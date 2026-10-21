/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Widget;
import a.iom;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.List;
import net.minecraft.class_332;

final class AutoAccentRow
extends Widget {
    private static final float hht = 22.0f;
    private static final float hhu = 12.0f;
    private final Spring[] hhv;
    private final Spring[] hhw;
    private static /* synthetic */ int hhx;
    private static /* synthetic */ String hhy;

    AutoAccentRow() {
        super(Theme.ACCENT);
        int n = Theme.ACCENT.getModes().size();
        this.hhv = new Spring[n];
        this.hhw = new Spring[n];
        for (int i = 0; i < n; ++i) {
            this.hhv[i] = new Spring(16.0f);
            this.hhw[i] = new Spring(14.0f, i == Theme.ACCENT.index() ? 1.0f : 0.0f);
        }
    }

    @Override
    float height() {
        return 22.0f;
    }

    private float hhz(int n, int n2) {
        float f = (this.w - 12.0f * (float)n2) / (float)(n2 - 1);
        return this.x + 6.0f + (float)n * (12.0f + f);
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        List<String> list = Theme.ACCENT.getModes();
        int n = list.size();
        float f4 = this.y + 11.0f;
        int n2 = -1;
        iom iom2 = Theme.preset();
        for (int i = 0; i < n; ++i) {
            boolean bl;
            float f5 = this.hhz(i, n);
            boolean bl2 = bl = hlc2.canHover() && UiKit.inside(f, f2, f5 - 6.0f - 2.0f, f4 - 6.0f - 2.0f, 16.0f, 16.0f);
            if (bl) {
                n2 = i;
            }
            float f6 = this.hhv[i].step(bl, f3);
            float f7 = this.hhw[i].step(i == Theme.ACCENT.index(), f3);
            float f8 = 6.0f + f6 * 0.8f - f7 * 1.2f;
            boolean bl3 = i == n - 1;
            boolean bl4 = i == 0;
            int[] nArray = Theme.accentPair(i, iom2);
            if (f7 > 0.01f) {
                DrawUtil.circleOutline(class_3322, f5, f4, 7.8f, 1.2f, ColorUtil.mulAlpha(Theme.text, f7 * 0.9f));
            }
            if (bl3) {
                DrawUtil.gradient(class_3322, f5 - f8, f4 - f8, f8 * 2.0f, f8 * 2.0f, f8, -45715, -11930, -16329056, -11698945);
                DrawUtil.circle(class_3322, f5, f4, f8 * 0.5f, nArray[0]);
                continue;
            }
            if (bl4) {
                DrawUtil.circle(class_3322, f5, f4, f8, ColorUtil.withAlpha(Theme.window, 255));
                DrawUtil.circleOutline(class_3322, f5, f4, f8, 0.8f, Theme.stroke);
                DrawUtil.gradient(class_3322, f5 - f8 * 0.55f, f4 - f8 * 0.55f, f8 * 1.1f, f8 * 1.1f, f8 * 0.55f, nArray[0], nArray[1], nArray[1], nArray[0]);
                continue;
            }
            DrawUtil.gradient(class_3322, f5 - f8, f4 - f8, f8 * 2.0f, f8 * 2.0f, f8, nArray[0], nArray[1], nArray[1], nArray[0]);
        }
        if (n2 >= 0) {
            hlc2.hint(n2 == 0 ? Lang.s("Auto  ·  the theme's own accent", "Авто  ·  акцент самой темы") : Lang.value(list.get(n2)));
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        List<String> list = Theme.ACCENT.getModes();
        int n2 = list.size();
        float f3 = this.y + 11.0f;
        for (int i = 0; i < n2; ++i) {
            float f4 = this.hhz(i, n2);
            if (!UiKit.inside(f, f2, f4 - 6.0f - 2.0f, f3 - 6.0f - 2.0f, 16.0f, 16.0f)) continue;
            Theme.ACCENT.set(list.get(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int aao(int n, int n2) {
        return n * n2 | 0xE360843A;
    }

    private static /* synthetic */ int aap(int n, int n2) {
        return AutoAccentRow.aao(n, n2) * n2;
    }
}

