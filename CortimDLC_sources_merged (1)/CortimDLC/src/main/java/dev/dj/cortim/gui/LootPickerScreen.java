package dev.dj.cortim.gui;

import dev.dj.cortim.module.LootCatalog;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class LootPickerScreen extends Screen {

    private static final int ROW_H = 24;
    private static final int ROW_GAP = 6;
    private static final int COL_GAP = 12;

    private final ItemSelector module;
    private final Screen parent;

    private int px, py, pw, ph;
    private int lx, ly, colW, visibleRows;
    private int scroll = 0;
    private boolean lastDown = false;
    private int[] btnAll, btnClear;

    public LootPickerScreen(ItemSelector module, Screen parent) {
        super(Text.literal("Лут"));
        this.module = module;
        this.parent = parent;
    }

    @Override
    protected void init() {
        pw = Math.min(width - 40, 560);
        ph = Math.min(height - 40, 520);
        px = (width - pw) / 2;
        py = (height - ph) / 2;

        btnAll = new int[]{px + pw - 16 - 150, py + 12, 70, 20};
        btnClear = new int[]{px + pw - 16 - 74, py + 12, 74, 20};

        lx = px + 16;
        ly = py + 44;
        colW = (pw - 32 - COL_GAP) / 2;
        visibleRows = Math.max(1, (py + ph - 16 - ly + ROW_GAP) / (ROW_H + ROW_GAP));
    }

    private int totalRows() { return (LootCatalog.ALL.size() + 1) / 2; }
    private int maxScroll() { return Math.max(0, totalRows() - visibleRows); }

    @Override
    public boolean mouseScrolled(double mx, double my, double h, double v) {
        scroll = Math.max(0, Math.min(maxScroll(), scroll - (int) Math.signum(v)));
        return true;
    }

    @Override public void renderBackground(DrawContext c, int mx, int my, float d) { }
    @Override public boolean shouldPause() { return false; }
    @Override public void close() { MinecraftClient.getInstance().setScreen(parent); }

    private static boolean in(int[] r, int x, int y) {
        return x >= r[0] && x < r[0] + r[2] && y >= r[1] && y < r[1] + r[3];
    }

    private void button(DrawContext c, int[] r, String label, int mx, int my) {
        c.fill(r[0], r[1], r[0] + r[2], r[1] + r[3], in(r, mx, my) ? 0xFF2A2A2F : 0xFF1C1C20);
        int tw = textRenderer.getWidth(label);
        c.drawTextWithShadow(textRenderer, Text.literal(label), r[0] + (r[2] - tw) / 2, r[1] + 6, 0xFFFFFFFF);
    }

    private int cellX(int i) { return lx + (i % 2) * (colW + COL_GAP); }
    private int cellY(int i) { return ly + ((i / 2) - scroll) * (ROW_H + ROW_GAP); }

    @Override
    public void render(DrawContext c, int mx, int my, float delta) {
        scroll = Math.max(0, Math.min(maxScroll(), scroll));

        c.fill(0, 0, width, height, 0xAA000000);
        c.fill(px, py, px + pw, py + ph, 0xF0131316);

        c.drawTextWithShadow(textRenderer, Text.literal("Список лута"), px + 16, py + 16, 0xFFFFFFFF);
        c.drawTextWithShadow(textRenderer,
                Text.literal(module.getSelected().size() + " / " + LootCatalog.ALL.size()),
                px + 110, py + 16, 0xFFAAAAAA);
        button(c, btnAll, "Все", mx, my);
        button(c, btnClear, "Очистить", mx, my);

        List<LootCatalog.Entry> all = LootCatalog.ALL;
        int start = scroll * 2;
        int end = Math.min(all.size(), start + visibleRows * 2);
        for (int i = start; i < end; i++) {
            LootCatalog.Entry e = all.get(i);
            int x = cellX(i), y = cellY(i);
            boolean sel = module.getSelected().contains(e.id());
            boolean hover = mx >= x && mx < x + colW && my >= y && my < y + ROW_H;

            c.fill(x, y, x + colW, y + ROW_H, hover ? 0xFF55555A : 0xFF4A4A4E);
            c.fill(x, y, x + colW, y + 1, 0xFF202024);
            c.fill(x, y + ROW_H - 1, x + colW, y + ROW_H, 0xFF202024);

            c.drawItem(new ItemStack(e.icon()), x + 6, y + 4);
            c.drawTextWithShadow(textRenderer, Text.literal(e.name()), x + 28, y + 8,
                    sel ? 0xFFFFFFFF : 0xFFAAAAAA);

            int bx = x + colW - 18, by = y + 6;
            c.fill(bx, by, bx + 12, by + 12, 0xFFE6E6E6);
            if (sel) c.fill(bx + 2, by + 2, bx + 10, by + 10, 0xFF3DDC84);
            else c.fill(bx + 2, by + 2, bx + 10, by + 10, 0xFF2A2A2E);
        }

        super.render(c, mx, my, delta);

        long win = MinecraftClient.getInstance().getWindow().getHandle();
        boolean down = GLFW.glfwGetMouseButton(win, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;
        if (down && !lastDown) onClick(mx, my);
        lastDown = down;
    }

    private void onClick(int mx, int my) {
        if (in(btnAll, mx, my)) {
            for (LootCatalog.Entry e : LootCatalog.ALL)
                if (!module.getSelected().contains(e.id())) module.toggleItem(e.id());
            return;
        }
        if (in(btnClear, mx, my)) { module.clearItems(); return; }

        List<LootCatalog.Entry> all = LootCatalog.ALL;
        int start = scroll * 2;
        int end = Math.min(all.size(), start + visibleRows * 2);
        for (int i = start; i < end; i++) {
            int x = cellX(i), y = cellY(i);
            if (mx >= x && mx < x + colW && my >= y && my < y + ROW_H) {
                module.toggleItem(all.get(i).id());
                return;
            }
        }
    }
}