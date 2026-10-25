package a;

record sfz(double x, double y, double z, float fx, float fz, float side, long at, float strength) {
   private final double sga;
   private final double sgb;
   private final double sgc;
   private final float sgd;
   private final float sge;
   private final float sgf;
   private final long sgg;
   private final float sgh;

   private sfz(double x, double y, double z, float fx, float fz, float side, long at, float strength) {
      this.sga = x;
      this.sgb = y;
      this.sgc = z;
      this.sgd = fx;
      this.sge = fz;
      this.sgf = side;
      this.sgg = at;
      this.sgh = strength;
   }

   public double x() {
      return this.sga;
   }

   public double y() {
      return this.sgb;
   }

   public double z() {
      return this.sgc;
   }

   public float fx() {
      return this.sgd;
   }

   public float fz() {
      return this.sge;
   }

   public float side() {
      return this.sgf;
   }

   public long at() {
      return this.sgg;
   }

   public float strength() {
      return this.sgh;
   }
}
