/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.OptionOverride;

public final class OverrideHandle {
    private static final OptionOverride<Double> vya = new OptionOverride(class_3102 -> class_3102.field_1690.method_42473());
    private static /* synthetic */ int vyb;
    private static /* synthetic */ boolean vyc;

    private OverrideHandle() {
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
        return OverrideHandle.dmf(n, n2) + n;
    }
}

