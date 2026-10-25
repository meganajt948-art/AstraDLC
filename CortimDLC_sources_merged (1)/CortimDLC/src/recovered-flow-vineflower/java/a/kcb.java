package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.gui.DrawContext;

public final class kcb {
   kcb() {
   }

   public static void draw(DrawContext var0, GpuTextureView var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      uut.arc(var0, var2, var3, var4, var5, 0.0F, 1.0F, kce.rgba(16777215, 0.13F));
      float var9 = var6 * 1.05F + 0.04F * (float)Math.sin(var6 * 2.4F);
      float var10 = 0.2F + 0.14F * (0.5F + 0.5F * (float)Math.sin(var6 * 2.4F - 0.6F));
      float var11 = vcq.inOutCubic(var7);
      var10 += (1.0F - var10) * var11;
      int var12 = kce.rgba(var8, 1.0F);
      int var13 = kce.rgba(16777215, 1.0F);
      uut.arc(var0, var2, var3, var4, var5, var9 - var10, var10, var12, var13, var13, var12);
      if (var1 != null) {
         uut.additive(true);
         float var14 = 0.35F + 0.5F * (1.0F - Math.abs(var7 * 2.0F - 1.0F)) * (var7 > 0.0F ? 1.0F : 0.0F);
         uut.sprite(var0, var1, var2, var3, var4 * 5.0F, kce.rgba(var8, 0.18F * var14 + 0.06F));
         double var15 = var9 % 1.0F * Math.PI * 2.0;
         float var17 = var2 + (float)Math.sin(var15) * (var4 - var5 * 0.5F);
         float var18 = var3 - (float)Math.cos(var15) * (var4 - var5 * 0.5F);
         uut.sprite(var0, var1, var17, var18, var5 * 7.0F, kce.rgba(16777215, 0.55F * (1.0F - var11)));
         uut.additive(false);
      }
   }
}
