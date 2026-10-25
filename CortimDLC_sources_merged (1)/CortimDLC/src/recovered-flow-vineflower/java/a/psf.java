package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class psf {
   static final AtomicLong psg = new AtomicLong();
   static final double psh = 0.25;
   static final double psi = 0.32;
   static final byte psj = 0;
   public final long id = psg.incrementAndGet();
   public final List<BlockPos> nodes;
   public final tvt track;
   public final int[] nodeAt;
   public final BlockPos goal;
   public final boolean direct;

   psf(List<BlockPos> var1, tvt var2, int[] var3, BlockPos var4, boolean var5) {
      this.nodes = var1;
      this.track = var2;
      this.nodeAt = var3;
      this.goal = var4;
      this.direct = var5;
   }

   public Vec3d end() {
      int var1 = this.track.n - 1;
      return new Vec3d(this.track.x[var1], this.track.y[var1], this.track.z[var1]);
   }

   public int nodeIndex(int var1) {
      return this.nodes.isEmpty() ? 0 : this.nodeAt[Math.max(0, Math.min(this.nodeAt.length - 1, var1))];
   }

   public static psf of(World var0, Entity var1, Vec3d var2, List<BlockPos> var3, BlockPos var4, psc var5, prz var6, Random var7) {
      if (var3 != null && !var3.isEmpty() && var0 != null) {
         prw var8 = new prw(var0, var1, var6);
         ArrayList var9 = new ArrayList();
         var9.add(new double[]{var2.x, psm(var0, var2), var2.z});

         for (BlockPos var11 : var3) {
            var9.add(new double[]{var11.getX() + 0.5, pqx.getStandY(var0, var11), var11.getZ() + 0.5});
         }

         ArrayList var20 = new ArrayList();
         ArrayList var21 = new ArrayList();
         ArrayList var12 = new ArrayList();
         var12.add((double[])var9.get(0));

         for (int var13 = 0; var13 + 1 < var9.size(); var13++) {
            double[] var14 = (double[])var9.get(var13);
            double[] var15 = (double[])var9.get(var13 + 1);
            double var16 = var15[1] - var14[1];
            boolean var18 = pua.water(var0, var14[0], var14[1], var14[2]) || pua.water(var0, var15[0], var15[1], var15[2]);
            int var19 = var18 ? 0 : (var16 > 0.601 ? 1 : (var16 < -0.601 ? 2 : 0));
            if (var19 == 0) {
               var12.add(var15);
            } else {
               var20.add(var12);
               var21.add(Byte.valueOf((byte)var19));
               var12 = new ArrayList();
               var12.add(var15);
            }
         }

         var20.add(var12);

         for (int var22 = 0; var22 < var20.size(); var22++) {
            List var23 = (List)var20.get(var22);
            List var24 = psn(var8, var23, var5.wide);
            List var25 = pso(var8, var24, var5.radius, var7);
            psp(var8, var25, var5.wobble, var7);
            if (var22 < var21.size()) {
               double[] var17 = (double[])var23.get(var23.size() - 1);
               double[] var26 = (double[])((List)var20.get(var22 + 1)).get(0);
               if (var24.size() > 0) {
                  var17 = new double[]{var8.xs.get(var8.xs.size() - 1), var8.ys.get(var8.ys.size() - 1), var8.zs.get(var8.zs.size() - 1)};
               }

               psr(var8, var17, var26, (Byte)var21.get(var22));
            }
         }

         return pss(var8, var3, var4, false);
      } else {
         return null;
      }
   }

   public static psf direct(World var0, Entity var1, Vec3d var2, Vec3d var3) {
      if (var0 == null) {
         return null;
      }

      prw var4 = new prw(var0, var1, new prz());
      double var5 = var3.x - var2.x;
      double var7 = var3.z - var2.z;
      double var9 = Math.hypot(var5, var7);
      double var11 = psm(var0, var2);
      var4.add(var2.x, var11, var2.z, (byte)0);
      int var13 = Math.max(1, (int)Math.ceil(var9 / 0.25));
      double var14 = var11;

      for (int var16 = 1; var16 <= var13; var16++) {
         double var17 = (double)var16 / var13;
         double var19 = var2.x + var5 * var17;
         double var21 = var2.z + var7 * var17;
         double var23 = pua.standAt(var0, var19, var14 + 0.6 + 0.65, var21, 2.5);
         byte var25 = 0;
         if (Double.isNaN(var23)) {
            var23 = var14;
         } else if (var23 - var14 > 0.601) {
            var25 = 1;
         } else if (var14 - var23 > 0.601) {
            var25 = 2;
         }

         if (pua.water(var0, var19, var23, var21)) {
            var25 = (byte)(var25 | 4);
         }

         var4.add(var19, var23, var21, var25);
         var14 = var23;
      }

      return pss(var4, List.of(), BlockPos.ofFloored(var3), true);
   }

   static double psm(World var0, Vec3d var1) {
      double var2 = pua.standAt(var0, var1.x, var1.y + 0.01, var1.z, 3.0);
      return Double.isNaN(var2) ? var1.y : var2;
   }

   static List<double[]> psn(prw var0, List<double[]> var1, double var2) {
      ArrayList var4 = new ArrayList();
      if (var1.isEmpty()) {
         return var4;
      }

      var4.add((double[])var1.get(0));
      int var5 = 0;
      int var6 = var1.size() - 1;

      while (var5 < var6) {
         int var7 = var5 + 1;
         boolean var8 = false;

         for (double var12 : new double[]{var2, 0.32}) {
            for (int var14 = Math.min(var6, var5 + 22); var14 > var5 + 1; var14--) {
               if (var0.clear((double[])var1.get(var5), (double[])var1.get(var14), var12)) {
                  var7 = var14;
                  var8 = true;
                  break;
               }
            }

            if (var8) {
               break;
            }
         }

         var4.add((double[])var1.get(var7));
         var5 = var7;
      }

      return var4;
   }

   static List<double[]> pso(prw var0, List<double[]> var1, double var2, Random var4) {
      if (var1.size() < 3) {
         return var1;
      }

      ArrayList var5 = new ArrayList();
      var5.add((double[])var1.get(0));
      double[] var6 = (double[])var1.get(0);

      for (int var7 = 1; var7 + 1 < var1.size(); var7++) {
         double[] var8 = (double[])var1.get(var7);
         double[] var9 = (double[])var1.get(var7 + 1);
         double var10 = var8[0] - var6[0];
         double var12 = var8[2] - var6[2];
         double var14 = var9[0] - var8[0];
         double var16 = var9[2] - var8[2];
         double var18 = Math.hypot(var10, var12);
         double var20 = Math.hypot(var14, var16);
         if (!(var18 < 0.001) && !(var20 < 0.001)) {
            var10 /= var18;
            var12 /= var18;
            var14 /= var20;
            var16 /= var20;
            double var22 = Math.max(-1.0, Math.min(1.0, var10 * var14 + var12 * var16));
            double var24 = Math.acos(var22);
            if (var24 < 0.14) {
               var5.add(var8);
               var6 = var8;
            } else {
               double var26 = var2 * (0.75 + var4.nextDouble() * 0.5);
               double var28 = Math.min(Math.min(var18 * 0.48, var20 * 0.48), Math.min(3.2, var26 * Math.tan(var24 * 0.5)));
               boolean var30 = false;

               for (int var31 = 0; var31 < 4 && var28 > 0.2; var31++) {
                  double[] var32 = new double[]{var8[0] - var10 * var28, var8[1], var8[2] - var12 * var28};
                  double[] var33 = new double[]{var8[0] + var14 * var28, var8[1], var8[2] + var16 * var28};
                  int var34 = Math.max(3, (int)Math.ceil(var28 * 2.0 * var24 / 0.5));
                  ArrayList var35 = new ArrayList();
                  var35.add(var32);
                  double var36 = var8[1];
                  boolean var38 = true;

                  for (int var39 = 1; var39 <= var34; var39++) {
                     double var40 = (double)var39 / var34;
                     double var42 = (1.0 - var40) * (1.0 - var40);
                     double var44 = 2.0 * var40 * (1.0 - var40);
                     double var46 = var40 * var40;
                     double var48 = var42 * var32[0] + var44 * var8[0] + var46 * var33[0];
                     double var50 = var42 * var32[2] + var44 * var8[2] + var46 * var33[2];
                     double[] var52 = new double[]{var48, var36, var50};
                     if (!var0.clear((double[])var35.get(var35.size() - 1), var52, 0.32)) {
                        var38 = false;
                        break;
                     }

                     double var53 = pua.standAt(var0.world, var48, var36, var50, 0.6);
                     var52[1] = Double.isNaN(var53) ? var36 : var53;
                     var36 = var52[1];
                     var35.add(var52);
                  }

                  if (var38) {
                     var5.addAll(var35);
                     var6 = (double[])var35.get(var35.size() - 1);
                     var30 = true;
                     break;
                  }

                  var28 *= 0.55;
               }

               if (!var30) {
                  var5.add(var8);
                  var6 = var8;
               }
            }
         } else {
            var5.add(var8);
            var6 = var8;
         }
      }

      var5.add((double[])var1.get(var1.size() - 1));
      return var5;
   }

   static void psp(prw var0, List<double[]> var1, double var2, Random var4) {
      ArrayList var5 = new ArrayList();
      var5.add((double[])var1.get(0));

      for (int var6 = 0; var6 + 1 < var1.size(); var6++) {
         double[] var7 = (double[])var1.get(var6);
         double[] var8 = (double[])var1.get(var6 + 1);
         double var9 = Math.hypot(var8[0] - var7[0], var8[2] - var7[2]);
         int var11 = Math.max(1, (int)Math.ceil(var9 / 0.25));
         double var12 = var7[1];

         for (int var14 = 1; var14 <= var11; var14++) {
            double var15 = (double)var14 / var11;
            double var17 = var7[0] + (var8[0] - var7[0]) * var15;
            double var19 = var7[2] + (var8[2] - var7[2]) * var15;
            double var21 = pua.standAt(var0.world, var17, var12, var19, 0.6);
            if (Double.isNaN(var21)) {
               var21 = var7[1] + (var8[1] - var7[1]) * var15;
            }

            var5.add(new double[]{var17, var21, var19});
            var12 = var21;
         }
      }

      int var27 = var5.size();
      double[] var28 = new double[var27];
      if (var2 > 0.01 && var27 > 12) {
         double var29 = (var27 - 1) * 0.25;
         double var10 = var2 * (0.6 + var4.nextDouble() * 0.8);
         double var37 = 7.0 + var4.nextDouble() * 6.0;
         double var39 = 3.5 + var4.nextDouble() * 2.5;
         double var16 = var4.nextDouble() * Math.PI * 2.0;
         double var18 = var4.nextDouble() * Math.PI * 2.0;
         double[] var20 = new double[var27];
         Arrays.fill(var20, 1.0);

         for (int var40 = 0; var40 < var27; var40++) {
            double var22 = var40 * 0.25;
            double var24 = Math.min(1.0, Math.min(var22 / 2.0, (var29 - var22) / 2.0));
            var28[var40] = var10
               * Math.max(0.0, var24)
               * (0.65 * Math.sin((Math.PI * 2) * var22 / var37 + var16) + 0.35 * Math.sin((Math.PI * 2) * var22 / var39 + var18));
         }

         for (int var41 = 1; var41 + 1 < var27; var41++) {
            double[] var43 = psq(var5, var41, var28[var41]);
            if (var43 == null || !var0.fits(var43[0], var43[1], var43[2])) {
               for (int var23 = Math.max(0, var41 - 5); var23 <= Math.min(var27 - 1, var41 + 5); var23++) {
                  var20[var23] = 0.0;
               }
            }
         }

         double[] var42 = new double[var27];

         for (int var44 = 0; var44 < var27; var44++) {
            double var46 = 0.0;
            int var25 = 0;

            for (int var26 = Math.max(0, var44 - 3); var26 <= Math.min(var27 - 1, var44 + 3); var26++) {
               var46 += var20[var26];
               var25++;
            }

            var42[var44] = var20[var44] == 0.0 ? 0.0 : var46 / var25;
         }

         for (int var45 = 0; var45 < var27; var45++) {
            var28[var45] *= var42[var45];
         }
      }

      ArrayList var30 = new ArrayList(var27);

      for (int var31 = 0; var31 < var27; var31++) {
         double[] var33 = var31 != 0 && var31 != var27 - 1 ? psq(var5, var31, var28[var31]) : (double[])var5.get(var31);
         var30.add(var33 == null ? (double[])var5.get(var31) : var33);
      }

      boolean var32 = true;

      for (int var34 = 1; var34 < var27 && var32; var34++) {
         if (var28[var34] != 0.0 || var28[var34 - 1] != 0.0) {
            var32 = var0.clear((double[])var30.get(var34 - 1), (double[])var30.get(var34), 0.32);
         }
      }

      for (double[] var38 : var32 ? var30 : var5) {
         int var13 = pua.water(var0.world, var38[0], var38[1], var38[2]) ? 4 : 0;
         var0.add(var38[0], var38[1], var38[2], (byte)var13);
      }
   }

   static double[] psq(List<double[]> var0, int var1, double var2) {
      if (var2 == 0.0) {
         return (double[])var0.get(var1);
      }

      double[] var4 = (double[])var0.get(Math.max(0, var1 - 1));
      double[] var5 = (double[])var0.get(Math.min(var0.size() - 1, var1 + 1));
      double var6 = var5[0] - var4[0];
      double var8 = var5[2] - var4[2];
      double var10 = Math.hypot(var6, var8);
      if (var10 < 1.0E-4) {
         return null;
      }

      double var12 = -var8 / var10;
      double var14 = var6 / var10;
      double[] var16 = (double[])var0.get(var1);
      return new double[]{var16[0] + var12 * var2, var16[1], var16[2] + var14 * var2};
   }

   static void psr(prw var0, double[] var1, double[] var2, byte var3) {
      double var4 = var2[0] - var1[0];
      double var6 = var2[2] - var1[2];
      double var8 = Math.hypot(var4, var6);
      int var10 = Math.max(2, (int)Math.ceil(var8 / 0.25));
      boolean var11 = false;

      for (int var12 = 1; var12 <= var10; var12++) {
         double var13 = (double)var12 / var10;
         double var15 = var1[0] + var4 * var13;
         double var17 = var1[2] + var6 * var13;
         double var19;
         if (var3 == 1) {
            double var21 = pua.standAt(var0.world, var15, var2[1], var17, 0.4);
            var19 = !Double.isNaN(var21) && var21 > var1[1] + 0.6 ? var21 : var1[1];
         } else {
            double var23 = pua.standAt(var0.world, var15, var1[1], var17, 0.4);
            var19 = !Double.isNaN(var23) ? var23 : var2[1];
         }

         if (var12 == var10) {
            var19 = var2[1];
         }

         byte var24 = 0;
         boolean var22 = var3 == 1 ? var19 > var1[1] + 0.6 : var19 < var1[1] - 0.6;
         if (var22) {
            var24 = var3;
            var11 = true;
         } else if (!var11 && var12 == var10) {
            var24 = var3;
         }

         var0.add(var15, var19, var17, var24);
      }
   }

   static psf pss(prw var0, List<BlockPos> var1, BlockPos var2, boolean var3) {
      int var4 = var0.xs.size();
      if (var4 < 2) {
         return null;
      }

      float[] var5 = new float[var4];
      float[] var6 = new float[var4];
      float[] var7 = new float[var4];
      byte[] var8 = new byte[var4];

      for (int var9 = 0; var9 < var4; var9++) {
         var5[var9] = (float)var0.xs.get(var9).doubleValue();
         var6[var9] = (float)var0.ys.get(var9).doubleValue();
         var7[var9] = (float)var0.zs.get(var9).doubleValue();
         var8[var9] = var0.fs.get(var9);
      }

      tvt var13 = new tvt(var5, var6, var7, var8);
      int[] var10 = new int[var4];
      if (!var1.isEmpty()) {
         int var11 = 0;

         for (int var12 = 0; var12 < var4; var12++) {
            while (
               var11 + 1 < var1.size()
                  && pst((BlockPos)var1.get(var11 + 1), var5[var12], var7[var12]) <= pst((BlockPos)var1.get(var11), var5[var12], var7[var12])
            ) {
               var11++;
            }

            var10[var12] = var11;
         }
      }

      return new psf(var1, var13, var10, var2, var3);
   }

   static double pst(BlockPos var0, double var1, double var3) {
      double var5 = var0.getX() + 0.5 - var1;
      double var7 = var0.getZ() + 0.5 - var3;
      return var5 * var5 + var7 * var7;
   }
}
