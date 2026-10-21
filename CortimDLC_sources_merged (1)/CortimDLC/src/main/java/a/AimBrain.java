/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package a;

import a.taf;
import a.AimSimulator;
import a.tbm;
import a.AngleUtil;
import a.AimModel;
import a.RecorderHooks;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;

public final class AimBrain {
    private static final double tem = 3.0;
    private static final double ten = 8.0;
    private static final double teo = 4.0;
    private final Random tep = new Random();
    private final taf teq = new taf();
    private final double[] ter = new double[32];
    private final double[] tes = new double[2];
    private final tbm tet = new tbm();
    private AimModel teu;
    private AimSimulator tev;
    private double tew = Double.NaN;
    private double tex = Double.NaN;
    private Object tey;
    private boolean tez;
    private boolean tfa;
    private boolean tfb;
    private double tfc = 0.5;
    private double tfd;
    private double tfe;
    private double tff;
    private double tfg;
    private double tfh;
    private double tfi = 0.5;
    private double tfj = 1.0;
    private double tfk;
    private double tfl;
    private double tfm = 3.0;
    private double tfn = 8.0;
    private double tfo;
    private double tfp;
    private double tfq;
    private double tfr;
    private double tfs;
    private double tft;
    private int tfu;
    private int tfv;
    private int tfw;
    private int tfx = -1;
    private double tfy = 1.0;
    private boolean tfz;
    private boolean tga;
    private double tgb;
    private double tgc;
    private double tgd;
    private double tge;
    private double tgf;
    private double tgg;
    private double tgh;
    private double tgi;
    private final double[] tgj = new double[8];
    private double tgk;
    private double tgl;
    private double tgm;
    private double tgn;
    private int tgo;
    private int tgp;
    private boolean tgq;
    private float tgr;
    private float tgs;
    private double tgt;
    private double tgu;
    private double tgv;
    private double tgw;
    private boolean tgx;
    private boolean tgy;
    private boolean tgz;
    private double tha;
    private double thb;
    private double thc;
    private double thd;
    private double the;
    private double thf;
    private double thg;
    private double thh;
    private boolean thi;
    private float thj;
    private float thk;
    private double thl;
    private double thm;
    private long thn;
    private double tho = 0.3;
    private double thp;
    private long thq;
    private static /* synthetic */ boolean thr;
    private static /* synthetic */ int ths;

    public void use(AimModel tck2) {
        if (tck2 == this.teu) {
            return;
        }
        this.teu = tck2;
        this.tev = tck2 == null ? null : new AimSimulator(tck2, this.tep);
        this.reset();
    }

    public boolean ready() {
        return this.tev != null;
    }

    public class_1297 target() {
        class_1297 class_12972;
        Object object = this.tey;
        return object instanceof class_1297 ? (class_12972 = (class_1297)object) : null;
    }

    public void tune(double d, double d2, double d3) {
        this.teq.speed = d;
        this.teq.texture = d2;
        this.teq.vertical = d3;
    }

    public void height(double d, double d2) {
        this.tew = Math.min(d, d2);
        this.tex = Math.max(d, d2);
    }

    public void verticalAware(boolean bl) {
        this.tgy = bl;
    }

    public boolean aiming() {
        return this.tgz || System.currentTimeMillis() < this.thq;
    }

    public void reset() {
        this.drop();
        this.tgq = false;
        this.thi = false;
        this.thh = 0.0;
        this.thg = 0.0;
        this.thm = 0.0;
        this.thl = 0.0;
        this.tgw = 0.0;
        this.tgv = 0.0;
        this.tgp = 0;
        if (this.tev != null) {
            this.tev.reset();
        }
    }

    public void drop() {
        this.tey = null;
        this.tgz = false;
        this.tga = false;
    }

    public void tick(class_310 class_3102, class_746 class_7462, class_1297 class_12972, int n, boolean bl) {
        this.tht(class_3102, class_7462, class_12972, n, bl);
    }

    public void assist(class_310 class_3102, class_746 class_7462, class_1297 class_12972, int n) {
        this.tht(class_3102, class_7462, class_12972, n, false);
    }

    public double lastPlan() {
        return this.thp;
    }

    public void cap(double d) {
        this.tfd = d;
    }

    public void reactionScale(double d) {
        this.tfj = Math.max(0.0, d);
    }

    public void newTick() {
        this.tfe = 0.0;
    }

    public double budgetLeft() {
        return this.tfd <= 0.0 ? Double.MAX_VALUE : Math.max(0.0, this.tfd - this.tfe);
    }

    public void spent(double d) {
        this.tfe += d;
    }

    public void pointSize(double d) {
        this.tfc = d;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void assistAt(class_310 class_3102, class_746 class_7462, Object object, class_243 class_2432, int n) {
        if (object == null || class_2432 == null) {
            this.thu(class_3102, class_7462, null, null, n, false);
            return;
        }
        this.tfa = true;
        this.tff = 0.0;
        this.tfg = 0.5;
        this.tfb = true;
        try {
            double d = this.tfc;
            this.thu(class_3102, class_7462, object, new class_238(class_2432.field_1352 - d, class_2432.field_1351 - d, class_2432.field_1350 - d, class_2432.field_1352 + d, class_2432.field_1351 + d, class_2432.field_1350 + d), n, false);
        }
        finally {
            this.tfa = false;
            this.tfb = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void assistBlock(class_310 class_3102, class_746 class_7462, Object object, class_238 class_2383, class_243 class_2432, int n) {
        if (object == null || class_2383 == null || class_2432 == null) {
            this.thu(class_3102, class_7462, null, null, n, false);
            return;
        }
        if (object != this.tey) {
            class_243 class_2433 = class_7462.method_33571();
            this.tfh = AngleUtil.hitU(class_2433.field_1352, class_2433.field_1350, (class_2383.field_1323 + class_2383.field_1320) * 0.5, (class_2383.field_1321 + class_2383.field_1324) * 0.5, (class_2383.field_1320 - class_2383.field_1323) * 0.5, class_2432.field_1352, class_2432.field_1350);
            this.tfi = AngleUtil.hitV(class_2383.field_1322, class_2383.field_1325 - class_2383.field_1322, class_2432.field_1351);
        }
        this.tfa = true;
        this.tff = this.tfh;
        this.tfg = this.tfi;
        this.tfb = true;
        try {
            this.thu(class_3102, class_7462, object, class_2383, n, false);
        }
        finally {
            this.tfa = false;
            this.tfb = false;
        }
    }

    private void tht(class_310 class_3102, class_746 class_7462, class_1297 class_12972, int n, boolean bl) {
        this.thu(class_3102, class_7462, class_12972, class_12972 == null ? null : class_12972.method_5829(), n, bl);
    }

    private void thu(class_310 class_3102, class_746 class_7462, Object object, class_238 class_2383, int n, boolean bl) {
        this.tgx = bl;
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        this.thv(f, f2);
        double d = this.thl;
        double d2 = this.thm;
        this.thm = 0.0;
        this.thl = 0.0;
        this.tgz = false;
        if (!this.thw(class_7462, object, class_2383, class_7462.method_33571(), n, bl, d, d2, f, f2)) {
            return;
        }
        double d3 = Math.hypot(this.tha, this.thb);
        if (this.tfd > 0.0 && d3 > this.tfd) {
            this.tha *= this.tfd / d3;
            this.thb *= this.tfd / d3;
        }
        this.thc = AimBrain.tig(this.tgt, this.tha);
        this.thd = AimBrain.tig(this.tgu, this.thb);
        this.thf = 0.0;
        this.the = 0.0;
        boolean bl2 = this.tgz = Math.abs(this.tha) + Math.abs(this.thb) > 1.0E-6;
        if (this.tgz && this.tho > 0.95) {
            this.tii(class_3102, class_7462, this.tha, this.thb);
            this.the = this.tha;
            this.thf = this.thb;
            this.tgz = false;
            this.thj = class_7462.method_36454();
            this.thk = class_7462.method_36455();
        }
    }

    public boolean steer(class_746 class_7462, Object object, class_238 class_2383, class_243 class_2432, int n, float f, float f2, double[] dArray) {
        this.thv(f, f2);
        this.tgz = false;
        if (!this.thw(class_7462, object, class_2383, class_2432, n, false, 0.0, 0.0, f, f2)) {
            return false;
        }
        dArray[0] = this.tha;
        dArray[1] = this.thb;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean steerAt(class_746 class_7462, Object object, class_238 class_2383, class_243 class_2432, double d, double d2, int n, float f, float f2, double[] dArray) {
        this.tfa = true;
        this.tff = d;
        this.tfg = d2;
        try {
            boolean bl = this.steer(class_7462, object, class_2383, class_2432, n, f, f2, dArray);
            return bl;
        }
        finally {
            this.tfa = false;
        }
    }

    public boolean steerTo(class_746 class_7462, Object object, double d, double d2, int n, float f, float f2, double[] dArray) {
        this.tfk = d;
        this.tfl = d2;
        return this.steer(class_7462, object, null, null, n, f, f2, dArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean steerTo(class_746 class_7462, Object object, double d, double d2, double d3, double d4, int n, float f, float f2, double[] dArray) {
        double d5 = this.tfm;
        double d6 = this.tfn;
        this.tfm = d3;
        this.tfn = d4;
        try {
            boolean bl = this.steerTo(class_7462, object, d, d2, n, f, f2, dArray);
            return bl;
        }
        finally {
            this.tfm = d5;
            this.tfn = d6;
        }
    }

    public void idle(float f, float f2) {
        this.thv(f, f2);
        this.tgz = false;
        this.drop();
    }

    public void turned(double d, double d2) {
        this.tgv += d;
        this.tgw += d2;
    }

    private void thv(float f, float f2) {
        this.tgt = this.tgq ? this.tgv : 0.0;
        double d = this.tgu = this.tgq ? this.tgw : 0.0;
        if (this.tgq && this.tga) {
            double d2 = AngleUtil.wrap(f - this.tgr) - this.tgv;
            double d3 = (double)(f2 - this.tgs) - this.tgw;
            for (int i = 0; i < 8; i += 2) {
                int n = i;
                this.tgj[n] = this.tgj[n] - d2;
                int n2 = i + 1;
                this.tgj[n2] = this.tgj[n2] - d3;
            }
        }
        this.tgw = 0.0;
        this.tgv = 0.0;
        if (this.tgq && this.tev != null) {
            this.tev.history(this.tgt, this.tgu);
        }
        this.tgr = f;
        this.tgs = f2;
        this.tgq = true;
    }

    private boolean thw(class_746 class_7462, Object object, class_238 class_2383, class_243 class_2432, int n, boolean bl, double d, double d2, float f, float f2) {
        if (this.tev == null || object == null) {
            this.drop();
            return false;
        }
        if (this.tgp > 0) {
            --this.tgp;
            this.drop();
            this.tev.settle();
            return false;
        }
        if (object != this.tey) {
            this.tfz = class_2383 == null || this.thx(class_2432, class_2383, f, f2);
            this.thy(object, class_2383 == null, n);
        }
        if (class_2383 == null) {
            this.thz();
        } else {
            if (this.tfa) {
                this.tfo = this.tff;
                this.tfp = this.tfg;
            } else if (!this.tez) {
                this.tif();
            }
            if (!AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, (class_2383.field_1323 + class_2383.field_1320) * 0.5, class_2383.field_1322, (class_2383.field_1321 + class_2383.field_1324) * 0.5, (class_2383.field_1320 - class_2383.field_1323) * 0.5, class_2383.field_1325 - class_2383.field_1322, this.tfo, this.tfp, this.tet)) {
                this.tga = false;
                return false;
            }
        }
        double d3 = AngleUtil.wrap(this.tet.yaw - (double)f);
        double d4 = this.tet.pitch - (double)f2;
        if (!this.tga) {
            for (int i = 0; i < 8; i += 2) {
                this.tgj[i] = d3;
                this.tgj[i + 1] = d4;
            }
            this.tgi = 0.0;
            this.tgh = 0.0;
            this.tgg = 0.0;
            this.tgf = 0.0;
            this.tge = 0.0;
            this.tgd = 0.0;
        }
        this.tgm = this.tga ? AngleUtil.wrap(this.tet.yaw - this.tgb) : 0.0;
        this.tgn = this.tga ? this.tet.pitch - this.tgc : 0.0;
        this.ter[2] = this.tgj[2];
        this.ter[3] = this.tgj[3];
        this.ter[4] = this.tgj[6];
        this.ter[5] = this.tgj[7];
        this.ter[8] = this.tgd;
        this.ter[9] = this.tge;
        this.ter[10] = this.tgf;
        this.ter[11] = this.tgg;
        this.ter[12] = this.tgh;
        this.ter[13] = this.tgi;
        System.arraycopy(this.tgj, 0, this.tgj, 2, 6);
        this.tgj[0] = d3;
        this.tgj[1] = d4;
        this.tgh = this.tgf;
        this.tgi = this.tgg;
        this.tgf = this.tgd;
        this.tgg = this.tge;
        this.tgd = this.tgm;
        this.tge = this.tgn;
        this.tgb = this.tet.yaw;
        this.tgc = this.tet.pitch;
        this.tga = true;
        this.tgk = this.tet.bw;
        this.tgl = this.tet.bh;
        if (bl) {
            double d5 = Math.hypot(d, d2);
            double d6 = Math.hypot(d3, d4);
            if (d5 > Math.max(2.5, 1.3 * this.thp) && d * d3 + d2 * d4 < -0.25 * d5 * d6) {
                this.tgp = 8 + this.tep.nextInt(7);
                this.drop();
                return false;
            }
        }
        if (this.tgo > 0) {
            --this.tgo;
            return false;
        }
        this.ter[0] = d3;
        this.ter[1] = d4;
        this.ter[6] = this.tgm;
        this.ter[7] = this.tgn;
        this.ter[22] = this.tet.bw;
        this.ter[23] = this.tet.bh;
        this.ter[24] = this.tfo;
        this.ter[25] = this.tfp;
        this.ter[26] = this.tet.dist;
        this.ter[27] = class_2383 == null || this.tfb ? 1.0 : (double)class_7462.method_7261(0.5f);
        this.ter[28] = this.tet.la;
        this.ter[29] = this.tet.ra;
        this.ter[30] = this.tet.ta;
        this.ter[31] = this.tet.ba;
        double d7 = Math.abs(d3) * Math.cos(Math.toRadians(f2));
        this.tev.step(this.ter, this.teq, this.tes, this.tgy && Math.abs(d4) > 1.5 * d7 + 2.0);
        this.tha = this.tes[0];
        this.thb = this.tes[1];
        this.thp = Math.hypot(this.tha, this.thb);
        this.thq = System.currentTimeMillis() + 300L;
        return true;
    }

    private boolean thx(class_243 class_2432, class_238 class_2383, float f, float f2) {
        tbm tbm2 = new tbm();
        if (!AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, (class_2383.field_1323 + class_2383.field_1320) * 0.5, class_2383.field_1322, (class_2383.field_1321 + class_2383.field_1324) * 0.5, (class_2383.field_1320 - class_2383.field_1323) * 0.5, class_2383.field_1325 - class_2383.field_1322, 0.0, 0.5, tbm2)) {
            return false;
        }
        return Math.hypot(AngleUtil.wrap(tbm2.yaw - (double)f), tbm2.pitch - (double)f2) >= 15.0;
    }

    private void thy(Object object, boolean bl, int n) {
        this.tey = object;
        this.tez = bl;
        this.tga = false;
        this.tgi = 0.0;
        this.tgh = 0.0;
        this.tgg = 0.0;
        this.tgf = 0.0;
        this.tge = 0.0;
        this.tgd = 0.0;
        if (bl) {
            this.tfs = 0.0;
            this.tfq = 0.0;
            this.tfo = 0.0;
            this.tft = 0.5;
            this.tfr = 0.5;
            this.tfp = 0.5;
        } else {
            double[] dArray = this.tia();
            this.tfq = this.tfs = dArray[0];
            this.tfo = this.tfs;
            this.tfr = this.tft = dArray[1];
            this.tfp = this.tft;
        }
        this.tfv = 0;
        this.tfu = 0;
        this.tfw = 30 + this.tep.nextInt(50);
        if (!bl && this.tib()) {
            this.tfx = this.tep.nextInt(this.teu.chainU.length);
            this.tfy = this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0;
            this.tfq = this.tfs = this.tic(this.tfx);
            this.tfo = this.tfs;
            this.tfr = this.tft = this.tid(this.tfx);
            this.tfp = this.tft;
        }
        if (n < 0) {
            int n2;
            int n3 = n2 = this.teu == null ? -1 : this.teu.reaction(this.tep);
            this.tgo = this.tfz ? (n2 >= 0 ? n2 : 1 + this.tep.nextInt(3)) : 0;
            this.tgo = (int)Math.round((double)this.tgo * this.tfj);
        } else {
            int n4 = this.tgo = n == 0 ? 0 : Math.max(0, (int)Math.round((double)n * (0.7 + this.tep.nextDouble() * 0.6)));
        }
        if (this.tev != null) {
            this.tev.settle();
        }
    }

    private void thz() {
        this.tet.yaw = this.tfk;
        this.tet.pitch = this.tfl;
        this.tet.bw = this.tfm;
        this.tet.bh = this.tfn;
        this.tet.la = -this.tfm;
        this.tet.ra = this.tfm;
        this.tet.ta = -this.tfn * 0.5;
        this.tet.ba = this.tfn * 0.5;
        this.tet.dist = 4.0;
    }

    private double[] tia() {
        if (!Double.isNaN(this.tew)) {
            double d = this.teu == null || this.teu.aimU.length == 0 ? this.tep.nextGaussian() * 0.25 : (double)this.teu.aimU[this.tep.nextInt(this.teu.aimU.length)] * (this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0);
            double d2 = this.tew + this.tep.nextDouble() * (this.tex - this.tew);
            return new double[]{Math.max(-0.9, Math.min(0.9, d)), Math.max(0.02, Math.min(0.98, d2))};
        }
        if (this.teu == null || this.teu.aimU.length == 0) {
            return new double[]{this.tep.nextGaussian() * 0.25, 0.62 + this.tep.nextDouble() * 0.22};
        }
        int n = this.tep.nextInt(this.teu.aimU.length);
        double d = (double)this.teu.aimU[n] * (this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0);
        return new double[]{Math.max(-0.9, Math.min(0.9, d)), Math.max(0.1, Math.min(0.95, (double)this.teu.aimV[n]))};
    }

    private boolean tib() {
        return this.teu != null && this.teu.ownAim() && Double.isNaN(this.tew);
    }

    private double tic(int n) {
        return Math.max(-0.95, Math.min(0.95, (double)this.teu.chainU[n] * this.tfy));
    }

    private double tid(int n) {
        return Math.max(0.02, Math.min(0.98, (double)this.teu.chainV[n]));
    }

    private void tie() {
        int n;
        if (this.tfu < this.tfv) {
            ++this.tfu;
            double d = (double)this.tfu / (double)this.tfv;
            this.tfo = this.tfq + (this.tfs - this.tfq) * d;
            this.tfp = this.tfr + (this.tft - this.tfr) * d;
            return;
        }
        int n2 = this.tfx + 1;
        if (n2 < this.teu.chainU.length && this.teu.chainGap[n2] > 0) {
            n = this.teu.chainGap[n2];
        } else {
            n2 = this.tep.nextInt(this.teu.chainU.length);
            this.tfy = this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0;
            n = this.teu.chainGap[n2] > 0 ? this.teu.chainGap[n2] : 8 + this.tep.nextInt(10);
        }
        this.tfx = n2;
        this.tfq = this.tfo;
        this.tfr = this.tfp;
        this.tfs = this.tic(n2);
        this.tft = this.tid(n2);
        this.tfu = 0;
        this.tfv = Math.max(1, n);
    }

    private void tif() {
        if (this.tib() && this.tfx >= 0 && this.tfx < this.teu.chainU.length) {
            this.tie();
            return;
        }
        if (this.tfu < this.tfv) {
            ++this.tfu;
            double d = (double)this.tfu / (double)this.tfv;
            double d2 = d * d * (3.0 - 2.0 * d);
            this.tfo = this.tfq + (this.tfs - this.tfq) * d2;
            this.tfp = this.tfr + (this.tft - this.tfr) * d2;
            return;
        }
        if (--this.tfw <= 0) {
            double[] dArray = this.tia();
            this.tfq = this.tfo;
            this.tfr = this.tfp;
            this.tfs = this.tfo + (dArray[0] - this.tfo) * 0.6;
            this.tft = this.tfp + (dArray[1] - this.tfp) * 0.6;
            this.tfu = 0;
            this.tfv = 8 + this.tep.nextInt(8);
            this.tfw = 25 + this.tep.nextInt(50);
        }
    }

    private static double tig(double d, double d2) {
        if (d * d2 <= 0.0) {
            return 0.0;
        }
        double d3 = 3.0 * Math.abs(d2);
        return Math.abs(d) > d3 ? Math.copySign(d3, d2) : d;
    }

    private static double tih(double d, double d2, double d3) {
        double d4 = d * d;
        double d5 = d4 * d;
        return (d5 - 2.0 * d4 + d) * d2 + (-2.0 * d5 + 3.0 * d4) * d3 + (d5 - d4) * d3;
    }

    public void frame(class_310 class_3102, class_746 class_7462) {
        long l = System.nanoTime();
        if (this.thn != 0L) {
            double d = Math.min(0.1, (double)(l - this.thn) / 1.0E9);
            this.tho += (d / 0.05 - this.tho) * 0.2;
        }
        this.thn = l;
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        if (this.thi) {
            this.thl += AngleUtil.wrap(f - this.thj);
            this.thm += (double)(f2 - this.thk);
        }
        if (this.tgz) {
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            float f3 = class_3102.method_61966().method_60637(true);
            double d6 = Math.max(0.5, Math.min(1.0, 1.0 - this.tho * 0.9));
            double d7 = Math.min(1.0, (double)f3 / d6);
            double d8 = AimBrain.tih(d7, this.thc, this.tha) - this.the;
            double d9 = AimBrain.tih(d7, this.thd, this.thb) - this.thf;
            double d10 = AngleUtil.wrap(this.tgb - (double)f) + this.tgm * this.teq.lead;
            double d11 = this.tgc - (double)f2 + this.tgn * this.teq.lead;
            double d12 = d5 = this.tgx ? Math.hypot(d10, d11) : 0.0;
            if (d5 > 1.0E-6 && (d4 = d8 * (d3 = d10 / d5) + d9 * (d2 = d11 / d5)) > (d = d5 + 0.18 * (this.tgk * Math.abs(d3) + 0.5 * this.tgl * Math.abs(d2)) + 0.02)) {
                d8 -= d3 * (d4 - d);
                d9 -= d2 * (d4 - d);
            }
            this.tii(class_3102, class_7462, d8, d9);
            this.the += d8;
            this.thf += d9;
        }
        this.thj = class_7462.method_36454();
        this.thk = class_7462.method_36455();
        this.thi = true;
    }

    public void tickOnly() {
        this.tho = 1.0;
        this.thn = 0L;
    }

    public void forgetFrame() {
        this.thi = false;
        this.thn = 0L;
    }

    private void tii(class_310 class_3102, class_746 class_7462, double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6 = RecorderHooks.unit(class_3102);
        if (d6 <= 0.0) {
            return;
        }
        if (this.tfd > 0.0 && (d5 = Math.hypot(d, d2)) > (d4 = Math.max(0.0, this.tfd - this.tfe))) {
            d3 = d4 / d5;
            d *= d3;
            d2 *= d3;
        }
        this.thg += d / d6;
        this.thh += d2 / d6;
        long l = (long)this.thg;
        long l2 = (long)this.thh;
        this.thg -= (double)l;
        this.thh -= (double)l2;
        if (l == 0L && l2 == 0L) {
            return;
        }
        d3 = d6 / 0.15;
        class_7462.method_5872((double)l * d3, (double)l2 * d3);
        this.tgv += (double)l * d6;
        this.tgw += (double)l2 * d6;
        this.tfe += Math.hypot((double)l * d6, (double)l2 * d6);
    }

    private static /* synthetic */ int cla(int n, int n2) {
        return n + n2 ^ 0x2DCE3946;
    }

    private static /* synthetic */ int clb(int n, int n2) {
        return n ^ n2 | 0x7B7AF29A;
    }

    private static /* synthetic */ int clc(int n, int n2) {
        return AimBrain.cla(n, n2) + n;
    }
}

