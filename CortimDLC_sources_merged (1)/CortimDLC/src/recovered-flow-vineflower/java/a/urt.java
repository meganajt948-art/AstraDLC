package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.jspecify.annotations.Nullable;

final class urt implements SimpleGuiElementRenderState {
   private final RenderPipeline uru;
   private final float[] urv;
   private final int urw;
   private final int urx;
   private final int ury;
   private final int urz;
   private final float usa;
   private final float usb;
   private final @Nullable ScreenRect usc;
   private final @Nullable ScreenRect usd;

   urt(
      RenderPipeline pipeline,
      float[] corners,
      int color,
      int color2,
      int pattern,
      int flags,
      float param,
      float time,
      @Nullable ScreenRect scissorArea,
      @Nullable ScreenRect bounds
   ) {
      this.uru = pipeline;
      this.urv = corners;
      this.urw = color;
      this.urx = color2;
      this.ury = pattern;
      this.urz = flags;
      this.usa = param;
      this.usb = time;
      this.usc = scissorArea;
      this.usd = bounds;
   }

   @Override
   public TextureSetup textureSetup() {
      return TextureSetup.empty();
   }

   @Override
   public void setupVertices(VertexConsumer vertices) {
      int var2 = this.urx >> 16 & 0xFF;
      int var3 = this.urx >> 8 & 0xFF;
      int var4 = this.urx & 0xFF;
      int var5 = Math.max(0, Math.min(255, Math.round(this.usa * 255.0F)));
      int var6 = var2 << 8 | var3;
      int var7 = var4 << 8 | var5;

      for (int var8 = 0; var8 < 4; var8++) {
         int var9 = var8 * 5;
         float var10 = this.urv[var9 + 4];
         vertices.vertex(this.urv[var9], this.urv[var9 + 1], this.usb)
            .color(this.urw)
            .texture(this.urv[var9 + 2] * var10, this.urv[var9 + 3] * var10)
            .overlay(this.ury, this.urz)
            .light(var6, var7)
            .lineWidth(var10);
      }
   }

   @Override
   public RenderPipeline pipeline() {
      return this.uru;
   }

   public float[] corners() {
      return this.urv;
   }

   public int color() {
      return this.urw;
   }

   public int color2() {
      return this.urx;
   }

   public int pattern() {
      return this.ury;
   }

   public int flags() {
      return this.urz;
   }

   public float param() {
      return this.usa;
   }

   public float time() {
      return this.usb;
   }

   @Override
   public @Nullable ScreenRect scissorArea() {
      return this.usc;
   }

   @Override
   public @Nullable ScreenRect bounds() {
      return this.usd;
   }
}
