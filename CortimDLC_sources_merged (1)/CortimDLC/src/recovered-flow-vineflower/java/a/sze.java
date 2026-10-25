package a;

public final class sze {
   public final int m;
   public final double[] st;
   public final int[] hits;
   public final boolean mirrored;
   public final double unit;

   sze(int var1, double[] var2, int[] var3, boolean var4, double var5) {
      this.m = var1;
      this.st = var2;
      this.hits = var3;
      this.mirrored = var4;
      this.unit = var5;
   }

   public double get(int var1, int var2) {
      return this.st[var1 * 32 + var2];
   }

   public sze mirror() {
      double[] var1 = new double[this.st.length];
      double[] var2 = new double[32];
      double[] var3 = new double[32];

      for (int var4 = 0; var4 <= this.m; var4++) {
         System.arraycopy(this.st, var4 * 32, var2, 0, 32);
         tbf.mirror(var2, var3);
         System.arraycopy(var3, 0, var1, var4 * 32, 32);
      }

      return new sze(this.m, var1, this.hits, true, this.unit);
   }
}
