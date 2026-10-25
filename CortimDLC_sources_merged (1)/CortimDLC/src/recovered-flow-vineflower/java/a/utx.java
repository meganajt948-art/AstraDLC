package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;
import org.joml.Vector2f;
import org.jspecify.annotations.Nullable;

final class utx implements SimpleGuiElementRenderState {
   private final RenderPipeline uty;
   private final TextureSetup utz;
   private final Matrix3x2f uua;
   private final float uub;
   private final float uuc;
   private final float uud;
   private final float uue;
   private final int uuf;
   private final int uug;
   private final int uuh;
   private final int uui;
   private final int uuj;
   private final int uuk;
   private final float uul;
   private final float uum;
   private final float uun;
   private final @Nullable ScreenRect uuo;
   private final @Nullable ScreenRect uup;

   utx(
      RenderPipeline pipeline,
      TextureSetup textureSetup,
      Matrix3x2f pose,
      float x,
      float y,
      float w,
      float h,
      int cTL,
      int cTR,
      int cBR,
      int cBL,
      int radiiA,
      int radiiB,
      float z,
      float pad,
      float param,
      @Nullable ScreenRect scissorArea,
      @Nullable ScreenRect bounds
   ) {
      this.uty = pipeline;
      this.utz = textureSetup;
      this.uua = pose;
      this.uub = x;
      this.uuc = y;
      this.uud = w;
      this.uue = h;
      this.uuf = cTL;
      this.uug = cTR;
      this.uuh = cBR;
      this.uui = cBL;
      this.uuj = radiiA;
      this.uuk = radiiB;
      this.uul = z;
      this.uum = pad;
      this.uun = param;
      this.uuo = scissorArea;
      this.uup = bounds;
   }

   static float pad(float var0) {
      return var0 + 1.5F;
   }

   @Override
   public void setupVertices(VertexConsumer vertices) {
      float var2 = this.uub - this.uum;
      float var3 = this.uuc - this.uum;
      float var4 = this.uub + this.uud + this.uum;
      float var5 = this.uuc + this.uue + this.uum;
      float var6 = this.uub + this.uud * 0.5F;
      float var7 = this.uuc + this.uue * 0.5F;
      int var8 = Math.min(32767, Math.round(this.uud * 4.0F));
      int var9 = Math.min(32767, Math.round(this.uue * 4.0F));
      Vector2f var10 = new Vector2f();
      this.uus(vertices, var10, var2, var3, var2 - var6, var3 - var7, this.uuf, var8, var9);
      this.uus(vertices, var10, var2, var5, var2 - var6, var5 - var7, this.uui, var8, var9);
      this.uus(vertices, var10, var4, var5, var4 - var6, var5 - var7, this.uuh, var8, var9);
      this.uus(vertices, var10, var4, var3, var4 - var6, var3 - var7, this.uug, var8, var9);
   }

   private void uus(VertexConsumer var1, Vector2f var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9) {
      this.uua.transformPosition(var3, var4, var2);
      var1.vertex(var2.x, var2.y, this.uul).color(var7).texture(var5, var6).overlay(var8, var9).light(this.uuj, this.uuk).lineWidth(this.uun);
   }

   static int packRadii(float var0, float var1) {
      int var2 = Math.max(0, Math.min(255, Math.round(var0 * 2.0F)));
      int var3 = Math.max(0, Math.min(255, Math.round(var1 * 2.0F)));
      return var2 | var3 << 8;
   }

   @Override
   public RenderPipeline pipeline() {
      return this.uty;
   }

   @Override
   public TextureSetup textureSetup() {
      return this.utz;
   }

   public Matrix3x2f pose() {
      return this.uua;
   }

   public float x() {
      return this.uub;
   }

   public float y() {
      return this.uuc;
   }

   public float w() {
      return this.uud;
   }

   public float h() {
      return this.uue;
   }

   public int cTL() {
      return this.uuf;
   }

   public int cTR() {
      return this.uug;
   }

   public int cBR() {
      return this.uuh;
   }

   public int cBL() {
      return this.uui;
   }

   public int radiiA() {
      return this.uuj;
   }

   public int radiiB() {
      return this.uuk;
   }

   public float z() {
      return this.uul;
   }

   public float pad() {
      return this.uum;
   }

   public float param() {
      return this.uun;
   }

   @Override
   public @Nullable ScreenRect scissorArea() {
      return this.uuo;
   }

   @Override
   public @Nullable ScreenRect bounds() {
      return this.uup;
   }
}
