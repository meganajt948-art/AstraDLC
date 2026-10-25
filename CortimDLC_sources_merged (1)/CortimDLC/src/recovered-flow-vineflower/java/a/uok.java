package a;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.awt.image.BufferedImage;
import net.minecraft.client.texture.NativeImage;

public final class uok implements AutoCloseable {
   public final int width;
   public final int height;
   public final GpuTextureView view;
   private final GpuTexture uol;

   private uok(int var1, int var2, GpuTexture var3, GpuTextureView var4) {
      this.width = var1;
      this.height = var2;
      this.uol = var3;
      this.view = var4;
   }

   public static uok upload(String var0, BufferedImage var1, boolean var2) {
      return upload(var0, var1, var2, false);
   }

   public static uok upload(String var0, BufferedImage var1, boolean var2, boolean var3) {
      int var4 = var1.getWidth();
      int var5 = var1.getHeight();
      int[] var6 = var1.getRGB(0, 0, var4, var5, null, 0, var4);
      int var7 = var3 ? 0 : -16777216;
      GpuDevice var8 = RenderSystem.getDevice();
      GpuTexture var9 = var8.createTexture(() -> "Flow2 " + var0, 5, TextureFormat.RGBA8, var4, var5, 1, 1);

      try (NativeImage var10 = new NativeImage(var4, var5, false)) {
         for (int var11 = 0; var11 < var5; var11++) {
            int var12 = (var2 ? var5 - 1 - var11 : var11) * var4;

            for (int var13 = 0; var13 < var4; var13++) {
               var10.setColorArgb(var13, var11, var6[var12 + var13] | var7);
            }
         }

         var8.createCommandEncoder().writeToTexture(var9, var10);
      }

      return new uok(var4, var5, var9, var8.createTextureView(var9));
   }

   public static uok target(String var0, int var1, int var2) {
      GpuDevice var3 = RenderSystem.getDevice();
      GpuTexture var4 = var3.createTexture(() -> "Flow2 " + var0, 12, TextureFormat.RGBA8, var1, var2, 1, 1);
      return new uok(var1, var2, var4, var3.createTextureView(var4));
   }

   public GpuTexture gpuTexture() {
      return this.uol;
   }

   @Override
   public void close() {
      this.view.close();
      this.uol.close();
   }
}
