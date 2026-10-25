package a;

import flow.dev.a;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public final class jzh {
   static final int jzi = 1920;
   static final int jzj = 2560;
   static final int jzk = 320;
   static final ExecutorService jzl = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, a.c(-2075306847, "哩\u2d72Ꞣ㧋뉙㓺軤ܝ饉Ꮳ鑥湕\ue091礦"));
      var1.setDaemon(true);
      return var1;
   });
   static final ExecutorService jzm = Executors.newFixedThreadPool(3, var0 -> {
      Thread var1 = new Thread(var0, a.b("仞㝅붕⏼ꡮ⻍铓ᴪ荾\u09d4蹒瑷謁挐\ue95b澥헻", -192065911));
      var1.setDaemon(true);
      var1.setPriority(1);
      return var1;
   });
   static final Map<String, CompletableFuture<BufferedImage[]>> jzn = new HashMap<>();
   static final Map<String, jza> jzo = new HashMap<>();
   static final List<uok> jzp = new ArrayList<>();
   static final List<Long> jzq = new ArrayList<>();
   static final List<String> jzr = new ArrayList<>();
   static final Map<String, CompletableFuture<BufferedImage>> jzs = new HashMap<>();
   static final Map<String, uok> jzt = new HashMap<>();

   jzh() {
   }

   public static synchronized void preload(String var0) {
      if (!jzo.containsKey(var0) && !jzn.containsKey(var0) && !jzr.contains(var0)) {
         jzn.put(var0, CompletableFuture.supplyAsync(() -> jzz(var0), jzl));
      }
   }

   public static synchronized boolean decoded(String var0) {
      CompletableFuture var1 = jzn.get(var0);
      return jzo.containsKey(var0) || jzr.contains(var0) || var1 != null && var1.isDone();
   }

   public static synchronized jza get(String var0) {
      jzy();
      jza var1 = jzo.get(var0);
      if (var1 != null) {
         return jzw(var0, var1);
      }

      preload(var0);
      CompletableFuture var2 = jzn.get(var0);
      if (var2 != null && var2.isDone()) {
         jzn.remove(var0);
         BufferedImage[] var3 = (BufferedImage[])var2.getNow(null);
         if (var3 == null) {
            jzr.add(var0);
            return null;
         }

         try {
            var1 = new jza(
               uok.upload(a.b("⮳刊\ud8d2䚸촺", -10474533) + var0, var3[0], false), uok.upload(a.c(265182911, "廘❡궹㏓롑㺢蓿ഗ鍏\u19ac") + var0, var3[1], false)
            );
         } catch (Throwable var5) {
            jzr.add(var0);
            System.out
               .println(
                  a.d("⣜入\udbbd䗗칕䢴\uf2fe笅\ue54d濽\ue829\u124f鳝", 1313727225, -1760638395) + var0 + a.b("㋄䬶쇧徙퐇勥\ue8e2慑）痽\uf27bࠏ蛄ὶ锫Ꮯꦑ♁벬㫧", 1208627952) + var5
               );
            return null;
         }

         jzo.put(var0, var1);
         return jzw(var0, var1);
      } else {
         return null;
      }
   }

   static jza jzw(String var0, jza var1) {
      kbs var2 = kbs.byKey(var0);
      int var3 = var2 != null ? var2.fill : -1;
      if (!whl.is(var0)) {
         return var3 >= 0 ? new jza(var1.sharp(), var1.blur(), false, var3) : var1;
      }

      uok var4 = whl.get(var0.substring(a.b("찴떚㽄ꄴ⫩갍", -1047999420).length())).frame();
      return new jza(var4 != null ? var4 : var1.sharp(), var1.blur(), var4 != null, var3);
   }

   public static synchronized uok thumb(String var0) {
      uok var1 = jzt.get(var0);
      if (var1 == null && !jzr.contains(var0)) {
         CompletableFuture var2 = jzs.computeIfAbsent(var0, var0x -> CompletableFuture.supplyAsync(() -> {
            try {
               BufferedImage var1x = kab(var0x, 320);
               return var1x == null ? null : kad(var1x, 320, Math.round(320.0F * var1x.getHeight() / var1x.getWidth()));
            } catch (Throwable var2x) {
               return null;
            }
         }, jzm));
         if (!var2.isDone()) {
            return null;
         } else {
            jzs.remove(var0);
            BufferedImage var3 = (BufferedImage)var2.getNow(null);
            if (var3 == null) {
               jzr.add(var0);
               return null;
            } else {
               var1 = uok.upload(a.c(-1610467836, "㙢俛씃孩탫嘎\uec41断ﯪ煔\uf6c5") + var0, var3, false);
               jzt.put(var0, var1);
               return var1;
            }
         }
      } else {
         return var1;
      }
   }

   public static synchronized boolean warm(String var0) {
      return get(var0) != null || jzr.contains(var0);
   }

   public static synchronized boolean warmThumb(String var0) {
      return thumb(var0) != null || jzr.contains(var0);
   }

   public static synchronized void releaseExcept(String... var0) {
      jzn.keySet().removeIf(var1x -> !Arrays.asList(var0).contains(var1x));
      Iterator var1 = jzo.entrySet().iterator();

      while (var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         boolean var3 = false;

         for (String var7 : var0) {
            var3 |= ((String)var2.getKey()).equals(var7);
         }

         if (!var3) {
            jzx(((jza)var2.getValue()).sharp());
            jzx(((jza)var2.getValue()).blur());
            var1.remove();
         }
      }
   }

   static void jzx(uok var0) {
      jzp.add(var0);
      jzq.add(unf.frame());
   }

   static void jzy() {
      long var0 = unf.frame();

      for (int var2 = jzp.size() - 1; var2 >= 0; var2--) {
         if (var0 - jzq.get(var2) > 3L) {
            jzp.remove(var2).close();
            jzq.remove(var2);
         }
      }
   }

   static BufferedImage[] jzz(String var0) {
      try {
         BufferedImage var1 = kaa(var0);
         if (var1 == null) {
            System.out.println(a.c(-2014295654, "䧺ぃ몛⓱꽳⦒鏘ᨣ葫\u0edb褏獩ﷻ") + var0 + a.c(-649380644, "㳷䔏쿆凤\uda7e峋\ue682潳\uf136简ﱚ"));
            return null;
         } else {
            int var2 = Math.max(1920, Math.min(2560, var1.getWidth()));
            int var3 = Math.round((float)(var2 * var1.getHeight()) / var1.getWidth());
            BufferedImage var4 = var1.getWidth() * 1.3F < var2 ? kae(var1, var2, var3) : kad(var1, var2, var3);
            short var5 = 320;
            int var6 = Math.max(8, Math.round((float)(var5 * var3) / var2));
            BufferedImage var7 = kak(kad(var4, var5, var6), 3.2F);
            return new BufferedImage[]{var4, var7};
         }
      } catch (Throwable var8) {
         System.out.println(a.c(-707460424, "˘筡\uf1b9濓\ue451抰\ud8fa儁콉䗹숭㡋뛙") + var0 + a.b("簅\u05f7輦ᅘ髆ᰤ꘣⾐뇈㬼벽䛛절冼\udbb1嵚", 1663466549) + var8);
         return null;
      }
   }

   static BufferedImage kaa(String var0) throws Exception {
      try (InputStream var1 = kac(var0)) {
         return var1 == null ? null : ImageIO.read(var1);
      }
   }

   static BufferedImage kab(String var0, int var1) throws Exception {
      try (
         InputStream var2 = kac(var0);
         ImageInputStream var3 = var2 == null ? null : ImageIO.createImageInputStream(var2);
      ) {
         if (var3 == null) {
            return null;
         }

         Iterator var4 = ImageIO.getImageReaders(var3);
         if (var4.hasNext()) {
            ImageReader var21 = (ImageReader)var4.next();

            try {
               var21.setInput(var3, true, true);
               int var6 = Math.max(1, var21.getWidth(0) / (var1 * 2));
               ImageReadParam var7 = var21.getDefaultReadParam();
               var7.setSourceSubsampling(var6, var6, 0, 0);
               return var21.read(0, var7);
            } finally {
               var21.dispose();
            }
         } else {
            return null;
         }
      }
   }

   static InputStream kac(String var0) throws Exception {
      String var1 = kbs.resource(var0);

      try {
         return ezj.open(var1.substring(0, var1.length() - 4) + a.c(-155281424, "韚\uee35擸婢"));
      } catch (Exception var3) {
         return ezj.open(var1);
      }
   }

   static BufferedImage kad(BufferedImage var0, int var1, int var2) {
      BufferedImage var3 = var0;
      int var4 = var3.getWidth();

      int var5;
      for (var5 = var3.getHeight(); var4 / 2 >= var1 && var5 / 2 >= var2; var3 = kaj(var3, var4, var5)) {
         var4 /= 2;
         var5 /= 2;
      }

      return var4 == var1 && var5 == var2 && var3.getType() == 1 ? var3 : kaj(var3, var1, var2);
   }

   static BufferedImage kae(BufferedImage var0, int var1, int var2) {
      BufferedImage var3 = kag(kaf(var0));
      int var4 = var3.getWidth();

      for (int var5 = var3.getHeight(); var4 * 1.5F < var1; var3 = kaj(var3, var4, var5)) {
         var4 = Math.round(var4 * 1.5F);
         var5 = Math.round(var5 * 1.5F);
      }

      var3 = kaj(var3, var1, var2);
      return kah(var3, 1.4F, 0.75F, 2.5F);
   }

   static BufferedImage kaf(BufferedImage var0) {
      return var0.getType() == 1 ? var0 : kaj(var0, var0.getWidth(), var0.getHeight());
   }

   static BufferedImage kag(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int[] var3 = var0.getRGB(0, 0, var1, var2, null, 0, var1);
      int[] var4 = new int[var3.length];
      float var5 = 14.0F;
      float[] var6 = new float[25];

      for (int var7 = -2; var7 <= 2; var7++) {
         for (int var8 = -2; var8 <= 2; var8++) {
            var6[(var7 + 2) * 5 + var8 + 2] = (float)Math.exp(-(var8 * var8 + var7 * var7) / 2.42F);
         }
      }

      for (int var26 = 0; var26 < var2; var26++) {
         for (int var28 = 0; var28 < var1; var28++) {
            int var9 = var3[var26 * var1 + var28];
            int var10 = var9 >> 16 & 0xFF;
            int var11 = var9 >> 8 & 0xFF;
            int var12 = var9 & 0xFF;
            float var13 = 0.0F;
            float var14 = 0.0F;
            float var15 = 0.0F;
            float var16 = 0.0F;

            for (int var17 = -2; var17 <= 2; var17++) {
               int var18 = Math.min(var2 - 1, Math.max(0, var26 + var17));

               for (int var19 = -2; var19 <= 2; var19++) {
                  int var20 = var3[var18 * var1 + Math.min(var1 - 1, Math.max(0, var28 + var19))];
                  int var21 = var20 >> 16 & 0xFF;
                  int var22 = var20 >> 8 & 0xFF;
                  int var23 = var20 & 0xFF;
                  float var24 = ((var21 - var10) * (var21 - var10) + (var22 - var11) * (var22 - var11) + (var23 - var12) * (var23 - var12)) / 3.0F;
                  float var25 = var6[(var17 + 2) * 5 + var19 + 2] * (float)Math.exp(-var24 / (2.0F * var5 * var5));
                  var13 += var21 * var25;
                  var14 += var22 * var25;
                  var15 += var23 * var25;
                  var16 += var25;
               }
            }

            var4[var26 * var1 + var28] = 0xFF000000 | kal(var13 / var16) << 16 | kal(var14 / var16) << 8 | kal(var15 / var16);
         }
      }

      BufferedImage var27 = new BufferedImage(var1, var2, 1);
      var27.setRGB(0, 0, var1, var2, var4, 0, var1);
      return var27;
   }

   static BufferedImage kah(BufferedImage var0, float var1, float var2, float var3) {
      int var4 = var0.getWidth();
      int var5 = var0.getHeight();
      int[] var6 = var0.getRGB(0, 0, var4, var5, null, 0, var4);
      int[] var7 = kak(var0, var1).getRGB(0, 0, var4, var5, null, 0, var4);

      for (int var8 = 0; var8 < var6.length; var8++) {
         int var9 = var6[var8];
         int var10 = var7[var8];
         int var11 = kai(var9 >> 16 & 0xFF, var10 >> 16 & 0xFF, var2, var3);
         int var12 = kai(var9 >> 8 & 0xFF, var10 >> 8 & 0xFF, var2, var3);
         int var13 = kai(var9 & 0xFF, var10 & 0xFF, var2, var3);
         var6[var8] = 0xFF000000 | var11 << 16 | var12 << 8 | var13;
      }

      BufferedImage var14 = new BufferedImage(var4, var5, 1);
      var14.setRGB(0, 0, var4, var5, var6, 0, var4);
      return var14;
   }

   static int kai(int var0, int var1, float var2, float var3) {
      float var4 = var0 - var1;
      float var5 = Math.min(1.0F, Math.max(0.0F, (Math.abs(var4) - var3) / var3));
      return kal(var0 + var4 * var2 * var5);
   }

   static BufferedImage kaj(BufferedImage var0, int var1, int var2) {
      BufferedImage var3 = new BufferedImage(Math.max(1, var1), Math.max(1, var2), 1);
      Graphics2D var4 = var3.createGraphics();
      var4.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      var4.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      var4.drawImage(var0, 0, 0, var3.getWidth(), var3.getHeight(), null);
      var4.dispose();
      return var3;
   }

   static BufferedImage kak(BufferedImage var0, float var1) {
      int var2 = var0.getWidth();
      int var3 = var0.getHeight();
      int var4 = Math.max(1, (int)Math.ceil(var1 * 2.8F));
      float[] var5 = new float[var4 * 2 + 1];
      float var6 = 0.0F;

      for (int var7 = -var4; var7 <= var4; var7++) {
         var5[var7 + var4] = (float)Math.exp(-(var7 * var7) / (2.0F * var1 * var1));
         var6 += var5[var7 + var4];
      }

      for (int var18 = 0; var18 < var5.length; var18++) {
         var5[var18] /= var6;
      }

      int[] var19 = var0.getRGB(0, 0, var2, var3, null, 0, var2);
      float[][] var8 = new float[3][var2 * var3];

      for (int var9 = 0; var9 < var19.length; var9++) {
         var8[0][var9] = var19[var9] >> 16 & 0xFF;
         var8[1][var9] = var19[var9] >> 8 & 0xFF;
         var8[2][var9] = var19[var9] & 0xFF;
      }

      float[] var20 = new float[var2 * var3];

      for (float[] var13 : var8) {
         for (int var14 = 0; var14 < var3; var14++) {
            for (int var15 = 0; var15 < var2; var15++) {
               float var16 = 0.0F;

               for (int var17 = -var4; var17 <= var4; var17++) {
                  var16 += var13[var14 * var2 + Math.min(var2 - 1, Math.max(0, var15 + var17))] * var5[var17 + var4];
               }

               var20[var14 * var2 + var15] = var16;
            }
         }

         for (int var23 = 0; var23 < var2; var23++) {
            for (int var24 = 0; var24 < var3; var24++) {
               float var25 = 0.0F;

               for (int var26 = -var4; var26 <= var4; var26++) {
                  var25 += var20[Math.min(var3 - 1, Math.max(0, var24 + var26)) * var2 + var23] * var5[var26 + var4];
               }

               var13[var24 * var2 + var23] = var25;
            }
         }
      }

      for (int var21 = 0; var21 < var19.length; var21++) {
         var19[var21] = 0xFF000000 | kal(var8[0][var21]) << 16 | kal(var8[1][var21]) << 8 | kal(var8[2][var21]);
      }

      BufferedImage var22 = new BufferedImage(var2, var3, 1);
      var22.setRGB(0, 0, var2, var3, var19, 0, var2);
      return var22;
   }

   static int kal(float var0) {
      return Math.max(0, Math.min(255, Math.round(var0)));
   }
}
