/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.class_310
 */
package flow.config;

import a.evy;
import a.ewf;
import a.CloudSync;
import a.AesGcmBox;
import a.Lang;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.config.ConfigManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import net.minecraft.class_310;

public final class ConfigShare {
    private static final String ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final int LEN = 12;
    private static final byte[] SALT = "cfg-share/v1".getBytes(StandardCharsets.UTF_8);
    private static final int ITER = 60000;
    private static final String SLOT = "shares";
    private static final SecureRandom RNG = new SecureRandom();
    private static final Map<String, Keys> KEYS = new ConcurrentHashMap<String, Keys>();
    private static final Map<String, AtomicInteger> REFRESH = new ConcurrentHashMap<String, AtomicInteger>();
    private static final Executor LATER = CompletableFuture.delayedExecutor(2L, TimeUnit.SECONDS);

    private ConfigShare() {
    }

    public static String normalize(String text) {
        if (text == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : text.toUpperCase(Locale.ROOT).toCharArray()) {
            if (!Character.isLetterOrDigit(c)) continue;
            sb.append(c);
        }
        if (sb.length() != 12) {
            return null;
        }
        for (int i = 0; i < 12; ++i) {
            if (ALPHABET.indexOf(sb.charAt(i)) >= 0) continue;
            return null;
        }
        return sb.toString();
    }

    public static String pretty(String code) {
        return code == null ? null : code.substring(0, 4) + "-" + code.substring(4, 8) + "-" + code.substring(8);
    }

    public static String codeOf(String name) {
        return name == null ? null : ConfigShare.pretty(ConfigShare.map().get(name));
    }

    public static Map<String, String> codes() {
        LinkedHashMap<String, String> out = new LinkedHashMap<String, String>();
        ConfigShare.map().forEach((k, v) -> out.put((String)k, ConfigShare.pretty(v)));
        return out;
    }

    private static Map<String, String> map() {
        LinkedHashMap<String, String> out = new LinkedHashMap<String, String>();
        String raw = CloudSync.get(SLOT);
        if (raw == null || raw.isBlank()) {
            return out;
        }
        try {
            for (Map.Entry e : JsonParser.parseString((String)raw).getAsJsonObject().entrySet()) {
                String code = ((JsonElement)e.getValue()).isJsonPrimitive() ? ConfigShare.normalize(((JsonElement)e.getValue()).getAsString()) : null;
                if (code == null) continue;
                out.put((String)e.getKey(), code);
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return out;
    }

    private static void store(Map<String, String> map) {
        JsonObject o = new JsonObject();
        map.forEach((arg_0, arg_1) -> ((JsonObject)o).addProperty(arg_0, arg_1));
        CloudSync.put(SLOT, o.toString());
    }

    private static String newCode() {
        char[] c = new char[12];
        for (int i = 0; i < 12; ++i) {
            c[i] = ALPHABET.charAt(RNG.nextInt(ALPHABET.length()));
        }
        return new String(c);
    }

    private static Keys keys(String code) {
        Keys k = KEYS.get(code);
        if (k != null) {
            return k;
        }
        PBEKeySpec spec = new PBEKeySpec(code.toCharArray(), SALT, 60000, 384);
        try {
            byte[] out = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
            StringBuilder id = new StringBuilder();
            for (int i = 32; i < 48; ++i) {
                id.append(Character.forDigit(out[i] >> 4 & 0xF, 16)).append(Character.forDigit(out[i] & 0xF, 16));
            }
            k = new Keys(Arrays.copyOf(out, 32), id.toString());
            Arrays.fill(out, (byte)0);
            KEYS.put(code, k);
            Keys keys = k;
            return keys;
        }
        catch (Exception e) {
            throw new CompletionException(new IOException("crypto"));
        }
        finally {
            spec.clearPassword();
        }
    }

    private static String aad(Keys k) {
        return "share:" + k.id();
    }

    public static CompletableFuture<String> share(String name) {
        if (!CloudSync.online()) {
            return CompletableFuture.failedFuture(new IOException("offline"));
        }
        if (name.equals(ConfigManager.active())) {
            ConfigManager.autoSaveLater();
        }
        REFRESH.computeIfAbsent(name, k -> new AtomicInteger()).incrementAndGet();
        evy cfg = CloudSync.configs().get(name);
        if (cfg == null) {
            return CompletableFuture.failedFuture(new IOException("missing"));
        }
        String existing = ConfigShare.map().get(name);
        String code = existing != null ? existing : ConfigShare.newCode();
        return ConfigShare.upload(code, name, cfg).thenApply(v -> {
            if (existing != null) return ConfigShare.pretty(code);
            Class<ConfigShare> clazz = ConfigShare.class;
            synchronized (ConfigShare.class) {
                Map<String, String> m = ConfigShare.map();
                m.put(name, code);
                ConfigShare.store(m);
                // ** MonitorExit[var4_4] (shouldn't be in output)
                return ConfigShare.pretty(code);
            }
        });
    }

    private static CompletableFuture<Void> upload(String code, String name, evy cfg) {
        JsonObject payload = new JsonObject();
        payload.addProperty("v", (Number)1);
        payload.addProperty("name", name);
        payload.addProperty("enabled", (Number)cfg.enabled());
        payload.addProperty("modules", (Number)cfg.modules());
        payload.addProperty("data", cfg.data());
        String text = payload.toString();
        return ((CompletableFuture)CompletableFuture.supplyAsync(() -> {
            Keys k = ConfigShare.keys(code);
            String sealed = AesGcmBox.sealWith(k.key(), ConfigShare.aad(k), text);
            if (sealed == null) {
                throw new CompletionException(new IOException("crypto"));
            }
            JsonObject req = new JsonObject();
            req.addProperty("id", k.id());
            req.addProperty("data", sealed);
            return req;
        }).thenCompose(req -> CloudSync.call("/api/share/put", req))).thenApply(r -> {
            if (!r.ok()) {
                throw new CompletionException(new IOException(r.error()));
            }
            return null;
        });
    }

    public static void refresh(String name) {
        if (name == null || !CloudSync.online() || !ConfigShare.map().containsKey(name)) {
            return;
        }
        AtomicInteger seq = REFRESH.computeIfAbsent(name, k -> new AtomicInteger());
        int mine = seq.incrementAndGet();
        CompletableFuture.runAsync(() -> {
            if (seq.get() != mine) {
                return;
            }
            String code = ConfigShare.map().get(name);
            evy cfg = CloudSync.configs().get(name);
            if (code != null && cfg != null) {
                ConfigShare.upload(code, name, cfg);
            }
        }, LATER);
    }

    public static CompletableFuture<Imported> fetch(String text) {
        String code = ConfigShare.normalize(text);
        if (code == null) {
            return CompletableFuture.failedFuture(new IOException("format"));
        }
        if (!CloudSync.online()) {
            return CompletableFuture.failedFuture(new IOException("offline"));
        }
        class_310 main = class_310.method_1551();
        return ((CompletableFuture)CompletableFuture.supplyAsync(() -> ConfigShare.keys(code)).thenCompose(k -> {
            JsonObject req = new JsonObject();
            req.addProperty("id", k.id());
            return CloudSync.call("/api/share/get", req).thenApply(r -> ConfigShare.decode(k, r));
        })).thenApplyAsync(ConfigShare::add, (Executor)main);
    }

    private static Found decode(Keys k, ewf r) {
        if (!r.ok()) {
            throw new CompletionException(new IOException(r.error()));
        }
        String sealed = r.body().has("data") ? r.body().get("data").getAsString() : null;
        String clear = AesGcmBox.openWith(k.key(), ConfigShare.aad(k), sealed);
        if (clear == null) {
            throw new CompletionException(new IOException("corrupt"));
        }
        try {
            JsonObject o = JsonParser.parseString((String)clear).getAsJsonObject();
            String data = o.get("data").getAsString();
            if (!JsonParser.parseString((String)data).getAsJsonObject().get("modules").isJsonObject()) {
                throw new IllegalStateException();
            }
            String name = o.has("name") ? ConfigManager.sanitize(o.get("name").getAsString()) : null;
            return new Found(name == null ? "Config" : name, data, o.has("enabled") ? o.get("enabled").getAsInt() : 0, o.has("modules") ? o.get("modules").getAsInt() : 0);
        }
        catch (RuntimeException e) {
            throw new CompletionException(new IOException("corrupt"));
        }
    }

    private static Imported add(Found f) {
        for (Map.Entry<String, evy> e : CloudSync.configs().entrySet()) {
            if (!e.getValue().data().equals(f.data())) continue;
            return new Imported(e.getKey(), true);
        }
        String name = f.name();
        int i = 2;
        while (ConfigManager.exists(name)) {
            String suffix = " " + i;
            String base = f.name().length() + suffix.length() > 32 ? f.name().substring(0, 32 - suffix.length()).trim() : f.name();
            name = base + suffix;
            ++i;
        }
        ConfigManager.addImported(name, f.data(), f.enabled(), f.modules());
        return new Imported(name, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void forget(String name) {
        Class<ConfigShare> clazz = ConfigShare.class;
        synchronized (ConfigShare.class) {
            Map<String, String> m = ConfigShare.map();
            String code = m.remove(name);
            if (code == null) {
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return;
            }
            ConfigShare.store(m);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            if (!CloudSync.online()) {
                return;
            }
            CompletableFuture.supplyAsync(() -> ConfigShare.keys(code)).thenCompose(k -> {
                JsonObject req = new JsonObject();
                JsonArray ids = new JsonArray();
                ids.add(k.id());
                req.add("ids", (JsonElement)ids);
                return CloudSync.call("/api/share/del", req);
            });
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void renamed(String from, String to) {
        Class<ConfigShare> clazz = ConfigShare.class;
        synchronized (ConfigShare.class) {
            Map<String, String> m = ConfigShare.map();
            String code = m.remove(from);
            if (code == null) {
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return;
            }
            m.put(to, code);
            ConfigShare.store(m);
            // ** MonitorExit[var2_2] (shouldn't be in output)
            ConfigShare.refresh(to);
            return;
        }
    }

    public static String describe(Throwable t) {
        String m;
        while (t instanceof CompletionException && t.getCause() != null) {
            t = t.getCause();
        }
        return switch (m = t.getMessage() == null ? "" : t.getMessage()) {
            case "format" -> Lang.s("Codes look like ABCD-EFGH-JKMN", "\u041a\u043e\u0434 \u0432\u044b\u0433\u043b\u044f\u0434\u0438\u0442 \u043a\u0430\u043a ABCD-EFGH-JKMN");
            case "offline" -> Lang.s("No cloud: start the game through the loader", "\u041d\u0435\u0442 \u043e\u0431\u043b\u0430\u043a\u0430: \u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u0435 \u0447\u0435\u0440\u0435\u0437 \u043b\u043e\u0430\u0434\u0435\u0440");
            case "not_found" -> Lang.s("No config with this code", "\u041a\u043e\u043d\u0444\u0438\u0433\u0430 \u0441 \u0442\u0430\u043a\u0438\u043c \u043a\u043e\u0434\u043e\u043c \u043d\u0435\u0442");
            case "rate_limited" -> Lang.s("Too many tries, wait a few minutes", "\u0421\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u043d\u043e\u0433\u043e \u043f\u043e\u043f\u044b\u0442\u043e\u043a, \u043f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435 \u043f\u0430\u0440\u0443 \u043c\u0438\u043d\u0443\u0442");
            case "corrupt" -> Lang.s("The config behind this code is damaged", "\u041a\u043e\u043d\u0444\u0438\u0433 \u043f\u043e \u044d\u0442\u043e\u043c\u0443 \u043a\u043e\u0434\u0443 \u043f\u043e\u0432\u0440\u0435\u0436\u0434\u0451\u043d");
            case "missing" -> Lang.s("Save the config first", "\u0421\u043d\u0430\u0447\u0430\u043b\u0430 \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u0435 \u043a\u043e\u043d\u0444\u0438\u0433");
            case "unauthorized" -> Lang.s("Cloud: log in through the loader again", "\u041e\u0431\u043b\u0430\u043a\u043e: \u043f\u0435\u0440\u0435\u0437\u0430\u0439\u0434\u0438\u0442\u0435 \u0432 \u043b\u043e\u0430\u0434\u0435\u0440");
            case "hwid" -> Lang.s("Cloud: HWID mismatch, reset it in the bot", "\u041e\u0431\u043b\u0430\u043a\u043e: HWID \u043d\u0435 \u0441\u043e\u0432\u043f\u0430\u043b, \u0441\u0431\u0440\u043e\u0441\u044c\u0442\u0435 \u0432 \u0431\u043e\u0442\u0435");
            case "too_large", "bad_request" -> Lang.s("The config is too big to share", "\u041a\u043e\u043d\u0444\u0438\u0433 \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u0431\u043e\u043b\u044c\u0448\u043e\u0439");
            default -> Lang.s("No connection to the cloud", "\u041d\u0435\u0442 \u0441\u0432\u044f\u0437\u0438 \u0441 \u043e\u0431\u043b\u0430\u043a\u043e\u043c");
        };
    }

    private record Keys(byte[] key, String id) {
    }

    private record Found(String name, String data, int enabled, int modules) {
    }

    public record Imported(String name, boolean existed) {
    }
}

