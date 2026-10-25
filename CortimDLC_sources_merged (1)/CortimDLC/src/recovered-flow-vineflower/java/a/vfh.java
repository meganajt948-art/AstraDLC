package a;

import java.awt.Rectangle;
import java.awt.font.GlyphVector;

final class vfh {
   final int cp;
   final GlyphVector vector;
   final Rectangle bounds;
   final float advance;
   int x;
   int y;

   vfh(int var1, GlyphVector var2, Rectangle var3, float var4) {
      this.cp = var1;
      this.vector = var2;
      this.bounds = var3;
      this.advance = var4;
   }
}
