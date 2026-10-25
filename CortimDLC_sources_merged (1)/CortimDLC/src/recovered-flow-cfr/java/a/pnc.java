/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.util.PlayerInput
 */
package a;

import a.efz;
import a.izx;
import a.kfa;
import a.kfe;
import a.vhz;
import a.vzz;
import a.wap;
import flow.dev.a;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.PlayerInput;

public abstract class pnc
extends kfe {
    protected efz driver;
    private static /* synthetic */ long pnd;
    private static /* synthetic */ String pne;

    protected pnc(String string, String string2, kfa kfa2) {
        super(string, string2, kfa2);
    }

    public void attachBot(efz efz2) {
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

    protected ClientPlayerEntity getPlayer() {
        return this.mc.field_1724;
    }

    protected ClientWorld getWorld() {
        return this.mc.field_1687;
    }

    protected ClientPlayNetworkHandler getNetworkHandler() {
        return this.mc.method_1562();
    }

    protected ClientPlayerInteractionManager getInteractionManager() {
        return this.mc.field_1761;
    }

    protected boolean isNotInWorld() {
        return this.mc.field_1724 == null || this.mc.field_1687 == null;
    }

    protected boolean heldByHuman(KeyBinding keyBinding) {
        if (this.driver != null) {
            return this.driver.heldByHuman(keyBinding);
        }
        if (keyBinding == null || this.mc.method_22683() == null) {
            return false;
        }
        try {
            return vzz.isPhysicallyDown(this.mc, keyBinding);
        }
        catch (RuntimeException runtimeException) {
            return false;
        }
    }

    protected void silenceMovement() {
        GameOptions gameOptions = this.mc.field_1690;
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (gameOptions == null || clientPlayerEntity == null) {
            return;
        }
        gameOptions.field_1894.method_23481(false);
        gameOptions.field_1881.method_23481(false);
        gameOptions.field_1913.method_23481(false);
        gameOptions.field_1849.method_23481(false);
        gameOptions.field_1903.method_23481(false);
        gameOptions.field_1867.method_23481(false);
        if (clientPlayerEntity.method_5624()) {
            clientPlayerEntity.method_5728(false);
        }
    }

    protected boolean isMovementSilent() {
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity == null || clientPlayerEntity.field_3913 == null) {
            return false;
        }
        PlayerInput playerInput = clientPlayerEntity.field_3913.field_54155;
        return !clientPlayerEntity.method_5624() && !playerInput.comp_3159() && !playerInput.comp_3160() && !playerInput.comp_3161() && !playerInput.comp_3162() && !playerInput.comp_3163() && !playerInput.comp_3165();
    }

    protected void notifyUser(String string, boolean bl) {
        string = wap.t(string);
        if (this.driver != null) {
            this.driver.report(this.getName() + a.d("\uc383\uba28", 986616081, 231690922) + string, bl);
            return;
        }
        try {
            izx.alert(this.getName(), string, vhz.INFO, bl);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int blh(int n, int n2) {
        return n + n2 ^ 0x487E7358;
    }

    private static /* synthetic */ int bli(int n, int n2) {
        return pnc.blh(n, n2) + n;
    }
}

