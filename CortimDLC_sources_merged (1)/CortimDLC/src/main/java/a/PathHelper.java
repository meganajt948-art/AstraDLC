/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2399
 *  net.minecraft.class_243
 *  net.minecraft.class_2541
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_3481
 */
package a;

import a.PathFinder;
import java.util.Iterator;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2399;
import net.minecraft.class_243;
import net.minecraft.class_2541;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_3481;

public final class PathHelper {
    public static final double MAX_JUMP = 1.25;
    private static /* synthetic */ boolean pqg;
    private static /* synthetic */ int pqh;

    private PathHelper() {
    }

    private static class_310 pqi() {
        return class_310.method_1551();
    }

    public static double getStandY(class_2338 class_23382) {
        class_310 class_3102 = PathHelper.pqi();
        if (class_3102.field_1687 == null) {
            return class_23382.method_10264();
        }
        return PathFinder.getStandY((class_1922)class_3102.field_1687, class_23382);
    }

    public static boolean isBlockedHorizontally() {
        class_310 class_3102 = PathHelper.pqi();
        if (class_3102.field_1724 == null) {
            return false;
        }
        return class_3102.field_1724.field_5976 && class_3102.field_1724.method_18798().method_37268() < 0.0025;
    }

    public static double getFrontStepUp(float f) {
        class_2338 class_23382;
        class_265 class_2652;
        class_310 class_3102 = PathHelper.pqi();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null) {
            return 0.0;
        }
        class_243 class_2432 = class_243.method_1030((float)0.0f, (float)f).method_1029();
        class_2338 class_23383 = class_2338.method_49637((double)(class_3102.field_1724.method_23317() + class_2432.field_1352 * 0.65), (double)(class_3102.field_1724.method_23318() + 0.1), (double)(class_3102.field_1724.method_23321() + class_2432.field_1350 * 0.65));
        double d = Double.NEGATIVE_INFINITY;
        for (int i = 0; i <= 2 && !(class_2652 = class_3102.field_1687.method_8320(class_23382 = class_23383.method_10086(i)).method_26220((class_1922)class_3102.field_1687, class_23382)).method_1110(); ++i) {
            d = (double)class_23382.method_10264() + class_2652.method_1105(class_2350.class_2351.field_11052);
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return Math.max(0.0, d - class_3102.field_1724.method_23318());
    }

    public static boolean isJumpUseful(float f) {
        double d = PathHelper.getFrontStepUp(f);
        return d > 0.6 && d <= 1.25;
    }

    public static boolean onClimbable(class_1657 class_16572) {
        return class_16572 != null && class_16572.method_6101() && !class_16572.method_5799() && !class_16572.method_31549().field_7479;
    }

    public static class_243 awayFromClimbable(class_1657 class_16572) {
        class_310 class_3102 = PathHelper.pqi();
        if (class_3102.field_1687 == null || class_16572 == null) {
            return null;
        }
        class_2338 class_23382 = class_16572.method_24515();
        double d = 0.0;
        double d2 = 0.0;
        for (class_2338 class_23383 : new class_2338[]{class_23382, class_23382.method_10084()}) {
            class_2680 class_26802 = class_3102.field_1687.method_8320(class_23383);
            if (class_26802.method_26204() instanceof class_2541) {
                for (class_2350 class_23502 : class_2350.class_2353.field_11062) {
                    class_2746 class_27462 = class_2541.method_10828((class_2350)class_23502);
                    if (class_27462 == null || !((Boolean)class_26802.method_11654((class_2769)class_27462)).booleanValue()) continue;
                    d -= (double)class_23502.method_10148();
                    d2 -= (double)class_23502.method_10165();
                }
                continue;
            }
            if (!(class_26802.method_26204() instanceof class_2399)) continue;
            Iterator iterator = (class_2350)class_26802.method_11654((class_2769)class_2399.field_11253);
            d += (double)iterator.method_10148();
            d2 += (double)iterator.method_10165();
        }
        if (d != 0.0 || d2 != 0.0) {
            double d3 = Math.hypot(d, d2);
            return new class_243(d / d3, 0.0, d2 / d3);
        }
        for (class_2350 class_23503 : class_2350.class_2353.field_11062) {
            class_2338 class_23384 = class_23382.method_10093(class_23503);
            boolean bl = class_3102.field_1687.method_8320(class_23384).method_26220((class_1922)class_3102.field_1687, class_23384).method_1110() && class_3102.field_1687.method_8320(class_23384.method_10084()).method_26220((class_1922)class_3102.field_1687, class_23384.method_10084()).method_1110() && !class_3102.field_1687.method_8320(class_23384).method_26164(class_3481.field_22414);
            if (!bl) continue;
            return new class_243((double)class_23503.method_10148(), 0.0, (double)class_23503.method_10165());
        }
        return null;
    }

    public static void resetKeys() {
        class_310 class_3102 = PathHelper.pqi();
        if (class_3102.field_1690 != null) {
            class_3102.field_1690.field_1894.method_23481(false);
            class_3102.field_1690.field_1881.method_23481(false);
            class_3102.field_1690.field_1913.method_23481(false);
            class_3102.field_1690.field_1849.method_23481(false);
            class_3102.field_1690.field_1903.method_23481(false);
            class_3102.field_1690.field_1867.method_23481(false);
        }
    }

    public static boolean hasReachedNode(class_2338 class_23382) {
        double d;
        class_310 class_3102 = PathHelper.pqi();
        if (class_3102.field_1724 == null) {
            return false;
        }
        double d2 = class_3102.field_1724.method_23317() - ((double)class_23382.method_10263() + 0.5);
        double d3 = d2 * d2 + (d = class_3102.field_1724.method_23321() - ((double)class_23382.method_10260() + 0.5)) * d;
        boolean bl = d3 < 0.36;
        double d4 = class_3102.field_1724.method_23318() - PathHelper.getStandY(class_23382);
        boolean bl2 = d4 > -0.6 && d4 < 1.6;
        return bl && bl2;
    }

    private static /* synthetic */ int bmo(int n, int n2) {
        return n * n2 ^ 0xEAB3C550;
    }
}

