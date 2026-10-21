package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;

public class AutoBuy extends Module {

    private long lastClick = 0L;
    private final IntSetting clickDelay = add(new IntSetting("Delay", "Задержка между кликами (мс)", 120, 50, 1000));

    public AutoBuy() { super("AutoBuy", Category.MISC); }

    @Override
    public void onTick() {
        if (!isEnabled()) return;
        MinecraftClient client = MinecraftClient.getInstance();
        if (!(client.currentScreen instanceof HandledScreen<?> screen)) return;

        long now = System.currentTimeMillis();
        if (now - lastClick < clickDelay.get()) return;

        for (Slot slot : screen.getScreenHandler().slots) {
            if (!slot.hasStack()) continue;
            String name = slot.getStack().getName().getString().toLowerCase();
            if (name.contains("buy") || name.contains("купить")) {
                client.interactionManager.clickSlot(
                        screen.getScreenHandler().syncId, slot.id, 0,
                        net.minecraft.screen.slot.SlotActionType.QUICK_MOVE,
                        client.player
                );
                lastClick = now;
                break;
            }
        }
    }
}