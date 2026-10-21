/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_266
 *  net.minecraft.class_269
 *  net.minecraft.class_310
 *  net.minecraft.class_8646
 *  net.minecraft.class_9013
 *  net.minecraft.class_9015
 */
package a;

import a.vyd;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_310;
import net.minecraft.class_8646;
import net.minecraft.class_9013;
import net.minecraft.class_9015;

public final class BelowNameHook {
    public static final int HIDDEN = 1000;
    private static /* synthetic */ boolean vyl;
    private static /* synthetic */ long vym;

    private BelowNameHook() {
    }

    public static vyd of(class_1309 class_13092) {
        class_1657 class_16572;
        Integer n;
        float f = Math.max(1.0f, class_13092.method_6063());
        if (class_13092 instanceof class_1657 && (n = BelowNameHook.belowName(class_16572 = (class_1657)class_13092)) != null) {
            if (n >= 1000) {
                return new vyd(f, 0.0f, f, true);
            }
            return new vyd(Math.max(0, n), 0.0f, f, false);
        }
        float f2 = class_13092.method_6032();
        boolean bl = class_13092.method_5767() || Float.isNaN(f2) || f2 > Math.max(f, 20.0f) * 1.5f;
        return new vyd(f2, class_13092.method_6067(), f, bl);
    }

    public static Integer belowName(class_1657 class_16572) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null) {
            return null;
        }
        class_269 class_2692 = class_3102.field_1687.method_8428();
        class_266 class_2662 = class_2692.method_1189(class_8646.field_45158);
        if (class_2662 == null) {
            return null;
        }
        class_9013 class_90132 = class_2692.method_55430((class_9015)class_16572, class_2662);
        return class_90132 != null ? Integer.valueOf(class_90132.method_55397()) : null;
    }

    private static /* synthetic */ int dmo(int n, int n2) {
        return n - n2 | 0xDA4721DC;
    }

    private static /* synthetic */ int dmp(int n, int n2) {
        return n * n2 + -331469670;
    }

    private static /* synthetic */ int dmq(int n, int n2) {
        return n * n2 + 900728126;
    }
}

