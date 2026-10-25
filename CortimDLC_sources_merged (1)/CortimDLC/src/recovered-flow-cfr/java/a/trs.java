/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tbx;
import a.tmt;
import a.tmw;
import a.trj;
import a.trm;
import a.trp;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class trs {
    private static final int trt = 128;
    private static final double tru = 0.002;
    private static final double trv = 2.0E-4;
    private static final double trw = 1.0E-4;
    private static final double trx = 5.0;
    private static /* synthetic */ String try;
    private static /* synthetic */ int trz;

    private trs() {
    }

    public static trm train(trp trp2, int n2, long l, tmw tmw2) {
        Random random = new Random(l);
        int n3 = trp2.n;
        boolean[] blArray = new boolean[n3];
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < n3; ++i) {
            blArray[i] = hashMap.computeIfAbsent(trp2.block[i], n -> random.nextDouble() < 0.15);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (int i = 0; i < n3; ++i) {
            (blArray[i] ? arrayList2 : arrayList).add(i);
        }
        if (arrayList2.size() < 50 || arrayList.size() < 200) {
            arrayList2 = arrayList;
        }
        tbx tbx2 = new tbx(71, 48, 48, 11);
        trj trj2 = new trj(tbx2);
        boolean[] blArray2 = trs.tsd(trp2, arrayList, trj2);
        tbx2.init(random, new double[11]);
        for (int i = 0; i < 71; ++i) {
            if (!blArray2[i]) continue;
            for (int j = 0; j < tbx2.h1; ++j) {
                tbx2.p[j * 71 + i] = 0.0;
            }
        }
        double[] dArray = new double[tbx2.size()];
        double[] dArray2 = new double[tbx2.size()];
        double[] dArray3 = new double[tbx2.size()];
        double[] dArray4 = (double[])tbx2.p.clone();
        double d = Double.POSITIVE_INFINITY;
        int n4 = 0;
        int n5 = 0;
        int[] nArray = arrayList.stream().mapToInt(Integer::intValue).toArray();
        int n6 = n2 * Math.max(1, (nArray.length + 128 - 1) / 128);
        double[] dArray5 = new double[71];
        double[] dArray6 = new double[71];
        double[] dArray7 = new double[71];
        double[] dArray8 = new double[tbx2.h1];
        double[] dArray9 = new double[tbx2.h2];
        double[] dArray10 = new double[11];
        double[] dArray11 = new double[11];
        double[] dArray12 = new double[tbx2.h1];
        double[] dArray13 = new double[tbx2.h2];
        ArrayList<Float> arrayList3 = new ArrayList<Float>();
        tmw2.epochs = n2;
        for (int i = 0; i < n2; ++i) {
            if (tmw2.cancel) {
                throw new tmt(a.c(-2081091724, "\u0f11\u76a2\ufc7e\u6202\ue9d3\u6f6b"));
            }
            tmw2.phase = a.c(-2034429023, "\u13c9\u6a71\ue0a0\u7ec5");
            tmw2.epoch = i;
            trs.tsf(nArray, random);
            for (int j = 0; j < nArray.length; j += 128) {
                double d2;
                int n7;
                Arrays.fill(dArray, 0.0);
                int n8 = Math.min(nArray.length, j + 128);
                double d3 = 0.0;
                for (int k = j; k < n8; ++k) {
                    int n9 = nArray[k];
                    n7 = random.nextBoolean();
                    trs.tsa(trp2, n9, dArray5);
                    int n10 = trp2.move[n9];
                    if (n7 != 0) {
                        trj.mirror(dArray5, 0, dArray6, 0);
                        System.arraycopy(dArray6, 0, dArray5, 0, 71);
                        n10 = trj.MIRROR[n10];
                    }
                    trj2.normalize(dArray5, 0, dArray7);
                    tbx2.forward(dArray7, dArray8, dArray9, dArray10);
                    d2 = trp2.weight[n9];
                    d3 += d2;
                    trs.tsb(dArray10, n10, trp2.jump[n9], trp2.sprint[n9], d2, dArray11);
                    tbx2.backward(dArray7, dArray8, dArray9, dArray11, dArray, null, dArray12, dArray13);
                }
                if (d3 <= 0.0) continue;
                double d4 = 0.0;
                for (n7 = 0; n7 < dArray.length; ++n7) {
                    int n11 = n7;
                    dArray[n11] = dArray[n11] / d3;
                    d4 += dArray[n7] * dArray[n7];
                }
                if ((d4 = Math.sqrt(d4)) > 5.0) {
                    n7 = 0;
                    while (n7 < dArray.length) {
                        int n12 = n7++;
                        dArray[n12] = dArray[n12] * (5.0 / d4);
                    }
                }
                double d5 = Math.min(1.0, (double)(++n5) / 100.0);
                d2 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)n5 / (double)n6)));
                trs.tse(tbx2.p, dArray, dArray2, dArray3, n5, (2.0E-4 + 0.0018 * d2) * d5);
            }
            double d6 = trs.tsc(trp2, arrayList2, trj2, null);
            arrayList3.add(Float.valueOf((float)d6));
            tmw2.curve = trs.tsg(arrayList3);
            if (d6 < d - 1.0E-4) {
                d = d6;
                System.arraycopy(tbx2.p, 0, dArray4, 0, dArray4.length);
                n4 = 0;
                continue;
            }
            if (i >= 6 && ++n4 >= 5) break;
        }
        System.arraycopy(dArray4, 0, tbx2.p, 0, dArray4.length);
        trm trm2 = new trm();
        trm2.legs = trj2;
        double[] dArray14 = new double[4];
        trs.tsc(trp2, arrayList2, trj2, dArray14);
        trm2.accuracy = dArray14[0];
        trm2.baseline = dArray14[1];
        trm2.jumpAcc = dArray14[2];
        trm2.sprintAcc = dArray14[3];
        trm2.samples = n3;
        return trm2;
    }

    private static void tsa(trp trp2, int n, double[] dArray) {
        for (int i = 0; i < 71; ++i) {
            dArray[i] = trp2.x[n * 71 + i];
        }
    }

    private static void tsb(double[] dArray, int n, boolean bl, boolean bl2, double d, double[] dArray2) {
        int n2;
        double d2 = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 9; ++i) {
            d2 = Math.max(d2, dArray[i]);
        }
        double d3 = 0.0;
        for (n2 = 0; n2 < 9; ++n2) {
            d3 += Math.exp(dArray[n2] - d2);
        }
        for (n2 = 0; n2 < 9; ++n2) {
            dArray2[n2] = d * (Math.exp(dArray[n2] - d2) / d3 - (n2 == n ? 1.0 : 0.0));
        }
        double d4 = 1.0 / (1.0 + Math.exp(-dArray[9]));
        double d5 = 1.0 / (1.0 + Math.exp(-dArray[10]));
        dArray2[9] = 0.5 * d * (d4 - (bl ? 1.0 : 0.0));
        dArray2[10] = 0.5 * d * (d5 - (bl2 ? 1.0 : 0.0));
    }

    private static double tsc(trp trp2, List<Integer> list, trj trj2, double[] dArray) {
        tbx tbx2 = trj2.net;
        double[] dArray2 = new double[71];
        double[] dArray3 = new double[71];
        double[] dArray4 = new double[tbx2.h1];
        double[] dArray5 = new double[tbx2.h2];
        double[] dArray6 = new double[11];
        double d = 0.0;
        double d2 = 0.0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int[] nArray = new int[9];
        for (int n4 : list) {
            int n5;
            trs.tsa(trp2, n4, dArray2);
            trj2.normalize(dArray2, 0, dArray3);
            tbx2.forward(dArray3, dArray4, dArray5, dArray6);
            double d3 = Double.NEGATIVE_INFINITY;
            int n6 = 0;
            for (int i = 0; i < 9; ++i) {
                if (!(dArray6[i] > d3)) continue;
                d3 = dArray6[i];
                n6 = i;
            }
            double d4 = 0.0;
            for (n5 = 0; n5 < 9; ++n5) {
                d4 += Math.exp(dArray6[n5] - d3);
            }
            n5 = trp2.move[n4];
            double d5 = trp2.weight[n4];
            d += d5 * -(dArray6[n5] - d3 - Math.log(d4));
            d2 += d5;
            if (n6 == n5) {
                ++n;
            }
            int n7 = n5;
            nArray[n7] = nArray[n7] + 1;
            if (dArray6[9] > 0.0 == trp2.jump[n4]) {
                ++n2;
            }
            if (dArray6[10] > 0.0 != trp2.sprint[n4]) continue;
            ++n3;
        }
        if (dArray != null) {
            int n4;
            int n8 = Math.max(1, list.size());
            n4 = 0;
            for (int n9 : nArray) {
                n4 = Math.max(n4, n9);
            }
            dArray[0] = 100.0 * (double)n / (double)n8;
            dArray[1] = 100.0 * (double)n4 / (double)n8;
            dArray[2] = 100.0 * (double)n2 / (double)n8;
            dArray[3] = 100.0 * (double)n3 / (double)n8;
        }
        return d2 <= 0.0 ? Double.NaN : d / d2;
    }

    private static boolean[] tsd(trp trp2, List<Integer> list, trj trj2) {
        double d;
        int n;
        int n2 = 71;
        double[] dArray = new double[n2];
        double[] dArray2 = new double[n2];
        for (int n3 : list) {
            n = 0;
            while (n < n2) {
                d = trp2.x[n3 * n2 + n];
                int n4 = n;
                dArray[n4] = dArray[n4] + d;
                int n5 = n++;
                dArray2[n5] = dArray2[n5] + d * d;
            }
        }
        int n6 = Math.max(1, list.size());
        boolean[] blArray = new boolean[n2];
        for (n = 0; n < n2; ++n) {
            d = dArray[n] / (double)n6;
            double d2 = dArray2[n] / (double)n6 - d * d;
            blArray[n] = d2 < 1.0E-6;
            trj2.mu[n] = d;
            trj2.sd[n] = blArray[n] ? 1.0 : Math.sqrt(Math.max(d2, 1.0E-4));
        }
        return blArray;
    }

    private static void tse(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, int n, double d) {
        double d2 = 0.9;
        double d3 = 0.999;
        double d4 = 1.0 - Math.pow(d2, n);
        double d5 = 1.0 - Math.pow(d3, n);
        for (int i = 0; i < dArray.length; ++i) {
            dArray3[i] = d2 * dArray3[i] + (1.0 - d2) * dArray2[i];
            dArray4[i] = d3 * dArray4[i] + (1.0 - d3) * dArray2[i] * dArray2[i];
            int n2 = i;
            dArray[n2] = dArray[n2] - d * (dArray3[i] / d4 / (Math.sqrt(dArray4[i] / d5) + 1.0E-8) + 1.0E-4 * dArray[i]);
        }
    }

    private static void tsf(int[] nArray, Random random) {
        for (int i = nArray.length - 1; i > 0; --i) {
            int n = random.nextInt(i + 1);
            int n2 = nArray[i];
            nArray[i] = nArray[n];
            nArray[n] = n2;
        }
    }

    private static float[] tsg(List<Float> list) {
        float[] fArray = new float[list.size()];
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = list.get(i).floatValue();
        }
        return fArray;
    }

    private static /* synthetic */ int cpx(int n, int n2) {
        return n + n2 | 0x686A413A;
    }
}

