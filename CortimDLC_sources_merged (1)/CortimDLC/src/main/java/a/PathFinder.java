/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3481
 *  net.minecraft.class_3726
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 */
package a;

import a.pqj;
import a.pqq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3481;
import net.minecraft.class_3726;
import net.minecraft.class_3959;
import net.minecraft.class_3965;

public final class PathFinder {
    private static final int pqy = 6000;
    private static final int pqz = 100;
    public static final double STEP_HEIGHT = 0.6;
    public static final double JUMP_HEIGHT = 1.2;
    private static final double pra = 8.0;
    private static final int[][] prb = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final int[][] prc = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final class_2350[] prd = new class_2350[]{class_2350.field_11043, class_2350.field_11035, class_2350.field_11034, class_2350.field_11039};
    private static /* synthetic */ long pre;
    private static /* synthetic */ int prf;

    private PathFinder() {
    }

    public static List<class_2338> findPath(class_2338 class_23382, class_2338 class_23383, List<class_2338> list, double d, boolean bl) {
        return PathFinder.findPath(class_23382, class_23383, list, d, bl, Collections.emptySet());
    }

    public static List<class_2338> findPath(class_2338 class_23382, class_2338 class_23383, List<class_2338> list, double d, boolean bl, Set<class_2338> set) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null) {
            return null;
        }
        return PathFinder.findPath((class_1922)class_3102.field_1687, (class_1297)class_3102.field_1724, class_23382, class_23383, list, d, bl, set);
    }

    public static List<class_2338> findPath(class_1922 class_19222, class_1297 class_12972, class_2338 class_23382, class_2338 class_23383, List<class_2338> list, double d, boolean bl, Set<class_2338> set) {
        return PathFinder.findPath(class_19222, class_12972, class_23382, class_23383, list, d, bl, set, null);
    }

    public static List<class_2338> findPath(class_1922 class_19222, class_1297 class_12972, class_2338 class_23382, class_2338 class_23383, List<class_2338> list, double d, boolean bl, Set<class_2338> set, pqq pqq2) {
        HashMap<class_2338, Double> hashMap = bl ? new HashMap<class_2338, Double>() : null;
        PriorityQueue<pqj> priorityQueue = new PriorityQueue<pqj>(Comparator.comparingDouble(pqj::fCost));
        HashMap<class_2338, Double> hashMap2 = new HashMap<class_2338, Double>();
        HashSet<class_2338> hashSet = new HashSet<class_2338>();
        pqj pqj2 = new pqj(class_23382);
        pqj2.pqm = 0.0;
        pqj2.pqn = PathFinder.prn(class_23382, class_23383);
        priorityQueue.add(pqj2);
        hashMap2.put(class_23382, 0.0);
        pqj pqj3 = pqj2;
        double d2 = pqj2.pqn;
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>(8);
        int n = 0;
        while (!priorityQueue.isEmpty() && n++ < 6000) {
            pqj pqj4 = priorityQueue.poll();
            if (!hashSet.add(pqj4.pqk)) continue;
            if (pqj4.pqn < d2) {
                d2 = pqj4.pqn;
                pqj3 = pqj4;
            }
            if (PathFinder.prn(pqj4.pqk, class_23383) <= 2.0 && PathFinder.prm(class_19222, class_12972, pqj4.pqk, class_23383)) {
                return PathFinder.pro(pqj4);
            }
            double d3 = PathFinder.getStandY(class_19222, pqj4.pqk);
            List<class_2338> list2 = PathFinder.neighbors(class_19222, pqj4.pqk, list, d, set, arrayList);
            for (int i = 0; i < list2.size(); ++i) {
                class_2338 class_23384 = list2.get(i);
                if (hashSet.contains(class_23384)) continue;
                double d4 = PathFinder.prn(pqj4.pqk, class_23384);
                if (pqq2 != null) {
                    d4 *= pqq2.at(class_23384.method_10263(), class_23384.method_10260());
                }
                double d5 = PathFinder.getStandY(class_19222, class_23384) - d3;
                if (((Boolean)arrayList.get(i)).booleanValue()) {
                    d4 += 0.5;
                }
                if (d5 < -1.5) {
                    d4 += 0.2;
                }
                if (hashMap != null && d5 < -3.2) {
                    d4 += (-d5 - 3.2) * 1.5;
                }
                if (hashMap != null) {
                    d4 += PathFinder.prh(class_19222, class_23384, hashMap) * (pqq2 == null ? 1.0 : pqq2.wall);
                }
                if (PathFinder.isClimbable(class_19222, class_23384) || PathFinder.isClimbable(class_19222, class_23384.method_10084())) {
                    d4 += 8.0;
                }
                double d6 = pqj4.pqm + d4;
                Double d7 = (Double)hashMap2.get(class_23384);
                if (d7 != null && d6 >= d7 - 1.0E-6) continue;
                hashMap2.put(class_23384, d6);
                pqj pqj5 = new pqj(class_23384);
                pqj5.pqm = d6;
                pqj5.pqn = PathFinder.prn(class_23384, class_23383);
                pqj5.pql = pqj4;
                priorityQueue.add(pqj5);
            }
        }
        if (pqj3.pql != null) {
            return PathFinder.pro(pqj3);
        }
        return null;
    }

    public static double getStandY(class_1922 class_19222, class_2338 class_23382) {
        class_2338 class_23383 = class_23382.method_10074();
        class_265 class_2652 = class_19222.method_8320(class_23383).method_26220(class_19222, class_23383);
        if (class_2652.method_1110()) {
            return class_23382.method_10264();
        }
        return (double)class_23383.method_10264() + class_2652.method_1105(class_2350.class_2351.field_11052);
    }

    static List<class_2338> neighbors(class_1922 class_19222, class_2338 class_23382, List<class_2338> list, double d, Set<class_2338> set, List<Boolean> list2) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>(8);
        list2.clear();
        double d2 = PathFinder.getStandY(class_19222, class_23382);
        block0: for (int[] nArray : prb) {
            class_2338 class_23383;
            boolean bl;
            int n = nArray[0];
            int n2 = nArray[1];
            boolean bl2 = bl = n != 0 && n2 != 0;
            if (bl && (!PathFinder.prl(class_19222, class_23382.method_10069(n, 0, 0)) || !PathFinder.prl(class_19222, class_23382.method_10069(0, 0, n2)) || !PathFinder.prl(class_19222, class_23382.method_10069(n, 1, 0)) || !PathFinder.prl(class_19222, class_23382.method_10069(0, 1, n2)))) continue;
            class_2338 class_23384 = class_23382.method_10069(n, 0, n2);
            if (PathFinder.prj(class_19222, class_23384, list, d)) {
                if (set.contains(class_23384)) continue;
                arrayList.add(class_23384);
                list2.add(false);
                continue;
            }
            class_2338 class_23385 = class_23384.method_10084();
            if (PathFinder.prj(class_19222, class_23385, list, d)) {
                boolean bl3;
                boolean bl4;
                if (set.contains(class_23385)) continue;
                double d3 = PathFinder.getStandY(class_19222, class_23385);
                double d4 = d3 - d2;
                boolean bl5 = d4 <= 0.6 || !bl && PathFinder.prg(class_19222, class_23384, n, n2, d2);
                boolean bl6 = bl4 = !bl5 && d4 <= 1.2 && !PathFinder.pri(class_19222, class_23384);
                if (!bl5 && !bl4) continue;
                boolean bl7 = bl3 = bl4 || d3 + 1.8 > (double)class_23382.method_10264() + 2.0 + 1.0E-4;
                if (bl3 && (!PathFinder.prl(class_19222, class_23382.method_10086(2)) || bl && (!PathFinder.prl(class_19222, class_23382.method_10069(n, 2, 0)) || !PathFinder.prl(class_19222, class_23382.method_10069(0, 2, n2))))) continue;
                arrayList.add(class_23385);
                list2.add(bl4);
                continue;
            }
            if (!PathFinder.prl(class_19222, class_23384.method_10084())) continue;
            for (int i = 1; i <= 100 && PathFinder.prl(class_19222, (class_23383 = class_23384.method_10087(i)).method_10084()) && !PathFinder.isClimbable(class_19222, class_23383.method_10084()); ++i) {
                if (!PathFinder.prj(class_19222, class_23383, list, d)) continue;
                if (set.contains(class_23383)) continue block0;
                arrayList.add(class_23383);
                list2.add(false);
                continue block0;
            }
        }
        return arrayList;
    }

    private static boolean prg(class_1922 class_19222, class_2338 class_23382, int n, int n2, double d) {
        class_265 class_2652 = class_19222.method_8320(class_23382).method_26220(class_19222, class_23382);
        if (class_2652.method_1110()) {
            return false;
        }
        double d2 = class_2652.method_1105(class_2350.class_2351.field_11052);
        double d3 = n < 0 ? 0.5 : 0.0;
        double d4 = n > 0 ? 0.5 : 1.0;
        double d5 = n2 < 0 ? 0.5 : 0.0;
        double d6 = n2 > 0 ? 0.5 : 1.0;
        double d7 = 0.0;
        for (class_238 class_2383 : class_2652.method_1090()) {
            if (!(class_2383.field_1320 > d3 + 1.0E-4) || !(class_2383.field_1323 < d4 - 1.0E-4) || !(class_2383.field_1324 > d5 + 1.0E-4) || !(class_2383.field_1321 < d6 - 1.0E-4)) continue;
            d7 = Math.max(d7, class_2383.field_1325);
        }
        if (d7 >= d2 - 1.0E-4) {
            return false;
        }
        return (double)class_23382.method_10264() + d7 - d <= 0.6001 && d2 - d7 <= 0.6001;
    }

    private static double prh(class_1922 class_19222, class_2338 class_23382, Map<class_2338, Double> map) {
        Double d = map.get(class_23382);
        if (d != null) {
            return d;
        }
        double d2 = 0.0;
        for (Object object : prd) {
            class_2338 class_23383 = class_23382.method_10093(object);
            if (PathFinder.prl(class_19222, class_23383) && PathFinder.prl(class_19222, class_23383.method_10084())) continue;
            d2 += 0.32;
        }
        int[][] nArray = prc;
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            Object object;
            object = nArray[i];
            if (PathFinder.prl(class_19222, class_23382.method_10069((int)object[0], 0, (int)object[1])) && PathFinder.prl(class_19222, class_23382.method_10069((int)object[0], 1, (int)object[1]))) continue;
            d2 += 0.14;
        }
        map.put(class_23382.method_10062(), d2);
        return d2;
    }

    private static boolean pri(class_1922 class_19222, class_2338 class_23382) {
        class_2680 class_26802 = class_19222.method_8320(class_23382);
        class_265 class_2652 = class_26802.method_26220(class_19222, class_23382);
        if (class_2652.method_1110()) {
            return false;
        }
        return class_2652.method_1105(class_2350.class_2351.field_11052) > 1.0;
    }

    private static boolean prj(class_1922 class_19222, class_2338 class_23382, List<class_2338> list, double d) {
        if (!list.isEmpty() && d > 0.0) {
            double d2 = d * d;
            for (class_2338 class_2350Array : list) {
                if (!(class_23382.method_10262((class_2382)class_2350Array) <= d2)) continue;
                return false;
            }
        }
        if (!PathFinder.prl(class_19222, class_23382) || !PathFinder.prl(class_19222, class_23382.method_10084())) {
            return false;
        }
        class_2338 class_23383 = class_23382.method_10074();
        class_2680 class_26802 = class_19222.method_8320(class_23383);
        if (PathFinder.prl(class_19222, class_23383) && !class_26802.method_27852(class_2246.field_10382)) {
            return false;
        }
        if (PathFinder.pri(class_19222, class_23383)) {
            return false;
        }
        if (PathFinder.prk(class_26802)) {
            return false;
        }
        class_2680 class_26803 = class_19222.method_8320(class_23382);
        if (class_26803.method_27852(class_2246.field_10164) || class_26803.method_27852(class_2246.field_10036)) {
            return false;
        }
        for (class_2350 class_23502 : prd) {
            class_2338 class_23384 = class_23382.method_10093(class_23502);
            if (!PathFinder.prk(class_19222.method_8320(class_23384)) && !PathFinder.prk(class_19222.method_8320(class_23384.method_10074()))) continue;
            return false;
        }
        return true;
    }

    private static boolean prk(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10164) || class_26802.method_27852(class_2246.field_10036) || class_26802.method_27852(class_2246.field_17350) || class_26802.method_27852(class_2246.field_10092);
    }

    private static boolean prl(class_1922 class_19222, class_2338 class_23382) {
        class_2680 class_26802 = class_19222.method_8320(class_23382);
        return class_26802.method_26220(class_19222, class_23382).method_1110() && !class_26802.method_27852(class_2246.field_10164);
    }

    public static boolean isClimbable(class_1922 class_19222, class_2338 class_23382) {
        return class_19222.method_8320(class_23382).method_26164(class_3481.field_22414);
    }

    private static boolean prm(class_1922 class_19222, class_1297 class_12972, class_2338 class_23382, class_2338 class_23383) {
        if (PathFinder.prn(class_23382, class_23383) > 4.0) {
            return false;
        }
        class_243 class_2432 = new class_243((double)class_23382.method_10263() + 0.5, PathFinder.getStandY(class_19222, class_23382) + 1.62, (double)class_23382.method_10260() + 0.5);
        class_243 class_2433 = class_243.method_24953((class_2382)class_23383);
        class_3965 class_39652 = class_19222.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, class_12972 == null ? class_3726.method_16194() : class_3726.method_16195((class_1297)class_12972)));
        return class_39652.method_17783() == class_239.class_240.field_1333 || class_39652.method_17777().equals((Object)class_23383);
    }

    private static double prn(class_2338 class_23382, class_2338 class_23383) {
        double d = class_23382.method_10263() - class_23383.method_10263();
        double d2 = class_23382.method_10264() - class_23383.method_10264();
        double d3 = class_23382.method_10260() - class_23383.method_10260();
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    private static List<class_2338> pro(pqj pqj2) {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        pqj pqj3 = pqj2;
        while (pqj3 != null && pqj3.pql != null) {
            arrayList.add(pqj3.pqk);
            pqj3 = pqj3.pql;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private static /* synthetic */ int bmz(int n, int n2) {
        return n ^ n2 ^ 0xC97FF2F3;
    }

    private static /* synthetic */ int bna(int n, int n2) {
        return n * n2 ^ 0x2A97661F;
    }

    private static /* synthetic */ int bnb(int n, int n2) {
        return PathFinder.bna(n, n2) * n2;
    }
}

