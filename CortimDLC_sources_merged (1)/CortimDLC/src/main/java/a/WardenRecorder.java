/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_5134
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.RouteGuide;
import a.Route;
import a.StudioProfiles;
import a.PathProjection;
import a.WalkHazards;
import a.WalkSnap;
import a.tzj;
import a.tzm;
import a.tzp;
import a.WalkRecordingReader;
import a.KeyUtil;
import flow.dev.StringDecryptor;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1922;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_5134;
import net.minecraft.class_638;
import net.minecraft.class_746;

public final class WardenRecorder {
    private static final int tye = 1200;
    private static final long tyf = 180000L;
    private static final int tyg = 10;
    public final StudioProfiles profile;
    public final String module;
    private final String tyh;
    private final WalkRecordingReader tyi = new WalkRecordingReader();
    private final Map<Long, Integer> tyj = new HashMap<Long, Integer>();
    private boolean tyk;
    private boolean tyl = true;
    private class_638 tym;
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

    public WardenRecorder(StudioProfiles tiq2, String string, float f) {
        this.profile = tiq2;
        this.module = string;
        this.tyh = tiq2.newTapeName();
        this.tyi.created = System.currentTimeMillis();
        this.tyi.unit = f;
        this.tyi.module = "AutoWarden".equals(string) ? 2 : 1;
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

    public void tick(class_310 class_3102) {
        WalkSnap tzg2;
        class_746 class_7462 = class_3102.field_1724;
        class_638 class_6382 = class_3102.field_1687;
        if (class_7462 == null || class_6382 == null) {
            this.pause("dead");
            return;
        }
        if (class_6382 != this.tym) {
            this.tym = class_6382;
            this.tyl = true;
            this.tyr = -1;
        }
        Route psf2 = RouteGuide.route();
        if (!RouteGuide.guiding()) {
            this.pause("module");
            return;
        }
        if (RouteGuide.working()) {
            this.pause("loot");
            return;
        }
        if (psf2 == null || psf2.track.n < 2) {
            this.pause("route");
            return;
        }
        if (!this.tyk) {
            this.tyk = true;
            this.tyi.ox = (int)Math.floor(class_7462.method_23317());
            this.tyi.oy = (int)Math.floor(class_7462.method_23318());
            this.tyi.oz = (int)Math.floor(class_7462.method_23321());
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
        int n3 = (int)Math.floor(class_7462.method_23317());
        int n4 = (int)Math.floor(class_7462.method_23318() + 0.001);
        int n5 = (int)Math.floor(class_7462.method_23321());
        if (this.tyr < 0 || n3 != this.tyo || n4 != this.typ || n5 != this.tyq || n2 - this.tyn >= 10) {
            tzg2 = WalkHazards.snap((class_1922)class_6382, n3, n4, n5);
            tzj tzj2 = new tzj();
            tzj2.x0 = tzg2.x0 - this.tyi.ox;
            tzj2.y0 = tzg2.y0 - this.tyi.oy;
            tzj2.z0 = tzg2.z0 - this.tyi.oz;
            tzj2.packed = WalkRecordingReader.pack(tzg2.cells);
            this.tyi.snaps.add(tzj2);
            this.tyr = this.tyi.snaps.size() - 1;
            this.tyo = n3;
            this.typ = n4;
            this.tyq = n5;
            this.tyn = n2;
        }
        tzg2 = class_3102.field_1690;
        boolean bl = KeyUtil.isPhysicallyDown(class_3102, ((class_315)tzg2).field_1903);
        int n6 = (KeyUtil.isPhysicallyDown(class_3102, ((class_315)tzg2).field_1894) ? 1 : 0) | (KeyUtil.isPhysicallyDown(class_3102, ((class_315)tzg2).field_1881) ? 2 : 0) | (KeyUtil.isPhysicallyDown(class_3102, ((class_315)tzg2).field_1913) ? 4 : 0) | (KeyUtil.isPhysicallyDown(class_3102, ((class_315)tzg2).field_1849) ? 8 : 0) | (bl ? 16 : 0) | (class_7462.method_5624() ? 32 : 0) | (class_7462.method_5715() ? 64 : 0);
        tzp tzp2 = new tzp();
        tzp2.flags = 1 | (class_7462.method_24828() ? 2 : 0) | (this.tyl ? 4 : 0) | (class_7462.method_5624() ? 8 : 0) | (class_7462.method_5715() ? 16 : 0) | (class_7462.method_5799() ? 32 : 0) | (class_7462.method_6101() ? 64 : 0) | (class_7462.field_5976 ? 128 : 0);
        tzp2.keys = n6;
        tzp2.yaw = class_7462.method_36454();
        tzp2.pitch = class_7462.method_36455();
        tzp2.x = (float)(class_7462.method_23317() - (double)this.tyi.ox);
        tzp2.y = (float)(class_7462.method_23318() - (double)this.tyi.oy);
        tzp2.z = (float)(class_7462.method_23321() - (double)this.tyi.oz);
        tzp2.vx = (float)(class_7462.method_23317() - class_7462.field_6014);
        tzp2.vy = (float)(class_7462.method_23318() - class_7462.field_6036);
        tzp2.vz = (float)(class_7462.method_23321() - class_7462.field_5969);
        double d = class_7462.method_45325(class_5134.field_23719);
        tzp2.speed = (float)(class_7462.method_5624() ? d / 1.3 : d);
        tzp2.food = Math.max(0, Math.min(255, class_7462.method_7344().method_7586()));
        tzp2.route = n;
        tzp2.snap = this.tyr;
        if (!this.tyl) {
            this.meters += Math.hypot(class_7462.method_23317() - this.tzb, class_7462.method_23321() - this.tzc);
            if (bl && !this.tza) {
                ++this.jumps;
            }
        }
        this.tzb = class_7462.method_23317();
        this.tzc = class_7462.method_23321();
        this.tza = bl;
        this.tyl = false;
        this.tyi.ticks.add(tzp2);
        ++this.recorded;
        if (n2 + 1 - this.tys >= 1200) {
            this.save();
        }
    }

    private tzm tzf(Route psf2) {
        PathProjection tvt2 = psf2.track;
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
        this.profile.add("walk.ticks", this.recorded - this.tyt);
        this.profile.add("walk.meters", Math.round(this.meters - this.tyu));
        this.profile.add("walk.routes", this.routes - this.tyv);
        this.profile.add("walk.jumps", this.jumps - this.tyw);
        this.tyt = this.recorded;
        this.tyu = Math.round(this.meters);
        this.tyv = this.routes;
        this.tyw = this.jumps;
        this.tys = n;
        this.profile.save();
        WalkRecordingReader tzs2 = this.tyi.frozen();
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
            this.profile.add("sessions", 1L);
        }
        this.tyy = this.recorded > 0;
        this.save();
    }

    private static /* synthetic */ int cti(int n, int n2) {
        return n * n2 | 0x414ABA9A;
    }

    private static /* synthetic */ int ctj(int n, int n2) {
        return WardenRecorder.cti(n, n2) ^ 0x13B9E0CC;
    }
}

