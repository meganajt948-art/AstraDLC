package a;

public final class vcq {
   private vcq() {
   }

   public static float clamp01(float var0) {
      return var0 < 0.0F ? 0.0F : (var0 > 1.0F ? 1.0F : var0);
   }

   public static float outCubic(float var0) {
      var0 = clamp01(var0);
      float var1 = 1.0F - var0;
      return 1.0F - var1 * var1 * var1;
   }

   public static float inCubic(float var0) {
      var0 = clamp01(var0);
      return var0 * var0 * var0;
   }

   public static float inOutCubic(float var0) {
      var0 = clamp01(var0);
      return var0 < 0.5F ? 4.0F * var0 * var0 * var0 : 1.0F - (float)Math.pow(-2.0F * var0 + 2.0F, 3.0) / 2.0F;
   }

   public static float outQuint(float var0) {
      var0 = clamp01(var0);
      float var1 = 1.0F - var0;
      return 1.0F - var1 * var1 * var1 * var1 * var1;
   }

   public static float outExpo(float var0) {
      var0 = clamp01(var0);
      return var0 >= 1.0F ? 1.0F : 1.0F - (float)Math.pow(2.0, -10.0F * var0);
   }

   public static float outBack(float var0) {
      var0 = clamp01(var0);
      float var1 = 1.70158F;
      float var2 = var1 + 1.0F;
      float var3 = var0 - 1.0F;
      return 1.0F + var2 * var3 * var3 * var3 + var1 * var3 * var3;
   }
}
