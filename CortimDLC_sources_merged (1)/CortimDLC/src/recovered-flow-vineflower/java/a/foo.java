package a;

final class foo {
   private final long fop;
   private final float foq;

   private foo(long nanos, float amount) {
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
