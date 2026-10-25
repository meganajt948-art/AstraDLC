package a;

import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Direction;

final class rmy {
   final double[] pts = new double[726];
   int n;
   Type hit = Type.field_1333;
   double hx;
   double hy;
   double hz;
   Direction face = Direction.field_11036;
   Entity entity;
   int ticks;

   private rmy() {
   }

   void add(double var1, double var3, double var5) {
      this.pts[this.n * 3] = var1;
      this.pts[this.n * 3 + 1] = var3;
      this.pts[this.n * 3 + 2] = var5;
      this.n++;
   }
}
