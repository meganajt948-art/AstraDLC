package dev.dj.cortim.module;

import dev.dj.cortim.mixin.HandledScreenAccessor;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ItemScroller extends Module {

    public static ItemScroller instance;

    private final BoolSetting shiftMove = add(new BoolSetting("Перенос с Shift",
            "Зажми Shift и ЛКМ и води мышью по слотам: предметы переносятся", true));

    private final BoolSetting wheel = add(new BoolSetting("Колесо",
            "Колесо над слотом: вверх переносит предмет в другой инвентарь, вниз возвращает", true));

    private final IntSetting speed = add(new IntSetting("Скорость",
            "Сколько слотов или предметов за тик", 1, 1, 10) {
        @Override public String display() { return get() + " /тик"; }
    });

    // состояние перетаскивания
    private boolean wasDragging = false;
    private double lastMx, lastMy;
    private final Set<Integer> visited = new HashSet<>();
    private final ArrayDeque<Integer> queue = new ArrayDeque<>();

    public ItemScroller() {
        super("ItemScroller", Category.PLAYER);
        instance = this;
    }

    // ---------------- колесо мыши ----------------
    public static void registerEvents() {
        ScreenEvents.AFTER_INIT.register((client, screen, w, h) -> {
            if (screen instanceof HandledScreen<?> hs) {
                ScreenMouseEvents.allowMouseScroll(screen).register((s, mx, my, ha, va) -> {
                    ItemScroller i = instance;
                    if (i == null || !i.isEnabled()) return true;
                    try {
                        return !i.onWheel(hs, mx, my, va); // true = пропустить ваниль, false = мы обработали
                    } catch (Throwable t) {
                        return true;
                    }
                });
            }
        });
    }

    private boolean onWheel(HandledScreen<?> hs, double mx, double my, double v) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity p = mc.player;
        if (!wheel.get() || v == 0 || p == null || mc.interactionManager == null) return false;
        if (!allowedScreen(hs) || hs.getScreenHandler() instanceof PlayerScreenHandler) return false;

        ScreenHandler h = hs.getScreenHandler();
        if (!h.getCursorStack().isEmpty()) return false;

        Slot hov = slotAt(hs, mx, my);
        if (hov == null || !hov.hasStack()) return false;

        boolean hovPlayer = hov.inventory == p.getInventory();
        int moved = 0;

        for (int k = 0; k < speed.get(); k++) {
            Slot from, to;
            if (v > 0) {
                // вверх: из слота под курсором в другой инвентарь
                from = hov;
                if (!from.hasStack() || !from.canTakeItems(p) || !from.canInsert(from.getStack())) break;
                to = findTarget(h, p, from.getStack(), !hovPlayer, null);
            } else {
                // вниз: из другого инвентаря в слот под курсором (того же предмета)
                if (!hov.hasStack()) break;
                ItemStack ref = hov.getStack().copy();
                from = findSource(h, p, ref, !hovPlayer);
                to = accepts(hov, ref) ? hov : findTarget(h, p, ref, hovPlayer, hov);
            }
            if (from == null || to == null || from == to) break;
            moveOne(mc, p, h, from, to);
            moved++;
        }
        return moved > 0;
    }

    /** Переносит ровно один предмет: взять стак, положить один ПКМ, вернуть остаток. */
    private void moveOne(MinecraftClient mc, ClientPlayerEntity p, ScreenHandler h, Slot from, Slot to) {
        int id = h.syncId;
        mc.interactionManager.clickSlot(id, from.id, 0, SlotActionType.PICKUP, p);
        mc.interactionManager.clickSlot(id, to.id, 1, SlotActionType.PICKUP, p);
        mc.interactionManager.clickSlot(id, from.id, 0, SlotActionType.PICKUP, p);
        if (!h.getCursorStack().isEmpty()) {
            mc.interactionManager.clickSlot(id, from.id, 0, SlotActionType.PICKUP, p); // страховка
        }
    }

    // ---------------- Shift + ЛКМ: перетаскивание ----------------
    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity p = mc.player;
        if (!isEnabled() || p == null || mc.interactionManager == null
                || !(mc.currentScreen instanceof HandledScreen<?> hs) || !allowedScreen(hs)) {
            resetDrag();
            return;
        }

        ScreenHandler h = hs.getScreenHandler();
        long win = mc.getWindow().getHandle();
        boolean down = GLFW.glfwGetMouseButton(win, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;
        boolean shift = GLFW.glfwGetKey(win, GLFW.GLFW_KEY_LEFT_SHIFT) == GLFW.GLFW_PRESS
                || GLFW.glfwGetKey(win, GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS;

        if (!(shiftMove.get() && shift && down && h.getCursorStack().isEmpty())) {
            resetDrag();
            return;
        }

        double[] cx = new double[1], cy = new double[1];
        GLFW.glfwGetCursorPos(win, cx, cy);
        int[] ww = new int[1], wh = new int[1];
        GLFW.glfwGetWindowSize(win, ww, wh);
        double mx = cx[0] * mc.getWindow().getScaledWidth() / (double) ww[0];
        double my = cy[0] * mc.getWindow().getScaledHeight() / (double) wh[0];

        if (!wasDragging) {
            // первый слот ваниль уже перенесла сама (Shift+клик), второй раз не трогаем
            visited.clear();
            queue.clear();
            Slot start = slotAt(hs, mx, my);
            if (start != null) visited.add(start.id);
        } else {
            // идём по отрезку от прошлой позиции, чтобы не пропускать слоты при быстром движении
            double dx = mx - lastMx, dy = my - lastMy;
            int steps = (int) Math.max(1, Math.ceil(Math.hypot(dx, dy) / 4.0));
            for (int i = 1; i <= steps; i++) {
                double t = i / (double) steps;
                Slot sl = slotAt(hs, lastMx + dx * t, lastMy + dy * t);
                if (sl != null && visited.add(sl.id) && sl.hasStack()) queue.add(sl.id);
            }
        }
        wasDragging = true;
        lastMx = mx;
        lastMy = my;

        int n = speed.get();
        while (n > 0 && !queue.isEmpty()) {
            int id = queue.poll();
            Slot sl = h.getSlot(id);
            if (!sl.hasStack() || !sl.canTakeItems(p)) continue;
            mc.interactionManager.clickSlot(h.syncId, id, 0, SlotActionType.QUICK_MOVE, p);
            n--;
        }
    }

    private void resetDrag() {
        wasDragging = false;
        visited.clear();
        queue.clear();
    }

    // ---------------- вспомогательное ----------------

    /** Окна, где переносить нельзя: креатив и серверные меню (аукцион, магазин). */
    private static boolean allowedScreen(HandledScreen<?> hs) {
        if (hs instanceof CreativeInventoryScreen) return false;
        String t = hs.getTitle().getString().toLowerCase(Locale.ROOT);
        return !(t.contains("аукцион") || t.contains("auction")
                || t.contains("магазин") || t.contains("shop")
                || t.contains("маркет") || t.contains("market"));
    }

    private static Slot slotAt(HandledScreen<?> hs, double x, double y) {
        HandledScreenAccessor a = (HandledScreenAccessor) (Object) hs;
        int ox = a.cortim$getX(), oy = a.cortim$getY();
        for (Slot s : hs.getScreenHandler().slots) {
            if (!s.isEnabled()) continue;
            int sx = ox + s.x, sy = oy + s.y;
            if (x >= sx && x < sx + 16 && y >= sy && y < sy + 16) return s;
        }
        return null;
    }

    private static boolean accepts(Slot s, ItemStack st) {
        if (!s.isEnabled() || !s.canInsert(st)) return false;
        ItemStack in = s.getStack();
        if (in.isEmpty()) return true;
        return ItemStack.areItemsAndComponentsEqual(in, st)
                && in.getCount() < Math.min(s.getMaxItemCount(in), in.getMaxCount());
    }

    /** Куда положить: сначала доливаем неполные стаки, потом берём пустой слот. */
    private static Slot findTarget(ScreenHandler h, ClientPlayerEntity p, ItemStack st,
                                   boolean playerSide, Slot exclude) {
        for (int pass = 0; pass < 2; pass++) {
            for (Slot s : h.slots) {
                if ((s.inventory == p.getInventory()) != playerSide) continue;
                if (s == exclude || !accepts(s, st)) continue;
                boolean empty = !s.hasStack();
                if ((pass == 0) == empty) continue;
                return s;
            }
        }
        return null;
    }

    /** Откуда взять: слот той же стороны с таким же предметом. */
    private static Slot findSource(ScreenHandler h, ClientPlayerEntity p, ItemStack ref, boolean playerSide) {
        for (Slot s : h.slots) {
            if ((s.inventory == p.getInventory()) != playerSide) continue;
            if (!s.isEnabled() || !s.hasStack() || !s.canTakeItems(p)) continue;
            ItemStack in = s.getStack();
            if (!ItemStack.areItemsAndComponentsEqual(in, ref) || !s.canInsert(in)) continue;
            return s;
        }
        return null;
    }
}