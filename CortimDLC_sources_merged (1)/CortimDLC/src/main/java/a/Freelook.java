/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_5498
 *  net.minecraft.class_746
 */
package a;

import a.CameraOffset;
import a.ModuleCategory;
import a.Module;
import a.FreeCam;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.KeyUtil;
import net.minecraft.class_310;
import net.minecraft.class_5498;
import net.minecraft.class_746;

public class Freelook
extends Module {
    private final KeySetting rdt = this.add(new KeySetting("Key", 342));
    private final ModeSetting rdu = this.add(new ModeSetting("Press", "Hold", "Hold", "Toggle"));
    private final ModeSetting rdv = this.add(new ModeSetting("View", "Back", "Back", "Front", "First person"));
    private final NumberSetting rdw = this.add(new NumberSetting("Distance", 4.0, 1.0, 12.0, 0.5).suffix("blocks"));
    private final NumberSetting rdx = this.add(new NumberSetting("Sensitivity", 1.0, 0.2, 2.0, 0.05).unit("x"));
    private boolean rdy;
    private boolean rdz;
    private float rea;
    private float reb;
    private float rec;
    private float red;
    private float ree;
    private float ref;
    private class_5498 reg;
    private class_5498 reh;
    private static /* synthetic */ String rei;
    private static /* synthetic */ int rej;

    public Freelook() {
        super(new String(new char[]{'F', 'r', 'e', 'e', 'L', 'o', 'o', 'k'}), "Look around without turning your player", ModuleCategory.RENDER);
        this.rdw.visibleWhen(() -> !this.rdv.is("First person"));
    }

    @Override
    protected void onDisable() {
        this.rdz = false;
        this.ren(class_310.method_1551());
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (n == this.rdt.get() && this.rdu.is("Toggle")) {
            this.rdz = !this.rdz;
        }
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        boolean bl;
        if (!this.rdu.is("Toggle")) {
            this.rdz = false;
        }
        boolean bl2 = class_3102.field_1755 == null && !FreeCam.active() && class_3102.field_1724 != null && (this.rdu.is("Toggle") ? this.rdz : KeyUtil.isDown(class_3102, this.rdt.get())) ? true : (bl = false);
        if (bl && !this.rdy) {
            this.rem(class_3102);
        } else if (!bl && this.rdy) {
            this.ren(class_3102);
        }
        if (this.rdy) {
            class_5498 class_54982 = this.rel();
            if (class_54982 != this.reh) {
                this.reh = class_54982;
                class_3102.field_1690.method_31043(class_54982);
            }
            CameraOffset.distance(this.rdv.is("First person") ? 0.0f : (float)this.rdw.get());
            this.rek(class_3102.field_1724);
        }
    }

    private void rek(class_746 class_7462) {
        double d = this.rdx.get();
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        if (d != 1.0) {
            f = this.ree + (float)((double)(f - this.ree) * d);
            f2 = Math.max(-90.0f, Math.min(90.0f, this.ref + (float)((double)(f2 - this.ref) * d)));
            class_7462.method_36456(f);
            class_7462.method_36457(f2);
        }
        this.ree = f;
        this.ref = f2;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (!this.rdy) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        this.rec = class_7462.method_36454();
        this.red = class_7462.method_36455();
        class_7462.method_36456(this.rea);
        class_7462.method_36457(this.reb);
        class_7462.field_5982 = this.rea;
        class_7462.field_6004 = this.reb;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (!this.rdy) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        this.rea = class_7462.method_36454();
        this.reb = class_7462.method_36455();
        class_7462.method_36456(this.rec);
        class_7462.method_36457(this.red);
        class_7462.field_5982 = this.rec;
        class_7462.field_6004 = this.red;
        this.ree = this.rec;
        this.ref = this.red;
    }

    private class_5498 rel() {
        return switch (this.rdv.get()) {
            case "Front" -> class_5498.field_26666;
            case "First person" -> class_5498.field_26664;
            default -> class_5498.field_26665;
        };
    }

    private void rem(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        this.rdy = true;
        this.rea = class_7462.method_36454();
        this.reb = class_7462.method_36455();
        this.rec = this.rea;
        this.red = this.reb;
        this.ree = this.rea;
        this.ref = this.reb;
        this.reg = class_3102.field_1690.method_31044();
        this.reh = this.rel();
        class_3102.field_1690.method_31043(this.reh);
    }

    private void ren(class_310 class_3102) {
        if (!this.rdy) {
            return;
        }
        this.rdy = false;
        CameraOffset.distance(0.0f);
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 != null) {
            class_7462.method_36456(this.rea);
            class_7462.method_36457(this.reb);
            class_7462.field_5982 = this.rea;
            class_7462.field_6004 = this.reb;
        }
        if (this.reg != null) {
            class_3102.field_1690.method_31043(this.reg);
            this.reg = null;
        }
        this.reh = null;
    }

    private static /* synthetic */ int bxp(int n, int n2) {
        return n * n2 ^ 0x8971386D;
    }

    private static /* synthetic */ int bxq(int n, int n2) {
        return Freelook.bxp(n, n2) * n2;
    }
}

