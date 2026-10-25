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
import a.vmc;
import a.wap;
import net.minecraft.client.gui.DrawContext;

final class imu
extends imn {
    private static final float imv = 25.0f;
    private static final float imw = 17.5f;
    private static final float imx = 2.5f;
    private final vmc imy;
    private final vcj imz;
    private final vcj ina = new vcj(16.0f);
    private boolean inb;
    private static /* synthetic */ long inc;
    private static /* synthetic */ long ind;

    imu(vmc vmc2) {
        super(vmc2);
        this.imy = vmc2;
        this.imz = new vcj(18.0f, (float)vmc2.getFraction());
    }

    @Override
    float height() {
        return 25.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        if (this.inb && !hlc2.isDragging(this)) {
            this.inb = false;
        }
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.ina.step(this.inb, f3);
        float f6 = this.imz.step((float)this.imy.getFraction(), f3);
        float f7 = this.y + 7.5f;
        irr.LABEL.draw(drawContext, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(f7), ujt.lerp(iov.textDim, iov.text, Math.max(f4, f5)));
        irr.VALUE.drawRight(drawContext, this.imy.display(), this.x + this.w, irr.VALUE.centerTop(f7), ujt.lerp(iov.textDim, iov.text, Math.max(f5, f4 * 0.6f)));
        float f8 = this.y + 17.5f;
        float f9 = 2.5f + f4 * 0.4f + f5 * 0.4f;
        float f10 = f8 + 1.25f;
        uut.round(drawContext, this.x, f10 - f9 * 0.5f, this.w, f9, f9 * 0.5f, iov.track);
        float f11 = Math.max(f9, this.w * f6);
        uut.gradientH(drawContext, this.x, f10 - f9 * 0.5f, f11, f9, f9 * 0.5f, iov.accent(), iov.accent2());
        ukf.inset(drawContext, this.x, f10 - f9 * 0.5f, this.w, f9, f9 * 0.5f, iov.lightness());
        float f12 = this.x + this.w * f6;
        float f13 = 3.2f + f4 * 0.4f + f5 * 0.6f;
        uut.shadow(drawContext, f12 - f13, f10 - f13 + 0.8f + f5 * 0.6f, f13 * 2.0f, f13 * 2.0f, f13, 1.6f + f5 * 1.6f, ujt.withAlpha(0, Math.round(110.0f + 40.0f * f5)));
        uut.gradientV(drawContext, f12 - f13, f10 - f13, f13 * 2.0f, f13 * 2.0f, f13, -1, -2302750);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (!this.hovered(f, f2)) {
            return false;
        }
        if (n == 1) {
            this.imy.reset();
            return true;
        }
        if (n == 0) {
            this.inb = true;
            hlc2.startDrag(this);
            this.mouseDragged(f, f2);
            return true;
        }
        return false;
    }

    @Override
    void mouseDragged(float f, float f2) {
        this.imy.setFromFraction((f - this.x) / this.w);
    }

    private static /* synthetic */ int ahq(int n, int n2) {
        return n + n2 | 0x5D52A44D;
    }

    private static /* synthetic */ int ahr(int n, int n2) {
        return n * n2 + -1697928962;
    }

    private static /* synthetic */ int ahs(int n, int n2) {
        return n * n2 + -330352484;
    }
}

