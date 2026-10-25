/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.util.InputUtil$Type
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Item
 */
package a;

import a.izx;
import a.oxw;
import a.vhz;
import a.vyn;
import a.vze;
import a.vzz;
import a.wap;
import a.wdq;
import flow.dev.a;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;

public final class vzh {
    private static final int vzi = 20;
    private final Item vzj;
    private final vyn vzk;
    private vze vzl;
    private int vzm;
    private boolean vzn;
    private int vzo;
    private int vzp;
    private int vzq = -1;
    private static /* synthetic */ long vzr;
    private static /* synthetic */ String vzs;

    public vzh(Item item) {
        this(item, false);
    }

    public vzh(Item item, boolean bl) {
        this.vzj = item;
        this.vzk = new vyn(bl);
    }

    public boolean busy() {
        return this.vzl != null;
    }

    public void press(MinecraftClient minecraftClient, int n, String string, String string2) {
        if (this.vzl != null || oxw.busy()) {
            return;
        }
        if (vzz.mods(n) != 0) {
            this.vzv(minecraftClient, vzz.baseKey(n));
        }
        this.vzt(minecraftClient, string, string2);
    }

    private void vzt(MinecraftClient minecraftClient, String string, String string2) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || !clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator() || clientPlayerEntity.currentScreenHandler != clientPlayerEntity.playerScreenHandler) {
            return;
        }
        int n = this.vzy(clientPlayerEntity);
        if (n < 0) {
            izx.alert(string, string2, vhz.INFO, false);
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (clientPlayerEntity.getItemCooldownManager().isCoolingDown(playerInventory.getStack(n))) {
            izx.alert(string, wap.s(a.d("\u3ab2\u432f\uc9fc\u578e\udc51\u5aeb\ue0a0\u6948", -1287075951, 137035112), a.d("\u4726\u3ece\ub465\u2a1b\ua1c8\u270a\u9d27", -1689195453, -1376211080)), vhz.CLOCK, false);
            return;
        }
        if (KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.useKey).equals((Object)InputUtil.UNKNOWN_KEY)) {
            izx.alert(string, wap.s(a.d("\ucf8b\ub601\u3cdc\ua2a2\u2969\uaf8c\u159c\u9c62\u0238\u8883\u0f58\uf562\u7bfc\ue257\u6819\ueea1\u54bd\udb38\u41c9\uc795\u4e78\u3432\uba8b", 557595628, 1464661026), a.b("\u6a1b\u1382\u9d44\u0728\u8cf2\u0a44\ub01d\u39e1\ua7c9\u2d0a\uaad1\u50ad\uda6a\u47e4\ucdb2\u4b45", 1910402582)), vhz.KEYBOARD, false);
            return;
        }
        this.vzm = n;
        this.vzn = n < 9;
        this.vzo = playerInventory.getSelectedSlot();
        this.vzp = 0;
        if (this.vzn) {
            this.vzl = vze.USE;
        } else if (this.vzx(clientPlayerEntity)) {
            wdq.swap(minecraftClient, this.vzm, this.vzo);
            this.vzl = vze.USE;
        } else {
            this.vzl = vze.PREPARE;
        }
    }

    public void startTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null) {
            return;
        }
        this.vzq = clientPlayerEntity.getInventory().getSelectedSlot();
        if (this.vzl == null) {
            return;
        }
        if (!clientPlayerEntity.isAlive() || clientPlayerEntity.currentScreenHandler != clientPlayerEntity.playerScreenHandler) {
            this.reset(minecraftClient);
            return;
        }
        if (minecraftClient.currentScreen != null && this.vzl != vze.SWAP_BACK) {
            if (this.vzl == vze.USE && !this.vzn) {
                this.vzl = vze.SWAP_BACK;
            } else {
                this.reset(minecraftClient);
                return;
            }
        }
        switch (this.vzl.ordinal()) {
            case 1: {
                this.vzu(minecraftClient, clientPlayerEntity);
                break;
            }
            case 3: {
                this.reset(minecraftClient);
                break;
            }
            default: {
                this.vzw(minecraftClient, clientPlayerEntity);
            }
        }
    }

    public void endTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.vzl == null || clientPlayerEntity == null) {
            return;
        }
        if (this.vzl == vze.PREPARE) {
            PlayerInventory playerInventory = clientPlayerEntity.getInventory();
            if (!playerInventory.getStack(this.vzm).isOf(this.vzj)) {
                this.reset(minecraftClient);
            } else if (this.vzx(clientPlayerEntity)) {
                this.vzo = playerInventory.getSelectedSlot();
                wdq.swap(minecraftClient, this.vzm, this.vzo);
                this.vzl = vze.USE;
            } else if (++this.vzp > 20) {
                this.reset(minecraftClient);
            }
        } else if (this.vzl == vze.SWAP_BACK) {
            if (wdq.canClick(clientPlayerEntity) && this.vzk.idle(clientPlayerEntity)) {
                wdq.swap(minecraftClient, this.vzm, this.vzo);
                this.reset(minecraftClient);
            } else if (++this.vzp > 20) {
                this.reset(minecraftClient);
            }
        }
    }

    private void vzu(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (!this.vzn) {
            this.vzw(minecraftClient, clientPlayerEntity);
        } else if (playerInventory.getSelectedSlot() != this.vzm) {
            playerInventory.setSelectedSlot(this.vzm);
        }
        if (!clientPlayerEntity.getMainHandStack().isOf(this.vzj)) {
            this.reset(minecraftClient);
            return;
        }
        if (clientPlayerEntity.isUsingItem()) {
            minecraftClient.interactionManager.stopUsingItem((PlayerEntity)clientPlayerEntity);
        }
        KeyBinding.onKeyPressed((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.useKey));
        this.vzp = 0;
        this.vzl = this.vzn ? vze.RESTORE : vze.SWAP_BACK;
    }

    public void reset(MinecraftClient minecraftClient) {
        PlayerInventory playerInventory;
        this.vzk.release(minecraftClient);
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.vzl != null && this.vzn && clientPlayerEntity != null && (playerInventory = clientPlayerEntity.getInventory()).getSelectedSlot() == this.vzm && this.vzm != this.vzo) {
            playerInventory.setSelectedSlot(this.vzo);
        }
        this.vzl = null;
    }

    private void vzv(MinecraftClient minecraftClient, int n) {
        PlayerInventory playerInventory = minecraftClient.player.getInventory();
        int n2 = playerInventory.getSelectedSlot();
        if (this.vzq < 0 || n2 == this.vzq || n2 >= minecraftClient.options.hotbarKeys.length) {
            return;
        }
        InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.hotbarKeys[n2]);
        if (key.getCategory() == InputUtil.Type.KEYSYM && key.getCode() == n) {
            playerInventory.setSelectedSlot(this.vzq);
        }
    }

    private void vzw(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        this.vzk.hold(minecraftClient);
        if (clientPlayerEntity.isUsingItem()) {
            minecraftClient.interactionManager.stopUsingItem((PlayerEntity)clientPlayerEntity);
        }
    }

    private boolean vzx(ClientPlayerEntity clientPlayerEntity) {
        return wdq.canClick(clientPlayerEntity) && this.vzk.idle(clientPlayerEntity) && !clientPlayerEntity.isUsingItem();
    }

    private int vzy(ClientPlayerEntity clientPlayerEntity) {
        int n;
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (playerInventory.getStack(n = playerInventory.getSelectedSlot()).isOf(this.vzj)) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.getStack(i).isOf(this.vzj)) continue;
            return i;
        }
        return -1;
    }

    private static /* synthetic */ int dnf(int n, int n2) {
        return n * n2 | 0x112541F2;
    }

    private static /* synthetic */ int dng(int n, int n2) {
        return n * n2 + -1024764142;
    }

    private static /* synthetic */ int dnh(int n, int n2) {
        return n ^ n2 | 0x4043103B;
    }
}

