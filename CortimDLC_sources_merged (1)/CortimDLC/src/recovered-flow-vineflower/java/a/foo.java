package a;

final class foo {
   final long fop;
   final float foq;

   foo(long nanos, float amount) {
      this.fop = nanos;
      this.foq = amount;
   }

   public long nanos() {
      return this.fop;
   }

   public float amount() {
      return this.foq;
   }
}
