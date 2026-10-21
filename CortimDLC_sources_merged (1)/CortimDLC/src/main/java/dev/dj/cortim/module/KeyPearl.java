package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;

public class KeyPearl extends Module {

    private final KeySetting throwKey = add(new KeySetting("Кнопка броска",
            "Клавиша, по которой бросается эндер-жемчуг", -1));

    private enum Stage { IDLE, SWAPPED, THROWN }

    private boolean wasDown = false;
    private Stage stage = Stage.IDLE;
    private int invSlot = -1;      // слот в инвентаре, откуда взяли жемчуг
    private int hotbarSlot = -1;   // слот хотбара, с которым меняли

    public KeyPearl() { super("KeyPearl", Category.COMBAT); }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;

        if (!isEnabled() || player == null || client.world == null || client.interactionManager == null) {
            wasDown = false;
            stage = Stage.IDLE;
            return;
        }

        // 1) если идёт бросок из инвентаря — доводим до конца (по одному шагу за тик)
        if (stage != Stage.IDLE) {
            runStage(client, player);
            return;
        }

        int key = throwKey.getKey();
        if (key < 0) { wasDown = false; return; }

        boolean down = client.currentScreen == null && isDown(client, key);
        if (down && !wasDown && !player.isDead()) {
            throwPearl(client, player);
        }
        wasDown = down;
    }

    private void runStage(MinecraftClient client, ClientPlayerEntity player) {
        int syncId = player.playerScreenHandler.syncId;

        if (stage == Stage.SWAPPED) {
            // жемчуг уже в руке — кидаем
            if (isPearl(player.getMainHandStack())) {
                use(client, player, Hand.MAIN_HAND);
            }
            stage = Stage.THROWN;
        } else if (stage == Stage.THROWN) {
            // возвращаем предмет на место
            client.interactionManager.clickSlot(syncId, invSlot, hotbarSlot, SlotActionType.SWAP, player);
            stage = Stage.IDLE;
        }
    }

    private boolean isDown(MinecraftClient client, int key) {
        long win = client.getWindow().getHandle();
        if (key >= 1000) return GLFW.glfwGetMouseButton(win, key - 1000) == GLFW.GLFW_PRESS;
        return GLFW.glfwGetKey(win, key) == GLFW.GLFW_PRESS;
    }

    private boolean isPearl(ItemStack s) {
        return !s.isEmpty() && s.isOf(Items.ENDER_PEARL);
    }

    private void use(MinecraftClient client, ClientPlayerEntity player, Hand hand) {
        client.interactionManager.interactItem(player, hand);
        player.swingHand(hand);
    }

    private void throwPearl(MinecraftClient client, ClientPlayerEntity player) {
        var cooldown = player.getItemCooldownManager();
        PlayerInventory inv = player.getInventory();
        int sel = inv.getSelectedSlot();

        // 1) жемчуг во второй руке
        ItemStack off = player.getOffHandStack();
        if (isPearl(off)) {
            if (!cooldown.isCoolingDown(off)) use(client, player, Hand.OFF_HAND);
            return;
        }

        // 2) жемчуг уже в основной руке
        if (isPearl(player.getMainHandStack())) {
            if (!cooldown.isCoolingDown(player.getMainHandStack())) use(client, player, Hand.MAIN_HAND);
            return;
        }

        // 3) жемчуг в хотбаре: выбираем слот, кидаем, возвращаем слот
        for (int i = 0; i < 9; i++) {
            ItemStack s = inv.getStack(i);
            if (!isPearl(s)) continue;
            if (cooldown.isCoolingDown(s)) return;

            inv.setSelectedSlot(i);
            use(client, player, Hand.MAIN_HAND);
            inv.setSelectedSlot(sel);
            return;
        }

        // 4) жемчуг в инвентаре: обмен -> бросок -> возврат (три тика)
        for (int i = 9; i < 36; i++) {
            ItemStack s = inv.getStack(i);
            if (!isPearl(s)) continue;
            if (cooldown.isCoolingDown(s)) return;

            invSlot = i;
            hotbarSlot = sel;
            client.interactionManager.clickSlot(
                    player.playerScreenHandler.syncId, i, sel, SlotActionType.SWAP, player);
            stage = Stage.SWAPPED;
            return;
        }
    }
}