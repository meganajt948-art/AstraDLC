package a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import flow.util.LoaderInfo;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class eyn {
   private static final int eyo = 33554432;
   private static HttpClient eyp;
   private static ExecutorService eyq;

   private eyn() {
   }

   public static boolean online() {
      ewk.ensureLoaded();
      return ewk.online();
   }

   private static synchronized void eyt() {
      if (eyq == null) {
         eyp = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
         eyq = Executors.newFixedThreadPool(2, var0 -> {
            Thread var1 = new Thread(var0, a.c(527543031, "ꪓ팭姽잖䱐쪨炸"));
            var1.setDaemon(true);
            var1.setPriority(1);
            return var1;
         });
      }
   }

   private static Builder eyu(String var0, int var1) {
      return HttpRequest.newBuilder(URI.create(ewk.endpoint() + var0))
         .timeout(Duration.ofSeconds(var1))
         .header(a.d("\ue484鴡៳覞Ɏ蓢㺪띈⤌ꎨ⑦\ude11僇", 1669155788, 1428664100), a.b("⚖开헗䮵쁵䛓ﳒ", -1834735917) + LoaderInfo.token())
         .header(a.c(-846022945, "뚡콅䗓\udbbd側훈"), eya.get());
   }

   private static <T> CompletableFuture<T> eyv(Callable<T> var0) {
      if (!online()) {
         return CompletableFuture.failedFuture(new IOException(a.c(278616441, "夑₩ꩺ㐁뿓㥥茽")));
      }

      eyt();
      return CompletableFuture.supplyAsync(() -> {
         try {
            return (T)var0.call();
         } catch (Exception var2) {
            throw new CompletionException(var2);
         }
      }, eyq);
   }

   public static CompletableFuture<List<eyg>> list(String var0) {
      return eyv(
         () -> {
            JsonObject var1 = new JsonObject();
            var1.addProperty(a.b("펪ꨙ⃝뺯㕷돗", -1980378148), var0 == null ? "" : var0);
            HttpRequest var2 = eyu(a.d("\ude05ꟺⴸ덐㣁븱ѩ趈Ꮠ饼ữ\ue4dd樏\uf3a4称", 1237169686, 645163059), 20)
               .header(a.d("㗘䱥욷壜팚喠\uefe9晁\uf847狻\uf521ཅ", -601345637, -311491540), a.b("\ue5e0鱀ᚓ裾̬薗㿆똢⡠ꋗ┅\udf35冧젏䉀쒰", 666232209))
               .POST(BodyPublishers.ofString(var1.toString(), StandardCharsets.UTF_8))
               .build();
            HttpResponse var3 = eyp.send(var2, BodyHandlers.ofByteArray());
            if (var3.statusCode() == 200 && ((byte[])var3.body()).length <= 4194304) {
               JsonObject var4 = JsonParser.parseString(new String((byte[])var3.body(), StandardCharsets.UTF_8)).getAsJsonObject();
               ArrayList var5 = new ArrayList();
               if (var4.has(a.d("쪨댄㧆ꞿⱶ", -853197632, 1864693252)) && var4.get(a.c(-2086874550, "툦ꮊⅈ뼱㓸")).isJsonArray()) {
                  for (JsonElement var7 : var4.getAsJsonArray(a.c(210030296, "캴뜘㷚ꎣ⡪"))) {
                     JsonObject var8 = var7.getAsJsonObject();
                     var5.add(
                        new eyg(
                           var8.get(a.c(-757718825, "₿夀폏")).getAsString(),
                           var8.get(a.d("磲ř讙ᗷ", 1902634188, -76309431)).getAsLong(),
                           var8.get(a.d("⍹嫍퀂买얩䌝累炿", -1635005759, 975169989)).getAsLong(),
                           parseMeta(
                              var8.has(a.d("\uece8镑ᾓ臷", 1193019393, 1039590528)) ? var8.get(a.d("葳\ufdca眈\ue96c", 616314835, -2131446839)).getAsString() : ""
                           )
                        )
                     );
                  }
               }

               return var5;
            } else {
               throw new IOException(a.d("ꙣ\udfd7唞쭨䃫", -32256427, 825845855) + var3.statusCode());
            }
         }
      );
   }

   public static CompletableFuture<byte[]> get(String var0) {
      return eyv(
         () -> {
            JsonObject var1 = new JsonObject();
            var1.addProperty(a.b("齇\ue6f8氷", -1934909649), var0);
            HttpRequest var2 = eyu(a.d("﵂蒽\u0e7f逗ᮆ鵶✮껏\u3097먻㶨작䥄탤", -771726234, -616392443), 120)
               .header(a.c(-645149043, "컢띟㶍ꏦ⠠꺚ᓓ鵻ͽ见ป\uf47f"), a.d("큋ꧫ⌸뵕㚇뀼੭莉᷋靼Ⴎ\uea9e搌ﶤ矫\uf11b", -563118819, 1153740071))
               .POST(BodyPublishers.ofString(var1.toString(), StandardCharsets.UTF_8))
               .build();
            HttpResponse var3 = eyp.send(var2, BodyHandlers.ofByteArray());
            if (var3.statusCode() != 200) {
               throw new IOException(a.c(1108902475, "舨ﮛ煙\uef7c") + var3.statusCode());
            } else if (((byte[])var3.body()).length > 33554432) {
               throw new IOException(a.c(-690311172, "꾁혫峸싆䥝쿡疡ﱅ战"));
            } else {
               byte[] var4 = exn.openBytes(a.c(1441751894, "挾᪄遇ั藻̟") + var0, (byte[])var3.body());
               if (var4 == null) {
                  throw new IOException(a.b("슧묀㇗꾫⑵ꋅ", 1684521682));
               } else {
                  return var4;
               }
            }
         }
      );
   }

   public static CompletableFuture<Boolean> put(String var0, byte[] var1, Map<String, String> var2) {
      return eyv(
         () -> {
            byte[] var3 = exn.sealBytes(a.c(-1327433137, "﨧莝फ़霨᳢騆") + var0, var1);
            if (var3 == null) {
               throw new IOException(a.b("䬲㊕롂☾", 230771525));
            } else {
               HttpRequest var4 = eyu(a.d("ꋡ\udb1e凜쾴䐥싕碍\uf16c漴\ue598戋頥ᛷ轇՟菺㦻뙶ⲁ", -2110089013, -411026922) + URLEncoder.encode(var0, StandardCharsets.UTF_8), 180)
                  .header(a.c(738725346, "ඍ琰ﻢ悉\ueb4f淵ힼ帔쀒䪮쵴㜐"), a.d("\u0df7瑗ﺄ惩\ueb3b涀ퟑ帵쁷䫀촒㜢릵 ꩌⲬ雲\u197a莗ׁ谰\uf676磁\ue31c", -983470750, 1241276652))
                  .header(
                     a.b("ꮂ퉦壵욌䵊쯮", 938191868),
                     URLEncoder.encode(meta(var2), StandardCharsets.UTF_8).replace(a.d("绳", 1518118432, -884352775), a.b("¬礊\uf3db", 1299841162))
                  )
                  .PUT(BodyPublishers.ofByteArray(var3))
                  .build();
               HttpResponse var5 = eyp.send(var4, BodyHandlers.ofString());
               if (var5.statusCode() != 200) {
                  throw new IOException(a.c(15853502, "\ue7ca鹾ᒬ誉") + var5.statusCode() + a.b("嬡", 997219072) + (String)var5.body());
               } else {
                  return true;
               }
            }
         }
      );
   }

   public static CompletableFuture<Boolean> delete(Collection<String> var0, String var1) {
      return eyv(
         () -> {
            JsonObject var2 = new JsonObject();
            JsonArray var3 = new JsonArray();
            if (var0 != null) {
               for (String var5 : var0) {
                  var3.add(var5);
               }
            }

            var2.add(a.d("惥ᥚ鎕෮", -374834285, -799466727), var3);
            if (var1 != null) {
               var2.addProperty(a.d("恗᧤錠\u0d52蚊*", -727031432, 538509657), var1);
            }

            HttpRequest var6 = eyu(a.b("ꥭ킒婐쐸侩쥙猁\ufae0撸\uee14榇鎽ᵫ蓓", -920802996), 30)
               .header(a.d("\uf570賍؟顴Ꮂ锈⽁ꛩ㣯뉓㖉쿭", 1347995745, 668614014), a.b("컹띙㶊ꏧ⠵꺎ᓟ鴻\u0379觎ผ\uf42c窾\ue316楙\uefa9", 673894024))
               .POST(BodyPublishers.ofString(var2.toString(), StandardCharsets.UTF_8))
               .build();
            return eyp.send(var6, BodyHandlers.discarding()).statusCode() == 200;
         }
      );
   }

   public static String meta(Map<String, String> var0) {
      StringBuilder var1 = new StringBuilder();
      if (var0 != null) {
         for (Entry var3 : var0.entrySet()) {
            if (var1.length() > 0) {
               var1.append(';');
            }

            var1.append(eyw((String)var3.getKey())).append('=').append(eyw((String)var3.getValue()));
         }
      }

      return var1.length() > 900 ? var1.substring(0, 900) : var1.toString();
   }

   private static String eyw(String var0) {
      return var0 == null ? "" : var0.replace(';', ',').replace('=', ':').replace('\n', ' ').replace('\r', ' ');
   }

   public static Map<String, String> parseMeta(String var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      if (var0 == null) {
         return var1;
      }

      for (String var5 : var0.split(a.d("뚮", -126428214, 878603614))) {
         int var6 = var5.indexOf(61);
         if (var6 > 0) {
            var1.put(var5.substring(0, var6), var5.substring(var6 + 1));
         }
      }

      return var1;
   }
}
