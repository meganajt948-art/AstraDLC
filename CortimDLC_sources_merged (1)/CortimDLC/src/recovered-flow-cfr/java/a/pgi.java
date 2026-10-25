/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public final class pgi {
    public static final int SETTLE = 0;
    public static final int ACT = 1;
    public static final int PAGE = 2;
    public static final int CONFIRM = 3;
    public static final int SEARCH = 4;
    public static final int IDLE = 5;
    public static final int BUY = 6;
    private static final int pgj = 7;
    private static final long[] pgk = new long[]{380L, 500L, 460L, 580L, 1500L, 2300L, 1280L};
    private static final long[] pgl = new long[]{270L, 330L, 300L, 390L, 950L, 1200L, 900L};
    private static final long[] pgm = new long[]{1800L, 2300L, 1900L, 2500L, 6000L, 8500L, 9000L};
    private static final double[] pgn = new double[]{0.3, 0.3, 0.3, 0.3, 0.4, 0.45, 0.55};
    private static final double[] pgo = new double[]{0.09, 0.09, 0.09, 0.09, 0.1, 0.12, 0.18};
    private static final double pgp = 0.5;
    private static final double pgq = 1.5;
    private static final double pgr = 0.12;
    private static final int pgs = 12;
    private static final double pgt = 0.82;
    private static final double pgu = 1.35;
    private static final double pgv = 0.08;
    private static final double pgw = 0.012;
    private static final int pgx = 25;
    private static final int pgy = 90;
    private final long[] pgz = new long[7];
    private double pha;
    private double phb;
    private int phc;
    private static /* synthetic */ boolean phd;
    private static /* synthetic */ String phe;

    public pgi() {
        this.reset();
    }

    public void reset() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.pha = threadLocalRandom.nextDouble(0.82, 1.35);
        this.phb = threadLocalRandom.nextDouble(0.82, 1.35);
        this.phc = threadLocalRandom.nextInt(25, 90);
        Arrays.fill(this.pgz, 0L);
    }

    public long draw(int n) {
        return this.draw(n, 1.0);
    }

    public long draw(int n, double d) {
        long l = this.phf(n);
        return d <= 1.0 ? l : Math.round((double)l * d);
    }

    private long phf(int n) {
        this.phi();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double d = pgk[n];
        long l = pgl[n];
        long l2 = pgm[n];
        long l3 = Math.round(d * this.pha * pgi.phg(n, threadLocalRandom));
        for (int i = 0; i < 12 && (l3 < l || l3 > l2); ++i) {
            l3 = Math.round(d * this.pha * pgi.phg(n, threadLocalRandom));
        }
        this.pgz[n] = l3 = this.phh(n, Math.max(l, Math.min(l2, l3)), l, l2);
        return l3;
    }

    private static double phg(int n, ThreadLocalRandom threadLocalRandom) {
        if (threadLocalRandom.nextDouble() < pgo[n]) {
            return 1.5 * Math.exp(0.5 * Math.abs(threadLocalRandom.nextGaussian()));
        }
        return Math.exp(pgn[n] * threadLocalRandom.nextGaussian());
    }

    private long phh(int n, long l, long l2, long l3) {
        boolean bl;
        long l4 = this.pgz[n];
        if (l4 <= 0L) {
            return l;
        }
        long l5 = Math.max(1L, Math.round((double)l4 * 0.12));
        if (Math.abs(l - l4) >= l5) {
            return l;
        }
        long l6 = l4 + l5;
        long l7 = l4 - l5;
        boolean bl2 = l6 <= l3;
        boolean bl3 = bl = l7 >= l2;
        if (l >= l4) {
            return bl2 ? l6 : (bl ? l7 : l);
        }
        return bl ? l7 : (bl2 ? l6 : l);
    }

    private void phi() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        if (--this.phc <= 0) {
            this.phb = threadLocalRandom.nextDouble(0.82, 1.35);
            this.phc = threadLocalRandom.nextInt(25, 90);
        }
        this.pha += (this.phb - this.pha) * 0.08 + threadLocalRandom.nextGaussian() * 0.012;
        this.pha = Math.max(0.82, Math.min(1.35, this.pha));
    }

    private static /* synthetic */ int bij(int n, int n2) {
        return n * n2 | 0xB6537D04;
    }

    private static /* synthetic */ int bik(int n, int n2) {
        return pgi.bij(n, n2) ^ 0xEB6BE776;
    }

    private static /* synthetic */ int bil(int n, int n2) {
        return pgi.bik(n, n2) ^ 0x22D1C621;
    }
}

