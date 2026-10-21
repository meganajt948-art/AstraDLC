/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.DrawUtil;
import a.NumberSetting;
import flow.dev.StringDecryptor;
import java.util.Locale;
import net.minecraft.class_332;

final class ColorRow
extends Widget {
    private static final float ima = 67.0f;
    private static final float imb = 50.0f;
    private static final float imc = 9.0f;
    private static final float imd = 7.0f;
    private final NumberSetting ime;
    private final NumberSetting imf;
    private final NumberSetting img;
    private int imh;
    private static /* synthetic */ int imi;
    private static /* synthetic */ long imj;

    ColorRow() {
        this(Theme.HUE, Theme.SATURATION, Theme.BRIGHTNESS);
    }

    ColorRow(NumberSetting vmc2, NumberSetting vmc3, NumberSetting vmc4) {
        super(null);
        this.ime = vmc2;
        this.imf = vmc3;
        this.img = vmc4;
    }

    @Override
    float height() {
        return 67.0f;
    }

    private float imk() {
        return this.y + 3.0f;
    }

    private float iml() {
        return this.w - 9.0f - 7.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        if (this.imh != 0 && !hlc2.isDragging(this)) {
            this.imh = 0;
        }
        float f4 = (float)this.ime.get();
        float f5 = (float)this.imf.get();
        float f6 = (float)this.img.get();
        float f7 = this.imk();
        float f8 = this.iml();
        float f9 = Theme.r(4.0f);
        int n = ColorUtil.hsv(f4, 1.0f, 1.0f);
        DrawUtil.gradient(class_3322, this.x, f7, f8, 50.0f, f9, -1, n, -16777216, -16777216);
        DrawUtil.outline(class_3322, this.x, f7, f8, 50.0f, f9, 1.0f, Theme.stroke);
        float f10 = this.x + f5 * f8;
        float f11 = f7 + (1.0f - f6) * 50.0f;
        DrawUtil.shadow(class_3322, f10 - 3.5f, f11 - 3.5f, 7.0f, 7.0f, 3.5f, 2.0f, 0x60000000);
        DrawUtil.circle(class_3322, f10, f11, 3.5f, -1);
        DrawUtil.circle(class_3322, f10, f11, 2.3f, ColorUtil.hsv(f4, f5, f6));
        float f12 = this.x + f8 + 7.0f;
        float f13 = 8.333333f;
        float f14 = 4.5f;
        DrawUtil.gradientV(class_3322, f12, f7, 9.0f, f13 + f14, f14, ColorUtil.hsv(0.0f, 1.0f, 1.0f), ColorUtil.hsv((f13 + f14) / 50.0f, 1.0f, 1.0f));
        DrawUtil.gradientV(class_3322, f12, f7 + 50.0f - f13 - f14, 9.0f, f13 + f14, f14, ColorUtil.hsv((50.0f - f13 - f14) / 50.0f, 1.0f, 1.0f), ColorUtil.hsv(1.0f, 1.0f, 1.0f));
        for (int i = 1; i < 5; ++i) {
            DrawUtil.gradientV(class_3322, f12, f7 + f13 * (float)i, 9.0f, f13, 0.0f, ColorUtil.hsv((float)i / 6.0f, 1.0f, 1.0f), ColorUtil.hsv((float)(i + 1) / 6.0f, 1.0f, 1.0f));
        }
        float f15 = f7 + f4 * 50.0f;
        DrawUtil.shadow(class_3322, f12 - 1.5f, f15 - 2.0f, 12.0f, 4.0f, 2.0f, 2.0f, 0x60000000);
        DrawUtil.outline(class_3322, f12 - 1.5f, f15 - 2.0f, 12.0f, 4.0f, 2.0f, 1.3f, -1);
        int n2 = ColorUtil.hsv(f4, f5, f6);
        String string = String.format(Locale.ROOT, "#%06X", n2 & 0xFFFFFF);
        float f16 = f7 + 50.0f + 9.0f;
        DrawUtil.circle(class_3322, this.x + 4.0f, f16, 3.5f, n2);
        UiKit.VALUE.draw(class_3322, string, this.x + 11.0f, UiKit.VALUE.centerTop(f16), Theme.textDim);
        UiKit.SMALL.drawRight(class_3322, Math.round(f4 * 360.0f) + "°  " + Math.round(f5 * 100.0f) + "%  " + Math.round(f6 * 100.0f) + "%", this.x + this.w, UiKit.SMALL.centerTop(f16), Theme.textMuted);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float f3 = this.imk();
        if (UiKit.inside(f, f2, this.x - 2.0f, f3 - 2.0f, this.iml() + 4.0f, 54.0f)) {
            this.imh = 1;
        } else if (UiKit.inside(f, f2, this.x + this.iml() + 7.0f - 3.0f, f3 - 3.0f, 15.0f, 56.0f)) {
            this.imh = 2;
        } else {
            return false;
        }
        hlc2.startDrag(this);
        this.mouseDragged(f, f2);
        return true;
    }

    @Override
    void mouseDragged(float f, float f2) {
        float f3 = this.imk();
        if (this.imh == 1) {
            this.imf.set(ColorRow.imm((f - this.x) / this.iml()));
            this.img.set(1.0f - ColorRow.imm((f2 - f3) / 50.0f));
        } else if (this.imh == 2) {
            this.ime.set(Math.min(0.999f, ColorRow.imm((f2 - f3) / 50.0f)));
        }
    }

    private static float imm(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private static /* synthetic */ int ahi(int n, int n2) {
        return n * n2 ^ 0xF861DF74;
    }
}

