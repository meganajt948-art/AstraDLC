package a;

import java.util.Arrays;

public final class tzv {
   public float[] x = new float[4096 * tzy.uam];
   public int[] move = new int[4096];
   public boolean[] jump = new boolean[4096];
   public boolean[] sprint = new boolean[4096];
   public int[] yaw = new int[4096];
   public int[] pitch = new int[4096];
   public float[] dyaw = new float[4096];
   public float[] dpitch = new float[4096];
   public int[] block = new int[4096];
   public int n;

   void add(double[] var1, int var2, boolean var3, boolean var4, double var5, double var7, int var9) {
      if (this.n == this.move.length) {
         int var10 = this.n * 2;
         this.x = Arrays.copyOf(this.x, var10 * tzy.uam);
         this.move = Arrays.copyOf(this.move, var10);
         this.jump = Arrays.copyOf(this.jump, var10);
         this.sprint = Arrays.copyOf(this.sprint, var10);
         this.yaw = Arrays.copyOf(this.yaw, var10);
         this.pitch = Arrays.copyOf(this.pitch, var10);
         this.dyaw = Arrays.copyOf(this.dyaw, var10);
         this.dpitch = Arrays.copyOf(this.dpitch, var10);
         this.block = Arrays.copyOf(this.block, var10);
      }

      for (int var11 = 0; var11 < tzy.uam; var11++) {
         this.x[this.n * tzy.uam + var11] = (float)var1[var11];
      }

      this.move[this.n] = var2;
      this.jump[this.n] = var3;
      this.sprint[this.n] = var4;
      this.yaw[this.n] = txv.bin(txv.YAW, var5);
      this.pitch[this.n] = txv.bin(txv.PITCH, var7);
      this.dyaw[this.n] = (float)var5;
      this.dpitch[this.n] = (float)var7;
      this.block[this.n] = var9;
      this.n++;
   }
}
