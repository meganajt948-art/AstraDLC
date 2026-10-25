package a;

import flow.dev.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public final class trj {
   public static final int SECTORS = 8;
   public static final int PER = 7;
   public static final int GLOBAL = 15;
   public static final int N = 71;
   public static final int MOVES = 9;
   public static final int OUT = 11;
   public static final int HIDDEN = 48;
   public static final int NONE = 0;
   public static final int F = 1;
   public static final int FL = 2;
   public static final int FR = 3;
   public static final int L = 4;
   public static final int R = 5;
   public static final int B = 6;
   public static final int BL = 7;
   public static final int BR = 8;
   public static final int[] MIRROR = new int[]{0, 1, 3, 2, 5, 4, 6, 8, 7};
   public static final int[] FWD = new int[]{0, 1, 1, 1, 0, 0, -1, -1, -1};
   public static final int[] LEFT = new int[]{0, 0, 1, -1, 1, -1, 0, 1, -1};
   public final tbx net;
   public final double[] mu = new double[71];
   public final double[] sd = new double[71];

   public trj(tbx var1) {
      this.net = var1;
      Arrays.fill(this.sd, 1.0);
   }

   public static int move(int var0) {
      boolean var1 = (var0 & 1) != 0 && (var0 & 2) == 0;
      boolean var2 = (var0 & 2) != 0 && (var0 & 1) == 0;
      boolean var3 = (var0 & 4) != 0 && (var0 & 8) == 0;
      boolean var4 = (var0 & 8) != 0 && (var0 & 4) == 0;
      if (var1) {
         return var3 ? 2 : (var4 ? 3 : 1);
      } else if (var2) {
         return var3 ? 7 : (var4 ? 8 : 6);
      } else {
         return var3 ? 4 : (var4 ? 5 : 0);
      }
   }

   public static void features(tvn var0, trg var1, double[] var2, int var3) {
      double var4 = Math.toRadians(var1.yaw);
      double var6 = -Math.sin(var4);
      double var8 = Math.cos(var4);
      double var10 = Math.cos(var4);
      double var12 = Math.sin(var4);
      int var14 = (int)Math.floor(var1.px);
      int var15 = (int)Math.floor(var1.pz);
      int var16 = var1.feetY;
      Arrays.fill(var2, var3, var3 + 71, 0.0);

      for (int var17 = 0; var17 < 8; var17++) {
         double var18 = Math.toRadians(45.0 * var17);
         double var20 = Math.cos(var18) * var6 + Math.sin(var18) * var10;
         double var22 = Math.cos(var18) * var8 + Math.sin(var18) * var12;
         int var24 = var14 + (Math.abs(var20) > 0.38 ? (var20 > 0.0 ? 1 : -1) : 0);
         int var25 = var15 + (Math.abs(var22) > 0.38 ? (var22 > 0.0 ? 1 : -1) : 0);
         byte var26 = var0.at(var24, var16 - 1, var25);
         byte var27 = var0.at(var24, var16, var25);
         byte var28 = var0.at(var24, var16 + 1, var25);
         byte var29 = var0.at(var24, var16 + 2, var25);
         int var30 = var3 + var17 * 7;
         var2[var30] = tpx.open(var27) && tpx.open(var28) && !tpx.open(var26) ? 1.0 : 0.0;
         var2[var30 + 1] = tpx.open(var27) && tpx.open(var28) && tpx.open(var26) ? 1.0 : 0.0;
         var2[var30 + 2] = !tpx.minable(var27) && !tpx.minable(var28) ? 0.0 : 1.0;
         var2[var30 + 3] = (tpx.open(var27) || tpx.minable(var27)) && (tpx.open(var28) || tpx.minable(var28)) ? 0.0 : 1.0;
         var2[var30 + 4] = !tpx.open(var27) && tpx.open(var28) && tpx.open(var29) ? 1.0 : 0.0;
      }

      for (int var34 = var14 - 5; var34 <= var14 + 5; var34++) {
         for (int var36 = var15 - 5; var36 <= var15 + 5; var36++) {
            double var19 = var34 + 0.5 - var1.px;
            double var21 = var36 + 0.5 - var1.pz;
            double var23 = Math.hypot(var19, var21);
            if (!(var23 < 0.5) && !(var23 > 5.5)) {
               double var44 = Math.toDegrees(Math.atan2(var19 * var10 + var21 * var12, var19 * var6 + var21 * var8));
               int var48 = ((int)Math.round(var44 / 45.0) % 8 + 8) % 8;
               int var50 = var3 + var48 * 7;

               for (int var51 = var16 - 2; var51 <= var16 + 4; var51++) {
                  byte var53 = var0.at(var34, var51, var36);
                  if (tpx.minable(var53)) {
                     if (var23 <= 4.5 && var51 >= var16 - 1 && var51 <= var16 + 3) {
                        var2[var50 + 5] = var2[var50 + 5] + 0.05;
                     }

                     if (tpx.target(var53)) {
                        var2[var50 + 6] = var2[var50 + 6] + 0.3333333333333333;
                     }
                  }
               }
            }
         }
      }

      int var35 = var3 + 56;
      var2[var35] = (var1.vx * var6 + var1.vz * var8) * 4.0;
      var2[var35 + 1] = (var1.vx * var10 + var1.vz * var12) * 4.0;
      var2[var35 + 2] = var1.vy * 2.0;
      var2[var35 + 3] = var1.ground ? 1.0 : 0.0;
      var2[var35 + 4] = var1.pitch / 90.0;
      if (var1.hasTarget) {
         double var37 = var1.tx + 0.5 - var1.px;
         double var40 = var1.tz + 0.5 - var1.pz;
         var2[var35 + 5] = 1.0;
         var2[var35 + 6] = (var37 * var6 + var40 * var8) / 4.0;
         var2[var35 + 7] = (var37 * var10 + var40 * var12) / 4.0;
         var2[var35 + 8] = (var1.ty - var16) / 3.0;
         double var42 = Math.toRadians(var1.pitch);
         double var46 = var1.ty + 0.5 - var1.eyeY;
         double var54 = Math.sqrt(var37 * var37 + var46 * var46 + var40 * var40);
         if (var54 > 1.0E-6) {
            double var32 = (var37 * var6 * Math.cos(var42) - var46 * Math.sin(var42) + var40 * var8 * Math.cos(var42)) / var54;
            var2[var35 + 9] = Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, var32)))) / 90.0;
         }
      }

      int[] var38 = new int[2];
      trd.reach(var0, var1.px, var1.eyeY, var1.pz, var38);
      var2[var35 + 10] = var38[0] / 40.0;
      var2[var35 + 11] = var38[1] / 4.0;
      if (var38[0] == 0) {
         double var39 = Double.MAX_VALUE;
         double var41 = 0.0;
         double var43 = 0.0;

         for (int var45 = var14 - 7 + 1; var45 <= var14 + 7 - 1; var45++) {
            for (int var47 = var15 - 7 + 1; var47 <= var15 + 7 - 1; var47++) {
               double var49 = var45 + 0.5 - var1.px;
               double var52 = var47 + 0.5 - var1.pz;
               double var31 = Math.hypot(var49, var52);
               if (!(var31 >= var39)) {
                  for (int var33 = var16; var33 <= var16 + 3; var33++) {
                     if (tpx.minable(var0.at(var45, var33, var47))) {
                        var39 = var31;
                        var41 = var49;
                        var43 = var52;
                        break;
                     }
                  }
               }
            }
         }

         if (var39 < Double.MAX_VALUE && var39 > 1.0E-6) {
            var2[var35 + 12] = (var41 * var6 + var43 * var8) / var39;
            var2[var35 + 13] = (var41 * var10 + var43 * var12) / var39;
            var2[var35 + 14] = var39 / 8.0;
         }
      }
   }

   public static void mirror(double[] var0, int var1, double[] var2, int var3) {
      for (int var4 = 0; var4 < 8; var4++) {
         int var5 = (8 - var4) % 8;
         System.arraycopy(var0, var1 + var4 * 7, var2, var3 + var5 * 7, 7);
      }

      byte var6 = 56;
      System.arraycopy(var0, var1 + var6, var2, var3 + var6, 15);
      var2[var3 + var6 + 1] = -var0[var1 + var6 + 1];
      var2[var3 + var6 + 7] = -var0[var1 + var6 + 7];
      var2[var3 + var6 + 13] = -var0[var1 + var6 + 13];
   }

   public void normalize(double[] var1, int var2, double[] var3) {
      for (int var4 = 0; var4 < 71; var4++) {
         var3[var4] = Math.max(-8.0, Math.min(8.0, (var1[var2 + var4] - this.mu[var4]) / this.sd[var4]));
      }
   }

   public void decide(double[] var1, double[] var2) {
      double[] var3 = new double[71];
      this.normalize(var1, 0, var3);
      double[] var4 = new double[this.net.h1];
      double[] var5 = new double[this.net.h2];
      double[] var6 = new double[11];
      this.net.forward(var3, var4, var5, var6);
      double var7 = Double.NEGATIVE_INFINITY;

      for (int var9 = 0; var9 < 9; var9++) {
         var7 = Math.max(var7, var6[var9]);
      }

      double var12 = 0.0;

      for (int var11 = 0; var11 < 9; var11++) {
         var2[var11] = Math.exp(var6[var11] - var7);
         var12 += var2[var11];
      }

      for (int var13 = 0; var13 < 9; var13++) {
         var2[var13] /= var12;
      }

      var2[9] = 1.0 / (1.0 + Math.exp(-var6[9]));
      var2[10] = 1.0 / (1.0 + Math.exp(-var6[10]));
   }

   public void write(DataOutputStream var1) throws IOException {
      var1.writeInt(71);

      for (int var2 = 0; var2 < 71; var2++) {
         var1.writeFloat((float)this.mu[var2]);
         var1.writeFloat((float)this.sd[var2]);
      }

      this.net.write(var1);
   }

   public static trj read(DataInputStream var0) throws IOException {
      int var1 = var0.readInt();
      if (var1 != 71) {
         throw new IOException(a.d("웆뽾㖯ꯊ⁎ꚬ᳤锜\u0b52臶", 2018157232, -508992496));
      } else {
         double[] var2 = new double[71];
         double[] var3 = new double[71];

         for (int var4 = 0; var4 < 71; var4++) {
            var2[var4] = var0.readFloat();
            var3[var4] = var0.readFloat();
         }

         tbx var6 = tbx.read(var0);
         if (var6.in == 71 && var6.out == 11) {
            trj var5 = new trj(var6);
            System.arraycopy(var2, 0, var5.mu, 0, 71);
            System.arraycopy(var3, 0, var5.sd, 0, 71);
            return var5;
         } else {
            throw new IOException(a.b("谬\uf594罅\ue120檤\uec46嘎\udff6䆸쬜", 1791003722));
         }
      }
   }
}
