/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 */
package a;

import a.PathFinder;
import a.prw;
import a.prz;
import a.psc;
import a.StandCheck;
import a.PathProjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;

public final class Route {
    private static final AtomicLong psg = new AtomicLong();
    private static final double psh = 0.25;
    private static final double psi = 0.32;
    private static final byte psj = 0;
    public final long id = psg.incrementAndGet();
    public final List<class_2338> nodes;
    public final PathProjection track;
    public final int[] nodeAt;
    public final class_2338 goal;
    public final boolean direct;
    private static /* synthetic */ int psk;
    private static /* synthetic */ long psl;

    private Route(List<class_2338> list, PathProjection tvt2, int[] nArray, class_2338 class_23382, boolean bl) {
        this.nodes = list;
        this.track = tvt2;
        this.nodeAt = nArray;
        this.goal = class_23382;
        this.direct = bl;
    }

    public class_243 end() {
        int n = this.track.n - 1;
        return new class_243((double)this.track.x[n], (double)this.track.y[n], (double)this.track.z[n]);
    }

    public int nodeIndex(int n) {
        if (this.nodes.isEmpty()) {
            return 0;
        }
        return this.nodeAt[Math.max(0, Math.min(this.nodeAt.length - 1, n))];
    }

    public static Route of(class_1937 class_19372, class_1297 class_12972, class_243 class_2432, List<class_2338> list, class_2338 class_23382, psc psc2, prz prz2, Random random) {
        Object object;
        Object object2;
        if (list == null || list.isEmpty() || class_19372 == null) {
            return null;
        }
        prw prw2 = new prw(class_19372, class_12972, prz2);
        ArrayList<double[]> arrayList = new ArrayList<double[]>();
        arrayList.add(new double[]{class_2432.field_1352, Route.psm(class_19372, class_2432), class_2432.field_1350});
        for (class_2338 object32 : list) {
            arrayList.add(new double[]{(double)object32.method_10263() + 0.5, PathFinder.getStandY((class_1922)class_19372, object32), (double)object32.method_10260() + 0.5});
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Byte> arrayList3 = new ArrayList<Byte>();
        ArrayList<Object> arrayList4 = new ArrayList<Object>();
        arrayList4.add((double[])arrayList.get(0));
        int n = 0;
        while (n + 1 < arrayList.size()) {
            byte by;
            boolean dArray2;
            object2 = (double[])arrayList.get(n);
            object = (double[])arrayList.get(n + 1);
            double list2 = object[1] - object2[1];
            boolean bl = dArray2 = StandCheck.water(class_19372, object2[0], object2[1], object2[2]) || StandCheck.water(class_19372, object[0], object[1], object[2]);
            byte by2 = dArray2 ? (byte)0 : (list2 > 0.601 ? (byte)1 : (by = list2 < -0.601 ? (byte)2 : 0));
            if (by == 0) {
                arrayList4.add(object);
            } else {
                arrayList2.add(arrayList4);
                arrayList3.add(by);
                arrayList4 = new ArrayList();
                arrayList4.add(object);
            }
            ++n;
        }
        arrayList2.add(arrayList4);
        for (n = 0; n < arrayList2.size(); ++n) {
            object2 = (List)arrayList2.get(n);
            object = Route.psn(prw2, (List<double[]>)object2, psc2.wide);
            List<double[]> list2 = Route.pso(prw2, (List<double[]>)object, psc2.radius, random);
            Route.psp(prw2, list2, psc2.wobble, random);
            if (n >= arrayList3.size()) continue;
            double[] dArray = (double[])object2.get(object2.size() - 1);
            double[] dArray2 = (double[])((List)arrayList2.get(n + 1)).get(0);
            if (object.size() > 0) {
                dArray = new double[]{prw2.xs.get(prw2.xs.size() - 1), prw2.ys.get(prw2.ys.size() - 1), prw2.zs.get(prw2.zs.size() - 1)};
            }
            Route.psr(prw2, dArray, dArray2, (Byte)arrayList3.get(n));
        }
        return Route.pss(prw2, list, class_23382, false);
    }

    public static Route direct(class_1937 class_19372, class_1297 class_12972, class_243 class_2432, class_243 class_2433) {
        if (class_19372 == null) {
            return null;
        }
        prw prw2 = new prw(class_19372, class_12972, new prz());
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        double d3 = Math.hypot(d, d2);
        double d4 = Route.psm(class_19372, class_2432);
        prw2.add(class_2432.field_1352, d4, class_2432.field_1350, (byte)0);
        int n = Math.max(1, (int)Math.ceil(d3 / 0.25));
        double d5 = d4;
        for (int i = 1; i <= n; ++i) {
            double d6 = (double)i / (double)n;
            double d7 = class_2432.field_1352 + d * d6;
            double d8 = class_2432.field_1350 + d2 * d6;
            double d9 = StandCheck.standAt(class_19372, d7, d5 + 0.6 + 0.65, d8, 2.5);
            byte by = 0;
            if (Double.isNaN(d9)) {
                d9 = d5;
            } else if (d9 - d5 > 0.601) {
                by = 1;
            } else if (d5 - d9 > 0.601) {
                by = 2;
            }
            if (StandCheck.water(class_19372, d7, d9, d8)) {
                by = (byte)(by | 4);
            }
            prw2.add(d7, d9, d8, by);
            d5 = d9;
        }
        return Route.pss(prw2, List.of(), class_2338.method_49638((class_2374)class_2433), true);
    }

    private static double psm(class_1937 class_19372, class_243 class_2432) {
        double d = StandCheck.standAt(class_19372, class_2432.field_1352, class_2432.field_1351 + 0.01, class_2432.field_1350, 3.0);
        return Double.isNaN(d) ? class_2432.field_1351 : d;
    }

    private static List<double[]> psn(prw prw2, List<double[]> list, double d) {
        ArrayList<double[]> arrayList = new ArrayList<double[]>();
        if (list.isEmpty()) {
            return arrayList;
        }
        arrayList.add(list.get(0));
        int n = 0;
        int n2 = list.size() - 1;
        while (n < n2) {
            int n3 = n + 1;
            boolean bl = false;
            for (double d2 : new double[]{d, 0.32}) {
                for (int i = Math.min(n2, n + 22); i > n + 1; --i) {
                    if (!prw2.clear(list.get(n), list.get(i), d2)) continue;
                    n3 = i;
                    bl = true;
                    break;
                }
                if (bl) break;
            }
            arrayList.add(list.get(n3));
            n = n3;
        }
        return arrayList;
    }

    private static List<double[]> pso(prw prw2, List<double[]> list, double d, Random random) {
        if (list.size() < 3) {
            return list;
        }
        ArrayList<double[]> arrayList = new ArrayList<double[]>();
        arrayList.add(list.get(0));
        double[] dArray = list.get(0);
        int n = 1;
        while (n + 1 < list.size()) {
            double[] dArray2 = list.get(n);
            double[] dArray3 = list.get(n + 1);
            double d2 = dArray2[0] - dArray[0];
            double d3 = dArray2[2] - dArray[2];
            double d4 = dArray3[0] - dArray2[0];
            double d5 = dArray3[2] - dArray2[2];
            double d6 = Math.hypot(d2, d3);
            double d7 = Math.hypot(d4, d5);
            if (d6 < 0.001 || d7 < 0.001) {
                arrayList.add(dArray2);
                dArray = dArray2;
            } else {
                double d8 = Math.max(-1.0, Math.min(1.0, (d2 /= d6) * (d4 /= d7) + (d3 /= d6) * (d5 /= d7)));
                double d9 = Math.acos(d8);
                if (d9 < 0.14) {
                    arrayList.add(dArray2);
                    dArray = dArray2;
                } else {
                    double d10 = d * (0.75 + random.nextDouble() * 0.5);
                    double d11 = Math.min(Math.min(d6 * 0.48, d7 * 0.48), Math.min(3.2, d10 * Math.tan(d9 * 0.5)));
                    boolean bl = false;
                    for (int i = 0; i < 4 && d11 > 0.2; d11 *= 0.55, ++i) {
                        double[] dArray4 = new double[]{dArray2[0] - d2 * d11, dArray2[1], dArray2[2] - d3 * d11};
                        double[] dArray5 = new double[]{dArray2[0] + d4 * d11, dArray2[1], dArray2[2] + d5 * d11};
                        int n2 = Math.max(3, (int)Math.ceil(d11 * 2.0 * d9 / 0.5));
                        ArrayList<double[]> arrayList2 = new ArrayList<double[]>();
                        arrayList2.add(dArray4);
                        double d12 = dArray2[1];
                        boolean bl2 = true;
                        for (int j = 1; j <= n2; ++j) {
                            double d13 = (double)j / (double)n2;
                            double d14 = (1.0 - d13) * (1.0 - d13);
                            double d15 = 2.0 * d13 * (1.0 - d13);
                            double d16 = d13 * d13;
                            double d17 = d14 * dArray4[0] + d15 * dArray2[0] + d16 * dArray5[0];
                            double d18 = d14 * dArray4[2] + d15 * dArray2[2] + d16 * dArray5[2];
                            double[] dArray6 = new double[]{d17, d12, d18};
                            if (!prw2.clear((double[])arrayList2.get(arrayList2.size() - 1), dArray6, 0.32)) {
                                bl2 = false;
                                break;
                            }
                            double d19 = StandCheck.standAt(prw2.world, d17, d12, d18, 0.6);
                            dArray6[1] = Double.isNaN(d19) ? d12 : d19;
                            d12 = dArray6[1];
                            arrayList2.add(dArray6);
                        }
                        if (!bl2) continue;
                        arrayList.addAll(arrayList2);
                        dArray = (double[])arrayList2.get(arrayList2.size() - 1);
                        bl = true;
                        break;
                    }
                    if (!bl) {
                        arrayList.add(dArray2);
                        dArray = dArray2;
                    }
                }
            }
            ++n;
        }
        arrayList.add(list.get(list.size() - 1));
        return arrayList;
    }

    private static void psp(prw prw2, List<double[]> list, double d, Random random) {
        int n;
        double d2;
        double[] dArray;
        ArrayList<double[]> arrayList = new ArrayList<double[]>();
        arrayList.add(list.get(0));
        int n2 = 0;
        while (n2 + 1 < list.size()) {
            dArray = list.get(n2);
            double[] dArray2 = list.get(n2 + 1);
            double d3 = Math.hypot(dArray2[0] - dArray[0], dArray2[2] - dArray[2]);
            int n3 = Math.max(1, (int)Math.ceil(d3 / 0.25));
            d2 = dArray[1];
            for (int i = 1; i <= n3; ++i) {
                double d4 = (double)i / (double)n3;
                double d5 = dArray[0] + (dArray2[0] - dArray[0]) * d4;
                double d6 = dArray[2] + (dArray2[2] - dArray[2]) * d4;
                double d7 = StandCheck.standAt(prw2.world, d5, d2, d6, 0.6);
                if (Double.isNaN(d7)) {
                    d7 = dArray[1] + (dArray2[1] - dArray[1]) * d4;
                }
                arrayList.add(new double[]{d5, d7, d6});
                d2 = d7;
            }
            ++n2;
        }
        n2 = arrayList.size();
        dArray = new double[n2];
        if (d > 0.01 && n2 > 12) {
            int n4;
            int n5;
            double d8 = (double)(n2 - 1) * 0.25;
            double d9 = d * (0.6 + random.nextDouble() * 0.8);
            d2 = 7.0 + random.nextDouble() * 6.0;
            double d10 = 3.5 + random.nextDouble() * 2.5;
            double d11 = random.nextDouble() * Math.PI * 2.0;
            double d12 = random.nextDouble() * Math.PI * 2.0;
            double[] dArray3 = new double[n2];
            Arrays.fill(dArray3, 1.0);
            for (n5 = 0; n5 < n2; ++n5) {
                double d13 = (double)n5 * 0.25;
                double d14 = Math.min(1.0, Math.min(d13 / 2.0, (d8 - d13) / 2.0));
                dArray[n5] = d9 * Math.max(0.0, d14) * (0.65 * Math.sin(Math.PI * 2 * d13 / d2 + d11) + 0.35 * Math.sin(Math.PI * 2 * d13 / d10 + d12));
            }
            n5 = 1;
            while (n5 + 1 < n2) {
                double[] dArray4 = Route.psq(arrayList, n5, dArray[n5]);
                if (dArray4 == null || !prw2.fits(dArray4[0], dArray4[1], dArray4[2])) {
                    for (int i = Math.max(0, n5 - 5); i <= Math.min(n2 - 1, n5 + 5); ++i) {
                        dArray3[i] = 0.0;
                    }
                }
                ++n5;
            }
            double[] dArray5 = new double[n2];
            for (n4 = 0; n4 < n2; ++n4) {
                double d15 = 0.0;
                int n6 = 0;
                for (int i = Math.max(0, n4 - 3); i <= Math.min(n2 - 1, n4 + 3); ++i) {
                    d15 += dArray3[i];
                    ++n6;
                }
                dArray5[n4] = dArray3[n4] == 0.0 ? 0.0 : d15 / (double)n6;
            }
            for (n4 = 0; n4 < n2; ++n4) {
                int n7 = n4;
                dArray[n7] = dArray[n7] * dArray5[n4];
            }
        }
        ArrayList<double[]> arrayList2 = new ArrayList<double[]>(n2);
        for (n = 0; n < n2; ++n) {
            double[] dArray6 = n == 0 || n == n2 - 1 ? (double[])arrayList.get(n) : Route.psq(arrayList, n, dArray[n]);
            arrayList2.add(dArray6 == null ? (double[])arrayList.get(n) : dArray6);
        }
        n = 1;
        for (int i = 1; i < n2 && n != 0; ++i) {
            if (dArray[i] == 0.0 && dArray[i - 1] == 0.0) continue;
            n = prw2.clear((double[])arrayList2.get(i - 1), (double[])arrayList2.get(i), 0.32) ? 1 : 0;
        }
        ArrayList<double[]> arrayList3 = n != 0 ? arrayList2 : arrayList;
        for (double[] dArray7 : arrayList3) {
            byte by = StandCheck.water(prw2.world, dArray7[0], dArray7[1], dArray7[2]) ? (byte)4 : 0;
            prw2.add(dArray7[0], dArray7[1], dArray7[2], by);
        }
    }

    private static double[] psq(List<double[]> list, int n, double d) {
        double d2;
        if (d == 0.0) {
            return list.get(n);
        }
        double[] dArray = list.get(Math.max(0, n - 1));
        double[] dArray2 = list.get(Math.min(list.size() - 1, n + 1));
        double d3 = dArray2[0] - dArray[0];
        double d4 = Math.hypot(d3, d2 = dArray2[2] - dArray[2]);
        if (d4 < 1.0E-4) {
            return null;
        }
        double d5 = -d2 / d4;
        double d6 = d3 / d4;
        double[] dArray3 = list.get(n);
        return new double[]{dArray3[0] + d5 * d, dArray3[1], dArray3[2] + d6 * d};
    }

    private static void psr(prw prw2, double[] dArray, double[] dArray2, byte by) {
        double d = dArray2[0] - dArray[0];
        double d2 = dArray2[2] - dArray[2];
        double d3 = Math.hypot(d, d2);
        int n = Math.max(2, (int)Math.ceil(d3 / 0.25));
        boolean bl = false;
        for (int i = 1; i <= n; ++i) {
            boolean bl2;
            double d4;
            double d5 = (double)i / (double)n;
            double d6 = dArray[0] + d * d5;
            double d7 = dArray[2] + d2 * d5;
            if (by == 1) {
                var21_15 = StandCheck.standAt(prw2.world, d6, dArray2[1], d7, 0.4);
                d4 = !Double.isNaN(var21_15) && var21_15 > dArray[1] + 0.6 ? var21_15 : dArray[1];
            } else {
                var21_15 = StandCheck.standAt(prw2.world, d6, dArray[1], d7, 0.4);
                double d8 = d4 = !Double.isNaN(var21_15) ? var21_15 : dArray2[1];
            }
            if (i == n) {
                d4 = dArray2[1];
            }
            byte by2 = 0;
            boolean bl3 = by == 1 ? d4 > dArray[1] + 0.6 : (bl2 = d4 < dArray[1] - 0.6);
            if (bl2) {
                by2 = by;
                bl = true;
            } else if (!bl && i == n) {
                by2 = by;
            }
            prw2.add(d6, d4, d7, by2);
        }
    }

    private static Route pss(prw prw2, List<class_2338> list, class_2338 class_23382, boolean bl) {
        int n = prw2.xs.size();
        if (n < 2) {
            return null;
        }
        float[] fArray = new float[n];
        float[] fArray2 = new float[n];
        float[] fArray3 = new float[n];
        byte[] byArray = new byte[n];
        for (int i = 0; i < n; ++i) {
            fArray[i] = (float)prw2.xs.get(i).doubleValue();
            fArray2[i] = (float)prw2.ys.get(i).doubleValue();
            fArray3[i] = (float)prw2.zs.get(i).doubleValue();
            byArray[i] = prw2.fs.get(i);
        }
        PathProjection tvt2 = new PathProjection(fArray, fArray2, fArray3, byArray);
        int[] nArray = new int[n];
        if (!list.isEmpty()) {
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                while (n2 + 1 < list.size() && Route.pst(list.get(n2 + 1), fArray[i], fArray3[i]) <= Route.pst(list.get(n2), fArray[i], fArray3[i])) {
                    ++n2;
                }
                nArray[i] = n2;
            }
        }
        return new Route(list, tvt2, nArray, class_23382, bl);
    }

    private static double pst(class_2338 class_23382, double d, double d2) {
        double d3 = (double)class_23382.method_10263() + 0.5 - d;
        double d4 = (double)class_23382.method_10260() + 0.5 - d2;
        return d3 * d3 + d4 * d4;
    }

    private static /* synthetic */ int bny(int n, int n2) {
        return n - n2 + -1646413677;
    }

    private static /* synthetic */ int bnz(int n, int n2) {
        return n + n2 | 0x15D535F9;
    }
}

