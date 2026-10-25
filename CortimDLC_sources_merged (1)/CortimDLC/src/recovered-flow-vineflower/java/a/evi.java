package a;

import flow.dev.a;
import flow.util.LoaderInfo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public final class evi {
   private static final long evj = 10000L;
   private static final int evk = 2097152;
   private static final int evl = 4096;
   private static final AtomicBoolean evm = new AtomicBoolean();
   private static volatile BufferedImage evn;
   private static volatile String evo = "";
   private static volatile boolean evp;
   private static volatile int evq;
   private static volatile long evr;
   private static HttpClient evs;

   private evi() {
   }

   public static BufferedImage image() {
      return evn;
   }

   public static String etag() {
      return evo;
   }

   public static boolean known() {
      return evp;
   }

   public static int version() {
      return evq;
   }

   public static void boot() {
      if (evr == 0L) {
         refresh();
      }
   }

   public static void refresh() {
      long var0 = System.currentTimeMillis();
      if (var0 - evr >= 10000L && !dry.armed() && !LoaderInfo.token().isBlank()) {
         if (evm.compareAndSet(false, true)) {
            evr = var0;
            Thread var2 = new Thread(() -> {
               try {
                  evw();
               } catch (Throwable var4) {
               } finally {
                  evm.set(false);
               }
            }, a.c(1086235517, "ꌙ\udaa7偷츜䗚쌢礽"));
            var2.setDaemon(true);
            var2.setPriority(1);
            var2.start();
         }
      }
   }

   private static synchronized HttpClient evv() {
      if (evs == null) {
         evs = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
      }

      return evs;
   }

   private static void evw() throws Exception {
      Builder var0 = HttpRequest.newBuilder(URI.create(ewk.endpoint() + a.b("夯⃐ꨒ㑺뿫㤔荐શ铼Ṙ馘", -929605365)))
         .timeout(Duration.ofSeconds(20L))
         .header(a.d("㬥䊀졒嘿\uddef孃\ue10b棩\uf6ad簉\ufbc7ư车", 1871235344, 1157558873), a.c(1364330743, "ࢲ焤ﯳ斑\uee51棷틶") + LoaderInfo.token())
         .header(a.d("\uf374誐\u0006鹨ᖡ錝", 2025088552, 191141154), eya.get())
         .GET();
      if (evn != null && !evo.isEmpty()) {
         var0.header(a.c(384634344, "ඌ琲ﺪ悘\ueb4e淾\ud7a6帟쀀䪽쵻㜝링"), evo);
      }

      HttpResponse var1 = evv().send(var0.build(), BodyHandlers.ofByteArray());
      int var2 = var1.statusCode();
      if (var2 == 304) {
         evp = true;
      } else if (var2 == 404) {
         if (evn != null) {
            evn = null;
            evo = "";
            evq++;
         }

         evp = true;
      } else if (var2 == 200 && ((byte[])var1.body()).length != 0 && ((byte[])var1.body()).length <= 2097152) {
         BufferedImage var3 = evx((byte[])var1.body());
         if (var3 != null) {
            evn = var3;
            evo = var1.headers().firstValue(a.d("㻮䝎춈叿", -1399358133, -751811644)).orElse("");
            evp = true;
            evq++;
         }
      }
   }

   private static BufferedImage evx(byte[] var0) throws Exception {
      try (ImageInputStream var1 = ImageIO.createImageInputStream(new ByteArrayInputStream(var0))) {
         Iterator var2 = ImageIO.getImageReaders(var1);
         if (!var2.hasNext()) {
            return null;
         }

         ImageReader var3 = (ImageReader)var2.next();

         try {
            var3.setInput(var1, true, true);
            return var3.getWidth(0) <= 4096 && var3.getHeight(0) <= 4096 ? var3.read(0) : null;
         } finally {
            var3.dispose();
         }
      }
   }
}
