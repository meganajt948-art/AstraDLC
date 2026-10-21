/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package a;

import a.PacketGate;
import a.Reflect;
import a.KeyUtil;
import a.ForwardKeyHold;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_10185;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public final class IdleTracker {
    private static final Field vyo = Reflect.find(class_746.class, "net.minecraft.class_746", "field_54156", "Lnet/minecraft/class_10185;");
    private static int vyp;
    private final ForwardKeyHold vyq = new ForwardKeyHold();
    private final boolean vyr;
    private boolean vys;
    private boolean vyt;
    private boolean vyu;
    private static /* synthetic */ int vyv;
    private static /* synthetic */ long vyw;

    public IdleTracker() {
        this(false);
    }

    public IdleTracker(boolean bl) {
        this.vyr = bl;
    }

    public boolean idle(class_746 class_7462) {
        return this.vyr ? IdleTracker.vyx(class_7462, true) : IdleTracker.serverIdle(class_7462);
    }

    public static boolean serverIdle(class_746 class_7462) {
        return IdleTracker.vyx(class_7462, false);
    }

    private static boolean vyx(class_746 class_7462, boolean bl) {
        if (ForwardKeyHold.serverSprinting(class_7462)) {
            return false;
        }
        Object object = class_7462.field_3913.field_54155;
        if (vyo != null) {
            try {
                object = vyo.get(class_7462);
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        if (bl && object instanceof class_10185) {
            Object object2 = object;
            return !object2.comp_3159() && !object2.comp_3160() && !object2.comp_3161() && !object2.comp_3162() && !object2.comp_3163() && !object2.comp_3165();
        }
        return class_10185.field_54098.equals(object);
    }

    public static boolean still(class_746 class_7462) {
        double d = class_7462.method_23317() - class_7462.field_6014;
        double d2 = class_7462.method_23321() - class_7462.field_5969;
        return class_7462.method_24828() && d * d + d2 * d2 < 9.0E-4;
    }

    public static class_10185 lastSent(class_746 class_7462) {
        if (vyo != null) {
            try {
                Object object = vyo.get(class_7462);
                if (object instanceof class_10185) {
                    class_10185 class_101852 = (class_10185)object;
                    return class_101852;
                }
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        return class_7462.field_3913.field_54155;
    }

    public boolean isHeld() {
        return this.vys;
    }

    public static boolean anyHeld() {
        return vyp > 0;
    }

    public void hold(class_310 class_3102) {
        class_315 class_3152 = class_3102.field_1690;
        for (class_304 class_3042 : IdleTracker.vyy(class_3152)) {
            class_3042.method_23481(false);
        }
        class_304 class_3043 = class_3152.field_1832;
        if (this.vyr) {
            PacketGate.sneakOk(true);
        } else if (((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
            if (class_3043.method_1434()) {
                class_3043.method_23481(true);
                this.vyt = true;
            }
        } else {
            class_3043.method_23481(false);
        }
        class_304 class_3044 = class_3152.field_1867;
        if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            if (class_3044.method_1434()) {
                class_3044.method_23481(true);
                this.vyu = true;
            }
        } else {
            class_3044.method_23481(false);
        }
        this.vyq.hold(class_3102);
        if (!this.vys) {
            ++vyp;
        }
        this.vys = true;
    }

    public void release(class_310 class_3102) {
        if (!this.vys) {
            return;
        }
        this.vys = false;
        vyp = Math.max(0, vyp - 1);
        if (this.vyr) {
            PacketGate.sneakOk(false);
        }
        if (class_3102 == null || class_3102.field_1690 == null || class_3102.method_22683() == null) {
            this.vyt = false;
            this.vyu = false;
            this.vyq.release(class_3102);
            return;
        }
        class_315 class_3152 = class_3102.field_1690;
        for (class_304 class_3042 : IdleTracker.vyy(class_3152)) {
            class_3042.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3042));
        }
        class_304 class_3043 = class_3152.field_1832;
        if (!this.vyr) {
            if (((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
                if (this.vyt && !class_3043.method_1434()) {
                    class_3043.method_23481(true);
                }
            } else {
                class_3043.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3043));
            }
        }
        this.vyt = false;
        class_304 class_3044 = class_3152.field_1867;
        if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            if (this.vyu && !class_3044.method_1434()) {
                class_3044.method_23481(true);
            }
        } else {
            class_3044.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3044));
        }
        this.vyu = false;
        this.vyq.release(class_3102);
    }

    private static class_304[] vyy(class_315 class_3152) {
        return new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903, class_3152.field_1904};
    }

    private static /* synthetic */ int dmt(int n, int n2) {
        return n + n2 | 0xD3FC7534;
    }
}

