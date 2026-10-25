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
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        minecraftClient.field_1761.method_2906(clientPlayerEntity.field_7498.field_7763, wdq.slotId(n), n2, SlotActionType.field_7791, (PlayerEntity)clientPlayerEntity);
    }

    public static void close(MinecraftClient minecraftClient) {
        if (!(minecraftClient.field_1755 instanceof HandledScreen)) {
            ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
            clientPlayerEntity.field_3944.method_52787((Packet)new CloseHandledScreenC2SPacket(clientPlayerEntity.field_7498.field_7763));
        }
    }

    public static int slotId(int n) {
        return n < 9 ? 36 + n : n;
    }

    public static int slotId(ScreenHandler screenHandler, Inventory inventory, int n) {
        for (Slot slot : screenHandler.field_7761) {
            if (slot.field_7871 != inventory || slot.method_34266() != n) continue;
            return slot.field_7874;
        }
        return -1;
    }

    public static boolean canClick(ClientPlayerEntity clientPlayerEntity) {
        return clientPlayerEntity != null && clientPlayerEntity.method_5805() && !clientPlayerEntity.method_7325() && clientPlayerEntity.field_7512 == clientPlayerEntity.field_7498 && clientPlayerEntity.field_7498.method_34255().method_7960();
    }

    private static /* synthetic */ int dpk(int n, int n2) {
        return n ^ n2 | 0x279F5F85;
    }
}

