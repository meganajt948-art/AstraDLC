/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.Std140Builder
 */
package a;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.util.Random;

public final class ParticleBuffer {
    private final Random sst = new Random();
    private final float[] ssu = new float[16];
    private final float[] ssv = new float[16];
    private final float[] ssw = new float[16];
    private final float[] ssx = new float[16];
    private final float[] ssy = new float[16];
    private final float[] ssz = new float[16];
    private final boolean[] sta = new boolean[16];
    private float stb;
    private static /* synthetic */ boolean stc;
    private static /* synthetic */ String std;

    public void clear() {
        for (int i = 0; i < 16; ++i) {
            this.sta[i] = false;
        }
        this.stb = 0.0f;
    }

    public void update(float f, float f2, float f3) {
        this.stb += f2 * f;
        while (this.stb >= 1.0f) {
            this.stb -= 1.0f;
            this.ste();
        }
        for (int i = 0; i < 16; ++i) {
            if (!this.sta[i]) continue;
            int n = i;
            this.ssx[n] = this.ssx[n] + f * (1.0f + f3 * 3.0f);
            if (this.ssz[i] > 0.0f && this.ssx[i] > 0.4f) {
                int n2 = i;
                this.ssz[n2] = this.ssz[n2] + f * 0.05f;
                int n3 = i;
                this.ssv[n3] = this.ssv[n3] - this.ssz[i] * f;
            }
            if (!(this.ssx[i] >= this.ssy[i]) && !(this.ssv[i] < -0.05f)) continue;
            this.sta[i] = false;
        }
    }

    private void ste() {
        int n = -1;
        float f = -1.0f;
        for (int i = 0; i < 16; ++i) {
            if (!this.sta[i]) {
                n = i;
                break;
            }
            float f2 = this.ssx[i] / this.ssy[i];
            if (!(f2 > f)) continue;
            f = f2;
            n = i;
        }
        this.ssu[n] = 0.06f + 0.88f * this.sst.nextFloat();
        this.ssv[n] = 0.12f + 0.84f * this.sst.nextFloat();
        float f3 = this.sst.nextFloat();
        this.ssw[n] = 0.018f + 0.05f * f3 * f3;
        this.ssx[n] = 0.0f;
        this.ssy[n] = 1.8f + 2.8f * this.sst.nextFloat();
        this.ssz[n] = this.ssw[n] > 0.013f && this.sst.nextFloat() < 0.55f ? 0.015f + 0.04f * this.sst.nextFloat() : 0.0f;
        this.sta[n] = true;
    }

    public int count() {
        return 16;
    }

    public boolean any() {
        for (boolean bl : this.sta) {
            if (!bl) continue;
            return true;
        }
        return false;
    }

    public void write(Std140Builder std140Builder) {
        for (int i = 0; i < 16; ++i) {
            if (!this.sta[i]) {
                std140Builder.putVec4(0.0f, 0.0f, 0.0f, 0.0f);
                continue;
            }
            float f = this.ssx[i] / this.ssy[i];
            float f2 = Math.min(1.0f, this.ssx[i] / 0.12f);
            float f3 = 1.0f - Math.max(0.0f, (f - 0.65f) / 0.35f);
            std140Builder.putVec4(this.ssu[i], this.ssv[i], this.ssw[i], 0.95f * f2 * f3 * f3);
        }
    }

    private static /* synthetic */ int cgc(int n, int n2) {
        return n * n2 ^ 0xB1B457F8;
    }

    private static /* synthetic */ int cgd(int n, int n2) {
        return ParticleBuffer.cgc(n, n2) * n2;
    }

    private static /* synthetic */ int cge(int n, int n2) {
        return ParticleBuffer.cgc(n, n2) + n;
    }
}

