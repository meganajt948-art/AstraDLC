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
import a.Spring;
import a.BoolSetting;
import a.Lang;
import net.minecraft.class_332;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class ToggleRow
extends Widget {
    private static final float inp = 20.0f;
    private final BoolSetting inq;
    private final Spring inr;
    private static /* synthetic */ String ins;
    private static /* synthetic */ boolean int;

    ToggleRow(BoolSetting vkl2) {
        super(vkl2);
        this.inq = vkl2;
        this.inr = new Spring(14.0f, vkl2.get() ? 1.0f : 0.0f);
    }

    @Override
    float height() {
        return 20.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.inr.step(this.inq.get(), f3);
        float f6 = this.y + 10.0f;
        UiKit.LABEL.draw(class_3322, Lang.t(this.setting.getName()), this.x, UiKit.LABEL.centerTop(f6), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f5 * 0.75f, f4)));
        UiKit.drawSwitch(class_3322, this.x + this.w - 17.0f, f6 - 4.75f, f5, f4);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n == 0 && this.hovered(f, f2)) {
            this.inq.toggle();
            return true;
        }
        return false;
    }

    private static /* synthetic */ int aia(int n, int n2) {
        return n ^ n2 ^ 0xD13BAB2E;
    }

    private static /* synthetic */ int aib(int n, int n2) {
        return ToggleRow.aia(n, n2) * n2;
    }

    private static /* synthetic */ int aic(int n, int n2) {
        return n ^ n2 ^ 0xE4CD7A62;
    }
}

