/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10192
 *  net.minecraft.class_1304
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

import a.vuc;
import a.CursorStack;
import a.InventoryClicks;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import net.minecraft.class_10192;
import net.minecraft.class_1304;
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

public final class EquipUtil {
    private static /* synthetic */ int vuj;
    private static /* synthetic */ String vuk;

    private EquipUtil() {
    }

    public static int slotId(class_1304 class_13042) {
        return switch (class_13042) {
            case class_1304.field_6169 -> 5;
            case class_1304.field_6174 -> 6;
            case class_1304.field_6172 -> 7;
            default -> 8;
        };
    }

    public static class_1304 wornIn(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return null;
        }
        class_10192 class_101922 = (class_10192)class_17992.method_58694(class_9334.field_54196);
        if (class_101922 == null) {
            return null;
        }
        class_1304 class_13042 = class_101922.comp_3174();
        return class_13042 == class_1304.field_6169 || class_13042 == class_1304.field_6174 || class_13042 == class_1304.field_6172 || class_13042 == class_1304.field_6166 ? class_13042 : null;
    }

    public static int left(class_1799 class_17992) {
        return class_17992.method_7963() ? class_17992.method_7936() - class_17992.method_7919() : Integer.MAX_VALUE;
    }

    public static vuc best(class_1661 class_16612, boolean bl, ToIntFunction<class_1799> toIntFunction) {
        vuc vuc2 = null;
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_9276 class_92762;
            class_1799 class_17992 = class_16612.method_5438(i);
            int n2 = toIntFunction.applyAsInt(class_17992);
            if (n2 > n) {
                vuc2 = new vuc(i, -1, class_17992);
                n = n2;
            }
            if (!bl || (class_92762 = CursorStack.contents(class_17992)) == null) continue;
            for (int j = 0; j < class_92762.method_57426(); ++j) {
                class_1799 class_17993 = class_92762.method_57422(j);
                int n3 = toIntFunction.applyAsInt(class_17993);
                if (n3 <= n) continue;
                vuc2 = new vuc(i, j, class_17993);
                n = n3;
            }
        }
        return vuc2;
    }

    public static boolean roomFor(class_1661 class_16612, vuc vuc2, class_1799 class_17992) {
        Fraction fraction;
        if (class_17992.method_7960() || !vuc2.inBundle()) {
            return true;
        }
        class_1799 class_17993 = class_16612.method_5438(vuc2.index());
        class_9276 class_92762 = CursorStack.contents(class_17993);
        if (class_92762 != null && (fraction = Fraction.ONE.subtract(class_92762.method_57428()).add(Fraction.getFraction((int)vuc2.stack().method_7947(), (int)vuc2.stack().method_7914()))).compareTo(Fraction.getFraction((int)class_17992.method_7947(), (int)class_17992.method_7914())) >= 0) {
            return true;
        }
        return EquipUtil.vum(class_16612) >= 0;
    }

    public static boolean equip(class_310 class_3102, class_1304 class_13042, vuc vuc2) {
        int n;
        class_746 class_7462 = class_3102.field_1724;
        if (!InventoryClicks.canClick(class_7462)) {
            return false;
        }
        class_1661 class_16612 = class_7462.method_31548();
        int n2 = EquipUtil.slotId(class_13042);
        if (vuc2.inBundle()) {
            class_1799 class_17992 = class_16612.method_5438(vuc2.index());
            class_9276 class_92762 = CursorStack.contents(class_17992);
            if (class_92762 == null || vuc2.entry() >= class_92762.method_57426()) {
                return false;
            }
            EquipUtil.vun(class_3102, vuc2.index(), vuc2.entry());
            EquipUtil.vuo(class_3102, InventoryClicks.slotId(vuc2.index()), 1);
        } else {
            EquipUtil.vuo(class_3102, InventoryClicks.slotId(vuc2.index()), 0);
        }
        if (EquipUtil.vul(class_7462).method_7960()) {
            return false;
        }
        EquipUtil.vuo(class_3102, n2, 0);
        if (!EquipUtil.vul(class_7462).method_7960()) {
            EquipUtil.vuo(class_3102, InventoryClicks.slotId(vuc2.index()), 0);
        }
        if (!EquipUtil.vul(class_7462).method_7960() && (n = EquipUtil.vum(class_16612)) >= 0) {
            EquipUtil.vuo(class_3102, InventoryClicks.slotId(n), 0);
        }
        if (!EquipUtil.vul(class_7462).method_7960()) {
            EquipUtil.vuo(class_3102, n2, 0);
            EquipUtil.vuo(class_3102, InventoryClicks.slotId(vuc2.index()), 0);
        }
        InventoryClicks.close(class_3102);
        return class_1799.method_7984((class_1799)class_7462.method_6118(class_13042), (class_1799)vuc2.stack());
    }

    public static boolean takeOff(class_310 class_3102, class_1304 class_13042) {
        class_746 class_7462 = class_3102.field_1724;
        int n = EquipUtil.vum(class_7462.method_31548());
        if (n < 0 || !InventoryClicks.canClick(class_7462) || class_7462.method_6118(class_13042).method_7960()) {
            return false;
        }
        EquipUtil.vuo(class_3102, EquipUtil.slotId(class_13042), 0);
        EquipUtil.vuo(class_3102, InventoryClicks.slotId(n), 0);
        InventoryClicks.close(class_3102);
        return true;
    }

    public static boolean matches(class_1799 class_17992, Predicate<class_1799> predicate) {
        return !class_17992.method_7960() && predicate.test(class_17992);
    }

    private static class_1799 vul(class_746 class_7462) {
        return class_7462.field_7498.method_34255();
    }

    private static int vum(class_1661 class_16612) {
        int n;
        for (n = 9; n < 36; ++n) {
            if (!class_16612.method_5438(n).method_7960()) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (!class_16612.method_5438(n).method_7960()) continue;
            return n;
        }
        return -1;
    }

    private static void vun(class_310 class_3102, int n, int n2) {
        int n3;
        class_1799 class_17992 = class_3102.field_1724.method_31548().method_5438(n);
        class_9276 class_92762 = CursorStack.contents(class_17992);
        int n4 = n3 = class_92762 == null ? -1 : class_92762.method_61668();
        if (class_92762 == null || n3 == n2 || n2 == 0 && (n3 < 0 || n3 >= class_92762.method_57426())) {
            return;
        }
        class_5537.method_61637((class_1799)class_17992, (int)n2);
        class_3102.method_1562().method_52787((class_2596)new class_9837(InventoryClicks.slotId(n), n2));
    }

    private static void vuo(class_310 class_3102, int n, int n2) {
        class_746 class_7462 = class_3102.field_1724;
        class_3102.field_1761.method_2906(class_7462.field_7498.field_7763, n, n2, class_1713.field_7790, (class_1657)class_7462);
    }

    private static /* synthetic */ int dkt(int n, int n2) {
        return n * n2 ^ 0xDDFD7A6;
    }

    private static /* synthetic */ int dku(int n, int n2) {
        return n ^ n2 | 0xA2766197;
    }
}

