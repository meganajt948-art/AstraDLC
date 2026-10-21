/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.PathProjection;
import a.txi;
import a.WalkSnap;
import java.util.Arrays;

public final class WalkFeatures {
    public static final double[] AHEAD = new double[]{0.5, 1.0, 1.6, 2.4, 3.3, 4.4, 5.8, 7.5};
    public static final int POINTS;
    public static final int I_SIN;
    public static final int I_COS;
    public static final int I_LAT;
    public static final int I_REM;
    public static final int I_END;
    public static final int I_JUMP;
    public static final int I_DROP;
    public static final int ROUTE;
    public static final int SECTORS = 8;
    public static final int PER = 7;
    public static final int I_TERRAIN;
    public static final int I_OWN;
    public static final int TERRAIN = 59;
    public static final int I_KIN;
    public static final int I_VF;
    public static final int I_VL;
    public static final int I_VY;
    public static final int I_HS;
    public static final int I_GROUND;
    public static final int I_WATER;
    public static final int I_CLIMB;
    public static final int I_COLLIDE;
    public static final int I_SPRINT;
    public static final int I_SPEED;
    public static final int I_PITCH;
    public static final int I_DYAW1;
    public static final int I_DYAW2;
    public static final int I_DPITCH1;
    public static final int I_DPITCH2;
    public static final int I_SINCE;
    public static final int KIN = 16;
    public static final int N;
    public static final double FAR_LATERAL = 3.0;
    private static /* synthetic */ boolean txm;
    private static /* synthetic */ String txn;

    private WalkFeatures() {
    }

    public static void features(txi txi2, PathProjection tvt2, int n, WalkSnap tzg2, double[] dArray, int n2) {
        double d;
        double d2;
        double d3;
        Arrays.fill(dArray, n2, n2 + N, 0.0);
        double d4 = Math.toRadians(txi2.yaw);
        double d5 = -Math.sin(d4);
        double d6 = Math.cos(d4);
        double d7 = Math.cos(d4);
        double d8 = Math.sin(d4);
        double[] dArray2 = new double[3];
        double[] dArray3 = new double[1];
        if (tvt2 != null && tvt2.n > 0) {
            double d9;
            double d10 = tvt2.project(txi2.x, txi2.z, n);
            for (int i = 0; i < AHEAD.length; ++i) {
                tvt2.at(d10 + AHEAD[i], dArray2);
                double d11 = dArray2[0] - txi2.x;
                double d12 = dArray2[2] - txi2.z;
                int n3 = n2 + i * 3;
                dArray[n3] = WalkFeatures.txo((d11 * d5 + d12 * d6) / 4.0, 3.0);
                dArray[n3 + 1] = WalkFeatures.txo((d11 * d7 + d12 * d8) / 4.0, 3.0);
                dArray[n3 + 2] = WalkFeatures.txo((dArray2[1] - txi2.y) / 2.0, 3.0);
            }
            d3 = Math.toRadians(PathProjection.wrap(tvt2.heading(d10) - (double)txi2.yaw));
            dArray[n2 + WalkFeatures.I_SIN] = Math.sin(d3);
            dArray[n2 + WalkFeatures.I_COS] = Math.cos(d3);
            dArray[n2 + WalkFeatures.I_LAT] = WalkFeatures.txo(tvt2.lateral(txi2.x, txi2.z, d10) / 1.5, 4.0);
            d2 = tvt2.length() - d10;
            dArray[n2 + WalkFeatures.I_REM] = Math.min(12.0, Math.max(0.0, d2)) / 12.0;
            dArray[n2 + WalkFeatures.I_END] = d2 < 8.0 ? 1.0 : 0.0;
            d = tvt2.next(d10, 6.0, (byte)1, txi2.y, dArray3);
            if (d >= 0.0) {
                dArray[n2 + WalkFeatures.I_JUMP] = 1.0;
                dArray[n2 + WalkFeatures.I_JUMP + 1] = d / 6.0;
                dArray[n2 + WalkFeatures.I_JUMP + 2] = Math.min(2.0, dArray3[0] / 1.25);
            }
            if ((d9 = tvt2.next(d10, 6.0, (byte)2, txi2.y, dArray3)) >= 0.0) {
                dArray[n2 + WalkFeatures.I_DROP] = 1.0;
                dArray[n2 + WalkFeatures.I_DROP + 1] = d9 / 6.0;
                dArray[n2 + WalkFeatures.I_DROP + 2] = Math.min(3.0, dArray3[0] / 4.0);
            }
        }
        int n4 = (int)Math.floor(txi2.y + 0.001);
        if (tzg2 != null) {
            int n5;
            for (n5 = 0; n5 < 8; ++n5) {
                d3 = Math.toRadians(45.0 * (double)n5);
                d2 = Math.cos(d3) * d5 + Math.sin(d3) * d7;
                d = Math.cos(d3) * d6 + Math.sin(d3) * d8;
                int n6 = (int)Math.floor(txi2.x + d2 * 0.8);
                int n7 = (int)Math.floor(txi2.z + d * 0.8);
                int n8 = n2 + I_TERRAIN + n5 * 7;
                boolean bl = false;
                boolean bl2 = false;
                for (int i = -2; i <= 2; ++i) {
                    int n9 = tzg2.at(n6, n4 + i, n7);
                    dArray[n8 + i + 2] = WalkSnap.top(n9);
                    if (i >= -1 && i <= 1 && (n9 & 0x20) != 0) {
                        bl = true;
                    }
                    if (i < -1 || i > 0 || (n9 & 0x10) == 0) continue;
                    bl2 = true;
                }
                dArray[n8 + 5] = bl ? 1.0 : 0.0;
                dArray[n8 + 6] = bl2 ? 1.0 : 0.0;
            }
            n5 = (int)Math.floor(txi2.x);
            int n10 = (int)Math.floor(txi2.z);
            dArray[n2 + WalkFeatures.I_OWN] = WalkSnap.top(tzg2.at(n5, n4 - 1, n10));
            dArray[n2 + WalkFeatures.I_OWN + 1] = WalkSnap.top(tzg2.at(n5, n4 + 2, n10));
        }
        dArray[n2 + WalkFeatures.I_OWN + 2] = txi2.y - (double)n4;
        dArray[n2 + WalkFeatures.I_VF] = WalkFeatures.txo((txi2.vx * d5 + txi2.vz * d6) * 4.0, 4.0);
        dArray[n2 + WalkFeatures.I_VL] = WalkFeatures.txo((txi2.vx * d7 + txi2.vz * d8) * 4.0, 4.0);
        dArray[n2 + WalkFeatures.I_VY] = WalkFeatures.txo(txi2.vy * 2.0, 3.0);
        dArray[n2 + WalkFeatures.I_HS] = Math.min(4.0, Math.hypot(txi2.vx, txi2.vz) * 4.0);
        dArray[n2 + WalkFeatures.I_GROUND] = txi2.ground ? 1.0 : 0.0;
        dArray[n2 + WalkFeatures.I_WATER] = txi2.water ? 1.0 : 0.0;
        dArray[n2 + WalkFeatures.I_CLIMB] = txi2.climb ? 1.0 : 0.0;
        dArray[n2 + WalkFeatures.I_COLLIDE] = txi2.collide ? 1.0 : 0.0;
        dArray[n2 + WalkFeatures.I_SPRINT] = txi2.sprinting ? 1.0 : 0.0;
        dArray[n2 + WalkFeatures.I_SPEED] = WalkFeatures.txo(txi2.speed / 0.1 - 1.0, 3.0);
        dArray[n2 + WalkFeatures.I_PITCH] = (double)txi2.pitch / 90.0;
        dArray[n2 + WalkFeatures.I_DYAW1] = WalkFeatures.txo(txi2.dyaw1 / 10.0, 4.0);
        dArray[n2 + WalkFeatures.I_DYAW2] = WalkFeatures.txo(txi2.dyaw2 / 10.0, 4.0);
        dArray[n2 + WalkFeatures.I_DPITCH1] = WalkFeatures.txo(txi2.dpitch1 / 5.0, 4.0);
        dArray[n2 + WalkFeatures.I_DPITCH2] = WalkFeatures.txo(txi2.dpitch2 / 5.0, 4.0);
        dArray[n2 + WalkFeatures.I_SINCE] = (double)Math.min(20, Math.max(0, txi2.sinceJump)) / 20.0;
    }

    public static void mirror(double[] dArray, int n, double[] dArray2, int n2) {
        int n3;
        System.arraycopy(dArray, n, dArray2, n2, N);
        for (n3 = 0; n3 < AHEAD.length; ++n3) {
            dArray2[n2 + n3 * 3 + 1] = -dArray[n + n3 * 3 + 1];
        }
        dArray2[n2 + WalkFeatures.I_SIN] = -dArray[n + I_SIN];
        dArray2[n2 + WalkFeatures.I_LAT] = -dArray[n + I_LAT];
        for (n3 = 0; n3 < 8; ++n3) {
            int n4 = (8 - n3) % 8;
            System.arraycopy(dArray, n + I_TERRAIN + n3 * 7, dArray2, n2 + I_TERRAIN + n4 * 7, 7);
        }
        dArray2[n2 + WalkFeatures.I_VL] = -dArray[n + I_VL];
        dArray2[n2 + WalkFeatures.I_DYAW1] = -dArray[n + I_DYAW1];
        dArray2[n2 + WalkFeatures.I_DYAW2] = -dArray[n + I_DYAW2];
    }

    private static double txo(double d, double d2) {
        return d > d2 ? d2 : (d < -d2 ? -d2 : d);
    }

    static {
        I_SIN = POINTS = AHEAD.length * 3;
        I_COS = POINTS + 1;
        I_LAT = POINTS + 2;
        I_REM = POINTS + 3;
        I_END = POINTS + 4;
        I_JUMP = POINTS + 5;
        I_DROP = POINTS + 8;
        I_TERRAIN = ROUTE = POINTS + 11;
        I_OWN = I_TERRAIN + 56;
        I_VF = I_KIN = ROUTE + 59;
        I_VL = I_KIN + 1;
        I_VY = I_KIN + 2;
        I_HS = I_KIN + 3;
        I_GROUND = I_KIN + 4;
        I_WATER = I_KIN + 5;
        I_CLIMB = I_KIN + 6;
        I_COLLIDE = I_KIN + 7;
        I_SPRINT = I_KIN + 8;
        I_SPEED = I_KIN + 9;
        I_PITCH = I_KIN + 10;
        I_DYAW1 = I_KIN + 11;
        I_DYAW2 = I_KIN + 12;
        I_DPITCH1 = I_KIN + 13;
        I_DPITCH2 = I_KIN + 14;
        I_SINCE = I_KIN + 15;
        N = ROUTE + 59 + 16;
    }

    private static /* synthetic */ int csu(int n, int n2) {
        return n * n2 ^ 0xB6366C31;
    }
}

