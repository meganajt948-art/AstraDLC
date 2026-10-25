package a;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Arrays;

public final class tpn {
   public static final int F = 32;
   public static final double REACH = 4.5;
   public static final int UP = 2;
   public static final int DOWN = 3;
   static final int[][] tpo = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
   static final double[][] tpp = new double[][]{{0.0, 0.0}, {0.3, 0.3}, {-0.3, 0.3}, {0.3, -0.3}, {-0.3, -0.3}};
   public int n;
   public int[] x = new int[64];
   public int[] y = new int[64];
   public int[] z = new int[64];
   public byte[] face = new byte[64];
   public double[] qx = new double[64];
   public double[] qy = new double[64];
   public double[] qz = new double[64];
   public double[] ang = new double[64];
   public double[] f = new double[2048];

   tpn() {
   }

   public int indexOf(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.n; var4++) {
         if (this.x[var4] == var1 && this.y[var4] == var2 && this.z[var4] == var3) {
            return var4;
         }
      }

      return -1;
   }

   public int nearest() {
      int var1 = -1;

      for (int var2 = 0; var2 < this.n; var2++) {
         if (var1 < 0 || this.ang[var2] < this.ang[var1]) {
            var1 = var2;
         }
      }

      return var1;
   }

   void tps() {
      int var1 = this.x.length * 2;
      this.x = Arrays.copyOf(this.x, var1);
      this.y = Arrays.copyOf(this.y, var1);
      this.z = Arrays.copyOf(this.z, var1);
      this.face = Arrays.copyOf(this.face, var1);
      this.qx = Arrays.copyOf(this.qx, var1);
      this.qy = Arrays.copyOf(this.qy, var1);
      this.qz = Arrays.copyOf(this.qz, var1);
      this.ang = Arrays.copyOf(this.ang, var1);
      this.f = Arrays.copyOf(this.f, var1 * 32);
   }

   public static tpn of(tvn var0, tra var1) {
      tpn var2 = new tpn();
      double var3 = Math.toRadians(var1.yaw);
      double var5 = Math.toRadians(var1.pitch);
      double var7 = -Math.sin(var3) * Math.cos(var5);
      double var9 = -Math.sin(var5);
      double var11 = Math.cos(var3) * Math.cos(var5);
      int var13 = (int)Math.floor(var1.ex);
      int var14 = (int)Math.floor(var1.ez);
      int var15 = (int)Math.floor(var1.ey + 4.5);

      for (int var16 = var13 - 5; var16 <= var13 + 5; var16++) {
         for (int var17 = var14 - 5; var17 <= var14 + 5; var17++) {
            for (int var18 = var1.feetY; var18 <= var15; var18++) {
               if (tpx.minable(var0.at(var16, var18, var17)) && !(tpt(var1, var16, var18, var17) > 4.5)) {
                  double var19 = Double.MAX_VALUE;
                  double var21 = 0.0;
                  double var23 = 0.0;
                  double var25 = 0.0;
                  int var27 = -1;

                  for (int var28 = 0; var28 < 6; var28++) {
                     int[] var29 = tpo[var28];
                     if (tpx.open(var0.at(var16 + var29[0], var18 + var29[1], var17 + var29[2]))) {
                        double var30 = var16 + 0.5 + var29[0] * 0.5;
                        double var32 = var18 + 0.5 + var29[1] * 0.5;
                        double var34 = var17 + 0.5 + var29[2] * 0.5;
                        if (!((var1.ex - var30) * var29[0] + (var1.ey - var32) * var29[1] + (var1.ez - var34) * var29[2] <= 0.02)) {
                           int var36 = var28 / 2;

                           for (double[] var40 : tpp) {
                              double var41 = var36 == 0 ? var30 : var30 + var40[0];
                              double var43 = var36 == 1 ? var32 : var32 + var40[1];
                              double var45 = var36 == 2 ? var34 : (var36 == 0 ? var34 + var40[0] : var34 + var40[1]);
                              double var47 = var41 - var1.ex;
                              double var49 = var43 - var1.ey;
                              double var51 = var45 - var1.ez;
                              double var53 = Math.sqrt(var47 * var47 + var49 * var49 + var51 * var51);
                              if (!(var53 > 4.5) && !(var53 < 0.3) && !(Math.sqrt(var47 * var47 + var51 * var51) < 0.25)) {
                                 double var55 = (var47 * var7 + var49 * var9 + var51 * var11) / var53;
                                 double var57 = Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, var55))));
                                 if (!(var57 >= var19)) {
                                    double var59 = 0.02 / var53;
                                    if (clear(
                                       var0,
                                       var1.ex,
                                       var1.ey,
                                       var1.ez,
                                       var41 + var47 * var59,
                                       var43 + var49 * var59,
                                       var45 + var51 * var59,
                                       var16,
                                       var18,
                                       var17,
                                       null
                                    )) {
                                       var19 = var57;
                                       var21 = var41;
                                       var23 = var43;
                                       var25 = var45;
                                       var27 = var28;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (var27 >= 0) {
                     if (var2.n == var2.x.length) {
                        var2.tps();
                     }

                     int var61 = var2.n++;
                     var2.x[var61] = var16;
                     var2.y[var61] = var18;
                     var2.z[var61] = var17;
                     var2.face[var61] = (byte)var27;
                     var2.ang[var61] = var19;
                     var2.qx[var61] = var21;
                     var2.qy[var61] = var23;
                     var2.qz[var61] = var25;
                  }
               }
            }
         }
      }

      if (var2.n > 0) {
         var2.tpw(var0, var1, var7, var11, tpv(var0, var1, var2));
      }

      return var2;
   }

   static double tpt(tra var0, int var1, int var2, int var3) {
      double var4 = Math.max(0.0, Math.max(var1 - var0.ex, var0.ex - (var1 + 1)));
      double var6 = Math.max(0.0, Math.max(var2 - var0.ey, var0.ey - (var2 + 1)));
      double var8 = Math.max(0.0, Math.max(var3 - var0.ez, var0.ez - (var3 + 1)));
      return Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
   }

   static long tpu(int var0, int var1, int var2) {
      return (long)(var0 & 67108863) << 38 | (long)(var2 & 67108863) << 12 | var1 & 4095;
   }

   static LongOpenHashSet tpv(tvn var0, tra var1, tpn var2) {
      LongOpenHashSet var3 = new LongOpenHashSet();

      for (int var4 = 0; var4 < var2.n; var4++) {
         var3.add(tpu(var2.x[var4], var2.y[var4], var2.z[var4]));
      }

      LongOpenHashSet var18 = new LongOpenHashSet();
      int var5 = (int)Math.floor(var1.ex);
      int var6 = (int)Math.floor(var1.ey);
      int var7 = (int)Math.floor(var1.ez);
      int[] var8 = new int[3];

      for (int var9 = var5 - 5; var9 <= var5 + 5; var9++) {
         for (int var10 = var7 - 5; var10 <= var7 + 5; var10++) {
            for (int var11 = var6 - 5; var11 <= var6 + 5; var11++) {
               if (tpx.target(var0.at(var9, var11, var10)) && !var3.contains(tpu(var9, var11, var10))) {
                  double var12 = var9 + 0.5 - var1.ex;
                  double var14 = var11 + 0.5 - var1.ey;
                  double var16 = var10 + 0.5 - var1.ez;
                  if (!(Math.sqrt(var12 * var12 + var14 * var14 + var16 * var16) > 5.5)
                     && !clear(var0, var1.ex, var1.ey, var1.ez, var9 + 0.5, var11 + 0.5, var10 + 0.5, var9, var11, var10, var8)
                     && tpx.minable(var0.at(var8[0], var8[1], var8[2]))) {
                     var18.add(tpu(var8[0], var8[1], var8[2]));
                  }
               }
            }
         }
      }

      return var18;
   }

   static boolean clear(tvn var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13, int var14, int var15, int[] var16) {
      double var17 = var7 - var1;
      double var19 = var9 - var3;
      double var21 = var11 - var5;
      int var23 = (int)Math.floor(var1);
      int var24 = (int)Math.floor(var3);
      int var25 = (int)Math.floor(var5);
      int var26 = var17 > 0.0 ? 1 : (var17 < 0.0 ? -1 : 0);
      int var27 = var19 > 0.0 ? 1 : (var19 < 0.0 ? -1 : 0);
      int var28 = var21 > 0.0 ? 1 : (var21 < 0.0 ? -1 : 0);
      double var29 = var26 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(var17);
      double var31 = var27 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(var19);
      double var33 = var28 == 0 ? Double.MAX_VALUE : 1.0 / Math.abs(var21);
      double var35 = var26 > 0 ? (var23 + 1 - var1) * var29 : (var26 < 0 ? (var1 - var23) * var29 : Double.MAX_VALUE);
      double var37 = var27 > 0 ? (var24 + 1 - var3) * var31 : (var27 < 0 ? (var3 - var24) * var31 : Double.MAX_VALUE);
      double var39 = var28 > 0 ? (var25 + 1 - var5) * var33 : (var28 < 0 ? (var5 - var25) * var33 : Double.MAX_VALUE);

      for (int var41 = 0; var41 < 64; var41++) {
         if (var23 == var13 && var24 == var14 && var25 == var15) {
            return true;
         }

         if (var41 > 0 && !tpx.open(var0.at(var23, var24, var25))) {
            if (var16 != null) {
               var16[0] = var23;
               var16[1] = var24;
               var16[2] = var25;
            }

            return false;
         }

         double var42;
         if (var35 <= var37 && var35 <= var39) {
            var42 = var35;
            var35 += var29;
            var23 += var26;
         } else if (var37 <= var39) {
            var42 = var37;
            var37 += var31;
            var24 += var27;
         } else {
            var42 = var39;
            var39 += var33;
            var25 += var28;
         }

         if (var42 > 1.0) {
            return false;
         }
      }

      return false;
   }

   void tpw(tvn var1, tra var2, double var3, double var5, LongOpenHashSet var7) {
      double var8 = Math.hypot(var2.vyaw, var2.vpitch);
      double var10 = Math.hypot(var2.vx, var2.vz);
      boolean var12 = var10 > 0.04;
      double var13 = Math.hypot(var3, var5);
      int var15 = var1.y0 + 11 - 1;

      for (int var16 = 0; var16 < this.n; var16++) {
         int var17 = this.x[var16];
         int var18 = this.y[var16];
         int var19 = this.z[var16];
         byte var20 = var1.at(var17, var18, var19);
         double var21 = this.qx[var16] - var2.ex;
         double var23 = this.qy[var16] - var2.ey;
         double var25 = this.qz[var16] - var2.ez;
         double var27 = tbp.wrap(tbp.yawTo(var21, var25) - var2.yaw);
         double var29 = tbp.pitchTo(var23, Math.sqrt(var21 * var21 + var25 * var25)) - var2.pitch;
         double var31 = 0.0;
         double var33 = 0.0;
         if (var8 > 0.5) {
            var31 = (var27 * var2.vyaw + var29 * var2.vpitch) / var8;
            var33 = Math.abs(var27 * var2.vpitch - var29 * var2.vyaw) / var8;
         }

         double var35 = var17 + 0.5 - var2.ex;
         double var37 = var18 + 0.5 - var2.ey;
         double var39 = var19 + 0.5 - var2.ez;
         double var41 = Math.sqrt(var35 * var35 + var37 * var37 + var39 * var39);
         int var43 = var18 - var2.feetY;
         int var44 = 0;
         int var45 = 0;
         int var46 = 0;

         for (int var47 = -1; var47 <= 1; var47++) {
            for (int var48 = -1; var48 <= 1; var48++) {
               for (int var49 = -1; var49 <= 1; var49++) {
                  if (var47 != 0 || var48 != 0 || var49 != 0) {
                     byte var50 = var1.at(var17 + var47, var18 + var48, var19 + var49);
                     if (tpx.minable(var50)) {
                        var46++;
                        if (tpx.target(var50)) {
                           var44++;
                        } else if (tpx.ore(var50)) {
                           var45++;
                        }
                     }
                  }
               }
            }
         }

         int var61 = this.face[var16] / 2;
         int var62 = 0;
         int var63 = 0;

         for (int var64 = -1; var64 <= 1; var64++) {
            for (int var51 = -1; var51 <= 1; var51++) {
               if (var64 != 0 || var51 != 0) {
                  int var52 = var61 == 0 ? 0 : var64;
                  int var53 = var61 == 1 ? 0 : (var61 == 0 ? var64 : var51);
                  byte var54 = (byte)(var61 == 2 ? 0 : var51);
                  byte var55 = var1.at(var17 + var52, var18 + var53, var19 + var54);
                  if (tpx.minable(var55)) {
                     var62++;
                     if (tpx.target(var55)) {
                        var63++;
                     }
                  }
               }
            }
         }

         int var65 = 0;

         for (int[] var72 : tpo) {
            if (tpx.open(var1.at(var17 + var72[0], var18 + var72[1], var19 + var72[2]))) {
               var65++;
            }
         }

         boolean var67 = true;

         for (int var69 = var18 + 1; var69 <= var15 && var67; var69++) {
            var67 = !tpx.minable(var1.at(var17, var69, var19));
         }

         double var70 = Math.hypot(var35, var39);
         double var73 = var12 && var70 > 0.001 ? (var2.vx * var35 + var2.vz * var39) / (var10 * var70) : 0.0;
         boolean var56 = (var43 == 0 || var43 == 1) && var70 < 1.8 && var13 > 0.001 && var70 > 0.001 && (var3 * var35 + var5 * var39) / (var13 * var70) > 0.7;
         int var57 = var16 * 32;
         this.f[var57] = this.ang[var16] / 30.0;
         this.f[var57 + 1] = Math.log1p(this.ang[var16] / 3.0);
         this.f[var57 + 2] = Math.abs(var27) / 30.0;
         this.f[var57 + 3] = var29 / 30.0;
         this.f[var57 + 4] = var31 / 30.0;
         this.f[var57 + 5] = var33 / 30.0;
         this.f[var57 + 6] = var41 / 4.0;
         this.f[var57 + 7] = var43 / 3.0;
         this.f[var57 + 8] = var43 == 0 ? 1.0 : 0.0;
         this.f[var57 + 9] = var43 == 1 ? 1.0 : 0.0;
         this.f[var57 + 10] = var43 >= 2 ? 1.0 : 0.0;
         this.f[var57 + 11] = tpx.target(var20) ? 1.0 : 0.0;
         this.f[var57 + 12] = tpx.ore(var20) ? 1.0 : 0.0;
         this.f[var57 + 13] = var44 / 3.0;
         this.f[var57 + 14] = var45 / 3.0;
         this.f[var57 + 15] = var46 / 26.0;
         this.f[var57 + 16] = var62 / 8.0;
         this.f[var57 + 17] = var63 / 3.0;
         this.f[var57 + 18] = var65 / 6.0;
         if (var2.hasPrev) {
            int var58 = Math.max(Math.abs(var17 - var2.px), Math.max(Math.abs(var18 - var2.py), Math.abs(var19 - var2.pz)));
            double var59 = Math.sqrt(
               (double)(var17 - var2.px) * (var17 - var2.px) + (double)(var18 - var2.py) * (var18 - var2.py) + (double)(var19 - var2.pz) * (var19 - var2.pz)
            );
            this.f[var57 + 19] = var58 == 1 ? 1.0 : 0.0;
            this.f[var57 + 20] = Math.min(var59, 8.0) / 4.0;
            this.f[var57 + 21] = 1.0;
         } else {
            this.f[var57 + 19] = 0.0;
            this.f[var57 + 20] = 0.0;
            this.f[var57 + 21] = 0.0;
         }

         this.f[var57 + 22] = var73;
         this.f[var57 + 23] = var56 ? 1.0 : 0.0;
         this.f[var57 + 24] = var67 ? 1.0 : 0.0;
         this.f[var57 + 25] = this.face[var16] == 2 ? 1.0 : 0.0;
         this.f[var57 + 26] = this.face[var16] == 3 ? 1.0 : 0.0;
         this.f[var57 + 27] = tpx.slow(var20) ? 1.0 : 0.0;
         this.f[var57 + 28] = var7.contains(tpu(var17, var18, var19)) ? 1.0 : 0.0;
         this.f[var57 + 29] = Math.min(1.0, var8 / 15.0);
         this.f[var57 + 30] = var12 ? 1.0 : 0.0;
         this.f[var57 + 31] = var2.ground ? 1.0 : 0.0;
      }
   }
}
