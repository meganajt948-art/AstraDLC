/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.DenseLayer;
import a.tmt;
import a.tmw;
import a.PathProjection;
import a.txi;
import a.WalkFeatures;
import a.txp;
import a.WalkModelReader;
import a.WalkNet;
import a.WalkSnap;
import a.tzp;
import a.WalkRecordingReader;
import a.tzv;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public final class WalkTrainer {
    public static final int MIN_SAMPLES = 2400;
    private static final int tzz = 128;
    private static final double uaa = 0.002;
    private static final double uab = 2.0E-4;
    private static final double uac = 1.0E-4;
    private static final double uad = 5.0;
    private static final double uae = 0.6;
    private static final double uaf = 0.4;
    private static final double uag = 0.8;
    private static final double uah = 0.5;
    private static final double uai = 2.0;
    private static final int uaj = 30;
    private static final int uak = 3;
    private static final double ual = 0.2;
    private static final int uam = WalkFeatures.N;
    private static final int uan = 15;
    private static final double[] uao = new double[]{0.8, 0.6, 0.8, 0.6, 0.3};
    private static final double[] uap = new double[]{0.5, 0.65, 0.8, 1.0};
    private static final double[] uaq = new double[]{0.0, 0.25, 0.5, 0.75, 1.0};
    private static /* synthetic */ boolean uar;
    private static /* synthetic */ String uas;

    private WalkTrainer() {
    }

    private static boolean uat(tzp tzp2, tzp tzp3) {
        if ((tzp2.flags & 1) == 0 || (tzp3.flags & 1) == 0 || (tzp3.flags & 4) != 0) {
            return false;
        }
        if (Math.abs(PathProjection.wrap(tzp3.yaw - tzp2.yaw)) > 90.0) {
            return false;
        }
        double d = tzp3.x - tzp2.x;
        double d2 = tzp3.y - tzp2.y;
        double d3 = tzp3.z - tzp2.z;
        return d * d + d2 * d2 + d3 * d3 < 6.25;
    }

    public static tzv build(List<WalkRecordingReader> list, tmw tmw2, txp txp2) {
        tzv tzv2 = new tzv();
        double[] dArray = new double[uam];
        txi txi2 = new txi();
        int n2 = 0;
        double d = 0.0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        ArrayList<Double> arrayList = new ArrayList<Double>();
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        HashSet<Long> hashSet = new HashSet<Long>();
        for (WalkRecordingReader tzs2 : list) {
            int n8;
            int n9 = tzs2.ticks.size();
            HashMap<Integer, PathProjection> hashMap = new HashMap<Integer, PathProjection>();
            boolean[] blArray = new boolean[n9];
            for (n8 = 1; n8 < n9; ++n8) {
                blArray[n8] = WalkTrainer.uat(tzs2.ticks.get(n8 - 1), tzs2.ticks.get(n8));
            }
            n8 = -2;
            WalkSnap tzg2 = null;
            int n10 = 0;
            int n11 = -1;
            int n12 = 0;
            int n13 = 0;
            int n14 = 20;
            boolean bl = false;
            int n15 = 0;
            while (n15 + 1 < n9) {
                boolean bl2;
                if (tmw2 != null && tmw2.cancel) {
                    throw new tmt("cancel");
                }
                tzp tzp2 = tzs2.ticks.get(n15);
                tzp tzp3 = tzs2.ticks.get(n15 + 1);
                if (!blArray[n15]) {
                    n14 = 20;
                    n12 = 0;
                    n13 = 0;
                    bl = false;
                }
                boolean bl3 = bl2 = (tzp2.keys & 0x10) != 0;
                if (bl2 && !bl) {
                    n14 = 0;
                } else if (n14 < 20) {
                    ++n14;
                }
                bl = bl2;
                if (blArray[n15 + 1] && tzp2.route >= 0 && (tzp2.flags & 0x100) == 0 && (tzp3.flags & 0x100) == 0) {
                    PathProjection tvt2 = hashMap.computeIfAbsent(tzp2.route, n -> tzs2.lanes.get((int)n).track());
                    if (tvt2.n >= 2) {
                        if (tzp2.route != n11) {
                            n10 = tvt2.closest(tzp2.x, tzp2.y, tzp2.z, 0, 0, tvt2.n);
                            n11 = tzp2.route;
                        } else {
                            n10 = tvt2.closest(tzp2.x, tzp2.y, tzp2.z, n10, 8, 60);
                        }
                        double d5 = tvt2.project(tzp2.x, tzp2.z, n10);
                        double d6 = tvt2.offset(tzp2.x, tzp2.z, d5);
                        if (!(d6 > 3.0)) {
                            double d7 = PathProjection.wrap(tzp3.yaw - tzp2.yaw);
                            double d8 = tzp3.pitch - tzp2.pitch;
                            double d9 = Math.hypot(tzp2.vx, tzp2.vz);
                            boolean bl4 = tzp2.keys == 0 && tzp3.keys == 0 && Math.abs(d7) < 0.05 && Math.abs(d8) < 0.05 && d9 < 0.01;
                            int n16 = n12 = bl4 ? n12 + 1 : 0;
                            if (n12 <= 30) {
                                boolean bl5 = (tzp2.keys & 0xF) == 0 && d9 < 0.02;
                                int n17 = n13 = bl5 ? n13 + 1 : 0;
                                if (!(bl5 && (tzp3.keys & 0xF) == 0 && n13 > 3 && Math.abs(d7) < 1.5 && tvt2.length() - d5 > 1.2)) {
                                    if (tzp2.snap != n8) {
                                        n8 = tzp2.snap;
                                        tzg2 = tzs2.snap(tzp2.snap);
                                    }
                                    txi2.x = tzp2.x;
                                    txi2.y = tzp2.y;
                                    txi2.z = tzp2.z;
                                    txi2.yaw = tzp2.yaw;
                                    txi2.pitch = tzp2.pitch;
                                    txi2.vx = tzp2.vx;
                                    txi2.vy = tzp2.vy;
                                    txi2.vz = tzp2.vz;
                                    txi2.ground = (tzp2.flags & 2) != 0;
                                    txi2.water = (tzp2.flags & 0x20) != 0;
                                    txi2.climb = (tzp2.flags & 0x40) != 0;
                                    txi2.collide = (tzp2.flags & 0x80) != 0;
                                    txi2.sprinting = (tzp2.flags & 8) != 0;
                                    txi2.speed = tzp2.speed > 0.0f ? (double)tzp2.speed : 0.1;
                                    tzp tzp4 = n15 >= 1 ? tzs2.ticks.get(n15 - 1) : null;
                                    tzp tzp5 = n15 >= 2 ? tzs2.ticks.get(n15 - 2) : null;
                                    txi2.dyaw1 = blArray[n15] && tzp4 != null ? PathProjection.wrap(tzp2.yaw - tzp4.yaw) : 0.0;
                                    txi2.dpitch1 = blArray[n15] && tzp4 != null ? (double)(tzp2.pitch - tzp4.pitch) : 0.0;
                                    txi2.dyaw2 = blArray[n15] && n15 >= 2 && blArray[n15 - 1] ? PathProjection.wrap(tzp4.yaw - tzp5.yaw) : 0.0;
                                    txi2.dpitch2 = blArray[n15] && n15 >= 2 && blArray[n15 - 1] ? (double)(tzp4.pitch - tzp5.pitch) : 0.0;
                                    txi2.sinceJump = n14;
                                    WalkFeatures.features(txi2, tvt2, n10, tzg2, dArray, 0);
                                    int n18 = WalkRecordingReader.move(tzp3.keys);
                                    boolean bl6 = (tzp3.keys & 0x10) != 0;
                                    boolean bl7 = (tzp3.flags & 8) != 0;
                                    tzv2.add(dArray, n18, bl6, bl7, d7, d8, n2 * 100000 + n15 / 200);
                                    hashSet.add((long)n2 << 32 | (long)tzp2.route);
                                    d4 += Math.hypot(tzp3.x - tzp2.x, tzp3.z - tzp2.z);
                                    d3 += d6;
                                    d2 += (double)tzp2.pitch;
                                    if (bl6 && (tzp2.keys & 0x10) == 0) {
                                        ++n7;
                                    }
                                    if (n18 != 0) {
                                        ++n4;
                                        if (bl7) {
                                            ++n5;
                                        }
                                        if (WalkNet.LEFT[n18] != 0) {
                                            ++n6;
                                        }
                                        if (txi2.ground && d9 > 0.05) {
                                            d += d9;
                                            ++n3;
                                        }
                                    }
                                    if (Math.abs(d7) > 0.5) {
                                        arrayList.add(Math.abs(d7));
                                    }
                                }
                            }
                        }
                    }
                }
                ++n15;
            }
            ++n2;
        }
        if (txp2 != null) {
            txp2.seconds = (float)tzv2.n / 20.0f;
            txp2.meters = (float)d4;
            txp2.routes = hashSet.size();
            txp2.speed = n3 == 0 ? 0.0f : (float)(d / (double)n3 * 20.0);
            txp2.sprintShare = n4 == 0 ? 0.0f : (float)n5 / (float)n4;
            txp2.strafeShare = n4 == 0 ? 0.0f : (float)n6 / (float)n4;
            txp2.jumpsPerMin = tzv2.n == 0 ? 0.0f : (float)((double)n7 / ((double)tzv2.n / 1200.0));
            txp2.turnMedian = (float)WalkTrainer.quantile(arrayList, 0.5);
            txp2.turnP99 = (float)WalkTrainer.quantile(arrayList, 0.99);
            txp2.pitchMean = tzv2.n == 0 ? 0.0f : (float)(d2 / (double)tzv2.n);
            txp2.lateralMean = tzv2.n == 0 ? 0.0f : (float)(d3 / (double)tzv2.n);
        }
        return tzv2;
    }

    public static WalkModelReader run(List<WalkRecordingReader> list, int n2, int n3, long l, boolean bl, tmw tmw2) {
        tmw2.phase = "data";
        WalkModelReader txs2 = new WalkModelReader();
        tzv tzv2 = WalkTrainer.build(list, tmw2, txs2.style);
        if (tzv2.n < 2400) {
            throw new tmt("few");
        }
        Random random = new Random(l);
        boolean[] blArray = new boolean[tzv2.n];
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < tzv2.n; ++i) {
            blArray[i] = hashMap.computeIfAbsent(tzv2.block[i], n -> random.nextDouble() < 0.15);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (int i = 0; i < tzv2.n; ++i) {
            (blArray[i] ? arrayList2 : arrayList).add(i);
        }
        if (arrayList2.size() < 200 || arrayList.size() < 1000) {
            arrayList2 = new ArrayList(arrayList);
        }
        DenseLayer tbx2 = new DenseLayer(uam, n2, n2, WalkNet.OUT);
        WalkNet txv2 = new WalkNet(tbx2);
        boolean[] blArray2 = WalkTrainer.uay(tzv2, arrayList, txv2);
        tbx2.init(random, WalkTrainer.uau(tzv2, arrayList));
        for (int i = 0; i < uam; ++i) {
            if (!blArray2[i]) continue;
            for (int j = 0; j < tbx2.h1; ++j) {
                tbx2.p[j * WalkTrainer.uam + i] = 0.0;
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
        int n6 = n3 * Math.max(1, (nArray.length + 128 - 1) / 128);
        double[] dArray5 = new double[uam];
        double[] dArray6 = new double[uam];
        double[] dArray7 = new double[uam];
        double[] dArray8 = new double[tbx2.h1];
        double[] dArray9 = new double[tbx2.h2];
        double[] dArray10 = new double[WalkNet.OUT];
        double[] dArray11 = new double[WalkNet.OUT];
        double[] dArray12 = new double[tbx2.h1];
        double[] dArray13 = new double[tbx2.h2];
        double[] dArray14 = new double[WalkNet.YAW.length];
        ArrayList<Float> arrayList3 = new ArrayList<Float>();
        tmw2.epochs = n3;
        for (int i = 0; i < n3; ++i) {
            if (tmw2.cancel) {
                throw new tmt("cancel");
            }
            tmw2.phase = "walk";
            tmw2.epoch = i;
            WalkTrainer.ubb(nArray, random);
            for (int j = 0; j < nArray.length; j += 128) {
                int n7;
                Arrays.fill(dArray, 0.0);
                int n8 = Math.min(nArray.length, j + 128);
                double d2 = 0.0;
                for (int k = j; k < n8; ++k) {
                    int n9 = nArray[k];
                    WalkTrainer.uaz(tzv2, n9, dArray5);
                    n7 = tzv2.move[n9];
                    int n10 = tzv2.yaw[n9];
                    if (bl && random.nextBoolean()) {
                        WalkFeatures.mirror(dArray5, 0, dArray6, 0);
                        System.arraycopy(dArray6, 0, dArray5, 0, uam);
                        n7 = WalkNet.MIRROR[n7];
                        n10 = WalkNet.YAW.length - 1 - n10;
                    }
                    if (random.nextDouble() < 0.2) {
                        dArray5[WalkFeatures.I_VF] = 0.0;
                        dArray5[WalkFeatures.I_VL] = 0.0;
                        dArray5[WalkFeatures.I_HS] = 0.0;
                        dArray5[WalkFeatures.I_SPRINT] = 0.0;
                    }
                    int n11 = WalkFeatures.I_DYAW1;
                    dArray5[n11] = dArray5[n11] + random.nextGaussian() * 0.04;
                    int n12 = WalkFeatures.I_DYAW2;
                    dArray5[n12] = dArray5[n12] + random.nextGaussian() * 0.04;
                    int n13 = WalkFeatures.I_DPITCH1;
                    dArray5[n13] = dArray5[n13] + random.nextGaussian() * 0.04;
                    int n14 = WalkFeatures.I_DPITCH2;
                    dArray5[n14] = dArray5[n14] + random.nextGaussian() * 0.04;
                    txv2.normalize(dArray5, 0, dArray7);
                    tbx2.forward(dArray7, dArray8, dArray9, dArray10);
                    d2 += 1.0;
                    WalkTrainer.uav(dArray10, n7, tzv2.jump[n9], tzv2.sprint[n9], n10, tzv2.pitch[n9], dArray11, dArray14);
                    tbx2.backward(dArray7, dArray8, dArray9, dArray11, dArray, null, dArray12, dArray13);
                }
                if (d2 <= 0.0) continue;
                double d3 = 0.0;
                for (n7 = 0; n7 < dArray.length; ++n7) {
                    int n15 = n7;
                    dArray[n15] = dArray[n15] / d2;
                    d3 += dArray[n7] * dArray[n7];
                }
                if ((d3 = Math.sqrt(d3)) > 5.0) {
                    n7 = 0;
                    while (n7 < dArray.length) {
                        int n16 = n7++;
                        dArray[n16] = dArray[n16] * (5.0 / d3);
                    }
                }
                double d4 = Math.min(1.0, (double)(++n5) / 100.0);
                double d5 = 0.5 * (1.0 + Math.cos(Math.PI * Math.min(1.0, (double)n5 / (double)n6)));
                WalkTrainer.uba(tbx2.p, dArray, dArray2, dArray3, n5, (2.0E-4 + 0.0018 * d5) * d4);
            }
            double d6 = WalkTrainer.uax(tzv2, arrayList2, txv2, null, random, uao);
            arrayList3.add(Float.valueOf((float)d6));
            tmw2.curve = WalkTrainer.ubc(arrayList3);
            if (d6 < d - 1.0E-4) {
                d = d6;
                System.arraycopy(tbx2.p, 0, dArray4, 0, dArray4.length);
                n4 = 0;
                continue;
            }
            if (i >= 6 && ++n4 >= 5) break;
        }
        System.arraycopy(dArray4, 0, tbx2.p, 0, dArray4.length);
        tmw2.phase = "check";
        double[] dArray15 = WalkTrainer.uaw(tzv2, arrayList2, txv2, l);
        txs2.yawTemp = dArray15[0];
        txs2.yawJitter = dArray15[1];
        txs2.pitchTemp = dArray15[2];
        txs2.pitchJitter = dArray15[3];
        txs2.jumpThreshold = dArray15[4];
        double[] dArray16 = new double[8];
        WalkTrainer.uax(tzv2, arrayList2, txv2, dArray16, new Random(l ^ 0x5DEECE66DL), dArray15);
        txs2.net = txv2;
        txs2.samples = tzv2.n;
        txs2.valSamples = arrayList2.size();
        txs2.keysAcc = dArray16[0];
        txs2.keysBase = dArray16[1];
        txs2.jumpAcc = dArray16[2];
        txs2.sprintAcc = dArray16[3];
        txs2.yawSim = dArray16[4];
        txs2.pitchSim = dArray16[5];
        txs2.yawCeil = dArray16[6];
        txs2.modelJumps = dArray16[7];
        txs2.created = System.currentTimeMillis();
        tmw2.phase = "finish";
        return txs2;
    }

    private static double[] uau(tzv tzv2, List<Integer> list) {
        int n;
        double[] dArray = new double[WalkNet.OUT];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[WalkNet.YAW.length];
        double[] dArray4 = new double[WalkNet.PITCH.length];
        double d = 0.0;
        double d2 = 0.0;
        for (int n2 : list) {
            int n3 = tzv2.move[n2];
            dArray2[n3] = dArray2[n3] + 1.0;
            int n4 = tzv2.yaw[n2];
            dArray3[n4] = dArray3[n4] + 1.0;
            int n5 = tzv2.pitch[n2];
            dArray4[n5] = dArray4[n5] + 1.0;
            if (tzv2.jump[n2]) {
                d += 1.0;
            }
            if (!tzv2.sprint[n2]) continue;
            d2 += 1.0;
        }
        double d3 = Math.max(1, list.size());
        for (n = 0; n < 9; ++n) {
            dArray[n] = Math.log((dArray2[n] + 1.0) / (d3 + 9.0));
        }
        for (n = 0; n < dArray3.length; ++n) {
            dArray[11 + n] = Math.log((dArray3[n] + 1.0) / (d3 + (double)dArray3.length));
        }
        for (n = 0; n < dArray4.length; ++n) {
            dArray[WalkNet.PITCH0 + n] = Math.log((dArray4[n] + 1.0) / (d3 + (double)dArray4.length));
        }
        double d4 = (d + 1.0) / (d3 + 2.0);
        double d5 = (d2 + 1.0) / (d3 + 2.0);
        dArray[9] = Math.log(d4 / (1.0 - d4));
        dArray[10] = Math.log(d5 / (1.0 - d5));
        return dArray;
    }

    private static void uav(double[] dArray, int n, boolean bl, boolean bl2, int n2, int n3, double[] dArray2, double[] dArray3) {
        int n4;
        Arrays.fill(dArray2, 0.0);
        WalkNet.softmax(dArray, 0, 9, 1.0, dArray3);
        for (int i = 0; i < 9; ++i) {
            dArray2[i] = dArray3[i] - (i == n ? 1.0 : 0.0);
        }
        double d = WalkNet.sigmoid(dArray[9]);
        dArray2[9] = 0.6 * (bl ? 2.0 * (d - 1.0) : d);
        double d2 = WalkNet.sigmoid(dArray[10]);
        dArray2[10] = 0.4 * (d2 - (bl2 ? 1.0 : 0.0));
        int n5 = WalkNet.YAW.length;
        WalkNet.softmax(dArray, 11, n5, 1.0, dArray3);
        for (n4 = 0; n4 < n5; ++n4) {
            dArray2[11 + n4] = 0.8 * (dArray3[n4] - (n4 == n2 ? 1.0 : 0.0));
        }
        n4 = WalkNet.PITCH.length;
        WalkNet.softmax(dArray, WalkNet.PITCH0, n4, 1.0, dArray3);
        for (int i = 0; i < n4; ++i) {
            dArray2[WalkNet.PITCH0 + i] = 0.5 * (dArray3[i] - (i == n3 ? 1.0 : 0.0));
        }
    }

    private static double[] uaw(tzv tzv2, List<Integer> list, WalkNet txv2, long l) {
        DenseLayer tbx2 = txv2.net;
        int n = Math.min(list.size(), 6000);
        double[][] dArrayArray = new double[n][];
        double[] dArray = new double[n];
        boolean[] blArray = new boolean[n];
        double[] dArray2 = new double[uam];
        double[] dArray3 = new double[uam];
        double[] dArray4 = new double[tbx2.h1];
        double[] dArray5 = new double[tbx2.h2];
        double[] dArray6 = new double[WalkNet.OUT];
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            int n3 = list.get(i);
            WalkTrainer.uaz(tzv2, n3, dArray2);
            txv2.normalize(dArray2, 0, dArray3);
            tbx2.forward(dArray3, dArray4, dArray5, dArray6);
            dArrayArray[i] = (double[])dArray6.clone();
            dArray[i] = WalkNet.sigmoid(dArray6[9]);
            blArray[i] = tzv2.jump[n3];
            if (blArray[i]) {
                ++n2;
            }
            arrayList.add(Double.valueOf(Math.abs(tzv2.dyaw[n3])));
            arrayList2.add(Double.valueOf(Math.abs(tzv2.dpitch[n3])));
        }
        double[] dArray7 = (double[])uao.clone();
        double[] dArray8 = new double[WalkNet.YAW.length];
        for (int i = 0; i < 2; ++i) {
            float[] fArray = i == 0 ? WalkNet.YAW : WalkNet.PITCH;
            int n4 = i == 0 ? 11 : WalkNet.PITCH0;
            double d = -1.0;
            for (double d2 : uap) {
                for (double d3 : uaq) {
                    Random random = new Random(l ^ (long)i * 131L + Math.round(d2 * 100.0) * 7L + Math.round(d3 * 100.0));
                    ArrayList<Double> arrayList3 = new ArrayList<Double>(n);
                    for (int j = 0; j < n; ++j) {
                        arrayList3.add(Math.abs(WalkNet.pick(fArray, dArrayArray[j], n4, d2, d3, dArray8, random)));
                    }
                    double d4 = 1.0 - WalkTrainer.ks(i == 0 ? arrayList : arrayList2, arrayList3);
                    if (!(d4 > d + 1.0E-4)) continue;
                    d = d4;
                    dArray7[i * 2] = d2;
                    dArray7[i * 2 + 1] = d3;
                }
            }
        }
        if (n2 == 0) {
            dArray7[4] = 0.5;
            return dArray7;
        }
        double d = -1.0;
        for (double d5 = 0.05; d5 <= 0.8001; d5 += 0.025) {
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            for (int i = 0; i < n; ++i) {
                boolean bl;
                boolean bl2 = bl = dArray[i] > d5;
                if (bl && blArray[i]) {
                    ++n5;
                    continue;
                }
                if (bl) {
                    ++n6;
                    continue;
                }
                if (!blArray[i]) continue;
                ++n7;
            }
            double d6 = 2.0 * (double)n5 / (double)Math.max(1, 2 * n5 + n6 + n7);
            if (!(d6 > d + 1.0E-6)) continue;
            d = d6;
            dArray7[4] = d5;
        }
        return dArray7;
    }

    private static double uax(tzv tzv2, List<Integer> list, WalkNet txv2, double[] dArray, Random random, double[] dArray2) {
        int arrayList5;
        DenseLayer tbx2 = txv2.net;
        double[] dArray3 = new double[uam];
        double[] dArray4 = new double[uam];
        double[] dArray5 = new double[tbx2.h1];
        double[] dArray6 = new double[tbx2.h2];
        double[] dArray7 = new double[WalkNet.OUT];
        double[] dArray8 = new double[9];
        double[] dArray9 = new double[WalkNet.YAW.length];
        double[] dArray10 = new double[WalkNet.PITCH.length];
        double d = 0.0;
        int n = 0;
        int[] nArray = new int[9];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        double d2 = dArray2[4];
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        ArrayList<Double> arrayList3 = new ArrayList<Double>();
        ArrayList<Double> arrayList4 = new ArrayList<Double>();
        for (int n7 : list) {
            boolean bl;
            WalkTrainer.uaz(tzv2, n7, dArray3);
            txv2.normalize(dArray3, 0, dArray4);
            tbx2.forward(dArray4, dArray5, dArray6, dArray7);
            WalkNet.softmax(dArray7, 0, 9, 1.0, dArray8);
            int n8 = tzv2.move[n7];
            d -= Math.log(Math.max(1.0E-9, dArray8[n8]));
            arrayList5 = 0;
            for (int i = 1; i < 9; ++i) {
                if (!(dArray8[i] > dArray8[arrayList5])) continue;
                arrayList5 = i;
            }
            if (arrayList5 == n8) {
                ++n;
            }
            int n9 = n8;
            nArray[n9] = nArray[n9] + 1;
            double i = WalkNet.sigmoid(dArray7[9]);
            d -= 0.6 * (tzv2.jump[n7] ? Math.log(Math.max(1.0E-9, i)) : Math.log(Math.max(1.0E-9, 1.0 - i)));
            boolean bl2 = bl = i > d2;
            if (bl) {
                ++n6;
            }
            if (bl && tzv2.jump[n7]) {
                ++n2;
            } else if (bl) {
                ++n3;
            } else if (tzv2.jump[n7]) {
                ++n4;
            }
            double d3 = WalkNet.sigmoid(dArray7[10]);
            d -= 0.4 * (tzv2.sprint[n7] ? Math.log(Math.max(1.0E-9, d3)) : Math.log(Math.max(1.0E-9, 1.0 - d3)));
            if (d3 > 0.5 == tzv2.sprint[n7]) {
                ++n5;
            }
            WalkNet.softmax(dArray7, 11, WalkNet.YAW.length, 1.0, dArray9);
            d -= 0.8 * Math.log(Math.max(1.0E-9, dArray9[tzv2.yaw[n7]]));
            WalkNet.softmax(dArray7, WalkNet.PITCH0, WalkNet.PITCH.length, 1.0, dArray10);
            d -= 0.5 * Math.log(Math.max(1.0E-9, dArray10[tzv2.pitch[n7]]));
            if (dArray == null) continue;
            arrayList.add(Double.valueOf(Math.abs(tzv2.dyaw[n7])));
            arrayList2.add(Math.abs(WalkNet.pick(WalkNet.YAW, dArray7, 11, dArray2[0], dArray2[1], dArray9, random)));
            arrayList3.add(Double.valueOf(Math.abs(tzv2.dpitch[n7])));
            arrayList4.add(Math.abs(WalkNet.pick(WalkNet.PITCH, dArray7, WalkNet.PITCH0, dArray2[2], dArray2[3], dArray10, random)));
        }
        int n11 = Math.max(1, list.size());
        if (dArray != null) {
            int n10;
            int n7;
            n7 = 0;
            int[] object = nArray;
            arrayList5 = object.length;
            for (n10 = 0; n10 < arrayList5; ++n10) {
                int n12 = object[n10];
                n7 = Math.max(n7, n12);
            }
            dArray[0] = 100.0 * (double)n / (double)n11;
            dArray[1] = 100.0 * (double)n7 / (double)n11;
            dArray[2] = n2 + n4 == 0 ? 100.0 : 200.0 * (double)n2 / (double)Math.max(1, 2 * n2 + n3 + n4);
            dArray[3] = 100.0 * (double)n5 / (double)n11;
            dArray[4] = 100.0 * (1.0 - WalkTrainer.ks(arrayList, arrayList2));
            dArray[5] = 100.0 * (1.0 - WalkTrainer.ks(arrayList3, arrayList4));
            ArrayList<Double> arrayList6 = new ArrayList<Double>();
            ArrayList<Double> arrayList7 = new ArrayList<Double>();
            for (n10 = 0; n10 < arrayList.size(); ++n10) {
                (n10 % 2 == 0 ? arrayList6 : arrayList7).add((Double)arrayList.get(n10));
            }
            dArray[6] = 100.0 * (1.0 - WalkTrainer.ks(arrayList6, arrayList7));
            dArray[7] = 100.0 * (double)n6 / (double)n11;
        }
        return d / (double)n11;
    }

    static double ks(List<Double> list, List<Double> list2) {
        if (list.isEmpty() || list2.isEmpty()) {
            return 1.0;
        }
        double[] dArray = list.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        double[] dArray2 = list2.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        int n = 0;
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

    private static boolean[] uay(tzv tzv2, List<Integer> list, WalkNet txv2) {
        double d;
        int n;
        double[] dArray = new double[uam];
        double[] dArray2 = new double[uam];
        for (int n2 : list) {
            n = 0;
            while (n < uam) {
                d = tzv2.x[n2 * uam + n];
                int n3 = n;
                dArray[n3] = dArray[n3] + d;
                int n4 = n++;
                dArray2[n4] = dArray2[n4] + d * d;
            }
        }
        int n5 = Math.max(1, list.size());
        boolean[] blArray = new boolean[uam];
        for (n = 0; n < uam; ++n) {
            d = dArray[n] / (double)n5;
            double d2 = dArray2[n] / (double)n5 - d * d;
            blArray[n] = d2 < 1.0E-6;
            txv2.mu[n] = d;
            txv2.sd[n] = blArray[n] ? 1.0 : Math.sqrt(Math.max(d2, 1.0E-4));
        }
        return blArray;
    }

    private static void uaz(tzv tzv2, int n, double[] dArray) {
        for (int i = 0; i < uam; ++i) {
            dArray[i] = tzv2.x[n * uam + i];
        }
    }

    private static void uba(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, int n, double d) {
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

    private static void ubb(int[] nArray, Random random) {
        for (int i = nArray.length - 1; i > 0; --i) {
            int n = random.nextInt(i + 1);
            int n2 = nArray[i];
            nArray[i] = nArray[n];
            nArray[n] = n2;
        }
    }

    static double quantile(List<Double> list, double d) {
        if (list.isEmpty()) {
            return 0.0;
        }
        double[] dArray = list.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        int n = (int)Math.min((long)(dArray.length - 1), Math.max(0L, Math.round(d * (double)(dArray.length - 1))));
        return dArray[n];
    }

    private static float[] ubc(List<Float> list) {
        float[] fArray = new float[list.size()];
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = list.get(i).floatValue();
        }
        return fArray;
    }

    private static /* synthetic */ int cun(int n, int n2) {
        return n * n2 + 1050134153;
    }

    private static /* synthetic */ int cuo(int n, int n2) {
        return WalkTrainer.cun(n, n2) * n2;
    }
}

