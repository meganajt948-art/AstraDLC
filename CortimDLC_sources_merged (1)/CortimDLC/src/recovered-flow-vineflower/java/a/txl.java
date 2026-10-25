package a;

import java.util.Arrays;

public final class txl {
   public static final double[] AHEAD = new double[]{0.5, 1.0, 1.6, 2.4, 3.3, 4.4, 5.8, 7.5};
   public static final int POINTS = AHEAD.length * 3;
   public static final int I_SIN = POINTS;
   public static final int I_COS = POINTS + 1;
   public static final int I_LAT = POINTS + 2;
   public static final int I_REM = POINTS + 3;
   public static final int I_END = POINTS + 4;
   public static final int I_JUMP = POINTS + 5;
   public static final int I_DROP = POINTS + 8;
   public static final int ROUTE = POINTS + 11;
   public static final int SECTORS = 8;
   public static final int PER = 7;
   public static final int I_TERRAIN = ROUTE;
   public static final int I_OWN = I_TERRAIN + 56;
   public static final int TERRAIN = 59;
   public static final int I_KIN = ROUTE + 59;
   public static final int I_VF = I_KIN;
   public static final int I_VL = I_KIN + 1;
   public static final int I_VY = I_KIN + 2;
   public static final int I_HS = I_KIN + 3;
   public static final int I_GROUND = I_KIN + 4;
   public static final int I_WATER = I_KIN + 5;
   public static final int I_CLIMB = I_KIN + 6;
   public static final int I_COLLIDE = I_KIN + 7;
   public static final int I_SPRINT = I_KIN + 8;
   public static final int I_SPEED = I_KIN + 9;
   public static final int I_PITCH = I_KIN + 10;
   public static final int I_DYAW1 = I_KIN + 11;
   public static final int I_DYAW2 = I_KIN + 12;
   public static final int I_DPITCH1 = I_KIN + 13;
   public static final int I_DPITCH2 = I_KIN + 14;
   public static final int I_SINCE = I_KIN + 15;
   public static final int KIN = 16;
   public static final int N = ROUTE + 59 + 16;
   public static final double FAR_LATERAL = 3.0;

   private txl() {
   }

   public static void features(txi var0, tvt var1, int var2, tzg var3, double[] var4, int var5) {
      Arrays.fill(var4, var5, var5 + N, 0.0);
      double var6 = Math.toRadians(var0.yaw);
      double var8 = -Math.sin(var6);
      double var10 = Math.cos(var6);
      double var12 = Math.cos(var6);
      double var14 = Math.sin(var6);
      double[] var16 = new double[3];
      double[] var17 = new double[1];
      if (var1 != null && var1.n > 0) {
         double var18 = var1.project(var0.x, var0.z, var2);

         for (int var20 = 0; var20 < AHEAD.length; var20++) {
            var1.at(var18 + AHEAD[var20], var16);
            double var21 = var16[0] - var0.x;
            double var23 = var16[2] - var0.z;
            int var25 = var5 + var20 * 3;
            var4[var25] = txo((var21 * var8 + var23 * var10) / 4.0, 3.0);
            var4[var25 + 1] = txo((var21 * var12 + var23 * var14) / 4.0, 3.0);
            var4[var25 + 2] = txo((var16[1] - var0.y) / 2.0, 3.0);
         }

         double var35 = Math.toRadians(tvt.wrap(var1.heading(var18) - var0.yaw));
         var4[var5 + I_SIN] = Math.sin(var35);
         var4[var5 + I_COS] = Math.cos(var35);
         var4[var5 + I_LAT] = txo(var1.lateral(var0.x, var0.z, var18) / 1.5, 4.0);
         double var22 = var1.length() - var18;
         var4[var5 + I_REM] = Math.min(12.0, Math.max(0.0, var22)) / 12.0;
         var4[var5 + I_END] = var22 < 8.0 ? 1.0 : 0.0;
         double var24 = var1.next(var18, 6.0, (byte)1, var0.y, var17);
         if (var24 >= 0.0) {
            var4[var5 + I_JUMP] = 1.0;
            var4[var5 + I_JUMP + 1] = var24 / 6.0;
            var4[var5 + I_JUMP + 2] = Math.min(2.0, var17[0] / 1.25);
         }

         double var26 = var1.next(var18, 6.0, (byte)2, var0.y, var17);
         if (var26 >= 0.0) {
            var4[var5 + I_DROP] = 1.0;
            var4[var5 + I_DROP + 1] = var26 / 6.0;
            var4[var5 + I_DROP + 2] = Math.min(3.0, var17[0] / 4.0);
         }
      }

      int var33 = (int)Math.floor(var0.y + 0.001);
      if (var3 != null) {
         for (int var19 = 0; var19 < 8; var19++) {
            double var36 = Math.toRadians(45.0 * var19);
            double var38 = Math.cos(var36) * var8 + Math.sin(var36) * var12;
            double var39 = Math.cos(var36) * var10 + Math.sin(var36) * var14;
            int var40 = (int)Math.floor(var0.x + var38 * 0.8);
            int var27 = (int)Math.floor(var0.z + var39 * 0.8);
            int var28 = var5 + I_TERRAIN + var19 * 7;
            boolean var29 = false;
            boolean var30 = false;

            for (int var31 = -2; var31 <= 2; var31++) {
               int var32 = var3.at(var40, var33 + var31, var27);
               var4[var28 + var31 + 2] = tzg.top(var32);
               if (var31 >= -1 && var31 <= 1 && (var32 & 32) != 0) {
                  var29 = true;
               }

               if (var31 >= -1 && var31 <= 0 && (var32 & 16) != 0) {
                  var30 = true;
               }
            }

            var4[var28 + 5] = var29 ? 1.0 : 0.0;
            var4[var28 + 6] = var30 ? 1.0 : 0.0;
         }

         int var34 = (int)Math.floor(var0.x);
         int var37 = (int)Math.floor(var0.z);
         var4[var5 + I_OWN] = tzg.top(var3.at(var34, var33 - 1, var37));
         var4[var5 + I_OWN + 1] = tzg.top(var3.at(var34, var33 + 2, var37));
      }

      var4[var5 + I_OWN + 2] = var0.y - var33;
      var4[var5 + I_VF] = txo((var0.vx * var8 + var0.vz * var10) * 4.0, 4.0);
      var4[var5 + I_VL] = txo((var0.vx * var12 + var0.vz * var14) * 4.0, 4.0);
      var4[var5 + I_VY] = txo(var0.vy * 2.0, 3.0);
      var4[var5 + I_HS] = Math.min(4.0, Math.hypot(var0.vx, var0.vz) * 4.0);
      var4[var5 + I_GROUND] = var0.ground ? 1.0 : 0.0;
      var4[var5 + I_WATER] = var0.water ? 1.0 : 0.0;
      var4[var5 + I_CLIMB] = var0.climb ? 1.0 : 0.0;
      var4[var5 + I_COLLIDE] = var0.collide ? 1.0 : 0.0;
      var4[var5 + I_SPRINT] = var0.sprinting ? 1.0 : 0.0;
      var4[var5 + I_SPEED] = txo(var0.speed / 0.1 - 1.0, 3.0);
      var4[var5 + I_PITCH] = var0.pitch / 90.0;
      var4[var5 + I_DYAW1] = txo(var0.dyaw1 / 10.0, 4.0);
      var4[var5 + I_DYAW2] = txo(var0.dyaw2 / 10.0, 4.0);
      var4[var5 + I_DPITCH1] = txo(var0.dpitch1 / 5.0, 4.0);
      var4[var5 + I_DPITCH2] = txo(var0.dpitch2 / 5.0, 4.0);
      var4[var5 + I_SINCE] = Math.min(20, Math.max(0, var0.sinceJump)) / 20.0;
   }

   public static void mirror(double[] var0, int var1, double[] var2, int var3) {
      System.arraycopy(var0, var1, var2, var3, N);

      for (int var4 = 0; var4 < AHEAD.length; var4++) {
         var2[var3 + var4 * 3 + 1] = -var0[var1 + var4 * 3 + 1];
      }

      var2[var3 + I_SIN] = -var0[var1 + I_SIN];
      var2[var3 + I_LAT] = -var0[var1 + I_LAT];

      for (int var6 = 0; var6 < 8; var6++) {
         int var5 = (8 - var6) % 8;
         System.arraycopy(var0, var1 + I_TERRAIN + var6 * 7, var2, var3 + I_TERRAIN + var5 * 7, 7);
      }

      var2[var3 + I_VL] = -var0[var1 + I_VL];
      var2[var3 + I_DYAW1] = -var0[var1 + I_DYAW1];
      var2[var3 + I_DYAW2] = -var0[var1 + I_DYAW2];
   }

   private static double txo(double var0, double var2) {
      return var0 > var2 ? var2 : (var0 < -var2 ? -var2 : var0);
   }
}
