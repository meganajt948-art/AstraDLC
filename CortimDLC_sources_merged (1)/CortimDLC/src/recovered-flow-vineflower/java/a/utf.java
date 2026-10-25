package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.jspecify.annotations.Nullable;

final class utf implements SimpleGuiElementRenderState {
   private final RenderPipeline utg;
   private final float uth;
   private final float uti;
   private final float utj;
   private final float utk;
   private final float utl;
   private final float utm;
   private final float utn;
   private final float uto;
   private final int utp;
   private final int utq;
   private final int utr;
   private final int uts;
   private final @Nullable ScreenRect utt;
   private final @Nullable ScreenRect utu;

   utf(
      RenderPipeline pipeline,
      float x0,
      float y0,
      float x1,
      float y1,
      float x2,
      float y2,
      float x3,
      float y3,
      int c0,
      int c1,
      int c2,
      int c3,
      @Nullable ScreenRect scissorArea,
      @Nullable ScreenRect bounds
   ) {
      this.utg = pipeline;
      this.uth = x0;
      this.uti = y0;
      this.utj = x1;
      this.utk = y1;
      this.utl = x2;
      this.utm = y2;
      this.utn = x3;
      this.uto = y3;
      this.utp = c0;
      this.utq = c1;
      this.utr = c2;
      this.uts = c3;
      this.utt = scissorArea;
      this.utu = bounds;
   }

   @Override
   public TextureSetup textureSetup() {
      return TextureSetup.empty();
   }

   @Override
   public void setupVertices(VertexConsumer vertices) {
      vertices.vertex(this.uth, this.uti, 0.0F).color(this.utp);
      vertices.vertex(this.utj, this.utk, 0.0F).color(this.utq);
      vertices.vertex(this.utl, this.utm, 0.0F).color(this.utr);
      vertices.vertex(this.utn, this.uto, 0.0F).color(this.uts);
   }

   @Override
   public RenderPipeline pipeline() {
      return this.utg;
   }

   public float x0() {
      return this.uth;
   }

   public float y0() {
      return this.uti;
   }

   public float x1() {
      return this.utj;
   }

   public float y1() {
      return this.utk;
   }

   public float x2() {
      return this.utl;
   }

   public float y2() {
      return this.utm;
   }

   public float x3() {
      return this.utn;
   }

   public float y3() {
      return this.uto;
   }

   public int c0() {
      return this.utp;
   }

   public int c1() {
      return this.utq;
   }

   public int c2() {
      return this.utr;
   }

   public int c3() {
      return this.uts;
   }

   @Override
   public @Nullable ScreenRect scissorArea() {
      return this.utt;
   }

   @Override
   public @Nullable ScreenRect bounds() {
      return this.utu;
   }
}
