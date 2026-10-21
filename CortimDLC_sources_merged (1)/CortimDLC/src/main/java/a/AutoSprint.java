/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.KeyPearl;
import a.ServerHelper;
import a.IdleTracker;
import a.KeyUtil;
import flow.dev.StringDecryptor;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public class AutoSprint
extends Module {
    private static final int lwi = 7;
    private static AutoSprint lwj;
    private boolean lwk;
    private boolean lwl;
    private static /* synthetic */ String lwm;
    private static /* synthetic */ String lwn;

    public AutoSprint() {
        super("AutoSprint", "Sprints while you walk forward", ModuleCategory.MOVEMENT);
        lwj = this;
    }

    public static boolean active() {
        return lwj != null && lwj.isEnabled();
    }

    public static boolean wants(class_310 class_3102, class_746 class_7462) {
        class_315 class_3152 = class_3102.field_1690;
        return (class_7462.method_7344().method_7586() >= 7 || class_7462.method_31549().field_7478) && KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1894) && !KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1881) && !class_3152.field_1832.method_1434();
    }

    @Override
    protected void onDisable() {
        this.lwp(this.mc);
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_3102.field_1755 != null || IdleTracker.anyHeld() || ServerHelper.busy() || KeyPearl.busy()) {
            return;
        }
        if (!class_7462.method_7325() && !class_7462.method_5765() && AutoSprint.wants(class_3102, class_7462)) {
            this.lwo(class_3102.field_1690);
        } else {
            this.lwp(class_3102);
        }
    }

    private void lwo(class_315 class_3152) {
        class_304 class_3042 = class_3152.field_1867;
        if (((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            if (!class_3042.method_1434()) {
                class_3042.method_23481(true);
                this.lwl = true;
            }
        } else {
            class_3042.method_23481(true);
        }
        this.lwk = true;
    }

    private void lwp(class_310 class_3102) {
        if (!this.lwk) {
            return;
        }
        this.lwk = false;
        if (class_3102 == null || class_3102.field_1690 == null || class_3102.method_22683() == null) {
            this.lwl = false;
            return;
        }
        class_304 class_3042 = class_3102.field_1690.field_1867;
        if (((Boolean)class_3102.field_1690.method_42450().method_41753()).booleanValue()) {
            if (this.lwl && class_3042.method_1434()) {
                class_3042.method_23481(true);
            }
        } else {
            class_3042.method_23481(KeyUtil.isPhysicallyDown(class_3102, class_3042));
        }
        this.lwl = false;
    }

    private static /* synthetic */ int azv(int n, int n2) {
        return n + n2 + 1471577964;
    }

    private static /* synthetic */ int azw(int n, int n2) {
        return AutoSprint.azv(n, n2) * n2;
    }
}

