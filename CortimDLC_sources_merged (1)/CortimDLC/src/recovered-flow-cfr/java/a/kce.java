/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gui.DrawContext
 *  org.joml.Matrix3x2fStack
 */
package a;

import a.unf;
import a.uut;
import a.vcq;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.splash.Wordmark;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

public final class kce {
    private static final int kcf = 14;
    private final float kcg;
    private Wordmark kch;
    private final List<Wordmark> kci = new ArrayList<Wordmark>();
    private final List<Long> kcj = new ArrayList<Long>();
    private static final List<Wordmark> kck = new ArrayList<Wordmark>();
    private static final List<Long> kcl = new ArrayList<Long>();
    private static /* synthetic */ long kcm;
    private static /* synthetic */ int kcn;

    public kce(float f) {
        this.kcg = f;
    }

    public float width(float f) {
        return this.kcr((float)f).width;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void draw(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        this.kcs();
        Wordmark wordmark = this.kcr(f4 * f3);
        Matrix3x2fStack matrix3x2fStack = drawContext.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f, f2);
        matrix3x2fStack.scale(f3, f3);
        try {
            float f9 = -wordmark.width * 0.5f;
            float f10 = wordmark.cap * 0.5f;
            float f11 = -f7 * 0.33f;
            float f12 = 0.42f - f8 * 0.12f;
            float f13 = this.kcg / 34.0f;
            if (gpuTextureView != null) {
                uut.additive(true);
                float f14 = vcq.clamp01(f6 * 1.4f - 0.3f);
                float f15 = 0.85f + 0.15f * (float)Math.sin(f5 * 1.3f);
                uut.image(drawContext, gpuTextureView, -wordmark.width * 0.8f, -wordmark.cap * 2.2f, wordmark.width * 1.6f, wordmark.cap * 4.4f, 0.0f, kce.rgba(n, 0.2f * f14 * f15));
                uut.additive(false);
            }
            int n2 = kce.mix(n, 659226, 0.62f);
            int n3 = kce.mix(n, 329484, 0.86f);
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < wordmark.glyphs.length; ++j) {
                    Wordmark.Glyph glyph = wordmark.glyphs[j];
                    float f16 = kce.kco(j, wordmark.glyphs.length, f6);
                    if (f16 <= 0.0f) continue;
                    float f17 = vcq.clamp01(f16 * 2.2f);
                    matrix3x2fStack.pushMatrix();
                    kce.kcp(matrix3x2fStack, glyph, j, f16, f9, f10, f5);
                    float f18 = glyph.x() - glyph.cx();
                    float f19 = glyph.y() - glyph.cy();
                    switch (i) {
                        case 0: {
                            uut.image(drawContext, glyph.soft().view, f18 + f11 * 14.0f * f13 * 1.6f, f19 + f12 * 14.0f * f13 * 1.9f, glyph.w(), glyph.h(), 0.0f, kce.rgba(0, 0.55f * f17));
                            break;
                        }
                        case 1: {
                            for (int k = 14; k >= 1; --k) {
                                int n4 = kce.mix(n2, n3, (float)k / 14.0f);
                                uut.image(drawContext, glyph.sharp().view, f18 + f11 * (float)k * f13, f19 + f12 * (float)k * f13, glyph.w(), glyph.h(), 0.0f, kce.rgba(n4, f17));
                            }
                            break;
                        }
                        case 2: {
                            int n5 = glyph.second() ? kce.mix(0xFFFFFF, n, 0.5f) : 0xFFFFFF;
                            uut.image(drawContext, glyph.sharp().view, f18, f19, glyph.w(), glyph.h(), 0.0f, kce.rgba(n5, f17));
                            break;
                        }
                        default: {
                            float f20 = kce.kcq(glyph.cx() / wordmark.width, f5);
                            if (!(f20 > 0.01f)) break;
                            uut.additive(true);
                            uut.image(drawContext, glyph.sharp().view, f18, f19, glyph.w(), glyph.h(), 0.0f, kce.rgba(0xFFFFFF, f20 * f17));
                            uut.additive(false);
                        }
                    }
                    matrix3x2fStack.popMatrix();
                }
            }
        }
        finally {
            uut.additive(false);
            matrix3x2fStack.popMatrix();
        }
    }

    private static float kco(int n, int n2, float f) {
        float f2 = 0.55f;
        float f3 = (float)n / (float)Math.max(1, n2 - 1) * (1.0f - f2);
        return vcq.clamp01((f - f3) / f2);
    }

    private static void kcp(Matrix3x2fStack matrix3x2fStack, Wordmark.Glyph glyph, int n, float f, float f2, float f3, float f4) {
        float f5 = -(1.0f - vcq.outBack(f)) * 26.0f;
        float f6 = (1.0f - vcq.outCubic(f)) * (n % 2 == 0 ? -0.35f : 0.28f);
        float f7 = 1.0f + 0.35f * (1.0f - vcq.outCubic(f));
        float f8 = (float)Math.sin(f4 * 1.6f + (float)n * 0.55f) * 0.9f * vcq.clamp01(f * 3.0f - 2.0f);
        matrix3x2fStack.translate(f2 + glyph.cx(), f3 + glyph.cy() + f5 + f8);
        matrix3x2fStack.rotate(f6);
        matrix3x2fStack.scale(f7, f7);
    }

    private static float kcq(float f, float f2) {
        float f3 = f2 % 5.5f / 1.6f;
        if (f3 > 1.0f) {
            return 0.0f;
        }
        float f4 = (f - (-0.2f + 1.4f * f3)) / 0.09f;
        return 0.55f * (float)Math.exp(-f4 * f4);
    }

    private Wordmark kcr(float f) {
        int n = Math.max(12, Math.round(this.kcg * f));
        if (this.kch != null && this.kch.px == n) {
            return this.kch;
        }
        if (this.kch != null) {
            this.kci.add(this.kch);
            this.kcj.add(unf.frame());
        }
        this.kch = Wordmark.build(this.kcg, f, true);
        return this.kch;
    }

    private void kcs() {
        long l = unf.frame();
        for (int i = this.kci.size() - 1; i >= 0; --i) {
            if (l - this.kcj.get(i) <= 3L) continue;
            this.kci.remove(i).close();
            this.kcj.remove(i);
        }
    }

    public void close() {
        if (this.kch != null) {
            this.kci.add(this.kch);
            this.kcj.add(unf.frame());
            this.kch = null;
        }
        kck.addAll(this.kci);
        kcl.addAll(this.kcj);
        this.kci.clear();
        this.kcj.clear();
    }

    public static void collectClosed() {
        long l = unf.frame();
        for (int i = kck.size() - 1; i >= 0; --i) {
            if (l - kcl.get(i) <= 3L) continue;
            kck.remove(i).close();
            kcl.remove(i);
        }
    }

    public static int mix(int n, int n2, float f) {
        int n3 = Math.round((float)(n >> 16 & 0xFF) + (float)((n2 >> 16 & 0xFF) - (n >> 16 & 0xFF)) * f);
        int n4 = Math.round((float)(n >> 8 & 0xFF) + (float)((n2 >> 8 & 0xFF) - (n >> 8 & 0xFF)) * f);
        int n5 = Math.round((float)(n & 0xFF) + (float)((n2 & 0xFF) - (n & 0xFF)) * f);
        return n3 << 16 | n4 << 8 | n5;
    }

    static int rgba(int n, float f) {
        int n2 = Math.max(0, Math.min(255, Math.round(f * 255.0f)));
        return n2 << 24 | n & 0xFFFFFF;
    }

    private static /* synthetic */ int arx(int n, int n2) {
        return n - n2 | 0x296AED0C;
    }

    private static /* synthetic */ int ary(int n, int n2) {
        return kce.arx(n, n2) * n2;
    }
}

