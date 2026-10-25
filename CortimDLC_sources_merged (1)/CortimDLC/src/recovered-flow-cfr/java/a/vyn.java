/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.util.PlayerInput
 */
package a;

import a.vwy;
import a.vxr;
import a.vzz;
import a.wdt;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.PlayerInput;

public final class vyn {
    private static final Field vyo = vxr.find(ClientPlayerEntity.class, a.c(-19559334, "\u8c23\uf599\u7f5b\ue170\u6ae4\uec51\u5605\udfff\u41a6\ucb06\u4cc6\ub6b0\u3875\ua19e\u2b80\uad7e\u173c\u98ff\u024c\u8431\u0dae\u77fc\uf94d"), a.b("\u2e07\u57b9\udd66\u431e\uc8c1\u4e4b\uf472\u7d82\ue3d8\u696d\ueebd", -619368854), a.b("\u46ce\u3f5d\ub585\u2be5\ua069\u269a\u9ccd\u153b\u8b6f\u01d8\u861a\u7c78\uf2a8\u6b0b\ue103\u67be\uddfe\u5222\uc883\u4ed2\uc709\ubd36\u3384\ua854\u2e22\ua4fe\u1d43", 1580680857));
    private static int vyp;
    private final wdt vyq = new wdt();
    private final boolean vyr;
    private boolean vys;
    private boolean vyt;
    private boolean vyu;
    private static /* synthetic */ int vyv;
    private static /* synthetic */ long vyw;

    public vyn() {
        this(false);
    }

    public vyn(boolean bl) {
        this.vyr = bl;
    }

    public boolean idle(ClientPlayerEntity clientPlayerEntity) {
        return this.vyr ? vyn.vyx(clientPlayerEntity, true) : vyn.serverIdle(clientPlayerEntity);
    }

    public static boolean serverIdle(ClientPlayerEntity clientPlayerEntity) {
        return vyn.vyx(clientPlayerEntity, false);
    }

    private static boolean vyx(ClientPlayerEntity clientPlayerEntity, boolean bl) {
        if (wdt.serverSprinting(clientPlayerEntity)) {
            return false;
        }
        Object object = clientPlayerEntity.input.playerInput;
        if (vyo != null) {
            try {
                object = vyo.get(clientPlayerEntity);
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        if (bl && object instanceof PlayerInput) {
            Object object2 = object;
            return !object2.forward() && !object2.backward() && !object2.left() && !object2.right() && !object2.jump() && !object2.sprint();
        }
        return PlayerInput.DEFAULT.equals(object);
    }

    public static boolean still(ClientPlayerEntity clientPlayerEntity) {
        double d = clientPlayerEntity.getX() - clientPlayerEntity.lastX;
        double d2 = clientPlayerEntity.getZ() - clientPlayerEntity.lastZ;
        return clientPlayerEntity.isOnGround() && d * d + d2 * d2 < 9.0E-4;
    }

    public static PlayerInput lastSent(ClientPlayerEntity clientPlayerEntity) {
        if (vyo != null) {
            try {
                Object object = vyo.get(clientPlayerEntity);
                if (object instanceof PlayerInput) {
                    PlayerInput playerInput = (PlayerInput)object;
                    return playerInput;
                }
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        return clientPlayerEntity.input.playerInput;
    }

    public boolean isHeld() {
        return this.vys;
    }

    public static boolean anyHeld() {
        return vyp > 0;
    }

    public void hold(MinecraftClient minecraftClient) {
        GameOptions gameOptions = minecraftClient.options;
        for (KeyBinding keyBinding : vyn.vyy(gameOptions)) {
            keyBinding.setPressed(false);
        }
        KeyBinding keyBinding = gameOptions.sneakKey;
        if (this.vyr) {
            vwy.sneakOk(true);
        } else if (((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
            if (keyBinding.isPressed()) {
                keyBinding.setPressed(true);
                this.vyt = true;
            }
        } else {
            keyBinding.setPressed(false);
        }
        KeyBinding keyBinding2 = gameOptions.sprintKey;
        if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            if (keyBinding2.isPressed()) {
                keyBinding2.setPressed(true);
                this.vyu = true;
            }
        } else {
            keyBinding2.setPressed(false);
        }
        this.vyq.hold(minecraftClient);
        if (!this.vys) {
            ++vyp;
        }
        this.vys = true;
    }

    public void release(MinecraftClient minecraftClient) {
        if (!this.vys) {
            return;
        }
        this.vys = false;
        vyp = Math.max(0, vyp - 1);
        if (this.vyr) {
            vwy.sneakOk(false);
        }
        if (minecraftClient == null || minecraftClient.options == null || minecraftClient.getWindow() == null) {
            this.vyt = false;
            this.vyu = false;
            this.vyq.release(minecraftClient);
            return;
        }
        GameOptions gameOptions = minecraftClient.options;
        for (KeyBinding keyBinding : vyn.vyy(gameOptions)) {
            keyBinding.setPressed(vzz.isPhysicallyDown(minecraftClient, keyBinding));
        }
        KeyBinding keyBinding = gameOptions.sneakKey;
        if (!this.vyr) {
            if (((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
                if (this.vyt && !keyBinding.isPressed()) {
                    keyBinding.setPressed(true);
                }
            } else {
                keyBinding.setPressed(vzz.isPhysicallyDown(minecraftClient, keyBinding));
            }
        }
        this.vyt = false;
        KeyBinding keyBinding2 = gameOptions.sprintKey;
        if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            if (this.vyu && !keyBinding2.isPressed()) {
                keyBinding2.setPressed(true);
            }
        } else {
            keyBinding2.setPressed(vzz.isPhysicallyDown(minecraftClient, keyBinding2));
        }
        this.vyu = false;
        this.vyq.release(minecraftClient);
    }

    private static KeyBinding[] vyy(GameOptions gameOptions) {
        return new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey, gameOptions.useKey};
    }

    private static /* synthetic */ int dmt(int n, int n2) {
        return n + n2 | 0xD3FC7534;
    }
}

