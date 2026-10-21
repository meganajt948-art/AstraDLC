/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 *  net.minecraft.class_310
 *  net.minecraft.class_465
 *  net.minecraft.class_746
 */
package a;

import net.minecraft.class_1263;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import net.minecraft.class_310;
import net.minecraft.class_465;
import net.minecraft.class_746;

public final class InventoryClicks {
    private static /* synthetic */ int wdr;
    private static /* synthetic */ long wds;

    private InventoryClicks() {
    }

    public static void swap(class_310 class_3102, int n, int n2) {
        InventoryClicks.click(class_3102, n, n2);
        InventoryClicks.close(class_3102);
    }

    public static void click(class_310 class_3102, int n, int n2) {
        class_746 class_7462 = class_3102.field_1724;
        class_3102.field_1761.method_2906(class_7462.field_7498.field_7763, InventoryClicks.slotId(n), n2, class_1713.field_7791, (class_1657)class_7462);
    }

    public static void close(class_310 class_3102) {
        if (!(class_3102.field_1755 instanceof class_465)) {
            class_746 class_7462 = class_3102.field_1724;
            class_7462.field_3944.method_52787((class_2596)new class_2815(class_7462.field_7498.field_7763));
        }
    }

    public static int slotId(int n) {
        return n < 9 ? 36 + n : n;
    }

    public static int slotId(class_1703 class_17032, class_1263 class_12632, int n) {
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (class_17352.field_7871 != class_12632 || class_17352.method_34266() != n) continue;
            return class_17352.field_7874;
        }
        return -1;
    }

    public static boolean canClick(class_746 class_7462) {
        return class_7462 != null && class_7462.method_5805() && !class_7462.method_7325() && class_7462.field_7512 == class_7462.field_7498 && class_7462.field_7498.method_34255().method_7960();
    }

    private static /* synthetic */ int dpk(int n, int n2) {
        return n ^ n2 | 0x279F5F85;
    }
}

