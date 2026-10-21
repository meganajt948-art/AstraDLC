/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class AimFeatures {
    public static final int EX = 0;
    public static final int EY = 1;
    public static final int E2X = 2;
    public static final int E2Y = 3;
    public static final int E4X = 4;
    public static final int E4Y = 5;
    public static final int W0X = 6;
    public static final int W0Y = 7;
    public static final int W1X = 8;
    public static final int W1Y = 9;
    public static final int W2X = 10;
    public static final int W2Y = 11;
    public static final int W3X = 12;
    public static final int W3Y = 13;
    public static final int H0X = 14;
    public static final int H0Y = 15;
    public static final int H1X = 16;
    public static final int H1Y = 17;
    public static final int H2X = 18;
    public static final int H2Y = 19;
    public static final int H3X = 20;
    public static final int H3Y = 21;
    public static final int BW = 22;
    public static final int BH = 23;
    public static final int U = 24;
    public static final int V = 25;
    public static final int DIST = 26;
    public static final int CD = 27;
    public static final int LA = 28;
    public static final int RA = 29;
    public static final int TA = 30;
    public static final int BA = 31;
    public static final int S = 32;
    public static final int WX = 6;
    public static final int WY = 7;
    public static final int HIST = 4;
    public static final int N = 32;
    public static final int OUT = 4;
    public static final double C_SCALE = 2.0;
    private static final double tbg = 1.5;
    private static final int[] tbh = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 24};
    private static final int[][] tbi = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15}, {16, 17}, {18, 19}, {20, 21}, {22, 23}, {28, 30}, {29, 31}};
    private static /* synthetic */ String tbj;
    private static /* synthetic */ int tbk;

    private AimFeatures() {
    }

    public static void raw(double[] dArray, double[] dArray2) {
        int n;
        double d = dArray[0];
        double d2 = dArray[1];
        dArray2[0] = d / 10.0;
        dArray2[1] = AimFeatures.slog(d);
        dArray2[2] = d2 / 10.0;
        dArray2[3] = AimFeatures.slog(d2);
        dArray2[4] = dArray[2] / 10.0;
        dArray2[5] = dArray[3] / 10.0;
        dArray2[6] = dArray[4] / 10.0;
        dArray2[7] = dArray[5] / 10.0;
        for (n = 0; n < 8; ++n) {
            dArray2[8 + n] = dArray[6 + n] / 3.0;
        }
        for (n = 0; n < 8; ++n) {
            dArray2[16 + n] = dArray[14 + n] / 5.0;
        }
        dArray2[24] = dArray[22] / 4.0;
        dArray2[25] = dArray[23] / 8.0;
        dArray2[26] = dArray[24];
        dArray2[27] = dArray[25] - 0.5;
        dArray2[28] = dArray[26] / 4.0 - 1.0;
        dArray2[29] = dArray[27] * 2.0 - 1.0;
        dArray2[30] = Math.tanh(AimFeatures.outX(dArray) / 1.5);
        dArray2[31] = Math.tanh(AimFeatures.outY(dArray) / 1.5);
    }

    public static void features(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
        AimFeatures.raw(dArray, dArray4);
        for (int i = 0; i < 32; ++i) {
            dArray4[i] = (dArray4[i] - dArray2[i]) / dArray3[i];
        }
    }

    public static double outX(double[] dArray) {
        return Math.max(dArray[28] + dArray[0], -dArray[0] - dArray[29]);
    }

    public static double outY(double[] dArray) {
        return Math.max(dArray[30] + dArray[1], -dArray[1] - dArray[31]);
    }

    public static void backward(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
        double d = dArray[0];
        double d2 = dArray[1];
        double d3 = Math.tanh(AimFeatures.outX(dArray) / 1.5);
        double d4 = Math.tanh(AimFeatures.outY(dArray) / 1.5);
        double d5 = dArray[28] + d >= -d - dArray[29] ? 1.0 : -1.0;
        double d6 = dArray[30] + d2 >= -d2 - dArray[31] ? 1.0 : -1.0;
        dArray4[0] = dArray3[0] / dArray2[0] / 10.0 + dArray3[1] / dArray2[1] * AimFeatures.tbl(d) + dArray3[30] / dArray2[30] * (1.0 - d3 * d3) / 1.5 * d5;
        dArray4[1] = dArray3[2] / dArray2[2] / 10.0 + dArray3[3] / dArray2[3] * AimFeatures.tbl(d2) + dArray3[31] / dArray2[31] * (1.0 - d4 * d4) / 1.5 * d6;
        dArray4[2] = dArray3[4] / dArray2[4] / 10.0;
        dArray4[3] = dArray3[5] / dArray2[5] / 10.0;
        dArray4[4] = dArray3[6] / dArray2[6] / 10.0;
        dArray4[5] = dArray3[7] / dArray2[7] / 10.0;
        for (int i = 0; i < 8; ++i) {
            dArray4[14 + i] = dArray3[16 + i] / dArray2[16 + i] / 5.0;
        }
    }

    public static void swapAxes(double[] dArray) {
        for (int[] nArray : tbi) {
            double d = dArray[nArray[0]];
            dArray[nArray[0]] = dArray[nArray[1]];
            dArray[nArray[1]] = d;
        }
    }

    public static void mirror(double[] dArray, double[] dArray2) {
        System.arraycopy(dArray, 0, dArray2, 0, 32);
        for (int n : tbh) {
            dArray2[n] = -dArray[n];
        }
        dArray2[28] = -dArray[29];
        dArray2[29] = -dArray[28];
    }

    public static double slog(double d) {
        return Math.signum(d) * Math.log1p(Math.abs(d) / 0.5) / 3.0;
    }

    private static double tbl(double d) {
        return 1.0 / (3.0 * (0.5 + Math.abs(d)));
    }

    private static /* synthetic */ int cjm(int n, int n2) {
        return n + n2 | 0x4A6B116A;
    }

    private static /* synthetic */ int cjn(int n, int n2) {
        return AimFeatures.cjm(n, n2) * n2;
    }

    private static /* synthetic */ int cjo(int n, int n2) {
        return AimFeatures.cjn(n, n2) + n;
    }
}

