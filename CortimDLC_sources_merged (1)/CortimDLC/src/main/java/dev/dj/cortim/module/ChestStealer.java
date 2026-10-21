package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

import java.util.Random;

/** Аналог ChestLooter, но без списка предметов: забирает из открытого сундука абсолютно всё. */
public class ChestStealer extends Module {

    private final IntSetting intervalMs = add(new IntSetting("Опустошает открытые сундуки", "Задержка между переносом предметов, мс", 60, 10, 1000));
    private final IntSetting spreadMs   = add(new IntSetting("Разброс", "Случайная добавка к задержке, мс", 40, 0, 500));
    private final BoolSetting closeSelf = add(new BoolSetting("Закрывать сам", "Закрыть сундук, когда он опустеет", true));
    private final BoolSetting noHotbar  = add(new BoolSetting("Без хотбара", "Не класть предметы в хотбар", true));

    private final Random random = new Random();
    private int cooldownTicks = 0;

    public ChestStealer() { super("ChestStealer", Category.PLAYER); }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;

        if (!isEnabled() || player == null || !(client.currentScreen instanceof GenericContainerScreen gs)) {
            cooldownTicks = 0;
            return;
        }

        if (cooldownTicks > 0) { cooldownTicks--; return; }

        GenericContainerScreenHandler h = gs.getScreenHandler();
        Slot sourceSlot = null;
        for (Slot slot : h.slots) {
            if (slot.inventory instanceof PlayerInventory) continue;
            if (!slot.getStack().isEmpty()) { sourceSlot = slot; break; }
        }

        if (sourceSlot == null) {
            if (closeSelf.get()) client.setScreen(null);
            cooldownTicks = 0;
            return;
        }

        Slot targetSlot = findTarget(h);
        int syncId = h.syncId;

        if (targetSlot != null) {
            // забираем в курсор, кладём в выбранный слот — так можно исключить хотбар
            client.interactionManager.clickSlot(syncId, sourceSlot.id, 0, SlotActionType.PICKUP, player);
            client.interactionManager.clickSlot(syncId, targetSlot.id, 0, SlotActionType.PICKUP, player);
        } else {
            client.interactionManager.clickSlot(syncId, sourceSlot.id, 0, SlotActionType.QUICK_MOVE, player);
        }

        int delay = intervalMs.get() + (spreadMs.get() > 0 ? random.nextInt(spreadMs.get() + 1) : 0);
        cooldownTicks = Math.max(1, delay / 50); // мс -> тики
    }

    private Slot findTarget(GenericContainerScreenHandler h) {
        int start = noHotbar.get() ? 9 : 0; // 0..8 — хотбар игрока
        for (Slot slot : h.slots) {
            if (!(slot.inventory instanceof PlayerInventory)) continue;
            int idx = slot.getIndex();
            if (idx < start || idx > 35) continue;
            if (slot.getStack().isEmpty()) return slot;
        }
        return null;
    }
}