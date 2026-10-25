/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class lmn {
    public static final int HORIZON = 40;
    public static final double SMASH_FALL = 1.52;
    private static final int lmo = 2;
    private static final int lmp = 43;
    private final double[] lmq = new double[43];
    private final double[] lmr = new double[43];
    private final double[] lms = new double[43];
    private final double[] lmt = new double[43];
    private final boolean[] lmu = new boolean[43];
    private int lmv = 43;
    private double lmw = 1.52;
    private double lmx = Double.MAX_VALUE;
    private static /* synthetic */ boolean lmy;
    private static /* synthetic */ boolean lmz;

    public void threshold(double d) {
        this.threshold(d, Double.MAX_VALUE);
    }

    public void threshold(double d, double d2) {
        this.lmw = Math.max(1.52, d);
        this.lmx = Math.max(this.lmw + 0.25, d2);
    }

    public double threshold() {
        return this.lmw;
    }

    public void predict(ClientPlayerEntity clientPlayerEntity, World world, double d) {
        double d2;
        Box box = clientPlayerEntity.getBoundingBox();
        boolean bl = clientPlayerEntity.isOnGround();
        double d3 = d;
        Vec3d vec3d = clientPlayerEntity.getVelocity();
        double d4 = vec3d.x;
        double d5 = vec3d.y;
        double d6 = vec3d.z;
        double d7 = clientPlayerEntity.getEyeY() - clientPlayerEntity.getY();
        double d8 = clientPlayerEntity.getFinalGravity();
        double d9 = 0.0;
        double d10 = 0.0;
        double d11 = clientPlayerEntity.sidewaysSpeed;
        double d12 = clientPlayerEntity.forwardSpeed;
        double d13 = d11 * d11 + d12 * d12;
        if (d13 > 1.0E-7) {
            if (d13 > 1.0) {
                d2 = Math.sqrt(d13);
                d11 /= d2;
                d12 /= d2;
            }
            d2 = clientPlayerEntity.isSprinting() ? 0.026 : 0.02;
            float f = clientPlayerEntity.getYaw() * ((float)Math.PI / 180);
            double d14 = MathHelper.sin((double)f);
            double d15 = MathHelper.cos((double)f);
            d9 = (d11 * d15 - d12 * d14) * d2;
            d10 = (d12 * d15 + d11 * d14) * d2;
        }
        d2 = clientPlayerEntity.getX();
        double d16 = clientPlayerEntity.getY();
        double d17 = clientPlayerEntity.getZ();
        this.lmv = 43;
        for (int i = 0; i < 43; ++i) {
            this.lmq[i] = d2;
            this.lmr[i] = d16 + d7;
            this.lms[i] = d17;
            this.lmu[i] = bl;
            double d18 = this.lmt[i] = bl ? 0.0 : d3;
            if (bl) {
                if (this.lmv != 43) continue;
                this.lmv = i;
                continue;
            }
            if (Math.abs(d4) < 0.003) {
                d4 = 0.0;
            }
            if (Math.abs(d5) < 0.003) {
                d5 = 0.0;
            }
            if (Math.abs(d6) < 0.003) {
                d6 = 0.0;
            }
            Vec3d vec3d2 = Entity.adjustMovementForCollisions((Entity)clientPlayerEntity, (Vec3d)new Vec3d(d4 += d9, d5, d6 += d10), (Box)box, (World)world, List.of());
            boolean bl2 = vec3d2.y != d5;
            boolean bl3 = bl = bl2 && d5 < 0.0;
            if (vec3d2.x != d4) {
                d4 = 0.0;
            }
            if (vec3d2.z != d6) {
                d6 = 0.0;
            }
            if (vec3d2.y > 0.0) {
                d3 = 0.0;
            } else if (vec3d2.y < 0.0) {
                d3 -= vec3d2.y;
            }
            if (bl) {
                d3 = 0.0;
            }
            box = box.offset(vec3d2);
            d2 += vec3d2.x;
            d16 += vec3d2.y;
            d17 += vec3d2.z;
            if (bl2) {
                d5 = 0.0;
            }
            d5 = (d5 - d8) * 0.98;
            d4 *= 0.91;
            d6 *= 0.91;
        }
    }

    public boolean smash(int n) {
        return n >= 0 && n < 40 && !this.lmu[n] && this.lmt[n] > this.lmw && this.lmt[n] <= this.lmx;
    }

    public boolean safe(int n) {
        if (!this.smash(n)) {
            return false;
        }
        for (int i = 1; i <= 2; ++i) {
            if (!this.lmu[n + i]) continue;
            return false;
        }
        return true;
    }

    public Vec3d eye(int n) {
        int n2 = MathHelper.clamp((int)n, (int)0, (int)42);
        return new Vec3d(this.lmq[n2], this.lmr[n2], this.lms[n2]);
    }

    public double fall(int n) {
        return this.lmt[MathHelper.clamp((int)n, (int)0, (int)42)];
    }

    public int landing() {
        return this.lmv;
    }

    public Box sweep(ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = this.eye(39).subtract(this.eye(0));
        return clientPlayerEntity.getBoundingBox().stretch(vec3d);
    }

    public static boolean environment(ClientPlayerEntity clientPlayerEntity, World world) {
        return !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isInLava() && !clientPlayerEntity.hasVehicle() && !clientPlayerEntity.isGliding() && !clientPlayerEntity.getAbilities().flying && !clientPlayerEntity.inPowderSnow && !clientPlayerEntity.hasStatusEffect(StatusEffects.LEVITATION) && !clientPlayerEntity.hasStatusEffect(StatusEffects.SLOW_FALLING) && world.getStatesInBox(clientPlayerEntity.getBoundingBox().contract(1.0E-7)).noneMatch(lmn::lna);
    }

    private static boolean lna(BlockState blockState) {
        return blockState.isOf(Blocks.COBWEB) || blockState.isOf(Blocks.SWEET_BERRY_BUSH) || blockState.isOf(Blocks.POWDER_SNOW);
    }

    private static /* synthetic */ int axq(int n, int n2) {
        return n - n2 ^ 0xCF64C28D;
    }
}

