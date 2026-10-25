package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.jspecify.annotations.Nullable;

final class uhx implements SimpleGuiElementRenderState {
   private final RenderPipeline uhy;
   private final TextureSetup uhz;
   private final @Nullable ScreenRect uia;
   private final List<SimpleGuiElementRenderState> uib = new ArrayList<>();
   private int uic = Integer.MAX_VALUE;
   private int uid = Integer.MAX_VALUE;
   private int uie = Integer.MIN_VALUE;
   private int uif = Integer.MIN_VALUE;
   private @Nullable ScreenRect uig;

   uhx(SimpleGuiElementRenderState var1) {
      this.uhy = var1.pipeline();
      this.uhz = var1.textureSetup();
      this.uia = var1.scissorArea();
      this.add(var1);
   }

   boolean accepts(SimpleGuiElementRenderState var1) {
      return var1.pipeline() == this.uhy && Objects.equals(var1.scissorArea(), this.uia) && var1.textureSetup().equals(this.uhz);
   }

   void add(SimpleGuiElementRenderState var1) {
      ScreenRect var2 = var1.bounds();
      if (var2 != null) {
         this.uib.add(var1);
         this.uic = Math.min(this.uic, var2.getLeft());
         this.uid = Math.min(this.uid, var2.getTop());
         this.uie = Math.max(this.uie, var2.getRight());
         this.uif = Math.max(this.uif, var2.getBottom());
         this.uig = null;
      }
   }

   boolean isEmpty() {
      return this.uib.isEmpty();
   }

   @Override
   public void setupVertices(VertexConsumer vertices) {
      for (SimpleGuiElementRenderState var3 : this.uib) {
         var3.setupVertices(vertices);
      }
   }

   @Override
   public RenderPipeline pipeline() {
      return this.uhy;
   }

   @Override
   public TextureSetup textureSetup() {
      return this.uhz;
   }

   @Override
   public @Nullable ScreenRect scissorArea() {
      return this.uia;
   }

   @Override
   public @Nullable ScreenRect bounds() {
      if (this.uig == null && this.uie > this.uic && this.uif > this.uid) {
         this.uig = new ScreenRect(this.uic, this.uid, this.uie - this.uic, this.uif - this.uid);
      }

      return this.uig;
   }
}
