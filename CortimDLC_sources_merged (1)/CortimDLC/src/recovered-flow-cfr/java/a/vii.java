/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.awt.geom.Path2D;

final class vii {
    private final String vij;
    private int vik;
    private static /* synthetic */ boolean vil;
    private static /* synthetic */ String vim;

    private vii(String string) {
        this.vij = string;
    }

    static Path2D.Float parse(String string) {
        return new vii(string).vin();
    }

    private Path2D.Float vin() {
        Path2D.Float float_ = new Path2D.Float();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int n = 32;
        int n2 = 32;
        while (true) {
            this.vio();
            if (this.vik >= this.vij.length()) break;
            char c = this.vij.charAt(this.vik);
            if (Character.isLetter(c)) {
                n2 = c;
                ++this.vik;
            } else if (n2 == 77) {
                n2 = 76;
            } else if (n2 == 109) {
                n2 = 108;
            }
            boolean bl = Character.isLowerCase((char)n2);
            float f7 = bl ? f : 0.0f;
            float f8 = bl ? f2 : 0.0f;
            switch (Character.toUpperCase((char)n2)) {
                case 'M': {
                    f = f7 + this.vip();
                    f2 = f8 + this.vip();
                    float_.moveTo(f, f2);
                    f3 = f;
                    f4 = f2;
                    f5 = f;
                    f6 = f2;
                    break;
                }
                case 'L': {
                    f = f7 + this.vip();
                    f2 = f8 + this.vip();
                    float_.lineTo(f, f2);
                    f5 = f;
                    f6 = f2;
                    break;
                }
                case 'H': {
                    f = f7 + this.vip();
                    float_.lineTo(f, f2);
                    f5 = f;
                    f6 = f2;
                    break;
                }
                case 'V': {
                    f2 = f8 + this.vip();
                    float_.lineTo(f, f2);
                    f5 = f;
                    f6 = f2;
                    break;
                }
                case 'C': {
                    float f9 = f7 + this.vip();
                    float f10 = f8 + this.vip();
                    float f11 = f7 + this.vip();
                    float f12 = f8 + this.vip();
                    f = f7 + this.vip();
                    f2 = f8 + this.vip();
                    float_.curveTo(f9, f10, f11, f12, f, f2);
                    f5 = f11;
                    f6 = f12;
                    break;
                }
                case 'S': {
                    boolean bl2 = "CcSs".indexOf(n) >= 0;
                    float f10 = bl2 ? 2.0f * f - f5 : f;
                    float f11 = bl2 ? 2.0f * f2 - f6 : f2;
                    float f13 = f7 + this.vip();
                    float f14 = f8 + this.vip();
                    f = f7 + this.vip();
                    f2 = f8 + this.vip();
                    float_.curveTo(f10, f11, f13, f14, f, f2);
                    f5 = f13;
                    f6 = f14;
                    break;
                }
                case 'Q': {
                    float f15 = f7 + this.vip();
                    float f10 = f8 + this.vip();
                    f = f7 + this.vip();
                    f2 = f8 + this.vip();
                    float_.quadTo(f15, f10, f, f2);
                    f5 = f15;
                    f6 = f10;
                    break;
                }
                case 'T': {
                    boolean bl3 = "QqTt".indexOf(n) >= 0;
                    float f10 = bl3 ? 2.0f * f - f5 : f;
                    float f11 = bl3 ? 2.0f * f2 - f6 : f2;
                    f = f7 + this.vip();
                    f2 = f8 + this.vip();
                    float_.quadTo(f10, f11, f, f2);
                    f5 = f10;
                    f6 = f11;
                    break;
                }
                case 'A': {
                    float f16 = this.vip();
                    float f10 = this.vip();
                    float f11 = this.vip();
                    boolean bl4 = this.viq();
                    boolean bl5 = this.viq();
                    float f17 = f7 + this.vip();
                    float f18 = f8 + this.vip();
                    vii.vir(float_, f, f2, f16, f10, f11, bl4, bl5, f17, f18);
                    f = f17;
                    f2 = f18;
                    f5 = f;
                    f6 = f2;
                    break;
                }
                case 'Z': {
                    float_.closePath();
                    f = f3;
                    f2 = f4;
                    f5 = f;
                    f6 = f2;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("bad path command '" + (char)n2 + "' in " + this.vij);
                }
            }
            n = n2;
        }
        return float_;
    }

    private void vio() {
        char c;
        while (this.vik < this.vij.length() && ((c = this.vij.charAt(this.vik)) == ' ' || c == ',' || c == '\n' || c == '\t')) {
            ++this.vik;
        }
    }

    private float vip() {
        this.vio();
        int n = this.vik;
        if (this.vik < this.vij.length() && (this.vij.charAt(this.vik) == '-' || this.vij.charAt(this.vik) == '+')) {
            ++this.vik;
        }
        boolean bl = false;
        while (this.vik < this.vij.length()) {
            char c = this.vij.charAt(this.vik);
            if (Character.isDigit(c)) {
                ++this.vik;
                continue;
            }
            if (c != '.' || bl) break;
            bl = true;
            ++this.vik;
        }
        if (n == this.vik) {
            throw new IllegalArgumentException("number expected at " + this.vik + " in " + this.vij);
        }
        return Float.parseFloat(this.vij.substring(n, this.vik));
    }

    private boolean viq() {
        this.vio();
        char c = this.vij.charAt(this.vik++);
        return c == '1';
    }

    private static void vir(Path2D.Float float_, float f, float f2, float f3, float f4, float f5, boolean bl, boolean bl2, float f6, float f7) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        if (f3 == 0.0f || f4 == 0.0f || f == f6 && f2 == f7) {
            float_.lineTo(f6, f7);
            return;
        }
        f3 = Math.abs(f3);
        f4 = Math.abs(f4);
        double d6 = Math.toRadians(f5);
        double d7 = Math.cos(d6);
        double d8 = d7 * (d5 = (double)(f - f6) * 0.5) + (d4 = Math.sin(d6)) * (d3 = (double)(f2 - f7) * 0.5);
        double d9 = d8 * d8 / (double)(f3 * f3) + (d2 = -d4 * d5 + d7 * d3) * d2 / (double)(f4 * f4);
        if (d9 > 1.0) {
            d = Math.sqrt(d9);
            f3 = (float)((double)f3 * d);
            f4 = (float)((double)f4 * d);
        }
        d = (double)(f3 * f3 * f4 * f4) - (double)(f3 * f3) * d2 * d2 - (double)(f4 * f4) * d8 * d8;
        double d10 = (double)(f3 * f3) * d2 * d2 + (double)(f4 * f4) * d8 * d8;
        double d11 = (double)(bl != bl2 ? 1 : -1) * Math.sqrt(Math.max(0.0, d / d10));
        double d12 = d11 * (double)f3 * d2 / (double)f4;
        double d13 = -d11 * (double)f4 * d8 / (double)f3;
        double d14 = d7 * d12 - d4 * d13 + (double)(f + f6) * 0.5;
        double d15 = d4 * d12 + d7 * d13 + (double)(f2 + f7) * 0.5;
        double d16 = (d8 - d12) / (double)f3;
        double d17 = (d2 - d13) / (double)f4;
        double d18 = (-d8 - d12) / (double)f3;
        double d19 = (-d2 - d13) / (double)f4;
        double d20 = Math.atan2(d17, d16);
        double d21 = Math.atan2(d16 * d19 - d17 * d18, d16 * d18 + d17 * d19);
        if (!bl2 && d21 > 0.0) {
            d21 -= Math.PI * 2;
        } else if (bl2 && d21 < 0.0) {
            d21 += Math.PI * 2;
        }
        int n = (int)Math.ceil(Math.abs(d21) / 1.5707963267948966 - 1.0E-6);
        double d22 = d21 / (double)Math.max(1, n);
        double d23 = 1.3333333333333333 * Math.tan(d22 / 4.0);
        for (int i = 0; i < n; ++i) {
            double d24 = d20 + d22 * (double)i;
            double d25 = d24 + d22;
            double d26 = Math.cos(d24);
            double d27 = Math.sin(d24);
            double d28 = Math.cos(d25);
            double d29 = Math.sin(d25);
            double[] dArray = vii.vis(d26 - d23 * d27, d27 + d23 * d26, f3, f4, d7, d4, d14, d15);
            double[] dArray2 = vii.vis(d28 + d23 * d29, d29 - d23 * d28, f3, f4, d7, d4, d14, d15);
            double[] dArray3 = vii.vis(d28, d29, f3, f4, d7, d4, d14, d15);
            float_.curveTo((float)dArray[0], (float)dArray[1], (float)dArray2[0], (float)dArray2[1], (float)dArray3[0], (float)dArray3[1]);
        }
    }

    private static double[] vis(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d * d3;
        double d10 = d2 * d4;
        return new double[]{d5 * d9 - d6 * d10 + d7, d6 * d9 + d5 * d10 + d8};
    }

    private static /* synthetic */ int dfo(int n, int n2) {
        return n * n2 ^ 0x7A0B2EFD;
    }

    private static /* synthetic */ int dfp(int n, int n2) {
        return vii.dfo(n, n2) ^ 0xFE7B34A7;
    }

    private static /* synthetic */ int dfq(int n, int n2) {
        return vii.dfp(n, n2) ^ 0x9C78B5DF;
    }
}

