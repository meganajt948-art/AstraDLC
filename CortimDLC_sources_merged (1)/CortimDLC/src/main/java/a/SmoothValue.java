/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class SmoothValue {
    private static final float vcu = 0.004166667f;
    private final float vcv;
    private final float vcw;
    private float vcx;
    private float vcy;
    private boolean vcz;
    private static /* synthetic */ boolean vda;
    private static /* synthetic */ int vdb;

    public SmoothValue(float f, float f2) {
        this.vcv = f;
        this.vcw = 2.0f * f2 * (float)Math.sqrt(f);
    }

    public float step(float f, float f2) {
        float f3;
        if (!this.vcz) {
            this.set(f);
            return this.vcx;
        }
        for (float f4 = f2; f4 > 0.0f; f4 -= f3) {
            f3 = Math.min(f4, 0.004166667f);
            this.vcy += (this.vcv * (f - this.vcx) - this.vcw * this.vcy) * f3;
            this.vcx += this.vcy * f3;
        }
        if (Math.abs(f - this.vcx) < 0.005f && Math.abs(this.vcy) < 0.05f) {
            this.vcx = f;
            this.vcy = 0.0f;
        }
        return this.vcx;
    }

    public float get() {
        return this.vcx;
    }

    public void set(float f) {
        this.vcx = f;
        this.vcy = 0.0f;
        this.vcz = true;
    }

    private static /* synthetic */ int dcz(int n, int n2) {
        return n + n2 | 0x86765277;
    }

    private static /* synthetic */ int dda(int n, int n2) {
        return SmoothValue.dcz(n, n2) * n2;
    }

    private static /* synthetic */ int ddb(int n, int n2) {
        return SmoothValue.dcz(n, n2) ^ 0xEE863FBF;
    }
}

