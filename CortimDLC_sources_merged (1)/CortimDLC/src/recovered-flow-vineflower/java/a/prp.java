package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

public final class prp {
   static final double prq = 0.15F;

   prp() {
   }

   public static double multiplier() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      if (var0.options == null) {
         return 0.0;
      }

      double var1 = var0.options.getMouseSensitivity().getValue() * 0.6F + 0.2F;
      double var3 = var1 * var1 * var1;
      return var0.player != null && var0.options.getPerspective().isFirstPerson() && var0.player.isUsingSpyglass() ? var3 : var3 * 8.0;
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
         float var11 = MathHelper.clamp(var1 + quantize((double)var3 - var1, var4), -90.0F, 90.0F);
         return new float[]{Float.isFinite(var10) ? var10 : var2, Float.isFinite(var11) ? var11 : var3};
      } else {
         return new float[]{var2, var3};
      }
   }
}
