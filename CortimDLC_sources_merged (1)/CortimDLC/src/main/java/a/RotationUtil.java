/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 */
package a;

import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;

public final class RotationUtil {
    private static /* synthetic */ int pru;
    private static /* synthetic */ String prv;

    private RotationUtil() {
    }

    public static class_243 getEyesPos(class_1297 class_12972) {
        return class_12972.method_73189().method_1031(0.0, (double)class_12972.method_18381(class_12972.method_18376()), 0.0);
    }

    public static float[] calculateAngle(class_243 class_2432) {
        float[] fArray;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null) {
            float[] fArray2 = new float[2];
            fArray2[0] = 0.0f;
            fArray = fArray2;
            fArray2[1] = 0.0f;
        } else {
            fArray = RotationUtil.calculateAngle(RotationUtil.getEyesPos((class_1297)class_3102.field_1724), class_2432);
        }
        return fArray;
    }

    public static float[] calculateAngle(class_243 class_2432, class_243 class_2433) {
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = (class_2433.field_1351 - class_2432.field_1351) * -1.0;
        double d3 = class_2433.field_1350 - class_2432.field_1350;
        double d4 = class_3532.method_15355((float)((float)(d * d + d3 * d3)));
        float f = (float)class_3532.method_15338((double)(Math.toDegrees(Math.atan2(d3, d)) - 90.0));
        float f2 = (float)class_3532.method_15350((double)class_3532.method_15338((double)Math.toDegrees(Math.atan2(d2, d4))), (double)-90.0, (double)90.0);
        return new float[]{f, f2};
    }

    private static /* synthetic */ int bni(int n, int n2) {
        return n * n2 | 0xE974A574;
    }
}

