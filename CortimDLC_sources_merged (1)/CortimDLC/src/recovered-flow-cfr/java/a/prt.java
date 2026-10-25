/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class prt {
    private static /* synthetic */ int pru;
    private static /* synthetic */ String prv;

    private prt() {
    }

    public static Vec3d getEyesPos(Entity entity) {
        return entity.method_73189().method_1031(0.0, (double)entity.method_18381(entity.method_18376()), 0.0);
    }

    public static float[] calculateAngle(Vec3d vec3d) {
        float[] fArray;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (minecraftClient.field_1724 == null) {
            float[] fArray2 = new float[2];
            fArray2[0] = 0.0f;
            fArray = fArray2;
            fArray2[1] = 0.0f;
        } else {
            fArray = prt.calculateAngle(prt.getEyesPos((Entity)minecraftClient.field_1724), vec3d);
        }
        return fArray;
    }

    public static float[] calculateAngle(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.field_1352 - vec3d.field_1352;
        double d2 = (vec3d2.field_1351 - vec3d.field_1351) * -1.0;
        double d3 = vec3d2.field_1350 - vec3d.field_1350;
        double d4 = MathHelper.method_15355((float)((float)(d * d + d3 * d3)));
        float f = (float)MathHelper.method_15338((double)(Math.toDegrees(Math.atan2(d3, d)) - 90.0));
        float f2 = (float)MathHelper.method_15350((double)MathHelper.method_15338((double)Math.toDegrees(Math.atan2(d2, d4))), (double)-90.0, (double)90.0);
        return new float[]{f, f2};
    }

    private static /* synthetic */ int bni(int n, int n2) {
        return n * n2 | 0xE974A574;
    }
}

