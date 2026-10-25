/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class lln {
    public double pull = 0.5;
    public double slow = 0.35;
    public double vertical = 0.5;
    public double flickFrom = 300.0;
    public double flickTo = 800.0;
    private static final double llo = 0.045;
    private static final double llp = 0.06;
    private static final double llq = 0.1;
    private double llr;
    private double lls;
    private double llt;
    private double llu;
    private double llv;
    private double llw;
    private double llx;
    private double lly;
    private double llz = 0.016666666666666666;
    private double lma;
    private static /* synthetic */ int lmb;
    private static /* synthetic */ long lmc;

    public void reset() {
        this.llr = 0.0;
        this.lma = 0.0;
        this.llt = 0.0;
        this.lls = 0.0;
        this.llv = 0.0;
        this.llu = 0.0;
        this.lly = 0.0;
        this.llx = 0.0;
        this.llw = 0.0;
    }

    public double speed() {
        return this.lma;
    }

    public void frame(double d) {
        if (this.llw > 0.0) {
            this.llr = lln.lmd(this.llr, Math.hypot(this.llu, this.llv) / this.llw, this.llw, 0.045);
            this.lls = lln.lmd(this.lls, this.llx, this.llw, 0.06);
            this.llt = lln.lmd(this.llt, this.lly, this.llw, 0.06);
        }
        this.llv = 0.0;
        this.llu = 0.0;
        this.lly = 0.0;
        this.llx = 0.0;
        this.llw = 0.0;
        if (d >= 0.1) {
            this.llr = 0.0;
            this.llt = 0.0;
            this.lls = 0.0;
        }
        this.llz = lln.clamp(d, 0.001, 0.1);
    }

    public void extra(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double[] dArray) {
        dArray[0] = 0.0;
        dArray[1] = 0.0;
        this.llu = d;
        this.llv = d2;
        this.llw = this.llz;
        double d9 = Math.hypot(d, d2);
        this.lma = Math.max(lln.lmd(this.llr, d9 / this.llz, this.llz, 0.045), 0.7 * d9 / this.llz);
        double d10 = Math.max(0.0, d8) * (1.0 - lln.smooth(this.flickFrom, this.flickTo, this.lma));
        double d11 = lln.clamp(this.vertical, 0.0, 1.0);
        double d12 = d3 + d5;
        double d13 = (d4 + d6) * d11;
        double d14 = 1.0 - lln.smooth(0.0, Math.max(0.2, d7), Math.hypot(d3, d4 * d11));
        double d15 = Math.hypot(d12, d13);
        double d16 = 0.0;
        double d17 = 0.0;
        if (d15 >= 1.0E-9 && d9 >= 1.0E-9) {
            d16 = (d * d12 + d2 * d13) / d15;
            d17 = lln.clamp((d16 / d9 + 0.35) / 1.35, 0.0, 1.0);
        }
        this.llx = this.pull * d10 * d17;
        this.lly = Math.min(0.9, this.slow * d14 * d10);
        if (d9 < 1.0E-9) {
            return;
        }
        double d18 = lln.lmd(this.lls, this.llx, this.llz, 0.06);
        double d19 = lln.lmd(this.llt, this.lly, this.llz, 0.06);
        if (d15 < 1.0E-9) {
            dArray[0] = -d19 * d;
            dArray[1] = -d19 * d2 * d11;
            return;
        }
        double d20 = d12 / d15;
        double d21 = d13 / d15;
        double d22 = lln.clamp(d16, 0.0, d15);
        double d23 = Math.min(d15 - d22, d9 * d18);
        dArray[0] = -d19 * (d - d22 * d20) + d23 * d20;
        dArray[1] = (-d19 * (d2 - d22 * d21) + d23 * d21) * d11;
    }

    private static double lmd(double d, double d2, double d3, double d4) {
        return d + (d2 - d) * (1.0 - Math.exp(-d3 / d4));
    }

    static double smooth(double d, double d2, double d3) {
        double d4 = lln.clamp((d3 - d) / (d2 - d), 0.0, 1.0);
        return d4 * d4 * (3.0 - 2.0 * d4);
    }

    static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private static /* synthetic */ int axi(int n, int n2) {
        return (n ^ n2) + -2002460275;
    }
}

