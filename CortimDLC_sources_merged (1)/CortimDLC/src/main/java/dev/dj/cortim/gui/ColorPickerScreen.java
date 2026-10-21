package dev.dj.cortim.gui;

import dev.dj.cortim.module.Module;
import dev.dj.cortim.render.CortimFont;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ColorPickerScreen extends Screen {

    private static final int PW = 260;
    private static final int PH = 400;
    private static final int PAD = 12;
    private static final int SV_SIZE = 220;
    private static final int HUE_H = 12;

    private final Module.ColorSetting setting;
    private final Screen parent;

    private float hue, sat, val;

    private boolean draggingSV = false;
    private boolean draggingHue = false;

    private static final int[] PRESETS = {
            0xFFFFFF, 0x000000, 0xFF0000, 0xFF8800,
            0xFFFF00, 0x00FF00, 0x00FFFF, 0x0066FF, 0x8800FF
    };

    private float uiScale = 1f;
    private int offsetX = 0, offsetY = 0;
    private int svX, svY;

    public ColorPickerScreen(Module.ColorSetting setting, Screen parent) {
        super(Text.literal("Выбор цвета"));
        this.setting = setting;
        this.parent = parent;

        int rgb = setting.getColor();
        float[] hsv = rgbToHsv(rgb);
        this.hue = hsv[0];
        this.sat = hsv[1];
        this.val = hsv[2];
    }

    @Override
    protected void init() {
        float kx = (float) width / PW;
        float ky = (float) height / PH;
        uiScale = Math.min(kx, ky);

        int scaledW = (int)(PW * uiScale);
        int scaledH = (int)(PH * uiScale);
        offsetX = (width - scaledW) / 2;
        offsetY = (height - scaledH) / 2;

        svX = (PW - SV_SIZE) / 2;
        svY = 56;
    }

    // virtual → screen
    private int sx(int vx) { return offsetX + Math.round(vx * uiScale); }
    private int sy(int vy) { return offsetY + Math.round(vy * uiScale); }
    private int sw(int vw) { return Math.round(vw * uiScale); }

    private void vRoundRect(DrawContext ctx, int vx, int vy, int vw, int vh, int r, int color) {
        int x = sx(vx);
        int y = sy(vy);
        int w = sw(vw);
        int h = sw(vh);
        int rr = sw(r);
        if (rr < 1) { ctx.fill(x, y, x + w, y + h, color); return; }
        if (rr * 2 > w) rr = w / 2;
        if (rr * 2 > h) rr = h / 2;
        ctx.fill(x + rr, y, x + w - rr, y + h, color);
        ctx.fill(x, y + rr, x + rr, y + h - rr, color);
        ctx.fill(x + w - rr, y + rr, x + w, y + h - rr, color);
        int steps = Math.min(rr / 2, 6);
        if (steps < 1) steps = 1;
        int stepH = Math.max(1, rr / steps);
        for (int s = 0; s < steps; s++) {
            int y1 = y + s * stepH;
            int y2 = y + Math.min((s + 1) * stepH, rr);
            double dy = rr - (s + 0.5) * stepH;
            if (dy < 0) dy = 0;
            int dx = (int)Math.sqrt(Math.max(0, rr * rr - dy * dy));
            int wL = rr - dx;
            if (wL > 0) {
                ctx.fill(x + wL, y1, x + rr, y2, color);
                ctx.fill(x + w - rr, y1, x + w - wL, y2, color);
            }
            int yb1 = y + h - Math.min((s + 1) * stepH, rr);
            int yb2 = y + h - s * stepH;
            if (wL > 0) {
                ctx.fill(x + wL, yb1, x + rr, yb2, color);
                ctx.fill(x + w - rr, yb1, x + w - wL, yb2, color);
            }
        }
    }

    private void drawText(DrawContext ctx, String text, int vx, int vy, int color) {
        CortimFont.draw(ctx, text, sx(vx), sy(vy), color);
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(0, 0, width, height, 0x80000000);

        int vmx = (int)((mouseX - offsetX) / uiScale);
        int vmy = (int)((mouseY - offsetY) / uiScale);

        // фон панели
        vRoundRect(ctx, 0, 0, PW, PH, 10, 0xE00E0E12);

        // Заголовок
        drawText(ctx, "Выбор цвета", PAD, 10, 0xFFFFFFFF);
        drawText(ctx, "Выберите цвет, который", PAD, 24, 0xFF808088);
        drawText(ctx, "будет использоваться.", PAD, 36, 0xFF808088);

        // Крестик
        int closeX = PW - 20;
        int closeY = 10;
        boolean hoverClose = vmx >= closeX - 6 && vmx <= closeX + 10
                && vmy >= closeY - 4 && vmy <= closeY + 12;
        drawText(ctx, "✕", closeX, closeY, hoverClose ? 0xFFFF5C5C : 0xFF909090);

        // SV
        drawSVSquare(ctx, svX, svY, SV_SIZE, SV_SIZE);

        // Hue
        int hueY = svY + SV_SIZE + 8;
        drawHueBar(ctx, svX, hueY, SV_SIZE, HUE_H);

        // RGB
        int rgbY = hueY + HUE_H + 10;
        int rgb = hsvToRgb(hue, sat, val);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;

        int fieldH = 18;
        int fieldW = (SV_SIZE - 16) / 3;
        drawField(ctx, svX, rgbY, fieldW, fieldH, "R", r);
        drawField(ctx, svX + fieldW + 8, rgbY, fieldW, fieldH, "G", g);
        drawField(ctx, svX + (fieldW + 8) * 2, rgbY, fieldW, fieldH, "B", b);

        // Пресеты
        int presetY = rgbY + fieldH + 16;
        drawText(ctx, "Сохранённые цвета", PAD, presetY, 0xFFFFFFFF);
        drawText(ctx, "Можете выбрать сохранённый цвет.", PAD, presetY + 12, 0xFF808088);

        int presetStart = presetY + 28;
        int psize = 20;
        int gap = 4;
        for (int i = 0; i < PRESETS.length; i++) {
            int px = PAD + i * (psize + gap);
            boolean hover = vmx >= px && vmx <= px + psize
                    && vmy >= presetStart && vmy <= presetStart + psize;
            vRoundRect(ctx, px, presetStart, psize, psize, 4, 0xFF000000 | PRESETS[i]);
            if (hover) {
                vRoundRect(ctx, px - 1, presetStart - 1, psize + 2, psize + 2, 5, 0x60FFFFFF);
            }
        }
    }

    private void drawField(DrawContext ctx, int x, int y, int w, int h, String label, int value) {
        vRoundRect(ctx, x, y, w, h, 4, 0xFF1A1A20);
        drawText(ctx, label, x + 6, y + 6, 0xFF808088);
        String val = String.valueOf(value);
        int vwPhys = CortimFont.width(val);
        int vwVirt = (int)(vwPhys / uiScale);
        drawText(ctx, val, x + w - vwVirt - 6, y + 6, 0xFFFFFFFF);
    }

    private void drawSVSquare(DrawContext ctx, int x, int y, int w, int h) {
        int x1 = sx(x);
        int y1 = sy(y);
        int x2 = sx(x + w);
        int y2 = sy(y + h);

        int pureHue = 0xFF000000 | (hsvToRgb(hue, 1f, 1f) & 0xFFFFFF);

        // 1. Горизонтальный: белый (s=0) → чистый hue (s=1)
        ctx.fillGradient(x1, y1, x2, y2, 0xFFFFFFFF, pureHue);

        // 2. Вертикальный поверх: прозрачный сверху → чёрный снизу
        ctx.fillGradient(x1, y1, x2, y2, 0x00000000, 0xFF000000);

        // курсор
        int cx = x + (int)(sat * w);
        int cy = y + (int)((1f - val) * h);
        vRoundRect(ctx, cx - 5, cy - 5, 10, 10, 5, 0xFF000000);
        vRoundRect(ctx, cx - 3, cy - 3, 6, 6, 3, 0xFFFFFFFF);
    }

    private void drawHueBar(DrawContext ctx, int x, int y, int w, int h) {
        int x1 = sx(x);
        int y1 = sy(y);
        int x2 = sx(x + w);
        int y2 = sy(y + h);

        int segments = 6;
        int segW = (x2 - x1) / segments;
        for (int i = 0; i < segments; i++) {
            float h1 = i * 60f;
            float h2 = (i + 1) * 60f;
            int c1 = 0xFF000000 | (hsvToRgb(h1, 1f, 1f) & 0xFFFFFF);
            int c2 = 0xFF000000 | (hsvToRgb(h2, 1f, 1f) & 0xFFFFFF);
            int sx1 = x1 + i * segW;
            int sx2 = (i == segments - 1) ? x2 : x1 + (i + 1) * segW;
            ctx.fillGradient(sx1, y1, sx2, y2, c1, c2);
        }

        int hx = sx(x + (int)(this.hue / 360f * w));
        int hy1 = sy(y - 2);
        int hy2 = sy(y + h + 2);
        ctx.fill(hx - 2, hy1, hx + 2, hy2, 0xFF000000);
        ctx.fill(hx - 1, hy1 + 1, hx + 1, hy2 - 1, 0xFFFFFFFF);
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        double mx = (click.x() - offsetX) / uiScale;
        double my = (click.y() - offsetY) / uiScale;

        if (mx >= svX && mx <= svX + SV_SIZE && my >= svY && my <= svY + SV_SIZE) {
            sat = (float)Math.max(0, Math.min(1, (mx - svX) / SV_SIZE));
            val = 1f - (float)Math.max(0, Math.min(1, (my - svY) / SV_SIZE));
            draggingSV = true;
            apply();
            return true;
        }

        int hueY = svY + SV_SIZE + 8;
        if (mx >= svX && mx <= svX + SV_SIZE && my >= hueY && my <= hueY + HUE_H) {
            hue = (float)Math.max(0, Math.min(360, (mx - svX) / SV_SIZE * 360));
            draggingHue = true;
            apply();
            return true;
        }

        int rgbY = hueY + HUE_H + 10;
        int presetStart = rgbY + 18 + 16 + 28;
        int psize = 20;
        int gap = 4;
        for (int i = 0; i < PRESETS.length; i++) {
            int px = PAD + i * (psize + gap);
            if (mx >= px && mx <= px + psize && my >= presetStart && my <= presetStart + psize) {
                int col = PRESETS[i];
                float[] hsv = rgbToHsv(col);
                hue = hsv[0]; sat = hsv[1]; val = hsv[2];
                apply();
                return true;
            }
        }

        int closeX = PW - 20;
        int closeY = 10;
        if (mx >= closeX - 6 && mx <= closeX + 10 && my >= closeY - 4 && my <= closeY + 12) {
            close();
            return true;
        }

        return super.mouseClicked(click, doubled);
    }

    @Override
    public boolean mouseDragged(Click click, double dx, double dy) {
        double mx = (click.x() - offsetX) / uiScale;
        double my = (click.y() - offsetY) / uiScale;

        if (draggingSV) {
            sat = (float)Math.max(0, Math.min(1, (mx - svX) / SV_SIZE));
            val = 1f - (float)Math.max(0, Math.min(1, (my - svY) / SV_SIZE));
            apply();
            return true;
        }
        if (draggingHue) {
            hue = (float)Math.max(0, Math.min(360, (mx - svX) / SV_SIZE * 360));
            apply();
            return true;
        }
        return super.mouseDragged(click, dx, dy);
    }

    @Override
    public boolean mouseReleased(Click click) {
        draggingSV = false;
        draggingHue = false;
        return super.mouseReleased(click);
    }

    @Override
    public void close() {
        MinecraftClient.getInstance().setScreen(parent);
    }

    @Override
    public boolean shouldPause() { return false; }

    private void apply() {
        int rgb = hsvToRgb(hue, sat, val);
        setting.setColor(rgb);
    }

    public static int hsvToRgb(float h, float s, float v) {
        h = ((h % 360) + 360) % 360;
        float c = v * s;
        float x = c * (1 - Math.abs(((h / 60f) % 2) - 1));
        float m = v - c;
        float r, g, b;
        if (h < 60)       { r = c; g = x; b = 0; }
        else if (h < 120) { r = x; g = c; b = 0; }
        else if (h < 180) { r = 0; g = c; b = x; }
        else if (h < 240) { r = 0; g = x; b = c; }
        else if (h < 300) { r = x; g = 0; b = c; }
        else              { r = c; g = 0; b = x; }
        int ri = (int)((r + m) * 255);
        int gi = (int)((g + m) * 255);
        int bi = (int)((b + m) * 255);
        return 0xFF000000 | (ri << 16) | (gi << 8) | bi;
    }

    public static float[] rgbToHsv(int rgb) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
        float rf = r / 255f, gf = g / 255f, bf = b / 255f;
        float max = Math.max(rf, Math.max(gf, bf));
        float min = Math.min(rf, Math.min(gf, bf));
        float d = max - min;
        float h;
        if (d == 0) h = 0;
        else if (max == rf) h = 60 * (((gf - bf) / d) % 6);
        else if (max == gf) h = 60 * (((bf - rf) / d) + 2);
        else                 h = 60 * (((rf - gf) / d) + 4);
        if (h < 0) h += 360;
        float s = max == 0 ? 0 : d / max;
        float v = max;
        return new float[]{h, s, v};
    }
}