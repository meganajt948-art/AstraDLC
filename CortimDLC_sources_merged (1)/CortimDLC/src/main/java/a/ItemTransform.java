/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1306
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_7833
 *  org.joml.Quaternionfc
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.HandRendererHook;
import a.vht;
import a.HandHooks;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.NumberSetting;
import a.Setting;
import net.minecraft.class_1306;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_7833;
import org.joml.Quaternionfc;

public class ItemTransform
extends Module
implements vht {
    private final NumberSetting rxb = this.add(new NumberSetting("X", 0.0, -1.0, 1.0, 0.01));
    private final NumberSetting rxc = this.add(new NumberSetting("Y", 0.0, -1.0, 1.0, 0.01));
    private final NumberSetting rxd = this.add(new NumberSetting("Z", 0.0, -1.0, 1.0, 0.01));
    private final NumberSetting rxe = this.add(new NumberSetting("Size", 1.0, 0.3, 2.0, 0.01).unit("x"));
    private final NumberSetting rxf = this.add(new NumberSetting("Turn X", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final NumberSetting rxg = this.add(new NumberSetting("Turn Y", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final NumberSetting rxh = this.add(new NumberSetting("Turn Z", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final BoolSetting rxi = this.add(new BoolSetting("Left mirrors right", true));
    private final NumberSetting rxj = this.add(new NumberSetting("Left X", 0.0, -1.0, 1.0, 0.01));
    private final NumberSetting rxk = this.add(new NumberSetting("Left Y", 0.0, -1.0, 1.0, 0.01));
    private final NumberSetting rxl = this.add(new NumberSetting("Left Z", 0.0, -1.0, 1.0, 0.01));
    private final NumberSetting rxm = this.add(new NumberSetting("Left size", 1.0, 0.3, 2.0, 0.01).unit("x"));
    private final NumberSetting rxn = this.add(new NumberSetting("Left turn X", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final NumberSetting rxo = this.add(new NumberSetting("Left turn Y", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final NumberSetting rxp = this.add(new NumberSetting("Left turn Z", 0.0, -180.0, 180.0, 1.0).unit("\u00b0"));
    private final BoolSetting rxq = this.add(new BoolSetting("Mace charge", true));
    private final ButtonSetting rxr = this.add(new ButtonSetting("Reset", new vkq("Reset", Icon.RESET, this::rxu)));
    private static /* synthetic */ boolean rxs;
    private static /* synthetic */ int rxt;

    public ItemTransform() {
        super(new String(new char[]{'V', 'i', 'e', 'w', 'M', 'o', 'd', 'e', 'l'}), "Move, turn and resize your hands", ModuleCategory.RENDER);
        HandHooks.register(this);
        for (Setting vmo2 : new Setting[]{this.rxj, this.rxk, this.rxl, this.rxm, this.rxn, this.rxo, this.rxp}) {
            vmo2.visibleWhen(() -> !this.rxi.get());
        }
    }

    private void rxu() {
        for (Setting vmo2 : this.getSettings()) {
            if (!(vmo2 instanceof NumberSetting)) continue;
            NumberSetting vmc2 = (NumberSetting)vmo2;
            vmc2.reset();
        }
        this.rxi.reset();
    }

    public boolean maceCharge() {
        return this.isEnabled() && this.rxq.get();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        HandRendererHook.ensureInstalled(class_3102);
    }

    @Override
    public boolean active() {
        return this.isEnabled();
    }

    @Override
    public void apply(class_4587 class_45872, class_1306 class_13062) {
        boolean bl = class_13062 == class_1306.field_6183;
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
        class_45872.method_46416(f2 * f, f3, f4);
        class_45872.method_46416(0.56f * f, -0.52f, -0.72f);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f7 * f));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f6));
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f8 * f));
        class_45872.method_22905(f5, f5, f5);
        class_45872.method_46416(-0.56f * f, 0.52f, 0.72f);
    }

    private static /* synthetic */ int cch(int n, int n2) {
        return n + n2 + -1398206908;
    }
}

