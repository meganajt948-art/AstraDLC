/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class kbp {
    public static final float MIN_W = 330.0f;
    public static final float MIN_H = 270.0f;
    private static /* synthetic */ int kbq;
    private static /* synthetic */ long kbr;

    private kbp() {
    }

    public static float scale(int n, int n2) {
        return Math.max(0.05f, Math.min(1.0f, Math.min((float)n / 330.0f, (float)n2 / 270.0f)));
    }

    private static /* synthetic */ int arn(int n, int n2) {
        return n * n2 + 883834841;
    }

    private static /* synthetic */ int aro(int n, int n2) {
        return n + n2 ^ 0x2D161DA1;
    }
}

