/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.KeyPearl;
import a.ServerHelper;
import a.BoolSetting;
import a.NumberSetting;
import a.vuc;
import a.EquipUtil;
import a.IdleTracker;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import net.minecraft.class_1304;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_746;
import net.minecraft.class_7923;

public class AutoArmor
extends Module {
    private static final class_1304[] mjs = new class_1304[]{class_1304.field_6174, class_1304.field_6172, class_1304.field_6169, class_1304.field_6166};
    private static final int mjt = 6;
    private final NumberSetting mju = this.add(new NumberSetting("Swap below durability", 2.0, 1.0, 100.0, 1.0));
    private final BoolSetting mjv = this.add(new BoolSetting("From bundles", true));
    private final BoolSetting mjw = this.add(new BoolSetting("Keep elytra", true));
    private final IdleTracker mjx = new IdleTracker();
    private boolean mjy;
    private boolean mjz;
    private int mka;
    private int mkb;
    private static /* synthetic */ int mkc;
    private static /* synthetic */ String mkd;

    public AutoArmor() {
        super("AutoArmor", "Puts on netherite or diamond armour at once, swaps a breaking piece for a repaired one", ModuleCategory.PLAYER);
    }

    @Override
    protected void onDisable() {
        if (this.mjy) {
            this.mjx.release(this.mc);
            this.mjy = false;
        }
        this.mjz = false;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (this.mjz && !this.mjy && class_3102.field_1724 != null) {
            this.mjx.hold(class_3102);
            this.mjy = true;
            this.mka = 0;
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        boolean bl;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        if (this.mkb > 0) {
            --this.mkb;
        }
        boolean bl2 = bl = this.mkb == 0 && this.mkf(class_3102, class_7462) && this.mkh(class_7462);
        if (!bl) {
            this.mjz = false;
            this.mke();
            return;
        }
        if (IdleTracker.serverIdle(class_7462) || AutoArmor.mkg(class_3102, class_7462)) {
            this.mki(class_3102, class_7462);
            this.mjz = false;
            this.mke();
            this.mkb = 2;
            return;
        }
        this.mjz = true;
        if (this.mjy && ++this.mka > 6) {
            this.mke();
            this.mjz = false;
            this.mkb = 10;
        }
    }

    private void mke() {
        if (this.mjy) {
            this.mjx.release(this.mc);
            this.mjy = false;
        }
    }

    private boolean mkf(class_310 class_3102, class_746 class_7462) {
        if (!class_7462.method_5805() || class_7462.method_7325() || !InventoryClicks.canClick(class_7462)) {
            return false;
        }
        if (class_3102.field_1755 != null && !AutoArmor.mkg(class_3102, class_7462)) {
            return false;
        }
        return !ServerHelper.busy() && !KeyPearl.busy() && !class_7462.method_6115();
    }

    private static boolean mkg(class_310 class_3102, class_746 class_7462) {
        class_465 class_4652;
        class_437 class_4372 = class_3102.field_1755;
        return class_4372 instanceof class_465 && (class_4652 = (class_465)class_4372).method_17577() == class_7462.field_7498;
    }

    private boolean mkh(class_746 class_7462) {
        for (class_1304 class_13042 : mjs) {
            if (this.mkj(class_7462, class_13042) == null) continue;
            return true;
        }
        return false;
    }

    private void mki(class_310 class_3102, class_746 class_7462) {
        for (class_1304 class_13042 : mjs) {
            vuc vuc2 = this.mkj(class_7462, class_13042);
            if (vuc2 == null || EquipUtil.equip(class_3102, class_13042, vuc2)) continue;
            return;
        }
    }

    private vuc mkj(class_746 class_7462, class_1304 class_13042) {
        boolean bl;
        class_1799 class_17993 = class_7462.method_6118(class_13042);
        if (class_13042 == class_1304.field_6174 && this.mjw.get() && class_17993.method_31574(class_1802.field_8833)) {
            return null;
        }
        int n = this.mju.getInt();
        boolean bl2 = class_17993.method_7960();
        boolean bl3 = bl = !bl2 && class_17993.method_7963() && EquipUtil.left(class_17993) <= n;
        if (!bl2 && !bl) {
            return null;
        }
        int n2 = bl2 ? 0 : EquipUtil.left(class_17993);
        class_1661 class_16612 = class_7462.method_31548();
        vuc vuc2 = EquipUtil.best(class_16612, this.mjv.get(), class_17992 -> {
            if (EquipUtil.wornIn(class_17992) != class_13042 || AutoArmor.mkk(class_17992) == 0) {
                return 0;
            }
            int n3 = EquipUtil.left(class_17992);
            if (n3 <= n || !bl2 && n3 <= n2) {
                return 0;
            }
            return AutoArmor.mkk(class_17992) * 100000 + Math.min(99999, n3);
        });
        if (vuc2 == null || !EquipUtil.roomFor(class_16612, vuc2, class_17993)) {
            return null;
        }
        return vuc2;
    }

    private static int mkk(class_1799 class_17992) {
        String string = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
        if (string.startsWith("netherite_")) {
            return 2;
        }
        return string.startsWith("diamond_") ? 1 : 0;
    }

    private static /* synthetic */ int bbh(int n, int n2) {
        return n - n2 + -107924305;
    }

    private static /* synthetic */ int bbi(int n, int n2) {
        return AutoArmor.bbh(n, n2) + n;
    }

    private static /* synthetic */ int bbj(int n, int n2) {
        return AutoArmor.bbi(n, n2) * n2;
    }
}

