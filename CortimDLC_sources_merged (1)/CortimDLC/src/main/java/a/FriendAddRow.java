/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.TextField;
import a.Widget;
import a.UiKit;
import a.Spring;
import a.Icon;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.function.IntPredicate;
import net.minecraft.class_332;

final class FriendAddRow
extends Widget {
    private static final float hxw = 17.0f;
    private static final float hxx = 52.0f;
    private static final IntPredicate hxy = n -> n > 32 && n != 127 && n != 167;
    final TextField name = new TextField("Player name", Icon.USER_PLUS, 20, hxy);
    private final Spring hxz = new Spring(16.0f);
    private final Spring hya = new Spring(9.0f);
    private ClickGuiScreen hyb;
    private static /* synthetic */ String hyc;
    private static /* synthetic */ String hyd;

    FriendAddRow() {
        super(null);
        this.name.onSubmit = this::hyf;
    }

    @Override
    float height() {
        return 24.0f;
    }

    private float hye() {
        return this.x + this.w - 52.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        this.hyb = hlc2;
        float f4 = this.y + 4.0f;
        this.name.x = this.x;
        this.name.y = f4;
        this.name.w = this.w - 52.0f - 6.0f;
        this.name.h = 17.0f;
        this.name.render(class_3322, hlc2, f, f2, f3);
        float f5 = this.hxz.step(hlc2.canHover() && UiKit.inside(f, f2, this.hye(), f4, 52.0f, 17.0f), f3);
        UiKit.primaryButton(class_3322, Lang.s("Add", "Добавить"), Icon.PLUS, this.hye(), f4, 52.0f, 17.0f, f5, this.hya.step(0.0f, f3));
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        this.hyb = hlc2;
        if (this.name.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        if (n == 0 && UiKit.inside(f, f2, this.hye(), this.y + 4.0f, 52.0f, 17.0f)) {
            this.hya.set(1.0f);
            this.hyf();
            return true;
        }
        return false;
    }

    private void hyf() {
        String string = Friends.clean(this.name.text);
        if (string == null) {
            this.name.error();
            if (this.hyb != null) {
                this.hyb.toast(Lang.s("Type a player name", "Введите ник игрока"), Icon.USER_PLUS, true);
            }
            return;
        }
        if (!Friends.add(string)) {
            this.name.error();
            if (this.hyb != null) {
                this.hyb.toast(Lang.s(string + " is already a friend", string + " уже в друзьях"), Icon.FRIENDS, true);
            }
            return;
        }
        this.name.setText("");
        if (this.hyb != null) {
            this.hyb.toast(Lang.s("Added ", "Добавлен ") + string, Icon.FRIENDS, false);
            this.hyb.focus(null);
        }
    }

    private static /* synthetic */ int adl(int n, int n2) {
        return n + n2 + -1352804198;
    }

    private static /* synthetic */ int adm(int n, int n2) {
        return n + n2 | 0x79FBD7EF;
    }
}

