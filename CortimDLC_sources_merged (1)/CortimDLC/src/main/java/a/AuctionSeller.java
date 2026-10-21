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
import a.lxu;
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

public class AuctionSeller
extends Module {
    private static final String lxz = "ah search ";
    private static final String lya = "ah sell ";
    private static final String lyb = "ah";
    private static final String lyc = "хранилищ";
    private static final String lyd = "перевыстав";
    private static final String lye = "аукцион";
    private static final String lyf = "цен";
    private static final String lyg = "price";
    private static final String lyh = "чтобы забрать";
    private static final String lyi = "не актуал";
    private static final String lyj = "продав";
    private static final String lyk = "владел";
    private static final String[] lyl = new String[]{"не так быстро", "слишком быстро", "слишком часто", "подожди", "cooldown"};
    private static final String[] lym = new String[]{"не найд", "не существ", "нет предмет", "лимит", "нельзя", "запрещ", "недостаточно", "не хватает", "слишком", "ошибк", "не удал"};
    private static final String[] lyn = new String[]{"освобод", "аренд"};
    private static final int lyo = 36;
    private static final double lyp = 0.75;
    private static final long lyq = 180000L;
    private static final long lyr = 120000L;
    private static final long lys = 110L;
    private static final long lyt = 360L;
    private static final long lyu = 260L;
    private static final long lyv = 4000L;
    private static final long lyw = 4000L;
    private static final long lyx = 20000L;
    private static final long lyy = 850L;
    private static final long lyz = 900L;
    private static final long lza = 3500L;
    private static final double lzb = 1.4;
    private static final double lzc = 1500.0;
    private static final double lzd = 0.75;
    private static final long lze = 25000L;
    private static final int lzf = 3;
    private static final long lzg = 60000L;
    private static final long lzh = 380L;
    private static final double lzi = 4.3;
    private static final long lzj = 60000L;
    private static final long lzk = 1500L;
    private static final long lzl = 3000L;
    private static final int lzm = 64;
    private static final int lzn = 0;
    private static final int lzo = 1;
    private static final int lzp = 2;
    private static final int lzq = 3;
    private static final Field lzr = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field lzs = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static AuctionSeller lzt;
    private final NumberSetting lzu = this.add(new NumberSetting("Ниже рынка", 5.0, 1.0, 50.0, 1.0).suffix("%"));
    private final NumberSetting lzv = this.add(new NumberSetting("Схожесть чар", 60.0, 0.0, 100.0, 5.0).suffix("%"));
    private final BoolSetting lzw = this.add(new BoolSetting("Хотбар тоже", false));
    private final NumberSetting lzx = this.add(new NumberSetting("Поисков в минуту", 20.0, 4.0, 40.0, 1.0));
    private final BoolSetting lzy = this.add(new BoolSetting("Из сундуков", true));
    private lxu lzz = lxu.IDLE;
    private long maa;
    private long mab;
    private long mac;
    private long mad;
    private long mae = -1L;
    private int maf = 0;
    private long mag;
    private long mah;
    private long mai = 360L;
    private long maj;
    private long mak;
    private int mal;
    private long mam;
    private int man;
    private int mao = 8;
    private boolean map;
    private class_1799 maq = class_1799.field_8037;
    private String mar = "";
    private String mas = "";
    private final Set<String> mat = new HashSet<String>();
    private final Map<String, long[]> mau = new HashMap<String, long[]>();
    private int mav = -1;
    private int maw;
    private int max;
    private long may;
    private boolean maz;
    private int mba = -1;
    private int mbb = -1;
    private int mbc = -1;
    private int mbd = -1;
    private boolean mbe;
    private final IdleTracker mbf = new IdleTracker();
    private long mbg;
    private long mbh;
    private boolean mbi;
    private int mbj = -1;
    private int mbk = -1;
    private long mbl;
    private int mbm = 0;
    private String mbn = "";
    private final Map<class_2338, Long> mbo = new HashMap<class_2338, Long>();
    private class_2338 mbp;
    private class_2338 mbq;
    private class_243 mbr;
    private double mbs;
    private double mbt;
    private double mbu;
    private int mbv;
    private long mbw;
    private boolean mbx;
    private int mby;
    private int mbz;
    private int mca;
    private int mcb = -1;
    private int mcc = -1;
    private class_1799[] mcd;
    private final boolean[] mce = new boolean[9];
    private boolean mcf;
    private final HumanDelays mcg = new HumanDelays();
    private final AimPersonalizer mch = new AimPersonalizer();
    private class_746 mci;
    private boolean mcj;
    private long mck;
    private static /* synthetic */ boolean mcl;
    private static /* synthetic */ String mcm;

    public AuctionSeller() {
        super("AucHelper", "Sells the inventory on the auction under the market by itself", ModuleCategory.PLAYER);
        lzt = this;
    }

    public static void onMessage(class_2561 class_25612) {
        AuctionSeller lxy2 = lzt;
        if (lxy2 != null && lxy2.isEnabled()) {
            lxy2.mcn(class_25612);
        }
    }

    @Override
    protected void onEnable() {
        this.mge();
        this.mat.clear();
        this.mbo.clear();
        this.mcf = false;
        this.mcg.reset();
        this.man = 0;
        this.mao = AuctionSeller.mfy();
        this.mbd = this.mc.field_1724 == null ? -1 : this.mc.field_1724.method_31548().method_67532();
        long l = System.currentTimeMillis();
        this.mau.values().removeIf(lArray -> l - lArray[1] > 180000L);
        this.mah = l + 260L + ThreadLocalRandom.current().nextLong(0L, 340L);
        this.mac = Math.max(this.mac, l + AuctionSeller.mfx());
    }

    @Override
    protected void onDisable() {
        this.mge();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.mdy();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.method_1562() == null) {
            if (this.lzz != lxu.IDLE) {
                this.mge();
            }
            return;
        }
        if (this.mbe) {
            this.mbf.hold(class_3102);
        }
        if (this.mcj && this.lzz == lxu.CHEST_OPEN) {
            this.mdz();
        }
        if (this.lzz == lxu.IDLE) {
            class_437 class_4372 = class_3102.field_1755;
            if (class_4372 != null && !(class_4372 instanceof class_465)) {
                return;
            }
            if (System.currentTimeMillis() < this.mah) {
                return;
            }
            if (!this.mco() && !this.mdo()) {
                this.mcs();
            }
            return;
        }
        if (this.lzz.lxv > 0L && System.currentTimeMillis() - this.maa > this.lzz.lxv) {
            if (this.lzz == lxu.RESTORE) {
                this.mdd();
            } else if (this.lzz == lxu.CHEST_OPEN) {
                this.mdu(System.currentTimeMillis() + 60000L, "Сундук не открылся", false, 0);
            } else if (this.lzz == lxu.CHEST_LOOT) {
                this.mdv();
                this.mdu(0L, null, true, 2);
            } else if (this.mdk()) {
                this.mgf("Хранилище не открылось", false);
                this.mdj();
            } else {
                this.mcr("Аукцион молчит: " + this.mas, false, true);
            }
            return;
        }
        switch (this.lzz.ordinal()) {
            case 1: {
                this.mct();
                break;
            }
            case 2: {
                this.mcu();
                break;
            }
            case 3: {
                this.mcv();
                break;
            }
            case 4: {
                this.mda();
                break;
            }
            case 5: {
                this.mdb();
                break;
            }
            case 6: {
                this.mdc();
                break;
            }
            case 7: {
                this.mdf();
                break;
            }
            case 8: {
                this.mdg();
                break;
            }
            case 9: {
                this.mdh();
                break;
            }
            case 10: {
                this.mdi();
                break;
            }
            case 11: {
                this.mdq();
                break;
            }
            case 12: {
                this.mdt();
                break;
            }
        }
    }

    private void mcn(class_2561 class_25612) {
        if (this.lzz == lxu.IDLE || this.mdk() || System.currentTimeMillis() - this.mag > 4000L) {
            return;
        }
        String string = AuctionSeller.mfg(class_25612.getString());
        if (string.isEmpty()) {
            return;
        }
        if (AuctionSeller.mfh(string)) {
            this.mbm = 3;
        } else if (AuctionSeller.mfi(string, lyl)) {
            this.mbm = 1;
        } else if (AuctionSeller.mfi(string, lym)) {
            this.mbn = string.length() > 48 ? string.substring(0, 48) : string;
            this.mbm = 2;
        }
    }

    private boolean mco() {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        for (int i = 0; i < 2; ++i) {
            int n = i == 0 ? 9 : 0;
            int n2 = i == 0 ? 36 : 9;
            for (int j = n; j < n2; ++j) {
                String string;
                class_1799 class_17992;
                if (!this.mcp(j) || (class_17992 = class_16612.method_5438(j)).method_7960() || this.mat.contains(string = AuctionSeller.mfa(class_17992))) continue;
                String string2 = AuctionSeller.cleanQuery(class_17992.method_7964().getString());
                if (string2.isEmpty()) {
                    this.mat.add(string);
                    continue;
                }
                this.maq = class_17992.method_7972();
                this.mar = string;
                this.mas = string2;
                this.mav = -1;
                this.max = 0;
                this.mbm = 0;
                this.mbn = "";
                this.mbi = false;
                this.mai = 360L + ThreadLocalRandom.current().nextLong(0L, 260L);
                this.mgf("Продаю: " + this.mas, true);
                this.mgd(lxu.TAKE);
                return true;
            }
        }
        return false;
    }

    private boolean mcp(int n) {
        if (n == this.mbc) {
            return false;
        }
        if (n >= 9) {
            return true;
        }
        return this.lzw.get() || n == this.mba || this.mcq(n);
    }

    private boolean mcq(int n) {
        if (!this.mce[n]) {
            return false;
        }
        if (this.mc.field_1724.method_31548().method_5438(n).method_7960()) {
            this.mce[n] = false;
            return false;
        }
        return true;
    }

    private void mcr(String string, boolean bl, boolean bl2) {
        if (bl2 && !this.mar.isEmpty()) {
            this.mat.add(this.mar);
        }
        if (string != null) {
            long l = System.currentTimeMillis();
            if (bl || l - this.maj > 4000L) {
                if (!bl) {
                    this.maj = l;
                }
                this.mgf(string, bl);
            }
        }
        this.mbi = false;
        this.mav = -1;
        this.max = 0;
        this.mbm = 0;
        this.mbn = "";
        this.maq = class_1799.field_8037;
        this.mar = "";
        this.mas = "";
        this.mfq();
        this.mah = System.currentTimeMillis() + 260L + ThreadLocalRandom.current().nextLong(0L, 300L);
        this.mgd(lxu.IDLE);
    }

    private void mcs() {
        this.mgf(this.maw > 0 ? "Готово, лотов: " + this.maw : "Продавать нечего", this.maw > 0);
        this.maz = true;
        this.mgd(lxu.RESTORE);
    }

    private void mct() {
        if (this.mfn()) {
            return;
        }
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        if (this.mcp(class_16612.method_67532()) && AuctionSeller.mfb(this.mc.field_1724.method_6047(), this.maq)) {
            this.mfq();
            this.mgd(lxu.SEARCH);
            return;
        }
        int n = this.mfj();
        if (n < 0) {
            this.mcr(null, true, false);
            return;
        }
        if (n < 9) {
            this.mfq();
            if (!this.mft()) {
                return;
            }
            class_16612.method_61496(n);
            this.mgd(lxu.SEARCH);
            return;
        }
        if (!this.mfo()) {
            return;
        }
        int n2 = this.mfl();
        boolean bl = !class_16612.method_5438(n2).method_7960();
        this.mfr(AuctionSeller.mfm(n), class_1713.field_7791, n2);
        this.mba = n2;
        if (bl && this.mbb < 0) {
            this.mbb = n2;
            this.mbc = n;
        }
    }

    private void mcu() {
        long l;
        long[] lArray;
        this.mfq();
        if (this.mfn()) {
            return;
        }
        String string = AuctionSeller.cleanQuery(this.mc.field_1724.method_6047().method_7964().getString());
        if (!string.isEmpty()) {
            this.mas = string;
        }
        if ((lArray = this.mcz(this.mar, l = System.currentTimeMillis(), 180000L)) != null) {
            if (lArray[0] > 0L) {
                this.mgd(lxu.SEND);
            } else {
                this.mcr("Нет цены: " + this.mas, false, true);
            }
            return;
        }
        if (!this.mfv(l, 0)) {
            return;
        }
        this.mbi = true;
        this.mbk = -1;
        this.mbl = 0L;
        this.mbj = this.mc.field_1724.field_7512 == null ? -1 : this.mc.field_1724.field_7512.field_7763;
        this.mbm = 0;
        this.mfs("ah search " + this.mas);
        this.mgd(lxu.SCAN);
    }

    private void mcv() {
        this.mfq();
        if (this.mbm == 3) {
            this.mde();
            return;
        }
        if (this.mbm == 2) {
            this.mgc();
            return;
        }
        if (this.mbm == 1) {
            if (this.mgb()) {
                this.mgd(lxu.SEARCH);
            }
            return;
        }
        List<class_1799> list = this.mcw();
        if (list == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.mbl < this.mai) {
            return;
        }
        this.mbi = false;
        this.mcx(list, l);
        long[] lArray = this.mcz(this.mar, l, 180000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.mcr("Нет цены: " + this.mas, false, true);
            return;
        }
        this.mam = l + AuctionSeller.mfz(900L, 0.45, 350L, 3500L);
        this.mgd(lxu.SEND);
    }

    private List<class_1799> mcw() {
        if (!this.mbi || !(this.mc.field_1755 instanceof class_465)) {
            return null;
        }
        class_1703 class_17032 = this.mc.field_1724.field_7512;
        if (!(class_17032 instanceof class_1707) || class_17032.field_7763 == this.mbj) {
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
        if (class_17032.field_7763 != this.mbk) {
            this.mbk = class_17032.field_7763;
            this.mbl = System.currentTimeMillis();
        }
        ArrayList<class_1799> arrayList = new ArrayList<class_1799>(class_17032.field_7761.size());
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            arrayList.add(((class_1735)class_17032.field_7761.get(i)).method_7677().method_7972());
        }
        return arrayList;
    }

    private void mcx(List<class_1799> list, long l) {
        this.mcy(this.mar, this.mer(list, this.maq), l);
        String string = this.mas;
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        for (int i = 0; i < 36; ++i) {
            String string2;
            class_1799 class_17992;
            if (!this.mcp(i) || (class_17992 = class_16612.method_5438(i)).method_7960() || class_17992.method_7909() != this.maq.method_7909() || (string2 = AuctionSeller.mfa(class_17992)).equals(this.mar) || this.mat.contains(string2) || !string.equals(AuctionSeller.cleanQuery(class_17992.method_7964().getString()))) continue;
            this.mcy(string2, this.mer(list, class_17992), l);
        }
    }

    private void mcy(String string, int n, long l) {
        this.mau.put(string, new long[]{n > 0 ? (long)n : -1L, l});
    }

    private long[] mcz(String string, long l, long l2) {
        long[] lArray = this.mau.get(string);
        return lArray != null && l - lArray[1] < l2 ? lArray : null;
    }

    private void mda() {
        this.mfq();
        long l = System.currentTimeMillis();
        if (l < this.mam && this.mc.field_1755 instanceof class_465) {
            this.maa = l;
            return;
        }
        if (this.mfn()) {
            return;
        }
        if (this.mbm == 3) {
            this.mde();
            return;
        }
        if (this.mbm == 2) {
            this.mgc();
            return;
        }
        long[] lArray = this.mcz(this.mar, l, 300000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.mgd(lxu.SEARCH);
            return;
        }
        int n = (int)lArray[0];
        class_1799 class_17992 = this.mc.field_1724.method_6047();
        if (!AuctionSeller.mfb(class_17992, this.maq)) {
            if (++this.max > 2) {
                this.mcr("Товар пропал из руки", false, true);
            } else {
                this.mgd(lxu.TAKE);
            }
            return;
        }
        if (!this.mfv(l, 1)) {
            return;
        }
        int n2 = Math.max(1, class_17992.method_7947());
        long l2 = (long)Math.floor((double)n * (1.0 - this.lzu.get() / 100.0));
        if (l2 >= (long)n) {
            l2 = (long)n - 1L;
        }
        this.may = AuctionSeller.mez(Math.max(1L, l2) * (long)n2);
        this.mav = this.mfk();
        this.mfs("ah sell " + this.may);
        this.mgd(lxu.CONFIRM);
    }

    private void mdb() {
        this.mfq();
        if (this.mfn()) {
            return;
        }
        if (this.mbm == 3) {
            this.mde();
            return;
        }
        if (this.mbm == 1) {
            if (this.mgb()) {
                this.mgd(lxu.SEND);
            }
            return;
        }
        if (this.mbm == 2) {
            this.mgc();
            return;
        }
        int n = this.mfk();
        if (this.mav < 0 || n >= this.mav) {
            return;
        }
        ++this.maw;
        this.mal = 0;
        this.max = 0;
        this.mav = -1;
        this.mgf("Выставлено за " + this.may, true);
        if (++this.man >= this.mao) {
            this.man = 0;
            this.mao = AuctionSeller.mfy();
            this.mac = Math.max(this.mac, System.currentTimeMillis() + AuctionSeller.mfz(3500L, 0.45, 1500L, 12000L));
        }
        if (n > 0) {
            this.mgd(lxu.TAKE);
        } else {
            this.mcr(null, true, false);
        }
    }

    private void mdc() {
        if (this.mfn()) {
            return;
        }
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        if (this.mbb >= 0 && this.mbc >= 0) {
            boolean bl;
            boolean bl2 = bl = !class_16612.method_5438(this.mbc).method_7960() || !class_16612.method_5438(this.mbb).method_7960();
            if (bl) {
                if (!this.mfo()) {
                    return;
                }
                this.mfr(AuctionSeller.mfm(this.mbc), class_1713.field_7791, this.mbb);
            }
            this.mbb = -1;
            this.mbc = -1;
            return;
        }
        this.mfq();
        if (this.mbd >= 0 && this.mbd < 9 && class_16612.method_67532() != this.mbd) {
            if (!this.mft()) {
                return;
            }
            class_16612.method_61496(this.mbd);
        }
        this.mdd();
    }

    private void mdd() {
        boolean bl = this.maz;
        this.mge();
        if (bl) {
            this.setEnabled(false);
        }
    }

    private void mde() {
        this.mbm = 0;
        this.mbn = "";
        this.mav = -1;
        this.mbi = false;
        this.mfq();
        if (this.map) {
            this.mgf("Слоты лотов заняты, продавать некуда", false);
            this.mcs();
            return;
        }
        long l = System.currentTimeMillis();
        if (l >= this.mbg) {
            this.mgd(lxu.AH_OPEN);
            return;
        }
        this.mgf("Хранилище полно, перевыставлю через " + (this.mbg - l + 999L) / 1000L + " с", false);
        this.mgd(lxu.FULL_WAIT);
    }

    private void mdf() {
        if (System.currentTimeMillis() >= this.mbg) {
            this.mgd(lxu.AH_OPEN);
        }
    }

    private void mdg() {
        if (this.mfn()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!this.mfv(l, 0)) {
            return;
        }
        this.mbg = l + 60000L + ThreadLocalRandom.current().nextLong(400L, 4000L);
        this.map = true;
        this.mfs("ah");
        this.mgd(lxu.AH_STORAGE);
    }

    private void mdh() {
        int n = this.mdl("хранилищ");
        if (n < 0 || !this.mdn() || !this.mfp()) {
            return;
        }
        this.mfr(n, class_1713.field_7790, 0);
        AuctionRateLimiter.note(0);
        this.mgd(lxu.AH_RELIST);
    }

    private void mdi() {
        int n = this.mdl("перевыстав");
        if (n < 0 || !this.mdn() || !this.mfp()) {
            return;
        }
        int n2 = this.mdm();
        if (n2 > 0) {
            this.mfr(n, class_1713.field_7790, 0);
            AuctionRateLimiter.note(0);
            this.mgf("Перевыставляю: " + n2, true);
        } else {
            this.mgf("Хранилище пустое, слоты заняты лотами", false);
        }
        this.mdj();
    }

    private void mdj() {
        this.mfq();
        this.mbm = 0;
        this.mbn = "";
        long l = System.currentTimeMillis();
        this.mag = 0L;
        this.mac = Math.max(this.mac, l + AuctionSeller.mfz(1600L, 0.35, 900L, 4000L));
        this.mab = l + 250L + ThreadLocalRandom.current().nextLong(0L, 350L);
        this.mgd(this.maq.method_7960() ? lxu.IDLE : lxu.TAKE);
    }

    private boolean mdk() {
        return this.lzz == lxu.FULL_WAIT || this.lzz == lxu.AH_OPEN || this.lzz == lxu.AH_STORAGE || this.lzz == lxu.AH_RELIST;
    }

    private int mdl(String string) {
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

    private int mdm() {
        class_1703 class_17032 = this.mc.field_1724.field_7512;
        int n = class_17032.field_7761.size() - 36;
        int n2 = 0;
        for (int i = 0; i < n - 9; ++i) {
            if (((class_1735)class_17032.field_7761.get(i)).method_7677().method_7960()) continue;
            ++n2;
        }
        return n2;
    }

    private boolean mdn() {
        long l;
        if (this.mbh != 0L) {
            return true;
        }
        this.mbh = l = System.currentTimeMillis();
        double d = AuctionSeller.mga(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.25, 0.7, 1.9);
        long l2 = (long)(380.0 * d) + ThreadLocalRandom.current().nextLong(10L, 90L);
        this.mab = Math.max(this.mab, l + l2);
        return false;
    }

    private boolean mdo() {
        if (!this.lzy.get()) {
            return false;
        }
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462.method_5765() || !AuctionSeller.meq(class_7462.method_31548()) || this.mee()) {
            return false;
        }
        long l = System.currentTimeMillis();
        if (AutoLoot.listEmpty()) {
            if (!this.mcf && this.mdp(l) != null) {
                this.mcf = true;
                this.mgf("Список ChestLooter пуст", false);
            }
            return false;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.mbs = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        this.mbt = (threadLocalRandom.nextDouble() - 0.5) * 0.25;
        this.mbu = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        class_2338 class_23382 = this.mdp(l);
        if (class_23382 == null) {
            return false;
        }
        this.mbp = class_23382;
        this.mbq = AuctionSeller.mel((class_1937)this.mc.field_1687, class_23382);
        this.mbr = this.meg(class_23382);
        this.mbv = 1 + threadLocalRandom.nextInt(4);
        this.mbw = 0L;
        this.meb(class_7462);
        this.mgd(lxu.CHEST_OPEN);
        return true;
    }

    private class_2338 mdp(long l) {
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
                    if (!(class_25862 instanceof class_2595) && !(class_25862 instanceof class_3719) || class_2432.method_1025(class_243.method_24953((class_2382)(class_23384 = class_25862.method_11016()))) > d || (l2 = this.mbo.get(class_23383 = AuctionSeller.mel((class_1937)class_6382, class_23384))) != null && l2 > l || (n3 = AutoLoot.markState(class_6382, class_23384)) == 1 || n3 == 2 && l2 == null) continue;
                    if (AuctionSeller.mem((class_1937)class_6382, class_23384)) {
                        this.mbo.put(class_23383, Long.MAX_VALUE);
                        continue;
                    }
                    class_243 class_2433 = this.meg(class_23384);
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

    private void mdq() {
        class_746 class_7462 = this.mc.field_1724;
        long l = System.currentTimeMillis();
        class_638 class_6382 = this.mc.field_1687;
        if (this.mbw > 0L && this.mc.field_1755 instanceof class_465 && this.mdr((class_1937)class_6382, class_7462.field_7512, l)) {
            this.mds(l);
            return;
        }
        if (this.mfn()) {
            return;
        }
        if (this.mbp == null || !AuctionSeller.mej((class_1937)class_6382, this.mbp)) {
            this.mdu(Long.MAX_VALUE, null, false, 0);
            return;
        }
        class_243 class_2432 = class_7462.method_33571();
        if (this.mbr == null || class_2432.method_1022(this.mbr) > 4.3) {
            this.mbr = this.meg(this.mbp);
            if (this.mbr == null || class_2432.method_1022(this.mbr) > 4.3) {
                this.mdu(l + 60000L, null, false, 0);
                return;
            }
        }
        this.mea();
        float f = Reflect.getFloat(lzr, class_7462, class_7462.method_36454());
        float f2 = Reflect.getFloat(lzs, class_7462, class_7462.method_36455());
        class_3965 class_39652 = this.mdw(class_7462, f, f2);
        if (class_39652 != null && this.mei((class_1937)class_6382, class_39652.method_17777())) {
            if (this.mbv > 0) {
                --this.mbv;
            } else if (l - this.mbw > 1500L && !class_7462.method_5715() && !class_7462.method_6115() && IdleTracker.serverIdle(class_7462)) {
                this.mdx();
                this.mbw = l;
            }
        }
        this.mec(this.mbr, this.meh((class_1937)class_6382, this.mbp, this.mbr));
    }

    private boolean mdr(class_1937 class_19372, class_1703 class_17032, long l) {
        int n;
        class_1707 class_17072;
        block5: {
            block4: {
                if (!(class_17032 instanceof class_1707)) break block4;
                class_17072 = (class_1707)class_17032;
                if (l - this.mbw <= 3000L && this.mbp != null) break block5;
            }
            return false;
        }
        int n2 = n = AuctionSeller.mek(class_19372, this.mbp) != null ? 6 : 3;
        if (class_17072.method_17388() != n) {
            return false;
        }
        String string = EnchantNameUtil.title(this.mc.field_1755.method_25440().getString());
        return !string.contains("аукцион") && !string.contains("хранилищ");
    }

    private void mds(long l) {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        this.mcc = this.mc.field_1724.field_7512.field_7763;
        this.mcd = new class_1799[9];
        for (int i = 0; i < 9; ++i) {
            this.mcd[i] = class_16612.method_5438(i).method_7972();
        }
        this.mby = 0;
        this.mbz = 0;
        this.mcb = -1;
        this.mca = AuctionSeller.men(class_16612);
        this.mab = l + this.mcg.draw(0);
        this.mgd(lxu.CHEST_LOOT);
    }

    private void mdt() {
        int n;
        class_746 class_7462 = this.mc.field_1724;
        long l = System.currentTimeMillis();
        class_1703 class_17032 = class_7462.field_7512;
        if (!(this.mc.field_1755 instanceof class_465) || !(class_17032 instanceof class_1707) || class_17032.field_7763 != this.mcc) {
            this.mdu(l + 15000L, null, true, this.mbz > 0 ? 2 : 0);
            return;
        }
        if (l < this.mab || !IdleTracker.serverIdle(class_7462)) {
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (this.mby >= 4 && this.mby % 4 == 0 && AuctionSeller.men(class_16612) <= this.mca) {
            this.mdv();
            this.mdu(Long.MAX_VALUE, "Сундук не отдаёт вещи", false, 2);
            return;
        }
        int n2 = class_17032.field_7761.size() - 36;
        int n3 = -1;
        double d = Double.MAX_VALUE;
        boolean bl = false;
        for (n = 0; n < n2; ++n) {
            double d2;
            class_1799 class_17992 = ((class_1735)class_17032.field_7761.get(n)).method_7677();
            if (class_17992.method_7960() || this.mat.contains(AuctionSeller.mfa(class_17992)) || !AutoLoot.wantsItem(class_17992.method_7909())) continue;
            if (!AuctionSeller.mep(class_16612, class_17992)) {
                bl = true;
                continue;
            }
            double d3 = d2 = this.mcb < 0 ? (double)n * 0.01 : AuctionSeller.meo(this.mcb, n);
            if (!(d2 < d)) continue;
            d = d2;
            n3 = n;
        }
        if (n3 < 0 || this.mby >= 64) {
            n = bl || n3 >= 0 ? 1 : 0;
            this.mdv();
            this.mdu(n != 0 ? 0L : Long.MAX_VALUE, this.mbz > 0 ? "Из сундука: " + this.mbz : null, true, n != 0 ? 2 : 1);
            return;
        }
        this.mc.field_1761.method_2906(class_17032.field_7763, n3, 0, class_1713.field_7794, (class_1657)class_7462);
        ++this.mbz;
        this.mcb = n3;
        this.mab = l + this.mcg.draw(this.mby++ == 0 ? 1 : 2);
    }

    private void mdu(long l, String string, boolean bl, int n) {
        if (this.mbq != null) {
            this.mbo.put(this.mbq, l);
        }
        if (n != 0 && this.mbp != null) {
            AutoLoot.markFromOutside(this.mc.field_1687, this.mbp, n == 2);
        }
        if (bl && this.mcd != null) {
            class_1661 class_16612 = this.mc.field_1724.method_31548();
            for (int i = 0; i < 9; ++i) {
                if (!this.mcd[i].method_7960() || class_16612.method_5438(i).method_7960()) continue;
                this.mce[i] = true;
            }
        }
        if (string != null) {
            this.mgf(string, bl);
        }
        this.med();
        this.mfq();
        this.mbp = null;
        this.mbq = null;
        this.mbr = null;
        this.mbw = 0L;
        this.mcd = null;
        this.mah = System.currentTimeMillis() + this.mcg.draw(0);
        this.mgd(lxu.IDLE);
    }

    private void mdv() {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462.field_7512 != class_7462.field_7498) {
            class_7462.method_7346();
        }
    }

    private class_3965 mdw(class_746 class_7462, float f, float f2) {
        class_243 class_2432;
        class_243 class_2433;
        class_243 class_2434 = class_7462.method_33571();
        class_3965 class_39652 = this.mc.field_1687.method_17742(new class_3959(class_2434, class_2433 = class_2434.method_1019((class_2432 = class_243.method_1030((float)f2, (float)f)).method_1021(class_7462.method_55754())), class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
        return class_39652.method_17783() == class_239.class_240.field_1332 ? class_39652 : null;
    }

    private void mdx() {
        class_315 class_3152 = this.mc.field_1690;
        if (class_3152 == null) {
            return;
        }
        class_3152.field_1904.method_23481(true);
        this.mbx = true;
    }

    private void mdy() {
        if (!this.mbx) {
            return;
        }
        this.mbx = false;
        if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
            this.mc.field_1690.field_1904.method_23481(KeyUtil.isPhysicallyDown(this.mc, this.mc.field_1690.field_1904));
        }
    }

    private void mdz() {
        class_315 class_3152 = this.mc.field_1690;
        if (class_3152 == null) {
            return;
        }
        while (class_3152.field_1886.method_1436()) {
        }
        while (class_3152.field_1904.method_1436()) {
        }
    }

    private void mea() {
        if (!this.mbe) {
            this.mbe = true;
            this.mbf.hold(this.mc);
        }
    }

    private void meb(class_746 class_7462) {
        if (this.mci != class_7462) {
            this.mci = class_7462;
            this.mch.personalize(AuctionSeller.mef(class_7462.method_7334().name()));
        }
        if (!this.mcj) {
            boolean bl = CameraOwner.INSTANCE.engaged();
            float f = bl ? Reflect.getFloat(lzr, class_7462, class_7462.method_36454()) : class_7462.method_36454();
            float f2 = bl ? Reflect.getFloat(lzs, class_7462, class_7462.method_36455()) : class_7462.method_36455();
            this.mch.reset(f, f2);
        }
    }

    private void mec(class_243 class_2432, double d) {
        float[] fArray = RotationUtil.calculateAngle(class_2432);
        this.mch.setMouseStep(MouseQuantizer.step());
        this.mch.aim(fArray[0], fArray[1], d);
        CameraOwner.INSTANCE.set(this, this.mch.getYaw(), class_3532.method_15363((float)this.mch.getPitch(), (float)-90.0f, (float)90.0f));
        this.mcj = true;
    }

    private void med() {
        if (this.mcj) {
            this.mcj = false;
            this.mck = System.currentTimeMillis();
            CameraOwner.INSTANCE.release(this.mc.field_1724);
        }
    }

    private boolean mee() {
        return !this.mcj && CameraOwner.INSTANCE.engaged() && System.currentTimeMillis() - this.mck > 1000L;
    }

    private static long mef(String string) {
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        return l;
    }

    private class_243 meg(class_2338 class_23382) {
        class_243[] class_243Array;
        class_746 class_7462 = this.mc.field_1724;
        class_638 class_6382 = this.mc.field_1687;
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        class_2338 class_23383 = AuctionSeller.mek((class_1937)class_6382, class_23382);
        for (class_243 class_2434 : class_243Array = new class_243[]{class_2433.method_1031(this.mbs, this.mbt, this.mbu), class_2433.method_1031(0.0, 0.3, 0.0), class_2433.method_1031(0.0, -0.2, 0.0), class_2433.method_1031(0.3, 0.0, 0.0), class_2433.method_1031(-0.3, 0.0, 0.0), class_2433.method_1031(0.0, 0.0, 0.3), class_2433.method_1031(0.0, 0.0, -0.3)}) {
            class_3965 class_39652 = class_6382.method_17742(new class_3959(class_2432, class_2434, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462));
            if (class_39652.method_17783() != class_239.class_240.field_1332 || !class_39652.method_17777().equals((Object)class_23382) && !class_39652.method_17777().equals((Object)class_23383)) continue;
            return class_2434;
        }
        return null;
    }

    private double meh(class_1937 class_19372, class_2338 class_23382, class_243 class_2432) {
        class_265 class_2652 = class_19372.method_8320(class_23382).method_26218((class_1922)class_19372, class_23382);
        class_238 class_2383 = class_2652.method_1110() ? new class_238(class_23382) : class_2652.method_1107().method_996(class_23382);
        double d = Math.min(Math.min(Math.min(class_2432.field_1352 - class_2383.field_1323, class_2383.field_1320 - class_2432.field_1352), Math.min(class_2432.field_1351 - class_2383.field_1322, class_2383.field_1325 - class_2432.field_1351)), Math.min(class_2432.field_1350 - class_2383.field_1321, class_2383.field_1324 - class_2432.field_1350));
        if (d <= 0.02) {
            return 0.25;
        }
        double d2 = Math.max(0.5, this.mc.field_1724.method_33571().method_1022(class_2432));
        return class_3532.method_15350((double)(Math.toDegrees(Math.atan2(d, d2)) * 0.55), (double)0.25, (double)4.0);
    }

    private boolean mei(class_1937 class_19372, class_2338 class_23382) {
        if (class_23382 == null || this.mbp == null) {
            return false;
        }
        return class_23382.equals((Object)this.mbp) || class_23382.equals((Object)AuctionSeller.mek(class_19372, this.mbp));
    }

    private static boolean mej(class_1937 class_19372, class_2338 class_23382) {
        class_2586 class_25862 = class_19372.method_8321(class_23382);
        return class_25862 instanceof class_2595 || class_25862 instanceof class_3719;
    }

    private static class_2338 mek(class_1937 class_19372, class_2338 class_23382) {
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        if (class_26802.method_26204() instanceof class_2281 && class_26802.method_28498((class_2769)class_2281.field_10770) && class_26802.method_11654((class_2769)class_2281.field_10770) != class_2745.field_12569) {
            return class_23382.method_10093(class_2281.method_9758((class_2680)class_26802));
        }
        return null;
    }

    private static class_2338 mel(class_1937 class_19372, class_2338 class_23382) {
        class_2338 class_23383 = AuctionSeller.mek(class_19372, class_23382);
        return (class_23383 != null && class_23383.method_10063() < class_23382.method_10063() ? class_23383 : class_23382).method_10062();
    }

    private static boolean mem(class_1937 class_19372, class_2338 class_23382) {
        if (!(class_19372.method_8320(class_23382).method_26204() instanceof class_2281)) {
            return false;
        }
        class_2338 class_23383 = AuctionSeller.mek(class_19372, class_23382);
        return class_2281.method_9756((class_1936)class_19372, (class_2338)class_23382) || class_23383 != null && class_2281.method_9756((class_1936)class_19372, (class_2338)class_23383);
    }

    private static int men(class_1661 class_16612) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || !AutoLoot.wantsItem(class_17992.method_7909())) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private static double meo(int n, int n2) {
        int n3 = n % 9 - n2 % 9;
        int n4 = n / 9 - n2 / 9;
        return Math.sqrt(n3 * n3 + n4 * n4);
    }

    private static boolean mep(class_1661 class_16612, class_1799 class_17992) {
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

    private static boolean meq(class_1661 class_16612) {
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_7960()) continue;
            return true;
        }
        return false;
    }

    private int mer(List<class_1799> list, class_1799 class_17992) {
        int n = this.mes(list, class_17992, 0);
        if (n <= 0) {
            n = this.mes(list, class_17992, 1);
        }
        if (n <= 0 && AuctionSeller.mfc(class_17992).isEmpty()) {
            n = this.mes(list, class_17992, 2);
        }
        return n;
    }

    private int mes(List<class_1799> list, class_1799 class_17992, int n) {
        int n2;
        Object object;
        int n3;
        int n4 = Math.max(0, list.size() - 36);
        String string = AuctionSeller.mfg(this.mc.field_1724.method_7334().name());
        Map<String, Integer> map = AuctionSeller.mfc(class_17992);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n3 = 0; n3 < n4; ++n3) {
            object = list.get(n3);
            if (object == null || object.method_7960() || !this.met((class_1799)object, class_17992, map, n) || (n2 = AuctionSeller.mew(AuctionSeller.mff((class_1799)object), string)) <= 0) continue;
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

    private boolean met(class_1799 class_17992, class_1799 class_17993, Map<String, Integer> map, int n) {
        if (class_17992.method_7909() != class_17993.method_7909()) {
            return false;
        }
        String string = AuctionSeller.cleanQuery(class_17992.method_7964().getString());
        String string2 = AuctionSeller.cleanQuery(class_17993.method_7964().getString());
        if (string.isEmpty() || string2.isEmpty()) {
            return false;
        }
        if (!(string.equals(string2) || string.contains(string2) || string2.contains(string))) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        Map<String, Integer> map2 = AuctionSeller.mfc(class_17992);
        if (n == 0) {
            return map.equals(map2) && AuctionSeller.meu(class_17992, class_17993);
        }
        return AuctionSeller.mev(map, map2) >= this.lzv.get() / 100.0;
    }

    private static boolean meu(class_1799 class_17992, class_1799 class_17993) {
        List<String> list = AuctionSeller.mff(class_17993);
        if (list.size() <= 1) {
            return true;
        }
        List<String> list2 = AuctionSeller.mff(class_17992);
        for (int i = 1; i < list.size(); ++i) {
            String string = list.get(i);
            if (string.isEmpty() || list2.contains(string)) continue;
            return false;
        }
        return true;
    }

    private static double mev(Map<String, Integer> map, Map<String, Integer> map2) {
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

    private static int mew(List<String> list, String string) {
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
            n = AuctionSeller.mex(string2, n3 >= 0 ? n3 + 1 : n2);
        }
        return n;
    }

    private static int mex(String string, int n) {
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
            if (bl && !AuctionSeller.mey(c)) break;
        }
        return bl && l > 0L ? (int)l : -1;
    }

    private static boolean mey(char c) {
        return c == ' ' || c == ',' || c == '.' || c == '\u00a0' || c == '\u202f';
    }

    private static long mez(long l) {
        long l2;
        long l3 = l;
        for (long i = 10L; i <= 10000L && l / i >= 10L && (l2 = (l + 1L) / i * i - 1L) > 0L && l - l2 <= Math.max(1L, l / 20L); i *= 10L) {
            l3 = l2;
        }
        return l3;
    }

    private static String mfa(class_1799 class_17992) {
        return String.valueOf(class_17992.method_7909()) + '|' + AuctionSeller.mfg(class_17992.method_7964().getString()) + '|' + AuctionSeller.mfe(class_17992);
    }

    private static boolean mfb(class_1799 class_17992, class_1799 class_17993) {
        if (class_17992 == null || class_17993 == null || class_17992.method_7960() || class_17993.method_7960()) {
            return false;
        }
        return class_17992.method_7909() == class_17993.method_7909() && AuctionSeller.mfa(class_17992).equals(AuctionSeller.mfa(class_17993));
    }

    private static Map<String, Integer> mfc(class_1799 class_17992) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        if (class_17992 == null || class_17992.method_7960()) {
            return treeMap;
        }
        try {
            AuctionSeller.mfd((class_9304)class_17992.method_58694(class_9334.field_49633), treeMap);
            AuctionSeller.mfd((class_9304)class_17992.method_58694(class_9334.field_49643), treeMap);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return treeMap;
    }

    private static void mfd(class_9304 class_93042, Map<String, Integer> map) {
        if (class_93042 == null || class_93042.method_57543()) {
            return;
        }
        for (class_6880 class_68802 : class_93042.method_57534()) {
            String string = class_68802.method_40230().map(class_53212 -> class_53212.method_29177().method_12832()).orElse("");
            if (string.isEmpty()) continue;
            map.put(string, class_93042.method_57536(class_68802));
        }
    }

    private static String mfe(class_1799 class_17992) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : AuctionSeller.mfc(class_17992).entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue()).append(',');
        }
        return stringBuilder.toString();
    }

    private static List<String> mff(class_1799 class_17992) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            arrayList.add(AuctionSeller.mfg(class_17992.method_7964().getString()));
            class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
            if (class_92902 != null) {
                for (class_2561 class_25612 : class_92902.comp_2400()) {
                    if (class_25612 == null) continue;
                    arrayList.add(AuctionSeller.mfg(class_25612.getString()));
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return arrayList;
    }

    private static String mfg(String string) {
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

    private static boolean mfh(String string) {
        String string2 = EnchantNameUtil.title(string);
        return string2.contains("хранилищ") && AuctionSeller.mfi(string2, lyn);
    }

    private static boolean mfi(String string, String[] stringArray) {
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private int mfj() {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992;
            if (!this.mcp(i) || !AuctionSeller.mfb(class_17992 = class_16612.method_5438(i), this.maq) || class_17992.method_7947() <= n2) continue;
            n2 = class_17992.method_7947();
            n = i;
        }
        return n;
    }

    private int mfk() {
        class_1661 class_16612 = this.mc.field_1724.method_31548();
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992;
            if (!this.mcp(i) || !AuctionSeller.mfb(class_17992 = class_16612.method_5438(i), this.maq)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private int mfl() {
        if (this.mba >= 0) {
            return this.mba;
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

    private static int mfm(int n) {
        return n < 9 ? 36 + n : n;
    }

    private boolean mfn() {
        class_437 class_4372 = this.mc.field_1755;
        if (class_4372 == null) {
            return false;
        }
        if (!(class_4372 instanceof class_465)) {
            this.maa = System.currentTimeMillis();
            return true;
        }
        if (this.mft()) {
            this.mc.field_1724.method_7346();
            this.mac = Math.max(this.mac, System.currentTimeMillis() + AuctionSeller.mfx());
        }
        return true;
    }

    private boolean mfo() {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462.field_7512 != class_7462.field_7498) {
            return false;
        }
        return this.mfp();
    }

    private boolean mfp() {
        if (this.mcj || CameraOwner.INSTANCE.engaged() && System.currentTimeMillis() - this.mck < 1000L) {
            return false;
        }
        if (!this.mft()) {
            return false;
        }
        if (!this.mbe) {
            this.mbe = true;
            return false;
        }
        return IdleTracker.serverIdle(this.mc.field_1724);
    }

    private void mfq() {
        if (this.mbe) {
            this.mbf.release(this.mc);
            this.mbe = false;
        }
    }

    private void mfr(int n, class_1713 class_17132, int n2) {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462 == null || this.mc.field_1761 == null) {
            return;
        }
        class_1703 class_17032 = class_7462.field_7512;
        if (class_17032 == null || n < 0 || n >= class_17032.field_7761.size()) {
            return;
        }
        this.mc.field_1761.method_2906(class_17032.field_7763, n, n2, class_17132, (class_1657)class_7462);
        this.mab = System.currentTimeMillis() + this.mfu();
    }

    private void mfs(String string) {
        long l;
        if (this.mc.method_1562() == null) {
            return;
        }
        this.mc.method_1562().method_45730(string);
        this.mag = l = System.currentTimeMillis();
        this.mad = l;
        this.mae = -1L;
    }

    private boolean mft() {
        long l = System.currentTimeMillis();
        if (l < this.mab) {
            return false;
        }
        this.mab = l + this.mfu();
        return true;
    }

    private long mfu() {
        double d = AuctionSeller.mga(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.22, 0.72, 1.8);
        long l = (long)(110.0 * d);
        if (ThreadLocalRandom.current().nextInt(100) < 6) {
            l += ThreadLocalRandom.current().nextLong(140L, 520L);
        }
        return l + ThreadLocalRandom.current().nextLong(10L, 60L);
    }

    private boolean mfv(long l, int n) {
        long l2;
        if (this.mae < 0L || this.maf != n) {
            this.mae = this.mfw(n);
            this.maf = n;
        }
        if (l < Math.max(this.mac, this.mad + this.mae)) {
            this.maa = l;
            return false;
        }
        long l3 = l2 = n == 1 ? l : AuctionRateLimiter.nextFree(n, this.lzx.getInt(), l);
        if (l2 <= l) {
            return true;
        }
        this.mac = l2 + AuctionSeller.mfz(900L, 0.6, 150L, 5000L);
        this.maa = l;
        if (this.mac - l > 5000L && l - this.mak > 20000L) {
            this.mak = l;
            this.mgf("Лимит аукциона, жду " + (this.mac - l + 999L) / 1000L + " с", false);
        }
        return false;
    }

    private long mfw(int n) {
        if (n == 1) {
            return this.mcg.draw(3, 1.4);
        }
        double d = 60000.0 / (double)AuctionRateLimiter.limit(this.lzx.getInt());
        return this.mcg.draw(4, d * 0.75 / 1500.0);
    }

    private static long mfx() {
        return AuctionSeller.mfz(850L, 0.35, 450L, 3000L);
    }

    private static int mfy() {
        return 14 + ThreadLocalRandom.current().nextInt(11);
    }

    private static long mfz(long l, double d, long l2, long l3) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long l4 = l;
        for (int i = 0; i < 12; ++i) {
            l4 = Math.round((double)l * Math.exp(d * threadLocalRandom.nextGaussian()));
            if (l4 < l2 || l4 > l3) continue;
            return l4;
        }
        return Math.max(l2, Math.min(l3, l4));
    }

    private static double mga(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private boolean mgb() {
        this.mbm = 0;
        this.mbi = false;
        if (AuctionRateLimiter.warn() >= 2) {
            this.mgf("Сервер режет команды", false);
            this.mcs();
            return false;
        }
        long l = System.currentTimeMillis();
        long l2 = AuctionSeller.mfz(25000L, 0.25, 15000L, 45000L);
        this.mac = Math.max(this.mac, l + l2);
        this.mgf("Сервер просит медленнее, пауза " + (l2 + 999L) / 1000L + " с", false);
        this.maa = l;
        return true;
    }

    private void mgc() {
        String string;
        String string2 = this.mbn;
        String string3 = string = string2.isEmpty() ? "Аукцион отказал" : "Аукцион отказал: " + string2;
        if (++this.mal >= 3) {
            this.mgf(string, false);
            this.mcs();
            return;
        }
        this.mcr(string, false, true);
    }

    private void mgd(lxu lxu2) {
        if (this.lzz != lxu2) {
            this.lzz = lxu2;
            this.maa = System.currentTimeMillis();
            this.mbh = 0L;
        }
    }

    private void mge() {
        this.mfq();
        this.mdy();
        this.med();
        this.mbp = null;
        this.mbq = null;
        this.mbr = null;
        this.mbw = 0L;
        this.mcd = null;
        Arrays.fill(this.mce, false);
        this.lzz = lxu.IDLE;
        this.maa = 0L;
        this.mbh = 0L;
        this.maz = false;
        this.mbi = false;
        this.mbm = 0;
        this.mbn = "";
        this.maq = class_1799.field_8037;
        this.mar = "";
        this.mas = "";
        this.mav = -1;
        this.max = 0;
        this.mal = 0;
        this.mam = 0L;
        this.map = false;
        this.maw = 0;
        this.mba = -1;
        this.mbb = -1;
        this.mbc = -1;
        this.mbd = -1;
    }

    private void mgf(String string, boolean bl) {
        System.out.println("AucHelper: " + string);
        Hud.alert(this.getName(), string, bl ? Icon.CHECK : Icon.INFO, bl);
    }

    private static /* synthetic */ int baq(int n, int n2) {
        return n - n2 | 0x870780ED;
    }

    private static /* synthetic */ int bar(int n, int n2) {
        return n - n2 | 0x63FA094F;
    }

    private static /* synthetic */ int bas(int n, int n2) {
        return AuctionSeller.bar(n, n2) + n;
    }
}

