/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vmo;

public class vlq
extends vmo {
    private final int vlr;
    private int vls;
    private static /* synthetic */ boolean vlt;
    private static /* synthetic */ String vlu;

    public vlq(String string) {
        this(string, -1);
    }

    public vlq(String string, int n) {
        super(string);
        this.vlr = n;
        this.vls = n;
    }

    public int get() {
        return this.vls;
    }

    public void set(int n) {
        this.vls = n;
    }

    public boolean isBound() {
        return this.vls != -1;
    }

    public void reset() {
        this.vls = this.vlr;
    }

    private static /* synthetic */ int dhl(int n, int n2) {
        return n * n2 | 0x5DC10F66;
    }
}

