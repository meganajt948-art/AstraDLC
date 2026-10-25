package a;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class lpp {
   final LivingEntity lpq;
   final int lpr;
   final boolean lps;
   final Vec3d lpt;
   final Vec3d lpu;
   final Box lpv;

   public lpp(LivingEntity target, int tick, boolean crit, Vec3d eye, Vec3d aim, Box box) {
      this.lpq = target;
      this.lpr = tick;
      this.lps = crit;
      this.lpt = eye;
      this.lpu = aim;
      this.lpv = box;
   }

   public float yaw() {
      return lme.yaw(this.lpt, this.lpu);
   }

   public float pitch() {
      return lme.pitch(this.lpt, this.lpu);
   }

   public LivingEntity target() {
      return this.lpq;
   }

   public int tick() {
      return this.lpr;
   }

   public boolean crit() {
      return this.lps;
   }

   public Vec3d eye() {
      return this.lpt;
   }

   public Vec3d aim() {
      return this.lpu;
   }

   public Box box() {
      return this.lpv;
   }
}
