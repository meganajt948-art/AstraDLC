/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.taf;
import a.AimFeatures;
import a.tch;
import a.AimModel;
import java.util.Random;

public final class AimSimulator {
    private final AimModel taj;
    private final Random tak;
    private final tch tal = new tch();
    private final double[] tam = new double[32];
    private final double[] tan = new double[2];
    private double tao;
    private double tap;
    private double taq;
    private double tar;
    private double tas;
    private double tat;
    private double tau;
    private double tav;
    private double taw;
    private double tax;
    private int tay = -1;
    private double taz = 1.0;
    private double tba;
    private double tbb;
    private static /* synthetic */ int tbc;
    private static /* synthetic */ boolean tbd;

    public AimSimulator(AimModel tck2, Random random) {
        this.taj = tck2;
        this.tak = random;
    }

    public AimModel model() {
        return this.taj;
    }

    public void reset() {
        this.tav = 0.0;
        this.tau = 0.0;
        this.tat = 0.0;
        this.tas = 0.0;
        this.tar = 0.0;
        this.taq = 0.0;
        this.tap = 0.0;
        this.tao = 0.0;
        this.tax = 0.0;
        this.taw = 0.0;
        this.tay = -1;
        this.tbb = 0.0;
        this.tba = 0.0;
    }

    public void settle() {
        this.tax = 0.0;
        this.taw = 0.0;
    }

    public void prime(double d, double d2) {
        this.taw = d;
        this.tax = d2;
    }

    public void history(double d, double d2) {
        this.tau = this.tas;
        this.tav = this.tat;
        this.tas = this.taq;
        this.tat = this.tar;
        this.taq = this.tao;
        this.tar = this.tap;
        this.tao = d;
        this.tap = d2;
    }

    public double lastX() {
        return this.tao;
    }

    public double lastY() {
        return this.tap;
    }

    public void step(double[] dArray, taf taf2, double[] dArray2) {
        this.step(dArray, taf2, dArray2, false);
    }

    public void step(double[] dArray, taf taf2, double[] dArray2, boolean bl) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        System.arraycopy(dArray, 0, this.tam, 0, 32);
        this.tam[14] = this.tao;
        this.tam[15] = this.tap;
        this.tam[16] = this.taq;
        this.tam[17] = this.tar;
        this.tam[18] = this.tas;
        this.tam[19] = this.tat;
        this.tam[20] = this.tau;
        this.tam[21] = this.tav;
        double d10 = this.taw;
        double d11 = this.tax;
        if (bl) {
            AimFeatures.swapAxes(this.tam);
            d10 = this.tax;
            d11 = this.taw;
        }
        this.taj.predict(this.tam, this.tan, this.tal);
        double d12 = this.tam[0];
        double d13 = this.tam[1];
        double d14 = Math.hypot(d12, d13);
        int n = AimModel.bin(d14);
        double d15 = this.tan[0] * taf2.speed;
        double d16 = this.tan[1] * taf2.speed;
        if (taf2.texture > 0.0 && this.taj.resX.length > 0) {
            this.tbe(n);
            d9 = (double)this.taj.texCap * Math.hypot(d15, d16) + (double)this.taj.texFloor;
            d8 = this.tba * taf2.texture * (double)(bl ? this.taj.texY : this.taj.texX);
            d7 = this.tbb * taf2.texture * (double)(bl ? this.taj.texX : this.taj.texY);
            d6 = Math.hypot(d8, d7);
            if (d6 > d9) {
                d8 *= d9 / d6;
                d7 *= d9 / d6;
            }
            d15 += d8;
            d16 += d7;
        }
        if (bl) {
            d15 *= taf2.vertical;
        } else {
            d16 *= taf2.vertical;
        }
        d9 = Math.max(1.0, taf2.speed);
        d8 = Math.hypot(this.tam[6], this.tam[7]);
        d7 = this.taj.speedCap[n] * d9 * 1.05 + d8 * 1.2;
        d6 = Math.hypot(d15, d16);
        if (taf2.envelope && d6 > d7 && d6 > 1.0E-9) {
            d15 *= d7 / d6;
            d16 *= d7 / d6;
        }
        double d17 = d15 - d10;
        double d18 = d16 - d11;
        double d19 = Math.hypot(d17, d18);
        double d20 = this.taj.accelCap[n] * d9 * 1.1 + d8 * 0.5;
        if (taf2.envelope && d19 > d20 && d19 > 1.0E-9) {
            d15 = d10 + d17 * d20 / d19;
            d16 = d11 + d18 * d20 / d19;
        }
        double d21 = d12 + this.tam[6] * taf2.lead;
        double d22 = d13 + this.tam[7] * taf2.lead;
        double d23 = Math.hypot(d21, d22);
        if (taf2.guard && d23 > 1.0E-6 && (d5 = d15 * (d4 = d21 / d23) + d16 * (d3 = d22 / d23)) > (d2 = d23 + (d = 0.18 * (this.tam[22] * Math.abs(d4) + 0.5 * this.tam[23] * Math.abs(d3)) + 0.02))) {
            d15 -= d4 * (d5 - d2);
            d16 -= d3 * (d5 - d2);
        }
        dArray2[0] = bl ? d16 : d15;
        dArray2[1] = bl ? d15 : d16;
        this.taw = dArray2[0];
        this.tax = dArray2[1];
    }

    private void tbe(int n) {
        boolean bl;
        boolean bl2 = bl = this.tay < 0 || this.tay + 1 >= this.taj.resX.length || !this.taj.resLink[this.tay] || Math.abs(this.taj.resBin[this.tay + 1] - n) > 1;
        if (bl) {
            int[] nArray = this.taj.residualsIn(n);
            if (nArray.length == 0) {
                this.tbb = 0.0;
                this.tba = 0.0;
                return;
            }
            this.tay = nArray[this.tak.nextInt(nArray.length)];
            this.taz = this.taj.mirror && this.tak.nextBoolean() ? -1.0 : 1.0;
        } else {
            ++this.tay;
        }
        this.tba = (double)this.taj.resX[this.tay] * this.taz;
        this.tbb = this.taj.resY[this.tay];
    }

    private static /* synthetic */ int cjh(int n, int n2) {
        return n - n2 + -884948305;
    }

    private static /* synthetic */ int cji(int n, int n2) {
        return AimSimulator.cjh(n, n2) ^ 0xBD4C79B2;
    }

    private static /* synthetic */ int cjj(int n, int n2) {
        return n ^ n2 | 0x8A90FDC;
    }
}

