/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vcq;

public final class vdc {
    private final float vdd;
    private float vde;
    private boolean vdf = true;
    private static /* synthetic */ boolean vdg;
    private static /* synthetic */ boolean vdh;

    public vdc(float f, float f2) {
        this.vdd = Math.max(0.001f, f);
        this.vde = f2;
    }

    public void update(float f) {
        this.vde += (this.vdf ? f : -f) / this.vdd;
        this.vde = vcq.clamp01(this.vde);
    }

    public void forward() {
        this.vdf = true;
    }

    public void backward() {
        this.vdf = false;
    }

    public void restart() {
        this.vde = 0.0f;
        this.vdf = true;
    }

    public boolean isForward() {
        return this.vdf;
    }

    public boolean finished() {
        return this.vdf ? this.vde >= 1.0f : this.vde <= 0.0f;
    }

    public float linear() {
        return this.vde;
    }

    private static /* synthetic */ int dde(int n, int n2) {
        return n * n2 | 0x5F889FD5;
    }

    private static /* synthetic */ int ddf(int n, int n2) {
        return vdc.dde(n, n2) * n2;
    }

    private static /* synthetic */ int ddg(int n, int n2) {
        return vdc.ddf(n, n2) * n2;
    }
}

