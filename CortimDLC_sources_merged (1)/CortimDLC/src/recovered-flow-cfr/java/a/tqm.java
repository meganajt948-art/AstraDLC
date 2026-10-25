/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tmt;
import a.tmw;
import a.tqa;
import a.tqg;
import a.tqj;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class tqm {
    private static final int tqn = 32;
    private static final double tqo = 0.003;
    private static final double tqp = 3.0E-4;
    private static final double tqq = 1.0E-4;
    private static final double tqr = 5.0;
    private static /* synthetic */ String tqs;
    private static /* synthetic */ boolean tqt;

    private tqm() {
    }

    public static tqj train(List<tqg> list, int n, int n2, long l, tmw tmw2) {
        int n3;
        Random random = new Random(l);
        ArrayList<tqg> arrayList = new ArrayList<tqg>(list);
        Collections.shuffle(arrayList, random);
        int n4 = arrayList.size() >= 60 ? Math.max(12, arrayList.size() * 15 / 100) : 0;
        ArrayList<tqg> arrayList2 = new ArrayList<tqg>(arrayList.subList(0, n4));
        ArrayList<tqg> arrayList3 = new ArrayList<tqg>(arrayList.subList(n4, arrayList.size()));
        if (arrayList2.isEmpty()) {
            arrayList2 = arrayList3;
        }
        tqa tqa2 = new tqa(32, n);
        boolean[] blArray = tqm.tqu(arrayList3, tqa2);
        tqa2.init(random);
        for (int i = 0; i < blArray.length; ++i) {
            if (!blArray[i]) continue;
            tqa2.silence(i);
        }
        List<double[]> list2 = tqm.tqv(arrayList3, tqa2);
        List<double[]> list3 = tqm.tqv(arrayList2, tqa2);
        double[] dArray = new double[tqa2.p.length];
        double[] dArray2 = new double[tqa2.p.length];
        double[] dArray3 = new double[tqa2.p.length];
        tqa tqa3 = tqa2.copy();
        double d = Double.POSITIVE_INFINITY;
        int n5 = 0;
        int n6 = 0;
        int n7 = Math.max(1, (arrayList3.size() + 32 - 1) / 32);
        int n8 = n2 * n7;
        ArrayList<Float> arrayList4 = new ArrayList<Float>();
        int[] nArray = new int[arrayList3.size()];
        for (n3 = 0; n3 < nArray.length; ++n3) {
            nArray[n3] = n3;
        }
        n3 = 0;
        tmw2.epochs = n2;
        for (int i = 0; i < n2; ++i) {
            if (tmw2.cancel) {
                throw new tmt(a.b("\ua17c\ud8cf\u5213\ucc6f\u47be\uc106", 1348706585));
            }
            tmw2.phase = a.b("\u50fe\u295f\ua39f\u3de6\ub636", -105688935);
            tmw2.epoch = i;
            tqm.tqy(nArray, random);
            for (int j = 0; j < nArray.length; j += 32) {
                int n9;
                Arrays.fill(dArray, 0.0);
                int n10 = Math.min(nArray.length, j + 32);
                double d2 = 0.0;
                for (int k = j; k < n10; ++k) {
                    tqg tqg2 = (tqg)arrayList3.get(nArray[k]);
                    tqm.tqw(tqa2, tqg2, list2.get(nArray[k]), dArray);
                    d2 += tqg2.weight;
                }
                if (d2 <= 0.0) continue;
                double d3 = 0.0;
                for (n9 = 0; n9 < dArray.length; ++n9) {
                    int n11 = n9;
                    dArray[n11] = dArray[n11] / d2;
                    d3 += dArray[n9] * dArray[n9];
                }
                if ((d3 = Math.sqrt(d3)) > 5.0) {
                    n9 = 0;
                    while (n9 < dArray.length) {
                        int n12 = n9++;
                        dArray[n12] = dArray[n12] * (5.0 / d3);
                    }
                }
                double d4 = Math.min(1.0, (double)(++n6) / 50.0);
                double d5 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)n6 / (double)n8)));
                tqm.tqx(tqa2.p, dArray, dArray2, dArray3, n6, (3.0E-4 + 0.0027 * d5) * d4);
            }
            double d6 = tqm.evaluate(tqa2, arrayList2, list3, null);
            arrayList4.add(Float.valueOf((float)d6));
            tmw2.curve = tqm.tqz(arrayList4);
            n3 = i + 1;
            if (d6 < d - 1.0E-4) {
                d = d6;
                tqa3 = tqa2.copy();
                n5 = 0;
                continue;
            }
            if (i >= 10 && ++n5 >= 8) break;
        }
        tqj tqj2 = new tqj();
        tqj2.net = tqa3;
        double[] dArray4 = new double[4];
        tqj2.nll = tqm.evaluate(tqa3, arrayList2, list3, dArray4);
        tqj2.top1 = dArray4[0];
        tqj2.top3 = dArray4[1];
        tqj2.base1 = dArray4[2];
        tqj2.trainEvents = arrayList3.size();
        tqj2.valEvents = n4;
        tqj2.epochs = n3;
        return tqj2;
    }

    private static boolean[] tqu(List<tqg> list, tqa tqa2) {
        double d;
        int n = 32;
        double[] dArray = new double[n];
        double[] dArray2 = new double[n];
        long l = 0L;
        for (tqg tqg2 : list) {
            for (int i = 0; i < tqg2.n; ++i) {
                int n2 = 0;
                while (n2 < n) {
                    d = tqg2.f[i * n + n2];
                    int n3 = n2;
                    dArray[n3] = dArray[n3] + d;
                    int n4 = n2++;
                    dArray2[n4] = dArray2[n4] + d * d;
                }
                ++l;
            }
        }
        Object object = new boolean[n];
        for (int i = 0; i < n; ++i) {
            double d2 = l == 0L ? 0.0 : dArray[i] / (double)l;
            d = l == 0L ? 0.0 : dArray2[i] / (double)l - d2 * d2;
            tqa2.mu[i] = d2;
            object[i] = d < 1.0E-6;
            tqa2.sd[i] = object[i] != false ? 1.0 : Math.sqrt(Math.max(d, 1.0E-4));
        }
        return object;
    }

    private static List<double[]> tqv(List<tqg> list, tqa tqa2) {
        ArrayList<double[]> arrayList = new ArrayList<double[]>(list.size());
        for (tqg tqg2 : list) {
            double[] dArray = new double[tqg2.n * 32];
            for (int i = 0; i < tqg2.n; ++i) {
                tqa2.normalize(tqg2.f, i * 32, dArray, i * 32);
            }
            arrayList.add(dArray);
        }
        return arrayList;
    }

    private static void tqw(tqa tqa2, tqg tqg2, double[] dArray, double[] dArray2) {
        int n;
        int n2 = tqg2.n;
        double[][] dArray3 = new double[n2][tqa2.hidden];
        double[] dArray4 = new double[n2];
        double d = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < n2; ++i) {
            dArray4[i] = tqa2.forward(dArray, i * 32, dArray3[i]);
            d = Math.max(d, dArray4[i]);
        }
        double d2 = 0.0;
        for (n = 0; n < n2; ++n) {
            dArray4[n] = Math.exp(dArray4[n] - d);
            d2 += dArray4[n];
        }
        for (n = 0; n < n2; ++n) {
            double d3 = tqg2.weight * (dArray4[n] / d2 - (n == tqg2.chosen ? 1.0 : 0.0));
            if (!(Math.abs(d3) > 1.0E-7)) continue;
            tqa2.backward(dArray, n * 32, dArray3[n], d3, dArray2);
        }
    }

    static double evaluate(tqa tqa2, List<tqg> list, List<double[]> list2, double[] dArray) {
        int n;
        double d = 0.0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        double[] dArray2 = new double[tqa2.hidden];
        for (n = 0; n < list.size(); ++n) {
            int n5;
            tqg tqg2 = list.get(n);
            double[] dArray3 = list2.get(n);
            double[] dArray4 = new double[tqg2.n];
            double d2 = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < tqg2.n; ++i) {
                dArray4[i] = tqa2.forward(dArray3, i * 32, dArray2);
                d2 = Math.max(d2, dArray4[i]);
            }
            double d3 = 0.0;
            for (n5 = 0; n5 < tqg2.n; ++n5) {
                d3 += Math.exp(dArray4[n5] - d2);
            }
            d += -(dArray4[tqg2.chosen] - d2 - Math.log(d3));
            n5 = 0;
            for (int i = 0; i < tqg2.n; ++i) {
                if (i == tqg2.chosen || !(dArray4[i] > dArray4[tqg2.chosen])) continue;
                ++n5;
            }
            if (n5 == 0) {
                ++n2;
            }
            if (n5 < 3) {
                ++n3;
            }
            if (tqg2.nearest != tqg2.chosen) continue;
            ++n4;
        }
        n = Math.max(1, list.size());
        if (dArray != null) {
            dArray[0] = 100.0 * (double)n2 / (double)n;
            dArray[1] = 100.0 * (double)n3 / (double)n;
            dArray[2] = 100.0 * (double)n4 / (double)n;
        }
        return d / (double)n;
    }

    private static void tqx(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, int n, double d) {
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

    private static void tqy(int[] nArray, Random random) {
        for (int i = nArray.length - 1; i > 0; --i) {
            int n = random.nextInt(i + 1);
            int n2 = nArray[i];
            nArray[i] = nArray[n];
            nArray[n] = n2;
        }
    }

    private static float[] tqz(List<Float> list) {
        float[] fArray = new float[list.size()];
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = list.get(i).floatValue();
        }
        return fArray;
    }

    private static /* synthetic */ int cot(int n, int n2) {
        return n + n2 | 0xE4FFFBCE;
    }

    private static /* synthetic */ int cou(int n, int n2) {
        return tqm.cot(n, n2) * n2;
    }

    private static /* synthetic */ int cov(int n, int n2) {
        return n - n2 + 357561513;
    }
}

