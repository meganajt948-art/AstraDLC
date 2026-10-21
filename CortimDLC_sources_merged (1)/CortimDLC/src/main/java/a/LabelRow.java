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
import a.Lang;
import java.util.function.Supplier;
import net.minecraft.class_332;

final class LabelRow
extends Widget {
    private static final float iac = 18.0f;
    private final String iad;
    private final Supplier<String> iae;
    private static /* synthetic */ boolean iaf;
    private static /* synthetic */ int iag;

    LabelRow(String string, Supplier<String> supplier) {
        super(null);
        this.iad = string;
        this.iae = supplier;
    }

    @Override
    float height() {
        return 18.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4 = this.y + 9.0f;
        String string = Lang.t(this.iad);
        UiKit.LABEL.draw(class_3322, string, this.x, UiKit.LABEL.centerTop(f4), Theme.textDim);
        String string2 = UiKit.SMALL.ellipsize(this.iae.get(), this.w - UiKit.LABEL.width(string) - 20.0f);
        UiKit.drawChip(class_3322, string2, this.x + this.w, f4, Theme.text, Theme.stroke, 0.0f);
    }

    private static /* synthetic */ int aeq(int n, int n2) {
        return n ^ n2 | 0x29F7EFA6;
    }

    private static /* synthetic */ int aer(int n, int n2) {
        return LabelRow.aeq(n, n2) + n;
    }
}

