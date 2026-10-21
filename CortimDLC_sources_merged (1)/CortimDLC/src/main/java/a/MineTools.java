/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1723
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1893
 *  net.minecraft.class_2246
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3489
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package a;

import a.qoc;
import a.qpq;
import a.InventoryCounter;
import a.StorageRun;
import a.IdleTracker;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1723;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1893;
import net.minecraft.class_2246;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3489;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public final class MineTools {
    private static final int qog = 420;
    private final IdleTracker qoh = new IdleTracker();
    private final Random qoi = new Random();
    private final ArrayDeque<int[]> qoj = new ArrayDeque();
    private final IntArrayList qok = new IntArrayList();
    private qoc qol = qoc.NONE;
    private int qom;
    private int qon;
    private boolean qoo;
    private int qop;
    private int qoq;
    private int qor;
    private class_1792[] qos;
    private boolean[] qot;
    private int qou;
    private boolean qov;
    private boolean qow;
    private int qox = -1;
    private int qoy = -1;
    private int qoz = -1;
    private int qpa = -1;
    private class_1792 qpb;
    public boolean noThrow;
    private static /* synthetic */ String qpc;
    private static /* synthetic */ int qpd;

    public boolean busy() {
        return this.qol != qoc.NONE;
    }

    public qoc job() {
        return this.qol;
    }

    public int thrown() {
        return this.qop;
    }

    public boolean laidOut() {
        return this.qow;
    }

    public static int bestPickaxe(class_1661 class_16612) {
        class_2680 class_26802 = class_2246.field_10340.method_9564();
        int n = -1;
        double d = 0.0;
        for (int i = 0; i < 36; ++i) {
            String string;
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || !class_17992.method_31573(class_3489.field_42614) || class_17992.method_7963() && class_17992.method_7936() - class_17992.method_7919() <= 5) continue;
            double d2 = class_17992.method_7924(class_26802);
            int n2 = MineTools.qpo(class_17992);
            if (n2 > 0) {
                d2 += (double)(n2 * n2 + 1);
            }
            if ((string = MineTools.qpp(class_17992)).contains("бульдоз")) {
                d2 += 1000.0;
            }
            if (string.contains("магнит")) {
                d2 += 500.0;
            }
            if (i == class_16612.method_67532()) {
                d2 += 0.5;
            } else if (i < 9) {
                d2 += 0.25;
            }
            if (!(d2 > d)) continue;
            d = d2;
            n = i;
        }
        return n;
    }

    public static boolean holdsPickaxe(class_746 class_7462) {
        return class_7462.method_6047().method_31573(class_3489.field_42614);
    }

    public static boolean hasJunk(class_1661 class_16612, Set<String> set) {
        for (int i = 0; i < 36; ++i) {
            if (!MineTools.qpe(class_16612.method_5438(i), set)) continue;
            return true;
        }
        return false;
    }

    public static int empty(class_1661 class_16612) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_7960()) continue;
            ++n;
        }
        return n;
    }

    public static boolean isJunkStack(class_1799 class_17992, Set<String> set) {
        return MineTools.qpe(class_17992, set);
    }

    private static boolean qpe(class_1799 class_17992, Set<String> set) {
        return !class_17992.method_7960() && set.contains(class_7923.field_41178.method_10221((Object)class_17992.method_7909()).toString());
    }

    public boolean equip(class_310 class_3102, class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        int n = MineTools.bestPickaxe(class_16612);
        if (n < 0) {
            return false;
        }
        if (n < 9) {
            if (class_16612.method_67532() != n) {
                class_16612.method_61496(n);
            }
            return true;
        }
        if (this.qol == qoc.NONE) {
            this.qol = qoc.EQUIP;
            this.qom = 0;
        }
        return true;
    }

    public void dropJunk(int n) {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.JUNK);
            this.qoq = n;
            this.qon = 1;
        }
    }

    public void swaps(int ... nArray) {
        if (this.qol != qoc.NONE || nArray.length < 2) {
            return;
        }
        this.qoj.clear();
        int n = 0;
        while (n + 1 < nArray.length) {
            this.qoj.add(new int[]{nArray[n], nArray[n + 1]});
            n += 2;
        }
        this.qpf(qoc.SWAPS);
    }

    public void throwOne(int n) {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.THROW);
            this.qor = n;
        }
    }

    public void layout() {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.LAYOUT);
            this.qos = null;
            this.qov = false;
            this.qow = false;
        }
    }

    public void compact() {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.COMPACT);
        }
    }

    public void freeHand() {
        if (this.qol == qoc.NONE) {
            this.qpf(qoc.HAND);
            this.qox = -1;
        }
    }

    public void unstow(class_746 class_7462) {
        if (this.qpa < 0 || this.qol != qoc.NONE) {
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        int n = this.qoz;
        int n2 = this.qpa;
        this.qpa = -1;
        if (class_16612.method_5438(n).method_7960() && class_16612.method_5438(n2).method_31574(this.qpb)) {
            this.swaps(n2, n);
        }
    }

    private void qpf(qoc qoc2) {
        this.qol = qoc2;
        this.qom = 0;
        this.qon = 0;
        this.qoo = false;
        this.qou = 0;
    }

    public void startTick(class_310 class_3102) {
        if (this.qol != qoc.NONE) {
            this.qoh.hold(class_3102);
        }
    }

    public void endTick(class_310 class_3102, class_746 class_7462, Set<String> set) {
        boolean bl;
        boolean bl2;
        if (this.qol == qoc.NONE) {
            return;
        }
        boolean bl3 = bl2 = class_7462.method_5805() && !class_7462.method_7325() && class_7462.field_7512 == class_7462.field_7498;
        if (!bl2 || this.qol != qoc.LAYOUT && this.qol != qoc.COMPACT && this.qol != qoc.HAND && !InventoryClicks.canClick(class_7462)) {
            StorageRun.log("inv " + (Object)((Object)this.qol) + " can't click: own=" + bl2 + " handler=" + class_7462.field_7512 + " cursor=" + class_7462.field_7498.method_34255() + " screen=" + class_3102.field_1755);
            this.qpn(class_3102);
            return;
        }
        boolean bl4 = bl = IdleTracker.serverIdle(class_7462) && IdleTracker.still(class_7462) && !class_7462.method_6115() && (class_3102.field_1761 == null || !class_3102.field_1761.method_2923());
        if (!bl) {
            if (++this.qom > 24) {
                this.qpn(class_3102);
            }
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        switch (this.qol.ordinal()) {
            case 1: {
                int n = MineTools.bestPickaxe(class_16612);
                if (n >= 9) {
                    InventoryClicks.swap(class_3102, n, class_16612.method_67532());
                }
                this.qpn(class_3102);
                break;
            }
            case 3: {
                int[] nArray = this.qoj.poll();
                if (nArray == null) {
                    this.qpm(class_3102);
                    return;
                }
                InventoryClicks.click(class_3102, nArray[0], nArray[1]);
                this.qoo = true;
                if (!this.qoj.isEmpty()) break;
                this.qpm(class_3102);
                break;
            }
            case 4: {
                if (!this.noThrow && !class_16612.method_5438(this.qor).method_7960()) {
                    class_3102.field_1761.method_2906(class_7462.field_7498.field_7763, InventoryClicks.slotId(this.qor), 0, class_1713.field_7795, (class_1657)class_7462);
                    this.qoo = true;
                    ++this.qop;
                }
                this.qpm(class_3102);
                break;
            }
            case 5: {
                this.qpl(class_3102, class_7462, class_16612, set);
                break;
            }
            case 6: {
                this.qpk(class_3102, class_7462, class_16612);
                break;
            }
            case 2: {
                this.qpg(class_3102, class_7462, class_16612, set);
                break;
            }
            case 7: {
                this.qph(class_3102, class_7462, class_16612, set);
                break;
            }
            default: {
                this.qpn(class_3102);
            }
        }
    }

    private void qpg(class_310 class_3102, class_746 class_7462, class_1661 class_16612, Set<String> set) {
        if (this.noThrow) {
            this.qpm(class_3102);
            return;
        }
        if (this.qon > 0) {
            --this.qon;
            return;
        }
        int n = class_16612.method_67532();
        for (int i = 35; i >= 0 && this.qoq > 0; --i) {
            if (i == n || !MineTools.qpe(class_16612.method_5438(i), set)) continue;
            --this.qoq;
            class_3102.field_1761.method_2906(class_7462.field_7498.field_7763, InventoryClicks.slotId(i), 1, class_1713.field_7795, (class_1657)class_7462);
            this.qoo = true;
            ++this.qop;
            this.qon = this.qoi.nextInt(5) == 0 ? 1 : 0;
            return;
        }
        this.qpm(class_3102);
    }

    private void qph(class_310 class_3102, class_746 class_7462, class_1661 class_16612, Set<String> set) {
        int n;
        int n2;
        class_1723 class_17232 = class_7462.field_7498;
        if (this.qon > 0) {
            --this.qon;
            return;
        }
        if (this.qox >= 0) {
            class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(this.qox), 0, class_1713.field_7790, (class_1657)class_7462);
            if (!class_17232.method_34255().method_7960()) {
                class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(this.qoy), 0, class_1713.field_7790, (class_1657)class_7462);
            }
            this.qox = -1;
            this.qon = 1;
            return;
        }
        if (!class_17232.method_34255().method_7960()) {
            this.qpm(class_3102);
            return;
        }
        for (n2 = 0; n2 < 9; ++n2) {
            if (!class_16612.method_5438(n2).method_7960()) continue;
            this.qpm(class_3102);
            return;
        }
        if (++this.qou > 6) {
            this.qpm(class_3102);
            return;
        }
        n2 = MineTools.qpi(class_16612);
        for (n = 9; n < 36; ++n) {
            if (!class_16612.method_5438(n).method_7960()) continue;
            this.qoz = n2;
            this.qpa = n;
            this.qpb = class_16612.method_5438(n2).method_7909();
            InventoryClicks.click(class_3102, n, n2);
            this.qoo = true;
            this.qpm(class_3102);
            return;
        }
        for (n = 35; n >= 0 && !this.noThrow; --n) {
            if (!MineTools.qpe(class_16612.method_5438(n), set)) continue;
            class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(n), 1, class_1713.field_7795, (class_1657)class_7462);
            this.qoo = true;
            ++this.qop;
            this.qon = 1;
            return;
        }
        int[] nArray = MineTools.qpj(class_16612, n2);
        if (nArray == null) {
            this.qpm(class_3102);
            return;
        }
        this.qoy = nArray[0];
        class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(nArray[0]), 0, class_1713.field_7790, (class_1657)class_7462);
        this.qoo = true;
        this.qox = nArray[1];
        this.qon = 1;
    }

    private static int qpi(class_1661 class_16612) {
        int n = class_16612.method_67532();
        if (!class_16612.method_5438(n).method_31573(class_3489.field_42614)) {
            return n;
        }
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_31573(class_3489.field_42614) || n2 >= 0 && class_17992.method_7947() >= class_16612.method_5438(n2).method_7947()) continue;
            n2 = i;
        }
        return n2 >= 0 ? n2 : n;
    }

    private static int[] qpj(class_1661 class_16612, int n) {
        int[] nArray = null;
        int n2 = Integer.MAX_VALUE;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960() || class_17992.method_7914() <= 1 || class_17992.method_31573(class_3489.field_42614)) continue;
            for (int j = 0; j < 36; ++j) {
                int n3;
                class_1799 class_17993 = class_16612.method_5438(j);
                if (j == i || class_17993.method_7960() || class_17992.method_7947() + class_17993.method_7947() > class_17993.method_7914() || !class_1799.method_31577((class_1799)class_17992, (class_1799)class_17993) || (n3 = (i == n ? 0 : (i < 9 ? 200 : 100)) + class_17992.method_7947()) >= n2) continue;
                n2 = n3;
                nArray = new int[]{i, j};
            }
        }
        return nArray;
    }

    private void qpk(class_310 class_3102, class_746 class_7462, class_1661 class_16612) {
        int n;
        class_1723 class_17232 = class_7462.field_7498;
        int n2 = -1;
        int n3 = -1;
        if (class_17232.method_34255().method_7960() && ++this.qou < 120) {
            for (n = 0; n < 36 && n2 < 0; ++n) {
                class_1799 class_17992 = class_16612.method_5438(n);
                if (class_17992.method_7960() || class_17992.method_7947() >= class_17992.method_7914()) continue;
                for (int i = 0; i < 36; ++i) {
                    class_1799 class_17993 = class_16612.method_5438(i);
                    if (i == n || class_17993.method_7960() || class_17993.method_7947() >= class_17993.method_7914() || !class_1799.method_31577((class_1799)class_17992, (class_1799)class_17993) || n3 >= 0 && class_17993.method_7947() <= class_16612.method_5438(n3).method_7947()) continue;
                    n3 = i;
                }
                if (n3 < 0) continue;
                n2 = class_17992.method_7947() <= class_16612.method_5438(n3).method_7947() ? n : n3;
                n3 = n2 == n ? n3 : n;
            }
        }
        if (n2 < 0) {
            if (!class_17232.method_34255().method_7960()) {
                n = InventoryCounter.emptySlot(class_16612);
                class_3102.field_1761.method_2906(class_17232.field_7763, n >= 0 ? InventoryClicks.slotId(n) : -999, 0, class_1713.field_7790, (class_1657)class_7462);
            }
            this.qpm(class_3102);
            return;
        }
        class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(n2), 0, class_1713.field_7790, (class_1657)class_7462);
        class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(n3), 0, class_1713.field_7790, (class_1657)class_7462);
        if (!class_17232.method_34255().method_7960()) {
            class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(n2), 0, class_1713.field_7790, (class_1657)class_7462);
        }
        this.qoo = true;
    }

    private void qpl(class_310 class_3102, class_746 class_7462, class_1661 class_16612, Set<String> set) {
        class_1723 class_17232 = class_7462.field_7498;
        if (!this.qov) {
            this.qov = true;
            this.qok.clear();
            for (int i = 0; i < 36 && !this.noThrow; ++i) {
                class_1799 class_17992 = class_16612.method_5438(i);
                if (!InventoryCounter.throwable(class_17992) && !MineTools.qpe(class_17992, set)) continue;
                this.qok.add(i);
            }
            for (class_1792 class_17922 : this.noThrow ? new class_1792[]{} : InventoryCounter.MARKERS) {
                int n = InventoryCounter.find(class_16612, class_17922);
                for (int i = 0; i < 36; ++i) {
                    if (i == n || !class_16612.method_5438(i).method_31574(class_17922)) continue;
                    this.qok.add(i);
                }
            }
        }
        if (!this.qok.isEmpty() && class_17232.method_34255().method_7960()) {
            int n = this.qok.removeInt(this.qok.size() - 1);
            if (!class_16612.method_5438(n).method_7960()) {
                class_3102.field_1761.method_2906(class_17232.field_7763, InventoryClicks.slotId(n), 1, class_1713.field_7795, (class_1657)class_7462);
                this.qoo = true;
                ++this.qop;
            }
            return;
        }
        if (this.qos == null) {
            this.qos = InventoryCounter.targets(class_16612, class_7462.method_6079());
            this.qot = new boolean[36];
        }
        for (int i = 0; i < 2; ++i) {
            qpq qpq2 = InventoryCounter.next(class_16612, class_17232.method_34255(), class_7462.method_6079(), this.qos, this.qot, this.noThrow);
            int n = 0;
            if (qpq2 != null && this.noThrow && qpq2.slot() == -999) {
                qpq2 = null;
                n = 1;
            }
            if (qpq2 == null || ++this.qou > 420) {
                int n2;
                boolean bl = this.qow = qpq2 == null && n == 0;
                if (!(class_17232.method_34255().method_7960() || (n2 = InventoryCounter.emptySlot(class_16612)) < 0 && this.noThrow)) {
                    class_3102.field_1761.method_2906(class_17232.field_7763, n2 >= 0 ? InventoryClicks.slotId(n2) : -999, 0, class_1713.field_7790, (class_1657)class_7462);
                }
                this.qpm(class_3102);
                return;
            }
            int n3 = qpq2.slot() == -999 ? -999 : (qpq2.slot() == 40 ? 45 : InventoryClicks.slotId(qpq2.slot()));
            class_3102.field_1761.method_2906(class_17232.field_7763, n3, qpq2.button(), qpq2.type(), (class_1657)class_7462);
            this.qoo = true;
            if (qpq2.type() == class_1713.field_7790) continue;
            return;
        }
    }

    private void qpm(class_310 class_3102) {
        if (this.qoo) {
            InventoryClicks.close(class_3102);
        }
        this.qpn(class_3102);
    }

    public void cancel(class_310 class_3102) {
        if (this.qoo && class_3102.field_1724 != null) {
            InventoryClicks.close(class_3102);
        }
        this.qpn(class_3102);
    }

    private void qpn(class_310 class_3102) {
        if (this.qol != qoc.NONE) {
            StorageRun.log("inv " + (Object)((Object)this.qol) + " over, waited " + this.qom + (this.qoo ? ", clicked" : ", no click"));
        }
        this.qol = qoc.NONE;
        this.qoo = false;
        this.qom = 0;
        this.qoj.clear();
        this.qok.clear();
        if (this.qoh.isHeld()) {
            this.qoh.release(class_3102);
        }
    }

    private static int qpo(class_1799 class_17992) {
        for (Object2IntMap.Entry entry : class_17992.method_58657().method_57539()) {
            if (!((class_6880)entry.getKey()).method_40225(class_1893.field_9131)) continue;
            return entry.getIntValue();
        }
        return 0;
    }

    private static String qpp(class_1799 class_17992) {
        StringBuilder stringBuilder = new StringBuilder();
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            for (class_2561 class_25612 : class_92902.comp_2400()) {
                stringBuilder.append(class_25612.getString()).append('\n');
            }
        }
        stringBuilder.append(class_17992.method_7964().getString());
        return stringBuilder.toString().toLowerCase(Locale.ROOT);
    }

    private static /* synthetic */ int btt(int n, int n2) {
        return n * n2 + 1285789881;
    }

    private static /* synthetic */ int btu(int n, int n2) {
        return MineTools.btt(n, n2) * n2;
    }
}

