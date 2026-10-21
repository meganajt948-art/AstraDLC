/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_339
 *  net.minecraft.class_350
 *  net.minecraft.class_357
 *  net.minecraft.class_4068
 *  net.minecraft.class_4185$class_12231
 *  net.minecraft.class_437
 *  net.minecraft.class_5348
 *  net.minecraft.class_5676
 *  org.joml.Matrix3x2fStack
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.PanicShutdown;
import a.MenuScreen;
import a.MenuSceneRenderer;
import a.WallpaperEntry;
import a.WordmarkAnimator;
import a.kdv;
import a.keb;
import a.keg;
import a.FrameDelta;
import a.DrawUtil;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Reflect;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_339;
import net.minecraft.class_350;
import net.minecraft.class_357;
import net.minecraft.class_4068;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_5348;
import net.minecraft.class_5676;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;

public final class ButtonSkin {
    public static final boolean ENABLED = !"false".equalsIgnoreCase(System.getProperty("flow2.buttons"));
    private static final Map<class_339, keg> kek = new WeakHashMap<class_339, keg>();
    private static Field kel;
    private static Field kem;
    private static boolean ken;
    private static boolean keo;
    private static /* synthetic */ int kep;
    private static /* synthetic */ long keq;

    private ButtonSkin() {
    }

    public static void attach(class_437 class_4373) {
        if (!ENABLED || keo || class_4373 instanceof MenuScreen || PanicShutdown.armed()) {
            return;
        }
        try {
            ButtonSkin.ker(class_4373);
            ScreenEvents.beforeRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> ButtonSkin.ker(class_4372));
        }
        catch (Throwable throwable) {
            keo = true;
            System.out.println("button skin off: " + throwable);
        }
    }

    private static void ker(class_437 class_4372) {
        List list;
        if (keo || PanicShutdown.armed()) {
            return;
        }
        if (!ken) {
            ken = true;
            kel = Reflect.find(class_437.class, "net.minecraft.class_437", "field_33816", "Ljava/util/List;");
            kem = Reflect.find(class_357.class, "net.minecraft.class_357", "field_22753", "D");
        }
        if (kel == null) {
            keo = true;
            return;
        }
        try {
            list = (List)kel.get(class_4372);
        }
        catch (IllegalAccessException illegalAccessException) {
            keo = true;
            return;
        }
        int n = 0;
        for (int i = 0; i < list.size(); ++i) {
            class_339 class_3392;
            class_4068 class_40682 = (class_4068)list.get(i);
            if (class_40682 instanceof kdv || class_40682 instanceof keb) {
                ++n;
                continue;
            }
            if (class_40682 instanceof class_339 && ButtonSkin.kes(class_3392 = (class_339)class_40682)) {
                list.set(i, new kdv(class_4372, class_3392, (float)Math.min(n++, 14) * 0.018f));
                continue;
            }
            if (!(class_40682 instanceof class_350)) continue;
            class_350 class_3502 = (class_350)class_40682;
            list.set(i, new keb(class_4372, class_3502));
        }
    }

    private static boolean kes(class_339 class_3392) {
        Class<?> clazz = class_3392.getClass();
        return clazz == class_4185.class_12231.class || clazz == class_5676.class || class_3392 instanceof class_357;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ket(class_332 class_3322, class_339 class_3392, int n, int n2, float f, float f2) {
        if (!class_3392.field_22764) {
            return;
        }
        float f3 = class_3392.method_75798();
        class_3392.method_25350(0.0f);
        try {
            class_3392.method_25394(class_3322, n, n2, f);
        }
        finally {
            class_3392.method_25350(f3);
        }
        ButtonSkin.keu(class_3322, class_3392, n, n2, f3, f2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void keu(class_332 class_3322, class_339 class_3393, int n, int n2, float f, float f2) {
        boolean bl;
        if (f <= 0.003f) {
            return;
        }
        FrameDelta.observe(class_3322);
        keg keg2 = kek.computeIfAbsent(class_3393, class_3392 -> new keg(f2));
        float f3 = MenuSceneRenderer.clock();
        float f4 = FrameDelta.delta();
        float f5 = Easing.outCubic(Easing.clamp01((f3 - keg2.born - keg2.delay) / 0.26f));
        if (f5 <= 0.0f) {
            return;
        }
        boolean bl2 = class_3393.field_22763;
        class_310 class_3102 = class_310.method_1551();
        boolean bl3 = class_3393.method_25370() && class_3102.method_48186().method_48183();
        float f6 = keg2.hover.step(bl2 && (class_3393.method_49606() || bl3), f4);
        boolean bl4 = bl = GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1;
        if (bl && !keg2.down && bl2 && class_3393.method_49606()) {
            keg2.pressAt = f3;
            keg2.px = n - class_3393.method_46426();
        }
        keg2.down = bl;
        float f7 = Easing.clamp01((f3 - keg2.pressAt) / 0.5f);
        float f8 = f7 < 1.0f ? (float)Math.sin(Math.PI * (double)Easing.clamp01(f7 * 2.6f)) : 0.0f;
        float f9 = class_3393.method_25368();
        float f10 = class_3393.method_25364();
        float f11 = Math.min(f10 * 0.5f, 5.0f);
        int n3 = WallpaperEntry.selected().accent;
        float f12 = 1.0f - 0.035f * f8;
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate((float)class_3393.method_46426() + f9 * 0.5f, (float)class_3393.method_46427() + f10 * 0.5f + (1.0f - f5) * 4.0f);
        matrix3x2fStack.scale(f12, f12);
        matrix3x2fStack.translate(-f9 * 0.5f, -f10 * 0.5f);
        float f13 = f * f5;
        DrawUtil.pushAlpha(f13);
        try {
            DrawUtil.shadow(class_3322, 0.0f, 1.5f, f9, f10, f11, 7.0f, ButtonSkin.kez(0, 0.2f + 0.1f * f6));
            DrawUtil.round(class_3322, 0.0f, 0.0f, f9, f10, f11, ButtonSkin.kez(658965, bl2 ? 0.5f + 0.12f * f6 : 0.3f));
            if (f6 > 0.01f) {
                DrawUtil.round(class_3322, 0.0f, 0.0f, f9, f10, f11, ButtonSkin.kez(n3, 0.11f * f6));
            }
            DrawUtil.gradient(class_3322, 0.0f, 0.0f, f9, f10 * 0.5f, f11, f11, 0.0f, 0.0f, ButtonSkin.kez(0xFFFFFF, 0.06f), ButtonSkin.kez(0xFFFFFF, 0.06f), ButtonSkin.kez(0xFFFFFF, 0.0f), ButtonSkin.kez(0xFFFFFF, 0.0f));
            if (class_3393 instanceof class_357) {
                ButtonSkin.kev(class_3322, class_3393, f9, f10, f11, f6, n3, bl2);
            }
            int n4 = WordmarkAnimator.AutoTpAccept(0xFFFFFF, n3, f6);
            DrawUtil.outlineGradientV(class_3322, 0.0f, 0.0f, f9, f10, f11, 0.6f, ButtonSkin.kez(n4, (bl2 ? 0.17f : 0.08f) + 0.45f * f6), ButtonSkin.kez(n4, (bl2 ? 0.05f : 0.03f) + 0.25f * f6));
            if (f7 < 1.0f) {
                float f14 = f9 * Easing.outCubic(f7);
                float f15 = Math.max(0.0f, keg2.px - f14);
                float f16 = Math.min(f9, keg2.px + f14);
                DrawUtil.round(class_3322, f15, 0.0f, f16 - f15, f10, f11, ButtonSkin.kez(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n3, 0.4f), 0.24f * (1.0f - f7)));
                float f17 = 5.0f * Easing.outCubic(f7);
                DrawUtil.outline(class_3322, -f17, -f17, f9 + 2.0f * f17, f10 + 2.0f * f17, f11 + f17, 0.8f, ButtonSkin.kez(n3, 0.6f * (1.0f - f7)));
            }
            ButtonSkin.kew(class_3322, class_3393, f9, f10, f6, bl2, f13);
        }
        finally {
            DrawUtil.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private static void kev(class_332 class_3322, class_339 class_3392, float f, float f2, float f3, float f4, int n, boolean bl) {
        double d = 0.0;
        try {
            d = kem != null ? kem.getDouble(class_3392) : 0.0;
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        float f5 = (float)Math.max(0.0, Math.min(1.0, d));
        float f6 = Math.max(f3, 5.0f);
        float f7 = f - f6 * 2.0f;
        float f8 = f6 + f7 * f5;
        DrawUtil.round(class_3322, 0.0f, 0.0f, Math.max(f3 * 2.0f, f8), f2, f3, ButtonSkin.kez(n, (bl ? 0.12f : 0.06f) + 0.08f * f4));
        float f9 = f2 - 3.6f;
        DrawUtil.round(class_3322, f6, f9 - 0.5f, f7, 1.0f, 0.5f, ButtonSkin.kez(0xFFFFFF, 0.14f));
        DrawUtil.round(class_3322, f6, f9 - 0.5f, f8 - f6, 1.0f, 0.5f, ButtonSkin.kez(n, bl ? 0.9f : 0.4f));
        DrawUtil.circle(class_3322, f8, f9, 1.7f + 0.5f * f4, ButtonSkin.kez(WordmarkAnimator.AutoTpAccept(0xFFFFFF, n, 0.2f), bl ? 1.0f : 0.5f));
    }

    private static void kew(class_332 class_3322, class_339 class_3392, float f, float f2, float f3, boolean bl, float f4) {
        class_2561 class_25612 = class_3392.method_25369();
        String string = class_25612.getString();
        int n = bl ? WordmarkAnimator.AutoTpAccept(15133683, 0xFFFFFF, f3) : 8028814;
        FontFace vdn2 = Fonts.semibold(6.9f);
        if ((!bl || ButtonSkin.kex(class_25612)) && ButtonSkin.key(vdn2, string)) {
            String string2 = vdn2.ellipsize(string, f - 8.0f);
            vdn2.drawCentered(class_3322, string2, f * 0.5f, vdn2.centerTop(f2 * 0.5f), ButtonSkin.kez(n, 1.0f));
            return;
        }
        class_327 class_3272 = class_310.method_1551().field_1772;
        int n2 = Math.round(255.0f * Math.max(0.0f, Math.min(1.0f, f4)));
        if (n2 < 5) {
            return;
        }
        int n3 = class_3272.method_27525((class_5348)class_25612);
        if ((float)n3 <= f - 6.0f) {
            class_3322.method_51439(class_3272, class_25612, Math.round((f - (float)n3) * 0.5f), Math.round(f2 * 0.5f - 4.0f), n2 << 24 | 0xFFFFFF, false);
        } else {
            String string3 = class_3272.method_27523(string, Math.max(0, Math.round(f - 6.0f) - class_3272.method_1727("..."))) + "...";
            class_3322.method_51433(class_3272, string3, Math.round((f - (float)class_3272.method_1727(string3)) * 0.5f), Math.round(f2 * 0.5f - 4.0f), n2 << 24 | n & 0xFFFFFF, false);
        }
    }

    private static boolean kex(class_2561 class_25612) {
        Optional optional = class_25612.method_27658((class_25832, string) -> class_25832.method_10973() != null ? Optional.of(Boolean.TRUE) : Optional.empty(), class_2583.field_24360);
        return optional.isEmpty();
    }

    private static boolean key(FontFace vdn2, String string) {
        int n;
        for (int i = 0; i < string.length(); i += Character.charCount(n)) {
            n = string.codePointAt(i);
            if (Character.isWhitespace(n) || vdn2.canDisplay(n)) continue;
            return false;
        }
        return true;
    }

    private static int kez(int n, float f) {
        return WordmarkAnimator.rgba(n, f);
    }

    private static /* synthetic */ int asr(int n, int n2) {
        return n * n2 | 0x9EB9831D;
    }

    private static /* synthetic */ int ass(int n, int n2) {
        return ButtonSkin.asr(n, n2) + n;
    }
}

