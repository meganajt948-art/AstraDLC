/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.hip;
import a.ClickGuiScreen;
import a.Widget;
import a.UiKit;
import a.Spring;
import a.Icon;
import a.ButtonSetting;
import a.Setting;
import a.Lang;
import net.minecraft.class_332;

final class ButtonSettingRow
extends Widget {
    private static final float hiw = 24.0f;
    private static final float hix = 17.0f;
    private static final float hiy = 6.0f;
    private final hip[] hiz;
    private final Spring[] hja;
    private final Spring[] hjb;
    private static /* synthetic */ boolean hjc;
    private static /* synthetic */ long hjd;

    ButtonSettingRow(String string, Icon vhz2, Runnable runnable) {
        this(new hip(string, vhz2, runnable));
    }

    ButtonSettingRow(hip ... hipArray) {
        this((Setting)null, hipArray);
    }

    ButtonSettingRow(ButtonSetting vkw2) {
        this(vkw2, (hip[])vkw2.buttons().stream().map(vkq2 -> new hip(vkq2.label(), vkq2.icon(), vkq2.action())).toArray(hip[]::new));
    }

    private ButtonSettingRow(Setting vmo2, hip[] hipArray) {
        super(vmo2);
        this.hiz = hipArray;
        this.hja = new Spring[hipArray.length];
        this.hjb = new Spring[hipArray.length];
        for (int i = 0; i < hipArray.length; ++i) {
            this.hja[i] = new Spring(16.0f);
            this.hjb[i] = new Spring(10.0f);
        }
    }

    @Override
    float height() {
        return 24.0f;
    }

    private float hje() {
        return (this.w - 6.0f * (float)(this.hiz.length - 1)) / (float)this.hiz.length;
    }

    private float hjf(int n) {
        return this.x + (float)n * (this.hje() + 6.0f);
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        float f4 = this.y + 3.5f;
        float f5 = this.hje();
        for (int i = 0; i < this.hiz.length; ++i) {
            hip hip2 = this.hiz[i];
            float f6 = this.hjf(i);
            float f7 = this.hja[i].step(hlc2.canHover() && UiKit.inside(f, f2, f6, f4, f5, 17.0f), f3);
            String string = UiKit.VALUE.ellipsize(Lang.t(hip2.label()), f5 - 8.0f - (hip2.icon() != null ? 11.0f : 0.0f));
            UiKit.secondaryButton(class_3322, string, hip2.icon(), f6, f4, f5, 17.0f, f7, this.hjb[i].step(0.0f, f3));
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        float f3 = this.y + 3.5f;
        if (n != 0) {
            return false;
        }
        for (int i = 0; i < this.hiz.length; ++i) {
            if (!UiKit.inside(f, f2, this.hjf(i), f3, this.hje(), 17.0f)) continue;
            this.hiz[i].action().run();
            this.hjb[i].set(1.0f);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int aaz(int n, int n2) {
        return n * n2 ^ 0xEDF90BFE;
    }

    private static /* synthetic */ int aba(int n, int n2) {
        return n + n2 ^ 0x97A8A6D0;
    }

    private static /* synthetic */ int abb(int n, int n2) {
        return ButtonSettingRow.aba(n, n2) * n2;
    }
}

