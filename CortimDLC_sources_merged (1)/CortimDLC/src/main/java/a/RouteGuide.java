/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Route;

public final class RouteGuide {
    private static final long png = 160L;
    private static volatile Route pnh;
    private static volatile int pni;
    private static volatile boolean pnj;
    private static volatile boolean pnk;
    private static volatile boolean pnl;
    private static volatile String pnm;
    private static volatile long pnn;
    private static /* synthetic */ String pno;
    private static /* synthetic */ String pnp;

    private RouteGuide() {
    }

    public static void publish(Route psf2, int n, boolean bl, boolean bl2, boolean bl3, String string) {
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

    public static Route route() {
        return RouteGuide.pnq() ? pnh : null;
    }

    public static int at() {
        return pni;
    }

    public static boolean guiding() {
        return RouteGuide.pnq() && pnj;
    }

    public static boolean working() {
        return RouteGuide.pnq() && pnk;
    }

    public static boolean visible() {
        return RouteGuide.pnq() && pnh != null && (pnj || pnl);
    }

    public static String module() {
        return RouteGuide.pnq() ? pnm : "";
    }

    static {
        pnm = "";
    }

    private static /* synthetic */ int bll(int n, int n2) {
        return (n ^ n2) + -680843635;
    }

    private static /* synthetic */ int blm(int n, int n2) {
        return RouteGuide.bll(n, n2) * n2;
    }
}

