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
import a.wap;
import java.util.function.Supplier;
import net.minecraft.client.gui.DrawContext;

final class iab
extends imn {
    private static final float iac = 18.0f;
    private final String iad;
    private final Supplier<String> iae;
    private static /* synthetic */ boolean iaf;
    private static /* synthetic */ int iag;

    iab(String string, Supplier<String> supplier) {
        super(null);
        this.iad = string;
        this.iae = supplier;
    }

    @Override
    float height() {
        return 18.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4 = this.y + 9.0f;
        String string = wap.t(this.iad);
        irr.LABEL.draw(drawContext, string, this.x, irr.LABEL.centerTop(f4), iov.textDim);
        String string2 = irr.SMALL.ellipsize(this.iae.get(), this.w - irr.LABEL.width(string) - 20.0f);
        irr.drawChip(drawContext, string2, this.x + this.w, f4, iov.text, iov.stroke, 0.0f);
    }

    private static /* synthetic */ int aeq(int n, int n2) {
        return n ^ n2 | 0x29F7EFA6;
    }

    private static /* synthetic */ int aer(int n, int n2) {
        return iab.aeq(n, n2) + n;
    }
}

