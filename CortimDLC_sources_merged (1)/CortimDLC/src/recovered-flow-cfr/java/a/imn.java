/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hiv;
import a.hlc;
import a.ict;
import a.iee;
import a.ier;
import a.imu;
import a.ine;
import a.ino;
import a.inu;
import a.irk;
import a.irr;
import a.vcj;
import a.vkl;
import a.vkw;
import a.vla;
import a.vlj;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vmu;
import java.util.function.BooleanSupplier;
import net.minecraft.client.gui.DrawContext;

abstract class imn {
    final vmo setting;
    final vcj hover = new vcj(16.0f);
    private final vcj imo = new vcj(14.0f, 1.0f);
    private final vcj imp = new vcj(12.0f, 1.0f);
    private BooleanSupplier imq = () -> true;
    private BooleanSupplier imr = () -> true;
    float x;
    float y;
    float w;
    private static /* synthetic */ String ims;
    private static /* synthetic */ long imt;

    imn(vmo vmo2) {
        this.setting = vmo2;
    }

    static imn of(vmo vmo2) {
        imn imn2;
        if (vmo2 instanceof vkl) {
            vkl vkl2 = (vkl)vmo2;
            imn2 = new ino(vkl2);
        } else if (vmo2 instanceof vmc) {
            vmc vmc2 = (vmc)vmo2;
            imn2 = new imu(vmc2);
        } else if (vmo2 instanceof vla) {
            vla vla2 = (vla)vmo2;
            imn2 = new ine(vla2);
        } else if (vmo2 instanceof vlv) {
            vlv vlv2 = (vlv)vmo2;
            imn2 = new ier(vlv2);
        } else if (vmo2 instanceof vlq) {
            vlq vlq2 = (vlq)vmo2;
            imn2 = new ict(vlq2, vlq2.getName(), new irk(vlq2.getName(), vlq2::get, vlq2::set, true));
        } else if (vmo2 instanceof vmu) {
            vmu vmu2 = (vmu)vmo2;
            imn2 = new inu(vmu2);
        } else if (vmo2 instanceof vkw) {
            vkw vkw2 = (vkw)vmo2;
            imn2 = new hiv(vkw2);
        } else if (vmo2 instanceof vlj) {
            vlj vlj2 = (vlj)vmo2;
            imn2 = new iee(vlj2);
        } else {
            return null;
        }
        if (vmo2.activeCondition() != null) {
            imn2.activeWhen(vmo2.activeCondition());
        }
        if (vmo2.visibleCondition() != null) {
            imn2.visibleWhen(vmo2.visibleCondition());
        }
        return imn2;
    }

    imn visibleWhen(BooleanSupplier booleanSupplier) {
        this.imq = booleanSupplier;
        this.imo.set(booleanSupplier.getAsBoolean() ? 1.0f : 0.0f);
        return this;
    }

    imn activeWhen(BooleanSupplier booleanSupplier) {
        this.imr = booleanSupplier;
        this.imp.set(booleanSupplier.getAsBoolean() ? 1.0f : 0.0f);
        return this;
    }

    abstract float height();

    final float currentHeight() {
        return this.height() * this.imo.get();
    }

    final float targetHeight() {
        return this.imq.getAsBoolean() ? this.height() : 0.0f;
    }

    final void animate(float f) {
        this.imo.step(this.imq.getAsBoolean(), f);
        this.imp.step(this.imr.getAsBoolean(), f);
    }

    final float opacity() {
        return Math.min(1.0f, this.imo.get() * 1.3f) * (0.38f + 0.62f * this.imp.get());
    }

    final boolean interactive() {
        return this.imo.get() > 0.6f && this.imq.getAsBoolean();
    }

    abstract void render(DrawContext var1, hlc var2, float var3, float var4, float var5);

    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        return false;
    }

    void mouseDragged(float f, float f2) {
    }

    boolean hovered(float f, float f2) {
        return irr.inside(f, f2, this.x, this.y, this.w, this.height());
    }

    private static /* synthetic */ int ahl(int n, int n2) {
        return n + n2 ^ 0x9DE40D1;
    }

    private static /* synthetic */ int ahm(int n, int n2) {
        return imn.ahl(n, n2) + n;
    }

    private static /* synthetic */ int ahn(int n, int n2) {
        return imn.ahl(n, n2) ^ 0x38E27A;
    }
}

