/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3486
 */
package a;

import a.WalkHazards;
import java.util.List;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3486;

public final class StandCheck {
    public static final double STEP = 0.6;
    private static /* synthetic */ String pub;
    private static /* synthetic */ boolean puc;

    private StandCheck() {
    }

    public static boolean bodyFits(class_1937 class_19372, class_1297 class_12972, double d, double d2, double d3, double d4) {
        class_238 class_2383 = new class_238(d - d4, d3 + 0.6, d2 - d4, d + d4, d3 + 1.8, d2 + d4);
        for (class_265 class_2652 : class_19372.method_20812(class_12972, class_2383)) {
            if (class_2652.method_1110()) continue;
            return false;
        }
        return true;
    }

    public static boolean water(class_1937 class_19372, double d, double d2, double d3) {
        class_2338.class_2339 class_23392 = new class_2338.class_2339((int)Math.floor(d), (int)Math.floor(d2 + 0.1), (int)Math.floor(d3));
        if (class_19372.method_8316((class_2338)class_23392).method_15767(class_3486.field_15517)) {
            return true;
        }
        class_23392.method_10098(class_2350.field_11033);
        return class_19372.method_8316((class_2338)class_23392).method_15767(class_3486.field_15517) && d2 - (double)class_23392.method_10264() < 1.05;
    }

    public static double standAt(class_1937 class_19372, double d, double d2, double d3, double d4) {
        int n = (int)Math.floor(d);
        int n2 = (int)Math.floor(d3);
        if (StandCheck.water(class_19372, d, d2, d3)) {
            return d2;
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        int n3 = (int)Math.floor(d2 + 0.6);
        int n4 = (int)Math.floor(d2 - d4) - 1;
        for (int i = n3; i >= n4; --i) {
            class_23392.method_10103(n, i, n2);
            class_2680 class_26802 = class_19372.method_8320((class_2338)class_23392);
            class_265 class_2652 = class_26802.method_26220((class_1922)class_19372, (class_2338)class_23392);
            if (class_2652.method_1110()) {
                if (!class_26802.method_26227().method_15767(class_3486.field_15517)) continue;
                return Math.max((double)i + 1.0, d2 - d4);
            }
            double d5 = (double)i + class_2652.method_1105(class_2350.class_2351.field_11052);
            if (d5 > d2 + 0.6 + 1.0E-4) {
                return Double.NaN;
            }
            if (d5 < d2 - d4 - 1.0E-4) {
                return Double.NaN;
            }
            return d5;
        }
        return Double.NaN;
    }

    public static boolean hazard(class_1937 class_19372, double d, double d2, double d3) {
        int n = (int)Math.floor(d);
        int n2 = (int)Math.floor(d3);
        int n3 = (int)Math.floor(d2 + 0.01);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = -1; i <= 1; ++i) {
            class_23392.method_10103(n, n3 + i, n2);
            if (!WalkHazards.hazard(class_19372.method_8320((class_2338)class_23392))) continue;
            return true;
        }
        return false;
    }

    public static boolean blocked(class_2338 class_23382, List<class_2338> list, double d, Set<class_2338> set) {
        if (!set.isEmpty() && (set.contains(class_23382) || set.contains(class_23382.method_10074()))) {
            return true;
        }
        if (!list.isEmpty() && d > 0.0) {
            double d2 = d * d;
            for (class_2338 class_23383 : list) {
                double d3;
                double d4;
                double d5 = class_23383.method_10263() - class_23382.method_10263();
                if (!(d5 * d5 + (d4 = (double)(class_23383.method_10260() - class_23382.method_10260())) * d4 + (d3 = (double)(class_23383.method_10264() - class_23382.method_10264())) * d3 <= d2)) continue;
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ int bos(int n, int n2) {
        return n * n2 ^ 0xFF087E17;
    }
}

