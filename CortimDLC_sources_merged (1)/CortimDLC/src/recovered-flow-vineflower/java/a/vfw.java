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
   @Nullable
   private final ScreenRect vgc;
   @Nullable
   private final ScreenRect vgd;

   public vfw(TextureSetup textureSetup, Matrix3x2f pose, float[] quads, int[] colors, int count, @Nullable ScreenRect scissorArea, @Nullable ScreenRect bounds) {
      this.vfx = textureSetup;
      this.vfy = pose;
      this.vfz = quads;
      this.vga = colors;
      this.vgb = count;
      this.vgc = scissorArea;
      this.vgd = bounds;
   }

   public RenderPipeline comp_4055() {
      return RenderPipelines.field_56883;
   }

   public void method_70917(VertexConsumer var1) {
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
         var1.method_70815(this.vfy, var4, var5).method_22913(var8, var9).method_39415(var12);
         var1.method_70815(this.vfy, var4, var7).method_22913(var8, var11).method_39415(var12);
         var1.method_70815(this.vfy, var6, var7).method_22913(var10, var11).method_39415(var12);
         var1.method_70815(this.vfy, var6, var5).method_22913(var10, var9).method_39415(var12);
      }
   }

   public TextureSetup comp_4056() {
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

   @Nullable
   public ScreenRect comp_4069() {
      return this.vgc;
   }

   @Nullable
   public ScreenRect comp_4274() {
      return this.vgd;
   }
}
