/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.GpuSampler
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.texture.TextureSetup
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fc
 */
package a;

import a.unf;
import a.uut;
import a.vdn;
import a.vfw;
import a.vhz;
import a.viw;
import a.vjb;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;

public final class vjf {
    private static final float vjg = 1.8f;
    private static final float vjh = 1.15f;
    private static final int vji = 1;
    private static final int vjj = 12;
    private static final Map<Long, vjb> vjk = new LinkedHashMap<Long, vjb>(16, 0.75f, true);
    private static final List<viw> vjl = new ArrayList<viw>();
    private static boolean vjm;
    private static /* synthetic */ String vjn;
    private static /* synthetic */ long vjo;

    private vjf() {
    }

    public static void draw(DrawContext drawContext, vhz vhz2, float f, float f2, float f3, int n) {
        ScreenRect screenRect;
        int n2 = uut.fade(n);
        if (n2 >>> 24 == 0 || f3 <= 0.0f || vjm) {
            return;
        }
        unf.observe(drawContext);
        vjf.vjr();
        float f4 = vjf.vjp();
        vjb vjb2 = vjf.vjq(f3, f4);
        if (vjb2 == null) {
            return;
        }
        float f5 = (float)vjb2.px / f4;
        float f6 = 1.0f / f4;
        float f7 = (float)Math.round((f - f5 * 0.5f) * f4) / f4 - f6;
        float f8 = (float)Math.round((f2 - f5 * 0.5f) * f4) / f4 - f6;
        float f9 = f7 + f5 + f6 * 2.0f;
        float f10 = f8 + f5 + f6 * 2.0f;
        int n3 = vhz2.ordinal();
        float[] fArray = vjb2.uv(n3);
        Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)drawContext.method_51448());
        ScreenRect screenRect2 = uut.bounds(matrix3x2f, f7, f8, f9, f10, screenRect = uut.scissor());
        if (screenRect2 == null) {
            return;
        }
        TextureSetup textureSetup = TextureSetup.method_70900((GpuTextureView)vjb2.view, (GpuSampler)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
        float[] fArray2 = new float[]{f7, f8, f9, f10, fArray[0], fArray[1], fArray[2], fArray[3]};
        uut.submit(drawContext, new vfw(textureSetup, matrix3x2f, fArray2, new int[]{n2}, 1, screenRect, screenRect2));
    }

    private static float vjp() {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        int n = minecraftClient.method_22683() != null ? minecraftClient.method_22683().method_4495() : 2;
        return (float)Math.max(1, n) * vdn.renderScale();
    }

    private static vjb vjq(float f, float f2) {
        int n = Math.max(6, Math.round(f * f2));
        vjb vjb2 = vjk.get(n);
        if (vjb2 != null) {
            return vjb2;
        }
        if (!RenderSystem.isOnRenderThread()) {
            return null;
        }
        try {
            vjb2 = vjb.build(n);
        }
        catch (Throwable throwable) {
            vjm = true;
            System.out.println("icons unavailable: " + throwable);
            return null;
        }
        vjk.put(Long.valueOf(n), vjb2);
        while (vjk.size() > 12) {
            Long l = vjk.keySet().iterator().next();
            vjl.add(new viw(vjk.remove(l), unf.frame()));
        }
        return vjb2;
    }

    private static void vjr() {
        if (vjl.isEmpty()) {
            return;
        }
        long l = unf.frame();
        vjl.removeIf(viw2 -> {
            if (l - viw2.viy > 2L) {
                viw2.vix.close();
                return true;
            }
            return false;
        });
    }

    private static /* synthetic */ int dgd(int n, int n2) {
        return n + n2 + -1109364260;
    }
}

