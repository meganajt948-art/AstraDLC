/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.util.InputUtil$Type
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.iov;
import a.ujt;
import a.ukf;
import a.uut;
import a.vdn;
import a.veo;
import a.vhz;
import a.vjf;
import a.vzz;
import a.wap;
import flow.dev.a;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class irr {
    static final vdn LOGO = veo.bold(12.5f);
    static final vdn TAB = veo.medium(7.5f);
    static final vdn SECTION = veo.semibold(5.5f);
    static final vdn TITLE = veo.semibold(12.0f);
    static final vdn SUBTITLE = veo.regular(6.5f);
    static final vdn CARD_TITLE = veo.semibold(7.5f);
    static final vdn LABEL = veo.regular(7.0f);
    static final vdn VALUE = veo.medium(6.5f);
    static final vdn SMALL = veo.medium(5.5f);
    static final vdn NAME = veo.medium(7.0f);
    static final vdn AVATAR = veo.bold(7.5f);
    static final float ICON = 9.5f;
    static final float ICON_SMALL = 7.0f;
    public static final float SWITCH_W = 17.0f;
    public static final float SWITCH_H = 9.5f;
    private static /* synthetic */ boolean irs;
    private static /* synthetic */ boolean irt;

    private irr() {
    }

    static boolean inside(double d, double d2, float f, float f2, float f3, float f4) {
        return d >= (double)f && d < (double)(f + f3) && d2 >= (double)f2 && d2 < (double)(f2 + f4);
    }

    public static void drawSwitch(DrawContext drawContext, float f, float f2, float f3, float f4) {
        float f5 = 4.75f;
        float f6 = iov.lightness();
        uut.round(drawContext, f, f2, 17.0f, 9.5f, f5, ujt.lerp(iov.track, iov.fieldHover, f4 * 0.6f));
        if (f3 > 0.01f) {
            uut.pushAlpha(f3);
            uut.gradientH(drawContext, f, f2, 17.0f, 9.5f, f5, iov.accent(), iov.accent2());
            uut.popAlpha();
        }
        ukf.inset(drawContext, f, f2, 17.0f, 9.5f, f5, f6);
        float f7 = f5 - 1.5f;
        float f8 = f + f5 + 7.5f * f3;
        float f9 = f2 + f5;
        float f10 = f7 * 0.9f * (1.0f - Math.abs(2.0f * f3 - 1.0f));
        float f11 = f7 * 2.0f + f10;
        uut.shadow(drawContext, f8 - f11 * 0.5f, f9 - f7 + 0.7f, f11, f7 * 2.0f, f7, 1.4f, 0x66000000);
        int n = ujt.lerp(iov.knob, -1, f3);
        uut.gradientV(drawContext, f8 - f11 * 0.5f, f9 - f7, f11, f7 * 2.0f, f7, ujt.lerp(n, -1, 0.35f), ujt.shade(n, 0.86f));
    }

    static void primaryButton(DrawContext drawContext, String string, vhz vhz2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = iov.r(5.0f);
        float f8 = 1.0f - 0.05f * f6;
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(f + f3 * 0.5f, f2 + f4 * 0.5f + 0.6f * f6 - 0.4f * f5);
        drawContext.getMatrices().scale(f8, f8);
        drawContext.getMatrices().translate(-f3 * 0.5f, -f4 * 0.5f);
        ukf.shadow(drawContext, 0.0f, 0.0f, f3, f4, f7, 0.4f + 0.6f * f5 - 0.4f * f6, iov.lightness());
        uut.gradientH(drawContext, 0.0f, 0.0f, f3, f4, f7, ujt.lerp(iov.accent(), -1, 0.1f * f5), ujt.lerp(iov.accent2(), -1, 0.1f * f5));
        ukf.sheen(drawContext, 0.0f, 0.0f, f3, f4, f7, 1.8f);
        uut.outlineGradientV(drawContext, 0.0f, 0.0f, f3, f4, f7, 1.0f, 0x40FFFFFF, 0x10000000);
        irr.iru(drawContext, string, vhz2, f3, f4, iov.onAccent());
        drawContext.getMatrices().popMatrix();
    }

    static void secondaryButton(DrawContext drawContext, String string, vhz vhz2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = iov.r(5.0f);
        float f8 = 1.0f - 0.05f * f6;
        float f9 = iov.lightness();
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(f + f3 * 0.5f, f2 + f4 * 0.5f + 0.6f * f6 - 0.4f * f5);
        drawContext.getMatrices().scale(f8, f8);
        drawContext.getMatrices().translate(-f3 * 0.5f, -f4 * 0.5f);
        ukf.shadow(drawContext, 0.0f, 0.0f, f3, f4, f7, 0.2f + 0.6f * f5 - 0.2f * f6, f9);
        uut.round(drawContext, 0.0f, 0.0f, f3, f4, f7, ujt.lerp(iov.field, iov.fieldHover, f5));
        ukf.rim(drawContext, 0.0f, 0.0f, f3, f4, f7, f9, 0.7f + 0.5f * f5);
        irr.iru(drawContext, string, vhz2, f3, f4, ujt.lerp(iov.textDim, iov.text, f5));
        drawContext.getMatrices().popMatrix();
    }

    private static void iru(DrawContext drawContext, String string, vhz vhz2, float f, float f2, int n) {
        float f3 = vhz2 != null ? 7.0f + (string.isEmpty() ? 0.0f : 4.0f) : 0.0f;
        float f4 = VALUE.width(string) + f3;
        float f5 = (f - f4) * 0.5f;
        if (vhz2 != null) {
            vjf.draw(drawContext, vhz2, f5 + 3.5f, f2 * 0.5f, 7.0f, n);
        }
        VALUE.draw(drawContext, string, f5 + f3, VALUE.centerTop(f2 * 0.5f), n);
    }

    static void iconButton(DrawContext drawContext, vhz vhz2, float f, float f2, float f3, float f4, boolean bl, float f5) {
        int n;
        if (f5 <= 0.01f) {
            return;
        }
        uut.pushAlpha(f5);
        int n2 = n = bl ? -1750963 : iov.accent();
        if (f4 > 0.01f || bl) {
            uut.round(drawContext, f, f2, f3, f3, iov.r(4.0f), bl ? ujt.withAlpha(-1750963, (int)(60.0f + 90.0f * f4)) : ujt.withAlpha(n, (int)(40.0f * f4)));
        }
        int n3 = bl ? -1 : ujt.lerp(iov.textDim, n, f4);
        vjf.draw(drawContext, vhz2, f + f3 * 0.5f, f2 + f3 * 0.5f, 7.5f, n3);
        uut.popAlpha();
    }

    static float drawChip(DrawContext drawContext, String string, float f, float f2, int n, int n2, float f3) {
        float f4 = Math.max(16.0f, SMALL.width(string) + 9.0f);
        float f5 = 11.0f;
        float f6 = f - f4;
        float f7 = iov.r(3.5f);
        uut.round(drawContext, f6, f2 - f5 * 0.5f, f4, f5, f7, ujt.lerp(iov.field, iov.fieldHover, f3));
        uut.outline(drawContext, f6, f2 - f5 * 0.5f, f4, f5, f7, 1.0f, n2);
        ukf.rim(drawContext, f6, f2 - f5 * 0.5f, f4, f5, f7, iov.lightness(), 0.5f);
        SMALL.drawCentered(drawContext, string, f6 + f4 * 0.5f, SMALL.centerTop(f2), n);
        return f6;
    }

    public static String keyName(int n) {
        if (n == -1) {
            return wap.s(a.b("\u182a\u61ba\ueb68\u7512", 1969428576), a.b("\ue596\u9c0f\u16ab", 566026632));
        }
        int n2 = vzz.mods(n);
        if (n2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if ((n2 & 2) != 0) {
                stringBuilder.append(a.d("\ud987\ua021\u2af4\ub49b\u3f20\ub99a\u03c2", -1515651032, -1524901397));
            }
            if ((n2 & 1) != 0) {
                stringBuilder.append(a.b("\u2c9f\u5535\udfe7\u4199\uca5c\u4c99\uf6c1\u7f3b", -1006818108));
            }
            if ((n2 & 4) != 0) {
                stringBuilder.append(a.b("\u0999\u7025\ufaee\u64eb\uef37\u698d", 472386014));
            }
            return stringBuilder.append(irr.keyName(vzz.baseKey(n))).toString();
        }
        if (vzz.isMouse(n)) {
            int n3 = vzz.mouseButton(n);
            return switch (n3) {
                case 0 -> wap.s(a.b("\ua7a3\ude13\u54cf", 806201324), a.d("\u55e1\u2c51\ua684", -1056962709, -240494958));
                case 1 -> wap.s(a.c(-602901494, "\u745b\u0df5\u8729"), a.c(1633381882, "\u69e6\u1052\u9a87"));
                case 2 -> wap.s(a.c(29176179, "\u313d\u488c\uc250"), a.c(1059229501, "\u8b1f\uf295\u7840"));
                default -> wap.s(a.b("\udd50\ua4c3\u2e0a\ub07d\u3bbc\ubd48", -1973035749), a.c(-280990112, "\u6a79\u139f\u994f\u073a\u8881")) + (n3 + 1);
            };
        }
        switch (n) {
            case 340: {
                return a.c(-760836543, "\u8e0b\uf7a5\u7d4d\ue33d\u68e5\uee46");
            }
            case 344: {
                return a.b("\u8fcf\uf67f\u7c97\ue2e7\u693f\uef9c", 1732546459);
            }
            case 341: {
                return a.d("\u1251\u6bef\ue10b\u7f7c\uf4b5", -1331387698, 778088662);
            }
            case 345: {
                return a.b("\ue0bf\u991f\u13fb\u8d8c\u0645", -1264000792);
            }
            case 342: {
                return a.c(-1129728427, "\ub61d\ucfa1\u455f\udb36");
            }
            case 346: {
                return a.c(-113249067, "\uf483\u8d21\u07df\u99b6");
            }
            case 32: {
                return wap.s(a.d("\u9e55\ue7c7\u6d05\uf376\u78a7", 1309349884, -1637185025), a.c(156611631, "\ub036\uc9d8\u4375\udd0b\u56d8\ud067"));
            }
            case 258: {
                return a.c(2131715984, "\u67c7\u1e43\u9493");
            }
            case 280: {
                return a.b("\u24f4\u5d67\ud7a5\u49d7", -1700846413);
            }
            case 257: {
                return a.b("\uac96\ud50c\u5fc5\uc1a5\u4a65", -1316246314);
            }
            case 260: {
                return a.d("\u9dcd\ue45b\u6e95", 990680040, -791933329);
            }
            case 261: {
                return a.b("\ue479\u9de9\u1733", -1963072450);
            }
            case 268: {
                return a.b("\u9b31\ue2a7\u6876\uf60f", 1125161853);
            }
            case 269: {
                return a.d("\u2b92\u5208\ud8d1", 1150987827, 1729791463);
            }
            case 266: {
                return a.d("\u7bc4\u0242\u88a3\u16f7", 1376238149, -1000422955);
            }
            case 267: {
                return a.b("\u787c\u01fa\u8b0a\u1551", 752646184);
            }
            case 265: {
                return wap.s(a.c(1279384849, "\udd46\ua4d2"), a.c(800052892, "\ud28b\uab1a\u21ce\ubfca\u3418"));
            }
            case 264: {
                return wap.s(a.c(383679204, "\u7aa4\u033e\u89f5\u179d"), a.c(2001079959, "\u0a81\u731f\uf9c9\u67b7"));
            }
            case 263: {
                return wap.s(a.b("\u45d7\u3c4f\ub69f\u28fc", 881280415), a.b("\u3e0d\u4795\ucd48\u533e\ud8e5", 773863962));
            }
            case 262: {
                return wap.s(a.b("\u7e66\u07ec\u8d31\u134f\u9884", -325616079), a.d("\ud082\ua91e\u23b2\ubdb3\u3666\ub0db", 1583723691, 341925949));
            }
        }
        if (n >= 290 && n <= 314) {
            return a.c(-1135448250, "\u6f01") + (n - 290 + 1);
        }
        if (n >= 320 && n <= 329) {
            return a.c(-1094911395, "\ufa10\u839a\u0951") + (n - 320);
        }
        if (n >= 65 && n <= 90 || n >= 48 && n <= 57) {
            return String.valueOf((char)n);
        }
        String string = GLFW.glfwGetKeyName((int)n, (int)0);
        if (string != null && !string.isEmpty()) {
            return string.toUpperCase();
        }
        try {
            return InputUtil.Type.KEYSYM.createFromCode(n).getLocalizedText().getString();
        }
        catch (RuntimeException runtimeException) {
            return a.d("\uadab", 1570214490, 826490835) + n;
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

