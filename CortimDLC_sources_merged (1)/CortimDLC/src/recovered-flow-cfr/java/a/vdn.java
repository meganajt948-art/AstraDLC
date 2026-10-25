/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gl.GpuSampler
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.texture.TextureSetup
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fc
 */
package a;

import a.ujt;
import a.unf;
import a.uut;
import a.vdi;
import a.vev;
import a.vfk;
import a.vfw;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;

public final class vdn {
    private static float vdo = 1.0f;
    private static final int vdp = 10;
    private final String vdq;
    private final Supplier<Font> vdr;
    private final float vds;
    private final String vdt;
    private final boolean vdu;
    private final Map<Integer, vfk> vdv = new LinkedHashMap<Integer, vfk>(8, 0.75f, true);
    private final StringBuilder vdw = new StringBuilder();
    private final List<vdi> vdx = new ArrayList<vdi>();
    private boolean vdy;
    private static /* synthetic */ int vdz;
    private static /* synthetic */ boolean vea;

    vdn(String string, Supplier<Font> supplier, float f, String string2, boolean bl) {
        this.vdq = string;
        this.vdr = supplier;
        this.vds = f;
        this.vdt = string2;
        this.vdu = bl;
    }

    public static void setRenderScale(float f) {
        vdo = Math.max(0.25f, f);
    }

    public static void setRenderScaleStepped(float f) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        int n = minecraftClient.method_22683() != null ? Math.max(1, minecraftClient.method_22683().method_4495()) : 2;
        float f2 = Math.max(0.5f, (float)Math.round(f * (float)n * 2.0f) / 2.0f);
        vdn.setRenderScale(f2 / (float)n);
    }

    public static float renderScale() {
        return vdo;
    }

    public float size() {
        return this.vds;
    }

    public float ascent() {
        vfk vfk2 = this.ved();
        return vfk2 != null ? vfk2.ascent : 7.0f;
    }

    public float descent() {
        vfk vfk2 = this.ved();
        return vfk2 != null ? vfk2.descent : 2.0f;
    }

    public float height() {
        vfk vfk2 = this.ved();
        return vfk2 != null ? vfk2.ascent + vfk2.descent : 9.0f;
    }

    public float capHeight() {
        vfk vfk2 = this.ved();
        return vfk2 != null ? vfk2.capHeight : 7.0f;
    }

    public float centerTop(float f) {
        vfk vfk2 = this.ved();
        if (vfk2 == null) {
            return f - 4.0f;
        }
        return f + vfk2.capHeight * 0.5f - vfk2.ascent;
    }

    public float width(String string) {
        return this.width(string, 0.0f);
    }

    public boolean canDisplay(int n) {
        vfk vfk2 = this.ved();
        return vfk2 != null && (vfk2.has(n) || vfk2.canDisplay(n));
    }

    public float width(String string, float f) {
        vfk vfk2;
        if (string == null || string.isEmpty()) {
            return 0.0f;
        }
        vfk vfk3 = vfk2 = RenderSystem.isOnRenderThread() ? this.vec(string) : this.ved();
        if (vfk2 == null) {
            return vdn.vej().method_1727(string);
        }
        float f2 = 0.0f;
        int n = 0;
        int n2 = 0;
        while (n2 < string.length()) {
            int n3 = string.codePointAt(n2);
            n2 += Character.charCount(n3);
            vev vev2 = vfk2.glyph(n3);
            if (vev2 == null) continue;
            f2 += vev2.advance();
            ++n;
        }
        return f2 + f * (float)Math.max(0, n - 1);
    }

    public String ellipsize(String string, float f) {
        String string2;
        float f2;
        int n;
        if (this.width(string) <= f) {
            return string;
        }
        String string3 = "\u2026";
        float f3 = f - this.width(string3);
        StringBuilder stringBuilder = new StringBuilder();
        float f4 = 0.0f;
        for (int i = 0; i < string.length() && !(f4 + (f2 = this.width(string2 = new String(Character.toChars(n = string.codePointAt(i))))) > f3); i += Character.charCount(n)) {
            stringBuilder.append(string2);
            f4 += f2;
        }
        return stringBuilder.toString().stripTrailing() + string3;
    }

    public float draw(DrawContext drawContext, String string, float f, float f2, int n) {
        return this.draw(drawContext, string, f, f2, n, n, 0.0f);
    }

    public float drawCentered(DrawContext drawContext, String string, float f, float f2, int n) {
        return this.draw(drawContext, string, f - this.width(string) * 0.5f, f2, n);
    }

    public float drawRight(DrawContext drawContext, String string, float f, float f2, int n) {
        return this.draw(drawContext, string, f - this.width(string), f2, n);
    }

    public float drawGradient(DrawContext drawContext, String string, float f, float f2, int n, int n2) {
        return this.draw(drawContext, string, f, f2, n, n2, 0.0f);
    }

    public float drawTracked(DrawContext drawContext, String string, float f, float f2, int n, float f3) {
        return this.draw(drawContext, string, f, f2, n, n, f3);
    }

    public void drawGlyphCentered(DrawContext drawContext, String string, float f, float f2, int n) {
        vev vev2;
        vfk vfk2 = this.vec(string);
        vev vev3 = vev2 = vfk2 != null ? vfk2.glyph(string.codePointAt(0)) : null;
        if (vev2 == null || vev2.w() <= 0.0f) {
            this.drawCentered(drawContext, string, f, this.centerTop(f2), n);
            return;
        }
        float f3 = f - vev2.ox() - vev2.w() * 0.5f;
        float f4 = f2 - vev2.oy() - vev2.h() * 0.5f;
        this.draw(drawContext, string, f3, f4 - vfk2.ascent, n);
    }

    public float draw(DrawContext drawContext, String string, float f, float f2, int n, int n2, float f3) {
        ScreenRect screenRect;
        vev vev2;
        if (string == null || string.isEmpty()) {
            return f;
        }
        unf.observe(drawContext);
        this.veh();
        vfk vfk2 = this.vec(string);
        if (vfk2 == null) {
            return this.vei(drawContext, string, f, f2, n);
        }
        int n3 = uut.fade(n);
        int n4 = uut.fade(n2);
        float f4 = this.width(string, f3);
        if ((n3 | n4) >>> 24 == 0) {
            return f + f4;
        }
        float f5 = vfk2.pixelsPerUnit;
        float f6 = vdn.veb(f2 + vfk2.ascent, f5);
        int n5 = string.codePointCount(0, string.length());
        float[] fArray = new float[n5 * 8];
        int[] nArray = new int[n5];
        int n6 = 0;
        float f7 = f;
        float f8 = Float.MAX_VALUE;
        float f9 = Float.MAX_VALUE;
        float f10 = -3.4028235E38f;
        float f11 = -3.4028235E38f;
        boolean bl = n3 != n4 && f4 > 0.0f;
        int n7 = 0;
        while (n7 < string.length()) {
            int n8 = string.codePointAt(n7);
            n7 += Character.charCount(n8);
            vev2 = vfk2.glyph(n8);
            if (vev2 == null) continue;
            if (vev2.w() > 0.0f) {
                float f12 = vdn.veb(f7 + vev2.ox(), f5);
                float f13 = f6 + vev2.oy();
                int n9 = n6 * 8;
                fArray[n9] = f12;
                fArray[n9 + 1] = f13;
                fArray[n9 + 2] = f12 + vev2.w();
                fArray[n9 + 3] = f13 + vev2.h();
                fArray[n9 + 4] = vev2.u0();
                fArray[n9 + 5] = vev2.v0();
                fArray[n9 + 6] = vev2.u1();
                fArray[n9 + 7] = vev2.v1();
                nArray[n6] = bl ? ujt.lerp(n3, n4, (f7 + vev2.advance() * 0.5f - f) / f4) : n3;
                f8 = Math.min(f8, f12);
                f9 = Math.min(f9, f13);
                f10 = Math.max(f10, f12 + vev2.w());
                f11 = Math.max(f11, f13 + vev2.h());
                ++n6;
            }
            f7 += vev2.advance() + f3;
        }
        if (n6 == 0) {
            return f + f4;
        }
        Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)drawContext.method_51448());
        vev2 = uut.bounds(matrix3x2f, f8, f9, f10, f11, screenRect = uut.scissor());
        if (vev2 != null) {
            TextureSetup textureSetup = TextureSetup.method_70900((GpuTextureView)vfk2.view, (GpuSampler)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            uut.submit(drawContext, new vfw(textureSetup, matrix3x2f, fArray, nArray, n6, screenRect, (ScreenRect)vev2));
        }
        return f + f4;
    }

    private static float veb(float f, float f2) {
        return (float)Math.round(f * f2) / f2;
    }

    private vfk vec(String string) {
        int n;
        vfk vfk2 = this.ved();
        if (vfk2 == null) {
            return null;
        }
        boolean bl = false;
        for (int i = 0; i < string.length(); i += Character.charCount(n)) {
            n = string.codePointAt(i);
            if (vfk2.has(n) || !vfk2.canDisplay(n) || this.vdw.indexOf(new String(Character.toChars(n))) >= 0) continue;
            this.vdw.appendCodePoint(n);
            bl = true;
        }
        if (bl) {
            this.veg(this.vdv.remove(vdn.vee(vfk2.pixelsPerUnit)));
            vfk2 = this.ved();
        }
        return vfk2;
    }

    private vfk ved() {
        Object object;
        if (this.vdy) {
            return null;
        }
        float f = vdn.vef();
        int n = vdn.vee(f);
        vfk vfk2 = this.vdv.get(n);
        if (vfk2 != null) {
            return vfk2;
        }
        if (!RenderSystem.isOnRenderThread()) {
            return null;
        }
        try {
            object = this.vdr.get();
            if (object == null) {
                throw new IllegalStateException("font face unavailable");
            }
            vfk2 = vfk.build(this.vdq, (Font)object, this.vds, f, this.vdt + this.vdw, this.vdu);
        }
        catch (Throwable throwable) {
            this.vdy = true;
            System.out.println("font " + this.vdq + " unavailable, using vanilla text: " + throwable);
            return null;
        }
        this.vdv.put(n, vfk2);
        while (this.vdv.size() > 10) {
            object = this.vdv.entrySet().iterator();
            this.veg((vfk)((Map.Entry)object.next()).getValue());
            object.remove();
        }
        return vfk2;
    }

    private static int vee(float f) {
        return Math.round(f * 100.0f);
    }

    private static float vef() {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        int n = minecraftClient.method_22683() != null ? minecraftClient.method_22683().method_4495() : 2;
        return (float)Math.max(1, n) * vdo;
    }

    private void veg(vfk vfk2) {
        if (vfk2 != null) {
            this.vdx.add(new vdi(vfk2, unf.frame()));
        }
    }

    private void veh() {
        if (this.vdx.isEmpty()) {
            return;
        }
        long l = unf.frame();
        this.vdx.removeIf(vdi2 -> {
            if (l - vdi2.vdk > 2L) {
                vdi2.vdj.close();
                return true;
            }
            return false;
        });
    }

    private float vei(DrawContext drawContext, String string, float f, float f2, int n) {
        TextRenderer textRenderer = vdn.vej();
        drawContext.method_51433(textRenderer, string, Math.round(f), Math.round(f2 + (this.height() - 8.0f) * 0.5f), uut.fade(n), false);
        return f + (float)textRenderer.method_1727(string);
    }

    private static TextRenderer vej() {
        return MinecraftClient.method_1551().field_1772;
    }

    private static /* synthetic */ int ddn(int n, int n2) {
        return n * n2 | 0x69B501C9;
    }

    private static /* synthetic */ int ddo(int n, int n2) {
        return n * n2 + 1289062820;
    }

    private static /* synthetic */ int ddp(int n, int n2) {
        return vdn.ddo(n, n2) * n2;
    }
}

