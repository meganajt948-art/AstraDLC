/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.ItemPickerPopup;
import a.Widget;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.Spring;
import a.Icon;
import a.ListSetting;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1799;
import net.minecraft.class_332;

final class ChooseButton
extends Widget {
    private static final float ief = 26.0f;
    private static final float ieg = 66.0f;
    private static final float ieh = 17.0f;
    private static final int iei = 5;
    private final ListSetting iej;
    private final Spring iek = new Spring(16.0f);
    private final Spring iel = new Spring(10.0f);
    private int iem = -1;
    private final List<class_1799> ien = new ArrayList<class_1799>();
    private static /* synthetic */ String ieo;
    private static /* synthetic */ int iep;

    ChooseButton(ListSetting vlj2) {
        super(vlj2);
        this.iej = vlj2;
    }

    @Override
    float height() {
        return 26.0f;
    }

    private void ieq() {
        if (this.iem == this.iej.version()) {
            return;
        }
        this.iem = this.iej.version();
        this.ien.clear();
        for (String string : this.iej.ids()) {
            class_1799 class_17992 = ItemPickerPopup.iconOf(this.iej.kind(), string);
            if (class_17992.method_7960()) continue;
            this.ien.add(class_17992);
            if (this.ien.size() < 5) continue;
            break;
        }
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4;
        this.ieq();
        float f5 = this.y + 13.0f;
        float f6 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        UiKit.LABEL.draw(class_3322, Lang.t(this.setting.getName()), this.x, UiKit.LABEL.centerTop(f5), ColorUtil.lerp(Theme.textDim, Theme.text, f6));
        float f7 = this.x + this.w - 66.0f;
        float f8 = f5 - 8.5f;
        float f9 = this.iek.step(hlc2.canHover() && UiKit.inside(f, f2, f7, f8, 66.0f, 17.0f), f3);
        UiKit.secondaryButton(class_3322, Lang.s("Choose", "Выбрать"), Icon.SEARCH, f7, f8, 66.0f, 17.0f, f9, this.iel.step(0.0f, f3));
        float f10 = f7 - 6.0f;
        int n = this.iej.size();
        if (n > this.ien.size()) {
            var13_13 = "+" + (n - this.ien.size());
            f10 = UiKit.drawChip(class_3322, var13_13, f10, f5, Theme.textDim, Theme.stroke, f6) - 4.0f;
        } else if (n == 0) {
            var13_13 = Lang.s("none", "пусто");
            UiKit.SMALL.draw(class_3322, var13_13, f10 - UiKit.SMALL.width(var13_13), UiKit.SMALL.centerTop(f5), Theme.textMuted);
        }
        float f11 = this.x + UiKit.LABEL.width(Lang.t(this.setting.getName())) + 6.0f;
        for (int i = this.ien.size() - 1; i >= 0 && !((f4 = f10 - 14.0f) < f11); --i) {
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(f4, f5 - 6.5f);
            class_3322.method_51448().scale(0.8125f, 0.8125f);
            class_3322.method_51427(this.ien.get(i), 0, 0);
            class_3322.method_51448().popMatrix();
            f10 = f4 - 1.5f;
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n == 0 && this.hovered(f, f2)) {
            this.iel.set(1.0f);
            hlc2.openPicker(this.iej);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int afq(int n, int n2) {
        return n * n2 ^ 0xC05D9C0A;
    }

    private static /* synthetic */ int afr(int n, int n2) {
        return ChooseButton.afq(n, n2) * n2;
    }

    private static /* synthetic */ int afs(int n, int n2) {
        return ChooseButton.afq(n, n2) * n2;
    }
}

