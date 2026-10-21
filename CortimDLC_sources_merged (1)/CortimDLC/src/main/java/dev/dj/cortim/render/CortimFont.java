package dev.dj.cortim.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class CortimFont {

    public static final Identifier FONT = Identifier.of("cortim", "default");

    private CortimFont() {}

    public static MutableText t(String s) {
        return Text.literal(s).setStyle(
                Style.EMPTY.withFont(new StyleSpriteSource.Font(FONT))
        );
    }

    private static boolean isOurChar(char c) {
        return c >= 32 && c <= 126;
    }

    // БЫСТРАЯ отрисовка: 1 вызов на сегмент, без 8-кратной обводки
    public static void drawMixed(DrawContext ctx, String text, int x, int y, int color, boolean withShadow) {
        var tr = MinecraftClient.getInstance().textRenderer;
        int cx = x;
        int i = 0;
        int n = text.length();

        while (i < n) {
            boolean isOurs = isOurChar(text.charAt(i));
            int start = i;
            while (i < n && isOurChar(text.charAt(i)) == isOurs) i++;
            String seg = text.substring(start, i);

            if (isOurs) {
                MutableText t = t(seg);
                if (withShadow) {
                    ctx.drawTextWithShadow(tr, t, cx, y, color);
                } else {
                    ctx.drawText(tr, t, cx, y, color, false);
                }
                cx += tr.getWidth(t);
            } else {
                if (withShadow) {
                    ctx.drawTextWithShadow(tr, seg, cx, y, color);
                } else {
                    ctx.drawText(tr, seg, cx, y, color, false);
                }
                cx += tr.getWidth(seg);
            }
        }
    }

    public static int widthMixed(String text) {
        var tr = MinecraftClient.getInstance().textRenderer;
        int total = 0;
        int i = 0;
        int n = text.length();
        while (i < n) {
            boolean isOurs = isOurChar(text.charAt(i));
            int start = i;
            while (i < n && isOurChar(text.charAt(i)) == isOurs) i++;
            String seg = text.substring(start, i);
            total += isOurs ? tr.getWidth(t(seg)) : tr.getWidth(seg);
        }
        return total;
    }

    public static void draw(DrawContext ctx, String text, int x, int y, int color) {
        drawMixed(ctx, text, x, y, color, true);
    }

    public static void drawPlain(DrawContext ctx, String text, int x, int y, int color) {
        drawMixed(ctx, text, x, y, color, false);
    }

    public static void drawShadow(DrawContext ctx, String text, int x, int y, int color) {
        drawMixed(ctx, text, x, y, color, true);
    }

    public static int width(String text) {
        return widthMixed(text);
    }
}