/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package a;

import a.AutoSprint;
import a.Reflect;
import a.KeyUtil;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1294;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_746;

public final class ForwardKeyHold {
    private static final Field wdu = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3919", "Z");
    private static int wdv;
    private static int wdw;
    private boolean wdx;
    private boolean wdy;
    private static /* synthetic */ boolean wdz;
    private static /* synthetic */ long wea;

    public static boolean anyHeld() {
        return wdv > 0;
    }

    public static boolean serverSprinting(class_746 class_7462) {
        return Reflect.getBoolean(wdu, class_7462, class_7462.method_5624());
    }

    public boolean isHeld() {
        return this.wdx;
    }

    public void hold(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (!this.wdx) {
            this.wdy = class_7462.method_5624() || Reflect.getBoolean(wdu, class_7462, false);
            ++wdv;
        }
        class_3102.field_1690.field_1894.method_23481(false);
        this.wdx = true;
    }

    public void release(class_310 class_3102) {
        if (!this.wdx) {
            return;
        }
        this.wdx = false;
        wdv = Math.max(0, wdv - 1);
        if (class_3102 == null || class_3102.field_1690 == null || class_3102.field_1724 == null) {
            this.wdy = false;
            return;
        }
        class_304 class_3042 = class_3102.field_1690.field_1894;
        class_3042.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3042));
        class_746 class_7462 = class_3102.field_1724;
        if (this.wdy && !AutoSprint.active() && !((Boolean)class_3102.field_1690.method_42450().method_41753()).booleanValue() && !class_3102.field_1690.field_1867.method_1434() && ForwardKeyHold.canResumeSprint(class_3102, class_7462)) {
            class_3102.field_1690.field_1867.method_23481(true);
            wdw = 2;
        }
        this.wdy = false;
    }

    public static void settle(class_310 class_3102) {
        if (wdw <= 0 || --wdw > 0) {
            return;
        }
        if (class_3102.field_1690 != null && class_3102.method_22683() != null && !((Boolean)class_3102.field_1690.method_42450().method_41753()).booleanValue()) {
            class_3102.field_1690.field_1867.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3102.field_1690.field_1867));
        }
    }

    public static boolean canResumeSprint(class_310 class_3102, class_746 class_7462) {
        return class_3102.field_1690.field_1894.method_1434() && !class_3102.field_1690.field_1881.method_1434() && !class_7462.method_5715() && !class_7462.method_6115() && !class_7462.field_5976 && !class_7462.method_5799() && !class_7462.method_6128() && !class_7462.method_6059(class_1294.field_5919) && (class_7462.method_7344().method_7586() > 6 || class_7462.method_31549().field_7478);
    }

    private static /* synthetic */ int dpn(int n, int n2) {
        return n - n2 ^ 0x6C1C70E9;
    }

    private static /* synthetic */ int dpo(int n, int n2) {
        return n - n2 + -814904496;
    }
}

