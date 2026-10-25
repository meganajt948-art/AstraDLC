package flow.cosmetic;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

final class Motion {
   final int id;
   long seen;
   Map<String, CosmeticItem> worn = Map.of();
   final Map<CosmeticItem.Emitter, float[]> emit = new IdentityHashMap<>();
   private boolean ready;
   private double lx;
   private double ly;
   private double lz;
   private float lyaw;
   private boolean ground = true;
   private float lastVy;
   private float air;
   float walkW;
   float flyW;
   float sneakW;
   float tIdle;
   float tWalk;
   float tFly;
   float headYaw;
   float headPitch;
   float bodyYaw;
   float speed;
   private final float[] sx = new float[2];
   private final float[] sy = new float[2];
   private final float[] sz = new float[2];
   private final float[] bob = new float[2];
   private final float[] twitch = new float[2];
   private final float[] jig = new float[2];
   private float lastStep;
   private float airW;
   private float nextHappy = 7.0F;
   private float happyLeft;
   private float lastStepV;
   private float nextTwitch = 2.0F;
   private float nextBlink = 3.0F;
   private float blinkLeft;
   Vec3d petPos;
   Vec3d petVel = Vec3d.ZERO;
   Vec3d petLast;
   float petYaw;
   float petLastYaw;
   World petWorld;
   float petSky = -1.0F;
   float petBlock;
   boolean petHidden;
   boolean petRun;
   float petWalk;
   float petWalkT;
   private final float[] px = new float[2];
   private final float[] py = new float[2];
   private final float[] pz = new float[2];
   private final float[] pturn = new float[2];
   private static final int LAG = 48;
   private static final float LAG_STEP = 0.016666668F;
   private final float[] bodyLag = new float[144];
   private final float[] petLag = new float[144];
   private int bodyHead;
   private int petHead;
   private float bodyAcc;
   private float petAcc;

   Motion(int id) {
      this.id = id;
   }

   private static int push(float[] buf, int head, float x, float y, float z) {
      int h = (head + 1) % 48;
      buf[h * 3] = x;
      buf[h * 3 + 1] = y;
      buf[h * 3 + 2] = z;
      return h;
   }

   static void spring(float[] s, float target, float hz, float zeta, float dt) {
      float w = (float)((Math.PI * 2) * hz);
      int steps = Math.max(1, (int)Math.ceil(dt / 0.008F));
      float h = dt / steps;

      for (int k = 0; k < steps; k++) {
         float a = w * w * (target - s[0]) - 2.0F * zeta * w * s[1];
         s[1] += a * h;
         s[0] += s[1] * h;
      }
   }

   private static float approach(float v, float target, float rate, float dt) {
      return v + (target - v) * (1.0F - (float)Math.exp(-rate * dt));
   }

   private static float clamp(float v, float lo, float hi) {
      return Math.max(lo, Math.min(hi, v));
   }

   private static float smooth(float e0, float e1, float x) {
      float t = clamp((x - e0) / (e1 - e0), 0.0F, 1.0F);
      return t * t * (3.0F - 2.0F * t);
   }

   void update(PlayerEntity p, float td, float dt, boolean local) {
      Vec3d pos = p.getLerpedPos(td);
      float yaw = MathHelper.lerpAngleDegrees(td, p.lastBodyYaw, p.bodyYaw);
      this.headYaw = MathHelper.lerpAngleDegrees(td, p.lastHeadYaw, p.headYaw);
      this.headPitch = p.getPitch(td);
      this.bodyYaw = yaw;
      boolean onGround = p.isOnGround();
      if (!this.ready || pos.squaredDistanceTo(this.lx, this.ly, this.lz) > 64.0) {
         this.ready = true;
         this.lx = pos.x;
         this.ly = pos.y;
         this.lz = pos.z;
         this.lyaw = yaw;
         this.ground = onGround;
      } else if (!(dt < 1.0E-4F)) {
         float vx = clamp((float)(pos.x - this.lx) / dt, -40.0F, 40.0F);
         float vy = clamp((float)(pos.y - this.ly) / dt, -80.0F, 40.0F);
         float vz = clamp((float)(pos.z - this.lz) / dt, -40.0F, 40.0F);
         float a = (float)Math.toRadians(180.0F - yaw);
         float c = (float)Math.cos(a);
         float s = (float)Math.sin(a);
         float bx = vx * c - vz * s;
         float bz = vx * s + vz * c;
         float omega = (float)Math.toRadians(MathHelper.wrapDegrees(yaw - this.lyaw)) / dt;
         omega = clamp(omega, -14.0F, 14.0F);
         this.speed = (float)Math.sqrt(vx * vx + vz * vz);
         spring(this.sx, clamp(-bx * 0.9F + omega * 0.4F, -14.0F, 14.0F), 1.6F, 0.42F, dt);
         spring(this.sy, clamp(-vy * 0.55F, -10.0F, 14.0F), 1.7F, 0.4F, dt);
         spring(this.sz, clamp(-bz * 0.9F, -14.0F, 14.0F), 1.6F, 0.42F, dt);

         for (this.bodyAcc = Math.min(this.bodyAcc + dt, 0.8000001F);
            this.bodyAcc >= 0.016666668F;
            this.bodyHead = push(this.bodyLag, this.bodyHead, this.sx[0], this.sy[0], this.sz[0])
         ) {
            this.bodyAcc -= 0.016666668F;
         }

         this.air = onGround ? 0.0F : this.air + dt;
         boolean fly = p.isGliding()
            || (local ? p.getAbilities().flying && !onGround : !onGround && this.air > 0.7F && Math.abs(vy) < 0.8F && !p.isTouchingWater());
         this.walkW = approach(this.walkW, fly ? 0.0F : smooth(0.35F, 2.4F, this.speed), 7.0F, dt);
         this.flyW = approach(this.flyW, fly ? 1.0F : 0.0F, 4.0F, dt);
         this.sneakW = approach(this.sneakW, p.isInSneakingPose() ? 1.0F : 0.0F, 9.0F, dt);
         this.tIdle += dt;
         this.tWalk = this.tWalk + dt * (0.75F + 0.35F * clamp(this.speed / 4.3F, 0.0F, 2.0F));
         this.tFly = this.tFly + dt * (1.0F + 0.15F * clamp(this.speed / 10.0F, 0.0F, 2.0F));
         float phase = p.limbAnimator.getAnimationProgress(td) * 0.6662F;
         if (!this.ground && onGround && this.lastVy < -5.0F) {
            this.bob[1] = this.bob[1] + this.lastVy * 0.35F;
         }

         spring(this.bob, -0.4F * this.walkW * (1.0F - this.flyW) * Math.abs((float)Math.sin(phase)), 5.5F, 0.35F, dt);
         this.airW = approach(this.airW, !onGround && !fly && !p.isTouchingWater() && this.air > 0.12F ? 1.0F : 0.0F, 7.0F, dt);
         this.nextHappy -= dt;
         this.happyLeft = Math.max(0.0F, this.happyLeft - dt);
         if (this.nextHappy <= 0.0F) {
            this.happyLeft = this.walkW < 0.3F ? 1.5F : 0.0F;
            this.nextHappy = 9.0F + ThreadLocalRandom.current().nextFloat() * 10.0F;
         }

         float step = -1.7F * this.walkW * (1.0F - this.flyW) * Math.abs((float)Math.sin(phase)) * (p.isSprinting() ? 1.35F : 1.0F);
         float stepV = (step - this.lastStep) / dt;
         this.jig[1] = clamp(this.jig[1] - (stepV - this.lastStepV) * 0.9F - (vy - this.lastVy) * 3.0F, -50.0F, 50.0F);
         this.lastStep = step;
         this.lastStepV = stepV;
         spring(this.jig, 0.0F, 2.8F, 0.12F, dt);
         this.nextTwitch -= dt;
         if (this.nextTwitch <= 0.0F) {
            ThreadLocalRandom r = ThreadLocalRandom.current();
            this.twitch[1] = this.twitch[1] + 520.0F;
            this.nextTwitch = r.nextFloat() < 0.3F ? 0.18F : 2.5F + r.nextFloat() * 5.5F;
         }

         spring(this.twitch, 0.0F, 7.0F, 0.28F, dt);
         this.blinkLeft = Math.max(0.0F, this.blinkLeft - dt);
         this.nextBlink -= dt;
         if (this.nextBlink <= 0.0F) {
            ThreadLocalRandom r = ThreadLocalRandom.current();
            this.blinkLeft = 0.13F;
            this.nextBlink = r.nextFloat() < 0.2F ? 0.3F : 2.2F + r.nextFloat() * 3.8F;
         }

         this.lx = pos.x;
         this.ly = pos.y;
         this.lz = pos.z;
         this.lyaw = yaw;
         this.lastVy = vy;
         this.ground = onGround;
      }
   }

   void body(CosmeticMesh.Drive d) {
      this.weights(d);
      d.dx = this.sx[0];
      d.dy = this.sy[0];
      d.dz = this.sz[0];
      d.lift = clamp(this.sy[0] * 2.6F - this.sneakW * 9.0F, -16.0F, 24.0F);
      d.sweep = clamp(this.sz[0] * 3.4F + this.sneakW * 7.0F, -10.0F, 30.0F);
      d.turn = clamp(this.sx[0] * 2.5F, -18.0F, 18.0F);
      d.bob = this.bob[0];
      d.tilt = clamp(this.sz[0] * 1.4F, -8.0F, 12.0F);
      d.twitch = clamp(this.twitch[0], -25.0F, 25.0F);
      d.blink = this.blinkLeft > 0.0F;
      d.jiggle = clamp(this.jig[0], -2.2F, 2.2F);
      d.wSneak = this.sneakW;
      d.wAir = this.airW;
      d.air = this.airW > 0.5F;
      d.happy = this.happyLeft > 0.0F;
      d.hurt = false;
      d.wAttack = 0.0F;
      d.sway = clamp(this.sx[0] * 0.5F, -6.0F, 6.0F);
      d.roll = 0.0F;
      d.pitch = 0.0F;
      d.lookYaw = 0.0F;
      d.lookPitch = 0.0F;
      d.cape = null;
      d.lag = this.bodyLag;
      d.lagHead = this.bodyHead;
   }

   void petStep(float dt) {
      if (this.petLast != null && !(dt < 1.0E-4F)) {
         float vx = clamp((float)(this.petPos.x - this.petLast.x) / dt, -30.0F, 30.0F);
         float vy = clamp((float)(this.petPos.y - this.petLast.y) / dt, -30.0F, 30.0F);
         float vz = clamp((float)(this.petPos.z - this.petLast.z) / dt, -30.0F, 30.0F);
         float a = (float)Math.toRadians(180.0F - this.petYaw);
         float c = (float)Math.cos(a);
         float s = (float)Math.sin(a);
         float omega = clamp((float)Math.toRadians(MathHelper.wrapDegrees(this.petYaw - this.petLastYaw)) / dt, -10.0F, 10.0F);
         spring(this.px, vx * c - vz * s, 1.8F, 0.5F, dt);
         spring(this.py, vy, 1.8F, 0.5F, dt);
         spring(this.pz, vx * s + vz * c, 1.8F, 0.5F, dt);
         spring(this.pturn, omega, 2.2F, 0.55F, dt);

         for (this.petAcc = Math.min(this.petAcc + dt, 0.8000001F);
            this.petAcc >= 0.016666668F;
            this.petHead = push(
               this.petLag,
               this.petHead,
               clamp(-this.px[0] + this.pturn[0] * 0.5F, -12.0F, 12.0F),
               clamp(-this.py[0], -12.0F, 12.0F),
               clamp(-this.pz[0], -12.0F, 12.0F)
            )
         ) {
            this.petAcc -= 0.016666668F;
         }

         this.petLast = this.petPos;
         this.petLastYaw = this.petYaw;
      } else {
         this.petLast = this.petPos;
         this.petLastYaw = this.petYaw;
      }
   }

   void pet(CosmeticMesh.Drive d) {
      this.weights(d);
      d.dx = clamp(-this.px[0] + this.pturn[0] * 0.5F, -12.0F, 12.0F);
      d.dy = clamp(-this.py[0], -12.0F, 12.0F);
      d.dz = clamp(-this.pz[0], -12.0F, 12.0F);
      d.lift = 0.0F;
      d.sweep = 0.0F;
      d.turn = 0.0F;
      d.bob = 0.0F;
      d.tilt = 0.0F;
      d.roll = clamp(this.px[0] * 7.0F + this.pturn[0] * 4.0F, -24.0F, 24.0F);
      d.pitch = clamp(this.pz[0] * 5.0F + this.py[0] * 3.0F, -20.0F, 20.0F);
      d.lookYaw = clamp(MathHelper.wrapDegrees(this.headYaw - this.petYaw), -70.0F, 70.0F) * 0.85F;
      d.lookPitch = clamp(this.headPitch, -45.0F, 45.0F) * 0.6F;
      d.twitch = clamp(this.twitch[0], -25.0F, 25.0F);
      d.blink = this.blinkLeft > 0.0F;
      d.happy = this.happyLeft > 0.0F;
      d.hurt = false;
      d.air = false;
      d.wSneak = 0.0F;
      d.wAir = 0.0F;
      d.wAttack = 0.0F;
      d.jiggle = 0.0F;
      d.cape = null;
      d.lag = this.petLag;
      d.lagHead = this.petHead;
   }

   private void weights(CosmeticMesh.Drive d) {
      d.wIdle = (1.0F - this.walkW) * (1.0F - this.flyW);
      d.wWalk = this.walkW * (1.0F - this.flyW);
      d.wFly = this.flyW;
      d.tIdle = this.tIdle;
      d.tWalk = this.tWalk;
      d.tFly = this.tFly;
   }
}
