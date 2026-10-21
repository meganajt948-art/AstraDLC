/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.awt.Color;

public final class ColorUtil {
    private static /* synthetic */ String uju;
    private static /* synthetic */ boolean ujv;

    private ColorUtil() {
    }

    public static int alpha(int n) {
        return n >>> 24 & 0xFF;
    }

    public static int mulAlpha(int n, float f) {
        int n2 = Math.round((float)ColorUtil.alpha(n) * Math.max(0.0f, Math.min(1.0f, f)));
        return n2 << 24 | n & 0xFFFFFF;
    }

    public static int withAlpha(int n, int n2) {
        return Math.max(0, Math.min(255, n2)) << 24 | n & 0xFFFFFF;
    }

    public static int lerp(int n, int n2, float f) {
        f = Math.max(0.0f, Math.min(1.0f, f));
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >> 16 & 0xFF;
        int n5 = n >> 8 & 0xFF;
        int n6 = n & 0xFF;
        int n7 = n2 >>> 24 & 0xFF;
        int n8 = n2 >> 16 & 0xFF;
        int n9 = n2 >> 8 & 0xFF;
        int n10 = n2 & 0xFF;
        return Math.round((float)n3 + (float)(n7 - n3) * f) << 24 | Math.round((float)n4 + (float)(n8 - n4) * f) << 16 | Math.round((float)n5 + (float)(n9 - n5) * f) << 8 | Math.round((float)n6 + (float)(n10 - n6) * f);
    }

    public static int hsv(float f, float f2, float f3) {
        return 0xFF000000 | Color.HSBtoRGB(f, Math.max(0.0f, Math.min(1.0f, f2)), Math.max(0.0f, Math.min(1.0f, f3))) & 0xFFFFFF;
    }

    public static float luminance(int n) {
        return (0.2126f * (float)(n >> 16 & 0xFF) + 0.7152f * (float)(n >> 8 & 0xFF) + 0.0722f * (float)(n & 0xFF)) / 255.0f;
    }

    public static int shade(int n, float f) {
        int n2 = Math.min(255, Math.round((float)(n >> 16 & 0xFF) * f));
        int n3 = Math.min(255, Math.round((float)(n >> 8 & 0xFF) * f));
        int n4 = Math.min(255, Math.round((float)(n & 0xFF) * f));
        return n & 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    private static /* synthetic */ int cxo(int n, int n2) {
        return n * n2 ^ 0x6C2C6C0F;
    }

    private static /* synthetic */ int cxp(int n, int n2) {
        return ColorUtil.cxo(n, n2) ^ 0x89ADBEB5;
    }

    private static /* synthetic */ int cxq(int n, int n2) {
        return (n ^ n2) + -562999069;
    }
}

