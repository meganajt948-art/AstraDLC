/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tme;
import flow.dev.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class tmh {
    public static final int MAGIC = 1177702979;
    public static final int VERSION = 1;
    public static final int VALID = 1;
    public static final int GROUND = 2;
    public static final int BREAK = 4;
    public static final int SOURCE_STANDS = 0;
    public static final int SOURCE_FIGHTS = 1;
    public static final int SOURCE_MINE = 2;
    public long created;
    public float unit;
    public double originX;
    public double originY;
    public double originZ;
    public int source;
    public final List<tme> ticks = new ArrayList<tme>();
    private static /* synthetic */ long tmi;
    private static /* synthetic */ boolean tmj;

    public byte[] bytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)byteArrayOutputStream, 65536), 65536));){
            dataOutputStream.writeInt(1177702979);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(this.created);
            dataOutputStream.writeFloat(this.unit);
            dataOutputStream.writeDouble(this.originX);
            dataOutputStream.writeDouble(this.originY);
            dataOutputStream.writeDouble(this.originZ);
            dataOutputStream.writeInt(this.source);
            dataOutputStream.writeInt(this.ticks.size());
            for (tme tme2 : this.ticks) {
                dataOutputStream.writeByte(tme2.flags);
                dataOutputStream.writeFloat(tme2.yaw);
                dataOutputStream.writeFloat(tme2.pitch);
                dataOutputStream.writeFloat(tme2.eyeX);
                dataOutputStream.writeFloat(tme2.eyeY);
                dataOutputStream.writeFloat(tme2.eyeZ);
                dataOutputStream.writeFloat(tme2.cooldown);
                dataOutputStream.writeByte(Math.min(tme2.presses, 127));
                dataOutputStream.writeInt(tme2.hitId);
                if (tme2.hitId != 0) {
                    dataOutputStream.writeFloat(tme2.hitU);
                    dataOutputStream.writeFloat(tme2.hitV);
                }
                int n = Math.min(tme2.ids.length, 255);
                dataOutputStream.writeByte(n);
                for (int i = 0; i < n; ++i) {
                    dataOutputStream.writeInt(tme2.ids[i]);
                    for (int j = 0; j < 5; ++j) {
                        dataOutputStream.writeFloat(tme2.boxes[i * 5 + j]);
                    }
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static tmh read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            if (dataInputStream.readInt() != 1177702979) {
                throw new IOException(a.d("\uf7b3\u8e03\u04cb\u9aee\u1178\u9788\u2d89\ua46f\u3a36\ub08b\u3745\ucd22\u43f8\uda4e\u5014", 873623202, -96036496));
            }
            int n = dataInputStream.readInt();
            if (n != 1) {
                throw new IOException(a.d("\ude3e\ua798\u2d4d\ub330\u38fa\ube5d\u0403\u8df5\u13a3\u9955\u1ed0\ue4b2\u6a72\uf3c2\u798b\uff7c\u4532\ucaad", 581465585, 2006952879) + n);
            }
            tmh tmh2 = new tmh();
            tmh2.created = dataInputStream.readLong();
            tmh2.unit = dataInputStream.readFloat();
            tmh2.originX = dataInputStream.readDouble();
            tmh2.originY = dataInputStream.readDouble();
            tmh2.originZ = dataInputStream.readDouble();
            tmh2.source = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            for (int i = 0; i < n2; ++i) {
                tme tme2 = new tme();
                tme2.flags = dataInputStream.readUnsignedByte();
                tme2.yaw = dataInputStream.readFloat();
                tme2.pitch = dataInputStream.readFloat();
                tme2.eyeX = dataInputStream.readFloat();
                tme2.eyeY = dataInputStream.readFloat();
                tme2.eyeZ = dataInputStream.readFloat();
                tme2.cooldown = dataInputStream.readFloat();
                tme2.presses = dataInputStream.readUnsignedByte();
                tme2.hitId = dataInputStream.readInt();
                if (tme2.hitId != 0) {
                    tme2.hitU = dataInputStream.readFloat();
                    tme2.hitV = dataInputStream.readFloat();
                }
                int n3 = dataInputStream.readUnsignedByte();
                tme2.ids = new int[n3];
                tme2.boxes = new float[n3 * 5];
                for (int j = 0; j < n3; ++j) {
                    tme2.ids[j] = dataInputStream.readInt();
                    for (int k = 0; k < 5; ++k) {
                        tme2.boxes[j * 5 + k] = dataInputStream.readFloat();
                    }
                }
                tmh2.ticks.add(tme2);
            }
            tmh tmh3 = tmh2;
            return tmh3;
        }
    }

    private static /* synthetic */ int cmk(int n, int n2) {
        return n * n2 ^ 0x81D55B5C;
    }
}

