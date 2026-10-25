package flow.config;

import a.dry;
import a.evy;
import a.ewk;
import a.kfe;
import a.vkl;
import a.vlj;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vmu;
import a.wap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.Flow;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

public final class ConfigManager {
   public static final vkl AUTO_SAVE = new vkl("Auto-save", true);
   public static final vkl LOAD_ON_START = new vkl("Load on start", true);
   private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   private static final int MAX_NAME = 32;
   private static String active;
   private static volatile int version;

   private ConfigManager() {
   }

   public static Path gameDir() {
      try {
         return FabricLoader.getInstance().getGameDir();
      } catch (Throwable t) {
         return MinecraftClient.getInstance().runDirectory.toPath();
      }
   }

   public static int version() {
      return version;
   }

   public static String active() {
      return active;
   }

   public static void setActive(String name) {
      active = name != null && !name.isBlank() ? name : null;
      version++;
   }

   public static String sanitize(String name) {
      if (name == null) {
         return null;
      }

      StringBuilder sb = new StringBuilder();
      name.codePoints().filter(c -> Character.isLetterOrDigit(c) || c == 32 || c == 45 || c == 95 || c == 46).forEach(sb::appendCodePoint);
      String s = sb.toString().trim();

      while (s.startsWith(".")) {
         s = s.substring(1).trim();
      }

      if (s.length() > 32) {
         s = s.substring(0, 32).trim();
      }

      return s.isEmpty() ? null : s;
   }

   public static boolean exists(String name) {
      return ewk.hasConfig(name);
   }

   public static List<ConfigManager.Info> list() {
      List<ConfigManager.Info> list = new ArrayList<>();

      for (Entry<String, evy> e : ewk.configs().entrySet()) {
         evy c = e.getValue();
         list.add(new ConfigManager.Info(e.getKey(), c.updated() * 1000L, c.enabled(), c.modules()));
      }

      list.sort(Comparator.comparingLong(ConfigManager.Info::modified).reversed());
      return list;
   }

   public static void save(String name) throws IOException {
      ewk.putConfig(name, json(), enabledCount(), moduleCount());
      setActive(name);
      ConfigShare.refresh(name);
   }

   static void addImported(String name, String data, int enabled, int modules) {
      ewk.putConfig(name, data, enabled, modules);
      version++;
   }

   private static int moduleCount() {
      return Flow.getInstance().getModuleManager().getModules().size();
   }

   private static int enabledCount() {
      int n = 0;

      for (kfe m : Flow.getInstance().getModuleManager().getModules()) {
         if (!m.isAction() && m.isEnabled()) {
            n++;
         }
      }

      return n;
   }

   private static String json() {
      JsonObject root = new JsonObject();
      root.addProperty("version", 1);
      root.addProperty("saved", System.currentTimeMillis());
      JsonObject mods = new JsonObject();

      for (kfe m : Flow.getInstance().getModuleManager().getModules()) {
         JsonObject o = new JsonObject();
         if (!m.isAction()) {
            o.addProperty("enabled", m.isEnabled());
         }

         o.addProperty("key", m.getKey());
         JsonObject settings = new JsonObject();

         for (vmo s : m.getSettings()) {
            if (s instanceof vkl b) {
               settings.addProperty(s.getName(), b.get());
            } else if (s instanceof vmc n) {
               settings.addProperty(s.getName(), n.get());
            } else if (s instanceof vlv mode) {
               settings.addProperty(s.getName(), mode.get());
            } else if (s instanceof vlq key) {
               settings.addProperty(s.getName(), key.get());
            } else if (s instanceof vmu text) {
               settings.addProperty(s.getName(), text.get());
            } else if (s instanceof vlj list) {
               JsonArray ids = new JsonArray();
               list.ids().forEach(ids::add);
               settings.add(s.getName(), ids);
            }
         }

         o.add("settings", settings);
         mods.add(m.getName(), o);
      }

      root.add("modules", mods);
      return GSON.toJson(root);
   }

   public static void load(String name) throws IOException {
      String raw = ewk.getConfig(name);
      if (raw == null) {
         throw new IOException(wap.s("no config ", "нет конфига ") + name);
      }

      byte[] fileBytes = raw.getBytes(StandardCharsets.UTF_8);

      JsonObject root;
      try (InputStreamReader r = new InputStreamReader(new ByteArrayInputStream(fileBytes), StandardCharsets.UTF_8)) {
         root = JsonParser.parseReader(r).getAsJsonObject();
      } finally {
         Arrays.fill(fileBytes, (byte)0);
      }

      JsonObject mods = root.getAsJsonObject("modules");
      if (mods == null) {
         throw new IOException(wap.s("no modules in ", "нет модулей в ") + name);
      }

      for (kfe m : Flow.getInstance().getModuleManager().getModules()) {
         JsonElement el = mods.get(m.getName());
         if (el != null && el.isJsonObject()) {
            JsonObject o = el.getAsJsonObject();
            JsonObject settings = o.getAsJsonObject("settings");
            if (settings != null) {
               for (vmo s : m.getSettings()) {
                  JsonElement v = settings.get(s.getName());
                  if (v != null) {
                     try {
                        if (s instanceof vkl b) {
                           b.set(v.getAsBoolean());
                        } else if (s instanceof vmc n) {
                           n.set(v.getAsDouble());
                        } else if (s instanceof vlv mode) {
                           mode.set(v.getAsString());
                        } else if (s instanceof vlq key) {
                           key.set(v.getAsInt());
                        } else if (s instanceof vmu text) {
                           text.set(v.getAsString());
                        } else if (s instanceof vlj list && v.isJsonArray()) {
                           List<String> ids = new ArrayList<>();
                           v.getAsJsonArray().forEach(e -> ids.add(e.getAsString()));
                           list.set(ids);
                        }
                     } catch (RuntimeException var25) {
                     }
                  }
               }
            }

            if (o.has("key")) {
               m.setKey(o.get("key").getAsInt());
            }

            m.onConfigLoaded(o.has("enabled"));
            if (o.has("enabled") && !m.isAction()) {
               m.setEnabled(o.get("enabled").getAsBoolean());
            }
         }
      }

      setActive(name);
   }

   public static void delete(String name) throws IOException {
      ewk.deleteConfig(name);
      ConfigShare.forget(name);
      if (name.equals(active)) {
         active = null;
      }

      version++;
   }

   public static void rename(String from, String to) throws IOException {
      if (!from.equals(to)) {
         if (exists(to)) {
            throw new IOException(wap.s("\"" + to + "\" already exists", "«" + to + "» уже есть"));
         }

         ewk.renameConfig(from, to);
         ConfigShare.forget(to);
         ConfigShare.renamed(from, to);
         if (from.equals(active)) {
            active = to;
         }

         version++;
      }
   }

   public static void autoSaveLater() {
      if (AUTO_SAVE.get() && active != null && !dry.armed()) {
         ewk.putConfig(active, json(), enabledCount(), moduleCount());
         version++;
         ConfigShare.refresh(active);
      }
   }

   public static void autoSave() {
      if (AUTO_SAVE.get() && active != null && !dry.armed()) {
         try {
            save(active);
         } catch (IOException e) {
            System.out.println("auto-save of " + active + " failed: " + e);
         }
      }
   }

   public record Info(String name, long modified, int enabled, int modules) {
   }
}
