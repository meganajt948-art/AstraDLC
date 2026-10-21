/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_332
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.SceneCapture;
import a.ColorUtil;
import a.GlassParams;
import a.DrawUtil;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.util.List;
import net.minecraft.class_332;
import org.jspecify.annotations.Nullable;

public final class LiquidGlass {
    public static final BoolSetting ENABLED = new BoolSetting("Liquid Glass", false);
    public static final ModeSetting STYLE = new ModeSetting("Style", "Liquid", "Liquid", "Frosted");
    public static final NumberSetting FROST = new NumberSetting("Frost", 2.0, 0.0, 6.0, 1.0);
    public static final NumberSetting REFRACTION = new NumberSetting("Refraction", 0.7, 0.0, 1.0, 0.01).percent();
    public static final NumberSetting EDGE = new NumberSetting("Edge", 12.0, 2.0, 30.0, 1.0).unit("px");
    public static final NumberSetting DISPERSION = new NumberSetting("Dispersion", 0.4, 0.0, 1.0, 0.01).percent();
    public static final NumberSetting HIGHLIGHT = new NumberSetting("Highlight", 0.7, 0.0, 1.0, 0.01).percent();
    public static final NumberSetting LIGHT = new NumberSetting("Light angle", 225.0, 0.0, 355.0, 5.0).unit("°");
    public static final NumberSetting VIBRANCY = new NumberSetting("Vibrancy", 1.15, 0.0, 2.0, 0.05).percent();
    public static final NumberSetting TINT = new NumberSetting("Tint", 0.8, 0.1, 1.0, 0.01).percent();
    public static final BoolSetting WINDOW = new BoolSetting("Window", true);
    public static final BoolSetting TABS = new BoolSetting("Tab pill", true);
    public static final BoolSetting CARDS = new BoolSetting("Group boxes", true);
    public static final BoolSetting POPUPS = new BoolSetting("Popups", true);
    static final List<Setting> OPTICS = List.of(STYLE, FROST, TINT, REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT, VIBRANCY);
    static final List<Setting> LIQUID_ONLY = List.of(REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT);
    static final List<Setting> TARGETS = List.of(WINDOW, TABS, CARDS, POPUPS);
    static final List<Setting> ALL = List.of(ENABLED, STYLE, FROST, TINT, REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT, VIBRANCY, WINDOW, TABS, CARDS, POPUPS);
    private static boolean hyw;
    private static /* synthetic */ long hyx;
    private static /* synthetic */ boolean hyy;

    private LiquidGlass() {
    }

    public static boolean liquid() {
        return STYLE.is("Liquid");
    }

    static void resetAll() {
        ENABLED.reset();
        STYLE.reset();
        for (Setting vmo2 : OPTICS) {
            if (!(vmo2 instanceof NumberSetting)) continue;
            NumberSetting vmc2 = (NumberSetting)vmo2;
            vmc2.reset();
        }
        for (Setting vmo2 : TARGETS) {
            ((BoolSetting)vmo2).reset();
        }
    }

    public static void capture(class_332 class_3322, int n, float f, @Nullable GpuTextureView gpuTextureView) {
        int n2 = FROST.getInt();
        if (n > 0) {
            SceneCapture uij2;
            SceneCapture uij3 = uij2 = n == n2 && gpuTextureView == null ? SceneCapture.SCENE : SceneCapture.BACKDROP;
            if (uij2.capture(class_3322, n, null)) {
                DrawUtil.glass(class_3322, uij2.result(class_3322), 0.0f, 0.0f, class_3322.method_51421(), class_3322.method_51443(), 0.0f, 0, f);
            }
        }
        hyw = ENABLED.get() && SceneCapture.SCENE.capture(class_3322, n2, gpuTextureView);
    }

    public static void skip() {
        hyw = false;
    }

    public static GlassParams lens(float f) {
        return new GlassParams((float)REFRACTION.get(), f, (float)DISPERSION.get(), (float)HIGHLIGHT.get(), (float)VIBRANCY.get(), (float)LIGHT.get());
    }

    static boolean active(BoolSetting vkl2) {
        return hyw && ENABLED.get() && vkl2.get();
    }

    public static boolean surface(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, int n2, float f6, BoolSetting vkl2) {
        if (LiquidGlass.active(vkl2)) {
            boolean bl;
            boolean bl2 = bl = LiquidGlass.liquid() ? DrawUtil.liquid(class_3322, f, f2, f3, f4, f5, n, 1.0f, LiquidGlass.lens(f6)) : DrawUtil.glass(class_3322, f, f2, f3, f4, f5, n, 1.0f);
            if (bl) {
                return true;
            }
        }
        DrawUtil.round(class_3322, f, f2, f3, f4, f5, n2);
        return false;
    }

    public static int tint(int n, float f) {
        return ColorUtil.withAlpha(n, Math.round(255.0f * Math.max(0.0f, Math.min(1.0f, f))));
    }

    private static /* synthetic */ int adx(int n, int n2) {
        return n - n2 + -2039058980;
    }

    private static /* synthetic */ int ady(int n, int n2) {
        return LiquidGlass.adx(n, n2) ^ 0xB62E66E3;
    }
}

