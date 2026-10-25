package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.util.Identifier;

public final class uog {
   uog() {
   }

   public static boolean draw(DrawContext var0, AbstractClientPlayerEntity var1, float var2, float var3, float var4, float var5, int var6) {
      SkinTextures var7;
      try {
         var7 = var1.getSkin();
      } catch (Throwable var9) {
         return false;
      }

      return draw(var0, var7, var2, var3, var4, var5, var6);
   }

   public static boolean draw(DrawContext var0, SkinTextures var1, float var2, float var3, float var4, float var5, int var6) {
      GpuTextureView var7 = uoj(var1);
      if (var7 == null) {
         return false;
      }

      uut.imageRegion(var0, var7, var2, var3, var4, var4, var5, 0.125F, 0.125F, 0.25F, 0.25F, var6, true);
      float var8 = var4 * 0.06F;
      uut.imageRegion(var0, var7, var2 - var8, var3 - var8, var4 + var8 * 2.0F, var4 + var8 * 2.0F, var5 + var8, 0.625F, 0.125F, 0.75F, 0.25F, var6, true);
      return true;
   }

   static GpuTextureView uoj(SkinTextures var0) {
      try {
         Identifier var1 = var0.body().texturePath();
         AbstractTexture var2 = MinecraftClient.getInstance().getTextureManager().getTexture(var1);
         return var2 != null ? var2.getGlTextureView() : null;
      } catch (Throwable var3) {
         return null;
      }
   }
}
