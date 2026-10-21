/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Easing;

public final class Tween {
    private final float vdd;
    private float vde;
    private boolean vdf = true;
    private static /* synthetic */ boolean vdg;
    private static /* synthetic */ boolean vdh;

    public Tween(float f, float f2) {
        this.vdd = Math.max(0.001f, f);
        this.vde = f2;
    }

    public void update(float f) {
        this.vde += (this.vdf ? f : -f) / this.vdd;
        this.vde = Easing.clamp01(this.vde);
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
        return Tween.dde(n, n2) * n2;
    }

    private static /* synthetic */ int ddg(int n, int n2) {
        return Tween.ddf(n, n2) * n2;
    }
}

