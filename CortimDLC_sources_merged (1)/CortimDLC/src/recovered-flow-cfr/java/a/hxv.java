/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hhf;
import a.hlc;
import a.iah;
import a.imn;
import a.irr;
import a.vcj;
import a.vhz;
import a.wap;
import flow.dev.a;
import java.util.function.IntPredicate;
import net.minecraft.client.gui.DrawContext;

final class hxv
extends imn {
    private static final float hxw = 17.0f;
    private static final float hxx = 52.0f;
    private static final IntPredicate hxy = n -> n > 32 && n != 127 && n != 167;
    final iah name = new iah(a.c(1291375195, "\ud200\uab8d\u2153\ubf3a\u34f1\ub257\u0856\u81e9\u1fb9\u9504\u12df"), vhz.USER_PLUS, 20, hxy);
    private final vcj hxz = new vcj(16.0f);
    private final vcj hya = new vcj(9.0f);
    private hlc hyb;
    private static /* synthetic */ String hyc;
    private static /* synthetic */ String hyd;

    hxv() {
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
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        this.hyb = hlc2;
        float f4 = this.y + 4.0f;
        this.name.x = this.x;
        this.name.y = f4;
        this.name.w = this.w - 52.0f - 6.0f;
        this.name.h = 17.0f;
        this.name.render(drawContext, hlc2, f, f2, f3);
        float f5 = this.hxz.step(hlc2.canHover() && irr.inside(f, f2, this.hye(), f4, 52.0f, 17.0f), f3);
        irr.primaryButton(drawContext, wap.s(a.d("\u9c65\ue5f1\u6f22", 363118095, 358883880), a.b("\u58f8\u2163\uabbf\u35cf\ube1a\u38a1\u8288\u0b77", -1100325660)), vhz.PLUS, this.hye(), f4, 52.0f, 17.0f, f5, this.hya.step(0.0f, f3));
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        this.hyb = hlc2;
        if (this.name.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        if (n == 0 && irr.inside(f, f2, this.hye(), this.y + 4.0f, 52.0f, 17.0f)) {
            this.hya.set(1.0f);
            this.hyf();
            return true;
        }
        return false;
    }

    private void hyf() {
        String string = hhf.clean(this.name.text);
        if (string == null) {
            this.name.error();
            if (this.hyb != null) {
                this.hyb.toast(wap.s(a.c(73502098, "\u8dd4\uf448\u7e92\ue0f6\u6b64\ued94\u5786\ude27\u4064\ucad8\u4d13\ub77e\u39be\ua05d\u2a40\uacbe\u16fd\u9924"), a.d("\u9e9e\ue70f\u6ddb\uf3ab\u7870\ufebb\u449f\uc97b\u5339\ud98d\u5e5c\ua037\u2af8\ub342\u3962\ubfed\u05a6\u8a7d", -735275264, 1972243870)), vhz.USER_PLUS, true);
            }
            return;
        }
        if (!hhf.add(string)) {
            this.name.error();
            if (this.hyb != null) {
                this.hyb.toast(wap.s(string + a.b("\uf0cc\u8934\u03fd\u9ddf\u1649\u90f5\u2ab8\ua35e\u3d05\ub7b1\u307f\uca57\u44c1\udd31\u5724\ud1c1\u6b95\ue448\u7ef0\uf8ab", 1724641528), string + a.c(792985682, "|\u7dae\uf708\u697a\ue6b8\u641b\uda5a\u57bf\uc994\u4326\uc481\u3e8b\ub05f\u29e4")), vhz.FRIENDS, true);
            }
            return;
        }
        this.name.setText("");
        if (this.hyb != null) {
            this.hyb.toast(wap.s(a.b("\u80a6\uf932\u73e1\ued91\u6647\ue0b2", 933920993), a.b("\ue42b\u9db0\u176c\u891c\u02c9\u8471\u3e2c\ub7d5\u2d97", -295903178)) + string, vhz.FRIENDS, false);
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

