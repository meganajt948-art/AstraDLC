/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.imn;
import a.iom;
import a.iov;
import a.irr;
import a.ujt;
import a.uut;
import a.vcj;
import a.wap;
import flow.dev.a;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class hhs
extends imn {
    private static final float hht = 22.0f;
    private static final float hhu = 12.0f;
    private final vcj[] hhv;
    private final vcj[] hhw;
    private static /* synthetic */ int hhx;
    private static /* synthetic */ String hhy;

    hhs() {
        super(iov.ACCENT);
        int n = iov.ACCENT.getModes().size();
        this.hhv = new vcj[n];
        this.hhw = new vcj[n];
        for (int i = 0; i < n; ++i) {
            this.hhv[i] = new vcj(16.0f);
            this.hhw[i] = new vcj(14.0f, i == iov.ACCENT.index() ? 1.0f : 0.0f);
        }
    }

    @Override
    float height() {
        return 22.0f;
    }

    private float hhz(int n, int n2) {
        float f = (this.w - 12.0f * (float)n2) / (float)(n2 - 1);
        return this.x + 6.0f + (float)n * (12.0f + f);
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<String> list = iov.ACCENT.getModes();
        int n = list.size();
        float f4 = this.y + 11.0f;
        int n2 = -1;
        iom iom2 = iov.preset();
        for (int i = 0; i < n; ++i) {
            boolean bl;
            float f5 = this.hhz(i, n);
            boolean bl2 = bl = hlc2.canHover() && irr.inside(f, f2, f5 - 6.0f - 2.0f, f4 - 6.0f - 2.0f, 16.0f, 16.0f);
            if (bl) {
                n2 = i;
            }
            float f6 = this.hhv[i].step(bl, f3);
            float f7 = this.hhw[i].step(i == iov.ACCENT.index(), f3);
            float f8 = 6.0f + f6 * 0.8f - f7 * 1.2f;
            boolean bl3 = i == n - 1;
            boolean bl4 = i == 0;
            int[] nArray = iov.accentPair(i, iom2);
            if (f7 > 0.01f) {
                uut.circleOutline(drawContext, f5, f4, 7.8f, 1.2f, ujt.mulAlpha(iov.text, f7 * 0.9f));
            }
            if (bl3) {
                uut.gradient(drawContext, f5 - f8, f4 - f8, f8 * 2.0f, f8 * 2.0f, f8, -45715, -11930, -16329056, -11698945);
                uut.circle(drawContext, f5, f4, f8 * 0.5f, nArray[0]);
                continue;
            }
            if (bl4) {
                uut.circle(drawContext, f5, f4, f8, ujt.withAlpha(iov.window, 255));
                uut.circleOutline(drawContext, f5, f4, f8, 0.8f, iov.stroke);
                uut.gradient(drawContext, f5 - f8 * 0.55f, f4 - f8 * 0.55f, f8 * 1.1f, f8 * 1.1f, f8 * 0.55f, nArray[0], nArray[1], nArray[1], nArray[0]);
                continue;
            }
            uut.gradient(drawContext, f5 - f8, f4 - f8, f8 * 2.0f, f8 * 2.0f, f8, nArray[0], nArray[1], nArray[1], nArray[0]);
        }
        if (n2 >= 0) {
            hlc2.hint(n2 == 0 ? wap.s(a.b("\u4cc4\u3541\ubf93\u21f9\uaa61\u2cd0\u9614\u1f72\u812d\u0bc8\u8c07\u767b\uf8e9\u610c\ueb43\u6dbf\ud7f8\u5821\uc2d0\u44d5\ucd71\ub76f\u39c4\ua20c\u243d\uaead\u171c\u994d\u03bc\u85e6\u0e4f", 552815770), a.b("\u32da\u4b49\uc1ea\u5fe7\ud02e\u569f\uec5b\u653d\ufb62\u75c3\uf21a\u0817\u86b3\u1f0a\u9526\u17b5\ua99b\u263b\ubc84\u3ad7\ub327\ucd6f\u47be\udc18\u5a6e\ud0c8", 13711056)) : wap.value(list.get(n2)));
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        List<String> list = iov.ACCENT.getModes();
        int n2 = list.size();
        float f3 = this.y + 11.0f;
        for (int i = 0; i < n2; ++i) {
            float f4 = this.hhz(i, n2);
            if (!irr.inside(f, f2, f4 - 6.0f - 2.0f, f3 - 6.0f - 2.0f, 16.0f, 16.0f)) continue;
            iov.ACCENT.set(list.get(i));
            return true;
        }
        return false;
    }

    private static /* synthetic */ int aao(int n, int n2) {
        return n * n2 | 0xE360843A;
    }

    private static /* synthetic */ int aap(int n, int n2) {
        return hhs.aao(n, n2) * n2;
    }
}

