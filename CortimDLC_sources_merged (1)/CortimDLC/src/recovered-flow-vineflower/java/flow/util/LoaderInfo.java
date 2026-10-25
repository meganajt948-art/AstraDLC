package flow.util;

import java.lang.StackWalker.Option;
import java.lang.StackWalker.StackFrame;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public final class LoaderInfo {
   private static volatile Map<String, String> cache;
   private static final Set<String> API_HOSTS = Set.of(
      new String(
         new char[]{
            'f',
            'l',
            'o',
            'w',
            '2',
            '-',
            'a',
            'u',
            't',
            'h',
            '.',
            'f',
            'l',
            'o',
            'w',
            '-',
            'c',
            '0',
            'd',
            '8',
            '7',
            '.',
            'w',
            'o',
            'r',
            'k',
            'e',
            'r',
            's',
            '.',
            'd',
            'e',
            'v'
         }
      )
   );
   private static final Map<String, String> ALIAS = Map.of("login", "l", "uid", "u", "token", "t", "api", "a", "combo", "c", "enc_key", "k");

   private LoaderInfo() {
   }

   public static void boot() {
   }

   public static String login() {
      return "ProgrammData";
   }

   public static long uid() {
      return 0L;
   }

   public static String token() {
      return "";
   }

   public static String api() {
      return "";
   }

   public static String combo() {
      return null;
   }

   public static byte[] encKey() {
      return null;
   }

   private static void gateCaller() {
      Class<?> caller;
      try {
         caller = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(s -> s.skip(2L).findFirst().map(StackFrame::getDeclaringClass).orElse(null));
      } catch (Throwable var4) {
         return;
      }

      if (caller != null) {
         String cn = caller.getName();
         if (!cn.startsWith("flow.") && !cn.startsWith("a.") && !cn.startsWith("boot.")) {
            if (!cn.startsWith("java.") && !cn.startsWith("jdk.") && !cn.startsWith("sun.")) {
               if (!cn.startsWith("net.fabricmc") && !cn.startsWith("net.minecraft")) {
                  try {
                     Class<?> ic = Class.forName("flow.sec.Integrity");
                     ic.getMethod("tripFromCallerGate", String.class).invoke(null, cn);
                  } catch (Throwable var3) {
                  }

                  throw new SecurityException();
               }
            }
         }
      }
   }

   private static String str(String key) {
      Map<String, String> m = cache;
      if (m == null) {
         m = resolve();
         cache = m;
      }

      String v = m.get(key);
      return v == null ? "" : v;
   }

   private static Map<String, String> resolve() {
      Map<String, String> out = new HashMap<>();

      for (Entry<String, String> e : ALIAS.entrySet()) {
         String msKey = "_ms." + e.getValue();
         String legacyKey = "flow2." + e.getKey();
         String v = System.getProperty(msKey);
         if (v == null || v.isBlank()) {
            v = System.getProperty(legacyKey);
         }

         if (v != null && !v.isBlank()) {
            out.put(e.getKey(), v.trim());
         }

         try {
            System.clearProperty(msKey);
         } catch (Throwable var8) {
         }

         try {
            System.clearProperty(legacyKey);
         } catch (Throwable var7) {
         }
      }

      fromGuiIni(out);
      String api = out.get("api");
      if (api != null && !isTrustedApi(api)) {
         out.remove("api");
      }

      return out;
   }

   private static boolean isTrustedApi(String url) {
      if (url != null && url.length() <= 256) {
         try {
            URI uri = URI.create(url);
            if (!"https".equalsIgnoreCase(uri.getScheme())) {
               return false;
            } else {
               String host = uri.getHost();
               return host != null && API_HOSTS.contains(host.toLowerCase(Locale.ROOT));
            }
         } catch (Exception var3) {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void fromGuiIni(Map<String, String> out) {
      try {
         String appdata = System.getenv("APPDATA");
         if (appdata == null || appdata.isEmpty()) {
            return;
         }

         Path file = Paths.get(appdata, new String(new char[]{'F', 'l', 'o', 'w', 'C', 'l', 'i', 'e', 'n', 't'}), "gui.ini");
         if (!Files.isRegularFile(file)) {
            return;
         }

         for (String raw : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            String line = raw.trim();
            if (!line.isEmpty() && !line.startsWith("#") && !line.startsWith(";")) {
               int eq = line.indexOf(61);
               if (eq > 0) {
                  String key = line.substring(0, eq).trim().toLowerCase();
                  String value = line.substring(eq + 1).trim();
                  if (!value.isEmpty() && !out.containsKey(key)) {
                     if (key.equals("open_combo")) {
                        key = "combo";
                     }

                     if (key.equals("login") || key.equals("uid") || key.equals("token") || key.equals("api") || key.equals("combo") || key.equals("enc_key")) {
                        out.put(key, value);
                     }
                  }
               }
            }
         }
      } catch (Throwable var10) {
      }
   }
}
