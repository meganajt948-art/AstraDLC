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
import a.Icon;
import a.IconRenderer;
import a.ModeSetting;
import a.Lang;
import java.util.List;
import net.minecraft.class_332;

final class ModeRow
extends Widget {
    private static final float ies = 21.0f;
    private static final float iet = 14.0f;
    private static final float ieu = 11.0f;
    private final ModeSetting iev;
    private final Spring iew = new Spring(16.0f);
    private final Spring iex = new Spring(18.0f, -1.0f);
    private final Spring iey = new Spring(18.0f, -1.0f);
    private boolean iez;
    private float ifa;
    private float ifb;
    private float ifc;
    private static /* synthetic */ long ifd;
    private static /* synthetic */ boolean ife;

    ModeRow(ModeSetting vlv2) {
        super(vlv2);
        this.iev = vlv2;
    }

    @Override
    float height() {
        return 21.0f;
    }

    private float iff(String string) {
        return UiKit.VALUE.width(Lang.value(string)) + 11.0f;
    }

    private void ifg() {
        List<String> list = this.iev.getModes();
        float f = 3.0f;
        for (String string : list) {
            f += this.iff(string);
        }
        float f2 = this.w - UiKit.LABEL.width(Lang.t(this.setting.getName())) - 10.0f;
        boolean bl = this.iez = list.size() <= 3 && f <= f2;
        if (this.iez) {
            this.ifc = f;
        } else {
            float f3 = 0.0f;
            for (String string : list) {
                f3 = Math.max(f3, UiKit.VALUE.width(Lang.value(string)));
            }
            this.ifc = Math.min(this.w * 0.6f, Math.max(60.0f, f3 + 24.0f));
        }
        this.ifa = this.x + this.w - this.ifc;
        this.ifb = this.y + 3.5f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        this.ifg();
        boolean bl = UiKit.inside(f, f2, this.ifa, this.ifb, this.ifc, 14.0f) && hlc2.canHover();
        float f4 = this.hover.step(bl, f3);
        float f5 = this.iew.step(hlc2.isDropdownFor(this.iev), f3);
        UiKit.LABEL.draw(class_3322, Lang.t(this.setting.getName()), this.x, UiKit.LABEL.centerTop(this.y + 10.5f), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f4, f5)));
        float f6 = Theme.r(4.0f);
        DrawUtil.round(class_3322, this.ifa, this.ifb, this.ifc, 14.0f, f6, ColorUtil.lerp(Theme.field, Theme.fieldHover, f4));
        DrawUtil.outline(class_3322, this.ifa, this.ifb, this.ifc, 14.0f, f6, 1.0f, ColorUtil.lerp(Theme.stroke, Theme.accent(150), f5));
        GlassDraw.inset(class_3322, this.ifa, this.ifb, this.ifc, 14.0f, f6, Theme.lightness());
        if (this.iez) {
            this.ifh(class_3322, f, f2, f3);
        } else {
            this.ifi(class_3322, f4, f5);
        }
    }

    private void ifh(class_332 class_3322, float f, float f2, float f3) {
        float f4;
        float f5;
        List<String> list = this.iev.getModes();
        float f6 = f5 = this.ifa + 1.5f;
        float f7 = this.iff(list.get(0));
        for (String string : list) {
            f4 = this.iff(string);
            if (string.equals(this.iev.get())) {
                f6 = f5;
                f7 = f4;
            }
            f5 += f4;
        }
        if (this.iex.get() < 0.0f) {
            this.iex.set(f6 - this.ifa);
            this.iey.set(f7);
        }
        float f8 = this.ifa + this.iex.step(f6 - this.ifa, f3);
        float f9 = this.iey.step(f7, f3);
        f4 = Theme.r(3.2f);
        float f10 = Theme.lightness();
        float f11 = this.ifb + 1.5f;
        float f12 = 11.0f;
        DrawUtil.shadow(class_3322, f8, f11 + 0.6f, f9, f12, f4, 1.4f, ColorUtil.withAlpha(0, Math.round(110.0f - 70.0f * f10)));
        DrawUtil.round(class_3322, f8, f11, f9, f12, f4, ColorUtil.lerp(Theme.cardHover, -1, 0.1f + 0.9f * f10));
        GlassDraw.sheen(class_3322, f8, f11, f9, f12, f4, 1.4f * (1.0f - 0.7f * f10));
        GlassDraw.rim(class_3322, f8, f11, f9, f12, f4, f10, 1.1f);
        f5 = this.ifa + 1.5f;
        float f13 = this.ifb + 7.0f;
        for (String string : list) {
            float f14 = this.iff(string);
            float f15 = Math.max(0.0f, Math.min(f8 + f9, f5 + f14) - Math.max(f8, f5)) / f14;
            boolean bl = UiKit.inside(f, f2, f5, this.ifb, f14, 14.0f);
            int n = bl ? Theme.textDim : Theme.textMuted;
            UiKit.VALUE.drawCentered(class_3322, Lang.value(string), f5 + f14 * 0.5f, UiKit.VALUE.centerTop(f13), ColorUtil.lerp(n, Theme.text, f15));
            f5 += f14;
        }
    }

    private void ifi(class_332 class_3322, float f, float f2) {
        String string = UiKit.VALUE.ellipsize(Lang.value(this.iev.get()), this.ifc - 22.0f);
        float f3 = this.ifb + 7.0f;
        UiKit.VALUE.draw(class_3322, string, this.ifa + 7.0f, UiKit.VALUE.centerTop(f3), ColorUtil.lerp(Theme.textDim, Theme.text, 0.6f + f * 0.4f));
        float f4 = this.ifa + this.ifc - 8.5f;
        int n = ColorUtil.lerp(Theme.textMuted, Theme.accent(), Math.max(f2, f * 0.5f));
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f4, f3);
        class_3322.method_51448().rotate((float)Math.PI * f2);
        IconRenderer.draw(class_3322, Icon.CHEVRON_DOWN, 0.0f, 0.0f, 7.0f, n);
        class_3322.method_51448().popMatrix();
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (n == 1) {
            this.iev.cyclePrev();
            return true;
        }
        if (n != 0) {
            return false;
        }
        if (this.iez) {
            float f3 = this.ifa + 1.5f;
            for (String string : this.iev.getModes()) {
                float f4 = this.iff(string);
                if (f >= f3 && f < f3 + f4) {
                    this.iev.set(string);
                    return true;
                }
                f3 += f4;
            }
            this.iev.cycle();
        } else {
            hlc2.openDropdown(this.iev, this.ifa, this.ifb + 14.0f + 3.0f, this.ifc, this.ifb);
        }
        return true;
    }

    private static /* synthetic */ int afv(int n, int n2) {
        return n + n2 + 896384156;
    }

    private static /* synthetic */ int afw(int n, int n2) {
        return n + n2 | 0x25E75D15;
    }

    private static /* synthetic */ int afx(int n, int n2) {
        return n * n2 ^ 0x9357D9E2;
    }
}

