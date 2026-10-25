/*
 * Decompiled with CFR 0.152.
 */
package flow.splash;

import a.uok;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextAttribute;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Wordmark {
    static final String FIRST = "Flow";
    static final String SECOND = "Client";
    private static final int[] FIRST_TOP = new int[]{255, 255, 255};
    private static final int[] FIRST_BOTTOM = new int[]{214, 234, 255};
    private static final int[] SECOND_TOP = new int[]{226, 242, 255};
    private static final int[] SECOND_BOTTOM = new int[]{140, 198, 255};
    private static final int[] WHITE = new int[]{255, 255, 255};
    private static final Map<String, Font> FACES = new HashMap<String, Font>();
    public final int px;
    public final Glyph[] glyphs;
    public final float width;
    public final float cap;
    public final int dotGlyph;
    public final float dotX;
    public final float dotY;
    public final float dotR;

    private Wordmark(int px, Glyph[] glyphs, float width, float cap, int dotGlyph, float dotX, float dotY, float dotR) {
        this.px = px;
        this.glyphs = glyphs;
        this.width = width;
        this.cap = cap;
        this.dotGlyph = dotGlyph;
        this.dotX = dotX;
        this.dotY = dotY;
        this.dotR = dotR;
    }

    public static Wordmark build(float em, float pixelsPerUnit) {
        return Wordmark.build(em, pixelsPerUnit, false);
    }

    public static Wordmark build(float em, float pixelsPerUnit, boolean mono) {
        int px = Math.max(12, Math.round(em * pixelsPerUnit));
        float unit = (float)px / em;
        Map<TextAttribute, Integer> kerning = Map.of(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        Font bold = Wordmark.face("/flow/font/Inter-Bold.ttf").deriveFont(kerning).deriveFont((float)px);
        Font light = Wordmark.face("/flow/font/Inter-Regular.ttf").deriveFont(kerning).deriveFont((float)px);
        FontRenderContext frc = new FontRenderContext(null, true, true);
        boolean dotless = !mono && light.canDisplay('\u0131');
        String second = dotless ? SECOND.replace('i', '\u0131') : SECOND;
        GlyphVector a2 = bold.layoutGlyphVector(frc, FIRST.toCharArray(), 0, FIRST.length(), 0);
        GlyphVector b = light.layoutGlyphVector(frc, second.toCharArray(), 0, second.length(), 0);
        float advA = (float)a2.getGlyphPosition(a2.getNumGlyphs()).getX();
        float gap = (float)px * 0.012f;
        float advB = (float)b.getGlyphPosition(b.getNumGlyphs()).getX();
        float capPx = (float)(-bold.createGlyphVector(frc, "H").getVisualBounds().getMinY());
        float sigma = (float)px * 0.055f;
        ArrayList<Glyph> out = new ArrayList<Glyph>();
        int dotGlyph = -1;
        float dotX = 0.0f;
        float dotY = 0.0f;
        float dotR = 0.0f;
        for (int pass = 0; pass < 2; ++pass) {
            GlyphVector gv = pass == 0 ? a2 : b;
            float offset = pass == 0 ? 0.0f : advA + gap;
            for (int i = 0; i < gv.getNumGlyphs(); ++i) {
                Shape shape = gv.getGlyphOutline(i, offset, 0.0f);
                Rectangle2D bb = shape.getBounds2D();
                if (bb.isEmpty()) continue;
                boolean isDot = pass == 1 && dotless && i < second.length() && second.charAt(i) == '\u0131';
                out.add(Wordmark.raster(shape, bb, sigma, capPx, pass == 1, mono, unit, px));
                if (!isDot) continue;
                dotGlyph = out.size() - 1;
                Rectangle2D iBox = light.createGlyphVector(frc, "i").getVisualBounds();
                Rectangle2D stemBox = light.createGlyphVector(frc, "\u0131").getVisualBounds();
                float top = (float)iBox.getMinY();
                float stem = (float)stemBox.getMinY();
                float d = (stem - top) * 0.55f;
                dotX = (float)bb.getCenterX() / unit;
                dotY = (top + d * 0.5f - d * 0.12f) / unit;
                dotR = Math.max(d * 0.95f, (float)px * 0.085f) / unit;
            }
        }
        return new Wordmark(px, out.toArray(new Glyph[0]), (advA + gap + advB) / unit, capPx / unit, dotGlyph, dotX, dotY, dotR);
    }

    private static Glyph raster(Shape shape, Rectangle2D bb, float sigma, float capPx, boolean second, boolean mono, float unit, int px) {
        int[] top;
        int pad = (int)Math.ceil(sigma * 3.0f) + 2;
        int x0 = (int)Math.floor(bb.getMinX()) - pad;
        int y0 = (int)Math.floor(bb.getMinY()) - pad;
        int w = (int)Math.ceil(bb.getMaxX()) - (int)Math.floor(bb.getMinX()) + pad * 2;
        int h = (int)Math.ceil(bb.getMaxY()) - (int)Math.floor(bb.getMinY()) + pad * 2;
        BufferedImage mask = new BufferedImage(w, h, 2);
        Graphics2D g = mask.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.translate(-x0, -y0);
        g.setColor(Color.WHITE);
        g.fill(shape);
        g.dispose();
        int[] pixels = mask.getRGB(0, 0, w, h, null, 0, w);
        float[] alpha = new float[w * h];
        for (int i = 0; i < alpha.length; ++i) {
            alpha[i] = (float)(pixels[i] >>> 24 & 0xFF) / 255.0f;
        }
        float[] blurred = Wordmark.gaussian(alpha, w, h, sigma);
        int[] nArray = mono ? WHITE : (top = second ? SECOND_TOP : FIRST_TOP);
        int[] bottom = mono ? WHITE : (second ? SECOND_BOTTOM : FIRST_BOTTOM);
        BufferedImage sharp = new BufferedImage(w, h, 2);
        BufferedImage soft = new BufferedImage(w, h, 2);
        int[] sharpPx = new int[w * h];
        int[] softPx = new int[w * h];
        for (int y = 0; y < h; ++y) {
            float t = Math.max(0.0f, Math.min(1.0f, ((float)(y0 + y) + capPx) / capPx));
            t = t * t * (3.0f - 2.0f * t);
            int rgb = Math.round((float)top[0] + (float)(bottom[0] - top[0]) * t) << 16 | Math.round((float)top[1] + (float)(bottom[1] - top[1]) * t) << 8 | Math.round((float)top[2] + (float)(bottom[2] - top[2]) * t);
            for (int x = 0; x < w; ++x) {
                int i = y * w + x;
                sharpPx[i] = Math.round(alpha[i] * 255.0f) << 24 | rgb;
                softPx[i] = Math.min(255, Math.round(blurred[i] * 255.0f * 1.15f)) << 24 | rgb;
            }
        }
        sharp.setRGB(0, 0, w, h, sharpPx, 0, w);
        soft.setRGB(0, 0, w, h, softPx, 0, w);
        uok sharpTex = uok.upload("wordmark " + px, sharp, false, true);
        uok softTex = uok.upload("wordmark soft " + px, soft, false, true);
        return new Glyph(sharpTex, softTex, (float)x0 / unit, (float)y0 / unit, (float)w / unit, (float)h / unit, (float)bb.getCenterX() / unit, (float)bb.getCenterY() / unit, second);
    }

    private static float[] gaussian(float[] src, int w, int h, float sigma) {
        int i;
        float acc;
        int i2;
        int r = Math.max(1, (int)Math.ceil(sigma * 2.6f));
        float[] k = new float[r * 2 + 1];
        float sum = 0.0f;
        for (i2 = -r; i2 <= r; ++i2) {
            float v;
            k[i2 + r] = v = (float)Math.exp((float)(-(i2 * i2)) / (2.0f * sigma * sigma));
            sum += v;
        }
        i2 = 0;
        while (i2 < k.length) {
            int n = i2++;
            k[n] = k[n] / sum;
        }
        float[] tmp = new float[w * h];
        for (int y = 0; y < h; ++y) {
            int row = y * w;
            for (int x = 0; x < w; ++x) {
                acc = 0.0f;
                for (i = -r; i <= r; ++i) {
                    int xx = x + i;
                    if (xx < 0 || xx >= w) continue;
                    acc += src[row + xx] * k[i + r];
                }
                tmp[row + x] = acc;
            }
        }
        float[] out = new float[w * h];
        for (int x = 0; x < w; ++x) {
            for (int y = 0; y < h; ++y) {
                acc = 0.0f;
                for (i = -r; i <= r; ++i) {
                    int yy = y + i;
                    if (yy < 0 || yy >= h) continue;
                    acc += tmp[yy * w + x] * k[i + r];
                }
                out[y * w + x] = acc;
            }
        }
        return out;
    }

    private static synchronized Font face(String resource) {
        Font f = FACES.get(resource);
        if (f != null) {
            return f;
        }
        try (InputStream in = Wordmark.class.getResourceAsStream(resource);){
            if (in == null) {
                throw new IllegalStateException("missing " + resource);
            }
            f = Font.createFont(0, in);
        }
        catch (RuntimeException e) {
            throw e;
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
        FACES.put(resource, f);
        return f;
    }

    public void close() {
        for (Glyph g : this.glyphs) {
            g.sharp.close();
            g.soft.close();
        }
    }

    public record Glyph(uok sharp, uok soft, float x, float y, float w, float h, float cx, float cy, boolean second) {
    }
}

