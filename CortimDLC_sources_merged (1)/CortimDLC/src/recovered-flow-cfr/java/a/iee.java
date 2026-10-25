/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.item.ItemStack
 */
package a;

import a.hlc;
import a.ibf;
import a.imn;
import a.iov;
import a.irr;
import a.ujt;
import a.vcj;
import a.vhz;
import a.vlj;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

final class iee
extends imn {
    private static final float ief = 26.0f;
    private static final float ieg = 66.0f;
    private static final float ieh = 17.0f;
    private static final int iei = 5;
    private final vlj iej;
    private final vcj iek = new vcj(16.0f);
    private final vcj iel = new vcj(10.0f);
    private int iem = -1;
    private final List<ItemStack> ien = new ArrayList<ItemStack>();
    private static /* synthetic */ String ieo;
    private static /* synthetic */ int iep;

    iee(vlj vlj2) {
        super(vlj2);
        this.iej = vlj2;
    }

    @Override
    float height() {
        return 26.0f;
    }

    private void ieq() {
        if (this.iem == this.iej.version()) {
            return;
        }
        this.iem = this.iej.version();
        this.ien.clear();
        for (String string : this.iej.ids()) {
            ItemStack itemStack = ibf.iconOf(this.iej.kind(), string);
            if (itemStack.method_7960()) continue;
            this.ien.add(itemStack);
            if (this.ien.size() < 5) continue;
            break;
        }
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        float f4;
        this.ieq();
        float f5 = this.y + 13.0f;
        float f6 = this.hover.step(this.hovered(f, f2) && hlc2.canHover(), f3);
        irr.LABEL.draw(drawContext, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(f5), ujt.lerp(iov.textDim, iov.text, f6));
        float f7 = this.x + this.w - 66.0f;
        float f8 = f5 - 8.5f;
        float f9 = this.iek.step(hlc2.canHover() && irr.inside(f, f2, f7, f8, 66.0f, 17.0f), f3);
        irr.secondaryButton(drawContext, wap.s(a.c(-2011918299, "\u9060\ue9fa\u632e\ufd5f\u7694\uf033"), a.d("\u52f6\u2b1e\ua1b7\u3fb7\ub410\u32d3\u888e", -204610555, 125154022)), vhz.SEARCH, f7, f8, 66.0f, 17.0f, f9, this.iel.step(0.0f, f3));
        float f10 = f7 - 6.0f;
        int n = this.iej.size();
        if (n > this.ien.size()) {
            var13_13 = a.c(420731926, "\udc3c") + (n - this.ien.size());
            f10 = irr.drawChip(drawContext, var13_13, f10, f5, iov.textDim, iov.stroke, f6) - 4.0f;
        } else if (n == 0) {
            var13_13 = wap.s(a.d("\u7b89\u0239\u88eb\u1691", -1210004797, -873549536), a.b("\u707b\u09b6\u8367\u1d15\u96be", -1063619519));
            irr.SMALL.draw(drawContext, var13_13, f10 - irr.SMALL.width(var13_13), irr.SMALL.centerTop(f5), iov.textMuted);
        }
        float f11 = this.x + irr.LABEL.width(wap.t(this.setting.getName())) + 6.0f;
        for (int i = this.ien.size() - 1; i >= 0 && !((f4 = f10 - 14.0f) < f11); --i) {
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate(f4, f5 - 6.5f);
            drawContext.method_51448().scale(0.8125f, 0.8125f);
            drawContext.method_51427(this.ien.get(i), 0, 0);
            drawContext.method_51448().popMatrix();
            f10 = f4 - 1.5f;
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n == 0 && this.hovered(f, f2)) {
            this.iel.set(1.0f);
            hlc2.openPicker(this.iej);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int afq(int n, int n2) {
        return n * n2 ^ 0xC05D9C0A;
    }

    private static /* synthetic */ int afr(int n, int n2) {
        return iee.afq(n, n2) * n2;
    }

    private static /* synthetic */ int afs(int n, int n2) {
        return iee.afq(n, n2) * n2;
    }
}

