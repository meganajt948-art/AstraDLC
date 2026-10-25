/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gui.DrawContext
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.uij;
import a.ujt;
import a.uoy;
import a.uut;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import org.jspecify.annotations.Nullable;

public final class hyv {
    public static final vkl ENABLED = new vkl(a.c(740963259, "\u33fb\u4a6f\uc0a4\u5ed1\ud51a\u53a6\ue9b1\u6027\ufe53\u74ef\uf32e\u095f"), false);
    public static final vlv STYLE = new vlv(a.b("\uad46\ud4d0\u5e0e\uc06a\u4bb4", 432778512), a.d("\u96c5\uef51\u659a\ufbef\u7024\uf698", -1451792942, 1049490269), a.b("\u13d2\u6a46\ue08d\u7ef8\uf533\u738f", 69342104), a.d("\u38b8\u413d\ucbf3\u559e\ude4e\u58ee\ue2bc", -262934813, 901305882));
    public static final vmc FROST = new vmc(a.c(-1870044846, "\u6111\u1894\u925a\u0c37\u87e7"), 2.0, 0.0, 6.0, 1.0);
    public static final vmc REFRACTION = new vmc(a.b("\u5d9c\u241a\uaeca\u30af\ubb6b\u3dd8\u879c\u0e70\u9029\u1a99", -1340187196), 0.7, 0.0, 1.0, 0.01).percent();
    public static final vmc EDGE = new vmc(a.d("\u9a2e\ue3be\u696e\uf71d", 406602611, -1915823844), 12.0, 2.0, 30.0, 1.0).unit(a.b("\ue068\u99d1", 1718542362));
    public static final vmc DISPERSION = new vmc(a.b("\u4a2a\u33b6\ub97f\u270d\uaccf\u2a69\u903b\u19d0\u8789\u0d39", 1609910884), 0.4, 0.0, 1.0, 0.01).percent();
    public static final vmc HIGHLIGHT = new vmc(a.b("\u48aa\u313a\ubbe7\u2599\uae4a\u28fe\u92a3\u1b5d\u851e", -134788885), 0.7, 0.0, 1.0, 0.01).percent();
    public static final vmc LIGHT = new vmc(a.c(-285835731, "\u7e6a\u07fe\u8d23\u135d\u9896\u1e73\ua461\u2d9f\ub3c9\u3973\ubea9"), 225.0, 0.0, 355.0, 5.0).unit(a.d("\ue86b", -1112090618, 1348153564));
    public static final vmc VIBRANCY = new vmc(a.c(-1330512706, "\ufce0\u856e\u0fb6\u91d7\u1a13\u9cad\u26f3\uaf18"), 1.15, 0.0, 2.0, 0.05).percent();
    public static final vmc TINT = new vmc(a.b("\u58d3\u215f\uab8b\u35e0", 419846275), 0.8, 0.1, 1.0, 0.01).percent();
    public static final vkl WINDOW = new vkl(a.c(-2051742050, "\ue6cf\u9f40\u1594\u8bef3\u869a"), true);
    public static final vkl TABS = new vkl(a.b("\u81aa\uf82e\u72fe\ueccd\u674a\ue1e2\u5bb4\ud245", -444694026), true);
    public static final vkl CARDS = new vkl(a.b("\u100d\u6989\ue347\u7d2c\uf6fe\u701f\uca0e\u43f2\uddba\u5716\ud0d3", 251465793), true);
    public static final vkl POPUPS = new vkl(a.b("\ua513\udc9d\u5651\uc825\u43f7\uc545", 1307026757), true);
    static final List<vmo> OPTICS = List.of(STYLE, FROST, TINT, REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT, VIBRANCY);
    static final List<vmo> LIQUID_ONLY = List.of(REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT);
    static final List<vmo> TARGETS = List.of(WINDOW, TABS, CARDS, POPUPS);
    static final List<vmo> ALL = List.of(ENABLED, STYLE, FROST, TINT, REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT, VIBRANCY, WINDOW, TABS, CARDS, POPUPS);
    private static boolean hyw;
    private static /* synthetic */ long hyx;
    private static /* synthetic */ boolean hyy;

    private hyv() {
    }

    public static boolean liquid() {
        return STYLE.is(a.c(436438085, "\u840f\ufd9b\u7750\ue925\u62ee\ue452"));
    }

    static void resetAll() {
        ENABLED.reset();
        STYLE.reset();
        for (vmo vmo2 : OPTICS) {
            if (!(vmo2 instanceof vmc)) continue;
            vmc vmc2 = (vmc)vmo2;
            vmc2.reset();
        }
        for (vmo vmo2 : TARGETS) {
            ((vkl)vmo2).reset();
        }
    }

    public static void capture(DrawContext drawContext, int n, float f, @Nullable GpuTextureView gpuTextureView) {
        int n2 = FROST.getInt();
        if (n > 0) {
            uij uij2;
            uij uij3 = uij2 = n == n2 && gpuTextureView == null ? uij.SCENE : uij.BACKDROP;
            if (uij2.capture(drawContext, n, null)) {
                uut.glass(drawContext, uij2.result(drawContext), 0.0f, 0.0f, drawContext.method_51421(), drawContext.method_51443(), 0.0f, 0, f);
            }
        }
        hyw = ENABLED.get() && uij.SCENE.capture(drawContext, n2, gpuTextureView);
    }

    public static void skip() {
        hyw = false;
    }

    public static uoy lens(float f) {
        return new uoy((float)REFRACTION.get(), f, (float)DISPERSION.get(), (float)HIGHLIGHT.get(), (float)VIBRANCY.get(), (float)LIGHT.get());
    }

    static boolean active(vkl vkl2) {
        return hyw && ENABLED.get() && vkl2.get();
    }

    public static boolean surface(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, int n2, float f6, vkl vkl2) {
        if (hyv.active(vkl2)) {
            boolean bl;
            boolean bl2 = bl = hyv.liquid() ? uut.liquid(drawContext, f, f2, f3, f4, f5, n, 1.0f, hyv.lens(f6)) : uut.glass(drawContext, f, f2, f3, f4, f5, n, 1.0f);
            if (bl) {
                return true;
            }
        }
        uut.round(drawContext, f, f2, f3, f4, f5, n2);
        return false;
    }

    public static int tint(int n, float f) {
        return ujt.withAlpha(n, Math.round(255.0f * Math.max(0.0f, Math.min(1.0f, f))));
    }

    private static /* synthetic */ int adx(int n, int n2) {
        return n - n2 + -2039058980;
    }

    private static /* synthetic */ int ady(int n, int n2) {
        return hyv.adx(n, n2) ^ 0xB62E66E3;
    }
}

