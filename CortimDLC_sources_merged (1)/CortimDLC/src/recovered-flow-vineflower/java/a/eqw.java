package a;

record eqw(int[] px, int w, int h) {
   private final int[] eqx;
   private final int eqy;
   private final int eqz;

   eqw(int[] px, int w, int h) {
      this.eqx = px;
      this.eqy = w;
      this.eqz = h;
   }

   public int[] px() {
      return this.eqx;
   }

   public int w() {
      return this.eqy;
   }

   public int h() {
      return this.eqz;
   }
}
