/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.LiquidGlass;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.ModeSetting;
import a.Lang;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_332;

final class ModeDropdown {
    private static final float hxj = 15.0f;
    private static final float hxk = 3.0f;
    final ModeSetting mode;
    private final float hxl;
    private final float hxm;
    private final float hxn;
    private final boolean hxo;
    private final Spring hxp = new Spring(18.0f);
    private final List<Spring> hxq = new ArrayList<Spring>();
    private boolean hxr;
    private static /* synthetic */ long hxs;
    private static /* synthetic */ String hxt;

    ModeDropdown(ModeSetting vlv2, float f, float f2, float f3, float f4, float f5) {
        this.mode = vlv2;
        this.hxl = f;
        this.hxm = f3;
        float f6 = this.hxu();
        this.hxo = f2 + f6 > f5 && f4 - 3.0f - f6 > 0.0f;
        this.hxn = this.hxo ? f4 - 3.0f - f6 : f2;
        for (int i = 0; i < vlv2.getModes().size(); ++i) {
            this.hxq.add(new Spring(18.0f));
        }
    }

    private float hxu() {
        return (float)this.mode.getModes().size() * 15.0f + 6.0f;
    }

    void close() {
        this.hxr = true;
    }

    boolean closing() {
        return this.hxr;
    }

    boolean gone() {
        return this.hxr && this.hxp.get() <= 0.01f;
    }

    void render(class_332 class_3322, float f, float f2, float f3) {
        float f4 = Easing.outCubic(this.hxp.step(this.hxr ? 0.0f : 1.0f, f3));
        if (f4 <= 0.01f) {
            return;
        }
        float f5 = this.hxu();
        float f6 = f5 * (0.35f + 0.65f * f4);
        float f7 = this.hxo ? this.hxn + f5 - f6 : this.hxn;
        float f8 = Theme.r(6.0f);
        DrawUtil.pushAlpha(f4);
        DrawUtil.shadow(class_3322, this.hxl, f7 + 2.0f, this.hxm, f6, f8, 12.0f, Theme.shadow);
        int n = ColorUtil.withAlpha(Theme.cardHover, 250);
        LiquidGlass.surface(class_3322, this.hxl, f7, this.hxm, f6, f8, LiquidGlass.tint(Theme.window, Math.min(1.0f, Theme.windowTint() + 0.08f)), n, 6.0f, LiquidGlass.POPUPS);
        DrawUtil.outline(class_3322, this.hxl, f7, this.hxm, f6, f8, 1.0f, Theme.stroke);
        DrawUtil.pushScissor(class_3322, this.hxl, f7, this.hxm, f6);
        List<String> list = this.mode.getModes();
        while (this.hxq.size() < list.size()) {
            this.hxq.add(new Spring(18.0f));
        }
        for (int i = 0; i < list.size(); ++i) {
            float f9 = this.hxn + 3.0f + (float)i * 15.0f;
            boolean bl = this.mode.get().equals(list.get(i));
            float f10 = this.hxq.get(i).step(!this.hxr && UiKit.inside(f, f2, this.hxl, f9, this.hxm, 15.0f), f3);
            if (f10 > 0.01f) {
                DrawUtil.round(class_3322, this.hxl + 3.0f, f9 + 1.0f, this.hxm - 6.0f, 13.0f, Theme.r(3.5f), ColorUtil.withAlpha(Theme.hover, Math.round((float)ColorUtil.alpha(Theme.hover) * 2.0f * f10)));
            }
            int n2 = bl ? Theme.accent() : ColorUtil.lerp(Theme.textDim, Theme.text, f10);
            UiKit.VALUE.draw(class_3322, UiKit.VALUE.ellipsize(Lang.value(list.get(i)), this.hxm - 24.0f), this.hxl + 8.0f, UiKit.VALUE.centerTop(f9 + 7.5f), n2);
            if (!bl) continue;
            IconRenderer.draw(class_3322, Icon.CHECK, this.hxl + this.hxm - 9.0f, f9 + 7.5f, 7.0f, Theme.accent());
        }
        DrawUtil.popScissor(class_3322);
        DrawUtil.popAlpha();
    }

    boolean mouseClicked(float f, float f2) {
        if (this.hxr || !UiKit.inside(f, f2, this.hxl, this.hxn, this.hxm, this.hxu())) {
            return false;
        }
        int n = (int)((f2 - this.hxn - 3.0f) / 15.0f);
        List<String> list = this.mode.getModes();
        if (n >= 0 && n < list.size()) {
            this.mode.set(list.get(n));
        }
        this.close();
        return true;
    }

    private static /* synthetic */ int adh(int n, int n2) {
        return n + n2 ^ 0xB46952AD;
    }

    private static /* synthetic */ int adi(int n, int n2) {
        return ModeDropdown.adh(n, n2) * n2;
    }
}

