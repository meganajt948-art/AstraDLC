/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_746
 */
package a;

import a.Box3;
import a.AngleUtil;
import a.MineGrid;
import a.PlayerState;
import a.MineScoring;
import a.trg;
import a.LegsNet;
import a.MineSnapshots;
import a.MineModelReader;
import a.MineSnap;
import java.util.Arrays;
import java.util.Random;
import java.util.function.LongPredicate;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_746;

public final class TurnRateLimiter {
    private static final double tor = 0.6;
    private static final double tos = 0.12;
    private static final double tot = 0.0016666666666666668;
    public final MineModelReader model;
    private final Random tou = new Random();
    private final float[] tov = new float[3];
    private final float[] tow = new float[3];
    private final int[] tox = new int[2];
    private final int[] toy = new int[2];
    private final double[] toz = new double[71];
    private final double[] tpa = new double[11];
    private int tpb;
    private MineSnap tpc;
    private MineSnap tpd;
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

    public TurnRateLimiter(MineModelReader ttb2) {
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

    public void tick(class_1937 class_19372, class_746 class_7462, Box3 pzc2) {
        this.tov[2] = this.tov[1];
        this.tov[1] = this.tov[0];
        this.tov[0] = class_7462.method_36454();
        this.tow[2] = this.tow[1];
        this.tow[1] = this.tow[0];
        this.tow[0] = class_7462.method_36455();
        ++this.tpb;
        this.tpc = MineSnapshots.snap(class_19372, class_7462, class_7462.method_24515(), pzc2, null, null);
        class_243 class_2432 = class_7462.method_33571();
        MineScoring.diff(this.tpd, this.tpc, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, this.tox);
        this.farmed += (long)this.tox[0];
        this.farmedDia += (long)this.tox[1];
        MineScoring.reach(this.tpc, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, this.toy);
        if (this.toy[0] >= 8) {
            double d = MineScoring.value(this.tox[0], this.tox[1]);
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

    public void planLegs(class_1937 class_19372, class_746 class_7462, class_2338 class_23382) {
        if (this.model.legs == null || this.tpc == null) {
            this.tpf = 0;
            this.tpg = false;
            this.tph = false;
            return;
        }
        trg trg2 = new trg();
        trg2.px = class_7462.method_23317();
        trg2.py = class_7462.method_23318();
        trg2.pz = class_7462.method_23321();
        trg2.eyeY = class_7462.method_23320();
        trg2.yaw = class_7462.method_36454();
        trg2.pitch = class_7462.method_36455();
        trg2.vx = class_7462.method_23317() - class_7462.field_6014;
        trg2.vy = class_7462.method_23318() - class_7462.field_6036;
        trg2.vz = class_7462.method_23321() - class_7462.field_5969;
        trg2.ground = class_7462.method_24828();
        trg2.feetY = MineSnapshots.standing(class_19372, class_7462).method_10264();
        if (class_23382 != null) {
            trg2.hasTarget = true;
            trg2.tx = class_23382.method_10263();
            trg2.ty = class_23382.method_10264();
            trg2.tz = class_23382.method_10260();
        }
        LegsNet.features(this.tpc, trg2, this.toz, 0);
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

    public long[] rank(class_1937 class_19372, class_746 class_7462, Box3 pzc2, LongPredicate longPredicate, LongPredicate longPredicate2, class_2338 class_23382, int n3) {
        int n4;
        MineSnap tvn2 = MineSnapshots.snap(class_19372, class_7462, class_7462.method_24515(), pzc2, longPredicate, longPredicate2);
        PlayerState tra2 = new PlayerState();
        class_243 class_2432 = class_7462.method_33571();
        tra2.ex = class_2432.field_1352;
        tra2.ey = class_2432.field_1351;
        tra2.ez = class_2432.field_1350;
        tra2.yaw = class_7462.method_36454();
        tra2.pitch = class_7462.method_36455();
        if (this.tpb >= 3) {
            tra2.vyaw = (float)(AngleUtil.wrap(this.tov[0] - this.tov[2]) * 0.5);
            tra2.vpitch = (this.tow[0] - this.tow[2]) * 0.5f;
        } else if (this.tpb == 2) {
            tra2.vyaw = (float)AngleUtil.wrap(this.tov[0] - this.tov[1]);
            tra2.vpitch = this.tow[0] - this.tow[1];
        }
        tra2.vx = class_7462.method_23317() - class_7462.field_6014;
        tra2.vz = class_7462.method_23321() - class_7462.field_5969;
        tra2.ground = class_7462.method_24828();
        tra2.feetY = MineSnapshots.standing(class_19372, class_7462).method_10264();
        if (class_23382 != null) {
            tra2.hasPrev = true;
            tra2.px = class_23382.method_10263();
            tra2.py = class_23382.method_10264();
            tra2.pz = class_23382.method_10260();
        }
        MineGrid tpn2 = MineGrid.of(tvn2, tra2);
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
        lArray[0] = class_2338.method_10064((int)tpn2.x[n7], (int)tpn2.y[n7], (int)tpn2.z[n7]);
        int n8 = 1;
        for (int i = 0; i < n5 && n8 < n4; ++i) {
            int n9 = integerArray[i];
            if (n9 == n7) continue;
            lArray[n8++] = class_2338.method_10064((int)tpn2.x[n9], (int)tpn2.y[n9], (int)tpn2.z[n9]);
        }
        return lArray;
    }

    private static /* synthetic */ int cnr(int n, int n2) {
        return n + n2 | 0x3E8DEF92;
    }

    private static /* synthetic */ int cns(int n, int n2) {
        return TurnRateLimiter.cnr(n, n2) + n;
    }

    private static /* synthetic */ int cnt(int n, int n2) {
        return TurnRateLimiter.cnr(n, n2) * n2;
    }
}

