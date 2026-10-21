package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

/**
 * Включается обычным переключателем. По клавише «Кнопка свапа» меняет предмет в левой руке
 * с одного выбранного типа на другой и обратно (Тотем / Зачар. тотем / Сфера = голова игрока).
 */
public class AutoSwap extends Module {

    private static final String[] KINDS = {"Тотем", "Зачар. тотем", "Сфера"};

    private final ModeSetting from = add(new ModeSetting("От",
            "Первый предмет", 0, KINDS).asSegmented());

    private final ModeSetting to = add(new ModeSetting("На",
            "Второй предмет", 1, KINDS).asSegmented());

    private final KeySetting swapKey = add(new KeySetting("Кнопка свапа",
            "Клавиша или кнопка мыши для свапа", -1));

    private boolean wasDown = false;

    public AutoSwap() { super("AutoSwap", Category.COMBAT); }

    @Override
    public void onTick() {
        if (!isEnabled()) { wasDown = false; return; }

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if (player == null || client.world == null || client.interactionManager == null) return;

        boolean down = client.currentScreen == null && swapKey.isDown();
        if (down && !wasDown && !player.isDead()) swap(client, player);
        wasDown = down;
    }

    private boolean matches(int kind, ItemStack s) {
        return switch (kind) {
            case 0 -> InvUtil.isPlainTotem(s);
            case 1 -> InvUtil.isEnchantedTotem(s);
            default -> InvUtil.isSphere(s);
        };
    }

    private void swap(MinecraftClient client, ClientPlayerEntity player) {
        int a = from.get();
        int b = to.get();
        if (a == b) return;

        ItemStack off = player.getOffHandStack();

        // в руке «От» -> берём «На»; в руке «На» -> берём «От»; иначе начинаем с «От»
        int want = matches(a, off) ? b : matches(b, off) ? a : a;

        PlayerInventory inv = player.getInventory();
        for (int i = 0; i < 36; i++) {
            if (matches(want, inv.getStack(i))) {
                InvUtil.swapOffhand(client, player, i);
                return;
            }
        }
    }
}