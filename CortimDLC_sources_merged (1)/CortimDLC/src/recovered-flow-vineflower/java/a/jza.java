package a;

public final class jza {
   final uok jzb;
   final uok jzc;
   final boolean jzd;
   final int jze;

   public jza(uok var1, uok var2) {
      this(var1, var2, false, -1);
   }

   public jza(uok sharp, uok blur, boolean video, int fill) {
      this.jzb = sharp;
      this.jzc = blur;
      this.jzd = video;
      this.jze = fill;
   }

   public float aspect() {
      return (float)this.jzb.width / this.jzb.height;
   }

   public boolean logo() {
      return this.jze >= 0;
   }

   public uok sharp() {
      return this.jzb;
   }

   public uok blur() {
      return this.jzc;
   }

   public boolean video() {
      return this.jzd;
   }

   public int fill() {
      return this.jze;
   }
}
