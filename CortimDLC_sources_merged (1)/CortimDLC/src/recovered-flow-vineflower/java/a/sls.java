package a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public final class sls {
   private static final int slt = 4194304;
   private static final int slu = 48;
   private static final long slv = 20000L;
   private static final double slw = 15.0;
   private static final Pattern slx = Pattern.compile(
      "\\s*[(\\[][^)\\]]*(official|video|audio|lyric|visuali[sz]er|music|clip|клип|премьер|\\bhd\\b|\\b4k\\b|\\bmv\\b|m/v|remaster|prod\\.)[^)\\]]*[)\\]]", 258
   );
   private static final Pattern sly = Pattern.compile("\\s*[(\\[]?\\b(feat\\.?|ft\\.|featuring)\\s+[^)\\]]*[)\\]]?", 258);
   private static final Pattern slz = Pattern.compile("\\s*(,|&|;|/|\\bfeat\\.?|\\bft\\.)\\s*", 258);
   private static final ExecutorService sma = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "media-text");
      var1.setDaemon(true);
      return var1;
   });
   private static final Map<String, sle> smb = Collections.synchronizedMap(new LinkedHashMap<String, sle>(16, 0.75F, true) {
      @Override
      protected boolean removeEldestEntry(Entry<String, sle> var1) {
         return this.size() > 48;
      }
   });
   private static final Set<String> smc = ConcurrentHashMap.newKeySet();
   private static final Map<String, Long> smd = new ConcurrentHashMap<>();
   private static volatile HttpClient sme;

   private sls() {
   }

   public static sle get(String var0, String var1, long var2) {
      String var4 = var0 + '\u0001' + var1;
      sle var5 = smb.get(var4);
      if (var5 != null) {
         return var5;
      }

      Long var6 = smd.get(var4);
      if (var6 != null && System.currentTimeMillis() < var6) {
         return null;
      }

      if (smc.add(var4)) {
         sma.execute(() -> {
            try {
               smb.put(var4, smh(var0, var1, var2));
               smd.remove(var4);
            } catch (Throwable var9) {
               smd.put(var4, System.currentTimeMillis() + 20000L);
            } finally {
               smc.remove(var4);
            }
         });
      }

      return null;
   }

   private static sle smh(String var0, String var1, long var2) throws IOException, InterruptedException {
      String var4 = cleanTitle(var0);
      String var5 = plainArtist(var1);
      String var6 = cleanArtist(var1);
      ArrayList var7 = new ArrayList();
      if (!var5.isEmpty()) {
         var7.add(new String[]{var4, var5});
      }

      if (!var6.isEmpty() && !var6.equals(var5)) {
         var7.add(new String[]{var4, var6});
      }

      int var8 = sml(var4);
      if (var8 > 0) {
         String var9 = cleanArtist(var4.substring(0, var8));
         String var10 = cleanTitle(var4.substring(var8 + 3));
         if (!var9.isEmpty() && !var10.isEmpty()) {
            var7.add(new String[]{var10, var9});
         }
      }

      var7.add(new String[]{var6.isEmpty() ? var4 : var4 + " " + var6, null});
      IOException var16 = null;
      boolean var17 = false;

      for (String[] var12 : var7) {
         JsonArray var13;
         try {
            var13 = smi(var12[0], var12[1]);
            var17 = true;
         } catch (IOException var15) {
            var16 = var15;
            continue;
         }

         sle var14 = smj(var13, var12[1] != null ? var12[0] : var4, var12[1] != null ? var12[1] : var6, var2);
         if (var14 != null) {
            return var14;
         }
      }

      if (!var17 && var16 != null) {
         throw var16;
      } else {
         return sle.NONE;
      }
   }

   private static JsonArray smi(String var0, String var1) throws IOException, InterruptedException {
      String var2 = var1 != null ? "track_name=" + smq(var0) + "&artist_name=" + smq(var1) : "q=" + smq(var0);
      URI var3 = URI.create(smr() + "?" + var2);
      int var4 = 0;

      while (true) {
         HttpRequest var5 = HttpRequest.newBuilder(var3).timeout(Duration.ofSeconds(12L)).header("accept", "application/json").GET().build();
         HttpResponse var6 = sms().send(var5, BodyHandlers.ofInputStream());

         byte[] var7;
         try (InputStream var8 = (InputStream)var6.body()) {
            var7 = var8.readNBytes(4194304);
         }

         int var13 = var6.statusCode();
         if (var13 == 200) {
            JsonElement var9 = JsonParser.parseString(new String(var7, StandardCharsets.UTF_8));
            return var9.isJsonArray() ? var9.getAsJsonArray() : new JsonArray();
         }

         if (var13 == 404) {
            return new JsonArray();
         }

         if (var13 != 429 && var13 < 500 || var4 >= 3) {
            throw new IOException("status " + var13);
         }

         Thread.sleep(1500L * (var4 + 1));
         var4++;
      }
   }

   private static sle smj(JsonArray var0, String var1, String var2, long var3) {
      String var5 = smm(var1);
      String var6 = smm(var2);
      double var7 = Double.MAX_VALUE;
      JsonObject var9 = null;

      for (JsonElement var11 : var0) {
         if (var11.isJsonObject()) {
            JsonObject var12 = var11.getAsJsonObject();
            boolean var13 = smo(var12, "instrumental");
            String var14 = smn(var12, "syncedLyrics");
            if (var13 || !var14.isBlank()) {
               double var15 = 0.0;
               double var17 = smp(var12, "duration");
               if (var3 > 0L && var17 > 0.0) {
                  double var19 = Math.abs(var17 - var3 / 1000.0);
                  if (var19 > 15.0) {
                     continue;
                  }

                  var15 += var19;
               }

               var15 += smk(var5, smm(smn(var12, "trackName")), 3.0, 9.0);
               if (!var6.isEmpty()) {
                  var15 += smk(var6, smm(smn(var12, "artistName")), 2.0, 7.0);
               }

               if (var13) {
                  var15 += 4.0;
               }

               if (var15 < var7) {
                  var7 = var15;
                  var9 = var12;
               }
            }
         }
      }

      if (var9 == null) {
         return null;
      } else {
         return smo(var9, "instrumental") ? sle.NONE : sle.parse(smn(var9, "syncedLyrics"));
      }
   }

   private static double smk(String var0, String var1, double var2, double var4) {
      if (var0.isEmpty() || var1.isEmpty()) {
         return var2;
      } else if (var0.equals(var1)) {
         return 0.0;
      } else {
         return !var0.contains(var1) && !var1.contains(var0) ? var4 : var2;
      }
   }

   static String cleanTitle(String var0) {
      String var1 = slx.matcher(var0).replaceAll("");
      var1 = sly.matcher(var1).replaceAll("");
      int var2 = var1.indexOf(" | ");
      if (var2 > 0) {
         var1 = var1.substring(0, var2);
      }

      int var3 = var1.indexOf(" #");
      if (var3 > 0) {
         var1 = var1.substring(0, var3);
      }

      var1 = var1.replace('«', ' ').replace('»', ' ').replace('"', ' ').replace('“', ' ').replace('”', ' ');
      return var1.replaceAll("\\s+", " ").trim();
   }

   static String plainArtist(String var0) {
      return var0.replaceAll("(?i)\\s*-\\s*topic$", "").replaceAll("(?i)vevo$", "").replaceAll("(?i)\\s*official$", "").trim();
   }

   static String cleanArtist(String var0) {
      String var1 = plainArtist(var0);
      String[] var2 = slz.split(var1);

      for (String var6 : var2) {
         if (!var6.isBlank()) {
            return var6.trim();
         }
      }

      return var1;
   }

   private static int sml(String var0) {
      for (String var4 : new String[]{" - ", " – ", " — "}) {
         int var5 = var0.indexOf(var4);
         if (var5 > 0) {
            return var5;
         }
      }

      return -1;
   }

   private static String smm(String var0) {
      if (var0 == null) {
         return "";
      }

      StringBuilder var1 = new StringBuilder(var0.length());
      String var2 = var0.toLowerCase(Locale.ROOT).replace('ё', 'е');
      int var3 = 0;

      while (var3 < var2.length()) {
         int var4 = var2.codePointAt(var3);
         if (Character.isLetterOrDigit(var4)) {
            var1.appendCodePoint(var4);
         }

         var3 += Character.charCount(var4);
      }

      return var1.toString();
   }

   private static String smn(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && !var2.isJsonNull() ? var2.getAsString() : "";
   }

   private static boolean smo(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && !var2.isJsonNull() && var2.getAsBoolean();
   }

   private static double smp(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);

      try {
         return var2 != null && !var2.isJsonNull() ? var2.getAsDouble() : 0.0;
      } catch (RuntimeException var4) {
         return 0.0;
      }
   }

   private static String smq(String var0) {
      return URLEncoder.encode(var0, StandardCharsets.UTF_8);
   }

   private static String smr() {
      return new String(
         new char[]{
            'h', 't', 't', 'p', 's', ':', '/', '/', 'l', 'r', 'c', 'l', 'i', 'b', '.', 'n', 'e', 't', '/', 'a', 'p', 'i', '/', 's', 'e', 'a', 'r', 'c', 'h'
         }
      );
   }

   private static HttpClient sms() {
      HttpClient var0 = sme;
      if (var0 == null) {
         synchronized (sls.class) {
            var0 = sme;
            if (var0 == null) {
               var0 = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).followRedirects(Redirect.NORMAL).build();
               sme = var0;
            }
         }
      }

      return var0;
   }
}
