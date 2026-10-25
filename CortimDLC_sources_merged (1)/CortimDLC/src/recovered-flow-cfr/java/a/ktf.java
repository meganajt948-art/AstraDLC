/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.ksp;
import a.ktc;
import java.util.List;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

final class ktf {
    static final int HORIZON = 20;
    private static final double ktg = 0.003;
    private static final double kth = 4.0E-8;
    private static final double kti = 16.0;
    private final ktc ktj = new ktc();
    private final ktc ktk = new ktc();
    private ClientPlayerEntity ktl;
    private double ktm;
    private double ktn;
    private double kto;
    private float ktp;
    private float ktq;
    private boolean ktr;
    private final boolean[] kts = new boolean[20];
    private final boolean[] ktt = new boolean[20];
    private final boolean[] ktu = new boolean[20];
    private final boolean[] ktv = new boolean[20];
    private final double[] ktw = new double[20];
    private final double[] ktx = new double[20];
    private final double[] kty = new double[20];
    private final double[] ktz = new double[20];
    private static /* synthetic */ int kua;
    private static /* synthetic */ String kub;

    ktf() {
    }

    void sync(ClientPlayerEntity clientPlayerEntity) {
        this.ktl = clientPlayerEntity;
        this.ktm = clientPlayerEntity.getX();
        this.ktn = clientPlayerEntity.getY();
        this.kto = clientPlayerEntity.getZ();
        this.ktp = clientPlayerEntity.getYaw();
        this.ktq = clientPlayerEntity.getPitch();
        this.ktj.ground = this.ktr = clientPlayerEntity.isOnGround();
        this.ktj.velocity = this.ktr ? -clientPlayerEntity.getFinalGravity() * 0.98 : clientPlayerEntity.getVelocity().y;
        this.ktj.fall = 0.0;
    }

    void afterMove(ClientPlayerEntity clientPlayerEntity, World world) {
        boolean bl;
        double d;
        double d2;
        if (clientPlayerEntity != this.ktl) {
            this.sync(clientPlayerEntity);
            return;
        }
        double d3 = clientPlayerEntity.getX() - this.ktm;
        double d4 = d3 * d3 + (d2 = clientPlayerEntity.getY() - this.ktn) * d2 + (d = clientPlayerEntity.getZ() - this.kto) * d;
        if (d4 > 16.0 || clientPlayerEntity.hasVehicle()) {
            this.sync(clientPlayerEntity);
            return;
        }
        boolean bl2 = clientPlayerEntity.isOnGround();
        boolean bl3 = d4 > 4.0E-8;
        boolean bl4 = bl = clientPlayerEntity.getYaw() != this.ktp || clientPlayerEntity.getPitch() != this.ktq;
        if (bl3 || bl || bl2 != this.ktr) {
            this.ktj.receive(bl3 ? d2 : 0.0, bl2, ksp.jumpVelocity(clientPlayerEntity, world), clientPlayerEntity.isTouchingWater());
            if (bl3) {
                this.ktm = clientPlayerEntity.getX();
                this.ktn = clientPlayerEntity.getY();
                this.kto = clientPlayerEntity.getZ();
            }
            if (bl) {
                this.ktp = clientPlayerEntity.getYaw();
                this.ktq = clientPlayerEntity.getPitch();
            }
            this.ktr = bl2;
        }
        this.ktj.tick((Entity)clientPlayerEntity, world, clientPlayerEntity.getBoundingBox(), clientPlayerEntity.getFinalGravity());
    }

    void predict(ClientPlayerEntity clientPlayerEntity, World world, boolean bl, int n, boolean bl2) {
        Box box = clientPlayerEntity.getBoundingBox();
        boolean bl3 = clientPlayerEntity.isOnGround();
        Vec3d vec3d = clientPlayerEntity.getVelocity();
        double d = vec3d.x;
        double d2 = vec3d.y;
        double d3 = vec3d.z;
        double d4 = clientPlayerEntity.sidewaysSpeed;
        double d5 = clientPlayerEntity.forwardSpeed;
        double d6 = d4 * d4 + d5 * d5;
        if (d6 < 1.0E-7) {
            d4 = 0.0;
            d5 = 0.0;
        } else if (d6 > 1.0) {
            double d7 = Math.sqrt(d6);
            d4 /= d7;
            d5 /= d7;
        }
        float f = clientPlayerEntity.getYaw() * ((float)Math.PI / 180);
        double d8 = MathHelper.sin((double)f);
        double d9 = MathHelper.cos((double)f);
        double d10 = d4 * d9 - d5 * d8;
        double d11 = d5 * d9 + d4 * d8;
        if (bl3 && clientPlayerEntity.isSneaking()) {
            d = 0.0;
            d3 = 0.0;
            d10 = 0.0;
            d11 = 0.0;
        }
        float f2 = world.getBlockState(clientPlayerEntity.getVelocityAffectingPos()).getBlock().getSlipperiness();
        double d12 = (double)clientPlayerEntity.getMovementSpeed() * (0.21600002 / (double)(f2 * f2 * f2));
        double d13 = clientPlayerEntity.isSprinting() ? 0.026 : 0.02;
        boolean bl4 = clientPlayerEntity.isSprinting();
        double d14 = clientPlayerEntity.getFinalGravity();
        float f3 = ksp.jumpVelocity(clientPlayerEntity, world);
        int n2 = bl2 ? 0 : n;
        boolean bl5 = clientPlayerEntity.isTouchingWater();
        this.ktk.copy(this.ktj);
        double d15 = 0.0;
        double d16 = 0.0;
        double d17 = 0.0;
        for (int i = 0; i < 20; ++i) {
            boolean bl6;
            this.ktu[i] = !bl3;
            this.ktv[i] = this.ktk.ground;
            this.ktw[i] = this.ktk.fall;
            this.kts[i] = this.ktk.fall > 0.0 && !this.ktk.ground;
            this.ktt[i] = this.kts[i] && !this.ktk.groundsLater((Entity)clientPlayerEntity, world, box, d14);
            this.ktx[i] = d15;
            this.kty[i] = d16;
            this.ktz[i] = d17;
            if (n2 > 0) {
                --n2;
            }
            if (Math.abs(d2) < 0.003) {
                d2 = 0.0;
            }
            if (d * d + d3 * d3 < 9.0E-6) {
                d = 0.0;
                d3 = 0.0;
            }
            if (bl) {
                if (bl3 && n2 == 0 && f3 > 1.0E-5f) {
                    d2 = Math.max((double)f3, d2);
                    int n3 = n2 = bl2 ? 0 : 10;
                    if (bl4) {
                        d -= d8 * 0.2;
                        d3 += d9 * 0.2;
                    }
                }
            } else {
                n2 = 0;
            }
            double d18 = (bl6 = bl3) ? d12 : d13;
            Vec3d vec3d2 = Entity.adjustMovementForCollisions((Entity)clientPlayerEntity, (Vec3d)new Vec3d(d += d10 * d18, d2, d3 += d11 * d18), (Box)box, (World)world, List.of());
            boolean bl7 = vec3d2.y != d2;
            boolean bl8 = bl3 = bl7 && d2 < 0.0;
            if (vec3d2.x != d) {
                d = 0.0;
            }
            if (vec3d2.z != d3) {
                d3 = 0.0;
            }
            box = box.offset(vec3d2);
            d15 += vec3d2.x;
            d16 += vec3d2.y;
            d17 += vec3d2.z;
            if (bl7) {
                d2 = 0.0;
            }
            d2 = (d2 - d14) * 0.98;
            double d19 = (bl6 ? (double)f2 : 1.0) * 0.91;
            d *= d19;
            d3 *= d19;
            this.ktk.receive(vec3d2.y, bl3, f3, bl5);
            this.ktk.tick((Entity)clientPlayerEntity, world, box, d14);
        }
    }

    boolean critAt(int n) {
        return n >= 0 && n < 20 && this.kts[n];
    }

    boolean safeAt(int n) {
        return n >= 0 && n < 20 && this.ktt[n];
    }

    boolean airAt(int n) {
        return n >= 0 && n < 20 && this.ktu[n];
    }

    boolean serverGroundAt(int n) {
        return n >= 0 && n < 20 && this.ktv[n];
    }

    double fallAt(int n) {
        return n >= 0 && n < 20 ? this.ktw[n] : 0.0;
    }

    boolean landsWithin(int n, int n2) {
        if (!this.airAt(n)) {
            return false;
        }
        for (int i = 1; i <= n2 && n + i < 20; ++i) {
            if (this.ktu[n + i]) continue;
            return true;
        }
        return false;
    }

    Vec3d offsetAt(int n) {
        int n2 = Math.max(0, Math.min(19, n));
        return new Vec3d(this.ktx[n2], this.kty[n2], this.ktz[n2]);
    }

    private static double kuc(Entity entity, World world, Box box, double d) {
        return Entity.adjustMovementForCollisions((Entity)entity, (Vec3d)new Vec3d((double)0.0, (double)d, (double)0.0), (Box)box, (World)world, List.of()).y;
    }

    private static /* synthetic */ int auu(int n, int n2) {
        return n * n2 ^ 0x1BC299F5;
    }

    private static /* synthetic */ int auv(int n, int n2) {
        return n ^ n2 | 0x428819FA;
    }

    private static /* synthetic */ int auw(int n, int n2) {
        return ktf.auu(n, n2) + n;
    }
}

