/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.lpp;
import a.tbp;
import a.tck;
import a.tel;
import flow.dev.a;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class lng {
    private static final double lnh = 30.0;
    private static final int lni = 10;
    private static final double lnj = 8.0;
    private static final double lnk = 45.0;
    private static final int lnl = 1;
    private static final int lnm = 2;
    private static final double lnn = 1.0;
    private static final double lno = 4.0;
    private static final double lnp = 4.0;
    private static final int lnq = 12;
    private static final double lnr = 150.0;
    private static final double lns = 1.5;
    private static final Object lnt = new Object();
    private final tel lnu = new tel();
    private final Random lnv = new Random();
    private final double[] lnw = new double[2];
    private boolean lnx;
    private double lny = 1.0;
    private double lnz = 45.0;
    private double loa;
    private double lob;
    private double loc;
    private double lod;
    private boolean loe;
    private float lof;
    private float log;
    private float loh;
    private float loi;
    private boolean loj;
    private Entity lok;
    private int lol;
    private int lom;
    private double lon;
    private ClientPlayerEntity loo;
    private float lop;
    private float loq;
    private double lor;
    private double los;
    private static /* synthetic */ String lot;
    private static /* synthetic */ int lou;

    public void use(tck tck2, double d) {
        this.lny = d;
        this.lnu.use(tck2);
        this.lnu.tune(d, 1.0, 1.0);
        this.lnu.verticalAware(true);
    }

    public void vertical(double d) {
        this.lnu.tune(this.lny, 1.0, d);
    }

    public void height(double d, double d2) {
        this.lnu.height(d, d2);
    }

    public void stepCap(double d) {
        this.lnz = d;
    }

    public void verticalAware(boolean bl) {
        this.lnu.verticalAware(bl);
    }

    public Entity target() {
        return this.loj ? (this.lok != null ? this.lok : this.lnu.target()) : null;
    }

    public float cameraYaw(ClientPlayerEntity clientPlayerEntity) {
        return this.loe ? this.lof : clientPlayerEntity.method_36454();
    }

    public double maxTurn() {
        return 30.0 * this.lny;
    }

    public boolean idle() {
        return this.loa == 0.0 && this.lob == 0.0;
    }

    public String debugOffsets() {
        return String.format(Locale.ROOT, a.c(-1959140365, "\ue3f2\u9a48\u1084\u8ea2\u053c\u8387\u39df\ub031\u2e39\ua4ce\u2355\ud923\u57f7\uce4e\u4444\uc2ad\u78a3\uf736\u6dcd\ueb9b\u626e\u1837\u96dc\u0d15\u8b2b\u01be\ub848\u3612\uacec\u2abb\ua10e\u5fdd\ud593\u4c3b\uca70\u4097"), this.loa, this.lob, this.lol, this.lom, this.loj);
    }

    public double offset() {
        return Math.sqrt(this.loa * this.loa + this.lob * this.lob);
    }

    public void mode(boolean bl, ClientPlayerEntity clientPlayerEntity) {
        if (this.lnx == bl) {
            return;
        }
        this.end(clientPlayerEntity);
        this.forget();
        this.lnx = bl;
    }

    public void forget() {
        this.loa = 0.0;
        this.lob = 0.0;
        this.loc = 0.0;
        this.lod = 0.0;
        this.loj = false;
        this.lok = null;
        this.lol = 0;
        this.lom = 0;
    }

    public void reset() {
        this.forget();
        this.lnu.reset();
        this.loo = null;
    }

    public float serverYaw(ClientPlayerEntity clientPlayerEntity) {
        return this.lnx && !this.loe ? (float)((double)clientPlayerEntity.method_36454() + this.loa) : clientPlayerEntity.method_36454();
    }

    public float serverPitch(ClientPlayerEntity clientPlayerEntity) {
        return this.lnx && !this.loe ? MathHelper.method_15363((float)((float)((double)clientPlayerEntity.method_36455() + this.lob)), (float)-90.0f, (float)90.0f) : clientPlayerEntity.method_36455();
    }

    public void begin(ClientPlayerEntity clientPlayerEntity) {
        if (clientPlayerEntity == null) {
            return;
        }
        if (!this.loe && this.loo == clientPlayerEntity) {
            double d = (double)(clientPlayerEntity.method_36454() - this.lop) - this.lor;
            double d2 = (double)(clientPlayerEntity.method_36455() - this.loq) - this.los;
            if (this.lnx) {
                if ((this.loj || this.lol > 0) && !this.idle()) {
                    this.loa -= d;
                    this.lob -= d2;
                }
            } else if (!this.loj && this.lol == 0 && !this.idle() && Math.abs(d) + Math.abs(d2) > 1.0) {
                this.release();
            }
        }
        this.los = 0.0;
        this.lor = 0.0;
        if (!this.loe) {
            this.low(clientPlayerEntity);
        }
        if (!this.lnx || this.loe || this.idle()) {
            return;
        }
        this.loy(clientPlayerEntity);
        clientPlayerEntity.method_36456((float)((double)this.lof + this.loa));
        clientPlayerEntity.method_36457(MathHelper.method_15363((float)((float)((double)this.log + this.lob)), (float)-90.0f, (float)90.0f));
    }

    public void end(ClientPlayerEntity clientPlayerEntity) {
        if (!this.loe) {
            return;
        }
        this.loe = false;
        if (clientPlayerEntity == null) {
            return;
        }
        clientPlayerEntity.method_36456(this.lof);
        clientPlayerEntity.method_36457(this.log);
        clientPlayerEntity.field_5982 = this.lof;
        clientPlayerEntity.field_6004 = this.log;
        clientPlayerEntity.field_3931 = this.loh;
        clientPlayerEntity.field_3914 = this.loi;
        clientPlayerEntity.field_3932 = this.loh + (this.lof - this.loh) * 0.5f;
        clientPlayerEntity.field_3916 = this.loi + (this.log - this.loi) * 0.5f;
    }

    public void newTick(ClientPlayerEntity clientPlayerEntity) {
        this.lon = 0.0;
        this.los = 0.0;
        this.lor = 0.0;
        this.loo = clientPlayerEntity;
        if (clientPlayerEntity != null) {
            this.lop = clientPlayerEntity.method_36454();
            this.loq = clientPlayerEntity.method_36455();
        }
    }

    public boolean approach(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, lpp lpp2, Box box) {
        float f = this.serverYaw(clientPlayerEntity);
        float f2 = this.serverPitch(clientPlayerEntity);
        if (!this.loj) {
            double d = MathHelper.method_15393((float)(lpp2.yaw() - f));
            double d2 = lpp2.pitch() - f2;
            if (lpp2.tick() > 10 && Math.sqrt(d * d + d2 * d2) < 8.0 * this.lny * (double)lpp2.tick()) {
                return false;
            }
        }
        this.loj = true;
        this.lol = 0;
        this.lom = 0;
        Box box2 = lpp2.box();
        Vec3d vec3d = lpp2.eye();
        Vec3d vec3d2 = lpp2.aim();
        double d = tbp.hitU(vec3d.field_1352, vec3d.field_1350, (box2.field_1323 + box2.field_1320) * 0.5, (box2.field_1321 + box2.field_1324) * 0.5, (box2.field_1320 - box2.field_1323) * 0.5, vec3d2.field_1352, vec3d2.field_1350);
        double d3 = tbp.hitV(box2.field_1322, box2.field_1325 - box2.field_1322, vec3d2.field_1351);
        if (this.lnu.steerAt(clientPlayerEntity, lpp2.target(), box, vec3d, d, d3, 1, f, f2, this.lnw)) {
            this.lov(minecraftClient, clientPlayerEntity);
        }
        return true;
    }

    public void track(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, int n) {
        float f = this.serverYaw(clientPlayerEntity);
        float f2 = this.serverPitch(clientPlayerEntity);
        this.loj = true;
        this.lok = null;
        this.lol = 0;
        this.lom = 0;
        if (this.lnu.steer(clientPlayerEntity, entity, entity.method_5829(), clientPlayerEntity.method_33571(), n, f, f2, this.lnw)) {
            this.lov(minecraftClient, clientPlayerEntity);
        }
    }

    public void turnBy(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, double d, double d2) {
        this.loj = true;
        this.lok = entity;
        this.lol = 0;
        this.lom = 0;
        this.loz(minecraftClient, clientPlayerEntity, d, d2, true);
    }

    private void lov(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = Math.hypot(this.lnw[0], this.lnw[1]);
        double d2 = d > this.lnz ? this.lnz / d : 1.0;
        this.loz(minecraftClient, clientPlayerEntity, this.lnw[0] * d2, this.lnw[1] * d2, true);
    }

    public void hit(int n) {
        this.lol = Math.max(this.lol, n);
        this.loj = false;
    }

    public boolean home(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        this.loj = false;
        float f = this.serverYaw(clientPlayerEntity);
        float f2 = this.serverPitch(clientPlayerEntity);
        if (this.lol > 0) {
            --this.lol;
            this.lnu.idle(f, f2);
            return false;
        }
        if (this.idle()) {
            this.lom = 0;
            this.lnu.idle(f, f2);
            return true;
        }
        ++this.lom;
        this.low(clientPlayerEntity);
        double d = MathHelper.method_15350((double)(-this.loa), (double)-150.0, (double)150.0);
        double d2 = (double)f2 - this.lob;
        boolean bl = this.lnu.steerTo(clientPlayerEntity, lnt, (double)f + d, d2, 2, f, f2, this.lnw);
        if (this.lom > 12) {
            this.lox(minecraftClient, clientPlayerEntity, 0.5 + this.lnv.nextDouble() * 0.3, this.maxTurn());
        } else if (bl && this.offset() < 4.0) {
            this.lox(minecraftClient, clientPlayerEntity, 0.5 + this.lnv.nextDouble() * 0.3, 4.0);
        } else if (bl) {
            this.lov(minecraftClient, clientPlayerEntity);
        }
        if (this.offset() <= Math.max(0.3, lng.lpa(minecraftClient, clientPlayerEntity) * 1.5)) {
            this.forget();
            return true;
        }
        return false;
    }

    public void release() {
        this.forget();
        this.lnu.drop();
    }

    private void low(ClientPlayerEntity clientPlayerEntity) {
        float f = clientPlayerEntity.method_36455();
        this.lob = this.lnx ? (double)(MathHelper.method_15363((float)((float)((double)f + this.lob)), (float)-90.0f, (float)90.0f) - f) : (double)f - MathHelper.method_15350((double)((double)f - this.lob), (double)-90.0, (double)90.0);
    }

    public void snap(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, float f, float f2) {
        if (this.lnx && !this.loe) {
            this.loy(clientPlayerEntity);
        }
        double d = MathHelper.method_15393((float)(f - clientPlayerEntity.method_36454()));
        double d2 = f2 - clientPlayerEntity.method_36455();
        double d3 = Math.sqrt(d * d + d2 * d2);
        double d4 = Math.max(0.0, this.maxTurn() - this.lon);
        if (d3 < 1.0E-4 || d4 <= 0.0) {
            return;
        }
        double d5 = Math.min(1.0, d4 / d3);
        this.loz(minecraftClient, clientPlayerEntity, d * d5, d2 * d5, false);
    }

    private void lox(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, double d, double d2) {
        double d3 = this.offset();
        if (d3 <= 0.0) {
            return;
        }
        double d4 = Math.min(d, d2 / d3);
        this.loz(minecraftClient, clientPlayerEntity, -this.loa * d4, -this.lob * d4, true);
    }

    private void loy(ClientPlayerEntity clientPlayerEntity) {
        this.lof = clientPlayerEntity.method_36454();
        this.log = clientPlayerEntity.method_36455();
        this.loh = clientPlayerEntity.field_3932;
        this.loi = clientPlayerEntity.field_3916;
        this.loe = true;
    }

    private void loz(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, double d, double d2, boolean bl) {
        double d3;
        double d4;
        double d5 = lng.lpb(minecraftClient, clientPlayerEntity);
        double d6 = d5 * 0.15;
        if (d6 <= 0.0) {
            return;
        }
        this.loc += d / d6;
        this.lod += d2 / d6;
        long l = (long)this.loc;
        long l2 = (long)this.lod;
        this.loc -= (double)l;
        this.lod -= (double)l2;
        if (l == 0L && l2 == 0L) {
            return;
        }
        if (this.lnx && !this.loe) {
            double d7;
            for (d7 = (double)this.serverPitch(clientPlayerEntity) + (double)l2 * d6; d7 > 90.0 && l2 > 0L; --l2, d7 -= d6) {
            }
            while (d7 < -90.0 && l2 < 0L) {
                ++l2;
                d7 += d6;
            }
            d4 = (float)((double)l * d5) * 0.15f;
            d3 = (float)((double)l2 * d5) * 0.15f;
        } else {
            float f = clientPlayerEntity.method_36454();
            float f2 = clientPlayerEntity.method_36455();
            float f3 = clientPlayerEntity.field_5982;
            float f4 = clientPlayerEntity.field_6004;
            clientPlayerEntity.method_5872((double)l * d5, (double)l2 * d5);
            d4 = clientPlayerEntity.method_36454() - f;
            d3 = clientPlayerEntity.method_36455() - f2;
            if (!this.lnx) {
                this.lor += d4;
                this.los += d3;
            }
            if (bl) {
                clientPlayerEntity.field_5982 = f3;
                clientPlayerEntity.field_6004 = f4;
            }
        }
        this.loa += d4;
        this.lob += d3;
        this.lon += Math.sqrt(d4 * d4 + d3 * d3);
        this.lnu.turned(d4, d3);
    }

    private static double lpa(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return lng.lpb(minecraftClient, clientPlayerEntity) * 0.15;
    }

    private static double lpb(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = (Double)minecraftClient.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = minecraftClient.field_1690.method_31044().method_31034() && clientPlayerEntity.method_31550();
        return bl ? d2 : d2 * 8.0;
    }

    private static /* synthetic */ int axw(int n, int n2) {
        return n - n2 ^ 0x36B1AAE8;
    }

    private static /* synthetic */ int axx(int n, int n2) {
        return lng.axw(n, n2) ^ 0x33B4E11;
    }
}

