/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.AutoEnd;
import a.AutoWarden;
import a.AutoLoot;
import a.InventorySorter;
import a.BoolSetting;
import a.NumberSetting;
import a.SlotUtil;
import flow.dev.StringDecryptor;
import java.util.Random;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;

public class ChestStealer
extends Module {
    private final NumberSetting oto = this.add(new NumberSetting("Delay", 60.0, 0.0, 500.0, 10.0).suffix("ms"));
    private final NumberSetting otp = this.add(new NumberSetting("Random", 40.0, 0.0, 300.0, 10.0).suffix("ms"));
    private final BoolSetting otq = this.add(new BoolSetting("Auto close", true));
    private final BoolSetting otr = this.add(new BoolSetting("No hotbar", false));
    private static final long ots = 180L;
    private static final long ott = 300L;
    private final Random otu = new Random();
    private class_437 otv;
    private long otw;
    private long otx;
    private long oty;
    private static /* synthetic */ int otz;
    private static /* synthetic */ int oua;

    public ChestStealer() {
        super("ChestStealer", "Empties the chests you open", ModuleCategory.PLAYER);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_465 class_4652;
        long l;
        block12: {
            block11: {
                class_437 class_4372 = class_3102.field_1755;
                l = System.currentTimeMillis();
                if (class_4372 != this.otv) {
                    this.otv = class_4372;
                    this.otw = l;
                    this.oty = l;
                    this.otx = l + 180L;
                }
                if (!(class_4372 instanceof class_465)) break block11;
                class_4652 = (class_465)class_4372;
                if (SlotUtil.isStorage(class_4372) && !AutoLoot.busy() && !InventorySorter.busy() && !ChestStealer.oub()) break block12;
            }
            return;
        }
        class_1703 class_17032 = class_4652.method_17577();
        if (!class_17032.method_34255().method_7960() || l < this.otx) {
            return;
        }
        class_1661 class_16612 = class_3102.field_1724.method_31548();
        for (class_1735 class_17352 : SlotUtil.own(class_17032, class_16612)) {
            if (!class_17352.method_7681() || !class_17352.method_7674((class_1657)class_3102.field_1724) || SlotUtil.room(class_17032, class_16612, class_17352.method_7677(), !this.otr.get()) == null) continue;
            if (this.otr.get()) {
                class_1735 class_17353 = SlotUtil.room(class_17032, class_16612, class_17352.method_7677(), false);
                SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7790);
                SlotUtil.click(class_3102, class_17032, class_17353.field_7874, 0, class_1713.field_7790);
                if (!class_17032.method_34255().method_7960()) {
                    SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7790);
                }
            } else {
                SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7794);
            }
            this.oty = l;
            this.otx = l + (long)this.oto.getInt() + (long)(this.otp.getInt() > 0 ? this.otu.nextInt(this.otp.getInt() + 1) : 0);
            return;
        }
        if (this.otq.get() && l - this.oty > 300L && l - this.otw > 480L) {
            class_4652.method_25419();
        }
    }

    private static boolean oub() {
        AutoWarden nxa2 = AutoWarden.mainInstance();
        if (nxa2 != null && nxa2.isEnabled() && nxa2.busy()) {
            return true;
        }
        AutoEnd mpq2 = AutoEnd.mainInstance();
        return mpq2 != null && mpq2.isEnabled() && mpq2.busy();
    }

    private static /* synthetic */ int bev(int n, int n2) {
        return n ^ n2 ^ 0x3FFCBC02;
    }
}

