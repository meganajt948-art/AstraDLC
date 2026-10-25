/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.tzg;
import a.tzj;
import a.tzm;
import a.tzp;
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
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public final class tzs {
    public static final int VALID = 1;
    public static final int GROUND = 2;
    public static final int BREAK = 4;
    public static final int SPRINT = 8;
    public static final int SNEAK = 16;
    public static final int WATER = 32;
    public static final int CLIMB = 64;
    public static final int COLLIDE = 128;
    public static final int WORK = 256;
    public static final int K_FWD = 1;
    public static final int K_BACK = 2;
    public static final int K_LEFT = 4;
    public static final int K_RIGHT = 8;
    public static final int K_JUMP = 16;
    public static final int K_SPRINT = 32;
    public static final int K_SNEAK = 64;
    public static final int MAGIC = 1177704276;
    public static final int VERSION = 1;
    public long created;
    public float unit;
    public int ox;
    public int oy;
    public int oz;
    public int module;
    public final List<tzp> ticks = new ArrayList<tzp>();
    public final List<tzm> lanes = new ArrayList<tzm>();
    public final List<tzj> snaps = new ArrayList<tzj>();
    private static /* synthetic */ int tzt;
    private static /* synthetic */ long tzu;

    public tzs frozen() {
        tzs tzs2 = new tzs();
        tzs2.created = this.created;
        tzs2.unit = this.unit;
        tzs2.ox = this.ox;
        tzs2.oy = this.oy;
        tzs2.oz = this.oz;
        tzs2.module = this.module;
        tzs2.ticks.addAll(this.ticks);
        tzs2.lanes.addAll(this.lanes);
        tzs2.snaps.addAll(this.snaps);
        return tzs2;
    }

    public int validTicks() {
        int n = 0;
        for (tzp tzp2 : this.ticks) {
            if ((tzp2.flags & 1) == 0 || (tzp2.flags & 0x100) != 0 || tzp2.route < 0) continue;
            ++n;
        }
        return n;
    }

    public tzg snap(int n) {
        if (n < 0 || n >= this.snaps.size()) {
            return null;
        }
        tzj tzj2 = this.snaps.get(n);
        return new tzg(tzj2.x0, tzj2.y0, tzj2.z0, tzs.unpack(tzj2.packed));
    }

    public byte[] bytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(262144);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)byteArrayOutputStream, 65536), 65536));){
            dataOutputStream.writeInt(1177704276);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(this.created);
            dataOutputStream.writeFloat(this.unit);
            dataOutputStream.writeInt(this.ox);
            dataOutputStream.writeInt(this.oy);
            dataOutputStream.writeInt(this.oz);
            dataOutputStream.writeInt(this.module);
            dataOutputStream.writeInt(this.lanes.size());
            for (tzm object : this.lanes) {
                dataOutputStream.writeByte(object.goal);
                dataOutputStream.writeInt(object.x.length);
                for (int i = 0; i < object.x.length; ++i) {
                    dataOutputStream.writeFloat(object.x[i]);
                    dataOutputStream.writeFloat(object.y[i]);
                    dataOutputStream.writeFloat(object.z[i]);
                    dataOutputStream.writeByte(object.flag[i]);
                }
            }
            dataOutputStream.writeInt(this.snaps.size());
            for (tzj tzj2 : this.snaps) {
                dataOutputStream.writeInt(tzj2.x0);
                dataOutputStream.writeInt(tzj2.y0);
                dataOutputStream.writeInt(tzj2.z0);
                dataOutputStream.writeInt(tzj2.packed.length);
                dataOutputStream.write(tzj2.packed);
            }
            dataOutputStream.writeInt(this.ticks.size());
            for (tzp tzp2 : this.ticks) {
                dataOutputStream.writeShort(tzp2.flags);
                dataOutputStream.writeByte(tzp2.keys);
                dataOutputStream.writeFloat(tzp2.yaw);
                dataOutputStream.writeFloat(tzp2.pitch);
                dataOutputStream.writeFloat(tzp2.x);
                dataOutputStream.writeFloat(tzp2.y);
                dataOutputStream.writeFloat(tzp2.z);
                dataOutputStream.writeFloat(tzp2.vx);
                dataOutputStream.writeFloat(tzp2.vy);
                dataOutputStream.writeFloat(tzp2.vz);
                dataOutputStream.writeFloat(tzp2.speed);
                dataOutputStream.writeByte(tzp2.food);
                dataOutputStream.writeInt(tzp2.route);
                dataOutputStream.writeInt(tzp2.snap);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static tzs read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            int n;
            int n2;
            int n3;
            if (dataInputStream.readInt() != 1177704276) {
                throw new IOException(a.b("\u6819\u11a9\u9b61\u0544\u8ed2\u0822\ub226\u3bc1\ua593\u2f25\ua8bd\u529e\udc5e\u45e9\ucfb6\u495a\uf303\u7cdf\ue66b\u6033", 1706125411));
            }
            if (dataInputStream.readInt() != 1) {
                throw new IOException(a.d("\u73ba\u0a1d\u80c3\u1eb5\u9529\u13ca\ua98e\u2079\ube2a\u3486\ub343\u493f\uc7ef\u5e57\ud443\u52e4\ue8b8\u677e\ufdcc\u7b87\uf276\u8826", 1233421286, -1549340611));
            }
            tzs tzs2 = new tzs();
            tzs2.created = dataInputStream.readLong();
            tzs2.unit = dataInputStream.readFloat();
            tzs2.ox = dataInputStream.readInt();
            tzs2.oy = dataInputStream.readInt();
            tzs2.oz = dataInputStream.readInt();
            tzs2.module = dataInputStream.readInt();
            int n4 = dataInputStream.readInt();
            if (n4 < 0 || n4 > 500000) {
                throw new IOException(a.c(1899889150, "\u0195\u7827\uf2f1\u6cc4\ue75f\u61e3\udbbf\u5245\ucc0c"));
            }
            for (n3 = 0; n3 < n4; ++n3) {
                tzm tzm2 = new tzm();
                tzm2.goal = dataInputStream.readByte();
                int n5 = dataInputStream.readInt();
                if (n5 < 0 || n5 > 100000) {
                    throw new IOException(a.b("\u497e\u30cc\uba1a\u242f\uafb4\u2908\u9354\u1aae", -2056566508));
                }
                tzm2.x = new float[n5];
                tzm2.y = new float[n5];
                tzm2.z = new float[n5];
                tzm2.flag = new byte[n5];
                for (n2 = 0; n2 < n5; ++n2) {
                    tzm2.x[n2] = dataInputStream.readFloat();
                    tzm2.y[n2] = dataInputStream.readFloat();
                    tzm2.z[n2] = dataInputStream.readFloat();
                    tzm2.flag[n2] = dataInputStream.readByte();
                }
                tzs2.lanes.add(tzm2);
            }
            n3 = dataInputStream.readInt();
            if (n3 < 0 || n3 > 2000000) {
                throw new IOException(a.d("\uf4f0\u8d42\u0794\u99a1\u1225\u9489\u2ed5\ua735\u3969", 1985625102, -15677291));
            }
            for (n = 0; n < n3; ++n) {
                tzj tzj2 = new tzj();
                tzj2.x0 = dataInputStream.readInt();
                tzj2.y0 = dataInputStream.readInt();
                tzj2.z0 = dataInputStream.readInt();
                n2 = dataInputStream.readInt();
                if (n2 < 0 || n2 > 2366) {
                    throw new IOException(a.c(642007241, "\u40a3\u3911\ub3c7\u2df2\ua676\u20da\u9a86\u1366"));
                }
                tzj2.packed = new byte[n2];
                dataInputStream.readFully(tzj2.packed);
                tzs2.snaps.add(tzj2);
            }
            n = dataInputStream.readInt();
            if (n < 0 || n > 4000000) {
                throw new IOException(a.d("\uec59\u95eb\u1f3d\u8108\u0a8b\u8c27\u367e\ubf87\u21c0", -1092893306, 1182738868));
            }
            for (int i = 0; i < n; ++i) {
                tzp tzp2 = new tzp();
                tzp2.flags = dataInputStream.readUnsignedShort();
                tzp2.keys = dataInputStream.readUnsignedByte();
                tzp2.yaw = dataInputStream.readFloat();
                tzp2.pitch = dataInputStream.readFloat();
                tzp2.x = dataInputStream.readFloat();
                tzp2.y = dataInputStream.readFloat();
                tzp2.z = dataInputStream.readFloat();
                tzp2.vx = dataInputStream.readFloat();
                tzp2.vy = dataInputStream.readFloat();
                tzp2.vz = dataInputStream.readFloat();
                tzp2.speed = dataInputStream.readFloat();
                tzp2.food = dataInputStream.readUnsignedByte();
                tzp2.route = dataInputStream.readInt();
                tzp2.snap = dataInputStream.readInt();
                if (tzp2.route >= n4) {
                    tzp2.route = -1;
                }
                if (tzp2.snap >= n3) {
                    tzp2.snap = -1;
                }
                tzs2.ticks.add(tzp2);
            }
            tzs tzs3 = tzs2;
            return tzs3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] pack(byte[] byArray) {
        Deflater deflater = new Deflater(1, true);
        try {
            deflater.setInput(byArray);
            deflater.finish();
            byte[] byArray2 = new byte[byArray.length + 64];
            int n = 0;
            while (!deflater.finished()) {
                if (n == byArray2.length) {
                    byArray2 = Arrays.copyOf(byArray2, byArray2.length * 2);
                }
                n += deflater.deflate(byArray2, n, byArray2.length - n);
            }
            byte[] byArray3 = Arrays.copyOf(byArray2, n);
            return byArray3;
        }
        finally {
            deflater.end();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] unpack(byte[] byArray) {
        Inflater inflater = new Inflater(true);
        try {
            int n;
            inflater.setInput(byArray);
            byte[] byArray2 = new byte[1183];
            for (int i = 0; !(i >= byArray2.length || inflater.finished() || (n = inflater.inflate(byArray2, i, byArray2.length - i)) == 0 && (inflater.needsInput() || inflater.needsDictionary())); i += n) {
            }
            byte[] byArray3 = byArray2;
            return byArray3;
        }
        catch (DataFormatException dataFormatException) {
            byte[] byArray4 = new byte[1183];
            return byArray4;
        }
        finally {
            inflater.end();
        }
    }

    public static int move(int n) {
        boolean bl;
        boolean bl2 = (n & 1) != 0 && (n & 2) == 0;
        boolean bl3 = (n & 2) != 0 && (n & 1) == 0;
        boolean bl4 = (n & 4) != 0 && (n & 8) == 0;
        boolean bl5 = bl = (n & 8) != 0 && (n & 4) == 0;
        if (bl2) {
            return bl4 ? 2 : (bl ? 3 : 1);
        }
        if (bl3) {
            return bl4 ? 7 : (bl ? 8 : 6);
        }
        return bl4 ? 4 : (bl ? 5 : 0);
    }

    private static /* synthetic */ int cue(int n, int n2) {
        return n ^ n2 | 0x40747F68;
    }

    private static /* synthetic */ int cuf(int n, int n2) {
        return tzs.cue(n, n2) ^ 0x269AB536;
    }
}

