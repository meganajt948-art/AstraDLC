/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1893
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3965
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.AutoTotem;
import a.KeyPearl;
import a.AncientFarmer;
import a.ServerHelper;
import a.BoolSetting;
import a.NumberSetting;
import a.IdleTracker;
import a.KeyUtil;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_3965;
import net.minecraft.class_6880;
import net.minecraft.class_746;

public class AutoMend
extends Module {
    private static final int nup = -1;
    private static final int nuq = -2;
    private static final int nur = -3;
    private static final int nus = 20;
    private static final int nut = 20;
    private static final int nuu = 10;
    private static final float nuv = 0.01f;
    private static final float nuw = 0.3f;
    private final BoolSetting nux = this.add(new BoolSetting("Из инвентаря", true));
    private final BoolSetting nuy = this.add(new BoolSetting("Возвращать", true));
    private final NumberSetting nuz = this.add(new NumberSetting("Задержка возврата", 4.0, 0.0, 20.0, 1.0).suffix("ticks"));
    private final BoolSetting nva = this.add(new BoolSetting("Беречь прочность", true));
    private static AutoMend nvb;
    private final IdleTracker nvc = new IdleTracker();
    private class_746 nvd;
    private int nve = -1;
    private int nvf = -1;
    private int nvg = -1;
    private class_1799 nvh = class_1799.field_8037;
    private boolean nvi;
    private int nvj;
    private int nvk = -1;
    private boolean nvl;
    private boolean nvm;
    private int nvn;
    private int nvo;
    private static /* synthetic */ String nvp;
    private static /* synthetic */ int nvq;

    public AutoMend() {
        super("AutoTool", "Takes the best tool while you mine", ModuleCategory.PLAYER);
        this.nuz.activeWhen(this.nuy::get);
        nvb = this;
    }

    public static boolean busy() {
        return nvb != null && nvb.isEnabled() && AutoMend.nvb.nve >= 0;
    }

    @Override
    protected void onEnable() {
        this.nvd = null;
        this.nwd();
        this.nvo = 0;
    }

    @Override
    protected void onDisable() {
        this.nwc();
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462 != null && class_7462 == this.nvd && this.nvg >= 0 && InventoryClicks.canClick(class_7462) && this.nwe(class_7462)) {
            this.nvx(class_7462.method_31548());
        }
        this.nwd();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        class_2680 class_26802;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 != this.nvd) {
            this.nvd = class_7462;
            this.nwd();
        }
        if (this.nvo > 0) {
            --this.nvo;
        }
        if (AncientFarmer.busy()) {
            this.nwc();
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (this.nvf >= 0 && class_16612.method_67532() != this.nvf) {
            this.nvi = true;
        }
        int n = this.nvj = (class_26802 = this.nvs(class_7462)) != null ? 0 : Math.min(this.nvj + 1, 1000);
        if (!class_7462.method_5805() || class_7462.method_7325()) {
            this.nwd();
            return;
        }
        int n2 = this.nvr(class_7462, class_26802);
        if (n2 == -1) {
            this.nwc();
            return;
        }
        if (n2 == -3) {
            this.nwd();
            return;
        }
        if (n2 < 9 && n2 >= 0) {
            this.nwc();
            this.nvy(class_16612, n2);
            return;
        }
        if (!(n2 != -2 || this.nvg >= 0 && this.nvz(class_16612))) {
            this.nvx(class_16612);
            return;
        }
        if (this.nvo > 0 || !InventoryClicks.canClick(class_7462) || ServerHelper.busy() || KeyPearl.busy() || AutoTotem.busy()) {
            this.nwc();
            return;
        }
        if (this.nwe(class_7462)) {
            this.nwc();
            this.nvw(class_7462, n2);
            return;
        }
        if (AutoMend.nwf(class_7462)) {
            this.nwc();
            return;
        }
        if (++this.nvn > 20) {
            this.nwc();
            this.nvo = 20;
            return;
        }
        this.nwa(class_7462);
        this.nvk = n2;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (this.nvk == -1) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        if (InventoryClicks.canClick(class_7462) && this.nwe(class_7462) && !ServerHelper.busy() && !KeyPearl.busy()) {
            int n = this.nvk;
            this.nvw(class_7462, n);
            this.nwc();
        } else {
            this.nwb();
        }
    }

    private int nvr(class_746 class_7462, class_2680 class_26802) {
        boolean bl;
        if (class_26802 != null) {
            if (this.nvi) {
                return -1;
            }
            boolean bl2 = this.nux.get() && (this.nwe(class_7462) || !AutoMend.nwf(class_7462));
            return this.nvt(class_7462, class_26802, bl2);
        }
        if (this.nve < 0 || class_7462.method_6115()) {
            return -1;
        }
        class_239 class_2392 = this.mc.field_1765;
        boolean bl3 = bl = class_2392 != null && class_2392.method_17783() == class_239.class_240.field_1331;
        if (!bl && this.nvj <= this.nuz.getInt()) {
            return -1;
        }
        return this.nuy.get() ? -2 : -3;
    }

    private class_2680 nvs(class_746 class_7462) {
        class_3965 class_39652;
        if (this.mc.field_1755 != null || this.mc.field_1687 == null || class_7462.method_68878() || class_7462.method_7325() || class_7462.method_6115() || !this.mc.field_1690.field_1886.method_1434()) {
            return null;
        }
        this.mc.field_1773.method_3190(1.0f);
        class_239 class_2392 = this.mc.field_1765;
        if (!(class_2392 instanceof class_3965) || (class_39652 = (class_3965)class_2392).method_17783() != class_239.class_240.field_1332) {
            return null;
        }
        class_2392 = class_39652.method_17777();
        class_2680 class_26802 = this.mc.field_1687.method_8320((class_2338)class_2392);
        if (class_26802.method_26215() || class_26802.method_26214((class_1922)this.mc.field_1687, (class_2338)class_2392) <= 0.0f) {
            return null;
        }
        return class_26802;
    }

    private int nvt(class_746 class_7462, class_2680 class_26802, boolean bl) {
        float f;
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        int n2 = class_16612.method_67532();
        float f2 = this.nvu(class_16612.method_5438(n2), class_26802);
        int n3 = -1;
        for (n = 0; n < 9; ++n) {
            if (n == n2 || !((f = this.nvu(class_16612.method_5438(n), class_26802)) > f2 + 0.01f)) continue;
            f2 = f;
            n3 = n;
        }
        if (bl) {
            for (n = 9; n < 36; ++n) {
                f = this.nvu(class_16612.method_5438(n), class_26802);
                if (!(f > f2 + 0.01f) || !(f > 1.0f)) continue;
                f2 = f;
                n3 = n;
            }
        }
        return n3;
    }

    private float nvu(class_1799 class_17992, class_2680 class_26802) {
        int n;
        if (this.nva.get() && class_17992.method_7963() && class_17992.method_7936() - class_17992.method_7919() <= 10) {
            return -1.0f;
        }
        float f = class_17992.method_7924(class_26802);
        if (f > 1.0f && (n = AutoMend.nvv(class_17992)) > 0) {
            f += (float)(n * n + 1);
        }
        return !class_26802.method_29291() || class_17992.method_7951(class_26802) ? f : f * 0.3f;
    }

    private static int nvv(class_1799 class_17992) {
        for (Object2IntMap.Entry entry : class_17992.method_58657().method_57539()) {
            if (!((class_6880)entry.getKey()).method_40225(class_1893.field_9131)) continue;
            return entry.getIntValue();
        }
        return 0;
    }

    private void nvw(class_746 class_7462, int n) {
        class_1661 class_16612 = class_7462.method_31548();
        if (n == -2) {
            this.nvx(class_16612);
            return;
        }
        if (this.nve < 0) {
            this.nve = class_16612.method_67532();
        }
        if (this.nvg >= 0 && this.nvz(class_16612)) {
            InventoryClicks.click(this.mc, this.nvg, this.nve);
            if (n == this.nvg) {
                this.nvg = -1;
                this.nvh = class_1799.field_8037;
                InventoryClicks.close(this.mc);
                this.nvy(class_16612, this.nve);
                return;
            }
        }
        this.nvh = class_16612.method_5438(this.nve).method_7972();
        InventoryClicks.click(this.mc, n, this.nve);
        this.nvg = n;
        InventoryClicks.close(this.mc);
        this.nvy(class_16612, this.nve);
    }

    private void nvx(class_1661 class_16612) {
        if (this.nvg >= 0 && this.nvz(class_16612)) {
            InventoryClicks.swap(this.mc, this.nvg, this.nve);
        }
        if (!this.nvi && this.nve >= 0 && class_16612.method_67532() == this.nvf && this.nvf != this.nve) {
            class_16612.method_61496(this.nve);
        }
        this.nwd();
    }

    private void nvy(class_1661 class_16612, int n) {
        if (this.nve < 0) {
            this.nve = class_16612.method_67532();
        }
        if (class_16612.method_67532() != n) {
            class_16612.method_61496(n);
        }
        this.nvf = n;
    }

    private boolean nvz(class_1661 class_16612) {
        return class_1799.method_31577((class_1799)class_16612.method_5438(this.nvg), (class_1799)this.nvh);
    }

    private void nwa(class_746 class_7462) {
        this.nvc.hold(this.mc);
        class_304 class_3042 = this.mc.field_1690.field_1886;
        while (class_3042.method_1436()) {
            this.nvm = true;
        }
        class_3042.method_23481(false);
        this.nvl = true;
        if (class_7462.method_6115()) {
            this.mc.field_1761.method_2897((class_1657)class_7462);
        }
    }

    private void nwb() {
        if (this.nvl) {
            this.nvl = false;
            if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
                class_3675.class_306 class_3062;
                class_304 class_3042 = this.mc.field_1690.field_1886;
                class_3042.method_23481(KeyUtil.isPhysicallyDown(this.mc, class_3042));
                if (this.nvm && !(class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3042)).equals((Object)class_3675.field_16237)) {
                    class_304.method_1420((class_3675.class_306)class_3062);
                }
            }
        }
        this.nvm = false;
    }

    private void nwc() {
        if (this.nvc.isHeld()) {
            this.nvc.release(this.mc);
        }
        this.nwb();
        this.nvk = -1;
        this.nvn = 0;
    }

    private void nwd() {
        this.nwc();
        this.nve = -1;
        this.nvf = -1;
        this.nvg = -1;
        this.nvh = class_1799.field_8037;
        this.nvi = false;
    }

    private boolean nwe(class_746 class_7462) {
        return IdleTracker.serverIdle(class_7462) && !class_7462.method_6115() && (this.mc.field_1761 == null || !this.mc.field_1761.method_2923());
    }

    private static boolean nwf(class_746 class_7462) {
        boolean bl;
        boolean bl2 = bl = class_7462.method_5715() || IdleTracker.lastSent(class_7462).comp_3164();
        if (!bl || !class_7462.method_24828()) {
            return false;
        }
        class_238 class_2383 = class_7462.method_5829();
        class_243 class_2432 = class_7462.method_18798();
        double d = class_7462.method_49476();
        class_238 class_2384 = new class_238(class_2383.field_1323 + class_2432.field_1352 + 1.0E-7, class_2383.field_1322 - d - 1.0E-7, class_2383.field_1321 + class_2432.field_1350 + 1.0E-7, class_2383.field_1320 + class_2432.field_1352 - 1.0E-7, class_2383.field_1322, class_2383.field_1324 + class_2432.field_1350 - 1.0E-7);
        return class_7462.method_73183().method_8587((class_1297)class_7462, class_2384);
    }

    private static /* synthetic */ int bdf(int n, int n2) {
        return n * n2 ^ 0xBCCD37E6;
    }

    private static /* synthetic */ int bdg(int n, int n2) {
        return n + n2 ^ 0x2EDEAA47;
    }

    private static /* synthetic */ int bdh(int n, int n2) {
        return AutoMend.bdg(n, n2) + n;
    }
}

