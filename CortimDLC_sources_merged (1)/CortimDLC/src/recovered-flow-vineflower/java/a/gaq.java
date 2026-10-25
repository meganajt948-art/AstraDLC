package a;

final class gaq {
   final String gar;
   final double gas;
   final double gat;
   final int gau;

   gaq(String phase, double height, double offset, int sweep) {
      this.gar = phase;
      this.gas = height;
      this.gat = offset;
      this.gau = sweep;
   }

   public String phase() {
      return this.gar;
   }

   public double height() {
      return this.gas;
   }

   public double offset() {
      return this.gat;
   }

   public int sweep() {
      return this.gau;
   }
}
