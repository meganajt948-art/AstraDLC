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
import a.irk;
import a.UiKit;
import a.ColorUtil;
import a.Spring;
import a.Setting;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_332;

final class ClickRow
extends Widget {
    private static final float icu = 20.0f;
    private final String icv;
    private final irk icw;
    private final Spring icx = new Spring(14.0f);
    private static /* synthetic */ boolean icy;
    private static /* synthetic */ boolean icz;

    ClickRow(String string, irk irk2) {
        this(null, string, irk2);
    }

    ClickRow(Setting vmo2, String string, irk irk2) {
        super(vmo2);
        this.icv = string;
        this.icw = irk2;
    }

    @Override
    float height() {
        return 20.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.icx.step(hlc2.binding() == this.icw, f3);
        float f6 = this.y + 10.0f;
        UiKit.LABEL.draw(class_3322, Lang.t(this.icv), this.x, UiKit.LABEL.centerTop(f6), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f4, f5)));
        String string = f5 > 0.5f ? "..." : UiKit.keyName(this.icw.get());
        float f7 = f5 > 0.01f ? 0.55f + 0.45f * (float)Math.sin((double)System.nanoTime() / 1.6E8) : 0.0f;
        UiKit.drawChip(class_3322, string, this.x + this.w, f6, ColorUtil.lerp(Theme.text, Theme.accent(), f5), ColorUtil.lerp(Theme.stroke, Theme.accent((int)(120.0f + 110.0f * f7)), f5), f4);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (this.hovered(f, f2) && n == 0) {
            hlc2.startBinding(this.icw);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int afh(int n, int n2) {
        return n - n2 + 1491098794;
    }

    private static /* synthetic */ int afi(int n, int n2) {
        return ClickRow.afh(n, n2) * n2;
    }

    private static /* synthetic */ int afj(int n, int n2) {
        return ClickRow.afh(n, n2) + n;
    }
}

