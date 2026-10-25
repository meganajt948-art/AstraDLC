/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public final class wdq {
    private static /* synthetic */ int wdr;
    private static /* synthetic */ long wds;

    private wdq() {
    }

    public static void swap(MinecraftClient minecraftClient, int n, int n2) {
        wdq.click(minecraftClient, n, n2);
        wdq.close(minecraftClient);
    }

    public static void click(MinecraftClient minecraftClient, int n, int n2) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        minecraftClient.interactionManager.clickSlot(clientPlayerEntity.playerScreenHandler.syncId, wdq.slotId(n), n2, SlotActionType.SWAP, (PlayerEntity)clientPlayerEntity);
    }

    public static void close(MinecraftClient minecraftClient) {
        if (!(minecraftClient.currentScreen instanceof HandledScreen)) {
            ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
            clientPlayerEntity.networkHandler.sendPacket((Packet)new CloseHandledScreenC2SPacket(clientPlayerEntity.playerScreenHandler.syncId));
        }
    }

    public static int slotId(int n) {
        return n < 9 ? 36 + n : n;
    }

    public static int slotId(ScreenHandler screenHandler, Inventory inventory, int n) {
        for (Slot slot : screenHandler.slots) {
            if (slot.inventory != inventory || slot.getIndex() != n) continue;
            return slot.id;
        }
        return -1;
    }

    public static boolean canClick(ClientPlayerEntity clientPlayerEntity) {
        return clientPlayerEntity != null && clientPlayerEntity.isAlive() && !clientPlayerEntity.isSpectator() && clientPlayerEntity.currentScreenHandler == clientPlayerEntity.playerScreenHandler && clientPlayerEntity.playerScreenHandler.getCursorStack().isEmpty();
    }

    private static /* synthetic */ int dpk(int n, int n2) {
        return n ^ n2 | 0x279F5F85;
    }
}

