/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.Locale;

public final class AuctionRateLimiter {
    public static final int SEARCH = 0;
    public static final int SELL = 1;
    private static final long pdj = 60000L;
    private static final long pdk = 600000L;
    private static final ArrayDeque<Long>[] pdl = new ArrayDeque[]{new ArrayDeque(), new ArrayDeque()};
    private static int pdm;
    private static long pdn;
    private static /* synthetic */ long pdo;
    private static /* synthetic */ int pdp;

    private AuctionRateLimiter() {
    }

    public static void observe(String string) {
        if (string == null) {
            return;
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.startsWith("ah sell") || string2.startsWith("auction sell")) {
            AuctionRateLimiter.note(1);
        } else if (string2.equals("ah") || string2.startsWith("ah ") || string2.equals("auction") || string2.startsWith("auction ")) {
            AuctionRateLimiter.note(0);
        }
    }

    public static synchronized void note(int n) {
        long l = System.currentTimeMillis();
        pdl[n].addLast(l);
        AuctionRateLimiter.pdq(n, l);
    }

    public static synchronized int limit(int n) {
        if (pdm > 0 && System.currentTimeMillis() - pdn < 600000L) {
            return Math.max(3, n / 2);
        }
        return Math.max(1, n);
    }

    public static synchronized long nextFree(int n, int n2, long l) {
        AuctionRateLimiter.pdq(n, l);
        int n3 = AuctionRateLimiter.limit(n2);
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
        return AuctionRateLimiter.bhb(n, n2) ^ 0xBF5EB5A0;
    }

    private static /* synthetic */ int bhd(int n, int n2) {
        return AuctionRateLimiter.bhc(n, n2) + n;
    }
}

