/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tbm;

public final class AngleUtil {
    private static /* synthetic */ String tbq;
    private static /* synthetic */ String tbr;

    private AngleUtil() {
    }

    public static double wrap(double d) {
        double d2 = d % 360.0;
        if (d2 >= 180.0) {
            d2 -= 360.0;
        } else if (d2 < -180.0) {
            d2 += 360.0;
        }
        return d2;
    }

    public static double yawTo(double d, double d2) {
        return Math.toDegrees(Math.atan2(d2, d)) - 90.0;
    }

    public static double pitchTo(double d, double d2) {
        return -Math.toDegrees(Math.atan2(d, d2));
    }

    public static boolean aim(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, tbm tbm2) {
        double d11 = d4 - d;
        double d12 = d6 - d3;
        double d13 = Math.sqrt(d11 * d11 + d12 * d12);
        if (d13 < 0.08) {
            return false;
        }
        double d14 = -d12 / d13;
        double d15 = d11 / d13;
        double d16 = d7 * (Math.abs(d14) + Math.abs(d15));
        double d17 = d4 + d14 * d9 * d16;
        double d18 = d6 + d15 * d9 * d16;
        double d19 = d5 + d10 * d8;
        double d20 = d17 - d;
        double d21 = d18 - d3;
        tbm2.yaw = AngleUtil.yawTo(d20, d21);
        tbm2.pitch = AngleUtil.pitchTo(d19 - d2, Math.sqrt(d20 * d20 + d21 * d21));
        double d22 = AngleUtil.yawTo(d11 - d14 * d16, d12 - d15 * d16);
        double d23 = AngleUtil.yawTo(d11 + d14 * d16, d12 + d15 * d16);
        tbm2.la = Math.min(0.0, AngleUtil.wrap(d22 - tbm2.yaw));
        tbm2.ra = Math.max(0.0, AngleUtil.wrap(d23 - tbm2.yaw));
        tbm2.bw = (tbm2.ra - tbm2.la) * 0.5;
        double d24 = Math.max(0.1, d13 - d7);
        tbm2.ta = Math.min(0.0, AngleUtil.pitchTo(d5 + d8 - d2, d24) - tbm2.pitch);
        tbm2.ba = Math.max(0.0, AngleUtil.pitchTo(d5 - d2, d24) - tbm2.pitch);
        tbm2.bh = tbm2.ba - tbm2.ta;
        double d25 = d5 + d8 * 0.5 - d2;
        tbm2.dist = Math.sqrt(d13 * d13 + d25 * d25);
        return true;
    }

    public static double hitU(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 - d;
        double d9 = d4 - d2;
        double d10 = Math.sqrt(d8 * d8 + d9 * d9);
        if (d10 < 0.08) {
            return 0.0;
        }
        double d11 = -d9 / d10;
        double d12 = d8 / d10;
        double d13 = d5 * (Math.abs(d11) + Math.abs(d12));
        double d14 = ((d6 - d3) * d11 + (d7 - d4) * d12) / Math.max(0.001, d13);
        return Math.max(-1.0, Math.min(1.0, d14));
    }

    public static double hitV(double d, double d2, double d3) {
        return Math.max(0.0, Math.min(1.0, (d3 - d) / Math.max(0.001, d2)));
    }

    private static /* synthetic */ int cju(int n, int n2) {
        return n * n2 + 982803644;
    }

    private static /* synthetic */ int cjv(int n, int n2) {
        return AngleUtil.cju(n, n2) * n2;
    }

    private static /* synthetic */ int cjw(int n, int n2) {
        return (n ^ n2) + 650560611;
    }
}

