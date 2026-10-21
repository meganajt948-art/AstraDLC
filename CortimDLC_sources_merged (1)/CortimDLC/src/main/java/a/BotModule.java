/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_304
 *  net.minecraft.class_315
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.BotHost;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.Icon;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_10185;
import net.minecraft.class_304;
import net.minecraft.class_315;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;

public abstract class BotModule
extends Module {
    protected BotHost driver;
    private static /* synthetic */ long pnd;
    private static /* synthetic */ String pne;

    protected BotModule(String string, String string2, ModuleCategory kfa2) {
        super(string, string2, kfa2);
    }

    public void attachBot(BotHost efz2) {
        this.driver = efz2;
    }

    public boolean isBotInstance() {
        return this.driver != null;
    }

    public void setBotRunning(boolean bl) {
        this.setEnabledSilently(bl);
    }

    @Override
    public void setEnabled(boolean bl) {
        if (this.driver != null) {
            this.setEnabledSilently(bl);
            return;
        }
        super.setEnabled(bl);
    }

    protected class_746 getPlayer() {
        return this.mc.field_1724;
    }

    protected class_638 getWorld() {
        return this.mc.field_1687;
    }

    protected class_634 getNetworkHandler() {
        return this.mc.method_1562();
    }

    protected class_636 getInteractionManager() {
        return this.mc.field_1761;
    }

    protected boolean isNotInWorld() {
        return this.mc.field_1724 == null || this.mc.field_1687 == null;
    }

    protected boolean heldByHuman(class_304 class_3042) {
        if (this.driver != null) {
            return this.driver.heldByHuman(class_3042);
        }
        if (class_3042 == null || this.mc.method_22683() == null) {
            return false;
        }
        try {
            return KeyUtil.isPhysicallyDown(this.mc, class_3042);
        }
        catch (RuntimeException runtimeException) {
            return false;
        }
    }

    protected void silenceMovement() {
        class_315 class_3152 = this.mc.field_1690;
        class_746 class_7462 = this.mc.field_1724;
        if (class_3152 == null || class_7462 == null) {
            return;
        }
        class_3152.field_1894.method_23481(false);
        class_3152.field_1881.method_23481(false);
        class_3152.field_1913.method_23481(false);
        class_3152.field_1849.method_23481(false);
        class_3152.field_1903.method_23481(false);
        class_3152.field_1867.method_23481(false);
        if (class_7462.method_5624()) {
            class_7462.method_5728(false);
        }
    }

    protected boolean isMovementSilent() {
        class_746 class_7462 = this.mc.field_1724;
        if (class_7462 == null || class_7462.field_3913 == null) {
            return false;
        }
        class_10185 class_101852 = class_7462.field_3913.field_54155;
        return !class_7462.method_5624() && !class_101852.comp_3159() && !class_101852.comp_3160() && !class_101852.comp_3161() && !class_101852.comp_3162() && !class_101852.comp_3163() && !class_101852.comp_3165();
    }

    protected void notifyUser(String string, boolean bl) {
        string = Lang.t(string);
        if (this.driver != null) {
            this.driver.report(this.getName() + ": " + string, bl);
            return;
        }
        try {
            Hud.alert(this.getName(), string, Icon.INFO, bl);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int blh(int n, int n2) {
        return n + n2 ^ 0x487E7358;
    }

    private static /* synthetic */ int bli(int n, int n2) {
        return BotModule.blh(n, n2) + n;
    }
}

