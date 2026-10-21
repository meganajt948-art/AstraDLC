/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3675$class_307
 *  net.minecraft.class_746
 */
package a;

import a.Hud;
import a.ServerHelper;
import a.Icon;
import a.IdleTracker;
import a.vze;
import a.KeyUtil;
import a.Lang;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_746;

public final class CooldownPress {
    private static final int vzi = 20;
    private final class_1792 vzj;
    private final IdleTracker vzk;
    private vze vzl;
    private int vzm;
    private boolean vzn;
    private int vzo;
    private int vzp;
    private int vzq = -1;
    private static /* synthetic */ long vzr;
    private static /* synthetic */ String vzs;

    public CooldownPress(class_1792 class_17922) {
        this(class_17922, false);
    }

    public CooldownPress(class_1792 class_17922, boolean bl) {
        this.vzj = class_17922;
        this.vzk = new IdleTracker(bl);
    }

    public boolean busy() {
        return this.vzl != null;
    }

    public void press(class_310 class_3102, int n, String string, String string2) {
        if (this.vzl != null || ServerHelper.busy()) {
            return;
        }
        if (KeyUtil.mods(n) != 0) {
            this.vzv(class_3102, KeyUtil.baseKey(n));
        }
        this.vzt(class_3102, string, string2);
    }

    private void vzt(class_310 class_3102, String string, String string2) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || !class_7462.method_5805() || class_7462.method_7325() || class_7462.field_7512 != class_7462.field_7498) {
            return;
        }
        int n = this.vzy(class_7462);
        if (n < 0) {
            Hud.alert(string, string2, Icon.INFO, false);
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (class_7462.method_7357().method_7904(class_16612.method_5438(n))) {
            Hud.alert(string, Lang.s("Cooldown", "Кулдаун"), Icon.CLOCK, false);
            return;
        }
        if (KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904).equals((Object)class_3675.field_16237)) {
            Hud.alert(string, Lang.s("Right click isn't bound", "Не назначена ПКМ"), Icon.KEYBOARD, false);
            return;
        }
        this.vzm = n;
        this.vzn = n < 9;
        this.vzo = class_16612.method_67532();
        this.vzp = 0;
        if (this.vzn) {
            this.vzl = vze.USE;
        } else if (this.vzx(class_7462)) {
            InventoryClicks.swap(class_3102, this.vzm, this.vzo);
            this.vzl = vze.USE;
        } else {
            this.vzl = vze.PREPARE;
        }
    }

    public void startTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        this.vzq = class_7462.method_31548().method_67532();
        if (this.vzl == null) {
            return;
        }
        if (!class_7462.method_5805() || class_7462.field_7512 != class_7462.field_7498) {
            this.reset(class_3102);
            return;
        }
        if (class_3102.field_1755 != null && this.vzl != vze.SWAP_BACK) {
            if (this.vzl == vze.USE && !this.vzn) {
                this.vzl = vze.SWAP_BACK;
            } else {
                this.reset(class_3102);
                return;
            }
        }
        switch (this.vzl.ordinal()) {
            case 1: {
                this.vzu(class_3102, class_7462);
                break;
            }
            case 3: {
                this.reset(class_3102);
                break;
            }
            default: {
                this.vzw(class_3102, class_7462);
            }
        }
    }

    public void endTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (this.vzl == null || class_7462 == null) {
            return;
        }
        if (this.vzl == vze.PREPARE) {
            class_1661 class_16612 = class_7462.method_31548();
            if (!class_16612.method_5438(this.vzm).method_31574(this.vzj)) {
                this.reset(class_3102);
            } else if (this.vzx(class_7462)) {
                this.vzo = class_16612.method_67532();
                InventoryClicks.swap(class_3102, this.vzm, this.vzo);
                this.vzl = vze.USE;
            } else if (++this.vzp > 20) {
                this.reset(class_3102);
            }
        } else if (this.vzl == vze.SWAP_BACK) {
            if (InventoryClicks.canClick(class_7462) && this.vzk.idle(class_7462)) {
                InventoryClicks.swap(class_3102, this.vzm, this.vzo);
                this.reset(class_3102);
            } else if (++this.vzp > 20) {
                this.reset(class_3102);
            }
        }
    }

    private void vzu(class_310 class_3102, class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        if (!this.vzn) {
            this.vzw(class_3102, class_7462);
        } else if (class_16612.method_67532() != this.vzm) {
            class_16612.method_61496(this.vzm);
        }
        if (!class_7462.method_6047().method_31574(this.vzj)) {
            this.reset(class_3102);
            return;
        }
        if (class_7462.method_6115()) {
            class_3102.field_1761.method_2897((class_1657)class_7462);
        }
        class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904));
        this.vzp = 0;
        this.vzl = this.vzn ? vze.RESTORE : vze.SWAP_BACK;
    }

    public void reset(class_310 class_3102) {
        class_1661 class_16612;
        this.vzk.release(class_3102);
        class_746 class_7462 = class_3102.field_1724;
        if (this.vzl != null && this.vzn && class_7462 != null && (class_16612 = class_7462.method_31548()).method_67532() == this.vzm && this.vzm != this.vzo) {
            class_16612.method_61496(this.vzo);
        }
        this.vzl = null;
    }

    private void vzv(class_310 class_3102, int n) {
        class_1661 class_16612 = class_3102.field_1724.method_31548();
        int n2 = class_16612.method_67532();
        if (this.vzq < 0 || n2 == this.vzq || n2 >= class_3102.field_1690.field_1852.length) {
            return;
        }
        class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1852[n2]);
        if (class_3062.method_1442() == class_3675.class_307.field_1668 && class_3062.method_1444() == n) {
            class_16612.method_61496(this.vzq);
        }
    }

    private void vzw(class_310 class_3102, class_746 class_7462) {
        this.vzk.hold(class_3102);
        if (class_7462.method_6115()) {
            class_3102.field_1761.method_2897((class_1657)class_7462);
        }
    }

    private boolean vzx(class_746 class_7462) {
        return InventoryClicks.canClick(class_7462) && this.vzk.idle(class_7462) && !class_7462.method_6115();
    }

    private int vzy(class_746 class_7462) {
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        if (class_16612.method_5438(n = class_16612.method_67532()).method_31574(this.vzj)) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_31574(this.vzj)) continue;
            return i;
        }
        return -1;
    }

    private static /* synthetic */ int dnf(int n, int n2) {
        return n * n2 | 0x112541F2;
    }

    private static /* synthetic */ int dng(int n, int n2) {
        return n * n2 + -1024764142;
    }

    private static /* synthetic */ int dnh(int n, int n2) {
        return n ^ n2 | 0x4043103B;
    }
}

