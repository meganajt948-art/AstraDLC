/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class tvq {
    public float sprintShare;
    public float walkBreakShare;
    public float turnCap;
    public float turnRate;
    public float blocksPerMin;
    public float oresPerMin;
    public float farmPerMin;
    public float activeRate;
    public float activeDia;
    public float workShare;
    public float seconds;
    public int hits;
    public int reactionMs;
    private static /* synthetic */ int tvr;
    private static /* synthetic */ long tvs;

    public boolean sprints() {
        return this.sprintShare >= 0.4f;
    }

    public boolean walkMines() {
        return this.walkBreakShare >= 0.25f;
    }

    void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.sprintShare);
        dataOutputStream.writeFloat(this.walkBreakShare);
        dataOutputStream.writeFloat(this.turnCap);
        dataOutputStream.writeFloat(this.turnRate);
        dataOutputStream.writeFloat(this.blocksPerMin);
        dataOutputStream.writeFloat(this.oresPerMin);
        dataOutputStream.writeFloat(this.farmPerMin);
        dataOutputStream.writeFloat(this.activeRate);
        dataOutputStream.writeFloat(this.activeDia);
        dataOutputStream.writeFloat(this.workShare);
        dataOutputStream.writeFloat(this.seconds);
        dataOutputStream.writeInt(this.hits);
        dataOutputStream.writeInt(this.reactionMs);
    }

    static tvq read(DataInputStream dataInputStream) throws IOException {
        tvq tvq2 = new tvq();
        tvq2.sprintShare = dataInputStream.readFloat();
        tvq2.walkBreakShare = dataInputStream.readFloat();
        tvq2.turnCap = dataInputStream.readFloat();
        tvq2.turnRate = dataInputStream.readFloat();
        tvq2.blocksPerMin = dataInputStream.readFloat();
        tvq2.oresPerMin = dataInputStream.readFloat();
        tvq2.farmPerMin = dataInputStream.readFloat();
        tvq2.activeRate = dataInputStream.readFloat();
        tvq2.activeDia = dataInputStream.readFloat();
        tvq2.workShare = dataInputStream.readFloat();
        tvq2.seconds = dataInputStream.readFloat();
        tvq2.hits = dataInputStream.readInt();
        tvq2.reactionMs = dataInputStream.readInt();
        return tvq2;
    }

    private static /* synthetic */ int crw(int n, int n2) {
        return n - n2 ^ 0xA44EF374;
    }

    private static /* synthetic */ int crx(int n, int n2) {
        return n - n2 | 0xD1EF6FF7;
    }

    private static /* synthetic */ int cry(int n, int n2) {
        return tvq.crx(n, n2) + n;
    }
}

