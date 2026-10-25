package flow.cosmetic;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;

public final class CosmeticFeature extends FeatureRenderer<PlayerEntityRenderState, PlayerEntityModel> {
   private final boolean lead;

   public CosmeticFeature(FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel> context, boolean lead) {
      super(context);
      this.lead = lead;
   }

   public void render(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, PlayerEntityRenderState state, float limbAngle, float limbDistance) {
      if (this.lead) {
         Cosmetics.renderWorn((PlayerEntityModel)this.method_17165(), matrices, queue, light, state);
      } else {
         Cosmetics.restoreArms();
      }
   }
}
