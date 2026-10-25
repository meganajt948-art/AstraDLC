/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 */
package a;

import a.kfa;
import a.kfe;
import a.kvz;
import a.oxw;
import a.vyn;
import a.vzz;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public class lwh
extends kfe {
    private static final int lwi = 7;
    private static lwh lwj;
    private boolean lwk;
    private boolean lwl;
    private static /* synthetic */ String lwm;
    private static /* synthetic */ String lwn;

    public lwh() {
        super(a.d("\u5c83\u2506\uafd4\u31be\uba55\u3cc7\u8696\u0f7c\u9124\u1b8f", 2043464830, -1213755210), a.b("\u8826\uf1b4\u7b65\ue50f\u6edf\ue874\u5220\udb82\u458a\ucf24\u48f6\ub282\u3c5c\ua5a8\u2fa2\ua945\u1310\u9c94\u0670\u8037\u09cd\u739b\ufd63\u66f4\ue082\u6a4e\ud3f8\u5dbf\uc75b\u411c", 1527351403), kfa.MOVEMENT);
        lwj = this;
    }

    public static boolean active() {
        return lwj != null && lwj.isEnabled();
    }

    public static boolean wants(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        GameOptions gameOptions = minecraftClient.options;
        return (clientPlayerEntity.getHungerManager().getFoodLevel() >= 7 || clientPlayerEntity.getAbilities().allowFlying) && vzz.isPhysicallyDown(minecraftClient, gameOptions.forwardKey) && !vzz.isPhysicallyDown(minecraftClient, gameOptions.backKey) && !gameOptions.sneakKey.isPressed();
    }

    @Override
    protected void onDisable() {
        this.lwp(this.mc);
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (minecraftClient.currentScreen != null || vyn.anyHeld() || oxw.busy() || kvz.busy()) {
            return;
        }
        if (!clientPlayerEntity.isSpectator() && !clientPlayerEntity.hasVehicle() && lwh.wants(minecraftClient, clientPlayerEntity)) {
            this.lwo(minecraftClient.options);
        } else {
            this.lwp(minecraftClient);
        }
    }

    private void lwo(GameOptions gameOptions) {
        KeyBinding keyBinding = gameOptions.sprintKey;
        if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            if (!keyBinding.isPressed()) {
                keyBinding.setPressed(true);
                this.lwl = true;
            }
        } else {
            keyBinding.setPressed(true);
        }
        this.lwk = true;
    }

    private void lwp(MinecraftClient minecraftClient) {
        if (!this.lwk) {
            return;
        }
        this.lwk = false;
        if (minecraftClient == null || minecraftClient.options == null || minecraftClient.getWindow() == null) {
            this.lwl = false;
            return;
        }
        KeyBinding keyBinding = minecraftClient.options.sprintKey;
        if (((Boolean)minecraftClient.options.getSprintToggled().getValue()).booleanValue()) {
            if (this.lwl && keyBinding.isPressed()) {
                keyBinding.setPressed(true);
            }
        } else {
            keyBinding.setPressed(vzz.isPhysicallyDown(minecraftClient, keyBinding));
        }
        this.lwl = false;
    }

    private static /* synthetic */ int azv(int n, int n2) {
        return n + n2 + 1471577964;
    }

    private static /* synthetic */ int azw(int n, int n2) {
        return lwh.azv(n, n2) * n2;
    }
}

