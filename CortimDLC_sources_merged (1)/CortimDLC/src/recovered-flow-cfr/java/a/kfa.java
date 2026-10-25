/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;

public enum kfa {
    COMBAT(a.d("\u0f5b\u76c6\ufc17\u6269\ue9bd\u6f19", -205514717, 326178621)),
    MOVEMENT(a.c(1650180091, "\ubfbe\uc62d\u4ce7\ud285\u595a\udfe3\u65bb\uec50")),
    PLAYER(a.d("\u6bfb\u1276\u98a8\u06c1\u8d0a\u0bac", 1871463321, 1338320948)),
    RENDER(a.b("\u5295\u2b13\ua1cb\u3fb0\ub466\u32c0", -1417588031)),
    MISC(a.d("\ud5f7\uac62\u26ab\ub8ca", 86891091, 1928400877));

    private final String kfb;
    private static /* synthetic */ int kfc;
    private static /* synthetic */ String kfd;

    private kfa(String string2) {
        this.kfb = string2;
    }

    public String title() {
        return this.kfb;
    }

    private static /* synthetic */ int asv(int n, int n2) {
        return n - n2 | 0x13C0B21D;
    }

    private static /* synthetic */ int asw(int n, int n2) {
        return n * n2 ^ 0x22F98216;
    }

    private static /* synthetic */ int asx(int n, int n2) {
        return kfa.asw(n, n2) + n;
    }
}

