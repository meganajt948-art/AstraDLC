/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.ujt;
import a.uut;
import net.minecraft.client.gui.DrawContext;

public final class ukf {
    public static boolean enabled = true;
    private static /* synthetic */ long ukg;
    private static /* synthetic */ boolean ukh;

    private ukf() {
    }

    public static void shadow(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!enabled) {
            return;
        }
        float f8 = 1.0f - 0.55f * f7;
        uut.shadow(drawContext, f, f2 + 0.6f + 0.3f * f6, f3, f4, f5, 1.6f + 0.6f * f6, ujt.withAlpha(0, Math.round((70.0f + 12.0f * f6) * f8)));
        uut.shadow(drawContext, f, f2 + 2.0f + 2.2f * f6, f3, f4, f5, 7.0f + 5.0f * f6, ujt.withAlpha(0, Math.round((34.0f + 16.0f * f6) * f8)));
    }

    public static void rim(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!enabled) {
            return;
        }
        int n = ujt.withAlpha(0xFFFFFF, Math.round(Math.min(255.0f, (44.0f + 150.0f * f6) * f7)));
        int n2 = f6 > 0.5f ? ujt.withAlpha(0, Math.round(26.0f * f7)) : ujt.withAlpha(0xFFFFFF, Math.round(7.0f * f7));
        uut.outlineGradientV(drawContext, f, f2, f3, f4, f5, 1.0f, n, n2);
    }

    public static void sheen(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!enabled) {
            return;
        }
        float f7 = Math.min(f4, Math.max(f5 * 2.0f, f4 * 0.55f));
        int n = ujt.withAlpha(0xFFFFFF, Math.round(14.0f * f6));
        uut.gradient(drawContext, f, f2, f3, f7, f5, f5, 0.0f, 0.0f, n, n, 0xFFFFFF, 0xFFFFFF);
    }

    public static void inset(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!enabled) {
            return;
        }
        int n = ujt.withAlpha(0, Math.round(70.0f - 40.0f * f6));
        uut.outlineGradientV(drawContext, f, f2, f3, f4, f5, 1.0f, n, 0);
    }

    private static /* synthetic */ int cxy(int n, int n2) {
        return n * n2 + -1854293520;
    }

    private static /* synthetic */ int cxz(int n, int n2) {
        return ukf.cxy(n, n2) + n;
    }

    private static /* synthetic */ int cya(int n, int n2) {
        return ukf.cxy(n, n2) * n2;
    }
}

