/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_3675$class_307
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.Theme;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.IconRenderer;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import org.lwjgl.glfw.GLFW;

public final class UiKit {
    static final FontFace LOGO = Fonts.bold(12.5f);
    static final FontFace TAB = Fonts.medium(7.5f);
    static final FontFace SECTION = Fonts.semibold(5.5f);
    static final FontFace TITLE = Fonts.semibold(12.0f);
    static final FontFace SUBTITLE = Fonts.regular(6.5f);
    static final FontFace CARD_TITLE = Fonts.semibold(7.5f);
    static final FontFace LABEL = Fonts.regular(7.0f);
    static final FontFace VALUE = Fonts.medium(6.5f);
    static final FontFace SMALL = Fonts.medium(5.5f);
    static final FontFace NAME = Fonts.medium(7.0f);
    static final FontFace AVATAR = Fonts.bold(7.5f);
    static final float ICON = 9.5f;
    static final float ICON_SMALL = 7.0f;
    public static final float SWITCH_W = 17.0f;
    public static final float SWITCH_H = 9.5f;
    private static /* synthetic */ boolean irs;
    private static /* synthetic */ boolean irt;

    private UiKit() {
    }

    static boolean inside(double d, double d2, float f, float f2, float f3, float f4) {
        return d >= (double)f && d < (double)(f + f3) && d2 >= (double)f2 && d2 < (double)(f2 + f4);
    }

    public static void drawSwitch(class_332 class_3322, float f, float f2, float f3, float f4) {
        float f5 = 4.75f;
        float f6 = Theme.lightness();
        DrawUtil.round(class_3322, f, f2, 17.0f, 9.5f, f5, ColorUtil.lerp(Theme.track, Theme.fieldHover, f4 * 0.6f));
        if (f3 > 0.01f) {
            DrawUtil.pushAlpha(f3);
            DrawUtil.gradientH(class_3322, f, f2, 17.0f, 9.5f, f5, Theme.accent(), Theme.accent2());
            DrawUtil.popAlpha();
        }
        GlassDraw.inset(class_3322, f, f2, 17.0f, 9.5f, f5, f6);
        float f7 = f5 - 1.5f;
        float f8 = f + f5 + 7.5f * f3;
        float f9 = f2 + f5;
        float f10 = f7 * 0.9f * (1.0f - Math.abs(2.0f * f3 - 1.0f));
        float f11 = f7 * 2.0f + f10;
        DrawUtil.shadow(class_3322, f8 - f11 * 0.5f, f9 - f7 + 0.7f, f11, f7 * 2.0f, f7, 1.4f, 0x66000000);
        int n = ColorUtil.lerp(Theme.knob, -1, f3);
        DrawUtil.gradientV(class_3322, f8 - f11 * 0.5f, f9 - f7, f11, f7 * 2.0f, f7, ColorUtil.lerp(n, -1, 0.35f), ColorUtil.shade(n, 0.86f));
    }

    static void primaryButton(class_332 class_3322, String string, Icon vhz2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = Theme.r(5.0f);
        float f8 = 1.0f - 0.05f * f6;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f + f3 * 0.5f, f2 + f4 * 0.5f + 0.6f * f6 - 0.4f * f5);
        class_3322.method_51448().scale(f8, f8);
        class_3322.method_51448().translate(-f3 * 0.5f, -f4 * 0.5f);
        GlassDraw.shadow(class_3322, 0.0f, 0.0f, f3, f4, f7, 0.4f + 0.6f * f5 - 0.4f * f6, Theme.lightness());
        DrawUtil.gradientH(class_3322, 0.0f, 0.0f, f3, f4, f7, ColorUtil.lerp(Theme.accent(), -1, 0.1f * f5), ColorUtil.lerp(Theme.accent2(), -1, 0.1f * f5));
        GlassDraw.sheen(class_3322, 0.0f, 0.0f, f3, f4, f7, 1.8f);
        DrawUtil.outlineGradientV(class_3322, 0.0f, 0.0f, f3, f4, f7, 1.0f, 0x40FFFFFF, 0x10000000);
        UiKit.iru(class_3322, string, vhz2, f3, f4, Theme.onAccent());
        class_3322.method_51448().popMatrix();
    }

    static void secondaryButton(class_332 class_3322, String string, Icon vhz2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = Theme.r(5.0f);
        float f8 = 1.0f - 0.05f * f6;
        float f9 = Theme.lightness();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f + f3 * 0.5f, f2 + f4 * 0.5f + 0.6f * f6 - 0.4f * f5);
        class_3322.method_51448().scale(f8, f8);
        class_3322.method_51448().translate(-f3 * 0.5f, -f4 * 0.5f);
        GlassDraw.shadow(class_3322, 0.0f, 0.0f, f3, f4, f7, 0.2f + 0.6f * f5 - 0.2f * f6, f9);
        DrawUtil.round(class_3322, 0.0f, 0.0f, f3, f4, f7, ColorUtil.lerp(Theme.field, Theme.fieldHover, f5));
        GlassDraw.rim(class_3322, 0.0f, 0.0f, f3, f4, f7, f9, 0.7f + 0.5f * f5);
        UiKit.iru(class_3322, string, vhz2, f3, f4, ColorUtil.lerp(Theme.textDim, Theme.text, f5));
        class_3322.method_51448().popMatrix();
    }

    private static void iru(class_332 class_3322, String string, Icon vhz2, float f, float f2, int n) {
        float f3 = vhz2 != null ? 7.0f + (string.isEmpty() ? 0.0f : 4.0f) : 0.0f;
        float f4 = VALUE.width(string) + f3;
        float f5 = (f - f4) * 0.5f;
        if (vhz2 != null) {
            IconRenderer.draw(class_3322, vhz2, f5 + 3.5f, f2 * 0.5f, 7.0f, n);
        }
        VALUE.draw(class_3322, string, f5 + f3, VALUE.centerTop(f2 * 0.5f), n);
    }

    static void iconButton(class_332 class_3322, Icon vhz2, float f, float f2, float f3, float f4, boolean bl, float f5) {
        int n;
        if (f5 <= 0.01f) {
            return;
        }
        DrawUtil.pushAlpha(f5);
        int n2 = n = bl ? -1750963 : Theme.accent();
        if (f4 > 0.01f || bl) {
            DrawUtil.round(class_3322, f, f2, f3, f3, Theme.r(4.0f), bl ? ColorUtil.withAlpha(-1750963, (int)(60.0f + 90.0f * f4)) : ColorUtil.withAlpha(n, (int)(40.0f * f4)));
        }
        int n3 = bl ? -1 : ColorUtil.lerp(Theme.textDim, n, f4);
        IconRenderer.draw(class_3322, vhz2, f + f3 * 0.5f, f2 + f3 * 0.5f, 7.5f, n3);
        DrawUtil.popAlpha();
    }

    static float drawChip(class_332 class_3322, String string, float f, float f2, int n, int n2, float f3) {
        float f4 = Math.max(16.0f, SMALL.width(string) + 9.0f);
        float f5 = 11.0f;
        float f6 = f - f4;
        float f7 = Theme.r(3.5f);
        DrawUtil.round(class_3322, f6, f2 - f5 * 0.5f, f4, f5, f7, ColorUtil.lerp(Theme.field, Theme.fieldHover, f3));
        DrawUtil.outline(class_3322, f6, f2 - f5 * 0.5f, f4, f5, f7, 1.0f, n2);
        GlassDraw.rim(class_3322, f6, f2 - f5 * 0.5f, f4, f5, f7, Theme.lightness(), 0.5f);
        SMALL.drawCentered(class_3322, string, f6 + f4 * 0.5f, SMALL.centerTop(f2), n);
        return f6;
    }

    public static String keyName(int n) {
        if (n == -1) {
            return Lang.s("None", "Нет");
        }
        int n2 = KeyUtil.mods(n);
        if (n2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if ((n2 & 2) != 0) {
                stringBuilder.append("CTRL + ");
            }
            if ((n2 & 1) != 0) {
                stringBuilder.append("SHIFT + ");
            }
            if ((n2 & 4) != 0) {
                stringBuilder.append("ALT + ");
            }
            return stringBuilder.append(UiKit.keyName(KeyUtil.baseKey(n))).toString();
        }
        if (KeyUtil.isMouse(n)) {
            int n3 = KeyUtil.mouseButton(n);
            return switch (n3) {
                case 0 -> Lang.s("LMB", "ЛКМ");
                case 1 -> Lang.s("RMB", "ПКМ");
                case 2 -> Lang.s("MMB", "СКМ");
                default -> Lang.s("Mouse ", "Мышь ") + (n3 + 1);
            };
        }
        switch (n) {
            case 340: {
                return "LShift";
            }
            case 344: {
                return "RShift";
            }
            case 341: {
                return "LCtrl";
            }
            case 345: {
                return "RCtrl";
            }
            case 342: {
                return "LAlt";
            }
            case 346: {
                return "RAlt";
            }
            case 32: {
                return Lang.s("Space", "Пробел");
            }
            case 258: {
                return "Tab";
            }
            case 280: {
                return "Caps";
            }
            case 257: {
                return "Enter";
            }
            case 260: {
                return "Ins";
            }
            case 261: {
                return "Del";
            }
            case 268: {
                return "Home";
            }
            case 269: {
                return "End";
            }
            case 266: {
                return "PgUp";
            }
            case 267: {
                return "PgDn";
            }
            case 265: {
                return Lang.s("Up", "Вверх");
            }
            case 264: {
                return Lang.s("Down", "Вниз");
            }
            case 263: {
                return Lang.s("Left", "Влево");
            }
            case 262: {
                return Lang.s("Right", "Вправо");
            }
        }
        if (n >= 290 && n <= 314) {
            return "F" + (n - 290 + 1);
        }
        if (n >= 320 && n <= 329) {
            return "Num" + (n - 320);
        }
        if (n >= 65 && n <= 90 || n >= 48 && n <= 57) {
            return String.valueOf((char)n);
        }
        String string = GLFW.glfwGetKeyName((int)n, (int)0);
        if (string != null && !string.isEmpty()) {
            return string.toUpperCase();
        }
        try {
            return class_3675.class_307.field_1668.method_1447(n).method_27445().getString();
        }
        catch (RuntimeException runtimeException) {
            return "#" + n;
        }
    }

    private static /* synthetic */ int aja(int n, int n2) {
        return (n ^ n2) + 1189472346;
    }

    private static /* synthetic */ int ajb(int n, int n2) {
        return n - n2 | 0xB295E576;
    }

    private static /* synthetic */ int ajc(int n, int n2) {
        return n * n2 ^ 0x6A78E7E6;
    }
}

