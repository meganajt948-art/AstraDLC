package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.jspecify.annotations.Nullable;

record utf(
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
) implements SimpleGuiElementRenderState {
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
   @Nullable
   private final ScreenRect utt;
   @Nullable
   private final ScreenRect utu;

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

   public TextureSetup comp_4056() {
      return TextureSetup.method_70899();
   }

   public void method_70917(VertexConsumer var1) {
      var1.method_22912(this.uth, this.uti, 0.0F).method_39415(this.utp);
      var1.method_22912(this.utj, this.utk, 0.0F).method_39415(this.utq);
      var1.method_22912(this.utl, this.utm, 0.0F).method_39415(this.utr);
      var1.method_22912(this.utn, this.uto, 0.0F).method_39415(this.uts);
   }

   public RenderPipeline comp_4055() {
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

   @Nullable
   public ScreenRect comp_4069() {
      return this.utt;
   }

   @Nullable
   public ScreenRect comp_4274() {
      return this.utu;
   }
}
