/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.Locale;

public final class pdi {
    public static final int SEARCH = 0;
    public static final int SELL = 1;
    private static final long pdj = 60000L;
    private static final long pdk = 600000L;
    private static final ArrayDeque<Long>[] pdl = new ArrayDeque[]{new ArrayDeque(), new ArrayDeque()};
    private static int pdm;
    private static long pdn;
    private static /* synthetic */ long pdo;
    private static /* synthetic */ int pdp;

    private pdi() {
    }

    public static void observe(String string) {
        if (string == null) {
            return;
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.startsWith(a.d("\u9212\uebaa\u6131\uff13\u74d2\uf26a\u4839", -1870505834, 989907682)) || string2.startsWith(a.d("\u4ead\u3708\ubdcd\u23ab\ua861\u2ed6\u9484\u1d3b\u8337\u0990\u8e4a\u743b", -1852168949, -2142475317))) {
            pdi.note(1);
        } else if (string2.equals(a.c(-1404359048, "\u2e1b\u57a3")) || string2.startsWith(a.d("\u542c\u2d94\ua70f", 1814205899, 385008005)) || string2.equals(a.c(-960735480, "\u576e\u2ecb\ua40e\u3a68\ub1a2\u3715\u8d47")) || string2.startsWith(a.b("\u3db8\u441d\uced8\u50be\udb74\u5dc3\ue791\u6e2e", 411450833))) {
            pdi.note(0);
        }
    }

    public static synchronized void note(int n) {
        long l = System.currentTimeMillis();
        pdl[n].addLast(l);
        pdi.pdq(n, l);
    }

    public static synchronized int limit(int n) {
        if (pdm > 0 && System.currentTimeMillis() - pdn < 600000L) {
            return Math.max(3, n / 2);
        }
        return Math.max(1, n);
    }

    public static synchronized long nextFree(int n, int n2, long l) {
        pdi.pdq(n, l);
        int n3 = pdi.limit(n2);
        ArrayDeque<Long> arrayDeque = pdl[n];
        if (arrayDeque.size() < n3) {
            return l;
        }
        int n4 = arrayDeque.size() - n3;
        long l2 = l;
        for (long l3 : arrayDeque) {
            if (n4-- > 0) continue;
            l2 = l3 + 60000L;
            break;
        }
        return Math.max(l, l2);
    }

    public static synchronized int warn() {
        long l = System.currentTimeMillis();
        if (l - pdn > 600000L) {
            pdm = 0;
        }
        pdn = l;
        return ++pdm;
    }

    private static void pdq(int n, long l) {
        ArrayDeque<Long> arrayDeque = pdl[n];
        while (!arrayDeque.isEmpty() && l - arrayDeque.peekFirst() > 60000L) {
            arrayDeque.pollFirst();
        }
    }

    private static /* synthetic */ int bhb(int n, int n2) {
        return n - n2 ^ 0x8801055C;
    }

    private static /* synthetic */ int bhc(int n, int n2) {
        return pdi.bhb(n, n2) ^ 0xBF5EB5A0;
    }

    private static /* synthetic */ int bhd(int n, int n2) {
        return pdi.bhc(n, n2) + n;
    }
}

