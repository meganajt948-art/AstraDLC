/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.world.BlockView
 */
package a;

import a.pnf;
import a.psf;
import a.tiq;
import a.tvt;
import a.txf;
import a.tzg;
import a.tzj;
import a.tzm;
import a.tzp;
import a.tzs;
import a.vzz;
import flow.dev.a;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.BlockView;

public final class tyd {
    private static final int tye = 1200;
    private static final long tyf = 180000L;
    private static final int tyg = 10;
    public final tiq profile;
    public final String module;
    private final String tyh;
    private final tzs tyi = new tzs();
    private final Map<Long, Integer> tyj = new HashMap<Long, Integer>();
    private boolean tyk;
    private boolean tyl = true;
    private ClientWorld tym;
    private int tyn = -1000;
    private int tyo;
    private int typ;
    private int tyq;
    private int tyr = -1;
    private int tys;
    private int tyt;
    private double tyu;
    private int tyv;
    private int tyw;
    private boolean tyx;
    private boolean tyy;
    private long tyz = System.currentTimeMillis();
    private boolean tza;
    private double tzb;
    private double tzc;
    public int recorded;
    public double meters;
    public int routes;
    public int jumps;
    public boolean paused = true;
    public String pauseReason = "";
    private static /* synthetic */ String tzd;
    private static /* synthetic */ boolean tze;

    public tyd(tiq tiq2, String string, float f) {
        this.profile = tiq2;
        this.module = string;
        this.tyh = tiq2.newTapeName();
        this.tyi.created = System.currentTimeMillis();
        this.tyi.unit = f;
        this.tyi.module = a.c(-13034048, "\u1d8b\u640e\ueedc\u70b6\ufb59\u7dde\uc79e\u4e79\ud027\u5a9d").equals(string) ? 2 : 1;
    }

    public int seconds() {
        return this.recorded / 20;
    }

    public double[] unsaved() {
        return new double[]{this.recorded - this.tyt, this.meters - this.tyu, this.routes - this.tyv, this.jumps - this.tyw};
    }

    public void pause(String string) {
        this.paused = true;
        this.pauseReason = string;
        this.tyl = true;
    }

    public void tick(MinecraftClient minecraftClient) {
        tzg tzg2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        ClientWorld clientWorld = minecraftClient.world;
        if (clientPlayerEntity == null || clientWorld == null) {
            this.pause(a.c(-506266187, "\ufdd5\u8465\u0eb2\u90c6"));
            return;
        }
        if (clientWorld != this.tym) {
            this.tym = clientWorld;
            this.tyl = true;
            this.tyr = -1;
        }
        psf psf2 = pnf.route();
        if (!pnf.guiding()) {
            this.pause(a.b("\u353f\u4c8c\uc654\u5834\ud3fa\u5542", 90584404));
            return;
        }
        if (pnf.working()) {
            this.pause(a.b("\u74e2\u0d50\u8783\u19e9", -1160874870));
            return;
        }
        if (psf2 == null || psf2.track.n < 2) {
            this.pause(a.c(571089828, "\u23d3\u5a7f\ud0b6\u4ec6\uc500"));
            return;
        }
        if (!this.tyk) {
            this.tyk = true;
            this.tyi.ox = (int)Math.floor(clientPlayerEntity.getX());
            this.tyi.oy = (int)Math.floor(clientPlayerEntity.getY());
            this.tyi.oz = (int)Math.floor(clientPlayerEntity.getZ());
        }
        this.paused = false;
        this.pauseReason = "";
        Integer n = this.tyj.get(psf2.id);
        if (n == null) {
            n = this.tyi.lanes.size();
            this.tyi.lanes.add(this.tzf(psf2));
            this.tyj.put(psf2.id, n);
            ++this.routes;
        }
        int n2 = this.tyi.ticks.size();
        int n3 = (int)Math.floor(clientPlayerEntity.getX());
        int n4 = (int)Math.floor(clientPlayerEntity.getY() + 0.001);
        int n5 = (int)Math.floor(clientPlayerEntity.getZ());
        if (this.tyr < 0 || n3 != this.tyo || n4 != this.typ || n5 != this.tyq || n2 - this.tyn >= 10) {
            tzg2 = txf.snap((BlockView)clientWorld, n3, n4, n5);
            tzj tzj2 = new tzj();
            tzj2.x0 = tzg2.x0 - this.tyi.ox;
            tzj2.y0 = tzg2.y0 - this.tyi.oy;
            tzj2.z0 = tzg2.z0 - this.tyi.oz;
            tzj2.packed = tzs.pack(tzg2.cells);
            this.tyi.snaps.add(tzj2);
            this.tyr = this.tyi.snaps.size() - 1;
            this.tyo = n3;
            this.typ = n4;
            this.tyq = n5;
            this.tyn = n2;
        }
        tzg2 = minecraftClient.options;
        boolean bl = vzz.isPhysicallyDown(minecraftClient, ((GameOptions)tzg2).jumpKey);
        int n6 = (vzz.isPhysicallyDown(minecraftClient, ((GameOptions)tzg2).forwardKey) ? 1 : 0) | (vzz.isPhysicallyDown(minecraftClient, ((GameOptions)tzg2).backKey) ? 2 : 0) | (vzz.isPhysicallyDown(minecraftClient, ((GameOptions)tzg2).leftKey) ? 4 : 0) | (vzz.isPhysicallyDown(minecraftClient, ((GameOptions)tzg2).rightKey) ? 8 : 0) | (bl ? 16 : 0) | (clientPlayerEntity.isSprinting() ? 32 : 0) | (clientPlayerEntity.isSneaking() ? 64 : 0);
        tzp tzp2 = new tzp();
        tzp2.flags = 1 | (clientPlayerEntity.isOnGround() ? 2 : 0) | (this.tyl ? 4 : 0) | (clientPlayerEntity.isSprinting() ? 8 : 0) | (clientPlayerEntity.isSneaking() ? 16 : 0) | (clientPlayerEntity.isTouchingWater() ? 32 : 0) | (clientPlayerEntity.isClimbing() ? 64 : 0) | (clientPlayerEntity.horizontalCollision ? 128 : 0);
        tzp2.keys = n6;
        tzp2.yaw = clientPlayerEntity.getYaw();
        tzp2.pitch = clientPlayerEntity.getPitch();
        tzp2.x = (float)(clientPlayerEntity.getX() - (double)this.tyi.ox);
        tzp2.y = (float)(clientPlayerEntity.getY() - (double)this.tyi.oy);
        tzp2.z = (float)(clientPlayerEntity.getZ() - (double)this.tyi.oz);
        tzp2.vx = (float)(clientPlayerEntity.getX() - clientPlayerEntity.lastX);
        tzp2.vy = (float)(clientPlayerEntity.getY() - clientPlayerEntity.lastY);
        tzp2.vz = (float)(clientPlayerEntity.getZ() - clientPlayerEntity.lastZ);
        double d = clientPlayerEntity.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
        tzp2.speed = (float)(clientPlayerEntity.isSprinting() ? d / 1.3 : d);
        tzp2.food = Math.max(0, Math.min(255, clientPlayerEntity.getHungerManager().getFoodLevel()));
        tzp2.route = n;
        tzp2.snap = this.tyr;
        if (!this.tyl) {
            this.meters += Math.hypot(clientPlayerEntity.getX() - this.tzb, clientPlayerEntity.getZ() - this.tzc);
            if (bl && !this.tza) {
                ++this.jumps;
            }
        }
        this.tzb = clientPlayerEntity.getX();
        this.tzc = clientPlayerEntity.getZ();
        this.tza = bl;
        this.tyl = false;
        this.tyi.ticks.add(tzp2);
        ++this.recorded;
        if (n2 + 1 - this.tys >= 1200) {
            this.save();
        }
    }

    private tzm tzf(psf psf2) {
        tvt tvt2 = psf2.track;
        tzm tzm2 = new tzm();
        int n = tvt2.n;
        tzm2.x = new float[n];
        tzm2.y = new float[n];
        tzm2.z = new float[n];
        tzm2.flag = new byte[n];
        for (int i = 0; i < n; ++i) {
            tzm2.x[i] = tvt2.x[i] - (float)this.tyi.ox;
            tzm2.y[i] = tvt2.y[i] - (float)this.tyi.oy;
            tzm2.z[i] = tvt2.z[i] - (float)this.tyi.oz;
            tzm2.flag[i] = tvt2.flag[i];
        }
        tzm2.goal = (byte)(psf2.direct ? 1 : 0);
        return tzm2;
    }

    public void save() {
        int n = this.tyi.ticks.size();
        if (n <= this.tys && !this.tyy) {
            return;
        }
        this.profile.add(a.d("\u7376\u0ad1\u800f\u1e79\u95eb\u1300\ua94e\u20b5\ubee2\u344b", -510440161, -586072556), this.recorded - this.tyt);
        this.profile.add(a.b("\ubde2\uc445\u4e9b\ud0ed\u5b7f\udd8d\u67d6\uee36\u7078\ufade\u7d0c", -1721451106), Math.round(this.meters - this.tyu));
        this.profile.add(a.b("\u7491\u0d36\u87e8\u199e\u920c\u14e1\uaeaf\u2744\ub91a\u33ba\ub47f", 152401133), this.routes - this.tyv);
        this.profile.add(a.c(-931175578, "\u631b\u1abc\u9062\u0e14\u8586\u0373\ub93f\u30d6\uae94\u2426"), this.jumps - this.tyw);
        this.tyt = this.recorded;
        this.tyu = Math.round(this.meters);
        this.tyv = this.routes;
        this.tyw = this.jumps;
        this.tys = n;
        this.profile.save();
        tzs tzs2 = this.tyi.frozen();
        this.profile.putWalkTape(this.tyh, tzs2);
        long l = System.currentTimeMillis();
        if (this.tyy || l - this.tyz > 180000L) {
            this.tyy = false;
            this.tyz = l;
            this.profile.uploadWalkTape(this.tyh, tzs2);
        }
    }

    public void finish() {
        if (this.recorded > 0 && !this.tyx) {
            this.tyx = true;
            this.profile.add(a.d("\u759d\u0c3a\u86ff\u188e\u9343\u15f4\uafa6\u264a", 831628901, -107949181), 1L);
        }
        this.tyy = this.recorded > 0;
        this.save();
    }

    private static /* synthetic */ int cti(int n, int n2) {
        return n * n2 | 0x414ABA9A;
    }

    private static /* synthetic */ int ctj(int n, int n2) {
        return tyd.cti(n, n2) ^ 0x13B9E0CC;
    }
}

