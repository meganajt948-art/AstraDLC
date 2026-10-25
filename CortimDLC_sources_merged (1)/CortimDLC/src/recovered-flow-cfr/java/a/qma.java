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
        int n = clientPlayerEntity.method_7344().method_7586();
        return n <= 14 || n < 20 && clientPlayerEntity.method_6032() < clientPlayerEntity.method_6063() * 0.6f;
    }

    public static boolean canEat(ClientPlayerEntity clientPlayerEntity) {
        if (qpw.isFood(clientPlayerEntity.method_6079())) {
            return true;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        for (int i = 0; i < 9; ++i) {
            if (!qpw.isFood(playerInventory.method_5438(i))) continue;
            return true;
        }
        return false;
    }

    public static int stored(ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        int n = qpw.find(playerInventory, Items.field_8071);
        if (n >= 9) {
            return n;
        }
        for (int i = 9; i < 36; ++i) {
            if (!qpw.isFood(playerInventory.method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    public boolean start(ClientPlayerEntity clientPlayerEntity) {
        if (this.active() || clientPlayerEntity.method_6115()) {
            return false;
        }
        this.qmc = -1;
        if (!qpw.isFood(clientPlayerEntity.method_6079())) {
            PlayerInventory playerInventory = clientPlayerEntity.method_31548();
            int n = -1;
            for (int i = 0; i < 9; ++i) {
                if (!playerInventory.method_5438(i).method_31574(Items.field_8071) && (n >= 0 || !qpw.isFood(playerInventory.method_5438(i)))) continue;
                n = i;
            }
            if (n < 0) {
                return false;
            }
            if (playerInventory.method_67532() != n) {
                this.qmc = playerInventory.method_67532();
                playerInventory.method_61496(n);
            }
        }
        this.qmb = 0;
        this.qmd = clientPlayerEntity.method_7344().method_7586();
        return true;
    }

    public void startTick(MinecraftClient minecraftClient) {
        if (this.active()) {
            minecraftClient.field_1690.field_1904.method_23481(true);
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
        if ((this.qmb == 1 || this.qmb == 12 && !clientPlayerEntity.method_6115()) && !(key = KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.field_1690.field_1904)).equals((Object)InputUtil.field_16237)) {
            KeyBinding.method_1420((InputUtil.Key)key);
        }
        boolean bl2 = bl = clientPlayerEntity.method_7344().method_7586() > this.qmd && !clientPlayerEntity.method_6115();
        if (bl || this.qmb > 70 || this.qmb > 24 && !clientPlayerEntity.method_6115() || !clientPlayerEntity.method_5805()) {
            this.stop(minecraftClient, clientPlayerEntity);
        }
    }

    public void stop(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (this.qme && minecraftClient.field_1690 != null && minecraftClient.method_22683() != null) {
            minecraftClient.field_1690.field_1904.method_23481(vzz.isPhysicallyDown(minecraftClient, minecraftClient.field_1690.field_1904));
        }
        this.qme = false;
        if (this.qmc >= 0 && clientPlayerEntity != null) {
            clientPlayerEntity.method_31548().method_61496(this.qmc);
        }
        this.qmc = -1;
        this.qmb = -1;
    }

    private static /* synthetic */ int bsw(int n, int n2) {
        return n + n2 + -1357643080;
    }
}

