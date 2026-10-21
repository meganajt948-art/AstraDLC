/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
import java.util.Locale;

public enum MineRarity {
    COMMON("Обычная", 1),
    MYTHIC("Мифическая", 2),
    LEGENDARY("Легендарная", 3);

    private final String qwk;
    private final int qwl;
    private static /* synthetic */ String qwm;
    private static /* synthetic */ int qwn;

    private MineRarity(String string2, int n2) {
        this.qwk = string2;
        this.qwl = n2;
    }

    public String title() {
        return this.qwk;
    }

    public int rank() {
        return this.qwl;
    }

    public boolean atLeast(MineRarity qwj2) {
        return this.qwl >= qwj2.qwl;
    }

    public static MineRarity parse(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        if (string2.contains("леген")) {
            return LEGENDARY;
        }
        if (string2.contains("миф")) {
            return MYTHIC;
        }
        if (string2.contains("обыч")) {
            return COMMON;
        }
        return null;
    }

    public static MineRarity byTitle(String string) {
        for (MineRarity qwj2 : MineRarity.values()) {
            if (!qwj2.qwk.equalsIgnoreCase(string)) continue;
            return qwj2;
        }
        return COMMON;
    }

    private static /* synthetic */ int bwe(int n, int n2) {
        return n - n2 ^ 0x5B5FDEAA;
    }

    private static /* synthetic */ int bwf(int n, int n2) {
        return MineRarity.bwe(n, n2) + n;
    }

    private static /* synthetic */ int bwg(int n, int n2) {
        return MineRarity.bwe(n, n2) ^ 0x537E881B;
    }
}

