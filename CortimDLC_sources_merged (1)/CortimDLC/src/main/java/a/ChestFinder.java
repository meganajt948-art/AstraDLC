/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2551
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2625
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2818
 *  net.minecraft.class_310
 *  net.minecraft.class_7713
 *  net.minecraft.class_7715
 */
package a;

import flow.dev.StringDecryptor;
import java.util.Locale;
import net.minecraft.class_1937;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2551;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2625;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2818;
import net.minecraft.class_310;
import net.minecraft.class_7713;
import net.minecraft.class_7715;

public final class ChestFinder {
    private static /* synthetic */ int ptf;
    private static /* synthetic */ int ptg;

    private ChestFinder() {
    }

    public static class_2338 find(class_310 class_3102, class_2338 class_23382, String ... stringArray) {
        return ChestFinder.find(class_3102, class_23382, 10, 5, stringArray);
    }

    public static class_2338 find(class_310 class_3102, class_2338 class_23382, int n, int n2, String ... stringArray) {
        if (class_3102.field_1687 == null || class_23382 == null) {
            return null;
        }
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        int n3 = class_23382.method_10263() >> 4;
        int n4 = class_23382.method_10260() >> 4;
        int n5 = (n >> 4) + 1;
        for (int i = -n5; i <= n5; ++i) {
            for (int j = -n5; j <= n5; ++j) {
                class_2818 class_28182 = class_3102.field_1687.method_2935().method_12126(n3 + i, n4 + j, false);
                if (class_28182 == null) continue;
                for (class_2586 class_25862 : class_28182.method_12214().values()) {
                    double d2;
                    class_2338 class_23384;
                    class_2625 class_26252;
                    class_2338 class_23385;
                    if (!(class_25862 instanceof class_2625) || Math.abs((class_23385 = (class_26252 = (class_2625)class_25862).method_11016()).method_10263() - class_23382.method_10263()) > n || Math.abs(class_23385.method_10264() - class_23382.method_10264()) > n2 || Math.abs(class_23385.method_10260() - class_23382.method_10260()) > n || !ChestFinder.matches(class_26252, stringArray) || (class_23384 = ChestFinder.chestFor((class_1937)class_3102.field_1687, class_23385)) == null || !((d2 = class_23384.method_10262((class_2382)class_23382)) < d)) continue;
                    d = d2;
                    class_23383 = class_23384;
                }
            }
        }
        return class_23383;
    }

    public static boolean matches(class_2625 class_26252, String ... stringArray) {
        for (boolean bl : new boolean[]{true, false}) {
            class_2561[] class_2561Array;
            for (class_2561 class_25612 : class_2561Array = class_26252.method_49843(bl).method_49877(false)) {
                if (class_25612 == null) continue;
                String string = class_25612.getString().replace(" ", "").toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
                for (String string2 : stringArray) {
                    if (!string.contains(string2)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static class_2338 chestFor(class_1937 class_19372, class_2338 class_23382) {
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        if (class_26802.method_26204() instanceof class_2551) {
            class_2338 class_23383 = class_23382.method_10093(((class_2350)class_26802.method_11654((class_2769)class_2551.field_11726)).method_10153());
            if (ChestFinder.isChest(class_19372, class_23383)) {
                return class_23383;
            }
            return ChestFinder.isChest(class_19372, class_23382.method_10074()) ? class_23382.method_10074() : null;
        }
        if (class_26802.method_26204() instanceof class_7715) {
            class_2350 class_23502 = (class_2350)class_26802.method_11654((class_2769)class_7715.field_40319);
            for (class_2350 class_23503 : new class_2350[]{class_23502.method_10170(), class_23502.method_10160(), class_23502.method_10153()}) {
                if (!ChestFinder.isChest(class_19372, class_23382.method_10093(class_23503))) continue;
                return class_23382.method_10093(class_23503);
            }
            return ChestFinder.isChest(class_19372, class_23382.method_10074()) ? class_23382.method_10074() : null;
        }
        if (class_26802.method_26204() instanceof class_7713) {
            return ChestFinder.isChest(class_19372, class_23382.method_10084()) ? class_23382.method_10084() : null;
        }
        return ChestFinder.isChest(class_19372, class_23382.method_10074()) ? class_23382.method_10074() : null;
    }

    public static boolean isChest(class_1937 class_19372, class_2338 class_23382) {
        return class_19372.method_8320(class_23382).method_26204() instanceof class_2281;
    }

    private static /* synthetic */ int bog(int n, int n2) {
        return n - n2 + 458206696;
    }

    private static /* synthetic */ int boh(int n, int n2) {
        return n * n2 + 1005050481;
    }

    private static /* synthetic */ int boi(int n, int n2) {
        return ChestFinder.boh(n, n2) + n;
    }
}

