/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.pzc;
import a.tbp;
import a.tpn;
import a.tra;
import a.trd;
import a.trg;
import a.trj;
import a.tsh;
import a.ttb;
import a.tvn;
import java.util.Arrays;
import java.util.Random;
import java.util.function.LongPredicate;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class toq {
    private static final double tor = 0.6;
    private static final double tos = 0.12;
    private static final double tot = 0.0016666666666666668;
    public final ttb model;
    private final Random tou = new Random();
    private final float[] tov = new float[3];
    private final float[] tow = new float[3];
    private final int[] tox = new int[2];
    private final int[] toy = new int[2];
    private final double[] toz = new double[71];
    private final double[] tpa = new double[11];
    private int tpb;
    private tvn tpc;
    private tvn tpd;
    private double tpe;
    private int tpf = 0;
    private boolean tpg;
    private boolean tph;
    public long farmed;
    public long farmedDia;
    private long tpi;
    private double tpj;
    private double tpk = -1.0;
    private static /* synthetic */ int tpl;
    private static /* synthetic */ int tpm;

    public toq(ttb ttb2) {
        this.model = ttb2;
    }

    public void boost(double d) {
        this.tpe = Math.max(0.0, Math.min(0.3, d));
    }

    public double turnRate() {
        return Math.max(8.0, (double)this.model.style.turnRate * (1.0 + this.tpe));
    }

    public void reset() {
        this.tpb = 0;
        this.tpd = null;
        this.tpc = null;
        this.tpf = 0;
    }

    public void tick(World world, ClientPlayerEntity clientPlayerEntity, pzc pzc2) {
        this.tov[2] = this.tov[1];
        this.tov[1] = this.tov[0];
        this.tov[0] = clientPlayerEntity.getYaw();
        this.tow[2] = this.tow[1];
        this.tow[1] = this.tow[0];
        this.tow[0] = clientPlayerEntity.getPitch();
        ++this.tpb;
        this.tpc = tsh.snap(world, clientPlayerEntity, clientPlayerEntity.getBlockPos(), pzc2, null, null);
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        trd.diff(this.tpd, this.tpc, vec3d.x, vec3d.y, vec3d.z, this.tox);
        this.farmed += (long)this.tox[0];
        this.farmedDia += (long)this.tox[1];
        trd.reach(this.tpc, vec3d.x, vec3d.y, vec3d.z, this.toy);
        if (this.toy[0] >= 8) {
            double d = trd.value(this.tox[0], this.tox[1]);
            ++this.tpi;
            this.tpj += d;
            this.tpk = this.tpi < 400L ? this.tpj / (double)this.tpi * 1200.0 : (this.tpk += (d * 1200.0 - this.tpk) * 0.0016666666666666668);
        }
        this.tpd = this.tpc;
    }

    public double rate() {
        return this.tpi < 100L ? -1.0 : this.tpk;
    }

    public double ratio() {
        double d = this.rate();
        double d2 = this.model.style.activeRate;
        return d < 0.0 || d2 <= 0.0 ? Double.NaN : d / d2;
    }

    public boolean hasLegs() {
        return this.model.legs != null;
    }

    public void planLegs(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        if (this.model.legs == null || this.tpc == null) {
            this.tpf = 0;
            this.tpg = false;
            this.tph = false;
            return;
        }
        trg trg2 = new trg();
        trg2.px = clientPlayerEntity.getX();
        trg2.py = clientPlayerEntity.getY();
        trg2.pz = clientPlayerEntity.getZ();
        trg2.eyeY = clientPlayerEntity.getEyeY();
        trg2.yaw = clientPlayerEntity.getYaw();
        trg2.pitch = clientPlayerEntity.getPitch();
        trg2.vx = clientPlayerEntity.getX() - clientPlayerEntity.lastX;
        trg2.vy = clientPlayerEntity.getY() - clientPlayerEntity.lastY;
        trg2.vz = clientPlayerEntity.getZ() - clientPlayerEntity.lastZ;
        trg2.ground = clientPlayerEntity.isOnGround();
        trg2.feetY = tsh.standing(world, clientPlayerEntity).getY();
        if (blockPos != null) {
            trg2.hasTarget = true;
            trg2.tx = blockPos.getX();
            trg2.ty = blockPos.getY();
            trg2.tz = blockPos.getZ();
        }
        trj.features(this.tpc, trg2, this.toz, 0);
        this.model.legs.decide(this.toz, this.tpa);
        int n = 0;
        for (int i = 1; i < 9; ++i) {
            if (!(this.tpa[i] > this.tpa[n])) continue;
            n = i;
        }
        if (n != this.tpf && this.tpa[n] < this.tpa[this.tpf] + 0.12) {
            n = this.tpf;
        }
        this.tpf = n;
        this.tpg = this.tpa[9] > 0.5;
        this.tph = this.tpa[10] > 0.5;
    }

    public void stopLegs() {
        this.tpf = 0;
        this.tpg = false;
        this.tph = false;
    }

    public int move() {
        return this.tpf;
    }

    public boolean jump() {
        return this.tpg;
    }

    public boolean sprint() {
        return this.tph;
    }

    public long[] rank(World world, ClientPlayerEntity clientPlayerEntity, pzc pzc2, LongPredicate longPredicate, LongPredicate longPredicate2, BlockPos blockPos, int n3) {
        int n4;
        tvn tvn2 = tsh.snap(world, clientPlayerEntity, clientPlayerEntity.getBlockPos(), pzc2, longPredicate, longPredicate2);
        tra tra2 = new tra();
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        tra2.ex = vec3d.x;
        tra2.ey = vec3d.y;
        tra2.ez = vec3d.z;
        tra2.yaw = clientPlayerEntity.getYaw();
        tra2.pitch = clientPlayerEntity.getPitch();
        if (this.tpb >= 3) {
            tra2.vyaw = (float)(tbp.wrap(this.tov[0] - this.tov[2]) * 0.5);
            tra2.vpitch = (this.tow[0] - this.tow[2]) * 0.5f;
        } else if (this.tpb == 2) {
            tra2.vyaw = (float)tbp.wrap(this.tov[0] - this.tov[1]);
            tra2.vpitch = this.tow[0] - this.tow[1];
        }
        tra2.vx = clientPlayerEntity.getX() - clientPlayerEntity.lastX;
        tra2.vz = clientPlayerEntity.getZ() - clientPlayerEntity.lastZ;
        tra2.ground = clientPlayerEntity.isOnGround();
        tra2.feetY = tsh.standing(world, clientPlayerEntity).getY();
        if (blockPos != null) {
            tra2.hasPrev = true;
            tra2.px = blockPos.getX();
            tra2.py = blockPos.getY();
            tra2.pz = blockPos.getZ();
        }
        tpn tpn2 = tpn.of(tvn2, tra2);
        int n5 = tpn2.n;
        if (n5 == 0) {
            return new long[0];
        }
        double[] dArray = this.model.brain.scores(tpn2);
        double d = 0.6 - this.tpe;
        double d2 = this.tpe * 3.0;
        for (int i = 0; i < n5; ++i) {
            int n6 = i * 32;
            double d3 = (tpn2.f[n6 + 16] * 8.0 + 4.0 * tpn2.f[n6 + 17] * 3.0 + 6.0 * tpn2.f[n6 + 11]) / 10.0;
            dArray[i] = dArray[i] / d + d2 * d3;
        }
        double d4 = Double.NEGATIVE_INFINITY;
        for (double d5 : dArray) {
            d4 = Math.max(d4, d5);
        }
        double[] dArray2 = new double[n5];
        double d6 = 0.0;
        for (int i = 0; i < n5; ++i) {
            dArray2[i] = Math.exp(dArray[i] - d4);
            d6 += dArray2[i];
        }
        double d7 = this.tou.nextDouble() * d6;
        int n7 = n5 - 1;
        for (int i = 0; i < n5; ++i) {
            if (!((d7 -= dArray2[i]) <= 0.0)) continue;
            n7 = i;
            break;
        }
        Integer[] integerArray = new Integer[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            integerArray[n4] = n4;
        }
        Arrays.sort(integerArray, (n, n2) -> Double.compare(dArray[n2], dArray[n]));
        n4 = Math.min(n3, n5);
        long[] lArray = new long[n4];
        lArray[0] = BlockPos.asLong((int)tpn2.x[n7], (int)tpn2.y[n7], (int)tpn2.z[n7]);
        int n8 = 1;
        for (int i = 0; i < n5 && n8 < n4; ++i) {
            int n9 = integerArray[i];
            if (n9 == n7) continue;
            lArray[n8++] = BlockPos.asLong((int)tpn2.x[n9], (int)tpn2.y[n9], (int)tpn2.z[n9]);
        }
        return lArray;
    }

    private static /* synthetic */ int cnr(int n, int n2) {
        return n + n2 | 0x3E8DEF92;
    }

    private static /* synthetic */ int cns(int n, int n2) {
        return toq.cnr(n, n2) + n;
    }

    private static /* synthetic */ int cnt(int n, int n2) {
        return toq.cnr(n, n2) * n2;
    }
}

