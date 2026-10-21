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
import a.PartyClient;
import a.Spring;
import a.Icon;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.function.IntPredicate;
import net.minecraft.class_332;

final class PartyInviteRow
extends Widget {
    private static final float ikt = 17.0f;
    private static final float iku = 64.0f;
    private static final IntPredicate ikv = n -> Character.isLetterOrDigit(n) || n == 45 || n == 32;
    final TextField field = new TextField("Friend's code", Icon.USER_PLUS, 9, ikv);
    private final Spring ikw = new Spring(16.0f);
    private final Spring ikx = new Spring(9.0f);
    private ClickGuiScreen iky;
    private static /* synthetic */ long ikz;
    private static /* synthetic */ int ila;

    PartyInviteRow() {
        super(null);
        this.field.onSubmit = this::ilc;
    }

    @Override
    float height() {
        return 24.0f;
    }

    private float ilb() {
        return this.x + this.w - 64.0f;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        this.iky = hlc2;
        float f4 = this.y + 4.0f;
        this.field.x = this.x;
        this.field.y = f4;
        this.field.w = this.w - 64.0f - 6.0f;
        this.field.h = 17.0f;
        this.field.render(class_3322, hlc2, f, f2, f3);
        float f5 = this.ikw.step(hlc2.canHover() && UiKit.inside(f, f2, this.ilb(), f4, 64.0f, 17.0f), f3);
        UiKit.primaryButton(class_3322, Lang.s("Invite", "Пригласить"), Icon.PLUS, this.ilb(), f4, 64.0f, 17.0f, f5, this.ikx.step(0.0f, f3));
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        this.iky = hlc2;
        if (this.field.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        if (n == 0 && UiKit.inside(f, f2, this.ilb(), this.y + 4.0f, 64.0f, 17.0f)) {
            this.ikx.set(1.0f);
            this.ilc();
            return true;
        }
        return false;
    }

    private void ilc() {
        if (PartyClient.normalize(this.field.text) == null) {
            this.field.error();
            if (this.iky != null) {
                this.iky.toast(Lang.s("Codes look like ABC-234", "Код выглядит как ABC-234"), Icon.USER_PLUS, true);
            }
            return;
        }
        PartyClient.invite(this.field.text);
        this.field.setText("");
        if (this.iky != null) {
            this.iky.focus(null);
        }
    }

    private static /* synthetic */ int agz(int n, int n2) {
        return n - n2 ^ 0x9DA355C1;
    }

    private static /* synthetic */ int aha(int n, int n2) {
        return n * n2 + -1029575758;
    }

    private static /* synthetic */ int ahb(int n, int n2) {
        return PartyInviteRow.agz(n, n2) * n2;
    }
}

