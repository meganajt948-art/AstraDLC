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
import a.vcj;
import a.vhz;
import a.wap;
import flow.config.ConfigManager;
import flow.dev.a;
import java.io.IOException;
import net.minecraft.client.gui.DrawContext;

final class hur
extends imn {
    private static final float hus = 26.0f;
    private static final float hut = 78.0f;
    final iah name = new iah(a.d("\u2139\u58a4\ud276\u4c0f\uc7d7\u4168\ufb7c\u72c3\uec93\u662e\ue1f5", -557382057, -1569708250), vhz.LAYERS, 32, iah.ANY);
    private final vcj huu = new vcj(16.0f);
    private final vcj huv = new vcj(9.0f);
    private hlc huw;
    private static /* synthetic */ long hux;
    private static /* synthetic */ long huy;

    hur() {
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
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        this.huw = hlc2;
        float f4 = this.y + (26.0f - this.huz()) * 0.5f;
        this.name.x = this.x;
        this.name.y = f4;
        this.name.w = this.w - 78.0f - 6.0f;
        this.name.h = this.huz();
        this.name.render(drawContext, hlc2, f, f2, f3);
        float f5 = this.x + this.w - 78.0f;
        float f6 = this.huu.step(hlc2.canHover() && irr.inside(f, f2, f5, f4, 78.0f, this.huz()), f3);
        float f7 = this.huv.step(0.0f, f3);
        String string = ConfigManager.sanitize(this.name.text);
        boolean bl = string != null && ConfigManager.exists(string);
        irr.primaryButton(drawContext, bl ? wap.s(a.c(1450705198, "\u0168\u78e0\uf220\u6c46\ue794\u6120\udb68\u5284\uccca"), a.c(1116761841, "\u6ae2\u1379\u99df\u07db\u8c0e\u0ab8\ub0e4\u3912\ua734\u2df4\uaa55\u502a")) : wap.s(a.c(-236959030, "\u4a9d\u331e\ub9da\u27b8"), a.d("\ua103\ud8ad\u5205\ucc71\u47d6\uc16a\u7b3c\uf2b7\u6ce6", 1350841337, 155162322)), vhz.SAVE, f5, f4, 78.0f, this.huz(), f6, f7);
        if (f6 > 0.5f) {
            hlc2.hint(bl ? wap.s(a.c(412155592, "\ufe93\u8715\u0dd3\u93be\u1864\u9ed7\u2482\uad36\u1355") + string + a.d("\u3367\u6aeb\ue06f\u7e00\uf5ca\u7367\uc97c\u40d9\ude9a\u5426\ud3b0\u2982\ua743\u3ef5\ub4a6\u3240\u8804\u07cf\u9d28\u1b2a\u92cb\ue88b\u6638\ufdf4\u7b8c\uf154\u48f3", 231434180, -1767541595), a.b("\u0ab9\u732f\uf9f0\u6788\uec57\u6ae3\ud0ca\u5935\uc306\u493c", -39776604) + string + a.b("\ucfc8\ub6e2\u3853\ua655\u2d8d\uab45\u111c\u989c\u06c7\u8c72\u0fb9\uf1d5\u7f0f\ue6cf\u6c9f\uea6c\u505d\udf8b\u453b\uc360\u4a9b\u30ce", -1546334363)) : wap.s(a.c(666432652, "\uf4ff\u8d7c\u07b8\u99da\u1248\u94b4\u2ee5\ua71f\u3951\ub3f9\u3423\uce44\u40cc\ud971\u5371\ud596\u6fc8\ue019\u7ab7\ufce1\u751f\u0f5a\u81ba\u1a2a\u9c5a\u1681\uaf76\u2165\ubb99\u3dcf\ub676\u48b0"), a.c(-998943165, "\u5241\u2bef\ua147\u3f33\ub494\u3228\u887e\u01f5\u9fa4\u1179\u92b6\u68c5\ue618\u7fde\uf5f5\u7307\ucd5c\u4281\udc2f\u5a73\ud3f5\ua9a7\u2716\ubcb9\u3ac1\ub013\u09a2\u83eb\u1d04\u9f4d\u10ef\uee37\u647d\ufd85\u7ba9")));
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        this.huw = hlc2;
        if (this.name.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        float f3 = this.y + (26.0f - this.huz()) * 0.5f;
        if (n == 0 && irr.inside(f, f2, this.x + this.w - 78.0f, f3, 78.0f, this.huz())) {
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
                    this.huw.toast(wap.s(a.d("\u3bd5\u4249\uc893\u56f7\udd65\u5b95\ue187\u6838\uf668\u7cd5\ufb0e\u013a\u8fab\u1613\u9c5d\u1afe\ua0e5\u2f28\ub596\u3382\uba36\uc06b\u4ed9\ud500\u5370\ud9af\u605b\uee4c\u74b4\uf2fe\u794c\u879a", 1713511806, 944907999), a.b("\u353e\u4c93\uc64d\u584b\ud3eb\u5551\uef09\u62e8\uf8a5\u7214\uf5c0\u0fb0\u816b\u18a0\u9284\u1060\uae37\u21e2\ubb22\u391c\ub4f1\ucea4\u4014\udbbc\u5dbf\ud765\u6ed5", 1609052420)), vhz.INFO, true);
                }
                return;
            }
            try {
                ConfigManager.save(string);
                this.name.setText(string);
                if (this.huw != null) {
                    this.huw.focus(null);
                    this.huw.toast(wap.s(a.c(-1487859390, "\u1116\u6895\ue251\u7c33\uf7e5\u7110\ueb7f") + string + a.c(-2144138099, "\u2c91"), a.d("\ue89d\u9133\u1b9b\u85ef\u0e48\u88f4\u32af\ubb56\u250a\uaba5\u2cfd", 1002002394, 772848493) + string + a.c(1680293644, "\u3fb6")), vhz.SAVE, false);
                }
            }
            catch (IOException iOException) {
                if (this.huw == null) break block5;
                this.huw.toast(wap.s(a.b("\u9ded\ue47e\u6ea2\uf09a\u7b1e\ufdfb\u47fb\uce18\u5050\udaf2\u5d7e\ua715", 5414306), a.d("\udd1e\ua487\u2a41\ub053\u3bf3\ubd46\u071e\u8eea\u10ca\u9a76\u19c9\ue7d9\u6971\uf0bb\u7aed\ufc6c\u462e\uc9fa\u5333\ud56c\u58ed\u22a6", 11489627, -1528919986)) + iOException.getMessage(), vhz.INFO, true);
            }
        }
    }

    private static /* synthetic */ int acn(int n, int n2) {
        return n * n2 + -1178447323;
    }

    private static /* synthetic */ int aco(int n, int n2) {
        return hur.acn(n, n2) + n;
    }
}

