/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 */
package a;

import java.util.Optional;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public final class lme {
    private static final double[] lmf = new double[]{0.0, 0.35, 0.6, 0.8, 1.0};
    private static final double lmg = 0.12;
    private final Random lmh = new Random();
    private double lmi = 0.5;
    private double lmj = 0.5;
    private double lmk = 0.5;
    private static /* synthetic */ String lml;
    private static /* synthetic */ boolean lmm;

    public void roll(double d) {
        double d2 = MathHelper.method_15350((double)d, (double)0.0, (double)0.9);
        this.lmi = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
        this.lmj = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
        this.lmk = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
    }

    public Vec3d on(Box box) {
        return new Vec3d(MathHelper.method_16436((double)this.lmi, (double)box.field_1323, (double)box.field_1320), MathHelper.method_16436((double)this.lmj, (double)box.field_1322, (double)box.field_1325), MathHelper.method_16436((double)this.lmk, (double)box.field_1321, (double)box.field_1324));
    }

    public Vec3d resolve(World world, Entity entity, Vec3d vec3d, Box box, double d) {
        Vec3d vec3d2 = this.on(box);
        if (box.method_1006(vec3d)) {
            return vec3d2;
        }
        if (box.method_49271(vec3d) > d * d) {
            return null;
        }
        Box box2 = box.method_35580(Math.min(0.12, box.method_17939() * 0.25), Math.min(0.12, box.method_17940() * 0.25), Math.min(0.12, box.method_17941() * 0.25));
        Vec3d vec3d3 = new Vec3d(MathHelper.method_15350((double)vec3d.field_1352, (double)box2.field_1323, (double)box2.field_1320), MathHelper.method_15350((double)vec3d.field_1351, (double)box2.field_1322, (double)box2.field_1325), MathHelper.method_15350((double)vec3d.field_1350, (double)box2.field_1321, (double)box2.field_1324));
        for (double d2 : lmf) {
            Vec3d vec3d4 = vec3d2.method_35590(vec3d3, d2);
            Vec3d vec3d5 = lme.entry(box, vec3d, vec3d4);
            if (vec3d5 == null || !(vec3d5.method_1025(vec3d) <= d * d) || !lme.clear(world, entity, vec3d, vec3d5)) continue;
            return vec3d4;
        }
        return null;
    }

    public static Vec3d entry(Box box, Vec3d vec3d, Vec3d vec3d2) {
        if (box.method_1006(vec3d)) {
            return vec3d;
        }
        Vec3d vec3d3 = vec3d.method_1019(vec3d2.method_1020(vec3d).method_1021(1.5));
        Optional optional = box.method_992(vec3d, vec3d3);
        return optional.orElse(null);
    }

    public static boolean clear(World world, Entity entity, Vec3d vec3d, Vec3d vec3d2) {
        return world.method_17742(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, entity)).method_17783() == HitResult.Type.field_1333;
    }

    public static float yaw(Vec3d vec3d, Vec3d vec3d2) {
        return (float)(MathHelper.method_15349((double)(vec3d2.field_1350 - vec3d.field_1350), (double)(vec3d2.field_1352 - vec3d.field_1352)) * 57.2957763671875) - 90.0f;
    }

    public static float pitch(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.field_1352 - vec3d.field_1352;
        double d2 = vec3d2.field_1350 - vec3d.field_1350;
        return (float)(-(MathHelper.method_15349((double)(vec3d2.field_1351 - vec3d.field_1351), (double)Math.sqrt(d * d + d2 * d2)) * 57.2957763671875));
    }

    private static /* synthetic */ int axl(int n, int n2) {
        return n - n2 + -530778591;
    }

    private static /* synthetic */ int axm(int n, int n2) {
        return lme.axl(n, n2) ^ 0x2D6C5DE0;
    }

    private static /* synthetic */ int axn(int n, int n2) {
        return (n ^ n2) + -1121420715;
    }
}

