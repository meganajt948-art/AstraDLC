/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10192
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1893
 *  net.minecraft.class_2561
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_476
 *  net.minecraft.class_746
 *  net.minecraft.class_9334
 */
package a;

import a.ClickGuiScreen;
import a.CollectorListPopup;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.CustomItemInfo;
import a.CollectorState;
import a.ItemSnapshot;
import a.ClaimTooltipParser;
import a.EnchantNameUtil;
import a.pfw;
import a.CollectorPages;
import a.HumanDelays;
import a.phj;
import a.ItemRule;
import a.Cooldown;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.IdleTracker;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_10192;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_476;
import net.minecraft.class_746;
import net.minecraft.class_9334;

public class AutoCollector
extends Module {
    private static AutoCollector mkm;
    private static final String[] mkn;
    private static final String[] mko;
    private static final String mkp;
    private static final String[] mkq;
    private static final Pattern mkr;
    private static final int mks = 200;
    private static final long mkt = 1500L;
    private static final long mku = 1400L;
    private static final int mkv = 4;
    private static final int mkw = 2;
    private static final int mkx = 6;
    private static final long mky = 3000L;
    private static final int mkz = 3;
    private static final int mla = 3;
    private static final int mlb = 40;
    private static final int mlc = 3;
    private static final long mld = 90000L;
    private static final long mle = 210000L;
    private static final long mlf = 2500L;
    private static final double mlg = 6.0;
    private static final long mlh = 4000L;
    private static final int mli = 4;
    private static final int mlj = 24;
    private static final int mlk = 54;
    private static final int mll = 4;
    private static final int mlm = 12;
    private static final int mln = 0;
    private static final int mlo = 1;
    private static final int mlp = 2;
    private static final int mlq = 3;
    private static final int mlr = 4;
    private static final int mls = 5;
    private static final int mlt = 6;
    private static final int mlu = 7;
    private final ButtonSetting mlv = this.add(new ButtonSetting("Work", new vkq("Start", Icon.PLAY, this::mnt), new vkq("Stop", Icon.PAUSE, this::mnu)));
    private final ButtonSetting mlw = this.add(new ButtonSetting("Item list", new vkq("Edit list", Icon.PENCIL, CollectorListPopup::open)));
    private final BoolSetting mlx = this.add(new BoolSetting("Notify", true));
    private final CollectorPages mly = new CollectorPages();
    private final HumanDelays mlz = new HumanDelays();
    private final Cooldown mma = new Cooldown();
    private final Cooldown mmb = new Cooldown();
    private final Cooldown mmc = new Cooldown();
    private final Cooldown mmd = new Cooldown();
    private final Cooldown mme = new Cooldown();
    private final Cooldown mmf = new Cooldown();
    private final IdleTracker mmg = new IdleTracker();
    private CustomItemInfo mmh;
    private boolean mmi;
    private String mmj = "";
    private boolean mmk;
    private int mml;
    private int mmm;
    private final Map<CustomItemInfo, Long> mmn = new HashMap<CustomItemInfo, Long>();
    private boolean mmo;
    private double mmp = 6.0;
    private long mmq = System.currentTimeMillis();
    private int mmr = -1;
    private class_1713 mms = class_1713.field_7790;
    private boolean mmt;
    private int mmu;
    private int mmv;
    private int mmw;
    private int mmx;
    private int mmy = -1;
    private int mmz;
    private int mna;
    private int mnb;
    private class_1799 mnc = class_1799.field_8037;
    private boolean mnd;
    private int mne;
    private boolean mnf;
    private int mng = -1;
    private final int[] mnh = new int[8];
    private boolean mni;
    private int mnj;
    private int mnk;
    private int mnl = -1;
    private float mnm;
    private float mnn;
    private volatile boolean mno;
    private volatile boolean mnp;
    private volatile boolean mnq;
    private static /* synthetic */ boolean mnr;
    private static /* synthetic */ String mns;

    public AutoCollector() {
        super("AutoCollector", "Buys your listed items on /ah", ModuleCategory.PLAYER);
        mkm = this;
    }

    public static AutoCollector get() {
        return mkm;
    }

    public static CustomItemInfo collecting() {
        AutoCollector mkl2 = mkm;
        return mkl2 != null && mkl2.isEnabled() ? mkl2.mmh : null;
    }

    public static boolean busy() {
        AutoCollector mkl2 = mkm;
        return mkl2 != null && mkl2.isEnabled() && mkl2.mmh != null;
    }

    public static void onMessage(class_2561 class_25612) {
        AutoCollector mkl2 = mkm;
        if (mkl2 == null || !mkl2.isEnabled() || mkl2.mmh == null || class_25612 == null) {
            return;
        }
        String string = class_25612.getString().toLowerCase();
        if (string.contains("этот товар уже купили")) {
            mkl2.mno = true;
        } else if (string.contains("не хватает монет")) {
            mkl2.mnp = true;
        } else if (string.contains("недоступна в режиме afk")) {
            mkl2.mnq = true;
        }
    }

    @Override
    protected void onEnable() {
        this.mpd();
        this.mpl(Lang.s("Press Start. It buys the cheapest fitting lots — watch your balance", "Нажмите «Запустить». Берёт самые дешёвые подходящие лоты — следите за балансом"), true);
    }

    @Override
    protected void onDisable() {
        this.mpd();
        this.mmg.release(this.mc);
        this.mny();
    }

    private void mnt() {
        if (this.mc.field_1724 == null) {
            return;
        }
        if (!this.isEnabled()) {
            this.setEnabled(true);
        }
        if (CollectorState.activeCount() == 0) {
            this.mpl(Lang.s("The list has no items switched on", "В списке не включено ни одного предмета"), false);
            return;
        }
        this.mmi = true;
        this.mmn.clear();
        this.mlz.reset();
        this.mmh = null;
        this.moz();
        this.mme.arm(this.mlz.draw(0));
    }

    private void mnu() {
        if (this.mmh != null || this.mmi) {
            this.mpc();
            this.mpl(Lang.s("Stopped", "Работа остановлена"), false);
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.mmg.release(class_3102);
        if (class_3102.field_1724 == null) {
            return;
        }
        if (this.mmh != null && class_3102.field_1755 instanceof class_465) {
            this.mmg.hold(class_3102);
        }
        this.mnx(class_3102);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (class_3102.field_1724 == null || class_3102.field_1687 == null) {
            return;
        }
        if (!(class_3102.field_1755 instanceof class_476)) {
            this.mmy = -1;
            this.mmr = -1;
        }
        this.mnw();
        if (this.mmh == null) {
            this.mpb();
            return;
        }
        if (this.mpk(class_3102)) {
            return;
        }
        if (class_3102.field_1724.method_31548().method_7376() == -1) {
            this.mpl(Lang.s("No free inventory slots", "Нет свободных слотов в инвентаре"), false);
            this.mpj();
            this.mpc();
            return;
        }
        this.mpe(false);
        this.mnv();
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        if (this.mmh == null || class_3102.field_1724 == null) {
            return;
        }
        if (class_3102.method_61964() != null) {
            class_3102.method_61964().method_61939();
        }
        this.mnv();
    }

    private void mnv() {
        if (this.mmh == null || this.mmj.isEmpty() || this.mc.field_1724 == null || this.mc.method_1562() == null) {
            return;
        }
        class_437 class_4372 = this.mc.field_1755;
        if (class_4372 instanceof class_476) {
            class_476 class_4762 = (class_476)class_4372;
            this.moa(class_4762);
            return;
        }
        if (this.mc.field_1755 != null || this.mnj > 0) {
            return;
        }
        if (this.mc.field_1724.field_6012 < 200 || !this.mme.ready()) {
            return;
        }
        if (this.mmm >= 3) {
            this.mon();
            return;
        }
        if (!this.mph()) {
            return;
        }
        this.mc.method_1562().method_45730("ah search " + this.mmj);
        this.mme.arm(this.mlz.draw(4, this.mpi()));
        this.mml = 0;
        ++this.mmm;
    }

    private void mnw() {
        if (this.mnq) {
            this.mnq = false;
            this.mnj = ThreadLocalRandom.current().nextInt(24, 54);
            this.mnk = 0;
        }
        if (this.mno) {
            this.mno = false;
            this.mmm = Math.max(0, this.mmm - 1);
            this.moq();
        }
        if (this.mnp) {
            this.mnp = false;
            if (this.mmh != null) {
                this.mpl(Lang.s("Out of coins", "Не хватает монет на аккаунте"), false);
                this.mpj();
                this.mpc();
            }
        }
    }

    private void mnx(class_310 class_3102) {
        if (this.mnj <= 0) {
            return;
        }
        if (class_3102.field_1755 != null) {
            this.mnj = 0;
            this.mny();
            return;
        }
        --this.mnj;
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        if (--this.mnk <= 0) {
            this.mnk = threadLocalRandom.nextInt(4, 12);
            this.mnl = threadLocalRandom.nextInt(5);
        }
        class_304[] class_304Array = AutoCollector.mnz(class_3102.field_1690);
        for (int i = 0; i < class_304Array.length; ++i) {
            class_304Array[i].method_23481(this.mnl == i);
        }
        this.mnm = this.mnm * 0.85f + (float)threadLocalRandom.nextGaussian() * 0.9f;
        this.mnn = this.mnn * 0.85f + (float)threadLocalRandom.nextGaussian() * 0.45f;
        float f = class_3102.field_1724.method_36455();
        float f2 = f + this.mnn > 80.0f || f + this.mnn < -80.0f ? -this.mnn : this.mnn;
        class_3102.field_1724.method_5872((double)this.mnm / 0.15, (double)f2 / 0.15);
        if (this.mnj == 0) {
            this.mny();
        }
    }

    private void mny() {
        if (this.mnl < 0 || this.mc.field_1690 == null || this.mc.method_22683() == null) {
            return;
        }
        this.mnl = -1;
        for (class_304 class_3042 : AutoCollector.mnz(this.mc.field_1690)) {
            class_3042.method_23481(KeyUtil.isPhysicallyDown(this.mc, class_3042));
        }
    }

    private static class_304[] mnz(class_315 class_3152) {
        return new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849};
    }

    private void moa(class_476 class_4762) {
        boolean bl;
        class_1703 class_17032 = class_4762.method_17577();
        String string = EnchantNameUtil.title(class_4762.method_25440().getString());
        if (class_17032.field_7763 != this.mmy) {
            this.mmy = class_17032.field_7763;
            this.mmb.arm(this.mlz.draw(0));
            this.mmd.restart();
            if (this.mmr >= 0) {
                this.mmt = true;
                this.mmu = 0;
                this.mmv = 0;
                this.mmr = -1;
            }
            return;
        }
        if (!IdleTracker.serverIdle(this.mc.field_1724)) {
            return;
        }
        if (AutoCollector.mob(string)) {
            if (this.mnd) {
                if (this.mma.elapsed(1400L)) {
                    this.mnd = false;
                    if (++this.mne >= 4) {
                        this.mpl(Lang.s("No buy button in the confirm window", "В окне подтверждения нет кнопки покупки"), false);
                        this.mne = 0;
                        this.mpj();
                    }
                }
                return;
            }
            if (this.mmb.ready() && this.mma.ready()) {
                class_1735 class_17352 = AutoCollector.moj(AutoCollector.mor(class_17032), "купить");
                if (class_17352 != null) {
                    this.mop(class_17032, class_17352.field_7874, class_1713.field_7794);
                    this.mnd = true;
                } else if (++this.mne >= 4) {
                    this.mpl(Lang.s("No buy button in the confirm window", "В окне подтверждения нет кнопки покупки"), false);
                    this.mne = 0;
                    this.mpj();
                }
                this.mma.arm(this.mlz.draw(3));
            }
            return;
        }
        if (!string.contains(EnchantNameUtil.title(this.mmj))) {
            this.mpj();
            return;
        }
        this.mnd = false;
        this.mne = 0;
        if (this.mnf) {
            if (class_17032.field_7763 == this.mng && !this.mma.elapsed(1400L)) {
                return;
            }
            this.mnf = false;
            this.mpe(true);
            if (this.mmz < this.mmh.count()) {
                this.mpj();
                this.mme.arm(this.mlz.draw(6));
                return;
            }
        }
        if (this.mmz >= this.mmh.count()) {
            if (!this.mma.ready()) {
                return;
            }
            this.mpl(Lang.s("Collected: ", "Предмет собран: ") + this.mmh.name(), true);
            this.moz();
            this.mpj();
            return;
        }
        if (!this.mmb.ready() || !this.mma.ready()) {
            return;
        }
        int[] nArray = AutoCollector.moe(class_17032, string);
        int n = nArray[0];
        int n2 = nArray[1];
        boolean bl2 = bl = !AutoCollector.moc(AutoCollector.mor(class_17032)) || n2 > 1 && !AutoCollector.moc(AutoCollector.mos(class_17032)) || nArray[2] == 0 && (this.mly.target() != null || this.mmr >= 0);
        if (bl) {
            if (this.mmd.elapsed(3000L)) {
                this.mom();
            }
            return;
        }
        this.mmd.restart();
        if (this.mog(n)) {
            return;
        }
        Arrays.fill(this.mnh, 0);
        this.mma.arm(this.mlz.draw(1));
        this.mod(class_17032, n, n2);
    }

    private static boolean mob(String string) {
        for (String string2 : mkq) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private static boolean moc(List<class_1735> list) {
        for (class_1735 class_17352 : list) {
            if (class_17352.method_7677().method_7960()) continue;
            return true;
        }
        return false;
    }

    private void mod(class_1703 class_17032, int n, int n2) {
        int n3 = Math.min(16, n2);
        pfw pfw2 = this.mly.target();
        if (pfw2 == null) {
            if (this.mly.markPage(n)) {
                for (class_1735 class_17352 : AutoCollector.mos(class_17032)) {
                    if (!this.mou(class_17352.method_7677())) continue;
                    this.mly.offer(n, ClaimTooltipParser.of(class_17352.method_7677()));
                }
            }
            if (!(n >= n3 || n >= 3 && this.mly.enough())) {
                this.moh(class_17032, n, mkn);
            } else if (!this.mly.choose(n)) {
                this.mom();
            }
            return;
        }
        if (pfw2.page() > n2) {
            this.mpl(Lang.s("The lot is gone, scanning again", "Оффер пропал, пересканирую"), false);
            this.moq();
            return;
        }
        if (n == pfw2.page()) {
            class_1735 class_17353 = null;
            int n4 = Integer.MAX_VALUE;
            for (class_1735 class_17354 : AutoCollector.mos(class_17032)) {
                int n5;
                if (!this.mou(class_17354.method_7677()) || (n5 = ClaimTooltipParser.of(class_17354.method_7677())) > pfw2.price() || n5 >= n4) continue;
                class_17353 = class_17354;
                n4 = n5;
            }
            if (class_17353 != null) {
                this.moo(class_17032, class_17353.field_7874);
                return;
            }
            this.mpl(Lang.s("The lot is gone, scanning again", "Оффер пропал, пересканирую"), false);
            if (this.mly.dropTarget() == null) {
                this.mom();
            }
            return;
        }
        this.moh(class_17032, n, n < pfw2.page() ? mkn : mko);
    }

    private static int[] moe(class_1703 class_17032, String string) {
        int[] nArray = AutoCollector.mof(string);
        if (nArray == null) {
            class_1735 class_17352;
            class_1799 class_17992;
            Iterator<class_1735> iterator = AutoCollector.mot(class_17032).iterator();
            while (iterator.hasNext() && ((class_17992 = (class_17352 = iterator.next()).method_7677()).method_7960() || (nArray = AutoCollector.mof(EnchantNameUtil.title(class_17992.method_7964().getString()))) == null)) {
            }
        }
        if (nArray == null) {
            return new int[]{1, 1, 0};
        }
        int n = Math.max(1, nArray[1]);
        return new int[]{Math.min(Math.max(1, nArray[0]), n), n, 1};
    }

    private static int[] mof(String string) {
        Matcher matcher = mkr.matcher(string);
        while (matcher.find()) {
            try {
                return new int[]{Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))};
            }
            catch (NumberFormatException numberFormatException) {
            }
        }
        return null;
    }

    private boolean mog(int n) {
        if (this.mmr < 0) {
            return false;
        }
        if (n != this.mmr) {
            this.mmr = -1;
            this.mmt = true;
            this.mmu = 0;
            this.mmv = 0;
            return false;
        }
        if (this.mmc.elapsed(1500L)) {
            this.mmr = -1;
            ++this.mmv;
            if (!this.mmt && ++this.mmu >= 2) {
                this.mms = this.mms == class_1713.field_7790 ? class_1713.field_7794 : class_1713.field_7790;
                this.mmu = 0;
            }
            return false;
        }
        return true;
    }

    private void moh(class_1703 class_17032, int n, String[] stringArray) {
        if (this.mmv >= 3 || ++this.mmw > 40) {
            this.mpl(Lang.s("The pager doesn't respond, searching again", "Листалка не отвечает, ищу заново"), false);
            this.mom();
            return;
        }
        class_1735 class_17352 = AutoCollector.moi(class_17032, stringArray);
        if (class_17352 == null) {
            this.mok(class_17032);
            return;
        }
        this.mmx = 0;
        this.mop(class_17032, class_17352.field_7874, this.mms);
        this.mmr = n;
        this.mmc.restart();
        this.mma.arm(this.mlz.draw(2));
    }

    private static class_1735 moi(class_1703 class_17032, String[] stringArray) {
        for (String string : stringArray) {
            class_1735 class_17352 = AutoCollector.moj(AutoCollector.mot(class_17032), string);
            if (class_17352 == null) continue;
            return class_17352;
        }
        return AutoCollector.moj(AutoCollector.mos(class_17032), stringArray[0]);
    }

    private static class_1735 moj(List<class_1735> list, String string) {
        for (class_1735 class_17352 : list) {
            class_1799 class_17992 = class_17352.method_7677();
            if (class_17992.method_7960() || !EnchantNameUtil.title(class_17992.method_7964().getString()).contains(string)) continue;
            return class_17352;
        }
        return null;
    }

    private void mok(class_1703 class_17032) {
        if (++this.mmx < 6) {
            this.mma.arm(this.mlz.draw(2));
            return;
        }
        this.mpl(Lang.s("No page buttons in the window", "В окне нет кнопки листания страниц"), false);
        this.mmx = 0;
        this.moq();
        class_1735 class_17352 = this.mol(class_17032);
        if (class_17352 != null) {
            this.moo(class_17032, class_17352.field_7874);
        } else {
            this.mom();
        }
    }

    private class_1735 mol(class_1703 class_17032) {
        class_1735 class_173522;
        int n = Integer.MAX_VALUE;
        for (class_1735 class_173522 : AutoCollector.mos(class_17032)) {
            if (!this.mou(class_173522.method_7677())) continue;
            n = Math.min(n, ClaimTooltipParser.of(class_173522.method_7677()));
        }
        if (n == Integer.MAX_VALUE) {
            return null;
        }
        int n2 = this.mmh.count() - this.mmz;
        class_173522 = null;
        class_1735 class_17353 = null;
        for (class_1735 class_17354 : AutoCollector.mos(class_17032)) {
            int n3;
            if (this.mov(class_17354.method_7677()) != 0 || (n3 = ClaimTooltipParser.of(class_17354.method_7677())) > n * 2) continue;
            if (class_17353 == null || n3 < ClaimTooltipParser.of(class_17353.method_7677())) {
                class_17353 = class_17354;
            }
            if (class_17354.method_7677().method_7947() < n2 || class_173522 != null && n3 >= ClaimTooltipParser.of(class_173522.method_7677())) continue;
            class_173522 = class_17354;
        }
        return class_173522 != null ? class_173522 : class_17353;
    }

    private void mom() {
        this.moq();
        this.mpj();
        String string = this.mmh.item().method_63680().getString();
        if (!(this.mml != 0 || this.mmk || this.mmh.hasQuery() || string.equalsIgnoreCase(this.mmj))) {
            this.mmk = true;
            this.mmj = string;
            this.mmm = 0;
            this.mpl(Lang.s("Searching by the item name: ", "Ищу по названию предмета: ") + string, false);
        } else if (this.mmm >= 3) {
            this.mon();
            return;
        }
        this.mme.arm(this.mlz.draw(4, this.mpi()));
    }

    private void mon() {
        this.mmn.put(this.mmh, System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(90000L, 210000L));
        this.mpl(Lang.s("No fitting lot: ", "Нет подходящего лота: ") + this.mmh.name() + this.mox(), false);
        this.moz();
    }

    private void moo(class_1703 class_17032, int n) {
        this.mop(class_17032, n, class_1713.field_7794);
        this.mng = class_17032.field_7763;
        this.mma.arm(this.mlz.draw(3));
        this.mme.arm(this.mlz.draw(6));
        this.moq();
        this.mnf = true;
        this.mmm = 0;
        this.mna = 1;
    }

    private void mop(class_1703 class_17032, int n, class_1713 class_17132) {
        this.mc.field_1761.method_2906(class_17032.field_7763, n, 0, class_17132, (class_1657)this.mc.field_1724);
    }

    private void moq() {
        this.mly.release();
        this.mmr = -1;
        this.mmv = 0;
        this.mmw = 0;
        this.mmx = 0;
    }

    private static List<class_1735> mor(class_1703 class_17032) {
        int n;
        if (class_17032 instanceof class_1707) {
            class_1707 class_17072 = (class_1707)class_17032;
            n = class_17072.method_17388() * 9;
        } else {
            n = class_17032.field_7761.size();
        }
        int n2 = n;
        return class_17032.field_7761.subList(0, Math.min(Math.max(n2, 0), class_17032.field_7761.size()));
    }

    private static List<class_1735> mos(class_1703 class_17032) {
        List<class_1735> list = AutoCollector.mor(class_17032);
        return list.size() > 9 ? list.subList(0, list.size() - 9) : list;
    }

    private static List<class_1735> mot(class_1703 class_17032) {
        List<class_1735> list = AutoCollector.mor(class_17032);
        return list.size() > 9 ? list.subList(list.size() - 9, list.size()) : list;
    }

    private boolean mou(class_1799 class_17992) {
        int n = this.mov(class_17992);
        if (this.mmh != null && class_17992.method_31574(this.mmh.item())) {
            int n2 = n;
            this.mnh[n2] = this.mnh[n2] + 1;
            ++this.mml;
        }
        return n == 0;
    }

    private int mov(class_1799 class_17992) {
        if (class_17992.method_7960() || this.mmh == null || !this.mmh.matches(class_17992, new ItemSnapshot(class_17992))) {
            return 1;
        }
        if (!(this.mmh.hasEffects() || this.mnc.method_7960() || Objects.equals(class_17992.method_58694(class_9334.field_49651), this.mnc.method_58694(class_9334.field_49651)))) {
            return 2;
        }
        if (ClaimTooltipParser.claimed(class_17992)) {
            return 3;
        }
        if (ClaimTooltipParser.of(class_17992) <= 0) {
            return 4;
        }
        if (class_17992.method_7947() > this.mnb) {
            return 7;
        }
        if (this.mmh.item() == class_1802.field_8288 && !this.mmh.hasAttrs() && class_17992.method_7958()) {
            return 5;
        }
        Integer n = (Integer)class_17992.method_58694(class_9334.field_49629);
        int n2 = class_17992.method_7936();
        if (n == null || n2 <= 0) {
            return 0;
        }
        if (this.mmh.item() == class_1802.field_8833) {
            return (float)(n2 - n) / (float)n2 >= 0.5f ? 0 : 6;
        }
        if (!AutoCollector.mow(class_17992)) {
            return 0;
        }
        boolean bl = false;
        for (ItemRule phm2 : this.mmh.rules()) {
            if (phm2.state() != phj.ON || !class_1893.field_9101.method_29177().toString().equals(phm2.key())) continue;
            bl = true;
        }
        return bl || (float)(n2 - n) / (float)n2 >= 0.7f ? 0 : 6;
    }

    private static boolean mow(class_1799 class_17992) {
        class_10192 class_101922 = (class_10192)class_17992.method_58694(class_9334.field_54196);
        return class_101922 != null && class_101922.comp_3174().method_46643();
    }

    private String mox() {
        StringBuilder stringBuilder = new StringBuilder();
        AutoCollector.moy(stringBuilder, Lang.s(" · conditions ", " · условия "), this.mnh[1]);
        AutoCollector.moy(stringBuilder, Lang.s(" · other potion ", " · другое зелье "), this.mnh[2]);
        AutoCollector.moy(stringBuilder, Lang.s(" · already bought ", " · уже куплен "), this.mnh[3]);
        AutoCollector.moy(stringBuilder, Lang.s(" · no price ", " · нет цены "), this.mnh[4]);
        AutoCollector.moy(stringBuilder, Lang.s(" · glint ", " · блеск "), this.mnh[5]);
        AutoCollector.moy(stringBuilder, Lang.s(" · durability ", " · прочность "), this.mnh[6]);
        AutoCollector.moy(stringBuilder, Lang.s(" · lot size ", " · размер лота "), this.mnh[7]);
        return stringBuilder.toString();
    }

    private static void moy(StringBuilder stringBuilder, String string, int n) {
        if (n > 0) {
            stringBuilder.append(string).append(n);
        }
    }

    private void moz() {
        List<CustomItemInfo> list = CollectorState.items();
        int n = this.mmh == null ? 0 : list.indexOf(this.mmh) + 1;
        this.moq();
        this.mne = 0;
        this.mnd = false;
        this.mnf = false;
        this.mmm = 0;
        this.mmk = false;
        this.mml = 0;
        this.mmh = this.mpa(list, Math.max(0, n));
        this.mme.arm(this.mlz.draw(5));
        if (this.mmh != null) {
            this.mmj = this.mmh.query();
            this.mmo = false;
            this.mpe(true);
            this.mpl(Lang.s("Collecting: ", "Собираем: ") + this.mmh.name(), true);
            return;
        }
        this.mmj = "";
        if (this.mmn.isEmpty()) {
            if (this.mmi) {
                this.mpl(Lang.s("Everything is collected", "Все предметы собраны, работа завершена"), true);
            }
            this.mmi = false;
        } else if (!this.mmo) {
            this.mmo = true;
            this.mpl(Lang.s("All left items are put off, back to them later", "Все строки отложены, вернусь к ним позже"), true);
        }
    }

    private CustomItemInfo mpa(List<CustomItemInfo> list, int n) {
        long l = System.currentTimeMillis();
        this.mmn.values().removeIf(l2 -> l2 <= l);
        for (int i = 0; i < list.size(); ++i) {
            CustomItemInfo pdr2 = list.get((n + i) % list.size());
            if (!pdr2.active() || this.mmn.containsKey(pdr2) || this.mpf(pdr2) >= pdr2.count()) continue;
            return pdr2;
        }
        return null;
    }

    private void mpb() {
        if (!this.mmi || this.mmn.isEmpty() || !this.mmf.elapsed(2500L)) {
            return;
        }
        this.mmf.restart();
        this.moz();
    }

    private void mpc() {
        this.mmh = null;
        this.mmi = false;
        this.mmo = false;
        this.mmj = "";
        this.mmn.clear();
        this.moq();
        this.mnd = false;
        this.mnf = false;
        this.mmm = 0;
        this.mmk = false;
        this.mml = 0;
    }

    private void mpd() {
        this.mpc();
        this.mms = class_1713.field_7790;
        this.mmt = false;
        this.mmu = 0;
        this.mne = 0;
        this.mmy = -1;
        this.mnj = 0;
        this.mnk = 0;
        this.mnm = 0.0f;
        this.mnn = 0.0f;
        this.mni = false;
        this.mmz = 0;
        this.mna = 0;
        this.mnb = 0;
        this.mnc = class_1799.field_8037;
        this.mno = false;
        this.mnp = false;
        this.mnq = false;
    }

    private void mpe(boolean bl) {
        if (this.mmh == null || !bl && --this.mna > 0) {
            return;
        }
        this.mna = 4;
        this.mmz = this.mpf(this.mmh);
        this.mnc = this.mmh.isPotion() && !this.mmh.hasEffects() ? this.mpg(this.mmh) : class_1799.field_8037;
        int n = this.mmh.count() + Math.round((float)this.mmh.count() * 0.2f);
        this.mnb = Math.max(n - this.mmz, this.mmh.count());
    }

    private int mpf(CustomItemInfo pdr2) {
        if (this.mc.field_1724 == null) {
            return 0;
        }
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        int n = 0;
        for (int i = 0; i < 41; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || !pdr2.matches(class_17992)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private class_1799 mpg(CustomItemInfo pdr2) {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        for (int i = 0; i < 41; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || !pdr2.matches(class_17992)) continue;
            return class_17992;
        }
        return class_1799.field_8037;
    }

    private boolean mph() {
        long l = System.currentTimeMillis();
        this.mmp = Math.min(6.0, this.mmp + (double)(l - this.mmq) / 4000.0);
        this.mmq = l;
        if (this.mmp < 1.0) {
            return false;
        }
        this.mmp -= 1.0;
        return true;
    }

    private double mpi() {
        return 1 << Math.min(this.mmm, 3);
    }

    private void mpj() {
        this.mmr = -1;
        this.mmx = 0;
        this.mmy = -1;
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462 != null && this.mc.field_1755 instanceof class_476) {
            class_7462.method_7346();
        }
    }

    private boolean mpk(class_310 class_3102) {
        boolean bl = KeyUtil.isDown(class_3102, 256);
        if (class_3102.field_1755 instanceof ClickGuiScreen) {
            this.mni = bl;
            return false;
        }
        if (bl && !this.mni) {
            this.mni = true;
            this.mpc();
            this.mpl(Lang.s("Stopped by Esc", "Работа остановлена (Esc)"), false);
            return true;
        }
        this.mni = bl;
        return false;
    }

    private void mpl(String string, boolean bl) {
        if (this.mlx.get()) {
            Hud.alert(this.getName(), string, bl ? Icon.CHECK : Icon.INFO, bl);
        }
    }

    static {
        mkp = "купить";
        mkn = new String[]{"следующ", "впер", "»", "→"};
        mko = new String[]{"предыдущ", "назад", "«", "←"};
        mkq = new String[]{"подтверждение покупки", "подозрительная цена"};
        mkr = Pattern.compile("(\\d+)\\s*/\\s*(\\d+)");
    }

    private static /* synthetic */ int bbm(int n, int n2) {
        return n ^ n2 | 0xBB5D6092;
    }

    private static /* synthetic */ int bbn(int n, int n2) {
        return AutoCollector.bbm(n, n2) + n;
    }
}

