/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.doubles.DoubleList
 *  it.unimi.dsi.fastutil.floats.FloatArraySet
 *  it.unimi.dsi.fastutil.floats.FloatArrays
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.util.shape.VoxelShapes
 *  net.minecraft.world.CollisionView
 */
package a;

import a.pwx;
import a.pxa;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.floats.FloatArraySet;
import it.unimi.dsi.fastutil.floats.FloatArrays;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.CollisionView;

public final class pxd {
    private static final double pxe = (double)0.98f;
    private static final double pxf = (double)0.98f;
    private final CollisionView pxg;
    private final Entity pxh;
    private final float pxi;
    private final double pxj;
    private final double pxk;
    private final double pxl;
    private final double pxm;
    private final boolean pxn;
    private Box pxo;
    private double pxp;
    private double pxq;
    private double pxr;
    private boolean pxs;
    private double pxt;
    private double pxu;
    private static /* synthetic */ long pxv;
    private static /* synthetic */ boolean pxw;

    private pxd(CollisionView collisionView, Entity entity, pwx pwx2, boolean bl) {
        this.pxg = collisionView;
        this.pxh = entity;
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

    public static pxa run(PlayerEntity playerEntity, float f, boolean bl, boolean bl2, int n) {
        return pxd.run((CollisionView)playerEntity.method_73183(), (Entity)playerEntity, pwx.of(playerEntity), f, bl, bl2, n);
    }

    public static pxa run(CollisionView collisionView, Entity entity, pwx pwx2, float f, boolean bl, boolean bl2, int n) {
        pxd pxd2 = new pxd(collisionView, entity, pwx2, bl);
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

    public static boolean jumpHelps(PlayerEntity playerEntity, float f, boolean bl, int n) {
        return pxd.jumpHelps((CollisionView)playerEntity.method_73183(), (Entity)playerEntity, pwx.of(playerEntity), f, bl, n);
    }

    public static boolean jumpHelps(CollisionView collisionView, Entity entity, pwx pwx2, float f, boolean bl, int n) {
        pxa pxa2 = pxd.run(collisionView, entity, pwx2, f, bl, false, 12);
        if (!pxa2.blockedWithin(n)) {
            return false;
        }
        pxa pxa3 = pxd.run(collisionView, entity, pwx2, f, bl, true, 12);
        return pxa3.progress > pxa2.progress + 0.5;
    }

    public static boolean reaches(PlayerEntity playerEntity, Vec3d vec3d, boolean bl, int n) {
        return pxd.reaches((CollisionView)playerEntity.method_73183(), (Entity)playerEntity, pwx.of(playerEntity), vec3d, bl, n);
    }

    public static boolean reaches(CollisionView collisionView, Entity entity, pwx pwx2, Vec3d vec3d, boolean bl, int n) {
        pxd pxd2 = new pxd(collisionView, entity, pwx2, bl);
        boolean bl2 = false;
        double d = Double.MAX_VALUE;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            double d2;
            double d3 = vec3d.field_1352 - pxd2.pxx();
            double d4 = Math.hypot(d3, d2 = vec3d.field_1350 - pxd2.pxy());
            if (d4 < 0.45 && pxd2.pxs && Math.abs(pxd2.pxo.field_1322 - vec3d.field_1351) < 0.6) {
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
            BlockPos blockPos = BlockPos.method_49637((double)this.pxx(), (double)(this.pxo.field_1322 - 0.500001), (double)this.pxy());
            f = this.pxg.method_8320(blockPos).method_26204().method_9499();
        }
        double d3 = this.pxs ? this.pxj * (0.21600002 / (double)(f * f * f)) : this.pxk;
        this.pxp += d * (double)0.98f * d3;
        this.pxr += d2 * (double)0.98f * d3;
        Vec3d vec3d = new Vec3d(this.pxp, this.pxq, this.pxr);
        Vec3d vec3d2 = this.pya(vec3d);
        this.pxo = this.pxo.method_997(vec3d2);
        boolean bl2 = Math.abs(vec3d2.field_1352 - vec3d.field_1352) > 1.0E-7;
        boolean bl3 = Math.abs(vec3d2.field_1350 - vec3d.field_1350) > 1.0E-7;
        boolean bl4 = Math.abs(vec3d2.field_1351 - vec3d.field_1351) > 1.0E-7;
        this.pxs = bl4 && vec3d.field_1351 < 0.0;
        this.pxt = vec3d.field_1352 * d + vec3d.field_1350 * d2;
        this.pxu = vec3d2.field_1352 * d + vec3d2.field_1350 * d2;
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

    private Vec3d pya(Vec3d vec3d) {
        boolean bl;
        if (vec3d.method_1027() == 0.0) {
            return vec3d;
        }
        Vec3d vec3d2 = pxd.pyc(vec3d, this.pxo, this.pyb(this.pxo.method_18804(vec3d)));
        boolean bl2 = vec3d.field_1352 != vec3d2.field_1352;
        boolean bl3 = vec3d.field_1350 != vec3d2.field_1350;
        boolean bl4 = bl = vec3d.field_1351 != vec3d2.field_1351 && vec3d.field_1351 < 0.0;
        if (this.pxi <= 0.0f || !bl && !this.pxs || !bl2 && !bl3) {
            return vec3d2;
        }
        Box box = bl ? this.pxo.method_989(0.0, vec3d2.field_1351, 0.0) : this.pxo;
        Box box2 = box.method_1012(vec3d.field_1352, (double)this.pxi, vec3d.field_1350);
        if (!bl) {
            box2 = box2.method_1012(0.0, -1.0E-5, 0.0);
        }
        List<VoxelShape> list = this.pyb(box2);
        FloatArraySet floatArraySet = new FloatArraySet(4);
        float f = (float)vec3d2.field_1351;
        block0: for (VoxelShape object : list) {
            DoubleList doubleList = object.method_1109(Direction.Axis.field_11052);
            for (int i = 0; i < doubleList.size(); ++i) {
                Object object2 = (float)(doubleList.getDouble(i) - box.field_1322);
                if (object2 < 0.0f || object2 == f) continue;
                if (object2 > this.pxi) continue block0;
                floatArraySet.add((float)object2);
            }
        }
        Object object = floatArraySet.toFloatArray();
        FloatArrays.unstableSort((float[])object);
        for (Object object2 : object) {
            Vec3d vec3d3 = pxd.pyc(new Vec3d(vec3d.field_1352, (double)object2, vec3d.field_1350), box, list);
            if (!(vec3d3.method_37268() > vec3d2.method_37268())) continue;
            return vec3d3.method_1031(0.0, box.field_1322 - this.pxo.field_1322, 0.0);
        }
        return vec3d2;
    }

    private List<VoxelShape> pyb(Box box) {
        ArrayList<VoxelShape> arrayList = new ArrayList<VoxelShape>();
        for (VoxelShape voxelShape : this.pxg.method_20812(this.pxh, box)) {
            if (voxelShape.method_1110()) continue;
            arrayList.add(voxelShape);
        }
        return arrayList;
    }

    private static Vec3d pyc(Vec3d vec3d, Box box, List<VoxelShape> list) {
        boolean bl;
        if (list.isEmpty()) {
            return vec3d;
        }
        double d = vec3d.field_1352;
        double d2 = vec3d.field_1351;
        double d3 = vec3d.field_1350;
        if (d2 != 0.0 && (d2 = VoxelShapes.method_1085((Direction.Axis)Direction.Axis.field_11052, (Box)box, list, (double)d2)) != 0.0) {
            box = box.method_989(0.0, d2, 0.0);
        }
        boolean bl2 = bl = Math.abs(d) < Math.abs(d3);
        if (bl && d3 != 0.0 && (d3 = VoxelShapes.method_1085((Direction.Axis)Direction.Axis.field_11051, (Box)box, list, (double)d3)) != 0.0) {
            box = box.method_989(0.0, 0.0, d3);
        }
        if (d != 0.0) {
            d = VoxelShapes.method_1085((Direction.Axis)Direction.Axis.field_11048, (Box)box, list, (double)d);
            if (!bl && d != 0.0) {
                box = box.method_989(d, 0.0, 0.0);
            }
        }
        if (!bl && d3 != 0.0) {
            d3 = VoxelShapes.method_1085((Direction.Axis)Direction.Axis.field_11051, (Box)box, list, (double)d3);
        }
        return new Vec3d(d, d2, d3);
    }

    private static /* synthetic */ int bpq(int n, int n2) {
        return n - n2 + -379049339;
    }
}

