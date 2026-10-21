/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.doubles.DoubleArrayList
 *  it.unimi.dsi.fastutil.longs.Long2DoubleMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2IntMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2LongMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongArrayList
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_1301
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2482
 *  net.minecraft.class_2510
 *  net.minecraft.class_2596
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3489
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.Box3;
import a.qcu;
import a.qda;
import a.qdk;
import a.qdo;
import a.qdt;
import a.qdw;
import a.LookModel;
import a.TrackingError;
import a.qmx;
import a.OreTargetMap;
import a.GhostBlockTracker;
import a.BreakQueue;
import a.AngleUtil;
import a.RecorderHooks;
import a.AimBrain;
import a.TurnRateLimiter;
import a.LegsNet;
import a.MineModelReader;
import a.Reflect;
import a.KeyUtil;
import flow.dev.StringDecryptor;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.longs.Long2DoubleMap;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2LongMap;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1297;
import net.minecraft.class_1301;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2482;
import net.minecraft.class_2510;
import net.minecraft.class_2596;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3489;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import net.minecraft.class_746;

public final class AutoMineController {
    private static final double qea = 4.4;
    private static final int qeb = 20;
    private static final int qec = 30;
    private static final int qed = 50;
    private static final double qee = 0.12;
    private static final double qef = 0.35;
    private static final int qeg = 32;
    private static final int qeh = 10;
    private static final double[][] qei = new double[][]{{0.14, 0.0}, {-0.14, 0.0}, {0.0, 0.14}, {0.0, -0.14}};
    private static final double[][] qej = new double[][]{{0.0, 0.0}, {0.27, 0.27}, {-0.27, 0.27}, {0.27, -0.27}, {-0.27, -0.27}, {0.3, 0.0}, {-0.3, 0.0}, {0.0, 0.3}, {0.0, -0.3}};
    private static final Field qek = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field qel = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static final double qem = 0.9;
    private static final int qen = 3;
    private static final int qeo = 6;
    private final Random qep = new Random();
    private final OreTargetMap qeq = new OreTargetMap();
    private final BreakQueue qer = new BreakQueue();
    private final LookModel qes = new LookModel();
    private final GhostBlockTracker qet = new GhostBlockTracker();
    private boolean qeu;
    private final LongOpenHashSet qev = new LongOpenHashSet();
    private final Long2LongOpenHashMap qew = new Long2LongOpenHashMap();
    private final LongOpenHashSet qex = new LongOpenHashSet();
    private final List<qcu> qey = new ArrayList<qcu>();
    private final Long2IntOpenHashMap qez = new Long2IntOpenHashMap();
    private final Long2IntOpenHashMap qfa = new Long2IntOpenHashMap();
    private final Long2IntOpenHashMap qfb = new Long2IntOpenHashMap();
    private final LongOpenHashSet qfc = new LongOpenHashSet();
    private final List<qdo> qfd = new ArrayList<qdo>();
    public static volatile Consumer<String> trace;
    private Predicate<class_2680> qfe = class_26802 -> false;
    private Predicate<class_1799> qff = class_17992 -> false;
    private Box3 qfg;
    private qdw qfh = qdw.IDLE;
    private int qfi;
    private qmx qfj;
    private int qfk;
    private boolean qfl = true;
    private int qfm;
    private int qfn;
    private boolean qfo;
    private int qfp;
    private int qfq;
    private class_2338 qfr;
    private class_2248 qfs;
    private boolean qft;
    private class_243 qfu;
    private Object qfv;
    private int qfw;
    private class_243 qfx;
    private boolean qfy;
    private boolean qfz;
    private class_243 qga;
    private Object qgb;
    private long qgc = Long.MIN_VALUE;
    private boolean qgd;
    private int qge;
    private class_2338 qgf;
    private class_2338 qgg;
    private class_2350 qgh;
    private float qgi;
    private float qgj;
    private int qgk;
    private boolean qgl;
    private class_243 qgm;
    private int qgn;
    private int qgo;
    private class_243 qgp;
    private int qgq;
    private TrackingError qgr;
    private TurnRateLimiter qgs;
    private double qgt;
    private boolean qgu;
    private int qgv;
    private int qgw;
    private boolean qgx;
    private boolean qgy;
    private boolean qgz;
    private boolean qha;
    private boolean qhb;
    private class_2338 qhc;
    private boolean qhd;
    private boolean qhe;
    private boolean qhf;
    private boolean qhg;
    private class_2338 qhh;
    private class_243 qhi;
    private Object qhj;
    private int qhk;
    private int qhl;
    private Runnable qhm = () -> {};
    private static final int qhn = Integer.MIN_VALUE;
    private int qho = Integer.MIN_VALUE;
    private int qhp;
    private long qhq = Long.MIN_VALUE;
    private int qhr;
    private static final List<class_238> qhs;
    private static final int qht = 4;
    private static final int qhu = 14;
    private static final double qhv = 3.6;
    private static final int[][] qhw;
    private static final int qhx = 0;
    private static final int qhy = 1;
    private static final int qhz = 2;
    private static final int qia = 3;
    private static final int qib = 4;
    private static final int qic = 5;
    private static final int qid = 6;
    private final int[] qie = new int[7];
    private int qif = Integer.MIN_VALUE;
    private static final int qig = 4;
    private int qih;
    private int qii = -1;
    private static /* synthetic */ String qij;
    private static /* synthetic */ boolean qik;

    public void configure(TrackingError qmh2, boolean bl, boolean bl2) {
        this.qgr = qmh2;
        this.qgx = bl;
        this.qgy = bl2;
        this.qes.wide(bl2);
        this.qeq.tune(bl ? 3.6f : 4.6f, qmh2 == null ? 4.0f : (bl2 ? 0.8f : 1.5f), qmh2 != null ? qmh2.cap() : 22.0, bl2 ? 0.6f : 0.0f);
    }

    public void target(Predicate<class_2680> predicate) {
        this.qfe = predicate;
    }

    public void brain(MineModelReader ttb2) {
        if (ttb2 == null) {
            this.qgs = null;
            this.qgu = false;
        } else if (this.qgs == null || this.qgs.model != ttb2) {
            this.qgs = new TurnRateLimiter(ttb2);
        }
        if (this.qgs != null) {
            this.qgs.boost(this.qgt);
        }
    }

    public void boost(double d) {
        this.qgt = d;
        if (this.qgs != null) {
            this.qgs.boost(d);
        }
    }

    public boolean hasBrain() {
        return this.qgs != null;
    }

    public TurnRateLimiter brain() {
        return this.qgs;
    }

    private double qil() {
        return this.qgr != null ? this.qgr.cap() : (this.qgs != null ? this.qgs.turnRate() : 22.0);
    }

    private static double qim(class_746 class_7462, class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(class_7462.method_33571());
        double d = AngleUtil.yawTo(class_2433.field_1352, class_2433.field_1350);
        double d2 = AngleUtil.pitchTo(class_2433.field_1351, Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350));
        return Math.hypot(class_3532.method_15338((double)(d - (double)class_7462.method_36454())), d2 - (double)class_7462.method_36455());
    }

    public void predict(boolean bl, class_310 class_3102) {
        if (this.qeu && !bl && class_3102 != null) {
            this.qet.restore((class_1937)class_3102.field_1687);
        }
        this.qeu = bl;
    }

    public void echo(class_2596<?> class_25962) {
        this.qet.echo(class_25962);
    }

    public String predicted() {
        return this.qet.describe();
    }

    public void junk(Predicate<class_1799> predicate) {
        this.qff = predicate;
    }

    public void onSit(Runnable runnable) {
        this.qhm = runnable;
    }

    public void park(Box3 pzc2, class_2338 class_23382, boolean bl) {
        this.start(pzc2);
        this.qhc = class_23382.method_10062();
        this.qhg = bl;
    }

    public boolean parking() {
        return this.qhc != null;
    }

    public boolean parked() {
        return this.qhc != null && this.qhd;
    }

    public boolean parkLost() {
        return this.qhc != null && this.qhe;
    }

    public void guard(Box3 pzc2) {
        this.start(pzc2);
        this.qhf = true;
    }

    public boolean guarding() {
        return this.qhf && this.qfh == qdw.WORKING;
    }

    public void start(Box3 pzc2) {
        this.qhf = false;
        this.qhc = null;
        this.qhd = false;
        this.qhe = false;
        this.qhh = null;
        this.qhi = null;
        this.qhk = 0;
        this.qhl = 0;
        this.qho = Integer.MIN_VALUE;
        this.qhq = Long.MIN_VALUE;
        this.qhr = 0;
        this.qif = Integer.MIN_VALUE;
        this.qii = -1;
        this.qih = 0;
        if (this.qfg == null || pzc2 == null || !this.qfg.covers(pzc2) || !pzc2.covers(this.qfg)) {
            this.qev.clear();
        }
        this.qfa.clear();
        this.qez.clear();
        this.qer.clear();
        this.qfg = pzc2;
        this.qfh = pzc2 == null ? qdw.IDLE : qdw.WORKING;
        this.qew.clear();
        this.qfb.clear();
        this.qey.clear();
        this.qfd.clear();
        this.qfc.clear();
        this.qfj = null;
        this.qfl = true;
        this.qfn = 0;
        this.qfo = false;
        this.qfr = null;
        this.qfx = null;
        this.qgo = 0;
    }

    public void avoid(class_243 class_2432, int n) {
        this.qgp = class_2432;
        this.qgq = this.qfi + n;
        this.qfl = true;
    }

    public Box3 area() {
        return this.qfg;
    }

    public qdw status() {
        return this.qfh;
    }

    public int mined() {
        return this.qfp;
    }

    public int reverts() {
        return this.qfq;
    }

    public boolean breaking() {
        return this.qfr != null;
    }

    public String dozer() {
        return this.qes.describe();
    }

    public class_2338 focus() {
        if (this.qfh != qdw.WORKING || this.qhc != null || this.qhf) {
            return null;
        }
        if (this.qfr != null && this.qft) {
            return this.qfr;
        }
        return this.qfj == null ? null : this.qfj.target();
    }

    public String action() {
        if (this.qfr != null) {
            return "break " + this.qfr.method_23854() + " aim " + AutoMineController.qin(this.qfu);
        }
        if (this.qfx != null) {
            return "walk " + AutoMineController.qin(this.qfx) + " look " + AutoMineController.qin(this.qga);
        }
        return "none";
    }

    private static String qin(class_243 class_2432) {
        return class_2432 == null ? "-" : String.format(Locale.ROOT, "%.2f,%.2f,%.2f", class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
    }

    public void resetCounters() {
        this.qfp = 0;
        this.qfq = 0;
        Arrays.fill(this.qie, 0);
    }

    public void stop(class_310 class_3102) {
        this.qfh = qdw.IDLE;
        this.qer.clear();
        this.qfg = null;
        this.qfj = null;
        this.qfr = null;
        this.qfx = null;
        this.qfc.clear();
        if (class_3102 != null) {
            this.qet.restore((class_1937)class_3102.field_1687);
        }
        this.releaseKeys(class_3102);
    }

    public void endTick(class_310 class_3102, class_746 class_7462, AimBrain tel2) {
        class_243 class_2432;
        ++this.qfi;
        this.qgu = false;
        class_638 class_6382 = class_3102.field_1687;
        if (class_6382 != null) {
            this.qet.tick((class_1937)class_6382, this.qfi);
        }
        if (this.qfg == null || class_6382 == null || this.qfh == qdw.IDLE) {
            this.qiq(class_3102, class_7462, tel2, null, null);
            return;
        }
        AutoMineController.qkz((class_1937)class_6382, class_7462);
        this.qlh((class_1937)class_6382);
        this.qjc((class_1937)class_6382, class_7462);
        this.qfd.removeIf(qdo2 -> this.qfi - qdo2.tick() > this.qes.lag() + 6);
        if (this.qgs != null) {
            this.qgs.tick((class_1937)class_6382, class_7462, this.qfg);
        }
        if (this.qfg.distanceTo(class_7462.method_73189()) > 40.0) {
            this.qfh = qdw.FAR;
            this.qfr = null;
            this.qfx = null;
            this.qiq(class_3102, class_7462, tel2, null, null);
            return;
        }
        if (class_3102.field_1755 != null || !class_7462.method_5805()) {
            this.qfr = null;
            this.qfx = null;
            this.qiq(class_3102, class_7462, tel2, null, null);
            return;
        }
        this.qlg(class_7462);
        if (this.qfr != null && this.qhc == null && !this.qhf) {
            this.qjf(6);
        }
        if (this.qfr != null && !this.qiy((class_1937)class_6382, class_7462)) {
            this.qfr = null;
            this.qfl = this.qfl || this.qgr == null;
        }
        this.qes.tick(this.qfi, arg_0 -> this.lambda$endTick$4((class_1937)class_6382, arg_0));
        class_2338 class_23382 = AutoMineController.trapped((class_1937)class_6382, class_7462);
        if (class_23382 != null && this.qfg.maxX >= this.qfg.minX && !this.qfg.contains(class_23382)) {
            class_23382 = null;
        }
        if (class_23382 != null && !class_23382.equals((Object)this.qfr)) {
            this.qlj("trapped in " + class_23382.method_23854());
            this.qku(class_23382, class_6382.method_8320(class_23382).method_26204(), false, AutoMineController.qkw(class_7462, class_23382));
            class_2432 = class_7462.method_31548();
            if (!class_7462.method_6047().method_31573(class_3489.field_42614)) {
                for (int i = 0; i < 9; ++i) {
                    if (!class_2432.method_5438(i).method_31573(class_3489.field_42614)) continue;
                    class_2432.method_61496(i);
                    break;
                }
            }
        }
        if (this.qfr == null) {
            this.qjd((class_1937)class_6382, class_7462);
        }
        if (this.qhd && this.qhg && this.qfr == null && this.qfx == null && !class_7462.method_5765()) {
            this.qiu((class_1937)class_6382, class_7462);
            class_2432 = class_7462.method_33571();
            if (this.qhi != null && Math.hypot(this.qhi.field_1352 - class_2432.field_1352, this.qhi.field_1350 - class_2432.field_1350) > 1.2) {
                this.qiq(class_3102, class_7462, tel2, this.qhj, new class_243(this.qhi.field_1352, class_2432.field_1351 - 0.35, this.qhi.field_1350));
            } else {
                this.qiq(class_3102, class_7462, tel2, null, null);
            }
            return;
        }
        if (this.qfr != null) {
            if (!this.qgz) {
                this.qfx = null;
            }
            this.qiq(class_3102, class_7462, tel2, this.qfv, this.qfu);
            if (this.qgr == null) {
                this.qir(class_3102, class_7462, tel2);
            }
        } else if (this.qga != null) {
            this.qiq(class_3102, class_7462, tel2, this.qgb, this.qga);
        } else {
            this.qiq(class_3102, class_7462, tel2, null, null);
        }
        this.qio((class_1937)class_6382, class_7462);
    }

    private void qio(class_1937 class_19372, class_746 class_7462) {
        this.qgu = false;
        if (this.qgs == null) {
            return;
        }
        boolean bl = this.qgs.hasLegs() && this.qgr == null && this.qhc == null && !this.qhf && this.qfg.maxX >= this.qfg.minX && this.qho == Integer.MIN_VALUE && this.qfx == null && this.qfi >= this.qgw && !class_7462.method_5765();
        double d = class_7462.method_23317();
        double d2 = class_7462.method_23321();
        if (bl && (d < (double)this.qfg.minX - 0.5 || d > (double)this.qfg.maxX + 1.5 || d2 < (double)this.qfg.minZ - 0.5 || d2 > (double)this.qfg.maxZ + 1.5)) {
            bl = false;
        }
        if (!bl) {
            this.qgs.stopLegs();
            this.qgv = 0;
            return;
        }
        int n = this.qgs.move();
        double d3 = Math.hypot(class_7462.method_23317() - class_7462.field_6014, class_7462.method_23321() - class_7462.field_5969);
        if (n != 0 && d3 < 0.02) {
            if (++this.qgv >= 20) {
                this.qgv = 0;
                this.qgw = this.qfi + 30;
                this.qgs.stopLegs();
                this.qlj("legs stuck at " + class_7462.method_24515().method_23854());
                return;
            }
        } else {
            this.qgv = 0;
        }
        this.qgs.planLegs(class_19372, class_7462, this.qfr);
        this.qgu = true;
    }

    private static boolean qip(class_1937 class_19372, class_746 class_7462, int n) {
        double d;
        double d2 = Math.toRadians(class_7462.method_36454());
        double d3 = (double)LegsNet.FWD[n] * -Math.sin(d2) + (double)LegsNet.LEFT[n] * Math.cos(d2);
        double d4 = Math.hypot(d3, d = (double)LegsNet.FWD[n] * Math.cos(d2) + (double)LegsNet.LEFT[n] * Math.sin(d2));
        if (d4 < 1.0E-6) {
            return false;
        }
        int n2 = class_3532.method_15357((double)(class_7462.method_23317() + d3 / d4 * 0.9));
        int n3 = class_3532.method_15357((double)(class_7462.method_23321() + d / d4 * 0.9));
        int n4 = AutoMineController.standing(class_19372, class_7462).method_10264();
        for (int i = n4 - 1; i >= n4 - 4; --i) {
            if (AutoMineController.qjs(class_19372, new class_2338(n2, i, n3))) continue;
            return false;
        }
        return true;
    }

    private void qiq(class_310 class_3102, class_746 class_7462, AimBrain tel2, Object object, class_243 class_2432) {
        if (this.qgr != null) {
            tel2.assistAt(class_3102, class_7462, null, null, 1);
            this.qgr.aim(class_3102, class_7462, object, class_2432);
        } else if (this.qgs != null && object != null && object == this.qfv && this.qfr != null) {
            tel2.assistBlock(class_3102, class_7462, object, new class_238(this.qfr), class_2432, -1);
        } else {
            tel2.assistAt(class_3102, class_7462, object, class_2432, this.qgs != null ? -1 : 1);
        }
    }

    private void qir(class_310 class_3102, class_746 class_7462, AimBrain tel2) {
        double d;
        if (this.qgk < 3 || this.qfi - this.qfw < 4) {
            return;
        }
        class_243 class_2432 = this.qfu.method_1020(class_7462.method_33571());
        double d2 = AngleUtil.yawTo(class_2432.field_1352, class_2432.field_1350);
        double d3 = AngleUtil.pitchTo(class_2432.field_1351, Math.sqrt(class_2432.field_1352 * class_2432.field_1352 + class_2432.field_1350 * class_2432.field_1350));
        double d4 = class_3532.method_15338((double)(d2 - (double)class_7462.method_36454()));
        double d5 = Math.hypot(d4, d = d3 - (double)class_7462.method_36455());
        if (d5 > 9.0 || d5 < 0.05) {
            return;
        }
        double d6 = Math.min(0.55 + this.qep.nextDouble() * 0.3, Math.min(3.5, tel2.budgetLeft()) / d5);
        if (d6 <= 0.0) {
            return;
        }
        double d7 = RecorderHooks.unit(class_3102);
        if (d7 <= 0.0) {
            return;
        }
        long l = Math.round(d4 * d6 / d7);
        long l2 = Math.round(d * d6 / d7);
        if (l == 0L && l2 == 0L) {
            if (Math.abs(d4) >= Math.abs(d)) {
                l = (long)Math.signum(d4);
            } else {
                l2 = (long)Math.signum(d);
            }
        }
        double d8 = d7 / 0.15;
        class_7462.method_5872((double)l * d8, (double)l2 * d8);
        tel2.spent(Math.hypot((double)l * d7, (double)l2 * d7));
    }

    public void startTick(class_310 class_3102, class_746 class_7462) {
        class_243 class_2432;
        if (this.qfh != qdw.WORKING || class_3102.field_1755 != null || class_7462 == null || !class_7462.method_5805()) {
            this.releaseKeys(class_3102);
            return;
        }
        class_315 class_3152 = class_3102.field_1690;
        if (class_7462.method_5765() && this.qhc == null) {
            class_3152.field_1894.method_23481(false);
            class_3152.field_1881.method_23481(false);
            class_3152.field_1913.method_23481(false);
            class_3152.field_1849.method_23481(false);
            class_3152.field_1903.method_23481(false);
            this.qix(class_3102, false);
            this.qis(class_3102, true);
            this.qgl = true;
            if (this.qgd) {
                class_3152.field_1886.method_23481(false);
                this.qgd = false;
            }
            return;
        }
        if (this.qhb) {
            this.qis(class_3102, false);
        }
        if (this.qhd && this.qhg && !class_7462.method_5765()) {
            this.qit(class_3102, class_7462);
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        if ((this.qfr == null || this.qgz) && this.qfx != null) {
            boolean bl8;
            class_2432 = class_7462.method_73189();
            double d = this.qfx.field_1352 - class_2432.field_1352;
            double d2 = this.qfx.field_1350 - class_2432.field_1350;
            double d3 = Math.sqrt(d * d + d2 * d2);
            class_243 class_2433 = class_7462.method_18798();
            double d4 = Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350);
            boolean bl9 = bl8 = this.qfz && class_7462.method_24828() && d3 < d4 * 1.3 + 0.05;
            if (d3 > 0.12 && !bl8) {
                double d5 = AngleUtil.yawTo(d, d2);
                double d6 = class_3532.method_15338((double)(d5 - (double)class_7462.method_36454()));
                bl = Math.abs(d6) < 67.5;
                bl2 = Math.abs(d6) > 112.5;
                bl4 = d6 > 22.5 && d6 < 157.5;
                bl3 = d6 < -22.5 && d6 > -157.5;
            }
            bl6 = this.qfz && d3 < 1.6;
            bl5 = this.qfy && class_7462.method_24828() && d3 < 1.25 || this.qgn >= 10 && this.qgn % 10 == 0 && class_7462.method_24828() && (bl || bl2 || bl3 || bl4);
        } else if (this.qgu && this.qgs != null && class_3102.field_1687 != null) {
            int n = this.qgs.move();
            bl = LegsNet.FWD[n] > 0;
            bl2 = LegsNet.FWD[n] < 0;
            bl3 = LegsNet.LEFT[n] > 0;
            boolean bl10 = bl4 = LegsNet.LEFT[n] < 0;
            if ((bl || bl2 || bl3 || bl4) && AutoMineController.qip((class_1937)class_3102.field_1687, class_7462, n)) {
                bl4 = false;
                bl3 = false;
                bl2 = false;
                bl = false;
            }
            bl5 = this.qgs.jump() && class_7462.method_24828();
            bl7 = true;
        }
        class_3152.field_1894.method_23481(bl);
        class_3152.field_1881.method_23481(bl2);
        class_3152.field_1913.method_23481(bl3);
        class_3152.field_1849.method_23481(bl4);
        class_3152.field_1903.method_23481(bl5);
        boolean bl11 = this.qgl = bl || bl2 || bl3 || bl4 || bl5;
        this.qix(class_3102, bl7 ? this.qgs.sprint() && bl && !bl2 : this.qgx && bl && !bl2 && !bl6);
        class_2432 = class_3152.field_1886;
        boolean bl12 = false;
        class_3965 class_39652 = null;
        if (this.qfr != null) {
            class_3102.field_1773.method_3190(1.0f);
            class_239 class_2392 = class_3102.field_1765;
            if (class_2392 instanceof class_3965) {
                class_3965 class_39653 = (class_3965)class_2392;
                if (class_2392.method_17783() == class_239.class_240.field_1332 && class_39653.method_17777().equals((Object)this.qfr)) {
                    bl12 = true;
                    class_39652 = class_39653;
                }
            }
        }
        if (bl12 && this.qhr > 0) {
            --this.qhr;
            bl12 = false;
            this.qgk = 0;
            if (this.qgd) {
                class_2432.method_23481(false);
                this.qgd = false;
            }
            return;
        }
        int n = this.qgk = this.qfr == null || bl12 ? 0 : this.qgk + 1;
        if (bl12 && this.qgd && this.qfr.equals((Object)this.qgf) && !class_3102.field_1761.method_2923()) {
            if (++this.qge >= 2) {
                this.qge = 0;
                bl12 = false;
                this.qgf = null;
            }
        } else {
            this.qge = 0;
        }
        if (bl12) {
            if (!this.qfr.equals((Object)this.qgf)) {
                class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_2432);
                if (!class_3062.equals((Object)class_3675.field_16237)) {
                    class_304.method_1420((class_3675.class_306)class_3062);
                }
                this.qgg = this.qgf = this.qfr.method_10062();
                this.qgh = class_39652.method_17780();
                this.qgi = Reflect.getFloat(qek, class_7462, class_7462.method_36454());
                this.qgj = Reflect.getFloat(qel, class_7462, class_7462.method_36455());
            }
            class_2432.method_23481(true);
            this.qgd = true;
        } else if (this.qgd) {
            class_2432.method_23481(false);
            this.qgd = false;
        }
    }

    private void qis(class_310 class_3102, boolean bl) {
        class_304 class_3042 = class_3102.field_1690.field_1832;
        if (((Boolean)class_3102.field_1690.method_42449().method_41753()).booleanValue()) {
            if (bl != class_3042.method_1434()) {
                class_3042.method_23481(true);
            }
        } else {
            class_3042.method_23481(bl);
        }
        this.qhb = bl;
    }

    private void qit(class_310 class_3102, class_746 class_7462) {
        class_315 class_3152 = class_3102.field_1690;
        this.qix(class_3102, false);
        if (this.qgd) {
            class_3152.field_1886.method_23481(false);
            this.qgd = false;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        if (this.qhi != null && this.qhk < 3) {
            double d = this.qhi.field_1352 - class_7462.method_23317();
            double d2 = this.qhi.field_1350 - class_7462.method_23321();
            double d3 = Math.sqrt(d * d + d2 * d2);
            class_243 class_2432 = class_7462.method_18798();
            double d4 = Math.sqrt(class_2432.field_1352 * class_2432.field_1352 + class_2432.field_1350 * class_2432.field_1350);
            if (d3 > 0.2) {
                boolean bl7;
                double d5 = class_3532.method_15338((double)(AngleUtil.yawTo(d, d2) - (double)class_7462.method_36454()));
                boolean bl8 = bl7 = class_7462.method_24828() && d3 < d4 * 1.5 + 0.04;
                if (!bl7) {
                    bl = Math.abs(d5) < 67.5;
                    bl2 = Math.abs(d5) > 112.5;
                    bl4 = d5 > 22.5 && d5 < 157.5;
                    bl3 = d5 < -22.5 && d5 > -157.5;
                }
                bl6 = d3 < 0.9;
                bl5 = class_7462.method_24828() && class_7462.field_5976 && this.qhi.field_1351 > class_7462.method_23318() + 0.6;
                this.qhl = Math.max(this.qhl, 6);
            } else if (class_7462.method_24828() && d4 < 0.02 && Math.abs(class_7462.method_23317() - class_7462.field_6014) + Math.abs(class_7462.method_23321() - class_7462.field_5969) < 0.003) {
                if (this.qhl > 0) {
                    --this.qhl;
                } else {
                    this.qhm.run();
                    ++this.qhk;
                    this.qhl = 40;
                    this.qlj("/sit at " + class_7462.method_24515().method_23854() + " try " + this.qhk);
                }
            }
        }
        class_3152.field_1894.method_23481(bl);
        class_3152.field_1881.method_23481(bl2);
        class_3152.field_1913.method_23481(bl3);
        class_3152.field_1849.method_23481(bl4);
        class_3152.field_1903.method_23481(bl5);
        this.qgl = bl || bl2 || bl3 || bl4 || bl5;
        this.qis(class_3102, bl6);
    }

    private void qiu(class_1937 class_19372, class_746 class_7462) {
        double d;
        class_243 class_2432;
        if (class_7462.method_5765() || this.qhc == null) {
            return;
        }
        if (this.qhi != null && (this.qhh == null || AutoMineController.qiw(class_19372.method_8320(this.qhh)))) {
            return;
        }
        this.qhh = null;
        if (AutoMineController.qiw(class_19372.method_8320(this.qhc)) && AutoMineController.qiv(class_19372, this.qhc)) {
            this.qhh = this.qhc;
        } else if (AutoMineController.qiw(class_19372.method_8320(this.qhc.method_10074())) && AutoMineController.qiv(class_19372, this.qhc.method_10074())) {
            this.qhh = this.qhc.method_10074();
        } else {
            class_2432 = class_243.method_24953((class_2382)this.qhc);
            d = Double.MAX_VALUE;
            for (int i = -3; i <= 3; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -3; k <= 3; ++k) {
                        class_2338 class_23382 = this.qhc.method_10069(i, j, k);
                        class_2680 class_26802 = class_19372.method_8320(class_23382);
                        if (!AutoMineController.qiw(class_26802) || !AutoMineController.qiv(class_19372, class_23382)) continue;
                        double d2 = class_243.method_24953((class_2382)class_23382).method_1022(class_2432) + (class_26802.method_26204() instanceof class_2510 ? 0.0 : 1.5);
                        if (!(d2 < d)) continue;
                        d = d2;
                        this.qhh = class_23382.method_10062();
                    }
                }
            }
        }
        if (this.qhh != null) {
            class_2432 = class_19372.method_8320(this.qhh).method_26220((class_1922)class_19372, this.qhh);
            d = class_2432.method_1110() ? 0.0 : class_2432.method_1105(class_2350.class_2351.field_11052);
            this.qhi = new class_243((double)this.qhh.method_10263() + 0.5, (double)this.qhh.method_10264() + d, (double)this.qhh.method_10260() + 0.5);
        } else {
            this.qhi = new class_243((double)this.qhc.method_10263() + 0.5, (double)this.qhc.method_10264(), (double)this.qhc.method_10260() + 0.5);
        }
        this.qhj = new Object();
        this.qlj("seat " + (this.qhh == null ? "spot " + this.qhc.method_23854() : this.qhh.method_23854()));
    }

    private static boolean qiv(class_1937 class_19372, class_2338 class_23382) {
        return class_19372.method_8320(class_23382.method_10084()).method_26220((class_1922)class_19372, class_23382.method_10084()).method_1110() && class_19372.method_8320(class_23382.method_10086(2)).method_26220((class_1922)class_19372, class_23382.method_10086(2)).method_1110();
    }

    private static boolean qiw(class_2680 class_26802) {
        return class_26802.method_26204() instanceof class_2510 || class_26802.method_26204() instanceof class_2482;
    }

    private void qix(class_310 class_3102, boolean bl) {
        class_304 class_3042 = class_3102.field_1690.field_1867;
        if (((Boolean)class_3102.field_1690.method_42450().method_41753()).booleanValue()) {
            if (bl != class_3042.method_1434()) {
                class_3042.method_23481(true);
            }
        } else {
            class_3042.method_23481(bl);
        }
        this.qha = bl;
    }

    public void releaseKeys(class_310 class_3102) {
        if (class_3102 == null || class_3102.field_1690 == null || class_3102.method_22683() == null) {
            return;
        }
        class_315 class_3152 = class_3102.field_1690;
        if (this.qhb) {
            if (((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
                if (class_3152.field_1832.method_1434()) {
                    class_3152.field_1832.method_23481(true);
                }
            } else {
                class_3152.field_1832.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1832));
            }
            this.qhb = false;
        }
        if (this.qha) {
            if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
                if (class_3152.field_1867.method_1434()) {
                    class_3152.field_1867.method_23481(true);
                }
            } else {
                class_3152.field_1867.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1867));
            }
            this.qha = false;
        }
        if (this.qgl) {
            for (class_304 class_3042 : new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903}) {
                class_3042.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3042));
            }
            this.qgl = false;
        }
        if (this.qgd) {
            class_3152.field_1886.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1886));
            this.qgd = false;
        }
        this.qgf = null;
    }

    private boolean qiy(class_1937 class_19372, class_746 class_7462) {
        class_243 class_2432;
        class_2680 class_26802 = class_19372.method_8320(this.qfr);
        if (class_26802.method_26215() || class_26802.method_26204() != this.qfs || !AutoMineController.qld(class_19372, this.qfr)) {
            if (class_26802.method_26215()) {
                this.qiz(class_19372, class_7462);
            }
            return false;
        }
        if (this.qfi - this.qfw > 200 || this.qgk > (this.qgr != null ? 12 : (this.qgs != null ? 14 : 80))) {
            this.qlj((this.qfi - this.qfw > 200 ? "break timeout " : "aim failed ") + this.qfr.method_23854());
            this.qlf(this.qfr, this.qgr != null ? 100 : (this.qgs != null ? 200 : 600));
            if (this.qfj != null && this.qgr == null && this.qgs == null) {
                this.qlf(this.qfj.target(), 600);
            }
            return false;
        }
        if (this.qgr != null ? this.qgk == 4 || this.qgk == 8 : (this.qgs != null ? this.qgk == 5 || this.qgk == 10 : this.qgk == 30 || this.qgk == 55)) {
            class_2432 = this.qkx(class_19372, class_7462, this.qfr);
            if (class_2432 == null) {
                return false;
            }
            this.qfu = class_2432;
            this.qfv = new Object();
        }
        if (((this.qfi - this.qfw) % 5 == 0 || this.qgr != null && this.qgk > 0) && (this.qfu.method_1022(class_2432 = class_7462.method_33571()) > 4.4 || !AutoMineController.qky(class_19372, class_7462, class_2432, this.qfr, this.qfu))) {
            class_243 class_2433 = this.qkx(class_19372, class_7462, this.qfr);
            if (class_2433 == null) {
                return false;
            }
            this.qfu = class_2433;
        }
        return true;
    }

    private void qiz(class_1937 class_19372, class_746 class_7462) {
        long l2 = this.qfr.method_10063();
        this.qey.add(new qcu(l2, this.qfs, this.qfi));
        if (!this.qgy || this.qgh == null || !this.qfr.equals((Object)this.qgg)) {
            LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
            longOpenHashSet.add(l2);
            this.qes.exclude(longOpenHashSet);
            return;
        }
        this.qgg = null;
        int n = this.qgh.method_10166().ordinal();
        double[] dArray = LookModel.lookAxes(this.qgi, this.qgj);
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        int n2 = this.qes.lag() + 3;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    if (i == 0 && j == 0 && k == 0) continue;
                    int[] nArray = new int[]{i, j, k};
                    boolean bl = nArray[n] == 0;
                    for (int i2 = 0; i2 < 3 && !bl; ++i2) {
                        bl = dArray[i2] > 0.0 && nArray[i2] == 0;
                    }
                    long l3 = class_2338.method_10096((long)l2, (int)i, (int)j, (int)k);
                    if (!bl || !this.qfg.contains(class_2338.method_10061((long)l3), class_2338.method_10071((long)l3), class_2338.method_10083((long)l3))) continue;
                    longOpenHashSet.add(l3);
                    if (!(this.qes.expect(l3, l2, n, dArray) >= 0.5)) continue;
                    this.qfb.put(l3, this.qfi + n2);
                }
            }
        }
        longOpenHashSet.add(l2);
        this.qes.exclude(longOpenHashSet);
        if (!this.qes.probing()) {
            LongOpenHashSet longOpenHashSet2 = new LongOpenHashSet();
            for (qdo qdo2 : this.qfd) {
                longOpenHashSet2.addAll((LongCollection)qdo2.blocks());
            }
            this.qes.open(l2, this.qfi, n, dArray, l -> this.qjb(class_19372, l), longOpenHashSet2);
        }
        this.qfd.add(new qdo(this.qfi, longOpenHashSet));
        this.qja(class_19372, class_7462, l2, n, dArray, longOpenHashSet);
    }

    private void qja(class_1937 class_19372, class_746 class_7462, long l, int n, double[] dArray, LongOpenHashSet longOpenHashSet) {
        if (!this.qeu || this.qes.votes() < 3 || class_7462 == null) {
            return;
        }
        LongOpenHashSet longOpenHashSet2 = AutoMineController.qjp(class_19372, class_7462, AutoMineController.standing(class_19372, class_7462).method_10264());
        class_238 class_2383 = class_7462.method_5829().method_1014(0.05);
        int n2 = this.qfi + this.qes.lag() * 2 + 6;
        LongIterator longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            class_2338 class_23382;
            long l2 = longIterator.nextLong();
            if (l2 == l || longOpenHashSet2.contains(l2) || !this.qjb(class_19372, l2) || this.qes.expect(l2, l, n, dArray) < 0.9 || new class_238(class_23382 = class_2338.method_10092((long)l2)).method_994(class_2383)) continue;
            this.qet.ghost(class_19372, class_23382, n2);
        }
    }

    private boolean qjb(class_1937 class_19372, long l) {
        class_2338 class_23382 = class_2338.method_10092((long)l);
        if (this.qfg == null || !this.qfg.contains(class_23382) || this.qev.contains(l)) {
            return false;
        }
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        return !class_26802.method_26215() && class_26802.method_26227().method_15769() && class_26802.method_26214((class_1922)class_19372, class_23382) >= 0.0f;
    }

    private void qjc(class_1937 class_19372, class_746 class_7462) {
        if (this.qfc.isEmpty()) {
            return;
        }
        class_243 class_2432 = class_7462.method_33571();
        LongIterator longIterator = this.qfc.iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.nextLong();
            class_2338 class_23382 = class_2338.method_10092((long)l);
            class_2680 class_26802 = class_19372.method_8320(class_23382);
            if (class_26802.method_26215()) {
                if (this.qet.isGhost(l)) continue;
                ++this.qfp;
                longIterator.remove();
                continue;
            }
            if (this.qfe.test(class_26802) && !(class_243.method_24953((class_2382)class_23382).method_1025(class_2432) > 81.0)) continue;
            longIterator.remove();
        }
    }

    private void qjd(class_1937 class_19372, class_746 class_7462) {
        boolean bl;
        if (this.qhf) {
            this.qfx = null;
            this.qga = null;
            return;
        }
        if (this.qhc != null && this.qhd && AutoMineController.standing(class_19372, class_7462).method_10262((class_2382)this.qhc) <= 25.0) {
            this.qfx = null;
            this.qga = null;
            return;
        }
        if (this.qhc == null && (this.qgr != null || this.qgs != null) && this.qfg.maxX >= this.qfg.minX) {
            this.qje(class_19372, class_7462);
            return;
        }
        if (this.qhc == null && this.qgr != null && this.qke(class_19372, class_7462)) {
            this.qfn = 0;
            return;
        }
        if (!(class_7462.method_24828() || class_7462.method_5799() || class_7462.method_6101())) {
            return;
        }
        class_2338 class_23382 = AutoMineController.standing(class_19372, class_7462);
        if (this.qfj != null && !this.qfl && this.qfi < this.qfm) {
            int n = this.qkm(class_23382);
            if (n < 0) {
                this.qlj("off path at " + class_23382.method_23854());
                this.qfl = true;
            } else {
                this.qfk = n;
            }
        }
        if (this.qhc == null && this.qfj != null && !this.qfl && !this.qkr(class_19372, this.qfj.target())) {
            this.qlj("target gone " + this.qfj.target().method_23854());
            this.qfl = true;
        }
        if (this.qfj == null || this.qfl || this.qfi >= this.qfm) {
            this.qkq(class_19372, class_7462);
        }
        if (this.qhc != null) {
            if (this.qfj == null) {
                this.qfx = null;
                this.qga = null;
                if (class_23382.method_10262((class_2382)this.qhc) <= 25.0) {
                    this.qhd = true;
                } else if (!this.qhd) {
                    this.qhe = true;
                }
                return;
            }
            if (this.qfk >= this.qkl() - 1) {
                if (!this.qhd) {
                    this.qlj("parked at " + class_23382.method_23854());
                }
                this.qhd = true;
                this.qfx = null;
                this.qga = null;
                return;
            }
            this.qhd = false;
            this.qjw(class_19372, class_7462, false);
            return;
        }
        if (this.qfj == null) {
            this.qfx = null;
            this.qga = null;
            if (!this.qfo && ++this.qfn > 30) {
                this.qfh = qdw.DONE;
            }
            return;
        }
        this.qfn = 0;
        class_2338 class_23383 = this.qfj.target();
        if (this.qfb.getOrDefault(class_23383.method_10063(), 0) > this.qfi) {
            this.qfx = null;
            return;
        }
        class_243 class_2432 = class_7462.method_33571();
        boolean bl2 = bl = this.qfk >= this.qkl() - 1;
        if (bl || class_243.method_24953((class_2382)class_23383).method_1022(class_2432) <= 4.2) {
            class_243 class_2433 = this.qkx(class_19372, class_7462, class_23383);
            if (class_2433 != null) {
                this.qku(class_23383, class_19372.method_8320(class_23383).method_26204(), true, class_2433);
                return;
            }
            if (bl) {
                class_2338 class_23384 = AutoMineController.qla(class_19372, class_7462, class_2432, class_23383);
                if (class_23384 != null && this.qlc(class_19372, class_23384)) {
                    this.qkt(class_19372, class_7462, class_23384, false);
                    if (this.qfr != null) {
                        return;
                    }
                }
                this.qlf(class_23383, 400);
                this.qfl = true;
                this.qfx = null;
                return;
            }
        }
        this.qjw(class_19372, class_7462, true);
    }

    private void qje(class_1937 class_19372, class_746 class_7462) {
        boolean bl;
        boolean bl2;
        boolean bl3 = bl2 = class_7462.method_24828() || class_7462.method_5799() || class_7462.method_6101();
        if (!bl2) {
            int n;
            this.qfx = null;
            this.qga = null;
            if (this.qho != Integer.MIN_VALUE && (n = this.qjj(class_19372, class_7462)) != Integer.MIN_VALUE && n + 1 > this.qho) {
                this.qjk(class_19372, class_7462, this.qji(class_19372, class_7462, n));
            }
            this.qjf(4);
            return;
        }
        class_2338 class_23382 = AutoMineController.standing(class_19372, class_7462);
        int n = class_23382.method_10264();
        if (this.qho != Integer.MIN_VALUE) {
            if (n > this.qho && this.qjk(class_19372, class_7462, this.qji(class_19372, class_7462, n - 1))) {
                this.qfn = 0;
                this.qjf(3);
                return;
            }
            this.qho = Integer.MIN_VALUE;
        }
        if (this.qfi >= this.qih) {
            this.qih = this.qfi + 20;
            this.qii = this.qjg(class_19372);
        }
        if (this.qii >= 0 && this.qii <= 4) {
            this.qlj("only " + this.qii + " diamonds left: done");
            this.qfx = null;
            this.qga = null;
            this.qfh = qdw.DONE;
            return;
        }
        boolean bl4 = bl = this.qfx != null && this.qfi - this.qhp < 8;
        if (this.qgs != null ? this.qjm(class_19372, class_7462, n, bl) || this.qjl(class_19372, class_7462, n, bl) : this.qjl(class_19372, class_7462, n, bl)) {
            this.qfn = 0;
            this.qjf(0);
            return;
        }
        if (this.qjt(class_19372, class_7462, n)) {
            this.qfn = 0;
            this.qjf(1);
            return;
        }
        if (this.qjh(class_19372, n)) {
            this.qjf(5);
            return;
        }
        if (n > this.qfg.minY) {
            class_2338 class_23383 = this.qji(class_19372, class_7462, n - 1);
            if (class_23383 != null && this.qjk(class_19372, class_7462, class_23383)) {
                this.qho = Math.max(this.qfg.minY, n - 3);
                this.qfn = 0;
                this.qlj("down from " + n + " to " + this.qho);
                this.qjf(3);
                return;
            }
            if (this.qju(class_19372, class_7462, n)) {
                this.qfn = 0;
                this.qjf(1);
                return;
            }
        }
        this.qfx = null;
        this.qga = null;
        this.qjf(5);
        if (++this.qfn > 30) {
            this.qfh = qdw.DONE;
        }
    }

    private void qjf(int n) {
        int n2 = n;
        this.qie[n2] = this.qie[n2] + 1;
    }

    private int qjg(class_1937 class_19372) {
        int n = 0;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = this.qfg.minX; i <= this.qfg.maxX; ++i) {
            for (int j = this.qfg.minZ; j <= this.qfg.maxZ; ++j) {
                for (int k = this.qfg.minY; k <= this.qfg.maxY; ++k) {
                    if (!this.qfe.test(class_19372.method_8320((class_2338)class_23392.method_10103(i, k, j))) || this.qev.contains(class_23392.method_10063())) continue;
                    ++n;
                }
            }
        }
        return n;
    }

    public int diamondsLeft() {
        return this.qii;
    }

    public String sweepStats() {
        String[] stringArray = new String[]{"pick", "walk", "collect", "down", "fall", "idle", "breaking"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; ++i) {
            stringBuilder.append(stringArray[i]).append(' ').append(this.qie[i]).append(i + 1 < stringArray.length ? " " : "");
        }
        return stringBuilder.toString();
    }

    private boolean qjh(class_1937 class_19372, int n) {
        if (this.qif == n) {
            return false;
        }
        this.qif = n;
        boolean bl = false;
        int n2 = Math.min(this.qfg.maxY, n + 4);
        ObjectIterator objectIterator = this.qew.long2LongEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            Long2LongMap.Entry entry = (Long2LongMap.Entry)objectIterator.next();
            int n3 = class_2338.method_10071((long)entry.getLongKey());
            if (entry.getLongValue() <= (long)this.qfi || n3 < n || n3 > n2) continue;
            objectIterator.remove();
            bl = true;
        }
        return bl;
    }

    private class_2338 qji(class_1937 class_19372, class_746 class_7462, int n) {
        class_238 class_2383 = class_7462.method_5829();
        class_2338 class_23382 = null;
        double d = Double.MAX_VALUE;
        for (int i = class_3532.method_15357((double)(class_2383.field_1323 + 0.001)); i <= class_3532.method_15357((double)(class_2383.field_1320 - 0.001)); ++i) {
            for (int j = class_3532.method_15357((double)(class_2383.field_1321 + 0.001)); j <= class_3532.method_15357((double)(class_2383.field_1324 - 0.001)); ++j) {
                class_2338 class_23383 = new class_2338(i, n, j);
                class_2680 class_26802 = class_19372.method_8320(class_23383);
                if (class_26802.method_26220((class_1922)class_19372, class_23383).method_1110()) continue;
                if (!this.qfg.contains(class_23383) || !AutoMineController.qjq(class_19372, class_23383, class_26802) || this.qev.contains(class_23383.method_10063()) || this.qew.getOrDefault(class_23383.method_10063(), 0L) > (long)this.qfi) {
                    return null;
                }
                double d2 = ((double)i + 0.5 - class_7462.method_23317()) * ((double)i + 0.5 - class_7462.method_23317()) + ((double)j + 0.5 - class_7462.method_23321()) * ((double)j + 0.5 - class_7462.method_23321());
                if (!(d2 < d)) continue;
                d = d2;
                class_23382 = class_23383;
            }
        }
        return class_23382;
    }

    private int qjj(class_1937 class_19372, class_746 class_7462) {
        int n;
        class_238 class_2383 = class_7462.method_5829();
        for (int i = n = class_3532.method_15357((double)(class_7462.method_23318() - 0.001)); i >= n - 4; --i) {
            for (int j = class_3532.method_15357((double)(class_2383.field_1323 + 0.001)); j <= class_3532.method_15357((double)(class_2383.field_1320 - 0.001)); ++j) {
                for (int k = class_3532.method_15357((double)(class_2383.field_1321 + 0.001)); k <= class_3532.method_15357((double)(class_2383.field_1324 - 0.001)); ++k) {
                    class_2338 class_23382 = new class_2338(j, i, k);
                    if (class_19372.method_8320(class_23382).method_26220((class_1922)class_19372, class_23382).method_1110()) continue;
                    return i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private boolean qjk(class_1937 class_19372, class_746 class_7462, class_2338 class_23382) {
        if (class_23382 == null) {
            return false;
        }
        if (this.qfb.getOrDefault(class_23382.method_10063(), 0) > this.qfi) {
            this.qfx = null;
            return true;
        }
        class_243 class_2432 = null;
        for (qda qda2 : this.qki(class_19372, class_7462, class_23382)) {
            if (qda2.axis() != class_2350.class_2351.field_11052.ordinal() || !(qda2.point().field_1351 < class_7462.method_23320())) continue;
            class_2432 = qda2.point();
            break;
        }
        if (class_2432 == null) {
            class_2432 = this.qkx(class_19372, class_7462, class_23382);
        }
        if (class_2432 == null) {
            return false;
        }
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        this.qku(class_23382, class_26802.method_26204(), this.qfe.test(class_26802), class_2432);
        this.qfx = null;
        this.qga = null;
        return true;
    }

    private boolean qjl(class_1937 class_19372, class_746 class_7462, int n3, boolean bl) {
        double d;
        double d2;
        int n4;
        class_243 class_2432 = class_7462.method_33571();
        int n5 = class_3532.method_15357((double)class_2432.field_1352);
        int n6 = class_3532.method_15357((double)class_2432.field_1350);
        int n7 = Math.max(this.qfg.minY, n3);
        int n8 = Math.min(this.qfg.maxY, class_3532.method_15357((double)(class_2432.field_1351 + 4.4)));
        LongOpenHashSet longOpenHashSet = AutoMineController.qjp(class_19372, class_7462, n3);
        LongArrayList longArrayList = new LongArrayList();
        DoubleArrayList doubleArrayList = new DoubleArrayList();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        double d3 = 24.010000000000005;
        for (int i = n5 - 5; i <= n5 + 5; ++i) {
            for (n4 = n6 - 5; n4 <= n6 + 5; ++n4) {
                for (int j = n7; j <= n8; ++j) {
                    double d4;
                    double d5;
                    double d6;
                    class_2680 class_26802;
                    if (!this.qfg.contains(i, j, n4) || !AutoMineController.qjq(class_19372, (class_2338)class_23392, class_26802 = class_19372.method_8320((class_2338)class_23392.method_10103(i, j, n4)))) continue;
                    long l = class_2338.method_10064((int)i, (int)j, (int)n4);
                    if (this.qfe.test(class_26802)) {
                        this.qfc.add(l);
                    }
                    if ((d6 = (double)i + 0.5 - class_2432.field_1352) * d6 + (d5 = (double)j + 0.5 - class_2432.field_1351) * d5 + (d4 = (double)n4 + 0.5 - class_2432.field_1350) * d4 > d3 || this.qkb(l) || !AutoMineController.qjr(class_19372, (class_2338)class_23392)) continue;
                    d2 = AutoMineController.qim(class_7462, new class_243((double)i + 0.5, (double)j + 0.5, (double)n4 + 0.5));
                    d = j == n3 + 1 ? 3.0 : (j == n3 ? 1.2 : 1.8);
                    longArrayList.add(l);
                    doubleArrayList.add(this.qka(class_26802) * d / AutoMineController.qjo(d2));
                }
            }
        }
        if (longArrayList.isEmpty()) {
            return false;
        }
        Integer[] integerArray = new Integer[longArrayList.size()];
        for (n4 = 0; n4 < integerArray.length; ++n4) {
            integerArray[n4] = n4;
        }
        Arrays.sort(integerArray, (n, n2) -> Double.compare(doubleArrayList.getDouble(n2.intValue()), doubleArrayList.getDouble(n.intValue())));
        qda qda2 = null;
        double d7 = 0.0;
        boolean bl2 = false;
        for (int i = 0; i < Math.min(14, integerArray.length); ++i) {
            long l = longArrayList.getLong(integerArray[i].intValue());
            class_2338 class_23382 = class_2338.method_10092((long)l);
            class_2680 class_26803 = class_19372.method_8320(class_23382);
            for (qda qda3 : this.qki(class_19372, class_7462, class_23382)) {
                d2 = AutoMineController.qjo(qda3.turn());
                d = this.qjn(class_19372, class_23382, class_26803, qda3.axis(), qda3.look(), n3, longOpenHashSet, class_23392) / d2;
                double d8 = qda3.turn() < 2.0 ? 0.0 : this.qjn(class_19372, class_23382, class_26803, qda3.axis(), LookModel.lookAxes(qda3.yaw(), qda3.pitch()), n3, longOpenHashSet, class_23392) / (d2 + 1.0);
                double d9 = d8;
                double d10 = Math.max(d, d9);
                if (!(d10 > d7)) continue;
                d7 = d10;
                qda2 = qda3;
                bl2 = d9 > d;
            }
        }
        if (qda2 == null) {
            return false;
        }
        class_2680 class_26804 = class_19372.method_8320(qda2.pos());
        this.qkv(qda2.pos(), class_26804.method_26204(), this.qfe.test(class_26804), qda2.point(), bl);
        this.qhr = bl2 ? 1 : 0;
        return true;
    }

    private boolean qjm(class_1937 class_19372, class_746 class_7462, int n, boolean bl) {
        Object object;
        class_2338 class_23382 = null;
        if (!this.qey.isEmpty() && this.qfi - ((qcu)(object = this.qey.get(this.qey.size() - 1))).tick() <= 40) {
            class_23382 = class_2338.method_10092((long)((qcu)object).pos());
        }
        if (((Object)(object = (Object)this.qgs.rank(class_19372, class_7462, this.qfg, l -> this.qew.getOrDefault(l, 0L) > (long)this.qfi || this.qev.contains(l), l -> this.qfb.getOrDefault(l, 0) > this.qfi, class_23382, 6))).length == 0) {
            return false;
        }
        LongOpenHashSet longOpenHashSet = AutoMineController.qjp(class_19372, class_7462, n);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (Object object2 : object) {
            class_2338 class_23383 = class_2338.method_10092((long)object2);
            class_2680 class_26802 = class_19372.method_8320(class_23383);
            if (!this.qfg.contains(class_23383) || this.qkb((long)object2) || !AutoMineController.qjq(class_19372, class_23383, class_26802)) continue;
            qda qda2 = null;
            double d = Double.NEGATIVE_INFINITY;
            boolean bl2 = false;
            for (qda qda3 : this.qki(class_19372, class_7462, class_23383)) {
                double d2 = AutoMineController.qjo(qda3.turn());
                double d3 = this.qjn(class_19372, class_23383, class_26802, qda3.axis(), qda3.look(), n, longOpenHashSet, class_23392) / d2;
                double d4 = qda3.turn() < 2.0 ? Double.NEGATIVE_INFINITY : this.qjn(class_19372, class_23383, class_26802, qda3.axis(), LookModel.lookAxes(qda3.yaw(), qda3.pitch()), n, longOpenHashSet, class_23392) / (d2 + 1.0);
                double d5 = Math.max(d3, d4);
                if (qda2 != null && !(d5 > d)) continue;
                qda2 = qda3;
                d = d5;
                bl2 = d4 > d3;
            }
            if (qda2 == null) continue;
            this.qkv(class_23383, class_26802.method_26204(), this.qfe.test(class_26802), qda2.point(), bl);
            this.qhr = bl2 ? 1 : 0;
            return true;
        }
        return false;
    }

    private double qjn(class_1937 class_19372, class_2338 class_23382, class_2680 class_26802, int n, double[] dArray, int n2, LongOpenHashSet longOpenHashSet, class_2338.class_2339 class_23392) {
        long l = class_23382.method_10063();
        double d = this.qka(class_26802);
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    double d2;
                    class_2680 class_26803;
                    long l2;
                    int n3;
                    int n4;
                    int n5;
                    if (i == 0 && j == 0 && k == 0 || !this.qfg.contains(n5 = class_23382.method_10263() + i, n4 = class_23382.method_10264() + j, n3 = class_23382.method_10260() + k) || this.qkb(l2 = class_2338.method_10064((int)n5, (int)n4, (int)n3)) || !AutoMineController.qjq(class_19372, (class_2338)class_23392, class_26803 = class_19372.method_8320((class_2338)class_23392.method_10103(n5, n4, n3))) || (d2 = this.qes.expect(l2, l, n, dArray)) <= 0.0) continue;
                    if (n4 < n2) {
                        d -= (longOpenHashSet.contains(l2) ? 8.0 : 0.7) * d2;
                        continue;
                    }
                    d += this.qka(class_26803) * d2;
                }
            }
        }
        return d;
    }

    private static double qjo(double d) {
        return 1.0 + d / 55.0 + Math.max(0.0, d - 60.0) / 40.0;
    }

    private static LongOpenHashSet qjp(class_1937 class_19372, class_746 class_7462, int n) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        class_238 class_2383 = class_7462.method_5829();
        for (int i = class_3532.method_15357((double)(class_2383.field_1323 + 0.001)); i <= class_3532.method_15357((double)(class_2383.field_1320 - 0.001)); ++i) {
            for (int j = class_3532.method_15357((double)(class_2383.field_1321 + 0.001)); j <= class_3532.method_15357((double)(class_2383.field_1324 - 0.001)); ++j) {
                longOpenHashSet.add(class_2338.method_10064((int)i, (int)(n - 1), (int)j));
            }
        }
        return longOpenHashSet;
    }

    private static boolean qjq(class_1937 class_19372, class_2338 class_23382, class_2680 class_26802) {
        return !class_26802.method_26215() && class_26802.method_26227().method_15769() && class_26802.method_26214((class_1922)class_19372, class_23382) >= 0.0f && !class_26802.method_26220((class_1922)class_19372, class_23382).method_1110();
    }

    private static boolean qjr(class_1937 class_19372, class_2338 class_23382) {
        for (class_2350 class_23502 : class_2350.values()) {
            class_2338 class_23383 = class_23382.method_10093(class_23502);
            if (!class_19372.method_8320(class_23383).method_26218((class_1922)class_19372, class_23383).method_1110()) continue;
            return true;
        }
        return false;
    }

    private static boolean qjs(class_1937 class_19372, class_2338 class_23382) {
        return class_19372.method_8320(class_23382).method_26220((class_1922)class_19372, class_23382).method_1110();
    }

    private boolean qjt(class_1937 class_19372, class_746 class_7462, int n2) {
        int[] nArray;
        class_2338 class_23382;
        qdk qdk2 = new qdk(this, class_19372, class_7462, n2);
        if (qdk2.start < 0) {
            return false;
        }
        long[] lArray = new long[qdk2.w * qdk2.d];
        Arrays.fill(lArray, Long.MIN_VALUE);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        int n3 = Math.min(this.qfg.maxY, n2 + 4);
        boolean bl = false;
        for (int i = this.qfg.minX; i <= this.qfg.maxX; ++i) {
            block1: for (int j = this.qfg.minZ; j <= this.qfg.maxZ; ++j) {
                for (int k = Math.max(this.qfg.minY, n2); k <= n3; ++k) {
                    long l = class_2338.method_10064((int)i, (int)k, (int)j);
                    if (this.qkb(l) || !AutoMineController.qjq(class_19372, (class_2338)class_23392.method_10103(i, k, j), class_19372.method_8320((class_2338)class_23392))) continue;
                    bl = true;
                    for (int i2 = i - 3; i2 <= i + 3; ++i2) {
                        for (int i3 = j - 3; i3 <= j + 3; ++i3) {
                            double d;
                            double d2;
                            double d3;
                            int n4 = qdk2.index(i2, i3);
                            if (n4 < 0 || lArray[n4] != Long.MIN_VALUE || !((d3 = (double)(i - i2)) * d3 + (d2 = (double)k + 0.5 - ((double)n2 + 1.62)) * d2 + (d = (double)(j - i3)) * d <= 12.96)) continue;
                            lArray[n4] = l;
                        }
                    }
                    continue block1;
                }
            }
        }
        if (!bl) {
            return false;
        }
        if (this.qhq != Long.MIN_VALUE && this.qfi - this.qhp <= 2 && class_243.method_24953((class_2382)(class_23382 = class_2338.method_10092((long)this.qhq))).method_1022(class_7462.method_33571()) <= 3.9) {
            this.qlf(class_23382, 400);
            this.qhq = Long.MIN_VALUE;
        }
        if ((nArray = qdk2.path(n -> n != qdk2.start && lArray[n] != Long.MIN_VALUE && this.qew.getOrDefault(lArray[n], 0L) <= (long)this.qfi)) == null) {
            return false;
        }
        long l = lArray[nArray[nArray.length - 1]];
        this.qjv(qdk2.waypoint(class_7462, nArray), nArray.length <= 3, l, class_243.method_24953((class_2382)class_2338.method_10092((long)l)));
        return true;
    }

    private boolean qju(class_1937 class_19372, class_746 class_7462, int n) {
        qdk qdk2 = new qdk(this, class_19372, class_7462, n);
        if (qdk2.start < 0) {
            return false;
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        int[] nArray = qdk2.path(n2 -> {
            int n3;
            if (n2 == qdk2.start) {
                return false;
            }
            int n4 = qdk2.cellX(n2);
            if (!this.qfg.contains(n4, n - 1, n3 = qdk2.cellZ(n2)) || this.qkb(class_2338.method_10064((int)n4, (int)(n - 1), (int)n3))) {
                return false;
            }
            return AutoMineController.qjq(class_19372, (class_2338)class_23392.method_10103(n4, n - 1, n3), class_19372.method_8320((class_2338)class_23392));
        });
        if (nArray == null) {
            return false;
        }
        int n3 = nArray[nArray.length - 1];
        class_243 class_2432 = nArray.length <= 2 ? new class_243((double)qdk2.cellX(n3) + 0.5, (double)n, (double)qdk2.cellZ(n3) + 0.5) : qdk2.waypoint(class_7462, nArray);
        this.qjv(class_2432, true, class_2338.method_10064((int)qdk2.cellX(n3), (int)(n - 1), (int)qdk2.cellZ(n3)), new class_243((double)qdk2.cellX(n3) + 0.5, (double)n - 0.5, (double)qdk2.cellZ(n3) + 0.5));
        return true;
    }

    private void qjv(class_243 class_2432, boolean bl, long l, class_243 class_2433) {
        if (l != this.qhq) {
            this.qhq = l;
            this.qgb = new Object();
        } else if (this.qgn > 40) {
            this.qgn = 0;
            this.qlf(class_2338.method_10092((long)l), 400);
        }
        this.qfx = class_2432;
        this.qhp = this.qfi;
        this.qfy = false;
        this.qfz = bl;
        this.qga = class_2433;
    }

    private void qjw(class_1937 class_19372, class_746 class_7462, boolean bl) {
        int n;
        class_2338 class_23382 = this.qfj.target();
        int n2 = this.qfj.path()[this.qfk * 3];
        int n3 = this.qfj.path()[this.qfk * 3 + 1];
        int n4 = this.qfj.path()[this.qfk * 3 + 2];
        int n5 = this.qfj.path()[(this.qfk + 1) * 3];
        int n6 = this.qfj.path()[(this.qfk + 1) * 3 + 1];
        int n7 = this.qfj.path()[(this.qfk + 1) * 3 + 2];
        int n8 = this.qjy(class_19372, n2, n3, n4, n5, n6, n7);
        int n9 = this.qfj.path()[n8 * 3];
        int n10 = this.qfj.path()[n8 * 3 + 2];
        class_243 class_2432 = new class_243((double)n9 + 0.5, (double)n6, (double)n10 + 0.5);
        if (bl && this.qjz()) {
            n = this.qkk(class_19372, class_7462);
            if (n < 0) {
                this.qlj("blocked step " + n2 + "," + n3 + "," + n4 + " -> " + n5 + "," + n6 + "," + n7);
                this.qfl = true;
                this.qfx = null;
                return;
            }
            if (n > 0) {
                this.qfx = n == 2 ? null : class_2432;
                this.qfy = n6 > n3;
                this.qfz = true;
                return;
            }
        } else {
            for (class_2338 class_23383 : this.qks(n2, n3, n4, n5, n6, n7)) {
                if (!AutoMineController.qle(class_19372, class_23383)) continue;
                if (!this.qlc(class_19372, class_23383)) {
                    this.qlj("blocked " + class_23383.method_23854() + " step " + n2 + "," + n3 + "," + n4 + " -> " + n5 + "," + n6 + "," + n7);
                    this.qfl = true;
                    this.qfx = null;
                    return;
                }
                this.qkt(class_19372, class_7462, class_23383, false);
                if (this.qfr != null) {
                    return;
                }
                this.qlj("no aim " + class_23383.method_23854() + " step " + n2 + "," + n3 + "," + n4 + " -> " + n5 + "," + n6 + "," + n7);
                this.qfl = true;
                return;
            }
        }
        if (this.qgn > 50) {
            this.qlj("stuck at " + class_7462.method_24515().method_23854() + " to " + n5 + "," + n6 + "," + n7);
            this.qgn = 0;
            if (++this.qgo >= 3) {
                if (this.qhc != null) {
                    this.qhd = true;
                } else {
                    this.qlf(class_23382, 600);
                }
                this.qgo = 0;
            }
            this.qfl = true;
            this.qfx = null;
            return;
        }
        boolean bl2 = this.qfz = n6 <= n3 && (n8 >= this.qkl() - 1 || this.qko(n8));
        if (this.qfx == null || this.qfx.field_1352 != class_2432.field_1352 || this.qfx.field_1351 != class_2432.field_1351 || this.qfx.field_1350 != class_2432.field_1350) {
            this.qlj("walk " + n2 + "," + n3 + "," + n4 + " -> " + n9 + "," + n6 + "," + n10);
        }
        this.qfx = class_2432;
        this.qfy = n6 > n3;
        n = Math.min(this.qkl() - 1, this.qfk + 3);
        int n11 = this.qfj.path()[n * 3];
        int n12 = this.qfj.path()[n * 3 + 1];
        int n13 = this.qfj.path()[n * 3 + 2];
        class_243 class_2433 = class_7462.method_33571();
        if (bl && this.qgr != null && AutoMineController.qjx(class_2433, n11, n13, class_23382)) {
            long l = class_23382.method_10063() ^ 0x5DEECE66DL;
            if (l != this.qgc || this.qga == null) {
                this.qgc = l;
                this.qgb = new Object();
                this.qga = class_243.method_24953((class_2382)class_23382);
            }
            return;
        }
        long l = class_2338.method_10064((int)n11, (int)n12, (int)n13);
        if (l != this.qgc || this.qga == null) {
            this.qgc = l;
            this.qgb = new Object();
            class_243 class_2434 = new class_243((double)n11 + 0.5, (double)n12 + (this.qgr != null ? 1.45 : 0.9), (double)n13 + 0.5);
            class_243 class_2435 = class_2434.method_1020(class_2433);
            double d = Math.sqrt(class_2435.field_1352 * class_2435.field_1352 + class_2435.field_1350 * class_2435.field_1350);
            if (d < 1.5) {
                double d2 = n5 - n2;
                double d3 = n7 - n4;
                double d4 = Math.sqrt(d2 * d2 + d3 * d3);
                if (d4 < 0.5) {
                    double d5 = Math.toRadians(class_7462.method_36454());
                    d2 = -Math.sin(d5);
                    d3 = Math.cos(d5);
                    d4 = 1.0;
                }
                class_2434 = new class_243(class_2433.field_1352 + d2 / d4 * 3.0, class_2433.field_1351 - (n6 < n3 ? 1.6 : 0.4), class_2433.field_1350 + d3 / d4 * 3.0);
            }
            this.qga = class_2434;
        }
    }

    private static boolean qjx(class_243 class_2432, int n, int n2, class_2338 class_23382) {
        double d = (double)n + 0.5 - class_2432.field_1352;
        double d2 = (double)n2 + 0.5 - class_2432.field_1350;
        double d3 = (double)class_23382.method_10263() + 0.5 - class_2432.field_1352;
        double d4 = (double)class_23382.method_10260() + 0.5 - class_2432.field_1350;
        double d5 = Math.sqrt(d * d + d2 * d2);
        double d6 = Math.sqrt(d3 * d3 + d4 * d4);
        if (d5 < 0.5 || d6 < 0.5 || Math.abs((double)class_23382.method_10264() + 0.5 - class_2432.field_1351) > d6 * 0.7) {
            return false;
        }
        return (d * d3 + d2 * d4) / (d5 * d6) > 0.34;
    }

    private int qjy(class_1937 class_19372, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.qfk + 1;
        if (n5 != n2) {
            return n7;
        }
        int n8 = n4 - n;
        int n9 = n6 - n3;
        int n10 = n7;
        int[] nArray = this.qfj.path();
        while (n10 + 1 < this.qkl() && n10 + 1 <= this.qfk + 4) {
            int n11 = nArray[n10 * 3];
            int n12 = nArray[n10 * 3 + 1];
            int n13 = nArray[n10 * 3 + 2];
            int n14 = nArray[(n10 + 1) * 3];
            int n15 = nArray[(n10 + 1) * 3 + 1];
            int n16 = nArray[(n10 + 1) * 3 + 2];
            if (n15 != n12 || n14 - n11 != n8 || n16 - n13 != n9) break;
            boolean bl = true;
            for (class_2338 class_23382 : this.qks(n11, n12, n13, n14, n15, n16)) {
                if (!AutoMineController.qle(class_19372, class_23382)) continue;
                bl = false;
                break;
            }
            if (!bl || !AutoMineController.qle(class_19372, new class_2338(n14, n15 - 1, n16))) break;
            ++n10;
        }
        return n10;
    }

    private boolean qjz() {
        return this.qgr != null && this.qgy;
    }

    private double qka(class_2680 class_26802) {
        return 1.0 + (double)OreTargetMap.value(class_26802) / 15.0;
    }

    private boolean qkb(long l) {
        return this.qfb.getOrDefault(l, 0) > this.qfi || this.qew.getOrDefault(l, 0L) > (long)this.qfi || this.qev.contains(l);
    }

    private int qkc(class_1937 class_19372, class_746 class_7462, class_2338 class_23382, class_2680 class_26802) {
        float f = class_26802.method_26165((class_1657)class_7462, (class_1922)class_19372, class_23382);
        if (f <= 0.0f) {
            return 600;
        }
        return Math.max(1, (int)Math.ceil(1.0f / f));
    }

    private double qkd(double d) {
        return d / Math.max(10.0, this.qil());
    }

    /*
     * WARNING - void declaration
     */
    private boolean qke(class_1937 class_19372, class_746 class_7462) {
        double d;
        Object object;
        if (this.qfg == null || this.qfg.maxX < this.qfg.minX) {
            return false;
        }
        class_243 class_2432 = class_7462.method_33571();
        int n = class_3532.method_15357((double)class_2432.field_1352);
        int n2 = class_3532.method_15357((double)class_2432.field_1351);
        int n3 = class_3532.method_15357((double)class_2432.field_1350);
        double d2 = 6.0;
        Long2DoubleOpenHashMap long2DoubleOpenHashMap = new Long2DoubleOpenHashMap();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = n - 6; i <= n + 6; ++i) {
            for (int j = n2 - 6; j <= n2 + 5; ++j) {
                for (int k = n3 - 6; k <= n3 + 6; ++k) {
                    class_2680 class_26802;
                    long l3;
                    double d3;
                    double d4;
                    double d5;
                    if (!this.qfg.contains(i, j, k) || (d5 = (double)i + 0.5 - class_2432.field_1352) * d5 + (d4 = (double)j + 0.5 - class_2432.field_1351) * d4 + (d3 = (double)k + 0.5 - class_2432.field_1350) * d3 > d2 * d2 || this.qkb(l3 = class_2338.method_10064((int)i, (int)j, (int)k)) || (class_26802 = class_19372.method_8320((class_2338)class_23392.method_10103(i, j, k))).method_26215() || !this.qfe.test(class_26802)) continue;
                    long2DoubleOpenHashMap.put(l3, this.qka(class_26802));
                    this.qfc.add(l3);
                }
            }
        }
        if (long2DoubleOpenHashMap.isEmpty()) {
            return false;
        }
        Long2DoubleOpenHashMap long2DoubleOpenHashMap2 = new Long2DoubleOpenHashMap();
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        for (Long2DoubleMap.Entry entry : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
            class_2338 class_23382;
            long l4 = entry.getLongKey();
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        if ((i != 0 || j != 0 || k != 0) && !this.qgy) continue;
                        longOpenHashSet.add(class_2338.method_10096((long)l4, (int)i, (int)j, (int)k));
                    }
                }
            }
            class_2338 class_23383 = class_2338.method_10092((long)l4);
            if (!(class_243.method_24953((class_2382)class_23383).method_1022(class_2432) <= 4.7) || (class_23382 = AutoMineController.qla(class_19372, class_7462, class_2432, class_23383)) == null || AutoMineController.qkg(class_23382.method_10063(), l4) <= (this.qgy ? 1 : 0)) continue;
            longOpenHashSet.add(class_23382.method_10063());
            double d6 = 0.45 * entry.getDoubleValue();
            if (!(d6 > long2DoubleOpenHashMap2.get(class_23382.method_10063()))) continue;
            long2DoubleOpenHashMap2.put(class_23382.method_10063(), d6);
        }
        boolean bl = this.qgy && this.qes.p(2) < 0.98;
        LongArrayList longArrayList = new LongArrayList();
        Long2DoubleOpenHashMap long2DoubleOpenHashMap3 = new Long2DoubleOpenHashMap();
        LongIterator longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            class_243 class_2433;
            double d7;
            long l5 = longIterator.nextLong();
            class_2338 class_23384 = class_2338.method_10092((long)l5);
            if (!this.qfg.contains(class_23384) || this.qkb(l5) || (d7 = (class_2433 = class_243.method_24953((class_2382)class_23384)).method_1022(class_2432)) > 4.45 || (object = class_19372.method_8320(class_23384)).method_26215() || !object.method_26227().method_15769() || object.method_26214((class_1922)class_19372, class_23384) < 0.0f) continue;
            double d8 = long2DoubleOpenHashMap.get(l5) + long2DoubleOpenHashMap2.get(l5);
            if (bl) {
                for (Object object2 : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
                    long l6 = object2.getLongKey();
                    if (l6 == l5 || AutoMineController.qkg(l6, l5) > 1 || !AutoMineController.qkh(l6, l5)) continue;
                    d8 += object2.getDoubleValue();
                }
            }
            if (d8 <= 0.0) continue;
            double d9 = Math.toDegrees(Math.atan2(0.6, Math.max(0.6, d7)));
            double d10 = (double)this.qkc(class_19372, class_7462, class_23384, (class_2680)object) + this.qkd(Math.max(0.0, this.qgr.error(class_7462, class_2433) - d9)) + 0.35;
            long2DoubleOpenHashMap3.put(l5, d8 / d10);
            longArrayList.add(l5);
        }
        if (longArrayList.isEmpty()) {
            return false;
        }
        longArrayList.sort((l, l2) -> Double.compare(long2DoubleOpenHashMap3.get(l2), long2DoubleOpenHashMap3.get(l)));
        long l7 = AutoMineController.standing(class_19372, class_7462).method_10074().method_10063();
        ArrayList<Long2DoubleMap.Entry> arrayList = new ArrayList<Long2DoubleMap.Entry>();
        int n4 = 0;
        for (int i = 0; i < longArrayList.size() && n4 < 32; ++i) {
            void qdt5;
            Object object2;
            long l8 = longArrayList.getLong(i);
            if (arrayList.size() >= 10 && long2DoubleOpenHashMap3.get(l8) <= ((qdt)arrayList.get(9)).rate()) break;
            ++n4;
            object = class_2338.method_10092((long)l8);
            class_2680 class_26803 = class_19372.method_8320((class_2338)object);
            d = this.qkc(class_19372, class_7462, (class_2338)object, class_26803);
            object2 = null;
            for (qda qda2 : this.qki(class_19372, class_7462, (class_2338)object)) {
                qdt qdt2 = new qdt(qda2, long2DoubleOpenHashMap.get(l8) + long2DoubleOpenHashMap2.get(l8), d);
                qdt2.value = qdt2.own;
                if (long2DoubleOpenHashMap.containsKey(l8)) {
                    qdt2.caught.add(l8);
                    qdt2.chance.add(1.0);
                }
                if (bl) {
                    for (Long2DoubleMap.Entry entry : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
                        double d3;
                        long l3 = entry.getLongKey();
                        if (l3 == l8 || AutoMineController.qkg(l3, l8) > 1 || !((d3 = this.qes.expect(l3, l8, qda2.axis(), qda2.look())) > 0.0)) continue;
                        qdt2.value += entry.getDoubleValue() * d3;
                        qdt2.caught.add(l3);
                        qdt2.chance.add(d3);
                    }
                }
                double d4 = l7 == l8 ? 1.0 : (bl ? this.qes.expect(l7, l8, qda2.axis(), qda2.look()) : 0.0);
                qdt2.time = d + this.qkd(qda2.turn()) + 0.35 + d4 * 0.8;
                if (object2 != null && !(qdt2.rate() > ((qdt)object2).rate())) continue;
                object2 = qdt2;
            }
            if (object2 == null || ((qdt)object2).value <= 0.0) continue;
            boolean n5 = false;
            while (qdt5 < arrayList.size() && ((qdt)arrayList.get((int)qdt5)).rate() >= ((qdt)object2).rate()) {
                ++qdt5;
            }
            arrayList.add((int)qdt5, (Long2DoubleMap.Entry)object2);
            if (arrayList.size() <= 10) continue;
            arrayList.remove(arrayList.size() - 1);
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        qdt qdt3 = null;
        double d13 = 0.0;
        for (qdt qdt4 : arrayList) {
            d = qdt4.rate();
            for (qdt qdt5 : arrayList) {
                if (qdt5 == qdt4 || qdt4.chanceOf(qdt5.key) >= 0.5 || bl && this.qes.expect(qdt5.key, qdt4.key, qdt4.hit.axis(), qdt4.hit.look()) >= 0.5) continue;
                double[] dArray = LookModel.lookAxes(qdt4.hit.yaw(), qdt4.hit.pitch());
                double d5 = qdt5.own * (1.0 - qdt4.chanceOf(qdt5.key));
                if (bl) {
                    for (Long2DoubleMap.Entry entry : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
                        long l4 = entry.getLongKey();
                        if (l4 == qdt5.key || AutoMineController.qkg(l4, qdt5.key) > 1) continue;
                        double d6 = this.qes.expect(l4, qdt5.key, qdt5.hit.axis(), dArray);
                        d5 += entry.getDoubleValue() * d6 * (1.0 - qdt4.chanceOf(l4));
                    }
                }
                double d7 = AutoMineController.qkf(class_2432, qdt4.hit.point(), qdt5.hit.point());
                double d8 = (qdt4.value + d5) / (qdt4.time + qdt5.ticks + this.qkd(d7) + 0.35);
                d = Math.max(d, d8);
            }
            if (!(d > d13)) continue;
            d13 = d;
            qdt3 = qdt4;
        }
        if (qdt3 == null || d13 < 0.12) {
            return false;
        }
        object = qdt3.hit.pos();
        class_2680 class_26804 = class_19372.method_8320((class_2338)object);
        this.qkv((class_2338)object, class_26804.method_26204(), long2DoubleOpenHashMap.containsKey(qdt3.key), qdt3.hit.point(), this.qfx != null && this.qfj != null);
        if (trace != null) {
            this.qlj(String.format(Locale.ROOT, "pick %s v=%.2f t=%.2f turn=%.0f score=%.2f of %d (%s)", object.method_23854(), qdt3.value, qdt3.time, qdt3.hit.turn(), d13, arrayList.size(), this.qes.describe()));
        }
        return true;
    }

    private static double qkf(class_243 class_2432, class_243 class_2433, class_243 class_2434) {
        class_243 class_2435 = class_2433.method_1020(class_2432).method_1029();
        class_243 class_2436 = class_2434.method_1020(class_2432).method_1029();
        return Math.toDegrees(Math.acos(class_3532.method_15350((double)class_2435.method_1026(class_2436), (double)-1.0, (double)1.0)));
    }

    private static int qkg(long l, long l2) {
        return Math.max(Math.abs(class_2338.method_10061((long)l) - class_2338.method_10061((long)l2)), Math.max(Math.abs(class_2338.method_10071((long)l) - class_2338.method_10071((long)l2)), Math.abs(class_2338.method_10083((long)l) - class_2338.method_10083((long)l2))));
    }

    private static boolean qkh(long l, long l2) {
        return class_2338.method_10061((long)l) == class_2338.method_10061((long)l2) || class_2338.method_10071((long)l) == class_2338.method_10071((long)l2) || class_2338.method_10083((long)l) == class_2338.method_10083((long)l2);
    }

    private List<qda> qki(class_1937 class_19372, class_746 class_7462, class_2338 class_23382) {
        ArrayList<qda> arrayList = new ArrayList<qda>(3);
        class_243 class_2432 = class_7462.method_33571();
        double d = (this.qep.nextDouble() - 0.5) * 0.3;
        double d2 = (this.qep.nextDouble() - 0.5) * 0.3;
        block0: for (class_2350 class_23502 : class_2350.values()) {
            class_2338 class_23383 = class_23382.method_10093(class_23502);
            if (!class_19372.method_8320(class_23383).method_26218((class_1922)class_19372, class_23383).method_1110()) continue;
            class_243 class_2433 = new class_243((double)class_23502.method_10148(), (double)class_23502.method_10164(), (double)class_23502.method_10165());
            class_243 class_2434 = class_243.method_24953((class_2382)class_23382).method_1019(class_2433.method_1021(0.5));
            if (class_2432.method_1020(class_2434).method_1026(class_2433) <= 0.02) continue;
            class_243 class_2435 = class_23502.method_10166() == class_2350.class_2351.field_11048 ? new class_243(0.0, 0.0, 1.0) : new class_243(1.0, 0.0, 0.0);
            class_243 class_2436 = class_23502.method_10166() == class_2350.class_2351.field_11052 ? new class_243(0.0, 0.0, 1.0) : new class_243(0.0, 1.0, 0.0);
            for (double[] dArray : qej) {
                double d3;
                double d4 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d : dArray[0];
                double d5 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d2 : dArray[1];
                class_243 class_2437 = class_2434.method_1019(class_2435.method_1021(d4)).method_1019(class_2436.method_1021(d5));
                class_243 class_2438 = class_2437.method_1020(class_2432);
                double d6 = class_2438.method_1033();
                if (d6 > 4.4 || d6 < 0.3 || (d3 = Math.sqrt(class_2438.field_1352 * class_2438.field_1352 + class_2438.field_1350 * class_2438.field_1350)) < 0.25 || !AutoMineController.qky(class_19372, class_7462, class_2432, class_23382, class_2437)) continue;
                float f = (float)AngleUtil.yawTo(class_2438.field_1352, class_2438.field_1350);
                float f2 = (float)AngleUtil.pitchTo(class_2438.field_1351, d3);
                double d7 = Math.hypot(class_3532.method_15393((float)(f - class_7462.method_36454())), f2 - class_7462.method_36455());
                arrayList.add(new qda(class_23382.method_10062(), class_2437, class_23502.method_10166().ordinal(), this.qkj(class_7462, f, f2, d7), d7, f, f2));
                continue block0;
            }
        }
        return arrayList;
    }

    private double[] qkj(class_746 class_7462, float f, float f2, double d) {
        float f3 = class_7462.method_36454();
        float f4 = class_7462.method_36455();
        double d2 = this.qil();
        if (d <= d2 * 0.97) {
            return LookModel.lookAxes(f3, f4);
        }
        double d3 = d2 / d;
        return LookModel.lookAxes((float)((double)f3 + (double)class_3532.method_15393((float)(f - f3)) * d3), (float)((double)f4 + (double)(f2 - f4) * d3));
    }

    private int qkk(class_1937 class_19372, class_746 class_7462) {
        int n;
        long l;
        int n2 = this.qkl();
        int[] nArray = this.qfj.path();
        LongArrayList longArrayList = new LongArrayList();
        DoubleArrayList doubleArrayList = new DoubleArrayList();
        boolean bl = false;
        block0: for (int i = this.qfk; i < Math.min(n2 - 1, this.qfk + 3); ++i) {
            for (class_2338 class_23382 : this.qks(nArray[i * 3], nArray[i * 3 + 1], nArray[i * 3 + 2], nArray[(i + 1) * 3], nArray[(i + 1) * 3 + 1], nArray[(i + 1) * 3 + 2])) {
                if (!AutoMineController.qle(class_19372, class_23382)) continue;
                l = class_23382.method_10063();
                if (this.qfb.getOrDefault(l, 0) > this.qfi) {
                    bl |= i == this.qfk;
                    continue;
                }
                if (!this.qlc(class_19372, class_23382)) {
                    if (i != this.qfk) break block0;
                    return -1;
                }
                if (longArrayList.contains(l)) continue;
                longArrayList.add(l);
                doubleArrayList.add(i == this.qfk ? 1.5 : (i == this.qfk + 1 ? 1.0 : 0.6));
            }
        }
        if (longArrayList.isEmpty()) {
            return bl ? 2 : 0;
        }
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        longOpenHashSet.add(AutoMineController.standing(class_19372, class_7462).method_10074().method_10063());
        for (n = this.qfk; n < Math.min(n2, this.qfk + 5); ++n) {
            longOpenHashSet.add(class_2338.method_10064((int)nArray[n * 3], (int)(nArray[n * 3 + 1] - 1), (int)nArray[n * 3 + 2]));
        }
        for (n = 0; n < longArrayList.size(); ++n) {
            longOpenHashSet.remove(longArrayList.getLong(n));
        }
        LongOpenHashSet longOpenHashSet2 = new LongOpenHashSet();
        for (int i = 0; i < longArrayList.size(); ++i) {
            l = longArrayList.getLong(i);
            longOpenHashSet2.add(l);
            if (!this.qgy) continue;
            longOpenHashSet2.add(class_2338.method_10096((long)l, (int)0, (int)1, (int)0));
            longOpenHashSet2.add(class_2338.method_10096((long)l, (int)0, (int)-1, (int)0));
        }
        class_243 class_2432 = class_7462.method_33571();
        qda qda2 = null;
        double d = 0.0;
        LongIterator longIterator = longOpenHashSet2.iterator();
        while (longIterator.hasNext()) {
            long l2 = longIterator.nextLong();
            class_2338 class_23383 = class_2338.method_10092((long)l2);
            if (longOpenHashSet.contains(l2) || this.qfb.getOrDefault(l2, 0) > this.qfi || !this.qlc(class_19372, class_23383) || class_243.method_24953((class_2382)class_23383).method_1022(class_2432) > 4.5) continue;
            class_2680 class_26802 = class_19372.method_8320(class_23383);
            double d2 = this.qkc(class_19372, class_7462, class_23383, class_26802);
            for (qda qda3 : this.qki(class_19372, class_7462, class_23383)) {
                double d3 = 0.0;
                for (int i = 0; i < longArrayList.size(); ++i) {
                    d3 += doubleArrayList.getDouble(i) * this.qes.expect(longArrayList.getLong(i), l2, qda3.axis(), qda3.look());
                }
                double d4 = 0.0;
                LongIterator longIterator2 = longOpenHashSet.iterator();
                while (longIterator2.hasNext()) {
                    d4 += this.qes.expect(longIterator2.nextLong(), l2, qda3.axis(), qda3.look());
                }
                double d5 = (d3 - 2.5 * d4) / (d2 + this.qkd(qda3.turn()) + 0.35);
                if (!(d5 > d)) continue;
                d = d5;
                qda2 = qda3;
            }
        }
        if (qda2 == null) {
            longIterator = class_2338.method_10092((long)longArrayList.getLong(0));
            this.qkt(class_19372, class_7462, (class_2338)longIterator, false);
            if (this.qfr == null) {
                return -1;
            }
            this.qgz = true;
            return 1;
        }
        longIterator = class_19372.method_8320(qda2.pos());
        this.qkv(qda2.pos(), longIterator.method_26204(), this.qfe.test((class_2680)longIterator), qda2.point(), true);
        return 1;
    }

    private int qkl() {
        return this.qfj.path().length / 3;
    }

    private int qkm(class_2338 class_23382) {
        int n = this.qkl();
        for (int i = this.qfk; i < Math.min(n, this.qfk + 4); ++i) {
            int n2 = this.qfj.path()[i * 3];
            int n3 = this.qfj.path()[i * 3 + 1];
            int n4 = this.qfj.path()[i * 3 + 2];
            if (class_23382.method_10263() == n2 && class_23382.method_10264() == n3 && class_23382.method_10260() == n4) {
                if (i == this.qfk || !this.qko(i) || this.qkn(class_23382, n2, n4)) {
                    return i;
                }
                return i - 1;
            }
            if (i <= 0 || class_23382.method_10263() != n2 || class_23382.method_10260() != n4 || class_23382.method_10264() <= n3 || class_23382.method_10264() > this.qfj.path()[(i - 1) * 3 + 1]) continue;
            return i - 1;
        }
        return -1;
    }

    private boolean qkn(class_2338 class_23382, int n, int n2) {
        return this.qgm != null && Math.abs(this.qgm.field_1352 - ((double)n + 0.5)) < 0.32 && Math.abs(this.qgm.field_1350 - ((double)n2 + 0.5)) < 0.32;
    }

    private boolean qko(int n) {
        int n2 = this.qkl();
        if (n <= 0 || n >= n2 - 1) {
            return false;
        }
        int[] nArray = this.qfj.path();
        int n3 = nArray[n * 3] - nArray[(n - 1) * 3];
        int n4 = nArray[n * 3 + 2] - nArray[(n - 1) * 3 + 2];
        int n5 = nArray[(n + 1) * 3] - nArray[n * 3];
        int n6 = nArray[(n + 1) * 3 + 2] - nArray[n * 3 + 2];
        return n3 != n5 || n4 != n6;
    }

    private List<class_243> qkp(class_1937 class_19372) {
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        if (this.qgp != null && this.qfi < this.qgq) {
            arrayList.add(this.qgp);
        }
        class_238 class_2383 = new class_238((double)(this.qfg.minX - 4), (double)(this.qfg.minY - 2), (double)(this.qfg.minZ - 4), (double)(this.qfg.maxX + 5), (double)(this.qfg.maxY + 6), (double)(this.qfg.maxZ + 5));
        if (this.qhc != null) {
            class_2383 = class_2383.method_991(new class_238(this.qhc).method_1014(6.0));
        }
        for (class_1542 class_15423 : class_19372.method_8390(class_1542.class, class_2383, class_15422 -> this.qff.test(class_15422.method_6983()))) {
            if (arrayList.size() >= 40) continue;
            arrayList.add(class_15423.method_73189());
        }
        return arrayList;
    }

    private void qkq(class_1937 class_19372, class_746 class_7462) {
        Long2IntMap.Entry entry;
        this.qfl = false;
        this.qfm = this.qfi + 20;
        this.qfo = false;
        this.qex.clear();
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        ObjectIterator objectIterator = this.qfb.long2IntEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            entry = (Long2IntMap.Entry)objectIterator.next();
            if (entry.getIntValue() <= this.qfi) {
                objectIterator.remove();
                continue;
            }
            this.qex.add(entry.getLongKey());
        }
        objectIterator = this.qew.long2LongEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            entry = (Long2LongMap.Entry)objectIterator.next();
            if (entry.getLongValue() <= (long)this.qfi) {
                objectIterator.remove();
                continue;
            }
            this.qex.add(entry.getLongKey());
            longOpenHashSet.add(entry.getLongKey());
        }
        if (this.qhc != null) {
            this.qeq.build(class_19372, class_7462, this.qfg, this.qfe, (LongSet)this.qev, this.qkp(class_19372), this.qhc);
            this.qeq.search(AutoMineController.standing(class_19372, class_7462));
            this.qfj = this.qeq.toward(this.qhc, 3);
            this.qfk = 0;
            this.qgc = Long.MIN_VALUE;
            this.qlj(this.qfj == null ? "park: no way to " + this.qhc.method_23854() : "park: path " + this.qfj.path().length / 3 + " nodes to " + this.qhc.method_23854());
            return;
        }
        this.qeq.build(class_19372, class_7462, this.qfg, this.qfe, (LongSet)this.qev, this.qkp(class_19372));
        this.qeq.search(AutoMineController.standing(class_19372, class_7462));
        objectIterator = class_7462.method_33571();
        entry = class_7462.method_5828(1.0f);
        LongArrayList longArrayList = new LongArrayList();
        for (int i = 0; i < this.qeq.targetCount(); ++i) {
            long l = this.qeq.targetKey(i);
            if (longOpenHashSet.contains(l)) continue;
            longArrayList.add(l);
        }
        class_243 class_2432 = class_7462.method_73189();
        this.qer.update(longArrayList, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        this.qfj = null;
        for (int i = 0; i < 4 && this.qfj == null && !this.qer.isEmpty(); ++i) {
            LongOpenHashSet longOpenHashSet2 = this.qer.head();
            this.qfj = this.qeq.best((class_243)objectIterator, (class_243)entry, (LongSet)this.qex, (LongSet)longOpenHashSet2);
            if (this.qfj != null) break;
            boolean bl = true;
            LongIterator longIterator = longOpenHashSet2.iterator();
            while (longIterator.hasNext() && bl) {
                bl = this.qfb.getOrDefault(longIterator.nextLong(), 0) > this.qfi;
            }
            if (bl) {
                this.qfo = true;
                break;
            }
            this.qlj("route: can't reach stop at " + this.qer.headCenter().method_23854());
            longIterator = longOpenHashSet2.iterator();
            while (longIterator.hasNext()) {
                long l = longIterator.nextLong();
                if (this.qfb.getOrDefault(l, 0) > this.qfi) continue;
                this.qlf(class_2338.method_10092((long)l), 600);
                this.qex.add(l);
            }
            this.qer.dropHead();
        }
        if (this.qfj == null && !this.qfo) {
            this.qfj = this.qeq.best((class_243)objectIterator, (class_243)entry, (LongSet)this.qex);
        }
        if (this.qfj == null) {
            this.qfm = this.qfi + 4;
        }
        this.qfk = 0;
        if (trace != null) {
            this.qlj(this.qfj == null ? "plan none (" + this.qeq.targetCount() + " targets" + (this.qfo ? ", 3x3 pending" : "") + ")" : "plan " + this.qfj.target().method_23854() + " nodes=" + this.qfj.path().length / 3 + " cost=" + (int)this.qfj.cost() + " targets=" + this.qeq.targetCount() + " stops=" + this.qer.size() + " at " + class_7462.method_24515().method_23854());
        }
        this.qgc = Long.MIN_VALUE;
    }

    private boolean qkr(class_1937 class_19372, class_2338 class_23382) {
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        return !class_26802.method_26215() && this.qfe.test(class_26802) && !this.qew.containsKey(class_23382.method_10063());
    }

    private List<class_2338> qks(int n, int n2, int n3, int n4, int n5, int n6) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>(3);
        if (n4 == n && n6 == n3) {
            if (n5 < n2) {
                arrayList.add(new class_2338(n, n2 - 1, n3));
            }
            return arrayList;
        }
        if (n5 > n2) {
            arrayList.add(new class_2338(n, n2 + 2, n3));
            arrayList.add(new class_2338(n4, n5 + 1, n6));
            arrayList.add(new class_2338(n4, n5, n6));
            return arrayList;
        }
        arrayList.add(new class_2338(n4, n2 + 1, n6));
        arrayList.add(new class_2338(n4, n2, n6));
        return arrayList;
    }

    private void qkt(class_1937 class_19372, class_746 class_7462, class_2338 class_23382, boolean bl) {
        class_243 class_2432 = this.qkx(class_19372, class_7462, class_23382);
        if (class_2432 == null) {
            class_2338 class_23383 = AutoMineController.qla(class_19372, class_7462, class_7462.method_33571(), class_23382);
            if (class_23383 != null && !class_23383.equals((Object)class_23382) && this.qlc(class_19372, class_23383) && (class_2432 = this.qkx(class_19372, class_7462, class_23383)) != null) {
                this.qku(class_23383, class_19372.method_8320(class_23383).method_26204(), this.qfe.test(class_19372.method_8320(class_23383)), class_2432);
            }
            return;
        }
        this.qku(class_23382, class_19372.method_8320(class_23382).method_26204(), bl || this.qfe.test(class_19372.method_8320(class_23382)), class_2432);
    }

    private void qku(class_2338 class_23382, class_2248 class_22482, boolean bl, class_243 class_2432) {
        this.qkv(class_23382, class_22482, bl, class_2432, false);
    }

    private void qkv(class_2338 class_23382, class_2248 class_22482, boolean bl, class_243 class_2432, boolean bl2) {
        if (class_23382.equals((Object)this.qfr)) {
            return;
        }
        this.qgz = bl2;
        this.qlj("break " + class_23382.method_23854() + " " + class_22482.method_63499().replace("block.minecraft.", "") + (bl ? " T" : ""));
        this.qfr = class_23382.method_10062();
        this.qfs = class_22482;
        this.qft = bl;
        if (bl) {
            this.qfc.add(this.qfr.method_10063());
        }
        this.qfu = class_2432;
        this.qfv = new Object();
        this.qfw = this.qfi;
        this.qgk = 0;
        if (!bl2) {
            this.qfx = null;
        }
    }

    private static class_243 qkw(class_746 class_7462, class_2338 class_23382) {
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_7462.method_5828(1.0f);
        if (class_2338.method_49638((class_2374)class_2432).equals((Object)class_23382)) {
            return class_2432.method_1031(class_2433.field_1352 * 0.6, -0.3, class_2433.field_1350 * 0.6);
        }
        double d = Math.max(0.001, Math.sqrt(class_2433.field_1352 * class_2433.field_1352 + class_2433.field_1350 * class_2433.field_1350));
        return new class_243((double)class_23382.method_10263() + 0.5 + class_2433.field_1352 / d * 0.25, (double)class_23382.method_10264() + 1.0, (double)class_23382.method_10260() + 0.5 + class_2433.field_1350 / d * 0.25);
    }

    private class_243 qkx(class_1937 class_19372, class_746 class_7462, class_2338 class_23382) {
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_7462.method_5828(1.0f);
        class_243 class_2434 = null;
        double d = Double.MAX_VALUE;
        double d2 = (this.qep.nextDouble() - 0.5) * 0.3;
        double d3 = (this.qep.nextDouble() - 0.5) * 0.3;
        block0: for (class_2350 class_23502 : class_2350.values()) {
            class_2338 class_23383 = class_23382.method_10093(class_23502);
            if (!class_19372.method_8320(class_23383).method_26218((class_1922)class_19372, class_23383).method_1110()) continue;
            class_243 class_2435 = new class_243((double)class_23502.method_10148(), (double)class_23502.method_10164(), (double)class_23502.method_10165());
            class_243 class_2436 = class_243.method_24953((class_2382)class_23382).method_1019(class_2435.method_1021(0.5));
            if (class_2432.method_1020(class_2436).method_1026(class_2435) <= 0.02) continue;
            class_243 class_2437 = class_23502.method_10166() == class_2350.class_2351.field_11048 ? new class_243(0.0, 0.0, 1.0) : new class_243(1.0, 0.0, 0.0);
            class_243 class_2438 = class_23502.method_10166() == class_2350.class_2351.field_11052 ? new class_243(0.0, 0.0, 1.0) : new class_243(0.0, 1.0, 0.0);
            for (double[] dArray : qej) {
                double d4;
                double d5;
                double d6;
                double d7 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d2 : dArray[0];
                double d8 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d3 : dArray[1];
                class_243 class_2439 = class_2436.method_1019(class_2437.method_1021(d7)).method_1019(class_2438.method_1021(d8));
                class_243 class_24310 = class_2439.method_1020(class_2432);
                double d9 = class_24310.method_1033();
                if (d9 > 4.4 || d9 < 0.3 || (d6 = Math.sqrt(class_24310.field_1352 * class_24310.field_1352 + class_24310.field_1350 * class_24310.field_1350)) < 0.25 || !AutoMineController.qky(class_19372, class_7462, class_2432, class_23382, class_2439)) continue;
                int n = 0;
                for (double[] dArray2 : qei) {
                    d5 = class_3532.method_15350((double)(d7 + dArray2[0]), (double)-0.47, (double)0.47);
                    double d10 = class_3532.method_15350((double)(d8 + dArray2[1]), (double)-0.47, (double)0.47);
                    if (!AutoMineController.qky(class_19372, class_7462, class_2432, class_23382, class_2436.method_1019(class_2437.method_1021(d5)).method_1019(class_2438.method_1021(d10)))) continue;
                    ++n;
                }
                double d11 = Math.acos(class_3532.method_15350((double)class_24310.method_1021(1.0 / d9).method_1026(class_2433), (double)-1.0, (double)1.0));
                d5 = d11 + (double)(qei.length - n) * 0.35 + ((d4 = d6 / Math.max(0.05, Math.abs(class_24310.field_1351))) < 0.4 ? (0.4 - d4) * 2.0 : 0.0);
                if (d5 < d) {
                    d = d5;
                    class_2434 = class_2439;
                }
                if (n == qei.length) continue block0;
            }
        }
        return class_2434;
    }

    private static boolean qky(class_1937 class_19372, class_746 class_7462, class_243 class_2432, class_2338 class_23382, class_243 class_2433) {
        class_243 class_2434 = class_2433.method_1020(class_2432);
        double d = class_2434.method_1033();
        if (d < 1.0E-4) {
            return false;
        }
        class_243 class_2435 = class_2433.method_1019(class_2434.method_1021(0.08 / d));
        class_3965 class_39652 = class_19372.method_17742(new class_3959(class_2432, class_2435, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        if (class_39652.method_17783() != class_239.class_240.field_1332 || !class_39652.method_17777().equals((Object)class_23382)) {
            return false;
        }
        for (class_238 class_2383 : qhs) {
            if (!class_2383.method_1006(class_2432) && !class_2383.method_992(class_2432, class_2435).isPresent()) continue;
            return false;
        }
        return true;
    }

    private static void qkz(class_1937 class_19372, class_746 class_7462) {
        qhs.clear();
        for (class_1297 class_12972 : class_19372.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(7.0), class_1301.field_52443)) {
            qhs.add(class_12972.method_5829().method_1014((double)class_12972.method_5871()));
        }
    }

    private static class_2338 qla(class_1937 class_19372, class_746 class_7462, class_243 class_2432, class_2338 class_23382) {
        class_3965 class_39652 = class_19372.method_17742(new class_3959(class_2432, class_243.method_24953((class_2382)class_23382), class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        if (class_39652.method_17783() != class_239.class_240.field_1332 || class_39652.method_17777().equals((Object)class_23382)) {
            return null;
        }
        return class_39652.method_17777();
    }

    static class_2338 standing(class_1937 class_19372, class_746 class_7462) {
        class_2338 class_23382 = class_7462.method_24515();
        if (class_7462.method_23318() - (double)class_23382.method_10264() >= 0.49 && !class_19372.method_8320(class_23382).method_26220((class_1922)class_19372, class_23382).method_1110()) {
            return class_23382.method_10084();
        }
        return class_23382;
    }

    public static class_2338 trapped(class_1937 class_19372, class_746 class_7462) {
        class_238 class_2383 = class_7462.method_5829().method_1011(0.001);
        if (class_19372.method_8587((class_1297)class_7462, class_2383)) {
            class_2338 class_23382 = class_2338.method_49637((double)class_7462.method_23317(), (double)class_2383.field_1322, (double)class_7462.method_23321()).method_10084();
            return class_7462.method_20448() && AutoMineController.qlb(class_19372, class_23382) ? class_23382 : null;
        }
        class_2338 class_23383 = class_2338.method_49638((class_2374)class_7462.method_33571());
        if (AutoMineController.qlb(class_19372, class_23383)) {
            return class_23383;
        }
        class_2338 class_23384 = class_2338.method_49637((double)class_7462.method_23317(), (double)class_2383.field_1322, (double)class_7462.method_23321());
        if (AutoMineController.qlb(class_19372, class_23384)) {
            return class_23384;
        }
        for (class_2338 class_23385 : class_2338.method_10097((class_2338)class_2338.method_49637((double)class_2383.field_1323, (double)class_2383.field_1322, (double)class_2383.field_1321), (class_2338)class_2338.method_49637((double)class_2383.field_1320, (double)class_2383.field_1325, (double)class_2383.field_1324))) {
            if (!AutoMineController.qlb(class_19372, class_23385) || !class_19372.method_8320(class_23385).method_26220((class_1922)class_19372, class_23385).method_1107().method_996(class_23385).method_994(class_2383)) continue;
            return class_23385.method_10062();
        }
        return null;
    }

    private static boolean qlb(class_1937 class_19372, class_2338 class_23382) {
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        return !class_26802.method_26215() && class_26802.method_26227().method_15769() && class_26802.method_26214((class_1922)class_19372, class_23382) >= 0.0f && class_26802.method_26234((class_1922)class_19372, class_23382);
    }

    private boolean qlc(class_1937 class_19372, class_2338 class_23382) {
        if (this.qfg == null || !this.qfg.contains(class_23382) || this.qev.contains(class_23382.method_10063())) {
            return false;
        }
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        return !class_26802.method_26215() && class_26802.method_26227().method_15769() && class_26802.method_26214((class_1922)class_19372, class_23382) >= 0.0f;
    }

    private static boolean qld(class_1937 class_19372, class_2338 class_23382) {
        return !class_19372.method_8320(class_23382).method_26220((class_1922)class_19372, class_23382).method_1110();
    }

    private static boolean qle(class_1937 class_19372, class_2338 class_23382) {
        class_265 class_2652 = class_19372.method_8320(class_23382).method_26220((class_1922)class_19372, class_23382);
        return !class_2652.method_1110() && class_2652.method_1105(class_2350.class_2351.field_11052) > 0.25;
    }

    private void qlf(class_2338 class_23382, int n) {
        this.qlj("skip " + class_23382.method_23854() + " " + n);
        this.qew.put(class_23382.method_10063(), (long)(this.qfi + n));
    }

    private void qlg(class_746 class_7462) {
        class_243 class_2432 = class_7462.method_73189();
        this.qgn = this.qfx != null && this.qfr == null && this.qgm != null && class_2432.method_1025(this.qgm) < 4.0E-4 ? ++this.qgn : 0;
        this.qgm = class_2432;
    }

    private void qlh(class_1937 class_19372) {
        Iterator<qcu> iterator = this.qey.iterator();
        while (iterator.hasNext()) {
            qcu qcu2 = iterator.next();
            if (this.qfi - qcu2.tick() > 60) {
                iterator.remove();
                continue;
            }
            class_2338 class_23382 = class_2338.method_10092((long)qcu2.pos());
            if (class_19372.method_8320(class_23382).method_26204() != qcu2.block()) {
                this.qez.remove(qcu2.pos());
                continue;
            }
            int n = this.qez.getOrDefault(qcu2.pos(), -1);
            if (n < 0) {
                this.qez.put(qcu2.pos(), this.qfi);
                int n2 = this.qfa.addTo(qcu2.pos(), 1) + 1;
                if (n2 < 2) continue;
                this.qli(qcu2.pos(), "twice");
                iterator.remove();
                continue;
            }
            if (this.qfi - n <= 25) continue;
            this.qli(qcu2.pos(), "stayed");
            iterator.remove();
        }
    }

    private void qli(long l, String string) {
        this.qev.add(l);
        this.qez.remove(l);
        ++this.qfq;
        this.qfl = true;
        this.qlj("ban " + class_2338.method_10092((long)l).method_23854() + " " + string);
    }

    private void qlj(String string) {
        Consumer<String> consumer = trace;
        if (consumer != null) {
            consumer.accept(this.qfi + " " + string);
        }
    }

    private /* synthetic */ boolean lambda$endTick$4(class_1937 class_19372, long l) {
        return !this.qet.isGhost(l) && class_19372.method_8320(class_2338.method_10092((long)l)).method_26215();
    }

    static {
        qhs = new ArrayList<class_238>();
        qhw = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    }

    private static /* synthetic */ int bsi(int n, int n2) {
        return n - n2 | 0x4DAD0EE;
    }

    private static /* synthetic */ int bsj(int n, int n2) {
        return AutoMineController.bsi(n, n2) + n;
    }

    private static /* synthetic */ int bsk(int n, int n2) {
        return n * n2 | 0x22A1611;
    }
}

