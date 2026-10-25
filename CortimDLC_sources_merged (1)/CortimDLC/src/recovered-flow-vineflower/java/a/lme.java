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
   private static final double[] lmf = new double[]{0.0, 0.35, 0.6, 0.8, 1.0};
   private static final double lmg = 0.12;
   private final Random lmh = new Random();
   private double lmi = 0.5;
   private double lmj = 0.5;
   private double lmk = 0.5;

   public void roll(double var1) {
      double var3 = MathHelper.method_15350(var1, 0.0, 0.9);
      this.lmi = 0.5 + (this.lmh.nextDouble() - 0.5) * var3;
      this.lmj = 0.5 + (this.lmh.nextDouble() - 0.5) * var3;
      this.lmk = 0.5 + (this.lmh.nextDouble() - 0.5) * var3;
   }

   public Vec3d on(Box var1) {
      return new Vec3d(
         MathHelper.method_16436(this.lmi, var1.field_1323, var1.field_1320),
         MathHelper.method_16436(this.lmj, var1.field_1322, var1.field_1325),
         MathHelper.method_16436(this.lmk, var1.field_1321, var1.field_1324)
      );
   }

   public Vec3d resolve(World var1, Entity var2, Vec3d var3, Box var4, double var5) {
      Vec3d var7 = this.on(var4);
      if (var4.method_1006(var3)) {
         return var7;
      } else if (var4.method_49271(var3) > var5 * var5) {
         return null;
      } else {
         Box var8 = var4.method_35580(
            Math.min(0.12, var4.method_17939() * 0.25), Math.min(0.12, var4.method_17940() * 0.25), Math.min(0.12, var4.method_17941() * 0.25)
         );
         Vec3d var9 = new Vec3d(
            MathHelper.method_15350(var3.field_1352, var8.field_1323, var8.field_1320),
            MathHelper.method_15350(var3.field_1351, var8.field_1322, var8.field_1325),
            MathHelper.method_15350(var3.field_1350, var8.field_1321, var8.field_1324)
         );

         for (double var13 : lmf) {
            Vec3d var15 = var7.method_35590(var9, var13);
            Vec3d var16 = entry(var4, var3, var15);
            if (var16 != null && var16.method_1025(var3) <= var5 * var5 && clear(var1, var2, var3, var16)) {
               return var15;
            }
         }

         return null;
      }
   }

   public static Vec3d entry(Box var0, Vec3d var1, Vec3d var2) {
      if (var0.method_1006(var1)) {
         return var1;
      } else {
         Vec3d var3 = var1.method_1019(var2.method_1020(var1).method_1021(1.5));
         Optional var4 = var0.method_992(var1, var3);
         return (Vec3d)var4.orElse(null);
      }
   }

   public static boolean clear(World var0, Entity var1, Vec3d var2, Vec3d var3) {
      return var0.method_17742(new RaycastContext(var2, var3, ShapeType.field_17559, FluidHandling.field_1348, var1)).method_17783() == Type.field_1333;
   }

   public static float yaw(Vec3d var0, Vec3d var1) {
      return (float)(MathHelper.method_15349(var1.field_1350 - var0.field_1350, var1.field_1352 - var0.field_1352) * 180.0F / (float)Math.PI) - 90.0F;
   }

   public static float pitch(Vec3d var0, Vec3d var1) {
      double var2 = var1.field_1352 - var0.field_1352;
      double var4 = var1.field_1350 - var0.field_1350;
      return (float)(-(MathHelper.method_15349(var1.field_1351 - var0.field_1351, Math.sqrt(var2 * var2 + var4 * var4)) * 180.0F / (float)Math.PI));
   }
}
