package a;

final class eps {
   final int ept;
   final int epu;
   final int epv;
   final int epw;

   eps(int kh, int kw, int sh, int sw) {
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
