package a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import flow.offline.LocalState;
import flow.util.LoaderInfo;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class ewk {
   private static final String ewl = new String(
      new char[]{
         'h',
         't',
         't',
         'p',
         's',
         ':',
         '/',
         '/',
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
   );
   private static final long ewm = 5000L;
   private static final long ewn = 1500L;
   private static final Map<String, String> ewo = new ConcurrentHashMap<>();
   private static final Map<String, evy> ewp = new ConcurrentHashMap<>();
   private static final Set<String> ewq = new HashSet<>();
   private static final Set<String> ewr = new HashSet<>();
   private static final Set<String> ews = new HashSet<>();
   private static final Object ewt = new Object();
   private static volatile boolean ewu;
   private static volatile boolean ewv;
   private static final CountDownLatch eww = new CountDownLatch(1);
   private static HttpClient ewx;
   private static ScheduledExecutorService ewy;
   private static ScheduledFuture<?> ewz;
   private static volatile int exa;
   private static volatile long exb;

   private ewk() {
   }

   private static String exe() {
      String var0 = LoaderInfo.api();
      if (var0 != null && !var0.isBlank()) {
         var0 = var0.trim();
         return var0.endsWith(a.c(-1959158928, "魞")) ? var0.substring(0, var0.length() - 1) : var0;
      } else {
         return ewl;
      }
   }

   static String endpoint() {
      return exe();
   }

   public static synchronized void init() {
      if (ewu) {
         LocalState.init();
      } else {
         ewu = true;
         String var0 = LoaderInfo.token();
         ewv = var0 != null && !var0.isBlank();
         if (!ewv) {
            eww.countDown();
            LocalState.init();
         } else {
            ewx = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(6L)).build();
            ewy = Executors.newSingleThreadScheduledExecutor(var0x -> {
               Thread var1 = new Thread(var0x, a.d("㑩䷲윢奋틙呺\uee6a枔杻獣\uf4a1", -288422410, 846541266));
               var1.setDaemon(true);
               return var1;
            });
            ewy.execute(ewk::exf);
            LocalState.init();
         }
      }
   }

   public static boolean online() {
      return ewv;
   }

   public static void ensureLoaded() {
      if (!ewu) {
         init();
      }

      try {
         eww.await(5000L, TimeUnit.MILLISECONDS);
      } catch (InterruptedException var1) {
         Thread.currentThread().interrupt();
      }
   }

   private static void exf() {
      try {
         HttpRequest var0 = HttpRequest.newBuilder(URI.create(exe() + a.b("\ue7d6鸩ᓫ誃Ē蟨㶾둚⨐ꃯ❣\udd17叙쩨", 1851647991)))
            .timeout(Duration.ofSeconds(8L))
            .header(a.d("\uebad鈈ᣚ蚷൧诋ㆃ롡☥겁⭏털忮", 1754081090, -1202926461), a.d("掶ᨠ郷ຕ蕕ϳ맲", -921926319, -889002334) + LoaderInfo.token())
            .header(a.b("ｩ蛔ఆ鉭ᦫ鼑╘곰㋶롊㾐열", 881327878), a.d("劫⬋ꇘ㾵둧㋜袍ũ鼫ᖜ鉎桾\ue6ec罄\uf50b珻", -1721122490, -426077284))
            .header(a.b("륷삓䨅푫徢\ud91e", 66697481), eya.get())
            .POST(BodyPublishers.ofString(a.b("ﱳ藄", 1139145738)))
            .build();
         HttpResponse var1 = ewx.send(var0, BodyHandlers.ofByteArray());
         if (var1.statusCode() != 200) {
            exm(var1.statusCode());
            return;
         }

         if (((byte[])var1.body()).length <= 8388608) {
            JsonObject var2 = JsonParser.parseString(new String((byte[])var1.body(), StandardCharsets.UTF_8)).getAsJsonObject();
            if (var2.has(a.b("뚬켂䗒\udbb8偨", -1280657702)) && var2.get(a.c(431515312, "曆Ὠ閸\u0bd2耂")).isJsonObject()) {
               for (Entry var4 : var2.getAsJsonObject(a.d("쮰눞㣎ꚤ\u2d74", 1197382561, 719933543)).entrySet()) {
                  if (((JsonElement)var4.getValue()).isJsonPrimitive() && !exg((String)var4.getKey())) {
                     String var5 = exn.open(a.c(439022201, "\uf20f计ű鼛ᒂ") + (String)var4.getKey(), ((JsonElement)var4.getValue()).getAsString());
                     if (var5 != null) {
                        ewo.put((String)var4.getKey(), var5);
                     }
                  }
               }
            }

            if (var2.has(a.c(-1185447159, "荭𢡄瀂\uee7b斣\ue31c奛")) && var2.get(a.b("⁵姈팚䵣욻䀄暑", 1419386897)).isJsonObject()) {
               for (Entry var13 : var2.getAsJsonObject(a.c(-184772066, "驺\ue3c7椕\uf76c粴廓䁌")).entrySet()) {
                  if (!exh((String)var13.getKey()) && ((JsonElement)var13.getValue()).isJsonObject()) {
                     JsonObject var14 = ((JsonElement)var13.getValue()).getAsJsonObject();
                     String var6 = exn.open(
                        a.d("\uf423趞\u074c餵ይ鑒⹜", 1316211507, 373047156) + (String)var13.getKey(),
                        var14.has(a.d("\ue3a5騑თ躳", 1694103458, 127603815)) ? var14.get(a.c(-1629606079, "⼡嚕\udc53䈷")).getAsString() : ""
                     );
                     if (var6 != null) {
                        ewp.put(
                           (String)var13.getKey(),
                           new evy(
                              var6,
                              var14.has(a.d("Ḿ构\ued58猪\uf8f3繋쐙", 1226093598, 1498327618)) ? var14.get(a.c(-910560547, "\uf2bf謅Ǚ龫ᑲ鋊⢘")).getAsInt() : 0,
                              var14.has(a.d("\ueb93鈠\u18f8蚘ൖ诮ㆫ", -1812808388, 1433294533)) ? var14.get(a.b("\u197f惌\uea14瑴ﾺ礂썇", 1739528469)).getAsInt() : 0,
                              var14.has(a.b("Ѿ緊\uf70d楹\ue2bb搛\ude49", -22281204)) ? var14.get(a.c(-1275027440, "ꁢ\ud9d6匑쵥䚧쀇穕")).getAsLong() : 0L
                           )
                        );
                     }
                  }
               }
            }

            return;
         }
      } catch (Exception var10) {
         return;
      } finally {
         eww.countDown();
      }
   }

   private static boolean exg(String var0) {
      synchronized (ewt) {
         return ewq.contains(var0);
      }
   }

   private static boolean exh(String var0) {
      synchronized (ewt) {
         return ewr.contains(var0) || ews.contains(var0);
      }
   }

   public static String get(String var0) {
      ensureLoaded();
      return ewo.get(var0);
   }

   public static void put(String var0, String var1) {
      ewo.put(var0, var1);
      if (!ewv) {
         LocalState.save();
      } else {
         synchronized (ewt) {
            ewq.add(var0);
            exi();
         }

         LocalState.save();
      }
   }

   public static void putAlone(String var0, String var1) {
      ewo.put(var0, var1);
      if (ewv && ewy != null) {
         ewy.execute(
            () -> {
               String var2 = exn.seal(a.d("苇ﭩ熹\uefd3摊", -1074421833, -1157620474) + var0, var1);
               if (var2 != null) {
                  JsonObject var3 = new JsonObject();
                  var3.addProperty(var0, var2);
                  JsonObject var4 = new JsonObject();
                  var4.add(a.c(-875142907, "慳ᣝ鈍౧螷"), var3);

                  try {
                     HttpRequest var5 = HttpRequest.newBuilder(URI.create(exe() + a.c(-92669599, "鹿肿\u0a7d鐕ᾄ饾⌨\uaacc㒆빹㧵쎁䵐퓺")))
                        .timeout(Duration.ofSeconds(20L))
                        .header(a.d("꼩회属숳䧣콏甇ﳥ抡\ue805濋閼᭪", 1962397008, 374694421), a.b("⨻厭\ud97a䜘쳘䩾\uf07f", 960375422) + LoaderInfo.token())
                        .header(a.c(-329410554, "顩\ue1d4欆\uf56d纫\uf811䉘쯰嗶\udf4a墐ꋴ"), a.c(623456749, "㆜䠼싯岂흐凫\uebba扞ﰜ皫\uf179\u0b49藛ᱳ阼\u10cc"))
                        .header(a.d("ꉏ\udbab儽콓䒚숦", 515674112, -1723321807), eya.get())
                        .POST(BodyPublishers.ofString(var4.toString(), StandardCharsets.UTF_8))
                        .build();
                     exm(ewx.send(var5, BodyHandlers.discarding()).statusCode());
                  } catch (Exception var6) {
                  }
               }
            }
         );
         LocalState.save();
      } else {
         LocalState.save();
      }
   }

   public static long sizeOf(String var0) {
      ensureLoaded();
      long var1 = 0L;

      for (Entry var4 : ewo.entrySet()) {
         if (((String)var4.getKey()).startsWith(var0)) {
            var1 += ((String)var4.getValue()).length();
         }
      }

      return var1;
   }

   public static byte[] getBytes(String var0) {
      String var1 = get(var0);
      if (var1 == null) {
         return null;
      }

      try {
         return Base64.getDecoder().decode(var1.trim());
      } catch (RuntimeException var3) {
         return null;
      }
   }

   public static void putBytes(String var0, byte[] var1) {
      put(var0, Base64.getEncoder().encodeToString(var1));
   }

   public static Set<String> configNames() {
      ensureLoaded();
      return new TreeSet<>(ewp.keySet());
   }

   public static Map<String, evy> configs() {
      ensureLoaded();
      return Map.copyOf(ewp);
   }

   public static boolean hasConfig(String var0) {
      ensureLoaded();
      return var0 != null && ewp.containsKey(var0);
   }

   public static String getConfig(String var0) {
      ensureLoaded();
      evy var1 = ewp.get(var0);
      return var1 == null ? null : var1.data();
   }

   public static void putConfig(String var0, String var1, int var2, int var3) {
      ewp.put(var0, new evy(var1, var2, var3, System.currentTimeMillis() / 1000L));
      if (!ewv) {
         LocalState.save();
      } else {
         synchronized (ewt) {
            ewr.add(var0);
            ews.remove(var0);
            exi();
         }

         LocalState.save();
      }
   }

   public static void deleteConfig(String var0) {
      ewp.remove(var0);
      if (!ewv) {
         LocalState.save();
      } else {
         synchronized (ewt) {
            ewr.remove(var0);
            ews.add(var0);
            exi();
         }

         LocalState.save();
      }
   }

   public static void renameConfig(String var0, String var1) {
      evy var2 = ewp.remove(var0);
      if (var2 == null) {
         LocalState.save();
      } else {
         ewp.put(var1, new evy(var2.data(), var2.enabled(), var2.modules(), System.currentTimeMillis() / 1000L));
         if (!ewv) {
            LocalState.save();
         } else {
            synchronized (ewt) {
               ewr.add(var1);
               ewr.remove(var0);
               ews.add(var0);
               ews.remove(var1);
               exi();
            }

            LocalState.save();
         }
      }
   }

   private static void exi() {
      if (ewy != null) {
         if (ewz != null) {
            ewz.cancel(false);
         }

         ewz = ewy.schedule(ewk::exj, 1500L, TimeUnit.MILLISECONDS);
      }
   }

   private static void exj() {
      JsonObject var0;
      synchronized (ewt) {
         if (ewq.isEmpty() && ewr.isEmpty() && ews.isEmpty()) {
            return;
         }

         var0 = exl();
         ewq.clear();
         ewr.clear();
         ews.clear();
      }

      try {
         HttpRequest var5 = HttpRequest.newBuilder(URI.create(exe() + a.c(895331111, "ꬆ틹堻왓䷂쬸煮\uf88a曀\uec3f殳采\u1f16蚼")))
            .timeout(Duration.ofSeconds(10L))
            .header(a.d("䷻㑞뺌⃡ꬱ\u2d9d韕ḷ聳\u0ad7贙睮隸", 348207528, -1436715969), a.c(-1442955409, "㼪䚼챫刉\ud9c9彯\ue56e") + LoaderInfo.token())
            .header(a.d("唽ⲀꙒ㠹돿㕅輌ڤ颢ሞ闄澠", 1456105416, 1540960922), a.c(-1772307896, "먹쎙䥊휧峵\uda4e怟\ue9fb瞹ﴎ竜胬\u0e7e韖ᶙ魩"))
            .header(a.b("됂췦䝰\ud91e勗푫", -1012747140), eya.get())
            .POST(BodyPublishers.ofString(var0.toString(), StandardCharsets.UTF_8))
            .build();
         HttpResponse var2 = ewx.send(var5, BodyHandlers.ofString());
         if (var2.statusCode() != 200) {
            exm(var2.statusCode());
            exk(var0);
         }
      } catch (Exception var3) {
         exk(var0);
      }
   }

   private static void exk(JsonObject var0) {
      synchronized (ewt) {
         if (var0.has(a.c(1113055403, "\ue0dd饳Ꭳ跉ؙ"))) {
            ewq.addAll(var0.getAsJsonObject(a.c(-83611927, "⺟圱\udde1䎋졛")).keySet());
         }

         if (var0.has(a.d("휰꺍\u245f먦ㇾ띁ആ", -773624455, -591939027))) {
            ewr.addAll(var0.getAsJsonObject(a.c(582933155, "\udac7ꍺ⦨럑㰉몶ñ")).keySet());
         }

         if (var0.has(a.c(-645409145, "훩꽙▃믝〦뚖್蔳᭢采"))) {
            var0.getAsJsonArray(a.c(1879308360, "\uf826膖ୌ锒ứ顙∂\uabfc㖭뼈")).forEach(var0x -> ews.add(var0x.getAsString()));
         }
      }
   }

   private static JsonObject exl() {
      JsonObject var0 = new JsonObject();
      JsonObject var1 = new JsonObject();

      for (String var3 : ewq) {
         String var4 = ewo.get(var3);
         if (var4 != null) {
            String var5 = exn.seal(a.c(-546090694, "兌⣢ꈲ㱘럁") + var3, var4);
            if (var5 != null) {
               var1.addProperty(var3, var5);
            }
         }
      }

      if (var1.size() > 0) {
         var0.add(a.b("\uf007覩\u0379鴓ᛃ", 931917937), var1);
      }

      JsonObject var8 = new JsonObject();

      for (String var11 : ewr) {
         evy var13 = ewp.get(var11);
         if (var13 != null) {
            String var6 = exn.seal(a.c(-236845419, "۱罌\uf59e毧\ue03f暀\udc8e") + var11, var13.data());
            if (var6 != null) {
               JsonObject var7 = new JsonObject();
               var7.addProperty(a.c(1716571219, "찳떇㽁ꄥ"), var6);
               var7.addProperty(a.d("嵉⓳긯そ뮄㴼蝮", 1958396343, 1536662684), var13.enabled());
               var7.addProperty(a.d("ྲྀ盅ﰝ扽\ue9b3漋핎", 31516459, 740026423), var13.modules());
               var8.add(var11, var7);
            }
         }
      }

      if (var8.size() > 0) {
         var0.add(a.b("\ue2ad鬐ᇂ辻ѣ苜㢛", -305929527), var8);
      }

      if (!ews.isEmpty()) {
         JsonArray var10 = new JsonArray();

         for (String var14 : ews) {
            var10.add(var14);
         }

         var0.add(a.b("닷쭇䆝\udfc3吸튈棓\ue12d罼\uf5d9", 549368473), var10);
      }

      return var0;
   }

   private static void exm(int var0) {
      if (var0 == 401 || var0 == 403) {
         long var1 = System.currentTimeMillis();
         if (var0 != exa || var1 - exb >= 15000L) {
            exa = var0;
            exb = var1;

            try {
               String var3 = var0 == 403
                  ? wap.s(
                     a.b("睆\u0ee8营ᩙ釪\u1716굁⒪뫫ざ랐䷶쌪嫓\uf0b4噱\uec6c措羅罈\uf6ae貫ɰ馾῟锃Ⳕꋌ㠼븣㗒쬎䅚", 1795585839),
                     a.b("왕뿻㔶ꭊ\u20f9ꉕ\u180e闪࿔蔚˅\uf8b9癡\uefdb憓읖崭횝䱞쩾䏷㧙띧⣚ꪷ⑴駖ឈ贃ଥ", -1684617725)
                  )
                  : wap.s(a.c(1076843101, "删⮆ꄝ㼭듹㉀蠝ǫ鿺ᔅ鋝梬\ue67a翊\uf598"), a.d("ꅝ\ud8e6剀채䞑섧筽\uf281泒\ue27b憺鿙ᔕ財ۼ耉㩇뗣", 772717351, 1579097687));
               izx.alert(wap.s(a.c(925850643, "展○꼛ㅰ몶"), a.c(-1033315770, "\ude5eꟀⴙ덣㢾븋")), var3, vhz.MISC, false);
            } catch (Throwable var4) {
            }
         }
      }
   }

   public static CompletableFuture<ewf> call(String var0, JsonObject var1) {
      if (!ewu) {
         init();
      }

      return ewv && ewy != null
         ? CompletableFuture.supplyAsync(
            () -> {
               try {
                  HttpRequest var2 = HttpRequest.newBuilder(URI.create(exe() + var0))
                     .timeout(Duration.ofSeconds(10L))
                     .header(a.d("\ud86cꇉ⬛땶㺦렊ɂ讠ᗤ齀ᢎ\ue2f9氯", 1301689201, 240184177), a.b("仭㝻붬⏎ꠎ⺨钩", -1080013144) + LoaderInfo.token())
                     .header(a.d("ʂ笿\uf1ed澆\ue440拺\ud8b3儛켝䖡쉻㠟", 218058370, -1695658897), a.b("⛁彡햲䯟쀍䚶ﳧ甃\ueb41懶\ue624ᰔ銆ମ腡ޑ", 1849304752))
                     .header(a.d("\uf1bd衙ˏ鲡ᝨ釔", -998770625, 1189743100), eya.get())
                     .POST(BodyPublishers.ofString(var1.toString(), StandardCharsets.UTF_8))
                     .build();
                  HttpResponse var3 = ewx.send(var2, BodyHandlers.ofByteArray());
                  exm(var3.statusCode());
                  if (((byte[])var3.body()).length > 2097152) {
                     throw new IOException(a.b("將▭꽾ㅀ뫛㱧蘧࿃醞", -1018012550));
                  }

                  JsonObject var4;
                  try {
                     var4 = JsonParser.parseString(new String((byte[])var3.body(), StandardCharsets.UTF_8)).getAsJsonObject();
                  } catch (RuntimeException var6) {
                     var4 = new JsonObject();
                  }

                  return new ewf(var3.statusCode(), var4);
               } catch (IOException var7) {
                  throw new CompletionException(var7);
               } catch (InterruptedException var8) {
                  Thread.currentThread().interrupt();
                  throw new CompletionException(var8);
               }
            },
            ewy
         )
         : CompletableFuture.failedFuture(new IOException(a.d("ั瞉ﵚ挡\ue8f3湅퐝", 1008244733, -300639836)));
   }

   public static void flushNow() {
      if (!ewv) {
         LocalState.save();
      } else {
         synchronized (ewt) {
            if (ewz != null) {
               ewz.cancel(false);
            }
         }

         exj();
         LocalState.save();
      }
   }
}
