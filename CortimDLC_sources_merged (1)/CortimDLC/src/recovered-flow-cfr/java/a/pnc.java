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
        return this.mc.player;
    }

    protected ClientWorld getWorld() {
        return this.mc.world;
    }

    protected ClientPlayNetworkHandler getNetworkHandler() {
        return this.mc.getNetworkHandler();
    }

    protected ClientPlayerInteractionManager getInteractionManager() {
        return this.mc.interactionManager;
    }

    protected boolean isNotInWorld() {
        return this.mc.player == null || this.mc.world == null;
    }

    protected boolean heldByHuman(KeyBinding keyBinding) {
        if (this.driver != null) {
            return this.driver.heldByHuman(keyBinding);
        }
        if (keyBinding == null || this.mc.getWindow() == null) {
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
        GameOptions gameOptions = this.mc.options;
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (gameOptions == null || clientPlayerEntity == null) {
            return;
        }
        gameOptions.forwardKey.setPressed(false);
        gameOptions.backKey.setPressed(false);
        gameOptions.leftKey.setPressed(false);
        gameOptions.rightKey.setPressed(false);
        gameOptions.jumpKey.setPressed(false);
        gameOptions.sprintKey.setPressed(false);
        if (clientPlayerEntity.isSprinting()) {
            clientPlayerEntity.setSprinting(false);
        }
    }

    protected boolean isMovementSilent() {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (clientPlayerEntity == null || clientPlayerEntity.input == null) {
            return false;
        }
        PlayerInput playerInput = clientPlayerEntity.input.playerInput;
        return !clientPlayerEntity.isSprinting() && !playerInput.forward() && !playerInput.backward() && !playerInput.left() && !playerInput.right() && !playerInput.jump() && !playerInput.sprint();
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

