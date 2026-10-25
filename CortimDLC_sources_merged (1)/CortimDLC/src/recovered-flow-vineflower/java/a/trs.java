package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class trs {
   static final int trt = 128;
   static final double tru = 0.002;
   static final double trv = 2.0E-4;
   static final double trw = 1.0E-4;
   static final double trx = 5.0;

   trs() {
   }

   public static trm train(trp var0, int var1, long var2, tmw var4) {
      Random var5 = new Random(var2);
      int var6 = var0.n;
      boolean[] var7 = new boolean[var6];
      HashMap<Integer, Boolean> var8 = new HashMap<>();

      for (int var9 = 0; var9 < var6; var9++) {
         var7[var9] = var8.computeIfAbsent(var0.block[var9], var1x -> var5.nextDouble() < 0.15);
      }

      ArrayList<Integer> var45 = new ArrayList<>();
      ArrayList<Integer> var10 = new ArrayList<>();

      for (int var11 = 0; var11 < var6; var11++) {
         (var7[var11] ? var10 : var45).add(var11);
      }

      if (var10.size() < 50 || var45.size() < 200) {
         var10 = var45;
      }

      tbx var46 = new tbx(71, 48, 48, 11);
      trj var12 = new trj(var46);
      boolean[] var13 = tsd(var0, var45, var12);
      var46.init(var5, new double[11]);

      for (int var14 = 0; var14 < 71; var14++) {
         if (var13[var14]) {
            for (int var15 = 0; var15 < var46.h1; var15++) {
               var46.p[var15 * 71 + var14] = 0.0;
            }
         }
      }

      double[] var47 = new double[var46.size()];
      double[] var48 = new double[var46.size()];
      double[] var16 = new double[var46.size()];
      double[] var17 = (double[])var46.p.clone();
      double var18 = Double.POSITIVE_INFINITY;
      int var20 = 0;
      int var21 = 0;
      int[] var22 = var45.stream().mapToInt(Integer::intValue).toArray();
      int var23 = var1 * Math.max(1, (var22.length + 128 - 1) / 128);
      double[] var24 = new double[71];
      double[] var25 = new double[71];
      double[] var26 = new double[71];
      double[] var27 = new double[var46.h1];
      double[] var28 = new double[var46.h2];
      double[] var29 = new double[11];
      double[] var30 = new double[11];
      double[] var31 = new double[var46.h1];
      double[] var32 = new double[var46.h2];
      ArrayList var33 = new ArrayList();
      var4.epochs = var1;

      for (int var34 = 0; var34 < var1; var34++) {
         if (var4.cancel) {
            throw new tmt(a.c(-2081091724, "༑皢ﱾ戂\ue9d3潫"));
         }

         var4.phase = a.c(-2034429023, "Ꮙ橱\ue0a0绅");
         var4.epoch = var34;
         tsf(var22, var5);

         for (short var35 = 0; var35 < var22.length; var35 += 128) {
            Arrays.fill(var47, 0.0);
            int var36 = Math.min(var22.length, var35 + 128);
            double var37 = 0.0;

            for (int var39 = var35; var39 < var36; var39++) {
               int var40 = var22[var39];
               boolean var41 = var5.nextBoolean();
               tsa(var0, var40, var24);
               int var42 = var0.move[var40];
               if (var41) {
                  trj.mirror(var24, 0, var25, 0);
                  System.arraycopy(var25, 0, var24, 0, 71);
                  var42 = trj.MIRROR[var42];
               }

               var12.normalize(var24, 0, var26);
               var46.forward(var26, var27, var28, var29);
               double var43 = var0.weight[var40];
               var37 += var43;
               tsb(var29, var42, var0.jump[var40], var0.sprint[var40], var43, var30);
               var46.backward(var26, var27, var28, var30, var47, null, var31, var32);
            }

            if (!(var37 <= 0.0)) {
               double var52 = 0.0;

               for (int var54 = 0; var54 < var47.length; var54++) {
                  var47[var54] /= var37;
                  var52 += var47[var54] * var47[var54];
               }

               var52 = Math.sqrt(var52);
               if (var52 > 5.0) {
                  for (int var55 = 0; var55 < var47.length; var55++) {
                     var47[var55] *= 5.0 / var52;
                  }
               }

               var21++;
               double var56 = Math.min(1.0, var21 / 100.0);
               double var57 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)var21 / var23)));
               tse(var46.p, var47, var48, var16, var21, (2.0E-4 + 0.0018 * var57) * var56);
            }
         }

         double var50 = tsc(var0, var10, var12, null);
         var33.add((float)var50);
         var4.curve = tsg(var33);
         if (var50 < var18 - 1.0E-4) {
            var18 = var50;
            System.arraycopy(var46.p, 0, var17, 0, var17.length);
            var20 = 0;
         } else if (var34 >= 6) {
            if (++var20 >= 5) {
               break;
            }
         }
      }

      System.arraycopy(var17, 0, var46.p, 0, var17.length);
      trm var49 = new trm();
      var49.legs = var12;
      double[] var51 = new double[4];
      tsc(var0, var10, var12, var51);
      var49.accuracy = var51[0];
      var49.baseline = var51[1];
      var49.jumpAcc = var51[2];
      var49.sprintAcc = var51[3];
      var49.samples = var6;
      return var49;
   }

   static void tsa(trp var0, int var1, double[] var2) {
      for (int var3 = 0; var3 < 71; var3++) {
         var2[var3] = var0.x[var1 * 71 + var3];
      }
   }

   static void tsb(double[] var0, int var1, boolean var2, boolean var3, double var4, double[] var6) {
      double var7 = Double.NEGATIVE_INFINITY;

      for (int var9 = 0; var9 < 9; var9++) {
         var7 = Math.max(var7, var0[var9]);
      }

      double var15 = 0.0;

      for (int var11 = 0; var11 < 9; var11++) {
         var15 += Math.exp(var0[var11] - var7);
      }

      for (int var16 = 0; var16 < 9; var16++) {
         var6[var16] = var4 * (Math.exp(var0[var16] - var7) / var15 - (var16 == var1 ? 1.0 : 0.0));
      }

      double var17 = 1.0 / (1.0 + Math.exp(-var0[9]));
      double var13 = 1.0 / (1.0 + Math.exp(-var0[10]));
      var6[9] = 0.5 * var4 * (var17 - (var2 ? 1.0 : 0.0));
      var6[10] = 0.5 * var4 * (var13 - (var3 ? 1.0 : 0.0));
   }

   static double tsc(trp var0, List<Integer> var1, trj var2, double[] var3) {
      tbx var4 = var2.net;
      double[] var5 = new double[71];
      double[] var6 = new double[71];
      double[] var7 = new double[var4.h1];
      double[] var8 = new double[var4.h2];
      double[] var9 = new double[11];
      double var10 = 0.0;
      double var12 = 0.0;
      int var14 = 0;
      int var15 = 0;
      int var16 = 0;
      int[] var17 = new int[9];

      for (int var19 : var1) {
         tsa(var0, var19, var5);
         var2.normalize(var5, 0, var6);
         var4.forward(var6, var7, var8, var9);
         double var20 = Double.NEGATIVE_INFINITY;
         int var22 = 0;

         for (int var23 = 0; var23 < 9; var23++) {
            if (var9[var23] > var20) {
               var20 = var9[var23];
               var22 = var23;
            }
         }

         double var32 = 0.0;

         for (int var25 = 0; var25 < 9; var25++) {
            var32 += Math.exp(var9[var25] - var20);
         }

         int var34 = var0.move[var19];
         double var26 = var0.weight[var19];
         var10 += var26 * -(var9[var34] - var20 - Math.log(var32));
         var12 += var26;
         if (var22 == var34) {
            var14++;
         }

         var17[var34]++;
         if (var9[9] > 0.0 == var0.jump[var19]) {
            var15++;
         }

         if (var9[10] > 0.0 == var0.sprint[var19]) {
            var16++;
         }
      }

      if (var3 != null) {
         int var28 = Math.max(1, var1.size());
         int var29 = 0;

         for (int var33 : var17) {
            var29 = Math.max(var29, var33);
         }

         var3[0] = 100.0 * var14 / var28;
         var3[1] = 100.0 * var29 / var28;
         var3[2] = 100.0 * var15 / var28;
         var3[3] = 100.0 * var16 / var28;
      }

      return var12 <= 0.0 ? Double.NaN : var10 / var12;
   }

   static boolean[] tsd(trp var0, List<Integer> var1, trj var2) {
      byte var3 = 71;
      double[] var4 = new double[var3];
      double[] var5 = new double[var3];

      for (int var7 : var1) {
         for (int var8 = 0; var8 < var3; var8++) {
            double var9 = var0.x[var7 * var3 + var8];
            var4[var8] += var9;
            var5[var8] += var9 * var9;
         }
      }

      int var13 = Math.max(1, var1.size());
      boolean[] var14 = new boolean[var3];

      for (int var15 = 0; var15 < var3; var15++) {
         double var16 = var4[var15] / var13;
         double var11 = var5[var15] / var13 - var16 * var16;
         var14[var15] = var11 < 1.0E-6;
         var2.mu[var15] = var16;
         var2.sd[var15] = var14[var15] ? 1.0 : Math.sqrt(Math.max(var11, 1.0E-4));
      }

      return var14;
   }

   static void tse(double[] var0, double[] var1, double[] var2, double[] var3, int var4, double var5) {
      double var7 = 0.9;
      double var9 = 0.999;
      double var11 = 1.0 - Math.pow(var7, var4);
      double var13 = 1.0 - Math.pow(var9, var4);

      for (int var15 = 0; var15 < var0.length; var15++) {
         var2[var15] = var7 * var2[var15] + (1.0 - var7) * var1[var15];
         var3[var15] = var9 * var3[var15] + (1.0 - var9) * var1[var15] * var1[var15];
         var0[var15] -= var5 * (var2[var15] / var11 / (Math.sqrt(var3[var15] / var13) + 1.0E-8) + 1.0E-4 * var0[var15]);
      }
   }

   static void tsf(int[] var0, Random var1) {
      for (int var2 = var0.length - 1; var2 > 0; var2--) {
         int var3 = var1.nextInt(var2 + 1);
         int var4 = var0[var2];
         var0[var2] = var0[var3];
         var0[var3] = var4;
      }
   }

   static float[] tsg(List<Float> var0) {
      float[] var1 = new float[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (Float)var0.get(var2);
      }

      return var1;
   }
}
