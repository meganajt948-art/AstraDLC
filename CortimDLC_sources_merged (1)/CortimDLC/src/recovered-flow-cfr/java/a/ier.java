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
import a.ukf;
import a.uut;
import a.vcj;
import a.vhz;
import a.vjf;
import a.vlv;
import a.wap;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class ier
extends imn {
    private static final float ies = 21.0f;
    private static final float iet = 14.0f;
    private static final float ieu = 11.0f;
    private final vlv iev;
    private final vcj iew = new vcj(16.0f);
    private final vcj iex = new vcj(18.0f, -1.0f);
    private final vcj iey = new vcj(18.0f, -1.0f);
    private boolean iez;
    private float ifa;
    private float ifb;
    private float ifc;
    private static /* synthetic */ long ifd;
    private static /* synthetic */ boolean ife;

    ier(vlv vlv2) {
        super(vlv2);
        this.iev = vlv2;
    }

    @Override
    float height() {
        return 21.0f;
    }

    private float iff(String string) {
        return irr.VALUE.width(wap.value(string)) + 11.0f;
    }

    private void ifg() {
        List<String> list = this.iev.getModes();
        float f = 3.0f;
        for (String string : list) {
            f += this.iff(string);
        }
        float f2 = this.w - irr.LABEL.width(wap.t(this.setting.getName())) - 10.0f;
        boolean bl = this.iez = list.size() <= 3 && f <= f2;
        if (this.iez) {
            this.ifc = f;
        } else {
            float f3 = 0.0f;
            for (String string : list) {
                f3 = Math.max(f3, irr.VALUE.width(wap.value(string)));
            }
            this.ifc = Math.min(this.w * 0.6f, Math.max(60.0f, f3 + 24.0f));
        }
        this.ifa = this.x + this.w - this.ifc;
        this.ifb = this.y + 3.5f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        this.ifg();
        boolean bl = irr.inside(f, f2, this.ifa, this.ifb, this.ifc, 14.0f) && hlc2.canHover();
        float f4 = this.hover.step(bl, f3);
        float f5 = this.iew.step(hlc2.isDropdownFor(this.iev), f3);
        irr.LABEL.draw(drawContext, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(this.y + 10.5f), ujt.lerp(iov.textDim, iov.text, Math.max(f4, f5)));
        float f6 = iov.r(4.0f);
        uut.round(drawContext, this.ifa, this.ifb, this.ifc, 14.0f, f6, ujt.lerp(iov.field, iov.fieldHover, f4));
        uut.outline(drawContext, this.ifa, this.ifb, this.ifc, 14.0f, f6, 1.0f, ujt.lerp(iov.stroke, iov.accent(150), f5));
        ukf.inset(drawContext, this.ifa, this.ifb, this.ifc, 14.0f, f6, iov.lightness());
        if (this.iez) {
            this.ifh(drawContext, f, f2, f3);
        } else {
            this.ifi(drawContext, f4, f5);
        }
    }

    private void ifh(DrawContext drawContext, float f, float f2, float f3) {
        float f4;
        float f5;
        List<String> list = this.iev.getModes();
        float f6 = f5 = this.ifa + 1.5f;
        float f7 = this.iff(list.get(0));
        for (String string : list) {
            f4 = this.iff(string);
            if (string.equals(this.iev.get())) {
                f6 = f5;
                f7 = f4;
            }
            f5 += f4;
        }
        if (this.iex.get() < 0.0f) {
            this.iex.set(f6 - this.ifa);
            this.iey.set(f7);
        }
        float f8 = this.ifa + this.iex.step(f6 - this.ifa, f3);
        float f9 = this.iey.step(f7, f3);
        f4 = iov.r(3.2f);
        float f10 = iov.lightness();
        float f11 = this.ifb + 1.5f;
        float f12 = 11.0f;
        uut.shadow(drawContext, f8, f11 + 0.6f, f9, f12, f4, 1.4f, ujt.withAlpha(0, Math.round(110.0f - 70.0f * f10)));
        uut.round(drawContext, f8, f11, f9, f12, f4, ujt.lerp(iov.cardHover, -1, 0.1f + 0.9f * f10));
        ukf.sheen(drawContext, f8, f11, f9, f12, f4, 1.4f * (1.0f - 0.7f * f10));
        ukf.rim(drawContext, f8, f11, f9, f12, f4, f10, 1.1f);
        f5 = this.ifa + 1.5f;
        float f13 = this.ifb + 7.0f;
        for (String string : list) {
            float f14 = this.iff(string);
            float f15 = Math.max(0.0f, Math.min(f8 + f9, f5 + f14) - Math.max(f8, f5)) / f14;
            boolean bl = irr.inside(f, f2, f5, this.ifb, f14, 14.0f);
            int n = bl ? iov.textDim : iov.textMuted;
            irr.VALUE.drawCentered(drawContext, wap.value(string), f5 + f14 * 0.5f, irr.VALUE.centerTop(f13), ujt.lerp(n, iov.text, f15));
            f5 += f14;
        }
    }

    private void ifi(DrawContext drawContext, float f, float f2) {
        String string = irr.VALUE.ellipsize(wap.value(this.iev.get()), this.ifc - 22.0f);
        float f3 = this.ifb + 7.0f;
        irr.VALUE.draw(drawContext, string, this.ifa + 7.0f, irr.VALUE.centerTop(f3), ujt.lerp(iov.textDim, iov.text, 0.6f + f * 0.4f));
        float f4 = this.ifa + this.ifc - 8.5f;
        int n = ujt.lerp(iov.textMuted, iov.accent(), Math.max(f2, f * 0.5f));
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f4, f3);
        drawContext.method_51448().rotate((float)Math.PI * f2);
        vjf.draw(drawContext, vhz.CHEVRON_DOWN, 0.0f, 0.0f, 7.0f, n);
        drawContext.method_51448().popMatrix();
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (n == 1) {
            this.iev.cyclePrev();
            return true;
        }
        if (n != 0) {
            return false;
        }
        if (this.iez) {
            float f3 = this.ifa + 1.5f;
            for (String string : this.iev.getModes()) {
                float f4 = this.iff(string);
                if (f >= f3 && f < f3 + f4) {
                    this.iev.set(string);
                    return true;
                }
                f3 += f4;
            }
            this.iev.cycle();
        } else {
            hlc2.openDropdown(this.iev, this.ifa, this.ifb + 14.0f + 3.0f, this.ifc, this.ifb);
        }
        return true;
    }

    private static /* synthetic */ int afv(int n, int n2) {
        return n + n2 + 896384156;
    }

    private static /* synthetic */ int afw(int n, int n2) {
        return n + n2 | 0x25E75D15;
    }

    private static /* synthetic */ int afx(int n, int n2) {
        return n * n2 ^ 0x9357D9E2;
    }
}

