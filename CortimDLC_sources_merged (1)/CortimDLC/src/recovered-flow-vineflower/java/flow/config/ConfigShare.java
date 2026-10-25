package flow.config;

import a.evy;
import a.ewf;
import a.ewk;
import a.exn;
import a.wap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import net.minecraft.client.MinecraftClient;

public final class ConfigShare {
   private static final String ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
   private static final int LEN = 12;
   private static final byte[] SALT = "cfg-share/v1".getBytes(StandardCharsets.UTF_8);
   private static final int ITER = 60000;
   private static final String SLOT = "shares";
   private static final SecureRandom RNG = new SecureRandom();
   private static final Map<String, ConfigShare.Keys> KEYS = new ConcurrentHashMap<>();
   private static final Map<String, AtomicInteger> REFRESH = new ConcurrentHashMap<>();
   private static final Executor LATER = CompletableFuture.delayedExecutor(2L, TimeUnit.SECONDS);

   private ConfigShare() {
   }

   public static String normalize(String text) {
      if (text == null) {
         return null;
      }

      StringBuilder sb = new StringBuilder();

      for (char c : text.toUpperCase(Locale.ROOT).toCharArray()) {
         if (Character.isLetterOrDigit(c)) {
            sb.append(c);
         }
      }

      if (sb.length() != 12) {
         return null;
      }

      for (int i = 0; i < 12; i++) {
         if ("ABCDEFGHJKLMNPQRSTUVWXYZ23456789".indexOf(sb.charAt(i)) < 0) {
            return null;
         }
      }

      return sb.toString();
   }

   public static String pretty(String code) {
      return code == null ? null : code.substring(0, 4) + "-" + code.substring(4, 8) + "-" + code.substring(8);
   }

   public static String codeOf(String name) {
      return name == null ? null : pretty(map().get(name));
   }

   public static Map<String, String> codes() {
      Map<String, String> out = new LinkedHashMap<>();
      map().forEach((k, v) -> out.put(k, pretty(v)));
      return out;
   }

   private static Map<String, String> map() {
      Map<String, String> out = new LinkedHashMap<>();
      String raw = ewk.get("shares");
      if (raw != null && !raw.isBlank()) {
         try {
            for (Entry<String, JsonElement> e : JsonParser.parseString(raw).getAsJsonObject().entrySet()) {
               String code = e.getValue().isJsonPrimitive() ? normalize(e.getValue().getAsString()) : null;
               if (code != null) {
                  out.put(e.getKey(), code);
               }
            }
         } catch (RuntimeException var5) {
         }

         return out;
      } else {
         return out;
      }
   }

   private static void store(Map<String, String> map) {
      JsonObject o = new JsonObject();
      map.forEach(o::addProperty);
      ewk.put("shares", o.toString());
   }

   private static String newCode() {
      char[] c = new char[12];

      for (int i = 0; i < 12; i++) {
         c[i] = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(RNG.nextInt("ABCDEFGHJKLMNPQRSTUVWXYZ23456789".length()));
      }

      return new String(c);
   }

   private static ConfigShare.Keys keys(String code) {
      ConfigShare.Keys k = KEYS.get(code);
      if (k != null) {
         return k;
      }

      PBEKeySpec spec = new PBEKeySpec(code.toCharArray(), SALT, 60000, 384);

      try {
         byte[] out = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
         StringBuilder id = new StringBuilder();

         for (int i = 32; i < 48; i++) {
            id.append(Character.forDigit(out[i] >> 4 & 15, 16)).append(Character.forDigit(out[i] & 15, 16));
         }

         k = new ConfigShare.Keys(Arrays.copyOf(out, 32), id.toString());
         Arrays.fill(out, (byte)0);
         KEYS.put(code, k);
         return k;
      } catch (Exception e) {
         throw new CompletionException(new IOException("crypto"));
      } finally {
         spec.clearPassword();
      }
   }

   private static String aad(ConfigShare.Keys k) {
      return "share:" + k.id();
   }

   public static CompletableFuture<String> share(String name) {
      if (!ewk.online()) {
         return CompletableFuture.failedFuture(new IOException("offline"));
      }

      if (name.equals(ConfigManager.active())) {
         ConfigManager.autoSaveLater();
      }

      REFRESH.computeIfAbsent(name, k -> new AtomicInteger()).incrementAndGet();
      evy cfg = ewk.configs().get(name);
      if (cfg == null) {
         return CompletableFuture.failedFuture(new IOException("missing"));
      }

      String existing = map().get(name);
      String code = existing != null ? existing : newCode();
      return upload(code, name, cfg).thenApply(v -> {
         if (existing == null) {
            synchronized (ConfigShare.class) {
               Map<String, String> m = map();
               m.put(name, code);
               store(m);
            }
         }

         return pretty(code);
      });
   }

   private static CompletableFuture<Void> upload(String code, String name, evy cfg) {
      JsonObject payload = new JsonObject();
      payload.addProperty("v", 1);
      payload.addProperty("name", name);
      payload.addProperty("enabled", cfg.enabled());
      payload.addProperty("modules", cfg.modules());
      payload.addProperty("data", cfg.data());
      String text = payload.toString();
      return CompletableFuture.<JsonObject>supplyAsync(() -> {
         ConfigShare.Keys k = keys(code);
         String sealed = exn.sealWith(k.key(), aad(k), text);
         if (sealed == null) {
            throw new CompletionException(new IOException("crypto"));
         }

         JsonObject req = new JsonObject();
         req.addProperty("id", k.id());
         req.addProperty("data", sealed);
         return req;
      }).thenCompose(req -> ewk.call("/api/share/put", req)).thenApply(r -> {
         if (!r.ok()) {
            throw new CompletionException(new IOException(r.error()));
         } else {
            return null;
         }
      });
   }

   public static void refresh(String name) {
      if (name != null && ewk.online() && map().containsKey(name)) {
         AtomicInteger seq = REFRESH.computeIfAbsent(name, k -> new AtomicInteger());
         int mine = seq.incrementAndGet();
         CompletableFuture.runAsync(() -> {
            if (seq.get() == mine) {
               String code = map().get(name);
               evy cfg = ewk.configs().get(name);
               if (code != null && cfg != null) {
                  upload(code, name, cfg);
               }
            }
         }, LATER);
      }
   }

   public static CompletableFuture<ConfigShare.Imported> fetch(String text) {
      String code = normalize(text);
      if (code == null) {
         return CompletableFuture.failedFuture(new IOException("format"));
      }

      if (!ewk.online()) {
         return CompletableFuture.failedFuture(new IOException("offline"));
      }

      Executor main = MinecraftClient.getInstance();
      return CompletableFuture.<ConfigShare.Keys>supplyAsync(() -> keys(code)).thenCompose(k -> {
         JsonObject req = new JsonObject();
         req.addProperty("id", k.id());
         return ewk.call("/api/share/get", req).thenApply(r -> decode(k, r));
      }).thenApplyAsync(ConfigShare::add, main);
   }

   private static ConfigShare.Found decode(ConfigShare.Keys k, ewf r) {
      if (!r.ok()) {
         throw new CompletionException(new IOException(r.error()));
      }

      String sealed = r.body().has("data") ? r.body().get("data").getAsString() : null;
      String clear = exn.openWith(k.key(), aad(k), sealed);
      if (clear == null) {
         throw new CompletionException(new IOException("corrupt"));
      }

      try {
         JsonObject o = JsonParser.parseString(clear).getAsJsonObject();
         String data = o.get("data").getAsString();
         if (!JsonParser.parseString(data).getAsJsonObject().get("modules").isJsonObject()) {
            throw new IllegalStateException();
         }

         String name = o.has("name") ? ConfigManager.sanitize(o.get("name").getAsString()) : null;
         return new ConfigShare.Found(
            name == null ? "Config" : name, data, o.has("enabled") ? o.get("enabled").getAsInt() : 0, o.has("modules") ? o.get("modules").getAsInt() : 0
         );
      } catch (RuntimeException e) {
         throw new CompletionException(new IOException("corrupt"));
      }
   }

   private static ConfigShare.Imported add(ConfigShare.Found f) {
      for (Entry<String, evy> e : ewk.configs().entrySet()) {
         if (e.getValue().data().equals(f.data())) {
            return new ConfigShare.Imported(e.getKey(), true);
         }
      }

      String name = f.name();

      for (int i = 2; ConfigManager.exists(name); i++) {
         String suffix = " " + i;
         String base = f.name().length() + suffix.length() > 32 ? f.name().substring(0, 32 - suffix.length()).trim() : f.name();
         name = base + suffix;
      }

      ConfigManager.addImported(name, f.data(), f.enabled(), f.modules());
      return new ConfigShare.Imported(name, false);
   }

   public static void forget(String name) {
      String code;
      synchronized (ConfigShare.class) {
         Map<String, String> m = map();
         code = m.remove(name);
         if (code == null) {
            return;
         }

         store(m);
      }

      if (ewk.online()) {
         CompletableFuture.<ConfigShare.Keys>supplyAsync(() -> keys(code)).thenCompose(k -> {
            JsonObject req = new JsonObject();
            JsonArray ids = new JsonArray();
            ids.add(k.id());
            req.add("ids", ids);
            return ewk.call("/api/share/del", req);
         });
      }
   }

   public static void renamed(String from, String to) {
      synchronized (ConfigShare.class) {
         Map<String, String> m = map();
         String code = m.remove(from);
         if (code == null) {
            return;
         }

         m.put(to, code);
         store(m);
      }

      refresh(to);
   }

   public static String describe(Throwable t) {
      while (t instanceof CompletionException && t.getCause() != null) {
         t = t.getCause();
      }

      String m = t.getMessage() == null ? "" : t.getMessage();

      return switch (m) {
         case "format" -> wap.s("Codes look like ABCD-EFGH-JKMN", "Код выглядит как ABCD-EFGH-JKMN");
         case "offline" -> wap.s("No cloud: start the game through the loader", "Нет облака: запустите через лоадер");
         case "not_found" -> wap.s("No config with this code", "Конфига с таким кодом нет");
         case "rate_limited" -> wap.s("Too many tries, wait a few minutes", "Слишком много попыток, подождите пару минут");
         case "corrupt" -> wap.s("The config behind this code is damaged", "Конфиг по этому коду повреждён");
         case "missing" -> wap.s("Save the config first", "Сначала сохраните конфиг");
         case "unauthorized" -> wap.s("Cloud: log in through the loader again", "Облако: перезайдите в лоадер");
         case "hwid" -> wap.s("Cloud: HWID mismatch, reset it in the bot", "Облако: HWID не совпал, сбросьте в боте");
         case "too_large", "bad_request" -> wap.s("The config is too big to share", "Конфиг слишком большой");
         default -> wap.s("No connection to the cloud", "Нет связи с облаком");
      };
   }

   private record Found(String name, String data, int enabled, int modules) {
   }

   public record Imported(String name, boolean existed) {
   }

   private record Keys(byte[] key, String id) {
   }
}
