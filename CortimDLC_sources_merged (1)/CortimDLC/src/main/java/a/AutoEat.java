/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1661
 *  net.minecraft.class_1802
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_746
 */
package a;

import a.InventoryCounter;
import a.KeyUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1661;
import net.minecraft.class_1802;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_746;

public final class AutoEat {
    private int qmb = -1;
    private int qmc = -1;
    private int qmd;
    private boolean qme;
    private static /* synthetic */ boolean qmf;
    private static /* synthetic */ int qmg;

    public boolean active() {
        return this.qmb >= 0;
    }

    public static boolean hungry(class_746 class_7462) {
        int n = class_7462.method_7344().method_7586();
        return n <= 14 || n < 20 && class_7462.method_6032() < class_7462.method_6063() * 0.6f;
    }

    public static boolean canEat(class_746 class_7462) {
        if (InventoryCounter.isFood(class_7462.method_6079())) {
            return true;
        }
        class_1661 class_16612 = class_7462.method_31548();
        for (int i = 0; i < 9; ++i) {
            if (!InventoryCounter.isFood(class_16612.method_5438(i))) continue;
            return true;
        }
        return false;
    }

    public static int stored(class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        int n = InventoryCounter.find(class_16612, class_1802.field_8071);
        if (n >= 9) {
            return n;
        }
        for (int i = 9; i < 36; ++i) {
            if (!InventoryCounter.isFood(class_16612.method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    public boolean start(class_746 class_7462) {
        if (this.active() || class_7462.method_6115()) {
            return false;
        }
        this.qmc = -1;
        if (!InventoryCounter.isFood(class_7462.method_6079())) {
            class_1661 class_16612 = class_7462.method_31548();
            int n = -1;
            for (int i = 0; i < 9; ++i) {
                if (!class_16612.method_5438(i).method_31574(class_1802.field_8071) && (n >= 0 || !InventoryCounter.isFood(class_16612.method_5438(i)))) continue;
                n = i;
            }
            if (n < 0) {
                return false;
            }
            if (class_16612.method_67532() != n) {
                this.qmc = class_16612.method_67532();
                class_16612.method_61496(n);
            }
        }
        this.qmb = 0;
        this.qmd = class_7462.method_7344().method_7586();
        return true;
    }

    public void startTick(class_310 class_3102) {
        if (this.active()) {
            class_3102.field_1690.field_1904.method_23481(true);
            this.qme = true;
        }
    }

    public void endTick(class_310 class_3102, class_746 class_7462) {
        boolean bl;
        class_3675.class_306 class_3062;
        if (!this.active()) {
            return;
        }
        ++this.qmb;
        if ((this.qmb == 1 || this.qmb == 12 && !class_7462.method_6115()) && !(class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904)).equals((Object)class_3675.field_16237)) {
            class_304.method_1420((class_3675.class_306)class_3062);
        }
        boolean bl2 = bl = class_7462.method_7344().method_7586() > this.qmd && !class_7462.method_6115();
        if (bl || this.qmb > 70 || this.qmb > 24 && !class_7462.method_6115() || !class_7462.method_5805()) {
            this.stop(class_3102, class_7462);
        }
    }

    public void stop(class_310 class_3102, class_746 class_7462) {
        if (this.qme && class_3102.field_1690 != null && class_3102.method_22683() != null) {
            class_3102.field_1690.field_1904.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3102.field_1690.field_1904));
        }
        this.qme = false;
        if (this.qmc >= 0 && class_7462 != null) {
            class_7462.method_31548().method_61496(this.qmc);
        }
        this.qmc = -1;
        this.qmb = -1;
    }

    private static /* synthetic */ int bsw(int n, int n2) {
        return n + n2 + -1357643080;
    }
}

