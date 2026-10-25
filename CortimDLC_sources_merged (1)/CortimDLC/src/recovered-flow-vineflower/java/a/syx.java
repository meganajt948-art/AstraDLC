package a;

final class syx {
   final int syy;
   final int syz;
   final double sza;
   final double szb;

   syx(int tick, int id, double u, double v) {
      this.syy = tick;
      this.syz = id;
      this.sza = u;
      this.szb = v;
   }

   public int tick() {
      return this.syy;
   }

   public int id() {
      return this.syz;
   }

   public double u() {
      return this.sza;
   }

   public double v() {
      return this.szb;
   }
}
