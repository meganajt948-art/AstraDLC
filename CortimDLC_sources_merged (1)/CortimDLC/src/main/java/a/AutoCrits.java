/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_12392
 *  net.minecraft.class_1268
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3489
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_746
 *  net.minecraft.class_9334
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.AutoMace;
import a.JumpPhysics;
import a.CritSimulator;
import a.KeyPearl;
import a.AncientFarmer;
import a.NoJumpDelay;
import a.AutoMines;
import a.AutoMend;
import a.ServerHelper;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Reflect;
import a.ForwardKeyHold;
import a.SwingCounter;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_12392;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3489;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_746;
import net.minecraft.class_9334;

public class AutoCrits
extends Module {
    private final ModeSetting lgd = this.add(new ModeSetting("Crits", "Smart", "Smart", "Off"));
    private final BoolSetting lge = this.add(new BoolSetting("Predict", true));
    private final BoolSetting lgf = this.add(new BoolSetting("Sprint reset", true));
    private final BoolSetting lgg = this.add(new BoolSetting("MaceSmash", true));
    private final NumberSetting lgh = this.add(new NumberSetting("Reaction", 0.0, 0.0, 500.0, 10.0).suffix("ms"));
    private final NumberSetting lgi = this.add(new NumberSetting("Delay", 0.0, 0.0, 10.0, 1.0).suffix("ticks"));
    private final NumberSetting lgj = this.add(new NumberSetting("Distance", 3.0, 2.5, 3.0, 0.05));
    private final BoolSetting lgk = this.add(new BoolSetting("Players", true));
    private final BoolSetting lgl = this.add(new BoolSetting("Mobs", true));
    private final BoolSetting lgm = this.add(new BoolSetting("Through friends", true));
    private static final float lgn = 0.9f;
    private static final double lgo = 1.5;
    private static final int lgp = 2;
    private static final int lgq = 10;
    private static final int lgr = 2;
    private static final int lgs = 14;
    private static final int lgt = 18;
    private static final int lgu = 30;
    private static final int lgv = 4;
    private static final int lgw = 26;
    private static final int lgx = 2;
    private static final int lgy = 7;
    private static final double lgz = 0.16;
    private static final int lha = 10;
    private static final double lhb = 0.6;
    private static final double lhc = 0.766;
    private static final double lhd = 0.1;
    private static final double lhe = 1.5;
    private static final double lhf = 0.1;
    private static final Field lhg = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1771", "I");
    private static final Field lhh = Reflect.find(class_1309.class, "net.minecraft.class_1309", "field_6228", "I");
    private static final Field lhi = Reflect.find(class_304.class, "net.minecraft.class_304", "field_1661", "I");
    private static AutoCrits lhj;
    private final ForwardKeyHold lhk = new ForwardKeyHold();
    private final CritSimulator lhl = new CritSimulator();
    private int lhm;
    private int lhn;
    private int lho;
    private int lhp;
    private int lhq = 1;
    private int lhr;
    private int lhs;
    private int lht;
    private boolean lhu;
    private class_1297 lhv;
    private int lhw = 10;
    private class_1297 lhx;
    private class_243 lhy;
    private int lhz = 1000;
    private int lia;
    private boolean lib;
    private boolean lic;
    private boolean lid;
    private int lie;
    private boolean lif = true;
    private boolean lig;
    private int lih;
    private int lii = -1000;
    private boolean lij;
    private int lik = -1000;
    private double lil = 2.0;
    private static /* synthetic */ int lim;
    private static /* synthetic */ boolean lin;

    public AutoCrits() {
        super("TriggerBot", "Hits the target under your crosshair", ModuleCategory.COMBAT);
        lhj = this;
        this.lge.visibleWhen(() -> this.lgd.is("Smart"));
    }

    static boolean moduleOn() {
        return lhj != null && lhj.isEnabled();
    }

    @Override
    protected void onEnable() {
        if (this.mc.field_1724 != null) {
            this.lhl.sync(this.mc.field_1724);
            this.lic = ForwardKeyHold.serverSprinting(this.mc.field_1724);
        }
        this.lia = SwingCounter.count();
        this.lhz = 1000;
        this.lib = false;
        this.lid = false;
        this.lie = 0;
        this.lht = 0;
        this.lii = -1000;
        this.lik = -1000;
        this.lhp = AutoCrits.liy();
        this.lhq = AutoCrits.liz();
        this.ljr();
    }

    @Override
    protected void onDisable() {
        this.liu(this.mc);
        this.ljr();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        this.lhl.afterMove(class_7462, (class_1937)class_3102.field_1687);
        boolean bl = ForwardKeyHold.serverSprinting(class_7462);
        if (bl != this.lic) {
            this.lic = bl;
            this.lib = false;
        }
        boolean bl2 = class_7462.method_24828();
        if (this.lif && !bl2 && this.lig && class_7462.method_23318() > class_7462.field_6036 + 1.0E-4) {
            if (this.lik > this.lii) {
                this.lil = this.lil * 0.7 + (double)Math.min(10, this.lhm - this.lik) * 0.3;
            }
            this.lii = this.lhm;
            this.lij = this.lhu || (this.lht & 1) != 0;
        } else if (!this.lif && bl2) {
            this.lik = this.lhm;
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        boolean bl;
        class_746 class_7462 = class_3102.field_1724;
        ++this.lhm;
        if (this.lhn > 0) {
            --this.lhn;
        }
        if (this.lhw < 10) {
            ++this.lhw;
        }
        SwingCounter.ensure(class_3102);
        int n = SwingCounter.count();
        if (n != this.lia) {
            this.lia = n;
            this.lhz = 1;
        } else if (this.lhz < 1000) {
            ++this.lhz;
        }
        boolean bl2 = class_7462.method_24828();
        this.lih = bl2 ? Math.min(this.lih + 1, 1000) : 0;
        this.lif = bl2;
        this.lig = class_3102.field_1690.field_1903.method_1434();
        class_3102.field_1773.method_3190(1.0f);
        if (this.ljq(class_3102, class_7462)) {
            this.liu(class_3102);
            this.ljr();
            return;
        }
        class_1297 class_12972 = this.ljt(class_3102);
        boolean bl3 = class_12972 != null || this.ljb(class_3102, class_7462);
        this.lhu = Integer.bitCount(this.lht) >= 2;
        this.lht = (this.lht << 1 | (bl3 ? 1 : 0)) & 0xFFFF;
        boolean bl4 = this.lji(class_12972);
        boolean bl5 = this.lgg.get() && class_7462.method_6047().method_31574(class_1802.field_49814);
        boolean bl6 = ForwardKeyHold.serverSprinting(class_7462) && !this.lib;
        boolean bl7 = this.lgf.get();
        boolean bl8 = this.lgd.is("Smart") && !bl5 && this.ljo(class_3102, class_7462) && (bl7 || !bl6);
        this.lhl.predict(class_7462, (class_1937)class_3102.field_1687, class_3102.field_1690.field_1903.method_1434(), Reflect.getInt(lhh, class_7462, 0), NoJumpDelay.active());
        int n2 = bl8 ? this.lio(class_7462, bl6) : -1;
        boolean bl9 = bl8 && this.lge.get() && this.lip(class_3102, class_7462, bl2);
        boolean bl10 = bl = class_12972 != null && bl4 && this.lhn == 0;
        if (bl) {
            class_243 class_2432 = this.lhx != null ? this.lhy : class_3102.field_1765.method_17784();
            AutoCrits.ljj(class_3102);
            bl = AutoCrits.ljk(class_3102, class_7462, class_2432) && class_7462.method_33571().method_1025(class_2432) <= this.lgj.get() * this.lgj.get();
        }
        boolean bl11 = this.liv(class_7462, 0);
        if (bl && bl11) {
            ++this.lho;
        }
        boolean bl12 = false;
        if (bl) {
            if (bl5) {
                bl12 = !this.ljm(class_12972) && this.ljn(class_3102, class_7462) && this.lhl.airAt(0) && this.lhl.fallAt(0) > 1.5 && (bl11 || this.lhl.landsWithin(0, 2));
            } else if (!bl8) {
                bl12 = bl11 && this.lis(class_7462) && this.lie == 0;
            } else if (n2 == 0) {
                bl12 = true;
            } else if (bl11) {
                boolean bl13;
                boolean bl14 = !this.lja(class_7462, class_12972, n2 < 0 ? 4 : n2) && !this.ljc(class_7462, class_12972);
                boolean bl15 = n2 > 0 && (n2 <= 1 || this.lhu) && n2 <= 14 && bl14;
                boolean bl16 = n2 < 0 && bl9 && this.lhu && bl14;
                boolean bl17 = bl13 = this.lho <= 18 || this.lho <= 30 && bl9 && !bl6 && this.lhl.serverGroundAt(0);
                if ((bl15 || bl16) && bl13) {
                    bl12 = false;
                } else if (this.lie != 0) {
                    bl12 = false;
                } else if (this.lir(class_3102, class_7462, bl7) && this.lhu && !this.lja(class_7462, class_12972, 2)) {
                    this.lie = 1;
                } else {
                    boolean bl18 = bl12 = this.lis(class_7462) || this.lho > 18;
                }
            }
        }
        if (!(bl12 || this.lie != 0 || this.lid || bl5 || !this.lir(class_3102, class_7462, bl7) || n2 >= 0 || bl9 || !this.liv(class_7462, 2) || this.liv(class_7462, 1) || class_12972 == null && !this.lhu)) {
            this.lie = 1;
        }
        if (this.lid) {
            this.lid = bl8 && bl7 && n2 >= 0 && n2 <= Math.max(this.lhq, 1) && (class_12972 != null || this.lhu || n2 <= 1 && this.ljd(class_3102, class_7462));
        } else if (bl8 && bl7 && bl6 && n2 >= 1 && n2 <= this.lhq && this.lie == 0) {
            boolean bl19 = this.lid = class_12972 != null || this.lhu || this.lge.get() && this.ljd(class_3102, class_7462);
        }
        if (bl12) {
            this.lit(class_3102, class_7462, class_12972);
            this.lid = false;
        }
        if (this.lid || this.lie == 1) {
            this.lhk.hold(class_3102);
        } else {
            this.lhk.release(class_3102);
        }
        if (this.lie == 1) {
            this.lie = 2;
        } else if (this.lie == 2) {
            this.lie = 0;
        }
    }

    private int lio(class_746 class_7462, boolean bl) {
        int n = bl ? 1 : 0;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        for (int i = n; i <= 20; ++i) {
            if (i == 20 || i > n && this.lhl.airAt(i - 1) && !this.lhl.airAt(i)) {
                if (n2 >= 0) {
                    return n2;
                }
                if (n4 < 0 && i != 20) continue;
                return n4;
            }
            if (!this.lhl.critAt(i) || !this.liv(class_7462, i)) continue;
            if (!this.lhl.safeAt(i)) {
                if (n4 >= 0) continue;
                n4 = i;
                continue;
            }
            if (n2 < 0) {
                n2 = i;
                if (!(this.liw(class_7462, i) >= 1.0f)) continue;
                return i;
            }
            if (n3 >= 0) {
                return n3;
            }
            if (!(this.liw(class_7462, i) >= 1.0f)) continue;
            n3 = i;
        }
        return -1;
    }

    private boolean lip(class_310 class_3102, class_746 class_7462, boolean bl) {
        if (!this.lij || this.lhm - this.lii > 26 || class_7462.method_5715() || class_7462.method_5799() || bl && this.lih > this.liq()) {
            return false;
        }
        return JumpPhysics.headroom(class_7462, (class_1937)class_3102.field_1687, 0.16) >= 0.16;
    }

    private int liq() {
        return class_3532.method_15340((int)((int)Math.ceil(this.lil) + 2), (int)2, (int)7);
    }

    private boolean lir(class_310 class_3102, class_746 class_7462, boolean bl) {
        return this.lib && bl && class_7462.method_5624() && !ForwardKeyHold.anyHeld() && (!class_7462.method_24828() || !class_3102.field_1690.field_1903.method_1434());
    }

    private boolean lis(class_746 class_7462) {
        return !this.lhu || this.liw(class_7462, -this.lhp) >= 1.0f;
    }

    private void lit(class_310 class_3102, class_746 class_7462, class_1297 class_12972) {
        block5: {
            block6: {
                if (!ForwardKeyHold.serverSprinting(class_7462) || this.lib || !this.liv(class_7462, 0)) break block5;
                if (!(class_12972 instanceof class_1309)) break block6;
                class_1309 class_13092 = (class_1309)class_12972;
                if (class_13092.field_6235 > 0 || class_13092.method_6039()) break block5;
            }
            this.lib = true;
        }
        if (this.lhx != null) {
            class_3102.field_1761.method_2918((class_1657)class_7462, this.lhx);
            class_7462.method_6104(class_1268.field_5808);
        } else {
            AutoCrits.lix(class_3102);
        }
        this.lhv = class_12972;
        this.lhw = 0;
        this.lho = 0;
        this.lhn = this.lgi.getInt();
        this.lhp = AutoCrits.liy();
        this.lhq = AutoCrits.liz();
    }

    private void liu(class_310 class_3102) {
        this.lhk.release(class_3102);
        this.lid = false;
        this.lie = 0;
    }

    private boolean liv(class_746 class_7462, int n) {
        return this.liw(class_7462, n) > 0.9f;
    }

    private float liw(class_746 class_7462, int n) {
        float f = class_3532.method_15363((float)(((float)this.lhz + 0.5f + (float)n) / class_7462.method_7279()), (float)0.0f, (float)1.0f);
        return Math.min(class_7462.method_7261(0.5f + (float)n), f);
    }

    private static void lix(class_310 class_3102) {
        class_304 class_3042 = class_3102.field_1690.field_1886;
        int n = Reflect.getInt(lhi, class_3042, -1);
        if (n > 0) {
            return;
        }
        if (n == 0 && Reflect.setInt(lhi, class_3042, 1)) {
            return;
        }
        class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3042);
        if (!class_3062.equals((Object)class_3675.field_16237)) {
            class_304.method_1420((class_3675.class_306)class_3062);
        }
    }

    private static int liy() {
        return ThreadLocalRandom.current().nextDouble() < 0.2 ? 1 : 0;
    }

    private static int liz() {
        return ThreadLocalRandom.current().nextDouble() < 0.3 ? 2 : 1;
    }

    private boolean lja(class_746 class_7462, class_1297 class_12972, int n) {
        int n2 = Math.min(n, 4);
        double d = Math.min(AutoCrits.ljl(class_7462), this.lgj.get());
        class_243 class_2432 = class_7462.method_33571().method_1019(this.lhl.offsetAt(n2));
        class_238 class_2383 = class_12972.method_5829().method_989((class_12972.method_23317() - class_12972.field_6014) * (double)n2, 0.0, (class_12972.method_23321() - class_12972.field_5969) * (double)n2);
        return class_2383.method_49271(class_2432) > d * d;
    }

    private boolean ljb(class_310 class_3102, class_746 class_7462) {
        double d = Math.min(AutoCrits.ljl(class_7462), this.lgj.get()) + 1.5;
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(d));
        class_243 class_2434 = AutoCrits.ljg(class_3102, class_7462, class_2432, class_2433);
        for (class_1297 class_12973 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0), class_12972 -> this.ljv(class_3102, (class_1297)class_12972))) {
            if (!AutoCrits.ljh(class_12973.method_5829().method_1014((double)class_12973.method_5871()), class_2432, class_2433, class_2434)) continue;
            return true;
        }
        return false;
    }

    private boolean ljc(class_746 class_7462, class_1297 class_12972) {
        float f = 2.0f * class_7462.method_36454() - class_7462.field_5982;
        float f2 = class_3532.method_15363((float)(2.0f * class_7462.method_36455() - class_7462.field_6004), (float)-90.0f, (float)90.0f);
        class_243 class_2432 = class_7462.method_33571().method_1019(this.lhl.offsetAt(1));
        class_243 class_2433 = class_2432.method_1019(class_243.method_1030((float)f2, (float)f).method_1021(Math.min(AutoCrits.ljl(class_7462), this.lgj.get())));
        class_238 class_2383 = class_12972.method_5829().method_989(class_12972.method_23317() - class_12972.field_6014, class_12972.method_23318() - class_12972.field_6036, class_12972.method_23321() - class_12972.field_5969).method_1014((double)class_12972.method_5871() + 0.1);
        return !class_2383.method_1006(class_2432) && class_2383.method_992(class_2432, class_2433).isEmpty();
    }

    private boolean ljd(class_310 class_3102, class_746 class_7462) {
        return this.lje(class_3102, class_7462) || this.ljf(class_3102, class_7462);
    }

    private boolean lje(class_310 class_3102, class_746 class_7462) {
        double d = Math.min(AutoCrits.ljl(class_7462), this.lgj.get()) + 0.6;
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_7462.method_5828(1.0f);
        for (class_1297 class_12973 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0), class_12972 -> this.ljv(class_3102, (class_1297)class_12972))) {
            class_238 class_2383 = class_12973.method_5829();
            if (class_2383.method_49271(class_2432) > d * d || !(class_2383.method_1005().method_1020(class_2432).method_1029().method_1026(class_2433) >= 0.766)) continue;
            return true;
        }
        return false;
    }

    private boolean ljf(class_310 class_3102, class_746 class_7462) {
        double d = AutoCrits.ljl(class_7462);
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(d));
        float f = class_3532.method_15363((float)(2.0f * class_7462.method_36455() - class_7462.field_6004), (float)-90.0f, (float)90.0f);
        float f2 = 2.0f * class_7462.method_36454() - class_7462.field_5982;
        class_243 class_2434 = class_2432.method_1019(class_243.method_1030((float)f, (float)f2).method_1021(d));
        class_243 class_2435 = AutoCrits.ljg(class_3102, class_7462, class_2432, class_2433);
        class_243 class_2436 = AutoCrits.ljg(class_3102, class_7462, class_2432, class_2434);
        for (class_1297 class_12973 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 2.0), class_12972 -> this.ljv(class_3102, (class_1297)class_12972))) {
            class_238 class_2383 = class_12973.method_5829();
            class_238 class_2384 = class_2383.method_991(class_2383.method_989(class_12973.method_23317() - class_12973.field_6014, class_12973.method_23318() - class_12973.field_6036, class_12973.method_23321() - class_12973.field_5969)).method_1014(0.1);
            if (!AutoCrits.ljh(class_2384, class_2432, class_2433, class_2435) && !AutoCrits.ljh(class_2384, class_2432, class_2434, class_2436)) continue;
            return true;
        }
        return false;
    }

    private static class_243 ljg(class_310 class_3102, class_746 class_7462, class_243 class_2432, class_243 class_2433) {
        class_3965 class_39652 = class_3102.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        return class_39652.method_17783() == class_239.class_240.field_1333 ? class_2433 : class_39652.method_17784();
    }

    private static boolean ljh(class_238 class_2383, class_243 class_2432, class_243 class_2434, class_243 class_2435) {
        if (class_2383.method_1006(class_2432)) {
            return true;
        }
        double d = class_2432.method_1025(class_2435);
        return class_2383.method_992(class_2432, class_2434).filter(class_2433 -> class_2432.method_1025(class_2433) <= d).isPresent();
    }

    private boolean lji(class_1297 class_12972) {
        if (class_12972 == null) {
            if (++this.lhs > 2) {
                this.lhr = 0;
                this.lho = 0;
            }
            return false;
        }
        this.lhs = 0;
        return (long)this.lhr++ * 50L >= (long)this.lgh.get();
    }

    private static void ljj(class_310 class_3102) {
        if (Reflect.getInt(lhg, class_3102, 0) > 10) {
            Reflect.setInt(lhg, class_3102, 0);
        }
    }

    private static boolean ljk(class_310 class_3102, class_746 class_7462, class_243 class_2432) {
        if (Reflect.getInt(lhg, class_3102, 0) > 0) {
            return false;
        }
        class_1799 class_17992 = class_7462.method_6047();
        if (class_7462.method_75202(class_17992, 0)) {
            return false;
        }
        class_12392 class_123922 = (class_12392)class_17992.method_58694(class_9334.field_64680);
        return class_123922 == null || class_123922.method_76736((class_1309)class_7462, class_2432);
    }

    private static double ljl(class_746 class_7462) {
        class_12392 class_123922 = (class_12392)class_7462.method_6047().method_58694(class_9334.field_64680);
        return class_123922 != null ? (double)class_123922.method_76739((class_1297)class_7462) : class_7462.method_55755();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean ljm(class_1297 class_12972) {
        if (class_12972 instanceof class_1309) {
            class_1309 class_13092 = (class_1309)class_12972;
            if (class_13092.field_6235 > 0) return true;
        }
        if (class_12972 != this.lhv) return false;
        if (this.lhw >= 10) return false;
        return true;
    }

    private boolean ljn(class_310 class_3102, class_746 class_7462) {
        return !class_7462.method_6101() && !class_7462.method_5799() && !class_7462.method_5771() && !class_7462.method_5765() && !class_7462.method_6128() && !class_7462.method_31549().field_7479 && !class_7462.field_27857 && !class_7462.method_6059(class_1294.field_5902) && !class_7462.method_6059(class_1294.field_5906) && class_3102.field_1687.method_29546(class_7462.method_5829().method_1011(1.0E-7)).noneMatch(AutoCrits::ljp);
    }

    private boolean ljo(class_310 class_3102, class_746 class_7462) {
        return !class_7462.method_6059(class_1294.field_5919) && this.ljn(class_3102, class_7462);
    }

    private static boolean ljp(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10343) || class_26802.method_27852(class_2246.field_16999) || class_26802.method_27852(class_2246.field_27879);
    }

    private boolean ljq(class_310 class_3102, class_746 class_7462) {
        return class_3102.field_1755 != null || class_7462.method_7325() || !class_7462.method_5805() || class_7462.method_6115() || class_7462.method_3144() || this.ljs(class_3102) || ServerHelper.busy() || KeyPearl.busy() || AutoMend.busy() && !AutoCrits.ljw(class_7462) || AutoMace.busy() || AutoMines.busy() || AncientFarmer.busy();
    }

    private void ljr() {
        this.lhr = 0;
        this.lhs = 0;
        this.lho = 0;
        this.lht = 0;
    }

    private boolean ljs(class_310 class_3102) {
        if (class_3102.field_1761 != null && class_3102.field_1761.method_2923()) {
            return true;
        }
        return class_3102.field_1690.field_1886.method_1434() && class_3102.field_1765 != null && class_3102.field_1765.method_17783() == class_239.class_240.field_1332;
    }

    private class_1297 ljt(class_310 class_3102) {
        this.lhx = null;
        class_239 class_2392 = class_3102.field_1765;
        if (class_2392 == null || class_2392.method_17783() != class_239.class_240.field_1331) {
            return null;
        }
        class_1297 class_12972 = ((class_3966)class_2392).method_17782();
        if (this.ljv(class_3102, class_12972)) {
            return class_12972;
        }
        if (this.lgm.get() && class_12972 instanceof class_1657 && Friends.isFriend(class_12972)) {
            this.lhx = this.lju(class_3102, class_3102.field_1724);
            return this.lhx;
        }
        return null;
    }

    private class_1297 lju(class_310 class_3102, class_746 class_7462) {
        double d = AutoCrits.ljl(class_7462);
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(d));
        double d2 = class_2432.method_1025(AutoCrits.ljg(class_3102, class_7462, class_2432, class_2433));
        class_1297 class_12973 = null;
        double d3 = Double.MAX_VALUE;
        for (class_1297 class_12974 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0), class_12972 -> this.ljv(class_3102, (class_1297)class_12972))) {
            double d4;
            class_238 class_2383 = class_12974.method_5829().method_1014((double)class_12974.method_5871());
            class_243 class_2434 = class_2383.method_1006(class_2432) ? class_2432 : (class_243)class_2383.method_992(class_2432, class_2433).orElse(null);
            if (class_2434 == null || !((d4 = class_2432.method_1025(class_2434)) <= d2) || !(d4 < d3)) continue;
            class_12973 = class_12974;
            d3 = d4;
            this.lhy = class_2434;
        }
        return class_12973;
    }

    private boolean ljv(class_310 class_3102, class_1297 class_12972) {
        class_1309 class_13092;
        if (class_12972 == null || class_12972 == class_3102.field_1724) {
            return false;
        }
        if (!(class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_5805() && class_12972.method_5732())) {
            return false;
        }
        if (class_12972 instanceof class_1657) {
            return this.lgk.get() && !Friends.protects(class_12972);
        }
        return this.lgl.get();
    }

    private static boolean ljw(class_746 class_7462) {
        class_1799 class_17992 = class_7462.method_6047();
        return class_17992.method_31573(class_3489.field_42611) || class_17992.method_31573(class_3489.field_42612) || class_17992.method_31574(class_1802.field_49814) || class_17992.method_31574(class_1802.field_8547);
    }

    private static /* synthetic */ int awr(int n, int n2) {
        return n * n2 + -2053724126;
    }
}

