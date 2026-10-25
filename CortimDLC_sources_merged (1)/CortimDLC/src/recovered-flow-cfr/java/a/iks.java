/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.iah;
import a.imn;
import a.irr;
import a.ucg;
import a.vcj;
import a.vhz;
import a.wap;
import flow.dev.a;
import java.util.function.IntPredicate;
import net.minecraft.client.gui.DrawContext;

final class iks
extends imn {
    private static final float ikt = 17.0f;
    private static final float iku = 64.0f;
    private static final IntPredicate ikv = n -> Character.isLetterOrDigit(n) || n == 45 || n == 32;
    final iah field = new iah(a.c(-1845535435, "\u5d7e\u24fb\uae33\u304e\ubb92\u3d29\u8739\u0e9c\u9090\u1a62\u9dbd\u67c7\ue911"), vhz.USER_PLUS, 9, ikv);
    private final vcj ikw = new vcj(16.0f);
    private final vcj ikx = new vcj(9.0f);
    private hlc iky;
    private static /* synthetic */ long ikz;
    private static /* synthetic */ int ila;

    iks() {
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
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        this.iky = hlc2;
        float f4 = this.y + 4.0f;
        this.field.x = this.x;
        this.field.y = f4;
        this.field.w = this.w - 64.0f - 6.0f;
        this.field.h = 17.0f;
        this.field.render(drawContext, hlc2, f, f2, f3);
        float f5 = this.ikw.step(hlc2.canHover() && irr.inside(f, f2, this.ilb(), f4, 64.0f, 17.0f), f3);
        irr.primaryButton(drawContext, wap.s(a.d("\uc9dd\ub04b\u3a80\ua4ee\u2f24\ua984", 508246472, 2108026970), a.c(269984942, "\ua0bb\ud955\u53fe\ucd84\u465b\uc0e1\u7ac3\uf34b\u6d6e\ue7d1")), vhz.PLUS, this.ilb(), f4, 64.0f, 17.0f, f5, this.ikx.step(0.0f, f3));
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        this.iky = hlc2;
        if (this.field.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        if (n == 0 && irr.inside(f, f2, this.ilb(), this.y + 4.0f, 64.0f, 17.0f)) {
            this.ikx.set(1.0f);
            this.ilc();
            return true;
        }
        return false;
    }

    private void ilc() {
        if (ucg.normalize(this.field.text) == null) {
            this.field.error();
            if (this.iky != null) {
                this.iky.toast(wap.s(a.b("\u213e\u58a3\ud27b\u4c0b\uc7ca\u4128\ufb37\u72c5\uec9a\u662f\ue1b7\u1b8a\u9558\u0ceb\u86b6\u0002\uba2c\u35fe\uaf4c\u2973\ua09b\udacb\u547f", 247996778), a.b("\u8d2b\uf4be\u7e67\ue402\u6bc7\ued0f\u5724\udedd\u40f6\uca3c\u4de3\ub7e8\u3d5d\ua0f6\u2aaf\uac54\u1201\u9db1\u0701\u8151\u08c8\u7286\ufc34\u67e2", 841517353)), vhz.USER_PLUS, true);
            }
            return;
        }
        ucg.invite(this.field.text);
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
        return iks.agz(n, n2) * n2;
    }
}

