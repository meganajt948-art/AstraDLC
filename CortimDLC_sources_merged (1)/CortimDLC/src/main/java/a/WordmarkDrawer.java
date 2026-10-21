/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_332
 */
package a;

import a.WordmarkAnimator;
import a.DrawUtil;
import a.Easing;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_332;

public final class WordmarkDrawer {
    private static /* synthetic */ int kcc;
    private static /* synthetic */ String kcd;

    private WordmarkDrawer() {
    }

    public static void draw(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        DrawUtil.arc(class_3322, f, f2, f3, f4, 0.0f, 1.0f, WordmarkAnimator.rgba(0xFFFFFF, 0.13f));
        float f7 = f5 * 1.05f + 0.04f * (float)Math.sin(f5 * 2.4f);
        float f8 = 0.2f + 0.14f * (0.5f + 0.5f * (float)Math.sin(f5 * 2.4f - 0.6f));
        float f9 = Easing.inOutCubic(f6);
        f8 += (1.0f - f8) * f9;
        int n2 = WordmarkAnimator.rgba(n, 1.0f);
        int n3 = WordmarkAnimator.rgba(0xFFFFFF, 1.0f);
        DrawUtil.arc(class_3322, f, f2, f3, f4, f7 - f8, f8, n2, n3, n3, n2);
        if (gpuTextureView != null) {
            DrawUtil.additive(true);
            float f10 = 0.35f + 0.5f * (1.0f - Math.abs(f6 * 2.0f - 1.0f)) * (f6 > 0.0f ? 1.0f : 0.0f);
            DrawUtil.sprite(class_3322, gpuTextureView, f, f2, f3 * 5.0f, WordmarkAnimator.rgba(n, 0.18f * f10 + 0.06f));
            double d = (double)(f7 % 1.0f) * Math.PI * 2.0;
            float f11 = f + (float)Math.sin(d) * (f3 - f4 * 0.5f);
            float f12 = f2 - (float)Math.cos(d) * (f3 - f4 * 0.5f);
            DrawUtil.sprite(class_3322, gpuTextureView, f11, f12, f4 * 7.0f, WordmarkAnimator.rgba(0xFFFFFF, 0.55f * (1.0f - f9)));
            DrawUtil.additive(false);
        }
    }

    private static /* synthetic */ int aru(int n, int n2) {
        return n + n2 | 0x395F6D4D;
    }
}

