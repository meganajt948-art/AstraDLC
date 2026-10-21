package dev.dj.cortim.gui;

import net.minecraft.client.gui.DrawContext;

public class ColorPicker {

    public float hue = 0f;
    public float sat = 1f;
    public float val = 1f;

    public int x, y, w, h;
    public int hueBarH = 10;
    public boolean compact = false;

    public ColorPicker() {}

    public void syncFromRgb(int r, int g, int b) {
        float[] hsv = rgbToHsv(r, g, b);
        this.hue = hsv[0];
        this.sat = hsv[1];
        this.val = hsv[2];
    }

    public int currentRgb() {
        return hsvToRgb(hue, sat, val);
    }

    public void render(DrawContext ctx, int mouseX, int mouseY) {
        int svW = w;
        int svH = h - hueBarH - 4;
        int svY = y;

        int steps = compact ? 20 : 40;
        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < steps; j++) {
                float s = i / (float)(steps - 1);
                float v = 1f - j / (float)(steps - 1);
                int col = hsvToRgb(hue, s, v);
                int px = x + i * svW / steps;
                int py = svY + j * svH / steps;
                int pw = (i + 1) * svW / steps - px + 1;
                int ph = (j + 1) * svH / steps - py + 1;
                ctx.fill(px, py, px + pw, py + ph, col);
            }
        }

        int cR = compact ? 3 : 5;
        int cx = x + (int)(sat * svW);
        int cy = svY + (int)((1f - val) * svH);
        drawCircle(ctx, cx, cy, cR, 0xFFFFFFFF);

        int hueY = y + h - hueBarH;
        int hueSteps = compact ? 40 : 90;
        for (int i = 0; i < hueSteps; i++) {
            float h1 = i * 360f / hueSteps;
            int col = hsvToRgb(h1, 1f, 1f);
            int px = x + i * w / hueSteps;
            int pw = (i + 1) * w / hueSteps - px + 1;
            ctx.fill(px, hueY, px + pw, hueY + hueBarH, col);
        }

        int hx = x + (int)(hue / 360f * w);
        drawCircle(ctx, hx, hueY + hueBarH / 2, cR, 0xFFFFFFFF);
    }

    public boolean mouseClicked(double mx, double my, int button) {
        int svH = h - hueBarH - 4;
        if (mx >= x && mx <= x + w && my >= y && my <= y + svH) {
            sat = (float)Math.max(0, Math.min(1, (mx - x) / w));
            val = 1f - (float)Math.max(0, Math.min(1, (my - y) / svH));
            return true;
        }
        int hueY = y + h - hueBarH;
        if (mx >= x && mx <= x + w && my >= hueY && my <= hueY + hueBarH) {
            hue = (float)Math.max(0, Math.min(360, (mx - x) / w * 360));
            return true;
        }
        return false;
    }

    public void mouseDragged(double mx, double my) {
        int svH = h - hueBarH - 4;
        int hueY = y + h - hueBarH;
        if (my >= y && my <= y + svH) {
            sat = (float)Math.max(0, Math.min(1, (mx - x) / w));
            val = 1f - (float)Math.max(0, Math.min(1, (my - y) / svH));
        } else if (my >= hueY && my <= hueY + hueBarH) {
            hue = (float)Math.max(0, Math.min(360, (mx - x) / w * 360));
        }
    }

    private static void drawCircle(DrawContext ctx, int cx, int cy, int r, int color) {
        int segments = 16;
        for (int i = 0; i < segments; i++) {
            double a1 = i * 2 * Math.PI / segments;
            double a2 = (i + 1) * 2 * Math.PI / segments;
            int x1 = cx + (int)(Math.cos(a1) * r);
            int y1 = cy + (int)(Math.sin(a1) * r);
            int x2 = cx + (int)(Math.cos(a2) * r);
            int y2 = cy + (int)(Math.sin(a2) * r);
            drawLine(ctx, x1, y1, x2, y2, color);
        }
    }

    private static void drawLine(DrawContext ctx, int x1, int y1, int x2, int y2, int color) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        while (true) {
            ctx.fill(x1, y1, x1 + 1, y1 + 1, color);
            if (x1 == x2 && y1 == y2) break;
            int e2 = err * 2;
            if (e2 > -dy) { err -= dy; x1 += sx; }
            if (e2 < dx) { err += dx; y1 += sy; }
        }
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

    public static float[] rgbToHsv(int r, int g, int b) {
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