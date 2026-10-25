/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.imn;
import a.iov;
import a.irr;
import a.isn;
import a.isv;
import a.ujt;
import a.uok;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class irv
extends imn {
    private static final float irw = 54.0f;
    private static final float irx = 6.0f;
    private static final float iry = 10.0f;
    private final List<vcj> irz = new ArrayList<vcj>();
    private final List<vcj> isa = new ArrayList<vcj>();
    private static /* synthetic */ int isb;
    private static /* synthetic */ int isc;

    irv() {
        super(null);
    }

    private List<isn> isd() {
        List<isn> list = isv.entries();
        while (this.irz.size() < list.size()) {
            this.irz.add(new vcj(16.0f));
            this.isa.add(new vcj(14.0f));
        }
        return list;
    }

    private int ise() {
        float f = this.w > 0.0f ? this.w : 376.0f;
        return Math.max(3, (int)((f + 6.0f) / 60.0f));
    }

    private float isf() {
        int n = this.ise();
        return (this.w - 6.0f * (float)(n - 1)) / (float)n;
    }

    private float isg() {
        return this.isf() * 9.0f / 16.0f;
    }

    private int ish() {
        return (this.isd().size() + this.ise() - 1) / this.ise();
    }

    @Override
    float height() {
        float f = this.w > 0.0f ? this.isf() : 54.0f;
        float f2 = f * 9.0f / 16.0f + 10.0f;
        return 3.0f + (float)this.ish() * f2 + (float)(this.ish() - 1) * 6.0f;
    }

    private float isi(int n) {
        return this.x + (float)(n % this.ise()) * (this.isf() + 6.0f);
    }

    private float isj(int n) {
        return this.y + 3.0f + (float)(n / this.ise()) * (this.isg() + 10.0f + 6.0f);
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<isn> list = this.isd();
        float f4 = this.isf();
        float f5 = this.isg();
        float f6 = iov.r(5.0f);
        for (int i = 0; i < list.size(); ++i) {
            isn isn2 = list.get(i);
            float f7 = this.isi(i);
            float f8 = this.isj(i);
            boolean bl = hlc2.canHover() && irr.inside(f, f2, f7, f8, f4, f5 + 10.0f);
            float f9 = this.irz.get(i).step(bl, f3);
            float f10 = this.isa.get(i).step(isn2.key.equals(isv.selected()), f3);
            float f11 = f8 - f9;
            if (bl) {
                hlc2.hint(isn2.isWorld() ? wap.s(a.b("\ud51b\uac8b\u2617\ub831\u33f0\ub54c\u0f1f\u86f2\u18bc\u921c\u15da\uefbc\u6139\ud8bc\u72db\uf47e\u4e2d\uc1f1\u5b07\udd11\u54e0\u2ebd\ua006\u3b92\ubdba\u3773\u8edd\u0092\u9a6d\u1c78\u9789\u695f\ue31d\u7aed\ufcb9\u7602\uc991\u43b4\uc57b\u5cc7\ud6dd\ua861\u223a\ua580\u3f4c", -1832790664), a.d("\u426d\u3bf8\ub129\u2b4f\ua486\u2238\u9864\u119e\u8fc6\u0165\ua682\u7cc7\uf607\u6fb1\ue1f2\u631f\ud959\u5680\ucc40\u4e7f\uc39a\ub9c1\u377e\uacae\u2ad9\ua415\u19ba\u97ef\u0d60\u8f51\u00fa\ufe20\u741c\uede6", -1981584058, 2132683544)) : isv.label(isn2) + (isn2.isLive() ? wap.s(a.c(1108563249, "\u5500\u2cb1\ua6f5\u3813\ub3c4\u3534\u8f68\u069e\u98c5\u1278\u95be\u6fde\ue108\u78fd\uf2fd\u7414\uce49"), a.c(-417826806, "\u7825\u0194\u8bd0\u1536\u9ee1\u1c46\ua61b\u2fe0\ub1b3\u3b09\ub8cf\u46a3\uc87c\u51c9\udb95")) : (isn2.isVideo() ? wap.s(a.b("\ucad6\ub367\u3923\ua7c5\u2c12\uaaf5\u10b9\u9945\u071b\u8da0", -410727684), a.d("\uea34\u9385\u19c1\u8727\u0cf0\u8e53\u340a\ubdf7\u23a9\ua913", -740380589, -1646699955)) : (isn2.isUser() ? wap.s(a.c(573754177, "\ucb6e\ub2df\u389b\ua67d\u2daa\uab42\u1107\u98ec\u06b4\u8c57\u0bcd\uf1b8\u7f63\ue6d4\u6c85"), a.d("\u8c8c\uf53d\u7f79\ue19f\u6a48\ue8eb\u52ba\udb33\u4514\ucbb5\u487c\ub207\u3ca0\ua513\u2f3a\ua9ce\u1386\u9c5d", 296825892, -1182746470)) : wap.s(a.c(-1581872748, "\u89b9\uf008\u7a4c\ue4aa\u6f7d\ue98e\u53ca\uda27\u447d\uced4\u495e\ub36b\u3dbb"), a.c(-245705572, "\ud4b3\uad02\u2746\ub9a0\u3277\ub0d4\u0af4\u8306\u1d5b\u9794\u104c\uea35\u64e2\ufd5e\u7772"))))));
            }
            if (f10 > 0.01f) {
                uut.shadow(drawContext, f7, f11, f4, f5, f6, 7.0f, iov.accent((int)(70.0f * f10)));
            }
            if (isn2.isWorld()) {
                uut.gradient(drawContext, f7, f11, f4, f5, f6, -12882264, -8408864, -9728178, -13280722);
                vjf.draw(drawContext, vhz.GLOBE, f7 + f4 * 0.5f, f11 + f5 * 0.5f, 11.0f, -419430401);
            } else {
                uok uok2 = isv.thumbnail(isn2);
                if (uok2 != null) {
                    uut.image(drawContext, uok2.view, f7, f11, f4, f5, f6, -1);
                } else {
                    uut.round(drawContext, f7, f11, f4, f5, f6, iov.field);
                    vjf.draw(drawContext, vhz.IMAGE, f7 + f4 * 0.5f, f11 + f5 * 0.5f, 10.0f, isn2.failed ? -1750963 : iov.textMuted);
                }
            }
            if (isn2.isLive() || isn2.isVideo()) {
                uut.circle(drawContext, f7 + 6.0f, f11 + f5 - 6.0f, 3.6f, -1728053248);
                vjf.draw(drawContext, vhz.PLAY, f7 + 6.2f, f11 + f5 - 6.0f, 4.6f, -218103809);
            }
            uut.outline(drawContext, f7, f11, f4, f5, f6, 1.0f, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, f9 * 0.5f), iov.accent(), f10));
            if (f10 > 0.02f) {
                float f12 = f7 + f4 - 5.5f;
                float f13 = f11 + 5.5f;
                float f14 = vcq.outBack(f10);
                uut.pushAlpha(f10);
                drawContext.getMatrices().pushMatrix();
                drawContext.getMatrices().translate(f12, f13);
                drawContext.getMatrices().scale(f14, f14);
                uut.circle(drawContext, 0.0f, 0.0f, 3.8f, iov.accent());
                vjf.draw(drawContext, vhz.CHECK, 0.0f, 0.0f, 5.5f, iov.onAccent());
                drawContext.getMatrices().popMatrix();
                uut.popAlpha();
            }
            irr.SMALL.drawCentered(drawContext, irr.SMALL.ellipsize(isv.label(isn2), f4), f7 + f4 * 0.5f, irr.SMALL.centerTop(f8 + f5 + 5.0f + 1.0f), ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, f9), iov.text, f10));
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        List<isn> list = this.isd();
        float f3 = this.isf();
        float f4 = this.isg();
        for (int i = 0; i < list.size(); ++i) {
            if (!irr.inside(f, f2, this.isi(i), this.isj(i), f3, f4 + 10.0f)) continue;
            isv.select(list.get((int)i).key);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int ajf(int n, int n2) {
        return n * n2 + 894134942;
    }

    private static /* synthetic */ int ajg(int n, int n2) {
        return irv.ajf(n, n2) * n2;
    }

    private static /* synthetic */ int ajh(int n, int n2) {
        return n + n2 + 448513735;
    }
}

