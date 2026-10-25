/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.szk;
import a.taf;
import a.tai;
import a.tck;
import a.tmn;
import a.tmz;
import a.tnl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class tbs {
    private static /* synthetic */ int tbt;
    private static /* synthetic */ int tbu;

    private tbs() {
    }

    static void score(tck tck2, List<tmn> list, Random random) {
        tbs.score(tck2, list, random, new taf());
    }

    static void score(tck tck2, List<tmn> list, Random random, taf taf2) {
        tai tai2 = new tai(tck2, random);
        int n = 32;
        double[] dArray = new double[n];
        double[] dArray2 = new double[2];
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        ArrayList<Double> arrayList3 = new ArrayList<Double>();
        ArrayList<Double> arrayList4 = new ArrayList<Double>();
        ArrayList<Double> arrayList5 = new ArrayList<Double>();
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (tmn tmn2 : list) {
            double[] dArray3 = tmn2.seg().st;
            int n5 = tmn2.from();
            int n6 = tmn2.to();
            int n7 = n6 - n5;
            double[] dArray4 = new double[(n7 + 1) * n];
            System.arraycopy(dArray3, n5 * n, dArray4, 0, dArray4.length);
            tai2.reset();
            for (int i = 3; i >= 0; --i) {
                tai2.history(dArray3[n5 * n + 14 + i * 2], dArray3[n5 * n + 15 + i * 2]);
            }
            tai2.prime(dArray3[n5 * n + 14], dArray3[n5 * n + 15]);
            tmz tmz2 = new tmz(n7);
            tmz2.ex[0] = dArray3[n5 * n + 0];
            tmz2.ey[0] = dArray3[n5 * n + 1];
            double d4 = 0.0;
            double d5 = 0.0;
            int n8 = n7 + 1;
            int n9 = n7 + 1;
            for (int i = 0; i < n7; ++i) {
                int n10 = n5 + i;
                tmz2.state(tmn2.seg(), n5, i, dArray);
                tai2.step(dArray, taf2, dArray2);
                tai2.history(dArray2[0], dArray2[1]);
                int n11 = (n10 + 1) * n;
                double d6 = tmz2.ex[i] + dArray3[n11 + 6] - dArray2[0];
                double d7 = tmz2.ey[i] + dArray3[n11 + 7] - dArray2[1];
                tmz2.ex[i + 1] = d6;
                tmz2.ey[i + 1] = d7;
                int n12 = (i + 1) * n;
                dArray4[n12 + 0] = d6;
                dArray4[n12 + 1] = d7;
                dArray4[n12 + 14] = dArray2[0];
                dArray4[n12 + 15] = dArray2[1];
                double d8 = Math.hypot(dArray2[0], dArray2[1]);
                double d9 = Math.hypot(dArray3[n11 + 14], dArray3[n11 + 15]);
                d4 = Math.max(d4, d8);
                d5 = Math.max(d5, d9);
                arrayList5.add(d8);
                arrayList4.add(d9);
                if (n8 > n7 && tbs.tbv(dArray4, n12, d6, d7)) {
                    n8 = i + 1;
                }
                if (n9 <= n7 || !tbs.tbv(dArray3, n11, dArray3[n11 + 0], dArray3[n11 + 1])) continue;
                n9 = i + 1;
            }
            if (szk.overshootCount(dArray4, n7) > 0) {
                ++n2;
            }
            double[] dArray5 = new double[(n7 + 1) * n];
            System.arraycopy(dArray3, n5 * n, dArray5, 0, dArray5.length);
            if (szk.overshootCount(dArray5, n7) > 0) {
                ++n3;
            }
            if (d5 > 0.5) {
                arrayList.add(Math.max(0.001, d4) / d5);
            }
            arrayList2.add(d5);
            arrayList3.add(d4);
            d += (double)Math.abs(n8 - n9);
            d2 += (double)n9;
            d3 += (double)n8;
            ++n4;
        }
        if (n4 == 0) {
            return;
        }
        double d10 = arrayList.isEmpty() ? 1.0 : tnl.quantile(arrayList, 0.5);
        tck2.speedMatch = Math.exp(-2.5 * Math.abs(Math.log(d10)));
        tck2.timeMatch = Math.exp(-(d / (double)n4) / 4.0);
        tck2.shapeMatch = 1.0 - tbs.tbw(arrayList4, arrayList5);
        tck2.similarity = 100.0 * (0.35 * tck2.speedMatch + 0.35 * tck2.timeMatch + 0.3 * tck2.shapeMatch);
        tck2.overshootModel = (double)n2 / (double)n4;
        tck2.overshootUser = (double)n3 / (double)n4;
        tck2.userPeak = tnl.quantile(arrayList2, 0.5);
        tck2.modelPeak = tnl.quantile(arrayList3, 0.5);
        tck2.userEntry = d2 / (double)n4;
        tck2.modelEntry = d3 / (double)n4;
    }

    private static boolean tbv(double[] dArray, int n, double d, double d2) {
        double d3 = -d;
        double d4 = -d2;
        return d3 >= dArray[n + 28] && d3 <= dArray[n + 29] && d4 >= dArray[n + 30] && d4 <= dArray[n + 31];
    }

    private static double tbw(List<Double> list, List<Double> list2) {
        int n;
        if (list.isEmpty() || list2.isEmpty()) {
            return 1.0;
        }
        double[] dArray = new double[list.size()];
        double[] dArray2 = new double[list2.size()];
        for (n = 0; n < dArray.length; ++n) {
            dArray[n] = list.get(n);
        }
        for (n = 0; n < dArray2.length; ++n) {
            dArray2[n] = list2.get(n);
        }
        Arrays.sort(dArray);
        Arrays.sort(dArray2);
        n = 0;
        int n2 = 0;
        double d = 0.0;
        while (n < dArray.length && n2 < dArray2.length) {
            double d2 = Math.min(dArray[n], dArray2[n2]);
            while (n < dArray.length && dArray[n] <= d2) {
                ++n;
            }
            while (n2 < dArray2.length && dArray2[n2] <= d2) {
                ++n2;
            }
            d = Math.max(d, Math.abs((double)n / (double)dArray.length - (double)n2 / (double)dArray2.length));
        }
        return d;
    }

    private static /* synthetic */ int cjz(int n, int n2) {
        return n + n2 | 0x6A375279;
    }
}

