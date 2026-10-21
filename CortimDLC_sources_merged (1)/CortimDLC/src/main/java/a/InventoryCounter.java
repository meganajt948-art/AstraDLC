/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2480
 *  net.minecraft.class_3489
 *  net.minecraft.class_746
 *  net.minecraft.class_9334
 */
package a;

import a.MineTools;
import a.qpq;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2480;
import net.minecraft.class_3489;
import net.minecraft.class_746;
import net.minecraft.class_9334;

public final class InventoryCounter {
    public static final int SLOTS = 36;
    public static final int OFFHAND = 40;
    public static final int OUTSIDE = -999;
    public static final int DEBRIS_SLOT = 32;
    public static final int KEEP_DIAMONDS = 16;
    public static final int KEEP_GOLD = 14;
    public static final class_1792[] MARKERS;
    private static final class_1792[] qpx;
    private static final int[] qpy;
    private static /* synthetic */ String qpz;
    private static /* synthetic */ int qqa;

    private InventoryCounter() {
    }

    public static int count(class_1661 class_16612, class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (!class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    public static int countAll(class_1657 class_16572, class_1792 class_17922) {
        class_1799 class_17992 = class_16572.method_6079();
        return InventoryCounter.count(class_16572.method_31548(), class_17922) + (class_17992.method_31574(class_17922) ? class_17992.method_7947() : 0);
    }

    public static int food(class_1657 class_16572) {
        return InventoryCounter.countAll(class_16572, class_1802.field_8071);
    }

    public static int find(class_1661 class_16612, class_1792 class_17922) {
        int n = -1;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (!class_17992.method_31574(class_17922) || n >= 0 && class_17992.method_7947() <= class_16612.method_5438(n).method_7947()) continue;
            n = i;
        }
        return n;
    }

    public static int emptySlot(class_1661 class_16612) {
        for (int i = 35; i >= 0; --i) {
            if (!class_16612.method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    public static int durability(class_1799 class_17992) {
        return class_17992.method_7960() || !class_17992.method_7963() ? -1 : class_17992.method_7936() - class_17992.method_7919();
    }

    public static int pickaxe(class_1661 class_16612) {
        if (class_16612.method_5438(0).method_31573(class_3489.field_42614)) {
            return 0;
        }
        int n = MineTools.bestPickaxe(class_16612);
        if (n >= 0) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_31573(class_3489.field_42614)) continue;
            return i;
        }
        return -1;
    }

    public static int pickaxeDurability(class_746 class_7462) {
        class_1799 class_17992 = class_7462.method_6047();
        if (class_17992.method_31573(class_3489.field_42614) && class_17992.method_7963()) {
            return InventoryCounter.durability(class_17992);
        }
        int n = InventoryCounter.pickaxe(class_7462.method_31548());
        if (n >= 0) {
            return InventoryCounter.durability(class_7462.method_31548().method_5438(n));
        }
        class_1799 class_17993 = class_7462.method_6079();
        return class_17993.method_31573(class_3489.field_42614) ? InventoryCounter.durability(class_17993) : -1;
    }

    public static boolean isFood(class_1799 class_17992) {
        if (class_17992.method_7960() || class_17992.method_58694(class_9334.field_50075) == null) {
            return false;
        }
        return !class_17992.method_31574(class_1802.field_8511) && !class_17992.method_31574(class_1802.field_8680) && !class_17992.method_31574(class_1802.field_8635) && !class_17992.method_31574(class_1802.field_8323) && !class_17992.method_31574(class_1802.field_8233) && !class_17992.method_31574(class_1802.field_8766) && !class_17992.method_31574(class_1802.field_8367);
    }

    public static boolean isLayoutItem(class_1792 class_17922) {
        if (class_17922 == class_1802.field_8477 || class_17922 == class_1802.field_8695 || class_17922 == class_1802.field_22019) {
            return true;
        }
        for (class_1792 class_17923 : MARKERS) {
            if (class_17923 != class_17922) continue;
            return true;
        }
        return false;
    }

    public static boolean isMarker(class_1792 class_17922) {
        for (class_1792 class_17923 : MARKERS) {
            if (class_17923 != class_17922) continue;
            return true;
        }
        return false;
    }

    public static boolean keeps(class_1799 class_17992) {
        class_1747 class_17472;
        if (class_17992.method_7960()) {
            return false;
        }
        if (class_17992.method_31573(class_3489.field_42614) || class_17992.method_7963() || InventoryCounter.isFood(class_17992) || class_17992.method_31574(class_1802.field_8367)) {
            return true;
        }
        if (class_17992.method_31574(class_1802.field_8288) || class_17992.method_31574(class_1802.field_8287) || class_17992.method_31574(class_1802.field_22020) || class_17992.method_31574(class_1802.field_22021) || class_17992.method_31574(class_1802.field_8603) || class_17992.method_31574(class_1802.field_8494) || class_17992.method_31574(class_1802.field_8634) || class_17992.method_31574(class_1802.field_8833) || class_17992.method_31574(class_1802.field_8687) || class_17992.method_31574(class_1802.field_8733) || class_17992.method_31574(class_1802.field_22018)) {
            return true;
        }
        class_1792 class_17922 = class_17992.method_7909();
        return class_17922 instanceof class_1747 && (class_17472 = (class_1747)class_17922).method_7711() instanceof class_2480;
    }

    public static boolean throwable(class_1799 class_17992) {
        return !class_17992.method_7960() && !InventoryCounter.keeps(class_17992) && !InventoryCounter.isLayoutItem(class_17992.method_7909());
    }

    public static boolean ready(class_1661 class_16612) {
        int n = 14 + (InventoryCounter.count(class_16612, class_1802.field_22019) == 0 ? 1 : 0);
        return InventoryCounter.count(class_16612, class_1802.field_8477) >= 16 && InventoryCounter.count(class_16612, class_1802.field_8695) >= n;
    }

    public static int keepGold(class_1661 class_16612) {
        return 14 + (InventoryCounter.count(class_16612, class_1802.field_22019) == 0 ? 1 : 0);
    }

    public static class_1792[] targets(class_1661 class_16612, class_1799 class_17992) {
        int n;
        int n2;
        class_1792[] class_1792Array = (class_1792[])qpx.clone();
        if (InventoryCounter.count(class_16612, class_1802.field_22019) == 0) {
            class_1792Array[32] = class_1802.field_8695;
        }
        for (n2 = 0; n2 < MARKERS.length; ++n2) {
            if (InventoryCounter.count(class_16612, MARKERS[n2]) != 0) continue;
            class_1792Array[9 + n2] = null;
        }
        n2 = InventoryCounter.pickaxe(class_16612);
        boolean bl = class_17992.method_7960() || class_17992.method_31574(class_1802.field_8071);
        int n3 = 0;
        for (n = 0; n < 36; ++n) {
            class_1799 class_17993 = class_16612.method_5438(n);
            if (class_17993.method_7960() || n == n2 || InventoryCounter.isLayoutItem(class_17993.method_7909()) || !InventoryCounter.keeps(class_17993)) continue;
            if (bl && class_17993.method_31574(class_1802.field_8071)) {
                bl = false;
                continue;
            }
            ++n3;
        }
        for (n = 1; n < 36; ++n) {
            if (class_1792Array[n] != null) continue;
            --n3;
        }
        for (n = qpy.length - 1; n >= 0 && n3 > 0; --n) {
            if (class_1792Array[qpy[n]] == null) continue;
            class_1792Array[InventoryCounter.qpy[n]] = null;
            --n3;
        }
        return class_1792Array;
    }

    public static int misplaced(class_1661 class_16612, class_1792[] class_1792Array) {
        int n = 0;
        for (int i = 1; i < 36; ++i) {
            if (class_1792Array[i] == null || class_16612.method_5438(i).method_31574(class_1792Array[i])) continue;
            ++n;
        }
        return n;
    }

    public static qpq next(class_1661 class_16612, class_1799 class_17992, class_1799 class_17993, class_1792[] class_1792Array, boolean[] blArray) {
        return InventoryCounter.next(class_16612, class_17992, class_17993, class_1792Array, blArray, false);
    }

    public static qpq next(class_1661 class_16612, class_1799 class_17992, class_1799 class_17993, class_1792[] class_1792Array, boolean[] blArray, boolean bl) {
        int n;
        if (!class_17992.method_7960()) {
            if (class_17992.method_31574(class_1802.field_8071) && (class_17993.method_7960() || class_1799.method_31577((class_1799)class_17993, (class_1799)class_17992) && class_17993.method_7947() < class_17993.method_7914())) {
                return new qpq(40, 0, class_1713.field_7790);
            }
            return InventoryCounter.qqb(class_16612, class_17992, class_1792Array, blArray, bl);
        }
        int n2 = InventoryCounter.pickaxe(class_16612);
        if (n2 > 0 && !class_16612.method_5438(0).method_31573(class_3489.field_42614)) {
            return new qpq(n2, 0, class_1713.field_7791);
        }
        for (int n3 : qpy) {
            class_1799 class_17994;
            class_1792 class_17922 = class_1792Array[n3];
            if (class_17922 == null || blArray[n3] || (class_17994 = class_16612.method_5438(n3)).method_31574(class_17922)) continue;
            if (!class_17994.method_7960()) {
                return new qpq(n3, 0, class_1713.field_7790);
            }
            int n4 = InventoryCounter.qqc(class_16612, class_1792Array, class_17922);
            if (n4 < 0) {
                blArray[n3] = true;
                continue;
            }
            return new qpq(n4, 0, class_1713.field_7790);
        }
        if (!class_17993.method_31574(class_1802.field_8071) && class_17993.method_7960() && (n = InventoryCounter.find(class_16612, class_1802.field_8071)) >= 0) {
            return new qpq(n, 40, class_1713.field_7791);
        }
        return null;
    }

    private static qpq qqb(class_1661 class_16612, class_1799 class_17992, class_1792[] class_1792Array, boolean[] blArray, boolean bl) {
        int n;
        class_1792 class_17922 = class_17992.method_7909();
        int[] nArray = qpy;
        int n2 = nArray.length;
        for (n = 0; n < n2; ++n) {
            int n3 = nArray[n];
            if (class_1792Array[n3] != class_17922 || blArray[n3] || !class_16612.method_5438(n3).method_7960()) continue;
            return new qpq(n3, class_17992.method_7947() > 1 ? 1 : 0, class_1713.field_7790);
        }
        int n4 = -1;
        for (n2 = 0; n2 < 36; ++n2) {
            class_1799 class_17993 = class_16612.method_5438(n2);
            if (class_17993.method_7960() || !class_1799.method_31577((class_1799)class_17993, (class_1799)class_17992) || class_17993.method_7947() >= class_17993.method_7914() || n4 >= 0 && (class_1792Array[n2] != class_17922 || class_1792Array[n4] == class_17922)) continue;
            n4 = n2;
        }
        if (n4 >= 0) {
            return new qpq(n4, 0, class_1713.field_7790);
        }
        for (n2 = 35; n2 >= 1; --n2) {
            if (class_1792Array[n2] != null || !class_16612.method_5438(n2).method_7960()) continue;
            return new qpq(n2, 0, class_1713.field_7790);
        }
        if (!(bl || InventoryCounter.keeps(class_17992) || InventoryCounter.isLayoutItem(class_17922))) {
            return new qpq(-999, 0, class_1713.field_7790);
        }
        for (n2 = qpy.length - 1; n2 >= 0; --n2) {
            n = qpy[n2];
            if (!class_16612.method_5438(n).method_7960()) continue;
            blArray[n] = true;
            return new qpq(n, 0, class_1713.field_7790);
        }
        return bl ? null : new qpq(-999, 0, class_1713.field_7790);
    }

    private static int qqc(class_1661 class_16612, class_1792[] class_1792Array, class_1792 class_17922) {
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < 36; ++i) {
            int n3;
            boolean bl;
            class_1799 class_17992 = class_16612.method_5438(i);
            if (!class_17992.method_31574(class_17922)) continue;
            boolean bl2 = bl = class_1792Array[i] == class_17922;
            if (bl && class_17992.method_7947() < 2 || (n3 = (bl ? 0 : 1000) + class_17992.method_7947()) <= n2) continue;
            n2 = n3;
            n = i;
        }
        return n;
    }

    static {
        int n;
        MARKERS = new class_1792[]{class_1802.field_8725, class_1802.field_8759, class_1802.field_8620, class_1802.field_8713};
        qpx = new class_1792[36];
        for (n = 1; n <= 8; ++n) {
            InventoryCounter.qpx[n] = class_1802.field_8477;
        }
        for (n = 0; n < MARKERS.length; ++n) {
            InventoryCounter.qpx[9 + n] = MARKERS[n];
        }
        for (n = 13; n <= 26; ++n) {
            InventoryCounter.qpx[n] = class_1802.field_8695;
        }
        for (n = 27; n <= 35; ++n) {
            InventoryCounter.qpx[n] = class_1802.field_8477;
        }
        InventoryCounter.qpx[32] = class_1802.field_22019;
        int[] nArray = new int[35];
        int n2 = 0;
        int n3 = 9;
        while (n3 <= 12) {
            nArray[n2++] = n3++;
        }
        nArray[n2++] = 32;
        n3 = 13;
        while (n3 <= 26) {
            nArray[n2++] = n3++;
        }
        for (n3 = 27; n3 <= 35; ++n3) {
            if (n3 == 32) continue;
            nArray[n2++] = n3;
        }
        n3 = 1;
        while (n3 <= 8) {
            nArray[n2++] = n3++;
        }
        qpy = nArray;
    }

    private static /* synthetic */ int bub(int n, int n2) {
        return (n ^ n2) + 1868812387;
    }

    private static /* synthetic */ int buc(int n, int n2) {
        return InventoryCounter.bub(n, n2) * n2;
    }

    private static /* synthetic */ int bud(int n, int n2) {
        return n - n2 | 0xE8385A1A;
    }
}

