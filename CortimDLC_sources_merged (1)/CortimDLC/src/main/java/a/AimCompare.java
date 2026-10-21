/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.syh;
import a.syk;
import a.syn;
import a.sze;
import a.AimTrace;
import a.taf;
import a.AimSimulator;
import a.AimModel;
import a.RecordingReader;
import a.tmn;
import a.tmz;
import a.NeuroWorker;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public final class AimCompare {
    public static final int SPEED = 0;
    public static final int ACCEL = 1;
    public static final int JERK = 2;
    public static final int ERROR = 3;
    public static final int SMOOTH = 4;
    public static final int OVERSHOOT = 5;
    public static final int PARTS = 6;
    public static final double STEP_CAP = 30.0;
    public static final int SIM_X = 0;
    public static final int SIM_Y = 1;
    public static final int CEIL_X = 2;
    public static final int CEIL_Y = 3;
    public static final int PARTS_X = 4;
    public static final int PARTS_Y = 10;
    public static final int OVER_USER_X = 16;
    public static final int OVER_MODEL_X = 17;
    public static final int OVER_USER_Y = 18;
    public static final int OVER_MODEL_Y = 19;
    public static final int REACTION = 20;
    public static final int PACKED = 21;
    private static /* synthetic */ long syr;
    private static /* synthetic */ long sys;

    static float[] pack(syk syk2, syk syk3, double d) {
        float[] fArray = new float[21];
        fArray[16] = (float)syk2.overA[0];
        fArray[17] = (float)syk2.overB[0];
        fArray[18] = (float)syk2.overA[1];
        fArray[19] = (float)syk2.overB[1];
        fArray[20] = (float)d;
        fArray[0] = (float)syk2.simX;
        fArray[1] = (float)syk2.simY;
        fArray[2] = syk3 == null ? Float.NaN : (float)syk3.simX;
        fArray[3] = syk3 == null ? Float.NaN : (float)syk3.simY;
        for (int i = 0; i < 6; ++i) {
            fArray[4 + i] = (float)(syk2.x[i] * 100.0);
            fArray[10 + i] = (float)(syk2.y[i] * 100.0);
        }
        return fArray;
    }

    private AimCompare() {
    }

    static syn user(List<tmn> list) {
        syn syn2 = new syn();
        syn2.episodes = list;
        int n = 32;
        for (tmn tmn2 : list) {
            double[] dArray = tmn2.seg().st;
            int n2 = tmn2.to() - tmn2.from();
            double[] dArray2 = new double[n2];
            double[] dArray3 = new double[n2];
            double[] dArray4 = new double[n2];
            double[] dArray5 = new double[n2];
            for (int i = 0; i < n2; ++i) {
                int n3 = (tmn2.from() + i + 1) * n;
                dArray2[i] = dArray[n3 + 14];
                dArray3[i] = dArray[n3 + 15];
                dArray4[i] = dArray[n3 + 0];
                dArray5[i] = dArray[n3 + 1];
            }
            syn2.dx.add(dArray2);
            syn2.dy.add(dArray3);
            syn2.ex.add(dArray4);
            syn2.ey.add(dArray5);
        }
        return syn2;
    }

    static syn model(AimModel tck2, List<tmn> list, Random random, taf taf2) {
        syn syn2 = new syn();
        syn2.episodes = list;
        double d = tck2.turnCap > 0.0f ? (double)tck2.turnCap : 30.0;
        AimSimulator tai2 = new AimSimulator(tck2, random);
        int n = 32;
        double[] dArray = new double[n];
        double[] dArray2 = new double[2];
        for (tmn tmn2 : list) {
            double[] dArray3 = tmn2.seg().st;
            int n2 = tmn2.from();
            int n3 = tmn2.to() - n2;
            double d2 = tmn2.seg().unit > 0.0 ? tmn2.seg().unit : (tck2.unit > 0.0f ? (double)tck2.unit : 0.0);
            tai2.reset();
            for (int i = 3; i >= 0; --i) {
                tai2.history(dArray3[n2 * n + 14 + i * 2], dArray3[n2 * n + 15 + i * 2]);
            }
            tai2.prime(dArray3[n2 * n + 14], dArray3[n2 * n + 15]);
            tmz tmz2 = new tmz(n3);
            tmz2.ex[0] = dArray3[n2 * n + 0];
            tmz2.ey[0] = dArray3[n2 * n + 1];
            double d3 = 0.0;
            double d4 = 0.0;
            double[] dArray4 = new double[n3];
            double[] dArray5 = new double[n3];
            double[] dArray6 = new double[n3];
            double[] dArray7 = new double[n3];
            for (int i = 0; i < n3; ++i) {
                int n4 = n2 + i;
                tmz2.state(tmn2.seg(), n2, i, dArray);
                tai2.step(dArray, taf2, dArray2);
                double d5 = dArray2[0];
                double d6 = dArray2[1];
                double d7 = Math.hypot(d5, d6);
                if (d7 > d) {
                    d5 *= d / d7;
                    d6 *= d / d7;
                }
                if (d2 > 0.0) {
                    long l = (long)(d3 += d5 / d2);
                    long l2 = (long)(d4 += d6 / d2);
                    d3 -= (double)l;
                    d4 -= (double)l2;
                    d5 = (double)l * d2;
                    d6 = (double)l2 * d2;
                }
                tai2.history(d5, d6);
                int n5 = (n4 + 1) * n;
                tmz2.ex[i + 1] = tmz2.ex[i] + dArray3[n5 + 6] - d5;
                tmz2.ey[i + 1] = tmz2.ey[i] + dArray3[n5 + 7] - d6;
                dArray4[i] = d5;
                dArray5[i] = d6;
                dArray6[i] = tmz2.ex[i + 1];
                dArray7[i] = tmz2.ey[i + 1];
            }
            syn2.dx.add(dArray4);
            syn2.dy.add(dArray5);
            syn2.ex.add(dArray6);
            syn2.ey.add(dArray7);
        }
        return syn2;
    }

    static syk compare(syn syn2, syn syn3) {
        syk syk2 = new syk();
        AimCompare.syt(syn2.dx, syn2.ex, syn3.dx, syn3.ex, syk2.x);
        AimCompare.syt(syn2.dy, syn2.ey, syn3.dy, syn3.ey, syk2.y);
        for (int i = 0; i < 2; ++i) {
            syh syh2 = AimCompare.overshoots(syn2, syn2.episodes, i == 1);
            syh syh3 = AimCompare.overshoots(syn3, syn3.episodes, i == 1);
            (i == 0 ? syk2.x : syk2.y)[5] = AimCompare.overshootMatch(syh2, syh3);
            syk2.overA[i] = syh2.rate();
            syk2.overB[i] = syh3.rate();
        }
        syk2.simX = AimCompare.syu(syk2.x) * 100.0;
        syk2.simY = AimCompare.syu(syk2.y) * 100.0;
        return syk2;
    }

    private static void syt(List<double[]> list, List<double[]> list2, List<double[]> list3, List<double[]> list4, double[] dArray) {
        dArray[0] = 1.0 - AimCompare.ks(AimCompare.diff(list, 0), AimCompare.diff(list3, 0));
        dArray[1] = 1.0 - AimCompare.ks(AimCompare.diff(list, 1), AimCompare.diff(list3, 1));
        dArray[2] = 1.0 - AimCompare.ks(AimCompare.diff(list, 2), AimCompare.diff(list3, 2));
        dArray[3] = 1.0 - AimCompare.ks(AimCompare.diff(list2, 0), AimCompare.diff(list4, 0));
        dArray[4] = 1.0 - Math.min(1.0, Math.abs(AimCompare.autocorr(list) - AimCompare.autocorr(list3)));
    }

    private static double syu(double[] dArray) {
        double d = 0.0;
        for (double d2 : dArray) {
            d += d2;
        }
        return d / (double)dArray.length;
    }

    static syh overshoots(syn syn2, List<tmn> list, boolean bl) {
        syh syh2 = new syh();
        int n = 32;
        int n2 = bl ? 30 : 28;
        int n3 = bl ? 31 : 29;
        int n4 = bl ? 23 : 22;
        int n5 = bl ? 7 : 6;
        double d = bl ? 0.15 : 0.25;
        for (int i = 0; i < list.size(); ++i) {
            tmn tmn2 = list.get(i);
            double[] dArray = tmn2.seg().st;
            double[] dArray2 = bl ? syn2.dy.get(i) : syn2.dx.get(i);
            double[] dArray3 = bl ? syn2.ey.get(i) : syn2.ex.get(i);
            int n6 = 0;
            double d2 = 0.0;
            double d3 = 0.0;
            int n7 = 0;
            double d4 = 0.0;
            for (int j = 0; j < dArray2.length; ++j) {
                int n8 = (tmn2.from() + j + 1) * n;
                double d5 = -dArray3[j];
                double d6 = d * dArray[n8 + n4];
                double d7 = d5 - dArray[n8 + n3];
                double d8 = dArray[n8 + n2] - d5;
                int n9 = d7 > d6 ? 1 : (d8 > d6 ? -1 : 0);
                d2 += dArray2[j];
                d3 += dArray[n8 + n5];
                if (n7 != 0) {
                    if (n9 == n7) {
                        d4 = Math.max(d4, n7 > 0 ? d7 : d8);
                    } else {
                        syh2.depth.add(d4);
                        n7 = 0;
                    }
                }
                if (n9 != 0) {
                    if (n6 != 0 && n9 != n6 && d2 * (double)n9 > 0.0 && d2 * (double)n9 > -d3 * (double)n9) {
                        ++syh2.events;
                        n7 = n9;
                        d4 = n9 > 0 ? d7 : d8;
                    }
                    n6 = n9;
                    d2 = 0.0;
                    d3 = 0.0;
                }
                ++syh2.ticks;
            }
            if (n7 == 0) continue;
            syh2.depth.add(d4);
        }
        return syh2;
    }

    static double overshootMatch(syh syh2, syh syh3) {
        double d;
        double d2 = syh2.rate();
        if (d2 + (d = syh3.rate()) < 1.0E-9) {
            return 1.0;
        }
        double d3 = 1.0 - Math.abs(d2 - d) / Math.max(1.0, Math.max(d2, d));
        if (syh2.depth.size() < 20 || syh3.depth.size() < 20) {
            return d3;
        }
        return 0.5 * d3 + 0.5 * (1.0 - AimCompare.ks(AimCompare.syv(syh2.depth), AimCompare.syv(syh3.depth)));
    }

    private static double[] syv(List<Double> list) {
        double[] dArray = new double[list.size()];
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = list.get(i);
        }
        return dArray;
    }

    public static double[] overshootRates(List<RecordingReader> list) {
        if (list.isEmpty()) {
            return new double[]{Double.NaN, Double.NaN};
        }
        List<tmn> list2 = NeuroWorker.windows(AimTrace.track(list, (boolean)false).segments);
        syn syn2 = AimCompare.user(list2);
        return new double[]{AimCompare.overshoots(syn2, list2, false).rate(), AimCompare.overshoots(syn2, list2, true).rate()};
    }

    public static double instantShare(List<RecordingReader> list) {
        List<Integer> list2 = AimTrace.track(list, (boolean)false).reactions;
        return list2.isEmpty() ? Double.NaN : (double)list2.stream().filter(n -> n == 0).count() / (double)list2.size();
    }

    public static double medianReaction(List<RecordingReader> list) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(AimTrace.track(list, (boolean)false).reactions);
        arrayList.removeIf(n -> n == 0);
        if (arrayList.isEmpty()) {
            return Double.NaN;
        }
        arrayList.sort(Integer::compare);
        return ((Integer)arrayList.get(arrayList.size() / 2)).intValue();
    }

    public static List<String> report(List<double[]> list, List<double[]> list2, List<RecordingReader> list3) {
        Object[] objectArray2;
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = 0;
        for (Object[] objectArray2 : list) {
            n += objectArray2.length;
        }
        arrayList.add(String.format(Locale.ROOT, "aura: %d runs, %d ticks | %s | %s", list.size(), n, AimCompare.syw("X", list), AimCompare.syw("Y", list2)));
        if (list3.isEmpty() || n == 0) {
            return arrayList;
        }
        syn syn2 = AimCompare.user(NeuroWorker.windows(AimTrace.track(list3, (boolean)false).segments));
        arrayList.add(String.format(Locale.ROOT, "you:  %d ticks | %s | %s", syn2.ticks(), AimCompare.syw("X", syn2.dx), AimCompare.syw("Y", syn2.dy)));
        objectArray2 = new String[]{"delta", "accel", "jerk"};
        for (int i = 0; i < 2; ++i) {
            List<double[]> list4 = i == 0 ? list : list2;
            List<double[]> list5 = i == 0 ? syn2.dx : syn2.dy;
            StringBuilder stringBuilder = new StringBuilder(i == 0 ? "similarity X:" : "similarity Y:");
            double d = 0.0;
            for (int j = 0; j < 3; ++j) {
                double d2 = 100.0 * (1.0 - AimCompare.ks(AimCompare.diff(list4, j), AimCompare.diff(list5, j)));
                d += d2;
                stringBuilder.append(String.format(Locale.ROOT, " %s %.0f", objectArray2[j], d2));
            }
            double d3 = 100.0 * (1.0 - Math.min(1.0, Math.abs(AimCompare.autocorr(list4) - AimCompare.autocorr(list5))));
            stringBuilder.append(String.format(Locale.ROOT, " smooth %.0f -> %.1f", d3, (d += d3) / 4.0));
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    public static double[] onTarget(List<RecordingReader> list) {
        if (list.isEmpty()) {
            return new double[]{0.0, 0.0};
        }
        int n = 32;
        int n2 = 0;
        int n3 = 0;
        for (sze sze2 : AimTrace.track(list, (boolean)false).segments) {
            for (int i = 1; i <= sze2.m; ++i) {
                int n4 = i * n;
                double d = -sze2.st[n4 + 0];
                double d2 = -sze2.st[n4 + 1];
                ++n2;
                if (!(d >= sze2.st[n4 + 28]) || !(d <= sze2.st[n4 + 29]) || !(d2 >= sze2.st[n4 + 30]) || !(d2 <= sze2.st[n4 + 31])) continue;
                ++n3;
            }
        }
        return new double[]{n2 == 0 ? 0.0 : (double)n3 / (double)n2, n2};
    }

    private static String syw(String string, List<double[]> list) {
        double[] dArray = AimCompare.diff(list, 0);
        double[] dArray2 = AimCompare.diff(list, 1);
        if (dArray.length == 0) {
            return string + " -";
        }
        Arrays.sort(dArray);
        Arrays.sort(dArray2);
        int n = 0;
        for (double d : dArray) {
            if (!(d < 0.001)) continue;
            ++n;
        }
        return String.format(Locale.ROOT, "%s |d| med %.2f p90 %.2f p99 %.2f, zero %.0f%%, |acc| med %.2f p90 %.2f", string, dArray[dArray.length / 2], dArray[(int)((double)dArray.length * 0.9)], dArray[(int)((double)dArray.length * 0.99)], 100.0 * (double)n / (double)dArray.length, dArray2.length == 0 ? 0.0 : dArray2[dArray2.length / 2], dArray2.length == 0 ? 0.0 : dArray2[(int)((double)dArray2.length * 0.9)]);
    }

    static double[] diff(List<double[]> list, int n) {
        int n2 = 0;
        for (double[] dArray : list) {
            n2 += Math.max(0, dArray.length - n);
        }
        Object object = new double[n2];
        int n3 = 0;
        for (double[] dArray : list) {
            for (int i = n; i < dArray.length; ++i) {
                double d = switch (n) {
                    case 0 -> dArray[i];
                    case 1 -> dArray[i] - dArray[i - 1];
                    default -> dArray[i] - 2.0 * dArray[i - 1] + dArray[i - 2];
                };
                object[n3++] = Math.abs(d);
            }
        }
        return object;
    }

    static double autocorr(List<double[]> list) {
        double d = 0.0;
        double d2 = 0.0;
        for (double[] dArray : list) {
            double d3 = 0.0;
            for (double d4 : dArray) {
                d3 += d4;
            }
            d3 /= (double)Math.max(1, dArray.length);
            for (int i = 0; i < dArray.length; ++i) {
                double d5 = dArray[i] - d3;
                d2 += d5 * d5;
                if (i <= 0) continue;
                d += d5 * (dArray[i - 1] - d3);
            }
        }
        return d2 > 0.0 ? d / d2 : 0.0;
    }

    static double ks(double[] dArray, double[] dArray2) {
        if (dArray.length == 0 || dArray2.length == 0) {
            return 1.0;
        }
        dArray = (double[])dArray.clone();
        dArray2 = (double[])dArray2.clone();
        Arrays.sort(dArray);
        Arrays.sort(dArray2);
        int n = 0;
        int n2 = 0;
        double d = 0.0;
        while (n < dArray.length && n2 < dArray2.length) {
            double d2 = Math.min(dArray[n], dArray2[n2]);
            while (n < dArray.length && dArray[n] <= d2 + 0.001) {
                ++n;
            }
            while (n2 < dArray2.length && dArray2[n2] <= d2 + 0.001) {
                ++n2;
            }
            d = Math.max(d, Math.abs((double)n / (double)dArray.length - (double)n2 / (double)dArray2.length));
        }
        return d;
    }

    private static /* synthetic */ int cih(int n, int n2) {
        return n - n2 | 0x34036084;
    }

    private static /* synthetic */ int cii(int n, int n2) {
        return AimCompare.cih(n, n2) * n2;
    }
}

