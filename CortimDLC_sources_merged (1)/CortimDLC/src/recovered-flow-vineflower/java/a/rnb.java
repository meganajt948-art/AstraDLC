package a;

record rnb(double speed, double gravity, double drag, double waterDrag, float roll, boolean arrow) {
   private final double rnc;
   private final double rnd;
   private final double rne;
   private final double rnf;
   private final float rng;
   private final boolean rnh;

   private rnb(double speed, double gravity, double drag, double waterDrag, float roll, boolean arrow) {
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
