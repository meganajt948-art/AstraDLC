/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class tvt {
    public static final byte JUMP = 1;
    public static final byte DROP = 2;
    public static final byte WATER = 4;
    public static final byte CLIMB = 8;
    public final int n;
    public final float[] x;
    public final float[] y;
    public final float[] z;
    public final byte[] flag;
    public final float[] s;
    private static /* synthetic */ boolean tvu;
    private static /* synthetic */ String tvv;

    public tvt(float[] fArray, float[] fArray2, float[] fArray3, byte[] byArray) {
        this.n = fArray.length;
        this.x = fArray;
        this.y = fArray2;
        this.z = fArray3;
        this.flag = byArray;
        this.s = new float[this.n];
        for (int i = 1; i < this.n; ++i) {
            this.s[i] = this.s[i - 1] + (float)Math.hypot(fArray[i] - fArray[i - 1], fArray3[i] - fArray3[i - 1]);
        }
    }

    public double length() {
        return this.n == 0 ? 0.0 : (double)this.s[this.n - 1];
    }

    public int closest(double d, double d2, double d3, int n, int n2, int n3) {
        if (this.n == 0) {
            return 0;
        }
        int n4 = Math.max(0, n - n2);
        int n5 = Math.min(this.n - 1, n + n3);
        int n6 = Math.max(n4, Math.min(n5, n));
        double d4 = Double.MAX_VALUE;
        for (int i = n4; i <= n5; ++i) {
            double d5 = (double)this.x[i] - d;
            double d6 = (double)this.z[i] - d3;
            double d7 = (double)this.y[i] - d2;
            double d8 = d5 * d5 + d6 * d6 + d7 * d7 * 0.35;
            if (!(d8 < d4 - 1.0E-9)) continue;
            d4 = d8;
            n6 = i;
        }
        return n6;
    }

    public double project(double d, double d2, int n) {
        if (this.n < 2) {
            return 0.0;
        }
        double d3 = this.s[n];
        double d4 = Double.MAX_VALUE;
        for (int i = Math.max(0, n - 1); i <= Math.min(this.n - 2, n); ++i) {
            double d5;
            double d6;
            double d7;
            double d8 = this.z[i];
            double d9 = (double)this.z[i + 1] - d8;
            double d10 = (d7 = (double)this.x[i + 1] - (d6 = (double)this.x[i])) * d7 + d9 * d9;
            double d11 = d10 < 1.0E-9 ? 0.0 : Math.max(0.0, Math.min(1.0, ((d - d6) * d7 + (d2 - d8) * d9) / d10));
            double d12 = d6 + d7 * d11 - d;
            double d13 = d12 * d12 + (d5 = d8 + d9 * d11 - d2) * d5;
            if (!(d13 < d4)) continue;
            d4 = d13;
            d3 = (double)this.s[i] + (double)(this.s[i + 1] - this.s[i]) * d11;
        }
        return d3;
    }

    public int index(double d) {
        if (this.n == 0) {
            return 0;
        }
        if (d <= 0.0) {
            return 0;
        }
        if (d >= (double)this.s[this.n - 1]) {
            return this.n - 1;
        }
        int n = 0;
        int n2 = this.n - 1;
        while (n2 - n > 1) {
            int n3 = n + n2 >>> 1;
            if ((double)this.s[n3] <= d) {
                n = n3;
                continue;
            }
            n2 = n3;
        }
        return n;
    }

    public void at(double d, double[] dArray) {
        if (this.n == 0) {
            dArray[0] = 0.0;
            dArray[1] = 0.0;
            dArray[2] = 0.0;
            return;
        }
        if (this.n == 1 || d <= 0.0) {
            dArray[0] = this.x[0];
            dArray[1] = this.y[0];
            dArray[2] = this.z[0];
            return;
        }
        if (d >= (double)this.s[this.n - 1]) {
            dArray[0] = this.x[this.n - 1];
            dArray[1] = this.y[this.n - 1];
            dArray[2] = this.z[this.n - 1];
            return;
        }
        int n = this.index(d);
        double d2 = this.s[n + 1] - this.s[n];
        double d3 = d2 < 1.0E-9 ? 0.0 : (d - (double)this.s[n]) / d2;
        dArray[0] = (double)this.x[n] + (double)(this.x[n + 1] - this.x[n]) * d3;
        dArray[1] = (double)this.y[n] + (double)(this.y[n + 1] - this.y[n]) * d3;
        dArray[2] = (double)this.z[n] + (double)(this.z[n + 1] - this.z[n]) * d3;
    }

    public double heading(double d) {
        int n;
        if (this.n < 2) {
            return 0.0;
        }
        int n2 = Math.min(this.n - 2, this.index(d));
        for (n = n2 + 1; n < this.n - 1 && (double)(this.s[n] - this.s[n2]) < 0.4; ++n) {
        }
        while (n2 > 0 && (double)(this.s[n] - this.s[n2]) < 0.4) {
            --n2;
        }
        return tvt.yawOf(this.x[n] - this.x[n2], this.z[n] - this.z[n2]);
    }

    public double lateral(double d, double d2, double d3) {
        if (this.n < 2) {
            return 0.0;
        }
        double[] dArray = new double[3];
        this.at(d3, dArray);
        double d4 = Math.toRadians(this.heading(d3));
        double d5 = d - dArray[0];
        double d6 = d2 - dArray[2];
        return d5 * Math.cos(d4) + d6 * Math.sin(d4);
    }

    public double offset(double d, double d2, double d3) {
        double[] dArray = new double[3];
        this.at(d3, dArray);
        return Math.hypot(d - dArray[0], d2 - dArray[2]);
    }

    public double next(double d, double d2, byte by, double d3, double[] dArray) {
        int n = this.index(d);
        double d4 = d + d2;
        for (int i = n; i < this.n && (double)this.s[i] <= d4; ++i) {
            if ((this.flag[i] & by) == 0) continue;
            if (by == 1) {
                var13_9 = (double)this.y[i] - d3;
                for (var15_10 = i; var15_10 < this.n && (double)this.s[var15_10] <= (double)this.s[i] + 1.6; ++var15_10) {
                    var13_9 = Math.max(var13_9, (double)this.y[var15_10] - d3);
                }
                if (var13_9 < 0.55) continue;
                dArray[0] = var13_9;
            } else if (by == 2) {
                var13_9 = this.y[i];
                for (var15_10 = i; var15_10 < this.n && (double)this.s[var15_10] <= (double)this.s[i] + 2.0; ++var15_10) {
                    var13_9 = Math.min(var13_9, (double)this.y[var15_10]);
                }
                dArray[0] = d3 - var13_9;
                if (dArray[0] < 0.55) {
                    continue;
                }
            } else {
                dArray[0] = 0.0;
            }
            return Math.max(0.0, (double)this.s[i] - d);
        }
        dArray[0] = 0.0;
        return -1.0;
    }

    public double flatAhead(double d, double d2, double d3) {
        int n = this.index(d);
        double d4 = d + d2;
        for (int i = n; i < this.n && (double)this.s[i] <= d4; ++i) {
            if (!(Math.abs((double)this.y[i] - d3) > 0.55) && (this.flag[i] & 0xF) == 0) continue;
            return (double)this.s[i] - d;
        }
        return Math.min(d2, this.length() - d);
    }

    public double bend(double d, double d2) {
        if (this.n < 3) {
            return 0.0;
        }
        double d3 = this.heading(d);
        double d4 = 0.0;
        for (double d5 = 0.5; d5 <= d2 && !(d + d5 > this.length()); d5 += 0.5) {
            d4 = Math.max(d4, Math.abs(tvt.wrap(this.heading(d + d5) - d3)));
        }
        return d4;
    }

    public static double yawOf(double d, double d2) {
        return Math.toDegrees(Math.atan2(-d, d2));
    }

    public static double wrap(double d) {
        double d2 = d % 360.0;
        if (d2 >= 180.0) {
            d2 -= 360.0;
        }
        if (d2 < -180.0) {
            d2 += 360.0;
        }
        return d2;
    }

    private static /* synthetic */ int csb(int n, int n2) {
        return n + n2 + 1163745309;
    }
}

