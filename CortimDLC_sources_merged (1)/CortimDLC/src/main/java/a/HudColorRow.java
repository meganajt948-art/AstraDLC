/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Widget;
import a.iog;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Lang;
import flow.dev.StringDecryptor;
import java.awt.Color;
import java.util.Locale;
import net.minecraft.class_332;

final class HudColorRow
extends Widget {
    private static final float htk = 16.0f;
    private static final float htl = 56.0f;
    private static final float htm = 80.0f;
    private static final float htn = 9.0f;
    private static final float hto = 6.0f;
    private static final float htp = 4.3f;
    private static final int htq = Math.max(Theme.MENU_PAINTS.length, Theme.HUD_PAINTS.length);
    private final Spring[] htr = new Spring[htq];
    private final Spring[] hts = new Spring[htq];
    private final Spring htt = new Spring(16.0f);
    private String htu = "";
    private int htv = -1;
    private float htw;
    private float htx;
    private float hty;
    private float htz = 1.0f;
    private int hua;
    private float hub;
    private static /* synthetic */ long huc;
    private static /* synthetic */ boolean hud;

    HudColorRow() {
        super(null);
        for (int i = 0; i < htq; ++i) {
            this.htr[i] = new Spring(16.0f);
            this.hts[i] = new Spring(13.0f);
        }
    }

    private static iog[] hue() {
        return Theme.PAINT.is("HUD") ? Theme.HUD_PAINTS : Theme.MENU_PAINTS;
    }

    @Override
    float height() {
        float f = 4.0f;
        iog[] iogArray = HudColorRow.hue();
        for (int i = 0; i < iogArray.length; ++i) {
            f += 16.0f + 80.0f * this.hts[i].get();
        }
        return f;
    }

    private float huf(int n) {
        float f = this.y + 2.0f;
        for (int i = 0; i < n; ++i) {
            f += 16.0f + 80.0f * this.hts[i].get();
        }
        return f;
    }

    private float hug(iog iog2) {
        return this.w - 15.0f * (iog2.hasAlpha() ? 2.0f : 1.0f);
    }

    private void huh() {
        if (!Theme.PAINT.get().equals(this.htu)) {
            this.htu = Theme.PAINT.get();
            this.htv = -1;
            this.hua = 0;
            for (Spring vcj2 : this.hts) {
                vcj2.set(0.0f);
            }
        }
    }

    private void hui(iog iog2, boolean bl) {
        int n = Theme.paintColor(iog2);
        if (!bl && this.huj(iog2) == (iog2.hasAlpha() ? n : n | 0xFF000000)) {
            return;
        }
        if (!iog2.hud() && iog2.slot() == 0) {
            this.htw = (float)Theme.BG_HUE.get();
            this.htx = (float)Theme.BG_SATURATION.get();
            this.hty = (float)Theme.BG_BRIGHTNESS.get();
            this.htz = 1.0f;
            return;
        }
        float[] fArray = Color.RGBtoHSB(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, null);
        if (fArray[1] > 0.001f && fArray[2] > 0.001f) {
            this.htw = fArray[0];
        }
        this.htx = fArray[1];
        this.hty = fArray[2];
        this.htz = iog2.hasAlpha() ? (float)ColorUtil.alpha(n) / 255.0f : 1.0f;
    }

    private int huj(iog iog2) {
        return ColorUtil.withAlpha(ColorUtil.hsv(this.htw, this.htx, this.hty), iog2.hasAlpha() ? Math.round(this.htz * 255.0f) : 255);
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        this.huh();
        if (this.hua != 0 && !hlc2.isDragging(this)) {
            this.hua = 0;
        }
        iog[] iogArray = HudColorRow.hue();
        float f4 = this.y + 2.0f;
        for (int i = 0; i < iogArray.length; ++i) {
            iog iog2 = iogArray[i];
            float f5 = this.hts[i].step(i == this.htv, f3);
            boolean bl = hlc2.canHover() && UiKit.inside(f, f2, this.x - 3.0f, f4, this.w + 6.0f, 16.0f);
            float f6 = this.htr[i].step(bl, f3);
            this.huk(class_3322, iog2, f4, f6, f5);
            if (bl) {
                hlc2.hint(Lang.t(iog2.name()) + Lang.s("  ·  click: pick  ·  right click: Auto", "  ·  клик: выбрать  ·  ПКМ: авто"));
            }
            f4 += 16.0f;
            if (!(f5 > 0.01f)) continue;
            float f7 = 80.0f * f5;
            if (i == this.htv) {
                DrawUtil.pushScissor(class_3322, this.x - 3.0f, f4, this.w + 6.0f, f7);
                DrawUtil.pushAlpha(Math.min(1.0f, f5 * 1.4f));
                if (this.hua == 0) {
                    this.hui(iog2, false);
                }
                this.hub = f4 + 4.0f;
                this.hun(class_3322, hlc2, iog2, f4 + 4.0f, f, f2, f3);
                DrawUtil.popAlpha();
                DrawUtil.popScissor(class_3322);
            }
            f4 += f7;
        }
    }

    private void huk(class_332 class_3322, iog iog2, float f, float f2, float f3) {
        float f4 = f + 8.0f;
        float f5 = Theme.r(4.0f);
        float f6 = Math.max(f2, f3 * 0.6f);
        if (f6 > 0.01f) {
            DrawUtil.round(class_3322, this.x - 3.0f, f + 0.5f, this.w + 6.0f, 15.0f, f5, ColorUtil.withAlpha(Theme.hover, Math.round((float)ColorUtil.alpha(Theme.hover) * 2.0f * f6)));
        }
        int n = Theme.paintColor(iog2);
        HudColorRow.hul(class_3322, this.x + 4.3f + 1.0f, f4, 4.3f, n);
        UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(Lang.t(iog2.name()), this.w * 0.62f), this.x + 8.6f + 7.0f, UiKit.LABEL.centerTop(f4), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f2, f3)));
        boolean bl = Theme.isPainted(iog2);
        String string = bl ? HudColorRow.hum(n, iog2.hasAlpha()) : Lang.value("Auto");
        UiKit.SMALL.drawRight(class_3322, string, this.x + this.w, UiKit.SMALL.centerTop(f4), bl ? ColorUtil.lerp(Theme.textMuted, Theme.textDim, 0.6f + 0.4f * f2) : Theme.textMuted);
    }

    private static void hul(class_332 class_3322, float f, float f2, float f3, int n) {
        if (ColorUtil.alpha(n) < 250) {
            DrawUtil.round(class_3322, f - f3, f2 - f3, f3, f3 * 2.0f, f3, 0.0f, 0.0f, f3, -4934468);
            DrawUtil.round(class_3322, f, f2 - f3, f3, f3 * 2.0f, 0.0f, f3, f3, 0.0f, -13750732);
        }
        DrawUtil.circle(class_3322, f, f2, f3, n);
        DrawUtil.circleOutline(class_3322, f, f2, f3, 0.8f, ColorUtil.withAlpha(Theme.textMuted, 110));
    }

    private static String hum(int n, boolean bl) {
        String string = String.format(Locale.ROOT, "#%06X", n & 0xFFFFFF);
        int n2 = ColorUtil.alpha(n);
        return bl && n2 < 255 ? string + "  " + Math.round((float)n2 / 2.55f) + "%" : string;
    }

    private void hun(class_332 class_3322, ClickGuiScreen hlc2, iog iog2, float f, float f2, float f3, float f4) {
        int n;
        float f5 = this.htw;
        float f6 = this.htx;
        float f7 = this.hty;
        float f8 = this.htz;
        float f9 = this.hug(iog2);
        float f10 = Theme.r(4.0f);
        int n2 = ColorUtil.hsv(f5, 1.0f, 1.0f);
        DrawUtil.gradient(class_3322, this.x, f, f9, 56.0f, f10, -1, n2, -16777216, -16777216);
        DrawUtil.outline(class_3322, this.x, f, f9, 56.0f, f10, 1.0f, Theme.stroke);
        float f11 = this.x + f6 * f9;
        float f12 = f + (1.0f - f7) * 56.0f;
        int n3 = ColorUtil.hsv(f5, f6, f7);
        DrawUtil.shadow(class_3322, f11 - 3.5f, f12 - 3.5f, 7.0f, 7.0f, 3.5f, 2.0f, 0x60000000);
        DrawUtil.circle(class_3322, f11, f12, 3.5f, -1);
        DrawUtil.circle(class_3322, f11, f12, 2.3f, n3);
        float f13 = this.x + f9 + 6.0f;
        float f14 = 9.333333f;
        float f15 = 4.5f;
        DrawUtil.gradientV(class_3322, f13, f, 9.0f, f14 + f15, f15, ColorUtil.hsv(0.0f, 1.0f, 1.0f), ColorUtil.hsv((f14 + f15) / 56.0f, 1.0f, 1.0f));
        DrawUtil.gradientV(class_3322, f13, f + 56.0f - f14 - f15, 9.0f, f14 + f15, f15, ColorUtil.hsv((56.0f - f14 - f15) / 56.0f, 1.0f, 1.0f), ColorUtil.hsv(1.0f, 1.0f, 1.0f));
        for (int i = 1; i < 5; ++i) {
            DrawUtil.gradientV(class_3322, f13, f + f14 * (float)i, 9.0f, f14, 0.0f, ColorUtil.hsv((float)i / 6.0f, 1.0f, 1.0f), ColorUtil.hsv((float)(i + 1) / 6.0f, 1.0f, 1.0f));
        }
        HudColorRow.huo(class_3322, f13, f + f5 * 56.0f);
        if (iog2.hasAlpha()) {
            float f16 = f13 + 9.0f + 6.0f;
            DrawUtil.pushScissor(class_3322, f16, f, 9.0f, 56.0f);
            float f17 = 4.5f;
            n = 0;
            while ((float)n * f17 < 56.0f) {
                for (int i = 0; i < 2; ++i) {
                    DrawUtil.rect(class_3322, f16 + (float)i * f17, f + (float)n * f17, f17, Math.min(f17, 56.0f - (float)n * f17), (n + i) % 2 == 0 ? -1644822 : -6645086);
                }
                ++n;
            }
            DrawUtil.popScissor(class_3322);
            DrawUtil.gradientV(class_3322, f16, f, 9.0f, 56.0f, 0.0f, n3, ColorUtil.withAlpha(n3, 0));
            DrawUtil.outline(class_3322, f16, f, 9.0f, 56.0f, Math.min(f15, Theme.r(3.0f)), 1.0f, Theme.stroke);
            HudColorRow.huo(class_3322, f16, f + (1.0f - f8) * 56.0f);
        }
        float f18 = f + 56.0f + 10.0f;
        int n4 = ColorUtil.withAlpha(n3, iog2.hasAlpha() ? Math.round(f8 * 255.0f) : 255);
        HudColorRow.hul(class_3322, this.x + 4.0f, f18, 3.5f, n4);
        UiKit.VALUE.draw(class_3322, HudColorRow.hum(n4, iog2.hasAlpha()), this.x + 11.0f, UiKit.VALUE.centerTop(f18), Theme.textDim);
        int n5 = n = !iog2.hud() && iog2.slot() == 0 ? 1 : 0;
        if (n != 0 || Theme.isPainted(iog2)) {
            String string = n != 0 ? Lang.s("Default", "По умолчанию") : Lang.value("Auto");
            float f19 = Math.max(16.0f, UiKit.SMALL.width(string) + 9.0f);
            float f20 = this.htt.step(hlc2.canHover() && UiKit.inside(f2, f3, this.x + this.w - f19, f18 - 5.5f, f19, 11.0f), f4);
            UiKit.drawChip(class_3322, string, this.x + this.w, f18, ColorUtil.lerp(Theme.textDim, Theme.text, f20), ColorUtil.lerp(Theme.stroke, Theme.accent(150), f20), f20);
        }
    }

    private static void huo(class_332 class_3322, float f, float f2) {
        DrawUtil.shadow(class_3322, f - 1.5f, f2 - 2.0f, 12.0f, 4.0f, 2.0f, 2.0f, 0x60000000);
        DrawUtil.outline(class_3322, f - 1.5f, f2 - 2.0f, 12.0f, 4.0f, 2.0f, 1.3f, -1);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        iog[] iogArray = HudColorRow.hue();
        for (int i = 0; i < iogArray.length; ++i) {
            iog iog2 = iogArray[i];
            float f3 = this.huf(i);
            if (UiKit.inside(f, f2, this.x - 3.0f, f3, this.w + 6.0f, 16.0f)) {
                if (n == 1) {
                    Theme.clearPaint(iog2);
                    if (i == this.htv) {
                        this.hui(iog2, true);
                    }
                    return true;
                }
                if (n != 0) {
                    return false;
                }
                int n2 = this.htv = this.htv == i ? -1 : i;
                if (this.htv == i) {
                    this.hui(iog2, true);
                }
                return true;
            }
            if (i != this.htv || !(this.hts[i].get() > 0.9f) || n != 0 || !this.hup(hlc2, iog2, f3 + 16.0f + 4.0f, f, f2)) continue;
            return true;
        }
        return false;
    }

    private boolean hup(ClickGuiScreen hlc2, iog iog2, float f, float f2, float f3) {
        float f4 = this.hug(iog2);
        float f5 = this.x + f4 + 6.0f;
        this.hub = f;
        if (UiKit.inside(f2, f3, this.x - 2.0f, f - 2.0f, f4 + 4.0f, 60.0f)) {
            this.hua = 1;
        } else if (UiKit.inside(f2, f3, f5 - 3.0f, f - 3.0f, 15.0f, 62.0f)) {
            this.hua = 2;
        } else if (iog2.hasAlpha() && UiKit.inside(f2, f3, f5 + 9.0f + 6.0f - 3.0f, f - 3.0f, 15.0f, 62.0f)) {
            this.hua = 3;
        } else {
            float f6 = f + 56.0f + 10.0f;
            boolean bl = !iog2.hud() && iog2.slot() == 0;
            String string = bl ? Lang.s("Default", "По умолчанию") : Lang.value("Auto");
            float f7 = Math.max(16.0f, UiKit.SMALL.width(string) + 9.0f);
            if ((bl || Theme.isPainted(iog2)) && UiKit.inside(f2, f3, this.x + this.w - f7, f6 - 5.5f, f7, 11.0f)) {
                Theme.clearPaint(iog2);
                this.hui(iog2, true);
                return true;
            }
            return false;
        }
        hlc2.startDrag(this);
        this.mouseDragged(f2, f3);
        return true;
    }

    @Override
    void mouseDragged(float f, float f2) {
        iog[] iogArray = HudColorRow.hue();
        if (this.htv < 0 || this.htv >= iogArray.length || this.hua == 0) {
            return;
        }
        iog iog2 = iogArray[this.htv];
        float f3 = HudColorRow.huq((f2 - this.hub) / 56.0f);
        switch (this.hua) {
            case 1: {
                this.htx = HudColorRow.huq((f - this.x) / this.hug(iog2));
                this.hty = 1.0f - f3;
                break;
            }
            case 2: {
                this.htw = Math.min(0.999f, f3);
                break;
            }
            default: {
                this.htz = 1.0f - f3;
            }
        }
        if (this.hua != 3 && iog2.hasAlpha() && !Theme.isPainted(iog2) && this.htz < 0.35f) {
            this.htz = 1.0f;
        }
        Theme.setPaint(iog2, this.huj(iog2), this.htw, this.htx, this.hty);
    }

    private static float huq(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private static /* synthetic */ int aci(int n, int n2) {
        return n * n2 ^ 0x2EB7BC00;
    }

    private static /* synthetic */ int acj(int n, int n2) {
        return n + n2 ^ 0xF8706BF1;
    }

    private static /* synthetic */ int ack(int n, int n2) {
        return n * n2 + 1347130580;
    }
}

