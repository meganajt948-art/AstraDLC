package a;

public final class syk {
   public final double[] x = new double[6];
   public final double[] y = new double[6];
   public double simX;
   public double simY;
   public final double[] overA = new double[2];
   public final double[] overB = new double[2];

   public double total() {
      return (this.simX + this.simY) * 0.5;
   }

   void add(syk var1, double var2) {
      for (int var4 = 0; var4 < 6; var4++) {
         this.x[var4] = this.x[var4] + var1.x[var4] * var2;
         this.y[var4] = this.y[var4] + var1.y[var4] * var2;
      }

      this.simX = this.simX + var1.simX * var2;
      this.simY = this.simY + var1.simY * var2;

      for (int var5 = 0; var5 < 2; var5++) {
         this.overA[var5] = this.overA[var5] + var1.overA[var5] * var2;
         this.overB[var5] = this.overB[var5] + var1.overB[var5] * var2;
      }
   }
}
