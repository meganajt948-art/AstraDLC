package a;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class pwx {
   public Box box;
   public double vx;
   public double vy;
   public double vz;
   public boolean onGround;
   public boolean sprinting;
   public float stepHeight = 0.6F;
   public double movementSpeed = 0.1;
   public double jumpVelocity = 0.42F;
   public double gravity = 0.08;

   public static pwx of(PlayerEntity var0) {
      pwx var1 = new pwx();
      var1.box = var0.getBoundingBox();
      Vec3d var2 = var0.getVelocity();
      var1.vx = var2.x;
      var1.vy = var2.y;
      var1.vz = var2.z;
      var1.onGround = var0.isOnGround();
      var1.sprinting = var0.isSprinting();
      var1.stepHeight = var0.getStepHeight();
      double var3 = var0.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
      var1.movementSpeed = var0.isSprinting() ? var3 / 1.3 : var3;
      double var5 = var0.getAttributeValue(EntityAttributes.JUMP_STRENGTH);
      StatusEffectInstance var7 = var0.getStatusEffect(StatusEffects.JUMP_BOOST);
      if (var7 != null) {
         var5 += 0.1 * (var7.getAmplifier() + 1.0);
      }

      var1.jumpVelocity = var5;
      var1.gravity = var0.getFinalGravity();
      return var1;
   }
}
