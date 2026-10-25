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
        GameOptions gameOptions = minecraftClient.field_1690;
        return (clientPlayerEntity.method_7344().method_7586() >= 7 || clientPlayerEntity.method_31549().field_7478) && vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1894) && !vzz.isPhysicallyDown(minecraftClient, gameOptions.field_1881) && !gameOptions.field_1832.method_1434();
    }

    @Override
    protected void onDisable() {
        this.lwp(this.mc);
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (minecraftClient.field_1755 != null || vyn.anyHeld() || oxw.busy() || kvz.busy()) {
            return;
        }
        if (!clientPlayerEntity.method_7325() && !clientPlayerEntity.method_5765() && lwh.wants(minecraftClient, clientPlayerEntity)) {
            this.lwo(minecraftClient.field_1690);
        } else {
            this.lwp(minecraftClient);
        }
    }

    private void lwo(GameOptions gameOptions) {
        KeyBinding keyBinding = gameOptions.field_1867;
        if (((Boolean)gameOptions.method_42450().method_41753()).booleanValue()) {
            if (!keyBinding.method_1434()) {
                keyBinding.method_23481(true);
                this.lwl = true;
            }
        } else {
            keyBinding.method_23481(true);
        }
        this.lwk = true;
    }

    private void lwp(MinecraftClient minecraftClient) {
        if (!this.lwk) {
            return;
        }
        this.lwk = false;
        if (minecraftClient == null || minecraftClient.field_1690 == null || minecraftClient.method_22683() == null) {
            this.lwl = false;
            return;
        }
        KeyBinding keyBinding = minecraftClient.field_1690.field_1867;
        if (((Boolean)minecraftClient.field_1690.method_42450().method_41753()).booleanValue()) {
            if (this.lwl && keyBinding.method_1434()) {
                keyBinding.method_23481(true);
            }
        } else {
            keyBinding.method_23481(vzz.isPhysicallyDown(minecraftClient, keyBinding));
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

