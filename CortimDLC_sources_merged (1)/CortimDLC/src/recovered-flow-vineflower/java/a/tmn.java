package a;

final class tmn {
   private final sze tmo;
   private final int tmp;
   private final int tmq;

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
