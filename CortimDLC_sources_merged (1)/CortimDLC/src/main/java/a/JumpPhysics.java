/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_5134
 *  net.minecraft.class_746
 */
package a;

import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_5134;
import net.minecraft.class_746;

final class JumpPhysics {
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

    JumpPhysics() {
    }

    void predict(class_746 class_7462, class_1937 class_19372, boolean bl, int n, boolean bl2, double d) {
        class_238 class_2383 = class_7462.method_5829();
        boolean bl3 = class_7462.method_24828();
        double d2 = d;
        double d3 = class_7462.method_18798().field_1351;
        double d4 = class_7462.method_23317() - class_7462.field_6014;
        double d5 = class_7462.method_23321() - class_7462.field_5969;
        if (bl3 && class_7462.method_5715()) {
            d4 = 0.0;
            d5 = 0.0;
        }
        double d6 = class_7462.method_56989();
        float f = JumpPhysics.jumpVelocity(class_7462, class_19372);
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
            class_243 class_2432 = class_1297.method_20736((class_1297)class_7462, (class_243)new class_243(d4, d3, d5), (class_238)class_2383, (class_1937)class_19372, List.of());
            boolean bl4 = class_2432.field_1351 != d3;
            boolean bl5 = bl3 = bl4 && d3 < 0.0;
            if (class_2432.field_1352 != d4) {
                d4 = 0.0;
            }
            if (class_2432.field_1350 != d5) {
                d5 = 0.0;
            }
            if (class_2432.field_1351 > 0.0) {
                d2 = 0.0;
            } else if (class_2432.field_1351 < 0.0) {
                d2 -= class_2432.field_1351;
            }
            if (bl3) {
                d2 = 0.0;
            }
            class_2383 = class_2383.method_997(class_2432);
            d7 += class_2432.field_1352;
            d8 += class_2432.field_1351;
            d9 += class_2432.field_1350;
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

    class_243 offsetAt(int n) {
        int n2 = Math.max(0, Math.min(19, n));
        return new class_243(this.ksv[n2], this.ksw[n2], this.ksx[n2]);
    }

    static double headroom(class_746 class_7462, class_1937 class_19372, double d) {
        return class_1297.method_20736((class_1297)class_7462, (class_243)new class_243((double)0.0, (double)d, (double)0.0), (class_238)class_7462.method_5829(), (class_1937)class_19372, List.of()).field_1351;
    }

    static float jumpVelocity(class_746 class_7462, class_1937 class_19372) {
        float f = class_19372.method_8320(class_7462.method_24515()).method_26204().method_23350();
        float f2 = class_19372.method_8320(class_7462.method_23314()).method_26204().method_23350();
        float f3 = f == 1.0f ? f2 : f;
        return (float)class_7462.method_45325(class_5134.field_23728) * f3 + class_7462.method_37416();
    }

    private static /* synthetic */ int aum(int n, int n2) {
        return n * n2 | 0xDDA16690;
    }

    private static /* synthetic */ int aun(int n, int n2) {
        return JumpPhysics.aum(n, n2) + n;
    }

    private static /* synthetic */ int auo(int n, int n2) {
        return JumpPhysics.aum(n, n2) + n;
    }
}

