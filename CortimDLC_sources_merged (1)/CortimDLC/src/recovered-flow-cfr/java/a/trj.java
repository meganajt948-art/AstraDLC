/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tbx;
import a.tpx;
import a.trd;
import a.trg;
import a.tvn;
import flow.dev.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public final class trj {
    public static final int SECTORS = 8;
    public static final int PER = 7;
    public static final int GLOBAL = 15;
    public static final int N = 71;
    public static final int MOVES = 9;
    public static final int OUT = 11;
    public static final int HIDDEN = 48;
    public static final int NONE = 0;
    public static final int F = 1;
    public static final int FL = 2;
    public static final int FR = 3;
    public static final int L = 4;
    public static final int R = 5;
    public static final int B = 6;
    public static final int BL = 7;
    public static final int BR = 8;
    public static final int[] MIRROR = new int[]{0, 1, 3, 2, 5, 4, 6, 8, 7};
    public static final int[] FWD = new int[]{0, 1, 1, 1, 0, 0, -1, -1, -1};
    public static final int[] LEFT = new int[]{0, 0, 1, -1, 1, -1, 0, 1, -1};
    public final tbx net;
    public final double[] mu = new double[71];
    public final double[] sd = new double[71];
    private static /* synthetic */ String trk;
    private static /* synthetic */ String trl;

    public trj(tbx tbx2) {
        this.net = tbx2;
        Arrays.fill(this.sd, 1.0);
    }

    public static int move(int n) {
        boolean bl;
        boolean bl2 = (n & 1) != 0 && (n & 2) == 0;
        boolean bl3 = (n & 2) != 0 && (n & 1) == 0;
        boolean bl4 = (n & 4) != 0 && (n & 8) == 0;
        boolean bl5 = bl = (n & 8) != 0 && (n & 4) == 0;
        if (bl2) {
            return bl4 ? 2 : (bl ? 3 : 1);
        }
        if (bl3) {
            return bl4 ? 7 : (bl ? 8 : 6);
        }
        return bl4 ? 4 : (bl ? 5 : 0);
    }

    public static void features(tvn tvn2, trg trg2, double[] dArray, int n) {
        double d;
        double d2;
        double d3;
        byte by;
        byte by2;
        byte by3;
        byte by4;
        int n2;
        double d4;
        double d5;
        int n3;
        double d6 = Math.toRadians(trg2.yaw);
        double d7 = -Math.sin(d6);
        double d8 = Math.cos(d6);
        double d9 = Math.cos(d6);
        double d10 = Math.sin(d6);
        int n4 = (int)Math.floor(trg2.px);
        int n5 = (int)Math.floor(trg2.pz);
        int n6 = trg2.feetY;
        Arrays.fill(dArray, n, n + 71, 0.0);
        for (n3 = 0; n3 < 8; ++n3) {
            double d11 = Math.toRadians(45.0 * (double)n3);
            d5 = Math.cos(d11) * d7 + Math.sin(d11) * d9;
            d4 = Math.cos(d11) * d8 + Math.sin(d11) * d10;
            int n7 = n4 + (Math.abs(d5) > 0.38 ? (d5 > 0.0 ? 1 : -1) : 0);
            n2 = n5 + (Math.abs(d4) > 0.38 ? (d4 > 0.0 ? 1 : -1) : 0);
            byte by5 = tvn2.at(n7, n6 - 1, n2);
            by4 = tvn2.at(n7, n6, n2);
            by3 = tvn2.at(n7, n6 + 1, n2);
            by2 = tvn2.at(n7, n6 + 2, n2);
            by = n + n3 * 7;
            dArray[by] = tpx.open(by4) && tpx.open(by3) && !tpx.open(by5) ? 1.0 : 0.0;
            dArray[by + 1] = tpx.open(by4) && tpx.open(by3) && tpx.open(by5) ? 1.0 : 0.0;
            dArray[by + 2] = tpx.minable(by4) || tpx.minable(by3) ? 1.0 : 0.0;
            dArray[by + 3] = !tpx.open(by4) && !tpx.minable(by4) || !tpx.open(by3) && !tpx.minable(by3) ? 1.0 : 0.0;
            dArray[by + 4] = !tpx.open(by4) && tpx.open(by3) && tpx.open(by2) ? 1.0 : 0.0;
        }
        for (n3 = n4 - 5; n3 <= n4 + 5; ++n3) {
            for (int i = n5 - 5; i <= n5 + 5; ++i) {
                d3 = (double)n3 + 0.5 - trg2.px;
                d2 = (double)i + 0.5 - trg2.pz;
                d = Math.hypot(d3, d2);
                if (d < 0.5 || d > 5.5) continue;
                double d12 = Math.toDegrees(Math.atan2(d3 * d9 + d2 * d10, d3 * d7 + d2 * d8));
                by4 = ((int)Math.round(d12 / 45.0) % 8 + 8) % 8;
                by3 = n + by4 * 7;
                for (by2 = n6 - 2; by2 <= n6 + 4; ++by2) {
                    by = tvn2.at(n3, by2, i);
                    if (!tpx.minable(by)) continue;
                    if (d <= 4.5 && by2 >= n6 - 1 && by2 <= n6 + 3) {
                        int n8 = by3 + 5;
                        dArray[n8] = dArray[n8] + 0.05;
                    }
                    if (!tpx.target(by)) continue;
                    int n9 = by3 + 6;
                    dArray[n9] = dArray[n9] + 0.3333333333333333;
                }
            }
        }
        n3 = n + 56;
        dArray[n3] = (trg2.vx * d7 + trg2.vz * d8) * 4.0;
        dArray[n3 + 1] = (trg2.vx * d9 + trg2.vz * d10) * 4.0;
        dArray[n3 + 2] = trg2.vy * 2.0;
        dArray[n3 + 3] = trg2.ground ? 1.0 : 0.0;
        dArray[n3 + 4] = (double)trg2.pitch / 90.0;
        if (trg2.hasTarget) {
            double d13 = (double)trg2.tx + 0.5 - trg2.px;
            d5 = (double)trg2.tz + 0.5 - trg2.pz;
            dArray[n3 + 5] = 1.0;
            dArray[n3 + 6] = (d13 * d7 + d5 * d8) / 4.0;
            dArray[n3 + 7] = (d13 * d9 + d5 * d10) / 4.0;
            dArray[n3 + 8] = (double)(trg2.ty - n6) / 3.0;
            d4 = Math.toRadians(trg2.pitch);
            double d14 = d13;
            double d15 = (double)trg2.ty + 0.5 - trg2.eyeY;
            double d16 = d5;
            double d17 = Math.sqrt(d14 * d14 + d15 * d15 + d16 * d16);
            if (d17 > 1.0E-6) {
                double d18 = (d14 * d7 * Math.cos(d4) - d15 * Math.sin(d4) + d16 * d8 * Math.cos(d4)) / d17;
                dArray[n3 + 9] = Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, d18)))) / 90.0;
            }
        }
        int[] nArray = new int[2];
        trd.reach(tvn2, trg2.px, trg2.eyeY, trg2.pz, nArray);
        dArray[n3 + 10] = (double)nArray[0] / 40.0;
        dArray[n3 + 11] = (double)nArray[1] / 4.0;
        if (nArray[0] == 0) {
            d3 = Double.MAX_VALUE;
            d2 = 0.0;
            d = 0.0;
            for (n2 = n4 - 7 + 1; n2 <= n4 + 7 - 1; ++n2) {
                block5: for (int i = n5 - 7 + 1; i <= n5 + 7 - 1; ++i) {
                    double d19 = (double)n2 + 0.5 - trg2.px;
                    double d20 = (double)i + 0.5 - trg2.pz;
                    double d21 = Math.hypot(d19, d20);
                    if (d21 >= d3) continue;
                    for (int j = n6; j <= n6 + 3; ++j) {
                        if (!tpx.minable(tvn2.at(n2, j, i))) continue;
                        d3 = d21;
                        d2 = d19;
                        d = d20;
                        continue block5;
                    }
                }
            }
            if (d3 < Double.MAX_VALUE && d3 > 1.0E-6) {
                dArray[n3 + 12] = (d2 * d7 + d * d8) / d3;
                dArray[n3 + 13] = (d2 * d9 + d * d10) / d3;
                dArray[n3 + 14] = d3 / 8.0;
            }
        }
    }

    public static void mirror(double[] dArray, int n, double[] dArray2, int n2) {
        int n3;
        for (n3 = 0; n3 < 8; ++n3) {
            int n4 = (8 - n3) % 8;
            System.arraycopy(dArray, n + n3 * 7, dArray2, n2 + n4 * 7, 7);
        }
        n3 = 56;
        System.arraycopy(dArray, n + n3, dArray2, n2 + n3, 15);
        dArray2[n2 + n3 + 1] = -dArray[n + n3 + 1];
        dArray2[n2 + n3 + 7] = -dArray[n + n3 + 7];
        dArray2[n2 + n3 + 13] = -dArray[n + n3 + 13];
    }

    public void normalize(double[] dArray, int n, double[] dArray2) {
        for (int i = 0; i < 71; ++i) {
            dArray2[i] = Math.max(-8.0, Math.min(8.0, (dArray[n + i] - this.mu[i]) / this.sd[i]));
        }
    }

    public void decide(double[] dArray, double[] dArray2) {
        int n;
        double[] dArray3 = new double[71];
        this.normalize(dArray, 0, dArray3);
        double[] dArray4 = new double[this.net.h1];
        double[] dArray5 = new double[this.net.h2];
        double[] dArray6 = new double[11];
        this.net.forward(dArray3, dArray4, dArray5, dArray6);
        double d = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 9; ++i) {
            d = Math.max(d, dArray6[i]);
        }
        double d2 = 0.0;
        for (n = 0; n < 9; ++n) {
            dArray2[n] = Math.exp(dArray6[n] - d);
            d2 += dArray2[n];
        }
        n = 0;
        while (n < 9) {
            int n2 = n++;
            dArray2[n2] = dArray2[n2] / d2;
        }
        dArray2[9] = 1.0 / (1.0 + Math.exp(-dArray6[9]));
        dArray2[10] = 1.0 / (1.0 + Math.exp(-dArray6[10]));
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(71);
        for (int i = 0; i < 71; ++i) {
            dataOutputStream.writeFloat((float)this.mu[i]);
            dataOutputStream.writeFloat((float)this.sd[i]);
        }
        this.net.write(dataOutputStream);
    }

    public static trj read(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        if (n != 71) {
            throw new IOException(a.d("\uc6c6\ubf7e\u35af\uabca\u204e\ua6ac\u1ce4\u951c\u0b52\u81f6", 2018157232, -508992496));
        }
        double[] dArray = new double[71];
        double[] dArray2 = new double[71];
        for (int i = 0; i < 71; ++i) {
            dArray[i] = dataInputStream.readFloat();
            dArray2[i] = dataInputStream.readFloat();
        }
        tbx tbx2 = tbx.read(dataInputStream);
        if (tbx2.in != 71 || tbx2.out != 11) {
            throw new IOException(a.b("\u8c2c\uf594\u7f45\ue120\u6aa4\uec46\u560e\udff6\u41b8\ucb1c", 1791003722));
        }
        trj trj2 = new trj(tbx2);
        System.arraycopy(dArray, 0, trj2.mu, 0, 71);
        System.arraycopy(dArray2, 0, trj2.sd, 0, 71);
        return trj2;
    }

    private static /* synthetic */ int cpj(int n, int n2) {
        return n + n2 + 1612399783;
    }

    private static /* synthetic */ int cpk(int n, int n2) {
        return n - n2 | 0xF57DA560;
    }

    private static /* synthetic */ int cpl(int n, int n2) {
        return trj.cpj(n, n2) ^ 0xAE5B70E8;
    }
}

