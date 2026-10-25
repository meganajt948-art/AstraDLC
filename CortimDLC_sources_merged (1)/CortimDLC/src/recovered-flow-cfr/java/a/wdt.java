/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.entity.effect.StatusEffects
 */
package a;

import a.lwh;
import a.vxr;
import a.vzz;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.effect.StatusEffects;

public final class wdt {
    private static final Field wdu = vxr.find(ClientPlayerEntity.class, a.b("\u82d0\ufb6a\u71a8\uef83\u6417\ue2a2\u58f6\ud10c\u4f55\uc5f5\u4235\ub843\u3686\uaf6d\u2573\ua38d\u19cf\u960c\u0cbf\u8ac2\u035d\u790f\uf7be", 1596162729), a.d("\u6e03\u17bd\u9d62\u031a\u88c5\u0e4f\ub470\u3d8b\ua3dc\u2965", -2122966181, 124613940), a.d("\u4faa", -1387316494, 561935619));
    private static int wdv;
    private static int wdw;
    private boolean wdx;
    private boolean wdy;
    private static /* synthetic */ boolean wdz;
    private static /* synthetic */ long wea;

    public static boolean anyHeld() {
        return wdv > 0;
    }

    public static boolean serverSprinting(ClientPlayerEntity clientPlayerEntity) {
        return vxr.getBoolean(wdu, clientPlayerEntity, clientPlayerEntity.isSprinting());
    }

    public boolean isHeld() {
        return this.wdx;
    }

    public void hold(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!this.wdx) {
            this.wdy = clientPlayerEntity.isSprinting() || vxr.getBoolean(wdu, clientPlayerEntity, false);
            ++wdv;
        }
        minecraftClient.options.forwardKey.setPressed(false);
        this.wdx = true;
    }

    public void release(MinecraftClient minecraftClient) {
        if (!this.wdx) {
            return;
        }
        this.wdx = false;
        wdv = Math.max(0, wdv - 1);
        if (minecraftClient == null || minecraftClient.options == null || minecraftClient.player == null) {
            this.wdy = false;
            return;
        }
        KeyBinding keyBinding = minecraftClient.options.forwardKey;
        keyBinding.setPressed(vzz.isPhysicallyDown(minecraftClient, keyBinding));
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.wdy && !lwh.active() && !((Boolean)minecraftClient.options.getSprintToggled().getValue()).booleanValue() && !minecraftClient.options.sprintKey.isPressed() && wdt.canResumeSprint(minecraftClient, clientPlayerEntity)) {
            minecraftClient.options.sprintKey.setPressed(true);
            wdw = 2;
        }
        this.wdy = false;
    }

    public static void settle(MinecraftClient minecraftClient) {
        if (wdw <= 0 || --wdw > 0) {
            return;
        }
        if (minecraftClient.options != null && minecraftClient.getWindow() != null && !((Boolean)minecraftClient.options.getSprintToggled().getValue()).booleanValue()) {
            minecraftClient.options.sprintKey.setPressed(vzz.isPhysicallyDown(minecraftClient, minecraftClient.options.sprintKey));
        }
    }

    public static boolean canResumeSprint(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return minecraftClient.options.forwardKey.isPressed() && !minecraftClient.options.backKey.isPressed() && !clientPlayerEntity.isSneaking() && !clientPlayerEntity.isUsingItem() && !clientPlayerEntity.horizontalCollision && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isGliding() && !clientPlayerEntity.hasStatusEffect(StatusEffects.BLINDNESS) && (clientPlayerEntity.getHungerManager().getFoodLevel() > 6 || clientPlayerEntity.getAbilities().allowFlying);
    }

    private static /* synthetic */ int dpn(int n, int n2) {
        return n - n2 ^ 0x6C1C70E9;
    }

    private static /* synthetic */ int dpo(int n, int n2) {
        return n - n2 + -814904496;
    }
}

