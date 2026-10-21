/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10706
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_310
 *  net.minecraft.class_5537
 *  net.minecraft.class_746
 *  net.minecraft.class_9276
 *  net.minecraft.class_9334
 *  net.minecraft.class_9837
 *  org.apache.commons.lang3.math.Fraction
 */
package a;

import a.InventoryClicks;
import java.util.function.Predicate;
import net.minecraft.class_10706;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_5537;
import net.minecraft.class_746;
import net.minecraft.class_9276;
import net.minecraft.class_9334;
import net.minecraft.class_9837;
import org.apache.commons.lang3.math.Fraction;

public final class CursorStack {
    private static final Fraction vvo = Fraction.getFraction((int)1, (int)16);
    private int vvp = -1;
    private int vvq;
    private int vvr;
    private int vvs = -1;
    private class_1799 vvt = class_1799.field_8037;
    private boolean vvu;
    private static /* synthetic */ long vvv;
    private static /* synthetic */ String vvw;

    public boolean active() {
        return this.vvu;
    }

    public boolean cursorHeld(class_746 class_7462) {
        return this.vvu && !class_7462.field_7498.method_34255().method_7960();
    }

    public static class_9276 contents(class_1799 class_17992) {
        return class_17992.method_7909() instanceof class_5537 ? (class_9276)class_17992.method_58694(class_9334.field_49650) : null;
    }

    public static int[] locate(class_1661 class_16612, Predicate<class_1799> predicate) {
        for (int i = 0; i < 36; ++i) {
            class_9276 class_92762 = CursorStack.contents(class_16612.method_5438(i));
            if (class_92762 == null) continue;
            for (int j = 0; j < class_92762.method_57426(); ++j) {
                if (!predicate.test(class_92762.method_57422(j))) continue;
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static class_1799 peek(class_1661 class_16612, Predicate<class_1799> predicate) {
        int[] nArray = CursorStack.locate(class_16612, predicate);
        return nArray == null ? class_1799.field_8037 : CursorStack.contents(class_16612.method_5438(nArray[0])).method_57422(nArray[1]);
    }

    public static int count(class_1661 class_16612, Predicate<class_1799> predicate) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_9276 class_92762 = CursorStack.contents(class_16612.method_5438(i));
            if (class_92762 == null) continue;
            for (class_1799 class_17992 : class_92762.method_57421()) {
                if (!predicate.test(class_17992)) continue;
                n += class_17992.method_7947();
            }
        }
        return n;
    }

    public boolean take(class_310 class_3102, Predicate<class_1799> predicate, int n) {
        class_746 class_7462 = class_3102.field_1724;
        class_1661 class_16612 = class_7462.method_31548();
        if (class_7462.field_7512 != class_7462.field_7498 || !class_7462.field_7498.method_34255().method_7960()) {
            return false;
        }
        int[] nArray = CursorStack.locate(class_16612, predicate);
        if (nArray == null) {
            return false;
        }
        int n2 = nArray[0];
        class_1799 class_17992 = CursorStack.contents(class_16612.method_5438(n2)).method_57422(nArray[1]);
        Fraction fraction = CursorStack.vwb(class_16612.method_5438(n2)).add(CursorStack.vwc(class_17992));
        class_1799 class_17993 = class_16612.method_5438(n);
        int n3 = -1;
        int n4 = -1;
        if (class_17993.method_7960()) {
            n3 = n;
        } else {
            n3 = CursorStack.vwe(class_16612, -1);
            if (n3 < 0 && CursorStack.vvy(class_17993) && (n4 = CursorStack.vvz(class_16612, class_17993, n, n2, fraction)) >= 0) {
                n3 = n;
            }
            for (int i = 0; i < 2 && n3 < 0; ++i) {
                for (int j = i == 0 ? 0 : 9; j < (i == 0 ? 9 : 36) && n3 < 0; ++j) {
                    class_1799 class_17994 = class_16612.method_5438(j);
                    if (j == n || j == n2 || !CursorStack.vvy(class_17994) || (n4 = CursorStack.vvz(class_16612, class_17994, j, n2, fraction)) < 0) continue;
                    n3 = j;
                }
            }
            if (n3 < 0 && CursorStack.contents(class_17993) == null) {
                n3 = n;
            }
        }
        if (n3 < 0) {
            return false;
        }
        this.vvp = n2;
        this.vvq = n3;
        this.vvr = n;
        this.vvs = n4;
        this.vvt = class_1799.field_8037;
        this.vvu = true;
        CursorStack.vwf(class_3102, n2, nArray[1]);
        CursorStack.vwg(class_3102, n2, 1);
        CursorStack.vwg(class_3102, n3, 0);
        if (n4 >= 0) {
            this.vvt = class_7462.field_7498.method_34255().method_7972();
            CursorStack.vwg(class_3102, n4, 0);
        }
        if (n3 != n && class_7462.field_7498.method_34255().method_7960()) {
            InventoryClicks.click(class_3102, n3, n);
        }
        return true;
    }

    public void giveBack(class_310 class_3102) {
        int n;
        if (!this.vvu) {
            return;
        }
        this.vvu = false;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_7462.field_7512 != class_7462.field_7498) {
            return;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (this.vvq != this.vvr && CursorStack.vvx(class_7462).method_7960()) {
            InventoryClicks.click(class_3102, this.vvq, this.vvr);
        }
        if (this.vvs >= 0 && CursorStack.vvx(class_7462).method_7960()) {
            int n2;
            class_9276 class_92762 = CursorStack.contents(class_16612.method_5438(this.vvs));
            int n3 = n2 = class_92762 == null ? -1 : CursorStack.vwa(class_92762, this.vvt);
            if (n2 >= 0) {
                CursorStack.vwf(class_3102, this.vvs, n2);
                CursorStack.vwg(class_3102, this.vvs, 1);
            }
        }
        if (!CursorStack.vvx(class_7462).method_7960() || !class_16612.method_5438(this.vvq).method_7960()) {
            CursorStack.vwg(class_3102, this.vvq, 0);
        }
        if (!CursorStack.vvx(class_7462).method_7960() && CursorStack.contents(class_16612.method_5438(this.vvp)) != null) {
            CursorStack.vwg(class_3102, this.vvp, 0);
        }
        if (!CursorStack.vvx(class_7462).method_7960() && (n = CursorStack.vwe(class_16612, -1)) >= 0) {
            CursorStack.vwg(class_3102, n, 0);
        }
        this.vvs = -1;
        this.vvt = class_1799.field_8037;
    }

    private static class_1799 vvx(class_746 class_7462) {
        return class_7462.field_7498.method_34255();
    }

    private static boolean vvy(class_1799 class_17992) {
        return class_9276.method_61667((class_1799)class_17992) && CursorStack.contents(class_17992) == null;
    }

    private static int vvz(class_1661 class_16612, class_1799 class_17992, int n, int n2, Fraction fraction) {
        Fraction fraction2 = CursorStack.vwc(class_17992);
        int n3 = -1;
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17993;
            class_9276 class_92762;
            if (i == n || (class_92762 = CursorStack.contents(class_17993 = class_16612.method_5438(i))) == null || (i == n2 ? fraction : CursorStack.vwb(class_17993)).compareTo(fraction2) < 0) continue;
            if (CursorStack.vwa(class_92762, class_17992) < 0) {
                return i;
            }
            if (n3 >= 0) continue;
            n3 = i;
        }
        return n3;
    }

    private static int vwa(class_9276 class_92762, class_1799 class_17992) {
        for (int i = 0; i < class_92762.method_57426(); ++i) {
            if (!class_1799.method_31577((class_1799)class_92762.method_57422(i), (class_1799)class_17992)) continue;
            return i;
        }
        return -1;
    }

    private static Fraction vwb(class_1799 class_17992) {
        return Fraction.ONE.subtract(CursorStack.contents(class_17992).method_57428());
    }

    private static Fraction vwc(class_1799 class_17992) {
        return CursorStack.vwd(class_17992).multiplyBy(Fraction.getFraction((int)class_17992.method_7947(), (int)1));
    }

    private static Fraction vwd(class_1799 class_17992) {
        class_9276 class_92762 = (class_9276)class_17992.method_58694(class_9334.field_49650);
        if (class_92762 != null) {
            return vvo.add(class_92762.method_57428());
        }
        if (!((class_10706)class_17992.method_58695(class_9334.field_49624, (Object)class_10706.field_56300)).comp_3585().isEmpty()) {
            return Fraction.ONE;
        }
        return Fraction.getFraction((int)1, (int)class_17992.method_7914());
    }

    private static int vwe(class_1661 class_16612, int n) {
        for (int i = 0; i < 36; ++i) {
            if (i == n || !class_16612.method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    private static void vwf(class_310 class_3102, int n, int n2) {
        class_1799 class_17992 = class_3102.field_1724.method_31548().method_5438(n);
        class_9276 class_92762 = CursorStack.contents(class_17992);
        int n3 = class_92762.method_61668();
        if (n3 == n2 || n2 == 0 && (n3 < 0 || n3 >= class_92762.method_57426())) {
            return;
        }
        class_5537.method_61637((class_1799)class_17992, (int)n2);
        class_3102.method_1562().method_52787((class_2596)new class_9837(InventoryClicks.slotId(n), n2));
    }

    private static void vwg(class_310 class_3102, int n, int n2) {
        class_746 class_7462 = class_3102.field_1724;
        class_3102.field_1761.method_2906(class_7462.field_7498.field_7763, InventoryClicks.slotId(n), n2, class_1713.field_7790, (class_1657)class_7462);
    }

    private static /* synthetic */ int dlf(int n, int n2) {
        return n ^ n2 ^ 0x9C95321B;
    }

    private static /* synthetic */ int dlg(int n, int n2) {
        return CursorStack.dlf(n, n2) + n;
    }

    private static /* synthetic */ int dlh(int n, int n2) {
        return CursorStack.dlf(n, n2) + n;
    }
}

