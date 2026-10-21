/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 */
package a;

import a.prz;
import a.psc;
import a.Route;
import a.CameraOwner;
import a.pvb;
import a.RouteWalker;
import a.PathProjection;
import a.tvw;
import a.WalkSpeedModel;
import a.WalkModelReader;
import java.util.List;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;

public final class WalkDriver {
    private static final int pye = 14;
    private static final int pyf = 5;
    private static final int pyg = 4;
    public final RouteWalker stride = new RouteWalker();
    private final Random pyh = new Random();
    private WalkSpeedModel pyi;
    private Route pyj;
    private class_243 pyk;
    private int pyl;
    private Route pym;
    private int pyn;
    private boolean pyo;
    private double pyp;
    private double pyq;
    private double pyr = Double.NaN;
    private boolean pys;
    private int pyt;
    private double pyu;
    private int pyv;
    private int pyw;
    private int pyx;
    private long pyy = -1L;
    private boolean pyz;
    private static /* synthetic */ boolean pza;
    private static /* synthetic */ boolean pzb;

    public void personalize(long l) {
        this.stride.personalize(l);
    }

    public psc style() {
        return this.stride.routeStyle();
    }

    public void reset() {
        this.stride.reset();
        this.pyj = null;
        this.pyk = null;
        this.pyo = false;
        this.pys = false;
        this.pyt = 0;
        this.pyv = 0;
        this.pyy = -1L;
        if (this.pyi != null) {
            this.pyi.reset();
        }
    }

    public void beginTick() {
        this.pym = null;
        this.pys = false;
        this.pyo = false;
        this.pyr = Double.NaN;
    }

    public boolean drove() {
        return this.pys;
    }

    public boolean neural() {
        return this.pys && this.pyz;
    }

    public Route shown() {
        return this.pym;
    }

    public int shownAt() {
        return this.pyn;
    }

    public double moveYaw(double d) {
        return Double.isNaN(this.pyr) ? d : this.pyr;
    }

    public boolean takeTurn(double[] dArray) {
        if (!this.pyo) {
            return false;
        }
        this.pyo = false;
        dArray[0] = this.pyp;
        dArray[1] = this.pyq;
        return true;
    }

    public WalkSpeedModel brain() {
        return this.pyi;
    }

    public double remaining(Route psf2) {
        if (psf2 == null) {
            return 0.0;
        }
        return this.stride.route() == psf2 ? psf2.track.length() - this.stride.progress() : psf2.track.length();
    }

    public Route plan(class_1937 class_19372, class_1657 class_16572, List<class_2338> list, class_2338 class_23382, prz prz2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            return Route.of(class_19372, (class_1297)class_16572, class_16572.method_73189(), list, class_23382, this.style(), prz2, this.pyh);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public int walkTo(class_310 class_3102, class_1657 class_16572, class_1937 class_19372, class_243 class_2432, float f, float f2, class_243 class_2433, boolean bl, boolean bl2, WalkModelReader txs2) {
        ++this.pyl;
        if (this.pyj == null || this.pyk == null || this.pyk.method_1025(class_2432) > 0.36 || this.pyl > 60) {
            this.pyj = Route.direct(class_19372, (class_1297)class_16572, class_16572.method_73189(), class_2432);
            this.pyk = class_2432;
            this.pyl = 0;
        }
        if (this.pyj == null) {
            return 1;
        }
        int n = this.follow(class_3102, class_16572, class_19372, this.pyj, f, f2, class_2433, bl, bl2, txs2);
        if (n == 2) {
            this.pyj = null;
        }
        return n;
    }

    public int follow(class_310 class_3102, class_1657 class_16572, class_1937 class_19372, Route psf2, float f, float f2, class_243 class_2432, boolean bl, boolean bl2, WalkModelReader txs2) {
        Object object;
        boolean bl3;
        int n = this.stride.track(class_16572, psf2);
        this.pym = psf2;
        this.pyn = this.stride.at();
        if (psf2.id != this.pyy) {
            this.pyy = psf2.id;
            this.pyu = this.stride.progress();
            this.pyv = 0;
            this.pyw = 0;
            this.pyx = 0;
        }
        if (n != 0 || bl2) {
            return n;
        }
        this.pys = true;
        boolean bl4 = bl3 = class_16572.method_7344().method_7586() > 6 && !class_16572.method_6115();
        if (txs2 != null && this.pyt <= 0) {
            if (this.pyi == null || this.pyi.model != txs2) {
                this.pyi = new WalkSpeedModel(txs2);
            }
            object = this.pyi.decide(class_19372, class_16572, psf2.track, this.stride.at(), f, f2, bl3);
            double d = this.stride.progress();
            double d2 = Math.hypot(class_16572.method_23317() - class_16572.field_6014, class_16572.method_23321() - class_16572.field_5969);
            if (d > this.pyu + 0.3) {
                this.pyu = d;
                this.pyv = 0;
            } else if (++this.pyv > 14) {
                this.pyv = 0;
                this.pyt = 40;
            }
            int n2 = this.pyw = d2 < 0.02 ? this.pyw + 1 : 0;
            if (this.pyw >= 5 && psf2.track.length() - d > 1.0) {
                this.pyw = 0;
                this.pyt = 30;
            }
            boolean bl5 = Math.abs(PathProjection.wrap(this.stride.aheadYaw(class_16572, 1.6) - ((double)f + ((tvw)object).dyaw))) > 110.0;
            int n3 = this.pyx = bl5 && !((tvw)object).forward ? this.pyx + 1 : 0;
            if (this.pyx >= 4) {
                this.pyx = 0;
                this.pyt = 25;
            }
            if (this.pyt <= 0 && this.stride.safe(class_16572, class_19372, ((tvw)object).forward, ((tvw)object).back, ((tvw)object).left, ((tvw)object).right, ((tvw)object).sprint, ((tvw)object).jump, (double)f + ((tvw)object).dyaw)) {
                float f3;
                float f4 = ((tvw)object).forward ? 1.0f : (f3 = ((tvw)object).back ? -1.0f : 0.0f);
                float f5 = ((tvw)object).left ? 1.0f : (((tvw)object).right ? -1.0f : 0.0f);
                this.pyr = f3 == 0.0f && f5 == 0.0f ? (double)f : Math.toDegrees(CameraOwner.inputDirection((float)((double)f + ((tvw)object).dyaw), f3, f5));
                boolean bl6 = ((tvw)object).jump || (f3 != 0.0f || f5 != 0.0f) && this.stride.mustJump(class_16572, this.pyr);
                WalkDriver.apply(class_3102, ((tvw)object).forward, ((tvw)object).back, ((tvw)object).left, ((tvw)object).right, bl6, ((tvw)object).sprint);
                this.pyi.jumped(bl6);
                this.pyp = ((tvw)object).dyaw;
                this.pyq = ((tvw)object).dpitch;
                this.pyo = true;
                this.pyz = true;
                return 0;
            }
            if (this.pyt <= 0) {
                this.pyt = 12;
            }
        }
        if (this.pyt > 0) {
            --this.pyt;
        }
        object = this.stride.drive(class_16572, class_19372, f, f2, class_2432, bl, bl3);
        if (!this.stride.safe(class_16572, class_19372, ((pvb)object).forward, ((pvb)object).back, ((pvb)object).left, ((pvb)object).right, ((pvb)object).sprint, ((pvb)object).jump, (double)f + ((pvb)object).dyaw)) {
            object = this.stride.cautious(class_16572, class_19372, f);
        }
        WalkDriver.apply(class_3102, ((pvb)object).forward, ((pvb)object).back, ((pvb)object).left, ((pvb)object).right, ((pvb)object).jump, ((pvb)object).sprint);
        if (this.pyi != null) {
            this.pyi.jumped(((pvb)object).jump);
        }
        this.pyp = ((pvb)object).dyaw;
        this.pyq = ((pvb)object).dpitch;
        this.pyo = true;
        this.pyz = false;
        this.pyr = ((pvb)object).moveYaw;
        return 0;
    }

    public static void apply(class_310 class_3102, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        class_315 class_3152 = class_3102.field_1690;
        if (class_3152 == null) {
            return;
        }
        class_3152.field_1894.method_23481(bl);
        class_3152.field_1881.method_23481(bl2);
        class_3152.field_1913.method_23481(bl3);
        class_3152.field_1849.method_23481(bl4);
        class_3152.field_1903.method_23481(bl5);
        WalkDriver.setSprint(class_3152, bl6);
    }

    public static void setSprint(class_315 class_3152, boolean bl) {
        class_304 class_3042 = class_3152.field_1867;
        if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            if (bl != class_3042.method_1434()) {
                class_3042.method_23481(true);
            }
        } else {
            class_3042.method_23481(bl);
        }
    }

    private static /* synthetic */ int bpt(int n, int n2) {
        return n ^ n2 | 0xB1DE3110;
    }

    private static /* synthetic */ int bpu(int n, int n2) {
        return n + n2 + 918883952;
    }

    private static /* synthetic */ int bpv(int n, int n2) {
        return WalkDriver.bpt(n, n2) ^ 0x77BFC079;
    }
}

