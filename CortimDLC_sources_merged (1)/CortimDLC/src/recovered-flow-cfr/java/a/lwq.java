/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.entity.player.PlayerAbilities
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.kfa;
import a.kfe;
import a.lqq;
import a.ovh;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.util.math.Vec3d;

public class lwq
extends kfe {
    public static final double MAX_STEP = 9.5;
    public static final double SPEED = 40.0;
    public static final double VERTICAL = 25.0;
    private PlayerAbilities lwr;
    private float lws;
    private static /* synthetic */ long lwt;
    private static /* synthetic */ boolean lwu;

    public lwq() {
        super(a.c(1474605818, "\ub2b7\ucb30\u41f0\udf87\u5458\ud2e8\u6893\ue148\u7f02"), a.d("\u8be5\uf273\u78b2\ue6c4\u6d02\ueba4\u51a5\ud85b\u464d\uccf6\u4b30\ub118\u3f89\ua632\u2c64\uaa9b\u10db\u9f16\u05eb\u83a0\u0a43\u7016\ufeb5\u6526\ue314\u6999\ud079\u5e7f\uc496\u42da\uc975\u37a3\ubdf6\u2406\ua201\u28f9\u9729\u1d53\u9b97\u0220\u8862\uf69b\u7c85\ufb38\u61fd\uef8b\u564d\udcbe\u5abc\uc131\u4f11\ub595\u3c27\uba26\u2094\uaeca\u157f\u93ea\u19dd\u8007\u0ea8\u74e0\uf35d\u7943\ue78d\u6e72\ud46b\u5285\ud8ca\u4766\ucde5\u4bd5\ub205\u38be\ua6a9\u2d0b\uab41\u11fb\u982c\u0657", 1734745515, 1925027416), kfa.MOVEMENT);
    }

    @Override
    protected void onDisable() {
        this.lwv();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        Vec3d vec3d;
        double d;
        double d2;
        this.lwv();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        PlayerAbilities playerAbilities = clientPlayerEntity.getAbilities();
        if (!playerAbilities.flying || clientPlayerEntity.isSpectator() || clientPlayerEntity.hasVehicle() || clientPlayerEntity.hurtTime > 0 || ovh.active() || lqq.busy()) {
            return;
        }
        GameOptions gameOptions = minecraftClient.options;
        double d3 = lwq.lww(gameOptions.forwardKey.isPressed(), gameOptions.backKey.isPressed());
        double d4 = lwq.lww(gameOptions.leftKey.isPressed(), gameOptions.rightKey.isPressed());
        double d5 = lwq.lww(gameOptions.jumpKey.isPressed(), gameOptions.sneakKey.isPressed());
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = Math.hypot(d3, d4);
        if (d8 > 0.0) {
            d2 = 2.0 / d8;
            double d9 = Math.toRadians(clientPlayerEntity.getYaw());
            double d10 = Math.sin(d9);
            double d11 = Math.cos(d9);
            d6 = (d4 * d11 - d3 * d10) * d2;
            d7 = (d3 * d11 + d4 * d10) * d2;
        }
        clientPlayerEntity.setVelocity((d = (vec3d = new Vec3d(d6, d2 = d5 * 25.0 / 20.0, d7)).length()) > 9.5 ? vec3d.multiply(9.5 / d) : vec3d);
        this.lwr = playerAbilities;
        this.lws = playerAbilities.getFlySpeed();
        playerAbilities.setFlySpeed(0.0f);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        this.lwv();
    }

    private void lwv() {
        if (this.lwr != null) {
            this.lwr.setFlySpeed(this.lws);
            this.lwr = null;
        }
    }

    private static double lww(boolean bl, boolean bl2) {
        return (bl ? 1 : 0) - (bl2 ? 1 : 0);
    }

    private static /* synthetic */ int azz(int n, int n2) {
        return n * n2 | 0x242A62DC;
    }

    private static /* synthetic */ int baa(int n, int n2) {
        return lwq.azz(n, n2) + n;
    }
}

