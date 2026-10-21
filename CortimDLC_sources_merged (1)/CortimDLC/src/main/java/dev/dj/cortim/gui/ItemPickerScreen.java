package dev.dj.cortim.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemPickerScreen extends Screen {

    private static List<ItemStack> ALL = null;

    private final ItemSelector module;
    private final Screen parent;

    private TextFieldWidget search;
    private boolean onlySelected = false;
    private int scrollRows = 0;
    private boolean lastDown = false;

    private final List<ItemStack> shown = new ArrayList<>();
    private String lastQuery = null;
    private boolean lastOnly = false;

    private int px, py, pw, ph;
    private int gx, gy, gcols, grows;
    private int[] tabAll, tabSel, btnClear, btnReset;

    private static final int CELL = 28;
    private static final int PITCH = 32;

    public ItemPickerScreen(ItemSelector module, Screen parent) {
        super(Text.literal("Предметы"));
        this.module = module;
        this.parent = parent;
    }

    private static List<ItemStack> all() {
        if (ALL == null) {
            ALL = new ArrayList<>();
            for (Item item : Registries.ITEM) {
                if (item == Items.AIR) continue;
                ALL.add(new ItemStack(item));
            }
        }
        return ALL;
    }

    @Override
    protected void init() {
        pw = Math.min(width - 40, 780);
        ph = Math.min(height - 40, 560);
        px = (width - pw) / 2;
        py = (height - ph) / 2;

        int searchW = (int) (pw * 0.40);
        search = new TextFieldWidget(textRenderer, px + 16, py + 40, searchW, 20, Text.literal("Поиск"));
        search.setPlaceholder(Text.literal("Поиск"));
        addDrawableChild(search);
        setInitialFocus(search);

        int x = px + 16 + searchW + 10;
        tabAll = new int[]{x, py + 40, 56, 20};
        tabSel = new int[]{x + 60, py + 40, 80, 20};
        btnClear = new int[]{x + 150, py + 40, 76, 20};
        btnReset = new int[]{x + 232, py + 40, 56, 20};

        gx = px + 16;
        gy = py + 74;
        gcols = Math.max(1, (pw - 32) / PITCH);
        grows = Math.max(1, (py + ph - 30 - gy) / PITCH);
        lastQuery = null;
    }

    private void refilter() {
        String q = search.getText().trim().toLowerCase(Locale.ROOT);
        if (q.equals(lastQuery) && onlySelected == lastOnly) return;
        lastQuery = q;
        lastOnly = onlySelected;
        shown.clear();
        for (ItemStack st : all()) {
            String id = Registries.ITEM.getId(st.getItem()).toString();
            if (onlySelected && !module.getSelected().contains(id)) continue;
            if (!q.isEmpty()) {
                String name = st.getName().getString().toLowerCase(Locale.ROOT);
                if (!name.contains(q) && !id.contains(q)) continue;
            }
            shown.add(st);
        }
        scrollRows = 0;
    }

    private int maxScroll() {
        int rows = (shown.size() + gcols - 1) / gcols;
        return Math.max(0, rows - grows);
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double h, double v) {
        scrollRows = Math.max(0, Math.min(maxScroll(), scrollRows - (int) Math.signum(v)));
        return true;
    }

    @Override
    public void renderBackground(DrawContext c, int mx, int my, float d) { }

    @Override
    public boolean shouldPause() { return false; }

    @Override
    public void close() {
        MinecraftClient.getInstance().setScreen(parent);
    }

    private static boolean in(int[] r, int x, int y) {
        return x >= r[0] && x < r[0] + r[2] && y >= r[1] && y < r[1] + r[3];
    }

    private void button(DrawContext c, int[] r, String label, boolean active, int mx, int my) {
        int bg = active ? 0xFF3A3A40 : (in(r, mx, my) ? 0xFF2A2A2F : 0xFF1C1C20);
        c.fill(r[0], r[1], r[0] + r[2], r[1] + r[3], bg);
        int tw = textRenderer.getWidth(label);
        c.drawTextWithShadow(textRenderer, Text.literal(label),
                r[0] + (r[2] - tw) / 2, r[1] + 6, 0xFFFFFFFF);
    }

    @Override
    public void render(DrawContext c, int mx, int my, float delta) {
        refilter();
        scrollRows = Math.max(0, Math.min(maxScroll(), scrollRows));

        c.fill(0, 0, width, height, 0xAA000000);
        c.fill(px, py, px + pw, py + ph, 0xF0131316);

        c.drawTextWithShadow(textRenderer, Text.literal("Предметы"), px + 16, py + 16, 0xFFFFFFFF);
        c.drawTextWithShadow(textRenderer,
                Text.literal(module.getSelected().size() + " выбрано"), px + 90, py + 16, 0xFFAAAAAA);

        button(c, tabAll, "Все", !onlySelected, mx, my);
        button(c, tabSel, "Выбранные", onlySelected, mx, my);
        button(c, btnClear, "Очистить", false, mx, my);
        button(c, btnReset, "Сброс", false, mx, my);

        ItemStack hovered = null;
        int start = scrollRows * gcols;
        int end = Math.min(shown.size(), start + gcols * grows);

        for (int i = start; i < end; i++) {
            int idx = i - start;
            int x = gx + (idx % gcols) * PITCH;
            int y = gy + (idx / gcols) * PITCH;
            ItemStack st = shown.get(i);
            String id = Registries.ITEM.getId(st.getItem()).toString();
            boolean sel = module.getSelected().contains(id);
            boolean hover = mx >= x && mx < x + CELL && my >= y && my < y + CELL;

            c.fill(x, y, x + CELL, y + CELL, hover ? 0xFF2C2C32 : 0xFF1E1E22);
            if (sel) {
                c.fill(x, y, x + CELL, y + 1, 0xFFE6E6E6);
                c.fill(x, y + CELL - 1, x + CELL, y + CELL, 0xFFE6E6E6);
                c.fill(x, y, x + 1, y + CELL, 0xFFE6E6E6);
                c.fill(x + CELL - 1, y, x + CELL, y + CELL, 0xFFE6E6E6);
                c.fill(x + CELL - 8, y + 2, x + CELL - 2, y + 8, 0xFF3DDC84);
            }
            c.drawItem(st, x + (CELL - 16) / 2, y + (CELL - 16) / 2);
            if (hover) hovered = st;
        }

        c.drawTextWithShadow(textRenderer,
                Text.literal("Клик — добавить или убрать · " + shown.size() + " показано"),
                px + 16, py + ph - 18, 0xFF888888);

        super.render(c, mx, my, delta);

        if (hovered != null) c.drawTooltip(textRenderer, hovered.getName(), mx, my);

        // клики через GLFW (по фронту нажатия)
        long win = MinecraftClient.getInstance().getWindow().getHandle();
        boolean down = GLFW.glfwGetMouseButton(win, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;
        if (down && !lastDown) onClick(mx, my);
        lastDown = down;
    }

    private void onClick(int mx, int my) {
        if (in(tabAll, mx, my)) { onlySelected = false; return; }
        if (in(tabSel, mx, my)) { onlySelected = true; return; }
        if (in(btnClear, mx, my)) { module.clearItems(); lastQuery = null; return; }
        if (in(btnReset, mx, my)) {
            search.setText("");
            onlySelected = false;
            scrollRows = 0;
            lastQuery = null;
            return;
        }

        int start = scrollRows * gcols;
        int end = Math.min(shown.size(), start + gcols * grows);
        for (int i = start; i < end; i++) {
            int idx = i - start;
            int x = gx + (idx % gcols) * PITCH;
            int y = gy + (idx / gcols) * PITCH;
            if (mx >= x && mx < x + CELL && my >= y && my < y + CELL) {
                module.toggleItem(Registries.ITEM.getId(shown.get(i).getItem()).toString());
                if (onlySelected) lastQuery = null; // обновить список «Выбранные»
                return;
            }
        }
    }
}