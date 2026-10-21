/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_746
 *  net.minecraft.class_9779
 */
package a;

import a.Theme;
import a.Module;
import a.ItemTransform;
import a.ColorUtil;
import a.FrameDelta;
import a.DrawUtil;
import a.Spring;
import a.FontFace;
import a.Fonts;
import flow.Flow;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_746;
import net.minecraft.class_9779;

public final class SmashHud {
    private static final FontFace rhg = Fonts.semibold(6.0f);
    private static final Spring rhh = new Spring(10.0f);
    private static final Spring rhi = new Spring(12.0f);
    private static final Spring rhj = new Spring(6.0f);
    private static long rhk = -1L;
    private static float rhl;
    private static /* synthetic */ String rhm;
    private static /* synthetic */ long rhn;

    private SmashHud() {
    }

    private static boolean rho() {
        if (Flow.getInstance().getModuleManager() == null) {
            return false;
        }
        for (Module kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            ItemTransform rxa2;
            if (!(kfe2 instanceof ItemTransform) || !(rxa2 = (ItemTransform)kfe2).maceCharge()) continue;
            return true;
        }
        return false;
    }

    static float smashBonus(double d) {
        if (d <= 1.5) {
            return 0.0f;
        }
        if (d <= 3.0) {
            return (float)(4.0 * d);
        }
        if (d <= 8.0) {
            return (float)(12.0 + 2.0 * (d - 3.0));
        }
        return (float)(22.0 + (d - 8.0));
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        class_310 class_3102 = class_310.method_1551();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 != null || !class_3102.field_1690.method_31044().method_31034()) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rhk) {
            return;
        }
        rhk = FrameDelta.frame();
        float f = FrameDelta.delta();
        boolean bl = class_7462.method_6047().method_31574(class_1802.field_49814) && SmashHud.rho();
        float f2 = class_97792.method_60637(true);
        float f3 = bl ? class_7462.method_7261(f2) : 1.0f;
        double d = class_7462.field_6017;
        boolean bl2 = bl && !class_7462.method_24828() && !class_7462.method_6128() && d > 1.5;
        rhl = f3 >= 0.999f ? rhl + f : 0.0f;
        boolean bl3 = bl && (f3 < 0.999f || rhl < 0.6f || bl2);
        float f4 = rhh.step(bl3, f);
        float f5 = rhi.step(bl2, f);
        float f6 = rhj.step(f3 >= 0.999f, f);
        if (f4 <= 0.01f) {
            return;
        }
        DrawUtil.beginFrame();
        float f7 = (float)class_3322.method_51421() * 0.5f;
        float f8 = (float)class_3322.method_51443() * 0.5f;
        float f9 = 11.0f;
        int n = ColorUtil.lerp(Theme.accent() | 0xFF000000, -11443, f5);
        DrawUtil.pushAlpha(f4);
        DrawUtil.arc(class_3322, f7, f8, f9, 1.6f, 0.0f, 1.0f, 0x40FFFFFF);
        DrawUtil.arc(class_3322, f7, f8, f9, 1.6f, 0.0f, Math.max(0.001f, f3), n);
        float f10 = Math.max(f6 * (1.0f - Math.min(1.0f, rhl / 0.6f)), f5);
        if (f10 > 0.02f) {
            DrawUtil.additive(true);
            DrawUtil.shadow(class_3322, f7 - f9, f8 - f9, f9 * 2.0f, f9 * 2.0f, f9, 5.0f, ColorUtil.withAlpha(n, Math.round(70.0f * f10)));
            DrawUtil.additive(false);
        }
        if (f5 > 0.02f) {
            float f11 = SmashHud.smashBonus(d);
            float f12 = Math.min(1.0f, f11 / 22.0f);
            DrawUtil.pushAlpha(f5);
            DrawUtil.arc(class_3322, f7, f8, f9 + 3.2f, 1.2f, 0.0f, Math.max(0.001f, f12), ColorUtil.withAlpha(-5720, 230));
            String string = "+" + Math.round(f11);
            rhg.drawCentered(class_3322, string, f7, rhg.centerTop(f8 + f9 + 9.0f), -8054);
            DrawUtil.popAlpha();
        }
        DrawUtil.popAlpha();
    }

    private static /* synthetic */ int byq(int n, int n2) {
        return n + n2 ^ 0xB5AE2AA3;
    }

    private static /* synthetic */ int byr(int n, int n2) {
        return n * n2 | 0xB0850162;
    }
}

