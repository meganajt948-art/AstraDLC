package a;

public record sti(double x, double z, float distance, boolean bolt) {
   private final double stj;
   private final double stk;
   private final float stl;
   private final boolean stm;

   public sti(double x, double z, float distance, boolean bolt) {
      this.stj = x;
      this.stk = z;
      this.stl = distance;
      this.stm = bolt;
   }

   public double x() {
      return this.stj;
   }

   public double z() {
      return this.stk;
   }

   public float distance() {
      return this.stl;
   }

   public boolean bolt() {
      return this.stm;
   }
}
