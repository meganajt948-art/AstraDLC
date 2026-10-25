package a;

import flow.dev.a;
import flow.offline.LocalAssets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public final class eul {
   private static final String eum = new String(
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
   private static final long eun = 314572800L;
   private static final long euo = 50331648L;
   private static final int eup = 4;
   private static final Pattern euq = Pattern.compile(a.d("䰾㖊뽃⅞\uaafeⱴ陫῍臘୴貳皦\uf877懜\uebe3浥휑墌쉨䑳춙럜㥸ꋘⓗ긄ះ馰̌蕁\u0eec\uf03a穵\ue3cc旆", 512414536, 799710987));
   private static final Map<String, byte[]> eur = new LinkedHashMap<>(32, 0.75F, true);
   private static long eus;
   private static final ConcurrentHashMap<String, Future<byte[]>> eut = new ConcurrentHashMap<>();
   private static volatile HttpClient euu;
   private static volatile ThreadPoolExecutor euv;
   private static volatile String euw;
   private static volatile int eux;
   private static volatile long euy;

   private eul() {
   }

   public static String base() {
      return "";
   }

   private static HttpClient evb() {
      HttpClient var0 = euu;
      if (var0 != null) {
         return var0;
      } else {
         synchronized (eul.class) {
            if (euu == null) {
               euu = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();
               euv = (ThreadPoolExecutor)Executors.newFixedThreadPool(4, var0x -> {
                  Thread var1 = new Thread(var0x, a.c(1557565890, "醈\ue813拃ﲪ眸\uf19b䮉쉪尵횒児ꬦ"));
                  var1.setDaemon(true);
                  return var1;
               });
            }

            return euu;
         }
      }
   }

   private static String evc(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = var0.replace('\\', '/').trim();

         while (var1.startsWith(a.b("\ue74b", 1190979429))) {
            var1 = var1.substring(1);
         }

         if (var1.startsWith(a.c(739659443, "仐㝫붻⏒ꡝ"))) {
            var1 = var1.substring(a.c(-1313949918, "띁컺䐪\uda43凌").length());
         }

         if (!euq.matcher(var1).matches()) {
            return "";
         } else {
            for (String var5 : var1.split(a.c(-2933635, "㱓"))) {
               if (var5.isEmpty() || var5.equals(a.d("挣", 274787962, -1357607562)) || var5.equals(a.d("匡⪐", -952182484, -1744270815))) {
                  return "";
               }
            }

            return var1;
         }
      }
   }

   private static byte[] evd(String var0) {
      synchronized (eur) {
         return eur.get(var0);
      }
   }

   private static void eve(String var0, byte[] var1) {
      synchronized (eur) {
         byte[] var3 = eur.put(var0, var1);
         if (var3 != null) {
            eus -= var3.length;
         }

         eus += var1.length;

         while (eus > 314572800L && eur.size() > 1) {
            Entry var4 = eur.entrySet().iterator().next();
            eur.remove(var4.getKey());
            eus = eus - ((byte[])var4.getValue()).length;
         }
      }
   }

   public static byte[] bytes(String var0) throws IOException {
      return LocalAssets.bytes(var0);
   }

   public static void preload(String var0, Consumer<byte[]> var1) {
      String var2 = evc(var0);
      byte[] var3 = evd(var2);
      if (var3 != null) {
         if (var1 != null) {
            var1.accept(var3);
         }
      } else {
         evb();
         euv.execute(() -> {
            try {
               byte[] var2x = bytes(var2);
               if (var1 != null) {
                  var1.accept(var2x);
               }
            } catch (IOException var3x) {
            }
         });
      }
   }

   public static InputStream open(String var0) throws IOException {
      return new ByteArrayInputStream(bytes(var0));
   }

   private static byte[] evf(String var0) throws Exception {
      return LocalAssets.bytes(var0);
   }

   private static String evg(int var0) {
      return switch (var0) {
         case 401 -> wap.s(a.d("핃곥♾롎㎚딣ཾ蚈ᢙ鉦ᖾ\uefcf愙\uf8a9狻", -1232236474, -1336392328), a.d("섖뢭㈋갏⟚ꅬᬶ鋊ಙ舰Ǳﾒ畞\uecea暷\ue042娌햨", 1964156038, 459956669));
         default -> a.c(-852605427, "䙀㿭딾⭋ꃬ") + var0;
         case 403 -> wap.s(
            a.b("渗ឹ鵴̈袻็됐㷻ꎺ⤇껁咧\uda7b䎂\ue9e5传\uf53d竻\ue05e昙\uefff闺ᬡ胯ڎ豒㖅뮝Ⅽꝲⲃ퉟堋", 1722510974), a.b("挛᪵選ค薷ܛ뵀イꪚ⁔Ꞌ巷팯䪕쓝战\uf863珓\ue910漰\ue6b9鲗ሩ趔\u0ff9脺㲘닆⡍깫", 135095117)
         );
         case 404 -> wap.s(a.c(-291342373, "瞷ด蓇᪠酦ឃ궝⑨먭゜띕䴣쏽"), a.d("袅\uf13c翺\ue596湌\ue8f4努\udb5a䔍쾿", -1199009961, 1900938213));
      };
   }

   private static void evh(int var0, String var1) {
      long var2 = System.currentTimeMillis();
      if (var0 != eux || var2 - euy >= 15000L) {
         eux = var0;
         euy = var2;

         try {
            izx.alert(wap.s(a.c(-1698901386, "툰ꮮⅾ뼕㓓"), a.d("䒹㴧럾⦄ꉙ⓬", -1937593698, 983034431)), var1, vhz.MISC, false);
         } catch (Throwable var5) {
         }
      }
   }

   public static void shutdown() {
      ThreadPoolExecutor var0 = euv;
      if (var0 != null) {
         var0.shutdownNow();

         try {
            var0.awaitTermination(2L, TimeUnit.SECONDS);
         } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
         }
      }
   }
}
