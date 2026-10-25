/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class vcj {
    private static final float vck = 1.7f;
    private final float vcl;
    private float vcm;
    private float vcn;
    private static /* synthetic */ long vco;
    private static /* synthetic */ String vcp;

    public vcj(float f, float f2) {
        this.vcl = f;
        this.vcm = f2;
    }

    public vcj(float f) {
        this(f, 0.0f);
    }

    public float step(float f, float f2) {
        float f3;
        if (f2 <= 0.0f) {
            return this.vcm;
        }
        f2 = Math.min(f2, 0.1f);
        float f4 = this.vcl * 1.7f;
        float f5 = f4 * f2;
        float f6 = 1.0f / (1.0f + f5 + 0.48f * f5 * f5 + 0.235f * f5 * f5 * f5);
        float f7 = this.vcm - f;
        float f8 = (this.vcn + f4 * f7) * f2;
        this.vcn = (this.vcn - f4 * f8) * f6;
        if (f - this.vcm > 0.0f == (f3 = f + (f7 + f8) * f6) > f) {
            f3 = f;
            this.vcn = 0.0f;
        }
        this.vcm = f3;
        if (Math.abs(f - this.vcm) < 5.0E-4f && Math.abs(this.vcn) < 0.01f) {
            this.vcm = f;
            this.vcn = 0.0f;
        }
        return this.vcm;
    }

    public float step(boolean bl, float f) {
        return this.step(bl ? 1.0f : 0.0f, f);
    }

    public float get() {
        return this.vcm;
    }

    public void set(float f) {
        this.vcm = f;
        this.vcn = 0.0f;
    }

    private static /* synthetic */ int dcr(int n, int n2) {
        return n ^ n2 | 0x19D8C88C;
    }

    private static /* synthetic */ int dcs(int n, int n2) {
        return n + n2 + 1499475506;
    }

    private static /* synthetic */ int dct(int n, int n2) {
        return vcj.dcs(n, n2) + n;
    }
}

