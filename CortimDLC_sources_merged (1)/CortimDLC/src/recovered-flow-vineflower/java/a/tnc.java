package a;

record tnc(sze seg, int k0, int limit) {
   private final sze tnd;
   private final int tne;
   private final int tnf;

   private tnc(sze seg, int k0, int limit) {
      this.tnd = seg;
      this.tne = k0;
      this.tnf = limit;
   }

   public sze seg() {
      return this.tnd;
   }

   public int k0() {
      return this.tne;
   }

   public int limit() {
      return this.tnf;
   }
}
