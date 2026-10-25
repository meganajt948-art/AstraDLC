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
   private final Random usk = Random.method_43047();

   public usj(Context var1) {
      super(var1);
   }

   public ItemEntityRenderState method_62469() {
      return new usg();
   }

   public void method_62470(ItemEntity var1, ItemEntityRenderState var2, float var3) {
      super.method_62470(var1, var2, var3);
      if (var2 instanceof usg var4) {
         var4.onGround = var1.method_24828();
         var4.inWater = var1.method_5799();
         var4.id = var1.method_5628();
      }
   }

   public void method_3996(ItemEntityRenderState var1, MatrixStack var2, OrderedRenderCommandQueue var3, CameraRenderState var4) {
      if (rfp.on() && var1 instanceof usg var5 && !var1.field_55310.method_65606()) {
         Box var6 = var1.field_55310.method_72173();
         boolean var7 = var6.method_17941() <= 0.0625;
         float var8 = var5.id * 137.508F % 360.0F;
         int var9 = Math.max(1, var1.field_55311);
         var2.method_22903();
         if (!var5.onGround || var5.inWater) {
            float var11 = var1.field_53328 * (var5.inWater ? 4.0F : 14.0F) * rfp.spin();
            var2.method_46416(0.0F, (float)(-var6.field_1322 + 0.0625), 0.0F);
            var2.method_22907(RotationAxis.field_40716.rotationDegrees(var8 + var11));
            var2.method_22907(RotationAxis.field_40714.rotationDegrees(var11 * 0.8F));
         } else if (var7) {
            float var10 = (float)(var6.method_17941() * 0.5) + (var9 - 1) * 0.046875F + 0.004F;
            var2.method_46416(0.0F, var10, 0.0F);
            var2.method_22907(RotationAxis.field_40716.rotationDegrees(var8));
            var2.method_22907(RotationAxis.field_40713.rotationDegrees(90.0F));
            var2.method_46416((float)(-var6.method_1005().field_1352), (float)(-var6.method_1005().field_1351), 0.0F);
         } else {
            var2.method_46416(0.0F, (float)(-var6.field_1322), 0.0F);
            var2.method_22907(RotationAxis.field_40716.rotationDegrees(var8));
         }

         ItemEntityRenderer.method_72986(var2, var3, var1.field_61820, var1, this.usk, var6);
         var2.method_22909();
      } else {
         super.method_3996(var1, var2, var3, var4);
      }
   }
}
