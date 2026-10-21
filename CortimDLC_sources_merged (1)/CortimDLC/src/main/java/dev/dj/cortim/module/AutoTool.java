package dev.dj.cortim.module;

import dev.dj.cortim.Cortim;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

public class AutoTool extends Module {

    public static AutoTool instance;

    private final BoolSetting fromInv = add(new BoolSetting("Из инвентаря",
            "Брать инструмент из инвентаря, если в хотбаре его нет", true));

    private final BoolSetting back = add(new BoolSetting("Возвращать",
            "Вернуть прошлый предмет, когда перестал копать", true));

    private final IntSetting backDelay = add(new IntSetting("Задержка возврата",
            "Через сколько тиков вернуть предмет", 4, 0, 20) {
        @Override public String display() { return get() + " тиков"; }
    });

    private final BoolSetting saveDur = add(new BoolSetting("Беречь прочность",
            "Не брать почти сломанные инструменты и не тратить прочность на мгновенно ломающиеся блоки", true));

    // состояние
    private boolean altered = false;
    private int prevSlot = -1;          // слот хотбара, который был выбран до нас
    private int swappedInv = -1;        // слот инвентаря (9..35), откуда взяли инструмент
    private int swappedHotbar = -1;     // слот хотбара, куда его положили
    private Item swappedItem = null;
    private int returnTimer = -1;

    public AutoTool() {
        super("AutoTool", Category.PLAYER);
        instance = this;
    }

    /** Тик идёт в НАЧАЛЕ клиентского тика, чтобы инструмент сменился до расчёта ломания блока. */
    public static void registerEvents() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            AutoTool a = instance;
            if (a == null) return;
            try { a.onTick(); } catch (Throwable t) { Cortim.LOG.warn("autotool", t); }
        });
    }

    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity p = mc.player;
        if (p == null || mc.world == null || mc.interactionManager == null) { forget(); return; }

        if (!isEnabled()) {
            if (altered) restore(mc, p);
            return;
        }

        BlockPos pos = null;
        if (mc.currentScreen == null && mc.options.attackKey.isPressed()
                && !p.isCreative() && !p.isSpectator() && !p.isUsingItem()
                && mc.crosshairTarget instanceof BlockHitResult hit
                && hit.getType() == HitResult.Type.BLOCK) {
            pos = hit.getBlockPos();
        }

        if (pos != null) {
            BlockState state = mc.world.getBlockState(pos);
            if (!state.isAir()) {
                returnTimer = -1;
                choose(mc, p, state, pos);
                return;
            }
        }

        // не копаем
        if (!altered) return;
        if (returnTimer < 0) returnTimer = backDelay.get();
        if (returnTimer > 0) { returnTimer--; return; }
        if (mc.currentScreen != null) return;   // ждём, пока закроется окно

        if (back.get()) restore(mc, p); else forget();
    }

    private void choose(MinecraftClient mc, ClientPlayerEntity p, BlockState state, BlockPos pos) {
        float hardness = state.getHardness(mc.world, pos);
        if (hardness < 0f) return;                        // бедрок и т.п.
        if (saveDur.get() && hardness == 0f) return;      // ломается мгновенно, инструмент не нужен

        PlayerInventory inv = p.getInventory();
        int cur = inv.getSelectedSlot();
        int best = cur;
        float bestScore = inv.getStack(cur).getMiningSpeedMultiplier(state);

        // 1) хотбар
        for (int i = 0; i < 9; i++) {
            if (i == cur) continue;
            float s = candidate(inv.getStack(i), state);
            if (s > bestScore + 0.05f) { bestScore = s; best = i; }
        }
        if (best != cur) {
            if (!altered) { altered = true; prevSlot = cur; }
            inv.setSelectedSlot(best);
            return;
        }

        // 2) основной инвентарь: меняем местами с выбранным слотом
        if (fromInv.get() && swappedInv == -1) {
            int bestInv = -1;
            for (int i = 9; i < 36; i++) {
                float s = candidate(inv.getStack(i), state);
                if (s > bestScore + 0.05f) { bestScore = s; bestInv = i; }
            }
            if (bestInv != -1) {
                if (!altered) { altered = true; prevSlot = cur; }
                swappedItem = inv.getStack(bestInv).getItem();
                swappedInv = bestInv;
                swappedHotbar = cur;
                mc.interactionManager.clickSlot(p.playerScreenHandler.syncId, bestInv, cur,
                        SlotActionType.SWAP, p);
            }
        }
    }

    /** Скорость копания предметом, или -1, если предмет нам не подходит. */
    private float candidate(ItemStack st, BlockState state) {
        if (st.isEmpty()) return -1f;
        if (saveDur.get() && st.isDamageable()) {
            int left = st.getMaxDamage() - st.getDamage();
            if (left <= Math.max(2, st.getMaxDamage() / 20)) return -1f;
        }
        return st.getMiningSpeedMultiplier(state);
    }

    private void restore(MinecraftClient mc, ClientPlayerEntity p) {
        PlayerInventory inv = p.getInventory();
        if (swappedInv != -1 && swappedItem != null && mc.currentScreen == null
                && mc.interactionManager != null
                && inv.getStack(swappedHotbar).isOf(swappedItem)) {
            mc.interactionManager.clickSlot(p.playerScreenHandler.syncId, swappedInv, swappedHotbar,
                    SlotActionType.SWAP, p);
        }
        if (prevSlot >= 0 && prevSlot < 9) inv.setSelectedSlot(prevSlot);
        forget();
    }

    private void forget() {
        altered = false;
        prevSlot = -1;
        swappedInv = -1;
        swappedHotbar = -1;
        swappedItem = null;
        returnTimer = -1;
    }
}