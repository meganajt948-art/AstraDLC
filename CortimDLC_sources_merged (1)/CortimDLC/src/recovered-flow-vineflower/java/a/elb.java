package a;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import flow.dev.a;
import net.minecraft.client.texture.NativeImage;

public final class elb implements AutoCloseable {
   public final int width;
   public final int height;
   final NativeImage elc;
   final GpuTexture eld;
   final GpuTextureView ele;

   elb(String var1, int var2, int var3) {
      this.width = var2;
      this.height = var3;
      GpuDevice var4 = RenderSystem.getDevice();
      this.eld = var4.createTexture(() -> a.b("殺茍ঢ়鞴ᰦ骅ₔꥨ㜬뷉", 7469786) + var1, 5, TextureFormat.RGBA8, var2, var3, 1, 1);
      this.ele = var4.createTextureView(this.eld);
      this.elc = new NativeImage(var2, var3, false);
   }

   void set(int var1, int var2, int var3) {
      this.elc.setColorArgb(var1, var2, var3);
   }

   void upload() {
      RenderSystem.getDevice().createCommandEncoder().writeToTexture(this.eld, this.elc);
   }

   public GpuTextureView view() {
      return this.ele;
   }

   @Override
   public void close() {
      this.elc.close();
      this.ele.close();
      this.eld.close();
   }
}
