package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class prt {
   private prt() {
   }

   public static Vec3d getEyesPos(Entity var0) {
      return var0.method_73189().method_1031(0.0, var0.method_18381(var0.method_18376()), 0.0);
   }

   public static float[] calculateAngle(Vec3d var0) {
      MinecraftClient var1 = MinecraftClient.method_1551();
      return var1.field_1724 == null ? new float[]{0.0F, 0.0F} : calculateAngle(getEyesPos(var1.field_1724), var0);
   }

   public static float[] calculateAngle(Vec3d var0, Vec3d var1) {
      double var2 = var1.field_1352 - var0.field_1352;
      double var4 = (var1.field_1351 - var0.field_1351) * -1.0;
      double var6 = var1.field_1350 - var0.field_1350;
      double var8 = MathHelper.method_15355((float)(var2 * var2 + var6 * var6));
      float var10 = (float)MathHelper.method_15338(Math.toDegrees(Math.atan2(var6, var2)) - 90.0);
      float var11 = (float)MathHelper.method_15350(MathHelper.method_15338(Math.toDegrees(Math.atan2(var4, var8))), -90.0, 90.0);
      return new float[]{var10, var11};
   }
}
