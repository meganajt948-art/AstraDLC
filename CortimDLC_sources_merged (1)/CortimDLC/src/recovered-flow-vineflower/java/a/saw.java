package a;

record saw(double x, double y, double z, float fx, float fz, float side, long at, float strength) {
   private final double sax;
   private final double say;
   private final double saz;
   private final float sba;
   private final float sbb;
   private final float sbc;
   private final long sbd;
   private final float sbe;

   private saw(double x, double y, double z, float fx, float fz, float side, long at, float strength) {
      this.sax = x;
      this.say = y;
      this.saz = z;
      this.sba = fx;
      this.sbb = fz;
      this.sbc = side;
      this.sbd = at;
      this.sbe = strength;
   }

   public double x() {
      return this.sax;
   }

   public double y() {
      return this.say;
   }

   public double z() {
      return this.saz;
   }

   public float fx() {
      return this.sba;
   }

   public float fz() {
      return this.sbb;
   }

   public float side() {
      return this.sbc;
   }

   public long at() {
      return this.sbd;
   }

   public float strength() {
      return this.sbe;
   }
}
