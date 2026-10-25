package a;

import java.util.Optional;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class lme {
   static final double[] lmf = new double[]{0.0, 0.35, 0.6, 0.8, 1.0};
   static final double lmg = 0.12;
   final Random lmh = new Random();
   double lmi = 0.5;
   double lmj = 0.5;
   double lmk = 0.5;

   public void roll(double var1) {
      double var3 = MathHelper.clamp(var1, 0.0, 0.9);
      this.lmi = 0.5 + (this.lmh.nextDouble() - 0.5) * var3;
      this.lmj = 0.5 + (this.lmh.nextDouble() - 0.5) * var3;
      this.lmk = 0.5 + (this.lmh.nextDouble() - 0.5) * var3;
   }

   public Vec3d on(Box var1) {
      return new Vec3d(
         MathHelper.lerp(this.lmi, var1.minX, var1.maxX), MathHelper.lerp(this.lmj, var1.minY, var1.maxY), MathHelper.lerp(this.lmk, var1.minZ, var1.maxZ)
      );
   }

   public Vec3d resolve(World var1, Entity var2, Vec3d var3, Box var4, double var5) {
      Vec3d var7 = this.on(var4);
      if (var4.contains(var3)) {
         return var7;
      }

      if (var4.squaredMagnitude(var3) > var5 * var5) {
         return null;
      }

      Box var8 = var4.contract(Math.min(0.12, var4.getLengthX() * 0.25), Math.min(0.12, var4.getLengthY() * 0.25), Math.min(0.12, var4.getLengthZ() * 0.25));
      Vec3d var9 = new Vec3d(
         MathHelper.clamp(var3.x, var8.minX, var8.maxX), MathHelper.clamp(var3.y, var8.minY, var8.maxY), MathHelper.clamp(var3.z, var8.minZ, var8.maxZ)
      );

      for (double var13 : lmf) {
         Vec3d var15 = var7.lerp(var9, var13);
         Vec3d var16 = entry(var4, var3, var15);
         if (var16 != null && var16.squaredDistanceTo(var3) <= var5 * var5 && clear(var1, var2, var3, var16)) {
            return var15;
         }
      }

      return null;
   }

   public static Vec3d entry(Box var0, Vec3d var1, Vec3d var2) {
      if (var0.contains(var1)) {
         return var1;
      }

      Vec3d var3 = var1.add(var2.subtract(var1).multiply(1.5));
      Optional var4 = var0.raycast(var1, var3);
      return (Vec3d)var4.orElse(null);
   }

   public static boolean clear(World var0, Entity var1, Vec3d var2, Vec3d var3) {
      return var0.raycast(new RaycastContext(var2, var3, ShapeType.OUTLINE, FluidHandling.NONE, var1)).getType() == Type.MISS;
   }

   public static float yaw(Vec3d var0, Vec3d var1) {
      return (float)(MathHelper.atan2(var1.z - var0.z, var1.x - var0.x) * 180.0F / (float)Math.PI) - 90.0F;
   }

   public static float pitch(Vec3d var0, Vec3d var1) {
      double var2 = var1.x - var0.x;
      double var4 = var1.z - var0.z;
      return (float)(-(MathHelper.atan2(var1.y - var0.y, Math.sqrt(var2 * var2 + var4 * var4)) * 180.0F / (float)Math.PI));
   }
}
