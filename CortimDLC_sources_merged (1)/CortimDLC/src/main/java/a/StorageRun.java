/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1263
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1714
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2480
 *  net.minecraft.class_2551
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2625
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3489
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3708
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_479
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_7715
 */
package a;

import a.AutoRepair;
import a.EnchantNameUtil;
import a.Box3;
import a.TimerTextParser;
import a.CraftHelper;
import a.qdw;
import a.AutoMineController;
import a.MineTools;
import a.InventoryCounter;
import a.qsp;
import a.qsq;
import a.qst;
import a.AimBrain;
import a.SlotUtil;
import a.KeyUtil;
import a.Lang;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1263;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1714;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2480;
import net.minecraft.class_2551;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2625;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3489;
import net.minecraft.class_3675;
import net.minecraft.class_3708;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_479;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_7715;

public final class StorageRun {
    private static final String qsx = "dump";
    private static final String qsy = "food";
    private static final String qsz = "xp";
    private static final double qta = 4.3;
    private static final long qtb = 75000L;
    private static final long qtc = 160000L;
    private static final long qtd = 360000L;
    private static final int qte = 10;
    private static final int qtf = 2;
    private static final int qtg = 24;
    public static volatile Consumer<String> trace;
    public int repairTo = 1500;
    public int xpStock = 576;
    public Set<String> junk = Set.of();
    private final AutoMineController qth = new AutoMineController();
    private final CraftHelper qti = new CraftHelper();
    private final Map<class_2338, String> qtj = new HashMap<class_2338, String>();
    private final ArrayDeque<class_2338> qtk = new ArrayDeque();
    private Consumer<String> qtl = string -> {};
    private qst qtm = qst.DONE;
    private long qtn;
    private long qto;
    private class_2338 qtp;
    private class_2338 qtq;
    private class_2338 qtr;
    private class_2338 qts;
    private int qtt = -1;
    private boolean qtu;
    private boolean qtv;
    private long qtw;
    private String qtx = "";
    private class_2338 qty;
    private int qtz;
    private long qua;
    private int qub;
    private Object quc;
    private boolean qud;
    private int que;
    private int quf;
    private int qug;
    private long quh;
    private int qui;
    private long quj;
    private long quk;
    private boolean qul;
    private boolean qum;
    private long qun;
    private int quo;
    private int qup;
    private static /* synthetic */ long quq;
    private static /* synthetic */ int qur;

    public StorageRun() {
        this.qth.target(class_26802 -> false);
    }

    public void notes(Consumer<String> consumer) {
        this.qtl = consumer;
    }

    public AutoMineController walker() {
        return this.qth;
    }

    public boolean repairFailed() {
        if (this.qtv && System.currentTimeMillis() - this.qtw > 600000L) {
            this.qtv = false;
        }
        return this.qtv;
    }

    public String status() {
        return this.qtx;
    }

    public boolean running() {
        return this.qtm != qst.DONE;
    }

    public boolean canPause() {
        return this.qty == null && this.quf == 0 && this.qtm != qst.LAYOUT;
    }

    public void begin(long l) {
        this.qto = l;
        this.qtp = null;
        this.qtq = null;
        this.qtr = null;
        this.qts = null;
        this.qtt = -1;
        this.qtu = false;
        this.qty = null;
        this.qtk.clear();
        this.quf = 0;
        this.qum = false;
        this.qun = 0L;
        this.quo = 0;
        this.qup = 0;
        this.qus(qst.FIND, l);
    }

    public void forget() {
        this.qtj.clear();
        this.qtv = false;
    }

    public void stop(class_310 class_3102) {
        this.qth.stop(class_3102);
        this.qwi(class_3102);
        if (class_3102.field_1724 != null && class_3102.field_1755 instanceof class_465) {
            class_3102.field_1724.method_7346();
        }
        this.qtm = qst.DONE;
        this.qty = null;
    }

    public void startTick(class_310 class_3102, class_746 class_7462) {
        if (this.qtm == qst.REPAIR && this.quf == 3 && class_7462.method_6047().method_31574(class_1802.field_8287) && class_3102.field_1755 == null && StorageRun.qwh(class_3102)) {
            this.qth.releaseKeys(class_3102);
            class_3102.field_1690.field_1904.method_23481(true);
            this.qul = true;
            return;
        }
        this.qwi(class_3102);
        if (this.qty != null && this.qtz == 0) {
            this.qth.startTick(class_3102, class_7462);
        } else {
            this.qth.releaseKeys(class_3102);
        }
    }

    public qsq tick(class_310 class_3102, class_746 class_7462, MineTools qof2, AimBrain tel2, qsp qsp2, long l) {
        if (this.qtm == qst.DONE) {
            return qsq.DONE;
        }
        if (l - this.qtn > (this.qtm == qst.REPAIR ? 160000L : 75000L)) {
            this.qtl.accept("Склад: «" + StorageRun.quv(this.qtm) + "» не успел, дальше");
            this.qvn(class_3102);
            this.qth.stop(class_3102);
            this.qwi(class_3102);
            this.qty = null;
            if (this.qtm == qst.REPAIR) {
                this.quf = 0;
                this.qum = false;
                if (class_7462.method_6079().method_31573(class_3489.field_42614) && !qof2.busy()) {
                    qof2.swaps(this.qug, 40);
                }
            }
            this.qut(l);
            return qsq.RUNNING;
        }
        class_1661 class_16612 = class_7462.method_31548();
        boolean bl = this.qty == null;
        switch (this.qtm.ordinal()) {
            case 0: {
                this.qtx = "Склад: ищу сундуки";
                if (l - this.qto < 1500L) break;
                this.quy((class_1937)class_3102.field_1687, class_7462);
                if (this.qtp != null && this.qtq != null && this.qtr != null) {
                    this.qut(l);
                    break;
                }
                if (l - this.qtn <= 4000L) break;
                this.qvb((class_1937)class_3102.field_1687, class_7462);
                this.qus(qst.SCAN, l);
                break;
            }
            case 1: {
                this.qtx = "Склад: смотрю сундуки";
                class_2338 class_23382 = this.qtk.peek();
                if (class_23382 == null) {
                    if (this.qtp == null && this.qtq == null && this.qtr == null) {
                        this.qtl.accept("Не нашёл сундуки склада (таблички «сброс», «золотая морковь», «опыт»)");
                        this.stop(class_3102);
                        return qsq.FAILED;
                    }
                    this.quu("не нашёл: " + this.quw());
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, class_23382, l);
                if (n == 0) break;
                if (n > 0) {
                    String string = StorageRun.role(class_3102.field_1755.method_25440().getString());
                    if (string != null) {
                        this.qtj.put(class_23382, string);
                        this.quz(string, class_23382, class_7462);
                    }
                    this.qvn(class_3102);
                }
                this.qty = null;
                this.qtk.poll();
                break;
            }
            case 2: {
                this.qut(l);
                break;
            }
            case 3: {
                this.qtx = "Склад: стакаю алмазы и золото";
                if (qof2.busy()) break;
                if (!this.qud) {
                    this.qud = true;
                    qof2.compact();
                    break;
                }
                this.qut(l);
                break;
            }
            case 4: {
                this.qtx = "Склад: смотрю опыт";
                if (this.qtr == null) {
                    this.qtu = this.needsRepair(class_7462);
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, this.qtr, l);
                if (n < 0) {
                    this.quu("не открылся сундук «опыт»");
                    this.qty = null;
                    this.qtu = this.needsRepair(class_7462);
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(class_3102, class_7462, l) || !this.qvr(class_3102, class_7462)) break;
                this.qvo(class_3102, l);
                break;
            }
            case 5: {
                String string = this.qtx = this.qtu ? "Склад: крафчу опыт и блоки" : "Склад: крафчу блоки";
                if (this.qts == null || !this.qud && !this.qwa(class_16612) && !this.qtu) {
                    if (this.qts == null && this.qtu) {
                        this.quu("нет верстака у сундука «опыт»");
                    }
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, this.qts, l);
                if (n < 0) {
                    this.quu("не открылся верстак");
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0) break;
                class_437 class_4372 = class_3102.field_1755;
                if (!(class_4372 instanceof class_479)) {
                    this.quu("это не верстак");
                    this.qvo(class_3102, l);
                    break;
                }
                class_479 class_4792 = (class_479)class_4372;
                if (!this.qud) {
                    this.qud = true;
                    if (this.qtu) {
                        ++this.qup;
                    }
                    this.qti.plan(this.qtu, this.qwb(class_16612));
                }
                if (!this.qti.tick(class_3102, class_7462, (class_1714)(class_4372 = (class_1714)class_4792.method_17577()))) break;
                for (String string2 : this.qti.notes()) {
                    this.quu(string2);
                }
                CraftHelper.putBack(class_3102, class_7462, (class_1703)class_4372, -1);
                this.qvo(class_3102, l);
                break;
            }
            case 6: {
                this.qtx = "Склад: беру опыт";
                if (this.qtr == null || !this.qud && (!this.needsRepair(class_7462) || this.qtt == 0 || InventoryCounter.count(class_16612, class_1802.field_8287) >= this.qux(class_7462))) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, this.qtr, l);
                if (n < 0) {
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(class_3102, class_7462, l) || !this.qvt(class_3102, class_7462, class_1802.field_8287, this.qux(class_7462))) break;
                this.qtt = this.qvs(class_3102, class_7462, class_1802.field_8287);
                this.qvo(class_3102, l);
                break;
            }
            case 7: {
                if (this.qun == 0L) {
                    this.qun = l;
                }
                this.qtx = "Склад: чиню кирку" + (this.quf == 3 ? " (FastUse)" : "") + " · " + Math.max(0, InventoryCounter.pickaxeDurability(class_7462)) + " / " + this.repairTo;
                if (!this.qwe(class_3102, class_7462, qof2, qsp2, l)) break;
                this.qwc(class_7462, l);
                break;
            }
            case 8: {
                this.qtx = "Склад: убираю опыт";
                if (this.qtr == null || !this.qud && InventoryCounter.count(class_16612, class_1802.field_8287) == 0) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, this.qtr, l);
                if (n < 0) {
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(class_3102, class_7462, l) || !this.qvu(class_3102, class_7462, class_17992 -> class_17992.method_31574(class_1802.field_8287))) break;
                this.qvo(class_3102, l);
                break;
            }
            case 9: {
                this.qtx = "Склад: складываю в сброс";
                if (this.qtp == null || !this.qud && !StorageRun.qvx(class_16612)) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, this.qtp, l);
                if (n < 0) {
                    this.quu("не открылся сундук «сброс»");
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(class_3102, class_7462, l) || !this.qvy(class_3102, class_7462)) break;
                this.qvo(class_3102, l);
                break;
            }
            case 10: {
                if (qof2.busy()) break;
                int n = InventoryCounter.emptySlot(class_16612);
                if (!this.qud) {
                    StorageRun.log("food prep: off=" + class_7462.method_6079() + " inInv=" + InventoryCounter.find(class_16612, class_1802.field_8071) + " empty=" + n + " food=" + InventoryCounter.food((class_1657)class_7462));
                    this.qud = true;
                    if (this.qtq != null && InventoryCounter.food((class_1657)class_7462) < 64 && class_7462.method_6079().method_31574(class_1802.field_8071) && InventoryCounter.find(class_16612, class_1802.field_8071) < 0 && n >= 0) {
                        qof2.swaps(n, 40);
                        break;
                    }
                }
                this.qut(l);
                break;
            }
            case 11: {
                this.qtx = "Склад: беру золотую морковь";
                if (this.qtq == null || !this.qud && InventoryCounter.food((class_1657)class_7462) >= 64) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(class_3102, class_7462, tel2, qsp2, this.qtq, l);
                if (n < 0) {
                    this.quu("не открылся сундук «золотая морковь»");
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(class_3102, class_7462, l) || !this.qvv(class_3102, class_7462)) break;
                this.qvo(class_3102, l);
                break;
            }
            case 12: {
                this.qtx = "Склад: раскладываю инвентарь";
                if (qof2.busy()) break;
                if (class_3102.field_1755 != null) {
                    this.qvn(class_3102);
                    break;
                }
                if (!this.qud) {
                    this.qud = true;
                    qof2.layout();
                    break;
                }
                if (class_16612.method_5438(0).method_31573(class_3489.field_42614)) {
                    class_16612.method_61496(0);
                }
                this.qut(l);
                break;
            }
        }
        if (this.qtm == qst.DONE) {
            this.qth.stop(class_3102);
            return qsq.DONE;
        }
        if (this.qty != null && this.qtz == 0) {
            this.qth.endTick(class_3102, class_7462, tel2);
        } else if (!(this.qtm == qst.REPAIR && this.quf >= 1 || !bl && this.qtz == 1)) {
            qsp2.at(class_3102, class_7462, null, null);
        }
        return qsq.RUNNING;
    }

    static void log(String string) {
        Consumer<String> consumer = trace;
        if (consumer != null) {
            consumer.accept(string);
        }
    }

    private void qus(qst qst2, long l) {
        StorageRun.log("step " + (Object)((Object)qst2));
        this.qtm = qst2;
        this.qtn = l;
        this.qud = false;
        this.que = 0;
    }

    private void qut(long l) {
        this.qvn(class_310.method_1551());
        this.qty = null;
        qst[] qstArray = qst.values();
        this.qus(qstArray[Math.min(qstArray.length - 1, this.qtm.ordinal() + 1)], l);
        if (this.qtm == qst.SCAN) {
            this.qus(qst.JUNK, l);
        }
    }

    private void quu(String string) {
        this.qtl.accept("Склад: " + string);
    }

    private static String quv(qst qst2) {
        return switch (qst2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 1 -> "поиск сундуков";
            case 2 -> "мусор";
            case 3 -> "стаки";
            case 4, 6 -> "опыт";
            case 5 -> "крафт";
            case 7 -> "починка";
            case 8 -> "убрать опыт";
            case 9 -> "сброс";
            case 10, 11 -> "морковь";
            case 12 -> "раскладка";
            case 13 -> "готово";
        };
    }

    private String quw() {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (this.qtp == null) {
            arrayList.add("сброс");
        }
        if (this.qtq == null) {
            arrayList.add("морковь");
        }
        if (this.qtr == null) {
            arrayList.add("опыт");
        }
        if (this.qts == null) {
            arrayList.add("верстак");
        }
        return String.join((CharSequence)", ", arrayList);
    }

    public boolean needsRepair(class_746 class_7462) {
        int n = InventoryCounter.pickaxeDurability(class_7462);
        return n >= 0 && n < this.repairTo && !this.repairFailed();
    }

    private int qux(class_746 class_7462) {
        int n = Math.max(0, InventoryCounter.pickaxeDurability(class_7462));
        return Math.max(64, Math.min(768, (this.repairTo - n) / 10 + 32));
    }

    private void quy(class_1937 class_19372, class_746 class_7462) {
        List list;
        Object object;
        Object object2;
        class_2338 class_23382 = class_7462.method_24515();
        double[] dArray = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
        class_2338[] class_2338Array = new class_2338[3];
        for (int i = class_23382.method_10263() - 24 >> 4; i <= class_23382.method_10263() + 24 >> 4; ++i) {
            for (int j = class_23382.method_10260() - 24 >> 4; j <= class_23382.method_10260() + 24 >> 4; ++j) {
                object2 = class_19372.method_8497(i, j);
                object = new ArrayList(object2.method_12214().values()).iterator();
                while (object.hasNext()) {
                    String string;
                    String string2;
                    class_2586 class_25862 = (class_2586)object.next();
                    if (!(class_25862 instanceof class_2625)) continue;
                    class_2625 class_26252 = (class_2625)class_25862;
                    if (!class_25862.method_11016().method_19771((class_2382)class_23382, 24.0) || (string2 = StorageRun.role(string = StorageRun.qvc(class_26252))) == null) continue;
                    class_2338 class_23383 = StorageRun.qvd(class_19372, class_26252.method_11016(), class_19372.method_8320(class_26252.method_11016()));
                    StorageRun.qva(string2, class_23383, class_23382, class_2338Array, dArray);
                }
            }
        }
        if (class_19372 instanceof class_638) {
            class_638 class_6382 = (class_638)class_19372;
            list = class_6382.method_18112();
        } else {
            list = List.of();
        }
        for (class_1297 class_12972 : list) {
            if (class_12972 == class_7462 || !class_12972.method_24515().method_19771((class_2382)class_23382, 24.0) || (object2 = TimerTextParser.lines(class_12972)).isEmpty() || (object = StorageRun.role(String.join((CharSequence)" ", (Iterable<? extends CharSequence>)object2))) == null) continue;
            StorageRun.qva((String)object, StorageRun.qve(class_19372, class_12972.method_24515(), 2), class_23382, class_2338Array, dArray);
        }
        for (Map.Entry entry : this.qtj.entrySet()) {
            if (!StorageRun.qvg(class_19372.method_8320((class_2338)entry.getKey())) || !((class_2338)entry.getKey()).method_19771((class_2382)class_23382, 24.0)) continue;
            StorageRun.qva((String)entry.getValue(), (class_2338)entry.getKey(), class_23382, class_2338Array, dArray);
        }
        if (class_2338Array[0] != null) {
            this.qtp = class_2338Array[0];
        }
        if (class_2338Array[1] != null) {
            this.qtq = class_2338Array[1];
        }
        if (class_2338Array[2] != null) {
            this.qtr = class_2338Array[2];
        }
        class_2338 class_23383 = this.qts = this.qtr != null ? StorageRun.qvf(class_19372, this.qtr, 6, class_2246.field_9980) : null;
        if (this.qts == null) {
            this.qts = StorageRun.qvf(class_19372, class_23382, 12, class_2246.field_9980);
        }
    }

    public boolean atHome(class_1937 class_19372, class_746 class_7462, double d) {
        if (class_19372 == null) {
            return false;
        }
        class_243 class_2432 = class_7462.method_33571();
        class_2338 class_23382 = class_7462.method_24515();
        int n = (int)Math.ceil(d) + 1;
        for (int i = class_23382.method_10263() - n >> 4; i <= class_23382.method_10263() + n >> 4; ++i) {
            for (int j = class_23382.method_10260() - n >> 4; j <= class_23382.method_10260() + n >> 4; ++j) {
                for (class_2586 class_25862 : new ArrayList(class_19372.method_8497(i, j).method_12214().values())) {
                    if (!(class_25862 instanceof class_2625)) continue;
                    class_2625 class_26252 = (class_2625)class_25862;
                    if (!(class_243.method_24953((class_2382)class_25862.method_11016()).method_1022(class_2432) <= d) || StorageRun.role(StorageRun.qvc(class_26252)) == null) continue;
                    return true;
                }
            }
        }
        for (Map.Entry<class_2338, String> entry : this.qtj.entrySet()) {
            if (!(class_243.method_24953((class_2382)((class_2382)entry.getKey())).method_1022(class_2432) <= d) || !StorageRun.qvg(class_19372.method_8320(entry.getKey()))) continue;
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private void quz(String var1_1, class_2338 var2_2, class_746 var3_3) {
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

    /*
     * Exception decompiling
     */
    private static void qva(String var0, class_2338 var1_1, class_2338 var2_2, class_2338[] var3_3, double[] var4_4) {
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

    private void qvb(class_1937 class_19372, class_746 class_7462) {
        this.qtk.clear();
        class_2338 class_23382 = class_7462.method_24515();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        for (class_2338 class_23383 : class_2338.method_25996((class_2338)class_23382, (int)10, (int)4, (int)10)) {
            if (!StorageRun.qvg(class_19372.method_8320(class_23383)) || class_23383.equals((Object)this.qtp) || class_23383.equals((Object)this.qtq) || class_23383.equals((Object)this.qtr) || this.qtj.containsKey(class_23383)) continue;
            arrayList.add(class_23383.method_10062());
        }
        for (int i = 0; i < arrayList.size() && this.qtk.size() < 8; ++i) {
            class_2338 class_23383;
            class_23383 = (class_2338)arrayList.get(i);
            boolean bl = false;
            for (class_2338 class_23384 : this.qtk) {
                if (class_23384.method_19455((class_2382)class_23383) != 1 || !(class_19372.method_8320(class_23384).method_26204() instanceof class_2281)) continue;
                bl = true;
            }
            if (bl) continue;
            this.qtk.add(class_23383);
        }
    }

    static String role(String string) {
        String string2 = EnchantNameUtil.title(string);
        if (string2.contains("сброс")) {
            return "dump";
        }
        if (string2.contains("морков") || string2.contains("еда")) {
            return "food";
        }
        if (string2.contains("опыт") || string2.contains("пузыр")) {
            return "xp";
        }
        return null;
    }

    private static String qvc(class_2625 class_26252) {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean bl : new boolean[]{true, false}) {
            for (class_2561 class_25612 : class_26252.method_49843(bl).method_49877(false)) {
                stringBuilder.append(class_25612.getString()).append(' ');
            }
        }
        return stringBuilder.toString();
    }

    private static class_2338 qvd(class_1937 class_19372, class_2338 class_23382, class_2680 class_26802) {
        class_2338 class_23383;
        class_2350 class_23502 = null;
        if (class_26802.method_26204() instanceof class_2551) {
            class_23502 = (class_2350)class_26802.method_11654((class_2769)class_2551.field_11726);
        } else if (class_26802.method_26204() instanceof class_7715) {
            class_23502 = (class_2350)class_26802.method_11654((class_2769)class_7715.field_40319);
        }
        if (class_23502 != null && StorageRun.qvg(class_19372.method_8320(class_23383 = class_23382.method_10093(class_23502.method_10153())))) {
            return class_23383;
        }
        if (StorageRun.qvg(class_19372.method_8320(class_23382.method_10074()))) {
            return class_23382.method_10074();
        }
        return StorageRun.qve(class_19372, class_23382, 2);
    }

    private static class_2338 qve(class_1937 class_19372, class_2338 class_23382, int n) {
        for (class_2338 class_23383 : class_2338.method_25996((class_2338)class_23382, (int)n, (int)n, (int)n)) {
            if (!StorageRun.qvg(class_19372.method_8320(class_23383))) continue;
            return class_23383.method_10062();
        }
        return null;
    }

    private static class_2338 qvf(class_1937 class_19372, class_2338 class_23382, int n, class_2248 class_22482) {
        for (class_2338 class_23383 : class_2338.method_25996((class_2338)class_23382, (int)n, (int)n, (int)n)) {
            if (!class_19372.method_8320(class_23383).method_27852(class_22482)) continue;
            return class_23383.method_10062();
        }
        return null;
    }

    private static boolean qvg(class_2680 class_26802) {
        class_2248 class_22482 = class_26802.method_26204();
        return class_22482 instanceof class_2281 || class_22482 instanceof class_3708 || class_22482 instanceof class_2480;
    }

    private int qvh(class_310 class_3102, class_746 class_7462, AimBrain tel2, qsp qsp2, class_2338 class_23382, long l) {
        if (!class_23382.equals((Object)this.qty)) {
            this.qvn(class_3102);
            this.qty = class_23382;
            this.qtz = 0;
            this.qua = l;
            this.qub = 0;
            this.qth.stop(class_3102);
        }
        switch (this.qtz) {
            case 0: {
                if (StorageRun.qvj(class_7462, class_23382) <= 4.3 && StorageRun.qvk((class_1937)class_3102.field_1687, class_7462, class_23382) != null) {
                    this.qth.stop(class_3102);
                    this.qtz = 1;
                    this.qua = l;
                    this.quc = new Object();
                    return 0;
                }
                if (this.qth.status() == qdw.IDLE) {
                    this.qth.park(Box3.empty(class_7462.method_24515()), class_23382, false);
                } else if (this.qth.parked() || this.qth.parkLost() || this.qth.status() == qdw.FAR) {
                    if (StorageRun.qvj(class_7462, class_23382) <= 5.3) {
                        this.qth.stop(class_3102);
                        this.qtz = 1;
                        this.qua = l;
                        this.quc = new Object();
                        return 0;
                    }
                    if (l - this.qua > 3000L) {
                        this.qth.stop(class_3102);
                        return -1;
                    }
                }
                if (l - this.qua > 25000L) {
                    this.qth.stop(class_3102);
                    return -1;
                }
                return 0;
            }
            case 1: {
                class_3965 class_39652;
                class_243 class_2432 = StorageRun.qvk((class_1937)class_3102.field_1687, class_7462, class_23382);
                qsp2.at(class_3102, class_7462, this.quc, class_2432 != null ? class_2432 : StorageRun.qvl(class_7462, class_23382));
                class_3102.field_1773.method_3190(1.0f);
                class_239 class_2392 = class_3102.field_1765;
                if (class_2392 instanceof class_3965 && (class_39652 = (class_3965)class_2392).method_17783() == class_239.class_240.field_1332 && StorageRun.qvi((class_1937)class_3102.field_1687, class_39652.method_17777(), class_23382)) {
                    class_2392 = class_3102.field_1761.method_2896(class_7462, class_1268.field_5808, class_39652);
                    if (class_2392.method_23665()) {
                        class_7462.method_6104(class_1268.field_5808);
                    }
                    this.qtz = 2;
                    this.qua = l;
                } else if (l - this.qua > 3000L) {
                    return ++this.qub > 2 ? -1 : 0;
                }
                return 0;
            }
        }
        if (class_3102.field_1755 instanceof class_465) {
            return 1;
        }
        if (l - this.qua > 2500L) {
            if (++this.qub > 2) {
                return -1;
            }
            this.qtz = 1;
            this.qua = l;
            this.quc = new Object();
        }
        return 0;
    }

    private static boolean qvi(class_1937 class_19372, class_2338 class_23382, class_2338 class_23383) {
        if (class_23382.equals((Object)class_23383)) {
            return true;
        }
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        return class_26802.method_26204() instanceof class_2281 && class_26802.method_26204() == class_19372.method_8320(class_23383).method_26204() && class_23382.method_19455((class_2382)class_23383) == 1;
    }

    private static double qvj(class_746 class_7462, class_2338 class_23382) {
        class_243 class_2432 = class_7462.method_33571();
        class_238 class_2383 = new class_238(class_23382);
        double d = Math.max(0.0, Math.max(class_2383.field_1323 - class_2432.field_1352, class_2432.field_1352 - class_2383.field_1320));
        double d2 = Math.max(0.0, Math.max(class_2383.field_1322 - class_2432.field_1351, class_2432.field_1351 - class_2383.field_1325));
        double d3 = Math.max(0.0, Math.max(class_2383.field_1321 - class_2432.field_1350, class_2432.field_1350 - class_2383.field_1324));
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    private static class_243 qvk(class_1937 class_19372, class_746 class_7462, class_2338 class_23382) {
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_7462.method_5828(1.0f);
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        arrayList.add(StorageRun.qvl(class_7462, class_23382));
        class_243 class_2434 = class_243.method_24953((class_2382)class_23382);
        for (Object object : class_2350.values()) {
            double d = object == class_2350.field_11036 ? 0.33 : 0.4;
            arrayList.add(class_2434.method_1031((double)object.method_10148() * d, (double)object.method_10164() * d, (double)object.method_10165() * d));
        }
        class_243 class_2435 = null;
        double d = Double.MAX_VALUE;
        for (class_243 class_2436 : arrayList) {
            double d2;
            class_3965 class_39652;
            class_243 class_2437 = class_2436.method_1020(class_2432);
            double d3 = class_2437.method_1033();
            if (d3 > 4.7 || d3 < 0.001 || (class_39652 = class_19372.method_17742(new class_3959(class_2432, class_2436.method_1019(class_2437.method_1021(0.05 / d3)), class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)class_7462))).method_17783() != class_239.class_240.field_1332 || !StorageRun.qvi(class_19372, class_39652.method_17777(), class_23382) || !((d2 = Math.acos(Math.max(-1.0, Math.min(1.0, class_2437.method_1021(1.0 / d3).method_1026(class_2433))))) < d)) continue;
            d = d2;
            class_2435 = class_2436;
        }
        return class_2435;
    }

    private static class_243 qvl(class_746 class_7462, class_2338 class_23382) {
        class_243 class_2432 = class_7462.method_33571();
        return new class_243(StorageRun.qvm(class_2432.field_1352, (double)class_23382.method_10263() + 0.3, (double)class_23382.method_10263() + 0.7), StorageRun.qvm(class_2432.field_1351, (double)class_23382.method_10264() + 0.3, (double)class_23382.method_10264() + 0.65), StorageRun.qvm(class_2432.field_1350, (double)class_23382.method_10260() + 0.3, (double)class_23382.method_10260() + 0.7));
    }

    private static double qvm(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    private void qvn(class_310 class_3102) {
        if (class_3102.field_1724 != null && class_3102.field_1755 instanceof class_465) {
            class_3102.field_1724.method_7346();
        }
    }

    private void qvo(class_310 class_3102, long l) {
        this.qvn(class_3102);
        this.qty = null;
        this.qut(l);
    }

    private boolean qvp(class_310 class_3102, class_746 class_7462, long l) {
        if (!this.qud) {
            this.qud = true;
            this.qua = l;
            return false;
        }
        return l - this.qua >= 250L && class_3102.field_1755 instanceof class_465;
    }

    private class_1703 qvq(class_310 class_3102) {
        class_1703 class_17032;
        class_437 class_4372 = class_3102.field_1755;
        if (class_4372 instanceof class_465) {
            class_465 class_4652 = (class_465)class_4372;
            class_17032 = class_4652.method_17577();
        } else {
            class_17032 = null;
        }
        return class_17032;
    }

    private boolean qvr(class_310 class_3102, class_746 class_7462) {
        class_1703 class_17032 = this.qvq(class_3102);
        if (class_17032 == null) {
            return true;
        }
        if (this.qtt < 0) {
            this.qtt = this.qvs(class_3102, class_7462, class_1802.field_8287);
            this.qtu = this.qtt < this.xpStock;
            this.quu("опыта в сундуке " + this.qtt + (this.qtu ? " — меньше " + this.xpStock + ", скрафчу" : ""));
        }
        if (this.qtu || !this.needsRepair(class_7462)) {
            return true;
        }
        if (this.qvt(class_3102, class_7462, class_1802.field_8287, this.qux(class_7462))) {
            this.qtt = this.qvs(class_3102, class_7462, class_1802.field_8287);
            return true;
        }
        return false;
    }

    private int qvs(class_310 class_3102, class_746 class_7462, class_1792 class_17922) {
        class_1703 class_17032 = this.qvq(class_3102);
        if (class_17032 == null) {
            return -1;
        }
        int n = 0;
        for (class_1735 class_17352 : SlotUtil.own(class_17032, class_7462.method_31548())) {
            if (!class_17352.method_7677().method_31574(class_17922)) continue;
            n += class_17352.method_7677().method_7947();
        }
        return n;
    }

    private boolean qvt(class_310 class_3102, class_746 class_7462, class_1792 class_17922, int n) {
        class_1703 class_17032 = this.qvq(class_3102);
        if (class_17032 == null) {
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            if (CraftHelper.count(class_17032, class_7462, class_17922) >= n || ++this.que > 60) {
                return true;
            }
            class_1735 class_17352 = null;
            for (class_1735 class_17353 : SlotUtil.own(class_17032, class_7462.method_31548())) {
                if (!class_17353.method_7677().method_31574(class_17922)) continue;
                class_17352 = class_17353;
                break;
            }
            if (class_17352 == null || !SlotUtil.hasRoom(class_17032, class_7462.method_31548(), class_17352.method_7677())) {
                return true;
            }
            SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7794);
        }
        return false;
    }

    private boolean qvu(class_310 class_3102, class_746 class_7462, Predicate<class_1799> predicate) {
        class_1703 class_17032 = this.qvq(class_3102);
        if (class_17032 == null) {
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            class_1735 class_17352 = null;
            for (class_1735 class_17353 : class_17032.field_7761) {
                if (class_17353.field_7871 != class_7462.method_31548() || !predicate.test(class_17353.method_7677())) continue;
                class_17352 = class_17353;
                break;
            }
            if (class_17352 == null || ++this.que > 80) {
                return true;
            }
            int n = class_17352.method_7677().method_7947();
            SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7794);
            if (class_17352.method_7677().method_7947() != n) continue;
            this.quu("сундук полон");
            return true;
        }
        return false;
    }

    private boolean qvv(class_310 class_3102, class_746 class_7462) {
        class_1703 class_17032 = this.qvq(class_3102);
        if (class_17032 == null) {
            return true;
        }
        if (!class_17032.method_34255().method_7960()) {
            CraftHelper.putBack(class_3102, class_7462, class_17032, -1);
            return false;
        }
        int n = InventoryCounter.food((class_1657)class_7462);
        if (n >= 64 || ++this.que > 30) {
            return true;
        }
        class_1735 object = null;
        for (class_1735 object2 : SlotUtil.own(class_17032, class_7462.method_31548())) {
            if (!object2.method_7677().method_31574(class_1802.field_8071)) continue;
            object = object2;
            break;
        }
        if (object == null) {
            this.quu("в сундуке нет золотой моркови");
            return true;
        }
        class_1735 class_17352 = null;
        for (class_1735 class_17353 : class_17032.field_7761) {
            if (class_17353.field_7871 != class_7462.method_31548() || !class_17353.method_7677().method_31574(class_1802.field_8071) || class_17353.method_7677().method_7947() >= class_17353.method_7677().method_7914()) continue;
            class_17352 = class_17353;
            break;
        }
        if (class_17352 == null) {
            for (class_1735 class_17353 : class_17032.field_7761) {
                if (class_17353.field_7871 != class_7462.method_31548() || class_17353.method_7681()) continue;
                class_17352 = class_17353;
                break;
            }
        }
        if (class_17352 == null) {
            this.quu("нет места для моркови");
            return true;
        }
        SlotUtil.click(class_3102, class_17032, object.field_7874, 0, class_1713.field_7790);
        int n2 = 64 - n;
        if (class_17352.method_7681() || class_17032.method_34255().method_7947() <= n2 || n2 > 8) {
            SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7790);
        } else {
            for (int i = 0; i < n2 && !class_17032.method_34255().method_7960(); ++i) {
                SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 1, class_1713.field_7790);
            }
        }
        if (!class_17032.method_34255().method_7960()) {
            SlotUtil.click(class_3102, class_17032, object.field_7874, 0, class_1713.field_7790);
        }
        return false;
    }

    private static int[] qvw(class_1661 class_16612) {
        for (int i = 0; i < 36; ++i) {
            if (!StorageRun.dumpable(class_16612.method_5438(i))) continue;
            return new int[]{i, 0};
        }
        return null;
    }

    static boolean dumpable(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8603) || class_17992.method_31574(class_1802.field_8494) || class_17992.method_31574(class_1802.field_22019) || class_17992.method_31574(class_1802.field_22021);
    }

    private static boolean qvx(class_1661 class_16612) {
        return StorageRun.qvw(class_16612) != null;
    }

    private boolean qvy(class_310 class_3102, class_746 class_7462) {
        class_1703 class_17032 = this.qvq(class_3102);
        if (class_17032 == null) {
            return true;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (!class_17032.method_34255().method_7960()) {
            if (!this.qvz(class_3102, class_7462, class_17032)) {
                CraftHelper.putBack(class_3102, class_7462, class_17032, -1);
                this.quu("сундук «сброс» полон");
                return true;
            }
            return false;
        }
        int[] nArray = StorageRun.qvw(class_16612);
        if (nArray == null || ++this.que > 120) {
            return true;
        }
        int n = InventoryClicks.slotId(class_17032, (class_1263)class_16612, nArray[0]);
        if (n < 0) {
            return true;
        }
        class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
        int n2 = class_17352.method_7677().method_7947();
        if (nArray[1] == 0) {
            SlotUtil.click(class_3102, class_17032, n, 0, class_1713.field_7794);
            if (class_17352.method_7677().method_7947() == n2) {
                this.quu("сундук «сброс» полон");
                return true;
            }
            return false;
        }
        SlotUtil.click(class_3102, class_17032, n, 0, class_1713.field_7790);
        for (int i = 0; i < nArray[1]; ++i) {
            SlotUtil.click(class_3102, class_17032, n, 1, class_1713.field_7790);
        }
        return false;
    }

    private boolean qvz(class_310 class_3102, class_746 class_7462, class_1703 class_17032) {
        class_1799 class_17992 = class_17032.method_34255();
        class_1735 class_17352 = null;
        for (class_1735 class_17353 : SlotUtil.own(class_17032, class_7462.method_31548())) {
            if (!class_17353.method_7681() || !class_1799.method_31577((class_1799)class_17353.method_7677(), (class_1799)class_17992) || class_17353.method_7677().method_7947() >= class_17353.method_7677().method_7914()) continue;
            class_17352 = class_17353;
            break;
        }
        if (class_17352 == null) {
            for (class_1735 class_17353 : SlotUtil.own(class_17032, class_7462.method_31548())) {
                if (class_17353.method_7681()) continue;
                class_17352 = class_17353;
                break;
            }
        }
        if (class_17352 == null) {
            return false;
        }
        SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7790);
        return true;
    }

    private boolean qwa(class_1661 class_16612) {
        return InventoryCounter.count(class_16612, class_1802.field_8477) >= 25 || InventoryCounter.count(class_16612, class_1802.field_8695) >= this.qwb(class_16612) + 9 || InventoryCounter.count(class_16612, class_1802.field_8397) >= 9;
    }

    private int qwb(class_1661 class_16612) {
        return this.qtp != null ? 15 : InventoryCounter.keepGold(class_16612);
    }

    private void qwc(class_746 class_7462, long l) {
        boolean bl = this.qum;
        this.qum = false;
        if (bl && this.needsRepair(class_7462)) {
            int n = Math.max(0, InventoryCounter.pickaxeDurability(class_7462));
            if (this.quo >= 10 || l - this.qun > 360000L) {
                this.quu(Lang.s("the bottles ran out, durability ", "пузырьки кончились, прочность ") + n + Lang.s(" (enough trips for more)", " (хватит ходить за новыми)"));
            } else {
                if (this.qtr != null && this.qtt != 0) {
                    ++this.quo;
                    this.quu(Lang.s("the bottles ran out at ", "пузырьки кончились на ") + n + Lang.s(" — more from the chest", " — беру ещё из сундука"));
                    this.qty = null;
                    this.qus(qst.XP_TAKE, l);
                    return;
                }
                if (this.qwd(class_7462.method_31548())) {
                    ++this.quo;
                    this.quu(Lang.s("the bottles ran out at ", "пузырьки кончились на ") + n + Lang.s(" — crafting more", " — крафчу ещё"));
                    this.qtu = true;
                    this.qty = null;
                    this.qus(qst.CRAFT, l);
                    return;
                }
                this.quu(Lang.s("no bottles left anywhere, durability ", "опыта больше нет нигде, прочность ") + n);
            }
        }
        this.qut(l);
    }

    private boolean qwd(class_1661 class_16612) {
        return this.qts != null && this.qup < 2 && !this.qti.xpFailed() && InventoryCounter.count(class_16612, class_1802.field_8603) > 2;
    }

    private boolean qwe(class_310 class_3102, class_746 class_7462, MineTools qof2, qsp qsp2, long l) {
        class_1661 class_16612 = class_7462.method_31548();
        switch (this.quf) {
            case 0: {
                if (qof2.busy()) {
                    return false;
                }
                if (class_3102.field_1755 != null) {
                    this.qvn(class_3102);
                    return false;
                }
                int n = InventoryCounter.pickaxe(class_16612);
                int n2 = InventoryCounter.find(class_16612, class_1802.field_8287);
                if (!this.needsRepair(class_7462) || n < 0 || n2 < 0) {
                    if (this.needsRepair(class_7462) && n2 < 0 && n >= 0) {
                        if (this.qtt == 0 || this.qtr == null) {
                            this.qum = true;
                        } else {
                            this.quu("нечем чинить кирку — нет пузырьков опыта");
                        }
                    }
                    return true;
                }
                this.qug = n;
                int n3 = class_16612.method_67532();
                if (n2 < 9 && n2 != n) {
                    class_16612.method_61496(n2);
                    qof2.swaps(n, 40);
                } else {
                    if (n3 == n) {
                        n3 = n == 8 ? 7 : n + 1;
                        class_16612.method_61496(n3);
                    }
                    qof2.swaps(n, 40, n2, n3);
                }
                this.quf = 1;
                this.quh = l;
                break;
            }
            case 1: {
                if (qof2.busy()) {
                    return false;
                }
                if (!class_7462.method_6079().method_31573(class_3489.field_42614) || !class_7462.method_6047().method_31574(class_1802.field_8287)) {
                    this.quu("не смог взять кирку во вторую руку");
                    this.quf = 4;
                    return false;
                }
                this.quf = 2;
                this.qui = InventoryCounter.durability(class_7462.method_6079());
                this.quj = l;
                this.quh = l;
                this.quk = l;
                break;
            }
            case 2: {
                if (class_3102.field_1755 instanceof class_465) {
                    this.qvn(class_3102);
                    return false;
                }
                class_2338 class_23382 = StorageRun.qwf((class_1937)class_3102.field_1687, class_7462);
                qsp2.at(class_3102, class_7462, this, class_23382 == null ? class_7462.method_73189().method_1031(0.0, -1.0, 0.0) : new class_243((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 0.95, (double)class_23382.method_10260() + 0.5));
                class_3102.field_1773.method_3190(1.0f);
                if (!(class_7462.method_36455() >= 60.0f && StorageRun.qwh(class_3102)) && l - this.quk <= 3000L) break;
                this.quf = 3;
                this.quj = l;
                class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1904);
                if (class_3062.equals((Object)class_3675.field_16237)) break;
                class_304.method_1420((class_3675.class_306)class_3062);
                break;
            }
            case 3: {
                if (class_3102.field_1755 instanceof class_465 || !StorageRun.qwh(class_3102)) {
                    this.qwi(class_3102);
                    this.qvn(class_3102);
                    this.quf = 2;
                    this.quk = l;
                    return false;
                }
                class_2338 class_23383 = StorageRun.qwf((class_1937)class_3102.field_1687, class_7462);
                qsp2.at(class_3102, class_7462, this, class_23383 == null ? class_7462.method_73189().method_1031(0.0, -1.0, 0.0) : new class_243((double)class_23383.method_10263() + 0.5, (double)class_23383.method_10264() + 0.95, (double)class_23383.method_10260() + 0.5));
                int n = InventoryCounter.durability(class_7462.method_6079());
                if (trace != null && (l - this.quh) % 1000L < 50L) {
                    StorageRun.log("repair main=" + class_7462.method_6047() + " off=" + class_7462.method_6079() + " dur=" + n + " pitch=" + (int)class_7462.method_36455() + " use=" + class_3102.field_1690.field_1904.method_1434() + " using=" + class_7462.method_6115());
                }
                if (n > this.qui) {
                    this.qui = n;
                    this.quj = l;
                }
                if (!class_7462.method_6079().method_31573(class_3489.field_42614) || n >= this.repairTo) {
                    this.quf = 4;
                    return false;
                }
                if (!class_7462.method_6047().method_31574(class_1802.field_8287)) {
                    int n4 = InventoryCounter.find(class_16612, class_1802.field_8287);
                    if (n4 < 0) {
                        this.qum = true;
                        this.quf = 4;
                    } else if (!qof2.busy()) {
                        this.qwi(class_3102);
                        qof2.swaps(n4, class_16612.method_67532());
                        this.quf = 1;
                    }
                    return false;
                }
                AutoRepair.repairing(class_3102);
                if (l - this.quj > 9000L) {
                    this.quu("кирка не чинится (нет «Починки»?)");
                    this.qtv = true;
                    this.qtw = System.currentTimeMillis();
                    this.quf = 4;
                    break;
                }
                if (l - this.quh <= 150000L && l - this.qun <= 360000L) break;
                this.quu(Lang.s("the repair took too long, durability ", "починка затянулась, прочность ") + n);
                this.quf = 4;
                break;
            }
            case 4: {
                this.qwi(class_3102);
                if (qof2.busy()) {
                    return false;
                }
                if (class_7462.method_6079().method_31573(class_3489.field_42614)) {
                    qof2.swaps(this.qug, 40);
                }
                this.quf = 5;
                break;
            }
            default: {
                if (qof2.busy()) {
                    return false;
                }
                if (!this.qum) {
                    this.quu("кирка починена до " + Math.max(0, InventoryCounter.pickaxeDurability(class_7462)));
                }
                this.quf = 0;
                return true;
            }
        }
        return false;
    }

    private static class_2338 qwf(class_1937 class_19372, class_746 class_7462) {
        class_2338 class_23382 = class_7462.method_24515().method_10074();
        for (class_2338 class_23383 : class_2338.method_25996((class_2338)class_23382, (int)1, (int)0, (int)1)) {
            if (!StorageRun.qwg(class_19372, class_23383)) continue;
            return class_23383.method_10062();
        }
        return null;
    }

    private static boolean qwg(class_1937 class_19372, class_2338 class_23382) {
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        return class_26802.method_26212((class_1922)class_19372, class_23382) && !class_26802.method_31709() && class_26802.method_26196(class_19372, class_23382) == null;
    }

    private static boolean qwh(class_310 class_3102) {
        class_3965 class_39652;
        class_239 class_2392 = class_3102.field_1765;
        if (!(class_2392 instanceof class_3965) || (class_39652 = (class_3965)class_2392).method_17783() != class_239.class_240.field_1332) {
            return true;
        }
        return StorageRun.qwg((class_1937)class_3102.field_1687, class_39652.method_17777());
    }

    private void qwi(class_310 class_3102) {
        if (this.qul && class_3102.field_1690 != null && class_3102.method_22683() != null) {
            class_3102.field_1690.field_1904.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3102.field_1690.field_1904));
        }
        this.qul = false;
    }

    private static /* synthetic */ int bvz(int n, int n2) {
        return n + n2 ^ 0x65BF8133;
    }

    private static /* synthetic */ int bwa(int n, int n2) {
        return StorageRun.bvz(n, n2) + n;
    }

    private static /* synthetic */ int bwb(int n, int n2) {
        return StorageRun.bwa(n, n2) + n;
    }
}

