/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.piv;
import a.pja;
import flow.dev.a;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class pjd {
    public static final int LIMIT = 3;
    public static final Object MAIN = new Object();
    private static final long pje = 60000L;
    private static final long pjf = 10000L;
    private static final Map<Object, piv> pjg = new IdentityHashMap<Object, piv>();
    private static final List<pja> pjh = new ArrayList<pja>();
    private static /* synthetic */ int pji;
    private static /* synthetic */ boolean pjj;

    private pjd() {
    }

    public static String key(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.replaceAll(a.c(-821074676, "\u6551\u1ce5\u9658\u0834\u83f7\u0522"), "");
        return string2.isEmpty() ? string.trim().toLowerCase(Locale.ROOT) : string2;
    }

    public static synchronized boolean enter(Object object, String string) {
        long l = System.currentTimeMillis();
        pjd.pjm(l);
        String string2 = pjd.key(string);
        if (object == null || string2.isEmpty()) {
            return true;
        }
        piv piv2 = pjg.get(object);
        if (piv2 != null && piv2.piw.equals(string2)) {
            pjg.put(object, new piv(string2, l));
            pjd.pjl(object);
            return true;
        }
        pja pja2 = pjd.pjk(object);
        if (pja2 == null || !pja2.anarchy.equals(string2)) {
            pjd.pjl(object);
            pja2 = new pja(object, string2, l);
            pjh.add(pja2);
        }
        pja2.seen = l;
        if (pjd.count(string2, object) >= 3) {
            return false;
        }
        for (pja pja3 : pjh) {
            if (!pja3.anarchy.equals(string2)) continue;
            if (pja3.owner == object) break;
            return false;
        }
        pjd.pjl(object);
        pjg.put(object, new piv(string2, l));
        return true;
    }

    public static synchronized boolean hasRoom(String string, Object object) {
        pjd.pjm(System.currentTimeMillis());
        String string2 = pjd.key(string);
        piv piv2 = pjg.get(object);
        if (string2.isEmpty() || piv2 != null && piv2.piw.equals(string2)) {
            return true;
        }
        if (pjd.count(string2, object) >= 3) {
            return false;
        }
        for (pja pja2 : pjh) {
            if (!pja2.anarchy.equals(string2)) continue;
            return pja2.owner == object;
        }
        return true;
    }

    public static synchronized int position(Object object) {
        pja pja2 = pjd.pjk(object);
        if (pja2 == null) {
            return 0;
        }
        int n = 0;
        for (pja pja3 : pjh) {
            if (!pja3.anarchy.equals(pja2.anarchy)) continue;
            ++n;
            if (pja3 != pja2) continue;
            return n;
        }
        return 0;
    }

    public static synchronized int count(String string, Object object) {
        String string2 = pjd.key(string);
        int n = 0;
        for (Map.Entry<Object, piv> entry : pjg.entrySet()) {
            if (entry.getKey() == object || !entry.getValue().piw.equals(string2)) continue;
            ++n;
        }
        return n;
    }

    public static synchronized void at(Object object, String string) {
        String string2 = pjd.key(string);
        if (object == null || string2.isEmpty()) {
            return;
        }
        pjd.pjl(object);
        pjg.put(object, new piv(string2, System.currentTimeMillis()));
    }

    public static synchronized String where(Object object) {
        piv piv2 = pjg.get(object);
        return piv2 == null ? "" : piv2.piw;
    }

    public static synchronized void keep(Object object) {
        piv piv2 = pjg.get(object);
        if (piv2 != null) {
            pjg.put(object, new piv(piv2.piw, System.currentTimeMillis()));
        }
    }

    public static synchronized void cancel(Object object) {
        pjd.pjl(object);
    }

    public static synchronized void leave(Object object) {
        pjd.pjl(object);
        pjg.remove(object);
    }

    private static pja pjk(Object object) {
        for (pja pja2 : pjh) {
            if (pja2.owner != object) continue;
            return pja2;
        }
        return null;
    }

    private static void pjl(Object object) {
        pjh.removeIf(pja2 -> pja2.owner == object);
    }

    private static void pjm(long l) {
        pjg.values().removeIf(piv2 -> l - piv2.pix > 60000L);
        Iterator<pja> iterator = pjh.iterator();
        while (iterator.hasNext()) {
            if (l - iterator.next().seen <= 10000L) continue;
            iterator.remove();
        }
    }

    private static /* synthetic */ int bke(int n, int n2) {
        return (n ^ n2) + 1748493626;
    }

    private static /* synthetic */ int bkf(int n, int n2) {
        return pjd.bke(n, n2) ^ 0xF7BBA339;
    }
}

