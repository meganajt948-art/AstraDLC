package a;

import java.util.Arrays;

public final class trp {
   public float[] x = new float[72704];
   public int[] move = new int[1024];
   public boolean[] jump = new boolean[1024];
   public boolean[] sprint = new boolean[1024];
   public float[] weight = new float[1024];
   public int[] block = new int[1024];
   public int n;

   public void add(double[] var1, int var2, boolean var3, boolean var4, double var5, int var7) {
      if (this.n == this.move.length) {
         int var8 = this.n * 2;
         this.x = Arrays.copyOf(this.x, var8 * 71);
         this.move = Arrays.copyOf(this.move, var8);
         this.jump = Arrays.copyOf(this.jump, var8);
         this.sprint = Arrays.copyOf(this.sprint, var8);
         this.weight = Arrays.copyOf(this.weight, var8);
         this.block = Arrays.copyOf(this.block, var8);
      }

      for (int var9 = 0; var9 < 71; var9++) {
         this.x[this.n * 71 + var9] = (float)var1[var9];
      }

      this.move[this.n] = var2;
      this.jump[this.n] = var3;
      this.sprint[this.n] = var4;
      this.weight[this.n] = (float)var5;
      this.block[this.n] = var7;
      this.n++;
   }
}
