package a;

final class tmn {
   final sze tmo;
   final int tmp;
   final int tmq;

   tmn(sze seg, int from, int to) {
      this.tmo = seg;
      this.tmp = from;
      this.tmq = to;
   }

   public sze seg() {
      return this.tmo;
   }

   public int from() {
      return this.tmp;
   }

   public int to() {
      return this.tmq;
   }
}
