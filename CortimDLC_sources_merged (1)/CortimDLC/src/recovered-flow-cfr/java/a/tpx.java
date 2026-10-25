/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class tpx {
    public static final byte AIR = 0;
    public static final byte STONE = 1;
    public static final byte TARGET = 2;
    public static final byte ORE = 3;
    public static final byte HARD = 4;
    public static final byte FLUID = 5;
    public static final byte PART = 6;
    public static final int TYPE = 7;
    public static final int SLOW = 8;
    private static /* synthetic */ int tpy;
    private static /* synthetic */ String tpz;

    private tpx() {
    }

    public static int type(byte by) {
        return by & 7;
    }

    public static boolean open(byte by) {
        int n = by & 7;
        return n == 0 || n == 5;
    }

    public static boolean minable(byte by) {
        int n = by & 7;
        return n == 1 || n == 2 || n == 3 || n == 6;
    }

    public static boolean target(byte by) {
        return (by & 7) == 2;
    }

    public static boolean ore(byte by) {
        return (by & 7) == 3;
    }

    public static boolean slow(byte by) {
        return (by & 8) != 0;
    }

    private static /* synthetic */ int cob(int n, int n2) {
        return n ^ n2 | 0x5C038B99;
    }

    private static /* synthetic */ int coc(int n, int n2) {
        return n - n2 ^ 0x3D5143CB;
    }

    private static /* synthetic */ int cod(int n, int n2) {
        return n * n2 | 0x7E2EA3B;
    }
}

