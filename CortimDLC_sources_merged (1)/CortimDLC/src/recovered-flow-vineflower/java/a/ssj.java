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

   @Nullable
   static List<spg> capture(MinecraftClient var0, LivingEntity var1, float var2, double[] var3) {
      try {
         EntityRenderer var4 = var0.method_1561().method_3953(var1);
         if (var4 instanceof LivingEntityRenderer var5) {
            if (var4.method_62425(var1, var2) instanceof LivingEntityRenderState var7) {
               EntityModel var8 = var5.method_4038();
               ssr(var8, var7);
               boolean var9 = var8 instanceof BipedEntityModel;
               boolean var10 = var1 instanceof PlayerEntity;
               MatrixStack var11 = sso(var7.field_53453, var7.field_53446, var10 ? 0.9375F : 1.0F);
               ArrayList var12 = new ArrayList();
               var8.method_63512()
                  .method_35745(
                     var11,
                     (var3x, var4x, var5x, var6) -> {
                        if (!var9 || var4x.lastIndexOf(47) <= 0) {
                           var12.add(
                              ssp(
                                 var3x.method_23761(),
                                 var3x.method_23762(),
                                 var6.field_3645,
                                 var6.field_3644,
                                 var6.field_3643,
                                 var6.field_3648,
                                 var6.field_3647,
                                 var6.field_3646,
                                 ssq(var1, var4x, var9)
                              )
                           );
                        }
                     }
                  );
               var8.method_63514();
               var3[0] = var7.field_53325;
               var3[1] = var7.field_53326;
               var3[2] = var7.field_53327;
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
      var1.method_22903();
      var1.method_46416(var2 / 16.0F, var3 / 16.0F, var4 / 16.0F);
      Entry var11 = var1.method_23760();
      var0.add(ssp(var11.method_23761(), var11.method_23762(), var5, var6, var7, var8, var9, var10, 0.6F));
      var1.method_22909();
   }

   private static MatrixStack sso(float var0, float var1, float var2) {
      MatrixStack var3 = new MatrixStack();
      var3.method_22905(var0, var0, var0);
      var3.method_22907(RotationAxis.field_40716.rotationDegrees(180.0F - var1));
      var3.method_22905(-1.0F, -1.0F, 1.0F);
      var3.method_22905(var2, var2, var2);
      var3.method_46416(0.0F, -1.501F, 0.0F);
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
      } else {
         EquipmentSlot var3 = switch (var1) {
            case "/head" -> EquipmentSlot.field_6169;
            case "/body", "/right_arm", "/left_arm" -> EquipmentSlot.field_6174;
            case "/right_leg", "/left_leg" -> EquipmentSlot.field_6172;
            default -> null;
         };
         if (var3 == null) {
            return 0.6F;
         } else {
            boolean var4 = !var0.method_6118(var3).method_7960()
               || var3 == EquipmentSlot.field_6172 && !var0.method_6118(EquipmentSlot.field_6166).method_7960();
            return var4 ? 1.1F : 0.6F;
         }
      }
   }

   private static void ssr(EntityModel var0, LivingEntityRenderState var1) {
      var0.method_2819(var1);
   }
}
