package a;

record eps(int kh, int kw, int sh, int sw) {
   private final int ept;
   private final int epu;
   private final int epv;
   private final int epw;

   private eps(int kh, int kw, int sh, int sw) {
      this.ept = kh;
      this.epu = kw;
      this.epv = sh;
      this.epw = sw;
   }

   public int kh() {
      return this.ept;
   }

   public int kw() {
      return this.epu;
   }

   public int sh() {
      return this.epv;
   }

   public int sw() {
      return this.epw;
   }
}
