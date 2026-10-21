package dev.dj.cortim.gui;

import dev.dj.cortim.CortimConfig;
import dev.dj.cortim.render.CortimFont;
import dev.dj.cortim.render.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LanguageScreen extends Screen {

    private static final Identifier FLAG_RU = Identifier.of("cortim", "textures/gui/flag_ru.png");
    private static final Identifier FLAG_EN = Identifier.of("cortim", "textures/gui/flag_en.png");

    private static final int WHITE = 0xFFF1F1F4;
    private static final int MUTED = 0xFF85858F;
    private static final int PANEL = 0xE609090C;

    private final Screen parent;

    private int boxX, boxY, boxW, boxH;
    private int ruX, enX, cardY, cardW, cardH;

    public LanguageScreen(Screen parent) {
        super(Text.literal("Language"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        boxW = Math.min(480, width - 32);
        boxH = 264;
        boxX = (width - boxW) / 2;
        boxY = (height - boxH) / 2;

        int gap = 18;
        int innerW = boxW - 48;
        cardW = (innerW - gap) / 2;
        cardH = 104;
        ruX = boxX + 24;
        enX = ruX + cardW + gap;
        cardY = boxY + 100;
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(0, 0, width, height, 0x66000000);

        RenderUtils.drawSmoothRoundedRect(ctx, boxX, boxY, boxW, boxH, 24f, PANEL);

        drawGlobe(ctx, boxX + 24, boxY + 24);
        CortimFont.draw(ctx, Lang.tr("lang.title"), boxX + 72, boxY + 28, WHITE);
        CortimFont.draw(ctx, Lang.tr("lang.sub"), boxX + 72, boxY + 46, MUTED);

        boolean ru = Lang.ru();
        drawCard(ctx, ruX, cardY, "RU", "Русский", FLAG_RU, ru,
                inside(mouseX, mouseY, ruX, cardY, cardW, cardH));
        drawCard(ctx, enX, cardY, "EN", "English", FLAG_EN, !ru,
                inside(mouseX, mouseY, enX, cardY, cardW, cardH));

        String hint = Lang.tr("lang.hint");
        CortimFont.draw(ctx, hint, boxX + (boxW - CortimFont.width(hint)) / 2,
                boxY + boxH - 30, MUTED);
    }

    private void drawGlobe(DrawContext ctx, int x, int y) {
        // круглая подложка 38x38
        RenderUtils.drawSmoothRoundedRect(ctx, x, y, 38, 38, 19f, 0xFF242429);
        int gx = x + 10, gy = y + 10; // глобус 18x18
        int light = 0xFFD8D8DC, dark = 0xFF242429;
        RenderUtils.drawSmoothRoundedRect(ctx, gx, gy, 18, 18, 9f, light);
        RenderUtils.drawSmoothRoundedRect(ctx, gx + 1, gy + 1, 16, 16, 8f, dark);
        RenderUtils.drawSmoothRoundedRect(ctx, gx + 5, gy, 8, 18, 4f, light);
        RenderUtils.drawSmoothRoundedRect(ctx, gx + 6, gy + 1, 6, 16, 3f, dark);
        ctx.fill(gx + 1, gy + 8, gx + 17, gy + 9, light);
    }

    private void drawCard(DrawContext ctx, int x, int y, String code, String name,
                          Identifier flag, boolean selected, boolean hover) {
        int border = selected ? 0xFFE6E6EA : 0xFF2A2A31;
        int fill = selected ? 0xFF15151A : (hover ? 0xFF18181D : 0xFF0F0F13);

        RenderUtils.drawSmoothRoundedRect(ctx, x, y, cardW, cardH, 16f, border);
        RenderUtils.drawSmoothRoundedRect(ctx, x + 1, y + 1, cardW - 2, cardH - 2, 15f, fill);

        int fw = 40, fh = 27;
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, flag,
                x + 18, y + 16, 0f, 0f, fw, fh, fw, fh);

        CortimFont.draw(ctx, code, x + 18, y + 54, WHITE);
        CortimFont.draw(ctx, name, x + 18, y + 72, MUTED);

        if (selected) {
            int cx = x + cardW - 34, cy = y + 14;
            RenderUtils.drawSmoothRoundedRect(ctx, cx, cy, 20, 20, 10f, 0xFFE6E6EA);
            drawCheck(ctx, cx + 6, cy + 7, 0xFF111114);
        }
    }

    private void drawCheck(DrawContext ctx, int x, int y, int color) {
        int[][] pts = { {0, 2}, {1, 3}, {2, 4}, {3, 3}, {4, 2}, {5, 1}, {6, 0} };
        for (int[] p : pts) {
            ctx.fill(x + p[0], y + p[1], x + p[0] + 2, y + p[1] + 2, color);
        }
    }

    private boolean inside(int mx, int my, int x, int y, int w, int h) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        int mx = (int) click.x();
        int my = (int) click.y();

        if (inside(mx, my, ruX, cardY, cardW, cardH)) {
            CortimConfig.language = "RU";
            return true;
        }
        if (inside(mx, my, enX, cardY, cardW, cardH)) {
            CortimConfig.language = "EN";
            return true;
        }
        if (!inside(mx, my, boxX, boxY, boxW, boxH)) {
            close();
            return true;
        }
        return super.mouseClicked(click, doubled);
    }

    @Override
    public void close() {
        MinecraftClient.getInstance().setScreen(parent);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}