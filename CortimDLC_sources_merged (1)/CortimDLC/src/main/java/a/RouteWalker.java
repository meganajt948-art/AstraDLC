/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 */
package a;

import a.psc;
import a.Route;
import a.StandCheck;
import a.CameraOwner;
import a.pvb;
import a.pxa;
import a.MoveSolver;
import a.PathProjection;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_243;

public final class RouteWalker {
    public static final int WALK = 0;
    public static final int DONE = 1;
    public static final int OFF = 2;
    private static final float[][] pvf = new float[][]{{1.0f, 0.0f}, {1.0f, 1.0f}, {1.0f, -1.0f}, {0.0f, 1.0f}, {0.0f, -1.0f}, {-1.0f, 0.0f}, {-1.0f, 1.0f}, {-1.0f, -1.0f}};
    private static final double[] pvg = new double[]{0.0, 6.0, 6.0, 22.0, 22.0, 40.0, 44.0, 44.0};
    private final Random pvh = new Random();
    private double pvi = 1.0;
    private double pvj = 0.13;
    private double pvk = 0.5;
    private double pvl = 30.0;
    private double pvm = 14.0;
    private double pvn = 0.4;
    private boolean pvo = true;
    private psc pvp = new psc();
    private Route pvq;
    private int pvr;
    private double pvs;
    private int pvt;
    private int pvu;
    private long pvv;
    private double pvw;
    private double pvx;
    private double pvy;
    private double pvz;
    private int pwa = -1;
    private int pwb;
    private int pwc;
    private int pwd = 240;
    private double pwe;
    private int pwf;
    private int pwg = 40;
    private int pwh;
    private int pwi = 1;
    private int pwj;
    private boolean pwk = true;
    private final pvb pwl = new pvb();
    private final double[] pwm = new double[3];
    private final double[] pwn = new double[1];
    private static /* synthetic */ long pwo;
    private static /* synthetic */ long pwp;

    public void personalize(long l) {
        Random random = new Random(l ^ 0x3C6EF372FE94F82BL);
        this.pvi = 0.85 + random.nextDouble() * 0.35;
        this.pvj = 0.1 + random.nextDouble() * 0.07;
        this.pvk = 0.44 + random.nextDouble() * 0.16;
        this.pvl = 24.0 + random.nextDouble() * 16.0;
        this.pvm = 8.0 + random.nextDouble() * 14.0;
        this.pvn = random.nextDouble() < 0.3 ? 0.0 : 0.2 + random.nextDouble() * 0.7;
        this.pvo = random.nextDouble() < 0.6;
        this.pvp = psc.of(l);
    }

    public psc routeStyle() {
        return this.pvp;
    }

    public void reset() {
        this.pvq = null;
        this.pvr = 0;
        this.pvs = 0.0;
        this.pvt = 0;
        this.pvw = 0.0;
        this.pvx = 0.0;
        this.pwa = -1;
        this.pwf = 0;
        this.pwh = 0;
        this.pwj = 0;
        this.pwb = 0;
    }

    public Route route() {
        return this.pvq;
    }

    public int at() {
        return this.pvr;
    }

    public double progress() {
        return this.pvs;
    }

    public int track(class_1657 class_16572, Route psf2) {
        boolean bl;
        PathProjection tvt2 = psf2.track;
        double d = class_16572.method_23317();
        double d2 = class_16572.method_23318();
        double d3 = class_16572.method_23321();
        if (psf2 != this.pvq) {
            this.pvq = psf2;
            this.pvr = tvt2.closest(d, d2, d3, 0, 0, tvt2.n);
            this.pvt = 0;
        } else {
            this.pvr = tvt2.closest(d, d2, d3, this.pvr, 6, 56);
        }
        this.pvs = tvt2.project(d, d3, this.pvr);
        double d4 = tvt2.offset(d, d3, this.pvs);
        double d5 = d2 - (double)tvt2.y[this.pvr];
        boolean bl2 = bl = class_16572.method_24828() || class_16572.method_5799();
        if (bl && (d4 > 2.2 || d5 < -1.9 || d5 > 2.6)) {
            ++this.pvt;
        } else if (d4 < 1.6 && d5 > -1.6) {
            this.pvt = 0;
        }
        if (this.pvt > 3) {
            return 2;
        }
        double d6 = tvt2.length() - this.pvs;
        double d7 = Math.hypot(d - class_16572.field_6014, d3 - class_16572.field_5969);
        int n = this.pvu = d7 < 0.02 ? this.pvu + 1 : 0;
        if (bl && Math.abs(d5) < 1.2 && (d6 < 0.32 || d6 < 1.3 && this.pvu >= 3)) {
            return 1;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public pvb drive(class_1657 class_16572, class_1937 class_19372, float f, float f2, class_243 class_2432, boolean bl, boolean bl2) {
        boolean bl3;
        double d;
        pvb pvb2;
        boolean bl4;
        boolean bl5;
        double d2;
        PathProjection tvt2;
        block21: {
            block22: {
                boolean bl6;
                boolean bl7;
                double d3;
                double d4;
                block23: {
                    block20: {
                        boolean bl8;
                        double d5;
                        double d6;
                        double d7;
                        long l = System.currentTimeMillis();
                        if (l - this.pvv > 160L) {
                            this.pvw = 0.0;
                            this.pvx = 0.0;
                            this.pwa = -1;
                            this.pwf = 0;
                            this.pwj = 0;
                        }
                        this.pvv = l;
                        tvt2 = this.pvq.track;
                        double d8 = class_16572.method_23317();
                        d2 = class_16572.method_23318();
                        double d9 = class_16572.method_23321();
                        double d10 = d8 - class_16572.field_6014;
                        double d11 = d9 - class_16572.field_5969;
                        double d12 = Math.hypot(d10, d11);
                        bl5 = class_16572.method_24828();
                        bl4 = class_16572.method_5799();
                        d4 = tvt2.length() - this.pvs;
                        double d13 = RouteWalker.pww(1.05 + 5.0 * d12, 1.25, 2.7) * this.pvi;
                        tvt2.at(this.pvs + d13, this.pwm);
                        for (int i = 0; i < 3 && d13 > 0.7 && !RouteWalker.pws(class_19372, class_16572, d8, d2, d9, this.pwm); ++i) {
                            tvt2.at(this.pvs + (d13 *= 0.6), this.pwm);
                        }
                        double d14 = this.pwm[0] - d8;
                        double d15 = this.pwm[2] - d9;
                        d3 = Math.hypot(d14, d15) > 0.15 ? PathProjection.yawOf(d14, d15) : tvt2.heading(this.pvs);
                        double d16 = this.pvs + d13 + 1.3 + 3.0 * d12;
                        tvt2.at(d16, this.pwm);
                        double d17 = this.pwm[0] - d8;
                        double d18 = this.pwm[2] - d9;
                        double d19 = Math.hypot(d17, d18) > 0.3 ? PathProjection.yawOf(d17, d18) : d3;
                        double d20 = d3 + RouteWalker.pwv(PathProjection.wrap(d19 - d3) * 0.45, 24.0);
                        class_243 class_2433 = class_16572.method_33571();
                        if (class_2432 != null) {
                            d7 = class_2432.field_1352 - class_2433.field_1352;
                            d6 = class_2432.field_1351 - class_2433.field_1351;
                            d5 = class_2432.field_1350 - class_2433.field_1350;
                            d20 = PathProjection.yawOf(d7, d5);
                            var46_34 = -Math.toDegrees(Math.atan2(d6, Math.max(0.2, Math.hypot(d7, d5))));
                            this.pwb = 0;
                        } else {
                            tvt2.at(this.pvs + 3.2 + 5.5 * d12, this.pwm);
                            d7 = Math.max(1.5, Math.hypot(this.pwm[0] - d8, this.pwm[2] - d9));
                            d6 = Math.toDegrees(Math.atan2(class_2433.field_1351 - this.pwm[1], d7));
                            var46_34 = RouteWalker.pww(0.55 * this.pvm + 0.45 * d6, -12.0, 50.0);
                            this.pwq(tvt2, d4, bl);
                            if (this.pwb > 0) {
                                int n = this.pwc - this.pwb;
                                double d21 = Math.min(1.0, Math.min((double)n / 4.0, (double)this.pwb / 4.0));
                                d20 += this.pwe * d21;
                                --this.pwb;
                            }
                        }
                        this.pvy = this.pvy * 0.965 + this.pvh.nextGaussian() * 0.42;
                        this.pvz = this.pvz * 0.985 + this.pvh.nextGaussian() * 0.18;
                        d7 = PathProjection.wrap((d20 += this.pvy) - (double)f);
                        d6 = RouteWalker.pwv(this.pvj * d7 - this.pvk * this.pvw, 4.0 + 0.3 * Math.abs(d7));
                        this.pvw = RouteWalker.pwv(this.pvw + d6, this.pvl);
                        d5 = this.pvw + this.pvh.nextGaussian() * (0.03 * Math.abs(this.pvw) + 0.02);
                        double d22 = (var46_34 += this.pvz) - (double)f2;
                        double d23 = RouteWalker.pwv(0.08 * d22 - 0.5 * this.pvx, 2.5);
                        double d24 = this.pvx = RouteWalker.pwv(this.pvx + d23, 9.0);
                        double d25 = (double)f + d5;
                        pvb2 = this.pwl;
                        pvb2.forward = false;
                        pvb2.back = false;
                        pvb2.left = false;
                        pvb2.right = false;
                        pvb2.jump = false;
                        pvb2.sprint = false;
                        pvb2.dyaw = d5;
                        pvb2.dpitch = d24;
                        pvb2.moveYaw = d3;
                        double d26 = 1.25 * d12 + 0.1;
                        double d27 = Math.abs(PathProjection.wrap(d3 - d25));
                        boolean bl9 = bl8 = !bl && d27 > 120.0 && class_2432 == null;
                        if (d4 < d26 || bl8) {
                            this.pwa = -1;
                            this.pwk = bl5;
                            return pvb2;
                        }
                        int n = 0;
                        double d28 = Double.MAX_VALUE;
                        for (int i = 0; i < pvf.length; ++i) {
                            double d29 = RouteWalker.pwu(i, d25, d3) + (bl ? pvg[i] * 0.5 : pvg[i]);
                            if (!(d29 < d28)) continue;
                            d28 = d29;
                            n = i;
                        }
                        if (this.pwa >= 0 && RouteWalker.pwu(this.pwa, d25, d3) + pvg[this.pwa] <= d28 + 12.0) {
                            n = this.pwa;
                        }
                        double d30 = (d = tvt2.next(this.pvs, 2.5, (byte)2, d2, this.pwn)) >= 0.0 ? this.pwn[0] : 0.0;
                        bl7 = class_16572.field_5976;
                        int n2 = this.pwh = bl7 && bl5 ? this.pwh + 1 : 0;
                        if (this.pwh >= 3 && pvf[n][0] > 0.0f) {
                            int n3 = RouteWalker.pwt(class_19372, class_16572, d3);
                            if (n3 != 0) {
                                this.pwi = n3;
                            } else if (this.pwh % 14 == 0) {
                                this.pwi = -this.pwi;
                            }
                            n = this.pwi > 0 ? 1 : 2;
                        }
                        this.pwa = n;
                        float f3 = pvf[n][0];
                        float f4 = pvf[n][1];
                        pvb2.forward = f3 > 0.0f;
                        pvb2.back = f3 < 0.0f;
                        pvb2.left = f4 > 0.0f;
                        pvb2.right = f4 < 0.0f;
                        bl6 = class_16572.method_5624();
                        pvb2.sprint = bl2 && pvb2.forward && !bl4 && (bl || d4 > 1.4 + 5.0 * d12) && d30 <= 2.0;
                        bl3 = false;
                        if (!bl4) break block20;
                        tvt2.at(this.pvs + 1.0, this.pwm);
                        bl3 = this.pwm[1] >= d2 - 0.2 || bl7;
                        break block21;
                    }
                    if (!bl5) break block22;
                    double d31 = tvt2.next(this.pvs, 2.2, (byte)1, d2, this.pwn);
                    if (!(d31 >= 0.0)) break block23;
                    double d32 = bl6 ? 0.3 : 0.15;
                    if (!(d31 < 0.95 + d32)) break block23;
                    bl3 = true;
                    break block21;
                }
                if (bl7 && this.pwh >= 1 && MoveSolver.jumpHelps(class_16572, (float)d3, bl6, 3)) {
                    bl3 = true;
                    break block21;
                } else if (this.pwr(class_16572, tvt2, d4, bl, bl2 && bl6, d, d3)) {
                    bl3 = true;
                }
                break block21;
            }
            if (this.pwf > 0 && this.pvo) {
                bl3 = true;
            }
        }
        if (bl3 && bl5) {
            this.pwj = 1 + this.pvh.nextInt(3);
        }
        if (this.pwj > 0) {
            --this.pwj;
            bl3 = true;
        }
        if (d >= 0.0 && d < 1.2 && tvt2.next(this.pvs, 1.6, (byte)1, d2, this.pwn) < 0.0 && !bl4) {
            bl3 = false;
            this.pwj = 0;
        }
        if (bl5 && !this.pwk && this.pwf > 0) {
            --this.pwf;
        }
        this.pwk = bl5;
        pvb2.jump = bl3;
        return pvb2;
    }

    public double aheadYaw(class_1657 class_16572, double d) {
        if (this.pvq == null) {
            return class_16572.method_36454();
        }
        this.pvq.track.at(this.pvs + d, this.pwm);
        double d2 = this.pwm[0] - class_16572.method_23317();
        double d3 = this.pwm[2] - class_16572.method_23321();
        return Math.hypot(d2, d3) < 0.1 ? this.pvq.track.heading(this.pvs) : PathProjection.yawOf(d2, d3);
    }

    public boolean mustJump(class_1657 class_16572, double d) {
        if (this.pvq == null || !class_16572.method_24828() || class_16572.method_5799()) {
            return false;
        }
        boolean bl = class_16572.method_5624();
        double d2 = this.pvq.track.next(this.pvs, 2.2, (byte)1, class_16572.method_23318(), this.pwn);
        if (d2 >= 0.0) {
            double d3 = bl ? 0.3 : 0.15;
            if (d2 < 0.95 + d3) {
                return true;
            }
        }
        return class_16572.field_5976 && MoveSolver.jumpHelps(class_16572, (float)d, bl, 3);
    }

    public boolean safe(class_1657 class_16572, class_1937 class_19372, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, double d) {
        return this.safe(class_16572, class_19372, bl, bl2, bl3, bl4, bl5, bl6, d, 6);
    }

    public boolean safe(class_1657 class_16572, class_1937 class_19372, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, double d, int n) {
        float f;
        if (this.pvq == null || !bl && !bl2 && !bl3 && !bl4) {
            return true;
        }
        float f2 = bl ? 1.0f : (f = bl2 ? -1.0f : 0.0f);
        float f3 = bl3 ? 1.0f : (bl4 ? -1.0f : 0.0f);
        double d2 = Math.toDegrees(CameraOwner.inputDirection((float)d, f, f3));
        pxa pxa2 = MoveSolver.run(class_16572, (float)d2, bl5 && bl, bl6 && class_16572.method_24828(), n);
        PathProjection tvt2 = this.pvq.track;
        double d3 = pxa2.endX;
        double d4 = pxa2.endZ;
        int n2 = tvt2.closest(d3, pxa2.endY, d4, this.pvr, 4, 40);
        double d5 = tvt2.project(d3, d4, n2);
        if (tvt2.offset(d3, d4, d5) > 2.4) {
            return false;
        }
        double d6 = Math.min(tvt2.y[n2], tvt2.y[Math.max(0, n2 - 2)]);
        if (pxa2.minY < d6 - 0.9 && pxa2.minY < class_16572.method_23318() - 0.9) {
            return false;
        }
        return !StandCheck.hazard(class_19372, d3, pxa2.endY, d4);
    }

    private void pwq(PathProjection tvt2, double d, boolean bl) {
        if (this.pwb > 0) {
            return;
        }
        if (this.pwd > 0) {
            --this.pwd;
            return;
        }
        this.pwd = 260 + this.pvh.nextInt(900);
        if (bl || d < 10.0 || tvt2.bend(this.pvs, 6.0) > 20.0 || this.pwf > 0 || this.pvh.nextDouble() < 0.4) {
            return;
        }
        this.pwb = this.pwc = 10 + this.pvh.nextInt(18);
        this.pwe = (this.pvh.nextBoolean() ? 1.0 : -1.0) * (16.0 + this.pvh.nextDouble() * 34.0);
    }

    private boolean pwr(class_1657 class_16572, PathProjection tvt2, double d, boolean bl, boolean bl2, double d2, double d3) {
        boolean bl3;
        double d4;
        double d5 = d4 = bl ? Math.max(0.75, this.pvn) : this.pvn;
        if (!bl2 || d4 <= 0.0 || class_16572.method_7344().method_7586() < 14) {
            this.pwf = 0;
            return false;
        }
        boolean bl4 = bl3 = d > 6.0 && tvt2.flatAhead(this.pvs, 6.0, class_16572.method_23318()) >= 5.5 && tvt2.bend(this.pvs, 6.0) < 14.0 && (d2 < 0.0 || d2 > 5.0);
        if (!bl3) {
            this.pwf = 0;
            return false;
        }
        if (this.pwf <= 0) {
            if (this.pwg > 0) {
                --this.pwg;
                return false;
            }
            this.pwg = 15 + this.pvh.nextInt(40);
            if (this.pvh.nextDouble() > d4) {
                return false;
            }
            this.pwf = 2 + this.pvh.nextInt(bl ? 10 : 6);
        }
        pxa pxa2 = MoveSolver.run(class_16572, (float)d3, true, true, 12);
        if (pxa2.firstBlockTick >= 0) {
            this.pwf = 0;
            return false;
        }
        return true;
    }

    private static boolean pws(class_1937 class_19372, class_1657 class_16572, double d, double d2, double d3, double[] dArray) {
        double d4 = dArray[0] - d;
        double d5 = dArray[2] - d3;
        double d6 = Math.hypot(d4, d5);
        int n = Math.max(1, (int)Math.ceil(d6 / 0.3));
        double d7 = d2;
        for (int i = 1; i <= n; ++i) {
            double d8 = (double)i / (double)n;
            double d9 = d + d4 * d8;
            double d10 = d3 + d5 * d8;
            double d11 = StandCheck.standAt(class_19372, d9, Math.max(d7, d2 + (dArray[1] - d2) * d8), d10, 1.25);
            if (Double.isNaN(d11) || StandCheck.hazard(class_19372, d9, d11, d10)) {
                return false;
            }
            d7 = d11;
        }
        return true;
    }

    public pvb cautious(class_1657 class_16572, class_1937 class_19372, float f) {
        boolean bl;
        boolean bl2;
        PathProjection tvt2 = this.pvq.track;
        tvt2.at(this.pvs + 0.7, this.pwm);
        double d = PathProjection.yawOf(this.pwm[0] - class_16572.method_23317(), this.pwm[2] - class_16572.method_23321());
        pvb pvb2 = this.pwl;
        pvb2.forward = false;
        pvb2.back = false;
        pvb2.left = false;
        pvb2.right = false;
        pvb2.jump = false;
        pvb2.sprint = false;
        pvb2.moveYaw = d;
        boolean bl3 = false;
        double d2 = Double.MAX_VALUE;
        for (bl2 = false; bl2 < 5 != 0; bl2 += 1) {
            double d3 = RouteWalker.pwu(bl2 ? 1 : 0, (double)f + pvb2.dyaw, d);
            if (!(d3 < d2)) continue;
            d2 = d3;
            bl3 = bl2;
        }
        bl2 = pvf[bl3][0] > 0.0f;
        boolean bl4 = pvf[bl3][1] > 0.0f;
        boolean bl5 = bl = pvf[bl3][1] < 0.0f;
        if (this.safe(class_16572, class_19372, bl2, false, bl4, bl, false, false, (double)f + pvb2.dyaw, 3)) {
            pvb2.forward = bl2;
            pvb2.left = bl4;
            pvb2.right = bl;
        }
        this.pwa = -1;
        return pvb2;
    }

    private static int pwt(class_1937 class_19372, class_1657 class_16572, double d) {
        boolean bl;
        double d2;
        double d3;
        double d4 = Math.toRadians(d);
        double d5 = -Math.sin(d4);
        double d6 = Math.cos(d4);
        double d7 = -d6;
        double d8 = d5;
        double d9 = class_16572.method_23317() + d5 * 0.5;
        boolean bl2 = StandCheck.bodyFits(class_19372, (class_1297)class_16572, d9 + d7 * 0.5, (d3 = class_16572.method_23321() + d6 * 0.5) + d8 * 0.5, d2 = class_16572.method_23318(), 0.3) && !Double.isNaN(StandCheck.standAt(class_19372, d9 + d7 * 0.5, d2, d3 + d8 * 0.5, 1.0));
        boolean bl3 = bl = StandCheck.bodyFits(class_19372, (class_1297)class_16572, d9 - d7 * 0.5, d3 - d8 * 0.5, d2, 0.3) && !Double.isNaN(StandCheck.standAt(class_19372, d9 - d7 * 0.5, d2, d3 - d8 * 0.5, 1.0));
        if (bl2 == bl) {
            return 0;
        }
        return bl2 ? -1 : 1;
    }

    private static double pwu(int n, double d, double d2) {
        double d3 = Math.toDegrees(CameraOwner.inputDirection((float)d, pvf[n][0], pvf[n][1]));
        return Math.abs(PathProjection.wrap(d3 - d2));
    }

    private static double pwv(double d, double d2) {
        return d > d2 ? d2 : (d < -d2 ? -d2 : d);
    }

    private static double pww(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private static /* synthetic */ int bpf(int n, int n2) {
        return n + n2 ^ 0xE9AC2BE;
    }
}

