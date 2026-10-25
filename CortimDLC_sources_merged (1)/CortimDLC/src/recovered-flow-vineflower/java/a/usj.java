package a;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;

public final class usj extends ItemEntityRenderer {
   final Random usk = Random.create();

   public usj(Context var1) {
      super(var1);
   }

   @Override
   public ItemEntityRenderState createRenderState() {
      return new usg();
   }

   @Override
   public void updateRenderState(ItemEntity var1, ItemEntityRenderState var2, float var3) {
      super.updateRenderState(var1, var2, var3);
      if (var2 instanceof usg var4) {
         var4.onGround = var1.isOnGround();
         var4.inWater = var1.isTouchingWater();
         var4.id = var1.getId();
      }
   }

   @Override
   public void render(ItemEntityRenderState var1, MatrixStack var2, OrderedRenderCommandQueue var3, CameraRenderState var4) {
      if (rfp.on() && var1 instanceof usg var5 && !var1.itemRenderState.isEmpty()) {
         Box var6 = var1.itemRenderState.getModelBoundingBox();
         boolean var7 = var6.getLengthZ() <= 0.0625;
         float var8 = var5.id * 137.508F % 360.0F;
         int var9 = Math.max(1, var1.renderedAmount);
         var2.push();
         if (!var5.onGround || var5.inWater) {
            float var11 = var1.age * (var5.inWater ? 4.0F : 14.0F) * rfp.spin();
            var2.translate(0.0F, (float)(-var6.minY + 0.0625), 0.0F);
            var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var8 + var11));
            var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var11 * 0.8F));
         } else if (var7) {
            float var10 = (float)(var6.getLengthZ() * 0.5) + (var9 - 1) * 0.046875F + 0.004F;
            var2.translate(0.0F, var10, 0.0F);
            var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var8));
            var2.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(90.0F));
            var2.translate((float)(-var6.getCenter().x), (float)(-var6.getCenter().y), 0.0F);
         } else {
            var2.translate(0.0F, (float)(-var6.minY), 0.0F);
            var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var8));
         }

         ItemEntityRenderer.render(var2, var3, var1.light, var1, this.usk, var6);
         var2.pop();
      } else {
         super.render(var1, var2, var3, var4);
      }
   }
}
