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
   @Nullable
   private final ScreenRect uia;
   private final List<SimpleGuiElementRenderState> uib = new ArrayList<>();
   private int uic = Integer.MAX_VALUE;
   private int uid = Integer.MAX_VALUE;
   private int uie = Integer.MIN_VALUE;
   private int uif = Integer.MIN_VALUE;
   @Nullable
   private ScreenRect uig;

   uhx(SimpleGuiElementRenderState var1) {
      this.uhy = var1.comp_4055();
      this.uhz = var1.comp_4056();
      this.uia = var1.comp_4069();
      this.add(var1);
   }

   boolean accepts(SimpleGuiElementRenderState var1) {
      return var1.comp_4055() == this.uhy && Objects.equals(var1.comp_4069(), this.uia) && var1.comp_4056().equals(this.uhz);
   }

   void add(SimpleGuiElementRenderState var1) {
      ScreenRect var2 = var1.comp_4274();
      if (var2 != null) {
         this.uib.add(var1);
         this.uic = Math.min(this.uic, var2.method_49620());
         this.uid = Math.min(this.uid, var2.method_49618());
         this.uie = Math.max(this.uie, var2.method_49621());
         this.uif = Math.max(this.uif, var2.method_49619());
         this.uig = null;
      }
   }

   boolean isEmpty() {
      return this.uib.isEmpty();
   }

   public void method_70917(VertexConsumer var1) {
      for (SimpleGuiElementRenderState var3 : this.uib) {
         var3.method_70917(var1);
      }
   }

   public RenderPipeline comp_4055() {
      return this.uhy;
   }

   public TextureSetup comp_4056() {
      return this.uhz;
   }

   @Nullable
   public ScreenRect comp_4069() {
      return this.uia;
   }

   @Nullable
   public ScreenRect comp_4274() {
      if (this.uig == null && this.uie > this.uic && this.uif > this.uid) {
         this.uig = new ScreenRect(this.uic, this.uid, this.uie - this.uic, this.uif - this.uid);
      }

      return this.uig;
   }
}
