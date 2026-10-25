/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class piq {
    private long pir = System.currentTimeMillis();
    private long pis;
    private static /* synthetic */ String pit;
    private static /* synthetic */ int piu;

    public void arm(long l) {
        this.pir = System.currentTimeMillis();
        this.pis = Math.max(0L, l);
    }

    public void restart() {
        this.pir = System.currentTimeMillis();
    }

    public boolean ready() {
        return System.currentTimeMillis() - this.pir >= this.pis;
    }

    public boolean elapsed(long l) {
        return System.currentTimeMillis() - this.pir >= l;
    }

    private static /* synthetic */ int bjp(int n, int n2) {
        return n * n2 ^ 0x5852B6A0;
    }

    private static /* synthetic */ int bjq(int n, int n2) {
        return n - n2 | 0xF7156A30;
    }

    private static /* synthetic */ int bjr(int n, int n2) {
        return n + n2 + 1261226106;
    }
}

