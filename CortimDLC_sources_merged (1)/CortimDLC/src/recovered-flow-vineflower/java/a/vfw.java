package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

public record vfw(
   TextureSetup textureSetup, Matrix3x2f pose, float[] quads, int[] colors, int count, @Nullable ScreenRect scissorArea, @Nullable ScreenRect bounds
) implements SimpleGuiElementRenderState {
   private final TextureSetup vfx;
   private final Matrix3x2f vfy;
   private final float[] vfz;
   private final int[] vga;
   private final int vgb;
   private final @Nullable ScreenRect vgc;
   private final @Nullable ScreenRect vgd;

   public vfw(TextureSetup textureSetup, Matrix3x2f pose, float[] quads, int[] colors, int count, @Nullable ScreenRect scissorArea, @Nullable ScreenRect bounds) {
      this.vfx = textureSetup;
      this.vfy = pose;
      this.vfz = quads;
      this.vga = colors;
      this.vgb = count;
      this.vgc = scissorArea;
      this.vgd = bounds;
   }

   @Override
   public RenderPipeline pipeline() {
      return RenderPipelines.GUI_TEXTURED;
   }

   @Override
   public void setupVertices(VertexConsumer vertices) {
      for (int var2 = 0; var2 < this.vgb; var2++) {
         int var3 = var2 * 8;
         float var4 = this.vfz[var3];
         float var5 = this.vfz[var3 + 1];
         float var6 = this.vfz[var3 + 2];
         float var7 = this.vfz[var3 + 3];
         float var8 = this.vfz[var3 + 4];
         float var9 = this.vfz[var3 + 5];
         float var10 = this.vfz[var3 + 6];
         float var11 = this.vfz[var3 + 7];
         int var12 = this.vga[var2];
         vertices.vertex(this.vfy, var4, var5).texture(var8, var9).color(var12);
         vertices.vertex(this.vfy, var4, var7).texture(var8, var11).color(var12);
         vertices.vertex(this.vfy, var6, var7).texture(var10, var11).color(var12);
         vertices.vertex(this.vfy, var6, var5).texture(var10, var9).color(var12);
      }
   }

   @Override
   public TextureSetup textureSetup() {
      return this.vfx;
   }

   public Matrix3x2f pose() {
      return this.vfy;
   }

   public float[] quads() {
      return this.vfz;
   }

   public int[] colors() {
      return this.vga;
   }

   public int count() {
      return this.vgb;
   }

   @Override
   public @Nullable ScreenRect scissorArea() {
      return this.vgc;
   }

   @Override
   public @Nullable ScreenRect bounds() {
      return this.vgd;
   }
}
