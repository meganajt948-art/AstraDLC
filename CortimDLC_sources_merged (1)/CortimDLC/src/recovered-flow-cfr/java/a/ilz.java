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
import a.ujt;
import a.uut;
import a.vmc;
import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

final class ilz
extends imn {
    private static final float ima = 67.0f;
    private static final float imb = 50.0f;
    private static final float imc = 9.0f;
    private static final float imd = 7.0f;
    private final vmc ime;
    private final vmc imf;
    private final vmc img;
    private int imh;
    private static /* synthetic */ int imi;
    private static /* synthetic */ long imj;

    ilz() {
        this(iov.HUE, iov.SATURATION, iov.BRIGHTNESS);
    }

    ilz(vmc vmc2, vmc vmc3, vmc vmc4) {
        super(null);
        this.ime = vmc2;
        this.imf = vmc3;
        this.img = vmc4;
    }

    @Override
    float height() {
        return 67.0f;
    }

    private float imk() {
        return this.y + 3.0f;
    }

    private float iml() {
        return this.w - 9.0f - 7.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        if (this.imh != 0 && !hlc2.isDragging(this)) {
            this.imh = 0;
        }
        float f4 = (float)this.ime.get();
        float f5 = (float)this.imf.get();
        float f6 = (float)this.img.get();
        float f7 = this.imk();
        float f8 = this.iml();
        float f9 = iov.r(4.0f);
        int n = ujt.hsv(f4, 1.0f, 1.0f);
        uut.gradient(drawContext, this.x, f7, f8, 50.0f, f9, -1, n, -16777216, -16777216);
        uut.outline(drawContext, this.x, f7, f8, 50.0f, f9, 1.0f, iov.stroke);
        float f10 = this.x + f5 * f8;
        float f11 = f7 + (1.0f - f6) * 50.0f;
        uut.shadow(drawContext, f10 - 3.5f, f11 - 3.5f, 7.0f, 7.0f, 3.5f, 2.0f, 0x60000000);
        uut.circle(drawContext, f10, f11, 3.5f, -1);
        uut.circle(drawContext, f10, f11, 2.3f, ujt.hsv(f4, f5, f6));
        float f12 = this.x + f8 + 7.0f;
        float f13 = 8.333333f;
        float f14 = 4.5f;
        uut.gradientV(drawContext, f12, f7, 9.0f, f13 + f14, f14, ujt.hsv(0.0f, 1.0f, 1.0f), ujt.hsv((f13 + f14) / 50.0f, 1.0f, 1.0f));
        uut.gradientV(drawContext, f12, f7 + 50.0f - f13 - f14, 9.0f, f13 + f14, f14, ujt.hsv((50.0f - f13 - f14) / 50.0f, 1.0f, 1.0f), ujt.hsv(1.0f, 1.0f, 1.0f));
        for (int i = 1; i < 5; ++i) {
            uut.gradientV(drawContext, f12, f7 + f13 * (float)i, 9.0f, f13, 0.0f, ujt.hsv((float)i / 6.0f, 1.0f, 1.0f), ujt.hsv((float)(i + 1) / 6.0f, 1.0f, 1.0f));
        }
        float f15 = f7 + f4 * 50.0f;
        uut.shadow(drawContext, f12 - 1.5f, f15 - 2.0f, 12.0f, 4.0f, 2.0f, 2.0f, 0x60000000);
        uut.outline(drawContext, f12 - 1.5f, f15 - 2.0f, 12.0f, 4.0f, 2.0f, 1.3f, -1);
        int n2 = ujt.hsv(f4, f5, f6);
        String string = String.format(Locale.ROOT, a.d("\u91f9\ue84e\u6288\ufcff\u7746", -385770431, 593956254), n2 & 0xFFFFFF);
        float f16 = f7 + 50.0f + 9.0f;
        uut.circle(drawContext, this.x + 4.0f, f16, 3.5f, n2);
        irr.VALUE.draw(drawContext, string, this.x + 11.0f, irr.VALUE.centerTop(f16), iov.textDim);
        irr.SMALL.drawRight(drawContext, Math.round(f4 * 360.0f) + a.d("\u7b2b\u020a\u88d9", -260310854, 1868530466) + Math.round(f5 * 100.0f) + a.d("\ud69a\uaf2e\u25fd", -378538918, 523510502) + Math.round(f6 * 100.0f) + a.b("\u1bbf", -1469506661), this.x + this.w, irr.SMALL.centerTop(f16), iov.textMuted);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float f3 = this.imk();
        if (irr.inside(f, f2, this.x - 2.0f, f3 - 2.0f, this.iml() + 4.0f, 54.0f)) {
            this.imh = 1;
        } else if (irr.inside(f, f2, this.x + this.iml() + 7.0f - 3.0f, f3 - 3.0f, 15.0f, 56.0f)) {
            this.imh = 2;
        } else {
            return false;
        }
        hlc2.startDrag(this);
        this.mouseDragged(f, f2);
        return true;
    }

    @Override
    void mouseDragged(float f, float f2) {
        float f3 = this.imk();
        if (this.imh == 1) {
            this.imf.set(ilz.imm((f - this.x) / this.iml()));
            this.img.set(1.0f - ilz.imm((f2 - f3) / 50.0f));
        } else if (this.imh == 2) {
            this.ime.set(Math.min(0.999f, ilz.imm((f2 - f3) / 50.0f)));
        }
    }

    private static float imm(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private static /* synthetic */ int ahi(int n, int n2) {
        return n * n2 ^ 0xF861DF74;
    }
}

