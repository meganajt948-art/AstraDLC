package a;

public final class trd {
   public static final double RADIUS = 6.0;
   public static final double REACH = 4.8;
   public static final int WORKING = 8;
   public static final int DIA_WEIGHT = 6;

   private trd() {
   }

   public static void diff(tvn var0, tvn var1, double var2, double var4, double var6, int[] var8) {
      var8[0] = 0;
      var8[1] = 0;
      if (var0 != null && var1 != null) {
         int var9 = (int)Math.ceil(6.0);
         int var10 = (int)Math.floor(var2);
         int var11 = (int)Math.floor(var4);
         int var12 = (int)Math.floor(var6);
         double var13 = 36.0;

         for (int var15 = var10 - var9; var15 <= var10 + var9; var15++) {
            for (int var16 = var11 - var9; var16 <= var11 + var9; var16++) {
               for (int var17 = var12 - var9; var17 <= var12 + var9; var17++) {
                  double var18 = var15 + 0.5 - var2;
                  double var20 = var16 + 0.5 - var4;
                  double var22 = var17 + 0.5 - var6;
                  if (!(var18 * var18 + var20 * var20 + var22 * var22 > var13) && var0.inside(var15, var16, var17) && var1.inside(var15, var16, var17)) {
                     byte var24 = var0.at(var15, var16, var17);
                     if (tpx.minable(var24) && tpx.open(var1.at(var15, var16, var17))) {
                        var8[0]++;
                        if (tpx.target(var24)) {
                           var8[1]++;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public static void reach(tvn var0, double var1, double var3, double var5, int[] var7) {
      var7[0] = 0;
      var7[1] = 0;
      int var8 = (int)Math.ceil(4.8);
      int var9 = (int)Math.floor(var1);
      int var10 = (int)Math.floor(var3);
      int var11 = (int)Math.floor(var5);
      double var12 = 23.04;

      for (int var14 = var9 - var8; var14 <= var9 + var8; var14++) {
         for (int var15 = var10 - var8; var15 <= var10 + var8; var15++) {
            for (int var16 = var11 - var8; var16 <= var11 + var8; var16++) {
               double var17 = var14 + 0.5 - var1;
               double var19 = var15 + 0.5 - var3;
               double var21 = var16 + 0.5 - var5;
               if (!(var17 * var17 + var19 * var19 + var21 * var21 > var12)) {
                  byte var23 = var0.at(var14, var15, var16);
                  if (tpx.minable(var23)) {
                     var7[0]++;
                     if (tpx.target(var23)) {
                        var7[1]++;
                     }
                  }
               }
            }
         }
      }
   }

   public static double value(int var0, int var1) {
      return var0 + 5 * var1;
   }
}
