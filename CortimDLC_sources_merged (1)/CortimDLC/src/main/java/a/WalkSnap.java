/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;

public final class WalkSnap {
    public static final int RX = 6;
    public static final int DOWN = 3;
    public static final int UP = 3;
    public static final int W = 13;
    public static final int H = 7;
    public static final int SIZE = 1183;
    public static final int HEIGHT = 15;
    public static final int FULL = 8;
    public static final int TALL = 9;
    public static final int FLUID = 16;
    public static final int HAZARD = 32;
    public static final int CLIMB = 64;
    public static final int THIN = 128;
    public final int x0;
    public final int y0;
    public final int z0;
    public final byte[] cells;
    private static /* synthetic */ long tzh;
    private static /* synthetic */ int tzi;

    public WalkSnap(int n, int n2, int n3, byte[] byArray) {
        if (byArray.length != 1183) {
            throw new IllegalArgumentException("walk snap size");
        }
        this.x0 = n;
        this.y0 = n2;
        this.z0 = n3;
        this.cells = byArray;
    }

    public static int index(int n, int n2, int n3) {
        return (n * 7 + n2) * 13 + n3;
    }

    public boolean inside(int n, int n2, int n3) {
        int n4 = n - this.x0;
        int n5 = n2 - this.y0;
        int n6 = n3 - this.z0;
        return n4 >= 0 && n5 >= 0 && n6 >= 0 && n4 < 13 && n5 < 7 && n6 < 13;
    }

    public int at(int n, int n2, int n3) {
        int n4 = n - this.x0;
        int n5 = n2 - this.y0;
        int n6 = n3 - this.z0;
        if (n4 < 0 || n5 < 0 || n6 < 0 || n4 >= 13 || n5 >= 7 || n6 >= 13) {
            return 8;
        }
        return this.cells[WalkSnap.index(n4, n5, n6)] & 0xFF;
    }

    public static int height(int n) {
        return n & 0xF;
    }

    public static boolean solid(int n) {
        return (n & 0xF) != 0;
    }

    public static float top(int n) {
        int n2 = n & 0xF;
        return n2 >= 9 ? 1.5f : (float)n2 / 8.0f;
    }

    private static /* synthetic */ int ctm(int n, int n2) {
        return n * n2 + 1301378288;
    }

    private static /* synthetic */ int ctn(int n, int n2) {
        return n ^ n2 ^ 0xA4BC7FC9;
    }

    private static /* synthetic */ int cto(int n, int n2) {
        return WalkSnap.ctn(n, n2) + n;
    }
}

