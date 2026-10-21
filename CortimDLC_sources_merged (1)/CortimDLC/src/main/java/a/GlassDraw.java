/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ColorUtil;
import a.DrawUtil;
import net.minecraft.class_332;

public final class GlassDraw {
    public static boolean enabled = true;
    private static /* synthetic */ long ukg;
    private static /* synthetic */ boolean ukh;

    private GlassDraw() {
    }

    public static void shadow(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!enabled) {
            return;
        }
        float f8 = 1.0f - 0.55f * f7;
        DrawUtil.shadow(class_3322, f, f2 + 0.6f + 0.3f * f6, f3, f4, f5, 1.6f + 0.6f * f6, ColorUtil.withAlpha(0, Math.round((70.0f + 12.0f * f6) * f8)));
        DrawUtil.shadow(class_3322, f, f2 + 2.0f + 2.2f * f6, f3, f4, f5, 7.0f + 5.0f * f6, ColorUtil.withAlpha(0, Math.round((34.0f + 16.0f * f6) * f8)));
    }

    public static void rim(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!enabled) {
            return;
        }
        int n = ColorUtil.withAlpha(0xFFFFFF, Math.round(Math.min(255.0f, (44.0f + 150.0f * f6) * f7)));
        int n2 = f6 > 0.5f ? ColorUtil.withAlpha(0, Math.round(26.0f * f7)) : ColorUtil.withAlpha(0xFFFFFF, Math.round(7.0f * f7));
        DrawUtil.outlineGradientV(class_3322, f, f2, f3, f4, f5, 1.0f, n, n2);
    }

    public static void sheen(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!enabled) {
            return;
        }
        float f7 = Math.min(f4, Math.max(f5 * 2.0f, f4 * 0.55f));
        int n = ColorUtil.withAlpha(0xFFFFFF, Math.round(14.0f * f6));
        DrawUtil.gradient(class_3322, f, f2, f3, f7, f5, f5, 0.0f, 0.0f, n, n, 0xFFFFFF, 0xFFFFFF);
    }

    public static void inset(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!enabled) {
            return;
        }
        int n = ColorUtil.withAlpha(0, Math.round(70.0f - 40.0f * f6));
        DrawUtil.outlineGradientV(class_3322, f, f2, f3, f4, f5, 1.0f, n, 0);
    }

    private static /* synthetic */ int cxy(int n, int n2) {
        return n * n2 + -1854293520;
    }

    private static /* synthetic */ int cxz(int n, int n2) {
        return GlassDraw.cxy(n, n2) + n;
    }

    private static /* synthetic */ int cya(int n, int n2) {
        return GlassDraw.cxy(n, n2) * n2;
    }
}

