/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tck;
import a.tqa;
import a.trj;
import a.tvq;
import flow.dev.a;
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

public final class ttb {
    public static final int MAGIC = 1177701710;
    public static final int VERSION = 2;
    public tck hand;
    public tqa brain;
    public trj legs;
    public tvq style = new tvq();
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

    public static ttb read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            int n;
            if (dataInputStream.readInt() != 1177701710) {
                throw new IOException(a.d("\ubb20\uc290\u4858\ud67d\u5deb\udb1b\u6105\ue8f0\u76a8\ufc12\u7b84\u81b8\u0f6d\u96d7\u1c85\u9a7d", 2105038156, 981528082));
            }
            int n2 = dataInputStream.readInt();
            if (n2 != 2) {
                throw new IOException(a.d("\u087c\u71ce\ufb15\u6520\ueeba\u6809\ud251\u5ba1\uc5f7\u4f0a\uc88f\u32ed\ubc2d\u259d\uafd4\u2923\u936d\u1cf2", -844173843, 1687938540) + n2);
            }
            ttb ttb2 = new ttb();
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
            ttb2.style = tvq.read(dataInputStream);
            ttb2.brain = tqa.read(dataInputStream);
            if (dataInputStream.readBoolean()) {
                ttb2.legs = trj.read(dataInputStream);
            }
            if ((n = dataInputStream.readInt()) <= 0 || n > 8000000) {
                throw new IOException(a.c(446779379, "\u4f99\u362b\ubcfd\u22c8\ua957\u2fef\u95b3\u1c48"));
            }
            byte[] byArray = new byte[n];
            dataInputStream.readFully(byArray);
            ttb2.hand = tck.read(new ByteArrayInputStream(byArray));
            ttb ttb3 = ttb2;
            return ttb3;
        }
    }

    private static /* synthetic */ int cqp(int n, int n2) {
        return n - n2 ^ 0x1BB37CA4;
    }

    private static /* synthetic */ int cqq(int n, int n2) {
        return ttb.cqp(n, n2) + n;
    }

    private static /* synthetic */ int cqr(int n, int n2) {
        return ttb.cqq(n, n2) * n2;
    }
}

