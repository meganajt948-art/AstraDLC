/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_5134
 */
package a;

import a.PathProjection;
import a.tvw;
import a.WalkHazards;
import a.txi;
import a.WalkFeatures;
import a.WalkModelReader;
import a.WalkNet;
import a.WalkSnap;
import java.util.Random;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_5134;

public final class WalkSpeedModel {
    private static final double twa = 0.12;
    private static final double twb = 0.03;
    private static final int twc = 10;
    public final WalkModelReader model;
    private final WalkNet twd;
    private final Random twe = new Random();
    private final double[] twf = new double[WalkFeatures.N];
    private final double[] twg = new double[9];
    private final double[] twh = new double[WalkNet.YAW.length];
    private final double[] twi = new double[WalkNet.PITCH.length];
    private final txi twj = new txi();
    private final tvw twk = new tvw();
    private WalkSnap twl;
    private class_1937 twm;
    private int twn;
    private int two;
    private int twp;
    private int twq;
    private long twr;
    private float tws;
    private float twt;
    private double twu;
    private double twv;
    private int tww = 0;
    private boolean twx;
    private boolean twy;
    private boolean twz;
    private int txa = 20;
    private double txb;
    private int txc;
    private static /* synthetic */ int txd;
    private static /* synthetic */ long txe;

    public WalkSpeedModel(WalkModelReader txs2) {
        this.model = txs2;
        this.twd = txs2.net.copy();
    }

    public double speed() {
        return this.txc < 40 ? -1.0 : this.txb / (double)this.txc * 20.0;
    }

    public void reset() {
        this.twr = 0L;
        this.tww = 0;
        this.twx = false;
        this.twy = false;
        this.twz = false;
        this.txa = 20;
    }

    public tvw decide(class_1937 class_19372, class_1657 class_16572, PathProjection tvt2, int n, float f, float f2, boolean bl) {
        double d;
        long l = System.currentTimeMillis();
        boolean bl2 = l - this.twr > 140L;
        this.twr = l;
        int n2 = (int)Math.floor(class_16572.method_23317());
        int n3 = (int)Math.floor(class_16572.method_23318() + 0.001);
        int n4 = (int)Math.floor(class_16572.method_23321());
        if (this.twl == null || class_19372 != this.twm || n2 != this.twn || n3 != this.two || n4 != this.twp || ++this.twq >= 10) {
            this.twl = WalkHazards.snap((class_1922)class_19372, n2, n3, n4);
            this.twm = class_19372;
            this.twn = n2;
            this.two = n3;
            this.twp = n4;
            this.twq = 0;
        }
        double d2 = bl2 ? 0.0 : PathProjection.wrap(f - this.tws);
        double d3 = bl2 ? 0.0 : (double)(f2 - this.twt);
        this.twj.dyaw2 = bl2 ? 0.0 : this.twu;
        this.twj.dpitch2 = bl2 ? 0.0 : this.twv;
        this.twj.dyaw1 = d2;
        this.twj.dpitch1 = d3;
        this.twu = d2;
        this.twv = d3;
        this.tws = f;
        this.twt = f2;
        if (bl2) {
            this.tww = 0;
            this.txa = 20;
            this.twy = false;
            this.twz = false;
        } else {
            this.txa = this.twy && !this.twz ? 0 : Math.min(20, this.txa + 1);
            this.twz = this.twy;
        }
        this.twj.x = class_16572.method_23317();
        this.twj.y = class_16572.method_23318();
        this.twj.z = class_16572.method_23321();
        this.twj.yaw = f;
        this.twj.pitch = f2;
        this.twj.vx = class_16572.method_23317() - class_16572.field_6014;
        this.twj.vy = class_16572.method_23318() - class_16572.field_6036;
        this.twj.vz = class_16572.method_23321() - class_16572.field_5969;
        this.twj.ground = class_16572.method_24828();
        this.twj.water = class_16572.method_5799();
        this.twj.climb = class_16572.method_6101();
        this.twj.collide = class_16572.field_5976;
        this.twj.sprinting = class_16572.method_5624();
        double d4 = class_16572.method_45325(class_5134.field_23719);
        this.twj.speed = class_16572.method_5624() ? d4 / 1.3 : d4;
        this.twj.sinceJump = this.txa;
        WalkFeatures.features(this.twj, tvt2, n, this.twl, this.twf, 0);
        double[] dArray = this.twd.forward(this.twf);
        WalkNet.softmax(dArray, 0, 9, 1.0, this.twg);
        int n5 = 0;
        for (int i = 1; i < 9; ++i) {
            if (!(this.twg[i] > this.twg[n5])) continue;
            n5 = i;
        }
        double d5 = d = this.tww == 0 ? 0.03 : 0.12;
        if (n5 != this.tww && this.twg[n5] < this.twg[this.tww] + d) {
            n5 = this.tww;
        }
        this.tww = n5;
        double d6 = WalkNet.sigmoid(dArray[9]);
        double d7 = WalkNet.sigmoid(dArray[10]);
        this.twx = this.twx ? d7 > 0.42 : d7 > 0.58;
        double d8 = WalkNet.pick(WalkNet.YAW, dArray, 11, this.model.yawTemp, this.model.yawJitter, this.twh, this.twe);
        double d9 = WalkNet.pick(WalkNet.PITCH, dArray, WalkNet.PITCH0, this.model.pitchTemp, this.model.pitchJitter, this.twi, this.twe);
        tvw tvw2 = this.twk;
        tvw2.forward = WalkNet.FWD[this.tww] > 0;
        tvw2.back = WalkNet.FWD[this.tww] < 0;
        tvw2.left = WalkNet.LEFT[this.tww] > 0;
        tvw2.right = WalkNet.LEFT[this.tww] < 0;
        tvw2.jump = d6 > this.model.jumpThreshold;
        tvw2.sprint = this.twx && bl && tvw2.forward;
        tvw2.dyaw = d8;
        tvw2.dpitch = Math.max(-90.0 - (double)f2, Math.min(90.0 - (double)f2, d9));
        this.twy = tvw2.jump;
        double d10 = Math.hypot(this.twj.vx, this.twj.vz);
        if (this.twj.ground && this.tww != 0 && d10 > 0.05) {
            if (this.txc >= 2000) {
                this.txb *= 0.5;
                this.txc /= 2;
            }
            this.txb += d10;
            ++this.txc;
        }
        return tvw2;
    }

    public void jumped(boolean bl) {
        this.twy = bl;
    }

    private static /* synthetic */ int csj(int n, int n2) {
        return n * n2 + -1204370300;
    }

    private static /* synthetic */ int csk(int n, int n2) {
        return WalkSpeedModel.csj(n, n2) * n2;
    }
}

