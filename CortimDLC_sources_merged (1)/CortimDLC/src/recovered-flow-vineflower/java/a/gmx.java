package a;

final class gmx {
   final String gmy;
   final int gmz;
   final int gna;
   final boolean gnb;
   final double gnc;
   final boolean gnd;

   gmx(String name, int ticks, int orbit, boolean jump, double fight, boolean move) {
      this.gmy = name;
      this.gmz = ticks;
      this.gna = orbit;
      this.gnb = jump;
      this.gnc = fight;
      this.gnd = move;
   }

   public String name() {
      return this.gmy;
   }

   public int ticks() {
      return this.gmz;
   }

   public int orbit() {
      return this.gna;
   }

   public boolean jump() {
      return this.gnb;
   }

   public double fight() {
      return this.gnc;
   }

   public boolean move() {
      return this.gnd;
   }
}
