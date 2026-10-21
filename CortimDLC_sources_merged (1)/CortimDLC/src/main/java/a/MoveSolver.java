/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.doubles.DoubleList
 *  it.unimi.dsi.fastutil.floats.FloatArraySet
 *  it.unimi.dsi.fastutil.floats.FloatArrays
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1941
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 */
package a;

import a.pwx;
import a.pxa;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.floats.FloatArraySet;
import it.unimi.dsi.fastutil.floats.FloatArrays;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1941;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_265;

public final class MoveSolver {
    private static final double pxe = (double)0.98f;
    private static final double pxf = (double)0.98f;
    private final class_1941 pxg;
    private final class_1297 pxh;
    private final float pxi;
    private final double pxj;
    private final double pxk;
    private final double pxl;
    private final double pxm;
    private final boolean pxn;
    private class_238 pxo;
    private double pxp;
    private double pxq;
    private double pxr;
    private boolean pxs;
    private double pxt;
    private double pxu;
    private static /* synthetic */ long pxv;
    private static /* synthetic */ boolean pxw;

    private MoveSolver(class_1941 class_19412, class_1297 class_12972, pwx pwx2, boolean bl) {
        this.pxg = class_19412;
        this.pxh = class_12972;
        this.pxn = bl;
        this.pxi = pwx2.stepHeight;
        this.pxj = bl ? pwx2.movementSpeed * 1.3 : pwx2.movementSpeed;
        this.pxk = bl ? 0.025999999 : 0.02;
        this.pxl = pwx2.jumpVelocity;
        this.pxm = pwx2.gravity;
        this.pxo = pwx2.box;
        this.pxp = pwx2.vx;
        this.pxq = pwx2.vy;
        this.pxr = pwx2.vz;
        this.pxs = pwx2.onGround;
    }

    public static pxa run(class_1657 class_16572, float f, boolean bl, boolean bl2, int n) {
        return MoveSolver.run((class_1941)class_16572.method_73183(), (class_1297)class_16572, pwx.of(class_16572), f, bl, bl2, n);
    }

    public static pxa run(class_1941 class_19412, class_1297 class_12972, pwx pwx2, float f, boolean bl, boolean bl2, int n) {
        MoveSolver pxd2 = new MoveSolver(class_19412, class_12972, pwx2, bl);
        double d = Math.toRadians(f);
        double d2 = -Math.sin(d);
        double d3 = Math.cos(d);
        double d4 = pxd2.pxx();
        double d5 = pxd2.pxy();
        pxa pxa2 = new pxa();
        pxa2.startY = pxd2.pxo.field_1322;
        pxa2.maxY = pxd2.pxo.field_1322;
        pxa2.minY = pxd2.pxo.field_1322;
        for (int i = 0; i < n; ++i) {
            pxd2.pxz(d2, d3, bl2 && i == 0);
            if (pxa2.firstBlockTick < 0 && pxd2.pxt > 0.02 && pxd2.pxu < pxd2.pxt * 0.5) {
                pxa2.firstBlockTick = i;
            }
            pxa2.maxY = Math.max(pxa2.maxY, pxd2.pxo.field_1322);
            pxa2.minY = Math.min(pxa2.minY, pxd2.pxo.field_1322);
        }
        pxa2.endX = pxd2.pxx();
        pxa2.endZ = pxd2.pxy();
        pxa2.progress = (pxd2.pxx() - d4) * d2 + (pxd2.pxy() - d5) * d3;
        pxa2.endY = pxd2.pxo.field_1322;
        pxa2.endOnGround = pxd2.pxs;
        return pxa2;
    }

    public static boolean jumpHelps(class_1657 class_16572, float f, boolean bl, int n) {
        return MoveSolver.jumpHelps((class_1941)class_16572.method_73183(), (class_1297)class_16572, pwx.of(class_16572), f, bl, n);
    }

    public static boolean jumpHelps(class_1941 class_19412, class_1297 class_12972, pwx pwx2, float f, boolean bl, int n) {
        pxa pxa2 = MoveSolver.run(class_19412, class_12972, pwx2, f, bl, false, 12);
        if (!pxa2.blockedWithin(n)) {
            return false;
        }
        pxa pxa3 = MoveSolver.run(class_19412, class_12972, pwx2, f, bl, true, 12);
        return pxa3.progress > pxa2.progress + 0.5;
    }

    public static boolean reaches(class_1657 class_16572, class_243 class_2432, boolean bl, int n) {
        return MoveSolver.reaches((class_1941)class_16572.method_73183(), (class_1297)class_16572, pwx.of(class_16572), class_2432, bl, n);
    }

    public static boolean reaches(class_1941 class_19412, class_1297 class_12972, pwx pwx2, class_243 class_2432, boolean bl, int n) {
        MoveSolver pxd2 = new MoveSolver(class_19412, class_12972, pwx2, bl);
        boolean bl2 = false;
        double d = Double.MAX_VALUE;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            double d2;
            double d3 = class_2432.field_1352 - pxd2.pxx();
            double d4 = Math.hypot(d3, d2 = class_2432.field_1350 - pxd2.pxy());
            if (d4 < 0.45 && pxd2.pxs && Math.abs(pxd2.pxo.field_1322 - class_2432.field_1351) < 0.6) {
                return true;
            }
            if (d4 < d - 0.05) {
                d = d4;
                n2 = 0;
            } else if (++n2 > 8) {
                return false;
            }
            double d5 = d4 < 1.0E-4 ? 0.0 : d3 / d4;
            double d6 = d4 < 1.0E-4 ? 0.0 : d2 / d4;
            pxd2.pxz(d5, d6, bl2);
            bl2 = pxd2.pxs && pxd2.pxt > 0.02 && pxd2.pxu < pxd2.pxt * 0.5;
        }
        return false;
    }

    private double pxx() {
        return (this.pxo.field_1323 + this.pxo.field_1320) * 0.5;
    }

    private double pxy() {
        return (this.pxo.field_1321 + this.pxo.field_1324) * 0.5;
    }

    private void pxz(double d, double d2, boolean bl) {
        if (Math.abs(this.pxp) < 0.003) {
            this.pxp = 0.0;
        }
        if (Math.abs(this.pxq) < 0.003) {
            this.pxq = 0.0;
        }
        if (Math.abs(this.pxr) < 0.003) {
            this.pxr = 0.0;
        }
        if (bl && this.pxs) {
            this.pxq = Math.max(this.pxl, this.pxq);
            if (this.pxn) {
                this.pxp += d * 0.2;
                this.pxr += d2 * 0.2;
            }
        }
        float f = 1.0f;
        if (this.pxs) {
            class_2338 class_23382 = class_2338.method_49637((double)this.pxx(), (double)(this.pxo.field_1322 - 0.500001), (double)this.pxy());
            f = this.pxg.method_8320(class_23382).method_26204().method_9499();
        }
        double d3 = this.pxs ? this.pxj * (0.21600002 / (double)(f * f * f)) : this.pxk;
        this.pxp += d * (double)0.98f * d3;
        this.pxr += d2 * (double)0.98f * d3;
        class_243 class_2432 = new class_243(this.pxp, this.pxq, this.pxr);
        class_243 class_2433 = this.pya(class_2432);
        this.pxo = this.pxo.method_997(class_2433);
        boolean bl2 = Math.abs(class_2433.field_1352 - class_2432.field_1352) > 1.0E-7;
        boolean bl3 = Math.abs(class_2433.field_1350 - class_2432.field_1350) > 1.0E-7;
        boolean bl4 = Math.abs(class_2433.field_1351 - class_2432.field_1351) > 1.0E-7;
        this.pxs = bl4 && class_2432.field_1351 < 0.0;
        this.pxt = class_2432.field_1352 * d + class_2432.field_1350 * d2;
        this.pxu = class_2433.field_1352 * d + class_2433.field_1350 * d2;
        if (bl2) {
            this.pxp = 0.0;
        }
        if (bl3) {
            this.pxr = 0.0;
        }
        if (bl4) {
            this.pxq = 0.0;
        }
        float f2 = f * 0.91f;
        this.pxq = (this.pxq - this.pxm) * (double)0.98f;
        this.pxp *= (double)f2;
        this.pxr *= (double)f2;
    }

    private class_243 pya(class_243 class_2432) {
        boolean bl;
        if (class_2432.method_1027() == 0.0) {
            return class_2432;
        }
        class_243 class_2433 = MoveSolver.pyc(class_2432, this.pxo, this.pyb(this.pxo.method_18804(class_2432)));
        boolean bl2 = class_2432.field_1352 != class_2433.field_1352;
        boolean bl3 = class_2432.field_1350 != class_2433.field_1350;
        boolean bl4 = bl = class_2432.field_1351 != class_2433.field_1351 && class_2432.field_1351 < 0.0;
        if (this.pxi <= 0.0f || !bl && !this.pxs || !bl2 && !bl3) {
            return class_2433;
        }
        class_238 class_2383 = bl ? this.pxo.method_989(0.0, class_2433.field_1351, 0.0) : this.pxo;
        class_238 class_2384 = class_2383.method_1012(class_2432.field_1352, (double)this.pxi, class_2432.field_1350);
        if (!bl) {
            class_2384 = class_2384.method_1012(0.0, -1.0E-5, 0.0);
        }
        List<class_265> list = this.pyb(class_2384);
        FloatArraySet floatArraySet = new FloatArraySet(4);
        float f = (float)class_2433.field_1351;
        block0: for (class_265 object : list) {
            DoubleList doubleList = object.method_1109(class_2350.class_2351.field_11052);
            for (int i = 0; i < doubleList.size(); ++i) {
                Object object2 = (float)(doubleList.getDouble(i) - class_2383.field_1322);
                if (object2 < 0.0f || object2 == f) continue;
                if (object2 > this.pxi) continue block0;
                floatArraySet.add((float)object2);
            }
        }
        Object object = floatArraySet.toFloatArray();
        FloatArrays.unstableSort((float[])object);
        for (Object object2 : object) {
            class_243 class_2434 = MoveSolver.pyc(new class_243(class_2432.field_1352, (double)object2, class_2432.field_1350), class_2383, list);
            if (!(class_2434.method_37268() > class_2433.method_37268())) continue;
            return class_2434.method_1031(0.0, class_2383.field_1322 - this.pxo.field_1322, 0.0);
        }
        return class_2433;
    }

    private List<class_265> pyb(class_238 class_2383) {
        ArrayList<class_265> arrayList = new ArrayList<class_265>();
        for (class_265 class_2652 : this.pxg.method_20812(this.pxh, class_2383)) {
            if (class_2652.method_1110()) continue;
            arrayList.add(class_2652);
        }
        return arrayList;
    }

    private static class_243 pyc(class_243 class_2432, class_238 class_2383, List<class_265> list) {
        boolean bl;
        if (list.isEmpty()) {
            return class_2432;
        }
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        if (d2 != 0.0 && (d2 = class_259.method_1085((class_2350.class_2351)class_2350.class_2351.field_11052, (class_238)class_2383, list, (double)d2)) != 0.0) {
            class_2383 = class_2383.method_989(0.0, d2, 0.0);
        }
        boolean bl2 = bl = Math.abs(d) < Math.abs(d3);
        if (bl && d3 != 0.0 && (d3 = class_259.method_1085((class_2350.class_2351)class_2350.class_2351.field_11051, (class_238)class_2383, list, (double)d3)) != 0.0) {
            class_2383 = class_2383.method_989(0.0, 0.0, d3);
        }
        if (d != 0.0) {
            d = class_259.method_1085((class_2350.class_2351)class_2350.class_2351.field_11048, (class_238)class_2383, list, (double)d);
            if (!bl && d != 0.0) {
                class_2383 = class_2383.method_989(d, 0.0, 0.0);
            }
        }
        if (!bl && d3 != 0.0) {
            d3 = class_259.method_1085((class_2350.class_2351)class_2350.class_2351.field_11051, (class_238)class_2383, list, (double)d3);
        }
        return new class_243(d, d2, d3);
    }

    private static /* synthetic */ int bpq(int n, int n2) {
        return n - n2 + -379049339;
    }
}

