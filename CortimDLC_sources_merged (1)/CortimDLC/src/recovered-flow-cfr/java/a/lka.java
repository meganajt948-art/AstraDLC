/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package a;

import net.minecraft.client.MinecraftClient;

public final class lka {
    private static final MinecraftClient lkb = MinecraftClient.method_1551();
    private double lkc;
    private double lkd;
    private static /* synthetic */ long lke;
    private static /* synthetic */ String lkf;

    private double lkg() {
        double d = (Double)lka.lkb.field_1690.method_42495().method_41753();
        double d2 = d * 0.6 + 0.2;
        double d3 = d2 * d2 * d2 * 1.2;
        return d3 * 0.15;
    }

    public float fix(float f, boolean bl) {
        double d = this.lkg();
        double d2 = (double)f + (bl ? this.lkc : this.lkd);
        long l = Math.round(d2 / d);
        double d3 = (double)l * d;
        double d4 = d2 - d3;
        if (bl) {
            this.lkc = d4;
        } else {
            this.lkd = d4;
        }
        return (float)d3;
    }

    public void reset() {
        this.lkc = 0.0;
        this.lkd = 0.0;
    }

    private static /* synthetic */ int awy(int n, int n2) {
        return n - n2 + 46735269;
    }

    private static /* synthetic */ int awz(int n, int n2) {
        return lka.awy(n, n2) * n2;
    }

    private static /* synthetic */ int axa(int n, int n2) {
        return lka.awy(n, n2) ^ 0x9D74AA57;
    }
}

