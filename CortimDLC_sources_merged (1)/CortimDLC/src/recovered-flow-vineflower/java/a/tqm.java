package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class tqm {
   private static final int tqn = 32;
   private static final double tqo = 0.003;
   private static final double tqp = 3.0E-4;
   private static final double tqq = 1.0E-4;
   private static final double tqr = 5.0;

   private tqm() {
   }

   public static tqj train(List<tqg> var0, int var1, int var2, long var3, tmw var5) {
      Random var6 = new Random(var3);
      ArrayList var7 = new ArrayList(var0);
      Collections.shuffle(var7, var6);
      int var8 = var7.size() >= 60 ? Math.max(12, var7.size() * 15 / 100) : 0;
      ArrayList var9 = new ArrayList(var7.subList(0, var8));
      ArrayList var10 = new ArrayList(var7.subList(var8, var7.size()));
      if (var9.isEmpty()) {
         var9 = var10;
      }

      tqa var11 = new tqa(32, var1);
      boolean[] var12 = tqu(var10, var11);
      var11.init(var6);

      for (int var13 = 0; var13 < var12.length; var13++) {
         if (var12[var13]) {
            var11.silence(var13);
         }
      }

      List var39 = tqv(var10, var11);
      List var14 = tqv(var9, var11);
      double[] var15 = new double[var11.p.length];
      double[] var16 = new double[var11.p.length];
      double[] var17 = new double[var11.p.length];
      tqa var18 = var11.copy();
      double var19 = Double.POSITIVE_INFINITY;
      int var21 = 0;
      int var22 = 0;
      int var23 = Math.max(1, (var10.size() + 32 - 1) / 32);
      int var24 = var2 * var23;
      ArrayList var25 = new ArrayList();
      int[] var26 = new int[var10.size()];
      int var27 = 0;

      while (var27 < var26.length) {
         var26[var27] = var27++;
      }

      var27 = 0;
      var5.epochs = var2;

      for (int var28 = 0; var28 < var2; var28++) {
         if (var5.cancel) {
            throw new tmt(a.b("ꅼ\ud8cf刓챯䞾섆", 1348706585));
         }

         var5.phase = a.b("僾⥟ꎟ㷦똶", -105688935);
         var5.epoch = var28;
         tqy(var26, var6);

         for (byte var29 = 0; var29 < var26.length; var29 += 32) {
            Arrays.fill(var15, 0.0);
            int var30 = Math.min(var26.length, var29 + 32);
            double var31 = 0.0;

            for (int var33 = var29; var33 < var30; var33++) {
               tqg var34 = (tqg)var10.get(var26[var33]);
               tqw(var11, var34, (double[])var39.get(var26[var33]), var15);
               var31 += var34.weight;
            }

            if (!(var31 <= 0.0)) {
               double var44 = 0.0;

               for (int var35 = 0; var35 < var15.length; var35++) {
                  var15[var35] /= var31;
                  var44 += var15[var35] * var15[var35];
               }

               var44 = Math.sqrt(var44);
               if (var44 > 5.0) {
                  for (int var46 = 0; var46 < var15.length; var46++) {
                     var15[var46] *= 5.0 / var44;
                  }
               }

               var22++;
               double var47 = Math.min(1.0, var22 / 50.0);
               double var37 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)var22 / var24)));
               tqx(var11.p, var15, var16, var17, var22, (3.0E-4 + 0.0027 * var37) * var47);
            }
         }

         double var42 = evaluate(var11, var9, var14, null);
         var25.add((float)var42);
         var5.curve = tqz(var25);
         var27 = var28 + 1;
         if (var42 < var19 - 1.0E-4) {
            var19 = var42;
            var18 = var11.copy();
            var21 = 0;
         } else if (var28 >= 10) {
            if (++var21 >= 8) {
               break;
            }
         }
      }

      tqj var41 = new tqj();
      var41.net = var18;
      double[] var43 = new double[4];
      var41.nll = evaluate(var18, var9, var14, var43);
      var41.top1 = var43[0];
      var41.top3 = var43[1];
      var41.base1 = var43[2];
      var41.trainEvents = var10.size();
      var41.valEvents = var8;
      var41.epochs = var27;
      return var41;
   }

   private static boolean[] tqu(List<tqg> var0, tqa var1) {
      byte var2 = 32;
      double[] var3 = new double[var2];
      double[] var4 = new double[var2];
      long var5 = 0L;

      for (tqg var8 : var0) {
         for (int var9 = 0; var9 < var8.n; var9++) {
            for (int var10 = 0; var10 < var2; var10++) {
               double var11 = var8.f[var9 * var2 + var10];
               var3[var10] += var11;
               var4[var10] += var11 * var11;
            }

            var5++;
         }
      }

      boolean[] var13 = new boolean[var2];

      for (int var14 = 0; var14 < var2; var14++) {
         double var15 = var5 == 0L ? 0.0 : var3[var14] / var5;
         double var16 = var5 == 0L ? 0.0 : var4[var14] / var5 - var15 * var15;
         var1.mu[var14] = var15;
         var13[var14] = var16 < 1.0E-6;
         var1.sd[var14] = var13[var14] ? 1.0 : Math.sqrt(Math.max(var16, 1.0E-4));
      }

      return var13;
   }

   private static List<double[]> tqv(List<tqg> var0, tqa var1) {
      ArrayList var2 = new ArrayList(var0.size());

      for (tqg var4 : var0) {
         double[] var5 = new double[var4.n * 32];

         for (int var6 = 0; var6 < var4.n; var6++) {
            var1.normalize(var4.f, var6 * 32, var5, var6 * 32);
         }

         var2.add(var5);
      }

      return var2;
   }

   private static void tqw(tqa var0, tqg var1, double[] var2, double[] var3) {
      int var4 = var1.n;
      double[][] var5 = new double[var4][var0.hidden];
      double[] var6 = new double[var4];
      double var7 = Double.NEGATIVE_INFINITY;

      for (int var9 = 0; var9 < var4; var9++) {
         var6[var9] = var0.forward(var2, var9 * 32, var5[var9]);
         var7 = Math.max(var7, var6[var9]);
      }

      double var14 = 0.0;

      for (int var11 = 0; var11 < var4; var11++) {
         var6[var11] = Math.exp(var6[var11] - var7);
         var14 += var6[var11];
      }

      for (int var15 = 0; var15 < var4; var15++) {
         double var12 = var1.weight * (var6[var15] / var14 - (var15 == var1.chosen ? 1.0 : 0.0));
         if (Math.abs(var12) > 1.0E-7) {
            var0.backward(var2, var15 * 32, var5[var15], var12, var3);
         }
      }
   }

   static double evaluate(tqa var0, List<tqg> var1, List<double[]> var2, double[] var3) {
      double var4 = 0.0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      double[] var9 = new double[var0.hidden];

      for (int var10 = 0; var10 < var1.size(); var10++) {
         tqg var11 = (tqg)var1.get(var10);
         double[] var12 = (double[])var2.get(var10);
         double[] var13 = new double[var11.n];
         double var14 = Double.NEGATIVE_INFINITY;

         for (int var16 = 0; var16 < var11.n; var16++) {
            var13[var16] = var0.forward(var12, var16 * 32, var9);
            var14 = Math.max(var14, var13[var16]);
         }

         double var21 = 0.0;

         for (int var18 = 0; var18 < var11.n; var18++) {
            var21 += Math.exp(var13[var18] - var14);
         }

         var4 += -(var13[var11.chosen] - var14 - Math.log(var21));
         int var22 = 0;

         for (int var19 = 0; var19 < var11.n; var19++) {
            if (var19 != var11.chosen && var13[var19] > var13[var11.chosen]) {
               var22++;
            }
         }

         if (var22 == 0) {
            var6++;
         }

         if (var22 < 3) {
            var7++;
         }

         if (var11.nearest == var11.chosen) {
            var8++;
         }
      }

      int var20 = Math.max(1, var1.size());
      if (var3 != null) {
         var3[0] = 100.0 * var6 / var20;
         var3[1] = 100.0 * var7 / var20;
         var3[2] = 100.0 * var8 / var20;
      }

      return var4 / var20;
   }

   private static void tqx(double[] var0, double[] var1, double[] var2, double[] var3, int var4, double var5) {
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

   private static void tqy(int[] var0, Random var1) {
      for (int var2 = var0.length - 1; var2 > 0; var2--) {
         int var3 = var1.nextInt(var2 + 1);
         int var4 = var0[var2];
         var0[var2] = var0[var3];
         var0[var3] = var4;
      }
   }

   private static float[] tqz(List<Float> var0) {
      float[] var1 = new float[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (Float)var0.get(var2);
      }

      return var1;
   }
}
