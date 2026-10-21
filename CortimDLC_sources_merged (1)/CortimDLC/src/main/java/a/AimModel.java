/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.AimFeatures;
import a.DenseLayer;
import a.tch;
import a.AimModelLoaderA;
import a.AimModelLoaderB;
import flow.dev.StringDecryptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class AimModel {
    public static final int MAGIC = 1177701965;
    public static final int VERSION = 4;
    public static final int KIND_AIM = 0;
    public static final int KIND_AURA = 1;
    public static final double[] EDGES = new double[]{0.5, 1.0, 2.0, 4.0, 8.0, 16.0, 32.0, 64.0};
    public static final int BINS = EDGES.length + 1;
    public DenseLayer[] nets = new DenseLayer[0];
    public int lag = 3;
    public float[] qIn = new float[0];
    public float[] qOut = new float[0];
    public float boost = 1.0f;
    public float boostFrom;
    public float boostTo;
    public int flicks;
    public int tracking;
    public final double[] mu = new double[32];
    public final double[] sd = new double[32];
    public boolean mirror;
    public final double[] speedCap = new double[BINS];
    public final double[] accelCap = new double[BINS];
    public float[] aimU = new float[0];
    public float[] aimV = new float[0];
    public float[] resX = new float[0];
    public float[] resY = new float[0];
    public byte[] resBin = new byte[0];
    public boolean[] resLink = new boolean[0];
    public int kind = 0;
    public float[] axes = new float[0];
    public float texX = 1.0f;
    public float texY = 1.0f;
    public float texCap = 0.35f;
    public float texFloor = 0.12f;
    public float turnCap;
    public float[] chainU = new float[0];
    public float[] chainV = new float[0];
    public int[] chainGap = new int[0];
    public int[] reactions = new int[0];
    public long created;
    public int hits;
    public int steps;
    public int epochs;
    public float unit;
    public double similarity;
    public double speedMatch;
    public double timeMatch;
    public double shapeMatch;
    public double overshootModel;
    public double overshootUser;
    public double userPeak;
    public double modelPeak;
    public double userEntry;
    public double modelEntry;
    private int[][] tcl;
    private static AimModel tcm;
    private static boolean tcn;
    private static AimModel tco;
    private static boolean tcp;
    private static /* synthetic */ boolean tcq;
    private static /* synthetic */ int tcr;

    public static synchronized AimModel profile1() {
        if (!tcn) {
            tcn = true;
            try (InputStream inputStream = AimModelLoaderA.open();){
                tcm = AimModel.read(inputStream);
            }
            catch (Exception exception) {
                System.out.println("can't read the aim model: " + exception);
                tcm = null;
            }
        }
        return tcm;
    }

    public static synchronized AimModel profileOld() {
        if (!tcp) {
            tcp = true;
            try (InputStream inputStream = AimModelLoaderB.open();){
                tco = AimModel.read(inputStream);
            }
            catch (Exception exception) {
                System.out.println("can't read the old aim model: " + exception);
                tco = null;
            }
        }
        return tco != null ? tco : AimModel.profile1();
    }

    public static int bin(double d) {
        int n;
        for (n = 0; n < EDGES.length && d >= EDGES[n]; ++n) {
        }
        return n;
    }

    public void raw(double[] dArray, double[] dArray2, tch tch2) {
        AimFeatures.features(dArray, this.mu, this.sd, tch2.x);
        Arrays.fill(tch2.sum, 0.0);
        for (DenseLayer tbx2 : this.nets) {
            tch2.fit(tbx2);
            tbx2.forward(tch2.x, tch2.a1, tch2.a2, tch2.y);
            for (int i = 0; i < 4; ++i) {
                int n = i;
                tch2.sum[n] = tch2.sum[n] + tch2.y[i];
            }
        }
        double d = this.nets.length == 0 ? 0.0 : 1.0 / (double)this.nets.length;
        dArray2[0] = dArray[0] * tch2.sum[0] * d + 2.0 * tch2.sum[2] * d;
        dArray2[1] = dArray[1] * tch2.sum[1] * d + 2.0 * tch2.sum[3] * d;
    }

    public void predict(double[] dArray, double[] dArray2, tch tch2) {
        this.base(dArray, dArray2, tch2);
        this.calibrate(dArray2);
    }

    public void base(double[] dArray, double[] dArray2, tch tch2) {
        this.raw(dArray, dArray2, tch2);
        if (!this.mirror) {
            return;
        }
        double d = dArray2[0];
        double d2 = dArray2[1];
        AimFeatures.mirror(dArray, tch2.m);
        this.raw(tch2.m, dArray2, tch2);
        dArray2[0] = (d - dArray2[0]) * 0.5;
        dArray2[1] = (d2 + dArray2[1]) * 0.5;
    }

    public void calibrate(double[] dArray) {
        double d;
        int n = this.qIn.length;
        if (n < 2) {
            return;
        }
        double d2 = Math.hypot(dArray[0], dArray[1]);
        if (d2 <= (double)this.qIn[0] || d2 < 1.0E-6) {
            return;
        }
        if (d2 >= (double)this.qIn[n - 1]) {
            d = d2 * (double)this.qOut[n - 1] / Math.max(1.0E-6, (double)this.qIn[n - 1]);
        } else {
            int n2;
            for (n2 = 1; n2 < n - 1 && (double)this.qIn[n2] < d2; ++n2) {
            }
            double d3 = this.qIn[n2];
            double d4 = this.qIn[n2 - 1];
            double d5 = d3 - d4 > 1.0E-9 ? (d2 - d4) / (d3 - d4) : 1.0;
            d = (double)this.qOut[n2 - 1] + (double)(this.qOut[n2] - this.qOut[n2 - 1]) * d5;
        }
        double d6 = Math.max(0.6, Math.min(2.0, d / d2));
        if (this.boost != 1.0f && this.boostTo > this.boostFrom) {
            double d7 = Math.max(0.0, Math.min(1.0, (d2 - (double)this.boostFrom) / (double)(this.boostTo - this.boostFrom)));
            d6 *= 1.0 + ((double)this.boost - 1.0) * d7 * d7 * (3.0 - 2.0 * d7);
        }
        dArray[0] = dArray[0] * d6;
        dArray[1] = dArray[1] * d6;
    }

    public double axisScore(int n) {
        return n < this.axes.length ? (double)this.axes[n] : Double.NaN;
    }

    public boolean ownAim() {
        return this.chainU.length > 0;
    }

    public int reaction(Random random) {
        return this.reactions.length < 8 ? -1 : this.reactions[random.nextInt(this.reactions.length)];
    }

    public int[] residualsIn(int n) {
        int n2;
        if (this.tcl == null) {
            int[][] nArrayArray = new int[BINS][];
            int[] nArray = new int[BINS];
            byte[] byArray = this.resBin;
            int n3 = byArray.length;
            for (int i = 0; i < n3; ++i) {
                byte by;
                byte by2 = by = byArray[i];
                nArray[by2] = nArray[by2] + 1;
            }
            for (n2 = 0; n2 < BINS; ++n2) {
                nArrayArray[n2] = new int[nArray[n2]];
                nArray[n2] = 0;
            }
            n2 = 0;
            while (n2 < this.resBin.length) {
                int n4 = n3 = this.resBin[n2];
                int n5 = nArray[n4];
                nArray[n4] = n5 + 1;
                nArrayArray[n3][n5] = n2++;
            }
            this.tcl = nArrayArray;
        }
        for (int i = 0; i < BINS; ++i) {
            int n6 = n - i;
            n2 = n + i;
            if (n6 >= 0 && this.tcl[n6].length > 0) {
                return this.tcl[n6];
            }
            if (n2 >= BINS || this.tcl[n2].length <= 0) continue;
            return this.tcl[n2];
        }
        return new int[0];
    }

    public void write(Path path) throws IOException {
        throw new IOException("neuro disabled");
    }

    public byte[] bytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(262144);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)byteArrayOutputStream, 65536), 65536));){
            int n;
            dataOutputStream.writeInt(1177701965);
            dataOutputStream.writeInt(4);
            dataOutputStream.writeLong(this.created);
            dataOutputStream.writeInt(this.hits);
            dataOutputStream.writeInt(this.steps);
            dataOutputStream.writeInt(this.epochs);
            dataOutputStream.writeFloat(this.unit);
            double[] dArray = new double[]{this.similarity, this.speedMatch, this.timeMatch, this.shapeMatch, this.overshootModel, this.overshootUser, this.userPeak, this.modelPeak, this.userEntry, this.modelEntry};
            dataOutputStream.writeInt(dArray.length);
            for (double d : dArray) {
                dataOutputStream.writeDouble(d);
            }
            dataOutputStream.writeBoolean(this.mirror);
            for (int i = 0; i < 32; ++i) {
                dataOutputStream.writeDouble(this.mu[i]);
                dataOutputStream.writeDouble(this.sd[i]);
            }
            dataOutputStream.writeInt(this.nets.length);
            for (DenseLayer tbx2 : this.nets) {
                tbx2.write(dataOutputStream);
            }
            dataOutputStream.writeInt(this.lag);
            dataOutputStream.writeInt(this.flicks);
            dataOutputStream.writeInt(this.tracking);
            dataOutputStream.writeFloat(this.boost);
            dataOutputStream.writeFloat(this.boostFrom);
            dataOutputStream.writeFloat(this.boostTo);
            dataOutputStream.writeInt(this.qIn.length);
            for (n = 0; n < this.qIn.length; ++n) {
                dataOutputStream.writeFloat(this.qIn[n]);
                dataOutputStream.writeFloat(this.qOut[n]);
            }
            for (n = 0; n < BINS; ++n) {
                dataOutputStream.writeFloat((float)this.speedCap[n]);
                dataOutputStream.writeFloat((float)this.accelCap[n]);
            }
            dataOutputStream.writeInt(this.aimU.length);
            for (n = 0; n < this.aimU.length; ++n) {
                dataOutputStream.writeFloat(this.aimU[n]);
                dataOutputStream.writeFloat(this.aimV[n]);
            }
            dataOutputStream.writeInt(this.resX.length);
            for (n = 0; n < this.resX.length; ++n) {
                dataOutputStream.writeFloat(this.resX[n]);
                dataOutputStream.writeFloat(this.resY[n]);
                dataOutputStream.writeByte(this.resBin[n]);
                dataOutputStream.writeBoolean(this.resLink[n]);
            }
            dataOutputStream.writeInt(this.kind);
            dataOutputStream.writeFloat(this.texX);
            dataOutputStream.writeFloat(this.texY);
            dataOutputStream.writeFloat(this.texCap);
            dataOutputStream.writeFloat(this.texFloor);
            dataOutputStream.writeInt(this.axes.length);
            for (float f : this.axes) {
                dataOutputStream.writeFloat(f);
            }
            dataOutputStream.writeFloat(this.turnCap);
            dataOutputStream.writeInt(this.chainU.length);
            for (int i = 0; i < this.chainU.length; ++i) {
                dataOutputStream.writeFloat(this.chainU[i]);
                dataOutputStream.writeFloat(this.chainV[i]);
                dataOutputStream.writeShort(this.chainGap[i]);
            }
            dataOutputStream.writeInt(this.reactions.length);
            for (int n2 : this.reactions) {
                dataOutputStream.writeByte(n2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static float[] tcs(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        if (n < 0 || n > 4096) {
            throw new IOException("bad array");
        }
        float[] fArray = new float[n];
        for (int i = 0; i < n; ++i) {
            fArray[i] = dataInputStream.readFloat();
        }
        return fArray;
    }

    public static AimModel read(Path path) throws IOException {
        return AimModel.read(Files.newInputStream(path, new OpenOption[0]));
    }

    public static AimModel read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            if (dataInputStream.readInt() != 1177701965) {
                throw new IOException("not a model");
            }
            int n6 = dataInputStream.readInt();
            if (n6 < 2 || n6 > 4) {
                throw new IOException("old model version " + n6);
            }
            AimModel tck2 = new AimModel();
            tck2.created = dataInputStream.readLong();
            tck2.hits = dataInputStream.readInt();
            tck2.steps = dataInputStream.readInt();
            tck2.epochs = dataInputStream.readInt();
            tck2.unit = dataInputStream.readFloat();
            int n7 = dataInputStream.readInt();
            double[] dArray = new double[Math.max(10, n7)];
            for (n5 = 0; n5 < n7; ++n5) {
                dArray[n5] = dataInputStream.readDouble();
            }
            tck2.similarity = dArray[0];
            tck2.speedMatch = dArray[1];
            tck2.timeMatch = dArray[2];
            tck2.shapeMatch = dArray[3];
            tck2.overshootModel = dArray[4];
            tck2.overshootUser = dArray[5];
            tck2.userPeak = dArray[6];
            tck2.modelPeak = dArray[7];
            tck2.userEntry = dArray[8];
            tck2.modelEntry = dArray[9];
            tck2.mirror = dataInputStream.readBoolean();
            for (n5 = 0; n5 < 32; ++n5) {
                tck2.mu[n5] = dataInputStream.readDouble();
                tck2.sd[n5] = dataInputStream.readDouble();
            }
            n5 = dataInputStream.readInt();
            if (n5 <= 0 || n5 > 8) {
                throw new IOException("bad ensemble");
            }
            tck2.nets = new DenseLayer[n5];
            for (n4 = 0; n4 < n5; ++n4) {
                tck2.nets[n4] = DenseLayer.read(dataInputStream);
                if (tck2.nets[n4].in == 32 && tck2.nets[n4].out == 4) continue;
                throw new IOException("model inputs differ");
            }
            tck2.lag = dataInputStream.readInt();
            tck2.flicks = dataInputStream.readInt();
            tck2.tracking = dataInputStream.readInt();
            tck2.boost = dataInputStream.readFloat();
            tck2.boostFrom = dataInputStream.readFloat();
            tck2.boostTo = dataInputStream.readFloat();
            n4 = dataInputStream.readInt();
            if (n4 < 0 || n4 > 256) {
                throw new IOException("bad calibration");
            }
            tck2.qIn = new float[n4];
            tck2.qOut = new float[n4];
            for (n3 = 0; n3 < n4; ++n3) {
                tck2.qIn[n3] = dataInputStream.readFloat();
                tck2.qOut[n3] = dataInputStream.readFloat();
            }
            for (n3 = 0; n3 < BINS; ++n3) {
                tck2.speedCap[n3] = dataInputStream.readFloat();
                tck2.accelCap[n3] = dataInputStream.readFloat();
            }
            n3 = dataInputStream.readInt();
            tck2.aimU = new float[n3];
            tck2.aimV = new float[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                tck2.aimU[n2] = dataInputStream.readFloat();
                tck2.aimV[n2] = dataInputStream.readFloat();
            }
            n2 = dataInputStream.readInt();
            tck2.resX = new float[n2];
            tck2.resY = new float[n2];
            tck2.resBin = new byte[n2];
            tck2.resLink = new boolean[n2];
            for (n = 0; n < n2; ++n) {
                tck2.resX[n] = dataInputStream.readFloat();
                tck2.resY[n] = dataInputStream.readFloat();
                tck2.resBin[n] = (byte)Math.max(0, Math.min(BINS - 1, dataInputStream.readByte()));
                tck2.resLink[n] = dataInputStream.readBoolean();
            }
            if (n6 >= 3) {
                tck2.kind = dataInputStream.readInt();
                tck2.texX = dataInputStream.readFloat();
                tck2.texY = dataInputStream.readFloat();
                tck2.texCap = dataInputStream.readFloat();
                tck2.texFloor = dataInputStream.readFloat();
                tck2.axes = AimModel.tcs(dataInputStream);
            }
            if (n6 >= 4) {
                int n8;
                tck2.turnCap = dataInputStream.readFloat();
                n = dataInputStream.readInt();
                if (n < 0 || n > 100000) {
                    throw new IOException("bad aim chains");
                }
                tck2.chainU = new float[n];
                tck2.chainV = new float[n];
                tck2.chainGap = new int[n];
                for (n8 = 0; n8 < n; ++n8) {
                    tck2.chainU[n8] = dataInputStream.readFloat();
                    tck2.chainV[n8] = dataInputStream.readFloat();
                    tck2.chainGap[n8] = dataInputStream.readUnsignedShort();
                }
                n8 = dataInputStream.readInt();
                if (n8 < 0 || n8 > 100000) {
                    throw new IOException("bad reactions");
                }
                tck2.reactions = new int[n8];
                for (int i = 0; i < n8; ++i) {
                    tck2.reactions[i] = dataInputStream.readUnsignedByte();
                }
            }
            AimModel tck3 = tck2;
            return tck3;
        }
    }

    private static /* synthetic */ int ckl(int n, int n2) {
        return n - n2 + 2010302020;
    }
}

