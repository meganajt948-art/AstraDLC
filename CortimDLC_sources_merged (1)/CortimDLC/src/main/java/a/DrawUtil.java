/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_11231
 *  net.minecraft.class_11244
 *  net.minecraft.class_11246
 *  net.minecraft.class_12137
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_8030
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fStack
 *  org.joml.Matrix3x2fc
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.UniformsA;
import a.SceneCapture;
import a.GlassParams;
import a.UniformsB;
import a.UniformsC;
import a.UniformsD;
import a.VertexFormats;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.class_11231;
import net.minecraft.class_11244;
import net.minecraft.class_11246;
import net.minecraft.class_12137;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_8030;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import org.jspecify.annotations.Nullable;

public final class DrawUtil {
    private static final class_8030 uuu = new class_8030(0, 0, 0, 0);
    private static final Deque<class_8030> uuv = new ArrayDeque<class_8030>();
    private static final Deque<Float> uuw = new ArrayDeque<Float>();
    private static float uux = 1.0f;
    private static boolean uuy;
    private static Field uuz;
    private static boolean uva;
    private static @Nullable class_332 uvb;
    private static @Nullable class_11246 uvc;
    private static final List<UniformsA> uvd;
    private static int uve;
    private static @Nullable class_11246 uvf;
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

    private DrawUtil() {
    }

    public static void beginBatch() {
        ++uve;
    }

    public static void endBatch() {
        if (uve > 0 && --uve == 0) {
            DrawUtil.uvj();
        }
    }

    private static void uvi(class_11246 class_112462, class_11244 class_112442) {
        if (uve == 0) {
            class_112462.method_70919(class_112442);
            return;
        }
        if (uvf != class_112462) {
            DrawUtil.uvj();
            uvf = class_112462;
        }
        int n = uvd.size();
        for (int i = 0; i < n; ++i) {
            UniformsA uhx2 = uvd.get(i);
            if (!uhx2.accepts(class_112442)) continue;
            uhx2.add(class_112442);
            return;
        }
        uvd.add(new UniformsA(class_112442));
    }

    private static void uvj() {
        class_11246 class_112462 = uvf;
        if (class_112462 != null) {
            for (UniformsA uhx2 : uvd) {
                if (uhx2.isEmpty()) continue;
                class_112462.method_70919((class_11244)uhx2);
            }
        }
        uvd.clear();
        uvf = null;
    }

    public static void pushAlpha(float f) {
        uuw.push(Float.valueOf(uux));
        uux *= class_3532.method_15363((float)f, (float)0.0f, (float)1.0f);
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

    public static void pushScissor(class_332 class_3322, float f, float f2, float f3, float f4) {
        int n = class_3532.method_15375((float)f);
        int n2 = class_3532.method_15375((float)f2);
        int n3 = class_3532.method_15386((float)(f + f3));
        int n4 = class_3532.method_15386((float)(f2 + f4));
        class_8030 class_80302 = new class_8030(n, n2, Math.max(0, n3 - n), Math.max(0, n4 - n2)).method_71523((Matrix3x2fc)class_3322.method_51448());
        class_8030 class_80303 = uuv.peek();
        class_8030 class_80304 = class_80303 == null ? class_80302 : class_80303.method_49701(class_80302);
        uuv.push(class_80304 == null ? uuu : class_80304);
        class_3322.method_44379(n, n2, n3, n4);
    }

    public static void popScissor(class_332 class_3322) {
        if (!uuv.isEmpty()) {
            uuv.pop();
            class_3322.method_44380();
        }
    }

    public static @Nullable class_8030 scissor() {
        return uuv.peek();
    }

    public static void beginFrame() {
        if (uve > 0) {
            uve = 0;
            DrawUtil.uvj();
        }
        uuv.clear();
        uuw.clear();
        uux = 1.0f;
        uuy = false;
    }

    public static void additive(boolean bl) {
        uuy = bl;
    }

    public static void sprite(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, int n) {
        DrawUtil.image(class_3322, gpuTextureView, f - f3 * 0.5f, f2 - f3 * 0.5f, f3, f3, 0.0f, n);
    }

    public static void rect(class_332 class_3322, float f, float f2, float f3, float f4, int n) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, 0.0f, 0.0f, 0.0f, 0.0f, n, n, n, n, 0.0f, 0.0f);
    }

    public static void round(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, 0.0f, 0.0f);
    }

    public static void round(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f6, f7, f8, n, n, n, n, 0.0f, 0.0f);
    }

    public static void gradient(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, int n4) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n2, n3, n4, 0.0f, 0.0f);
    }

    public static void gradient(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f6, f7, f8, n, n2, n3, n4, 0.0f, 0.0f);
    }

    public static void gradientH(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        DrawUtil.gradient(class_3322, f, f2, f3, f4, f5, n, n2, n2, n);
    }

    public static void gradientV(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        DrawUtil.gradient(class_3322, f, f2, f3, f4, f5, n, n, n2, n2);
    }

    public static void outline(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, 0.0f, Math.max(0.05f, f6));
    }

    public static void outlineGradientH(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n2, n2, n, 0.0f, Math.max(0.05f, f6));
    }

    public static void outlineGradientV(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5, f5, f5, f5, n, n, n2, n2, 0.0f, Math.max(0.05f, f6));
    }

    public static boolean arc(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        if (f6 <= 5.0E-4f || f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        int n8 = DrawUtil.fade(n);
        if ((n8 | (n7 = DrawUtil.fade(n2)) | (n6 = DrawUtil.fade(n3)) | (n5 = DrawUtil.fade(n4))) >>> 24 == 0) {
            return true;
        }
        if (!VertexFormats.ensure(VertexFormats.ARC)) {
            return false;
        }
        float f7 = f5 - (float)Math.floor(f5);
        int n9 = Math.round(f7 * 65535.0f) & 0xFFFF;
        int n10 = Math.round(Math.min(1.0f, f6) * 65535.0f) & 0xFFFF;
        return DrawUtil.uvo(class_3322, VertexFormats.ARC, class_11231.method_70899(), f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, n9, n10, n8, n7, n6, n5, 0.0f, UniformsD.pad(0.0f), f4);
    }

    public static boolean arc(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        return DrawUtil.arc(class_3322, f, f2, f3, f4, f5, f6, n, n, n, n);
    }

    public static void shadow(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        DrawUtil.uvl(class_3322, VertexFormats.RECT, class_11231.method_70899(), f, f2, f3, f4, f5 + f6 * 0.5f, f5 + f6 * 0.5f, f5 + f6 * 0.5f, f5 + f6 * 0.5f, n, n, n, n, Math.max(0.5f, f6), 0.0f);
    }

    public static void line(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n) {
        DrawUtil.uvk(class_3322, f, f2, f3, f4, f5, 0.0f, n);
    }

    public static void softLine(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        DrawUtil.uvk(class_3322, f, f2, f3, f4, f5, Math.max(0.5f, f6), n);
    }

    private static void uvk(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        RenderPipeline renderPipeline;
        float f7 = f3 - f;
        float f8 = f4 - f2;
        float f9 = (float)Math.sqrt(f7 * f7 + f8 * f8);
        float f10 = f5 * 0.5f;
        int n2 = DrawUtil.fade(n);
        if (n2 >>> 24 == 0) {
            return;
        }
        RenderPipeline renderPipeline2 = renderPipeline = uuy ? VertexFormats.RECT_ADD : VertexFormats.RECT;
        if (VertexFormats.ensure(renderPipeline)) {
            Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)class_3322.method_51448()).translate(f, f2);
            if (f9 > 0.001f) {
                matrix3x2f.rotate((float)Math.atan2(f8, f7));
            }
            float f11 = f6 > 0.0f ? Math.max(0.5f, f6) : 0.0f;
            float f12 = f10 + f11 * 0.5f;
            DrawUtil.uvn(class_3322, matrix3x2f, renderPipeline, class_11231.method_70899(), -f10, -f10, f9 + f5, f5, f12, f12, f12, f12, n2, n2, n2, n2, f11, UniformsD.pad(f11), 0.0f);
            return;
        }
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f2);
        if (f9 > 0.001f) {
            class_3322.method_51448().rotate((float)Math.atan2(f8, f7));
        }
        if (f6 > 0.0f) {
            DrawUtil.shadow(class_3322, -f10, -f10, f9 + f5, f5, f10, f6, n);
        } else {
            DrawUtil.round(class_3322, -f10, -f10, f9 + f5, f5, f10, n);
        }
        class_3322.method_51448().popMatrix();
    }

    public static void circle(class_332 class_3322, float f, float f2, float f3, int n) {
        DrawUtil.round(class_3322, f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, f3, n);
    }

    public static void circleOutline(class_332 class_3322, float f, float f2, float f3, float f4, int n) {
        DrawUtil.outline(class_3322, f - f3, f2 - f3, f3 * 2.0f, f3 * 2.0f, f3, f4, n);
    }

    public static boolean glass(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        return DrawUtil.glass(class_3322, SceneCapture.SCENE.result(class_3322), f, f2, f3, f4, f5, n, f6);
    }

    public static boolean glass(class_332 class_3322, @Nullable GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        if (gpuTextureView == null) {
            return false;
        }
        float f7 = class_3532.method_15363((float)(f6 * uux), (float)0.0f, (float)1.0f);
        if (f7 <= 0.002f || f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        if (!VertexFormats.ensure(VertexFormats.GLASS)) {
            return false;
        }
        class_11231 class_112312 = class_11231.method_70900((GpuTextureView)gpuTextureView, (class_12137)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        return DrawUtil.uvm(class_3322, VertexFormats.GLASS, class_112312, f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, 0.0f, UniformsD.pad(0.0f), f7);
    }

    public static boolean liquid(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, float f6, GlassParams uoy2) {
        return DrawUtil.liquid(class_3322, SceneCapture.SCENE.result(class_3322), f, f2, f3, f4, f5, n, f6, uoy2);
    }

    public static boolean liquid(class_332 class_3322, @Nullable GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n, float f6, GlassParams uoy2) {
        if (gpuTextureView == null) {
            return false;
        }
        float f7 = class_3532.method_15363((float)(f6 * uux), (float)0.0f, (float)1.0f);
        if (f7 <= 0.004f || f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        if (!VertexFormats.ensure(VertexFormats.LIQUID)) {
            return DrawUtil.glass(class_3322, gpuTextureView, f, f2, f3, f4, f5, n, f6);
        }
        class_11231 class_112312 = class_11231.method_70900((GpuTextureView)gpuTextureView, (class_12137)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        float f8 = Math.min(f3, f4) * 0.5f;
        return DrawUtil.uvm(class_3322, VertexFormats.LIQUID, class_112312, f, f2, f3, f4, f5, f5, f5, f5, n, n, n, n, uoy2.packShape(f8), UniformsD.pad(0.0f), uoy2.packLight(f7));
    }

    public static void image(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, int n) {
        RenderPipeline renderPipeline;
        int n2 = DrawUtil.fade(n);
        RenderPipeline renderPipeline2 = renderPipeline = uuy ? VertexFormats.IMAGE_ADD : VertexFormats.IMAGE;
        if (n2 >>> 24 == 0 || f3 <= 0.0f || f4 <= 0.0f || !VertexFormats.ensure(renderPipeline)) {
            return;
        }
        class_11231 class_112312 = class_11231.method_70900((GpuTextureView)gpuTextureView, (class_12137)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        DrawUtil.uvm(class_3322, renderPipeline, class_112312, f, f2, f3, f4, f5, f5, f5, f5, n2, n2, n2, n2, 0.0f, UniformsD.pad(0.0f), 0.0f);
    }

    public static void imageRegion(class_332 class_3322, GpuTextureView gpuTextureView, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, boolean bl) {
        int n2 = DrawUtil.fade(n);
        if (n2 >>> 24 == 0 || f3 <= 0.0f || f4 <= 0.0f || !VertexFormats.ensure(VertexFormats.IMAGE)) {
            return;
        }
        int n3 = Math.max(0, Math.min(4095, Math.round(f6 * 4095.0f)));
        int n4 = Math.max(0, Math.min(4095, Math.round(f7 * 4095.0f)));
        int n5 = Math.max(1, Math.min(4095, Math.round((f8 - f6) * 4095.0f)));
        int n6 = Math.max(1, Math.min(4095, Math.round((f9 - f7) * 4095.0f)));
        class_11231 class_112312 = class_11231.method_70900((GpuTextureView)gpuTextureView, (class_12137)RenderSystem.getSamplerCache().method_75294(bl ? FilterMode.NEAREST : FilterMode.LINEAR));
        DrawUtil.uvm(class_3322, VertexFormats.IMAGE, class_112312, f, f2, f3, f4, f5, f5, f5, f5, n2, n2, n2, n2, n3 << 12 | n4, UniformsD.pad(0.0f), n5 << 12 | n6);
    }

    public static void quad(class_332 class_3322, float f, float f2, int n, float f3, float f4, int n2, float f5, float f6, int n3, float f7, float f8, int n4) {
        int n5;
        int n6;
        int n7;
        int n8 = DrawUtil.fade(n);
        if ((n8 | (n7 = DrawUtil.fade(n2)) | (n6 = DrawUtil.fade(n3)) | (n5 = DrawUtil.fade(n4))) >>> 24 == 0) {
            return;
        }
        RenderPipeline renderPipeline = uuy ? VertexFormats.QUAD_ADD : VertexFormats.QUAD;
        class_11246 class_112462 = DrawUtil.state(class_3322);
        if (class_112462 == null || !VertexFormats.ensure(renderPipeline)) {
            return;
        }
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        float f9 = matrix3x2fStack.m00() * f + matrix3x2fStack.m10() * f2 + matrix3x2fStack.m20();
        float f10 = matrix3x2fStack.m01() * f + matrix3x2fStack.m11() * f2 + matrix3x2fStack.m21();
        float f11 = matrix3x2fStack.m00() * f3 + matrix3x2fStack.m10() * f4 + matrix3x2fStack.m20();
        float f12 = matrix3x2fStack.m01() * f3 + matrix3x2fStack.m11() * f4 + matrix3x2fStack.m21();
        float f13 = matrix3x2fStack.m00() * f5 + matrix3x2fStack.m10() * f6 + matrix3x2fStack.m20();
        float f14 = matrix3x2fStack.m01() * f5 + matrix3x2fStack.m11() * f6 + matrix3x2fStack.m21();
        float f15 = matrix3x2fStack.m00() * f7 + matrix3x2fStack.m10() * f8 + matrix3x2fStack.m20();
        float f16 = matrix3x2fStack.m01() * f7 + matrix3x2fStack.m11() * f8 + matrix3x2fStack.m21();
        int n9 = class_3532.method_15375((float)Math.min(Math.min(f9, f11), Math.min(f13, f15)));
        int n10 = class_3532.method_15375((float)Math.min(Math.min(f10, f12), Math.min(f14, f16)));
        int n11 = class_3532.method_15386((float)Math.max(Math.max(f9, f11), Math.max(f13, f15)));
        int n12 = class_3532.method_15386((float)Math.max(Math.max(f10, f12), Math.max(f14, f16)));
        if (n11 <= n9 || n12 <= n10) {
            return;
        }
        class_8030 class_80302 = uuv.peek();
        class_8030 class_80303 = new class_8030(n9, n10, n11 - n9, n12 - n10);
        if (class_80302 != null && (class_80303 = class_80302.method_49701(class_80303)) == null) {
            return;
        }
        DrawUtil.uvi(class_112462, new UniformsC(renderPipeline, f9, f10, f11, f12, f13, f14, f15, f16, n8, n7, n6, n5, class_80302, class_80303));
    }

    public static void pattern(class_332 class_3322, float[] fArray, int n, int n2, int n3, int n4, float f, float f2) {
        int n5;
        int n6;
        int n7 = DrawUtil.fade(n3);
        if (n7 >>> 24 == 0) {
            return;
        }
        RenderPipeline renderPipeline = uuy ? VertexFormats.PATTERN_ADD : VertexFormats.PATTERN;
        class_11246 class_112462 = DrawUtil.state(class_3322);
        if (class_112462 == null || !VertexFormats.ensure(renderPipeline)) {
            return;
        }
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
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
        n6 = class_3532.method_15375((float)f3);
        n5 = class_3532.method_15375((float)f4);
        int n8 = class_3532.method_15386((float)f5);
        int n9 = class_3532.method_15386((float)f6);
        if (n8 <= n6 || n9 <= n5) {
            return;
        }
        class_8030 class_80302 = uuv.peek();
        class_8030 class_80303 = new class_8030(n6, n5, n8 - n6, n9 - n5);
        if (class_80302 != null && (class_80303 = class_80302.method_49701(class_80303)) == null) {
            return;
        }
        float f11 = f2 % 3600.0f;
        DrawUtil.uvi(class_112462, new UniformsB(renderPipeline, fArray2, n7, n4, n, n2, f, f11, class_80302, class_80303));
    }

    private static boolean uvl(class_332 class_3322, RenderPipeline renderPipeline, class_11231 class_112312, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, float f9, float f10) {
        int n5;
        int n6;
        int n7;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            return true;
        }
        int n8 = DrawUtil.fade(n);
        if ((n8 | (n7 = DrawUtil.fade(n2)) | (n6 = DrawUtil.fade(n3)) | (n5 = DrawUtil.fade(n4))) >>> 24 == 0) {
            return true;
        }
        if (uuy && renderPipeline == VertexFormats.RECT) {
            if (!VertexFormats.ensure(VertexFormats.RECT_ADD)) {
                return false;
            }
            renderPipeline = VertexFormats.RECT_ADD;
        }
        if (!VertexFormats.ensure(renderPipeline)) {
            if (renderPipeline == VertexFormats.RECT && f9 == 0.0f) {
                DrawUtil.uvp(class_3322, f, f2, f3, f4, n8, n5, f10);
            }
            return false;
        }
        return DrawUtil.uvm(class_3322, renderPipeline, class_112312, f, f2, f3, f4, f5, f6, f7, f8, n8, n7, n6, n5, f9, UniformsD.pad(f9), f10);
    }

    private static boolean uvm(class_332 class_3322, RenderPipeline renderPipeline, class_11231 class_112312, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, float f9, float f10, float f11) {
        return DrawUtil.uvn(class_3322, null, renderPipeline, class_112312, f, f2, f3, f4, f5, f6, f7, f8, n, n2, n3, n4, f9, f10, f11);
    }

    private static boolean uvn(class_332 class_3322, @Nullable Matrix3x2f matrix3x2f, RenderPipeline renderPipeline, class_11231 class_112312, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, float f9, float f10, float f11) {
        class_8030 class_80302;
        class_8030 class_80303;
        class_11246 class_112462 = DrawUtil.state(class_3322);
        if (class_112462 == null) {
            return false;
        }
        if (matrix3x2f == null) {
            matrix3x2f = new Matrix3x2f((Matrix3x2fc)class_3322.method_51448());
        }
        if ((class_80303 = DrawUtil.bounds(matrix3x2f, f - f10, f2 - f10, f + f3 + f10, f2 + f4 + f10, class_80302 = uuv.peek())) == null) {
            return true;
        }
        float f12 = Math.min(f3, f4) * 0.5f;
        DrawUtil.uvi(class_112462, new UniformsD(renderPipeline, class_112312, matrix3x2f, f, f2, f3, f4, n, n2, n3, n4, UniformsD.packRadii(Math.min(f5, f12), Math.min(f6, f12)), UniformsD.packRadii(Math.min(f7, f12), Math.min(f8, f12)), f9, f10, f11, class_80302, class_80303));
        return true;
    }

    private static boolean uvo(class_332 class_3322, RenderPipeline renderPipeline, class_11231 class_112312, float f, float f2, float f3, float f4, int n, int n2, int n3, int n4, int n5, int n6, float f5, float f6, float f7) {
        class_8030 class_80302;
        class_11246 class_112462 = DrawUtil.state(class_3322);
        if (class_112462 == null) {
            return false;
        }
        Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)class_3322.method_51448());
        class_8030 class_80303 = DrawUtil.bounds(matrix3x2f, f - f6, f2 - f6, f + f3 + f6, f2 + f4 + f6, class_80302 = uuv.peek());
        if (class_80303 == null) {
            return true;
        }
        DrawUtil.uvi(class_112462, new UniformsD(renderPipeline, class_112312, matrix3x2f, f, f2, f3, f4, n3, n4, n5, n6, n, n2, f5, f6, f7, class_80302, class_80303));
        return true;
    }

    public static void submit(class_332 class_3322, class_11244 class_112442) {
        class_11246 class_112462 = DrawUtil.state(class_3322);
        if (class_112462 != null) {
            DrawUtil.uvi(class_112462, class_112442);
        }
    }

    public static @Nullable class_8030 bounds(Matrix3x2f matrix3x2f, float f, float f2, float f3, float f4, @Nullable class_8030 class_80302) {
        int n = class_3532.method_15375((float)f);
        int n2 = class_3532.method_15375((float)f2);
        int n3 = class_3532.method_15386((float)f3) - n;
        int n4 = class_3532.method_15386((float)f4) - n2;
        if (n3 <= 0 || n4 <= 0) {
            return null;
        }
        class_8030 class_80303 = new class_8030(n, n2, n3, n4).method_71523((Matrix3x2fc)matrix3x2f);
        return class_80302 != null ? class_80302.method_49701(class_80303) : class_80303;
    }

    private static void uvp(class_332 class_3322, float f, float f2, float f3, float f4, int n, int n2, float f5) {
        int n3 = Math.round(f);
        int n4 = Math.round(f2);
        int n5 = Math.round(f + f3);
        int n6 = Math.round(f2 + f4);
        if (f5 > 0.0f) {
            class_3322.method_73198(n3, n4, n5 - n3, n6 - n4, n);
        } else if (n == n2) {
            class_3322.method_25294(n3, n4, n5, n6, n);
        } else {
            class_3322.method_25296(n3, n4, n5, n6, n, n2);
        }
    }

    static @Nullable class_11246 state(class_332 class_3322) {
        if (uuz == null && !uva) {
            for (class_11246 class_112462 : class_332.class.getDeclaredFields()) {
                if (class_112462.getType() != class_11246.class) continue;
                class_112462.setAccessible(true);
                uuz = class_112462;
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
        if (class_3322 == uvb) {
            return uvc;
        }
        try {
            class_11246 class_112463 = (class_11246)uuz.get(class_3322);
            uvb = class_3322;
            uvc = class_112463;
            return class_112463;
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    static {
        uvd = new ArrayList<UniformsA>();
    }

    private static /* synthetic */ int dbb(int n, int n2) {
        return n ^ n2 ^ 0xC7CF7275;
    }

    private static /* synthetic */ int dbc(int n, int n2) {
        return DrawUtil.dbb(n, n2) + n;
    }

    private static /* synthetic */ int dbd(int n, int n2) {
        return DrawUtil.dbc(n, n2) * n2;
    }
}

