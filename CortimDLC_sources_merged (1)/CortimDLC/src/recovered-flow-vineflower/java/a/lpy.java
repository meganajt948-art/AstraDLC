package a;

import java.util.List;
import java.util.function.ToIntFunction;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class lpy {
   static final float lpz = 0.9F;
   final lmn lqa = new lmn();
   final lqk lqb = new lqk();
   final lme lqc = new lme();
   LivingEntity lqd;

   public lmn path() {
      return this.lqa;
   }

   public void forget() {
      this.lqd = null;
   }

   public lpp plan(ClientPlayerEntity var1, World var2, double var3, List<LivingEntity> var5, ToIntFunction<LivingEntity> var6, lpc var7) {
      this.lqa.threshold(var7.minFall(), var7.maxFall());
      this.lqa.predict(var1, var2, var3);
      if (!this.lqa.smash(this.lqg())) {
         this.lqd = null;
         return null;
      }

      if (this.lqd != null && var5.contains(this.lqd)) {
         lpp var8 = this.lqh(var1, var2, this.lqd, var6.applyAsInt(this.lqd), var7);
         if (var8 != null) {
            return var8;
         }
      }

      lpp var16 = null;
      double var9 = Double.MAX_VALUE;

      for (LivingEntity var12 : var5) {
         if (var12 != this.lqd) {
            lpp var13 = this.lqh(var1, var2, var12, var6.applyAsInt(var12), var7);
            if (var13 != null) {
               double var14 = this.lqb.box(var13.tick()).squaredMagnitude(var13.eye());
               if (var16 == null || var13.tick() < var16.tick() || var13.tick() == var16.tick() && var14 < var9) {
                  var16 = var13;
                  var9 = var14;
               }
            }
         }
      }

      if (var16 != null && var16.target() != this.lqd) {
         this.lqd = var16.target();
         this.lqc.roll(var7.spread());
         var16 = this.lqh(var1, var2, this.lqd, var6.applyAsInt(this.lqd), var7);
      }

      if (var16 == null) {
         this.lqd = null;
      }

      return var16;
   }

   public Vec3d aimNow(World var1, ClientPlayerEntity var2, LivingEntity var3, double var4) {
      return this.lqc.resolve(var1, var2, var2.getEyePos(), var3.getBoundingBox(), var4);
   }

   public void hit() {
      this.lqd = null;
   }

   int lqg() {
      for (int var1 = 0; var1 < 40; var1++) {
         if (this.lqa.smash(var1)) {
            return var1;
         }
      }

      return -1;
   }

   lpp lqh(ClientPlayerEntity var1, World var2, LivingEntity var3, int var4, lpc var5) {
      this.lqb.predict(var3, var2);
      lpp var6 = null;
      lpp var7 = null;

      for (int var8 = Math.max(0, var4); var8 < 40; var8++) {
         if (this.lqa.smash(var8)) {
            boolean var9 = this.lqa.safe(var8);
            if (var9 || var5.lateSmash() && var7 == null) {
               Vec3d var10 = this.lqa.eye(var8);
               Box var11 = this.lqb.box(var8);
               Vec3d var12 = this.lqc.resolve(var2, var1, var10, var11, var5.reach());
               if (var12 != null && lqi(var5, var10, var12, var8)) {
                  if (!var9) {
                     var7 = new lpp(var3, var8, false, var10, var12, var11);
                  } else {
                     boolean var13 = var5.crits() && lqj(var1, var8) && (var8 >= 1 || !var5.serverSprinting());
                     lpp var14 = new lpp(var3, var8, var13, var10, var12, var11);
                     if (var13 || !var5.crits()) {
                        return var14;
                     }

                     if (var6 == null) {
                        var6 = var14;
                     }
                  }
               }
            }
         }
      }

      return var6 != null ? var6 : var7;
   }

   static boolean lqi(lpc var0, Vec3d var1, Vec3d var2, int var3) {
      double var4 = MathHelper.wrapDegrees(lme.yaw(var1, var2) - var0.lookYaw());
      double var6 = lme.pitch(var1, var2) - var0.lookPitch();
      return Math.sqrt(var4 * var4 + var6 * var6) <= var0.maxTurn() * (var3 + 1) + 0.5;
   }

   static boolean lqj(ClientPlayerEntity var0, int var1) {
      return var0.getAttackCooldownProgress(0.5F + var1) > 0.9F;
   }
}
