/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
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
    private static final int ksq = 2;
    private static final int ksr = 22;
    private final boolean[] kss = new boolean[22];
    private final boolean[] kst = new boolean[22];
    private final double[] ksu = new double[22];
    private final double[] ksv = new double[22];
    private final double[] ksw = new double[22];
    private final double[] ksx = new double[22];
    private static /* synthetic */ int ksy;
    private static /* synthetic */ long ksz;

    ksp() {
    }

    void predict(ClientPlayerEntity clientPlayerEntity, World world, boolean bl, int n, boolean bl2, double d) {
        Box box = clientPlayerEntity.getBoundingBox();
        boolean bl3 = clientPlayerEntity.isOnGround();
        double d2 = d;
        double d3 = clientPlayerEntity.getVelocity().y;
        double d4 = clientPlayerEntity.getX() - clientPlayerEntity.lastX;
        double d5 = clientPlayerEntity.getZ() - clientPlayerEntity.lastZ;
        if (bl3 && clientPlayerEntity.isSneaking()) {
            d4 = 0.0;
            d5 = 0.0;
        }
        double d6 = clientPlayerEntity.getFinalGravity();
        float f = ksp.jumpVelocity(clientPlayerEntity, world);
        int n2 = bl2 ? 0 : n;
        double d7 = 0.0;
        double d8 = 0.0;
        double d9 = 0.0;
        for (int i = 0; i < 22; ++i) {
            this.kss[i] = d2 > 0.0 && !bl3;
            this.kst[i] = bl3;
            this.ksu[i] = bl3 ? 0.0 : d2;
            this.ksv[i] = d7;
            this.ksw[i] = d8;
            this.ksx[i] = d9;
            if (n2 > 0) {
                --n2;
            }
            if (Math.abs(d3) < 0.003) {
                d3 = 0.0;
            }
            if (bl) {
                if (bl3 && n2 == 0 && f > 1.0E-5f) {
                    d3 = Math.max((double)f, d3);
                    n2 = bl2 ? 0 : 10;
                }
            } else {
                n2 = 0;
            }
            Vec3d vec3d = Entity.adjustMovementForCollisions((Entity)clientPlayerEntity, (Vec3d)new Vec3d(d4, d3, d5), (Box)box, (World)world, List.of());
            boolean bl4 = vec3d.y != d3;
            boolean bl5 = bl3 = bl4 && d3 < 0.0;
            if (vec3d.x != d4) {
                d4 = 0.0;
            }
            if (vec3d.z != d5) {
                d5 = 0.0;
            }
            if (vec3d.y > 0.0) {
                d2 = 0.0;
            } else if (vec3d.y < 0.0) {
                d2 -= vec3d.y;
            }
            if (bl3) {
                d2 = 0.0;
            }
            box = box.offset(vec3d);
            d7 += vec3d.x;
            d8 += vec3d.y;
            d9 += vec3d.z;
            if (bl4) {
                d3 = 0.0;
            }
            d3 = (d3 - d6) * 0.98;
        }
    }

    boolean critAt(int n) {
        if (!this.rawCritAt(n)) {
            return false;
        }
        return !this.kta(n) || this.ktb(n);
    }

    private boolean kta(int n) {
        for (int i = 1; i <= 2; ++i) {
            if (!this.kst[n + i]) continue;
            return true;
        }
        return false;
    }

    private boolean ktb(int n) {
        for (int i = n; i > 0 && !this.kst[i - 1]; --i) {
        }
        for (int i = i; i < 20; ++i) {
            if (this.kst[i]) {
                return true;
            }
            if (!this.kss[i] || this.kta(i)) continue;
            return false;
        }
        return false;
    }

    boolean rawCritAt(int n) {
        return n >= 0 && n < 20 && this.kss[n];
    }

    double fallAt(int n) {
        return n >= 0 && n < 20 ? this.ksu[n] : 0.0;
    }

    boolean smashAt(int n) {
        return n >= 0 && n < 20 && !this.kst[n] && this.ksu[n] > 1.52;
    }

    Vec3d offsetAt(int n) {
        int n2 = Math.max(0, Math.min(19, n));
        return new Vec3d(this.ksv[n2], this.ksw[n2], this.ksx[n2]);
    }

    static double headroom(ClientPlayerEntity clientPlayerEntity, World world, double d) {
        return Entity.adjustMovementForCollisions((Entity)clientPlayerEntity, (Vec3d)new Vec3d((double)0.0, (double)d, (double)0.0), (Box)clientPlayerEntity.getBoundingBox(), (World)world, List.of()).y;
    }

    static float jumpVelocity(ClientPlayerEntity clientPlayerEntity, World world) {
        float f = world.getBlockState(clientPlayerEntity.getBlockPos()).getBlock().getJumpVelocityMultiplier();
        float f2 = world.getBlockState(clientPlayerEntity.getVelocityAffectingPos()).getBlock().getJumpVelocityMultiplier();
        float f3 = f == 1.0f ? f2 : f;
        return (float)clientPlayerEntity.getAttributeValue(EntityAttributes.JUMP_STRENGTH) * f3 + clientPlayerEntity.getJumpBoostVelocityModifier();
    }

    private static /* synthetic */ int aum(int n, int n2) {
        return n * n2 | 0xDDA16690;
    }

    private static /* synthetic */ int aun(int n, int n2) {
        return ksp.aum(n, n2) + n;
    }

    private static /* synthetic */ int auo(int n, int n2) {
        return ksp.aum(n, n2) + n;
    }
}

