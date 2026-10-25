package a;

final class fpf {
   final long fpg;
   final boolean fph;
   final float fpi;
   final double fpj;
   final boolean fpk;
   final boolean fpl;

   fpf(long nanos, boolean crit, float charge, double fall, boolean ground, boolean sprint) {
      this.fpg = nanos;
      this.fph = crit;
      this.fpi = charge;
      this.fpj = fall;
      this.fpk = ground;
      this.fpl = sprint;
   }

   public long nanos() {
      return this.fpg;
   }

   public boolean crit() {
      return this.fph;
   }

   public float charge() {
      return this.fpi;
   }

   public double fall() {
      return this.fpj;
   }

   public boolean ground() {
      return this.fpk;
   }

   public boolean sprint() {
      return this.fpl;
   }
}
