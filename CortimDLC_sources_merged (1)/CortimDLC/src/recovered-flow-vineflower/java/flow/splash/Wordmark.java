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
import java.util.List;
import java.util.Map;

public final class Wordmark {
   static final String FIRST = "Flow";
   static final String SECOND = "Client";
   private static final int[] FIRST_TOP = new int[]{255, 255, 255};
   private static final int[] FIRST_BOTTOM = new int[]{214, 234, 255};
   private static final int[] SECOND_TOP = new int[]{226, 242, 255};
   private static final int[] SECOND_BOTTOM = new int[]{140, 198, 255};
   private static final int[] WHITE = new int[]{255, 255, 255};
   private static final Map<String, Font> FACES = new HashMap<>();
   public final int px;
   public final Wordmark.Glyph[] glyphs;
   public final float width;
   public final float cap;
   public final int dotGlyph;
   public final float dotX;
   public final float dotY;
   public final float dotR;

   private Wordmark(int px, Wordmark.Glyph[] glyphs, float width, float cap, int dotGlyph, float dotX, float dotY, float dotR) {
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
      return build(em, pixelsPerUnit, false);
   }

   public static Wordmark build(float em, float pixelsPerUnit, boolean mono) {
      int px = Math.max(12, Math.round(em * pixelsPerUnit));
      float unit = px / em;
      Map<TextAttribute, Object> kerning = Map.of(TextAttribute.KERNING, TextAttribute.KERNING_ON);
      Font bold = face("/flow/font/Inter-Bold.ttf").deriveFont(kerning).deriveFont((float)px);
      Font light = face("/flow/font/Inter-Regular.ttf").deriveFont(kerning).deriveFont((float)px);
      FontRenderContext frc = new FontRenderContext(null, true, true);
      boolean dotless = !mono && light.canDisplay('ı');
      String second = dotless ? "Client".replace('i', 'ı') : "Client";
      GlyphVector a = bold.layoutGlyphVector(frc, "Flow".toCharArray(), 0, "Flow".length(), 0);
      GlyphVector b = light.layoutGlyphVector(frc, second.toCharArray(), 0, second.length(), 0);
      float advA = (float)a.getGlyphPosition(a.getNumGlyphs()).getX();
      float gap = px * 0.012F;
      float advB = (float)b.getGlyphPosition(b.getNumGlyphs()).getX();
      float capPx = (float)(-bold.createGlyphVector(frc, "H").getVisualBounds().getMinY());
      float sigma = px * 0.055F;
      List<Wordmark.Glyph> out = new ArrayList<>();
      int dotGlyph = -1;
      float dotX = 0.0F;
      float dotY = 0.0F;
      float dotR = 0.0F;

      for (int pass = 0; pass < 2; pass++) {
         GlyphVector gv = pass == 0 ? a : b;
         float offset = pass == 0 ? 0.0F : advA + gap;

         for (int i = 0; i < gv.getNumGlyphs(); i++) {
            Shape shape = gv.getGlyphOutline(i, offset, 0.0F);
            Rectangle2D bb = shape.getBounds2D();
            if (!bb.isEmpty()) {
               boolean isDot = pass == 1 && dotless && i < second.length() && second.charAt(i) == 305;
               out.add(raster(shape, bb, sigma, capPx, pass == 1, mono, unit, px));
               if (isDot) {
                  dotGlyph = out.size() - 1;
                  Rectangle2D iBox = light.createGlyphVector(frc, "i").getVisualBounds();
                  Rectangle2D stemBox = light.createGlyphVector(frc, "ı").getVisualBounds();
                  float top = (float)iBox.getMinY();
                  float stem = (float)stemBox.getMinY();
                  float d = (stem - top) * 0.55F;
                  dotX = (float)bb.getCenterX() / unit;
                  dotY = (top + d * 0.5F - d * 0.12F) / unit;
                  dotR = Math.max(d * 0.95F, px * 0.085F) / unit;
               }
            }
         }
      }

      return new Wordmark(px, out.toArray(new Wordmark.Glyph[0]), (advA + gap + advB) / unit, capPx / unit, dotGlyph, dotX, dotY, dotR);
   }

   private static Wordmark.Glyph raster(Shape shape, Rectangle2D bb, float sigma, float capPx, boolean second, boolean mono, float unit, int px) {
      int pad = (int)Math.ceil(sigma * 3.0F) + 2;
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

      for (int i = 0; i < alpha.length; i++) {
         alpha[i] = (pixels[i] >>> 24 & 0xFF) / 255.0F;
      }

      float[] blurred = gaussian(alpha, w, h, sigma);
      int[] top = mono ? WHITE : (second ? SECOND_TOP : FIRST_TOP);
      int[] bottom = mono ? WHITE : (second ? SECOND_BOTTOM : FIRST_BOTTOM);
      BufferedImage sharp = new BufferedImage(w, h, 2);
      BufferedImage soft = new BufferedImage(w, h, 2);
      int[] sharpPx = new int[w * h];
      int[] softPx = new int[w * h];

      for (int y = 0; y < h; y++) {
         float t = Math.max(0.0F, Math.min(1.0F, (y0 + y + capPx) / capPx));
         t = t * t * (3.0F - 2.0F * t);
         int rgb = Math.round(top[0] + (bottom[0] - top[0]) * t) << 16
            | Math.round(top[1] + (bottom[1] - top[1]) * t) << 8
            | Math.round(top[2] + (bottom[2] - top[2]) * t);

         for (int x = 0; x < w; x++) {
            int i = y * w + x;
            sharpPx[i] = Math.round(alpha[i] * 255.0F) << 24 | rgb;
            softPx[i] = Math.min(255, Math.round(blurred[i] * 255.0F * 1.15F)) << 24 | rgb;
         }
      }

      sharp.setRGB(0, 0, w, h, sharpPx, 0, w);
      soft.setRGB(0, 0, w, h, softPx, 0, w);
      uok sharpTex = uok.upload("wordmark " + px, sharp, false, true);
      uok softTex = uok.upload("wordmark soft " + px, soft, false, true);
      return new Wordmark.Glyph(
         sharpTex, softTex, x0 / unit, y0 / unit, w / unit, h / unit, (float)bb.getCenterX() / unit, (float)bb.getCenterY() / unit, second
      );
   }

   private static float[] gaussian(float[] src, int w, int h, float sigma) {
      int r = Math.max(1, (int)Math.ceil(sigma * 2.6F));
      float[] k = new float[r * 2 + 1];
      float sum = 0.0F;

      for (int i = -r; i <= r; i++) {
         float v = (float)Math.exp(-(i * i) / (2.0F * sigma * sigma));
         k[i + r] = v;
         sum += v;
      }

      for (int i = 0; i < k.length; i++) {
         k[i] /= sum;
      }

      float[] tmp = new float[w * h];

      for (int y = 0; y < h; y++) {
         int row = y * w;

         for (int x = 0; x < w; x++) {
            float acc = 0.0F;

            for (int i = -r; i <= r; i++) {
               int xx = x + i;
               if (xx >= 0 && xx < w) {
                  acc += src[row + xx] * k[i + r];
               }
            }

            tmp[row + x] = acc;
         }
      }

      float[] out = new float[w * h];

      for (int x = 0; x < w; x++) {
         for (int y = 0; y < h; y++) {
            float acc = 0.0F;

            for (int ix = -r; ix <= r; ix++) {
               int yy = y + ix;
               if (yy >= 0 && yy < h) {
                  acc += tmp[yy * w + x] * k[ix + r];
               }
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
      } else {
         try (InputStream in = Wordmark.class.getResourceAsStream(resource)) {
            if (in == null) {
               throw new IllegalStateException("missing " + resource);
            }

            f = Font.createFont(0, in);
         } catch (RuntimeException var7) {
            throw var7;
         } catch (Exception var8) {
            throw new IllegalStateException(var8);
         }

         FACES.put(resource, f);
         return f;
      }
   }

   public void close() {
      for (Wordmark.Glyph g : this.glyphs) {
         g.sharp.close();
         g.soft.close();
      }
   }

   public record Glyph(uok sharp, uok soft, float x, float y, float w, float h, float cx, float cy, boolean second) {
   }
}
