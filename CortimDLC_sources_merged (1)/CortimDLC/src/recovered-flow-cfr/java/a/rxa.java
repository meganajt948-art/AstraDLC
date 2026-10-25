/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.util.Arm
 *  net.minecraft.util.math.RotationAxis
 *  org.joml.Quaternionfc
 */
package a;

import a.kfa;
import a.kfe;
import a.vgj;
import a.vht;
import a.vhu;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vmc;
import a.vmo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionfc;

public class rxa
extends kfe
implements vht {
    private final vmc rxb = this.add(new vmc("X", 0.0, -1.0, 1.0, 0.01));
    private final vmc rxc = this.add(new vmc("Y", 0.0, -1.0, 1.0, 0.01));
    private final vmc rxd = this.add(new vmc("Z", 0.0, -1.0, 1.0, 0.01));
    private final vmc rxe = this.add(new vmc("Size", 1.0, 0.3, 2.0, 0.01).unit("x"));
    private final vmc rxf = this.add(new vmc("Turn X", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final vmc rxg = this.add(new vmc("Turn Y", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final vmc rxh = this.add(new vmc("Turn Z", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final vkl rxi = this.add(new vkl("Left mirrors right", true));
    private final vmc rxj = this.add(new vmc("Left X", 0.0, -1.0, 1.0, 0.01));
    private final vmc rxk = this.add(new vmc("Left Y", 0.0, -1.0, 1.0, 0.01));
    private final vmc rxl = this.add(new vmc("Left Z", 0.0, -1.0, 1.0, 0.01));
    private final vmc rxm = this.add(new vmc("Left size", 1.0, 0.3, 2.0, 0.01).unit("x"));
    private final vmc rxn = this.add(new vmc("Left turn X", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final vmc rxo = this.add(new vmc("Left turn Y", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final vmc rxp = this.add(new vmc("Left turn Z", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final vkl rxq = this.add(new vkl("Mace charge", true));
    private final vkw rxr = this.add(new vkw("Reset", new vkq("Reset", vhz.RESET, this::rxu)));
    private static /* synthetic */ boolean rxs;
    private static /* synthetic */ int rxt;

    public rxa() {
        super(new String(new char[]{'V', 'i', 'e', 'w', 'M', 'o', 'd', 'e', 'l'}), "Move, turn and resize your hands", kfa.RENDER);
        vhu.register(this);
        for (vmo vmo2 : new vmo[]{this.rxj, this.rxk, this.rxl, this.rxm, this.rxn, this.rxo, this.rxp}) {
            vmo2.visibleWhen(() -> !this.rxi.get());
        }
    }

    private void rxu() {
        for (vmo vmo2 : this.getSettings()) {
            if (!(vmo2 instanceof vmc)) continue;
            vmc vmc2 = (vmc)vmo2;
            vmc2.reset();
        }
        this.rxi.reset();
    }

    public boolean maceCharge() {
        return this.isEnabled() && this.rxq.get();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        vgj.ensureInstalled(minecraftClient);
    }

    @Override
    public boolean active() {
        return this.isEnabled();
    }

    @Override
    public void apply(MatrixStack matrixStack, Arm arm) {
        boolean bl = arm == Arm.RIGHT;
        boolean bl2 = !bl && !this.rxi.get();
        float f = bl ? 1.0f : -1.0f;
        float f2 = (float)(bl2 ? this.rxj.get() : this.rxb.get());
        float f3 = (float)(bl2 ? this.rxk.get() : this.rxc.get());
        float f4 = (float)(bl2 ? this.rxl.get() : this.rxd.get());
        float f5 = (float)(bl2 ? this.rxm.get() : this.rxe.get());
        float f6 = (float)(bl2 ? this.rxn.get() : this.rxf.get());
        float f7 = (float)(bl2 ? this.rxo.get() : this.rxg.get());
        float f8 = (float)(bl2 ? this.rxp.get() : this.rxh.get());
        if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f && f5 == 1.0f && f6 == 0.0f && f7 == 0.0f && f8 == 0.0f) {
            return;
        }
        matrixStack.translate(f2 * f, f3, f4);
        matrixStack.translate(0.56f * f, -0.52f, -0.72f);
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f7 * f));
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f6));
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees(f8 * f));
        matrixStack.scale(f5, f5, f5);
        matrixStack.translate(-0.56f * f, 0.52f, 0.72f);
    }

    private static /* synthetic */ int cch(int n, int n2) {
        return n + n2 + -1398206908;
    }
}

