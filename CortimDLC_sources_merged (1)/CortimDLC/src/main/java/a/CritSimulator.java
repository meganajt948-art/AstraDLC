/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import a.JumpPhysics;
import a.ktc;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_746;

final class CritSimulator {
    static final int HORIZON = 20;
    private static final double ktg = 0.003;
    private static final double kth = 4.0E-8;
    private static final double kti = 16.0;
    private final ktc ktj = new ktc();
    private final ktc ktk = new ktc();
    private class_746 ktl;
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

    CritSimulator() {
    }

    void sync(class_746 class_7462) {
        this.ktl = class_7462;
        this.ktm = class_7462.method_23317();
        this.ktn = class_7462.method_23318();
        this.kto = class_7462.method_23321();
        this.ktp = class_7462.method_36454();
        this.ktq = class_7462.method_36455();
        this.ktj.ground = this.ktr = class_7462.method_24828();
        this.ktj.velocity = this.ktr ? -class_7462.method_56989() * 0.98 : class_7462.method_18798().field_1351;
        this.ktj.fall = 0.0;
    }

    void afterMove(class_746 class_7462, class_1937 class_19372) {
        boolean bl;
        double d;
        double d2;
        if (class_7462 != this.ktl) {
            this.sync(class_7462);
            return;
        }
        double d3 = class_7462.method_23317() - this.ktm;
        double d4 = d3 * d3 + (d2 = class_7462.method_23318() - this.ktn) * d2 + (d = class_7462.method_23321() - this.kto) * d;
        if (d4 > 16.0 || class_7462.method_5765()) {
            this.sync(class_7462);
            return;
        }
        boolean bl2 = class_7462.method_24828();
        boolean bl3 = d4 > 4.0E-8;
        boolean bl4 = bl = class_7462.method_36454() != this.ktp || class_7462.method_36455() != this.ktq;
        if (bl3 || bl || bl2 != this.ktr) {
            this.ktj.receive(bl3 ? d2 : 0.0, bl2, JumpPhysics.jumpVelocity(class_7462, class_19372), class_7462.method_5799());
            if (bl3) {
                this.ktm = class_7462.method_23317();
                this.ktn = class_7462.method_23318();
                this.kto = class_7462.method_23321();
            }
            if (bl) {
                this.ktp = class_7462.method_36454();
                this.ktq = class_7462.method_36455();
            }
            this.ktr = bl2;
        }
        this.ktj.tick((class_1297)class_7462, class_19372, class_7462.method_5829(), class_7462.method_56989());
    }

    void predict(class_746 class_7462, class_1937 class_19372, boolean bl, int n, boolean bl2) {
        class_238 class_2383 = class_7462.method_5829();
        boolean bl3 = class_7462.method_24828();
        class_243 class_2432 = class_7462.method_18798();
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        double d4 = class_7462.field_6212;
        double d5 = class_7462.field_6250;
        double d6 = d4 * d4 + d5 * d5;
        if (d6 < 1.0E-7) {
            d4 = 0.0;
            d5 = 0.0;
        } else if (d6 > 1.0) {
            double d7 = Math.sqrt(d6);
            d4 /= d7;
            d5 /= d7;
        }
        float f = class_7462.method_36454() * ((float)Math.PI / 180);
        double d8 = class_3532.method_15374((double)f);
        double d9 = class_3532.method_15362((double)f);
        double d10 = d4 * d9 - d5 * d8;
        double d11 = d5 * d9 + d4 * d8;
        if (bl3 && class_7462.method_5715()) {
            d = 0.0;
            d3 = 0.0;
            d10 = 0.0;
            d11 = 0.0;
        }
        float f2 = class_19372.method_8320(class_7462.method_23314()).method_26204().method_9499();
        double d12 = (double)class_7462.method_6029() * (0.21600002 / (double)(f2 * f2 * f2));
        double d13 = class_7462.method_5624() ? 0.026 : 0.02;
        boolean bl4 = class_7462.method_5624();
        double d14 = class_7462.method_56989();
        float f3 = JumpPhysics.jumpVelocity(class_7462, class_19372);
        int n2 = bl2 ? 0 : n;
        boolean bl5 = class_7462.method_5799();
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
            this.ktt[i] = this.kts[i] && !this.ktk.groundsLater((class_1297)class_7462, class_19372, class_2383, d14);
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
            class_243 class_2433 = class_1297.method_20736((class_1297)class_7462, (class_243)new class_243(d += d10 * d18, d2, d3 += d11 * d18), (class_238)class_2383, (class_1937)class_19372, List.of());
            boolean bl7 = class_2433.field_1351 != d2;
            boolean bl8 = bl3 = bl7 && d2 < 0.0;
            if (class_2433.field_1352 != d) {
                d = 0.0;
            }
            if (class_2433.field_1350 != d3) {
                d3 = 0.0;
            }
            class_2383 = class_2383.method_997(class_2433);
            d15 += class_2433.field_1352;
            d16 += class_2433.field_1351;
            d17 += class_2433.field_1350;
            if (bl7) {
                d2 = 0.0;
            }
            d2 = (d2 - d14) * 0.98;
            double d19 = (bl6 ? (double)f2 : 1.0) * 0.91;
            d *= d19;
            d3 *= d19;
            this.ktk.receive(class_2433.field_1351, bl3, f3, bl5);
            this.ktk.tick((class_1297)class_7462, class_19372, class_2383, d14);
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

    class_243 offsetAt(int n) {
        int n2 = Math.max(0, Math.min(19, n));
        return new class_243(this.ktx[n2], this.kty[n2], this.ktz[n2]);
    }

    private static double kuc(class_1297 class_12972, class_1937 class_19372, class_238 class_2383, double d) {
        return class_1297.method_20736((class_1297)class_12972, (class_243)new class_243((double)0.0, (double)d, (double)0.0), (class_238)class_2383, (class_1937)class_19372, List.of()).field_1351;
    }

    private static /* synthetic */ int auu(int n, int n2) {
        return n * n2 ^ 0x1BC299F5;
    }

    private static /* synthetic */ int auv(int n, int n2) {
        return n ^ n2 | 0x428819FA;
    }

    private static /* synthetic */ int auw(int n, int n2) {
        return CritSimulator.auu(n, n2) + n;
    }
}

