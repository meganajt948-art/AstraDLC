/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.DenseLayer;
import a.WalkFeatures;
import flow.dev.StringDecryptor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class WalkNet {
    public static final int NONE = 0;
    public static final int F = 1;
    public static final int FL = 2;
    public static final int FR = 3;
    public static final int L = 4;
    public static final int R = 5;
    public static final int B = 6;
    public static final int BL = 7;
    public static final int BR = 8;
    public static final int MOVES = 9;
    public static final int[] MIRROR = new int[]{0, 1, 3, 2, 5, 4, 6, 8, 7};
    public static final int[] FWD = new int[]{0, 1, 1, 1, 0, 0, -1, -1, -1};
    public static final int[] LEFT = new int[]{0, 0, 1, -1, 1, -1, 0, 1, -1};
    public static final float[] YAW = WalkNet.tyc(new float[]{0.3f, 0.7f, 1.2f, 1.9f, 2.8f, 4.0f, 5.5f, 7.5f, 10.0f, 13.0f, 17.0f, 22.0f, 29.0f, 38.0f, 52.0f});
    public static final float[] PITCH = WalkNet.tyc(new float[]{0.3f, 0.7f, 1.3f, 2.2f, 3.5f, 5.5f, 9.0f});
    public static final int JUMP = 9;
    public static final int SPRINT = 10;
    public static final int YAW0 = 11;
    public static final int PITCH0 = 11 + YAW.length;
    public static final int OUT = PITCH0 + PITCH.length;
    public final DenseLayer net;
    public final double[] mu = new double[WalkFeatures.N];
    public final double[] sd = new double[WalkFeatures.N];
    private final double[] txw = new double[WalkFeatures.N];
    private double[] txx;
    private double[] txy;
    private final double[] txz = new double[OUT];
    private static /* synthetic */ String tya;
    private static /* synthetic */ long tyb;

    public WalkNet(DenseLayer tbx2) {
        this.net = tbx2;
        Arrays.fill(this.sd, 1.0);
        this.txx = new double[tbx2.h1];
        this.txy = new double[tbx2.h2];
    }

    private static float[] tyc(float[] fArray) {
        float[] fArray2 = new float[fArray.length * 2 + 1];
        int n = fArray.length;
        for (int i = 0; i < fArray.length; ++i) {
            fArray2[n + 1 + i] = fArray[i];
            fArray2[n - 1 - i] = -fArray[i];
        }
        return fArray2;
    }

    public static int bin(float[] fArray, double d) {
        int n = 0;
        double d2 = Double.MAX_VALUE;
        for (int i = 0; i < fArray.length; ++i) {
            double d3 = Math.abs((double)fArray[i] - d);
            if (!(d3 < d2)) continue;
            d2 = d3;
            n = i;
        }
        return n;
    }

    public static double lo(float[] fArray, int n) {
        if (n == 0) {
            return (double)fArray[0] - (double)(fArray[1] - fArray[0]) * 0.5;
        }
        return (double)(fArray[n - 1] + fArray[n]) * 0.5;
    }

    public static double hi(float[] fArray, int n) {
        int n2 = fArray.length;
        if (n == n2 - 1) {
            return (double)fArray[n2 - 1] + (double)(fArray[n2 - 1] - fArray[n2 - 2]) * 0.5;
        }
        return (double)(fArray[n] + fArray[n + 1]) * 0.5;
    }

    public static double draw(float[] fArray, int n, Random random) {
        double d = WalkNet.lo(fArray, n);
        double d2 = WalkNet.hi(fArray, n);
        if (fArray[n] == 0.0f) {
            return (random.nextDouble() - 0.5) * (d2 - d) * 0.6;
        }
        return d + (d2 - d) * random.nextDouble();
    }

    public void normalize(double[] dArray, int n, double[] dArray2) {
        for (int i = 0; i < WalkFeatures.N; ++i) {
            double d = (dArray[n + i] - this.mu[i]) / this.sd[i];
            dArray2[i] = d > 8.0 ? 8.0 : (d < -8.0 ? -8.0 : d);
        }
    }

    public double[] forward(double[] dArray) {
        this.normalize(dArray, 0, this.txw);
        this.net.forward(this.txw, this.txx, this.txy, this.txz);
        return this.txz;
    }

    public static void softmax(double[] dArray, int n, int n2, double d, double[] dArray2) {
        int n3;
        double d2 = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < n2; ++i) {
            d2 = Math.max(d2, dArray[n + i]);
        }
        double d3 = 0.0;
        for (n3 = 0; n3 < n2; ++n3) {
            dArray2[n3] = Math.exp((dArray[n + n3] - d2) / d);
            d3 += dArray2[n3];
        }
        n3 = 0;
        while (n3 < n2) {
            int n4 = n3++;
            dArray2[n4] = dArray2[n4] / d3;
        }
    }

    public static int sample(double[] dArray, int n, Random random) {
        double d = random.nextDouble();
        for (int i = 0; i < n; ++i) {
            if (!((d -= dArray[i]) <= 0.0)) continue;
            return i;
        }
        return n - 1;
    }

    public static double pick(float[] fArray, double[] dArray, int n, double d, double d2, double[] dArray2, Random random) {
        WalkNet.softmax(dArray, n, fArray.length, d, dArray2);
        int n2 = WalkNet.sample(dArray2, fArray.length, random);
        int n3 = Math.max(0, n2 - 1);
        int n4 = Math.min(fArray.length - 1, n2 + 1);
        double d3 = 0.0;
        double d4 = 0.0;
        for (int i = n3; i <= n4; ++i) {
            d3 += dArray2[i];
            d4 += dArray2[i] * (double)fArray[i];
        }
        double d5 = d3 > 0.0 ? d4 / d3 : (double)fArray[n2];
        return d5 + d2 * (WalkNet.draw(fArray, n2, random) - d5);
    }

    public static double sigmoid(double d) {
        return 1.0 / (1.0 + Math.exp(-d));
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(WalkFeatures.N);
        dataOutputStream.writeInt(OUT);
        for (int i = 0; i < WalkFeatures.N; ++i) {
            dataOutputStream.writeFloat((float)this.mu[i]);
            dataOutputStream.writeFloat((float)this.sd[i]);
        }
        this.net.write(dataOutputStream);
    }

    public static WalkNet read(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        int n2 = dataInputStream.readInt();
        if (n != WalkFeatures.N || n2 != OUT) {
            throw new IOException("old model version walk shape");
        }
        double[] dArray = new double[n];
        double[] dArray2 = new double[n];
        for (int i = 0; i < n; ++i) {
            dArray[i] = dataInputStream.readFloat();
            dArray2[i] = dataInputStream.readFloat();
        }
        DenseLayer tbx2 = DenseLayer.read(dataInputStream);
        if (tbx2.in != n || tbx2.out != OUT) {
            throw new IOException("walk shape");
        }
        WalkNet txv2 = new WalkNet(tbx2);
        System.arraycopy(dArray, 0, txv2.mu, 0, n);
        System.arraycopy(dArray2, 0, txv2.sd, 0, n);
        return txv2;
    }

    public WalkNet copy() {
        WalkNet txv2 = new WalkNet(this.net.copy());
        System.arraycopy(this.mu, 0, txv2.mu, 0, this.mu.length);
        System.arraycopy(this.sd, 0, txv2.sd, 0, this.sd.length);
        return txv2;
    }

    private static /* synthetic */ int ctf(int n, int n2) {
        return n * n2 + 1146392429;
    }
}

