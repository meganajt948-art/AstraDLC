/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package a;

import a.lex;
import a.AutoMine;
import a.pjt;
import a.AimModel;
import a.AimBrain;
import java.util.Random;
import net.minecraft.class_310;
import net.minecraft.class_3532;

public final class AimPersonalizer {
    private static final double pjx = 10.0;
    private static final double pjy = 0.45;
    private static final double pjz = 0.55;
    private static final double pka = 0.5;
    private static final double pkb = 1.6;
    private static final double pkc = 2.4;
    private static final double pkd = 8.0;
    private static final double pke = 40.0;
    private static final double pkf = 1.2;
    private static final double pkg = 45.0;
    private static final int pkh = 2;
    private final Random pki = new Random();
    private final AimBrain pkj = new AimBrain();
    private final double[] pkk = new double[2];
    private lex pkl;
    private double pkm = 1.0;
    private double pkn = 1.0;
    private double pko = 2.0;
    private double pkp = 6.5;
    private double pkq = 0.65;
    private double pkr;
    private double pks;
    private boolean pkt;
    private double pku = 0.15;
    private boolean pkv;
    private double pkw;
    private double pkx;
    private Object pky = new Object();
    private Object pkz;
    private double pla;
    private double plb;
    private double plc;
    private double pld;
    private boolean ple;
    private double plf;
    private double plg;
    private double plh;
    private int pli;
    private int plj = 120;
    private boolean plk;
    private double pll;
    private double plm;
    private double pln;
    private double plo;
    private int plp;
    private int plq = 40;
    private static /* synthetic */ long plr;
    private static /* synthetic */ boolean pls;

    public AimPersonalizer neuro(lex lex2) {
        this.pkl = lex2;
        return this;
    }

    public void personalize(long l) {
        Random random = new Random(l ^ 0x5DEECE66DL ^ 0x2545F4914F6CDD1DL);
        this.pkm = 0.85 + random.nextDouble() * 0.3;
        this.pkn = 0.8 + random.nextDouble() * 0.4;
        this.pko = 1.5 + random.nextDouble() * 1.3;
        this.pkp = 4.5 + random.nextDouble() * 4.0;
        this.pkq = 0.5 + random.nextDouble() * 0.35;
    }

    public void setMouseStep(double d) {
        if (d > 0.0 && Double.isFinite(d)) {
            this.pku = d;
        }
    }

    public void reset(float f, float f2) {
        this.pkr = f;
        this.pks = f2;
        this.pkt = true;
        this.pkv = false;
        this.pkw = 0.0;
        this.pkx = 0.0;
        this.pky = new Object();
        this.pkz = null;
        this.pkj.reset();
        this.ple = false;
        this.pla = f;
        this.plb = f2;
        this.plk = false;
        this.plf = 0.0;
        this.plg = 0.0;
        this.pli = 0;
        this.plp = 0;
    }

    public boolean isPrimed() {
        return this.pkt;
    }

    public void aimTight(float f, float f2) {
        this.plt(f, f2, pjt.TIGHT, 0.0);
    }

    public void aim(float f, float f2) {
        this.plt(f, f2, pjt.PRECISE, 0.45);
    }

    public void aim(float f, float f2, double d) {
        this.plt(f, f2, pjt.PRECISE, d > 0.0 ? d : 0.45);
    }

    public void aimRelaxed(float f, float f2) {
        this.plt(f, f2, pjt.RELAXED, 0.0);
    }

    private void plt(float f, float f2, pjt pjt2, double d) {
        f2 = class_3532.method_15363((float)f2, (float)-89.0f, (float)89.0f);
        this.plk = false;
        if (!this.pkt) {
            this.reset(f, f2);
            return;
        }
        double d2 = f;
        double d3 = f2;
        if (pjt2 == pjt.PRECISE) {
            this.plf *= 0.7;
            this.plg *= 0.7;
            this.pli = 0;
        } else {
            this.plu();
            if (pjt2 == pjt.TIGHT) {
                this.plf *= 0.6;
            } else {
                d2 += this.plf;
            }
            d3 = class_3532.method_15350((double)((double)f2 + this.plg + this.plv()), (double)-78.0, (double)78.0);
        }
        this.plw(d2, d3, pjt2, d);
    }

    public void freeze() {
        if (!this.pkt) {
            return;
        }
        this.pkj.idle((float)this.pkr, (float)this.pks);
        this.pkv = false;
    }

    public void turn(double d, double d2) {
        if (!this.pkt) {
            return;
        }
        this.plk = false;
        this.pkw += d / this.pku;
        this.pkx += d2 / this.pku;
        long l = Math.round(this.pkw);
        long l2 = Math.round(this.pkx);
        this.pkw -= (double)l;
        this.pkx -= (double)l2;
        double d3 = (double)l * this.pku;
        double d4 = class_3532.method_15350((double)(this.pks + (double)l2 * this.pku), (double)-90.0, (double)90.0);
        this.pkr += d3;
        this.pks = d4;
        this.pla = this.pkr;
        this.plb = this.pks;
        this.plc = this.pkr;
        this.pld = this.pks;
        this.ple = false;
        this.pky = new Object();
        this.pkj.idle((float)this.pkr, (float)this.pks);
        this.pkv = l != 0L || l2 != 0L;
    }

    public void hold() {
        if (!this.pkt) {
            return;
        }
        this.plk = false;
        this.plw(this.pkr, this.pks, pjt.HOLD, 0.0);
    }

    public void idle() {
        if (!this.pkt) {
            return;
        }
        if (!this.plk) {
            this.plk = true;
            this.pll = this.pkr;
            this.plm = this.pks;
            this.pln = 0.0;
            this.plo = 0.0;
            this.plp = 0;
            this.plq = 20 + this.pki.nextInt(80);
        }
        if (this.plp > 0) {
            if (--this.plp == 0) {
                this.pln = this.pki.nextGaussian() * 5.0;
                this.plo = this.pki.nextGaussian() * 2.0;
            }
        } else if (this.plq > 0) {
            --this.plq;
        } else {
            this.plp = 8 + this.pki.nextInt(34);
            this.plq = 25 + this.pki.nextInt(110);
            this.pln = this.pki.nextGaussian() * 8.0;
            this.plo = this.pki.nextGaussian() * 3.0;
        }
        double d = this.pll + this.pln;
        double d2 = class_3532.method_15350((double)(this.plm + this.plo), (double)-70.0, (double)70.0);
        this.plw(d, d2, pjt.IDLE, 0.0);
    }

    private void plu() {
        this.plf = class_3532.method_15350((double)(this.plf * 0.992 + this.pki.nextGaussian() * 0.025), (double)-0.6, (double)0.6);
        this.plg = class_3532.method_15350((double)(this.plg * 0.99 + this.pki.nextGaussian() * 0.06), (double)-1.5, (double)1.5);
        if (this.pli > 0) {
            --this.pli;
        } else if (this.plj > 0) {
            --this.plj;
        } else {
            this.pli = 10 + this.pki.nextInt(26);
            this.plj = 160 + this.pki.nextInt(420);
            this.plh = this.pki.nextGaussian() * 1.5;
        }
    }

    private double plv() {
        return this.pli > 0 ? this.plh : 0.0;
    }

    private void plw(double d, double d2, pjt pjt2, double d3) {
        boolean bl;
        double d4;
        double d5;
        double d6;
        this.pla = d;
        this.plb = d2;
        if (this.ple && Math.hypot(class_3532.method_15338((double)(d - this.plc)), d2 - this.pld) > 18.0) {
            this.pky = new Object();
        }
        this.ple = true;
        this.plc = d;
        this.pld = d2;
        if (pjt2 == pjt.HOLD) {
            this.pkj.idle((float)this.pkr, (float)this.pks);
            this.pkv = false;
            return;
        }
        double d7 = class_3532.method_15338((double)(d - this.pkr));
        double d8 = d2 - this.pks;
        switch (pjt2.ordinal()) {
            case 2: {
                d5 = d6 = Math.max(0.5, d3 / 0.55);
                d4 = d6 * 2.0;
                bl = Math.hypot(d7, d8) <= d3;
                break;
            }
            case 1: {
                d5 = this.pkq;
                d4 = this.pkp * 2.0;
                bl = Math.abs(d7) <= this.pkq * 0.5 && Math.abs(d8) <= this.pkp * 0.5;
                break;
            }
            case 3: {
                d5 = 1.6;
                d4 = 4.8;
                bl = Math.abs(d7) <= 0.8 && Math.abs(d8) <= 1.2;
                break;
            }
            default: {
                d5 = this.pko;
                d4 = this.pkp * 2.0;
                boolean bl2 = bl = Math.abs(d7) <= this.pko * 0.5 && Math.abs(d8) <= this.pkp * 0.5;
            }
        }
        if (bl) {
            this.pkj.idle((float)this.pkr, (float)this.pks);
            this.pkv = false;
            return;
        }
        d6 = pjt2 == pjt.IDLE ? 0.0 : AimPersonalizer.plx((Math.hypot(d7, d8) - 8.0) / 32.0);
        AimModel tck2 = this.pkl == null ? null : AutoMine.model(this.pkl);
        this.pkj.use(tck2 != null ? tck2 : AimModel.profile1());
        this.pkj.tune((tck2 != null ? 1.0 : this.pkm) * (1.0 + 1.2 * d6), tck2 != null ? 1.0 : this.pkn, 1.0);
        class_310 class_3102 = class_310.method_1551();
        int n = this.pky == this.pkz ? 0 : 2;
        this.pkz = this.pky;
        if (!this.pkj.steerTo(class_3102.field_1724, this.pky, this.pkr + d7, d2, d5, d4, n, (float)this.pkr, (float)this.pks, this.pkk)) {
            this.pkv = false;
            return;
        }
        double d9 = this.pkk[0];
        double d10 = this.pkk[1];
        double d11 = Math.hypot(d9, d10);
        if (d11 > 45.0) {
            d9 *= 45.0 / d11;
            d10 *= 45.0 / d11;
        }
        this.pkw += d9 / this.pku;
        this.pkx += d10 / this.pku;
        long l = Math.round(this.pkw);
        long l2 = Math.round(this.pkx);
        this.pkw -= (double)l;
        this.pkx -= (double)l2;
        double d12 = (double)l * this.pku;
        double d13 = class_3532.method_15350((double)(this.pks + (double)l2 * this.pku), (double)-90.0, (double)90.0);
        double d14 = d13 - this.pks;
        this.pkr += d12;
        this.pks = d13;
        this.pkj.turned(d12, d14);
        this.pkv = l != 0L || l2 != 0L;
    }

    private static double plx(double d) {
        d = class_3532.method_15350((double)d, (double)0.0, (double)1.0);
        return d * d * (3.0 - 2.0 * d);
    }

    public float intentYaw() {
        return (float)this.pkr;
    }

    public float intentPitch() {
        return (float)this.pks;
    }

    public float getYaw() {
        return (float)this.pkr;
    }

    public float getPitch() {
        return (float)class_3532.method_15350((double)this.pks, (double)-90.0, (double)90.0);
    }

    public boolean isMoving() {
        return this.pkv;
    }

    public double error() {
        return this.pkt ? Math.hypot(class_3532.method_15338((double)(this.pla - this.pkr)), this.plb - this.pks) : 0.0;
    }

    public boolean isOn(double d) {
        return this.error() <= d;
    }

    private static /* synthetic */ int bkp(int n, int n2) {
        return n * n2 ^ 0x6C8848DE;
    }

    private static /* synthetic */ int bkq(int n, int n2) {
        return n + n2 ^ 0x7671CEED;
    }
}

