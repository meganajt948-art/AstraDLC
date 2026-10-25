/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.Drawable
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.widget.ButtonWidget$Text
 *  net.minecraft.client.gui.widget.ClickableWidget
 *  net.minecraft.client.gui.widget.CyclingButtonWidget
 *  net.minecraft.client.gui.widget.EntryListWidget
 *  net.minecraft.client.gui.widget.SliderWidget
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 *  org.joml.Matrix3x2fStack
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.dry;
import a.jte;
import a.kap;
import a.kbs;
import a.kce;
import a.kdv;
import a.keb;
import a.keg;
import a.unf;
import a.uut;
import a.vcq;
import a.vdn;
import a.veo;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;

public final class kej {
    public static final boolean ENABLED = !a.c(55813747, "\ua610\udfa6\u5578\ucb16\u40d7").equalsIgnoreCase(System.getProperty(a.b("\u7b2d\u0296\u8846\u162f\u9dbd\u1b10\ua10f\u28e9\ub6b7\u3c06\ubbce\u41be\ucf74", -716801210)));
    private static final Map<ClickableWidget, keg> kek = new WeakHashMap<ClickableWidget, keg>();
    private static Field kel;
    private static Field kem;
    private static boolean ken;
    private static boolean keo;
    private static /* synthetic */ int kep;
    private static /* synthetic */ long keq;

    private kej() {
    }

    public static void attach(Screen screen2) {
        if (!ENABLED || keo || screen2 instanceof jte || dry.armed()) {
            return;
        }
        try {
            kej.ker(screen2);
            ScreenEvents.beforeRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> kej.ker(screen));
        }
        catch (Throwable throwable) {
            keo = true;
            System.out.println(a.b("\u59a6\u2000\uaad2\u34a3\ubf6f\u39df\u83c2\u0a60\u9427\u1e94\u9940\u637f\uede7\u745f\ufe0c\u78a1\uc2f4", -968861227) + throwable);
        }
    }

    private static void ker(Screen screen) {
        List list;
        if (keo || dry.armed()) {
            return;
        }
        if (!ken) {
            ken = true;
            kel = vxr.find(Screen.class, a.b("\ud09b\ua921\u23e3\ubdc8\u365c\ub0e9\u0abd\u8347\u1d1e\u97be\u107e\uea08\u64cd\ufd26\u7738\uf1c6\u4b84\uc447\u5ef4\ud889\u5115\u2b43\ua5f4", 324980962), a.c(-1693225583, "\u6dfc\u1442\u9e9d\u00e5\u8b3a\u0db0\ub78f\u3e7e\ua02a\u2a92\uad46"), a.c(-1427972898, "\udc82\ua515\u2fcd\ub1ab\u3a6b\ubc94\u069d\u8f6d\u112f\u9b9b\u1c0b\ue619\u68eb\uf140\u7b14\ufdaa"));
            kem = vxr.find(SliderWidget.class, a.b("\u9826\ue19c\u6b5e\uf575\u7ee1\uf854\u4200\ucbfa\u55a3\udf03\u58c3\ua2b5\u2c70\ub59b\u3f85\ub97b\u0339\u8cfa\u1649\u9034\u19af\u63f8\ued49", 1020500063), a.b("\u96c6\uef78\u65a7\ufbdf\u7000\uf68a\u4cb4\uc545\u5b1f\ud1ac\u5679", -1888053589), a.d("\u7897", -1806554427, 1878348311));
        }
        if (kel == null) {
            keo = true;
            return;
        }
        try {
            list = (List)kel.get(screen);
        }
        catch (IllegalAccessException illegalAccessException) {
            keo = true;
            return;
        }
        int n = 0;
        for (int i = 0; i < list.size(); ++i) {
            ClickableWidget clickableWidget;
            Drawable drawable = (Drawable)list.get(i);
            if (drawable instanceof kdv || drawable instanceof keb) {
                ++n;
                continue;
            }
            if (drawable instanceof ClickableWidget && kej.kes(clickableWidget = (ClickableWidget)drawable)) {
                list.set(i, new kdv(screen, clickableWidget, (float)Math.min(n++, 14) * 0.018f));
                continue;
            }
            if (!(drawable instanceof EntryListWidget)) continue;
            EntryListWidget entryListWidget = (EntryListWidget)drawable;
            list.set(i, new keb(screen, entryListWidget));
        }
    }

    private static boolean kes(ClickableWidget clickableWidget) {
        Class<?> clazz = clickableWidget.getClass();
        return clazz == ButtonWidget.Text.class || clazz == CyclingButtonWidget.class || clickableWidget instanceof SliderWidget;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ket(DrawContext drawContext, ClickableWidget clickableWidget, int n, int n2, float f, float f2) {
        if (!clickableWidget.visible) {
            return;
        }
        float f3 = clickableWidget.getAlpha();
        clickableWidget.setAlpha(0.0f);
        try {
            clickableWidget.render(drawContext, n, n2, f);
        }
        finally {
            clickableWidget.setAlpha(f3);
        }
        kej.keu(drawContext, clickableWidget, n, n2, f3, f2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void keu(DrawContext drawContext, ClickableWidget clickableWidget2, int n, int n2, float f, float f2) {
        boolean bl;
        if (f <= 0.003f) {
            return;
        }
        unf.observe(drawContext);
        keg keg2 = kek.computeIfAbsent(clickableWidget2, clickableWidget -> new keg(f2));
        float f3 = kap.clock();
        float f4 = unf.delta();
        float f5 = vcq.outCubic(vcq.clamp01((f3 - keg2.born - keg2.delay) / 0.26f));
        if (f5 <= 0.0f) {
            return;
        }
        boolean bl2 = clickableWidget2.active;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        boolean bl3 = clickableWidget2.isFocused() && minecraftClient.getNavigationType().isKeyboard();
        float f6 = keg2.hover.step(bl2 && (clickableWidget2.isHovered() || bl3), f4);
        boolean bl4 = bl = GLFW.glfwGetMouseButton((long)minecraftClient.getWindow().getHandle(), (int)0) == 1;
        if (bl && !keg2.down && bl2 && clickableWidget2.isHovered()) {
            keg2.pressAt = f3;
            keg2.px = n - clickableWidget2.getX();
        }
        keg2.down = bl;
        float f7 = vcq.clamp01((f3 - keg2.pressAt) / 0.5f);
        float f8 = f7 < 1.0f ? (float)Math.sin(Math.PI * (double)vcq.clamp01(f7 * 2.6f)) : 0.0f;
        float f9 = clickableWidget2.getWidth();
        float f10 = clickableWidget2.getHeight();
        float f11 = Math.min(f10 * 0.5f, 5.0f);
        int n3 = kbs.selected().accent;
        float f12 = 1.0f - 0.035f * f8;
        Matrix3x2fStack matrix3x2fStack = drawContext.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate((float)clickableWidget2.getX() + f9 * 0.5f, (float)clickableWidget2.getY() + f10 * 0.5f + (1.0f - f5) * 4.0f);
        matrix3x2fStack.scale(f12, f12);
        matrix3x2fStack.translate(-f9 * 0.5f, -f10 * 0.5f);
        float f13 = f * f5;
        uut.pushAlpha(f13);
        try {
            uut.shadow(drawContext, 0.0f, 1.5f, f9, f10, f11, 7.0f, kej.kez(0, 0.2f + 0.1f * f6));
            uut.round(drawContext, 0.0f, 0.0f, f9, f10, f11, kej.kez(658965, bl2 ? 0.5f + 0.12f * f6 : 0.3f));
            if (f6 > 0.01f) {
                uut.round(drawContext, 0.0f, 0.0f, f9, f10, f11, kej.kez(n3, 0.11f * f6));
            }
            uut.gradient(drawContext, 0.0f, 0.0f, f9, f10 * 0.5f, f11, f11, 0.0f, 0.0f, kej.kez(0xFFFFFF, 0.06f), kej.kez(0xFFFFFF, 0.06f), kej.kez(0xFFFFFF, 0.0f), kej.kez(0xFFFFFF, 0.0f));
            if (clickableWidget2 instanceof SliderWidget) {
                kej.kev(drawContext, clickableWidget2, f9, f10, f11, f6, n3, bl2);
            }
            int n4 = kce.mix(0xFFFFFF, n3, f6);
            uut.outlineGradientV(drawContext, 0.0f, 0.0f, f9, f10, f11, 0.6f, kej.kez(n4, (bl2 ? 0.17f : 0.08f) + 0.45f * f6), kej.kez(n4, (bl2 ? 0.05f : 0.03f) + 0.25f * f6));
            if (f7 < 1.0f) {
                float f14 = f9 * vcq.outCubic(f7);
                float f15 = Math.max(0.0f, keg2.px - f14);
                float f16 = Math.min(f9, keg2.px + f14);
                uut.round(drawContext, f15, 0.0f, f16 - f15, f10, f11, kej.kez(kce.mix(0xFFFFFF, n3, 0.4f), 0.24f * (1.0f - f7)));
                float f17 = 5.0f * vcq.outCubic(f7);
                uut.outline(drawContext, -f17, -f17, f9 + 2.0f * f17, f10 + 2.0f * f17, f11 + f17, 0.8f, kej.kez(n3, 0.6f * (1.0f - f7)));
            }
            kej.kew(drawContext, clickableWidget2, f9, f10, f6, bl2, f13);
        }
        finally {
            uut.popAlpha();
            matrix3x2fStack.popMatrix();
        }
    }

    private static void kev(DrawContext drawContext, ClickableWidget clickableWidget, float f, float f2, float f3, float f4, int n, boolean bl) {
        double d = 0.0;
        try {
            d = kem != null ? kem.getDouble(clickableWidget) : 0.0;
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        float f5 = (float)Math.max(0.0, Math.min(1.0, d));
        float f6 = Math.max(f3, 5.0f);
        float f7 = f - f6 * 2.0f;
        float f8 = f6 + f7 * f5;
        uut.round(drawContext, 0.0f, 0.0f, Math.max(f3 * 2.0f, f8), f2, f3, kej.kez(n, (bl ? 0.12f : 0.06f) + 0.08f * f4));
        float f9 = f2 - 3.6f;
        uut.round(drawContext, f6, f9 - 0.5f, f7, 1.0f, 0.5f, kej.kez(0xFFFFFF, 0.14f));
        uut.round(drawContext, f6, f9 - 0.5f, f8 - f6, 1.0f, 0.5f, kej.kez(n, bl ? 0.9f : 0.4f));
        uut.circle(drawContext, f8, f9, 1.7f + 0.5f * f4, kej.kez(kce.mix(0xFFFFFF, n, 0.2f), bl ? 1.0f : 0.5f));
    }

    private static void kew(DrawContext drawContext, ClickableWidget clickableWidget, float f, float f2, float f3, boolean bl, float f4) {
        Text text = clickableWidget.getMessage();
        String string = text.getString();
        int n = bl ? kce.mix(15133683, 0xFFFFFF, f3) : 8028814;
        vdn vdn2 = veo.semibold(6.9f);
        if ((!bl || kej.kex(text)) && kej.key(vdn2, string)) {
            String string2 = vdn2.ellipsize(string, f - 8.0f);
            vdn2.drawCentered(drawContext, string2, f * 0.5f, vdn2.centerTop(f2 * 0.5f), kej.kez(n, 1.0f));
            return;
        }
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        int n2 = Math.round(255.0f * Math.max(0.0f, Math.min(1.0f, f4)));
        if (n2 < 5) {
            return;
        }
        int n3 = textRenderer.getWidth((StringVisitable)text);
        if ((float)n3 <= f - 6.0f) {
            drawContext.drawText(textRenderer, text, Math.round((f - (float)n3) * 0.5f), Math.round(f2 * 0.5f - 4.0f), n2 << 24 | 0xFFFFFF, false);
        } else {
            String string3 = textRenderer.trimToWidth(string, Math.max(0, Math.round(f - 6.0f) - textRenderer.getWidth(a.b("\u6cf3\u1542\u9f91", -825398050)))) + a.b("\u3b31\u4280\uc853", -478790884);
            drawContext.drawText(textRenderer, string3, Math.round((f - (float)textRenderer.getWidth(string3)) * 0.5f), Math.round(f2 * 0.5f - 4.0f), n2 << 24 | n & 0xFFFFFF, false);
        }
    }

    private static boolean kex(Text text) {
        Optional optional = text.visit((style, string) -> style.getColor() != null ? Optional.of(Boolean.TRUE) : Optional.empty(), Style.EMPTY);
        return optional.isEmpty();
    }

    private static boolean key(vdn vdn2, String string) {
        int n;
        for (int i = 0; i < string.length(); i += Character.charCount(n)) {
            n = string.codePointAt(i);
            if (Character.isWhitespace(n) || vdn2.canDisplay(n)) continue;
            return false;
        }
        return true;
    }

    private static int kez(int n, float f) {
        return kce.rgba(n, f);
    }

    private static /* synthetic */ int asr(int n, int n2) {
        return n * n2 | 0x9EB9831D;
    }

    private static /* synthetic */ int ass(int n, int n2) {
        return kej.asr(n, n2) + n;
    }
}

