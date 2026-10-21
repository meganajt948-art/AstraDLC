/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3489
 *  net.minecraft.class_418
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.BotHost;
import a.ProfilePopup;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.lex;
import a.AutoMine;
import a.nes;
import a.ney;
import a.nff;
import a.nfi;
import a.EnchantNameUtil;
import a.InstanceQueue;
import a.LobbyWatcher;
import a.Box3;
import a.pzp;
import a.TimerTextParser;
import a.BuyerSeller;
import a.qdw;
import a.AutoMineController;
import a.AutoEat;
import a.TrackingError;
import a.qoc;
import a.MineTools;
import a.InventoryCounter;
import a.qqd;
import a.qqg;
import a.qqm;
import a.qqp;
import a.HopTimings;
import a.qsq;
import a.StorageRun;
import a.MineRarity;
import a.DiamondEsp;
import a.AimModel;
import a.AimBrain;
import a.TurnRateLimiter;
import a.MineModelReader;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.Setting;
import a.TextSetting;
import a.PacketHooks;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3489;
import net.minecraft.class_418;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoMines
extends Module {
    private static final int nfm = 0;
    private static final double nfn = 72.0;
    private static final double nfo = 36.0;
    private static final double nfp = 30.0;
    private static final double nfq = 6.0;
    private static final int nfr = 3;
    private static final long nfs = 600000L;
    private static final Pattern nft;
    private static final Pattern nfu;
    private static final String nfv;
    private static final String nfw;
    private static final String nfx;
    private static final long nfy = 30000L;
    private static final long nfz = 7000L;
    private static final long nga = 25000L;
    private static final long ngb = 150000L;
    private static final String ngc;
    private static final String ngd;
    private static final String nge;
    private static final String ngf;
    private static final int ngg = 190;
    private static final int ngh = 576;
    private static final float ngi = 3.0f;
    private static final int ngj = 576;
    private static final int ngk = 20;
    private static final long ngl = 60000L;
    private static final long ngm = 20000L;
    private static final Set<String> ngn;
    private final TextSetting ngo = this.add(new TextSetting("Анка склада", "", 16));
    private final BoolSetting ngp = this.add(new BoolSetting("Обычные шахты", true));
    private final BoolSetting ngq = this.add(new BoolSetting("Мифические шахты", true));
    private final BoolSetting ngr = this.add(new BoolSetting("Легендарные шахты", true));
    private final BoolSetting ngs = this.add(new BoolSetting("Предикт ломания", true));
    private final ButtonSetting ngt = this.add(new ButtonSetting("Нейро-копание", new vkq("Записать и обучить", Icon.LAYERS, ProfilePopup::openMine)));
    private static AutoMines ngu;
    private static boolean ngv;
    private BotHost ngw;
    private final HopTimings ngx = new HopTimings();
    private final qqd ngy = new qqd();
    private final AutoMineController ngz = new AutoMineController();
    private final MineTools nha = new MineTools();
    private final AimBrain nhb = new AimBrain();
    private final TrackingError nhc = new TrackingError();
    private final StorageRun nhd = new StorageRun();
    private final BuyerSeller nhe = new BuyerSeller();
    private final AutoEat nhf = new AutoEat();
    private final Map<Integer, Box3> nhg = new HashMap<Integer, Box3>();
    private final Map<Integer, class_243> nhh = new HashMap<Integer, class_243>();
    private final Set<Integer> nhi = new HashSet<Integer>();
    private final Map<String, Long> nhj = new HashMap<String, Long>();
    private final LobbyWatcher nhk = new LobbyWatcher();
    private final Map<Integer, Long> nhl = new HashMap<Integer, Long>();
    private final Map<Integer, Long> nhm = new HashMap<Integer, Long>();
    private boolean nhn;
    private boolean nho;
    private nff nhp = nff.START;
    private long nhq;
    private int nhr = -1;
    private int nhs = -1;
    private boolean nht;
    private class_746 nhu;
    private int nhv = -1;
    private long nhw;
    private boolean nhx;
    private class_638 nhy;
    private class_746 nhz;
    private class_243 nia;
    private boolean nib;
    private boolean nic;
    private int nid;
    private long nie;
    private long nif;
    private int nig;
    private class_243 nih;
    private class_638 nii;
    private class_746 nij;
    private long nik;
    private boolean nil;
    private long nim;
    private int nin;
    private long nio;
    private boolean nip;
    private String niq = "";
    private long nir;
    private int nis = -1;
    private boolean nit;
    private boolean niu;
    private long niv;
    private int niw = -1;
    private long nix;
    private MineRarity niy;
    private MineRarity niz;
    private long nja;
    private int njb;
    private boolean njc;
    private int njd;
    private boolean nje;
    private boolean njf;
    private boolean njg;
    private boolean njh;
    private long nji;
    private long njj;
    private String njk;
    private long njl;
    private long njm;
    private class_243 njn;
    private Object njo;
    private long njp;
    private String njq = "";
    private int njr;
    private static /* synthetic */ boolean njs;
    private static /* synthetic */ long njt;

    public AutoMines() {
        super("AutoMine", "Clears the anarchy auto-mines by itself", ModuleCategory.PLAYER);
        if (ngu == null) {
            ngu = this;
        }
        this.ngz.target(AutoMines::nkc);
        this.ngz.junk(class_17992 -> MineTools.isJunkStack(class_17992, ngn));
        this.ngz.onSit(this::nkd);
        this.nhd.walker().junk(class_17992 -> MineTools.isJunkStack(class_17992, ngn));
        this.nhd.notes(string -> this.nma((String)string, Icon.INFO));
        this.nhk.notes(string -> this.nma((String)string, Icon.NAV));
        if (!ngv) {
            ngv = true;
            PacketHooks.listen(AutoMines::nju);
        }
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    private static void nju(class_2596<?> class_25962) {
        AutoMines nfl2 = ngu;
        if (nfl2 != null && nfl2.ngw == null && nfl2.isEnabled()) {
            nfl2.ngz.echo(class_25962);
        }
    }

    public void onPacket(class_2596<?> class_25962) {
        if (this.isEnabled()) {
            this.ngz.echo(class_25962);
        }
    }

    public static boolean busy() {
        AutoMines nfl2 = ngu;
        return nfl2 != null && nfl2.isEnabled() && nfl2.nhp != nff.START;
    }

    public void attachBot(BotHost efz2) {
        this.ngw = efz2;
        this.nhb.tickOnly();
    }

    public boolean isBotInstance() {
        return this.ngw != null;
    }

    public void copySettingsFrom(AutoMines nfl2) {
        if (nfl2 == null || nfl2 == this) {
            return;
        }
        List<Setting> list = nfl2.getSettings();
        List<Setting> list2 = this.getSettings();
        for (int i = 0; i < Math.min(list.size(), list2.size()); ++i) {
            Setting vmo2 = list.get(i);
            Setting vmo3 = list2.get(i);
            if (vmo2 instanceof BoolSetting) {
                BoolSetting vkl2 = (BoolSetting)vmo2;
                if (vmo3 instanceof BoolSetting) {
                    BoolSetting vkl3 = (BoolSetting)vmo3;
                    vkl3.set(vkl2.get());
                    continue;
                }
            }
            if (!(vmo2 instanceof TextSetting)) continue;
            TextSetting vmu2 = (TextSetting)vmo2;
            if (!(vmo3 instanceof TextSetting)) continue;
            TextSetting vmu3 = (TextSetting)vmo3;
            vmu3.set(vmu2.get());
        }
    }

    private void njv() {
        Flow flow = Flow.getInstance();
        if (flow == null || flow.getModuleManager() == null) {
            return;
        }
        AutoMines nfl2 = flow.getModuleManager().get(AutoMines.class);
        if (nfl2 == null || nfl2 == this || nfl2.isBotInstance()) {
            return;
        }
        Set set = Collections.newSetFromMap(new IdentityHashMap());
        set.addAll(List.of(this.botSettings()));
        List<Setting> list = nfl2.getSettings();
        List<Setting> list2 = this.getSettings();
        for (int i = 0; i < Math.min(list.size(), list2.size()); ++i) {
            Setting vmo2 = list.get(i);
            Setting vmo3 = list2.get(i);
            if (set.contains(vmo3)) continue;
            if (vmo2 instanceof BoolSetting) {
                BoolSetting vkl2 = (BoolSetting)vmo2;
                if (vmo3 instanceof BoolSetting) {
                    BoolSetting vkl3 = (BoolSetting)vmo3;
                    if (vkl2.get() != vkl3.get()) {
                        vkl3.set(vkl2.get());
                        continue;
                    }
                }
            }
            if (!(vmo2 instanceof TextSetting)) continue;
            TextSetting vmu2 = (TextSetting)vmo2;
            if (!(vmo3 instanceof TextSetting)) continue;
            TextSetting vmu3 = (TextSetting)vmo3;
            if (vmu2.get().equals(vmu3.get())) continue;
            vmu3.set(vmu2.get());
        }
    }

    public Setting[] botSettings() {
        return new Setting[]{this.ngo, this.ngp, this.ngq, this.ngr, this.ngs};
    }

    public int mined() {
        return this.ngz.mined();
    }

    public String lastNote() {
        return this.njq;
    }

    public static String hudStatus() {
        AutoMines nfl2 = ngu;
        return nfl2 == null ? null : nfl2.status();
    }

    public static List<ney> hudRows() {
        AutoMines nfl2 = ngu;
        ArrayList<ney> arrayList = new ArrayList<ney>();
        if (nfl2 == null || !nfl2.isEnabled()) {
            return arrayList;
        }
        long l = System.currentTimeMillis();
        for (qqm qqm2 : nfl2.ngx.entries()) {
            if (qqm2.tier == null || qqm2.refreshAt <= l - 2000L) continue;
            boolean bl = qqm2.id == nfl2.nhs || qqm2.id == nfl2.nhr && (nfl2.nhp == nff.WAIT || nfl2.nhp == nff.MINE);
            arrayList.add(new ney(qqm2.id, qqm2.tier, qqm2.refreshAt, bl));
        }
        arrayList.sort((ney2, ney3) -> Long.compare(ney2.refreshAt(), ney3.refreshAt()));
        return arrayList.size() > 8 ? new ArrayList<ney>(arrayList.subList(0, 8)) : arrayList;
    }

    public String status() {
        AutoMines nfl2 = this;
        if (!nfl2.isEnabled()) {
            return null;
        }
        long l = System.currentTimeMillis();
        if (nfl2.nhk.active()) {
            return nfl2.nhk.status();
        }
        if (nfl2.nhe.active()) {
            return "Включаю авто-скупку";
        }
        if (nfl2.nhf.active()) {
            return "Ем";
        }
        return switch (nfl2.nhp.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 1 -> "Выбираю шахту";
            case 2 -> "Захожу на " + nfl2.nhv + (nfl2.nid > 0 ? " (повтор " + nfl2.nid + ")" : "");
            case 3 -> "Смотрю табличку на " + nfl2.nhr;
            case 4 -> {
                if (nfl2.nim > 0L) {
                    yield "Смотрю табличку";
                }
                if (nfl2.nik > l) {
                    yield "Варп на шахту · " + (nfl2.nik - l + 999L) / 1000L + " с";
                }
                yield "Варп на шахту";
            }
            case 5 -> {
                qqm var4_3 = nfl2.ngx.entry(nfl2.nhr);
                String var5_4 = !nfl2.njf ? "Жду " : (nfl2.ngz.parked() ? (nfl2.mc.field_1724 != null && nfl2.mc.field_1724.method_5765() ? "Сижу на ступеньках, жду " : "У ступенек, жду ") : "Иду к ступенькам, жду ");
                yield var5_4 + (nfl2.niy == null ? "шахту" : nfl2.niy.title()) + (var4_3 == null ? "" : " · " + AutoMines.clock(var4_3.refreshAt - l));
            }
            case 6 -> "Шахта обновилась";
            case 7 -> "Копаю " + (nfl2.niz == null ? "шахту" : nfl2.niz.title()) + " · " + nfl2.ngz.mined() + " алм." + (nfl2.ngz.hasBrain() ? " · нейро" + nfl2.njw() : "");
            case 8 -> "Жду";
            case 9 -> {
                switch (nfl2.nin) {
                    case -1: {
                        yield "На склад (" + nfl2.niq + ") · на " + nfl2.nln() + " уже " + 3 + " наших, жду очереди (" + Math.max(1, InstanceQueue.position(nfl2.nmb())) + "-й)";
                    }
                    case 0: {
                        yield "На склад (" + nfl2.niq + ") · захожу на " + nfl2.nln();
                    }
                    case 1: {
                        if (nfl2.nik > l) {
                            yield "Телепорт на склад · " + (nfl2.nik - l + 999L) / 1000L + " с";
                        }
                        yield "Телепорт на склад";
                    }
                }
                yield nfl2.nhd.status();
            }
        };
    }

    private String njw() {
        double d;
        TurnRateLimiter toq2 = this.ngz.brain();
        double d2 = d = toq2 == null ? Double.NaN : toq2.ratio();
        if (Double.isNaN(d)) {
            return "";
        }
        long l = Math.round((d - 1.0) * 100.0);
        return " " + (l >= 0L ? "+" : "") + l + "% к тебе";
    }

    public static TurnRateLimiter neuroBrain() {
        AutoMines nfl2 = ngu;
        return nfl2 == null || !nfl2.isEnabled() ? null : nfl2.ngz.brain();
    }

    public String debug() {
        return (Object)((Object)this.nhp) + " here=" + this.nhr + " mined=" + this.ngz.mined() + " thrown=" + this.nha.thrown() + " reverts=" + this.ngz.reverts() + " predict=[" + this.ngz.predicted() + "] hop=" + this.ngx.hopMs() + " warp=" + this.ngx.warpMs() + (this.ngz.area() == null ? "" : " area=" + this.ngz.area()) + " " + this.ngz.dozer() + " [" + this.ngz.sweepStats() + "]";
    }

    public String action() {
        return this.ngz.action() + String.format(Locale.ROOT, " plan=%.1f", this.nhb.lastPlan());
    }

    public static void onMessage(class_2561 class_25612) {
        AutoMines nfl2 = ngu;
        if (nfl2 != null) {
            nfl2.onChat(class_25612);
        }
    }

    public void onChat(class_2561 class_25612) {
        boolean bl;
        AutoMines nfl2 = this;
        if (!nfl2.isEnabled() || class_25612 == null) {
            return;
        }
        nfl2.nhk.onChat(class_25612);
        String string = EnchantNameUtil.title(class_25612.getString());
        boolean bl2 = nfl2.nhp == nff.HOP || nfl2.nhp == nff.BASE && nfl2.nin == 0;
        boolean bl3 = bl = nfl2.nhp == nff.WARP || nfl2.nhp == nff.BASE && nfl2.nin == 1;
        if (bl2) {
            if (string.contains("уже") && (string.contains("сервер") || string.contains("подключ") || string.contains("находит")) || string.contains("already connected")) {
                nfl2.nib = true;
            } else if (string.contains("недоступ") || string.contains("не удалось подключ") || string.contains("not available") || string.contains("переполнен")) {
                nfl2.nic = true;
            }
        }
        if (bl) {
            Matcher matcher;
            if (string.contains("отменен") || string.contains("отменён")) {
                nfl2.nil = true;
            } else if (string.contains("через") && (string.contains("перемещ") || string.contains("телепорт")) && (matcher = nft.matcher(string)).find()) {
                nfl2.nik = System.currentTimeMillis() + (long)Integer.parseInt(matcher.group(1)) * 1000L + 300L;
            }
        }
    }

    private boolean njx() {
        Boolean bl = nfi.solo;
        return bl == null || bl == false;
    }

    private static String njy() {
        String string = nfi.anarchies;
        return string != null ? string : "103-112, 203-234, 302-323, 501-514, 901-904";
    }

    private static long njz() {
        Long l = nfi.minMineMs;
        return l != null ? l : 25000L;
    }

    private static long nka() {
        Long l = nfi.maxMineMs;
        return l != null ? l : 150000L;
    }

    private Set<MineRarity> nkb() {
        EnumSet<MineRarity> enumSet = EnumSet.noneOf(MineRarity.class);
        if (this.ngp.get()) {
            enumSet.add(MineRarity.COMMON);
        }
        if (this.ngq.get()) {
            enumSet.add(MineRarity.MYTHIC);
        }
        if (this.ngr.get()) {
            enumSet.add(MineRarity.LEGENDARY);
        }
        return enumSet.isEmpty() ? EnumSet.allOf(MineRarity.class) : enumSet;
    }

    private static boolean nkc(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10442) || class_26802.method_27852(class_2246.field_29029);
    }

    private void nkd() {
        if (this.mc.method_1562() != null) {
            this.mc.method_1562().method_45730("sit");
        }
    }

    @Override
    protected void onEnable() {
        this.ngx.clear();
        this.nhr = -1;
        this.nhs = -1;
        this.nht = false;
        this.niw = -1;
        this.nje = false;
        this.njp = 0L;
        this.njq = "";
        this.nhi.clear();
        this.nhj.clear();
        this.nhl.clear();
        this.nhm.clear();
        this.nhk.reset(this.nmb());
        this.nhn = false;
        this.nir = 0L;
        this.niu = false;
        this.nhd.forget();
        this.ngz.resetCounters();
        this.nhc.reset();
        this.nhb.reset();
        this.nhb.forgetFrame();
        class_746 class_7462 = this.mc.field_1724;
        this.nit = class_7462 != null && InventoryCounter.ready(class_7462.method_31548()) && InventoryCounter.misplaced(class_7462.method_31548(), InventoryCounter.targets(class_7462.method_31548(), class_7462.method_6079())) == 0;
        this.nly(nff.START);
    }

    @Override
    protected void onDisable() {
        this.ngz.stop(this.mc);
        this.nhd.stop(this.mc);
        this.nhe.cancel(this.mc);
        this.nhf.stop(this.mc, this.mc.field_1724);
        this.nha.cancel(this.mc);
        this.nhb.reset();
        this.nhb.forgetFrame();
        if (this.ngw == null) {
            DiamondEsp.clear();
        }
        this.nhk.reset(this.nmb());
        InstanceQueue.cancel(this.nmb());
        this.nhp = nff.START;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.nhb.newTick();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        if (this.nhn) {
            this.ngz.releaseKeys(class_3102);
            this.nhd.walker().releaseKeys(class_3102);
            return;
        }
        if (this.nha.busy()) {
            this.ngz.releaseKeys(class_3102);
            this.nhd.walker().releaseKeys(class_3102);
            this.nha.startTick(class_3102);
            return;
        }
        if (this.nhf.active()) {
            this.ngz.releaseKeys(class_3102);
            this.nhd.walker().releaseKeys(class_3102);
            this.nhf.startTick(class_3102);
            return;
        }
        if (this.njg) {
            this.nhd.walker().releaseKeys(class_3102);
            this.ngz.startTick(class_3102, class_7462);
            return;
        }
        if (this.nhp == nff.BASE) {
            this.ngz.releaseKeys(class_3102);
            if (this.nin == 2) {
                this.nhd.startTick(class_3102, class_7462);
            } else {
                this.nhd.walker().releaseKeys(class_3102);
            }
            return;
        }
        if (this.nhe.active() || !this.nkg()) {
            this.ngz.releaseKeys(class_3102);
            return;
        }
        this.ngz.startTick(class_3102, class_7462);
    }

    private void nke(class_310 class_3102, class_746 class_7462, long l) {
        boolean bl;
        boolean bl2 = bl = class_7462.method_5805() && (this.nhp != nff.BASE || this.nin != 2) && !this.nkg() && AutoMineController.trapped((class_1937)class_3102.field_1687, class_7462) != null;
        if (!bl) {
            if (this.njg) {
                this.njg = false;
                if (!this.nkg()) {
                    this.ngz.stop(class_3102);
                }
            }
            return;
        }
        if (this.nhf.active()) {
            this.nhf.stop(class_3102, class_7462);
        }
        if (!this.njg) {
            this.njg = true;
            this.nji = l;
            this.nma("Застрял в блоках — выкапываюсь", Icon.ALERT);
        }
        if (this.ngz.status() != qdw.WORKING || !this.ngz.guarding()) {
            this.ngz.guard(Box3.empty(class_7462.method_24515()));
        }
    }

    private boolean nkf(class_310 class_3102, class_746 class_7462, long l) {
        if (this.nhk.tick(class_3102, class_7462, this.nmb(), this.ngo.get(), l)) {
            if (!this.nhn) {
                this.nhn = true;
                this.nho = false;
                this.ngz.stop(class_3102);
                this.nhd.stop(class_3102);
                this.nhe.cancel(class_3102);
                this.nhf.stop(class_3102, class_7462);
                this.nha.cancel(class_3102);
                this.njg = false;
                this.njf = false;
                this.nhs = -1;
                this.nly(nff.IDLE);
            }
            this.nho |= this.nhk.active();
            this.nhb.assistAt(class_3102, class_7462, null, null, 1);
            return true;
        }
        boolean bl = this.nhk.takeReturned();
        if (bl || this.nhn) {
            this.nhn = false;
            if (bl || this.nho) {
                this.nhr = !this.njx() ? 0 : (bl ? this.nln() : -1);
                this.nht = false;
                this.njp = 0L;
                this.nly(nff.START);
            } else {
                this.nly(nff.DECIDE);
            }
        }
        return false;
    }

    private boolean nkg() {
        return this.nhp == nff.MINE || (this.nhp == nff.WAIT || this.nhp == nff.SETTLE) && this.ngz.status() == qdw.WORKING;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        boolean bl;
        long l;
        MineModelReader ttb2;
        class_746 class_7462;
        ++this.njr;
        if (this.ngw != null && this.njr % 20 == 1) {
            this.njv();
        }
        if ((class_7462 = class_3102.field_1724) == null || class_3102.field_1687 == null) {
            return;
        }
        InstanceQueue.keep(this.nmb());
        if (this.ngw == null) {
            PacketHooks.ensure(class_3102);
        }
        AimModel tck2 = (ttb2 = AutoMine.mineModel()) != null ? ttb2.hand : AutoMine.model(lex.MINE);
        double d = ttb2 != null ? AutoMine.mineBoost() : 0.0;
        this.nhb.use(tck2 != null ? tck2 : AimModel.profile1());
        this.nhb.tune(1.0 + d, 1.0, 1.0);
        this.nhb.reactionScale(1.0 / (1.0 + 2.0 * d));
        this.nhb.verticalAware(ttb2 == null);
        this.nhb.cap(ttb2 != null && ttb2.style.turnCap > 0.0f ? (double)ttb2.style.turnCap * (1.0 + d) : 0.0);
        this.nhb.pointSize(ttb2 != null ? 0.5 : 0.3);
        this.nhc.cap(110.0);
        this.ngz.boost(d);
        this.ngz.brain(ttb2);
        this.ngz.configure(tck2 != null ? null : this.nhc, ttb2 == null || ttb2.style.sprints(), true);
        this.ngz.predict(this.ngs.get(), class_3102);
        this.nhd.walker().configure(this.nhc, true, false);
        this.nha.noThrow = this.nhp == nff.BASE;
        this.nlx();
        if (class_3102.field_1755 instanceof class_418 && class_7462.method_29504() && this.njr % 20 == 0) {
            class_7462.method_7331();
            class_3102.method_1507(null);
        }
        if (class_7462.method_29504() && this.nhp == nff.BASE) {
            this.nhd.stop(class_3102);
            this.nly(nff.DECIDE);
        }
        if (this.nht && this.nhu != class_7462) {
            this.nht = false;
        }
        if (this.nkf(class_3102, class_7462, l = System.currentTimeMillis())) {
            return;
        }
        this.nke(class_3102, class_7462, l);
        boolean bl2 = bl = !this.njg && (this.nhp != nff.BASE || this.nin == 2 && this.nhd.canPause());
        if (this.njr % 10 == 0 && !this.nhf.active() && !this.nha.busy() && !this.nhe.active() && class_3102.field_1755 == null && bl && class_7462.method_5805() && AutoEat.hungry(class_7462)) {
            if (AutoEat.canEat(class_7462)) {
                this.nhf.start(class_7462);
            } else {
                int n = AutoEat.stored(class_7462);
                if (n >= 0) {
                    this.nha.swaps(n, class_7462.method_6079().method_7960() ? 40 : 8);
                }
            }
        }
        try {
            if (!(this.nhf.active() || this.nha.busy() || this.njg && l - this.nji < 12000L)) {
                this.nki(class_3102, class_7462, l);
            }
        }
        catch (RuntimeException runtimeException) {
            System.out.println("AutoMine: " + runtimeException);
            runtimeException.printStackTrace();
            this.ngz.stop(class_3102);
            this.nhd.stop(class_3102);
            this.nly(nff.DECIDE);
        }
        if (this.nha.busy()) {
            this.nha.endTick(class_3102, class_7462, ngn);
        }
        if (this.ngw == null) {
            this.nlk(class_3102, class_7462);
        }
        if (this.nha.busy()) {
            if (this.nha.job() == qoc.JUNK && this.njn != null) {
                this.nkh(class_3102, class_7462, this.njo, this.njn);
            } else {
                this.nhb.assistAt(class_3102, class_7462, null, null, 1);
            }
        } else if (this.nhf.active()) {
            this.nhf.endTick(class_3102, class_7462);
            this.nhb.assistAt(class_3102, class_7462, null, null, 1);
        } else if (this.njg) {
            this.ngz.endTick(class_3102, class_7462, this.nhb);
        } else if (this.nhp == nff.BASE) {
            if (this.nin != 2) {
                this.nhb.assistAt(class_3102, class_7462, null, null, 1);
            }
        } else if (this.nkg() && !this.nhe.active()) {
            this.ngz.endTick(class_3102, class_7462, this.nhb);
        } else {
            this.nhb.assistAt(class_3102, class_7462, null, null, 1);
        }
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1755 != null || !class_3102.field_1729.method_1613()) {
            this.nhb.forgetFrame();
            return;
        }
        this.nhb.frame(class_3102, class_7462);
    }

    private void nkh(class_310 class_3102, class_746 class_7462, Object object, class_243 class_2432) {
        this.nhb.assistAt(class_3102, class_7462, null, null, 1);
        this.nhc.aim(class_3102, class_7462, object, class_2432);
    }

    private void nki(class_310 class_3102, class_746 class_7462, long l) {
        if (this.nhe.active()) {
            if (this.nhe.tick(class_3102, class_7462, l)) {
                this.nhi.add(this.nis);
                this.nma("Авто-скупка" + (this.nis > 0 ? " на " + this.nis : "") + ": " + this.nhe.result(), this.nhe.ok() ? Icon.CHECK : Icon.ALERT);
            }
            return;
        }
        switch (this.nhp.ordinal()) {
            case 0: {
                this.nkj(class_3102, class_7462, l);
                break;
            }
            case 1: {
                this.nkk(class_3102, class_7462, l);
                break;
            }
            case 2: {
                this.nks(class_3102, class_7462, l);
                break;
            }
            case 3: {
                this.nkt(class_3102, class_7462, l);
                break;
            }
            case 4: {
                this.nkw(class_3102, class_7462, l);
                break;
            }
            case 5: {
                this.nkz(class_3102, class_7462, l);
                break;
            }
            case 6: {
                this.nlf(class_3102, class_7462, l);
                break;
            }
            case 7: {
                this.nli(class_3102, class_7462, l);
                break;
            }
            case 9: {
                this.nlt(class_3102, class_7462, l);
                break;
            }
            case 8: {
                if (this.njr % 20 == 0 && this.nls(class_3102, class_7462, l)) {
                    return;
                }
                if (l - this.nhq <= 2500L) break;
                this.nly(nff.DECIDE);
            }
        }
    }

    private void nkj(class_310 class_3102, class_746 class_7462, long l) {
        Box3 pzc2;
        pzp pzp2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(this.njx() ? HopTimings.parseList(AutoMines.njy()) : List.of(Integer.valueOf(0)));
        arrayList.remove((Object)this.nln());
        this.ngx.list(arrayList);
        if (!this.njx()) {
            this.nhr = 0;
        }
        if ((pzp2 = TimerTextParser.read(class_3102, 72.0)) != null && pzp2.pos().method_1022(class_7462.method_73189()) <= 30.0 && (pzc2 = Box3.detect((class_1937)class_3102.field_1687, pzp2.pos())) != null && pzc2.ores >= 20 && pzc2.distanceTo(class_7462.method_73189()) < 24.0) {
            this.nkx(class_7462);
            if (this.nhr >= 0) {
                this.nlw(this.nhr, pzp2, l, false);
                this.nhg.put(this.nhr, pzc2);
                this.nhh.put(this.nhr, pzp2.pos());
            }
            this.niz = null;
            this.nhs = this.nhr;
            this.nlh(class_3102, class_7462, pzc2, l);
            this.nma("Копаю шахту рядом", Icon.PLAYER);
            return;
        }
        this.nly(nff.DECIDE);
    }

    private void nkk(class_310 class_3102, class_746 class_7462, long l) {
        nes nes2;
        Object object;
        if (!MineTools.holdsPickaxe(class_7462) && MineTools.bestPickaxe(class_7462.method_31548()) < 0 && !LobbyWatcher.inLobby((class_1657)class_7462)) {
            if (this.njp == 0L) {
                this.njp = l;
            }
            if (l - this.njp > 5000L) {
                this.nma("Нет кирки в инвентаре", Icon.ALERT);
                this.nlz();
            }
            return;
        }
        this.njp = 0L;
        if (this.nls(class_3102, class_7462, l) || this.nlp(class_3102, class_7462, l)) {
            return;
        }
        if (this.nht && (object = this.nhh.get(this.nhr)) != null && object.method_1022(class_7462.method_73189()) > 36.0) {
            this.nht = false;
        }
        if (!this.njx()) {
            this.nhr = 0;
            object = TimerTextParser.read(class_3102, 72.0);
            if (object == null) {
                if (this.nht) {
                    this.nly(nff.IDLE);
                } else {
                    this.nku(class_3102, class_7462, l);
                }
                return;
            }
            this.nhh.put(0, ((pzp)object).pos());
            this.nlw(0, (pzp)object, l, false);
        }
        Object object2 = object = this.nhr >= 0 ? this.ngx.fresh(this.nhr, l, this.ngy) : null;
        if (object != null && this.nhh.containsKey(this.nhr)) {
            this.nhs = this.nhr;
            this.niz = object;
            if (this.nht) {
                this.nlg(true);
            } else {
                this.nku(class_3102, class_7462, l);
            }
            return;
        }
        nes nes3 = nes2 = this.nhr >= 0 ? this.nkl(class_3102, class_7462, l) : null;
        if (nes2 != null) {
            String string;
            this.nhs = this.nhr;
            qqm qqm2 = this.ngx.entry(this.nhr);
            this.niz = qqm2 != null && qqm2.lastTier != null ? qqm2.lastTier : MineRarity.COMMON;
            String string2 = string = this.nhr > 0 ? " на " + this.nhr : "";
            if (!nes2.look() && (this.nht || nes2.area().distanceTo(class_7462.method_73189()) < 24.0)) {
                this.nma("Шахта" + string + " только что обновилась: " + nes2.diamonds() + " алмазов — копаю", Icon.PLAYER);
                this.nlh(class_3102, class_7462, nes2.area(), l);
            } else {
                this.nma(nes2.look() ? "Шахта" + string + " видна не вся, алмазов в ней много — иду посмотреть" : "Шахта" + string + " только что обновилась: " + nes2.diamonds() + " алмазов — иду копать", Icon.NAV);
                this.nku(class_3102, class_7462, l);
            }
            return;
        }
        qqg qqg2 = this.ngx.decide(l, this.nhr, this.nht ? 0L : this.ngx.warpMs(), this.ngy);
        switch (qqg2.kind()) {
            case SCAN: {
                this.nhs = -1;
                this.nkp(class_3102, class_7462, qqg2.id(), l);
                break;
            }
            case GO: {
                this.nhs = qqg2.id();
                if (qqg2.id() == this.nhr) {
                    if (this.nht) {
                        this.nky(class_3102, qqg2.entry(), l);
                        break;
                    }
                    this.nku(class_3102, class_7462, l);
                    break;
                }
                qqm qqm3 = qqg2.entry();
                this.nma("Иду на " + qqg2.id() + ": " + qqm3.tier.title() + " через " + AutoMines.clock(qqm3.refreshAt - l), Icon.NAV);
                this.nkp(class_3102, class_7462, qqg2.id(), l);
                break;
            }
            case IDLE: {
                this.nly(nff.IDLE);
            }
        }
    }

    private nes nkl(class_310 class_3102, class_746 class_7462, long l) {
        int n;
        class_243 class_2432 = this.nhh.get(this.nhr);
        qqm qqm2 = this.ngx.entry(this.nhr);
        if (class_2432 == null || qqm2 == null || this.nhr == this.nln() || class_3102.field_1687 == null) {
            return null;
        }
        if (qqm2.refreshAt - l < this.ngy.minMineMs + 20000L) {
            return null;
        }
        if (AutoMines.nkn(this.nhl.get(this.nhr), qqm2.refreshAt)) {
            return null;
        }
        boolean bl = AutoMines.nkn(this.nhm.get(this.nhr), qqm2.refreshAt);
        if (bl && !this.nht) {
            this.nhl.put(this.nhr, qqm2.refreshAt);
            return null;
        }
        Box3 pzc2 = this.nhg.get(this.nhr);
        if (pzc2 == null || pzc2.distanceTo(class_2432) > 30.0) {
            pzc2 = Box3.detect((class_1937)class_3102.field_1687, class_2432);
            if (pzc2 == null) {
                return null;
            }
            this.nhg.put(this.nhr, pzc2);
        }
        if ((n = AutoMines.nkm((class_1937)class_3102.field_1687, pzc2)) >= 20) {
            if (!this.nht) {
                this.nhm.put(this.nhr, qqm2.refreshAt);
            }
            return new nes(pzc2, n, false);
        }
        if (this.nht || Box3.loaded((class_1937)class_3102.field_1687, class_2432)) {
            this.nhl.put(this.nhr, qqm2.refreshAt);
            return null;
        }
        if (!bl && n * 2 >= 20) {
            this.nhm.put(this.nhr, qqm2.refreshAt);
            return new nes(pzc2, n, true);
        }
        return null;
    }

    private static int nkm(class_1937 class_19372, Box3 pzc2) {
        int n = 0;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = pzc2.minX; i <= pzc2.maxX; ++i) {
            for (int j = pzc2.minZ; j <= pzc2.maxZ; ++j) {
                if (!class_19372.method_8393(i >> 4, j >> 4)) continue;
                for (int k = pzc2.minY; k <= pzc2.maxY; ++k) {
                    if (!AutoMines.nkc(class_19372.method_8320((class_2338)class_23392.method_10103(i, k, j)))) continue;
                    ++n;
                }
            }
        }
        return n;
    }

    private static boolean nkn(Long l, long l2) {
        return l != null && Math.abs(l - l2) < 60000L;
    }

    private void nko() {
        qqm qqm2;
        qqm qqm3 = qqm2 = this.nhr >= 0 ? this.ngx.entry(this.nhr) : null;
        if (qqm2 != null) {
            this.nhl.put(this.nhr, qqm2.refreshAt);
        }
    }

    private void nkp(class_310 class_3102, class_746 class_7462, int n, long l) {
        if (!InstanceQueue.enter(this.nmb(), String.valueOf(n))) {
            InstanceQueue.cancel(this.nmb());
            this.ngx.block(n, l + 30000L);
            this.nma("На " + n + " уже " + 3 + " наших — пропускаю", Icon.INFO);
            this.nly(nff.DECIDE);
            return;
        }
        this.ngx.scanned(n);
        this.nhv = n;
        this.nhw = l;
        this.nhx = true;
        this.nid = 0;
        this.nie = 0L;
        this.nkq(class_3102, class_7462);
        this.nly(nff.HOP);
    }

    private void nkq(class_310 class_3102, class_746 class_7462) {
        this.nhy = class_3102.field_1687;
        this.nhz = class_7462;
        this.nia = class_7462.method_73189();
        this.nib = false;
        this.nic = false;
        class_3102.method_1562().method_45730("an" + this.nhv);
    }

    private boolean nkr(class_310 class_3102, class_746 class_7462) {
        return class_3102.field_1687 != this.nhy || class_7462 != this.nhz || this.nia != null && class_7462.method_73189().method_1022(this.nia) > 48.0;
    }

    private void nks(class_310 class_3102, class_746 class_7462, long l) {
        if (this.nkr(class_3102, class_7462) || this.nib) {
            this.nhr = this.nhv;
            this.nht = false;
            this.nly(nff.ARRIVE);
            return;
        }
        if (this.nic) {
            if (this.nid >= 3) {
                this.ngx.block(this.nhv, l + 120000L);
                this.nma("Анархия " + this.nhv + " недоступна, пропускаю", Icon.ALERT);
                this.nly(nff.DECIDE);
                return;
            }
            if (this.nie == 0L) {
                this.nie = l + 2500L;
            } else if (l >= this.nie) {
                ++this.nid;
                this.nie = 0L;
                this.nhx = false;
                this.nkq(class_3102, class_7462);
            }
            return;
        }
        if (l - this.nhq > 15000L) {
            this.ngx.block(this.nhv, l + 90000L);
            this.nma("Не пустило на " + this.nhv, Icon.ALERT);
            this.nly(nff.DECIDE);
        }
    }

    private void nkt(class_310 class_3102, class_746 class_7462, long l) {
        if (class_3102.field_1755 != null && !(class_3102.field_1755 instanceof class_418)) {
            if (l - this.nhq > 20000L) {
                this.nly(nff.DECIDE);
            }
            return;
        }
        if (l - this.nhq < 1500L) {
            return;
        }
        pzp pzp2 = TimerTextParser.read(class_3102, 72.0);
        if (pzp2 != null) {
            this.nhh.put(this.nhr, pzp2.pos());
            this.nlw(this.nhr, pzp2, l, this.nhx);
            this.nhx = false;
            if (pzp2.pos().method_1022(class_7462.method_73189()) <= 12.0) {
                this.nkx(class_7462);
            }
            this.nly(nff.DECIDE);
            return;
        }
        if (l - this.nhq > 4000L) {
            this.nku(class_3102, class_7462, l);
        }
    }

    private void nku(class_310 class_3102, class_746 class_7462, long l) {
        this.nig = 0;
        this.nly(nff.WARP);
        this.nkv(class_3102, class_7462, l, "warp mine");
    }

    private void nkv(class_310 class_3102, class_746 class_7462, long l, String string) {
        String string2 = string.trim();
        if (string2.startsWith("/")) {
            string2 = string2.substring(1);
        }
        if (!string2.isEmpty()) {
            class_3102.method_1562().method_45730(string2);
        }
        ++this.nig;
        this.nif = l;
        this.nih = class_7462.method_73189();
        this.nii = class_3102.field_1687;
        this.nij = class_7462;
        this.nik = 0L;
        this.nil = false;
        this.nim = 0L;
    }

    private void nkw(class_310 class_3102, class_746 class_7462, long l) {
        if (this.nim == 0L) {
            long l2;
            boolean bl;
            boolean bl2 = class_3102.field_1687 != this.nii || class_7462 != this.nij || class_7462.method_73189().method_1022(this.nih) > 2.5;
            class_243 class_2432 = this.nhh.get(this.nhr);
            boolean bl3 = bl = this.nik > 0L && l > this.nik + 1500L && class_2432 != null && class_2432.method_1022(class_7462.method_73189()) <= 14.0;
            if (bl2 || bl) {
                this.nim = l;
                this.nkx(class_7462);
                this.ngx.warpTook(l - this.nif);
                return;
            }
            long l3 = l2 = this.nik > 0L ? this.nik + 5000L : this.nif + 12000L;
            if (this.nil || l > l2) {
                if (this.nig < 2) {
                    this.nkv(class_3102, class_7462, l, "warp mine");
                    return;
                }
                if (this.njx() && this.nhr >= 0) {
                    this.ngx.block(this.nhr, l + 120000L);
                }
                this.nma("Не получилось телепортироваться на шахту" + (this.nhr > 0 ? " на " + this.nhr : ""), Icon.ALERT);
                this.nly(this.njx() ? nff.DECIDE : nff.IDLE);
            }
            return;
        }
        if (l - this.nim < 700L) {
            return;
        }
        pzp pzp2 = TimerTextParser.read(class_3102, 72.0);
        if (pzp2 != null) {
            this.nhh.put(this.nhr, pzp2.pos());
            this.nlw(this.nhr, pzp2, l, this.nhx);
            this.nhx = false;
            this.nly(nff.DECIDE);
            return;
        }
        if (l - this.nim > 6000L) {
            this.nma("Не вижу табличку шахты" + (this.nhr > 0 ? " на " + this.nhr : ""), Icon.ALERT);
            if (this.njx() && this.nhr >= 0 && this.ngx.entry(this.nhr) == null) {
                this.ngx.block(this.nhr, l + 120000L);
            }
            this.nly(nff.DECIDE);
        }
    }

    private void nkx(class_746 class_7462) {
        this.nht = true;
        this.nhu = class_7462;
    }

    private void nky(class_310 class_3102, qqm qqm2, long l) {
        this.niy = qqm2 == null ? null : qqm2.tier;
        this.niw = -1;
        this.njf = false;
        this.njj = 0L;
        this.njk = null;
        this.nma("Жду " + (this.niy == null ? "шахту" : this.niy.title()) + " на " + this.nhr + (qqm2 == null ? "" : " (" + AutoMines.clock(qqm2.refreshAt - l) + ")"), Icon.CLOCK);
        this.nly(nff.WAIT);
        this.nlm(class_3102, l);
    }

    private void nkz(class_310 class_3102, class_746 class_7462, long l) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        if (this.njf && (this.ngz.parkLost() || this.ngz.status() != qdw.WORKING)) {
            this.njf = false;
            this.ngz.stop(class_3102);
            this.nlc("не вижу дороги к ступенькам", l);
        }
        if (!this.njf && this.nht && l >= this.njj) {
            this.nlb(class_3102, class_7462, l);
        }
        if (!this.njf && this.nht) {
            this.nla(class_7462);
        }
        boolean bl4 = bl3 = this.njf || class_7462.method_5765();
        if (!bl3 && this.njr % 20 == 0 && this.nls(class_3102, class_7462, l)) {
            return;
        }
        if (this.njr % 5 != 0) {
            return;
        }
        pzp pzp2 = TimerTextParser.read(class_3102, 72.0);
        qqm qqm2 = this.ngx.entry(this.nhr);
        boolean bl5 = bl2 = qqm2 != null && l > qqm2.refreshAt + 2500L;
        if (pzp2 == null || pzp2.pos().method_1022(class_7462.method_73189()) > 36.0) {
            boolean bl6;
            class_243 class_2432 = this.nhh.get(this.nhr);
            boolean bl7 = bl6 = bl3 || class_2432 != null && class_2432.method_1022(class_7462.method_73189()) <= 36.0;
            if (bl6 && bl2) {
                this.niz = this.niy != null ? this.niy : qqm2.tier;
                this.nlg(false);
            } else if (!bl6 && l - this.nix > 6000L) {
                this.nht = false;
                this.nly(nff.DECIDE);
            }
            return;
        }
        boolean bl8 = bl = this.niw >= 0 && pzp2.seconds() > this.niw + 20;
        if (bl || bl2) {
            MineRarity qwj2;
            MineRarity qwj3 = this.niy != null ? this.niy : (qwj2 = qqm2 != null ? qqm2.tier : null);
            if (bl) {
                this.nlw(this.nhr, pzp2, l, false);
            }
            this.niz = qwj2;
            this.nhh.put(this.nhr, pzp2.pos());
            this.nlg(bl);
            return;
        }
        if (pzp2.tier() != null && (qqm2 == null || qqm2.tier == pzp2.tier())) {
            this.nlw(this.nhr, pzp2, l, false);
        }
        this.niw = pzp2.seconds();
        if (bl3) {
            return;
        }
        qqg qqg2 = this.ngx.decide(l, this.nhr, 0L, this.ngy);
        if (qqg2.kind() == qqp.GO && qqg2.id() != this.nhr && qqm2 != null && qqg2.entry() != null && qqg2.entry().tier.rank() > qqm2.tier.rank()) {
            this.nly(nff.DECIDE);
        }
    }

    private void nla(class_746 class_7462) {
        if (this.ngz.status() == qdw.WORKING) {
            return;
        }
        Box3 pzc2 = this.nhg.get(this.nhr);
        this.ngz.guard(pzc2 != null && pzc2.distanceTo(class_7462.method_73189()) < 30.0 ? pzc2 : Box3.empty(class_7462.method_24515()));
    }

    private void nlb(class_310 class_3102, class_746 class_7462, long l) {
        if (!class_7462.method_24828() && !class_7462.method_5765()) {
            return;
        }
        class_2338 class_23382 = AutoMines.nle("-61 69 35");
        if (class_23382 == null) {
            this.nlc("не понял координаты «-61 69 35»", l);
            return;
        }
        class_243 class_2432 = class_243.method_24953((class_2382)class_23382);
        class_243 class_2433 = this.nhh.get(this.nhr);
        if (class_2433 != null && class_2433.method_1022(class_2432) > 48.0 || class_2432.method_1022(class_7462.method_73189()) > 48.0) {
            this.nlc("ступеньки " + class_23382.method_23854() + " далеко", l);
            return;
        }
        Box3 pzc2 = this.nld(class_3102, class_2433, class_23382);
        this.nha.equip(class_3102, class_7462);
        this.ngz.park(pzc2, class_23382, true);
        this.njf = true;
        if (this.njk == null) {
            this.nma("Иду к ступенькам " + class_23382.method_23854(), Icon.NAV);
        }
    }

    private void nlc(String string, long l) {
        this.njj = l + 3000L;
        if (!string.equals(this.njk)) {
            this.njk = string;
            this.nma("Не иду на ступеньки: " + string, Icon.ALERT);
        }
    }

    private Box3 nld(class_310 class_3102, class_243 class_2432, class_2338 class_23382) {
        Box3 pzc2 = this.nhg.get(this.nhr);
        if (pzc2 != null && (class_2432 == null || pzc2.distanceTo(class_2432) <= 30.0)) {
            return pzc2;
        }
        if (class_2432 != null) {
            Box3 pzc3 = Box3.detect((class_1937)class_3102.field_1687, class_2432);
            if (pzc3 != null) {
                this.nhg.put(this.nhr, pzc3);
                return pzc3;
            }
            for (Map.Entry<Integer, Box3> entry : this.nhg.entrySet()) {
                class_243 class_2433 = this.nhh.get(entry.getKey());
                if (entry.getKey() == this.nhr || class_2433 == null || class_2433.method_1022(class_2432) > 3.0) continue;
                Box3 pzc4 = entry.getValue();
                int n = (int)Math.round(class_2432.field_1352 - class_2433.field_1352);
                int n2 = (int)Math.round(class_2432.field_1351 - class_2433.field_1351);
                int n3 = (int)Math.round(class_2432.field_1350 - class_2433.field_1350);
                return new Box3(pzc4.minX + n, pzc4.minY + n2, pzc4.minZ + n3, pzc4.maxX + n, pzc4.maxY + n2, pzc4.maxZ + n3, pzc4.ores);
            }
        }
        return Box3.empty(class_23382);
    }

    private static class_2338 nle(String string) {
        String[] stringArray = string.trim().replace(',', ' ').split("\\s+");
        if (stringArray.length < 3) {
            return null;
        }
        try {
            return class_2338.method_49637((double)Double.parseDouble(stringArray[0]), (double)Double.parseDouble(stringArray[1]), (double)Double.parseDouble(stringArray[2]));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private void nlf(class_310 class_3102, class_746 class_7462, long l) {
        ++this.njb;
        if (this.nht && this.ngz.status() != qdw.WORKING) {
            this.nla(class_7462);
        }
        if (this.njb % 20 == 0 && !class_7462.method_5765() && this.nls(class_3102, class_7462, l)) {
            return;
        }
        if (this.njb % 3 != 0) {
            return;
        }
        class_243 class_2432 = this.nhh.get(this.nhr);
        pzp pzp2 = TimerTextParser.read(class_3102, 72.0);
        if (pzp2 != null) {
            class_2432 = pzp2.pos();
            if (!this.njc && this.niw >= 0 && pzp2.seconds() > this.niw + 20) {
                this.njc = true;
                this.njd = this.njb;
                this.nlw(this.nhr, pzp2, l, false);
            } else if (!this.njc && pzp2.seconds() >= 0) {
                int n = this.niw = this.niw < 0 ? pzp2.seconds() : Math.min(this.niw, pzp2.seconds());
            }
        }
        if (!this.njc && this.njb > 200) {
            this.njc = true;
            this.njd = this.njb;
        }
        if (!this.njc || this.njb - this.njd < 12 || this.njb % 6 != 0) {
            return;
        }
        if (class_2432 == null) {
            class_2432 = class_7462.method_73189();
        }
        Box3 pzc2 = Box3.detect((class_1937)class_3102.field_1687, class_2432);
        Box3 pzc3 = this.nhg.get(this.nhr);
        if (pzc3 != null && pzc3.distanceTo(class_2432) > 30.0) {
            pzc3 = null;
        }
        if (!(pzc2 == null || pzc3 != null && pzc2.volume() < pzc3.volume() && pzc3.covers(pzc2))) {
            this.nhg.put(this.nhr, pzc2);
            pzc3 = pzc2;
        }
        if (pzc3 != null && (pzc2 != null || this.njb - this.njd > 60)) {
            this.nlh(class_3102, class_7462, pzc3, l);
            this.nma("Копаю " + (this.niz == null ? "шахту" : this.niz.title()) + (this.nhr > 0 ? " на " + this.nhr : ""), Icon.PLAYER);
            return;
        }
        if (this.njb - this.njd > 80) {
            this.nma("Не нашёл границы шахты", Icon.ALERT);
            this.ngx.mined(this.nhr);
            this.nly(nff.DECIDE);
        }
    }

    private void nlg(boolean bl) {
        this.njb = 0;
        this.njc = bl;
        this.njd = 0;
        this.nly(nff.SETTLE);
    }

    private void nlh(class_310 class_3102, class_746 class_7462, Box3 pzc2, long l) {
        this.nja = l;
        this.ngx.mined(this.nhr);
        this.nko();
        this.nha.equip(class_3102, class_7462);
        this.nha.unstow(class_7462);
        this.ngz.start(pzc2);
        this.niw = -1;
        this.nly(nff.MINE);
        this.nlm(class_3102, l);
    }

    private void nli(class_310 class_3102, class_746 class_7462, long l) {
        int n;
        boolean bl;
        class_1661 class_16612 = class_7462.method_31548();
        if (this.nlp(class_3102, class_7462, l)) {
            return;
        }
        this.nha.unstow(class_7462);
        if (this.niu && !this.nha.busy()) {
            this.niu = false;
            this.nit = this.nha.laidOut();
            this.nma(this.nit ? "Инвентарь разложен" : "Раскладка не удалась, повторю позже", this.nit ? Icon.CHECK : Icon.ALERT);
        }
        if (this.njr % 20 == 0) {
            if (this.nls(class_3102, class_7462, l)) {
                return;
            }
            pzp pzp2 = TimerTextParser.read(class_3102, 72.0);
            if (pzp2 != null) {
                if (this.niw >= 0 && pzp2.seconds() > this.niw + 20) {
                    qqm qqm2 = this.ngx.entry(this.nhr);
                    this.niz = qqm2 != null ? qqm2.tier : this.niz;
                    this.nlw(this.nhr, pzp2, l, false);
                    this.niw = pzp2.seconds();
                    this.ngz.stop(class_3102);
                    this.nlg(true);
                    return;
                }
                if (this.nhr >= 0) {
                    this.nlw(this.nhr, pzp2, l, false);
                    this.ngx.mined(this.nhr);
                }
                this.niw = pzp2.seconds();
            }
            if (!(MineTools.holdsPickaxe(class_7462) || this.nha.busy() || this.nha.equip(class_3102, class_7462))) {
                this.nma("Нет кирки", Icon.ALERT);
                this.nlz();
                return;
            }
            if (this.nit && this.njr % 400 == 0 && InventoryCounter.misplaced(class_16612, InventoryCounter.targets(class_16612, class_7462.method_6079())) > 3) {
                this.nit = false;
            }
        }
        if (!(this.nit || this.niu || this.njr % 20 != 10 || this.nha.busy() || this.ngz.breaking() || !InventoryCounter.ready(class_16612))) {
            this.nma("Нужное набрано, раскладываю инвентарь", Icon.INFO);
            this.nha.layout();
            this.niu = true;
            return;
        }
        if (this.nit && this.njr % 10 == 5 && l - this.niv > 3000L && !this.nha.busy()) {
            this.nll(class_3102, class_7462, l);
        }
        boolean bl2 = bl = class_3102.field_1761 != null && class_3102.field_1761.method_2923();
        if (!this.nha.busy() && !bl && this.njr % 5 == 0 && l - this.njl > 5000L && (n = MineTools.empty(class_16612)) <= 2) {
            if (MineTools.hasJunk(class_16612, ngn)) {
                this.nlj(class_7462);
                this.ngz.avoid(class_7462.method_73189(), 1200);
                this.njl = l;
                this.nje = false;
            } else if (!this.nje && n == 0 && !this.nit) {
                this.nje = true;
                this.nma("Инвентарь полон", Icon.ALERT);
            }
        }
        long l2 = this.njx() ? this.ngx.leaveAt(l, this.nhr, this.niz, l - this.nja, this.ngy) : Long.MAX_VALUE;
        boolean bl3 = l - this.nja > AutoMines.nka();
        qqm qqm3 = this.nhr >= 0 ? this.ngx.entry(this.nhr) : null;
        boolean bl4 = qqm3 != null && qqm3.refreshAt > this.nja + 20000L && qqm3.refreshAt - l < 20000L;
        qdw qdw2 = this.ngz.status();
        if (l >= l2 || bl3 || bl4 || qdw2 == qdw.DONE || qdw2 == qdw.FAR) {
            if (this.nha.busy()) {
                return;
            }
            int n2 = this.ngz.diamondsLeft();
            this.nma("Накопал " + this.ngz.mined() + " алмазов" + (bl4 ? " — шахта сейчас обновится, жду её" : (qdw2 != qdw.DONE ? "" : (n2 > 0 ? ", осталось " + n2 + " — дальше не копаю" : ", шахта пуста"))), Icon.CHECK);
            this.ngz.stop(class_3102);
            this.nko();
            this.nhs = -1;
            if (qdw2 == qdw.FAR) {
                this.nht = false;
            } else if (MineTools.hasJunk(class_16612, ngn)) {
                this.nlj(class_7462);
                this.njl = l;
                this.nje = false;
            }
            this.nly(nff.DECIDE);
        }
    }

    private void nlj(class_746 class_7462) {
        double d;
        class_243 class_2432;
        Box3 pzc2;
        this.nha.dropJunk(64);
        this.njo = new Object();
        class_243 class_2433 = class_7462.method_33571();
        class_243 class_2434 = null;
        Box3 pzc3 = pzc2 = this.nhr >= 0 ? this.nhg.get(this.nhr) : null;
        if (pzc2 == null) {
            pzc2 = this.ngz.area();
        }
        if (pzc2 != null && pzc2.maxX >= pzc2.minX) {
            class_2432 = pzc2.center();
            d = class_2433.field_1352 - class_2432.field_1352;
            double d2 = class_2433.field_1350 - class_2432.field_1350;
            double d3 = Math.sqrt(d * d + d2 * d2);
            if (d3 > 1.5) {
                class_2434 = new class_243(d / d3, 0.0, d2 / d3);
            }
        }
        if (class_2434 == null) {
            class_2432 = class_7462.method_5828(1.0f);
            d = Math.sqrt(class_2432.field_1352 * class_2432.field_1352 + class_2432.field_1350 * class_2432.field_1350);
            class_2434 = d < 0.1 ? new class_243(0.0, 0.0, 1.0) : new class_243(class_2432.field_1352 / d, 0.0, class_2432.field_1350 / d);
        }
        this.njn = class_2433.method_1031(class_2434.field_1352 * 4.0, 2.2, class_2434.field_1350 * 4.0);
    }

    private void nlk(class_310 class_3102, class_746 class_7462) {
        Box3 pzc2;
        Box3 pzc3 = pzc2 = this.nhr >= 0 ? this.nhg.get(this.nhr) : null;
        if (pzc2 == null && this.nkg()) {
            pzc2 = this.ngz.area();
        }
        if (pzc2 == null || pzc2.maxX < pzc2.minX || pzc2.distanceTo(class_7462.method_73189()) > 64.0) {
            DiamondEsp.clear();
            return;
        }
        if (this.njr % 10 == 0) {
            DiamondEsp.scan((class_1937)class_3102.field_1687, pzc2, class_7462.method_33571());
        }
        DiamondEsp.focus(this.ngz.focus());
    }

    private void nll(class_310 class_3102, class_746 class_7462, long l) {
        boolean bl;
        class_1661 class_16612 = class_7462.method_31548();
        if (InventoryCounter.count(class_16612, class_1802.field_22019) > 0 || MineTools.empty(class_16612) > 0) {
            return;
        }
        boolean bl2 = bl = !class_3102.field_1687.method_8390(class_1542.class, class_7462.method_5829().method_1009(6.0, 3.0, 6.0), class_15422 -> class_15422.method_6983().method_31574(class_1802.field_22019)).isEmpty();
        if (!bl) {
            return;
        }
        int n = -1;
        if (class_16612.method_5438(32).method_31574(class_1802.field_8695) && class_16612.method_5438(32).method_7947() == 1) {
            n = 32;
        } else {
            for (int i = 9; i < 36 && n < 0; ++i) {
                if (!class_16612.method_5438(i).method_31574(class_1802.field_8695) || class_16612.method_5438(i).method_7947() != 1) continue;
                n = i;
            }
        }
        if (n >= 0) {
            this.niv = l;
            this.nha.throwOne(n);
            this.nma("Древний обломок на земле — освобождаю под него слот", Icon.INFO);
        }
    }

    private void nlm(class_310 class_3102, long l) {
        int n;
        int n2 = n = this.njx() ? this.nhr : 0;
        if (this.nhe.active() || n < 0 || n == this.nln() || this.nhi.contains(n)) {
            return;
        }
        this.nis = n;
        this.nhe.begin(class_3102, "buyer", l);
    }

    private int nln() {
        Matcher matcher = nfu.matcher(this.ngo.get());
        if (!matcher.find()) {
            return -1;
        }
        try {
            return Integer.parseInt(matcher.group(1));
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    private String nlo(class_746 class_7462, long l) {
        if (this.nln() <= 0 || l < this.nir) {
            return null;
        }
        if (AutoMineController.trapped(class_7462.method_73183(), class_7462) != null) {
            return null;
        }
        if (class_7462.method_6032() < 3.0f && this.nlq("hp", l)) {
            return "hp";
        }
        int n = InventoryCounter.pickaxeDurability(class_7462);
        if (n >= 0 && n < 190 && !this.nhd.repairFailed() && this.nlq("pick", l)) {
            return "pick";
        }
        if (InventoryCounter.count(class_7462.method_31548(), class_1802.field_8477) > 576 && this.nlq("diamonds", l)) {
            return "diamonds";
        }
        if (InventoryCounter.food((class_1657)class_7462) < 3 && this.nlq("food", l)) {
            return "food";
        }
        return null;
    }

    private boolean nlp(class_310 class_3102, class_746 class_7462, long l) {
        int n = InventoryCounter.pickaxeDurability(class_7462);
        if (n < 0 || n >= 190) {
            this.njh = false;
            return false;
        }
        if (this.nls(class_3102, class_7462, l)) {
            return true;
        }
        if (AutoMineController.trapped(class_7462.method_73183(), class_7462) != null) {
            return false;
        }
        this.ngz.stop(class_3102);
        if (!this.njh) {
            this.njh = true;
            this.nma("Кирка: " + n + " прочности — не копаю, чтобы не сломать (" + (this.nln() <= 0 ? "склад не задан" : "склад позже") + ")", Icon.ALERT);
        }
        this.nly(nff.IDLE);
        return true;
    }

    private boolean nlq(String string, long l) {
        Long l2 = this.nhj.get(string);
        return l2 == null || l2 <= l;
    }

    /*
     * Exception decompiling
     */
    private static String nlr(String var0) {
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

    private boolean nls(class_310 class_3102, class_746 class_7462, long l) {
        String string = this.nlo(class_7462, l);
        if (string == null || this.nha.busy()) {
            return false;
        }
        if (this.njx() && this.nhr != this.nln() && MineTools.hasJunk(class_7462.method_31548(), ngn) && l - this.njm > 15000L) {
            this.njm = l;
            this.ngz.stop(class_3102);
            this.nlj(class_7462);
            this.njl = l;
            return true;
        }
        this.ngz.stop(class_3102);
        this.njf = false;
        this.niq = AutoMines.nlr(string);
        this.nma("На склад: " + this.niq, Icon.NAV);
        this.nht = false;
        this.nhs = -1;
        int n = this.nln();
        if (this.nhd.atHome((class_1937)class_3102.field_1687, class_7462, 6.0)) {
            if (this.njx()) {
                this.nhr = n;
            }
            this.nin = 2;
            this.nhd.begin(l);
            this.nma("Уже у склада — без /home", Icon.CHECK);
        } else if (this.njx() && this.nhr != n) {
            this.nhv = n;
            this.nhw = l;
            this.nid = 0;
            this.nie = 0L;
            if (InstanceQueue.enter(this.nmb(), String.valueOf(n))) {
                this.nkq(class_3102, class_7462);
                this.nin = 0;
            } else {
                this.nin = -1;
                this.nma("На складе уже 3 наших — жду очереди", Icon.INFO);
            }
        } else {
            this.nin = 1;
            this.nip = false;
        }
        this.nio = l;
        this.nly(nff.BASE);
        return true;
    }

    private void nlt(class_310 class_3102, class_746 class_7462, long l) {
        switch (this.nin) {
            case -1: {
                if (this.njr % 20 != 0 || !InstanceQueue.enter(this.nmb(), String.valueOf(this.nhv))) break;
                this.nhw = l;
                this.nid = 0;
                this.nie = 0L;
                this.nkq(class_3102, class_7462);
                this.nin = 0;
                this.nio = l;
                this.nhq = l;
                break;
            }
            case 0: {
                if (this.nkr(class_3102, class_7462) || this.nib) {
                    this.nhr = this.nhv;
                    this.nin = 1;
                    this.nio = l;
                    this.nip = false;
                    return;
                }
                if (this.nic) {
                    if (this.nid >= 3) {
                        this.nlv(class_3102, class_7462, false, "склад " + this.nhv + " недоступен", l);
                    } else if (this.nie == 0L) {
                        this.nie = l + 2500L;
                    } else if (l >= this.nie) {
                        ++this.nid;
                        this.nie = 0L;
                        this.nkq(class_3102, class_7462);
                    }
                    return;
                }
                if (l - this.nhq <= 20000L) break;
                this.nlv(class_3102, class_7462, false, "не пустило на склад " + this.nhv, l);
                break;
            }
            case 1: {
                long l2;
                if (!this.nip) {
                    if (l - this.nio < 1500L || class_3102.field_1755 != null && !(class_3102.field_1755 instanceof class_418)) {
                        return;
                    }
                    if (this.nhd.atHome((class_1937)class_3102.field_1687, class_7462, 6.0)) {
                        this.nin = 2;
                        this.nhd.begin(l);
                        this.nma("Уже у склада — без /home", Icon.CHECK);
                        return;
                    }
                    this.nip = true;
                    this.nig = 0;
                    this.nkv(class_3102, class_7462, l, "home");
                    return;
                }
                boolean bl = class_3102.field_1687 != this.nii || class_7462 != this.nij || class_7462.method_73189().method_1022(this.nih) > 2.5;
                long l3 = l2 = this.nik > 0L ? this.nik + 5000L : this.nif + 12000L;
                if (bl || this.nig >= 2 && (this.nil || l > l2)) {
                    this.nin = 2;
                    this.nhd.begin(l);
                    return;
                }
                if (!this.nil && l <= l2) break;
                this.nkv(class_3102, class_7462, l, "home");
                break;
            }
            default: {
                this.nhd.repairTo = AutoMines.nlu(class_7462);
                this.nhd.xpStock = 576;
                this.nhd.junk = ngn;
                qsq qsq2 = this.nhd.tick(class_3102, class_7462, this.nha, this.nhb, this::nkh, l);
                if (qsq2 == qsq.RUNNING) break;
                this.nlv(class_3102, class_7462, qsq2 == qsq.DONE, null, l);
            }
        }
    }

    private static int nlu(class_746 class_7462) {
        class_1799 class_17992 = class_7462.method_6047();
        if (!class_17992.method_31573(class_3489.field_42614)) {
            int n = MineTools.bestPickaxe(class_7462.method_31548());
            class_1799 class_17993 = class_17992 = n >= 0 ? class_7462.method_31548().method_5438(n) : class_7462.method_6079();
        }
        if (!class_17992.method_31573(class_3489.field_42614) || class_17992.method_7936() <= 0) {
            return 1500;
        }
        return Math.max(200, class_17992.method_7936() - 2);
    }

    private void nlv(class_310 class_3102, class_746 class_7462, boolean bl, String string, long l) {
        this.nhd.stop(class_3102);
        if (string != null) {
            this.nma(string, Icon.ALERT);
        }
        if (bl) {
            this.nit = this.nha.laidOut();
            this.nma("Склад готов, возвращаюсь копать", Icon.CHECK);
        } else {
            this.nir = l + 120000L;
        }
        String string2 = this.nlo(class_7462, l);
        while (string2 != null) {
            this.nhj.put(string2, l + 600000L);
            this.nma("Склад не помог: " + AutoMines.nlr(string2) + " — подожду 10 мин", Icon.ALERT);
            string2 = this.nlo(class_7462, l);
        }
        this.nht = false;
        this.nhs = -1;
        this.nly(nff.DECIDE);
    }

    private void nlw(int n, pzp pzp2, long l, boolean bl) {
        qqm qqm2;
        if (n < 0 || pzp2 == null) {
            return;
        }
        MineRarity qwj2 = pzp2.tier();
        if (qwj2 == null) {
            qwj2 = MineRarity.COMMON;
            if (!pzp2.tierWord().isEmpty() && !this.njq.contains(pzp2.tierWord())) {
                this.nma("Неизвестный уровень: " + pzp2.tierWord(), Icon.INFO);
            }
        }
        boolean bl2 = (qqm2 = this.ngx.entry(n)) == null || qqm2.tier != qwj2 || qqm2.refreshAt < l;
        this.ngx.seen(n, qwj2, pzp2.seconds(), l);
        this.nix = l;
        if (bl) {
            this.ngx.hopTook(l - this.nhw);
        }
        if (bl2 && this.nhp != nff.MINE && this.nhp != nff.SETTLE) {
            this.nma((n > 0 ? n + ": " : "") + qwj2.title() + " через " + AutoMines.clock((long)pzp2.seconds() * 1000L), Icon.INFO);
        }
    }

    private void nlx() {
        this.ngy.tiers = this.nkb();
        this.ngy.waitMs = 30000L;
        this.ngy.leadMs = 7000L;
        this.ngy.minMineMs = AutoMines.njz();
    }

    private void nly(nff nff2) {
        if (this.njf && nff2 != nff.WAIT) {
            this.njf = false;
            if (nff2 != nff.SETTLE) {
                this.ngz.stop(this.mc);
            }
        }
        if ((this.nhp == nff.WAIT || this.nhp == nff.SETTLE) && nff2 != nff.WAIT && nff2 != nff.SETTLE && nff2 != nff.MINE && this.ngz.guarding()) {
            this.ngz.stop(this.mc);
        }
        this.nhp = nff2;
        this.nhq = System.currentTimeMillis();
    }

    private void nlz() {
        if (this.ngw != null) {
            this.setEnabledSilently(false);
        } else {
            this.setEnabled(false);
        }
    }

    private void nma(String string, Icon vhz2) {
        this.njq = string;
        if (this.ngw != null) {
            this.ngw.report("AutoMine: " + string, true);
            return;
        }
        System.out.println("AutoMine: " + string);
        Hud.alert(this.getName(), string, vhz2, true);
    }

    private Object nmb() {
        return this.ngw != null ? this.ngw : InstanceQueue.MAIN;
    }

    public static String clock(long l) {
        long l2 = Math.max(0L, (l + 999L) / 1000L);
        return String.format(Locale.ROOT, "%d:%02d", l2 / 60L, l2 % 60L);
    }

    static {
        nfv = "103-112, 203-234, 302-323, 501-514, 901-904";
        nfw = "an";
        nfx = "warp mine";
        ngc = "-61 69 35";
        ngd = "buyer";
        nge = "sit";
        ngf = "home";
        nft = Pattern.compile("(\\d+)\\s*сек");
        nfu = Pattern.compile("(\\d+)");
        ngn = Set.of("minecraft:cobblestone", "minecraft:cobbled_deepslate", "minecraft:stone", "minecraft:granite", "minecraft:diorite", "minecraft:andesite", "minecraft:tuff", "minecraft:calcite", "minecraft:deepslate", "minecraft:gravel", "minecraft:dirt", "minecraft:netherrack", "minecraft:blackstone", "minecraft:basalt", "minecraft:smooth_basalt", "minecraft:flint");
    }

    private static /* synthetic */ int bcr(int n, int n2) {
        return n * n2 ^ 0x7A8F7001;
    }

    private static /* synthetic */ int bcs(int n, int n2) {
        return AutoMines.bcr(n, n2) * n2;
    }
}

