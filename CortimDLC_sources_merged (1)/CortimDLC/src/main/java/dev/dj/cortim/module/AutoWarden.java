/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1723
 *  net.minecraft.class_1735
 *  net.minecraft.class_1743
 *  net.minecraft.class_1746
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1821
 *  net.minecraft.class_1844
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2596
 *  net.minecraft.class_2649
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2765
 *  net.minecraft.class_2767
 *  net.minecraft.class_2769
 *  net.minecraft.class_2815
 *  net.minecraft.class_2818
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3414
 *  net.minecraft.class_3489
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_418
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_490
 *  net.minecraft.class_7260
 *  net.minecraft.class_7439
 *  net.minecraft.class_746
 *  net.minecraft.class_7743
 *  net.minecraft.class_8052
 *  net.minecraft.class_9334
 */
package dev.dj.cortim.module;

import a.BotHost;
import a.ProfilePopup;
import a.ModuleCategory;
import a.lex;
import a.AutoMine;
import a.AutoEnd;
import a.nwg;
import a.nwj;
import a.nwq;
import a.nwx;
import a.AutoLoot;
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
import a.ChestFinder;
import a.SilentRotation;
import a.CameraOwner;
import a.pxa;
import a.MoveSolver;
import a.WalkDriver;
import a.rzv;
import a.WardenTimers;
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
import a.PacketHooks;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1723;
import net.minecraft.class_1735;
import net.minecraft.class_1743;
import net.minecraft.class_1746;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1821;
import net.minecraft.class_1844;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2596;
import net.minecraft.class_2649;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2765;
import net.minecraft.class_2767;
import net.minecraft.class_2769;
import net.minecraft.class_2815;
import net.minecraft.class_2818;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3414;
import net.minecraft.class_3489;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_418;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_490;
import net.minecraft.class_7260;
import net.minecraft.class_7439;
import net.minecraft.class_746;
import net.minecraft.class_7743;
import net.minecraft.class_8052;
import net.minecraft.class_9334;

public class AutoWarden
        extends BotModule {
    private static final String nxb = "an238";
    private static final String nxc = "an239";
    private static final String nxd = "Home";
    private static final String nxe = "Warp";
    private static final String nxf = "warden";
    private static final String nxg = "сброс";
    private static final String nxh = "еда";
    private static final String nxi = "инвиз";
    private static final String nxj = "невидим";
    private static final String nxk = "скорост";
    private static final String nxl = "PvP-режим активен";
    private static final String nxm = "Телепортация через:";
    private static final String nxn = "Инвентарь полон - на сейв";
    private static final String nxo = "Сундуки собраны - на сейв";
    private static final String nxp = "Нет невидимости - на сейв";
    private static final String nxq = "Нет невидимости на базе - ждём";
    private static final String nxr = "Нет еды - на сейв";
    private static final String nxs = "Смерть - на сейв";
    private static final String nxt = "Варден рядом - уходим";
    private static final String nxu = "На сейве уже 3 наших - ждём очереди";
    private static final String nxv = "Все анки лута заняты - ждём очереди";
    private static final String nxw = "Не телепортировало в город - пробуем другую анку";
    private static final double nxx = 120.0;
    private static final double nxy = 100.0;
    private static final int nxz = 200;
    private static final double nya = 7.0;
    private static final int nyb = 2400;
    private static final long nyc = 6000L;
    private static final long nyd = 10000L;
    private static final double nye = 14.0;
    private static final long nyf = 240L;
    private static final int nyg = 3;
    private static final int[] nyh = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
    private static final float nyi = -55.0f;
    private static final float nyj = 86.0f;
    private static final int nyk = 3;
    private static final int nyl = 3;
    private static final int nym = 100;
    private static AutoWarden nyn;
    private static boolean nyo;
    private final pnz nyp = new pnz();
    private final NumberSetting nyq = this.add(new NumberSetting("Max chests", 5.0, 1.0, 30.0, 1.0));
    private final ListSetting nyr = this.add(new ListSetting("Loot list", vlg.LOOT, TalismanTable.WARDEN_DEFAULTS));
    private final NumberSetting nys = this.add(new NumberSetting("Loot delay", 60.0, 35.0, 200.0, 5.0).suffix("ms"));
    private final BoolSetting nyt = this.add(new BoolSetting("Take speed", false));
    private final TextSetting nyu = this.add(new TextSetting("Save anarchy", "an238", 32));
    private final TextSetting nyv = this.add(new TextSetting("Loot anarchy", "an239", 120));
    private final ModeSetting nyw = this.add(new ModeSetting("Teleport by", "Home", "Home", "Warp"));
    private final TextSetting nyx = this.add(new TextSetting("Home name", "warden", 32));
    private final TextSetting nyy = this.add(new TextSetting("Warp name", "warden", 32));
    private final BoolSetting nyz = this.add(new BoolSetting("Show route", false));
    private final ButtonSetting nza = this.add(new ButtonSetting("Neuro walking", new vkq("Record and train", Icon.LAYERS, () -> ProfilePopup.openWalk("AutoWarden"))));
    private nwx nzb = nwx.BOOT;
    private int nzc = 0;
    private int nzd = 0;
    private int nze = 0;
    private final Random nzf = new Random();
    private int nzg = 0;
    private class_2338 nzh = null;
    private final Map<class_2338, Long> nzi = new HashMap<class_2338, Long>();
    private final Map<class_2338, Long> nzj = new HashMap<class_2338, Long>();
    private final Set<class_2338> nzk = new HashSet<class_2338>();
    private final Map<class_2338, Long> nzl = new HashMap<class_2338, Long>();
    private final Map<class_2338, Long> nzm = new HashMap<class_2338, Long>();
    private long nzn = 0L;
    private int nzo = 0;
    private final Map<class_2338, Integer> nzp = new HashMap<class_2338, Integer>();
    private List<class_2338> nzq = List.of();
    private volatile long nzr = 0L;
    private final ConcurrentLinkedQueue<String> nzs = new ConcurrentLinkedQueue();
    private rzv nzt = null;
    private class_2338 nzu = null;
    private int nzv = 99;
    private class_2338 nzw = null;
    private int nzx = 0;
    private int nzy = 0;
    private long nzz = 700L;
    private int oaa = 0;
    private class_2338 oab = null;
    private int oac = 0;
    private int oad = 0;
    private int oae = 0;
    private class_243 oaf = null;
    private boolean oag = false;
    private boolean oah = false;
    private boolean oai = false;
    private boolean oaj = false;
    private final List<nwg> oak = new ArrayList<nwg>(List.of(nwg.FOOD, nwg.INVIS, nwg.SPEED));
    private int oal = 3;
    private class_2338 oam = null;
    private nwg oan = nwg.NONE;
    private int oao = 0;
    private int oap = 0;
    private int oaq = 0;
    private long oar = 0L;
    private int oas = 0;
    private int oat = 0;
    private boolean oau = false;
    private boolean oav = false;
    private class_2338 oaw = null;
    private int oax = 0;
    private int oay = 0;
    private nwg oaz = nwg.NONE;
    private int oba = -1;
    private class_2338 obb = null;
    private long obc = 0L;
    private long obd = 0L;
    private volatile int obe = -1;
    private boolean obf = false;
    private boolean obg = false;
    private long obh = 0L;
    private int obi = -1;
    private double obj = 88.0;
    private double obk = 84.0;
    private int obl = 0;
    private int obm = 0;
    private boolean obn = false;
    private final Map<Integer, Integer> obo = new HashMap<Integer, Integer>();
    private final Set<Integer> obp = new HashSet<Integer>();
    private StashDriver obq = null;
    private int obr = 0;
    private class_2338 obs = null;
    private long obt = 0L;
    private nwg obu = nwg.NONE;
    private long obv = 0L;
    private boolean obw = false;
    private boolean obx = false;
    private long oby = 0L;
    private long obz = 0L;
    private int oca = 0;
    private int ocb = 0;
    private int occ = -1;
    private int ocd = 0;
    private boolean oce = false;
    private boolean ocf = false;
    private int ocg = -1;
    private int och = 0;
    private int oci = 0;
    private boolean ocj = false;
    private int ock = 0;
    private int ocl = 0;
    private int ocm = 0;
    private float ocn = 0.0f;
    private int oco = 0;
    private int ocp = 0;
    private int ocq = -100000;
    private final Map<class_1799, Boolean> ocr = new IdentityHashMap<class_1799, Boolean>();
    private int ocs = -1;
    private int oct = -1;
    private int ocu = 0;
    private float ocv = 10.0f;
    private int ocw = 0;
    private int ocx = 0;
    private class_1937 ocy = null;
    private class_1937 ocz = null;
    private class_1657 oda = null;
    private class_243 odb = null;
    private int odc = -1;
    private boolean odd = false;
    private int ode = -100000;
    private String odf = "";
    private int odg = 0;
    private float odh = 0.0f;
    private int odi = 0;
    private boolean odj = false;
    private int odk = 0;
    private int odl = 0;
    private int odm = -1;
    private int odn = -100000;
    private final int[] odo = new int[]{-1, -1};
    private final int[] odp = new int[2];
    private final int[] odq = new int[2];
    private final int[] odr = new int[2];
    private final int[] ods = new int[2];
    private final boolean[] odt = new boolean[2];
    private String odu = null;
    private int odv = 0;
    private String odw = "";
    private boolean odx = false;
    private boolean ody = false;
    private final Map<String, class_2338> odz = new HashMap<String, class_2338>();
    private final Map<String, String> oea = new HashMap<String, String>();
    private boolean oeb = false;
    private class_2338 oec = null;
    private class_1937 oed = null;
    private int oee = -100000;
    private class_1657 oef = null;
    private int oeg = -100000;
    private float oeh = 0.0f;
    private boolean oei = false;
    private int oej = 0;
    private int oek = -100000;
    private boolean oel = false;
    private int oem = 0;
    private int oen = 0;
    private int oeo = 40;
    private boolean oep = false;
    private class_243 oeq = null;
    private int oer = 0;
    private int oes = 0;
    private int oet = 0;
    private class_2338 oeu = null;
    private int oev = 0;
    private int oew = 0;
    private boolean oex = false;
    private int oey = 0;
    private int oez = 1;
    private boolean ofa = false;
    private List<class_2338> ofb = null;
    private int ofc = 0;
    private int ofd = 0;
    private final WalkDriver ofe = new WalkDriver();
    private Route off = null;
    private pqq ofg = null;
    private class_2338 ofh = null;
    private boolean ofi = false;
    private boolean ofj = false;
    private boolean ofk = false;
    private final double[] ofl = new double[2];
    private double ofm = Double.NaN;
    private int ofn = 0;
    private int ofo = 0;
    private final Set<Long> ofp = new HashSet<Long>();
    private class_2338 ofq = null;
    private class_2338 ofr = null;
    private final Map<class_2338, Long> ofs = new HashMap<class_2338, Long>();
    private class_2338 oft = null;
    private class_243 ofu = null;
    private int ofv = 0;
    private int ofw = 0;
    private int ofx = 0;
    private int ofy = 0;
    private boolean ofz = false;
    private int oga = 0;
    private float ogb = 0.0f;
    private int ogc = 0;
    private class_243 ogd = null;
    private boolean oge = true;
    private double ogf = Double.NaN;
    private WardenTimers ogg;
    private int ogh = 0;
    private int ogi = 0;
    private long ogj = 0L;
    private long ogk = 0L;
    private final AimPersonalizer ogl = new AimPersonalizer().neuro(lex.WARDEN);
    private final CameraOwner ogm = CameraOwner.INSTANCE;
    private boolean ogn = false;
    private boolean ogo = false;
    private boolean ogp = false;
    private boolean ogq = false;
    private boolean ogr = false;
    private float ogs = 0.0f;
    private float ogt = 0.0f;
    private double ogu = 0.0;
    private float ogv = 0.0f;
    private float ogw = 0.0f;
    private class_1657 ogx = null;
    private class_243 ogy = null;
    private class_2338 ogz = null;
    private class_243 oha = null;
    private boolean ohb = false;
    private boolean ohc = false;
    private int ohd = 0;
    private int ohe = 0;
    private double ohf = 0.0;
    private double ohg = 0.0;
    private double ohh = 0.0;
    private int ohi = 0;
    private int ohj = 0;
    private boolean ohk = false;
    private int ohl = -1000;
    private float ohm = 0.0f;
    private boolean ohn = false;
    private boolean oho = false;
    private boolean ohp = false;
    private boolean ohq = false;
    private static /* synthetic */ long ohr;
    private static /* synthetic */ int ohs;

    public AutoWarden() {
        super("AutoWarden", "Loots the Warden town chests by timers", ModuleCategory.PLAYER);
        this.nyy.visibleWhen(() -> "Warp".equals(this.nyw.get()));
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    public static AutoWarden mainInstance() {
        return nyn;
    }

    public void registerAsMain() {
        nyn = this;
        if (!nyo) {
            nyo = true;
            PacketHooks.listen(class_25962 -> {
                AutoWarden nxa2 = nyn;
                if (nxa2 != null && nxa2.isEnabled() && !nxa2.isBotInstance()) {
                    nxa2.onPacket((class_2596<?>)class_25962);
                }
            });
        }
    }

    @Override
    public void attachBot(BotHost efz2) {
        super.attachBot(efz2);
        this.ogg = new WardenTimers(false);
    }

    public boolean ownsContainer() {
        return this.oaz != nwg.NONE;
    }

    public void copySettingsFrom(AutoWarden nxa2) {
        if (nxa2 == null || nxa2 == this) {
            return;
        }
        this.nyq.set(nxa2.nyq.get());
        this.nyr.set(nxa2.nyr.ids());
        this.nys.set(nxa2.nys.get());
        this.nyt.set(nxa2.nyt.get());
        this.nyu.set(nxa2.nyu.get());
        this.nyv.set(nxa2.nyv.get());
        this.nyw.set(nxa2.nyw.get());
        this.nyx.set(nxa2.nyx.get());
        this.nyy.set(nxa2.nyy.get());
    }

    public Setting[] botSettings() {
        return new Setting[]{this.nyu, this.nyv, this.nyw, this.nyx, this.nyy, this.nyq, this.nys, this.nyt};
    }

    public ListSetting lootList() {
        AutoWarden nxa2 = nyn;
        return this.driver != null && nxa2 != null && nxa2 != this ? nxa2.nyr : this.nyr;
    }

    private boolean oht(class_1799 class_17992) {
        Boolean bl;
        if (class_17992.method_7960()) {
            return false;
        }
        ListSetting vlj2 = this.lootList();
        if (this.ocs != this.nzd || this.oct != vlj2.version() || this.ocr.size() > 256) {
            this.ocr.clear();
            this.ocs = this.nzd;
            this.oct = vlj2.version();
        }
        if ((bl = this.ocr.get(class_17992)) == null) {
            bl = TalismanTable.picked(class_17992, vlj2.ids());
            this.ocr.put(class_17992, bl);
        }
        return bl;
    }

    public String queueNote() {
        return this.odf;
    }

    private Object ohu() {
        return this.driver != null ? this.driver : InstanceQueue.MAIN;
    }

    public void onBotSettingChanged() {
    }

    public void setLootStart(int n) {
        this.nze = Math.max(0, n);
    }

    public String getCurrentLootAnarchy() {
        return this.olr();
    }

    public int getStateIndex() {
        return this.nzb == null ? 0 : this.nzb.ordinal();
    }

    public WalkSpeedModel walkBrain() {
        return this.ofe.brain();
    }

    public List<class_2338> getBotPath() {
        return this.ofb;
    }

    public int getBotPathIndex() {
        return this.ofc;
    }

    public class_2338 getBotTarget() {
        if (this.nzu != null) {
            return this.nzu;
        }
        if (this.oam != null) {
            return this.oam;
        }
        return this.oab;
    }

    public int getTripChests() {
        return this.nzg;
    }

    public int getMaxChests() {
        return this.nyq.getInt();
    }

    public int getTotalChests() {
        return this.ogh;
    }

    public int getTotalTrips() {
        return this.ogi;
    }

    public long getFarmMillis() {
        return this.ogj;
    }

    public void resetFarmStats() {
        this.ogh = 0;
        this.ogi = 0;
        this.ogj = 0L;
    }

    public boolean wantsBotFrame() {
        if (!this.isEnabled()) {
            return false;
        }
        if (this.oaz != nwg.NONE || this.obw) {
            return true;
        }
        this.obv = System.currentTimeMillis();
        return false;
    }

    public void onBotFrame() {
        long l;
        if (!this.isEnabled() || this.isNotInWorld()) {
            return;
        }
        this.obv = l = System.currentTimeMillis();
        this.ojk(l);
        this.okg(l);
    }

    public static void onFrame() {
        long l;
        AutoWarden nxa2 = nyn;
        if (nxa2 == null || !nxa2.isEnabled() || nxa2.isBotInstance() || nxa2.isNotInWorld()) {
            return;
        }
        nxa2.obv = l = System.currentTimeMillis();
        if (nxa2.oaz != nwg.NONE || nxa2.obw) {
            nxa2.ojk(l);
            nxa2.okg(l);
        }
    }

    @Override
    protected void onEnable() {
        if (this.getPlayer() != null) {
            this.oeh = this.getPlayer().method_6032();
        }
        if (this.driver == null) {
            try {
                AutoEnd mpq2 = Flow.getInstance().getModuleManager().get(AutoEnd.class);
                if (mpq2 != null && mpq2.isEnabled() && !mpq2.isBotInstance()) {
                    mpq2.setEnabled(false);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        this.ogk = 0L;
        this.ooi();
        this.ofp.clear();
        this.ofm = Double.NaN;
        this.ofn = 0;
        this.nyp.reset();
        this.odv = 0;
        this.odx = false;
        this.ody = false;
        this.oee = -100000;
        this.oef = null;
        this.ohv();
        this.ohw();
        this.ohy(nwx.BOOT);
        this.nzc = 10;
    }

    @Override
    protected void onDisable() {
        this.ohv();
        this.ooj();
        if (this.driver == null) {
            RouteGuide.clear();
        }
        InstanceQueue.cancel(this.ohu());
        this.odf = "";
    }

    private void ohv() {
        this.ohy(nwx.RESTOCK);
        this.ohx();
        this.oab = null;
        this.ofb = null;
        this.ofc = 0;
        this.off = null;
        this.ofe.reset();
        this.ofd = 0;
        this.oao = 0;
        this.oaa = 0;
        this.oac = 0;
        this.oam = null;
        this.oan = nwg.NONE;
        this.oap = 0;
        this.oaq = 0;
        this.oas = 0;
        this.oau = false;
        this.oav = false;
        this.oaw = null;
        this.oay = 0;
        this.oeu = null;
        this.oev = 0;
        this.oew = 0;
        this.oey = 0;
        this.oet = 0;
        this.opg();
        this.oer = 0;
        this.oeq = null;
        this.oel = false;
        this.oem = 0;
        this.odg = 0;
        this.odi = 0;
        this.odj = false;
        this.odk = 0;
        this.odl = 0;
        this.odm = -1;
        this.odp[0] = 0;
        this.odp[1] = 0;
        this.oei = false;
        this.oej = 0;
        this.oad = 0;
        this.oae = 0;
        this.ohi = 0;
        this.ohj = 1200 + this.nzf.nextInt(3000);
        this.oha = null;
        this.ohb = false;
        this.ohc = false;
        this.ohd = 0;
        this.ogu = 0.0;
        this.ogz = null;
        this.obs = null;
        this.obu = nwg.NONE;
        this.oce = false;
        this.ocd = 0;
        this.oka();
        this.okh();
        this.oku();
        this.oci = 0;
        this.ocn = 0.0f;
        this.oco = 0;
        this.ocq = -100000;
        this.ocu = 0;
        this.ocx = 0;
        this.nzs.clear();
        if (this.mc.field_1761 != null) {
            this.mc.field_1761.method_2925();
        }
        SilentRotation.clear();
        this.oje();
    }

    private void ohw() {
        this.nzg = 0;
        this.nzh = null;
        this.nzi.clear();
        this.nzj.clear();
        this.nzk.clear();
        this.nzl.clear();
        this.nzm.clear();
        this.ofs.clear();
        this.nzp.clear();
        this.nzq = List.of();
        this.oag = false;
        this.oah = false;
        this.oai = false;
        this.oaj = false;
        this.odu = null;
        for (int i = 0; i < 2; ++i) {
            this.odt[i] = false;
            this.ods[i] = 0;
        }
        this.olm();
    }

    private void ohx() {
        this.nzt = null;
        this.nzu = null;
        this.nzv = 99;
        this.nzw = null;
        this.nzx = 0;
        this.nzy = 0;
        this.ohb = false;
    }

    private void ohy(nwx nwx2) {
        if (this.nzb != nwx2) {
            this.odf = "";
        }
        this.nzb = nwx2;
    }

    private WardenTimers ohz() {
        if (this.driver != null) {
            return this.ogg;
        }
        try {
            return Flow.getInstance().getModuleManager().get(WardenTimers.class);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private void oia() {
        WardenTimers rzy2 = this.ohz();
        if (rzy2 != null) {
            rzy2.clearTimers();
        }
    }

    public void onPacket(class_2596<?> class_25962) {
        Object object;
        class_2649 class_26492;
        if (class_25962 instanceof class_2649 && (class_26492 = (class_2649)class_25962).comp_3837() != 0) {
            this.obe = class_26492.comp_3837();
            return;
        }
        if (class_25962 instanceof class_7439) {
            class_26492 = (class_7439)class_25962;
            if (this.nzs.size() < 64) {
                this.nzs.add(class_26492.comp_763().getString());
            }
            return;
        }
        class_26492 = null;
        if (class_25962 instanceof class_2767) {
            object = (class_2767)class_25962;
            class_26492 = object.method_11894();
        } else if (class_25962 instanceof class_2765) {
            class_2765 class_27652 = (class_2765)class_25962;
            class_26492 = class_27652.method_11882();
        }
        if (class_26492 != null) {
            try {
                object = ((class_3414)class_26492.comp_349()).comp_3319().method_12832();
                if (((String)object).contains("warden.roar") || ((String)object).contains("warden.angry") || ((String)object).contains("warden.sonic")) {
                    this.nzr = System.currentTimeMillis();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        WardenTimers rzy2;
        if (this.mc.field_1690 == null) {
            return;
        }
        this.mc.field_1690.field_1886.method_23481(this.oho);
        this.mc.field_1690.field_1904.method_23481(this.ohp);
        while (this.mc.field_1690.field_1886.method_1436()) {
        }
        while (this.mc.field_1690.field_1904.method_1436()) {
        }
        if (this.obw || this.oaz != nwg.NONE) {
            this.silenceMovement();
        }
        if ((rzy2 = this.ohz()) != null && !rzy2.isEnabled() && !this.isNotInWorld()) {
            rzy2.tickTimers(false);
        }
        if (this.mc.field_1724 != null && this.mc.field_1687 != null) {
            if (this.driver == null) {
                PacketHooks.ensure(this.mc);
                if (!this.ohq && this.ohn && this.ogn && !this.obw && this.oaz == nwg.NONE) {
                    this.ogm.remapHumanKeys(this.mc, this.ogm.cameraYaw(this.mc.field_1724), this.ogv);
                }
            }
            SilentRotation.applyOwn(this.mc);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEndTick(class_310 class_3102) {
        boolean bl;
        block14: {
            ++this.nzd;
            if (this.isNotInWorld()) {
                this.ogk = 0L;
                this.oig();
                return;
            }
            if (this.odx) {
                this.odx = false;
                PathHelper.resetKeys();
                if (this.driver != null) {
                    this.setBotRunning(false);
                    this.driver.halted();
                } else {
                    this.setEnabled(false);
                }
                return;
            }
            long l = System.currentTimeMillis();
            if (this.ogk != 0L) {
                this.ogj += Math.min(2000L, Math.max(0L, l - this.ogk));
            }
            this.ogk = l;
            InstanceQueue.keep(this.ohu());
            this.ook();
            this.ohm = this.getPlayer().method_36454();
            this.ohn = true;
            this.ofe.beginTick();
            bl = this.oib();
            if (bl && this.mc.field_1690 != null) {
                this.ofi = this.mc.field_1690.field_1867.method_1434();
                this.ofj = this.mc.field_1690.field_1832.method_1434();
            }
            try {
                this.oih();
                if (bl) {
                    this.oif();
                }
                this.oox();
                this.ofz = this.ohq;
                if (!this.obw && this.oaz == nwg.NONE || this.mc.field_1690 == null) break block14;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.oif();
                }
                this.oox();
                this.ofz = this.ohq;
                if ((this.obw || this.oaz != nwg.NONE) && this.mc.field_1690 != null) {
                    this.mc.field_1690.field_1886.method_23481(false);
                    this.mc.field_1690.field_1904.method_23481(false);
                }
                this.ojd();
                this.oho = this.mc.field_1690 != null && this.mc.field_1690.field_1886.method_1434();
                boolean bl2 = this.ohp = this.mc.field_1690 != null && this.mc.field_1690.field_1904.method_1434();
                if (this.driver == null) {
                    RouteGuide.publish(this.ofe.shown(), this.ofe.shownAt(), bl, bl && this.oic(), this.nyz.get(), this.getName());
                }
                throw throwable;
            }
            this.mc.field_1690.field_1886.method_23481(false);
            this.mc.field_1690.field_1904.method_23481(false);
        }
        this.ojd();
        this.oho = this.mc.field_1690 != null && this.mc.field_1690.field_1886.method_1434();
        boolean bl3 = this.ohp = this.mc.field_1690 != null && this.mc.field_1690.field_1904.method_1434();
        if (this.driver == null) {
            RouteGuide.publish(this.ofe.shown(), this.ofe.shownAt(), bl, bl && this.oic(), this.nyz.get(), this.getName());
        }
        long l = System.currentTimeMillis();
        if (l - this.obv > 80L) {
            this.ojk(l);
            this.okg(l);
        }
    }

    private boolean oib() {
        return this.driver == null && nyn == this && this.isEnabled() && RecorderHooks.walkGuide();
    }

    private boolean oic() {
        return this.ofk || this.getPlayer().method_6115() || this.obw || this.ocf || this.oaz != nwg.NONE || this.mc.field_1755 != null;
    }

    private int oid(int n) {
        return this.oib() ? n * 3 : n;
    }

    private WalkModelReader oie() {
        return AutoMine.walkModel(lex.WARDEN);
    }

    private void oif() {
        class_304[] class_304Array;
        class_315 class_3152 = this.mc.field_1690;
        if (class_3152 == null || this.obw || this.oaz != nwg.NONE || this.ocf) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903}) {
            class_3042.method_23481(this.heldByHuman(class_3042));
        }
        if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            if (class_3152.field_1867.method_1434() != this.ofi) {
                class_3152.field_1867.method_23481(true);
            }
        } else {
            class_3152.field_1867.method_23481(this.heldByHuman(class_3152.field_1867));
        }
        if (((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
            if (class_3152.field_1832.method_1434() != this.ofj) {
                class_3152.field_1832.method_23481(true);
            }
        } else {
            class_3152.field_1832.method_23481(this.heldByHuman(class_3152.field_1832));
        }
    }

    private void oig() {
        if (this.ogn) {
            this.ogn = false;
            if (this.driver == null) {
                this.ogm.reset();
            }
        }
        this.ogx = null;
        this.ogy = null;
        this.ohn = false;
        this.oho = false;
        this.ohp = false;
        SilentRotation.clear();
        this.oka();
        this.obw = false;
        this.obx = false;
        this.ocf = false;
        this.oku();
        this.obs = null;
        this.nzp.clear();
        this.nzq = List.of();
        this.ofs.clear();
        this.opg();
    }

    private void oih() {
        class_7260 class_72602;
        boolean bl;
        long l = System.currentTimeMillis();
        this.oha = null;
        this.ohq = false;
        this.ofa = false;
        this.ohk = false;
        if (this.oga <= 0 && this.mc.field_1690.field_1881.method_1434() && !this.heldByHuman(this.mc.field_1690.field_1881)) {
            this.mc.field_1690.field_1881.method_23481(false);
        }
        if (this.ofd > 0) {
            --this.ofd;
        }
        if (this.oci > 0) {
            --this.oci;
        }
        if (this.oao > 0) {
            --this.oao;
        }
        if (this.oac > 0) {
            --this.oac;
        }
        if (this.nzo > 0) {
            --this.nzo;
        }
        if (this.oaa > 0) {
            --this.oaa;
        }
        if (this.ocd > 0) {
            --this.ocd;
        }
        if (this.odl > 0) {
            --this.odl;
        }
        if (this.oco > 0) {
            --this.oco;
        }
        this.ocn *= 0.99f;
        int n = this.oqk();
        if (n > this.ocp && this.nzd - this.ocq < 200 && this.oaz == nwg.NONE) {
            this.oco = 600;
        }
        this.ocp = n;
        this.onr();
        this.oin();
        this.oim();
        this.oio();
        this.okz();
        if (this.oiq()) {
            PathHelper.resetKeys();
            return;
        }
        if (this.oel) {
            PathHelper.resetKeys();
            if (++this.oem >= 40 && !this.getPlayer().method_29504()) {
                this.ohv();
                this.ohy(nwx.TELEPORT_TO_SAVE);
            }
            return;
        }
        if (this.nzb != nwx.TELEPORT_TO_SAVE && this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nyp.check((class_1657)this.getPlayer(), System.currentTimeMillis(), 6000L)) {
            PathHelper.resetKeys();
            InstanceQueue.leave(this.ohu());
            this.ohv();
            this.ohw();
            this.ohy(nwx.TELEPORT_TO_SAVE);
            this.notifyUser("В лобби (компас в слотах) — иду на сейв " + AutoWarden.ols(this.nyu.get(), "an238"), false);
            return;
        }
        if (this.nzb == nwx.BOOT) {
            PathHelper.resetKeys();
            this.oot();
            if (--this.nzc <= 0) {
                this.oii();
            }
            return;
        }
        if (this.oir()) {
            return;
        }
        boolean bl2 = bl = this.nzb != nwx.WARPING_TO_LOOT_BASE && this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nzb != nwx.LOOTING;
        if (!this.oib()) {
            this.oiu(bl);
            this.ois(bl);
        }
        int n2 = this.ocu = PathHelper.onClimbable((class_1657)this.getPlayer()) ? this.ocu + 1 : 0;
        if (this.mc.field_1755 instanceof class_7743) {
            this.mc.field_1755.method_25419();
            return;
        }
        if (this.oaz == nwg.NONE && this.oil() && !this.ojh(l)) {
            this.olh();
            this.mc.field_1724.method_7346();
            return;
        }
        if (this.oaz != nwg.NONE) {
            PathHelper.resetKeys();
            this.oot();
            this.olh();
            return;
        }
        if (this.nzb == nwx.LOOTING) {
            this.ohy(nwx.EXPLORING);
        }
        this.mc.field_1690.field_1832.method_23481(this.mc.field_1690.field_1904.method_1434() && this.oli(this.getPlayer().method_6047()) && !this.opb());
        if (this.getPlayer().method_6032() <= 0.0f || this.getPlayer().method_29504()) {
            this.oip();
            return;
        }
        if (this.oej > 0) {
            --this.oej;
        }
        if (this.getPlayer().field_6017 > 3.0) {
            this.oei = true;
        } else if (this.oei) {
            this.oei = false;
            this.oej = 6;
        }
        float f = this.getPlayer().method_6032();
        if (f < this.oeh && this.oej <= 0 && this.oik() && this.nzb != nwx.ESCAPING) {
            class_72602 = this.onu(20.0);
            class_1657 class_16572 = this.ooh();
            this.ooa(class_72602 != null && (class_16572 == null || class_72602.method_5858((class_1297)this.getPlayer()) < class_16572.method_5858((class_1297)this.getPlayer())));
        }
        this.oeh = f;
        if (this.omp()) {
            this.oek = this.nzd;
        }
        if (!this.odj && !this.mc.field_1690.field_1904.method_1434()) {
            this.okd(l);
            if (!(this.ocg != -1 || this.obw || this.ocf || this.nzb == nwx.ESCAPING || (class_72602 = this.getPlayer().method_6047()).method_7960() || this.oqd((class_1799)class_72602))) {
                this.olj();
            }
        } else {
            this.oku();
        }
        if (this.obw) {
            PathHelper.resetKeys();
            this.oot();
            return;
        }
        this.okp();
        if (this.okx()) {
            return;
        }
        if (this.nzb != nwx.ESCAPING && !this.ond(l)) {
            if (this.olc()) {
                this.ole();
                return;
            }
        } else if (this.odg != 0) {
            this.olf();
        }
        if (this.oik() && this.nzb != nwx.ESCAPING && this.onx()) {
            this.notifyUser("Варден рядом - уходим", false);
        }
        if (bl && !this.oib()) {
            this.oiz();
        }
        if (this.oga > 0 && bl && !this.oib()) {
            --this.oga;
            this.oja();
            this.oot();
            return;
        }
        if ((this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST) && this.nzo <= 0) {
            this.nzo = 5;
            this.omy(l);
        }
        switch (this.nzb.ordinal()) {
            case 1: {
                this.olk(l);
                break;
            }
            case 2: {
                this.olx();
                break;
            }
            case 3: {
                this.olz();
                break;
            }
            case 4: {
                this.omq(l);
                break;
            }
            case 5: {
                this.one(l);
                break;
            }
            case 7: {
                this.oob();
                break;
            }
            case 8: {
                this.oof();
                break;
            }
            case 9: {
                this.omm();
                break;
            }
            case 10: {
                this.omn();
                break;
            }
        }
        if (!this.oib()) {
            this.ojc(bl);
        }
    }

    private void oii() {
        class_2338 class_23382 = this.getPlayer().method_24515();
        WardenTimers rzy2 = this.ohz();
        String string = this.oij();
        if (rzy2 != null) {
            for (rzv rzv2 : rzy2.getCachedTimers()) {
                if (!string.equals(rzv2.dimension) || !(rzv2.pos.method_1025(this.getPlayer().method_73189()) < 6400.0)) continue;
                this.nzh = class_23382;
                InstanceQueue.at(this.ohu(), this.olr());
                this.ohy(nwx.EXPLORING);
                return;
            }
        }
        if (this.olp("сброс") != null) {
            InstanceQueue.at(this.ohu(), AutoWarden.ols(this.nyu.get(), "an238"));
            this.ohy(nwx.RESTOCK);
            return;
        }
        this.ohy(nwx.TELEPORT_TO_SAVE);
    }

    private String oij() {
        return this.mc.field_1687 == null ? "" : this.mc.field_1687.method_27983().method_29177().toString();
    }

    private boolean oik() {
        return this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST || this.nzb == nwx.CHECK_PVP_COOLDOWN || this.nzb == nwx.ESCAPING || this.nzb == nwx.LOOTING || this.nzb == nwx.TELEPORT_TO_SAVE && this.nzh != null && !this.odf.isEmpty();
    }

    private boolean oil() {
        class_465 class_4652;
        class_437 class_4372 = this.mc.field_1755;
        return class_4372 instanceof class_465 && !((class_4652 = (class_465)class_4372) instanceof class_490) && !(class_4652.method_17577() instanceof class_1723);
    }

    private void oim() {
        String string;
        while ((string = this.nzs.poll()) != null) {
            boolean bl;
            int n;
            String string2 = string.toLowerCase();
            for (n = 0; n < string2.length() && !Character.isLetter(string2.charAt(n)); ++n) {
            }
            if ((string2 = string2.substring(n)).startsWith("помяним") || string2.startsWith("помянем") || string2.startsWith("вы погибли") || string2.startsWith("смерть на координатах")) {
                this.oee = this.nzd;
            }
            boolean bl2 = bl = string2.contains("уже") && (string2.contains("сервер") || string2.contains("подключ") || string2.contains("находит")) || string2.contains("already connected");
            if (this.nzb == nwx.WARPING_TO_LOOT_BASE && !this.oau && bl) {
                this.odd = true;
            }
            if (!bl || this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nzb != nwx.TELEPORT_TO_SAVE) continue;
            this.nyp.dismiss(this.getWorld());
        }
    }

    private void oin() {
        class_746 class_7462 = this.getPlayer();
        if (class_7462 != this.oef) {
            this.oeg = this.nzd;
        }
        this.oef = class_7462;
    }

    private void oio() {
        boolean bl;
        if (this.nzd - this.oee > 100) {
            return;
        }
        class_746 class_7462 = this.getPlayer();
        boolean bl2 = class_7462.method_29504() || class_7462.method_6032() <= 0.0f;
        boolean bl3 = this.nzb == nwx.TELEPORT_TO_LOOT || this.nzb == nwx.TELEPORT_TO_SAVE || this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.WARPING_TO_LOOT_BASE && (this.odc < 0 || this.oas - this.odc < 100);
        boolean bl4 = bl = !bl3 && this.oeg >= this.oee - 100;
        if (bl2 || bl) {
            this.oee = -100000;
            this.oip();
        }
    }

    private void oip() {
        if (this.oel) {
            return;
        }
        this.oel = true;
        this.oem = 0;
        ++this.nze;
        this.oka();
        this.okh();
        this.olh();
        this.notifyUser("Смерть - на сейв", false);
    }

    private boolean oiq() {
        if (!(this.mc.field_1755 instanceof class_418)) {
            this.oen = 0;
            this.oep = false;
            this.oeo = 26 + this.nzf.nextInt(34);
            return false;
        }
        this.oip();
        if (++this.oen >= this.oeo && !this.oep && this.mc.field_1724 != null) {
            this.mc.field_1724.method_7331();
            this.oep = true;
        }
        return true;
    }

    private boolean oir() {
        if (this.oes > 0) {
            --this.oes;
        }
        class_243 class_2432 = this.getPlayer().method_73189();
        if (this.oeq == null || class_2432.method_1025(this.oeq) > 2.25) {
            this.oeq = class_2432;
            this.oer = 0;
            return false;
        }
        ++this.oer;
        if (this.nzb == nwx.RESTOCK && this.ody) {
            this.oer = 0;
            return false;
        }
        if (this.oer < 2400 || this.oes > 0) {
            return false;
        }
        PathHelper.resetKeys();
        this.olh();
        if (this.mc.field_1724 != null && this.mc.field_1755 != null) {
            this.mc.field_1724.method_7346();
        }
        if (this.nzg == 0 && this.nzb != nwx.TELEPORT_TO_SAVE && this.nzb != nwx.TELEPORT_TO_LOOT) {
            this.omd(Lang.s("stood still for 2 minutes", "стоял на месте 2 минуты"));
            if (this.ome()) {
                return true;
            }
        }
        this.ohv();
        this.oeq = class_2432;
        this.oes = 600;
        this.ohy(nwx.TELEPORT_TO_SAVE);
        return true;
    }

    private void ois(boolean bl) {
        boolean bl2 = bl && this.ofz && this.ohi <= 0 && !this.obw && this.oga <= 0;
        class_243 class_2432 = this.getPlayer().method_73189();
        if (!bl2) {
            this.ofu = null;
            this.ofv = 0;
            return;
        }
        if (this.ofu == null || AutoWarden.oit(class_2432, this.ofu) > 0.9) {
            this.ofu = class_2432;
            this.ofv = 0;
            return;
        }
        if (++this.ofv >= 28) {
            this.ofu = class_2432;
            this.ofv = 0;
            this.oiv(false);
        }
    }

    private static double oit(class_243 class_2432, class_243 class_2433) {
        return Math.hypot(class_2432.field_1352 - class_2433.field_1352, class_2432.field_1350 - class_2433.field_1350);
    }

    private void oiu(boolean bl) {
        class_746 class_7462 = this.getPlayer();
        boolean bl2 = class_7462.method_24828();
        if (bl2 || Double.isNaN(this.ogf)) {
            this.ogf = class_7462.method_23318();
        }
        if (this.oge && !bl2 && class_7462.method_18798().field_1351 > 0.2) {
            this.ogd = class_7462.method_73189();
        } else if (!this.oge && bl2 && this.ogd != null) {
            double d = AutoWarden.oit(class_7462.method_73189(), this.ogd);
            double d2 = class_7462.method_23318() - this.ogd.field_1351;
            this.ogd = null;
            if (bl && this.ofz && d < 0.55 && d2 < 0.3) {
                if (++this.ogc >= 2) {
                    this.ogc = 0;
                    this.oiv(true);
                }
            } else {
                this.ogc = 0;
            }
        }
        this.oge = bl2;
    }

    private void oiv(boolean bl) {
        class_2338 class_23382;
        ++this.oet;
        this.ofy = 0;
        class_2338 class_23383 = class_23382 = this.opb() ? this.ofb.get(this.ofc) : null;
        if (class_23382 != null && this.opp(class_23382) < 6.25 && !class_23382.equals((Object)this.ofq) && (bl || class_23382.equals((Object)this.oft))) {
            this.oiw(class_23382, 30000L);
        }
        this.oft = class_23382;
        this.oiy();
        this.ofb = null;
        this.ofc = 0;
        this.ofd = 0;
        this.oey = 0;
        if (this.oet >= 4) {
            this.oet = 0;
            this.ojb();
        }
    }

    private void oiw(class_2338 class_23382, long l) {
        if (this.ofs.size() > 256) {
            this.ofs.clear();
        }
        this.ofs.put(class_23382.method_10062(), System.currentTimeMillis() + l);
    }

    private Set<class_2338> oix() {
        if (this.ofs.isEmpty()) {
            return Set.of();
        }
        long l = System.currentTimeMillis();
        this.ofs.values().removeIf(l2 -> l2 <= l);
        return this.ofs.isEmpty() ? Set.of() : new HashSet<class_2338>(this.ofs.keySet());
    }

    private void oiy() {
        this.oga = 0;
        class_746 class_7462 = this.getPlayer();
        if (class_7462 == null || !class_7462.method_24828()) {
            return;
        }
        float f = this.oow();
        float[] fArray = new float[]{180.0f, 135.0f, -135.0f, 90.0f, -90.0f};
        int n = this.nzf.nextBoolean() ? 1 : 2;
        for (int i = 0; i < fArray.length; ++i) {
            int n2 = i == 0 ? 0 : (i == 1 ? n : (i == 2 ? 3 - n : i));
            float f2 = f + fArray[n2];
            pxa pxa2 = MoveSolver.run((class_1657)class_7462, f2, false, false, 8);
            if (!(pxa2.progress > 0.35) || !(pxa2.endY > class_7462.method_23318() - 0.7) || pxa2.blockedWithin(2)) continue;
            this.ogb = f2;
            this.oga = 5 + this.nzf.nextInt(6);
            return;
        }
    }

    private void oiz() {
        if (this.ocu < 6 || this.oga > 0) {
            return;
        }
        class_746 class_7462 = this.getPlayer();
        if (this.opb() && PathHelper.getStandY(this.ofb.get(this.ofc)) > class_7462.method_23318() + 0.6) {
            return;
        }
        if (this.ocu > 200) {
            this.ocu = 0;
            this.oiv(false);
        }
        class_2338 class_23382 = class_7462.method_24515();
        this.oiw(class_23382, 30000L);
        this.oiw(class_23382.method_10074(), 30000L);
        this.ofb = null;
        this.ofc = 0;
        this.ofd = 0;
        class_243 class_2432 = PathHelper.awayFromClimbable((class_1657)class_7462);
        this.ogb = class_2432 != null ? (float)Math.toDegrees(Math.atan2(-class_2432.field_1352, class_2432.field_1350)) : this.oow() + 180.0f;
        this.oga = 6 + this.nzf.nextInt(5);
    }

    private void oja() {
        float f = -1.0f;
        float f2 = 0.0f;
        float f3 = Float.MAX_VALUE;
        for (float f4 = -1.0f; f4 <= 1.0f; f4 += 1.0f) {
            for (float f5 = -1.0f; f5 <= 1.0f; f5 += 1.0f) {
                double d;
                float f6;
                if (f4 == 0.0f && f5 == 0.0f || !((f6 = Math.abs(class_3532.method_15393((float)((float)(d = Math.toDegrees(CameraOwner.inputDirection(this.ogv, f4, f5))) - this.ogb)))) < f3)) continue;
                f3 = f6;
                f = f4;
                f2 = f5;
            }
        }
        this.ohq = true;
        this.ofa = true;
        this.mc.field_1690.field_1894.method_23481(f > 0.0f);
        this.mc.field_1690.field_1881.method_23481(f < 0.0f);
        this.mc.field_1690.field_1913.method_23481(f2 > 0.0f);
        this.mc.field_1690.field_1849.method_23481(f2 < 0.0f);
        this.mc.field_1690.field_1867.method_23481(false);
        this.mc.field_1690.field_1903.method_23481(false);
    }

    private void ojb() {
        long l = System.currentTimeMillis();
        if (this.nzb == nwx.WAITING_FOR_CHEST && this.nzu != null) {
            this.nzj.put(this.nzu, l + 30000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
        } else if (this.oab != null) {
            this.nzl.put(this.oab, l + 60000L);
            this.oab = null;
        } else if (this.nzb == nwx.CHECK_PVP_COOLDOWN) {
            this.oeu = null;
        }
    }

    private void ojc(boolean bl) {
        boolean bl2 = this.mc.field_1690.field_1894.method_1434();
        if (!(bl && bl2 && PathHelper.isBlockedHorizontally())) {
            this.oey = 0;
            if (!this.ofa) {
                this.mc.field_1690.field_1913.method_23481(false);
                this.mc.field_1690.field_1849.method_23481(false);
            }
            return;
        }
        ++this.oey;
        if (this.oey < 8) {
            return;
        }
        this.ohq = true;
        if (this.oey % 20 == 0) {
            this.oez = -this.oez;
        }
        this.mc.field_1690.field_1849.method_23481(this.oez > 0);
        this.mc.field_1690.field_1913.method_23481(this.oez < 0);
        if (this.oey > 30) {
            this.oew = (this.oew + 1) % nyh.length;
            this.oiv(false);
        }
    }

    private void ojd() {
        class_304[] class_304Array;
        if (this.mc.field_1690 == null || this.obw || this.oaz != nwg.NONE) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{this.mc.field_1690.field_1894, this.mc.field_1690.field_1881, this.mc.field_1690.field_1913, this.mc.field_1690.field_1849, this.mc.field_1690.field_1903, this.mc.field_1690.field_1832, this.mc.field_1690.field_1867}) {
            if (!this.heldByHuman(class_3042)) continue;
            class_3042.method_23481(true);
        }
    }

    private void oje() {
        class_304[] class_304Array;
        if (this.mc.field_1690 == null) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{this.mc.field_1690.field_1894, this.mc.field_1690.field_1881, this.mc.field_1690.field_1913, this.mc.field_1690.field_1849, this.mc.field_1690.field_1903, this.mc.field_1690.field_1867, this.mc.field_1690.field_1832, this.mc.field_1690.field_1886, this.mc.field_1690.field_1904}) {
            if (this.heldByHuman(class_3042)) continue;
            class_3042.method_23481(false);
        }
    }

    private void ojf() {
        class_304[] class_304Array;
        if (this.mc.field_1690 == null) {
            return;
        }
        for (class_304 class_3042 : class_304Array = new class_304[]{this.mc.field_1690.field_1894, this.mc.field_1690.field_1881, this.mc.field_1690.field_1913, this.mc.field_1690.field_1849, this.mc.field_1690.field_1903, this.mc.field_1690.field_1867}) {
            class_3042.method_23481(this.heldByHuman(class_3042));
        }
    }

    public boolean busy() {
        return this.oaz != nwg.NONE || this.obw || this.ocf;
    }

    private void ojg(class_2338 class_23382, nwg nwg2, long l) {
        this.obs = class_23382;
        this.obt = l;
        this.obu = nwg2;
    }

    private boolean ojh(long l) {
        class_1707 class_17072;
        class_437 class_4372;
        block7: {
            block6: {
                class_4372 = this.mc.field_1755;
                if (!(class_4372 instanceof class_465)) {
                    return false;
                }
                class_465 class_4652 = (class_465)class_4372;
                class_4372 = class_4652.method_17577();
                if (!(class_4372 instanceof class_1707)) break block6;
                class_17072 = (class_1707)class_4372;
                if (this.obs != null && this.obu != nwg.NONE && l - this.obt <= 2500L) break block7;
            }
            return false;
        }
        int n = this.oji(this.obs);
        if (n <= 0 || class_17072.method_17388() * 9 != n) {
            this.nzj.put(this.obs, l + 30000L);
            this.obs = null;
            return false;
        }
        this.oaz = this.obu;
        this.oba = class_4372.field_7763;
        this.obb = this.obs;
        this.obd = l;
        this.obf = false;
        this.obg = false;
        this.obm = 0;
        this.obl = 0;
        this.obn = false;
        this.obh = 0L;
        this.obi = -1;
        this.obo.clear();
        this.obp.clear();
        this.obq = null;
        this.obr = 0;
        this.obj = 88.0;
        this.obk = (114.0 + (double)class_17072.method_17388() * 18.0) / 2.0;
        this.obc = l + Math.round(class_3532.method_15350((double)(230.0 * Math.exp(this.nzf.nextGaussian() * 0.25)), (double)150.0, (double)480.0));
        this.obs = null;
        this.obu = nwg.NONE;
        if (this.oaz == nwg.LOOT) {
            this.ohy(nwx.LOOTING);
        }
        this.silenceMovement();
        return true;
    }

    private int oji(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return 0;
        }
        class_2680 class_26802 = this.getWorld().method_8320(class_23382);
        if (!(class_26802.method_26204() instanceof class_2281)) {
            return 0;
        }
        return class_26802.method_11654((class_2769)class_2281.field_10770) == class_2745.field_12569 ? 27 : 54;
    }

    private class_465<?> ojj() {
        class_437 class_4372 = this.mc.field_1755;
        if (class_4372 instanceof class_465) {
            class_465 class_4652 = (class_465)class_4372;
            if (class_4652.method_17577().field_7763 == this.oba) {
                return class_4652;
            }
        }
        return null;
    }

    private void ojk(long l) {
        if (this.oaz == nwg.NONE || this.getPlayer() == null || this.getInteractionManager() == null) {
            return;
        }
        class_465<?> class_4652 = this.ojj();
        if (class_4652 == null) {
            this.ojz();
            return;
        }
        class_1703 class_17032 = class_4652.method_17577();
        if (this.obf) {
            if (l >= this.obc) {
                if (this.ojp(class_17032, l)) {
                    return;
                }
                this.mc.field_1724.method_7346();
                this.ojz();
            }
            return;
        }
        if (l < this.obc) {
            return;
        }
        if (!this.isMovementSilent()) {
            this.obc = l + 25L;
            return;
        }
        if (this.obe != this.oba && l - this.obd < 1500L) {
            this.obc = l + 40L;
            return;
        }
        if (this.obq != null) {
            pmc pmc2 = this.obq.drive(class_17032, l, (n, n2, class_17132) -> this.ojl(class_17032, n, n2, class_17132));
            if (pmc2 == pmc.DONE || pmc2 == pmc.GAVE_UP) {
                this.obq = null;
                this.obc = l + StashDriver.settleDelay(this.nzf);
            }
            return;
        }
        if (this.ojp(class_17032, l)) {
            return;
        }
        if (!class_17032.method_34255().method_7960()) {
            this.ojy(l);
            return;
        }
        switch (this.oaz.ordinal()) {
            case 1: {
                this.ojm(class_17032, l);
                break;
            }
            case 2: {
                this.ojn(class_17032, l);
                break;
            }
            case 3: {
                this.ojo(class_17032, l);
                break;
            }
            case 4: {
                this.ojs(class_17032, l, true);
                break;
            }
            case 5: {
                this.ojs(class_17032, l, false);
                break;
            }
            default: {
                this.ojy(l);
            }
        }
    }

    private void ojl(class_1703 class_17032, int n, int n2, class_1713 class_17132) {
        this.getInteractionManager().method_2906(class_17032.field_7763, n, n2, class_17132, (class_1657)this.getPlayer());
        this.obh = System.currentTimeMillis();
        if (n >= 0 && n < class_17032.field_7761.size()) {
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
            this.obj = (double)class_17352.field_7873 + 8.0;
            this.obk = (double)class_17352.field_7872 + 8.0;
        }
    }

    private void ojm(class_1703 class_17032, long l) {
        class_1735 class_17352;
        class_1735 class_17353;
        class_1735 class_17354 = class_17353 = this.obi >= 0 && this.oju(class_17032, this.obi) ? (class_1735)class_17032.field_7761.get(this.obi) : this.ojt(class_17032, -1, true);
        if (class_17353 == null) {
            if (this.obh > 0L && l - this.obh < 240L) {
                this.obc = this.obh + 240L;
                return;
            }
            this.obn = this.ojw(class_17032);
            this.obg = true;
            this.ojy(l);
            return;
        }
        int n = this.obo.merge(class_17353.field_7874, 1, Integer::sum);
        if (n > 3) {
            this.obp.add(class_17353.field_7874);
            this.obi = -1;
            return;
        }
        this.ojl(class_17032, class_17353.field_7874, 0, class_1713.field_7794);
        if (n == 1) {
            ++this.obl;
        }
        this.obi = (class_17352 = this.ojt(class_17032, class_17353.field_7874, true)) == null ? -1 : class_17352.field_7874;
        double d = class_17352 == null ? 0.0 : Math.hypot(class_17352.field_7873 - class_17353.field_7873, class_17352.field_7872 - class_17353.field_7872) / 18.0;
        this.obc = l + this.okc(d, 1.0);
    }

    private void ojn(class_1703 class_17032, long l) {
        class_1735 class_17352;
        class_1735 class_17353 = class_17352 = this.obi >= 0 && this.ojv(class_17032, this.obi) ? (class_1735)class_17032.field_7761.get(this.obi) : this.ojt(class_17032, -1, false);
        if (class_17352 == null) {
            if (this.obh > 0L && l - this.obh < 240L) {
                this.obc = this.obh + 240L;
                return;
            }
            this.obg = true;
            this.ojy(l);
            return;
        }
        int n = this.obo.merge(class_17352.field_7874, 1, Integer::sum);
        if (n > 3) {
            this.obp.add(class_17352.field_7874);
            this.obi = -1;
            return;
        }
        this.ojl(class_17032, class_17352.field_7874, 0, class_1713.field_7794);
        class_1735 class_17354 = this.ojt(class_17032, class_17352.field_7874, false);
        this.obi = class_17354 == null ? -1 : class_17354.field_7874;
        double d = class_17354 == null ? 0.0 : Math.hypot(class_17354.field_7873 - class_17352.field_7873, class_17354.field_7872 - class_17352.field_7872) / 18.0;
        this.obc = l + this.okc(d, 1.15);
    }

    private void ojo(class_1703 class_17032, long l) {
        int n;
        int n2 = this.oqh(class_1802.field_8071);
        if (n2 > this.oal && this.obm < 6 && (n = this.ojr(class_17032, class_17992 -> class_17992.method_31574(class_1802.field_8071))) != -1) {
            ++this.obm;
            this.ojl(class_17032, n, 0, class_1713.field_7794);
            this.obc = l + this.okc(1.0, 1.4);
            return;
        }
        if (n2 >= this.oal || this.obm >= 6) {
            this.obg = true;
            this.ojy(l);
            return;
        }
        ++this.obm;
        this.obq = StashDriver.plan(class_17032, this.getPlayer().method_31548(), class_17992 -> class_17992.method_31574(class_1802.field_8071), this.oal - n2, this.nzf, l);
        if (this.obq == null) {
            this.obg = true;
            this.ojy(l);
        }
    }

    private boolean ojp(class_1703 class_17032, long l) {
        int n;
        class_1799 class_17992 = class_17032.method_34255();
        if (class_17992.method_7960() || this.obr >= 8) {
            return false;
        }
        boolean bl = this.oaz == nwg.DUMP || this.oaz == nwg.FOOD && class_17992.method_31574(class_1802.field_8071) || this.oaz == nwg.INVIS && this.oqf(class_17992, true) || this.oaz == nwg.SPEED && this.oqf(class_17992, false);
        int n2 = n = bl ? StashDriver.stashSlot(class_17032, this.getPlayer().method_31548(), class_17992, -1) : this.ojq(class_17032, class_17992);
        if (n == -1) {
            int n3 = n = bl ? this.ojq(class_17032, class_17992) : StashDriver.stashSlot(class_17032, this.getPlayer().method_31548(), class_17992, -1);
        }
        if (n == -1) {
            return false;
        }
        ++this.obr;
        this.ojl(class_17032, n, 0, class_1713.field_7790);
        this.obc = l + StashDriver.settleDelay(this.nzf);
        return true;
    }

    private int ojq(class_1703 class_17032, class_1799 class_17992) {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n = -1;
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(i);
            if (class_17352.field_7871 != class_16612 || class_17352.method_34266() >= 36) continue;
            if (!class_17352.method_7681()) {
                if (n != -1) continue;
                n = i;
                continue;
            }
            if (!class_1799.method_31577((class_1799)class_17352.method_7677(), (class_1799)class_17992) || class_17352.method_7677().method_7947() >= class_17352.method_7677().method_7914()) continue;
            return i;
        }
        return n;
    }

    private int ojr(class_1703 class_17032, Predicate<class_1799> predicate) {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(i);
            if (class_17352.field_7871 != class_16612 || class_17352.method_34266() >= 36 || !class_17352.method_7681() || !predicate.test(class_17352.method_7677()) || class_17352.method_7677().method_7947() <= n2) continue;
            n2 = class_17352.method_7677().method_7947();
            n = i;
        }
        return n;
    }

    private void ojs(class_1703 class_17032, long l, boolean bl) {
        int n = this.oqg(bl);
        if (n == 1 || this.obm > 4) {
            this.obg = true;
            this.ojy(l);
            return;
        }
        if (n > 1) {
            for (int i = 0; i < class_17032.field_7761.size(); ++i) {
                class_1735 class_17352 = (class_1735)class_17032.field_7761.get(i);
                if (class_17352.field_7871 != this.getPlayer().method_31548() || !this.oqf(class_17352.method_7677(), bl)) continue;
                this.ojl(class_17032, i, 0, class_1713.field_7794);
                this.obc = l + this.okc(1.0, 1.4);
                return;
            }
            ++this.obm;
            return;
        }
        ++this.obm;
        this.obq = StashDriver.plan(class_17032, this.getPlayer().method_31548(), class_17992 -> this.oqf((class_1799)class_17992, bl), 1, this.nzf, l);
        if (this.obq == null) {
            this.obg = true;
            this.ojy(l);
        }
    }

    private class_1735 ojt(class_1703 class_17032, int n, boolean bl) {
        class_1735 class_17352 = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            if (i == n || (bl ? !this.oju(class_17032, i) : !this.ojv(class_17032, i))) continue;
            class_1735 class_17353 = (class_1735)class_17032.field_7761.get(i);
            double d2 = Math.hypot((double)class_17353.field_7873 + 8.0 - this.obj, (double)class_17353.field_7872 + 8.0 - this.obk);
            if (!(d2 < d)) continue;
            d = d2;
            class_17352 = class_17353;
        }
        return class_17352;
    }

    private boolean oju(class_1703 class_17032, int n) {
        if (n < 0 || n >= class_17032.field_7761.size() || this.obp.contains(n)) {
            return false;
        }
        class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
        class_1661 class_16612 = this.getPlayer().method_31548();
        if (class_17352.field_7871 == class_16612 || !class_17352.method_7681()) {
            return false;
        }
        class_1799 class_17992 = class_17352.method_7677();
        return !this.oqa(class_17992) && class_17352.method_7674((class_1657)this.getPlayer()) && AutoWarden.ojx(class_16612, class_17992);
    }

    private boolean ojv(class_1703 class_17032, int n) {
        if (n < 0 || n >= class_17032.field_7761.size() || this.obp.contains(n)) {
            return false;
        }
        class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
        if (class_17352.field_7871 != this.getPlayer().method_31548() || !class_17352.method_7681() || class_17352.method_34266() >= 36) {
            return false;
        }
        class_1799 class_17992 = class_17352.method_7677();
        return !this.oqe(class_17992) && !this.oqb(class_17992);
    }

    private boolean ojw(class_1703 class_17032) {
        class_1661 class_16612 = this.getPlayer().method_31548();
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (class_17352.field_7871 == class_16612 || !class_17352.method_7681() || this.oqa(class_17352.method_7677()) || AutoWarden.ojx(class_16612, class_17352.method_7677())) continue;
            return true;
        }
        return false;
    }

    private static boolean ojx(class_1661 class_16612, class_1799 class_17992) {
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17993 = class_16612.method_5438(i);
            if (class_17993.method_7960()) {
                return true;
            }
            if (class_17993.method_7947() >= class_17993.method_7914() || !class_1799.method_31577((class_1799)class_17993, (class_1799)class_17992)) continue;
            return true;
        }
        return false;
    }

    private void ojy(long l) {
        this.obf = true;
        this.obc = l + Math.round(class_3532.method_15350((double)(160.0 * Math.exp(this.nzf.nextGaussian() * 0.25)), (double)90.0, (double)400.0));
    }

    private void ojz() {
        nwg nwg2 = this.oaz;
        class_2338 class_23382 = this.obb;
        boolean bl = this.obg;
        this.oka();
        this.oar = System.currentTimeMillis();
        this.oaq = 0;
        if (nwg2 == nwg.LOOT) {
            this.okb(class_23382);
            return;
        }
        if (nwg2 == nwg.NONE) {
            return;
        }
        if (!bl && ++this.oap < 3) {
            this.oam = null;
            return;
        }
        this.oap = 0;
        switch (nwg2.ordinal()) {
            case 2: {
                this.oag = true;
                break;
            }
            case 3: {
                this.oah = true;
                break;
            }
            case 4: {
                this.oai = true;
                break;
            }
            case 5: {
                this.oaj = true;
                break;
            }
        }
        this.oam = null;
    }

    private void oka() {
        this.oaz = nwg.NONE;
        this.oba = -1;
        this.obb = null;
        this.obf = false;
        this.obg = false;
        this.obi = -1;
        this.obo.clear();
        this.obp.clear();
        this.obq = null;
        this.obr = 0;
    }

    private void okb(class_2338 class_23382) {
        long l = System.currentTimeMillis();
        if (class_23382 != null) {
            this.nzi.put(class_23382, l);
            if (this.getWorld() != null && this.driver == null) {
                AutoLoot.markFromOutside(this.getWorld(), class_23382, this.obn);
            }
        }
        if (this.obl > 0) {
            ++this.nzg;
            ++this.ogh;
            this.odv = 0;
            if (this.nzh != null) {
                String string = InstanceQueue.key(this.olr());
                this.odz.put(string, this.nzh);
                this.oea.put(string, this.oij());
            }
        }
        this.oce = true;
        this.ohx();
        this.ofb = null;
        this.ofc = 0;
        if (this.obn || this.oql() < 2) {
            this.oml("Инвентарь полон - на сейв");
        } else if ((double)this.nzg >= this.nyq.get()) {
            this.oml("Сундуки собраны - на сейв");
        } else {
            this.ohy(nwx.EXPLORING);
            this.oaa = 0;
        }
    }

    private long okc(double d, double d2) {
        double d3 = this.nys.get() * d2;
        double d4 = d3 * Math.exp(this.nzf.nextGaussian() * 0.22) + d3 * 0.32 * (Math.log(1.0 + d) / Math.log(2.0));
        if (this.nzf.nextDouble() < 0.04) {
            d4 += d3 * (1.0 + this.nzf.nextDouble() * 1.6);
        }
        return Math.round(class_3532.method_15350((double)d4, (double)(d3 * 0.6), (double)(d3 * 5.0)));
    }

    private void okd(long l) {
        boolean bl;
        boolean bl2;
        class_1799 class_17992;
        int n;
        int n2;
        if (this.okv()) {
            return;
        }
        if (this.obw || this.oaz != nwg.NONE || this.mc.field_1755 != null) {
            return;
        }
        if (this.nzb == nwx.ESCAPING || this.nzb == nwx.BOOT || this.nzb == nwx.CHECK_PVP_COOLDOWN || this.nzb == nwx.TELEPORT_TO_SAVE || this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.TELEPORT_TO_LOOT || this.nzb == nwx.WARPING_TO_LOOT_BASE) {
            return;
        }
        if (this.oci <= 0 && this.okq() && (n2 = this.oks()) != -1) {
            if (this.ocn > 10.0f) {
                this.oci = 200 + this.nzf.nextInt(200);
                return;
            }
            this.okt(n2);
            return;
        }
        if (this.ocd > 0 || this.odl > 60) {
            return;
        }
        class_1661 class_16612 = this.getPlayer().method_31548();
        boolean bl3 = this.okr();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (n = 9; n < 36; ++n) {
            class_17992 = class_16612.method_5438(n);
            if (class_17992.method_7960()) {
                ++n4;
                continue;
            }
            if (!bl3 || !this.oqb(class_17992)) continue;
            ++n3;
        }
        for (n = 0; n < 9; ++n) {
            class_17992 = class_16612.method_5438(n);
            if (class_17992.method_7960()) {
                ++n6;
                continue;
            }
            if (this.oqb(class_17992) || this.oqd(class_17992)) continue;
            ++n5;
        }
        n = this.oke() ? 1 : 0;
        boolean bl4 = bl2 = n != 0 || n3 > 0 && (n4 <= 3 || n3 >= 5 || this.oce) || n5 > 0 && n4 > 0 && (this.oce || n6 < 2);
        if (!bl2) {
            this.oce = false;
            return;
        }
        boolean bl5 = bl = !this.opb() || this.oce;
        if (n == 0 && !bl && n4 > 1 && n6 >= 1) {
            return;
        }
        this.okf(l);
        this.oce = false;
    }

    private boolean oke() {
        if (this.nzb == nwx.RESTOCK || this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.TELEPORT_TO_SAVE) {
            return false;
        }
        return this.okj() != null;
    }

    private void okf(long l) {
        if (this.obw) {
            return;
        }
        this.oku();
        this.obw = true;
        this.obx = false;
        this.ocb = 0;
        this.occ = -1;
        this.oca = this.nzd;
        this.obz = l;
        this.oby = l + Math.round(class_3532.method_15350((double)(190.0 * Math.exp(this.nzf.nextGaussian() * 0.25)), (double)120.0, (double)420.0));
        this.silenceMovement();
    }

    private void okg(long l) {
        if (!this.obw) {
            return;
        }
        if (this.getPlayer() == null || this.mc.field_1755 != null || this.nzb == nwx.ESCAPING || l - this.obz > 9000L) {
            this.okh();
            return;
        }
        if (l < this.oby || this.nzd - this.oca < 1 || !this.isMovementSilent()) {
            return;
        }
        if (this.obx) {
            this.okh();
            return;
        }
        nwj nwj2 = this.oki();
        if (nwj2 == null) {
            this.obx = true;
            this.oby = l + (this.ocb == 0 ? 40L + (long)this.nzf.nextInt(60) : this.okn());
            return;
        }
        this.oko(nwj2.slot(), nwj2.button(), nwj2.type());
        if (nwj2.type() == class_1713.field_7795) {
            this.ocq = this.nzd;
        }
        this.occ = nwj2.cursor();
        ++this.ocb;
        nwj nwj3 = this.oki();
        if (nwj3 == null) {
            this.obx = true;
            this.oby = l + this.okn();
        } else {
            this.oby = l + this.okm(AutoWarden.okl(nwj2.cursor(), nwj3.cursor()));
        }
    }

    private void okh() {
        if (!this.obw) {
            return;
        }
        boolean bl = this.ocb == 0;
        this.obw = false;
        this.obx = false;
        this.okp();
        this.ojf();
        this.ocd = bl ? 40 : 10 + this.nzf.nextInt(20);
    }

    private nwj oki() {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n = this.occ != -1 ? this.occ : 13;
        int n2 = -1;
        double d = Double.MAX_VALUE;
        boolean bl = this.okr();
        for (int i = 0; i < 36; ++i) {
            double d2;
            if (!bl || !this.oqb(class_16612.method_5438(i)) || !((d2 = AutoWarden.okl(n, i)) < d)) continue;
            d = d2;
            n2 = i;
        }
        if (n2 != -1) {
            return new nwj(n2, 1, class_1713.field_7795, n2);
        }
        nwj nwj2 = this.okj();
        if (nwj2 != null) {
            return nwj2;
        }
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || this.oqd(class_17992)) continue;
            int n3 = this.okk(n);
            if (n3 == -1) {
                return null;
            }
            return new nwj(n3, i, class_1713.field_7791, n3);
        }
        return null;
    }

    private nwj okj() {
        int n;
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n2 = -1;
        if (this.oqi(class_17992 -> this.oqf((class_1799)class_17992, true)) == -1) {
            n2 = this.oqj(class_17992 -> this.oqf((class_1799)class_17992, true));
        }
        if (n2 == -1 && this.nyt.get() && this.oqi(class_17992 -> this.oqf((class_1799)class_17992, false)) == -1) {
            n2 = this.oqj(class_17992 -> this.oqf((class_1799)class_17992, false));
        }
        if (n2 == -1 && this.oqi(class_17992 -> class_17992.method_31574(class_1802.field_8071)) == -1) {
            n2 = this.oqj(class_17992 -> class_17992.method_31574(class_1802.field_8071));
        }
        if (n2 == -1) {
            return null;
        }
        int n3 = -1;
        for (n = 0; n < 9 && n3 == -1; ++n) {
            if (!class_16612.method_5438(n).method_7960()) continue;
            n3 = n;
        }
        for (n = 0; n < 9 && n3 == -1; ++n) {
            if (this.oqd(class_16612.method_5438(n))) continue;
            n3 = n;
        }
        if (n3 == -1) {
            return null;
        }
        return new nwj(n2, n3, class_1713.field_7791, n2);
    }

    private int okk(int n) {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n2 = -1;
        double d = Double.MAX_VALUE;
        for (int i = 9; i < 36; ++i) {
            double d2;
            if (!class_16612.method_5438(i).method_7960() || !((d2 = AutoWarden.okl(n, i)) < d)) continue;
            d = d2;
            n2 = i;
        }
        return n2;
    }

    private static double okl(int n, int n2) {
        double d = n < 9 ? 3.25 : (double)((n - 9) / 9);
        double d2 = n < 9 ? (double)n : (double)((n - 9) % 9);
        double d3 = n2 < 9 ? 3.25 : (double)((n2 - 9) / 9);
        double d4 = n2 < 9 ? (double)n2 : (double)((n2 - 9) % 9);
        return Math.hypot(d - d3, d2 - d4);
    }

    private long okm(double d) {
        double d2 = 95.0 * Math.exp(this.nzf.nextGaussian() * 0.25) + 28.0 * (Math.log(1.0 + d) / Math.log(2.0));
        if (this.nzf.nextDouble() < 0.04) {
            d2 += 120.0 + this.nzf.nextDouble() * 180.0;
        }
        return Math.round(class_3532.method_15350((double)d2, (double)55.0, (double)520.0));
    }

    private long okn() {
        return Math.round(class_3532.method_15350((double)(150.0 * Math.exp(this.nzf.nextGaussian() * 0.3)), (double)80.0, (double)420.0));
    }

    private void oko(int n, int n2, class_1713 class_17132) {
        if (this.getInteractionManager() == null || this.getPlayer() == null) {
            return;
        }
        int n3 = n < 9 ? n + 36 : n;
        this.getInteractionManager().method_2906(this.getPlayer().field_7498.field_7763, n3, n2, class_17132, (class_1657)this.getPlayer());
        if (this.mc.field_1755 == null) {
            this.ocf = true;
        }
    }

    private void okp() {
        if (!this.ocf) {
            return;
        }
        this.ocf = false;
        if (this.mc.field_1755 != null || this.getPlayer() == null || this.getNetworkHandler() == null) {
            return;
        }
        this.getNetworkHandler().method_52787((class_2596)new class_2815(this.getPlayer().field_7498.field_7763));
    }

    private boolean okq() {
        return this.mc.field_1755 == null && !this.ocf && !this.obw && this.oaz == nwg.NONE && !this.mc.field_1690.field_1886.method_1434() && !this.mc.field_1690.field_1904.method_1434() && !this.getPlayer().method_6115() && !this.getPlayer().method_7325() && this.nzb != nwx.ESCAPING && this.nzd - this.ohl > 10 && !this.ohb && !this.ond(System.currentTimeMillis()) && this.okr();
    }

    private boolean okr() {
        if (this.oco > 0 || this.nzd - this.oek < 40 || !this.opb()) {
            return false;
        }
        return this.nzb == nwx.EXPLORING || this.nzb == nwx.RESTOCK || this.nzb == nwx.WAITING_FOR_CHEST && !this.oni();
    }

    private int oks() {
        class_1661 class_16612 = this.getPlayer().method_31548();
        int n = class_16612.method_67532();
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            if (!this.oqb(class_16612.method_5438(i)) || n2 != -1 && Math.abs(i - n) >= Math.abs(n2 - n)) continue;
            n2 = i;
        }
        return n2;
    }

    private void okt(int n) {
        this.oku();
        this.ocg = n;
        boolean bl = this.getPlayer().method_31548().method_67532() == n;
        float f = this.nzf.nextFloat();
        this.och = bl ? 0 : (f < 0.2f ? 0 : (f < 0.6f ? 1 : (f < 0.9f ? 2 : 3)));
        this.getPlayer().method_31548().method_61496(n);
    }

    private void oku() {
        this.ocg = -1;
        this.och = 0;
        this.ocj = false;
        this.ock = 0;
        this.ocl = 0;
    }

    private boolean okv() {
        if (this.ocg == -1) {
            return false;
        }
        if (this.ocj) {
            if (this.ocl == 0 && ++this.ock <= 3) {
                return true;
            }
            boolean bl = this.ocl > 0;
            this.oku();
            if (bl) {
                this.ocn += 1.0f;
                this.oci = this.nzf.nextInt(3);
                this.ocq = this.nzd;
            } else {
                this.oci = 8 + this.nzf.nextInt(12);
            }
            return false;
        }
        class_1661 class_16612 = this.getPlayer().method_31548();
        if (!this.okq() || !this.oqb(class_16612.method_5438(this.ocg)) || class_16612.method_67532() != this.ocg) {
            this.oku();
            this.oci = 6 + this.nzf.nextInt(10);
            return false;
        }
        if (this.och-- > 0) {
            return true;
        }
        int n = this.ocg;
        int n2 = ++this.ocm;
        this.ocj = true;
        this.ock = 0;
        this.ocl = 0;
        SilentRotation.later(() -> {
            boolean bl = this.okw(n, n2);
            if (n2 == this.ocm) {
                this.ocl = bl ? 1 : -1;
            }
        });
        return true;
    }

    private boolean okw(int n, int n2) {
        class_746 class_7462 = this.mc.field_1724;
        if (n2 != this.ocm || !this.ocj || class_7462 == null || this.mc.field_1755 != null || class_7462.method_7325() || class_7462.method_31548().method_67532() != n) {
            return false;
        }
        class_1799 class_17992 = class_7462.method_6047();
        if (!this.oqb(class_17992)) {
            return false;
        }
        if (!class_7462.method_7290(class_17992.method_7947() > 1)) {
            return false;
        }
        class_7462.method_6104(class_1268.field_5808);
        return true;
    }

    private boolean okx() {
        boolean bl;
        boolean bl2 = this.nzb == nwx.WARPING_TO_LOOT_BASE && this.oau && (this.omo() > 0 || this.omk());
        boolean bl3 = bl = this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST || this.nzb == nwx.CHECK_PVP_COOLDOWN;
        if ((bl2 || bl) && this.odl <= 0 && !this.ond(System.currentTimeMillis())) {
            boolean bl4;
            int n = bl2 ? 2400 : 600;
            boolean bl5 = this.oky(true, n);
            boolean bl6 = bl4 = this.nyt.get() && this.oky(false, n);
            if (bl5 || bl4) {
                boolean bl7 = bl5;
                int n2 = this.oqi(class_17992 -> this.oqf((class_1799)class_17992, bl7));
                if (n2 == -1) {
                    if (this.ocd > 0) {
                        return false;
                    }
                    this.okf(System.currentTimeMillis());
                    PathHelper.resetKeys();
                    this.oot();
                    return true;
                }
                if (this.odg != 0) {
                    this.olf();
                }
                PathHelper.resetKeys();
                this.oot();
                if (this.getPlayer().method_31548().method_67532() != n2) {
                    this.getPlayer().method_31548().method_61496(n2);
                    this.olh();
                    this.odk = 0;
                    this.odj = true;
                    return true;
                }
                this.odj = true;
                ++this.odk;
                if (!(this.getPlayer().method_31548().method_5438(n2).method_31574(class_1802.field_8574) || this.old(86.0f) && !(this.ogw < 78.0f))) {
                    this.olh();
                    if (this.odk > 100) {
                        this.odk = 0;
                        this.odl = 100;
                    }
                    return true;
                }
                this.odm = bl7 ? 0 : 1;
                this.odn = this.nzd;
                this.olg(true);
                if (!this.getPlayer().method_6115() && this.odk % 5 == 0) {
                    SilentRotation.later(() -> {
                        if (this.mc.field_1724 != null && this.mc.field_1761 != null && !this.mc.field_1724.method_6115()) {
                            this.mc.field_1761.method_2919((class_1657)this.mc.field_1724, class_1268.field_5808);
                        }
                    });
                }
                if (this.odk > 100) {
                    int n3;
                    this.olh();
                    this.odk = 0;
                    this.odl = 100;
                    int n4 = n3 = bl7 ? 0 : 1;
                    this.ods[n4] = this.ods[n4] + 1;
                    if (this.ods[n4] >= 3) {
                        this.ola(n3);
                    }
                }
                return true;
            }
        }
        if (this.odj) {
            this.odj = false;
            this.odk = 0;
            this.odm = -1;
            this.olh();
            if (!this.oqb(this.getPlayer().method_6047())) {
                this.olj();
            }
        }
        return false;
    }

    private boolean oky(boolean bl, int n) {
        int n2;
        int n3 = n2 = bl ? 0 : 1;
        if (this.odt[n2] || this.odp[n2] > 0 || this.oqg(bl) == 0) {
            return false;
        }
        int n4 = this.odr[n2] > 0 ? Math.min(n, this.odr[n2] * 3 / 4) : n;
        return this.olb(bl) < n4;
    }

    private void okz() {
        for (int i = 0; i < 2; ++i) {
            boolean bl = i == 0;
            int n = this.oqg(bl);
            int n2 = this.olb(bl);
            if (this.odo[i] >= 0 && n < this.odo[i] && this.odm == i && this.nzd - this.odn <= 3) {
                this.odp[i] = 60;
                this.odq[i] = n2;
                this.ods[i] = 0;
            }
            this.odo[i] = n;
            if (this.odp[i] <= 0) continue;
            if (n2 > this.odq[i]) {
                this.odp[i] = 0;
                this.odr[i] = n2;
                continue;
            }
            int n3 = i;
            this.odp[n3] = this.odp[n3] - 1;
            if (this.odp[n3] != 0) continue;
            this.ola(i);
        }
    }

    private void ola(int n) {
        if (this.odt[n]) {
            return;
        }
        this.odt[n] = true;
        this.notifyUser(n == 0 ? Lang.s("The invisibility potion gave no effect - no more of them this trip", "Зелье невидимости не дало эффекта - больше не пью в этом заходе") : Lang.s("The speed potion gave no effect - no more of them this trip", "Зелье скорости не дало эффекта - больше не пью в этом заходе"), false);
    }

    private int olb(boolean bl) {
        class_1293 class_12932 = this.getPlayer().method_6112(bl ? class_1294.field_5905 : class_1294.field_5904);
        return class_12932 == null ? 0 : (class_12932.method_48559() ? Integer.MAX_VALUE : class_12932.method_5584());
    }

    private boolean olc() {
        boolean bl = this.getPlayer().method_7344().method_7586() < 14;
        int n = this.oqi(class_17992 -> class_17992.method_31574(class_1802.field_8071));
        boolean bl2 = this.opb();
        if (this.odg == 0) {
            if (!bl || n == -1) {
                if (this.mc.field_1690.field_1904.method_1434() && !this.ohk) {
                    this.olh();
                    if (this.getPlayer().method_6047().method_31574(class_1802.field_8071)) {
                        this.olj();
                    }
                }
                return false;
            }
            this.odh = this.ogl.intentPitch();
            this.odg = bl2 ? 2 : 1;
            this.odi = 0;
        }
        if (!(this.odg == 3 || bl && n != -1)) {
            this.olh();
            int n2 = this.odg = bl2 ? 0 : 3;
            if (this.odg == 0) {
                this.olj();
                return false;
            }
        }
        switch (this.odg) {
            case 1: {
                this.olh();
                if (!bl2 && !this.old(-55.0f)) break;
                this.odg = 2;
                this.odi = 0;
                break;
            }
            case 2: {
                if (!bl2) {
                    this.old(-55.0f);
                }
                this.getPlayer().method_31548().method_61496(n);
                this.olg(!bl2);
                if (++this.odi <= 200) break;
                this.olh();
                this.odg = 3;
                break;
            }
            case 3: {
                this.olh();
                if (!bl2 && !this.old(this.odh)) break;
                this.odg = 0;
                this.olj();
                return false;
            }
        }
        return true;
    }

    private boolean old(float f) {
        this.oom(this.ogo ? this.ogs : this.ogl.intentYaw(), f);
        return Math.abs(this.ogl.intentPitch() - f) <= 0.75f;
    }

    private void ole() {
        if (this.opb()) {
            this.opq();
            WalkDriver.setSprint(this.mc.field_1690, false);
            this.mc.field_1690.field_1903.method_23481(false);
        } else {
            PathHelper.resetKeys();
            this.oot();
        }
    }

    private void olf() {
        this.olh();
        this.odg = 0;
        this.odi = 0;
    }

    private void olg(boolean bl) {
        this.mc.field_1690.field_1832.method_23481(bl);
        this.mc.field_1690.field_1904.method_23481(true);
        SilentRotation.miss();
    }

    private void olh() {
        if (this.mc.field_1690 == null) {
            return;
        }
        this.mc.field_1690.field_1904.method_23481(false);
        this.mc.field_1690.field_1832.method_23481(false);
    }

    private boolean oli(class_1799 class_17992) {
        return !class_17992.method_7960() && (class_17992.method_31574(class_1802.field_8071) || this.oqf(class_17992, true) || this.oqf(class_17992, false));
    }

    private void olj() {
        int n;
        class_1661 class_16612 = this.getPlayer().method_31548();
        for (n = 0; n < 9; ++n) {
            if (!class_16612.method_5438(n).method_7960()) continue;
            class_16612.method_61496(n);
            return;
        }
        for (n = 0; n < 9; ++n) {
            if (this.oli(class_16612.method_5438(n))) continue;
            class_16612.method_61496(n);
            return;
        }
    }

    private void olk(long l) {
        this.odj = false;
        if (!this.oai && this.oqg(true) == 1) {
            this.oai = true;
        }
        if (this.nyt.get()) {
            if (!this.oaj && this.oqg(false) == 1) {
                this.oaj = true;
            }
        } else {
            this.oaj = true;
        }
        if (!this.oah && this.oqh(class_1802.field_8071) == this.oal) {
            this.oah = true;
        }
        if (this.oag && this.oah && this.oai && this.oaj) {
            if (this.oqg(true) == 0 && (this.olb(true) < 2400 || this.olp("инвиз", "невидим") != null)) {
                if (!this.ody) {
                    this.ody = true;
                    this.notifyUser("Нет невидимости на базе - ждём", false);
                }
                this.oai = false;
                this.oao = 600;
                return;
            }
            this.ody = false;
            if (this.ome()) {
                PathHelper.resetKeys();
                this.oou();
                return;
            }
            this.ohy(nwx.TELEPORT_TO_LOOT);
            return;
        }
        if (this.oam != null && this.nzd - this.ocw > 400) {
            this.oam = null;
            this.ofb = null;
            this.oao = 40;
            this.oln();
        }
        if (this.oam == null) {
            class_2338 class_23382;
            if (this.oao > 0) {
                PathHelper.resetKeys();
                this.oou();
                return;
            }
            nwg nwg2 = !this.oag ? nwg.DUMP : this.oll();
            switch (nwg2.ordinal()) {
                case 2: {
                    class_2338 class_23383 = this.olp("сброс");
                    break;
                }
                case 3: {
                    class_2338 class_23383 = this.olp("еда");
                    break;
                }
                case 4: {
                    class_2338 class_23383 = this.olp("инвиз", "невидим");
                    break;
                }
                default: {
                    class_2338 class_23383 = class_23382 = this.olp("скорост");
                }
            }
            if (class_23382 == null) {
                this.oao = 10;
                if (nwg2 != nwg.DUMP && this.olp("сброс") != null) {
                    switch (nwg2.ordinal()) {
                        case 3: {
                            this.oah = true;
                            break;
                        }
                        case 4: {
                            this.oai = true;
                            break;
                        }
                        default: {
                            this.oaj = true;
                        }
                    }
                }
                PathHelper.resetKeys();
                this.oou();
                return;
            }
            this.oam = class_23382;
            this.oan = nwg2;
            this.ocw = this.nzd;
            this.oaq = 0;
            this.nzy = 0;
            this.oov();
            this.opc(class_23382, true);
            return;
        }
        if (!this.olo(this.oam)) {
            if (!this.opb()) {
                this.opc(this.oam, false);
            }
            if (this.opb()) {
                this.opq();
                return;
            }
        }
        this.ofb = null;
        PathHelper.resetKeys();
        class_243 class_2432 = this.onl(this.oam);
        if (class_2432 == null) {
            if (this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)this.oam)) > 16.0) {
                this.opc(this.oam, false);
            }
            class_2432 = class_243.method_24953((class_2382)this.oam);
        }
        this.ooq(this.oam, class_2432);
        this.ono(this.oam, this.oan, l);
        if (this.nzy > 6) {
            this.nzy = 0;
            this.oam = null;
            this.oao = 40;
            this.oln();
        }
    }

    private nwg oll() {
        for (nwg nwg2 : this.oak) {
            if (nwg2 == nwg.FOOD && !this.oah) {
                return nwg2;
            }
            if (nwg2 == nwg.INVIS && !this.oai) {
                return nwg2;
            }
            if (nwg2 != nwg.SPEED || this.oaj) continue;
            return nwg2;
        }
        return nwg.SPEED;
    }

    private void olm() {
        Collections.shuffle(this.oak, this.nzf);
        this.oal = 3;
        this.ocv = 4.0f + this.nzf.nextFloat() * 14.0f;
    }

    private void oln() {
        if (++this.oap < 3) {
            return;
        }
        this.oap = 0;
        switch (this.oan.ordinal()) {
            case 2: {
                this.oag = true;
                break;
            }
            case 3: {
                this.oah = true;
                break;
            }
            case 4: {
                this.oai = true;
                break;
            }
            case 5: {
                this.oaj = true;
                break;
            }
        }
    }

    private boolean olo(class_2338 class_23382) {
        return this.getPlayer().method_24828() && this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)class_23382)) <= 12.0 && this.onl(class_23382) != null;
    }

    private class_2338 olp(String ... stringArray) {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        return ChestFinder.find(this.mc, this.getPlayer().method_24515(), stringArray);
    }

    private boolean olq(class_2338 class_23382) {
        return this.getWorld() != null && this.getWorld().method_8320(class_23382).method_26204() instanceof class_2281;
    }

    private String olr() {
        String[] stringArray;
        String string = this.nyv.get();
        String[] stringArray2 = stringArray = string == null ? new String[]{} : string.trim().split("[,\\s]+");
        if (stringArray.length == 0 || stringArray[0].isEmpty()) {
            return "an239";
        }
        if (this.nze >= stringArray.length) {
            this.nze = 0;
        }
        return stringArray[this.nze];
    }

    private static String ols(String string, String string2) {
        String string3;
        String string4 = string3 = string == null ? "" : string.trim();
        while (string3.startsWith("/")) {
            string3 = string3.substring(1).trim();
        }
        return string3.isEmpty() ? string2 : string3;
    }

    private String olt() {
        if ("Warp".equals(this.nyw.get())) {
            String string = AutoWarden.ols(this.nyy.get(), "warden");
            if (string.toLowerCase().startsWith("warp ")) {
                string = string.substring(5).trim();
            }
            return "warp " + (string.isEmpty() ? "warden" : string);
        }
        return this.olu();
    }

    private String olu() {
        String string = AutoWarden.ols(this.nyx.get(), "warden");
        if (string.toLowerCase().startsWith("home ")) {
            string = string.substring(5).trim();
        }
        return "home " + (string.isEmpty() ? "warden" : string);
    }

    private void olv() {
        this.oas = 0;
        this.oau = false;
        this.oav = false;
        this.ocx = 0;
        this.oaw = null;
        this.oax = 0;
        this.oay = 0;
        this.oat = this.nzf.nextInt(25);
        this.ofb = null;
        this.ofc = 0;
        this.ohx();
        this.oab = null;
        this.oia();
        this.ocz = this.getWorld();
        this.oda = this.getPlayer();
        this.odb = this.getPlayer() == null ? null : this.getPlayer().method_73189();
        this.odc = -1;
        this.odd = false;
        this.oeb = false;
        this.oec = null;
        this.oed = null;
    }

    private String[] olw() {
        String[] stringArray;
        String[] stringArray2;
        String string = this.nyv.get();
        String[] stringArray3 = stringArray2 = string == null ? new String[]{} : string.trim().split("[,\\s]+");
        if (stringArray2.length == 0 || stringArray2[0].isEmpty()) {
            String[] stringArray4 = new String[1];
            stringArray = stringArray4;
            stringArray4[0] = "an239";
        } else {
            stringArray = stringArray2;
        }
        return stringArray;
    }

    private void olx() {
        PathHelper.resetKeys();
        String[] stringArray = this.olw();
        for (int i = 0; i < stringArray.length; ++i) {
            int n = (this.nze + i) % stringArray.length;
            if (!InstanceQueue.hasRoom(stringArray[n], this.ohu())) continue;
            this.nze = n;
            break;
        }
        String string = AutoWarden.ols(this.olr(), "an239");
        if (!InstanceQueue.enter(this.ohu(), string)) {
            this.oly("Все анки лута заняты - ждём очереди", false);
            return;
        }
        this.odf = "";
        this.getNetworkHandler().method_45730(string);
        this.olv();
        ++this.ogi;
        this.nzg = 0;
        this.nzi.clear();
        this.nzj.clear();
        this.nzk.clear();
        this.nzl.clear();
        this.ohy(nwx.WARPING_TO_LOOT_BASE);
    }

    private void oly(String string, boolean bl) {
        int n = InstanceQueue.position(this.ohu());
        this.odf = Lang.t(string) + (n > 0 ? Lang.s(" (#" + n + ")", " (" + n + "-й)") : "");
        if (this.nzd - this.ode > 600) {
            this.ode = this.nzd;
            this.notifyUser(this.odf, false);
        }
        if (bl) {
            this.oog();
        } else {
            PathHelper.resetKeys();
            this.oou();
        }
    }

    private void olz() {
        PathHelper.resetKeys();
        this.oot();
        this.omh();
        ++this.oas;
        if (!this.oau) {
            if (this.odc < 0) {
                if (this.omf() || this.oas >= 200) {
                    this.odc = this.oas;
                    this.oeb = this.omf();
                }
                return;
            }
            if (this.oas - this.odc < 30 + this.oat) {
                return;
            }
            if (this.omg() || this.omc()) {
                this.omb();
                return;
            }
            if (this.ocx >= 3) {
                this.oma();
                return;
            }
            this.omi(this.olt());
            return;
        }
        if (this.getWorld() != this.ocy && !this.oeb) {
            this.oeb = true;
            this.oau = false;
            this.odc = this.oas;
            this.oay = 0;
            this.oec = null;
            this.oed = null;
            return;
        }
        if (this.omo() > 0) {
            this.oay = 0;
            return;
        }
        if (!(this.omk() || this.omg() || this.omc())) {
            if (this.oas - this.oax < 200) {
                return;
            }
            if (this.ocx < 3) {
                this.omi(this.olt());
                return;
            }
            this.oma();
            return;
        }
        if (++this.oay >= 30) {
            this.omb();
        }
    }

    private void oma() {
        this.notifyUser("Не телепортировало в город - пробуем другую анку", false);
        this.omd(Lang.t("Не телепортировало в город - пробуем другую анку"));
        ++this.nze;
        this.ohy(nwx.TELEPORT_TO_SAVE);
    }

    private void omb() {
        class_2338 class_23382 = this.omc() ? this.odz.get(InstanceQueue.key(this.olr())) : null;
        this.nzh = class_23382 != null ? class_23382 : this.getPlayer().method_24515();
        this.oaa = 0;
        this.oay = 0;
        this.ohy(nwx.EXPLORING);
    }

    private boolean omc() {
        String string = InstanceQueue.key(this.olr());
        class_2338 class_23382 = this.odz.get(string);
        double d = 100.0;
        return class_23382 != null && this.oij().equals(this.oea.get(string)) && this.getPlayer().method_24515().method_10262((class_2382)class_23382) < d * d;
    }

    private void omd(String string) {
        ++this.odv;
        this.odw = string;
    }

    private boolean ome() {
        if (this.odv < 3) {
            return false;
        }
        if (!this.odx) {
            this.notifyUser(Lang.s("Stopped: " + this.odv + " trips in a row came back with nothing (" + this.odw + "). Check the potions, the warp / home and the anarchies, then turn it on again", "Остановлен: " + this.odv + " захода подряд впустую (" + this.odw + "). Проверь зелья, варп / хом и анархии и включи снова"), false);
            this.odx = true;
        }
        return true;
    }

    private boolean omf() {
        class_746 class_7462 = this.getPlayer();
        return this.odd || this.getWorld() != this.ocz || class_7462 != this.oda || this.odb != null && class_7462.method_73189().method_1022(this.odb) > 48.0;
    }

    private boolean omg() {
        class_746 class_7462 = this.getPlayer();
        if (class_7462 == null || this.getWorld() == null) {
            return false;
        }
        WardenTimers rzy2 = this.ohz();
        if (rzy2 != null) {
            String string = this.oij();
            class_243 class_2432 = class_7462.method_73189();
            for (rzv rzv2 : rzy2.getCachedTimers()) {
                if (rzv2.untimed || !string.equals(rzv2.dimension) || !(rzv2.pos.method_1025(class_2432) < 10000.0)) continue;
                return true;
            }
        }
        return this.omv(2).size() >= 4 && ChestFinder.find(this.mc, class_7462.method_24515(), 24, 8, "сброс") == null;
    }

    private void omh() {
        if (PathHelper.onClimbable((class_1657)this.getPlayer()) && this.mc.field_1690 != null) {
            this.mc.field_1690.field_1832.method_23481(true);
        }
    }

    private void omi(String string) {
        this.getNetworkHandler().method_45730(string);
        this.oau = true;
        ++this.ocx;
        this.oaw = this.getPlayer().method_24515();
        this.ocy = this.getWorld();
        this.oax = this.oas;
        this.oay = 0;
        if (this.oec == null) {
            this.oec = this.oaw;
            this.oed = this.ocy;
        }
    }

    private boolean omj() {
        return this.oaw != null && this.getPlayer().method_24515().method_10262((class_2382)this.oaw) > 9.0;
    }

    private boolean omk() {
        return this.oec != null && (this.getWorld() != this.oed || this.getPlayer().method_24515().method_10262((class_2382)this.oec) > 576.0);
    }

    private void oml(String string) {
        if (this.odu == null) {
            String string2 = this.odu = string == null ? "" : string;
            if (string != null) {
                this.notifyUser(string, true);
                if (this.nzg == 0 && ("Нет невидимости - на сейв".equals(string) || "Нет еды - на сейв".equals(string))) {
                    this.omd(Lang.t(string));
                }
            }
        }
        this.ohx();
        this.oab = null;
        this.oeu = null;
        this.ofb = null;
        this.ofc = 0;
        this.ohy(nwx.CHECK_PVP_COOLDOWN);
    }

    private void omm() {
        String string = AutoWarden.ols(this.nyu.get(), "an238");
        if (!InstanceQueue.enter(this.ohu(), string)) {
            this.oly("На сейве уже 3 наших - ждём очереди", this.nzh != null);
            return;
        }
        this.odf = "";
        PathHelper.resetKeys();
        this.getNetworkHandler().method_45730(string);
        this.olv();
        this.ohw();
        this.oam = null;
        this.oap = 0;
        this.oeu = null;
        this.ohy(nwx.WARPING_TO_SAVE_BASE);
    }

    private void omn() {
        PathHelper.resetKeys();
        this.oot();
        this.omh();
        ++this.oas;
        if (this.omo() > 0) {
            this.oay = 0;
            return;
        }
        if (this.oas < 60) {
            return;
        }
        if (!this.oau) {
            if (this.olp("сброс") != null) {
                this.ohy(nwx.RESTOCK);
                return;
            }
            if (this.oas < 80 + this.oat) {
                return;
            }
            this.omi(this.olu());
            return;
        }
        if (!this.omj() && this.oas - this.oax < 200) {
            return;
        }
        if (++this.oay >= 30) {
            this.ohy(nwx.RESTOCK);
        }
    }

    private int omo() {
        return TeleportTimer.teleportSeconds(this.mc, "Телепортация через:");
    }

    private boolean omp() {
        return TeleportTimer.contains(this.mc, "PvP-режим активен");
    }

    private void omq(long l) {
        if (this.nzh == null) {
            this.nzh = this.getPlayer().method_24515();
        }
        if (this.odu != null) {
            this.oml(null);
            return;
        }
        if (this.oql() < 2) {
            this.oml("Инвентарь полон - на сейв");
            return;
        }
        if ((double)this.nzg >= this.nyq.get()) {
            this.oml("Сундуки собраны - на сейв");
            return;
        }
        if (this.olb(true) < 100 && (this.oqg(true) == 0 || this.odt[0])) {
            this.oml("Нет невидимости - на сейв");
            return;
        }
        if (this.getPlayer().method_7344().method_7586() < 8 && this.oqh(class_1802.field_8071) == 0) {
            this.oml("Нет еды - на сейв");
            return;
        }
        if (this.oaa <= 0) {
            this.oaa = 5;
            nwq nwq2 = this.omw(l);
            if (nwq2 != null) {
                this.omr(nwq2);
                this.ohy(nwx.WAITING_FOR_CHEST);
                return;
            }
        }
        this.oms(l);
    }

    private void omr(nwq nwq2) {
        this.ohx();
        this.nzt = nwq2.timer();
        this.nzu = nwq2.chest();
        this.nzv = nwq2.tier();
        this.oab = null;
        this.ofb = null;
        this.ofc = 0;
        this.oaq = 0;
        this.oov();
    }

    private void oms(long l) {
        if (this.oab != null) {
            double d = this.getPlayer().method_24515().method_10262((class_2382)this.oab);
            if (!this.olq(this.oab) || d <= 144.0) {
                this.omt();
                this.oab = null;
                this.ofb = null;
            }
        }
        if (this.oab == null && this.oac <= 0) {
            this.oac = 20;
            this.omu(l);
        }
        if (this.oab != null) {
            if (!this.opb() && !this.opc(this.oab, false) && this.ofd <= 0) {
                this.nzl.put(this.oab, l + 60000L);
                this.oab = null;
            }
            if (this.opb()) {
                this.opq();
            } else {
                PathHelper.resetKeys();
                this.oot();
            }
            return;
        }
        this.opi();
    }

    private void omt() {
        class_2338 class_23382 = this.getPlayer().method_24515();
        for (class_2338 class_23383 : this.omv(1)) {
            if (!(class_23383.method_10262((class_2382)class_23382) <= 196.0)) continue;
            this.nzk.add(class_23383);
        }
    }

    private void omu(long l) {
        List<class_2338> list;
        class_2338 class_23382 = this.getPlayer().method_24515();
        this.omt();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (class_2338 class_23385 : this.omv(4)) {
            if (this.nzk.contains(class_23385) || (list = this.nzl.get(class_23385)) != null && (Long)((Object)list) > l || this.nzh != null && class_23385.method_10262((class_2382)this.nzh) > 14400.0 || this.ont(class_23385, 7.0)) continue;
            arrayList.add(class_23385);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.sort((class_23383, class_23384) -> Double.compare(class_23383.method_10262((class_2382)class_23382), class_23384.method_10262((class_2382)class_23382)));
        for (int i = 0; i < Math.min(2, arrayList.size()); ++i) {
            class_2338 class_23385;
            class_23385 = (class_2338)arrayList.get(i);
            list = this.opd(class_23385);
            if (list != null && !list.isEmpty()) {
                this.oab = class_23385;
                this.opf(list);
                return;
            }
            this.nzl.put(class_23385, l + 60000L);
        }
    }

    private List<class_2338> omv(int n) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        if (this.mc.field_1687 == null) {
            return arrayList;
        }
        class_2338 class_23382 = this.getPlayer().method_24515();
        int n2 = class_23382.method_10263() >> 4;
        int n3 = class_23382.method_10260() >> 4;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                class_2818 class_28182 = this.mc.field_1687.method_2935().method_12126(n2 + i, n3 + j, false);
                if (class_28182 == null) continue;
                for (class_2586 class_25862 : class_28182.method_12214().values()) {
                    if (!(class_25862 instanceof class_2595) || Math.abs(class_25862.method_11016().method_10264() - class_23382.method_10264()) > 16) continue;
                    arrayList.add(class_25862.method_11016());
                }
            }
        }
        return arrayList;
    }

    private nwq omw(long l) {
        WardenTimers rzy2 = this.ohz();
        if (rzy2 == null) {
            return null;
        }
        String string = this.oij();
        class_243 class_2432 = this.getPlayer().method_33571();
        nwq nwq2 = null;
        for (rzv rzv2 : rzy2.getCachedTimers()) {
            int n;
            Long l2;
            Long l3;
            class_2338 class_23382;
            if (!string.equals(rzv2.dimension) || (class_23382 = this.onc(rzv2)) == null || (l3 = this.nzj.get(class_23382)) != null && l3 > l || (l2 = this.nzi.get(class_23382)) != null && rzv2.lastNumericUpdate <= l2 + 1500L || this.nzh != null && class_23382.method_10262((class_2382)this.nzh) > 14400.0) continue;
            long l4 = AutoWarden.omx(rzv2, l);
            boolean bl = l4 <= 0L;
            double d = class_2432.method_1025(class_243.method_24953((class_2382)class_23382));
            if (bl && d <= 25.0) {
                n = 0;
            } else if (!bl && l4 <= 5000L && d <= 144.0) {
                n = 1;
            } else if (bl && d <= 144.0) {
                n = 2;
            } else if (!bl && l4 <= 15000L && d <= 625.0) {
                n = 3;
            } else if (bl) {
                n = 4;
            } else {
                if (l4 > 30000L) continue;
                n = 5;
            }
            if (this.ont(class_23382, 7.0) || this.onv(class_23382)) continue;
            double d2 = (double)class_23382.method_10264() + 0.5 - class_2432.field_1351;
            double d3 = (double)class_23382.method_10263() + 0.5 - this.getPlayer().method_23317();
            double d4 = (double)class_23382.method_10260() + 0.5 - this.getPlayer().method_23321();
            double d5 = d3 * d3 + d4 * d4 + (d2 > 0.0 ? 2.0 : 1.0) * d2 * d2;
            if (nwq2 != null && n >= nwq2.tier() && (n != nwq2.tier() || !(d5 < nwq2.score()))) continue;
            nwq2 = new nwq(rzv2, class_23382, n, d5);
        }
        if (nwq2 != null && this.onj(nwq2.chest()) == null) {
            this.nzj.put(nwq2.chest(), l + 20000L);
            return null;
        }
        return nwq2;
    }

    private static long omx(rzv rzv2, long l) {
        return rzv2.isReady ? -1L : rzv2.expirationTime - l;
    }

    private void omy(long l) {
        class_2338 class_23383;
        WardenTimers rzy2 = this.ohz();
        if (rzy2 == null || this.nzn == 0L || l - this.nzn < 3000L) {
            return;
        }
        String string = this.oij();
        HashSet<class_2338> hashSet = new HashSet<class_2338>();
        for (rzv rzv3 : rzy2.getCachedTimers()) {
            class_2338 class_23384;
            if (rzv3.untimed || !string.equals(rzv3.dimension) || (class_23384 = this.onc(rzv3)) == null) continue;
            hashSet.add(class_23384);
            class_23383 = this.ona(class_23384);
            if (class_23383 == null) continue;
            hashSet.add(class_23383);
        }
        rzy2.getCachedTimers().removeIf(rzv2 -> {
            if (!rzv2.untimed || !string.equals(rzv2.dimension)) {
                return false;
            }
            class_2338 class_23382 = this.onc((rzv)rzv2);
            return class_23382 == null || hashSet.contains(class_23382);
        });
        class_243 class_2432 = this.getPlayer().method_33571();
        double d = 196.0;
        class_23383 = new HashSet();
        for (class_2338 class_23385 : this.omv(1)) {
            long l2;
            class_2338 class_23386;
            if (class_2432.method_1025(class_243.method_24953((class_2382)class_23385)) > d || hashSet.contains(class_23385) || !class_23383.add(class_23386 = this.onb(class_23385)) || l - (l2 = this.nzm.computeIfAbsent(class_23386, class_23382 -> l).longValue()) < 250L || this.omz(class_23386, l) || this.nzh != null && class_23386.method_10262((class_2382)this.nzh) > 14400.0) continue;
            rzy2.markUntimedReady(class_23386, string);
        }
        this.nzm.keySet().retainAll((Collection<?>)class_23383);
    }

    private boolean omz(class_2338 class_23382, long l) {
        Long l2 = this.nzi.get(class_23382);
        if (l2 != null && l - l2 < 600000L) {
            return true;
        }
        class_2338 class_23383 = this.ona(class_23382);
        Long l3 = class_23383 == null ? null : this.nzi.get(class_23383);
        return l3 != null && l - l3 < 600000L;
    }

    private class_2338 ona(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return null;
        }
        class_2680 class_26802 = this.getWorld().method_8320(class_23382);
        if (!(class_26802.method_26204() instanceof class_2281) || class_26802.method_11654((class_2769)class_2281.field_10770) == class_2745.field_12569) {
            return null;
        }
        class_2338 class_23383 = class_23382.method_10093(class_2281.method_9758((class_2680)class_26802));
        return this.olq(class_23383) ? class_23383 : null;
    }

    private class_2338 onb(class_2338 class_23382) {
        class_2338 class_23383 = this.ona(class_23382);
        if (class_23383 == null) {
            return class_23382;
        }
        return class_23383.method_10063() < class_23382.method_10063() ? class_23383 : class_23382;
    }

    private class_2338 onc(rzv rzv2) {
        class_2338 class_23382 = class_2338.method_49637((double)rzv2.pos.field_1352, (double)rzv2.pos.field_1351, (double)rzv2.pos.field_1350);
        for (int i = 0; i >= -3; --i) {
            if (this.olq(class_23382.method_10069(0, i, 0))) {
                return class_23382.method_10069(0, i, 0);
            }
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    class_2338 class_23383 = class_23382.method_10069(j, i, k);
                    if (!this.olq(class_23383)) continue;
                    return class_23383;
                }
            }
        }
        return null;
    }

    private boolean ond(long l) {
        return this.nzb == nwx.WAITING_FOR_CHEST && this.nzt != null && AutoWarden.omx(this.nzt, l) < 3500L && this.nzw != null && this.oni();
    }

    private void one(long l) {
        nwq nwq2;
        WardenTimers rzy2 = this.ohz();
        rzv rzv2 = this.nzt;
        class_2338 class_23382 = this.nzu;
        if (rzv2 == null || class_23382 == null || rzy2 == null || !rzy2.getCachedTimers().contains(rzv2) || !this.olq(class_23382)) {
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        long l2 = AutoWarden.omx(rzv2, l);
        if (l2 > 31000L) {
            this.nzi.put(class_23382, l);
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        if (this.ont(class_23382, 7.0) || this.onv(class_23382)) {
            this.nzj.put(class_23382, l + 20000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        if (this.oaa <= 0 && l2 > 4000L) {
            this.oaa = 10;
            nwq2 = this.omw(l);
            if (nwq2 != null && !nwq2.chest().equals((Object)class_23382) && nwq2.tier() < this.nzv) {
                this.omr(nwq2);
                return;
            }
        }
        if (this.nzw == null || !this.onk(this.nzw)) {
            this.nzw = this.onj(class_23382);
            this.ofb = null;
            if (this.nzw == null) {
                this.nzj.put(class_23382, l + 20000L);
                this.ohx();
                this.ohy(nwx.EXPLORING);
                return;
            }
        }
        if (!this.oni()) {
            this.ong(class_23382, l);
            return;
        }
        this.nzx = 0;
        this.ofb = null;
        this.ofc = 0;
        PathHelper.resetKeys();
        nwq2 = this.onl(class_23382);
        if (nwq2 == null) {
            this.nzw = null;
            return;
        }
        boolean bl = this.onf(rzv2, l2, l);
        if (!bl && l2 > 2500L) {
            if (!this.onh()) {
                this.oop((class_243)nwq2);
            }
            return;
        }
        this.oad = 0;
        if (this.oli(this.getPlayer().method_6047())) {
            this.olj();
        }
        this.ooq(class_23382, (class_243)nwq2);
        if (!bl) {
            return;
        }
        this.ono(class_23382, nwg.LOOT, l);
        if (this.nzy > 4) {
            this.nzj.put(class_23382, l + (rzv2.untimed ? 180000L : 25000L));
            this.ohx();
            this.ohy(nwx.EXPLORING);
        }
    }

    private boolean onf(rzv rzv2, long l, long l2) {
        if (l > 1000L) {
            return false;
        }
        if (!rzv2.countdownShown(l2)) {
            return true;
        }
        return rzv2.zeroShownMs(l2) > 10000L;
    }

    private void ong(class_2338 class_23382, long l) {
        boolean bl;
        if (++this.nzx > this.oid(400)) {
            this.nzj.put(class_23382, l + 30000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        class_243 class_2432 = new class_243((double)this.nzw.method_10263() + 0.5, PathHelper.getStandY(this.nzw), (double)this.nzw.method_10260() + 0.5);
        double d = Math.hypot(class_2432.field_1352 - this.getPlayer().method_23317(), class_2432.field_1350 - this.getPlayer().method_23321());
        double d2 = class_2432.field_1351 - this.getPlayer().method_23318();
        boolean bl2 = d < 5.0 && d2 > -1.6 && d2 < 1.2 && (Math.abs(d2) < 0.6 ? this.opt(class_2432) : this.opu(class_2432)) ? true : (bl = false);
        if (bl) {
            this.ofb = null;
            this.opo(class_2432, true);
            if (d < 2.0) {
                this.mc.field_1690.field_1867.method_23481(false);
            }
            return;
        }
        if (!this.opb()) {
            this.opc(this.nzw, false);
        }
        if (this.opb()) {
            class_243 class_2433 = this.onl(class_23382);
            double d3 = this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)class_23382));
            if (!this.ohb && class_2433 != null && d3 <= 25.0 && this.opt(class_2432)) {
                this.ohb = true;
            }
            if (this.ohb && class_2433 != null) {
                this.oha = class_2433;
            }
            this.opq();
        } else {
            PathHelper.resetKeys();
            this.oot();
        }
    }

    private boolean onh() {
        if (this.oad > 0) {
            --this.oad;
            if (this.oaf != null) {
                this.oop(this.oaf);
            }
            return true;
        }
        if (this.oae > 0) {
            --this.oae;
            return false;
        }
        this.oae = 60 + this.nzf.nextInt(80);
        this.oad = 10 + this.nzf.nextInt(16);
        double d = Math.toRadians((double)this.ogv + 90.0 + (this.nzf.nextDouble() - 0.5) * 140.0);
        double d2 = 6.0 + this.nzf.nextDouble() * 8.0;
        class_243 class_2432 = this.getPlayer().method_33571();
        this.oaf = new class_243(class_2432.field_1352 + Math.cos(d) * d2, class_2432.field_1351 + (this.nzf.nextDouble() - 0.6) * 3.0, class_2432.field_1350 + Math.sin(d) * d2);
        return true;
    }

    private boolean oni() {
        if (this.nzw == null) {
            return false;
        }
        double d = this.getPlayer().method_23317() - ((double)this.nzw.method_10263() + 0.5);
        double d2 = this.getPlayer().method_23321() - ((double)this.nzw.method_10260() + 0.5);
        double d3 = this.getPlayer().method_23318() - PathHelper.getStandY(this.nzw);
        double d4 = d * d + d2 * d2;
        if (!this.getPlayer().method_24828() || Math.abs(d3) > 0.6) {
            return false;
        }
        if (d4 < 0.36) {
            return true;
        }
        return d4 < 2.25 && this.nzu != null && this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)this.nzu)) <= 15.0 && this.onl(this.nzu) != null;
    }

    private class_2338 onj(class_2338 class_23382) {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        double d = this.getPlayer().method_18381(class_4050.field_18076);
        class_243 class_2432 = class_243.method_24953((class_2382)class_23382);
        class_243 class_2433 = this.getPlayer().method_73189();
        class_2338 class_23383 = null;
        double d2 = Double.MAX_VALUE;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -2; k <= 2; ++k) {
                    class_2338 class_23384;
                    if (j == 0 && k == 0 && i != 1 || !this.onk(class_23384 = class_23382.method_10069(j, i, k)) || this.ont(class_23384, 7.0)) continue;
                    double d3 = PathHelper.getStandY(class_23384);
                    class_243 class_2434 = new class_243((double)class_23384.method_10263() + 0.5, d3 + d, (double)class_23384.method_10260() + 0.5);
                    if (class_2434.method_1025(class_2432) > 12.9 || this.onm(class_2434, class_23382) == null) continue;
                    double d4 = Math.max(Math.abs(j), Math.abs(k));
                    double d5 = Math.sqrt(class_2433.method_1025(class_243.method_24955((class_2382)class_23384))) + (d4 > 1.0 ? 1.2 : 0.0) + (i != 0 ? 0.8 : 0.0) + (j == 0 && k == 0 ? 1.5 : 0.0);
                    if (!(d5 < d2)) continue;
                    d2 = d5;
                    class_23383 = class_23384;
                }
            }
        }
        return class_23383;
    }

    private boolean onk(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return false;
        }
        return this.getWorld().method_8320(class_23382).method_26220((class_1922)this.getWorld(), class_23382).method_1110() && this.getWorld().method_8320(class_23382.method_10084()).method_26220((class_1922)this.getWorld(), class_23382.method_10084()).method_1110() && !this.getWorld().method_8320(class_23382.method_10074()).method_26220((class_1922)this.getWorld(), class_23382.method_10074()).method_1110();
    }

    private class_243 onl(class_2338 class_23382) {
        return this.onm(this.getPlayer().method_33571(), class_23382);
    }

    private class_243 onm(class_243 class_2432, class_2338 class_23382) {
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382).method_1031(0.0, -0.06, 0.0);
        class_243 class_2434 = class_2433.method_1031(this.ohf, this.ohg * 0.6, this.ohh);
        if (this.onn(class_2432, class_2434, class_23382)) {
            return class_2434;
        }
        class_243 class_2435 = null;
        double d = Double.MAX_VALUE;
        for (double d2 = -0.3; d2 <= 0.31; d2 += 0.3) {
            for (double d3 = -0.3; d3 <= 0.31; d3 += 0.3) {
                for (double d4 = -0.3; d4 <= 0.31; d4 += 0.3) {
                    class_243 class_2436 = class_2433.method_1031(d2, d3, d4);
                    double d5 = class_2436.method_1025(class_2433);
                    if (!(d5 < d) || !this.onn(class_2432, class_2436, class_23382)) continue;
                    d = d5;
                    class_2435 = class_2436;
                }
            }
        }
        return class_2435;
    }

    private boolean onn(class_243 class_2432, class_243 class_2433, class_2338 class_23382) {
        class_3965 class_39652 = this.getWorld().method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
        return class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382);
    }

    private void ono(class_2338 class_23382, nwg nwg2, long l) {
        class_3965 class_39652;
        if (this.mc.field_1755 != null) {
            return;
        }
        this.ohk = true;
        this.ohl = this.nzd;
        class_3965 class_39653 = this.opa(class_23382);
        this.oos(class_39653 != null);
        boolean bl = false;
        if (class_39653 != null) {
            this.oaq = 0;
            if (this.ohe > 0) {
                --this.ohe;
            } else if (l - this.oar > this.nzz) {
                bl = true;
            }
        } else if (++this.oaq > 40 && l - this.oar > this.nzz && this.getPlayer().method_33571().method_1025(class_243.method_24953((class_2382)class_23382)) < 16.0 && (class_39652 = this.onq(class_23382)) != null) {
            SilentRotation.later(() -> {
                if (this.mc.field_1761 != null && this.mc.field_1724 != null && this.mc.field_1755 == null) {
                    this.mc.field_1761.method_2896(this.mc.field_1724, class_1268.field_5808, class_39652);
                    this.mc.field_1724.method_6104(class_1268.field_5808);
                }
            });
            this.onp(class_23382, nwg2, l);
        }
        if (bl) {
            this.onp(class_23382, nwg2, l);
        }
        this.mc.field_1690.field_1904.method_23481(bl);
        this.mc.field_1690.field_1832.method_23481(false);
    }

    private void onp(class_2338 class_23382, nwg nwg2, long l) {
        this.oar = l;
        this.nzz = 550L + (long)this.nzf.nextInt(450);
        ++this.nzy;
        this.ojg(class_23382, nwg2, l);
    }

    private class_3965 onq(class_2338 class_23382) {
        class_243 class_2432 = this.getPlayer().method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        class_3965 class_39652 = this.getWorld().method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
        if (class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382)) {
            return class_39652;
        }
        if (this.oaq <= 80) {
            return null;
        }
        class_2350 class_23502 = class_2350.method_10142((double)(class_2432.field_1352 - class_2433.field_1352), (double)(class_2432.field_1351 - class_2433.field_1351), (double)(class_2432.field_1350 - class_2433.field_1350));
        class_243 class_2434 = class_2433.method_1031((double)class_23502.method_10148() * 0.5, (double)class_23502.method_10164() * 0.5, (double)class_23502.method_10165() * 0.5);
        return new class_3965(class_2434, class_23502, class_23382, false);
    }

    private void onr() {
        if (this.mc.field_1687 == null) {
            return;
        }
        boolean bl = false;
        for (class_1297 class_12972 : this.mc.field_1687.method_18112()) {
            class_7260 class_72602;
            if (!(class_12972 instanceof class_7260) || !(class_72602 = (class_7260)class_12972).method_5805() || this.nzp.put(class_72602.method_24515(), this.nzd + 100) != null) continue;
            bl = true;
        }
        if (this.nzp.values().removeIf(n -> n < this.nzd)) {
            bl = true;
        }
        if (this.nzp.size() > 256) {
            this.nzp.clear();
            bl = true;
        }
        if (bl) {
            this.nzq = new ArrayList<class_2338>(this.nzp.keySet());
        }
    }

    private List<class_2338> ons() {
        return this.nzq;
    }

    private boolean ont(class_2338 class_23382, double d) {
        double d2 = d * d;
        for (class_2338 class_23383 : this.nzp.keySet()) {
            if (!(class_23383.method_10262((class_2382)class_23382) < d2)) continue;
            return true;
        }
        return false;
    }

    private class_7260 onu(double d) {
        if (this.mc.field_1687 == null) {
            return null;
        }
        class_7260 class_72602 = null;
        double d2 = d * d;
        for (class_1297 class_12972 : this.mc.field_1687.method_18112()) {
            double d3;
            class_7260 class_72603;
            if (!(class_12972 instanceof class_7260) || !(class_72603 = (class_7260)class_12972).method_5805() || !((d3 = class_72603.method_5858((class_1297)this.getPlayer())) < d2)) continue;
            d2 = d3;
            class_72602 = class_72603;
        }
        return class_72602;
    }

    private boolean onv(class_2338 class_23382) {
        class_243 class_2432 = class_243.method_24953((class_2382)class_23382);
        for (class_1657 class_16572 : this.mc.field_1687.method_18456()) {
            if (class_16572 == this.getPlayer() || class_16572.method_5707(class_2432) >= 20.0 || !AutoWarden.onw(class_16572.method_6118(class_1304.field_6169)) && !AutoWarden.onw(class_16572.method_6118(class_1304.field_6174)) && !AutoWarden.onw(class_16572.method_6118(class_1304.field_6172)) && !AutoWarden.onw(class_16572.method_6118(class_1304.field_6166))) continue;
            return true;
        }
        return false;
    }

    private static boolean onw(class_1799 class_17992) {
        return !class_17992.method_7960() && (class_17992.method_31573(class_3489.field_48297) || class_17992.method_31573(class_3489.field_48296) || class_17992.method_31573(class_3489.field_48295) || class_17992.method_31573(class_3489.field_48294));
    }

    private boolean onx() {
        boolean bl = System.currentTimeMillis() - this.nzr < 5000L;
        class_1657 class_16572 = this.mc.field_1687.method_18112().iterator();
        while (class_16572.hasNext()) {
            double d;
            class_7260 class_72602;
            class_1297 class_12972 = (class_1297)class_16572.next();
            if (!(class_12972 instanceof class_7260) || !(class_72602 = (class_7260)class_12972).method_5805() || !((d = class_72602.method_5858((class_1297)this.getPlayer())) < 36.0) && (!bl || !(d < 900.0) || !this.ony(class_72602) || !(d < 64.0) && !this.onz(class_72602))) continue;
            this.ooa(true);
            return true;
        }
        if (this.getPlayer().method_6059(class_1294.field_5912) && (class_16572 = this.ooh()) != null && class_16572.method_5858((class_1297)this.getPlayer()) < 576.0) {
            this.ooa(false);
            return true;
        }
        return false;
    }

    private boolean ony(class_7260 class_72602) {
        double d = Math.toDegrees(Math.atan2(-(this.getPlayer().method_23317() - class_72602.method_23317()), this.getPlayer().method_23321() - class_72602.method_23321()));
        return Math.abs(class_3532.method_15338((double)((double)class_72602.method_73188() - d))) < 30.0;
    }

    private boolean onz(class_7260 class_72602) {
        return (this.getPlayer().method_23317() - class_72602.method_23317()) * (class_72602.method_23317() - class_72602.field_6014) + (this.getPlayer().method_23321() - class_72602.method_23321()) * (class_72602.method_23321() - class_72602.field_5969) > 0.01;
    }

    private void ooa(boolean bl) {
        if (this.nzb == nwx.ESCAPING) {
            return;
        }
        this.oex = bl;
        this.oev = 0;
        this.oew = 0;
        this.oey = 0;
        this.ofb = null;
        this.ofc = 0;
        this.ofd = 0;
        this.olh();
        this.ohx();
        this.oab = null;
        this.ohy(nwx.ESCAPING);
    }

    private void oob() {
        boolean bl;
        double d;
        ++this.oev;
        this.mc.field_1690.field_1886.method_23481(false);
        this.olh();
        class_1657 class_16572 = this.oex ? this.onu(48.0) : this.ooh();
        double d2 = class_16572 != null ? class_16572.method_5858((class_1297)this.getPlayer()) : Double.MAX_VALUE;
        double d3 = d = this.oex ? 576.0 : 1600.0;
        if (this.oev > 30 && d2 > d || this.oev > 240) {
            PathHelper.resetKeys();
            this.ofb = null;
            boolean bl2 = this.odu != null || (double)this.nzg >= this.nyq.get() || this.oql() < 2;
            this.ohy(bl2 ? nwx.CHECK_PVP_COOLDOWN : nwx.EXPLORING);
            this.oaa = 0;
            return;
        }
        boolean bl3 = bl = !this.opb() || this.oev % 25 == 0;
        if (class_16572 != null && bl && this.ofd <= 0) {
            this.ofd = 10;
            this.ood(class_16572.method_73189());
        }
        if (this.opb()) {
            this.opq();
        } else if (class_16572 != null) {
            class_243 class_2432 = AutoWarden.ooc(this.getPlayer().method_73189().method_1020(class_16572.method_73189()).method_1029(), Math.toRadians(nyh[this.oew]));
            class_243 class_2433 = this.getPlayer().method_73189().method_1019(class_2432.method_1021(12.0));
            this.opn(new class_243(class_2433.field_1352, this.getPlayer().method_23318(), class_2433.field_1350));
        } else {
            this.oot();
            this.ohq = true;
            this.mc.field_1690.field_1894.method_23481(true);
            WalkDriver.setSprint(this.mc.field_1690, true);
        }
    }

    private static class_243 ooc(class_243 class_2432, double d) {
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        return new class_243(class_2432.field_1352 * d2 - class_2432.field_1350 * d3, 0.0, class_2432.field_1352 * d3 + class_2432.field_1350 * d2).method_1029();
    }

    private void ood(class_243 class_2432) {
        class_243 class_2433 = this.getPlayer().method_73189().method_1020(class_2432).method_1029();
        class_2338 class_23382 = this.getPlayer().method_24515();
        for (int i = 0; i < 2; ++i) {
            int n = (this.oew + i) % nyh.length;
            double d = (double)nyh[n] + this.nzf.nextGaussian() * 12.0;
            class_243 class_2434 = AutoWarden.ooc(class_2433, Math.toRadians(d));
            double d2 = 22.0 + this.nzf.nextDouble() * 12.0;
            class_2338 class_23383 = this.ooe(this.oph(class_23382.method_10069((int)(class_2434.field_1352 * d2), 0, (int)(class_2434.field_1350 * d2))));
            List<class_2338> list = this.opd(class_23383);
            if (list == null || list.size() < 5) continue;
            this.opf(list);
            this.oew = n;
            return;
        }
        this.oew = (this.oew + 3) % nyh.length;
        this.ofb = null;
        this.ofc = 0;
    }

    private class_2338 ooe(class_2338 class_23382) {
        double d;
        double d2;
        if (this.nzh == null) {
            return class_23382;
        }
        double d3 = class_23382.method_10263() - this.nzh.method_10263();
        double d4 = Math.hypot(d3, d2 = (double)(class_23382.method_10260() - this.nzh.method_10260()));
        if (d4 <= (d = 100.0)) {
            return class_23382;
        }
        double d5 = d / d4;
        return this.oph(new class_2338(this.nzh.method_10263() + (int)(d3 * d5), class_23382.method_10264(), this.nzh.method_10260() + (int)(d2 * d5)));
    }

    private void oof() {
        if (this.nzd - this.oek > 60) {
            ++this.nze;
            this.oeu = null;
            this.ohy(nwx.TELEPORT_TO_SAVE);
            return;
        }
        this.oog();
    }

    private void oog() {
        class_1657 class_16572 = this.ooh();
        class_2338 class_23382 = this.getPlayer().method_24515();
        if (this.ofd <= 0) {
            if (class_16572 != null && (this.oeu == null || this.oeu.method_10262((class_2382)class_23382) < 10.0 || class_16572.method_5858((class_1297)this.getPlayer()) < 400.0)) {
                class_243 class_2432 = AutoWarden.ooc(this.getPlayer().method_73189().method_1020(class_16572.method_73189()).method_1029(), Math.toRadians(this.nzf.nextGaussian() * 20.0));
                double d = 24.0 + this.nzf.nextDouble() * 14.0;
                this.oeu = this.ooe(this.oph(class_23382.method_10069((int)(class_2432.field_1352 * d), 0, (int)(class_2432.field_1350 * d))));
                this.ofd = 10;
                this.opf(this.opd(this.oeu));
            } else if (!(class_16572 != null || this.oeu != null && !(this.oeu.method_10262((class_2382)class_23382) < 4.0) || this.oeu != null && this.nzf.nextInt(120) != 0)) {
                double d = this.nzf.nextDouble() * Math.PI * 2.0;
                double d2 = 12.0 + this.nzf.nextDouble() * 14.0;
                this.oeu = this.ooe(this.oph(class_23382.method_10069((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2))));
                this.ofd = 10;
                this.opf(this.opd(this.oeu));
            }
        }
        if (this.opb()) {
            this.opq();
        } else {
            PathHelper.resetKeys();
            this.oot();
        }
    }

    private class_1657 ooh() {
        class_1657 class_16572 = null;
        double d = 2500.0;
        for (class_1657 class_16573 : this.mc.field_1687.method_18456()) {
            double d2;
            if (class_16573 == this.getPlayer() || !((d2 = class_16573.method_5858((class_1297)this.getPlayer())) < d)) continue;
            d = d2;
            class_16572 = class_16573;
        }
        return class_16572;
    }

    private void ooi() {
        this.ogx = this.getPlayer();
        if (this.ogx != null) {
            this.ool(this.ogx);
            this.ogl.reset(this.ogx.method_36454(), this.ogx.method_36455());
            this.ogv = this.ogx.method_36454();
            this.ogw = this.ogx.method_36455();
            this.ogy = this.ogx.method_73189();
        }
        this.ogn = false;
        this.ogo = false;
        this.ohn = false;
        this.oho = false;
        this.ohp = false;
        this.nzn = System.currentTimeMillis();
    }

    private void ooj() {
        SilentRotation.clear();
        if (this.ogn) {
            this.ogn = false;
            if (this.driver == null && this.ogm.ownedBy(this)) {
                this.ogm.release(this.mc.field_1724);
            }
        }
    }

    private void ook() {
        boolean bl;
        class_746 class_7462 = this.getPlayer();
        if (class_7462 == null) {
            return;
        }
        boolean bl2 = bl = this.ogx != class_7462 || this.ogy == null || class_7462.method_73189().method_1025(this.ogy) > 400.0;
        if (bl) {
            this.nzn = System.currentTimeMillis();
            this.nzm.clear();
            if (this.driver == null) {
                this.ogm.reset();
            }
            if (this.ogx != class_7462) {
                this.ool((class_1657)class_7462);
            }
            this.ogl.reset(class_7462.method_36454(), class_7462.method_36455());
            this.ogv = class_7462.method_36454();
            this.ogw = class_7462.method_36455();
            this.ogx = class_7462;
            this.ogn = false;
            this.ofb = null;
            this.ofc = 0;
            this.off = null;
            this.ofe.reset();
        }
        this.ogy = class_7462.method_73189();
    }

    private void ool(class_1657 class_16572) {
        String string = class_16572.method_7334() != null ? class_16572.method_7334().name() : null;
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        this.ogl.personalize(l);
        this.ofe.personalize(l);
    }

    private void oom(float f, float f2) {
        this.oon(f, f2, false);
    }

    private void oon(float f, float f2, boolean bl) {
        this.ogs = f;
        this.ogt = f2;
        this.ogq = bl;
        this.ogr = false;
        this.ogu = 0.0;
        this.ogo = true;
        this.ogp = false;
    }

    private void ooo(class_243 class_2432) {
        float[] fArray = RotationUtil.calculateAngle(class_2432);
        this.oon(fArray[0], fArray[1], false);
    }

    private void oop(class_243 class_2432) {
        float[] fArray = RotationUtil.calculateAngle(class_2432);
        this.oon(fArray[0], fArray[1], true);
    }

    private void ooq(class_2338 class_23382, class_243 class_2432) {
        this.ooo(class_2432);
        this.ogu = this.ohc ? 0.25 : this.oor(class_23382, class_2432);
    }

    private double oor(class_2338 class_23382, class_243 class_2432) {
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

    private void oos(boolean bl) {
        if (bl || this.ogl.isMoving()) {
            this.ohd = 0;
            return;
        }
        if (++this.ohd >= 3) {
            this.ohc = true;
        }
    }

    private void oot() {
        if (!this.ogo) {
            this.ogp = true;
        }
    }

    private void oou() {
        float f = this.ogl.intentPitch();
        if (Math.abs(f - this.ocv) > 6.0f) {
            this.oon(this.ogl.intentYaw(), this.ocv, true);
        } else {
            this.oot();
        }
    }

    private void oov() {
        this.ohb = false;
        this.ohc = false;
        this.ohd = 0;
        this.ohf = (this.nzf.nextDouble() - 0.5) * 0.3;
        this.ohg = (this.nzf.nextDouble() - 0.5) * 0.36;
        this.ohh = (this.nzf.nextDouble() - 0.5) * 0.3;
        this.ohe = 1 + this.nzf.nextInt(4);
    }

    private float oow() {
        return (float)this.ofe.moveYaw(this.ogv);
    }

    private void oox() {
        if (this.getPlayer() == null) {
            return;
        }
        this.ofk = this.ogo && !this.ogq;
        boolean bl = this.ofe.takeTurn(this.ofl);
        if (this.oib() && !this.ofk) {
            this.ooy();
            return;
        }
        if (this.mc.field_1755 == null) {
            this.ogl.setMouseStep(this.driver != null ? this.driver.mouseStep() : MouseQuantizer.step());
            if (this.obw || this.ocf) {
                this.ogl.freeze();
            } else if (this.ogo) {
                if (this.ogq && this.ogr) {
                    this.ogl.aimTight(this.ogs, this.ogt);
                } else if (this.ogq) {
                    this.ogl.aimRelaxed(this.ogs, this.ogt);
                } else {
                    this.ogl.aim(this.ogs, this.ogt, this.ogu);
                }
            } else if (bl) {
                this.ogl.turn(this.ofl[0], this.ofl[1]);
            } else if (this.ogp) {
                this.ogl.hold();
            } else {
                this.ogl.idle();
            }
            this.ogv = this.ogl.getYaw();
            this.ogw = this.ogl.getPitch();
        }
        this.ogo = false;
        this.ogp = false;
        if (this.driver != null) {
            if (this.mc.field_1755 == null) {
                this.driver.look(this.ogv, class_3532.method_15363((float)this.ogw, (float)-90.0f, (float)90.0f));
            }
        } else {
            this.ogm.set(this, this.ogv, class_3532.method_15363((float)this.ogw, (float)-90.0f, (float)90.0f));
        }
        this.ogn = true;
        if (this.mc.field_1755 != null) {
            SilentRotation.clear();
        } else if (this.ogz != null) {
            SilentRotation.aimAt(this.ogz, this.ogv, this.ogw);
        }
        this.ogz = null;
    }

    private void ooy() {
        this.ogo = false;
        this.ogp = false;
        class_746 class_7462 = this.getPlayer();
        this.ogl.reset(class_7462.method_36454(), class_7462.method_36455());
        this.ogv = class_7462.method_36454();
        this.ogw = class_7462.method_36455();
        if (this.ogn) {
            this.ogn = false;
            if (this.ogm.ownedBy(this)) {
                this.ogm.release(this.mc.field_1724);
            }
        }
        if (this.mc.field_1755 != null) {
            SilentRotation.clear();
        } else if (this.ogz != null) {
            SilentRotation.aimAt(this.ogz, this.ogv, this.ogw);
        }
        this.ogz = null;
    }

    private class_3965 ooz() {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        class_243 class_2432 = this.getPlayer().method_33571();
        class_243 class_2433 = class_243.method_1030((float)this.ogw, (float)this.ogv);
        double d = 4.5;
        class_243 class_2434 = class_2432.method_1031(class_2433.field_1352 * d, class_2433.field_1351 * d, class_2433.field_1350 * d);
        return this.getWorld().method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)this.getPlayer()));
    }

    private class_3965 opa(class_2338 class_23382) {
        class_3965 class_39652 = this.ooz();
        if (class_39652 != null && class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382)) {
            this.ogz = class_23382;
            return class_39652;
        }
        return null;
    }

    private boolean opb() {
        return this.ofb != null && this.ofc < this.ofb.size();
    }

    private boolean opc(class_2338 class_23382, boolean bl) {
        if (class_23382 == null) {
            return false;
        }
        if (!bl && this.ofd > 0) {
            return this.opb();
        }
        this.ofd = 8;
        this.opf(this.opd(class_23382));
        return this.ofb != null && !this.ofb.isEmpty();
    }

    private List<class_2338> opd(class_2338 class_23382) {
        this.ofq = class_23382;
        this.ofr = this.ope();
        if (this.ofg == null || !class_23382.equals((Object)this.ofh)) {
            this.ofg = pqq.random(this.nzf);
            this.ofh = class_23382;
        }
        return PathFinder.findPath((class_1922)this.getWorld(), (class_1297)this.getPlayer(), this.ofr, class_23382, this.ons(), 7.0, true, this.oix(), this.ofg);
    }

    private class_2338 ope() {
        class_746 class_7462 = this.getPlayer();
        class_2338 class_23382 = class_2338.method_49637((double)class_7462.method_23317(), (double)(class_7462.method_23318() + 0.001), (double)class_7462.method_23321());
        if (!this.opz(class_23382)) {
            class_23382 = class_23382.method_10084();
        }
        if (!class_7462.method_24828() && !class_7462.method_5799()) {
            class_2338.class_2339 class_23392 = class_23382.method_25503();
            for (int i = 0; i < 6 && this.opz(class_23392.method_10074()); ++i) {
                class_23392.method_10098(class_2350.field_11033);
            }
            return class_23392.method_10062();
        }
        return class_23382;
    }

    private void opf(List<class_2338> list) {
        this.ofb = list;
        this.ofc = 0;
        this.ofw = 0;
        this.ofx = 0;
        this.off = null;
        if (list != null && !list.isEmpty()) {
            prz prz2 = new prz();
            prz2.danger = this.ons();
            prz2.radius = 7.0;
            prz2.avoid = this.oix();
            this.off = this.ofe.plan((class_1937)this.getWorld(), (class_1657)this.getPlayer(), list, this.ofq, prz2);
        }
        if (this.off == null) {
            this.ofb = null;
        }
    }

    private void opg() {
        this.ofq = null;
        this.ofr = null;
        this.oft = null;
        this.ofu = null;
        this.ofv = 0;
        this.ofw = 0;
        this.ofx = 0;
        this.ofy = 0;
        this.ofz = false;
        this.oga = 0;
        this.ogc = 0;
        this.ogd = null;
        this.oge = true;
        this.ogf = Double.NaN;
    }

    private class_2338 oph(class_2338 class_23382) {
        if (this.getWorld() == null) {
            return class_23382;
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        block0: for (int i = 0; i <= 10; ++i) {
            for (int j = 1; j >= -1; j -= 2) {
                class_23392.method_10103(class_23382.method_10263(), class_23382.method_10264() + i * j, class_23382.method_10260());
                if (this.onk((class_2338)class_23392)) {
                    return class_23392.method_10062();
                }
                if (i == 0) continue block0;
            }
        }
        return class_23382;
    }

    private void opi() {
        if (this.opb() && this.off != null && this.ofd <= 0 && !this.oib() && this.ofe.remaining(this.off) < 3.5) {
            this.ofd = 8;
            this.opj();
        }
        if (!this.opb()) {
            if (this.ofd > 0) {
                PathHelper.resetKeys();
                this.oot();
                return;
            }
            this.ofd = 8;
            this.opj();
        }
        if (this.opb()) {
            this.opq();
        } else {
            PathHelper.resetKeys();
            this.oot();
        }
    }

    private void opj() {
        class_2338 class_23382 = this.getPlayer().method_24515();
        this.opl(class_23382);
        if (Double.isNaN(this.ofm)) {
            this.ofm = Math.toRadians((double)this.oow() + 90.0);
        }
        if (this.nzh != null && class_23382.method_10262((class_2382)this.nzh) > 4900.0) {
            this.ofm = Math.atan2(this.nzh.method_10260() - class_23382.method_10260(), this.nzh.method_10263() - class_23382.method_10263());
        }
        double[] dArray = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
        int n = 0;
        for (int i = 0; i < dArray.length && n < 2; ++i) {
            double d = this.ofm + dArray[(i + this.ofo) % dArray.length] + this.nzf.nextGaussian() * 0.28;
            double d2 = 14.0 + this.nzf.nextDouble() * 16.0;
            class_2338 class_23383 = class_23382.method_10069((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2));
            if (this.opm(class_23383) && this.ofn < 2) continue;
            ++n;
            List<class_2338> list = this.opd(this.ooe(this.oph(class_23383)));
            if (list == null || list.size() < 5) continue;
            this.ofm = d;
            this.ofn = 0;
            this.ofo = 0;
            this.opf(list);
            return;
        }
        ++this.ofn;
        this.ofo = (this.ofo + 2) % dArray.length;
        this.ofm += 1.5707963267948966 + this.nzf.nextDouble() * Math.PI;
        this.opf(null);
    }

    private static long opk(class_2338 class_23382) {
        return (long)(class_23382.method_10263() >> 4) << 32 ^ (long)(class_23382.method_10260() >> 4) & 0xFFFFFFFFL;
    }

    private void opl(class_2338 class_23382) {
        if (this.ofp.size() > 512) {
            this.ofp.clear();
        }
        this.ofp.add(AutoWarden.opk(class_23382));
    }

    private boolean opm(class_2338 class_23382) {
        return this.ofp.contains(AutoWarden.opk(class_23382));
    }

    private void opn(class_243 class_2432) {
        this.opo(class_2432, false);
    }

    private void opo(class_243 class_2432, boolean bl) {
        int n = this.ofe.walkTo(this.mc, (class_1657)this.getPlayer(), (class_1937)this.getWorld(), class_2432, this.ogv, this.ogw, null, this.nzb == nwx.ESCAPING, this.oib(), this.oie());
        if (n != 0 && !this.oib()) {
            PathHelper.resetKeys();
        }
        this.ohq = true;
        this.ofa = true;
    }

    private double opp(class_2338 class_23382) {
        double d = this.getPlayer().method_23317() - ((double)class_23382.method_10263() + 0.5);
        double d2 = this.getPlayer().method_23321() - ((double)class_23382.method_10260() + 0.5);
        return d * d + d2 * d2;
    }

    private void opq() {
        Object object;
        if (!this.opb()) {
            return;
        }
        if (!this.oib() && this.ops()) {
            PathHelper.resetKeys();
            this.oot();
            return;
        }
        if (this.off == null) {
            object = new prz();
            object.danger = this.ons();
            object.radius = 7.0;
            object.avoid = this.oix();
            this.off = this.ofe.plan((class_1937)this.getWorld(), (class_1657)this.getPlayer(), this.ofb, this.ofq, (prz)object);
            if (this.off == null) {
                this.ofb = null;
                this.ofc = 0;
                return;
            }
        }
        object = this.oha;
        this.oha = null;
        int n = this.ofe.follow(this.mc, (class_1657)this.getPlayer(), (class_1937)this.getWorld(), this.off, this.ogv, this.ogw, (class_243)object, this.nzb == nwx.ESCAPING, this.oib(), this.oie());
        if (n == 2) {
            List<class_2338> list;
            List<class_2338> list2 = list = this.ofq != null ? this.opd(this.ofq) : null;
            if (list == null || list.isEmpty()) {
                this.ofb = null;
                this.ofc = 0;
                this.off = null;
                this.ofd = 0;
                if (!this.oib()) {
                    PathHelper.resetKeys();
                }
                return;
            }
            this.opf(list);
            return;
        }
        if (n == 1) {
            this.ofc = this.ofb.size();
            this.off = null;
            if (!this.oib()) {
                PathHelper.resetKeys();
            }
            return;
        }
        this.ofc = Math.min(this.ofb.size() - 1, this.off.nodeIndex(this.ofe.stride.at()));
        if (this.ofc > this.ofw) {
            this.ofy += this.ofc - this.ofw;
            this.ofw = this.ofc;
            this.ofx = 0;
            if (this.ofy >= 10) {
                this.oet = 0;
                this.oft = null;
            }
        } else if (!this.oib() && this.ofz && ++this.ofx > 90) {
            this.ofx = 0;
            this.oiv(false);
            PathHelper.resetKeys();
            return;
        }
        this.ohq = true;
        this.ofa = true;
    }

    private double opr() {
        class_746 class_7462 = this.getPlayer();
        return class_7462.method_24828() || Double.isNaN(this.ogf) ? class_7462.method_23318() : this.ogf;
    }

    private boolean ops() {
        if (this.ohi > 0) {
            --this.ohi;
            return true;
        }
        if (this.ohj > 0) {
            --this.ohj;
            return false;
        }
        if (this.nzb != nwx.EXPLORING || this.oab != null) {
            return false;
        }
        this.ohj = 2400 + this.nzf.nextInt(4200);
        this.ohi = 8 + this.nzf.nextInt(26);
        return true;
    }

    private boolean opt(class_243 class_2432) {
        return this.opv(class_2432, true);
    }

    private boolean opu(class_243 class_2432) {
        return this.opv(class_2432, false);
    }

    private boolean opv(class_243 class_2432, boolean bl) {
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
        double d4 = this.opw();
        int n = (int)Math.ceil(d3 / 0.45);
        for (int i = 1; i <= n; ++i) {
            double d5 = (double)i / (double)n;
            double d6 = class_2433.field_1352 + d * d5;
            double d7 = class_2433.field_1350 + d2 * d5;
            if (!this.opx(d6, d7, d4)) {
                return false;
            }
            if (!bl || !this.opz(class_2338.method_49637((double)d6, (double)(d4 - 0.2), (double)d7))) continue;
            return false;
        }
        return true;
    }

    private double opw() {
        double d = this.opr();
        if (!this.opb()) {
            return d;
        }
        double d2 = PathHelper.getStandY(this.ofb.get(this.ofc));
        double d3 = d2 - d;
        return d3 > 0.0 && d3 <= 0.6 ? d2 : d;
    }

    private boolean opx(double d, double d2, double d3) {
        return this.opy(new class_238(d - 0.31, d3 + 0.6, d2 - 0.31, d + 0.31, d3 + 1.8, d2 + 0.31));
    }

    private boolean opy(class_238 class_2383) {
        for (class_265 class_2652 : this.getWorld().method_20812((class_1297)this.getPlayer(), class_2383)) {
            if (class_2652.method_1110()) continue;
            return false;
        }
        return true;
    }

    private boolean opz(class_2338 class_23382) {
        return this.getWorld().method_8320(class_23382).method_26220((class_1922)this.getWorld(), class_23382).method_1110();
    }

    private boolean oqa(class_1799 class_17992) {
        if (class_17992.method_7960() || class_17992.method_31574(class_1802.field_8469)) {
            return true;
        }
        if (this.oqf(class_17992, true) || this.nyt.get() && this.oqf(class_17992, false)) {
            return false;
        }
        return !this.oht(class_17992);
    }

    private boolean oqb(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return false;
        }
        if (class_17992.method_31574(class_1802.field_8469)) {
            return true;
        }
        return !this.oqd(class_17992) && AutoWarden.oqc(class_17992) && !this.oht(class_17992);
    }

    private static boolean oqc(class_1799 class_17992) {
        class_1792 class_17922 = class_17992.method_7909();
        return class_17922 instanceof class_1821 || class_17922 instanceof class_1743 || class_17922 instanceof class_1746 || class_17922 instanceof class_8052 && !class_17992.method_31574(class_1802.field_41946) || class_17992.method_31574(class_1802.field_8894) || class_17992.method_31574(class_1802.field_8598) || class_17992.method_31574(class_1802.field_8547) || class_17992.method_31574(class_1802.field_8448) || class_17992.method_31574(class_1802.field_37523) || class_17992.method_31574(class_1802.field_28101) || class_17992.method_31574(class_1802.field_8466) || class_17992.method_31574(class_1802.field_38418) || class_17992.method_31574(class_1802.field_8323) || class_17992.method_31574(class_1802.field_20417) || class_17992.method_31574(class_1802.field_8711) || class_17992.method_31574(class_1802.field_8782) || class_17992.method_31574(class_1802.field_8261);
    }

    private boolean oqd(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return true;
        }
        if (class_17992.method_31574(class_1802.field_8071) || class_17992.method_31574(class_1802.field_8288) || class_17992.method_31574(class_1802.field_49814)) {
            return true;
        }
        if (this.oqf(class_17992, true) || this.oqf(class_17992, false)) {
            return true;
        }
        return class_17992.method_7909().method_7876().contains("_sword");
    }

    private boolean oqe(class_1799 class_17992) {
        if (this.oqf(class_17992, true) || this.oqf(class_17992, false)) {
            return true;
        }
        if (class_17992.method_31574(class_1802.field_8071)) {
            return this.oqh(class_1802.field_8071) <= this.oal;
        }
        return this.oqd(class_17992) && !this.oht(class_17992);
    }

    private boolean oqf(class_1799 class_17992, boolean bl) {
        if (class_17992.method_7960()) {
            return false;
        }
        if (!(class_17992.method_31574(class_1802.field_8574) || class_17992.method_31574(class_1802.field_8436) || class_17992.method_31574(class_1802.field_8150))) {
            return false;
        }
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 != null) {
            int n = 0;
            boolean bl2 = false;
            for (class_1293 class_12932 : class_18442.method_57397()) {
                ++n;
                if (class_12932.method_5579() != (bl ? class_1294.field_5905 : class_1294.field_5904)) continue;
                bl2 = true;
            }
            if (n > 0) {
                return n == 1 && bl2;
            }
        }
        String string = class_17992.method_7964().getString().toLowerCase();
        return bl ? string.contains("невидим") : string.contains("скорост") || string.contains("speed");
    }

    private int oqg(boolean bl) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(i);
            if (!this.oqf(class_17992, bl)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int oqh(class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(i);
            if (!class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int oqi(Predicate<class_1799> predicate) {
        for (int i = 0; i < 9; ++i) {
            if (!predicate.test(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private int oqj(Predicate<class_1799> predicate) {
        for (int i = 9; i < 36; ++i) {
            if (!predicate.test(this.getPlayer().method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private int oqk() {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            if (!this.oqb(this.getPlayer().method_31548().method_5438(i))) continue;
            ++n;
        }
        return n;
    }

    private int oql() {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = this.getPlayer().method_31548().method_5438(i);
            if (!class_17992.method_7960() && !this.oqb(class_17992)) continue;
            ++n;
        }
        return n;
    }

    private static /* synthetic */ int bec(int n, int n2) {
        return n - n2 ^ 0x972C128B;
    }

    private static /* synthetic */ int bed(int n, int n2) {
        return AutoWarden.bec(n, n2) * n2;
    }
}

