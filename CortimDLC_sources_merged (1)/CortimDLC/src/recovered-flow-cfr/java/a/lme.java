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
        double d2 = MathHelper.clamp((double)d, (double)0.0, (double)0.9);
        this.lmi = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
        this.lmj = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
        this.lmk = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
    }

    public Vec3d on(Box box) {
        return new Vec3d(MathHelper.lerp((double)this.lmi, (double)box.minX, (double)box.maxX), MathHelper.lerp((double)this.lmj, (double)box.minY, (double)box.maxY), MathHelper.lerp((double)this.lmk, (double)box.minZ, (double)box.maxZ));
    }

    public Vec3d resolve(World world, Entity entity, Vec3d vec3d, Box box, double d) {
        Vec3d vec3d2 = this.on(box);
        if (box.contains(vec3d)) {
            return vec3d2;
        }
        if (box.squaredMagnitude(vec3d) > d * d) {
            return null;
        }
        Box box2 = box.contract(Math.min(0.12, box.getLengthX() * 0.25), Math.min(0.12, box.getLengthY() * 0.25), Math.min(0.12, box.getLengthZ() * 0.25));
        Vec3d vec3d3 = new Vec3d(MathHelper.clamp((double)vec3d.x, (double)box2.minX, (double)box2.maxX), MathHelper.clamp((double)vec3d.y, (double)box2.minY, (double)box2.maxY), MathHelper.clamp((double)vec3d.z, (double)box2.minZ, (double)box2.maxZ));
        for (double d2 : lmf) {
            Vec3d vec3d4 = vec3d2.lerp(vec3d3, d2);
            Vec3d vec3d5 = lme.entry(box, vec3d, vec3d4);
            if (vec3d5 == null || !(vec3d5.squaredDistanceTo(vec3d) <= d * d) || !lme.clear(world, entity, vec3d, vec3d5)) continue;
            return vec3d4;
        }
        return null;
    }

    public static Vec3d entry(Box box, Vec3d vec3d, Vec3d vec3d2) {
        if (box.contains(vec3d)) {
            return vec3d;
        }
        Vec3d vec3d3 = vec3d.add(vec3d2.subtract(vec3d).multiply(1.5));
        Optional optional = box.raycast(vec3d, vec3d3);
        return optional.orElse(null);
    }

    public static boolean clear(World world, Entity entity, Vec3d vec3d, Vec3d vec3d2) {
        return world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getType() == HitResult.Type.MISS;
    }

    public static float yaw(Vec3d vec3d, Vec3d vec3d2) {
        return (float)(MathHelper.atan2((double)(vec3d2.z - vec3d.z), (double)(vec3d2.x - vec3d.x)) * 57.2957763671875) - 90.0f;
    }

    public static float pitch(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.z - vec3d.z;
        return (float)(-(MathHelper.atan2((double)(vec3d2.y - vec3d.y), (double)Math.sqrt(d * d + d2 * d2)) * 57.2957763671875));
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

