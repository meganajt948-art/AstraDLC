package a;

import net.minecraft.client.gui.DrawContext;

public final class ukf {
   public static boolean enabled = true;

   private ukf() {
   }

   public static void shadow(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (enabled) {
         float var8 = 1.0F - 0.55F * var7;
         uut.shadow(var0, var1, var2 + 0.6F + 0.3F * var6, var3, var4, var5, 1.6F + 0.6F * var6, ujt.withAlpha(0, Math.round((70.0F + 12.0F * var6) * var8)));
         uut.shadow(var0, var1, var2 + 2.0F + 2.2F * var6, var3, var4, var5, 7.0F + 5.0F * var6, ujt.withAlpha(0, Math.round((34.0F + 16.0F * var6) * var8)));
      }
   }

   public static void rim(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (enabled) {
         int var8 = ujt.withAlpha(16777215, Math.round(Math.min(255.0F, (44.0F + 150.0F * var6) * var7)));
         int var9 = var6 > 0.5F ? ujt.withAlpha(0, Math.round(26.0F * var7)) : ujt.withAlpha(16777215, Math.round(7.0F * var7));
         uut.outlineGradientV(var0, var1, var2, var3, var4, var5, 1.0F, var8, var9);
      }
   }

   public static void sheen(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      if (enabled) {
         float var7 = Math.min(var4, Math.max(var5 * 2.0F, var4 * 0.55F));
         int var8 = ujt.withAlpha(16777215, Math.round(14.0F * var6));
         uut.gradient(var0, var1, var2, var3, var7, var5, var5, 0.0F, 0.0F, var8, var8, 16777215, 16777215);
      }
   }

   public static void inset(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      if (enabled) {
         int var7 = ujt.withAlpha(0, Math.round(70.0F - 40.0F * var6));
         uut.outlineGradientV(var0, var1, var2, var3, var4, var5, 1.0F, var7, 0);
      }
   }
}
