/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import java.util.Locale;

public enum qwj {
    COMMON(a.b("\u26ad\u5f33\ud59a\u4be7\uc04a\u46f6\ufcda", 309863092), 1),
    MYTHIC(a.b("\u7c95\u0500\u8faf\u11a2\u9a0a\u1cc9\ua6ee\u2f64\ub131\u3bff", -848398205), 2),
    LEGENDARY(a.b("\u7376\u0ae9\u803c\u1e4b\u9594\u132c\ua97b\u20fa\ubed8\u3464\ub3c8", -291997850), 3);

    private final String qwk;
    private final int qwl;
    private static /* synthetic */ String qwm;
    private static /* synthetic */ int qwn;

    private qwj(String string2, int n2) {
        this.qwk = string2;
        this.qwl = n2;
    }

    public String title() {
        return this.qwk;
    }

    public int rank() {
        return this.qwl;
    }

    public boolean atLeast(qwj qwj2) {
        return this.qwl >= qwj2.qwl;
    }

    public static qwj parse(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        if (string2.contains(a.d("\u5c29\u2596\uaf43\u3134\ubaeb", 704360598, -335878015))) {
            return LEGENDARY;
        }
        if (string2.contains(a.d("\u9ced\ue558\u6ff7", -87782288, 1160320162))) {
            return MYTHIC;
        }
        if (string2.contains(a.d("\ua6b9\udf07\u55ae\ucbd3", -1358368631, 144658954))) {
            return COMMON;
        }
        return null;
    }

    public static qwj byTitle(String string) {
        for (qwj qwj2 : qwj.values()) {
            if (!qwj2.qwk.equalsIgnoreCase(string)) continue;
            return qwj2;
        }
        return COMMON;
    }

    private static /* synthetic */ int bwe(int n, int n2) {
        return n - n2 ^ 0x5B5FDEAA;
    }

    private static /* synthetic */ int bwf(int n, int n2) {
        return qwj.bwe(n, n2) + n;
    }

    private static /* synthetic */ int bwg(int n, int n2) {
        return qwj.bwe(n, n2) ^ 0x537E881B;
    }
}

