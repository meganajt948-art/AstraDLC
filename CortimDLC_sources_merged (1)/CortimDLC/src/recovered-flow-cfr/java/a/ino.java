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
import a.vcj;
import a.vkl;
import a.wap;
import net.minecraft.client.gui.DrawContext;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class ino
extends imn {
    private static final float inp = 20.0f;
    private final vkl inq;
    private final vcj inr;
    private static /* synthetic */ String ins;
    private static /* synthetic */ boolean int;

    ino(vkl vkl2) {
        super(vkl2);
        this.inq = vkl2;
        this.inr = new vcj(14.0f, vkl2.get() ? 1.0f : 0.0f);
    }

    @Override
    float height() {
        return 20.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.inr.step(this.inq.get(), f3);
        float f6 = this.y + 10.0f;
        irr.LABEL.draw(drawContext, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(f6), ujt.lerp(iov.textDim, iov.text, Math.max(f5 * 0.75f, f4)));
        irr.drawSwitch(drawContext, this.x + this.w - 17.0f, f6 - 4.75f, f5, f4);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n == 0 && this.hovered(f, f2)) {
            this.inq.toggle();
            return true;
        }
        return false;
    }

    private static /* synthetic */ int aia(int n, int n2) {
        return n ^ n2 ^ 0xD13BAB2E;
    }

    private static /* synthetic */ int aib(int n, int n2) {
        return ino.aia(n, n2) * n2;
    }

    private static /* synthetic */ int aic(int n, int n2) {
        return n ^ n2 ^ 0xE4CD7A62;
    }
}

