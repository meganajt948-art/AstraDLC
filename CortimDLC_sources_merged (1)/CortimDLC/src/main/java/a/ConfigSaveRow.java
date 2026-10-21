/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.TextField;
import a.Widget;
import a.UiKit;
import a.Spring;
import a.Icon;
import a.Lang;
import flow.config.ConfigManager;
import flow.dev.StringDecryptor;
import java.io.IOException;
import net.minecraft.class_332;

final class ConfigSaveRow
extends Widget {
    private static final float hus = 26.0f;
    private static final float hut = 78.0f;
    final TextField name = new TextField("Config name", Icon.LAYERS, 32, TextField.ANY);
    private final Spring huu = new Spring(16.0f);
    private final Spring huv = new Spring(9.0f);
    private ClickGuiScreen huw;
    private static /* synthetic */ long hux;
    private static /* synthetic */ long huy;

    ConfigSaveRow() {
        super(null);
        this.name.onSubmit = this::save;
    }

    @Override
    float height() {
        return 26.0f;
    }

    private float huz() {
        return 17.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        this.huw = hlc2;
        float f4 = this.y + (26.0f - this.huz()) * 0.5f;
        this.name.x = this.x;
        this.name.y = f4;
        this.name.w = this.w - 78.0f - 6.0f;
        this.name.h = this.huz();
        this.name.render(class_3322, hlc2, f, f2, f3);
        float f5 = this.x + this.w - 78.0f;
        float f6 = this.huu.step(hlc2.canHover() && UiKit.inside(f, f2, f5, f4, 78.0f, this.huz()), f3);
        float f7 = this.huv.step(0.0f, f3);
        String string = ConfigManager.sanitize(this.name.text);
        boolean bl = string != null && ConfigManager.exists(string);
        UiKit.primaryButton(class_3322, bl ? Lang.s("Overwrite", "Перезаписать") : Lang.s("Save", "Сохранить"), Icon.SAVE, f5, f4, 78.0f, this.huz(), f6, f7);
        if (f6 > 0.5f) {
            hlc2.hint(bl ? Lang.s("Replace “" + string + "” with the current settings", "Заменить «" + string + "» текущими настройками") : Lang.s("Save modules, settings and binds", "Сохранить модули, настройки и бинды"));
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        this.huw = hlc2;
        if (this.name.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        float f3 = this.y + (26.0f - this.huz()) * 0.5f;
        if (n == 0 && UiKit.inside(f, f2, this.x + this.w - 78.0f, f3, 78.0f, this.huz())) {
            this.huv.set(1.0f);
            this.save();
            return true;
        }
        return false;
    }

    void save() {
        block5: {
            String string = ConfigManager.sanitize(this.name.text);
            if (string == null) {
                this.name.error();
                if (this.huw != null) {
                    this.huw.toast(Lang.s("Type a name for the config first", "Сначала введите имя конфига"), Icon.INFO, true);
                }
                return;
            }
            try {
                ConfigManager.save(string);
                this.name.setText(string);
                if (this.huw != null) {
                    this.huw.focus(null);
                    this.huw.toast(Lang.s("Saved “" + string + "”", "Сохранено «" + string + "»"), Icon.SAVE, false);
                }
            }
            catch (IOException iOException) {
                if (this.huw == null) break block5;
                this.huw.toast(Lang.s("Can't save: ", "Не удалось сохранить: ") + iOException.getMessage(), Icon.INFO, true);
            }
        }
    }

    private static /* synthetic */ int acn(int n, int n2) {
        return n * n2 + -1178447323;
    }

    private static /* synthetic */ int aco(int n, int n2) {
        return ConfigSaveRow.acn(n, n2) + n;
    }
}

