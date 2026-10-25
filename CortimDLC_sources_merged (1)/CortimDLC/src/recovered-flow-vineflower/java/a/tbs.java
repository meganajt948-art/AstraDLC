package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class tbs {
   private tbs() {
   }

   static void score(tck var0, List<tmn> var1, Random var2) {
      score(var0, var1, var2, new taf());
   }

   static void score(tck var0, List<tmn> var1, Random var2, taf var3) {
      tai var4 = new tai(var0, var2);
      byte var5 = 32;
      double[] var6 = new double[var5];
      double[] var7 = new double[2];
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();
      ArrayList var10 = new ArrayList();
      ArrayList var11 = new ArrayList();
      ArrayList var12 = new ArrayList();
      double var13 = 0.0;
      double var15 = 0.0;
      double var17 = 0.0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;

      for (tmn var23 : var1) {
         double[] var24 = var23.seg().st;
         int var25 = var23.from();
         int var26 = var23.to();
         int var27 = var26 - var25;
         double[] var28 = new double[(var27 + 1) * var5];
         System.arraycopy(var24, var25 * var5, var28, 0, var28.length);
         var4.reset();

         for (int var29 = 3; var29 >= 0; var29--) {
            var4.history(var24[var25 * var5 + 14 + var29 * 2], var24[var25 * var5 + 15 + var29 * 2]);
         }

         var4.prime(var24[var25 * var5 + 14], var24[var25 * var5 + 15]);
         tmz var49 = new tmz(var27);
         var49.ex[0] = var24[var25 * var5 + 0];
         var49.ey[0] = var24[var25 * var5 + 1];
         double var30 = 0.0;
         double var32 = 0.0;
         int var34 = var27 + 1;
         int var35 = var27 + 1;

         for (int var36 = 0; var36 < var27; var36++) {
            int var37 = var25 + var36;
            var49.state(var23.seg(), var25, var36, var6);
            var4.step(var6, var3, var7);
            var4.history(var7[0], var7[1]);
            int var38 = (var37 + 1) * var5;
            double var39 = var49.ex[var36] + var24[var38 + 6] - var7[0];
            double var41 = var49.ey[var36] + var24[var38 + 7] - var7[1];
            var49.ex[var36 + 1] = var39;
            var49.ey[var36 + 1] = var41;
            int var43 = (var36 + 1) * var5;
            var28[var43 + 0] = var39;
            var28[var43 + 1] = var41;
            var28[var43 + 14] = var7[0];
            var28[var43 + 15] = var7[1];
            double var44 = Math.hypot(var7[0], var7[1]);
            double var46 = Math.hypot(var24[var38 + 14], var24[var38 + 15]);
            var30 = Math.max(var30, var44);
            var32 = Math.max(var32, var46);
            var12.add(var44);
            var11.add(var46);
            if (var34 > var27 && tbv(var28, var43, var39, var41)) {
               var34 = var36 + 1;
            }

            if (var35 > var27 && tbv(var24, var38, var24[var38 + 0], var24[var38 + 1])) {
               var35 = var36 + 1;
            }
         }

         if (szk.overshootCount(var28, var27) > 0) {
            var19++;
         }

         double[] var50 = new double[(var27 + 1) * var5];
         System.arraycopy(var24, var25 * var5, var50, 0, var50.length);
         if (szk.overshootCount(var50, var27) > 0) {
            var20++;
         }

         if (var32 > 0.5) {
            var8.add(Math.max(0.001, var30) / var32);
         }

         var9.add(var32);
         var10.add(var30);
         var13 += Math.abs(var34 - var35);
         var15 += var35;
         var17 += var34;
         var21++;
      }

      if (var21 != 0) {
         double var48 = var8.isEmpty() ? 1.0 : tnl.quantile(var8, 0.5);
         var0.speedMatch = Math.exp(-2.5 * Math.abs(Math.log(var48)));
         var0.timeMatch = Math.exp(-(var13 / var21) / 4.0);
         var0.shapeMatch = 1.0 - tbw(var11, var12);
         var0.similarity = 100.0 * (0.35 * var0.speedMatch + 0.35 * var0.timeMatch + 0.3 * var0.shapeMatch);
         var0.overshootModel = (double)var19 / var21;
         var0.overshootUser = (double)var20 / var21;
         var0.userPeak = tnl.quantile(var9, 0.5);
         var0.modelPeak = tnl.quantile(var10, 0.5);
         var0.userEntry = var15 / var21;
         var0.modelEntry = var17 / var21;
      }
   }

   private static boolean tbv(double[] var0, int var1, double var2, double var4) {
      double var6 = -var2;
      double var8 = -var4;
      return var6 >= var0[var1 + 28] && var6 <= var0[var1 + 29] && var8 >= var0[var1 + 30] && var8 <= var0[var1 + 31];
   }

   private static double tbw(List<Double> var0, List<Double> var1) {
      if (!var0.isEmpty() && !var1.isEmpty()) {
         double[] var2 = new double[var0.size()];
         double[] var3 = new double[var1.size()];

         for (int var4 = 0; var4 < var2.length; var4++) {
            var2[var4] = (Double)var0.get(var4);
         }

         for (int var10 = 0; var10 < var3.length; var10++) {
            var3[var10] = (Double)var1.get(var10);
         }

         Arrays.sort(var2);
         Arrays.sort(var3);
         int var11 = 0;
         int var5 = 0;

         double var6;
         for (var6 = 0.0; var11 < var2.length && var5 < var3.length; var6 = Math.max(var6, Math.abs((double)var11 / var2.length - (double)var5 / var3.length))) {
            double var8 = Math.min(var2[var11], var3[var5]);

            while (var11 < var2.length && var2[var11] <= var8) {
               var11++;
            }

            while (var5 < var3.length && var3[var5] <= var8) {
               var5++;
            }
         }

         return var6;
      } else {
         return 1.0;
      }
   }
}
