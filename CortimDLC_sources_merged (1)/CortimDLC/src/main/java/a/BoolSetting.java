/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Setting;

public class BoolSetting
extends Setting {
    private final boolean vkm;
    private boolean vkn;
    private static /* synthetic */ boolean vko;
    private static /* synthetic */ long vkp;

    public BoolSetting(String string, boolean bl) {
        super(string);
        this.vkm = bl;
        this.vkn = bl;
    }

    public boolean get() {
        return this.vkn;
    }

    public void set(boolean bl) {
        this.vkn = bl;
    }

    public void toggle() {
        this.vkn = !this.vkn;
    }

    public void reset() {
        this.vkn = this.vkm;
    }

    private static /* synthetic */ int dgj(int n, int n2) {
        return n + n2 | 0xED43E574;
    }

    private static /* synthetic */ int dgk(int n, int n2) {
        return BoolSetting.dgj(n, n2) + n;
    }

    private static /* synthetic */ int dgl(int n, int n2) {
        return BoolSetting.dgj(n, n2) ^ 0xA0A49AC1;
    }
}

