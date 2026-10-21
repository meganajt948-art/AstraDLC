/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1714
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_640
 *  net.minecraft.class_746
 */
package a;

import a.qbf;
import a.qbi;
import a.qbl;
import a.StorageRun;
import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1714;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_640;
import net.minecraft.class_746;

final class CraftHelper {
    static final int XP_DIAMOND_BLOCKS = 15;
    private final ArrayDeque<qbf> qbp = new ArrayDeque();
    private final List<String> qbq = new ArrayList<String>();
    private int qbr;
    private int qbs;
    private int qbt = -1;
    private int qbu;
    private boolean qbv;
    private int qbw = -1;
    private int qbx;
    private int qby;
    private static /* synthetic */ int qbz;
    private static /* synthetic */ long qca;

    CraftHelper() {
    }

    void plan(boolean bl, int n) {
        this.qbp.clear();
        this.qbq.clear();
        this.qbr = 0;
        this.qbs = 0;
        this.qbt = -1;
        this.qbu = 0;
        this.qbv = false;
        this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
        this.qcb();
        if (bl) {
            this.qbp.add(new qbf(qbi.PLAN_XP, null, null, 0));
        }
        this.qbp.add(new qbf(qbi.KEEP, class_1802.field_8477, class_1802.field_8603, 16));
        this.qbp.add(new qbf(qbi.KEEP, class_1802.field_8695, class_1802.field_8494, n));
        this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
    }

    private void qcb() {
        this.qbp.add(new qbf(qbi.COMPRESS, class_1802.field_8397, class_1802.field_8695, 0));
        this.qbp.add(new qbf(qbi.COMPRESS, class_1802.field_8695, class_1802.field_8494, 0));
        this.qbp.add(new qbf(qbi.COMPRESS, class_1802.field_8477, class_1802.field_8603, 0));
    }

    List<String> notes() {
        return this.qbq;
    }

    boolean xpFailed() {
        return this.qbv;
    }

    boolean tick(class_310 class_3102, class_746 class_7462, class_1714 class_17142) {
        if (this.qbr > 0) {
            --this.qbr;
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            qbf qbf2 = this.qbp.peek();
            if (qbf2 == null) {
                return true;
            }
            if (!class_17142.method_34255().method_7960() && qbf2.kind != qbi.CLEAR) {
                CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, -1);
                return false;
            }
            qbl qbl2 = this.qcc(class_3102, class_7462, class_17142, qbf2);
            if (qbl2 != qbl.WAIT && StorageRun.trace != null) {
                StorageRun.log("craft " + (Object)((Object)qbf2.kind) + (qbf2.item == null ? "" : " " + qbf2.item) + " " + (Object)((Object)qbl2) + " grid=" + CraftHelper.qck(class_17142) + " out=" + class_17142.method_61627().method_7677());
            }
            if (qbl2 == qbl.DONE || qbl2 == qbl.FAIL) {
                if (this.qbp.peek() == qbf2) {
                    this.qbp.poll();
                }
                if (qbl2 == qbl.FAIL) {
                    this.qbp.addFirst(new qbf(qbi.CLEAR, null, null, 0));
                }
                this.qbs = 0;
                this.qbt = -1;
                this.qbu = 0;
                continue;
            }
            if (qbl2 != qbl.WAIT) continue;
            return false;
        }
        return false;
    }

    private qbl qcc(class_310 class_3102, class_746 class_7462, class_1714 class_17142, qbf qbf2) {
        List list = class_17142.method_61628();
        return switch (qbf2.kind.ordinal()) {
            default -> throw new MatchException(null, null);
            case 6 -> this.qcj(class_3102, class_7462, class_17142, list, null);
            case 0 -> this.qcd(class_3102, class_7462, class_17142, list, qbf2);
            case 1 -> this.qce(class_3102, class_7462, class_17142, list, qbf2);
            case 2 -> this.qcf(class_3102, class_7462, class_17142, list, qbf2);
            case 3 -> this.qcg(class_3102, class_7462, class_17142, list);
            case 4 -> this.qch(class_7462, class_17142);
            case 5 -> {
                int var6_6 = CraftHelper.count((class_1703)class_17142, class_7462, qbf2.item);
                if (var6_6 >= qbf2.amount || CraftHelper.count((class_1703)class_17142, class_7462, qbf2.result) == 0) {
                    yield qbl.DONE;
                }
                this.qbp.poll();
                this.qbp.addFirst(new qbf(qbi.UNPACK, qbf2.result, qbf2.item, Math.min(CraftHelper.count((class_1703)class_17142, class_7462, qbf2.result), (qbf2.amount - var6_6 + 8) / 9)));
                yield qbl.ACT;
            }
        };
    }

    private qbl qcd(class_310 class_3102, class_746 class_7462, class_1714 class_17142, List<class_1735> list, qbf qbf2) {
        if (CraftHelper.qcl(list, qbf2.item, null)) {
            return this.qcj(class_3102, class_7462, class_17142, list, qbf2.item);
        }
        int n = CraftHelper.count((class_1703)class_17142, class_7462, qbf2.item);
        int n2 = Integer.MAX_VALUE;
        int n3 = 0;
        for (class_1735 class_17352 : list) {
            n2 = Math.min(n2, class_17352.method_7677().method_7947());
            n3 += class_17352.method_7677().method_7947();
        }
        if (n >= 9 && n2 < 64) {
            class_1735 class_17353 = CraftHelper.qcs((class_1703)class_17142, class_7462, qbf2.item);
            if (class_17353.method_7677().method_7947() < 9) {
                class_1735 class_17352;
                class_17352 = CraftHelper.qct((class_1703)class_17142, class_7462, qbf2.item, class_17353);
                CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7790);
                CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17353.field_7874, 0, class_1713.field_7790);
                CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874);
                return qbl.ACT;
            }
            int n4 = class_17353.field_7874;
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, n4, 0, class_1713.field_7790);
            CraftHelper.qcr(class_3102, class_7462, (class_1703)class_17142, list);
            CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, n4);
            return qbl.ACT;
        }
        if (n2 >= 1) {
            return this.qci(class_3102, class_7462, class_17142, qbf2.result);
        }
        if (n3 > 0) {
            return this.qcj(class_3102, class_7462, class_17142, list, null);
        }
        return qbl.DONE;
    }

    private qbl qce(class_310 class_3102, class_746 class_7462, class_1714 class_17142, List<class_1735> list, qbf qbf2) {
        class_1735 class_17352 = list.get(4);
        if (CraftHelper.qcl(list, qbf2.item, class_17352)) {
            return this.qcj(class_3102, class_7462, class_17142, list, null);
        }
        if (!qbf2.started) {
            qbf2.started = true;
            int n = class_17352.method_7677().method_7947();
            if (n < qbf2.amount && CraftHelper.count((class_1703)class_17142, class_7462, qbf2.item) > 0) {
                class_1735 class_17353 = CraftHelper.qcs((class_1703)class_17142, class_7462, qbf2.item);
                int n2 = qbf2.amount - n;
                CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17353.field_7874, 0, class_1713.field_7790);
                if (class_17142.method_34255().method_7947() <= n2) {
                    CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7790);
                } else {
                    for (int i = 0; i < n2; ++i) {
                        CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 1, class_1713.field_7790);
                    }
                }
                CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, class_17353.field_7874);
                return qbl.ACT;
            }
        }
        if (class_17352.method_7681()) {
            return this.qci(class_3102, class_7462, class_17142, qbf2.result);
        }
        return qbl.DONE;
    }

    private qbl qcf(class_310 class_3102, class_746 class_7462, class_1714 class_17142, List<class_1735> list, qbf qbf2) {
        class_1735 class_17352 = list.get(4);
        if (CraftHelper.qcl(list, qbf2.item, class_17352)) {
            return this.qcj(class_3102, class_7462, class_17142, list, null);
        }
        if (!class_17352.method_7681()) {
            int n = CraftHelper.count((class_1703)class_17142, class_7462, qbf2.result);
            if (CraftHelper.count((class_1703)class_17142, class_7462, qbf2.item) == 0 || qbf2.amount > 0 && n >= qbf2.amount) {
                return qbl.DONE;
            }
            int n2 = qbf2.amount > 0 ? (qbf2.amount - n + 8) / 9 : 64;
            class_1735 class_17353 = CraftHelper.qcs((class_1703)class_17142, class_7462, qbf2.item);
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17353.field_7874, 0, class_1713.field_7790);
            if (class_17142.method_34255().method_7947() <= n2 || n2 > 12) {
                CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7790);
            } else {
                for (int i = 0; i < n2; ++i) {
                    CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 1, class_1713.field_7790);
                }
            }
            CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, class_17353.field_7874);
            return qbl.ACT;
        }
        return this.qci(class_3102, class_7462, class_17142, qbf2.result);
    }

    private qbl qcg(class_310 class_3102, class_746 class_7462, class_1714 class_17142, List<class_1735> list) {
        Object object3;
        if (this.qbv) {
            return this.qcj(class_3102, class_7462, class_17142, list, null);
        }
        class_1735 class_17352 = list.get(4);
        List<class_1735> list2 = List.of(list.get(1), list.get(3), list.get(5), list.get(7));
        for (int n : new int[]{0, 2, 6, 8}) {
            if (!list.get(n).method_7681()) continue;
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, list.get((int)n).field_7874, 0, class_1713.field_7794);
            return qbl.ACT;
        }
        if (class_17352.method_7681() && !class_17352.method_7677().method_31574(class_1802.field_8477)) {
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7794);
            return qbl.ACT;
        }
        Object object2 = list2.iterator();
        while (object2.hasNext()) {
            class_1735 class_17353 = (class_1735)object2.next();
            if (!class_17353.method_7681() || class_17353.method_7677().method_31574(class_1802.field_8397)) continue;
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17353.field_7874, 0, class_1713.field_7794);
            return qbl.ACT;
        }
        int n = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8477);
        int n2 = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8397);
        int n3 = 0;
        for (Object object3 : list2) {
            if (object3.method_7681()) continue;
            ++n3;
        }
        if (!class_17352.method_7681() && n == 0 || n3 > 0 && n2 < Math.max(4, n3)) {
            return this.qcj(class_3102, class_7462, class_17142, list, null);
        }
        if (class_17352.method_7677().method_7947() < 64 && n > 0) {
            class_1735 class_17354 = CraftHelper.qcs((class_1703)class_17142, class_7462, class_1802.field_8477);
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17354.field_7874, 0, class_1713.field_7790);
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7790);
            CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, class_17354.field_7874);
            return qbl.ACT;
        }
        int n4 = Integer.MAX_VALUE;
        for (class_1735 class_17355 : list2) {
            n4 = Math.min(n4, class_17355.method_7677().method_7947());
        }
        if (n4 < 64 && n2 >= 4) {
            object3 = CraftHelper.qcs((class_1703)class_17142, class_7462, class_1802.field_8397);
            if (object3.method_7677().method_7947() < 4) {
                class_1735 class_17355;
                class_17355 = CraftHelper.qct((class_1703)class_17142, class_7462, class_1802.field_8397, object3);
                CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17355.field_7874, 0, class_1713.field_7790);
                CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, object3.field_7874, 0, class_1713.field_7790);
                CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, class_17355.field_7874);
                return qbl.ACT;
            }
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, object3.field_7874, 0, class_1713.field_7790);
            CraftHelper.qcr(class_3102, class_7462, (class_1703)class_17142, list2);
            CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, object3.field_7874);
            return qbl.ACT;
        }
        if (class_17352.method_7681() && n4 >= 1) {
            object3 = this.qci(class_3102, class_7462, class_17142, null);
            if (object3 == qbl.FAIL && this.qbs < 0) {
                this.qbv = true;
                this.qbq.add("сервер не дал крафт опыта (алмаз + 4 самородка)");
            }
            return object3;
        }
        return this.qcj(class_3102, class_7462, class_17142, list, null);
    }

    private qbl qch(class_746 class_7462, class_1714 class_17142) {
        int n = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8603);
        int n2 = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8477);
        int n3 = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8494);
        int n4 = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8695);
        int n5 = CraftHelper.count((class_1703)class_17142, class_7462, class_1802.field_8397);
        int n6 = Math.min(15, n - 2);
        if (n6 <= 0) {
            this.qbq.add("мало алмазов на опыт");
            return qbl.DONE;
        }
        int n7 = n4 * 9 + n5;
        int n8 = 4 * (n6 * 9 + n2);
        int n9 = Math.max(0, Math.min(n3 - 2, (n8 - n7 + 80) / 81));
        if (n7 + n9 * 81 < 4) {
            this.qbq.add("мало золота на опыт");
            return qbl.DONE;
        }
        ArrayList<qbf> arrayList = new ArrayList<qbf>();
        arrayList.add(new qbf(qbi.UNPACK, class_1802.field_8603, class_1802.field_8477, n6));
        if (n9 > 0) {
            arrayList.add(new qbf(qbi.UNPACK, class_1802.field_8494, class_1802.field_8695, n9));
        }
        arrayList.add(new qbf(qbi.SPLIT, class_1802.field_8695, class_1802.field_8397, n8));
        arrayList.add(new qbf(qbi.XP, null, null, 0));
        arrayList.add(new qbf(qbi.CLEAR, null, null, 0));
        arrayList.add(new qbf(qbi.COMPRESS, class_1802.field_8397, class_1802.field_8695, 0));
        arrayList.add(new qbf(qbi.COMPRESS, class_1802.field_8695, class_1802.field_8494, 0));
        arrayList.add(new qbf(qbi.COMPRESS, class_1802.field_8477, class_1802.field_8603, 0));
        this.qbp.poll();
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            this.qbp.addFirst((qbf)arrayList.get(i));
        }
        return qbl.DONE;
    }

    private qbl qci(class_310 class_3102, class_746 class_7462, class_1714 class_17142, class_1792 class_17922) {
        boolean bl;
        class_1735 class_17352 = class_17142.method_61627();
        class_1799 class_17992 = class_17352.method_7677();
        boolean bl2 = class_17922 != null ? !class_17992.method_31574(class_17922) : (bl = class_17992.method_31574(class_1802.field_8397) || class_17992.method_31574(class_1802.field_8695) || class_17992.method_31574(class_1802.field_8494) || class_17992.method_31574(class_1802.field_8477) || class_17992.method_31574(class_1802.field_8603));
        if (!class_17352.method_7681() || bl) {
            if (++this.qbs > CraftHelper.qcp(class_3102, class_7462)) {
                this.qbs = -1;
                if (class_17922 != null) {
                    this.qbq.add("верстак не дал " + class_17922.method_63680().getString());
                }
                return qbl.FAIL;
            }
            return qbl.WAIT;
        }
        this.qbs = 0;
        int n = CraftHelper.qcm(class_17142.method_61628());
        if (n == this.qbt) {
            if (++this.qbu >= 3) {
                this.qbq.add("нет места в инвентаре для крафта");
                return qbl.FAIL;
            }
        } else {
            this.qbu = 0;
        }
        this.qbt = n;
        CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7794);
        this.qbr = CraftHelper.qco(class_3102, class_7462);
        return qbl.ACT;
    }

    private qbl qcj(class_310 class_3102, class_746 class_7462, class_1714 class_17142, List<class_1735> list, class_1792 class_17922) {
        if (!class_17142.method_34255().method_7960()) {
            CraftHelper.putBack(class_3102, class_7462, (class_1703)class_17142, -1);
            return qbl.ACT;
        }
        for (class_1735 class_17352 : list) {
            if (!class_17352.method_7681() || class_17922 != null && class_17352.method_7677().method_31574(class_17922)) continue;
            int n = class_17352.method_7677().method_7947();
            if (class_17352.field_7874 == this.qbw && n == this.qbx) {
                if (++this.qby > 4) {
                    this.qbq.add("нет места в инвентаре, часть осталась в верстаке");
                    return qbl.DONE;
                }
            } else {
                this.qby = 0;
            }
            this.qbw = class_17352.field_7874;
            this.qbx = n;
            CraftHelper.qcq(class_3102, class_7462, (class_1703)class_17142, class_17352.field_7874, 0, class_1713.field_7794);
            return qbl.ACT;
        }
        return qbl.DONE;
    }

    private static String qck(class_1714 class_17142) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (class_1735 class_17352 : class_17142.method_61628()) {
            stringBuilder.append(class_17352.method_7677().method_7947()).append(' ');
        }
        return stringBuilder.append(']').toString();
    }

    private static boolean qcl(List<class_1735> list, class_1792 class_17922, class_1735 class_17352) {
        for (class_1735 class_17353 : list) {
            if (!class_17353.method_7681() || class_17353.method_7677().method_31574(class_17922) && (class_17352 == null || class_17353 == class_17352)) continue;
            return true;
        }
        return false;
    }

    private static int qcm(List<class_1735> list) {
        int n = 17;
        for (class_1735 class_17352 : list) {
            n = n * 31 + class_17352.method_7677().method_7947();
        }
        return n;
    }

    private static int qcn(class_310 class_3102, class_746 class_7462) {
        if (class_3102.method_1562() == null) {
            return 100;
        }
        class_640 class_6402 = class_3102.method_1562().method_2871(class_7462.method_5667());
        return class_6402 == null ? 100 : Math.max(0, class_6402.method_2959());
    }

    private static int qco(class_310 class_3102, class_746 class_7462) {
        return Math.min(14, 3 + CraftHelper.qcn(class_3102, class_7462) / 50);
    }

    private static int qcp(class_310 class_3102, class_746 class_7462) {
        return Math.min(100, 30 + CraftHelper.qcn(class_3102, class_7462) / 20);
    }

    private static void qcq(class_310 class_3102, class_746 class_7462, class_1703 class_17032, int n, int n2, class_1713 class_17132) {
        class_3102.field_1761.method_2906(class_17032.field_7763, n, n2, class_17132, (class_1657)class_7462);
    }

    private static void qcr(class_310 class_3102, class_746 class_7462, class_1703 class_17032, List<class_1735> list) {
        CraftHelper.qcq(class_3102, class_7462, class_17032, -999, class_1703.method_7591((int)0, (int)0), class_1713.field_7789);
        for (class_1735 class_17352 : list) {
            CraftHelper.qcq(class_3102, class_7462, class_17032, class_17352.field_7874, class_1703.method_7591((int)1, (int)0), class_1713.field_7789);
        }
        CraftHelper.qcq(class_3102, class_7462, class_17032, -999, class_1703.method_7591((int)2, (int)0), class_1713.field_7789);
    }

    static void putBack(class_310 class_3102, class_746 class_7462, class_1703 class_17032, int n) {
        for (int i = 0; i < 4 && !class_17032.method_34255().method_7960(); ++i) {
            class_1735 class_17352;
            Iterator iterator;
            class_1799 class_17992 = class_17032.method_34255();
            int n2 = -1;
            if (n >= 0 && n < class_17032.field_7761.size() && ((iterator = ((class_1735)class_17032.field_7761.get(n)).method_7677()).method_7960() || class_1799.method_31577((class_1799)iterator, (class_1799)class_17992) && iterator.method_7947() < iterator.method_7914())) {
                n2 = n;
            }
            if (n2 < 0) {
                iterator = class_17032.field_7761.iterator();
                while (iterator.hasNext()) {
                    class_17352 = (class_1735)iterator.next();
                    if (class_17352.field_7871 != class_7462.method_31548() || !class_17352.method_7681() || !class_1799.method_31577((class_1799)class_17352.method_7677(), (class_1799)class_17992) || class_17352.method_7677().method_7947() >= class_17352.method_7677().method_7914()) continue;
                    n2 = class_17352.field_7874;
                    break;
                }
            }
            if (n2 < 0) {
                iterator = class_17032.field_7761.iterator();
                while (iterator.hasNext()) {
                    class_17352 = (class_1735)iterator.next();
                    if (class_17352.field_7871 != class_7462.method_31548() || class_17352.method_7681() || class_17352.method_34266() >= 36) continue;
                    n2 = class_17352.field_7874;
                    break;
                }
            }
            CraftHelper.qcq(class_3102, class_7462, class_17032, n2 < 0 ? -999 : n2, 0, class_1713.field_7790);
            n = -1;
        }
    }

    static int count(class_1703 class_17032, class_746 class_7462, class_1792 class_17922) {
        int n = 0;
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (class_17352.field_7871 != class_7462.method_31548() || !class_17352.method_7677().method_31574(class_17922)) continue;
            n += class_17352.method_7677().method_7947();
        }
        return n;
    }

    private static class_1735 qcs(class_1703 class_17032, class_746 class_7462, class_1792 class_17922) {
        class_1735 class_17352 = null;
        for (class_1735 class_17353 : class_17032.field_7761) {
            if (class_17353.field_7871 != class_7462.method_31548() || !class_17353.method_7677().method_31574(class_17922) || class_17352 != null && class_17353.method_7677().method_7947() <= class_17352.method_7677().method_7947()) continue;
            class_17352 = class_17353;
        }
        return class_17352;
    }

    private static class_1735 qct(class_1703 class_17032, class_746 class_7462, class_1792 class_17922, class_1735 class_17352) {
        class_1735 class_17353 = null;
        for (class_1735 class_17354 : class_17032.field_7761) {
            if (class_17354 == class_17352 || class_17354.field_7871 != class_7462.method_31548() || !class_17354.method_7677().method_31574(class_17922) || class_17353 != null && class_17354.method_7677().method_7947() >= class_17353.method_7677().method_7947()) continue;
            class_17353 = class_17354;
        }
        return class_17353;
    }

    private static /* synthetic */ int brf(int n, int n2) {
        return n - n2 | 0xCC2A05B8;
    }
}

