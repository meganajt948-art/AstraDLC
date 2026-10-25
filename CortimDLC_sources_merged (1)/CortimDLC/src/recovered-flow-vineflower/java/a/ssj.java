package a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.MatrixStack.Entry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.jspecify.annotations.Nullable;

final class ssj {
   private static final float ssk = 0.9375F;

   private ssj() {
   }

   static @Nullable List<spg> capture(MinecraftClient var0, LivingEntity var1, float var2, double[] var3) {
      try {
         EntityRenderer var4 = var0.getEntityRenderDispatcher().getRenderer(var1);
         if (var4 instanceof LivingEntityRenderer var5) {
            if (var4.getAndUpdateRenderState(var1, var2) instanceof LivingEntityRenderState var7) {
               EntityModel var8 = var5.getModel();
               ssr(var8, var7);
               boolean var9 = var8 instanceof BipedEntityModel;
               boolean var10 = var1 instanceof PlayerEntity;
               MatrixStack var11 = sso(var7.baseScale, var7.bodyYaw, var10 ? 0.9375F : 1.0F);
               ArrayList var12 = new ArrayList();
               var8.getRootPart()
                  .forEachCuboid(
                     var11,
                     (var3x, var4x, var5x, var6) -> {
                        if (!var9 || var4x.lastIndexOf(47) <= 0) {
                           var12.add(
                              ssp(
                                 var3x.getPositionMatrix(),
                                 var3x.getNormalMatrix(),
                                 var6.minX,
                                 var6.minY,
                                 var6.minZ,
                                 var6.maxX,
                                 var6.maxY,
                                 var6.maxZ,
                                 ssq(var1, var4x, var9)
                              )
                           );
                        }
                     }
                  );
               var8.resetTransforms();
               var3[0] = var7.x;
               var3[1] = var7.y;
               var3[2] = var7.z;
               return !var12.isEmpty() && var12.size() <= 64 ? var12 : null;
            } else {
               return null;
            }
         } else {
            return null;
         }
      } catch (Throwable var13) {
         return null;
      }
   }

   static List<spg> steve(float var0, float var1) {
      MatrixStack var2 = sso(1.0F, var0, 0.9375F * var1);
      ArrayList var3 = new ArrayList();
      ssn(var3, var2, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F, -4.0F, 4.0F, 0.0F, 4.0F);
      ssn(var3, var2, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 2.0F);
      ssn(var3, var2, -5.0F, 2.0F, 0.0F, -3.0F, -2.0F, -2.0F, 1.0F, 10.0F, 2.0F);
      ssn(var3, var2, 5.0F, 2.0F, 0.0F, -1.0F, -2.0F, -2.0F, 3.0F, 10.0F, 2.0F);
      ssn(var3, var2, -1.9F, 12.0F, 0.0F, -2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F);
      ssn(var3, var2, 1.9F, 12.0F, 0.0F, -2.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F);
      return var3;
   }

   private static void ssn(
      List<spg> var0, MatrixStack var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10
   ) {
      var1.push();
      var1.translate(var2 / 16.0F, var3 / 16.0F, var4 / 16.0F);
      Entry var11 = var1.peek();
      var0.add(ssp(var11.getPositionMatrix(), var11.getNormalMatrix(), var5, var6, var7, var8, var9, var10, 0.6F));
      var1.pop();
   }

   private static MatrixStack sso(float var0, float var1, float var2) {
      MatrixStack var3 = new MatrixStack();
      var3.scale(var0, var0, var0);
      var3.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - var1));
      var3.scale(-1.0F, -1.0F, 1.0F);
      var3.scale(var2, var2, var2);
      var3.translate(0.0F, -1.501F, 0.0F);
      return var3;
   }

   private static spg ssp(Matrix4f var0, Matrix3f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      Matrix4f var9 = new Matrix4f(var0).translate((var2 + var5) / 32.0F, (var3 + var6) / 32.0F, (var4 + var7) / 32.0F);
      float var10 = var8 / 16.0F;
      return new spg(var9, new Matrix3f(var1), (var5 - var2) / 32.0F + var10, (var6 - var3) / 32.0F + var10, (var7 - var4) / 32.0F + var10);
   }

   private static float ssq(LivingEntity var0, String var1, boolean var2) {
      if (!var2) {
         return 0.35F;
      }

      EquipmentSlot var3 = switch (var1) {
         case "/head" -> EquipmentSlot.HEAD;
         case "/body", "/right_arm", "/left_arm" -> EquipmentSlot.CHEST;
         case "/right_leg", "/left_leg" -> EquipmentSlot.LEGS;
         default -> null;
      };
      if (var3 == null) {
         return 0.6F;
      }

      boolean var6 = !var0.getEquippedStack(var3).isEmpty() || var3 == EquipmentSlot.LEGS && !var0.getEquippedStack(EquipmentSlot.FEET).isEmpty();
      return var6 ? 1.1F : 0.6F;
   }

   private static void ssr(EntityModel var0, LivingEntityRenderState var1) {
      var0.setAngles(var1);
   }
}
