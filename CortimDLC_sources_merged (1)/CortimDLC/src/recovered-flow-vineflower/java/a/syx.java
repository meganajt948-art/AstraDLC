package a;

final class syx {
   private final int syy;
   private final int syz;
   private final double sza;
   private final double szb;

   private syx(int tick, int id, double u, double v) {
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
