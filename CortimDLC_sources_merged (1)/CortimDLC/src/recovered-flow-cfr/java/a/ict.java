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
import a.irk;
import a.irr;
import a.ujt;
import a.vcj;
import a.vmo;
import a.wap;
import flow.dev.a;
import net.minecraft.client.gui.DrawContext;

final class ict
extends imn {
    private static final float icu = 20.0f;
    private final String icv;
    private final irk icw;
    private final vcj icx = new vcj(14.0f);
    private static /* synthetic */ boolean icy;
    private static /* synthetic */ boolean icz;

    ict(String string, irk irk2) {
        this(null, string, irk2);
    }

    ict(vmo vmo2, String string, irk irk2) {
        super(vmo2);
        this.icv = string;
        this.icw = irk2;
    }

    @Override
    float height() {
        return 20.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        float f5 = this.icx.step(hlc2.binding() == this.icw, f3);
        float f6 = this.y + 10.0f;
        irr.LABEL.draw(drawContext, wap.t(this.icv), this.x, irr.LABEL.centerTop(f6), ujt.lerp(iov.textDim, iov.text, Math.max(f4, f5)));
        String string = f5 > 0.5f ? a.b("\ubfb9\uc608\u4cdb", 1344651156) : irr.keyName(this.icw.get());
        float f7 = f5 > 0.01f ? 0.55f + 0.45f * (float)Math.sin((double)System.nanoTime() / 1.6E8) : 0.0f;
        irr.drawChip(drawContext, string, this.x + this.w, f6, ujt.lerp(iov.text, iov.accent(), f5), ujt.lerp(iov.stroke, iov.accent((int)(120.0f + 110.0f * f7)), f5), f4);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (this.hovered(f, f2) && n == 0) {
            hlc2.startBinding(this.icw);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int afh(int n, int n2) {
        return n - n2 + 1491098794;
    }

    private static /* synthetic */ int afi(int n, int n2) {
        return ict.afh(n, n2) * n2;
    }

    private static /* synthetic */ int afj(int n, int n2) {
        return ict.afh(n, n2) + n;
    }
}

