package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

public final class prp {
   private static final double prq = 0.15F;

   private prp() {
   }

   public static double multiplier() {
      MinecraftClient var0 = MinecraftClient.method_1551();
      if (var0.field_1690 == null) {
         return 0.0;
      } else {
         double var1 = (Double)var0.field_1690.method_42495().method_41753() * 0.6F + 0.2F;
         double var3 = var1 * var1 * var1;
         return var0.field_1724 != null && var0.field_1690.method_31044().method_31034() && var0.field_1724.method_31550() ? var3 : var3 * 8.0;
      }
   }

   public static double step() {
      return step(multiplier());
   }

   public static double step(double var0) {
      return var0 * 0.15F;
   }

   public static float quantize(double var0, double var2) {
      if (Double.isFinite(var0) && !(var2 <= 0.0)) {
         long var4 = Math.round(var0 / (var2 * 0.15F));
         return (float)(var4 * var2) * 0.15F;
      } else {
         return 0.0F;
      }
   }

   public static float[] apply(float var0, float var1, float var2, float var3) {
      double var4 = multiplier();
      if (!(var4 <= 0.0) && Float.isFinite(var2) && Float.isFinite(var3) && Float.isFinite(var0) && Float.isFinite(var1)) {
         double var6 = (double)var2 - var0;
         double var8 = Math.floor((var6 + 180.0) / 360.0) * 360.0;
         float var10 = (float)(var0 + var8) + quantize(var6 - var8, var4);
         float var11 = MathHelper.method_15363(var1 + quantize((double)var3 - var1, var4), -90.0F, 90.0F);
         return new float[]{Float.isFinite(var10) ? var10 : var2, Float.isFinite(var11) ? var11 : var3};
      } else {
         return new float[]{var2, var3};
      }
   }
}
