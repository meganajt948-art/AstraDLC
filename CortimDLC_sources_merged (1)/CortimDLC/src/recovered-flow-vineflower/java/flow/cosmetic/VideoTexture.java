package flow.cosmetic;

import a.uok;
import a.whl;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.texture.AbstractTexture;

final class VideoTexture extends AbstractTexture {
   private final String name;
   private final int width;
   private final int height;
   private final AbstractTexture fallback;
   private uok frame;
   private boolean live;

   VideoTexture(String name, int width, int height, AbstractTexture fallback) {
      this.name = name;
      this.width = width;
      this.height = height;
      this.fallback = fallback;
      this.field_63613 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
   }

   void refresh() {
      try {
         this.frame = whl.get(this.name).fittedImage(this.width, this.height);
      } catch (Throwable var2) {
         this.frame = null;
      }

      this.live = this.frame != null;
   }

   boolean live() {
      return this.live && this.frame != null;
   }

   public GpuTexture method_68004() {
      return this.live() ? this.frame.gpuTexture() : this.fallback.method_68004();
   }

   public GpuTextureView method_71659() {
      return this.live() ? this.frame.view : this.fallback.method_71659();
   }

   public void close() {
   }
}
