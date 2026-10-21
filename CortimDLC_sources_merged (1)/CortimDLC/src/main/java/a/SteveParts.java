/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_10042
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_572
 *  net.minecraft.class_583
 *  net.minecraft.class_7833
 *  net.minecraft.class_897
 *  net.minecraft.class_922
 *  org.joml.Matrix3f
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.spg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_572;
import net.minecraft.class_583;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_922;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.jspecify.annotations.Nullable;

final class SteveParts {
    private static final float ssk = 0.9375f;
    private static /* synthetic */ long ssl;
    private static /* synthetic */ int ssm;

    private SteveParts() {
    }

    static @Nullable List<spg> capture(class_310 class_3102, class_1309 class_13092, float f, double[] dArray) {
        try {
            class_897 class_8972 = class_3102.method_1561().method_3953((class_1297)class_13092);
            if (!(class_8972 instanceof class_922)) {
                return null;
            }
            class_922 class_9222 = (class_922)class_8972;
            class_10017 class_100172 = class_8972.method_62425((class_1297)class_13092, f);
            if (!(class_100172 instanceof class_10042)) {
                return null;
            }
            class_10042 class_100422 = (class_10042)class_100172;
            class_583 class_5832 = class_9222.method_4038();
            SteveParts.ssr(class_5832, class_100422);
            boolean bl = class_5832 instanceof class_572;
            boolean bl2 = class_13092 instanceof class_1657;
            class_4587 class_45872 = SteveParts.sso(class_100422.field_53453, class_100422.field_53446, bl2 ? 0.9375f : 1.0f);
            ArrayList arrayList = new ArrayList();
            class_5832.method_63512().method_35745(class_45872, (class_46652, string, n, class_6282) -> {
                if (bl && string.lastIndexOf(47) > 0) {
                    return;
                }
                arrayList.add(SteveParts.ssp(class_46652.method_23761(), class_46652.method_23762(), class_6282.field_3645, class_6282.field_3644, class_6282.field_3643, class_6282.field_3648, class_6282.field_3647, class_6282.field_3646, SteveParts.ssq(class_13092, string, bl)));
            });
            class_5832.method_63514();
            dArray[0] = class_100422.field_53325;
            dArray[1] = class_100422.field_53326;
            dArray[2] = class_100422.field_53327;
            return arrayList.isEmpty() || arrayList.size() > 64 ? null : arrayList;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static List<spg> steve(float f, float f2) {
        class_4587 class_45872 = SteveParts.sso(1.0f, f, 0.9375f * f2);
        ArrayList<spg> arrayList = new ArrayList<spg>();
        SteveParts.ssn(arrayList, class_45872, 0.0f, 0.0f, 0.0f, -4.0f, -8.0f, -4.0f, 4.0f, 0.0f, 4.0f);
        SteveParts.ssn(arrayList, class_45872, 0.0f, 0.0f, 0.0f, -4.0f, 0.0f, -2.0f, 4.0f, 12.0f, 2.0f);
        SteveParts.ssn(arrayList, class_45872, -5.0f, 2.0f, 0.0f, -3.0f, -2.0f, -2.0f, 1.0f, 10.0f, 2.0f);
        SteveParts.ssn(arrayList, class_45872, 5.0f, 2.0f, 0.0f, -1.0f, -2.0f, -2.0f, 3.0f, 10.0f, 2.0f);
        SteveParts.ssn(arrayList, class_45872, -1.9f, 12.0f, 0.0f, -2.0f, 0.0f, -2.0f, 2.0f, 12.0f, 2.0f);
        SteveParts.ssn(arrayList, class_45872, 1.9f, 12.0f, 0.0f, -2.0f, 0.0f, -2.0f, 2.0f, 12.0f, 2.0f);
        return arrayList;
    }

    private static void ssn(List<spg> list, class_4587 class_45872, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        class_45872.method_22903();
        class_45872.method_46416(f / 16.0f, f2 / 16.0f, f3 / 16.0f);
        class_4587.class_4665 class_46652 = class_45872.method_23760();
        list.add(SteveParts.ssp(class_46652.method_23761(), class_46652.method_23762(), f4, f5, f6, f7, f8, f9, 0.6f));
        class_45872.method_22909();
    }

    private static class_4587 sso(float f, float f2, float f3) {
        class_4587 class_45872 = new class_4587();
        class_45872.method_22905(f, f, f);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(180.0f - f2));
        class_45872.method_22905(-1.0f, -1.0f, 1.0f);
        class_45872.method_22905(f3, f3, f3);
        class_45872.method_46416(0.0f, -1.501f, 0.0f);
        return class_45872;
    }

    private static spg ssp(Matrix4f matrix4f, Matrix3f matrix3f, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f).translate((f + f4) / 32.0f, (f2 + f5) / 32.0f, (f3 + f6) / 32.0f);
        float f8 = f7 / 16.0f;
        return new spg(matrix4f2, new Matrix3f((Matrix3fc)matrix3f), (f4 - f) / 32.0f + f8, (f5 - f2) / 32.0f + f8, (f6 - f3) / 32.0f + f8);
    }

    private static float ssq(class_1309 class_13092, String string, boolean bl) {
        class_1304 class_13042;
        if (!bl) {
            return 0.35f;
        }
        switch (string) {
            case "/head": {
                class_1304 class_13043 = class_1304.field_6169;
                break;
            }
            case "/body": 
            case "/right_arm": 
            case "/left_arm": {
                class_1304 class_13043 = class_1304.field_6174;
                break;
            }
            case "/right_leg": 
            case "/left_leg": {
                class_1304 class_13043 = class_1304.field_6172;
                break;
            }
            default: {
                class_1304 class_13043 = class_13042 = null;
            }
        }
        if (class_13042 == null) {
            return 0.6f;
        }
        boolean bl2 = !class_13092.method_6118(class_13042).method_7960() || class_13042 == class_1304.field_6172 && !class_13092.method_6118(class_1304.field_6166).method_7960();
        return bl2 ? 1.1f : 0.6f;
    }

    private static void ssr(class_583 class_5832, class_10042 class_100422) {
        class_5832.method_2819((Object)class_100422);
    }

    private static /* synthetic */ int cfy(int n, int n2) {
        return n - n2 + 285986961;
    }

    private static /* synthetic */ int cfz(int n, int n2) {
        return n + n2 ^ 0xE42D6525;
    }
}

