/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3675$class_307
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_746
 *  net.minecraft.class_8956
 */
package a;

import a.CameraOffset;
import a.WheelScreen;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.ModuleManager;
import a.AutoMace;
import a.KeyPearl;
import a.oxc;
import a.oxf;
import a.oxi;
import a.oxt;
import a.MouseQuantizer;
import a.Icon;
import a.BoolSetting;
import a.KeySetting;
import a.ModeSetting;
import a.CursorStack;
import a.IdleTracker;
import a.KeyUtil;
import a.Lang;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_746;
import net.minecraft.class_8956;

public class ServerHelper
extends Module {
    private static final String oxx = "FunTime";
    private static final String oxy = "HolyWorld";
    private static final String oxz = "ReallyWorld";
    private static final int oya = 10;
    public static final long FLASH_MS = 700L;
    private static ServerHelper oyb;
    private final ModeSetting oyc = this.add(new ModeSetting("Server", "FunTime", "FunTime", "HolyWorld", "ReallyWorld"));
    private final KeySetting oyd = this.add(new KeySetting("Item wheel"));
    private final BoolSetting oye = new BoolSetting("Булава после заряда", true);
    private final BoolSetting oyf = new BoolSetting("Прыжок в тайминг", true);
    private final List<oxf> oyg = new ArrayList<oxf>();
    private final IdleTracker oyh = new IdleTracker(true);
    private final CursorStack oyi = new CursorStack();
    private boolean oyj;
    private oxf oyk;
    private oxf oyl;
    private oxf oym;
    private oxt oyn;
    private int oyo;
    private boolean oyp;
    private int oyq;
    private float oyr;
    private boolean oys;
    private int oyt;
    private int oyu = -1;
    private int oyv = -1;
    private boolean oyw;
    private static final float oyx = 83.0f;
    private static final float oyy = 93.0f;
    private static final float oyz = 3.0f;
    private static final float oza = 40.0f;
    private static final float ozb = 65.0f;
    private static final float ozc = 1.6f;
    private static final float ozd = 1.2f;
    private static final float oze = 30.0f;
    private static final float ozf = 55.0f;
    private static final int ozg = 0;
    private static final int ozh = 1;
    private static final int ozi = 0;
    private static final int ozj = 1;
    private static final long ozk = 120L;
    private static final long ozl = 220L;
    private int ozm;
    private long ozn;
    private oxf ozo;
    private float ozp;
    private float ozq;
    private float ozr;
    private float ozs;
    private static final int ozt = 12;
    private int ozu;
    private int ozv = -1;
    private boolean ozw;
    private double ozx;
    private float ozy;
    private float ozz;
    private static /* synthetic */ boolean paa;
    private static /* synthetic */ boolean pab;

    public ServerHelper() {
        super("ServerHelper", "Keys for FunTime, HolyWorld and ReallyWorld donate items: uses them straight from the inventory, plus a potion wheel", ModuleCategory.PLAYER);
        oyb = this;
        oxf oxf2 = this.pac("wind", "Заряд ветра", class_1802.field_49098, null, null, true);
        oxf2.thenMace = true;
        oxf2.groundOnly = true;
        this.add(this.oye);
        this.add(this.oyf);
        this.oye.activeWhen(oxf2.key::isBound);
        this.oyf.activeWhen(oxf2.key::isBound);
        this.pac("aura", "Божья аура", class_1802.field_8614, "божья аура", "FunTime", false);
        this.pac("trap", "Трапка", class_1802.field_22021, "трапка", "FunTime", false);
        this.pac("plast", "Пласт", class_1802.field_8551, "пласт", "FunTime", false);
        this.pac("dust", "Явная пыль", class_1802.field_8479, "явная", "FunTime", false);
        this.pac("disorient", "Дезориентация", class_1802.field_8449, "дезориентация", "FunTime", false);
        this.pac("snowball", "Снежок заморозка", class_1802.field_8543, "снежок заморозка", "FunTime", false);
        this.pac("hlopushka", "Хлопушка", class_1802.field_8436, "хлопушка", "FunTime", false);
        this.pac("holywater", "Святая вода", class_1802.field_8436, "святая вода", "FunTime", true);
        this.pac("anger", "Зелье гнева", class_1802.field_8436, "зелье гнева", "FunTime", true);
        this.pac("paladin", "Зелье паладина", class_1802.field_8436, "зелье палладина", "FunTime", true);
        this.pac("assassin", "Зелье ассасина", class_1802.field_8436, "зелье ассасина", "FunTime", true);
        this.pac("radiation", "Зелье радиации", class_1802.field_8436, "зелье радиации", "FunTime", false);
        this.pac("sleep", "Снотворное", class_1802.field_8436, "снотворное", "FunTime", false);
        this.pac((String)"fireball", (String)"Огненный шар", (class_1792)class_1802.field_8814, (String)"огненный шар", (String)"FunTime", (boolean)false).anyItem = true;
        this.pac("hw.boomtrap", "Взрывная трапка", class_1802.field_8662, "взрывная трапка", "HolyWorld", false);
        this.pac("hw.trap", "Обычная трапка", class_1802.field_8882, "трапка", "HolyWorld", false);
        this.pac("hw.stun", "Стан", class_1802.field_8137, "стан", "HolyWorld", false);
        this.pac("hw.boom", "Взрывная штучка", class_1802.field_8814, "взрывная штучка", "HolyWorld", false);
        this.pac("hw.snowball", "Снежок заморозка HW", class_1802.field_8543, "снежок заморозка", "HolyWorld", false);
        this.pac("hw.jack", "Светильник Джека", class_1802.field_8693, "светильник джека", "HolyWorld", false);
        this.pac("hw.exp", "Пузырь опыта", class_1802.field_8287, "пузырь опыта", "HolyWorld", false);
        this.pac("hw.bag1", "Рюкзак 1 уровня", class_1802.field_8520, "рюкзак (i уровень)", "HolyWorld", false);
        this.pac("hw.bag2", "Рюкзак 2 уровня", class_1802.field_8350, "рюкзак (ii уровень)", "HolyWorld", false);
        this.pac("hw.bag3", "Рюкзак 3 уровня", class_1802.field_8676, "рюкзак (iii уровень)", "HolyWorld", false);
        this.pac("rw.antifly", "Анти полет", class_1802.field_8450, "анти полет", "ReallyWorld", false);
        this.pac("rw.exp", "Свиток опыта", class_1802.field_8498, "свиток опыта", "ReallyWorld", false);
    }

    private oxf pac(String string, String string2, class_1792 class_17922, String string3, String string4, boolean bl) {
        oxf oxf2 = new oxf(string, string2, class_17922, string3, string4, bl);
        if (string4 != null) {
            oxf2.key.visibleWhen(() -> this.oyc.is(string4));
        }
        this.add(oxf2.key);
        this.oyg.add(oxf2);
        return oxf2;
    }

    private boolean pad(oxf oxf2) {
        return oxf2.server == null || this.oyc.is(oxf2.server);
    }

    public static ServerHelper get() {
        return oyb;
    }

    public static boolean busy() {
        return oyb != null && ServerHelper.oyb.oym != null;
    }

    @Override
    protected void onEnable() {
        this.oym = null;
        this.oyk = null;
        this.oyl = null;
        this.ozo = null;
    }

    @Override
    protected void onDisable() {
        this.oyl = null;
        this.ozo = null;
        this.pap();
        this.pas(this.mc);
        this.ozv = -1;
    }

    @Override
    public boolean keysAtStart() {
        return true;
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (n == this.oyd.get()) {
            this.paf(class_3102, n);
            return;
        }
        if (KeyUtil.mods(n) != 0) {
            this.pav(class_3102, KeyUtil.baseKey(n));
        }
        boolean bl = this.oym != null || KeyPearl.busy();
        for (oxf oxf2 : this.oyg) {
            if (oxf2.key.get() != n || !this.pad(oxf2)) continue;
            if (bl) {
                if (this.oym == oxf2 || class_3102.field_1724 == null || ServerHelper.pag(class_3102.field_1724, oxf2) <= 0) continue;
                this.ozo = oxf2;
                return;
            }
            if (!this.pae(class_3102, oxf2)) continue;
            return;
        }
    }

    private boolean pae(class_310 class_3102, oxf oxf2) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 != null && System.currentTimeMillis() < this.ozn && ServerHelper.pag(class_7462, oxf2) > 0) {
            this.ozo = oxf2;
            return true;
        }
        if (!oxf2.groundOnly || class_7462 == null || class_7462.method_24828() || !class_7462.method_5805()) {
            return this.pai(class_3102, oxf2);
        }
        if (ServerHelper.pag(class_7462, oxf2) == 0) {
            Hud.alert(Lang.t(oxf2.name), Lang.s("Not in the inventory", "Нет в инвентаре"), Icon.POTION, false);
            return false;
        }
        if (this.oyl != oxf2) {
            this.oyl = oxf2;
            Hud.alert(Lang.t(oxf2.name), Lang.s("After landing", "После приземления"), Icon.CLOCK, false);
        }
        return true;
    }

    private void paf(class_310 class_3102, int n) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1755 != null) {
            return;
        }
        ArrayList<oxf> arrayList = new ArrayList<oxf>();
        for (oxf oxf2 : this.oyg) {
            if (!oxf2.potion() || !this.pad(oxf2) || ServerHelper.pag(class_7462, oxf2) <= 0) continue;
            arrayList.add(oxf2);
        }
        if (arrayList.isEmpty()) {
            Hud.alert(this.getName(), Lang.s("No server potions on you", "Нет донат-зелий в инвентаре"), Icon.POTION, false);
            return;
        }
        class_3102.method_1507((class_437)new WheelScreen(new oxc(this, arrayList, class_3102), n));
    }

    private static int pag(class_746 class_7462, oxf oxf2) {
        class_1661 class_16612 = class_7462.method_31548();
        int n = CursorStack.count(class_16612, oxf2::matches);
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (!oxf2.matches(class_17992)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private static class_1799 pah(class_746 class_7462, oxf oxf2) {
        class_1661 class_16612 = class_7462.method_31548();
        for (int i = 0; i < 36; ++i) {
            if (!oxf2.matches(class_16612.method_5438(i))) continue;
            return class_16612.method_5438(i);
        }
        return CursorStack.peek(class_16612, oxf2::matches);
    }

    private boolean pai(class_310 class_3102, oxf oxf2) {
        class_1799 class_17992;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || !class_7462.method_5805() || class_7462.method_7325() || class_7462.field_7512 != class_7462.field_7498) {
            return false;
        }
        int n = ServerHelper.pbc(class_7462, oxf2);
        class_1799 class_17993 = class_17992 = n >= 0 ? class_7462.method_31548().method_5438(n) : CursorStack.peek(class_7462.method_31548(), oxf2::matches);
        if (class_17992.method_7960()) {
            Hud.alert(Lang.t(oxf2.name), Lang.s("Not in the inventory", "Нет в инвентаре"), Icon.POTION, false);
            return false;
        }
        if (class_7462.method_7357().method_7904(class_17992)) {
            Hud.alert(Lang.t(oxf2.name), Lang.s("Cooldown", "Кулдаун"), Icon.CLOCK, false);
            return true;
        }
        if (KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904).equals((Object)class_3675.field_16237)) {
            Hud.alert(Lang.t(oxf2.name), Lang.s("Right click isn't bound", "Не назначена ПКМ"), Icon.KEYBOARD, false);
            return true;
        }
        class_1661 class_16612 = class_7462.method_31548();
        this.oym = oxf2;
        this.oyo = n;
        this.oyj = n < 0;
        this.oyp = !this.oyj && n < 9;
        this.oyq = class_16612.method_67532();
        this.oyr = class_7462.method_36455();
        this.ozp = Math.min(90.0f, ServerHelper.pba(83.0f, 93.0f));
        this.ozs = this.ozq = ServerHelper.pba(-3.0f, 3.0f);
        this.oyt = 0;
        this.oyv = -1;
        this.oyw = false;
        this.ozm = 0;
        if (this.oyp) {
            this.oyn = oxt.SELECT;
        } else if (this.pbb(class_7462)) {
            if (!this.pao(class_3102)) {
                return true;
            }
            this.oyn = oxt.USE;
            this.ozm = ServerHelper.paq(0, 1);
        } else {
            this.oyn = oxt.PREPARE;
        }
        return true;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        ++this.ozu;
        this.oyu = class_3102.field_1724.method_31548().method_67532();
        this.pas(class_3102);
        this.pam(class_3102);
        this.paj(class_3102);
        this.pak(class_3102);
        this.par(class_3102);
    }

    private void paj(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (this.oyl != null && (!class_7462.method_5805() || class_7462.method_7325())) {
            this.oyl = null;
        }
        if (this.oym != null || KeyPearl.busy() || class_3102.field_1755 != null) {
            return;
        }
        if (this.oyl != null && class_7462.method_24828()) {
            oxf oxf2 = this.oyl;
            this.oyl = null;
            this.pai(class_3102, oxf2);
            return;
        }
        if (this.oyk != null) {
            oxf oxf3 = this.oyk;
            this.oyk = null;
            this.pai(class_3102, oxf3);
            return;
        }
        if (this.ozo != null && System.currentTimeMillis() >= this.ozn) {
            oxf oxf4 = this.ozo;
            this.ozo = null;
            this.pae(class_3102, oxf4);
        }
    }

    private void pak(class_310 class_3102) {
        if (this.oym == null) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        if (!class_7462.method_5805() || class_7462.field_7512 != class_7462.field_7498 || class_3102.field_1755 != null) {
            this.pap();
            return;
        }
        switch (this.oyn.ordinal()) {
            case 0: {
                boolean bl;
                class_1661 class_16612 = class_7462.method_31548();
                boolean bl2 = bl = class_16612.method_67532() != this.oyo;
                if (bl) {
                    class_16612.method_61496(this.oyo);
                }
                this.oyn = oxt.USE;
                this.ozm = 0;
                if (bl && ServerHelper.paq(0, 1) > 0) {
                    this.pax(class_7462);
                    break;
                }
                this.pal(class_3102, class_7462);
                break;
            }
            case 1: {
                this.paw(class_3102, class_7462);
                this.pax(class_7462);
                break;
            }
            case 2: {
                if (this.ozm > 0) {
                    --this.ozm;
                    if (!this.oyp) {
                        this.paw(class_3102, class_7462);
                    }
                    this.pax(class_7462);
                    return;
                }
                this.pal(class_3102, class_7462);
                break;
            }
            case 4: {
                if (this.ozm > 0) {
                    --this.ozm;
                    return;
                }
                this.pan(class_3102, class_7462);
                break;
            }
            default: {
                this.paw(class_3102, class_7462);
            }
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        this.ozx = class_3102.field_1724.method_18798().field_1351;
        if (this.oym == null) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        if (this.oyn == oxt.PREPARE) {
            if (!this.oyj && !this.oym.matches(class_7462.method_31548().method_5438(this.oyo))) {
                this.pap();
            } else if (this.pbb(class_7462)) {
                if (this.pao(class_3102)) {
                    this.oyn = oxt.USE;
                    this.ozm = ServerHelper.paq(0, 1);
                }
            } else if (++this.oyt > 10) {
                this.pap();
            }
        } else if (this.oyn == oxt.SWAP_BACK && this.ozm > 0) {
            --this.ozm;
        } else if (this.oyn == oxt.SWAP_BACK) {
            boolean bl;
            boolean bl2 = this.oyj ? class_7462.field_7512 == class_7462.field_7498 && this.oyh.idle(class_7462) : (bl = InventoryClicks.canClick(class_7462) && this.oyh.idle(class_7462));
            if (bl) {
                if (this.oyj) {
                    this.oyi.giveBack(class_3102);
                } else {
                    InventoryClicks.click(class_3102, this.oyo, this.oyq);
                }
                if (this.pat() && class_7462.field_7498.method_34255().method_7960()) {
                    int n = ServerHelper.pau(class_7462, this.oyq);
                    if (n >= 9) {
                        InventoryClicks.click(class_3102, n, this.oyq);
                    } else if (n >= 0) {
                        class_7462.method_31548().method_61496(n);
                    }
                }
                InventoryClicks.close(class_3102);
                this.oyh.release(class_3102);
                this.oyt = 0;
                if (this.oym.self) {
                    this.oyn = oxt.RESTORE;
                } else {
                    this.pap();
                }
            } else if (++this.oyt > 10) {
                this.pap();
            }
        } else if (this.oyn == oxt.RESTORE && this.oyv >= 0) {
            if (this.pbb(class_7462)) {
                InventoryClicks.swap(class_3102, this.oyv, class_7462.method_31548().method_67532());
                this.oyv = -1;
                this.oyh.release(class_3102);
                if (this.oyw) {
                    this.pap();
                }
            } else if (++this.oyt > 10) {
                this.oyv = -1;
                this.oyh.release(class_3102);
            }
        }
    }

    private void pal(class_310 class_3102, class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        if (!this.oyp) {
            this.paw(class_3102, class_7462);
        } else if (class_16612.method_67532() != this.oyo) {
            class_16612.method_61496(this.oyo);
        }
        if (!this.pax(class_7462)) {
            return;
        }
        if (this.oym.self) {
            this.ozr = class_3532.method_15363((float)(this.oyr + ServerHelper.pba(-1.6f, 1.6f)), (float)-90.0f, (float)90.0f);
            this.ozs = ServerHelper.pba(-1.2f, 1.2f) - (this.ozq - this.ozs);
        }
        if (!this.oym.matches(class_7462.method_6047())) {
            if (this.oyp) {
                this.pap();
            } else {
                this.oyt = 0;
                this.oyn = oxt.SWAP_BACK;
            }
            return;
        }
        if (class_7462.method_6115()) {
            class_3102.field_1761.method_2897((class_1657)class_7462);
        }
        if (class_3102.field_1761.method_2923()) {
            class_3102.field_1761.method_2925();
            class_3102.field_1690.field_1886.method_23481(false);
            this.oys = true;
        }
        for (class_304 class_3042 : class_3102.field_1690.field_1852) {
            while (class_3042.method_1436()) {
            }
        }
        class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904));
        this.oym.usedAt = System.currentTimeMillis();
        if (this.oym.thenMace && this.oyf.get() && class_7462.method_24828()) {
            this.ozv = this.ozu + 12;
        }
        this.oyt = 0;
        this.oyn = this.oyp ? oxt.RESTORE : oxt.SWAP_BACK;
        this.ozm = this.oyp ? ServerHelper.paq(0, 1) : ServerHelper.paq(0, 1);
    }

    private void pam(class_310 class_3102) {
        if (this.oys) {
            this.oys = false;
            if (class_3102.field_1690 != null && class_3102.method_22683() != null) {
                class_3102.field_1690.field_1886.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3102.field_1690.field_1886));
            }
        }
    }

    private void pan(class_310 class_3102, class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        if (this.oyp) {
            if (class_16612.method_67532() == this.oyo && this.oyo != this.oyq) {
                class_16612.method_61496(this.oyq);
            }
            this.oyp = false;
            if (this.pat() && class_16612.method_67532() == this.oyq) {
                int n = ServerHelper.pau(class_7462, this.oyq);
                if (n >= 9) {
                    this.oyv = n;
                } else if (n >= 0) {
                    class_16612.method_61496(n);
                }
            }
        }
        boolean bl = this.oyw = !this.oym.self || this.pay(class_7462, this.ozr, 30.0f, 55.0f);
        if (this.oyv >= 0) {
            this.paw(class_3102, class_7462);
            return;
        }
        if (this.oyw) {
            this.pap();
        }
    }

    private boolean pao(class_310 class_3102) {
        if (!this.oyj) {
            InventoryClicks.swap(class_3102, this.oyo, this.oyq);
            return true;
        }
        if (!this.oyi.take(class_3102, this.oym::matches, this.oyq)) {
            Hud.alert(Lang.t(this.oym.name), Lang.s("No room to take it out", "Некуда достать из мешка"), Icon.POTION, false);
            this.pap();
            return false;
        }
        if (!this.oyi.cursorHeld(class_3102.field_1724)) {
            InventoryClicks.close(class_3102);
        }
        return true;
    }

    private void pap() {
        class_1661 class_16612;
        class_746 class_7462 = this.mc.field_1724;
        if (this.oyi.active() && class_7462 != null) {
            this.oyi.giveBack(this.mc);
            InventoryClicks.close(this.mc);
        }
        this.oyh.release(this.mc);
        this.pam(this.mc);
        if (this.oym != null && this.oyp && class_7462 != null && (class_16612 = class_7462.method_31548()).method_67532() == this.oyo && this.oyo != this.oyq) {
            class_16612.method_61496(this.oyq);
        }
        if (this.oym != null) {
            this.ozn = System.currentTimeMillis() + 120L + ThreadLocalRandom.current().nextLong(101L);
        }
        this.oym = null;
        this.oyn = null;
        this.oyv = -1;
        this.ozm = 0;
        this.ozy = 0.0f;
        this.ozz = 0.0f;
        CameraOffset.releaseView();
    }

    private static int paq(int n, int n2) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double d = (threadLocalRandom.nextDouble() + threadLocalRandom.nextDouble()) * 0.5;
        return n + (int)Math.round(d * (double)(n2 - n));
    }

    private void par(class_310 class_3102) {
        if (this.ozv < 0) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        if (this.ozu > this.ozv || !class_7462.method_24828() || class_7462.method_18798().field_1351 - this.ozx > 0.5) {
            this.ozv = -1;
            return;
        }
        for (class_8956 class_89563 : class_3102.field_1687.method_8390(class_8956.class, class_7462.method_5829().method_1009(2.0, 3.0, 2.0), class_89562 -> class_89562.method_24921() == null || class_89562.method_24921() == class_7462)) {
            class_243 class_2432;
            class_243 class_2433 = class_89563.method_73189();
            class_3965 class_39652 = class_3102.field_1687.method_17742(new class_3959(class_2433, class_2432 = class_2433.method_1019(class_89563.method_18798().method_1021(2.0)), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)class_89563));
            if (class_39652.method_17783() == class_239.class_240.field_1333) continue;
            this.ozv = -1;
            if (class_3102.field_1755 == null) {
                class_3102.field_1690.field_1903.method_23481(true);
                this.ozw = true;
            }
            return;
        }
    }

    private void pas(class_310 class_3102) {
        if (this.ozw) {
            this.ozw = false;
            if (class_3102.field_1690 != null && class_3102.method_22683() != null) {
                class_3102.field_1690.field_1903.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3102.field_1690.field_1903));
            }
        }
    }

    private boolean pat() {
        return this.oym.thenMace && this.oye.get() && !AutoMace.takesWindMace();
    }

    private static int pau(class_746 class_7462, int n) {
        class_1661 class_16612 = class_7462.method_31548();
        if (class_16612.method_5438(n).method_31574(class_1802.field_49814)) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_31574(class_1802.field_49814)) continue;
            return i;
        }
        return -1;
    }

    private void pav(class_310 class_3102, int n) {
        for (class_304 class_3042 : class_3102.field_1690.field_1852) {
            class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3042);
            if (class_3062.method_1442() != class_3675.class_307.field_1668 || class_3062.method_1444() != n) continue;
            while (class_3042.method_1436()) {
            }
        }
        if (ModuleManager.startPhase()) {
            return;
        }
        class_1661 class_16612 = class_3102.field_1724.method_31548();
        int n2 = class_16612.method_67532();
        if (this.oyu < 0 || n2 == this.oyu || n2 >= class_3102.field_1690.field_1852.length) {
            return;
        }
        class_3675.class_306 class_3063 = KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1852[n2]);
        if (class_3063.method_1442() == class_3675.class_307.field_1668 && class_3063.method_1444() == n) {
            class_16612.method_61496(this.oyu);
        }
    }

    private void paw(class_310 class_3102, class_746 class_7462) {
        this.oyh.hold(class_3102);
        if (class_7462.method_6115()) {
            class_3102.field_1761.method_2897((class_1657)class_7462);
        }
    }

    private boolean pax(class_746 class_7462) {
        return !this.oym.self || this.pay(class_7462, this.ozp, 40.0f, 65.0f);
    }

    private boolean pay(class_746 class_7462, float f, float f2, float f3) {
        float f4 = f - class_7462.method_36455();
        float f5 = ServerHelper.pba(f2, f3);
        boolean bl = Math.abs(f4) <= f5;
        float f6 = bl ? 1.0f : f5 / Math.abs(f4);
        double d = MouseQuantizer.multiplier();
        float f7 = ServerHelper.paz(bl ? f4 : Math.signum(f4) * f5, d);
        float f8 = ServerHelper.paz(this.ozs * f6, d);
        float f9 = class_7462.method_36455();
        class_7462.method_36457(class_3532.method_15363((float)(class_7462.method_36455() + f7), (float)-90.0f, (float)90.0f));
        class_7462.method_36456(class_7462.method_36454() + f8);
        this.ozs -= f8;
        this.ozy += f8;
        this.ozz += class_7462.method_36455() - f9;
        CameraOffset.viewOffset(this.ozy, this.ozz);
        return bl;
    }

    private static float paz(float f, double d) {
        return d > 0.0 ? MouseQuantizer.quantize(f, d) : f;
    }

    private static float pba(float f, float f2) {
        return f + ThreadLocalRandom.current().nextFloat() * (f2 - f);
    }

    private boolean pbb(class_746 class_7462) {
        return InventoryClicks.canClick(class_7462) && this.oyh.idle(class_7462) && !class_7462.method_6115();
    }

    private static int pbc(class_746 class_7462, oxf oxf2) {
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        if (oxf2.matches(class_16612.method_5438(n = class_16612.method_67532()))) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!oxf2.matches(class_16612.method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private static String pbd(String string) {
        return string.toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
    }

    public List<oxi> entries(float f) {
        ArrayList<oxi> arrayList = new ArrayList<oxi>();
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462 == null) {
            return arrayList;
        }
        class_1661 class_16612 = class_7462.method_31548();
        for (oxf oxf2 : this.oyg) {
            if (!oxf2.key.isBound() || !this.pad(oxf2)) continue;
            int n = CursorStack.count(class_16612, oxf2::matches);
            class_1799 class_17992 = class_1799.field_8037;
            for (int i = 0; i < 36; ++i) {
                class_1799 class_17993 = class_16612.method_5438(i);
                if (!oxf2.matches(class_17993)) continue;
                n += class_17993.method_7947();
                if (!class_17992.method_7960()) continue;
                class_17992 = class_17993;
            }
            if (class_17992.method_7960() && n > 0) {
                class_17992 = CursorStack.peek(class_16612, oxf2::matches);
            }
            float f2 = class_17992.method_7960() ? 0.0f : class_7462.method_7357().method_7905(class_17992, f);
            arrayList.add(new oxi(oxf2.id, oxf2.name, class_17992.method_7960() ? new class_1799((class_1935)oxf2.item) : class_17992, n, oxf2.key.get(), f2, oxf2.usedAt, this.oym == oxf2 || this.oyl == oxf2));
        }
        return arrayList;
    }

    private static /* synthetic */ int bgh(int n, int n2) {
        return (n ^ n2) + -224654549;
    }

    private static /* synthetic */ int bgi(int n, int n2) {
        return ServerHelper.bgh(n, n2) + n;
    }

    private static /* synthetic */ int bgj(int n, int n2) {
        return n * n2 + -2005507098;
    }
}

