/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ButtonSettingRow;
import a.ClickGuiScreen;
import a.ClickRow;
import a.ChooseButton;
import a.ModeRow;
import a.SliderRow;
import a.PaletteRow;
import a.ToggleRow;
import a.TextInputRow;
import a.irk;
import a.UiKit;
import a.Spring;
import a.BoolSetting;
import a.ButtonSetting;
import a.ColorSetting;
import a.ListSetting;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.TextSetting;
import java.util.function.BooleanSupplier;
import net.minecraft.class_332;

abstract class Widget {
    final Setting setting;
    final Spring hover = new Spring(16.0f);
    private final Spring imo = new Spring(14.0f, 1.0f);
    private final Spring imp = new Spring(12.0f, 1.0f);
    private BooleanSupplier imq = () -> true;
    private BooleanSupplier imr = () -> true;
    float x;
    float y;
    float w;
    private static /* synthetic */ String ims;
    private static /* synthetic */ long imt;

    Widget(Setting vmo2) {
        this.setting = vmo2;
    }

    static Widget of(Setting vmo2) {
        Widget imn2;
        if (vmo2 instanceof BoolSetting) {
            BoolSetting vkl2 = (BoolSetting)vmo2;
            imn2 = new ToggleRow(vkl2);
        } else if (vmo2 instanceof NumberSetting) {
            NumberSetting vmc2 = (NumberSetting)vmo2;
            imn2 = new SliderRow(vmc2);
        } else if (vmo2 instanceof ColorSetting) {
            ColorSetting vla2 = (ColorSetting)vmo2;
            imn2 = new PaletteRow(vla2);
        } else if (vmo2 instanceof ModeSetting) {
            ModeSetting vlv2 = (ModeSetting)vmo2;
            imn2 = new ModeRow(vlv2);
        } else if (vmo2 instanceof KeySetting) {
            KeySetting vlq2 = (KeySetting)vmo2;
            imn2 = new ClickRow(vlq2, vlq2.getName(), new irk(vlq2.getName(), vlq2::get, vlq2::set, true));
        } else if (vmo2 instanceof TextSetting) {
            TextSetting vmu2 = (TextSetting)vmo2;
            imn2 = new TextInputRow(vmu2);
        } else if (vmo2 instanceof ButtonSetting) {
            ButtonSetting vkw2 = (ButtonSetting)vmo2;
            imn2 = new ButtonSettingRow(vkw2);
        } else if (vmo2 instanceof ListSetting) {
            ListSetting vlj2 = (ListSetting)vmo2;
            imn2 = new ChooseButton(vlj2);
        } else {
            return null;
        }
        if (vmo2.activeCondition() != null) {
            imn2.activeWhen(vmo2.activeCondition());
        }
        if (vmo2.visibleCondition() != null) {
            imn2.visibleWhen(vmo2.visibleCondition());
        }
        return imn2;
    }

    Widget visibleWhen(BooleanSupplier booleanSupplier) {
        this.imq = booleanSupplier;
        this.imo.set(booleanSupplier.getAsBoolean() ? 1.0f : 0.0f);
        return this;
    }

    Widget activeWhen(BooleanSupplier booleanSupplier) {
        this.imr = booleanSupplier;
        this.imp.set(booleanSupplier.getAsBoolean() ? 1.0f : 0.0f);
        return this;
    }

    abstract float height();

    final float currentHeight() {
        return this.height() * this.imo.get();
    }

    final float targetHeight() {
        return this.imq.getAsBoolean() ? this.height() : 0.0f;
    }

    final void animate(float f) {
        this.imo.step(this.imq.getAsBoolean(), f);
        this.imp.step(this.imr.getAsBoolean(), f);
    }

    final float opacity() {
        return Math.min(1.0f, this.imo.get() * 1.3f) * (0.38f + 0.62f * this.imp.get());
    }

    final boolean interactive() {
        return this.imo.get() > 0.6f && this.imq.getAsBoolean();
    }

    abstract void render(class_332 var1, ClickGuiScreen var2, float var3, float var4, float var5);

    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        return false;
    }

    void mouseDragged(float f, float f2) {
    }

    boolean hovered(float f, float f2) {
        return UiKit.inside(f, f2, this.x, this.y, this.w, this.height());
    }

    private static /* synthetic */ int ahl(int n, int n2) {
        return n + n2 ^ 0x9DE40D1;
    }

    private static /* synthetic */ int ahm(int n, int n2) {
        return Widget.ahl(n, n2) + n;
    }

    private static /* synthetic */ int ahn(int n, int n2) {
        return Widget.ahl(n, n2) ^ 0x38E27A;
    }
}

