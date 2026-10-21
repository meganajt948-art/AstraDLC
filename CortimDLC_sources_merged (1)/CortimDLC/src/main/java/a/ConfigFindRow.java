/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
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
import flow.config.ConfigShare;
import flow.dev.StringDecryptor;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.function.IntPredicate;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class ConfigFindRow
extends Widget {
    private static final float hvb = 24.0f;
    private static final float hvc = 17.0f;
    private static final float hvd = 78.0f;
    private static final IntPredicate hve = n -> Character.isLetterOrDigit(n) || n == 45 || n == 32;
    final TextField field = new TextField("Find a config by code", Icon.SEARCH, 20, hve);
    private final Spring hvf = new Spring(16.0f);
    private final Spring hvg = new Spring(9.0f);
    private ClickGuiScreen hvh;
    private boolean hvi;
    private static /* synthetic */ int hvj;
    private static /* synthetic */ boolean hvk;

    ConfigFindRow() {
        super(null);
        this.field.onSubmit = this::hvm;
    }

    @Override
    float height() {
        return 24.0f;
    }

    private float hvl() {
        return this.x + this.w - 78.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        this.hvh = hlc2;
        float f4 = this.y + 3.5f;
        this.field.x = this.x;
        this.field.y = f4;
        this.field.w = this.w - 78.0f - 6.0f;
        this.field.h = 17.0f;
        this.field.render(class_3322, hlc2, f, f2, f3);
        boolean bl = hlc2.canHover() && UiKit.inside(f, f2, this.hvl(), f4, 78.0f, 17.0f);
        float f5 = this.hvf.step(bl, f3);
        UiKit.secondaryButton(class_3322, this.hvi ? Lang.s("Looking…", "Ищем…") : Lang.s("Find", "Найти"), Icon.DOWNLOAD, this.hvl(), f4, 78.0f, 17.0f, this.hvi ? 1.0f : f5, this.hvg.step(0.0f, f3));
        if (bl || hlc2.canHover() && this.field.contains(f, f2)) {
            hlc2.hint(Lang.s("Paste a friend's code: their config shows up in your list", "Вставьте код друга: его конфиг появится в вашем списке"));
        }
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        this.hvh = hlc2;
        if (this.field.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        float f3 = this.y + 3.5f;
        if (n == 0 && UiKit.inside(f, f2, this.hvl(), f3, 78.0f, 17.0f)) {
            this.hvg.set(1.0f);
            this.hvm();
            return true;
        }
        return false;
    }

    private void hvm() {
        if (this.hvi) {
            return;
        }
        if (ConfigShare.normalize(this.field.text) == null) {
            this.field.error();
            if (this.hvh != null) {
                this.hvh.toast(ConfigShare.describe(new IOException("format")), Icon.SEARCH, true);
            }
            return;
        }
        this.hvi = true;
        ClickGuiScreen hlc2 = this.hvh;
        ConfigShare.fetch(this.field.text).whenCompleteAsync((imported, throwable) -> {
            this.hvi = false;
            if (throwable != null) {
                this.field.error();
                if (hlc2 != null) {
                    hlc2.toast(ConfigShare.describe(throwable), Icon.INFO, true);
                }
                return;
            }
            this.field.setText("");
            if (hlc2 != null) {
                hlc2.focus(null);
                hlc2.toast(imported.existed() ? Lang.s("You already have it: “" + imported.name() + "”", "Уже есть у вас: «" + imported.name() + "»") : Lang.s("Added “" + imported.name() + "”", "Добавлен «" + imported.name() + "»"), Icon.DOWNLOAD, false);
            }
        }, (Executor)class_310.method_1551());
    }

    private static /* synthetic */ int acr(int n, int n2) {
        return (n ^ n2) + -1934725538;
    }

    private static /* synthetic */ int acs(int n, int n2) {
        return ConfigFindRow.acr(n, n2) + n;
    }

    private static /* synthetic */ int act(int n, int n2) {
        return ConfigFindRow.acs(n, n2) + n;
    }
}

