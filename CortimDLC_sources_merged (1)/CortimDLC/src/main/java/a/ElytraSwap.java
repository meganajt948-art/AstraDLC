/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 */
package a;

import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.KeyPearl;
import a.ServerHelper;
import a.Icon;
import a.KeySetting;
import a.vuc;
import a.EquipUtil;
import a.IdleTracker;
import a.CooldownPress;
import a.KeyUtil;
import a.Lang;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_746;
import net.minecraft.class_7923;

public class ElytraSwap
extends Module {
    private static final int oud = 6;
    private final KeySetting oue = this.add(new KeySetting("Swap key"));
    private final KeySetting ouf = this.add(new KeySetting("Firework key"));
    private final CooldownPress oug = new CooldownPress(class_1802.field_8639);
    private final IdleTracker ouh = new IdleTracker();
    private boolean oui;
    private boolean ouj;
    private int ouk;
    private int oul;
    private static /* synthetic */ boolean oum;
    private static /* synthetic */ int oun;

    public ElytraSwap() {
        super("ElytraSwap", "Swaps the chestplate and the elytra on one key, uses a firework on the other", ModuleCategory.PLAYER);
    }

    @Override
    protected void onEnable() {
        if (!this.oue.isBound() && !this.ouf.isBound() && this.mc.field_1724 != null) {
            Hud.alert(this.getName(), Lang.s("Bind the keys in its settings", "Назначь кнопки в настройках"), Icon.KEYBOARD, false);
        }
    }

    @Override
    protected void onDisable() {
        this.ouj = false;
        this.oup();
        this.ouq();
        this.oug.reset(this.mc);
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (n == this.oue.get()) {
            this.ouj = true;
            this.ouk = 0;
        } else if (n == this.ouf.get() && !this.ouj) {
            this.oug.press(class_3102, n, this.getName(), Lang.s("No fireworks", "Нет фейерверков"));
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.oug.startTick(class_3102);
        if (this.oul > 0 && --this.oul == 0) {
            this.ouq();
        }
        if (this.ouj && !this.oui && class_3102.field_1724 != null && !IdleTracker.serverIdle(class_3102.field_1724)) {
            this.ouh.hold(class_3102);
            this.oui = true;
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        this.oug.endTick(class_3102);
        class_746 class_7462 = class_3102.field_1724;
        if (!this.ouj || class_7462 == null) {
            return;
        }
        if (!InventoryClicks.canClick(class_7462) || class_3102.field_1755 != null || ServerHelper.busy() || KeyPearl.busy() || this.oug.busy()) {
            if (++this.ouk > 6) {
                this.ouj = false;
                this.oup();
            }
            return;
        }
        if (!IdleTracker.serverIdle(class_7462)) {
            if (++this.ouk > 6) {
                this.ouj = false;
                this.oup();
            }
            return;
        }
        this.ouj = false;
        this.ouo(class_3102, class_7462);
        this.oup();
    }

    private void ouo(class_310 class_3102, class_746 class_7462) {
        class_1799 class_17993 = class_7462.method_6118(class_1304.field_6174);
        boolean bl = !class_17993.method_31574(class_1802.field_8833);
        vuc vuc2 = EquipUtil.best(class_7462.method_31548(), true, class_17992 -> {
            if (bl) {
                return class_17992.method_31574(class_1802.field_8833) && EquipUtil.left(class_17992) > 1 ? 1 + Math.min(9999, EquipUtil.left(class_17992)) : 0;
            }
            if (EquipUtil.wornIn(class_17992) != class_1304.field_6174 || class_17992.method_31574(class_1802.field_8833)) {
                return 0;
            }
            String string = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
            int n = string.startsWith("netherite_") ? 6 : (string.startsWith("diamond_") ? 5 : (string.startsWith("iron_") ? 4 : (string.startsWith("chainmail_") ? 3 : (string.startsWith("golden_") ? 2 : 1))));
            return n * 100000 + Math.min(99999, EquipUtil.left(class_17992));
        });
        if (vuc2 == null) {
            Hud.alert(this.getName(), bl ? Lang.s("No elytra", "Нет элитр") : Lang.s("No chestplate", "Нет нагрудника"), Icon.INFO, false);
            return;
        }
        if (!EquipUtil.roomFor(class_7462.method_31548(), vuc2, class_17993)) {
            Hud.alert(this.getName(), Lang.s("No room in the inventory", "Нет места в инвентаре"), Icon.INFO, false);
            return;
        }
        if (EquipUtil.equip(class_3102, class_1304.field_6174, vuc2) && bl && !class_7462.method_24828() && !class_7462.method_6128() && !class_7462.method_31549().field_7479) {
            class_3102.field_1690.field_1903.method_23481(true);
            this.oul = 2;
        }
    }

    private void oup() {
        if (this.oui) {
            this.ouh.release(this.mc);
            this.oui = false;
        }
    }

    private void ouq() {
        if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
            this.mc.field_1690.field_1903.method_23481(KeyUtil.isPhysicallyDown(this.mc, this.mc.field_1690.field_1903));
        }
        this.oul = 0;
    }

    private static /* synthetic */ int bey(int n, int n2) {
        return n + n2 ^ 0x3E693F6A;
    }
}

