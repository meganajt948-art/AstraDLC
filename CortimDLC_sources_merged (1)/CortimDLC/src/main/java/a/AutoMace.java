/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_12392
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3966
 *  net.minecraft.class_746
 *  net.minecraft.class_9334
 *  net.minecraft.class_9362
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.KeyPearl;
import a.AimPointPicker;
import a.SmashPredictor;
import a.LandingTracker;
import a.AimDriver;
import a.lpc;
import a.lpp;
import a.PathAimPlanner;
import a.AutoMend;
import a.FreeCam;
import a.ServerHelper;
import a.AimModel;
import a.BoolSetting;
import a.NumberSetting;
import a.Reflect;
import a.IdleTracker;
import a.InventoryClicks;
import a.ForwardKeyHold;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_12392;
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_3966;
import net.minecraft.class_746;
import net.minecraft.class_9334;
import net.minecraft.class_9362;

public class AutoMace
extends Module {
    private static final int kmz = 10;
    private static final int kna = 1;
    private static final int knb = 3;
    private static final double knc = 0.05;
    private static final boolean knd = true;
    private static final int kne = 3;
    private static final Field knf = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1771", "I");
    private static AutoMace kng;
    private final NumberSetting knh = this.add(new NumberSetting("Скорость", 1.0, 0.3, 1.6, 0.05).percent());
    private final NumberSetting kni = this.add(new NumberSetting("Разброс", 0.6, 0.0, 0.9, 0.05).percent());
    private final NumberSetting knj = this.add(new NumberSetting("Дистанция", 3.0, 2.0, 3.0, 0.05).suffix("m"));
    private final NumberSetting knk = this.add(new NumberSetting("Мин. высота удара", 3.0, 1.5, 40.0, 0.5).suffix("m"));
    private final NumberSetting knl = this.add(new NumberSetting("Макс. высота удара", 40.0, 2.0, 60.0, 0.5).suffix("m"));
    private final BoolSetting knm = this.add(new BoolSetting("Криты", true));
    private final BoolSetting knn = this.add(new BoolSetting("Свап на булаву", true));
    private final BoolSetting kno = this.add(new BoolSetting("Вернуть слот", true));
    private final BoolSetting knp = this.add(new BoolSetting("Булава после заряда", true));
    private final BoolSetting knq = this.add(new BoolSetting("Булава в падении", false));
    private final BoolSetting knr = this.add(new BoolSetting("Игроки", true));
    private final BoolSetting kns = this.add(new BoolSetting("Мобы", false));
    private final LandingTracker knt = new LandingTracker();
    private final PathAimPlanner knu = new PathAimPlanner();
    private final AimDriver knv = new AimDriver();
    private final ForwardKeyHold knw = new ForwardKeyHold();
    private final Random knx = new Random();
    private lpp kny;
    private class_1309 knz;
    private int koa = 10;
    private int kob = -1;
    private int koc = -1;
    private int kod;
    private String koe = "-";
    private static final int kof = 0;
    private static final int kog = 1;
    private static final int koh = 2;
    private static class_1799 koi;
    private final IdleTracker koj = new IdleTracker();
    private boolean kok;
    private boolean kol;
    private int kom = -1;
    private int kon = -1;
    private int koo = 0;
    private boolean kop;
    private boolean koq;
    private int kor;
    private long kos;
    private boolean kot;
    private final IdleTracker kou = new IdleTracker();
    private boolean kov;
    private boolean kow;
    private int kox = -1;
    private int koy = -1;
    private int koz;
    private static /* synthetic */ String kpa;
    private static /* synthetic */ String kpb;

    public AutoMace() {
        super("AutoMace", "Mace smash timed to your fall", ModuleCategory.COMBAT);
        kng = this;
        this.kno.visibleWhen(this.knn::get);
        this.knq.visibleWhen(this.knn::get);
    }

    public static boolean busy() {
        return kng != null && kng.isEnabled() && (AutoMace.kng.kny != null || !AutoMace.kng.knv.idle());
    }

    public static boolean takesWindMace() {
        return kng != null && kng.isEnabled() && AutoMace.kng.knp.get();
    }

    public static int strikes() {
        return kng == null ? 0 : AutoMace.kng.kod;
    }

    public static String debug() {
        if (kng == null) {
            return "off";
        }
        lpp lpp2 = AutoMace.kng.kny;
        class_746 class_7462 = class_310.method_1551().field_1724;
        String string = class_7462 == null ? "" : String.format(Locale.ROOT, " view=%.1f/%.1f", Float.valueOf(AutoMace.kng.knv.serverYaw(class_7462)), Float.valueOf(AutoMace.kng.knv.serverPitch(class_7462)));
        return (lpp2 == null ? "plan=none" : "plan=" + lpp2.tick() + (lpp2.crit() ? "c" : "") + " target=" + lpp2.target().method_5628() + String.format(Locale.ROOT, " aim=%.1f/%.1f", Float.valueOf(lpp2.yaw()), Float.valueOf(lpp2.pitch()))) + string + " miss=" + AutoMace.kng.koe + " offset=" + String.format(Locale.ROOT, "%.1f", AutoMace.kng.knv.offset()) + " fall=" + String.format(Locale.ROOT, "%.2f", AutoMace.kng.knt.get()) + " strikes=" + AutoMace.kng.kod;
    }

    @Override
    protected void onEnable() {
        this.knt.reset();
        this.kny = null;
        this.knu.forget();
        this.knv.reset();
        this.koa = 10;
        this.kob = -1;
        this.koc = -1;
        this.kol = false;
        this.kom = -1;
        this.koo = 0;
        this.kok = this.mc.field_1724 != null && AutoMace.kpg(this.mc.field_1724);
        this.kot = false;
        this.kox = -1;
        this.kow = false;
    }

    @Override
    protected void onDisable() {
        this.knv.end(this.mc.field_1724);
        this.knv.reset();
        this.knw.release(this.mc);
        this.kny = null;
        this.knu.forget();
        this.kob = -1;
        if (this.kop) {
            this.koj.release(this.mc);
            this.kop = false;
        }
        this.kol = false;
        this.kom = -1;
        this.koo = 0;
        if (this.mc.field_1724 != null) {
            this.kpe(this.mc, this.mc.field_1724, true);
        }
        this.kow = false;
        if (this.kov) {
            this.kou.release(this.mc);
            this.kov = false;
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        lpp lpp2;
        class_746 class_7462 = class_3102.field_1724;
        if (this.koo != 0 && !this.kop) {
            this.koj.hold(class_3102);
            this.kop = true;
        }
        if (this.kow && !this.kov && !this.kop && class_7462 != null) {
            this.kou.hold(class_3102);
            this.kov = true;
            this.koz = 0;
        }
        this.knv.mode(true, class_7462);
        this.knv.begin(class_7462);
        if (this.koa < 10) {
            ++this.koa;
        }
        if ((lpp2 = this.kny) == null || lpp2.tick() > 1) {
            this.kpo(class_7462);
        }
        if (lpp2 == null || !this.kpq(class_3102, class_7462)) {
            this.knw.release(class_3102);
            return;
        }
        if (lpp2.crit() && lpp2.tick() <= 1) {
            this.knw.hold(class_3102);
        } else {
            this.knw.release(class_3102);
        }
        if (lpp2.tick() == 0) {
            this.kpl(class_3102, class_7462, lpp2);
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        this.kpc(class_3102, class_7462);
        this.kpd(class_3102, class_7462);
    }

    private void kpc(class_310 class_3102, class_746 class_7462) {
        class_238 class_2383;
        this.kph(class_3102, class_7462);
        this.knv.end(class_7462);
        this.knv.newTick(class_7462);
        this.knt.update(class_7462);
        if (class_7462.method_24828()) {
            this.kot = false;
        }
        this.knv.use(AimModel.profile1(), this.knh.get());
        if (!this.kpq(class_3102, class_7462)) {
            this.kny = null;
            this.knu.forget();
            if (!class_7462.method_5805()) {
                this.knv.forget();
            } else {
                this.kpn(class_3102, class_7462);
            }
            return;
        }
        double d = this.kpt(class_7462);
        lpc lpc2 = new lpc(d, this.knm.get(), ForwardKeyHold.serverSprinting(class_7462), true, this.kni.get(), this.knv.serverYaw(class_7462), this.knv.serverPitch(class_7462), this.knv.maxTurn(), this.knk.get(), Math.max(this.knl.get(), this.knk.get() + 0.5));
        this.kny = this.knu.plan(class_7462, (class_1937)class_3102.field_1687, this.knt.get(), this.kpu(class_3102, class_7462, d), this::kpp, lpc2);
        this.kpi(class_7462);
        if (this.kny == null) {
            this.kpn(class_3102, class_7462);
            return;
        }
        class_238 class_2384 = class_2383 = this.kny.tick() <= 3 ? this.kny.box() : this.kny.target().method_5829();
        if (!this.knv.approach(class_3102, class_7462, this.kny, class_2383)) {
            this.kpn(class_3102, class_7462);
        }
    }

    private void kpd(class_310 class_3102, class_746 class_7462) {
        boolean bl;
        if (class_7462 == null) {
            return;
        }
        if (this.kov) {
            ++this.koz;
        }
        if (!(this.kox < 0 || this.kny != null && this.kny.tick() <= 1 && this.koz <= 8 && class_7462.method_5805())) {
            this.kpe(class_3102, class_7462, false);
        }
        this.kow = bl = this.kox < 0 && this.knn.get() && this.kny != null && this.kny.tick() <= 2 && class_7462.method_5805() && this.kpr(class_7462) < 0 && AutoMace.kpf(class_7462) >= 0 && this.koo == 0;
        if (this.kov && this.kox < 0 && (!bl || this.koz > 8)) {
            this.kou.release(class_3102);
            this.kov = false;
        }
    }

    private void kpe(class_310 class_3102, class_746 class_7462, boolean bl) {
        if (this.kox < 0) {
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (class_7462.method_5805() && AutoMace.kps(class_16612.method_5438(this.koy)) && InventoryClicks.canClick(class_7462) && class_3102.field_1755 == null && (bl || IdleTracker.serverIdle(class_7462))) {
            InventoryClicks.swap(class_3102, this.kox, this.koy);
        }
        this.kox = -1;
        this.koy = -1;
    }

    private static int kpf(class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        for (int i = 9; i < 36; ++i) {
            if (!AutoMace.kps(class_16612.method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private static boolean kpg(class_746 class_7462) {
        if (koi == null) {
            koi = new class_1799((class_1935)class_1802.field_49098);
        }
        return class_7462.method_7357().method_7904(koi);
    }

    private void kph(class_310 class_3102, class_746 class_7462) {
        boolean bl;
        if (this.kop) {
            if (class_7462.method_5805() && InventoryClicks.canClick(class_7462) && IdleTracker.serverIdle(class_7462) && class_3102.field_1755 == null) {
                class_1661 class_16612 = class_7462.method_31548();
                if (this.koo == 1 && AutoMace.kps(class_16612.method_5438(this.kom))) {
                    InventoryClicks.swap(class_3102, this.kom, this.kon);
                } else if (this.koo == 2 && AutoMace.kps(class_16612.method_5438(this.kon))) {
                    InventoryClicks.swap(class_3102, this.kom, this.kon);
                    this.kom = -1;
                } else {
                    this.kom = -1;
                }
            } else if (this.koo == 1) {
                this.kom = -1;
            }
            this.koj.release(class_3102);
            this.kop = false;
            this.koo = 0;
        }
        if ((bl = AutoMace.kpg(class_7462)) && !this.kok && this.knp.get() && class_7462.method_5805()) {
            this.kos = System.currentTimeMillis();
            this.koq = !class_7462.method_24828();
            this.kor = 0;
            if (this.kom < 0) {
                this.kol = true;
            }
        }
        this.kok = bl;
        if (!this.knp.get() && !this.knq.get() || !class_7462.method_5805()) {
            this.kol = false;
            if (!class_7462.method_5805()) {
                this.kom = -1;
            }
            return;
        }
        if (this.kol && this.koo == 0 && !ServerHelper.busy() && !KeyPearl.busy() && class_3102.field_1755 == null && InventoryClicks.canClick(class_7462)) {
            this.kol = false;
            this.kpj(class_7462);
        } else if (this.kom >= 0 && this.koo == 0) {
            boolean bl2;
            if (!class_7462.method_24828()) {
                this.koq = true;
                this.kor = 0;
            } else {
                ++this.kor;
            }
            long l = System.currentTimeMillis() - this.kos;
            boolean bl3 = this.koq && this.kor >= 2;
            boolean bl4 = bl2 = !this.koq && l > 1500L;
            if ((bl3 || bl2 || l > 8000L) && class_7462.method_24828() && this.kny == null) {
                this.kpk(class_7462);
            }
        }
    }

    private void kpi(class_746 class_7462) {
        if (!this.knq.get() || !this.knn.get() || this.kot || class_7462.method_24828() || this.kom >= 0 || this.kol || this.koo != 0 || class_7462.method_18798().field_1351 >= 0.0 || this.knt.get() < this.knk.get()) {
            return;
        }
        this.kot = true;
        if (AutoMace.kps(class_7462.method_6047())) {
            return;
        }
        this.kos = System.currentTimeMillis();
        this.koq = true;
        this.kor = 0;
        if (this.kpr(class_7462) >= 0 || InventoryClicks.canClick(class_7462)) {
            this.kpj(class_7462);
        } else {
            this.kol = true;
        }
    }

    private void kpj(class_746 class_7462) {
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        if (AutoMace.kps(class_16612.method_5438(n = class_16612.method_67532()))) {
            return;
        }
        for (int i = 0; i < 36; ++i) {
            if (!AutoMace.kps(class_16612.method_5438(i))) continue;
            if (i < 9) {
                this.kom = i;
                this.kon = n;
                class_16612.method_61496(i);
            } else {
                this.kom = i;
                this.kon = n;
                this.koo = 1;
            }
            return;
        }
    }

    private void kpk(class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        if (this.kom < 9) {
            if (class_16612.method_67532() == this.kom && this.kon >= 0) {
                class_16612.method_61496(this.kon);
            }
            this.kom = -1;
            return;
        }
        if (AutoMace.kps(class_16612.method_5438(this.kon)) && InventoryClicks.canClick(class_7462)) {
            this.koo = 2;
        } else {
            this.kom = -1;
        }
    }

    private void kpl(class_310 class_3102, class_746 class_7462, lpp lpp2) {
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        int n2 = this.kpr(class_7462);
        if (n2 < 0) {
            int n3 = n = this.knn.get() ? AutoMace.kpf(class_7462) : -1;
            if (!(n >= 0 && this.kov && InventoryClicks.canClick(class_7462) && IdleTracker.serverIdle(class_7462))) {
                this.koe = "swap";
                return;
            }
            int n4 = class_16612.method_67532();
            InventoryClicks.swap(class_3102, n, n4);
            this.kox = n;
            this.koy = n4;
            n2 = n4;
        }
        if (n2 != (n = class_16612.method_67532())) {
            class_16612.method_61496(n2);
            this.koc = n2;
            if (this.kno.get() && this.kob < 0) {
                this.kob = n;
            }
        }
        class_3102.field_1773.method_3190(1.0f);
        if (!AutoMace.kpm(class_3102, lpp2)) {
            class_243 class_2432 = this.knu.aimNow((class_1937)class_3102.field_1687, class_7462, lpp2.target(), this.kpt(class_7462));
            if (class_2432 == null) {
                class_2432 = lpp2.aim();
            }
            class_243 class_2433 = class_7462.method_33571();
            this.knv.snap(class_3102, class_7462, AimPointPicker.yaw(class_2433, class_2432), AimPointPicker.pitch(class_2433, class_2432));
            class_3102.field_1773.method_3190(1.0f);
        }
        String string = !AutoMace.kpm(class_3102, lpp2) ? "aim" : (!AutoMace.kpw(class_3102, class_7462) ? "charge" : (this.koe = this.knt.get() <= this.knu.path().threshold() || class_7462.method_24828() ? "fall" : "-"));
        if (!"-".equals(this.koe)) {
            return;
        }
        class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1886));
        this.knv.hit(1 + this.knx.nextInt(3));
        this.knt.landed();
        this.knz = lpp2.target();
        this.koa = 0;
        ++this.kod;
        this.kny = null;
        this.knu.hit();
        this.knw.release(class_3102);
    }

    private static boolean kpm(class_310 class_3102, lpp lpp2) {
        class_3966 class_39662;
        class_239 class_2392 = class_3102.field_1765;
        return class_2392 instanceof class_3966 && (class_39662 = (class_3966)class_2392).method_17782() == lpp2.target();
    }

    private void kpn(class_310 class_3102, class_746 class_7462) {
        this.knv.home(class_3102, class_7462);
    }

    private void kpo(class_746 class_7462) {
        if (this.kob < 0) {
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (class_16612.method_67532() == this.koc) {
            class_16612.method_61496(this.kob);
        }
        this.kob = -1;
        this.koc = -1;
    }

    private int kpp(class_1309 class_13092) {
        int n = class_13092 == this.knz ? 10 - this.koa - 1 : 0;
        return Math.max(class_13092.field_6235, n);
    }

    private boolean kpq(class_310 class_3102, class_746 class_7462) {
        return class_3102.field_1755 == null && class_7462.method_5805() && !class_7462.method_7325() && !class_7462.method_6115() && !class_7462.method_3144() && !FreeCam.active() && !ServerHelper.busy() && !KeyPearl.busy() && !AutoMend.busy() && (class_3102.field_1761 == null || !class_3102.field_1761.method_2923()) && (this.kpr(class_7462) >= 0 || this.kox >= 0 || this.knn.get() && AutoMace.kpf(class_7462) >= 0) && SmashPredictor.environment(class_7462, (class_1937)class_3102.field_1687);
    }

    private int kpr(class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        if (AutoMace.kps(class_7462.method_6047())) {
            return class_16612.method_67532();
        }
        if (!this.knn.get()) {
            return -1;
        }
        for (int i = 0; i < class_1661.method_7368(); ++i) {
            if (!AutoMace.kps(class_16612.method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private static boolean kps(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_49814) || class_17992.method_7909() instanceof class_9362;
    }

    private double kpt(class_746 class_7462) {
        int n = this.kpr(class_7462);
        if (n < 0 && this.knn.get()) {
            n = AutoMace.kpf(class_7462);
        }
        class_1799 class_17992 = n >= 0 ? class_7462.method_31548().method_5438(n) : class_7462.method_6047();
        class_12392 class_123922 = (class_12392)class_17992.method_58694(class_9334.field_64680);
        double d = class_123922 != null ? (double)class_123922.method_76739((class_1297)class_7462) : class_7462.method_55755();
        return Math.min(this.knj.get(), d) - 0.05;
    }

    private List<class_1309> kpu(class_310 class_3102, class_746 class_7462, double d) {
        double d2 = Math.max(4.0, Math.abs(Math.min(0.0, class_7462.method_18798().field_1351)) * 16.0 + 8.0);
        class_238 class_2383 = class_7462.method_5829().method_1012(0.0, -d2, 0.0).method_1014(d + 2.5);
        ArrayList<class_1309> arrayList = new ArrayList<class_1309>();
        for (class_1297 class_12973 : class_3102.field_1687.method_8333((class_1297)class_7462, class_2383, class_12972 -> this.kpv(class_7462, (class_1297)class_12972))) {
            arrayList.add((class_1309)class_12973);
        }
        return arrayList;
    }

    private boolean kpv(class_746 class_7462, class_1297 class_12972) {
        class_1309 class_13092;
        if (!(class_12972 != class_7462 && class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_5805() && class_12972.method_5732())) {
            return false;
        }
        if (class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            return this.knr.get() && !class_16572.method_7325() && !Friends.protects((class_1297)class_16572);
        }
        return this.kns.get() && class_12972 instanceof class_1308;
    }

    private static boolean kpw(class_310 class_3102, class_746 class_7462) {
        if (Reflect.getInt(knf, class_3102, 0) > 0) {
            return false;
        }
        class_1799 class_17992 = class_7462.method_6047();
        if (class_7462.method_75202(class_17992, 0)) {
            return false;
        }
        class_12392 class_123922 = (class_12392)class_17992.method_58694(class_9334.field_64680);
        return class_123922 == null || class_123922.method_76736((class_1309)class_7462, class_3102.field_1765.method_17784());
    }

    private static /* synthetic */ int att(int n, int n2) {
        return n ^ n2 | 0x37FEDC1A;
    }
}

