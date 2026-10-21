/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.PlayerState;
import a.tut;
import a.tuw;
import a.tuz;
import a.MineSnap;
import flow.dev.StringDecryptor;
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

public final class MineRecordingReader {
    public static final int VALID = 1;
    public static final int GROUND = 2;
    public static final int BREAK = 4;
    public static final int SPRINT = 8;
    public static final int SNEAK = 16;
    public static final int MOVE = 32;
    public static final int ATTACK = 64;
    public static final int K_FWD = 1;
    public static final int K_BACK = 2;
    public static final int K_LEFT = 4;
    public static final int K_RIGHT = 8;
    public static final int K_JUMP = 16;
    public static final int K_SPRINT = 32;
    public static final int K_SNEAK = 64;
    public long created;
    public float unit;
    public int ox;
    public int oy;
    public int oz;
    public final List<tuz> ticks = new ArrayList<tuz>();
    public final List<tuw> hits = new ArrayList<tuw>();
    public final List<tut> decisions = new ArrayList<tut>();
    public static final int MAGIC = 1177701716;
    public static final int VERSION = 1;
    private static /* synthetic */ boolean tvd;
    private static /* synthetic */ String tve;

    public MineRecordingReader frozen() {
        MineRecordingReader tvc2 = new MineRecordingReader();
        tvc2.created = this.created;
        tvc2.unit = this.unit;
        tvc2.ox = this.ox;
        tvc2.oy = this.oy;
        tvc2.oz = this.oz;
        tvc2.ticks.addAll(this.ticks);
        tvc2.hits.addAll(this.hits);
        tvc2.decisions.addAll(this.decisions);
        return tvc2;
    }

    public int validTicks() {
        int n = 0;
        for (tuz tuz2 : this.ticks) {
            if ((tuz2.flags & 1) == 0) continue;
            ++n;
        }
        return n;
    }

    public byte[] bytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(0x100000);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)byteArrayOutputStream, 65536), 65536));){
            dataOutputStream.writeInt(1177701716);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(this.created);
            dataOutputStream.writeFloat(this.unit);
            dataOutputStream.writeInt(this.ox);
            dataOutputStream.writeInt(this.oy);
            dataOutputStream.writeInt(this.oz);
            dataOutputStream.writeInt(this.ticks.size());
            for (tuz object : this.ticks) {
                dataOutputStream.writeShort(object.flags);
                dataOutputStream.writeByte(object.keys);
                dataOutputStream.writeFloat(object.yaw);
                dataOutputStream.writeFloat(object.pitch);
                dataOutputStream.writeFloat(object.x);
                dataOutputStream.writeFloat(object.y);
                dataOutputStream.writeFloat(object.z);
                dataOutputStream.writeFloat(object.vx);
                dataOutputStream.writeFloat(object.vy);
                dataOutputStream.writeFloat(object.vz);
                dataOutputStream.writeInt(object.feetY);
                dataOutputStream.writeShort(object.farm);
                dataOutputStream.writeByte(object.dia);
                dataOutputStream.writeInt(object.sx);
                dataOutputStream.writeInt(object.sy);
                dataOutputStream.writeInt(object.sz);
                dataOutputStream.writeInt(object.snap == null ? -1 : object.snap.length);
                if (object.snap == null) continue;
                dataOutputStream.write(object.snap);
            }
            dataOutputStream.writeInt(this.hits.size());
            for (tuw tuw2 : this.hits) {
                dataOutputStream.writeInt(tuw2.tick);
                dataOutputStream.writeInt(tuw2.x);
                dataOutputStream.writeInt(tuw2.y);
                dataOutputStream.writeInt(tuw2.z);
                dataOutputStream.writeByte(tuw2.face);
                dataOutputStream.writeFloat(tuw2.px);
                dataOutputStream.writeFloat(tuw2.py);
                dataOutputStream.writeFloat(tuw2.pz);
                dataOutputStream.writeByte(tuw2.cell);
            }
            dataOutputStream.writeInt(this.decisions.size());
            for (tut tut2 : this.decisions) {
                dataOutputStream.writeInt(tut2.tick);
                dataOutputStream.writeInt(tut2.hit);
                PlayerState tra2 = tut2.ctx;
                dataOutputStream.writeFloat((float)tra2.ex);
                dataOutputStream.writeFloat((float)tra2.ey);
                dataOutputStream.writeFloat((float)tra2.ez);
                dataOutputStream.writeFloat(tra2.yaw);
                dataOutputStream.writeFloat(tra2.pitch);
                dataOutputStream.writeFloat(tra2.vyaw);
                dataOutputStream.writeFloat(tra2.vpitch);
                dataOutputStream.writeFloat((float)tra2.vx);
                dataOutputStream.writeFloat((float)tra2.vz);
                dataOutputStream.writeBoolean(tra2.ground);
                dataOutputStream.writeInt(tra2.feetY);
                dataOutputStream.writeBoolean(tra2.hasPrev);
                dataOutputStream.writeInt(tra2.px);
                dataOutputStream.writeInt(tra2.py);
                dataOutputStream.writeInt(tra2.pz);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static MineRecordingReader read(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream, 65536), 65536));){
            int n;
            int n2;
            if (dataInputStream.readInt() != 1177701716) {
                throw new IOException("not a mine recording");
            }
            if (dataInputStream.readInt() != 1) {
                throw new IOException("mine recording version");
            }
            MineRecordingReader tvc2 = new MineRecordingReader();
            tvc2.created = dataInputStream.readLong();
            tvc2.unit = dataInputStream.readFloat();
            tvc2.ox = dataInputStream.readInt();
            tvc2.oy = dataInputStream.readInt();
            tvc2.oz = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            if (n3 < 0 || n3 > 2000000) {
                throw new IOException("bad ticks");
            }
            for (n2 = 0; n2 < n3; ++n2) {
                tuz tuz2 = new tuz();
                tuz2.flags = dataInputStream.readUnsignedShort();
                tuz2.keys = dataInputStream.readUnsignedByte();
                tuz2.yaw = dataInputStream.readFloat();
                tuz2.pitch = dataInputStream.readFloat();
                tuz2.x = dataInputStream.readFloat();
                tuz2.y = dataInputStream.readFloat();
                tuz2.z = dataInputStream.readFloat();
                tuz2.vx = dataInputStream.readFloat();
                tuz2.vy = dataInputStream.readFloat();
                tuz2.vz = dataInputStream.readFloat();
                tuz2.feetY = dataInputStream.readInt();
                tuz2.farm = dataInputStream.readShort();
                tuz2.dia = dataInputStream.readByte();
                tuz2.sx = dataInputStream.readInt();
                tuz2.sy = dataInputStream.readInt();
                tuz2.sz = dataInputStream.readInt();
                int n4 = dataInputStream.readInt();
                if (n4 > 4950) {
                    throw new IOException("bad snapshot");
                }
                if (n4 >= 0) {
                    tuz2.snap = new byte[n4];
                    dataInputStream.readFully(tuz2.snap);
                }
                tvc2.ticks.add(tuz2);
            }
            n2 = dataInputStream.readInt();
            if (n2 < 0 || n2 > 2000000) {
                throw new IOException("bad hits");
            }
            for (n = 0; n < n2; ++n) {
                tuw tuw2 = new tuw();
                tuw2.tick = dataInputStream.readInt();
                tuw2.x = dataInputStream.readInt();
                tuw2.y = dataInputStream.readInt();
                tuw2.z = dataInputStream.readInt();
                tuw2.face = dataInputStream.readByte();
                tuw2.px = dataInputStream.readFloat();
                tuw2.py = dataInputStream.readFloat();
                tuw2.pz = dataInputStream.readFloat();
                tuw2.cell = dataInputStream.readByte();
                tvc2.hits.add(tuw2);
            }
            n = dataInputStream.readInt();
            if (n < 0 || n > 2000000) {
                throw new IOException("bad decisions");
            }
            for (int i = 0; i < n; ++i) {
                tut tut2 = new tut();
                tut2.tick = dataInputStream.readInt();
                tut2.hit = dataInputStream.readInt();
                PlayerState tra2 = new PlayerState();
                tra2.ex = dataInputStream.readFloat();
                tra2.ey = dataInputStream.readFloat();
                tra2.ez = dataInputStream.readFloat();
                tra2.yaw = dataInputStream.readFloat();
                tra2.pitch = dataInputStream.readFloat();
                tra2.vyaw = dataInputStream.readFloat();
                tra2.vpitch = dataInputStream.readFloat();
                tra2.vx = dataInputStream.readFloat();
                tra2.vz = dataInputStream.readFloat();
                tra2.ground = dataInputStream.readBoolean();
                tra2.feetY = dataInputStream.readInt();
                tra2.hasPrev = dataInputStream.readBoolean();
                tra2.px = dataInputStream.readInt();
                tra2.py = dataInputStream.readInt();
                tra2.pz = dataInputStream.readInt();
                tut2.ctx = tra2;
                if (tut2.tick < 0 || tut2.tick >= n3 || tut2.hit < 0 || tut2.hit >= n2) continue;
                tvc2.decisions.add(tut2);
            }
            MineRecordingReader tvc3 = tvc2;
            return tvc3;
        }
    }

    public MineSnap snap(int n) {
        tuz tuz2 = this.ticks.get(n);
        return tuz2.snap == null ? null : new MineSnap(tuz2.sx, tuz2.sy, tuz2.sz, MineRecordingReader.unpack(tuz2.snap));
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
            byte[] byArray2 = new byte[2475];
            for (int i = 0; !(i >= byArray2.length || inflater.finished() || (n = inflater.inflate(byArray2, i, byArray2.length - i)) == 0 && (inflater.needsInput() || inflater.needsDictionary())); i += n) {
            }
            byte[] byArray3 = byArray2;
            return byArray3;
        }
        catch (DataFormatException dataFormatException) {
            byte[] byArray4 = new byte[2475];
            return byArray4;
        }
        finally {
            inflater.end();
        }
    }

    private static /* synthetic */ int crl(int n, int n2) {
        return n - n2 ^ 0x88176E21;
    }
}

