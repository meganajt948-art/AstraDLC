package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class prt {
   prt() {
   }

   public static Vec3d getEyesPos(Entity var0) {
      return var0.getEntityPos().add(0.0, var0.getEyeHeight(var0.getPose()), 0.0);
   }

   public static float[] calculateAngle(Vec3d var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      return var1.player == null ? new float[]{0.0F, 0.0F} : calculateAngle(getEyesPos(var1.player), var0);
   }

   public static float[] calculateAngle(Vec3d var0, Vec3d var1) {
      double var2 = var1.x - var0.x;
      double var4 = (var1.y - var0.y) * -1.0;
      double var6 = var1.z - var0.z;
      double var8 = MathHelper.sqrt((float)(var2 * var2 + var6 * var6));
      float var10 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var6, var2)) - 90.0);
      float var11 = (float)MathHelper.clamp(MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var4, var8))), -90.0, 90.0);
      return new float[]{var10, var11};
   }
}
