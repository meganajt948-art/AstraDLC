/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongArrayList
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongList
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  net.minecraft.util.math.BlockPos
 */
package a;

import a.qrz;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.util.math.BlockPos;

public final class qsc {
    private static final double qsd = 4.0;
    private static final double qse = 1.5;
    private final List<qrz> qsf = new ArrayList<qrz>();
    private final LongOpenHashSet qsg = new LongOpenHashSet();
    private LongOpenHashSet qsh;
    private static /* synthetic */ String qsi;
    private static /* synthetic */ long qsj;

    public void clear() {
        this.qsf.clear();
        this.qsg.clear();
        this.qsh = null;
    }

    public boolean isEmpty() {
        return this.qsf.isEmpty();
    }

    public int size() {
        return this.qsf.size();
    }

    public BlockPos headCenter() {
        if (this.qsf.isEmpty()) {
            return null;
        }
        qrz qrz2 = this.qsf.get(0);
        return BlockPos.method_49637((double)qrz2.x, (double)qrz2.y, (double)qrz2.z);
    }

    public LongOpenHashSet head() {
        if (this.qsf.isEmpty()) {
            return null;
        }
        if (this.qsh == null) {
            this.qsh = new LongOpenHashSet((LongCollection)this.qsf.get((int)0).ores);
        }
        return this.qsh;
    }

    public void dropHead() {
        if (!this.qsf.isEmpty()) {
            this.qsf.remove(0);
            this.qsh = null;
        }
    }

    public void update(LongArrayList longArrayList, double d, double d2, double d3) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet((LongCollection)longArrayList);
        this.qsg.clear();
        for (int i = this.qsf.size() - 1; i >= 0; --i) {
            qrz qrz2 = this.qsf.get(i);
            int n = qrz2.ores.size();
            qrz2.ores.removeIf(l -> !longOpenHashSet.contains(l));
            if (qrz2.ores.isEmpty()) {
                this.qsf.remove(i);
                if (i != 0) continue;
                this.qsh = null;
                continue;
            }
            if (qrz2.ores.size() != n) {
                qrz2.center();
                if (i == 0) {
                    this.qsh = null;
                }
            }
            this.qsg.addAll((LongCollection)qrz2.ores);
        }
        LongArrayList longArrayList2 = new LongArrayList();
        for (int i = 0; i < longArrayList.size(); ++i) {
            long l2 = longArrayList.getLong(i);
            if (this.qsg.contains(l2)) continue;
            longArrayList2.add(l2);
        }
        if (longArrayList2.isEmpty()) {
            return;
        }
        List<qrz> list = qsc.qsl(longArrayList2);
        for (qrz qrz3 : list) {
            this.qsg.addAll((LongCollection)qrz3.ores);
        }
        if (this.qsf.isEmpty()) {
            this.qsf.addAll(qsc.qsm(list, d, d2, d3));
            qsc.qsn(this.qsf, 0, d, d2, d3, 40);
            this.qsh = null;
            return;
        }
        for (qrz qrz3 : list) {
            this.qsk(qrz3, d, d2, d3);
        }
        qrz qrz4 = this.qsf.get(0);
        qsc.qsn(this.qsf, 1, qrz4.x, qrz4.y, qrz4.z, 8);
    }

    private void qsk(qrz qrz2, double d, double d2, double d3) {
        int n;
        int n2;
        int n3 = n2 = this.qsf.size();
        double d4 = Double.MAX_VALUE;
        boolean bl = qsc.qso(d, d2, d3, qrz2.x, qrz2.y, qrz2.z) <= 4.0;
        int n4 = n = bl ? 0 : 1;
        while (n <= n2) {
            double d5 = n == 0 ? d : this.qsf.get((int)(n - 1)).x;
            double d6 = n == 0 ? d2 : this.qsf.get((int)(n - 1)).y;
            double d7 = n == 0 ? d3 : this.qsf.get((int)(n - 1)).z;
            double d8 = qsc.qso(d5, d6, d7, qrz2.x, qrz2.y, qrz2.z);
            if (n < n2) {
                qrz qrz3 = this.qsf.get(n);
                d8 += qsc.qso(qrz2.x, qrz2.y, qrz2.z, qrz3.x, qrz3.y, qrz3.z) - qsc.qso(d5, d6, d7, qrz3.x, qrz3.y, qrz3.z);
            }
            if (d8 < d4) {
                d4 = d8;
                n3 = n;
            }
            ++n;
        }
        this.qsf.add(n3, qrz2);
        if (n3 == 0) {
            this.qsh = null;
        }
    }

    private static List<qrz> qsl(LongArrayList longArrayList) {
        ArrayList<qrz> arrayList = new ArrayList<qrz>();
        LongArrayList longArrayList2 = new LongArrayList((LongList)longArrayList);
        while (!longArrayList2.isEmpty()) {
            long l = longArrayList2.removeLong(longArrayList2.size() - 1);
            qrz qrz2 = new qrz();
            qrz2.ores.add(l);
            int n = BlockPos.method_10061((long)l);
            int n2 = BlockPos.method_10071((long)l);
            int n3 = BlockPos.method_10083((long)l);
            for (int i = 0; i < qrz2.ores.size(); ++i) {
                long l2 = qrz2.ores.getLong(i);
                int n4 = BlockPos.method_10061((long)l2);
                int n5 = BlockPos.method_10071((long)l2);
                int n6 = BlockPos.method_10083((long)l2);
                for (int j = longArrayList2.size() - 1; j >= 0; --j) {
                    long l3 = longArrayList2.getLong(j);
                    int n7 = BlockPos.method_10061((long)l3);
                    int n8 = BlockPos.method_10071((long)l3);
                    int n9 = BlockPos.method_10083((long)l3);
                    if (Math.abs(n7 - n4) > 2 || Math.abs(n8 - n5) > 2 || Math.abs(n9 - n6) > 2 || Math.abs(n7 - n) > 3 || Math.abs(n8 - n2) > 3 || Math.abs(n9 - n3) > 3) continue;
                    qrz2.ores.add(l3);
                    longArrayList2.removeLong(j);
                }
            }
            qrz2.center();
            arrayList.add(qrz2);
        }
        return arrayList;
    }

    private static List<qrz> qsm(List<qrz> list, double d, double d2, double d3) {
        ArrayList<qrz> arrayList = new ArrayList<qrz>(list);
        ArrayList<qrz> arrayList2 = new ArrayList<qrz>(list.size());
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        while (!arrayList.isEmpty()) {
            int n = 0;
            double d7 = Double.MAX_VALUE;
            for (int i = 0; i < arrayList.size(); ++i) {
                qrz qrz2 = (qrz)arrayList.get(i);
                double d8 = qsc.qso(d4, d5, d6, qrz2.x, qrz2.y, qrz2.z);
                if (!(d8 < d7)) continue;
                d7 = d8;
                n = i;
            }
            qrz qrz3 = (qrz)arrayList.remove(n);
            arrayList2.add(qrz3);
            d4 = qrz3.x;
            d5 = qrz3.y;
            d6 = qrz3.z;
        }
        return arrayList2;
    }

    private static void qsn(List<qrz> list, int n, double d, double d2, double d3, int n2) {
        int n3 = list.size();
        boolean bl = true;
        for (int i = 0; bl && i < n2; ++i) {
            bl = false;
            for (int j = n; j < n3 - 1; ++j) {
                double d4 = j == n ? d : list.get((int)(j - 1)).x;
                double d5 = j == n ? d2 : list.get((int)(j - 1)).y;
                double d6 = j == n ? d3 : list.get((int)(j - 1)).z;
                for (int k = j + 1; k < n3; ++k) {
                    qrz qrz2 = list.get(j);
                    qrz qrz3 = list.get(k);
                    qrz qrz4 = k + 1 < n3 ? list.get(k + 1) : null;
                    double d7 = qsc.qso(d4, d5, d6, qrz2.x, qrz2.y, qrz2.z) + (qrz4 == null ? 0.0 : qsc.qso(qrz3.x, qrz3.y, qrz3.z, qrz4.x, qrz4.y, qrz4.z));
                    double d8 = qsc.qso(d4, d5, d6, qrz3.x, qrz3.y, qrz3.z) + (qrz4 == null ? 0.0 : qsc.qso(qrz2.x, qrz2.y, qrz2.z, qrz4.x, qrz4.y, qrz4.z));
                    if (!(d8 < d7 - 1.0E-6)) continue;
                    Collections.reverse(list.subList(j, k + 1));
                    bl = true;
                }
            }
        }
    }

    private static double qso(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = (d2 - d5) * 1.5;
        double d9 = d3 - d6;
        return Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
    }

    private static /* synthetic */ int bvm(int n, int n2) {
        return n - n2 ^ 0xE852435B;
    }

    private static /* synthetic */ int bvn(int n, int n2) {
        return qsc.bvm(n, n2) * n2;
    }
}

