/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package flow.cosmetic;

import flow.cosmetic.CosmeticItem;
import flow.cosmetic.CosmeticMesh;
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
    final Map<CosmeticItem.Emitter, float[]> emit = new IdentityHashMap<CosmeticItem.Emitter, float[]>();
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
    private float nextHappy = 7.0f;
    private float happyLeft;
    private float lastStepV;
    private float nextTwitch = 2.0f;
    private float nextBlink = 3.0f;
    private float blinkLeft;
    Vec3d petPos;
    Vec3d petVel = Vec3d.ZERO;
    Vec3d petLast;
    float petYaw;
    float petLastYaw;
    World petWorld;
    float petSky = -1.0f;
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
    private static final float LAG_STEP = 0.016666668f;
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
        float w = (float)(Math.PI * 2 * (double)hz);
        int steps = Math.max(1, (int)Math.ceil(dt / 0.008f));
        float h = dt / (float)steps;
        for (int k = 0; k < steps; ++k) {
            float a2 = w * w * (target - s[0]) - 2.0f * zeta * w * s[1];
            s[1] = s[1] + a2 * h;
            s[0] = s[0] + s[1] * h;
        }
    }

    private static float approach(float v, float target, float rate, float dt) {
        return v + (target - v) * (1.0f - (float)Math.exp(-rate * dt));
    }

    private static float clamp(float v, float lo, float hi) {
        return Math.max(lo, Math.min(hi, v));
    }

    private static float smooth(float e0, float e1, float x) {
        float t = Motion.clamp((x - e0) / (e1 - e0), 0.0f, 1.0f);
        return t * t * (3.0f - 2.0f * t);
    }

    void update(PlayerEntity p, float td, float dt, boolean local) {
        ThreadLocalRandom r;
        Vec3d pos = p.getLerpedPos(td);
        float yaw = MathHelper.lerpAngleDegrees((float)td, (float)p.lastBodyYaw, (float)p.bodyYaw);
        this.headYaw = MathHelper.lerpAngleDegrees((float)td, (float)p.lastHeadYaw, (float)p.headYaw);
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
            return;
        }
        if (dt < 1.0E-4f) {
            return;
        }
        float vx = Motion.clamp((float)(pos.x - this.lx) / dt, -40.0f, 40.0f);
        float vy = Motion.clamp((float)(pos.y - this.ly) / dt, -80.0f, 40.0f);
        float vz = Motion.clamp((float)(pos.z - this.lz) / dt, -40.0f, 40.0f);
        float a2 = (float)Math.toRadians(180.0f - yaw);
        float c = (float)Math.cos(a2);
        float s = (float)Math.sin(a2);
        float bx = vx * c - vz * s;
        float bz = vx * s + vz * c;
        float omega = (float)Math.toRadians(MathHelper.wrapDegrees((float)(yaw - this.lyaw))) / dt;
        omega = Motion.clamp(omega, -14.0f, 14.0f);
        this.speed = (float)Math.sqrt(vx * vx + vz * vz);
        Motion.spring(this.sx, Motion.clamp(-bx * 0.9f + omega * 0.4f, -14.0f, 14.0f), 1.6f, 0.42f, dt);
        Motion.spring(this.sy, Motion.clamp(-vy * 0.55f, -10.0f, 14.0f), 1.7f, 0.4f, dt);
        Motion.spring(this.sz, Motion.clamp(-bz * 0.9f, -14.0f, 14.0f), 1.6f, 0.42f, dt);
        this.bodyAcc = Math.min(this.bodyAcc + dt, 0.8000001f);
        while (this.bodyAcc >= 0.016666668f) {
            this.bodyAcc -= 0.016666668f;
            this.bodyHead = Motion.push(this.bodyLag, this.bodyHead, this.sx[0], this.sy[0], this.sz[0]);
        }
        float f = this.air = onGround ? 0.0f : this.air + dt;
        boolean fly = p.isGliding() || (local ? p.getAbilities().flying && !onGround : !onGround && this.air > 0.7f && Math.abs(vy) < 0.8f && !p.isTouchingWater());
        this.walkW = Motion.approach(this.walkW, fly ? 0.0f : Motion.smooth(0.35f, 2.4f, this.speed), 7.0f, dt);
        this.flyW = Motion.approach(this.flyW, fly ? 1.0f : 0.0f, 4.0f, dt);
        this.sneakW = Motion.approach(this.sneakW, p.isInSneakingPose() ? 1.0f : 0.0f, 9.0f, dt);
        this.tIdle += dt;
        this.tWalk += dt * (0.75f + 0.35f * Motion.clamp(this.speed / 4.3f, 0.0f, 2.0f));
        this.tFly += dt * (1.0f + 0.15f * Motion.clamp(this.speed / 10.0f, 0.0f, 2.0f));
        float phase = p.limbAnimator.getAnimationProgress(td) * 0.6662f;
        if (!this.ground && onGround && this.lastVy < -5.0f) {
            this.bob[1] = this.bob[1] + this.lastVy * 0.35f;
        }
        Motion.spring(this.bob, -0.4f * this.walkW * (1.0f - this.flyW) * Math.abs((float)Math.sin(phase)), 5.5f, 0.35f, dt);
        this.airW = Motion.approach(this.airW, !onGround && !fly && !p.isTouchingWater() && this.air > 0.12f ? 1.0f : 0.0f, 7.0f, dt);
        this.nextHappy -= dt;
        this.happyLeft = Math.max(0.0f, this.happyLeft - dt);
        if (this.nextHappy <= 0.0f) {
            this.happyLeft = this.walkW < 0.3f ? 1.5f : 0.0f;
            this.nextHappy = 9.0f + ThreadLocalRandom.current().nextFloat() * 10.0f;
        }
        float step = -1.7f * this.walkW * (1.0f - this.flyW) * Math.abs((float)Math.sin(phase)) * (p.isSprinting() ? 1.35f : 1.0f);
        float stepV = (step - this.lastStep) / dt;
        this.jig[1] = Motion.clamp(this.jig[1] - (stepV - this.lastStepV) * 0.9f - (vy - this.lastVy) * 3.0f, -50.0f, 50.0f);
        this.lastStep = step;
        this.lastStepV = stepV;
        Motion.spring(this.jig, 0.0f, 2.8f, 0.12f, dt);
        this.nextTwitch -= dt;
        if (this.nextTwitch <= 0.0f) {
            r = ThreadLocalRandom.current();
            this.twitch[1] = this.twitch[1] + 520.0f;
            this.nextTwitch = r.nextFloat() < 0.3f ? 0.18f : 2.5f + r.nextFloat() * 5.5f;
        }
        Motion.spring(this.twitch, 0.0f, 7.0f, 0.28f, dt);
        this.blinkLeft = Math.max(0.0f, this.blinkLeft - dt);
        this.nextBlink -= dt;
        if (this.nextBlink <= 0.0f) {
            r = ThreadLocalRandom.current();
            this.blinkLeft = 0.13f;
            this.nextBlink = r.nextFloat() < 0.2f ? 0.3f : 2.2f + r.nextFloat() * 3.8f;
        }
        this.lx = pos.x;
        this.ly = pos.y;
        this.lz = pos.z;
        this.lyaw = yaw;
        this.lastVy = vy;
        this.ground = onGround;
    }

    void body(CosmeticMesh.Drive d) {
        this.weights(d);
        d.dx = this.sx[0];
        d.dy = this.sy[0];
        d.dz = this.sz[0];
        d.lift = Motion.clamp(this.sy[0] * 2.6f - this.sneakW * 9.0f, -16.0f, 24.0f);
        d.sweep = Motion.clamp(this.sz[0] * 3.4f + this.sneakW * 7.0f, -10.0f, 30.0f);
        d.turn = Motion.clamp(this.sx[0] * 2.5f, -18.0f, 18.0f);
        d.bob = this.bob[0];
        d.tilt = Motion.clamp(this.sz[0] * 1.4f, -8.0f, 12.0f);
        d.twitch = Motion.clamp(this.twitch[0], -25.0f, 25.0f);
        d.blink = this.blinkLeft > 0.0f;
        d.jiggle = Motion.clamp(this.jig[0], -2.2f, 2.2f);
        d.wSneak = this.sneakW;
        d.wAir = this.airW;
        d.air = this.airW > 0.5f;
        d.happy = this.happyLeft > 0.0f;
        d.hurt = false;
        d.wAttack = 0.0f;
        d.sway = Motion.clamp(this.sx[0] * 0.5f, -6.0f, 6.0f);
        d.roll = 0.0f;
        d.pitch = 0.0f;
        d.lookYaw = 0.0f;
        d.lookPitch = 0.0f;
        d.cape = null;
        d.lag = this.bodyLag;
        d.lagHead = this.bodyHead;
    }

    void petStep(float dt) {
        if (this.petLast == null || dt < 1.0E-4f) {
            this.petLast = this.petPos;
            this.petLastYaw = this.petYaw;
            return;
        }
        float vx = Motion.clamp((float)(this.petPos.x - this.petLast.x) / dt, -30.0f, 30.0f);
        float vy = Motion.clamp((float)(this.petPos.y - this.petLast.y) / dt, -30.0f, 30.0f);
        float vz = Motion.clamp((float)(this.petPos.z - this.petLast.z) / dt, -30.0f, 30.0f);
        float a2 = (float)Math.toRadians(180.0f - this.petYaw);
        float c = (float)Math.cos(a2);
        float s = (float)Math.sin(a2);
        float omega = Motion.clamp((float)Math.toRadians(MathHelper.wrapDegrees((float)(this.petYaw - this.petLastYaw))) / dt, -10.0f, 10.0f);
        Motion.spring(this.px, vx * c - vz * s, 1.8f, 0.5f, dt);
        Motion.spring(this.py, vy, 1.8f, 0.5f, dt);
        Motion.spring(this.pz, vx * s + vz * c, 1.8f, 0.5f, dt);
        Motion.spring(this.pturn, omega, 2.2f, 0.55f, dt);
        this.petAcc = Math.min(this.petAcc + dt, 0.8000001f);
        while (this.petAcc >= 0.016666668f) {
            this.petAcc -= 0.016666668f;
            this.petHead = Motion.push(this.petLag, this.petHead, Motion.clamp(-this.px[0] + this.pturn[0] * 0.5f, -12.0f, 12.0f), Motion.clamp(-this.py[0], -12.0f, 12.0f), Motion.clamp(-this.pz[0], -12.0f, 12.0f));
        }
        this.petLast = this.petPos;
        this.petLastYaw = this.petYaw;
    }

    void pet(CosmeticMesh.Drive d) {
        this.weights(d);
        d.dx = Motion.clamp(-this.px[0] + this.pturn[0] * 0.5f, -12.0f, 12.0f);
        d.dy = Motion.clamp(-this.py[0], -12.0f, 12.0f);
        d.dz = Motion.clamp(-this.pz[0], -12.0f, 12.0f);
        d.lift = 0.0f;
        d.sweep = 0.0f;
        d.turn = 0.0f;
        d.bob = 0.0f;
        d.tilt = 0.0f;
        d.roll = Motion.clamp(this.px[0] * 7.0f + this.pturn[0] * 4.0f, -24.0f, 24.0f);
        d.pitch = Motion.clamp(this.pz[0] * 5.0f + this.py[0] * 3.0f, -20.0f, 20.0f);
        d.lookYaw = Motion.clamp(MathHelper.wrapDegrees((float)(this.headYaw - this.petYaw)), -70.0f, 70.0f) * 0.85f;
        d.lookPitch = Motion.clamp(this.headPitch, -45.0f, 45.0f) * 0.6f;
        d.twitch = Motion.clamp(this.twitch[0], -25.0f, 25.0f);
        d.blink = this.blinkLeft > 0.0f;
        d.happy = this.happyLeft > 0.0f;
        d.hurt = false;
        d.air = false;
        d.wSneak = 0.0f;
        d.wAir = 0.0f;
        d.wAttack = 0.0f;
        d.jiggle = 0.0f;
        d.cape = null;
        d.lag = this.petLag;
        d.lagHead = this.petHead;
    }

    private void weights(CosmeticMesh.Drive d) {
        d.wIdle = (1.0f - this.walkW) * (1.0f - this.flyW);
        d.wWalk = this.walkW * (1.0f - this.flyW);
        d.wFly = this.flyW;
        d.tIdle = this.tIdle;
        d.tWalk = this.tWalk;
        d.tFly = this.tFly;
    }
}

