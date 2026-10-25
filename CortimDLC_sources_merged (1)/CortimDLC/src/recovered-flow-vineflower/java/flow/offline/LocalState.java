package flow.offline;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public final class LocalState {
   private static boolean ready;
   private static Map<String, String> slots;
   private static Map<String, Object> configs;
   private static Class<?> configType;
   private static Path file;

   private LocalState() {
   }

   private static String encode(String s) {
      return Base64.getUrlEncoder().withoutPadding().encodeToString(s.getBytes(StandardCharsets.UTF_8));
   }

   private static String decode(String s) {
      return new String(Base64.getUrlDecoder().decode(s), StandardCharsets.UTF_8);
   }

   public static synchronized void init() {
      if (!ready) {
         ready = true;

         try {
            ClassLoader loader = LocalState.class.getClassLoader();
            Class<?> cloud = Class.forName("a.ewk", false, loader);
            Field sf = cloud.getDeclaredField("ewo");
            Field cf = cloud.getDeclaredField("ewp");
            sf.setAccessible(true);
            cf.setAccessible(true);
            slots = (Map<String, String>)sf.get(null);
            configs = (Map<String, Object>)cf.get(null);
            configType = Class.forName("a.evy", false, loader);
            Path game = Path.of(System.getProperty("user.dir"));

            try {
               Class<?> fabric = Class.forName("net.fabricmc.loader.api.FabricLoader");
               Object instance = fabric.getMethod("getInstance").invoke(null);
               game = (Path)fabric.getMethod("getGameDir").invoke(instance);
            } catch (ReflectiveOperationException var11) {
            }

            file = game.resolve("config").resolve("flow2-offline").resolve("state.properties");
            if (Files.isRegularFile(file)) {
               Properties p = new Properties();

               try (Reader r = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                  p.load(r);
               }

               Constructor<?> ctor = configType.getConstructor(String.class, int.class, int.class, long.class);

               for (String key : p.stringPropertyNames()) {
                  if (key.startsWith("slot.")) {
                     slots.put(decode(key.substring(5)), p.getProperty(key));
                  } else if (key.startsWith("config.") && key.endsWith(".data")) {
                     String prefix = key.substring(0, key.length() - 5);
                     configs.put(
                        decode(prefix.substring(7)),
                        ctor.newInstance(
                           p.getProperty(key),
                           Integer.parseInt(p.getProperty(prefix + ".enabled", "0")),
                           Integer.parseInt(p.getProperty(prefix + ".modules", "0")),
                           Long.parseLong(p.getProperty(prefix + ".updated", "0"))
                        )
                     );
                  }
               }
            }

            Runtime.getRuntime().addShutdownHook(new Thread(LocalState::save, "Flow2 local save"));
         } catch (Exception var13) {
            System.err.println("[Flow2] Local settings: " + var13);
         }
      }
   }

   public static synchronized void save() {
      if (ready && file != null && slots != null && configs != null) {
         try {
            Properties p = new Properties();
            slots.forEach((key, valuex) -> p.setProperty("slot." + encode(key), valuex));

            for (Entry<String, Object> e : configs.entrySet()) {
               String prefix = "config." + encode(e.getKey());
               Object value = e.getValue();

               for (String field : List.of("data", "enabled", "modules", "updated")) {
                  p.setProperty(prefix + "." + field, String.valueOf(configType.getMethod(field).invoke(value)));
               }
            }

            Files.createDirectories(file.getParent());
            Path temp = file.resolveSibling("state.properties.tmp");

            try (Writer writer = Files.newBufferedWriter(temp, StandardCharsets.UTF_8)) {
               p.store(writer, "Flow2 local settings");
            }

            try {
               Files.move(temp, file, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException var8) {
               Files.move(temp, file, StandardCopyOption.REPLACE_EXISTING);
            }
         } catch (Exception var10) {
            System.err.println("[Flow2] Could not save local settings: " + var10);
         }
      }
   }
}
