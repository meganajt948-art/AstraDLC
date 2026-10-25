/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gl.GpuSampler
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.gui.render.state.GuiRenderState
 *  net.minecraft.client.gui.render.state.SimpleGuiElementRenderState
 *  net.minecraft.client.texture.TextureSetup
 *  net.minecraft.util.math.MathHelper
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fStack
 *  org.joml.Matrix3x2fc
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.uhx;
import a.uij;
import a.uoy;
import a.urt;
import a.utf;
import a.utx;
import a.uvq;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import org.jspecify.annotations.Nullable;

public final class uut {
    private static final ScreenRect uuu = new ScreenRect(0, 0, 0, 0);
    private static final Deque<ScreenRect> uuv = new ArrayDeque<ScreenRect>();
    private static final Deque<Float> uuw = new ArrayDeque<Float>();
    private static float uux = 1.0f;
    private static boolean uuy;
    private static Field uuz;
    private static boolean uva;
    private static @Nullable DrawContext uvb;
    private static @Nullable GuiRenderState uvc;
    private static final List<uhx> uvd;
    private static int uve;
    private static @Nullable GuiRenderState uvf;
    public static final int COSMOS = 0;
    public static final int WINTER = 1;
    public static final int LAVA = 2;
    public static final int AURORA = 3;
    public static final int OCEAN = 4;
    public static final int NEON = 5;
    public static final int SAKURA = 6;
    public static final int PLAIN = 7;
    public static final int FACE = 1;
    public static final int DISC = 2;
    private static /* synthetic */ long uvg;
    private static /* synthetic */ int uvh;

    private uut() {
    }

    public static void beginBatch() {
        ++uve;
    }

    public static void endBatch() {
        if (uve > 0 && --uve == 0) {
            uut.uvj();
        }
    }

    private static void uvi(GuiRenderState guiRenderState, SimpleGuiElementRenderState simpleGuiElementRenderState) {
        if (uve == 0) {
            guiRenderState.method_70919(simpleGuiElementRenderState);
            return;
        }
        if (uvf != guiRenderState) {
            uut.uvj();
            uvf = guiRenderState;
        }
        int n = uvd.size();
        for (int i = 0; i < n; ++i) {
            uhx uhx2 = uvd.get(i);
            if (!uhx2.accepts(simpleGuiElementRenderState)) continue;
            uhx2.add(simpleGuiElementRenderState);
            return;
        }
        uvd.add(new uhx(simpleGuiElementRenderState));
    }

    private static void uvj() {
        GuiRenderState guiRenderState = uvf;
        if (guiRenderState != null) {
            for (uhx uhx2 : uvd) {
                if (uhx2.isEmpty()) continue;
                guiRenderState.method_70919((SimpleGuiElementRenderState)uhx2);
            }
        }
        uvd.clear();
        uvf = null;
    }

    public static void pushAlpha(float f) {
        uuw.push(Float.valueOf(uux));
        uux *= MathHelper.method_15363((float)f, (float)0.0f, (float)1.0f);
    }

    public static void popAlpha() {
        uux = uuw.isEmpty() ? 1.0f : uuw.pop().floatValue();
    }

    public static float alpha() {
        return uux;
    }

    public static int fade(int n) {
        if (uux >= 0.999f) {
            return n;
        }
        int n2 = Math.round((float)(n >>> 24 & 0xFF) * uux);
        return n2 << 24 | n & 0xFFFFFF;
    }

    public static void pushScissor(DrawContext drawContext, float f, float f2, float f3, float f4) {
        int n = MathHelper.method_15375((float)f);
        int n2 = MathHelper.method_15375((float)f2);
        int n3 = MathHelper.method_15386((float)(f + f3));
        int n4 = MathHelper.method_15386((float)(f2 + f4));
        ScreenRect screenRect = new ScreenRect(n, n2, Math.max(0, n3 - n), Math.max(0, n4 - n2)).method_71523((Matrix3x2fc)drawContext.method_51448());
        ScreenRect screenRect2 = uuv.peek();
        ScreenRect screenRect3 = screenRect2 == null ? screenRect : screenRect2.method_49701(screenRect);
        uuv.push(screenRect3 == null ? uuu : screenRect3);
        drawContext.method_44379(n, n2, n3, n4);
    }

    public static void popScissor(DrawContext drawContext) {
        if (!uuv.isEmpty()) {
            uuv.pop();
            drawContext.method_44380();
        }
    }

    public static @Nullable ScreenRect scissor() {
        return uuv.peek();
    }

    public static void beginFrame() {
        if (uve > 0) {
            uve = 0;
            uut.uvj();
        }
        uuv.clear();
        uuw.clear();
        uux = 1.0f;
        uuy = false;
    }

    public static void additive(boolean bl) {
        uuy = bl;
    }

    public static void sprite(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, int n) {
        uut.image(drawContext, gpuTextureView, f - f3 * 0.5f, f2 - f3 * 0.5f, f3, f3, 0.0f, n);
    }

    public static void rect(DrawContext drawContext, float f, float f2, float f3, float f4, int n) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, 0.0f, 0.0f, 0.0f, 0.0f, n, n, n, n, 0.0f, 0.0f);
    }

    public static void round(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, 0.0f, 0.0f);
    }

    public static void round(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f6, f7, f8, n, n, n, n, 0.0f, 0.0f);
    }

    public static void gradient(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, int n4) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n2, n3, n4, 0.0f, 0.0f);
    }

    public static void gradient(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f6, f7, f8, n, n2, n3, n4, 0.0f, 0.0f);
    }

    public static void gradientH(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        uut.gradient(drawContext, f, f2, f3, f4, f5, n, n2, n2, n);
    }

    public static void gradientV(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        uut.gradient(drawContext, f, f2, f3, f4, f5, n, n, n2, n2);
    }

    public static void outline(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, 0.0f, Math.max(0.05f, f6));
    }

    public static void outlineGradientH(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n2, n2, n, 0.0f, Math.max(0.05f, f6));
    }

    public static void outlineGradientV(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n, n2, n2, 0.0f, Math.max(0.05f, f6));
    }

    public static boolean arc(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        if (f6 <= 5.0E-4f || f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        int n8 = uut.fade(n);
        if ((n8 | (n7 = uut.fade(n2)) | (n6 = uut.fade(n3)) | (n5 = uut.fade(n4))) >>> 24 == 0) {
            return true;
        }
        if (!uvq.ensure(uvq.ARC)) {
            return false;
        }
        float f7 = f5 - (float)Math.floor(f5);
        int n9 = Math.round(f7 * 65535.0f) & 0xFFFF;
        int n10 = Math.round(Math.min(1.0f, f6) * 65535.0f) & 0xFFFF;
        return uut.uvo(drawContext, uvq.ARC, TextureSetup.method_70899(), f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, n9, n10, n8, n7, n6, n5, 0.0f, utx.pad(0.0f), f4);
    }

    public static boolean arc(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        return uut.arc(drawContext, f, f2, f3, f4, f5, f6, n, n, n, n);
    }

    public static void shadow(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        uut.uvl(drawContext, uvq.RECT, TextureSetup.method_70899(), f, f2, f3, f4, f5 + f6 * 0.5f, f5 + f6 * 0.5f, f5 + f6 * 0.5f, f5 + f6 * 0.5f, n, n, n, n, Math.max(0.5f, f6), 0.0f);
    }

    public static void line(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n) {
        uut.uvk(drawContext, f, f2, f3, f4, f5, 0.0f, n);
    }

    public static void softLine(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        uut.uvk(drawContext, f, f2, f3, f4, f5, Math.max(0.5f, f6), n);
    }

    private static void uvk(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        RenderPipeline renderPipeline;
        float f7 = f3 - f;
        float f8 = f4 - f2;
        float f9 = (float)Math.sqrt(f7 * f7 + f8 * f8);
        float f10 = f5 * 0.5f;
        int n2 = uut.fade(n);
        if (n2 >>> 24 == 0) {
            return;
        }
        RenderPipeline renderPipeline2 = renderPipeline = uuy ? uvq.RECT_ADD : uvq.RECT;
        if (uvq.ensure(renderPipeline)) {
            Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)drawContext.method_51448()).translate(f, f2);
            if (f9 > 0.001f) {
                matrix3x2f.rotate((float)Math.atan2(f8, f7));
            }
            float f11 = f6 > 0.0f ? Math.max(0.5f, f6) : 0.0f;
            float f12 = f10 + f11 * 0.5f;
            uut.uvn(drawContext, matrix3x2f, renderPipeline, TextureSetup.method_70899(), -f10, -f10, f9 + f5, f5, f12, f12, f12, f12, n2, n2, n2, n2, f11, utx.pad(f11), 0.0f);
            return;
        }
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f, f2);
        if (f9 > 0.001f) {
            drawContext.method_51448().rotate((float)Math.atan2(f8, f7));
        }
        if (f6 > 0.0f) {
            uut.shadow(drawContext, -f10, -f10, f9 + f5, f5, f10, f6, n);
        } else {
            uut.round(drawContext, -f10, -f10, f9 + f5, f5, f10, n);
        }
        drawContext.method_51448().popMatrix();
    }

    public static void circle(DrawContext drawContext, float f, float f2, float f3, int n) {
        uut.round(drawContext, f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, f3, n);
    }

    public static void circleOutline(DrawContext drawContext, float f, float f2, float f3, float f4, int n) {
        uut.outline(drawContext, f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, f3, f4, n);
    }

    public static boolean glass(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        return uut.glass(drawContext, uij.SCENE.result(drawContext), f, f2, f3, f4, f5, n, f6);
    }

    public static boolean glass(DrawContext drawContext, @Nullable GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        if (gpuTextureView == null) {
            return false;
        }
        float f7 = MathHelper.method_15363((float)(f6 * uux), (float)0.0f, (float)1.0f);
        if (f7 <= 0.002f || f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        if (!uvq.ensure(uvq.GLASS)) {
            return false;
        }
        TextureSetup textureSetup = TextureSetup.method_70900((GpuTextureView)gpuTextureView, (GpuSampler)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        return uut.uvm(drawContext, uvq.GLASS, textureSetup, f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, 0.0f, utx.pad(0.0f), f7);
    }

    public static boolean liquid(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, float f6, uoy uoy2) {
        return uut.liquid(drawContext, uij.SCENE.result(drawContext), f, f2, f3, f4, f5, n, f6, uoy2);
    }

    public static boolean liquid(DrawContext drawContext, @Nullable GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n, float f6, uoy uoy2) {
        if (gpuTextureView == null) {
            return false;
        }
        float f7 = MathHelper.method_15363((float)(f6 * uux), (float)0.0f, (float)1.0f);
        if (f7 <= 0.004f || f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        if (!uvq.ensure(uvq.LIQUID)) {
            return uut.glass(drawContext, gpuTextureView, f, f2, f3, f4, f5, n, f6);
        }
        TextureSetup textureSetup = TextureSetup.method_70900((GpuTextureView)gpuTextureView, (GpuSampler)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        float f8 = Math.min(f3, f4) * 0.5f;
        return uut.uvm(drawContext, uvq.LIQUID, textureSetup, f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, uoy2.packShape(f8), utx.pad(0.0f), uoy2.packLight(f7));
    }

    public static void image(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n) {
        RenderPipeline renderPipeline;
        int n2 = uut.fade(n);
        RenderPipeline renderPipeline2 = renderPipeline = uuy ? uvq.IMAGE_ADD : uvq.IMAGE;
        if (n2 >>> 24 == 0 || f3 <= 0.0f || f4 <= 0.0f || !uvq.ensure(renderPipeline)) {
            return;
        }
        TextureSetup textureSetup = TextureSetup.method_70900((GpuTextureView)gpuTextureView, (GpuSampler)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        uut.uvm(drawContext, renderPipeline, textureSetup, f, f2, f3, f4, f5, f5, f5, f5, n2, n2, n2, n2, 0.0f, utx.pad(0.0f), 0.0f);
    }

    public static void imageRegion(DrawContext drawContext, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, boolean bl) {
        int n2 = uut.fade(n);
        if (n2 >>> 24 == 0 || f3 <= 0.0f || f4 <= 0.0f || !uvq.ensure(uvq.IMAGE)) {
            return;
        }
        int n3 = Math.max(0, Math.min(4095, Math.round(f6 * 4095.0f)));
        int n4 = Math.max(0, Math.min(4095, Math.round(f7 * 4095.0f)));
        int n5 = Math.max(1, Math.min(4095, Math.round((f8 - f6) * 4095.0f)));
        int n6 = Math.max(1, Math.min(4095, Math.round((f9 - f7) * 4095.0f)));
        TextureSetup textureSetup = TextureSetup.method_70900((GpuTextureView)gpuTextureView, (GpuSampler)RenderSystem.getSamplerCache().method_75294(bl ? FilterMode.NEAREST : FilterMode.LINEAR));
        uut.uvm(drawContext, uvq.IMAGE, textureSetup, f, f2, f3, f4, f5, f5, f5, f5, n2, n2, n2, n2, n3 << 12 | n4, utx.pad(0.0f), n5 << 12 | n6);
    }

    public static void quad(DrawContext drawContext, float f, float f2, int n, float f3, float f4, int n2, float f5, float f6, int n3, float f7, float f8, int n4) {
        int n5;
        int n6;
        int n7;
        int n8 = uut.fade(n);
        if ((n8 | (n7 = uut.fade(n2)) | (n6 = uut.fade(n3)) | (n5 = uut.fade(n4))) >>> 24 == 0) {
            return;
        }
        RenderPipeline renderPipeline = uuy ? uvq.QUAD_ADD : uvq.QUAD;
        GuiRenderState guiRenderState = uut.state(drawContext);
        if (guiRenderState == null || !uvq.ensure(renderPipeline)) {
            return;
        }
        Matrix3x2fStack matrix3x2fStack = drawContext.method_51448();
        float f9 = matrix3x2fStack.m00() * f + matrix3x2fStack.m10() * f2 + matrix3x2fStack.m20();
        float f10 = matrix3x2fStack.m01() * f + matrix3x2fStack.m11() * f2 + matrix3x2fStack.m21();
        float f11 = matrix3x2fStack.m00() * f3 + matrix3x2fStack.m10() * f4 + matrix3x2fStack.m20();
        float f12 = matrix3x2fStack.m01() * f3 + matrix3x2fStack.m11() * f4 + matrix3x2fStack.m21();
        float f13 = matrix3x2fStack.m00() * f5 + matrix3x2fStack.m10() * f6 + matrix3x2fStack.m20();
        float f14 = matrix3x2fStack.m01() * f5 + matrix3x2fStack.m11() * f6 + matrix3x2fStack.m21();
        float f15 = matrix3x2fStack.m00() * f7 + matrix3x2fStack.m10() * f8 + matrix3x2fStack.m20();
        float f16 = matrix3x2fStack.m01() * f7 + matrix3x2fStack.m11() * f8 + matrix3x2fStack.m21();
        int n9 = MathHelper.method_15375((float)Math.min(Math.min(f9, f11), Math.min(f13, f15)));
        int n10 = MathHelper.method_15375((float)Math.min(Math.min(f10, f12), Math.min(f14, f16)));
        int n11 = MathHelper.method_15386((float)Math.max(Math.max(f9, f11), Math.max(f13, f15)));
        int n12 = MathHelper.method_15386((float)Math.max(Math.max(f10, f12), Math.max(f14, f16)));
        if (n11 <= n9 || n12 <= n10) {
            return;
        }
        ScreenRect screenRect = uuv.peek();
        ScreenRect screenRect2 = new ScreenRect(n9, n10, n11 - n9, n12 - n10);
        if (screenRect != null && (screenRect2 = screenRect.method_49701(screenRect2)) == null) {
            return;
        }
        uut.uvi(guiRenderState, new utf(renderPipeline, f9, f10, f11, f12, f13, f14, f15, f16, n8, n7, n6, n5, screenRect, screenRect2));
    }

    public static void pattern(DrawContext drawContext, float[] fArray, int n, int n2, int n3, int n4, float f, float f2) {
        int n5;
        int n6;
        int n7 = uut.fade(n3);
        if (n7 >>> 24 == 0) {
            return;
        }
        RenderPipeline renderPipeline = uuy ? uvq.PATTERN_ADD : uvq.PATTERN;
        GuiRenderState guiRenderState = uut.state(drawContext);
        if (guiRenderState == null || !uvq.ensure(renderPipeline)) {
            return;
        }
        Matrix3x2fStack matrix3x2fStack = drawContext.method_51448();
        float[] fArray2 = new float[20];
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MAX_VALUE;
        float f5 = -3.4028235E38f;
        float f6 = -3.4028235E38f;
        for (n6 = 0; n6 < 4; ++n6) {
            n5 = n6 * 5;
            float f7 = fArray[n5];
            float f8 = fArray[n5 + 1];
            float f9 = matrix3x2fStack.m00() * f7 + matrix3x2fStack.m10() * f8 + matrix3x2fStack.m20();
            float f10 = matrix3x2fStack.m01() * f7 + matrix3x2fStack.m11() * f8 + matrix3x2fStack.m21();
            fArray2[n5] = f9;
            fArray2[n5 + 1] = f10;
            fArray2[n5 + 2] = fArray[n5 + 2];
            fArray2[n5 + 3] = fArray[n5 + 3];
            fArray2[n5 + 4] = fArray[n5 + 4];
            f3 = Math.min(f3, f9);
            f4 = Math.min(f4, f10);
            f5 = Math.max(f5, f9);
            f6 = Math.max(f6, f10);
        }
        n6 = MathHelper.method_15375((float)f3);
        n5 = MathHelper.method_15375((float)f4);
        int n8 = MathHelper.method_15386((float)f5);
        int n9 = MathHelper.method_15386((float)f6);
        if (n8 <= n6 || n9 <= n5) {
            return;
        }
        ScreenRect screenRect = uuv.peek();
        ScreenRect screenRect2 = new ScreenRect(n6, n5, n8 - n6, n9 - n5);
        if (screenRect != null && (screenRect2 = screenRect.method_49701(screenRect2)) == null) {
            return;
        }
        float f11 = f2 % 3600.0f;
        uut.uvi(guiRenderState, new urt(renderPipeline, fArray2, n7, n4, n, n2, f, f11, screenRect, screenRect2));
    }

    private static boolean uvl(DrawContext drawContext, RenderPipeline renderPipeline, TextureSetup textureSetup, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, float f9, float f10) {
        int n5;
        int n6;
        int n7;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        int n8 = uut.fade(n);
        if ((n8 | (n7 = uut.fade(n2)) | (n6 = uut.fade(n3)) | (n5 = uut.fade(n4))) >>> 24 == 0) {
            return true;
        }
        if (uuy && renderPipeline == uvq.RECT) {
            if (!uvq.ensure(uvq.RECT_ADD)) {
                return false;
            }
            renderPipeline = uvq.RECT_ADD;
        }
        if (!uvq.ensure(renderPipeline)) {
            if (renderPipeline == uvq.RECT && f9 == 0.0f) {
                uut.uvp(drawContext, f, f2, f3, f4, n8, n5, f10);
            }
            return false;
        }
        return uut.uvm(drawContext, renderPipeline, textureSetup, f, f2, f3, f4, f5, f6, f7, f8, n8, n7, n6, n5, f9, utx.pad(f9), f10);
    }

    private static boolean uvm(DrawContext drawContext, RenderPipeline renderPipeline, TextureSetup textureSetup, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, float f9, float f10, float f11) {
        return uut.uvn(drawContext, null, renderPipeline, textureSetup, f, f2, f3, f4, f5, f6, f7, f8, n, n2, n3, n4, f9, f10, f11);
    }

    private static boolean uvn(DrawContext drawContext, @Nullable Matrix3x2f matrix3x2f, RenderPipeline renderPipeline, TextureSetup textureSetup, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, float f9, float f10, float f11) {
        ScreenRect screenRect;
        ScreenRect screenRect2;
        GuiRenderState guiRenderState = uut.state(drawContext);
        if (guiRenderState == null) {
            return false;
        }
        if (matrix3x2f == null) {
            matrix3x2f = new Matrix3x2f((Matrix3x2fc)drawContext.method_51448());
        }
        if ((screenRect2 = uut.bounds(matrix3x2f, f - f10, f2 - f10, f + f3 + f10, f2 + f4 + f10, screenRect = uuv.peek())) == null) {
            return true;
        }
        float f12 = Math.min(f3, f4) * 0.5f;
        uut.uvi(guiRenderState, new utx(renderPipeline, textureSetup, matrix3x2f, f, f2, f3, f4, n, n2, n3, n4, utx.packRadii(Math.min(f5, f12), Math.min(f6, f12)), utx.packRadii(Math.min(f7, f12), Math.min(f8, f12)), f9, f10, f11, screenRect, screenRect2));
        return true;
    }

    private static boolean uvo(DrawContext drawContext, RenderPipeline renderPipeline, TextureSetup textureSetup, float f, float f2, float f3, float f4, int n, int n2, int n3, int n4, int n5, int n6, float f5, float f6, float f7) {
        ScreenRect screenRect;
        GuiRenderState guiRenderState = uut.state(drawContext);
        if (guiRenderState == null) {
            return false;
        }
        Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)drawContext.method_51448());
        ScreenRect screenRect2 = uut.bounds(matrix3x2f, f - f6, f2 - f6, f + f3 + f6, f2 + f4 + f6, screenRect = uuv.peek());
        if (screenRect2 == null) {
            return true;
        }
        uut.uvi(guiRenderState, new utx(renderPipeline, textureSetup, matrix3x2f, f, f2, f3, f4, n3, n4, n5, n6, n, n2, f5, f6, f7, screenRect, screenRect2));
        return true;
    }

    public static void submit(DrawContext drawContext, SimpleGuiElementRenderState simpleGuiElementRenderState) {
        GuiRenderState guiRenderState = uut.state(drawContext);
        if (guiRenderState != null) {
            uut.uvi(guiRenderState, simpleGuiElementRenderState);
        }
    }

    public static @Nullable ScreenRect bounds(Matrix3x2f matrix3x2f, float f, float f2, float f3, float f4, @Nullable ScreenRect screenRect) {
        int n = MathHelper.method_15375((float)f);
        int n2 = MathHelper.method_15375((float)f2);
        int n3 = MathHelper.method_15386((float)f3) - n;
        int n4 = MathHelper.method_15386((float)f4) - n2;
        if (n3 <= 0 || n4 <= 0) {
            return null;
        }
        ScreenRect screenRect2 = new ScreenRect(n, n2, n3, n4).method_71523((Matrix3x2fc)matrix3x2f);
        return screenRect != null ? screenRect.method_49701(screenRect2) : screenRect2;
    }

    private static void uvp(DrawContext drawContext, float f, float f2, float f3, float f4, int n, int n2, float f5) {
        int n3 = Math.round(f);
        int n4 = Math.round(f2);
        int n5 = Math.round(f + f3);
        int n6 = Math.round(f2 + f4);
        if (f5 > 0.0f) {
            drawContext.method_73198(n3, n4, n5 - n3, n6 - n4, n);
        } else if (n == n2) {
            drawContext.method_25294(n3, n4, n5, n6, n);
        } else {
            drawContext.method_25296(n3, n4, n5, n6, n, n2);
        }
    }

    static @Nullable GuiRenderState state(DrawContext drawContext) {
        if (uuz == null && !uva) {
            for (GuiRenderState guiRenderState : DrawContext.class.getDeclaredFields()) {
                if (guiRenderState.getType() != GuiRenderState.class) continue;
                guiRenderState.setAccessible(true);
                uuz = guiRenderState;
                break;
            }
            if (uuz == null) {
                uva = true;
                System.out.println("DrawContext render state field not found");
            }
        }
        if (uuz == null) {
            return null;
        }
        if (drawContext == uvb) {
            return uvc;
        }
        try {
            GuiRenderState guiRenderState = (GuiRenderState)uuz.get(drawContext);
            uvb = drawContext;
            uvc = guiRenderState;
            return guiRenderState;
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    static {
        uvd = new ArrayList<uhx>();
    }

    private static /* synthetic */ int dbb(int n, int n2) {
        return n ^ n2 ^ 0xC7CF7275;
    }

    private static /* synthetic */ int dbc(int n, int n2) {
        return uut.dbb(n, n2) + n;
    }

    private static /* synthetic */ int dbd(int n, int n2) {
        return uut.dbc(n, n2) * n2;
    }
}

