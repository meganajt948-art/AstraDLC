/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.MineGrid;
import flow.dev.StringDecryptor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class Mlp {
    public final int in;
    public final int hidden;
    public final double[] p;
    public final double[] mu;
    public final double[] sd;
    private final int tqb;
    private final int tqc;
    private final int tqd;
    private static /* synthetic */ boolean tqe;
    private static /* synthetic */ String tqf;

    public Mlp(int n, int n2) {
        this.in = n;
        this.hidden = n2;
        this.tqb = n2 * n;
        this.tqc = this.tqb + n2;
        this.tqd = this.tqc + n2;
        this.p = new double[this.tqd + 1];
        this.mu = new double[n];
        this.sd = new double[n];
        Arrays.fill(this.sd, 1.0);
    }

    public void init(Random random) {
        double d = Math.sqrt(1.0 / (double)this.in);
        for (int i = 0; i < this.tqb; ++i) {
            this.p[i] = random.nextGaussian() * d;
        }
        double d2 = 0.3 * Math.sqrt(1.0 / (double)this.hidden);
        for (int i = 0; i < this.hidden; ++i) {
            this.p[this.tqc + i] = random.nextGaussian() * d2;
        }
    }

    public Mlp copy() {
        Mlp tqa2 = new Mlp(this.in, this.hidden);
        System.arraycopy(this.p, 0, tqa2.p, 0, this.p.length);
        System.arraycopy(this.mu, 0, tqa2.mu, 0, this.in);
        System.arraycopy(this.sd, 0, tqa2.sd, 0, this.in);
        return tqa2;
    }

    public void normalize(double[] dArray, int n, double[] dArray2, int n2) {
        for (int i = 0; i < this.in; ++i) {
            dArray2[n2 + i] = Math.max(-8.0, Math.min(8.0, (dArray[n + i] - this.mu[i]) / this.sd[i]));
        }
    }

    void silence(int n) {
        for (int i = 0; i < this.hidden; ++i) {
            this.p[i * this.in + n] = 0.0;
        }
    }

    double forward(double[] dArray, int n, double[] dArray2) {
        double d = this.p[this.tqd];
        for (int i = 0; i < this.hidden; ++i) {
            double d2 = this.p[this.tqb + i];
            int n2 = i * this.in;
            for (int j = 0; j < this.in; ++j) {
                d2 += this.p[n2 + j] * dArray[n + j];
            }
            dArray2[i] = Math.tanh(d2);
            d += this.p[this.tqc + i] * dArray2[i];
        }
        return d;
    }

    void backward(double[] dArray, int n, double[] dArray2, double d, double[] dArray3) {
        int n2 = this.tqd;
        dArray3[n2] = dArray3[n2] + d;
        for (int i = 0; i < this.hidden; ++i) {
            int n3 = this.tqc + i;
            dArray3[n3] = dArray3[n3] + d * dArray2[i];
            double d2 = d * this.p[this.tqc + i] * (1.0 - dArray2[i] * dArray2[i]);
            if (d2 == 0.0) continue;
            int n4 = this.tqb + i;
            dArray3[n4] = dArray3[n4] + d2;
            int n5 = i * this.in;
            for (int j = 0; j < this.in; ++j) {
                int n6 = n5 + j;
                dArray3[n6] = dArray3[n6] + d2 * dArray[n + j];
            }
        }
    }

    public double[] scores(MineGrid tpn2) {
        double[] dArray = new double[tpn2.n];
        double[] dArray2 = new double[this.in];
        double[] dArray3 = new double[this.hidden];
        for (int i = 0; i < tpn2.n; ++i) {
            this.normalize(tpn2.f, i * 32, dArray2, 0);
            dArray[i] = this.forward(dArray2, 0, dArray3);
        }
        return dArray;
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.in);
        dataOutputStream.writeInt(this.hidden);
        for (int i = 0; i < this.in; ++i) {
            dataOutputStream.writeFloat((float)this.mu[i]);
            dataOutputStream.writeFloat((float)this.sd[i]);
        }
        for (double d : this.p) {
            dataOutputStream.writeFloat((float)d);
        }
    }

    public static Mlp read(DataInputStream dataInputStream) throws IOException {
        int n;
        int n2 = dataInputStream.readInt();
        int n3 = dataInputStream.readInt();
        if (n2 != 32 || n3 <= 0 || n3 > 256) {
            throw new IOException("choice shape");
        }
        Mlp tqa2 = new Mlp(n2, n3);
        for (n = 0; n < n2; ++n) {
            tqa2.mu[n] = dataInputStream.readFloat();
            tqa2.sd[n] = dataInputStream.readFloat();
        }
        for (n = 0; n < tqa2.p.length; ++n) {
            tqa2.p[n] = dataInputStream.readFloat();
        }
        return tqa2;
    }

    private static /* synthetic */ int cog(int n, int n2) {
        return n - n2 | 0xEAC36FF;
    }

    private static /* synthetic */ int coh(int n, int n2) {
        return n - n2 | 0x65AEE20E;
    }
}

