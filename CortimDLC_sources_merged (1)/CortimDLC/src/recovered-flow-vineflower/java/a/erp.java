package a;

import flow.dev.a;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class erp {
   static final int erq = 10;
   static final double err = 0.35;
   static final int ers = 5;
   static final int ert = 22;
   static final int eru = 15527144;
   static final double erv = Math.log(2.0);
   static final String erw = new String(new char[]{'f', 'l', 'o', 'w'});
   static final String erx = new String(new char[]{'c', 'a', 'p', 't', 'c', 'h', 'a', '/', 'd', 'i', 'g', 'i', 't', 's', '.', 'o', 'n', 'n', 'x'});
   static final Object ery = new Object();
   static volatile eqc erz;
   static final ThreadPoolExecutor esa = esd();

   erp() {
   }

   static ThreadPoolExecutor esd() {
      int var0 = Math.max(1, Math.min(6, Runtime.getRuntime().availableProcessors() - 1));
      ThreadPoolExecutor var1 = new ThreadPoolExecutor(var0, var0, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), var0x -> {
         Thread var1x = Executors.defaultThreadFactory().newThread(var0x);
         var1x.setDaemon(true);
         return var1x;
      });
      var1.allowCoreThreadTimeOut(true);
      return var1;
   }

   public static void preload() {
      try {
         eqc var0 = esm();
         var0.logits(new float[3 * var0.inputH * var0.inputW]);
      } catch (erh | InterruptedException | RuntimeException var1) {
      }
   }

   public static erc solve(BufferedImage var0) throws erh {
      eqc var1 = esm();

      try {
         erk var2 = read(var0, var1);
         return !var2.code().isEmpty() && var2.strength() >= 0.35
            ? new erc(var2.code(), a.d("\ue046駳", -1026138789, 2072952176))
            : new erc("", a.c(2075820018, "美ؤ賺ኍ饍Ὼꖼⱅ눝"));
      } catch (IllegalArgumentException var4) {
         return new erc("", var4.getMessage());
      } catch (InterruptedException var5) {
         Thread.currentThread().interrupt();
         return new erc("", a.c(1993195927, "쇵롃㊊곪✪ꆛᯏ鈻ౠ蛀Ē"));
      } catch (RuntimeException | ExecutionException var6) {
         Throwable var3 = var6 instanceof ExecutionException && var6.getCause() != null ? var6.getCause() : var6;
         return new erc("", a.c(1766866921, "㾭䘐쳒勑\ud943忥\ue5b6汚\uf218磡Ｈ") + var3);
      }
   }

   static erk read(BufferedImage var0, eqc var1) throws InterruptedException, ExecutionException {
      int var2 = var0.getWidth();
      int var3 = var0.getHeight();
      if (var2 <= 4096 && var3 <= 4096 && Math.min(var2, var3) >= 16) {
         List var4 = views(flatten(var0));
         ArrayList var5 = new ArrayList(var4.size());

         for (eqw var7 : var4) {
            var5.add(() -> esh(var1.logits(tensor(resize(var7, var1.inputW, var1.inputH)))));
         }

         ArrayList var10 = new ArrayList(var4.size());

         for (Future var9 : esa.invokeAll(var5)) {
            var10.add((float[][])var9.get());
         }

         return vote(var10);
      } else {
         throw new IllegalArgumentException(a.d("깛ퟑ崟써䢺츋瑇ﶫ揲\ue952満钵ᨫ莞ু輶㕻뫯\u200fꙄ⾠嗮", -1073510822, 1330063426));
      }
   }

   static erk vote(List<float[][]> var0) {
      LinkedHashSet var1 = new LinkedHashSet();

      for (float[][] var3 : var0) {
         String var4 = ese(var3);
         if (var4.length() >= 3 && var4.length() <= 8) {
            var1.add(var4);
         }
      }

      if (var1.isEmpty()) {
         return new erk("", 0.0);
      }

      LinkedHashMap var13 = new LinkedHashMap();

      for (String var16 : var1) {
         double var5 = 0.0;
         double var7 = 0.0;

         for (float[][] var10 : var0) {
            double var11 = esf(var10, var16);
            var5 += var11;
            var7 += Math.exp(var11);
         }

         if (var16.length() != 5) {
            var5 -= 2.0;
         }

         var13.put(var16, new double[]{var5, var7 / var0.size()});
      }

      String var15 = null;
      double var17 = Double.NEGATIVE_INFINITY;

      for (Entry var19 : var13.entrySet()) {
         if (((double[])var19.getValue())[0] > var17) {
            var17 = ((double[])var19.getValue())[0];
            var15 = (String)var19.getKey();
         }
      }

      double var18 = 0.0;

      for (double[] var21 : var13.values()) {
         var18 += Math.exp(var21[0] - var17);
      }

      double var20 = Math.exp(((double[])var13.get(var15))[0] - var17) / var18;
      double var22 = ((double[])var13.get(var15))[1];
      return new erk(var15, var20 * Math.min(1.0, var22 * 2.5));
   }

   static String ese(float[][] var0) {
      StringBuilder var1 = new StringBuilder();
      int var2 = 10;

      for (float[] var6 : var0) {
         int var7 = 0;

         for (int var8 = 1; var8 < var6.length; var8++) {
            if (var6[var8] > var6[var7]) {
               var7 = var8;
            }
         }

         if (var7 != 10 && var7 != var2) {
            var1.append((char)(48 + var7));
         }

         var2 = var7;
      }

      return var1.toString();
   }

   static double esf(float[][] var0, String var1) {
      int var2 = var1.length() * 2 + 1;
      int[] var3 = new int[var2];
      var3[0] = 10;

      for (int var4 = 0; var4 < var1.length(); var4++) {
         var3[2 * var4 + 1] = var1.charAt(var4) - '0';
         var3[2 * var4 + 2] = 10;
      }

      double var12 = -1.0E30;
      double[] var6 = new double[var2];
      double[] var7 = new double[var2];
      Arrays.fill(var6, var12);
      var6[0] = var0[0][var3[0]];
      var6[1] = var0[0][var3[1]];

      for (int var8 = 1; var8 < var0.length; var8++) {
         for (int var9 = 0; var9 < var2; var9++) {
            double var10 = var6[var9];
            if (var9 >= 1) {
               var10 = esg(var10, var6[var9 - 1]);
            }

            if (var9 >= 2 && var3[var9] != 10 && var3[var9] != var3[var9 - 2]) {
               var10 = esg(var10, var6[var9 - 2]);
            }

            var7[var9] = var10 + var0[var8][var3[var9]];
         }

         double[] var13 = var6;
         var6 = var7;
         var7 = var13;
      }

      return esg(var6[var2 - 1], var6[var2 - 2]);
   }

   static double esg(double var0, double var2) {
      if (var0 == var2) {
         return var0 + erv;
      }

      double var4 = var0 - var2;
      return var4 > 0.0 ? var0 + Math.log1p(Math.exp(-var4)) : var2 + Math.log1p(Math.exp(var4));
   }

   static float[][] esh(float[][] var0) {
      float[][] var1 = new float[var0.length][];

      for (int var2 = 0; var2 < var0.length; var2++) {
         float[] var3 = var0[var2];
         float var4 = Float.NEGATIVE_INFINITY;

         for (float var8 : var3) {
            var4 = Math.max(var4, var8);
         }

         double var11 = 0.0;

         for (float var10 : var3) {
            var11 += Math.exp(var10 - var4);
         }

         double var13 = Math.log(var11);
         float[] var15 = new float[var3.length];

         for (int var16 = 0; var16 < var3.length; var16++) {
            var15[var16] = (float)(var3[var16] - var4 - var13);
         }

         var1[var2] = var15;
      }

      return var1;
   }

   static eqw flatten(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int[] var3 = var0.getRGB(0, 0, var1, var2, null, 0, var1);

      for (int var4 = 0; var4 < var3.length; var4++) {
         int var5 = var3[var4];
         int var6 = var5 >>> 24;
         if (var6 == 0) {
            var3[var4] = 16777215;
         } else {
            int var7 = var6 * 128;
            int var8 = 32640 - var7;
            var3[var4] = esi(var5 >> 16 & 0xFF, var7, var8) << 16 | esi(var5 >> 8 & 0xFF, var7, var8) << 8 | esi(var5 & 0xFF, var7, var8);
         }
      }

      return new eqw(var3, var1, var2);
   }

   static int esi(int var0, int var1, int var2) {
      int var3 = var0 * var1 + 255 * var2 + 16384;
      return (var3 >> 8) + var3 >> 8 >> 7;
   }

   static List<eqw> views(eqw var0) {
      int var1 = var0.w();
      int var2 = var0.h();
      ArrayList var3 = new ArrayList(6);
      var3.add(var0);

      for (double var7 : new double[]{0.04, 0.08}) {
         int var9 = (int)(var1 * var7);
         int var10 = (int)(var2 * var7);
         var3.add(esj(var0, var9, var10, var1 - var9, var2 - var10));
      }

      for (double var19 : new double[]{0.07, 0.12}) {
         int var20 = (int)(var1 * var19);
         int var21 = (int)(var2 * var19);
         int var11 = var1 + 2 * var20;
         int var12 = var2 + 2 * var21;
         int[] var13 = new int[var11 * var12];
         Arrays.fill(var13, 15527144);

         for (int var14 = 0; var14 < var2; var14++) {
            System.arraycopy(var0.px(), var14 * var1, var13, (var14 + var21) * var11 + var20, var1);
         }

         var3.add(new eqw(var13, var11, var12));
      }

      int var16 = (int)(var2 * 0.06);
      var3.add(esj(var0, 0, var16, var1, var2 - var16));
      return var3;
   }

   static eqw esj(eqw var0, int var1, int var2, int var3, int var4) {
      int var5 = var3 - var1;
      int var6 = var4 - var2;
      int[] var7 = new int[var5 * var6];

      for (int var8 = 0; var8 < var6; var8++) {
         System.arraycopy(var0.px(), (var8 + var2) * var0.w() + var1, var7, var8 * var5, var5);
      }

      return new eqw(var7, var5, var6);
   }

   static eqw resize(eqw var0, int var1, int var2) {
      eqw var3 = var0;
      if (var1 != var3.w()) {
         var3 = esk(var3, var1, true);
      }

      if (var2 != var3.h()) {
         var3 = esk(var3, var2, false);
      }

      return var3;
   }

   static eqw esk(eqw var0, int var1, boolean var2) {
      int var3 = var2 ? var0.w() : var0.h();
      double var4 = (double)var3 / var1;
      double var6 = Math.max(1.0, var4);
      double var8 = var6;
      int var10 = (int)Math.ceil(var8) * 2 + 1;
      int[] var11 = new int[var1 * 2];
      int[] var12 = new int[var1 * var10];
      double[] var13 = new double[var10];

      for (int var14 = 0; var14 < var1; var14++) {
         double var15 = (var14 + 0.5) * var4;
         double var17 = 1.0 / var6;
         int var19 = (int)(var15 - var8 + 0.5);
         if (var19 < 0) {
            var19 = 0;
         }

         int var20 = (int)(var15 + var8 + 0.5);
         if (var20 > var3) {
            var20 = var3;
         }

         var20 -= var19;
         double var21 = 0.0;

         for (int var23 = 0; var23 < var20; var23++) {
            double var24 = Math.abs((var23 + var19 - var15 + 0.5) * var17);
            var13[var23] = var24 < 1.0 ? 1.0 - var24 : 0.0;
            var21 += var13[var23];
         }

         for (int var39 = 0; var39 < var20; var39++) {
            double var41 = var21 != 0.0 ? var13[var39] / var21 : var13[var39];
            var12[var14 * var10 + var39] = var41 < 0.0 ? (int)(-0.5 + var41 * 4194304.0) : (int)(0.5 + var41 * 4194304.0);
         }

         var11[var14 * 2] = var19;
         var11[var14 * 2 + 1] = var20;
      }

      int var32 = var2 ? var1 : var0.w();
      int var33 = var2 ? var0.h() : var1;
      int[] var16 = new int[var32 * var33];
      int[] var34 = var0.px();
      int var18 = var2 ? 1 : var0.w();
      int var35 = var2 ? var33 : var32;

      for (int var37 = 0; var37 < var35; var37++) {
         for (int var38 = 0; var38 < var1; var38++) {
            int var22 = var11[var38 * 2];
            int var40 = var11[var38 * 2 + 1];
            int var42 = var38 * var10;
            int var25 = var2 ? var37 * var0.w() + var22 : var22 * var0.w() + var37;
            int var26 = 2097152;
            int var27 = var26;
            int var28 = var26;

            for (int var29 = 0; var29 < var40; var29++) {
               int var30 = var34[var25 + var29 * var18];
               int var31 = var12[var42 + var29];
               var26 += (var30 >> 16 & 0xFF) * var31;
               var27 += (var30 >> 8 & 0xFF) * var31;
               var28 += (var30 & 0xFF) * var31;
            }

            int var43 = var2 ? var37 * var32 + var38 : var38 * var32 + var37;
            var16[var43] = esl(var26) << 16 | esl(var27) << 8 | esl(var28);
         }
      }

      return new eqw(var16, var32, var33);
   }

   static int esl(int var0) {
      int var1 = var0 >> 22;
      return var1 < 0 ? 0 : Math.min(var1, 255);
   }

   static float[] tensor(eqw var0) {
      int var1 = var0.w() * var0.h();
      float[] var2 = new float[3 * var1];
      int[] var3 = var0.px();

      for (int var4 = 0; var4 < var1; var4++) {
         int var5 = var3[var4];
         var2[var4] = (var5 >> 16 & 0xFF) / 127.5F - 1.0F;
         var2[var1 + var4] = (var5 >> 8 & 0xFF) / 127.5F - 1.0F;
         var2[2 * var1 + var4] = (var5 & 0xFF) / 127.5F - 1.0F;
      }

      return var2;
   }

   static eqc esm() throws erh {
      eqc var0 = erz;
      if (var0 != null) {
         return var0;
      }

      synchronized (ery) {
         if (erz != null) {
            return erz;
         }

         byte[] var2 = esn(erx);
         if (var2 == null) {
            throw new erh(a.c(-330721377, "鎂\uea31惨ﺘ畁\uf387䶸쁓帆풸匓ꤝ⏒빽㑒늠࣭蜽ᶍ鯟ቘ桸\ue6bd紛＆燅챤䙔\udcd3媍텀\u2febꖫ"));
         }

         try {
            erz = eqc.parse(var2);
         } catch (RuntimeException var5) {
            throw new erh(a.b("훙꽪△믃〚뛜ࣣ蔈᭝釣ᙈ\uec46暉ﬥ煾\uf39a䶲순壕\udef6圄ⴢꎒ㡍멇れ", -1965567233) + var5.getMessage());
         }

         return erz;
      }
   }

   static byte[] esn(String var0) {
      try (InputStream var1 = ezj.open(a.c(-1900730780, "♊") + erw + a.c(-1866488690, "꒠") + var0)) {
         if (var1 == null) {
            return null;
         }

         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         var1.transferTo(var2);
         return var2.toByteArray();
      } catch (IOException var6) {
         return null;
      }
   }
}
