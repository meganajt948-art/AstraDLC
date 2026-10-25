package a;

final class hrk {
   final float hrl;
   final float hrm;
   final float hrn;
   final float hro;
   final Runnable hrp;
   final Runnable hrq;

   hrk(float x, float y, float w, float h, Runnable left, Runnable right) {
      this.hrl = x;
      this.hrm = y;
      this.hrn = w;
      this.hro = h;
      this.hrp = left;
      this.hrq = right;
   }

   public float x() {
      return this.hrl;
   }

   public float y() {
      return this.hrm;
   }

   public float w() {
      return this.hrn;
   }

   public float h() {
      return this.hro;
   }

   public Runnable left() {
      return this.hrp;
   }

   public Runnable right() {
      return this.hrq;
   }
}
