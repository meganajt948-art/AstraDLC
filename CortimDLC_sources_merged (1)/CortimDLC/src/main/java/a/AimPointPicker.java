/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 */
package a;

import java.util.Optional;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;

public final class AimPointPicker {
    private static final double[] lmf = new double[]{0.0, 0.35, 0.6, 0.8, 1.0};
    private static final double lmg = 0.12;
    private final Random lmh = new Random();
    private double lmi = 0.5;
    private double lmj = 0.5;
    private double lmk = 0.5;
    private static /* synthetic */ String lml;
    private static /* synthetic */ boolean lmm;

    public void roll(double d) {
        double d2 = class_3532.method_15350((double)d, (double)0.0, (double)0.9);
        this.lmi = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
        this.lmj = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
        this.lmk = 0.5 + (this.lmh.nextDouble() - 0.5) * d2;
    }

    public class_243 on(class_238 class_2383) {
        return new class_243(class_3532.method_16436((double)this.lmi, (double)class_2383.field_1323, (double)class_2383.field_1320), class_3532.method_16436((double)this.lmj, (double)class_2383.field_1322, (double)class_2383.field_1325), class_3532.method_16436((double)this.lmk, (double)class_2383.field_1321, (double)class_2383.field_1324));
    }

    public class_243 resolve(class_1937 class_19372, class_1297 class_12972, class_243 class_2432, class_238 class_2383, double d) {
        class_243 class_2433 = this.on(class_2383);
        if (class_2383.method_1006(class_2432)) {
            return class_2433;
        }
        if (class_2383.method_49271(class_2432) > d * d) {
            return null;
        }
        class_238 class_2384 = class_2383.method_35580(Math.min(0.12, class_2383.method_17939() * 0.25), Math.min(0.12, class_2383.method_17940() * 0.25), Math.min(0.12, class_2383.method_17941() * 0.25));
        class_243 class_2434 = new class_243(class_3532.method_15350((double)class_2432.field_1352, (double)class_2384.field_1323, (double)class_2384.field_1320), class_3532.method_15350((double)class_2432.field_1351, (double)class_2384.field_1322, (double)class_2384.field_1325), class_3532.method_15350((double)class_2432.field_1350, (double)class_2384.field_1321, (double)class_2384.field_1324));
        for (double d2 : lmf) {
            class_243 class_2435 = class_2433.method_35590(class_2434, d2);
            class_243 class_2436 = AimPointPicker.entry(class_2383, class_2432, class_2435);
            if (class_2436 == null || !(class_2436.method_1025(class_2432) <= d * d) || !AimPointPicker.clear(class_19372, class_12972, class_2432, class_2436)) continue;
            return class_2435;
        }
        return null;
    }

    public static class_243 entry(class_238 class_2383, class_243 class_2432, class_243 class_2433) {
        if (class_2383.method_1006(class_2432)) {
            return class_2432;
        }
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1020(class_2432).method_1021(1.5));
        Optional optional = class_2383.method_992(class_2432, class_2434);
        return optional.orElse(null);
    }

    public static boolean clear(class_1937 class_19372, class_1297 class_12972, class_243 class_2432, class_243 class_2433) {
        return class_19372.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, class_12972)).method_17783() == class_239.class_240.field_1333;
    }

    public static float yaw(class_243 class_2432, class_243 class_2433) {
        return (float)(class_3532.method_15349((double)(class_2433.field_1350 - class_2432.field_1350), (double)(class_2433.field_1352 - class_2432.field_1352)) * 57.2957763671875) - 90.0f;
    }

    public static float pitch(class_243 class_2432, class_243 class_2433) {
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        return (float)(-(class_3532.method_15349((double)(class_2433.field_1351 - class_2432.field_1351), (double)Math.sqrt(d * d + d2 * d2)) * 57.2957763671875));
    }

    private static /* synthetic */ int axl(int n, int n2) {
        return n - n2 + -530778591;
    }

    private static /* synthetic */ int axm(int n, int n2) {
        return AimPointPicker.axl(n, n2) ^ 0x2D6C5DE0;
    }

    private static /* synthetic */ int axn(int n, int n2) {
        return (n ^ n2) + -1121420715;
    }
}

