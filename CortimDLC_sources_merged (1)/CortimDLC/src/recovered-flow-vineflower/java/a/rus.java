package a;

final class rus {
   final float vis;
   final float hit;
   final float size;
   final int c1;
   final int c2;
   final int hitColor;

   rus(ruv var1, float var2, float var3) {
      this.vis = var2;
      this.hit = var3;
      this.size = (float)var1.size.get() * (0.7F + 0.3F * var2);
      this.hitColor = var1.hitColor.color();
      this.c1 = ujt.lerp(var1.color.color(), this.hitColor, var3);
      this.c2 = ujt.lerp(var1.color.color2(), var1.hitColor.color2(), var3);
   }

   int at(float var1) {
      return ujt.lerp(this.c1, this.c2, var1);
   }

   int core(float var1) {
      return ujt.lerp(this.c1, -1, var1);
   }
}
