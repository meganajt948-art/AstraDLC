/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector3f
 */
package a;

import a.spg;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.joml.Vector3f;

final class ModelMesh {
    private static final float spp = 0.0625f;
    int shards;
    int vertices;
    int[] start = new int[256];
    int[] count = new int[256];
    float[] center = new float[768];
    float[] pos = new float[24576];
    float[] nrm = new float[24576];
    int[] code = new int[8192];
    private final Random spq;
    private final float[] spr = new float[3];
    private final Vector3f sps = new Vector3f();
    private spg spt;
    private int spu;
    private static /* synthetic */ boolean spv;
    private static /* synthetic */ long spw;

    private ModelMesh(Random random) {
        this.spq = random;
    }

    static ModelMesh build(List<spg> list, boolean bl, Random random) {
        ModelMesh spo2 = new ModelMesh(random);
        if (bl) {
            double d = 0.0;
            for (spg object : list) {
                d += 8.0 * (double)object.hx() * (double)object.hy() * (double)object.hz();
            }
            float f = ModelMesh.sqk((float)Math.cbrt(d / 260.0), 0.1125f, 0.375f);
            for (spg spg2 : list) {
                spo2.sqb(spg2, f);
            }
        } else {
            double d = 0.0;
            for (spg spg3 : list) {
                d += 8.0 * (double)(spg3.hx() * spg3.hy() + spg3.hy() * spg3.hz() + spg3.hx() * spg3.hz());
            }
            float f = ModelMesh.sqk((float)Math.sqrt(2.0 * d / 620.0), 0.1375f, 0.375f);
            for (spg spg4 : list) {
                spo2.spy(spg4, f, 0.046875f);
            }
        }
        return spo2;
    }

    private void spx(spg spg2) {
        this.spt = spg2;
        this.spr[0] = spg2.hx();
        this.spr[1] = spg2.hy();
        this.spr[2] = spg2.hz();
    }

    private void spy(spg spg2, float f, float f2) {
        this.spx(spg2);
        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j >= -1; j -= 2) {
                float[] fArray;
                int n;
                int n2 = (i + 1) % 3;
                int n3 = (i + 2) % 3;
                int n4 = Math.max(1, Math.round(2.0f * this.spr[n2] / f));
                int n5 = Math.max(1, Math.round(2.0f * this.spr[n3] / f));
                float[][][] fArray2 = new float[n4 + 1][n5 + 1][];
                for (int k = 0; k <= n4; ++k) {
                    for (n = 0; n <= n5; ++n) {
                        float f3 = -this.spr[n2] + 2.0f * this.spr[n2] * (float)k / (float)n4;
                        float f4 = -this.spr[n3] + 2.0f * this.spr[n3] * (float)n / (float)n5;
                        if (k > 0 && k < n4) {
                            f3 += (this.spq.nextFloat() - 0.5f) * 1.5f * this.spr[n2] / (float)n4;
                        }
                        if (n > 0 && n < n5) {
                            f4 += (this.spq.nextFloat() - 0.5f) * 1.5f * this.spr[n3] / (float)n5;
                        }
                        fArray = new float[3];
                        fArray[i] = (float)j * this.spr[i];
                        fArray[n2] = f3;
                        fArray[n3] = f4;
                        fArray2[k][n] = fArray;
                    }
                }
                float[] fArray3 = new float[3];
                fArray3[i] = j;
                for (n = 0; n < n4; ++n) {
                    for (int k = 0; k < n5; ++k) {
                        float[] fArray4 = fArray2[n][k];
                        fArray = fArray2[n + 1][k];
                        float[] fArray5 = fArray2[n + 1][k + 1];
                        float[] fArray6 = fArray2[n][k + 1];
                        if (this.spq.nextBoolean()) {
                            this.spz(fArray4, fArray, fArray5, fArray3, f2);
                            this.spz(fArray4, fArray5, fArray6, fArray3, f2);
                            continue;
                        }
                        this.spz(fArray4, fArray, fArray6, fArray3, f2);
                        this.spz(fArray, fArray5, fArray6, fArray3, f2);
                    }
                }
            }
        }
    }

    private void spz(float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float f) {
        float[] fArray5 = ModelMesh.sqf(fArray, fArray4, f);
        float[] fArray6 = ModelMesh.sqf(fArray2, fArray4, f);
        float[] fArray7 = ModelMesh.sqf(fArray3, fArray4, f);
        float f2 = (fArray[0] + fArray2[0] + fArray3[0]) / 3.0f;
        float f3 = (fArray[1] + fArray2[1] + fArray3[1]) / 3.0f;
        float f4 = (fArray[2] + fArray2[2] + fArray3[2]) / 3.0f;
        this.sqg();
        this.sqi(fArray, fArray2, fArray3, fArray4[0], fArray4[1], fArray4[2], this.sqe(fArray2, fArray3), this.sqe(fArray3, fArray), this.sqe(fArray, fArray2), 0);
        this.sqi(fArray5, fArray7, fArray6, -fArray4[0], -fArray4[1], -fArray4[2], 2, 2, 2, 1);
        this.sqa(fArray, fArray2, fArray5, fArray6, fArray4, f2, f3, f4);
        this.sqa(fArray2, fArray3, fArray6, fArray7, fArray4, f2, f3, f4);
        this.sqa(fArray3, fArray, fArray7, fArray5, fArray4, f2, f3, f4);
        this.sqh();
    }

    private void sqa(float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float[] fArray5, float f, float f2, float f3) {
        float f4;
        float f5 = fArray2[1] - fArray[1];
        float f6 = fArray2[2] - fArray[2];
        float f7 = f5 * fArray5[2] - f6 * fArray5[1];
        float f8 = fArray2[0] - fArray[0];
        float f9 = f6 * fArray5[0] - f8 * fArray5[2];
        float f10 = f8 * fArray5[1] - f5 * fArray5[0];
        if (f7 * (fArray[0] - f) + f9 * (fArray[1] - f2) + f10 * (fArray[2] - f3) < 0.0f) {
            f7 = -f7;
            f9 = -f9;
            f10 = -f10;
        }
        if ((f4 = (float)Math.sqrt(f7 * f7 + f9 * f9 + f10 * f10)) < 1.0E-7f) {
            return;
        }
        this.sqi(fArray, fArray2, fArray4, f7 /= f4, f9 /= f4, f10 /= f4, 0, 2, 0, 1);
        this.sqi(fArray, fArray4, fArray3, f7, f9, f10, 0, 0, 2, 1);
    }

    private void sqb(spg spg2, float f) {
        this.spx(spg2);
        int[] nArray = new int[3];
        for (int i = 0; i < 3; ++i) {
            nArray[i] = Math.max(1, Math.round(2.0f * this.spr[i] / f));
        }
        int[] nArray2 = new int[3];
        float[] fArray = new float[3];
        float[] fArray2 = new float[3];
        for (int i = 0; i < nArray[0]; ++i) {
            for (int j = 0; j < nArray[1]; ++j) {
                for (int k = 0; k < nArray[2]; ++k) {
                    int n;
                    nArray2[0] = i;
                    nArray2[1] = j;
                    nArray2[2] = k;
                    for (n = 0; n < 3; ++n) {
                        fArray[n] = -this.spr[n] + 2.0f * this.spr[n] * (float)nArray2[n] / (float)nArray[n];
                        fArray2[n] = -this.spr[n] + 2.0f * this.spr[n] * (float)(nArray2[n] + 1) / (float)nArray[n];
                    }
                    this.sqg();
                    for (n = 0; n < 3; ++n) {
                        for (int i2 = 1; i2 >= -1; i2 -= 2) {
                            int n2 = (n + 1) % 3;
                            int n3 = (n + 2) % 3;
                            boolean bl = i2 > 0 ? nArray2[n] == nArray[n] - 1 : nArray2[n] == 0;
                            float[] fArray3 = ModelMesh.sqc(n, i2, n2, n3, fArray, fArray2, false, false);
                            float[] fArray4 = ModelMesh.sqc(n, i2, n2, n3, fArray, fArray2, true, false);
                            float[] fArray5 = ModelMesh.sqc(n, i2, n2, n3, fArray, fArray2, true, true);
                            float[] fArray6 = ModelMesh.sqc(n, i2, n2, n3, fArray, fArray2, false, true);
                            float f2 = n == 0 ? (float)i2 : 0.0f;
                            float f3 = n == 1 ? (float)i2 : 0.0f;
                            float f4 = n == 2 ? (float)i2 : 0.0f;
                            int n4 = bl ? 0 : 1;
                            this.sqi(fArray3, fArray4, fArray5, f2, f3, f4, this.sqd(bl, fArray4, fArray5), 2, this.sqd(bl, fArray3, fArray4), n4);
                            this.sqi(fArray3, fArray5, fArray6, f2, f3, f4, this.sqd(bl, fArray5, fArray6), this.sqd(bl, fArray6, fArray3), 2, n4);
                        }
                    }
                    this.sqh();
                }
            }
        }
    }

    private static float[] sqc(int n, int n2, int n3, int n4, float[] fArray, float[] fArray2, boolean bl, boolean bl2) {
        float[] fArray3 = new float[3];
        fArray3[n] = n2 > 0 ? fArray2[n] : fArray[n];
        fArray3[n3] = bl ? fArray2[n3] : fArray[n3];
        fArray3[n4] = bl2 ? fArray2[n4] : fArray[n4];
        return fArray3;
    }

    private int sqd(boolean bl, float[] fArray, float[] fArray2) {
        return bl ? this.sqe(fArray, fArray2) : 0;
    }

    private int sqe(float[] fArray, float[] fArray2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (!(Math.abs(Math.abs(fArray[i]) - this.spr[i]) < 1.0E-5f) || !(Math.abs(Math.abs(fArray2[i]) - this.spr[i]) < 1.0E-5f) || fArray[i] > 0.0f != fArray2[i] > 0.0f) continue;
            ++n;
        }
        return n >= 2 ? 1 : 0;
    }

    private static float[] sqf(float[] fArray, float[] fArray2, float f) {
        return new float[]{fArray[0] - fArray2[0] * f, fArray[1] - fArray2[1] * f, fArray[2] - fArray2[2] * f};
    }

    private void sqg() {
        if (this.shards + 1 > this.start.length) {
            int n = this.start.length * 2;
            this.start = Arrays.copyOf(this.start, n);
            this.count = Arrays.copyOf(this.count, n);
            this.center = Arrays.copyOf(this.center, n * 3);
        }
        this.spu = this.vertices;
    }

    private void sqh() {
        int n;
        int n2 = this.vertices - this.spu;
        if (n2 <= 0) {
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (n = this.spu; n < this.vertices; ++n) {
            f += this.pos[n * 3];
            f2 += this.pos[n * 3 + 1];
            f3 += this.pos[n * 3 + 2];
        }
        f /= (float)n2;
        f2 /= (float)n2;
        f3 /= (float)n2;
        for (n = this.spu; n < this.vertices; ++n) {
            int n3 = n * 3;
            this.pos[n3] = this.pos[n3] - f;
            int n4 = n * 3 + 1;
            this.pos[n4] = this.pos[n4] - f2;
            int n5 = n * 3 + 2;
            this.pos[n5] = this.pos[n5] - f3;
        }
        this.start[this.shards] = this.spu;
        this.count[this.shards] = n2;
        this.center[this.shards * 3] = f;
        this.center[this.shards * 3 + 1] = f2;
        this.center[this.shards * 3 + 2] = f3;
        ++this.shards;
    }

    private void sqi(float[] fArray, float[] fArray2, float[] fArray3, float f, float f2, float f3, int n, int n2, int n3, int n4) {
        if (this.vertices + 3 > this.code.length) {
            int n5 = this.code.length * 2;
            this.code = Arrays.copyOf(this.code, n5);
            this.pos = Arrays.copyOf(this.pos, n5 * 3);
            this.nrm = Arrays.copyOf(this.nrm, n5 * 3);
        }
        this.sps.set(f, f2, f3);
        this.spt.normals().transform(this.sps);
        this.sps.normalize();
        float f4 = this.sps.x;
        float f5 = this.sps.y;
        float f6 = this.sps.z;
        int n6 = n + n2 * 3 + n3 * 9 + n4 * 27 << 24;
        this.sqj(fArray, f4, f5, f6, 0xFF | n6);
        this.sqj(fArray2, f4, f5, f6, 0xFF00 | n6);
        this.sqj(fArray3, f4, f5, f6, 0xFF0000 | n6);
    }

    private void sqj(float[] fArray, float f, float f2, float f3, int n) {
        this.sps.set(fArray[0], fArray[1], fArray[2]);
        this.spt.matrix().transformPosition(this.sps);
        int n2 = this.vertices * 3;
        this.pos[n2] = this.sps.x;
        this.pos[n2 + 1] = this.sps.y;
        this.pos[n2 + 2] = this.sps.z;
        this.nrm[n2] = f;
        this.nrm[n2 + 1] = f2;
        this.nrm[n2 + 2] = f3;
        this.code[this.vertices] = n;
        ++this.vertices;
    }

    private static float sqk(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static /* synthetic */ int cfr(int n, int n2) {
        return n + n2 | 0xE7A4A163;
    }
}

