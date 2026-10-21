/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package a;

import a.AimContext;
import a.GcdFix;
import flow.dev.StringDecryptor;
import java.util.Locale;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;

public final class RotationDebug {
    private static final class_310 lki = class_310.method_1551();
    private static final double lkj = 33.5;
    private static final double lkk = 15.0;
    private static final double lkl = 0.021321961620469083;
    private static final double lkm = 0.8;
    private static final double lkn = 1.25;
    private static final int lko = 24;
    private static final double lkp = 1.5;
    private static final int lkq = 12;
    private static final int lkr = 2;
    private static final double lks = 0.4;
    private static final long lkt = 50L;
    private final AimContext lku;
    private final GcdFix lkv = new GcdFix();
    private final float[] lkw = new float[16];
    private final float[] lkx = new float[16];
    private double lky;
    private long lkz;
    private double lla;
    private double llb;
    private float llc;
    private float lld;
    private int lle = -1;
    private static /* synthetic */ boolean llf;
    private static /* synthetic */ String llg;

    public RotationDebug(AimContext ljx2) {
        this.lku = ljx2;
    }

    public String debug() {
        return String.format(Locale.ROOT, "eta=%d rate=%.2f miss=%.1f", this.lle, this.lla, this.llb);
    }

    public float yaw() {
        return this.llc;
    }

    public float pitch() {
        return this.lld;
    }

    public boolean rotate(float f, float f2) {
        if (RotationDebug.lki.field_1724 == null || this.lku.target == null) {
            return false;
        }
        double d = 1.0;
        if (this.lku.attackReady) {
            d = 0.5;
        }
        float f3 = class_3532.method_15393((float)(this.lku.yawToTarget - f));
        float f4 = class_3532.method_15363((float)(this.lku.pitchToTarget - f2), (float)-90.0f, (float)90.0f);
        f3 += Math.signum(f3) * 25.0f;
        double d2 = this.llh(f, f2, d);
        float f5 = (float)(Math.sin(d2) * 33.5 * d + (double)f3 * 0.2);
        float f6 = (float)(Math.cos(d2) * 15.0 * d + (double)f4 * 0.1);
        this.llc = f + this.lkv.fix(f5, true);
        this.lld = class_3532.method_15363((float)(f2 + this.lkv.fix(f6, false)), (float)-90.0f, (float)90.0f);
        return true;
    }

    private double llh(float f, float f2, double d) {
        int n;
        if (this.lkz == 0L) {
            this.lkz = System.currentTimeMillis();
            this.lky = (double)this.lkz * 0.021321961620469083;
            return this.lky;
        }
        double d2 = 1.0660980810234542;
        this.lle = n = this.llk();
        this.lll(Math.min(n + 2, 15));
        double d3 = this.llm(true);
        double d4 = this.llm(false);
        this.lli(d2, f, f2, d, n, n, d3, d4);
        if (this.llb > 0.0) {
            this.lli(d2, f, f2, d, n, n + 2, d3, d4);
        }
        this.lky += d2 * this.lla;
        return this.lky;
    }

    private void lli(double d, float f, float f2, double d2, int n, int n2, double d3, double d4) {
        double d5 = 1.0;
        double d6 = Double.MAX_VALUE;
        double d7 = Double.MAX_VALUE;
        for (int i = 0; i <= 24; ++i) {
            double d8 = 0.8 + 0.44999999999999996 * (double)i / 24.0;
            double d9 = this.llj(d * d8, f, f2, d2, n, n2, d3, d4);
            double d10 = d9 + Math.abs(d8 - 1.0) * 1.5;
            if (!(d10 < d6)) continue;
            d6 = d10;
            d5 = d8;
            d7 = d9;
        }
        this.lla = d5;
        this.llb = d7;
    }

    private double llj(double d, float f, float f2, double d2, int n, int n2, double d3, double d4) {
        double d5 = this.lky;
        float f3 = f;
        float f4 = f2;
        double d6 = Double.MAX_VALUE;
        for (int i = 0; i <= n2; ++i) {
            double d7 = i >= n ? Math.min(d2, 0.5) : d2;
            float f5 = class_3532.method_15393((float)(this.lkw[i] - f3));
            float f6 = class_3532.method_15363((float)(this.lkx[i] - f4), (float)-90.0f, (float)90.0f);
            f3 += (float)(Math.sin(d5 += d) * 33.5 * d7 + (double)(f5 + Math.signum(f5) * 25.0f) * 0.2);
            f4 = class_3532.method_15363((float)(f4 + (float)(Math.cos(d5) * 15.0 * d7 + (double)f6 * 0.1)), (float)-90.0f, (float)90.0f);
            if (i < n) continue;
            double d8 = Math.max(0.0, (double)Math.abs(class_3532.method_15393((float)(this.lkw[i] - f3))) - d3);
            double d9 = Math.max(0.0, (double)Math.abs(this.lkx[i] - f4) - d4);
            d6 = Math.min(d6, d8 + d9);
        }
        return d6;
    }

    private int llk() {
        return class_3532.method_15340((int)this.lku.strikeIn, (int)0, (int)12);
    }

    private void lll(int n) {
        this.lkw[0] = this.lku.yawToTarget;
        this.lkx[0] = this.lku.pitchToTarget;
        for (int i = 1; i <= n; ++i) {
            class_243 class_2432 = this.lku.eyeAt[i];
            class_243 class_2433 = this.lku.targetAt[i];
            if (class_2432 == null || class_2433 == null) {
                this.lkw[i] = this.lkw[i - 1];
                this.lkx[i] = this.lkx[i - 1];
                continue;
            }
            double d = class_2433.field_1352 - class_2432.field_1352;
            double d2 = class_2433.field_1351 - class_2432.field_1351;
            double d3 = class_2433.field_1350 - class_2432.field_1350;
            this.lkw[i] = (float)(Math.toDegrees(Math.atan2(d3, d)) - 90.0);
            this.lkx[i] = (float)(-Math.toDegrees(Math.atan2(d2, Math.hypot(d, d3))));
        }
    }

    private double llm(boolean bl) {
        class_238 class_2383 = this.lku.box;
        double d = bl ? Math.min(class_2383.method_17939(), class_2383.method_17941()) : class_2383.method_17940();
        class_243 class_2432 = RotationDebug.lki.field_1724.method_33571();
        class_243 class_2433 = class_2383.method_1005();
        double d2 = Math.max(0.05, Math.hypot(class_2433.field_1352 - class_2432.field_1352, class_2433.field_1350 - class_2432.field_1350));
        return Math.toDegrees(Math.atan2(d * 0.4, d2));
    }

    public void enabled() {
        this.lkv.reset();
        this.lkz = 0L;
    }

    public void targetNull() {
        this.lkv.reset();
        this.lkz = 0L;
    }

    private static /* synthetic */ int axd(int n, int n2) {
        return n + n2 | 0xFC956EAC;
    }

    private static /* synthetic */ int axe(int n, int n2) {
        return RotationDebug.axd(n, n2) ^ 0xAB8867DC;
    }

    private static /* synthetic */ int axf(int n, int n2) {
        return RotationDebug.axe(n, n2) + n;
    }
}

