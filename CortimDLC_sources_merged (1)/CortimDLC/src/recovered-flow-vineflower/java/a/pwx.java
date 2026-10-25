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
      var1.box = var0.method_5829();
      Vec3d var2 = var0.method_18798();
      var1.vx = var2.field_1352;
      var1.vy = var2.field_1351;
      var1.vz = var2.field_1350;
      var1.onGround = var0.method_24828();
      var1.sprinting = var0.method_5624();
      var1.stepHeight = var0.method_49476();
      double var3 = var0.method_45325(EntityAttributes.field_23719);
      var1.movementSpeed = var0.method_5624() ? var3 / 1.3 : var3;
      double var5 = var0.method_45325(EntityAttributes.field_23728);
      StatusEffectInstance var7 = var0.method_6112(StatusEffects.field_5913);
      if (var7 != null) {
         var5 += 0.1 * (var7.method_5578() + 1.0);
      }

      var1.jumpVelocity = var5;
      var1.gravity = var0.method_56989();
      return var1;
   }
}
