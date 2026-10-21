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
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.NumberSetting;
import a.Lang;
import net.minecraft.class_332;

final class SliderRow
extends Widget {
    private static final float imv = 25.0f;
    private static final float imw = 17.5f;
    private static final float imx = 2.5f;
    private final NumberSetting imy;
    private final Spring imz;
    private final Spring ina = new Spring(16.0f);
    private boolean inb;
    private static /* synthetic */ long inc;
    private static /* synthetic */ long ind;

    SliderRow(NumberSetting vmc2) {
        super(vmc2);
        this.imy = vmc2;
        this.imz = new Spring(18.0f, (float)vmc2.getFraction());
    }

    @Override
    float height() {
        return 25.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        if (this.inb && !hlc2.isDragging(this)) {
            this.inb = false;
        }
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.ina.step(this.inb, f3);
        float f6 = this.imz.step((float)this.imy.getFraction(), f3);
        float f7 = this.y + 7.5f;
        UiKit.LABEL.draw(class_3322, Lang.t(this.setting.getName()), this.x, UiKit.LABEL.centerTop(f7), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f4, f5)));
        UiKit.VALUE.drawRight(class_3322, this.imy.display(), this.x + this.w, UiKit.VALUE.centerTop(f7), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f5, f4 * 0.6f)));
        float f8 = this.y + 17.5f;
        float f9 = 2.5f + f4 * 0.4f + f5 * 0.4f;
        float f10 = f8 + 1.25f;
        DrawUtil.round(class_3322, this.x, f10 - f9 * 0.5f, this.w, f9, f9 * 0.5f, Theme.track);
        float f11 = Math.max(f9, this.w * f6);
        DrawUtil.gradientH(class_3322, this.x, f10 - f9 * 0.5f, f11, f9, f9 * 0.5f, Theme.accent(), Theme.accent2());
        GlassDraw.inset(class_3322, this.x, f10 - f9 * 0.5f, this.w, f9, f9 * 0.5f, Theme.lightness());
        float f12 = this.x + this.w * f6;
        float f13 = 3.2f + f4 * 0.4f + f5 * 0.6f;
        DrawUtil.shadow(class_3322, f12 - f13, f10 - f13 + 0.8f + f5 * 0.6f, f13 * 2.0f, f13 * 2.0f, f13, 1.6f + f5 * 1.6f, ColorUtil.withAlpha(0, Math.round(110.0f + 40.0f * f5)));
        DrawUtil.gradientV(class_3322, f12 - f13, f10 - f13, f13 * 2.0f, f13 * 2.0f, f13, -1, -2302750);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (n == 1) {
            this.imy.reset();
            return true;
        }
        if (n == 0) {
            this.inb = true;
            hlc2.startDrag(this);
            this.mouseDragged(f, f2);
            return true;
        }
        return false;
    }

    @Override
    void mouseDragged(float f, float f2) {
        this.imy.setFromFraction((f - this.x) / this.w);
    }

    private static /* synthetic */ int ahq(int n, int n2) {
        return n + n2 | 0x5D52A44D;
    }

    private static /* synthetic */ int ahr(int n, int n2) {
        return n * n2 + -1697928962;
    }

    private static /* synthetic */ int ahs(int n, int n2) {
        return n * n2 + -330352484;
    }
}

