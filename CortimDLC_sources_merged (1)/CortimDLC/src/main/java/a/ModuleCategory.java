/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;

public enum ModuleCategory {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    RENDER("Render"),
    MISC("Misc");

    private final String kfb;
    private static /* synthetic */ int kfc;
    private static /* synthetic */ String kfd;

    private ModuleCategory(String string2) {
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
        return ModuleCategory.asw(n, n2) + n;
    }
}

