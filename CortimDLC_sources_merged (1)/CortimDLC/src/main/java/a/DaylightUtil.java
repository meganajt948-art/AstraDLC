/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_12206
 *  net.minecraft.class_1944
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 */
package a;

import net.minecraft.class_12206;
import net.minecraft.class_1944;
import net.minecraft.class_310;
import net.minecraft.class_4184;

public final class DaylightUtil {
    private static float uht = -1.0f;
    private static long uhu;
    private static /* synthetic */ String uhv;
    private static /* synthetic */ boolean uhw;

    private DaylightUtil() {
    }

    public static float daylight(class_310 class_3102) {
        try {
            Float f = (Float)class_3102.field_1773.method_19418().method_75756().method_75689(class_12206.field_64346, 1.0f);
            return f == null ? 1.0f : Math.max(0.0f, Math.min(1.0f, f.floatValue()));
        }
        catch (RuntimeException runtimeException) {
            return 1.0f;
        }
    }

    public static float boost(class_310 class_3102) {
        Double d = (Double)class_3102.field_1690.method_42473().method_41753();
        return d == null ? 0.0f : (float)Math.max(0.0, Math.min(1.0, (d - 1.0) / 5.0));
    }

    public static float light(class_310 class_3102) {
        float f;
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        float f2 = 0.5f;
        if (class_3102.field_1687 != null && class_41842.method_19332()) {
            float f3 = (float)class_3102.field_1687.method_8314(class_1944.field_9284, class_41842.method_19328()) / 15.0f;
            float f4 = (float)class_3102.field_1687.method_8314(class_1944.field_9282, class_41842.method_19328()) / 15.0f;
            f = DaylightUtil.daylight(class_3102);
            f2 = Math.max(f3 * (0.18f + 0.82f * f), f4 * 0.75f);
            f2 = Math.max(f2, 0.08f);
            f2 += (1.0f - f2) * DaylightUtil.boost(class_3102);
        }
        long l = System.nanoTime();
        f = uhu == 0L ? 1.0f : Math.min(1.0f, (float)(l - uhu) / 1.0E9f);
        uhu = l;
        uht = uht < 0.0f ? f2 : (uht += (f2 - uht) * (1.0f - (float)Math.exp(-f / 0.6f)));
        return uht;
    }

    private static /* synthetic */ int cwx(int n, int n2) {
        return n + n2 | 0x94FD0799;
    }

    private static /* synthetic */ int cwy(int n, int n2) {
        return DaylightUtil.cwx(n, n2) ^ 0xFE129B17;
    }
}

