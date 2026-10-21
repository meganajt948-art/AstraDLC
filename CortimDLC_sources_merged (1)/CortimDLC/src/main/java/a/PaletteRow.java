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
import a.Spring;
import a.ColorSetting;
import a.Lang;
import java.util.List;
import net.minecraft.class_332;

final class PaletteRow
extends Widget {
    private static final float inf = 30.0f;
    private static final float ing = 10.0f;
    private final ColorSetting inh;
    private final Spring[] ini;
    private final Spring[] inj;
    private static /* synthetic */ String ink;
    private static /* synthetic */ int inl;

    PaletteRow(ColorSetting vla2) {
        super(vla2);
        this.inh = vla2;
        int n = vla2.getModes().size();
        this.ini = new Spring[n];
        this.inj = new Spring[n];
        for (int i = 0; i < n; ++i) {
            this.ini[i] = new Spring(16.0f);
            this.inj[i] = new Spring(14.0f, i == vla2.index() ? 1.0f : 0.0f);
        }
    }

    @Override
    float height() {
        return 30.0f;
    }

    private float inm(int n, int n2) {
        float f = (this.w - 10.0f * (float)n2) / (float)(n2 - 1);
        return this.x + 5.0f + (float)n * (10.0f + f);
    }

    private float inn() {
        return this.y + 30.0f - 5.0f - 4.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<String> list = this.inh.getModes();
        int n = list.size();
        float f4 = this.inn();
        int n2 = -1;
        for (int i = 0; i < n; ++i) {
            boolean bl;
            float f5 = this.inm(i, n);
            boolean bl2 = bl = hlc2.canHover() && UiKit.inside(f, f2, f5 - 5.0f - 2.0f, f4 - 5.0f - 2.0f, 14.0f, 14.0f);
            if (bl) {
                n2 = i;
            }
            float f6 = this.ini[i].step(bl, f3);
            float f7 = this.inj[i].step(i == this.inh.index(), f3);
            float f8 = 5.0f + f6 * 0.7f - f7 * 1.1f;
            int[] nArray = ColorSetting.pair(i);
            if (f7 > 0.01f) {
                DrawUtil.circleOutline(class_3322, f5, f4, 6.7f, 1.1f, ColorUtil.mulAlpha(Theme.text, f7 * 0.9f));
            }
            if (i == 0) {
                DrawUtil.circle(class_3322, f5, f4, f8, ColorUtil.withAlpha(Theme.window, 255));
                DrawUtil.circleOutline(class_3322, f5, f4, f8, 0.8f, Theme.stroke);
                float f9 = f8 * 0.55f;
                DrawUtil.gradient(class_3322, f5 - f9, f4 - f9, f9 * 2.0f, f9 * 2.0f, f9, nArray[0], nArray[1], nArray[1], nArray[0]);
                continue;
            }
            DrawUtil.gradient(class_3322, f5 - f8, f4 - f8, f8 * 2.0f, f8 * 2.0f, f8, nArray[0], nArray[1], nArray[1], nArray[0]);
        }
        UiKit.LABEL.draw(class_3322, Lang.t(this.setting.getName()), this.x, UiKit.LABEL.centerTop(this.y + 7.0f), n2 >= 0 ? Theme.text : Theme.textDim);
        String string = Lang.value(n2 >= 0 ? list.get(n2) : this.inh.get());
        UiKit.SMALL.drawRight(class_3322, string, this.x + this.w, UiKit.SMALL.centerTop(this.y + 7.0f), n2 >= 0 ? Theme.textDim : Theme.textMuted);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (n == 1) {
            this.inh.cyclePrev();
            return true;
        }
        if (n != 0) {
            return false;
        }
        List<String> list = this.inh.getModes();
        int n2 = list.size();
        float f3 = this.inn();
        for (int i = 0; i < n2; ++i) {
            float f4 = this.inm(i, n2);
            if (!UiKit.inside(f, f2, f4 - 5.0f - 2.0f, f3 - 5.0f - 2.0f, 14.0f, 14.0f)) continue;
            this.inh.set(list.get(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int ahv(int n, int n2) {
        return n - n2 | 0x9C2D763D;
    }

    private static /* synthetic */ int ahw(int n, int n2) {
        return n - n2 ^ 0x2D68CE5E;
    }

    private static /* synthetic */ int ahx(int n, int n2) {
        return n * n2 ^ 0x2815357B;
    }
}

