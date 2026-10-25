/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 */
package a;

import a.tvt;
import a.tvw;
import a.txf;
import a.txi;
import a.txl;
import a.txs;
import a.txv;
import a.tzg;
import java.util.Random;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class tvz {
    private static final double twa = 0.12;
    private static final double twb = 0.03;
    private static final int twc = 10;
    public final txs model;
    private final txv twd;
    private final Random twe = new Random();
    private final double[] twf = new double[txl.N];
    private final double[] twg = new double[9];
    private final double[] twh = new double[txv.YAW.length];
    private final double[] twi = new double[txv.PITCH.length];
    private final txi twj = new txi();
    private final tvw twk = new tvw();
    private tzg twl;
    private World twm;
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

    public tvz(txs txs2) {
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

    public tvw decide(World world, PlayerEntity playerEntity, tvt tvt2, int n, float f, float f2, boolean bl) {
        double d;
        long l = System.currentTimeMillis();
        boolean bl2 = l - this.twr > 140L;
        this.twr = l;
        int n2 = (int)Math.floor(playerEntity.getX());
        int n3 = (int)Math.floor(playerEntity.getY() + 0.001);
        int n4 = (int)Math.floor(playerEntity.getZ());
        if (this.twl == null || world != this.twm || n2 != this.twn || n3 != this.two || n4 != this.twp || ++this.twq >= 10) {
            this.twl = txf.snap((BlockView)world, n2, n3, n4);
            this.twm = world;
            this.twn = n2;
            this.two = n3;
            this.twp = n4;
            this.twq = 0;
        }
        double d2 = bl2 ? 0.0 : tvt.wrap(f - this.tws);
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
        this.twj.x = playerEntity.getX();
        this.twj.y = playerEntity.getY();
        this.twj.z = playerEntity.getZ();
        this.twj.yaw = f;
        this.twj.pitch = f2;
        this.twj.vx = playerEntity.getX() - playerEntity.lastX;
        this.twj.vy = playerEntity.getY() - playerEntity.lastY;
        this.twj.vz = playerEntity.getZ() - playerEntity.lastZ;
        this.twj.ground = playerEntity.isOnGround();
        this.twj.water = playerEntity.isTouchingWater();
        this.twj.climb = playerEntity.isClimbing();
        this.twj.collide = playerEntity.horizontalCollision;
        this.twj.sprinting = playerEntity.isSprinting();
        double d4 = playerEntity.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
        this.twj.speed = playerEntity.isSprinting() ? d4 / 1.3 : d4;
        this.twj.sinceJump = this.txa;
        txl.features(this.twj, tvt2, n, this.twl, this.twf, 0);
        double[] dArray = this.twd.forward(this.twf);
        txv.softmax(dArray, 0, 9, 1.0, this.twg);
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
        double d6 = txv.sigmoid(dArray[9]);
        double d7 = txv.sigmoid(dArray[10]);
        this.twx = this.twx ? d7 > 0.42 : d7 > 0.58;
        double d8 = txv.pick(txv.YAW, dArray, 11, this.model.yawTemp, this.model.yawJitter, this.twh, this.twe);
        double d9 = txv.pick(txv.PITCH, dArray, txv.PITCH0, this.model.pitchTemp, this.model.pitchJitter, this.twi, this.twe);
        tvw tvw2 = this.twk;
        tvw2.forward = txv.FWD[this.tww] > 0;
        tvw2.back = txv.FWD[this.tww] < 0;
        tvw2.left = txv.LEFT[this.tww] > 0;
        tvw2.right = txv.LEFT[this.tww] < 0;
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
        return tvz.csj(n, n2) * n2;
    }
}

