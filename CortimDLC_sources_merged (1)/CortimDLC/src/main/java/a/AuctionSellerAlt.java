/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_2818
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_3719
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_638
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  net.minecraft.class_9290
 *  net.minecraft.class_9304
 *  net.minecraft.class_9334
 */
package a;

import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.nmc;
import a.AutoLoot;
import a.AuctionRateLimiter;
import a.EnchantNameUtil;
import a.HumanDelays;
import a.AimPersonalizer;
import a.MouseQuantizer;
import a.RotationUtil;
import a.CameraOwner;
import a.Icon;
import a.BoolSetting;
import a.NumberSetting;
import a.Reflect;
import a.IdleTracker;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_2818;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_3719;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import net.minecraft.class_9290;
import net.minecraft.class_9304;
import net.minecraft.class_9334;

public class AuctionSellerAlt
extends Module {
    private static final String nmh = "ah search ";
    private static final String nmi = "ah sell ";
    private static final String nmj = "ah";
    private static final String nmk = "хранилищ";
    private static final String nml = "перевыстав";
    private static final String nmm = "аукцион";
    private static final String nmn = "цен";
    private static final String nmo = "price";
    private static final String nmp = "чтобы забрать";
    private static final String nmq = "не актуал";
    private static final String nmr = "продав";
    private static final String nms = "владел";
    private static final String[] nmt = new String[]{"не так быстро", "слишком быстро", "слишком часто", "подожди", "cooldown"};
    private static final String[] nmu = new String[]{"не найд", "не существ", "нет предмет", "лимит", "нельзя", "запрещ", "недостаточно", "не хватает", "слишком", "ошибк", "не удал"};
    private static final String[] nmv = new String[]{"освобод", "аренд"};
    private static final int nmw = 36;
    private static final double nmx = 0.75;
    private static final long nmy = 180000L;
    private static final long nmz = 120000L;
    private static final long nna = 110L;
    private static final long nnb = 360L;
    private static final long nnc = 260L;
    private static final long nnd = 4000L;
    private static final long nne = 4000L;
    private static final long nnf = 20000L;
    private static final long nng = 850L;
    private static final long nnh = 900L;
    private static final long nni = 3500L;
    private static final double nnj = 1.4;
    private static final double nnk = 1500.0;
    private static final double nnl = 0.75;
    private static final long nnm = 25000L;
    private static final int nnn = 3;
    private static final long nno = 60000L;
    private static final long nnp = 380L;
    private static final double nnq = 4.3;
    private static final long nnr = 60000L;
    private static final long nns = 1500L;
    private static final long nnt = 3000L;
    private static final int nnu = 64;
    private static final int nnv = 0;
    private static final int nnw = 1;
    private static final int nnx = 2;
    private static final int nny = 3;
    private static final Field nnz = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field noa = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static AuctionSellerAlt nob;
    private final NumberSetting noc = this.add(new NumberSetting("Ниже рынка", 5.0, 1.0, 50.0, 1.0).suffix("%"));
    private final NumberSetting nod = this.add(new NumberSetting("Схожесть чар", 60.0, 0.0, 100.0, 5.0).suffix("%"));
    private final BoolSetting noe = this.add(new BoolSetting("Хотбар тоже", false));
    private final NumberSetting nof = this.add(new NumberSetting("Поисков в минуту", 20.0, 4.0, 40.0, 1.0));
    private final BoolSetting nog = this.add(new BoolSetting("Из сундуков", true));
    private nmc noh = nmc.IDLE;
    private long noi;
    private long noj;
    private long nok;
    private long nol;
    private long nom = -1L;
    private int non = 0;
    private long noo;
    private long nop;
    private long noq = 360L;
    private long nor;
    private long nos;
    private int not;
    private long nou;
    private int nov;
    private int now = 8;
    private boolean nox;
    private class_1799 noy = class_1799.field_8037;
    private String noz = "";
    private String npa = "";
    private final Set<String> npb = new HashSet<String>();
    private final Map<String, long[]> npc = new HashMap<String, long[]>();
    private int npd = -1;
    private int npe;
    private int npf;
    private long npg;
    private boolean nph;
    private int npi = -1;
    private int npj = -1;
    private int npk = -1;
    private int npl = -1;
    private boolean npm;
    private final IdleTracker npn = new IdleTracker();
    private long npo;
    private long npp;
    private boolean npq;
    private int npr = -1;
    private int nps = -1;
    private long npt;
    private int npu = 0;
    private String npv = "";
    private final Map<class_2338, Long> npw = new HashMap<class_2338, Long>();
    private class_2338 npx;
    private class_2338 npy;
    private class_243 npz;
    private double nqa;
    private double nqb;
    private double nqc;
    private int nqd;
    private long nqe;
    private boolean nqf;
    private int nqg;
    private int nqh;
    private int nqi;
    private int nqj = -1;
    private int nqk = -1;
    private class_1799[] nql;
    private final boolean[] nqm = new boolean[9];
    private boolean nqn;
    private final HumanDelays nqo = new HumanDelays();
    private final AimPersonalizer nqp = new AimPersonalizer();
    private class_746 nqq;
    private boolean nqr;
    private long nqs;
    private static /* synthetic */ String nqt;
    private static /* synthetic */ int nqu;

    public AuctionSellerAlt() {
        super("AutoSell", "Sells your inventory on /ah under market", ModuleCategory.PLAYER);
        nob = this;
    }

    public static void onMessage(class_2561 class_25612) {
        AuctionSellerAlt nmg2 = nob;
        if (nmg2 != null && nmg2.isEnabled()) {
            nmg2.nqv(class_25612);
        }
    }

    @Override
    protected void onEnable() {
        this.num();
        this.npb.clear();
        this.npw.clear();
        this.nqn = false;
        this.nqo.reset();
        this.nov = 0;
        this.now = AuctionSellerAlt.nug();
        this.npl = this.mc.field_1724 == null ? -1 : this.mc.field_1724.method_31548().method_67532();
        long l = System.currentTimeMillis();
        this.npc.values().removeIf(lArray -> l - lArray[1] > 180000L);
        this.nop = l + 260L + ThreadLocalRandom.current().nextLong(0L, 340L);
        this.nok = Math.max(this.nok, l + AuctionSellerAlt.nuf());
    }

    @Override
    protected void onDisable() {
        this.num();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.nsg();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.method_1562() == null) {
            if (this.noh != nmc.IDLE) {
                this.num();
            }
            return;
        }
        if (this.npm) {
            this.npn.hold(class_3102);
        }
        if (this.nqr && this.noh == nmc.CHEST_OPEN) {
            this.nsh();
        }
        if (this.noh == nmc.IDLE) {
            class_437 class_4372 = class_3102.field_1755;
            if (class_4372 != null && !(class_4372 instanceof class_465)) {
                return;
            }
            if (System.currentTimeMillis() < this.nop) {
                return;
            }
            if (!this.nqw() && !this.nrw()) {
                this.nra();
            }
            return;
        }
        if (this.noh.nmd > 0L && System.currentTimeMillis() - this.noi > this.noh.nmd) {
            if (this.noh == nmc.RESTORE) {
                this.nrl();
            } else if (this.noh == nmc.CHEST_OPEN) {
                this.nsc(System.currentTimeMillis() + 60000L, Lang.s("The chest didn't open", "Сундук не открылся"), false, 0);
            } else if (this.noh == nmc.CHEST_LOOT) {
                this.nsd();
                this.nsc(0L, null, true, 2);
            } else if (this.nrs()) {
                this.nun(Lang.s("The storage didn't open", "Хранилище не открылось"), false);
                this.nrr();
            } else {
                this.nqz(Lang.s("The auction is silent: ", "Аукцион молчит: ") + this.npa, false, true);
            }
            return;
        }
        switch (this.noh.ordinal()) {
            case 1: {
                this.nrb();
                break;
            }
            case 2: {
                this.nrc();
                break;
            }
            case 3: {
                this.nrd();
                break;
            }
            case 4: {
                this.nri();
                break;
            }
            case 5: {
                this.nrj();
                break;
            }
            case 6: {
                this.nrk();
                break;
            }
            case 7: {
                this.nrn();
                break;
            }
            case 8: {
                this.nro();
                break;
            }
            case 9: {
                this.nrp();
                break;
            }
            case 10: {
                this.nrq();
                break;
            }
            case 11: {
                this.nry();
                break;
            }
            case 12: {
                this.nsb();
                break;
            }
        }
    }

    private void nqv(class_2561 class_25612) {
        if (this.noh == nmc.IDLE || this.nrs() || System.currentTimeMillis() - this.noo > 4000L) {
            return;
        }
        String string = AuctionSellerAlt.nto(class_25612.getString());
        if (string.isEmpty()) {
            return;
        }
        if (AuctionSellerAlt.ntp(string)) {
            this.npu = 3;
        } else if (AuctionSellerAlt.ntq(string, nmt)) {
            this.npu = 1;
        } else if (AuctionSellerAlt.ntq(string, nmu)) {
            this.npv = string.length() > 48 ? string.substring(0, 48) : string;
            this.npu = 2;
        }
    }

    private boolean nqw() {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        for (int i = 0; i < 2; ++i) {
            int n = i == 0 ? 9 : 0;
            int n2 = i == 0 ? 36 : 9;
            for (int j = n; j < n2; ++j) {
                String string;
                class_1799 class_17992;
                if (!this.nqx(j) || (class_17992 = class_16612.method_5438(j)).method_7960() || this.npb.contains(string = AuctionSellerAlt.nti(class_17992))) continue;
                String string2 = AuctionSellerAlt.cleanQuery(class_17992.method_7964().getString());
                if (string2.isEmpty()) {
                    this.npb.add(string);
                    continue;
                }
                this.noy = class_17992.method_7972();
                this.noz = string;
                this.npa = string2;
                this.npd = -1;
                this.npf = 0;
                this.npu = 0;
                this.npv = "";
                this.npq = false;
                this.noq = 360L + ThreadLocalRandom.current().nextLong(0L, 260L);
                this.nun(Lang.s("Selling: ", "Продаю: ") + this.npa, true);
                this.nul(nmc.TAKE);
                return true;
            }
        }
        return false;
    }

    private boolean nqx(int n) {
        if (n == this.npk) {
            return false;
        }
        if (n >= 9) {
            return true;
        }
        return this.noe.get() || n == this.npi || this.nqy(n);
    }

    private boolean nqy(int n) {
        if (!this.nqm[n]) {
            return false;
        }
        if (this.mc.field_1724.method_31548().method_5438(n).method_7960()) {
            this.nqm[n] = false;
            return false;
        }
        return true;
    }

    private void nqz(String string, boolean bl, boolean bl2) {
        if (bl2 && !this.noz.isEmpty()) {
            this.npb.add(this.noz);
        }
        if (string != null) {
            long l = System.currentTimeMillis();
            if (bl || l - this.nor > 4000L) {
                if (!bl) {
                    this.nor = l;
                }
                this.nun(string, bl);
            }
        }
        this.npq = false;
        this.npd = -1;
        this.npf = 0;
        this.npu = 0;
        this.npv = "";
        this.noy = class_1799.field_8037;
        this.noz = "";
        this.npa = "";
        this.nty();
        this.nop = System.currentTimeMillis() + 260L + ThreadLocalRandom.current().nextLong(0L, 300L);
        this.nul(nmc.IDLE);
    }

    private void nra() {
        this.nun(this.npe > 0 ? Lang.s("Done, lots: ", "Готово, лотов: ") + this.npe : Lang.s("Nothing to sell", "Продавать нечего"), this.npe > 0);
        this.nph = true;
        this.nul(nmc.RESTORE);
    }

    private void nrb() {
        if (this.ntv()) {
            return;
        }
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        if (this.nqx(class_16612.method_67532()) && AuctionSellerAlt.ntj(this.mc.field_1724.method_6047(), this.noy)) {
            this.nty();
            this.nul(nmc.SEARCH);
            return;
        }
        int n = this.ntr();
        if (n < 0) {
            this.nqz(null, true, false);
            return;
        }
        if (n < 9) {
            this.nty();
            if (!this.nub()) {
                return;
            }
            class_16612.method_61496(n);
            this.nul(nmc.SEARCH);
            return;
        }
        if (!this.ntw()) {
            return;
        }
        int n2 = this.ntt();
        boolean bl = !class_16612.method_5438(n2).method_7960();
        this.ntz(AuctionSellerAlt.ntu(n), class_1713.field_7791, n2);
        this.npi = n2;
        if (bl && this.npj < 0) {
            this.npj = n2;
            this.npk = n;
        }
    }

    private void nrc() {
        long l;
        long[] lArray;
        this.nty();
        if (this.ntv()) {
            return;
        }
        String string = AuctionSellerAlt.cleanQuery(this.mc.field_1724.method_6047().method_7964().getString());
        if (!string.isEmpty()) {
            this.npa = string;
        }
        if ((lArray = this.nrh(this.noz, l = System.currentTimeMillis(), 180000L)) != null) {
            if (lArray[0] > 0L) {
                this.nul(nmc.SEND);
            } else {
                this.nqz(Lang.s("No price: ", "Нет цены: ") + this.npa, false, true);
            }
            return;
        }
        if (!this.nud(l, 0)) {
            return;
        }
        this.npq = true;
        this.nps = -1;
        this.npt = 0L;
        this.npr = this.mc.field_1724.field_7512 == null ? -1 : this.mc.field_1724.field_7512.field_7763;
        this.npu = 0;
        this.nua("ah search " + this.npa);
        this.nul(nmc.SCAN);
    }

    private void nrd() {
        this.nty();
        if (this.npu == 3) {
            this.nrm();
            return;
        }
        if (this.npu == 2) {
            this.nuk();
            return;
        }
        if (this.npu == 1) {
            if (this.nuj()) {
                this.nul(nmc.SEARCH);
            }
            return;
        }
        List<class_1799> list = this.nre();
        if (list == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.npt < this.noq) {
            return;
        }
        this.npq = false;
        this.nrf(list, l);
        long[] lArray = this.nrh(this.noz, l, 180000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.nqz(Lang.s("No price: ", "Нет цены: ") + this.npa, false, true);
            return;
        }
        this.nou = l + AuctionSellerAlt.nuh(900L, 0.45, 350L, 3500L);
        this.nul(nmc.SEND);
    }

    private List<class_1799> nre() {
        if (!this.npq || !(this.mc.field_1755 instanceof class_465)) {
            return null;
        }
        class_1703 class_17032 = this.mc.field_1724.field_7512;
        if (!(class_17032 instanceof class_1707) || class_17032.field_7763 == this.npr) {
            return null;
        }
        int n = class_17032.field_7761.size() - 36;
        boolean bl = false;
        for (int i = 0; i < n && !bl; ++i) {
            bl = !((class_1735)class_17032.field_7761.get(i)).method_7677().method_7960();
        }
        if (!bl) {
            return null;
        }
        if (class_17032.field_7763 != this.nps) {
            this.nps = class_17032.field_7763;
            this.npt = System.currentTimeMillis();
        }
        ArrayList<class_1799> arrayList = new ArrayList<class_1799>(class_17032.field_7761.size());
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            arrayList.add(((class_1735)class_17032.field_7761.get(i)).method_7677().method_7972());
        }
        return arrayList;
    }

    private void nrf(List<class_1799> list, long l) {
        this.nrg(this.noz, this.nsz(list, this.noy), l);
        String string = this.npa;
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        for (int i = 0; i < 36; ++i) {
            String string2;
            class_1799 class_17992;
            if (!this.nqx(i) || (class_17992 = class_16612.method_5438(i)).method_7960() || class_17992.method_7909() != this.noy.method_7909() || (string2 = AuctionSellerAlt.nti(class_17992)).equals(this.noz) || this.npb.contains(string2) || !string.equals(AuctionSellerAlt.cleanQuery(class_17992.method_7964().getString()))) continue;
            this.nrg(string2, this.nsz(list, class_17992), l);
        }
    }

    private void nrg(String string, int n, long l) {
        this.npc.put(string, new long[]{n > 0 ? (long)n : -1L, l});
    }

    private long[] nrh(String string, long l, long l2) {
        long[] lArray = this.npc.get(string);
        return lArray != null && l - lArray[1] < l2 ? lArray : null;
    }

    private void nri() {
        this.nty();
        long l = System.currentTimeMillis();
        if (l < this.nou && this.mc.field_1755 instanceof class_465) {
            this.noi = l;
            return;
        }
        if (this.ntv()) {
            return;
        }
        if (this.npu == 3) {
            this.nrm();
            return;
        }
        if (this.npu == 2) {
            this.nuk();
            return;
        }
        long[] lArray = this.nrh(this.noz, l, 300000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.nul(nmc.SEARCH);
            return;
        }
        int n = (int)lArray[0];
        class_1799 class_17992 = this.mc.field_1724.method_6047();
        if (!AuctionSellerAlt.ntj(class_17992, this.noy)) {
            if (++this.npf > 2) {
                this.nqz(Lang.s("The item left the hand", "Товар пропал из руки"), false, true);
            } else {
                this.nul(nmc.TAKE);
            }
            return;
        }
        if (!this.nud(l, 1)) {
            return;
        }
        int n2 = Math.max(1, class_17992.method_7947());
        long l2 = (long)Math.floor((double)n * (1.0 - this.noc.get() / 100.0));
        if (l2 >= (long)n) {
            l2 = (long)n - 1L;
        }
        this.npg = AuctionSellerAlt.nth(Math.max(1L, l2) * (long)n2);
        this.npd = this.nts();
        this.nua("ah sell " + this.npg);
        this.nul(nmc.CONFIRM);
    }

    private void nrj() {
        this.nty();
        if (this.ntv()) {
            return;
        }
        if (this.npu == 3) {
            this.nrm();
            return;
        }
        if (this.npu == 1) {
            if (this.nuj()) {
                this.nul(nmc.SEND);
            }
            return;
        }
        if (this.npu == 2) {
            this.nuk();
            return;
        }
        int n = this.nts();
        if (this.npd < 0 || n >= this.npd) {
            return;
        }
        ++this.npe;
        this.not = 0;
        this.npf = 0;
        this.npd = -1;
        this.nun(Lang.s("Listed for ", "Выставлено за ") + this.npg, true);
        if (++this.nov >= this.now) {
            this.nov = 0;
            this.now = AuctionSellerAlt.nug();
            this.nok = Math.max(this.nok, System.currentTimeMillis() + AuctionSellerAlt.nuh(3500L, 0.45, 1500L, 12000L));
        }
        if (n > 0) {
            this.nul(nmc.TAKE);
        } else {
            this.nqz(null, true, false);
        }
    }

    private void nrk() {
        if (this.ntv()) {
            return;
        }
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        if (this.npj >= 0 && this.npk >= 0) {
            boolean bl;
            boolean bl2 = bl = !class_16612.method_5438(this.npk).method_7960() || !class_16612.method_5438(this.npj).method_7960();
            if (bl) {
                if (!this.ntw()) {
                    return;
                }
                this.ntz(AuctionSellerAlt.ntu(this.npk), class_1713.field_7791, this.npj);
            }
            this.npj = -1;
            this.npk = -1;
            return;
        }
        this.nty();
        if (this.npl >= 0 && this.npl < 9 && class_16612.method_67532() != this.npl) {
            if (!this.nub()) {
                return;
            }
            class_16612.method_61496(this.npl);
        }
        this.nrl();
    }

    private void nrl() {
        boolean bl = this.nph;
        this.num();
        if (bl) {
            this.setEnabled(false);
        }
    }

    private void nrm() {
        this.npu = 0;
        this.npv = "";
        this.npd = -1;
        this.npq = false;
        this.nty();
        if (this.nox) {
            this.nun(Lang.s("All lot slots are taken, nowhere to sell", "Слоты лотов заняты, продавать некуда"), false);
            this.nra();
            return;
        }
        long l = System.currentTimeMillis();
        if (l >= this.npo) {
            this.nul(nmc.AH_OPEN);
            return;
        }
        this.nun(Lang.s("The storage is full, relisting in ", "Хранилище полно, перевыставлю через ") + (this.npo - l + 999L) / 1000L + Lang.s(" s", " с"), false);
        this.nul(nmc.FULL_WAIT);
    }

    private void nrn() {
        if (System.currentTimeMillis() >= this.npo) {
            this.nul(nmc.AH_OPEN);
        }
    }

    private void nro() {
        if (this.ntv()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!this.nud(l, 0)) {
            return;
        }
        this.npo = l + 60000L + ThreadLocalRandom.current().nextLong(400L, 4000L);
        this.nox = true;
        this.nua("ah");
        this.nul(nmc.AH_STORAGE);
    }

    private void nrp() {
        int n = this.nrt("хранилищ");
        if (n < 0 || !this.nrv() || !this.ntx()) {
            return;
        }
        this.ntz(n, class_1713.field_7790, 0);
        AuctionRateLimiter.note(0);
        this.nul(nmc.AH_RELIST);
    }

    private void nrq() {
        int n = this.nrt("перевыстав");
        if (n < 0 || !this.nrv() || !this.ntx()) {
            return;
        }
        int n2 = this.nru();
        if (n2 > 0) {
            this.ntz(n, class_1713.field_7790, 0);
            AuctionRateLimiter.note(0);
            this.nun(Lang.s("Relisting: ", "Перевыставляю: ") + n2, true);
        } else {
            this.nun(Lang.s("The storage is empty, the slots hold live lots", "Хранилище пустое, слоты заняты лотами"), false);
        }
        this.nrr();
    }

    private void nrr() {
        this.nty();
        this.npu = 0;
        this.npv = "";
        long l = System.currentTimeMillis();
        this.noo = 0L;
        this.nok = Math.max(this.nok, l + AuctionSellerAlt.nuh(1600L, 0.35, 900L, 4000L));
        this.noj = l + 250L + ThreadLocalRandom.current().nextLong(0L, 350L);
        this.nul(this.noy.method_7960() ? nmc.IDLE : nmc.TAKE);
    }

    private boolean nrs() {
        return this.noh == nmc.FULL_WAIT || this.noh == nmc.AH_OPEN || this.noh == nmc.AH_STORAGE || this.noh == nmc.AH_RELIST;
    }

    private int nrt(String string) {
        class_746 class_7462 = this.mc.field_1724;
        class_1703 class_17032 = class_7462.field_7512;
        if (!(this.mc.field_1755 instanceof class_465) || class_17032 == null || class_17032 == class_7462.field_7498) {
            return -1;
        }
        int n = class_17032.field_7761.size() - 36;
        if (n < 9) {
            return -1;
        }
        for (int i = n - 9; i < n; ++i) {
            class_1799 class_17992 = ((class_1735)class_17032.field_7761.get(i)).method_7677();
            if (class_17992.method_7960() || !EnchantNameUtil.title(class_17992.method_7964().getString()).contains(string)) continue;
            return i;
        }
        return -1;
    }

    private int nru() {
        class_1703 class_17032 = this.mc.field_1724.field_7512;
        int n = class_17032.field_7761.size() - 36;
        int n2 = 0;
        for (int i = 0; i < n - 9; ++i) {
            if (((class_1735)class_17032.field_7761.get(i)).method_7677().method_7960()) continue;
            ++n2;
        }
        return n2;
    }

    private boolean nrv() {
        long l;
        if (this.npp != 0L) {
            return true;
        }
        this.npp = l = System.currentTimeMillis();
        double d = AuctionSellerAlt.nui(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.25, 0.7, 1.9);
        long l2 = (long)(380.0 * d) + ThreadLocalRandom.current().nextLong(10L, 90L);
        this.noj = Math.max(this.noj, l + l2);
        return false;
    }

    private boolean nrw() {
        if (!this.nog.get()) {
            return false;
        }
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462.method_5765() || !AuctionSellerAlt.nsy(class_7462.method_31548()) || this.nsm()) {
            return false;
        }
        long l = System.currentTimeMillis();
        if (AutoLoot.listEmpty()) {
            if (!this.nqn && this.nrx(l) != null) {
                this.nqn = true;
                this.nun(Lang.s("ChestLooter's list is empty", "Список ChestLooter пуст"), false);
            }
            return false;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.nqa = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        this.nqb = (threadLocalRandom.nextDouble() - 0.5) * 0.25;
        this.nqc = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        class_2338 class_23382 = this.nrx(l);
        if (class_23382 == null) {
            return false;
        }
        this.npx = class_23382;
        this.npy = AuctionSellerAlt.nst((class_1937)this.mc.field_1687, class_23382);
        this.npz = this.nso(class_23382);
        this.nqd = 1 + threadLocalRandom.nextInt(4);
        this.nqe = 0L;
        this.nsj(class_7462);
        this.nul(nmc.CHEST_OPEN);
        return true;
    }

    private class_2338 nrx(long l) {
        class_638 class_6382 = this.mc.field_1687;
        class_746 class_7462 = this.mc.field_1724;
        class_243 class_2432 = class_7462.method_33571();
        double d = 28.09;
        class_2338 class_23382 = null;
        double d2 = Double.MAX_VALUE;
        int n = class_7462.method_31477() >> 4;
        int n2 = class_7462.method_31479() >> 4;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                class_2818 class_28182 = class_6382.method_2935().method_12126(n + i, n2 + j, false);
                if (class_28182 == null) continue;
                for (class_2586 class_25862 : class_28182.method_12214().values()) {
                    int n3;
                    class_2338 class_23383;
                    Long l2;
                    class_2338 class_23384;
                    if (!(class_25862 instanceof class_2595) && !(class_25862 instanceof class_3719) || class_2432.method_1025(class_243.method_24953((class_2382)(class_23384 = class_25862.method_11016()))) > d || (l2 = this.npw.get(class_23383 = AuctionSellerAlt.nst((class_1937)class_6382, class_23384))) != null && l2 > l || (n3 = AutoLoot.markState(class_6382, class_23384)) == 1 || n3 == 2 && l2 == null) continue;
                    if (AuctionSellerAlt.nsu((class_1937)class_6382, class_23384)) {
                        this.npw.put(class_23383, Long.MAX_VALUE);
                        continue;
                    }
                    class_243 class_2433 = this.nso(class_23384);
                    double d3 = class_2433 == null ? Double.MAX_VALUE : class_2432.method_1025(class_2433);
                    double d4 = d3;
                    if (!(d4 <= 18.49) || !(d4 < d2)) continue;
                    d2 = d4;
                    class_23382 = class_23384.method_10062();
                }
            }
        }
        return class_23382;
    }

    private void nry() {
        class_746 class_7462 = this.mc.field_1724;
        long l = System.currentTimeMillis();
        class_638 class_6382 = this.mc.field_1687;
        if (this.nqe > 0L && this.mc.field_1755 instanceof class_465 && this.nrz((class_1937)class_6382, class_7462.field_7512, l)) {
            this.nsa(l);
            return;
        }
        if (this.ntv()) {
            return;
        }
        if (this.npx == null || !AuctionSellerAlt.nsr((class_1937)class_6382, this.npx)) {
            this.nsc(Long.MAX_VALUE, null, false, 0);
            return;
        }
        class_243 class_2432 = class_7462.method_33571();
        if (this.npz == null || class_2432.method_1022(this.npz) > 4.3) {
            this.npz = this.nso(this.npx);
            if (this.npz == null || class_2432.method_1022(this.npz) > 4.3) {
                this.nsc(l + 60000L, null, false, 0);
                return;
            }
        }
        this.nsi();
        float f = Reflect.getFloat(nnz, class_7462, class_7462.method_36454());
        float f2 = Reflect.getFloat(noa, class_7462, class_7462.method_36455());
        class_3965 class_39652 = this.nse(class_7462, f, f2);
        if (class_39652 != null && this.nsq((class_1937)class_6382, class_39652.method_17777())) {
            if (this.nqd > 0) {
                --this.nqd;
            } else if (l - this.nqe > 1500L && !class_7462.method_5715() && !class_7462.method_6115() && IdleTracker.serverIdle(class_7462)) {
                this.nsf();
                this.nqe = l;
            }
        }
        this.nsk(this.npz, this.nsp((class_1937)class_6382, this.npx, this.npz));
    }

    private boolean nrz(class_1937 class_19372, class_1703 class_17032, long l) {
        int n;
        class_1707 class_17072;
        block5: {
            block4: {
                if (!(class_17032 instanceof class_1707)) break block4;
                class_17072 = (class_1707)class_17032;
                if (l - this.nqe <= 3000L && this.npx != null) break block5;
            }
            return false;
        }
        int n2 = n = AuctionSellerAlt.nss(class_19372, this.npx) != null ? 6 : 3;
        if (class_17072.method_17388() != n) {
            return false;
        }
        String string = EnchantNameUtil.title(this.mc.field_1755.method_25440().getString());
        return !string.contains("аукцион") && !string.contains("хранилищ");
    }

    private void nsa(long l) {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        this.nqk = this.mc.field_1724.field_7512.field_7763;
        this.nql = new class_1799[9];
        for (int i = 0; i < 9; ++i) {
            this.nql[i] = class_16612.method_5438(i).method_7972();
        }
        this.nqg = 0;
        this.nqh = 0;
        this.nqj = -1;
        this.nqi = AuctionSellerAlt.nsv(class_16612);
        this.noj = l + this.nqo.draw(0);
        this.nul(nmc.CHEST_LOOT);
    }

    private void nsb() {
        int n;
        class_746 class_7462 = this.mc.field_1724;
        long l = System.currentTimeMillis();
        class_1703 class_17032 = class_7462.field_7512;
        if (!(this.mc.field_1755 instanceof class_465) || !(class_17032 instanceof class_1707) || class_17032.field_7763 != this.nqk) {
            this.nsc(l + 15000L, null, true, this.nqh > 0 ? 2 : 0);
            return;
        }
        if (l < this.noj || !IdleTracker.serverIdle(class_7462)) {
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (this.nqg >= 4 && this.nqg % 4 == 0 && AuctionSellerAlt.nsv(class_16612) <= this.nqi) {
            this.nsd();
            this.nsc(Long.MAX_VALUE, Lang.s("The chest won't give its items", "Сундук не отдаёт вещи"), false, 2);
            return;
        }
        int n2 = class_17032.field_7761.size() - 36;
        int n3 = -1;
        double d = Double.MAX_VALUE;
        boolean bl = false;
        for (n = 0; n < n2; ++n) {
            double d2;
            class_1799 class_17992 = ((class_1735)class_17032.field_7761.get(n)).method_7677();
            if (class_17992.method_7960() || this.npb.contains(AuctionSellerAlt.nti(class_17992)) || !AutoLoot.wantsItem(class_17992.method_7909())) continue;
            if (!AuctionSellerAlt.nsx(class_16612, class_17992)) {
                bl = true;
                continue;
            }
            double d3 = d2 = this.nqj < 0 ? (double)n * 0.01 : AuctionSellerAlt.nsw(this.nqj, n);
            if (!(d2 < d)) continue;
            d = d2;
            n3 = n;
        }
        if (n3 < 0 || this.nqg >= 64) {
            n = bl || n3 >= 0 ? 1 : 0;
            this.nsd();
            this.nsc(n != 0 ? 0L : Long.MAX_VALUE, this.nqh > 0 ? Lang.s("From the chest: ", "Из сундука: ") + this.nqh : null, true, n != 0 ? 2 : 1);
            return;
        }
        this.mc.field_1761.method_2906(class_17032.field_7763, n3, 0, class_1713.field_7794, (class_1657)class_7462);
        ++this.nqh;
        this.nqj = n3;
        this.noj = l + this.nqo.draw(this.nqg++ == 0 ? 1 : 2);
    }

    private void nsc(long l, String string, boolean bl, int n) {
        if (this.npy != null) {
            this.npw.put(this.npy, l);
        }
        if (n != 0 && this.npx != null) {
            AutoLoot.markFromOutside(this.mc.field_1687, this.npx, n == 2);
        }
        if (bl && this.nql != null) {
            class_1661 class_16612 = this.mc.field_1724.method_31548();
            for (int i = 0; i < 9; ++i) {
                if (!this.nql[i].method_7960() || class_16612.method_5438(i).method_7960()) continue;
                this.nqm[i] = true;
            }
        }
        if (string != null) {
            this.nun(string, bl);
        }
        this.nsl();
        this.nty();
        this.npx = null;
        this.npy = null;
        this.npz = null;
        this.nqe = 0L;
        this.nql = null;
        this.nop = System.currentTimeMillis() + this.nqo.draw(0);
        this.nul(nmc.IDLE);
    }

    private void nsd() {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462.field_7512 != class_7462.field_7498) {
            class_7462.method_7346();
        }
    }

    private class_3965 nse(class_746 class_7462, float f, float f2) {
        class_243 class_2432;
        class_243 class_2433;
        class_243 class_2434 = class_7462.method_33571();
        class_3965 class_39652 = this.mc.field_1687.method_17742(new class_3959(class_2434, class_2433 = class_2434.method_1019((class_2432 = class_243.method_1030((float)f2, (float)f)).method_1021(class_7462.method_55754())), class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        return class_39652.method_17783() == class_239.class_240.field_1332 ? class_39652 : null;
    }

    private void nsf() {
        class_315 class_3152 = this.mc.field_1690;
        if (class_3152 == null) {
            return;
        }
        class_3152.field_1904.method_23481(true);
        this.nqf = true;
    }

    private void nsg() {
        if (!this.nqf) {
            return;
        }
        this.nqf = false;
        if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
            this.mc.field_1690.field_1904.method_23481(KeyUtil.isPhysicallyDown(this.mc, this.mc.field_1690.field_1904));
        }
    }

    private void nsh() {
        class_315 class_3152 = this.mc.field_1690;
        if (class_3152 == null) {
            return;
        }
        while (class_3152.field_1886.method_1436()) {
        }
        while (class_3152.field_1904.method_1436()) {
        }
    }

    private void nsi() {
        if (!this.npm) {
            this.npm = true;
            this.npn.hold(this.mc);
        }
    }

    private void nsj(class_746 class_7462) {
        if (this.nqq != class_7462) {
            this.nqq = class_7462;
            this.nqp.personalize(AuctionSellerAlt.nsn(class_7462.method_7334().name()));
        }
        if (!this.nqr) {
            boolean bl = CameraOwner.INSTANCE.engaged();
            float f = bl ? Reflect.getFloat(nnz, class_7462, class_7462.method_36454()) : class_7462.method_36454();
            float f2 = bl ? Reflect.getFloat(noa, class_7462, class_7462.method_36455()) : class_7462.method_36455();
            this.nqp.reset(f, f2);
        }
    }

    private void nsk(class_243 class_2432, double d) {
        float[] fArray = RotationUtil.calculateAngle(class_2432);
        this.nqp.setMouseStep(MouseQuantizer.step());
        this.nqp.aim(fArray[0], fArray[1], d);
        CameraOwner.INSTANCE.set(this, this.nqp.getYaw(), class_3532.method_15363((float)this.nqp.getPitch(), (float)-90.0f, (float)90.0f));
        this.nqr = true;
    }

    private void nsl() {
        if (this.nqr) {
            this.nqr = false;
            this.nqs = System.currentTimeMillis();
            CameraOwner.INSTANCE.release(this.mc.field_1724);
        }
    }

    private boolean nsm() {
        return !this.nqr && CameraOwner.INSTANCE.engaged() && System.currentTimeMillis() - this.nqs > 1000L;
    }

    private static long nsn(String string) {
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        return l;
    }

    private class_243 nso(class_2338 class_23382) {
        class_243[] class_243Array;
        class_746 class_7462 = this.mc.field_1724;
        class_638 class_6382 = this.mc.field_1687;
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        class_2338 class_23383 = AuctionSellerAlt.nss((class_1937)class_6382, class_23382);
        for (class_243 class_2434 : class_243Array = new class_243[]{class_2433.method_1031(this.nqa, this.nqb, this.nqc), class_2433.method_1031(0.0, 0.3, 0.0), class_2433.method_1031(0.0, -0.2, 0.0), class_2433.method_1031(0.3, 0.0, 0.0), class_2433.method_1031(-0.3, 0.0, 0.0), class_2433.method_1031(0.0, 0.0, 0.3), class_2433.method_1031(0.0, 0.0, -0.3)}) {
            class_3965 class_39652 = class_6382.method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
            if (class_39652.method_17783() != class_239.class_240.field_1332 || !class_39652.method_17777().equals((Object)class_23382) && !class_39652.method_17777().equals((Object)class_23383)) continue;
            return class_2434;
        }
        return null;
    }

    private double nsp(class_1937 class_19372, class_2338 class_23382, class_243 class_2432) {
        class_265 class_2652 = class_19372.method_8320(class_23382).method_26218((class_1922)class_19372, class_23382);
        class_238 class_2383 = class_2652.method_1110() ? new class_238(class_23382) : class_2652.method_1107().method_996(class_23382);
        double d = Math.min(Math.min(Math.min(class_2432.field_1352 - class_2383.field_1323, class_2383.field_1320 - class_2432.field_1352), Math.min(class_2432.field_1351 - class_2383.field_1322, class_2383.field_1325 - class_2432.field_1351)), Math.min(class_2432.field_1350 - class_2383.field_1321, class_2383.field_1324 - class_2432.field_1350));
        if (d <= 0.02) {
            return 0.25;
        }
        double d2 = Math.max(0.5, this.mc.field_1724.method_33571().method_1022(class_2432));
        return class_3532.method_15350((double)(Math.toDegrees(Math.atan2(d, d2)) * 0.55), (double)0.25, (double)4.0);
    }

    private boolean nsq(class_1937 class_19372, class_2338 class_23382) {
        if (class_23382 == null || this.npx == null) {
            return false;
        }
        return class_23382.equals((Object)this.npx) || class_23382.equals((Object)AuctionSellerAlt.nss(class_19372, this.npx));
    }

    private static boolean nsr(class_1937 class_19372, class_2338 class_23382) {
        class_2586 class_25862 = class_19372.method_8321(class_23382);
        return class_25862 instanceof class_2595 || class_25862 instanceof class_3719;
    }

    private static class_2338 nss(class_1937 class_19372, class_2338 class_23382) {
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        if (class_26802.method_26204() instanceof class_2281 && class_26802.method_28498((class_2769)class_2281.field_10770) && class_26802.method_11654((class_2769)class_2281.field_10770) != class_2745.field_12569) {
            return class_23382.method_10093(class_2281.method_9758((class_2680)class_26802));
        }
        return null;
    }

    private static class_2338 nst(class_1937 class_19372, class_2338 class_23382) {
        class_2338 class_23383 = AuctionSellerAlt.nss(class_19372, class_23382);
        return (class_23383 != null && class_23383.method_10063() < class_23382.method_10063() ? class_23383 : class_23382).method_10062();
    }

    private static boolean nsu(class_1937 class_19372, class_2338 class_23382) {
        if (!(class_19372.method_8320(class_23382).method_26204() instanceof class_2281)) {
            return false;
        }
        class_2338 class_23383 = AuctionSellerAlt.nss(class_19372, class_23382);
        return class_2281.method_9756((class_1936)class_19372, (class_2338)class_23382) || class_23383 != null && class_2281.method_9756((class_1936)class_19372, (class_2338)class_23383);
    }

    private static int nsv(class_1661 class_16612) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || !AutoLoot.wantsItem(class_17992.method_7909())) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private static double nsw(int n, int n2) {
        int n3 = n % 9 - n2 % 9;
        int n4 = n / 9 - n2 / 9;
        return Math.sqrt(n3 * n3 + n4 * n4);
    }

    private static boolean nsx(class_1661 class_16612, class_1799 class_17992) {
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

    private static boolean nsy(class_1661 class_16612) {
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_7960()) continue;
            return true;
        }
        return false;
    }

    private int nsz(List<class_1799> list, class_1799 class_17992) {
        int n = this.nta(list, class_17992, 0);
        if (n <= 0) {
            n = this.nta(list, class_17992, 1);
        }
        if (n <= 0 && AuctionSellerAlt.ntk(class_17992).isEmpty()) {
            n = this.nta(list, class_17992, 2);
        }
        return n;
    }

    private int nta(List<class_1799> list, class_1799 class_17992, int n) {
        int n2;
        Object object;
        int n3;
        int n4 = Math.max(0, list.size() - 36);
        String string = AuctionSellerAlt.nto(this.mc.field_1724.method_7334().name());
        Map<String, Integer> map = AuctionSellerAlt.ntk(class_17992);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n3 = 0; n3 < n4; ++n3) {
            object = list.get(n3);
            if (object == null || object.method_7960() || !this.ntb((class_1799)object, class_17992, map, n) || (n2 = AuctionSellerAlt.nte(AuctionSellerAlt.ntn((class_1799)object), string)) <= 0) continue;
            arrayList.add(Math.max(1, n2 / Math.max(1, object.method_7947())));
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        n3 = (Integer)arrayList.get(Math.min(2, arrayList.size() - 1));
        object = arrayList.iterator();
        while (object.hasNext()) {
            n2 = (Integer)object.next();
            if (!((double)n2 >= (double)n3 * 0.75)) continue;
            return n2;
        }
        return n3;
    }

    private boolean ntb(class_1799 class_17992, class_1799 class_17993, Map<String, Integer> map, int n) {
        if (class_17992.method_7909() != class_17993.method_7909()) {
            return false;
        }
        String string = AuctionSellerAlt.cleanQuery(class_17992.method_7964().getString());
        String string2 = AuctionSellerAlt.cleanQuery(class_17993.method_7964().getString());
        if (string.isEmpty() || string2.isEmpty()) {
            return false;
        }
        if (!(string.equals(string2) || string.contains(string2) || string2.contains(string))) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        Map<String, Integer> map2 = AuctionSellerAlt.ntk(class_17992);
        if (n == 0) {
            return map.equals(map2) && AuctionSellerAlt.ntc(class_17992, class_17993);
        }
        return AuctionSellerAlt.ntd(map, map2) >= this.nod.get() / 100.0;
    }

    private static boolean ntc(class_1799 class_17992, class_1799 class_17993) {
        List<String> list = AuctionSellerAlt.ntn(class_17993);
        if (list.size() <= 1) {
            return true;
        }
        List<String> list2 = AuctionSellerAlt.ntn(class_17992);
        for (int i = 1; i < list.size(); ++i) {
            String string = list.get(i);
            if (string.isEmpty() || list2.contains(string)) continue;
            return false;
        }
        return true;
    }

    private static double ntd(Map<String, Integer> map, Map<String, Integer> map2) {
        if (map.isEmpty() && map2.isEmpty()) {
            return 1.0;
        }
        if (map.isEmpty() || map2.isEmpty()) {
            return 0.0;
        }
        double d = 0.0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer n = map2.get(entry.getKey());
            if (n == null) continue;
            d += n.equals(entry.getValue()) ? 1.0 : 0.6;
        }
        return d / (double)Math.max(map.size(), map2.size());
    }

    private static int nte(List<String> list, String string) {
        int n = -1;
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            if (string2.contains("чтобы забрать") || string2.contains("не актуал")) {
                return -1;
            }
            if (!string.isEmpty() && string2.contains(string) && (string2.contains("продав") || string2.contains("владел"))) {
                return -1;
            }
            if (n > 0 || i == 0) continue;
            int n2 = string2.indexOf("цен");
            if (n2 < 0) {
                n2 = string2.indexOf("price");
            }
            if (n2 < 0) {
                n2 = string2.indexOf(36);
            }
            if (n2 < 0) continue;
            int n3 = string2.indexOf(58, n2);
            n = AuctionSellerAlt.ntf(string2, n3 >= 0 ? n3 + 1 : n2);
        }
        return n;
    }

    private static int ntf(String string, int n) {
        long l = 0L;
        boolean bl = false;
        for (int i = n; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                if ((l = l * 10L + (long)(c - 48)) > Integer.MAX_VALUE) {
                    return -1;
                }
                bl = true;
                continue;
            }
            if (bl && !AuctionSellerAlt.ntg(c)) break;
        }
        return bl && l > 0L ? (int)l : -1;
    }

    private static boolean ntg(char c) {
        return c == ' ' || c == ',' || c == '.' || c == '\u00a0' || c == '\u202f';
    }

    private static long nth(long l) {
        long l2;
        long l3 = l;
        for (long i = 10L; i <= 10000L && l / i >= 10L && (l2 = (l + 1L) / i * i - 1L) > 0L && l - l2 <= Math.max(1L, l / 20L); i *= 10L) {
            l3 = l2;
        }
        return l3;
    }

    private static String nti(class_1799 class_17992) {
        return String.valueOf(class_17992.method_7909()) + '|' + AuctionSellerAlt.nto(class_17992.method_7964().getString()) + '|' + AuctionSellerAlt.ntm(class_17992);
    }

    private static boolean ntj(class_1799 class_17992, class_1799 class_17993) {
        if (class_17992 == null || class_17993 == null || class_17992.method_7960() || class_17993.method_7960()) {
            return false;
        }
        return class_17992.method_7909() == class_17993.method_7909() && AuctionSellerAlt.nti(class_17992).equals(AuctionSellerAlt.nti(class_17993));
    }

    private static Map<String, Integer> ntk(class_1799 class_17992) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        if (class_17992 == null || class_17992.method_7960()) {
            return treeMap;
        }
        try {
            AuctionSellerAlt.ntl((class_9304)class_17992.method_58694(class_9334.field_49633), treeMap);
            AuctionSellerAlt.ntl((class_9304)class_17992.method_58694(class_9334.field_49643), treeMap);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return treeMap;
    }

    private static void ntl(class_9304 class_93042, Map<String, Integer> map) {
        if (class_93042 == null || class_93042.method_57543()) {
            return;
        }
        for (class_6880 class_68802 : class_93042.method_57534()) {
            String string = class_68802.method_40230().map(class_53212 -> class_53212.method_29177().method_12832()).orElse("");
            if (string.isEmpty()) continue;
            map.put(string, class_93042.method_57536(class_68802));
        }
    }

    private static String ntm(class_1799 class_17992) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : AuctionSellerAlt.ntk(class_17992).entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue()).append(',');
        }
        return stringBuilder.toString();
    }

    private static List<String> ntn(class_1799 class_17992) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            arrayList.add(AuctionSellerAlt.nto(class_17992.method_7964().getString()));
            class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
            if (class_92902 != null) {
                for (class_2561 class_25612 : class_92902.comp_2400()) {
                    if (class_25612 == null) continue;
                    arrayList.add(AuctionSellerAlt.nto(class_25612.getString()));
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return arrayList;
    }

    private static String nto(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7') {
                ++i;
                continue;
            }
            stringBuilder.append(Character.toLowerCase(c));
        }
        return stringBuilder.toString().trim();
    }

    static String cleanQuery(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7') {
                ++i;
                continue;
            }
            if (Character.isLetterOrDigit(c)) {
                if (bl && stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                bl = false;
                stringBuilder.append(Character.toLowerCase(c));
                continue;
            }
            bl = true;
        }
        return stringBuilder.toString().trim();
    }

    private static boolean ntp(String string) {
        String string2 = EnchantNameUtil.title(string);
        return string2.contains("хранилищ") && AuctionSellerAlt.ntq(string2, nmv);
    }

    private static boolean ntq(String string, String[] stringArray) {
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private int ntr() {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992;
            if (!this.nqx(i) || !AuctionSellerAlt.ntj(class_17992 = class_16612.method_5438(i), this.noy) || class_17992.method_7947() <= n2) continue;
            n2 = class_17992.method_7947();
            n = i;
        }
        return n;
    }

    private int nts() {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992;
            if (!this.nqx(i) || !AuctionSellerAlt.ntj(class_17992 = class_16612.method_5438(i), this.noy)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int ntt() {
        if (this.npi >= 0) {
            return this.npi;
        }
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) {
            if (!class_16612.method_5438(i).method_7960()) continue;
            arrayList.add(i);
        }
        if (arrayList.isEmpty()) {
            return class_16612.method_67532();
        }
        return (Integer)arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
    }

    private static int ntu(int n) {
        return n < 9 ? 36 + n : n;
    }

    private boolean ntv() {
        class_437 class_4372 = this.mc.field_1755;
        if (class_4372 == null) {
            return false;
        }
        if (!(class_4372 instanceof class_465)) {
            this.noi = System.currentTimeMillis();
            return true;
        }
        if (this.nub()) {
            this.mc.field_1724.method_7346();
            this.nok = Math.max(this.nok, System.currentTimeMillis() + AuctionSellerAlt.nuf());
        }
        return true;
    }

    private boolean ntw() {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462.field_7512 != class_7462.field_7498) {
            return false;
        }
        return this.ntx();
    }

    private boolean ntx() {
        if (this.nqr || CameraOwner.INSTANCE.engaged() && System.currentTimeMillis() - this.nqs < 1000L) {
            return false;
        }
        if (!this.nub()) {
            return false;
        }
        if (!this.npm) {
            this.npm = true;
            return false;
        }
        return IdleTracker.serverIdle(this.mc.field_1724);
    }

    private void nty() {
        if (this.npm) {
            this.npn.release(this.mc);
            this.npm = false;
        }
    }

    private void ntz(int n, class_1713 class_17132, int n2) {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462 == null || this.mc.field_1761 == null) {
            return;
        }
        class_1703 class_17032 = class_7462.field_7512;
        if (class_17032 == null || n < 0 || n >= class_17032.field_7761.size()) {
            return;
        }
        this.mc.field_1761.method_2906(class_17032.field_7763, n, n2, class_17132, (class_1657)class_7462);
        this.noj = System.currentTimeMillis() + this.nuc();
    }

    private void nua(String string) {
        long l;
        if (this.mc.method_1562() == null) {
            return;
        }
        this.mc.method_1562().method_45730(string);
        this.noo = l = System.currentTimeMillis();
        this.nol = l;
        this.nom = -1L;
    }

    private boolean nub() {
        long l = System.currentTimeMillis();
        if (l < this.noj) {
            return false;
        }
        this.noj = l + this.nuc();
        return true;
    }

    private long nuc() {
        double d = AuctionSellerAlt.nui(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.22, 0.72, 1.8);
        long l = (long)(110.0 * d);
        if (ThreadLocalRandom.current().nextInt(100) < 6) {
            l += ThreadLocalRandom.current().nextLong(140L, 520L);
        }
        return l + ThreadLocalRandom.current().nextLong(10L, 60L);
    }

    private boolean nud(long l, int n) {
        long l2;
        if (this.nom < 0L || this.non != n) {
            this.nom = this.nue(n);
            this.non = n;
        }
        if (l < Math.max(this.nok, this.nol + this.nom)) {
            this.noi = l;
            return false;
        }
        long l3 = l2 = n == 1 ? l : AuctionRateLimiter.nextFree(n, this.nof.getInt(), l);
        if (l2 <= l) {
            return true;
        }
        this.nok = l2 + AuctionSellerAlt.nuh(900L, 0.6, 150L, 5000L);
        this.noi = l;
        if (this.nok - l > 5000L && l - this.nos > 20000L) {
            this.nos = l;
            this.nun(Lang.s("Auction limit, waiting ", "Лимит аукциона, жду ") + (this.nok - l + 999L) / 1000L + Lang.s(" s", " с"), false);
        }
        return false;
    }

    private long nue(int n) {
        if (n == 1) {
            return this.nqo.draw(3, 1.4);
        }
        double d = 60000.0 / (double)AuctionRateLimiter.limit(this.nof.getInt());
        return this.nqo.draw(4, d * 0.75 / 1500.0);
    }

    private static long nuf() {
        return AuctionSellerAlt.nuh(850L, 0.35, 450L, 3000L);
    }

    private static int nug() {
        return 14 + ThreadLocalRandom.current().nextInt(11);
    }

    private static long nuh(long l, double d, long l2, long l3) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long l4 = l;
        for (int i = 0; i < 12; ++i) {
            l4 = Math.round((double)l * Math.exp(d * threadLocalRandom.nextGaussian()));
            if (l4 < l2 || l4 > l3) continue;
            return l4;
        }
        return Math.max(l2, Math.min(l3, l4));
    }

    private static double nui(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private boolean nuj() {
        this.npu = 0;
        this.npq = false;
        if (AuctionRateLimiter.warn() >= 2) {
            this.nun(Lang.s("The server is cutting the commands", "Сервер режет команды"), false);
            this.nra();
            return false;
        }
        long l = System.currentTimeMillis();
        long l2 = AuctionSellerAlt.nuh(25000L, 0.25, 15000L, 45000L);
        this.nok = Math.max(this.nok, l + l2);
        this.nun(Lang.s("The server asks to slow down, pause ", "Сервер просит медленнее, пауза ") + (l2 + 999L) / 1000L + Lang.s(" s", " с"), false);
        this.noi = l;
        return true;
    }

    private void nuk() {
        String string;
        String string2 = this.npv;
        String string3 = string = string2.isEmpty() ? Lang.s("The auction refused", "Аукцион отказал") : Lang.s("The auction refused: ", "Аукцион отказал: ") + string2;
        if (++this.not >= 3) {
            this.nun(string, false);
            this.nra();
            return;
        }
        this.nqz(string, false, true);
    }

    private void nul(nmc nmc2) {
        if (this.noh != nmc2) {
            this.noh = nmc2;
            this.noi = System.currentTimeMillis();
            this.npp = 0L;
        }
    }

    private void num() {
        this.nty();
        this.nsg();
        this.nsl();
        this.npx = null;
        this.npy = null;
        this.npz = null;
        this.nqe = 0L;
        this.nql = null;
        Arrays.fill(this.nqm, false);
        this.noh = nmc.IDLE;
        this.noi = 0L;
        this.npp = 0L;
        this.nph = false;
        this.npq = false;
        this.npu = 0;
        this.npv = "";
        this.noy = class_1799.field_8037;
        this.noz = "";
        this.npa = "";
        this.npd = -1;
        this.npf = 0;
        this.not = 0;
        this.nou = 0L;
        this.nox = false;
        this.npe = 0;
        this.npi = -1;
        this.npj = -1;
        this.npk = -1;
        this.npl = -1;
    }

    private void nun(String string, boolean bl) {
        System.out.println("AutoSell: " + string);
        Hud.alert(this.getName(), string, bl ? Icon.CHECK : Icon.INFO, bl);
    }

    private static /* synthetic */ int bda(int n, int n2) {
        return n * n2 + 2124300415;
    }

    private static /* synthetic */ int bdb(int n, int n2) {
        return AuctionSellerAlt.bda(n, n2) ^ 0xBFB576FB;
    }

    private static /* synthetic */ int bdc(int n, int n2) {
        return n * n2 ^ 0x3D081603;
    }
}

