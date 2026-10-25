package a;

final class rnb {
   final double rnc;
   final double rnd;
   final double rne;
   final double rnf;
   final float rng;
   final boolean rnh;

   rnb(double speed, double gravity, double drag, double waterDrag, float roll, boolean arrow) {
      this.rnc = speed;
      this.rnd = gravity;
      this.rne = drag;
      this.rnf = waterDrag;
      this.rng = roll;
      this.rnh = arrow;
   }

   public double speed() {
      return this.rnc;
   }

   public double gravity() {
      return this.rnd;
   }

   public double drag() {
      return this.rne;
   }

   public double waterDrag() {
      return this.rnf;
   }

   public float roll() {
      return this.rng;
   }

   public boolean arrow() {
      return this.rnh;
   }
}
