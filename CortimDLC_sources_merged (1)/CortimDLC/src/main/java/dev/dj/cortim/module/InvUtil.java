package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;

/** Общие помощники для AutoSwap и AutoTotem. */
public final class InvUtil {
    private InvUtil() {}

    /** Индекс слота инвентаря игрока (0-8 хотбар, 9-35 основной) -> номер слота в окне инвентаря. */
    public static int handlerSlot(int invIndex) {
        return invIndex < 9 ? 36 + invIndex : invIndex;
    }

    // обычный тотем: без свечения; зачарованный: со свечением (зачарования)
    public static boolean isTotem(ItemStack s) {
        return !s.isEmpty() && s.isOf(Items.TOTEM_OF_UNDYING);
    }

    public static boolean isPlainTotem(ItemStack s) {
        return isTotem(s) && !s.hasGlint();
    }

    public static boolean isEnchantedTotem(ItemStack s) {
        return isTotem(s) && s.hasGlint();
    }

    public static boolean isSphere(ItemStack s) {
        return !s.isEmpty() && s.isOf(Items.PLAYER_HEAD);
    }

    /** Обмен слота со второй рукой одним пакетом (кнопка 40 = «поменять с левой рукой»). */
    public static void swapOffhand(MinecraftClient client, ClientPlayerEntity player, int invIndex) {
        client.interactionManager.clickSlot(player.playerScreenHandler.syncId,
                handlerSlot(invIndex), 40, SlotActionType.SWAP, player);
    }

    /** Обмен тремя кликами (взять, положить в левую руку, вернуть старый предмет). */
    public static void swapOffhandPickup(MinecraftClient client, ClientPlayerEntity player, int invIndex) {
        int sync = player.playerScreenHandler.syncId;
        int slot = handlerSlot(invIndex);
        client.interactionManager.clickSlot(sync, slot, 0, SlotActionType.PICKUP, player);
        client.interactionManager.clickSlot(sync, 45, 0, SlotActionType.PICKUP, player);
        client.interactionManager.clickSlot(sync, slot, 0, SlotActionType.PICKUP, player);
    }
}