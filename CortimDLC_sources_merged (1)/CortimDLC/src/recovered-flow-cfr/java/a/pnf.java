/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.psf;

public final class pnf {
    private static final long png = 160L;
    private static volatile psf pnh;
    private static volatile int pni;
    private static volatile boolean pnj;
    private static volatile boolean pnk;
    private static volatile boolean pnl;
    private static volatile String pnm;
    private static volatile long pnn;
    private static /* synthetic */ String pno;
    private static /* synthetic */ String pnp;

    private pnf() {
    }

    public static void publish(psf psf2, int n, boolean bl, boolean bl2, boolean bl3, String string) {
        pnh = psf2;
        pni = n;
        pnj = bl;
        pnk = bl2;
        pnl = bl3;
        pnm = string;
        pnn = System.currentTimeMillis();
    }

    public static void clear() {
        pnh = null;
        pnj = false;
        pnk = false;
        pnl = false;
        pnn = 0L;
    }

    private static boolean pnq() {
        return System.currentTimeMillis() - pnn < 160L;
    }

    public static psf route() {
        return pnf.pnq() ? pnh : null;
    }

    public static int at() {
        return pni;
    }

    public static boolean guiding() {
        return pnf.pnq() && pnj;
    }

    public static boolean working() {
        return pnf.pnq() && pnk;
    }

    public static boolean visible() {
        return pnf.pnq() && pnh != null && (pnj || pnl);
    }

    public static String module() {
        return pnf.pnq() ? pnm : "";
    }

    static {
        pnm = "";
    }

    private static /* synthetic */ int bll(int n, int n2) {
        return (n ^ n2) + -680843635;
    }

    private static /* synthetic */ int blm(int n, int n2) {
        return pnf.bll(n, n2) * n2;
    }
}

