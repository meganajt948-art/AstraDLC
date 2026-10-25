package a;

import java.util.List;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

final class ktf {
   static final int HORIZON = 20;
   private static final double ktg = 0.003;
   private static final double kth = 4.0E-8;
   private static final double kti = 16.0;
   private final ktc ktj = new ktc();
   private final ktc ktk = new ktc();
   private ClientPlayerEntity ktl;
   private double ktm;
   private double ktn;
   private double kto;
   private float ktp;
   private float ktq;
   private boolean ktr;
   private final boolean[] kts = new boolean[20];
   private final boolean[] ktt = new boolean[20];
   private final boolean[] ktu = new boolean[20];
   private final boolean[] ktv = new boolean[20];
   private final double[] ktw = new double[20];
   private final double[] ktx = new double[20];
   private final double[] kty = new double[20];
   private final double[] ktz = new double[20];

   void sync(ClientPlayerEntity var1) {
      this.ktl = var1;
      this.ktm = var1.getX();
      this.ktn = var1.getY();
      this.kto = var1.getZ();
      this.ktp = var1.getYaw();
      this.ktq = var1.getPitch();
      this.ktr = var1.isOnGround();
      this.ktj.ground = this.ktr;
      this.ktj.velocity = this.ktr ? -var1.getFinalGravity() * 0.98 : var1.getVelocity().y;
      this.ktj.fall = 0.0;
   }

   void afterMove(ClientPlayerEntity var1, World var2) {
      if (var1 != this.ktl) {
         this.sync(var1);
      } else {
         double var3 = var1.getX() - this.ktm;
         double var5 = var1.getY() - this.ktn;
         double var7 = var1.getZ() - this.kto;
         double var9 = var3 * var3 + var5 * var5 + var7 * var7;
         if (!(var9 > 16.0) && !var1.hasVehicle()) {
            boolean var11 = var1.isOnGround();
            boolean var12 = var9 > 4.0E-8;
            boolean var13 = var1.getYaw() != this.ktp || var1.getPitch() != this.ktq;
            if (var12 || var13 || var11 != this.ktr) {
               this.ktj.receive(var12 ? var5 : 0.0, var11, ksp.jumpVelocity(var1, var2), var1.isTouchingWater());
               if (var12) {
                  this.ktm = var1.getX();
                  this.ktn = var1.getY();
                  this.kto = var1.getZ();
               }

               if (var13) {
                  this.ktp = var1.getYaw();
                  this.ktq = var1.getPitch();
               }

               this.ktr = var11;
            }

            this.ktj.tick(var1, var2, var1.getBoundingBox(), var1.getFinalGravity());
         } else {
            this.sync(var1);
         }
      }
   }

   void predict(ClientPlayerEntity var1, World var2, boolean var3, int var4, boolean var5) {
      Box var6 = var1.getBoundingBox();
      boolean var7 = var1.isOnGround();
      Vec3d var8 = var1.getVelocity();
      double var9 = var8.x;
      double var11 = var8.y;
      double var13 = var8.z;
      double var15 = var1.sidewaysSpeed;
      double var17 = var1.forwardSpeed;
      double var19 = var15 * var15 + var17 * var17;
      if (var19 < 1.0E-7) {
         var15 = 0.0;
         var17 = 0.0;
      } else if (var19 > 1.0) {
         double var21 = Math.sqrt(var19);
         var15 /= var21;
         var17 /= var21;
      }

      float var57 = var1.getYaw() * (float) (Math.PI / 180.0);
      double var22 = MathHelper.sin(var57);
      double var24 = MathHelper.cos(var57);
      double var26 = var15 * var24 - var17 * var22;
      double var28 = var17 * var24 + var15 * var22;
      if (var7 && var1.isSneaking()) {
         var9 = 0.0;
         var13 = 0.0;
         var26 = 0.0;
         var28 = 0.0;
      }

      float var30 = var2.getBlockState(var1.getVelocityAffectingPos()).getBlock().getSlipperiness();
      double var31 = var1.getMovementSpeed() * (0.21600002 / (var30 * var30 * var30));
      double var33 = var1.isSprinting() ? 0.026 : 0.02;
      boolean var35 = var1.isSprinting();
      double var36 = var1.getFinalGravity();
      float var38 = ksp.jumpVelocity(var1, var2);
      int var39 = var5 ? 0 : var4;
      boolean var40 = var1.isTouchingWater();
      this.ktk.copy(this.ktj);
      double var41 = 0.0;
      double var43 = 0.0;
      double var45 = 0.0;

      for (int var47 = 0; var47 < 20; var47++) {
         this.ktu[var47] = !var7;
         this.ktv[var47] = this.ktk.ground;
         this.ktw[var47] = this.ktk.fall;
         this.kts[var47] = this.ktk.fall > 0.0 && !this.ktk.ground;
         this.ktt[var47] = this.kts[var47] && !this.ktk.groundsLater(var1, var2, var6, var36);
         this.ktx[var47] = var41;
         this.kty[var47] = var43;
         this.ktz[var47] = var45;
         if (var39 > 0) {
            var39--;
         }

         if (Math.abs(var11) < 0.003) {
            var11 = 0.0;
         }

         if (var9 * var9 + var13 * var13 < 9.0E-6) {
            var9 = 0.0;
            var13 = 0.0;
         }

         if (var3) {
            if (var7 && var39 == 0 && var38 > 1.0E-5F) {
               var11 = Math.max(var38, var11);
               var39 = var5 ? 0 : 10;
               if (var35) {
                  var9 -= var22 * 0.2;
                  var13 += var24 * 0.2;
               }
            }
         } else {
            var39 = 0;
         }

         boolean var48 = var7;
         double var49 = var48 ? var31 : var33;
         var9 += var26 * var49;
         var13 += var28 * var49;
         Vec3d var51 = Entity.adjustMovementForCollisions(var1, new Vec3d(var9, var11, var13), var6, var2, List.of());
         boolean var52 = var51.y != var11;
         var7 = var52 && var11 < 0.0;
         if (var51.x != var9) {
            var9 = 0.0;
         }

         if (var51.z != var13) {
            var13 = 0.0;
         }

         var6 = var6.offset(var51);
         var41 += var51.x;
         var43 += var51.y;
         var45 += var51.z;
         if (var52) {
            var11 = 0.0;
         }

         var11 = (var11 - var36) * 0.98;
         double var53 = (var48 ? var30 : 1.0) * 0.91;
         var9 *= var53;
         var13 *= var53;
         this.ktk.receive(var51.y, var7, var38, var40);
         this.ktk.tick(var1, var2, var6, var36);
      }
   }

   boolean critAt(int var1) {
      return var1 >= 0 && var1 < 20 && this.kts[var1];
   }

   boolean safeAt(int var1) {
      return var1 >= 0 && var1 < 20 && this.ktt[var1];
   }

   boolean airAt(int var1) {
      return var1 >= 0 && var1 < 20 && this.ktu[var1];
   }

   boolean serverGroundAt(int var1) {
      return var1 >= 0 && var1 < 20 && this.ktv[var1];
   }

   double fallAt(int var1) {
      return var1 >= 0 && var1 < 20 ? this.ktw[var1] : 0.0;
   }

   boolean landsWithin(int var1, int var2) {
      if (!this.airAt(var1)) {
         return false;
      }

      for (int var3 = 1; var3 <= var2 && var1 + var3 < 20; var3++) {
         if (!this.ktu[var1 + var3]) {
            return true;
         }
      }

      return false;
   }

   Vec3d offsetAt(int var1) {
      int var2 = Math.max(0, Math.min(19, var1));
      return new Vec3d(this.ktx[var2], this.kty[var2], this.ktz[var2]);
   }

   private static double kuc(Entity var0, World var1, Box var2, double var3) {
      return Entity.adjustMovementForCollisions(var0, new Vec3d(0.0, var3, 0.0), var2, var1, List.of()).y;
   }
}
