package dev.dj.cortim.module;

import dev.dj.cortim.mixin.HandledScreenAccessor;
import dev.dj.cortim.render.RenderUtils;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.DyeColor;
import net.minecraft.util.collection.DefaultedList;

import java.util.Locale;

public class ShulkerPreview extends Module {

    public static ShulkerPreview instance;

    private static final int DEFAULT_COLOR = 0x8E5E9E; // обычный фиолетовый шалкер

    private final FloatSetting size = add(new FloatSetting("Размер",
            "Масштаб окна предпросмотра", 1.0f, 0.5f, 1.75f, 0.05f) {
        @Override public String display() { return String.format(Locale.ROOT, "%.2fx", get()); }
    });

    private final BoolSetting tint = add(new BoolSetting("Цвет шалкера",
            "Окно в цвет шалкера", true));

    private final BoolSetting compact = add(new BoolSetting("Компактно",
            "Меньше отступов, без пустых ячеек", false));

    public ShulkerPreview() {
        super("ShulkerPreview", Category.PLAYER);
        instance = this;
    }

    public static void registerRender() {
        ScreenEvents.AFTER_INIT.register((client, screen, w, h) -> {
            if (screen instanceof HandledScreen<?> hs) {
                ScreenEvents.afterRender(screen).register((s, ctx, mx, my, td) -> {
                    ShulkerPreview p = instance;
                    if (p != null && p.isEnabled()) {
                        try { p.render(ctx, hs, mx, my); } catch (Throwable ignored) {}
                    }
                });
            }
        });
    }

    private void render(DrawContext ctx, HandledScreen<?> hs, int mx, int my) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        if (!hs.getScreenHandler().getCursorStack().isEmpty()) return;

        Slot hov = slotAt(hs, mx, my);
        if (hov == null || !hov.hasStack()) return;

        ItemStack box = hov.getStack();
        if (!(box.getItem() instanceof BlockItem bi) || !(bi.getBlock() instanceof ShulkerBoxBlock sb)) return;

        DefaultedList<ItemStack> items = DefaultedList.ofSize(27, ItemStack.EMPTY);
        ContainerComponent comp = box.get(DataComponentTypes.CONTAINER);
        if (comp != null) comp.copyTo(items);

        // цвет
        int base = DEFAULT_COLOR;
        if (tint.get()) {
            DyeColor dye = sb.getColor();
            if (dye != null) base = dye.getEntityColor() & 0xFFFFFF;
        } else {
            base = 0x606060;
        }
        int bg = 0xF0000000 | mul(base, 0.30f);
        int border = 0xFF000000 | mul(base, 1.15f);
        int cell = 0x66000000 | mul(base, 0.12f);

        // размеры
        boolean cmp = compact.get();
        int pitch = cmp ? 16 : 18;
        int pad = cmp ? 4 : 6;
        int pw = 9 * pitch + pad * 2;
        int ph = 3 * pitch + pad * 2;
        float s = size.get();
        int w = Math.round(pw * s), h = Math.round(ph * s);

        int sw = mc.getWindow().getScaledWidth();
        int sh = mc.getWindow().getScaledHeight();
        int px = Math.max(2, Math.min(mx + 6, sw - w - 2));
        int py = my - h - 8;
        if (py < 2) py = Math.min(my + 24, sh - h - 2);

        var m = ctx.getMatrices();
        m.pushMatrix();
        m.translate(px, py);
        m.scale(s, s);

        RenderUtils.drawSmoothRoundedRect(ctx, 0, 0, pw, ph, 6f, bg);
        RenderUtils.drawRoundedBorder(ctx, 0, 0, pw, ph, 6f, 1f, border, border);

        for (int i = 0; i < 27; i++) {
            int col = i % 9, row = i / 9;
            int cx = pad + col * pitch;
            int cy = pad + row * pitch;
            ItemStack st = items.get(i);

            if (!cmp || !st.isEmpty()) {
                RenderUtils.drawSmoothRoundedRect(ctx, cx, cy, pitch - (cmp ? 0 : 2), pitch - (cmp ? 0 : 2), 3f, cell);
            }
            if (!st.isEmpty()) {
                int ix = cx + (pitch - (cmp ? 0 : 2) - 16) / 2;
                int iy = cy + (pitch - (cmp ? 0 : 2) - 16) / 2;
                ctx.drawItem(st, ix, iy);
                ctx.drawStackOverlay(mc.textRenderer, st, ix, iy);
            }
        }

        m.popMatrix();
    }

    private static int mul(int rgb, float f) {
        int r = Math.min(255, (int) (((rgb >> 16) & 0xFF) * f));
        int g = Math.min(255, (int) (((rgb >> 8) & 0xFF) * f));
        int b = Math.min(255, (int) ((rgb & 0xFF) * f));
        return (r << 16) | (g << 8) | b;
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
}