package a;

public final class tbp {
   private tbp() {
   }

   public static double wrap(double var0) {
      double var2 = var0 % 360.0;
      if (var2 >= 180.0) {
         var2 -= 360.0;
      } else if (var2 < -180.0) {
         var2 += 360.0;
      }

      return var2;
   }

   public static double yawTo(double var0, double var2) {
      return Math.toDegrees(Math.atan2(var2, var0)) - 90.0;
   }

   public static double pitchTo(double var0, double var2) {
      return -Math.toDegrees(Math.atan2(var0, var2));
   }

   public static boolean aim(
      double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, tbm var20
   ) {
      double var21 = var6 - var0;
      double var23 = var10 - var4;
      double var25 = Math.sqrt(var21 * var21 + var23 * var23);
      if (var25 < 0.08) {
         return false;
      } else {
         double var27 = -var23 / var25;
         double var29 = var21 / var25;
         double var31 = var12 * (Math.abs(var27) + Math.abs(var29));
         double var33 = var6 + var27 * var16 * var31;
         double var35 = var10 + var29 * var16 * var31;
         double var37 = var8 + var18 * var14;
         double var39 = var33 - var0;
         double var41 = var35 - var4;
         var20.yaw = yawTo(var39, var41);
         var20.pitch = pitchTo(var37 - var2, Math.sqrt(var39 * var39 + var41 * var41));
         double var43 = yawTo(var21 - var27 * var31, var23 - var29 * var31);
         double var45 = yawTo(var21 + var27 * var31, var23 + var29 * var31);
         var20.la = Math.min(0.0, wrap(var43 - var20.yaw));
         var20.ra = Math.max(0.0, wrap(var45 - var20.yaw));
         var20.bw = (var20.ra - var20.la) * 0.5;
         double var47 = Math.max(0.1, var25 - var12);
         var20.ta = Math.min(0.0, pitchTo(var8 + var14 - var2, var47) - var20.pitch);
         var20.ba = Math.max(0.0, pitchTo(var8 - var2, var47) - var20.pitch);
         var20.bh = var20.ba - var20.ta;
         double var49 = var8 + var14 * 0.5 - var2;
         var20.dist = Math.sqrt(var25 * var25 + var49 * var49);
         return true;
      }
   }

   public static double hitU(double var0, double var2, double var4, double var6, double var8, double var10, double var12) {
      double var14 = var4 - var0;
      double var16 = var6 - var2;
      double var18 = Math.sqrt(var14 * var14 + var16 * var16);
      if (var18 < 0.08) {
         return 0.0;
      } else {
         double var20 = -var16 / var18;
         double var22 = var14 / var18;
         double var24 = var8 * (Math.abs(var20) + Math.abs(var22));
         double var26 = ((var10 - var4) * var20 + (var12 - var6) * var22) / Math.max(0.001, var24);
         return Math.max(-1.0, Math.min(1.0, var26));
      }
   }

   public static double hitV(double var0, double var2, double var4) {
      return Math.max(0.0, Math.min(1.0, (var4 - var0) / Math.max(0.001, var2)));
   }
}
