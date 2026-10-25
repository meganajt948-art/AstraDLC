/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tbp;
import a.tme;
import a.tmh;
import a.tmt;
import a.tmw;
import a.tpn;
import a.tpx;
import a.tqg;
import a.trd;
import a.trg;
import a.trj;
import a.trp;
import a.tsl;
import a.tso;
import a.tut;
import a.tuw;
import a.tuz;
import a.tvc;
import a.tvn;
import a.tvq;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class tsr {
    public static final int COVER = 40;
    public static final int MAX_TARGETS = 24;
    public static final int HORIZON = 40;
    public static final double REACT_FROM = 15.0;
    private static final int tss = 20;
    private static final double tst = 20.0;
    private static final double tsu = 0.25;
    private static final double tsv = 4.0;
    private static /* synthetic */ long tsw;
    private static /* synthetic */ String tsx;

    private tsr() {
    }

    public static List<tso> prepare(List<tvc> list, double d, tmw tmw2) {
        ArrayList<tso> arrayList = new ArrayList<tso>();
        int[] nArray = new int[2];
        double d2 = 0.0;
        double d3 = 0.0;
        long l = 0L;
        for (tvc tvc2 : list) {
            int n;
            tso tso2 = new tso(tvc2);
            int n2 = tvc2.ticks.size();
            for (n = 0; n < n2; ++n) {
                if (tmw2 != null && tmw2.cancel) {
                    throw new tmt(a.c(-1741957638, "\ud59f\uac2c\u26f0\ub88c\u335d\ub5e5"));
                }
                tuz tuz2 = tvc2.ticks.get(n);
                if ((tuz2.flags & 1) == 0 || tuz2.snap == null) continue;
                trd.reach(tvc2.snap(n), tuz2.x, tuz2.y, tuz2.z, nArray);
                tso2.reach[n] = nArray[0];
                tso2.reachDia[n] = nArray[1];
            }
            n = n2 - 1;
            double d4 = 0.0;
            int n3 = 0;
            for (int i = n2 - 1; i >= 0; --i) {
                tuz tuz3 = tvc2.ticks.get(i);
                if ((tuz3.flags & 1) == 0) {
                    n = i - 1;
                    d4 = 0.0;
                    n3 = 0;
                    continue;
                }
                d4 += trd.value(tuz3.farm, tuz3.dia);
                int n4 = i + 40;
                if (n4 <= n && ++n3 > 40) {
                    tuz tuz4 = tvc2.ticks.get(n4);
                    d4 -= trd.value(tuz4.farm, tuz4.dia);
                    --n3;
                }
                tso2.rate[i] = d4 / (double)n3;
                d2 += tso2.rate[i];
                d3 += tso2.rate[i] * tso2.rate[i];
                ++l;
                if ((tuz3.flags & 4) == 0) continue;
                n = i - 1;
                d4 = 0.0;
                n3 = 0;
            }
            arrayList.add(tso2);
        }
        double d5 = l == 0L ? 0.0 : d2 / (double)l;
        double d6 = l == 0L ? 1.0 : Math.sqrt(Math.max(1.0E-9, d3 / (double)l - d5 * d5));
        for (tso tso3 : arrayList) {
            for (int i = 0; i < tso3.rate.length; ++i) {
                double d7 = (tso3.rate[i] - d5) / d6;
                tso3.weight[i] = d <= 0.0 ? 1.0 : Math.max(0.25, Math.min(4.0, Math.exp(d * d7)));
            }
        }
        return arrayList;
    }

    public static tsl events(List<tso> list, tmw tmw2) {
        tsl tsl2 = new tsl();
        for (tso tso2 : list) {
            tvc tvc2 = tso2.tape;
            for (tut tut2 : tvc2.decisions) {
                tvn tvn2;
                if (tmw2 != null && tmw2.cancel) {
                    throw new tmt(a.d("\uf6db\u8f68\u05b4\u9bc8\u1019\u96a1", 1804537483, 599914549));
                }
                ++tsl2.decisions;
                tuw tuw2 = tvc2.hits.get(tut2.hit);
                if (tuw2.y < tut2.ctx.feetY) {
                    ++tsl2.below;
                    continue;
                }
                tvn tvn3 = tvn2 = tut2.tick >= 0 && tut2.tick < tvc2.ticks.size() ? tvc2.snap(tut2.tick) : null;
                if (tvn2 == null) {
                    ++tsl2.unmatched;
                    continue;
                }
                tpn tpn2 = tpn.of(tvn2, tut2.ctx);
                int n = tpn2.indexOf(tuw2.x, tuw2.y, tuw2.z);
                if (n < 0) {
                    ++tsl2.unmatched;
                    continue;
                }
                if (tpn2.n < 2) {
                    ++tsl2.single;
                    continue;
                }
                tqg tqg2 = new tqg(tpn2.n, Arrays.copyOf(tpn2.f, tpn2.n * 32), n, tpn2.nearest(), tvc2, tut2.tick);
                tqg2.weight = tso2.weight[tut2.tick];
                tsl2.list.add(tqg2);
            }
        }
        return tsl2;
    }

    public static trp legs(List<tso> list, tmw tmw2) {
        trp trp2 = new trp();
        double[] dArray = new double[71];
        trg trg2 = new trg();
        int n = 0;
        for (tso tso2 : list) {
            tvc tvc2 = tso2.tape;
            List<tuw> list2 = tvc2.hits;
            int n2 = 0;
            for (int i = 0; i < tvc2.ticks.size(); ++i) {
                boolean bl;
                if (tmw2 != null && tmw2.cancel) {
                    throw new tmt(a.b("\u2fb7\u5604\udcd8\u42a4\uc975\u4fcd", -975818798));
                }
                tuz tuz2 = tvc2.ticks.get(i);
                while (n2 < list2.size() && list2.get((int)n2).tick <= i) {
                    ++n2;
                }
                if ((tuz2.flags & 1) == 0 || tuz2.snap == null) continue;
                boolean bl2 = bl = n2 < list2.size() && list2.get((int)n2).tick - i <= 40;
                if (tso2.reach[i] == 0 && !bl) continue;
                trg2.px = tuz2.x;
                trg2.pz = tuz2.z;
                trg2.eyeY = tuz2.y;
                trg2.py = (double)tuz2.y - 1.62;
                trg2.yaw = tuz2.yaw;
                trg2.pitch = tuz2.pitch;
                trg2.vx = tuz2.vx;
                trg2.vy = tuz2.vy;
                trg2.vz = tuz2.vz;
                trg2.ground = (tuz2.flags & 2) != 0;
                trg2.feetY = tuz2.feetY;
                trg2.hasTarget = bl;
                if (bl) {
                    tuw tuw2 = list2.get(n2);
                    trg2.tx = tuw2.x;
                    trg2.ty = tuw2.y;
                    trg2.tz = tuw2.z;
                }
                trj.features(tvc2.snap(i), trg2, dArray, 0);
                trp2.add(dArray, trj.move(tuz2.keys), (tuz2.keys & 0x10) != 0, (tuz2.keys & 0x20) != 0, tso2.weight[i], n * 100000 + i / 200);
            }
            ++n;
        }
        return trp2;
    }

    public static List<tmh> rotation(List<tvc> list) {
        ArrayList<tmh> arrayList = new ArrayList<tmh>();
        for (tvc tvc2 : list) {
            int n;
            int n2;
            int n3 = tvc2.ticks.size();
            if (n3 < 20) continue;
            tmh tmh2 = new tmh();
            tmh2.created = tvc2.created;
            tmh2.unit = tvc2.unit;
            tmh2.source = 2;
            List<tuw> list2 = tvc2.hits;
            int[] nArray = new int[n3];
            Arrays.fill(nArray, -1);
            for (n2 = 0; n2 < list2.size(); ++n2) {
                n = list2.get((int)n2).tick;
                if (n < 0 || n >= n3 || nArray[n] >= 0) continue;
                nArray[n] = n2;
            }
            n2 = 0;
            for (n = 0; n < n3; ++n) {
                tuw tuw2;
                int n4;
                tuz tuz2 = tvc2.ticks.get(n);
                tme tme2 = new tme();
                boolean bl = (tuz2.flags & 1) != 0;
                tme2.flags = (bl ? 1 : 0) | ((tuz2.flags & 2) != 0 ? 2 : 0) | ((tuz2.flags & 4) != 0 ? 4 : 0);
                tme2.yaw = tuz2.yaw;
                tme2.pitch = tuz2.pitch;
                tme2.eyeX = tuz2.x;
                tme2.eyeY = tuz2.y;
                tme2.eyeZ = tuz2.z;
                tme2.cooldown = 1.0f;
                while (n2 < list2.size() && list2.get((int)n2).tick < n - 1) {
                    ++n2;
                }
                int n5 = 0;
                for (n4 = n2; n4 < list2.size() && n5 < 24 && list2.get((int)n4).tick <= n + 40; ++n5, ++n4) {
                }
                tme2.ids = new int[n5];
                tme2.boxes = new float[n5 * 5];
                for (n4 = 0; n4 < n5; ++n4) {
                    tuw2 = list2.get(n2 + n4);
                    tme2.ids[n4] = n2 + n4 + 1;
                    tme2.boxes[n4 * 5] = (float)tuw2.x + 0.5f;
                    tme2.boxes[n4 * 5 + 1] = tuw2.y;
                    tme2.boxes[n4 * 5 + 2] = (float)tuw2.z + 0.5f;
                    tme2.boxes[n4 * 5 + 3] = 0.5f;
                    tme2.boxes[n4 * 5 + 4] = 1.0f;
                }
                n4 = nArray[n];
                if (n4 >= 0 && bl) {
                    tuw2 = list2.get(n4);
                    tme2.hitId = n4 + 1;
                    tme2.hitU = (float)tbp.hitU(tuz2.x, tuz2.z, (double)tuw2.x + 0.5, (double)tuw2.z + 0.5, 0.5, tuw2.px, tuw2.pz);
                    tme2.hitV = (float)tbp.hitV(tuw2.y, 1.0, tuw2.py);
                    tme2.presses = 1;
                }
                tmh2.ticks.add(tme2);
            }
            arrayList.add(tmh2);
        }
        return arrayList;
    }

    private static boolean tsy(tvc tvc2, int n) {
        if (n <= 0 || n >= tvc2.ticks.size()) {
            return false;
        }
        tuz tuz2 = tvc2.ticks.get(n);
        tuz tuz3 = tvc2.ticks.get(n - 1);
        if ((tuz2.flags & 1) == 0 || (tuz3.flags & 1) == 0 || (tuz2.flags & 4) != 0) {
            return false;
        }
        double d = tuz2.x - tuz3.x;
        double d2 = tuz2.y - tuz3.y;
        double d3 = tuz2.z - tuz3.z;
        return (double)Math.abs(tuz2.yaw - tuz3.yaw) <= 180.0 && d * d + d2 * d2 + d3 * d3 < 16.0;
    }

    public static List<Integer> reactions(List<tvc> list) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (tvc tvc2 : list) {
            for (int i = 1; i < tvc2.hits.size(); ++i) {
                int n;
                tuw tuw2 = tvc2.hits.get(i - 1);
                tuw tuw3 = tvc2.hits.get(i);
                if (tuw3.tick - tuw2.tick > 40 || tuw3.tick <= tuw2.tick || (n = tsr.tta(tvc2, tuw2.tick, tuw3)) < 0) continue;
                arrayList.add(n);
            }
        }
        return arrayList;
    }

    private static double tsz(tuz tuz2, tuw tuw2) {
        double d = tuw2.px - tuz2.x;
        double d2 = tuw2.py - tuz2.y;
        double d3 = tuw2.pz - tuz2.z;
        return Math.hypot(tbp.wrap(tbp.yawTo(d, d3) - (double)tuz2.yaw), tbp.pitchTo(d2, Math.sqrt(d * d + d3 * d3)) - (double)tuz2.pitch);
    }

    private static int tta(tvc tvc2, int n, tuw tuw2) {
        for (int i = 0; i < 20; ++i) {
            int n2 = n + i;
            int n3 = n2 + 1;
            if (n3 > tuw2.tick || !tsr.tsy(tvc2, n3)) {
                return -1;
            }
            tuz tuz2 = tvc2.ticks.get(n2);
            double d = tuw2.px - tuz2.x;
            double d2 = tuw2.py - tuz2.y;
            double d3 = tuw2.pz - tuz2.z;
            double d4 = tbp.wrap(tbp.yawTo(d, d3) - (double)tuz2.yaw);
            double d5 = tbp.pitchTo(d2, Math.sqrt(d * d + d3 * d3)) - (double)tuz2.pitch;
            double d6 = Math.hypot(d4, d5);
            if (i == 0 && d6 < 15.0) {
                return -1;
            }
            tuz tuz3 = tvc2.ticks.get(n3);
            double d7 = ((double)(tuz3.yaw - tuz2.yaw) * d4 + (double)(tuz3.pitch - tuz2.pitch) * d5) / Math.max(1.0E-6, d6);
            if (!(d7 > Math.max(1.0, 0.08 * d6))) continue;
            return i;
        }
        return -1;
    }

    public static tvq style(List<tso> list, List<Integer> list2) {
        Object object;
        tvq tvq2 = new tvq();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        long l = 0L;
        int n7 = 0;
        double d = 0.0;
        long l2 = 0L;
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        ArrayList<Double> arrayList3 = new ArrayList<Double>();
        for (tso tso2 : list) {
            tuz tuz2;
            Object object2;
            int n8;
            object = tso2.tape;
            for (n8 = 0; n8 < ((tvc)object).ticks.size(); ++n8) {
                object2 = ((tvc)object).ticks.get(n8);
                if ((((tuz)object2).flags & 1) == 0) continue;
                ++n;
                l += (long)((tuz)object2).farm;
                if (tso2.reach[n8] >= 8) {
                    ++n7;
                    d += trd.value(((tuz)object2).farm, ((tuz)object2).dia);
                    l2 += (long)((tuz)object2).dia;
                }
                if (Math.hypot(((tuz)object2).vx, ((tuz)object2).vz) > 0.08) {
                    ++n2;
                    if ((((tuz)object2).flags & 8) != 0) {
                        ++n3;
                    }
                }
                if (!tsr.tsy((tvc)object, n8)) continue;
                tuz2 = ((tvc)object).ticks.get(n8 - 1);
                double d2 = Math.hypot(tbp.wrap(((tuz)object2).yaw - tuz2.yaw), ((tuz)object2).pitch - tuz2.pitch);
                arrayList.add(d2);
                if (!(d2 > 3.0)) continue;
                arrayList2.add(d2);
            }
            for (n8 = 0; n8 < ((tvc)object).hits.size(); ++n8) {
                object2 = ((tvc)object).hits.get(n8);
                if (((tuw)object2).tick < 0 || ((tuw)object2).tick >= ((tvc)object).ticks.size()) continue;
                ++n4;
                tuz2 = ((tvc)object).ticks.get(((tuw)object2).tick);
                if (Math.hypot(tuz2.vx, tuz2.vz) > 0.06) {
                    ++n5;
                }
                if (tpx.target(((tuw)object2).cell)) {
                    ++n6;
                }
                int n9 = n8 > 0 ? Math.max(((tvc)object).hits.get((int)(n8 - 1)).tick, ((tuw)object2).tick - 40) : ((tuw)object2).tick - 40;
                for (int i = Math.max(1, n9); i < ((tuw)object2).tick; ++i) {
                    if (!tsr.tsy((tvc)object, i + 1) || tsr.tsz(((tvc)object).ticks.get(i), (tuw)object2) < 20.0) continue;
                    tuz tuz3 = ((tvc)object).ticks.get(i);
                    tuz tuz4 = ((tvc)object).ticks.get(i + 1);
                    arrayList3.add(Math.hypot(tbp.wrap(tuz4.yaw - tuz3.yaw), tuz4.pitch - tuz3.pitch));
                }
            }
        }
        double d3 = (double)n / 1200.0;
        tvq2.sprintShare = n2 == 0 ? 0.0f : (float)n3 / (float)n2;
        tvq2.walkBreakShare = n4 == 0 ? 0.0f : (float)n5 / (float)n4;
        float f = tvq2.turnCap = arrayList.size() < 200 ? 0.0f : (float)Math.max(20.0, tsr.quantile(arrayList, 0.999));
        tvq2.turnRate = arrayList3.size() >= 50 ? (float)Math.max(6.0, tsr.quantile(arrayList3, 0.5)) : (arrayList2.size() >= 50 ? (float)Math.max(6.0, tsr.quantile(arrayList2, 0.75)) : 18.0f);
        tvq2.blocksPerMin = d3 <= 0.0 ? 0.0f : (float)((double)n4 / d3);
        tvq2.oresPerMin = d3 <= 0.0 ? 0.0f : (float)((double)n6 / d3);
        tvq2.farmPerMin = d3 <= 0.0 ? 0.0f : (float)((double)l / d3);
        tvq2.activeRate = n7 == 0 ? 0.0f : (float)(d / (double)n7 * 1200.0);
        tvq2.activeDia = n7 == 0 ? 0.0f : (float)((double)l2 / (double)n7 * 1200.0);
        tvq2.workShare = n == 0 ? 0.0f : (float)n7 / (float)n;
        tvq2.seconds = (float)n / 20.0f;
        tvq2.hits = n4;
        object = new ArrayList();
        for (int n10 : list2) {
            if (n10 <= 0) continue;
            object.add(Double.valueOf(n10));
        }
        tvq2.reactionMs = object.isEmpty() ? 0 : (int)Math.round(tsr.quantile((List<Double>)object, 0.5) * 50.0);
        return tvq2;
    }

    static double quantile(List<Double> list, double d) {
        if (list.isEmpty()) {
            return 0.0;
        }
        ArrayList<Double> arrayList = new ArrayList<Double>(list);
        Collections.sort(arrayList);
        int n = (int)Math.min((long)(arrayList.size() - 1), Math.max(0L, Math.round(d * (double)(arrayList.size() - 1))));
        return (Double)arrayList.get(n);
    }

    private static /* synthetic */ int cqm(int n, int n2) {
        return n + n2 | 0xF4396867;
    }
}

