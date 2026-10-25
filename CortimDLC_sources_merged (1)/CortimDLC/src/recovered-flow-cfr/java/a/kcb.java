/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.kce;
import a.uut;
import a.vcq;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.gui.DrawContext;

public final class kcb {
    private static /* synthetic */ int kcc;
    private static /* synthetic */ String kcd;

    private kcb() {
    }

    public static void draw(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        uut.arc(drawContext, f, f2, f3, f4, 0.0f, 1.0f, kce.rgba(0xFFFFFF, 0.13f));
        float f7 = f5 * 1.05f + 0.04f * (float)Math.sin(f5 * 2.4f);
        float f8 = 0.2f + 0.14f * (0.5f + 0.5f * (float)Math.sin(f5 * 2.4f - 0.6f));
        float f9 = vcq.inOutCubic(f6);
        f8 += (1.0f - f8) * f9;
        int n2 = kce.rgba(n, 1.0f);
        int n3 = kce.rgba(0xFFFFFF, 1.0f);
        uut.arc(drawContext, f, f2, f3, f4, f7 - f8, f8, n2, n3, n3, n2);
        if (gpuTextureView != null) {
            uut.additive(true);
            float f10 = 0.35f + 0.5f * (1.0f - Math.abs(f6 * 2.0f - 1.0f)) * (f6 > 0.0f ? 1.0f : 0.0f);
            uut.sprite(drawContext, gpuTextureView, f, f2, f3 * 5.0f, kce.rgba(n, 0.18f * f10 + 0.06f));
            double d = (double)(f7 % 1.0f) * Math.PI * 2.0;
            float f11 = f + (float)Math.sin(d) * (f3 - f4 * 0.5f);
            float f12 = f2 - (float)Math.cos(d) * (f3 - f4 * 0.5f);
            uut.sprite(drawContext, gpuTextureView, f11, f12, f4 * 7.0f, kce.rgba(0xFFFFFF, 0.55f * (1.0f - f9)));
            uut.additive(false);
        }
    }

    private static /* synthetic */ int aru(int n, int n2) {
        return n + n2 | 0x395F6D4D;
    }
}

