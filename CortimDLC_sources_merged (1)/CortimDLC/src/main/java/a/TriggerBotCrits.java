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
 *  net.minecraft.class_3532
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
import a.kjn;
import a.AutoMace;
import a.JumpPhysics;
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
import a.PacketHold;
import a.ForwardKeyHold;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
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
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_746;
import net.minecraft.class_9334;

final class TriggerBotCrits
extends Module {
    private final ModeSetting kjr = this.add(new ModeSetting("Crits", "Smart", "Smart", "Off"));
    private final BoolSetting kjs = this.add(new BoolSetting("Predict", true));
    private final BoolSetting kjt = this.add(new BoolSetting("SprintReset", false));
    private final BoolSetting kju = this.add(new BoolSetting("Keep sprint", true));
    private final BoolSetting kjv = this.add(new BoolSetting("MaceSmash", true));
    private final NumberSetting kjw = this.add(new NumberSetting("Reaction", 0.0, 0.0, 500.0, 10.0).suffix("ms"));
    private final NumberSetting kjx = this.add(new NumberSetting("Delay", 0.0, 0.0, 10.0, 1.0).suffix("ticks"));
    private final BoolSetting kjy = this.add(new BoolSetting("Players", true));
    private final BoolSetting kjz = this.add(new BoolSetting("Mobs", true));
    private final BoolSetting kka = this.add(new BoolSetting("Through friends", true));
    private static final int kkb = 12;
    private static final int kkc = 1;
    private static final int kkd = 2;
    private static final int kke = 10;
    private static final int kkf = 2;
    private static final double kkg = 0.1;
    private static final double kkh = 1.0;
    private static final int kki = 3;
    private static final float kkj = 0.9f;
    private static final double kkk = 1.25;
    private static final int kkl = 5;
    private static final int kkm = 20;
    private static final Field kkn = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1771", "I");
    private static final Field kko = Reflect.find(class_1309.class, "net.minecraft.class_1309", "field_6228", "I");
    private final JumpPhysics kkp = new JumpPhysics();
    private kjn kkq = kjn.NONE;
    private int kkr;
    private int kks = 1;
    private boolean kkt;
    private int kku;
    private boolean kkv;
    private double kkw;
    private boolean kkx = true;
    private int kky;
    private int kkz;
    private double kla;
    private double klb = Double.NaN;
    private int klc = Integer.MAX_VALUE;
    private class_1297 kld;
    private int kle;
    private int klf;
    private int klg = 3;
    private int klh;
    private boolean kli;
    private class_1297 klj;
    private int klk = 10;
    private final ForwardKeyHold kll = new ForwardKeyHold();
    private Predicate<class_1297> klm;
    private class_1297 kln;
    private class_243 klo;
    private boolean klp;
    private boolean klq;
    private int klr = -1;
    private kjn kls = kjn.NONE;
    private boolean klt;
    private static /* synthetic */ String klu;
    private static /* synthetic */ String klv;

    private TriggerBotCrits(Predicate<class_1297> predicate) {
        super("TriggerBot", "", ModuleCategory.COMBAT);
        this.klm = predicate;
    }

    static TriggerBotCrits embedded(Predicate<class_1297> predicate) {
        return new TriggerBotCrits(predicate);
    }

    String trace() {
        return "target=" + this.klp + " can=" + this.klq + " crit=" + this.klr + " engaged=" + this.kli + " rearm=" + (Object)((Object)this.kls) + " hop=" + this.klt + " spent=" + this.kkt;
    }

    int strikeIn(class_310 class_3102, class_746 class_7462, class_1297 class_12972, boolean bl) {
        int n;
        int n2;
        this.kkp.predict(class_7462, (class_1937)class_3102.field_1687, class_3102.field_1690.field_1903.method_1434(), Reflect.getInt(kko, class_7462, 0), NoJumpDelay.active(), this.kla);
        int n3 = n2 = ForwardKeyHold.serverSprinting(class_7462) ? 1 : 0;
        if (bl && this.kmr(class_3102, class_7462)) {
            n = this.kma(class_7462, n2, true, false);
            if (n < 0) {
                n = this.kma(class_7462, n2, false, false);
            }
            if (n > 0 && TriggerBotCrits.kmd(class_7462, 0) && this.kmb(class_7462, class_12972, n)) {
                n = -1;
            }
            if (n >= 0) {
                return n;
            }
        }
        for (n = 0; n < 20; ++n) {
            if (!TriggerBotCrits.kmd(class_7462, n)) continue;
            return n;
        }
        return 20;
    }

    class_243 selfOffset(int n) {
        return this.kkp.offsetAt(n);
    }

    void crits(boolean bl) {
        this.kjr.set(bl ? "Smart" : "Off");
    }

    @Override
    protected void onEnable() {
        this.kla = 0.0;
        this.klb = Double.NaN;
        this.klc = Integer.MAX_VALUE;
        this.kkt = false;
        this.kks = TriggerBotCrits.kmn();
        this.kkw = TriggerBotCrits.klx();
        this.kky = TriggerBotCrits.kly();
    }

    @Override
    protected void onDisable() {
        this.kmt(this.mc);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        double d = class_7462.method_23318();
        double d2 = Double.isNaN(this.klb) ? 0.0 : d - this.klb;
        this.klb = d;
        if (d2 > 0.0 || d2 < -4.0) {
            this.kla = 0.0;
        } else if (d2 < 0.0 && !class_7462.method_5799()) {
            this.kla -= d2;
        }
        this.kla = Math.min(this.kla, class_7462.field_6017);
        this.klc = class_7462.method_24828() ? Math.min(this.klc, 0x7FFFFFFE) + 1 : 0;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        boolean bl;
        int n;
        boolean bl2;
        boolean bl3;
        kjn kjn2;
        class_746 class_7462 = class_3102.field_1724;
        if (this.kkz > 0) {
            --this.kkz;
        }
        if (this.klk < 10) {
            ++this.klk;
        }
        if (class_3102.field_1755 != null || class_7462.method_7325() || !class_7462.method_5805() || class_7462.method_6115() || class_7462.method_3144() || this.kmu(class_3102) || ServerHelper.busy() || KeyPearl.busy() || AutoMend.busy() || AutoMace.busy() || AutoMines.busy() || AncientFarmer.busy()) {
            this.kmt(class_3102);
            return;
        }
        boolean bl4 = ForwardKeyHold.serverSprinting(class_7462);
        if (!bl4) {
            this.kkt = false;
        } else if (this.kkt) {
            if (!class_7462.method_5624()) {
                this.kkv = true;
            }
            if (!this.kkv && ++this.kku > 20) {
                this.kkt = false;
            }
        }
        boolean bl5 = class_7462.method_24828();
        if (this.kkx && !bl5) {
            this.kkw = TriggerBotCrits.klx();
        }
        this.kkx = bl5;
        boolean bl6 = this.kju.get();
        kjn kjn3 = kjn2 = bl6 ? kjn.NONE : this.kkq;
        if (kjn2 == kjn.STOP && class_7462.method_24828() && class_3102.field_1690.field_1903.method_1434()) {
            kjn2 = kjn.START;
        }
        class_3102.field_1773.method_3190(1.0f);
        class_1297 class_12972 = this.kmv(class_3102);
        this.kli = Integer.bitCount(this.klh) >= 2;
        this.klh = (this.klh << 1 | (class_12972 != null ? 1 : 0)) & 0xFFFF;
        boolean bl7 = this.kmc(class_12972);
        boolean bl8 = bl3 = this.kjv.get() && class_7462.method_6047().method_31574(class_1802.field_49814);
        boolean bl9 = class_12972 != null && bl7 && this.kkz == 0 && TriggerBotCrits.kme(class_3102, class_7462, this.kln != null ? this.klo : class_3102.field_1765.method_17784()) && (!bl3 || !this.kmp(class_12972));
        boolean bl10 = this.kjr.is("Smart") && this.kmr(class_3102, class_7462) && (!bl6 || !bl4 || this.kkt);
        boolean bl11 = bl2 = bl3 && this.kmq(class_3102, class_7462);
        if (bl10 || bl2) {
            this.kkp.predict(class_7462, (class_1937)class_3102.field_1687, class_3102.field_1690.field_1903.method_1434(), Reflect.getInt(kko, class_7462, 0), NoJumpDelay.active(), this.kla);
        }
        int n2 = !bl6 && bl4 ? 1 : 0;
        int n3 = -1;
        boolean bl12 = bl2 && this.kkp.smashAt(0);
        boolean bl13 = false;
        if (bl3) {
            if (bl10 && bl2) {
                n3 = this.kma(class_7462, n2, true, true);
            }
            if (n3 > 0 && bl12 && this.kmb(class_7462, class_12972, n3)) {
                n3 = -1;
            }
        } else if (bl10) {
            n3 = this.klw(class_7462, n2, true);
            if (n3 < 0) {
                n3 = this.klw(class_7462, n2, false);
            }
            boolean bl14 = bl13 = n3 < 0 && class_7462.method_24828() && this.klc <= 5 && this.kli && JumpPhysics.headroom(class_7462, (class_1937)class_3102.field_1687, 1.25) < 1.25;
            if (n3 > 0 && TriggerBotCrits.kmd(class_7462, 0) && this.kmb(class_7462, class_12972, n3)) {
                n = this.kma(class_7462, n2, true, false);
                if (n < 0) {
                    n = this.kma(class_7462, n2, false, false);
                }
                int n4 = n3 = n >= 0 && n < n3 && !this.kmb(class_7462, class_12972, n) ? n : -1;
            }
        }
        if (!bl6 && kjn2 == kjn.NONE && this.kkt && this.kjt.get() && n3 < 0 && (n = this.kmo(class_3102, class_7462)) > 0) {
            kjn2 = kjn.STOP;
            this.kkr = n;
        }
        n = n3 == 0 || n3 == 1 ? 1 : 0;
        boolean bl15 = class_12972 != null || n != 0 && this.kjs.get() && (this.kmh(class_3102, class_7462) || this.kmi(class_3102, class_7462));
        this.klg = bl15 ? 0 : this.klg + 1;
        boolean bl16 = bl = !bl6 && n != 0 && this.klg <= 2;
        if (kjn2 == kjn.STOP || bl) {
            this.kll.hold(class_3102);
        } else {
            this.kll.release(class_3102);
        }
        this.kkq = switch (kjn2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1 -> {
                if (--this.kkr > 0) {
                    yield kjn.STOP;
                }
                yield kjn.START;
            }
            case 0, 2 -> kjn.NONE;
        };
        this.klp = class_12972 != null;
        this.klq = bl9;
        this.klr = n3;
        this.kls = kjn2;
        this.klt = bl13;
        if (!bl9) {
            return;
        }
        if (n3 == 0) {
            this.kml(class_3102);
            this.kkw = TriggerBotCrits.klx();
            this.kll.release(class_3102);
            if (bl3) {
                this.kla = 0.0;
            }
        } else {
            if (n3 > 0) {
                return;
            }
            if (bl3) {
                if (!bl12) {
                    return;
                }
                this.kml(class_3102);
                this.kla = 0.0;
            } else {
                if (!TriggerBotCrits.kmd(class_7462, 0) || !TriggerBotCrits.klz(class_7462, this.kky) || kjn2 != kjn.NONE || bl13) {
                    return;
                }
                this.kml(class_3102);
            }
        }
        this.kkz = this.kjx.getInt();
    }

    private int klw(class_746 class_7462, int n, boolean bl) {
        if (!this.kli) {
            return this.kma(class_7462, n, bl, false);
        }
        int n2 = -1;
        for (int i = n; i < 20; ++i) {
            boolean bl2;
            boolean bl3 = bl2 = bl ? this.kkp.critAt(i) : this.kkp.rawCritAt(i);
            if (!bl2) {
                if (n2 < 0) continue;
                break;
            }
            if (!TriggerBotCrits.kmd(class_7462, i)) continue;
            if (n2 < 0) {
                n2 = i;
            }
            if (!(this.kkp.fallAt(i) >= this.kkw)) continue;
            return i;
        }
        return n2;
    }

    private static double klx() {
        double d = ThreadLocalRandom.current().nextDouble();
        return d < 0.3 ? 0.0 : (d < 0.65 ? 0.15 : (d < 0.9 ? 0.35 : 0.6));
    }

    private static int kly() {
        double d = ThreadLocalRandom.current().nextDouble();
        return d < 0.5 ? 0 : (d < 0.85 ? 1 : 2);
    }

    private static boolean klz(class_746 class_7462, int n) {
        return class_7462.method_7261(0.5f - (float)n) > 0.9f;
    }

    private int kma(class_746 class_7462, int n, boolean bl, boolean bl2) {
        for (int i = n; i < 20; ++i) {
            boolean bl3;
            boolean bl4 = bl3 = bl ? this.kkp.critAt(i) : this.kkp.rawCritAt(i);
            if (!bl3 || bl2 && !this.kkp.smashAt(i) || !TriggerBotCrits.kmd(class_7462, i)) continue;
            return i;
        }
        return -1;
    }

    private boolean kmb(class_746 class_7462, class_1297 class_12972, int n) {
        return n > (this.kli ? 12 : 1) || class_12972 != null && this.kmg(class_7462, class_12972, n);
    }

    private boolean kmc(class_1297 class_12972) {
        if (class_12972 == null) {
            if (this.kld != null && ++this.klf > 2) {
                this.kld = null;
            }
            return false;
        }
        if (class_12972 != this.kld) {
            this.kld = class_12972;
            this.kle = 0;
        }
        this.klf = 0;
        return (long)this.kle++ * 50L >= (long)this.kjw.get();
    }

    private static boolean kmd(class_746 class_7462, int n) {
        return class_7462.method_7261(0.5f + (float)n) > 0.9f;
    }

    private static boolean kme(class_310 class_3102, class_746 class_7462, class_243 class_2432) {
        if (Reflect.getInt(kkn, class_3102, 0) > 0) {
            return false;
        }
        class_1799 class_17992 = class_7462.method_6047();
        if (class_7462.method_75202(class_17992, 0)) {
            return false;
        }
        class_12392 class_123922 = (class_12392)class_17992.method_58694(class_9334.field_64680);
        return class_123922 == null || class_123922.method_76736((class_1309)class_7462, class_2432);
    }

    private static double kmf(class_746 class_7462) {
        class_12392 class_123922 = (class_12392)class_7462.method_6047().method_58694(class_9334.field_64680);
        return class_123922 != null ? (double)class_123922.method_76739((class_1297)class_7462) : class_7462.method_55755();
    }

    private boolean kmg(class_746 class_7462, class_1297 class_12972, int n) {
        int n2 = Math.min(n, 3);
        double d = TriggerBotCrits.kmf(class_7462);
        class_243 class_2432 = class_7462.method_33571().method_1019(this.kkp.offsetAt(n2));
        class_238 class_2383 = class_12972.method_5829().method_989((class_12972.method_23317() - class_12972.field_6014) * (double)n2, 0.0, (class_12972.method_23321() - class_12972.field_5969) * (double)n2);
        return class_2383.method_49271(class_2432) > d * d;
    }

    private boolean kmh(class_310 class_3102, class_746 class_7462) {
        double d = TriggerBotCrits.kmf(class_7462) + 1.0;
        class_243 class_2432 = class_7462.method_33571();
        for (class_1297 class_12973 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0), class_12972 -> this.kmx(class_3102, (class_1297)class_12972))) {
            if (!(class_12973.method_5829().method_49271(class_2432) <= d * d)) continue;
            return true;
        }
        return false;
    }

    private boolean kmi(class_310 class_3102, class_746 class_7462) {
        double d = TriggerBotCrits.kmf(class_7462);
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(d));
        float f = class_3532.method_15363((float)(2.0f * class_7462.method_36455() - class_7462.field_6004), (float)-90.0f, (float)90.0f);
        float f2 = 2.0f * class_7462.method_36454() - class_7462.field_5982;
        class_243 class_2434 = class_2432.method_1019(class_243.method_1030((float)f, (float)f2).method_1021(d));
        class_243 class_2435 = TriggerBotCrits.kmj(class_3102, class_7462, class_2432, class_2433);
        class_243 class_2436 = TriggerBotCrits.kmj(class_3102, class_7462, class_2432, class_2434);
        class_238 class_2383 = class_7462.method_5829().method_1014(d + 2.0);
        for (class_1297 class_12973 : class_3102.field_1687.method_8333((class_1297)class_7462, class_2383, class_12972 -> this.kmx(class_3102, (class_1297)class_12972))) {
            class_238 class_2384 = class_12973.method_5829();
            class_238 class_2385 = class_2384.method_991(class_2384.method_989(class_12973.method_23317() - class_12973.field_6014, class_12973.method_23318() - class_12973.field_6036, class_12973.method_23321() - class_12973.field_5969)).method_1014(0.1);
            if (!TriggerBotCrits.kmk(class_2385, class_2432, class_2433, class_2435) && !TriggerBotCrits.kmk(class_2385, class_2432, class_2434, class_2436)) continue;
            return true;
        }
        return false;
    }

    private static class_243 kmj(class_310 class_3102, class_746 class_7462, class_243 class_2432, class_243 class_2433) {
        class_3965 class_39652 = class_3102.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        return class_39652.method_17783() == class_239.class_240.field_1333 ? class_2433 : class_39652.method_17784();
    }

    private static boolean kmk(class_238 class_2383, class_243 class_2432, class_243 class_2434, class_243 class_2435) {
        if (class_2383.method_1006(class_2432)) {
            return true;
        }
        double d = class_2432.method_1025(class_2435);
        return class_2383.method_992(class_2432, class_2434).filter(class_2433 -> class_2432.method_1025(class_2433) <= d).isPresent();
    }

    private void kml(class_310 class_3102) {
        PacketHold.hold(class_3102, TriggerBotCrits.kmm());
        class_746 class_7462 = class_3102.field_1724;
        if (ForwardKeyHold.serverSprinting(class_7462) && class_7462.method_7261(0.5f) > 0.9f) {
            this.kkt = true;
            this.kku = 0;
            this.kkv = false;
            this.kks = TriggerBotCrits.kmn();
        }
        this.kky = TriggerBotCrits.kly();
        if (this.kln != null) {
            class_3102.field_1761.method_2918((class_1657)class_3102.field_1724, this.kln);
            class_3102.field_1724.method_6104(class_1268.field_5808);
            this.klj = this.kln;
        } else {
            class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1886));
            this.klj = this.kmv(class_3102);
        }
        this.klk = 0;
    }

    private static long kmm() {
        return ThreadLocalRandom.current().nextLong(1000000L, 10000001L);
    }

    private static int kmn() {
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    private int kmo(class_310 class_3102, class_746 class_7462) {
        for (int i = this.kks; i > 0; --i) {
            if (TriggerBotCrits.kmd(class_7462, i) || class_7462.method_24828() && (!TriggerBotCrits.kmd(class_7462, i + 1) || class_3102.field_1690.field_1903.method_1434())) continue;
            return i;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean kmp(class_1297 class_12972) {
        if (class_12972 instanceof class_1309) {
            class_1309 class_13092 = (class_1309)class_12972;
            if (class_13092.field_6235 > 0) return true;
        }
        if (class_12972 != this.klj) return false;
        if (this.klk >= 10) return false;
        return true;
    }

    private boolean kmq(class_310 class_3102, class_746 class_7462) {
        return !class_7462.method_6101() && !class_7462.method_5799() && !class_7462.method_5771() && !class_7462.method_5765() && !class_7462.method_6128() && !class_7462.method_31549().field_7479 && !class_7462.field_27857 && !class_7462.method_6059(class_1294.field_5902) && !class_7462.method_6059(class_1294.field_5906) && class_3102.field_1687.method_29546(class_7462.method_5829().method_1011(1.0E-7)).noneMatch(TriggerBotCrits::kms);
    }

    private boolean kmr(class_310 class_3102, class_746 class_7462) {
        return !class_7462.method_6059(class_1294.field_5919) && this.kmq(class_3102, class_7462);
    }

    private static boolean kms(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10343) || class_26802.method_27852(class_2246.field_16999) || class_26802.method_27852(class_2246.field_27879);
    }

    private void kmt(class_310 class_3102) {
        this.kll.release(class_3102);
        this.kkq = kjn.NONE;
        this.kld = null;
        this.kle = 0;
        this.klf = 0;
        this.klg = 3;
        this.klh = 0;
    }

    private boolean kmu(class_310 class_3102) {
        if (class_3102.field_1761 != null && class_3102.field_1761.method_2923()) {
            return true;
        }
        return class_3102.field_1690.field_1886.method_1434() && class_3102.field_1765 != null && class_3102.field_1765.method_17783() == class_239.class_240.field_1332;
    }

    private class_1297 kmv(class_310 class_3102) {
        this.kln = null;
        class_239 class_2392 = class_3102.field_1765;
        if (class_2392 == null || class_2392.method_17783() != class_239.class_240.field_1331) {
            return null;
        }
        class_1297 class_12972 = ((class_3966)class_2392).method_17782();
        if (this.kmx(class_3102, class_12972)) {
            return class_12972;
        }
        if (this.kka.get() && class_12972 instanceof class_1657 && Friends.isFriend(class_12972)) {
            this.kln = this.kmw(class_3102, class_3102.field_1724);
            return this.kln;
        }
        return null;
    }

    private class_1297 kmw(class_310 class_3102, class_746 class_7462) {
        double d = TriggerBotCrits.kmf(class_7462);
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(d));
        double d2 = class_2432.method_1025(TriggerBotCrits.kmj(class_3102, class_7462, class_2432, class_2433));
        class_1297 class_12973 = null;
        double d3 = Double.MAX_VALUE;
        for (class_1297 class_12974 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0), class_12972 -> this.kmx(class_3102, (class_1297)class_12972))) {
            double d4;
            class_238 class_2383 = class_12974.method_5829().method_1014((double)class_12974.method_5871());
            class_243 class_2434 = class_2383.method_1006(class_2432) ? class_2432 : (class_243)class_2383.method_992(class_2432, class_2433).orElse(null);
            if (class_2434 == null || !((d4 = class_2432.method_1025(class_2434)) <= d2) || !(d4 < d3)) continue;
            class_12973 = class_12974;
            d3 = d4;
            this.klo = class_2434;
        }
        return class_12973;
    }

    private boolean kmx(class_310 class_3102, class_1297 class_12972) {
        class_1309 class_13092;
        if (class_12972 == null || class_12972 == class_3102.field_1724) {
            return false;
        }
        if (!(class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_5805() && class_12972.method_5732())) {
            return false;
        }
        if (this.klm != null) {
            return this.klm.test(class_12972);
        }
        if (class_12972 instanceof class_1657) {
            return this.kjy.get() && !Friends.protects(class_12972);
        }
        return this.kjz.get();
    }

    private static /* synthetic */ int atq(int n, int n2) {
        return n + n2 | 0xB74FF4B5;
    }
}

