/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class lqk {
    private static final int lql = 5;
    private static final double lqm = 0.08;
    private final Box[] lqn = new Box[40];
    private static /* synthetic */ long lqo;
    private static /* synthetic */ String lqp;

    public void predict(Entity entity, World world) {
        Box box = entity.getBoundingBox();
        double d = entity.getX() - entity.lastX;
        double d2 = entity.getY() - entity.lastY;
        double d3 = entity.getZ() - entity.lastZ;
        boolean bl = entity.isOnGround();
        d2 = bl ? 0.0 : (d2 - 0.08) * 0.98;
        for (int i = 0; i < this.lqn.length; ++i) {
            double d4;
            this.lqn[i] = box;
            double d5 = i < 5 ? d : 0.0;
            double d6 = i < 5 ? d3 : 0.0;
            double d7 = d4 = bl ? 0.0 : d2;
            if (d5 == 0.0 && d4 == 0.0 && d6 == 0.0) continue;
            Vec3d vec3d = Entity.adjustMovementForCollisions((Entity)entity, (Vec3d)new Vec3d(d5, d4, d6), (Box)box, (World)world, List.of());
            if (!bl) {
                if (vec3d.y != d4 && d4 < 0.0) {
                    bl = true;
                    d2 = 0.0;
                } else {
                    d2 = (d2 - 0.08) * 0.98;
                }
            }
            box = box.offset(vec3d);
        }
    }

    public Box box(int n) {
        return this.lqn[MathHelper.clamp((int)n, (int)0, (int)(this.lqn.length - 1))];
    }

    private static /* synthetic */ int aym(int n, int n2) {
        return n ^ n2 ^ 0xD6D5FB29;
    }

    private static /* synthetic */ int ayn(int n, int n2) {
        return lqk.aym(n, n2) ^ 0xDCFB0E1A;
    }
}

