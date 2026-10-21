/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import a.lpp;
import a.AngleUtil;
import a.AimModel;
import a.AimBrain;
import flow.dev.StringDecryptor;
import java.util.Locale;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public final class AimDriver {
    private static final double lnh = 30.0;
    private static final int lni = 10;
    private static final double lnj = 8.0;
    private static final double lnk = 45.0;
    private static final int lnl = 1;
    private static final int lnm = 2;
    private static final double lnn = 1.0;
    private static final double lno = 4.0;
    private static final double lnp = 4.0;
    private static final int lnq = 12;
    private static final double lnr = 150.0;
    private static final double lns = 1.5;
    private static final Object lnt = new Object();
    private final AimBrain lnu = new AimBrain();
    private final Random lnv = new Random();
    private final double[] lnw = new double[2];
    private boolean lnx;
    private double lny = 1.0;
    private double lnz = 45.0;
    private double loa;
    private double lob;
    private double loc;
    private double lod;
    private boolean loe;
    private float lof;
    private float log;
    private float loh;
    private float loi;
    private boolean loj;
    private class_1297 lok;
    private int lol;
    private int lom;
    private double lon;
    private class_746 loo;
    private float lop;
    private float loq;
    private double lor;
    private double los;
    private static /* synthetic */ String lot;
    private static /* synthetic */ int lou;

    public void use(AimModel tck2, double d) {
        this.lny = d;
        this.lnu.use(tck2);
        this.lnu.tune(d, 1.0, 1.0);
        this.lnu.verticalAware(true);
    }

    public void vertical(double d) {
        this.lnu.tune(this.lny, 1.0, d);
    }

    public void height(double d, double d2) {
        this.lnu.height(d, d2);
    }

    public void stepCap(double d) {
        this.lnz = d;
    }

    public void verticalAware(boolean bl) {
        this.lnu.verticalAware(bl);
    }

    public class_1297 target() {
        return this.loj ? (this.lok != null ? this.lok : this.lnu.target()) : null;
    }

    public float cameraYaw(class_746 class_7462) {
        return this.loe ? this.lof : class_7462.method_36454();
    }

    public double maxTurn() {
        return 30.0 * this.lny;
    }

    public boolean idle() {
        return this.loa == 0.0 && this.lob == 0.0;
    }

    public String debugOffsets() {
        return String.format(Locale.ROOT, "%.1f/%.1f hold=%d home=%d engaged=%s", this.loa, this.lob, this.lol, this.lom, this.loj);
    }

    public double offset() {
        return Math.sqrt(this.loa * this.loa + this.lob * this.lob);
    }

    public void mode(boolean bl, class_746 class_7462) {
        if (this.lnx == bl) {
            return;
        }
        this.end(class_7462);
        this.forget();
        this.lnx = bl;
    }

    public void forget() {
        this.loa = 0.0;
        this.lob = 0.0;
        this.loc = 0.0;
        this.lod = 0.0;
        this.loj = false;
        this.lok = null;
        this.lol = 0;
        this.lom = 0;
    }

    public void reset() {
        this.forget();
        this.lnu.reset();
        this.loo = null;
    }

    public float serverYaw(class_746 class_7462) {
        return this.lnx && !this.loe ? (float)((double)class_7462.method_36454() + this.loa) : class_7462.method_36454();
    }

    public float serverPitch(class_746 class_7462) {
        return this.lnx && !this.loe ? class_3532.method_15363((float)((float)((double)class_7462.method_36455() + this.lob)), (float)-90.0f, (float)90.0f) : class_7462.method_36455();
    }

    public void begin(class_746 class_7462) {
        if (class_7462 == null) {
            return;
        }
        if (!this.loe && this.loo == class_7462) {
            double d = (double)(class_7462.method_36454() - this.lop) - this.lor;
            double d2 = (double)(class_7462.method_36455() - this.loq) - this.los;
            if (this.lnx) {
                if ((this.loj || this.lol > 0) && !this.idle()) {
                    this.loa -= d;
                    this.lob -= d2;
                }
            } else if (!this.loj && this.lol == 0 && !this.idle() && Math.abs(d) + Math.abs(d2) > 1.0) {
                this.release();
            }
        }
        this.los = 0.0;
        this.lor = 0.0;
        if (!this.loe) {
            this.low(class_7462);
        }
        if (!this.lnx || this.loe || this.idle()) {
            return;
        }
        this.loy(class_7462);
        class_7462.method_36456((float)((double)this.lof + this.loa));
        class_7462.method_36457(class_3532.method_15363((float)((float)((double)this.log + this.lob)), (float)-90.0f, (float)90.0f));
    }

    public void end(class_746 class_7462) {
        if (!this.loe) {
            return;
        }
        this.loe = false;
        if (class_7462 == null) {
            return;
        }
        class_7462.method_36456(this.lof);
        class_7462.method_36457(this.log);
        class_7462.field_5982 = this.lof;
        class_7462.field_6004 = this.log;
        class_7462.field_3931 = this.loh;
        class_7462.field_3914 = this.loi;
        class_7462.field_3932 = this.loh + (this.lof - this.loh) * 0.5f;
        class_7462.field_3916 = this.loi + (this.log - this.loi) * 0.5f;
    }

    public void newTick(class_746 class_7462) {
        this.lon = 0.0;
        this.los = 0.0;
        this.lor = 0.0;
        this.loo = class_7462;
        if (class_7462 != null) {
            this.lop = class_7462.method_36454();
            this.loq = class_7462.method_36455();
        }
    }

    public boolean approach(class_310 class_3102, class_746 class_7462, lpp lpp2, class_238 class_2383) {
        float f = this.serverYaw(class_7462);
        float f2 = this.serverPitch(class_7462);
        if (!this.loj) {
            double d = class_3532.method_15393((float)(lpp2.yaw() - f));
            double d2 = lpp2.pitch() - f2;
            if (lpp2.tick() > 10 && Math.sqrt(d * d + d2 * d2) < 8.0 * this.lny * (double)lpp2.tick()) {
                return false;
            }
        }
        this.loj = true;
        this.lol = 0;
        this.lom = 0;
        class_238 class_2384 = lpp2.box();
        class_243 class_2432 = lpp2.eye();
        class_243 class_2433 = lpp2.aim();
        double d = AngleUtil.hitU(class_2432.field_1352, class_2432.field_1350, (class_2384.field_1323 + class_2384.field_1320) * 0.5, (class_2384.field_1321 + class_2384.field_1324) * 0.5, (class_2384.field_1320 - class_2384.field_1323) * 0.5, class_2433.field_1352, class_2433.field_1350);
        double d3 = AngleUtil.hitV(class_2384.field_1322, class_2384.field_1325 - class_2384.field_1322, class_2433.field_1351);
        if (this.lnu.steerAt(class_7462, lpp2.target(), class_2383, class_2432, d, d3, 1, f, f2, this.lnw)) {
            this.lov(class_3102, class_7462);
        }
        return true;
    }

    public void track(class_310 class_3102, class_746 class_7462, class_1297 class_12972, int n) {
        float f = this.serverYaw(class_7462);
        float f2 = this.serverPitch(class_7462);
        this.loj = true;
        this.lok = null;
        this.lol = 0;
        this.lom = 0;
        if (this.lnu.steer(class_7462, class_12972, class_12972.method_5829(), class_7462.method_33571(), n, f, f2, this.lnw)) {
            this.lov(class_3102, class_7462);
        }
    }

    public void turnBy(class_310 class_3102, class_746 class_7462, class_1297 class_12972, double d, double d2) {
        this.loj = true;
        this.lok = class_12972;
        this.lol = 0;
        this.lom = 0;
        this.loz(class_3102, class_7462, d, d2, true);
    }

    private void lov(class_310 class_3102, class_746 class_7462) {
        double d = Math.hypot(this.lnw[0], this.lnw[1]);
        double d2 = d > this.lnz ? this.lnz / d : 1.0;
        this.loz(class_3102, class_7462, this.lnw[0] * d2, this.lnw[1] * d2, true);
    }

    public void hit(int n) {
        this.lol = Math.max(this.lol, n);
        this.loj = false;
    }

    public boolean home(class_310 class_3102, class_746 class_7462) {
        this.loj = false;
        float f = this.serverYaw(class_7462);
        float f2 = this.serverPitch(class_7462);
        if (this.lol > 0) {
            --this.lol;
            this.lnu.idle(f, f2);
            return false;
        }
        if (this.idle()) {
            this.lom = 0;
            this.lnu.idle(f, f2);
            return true;
        }
        ++this.lom;
        this.low(class_7462);
        double d = class_3532.method_15350((double)(-this.loa), (double)-150.0, (double)150.0);
        double d2 = (double)f2 - this.lob;
        boolean bl = this.lnu.steerTo(class_7462, lnt, (double)f + d, d2, 2, f, f2, this.lnw);
        if (this.lom > 12) {
            this.lox(class_3102, class_7462, 0.5 + this.lnv.nextDouble() * 0.3, this.maxTurn());
        } else if (bl && this.offset() < 4.0) {
            this.lox(class_3102, class_7462, 0.5 + this.lnv.nextDouble() * 0.3, 4.0);
        } else if (bl) {
            this.lov(class_3102, class_7462);
        }
        if (this.offset() <= Math.max(0.3, AimDriver.lpa(class_3102, class_7462) * 1.5)) {
            this.forget();
            return true;
        }
        return false;
    }

    public void release() {
        this.forget();
        this.lnu.drop();
    }

    private void low(class_746 class_7462) {
        float f = class_7462.method_36455();
        this.lob = this.lnx ? (double)(class_3532.method_15363((float)((float)((double)f + this.lob)), (float)-90.0f, (float)90.0f) - f) : (double)f - class_3532.method_15350((double)((double)f - this.lob), (double)-90.0, (double)90.0);
    }

    public void snap(class_310 class_3102, class_746 class_7462, float f, float f2) {
        if (this.lnx && !this.loe) {
            this.loy(class_7462);
        }
        double d = class_3532.method_15393((float)(f - class_7462.method_36454()));
        double d2 = f2 - class_7462.method_36455();
        double d3 = Math.sqrt(d * d + d2 * d2);
        double d4 = Math.max(0.0, this.maxTurn() - this.lon);
        if (d3 < 1.0E-4 || d4 <= 0.0) {
            return;
        }
        double d5 = Math.min(1.0, d4 / d3);
        this.loz(class_3102, class_7462, d * d5, d2 * d5, false);
    }

    private void lox(class_310 class_3102, class_746 class_7462, double d, double d2) {
        double d3 = this.offset();
        if (d3 <= 0.0) {
            return;
        }
        double d4 = Math.min(d, d2 / d3);
        this.loz(class_3102, class_7462, -this.loa * d4, -this.lob * d4, true);
    }

    private void loy(class_746 class_7462) {
        this.lof = class_7462.method_36454();
        this.log = class_7462.method_36455();
        this.loh = class_7462.field_3932;
        this.loi = class_7462.field_3916;
        this.loe = true;
    }

    private void loz(class_310 class_3102, class_746 class_7462, double d, double d2, boolean bl) {
        double d3;
        double d4;
        double d5 = AimDriver.lpb(class_3102, class_7462);
        double d6 = d5 * 0.15;
        if (d6 <= 0.0) {
            return;
        }
        this.loc += d / d6;
        this.lod += d2 / d6;
        long l = (long)this.loc;
        long l2 = (long)this.lod;
        this.loc -= (double)l;
        this.lod -= (double)l2;
        if (l == 0L && l2 == 0L) {
            return;
        }
        if (this.lnx && !this.loe) {
            double d7;
            for (d7 = (double)this.serverPitch(class_7462) + (double)l2 * d6; d7 > 90.0 && l2 > 0L; --l2, d7 -= d6) {
            }
            while (d7 < -90.0 && l2 < 0L) {
                ++l2;
                d7 += d6;
            }
            d4 = (float)((double)l * d5) * 0.15f;
            d3 = (float)((double)l2 * d5) * 0.15f;
        } else {
            float f = class_7462.method_36454();
            float f2 = class_7462.method_36455();
            float f3 = class_7462.field_5982;
            float f4 = class_7462.field_6004;
            class_7462.method_5872((double)l * d5, (double)l2 * d5);
            d4 = class_7462.method_36454() - f;
            d3 = class_7462.method_36455() - f2;
            if (!this.lnx) {
                this.lor += d4;
                this.los += d3;
            }
            if (bl) {
                class_7462.field_5982 = f3;
                class_7462.field_6004 = f4;
            }
        }
        this.loa += d4;
        this.lob += d3;
        this.lon += Math.sqrt(d4 * d4 + d3 * d3);
        this.lnu.turned(d4, d3);
    }

    private static double lpa(class_310 class_3102, class_746 class_7462) {
        return AimDriver.lpb(class_3102, class_7462) * 0.15;
    }

    private static double lpb(class_310 class_3102, class_746 class_7462) {
        double d = (Double)class_3102.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = class_3102.field_1690.method_31044().method_31034() && class_7462.method_31550();
        return bl ? d2 : d2 * 8.0;
    }

    private static /* synthetic */ int axw(int n, int n2) {
        return n - n2 ^ 0x36B1AAE8;
    }

    private static /* synthetic */ int axx(int n, int n2) {
        return AimDriver.axw(n, n2) ^ 0x33B4E11;
    }
}

