/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class vcq {
    private static /* synthetic */ long vcr;
    private static /* synthetic */ boolean vcs;

    private vcq() {
    }

    public static float clamp01(float f) {
        return f < 0.0f ? 0.0f : (f > 1.0f ? 1.0f : f);
    }

    public static float outCubic(float f) {
        f = vcq.clamp01(f);
        float f2 = 1.0f - f;
        return 1.0f - f2 * f2 * f2;
    }

    public static float inCubic(float f) {
        f = vcq.clamp01(f);
        return f * f * f;
    }

    public static float inOutCubic(float f) {
        return (f = vcq.clamp01(f)) < 0.5f ? 4.0f * f * f * f : 1.0f - (float)Math.pow(-2.0f * f + 2.0f, 3.0) / 2.0f;
    }

    public static float outQuint(float f) {
        f = vcq.clamp01(f);
        float f2 = 1.0f - f;
        return 1.0f - f2 * f2 * f2 * f2 * f2;
    }

    public static float outExpo(float f) {
        return (f = vcq.clamp01(f)) >= 1.0f ? 1.0f : 1.0f - (float)Math.pow(2.0, -10.0f * f);
    }

    public static float outBack(float f) {
        f = vcq.clamp01(f);
        float f2 = 1.70158f;
        float f3 = f2 + 1.0f;
        float f4 = f - 1.0f;
        return 1.0f + f3 * f4 * f4 * f4 + f2 * f4 * f4;
    }

    private static /* synthetic */ int dcw(int n, int n2) {
        return (n ^ n2) + -787974745;
    }
}

