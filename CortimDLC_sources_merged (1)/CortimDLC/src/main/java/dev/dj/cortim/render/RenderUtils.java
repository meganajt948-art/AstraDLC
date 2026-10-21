package dev.dj.cortim.render;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

/**
 * Скруглённые прямоугольники через nine-slice спрайты (один вызов на фигуру).
 * Спрайты лежат в assets/cortim/textures/gui/sprites/round/ (fill_N и ring_N, N = 1..32).
 * Они высокого разрешения со встроенным сглаживанием, поэтому круг ровный.
 */
public final class RenderUtils {
    private RenderUtils() {}

    private static final int MAX_R = 32;
    private static final int BORDER_BANDS = 4;

    private static final Identifier[] FILL = new Identifier[MAX_R + 1];
    private static final Identifier[] RING = new Identifier[MAX_R + 1];

    static {
        for (int r = 1; r <= MAX_R; r++) {
            FILL[r] = Identifier.of("cortim", "round/fill_" + r);
            RING[r] = Identifier.of("cortim", "round/ring_" + r);
        }
    }

    private static int radius(float r, int w, int h) {
        int rr = Math.round(r);
        rr = Math.min(rr, Math.min(w, h) / 2);
        return Math.min(rr, MAX_R);
    }

    private static void sprite(DrawContext ctx, Identifier id, int x, int y, int w, int h, int color) {
        ctx.drawGuiTexture(RenderPipelines.GUI_TEXTURED, id, x, y, w, h, color);
    }

    // ---------------------------------------------------------------
    // Заливка
    // ---------------------------------------------------------------

    public static void drawSmoothRoundedRect(DrawContext ctx, int x, int y, int w, int h,
                                             float r, int color) {
        drawSmoothRoundedRect(ctx, x, y, w, h, r, color, true, true, true, true);
    }

    public static void drawSmoothRoundedRect(DrawContext ctx, int x, int y, int w, int h,
                                             float r, int color,
                                             boolean tl, boolean tr, boolean bl, boolean br) {
        if (w <= 0 || h <= 0 || (color >>> 24) == 0) return;

        int rr = radius(r, w, h);
        if (rr < 1 || (!tl && !tr && !bl && !br)) {
            ctx.fill(x, y, x + w, y + h, color);
            return;
        }

        Identifier id = FILL[rr];

        if (tl && bl && !tr && !br) {            // скруглены только левые углы
            ctx.enableScissor(x, y, x + w, y + h);
            sprite(ctx, id, x, y, w + rr, h, color);
            ctx.disableScissor();
        } else if (tr && br && !tl && !bl) {     // только правые
            ctx.enableScissor(x, y, x + w, y + h);
            sprite(ctx, id, x - rr, y, w + rr, h, color);
            ctx.disableScissor();
        } else if (tl && tr && !bl && !br) {     // только верхние
            ctx.enableScissor(x, y, x + w, y + h);
            sprite(ctx, id, x, y, w, h + rr, color);
            ctx.disableScissor();
        } else if (bl && br && !tl && !tr) {     // только нижние
            ctx.enableScissor(x, y, x + w, y + h);
            sprite(ctx, id, x, y - rr, w, h + rr, color);
            ctx.disableScissor();
        } else {
            sprite(ctx, id, x, y, w, h, color);
        }
    }

    // ---------------------------------------------------------------
    // Обводка толщиной 1 GUI-пиксель, градиент сверху вниз (полосами)
    // ---------------------------------------------------------------

    public static void drawRoundedBorder(DrawContext ctx, int x, int y, int w, int h,
                                         float r, float thickness,
                                         int topColor, int bottomColor) {
        if (w <= 0 || h <= 0) return;
        if ((topColor >>> 24) == 0 && (bottomColor >>> 24) == 0) return;

        int rr = radius(r, w, h);
        if (rr < 1) return;
        Identifier id = RING[rr];

        if (topColor == bottomColor) {
            sprite(ctx, id, x, y, w, h, topColor);
            return;
        }

        for (int b = 0; b < BORDER_BANDS; b++) {
            int y0 = y + h * b / BORDER_BANDS;
            int y1 = (b == BORDER_BANDS - 1) ? y + h : y + h * (b + 1) / BORDER_BANDS;
            float f = (b + 0.5f) / BORDER_BANDS;
            int col = lerpColor(topColor, bottomColor, f);
            if ((col >>> 24) == 0) continue;

            ctx.enableScissor(x, y0, x + w, y1);
            sprite(ctx, id, x, y, w, h, col);
            ctx.disableScissor();
        }
    }

    // ---------------------------------------------------------------
    // Свечение: несколько расширяющихся колец с затуханием
    // ---------------------------------------------------------------

    public static void drawGlow(DrawContext ctx, int x, int y, int w, int h,
                                float r, int color, int layers) {
        int baseAlpha = color >>> 24;
        int rgb = color & 0xFFFFFF;
        if (baseAlpha == 0 || layers <= 0) return;

        for (int k = 1; k <= layers; k++) {
            float fall = 1f - (float) (k - 1) / layers;
            int a = (int) (baseAlpha * fall * fall);
            if (a <= 0) continue;
            int c = (a << 24) | rgb;
            drawRoundedBorder(ctx, x - k, y - k, w + 2 * k, h + 2 * k, r + k, 1f, c, c);
        }
    }

    private static int lerpColor(int c1, int c2, float f) {
        int a = (int) (((c1 >>> 24) & 0xFF) * (1 - f) + ((c2 >>> 24) & 0xFF) * f);
        int r = (int) (((c1 >> 16) & 0xFF) * (1 - f) + ((c2 >> 16) & 0xFF) * f);
        int g = (int) (((c1 >> 8) & 0xFF) * (1 - f) + ((c2 >> 8) & 0xFF) * f);
        int b = (int) ((c1 & 0xFF) * (1 - f) + (c2 & 0xFF) * f);
        return (a << 24) | (r << 16) | (g << 8) | b;
    }
}