/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.syk;
import a.syn;
import a.syq;
import a.sze;
import a.szk;
import a.taf;
import a.tbf;
import a.tbs;
import a.tbx;
import a.tch;
import a.tck;
import a.tmh;
import a.tmk;
import a.tmn;
import a.tmt;
import a.tmw;
import a.tmz;
import a.tnc;
import a.tni;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class tnl {
    static final int MAX_K = 24;
    private static final int tnm = 64;
    private static final int tnn = 24000;
    private static final double tno = 10.0;
    private static final double tnp = 0.8;
    private static final double tnq = 1.5;
    private static final double tnr = 0.003;
    private static final double tns = 1.0E-4;
    private static final double tnt = 1.0E-5;
    private static final double tnu = 2.0;
    private static final int tnv = 30;
    static final int TRACK_EPISODE = 40;
    private static final int[] tnw = new int[]{2, 4};
    private static final int[] tnx = new int[]{2, 4};
    static volatile List<tmn> lastEpisodes = List.of();
    private static final int tny = 8000;
    private static final int tnz = 600;
    private static final float[] toa = new float[]{0.35f, 0.7f, 1.0f, 1.5f, 2.2f};
    private static final float[] tob = new float[]{0.6f, 0.8f, 1.0f, 1.25f, 1.5f, 1.8f, 2.2f, 2.7f, 3.2f};
    private static /* synthetic */ long toc;
    private static /* synthetic */ boolean tod;

    private tnl() {
    }

    public static tck run(List<tmh> list, tmk tmk2, tmw tmw2) {
        int n;
        int n2;
        Object object;
        Object object2;
        Object object3;
        szk szk2;
        tmw2.phase = a.b("\u70c4\u0970\u83b6\u1dd2", 324563108);
        szk szk3 = szk2 = tmk2.track ? szk.track(list, tmk2.dropOvershoot) : szk.build(list, tmk2.dropOvershoot, tmk2.minWindow);
        if (tmk2.track ? szk2.stats.steps < 1500 : szk2.stats.usedHits < 25 || szk2.stats.steps < 250) {
            throw new tmt(a.c(112623011, "\u7dc6\u0474\u8eb5"));
        }
        Random random = new Random(tmk2.seed);
        ArrayList<sze> arrayList = new ArrayList<sze>(szk2.segments);
        List<tmn> list2 = tmk2.track ? tnl.windows(arrayList) : tnl.toe(arrayList);
        Collections.shuffle(list2, random);
        ArrayList<tmn> arrayList2 = new ArrayList<tmn>();
        IdentityHashMap<sze, boolean[]> identityHashMap = new IdentityHashMap<sze, boolean[]>();
        int n3 = list2.size() >= 40 ? Math.max(6, list2.size() * 15 / 100) : 0;
        for (int i = 0; i < n3; ++i) {
            object3 = list2.get(i);
            arrayList2.add((tmn)object3);
            object2 = identityHashMap.computeIfAbsent(((tmn)object3).tmo, sze2 -> new boolean[sze2.m + 1]);
            for (int j = ((tmn)object3).tmp; j < ((tmn)object3).tmq; ++j) {
                object2[j] = true;
            }
        }
        List<tmn> list3 = arrayList2.isEmpty() ? list2 : arrayList2;
        lastEpisodes = list3;
        object3 = new ArrayList<sze>(arrayList);
        if (tmk2.mirror) {
            object2 = arrayList.iterator();
            while (object2.hasNext()) {
                sze sze3 = (sze)object2.next();
                object = sze3.mirror();
                object3.add(object);
                boolean[] blArray = (boolean[])identityHashMap.get(sze3);
                if (blArray == null) continue;
                identityHashMap.put((sze)object, blArray);
            }
        }
        object2 = new tck();
        ((tck)object2).mirror = tmk2.mirror;
        tnl.tok((List<sze>)object3, (tck)object2);
        tnl.tol(arrayList, (tck)object2);
        ((tck)object2).lag = tnl.lag(arrayList);
        int n4 = Math.max(1, tmk2.threads);
        object = Executors.newFixedThreadPool(n4, runnable -> {
            Thread thread = new Thread(runnable, a.d("\ueaa1\u933a\u19ea\u8783\u0c11\u8ab2\u30af\ub955\u271a\uadac\u2a62\ud05c\u5edc\uc775\u4d3b\ucbd3\u7192\ufe54", -582182895, -80317724));
            thread.setDaemon(true);
            thread.setPriority(1);
            return thread;
        });
        tmw2.members = n2 = Math.max(1, tmk2.members);
        tmw2.epochs = n = Math.max(4, tmk2.epochs);
        ArrayList<tbx> arrayList3 = new ArrayList<tbx>();
        ArrayList<Float> arrayList4 = new ArrayList<Float>();
        int n5 = 0;
        try {
            for (int i = 0; i < n2; ++i) {
                tmw2.member = i;
                tbx tbx2 = new tbx(32, tmk2.hidden, tmk2.hidden, 4);
                tbx2.init(new Random(tmk2.seed * 31L + (long)i * 7919L), new double[]{0.35, 0.35, 0.0, 0.0});
                ((tck)object2).nets = new tbx[]{tbx2};
                n5 = Math.max(n5, tnl.tof(tbx2, (tck)object2, (List<sze>)object3, identityHashMap, list3, n, n4, (ExecutorService)object, new Random(tmk2.seed + (long)i * 104729L), tmw2, arrayList4, i == 0, tmk2.overshootWeight));
                arrayList3.add(tbx2);
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new tmt(a.d("\u9de6\ue455\u6e89\uf0f5\u7b24\ufd9c", -1054527445, -221663832));
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException(executionException.getCause());
        }
        finally {
            object.shutdownNow();
        }
        ((tck)object2).nets = arrayList3.toArray(new tbx[0]);
        tmw2.phase = a.b("\ua225\udb9b\u514f\ucf39\u44f4\uc25e", -2110217659);
        ((tck)object2).epochs = n5;
        ((tck)object2).hits = szk2.stats.usedHits;
        ((tck)object2).steps = szk2.stats.steps;
        ((tck)object2).flicks = szk2.stats.flicks;
        ((tck)object2).tracking = szk2.stats.tracking;
        ((tck)object2).created = System.currentTimeMillis();
        double d = 0.0;
        for (tmh tmh2 : list) {
            d += (double)tmh2.unit;
        }
        ((tck)object2).unit = list.isEmpty() ? 0.0f : (float)(d / (double)list.size());
        tnl.too(szk2, (tck)object2, random);
        tnl.calibrate(arrayList, (tck)object2);
        tnl.top(arrayList, (tck)object2, random);
        List<tmn> list4 = new ArrayList<tmn>(list2.subList(Math.min(n3, list2.size()), list2.size()));
        if (tmk2.track) {
            ((tck)object2).kind = 1;
            tnl.ownHand(szk2, arrayList, (tck)object2, random);
            tmw2.phase = a.d("\u2d5b\u54eb\ude23\u4059", 157518392, 500606739);
            tnl.tuneTexture((tck)object2, list4.size() > 400 ? list4.subList(0, 400) : list4, tmk2.seed, tmw2);
        } else {
            tnl.tune((tck)object2, list4.size() > 240 ? list4.subList(0, 240) : list4, tmk2.seed);
        }
        tbs.score((tck)object2, list3, new Random(tmk2.seed ^ 0x5DEECE66DL));
        if (tmk2.dropOvershoot) {
            ((tck)object2).overshootUser = (double)szk2.stats.overshoots / (double)Math.max(1, szk2.stats.overshoots + szk2.stats.usedHits);
        }
        tnl.scoreAxes((tck)object2, list3, list4, tmk2.seed);
        if (tmk2.track) {
            ((tck)object2).similarity = ((tck)object2).axisScore(0) * 0.5 + ((tck)object2).axisScore(1) * 0.5;
        }
        return object2;
    }

    static void scoreAxes(tck tck2, List<tmn> list, List<tmn> list2, long l) {
        if (list.isEmpty()) {
            return;
        }
        syn syn2 = syq.user(list);
        syk syk2 = new syk();
        int n2 = 3;
        for (int i = 0; i < n2; ++i) {
            syk syk3 = syq.compare(syn2, syq.model(tck2, list, new Random(l + 31L * (long)i), tnl.auraTuning()));
            syk2.add(syk3, 1.0 / (double)n2);
        }
        syk syk4 = list2.isEmpty() ? null : syq.compare(syn2, syq.user(list2.subList(0, Math.min(list2.size(), list.size()))));
        double d = Double.NaN;
        int[] nArray = Arrays.stream(tck2.reactions).filter(n -> n > 0).sorted().toArray();
        if (nArray.length > 0) {
            d = nArray[nArray.length / 2];
        }
        tck2.axes = syq.pack(syk2, syk4, d);
    }

    static void ownHand(szk szk2, List<sze> list, tck tck2, Random random) {
        Object object2;
        ArrayList arrayList = new ArrayList();
        for (Object object2 : szk2.chain) {
            if (object2[2] == 0.0f || arrayList.isEmpty()) {
                arrayList.add(new ArrayList());
            }
            ((List)arrayList.get(arrayList.size() - 1)).add(object2);
        }
        Collections.shuffle(arrayList, random);
        ArrayList arrayList2 = new ArrayList();
        object2 = arrayList.iterator();
        while (object2.hasNext()) {
            List list2 = (List)object2.next();
            if (arrayList2.size() + list2.size() > 8000) break;
            arrayList2.addAll(list2);
        }
        tck2.chainU = new float[arrayList2.size()];
        tck2.chainV = new float[arrayList2.size()];
        tck2.chainGap = new int[arrayList2.size()];
        for (int i = 0; i < arrayList2.size(); ++i) {
            tck2.chainU[i] = ((float[])arrayList2.get(i))[0];
            tck2.chainV[i] = ((float[])arrayList2.get(i))[1];
            tck2.chainGap[i] = (int)((float[])arrayList2.get(i))[2];
        }
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>(szk2.reactions);
        Collections.shuffle(arrayList3, random);
        int n = Math.min(600, arrayList3.size());
        tck2.reactions = new int[n];
        for (int i = 0; i < n; ++i) {
            tck2.reactions[i] = Math.min(255, (Integer)arrayList3.get(i));
        }
        ArrayList<Double> arrayList4 = new ArrayList<Double>();
        for (sze sze2 : list) {
            for (int i = 1; i <= sze2.m; ++i) {
                arrayList4.add(Math.hypot(sze2.get(i, 14), sze2.get(i, 15)));
            }
        }
        tck2.turnCap = arrayList4.size() < 200 ? 0.0f : (float)Math.max(20.0, tnl.quantile(arrayList4, 0.999));
    }

    static List<tmn> windows(List<sze> list) {
        ArrayList<tmn> arrayList = new ArrayList<tmn>();
        for (sze sze2 : list) {
            int n = 0;
            while (n + 40 <= sze2.m) {
                arrayList.add(new tmn(sze2, n, n + 40));
                n += 40;
            }
        }
        return arrayList;
    }

    private static List<tmn> toe(List<sze> list) {
        ArrayList<tmn> arrayList = new ArrayList<tmn>();
        for (sze sze2 : list) {
            int n = 0;
            for (int n2 : sze2.hits) {
                int n3 = Math.max(n, n2 - 30);
                if (n2 - n3 >= 3) {
                    arrayList.add(new tmn(sze2, n3, n2));
                }
                n = n2;
            }
        }
        return arrayList;
    }

    private static int tof(tbx tbx2, tck tck2, List<sze> list, Map<sze, boolean[]> map, List<tmn> list2, int n, int n2, ExecutorService executorService, Random random, tmw tmw2, List<Float> list3, boolean bl, double d) throws InterruptedException, ExecutionException {
        tni[] tniArray = new tni[n2];
        for (int i = 0; i < n2; ++i) {
            tniArray[i] = new tni(tbx2);
            tniArray[i].lambda = d;
        }
        double[] dArray = new double[tbx2.size()];
        double[] dArray2 = new double[tbx2.size()];
        double[] dArray3 = (double[])tbx2.p.clone();
        double d2 = Double.POSITIVE_INFINITY;
        int n3 = 0;
        int n4 = 0;
        int n5 = Math.max(1, Math.min(24000, tnl.toh(list)) / 64);
        int n6 = n * n5;
        int n7 = 0;
        for (int i = 0; i < n; ++i) {
            boolean bl2;
            double d3;
            if (tmw2.cancel) {
                throw new tmt(a.c(-523752987, "\u2980\u5033\udaef\u4493\ucf42\u49fa"));
            }
            int n8 = tnl.horizon(i, n);
            tmw2.phase = a.d("\u30a3\u4914\uc3d4\u5dad\ud67d", 2104034361, -1462553365);
            tmw2.epoch = i;
            tmw2.horizon = n8;
            List<tnc> list4 = tnl.toi(list, map, n8);
            Collections.shuffle(list4, random);
            int n9 = Math.min(list4.size(), n5 * 64);
            double d4 = 0.0;
            int n10 = 0;
            for (int j = 0; j < n9; j += 64) {
                int d8;
                int n12;
                if (tmw2.cancel) {
                    throw new tmt(a.c(-987985884, "\u8841\uf1f2\u7b2e\ue552\u6e83\ue83b"));
                }
                int n13 = Math.min(n9, j + 64);
                List<tnc> list5 = list4.subList(j, n13);
                ArrayList<Callable<Void>> arrayList = new ArrayList<Callable<Void>>();
                for (n12 = 0; n12 < n2; ++n12) {
                    tni object = tniArray[n12];
                    int n11 = n12 * list5.size() / n2;
                    int n14 = (n12 + 1) * list5.size() / n2;
                    long d6 = random.nextLong();
                    arrayList.add(() -> {
                        Arrays.fill(tni2.grad, 0.0);
                        tni2.loss = 0.0;
                        tni2.steps = 0;
                        Random random = new Random(d6);
                        for (int i = n11; i < n14; ++i) {
                            tnc tnc2 = (tnc)list5.get(i);
                            tnl.rollout(tbx2, tck2, tnc2.tnd, tnc2.tne, Math.min(n8, tnc2.tnf), object, random);
                        }
                        return null;
                    });
                }
                for (Future future : executorService.invokeAll(arrayList)) {
                    future.get();
                }
                n12 = 0;
                double d5 = 0.0;
                double[] dArray4 = tniArray[0].grad;
                for (int k = 0; k < n2; ++k) {
                    n12 += tniArray[k].steps;
                    d5 += tniArray[k].loss;
                    if (k <= 0) continue;
                    double[] dArray5 = tniArray[k].grad;
                    for (d8 = 0; d8 < dArray4.length; ++d8) {
                        int n15 = d8;
                        dArray4[n15] = dArray4[n15] + dArray5[d8];
                    }
                }
                if (n12 == 0) break;
                double d6 = 0.0;
                for (d8 = 0; d8 < dArray4.length; ++d8) {
                    int n16 = d8;
                    dArray4[n16] = dArray4[n16] / (double)n12;
                    d6 += dArray4[d8] * dArray4[d8];
                }
                if ((d6 = Math.sqrt(d6)) > 2.0) {
                    double d7 = 2.0 / d6;
                    int n17 = 0;
                    while (n17 < dArray4.length) {
                        int n18 = n17++;
                        dArray4[n18] = dArray4[n18] * d7;
                    }
                }
                double d9 = Math.min(1.0, (double)(++n4) / 200.0);
                double d10 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)n4 / (double)n6)));
                double d11 = (1.0E-4 + 0.0029000000000000002 * d10) * d9;
                tnl.toj(tbx2.p, dArray4, dArray, dArray2, n4, d11);
                d4 += d5;
                n10 += n12;
            }
            tmw2.trainLoss = n10 > 0 ? d4 / (double)n10 : Double.NaN;
            tmw2.phase = a.d("\u8adf\uf365\u79bb\ue7cc\u6c13", -1486786258, 150272919);
            tmw2.valLoss = d3 = tnl.validate(tck2, list2, d);
            if (bl) {
                list3.add(Float.valueOf((float)d3));
                tmw2.curve = tnl.tog(list3);
            }
            n7 = i + 1;
            boolean bl3 = bl2 = n8 >= 24;
            if (d3 < d2 - 1.0E-4 || !bl2 && d3 < d2) {
                d2 = d3;
                System.arraycopy(tbx2.p, 0, dArray3, 0, dArray3.length);
                n3 = 0;
                continue;
            }
            if (bl2 && ++n3 >= Math.max(8, n / 3)) break;
        }
        System.arraycopy(dArray3, 0, tbx2.p, 0, dArray3.length);
        return n7;
    }

    private static float[] tog(List<Float> list) {
        float[] fArray = new float[list.size()];
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = list.get(i).floatValue();
        }
        return fArray;
    }

    static int horizon(int n, int n2) {
        double d = (double)n / (double)n2;
        if (d < 0.1) {
            return 1;
        }
        if (d < 0.22) {
            return 4;
        }
        if (d < 0.36) {
            return 8;
        }
        if (d < 0.55) {
            return 16;
        }
        return 24;
    }

    private static int toh(List<sze> list) {
        int n = 0;
        for (sze sze2 : list) {
            n += sze2.m;
        }
        return n;
    }

    private static List<tnc> toi(List<sze> list, Map<sze, boolean[]> map, int n) {
        ArrayList<tnc> arrayList = new ArrayList<tnc>();
        int n2 = 32;
        for (sze sze2 : list) {
            boolean[] blArray = map.get(sze2);
            int n3 = 0;
            for (int i = sze2.m - 1; i >= 0; --i) {
                if (blArray != null && blArray[i]) {
                    n3 = 0;
                    continue;
                }
                tnc tnc2 = new tnc(sze2, i, Math.min(n, ++n3));
                double d = Math.hypot(sze2.st[i * n2 + 0], sze2.st[i * n2 + 1]);
                double d2 = Math.hypot(sze2.st[(i + 1) * n2 + 14], sze2.st[(i + 1) * n2 + 15]);
                int n4 = 1 + Math.min(3, (int)(d / 10.0 + d2 / 6.0));
                for (int j = 0; j < n4; ++j) {
                    arrayList.add(tnc2);
                }
            }
        }
        return arrayList;
    }

    private static void toj(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, int n, double d) {
        double d2 = 0.9;
        double d3 = 0.999;
        double d4 = 1.0 - Math.pow(d2, n);
        double d5 = 1.0 - Math.pow(d3, n);
        for (int i = 0; i < dArray.length; ++i) {
            dArray3[i] = d2 * dArray3[i] + (1.0 - d2) * dArray2[i];
            dArray4[i] = d3 * dArray4[i] + (1.0 - d3) * dArray2[i] * dArray2[i];
            double d6 = dArray3[i] / d4;
            double d7 = dArray4[i] / d5;
            int n2 = i;
            dArray[n2] = dArray[n2] - d * (d6 / (Math.sqrt(d7) + 1.0E-8) + 1.0E-5 * dArray[i]);
        }
    }

    static double huber(double d) {
        double d2 = Math.abs(d);
        return d2 < 1.0 ? 0.5 * d * d : d2 - 0.5;
    }

    static double clip(double d) {
        return d > 1.0 ? 1.0 : (d < -1.0 ? -1.0 : d);
    }

    static double sigmaD(double d, double d2, double d3, double d4) {
        return 0.2 + 0.15 * Math.hypot(d, d2) + 0.03 * Math.hypot(d3, d4);
    }

    static double sigmaE(double d, double d2) {
        return 0.25 + 0.1 * Math.hypot(d, d2);
    }

    static double tolerance(double[] dArray, double d, double d2) {
        return 0.35 * (dArray[22] * Math.abs(d) + 0.5 * dArray[23] * Math.abs(d2)) + 0.05;
    }

    static double rollout(tbx tbx2, tck tck2, sze sze2, int n, int n2, tni tni2, Random random) {
        double d;
        double d2;
        int n3;
        double[] dArray = sze2.st;
        int n4 = 32;
        double d3 = 2.0;
        double d4 = random == null ? 0.0 : 0.04 + 0.03 * Math.hypot(dArray[n * n4 + 0], dArray[n * n4 + 1]);
        tni2.ex[0] = dArray[n * n4 + 0] + (random == null ? 0.0 : random.nextGaussian() * d4);
        tni2.ey[0] = dArray[n * n4 + 1] + (random == null ? 0.0 : random.nextGaussian() * d4 * 0.5);
        double d5 = 0.0;
        for (n3 = 0; n3 < n2; ++n3) {
            double d6;
            double d7;
            double d8;
            int n5;
            int n6;
            int n7 = n + n3;
            int n8 = n7 * n4;
            int n9 = (n7 + 1) * n4;
            double[] dArray2 = tni2.s[n3];
            System.arraycopy(dArray, n8, dArray2, 0, n4);
            dArray2[0] = tni2.ex[n3];
            dArray2[1] = tni2.ey[n3];
            for (n6 = 0; n6 < tnw.length; ++n6) {
                n5 = n3 - tnw[n6];
                if (n5 < 1) continue;
                dArray2[tnl.tnx[n6]] = tni2.ex[n5];
                dArray2[tnl.tnx[n6] + 1] = tni2.ey[n5];
            }
            for (n6 = 0; n6 < 4; ++n6) {
                n5 = n3 - n6;
                if (n5 < 1) continue;
                dArray2[14 + n6 * 2] = tni2.dx[n5];
                dArray2[15 + n6 * 2] = tni2.dy[n5];
            }
            tbf.features(dArray2, tck2.mu, tck2.sd, tni2.x[n3]);
            tbx2.forward(tni2.x[n3], tni2.a1[n3], tni2.a2[n3], tni2.y[n3]);
            double[] dArray3 = tni2.y[n3];
            d2 = tni2.ex[n3] * dArray3[0] + d3 * dArray3[2];
            double d9 = tni2.ey[n3] * dArray3[1] + d3 * dArray3[3];
            tni2.dx[n3 + 1] = d2;
            tni2.dy[n3 + 1] = d9;
            double d10 = dArray[n9 + 6];
            double d11 = dArray[n9 + 7];
            tni2.ex[n3 + 1] = tni2.ex[n3] + d10 - d2;
            tni2.ey[n3 + 1] = tni2.ey[n3] + d11 - d9;
            double d12 = dArray[n9 + 14];
            double d13 = dArray[n9 + 15];
            double d14 = dArray[n9 + 0];
            double d15 = dArray[n9 + 1];
            double d16 = tnl.sigmaD(d12, d13, dArray[n8 + 0], dArray[n8 + 1]);
            double d17 = (d2 - d12) / d16;
            double d18 = (d9 - d13) / d16;
            d5 += tnl.huber(d17) + tnl.huber(d18);
            tni2.lDx[n3 + 1] = tnl.clip(d17) / d16;
            tni2.lDy[n3 + 1] = tnl.clip(d18) / d16;
            double d19 = tnl.sigmaE(d14, d15);
            double d20 = (tni2.ex[n3 + 1] - d14) / d19;
            double d21 = (tni2.ey[n3 + 1] - d15) / d19;
            d5 += 0.8 * (tnl.huber(d20) + tnl.huber(d21));
            tni2.lEx[n3 + 1] = 0.8 * tnl.clip(d20) / d19;
            tni2.lEy[n3 + 1] = 0.8 * tnl.clip(d21) / d19;
            double d22 = tni2.ex[n3] + d10;
            double d23 = tni2.ey[n3] + d11;
            double d24 = Math.hypot(d22, d23);
            if (!(d24 > 1.0E-6) || !((d8 = -(tni2.ex[n3 + 1] * (d7 = d22 / d24) + tni2.ey[n3 + 1] * (d6 = d23 / d24)) - tnl.tolerance(dArray2, d7, d6)) > 0.0)) continue;
            d5 += tni2.lambda * (d8 / d19) * (d8 / d19);
            double d25 = tni2.lambda * 2.0 * d8 / (d19 * d19);
            int n10 = n3 + 1;
            tni2.lEx[n10] = tni2.lEx[n10] - d25 * d7;
            int n11 = n3 + 1;
            tni2.lEy[n11] = tni2.lEy[n11] - d25 * d6;
        }
        if (n2 >= 4) {
            n3 = 0;
            double d26 = 0.0;
            double d27 = 0.0;
            for (int i = 1; i <= n2; ++i) {
                d2 = Math.hypot(tni2.dx[i], tni2.dy[i]);
                if (d2 > d26) {
                    d26 = d2;
                    n3 = i;
                }
                int n12 = (n + i) * n4;
                d27 = Math.max(d27, Math.hypot(dArray[n12 + 14], dArray[n12 + 15]));
            }
            if (d27 > 2.0 && n3 > 0 && d26 > 1.0E-6) {
                double d28 = 0.3 + 0.12 * d27;
                d = (d26 - d27) / d28;
                d5 += 1.5 * tnl.huber(d) * (double)n2 / 8.0;
                double d29 = 1.5 * tnl.clip(d) / d28 * (double)n2 / 8.0 / d26;
                int n13 = n3;
                tni2.lDx[n13] = tni2.lDx[n13] + d29 * tni2.dx[n3];
                int n14 = n3;
                tni2.lDy[n14] = tni2.lDy[n14] + d29 * tni2.dy[n3];
            }
        }
        for (n3 = 0; n3 <= n2; ++n3) {
            tni2.gEx[n3] = 0.0;
            tni2.gEy[n3] = 0.0;
            tni2.gDx[n3] = 0.0;
            tni2.gDy[n3] = 0.0;
        }
        for (n3 = n2 - 1; n3 >= 0; --n3) {
            int n15;
            int n16;
            double d30 = tni2.gEx[n3 + 1] + tni2.lEx[n3 + 1];
            double d31 = tni2.gEy[n3 + 1] + tni2.lEy[n3 + 1];
            double d32 = tni2.gDx[n3 + 1] + tni2.lDx[n3 + 1] - d30;
            d = tni2.gDy[n3 + 1] + tni2.lDy[n3 + 1] - d31;
            double[] dArray4 = tni2.y[n3];
            tni2.gy[0] = d32 * tni2.ex[n3];
            tni2.gy[1] = d * tni2.ey[n3];
            tni2.gy[2] = d32 * d3;
            tni2.gy[3] = d * d3;
            int n17 = n3;
            tni2.gEx[n17] = tni2.gEx[n17] + (d30 + d32 * dArray4[0]);
            int n18 = n3;
            tni2.gEy[n18] = tni2.gEy[n18] + (d31 + d * dArray4[1]);
            tbx2.backward(tni2.x[n3], tni2.a1[n3], tni2.a2[n3], tni2.gy, tni2.grad, tni2.gx, tni2.t1, tni2.t2);
            tbf.backward(tni2.s[n3], tck2.sd, tni2.gx, tni2.gs);
            int n19 = n3;
            tni2.gEx[n19] = tni2.gEx[n19] + tni2.gs[0];
            int n20 = n3;
            tni2.gEy[n20] = tni2.gEy[n20] + tni2.gs[1];
            for (n16 = 0; n16 < tnw.length; ++n16) {
                n15 = n3 - tnw[n16];
                if (n15 < 1) continue;
                int n21 = n15;
                tni2.gEx[n21] = tni2.gEx[n21] + tni2.gs[tnx[n16]];
                int n22 = n15;
                tni2.gEy[n22] = tni2.gEy[n22] + tni2.gs[tnx[n16] + 1];
            }
            for (n16 = 0; n16 < 4; ++n16) {
                n15 = n3 - n16;
                if (n15 < 1) continue;
                int n23 = n15;
                tni2.gDx[n23] = tni2.gDx[n23] + tni2.gs[14 + n16 * 2];
                int n24 = n15;
                tni2.gDy[n24] = tni2.gDy[n24] + tni2.gs[15 + n16 * 2];
            }
        }
        tni2.loss += d5;
        tni2.steps += n2;
        return d5;
    }

    static double validate(tck tck2, List<tmn> list, double d) {
        tch tch2 = new tch();
        double[] dArray = new double[32];
        double[] dArray2 = new double[2];
        double d2 = 0.0;
        int n = 0;
        int n2 = 32;
        for (tmn tmn2 : list) {
            double[] dArray3 = tmn2.tmo.st;
            int n3 = tmn2.tmq - tmn2.tmp;
            tmz tmz2 = new tmz(n3);
            tmz2.ex[0] = dArray3[tmn2.tmp * n2 + 0];
            tmz2.ey[0] = dArray3[tmn2.tmp * n2 + 1];
            for (int i = 0; i < n3; ++i) {
                double d3;
                double d4;
                double d5;
                int n4 = tmn2.tmp + i;
                int n5 = n4 * n2;
                int n6 = (n4 + 1) * n2;
                tmz2.state(tmn2.tmo, tmn2.tmp, i, dArray);
                for (int j = 0; j < 4; ++j) {
                    int n7 = i - j;
                    if (n7 < 1) continue;
                    dArray[14 + j * 2] = tmz2.dx[n7];
                    dArray[15 + j * 2] = tmz2.dy[n7];
                }
                tck2.predict(dArray, dArray2, tch2);
                double d6 = dArray3[n6 + 6];
                double d7 = dArray3[n6 + 7];
                double d8 = tmz2.ex[i] + d6 - dArray2[0];
                double d9 = tmz2.ey[i] + d7 - dArray2[1];
                tmz2.dx[i + 1] = dArray2[0];
                tmz2.dy[i + 1] = dArray2[1];
                tmz2.ex[i + 1] = d8;
                tmz2.ey[i + 1] = d9;
                double d10 = dArray3[n6 + 14];
                double d11 = dArray3[n6 + 15];
                double d12 = dArray3[n6 + 0];
                double d13 = dArray3[n6 + 1];
                double d14 = tnl.sigmaD(d10, d11, dArray3[n5 + 0], dArray3[n5 + 1]);
                double d15 = tnl.sigmaE(d12, d13);
                d2 += tnl.huber((dArray2[0] - d10) / d14) + tnl.huber((dArray2[1] - d11) / d14);
                d2 += 0.8 * (tnl.huber((d8 - d12) / d15) + tnl.huber((d9 - d13) / d15));
                double d16 = tmz2.ex[i] + d6;
                double d17 = tmz2.ey[i] + d7;
                double d18 = Math.hypot(d16, d17);
                if (d18 > 1.0E-6 && (d5 = -(d8 * (d4 = d16 / d18) + d9 * (d3 = d17 / d18)) - tnl.tolerance(dArray, d4, d3)) > 0.0) {
                    d2 += d * (d5 / d15) * (d5 / d15);
                }
                ++n;
            }
        }
        return n > 0 ? d2 / (double)n : Double.NaN;
    }

    private static void tok(List<sze> list, tck tck2) {
        int n = 32;
        double[] dArray = new double[n];
        double[] dArray2 = new double[n];
        double[] dArray3 = new double[32];
        double[] dArray4 = new double[n];
        long l = 0L;
        for (sze sze2 : list) {
            for (int i = 0; i < sze2.m; ++i) {
                System.arraycopy(sze2.st, i * 32, dArray3, 0, 32);
                tbf.raw(dArray3, dArray4);
                for (int j = 0; j < n; ++j) {
                    int n2 = j;
                    dArray[n2] = dArray[n2] + dArray4[j];
                    int n3 = j;
                    dArray2[n3] = dArray2[n3] + dArray4[j] * dArray4[j];
                }
                ++l;
            }
        }
        for (int i = 0; i < n; ++i) {
            double d = l > 0L ? dArray[i] / (double)l : 0.0;
            double d2 = l > 0L ? dArray2[i] / (double)l - d * d : 1.0;
            tck2.mu[i] = d;
            tck2.sd[i] = Math.max(0.05, Math.sqrt(Math.max(0.0, d2)));
        }
    }

    private static void tol(List<sze> list, tck tck2) {
        int d;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < tck.BINS; ++i) {
            arrayList.add(new ArrayList());
            arrayList2.add(new ArrayList());
        }
        for (sze object2 : list) {
            for (d = 0; d < object2.m; ++d) {
                double bl = Math.hypot(object2.get(d, 0), object2.get(d, 1));
                int n = tck.bin(bl);
                double i = object2.get(d + 1, 14);
                double d2 = object2.get(d + 1, 15);
                double d3 = Math.hypot(object2.get(d + 1, 6), object2.get(d + 1, 7));
                ((List)arrayList.get(n)).add(Math.max(0.0, Math.hypot(i, d2) - d3));
                ((List)arrayList2.get(n)).add(Math.hypot(i - object2.get(d, 14), d2 - object2.get(d, 15)));
            }
        }
        Object object3 = new double[tck.BINS];
        double[] dArray = new double[tck.BINS];
        for (d = 0; d < tck.BINS; ++d) {
            boolean bl = ((List)arrayList.get(d)).size() >= 20;
            object3[d] = bl ? tnl.quantile((List)arrayList.get(d), 0.995) : Double.NaN;
            dArray[d] = bl ? tnl.quantile((List)arrayList2.get(d), 0.995) : Double.NaN;
        }
        for (d = tck.BINS - 2; d >= 0; --d) {
            if (!Double.isNaN((double)object3[d])) continue;
            object3[d] = object3[d + 1];
            dArray[d] = dArray[d + 1];
        }
        double d4 = 0.4;
        double d5 = 0.6;
        for (int i = 0; i < tck.BINS; ++i) {
            double d6 = tck.EDGES[Math.min(i, tck.EDGES.length - 1)];
            Object object = Double.isNaN((double)object3[i]) ? (Object)Math.max(d4, d6 * 0.6) : object3[i];
            double d7 = Double.isNaN(dArray[i]) ? Math.max(d5, (double)(object * 0.8)) : dArray[i];
            d4 = Math.max(d4, (double)object);
            d5 = Math.max(d5, d7);
            tck2.speedCap[i] = d4;
            tck2.accelCap[i] = d5;
        }
    }

    static void calibrate(List<sze> list, tck tck2) {
        tch tch2 = new tch();
        double[] dArray = new double[32];
        double[] dArray2 = new double[2];
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        for (sze object2 : list) {
            for (int fArray = 0; fArray < object2.m; ++fArray) {
                System.arraycopy(object2.st, fArray * 32, dArray, 0, 32);
                tck2.base(dArray, dArray2, tch2);
                arrayList.add(Math.hypot(dArray2[0], dArray2[1]));
                arrayList2.add(Math.hypot(object2.get(fArray + 1, 14), object2.get(fArray + 1, 15)));
            }
        }
        if (arrayList.size() < 200) {
            return;
        }
        Object object3 = new double[]{0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.85, 0.9, 0.93, 0.95, 0.97, 0.98, 0.99, 0.995};
        float[] fArray = new float[((Object)object3).length];
        float[] fArray2 = new float[((Object)object3).length];
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < ((Object)object3).length; ++i) {
            d = Math.max(d + 0.001, tnl.quantile(arrayList, (double)object3[i]));
            d2 = Math.max(d2, tnl.quantile(arrayList2, (double)object3[i]));
            fArray[i] = (float)d;
            fArray2[i] = (float)Math.max(d2, d * 0.6);
        }
        fArray2[0] = fArray[0];
        tck2.qIn = fArray;
        tck2.qOut = fArray2;
    }

    public static taf auraTuning() {
        return new taf();
    }

    static void tuneTexture(tck tck2, List<tmn> list, long l, tmw tmw2) {
        if (list.size() < 20 || tck2.resX.length == 0) {
            return;
        }
        syn syn2 = syq.user(list);
        taf taf2 = tnl.auraTuning();
        tck2.texCap = 1.0f;
        tck2.texX = 1.25f;
        tck2.texY = 1.25f;
        double d = tnl.ton(tck2, list, syn2, taf2, l);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                float f;
                float[] fArray;
                float[] fArray2 = fArray = j == 0 ? toa : tob;
                float f2 = f = j == 0 ? tck2.texCap : (j == 1 ? tck2.texX : tck2.texY);
                for (float f3 : fArray) {
                    if (tmw2.cancel) {
                        throw new tmt(a.d("\u8caf\uf51c\u7fc0\ue1bc\u6a6d\uecd5", -1406059793, -698894811));
                    }
                    if (f3 == f) continue;
                    tnl.tom(tck2, j, f3);
                    double d2 = tnl.ton(tck2, list, syn2, taf2, l);
                    if (!(d2 > d + 0.05)) continue;
                    d = d2;
                    f2 = f3;
                }
                tnl.tom(tck2, j, f2);
            }
        }
    }

    private static void tom(tck tck2, int n, float f) {
        switch (n) {
            case 0: {
                tck2.texCap = f;
                break;
            }
            case 1: {
                tck2.texX = f;
                break;
            }
            default: {
                tck2.texY = f;
            }
        }
    }

    private static double ton(tck tck2, List<tmn> list, syn syn2, taf taf2, long l) {
        syk syk2 = syq.compare(syn2, syq.model(tck2, list, new Random(l), taf2));
        return 0.6 * Math.min(syk2.simX, syk2.simY) + 0.4 * syk2.total();
    }

    static void tune(tck tck2, List<tmn> list, long l) {
        if (tck2.qIn.length < 8 || list.size() < 20) {
            return;
        }
        tck2.boostFrom = tck2.qIn[4];
        tck2.boostTo = tck2.qIn[9];
        float f = 1.0f;
        double d = Double.NEGATIVE_INFINITY;
        double d2 = -1.0;
        for (float f2 = 1.0f; f2 <= 1.401f; f2 += 0.08f) {
            tck2.boost = f2;
            double d3 = 0.0;
            double d4 = 0.0;
            for (int i = 0; i < 3; ++i) {
                tbs.score(tck2, list, new Random(l + (long)i * 977L));
                d3 += tck2.similarity;
                d4 += tck2.overshootModel;
            }
            if (d2 < 0.0) {
                d2 = d4;
            }
            if (d4 > d2 + 1.0E-9 || !(d3 > d + 0.3)) continue;
            d = d3;
            f = f2;
        }
        tck2.boost = f;
    }

    static int lag(List<sze> list) {
        double d;
        int n;
        int n2 = 8;
        double[] dArray = new double[n2 + 1];
        double[] dArray2 = new double[n2 + 1];
        double[] dArray3 = new double[n2 + 1];
        int n3 = 32;
        for (sze sze2 : list) {
            for (int i = n2; i <= sze2.m; ++i) {
                n = i * n3;
                d = Math.hypot(sze2.st[n + 0], sze2.st[n + 1]);
                if (d > 3.0 * sze2.st[n + 22] + 2.0) continue;
                double d2 = sze2.st[n + 14];
                int n4 = 0;
                while (n4 <= n2) {
                    double d3 = sze2.st[(i - n4) * n3 + 6];
                    int n5 = n4;
                    dArray[n5] = dArray[n5] + d3 * d2;
                    int n6 = n4;
                    dArray2[n6] = dArray2[n6] + d3 * d3;
                    int n7 = n4++;
                    dArray3[n7] = dArray3[n7] + d2 * d2;
                }
            }
        }
        int n8 = 3;
        double d4 = 0.05;
        for (n = 0; n <= n2; ++n) {
            if (dArray2[n] <= 0.0 || dArray3[n] <= 0.0 || !((d = dArray[n] / Math.sqrt(dArray2[n] * dArray3[n])) > d4)) continue;
            d4 = d;
            n8 = n;
        }
        return n8;
    }

    static double quantile(List<Double> list, double d) {
        if (list.isEmpty()) {
            return Double.NaN;
        }
        double[] dArray = new double[list.size()];
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = list.get(i);
        }
        Arrays.sort(dArray);
        return dArray[Math.min(dArray.length - 1, (int)Math.floor(d * (double)(dArray.length - 1)))];
    }

    private static void too(szk szk2, tck tck2, Random random) {
        ArrayList<double[]> arrayList = new ArrayList<double[]>(szk2.aimPoints);
        Collections.shuffle(arrayList, random);
        int n = Math.min(arrayList.size(), 4000);
        tck2.aimU = new float[n];
        tck2.aimV = new float[n];
        for (int i = 0; i < n; ++i) {
            tck2.aimU[i] = (float)((double[])arrayList.get(i))[0];
            tck2.aimV[i] = (float)((double[])arrayList.get(i))[1];
        }
    }

    private static void top(List<sze> list, tck tck2, Random random) {
        ArrayList<sze> arrayList = new ArrayList<sze>(list);
        Collections.shuffle(arrayList, random);
        tch tch2 = new tch();
        double[] dArray = new double[32];
        double[] dArray2 = new double[2];
        ArrayList<float[]> arrayList2 = new ArrayList<float[]>();
        int n = 40000;
        for (sze sze2 : arrayList) {
            if (arrayList2.size() >= n) break;
            for (int i = 0; i < sze2.m && arrayList2.size() < n; ++i) {
                System.arraycopy(sze2.st, i * 32, dArray, 0, 32);
                tck2.predict(dArray, dArray2, tch2);
                double d = sze2.get(i + 1, 14) - dArray2[0];
                double d2 = sze2.get(i + 1, 15) - dArray2[1];
                int n2 = tck.bin(Math.hypot(dArray[0], dArray[1]));
                arrayList2.add(new float[]{(float)d, (float)d2, n2, i < sze2.m - 1 ? 1.0f : 0.0f});
            }
            if (arrayList2.isEmpty()) continue;
            ((float[])arrayList2.get((int)(arrayList2.size() - 1)))[3] = 0.0f;
        }
        int n3 = arrayList2.size();
        tck2.resX = new float[n3];
        tck2.resY = new float[n3];
        tck2.resBin = new byte[n3];
        tck2.resLink = new boolean[n3];
        for (int i = 0; i < n3; ++i) {
            float[] fArray = (float[])arrayList2.get(i);
            tck2.resX[i] = fArray[0];
            tck2.resY[i] = fArray[1];
            tck2.resBin[i] = (byte)fArray[2];
            tck2.resLink[i] = fArray[3] > 0.5f;
        }
    }

    private static /* synthetic */ int cno(int n, int n2) {
        return n + n2 | 0x88168558;
    }
}

