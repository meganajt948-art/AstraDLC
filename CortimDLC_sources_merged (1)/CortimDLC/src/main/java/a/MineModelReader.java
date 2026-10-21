/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.AimModel;
import a.Mlp;
import a.LegsNet;
import a.MineStyleStats;
import flow.dev.StringDecryptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class MineModelReader {
    public static final int MAGIC = 1177701710;
    public static final int VERSION = 2;
    public AimModel hand;
    public Mlp brain;
    public LegsNet legs;
    public MineStyleStats style = new MineStyleStats();
    public long created;
    public double top1;
    public double top3;
    public double base1;
    public double nll;
    public int events;
    public int valEvents;
    public double legsAcc;
    public double legsBase;
    public double legsJump;
    public double legsSprint;
    public int legsSamples;
    public int boost;
    private static /* synthetic */ boolean ttc;
    private static /* synthetic */ boolean ttd;

    public byte[] bytes() throws IOException {
        byte[] byArray = this.hand.bytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)byteArrayOutputStream, 65536), 65536));){
            dataOutputStream.writeInt(1177701710);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeLong(this.created);
            dataOutputStream.writeDouble(this.top1);
            dataOutputStream.writeDouble(this.top3);
            dataOutputStream.writeDouble(this.base1);
            dataOutputStream.writeDouble(this.nll);
            dataOutputStream.writeInt(this.events);
            dataOutputStream.writeInt(this.valEvents);
            dataOutputStream.writeDouble(this.legsAcc);
            dataOutputStream.writeDouble(this.legsBase);
            dataOutputStream.writeDouble(this.legsJump);
            dataOutputStream.writeDouble(this.legsSprint);
            dataOutputStream.writeInt(this.legsSamples);
            dataOutputStream.writeInt(this.boost);
            this.style.write(dataOutputStream);
            this.brain.write(dataOutputStream);
            dataOutputStream.writeBoolean(this.legs != null);
            if (this.legs != null) {
                this.legs.write(dataOutputStream);
            }
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static MineModelReader read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            int n;
            if (dataInputStream.readInt() != 1177701710) {
                throw new IOException("not a mine model");
            }
            int n2 = dataInputStream.readInt();
            if (n2 != 2) {
                throw new IOException("old model version " + n2);
            }
            MineModelReader ttb2 = new MineModelReader();
            ttb2.created = dataInputStream.readLong();
            ttb2.top1 = dataInputStream.readDouble();
            ttb2.top3 = dataInputStream.readDouble();
            ttb2.base1 = dataInputStream.readDouble();
            ttb2.nll = dataInputStream.readDouble();
            ttb2.events = dataInputStream.readInt();
            ttb2.valEvents = dataInputStream.readInt();
            ttb2.legsAcc = dataInputStream.readDouble();
            ttb2.legsBase = dataInputStream.readDouble();
            ttb2.legsJump = dataInputStream.readDouble();
            ttb2.legsSprint = dataInputStream.readDouble();
            ttb2.legsSamples = dataInputStream.readInt();
            ttb2.boost = dataInputStream.readInt();
            ttb2.style = MineStyleStats.read(dataInputStream);
            ttb2.brain = Mlp.read(dataInputStream);
            if (dataInputStream.readBoolean()) {
                ttb2.legs = LegsNet.read(dataInputStream);
            }
            if ((n = dataInputStream.readInt()) <= 0 || n > 8000000) {
                throw new IOException("bad hand");
            }
            byte[] byArray = new byte[n];
            dataInputStream.readFully(byArray);
            ttb2.hand = AimModel.read(new ByteArrayInputStream(byArray));
            MineModelReader ttb3 = ttb2;
            return ttb3;
        }
    }

    private static /* synthetic */ int cqp(int n, int n2) {
        return n - n2 ^ 0x1BB37CA4;
    }

    private static /* synthetic */ int cqq(int n, int n2) {
        return MineModelReader.cqp(n, n2) + n;
    }

    private static /* synthetic */ int cqr(int n, int n2) {
        return MineModelReader.cqq(n, n2) * n2;
    }
}

