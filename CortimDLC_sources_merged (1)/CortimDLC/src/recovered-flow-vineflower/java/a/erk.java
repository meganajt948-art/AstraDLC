package a;

record erk(String code, double strength) {
   private final String erl;
   private final double erm;

   erk(String code, double strength) {
      this.erl = code;
      this.erm = strength;
   }

   public String code() {
      return this.erl;
   }

   public double strength() {
      return this.erm;
   }
}
