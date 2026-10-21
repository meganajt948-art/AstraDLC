/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.syx;
import a.sze;
import a.szh;
import a.tbm;
import a.AngleUtil;
import a.tme;
import a.RecordingReader;
import a.NeuroWorker;
import java.util.ArrayList;
import java.util.List;

public final class AimTrace {
    public static final int MAXW = 60;
    public static final int GRACE = 8;
    public static final double FLICK = 20.0;
    private static final int szl = 6;
    private static final int szm = 6;
    private static final int szn = 2;
    public final List<sze> segments = new ArrayList<sze>();
    public final List<double[]> aimPoints = new ArrayList<double[]>();
    public final szh stats = new szh();
    public final List<float[]> chain = new ArrayList<float[]>();
    public final List<Integer> reactions = new ArrayList<Integer>();
    private double szo;
    private int szp = 3;
    public static final double TRACK_RANGE = 6.0;
    public static final double TRACK_FOV = 75.0;
    private static final double szq = 20.0;
    public static final double REACT_FROM = 15.0;
    private static final int szr = 20;
    private static /* synthetic */ long szs;
    private static /* synthetic */ String szt;

    public static AimTrace build(List<RecordingReader> list, boolean bl) {
        return AimTrace.build(list, bl, 3);
    }

    public static AimTrace build(List<RecordingReader> list, boolean bl, int n) {
        AimTrace szk2 = new AimTrace();
        szk2.szp = Math.max(1, n);
        for (RecordingReader tmh2 : list) {
            szk2.taa(tmh2, bl);
        }
        return szk2;
    }

    public static AimTrace track(List<RecordingReader> list, boolean bl) {
        AimTrace szk2 = new AimTrace();
        for (RecordingReader tmh2 : list) {
            szk2.szu(tmh2, bl);
        }
        return szk2;
    }

    private void szu(RecordingReader tmh2, boolean bl) {
        int n;
        int n2;
        this.szo = tmh2.unit;
        List<tme> list = tmh2.ticks;
        int n3 = list.size();
        if (n3 < 10) {
            return;
        }
        double[] dArray = AimTrace.szw(list);
        tbm tbm2 = new tbm();
        int[] nArray = new int[n3];
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            tme tme2 = list.get(n2);
            if ((tme2.flags & 1) == 0) {
                nArray[n2] = 0;
                n4 = 0;
                continue;
            }
            if (!AimTrace.szz(list, n2)) {
                n4 = 0;
            }
            n = 0;
            double d = Double.MAX_VALUE;
            double d2 = Double.MAX_VALUE;
            for (int i = 0; i < tme2.count(); ++i) {
                double d3;
                float[] fArray = tme2.boxes;
                if (!AngleUtil.aim(tme2.eyeX, tme2.eyeY, tme2.eyeZ, fArray[i * 5], fArray[i * 5 + 1], fArray[i * 5 + 2], fArray[i * 5 + 3], fArray[i * 5 + 4], 0.0, 0.5, tbm2) || tbm2.dist > 6.0 || (d3 = Math.hypot(AngleUtil.wrap(tbm2.yaw - (double)tme2.yaw), tbm2.pitch - (double)tme2.pitch)) > 75.0) continue;
                if (tme2.ids[i] == n4) {
                    d2 = d3;
                }
                if (!(d3 < d)) continue;
                d = d3;
                n = tme2.ids[i];
            }
            if (n4 != 0 && d2 <= 75.0 && d2 <= d + 20.0) {
                n = n4;
            }
            nArray[n2] = n;
            n4 = n;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            int n5;
            if (nArray[n2] == 0 || n2 != 0 && nArray[n2 - 1] == nArray[n2] && AimTrace.szz(list, n2) || (n5 = AimTrace.szv(list, n2, nArray[n2])) < 0) continue;
            this.reactions.add(n5);
        }
        n2 = 0;
        while (n2 < n3) {
            int n6;
            if (nArray[n2] == 0) {
                ++n2;
                continue;
            }
            int n7 = nArray[n2];
            n = n2;
            while (n + 1 < n3 && nArray[n + 1] == n7 && AimTrace.szz(list, n + 1)) {
                ++n;
            }
            int n8 = n2;
            for (n6 = 0; n6 < 6 && n8 - n6 - 1 >= 0 && AimTrace.szz(list, n8 - n6) && list.get(n8 - n6 - 1).indexOf(n7) >= 0; ++n6) {
            }
            if (n6 < 6) {
                n8 += 6 - n6;
            }
            if (n - n8 >= 8) {
                this.szx(tmh2, n7, n8, n, dArray, bl);
            }
            n2 = n + 1;
        }
    }

    private static int szv(List<tme> list, int n, int n2) {
        tbm tbm2 = new tbm();
        for (int i = 0; i < 20; ++i) {
            int n3 = n + i;
            int n4 = n3 + 1;
            if (n4 >= list.size() || !AimTrace.szz(list, n4)) {
                return -1;
            }
            tme tme2 = list.get(n3);
            int n5 = tme2.indexOf(n2);
            float[] fArray = tme2.boxes;
            if (n5 < 0 || !AngleUtil.aim(tme2.eyeX, tme2.eyeY, tme2.eyeZ, fArray[n5 * 5], fArray[n5 * 5 + 1], fArray[n5 * 5 + 2], fArray[n5 * 5 + 3], fArray[n5 * 5 + 4], 0.0, 0.5, tbm2)) {
                return -1;
            }
            double d = AngleUtil.wrap(tbm2.yaw - (double)tme2.yaw);
            double d2 = tbm2.pitch - (double)tme2.pitch;
            double d3 = Math.hypot(d, d2);
            if (i == 0 && d3 < 15.0) {
                return -1;
            }
            tme tme3 = list.get(n4);
            double d4 = ((double)(tme3.yaw - tme2.yaw) * d + (double)(tme3.pitch - tme2.pitch) * d2) / Math.max(1.0E-6, d3);
            if (!(d4 > Math.max(1.0, 0.08 * d3))) continue;
            return i;
        }
        return -1;
    }

    private static double[] szw(List<tme> list) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        for (tme tme2 : list) {
            if ((tme2.flags & 1) == 0 || tme2.hitId == 0) continue;
            arrayList.add(Math.abs((double)tme2.hitU));
            arrayList2.add(Double.valueOf(tme2.hitV));
        }
        if (arrayList.size() < 5) {
            return new double[]{0.0, 0.62};
        }
        return new double[]{0.0, NeuroWorker.quantile(arrayList2, 0.5)};
    }

    private void szx(RecordingReader tmh2, int n, int n2, int n3, double[] dArray, boolean bl) {
        int n4;
        int n5;
        Object object;
        Object object2;
        int n6;
        int n7;
        List<tme> list = tmh2.ticks;
        ArrayList<syx> arrayList = new ArrayList<syx>();
        for (n7 = n2; n7 <= n3; ++n7) {
            tme tme2 = list.get(n7);
            if (tme2.hitId != n) continue;
            arrayList.add(new syx(n7, n, tme2.hitU, tme2.hitV));
            ++this.stats.hits;
        }
        n7 = n2 - 6;
        int n8 = n3 - n7 + 1;
        double[] dArray2 = new double[n8];
        double[] dArray3 = new double[n8];
        int n9 = 0;
        for (n6 = 0; n6 < n8; ++n6) {
            int n10 = n7 + n6;
            if (arrayList.isEmpty()) {
                dArray2[n6] = dArray[0];
                dArray3[n6] = dArray[1];
                continue;
            }
            while (n9 < arrayList.size() - 1 && ((syx)arrayList.get((int)n9)).syy < n10) {
                ++n9;
            }
            object2 = (syx)arrayList.get(n9);
            object = n9 > 0 ? (syx)arrayList.get(n9 - 1) : null;
            Object object3 = object;
            if (object == null || n10 >= object2.syy) {
                dArray2[n6] = object2.sza;
                dArray3[n6] = object2.szb;
                continue;
            }
            double d = (double)(n10 - object.syy) / (double)(object2.syy - object.syy);
            dArray2[n6] = object.sza + (object2.sza - object.sza) * d;
            dArray3[n6] = object.szb + (object2.szb - object.szb) * d;
        }
        n6 = n3 - n2;
        tbm tbm2 = new tbm();
        object2 = new double[n8];
        object = new double[n8];
        double[] dArray4 = new double[n8];
        double[] dArray5 = new double[n8];
        double[][] dArrayArray = new double[n8][];
        for (int i = 0; i < n8; ++i) {
            tme tme3 = list.get(n7 + i);
            n5 = tme3.indexOf(n);
            float[] fArray = tme3.boxes;
            if (n5 < 0 || !AngleUtil.aim(tme3.eyeX, tme3.eyeY, tme3.eyeZ, fArray[n5 * 5], fArray[n5 * 5 + 1], fArray[n5 * 5 + 2], fArray[n5 * 5 + 3], fArray[n5 * 5 + 4], dArray2[i], dArray3[i], tbm2)) {
                return;
            }
            object2[i] = tbm2.yaw;
            object[i] = tbm2.pitch;
            dArray4[i] = AngleUtil.wrap(tbm2.yaw - (double)tme3.yaw);
            dArray5[i] = tbm2.pitch - (double)tme3.pitch;
            dArrayArray[i] = new double[]{tbm2.bw, tbm2.bh, tbm2.la, tbm2.ra, tbm2.ta, tbm2.ba, tbm2.dist};
        }
        double[] dArray6 = AimTrace.szy(list, n7, n6, dArray2, dArray3, object2, object, dArray4, dArray5, dArrayArray);
        for (int i = 0; i < arrayList.size(); ++i) {
            n5 = i == 0 ? 0 : Math.min(65535, ((syx)arrayList.get((int)i)).syy - ((syx)arrayList.get((int)(i - 1))).syy);
            this.chain.add(new float[]{(float)((syx)arrayList.get((int)i)).sza, (float)((syx)arrayList.get((int)i)).szb, n5});
        }
        boolean[] blArray = new boolean[n6 + 1];
        if (bl) {
            this.stats.overshoots += AimTrace.overshoots(dArray6, n6, blArray);
        }
        int[] nArray = new int[arrayList.size()];
        for (n4 = 0; n4 < arrayList.size(); ++n4) {
            nArray[n4] = ((syx)arrayList.get((int)n4)).syy - n2;
        }
        this.tad(dArray6, n6, nArray, blArray);
        n4 = -1;
        for (int i = 0; i <= n6 + 1; ++i) {
            boolean bl2;
            boolean bl3 = bl2 = i <= n6 && !blArray[i];
            if (bl2 && n4 < 0) {
                n4 = i;
                continue;
            }
            if (bl2 || n4 < 0) continue;
            this.tac(dArray6, n4, i - 1, arrayList, nArray, 8);
            n4 = -1;
        }
    }

    private static double[] szy(List<tme> list, int n, int n2, double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5, double[] dArray6, double[][] dArray7) {
        int n3 = 32;
        double[] dArray8 = new double[(n2 + 1) * n3];
        for (int i = 0; i <= n2; ++i) {
            int n4 = i + 6;
            tme tme2 = list.get(n + n4);
            int n5 = i * n3;
            dArray8[n5 + 0] = dArray5[n4];
            dArray8[n5 + 1] = dArray6[n4];
            dArray8[n5 + 2] = dArray5[n4 - 2];
            dArray8[n5 + 3] = dArray6[n4 - 2];
            dArray8[n5 + 4] = dArray5[n4 - 4];
            dArray8[n5 + 5] = dArray6[n4 - 4];
            for (int j = 0; j < 4; ++j) {
                dArray8[n5 + 6 + j * 2] = AngleUtil.wrap(dArray3[n4 - j] - dArray3[n4 - j - 1]);
                dArray8[n5 + 7 + j * 2] = dArray4[n4 - j] - dArray4[n4 - j - 1];
                tme tme3 = list.get(n + n4 - j);
                tme tme4 = list.get(n + n4 - j - 1);
                dArray8[n5 + 14 + j * 2] = tme3.yaw - tme4.yaw;
                dArray8[n5 + 15 + j * 2] = tme3.pitch - tme4.pitch;
            }
            double[] dArray9 = dArray7[n4];
            dArray8[n5 + 22] = dArray9[0];
            dArray8[n5 + 23] = dArray9[1];
            dArray8[n5 + 24] = dArray[n4];
            dArray8[n5 + 25] = dArray2[n4];
            dArray8[n5 + 26] = dArray9[6];
            dArray8[n5 + 27] = tme2.cooldown;
            dArray8[n5 + 28] = dArray9[2];
            dArray8[n5 + 29] = dArray9[3];
            dArray8[n5 + 30] = dArray9[4];
            dArray8[n5 + 31] = dArray9[5];
        }
        return dArray8;
    }

    private static boolean szz(List<tme> list, int n) {
        if (n <= 0) {
            return false;
        }
        tme tme2 = list.get(n);
        tme tme3 = list.get(n - 1);
        if ((tme2.flags & 1) == 0 || (tme3.flags & 1) == 0 || (tme2.flags & 4) != 0) {
            return false;
        }
        double d = tme2.eyeX - tme3.eyeX;
        double d2 = tme2.eyeY - tme3.eyeY;
        double d3 = tme2.eyeZ - tme3.eyeZ;
        return (double)Math.abs(tme2.yaw - tme3.yaw) <= 180.0 && d * d + d2 * d2 + d3 * d3 < 16.0;
    }

    private void taa(RecordingReader tmh2, boolean bl) {
        int n;
        int n2;
        this.szo = tmh2.unit;
        List<tme> list = tmh2.ticks;
        int n3 = list.size();
        if (n3 < 10) {
            return;
        }
        int[] nArray = new int[n3];
        for (int i = 0; i < n3; ++i) {
            nArray[i] = AimTrace.szz(list, i) ? nArray[i - 1] : i;
        }
        boolean[] blArray = new boolean[n3];
        int n4 = Integer.MAX_VALUE;
        for (int i = n3 - 1; i >= 0; --i) {
            tme tme2 = list.get(i);
            int n5 = n2 = (tme2.flags & 1) != 0 ? 1 : 0;
            if (n2 != 0 && tme2.hitId != 0) {
                n4 = i;
                ++this.stats.hits;
            }
            int n6 = tme2.presses - (tme2.hitId != 0 ? 1 : 0);
            if (n2 == 0 || n6 <= 0 || tme2.hitId != 0) continue;
            int n7 = n = n4 != Integer.MAX_VALUE && n4 - i <= 8 && nArray[n4] <= i ? 1 : 0;
            if (n != 0) continue;
            blArray[i] = true;
            ++this.stats.failures;
        }
        ArrayList<syx> arrayList = new ArrayList<syx>();
        int n8 = -1;
        n2 = -1;
        syx syx2 = null;
        for (n = 0; n < n3; ++n) {
            int n9;
            if (blArray[n]) {
                n2 = n;
            }
            tme tme3 = list.get(n);
            if ((tme3.flags & 1) == 0 || tme3.hitId == 0) continue;
            syx syx3 = new syx(n, tme3.hitId, tme3.hitU, tme3.hitV);
            int n10 = Math.max(n - 60, nArray[n] + 6);
            n10 = Math.max(n10, n2);
            if (syx2 != null && syx2.syz != syx3.syz) {
                n10 = Math.max(n10, syx2.syy);
            }
            for (n9 = n; n9 >= Math.max(0, n10 - 6); --n9) {
                if (list.get(n9).indexOf(syx3.syz) >= 0) continue;
                n10 = Math.max(n10, n9 + 1 + 6);
                break;
            }
            int n11 = n9 = !arrayList.isEmpty() && ((syx)arrayList.get((int)0)).syz == syx3.syz && n10 <= ((syx)arrayList.get((int)(arrayList.size() - 1))).syy ? 1 : 0;
            if (n9 == 0) {
                this.tab(tmh2, arrayList, n8, bl);
                arrayList = new ArrayList();
                n8 = n10;
            }
            if (n - n8 >= 1) {
                arrayList.add(syx3);
            }
            syx2 = syx3;
        }
        this.tab(tmh2, arrayList, n8, bl);
    }

    private void tab(RecordingReader tmh2, List<syx> list, int n, boolean bl) {
        int n2;
        Object object;
        Object object2;
        Object object3;
        if (list.isEmpty() || n < 0) {
            return;
        }
        int n3 = list.get((int)(list.size() - 1)).syy;
        int n4 = n3 - n;
        if (n4 < this.szp) {
            return;
        }
        List<tme> list2 = tmh2.ticks;
        int n5 = list.get((int)0).syz;
        int n6 = n - 6;
        int n7 = n3 - n6 + 1;
        double[] dArray = new double[n7];
        double[] dArray2 = new double[n7];
        int n8 = 0;
        for (int i = 0; i < n7; ++i) {
            int n9 = n6 + i;
            while (n8 < list.size() - 1 && list.get((int)n8).syy < n9) {
                ++n8;
            }
            object3 = list.get(n8);
            object2 = n8 > 0 ? list.get(n8 - 1) : null;
            Object object4 = object2;
            if (object2 == null || n9 >= object3.syy) {
                dArray[i] = object3.sza;
                dArray2[i] = object3.szb;
                continue;
            }
            double d = (double)(n9 - object2.syy) / (double)(object3.syy - object2.syy);
            dArray[i] = object2.sza + (object3.sza - object2.sza) * d;
            dArray2[i] = object2.szb + (object3.szb - object2.szb) * d;
        }
        tbm tbm2 = new tbm();
        double[] dArray3 = new double[n7];
        object3 = new double[n7];
        object2 = new double[n7];
        double[] dArray4 = new double[n7];
        double[][] dArrayArray = new double[n7][];
        for (int i = 0; i < n7; ++i) {
            object = list2.get(n6 + i);
            int n10 = ((tme)object).indexOf(n5);
            if (n10 < 0) {
                return;
            }
            float[] fArray = ((tme)object).boxes;
            if (!AngleUtil.aim(((tme)object).eyeX, ((tme)object).eyeY, ((tme)object).eyeZ, fArray[n10 * 5], fArray[n10 * 5 + 1], fArray[n10 * 5 + 2], fArray[n10 * 5 + 3], fArray[n10 * 5 + 4], dArray[i], dArray2[i], tbm2)) {
                return;
            }
            dArray3[i] = tbm2.yaw;
            object3[i] = tbm2.pitch;
            object2[i] = AngleUtil.wrap(tbm2.yaw - (double)((tme)object).yaw);
            dArray4[i] = tbm2.pitch - (double)((tme)object).pitch;
            dArrayArray[i] = new double[]{tbm2.bw, tbm2.bh, tbm2.la, tbm2.ra, tbm2.ta, tbm2.ba, tbm2.dist};
        }
        double[] dArray5 = AimTrace.szy(list2, n6, n4, dArray, dArray2, dArray3, object3, object2, dArray4, dArrayArray);
        object = new boolean[n4 + 1];
        if (bl) {
            this.stats.overshoots += AimTrace.overshoots(dArray5, n4, (boolean[])object);
        }
        int[] nArray = new int[list.size()];
        for (n2 = 0; n2 < list.size(); ++n2) {
            nArray[n2] = list.get((int)n2).syy - n;
        }
        this.tad(dArray5, n4, nArray, (boolean[])object);
        n2 = -1;
        for (int i = 0; i <= n4 + 1; ++i) {
            boolean bl2;
            boolean bl3 = bl2 = i <= n4 && object[i] == false;
            if (bl2 && n2 < 0) {
                n2 = i;
                continue;
            }
            if (bl2 || n2 < 0) continue;
            this.tac(dArray5, n2, i - 1, list, nArray, this.szp);
            n2 = -1;
        }
    }

    private void tac(double[] dArray, int n, int n2, List<syx> list, int[] nArray, int n3) {
        int n4;
        int n5 = n2 - n;
        if (n5 < n3) {
            return;
        }
        int n6 = 32;
        double[] dArray2 = new double[(n5 + 1) * n6];
        System.arraycopy(dArray, n * n6, dArray2, 0, dArray2.length);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nArray.length; ++i) {
            n4 = nArray[i] - n;
            if (n4 < 1 || n4 > n5) continue;
            arrayList.add(n4);
            this.aimPoints.add(new double[]{list.get((int)i).sza, list.get((int)i).szb});
        }
        int[] nArray2 = new int[arrayList.size()];
        for (n4 = 0; n4 < nArray2.length; ++n4) {
            nArray2[n4] = (Integer)arrayList.get(n4);
        }
        this.segments.add(new sze(n5, dArray2, nArray2, false, this.szo));
        this.stats.usedHits += nArray2.length;
        this.stats.steps += n5;
        ++this.stats.segments;
    }

    private void tad(double[] dArray, int n, int[] nArray, boolean[] blArray) {
        double d;
        int n2 = 32;
        int n3 = 0;
        for (int n4 : nArray) {
            d = 0.0;
            boolean bl = true;
            for (int i = n3; i < n4 && i <= n; ++i) {
                d = Math.max(d, Math.hypot(dArray[i * n2 + 0], dArray[i * n2 + 1]));
                bl &= !blArray[i];
            }
            if (bl && d >= 20.0) {
                ++this.stats.flicks;
            }
            n3 = n4;
        }
        for (int i = 0; i < n; ++i) {
            if (blArray[i]) continue;
            int n5 = i * n2;
            double d2 = Math.hypot(dArray[n5 + 0], dArray[n5 + 1]);
            d = Math.hypot(dArray[n5 + n2 + 6], dArray[n5 + n2 + 7]);
            if (d2 < 2.5 * dArray[n5 + 22] + 1.0 && d > 0.4) {
                ++this.stats.tracking;
            }
            if (!(Math.abs(dArray[n5 + n2 + 15]) > 1.5)) continue;
            ++this.stats.vertical;
        }
    }

    static int overshoots(double[] dArray, int n, boolean[] blArray) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        for (int i = 0; i <= n; ++i) {
            int n7;
            int n8 = i * 32;
            double d5 = dArray[n8 + 22];
            double d6 = dArray[n8 + 23];
            double d7 = -dArray[n8 + 0];
            int n9 = d7 > dArray[n8 + 29] + 0.25 * d5 ? 1 : (d7 < dArray[n8 + 28] - 0.25 * d5 ? -1 : 0);
            double d8 = -dArray[n8 + 1];
            int n10 = d8 > dArray[n8 + 31] + 0.15 * d6 ? 1 : (n7 = d8 < dArray[n8 + 30] - 0.15 * d6 ? -1 : 0);
            if (i > 0) {
                d += dArray[n8 + 14];
                d2 += dArray[n8 + 15];
                d3 += dArray[n8 + 6];
                d4 += dArray[n8 + 7];
            }
            boolean bl = false;
            if (n9 != 0) {
                if (n3 != 0 && n9 != n3 && d * (double)n9 > 0.0 && d * (double)n9 > -d3 * (double)n9) {
                    AimTrace.tae(blArray, n5 - 6, i + 2, n);
                    bl = true;
                }
                n3 = n9;
                n5 = i;
                d = 0.0;
                d3 = 0.0;
            }
            if (n7 != 0) {
                if (n4 != 0 && n7 != n4 && d2 * (double)n7 > 0.0 && d2 * (double)n7 > -d4 * (double)n7) {
                    AimTrace.tae(blArray, n6 - 6, i + 2, n);
                    bl = true;
                }
                n4 = n7;
                n6 = i;
                d2 = 0.0;
                d4 = 0.0;
            }
            if (!bl) continue;
            ++n2;
        }
        return n2;
    }

    private static void tae(boolean[] blArray, int n, int n2, int n3) {
        for (int i = Math.max(0, n); i <= Math.min(n3, n2); ++i) {
            blArray[i] = true;
        }
    }

    static int overshootCount(double[] dArray, int n) {
        return AimTrace.overshoots(dArray, n, new boolean[n + 1]);
    }

    public void addMirrors() {
        int n = this.segments.size();
        for (int i = 0; i < n; ++i) {
            this.segments.add(this.segments.get(i).mirror());
        }
    }

    private static /* synthetic */ int ciy(int n, int n2) {
        return n + n2 | 0x5673140B;
    }

    private static /* synthetic */ int ciz(int n, int n2) {
        return AimTrace.ciy(n, n2) ^ 0xBB6B5579;
    }

    private static /* synthetic */ int cja(int n, int n2) {
        return n - n2 | 0x7C713A3B;
    }
}

