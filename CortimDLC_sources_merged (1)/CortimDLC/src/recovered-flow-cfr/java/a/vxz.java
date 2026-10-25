/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.wbu;

public final class vxz {
    private static final wbu<Double> vya = new wbu(minecraftClient -> minecraftClient.options.getGamma());
    private static /* synthetic */ int vyb;
    private static /* synthetic */ boolean vyc;

    private vxz() {
    }

    public static boolean override(double d) {
        return vya.override(d);
    }

    public static void release() {
        vya.release();
    }

    public static double own() {
        Double d = vya.own();
        return d == null ? 0.5 : Math.max(0.0, Math.min(1.0, d));
    }

    private static /* synthetic */ int dmf(int n, int n2) {
        return n * n2 ^ 0x64AE265B;
    }

    private static /* synthetic */ int dmg(int n, int n2) {
        return vxz.dmf(n, n2) + n;
    }
}

