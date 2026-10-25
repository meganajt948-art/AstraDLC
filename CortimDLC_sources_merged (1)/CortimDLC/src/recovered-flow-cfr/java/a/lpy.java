/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.lme;
import a.lmn;
import a.lpc;
import a.lpp;
import a.lqk;
import java.util.List;
import java.util.function.ToIntFunction;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class lpy {
    private static final float lpz = 0.9f;
    private final lmn lqa = new lmn();
    private final lqk lqb = new lqk();
    private final lme lqc = new lme();
    private LivingEntity lqd;
    private static /* synthetic */ int lqe;
    private static /* synthetic */ int lqf;

    public lmn path() {
        return this.lqa;
    }

    public void forget() {
        this.lqd = null;
    }

    public lpp plan(ClientPlayerEntity clientPlayerEntity, World world, double d, List<LivingEntity> list, ToIntFunction<LivingEntity> toIntFunction, lpc lpc2) {
        lpp lpp2;
        this.lqa.threshold(lpc2.minFall(), lpc2.maxFall());
        this.lqa.predict(clientPlayerEntity, world, d);
        if (!this.lqa.smash(this.lqg())) {
            this.lqd = null;
            return null;
        }
        if (this.lqd != null && list.contains(this.lqd) && (lpp2 = this.lqh(clientPlayerEntity, world, this.lqd, toIntFunction.applyAsInt(this.lqd), lpc2)) != null) {
            return lpp2;
        }
        lpp2 = null;
        double d2 = Double.MAX_VALUE;
        for (LivingEntity livingEntity : list) {
            lpp lpp3;
            if (livingEntity == this.lqd || (lpp3 = this.lqh(clientPlayerEntity, world, livingEntity, toIntFunction.applyAsInt(livingEntity), lpc2)) == null) continue;
            double d3 = this.lqb.box(lpp3.tick()).squaredMagnitude(lpp3.eye());
            if (lpp2 != null && lpp3.tick() >= lpp2.tick() && (lpp3.tick() != lpp2.tick() || !(d3 < d2))) continue;
            lpp2 = lpp3;
            d2 = d3;
        }
        if (lpp2 != null && lpp2.target() != this.lqd) {
            this.lqd = lpp2.target();
            this.lqc.roll(lpc2.spread());
            lpp2 = this.lqh(clientPlayerEntity, world, this.lqd, toIntFunction.applyAsInt(this.lqd), lpc2);
        }
        if (lpp2 == null) {
            this.lqd = null;
        }
        return lpp2;
    }

    public Vec3d aimNow(World world, ClientPlayerEntity clientPlayerEntity, LivingEntity livingEntity, double d) {
        return this.lqc.resolve(world, (Entity)clientPlayerEntity, clientPlayerEntity.getEyePos(), livingEntity.getBoundingBox(), d);
    }

    public void hit() {
        this.lqd = null;
    }

    private int lqg() {
        for (int i = 0; i < 40; ++i) {
            if (!this.lqa.smash(i)) continue;
            return i;
        }
        return -1;
    }

    private lpp lqh(ClientPlayerEntity clientPlayerEntity, World world, LivingEntity livingEntity, int n, lpc lpc2) {
        this.lqb.predict((Entity)livingEntity, world);
        lpp lpp2 = null;
        lpp lpp3 = null;
        for (int i = Math.max(0, n); i < 40; ++i) {
            Box box;
            Vec3d vec3d;
            Vec3d vec3d2;
            boolean bl;
            if (!this.lqa.smash(i) || !(bl = this.lqa.safe(i)) && (!lpc2.lateSmash() || lpp3 != null) || (vec3d2 = this.lqc.resolve(world, (Entity)clientPlayerEntity, vec3d = this.lqa.eye(i), box = this.lqb.box(i), lpc2.reach())) == null || !lpy.lqi(lpc2, vec3d, vec3d2, i)) continue;
            if (!bl) {
                lpp3 = new lpp(livingEntity, i, false, vec3d, vec3d2, box);
                continue;
            }
            boolean bl2 = lpc2.crits() && lpy.lqj(clientPlayerEntity, i) && (i >= 1 || !lpc2.serverSprinting());
            lpp lpp4 = new lpp(livingEntity, i, bl2, vec3d, vec3d2, box);
            if (bl2 || !lpc2.crits()) {
                return lpp4;
            }
            if (lpp2 != null) continue;
            lpp2 = lpp4;
        }
        return lpp2 != null ? lpp2 : lpp3;
    }

    private static boolean lqi(lpc lpc2, Vec3d vec3d, Vec3d vec3d2, int n) {
        double d;
        double d2 = MathHelper.wrapDegrees((float)(lme.yaw(vec3d, vec3d2) - lpc2.lookYaw()));
        return Math.sqrt(d2 * d2 + (d = (double)(lme.pitch(vec3d, vec3d2) - lpc2.lookPitch())) * d) <= lpc2.maxTurn() * (double)(n + 1) + 0.5;
    }

    private static boolean lqj(ClientPlayerEntity clientPlayerEntity, int n) {
        return clientPlayerEntity.getAttackCooldownProgress(0.5f + (float)n) > 0.9f;
    }

    private static /* synthetic */ int ayh(int n, int n2) {
        return n ^ n2 | 0x7528EDA;
    }

    private static /* synthetic */ int ayi(int n, int n2) {
        return n + n2 + -1740593591;
    }

    private static /* synthetic */ int ayj(int n, int n2) {
        return n + n2 ^ 0x40DFB862;
    }
}

