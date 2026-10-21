/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class DenseLayer {
    public final int in;
    public final int h1;
    public final int h2;
    public final int out;
    public final double[] p;
    private final int tby;
    private final int tbz;
    private final int tca;
    private final int tcb;
    private final int tcc;
    private final int tcd;
    private static /* synthetic */ int tce;
    private static /* synthetic */ String tcf;

    public DenseLayer(int n, int n2, int n3, int n4) {
        this.in = n;
        this.h1 = n2;
        this.h2 = n3;
        this.out = n4;
        this.tby = 0;
        this.tbz = this.tby + n2 * n;
        this.tca = this.tbz + n2;
        this.tcb = this.tca + n3 * n2;
        this.tcc = this.tcb + n3;
        this.tcd = this.tcc + n4 * n3;
        this.p = new double[this.tcd + n4];
    }

    public void init(Random random, double[] dArray) {
        this.tcg(random, this.tby, this.h1 * this.in, Math.sqrt(1.0 / (double)this.in));
        this.tcg(random, this.tca, this.h2 * this.h1, Math.sqrt(1.0 / (double)this.h1));
        this.tcg(random, this.tcc, this.out * this.h2, 0.1 * Math.sqrt(1.0 / (double)this.h2));
        for (int i = 0; i < this.out; ++i) {
            this.p[this.tcd + i] = dArray[i];
        }
    }

    private void tcg(Random random, int n, int n2, double d) {
        for (int i = 0; i < n2; ++i) {
            this.p[n + i] = random.nextGaussian() * d;
        }
    }

    public int size() {
        return this.p.length;
    }

    public DenseLayer copy() {
        DenseLayer tbx2 = new DenseLayer(this.in, this.h1, this.h2, this.out);
        System.arraycopy(this.p, 0, tbx2.p, 0, this.p.length);
        return tbx2;
    }

    public void forward(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
        int n;
        int n2;
        double d;
        int n3;
        for (n3 = 0; n3 < this.h1; ++n3) {
            d = this.p[this.tbz + n3];
            n2 = this.tby + n3 * this.in;
            for (n = 0; n < this.in; ++n) {
                d += this.p[n2 + n] * dArray[n];
            }
            dArray2[n3] = Math.tanh(d);
        }
        for (n3 = 0; n3 < this.h2; ++n3) {
            d = this.p[this.tcb + n3];
            n2 = this.tca + n3 * this.h1;
            for (n = 0; n < this.h1; ++n) {
                d += this.p[n2 + n] * dArray2[n];
            }
            dArray3[n3] = Math.tanh(d);
        }
        for (n3 = 0; n3 < this.out; ++n3) {
            d = this.p[this.tcd + n3];
            n2 = this.tcc + n3 * this.h2;
            for (n = 0; n < this.h2; ++n) {
                d += this.p[n2 + n] * dArray3[n];
            }
            dArray4[n3] = d;
        }
    }

    public void backward(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5, double[] dArray6, double[] dArray7, double[] dArray8) {
        int n;
        int n2;
        double d;
        int n3;
        for (n3 = 0; n3 < this.h2; ++n3) {
            dArray8[n3] = 0.0;
        }
        for (n3 = 0; n3 < this.out; ++n3) {
            d = dArray4[n3];
            if (d == 0.0) continue;
            int n4 = this.tcd + n3;
            dArray5[n4] = dArray5[n4] + d;
            n2 = this.tcc + n3 * this.h2;
            for (n = 0; n < this.h2; ++n) {
                int n5 = n2 + n;
                dArray5[n5] = dArray5[n5] + d * dArray3[n];
                int n6 = n;
                dArray8[n6] = dArray8[n6] + d * this.p[n2 + n];
            }
        }
        for (n3 = 0; n3 < this.h1; ++n3) {
            dArray7[n3] = 0.0;
        }
        for (n3 = 0; n3 < this.h2; ++n3) {
            d = dArray8[n3] * (1.0 - dArray3[n3] * dArray3[n3]);
            int n7 = this.tcb + n3;
            dArray5[n7] = dArray5[n7] + d;
            n2 = this.tca + n3 * this.h1;
            for (n = 0; n < this.h1; ++n) {
                int n8 = n2 + n;
                dArray5[n8] = dArray5[n8] + d * dArray2[n];
                int n9 = n;
                dArray7[n9] = dArray7[n9] + d * this.p[n2 + n];
            }
        }
        if (dArray6 != null) {
            for (n3 = 0; n3 < this.in; ++n3) {
                dArray6[n3] = 0.0;
            }
        }
        for (n3 = 0; n3 < this.h1; ++n3) {
            d = dArray7[n3] * (1.0 - dArray2[n3] * dArray2[n3]);
            int n10 = this.tbz + n3;
            dArray5[n10] = dArray5[n10] + d;
            n2 = this.tby + n3 * this.in;
            for (n = 0; n < this.in; ++n) {
                int n11 = n2 + n;
                dArray5[n11] = dArray5[n11] + d * dArray[n];
                if (dArray6 == null) continue;
                int n12 = n;
                dArray6[n12] = dArray6[n12] + d * this.p[n2 + n];
            }
        }
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.in);
        dataOutputStream.writeInt(this.h1);
        dataOutputStream.writeInt(this.h2);
        dataOutputStream.writeInt(this.out);
        for (double d : this.p) {
            dataOutputStream.writeFloat((float)d);
        }
    }

    public static DenseLayer read(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        int n2 = dataInputStream.readInt();
        int n3 = dataInputStream.readInt();
        int n4 = dataInputStream.readInt();
        if (n <= 0 || n2 <= 0 || n3 <= 0 || n4 <= 0 || n > 256 || n2 > 1024 || n3 > 1024 || n4 > 64) {
            throw new IOException("bad network shape");
        }
        DenseLayer tbx2 = new DenseLayer(n, n2, n3, n4);
        for (int i = 0; i < tbx2.p.length; ++i) {
            tbx2.p[i] = dataInputStream.readFloat();
        }
        return tbx2;
    }

    private static /* synthetic */ int ckc(int n, int n2) {
        return n + n2 | 0x536C3C5A;
    }

    private static /* synthetic */ int ckd(int n, int n2) {
        return n - n2 ^ 0x165CC071;
    }
}

