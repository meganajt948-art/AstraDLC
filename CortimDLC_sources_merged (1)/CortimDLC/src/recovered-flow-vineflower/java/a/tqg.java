package a;

public final class tqg {
   public final int n;
   public final double[] f;
   public final int chosen;
   public final int nearest;
   public final int tick;
   public final tvc tape;
   public double weight = 1.0;

   public tqg(int var1, double[] var2, int var3, int var4) {
      this(var1, var2, var3, var4, null, -1);
   }

   public tqg(int var1, double[] var2, int var3, int var4, tvc var5, int var6) {
      this.n = var1;
      this.f = var2;
      this.chosen = var3;
      this.nearest = var4;
      this.tape = var5;
      this.tick = var6;
   }
}
