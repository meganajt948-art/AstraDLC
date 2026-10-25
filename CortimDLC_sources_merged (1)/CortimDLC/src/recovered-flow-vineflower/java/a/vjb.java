package a;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import net.minecraft.client.texture.NativeImage;

final class vjb {
   final int px;
   final int columns;
   final int width;
   final int height;
   final GpuTexture texture;
   final GpuTextureView view;

   private vjb(int var1, int var2, int var3, int var4, GpuTexture var5, GpuTextureView var6) {
      this.px = var1;
      this.columns = var2;
      this.width = var3;
      this.height = var4;
      this.texture = var5;
      this.view = var6;
   }

   float[] uv(int var1) {
      int var2 = this.px + 2;
      int var3 = var1 % this.columns * (var2 + 1) + 1;
      int var4 = var1 / this.columns * (var2 + 1) + 1;
      return new float[]{(float)var3 / this.width, (float)var4 / this.height, (float)(var3 + var2) / this.width, (float)(var4 + var2) / this.height};
   }

   static vjb build(int var0) {
      vhz[] var1 = vhz.values();
      int var2 = (int)Math.ceil(Math.sqrt(var1.length));
      int var3 = (var1.length + var2 - 1) / var2;
      int var4 = var0 + 2;
      int var5 = vje(var2 * (var4 + 1) + 1);
      int var6 = vje(var3 * (var4 + 1) + 1);
      BufferedImage var7 = new BufferedImage(var5, var6, 2);
      Graphics2D var8 = var7.createGraphics();

      for (int var9 = 0; var9 < var1.length; var9++) {
         int var10 = var9 % var2 * (var4 + 1) + 1 + 1;
         int var11 = var9 / var2 * (var4 + 1) + 1 + 1;
         vit.paint(var8, var1[var9], var10, var11, var0, 1.8F, 1.15F);
      }

      var8.dispose();
      int[] var18 = ((DataBufferInt)var7.getRaster().getDataBuffer()).getData();
      GpuDevice var19 = RenderSystem.getDevice();
      GpuTexture var20 = var19.createTexture(() -> "Flow2 icons " + var0, 5, TextureFormat.RGBA8, var5, var6, 1, 1);
      NativeImage var12 = new NativeImage(var5, var6, false);

      try {
         for (int var13 = 0; var13 < var6; var13++) {
            for (int var14 = 0; var14 < var5; var14++) {
               int var15 = var18[var13 * var5 + var14] >>> 24 & 0xFF;
               var12.method_61941(var14, var13, var15 << 24 | 16777215);
            }
         }

         var19.createCommandEncoder().writeToTexture(var20, var12);
      } catch (Throwable var17) {
         try {
            var12.close();
         } catch (Throwable var16) {
            var17.addSuppressed(var16);
         }

         throw var17;
      }

      var12.close();
      return new vjb(var0, var2, var5, var6, var20, var19.createTextureView(var20));
   }

   void close() {
      this.view.close();
      this.texture.close();
   }

   private static int vje(int var0) {
      byte var1 = 1;

      while (var1 < var0) {
         var1 <<= 1;
      }

      return var1;
   }
}
