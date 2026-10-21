/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_2815
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_476
 *  net.minecraft.class_490
 *  net.minecraft.class_5321
 *  net.minecraft.class_746
 *  net.minecraft.class_7743
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package a;

import a.ProfilePopup;
import a.ModuleCategory;
import a.lex;
import a.AutoMine;
import a.mpm;
import a.AutoWarden;
import a.InstanceQueue;
import a.TeleportTimer;
import a.AimPersonalizer;
import a.pmc;
import a.StashDriver;
import a.BotModule;
import a.RouteGuide;
import a.pnz;
import a.TalismanTable;
import a.PathHelper;
import a.pqq;
import a.PathFinder;
import a.MouseQuantizer;
import a.RotationUtil;
import a.prz;
import a.Route;
import a.SilentRotation;
import a.CameraOwner;
import a.WalkDriver;
import a.RecorderHooks;
import a.WalkSpeedModel;
import a.WalkModelReader;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.vlg;
import a.ListSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.TextSetting;
import a.Lang;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_2815;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_476;
import net.minecraft.class_490;
import net.minecraft.class_5321;
import net.minecraft.class_746;
import net.minecraft.class_7743;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public class AutoEnd
extends BotModule {
    private static final String mpr = "Home";
    private static final String mps = "Warp";
    private static final List<class_2338> mpt = Collections.emptyList();
    private static final int[] mpu = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
    private static final float mpv = -55.0f;
    private static final int mpw = 2400;
    private static final long mpx = 6000L;
    private static final int mpy = 2;
    private static final int mpz = 200;
    private static final int mqa = 3;
    private static final int mqb = 100;
    private static final float mqc = 86.0f;
    private final NumberSetting mqd = this.add(new NumberSetting("Max vases", 10.0, 1.0, 30.0, 1.0));
    private final ListSetting mqe = this.add(new ListSetting("Loot list", vlg.LOOT, TalismanTable.END_DEFAULTS));
    private final BoolSetting mqf = this.add(new BoolSetting("Use brush", false));
    private final BoolSetting mqg = this.add(new BoolSetting("Take speed", false));
    private final TextSetting mqh = this.add(new TextSetting("Save End", "an507", 32));
    private final TextSetting mqi = this.add(new TextSetting("Loot End", "an508", 120));
    private final ModeSetting mqj = this.add(new ModeSetting("Teleport by", "Home", "Home", "Warp"));
    private final TextSetting mqk = this.add(new TextSetting("Warp name", "end", 32));
    private final BoolSetting mql = this.add(new BoolSetting("Show route", false));
    private final ButtonSetting mqm = this.add(new ButtonSetting("Neuro walking", new vkq("Record and train", Icon.LAYERS, () -> ProfilePopup.openWalk("AutoEnd"))));
    private static AutoEnd mqn;
    private final pnz mqo = new pnz();
    private int mqp = 0;
    private mpm mqq = mpm.RESTOCK_AND_DUMP;
    private int mqr = 0;
    private long mqs = 0L;
    private long mqt = 0L;
    private int mqu = 0;
    private int mqv = 0;
    private int mqw = 0;
    private int mqx = -1;
    private List<class_2338> mqy = null;
    private int mqz = 0;
    private final Set<class_2338> mra = new HashSet<class_2338>();
    private int mrb = 0;
    private int mrc = 0;
    private final List<String> mrd = new ArrayList<String>(List.of("еда", "инвиз", "скорость"));
    private int mre = 3;
    private StashDriver mrf = null;
    private int mrg = 0;
    private boolean mrh = false;
    private boolean mri = false;
    private boolean mrj = false;
    private boolean mrk = false;
    private class_2338 mrl = null;
    private String mrm = "";
    private int mrn = 0;
    private boolean mro = false;
    private class_2338 mrp = null;
    private int mrq = 0;
    private class_2338 mrr = null;
    private int mrs = 0;
    private class_2338 mrt = null;
    private int mru = 0;
    private int mrv = 0;
    private int mrw = 0;
    private int mrx = 1;
    private boolean mry = false;
    private class_2338 mrz = null;
    private int msa = 0;
    private boolean msb = false;
    private int msc = 0;
    private int msd = 0;
    private int mse = 0;
    private int msf = 0;
    private int msg = 0;
    private int msh = 0;
    private int msi = 0;
    private class_243 msj = null;
    private boolean msk = false;
    private final Set<Integer> msl = new HashSet<Integer>();
    private final Set<Integer> msm = new HashSet<Integer>();
    private int msn = 0;
    private double mso = Double.MAX_VALUE;
    private int msp = -1;
    private boolean msq = false;
    private int msr = 0;
    private int mss = 0;
    private boolean mst = false;
    private boolean msu = false;
    private int msv = 0;
    private int msw = 0;
    private int msx = 0;
    private final Queue<Runnable> msy = new LinkedList<Runnable>();
    private int msz = 0;
    private long mta = 0L;
    private int mtb = 0;
    private float mtc = 0.0f;
    private boolean mtd = false;
    private int mte = 0;
    private int mtf = 0;
    private float mtg = 0.0f;
    private int mth = 0;
    private class_243 mti = null;
    private int mtj = 0;
    private int mtk = 0;
    private final AimPersonalizer mtl = new AimPersonalizer().neuro(lex.END);
    private final CameraOwner mtm = CameraOwner.INSTANCE;
    private boolean mtn = false;
    private boolean mto = false;
    private boolean mtp = false;
    private boolean mtq = false;
    private boolean mtr = false;
    private float mts = 0.0f;
    private float mtt = 0.0f;
    private float mtu = 0.0f;
    private float mtv = 0.0f;
    private class_1657 mtw = null;
    private class_243 mtx = null;
    private final Random mty = new Random();
    private float mtz = 0.0f;
    private boolean mua = false;
    private boolean mub = false;
    private boolean muc = false;
    private int mud = 0;
    private int mue = 0;
    private int muf = 0;
    private int mug = 0;
    private int muh = 0;
    private int mui = -1;
    private int muj = 0;
    private int muk = -1;
    private int mul = 0;
    private int mum = 0;
    private boolean mun = false;
    private int muo = 0;
    private int mup = 0;
    private int muq = 0;
    private float mur = 0.0f;
    private boolean mus = false;
    private class_1937 mut = null;
    private int muu = -1;
    private int muv = 0;
    private boolean muw = false;
    private boolean mux = false;
    private class_243 muy = null;
    private double muz = 0.0;
    private double mva = 0.0;
    private double mvb = 0.0;
    private int mvc = 0;
    private double mvd = 0.0;
    private boolean mve = false;
    private int mvf = 0;
    private int mvg = 0;
    private boolean mvh = false;
    private int mvi = 0;
    private int mvj = 0;
    private class_2338 mvk = null;
    private final WalkDriver mvl = new WalkDriver();
    private Route mvm = null;
    private pqq mvn = null;
    private class_2338 mvo = null;
    private boolean mvp = false;
    private boolean mvq = false;
    private boolean mvr = false;
    private final double[] mvs = new double[2];
    private double mvt = Double.NaN;
    private int mvu = 0;
    private int mvv = 0;
    private final Set<Long> mvw = new HashSet<Long>();
    private int mvx = 0;
    private boolean mvy = false;
    private String mvz = null;
    private int mwa = 0;
    private int mwb = 0;
    private final Map<class_1799, Boolean> mwc = new IdentityHashMap<class_1799, Boolean>();
    private int mwd = -1;
    private int mwe = -1;
    private int mwf = 0;
    private float mwg = 10.0f;
    private int mwh = 0;
    private int mwi = 0;
    private class_2338 mwj = null;
    private long mwk = 0L;
    private int mwl = -1;
    private int mwm = -100000;
    private String mwn = "";
    private class_243 mwo = null;
    private int mwp = 0;
    private int mwq = 0;
    private int mwr = -1;
    private int mws = -100000;
    private final int[] mwt = new int[]{-1, -1};
    private final int[] mwu = new int[2];
    private final int[] mwv = new int[2];
    private final int[] mww = new int[2];
    private final int[] mwx = new int[2];
    private final boolean[] mwy = new boolean[2];
    private class_1937 mwz = null;
    private class_1657 mxa = null;
    private class_243 mxb = null;
    private int mxc = -1;
    private volatile boolean mxd = false;
    private int mxe = 0;
    private int mxf = 0;
    private int mxg = 0;
    private int mxh = 0;
    private String mxi = "";
    private boolean mxj = false;
    private boolean mxk = false;
    private volatile int mxl = -100000;
    private volatile String mxm = null;
    private class_1657 mxn = null;
    private int mxo = -100000;
    private static /* synthetic */ long mxp;
    private static /* synthetic */ int mxq;

    public AutoEnd() {
        super("AutoEnd", "Breaks End pots, keeps your loot", ModuleCategory.PLAYER);
        this.mqk.visibleWhen(() -> "Warp".equals(this.mqj.get()));
        if (mqn == null) {
            mqn = this;
        }
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    public static AutoEnd mainInstance() {
        return mqn;
    }

    public static void onMessage(class_2561 class_25612) {
        AutoEnd mpq2 = mqn;
        if (mpq2 != null && mpq2.isEnabled() && class_25612 != null) {
            mpq2.onChatMessage(class_25612.getString());
        }
    }

    public void copySettingsFrom(AutoEnd mpq2) {
        if (mpq2 == null || mpq2 == this) {
            return;
        }
        this.mqd.set(mpq2.mqd.get());
        this.mqe.set(mpq2.mqe.ids());
        this.mqf.set(mpq2.mqf.get());
        this.mqg.set(mpq2.mqg.get());
        this.mqh.set(mpq2.mqh.get());
        this.mqi.set(mpq2.mqi.get());
        this.mqj.set(mpq2.mqj.get());
        this.mqk.set(mpq2.mqk.get());
    }

    public String getStateDescription() {
        if (!this.mwn.isEmpty()) {
            return this.mwn;
        }
        return this.mqq == null ? "" : this.mqq.mpn;
    }

    public Setting[] botSettings() {
        return new Setting[]{this.mqh, this.mqi, this.mqj, this.mqk, this.mqd, this.mqf, this.mqg};
    }

    public void onBotSettingChanged() {
    }

    public ListSetting lootList() {
        AutoEnd mpq2 = mqn;
        return this.driver != null && mpq2 != null && mpq2 != this && !mpq2.isBotInstance() ? mpq2.mqe : this.mqe;
    }

    private boolean mxr(class_1799 class_17992) {
        return TalismanTable.picked(class_17992, this.lootList().ids());
    }

    public String queueNote() {
        return this.mwn;
    }

    private Object mxs() {
        return this.driver != null ? this.driver : InstanceQueue.MAIN;
    }

    public WalkSpeedModel walkBrain() {
        return this.mvl.brain();
    }

    public List<class_2338> getBotPath() {
        return this.mqy;
    }

    public int getBotPathIndex() {
        return this.mqz;
    }

    public class_2338 getBotTarget() {
        if (this.mrr != null) {
            return this.mrr;
        }
        if (this.mrz != null) {
            return this.mrz;
        }
        return this.mrl;
    }

    public int getBrokenVases() {
        return this.mqr;
    }

    public long getFarmMillis() {
        return this.mqs;
    }

    public int getTotalVases() {
        return this.mqu;
    }

    public int getTotalSand() {
        return this.mqv;
    }

    public int getTotalBrushes() {
        return this.mqw;
    }

    public void resetFarmStats() {
        this.mqs = 0L;
        this.mqu = 0;
        this.mqv = 0;
        this.mqw = 0;
    }

    private String mxt() {
        if (!"Warp".equals(this.mqj.get())) {
            return "home home";
        }
        String string = this.mqk.get();
        String string2 = string = string == null ? "" : string.trim();
        while (string.startsWith("/")) {
            string = string.substring(1).trim();
        }
        if (string.toLowerCase().startsWith("warp ")) {
            string = string.substring(5).trim();
        }
        if (string.isEmpty()) {
            string = "end";
        }
        return "warp " + string;
    }

    @Override
    protected void onEnable() {
        if (this.getPlayer() != null) {
            this.mtc = this.getPlayer().method_6032();
        }
        if (this.driver == null) {
            try {
                AutoWarden nxa2 = Flow.getInstance().getModuleManager().get(AutoWarden.class);
                if (nxa2 != null && nxa2.isEnabled()) {
                    nxa2.setEnabled(false);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        this.nbv();
        this.mvw.clear();
        this.mvt = Double.NaN;
        this.mvu = 0;
        this.mqo.reset();
        this.mxg = 0;
        this.mxh = 0;
        this.mxj = false;
        this.mxk = false;
        this.mxl = -100000;
        this.mxn = null;
        this.mxu();
        if (this.mzh()) {
            InstanceQueue.at(this.mxs(), AutoEnd.nak(this.naj()));
            this.myd(mpm.FARMING);
        } else if (this.getPlayer() != null && this.mzn("сброс") != null) {
            InstanceQueue.at(this.mxs(), AutoEnd.nak(this.mqh.get()));
        }
    }

    @Override
    protected void onDisable() {
        this.mxu();
        this.nbw();
        if (this.driver == null) {
            RouteGuide.clear();
        }
        this.mqt = 0L;
        this.mqx = -1;
        InstanceQueue.cancel(this.mxs());
        this.mwn = "";
    }

    private void mxu() {
        this.myd(mpm.RESTOCK_AND_DUMP);
        this.mqr = 0;
        this.mqy = null;
        this.mqz = 0;
        this.mra.clear();
        this.mrh = false;
        this.mri = false;
        this.mrj = false;
        this.mrk = false;
        this.mrl = null;
        this.mrm = "";
        this.mrb = 0;
        this.naa();
        this.mrn = 0;
        this.mro = false;
        this.mrp = null;
        this.mrq = 0;
        this.mrr = null;
        this.mrs = 0;
        this.mrt = null;
        this.mru = 0;
        this.mrv = 0;
        this.mrw = 0;
        this.mrx = 1;
        this.mrz = null;
        this.msa = 0;
        this.msb = false;
        this.mwq = 0;
        this.msc = 0;
        this.msq = false;
        this.msr = 0;
        this.mss = 0;
        this.mst = false;
        this.msu = false;
        this.msv = 0;
        this.msx = 0;
        this.msw = 0;
        this.mwr = -1;
        this.myn();
        this.mxc = -1;
        this.mxe = 0;
        this.mse = 0;
        this.msf = 0;
        this.msg = 0;
        this.msh = 0;
        this.msi = 0;
        this.msj = null;
        this.msk = false;
        this.msl.clear();
        this.msm.clear();
        this.msn = 0;
        this.mso = Double.MAX_VALUE;
        this.msp = -1;
        if (this.mc.field_1761 != null) {
            this.mc.field_1761.method_2925();
        }
        SilentRotation.clear();
        this.mvk = null;
        this.muy = null;
        this.ndw();
        this.mud = 0;
        this.mue = 0;
        this.muf = 0;
        this.mug = 0;
        this.muh = 0;
        this.mui = -1;
        this.neb();
        this.mum = 0;
        this.mur = 0.0f;
        this.mus = false;
        this.mut = null;
        this.muu = -1;
        this.muv = 0;
        this.mvi = 0;
        this.mvj = 1200 + this.mty.nextInt(3000);
        this.mvc = 0;
        this.mvl.reset();
        this.mvm = null;
        this.mvd = 0.0;
        this.mve = false;
        this.mvf = 0;
        this.mvg = 0;
        this.mvy = false;
        this.mvz = null;
        this.mvx = 0;
        this.msy.clear();
        this.mrf = null;
        this.mrg = 0;
        this.mtb = 0;
        this.mtd = false;
        this.mte = 0;
        this.mtf = 0;
        this.mth = 0;
        this.mtj = 0;
        this.mti = null;
        this.mwf = 0;
        this.mwi = 0;
        this.mwj = null;
        this.mwl = -1;
        this.myy();
    }

    private void mxv() {
        this.mxw(true);
    }

    private void mxw(boolean bl) {
        this.mc.field_1690.field_1832.method_23481(bl);
        this.mc.field_1690.field_1904.method_23481(true);
        SilentRotation.miss();
    }

    private void mxx() {
        if (this.mc.field_1690 == null) {
            return;
        }
        this.mc.field_1690.field_1904.method_23481(false);
        this.mc.field_1690.field_1832.method_23481(false);
    }

    private boolean mxy(float f) {
        this.nby(this.mto ? this.mts : this.mtl.intentYaw(), f);
        return Math.abs(this.mtl.intentPitch() - f) <= 0.75f;
    }

    private boolean mxz() {
        boolean bl = this.getPlayer().method_7344().method_7586() < 18;
        int n = this.nei(class_1802.field_8071);
        boolean bl2 = this.nci();
        if (this.mtf == 0) {
            if (!bl || n == -1) {
                if (this.mc.field_1690.field_1904.method_1434() && this.mqq != mpm.BRUSHING_SAND) {
                    this.mxx();
                    if (this.getPlayer().method_6047().method_7909() == class_1802.field_8071) {
                        this.nat();
                    }
                }
                return false;
            }
            this.mtg = this.mtl.intentPitch();
            this.mtf = bl2 ? 2 : 1;
            this.mth = 0;
        }
        if (!(this.mtf == 3 || bl && n != -1)) {
            this.mxx();
            int n2 = this.mtf = bl2 ? 0 : 3;
            if (this.mtf == 0) {
                this.nat();
                return false;
            }
        }
        switch (this.mtf) {
            case 1: {
                this.mxx();
                if (!bl2 && !this.mxy(-55.0f)) break;
                this.mtf = 2;
                this.mth = 0;
                break;
            }
            case 2: {
                if (!bl2) {
                    this.mxy(-55.0f);
                }
                this.getPlayer().method_31548().method_61496(n);
                this.mxw(!bl2);
                ++this.mth;
                if (this.mth <= 200) break;
                this.mxx();
                this.mtf = 3;
                break;
            }
            case 3: {
                this.mxx();
                if (!bl2 && !this.mxy(this.mtg)) break;
                this.mtf = 0;
                this.nat();
                return false;
            }
        }
        return true;
    }

    private void mya() {
        if (this.nci()) {
            this.ncr();
            this.mc.field_1690.field_1867.method_23481(false);
            this.mc.field_1690.field_1903.method_23481(false);
        } else {
            PathHelper.resetKeys();
            this.ncf();
        }
    }

    private void myb() {
        this.mxx();
        this.mtf = 0;
        this.mth = 0;
    }

    private boolean myc(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return false;
        }
        return class_17992.method_7909() == class_1802.field_8071 || class_17992.method_7909() == class_1802.field_8705 || this.nel(class_17992) || this.neo(class_17992);
    }

    private void myd(mpm mpm2) {
        if (this.mqq != mpm2) {
            this.mqq = mpm2;
            this.mwn = "";
        }
    }

    private void mye(String string) {
        if (!this.mvy) {
            this.mvy = true;
            this.mvx = 0;
            ++this.mqp;
        }
        if (string != null && this.mvz == null) {
            this.mvz = string;
        }
    }

    public void onChatMessage(String string) {
        boolean bl;
        String string2 = string.toLowerCase();
        if ((string2.contains("помяним") || string2.contains("помянем") || string2.contains("вы погибли") || string2.contains("вас убил") || string2.contains("смерть на координатах")) && this.isEnabled()) {
            String[] stringArray;
            String string3 = null;
            if (string2.contains("убил ") && (stringArray = string.split("убил ")).length > 1 && (string3 = stringArray[1].split(" ")[0].replaceAll("[^a-zA-Z0-9_]", "")).isEmpty() && stringArray.length > 2) {
                string3 = stringArray[2].split(" ")[0].replaceAll("[^a-zA-Z0-9_]", "");
            }
            this.mxm = string3;
            this.mxl = this.mwa;
        }
        boolean bl2 = bl = string2.contains("уже") && (string2.contains("сервер") || string2.contains("подключ") || string2.contains("находит")) || string2.contains("already connected");
        if (this.mqq == mpm.WARPING_TO_LOOT_BASE && !this.mro && bl) {
            this.mxd = true;
        }
        if (bl && (this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.TELEPORT_TO_SAVE)) {
            this.mqo.dismiss(this.getWorld());
        }
    }

    private void myf() {
        class_746 class_7462 = this.getPlayer();
        if (class_7462 != this.mxn) {
            this.mxo = this.mwa;
        }
        this.mxn = class_7462;
    }

    private void myg() {
        boolean bl;
        int n = this.mxl;
        if (this.mwa - n > 100) {
            return;
        }
        class_746 class_7462 = this.getPlayer();
        boolean bl2 = class_7462.method_29504() || class_7462.method_6032() <= 0.0f;
        boolean bl3 = this.mqq == mpm.TELEPORT_TO_LOOT || this.mqq == mpm.TELEPORT_TO_SAVE || this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.WARPING_TO_LOOT_BASE && (this.mxc < 0 || this.mrn - this.mxc < 100);
        boolean bl4 = bl = !bl3 && this.mxo >= n - 100;
        if (bl2 || bl) {
            this.mxl = -100000;
            this.mye(this.mxm);
        }
    }

    private boolean myh() {
        class_1293 class_12932 = this.getPlayer().method_6112(class_1294.field_5905);
        if (class_12932 != null) {
            return class_12932.method_5584() > 600;
        }
        return false;
    }

    private boolean myi() {
        class_1293 class_12932 = this.getPlayer().method_6112(class_1294.field_5904);
        if (class_12932 != null) {
            return class_12932.method_5584() > 600;
        }
        return false;
    }

    private int myj(boolean bl) {
        class_1293 class_12932 = this.getPlayer().method_6112(bl ? class_1294.field_5905 : class_1294.field_5904);
        return class_12932 == null ? 0 : (class_12932.method_48559() ? Integer.MAX_VALUE : class_12932.method_5584());
    }

    private boolean myk(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.mwy[n] || this.mwu[n] > 0 || this.nab(bl) == 0) {
            return false;
        }
        int n3 = this.mww[n] > 0 ? Math.min(600, this.mww[n] * 3 / 4) : 600;
        return this.myj(bl) <= n3;
    }

    private void myl() {
        for (int i = 0; i < 2; ++i) {
            boolean bl = i == 0;
            int n = this.nab(bl);
            int n2 = this.myj(bl);
            if (this.mwt[i] >= 0 && n < this.mwt[i] && this.mwr == i && this.mwa - this.mws <= 3) {
                this.mwu[i] = 60;
                this.mwv[i] = n2;
                this.mwx[i] = 0;
            }
            this.mwt[i] = n;
            if (this.mwu[i] <= 0) continue;
            if (n2 > this.mwv[i]) {
                this.mwu[i] = 0;
                this.mww[i] = n2;
                if (i != 0) continue;
                this.mxh = 0;
                continue;
            }
            int n3 = i;
            this.mwu[n3] = this.mwu[n3] - 1;
            if (this.mwu[n3] != 0) continue;
            this.mym(i);
        }
    }

    private void mym(int n) {
        if (this.mwy[n]) {
            return;
        }
        this.mwy[n] = true;
        if (n == 0) {
            ++this.mxh;
            this.mxi = Lang.s("the invisibility potion gives no effect", "зелье невидимости не действует");
        }
        this.notifyUser(n == 0 ? Lang.s("The invisibility potion gave no effect - no more of them this trip", "Зелье невидимости не дало эффекта - больше не пью в этом заходе") : Lang.s("The speed potion gave no effect - no more of them this trip", "Зелье скорости не дало эффекта - больше не пью в этом заходе"), false);
    }

    private void myn() {
        for (int i = 0; i < 2; ++i) {
            this.mwu[i] = 0;
            this.mwy[i] = false;
            this.mwx[i] = 0;
        }
    }

    private void myo(String string) {
        ++this.mxg;
        this.mxi = string;
    }

    private boolean myp() {
        int n = Math.max(this.mxg, this.mxh);
        if (n < 3) {
            return false;
        }
        if (!this.mxj) {
            this.notifyUser(Lang.s("Stopped: " + n + " trips in a row came back with nothing (" + this.mxi + "). Check the potions, the warp / home and the anarchies, then turn it on again", "Остановлен: " + n + " захода подряд впустую (" + this.mxi + "). Проверь зелья, варп / хом и анархии и включи снова"), false);
            this.mxj = true;
        }
        return true;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        boolean bl;
        block14: {
            ++this.mwa;
            if (this.isNotInWorld()) {
                if (this.mtn) {
                    this.mtn = false;
                    if (this.driver == null) {
                        this.mtm.reset();
                    }
                }
                this.mtw = null;
                this.mtx = null;
                this.mua = false;
                this.mub = false;
                this.muc = false;
                SilentRotation.clear();
                this.mqt = 0L;
                this.mqx = -1;
                return;
            }
            if (this.mxj) {
                this.mxj = false;
                PathHelper.resetKeys();
                if (this.driver != null) {
                    this.setBotRunning(false);
                    this.driver.halted();
                } else {
                    this.setEnabled(false);
                }
                return;
            }
            this.myv();
            this.myw();
            InstanceQueue.keep(this.mxs());
            this.nbx();
            this.mtz = this.getPlayer().method_36454();
            this.mua = true;
            this.mvl.beginTick();
            bl = this.myq();
            if (bl && this.mc.field_1690 != null) {
                this.mvp = this.mc.field_1690.field_1867.method_1434();
                this.mvq = this.mc.field_1690.field_1832.method_1434();
            }
            try {
                this.myz();
                if (bl) {
                    this.myu();
                }
                this.nck();
                if (this.mud <= 0 || this.mc.field_1690 == null) break block14;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.myu();
                }
                this.nck();
                if (this.mud > 0 && this.mc.field_1690 != null) {
                    this.mc.field_1690.field_1886.method_23481(false);
                    this.mc.field_1690.field_1904.method_23481(false);
                }
                this.myx();
                this.mub = this.mc.field_1690 != null && this.mc.field_1690.field_1886.method_1434();
                boolean bl2 = this.muc = this.mc.field_1690 != null && this.mc.field_1690.field_1904.method_1434();
                if (this.driver == null) {
                    RouteGuide.publish(this.mvl.shown(), this.mvl.shownAt(), bl, bl && this.myr(), this.mql.get(), this.getName());
                }
                throw throwable;
            }
            this.mc.field_1690.field_1886.method_23481(false);
            this.mc.field_1690.field_1904.method_23481(false);
        }
        this.myx();
        this.mub = this.mc.field_1690 != null && this.mc.field_1690.field_1886.method_1434();
        boolean bl3 = this.muc = this.mc.field_1690 != null && this.mc.field_1690.field_1904.method_1434();
        if (this.driver == null) {
            RouteGuide.publish(this.mvl.shown(), this.mvl.shownAt(), bl, bl && this.myr(), this.mql.get(), this.getName());
        }
    }

    private boolean myq() {
        return this.driver == null && mqn == this && this.isEnabled() && RecorderHooks.walkGuide();
    }

    private boolean myr() {
        return this.mvr || this.getPlayer().method_6115() || this.ncm() || this.mrf != null || this.muw || this.mc.field_1755 != null;
    }

    private int mys(int n) {
        return this.myq() ? n * 3 : n;
    }

    private WalkModelReader myt() {
        return AutoMine.walkModel(lex.END);
    }

    private void myu() {
        class_304[] class_304Array;
        class_315 class_3152 = this.mc.field_1690;
        if (class_3152 == null || this.ncm() || this.mrf != null || this.muw) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903}) {
            class_3042.method_23481(this.heldByHuman(class_3042));
        }
        if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            if (class_3152.field_1867.method_1434() != this.mvp) {
                class_3152.field_1867.method_23481(true);
            }
        } else {
            class_3152.field_1867.method_23481(this.heldByHuman(class_3152.field_1867));
        }
        if (((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
            if (class_3152.field_1832.method_1434() != this.mvq) {
                class_3152.field_1832.method_23481(true);
            }
        } else {
            class_3152.field_1832.method_23481(this.heldByHuman(class_3152.field_1832));
        }
    }

    private void myv() {
        long l;
        long l2 = System.currentTimeMillis();
        if (this.mqt != 0L && (l = l2 - this.mqt) > 0L && l < 5000L) {
            this.mqs += l;
        }
        this.mqt = l2;
    }

    private void myw() {
        boolean bl;
        int n;
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n2 = 0;
        for (n = 0; n < class_16612.method_5439(); ++n) {
            class_1799 class_17992 = class_16612.method_5438(n);
            if (!AutoEnd.ndf(class_17992)) continue;
            n2 += class_17992.method_7947();
        }
        n = this.mqq == mpm.FARMING || this.mqq == mpm.LOOTING_VASE || this.mqq == mpm.FARMING_SAND || this.mqq == mpm.BRUSHING_SAND || this.mqq == mpm.LOOTING_SAND || this.mqq == mpm.CHECK_PVP_COOLDOWN || this.mqq == mpm.ESCAPING || this.mqq == mpm.RUN_TO_FARM_COORDS ? 1 : 0;
        boolean bl2 = bl = this.getPlayer().field_7512 != this.getPlayer().field_7498;
        if (this.mqx >= 0 && n2 > this.mqx && n != 0 && !bl) {
            this.mqw += n2 - this.mqx;
        }
        this.mqx = n2;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (this.mc.field_1690 == null) {
            return;
        }
        this.mc.field_1690.field_1886.method_23481(this.mub);
        this.mc.field_1690.field_1904.method_23481(this.muc);
        while (this.mc.field_1690.field_1886.method_1436()) {
        }
        while (this.mc.field_1690.field_1904.method_1436()) {
        }
        if (this.mud > 0) {
            this.silenceMovement();
        }
        if (this.mc.field_1724 != null && this.mc.field_1687 != null) {
            if (this.driver == null && !this.mux && this.mua && this.mtn && this.mud == 0) {
                this.mtm.remapHumanKeys(this.mc, this.mtm.cameraYaw(this.mc.field_1724), this.mtu);
            }
            SilentRotation.applyOwn(this.mc);
        }
    }

    private void myx() {
        class_304[] class_304Array;
        if (this.mc.field_1690 == null || this.mud > 0) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{this.mc.field_1690.field_1894, this.mc.field_1690.field_1881, this.mc.field_1690.field_1913, this.mc.field_1690.field_1849, this.mc.field_1690.field_1903, this.mc.field_1690.field_1832, this.mc.field_1690.field_1867}) {
            if (!this.heldByHuman(class_3042)) continue;
            class_3042.method_23481(true);
        }
    }

    private void myy() {
        class_304[] class_304Array;
        if (this.mc.field_1690 == null) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{this.mc.field_1690.field_1894, this.mc.field_1690.field_1881, this.mc.field_1690.field_1913, this.mc.field_1690.field_1849, this.mc.field_1690.field_1903, this.mc.field_1690.field_1867, this.mc.field_1690.field_1832, this.mc.field_1690.field_1886, this.mc.field_1690.field_1904}) {
            if (this.heldByHuman(class_3042)) continue;
            class_3042.method_23481(false);
        }
    }

    private void myz() {
        boolean bl;
        this.muy = null;
        this.mux = false;
        this.mry = false;
        if (this.mse > 0) {
            --this.mse;
        }
        if (this.mum > 0) {
            --this.mum;
        }
        this.mur *= 0.99f;
        if (this.msf > 0) {
            --this.msf;
        }
        if (this.msg > 0) {
            --this.msg;
        }
        if (this.msh > 0) {
            --this.msh;
        }
        this.ndn();
        this.myf();
        this.myg();
        this.myl();
        if (this.mvy) {
            ++this.mvx;
            if (this.mvx >= 40) {
                this.mvy = false;
                this.mxu();
                this.myd(mpm.TELEPORT_TO_SAVE);
            }
            return;
        }
        if (this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqo.check((class_1657)this.getPlayer(), System.currentTimeMillis(), 6000L)) {
            InstanceQueue.leave(this.mxs());
            this.mxu();
            this.myd(mpm.TELEPORT_TO_SAVE);
            this.notifyUser("В лобби (компас в слотах) — иду на сейв " + AutoEnd.nak(this.mqh.get()), false);
            return;
        }
        if (this.mza()) {
            return;
        }
        boolean bl2 = bl = this.mqq != mpm.WARPING_TO_LOOT_BASE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqq != mpm.RESTOCK_AND_DUMP;
        if (this.mwo != null && this.getPlayer().method_73189().method_1025(this.mwo) < 1.0E-4 && bl && this.mvi <= 0 && this.mud == 0 && !this.myq() && (this.mc.field_1690.field_1894.method_1434() || this.mqy != null)) {
            ++this.mwp;
            if (this.mwp > 6 && this.getPlayer().method_24828() && PathHelper.isJumpUseful(this.ncj())) {
                this.mc.field_1690.field_1903.method_23481(true);
            }
            if (this.mwp > 16) {
                this.mqy = null;
                this.mqz = 0;
                this.mse = 0;
                this.mwp = 0;
                ++this.mwq;
                if (this.mwq >= 3) {
                    this.mwq = 0;
                    if (this.mrr != null) {
                        this.nay(true);
                    } else if (this.mrz != null) {
                        this.ncz(true);
                    }
                }
            }
        } else {
            if (this.mwp > 0) {
                this.mwq = 0;
            }
            this.mwp = 0;
            this.mwo = this.getPlayer().method_73189();
        }
        int n = this.mwf = PathHelper.onClimbable((class_1657)this.getPlayer()) ? this.mwf + 1 : 0;
        if (this.mc.field_1755 instanceof class_7743) {
            this.mc.field_1755.method_25419();
            return;
        }
        if (this.mqq != mpm.RESTOCK_AND_DUMP && this.mc.field_1755 instanceof class_465 && !(this.mc.field_1755 instanceof class_490)) {
            this.mxx();
            this.mc.field_1724.method_7346();
            return;
        }
        this.mc.field_1690.field_1832.method_23481(this.mc.field_1690.field_1904.method_1434() && this.myc(this.getPlayer().method_6047()) && !this.nci());
        if (this.getPlayer().method_6032() <= 0.0f || this.getPlayer().method_29504()) {
            if (this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && !this.mvy) {
                this.mye(null);
            }
            return;
        }
        if (this.mte > 0) {
            --this.mte;
        }
        if (this.getPlayer().field_6017 > 3.0) {
            this.mtd = true;
        } else if (this.mtd) {
            this.mtd = false;
            this.mte = 6;
        }
        float f = this.getPlayer().method_6032();
        if (f < this.mtc && this.mte <= 0 && this.mqq != mpm.ESCAPING && this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqq != mpm.RESTOCK_AND_DUMP && this.mqq != mpm.WARPING_TO_LOOT_BASE && this.mzh()) {
            this.myd(mpm.ESCAPING);
            this.mru = 0;
            this.mrv = 0;
            this.mrw = 0;
            this.mqy = null;
            this.mqz = 0;
        }
        this.mtc = f;
        if (this.ndj()) {
            this.mwb = this.mwa;
        }
        if (!this.mst && !this.mc.field_1690.field_1904.method_1434()) {
            class_1799 class_17992;
            this.nee();
            this.ndo();
            if (!(this.muk != -1 || this.ncm() || this.muw || this.mqq == mpm.BRUSHING_SAND || this.mqq == mpm.ESCAPING || (class_17992 = this.getPlayer().method_6047()).method_7960() || class_17992.method_7909().method_7876().contains("sword") || class_17992.method_7909().method_7876().contains("mace") || class_17992.method_7909() == class_1802.field_8071 || this.nel(class_17992) || this.neo(class_17992))) {
                this.nat();
            }
        } else {
            this.neb();
        }
        if (this.mud > 0) {
            this.ndp();
            if (this.mud > 0) {
                PathHelper.resetKeys();
                return;
            }
        }
        if (this.mtb > 0) {
            --this.mtb;
            return;
        }
        if (this.mrf != null) {
            PathHelper.resetKeys();
            this.mzx();
            return;
        }
        if (!this.msy.isEmpty()) {
            PathHelper.resetKeys();
            if (++this.muj > 400) {
                this.msy.clear();
                this.msz = 0;
                this.muj = 0;
                this.mzy();
                if (this.mc.field_1724 != null && this.mc.field_1755 != null) {
                    this.mc.field_1724.method_7346();
                }
                return;
            }
            ++this.msz;
            boolean bl3 = this.mc.field_1755 instanceof class_476;
            if (this.msz >= (bl3 ? 4 : 2)) {
                this.msy.poll().run();
                this.msz = 0;
                this.mtb = bl3 ? 2 + this.mty.nextInt(5) : 1 + this.mty.nextInt(3);
            }
            return;
        }
        this.muj = 0;
        if (this.mud == 0) {
            this.ndw();
        }
        if (!this.mst && this.mqq != mpm.ESCAPING && this.mzh()) {
            boolean bl4;
            boolean bl5 = this.myk(true);
            boolean bl6 = bl4 = this.mqg.get() && this.myk(false);
            if (bl5 || bl4) {
                int n2;
                int n3 = -1;
                if (bl5 && (n3 = this.nej()) == -1) {
                    n2 = this.nek();
                    if (n2 != -1 && this.msy.isEmpty()) {
                        this.nau(n2);
                    }
                    if (n2 != -1) {
                        return;
                    }
                    bl5 = false;
                }
                if (!bl5 && bl4 && (n3 = this.nem()) == -1) {
                    n2 = this.nen();
                    if (n2 != -1 && this.msy.isEmpty()) {
                        this.nau(n2);
                    }
                    if (n2 != -1) {
                        return;
                    }
                    bl4 = false;
                }
                if (n3 != -1) {
                    PathHelper.resetKeys();
                    if (this.getPlayer().method_31548().method_67532() != n3) {
                        this.getPlayer().method_31548().method_61496(n3);
                        this.mxx();
                        this.msw = 0;
                        return;
                    }
                    n2 = bl5 ? 0 : 1;
                    ++this.msw;
                    if (!(this.getPlayer().method_31548().method_5438(n3).method_31574(class_1802.field_8574) || this.mxy(86.0f) && !(this.mtv < 78.0f))) {
                        this.mxx();
                        if (this.msw > 100) {
                            this.msw = 0;
                            int n4 = n2;
                            this.mwx[n4] = this.mwx[n4] + 1;
                            if (this.mwx[n4] >= 3) {
                                this.mym(n2);
                            }
                        }
                        return;
                    }
                    this.mwr = n2;
                    this.mws = this.mwa;
                    this.mxv();
                    if (!this.getPlayer().method_6115() && this.msw % 5 == 0) {
                        SilentRotation.later(() -> {
                            if (this.mc.field_1724 != null && this.mc.field_1761 != null && !this.mc.field_1724.method_6115()) {
                                this.mc.field_1761.method_2919((class_1657)this.mc.field_1724, class_1268.field_5808);
                            }
                        });
                    }
                    if (this.msw > 100) {
                        this.mxx();
                        this.mzm();
                        this.msw = 0;
                        int n5 = n2;
                        this.mwx[n5] = this.mwx[n5] + 1;
                        if (this.mwx[n5] >= 3) {
                            this.mym(n2);
                        }
                    }
                    return;
                }
            }
            if (this.msw > 0) {
                this.mxx();
                this.mzm();
                this.msw = 0;
                this.mwr = -1;
                if (this.muk == -1) {
                    this.nat();
                }
            }
        }
        if (!this.mst && this.mqq != mpm.ESCAPING) {
            if (this.mxz()) {
                this.mya();
                return;
            }
        } else if (this.mtf != 0) {
            this.myb();
        }
        if (this.mqf.get() && this.nde() && (this.mqq == mpm.FARMING || this.mqq == mpm.LOOTING_VASE)) {
            this.mc.field_1690.field_1886.method_23481(false);
            this.mc.field_1690.field_1904.method_23481(false);
            if (this.mc.field_1761 != null) {
                this.mc.field_1761.method_2925();
            }
            this.mrr = null;
            this.msu = false;
            this.msi = 0;
            this.msx = 0;
            this.mqy = null;
            this.mqz = 0;
            this.myd(mpm.FARMING_SAND);
        }
        if (!(this.mqq != mpm.FARMING && this.mqq != mpm.FARMING_SAND && this.mqq != mpm.LOOTING_VASE && this.mqq != mpm.LOOTING_SAND && this.mqq != mpm.BRUSHING_SAND && this.mqq != mpm.RUN_TO_FARM_COORDS || this.mzh())) {
            if (this.mwa % 60 == 0) {
                this.myd(mpm.TELEPORT_TO_SAVE);
            }
            return;
        }
        if (bl && this.mqq != mpm.ENTER_PORTAL && !this.myq() && this.mze()) {
            return;
        }
        switch (this.mqq.ordinal()) {
            case 0: {
                this.mzl();
                break;
            }
            case 1: {
                this.nam();
                break;
            }
            case 2: {
                this.nao();
                break;
            }
            case 3: {
                this.naq();
                break;
            }
            case 4: {
                this.nar();
                break;
            }
            case 5: {
                this.nax();
                break;
            }
            case 6: {
                this.nbq();
                break;
            }
            case 7: {
                this.ncy();
                break;
            }
            case 8: {
                this.ndc();
                break;
            }
            case 9: {
                this.ndd();
                break;
            }
            case 10: {
                this.ndh();
                break;
            }
            case 11: {
                this.ndk();
                break;
            }
            case 12: {
                this.ndl();
                break;
            }
            case 13: {
                this.mzi();
            }
        }
        if (!this.myq()) {
            this.mzb(bl);
        }
    }

    private boolean mza() {
        if (this.mtk > 0) {
            --this.mtk;
        }
        class_243 class_2432 = this.getPlayer().method_73189();
        if (this.mti == null || class_2432.method_1025(this.mti) > 2.25) {
            this.mti = class_2432;
            this.mtj = 0;
            return false;
        }
        ++this.mtj;
        if (this.mqq == mpm.RESTOCK_AND_DUMP && this.mxk) {
            this.mtj = 0;
            return false;
        }
        if (this.mtj < 2400 || this.mtk > 0) {
            return false;
        }
        PathHelper.resetKeys();
        this.mxx();
        if (this.mc.field_1724 != null && this.mc.field_1755 != null) {
            this.mc.field_1724.method_7346();
        }
        if (this.mqq == mpm.WARPING_TO_LOOT_BASE || this.mqq == mpm.ENTER_PORTAL || this.mqq == mpm.RUN_TO_FARM_COORDS || this.mqq == mpm.RESTOCK_AND_DUMP || this.mqq == mpm.WARPING_TO_SAVE_BASE) {
            this.myo(Lang.s("stood still for 2 minutes", "стоял на месте 2 минуты"));
            if (this.myp()) {
                return true;
            }
        }
        this.mxu();
        this.mti = class_2432;
        this.mtk = 600;
        this.myd(mpm.TELEPORT_TO_SAVE);
        return true;
    }

    private void mzb(boolean bl) {
        boolean bl2 = this.mc.field_1690.field_1894.method_1434();
        if (!(bl && bl2 && PathHelper.isBlockedHorizontally())) {
            this.mrw = 0;
            if (!this.mry) {
                this.mc.field_1690.field_1913.method_23481(false);
                this.mc.field_1690.field_1849.method_23481(false);
            }
            return;
        }
        ++this.mrw;
        if (this.mrw < 8) {
            return;
        }
        this.mux = true;
        if (this.mrw % 20 == 0) {
            this.mrx = -this.mrx;
        }
        if (this.mrx > 0) {
            this.mc.field_1690.field_1849.method_23481(true);
            this.mc.field_1690.field_1913.method_23481(false);
        } else {
            this.mc.field_1690.field_1913.method_23481(true);
            this.mc.field_1690.field_1849.method_23481(false);
        }
        if (this.mrw > 30) {
            this.mrw = 0;
            this.mqy = null;
            this.mqz = 0;
            this.mse = 0;
            this.mrv = (this.mrv + 1) % mpu.length;
        }
    }

    private void mzc(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = Float.MAX_VALUE;
        for (float f5 = -1.0f; f5 <= 1.0f; f5 += 1.0f) {
            for (float f6 = -1.0f; f6 <= 1.0f; f6 += 1.0f) {
                double d;
                float f7;
                if (f5 == 0.0f && f6 == 0.0f || !((f7 = Math.abs(class_3532.method_15393((float)((float)(d = Math.toDegrees(CameraOwner.inputDirection(this.mtu, f5, f6))) - f)))) < f4)) continue;
                f4 = f7;
                f2 = f5;
                f3 = f6;
            }
        }
        this.mux = true;
        this.mry = true;
        this.mc.field_1690.field_1894.method_23481(f2 > 0.0f);
        this.mc.field_1690.field_1881.method_23481(f2 < 0.0f);
        this.mc.field_1690.field_1913.method_23481(f3 > 0.0f);
        this.mc.field_1690.field_1849.method_23481(f3 < 0.0f);
    }

    private static float mzd(double d, double d2) {
        return (float)Math.toDegrees(Math.atan2(-d, d2));
    }

    private boolean mze() {
        if (this.mwf < 6) {
            return false;
        }
        class_746 class_7462 = this.getPlayer();
        if (this.nci() && PathHelper.getStandY(this.mqy.get(this.mqz)) > class_7462.method_23318() + 0.6) {
            return false;
        }
        this.mqy = null;
        this.mqz = 0;
        this.mse = 0;
        this.ncf();
        class_243 class_2432 = PathHelper.awayFromClimbable((class_1657)class_7462);
        PathHelper.resetKeys();
        this.mzc(class_2432 != null ? AutoEnd.mzd(class_2432.field_1352, class_2432.field_1350) : this.ncj() + 180.0f);
        this.mc.field_1690.field_1867.method_23481(false);
        if (this.mwf > 200) {
            this.mwf = 0;
            if (this.mrr != null) {
                this.nay(true);
            } else if (this.mrz != null) {
                this.ncz(true);
            }
        }
        return true;
    }

    private void mzf() {
        if (PathHelper.onClimbable((class_1657)this.getPlayer()) && this.mc.field_1690 != null) {
            this.mc.field_1690.field_1832.method_23481(true);
        }
    }

    private void mzg() {
        if (Math.abs(this.mtl.intentPitch() - this.mwg) > 6.0f) {
            this.nbz(this.mtl.intentYaw(), this.mwg, true);
        } else {
            this.ncf();
        }
    }

    private boolean mzh() {
        if (this.mc.field_1687 == null || this.getPlayer() == null) {
            return false;
        }
        String string = this.mc.field_1687.method_27983().method_29177().toString().toLowerCase();
        Optional optional = this.mc.field_1687.method_23753(this.getPlayer().method_24515()).method_40230();
        String string2 = optional.isPresent() ? ((class_5321)optional.get()).method_29177().toString().toLowerCase() : "";
        return string.contains("end") || string2.contains("end");
    }

    private void mzi() {
        boolean bl;
        class_1657 class_16572;
        double d;
        ++this.mru;
        this.mc.field_1690.field_1886.method_23481(false);
        this.mxx();
        if (this.mc.field_1761 != null) {
            this.mc.field_1761.method_2925();
        }
        double d2 = d = (class_16572 = this.neh()) != null ? class_16572.method_5858((class_1297)this.getPlayer()) : Double.MAX_VALUE;
        if (this.mru > 20 && d > 1600.0) {
            PathHelper.resetKeys();
            this.myd(mpm.FARMING);
            return;
        }
        boolean bl2 = bl = this.mqy == null || this.mqz >= this.mqy.size() || this.mru % 25 == 0;
        if (class_16572 != null && bl && this.mse <= 0) {
            this.mse = 10;
            this.mzk(class_16572);
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else if (class_16572 != null) {
            class_243 class_2432 = this.mzj(this.getPlayer().method_73189().method_1020(class_16572.method_73189()).method_1029(), Math.toRadians(mpu[this.mrv]));
            class_243 class_2433 = this.getPlayer().method_73189().method_1019(class_2432.method_1021(12.0));
            this.ncp(new class_243(class_2433.field_1352, this.getPlayer().method_23318(), class_2433.field_1350));
        } else {
            this.ncf();
            this.mux = true;
            this.mc.field_1690.field_1894.method_23481(true);
            WalkDriver.setSprint(this.mc.field_1690, true);
        }
        if (this.mru > 200) {
            PathHelper.resetKeys();
            this.myd(mpm.FARMING);
        }
    }

    private class_243 mzj(class_243 class_2432, double d) {
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        return new class_243(class_2432.field_1352 * d2 - class_2432.field_1350 * d3, 0.0, class_2432.field_1352 * d3 + class_2432.field_1350 * d2).method_1029();
    }

    private void mzk(class_1657 class_16572) {
        class_243 class_2432 = this.getPlayer().method_73189().method_1020(class_16572.method_73189()).method_1029();
        class_2338 class_23382 = this.getPlayer().method_24515();
        for (int i = 0; i < 3; ++i) {
            int n = (this.mrv + i) % mpu.length;
            double d = (double)mpu[n] + this.mty.nextGaussian() * 12.0;
            class_243 class_2433 = this.mzj(class_2432, Math.toRadians(d));
            double d2 = 26.0 + this.mty.nextDouble() * 12.0;
            class_2338 class_23383 = this.nbd(class_23382.method_10069((int)(class_2433.field_1352 * d2), 0, (int)(class_2433.field_1350 * d2)));
            List<class_2338> list = this.nbb(class_23382, class_23383);
            if (list == null || list.size() < 5) continue;
            this.nbc(list);
            this.mrv = n;
            return;
        }
        this.mrv = (this.mrv + 3) % mpu.length;
        this.mqy = null;
        this.mqz = 0;
    }

    private void mzl() {
        this.mst = false;
        if (!this.mrj && this.nab(true) == 1) {
            this.mrj = true;
        }
        if (this.mqg.get()) {
            if (!this.mrk && this.nab(false) == 1) {
                this.mrk = true;
            }
        } else if (!this.mrk) {
            this.mrk = true;
        }
        this.mzm();
        if (this.mrh && this.mri && this.mrj && this.mrk) {
            if (!(this.nab(true) != 0 || this.myh() && this.mzn("инвиз") == null)) {
                if (!this.mxk) {
                    this.mxk = true;
                    this.notifyUser("Нет невидимости на базе - ждём", false);
                }
                this.mrj = false;
                this.msh = 600;
                return;
            }
            this.mxk = false;
            if (this.myp()) {
                PathHelper.resetKeys();
                this.mzg();
                return;
            }
            this.myd(mpm.TELEPORT_TO_LOOT);
            return;
        }
        if (this.mrl != null && !(this.mc.field_1755 instanceof class_476) && this.mwa - this.mwh > 400) {
            this.mrl = null;
            this.mqy = null;
            this.mc.field_1690.field_1904.method_23481(false);
            this.msh = 40;
            if (++this.mwi >= 3) {
                this.mwi = 0;
                this.mzq(this.mrm);
            }
        }
        if (this.mrl == null) {
            String string;
            String string2 = string = !this.mrh ? "сброс" : this.mzz();
            if (this.msh > 0) {
                PathHelper.resetKeys();
                this.mzg();
                return;
            }
            class_2338 class_23382 = this.mzn(string);
            if (class_23382 != null) {
                this.mrl = class_23382;
                this.mrm = string;
                this.mwh = this.mwa;
                this.mvg = 0;
                this.nch();
                this.naz(this.mrl, true);
            } else {
                this.msh = 10;
                if (!string.equals("сброс") && this.mzn("сброс") != null) {
                    this.mzq(string);
                }
                PathHelper.resetKeys();
                this.mzg();
            }
        } else if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            class_476 class_4762;
            PathHelper.resetKeys();
            class_243 class_2432 = this.nbo(this.mrl);
            this.ncb(this.mrl, class_2432 != null ? class_2432 : class_243.method_24953((class_2382)this.mrl));
            class_437 class_4372 = this.mc.field_1755;
            if (class_4372 instanceof class_476 && !this.mzp(class_4762 = (class_476)class_4372)) {
                this.mc.field_1724.method_7346();
                return;
            }
            if (!(this.mc.field_1755 instanceof class_476)) {
                class_4762 = this.nco(this.mrl);
                boolean bl = false;
                if (class_4762 != null && this.mvc > 0) {
                    --this.mvc;
                } else if (class_4762 != null) {
                    bl = System.currentTimeMillis() - this.mta > 500L;
                } else {
                    class_3965 class_39652;
                    ++this.mvg;
                    if (this.mvg > 40 && this.getPlayer().method_24515().method_10262((class_2382)this.mrl) < 16.0 && System.currentTimeMillis() - this.mta > 500L && (class_39652 = this.mzr(this.mrl)) != null) {
                        SilentRotation.later(() -> {
                            if (this.mc.field_1761 != null && this.mc.field_1724 != null && this.mc.field_1755 == null) {
                                this.mc.field_1761.method_2896(this.mc.field_1724, class_1268.field_5808, class_39652);
                                this.mc.field_1724.method_6104(class_1268.field_5808);
                            }
                        });
                        this.mta = System.currentTimeMillis();
                        this.mzo(this.mrl);
                    }
                }
                if (bl) {
                    this.mta = System.currentTimeMillis();
                    this.mzo(this.mrl);
                }
                this.mc.field_1690.field_1904.method_23481(bl);
            } else {
                this.mc.field_1690.field_1904.method_23481(false);
                class_4762 = (class_476)this.mc.field_1755;
                if (this.mrm.equals("сброс")) {
                    this.mzt(class_4762);
                    this.msy.add(() -> {
                        this.mrh = true;
                        this.mc.field_1724.method_7346();
                        this.mrl = null;
                    });
                } else if (this.mrm.equals("еда")) {
                    if (this.msy.isEmpty()) {
                        int n = 0;
                        for (int i = 0; i < this.getPlayer().method_31548().method_5439(); ++i) {
                            if (this.getPlayer().method_31548().method_5438(i).method_7909() != class_1802.field_8071) continue;
                            n += this.getPlayer().method_31548().method_5438(i).method_7947();
                        }
                        if (n > this.mre && this.mrc < 4) {
                            ++this.mrc;
                            if (!this.nae(class_4762, class_17992 -> class_17992.method_7909() == class_1802.field_8071)) {
                                this.mrc = 4;
                            }
                        } else if (n >= this.mre || this.mrc >= 4) {
                            this.mrc = 0;
                            this.msy.add(() -> {
                                this.mri = true;
                                this.mc.field_1724.method_7346();
                                this.mrl = null;
                            });
                        } else {
                            ++this.mrc;
                            if (!this.mzw(class_4762, this.mre - n)) {
                                this.mrc = 0;
                                this.msy.add(() -> {
                                    this.mri = true;
                                    this.mc.field_1724.method_7346();
                                    this.mrl = null;
                                });
                            }
                        }
                    }
                } else if ((this.mrm.equals("инвиз") || this.mrm.equals("скорость")) && this.msy.isEmpty()) {
                    this.naf(class_4762, this.mrm.equals("инвиз"));
                }
            }
        }
    }

    private void mzm() {
        int n;
        if (this.mc.field_1755 != null || this.msu || this.mus) {
            return;
        }
        for (n = 0; n < 9; ++n) {
            if (this.getPlayer().method_31548().method_5438(n).method_7909() != class_1802.field_8469) continue;
            if (this.muk == -1 && this.mum <= 0 && this.ndx()) {
                this.ndz(n);
            }
            return;
        }
        if (!this.msy.isEmpty() || this.mud > 0) {
            return;
        }
        for (n = 9; n < 36; ++n) {
            if (this.getPlayer().method_31548().method_5438(n).method_7909() != class_1802.field_8469) continue;
            int n2 = n;
            this.msy.add(() -> this.ndv(n2, 1, class_1713.field_7795));
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private class_2338 mzn(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void mzo(class_2338 class_23382) {
        this.mwj = class_23382;
        this.mwk = System.currentTimeMillis();
    }

    private boolean mzp(class_476 class_4762) {
        int n;
        int n2 = ((class_1707)class_4762.method_17577()).field_7763;
        if (n2 == this.mwl) {
            return true;
        }
        if (this.mwj == null || !this.mwj.equals((Object)this.mrl) || System.currentTimeMillis() - this.mwk > 3000L) {
            return false;
        }
        class_2680 class_26802 = this.getWorld().method_8320(this.mwj);
        if (!(class_26802.method_26204() instanceof class_2281)) {
            return false;
        }
        int n3 = n = class_26802.method_11654((class_2769)class_2281.field_10770) == class_2745.field_12569 ? 27 : 54;
        if (((class_1707)class_4762.method_17577()).method_17388() * 9 != n) {
            return false;
        }
        this.mwl = n2;
        return true;
    }

    /*
     * Exception decompiling
     */
    private void mzq(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private class_3965 mzr(class_2338 class_23382) {
        class_243 class_2432 = this.getPlayer().method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        class_3965 class_39652 = this.getWorld().method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
        if (class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382)) {
            return class_39652;
        }
        if (this.mvg <= 80) {
            return null;
        }
        class_2350 class_23502 = class_2350.method_10142((double)(class_2432.field_1352 - class_2433.field_1352), (double)(class_2432.field_1351 - class_2433.field_1351), (double)(class_2432.field_1350 - class_2433.field_1350));
        class_243 class_2434 = class_2433.method_1031((double)class_23502.method_10148() * 0.5, (double)class_23502.method_10164() * 0.5, (double)class_23502.method_10165() * 0.5);
        return new class_3965(class_2434, class_23502, class_23382, false);
    }

    private boolean mzs(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return false;
        }
        String string = this.getWorld().method_8320(class_23382).method_26204().method_63499().toLowerCase();
        return string.contains("chest") && !string.contains("ender_chest");
    }

    private void mzt(class_476 class_4762) {
        int n;
        int n2 = this.mzv(class_1802.field_8071);
        for (int i = n = ((class_1707)class_4762.method_17577()).method_7629().method_5439(); i < ((class_1707)class_4762.method_17577()).field_7761.size(); ++i) {
            class_1799 class_17992;
            class_1735 class_17352 = (class_1735)((class_1707)class_4762.method_17577()).field_7761.get(i);
            if (class_17352.field_7871 != this.getPlayer().method_31548() || class_17352.method_34266() >= 36 || (class_17992 = class_17352.method_7677()).method_7960() || class_17992.method_31574(class_1802.field_42716) || class_17992.method_31574(class_1802.field_8469) || this.isTrashItem(class_17992) || this.nel(class_17992) || this.neo(class_17992) || class_17992.method_31574(class_1802.field_8705) || (class_17992.method_31574(class_1802.field_8071) ? n2 <= this.mre : !this.mxr(class_17992) && (class_17992.method_7909().method_7876().contains("sword") || class_17992.method_7909().method_7876().contains("mace") || class_17992.method_31574(class_1802.field_8288)))) continue;
            int n3 = i;
            int n4 = ((class_1707)class_4762.method_17577()).field_7763;
            this.msy.add(() -> {
                if (this.mc.field_1761 != null && this.getPlayer() != null && this.getPlayer().field_7512.field_7763 == n4 && !this.mzu(n3)) {
                    this.mc.field_1761.method_2906(n4, n3, 0, class_1713.field_7794, (class_1657)this.getPlayer());
                }
            });
        }
    }

    private boolean mzu(int n) {
        class_1703 class_17032 = this.getPlayer().field_7512;
        return n >= 0 && n < class_17032.field_7761.size() && ((class_1735)class_17032.field_7761.get(n)).method_7677().method_31574(class_1802.field_42716);
    }

    private int mzv(class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(i);
            if (!class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private boolean mzw(class_476 class_4762, int n) {
        this.mrf = StashDriver.plan(class_4762.method_17577(), this.getPlayer().method_31548(), class_17992 -> class_17992.method_7909() == class_1802.field_8071, n, this.mty, System.currentTimeMillis());
        this.mrg = 0;
        return this.mrf != null;
    }

    private void mzx() {
        pmc pmc2;
        class_476 class_4762;
        class_437 class_4372;
        block6: {
            block5: {
                class_4372 = this.mc.field_1755;
                if (!(class_4372 instanceof class_476)) break block5;
                class_4762 = (class_476)class_4372;
                if (this.mc.field_1761 != null && this.getPlayer() != null) break block6;
            }
            this.mrf = null;
            this.mrg = 0;
            return;
        }
        class_4372 = class_4762.method_17577();
        if (++this.mrg == 120) {
            this.mrf.abort();
        }
        if ((pmc2 = this.mrf.drive((class_1703)class_4372, System.currentTimeMillis(), (arg_0, arg_1, arg_2) -> this.lambda$driveTake$11((class_1703)class_4372, arg_0, arg_1, arg_2))) == pmc.DONE || pmc2 == pmc.GAVE_UP || this.mrg > 160) {
            this.mrf = null;
            this.mrg = 0;
            this.mtb = 2 + this.mty.nextInt(4);
        }
    }

    private void mzy() {
        class_476 class_4762;
        class_437 class_4372;
        block5: {
            block4: {
                class_4372 = this.mc.field_1755;
                if (!(class_4372 instanceof class_476)) break block4;
                class_4762 = (class_476)class_4372;
                if (this.mc.field_1761 != null && this.getPlayer() != null) break block5;
            }
            return;
        }
        class_4372 = class_4762.method_17577();
        int n = StashDriver.stashSlot((class_1703)class_4372, this.getPlayer().method_31548(), class_4372.method_34255(), -1);
        if (n != -1) {
            this.mc.field_1761.method_2906(class_4372.field_7763, n, 0, class_1713.field_7790, (class_1657)this.getPlayer());
        }
    }

    private String mzz() {
        for (String string : this.mrd) {
            if (string.equals("еда") && !this.mri) {
                return string;
            }
            if (string.equals("инвиз") && !this.mrj) {
                return string;
            }
            if (!string.equals("скорость") || this.mrk) continue;
            return string;
        }
        return "скорость";
    }

    private void naa() {
        Collections.shuffle(this.mrd, this.mty);
        this.mre = 3;
        this.mrc = 0;
        this.mwg = 4.0f + this.mty.nextFloat() * 14.0f;
    }

    private int nab(boolean bl) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(i);
            if (!(bl ? this.nel(class_17992) : this.neo(class_17992))) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int nac(class_476 class_4762, int n) {
        int n2 = ((class_1707)class_4762.method_17577()).method_7629().method_5439();
        if (n < 9) {
            return n2 + 27 + n;
        }
        return n2 + (n - 9);
    }

    private boolean nad(class_476 class_4762, boolean bl) {
        return this.nae(class_4762, class_17992 -> bl ? this.nel((class_1799)class_17992) : this.neo((class_1799)class_17992));
    }

    private boolean nae(class_476 class_4762, Predicate<class_1799> predicate) {
        boolean bl = false;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(i);
            if (!predicate.test(class_17992)) continue;
            int n = this.nac(class_4762, i);
            this.msy.add(() -> this.mc.field_1761.method_2906(((class_1707)class_4762.method_17577()).field_7763, n, 0, class_1713.field_7794, (class_1657)this.getPlayer()));
            bl = true;
        }
        return bl;
    }

    private void naf(class_476 class_4762, boolean bl) {
        int n = this.nab(bl);
        if (this.mrb > 4) {
            this.msy.add(() -> this.nag(bl));
            return;
        }
        if (n == 1) {
            this.mrb = 0;
            this.msy.add(() -> this.nag(bl));
            return;
        }
        ++this.mrb;
        if (n > 1) {
            if (!this.nad(class_4762, bl)) {
                this.msy.add(() -> this.nag(bl));
            }
            return;
        }
        if (!this.nah(class_4762, bl)) {
            this.msy.add(() -> this.nag(bl));
        }
    }

    private void nag(boolean bl) {
        if (bl) {
            this.mrj = true;
        } else {
            this.mrk = true;
        }
        this.mrb = 0;
        this.mc.field_1724.method_7346();
        this.mrl = null;
    }

    private boolean nah(class_476 class_4762, boolean bl) {
        this.mrf = StashDriver.plan(class_4762.method_17577(), this.getPlayer().method_31548(), class_17992 -> bl ? this.nel((class_1799)class_17992) : this.neo((class_1799)class_17992), 1, this.mty, System.currentTimeMillis());
        this.mrg = 0;
        return this.mrf != null;
    }

    private String[] nai() {
        String[] stringArray;
        String[] stringArray2;
        String string = this.mqi.get();
        String[] stringArray3 = stringArray2 = string == null ? new String[]{} : string.trim().split("[,\\s]+");
        if (stringArray2.length == 0 || stringArray2[0].isEmpty()) {
            String[] stringArray4 = new String[1];
            stringArray = stringArray4;
            stringArray4[0] = "an508";
        } else {
            stringArray = stringArray2;
        }
        return stringArray;
    }

    private String naj() {
        String[] stringArray = this.nai();
        if (this.mqp >= stringArray.length) {
            this.mqp = 0;
        }
        return stringArray[this.mqp];
    }

    private static String nak(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string.trim();
        while (string2.startsWith("/")) {
            string2 = string2.substring(1).trim();
        }
        return string2;
    }

    private void nal(String string) {
        int n = InstanceQueue.position(this.mxs());
        this.mwn = Lang.t(string) + (n > 0 ? Lang.s(" (#" + n + ")", " (" + n + "-й)") : "");
        if (this.mwa - this.mwm > 600) {
            this.mwm = this.mwa;
            this.notifyUser(this.mwn, false);
        }
        if (this.mzh()) {
            this.ndi();
        } else {
            PathHelper.resetKeys();
            this.mzg();
        }
    }

    private void nam() {
        String[] stringArray = this.nai();
        for (int i = 0; i < stringArray.length; ++i) {
            int n = (this.mqp + i) % stringArray.length;
            if (!InstanceQueue.hasRoom(stringArray[n], this.mxs())) continue;
            this.mqp = n;
            break;
        }
        String string = AutoEnd.nak(this.naj());
        if (!InstanceQueue.enter(this.mxs(), string)) {
            this.nal("Все анки лута заняты - ждём очереди");
            return;
        }
        this.mwn = "";
        this.getNetworkHandler().method_45730(string);
        this.mrn = 0;
        this.mro = false;
        this.mrp = null;
        this.mrq = 0;
        this.msq = false;
        this.msr = 0;
        this.mss = 0;
        this.mst = false;
        this.mut = this.getWorld();
        this.mwz = this.getWorld();
        this.mxa = this.getPlayer();
        this.mxb = this.getPlayer() == null ? null : this.getPlayer().method_73189();
        this.mxc = -1;
        this.mxd = false;
        this.mxe = 0;
        this.mxf = 0;
        this.myd(mpm.WARPING_TO_LOOT_BASE);
    }

    private boolean nan() {
        class_746 class_7462 = this.getPlayer();
        return this.mxd || this.getWorld() != this.mwz || class_7462 != this.mxa || this.mxb != null && class_7462.method_73189().method_1022(this.mxb) > 48.0;
    }

    private void nao() {
        boolean bl;
        PathHelper.resetKeys();
        this.mzf();
        ++this.mrn;
        this.mst = false;
        if (!this.msq) {
            if (this.mrn < 12) {
                return;
            }
            this.nas();
            return;
        }
        if (!this.mro) {
            if (this.mxc < 0) {
                if (this.mrn - this.mss >= 10 && (this.nan() || this.mrn >= 200)) {
                    this.mxc = this.mrn;
                }
                return;
            }
            if (this.mrn - this.mxc >= 10) {
                if (this.mzh()) {
                    this.mro = true;
                    this.myd(mpm.RUN_TO_FARM_COORDS);
                    return;
                }
                this.nap();
            }
            return;
        }
        int n = this.naw();
        if (n > 0) {
            this.mrq = 0;
            return;
        }
        if (this.mc.field_1690 != null) {
            this.mc.field_1690.field_1904.method_23481(false);
        }
        boolean bl2 = bl = this.mrp != null && this.getPlayer().method_24515().method_10262((class_2382)this.mrp) > 9.0;
        if (!bl && this.mrn - this.mxf < 200) {
            return;
        }
        if (!bl && this.mxe < 2) {
            this.nap();
            return;
        }
        ++this.mrq;
        if (this.mrq >= 40) {
            this.myd(mpm.ENTER_PORTAL);
        }
    }

    private void nap() {
        this.getNetworkHandler().method_45730(this.mxt());
        this.mro = true;
        ++this.mxe;
        this.mrp = this.getPlayer().method_24515();
        this.mxf = this.mrn;
        this.mrq = 0;
    }

    private void naq() {
        if (this.mzh()) {
            PathHelper.resetKeys();
            this.msc = 0;
            this.myd(mpm.RUN_TO_FARM_COORDS);
            return;
        }
        this.ncf();
        this.mux = true;
        this.mc.field_1690.field_1894.method_23481(true);
        this.mc.field_1690.field_1867.method_23481(true);
        this.mc.field_1690.field_1903.method_23481(this.getPlayer().field_5976 && this.getPlayer().method_24828());
        ++this.msc;
        if (this.msc > 600) {
            this.msc = 0;
            PathHelper.resetKeys();
            String string = Lang.s("Didn't get into the End - back to the save", "Не попал в Энд - на сейв");
            this.notifyUser(string, false);
            this.myo(string);
            this.mxu();
            this.myd(mpm.TELEPORT_TO_SAVE);
        }
    }

    private void nar() {
        int n;
        class_2338 class_23382 = new class_2338(0, 66, 1);
        if (Math.abs(this.getPlayer().method_23317()) <= 10.0 && Math.abs(this.getPlayer().method_23321() - 1.0) <= 10.0 && Math.abs(this.getPlayer().method_23318() - 66.0) <= 3.0) {
            PathHelper.resetKeys();
            this.mqy = null;
            this.mxg = 0;
            this.myd(mpm.FARMING);
            return;
        }
        if (this.msd > 0) {
            --this.msd;
            PathHelper.resetKeys();
            return;
        }
        if (this.mqy == null || this.mqz >= this.mqy.size()) {
            this.nbc(this.nba(class_23382));
            if (this.mqy == null || this.mqy.isEmpty()) {
                this.msd = 20;
            }
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            PathHelper.resetKeys();
        }
        if (this.getPlayer().field_6017 > 3.0 && (n = this.nei(class_1802.field_8705)) != -1) {
            this.getPlayer().method_31548().method_61496(n);
            this.nby(this.mtl.intentYaw(), 89.0f);
            if (this.mtl.intentPitch() > 65.0f) {
                this.mxv();
            }
        }
    }

    private void nas() {
        this.msq = true;
        this.mst = false;
        this.mss = this.mrn;
        this.mc.field_1690.field_1904.method_23481(false);
        this.nat();
    }

    private void nat() {
        int n;
        for (n = 0; n < 9; ++n) {
            if (!this.getPlayer().method_31548().method_5438(n).method_7960()) continue;
            this.getPlayer().method_31548().method_61496(n);
            return;
        }
        for (n = 0; n < 9; ++n) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(n);
            if (this.nel(class_17992) || this.neo(class_17992) || class_17992.method_7909() == class_1802.field_8071) continue;
            this.getPlayer().method_31548().method_61496(n);
            return;
        }
    }

    private void nau(int n) {
        int n2 = this.nav();
        int n3 = n2 != -1 ? n2 : 8;
        int n4 = n;
        this.msy.add(() -> this.ndv(n4, n3, class_1713.field_7791));
    }

    private int nav() {
        for (int i = 0; i < 9; ++i) {
            if (!this.getPlayer().method_31548().method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    private int naw() {
        return TeleportTimer.teleportSeconds(this.mc, "Телепортация через:");
    }

    private void nax() {
        this.msu = false;
        this.msv = 0;
        if ((double)this.mqr >= this.mqd.get() || this.getPlayer().method_31548().method_7376() == -1) {
            this.myd(mpm.CHECK_PVP_COOLDOWN);
            return;
        }
        if (this.mrr != null && (this.mra.contains(this.mrr) || !this.nbl(this.mrr))) {
            this.nay(false);
        }
        if (this.mrr == null && this.msf <= 0) {
            this.mrr = this.nbk();
            if (this.mrr == null) {
                this.msf = 10;
            } else {
                this.msi = 0;
                this.msx = 0;
                this.nch();
                this.naz(this.mrr, true);
            }
        }
        if (this.mrr == null) {
            this.nbf();
            return;
        }
        ++this.msi;
        double d = this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)this.mrr));
        boolean bl = this.nbm(this.mrr);
        if (bl && d <= 16.0) {
            this.mqy = null;
            this.mqz = 0;
            this.myd(mpm.LOOTING_VASE);
            this.mrs = 0;
            this.msu = false;
            this.msx = 0;
            return;
        }
        if (this.msi > this.mys(300)) {
            this.nay(true);
            return;
        }
        if (!this.mvh && bl && d <= 36.0 && this.ncs(class_243.method_24953((class_2382)this.mrr))) {
            this.mvh = true;
        }
        if (this.mvh && bl) {
            this.muy = this.nbo(this.mrr);
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
            this.msx = 0;
            return;
        }
        ++this.msx;
        if (this.msx >= 40) {
            this.nay(true);
            return;
        }
        if (bl && d < 100.0) {
            this.ncp(class_243.method_24953((class_2382)this.mrr));
        } else if (!this.naz(this.mrr, false)) {
            PathHelper.resetKeys();
        }
    }

    private void nay(boolean bl) {
        if (bl && this.mrr != null) {
            this.mra.add(this.mrr);
        }
        this.mvh = false;
        this.mrr = null;
        this.mqy = null;
        this.mqz = 0;
        this.msx = 0;
        this.msi = 0;
        if (this.mc.field_1761 != null) {
            this.mc.field_1761.method_2925();
        }
        this.mc.field_1690.field_1886.method_23481(false);
    }

    private boolean naz(class_2338 class_23382, boolean bl) {
        if (class_23382 == null) {
            return false;
        }
        if (!bl && this.mse > 0) {
            return this.mqy != null && this.mqz < this.mqy.size();
        }
        this.mse = 8;
        this.nbc(this.nba(class_23382));
        return this.mqy != null && !this.mqy.isEmpty();
    }

    private List<class_2338> nba(class_2338 class_23382) {
        return this.nbb(this.getPlayer().method_24515(), class_23382);
    }

    private List<class_2338> nbb(class_2338 class_23382, class_2338 class_23383) {
        if (class_23383 == null || this.getWorld() == null) {
            return null;
        }
        if (this.mvn == null || !class_23383.equals((Object)this.mvo)) {
            this.mvn = pqq.random(this.mty);
            this.mvo = class_23383;
        }
        return PathFinder.findPath((class_1922)this.getWorld(), (class_1297)this.getPlayer(), class_23382, class_23383, mpt, 0.0, true, Collections.emptySet(), this.mvn);
    }

    private void nbc(List<class_2338> list) {
        this.mqy = list;
        this.mqz = 0;
        Route psf2 = this.mvm = list == null || list.isEmpty() ? null : this.mvl.plan((class_1937)this.getWorld(), (class_1657)this.getPlayer(), list, list.get(list.size() - 1), new prz());
        if (this.mvm == null) {
            this.mqy = null;
        }
    }

    private class_2338 nbd(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return class_23382;
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        block0: for (int i = 0; i <= 10; ++i) {
            for (int j = 1; j >= -1; j -= 2) {
                class_23392.method_10103(class_23382.method_10263(), class_23382.method_10264() + i * j, class_23382.method_10260());
                if (this.nbe((class_2338)class_23392)) {
                    return class_23392.method_10062();
                }
                if (i == 0) continue block0;
            }
        }
        return class_23382;
    }

    private boolean nbe(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return false;
        }
        return this.getWorld().method_8320(class_23382).method_26220((class_1922)this.getWorld(), class_23382).method_1110() && this.getWorld().method_8320(class_23382.method_10084()).method_26220((class_1922)this.getWorld(), class_23382.method_10084()).method_1110() && !this.getWorld().method_8320(class_23382.method_10074()).method_26220((class_1922)this.getWorld(), class_23382.method_10074()).method_1110();
    }

    private void nbf() {
        if (this.nci() && this.mvm != null && this.mse <= 0 && !this.myq() && this.mvl.remaining(this.mvm) < 3.5) {
            this.mse = 8;
            this.nbg();
        }
        if (this.mqy == null || this.mqz >= this.mqy.size()) {
            if (this.mse > 0) {
                PathHelper.resetKeys();
                this.ncf();
                return;
            }
            this.mse = 8;
            this.nbg();
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            PathHelper.resetKeys();
            this.ncf();
        }
    }

    private void nbg() {
        class_2338 class_23382 = this.getPlayer().method_24515();
        this.nbi(class_23382);
        if (Double.isNaN(this.mvt)) {
            this.mvt = Math.toRadians((double)this.ncj() + 90.0);
        }
        double[] dArray = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
        int n = 0;
        for (int i = 0; i < dArray.length && n < 2; ++i) {
            double d = this.mvt + dArray[(i + this.mvv) % dArray.length] + this.mty.nextGaussian() * 0.28;
            double d2 = 17.0 + this.mty.nextDouble() * 19.0;
            class_2338 class_23383 = class_23382.method_10069((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2));
            if (this.nbj(class_23383) && this.mvu < 2) continue;
            ++n;
            List<class_2338> list = this.nbb(class_23382, this.nbd(class_23383));
            if (list == null || list.size() < 5) continue;
            this.mvt = d;
            this.mvu = 0;
            this.mvv = 0;
            this.nbc(list);
            return;
        }
        ++this.mvu;
        this.mvv = (this.mvv + 2) % dArray.length;
        this.mvt += 1.5707963267948966 + this.mty.nextDouble() * Math.PI;
        this.nbc(null);
    }

    private static long nbh(class_2338 class_23382) {
        return (long)(class_23382.method_10263() >> 4) << 32 ^ (long)(class_23382.method_10260() >> 4) & 0xFFFFFFFFL;
    }

    private void nbi(class_2338 class_23382) {
        if (this.mvw.size() > 512) {
            this.mvw.clear();
        }
        this.mvw.add(AutoEnd.nbh(class_23382));
    }

    private boolean nbj(class_2338 class_23382) {
        return this.mvw.contains(AutoEnd.nbh(class_23382));
    }

    private class_2338 nbk() {
        class_2338 class_23382 = this.getPlayer().method_24515();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        if (this.getWorld() != null) {
            for (class_1657 class_16572 : this.getWorld().method_18456()) {
                if (class_16572 == this.getPlayer()) continue;
                arrayList.add(class_16572.method_73189());
            }
        }
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        int n = 0;
        int n2 = -1;
        for (int i = 0; i <= 32; ++i) {
            for (int j = -i; j <= i; ++j) {
                for (int k = -i; k <= i; ++k) {
                    if (Math.max(Math.abs(j), Math.abs(k)) != i) continue;
                    for (int i2 = -8; i2 <= 8; ++i2) {
                        int n3 = class_23382.method_10264() + i2;
                        if (n3 >= 80 && n3 <= 90) continue;
                        class_23392.method_10103(class_23382.method_10263() + j, n3, class_23382.method_10260() + k);
                        if (!this.nbl((class_2338)class_23392) || this.mra.contains(class_23392)) continue;
                        double d2 = class_23392.method_10262((class_2382)class_23382) * (0.8 + this.mty.nextDouble() * 0.65);
                        if (!this.nbn((class_2338)class_23392)) {
                            d2 *= 2.4;
                        }
                        class_243 class_2432 = class_243.method_24953((class_2382)class_23392);
                        for (class_243 class_2433 : arrayList) {
                            if (!(class_2433.method_1025(class_2432) < 1600.0)) continue;
                            d2 += 100000.0;
                            break;
                        }
                        ++n;
                        if (!(d2 < d)) continue;
                        d = d2;
                        class_23383 = class_23392.method_10062();
                    }
                }
            }
            if (class_23383 == null) continue;
            if (n2 < 0) {
                n2 = i;
            }
            if (i < n2 + 4 && n < 12) continue;
            return class_23383;
        }
        return class_23383;
    }

    private boolean nbl(class_2338 class_23382) {
        if (this.getWorld() == null || class_23382 == null) {
            return false;
        }
        return this.getWorld().method_8320(class_23382).method_27852(class_2246.field_42752);
    }

    private boolean nbm(class_2338 class_23382) {
        return this.nbo(class_23382) != null;
    }

    private boolean nbn(class_2338 class_23382) {
        class_243[] class_243Array;
        class_243 class_2432 = this.getPlayer().method_33571();
        for (class_243 class_2433 : class_243Array = new class_243[]{class_243.method_24953((class_2382)class_23382), class_243.method_24953((class_2382)class_23382).method_1031(0.0, 0.4, 0.0)}) {
            class_3965 class_39652 = this.getWorld().method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
            if (class_39652.method_17783() != class_239.class_240.field_1333 && !class_39652.method_17777().equals((Object)class_23382)) continue;
            return true;
        }
        return false;
    }

    private class_243 nbo(class_2338 class_23382) {
        class_243[] class_243Array;
        if (this.getWorld() == null || this.getPlayer() == null || class_23382 == null) {
            return null;
        }
        class_243 class_2432 = this.getPlayer().method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        for (class_243 class_2434 : class_243Array = new class_243[]{class_2433.method_1031(this.muz, this.mva, this.mvb), class_2433.method_1031(0.0, 0.35, 0.0), class_2433.method_1031(0.0, -0.35, 0.0), class_2433.method_1031(0.3, 0.0, 0.0), class_2433.method_1031(-0.3, 0.0, 0.0), class_2433.method_1031(0.0, 0.0, 0.3), class_2433.method_1031(0.0, 0.0, -0.3)}) {
            class_3965 class_39652 = this.getWorld().method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
            if (class_39652.method_17783() != class_239.class_240.field_1333 && !class_39652.method_17777().equals((Object)class_23382)) continue;
            return class_2434;
        }
        return null;
    }

    private void nbp(class_243 class_2432) {
        this.msu = true;
        this.mrs = 0;
        this.msv = 0;
        this.msk = false;
        this.msn = 0;
        this.mso = Double.MAX_VALUE;
        this.msp = -1;
        this.msl.clear();
        this.mqy = null;
        this.mqz = 0;
        this.mc.field_1690.field_1886.method_23481(false);
        this.mxx();
        if (this.mc.field_1761 != null) {
            this.mc.field_1761.method_2925();
        }
        this.msj = class_2432;
        this.msm.clear();
        if (this.mc.field_1687 != null) {
            for (class_1297 class_12972 : this.mc.field_1687.method_18112()) {
                class_1542 class_15422;
                if (!(class_12972 instanceof class_1542) || !((class_15422 = (class_1542)class_12972).method_5707(class_2432) < 100.0) || class_15422.method_6985() <= 20) continue;
                this.msm.add(class_15422.method_5628());
            }
        }
    }

    private void nbq() {
        if (this.mrr == null || !this.nbl(this.mrr)) {
            if (!this.msu) {
                class_243 class_2432;
                class_243 class_2433 = class_2432 = this.mrr != null ? class_243.method_24953((class_2382)this.mrr) : this.getPlayer().method_73189();
                if (this.mrr != null) {
                    this.mra.add(this.mrr);
                    ++this.mqu;
                }
                this.mrr = null;
                this.nbp(class_2432);
            }
            this.nbs(mpm.FARMING);
            return;
        }
        ++this.mrs;
        class_243 class_2434 = this.nbo(this.mrr);
        double d = this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)this.mrr));
        if (class_2434 == null || d > 20.25) {
            this.mc.field_1690.field_1886.method_23481(false);
            if (this.mc.field_1761 != null) {
                this.mc.field_1761.method_2925();
            }
            if (this.mqy == null || this.mqz >= this.mqy.size()) {
                this.naz(this.mrr, false);
            }
            if (this.mqy != null && this.mqz < this.mqy.size()) {
                this.ncr();
            } else {
                PathHelper.resetKeys();
            }
            if (this.mrs > this.mys(80)) {
                this.nay(true);
                this.myd(mpm.FARMING);
            }
            return;
        }
        if (this.nbr(this.mrr)) {
            this.mux = true;
            this.mc.field_1690.field_1894.method_23481(true);
            this.mc.field_1690.field_1867.method_23481(true);
            this.mc.field_1690.field_1903.method_23481(false);
        } else {
            PathHelper.resetKeys();
        }
        this.ncb(this.mrr, class_2434);
        boolean bl = this.nco(this.mrr) != null;
        this.ncd(bl);
        if (bl && this.mvc > 0) {
            --this.mvc;
            bl = false;
        }
        this.mc.field_1690.field_1886.method_23481(bl);
        if (this.mrs > this.mys(100)) {
            this.nay(true);
            this.myd(mpm.FARMING);
        }
    }

    private boolean nbr(class_2338 class_23382) {
        double d;
        if (!this.getPlayer().method_24828() || this.getPlayer().method_5799()) {
            return false;
        }
        if (Math.abs((double)class_23382.method_10264() - this.getPlayer().method_23318()) > 1.0) {
            return false;
        }
        double d2 = (double)class_23382.method_10263() + 0.5 - this.getPlayer().method_23317();
        double d3 = Math.hypot(d2, d = (double)class_23382.method_10260() + 0.5 - this.getPlayer().method_23321());
        if (d3 < 2.0) {
            return false;
        }
        double d4 = (d3 - 1.3) / d3;
        return this.nct(new class_243(this.getPlayer().method_23317() + d2 * d4, this.getPlayer().method_23318(), this.getPlayer().method_23321() + d * d4), true);
    }

    private void nbs(mpm mpm2) {
        int n;
        ++this.mrs;
        this.mc.field_1690.field_1886.method_23481(false);
        this.mc.field_1690.field_1904.method_23481(false);
        class_243 class_2432 = this.msj != null ? this.msj : this.getPlayer().method_73189();
        class_1542 class_15422 = null;
        double d = Double.MAX_VALUE;
        if (this.mc.field_1687 != null) {
            for (class_1297 class_12972 : this.mc.field_1687.method_18112()) {
                double d2;
                class_1542 class_15423;
                if (!(class_12972 instanceof class_1542) || !(class_15423 = (class_1542)class_12972).method_5805() || class_15423.method_5707(class_2432) > 64.0 && class_15423.method_5858((class_1297)this.getPlayer()) > 36.0) continue;
                if (!this.msm.contains(class_15423.method_5628())) {
                    this.msk = true;
                }
                if (this.isTrashItem(class_15423.method_6983()) || this.msl.contains(class_15423.method_5628()) || !((d2 = class_15423.method_5858((class_1297)this.getPlayer())) < d)) continue;
                d = d2;
                class_15422 = class_15423;
            }
        }
        if (class_15422 != null) {
            int n2;
            this.msv = 0;
            if (class_15422.method_5628() != this.msp) {
                this.msp = class_15422.method_5628();
                this.msn = 0;
                this.mso = d;
                this.mqy = null;
                this.mqz = 0;
            }
            ++this.msn;
            if (d < this.mso - 0.05) {
                this.mso = d;
                this.msn = 0;
            }
            if (this.msn > (n2 = this.mys(d < 2.25 ? 30 : 60))) {
                this.msl.add(class_15422.method_5628());
                this.msp = -1;
                this.mqy = null;
                this.mqz = 0;
                PathHelper.resetKeys();
                return;
            }
            if (d > 6.25) {
                class_1297 class_12972;
                class_12972 = class_15422.method_24515();
                if (this.mqy == null || this.mqy.isEmpty() || this.mqz >= this.mqy.size() || this.mqy.get(this.mqy.size() - 1).method_10262((class_2382)class_12972) > 4.0) {
                    this.naz((class_2338)class_12972, false);
                }
                if (this.mqy != null && this.mqz < this.mqy.size()) {
                    this.ncr();
                } else {
                    this.ncq(class_15422.method_73189(), true);
                }
            } else if (PathHelper.isBlockedHorizontally() && this.msn > 12) {
                if (this.mqy == null || this.mqz >= this.mqy.size()) {
                    this.naz(class_15422.method_24515(), false);
                }
                if (this.mqy != null && this.mqz < this.mqy.size()) {
                    this.ncr();
                } else {
                    this.nbt(class_15422.method_73189());
                }
            } else {
                this.mqy = null;
                this.nbt(class_15422.method_73189());
            }
        } else {
            ++this.msv;
            double d3 = Math.hypot(class_2432.field_1352 - this.getPlayer().method_23317(), class_2432.field_1350 - this.getPlayer().method_23321());
            if (!this.msk && this.msj != null && this.mrs < 12 && d3 > 1.1 && this.ncx(class_2338.method_49638((class_2374)this.msj))) {
                this.ncq(new class_243(class_2432.field_1352, this.getPlayer().method_23318(), class_2432.field_1350), true);
            } else {
                PathHelper.resetKeys();
            }
        }
        int n3 = n = this.msk ? 4 : 24;
        if (this.msv > n && this.mrs > 8 || this.mrs > this.mys(160)) {
            PathHelper.resetKeys();
            this.nbu(mpm2);
        }
    }

    private void nbt(class_243 class_2432) {
        class_746 class_7462 = this.getPlayer();
        class_243 class_2433 = new class_243(class_2432.field_1352, class_7462.method_33571().field_1351 - 0.6, class_2432.field_1350);
        int n = this.mvl.walkTo(this.mc, (class_1657)class_7462, (class_1937)this.getWorld(), class_2432, this.mtu, this.mtv, class_2433, false, this.myq(), this.myt());
        if (n != 0 && !this.myq()) {
            PathHelper.resetKeys();
        }
        this.mux = true;
        this.mry = true;
    }

    private void nbu(mpm mpm2) {
        ++this.mqr;
        this.mrr = null;
        this.mrz = null;
        this.mqy = null;
        this.mqz = 0;
        this.msu = false;
        this.msv = 0;
        this.msj = null;
        this.msk = false;
        this.msl.clear();
        this.msm.clear();
        this.msp = -1;
        this.msn = 0;
        this.mso = Double.MAX_VALUE;
        this.msi = 0;
        this.msx = 0;
        this.msb = false;
        this.msf = 0;
        this.msg = 0;
        this.mse = 0;
        this.myd(mpm2);
    }

    private void nbv() {
        this.mtw = this.getPlayer();
        if (this.mtw != null) {
            this.nce(this.mtw);
            this.mtl.reset(this.mtw.method_36454(), this.mtw.method_36455());
            this.mtu = this.mtw.method_36454();
            this.mtv = this.mtw.method_36455();
            this.mtx = this.mtw.method_73189();
        }
        this.mtn = false;
        this.mto = false;
        this.mua = false;
        this.mub = false;
        this.muc = false;
    }

    private void nbw() {
        SilentRotation.clear();
        if (this.mtn) {
            this.mtn = false;
            if (this.driver == null && this.mtm.ownedBy(this)) {
                this.mtm.release(this.mc.field_1724);
            }
        }
    }

    private boolean nbx() {
        boolean bl;
        class_746 class_7462 = this.getPlayer();
        if (class_7462 == null) {
            return false;
        }
        boolean bl2 = bl = this.mtw != class_7462 || this.mtx == null || class_7462.method_73189().method_1025(this.mtx) > 400.0;
        if (bl) {
            if (this.driver == null) {
                this.mtm.reset();
            }
            if (this.mtw != class_7462) {
                this.nce((class_1657)class_7462);
            }
            this.mtl.reset(class_7462.method_36454(), class_7462.method_36455());
            this.mtu = class_7462.method_36454();
            this.mtv = class_7462.method_36455();
            this.mtw = class_7462;
            this.mtn = false;
            this.mqy = null;
            this.mqz = 0;
            this.mvm = null;
            this.mvl.reset();
        }
        this.mtx = class_7462.method_73189();
        return bl;
    }

    private void nby(float f, float f2) {
        this.nbz(f, f2, false);
    }

    private void nbz(float f, float f2, boolean bl) {
        this.mts = f;
        this.mtt = f2;
        this.mtq = bl;
        this.mtr = false;
        this.mvd = 0.0;
        this.mto = true;
        this.mtp = false;
    }

    private void nca(class_243 class_2432) {
        float[] fArray = RotationUtil.calculateAngle(class_2432);
        this.nbz(fArray[0], fArray[1], false);
    }

    private void ncb(class_2338 class_23382, class_243 class_2432) {
        this.nca(class_2432);
        this.mvd = this.mve ? 0.25 : this.ncc(class_23382, class_2432);
    }

    private double ncc(class_2338 class_23382, class_243 class_2432) {
        if (this.getWorld() == null || this.getPlayer() == null || class_23382 == null || class_2432 == null) {
            return 0.0;
        }
        class_265 class_2652 = this.getWorld().method_8320(class_23382).method_26218((class_1922)this.getWorld(), class_23382);
        class_238 class_2383 = class_2652.method_1110() ? new class_238(class_23382) : class_2652.method_1107().method_996(class_23382);
        double d = Math.min(Math.min(Math.min(class_2432.field_1352 - class_2383.field_1323, class_2383.field_1320 - class_2432.field_1352), Math.min(class_2432.field_1351 - class_2383.field_1322, class_2383.field_1325 - class_2432.field_1351)), Math.min(class_2432.field_1350 - class_2383.field_1321, class_2383.field_1324 - class_2432.field_1350));
        if (d <= 0.02) {
            return 0.25;
        }
        double d2 = Math.max(0.5, this.getPlayer().method_33571().method_1022(class_2432));
        return class_3532.method_15350((double)(Math.toDegrees(Math.atan2(d, d2)) * 0.55), (double)0.25, (double)4.0);
    }

    private void ncd(boolean bl) {
        if (bl || this.mtl.isMoving()) {
            this.mvf = 0;
            return;
        }
        if (++this.mvf >= 3) {
            this.mve = true;
        }
    }

    private void nce(class_1657 class_16572) {
        String string = class_16572.method_7334() != null ? class_16572.method_7334().name() : null;
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        this.mtl.personalize(l);
        this.mvl.personalize(l);
    }

    private void ncf() {
        if (!this.mto) {
            this.mtp = true;
        }
    }

    private boolean ncg() {
        if (this.mvi > 0) {
            --this.mvi;
            return true;
        }
        if (this.mvj > 0) {
            --this.mvj;
            return false;
        }
        if (this.msu || this.mqq != mpm.FARMING && this.mqq != mpm.FARMING_SAND && this.mqq != mpm.RUN_TO_FARM_COORDS) {
            return false;
        }
        this.mvj = 2400 + this.mty.nextInt(4200);
        this.mvi = 8 + this.mty.nextInt(26);
        return true;
    }

    private void nch() {
        this.mvh = false;
        this.mve = false;
        this.mvf = 0;
        this.muz = (this.mty.nextDouble() - 0.5) * 0.34;
        this.mva = (this.mty.nextDouble() - 0.5) * 0.44;
        this.mvb = (this.mty.nextDouble() - 0.5) * 0.34;
        this.mvc = 1 + this.mty.nextInt(4);
    }

    private boolean nci() {
        return this.mqy != null && this.mqz < this.mqy.size();
    }

    private float ncj() {
        return (float)this.mvl.moveYaw(this.mtu);
    }

    private void nck() {
        if (this.getPlayer() == null) {
            return;
        }
        this.mvr = this.mto && !this.mtq;
        boolean bl = this.mvl.takeTurn(this.mvs);
        if (this.myq() && !this.mvr) {
            this.ncl();
            return;
        }
        if (this.mc.field_1755 == null) {
            this.mtl.setMouseStep(this.driver != null ? this.driver.mouseStep() : MouseQuantizer.step());
            if (this.ncm()) {
                this.mtl.freeze();
            } else if (this.mto) {
                if (this.mtq && this.mtr) {
                    this.mtl.aimTight(this.mts, this.mtt);
                } else if (this.mtq) {
                    this.mtl.aimRelaxed(this.mts, this.mtt);
                } else {
                    this.mtl.aim(this.mts, this.mtt, this.mvd);
                }
            } else if (bl) {
                this.mtl.turn(this.mvs[0], this.mvs[1]);
            } else if (this.mtp) {
                this.mtl.hold();
            } else {
                this.mtl.idle();
            }
            this.mtu = this.mtl.getYaw();
            this.mtv = this.mtl.getPitch();
        }
        this.mto = false;
        this.mtp = false;
        if (this.driver != null) {
            if (this.mc.field_1755 == null) {
                this.driver.look(this.mtu, class_3532.method_15363((float)this.mtv, (float)-90.0f, (float)90.0f));
            }
        } else {
            this.mtm.set(this, this.mtu, class_3532.method_15363((float)this.mtv, (float)-90.0f, (float)90.0f));
        }
        this.mtn = true;
        if (this.mc.field_1755 != null) {
            SilentRotation.clear();
        } else if (this.mvk != null) {
            SilentRotation.aimAt(this.mvk, this.mtu, this.mtv);
        }
        this.mvk = null;
    }

    private void ncl() {
        this.mto = false;
        this.mtp = false;
        class_746 class_7462 = this.getPlayer();
        this.mtl.reset(class_7462.method_36454(), class_7462.method_36455());
        this.mtu = class_7462.method_36454();
        this.mtv = class_7462.method_36455();
        if (this.mtn) {
            this.mtn = false;
            if (this.mtm.ownedBy(this)) {
                this.mtm.release(this.mc.field_1724);
            }
        }
        if (this.mc.field_1755 != null) {
            SilentRotation.clear();
        } else if (this.mvk != null) {
            SilentRotation.aimAt(this.mvk, this.mtu, this.mtv);
        }
        this.mvk = null;
    }

    private boolean ncm() {
        return this.mud > 0 || !this.msy.isEmpty() || this.mtb > 0;
    }

    private class_3965 ncn() {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        class_243 class_2432 = this.getPlayer().method_33571();
        class_243 class_2433 = class_243.method_1030((float)this.mtv, (float)this.mtu);
        double d = 4.5;
        class_243 class_2434 = class_2432.method_1031(class_2433.field_1352 * d, class_2433.field_1351 * d, class_2433.field_1350 * d);
        return this.getWorld().method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
    }

    private class_3965 nco(class_2338 class_23382) {
        class_3965 class_39652 = this.ncn();
        if (class_39652 != null && class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382)) {
            this.mvk = class_23382;
            return class_39652;
        }
        return null;
    }

    private void ncp(class_243 class_2432) {
        this.ncq(class_2432, false);
    }

    private void ncq(class_243 class_2432, boolean bl) {
        int n = this.mvl.walkTo(this.mc, (class_1657)this.getPlayer(), (class_1937)this.getWorld(), class_2432, this.mtu, this.mtv, null, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
        if (n != 0 && !this.myq()) {
            PathHelper.resetKeys();
        }
        this.mux = true;
        this.mry = true;
    }

    private void ncr() {
        if (this.mqy == null || this.mqz >= this.mqy.size()) {
            return;
        }
        if (!this.myq() && this.ncg()) {
            PathHelper.resetKeys();
            this.ncf();
            return;
        }
        if (this.mvm == null) {
            this.mvm = this.mvl.plan((class_1937)this.getWorld(), (class_1657)this.getPlayer(), this.mqy, this.mqy.get(this.mqy.size() - 1), new prz());
            if (this.mvm == null) {
                this.mqy = null;
                this.mqz = 0;
                return;
            }
        }
        class_243 class_2432 = this.muy;
        this.muy = null;
        int n = this.mvl.follow(this.mc, (class_1657)this.getPlayer(), (class_1937)this.getWorld(), this.mvm, this.mtu, this.mtv, class_2432, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
        if (n == 2) {
            this.mqy = null;
            this.mqz = 0;
            this.mvm = null;
            this.mse = 0;
            if (!this.myq()) {
                PathHelper.resetKeys();
            }
            return;
        }
        if (n == 1) {
            this.mqz = this.mqy.size();
            this.mvm = null;
            if (!this.myq()) {
                PathHelper.resetKeys();
            }
            return;
        }
        this.mqz = Math.min(this.mqy.size() - 1, this.mvm.nodeIndex(this.mvl.stride.at()));
        this.mux = true;
        this.mry = true;
    }

    private boolean ncs(class_243 class_2432) {
        return this.nct(class_2432, true);
    }

    private boolean nct(class_243 class_2432, boolean bl) {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return false;
        }
        class_243 class_2433 = this.getPlayer().method_73189();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1350 - class_2433.field_1350;
        double d3 = Math.hypot(d, d2);
        if (d3 < 0.1) {
            return true;
        }
        double d4 = this.ncu();
        int n = (int)Math.ceil(d3 / 0.45);
        for (int i = 1; i <= n; ++i) {
            double d5 = (double)i / (double)n;
            double d6 = class_2433.field_1352 + d * d5;
            double d7 = class_2433.field_1350 + d2 * d5;
            if (!this.ncv(d6, d7, d4)) {
                return false;
            }
            if (!bl || !this.ncx(class_2338.method_49637((double)d6, (double)(d4 - 0.2), (double)d7))) continue;
            return false;
        }
        return true;
    }

    private double ncu() {
        return this.nci() ? PathHelper.getStandY(this.mqy.get(this.mqz)) : this.getPlayer().method_23318();
    }

    private boolean ncv(double d, double d2, double d3) {
        return this.ncw(new class_238(d - 0.31, d3 + 0.6, d2 - 0.31, d + 0.31, d3 + 1.8, d2 + 0.31));
    }

    private boolean ncw(class_238 class_2383) {
        for (class_265 class_2652 : this.getWorld().method_20812((class_1297)this.getPlayer(), class_2383)) {
            if (class_2652.method_1110()) continue;
            return false;
        }
        return true;
    }

    private boolean ncx(class_2338 class_23382) {
        return this.getWorld().method_8320(class_23382).method_26220((class_1922)this.getWorld(), class_23382).method_1110();
    }

    private void ncy() {
        if (!this.nde()) {
            this.myd(mpm.CHECK_PVP_COOLDOWN);
            return;
        }
        this.msu = false;
        this.msv = 0;
        if (this.mrz != null && (this.mra.contains(this.mrz) || !this.ndb(this.mrz))) {
            this.ncz(false);
        }
        if (this.mrz == null && this.msg <= 0) {
            this.mrz = this.nda();
            if (this.mrz == null) {
                this.msg = 10;
            } else {
                this.msi = 0;
                this.msx = 0;
                this.nch();
                this.naz(this.mrz, true);
            }
        }
        if (this.mrz == null) {
            this.nbf();
            return;
        }
        ++this.msi;
        double d = this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)this.mrz));
        boolean bl = this.nbm(this.mrz);
        if (bl && d <= 16.0) {
            PathHelper.resetKeys();
            this.mqy = null;
            this.mqz = 0;
            this.myd(mpm.BRUSHING_SAND);
            this.msa = 0;
            this.msb = false;
            this.msx = 0;
            return;
        }
        if (this.msi > this.mys(300)) {
            this.ncz(true);
            return;
        }
        if (!this.mvh && bl && d <= 36.0 && this.ncs(class_243.method_24953((class_2382)this.mrz))) {
            this.mvh = true;
        }
        if (this.mvh && bl) {
            this.muy = this.nbo(this.mrz);
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
            this.msx = 0;
            return;
        }
        ++this.msx;
        if (this.msx >= 40) {
            this.ncz(true);
            return;
        }
        if (bl && d < 100.0) {
            this.ncp(class_243.method_24953((class_2382)this.mrz));
        } else if (!this.naz(this.mrz, false)) {
            PathHelper.resetKeys();
        }
    }

    private void ncz(boolean bl) {
        if (bl && this.mrz != null) {
            this.mra.add(this.mrz);
        }
        this.mvh = false;
        this.mrz = null;
        this.mqy = null;
        this.mqz = 0;
        this.msx = 0;
        this.msi = 0;
        this.msb = false;
        this.mc.field_1690.field_1904.method_23481(false);
    }

    private class_2338 nda() {
        class_2338 class_23382 = this.getPlayer().method_24515();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        for (class_1657 class_16572 : this.getWorld().method_18456()) {
            if (class_16572 == this.getPlayer()) continue;
            arrayList.add(class_16572.method_73189());
        }
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i <= 32; ++i) {
            for (int j = -i; j <= i; ++j) {
                for (int k = -i; k <= i; ++k) {
                    if (Math.max(Math.abs(j), Math.abs(k)) != i) continue;
                    for (int i2 = -8; i2 <= 8; ++i2) {
                        class_23392.method_10103(class_23382.method_10263() + j, class_23382.method_10264() + i2, class_23382.method_10260() + k);
                        if (!this.ndb((class_2338)class_23392) || this.mra.contains(class_23392)) continue;
                        double d2 = class_23392.method_10262((class_2382)class_23382);
                        class_243 class_2432 = class_243.method_24953((class_2382)class_23392);
                        for (class_243 class_2433 : arrayList) {
                            if (!(class_2433.method_1025(class_2432) < 1600.0)) continue;
                            d2 += 100000.0;
                            break;
                        }
                        if (!(d2 < d)) continue;
                        d = d2;
                        class_23383 = class_23392.method_10062();
                    }
                }
            }
            if (class_23383 == null || !(d < 100000.0)) continue;
            return class_23383;
        }
        return class_23383;
    }

    private boolean ndb(class_2338 class_23382) {
        if (this.getWorld() == null || class_23382 == null) {
            return false;
        }
        return this.getWorld().method_8320(class_23382).method_27852(class_2246.field_42728);
    }

    private void ndc() {
        if (!this.nde()) {
            this.mc.field_1690.field_1904.method_23481(false);
            this.msj = this.mrz != null ? class_243.method_24953((class_2382)this.mrz) : this.getPlayer().method_73189();
            this.mrz = null;
            this.msu = false;
            this.myd(mpm.LOOTING_SAND);
            return;
        }
        if (this.mrz == null || !this.ndb(this.mrz)) {
            this.mc.field_1690.field_1904.method_23481(false);
            class_243 class_2432 = this.msj = this.mrz != null ? class_243.method_24953((class_2382)this.mrz) : this.getPlayer().method_73189();
            if (this.mrz != null) {
                this.mra.add(this.mrz);
                ++this.mqv;
            }
            this.mrz = null;
            this.msu = false;
            this.myd(mpm.LOOTING_SAND);
            return;
        }
        ++this.msa;
        int n = this.ndg(0, 9);
        if (n == -1) {
            int n2 = this.ndg(9, 36);
            if (n2 != -1 && this.msy.isEmpty()) {
                int n3 = this.nav();
                if (n3 == -1) {
                    n3 = 8;
                }
                int n4 = n3;
                int n5 = n2;
                this.msy.add(() -> this.ndv(n5, n4, class_1713.field_7791));
            }
            return;
        }
        this.getPlayer().method_31548().method_61496(n);
        double d = this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)this.mrz));
        if (d > 5.0) {
            this.msb = false;
            this.mc.field_1690.field_1904.method_23481(false);
            if (this.nbm(this.mrz)) {
                this.ncp(class_243.method_24953((class_2382)this.mrz));
            } else {
                if (this.mqy == null || this.mqz >= this.mqy.size()) {
                    this.naz(this.mrz, false);
                }
                if (this.mqy != null && this.mqz < this.mqy.size()) {
                    this.ncr();
                } else {
                    PathHelper.resetKeys();
                }
            }
            if (this.msa > this.mys(120)) {
                this.mra.add(this.mrz);
                this.mrz = null;
                this.mc.field_1690.field_1904.method_23481(false);
                this.myd(mpm.FARMING_SAND);
            }
            return;
        }
        if (!this.msb) {
            this.msb = true;
            this.msa = 0;
            this.mqy = null;
            this.mqz = 0;
        }
        PathHelper.resetKeys();
        this.ncb(this.mrz, class_243.method_24953((class_2382)this.mrz));
        class_3965 class_39652 = this.nco(this.mrz);
        boolean bl = class_39652 != null;
        this.ncd(bl);
        if (bl && this.mvc > 0) {
            --this.mvc;
            bl = false;
            class_39652 = null;
        }
        if (bl) {
            this.mc.field_1690.field_1904.method_23481(true);
            if (!this.getPlayer().method_6115()) {
                class_3965 class_39653 = class_39652;
                SilentRotation.later(() -> {
                    if (this.mc.field_1761 != null && this.mc.field_1724 != null && !this.mc.field_1724.method_6115() && AutoEnd.ndf(this.mc.field_1724.method_6047())) {
                        this.mc.field_1761.method_2896(this.mc.field_1724, class_1268.field_5808, class_39653);
                        this.mc.field_1724.method_6019(class_1268.field_5808);
                    }
                });
            }
            this.msx = 0;
        } else {
            this.mc.field_1690.field_1904.method_23481(false);
            ++this.msx;
            if (this.msx > 40) {
                this.mra.add(this.mrz);
                this.mrz = null;
                this.msx = 0;
                this.msb = false;
                this.myd(mpm.FARMING_SAND);
                return;
            }
        }
        if (this.msa > 200) {
            this.mra.add(this.mrz);
            this.msj = class_243.method_24953((class_2382)this.mrz);
            this.mrz = null;
            this.msb = false;
            this.mc.field_1690.field_1904.method_23481(false);
            this.msu = false;
            this.myd(mpm.LOOTING_SAND);
        }
    }

    private void ndd() {
        if (!this.msu) {
            this.nbp(this.msj != null ? this.msj : this.getPlayer().method_73189());
        }
        this.nbs(this.nde() ? mpm.FARMING_SAND : mpm.CHECK_PVP_COOLDOWN);
    }

    private boolean nde() {
        return this.ndg(0, 36) != -1;
    }

    private static boolean ndf(class_1799 class_17992) {
        if (!class_17992.method_31574(class_1802.field_42716)) {
            return false;
        }
        if (class_17992.method_57826(class_9334.field_49630)) {
            return true;
        }
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 == null) {
            return false;
        }
        for (class_2561 class_25612 : class_92902.comp_2400()) {
            if (!class_25612.getString().toLowerCase().contains("неразрушаем")) continue;
            return true;
        }
        return false;
    }

    private int ndg(int n, int n2) {
        for (int i = n; i < n2; ++i) {
            if (!AutoEnd.ndf(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private void ndh() {
        if (this.mwa - this.mwb > 60) {
            ++this.mqp;
            this.myd(mpm.TELEPORT_TO_SAVE);
            this.mrt = null;
            return;
        }
        this.ndi();
    }

    private void ndi() {
        class_1657 class_16572 = this.neh();
        if (class_16572 != null) {
            if (this.mse <= 0 && (this.mrt == null || this.mrt.method_10262((class_2382)this.getPlayer().method_24515()) < 10.0 || class_16572.method_5858((class_1297)this.getPlayer()) < 400.0)) {
                class_243 class_2432 = this.mzj(this.getPlayer().method_73189().method_1020(class_16572.method_73189()).method_1029(), Math.toRadians(this.mty.nextGaussian() * 20.0));
                double d = 26.0 + this.mty.nextDouble() * 14.0;
                this.mrt = this.nbd(this.getPlayer().method_24515().method_10069((int)(class_2432.field_1352 * d), 0, (int)(class_2432.field_1350 * d)));
                this.mse = 10;
                this.nbc(this.nba(this.mrt));
            }
        } else if (this.mse <= 0 && (this.mrt == null || this.mrt.method_10262((class_2382)this.getPlayer().method_24515()) < 4.0)) {
            double d = this.mty.nextDouble() * Math.PI * 2.0;
            double d2 = 18.0 + this.mty.nextDouble() * 20.0;
            this.mrt = this.nbd(this.getPlayer().method_24515().method_10069((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2)));
            this.mse = 10;
            this.nbc(this.nba(this.mrt));
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            PathHelper.resetKeys();
        }
    }

    private boolean ndj() {
        return TeleportTimer.contains(this.mc, "PvP-режим активен");
    }

    private void ndk() {
        String string = AutoEnd.nak(this.mqh.get());
        if (!InstanceQueue.enter(this.mxs(), string)) {
            this.nal("На сейве уже 3 наших - ждём очереди");
            return;
        }
        this.mwn = "";
        this.getNetworkHandler().method_45730(string);
        this.mrh = false;
        this.mri = false;
        this.mrj = false;
        this.mrk = false;
        this.myn();
        this.naa();
        this.mrl = null;
        this.mqr = 0;
        this.mra.clear();
        this.mrt = null;
        this.mrn = 0;
        this.mro = false;
        this.mrp = null;
        this.mrq = 0;
        this.mst = false;
        this.myd(mpm.WARPING_TO_SAVE_BASE);
    }

    private void ndl() {
        PathHelper.resetKeys();
        this.mzf();
        ++this.mrn;
        if (this.naw() > 0) {
            this.mrq = 0;
            return;
        }
        if (this.mrn < 60) {
            return;
        }
        this.myd(mpm.RESTOCK_AND_DUMP);
    }

    public boolean isTrashItem(class_1799 class_17992) {
        Boolean bl;
        if (class_17992.method_7960()) {
            return false;
        }
        ListSetting vlj2 = this.lootList();
        if (this.mwd != this.mwa || this.mwe != vlj2.version() || this.mwc.size() > 512) {
            this.mwc.clear();
            this.mwd = this.mwa;
            this.mwe = vlj2.version();
        }
        if ((bl = this.mwc.get(class_17992)) == null) {
            bl = this.ndm(class_17992, vlj2);
            this.mwc.put(class_17992, bl);
        }
        return bl;
    }

    private boolean ndm(class_1799 class_17992, ListSetting vlj2) {
        if (this.neg(class_17992)) {
            return false;
        }
        if (class_17992.method_31574(class_1802.field_42716)) {
            return true;
        }
        if (TalismanTable.picked(class_17992, vlj2.ids())) {
            return false;
        }
        if (TalismanTable.known(class_17992)) {
            return true;
        }
        class_1792 class_17922 = class_17992.method_7909();
        String string = class_17922.method_7876().toLowerCase();
        if (class_17922 == class_1802.field_8712) {
            return false;
        }
        if (class_17922 == class_1802.field_8071) {
            return false;
        }
        if (class_17922 == class_1802.field_8086 || class_17922 == class_1802.field_8136) {
            return false;
        }
        if (class_17922 == class_1802.field_8463 || class_17922 == class_1802.field_8367) {
            return false;
        }
        if (class_17922 == class_1802.field_49813) {
            return false;
        }
        if (string.contains("head") || string.contains("skull")) {
            return false;
        }
        if (class_17922 == class_1802.field_8675) {
            return false;
        }
        String string2 = class_17992.method_7964().getString().toLowerCase();
        if (string.contains("arrow")) {
            if (string2.contains("зевс") || string2.contains("кровав") || string2.contains("мучительн")) {
                return true;
            }
            return class_17922 != class_1802.field_8087 && !class_17992.method_57826(class_9334.field_49631);
        }
        if (string2.contains("хлопушк")) {
            return true;
        }
        if (class_17922 == class_1802.field_8719) {
            return true;
        }
        if (class_17922 == class_1802.field_8613) {
            return true;
        }
        if (class_17922 == class_1802.field_8803) {
            return true;
        }
        if (class_17922 == class_1802.field_8469) {
            return true;
        }
        if (class_17922 == class_1802.field_8153) {
            return !class_17992.method_57826(class_9334.field_49631);
        }
        if (class_17922 == class_1802.field_20417 || class_17922 == class_1802.field_20414) {
            return true;
        }
        if (class_17922 == class_1802.field_8657) {
            return true;
        }
        if (class_17922 == class_1802.field_8536) {
            return true;
        }
        if (class_17922 == class_1802.field_8070) {
            return true;
        }
        if (class_17922 == class_1802.field_8815) {
            return true;
        }
        if (class_17922 == class_1802.field_8711) {
            return true;
        }
        if (class_17922 == class_1802.field_8301) {
            return true;
        }
        if (class_17922 == class_1802.field_8102) {
            return true;
        }
        if (class_17922 == class_1802.field_8745) {
            return true;
        }
        if (class_17922 == class_1802.field_8687) {
            return true;
        }
        if (class_17922 == class_1802.field_8620) {
            return true;
        }
        if (class_17922 == class_1802.field_8695 || class_17922 == class_1802.field_8397) {
            return true;
        }
        if (class_17922 == class_1802.field_8864) {
            return true;
        }
        if (class_17922 == class_1802.field_8054) {
            return true;
        }
        if (class_17922 == class_1802.field_8233 || class_17922 == class_1802.field_8882) {
            return true;
        }
        if (string.contains("_sword")) {
            return true;
        }
        if (class_17922 == class_1802.field_8606) {
            return true;
        }
        if (string.contains("horse_armor") || string.contains("wolf_armor")) {
            return true;
        }
        if (class_17922 == class_1802.field_8894) {
            return true;
        }
        if (class_17922 == class_1802.field_8777) {
            return true;
        }
        if (class_17992.method_57826(class_9334.field_50075)) {
            return true;
        }
        if (string.contains("spawn_egg")) {
            return true;
        }
        if (class_17922 == class_1802.field_8466) {
            return true;
        }
        if (class_17922 == class_1802.field_8639) {
            return true;
        }
        if (class_17922 == class_1802.field_8598 || class_17922 == class_1802.field_8529 || class_17922 == class_1802.field_8360 || class_17922 == class_1802.field_8674) {
            return true;
        }
        if (string.contains("anvil")) {
            return true;
        }
        if (string.contains("template")) {
            return true;
        }
        if (string.contains("shovel")) {
            return true;
        }
        if (class_17922 == class_1802.field_17515) {
            return true;
        }
        if (class_17922 == class_1802.field_8547) {
            return true;
        }
        if (class_17922 == class_1802.field_8140) {
            return true;
        }
        if (string.contains("music_disc")) {
            return true;
        }
        if (string.contains("vault")) {
            return true;
        }
        if (class_17922 == class_1802.field_8323) {
            return true;
        }
        if (class_17922 == class_1802.field_8666 || class_17922 == class_1802.field_8714 || class_17922 == class_1802.field_8478 || class_17922 == class_1802.field_8108) {
            return true;
        }
        if (string.contains("banner")) {
            return true;
        }
        if (class_17922 == class_1802.field_8276) {
            return true;
        }
        if (class_17922 == class_1802.field_8448) {
            return true;
        }
        if (class_17922 == class_1802.field_8207) {
            return true;
        }
        if ((string.endsWith("_helmet") || string.endsWith("_chestplate") || string.endsWith("_leggings") || string.endsWith("_boots")) && !string.contains("netherite")) {
            return true;
        }
        if (string.contains("diamond_pickaxe") || string.contains("diamond_axe")) {
            return true;
        }
        if (string.contains("netherite_pickaxe") || string.contains("netherite_axe")) {
            return true;
        }
        return class_17922 == class_1802.field_8062;
    }

    private void ndn() {
        if (this.mqq == mpm.TELEPORT_TO_SAVE || this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.RESTOCK_AND_DUMP || this.mqq == mpm.TELEPORT_TO_LOOT) {
            this.mus = true;
            this.muu = -1;
            this.muv = 0;
            return;
        }
        if (!this.mus) {
            if (this.muv > 0) {
                --this.muv;
            }
            return;
        }
        if (this.muu < 0) {
            boolean bl;
            boolean bl2 = bl = this.mut != null && this.getWorld() != this.mut;
            if (!bl && !this.mzh()) {
                return;
            }
            this.muu = 10 + this.mty.nextInt(20);
        }
        if (this.muu-- > 0) {
            return;
        }
        this.mus = false;
        this.mut = null;
        this.muu = -1;
        this.muv = 400;
    }

    private void ndo() {
        int n;
        int n2;
        if (this.nec()) {
            return;
        }
        if (this.mc.field_1755 != null || !this.msy.isEmpty() || this.mud > 0) {
            return;
        }
        if (this.mum <= 0 && this.ndx() && (n2 = this.ndy()) != -1) {
            if (this.mur > 10.0f) {
                this.mum = 200 + this.mty.nextInt(200);
                return;
            }
            this.ndz(n2);
            return;
        }
        if (this.mus || this.mqq == mpm.ESCAPING) {
            return;
        }
        if (this.mc.field_1690.field_1886.method_1434()) {
            return;
        }
        if (this.msu && this.getPlayer().method_31548().method_7376() != -1) {
            return;
        }
        n2 = 0;
        int n3 = 0;
        for (n = 9; n < 36; ++n) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(n);
            if (class_17992.method_7960()) {
                ++n3;
                continue;
            }
            if (!this.isTrashItem(class_17992)) continue;
            ++n2;
        }
        if (n2 == 0) {
            return;
        }
        if (this.muv <= 0 && n3 > 3 && n2 < 5 && this.getPlayer().method_31548().method_7376() != -1) {
            return;
        }
        this.muv = 0;
        for (n = 0; n < 9; ++n) {
            if (!this.isTrashItem(this.getPlayer().method_31548().method_5438(n))) continue;
            ++n2;
        }
        this.mud = 1;
        this.mue = n2;
        this.muf = 3 + (this.mty.nextFloat() < 0.4f ? 1 : 0);
        this.mug = 0;
        this.muh = 30 + n2 * 6;
        this.mui = -1;
    }

    private void ndp() {
        int n;
        ++this.mug;
        if (this.mug > this.muh || this.mc.field_1755 != null || this.getPlayer() == null || this.mqq == mpm.ESCAPING || this.mus) {
            this.ndq();
            return;
        }
        if (this.muf > 0) {
            --this.muf;
            return;
        }
        if (!this.isMovementSilent()) {
            return;
        }
        if (this.mue <= 0) {
            this.ndq();
            return;
        }
        int n2 = this.ndr();
        if (n2 == -1) {
            this.mue = 0;
            this.muf = 1 + this.mty.nextInt(2);
            return;
        }
        this.ndv(n2, 1, class_1713.field_7795);
        this.mui = n2;
        --this.mue;
        int n3 = n = this.mue > 0 ? this.ndr() : -1;
        if (n == -1) {
            this.mue = 0;
            this.muf = 1 + this.mty.nextInt(2);
        } else {
            this.muf = this.ndt(AutoEnd.nds(n2, n));
        }
    }

    private void ndq() {
        this.mud = 0;
        this.mue = 0;
        this.muf = 0;
        this.mug = 0;
        this.muh = 0;
        this.mui = -1;
        this.ndw();
        this.ndu();
    }

    private int ndr() {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n = this.mui != -1 ? this.mui : 13;
        int n2 = -1;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < 36; ++i) {
            double d2;
            if (!this.isTrashItem(class_16612.method_5438(i)) || !((d2 = AutoEnd.nds(n, i)) < d)) continue;
            d = d2;
            n2 = i;
        }
        return n2;
    }

    private static double nds(int n, int n2) {
        double d = n < 9 ? 3.25 : (double)((n - 9) / 9);
        double d2 = n < 9 ? (double)n : (double)((n - 9) % 9);
        double d3 = n2 < 9 ? 3.25 : (double)((n2 - 9) / 9);
        double d4 = n2 < 9 ? (double)n2 : (double)((n2 - 9) % 9);
        return Math.hypot(d - d3, d2 - d4);
    }

    private int ndt(double d) {
        int n = d <= 1.5 ? 2 : (d <= 4.0 ? 3 : 4);
        float f = this.mty.nextFloat();
        if (n == 2 && f < 0.12f) {
            n = 1;
        } else if (f > 0.65f) {
            ++n;
        }
        return n - 1;
    }

    private void ndu() {
        class_304[] class_304Array;
        if (this.mc.field_1690 == null) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{this.mc.field_1690.field_1894, this.mc.field_1690.field_1881, this.mc.field_1690.field_1913, this.mc.field_1690.field_1849, this.mc.field_1690.field_1903, this.mc.field_1690.field_1867}) {
            class_3042.method_23481(this.heldByHuman(class_3042));
        }
    }

    private void ndv(int n, int n2, class_1713 class_17132) {
        if (this.mc.field_1761 == null || this.getPlayer() == null) {
            return;
        }
        int n3 = n < 9 ? n + 36 : n;
        this.mc.field_1761.method_2906(this.getPlayer().field_7498.field_7763, n3, n2, class_17132, (class_1657)this.getPlayer());
        if (this.mc.field_1755 == null) {
            this.muw = true;
        }
    }

    private void ndw() {
        if (!this.muw) {
            return;
        }
        this.muw = false;
        if (this.mc.field_1755 != null || this.getPlayer() == null || this.getNetworkHandler() == null) {
            return;
        }
        this.getNetworkHandler().method_52787((class_2596)new class_2815(this.getPlayer().field_7498.field_7763));
    }

    private boolean ndx() {
        return this.mc.field_1755 == null && !this.muw && this.msy.isEmpty() && this.mud == 0 && !this.mus && !this.mc.field_1690.field_1886.method_1434() && !this.mc.field_1690.field_1904.method_1434() && !this.getPlayer().method_6115() && !this.getPlayer().method_7325() && this.mqq != mpm.BRUSHING_SAND && this.mqq != mpm.ESCAPING && this.mqq != mpm.LOOTING_VASE && !this.mvh;
    }

    private int ndy() {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n = class_16612.method_67532();
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            if (!this.isTrashItem(class_16612.method_5438(i)) || n2 != -1 && Math.abs(i - n) >= Math.abs(n2 - n)) continue;
            n2 = i;
        }
        return n2;
    }

    private void ndz(int n) {
        this.neb();
        this.muk = n;
        boolean bl = this.getPlayer().method_31548().method_67532() == n;
        this.mul = bl ? 0 : this.nea();
        this.getPlayer().method_31548().method_61496(n);
    }

    private int nea() {
        float f = this.mty.nextFloat();
        return f < 0.2f ? 0 : (f < 0.6f ? 1 : (f < 0.9f ? 2 : 3));
    }

    private void neb() {
        this.muk = -1;
        this.mul = 0;
        this.mun = false;
        this.muo = 0;
        this.mup = 0;
    }

    private boolean nec() {
        if (this.muk == -1) {
            return false;
        }
        if (this.mun) {
            if (this.mup == 0 && ++this.muo <= 3) {
                return true;
            }
            boolean bl = this.mup > 0;
            this.neb();
            if (bl) {
                this.mur += 1.0f;
                this.mum = this.mty.nextInt(3);
            } else {
                this.mum = 8 + this.mty.nextInt(12);
            }
            return false;
        }
        class_1661 class_16612 = this.getPlayer().method_31548();
        if (!this.ndx() || !this.isTrashItem(class_16612.method_5438(this.muk))) {
            this.neb();
            this.mum = 4 + this.mty.nextInt(8);
            return false;
        }
        if (class_16612.method_67532() != this.muk) {
            this.neb();
            this.mum = 10 + this.mty.nextInt(10);
            return false;
        }
        if (this.mul-- > 0) {
            return true;
        }
        int n = this.muk;
        int n2 = ++this.muq;
        this.mun = true;
        this.muo = 0;
        this.mup = 0;
        SilentRotation.later(() -> {
            boolean bl = this.ned(n, n2);
            if (n2 == this.muq) {
                this.mup = bl ? 1 : -1;
            }
        });
        return true;
    }

    private boolean ned(int n, int n2) {
        class_746 class_7462 = this.mc.field_1724;
        if (n2 != this.muq || !this.mun || class_7462 == null || this.mc.field_1755 != null || class_7462.method_7325() || class_7462.method_31548().method_67532() != n) {
            return false;
        }
        class_1799 class_17992 = class_7462.method_6047();
        if (!this.isTrashItem(class_17992)) {
            return false;
        }
        if (!class_7462.method_7290(class_17992.method_7947() > 1)) {
            return false;
        }
        class_7462.method_6104(class_1268.field_5808);
        return true;
    }

    public boolean busy() {
        return !this.msy.isEmpty() || this.mud > 0 || this.mtb > 0 || this.mc.field_1755 instanceof class_476;
    }

    private void nee() {
        int n;
        if (this.mc.field_1755 != null || !this.msy.isEmpty() || this.mud > 0 || this.muk != -1) {
            return;
        }
        int n2 = 0;
        for (n = 0; n < 9; ++n) {
            if (!this.getPlayer().method_31548().method_5438(n).method_7960()) continue;
            ++n2;
        }
        if (n2 >= 2) {
            return;
        }
        for (n = 0; n < 9; ++n) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(n);
            if (this.isTrashItem(class_17992) || this.neg(class_17992)) continue;
            int n3 = this.nef();
            if (n3 == -1) {
                return;
            }
            int n4 = n;
            int n5 = n3;
            this.msy.add(() -> this.ndv(n5, n4, class_1713.field_7791));
            return;
        }
    }

    private int nef() {
        for (int i = 9; i < 36; ++i) {
            if (!this.getPlayer().method_31548().method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    private boolean neg(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return true;
        }
        if (class_17992.method_7909() == class_1802.field_8071 || AutoEnd.ndf(class_17992) || class_17992.method_7909() == class_1802.field_8705) {
            return true;
        }
        return this.nel(class_17992) || this.neo(class_17992);
    }

    private class_1657 neh() {
        class_1657 class_16572 = null;
        double d = 2500.0;
        for (class_1657 class_16573 : this.getWorld().method_18456()) {
            double d2;
            if (class_16573 == this.getPlayer() || !((d2 = class_16573.method_5858((class_1297)this.getPlayer())) < d)) continue;
            d = d2;
            class_16572 = class_16573;
        }
        return class_16572;
    }

    private int nei(class_1792 class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (this.getPlayer().method_31548().method_5438(i).method_7909() != class_17922) continue;
            return i;
        }
        return -1;
    }

    private int nej() {
        for (int i = 0; i < 9; ++i) {
            if (!this.nel(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private int nek() {
        for (int i = 9; i < 36; ++i) {
            if (!this.nel(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private boolean nel(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return false;
        }
        if (class_17992.method_7909() != class_1802.field_8574 && class_17992.method_7909() != class_1802.field_8436 && class_17992.method_7909() != class_1802.field_8150) {
            return false;
        }
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 != null) {
            int n = 0;
            boolean bl = false;
            for (class_1293 class_12932 : class_18442.method_57397()) {
                ++n;
                if (class_12932.method_5579() != class_1294.field_5905) continue;
                bl = true;
            }
            if (n > 0) {
                return n == 1 && bl;
            }
        }
        String string = class_17992.method_7964().getString().toLowerCase();
        return string.contains("невидим");
    }

    private int nem() {
        for (int i = 0; i < 9; ++i) {
            if (!this.neo(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private int nen() {
        for (int i = 9; i < 36; ++i) {
            if (!this.neo(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private boolean neo(class_1799 class_17992) {
        String string;
        if (class_17992.method_7960()) {
            return false;
        }
        if (class_17992.method_7909() != class_1802.field_8574 && class_17992.method_7909() != class_1802.field_8436 && class_17992.method_7909() != class_1802.field_8150) {
            return false;
        }
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 != null) {
            int n = 0;
            boolean bl = false;
            for (class_1293 class_12932 : class_18442.method_57397()) {
                ++n;
                if (class_12932.method_5579() != class_1294.field_5904) continue;
                bl = true;
            }
            if (n > 0) {
                return n == 1 && bl;
            }
        }
        return (string = class_17992.method_7964().getString().toLowerCase()).contains("скорост") || string.contains("speed");
    }

    private /* synthetic */ void lambda$driveTake$11(class_1703 class_17032, int n, int n2, class_1713 class_17132) {
        this.mc.field_1761.method_2906(class_17032.field_7763, n, n2, class_17132, (class_1657)this.getPlayer());
    }

    private static /* synthetic */ int bbt(int n, int n2) {
        return n + n2 | 0x8658EADA;
    }

    private static /* synthetic */ int bbu(int n, int n2) {
        return AutoEnd.bbt(n, n2) ^ 0x3AFA0D50;
    }

    private static /* synthetic */ int bbv(int n, int n2) {
        return n - n2 ^ 0x7CD1E40;
    }
}

