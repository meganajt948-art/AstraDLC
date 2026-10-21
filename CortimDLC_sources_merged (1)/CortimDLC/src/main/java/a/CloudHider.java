/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_9955
 */
package a;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_310;
import net.minecraft.class_9955;

public final class CloudHider {
    private static final Set<Object> ujm = new HashSet<Object>();
    private static Field ujn;
    private static boolean ujo;
    private static Object ujp;
    private static /* synthetic */ long ujq;
    private static /* synthetic */ int ujr;

    private CloudHider() {
    }

    public static void hide(Object object, boolean bl) {
        if (bl) {
            ujm.add(object);
        } else {
            ujm.remove(object);
        }
        CloudHider.ujs(!ujm.isEmpty());
    }

    private static void ujs(boolean bl) {
        class_310 class_3102 = class_310.method_1551();
        if (ujo || class_3102.field_1769 == null) {
            return;
        }
        try {
            class_9955 class_99552 = class_3102.field_1769.method_62196();
            if (ujn == null) {
                for (Field field : class_9955.class.getDeclaredFields()) {
                    if (!field.getType().isRecord() || field.getType().getEnclosingClass() != class_9955.class) continue;
                    field.setAccessible(true);
                    ujn = field;
                    break;
                }
                if (ujn == null) {
                    throw new IllegalStateException("cloud cells field not found");
                }
            }
            Object object = ujn.get(class_99552);
            if (bl) {
                if (object != null) {
                    ujp = object;
                    ujn.set(class_99552, null);
                }
            } else if (ujp != null) {
                if (object == null) {
                    ujn.set(class_99552, ujp);
                }
                ujp = null;
            }
        }
        catch (Throwable throwable) {
            ujo = true;
            System.out.println("can't hide clouds: " + throwable);
        }
    }

    private static /* synthetic */ int cxj(int n, int n2) {
        return n + n2 + 1437894466;
    }

    private static /* synthetic */ int cxk(int n, int n2) {
        return CloudHider.cxj(n, n2) * n2;
    }

    private static /* synthetic */ int cxl(int n, int n2) {
        return n + n2 ^ 0xC72A9146;
    }
}

