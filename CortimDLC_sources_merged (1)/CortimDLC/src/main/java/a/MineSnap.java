/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;

public final class MineSnap {
    public static final int RX = 7;
    public static final int DOWN = 3;
    public static final int UP = 7;
    public static final int W = 15;
    public static final int H = 11;
    public static final int SIZE = 2475;
    public final int x0;
    public final int y0;
    public final int z0;
    public final byte[] cells;
    private static /* synthetic */ String tvo;
    private static /* synthetic */ long tvp;

    public MineSnap(int n, int n2, int n3, byte[] byArray) {
        if (byArray.length != 2475) {
            throw new IllegalArgumentException("snap size");
        }
        this.x0 = n;
        this.y0 = n2;
        this.z0 = n3;
        this.cells = byArray;
    }

    public static MineSnap around(int n, int n2, int n3, byte[] byArray) {
        return new MineSnap(n - 7, n2 - 3, n3 - 7, byArray);
    }

    public static int index(int n, int n2, int n3) {
        return (n * 11 + n2) * 15 + n3;
    }

    public boolean inside(int n, int n2, int n3) {
        int n4 = n - this.x0;
        int n5 = n2 - this.y0;
        int n6 = n3 - this.z0;
        return n4 >= 0 && n5 >= 0 && n6 >= 0 && n4 < 15 && n5 < 11 && n6 < 15;
    }

    public byte at(int n, int n2, int n3) {
        int n4 = n - this.x0;
        int n5 = n2 - this.y0;
        int n6 = n3 - this.z0;
        if (n4 < 0 || n5 < 0 || n6 < 0 || n4 >= 15 || n5 >= 11 || n6 >= 15) {
            return 4;
        }
        return this.cells[MineSnap.index(n4, n5, n6)];
    }

    private static /* synthetic */ int crt(int n, int n2) {
        return n - n2 ^ 0xAF552F27;
    }
}

