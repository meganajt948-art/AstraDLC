/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import java.util.List;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public final class SmashPredictor {
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

    public void predict(class_746 class_7462, class_1937 class_19372, double d) {
        double d2;
        class_238 class_2383 = class_7462.method_5829();
        boolean bl = class_7462.method_24828();
        double d3 = d;
        class_243 class_2432 = class_7462.method_18798();
        double d4 = class_2432.field_1352;
        double d5 = class_2432.field_1351;
        double d6 = class_2432.field_1350;
        double d7 = class_7462.method_23320() - class_7462.method_23318();
        double d8 = class_7462.method_56989();
        double d9 = 0.0;
        double d10 = 0.0;
        double d11 = class_7462.field_6212;
        double d12 = class_7462.field_6250;
        double d13 = d11 * d11 + d12 * d12;
        if (d13 > 1.0E-7) {
            if (d13 > 1.0) {
                d2 = Math.sqrt(d13);
                d11 /= d2;
                d12 /= d2;
            }
            d2 = class_7462.method_5624() ? 0.026 : 0.02;
            float f = class_7462.method_36454() * ((float)Math.PI / 180);
            double d14 = class_3532.method_15374((double)f);
            double d15 = class_3532.method_15362((double)f);
            d9 = (d11 * d15 - d12 * d14) * d2;
            d10 = (d12 * d15 + d11 * d14) * d2;
        }
        d2 = class_7462.method_23317();
        double d16 = class_7462.method_23318();
        double d17 = class_7462.method_23321();
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
            class_243 class_2433 = class_1297.method_20736((class_1297)class_7462, (class_243)new class_243(d4 += d9, d5, d6 += d10), (class_238)class_2383, (class_1937)class_19372, List.of());
            boolean bl2 = class_2433.field_1351 != d5;
            boolean bl3 = bl = bl2 && d5 < 0.0;
            if (class_2433.field_1352 != d4) {
                d4 = 0.0;
            }
            if (class_2433.field_1350 != d6) {
                d6 = 0.0;
            }
            if (class_2433.field_1351 > 0.0) {
                d3 = 0.0;
            } else if (class_2433.field_1351 < 0.0) {
                d3 -= class_2433.field_1351;
            }
            if (bl) {
                d3 = 0.0;
            }
            class_2383 = class_2383.method_997(class_2433);
            d2 += class_2433.field_1352;
            d16 += class_2433.field_1351;
            d17 += class_2433.field_1350;
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

    public class_243 eye(int n) {
        int n2 = class_3532.method_15340((int)n, (int)0, (int)42);
        return new class_243(this.lmq[n2], this.lmr[n2], this.lms[n2]);
    }

    public double fall(int n) {
        return this.lmt[class_3532.method_15340((int)n, (int)0, (int)42)];
    }

    public int landing() {
        return this.lmv;
    }

    public class_238 sweep(class_746 class_7462) {
        class_243 class_2432 = this.eye(39).method_1020(this.eye(0));
        return class_7462.method_5829().method_18804(class_2432);
    }

    public static boolean environment(class_746 class_7462, class_1937 class_19372) {
        return !class_7462.method_6101() && !class_7462.method_5799() && !class_7462.method_5771() && !class_7462.method_5765() && !class_7462.method_6128() && !class_7462.method_31549().field_7479 && !class_7462.field_27857 && !class_7462.method_6059(class_1294.field_5902) && !class_7462.method_6059(class_1294.field_5906) && class_19372.method_29546(class_7462.method_5829().method_1011(1.0E-7)).noneMatch(SmashPredictor::lna);
    }

    private static boolean lna(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10343) || class_26802.method_27852(class_2246.field_16999) || class_26802.method_27852(class_2246.field_27879);
    }

    private static /* synthetic */ int axq(int n, int n2) {
        return n - n2 ^ 0xCF64C28D;
    }
}

