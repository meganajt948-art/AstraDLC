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
        Box box = clientPlayerEntity.method_5829();
        boolean bl = clientPlayerEntity.method_24828();
        double d3 = d;
        Vec3d vec3d = clientPlayerEntity.method_18798();
        double d4 = vec3d.field_1352;
        double d5 = vec3d.field_1351;
        double d6 = vec3d.field_1350;
        double d7 = clientPlayerEntity.method_23320() - clientPlayerEntity.method_23318();
        double d8 = clientPlayerEntity.method_56989();
        double d9 = 0.0;
        double d10 = 0.0;
        double d11 = clientPlayerEntity.field_6212;
        double d12 = clientPlayerEntity.field_6250;
        double d13 = d11 * d11 + d12 * d12;
        if (d13 > 1.0E-7) {
            if (d13 > 1.0) {
                d2 = Math.sqrt(d13);
                d11 /= d2;
                d12 /= d2;
            }
            d2 = clientPlayerEntity.method_5624() ? 0.026 : 0.02;
            float f = clientPlayerEntity.method_36454() * ((float)Math.PI / 180);
            double d14 = MathHelper.method_15374((double)f);
            double d15 = MathHelper.method_15362((double)f);
            d9 = (d11 * d15 - d12 * d14) * d2;
            d10 = (d12 * d15 + d11 * d14) * d2;
        }
        d2 = clientPlayerEntity.method_23317();
        double d16 = clientPlayerEntity.method_23318();
        double d17 = clientPlayerEntity.method_23321();
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
            Vec3d vec3d2 = Entity.method_20736((Entity)clientPlayerEntity, (Vec3d)new Vec3d(d4 += d9, d5, d6 += d10), (Box)box, (World)world, List.of());
            boolean bl2 = vec3d2.field_1351 != d5;
            boolean bl3 = bl = bl2 && d5 < 0.0;
            if (vec3d2.field_1352 != d4) {
                d4 = 0.0;
            }
            if (vec3d2.field_1350 != d6) {
                d6 = 0.0;
            }
            if (vec3d2.field_1351 > 0.0) {
                d3 = 0.0;
            } else if (vec3d2.field_1351 < 0.0) {
                d3 -= vec3d2.field_1351;
            }
            if (bl) {
                d3 = 0.0;
            }
            box = box.method_997(vec3d2);
            d2 += vec3d2.field_1352;
            d16 += vec3d2.field_1351;
            d17 += vec3d2.field_1350;
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
        int n2 = MathHelper.method_15340((int)n, (int)0, (int)42);
        return new Vec3d(this.lmq[n2], this.lmr[n2], this.lms[n2]);
    }

    public double fall(int n) {
        return this.lmt[MathHelper.method_15340((int)n, (int)0, (int)42)];
    }

    public int landing() {
        return this.lmv;
    }

    public Box sweep(ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = this.eye(39).method_1020(this.eye(0));
        return clientPlayerEntity.method_5829().method_18804(vec3d);
    }

    public static boolean environment(ClientPlayerEntity clientPlayerEntity, World world) {
        return !clientPlayerEntity.method_6101() && !clientPlayerEntity.method_5799() && !clientPlayerEntity.method_5771() && !clientPlayerEntity.method_5765() && !clientPlayerEntity.method_6128() && !clientPlayerEntity.method_31549().field_7479 && !clientPlayerEntity.field_27857 && !clientPlayerEntity.method_6059(StatusEffects.field_5902) && !clientPlayerEntity.method_6059(StatusEffects.field_5906) && world.method_29546(clientPlayerEntity.method_5829().method_1011(1.0E-7)).noneMatch(lmn::lna);
    }

    private static boolean lna(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10343) || blockState.method_27852(Blocks.field_16999) || blockState.method_27852(Blocks.field_27879);
    }

    private static /* synthetic */ int axq(int n, int n2) {
        return n - n2 ^ 0xCF64C28D;
    }
}

