package a;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

final class vit {
   private vit() {
   }

   static void paint(Graphics2D var0, vhz var1, int var2, int var3, float var4, float var5, float var6) {
      var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var0.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      var0.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
      var0.setColor(Color.WHITE);
      float var7 = var4 / 24.0F;
      float var8 = Math.max(var5, var6 / var7);
      AffineTransform var9 = var0.getTransform();
      var0.translate(var2, var3);
      var0.scale(var7, var7);
      var0.setStroke(new BasicStroke(var8, 1, 1));

      for (Shape var11 : var1.strokes()) {
         var0.draw(var11);
      }

      for (Shape var13 : var1.fills()) {
         var0.fill(var13);
      }

      var0.setTransform(var9);
   }
}
