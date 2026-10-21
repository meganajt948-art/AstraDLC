/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_11231
 *  net.minecraft.class_12137
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_8030
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fc
 */
package a;

import a.ColorUtil;
import a.FrameDelta;
import a.DrawUtil;
import a.vdi;
import a.vev;
import a.FontBuilder;
import a.UniformsE;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.class_11231;
import net.minecraft.class_12137;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_8030;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;

public final class FontFace {
    private static float vdo = 1.0f;
    private static final int vdp = 10;
    private final String vdq;
    private final Supplier<Font> vdr;
    private final float vds;
    private final String vdt;
    private final boolean vdu;
    private final Map<Integer, FontBuilder> vdv = new LinkedHashMap<Integer, FontBuilder>(8, 0.75f, true);
    private final StringBuilder vdw = new StringBuilder();
    private final List<vdi> vdx = new ArrayList<vdi>();
    private boolean vdy;
    private static /* synthetic */ int vdz;
    private static /* synthetic */ boolean vea;

    FontFace(String string, Supplier<Font> supplier, float f, String string2, boolean bl) {
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
        class_310 class_3102 = class_310.method_1551();
        int n = class_3102.method_22683() != null ? Math.max(1, class_3102.method_22683().method_4495()) : 2;
        float f2 = Math.max(0.5f, (float)Math.round(f * (float)n * 2.0f) / 2.0f);
        FontFace.setRenderScale(f2 / (float)n);
    }

    public static float renderScale() {
        return vdo;
    }

    public float size() {
        return this.vds;
    }

    public float ascent() {
        FontBuilder vfk2 = this.ved();
        return vfk2 != null ? vfk2.ascent : 7.0f;
    }

    public float descent() {
        FontBuilder vfk2 = this.ved();
        return vfk2 != null ? vfk2.descent : 2.0f;
    }

    public float height() {
        FontBuilder vfk2 = this.ved();
        return vfk2 != null ? vfk2.ascent + vfk2.descent : 9.0f;
    }

    public float capHeight() {
        FontBuilder vfk2 = this.ved();
        return vfk2 != null ? vfk2.capHeight : 7.0f;
    }

    public float centerTop(float f) {
        FontBuilder vfk2 = this.ved();
        if (vfk2 == null) {
            return f - 4.0f;
        }
        return f + vfk2.capHeight * 0.5f - vfk2.ascent;
    }

    public float width(String string) {
        return this.width(string, 0.0f);
    }

    public boolean canDisplay(int n) {
        FontBuilder vfk2 = this.ved();
        return vfk2 != null && (vfk2.has(n) || vfk2.canDisplay(n));
    }

    public float width(String string, float f) {
        FontBuilder vfk2;
        if (string == null || string.isEmpty()) {
            return 0.0f;
        }
        FontBuilder vfk3 = vfk2 = RenderSystem.isOnRenderThread() ? this.vec(string) : this.ved();
        if (vfk2 == null) {
            return FontFace.vej().method_1727(string);
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

    public float draw(class_332 class_3322, String string, float f, float f2, int n) {
        return this.draw(class_3322, string, f, f2, n, n, 0.0f);
    }

    public float drawCentered(class_332 class_3322, String string, float f, float f2, int n) {
        return this.draw(class_3322, string, f - this.width(string) * 0.5f, f2, n);
    }

    public float drawRight(class_332 class_3322, String string, float f, float f2, int n) {
        return this.draw(class_3322, string, f - this.width(string), f2, n);
    }

    public float drawGradient(class_332 class_3322, String string, float f, float f2, int n, int n2) {
        return this.draw(class_3322, string, f, f2, n, n2, 0.0f);
    }

    public float drawTracked(class_332 class_3322, String string, float f, float f2, int n, float f3) {
        return this.draw(class_3322, string, f, f2, n, n, f3);
    }

    public void drawGlyphCentered(class_332 class_3322, String string, float f, float f2, int n) {
        vev vev2;
        FontBuilder vfk2 = this.vec(string);
        vev vev3 = vev2 = vfk2 != null ? vfk2.glyph(string.codePointAt(0)) : null;
        if (vev2 == null || vev2.w() <= 0.0f) {
            this.drawCentered(class_3322, string, f, this.centerTop(f2), n);
            return;
        }
        float f3 = f - vev2.ox() - vev2.w() * 0.5f;
        float f4 = f2 - vev2.oy() - vev2.h() * 0.5f;
        this.draw(class_3322, string, f3, f4 - vfk2.ascent, n);
    }

    public float draw(class_332 class_3322, String string, float f, float f2, int n, int n2, float f3) {
        class_8030 class_80302;
        vev vev2;
        if (string == null || string.isEmpty()) {
            return f;
        }
        FrameDelta.observe(class_3322);
        this.veh();
        FontBuilder vfk2 = this.vec(string);
        if (vfk2 == null) {
            return this.vei(class_3322, string, f, f2, n);
        }
        int n3 = DrawUtil.fade(n);
        int n4 = DrawUtil.fade(n2);
        float f4 = this.width(string, f3);
        if ((n3 | n4) >>> 24 == 0) {
            return f + f4;
        }
        float f5 = vfk2.pixelsPerUnit;
        float f6 = FontFace.veb(f2 + vfk2.ascent, f5);
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
                float f12 = FontFace.veb(f7 + vev2.ox(), f5);
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
                nArray[n6] = bl ? ColorUtil.lerp(n3, n4, (f7 + vev2.advance() * 0.5f - f) / f4) : n3;
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
        Matrix3x2f matrix3x2f = new Matrix3x2f((Matrix3x2fc)class_3322.method_51448());
        vev2 = DrawUtil.bounds(matrix3x2f, f8, f9, f10, f11, class_80302 = DrawUtil.scissor());
        if (vev2 != null) {
            class_11231 class_112312 = class_11231.method_70900((GpuTextureView)vfk2.view, (class_12137)RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            DrawUtil.submit(class_3322, new UniformsE(class_112312, matrix3x2f, fArray, nArray, n6, class_80302, (class_8030)vev2));
        }
        return f + f4;
    }

    private static float veb(float f, float f2) {
        return (float)Math.round(f * f2) / f2;
    }

    private FontBuilder vec(String string) {
        int n;
        FontBuilder vfk2 = this.ved();
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
            this.veg(this.vdv.remove(FontFace.vee(vfk2.pixelsPerUnit)));
            vfk2 = this.ved();
        }
        return vfk2;
    }

    private FontBuilder ved() {
        Object object;
        if (this.vdy) {
            return null;
        }
        float f = FontFace.vef();
        int n = FontFace.vee(f);
        FontBuilder vfk2 = this.vdv.get(n);
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
            vfk2 = FontBuilder.build(this.vdq, (Font)object, this.vds, f, this.vdt + this.vdw, this.vdu);
        }
        catch (Throwable throwable) {
            this.vdy = true;
            System.out.println("font " + this.vdq + " unavailable, using vanilla text: " + throwable);
            return null;
        }
        this.vdv.put(n, vfk2);
        while (this.vdv.size() > 10) {
            object = this.vdv.entrySet().iterator();
            this.veg((FontBuilder)((Map.Entry)object.next()).getValue());
            object.remove();
        }
        return vfk2;
    }

    private static int vee(float f) {
        return Math.round(f * 100.0f);
    }

    private static float vef() {
        class_310 class_3102 = class_310.method_1551();
        int n = class_3102.method_22683() != null ? class_3102.method_22683().method_4495() : 2;
        return (float)Math.max(1, n) * vdo;
    }

    private void veg(FontBuilder vfk2) {
        if (vfk2 != null) {
            this.vdx.add(new vdi(vfk2, FrameDelta.frame()));
        }
    }

    private void veh() {
        if (this.vdx.isEmpty()) {
            return;
        }
        long l = FrameDelta.frame();
        this.vdx.removeIf(vdi2 -> {
            if (l - vdi2.vdk > 2L) {
                vdi2.vdj.close();
                return true;
            }
            return false;
        });
    }

    private float vei(class_332 class_3322, String string, float f, float f2, int n) {
        class_327 class_3272 = FontFace.vej();
        class_3322.method_51433(class_3272, string, Math.round(f), Math.round(f2 + (this.height() - 8.0f) * 0.5f), DrawUtil.fade(n), false);
        return f + (float)class_3272.method_1727(string);
    }

    private static class_327 vej() {
        return class_310.method_1551().field_1772;
    }

    private static /* synthetic */ int ddn(int n, int n2) {
        return n * n2 | 0x69B501C9;
    }

    private static /* synthetic */ int ddo(int n, int n2) {
        return n * n2 + 1289062820;
    }

    private static /* synthetic */ int ddp(int n, int n2) {
        return FontFace.ddo(n, n2) * n2;
    }
}

