/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2IntMap$Entry
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongPredicate
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.minecraft.util.math.BlockPos
 */
package a;

import a.qlk;
import flow.dev.a;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongPredicate;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Locale;
import net.minecraft.util.math.BlockPos;

public final class qln {
    public static final int FACE = 0;
    public static final int LOOK = 1;
    public static final int NONE = 2;
    private static final double qlo = 6.0;
    private static final int qlp = 20;
    private final double[] qlq = new double[3];
    private boolean qlr = true;
    private double qls = 4.0;
    private int qlt;
    private qlk qlu;
    private static /* synthetic */ int qlv;
    private static /* synthetic */ String qlw;

    public void wide(boolean bl) {
        this.qlr = bl;
        if (!bl) {
            this.qlu = null;
        }
    }

    public boolean wide() {
        return this.qlr;
    }

    public double p(int n) {
        if (!this.qlr) {
            return n == 2 ? 1.0 : 0.0;
        }
        double d = Math.pow(3.0, this.qlq[0]);
        double d2 = Math.pow(3.0, this.qlq[1]);
        double d3 = Math.pow(3.0, this.qlq[2]);
        double d4 = n == 0 ? d : (n == 1 ? d2 : d3);
        return d4 / (d + d2 + d3);
    }

    public int lag() {
        return (int)Math.ceil(this.qls);
    }

    public int votes() {
        return this.qlt;
    }

    public static double[] lookAxes(float f, float f2) {
        double[] dArray = new double[3];
        double d = Math.abs(f2);
        double d2 = d >= 55.0 ? 1.0 : (d <= 40.0 ? 0.0 : (d - 40.0) / 15.0);
        double d3 = Math.toRadians(f);
        double d4 = Math.abs(-Math.sin(d3));
        double d5 = Math.abs(Math.cos(d3));
        double d6 = Math.toDegrees(Math.atan2(d5, d4));
        double d7 = d6 <= 40.0 ? 1.0 : (d6 >= 50.0 ? 0.0 : (50.0 - d6) / 10.0);
        dArray[0] = (1.0 - d2) * d7;
        dArray[1] = d2;
        dArray[2] = (1.0 - d2) * (1.0 - d7);
        return dArray;
    }

    public double expect(long l, long l2, int n, double[] dArray) {
        if (l == l2) {
            return 1.0;
        }
        int n2 = BlockPos.unpackLongX((long)l) - BlockPos.unpackLongX((long)l2);
        int n3 = BlockPos.unpackLongY((long)l) - BlockPos.unpackLongY((long)l2);
        int n4 = BlockPos.unpackLongZ((long)l) - BlockPos.unpackLongZ((long)l2);
        if (Math.abs(n2) > 1 || Math.abs(n3) > 1 || Math.abs(n4) > 1) {
            return 0.0;
        }
        if (!this.qlr) {
            return 0.0;
        }
        double d = 0.0;
        if (qln.qlx(n2, n3, n4, n) == 0) {
            d += this.p(0);
        }
        double d2 = this.p(1);
        for (int i = 0; i < 3; ++i) {
            if (!(dArray[i] > 0.0) || qln.qlx(n2, n3, n4, i) != 0) continue;
            d += d2 * dArray[i];
        }
        return d;
    }

    private static int qlx(int n, int n2, int n3, int n4) {
        return n4 == 0 ? n : (n4 == 1 ? n2 : n3);
    }

    public boolean probing() {
        return this.qlu != null;
    }

    public void open(long l, int n, int n2, double[] dArray, LongPredicate longPredicate, LongOpenHashSet longOpenHashSet) {
        if (!this.qlr) {
            return;
        }
        qlk qlk2 = new qlk(l, n, n2, dArray);
        int n3 = BlockPos.unpackLongX((long)l);
        int n4 = BlockPos.unpackLongY((long)l);
        int n5 = BlockPos.unpackLongZ((long)l);
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    long l2;
                    if (i == 0 && j == 0 && k == 0) continue;
                    int n6 = 0;
                    if (qln.qlx(i, j, k, n2) == 0) {
                        n6 |= 1;
                    }
                    for (int i2 = 0; i2 < 3; ++i2) {
                        if (!(dArray[i2] > 0.0) || qln.qlx(i, j, k, i2) != 0) continue;
                        n6 |= 2 << i2;
                    }
                    if (n6 == 0 || longOpenHashSet.contains(l2 = BlockPos.asLong((int)(n3 + i), (int)(n4 + j), (int)(n5 + k))) || !longPredicate.test(l2)) continue;
                    qlk2.blocks.put(l2, n6);
                }
            }
        }
        if (!qlk2.blocks.isEmpty()) {
            this.qlu = qlk2;
        }
    }

    public void exclude(LongOpenHashSet longOpenHashSet) {
        if (this.qlu == null) {
            return;
        }
        ObjectIterator objectIterator = this.qlu.blocks.long2IntEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            if (!longOpenHashSet.contains(((Long2IntMap.Entry)objectIterator.next()).getLongKey())) continue;
            objectIterator.remove();
        }
        if (this.qlu.blocks.isEmpty()) {
            this.qlu = null;
        }
    }

    public void tick(int n, LongPredicate longPredicate) {
        int n2;
        qlk qlk2 = this.qlu;
        if (qlk2 == null) {
            return;
        }
        int n3 = 0;
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        for (Long2IntMap.Entry entry : qlk2.blocks.long2IntEntrySet()) {
            if (!longPredicate.test(entry.getLongKey())) continue;
            longOpenHashSet.add(entry.getLongKey());
            ++n3;
        }
        int n4 = n - qlk2.tick;
        if (n3 == 0 && n4 <= 20) {
            return;
        }
        this.qlu = null;
        if (n3 > 0) {
            this.qls = this.qls * 0.7 + (double)Math.max(1, n4) * 0.3;
        }
        int n5 = qln.qly(qlk2, 1, longOpenHashSet);
        int n6 = 0;
        for (n2 = 0; n2 < 3; ++n2) {
            if (!(qlk2.look[n2] > 0.0) || !qln.qly(qlk2, 2 << n2, longOpenHashSet)) continue;
            n6 = 1;
        }
        n2 = longOpenHashSet.isEmpty() ? 1 : 0;
        if (n5 == n6 && n6 == n2) {
            return;
        }
        this.qlz(0, n5 != 0);
        this.qlz(1, n6 != 0);
        this.qlz(2, n2 != 0);
        ++this.qlt;
    }

    private static boolean qly(qlk qlk2, int n, LongOpenHashSet longOpenHashSet) {
        for (Long2IntMap.Entry entry : qlk2.blocks.long2IntEntrySet()) {
            boolean bl = (entry.getIntValue() & n) != 0;
            if (bl == longOpenHashSet.contains(entry.getLongKey())) continue;
            return false;
        }
        return true;
    }

    private void qlz(int n, boolean bl) {
        this.qlq[n] = Math.max(-6.0, Math.min(6.0, this.qlq[n] + (bl ? 1.0 : -1.0)));
    }

    public String describe() {
        return String.format(Locale.ROOT, a.b("\uce68\ub792\u3d0a\ua368\u28f9\uae4f\u141e\u9de9\u03f3\u8947\u0e9f\uf4f2\u7a71\ue386\u6999\uef6b\u5524\udaf1\u4009\uc65d\u4fa1\u35ec\ubb0b\u209c\ua6ad\u2c7d\u95cf\u1b95\u8127\u0773\u8ccb\u7206\uf81d\u61aa\ue7f1\u6d4d\ud2db\u58ee\ude6b\u47c3\ucd87\ub367\u3922\ubecc\u2417\uaa2a\u13f4\u9943\u1f4b\u849f\u0ae7\uf029\u79c9\uffd7", -1875849619), this.p(0), this.p(1), this.p(2), this.qlt, this.qls);
    }

    private static /* synthetic */ int bss(int n, int n2) {
        return n + n2 + -1907007683;
    }

    private static /* synthetic */ int bst(int n, int n2) {
        return qln.bss(n, n2) ^ 0xB993373B;
    }
}

