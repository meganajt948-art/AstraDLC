/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.txp;
import a.txv;
import flow.dev.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class txs {
    public static final int MAGIC = 1177704269;
    public static final int VERSION = 3;
    public txv net;
    public txp style = new txp();
    public long created;
    public int samples;
    public int valSamples;
    public double keysAcc;
    public double keysBase;
    public double jumpAcc;
    public double sprintAcc;
    public double yawSim;
    public double pitchSim;
    public double yawCeil;
    public double modelJumps;
    public double yawTemp = 0.8;
    public double yawJitter = 0.6;
    public double pitchTemp = 0.8;
    public double pitchJitter = 0.6;
    public double jumpThreshold = 0.3;
    private static /* synthetic */ long txt;
    private static /* synthetic */ long txu;

    public byte[] bytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)byteArrayOutputStream, 65536), 65536));){
            dataOutputStream.writeInt(1177704269);
            dataOutputStream.writeInt(3);
            dataOutputStream.writeLong(this.created);
            dataOutputStream.writeInt(this.samples);
            dataOutputStream.writeInt(this.valSamples);
            dataOutputStream.writeDouble(this.keysAcc);
            dataOutputStream.writeDouble(this.keysBase);
            dataOutputStream.writeDouble(this.jumpAcc);
            dataOutputStream.writeDouble(this.sprintAcc);
            dataOutputStream.writeDouble(this.yawSim);
            dataOutputStream.writeDouble(this.pitchSim);
            dataOutputStream.writeDouble(this.yawCeil);
            dataOutputStream.writeDouble(this.modelJumps);
            dataOutputStream.writeDouble(this.yawTemp);
            dataOutputStream.writeDouble(this.yawJitter);
            dataOutputStream.writeDouble(this.pitchTemp);
            dataOutputStream.writeDouble(this.pitchJitter);
            dataOutputStream.writeDouble(this.jumpThreshold);
            this.style.write(dataOutputStream);
            this.net.write(dataOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static txs read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            if (dataInputStream.readInt() != 1177704269) {
                throw new IOException(a.d("\uff26\u8696\u0c5e\u927b\u19ed\u9f1d\u2519\uacfe\u32ac\ub81a\u3f82\uc5be\u4b6b\ud2d1\u5883\ude7b", -445606313, -280598257));
            }
            int n = dataInputStream.readInt();
            if (n != 3) {
                throw new IOException(a.d("\u3df8\u444a\uce91\u50a4\udb3e\u5d8d\ue7d5\u6e25\uf073\u7a8e\ufd0b\u0769\u89a9\u1019\u9a50\u1ca7\ua6e9\u2976", 1143663020, -352594903) + n);
            }
            txs txs2 = new txs();
            txs2.created = dataInputStream.readLong();
            txs2.samples = dataInputStream.readInt();
            txs2.valSamples = dataInputStream.readInt();
            txs2.keysAcc = dataInputStream.readDouble();
            txs2.keysBase = dataInputStream.readDouble();
            txs2.jumpAcc = dataInputStream.readDouble();
            txs2.sprintAcc = dataInputStream.readDouble();
            txs2.yawSim = dataInputStream.readDouble();
            txs2.pitchSim = dataInputStream.readDouble();
            txs2.yawCeil = dataInputStream.readDouble();
            txs2.modelJumps = dataInputStream.readDouble();
            txs2.yawTemp = dataInputStream.readDouble();
            txs2.yawJitter = dataInputStream.readDouble();
            txs2.pitchTemp = dataInputStream.readDouble();
            txs2.pitchJitter = dataInputStream.readDouble();
            txs2.jumpThreshold = dataInputStream.readDouble();
            txs2.style = txp.read(dataInputStream);
            txs2.net = txv.read(dataInputStream);
            txs txs3 = txs2;
            return txs3;
        }
    }

    private static /* synthetic */ int cta(int n, int n2) {
        return n - n2 ^ 0xEE8DA5F0;
    }

    private static /* synthetic */ int ctb(int n, int n2) {
        return txs.cta(n, n2) + n;
    }

    private static /* synthetic */ int ctc(int n, int n2) {
        return n + n2 | 0x267B69FD;
    }
}

