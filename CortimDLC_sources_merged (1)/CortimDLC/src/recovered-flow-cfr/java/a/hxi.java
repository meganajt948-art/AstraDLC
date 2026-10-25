/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hyv;
import a.iov;
import a.irr;
import a.ujt;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.vlv;
import a.wap;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class hxi {
    private static final float hxj = 15.0f;
    private static final float hxk = 3.0f;
    final vlv mode;
    private final float hxl;
    private final float hxm;
    private final float hxn;
    private final boolean hxo;
    private final vcj hxp = new vcj(18.0f);
    private final List<vcj> hxq = new ArrayList<vcj>();
    private boolean hxr;
    private static /* synthetic */ long hxs;
    private static /* synthetic */ String hxt;

    hxi(vlv vlv2, float f, float f2, float f3, float f4, float f5) {
        this.mode = vlv2;
        this.hxl = f;
        this.hxm = f3;
        float f6 = this.hxu();
        this.hxo = f2 + f6 > f5 && f4 - 3.0f - f6 > 0.0f;
        this.hxn = this.hxo ? f4 - 3.0f - f6 : f2;
        for (int i = 0; i < vlv2.getModes().size(); ++i) {
            this.hxq.add(new vcj(18.0f));
        }
    }

    private float hxu() {
        return (float)this.mode.getModes().size() * 15.0f + 6.0f;
    }

    void close() {
        this.hxr = true;
    }

    boolean closing() {
        return this.hxr;
    }

    boolean gone() {
        return this.hxr && this.hxp.get() <= 0.01f;
    }

    void render(DrawContext drawContext, float f, float f2, float f3) {
        float f4 = vcq.outCubic(this.hxp.step(this.hxr ? 0.0f : 1.0f, f3));
        if (f4 <= 0.01f) {
            return;
        }
        float f5 = this.hxu();
        float f6 = f5 * (0.35f + 0.65f * f4);
        float f7 = this.hxo ? this.hxn + f5 - f6 : this.hxn;
        float f8 = iov.r(6.0f);
        uut.pushAlpha(f4);
        uut.shadow(drawContext, this.hxl, f7 + 2.0f, this.hxm, f6, f8, 12.0f, iov.shadow);
        int n = ujt.withAlpha(iov.cardHover, 250);
        hyv.surface(drawContext, this.hxl, f7, this.hxm, f6, f8, hyv.tint(iov.window, Math.min(1.0f, iov.windowTint() + 0.08f)), n, 6.0f, hyv.POPUPS);
        uut.outline(drawContext, this.hxl, f7, this.hxm, f6, f8, 1.0f, iov.stroke);
        uut.pushScissor(drawContext, this.hxl, f7, this.hxm, f6);
        List<String> list = this.mode.getModes();
        while (this.hxq.size() < list.size()) {
            this.hxq.add(new vcj(18.0f));
        }
        for (int i = 0; i < list.size(); ++i) {
            float f9 = this.hxn + 3.0f + (float)i * 15.0f;
            boolean bl = this.mode.get().equals(list.get(i));
            float f10 = this.hxq.get(i).step(!this.hxr && irr.inside(f, f2, this.hxl, f9, this.hxm, 15.0f), f3);
            if (f10 > 0.01f) {
                uut.round(drawContext, this.hxl + 3.0f, f9 + 1.0f, this.hxm - 6.0f, 13.0f, iov.r(3.5f), ujt.withAlpha(iov.hover, Math.round((float)ujt.alpha(iov.hover) * 2.0f * f10)));
            }
            int n2 = bl ? iov.accent() : ujt.lerp(iov.textDim, iov.text, f10);
            irr.VALUE.draw(drawContext, irr.VALUE.ellipsize(wap.value(list.get(i)), this.hxm - 24.0f), this.hxl + 8.0f, irr.VALUE.centerTop(f9 + 7.5f), n2);
            if (!bl) continue;
            vjf.draw(drawContext, vhz.CHECK, this.hxl + this.hxm - 9.0f, f9 + 7.5f, 7.0f, iov.accent());
        }
        uut.popScissor(drawContext);
        uut.popAlpha();
    }

    boolean mouseClicked(float f, float f2) {
        if (this.hxr || !irr.inside(f, f2, this.hxl, this.hxn, this.hxm, this.hxu())) {
            return false;
        }
        int n = (int)((f2 - this.hxn - 3.0f) / 15.0f);
        List<String> list = this.mode.getModes();
        if (n >= 0 && n < list.size()) {
            this.mode.set(list.get(n));
        }
        this.close();
        return true;
    }

    private static /* synthetic */ int adh(int n, int n2) {
        return n + n2 ^ 0xB46952AD;
    }

    private static /* synthetic */ int adi(int n, int n2) {
        return hxi.adh(n, n2) * n2;
    }
}

