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
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Items
 */
package a;

import a.qpw;
import a.vzz;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;

public final class qma {
    private int qmb = -1;
    private int qmc = -1;
    private int qmd;
    private boolean qme;
    private static /* synthetic */ boolean qmf;
    private static /* synthetic */ int qmg;

    public boolean active() {
        return this.qmb >= 0;
    }

    public static boolean hungry(ClientPlayerEntity clientPlayerEntity) {
        int n = clientPlayerEntity.getHungerManager().getFoodLevel();
        return n <= 14 || n < 20 && clientPlayerEntity.getHealth() < clientPlayerEntity.getMaxHealth() * 0.6f;
    }

    public static boolean canEat(ClientPlayerEntity clientPlayerEntity) {
        if (qpw.isFood(clientPlayerEntity.getOffHandStack())) {
            return true;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        for (int i = 0; i < 9; ++i) {
            if (!qpw.isFood(playerInventory.getStack(i))) continue;
            return true;
        }
        return false;
    }

    public static int stored(ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        int n = qpw.find(playerInventory, Items.GOLDEN_CARROT);
        if (n >= 9) {
            return n;
        }
        for (int i = 9; i < 36; ++i) {
            if (!qpw.isFood(playerInventory.getStack(i))) continue;
            return i;
        }
        return -1;
    }

    public boolean start(ClientPlayerEntity clientPlayerEntity) {
        if (this.active() || clientPlayerEntity.isUsingItem()) {
            return false;
        }
        this.qmc = -1;
        if (!qpw.isFood(clientPlayerEntity.getOffHandStack())) {
            PlayerInventory playerInventory = clientPlayerEntity.getInventory();
            int n = -1;
            for (int i = 0; i < 9; ++i) {
                if (!playerInventory.getStack(i).isOf(Items.GOLDEN_CARROT) && (n >= 0 || !qpw.isFood(playerInventory.getStack(i)))) continue;
                n = i;
            }
            if (n < 0) {
                return false;
            }
            if (playerInventory.getSelectedSlot() != n) {
                this.qmc = playerInventory.getSelectedSlot();
                playerInventory.setSelectedSlot(n);
            }
        }
        this.qmb = 0;
        this.qmd = clientPlayerEntity.getHungerManager().getFoodLevel();
        return true;
    }

    public void startTick(MinecraftClient minecraftClient) {
        if (this.active()) {
            minecraftClient.options.useKey.setPressed(true);
            this.qme = true;
        }
    }

    public void endTick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        InputUtil.Key key;
        if (!this.active()) {
            return;
        }
        ++this.qmb;
        if ((this.qmb == 1 || this.qmb == 12 && !clientPlayerEntity.isUsingItem()) && !(key = KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.useKey)).equals((Object)InputUtil.UNKNOWN_KEY)) {
            KeyBinding.onKeyPressed((InputUtil.Key)key);
        }
        boolean bl2 = bl = clientPlayerEntity.getHungerManager().getFoodLevel() > this.qmd && !clientPlayerEntity.isUsingItem();
        if (bl || this.qmb > 70 || this.qmb > 24 && !clientPlayerEntity.isUsingItem() || !clientPlayerEntity.isAlive()) {
            this.stop(minecraftClient, clientPlayerEntity);
        }
    }

    public void stop(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (this.qme && minecraftClient.options != null && minecraftClient.getWindow() != null) {
            minecraftClient.options.useKey.setPressed(vzz.isPhysicallyDown(minecraftClient, minecraftClient.options.useKey));
        }
        this.qme = false;
        if (this.qmc >= 0 && clientPlayerEntity != null) {
            clientPlayerEntity.getInventory().setSelectedSlot(this.qmc);
        }
        this.qmc = -1;
        this.qmb = -1;
    }

    private static /* synthetic */ int bsw(int n, int n2) {
        return n + n2 + -1357643080;
    }
}

