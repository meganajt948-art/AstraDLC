package a;

import java.util.List;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

final class ksp {
   static final int HORIZON = 20;
   static final double SMASH_FALL = 1.52;
   static final int ksq = 2;
   static final int ksr = 22;
   final boolean[] kss = new boolean[22];
   final boolean[] kst = new boolean[22];
   final double[] ksu = new double[22];
   final double[] ksv = new double[22];
   final double[] ksw = new double[22];
   final double[] ksx = new double[22];

   void predict(ClientPlayerEntity var1, World var2, boolean var3, int var4, boolean var5, double var6) {
      Box var8 = var1.getBoundingBox();
      boolean var9 = var1.isOnGround();
      double var10 = var6;
      double var12 = var1.getVelocity().y;
      double var14 = var1.getX() - var1.lastX;
      double var16 = var1.getZ() - var1.lastZ;
      if (var9 && var1.isSneaking()) {
         var14 = 0.0;
         var16 = 0.0;
      }

      double var18 = var1.getFinalGravity();
      float var20 = jumpVelocity(var1, var2);
      int var21 = var5 ? 0 : var4;
      double var22 = 0.0;
      double var24 = 0.0;
      double var26 = 0.0;

      for (int var28 = 0; var28 < 22; var28++) {
         this.kss[var28] = var10 > 0.0 && !var9;
         this.kst[var28] = var9;
         this.ksu[var28] = var9 ? 0.0 : var10;
         this.ksv[var28] = var22;
         this.ksw[var28] = var24;
         this.ksx[var28] = var26;
         if (var21 > 0) {
            var21--;
         }

         if (Math.abs(var12) < 0.003) {
            var12 = 0.0;
         }

         if (var3) {
            if (var9 && var21 == 0 && var20 > 1.0E-5F) {
               var12 = Math.max(var20, var12);
               var21 = var5 ? 0 : 10;
            }
         } else {
            var21 = 0;
         }

         Vec3d var29 = Entity.adjustMovementForCollisions(var1, new Vec3d(var14, var12, var16), var8, var2, List.of());
         boolean var30 = var29.y != var12;
         var9 = var30 && var12 < 0.0;
         if (var29.x != var14) {
            var14 = 0.0;
         }

         if (var29.z != var16) {
            var16 = 0.0;
         }

         if (var29.y > 0.0) {
            var10 = 0.0;
         } else if (var29.y < 0.0) {
            var10 -= var29.y;
         }

         if (var9) {
            var10 = 0.0;
         }

         var8 = var8.offset(var29);
         var22 += var29.x;
         var24 += var29.y;
         var26 += var29.z;
         if (var30) {
            var12 = 0.0;
         }

         var12 = (var12 - var18) * 0.98;
      }
   }

   boolean critAt(int var1) {
      return !this.rawCritAt(var1) ? false : !this.kta(var1) || this.ktb(var1);
   }

   boolean kta(int var1) {
      for (int var2 = 1; var2 <= 2; var2++) {
         if (this.kst[var1 + var2]) {
            return true;
         }
      }

      return false;
   }

   boolean ktb(int var1) {
      int var2 = var1;

      while (var2 > 0 && !this.kst[var2 - 1]) {
         var2--;
      }

      for (int var3 = var2; var3 < 20; var3++) {
         if (this.kst[var3]) {
            return true;
         }

         if (this.kss[var3] && !this.kta(var3)) {
            return false;
         }
      }

      return false;
   }

   boolean rawCritAt(int var1) {
      return var1 >= 0 && var1 < 20 && this.kss[var1];
   }

   double fallAt(int var1) {
      return var1 >= 0 && var1 < 20 ? this.ksu[var1] : 0.0;
   }

   boolean smashAt(int var1) {
      return var1 >= 0 && var1 < 20 && !this.kst[var1] && this.ksu[var1] > 1.52;
   }

   Vec3d offsetAt(int var1) {
      int var2 = Math.max(0, Math.min(19, var1));
      return new Vec3d(this.ksv[var2], this.ksw[var2], this.ksx[var2]);
   }

   static double headroom(ClientPlayerEntity var0, World var1, double var2) {
      return Entity.adjustMovementForCollisions(var0, new Vec3d(0.0, var2, 0.0), var0.getBoundingBox(), var1, List.of()).y;
   }

   static float jumpVelocity(ClientPlayerEntity var0, World var1) {
      float var2 = var1.getBlockState(var0.getBlockPos()).getBlock().getJumpVelocityMultiplier();
      float var3 = var1.getBlockState(var0.getVelocityAffectingPos()).getBlock().getJumpVelocityMultiplier();
      float var4 = var2 == 1.0F ? var3 : var2;
      return (float)var0.getAttributeValue(EntityAttributes.JUMP_STRENGTH) * var4 + var0.getJumpBoostVelocityModifier();
   }
}
