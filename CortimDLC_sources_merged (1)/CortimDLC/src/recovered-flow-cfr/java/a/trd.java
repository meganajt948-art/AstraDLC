/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tpx;
import a.tvn;

public final class trd {
    public static final double RADIUS = 6.0;
    public static final double REACH = 4.8;
    public static final int WORKING = 8;
    public static final int DIA_WEIGHT = 6;
    private static /* synthetic */ boolean tre;
    private static /* synthetic */ int trf;

    private trd() {
    }

    public static void diff(tvn tvn2, tvn tvn3, double d, double d2, double d3, int[] nArray) {
        nArray[0] = 0;
        nArray[1] = 0;
        if (tvn2 == null || tvn3 == null) {
            return;
        }
        int n = (int)Math.ceil(6.0);
        int n2 = (int)Math.floor(d);
        int n3 = (int)Math.floor(d2);
        int n4 = (int)Math.floor(d3);
        double d4 = 36.0;
        for (int i = n2 - n; i <= n2 + n; ++i) {
            for (int j = n3 - n; j <= n3 + n; ++j) {
                for (int k = n4 - n; k <= n4 + n; ++k) {
                    byte by;
                    double d5 = (double)i + 0.5 - d;
                    double d6 = (double)j + 0.5 - d2;
                    double d7 = (double)k + 0.5 - d3;
                    if (d5 * d5 + d6 * d6 + d7 * d7 > d4 || !tvn2.inside(i, j, k) || !tvn3.inside(i, j, k) || !tpx.minable(by = tvn2.at(i, j, k)) || !tpx.open(tvn3.at(i, j, k))) continue;
                    nArray[0] = nArray[0] + 1;
                    if (!tpx.target(by)) continue;
                    nArray[1] = nArray[1] + 1;
                }
            }
        }
    }

    public static void reach(tvn tvn2, double d, double d2, double d3, int[] nArray) {
        nArray[0] = 0;
        nArray[1] = 0;
        int n = (int)Math.ceil(4.8);
        int n2 = (int)Math.floor(d);
        int n3 = (int)Math.floor(d2);
        int n4 = (int)Math.floor(d3);
        double d4 = 23.04;
        for (int i = n2 - n; i <= n2 + n; ++i) {
            for (int j = n3 - n; j <= n3 + n; ++j) {
                for (int k = n4 - n; k <= n4 + n; ++k) {
                    byte by;
                    double d5 = (double)i + 0.5 - d;
                    double d6 = (double)j + 0.5 - d2;
                    double d7 = (double)k + 0.5 - d3;
                    if (d5 * d5 + d6 * d6 + d7 * d7 > d4 || !tpx.minable(by = tvn2.at(i, j, k))) continue;
                    nArray[0] = nArray[0] + 1;
                    if (!tpx.target(by)) continue;
                    nArray[1] = nArray[1] + 1;
                }
            }
        }
    }

    public static double value(int n, int n2) {
        return n + 5 * n2;
    }

    private static /* synthetic */ int cpb(int n, int n2) {
        return n + n2 + -738789047;
    }
}

