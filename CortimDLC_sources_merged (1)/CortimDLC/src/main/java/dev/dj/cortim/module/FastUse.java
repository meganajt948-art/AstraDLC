package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

/**
 * НЕ использует предметы сам. Только снимает ванильную задержку (кулдаун) между использованиями
 * бутылки опыта / блока в руке, чтобы при зажатом/частом ПКМ предмет применялся быстрее.
 * Сам клик (использование) всегда делает игрок.
 */
public class FastUse extends Module {

    // 0 = Пузырьки опыта, 1 = Блоки, 2 = Все
    private final ModeSetting items = add(new ModeSetting("Предметы", "К каким предметам снимать задержку", 2,
            "Пузырьки опыта", "Блоки", "Все"));

    public FastUse() { super("FastUse", Category.PLAYER); }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (!isEnabled() || player == null) return;

        clearCooldownIfMatches(player, Hand.MAIN_HAND);
        clearCooldownIfMatches(player, Hand.OFF_HAND);
    }

    private void clearCooldownIfMatches(ClientPlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!matches(stack)) return;

        if (player.getItemCooldownManager().isCoolingDown(stack)) {
            Identifier id = Registries.ITEM.getId(stack.getItem());
            player.getItemCooldownManager().remove(id);
        }
    }

    private boolean matches(ItemStack stack) {
        if (stack.isEmpty()) return false;
        int mode = items.get();
        boolean isBottle = stack.isOf(Items.EXPERIENCE_BOTTLE);
        boolean isBlock = stack.getItem() instanceof BlockItem;
        return (mode == 0 && isBottle) || (mode == 1 && isBlock) || (mode == 2 && (isBottle || isBlock));
    }
}