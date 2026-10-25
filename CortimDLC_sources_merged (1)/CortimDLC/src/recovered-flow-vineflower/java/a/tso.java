package a;

import java.util.Arrays;

public final class tso {
   public final tvc tape;
   public final int[] reach;
   public final int[] reachDia;
   public final double[] rate;
   public final double[] weight;

   tso(tvc var1) {
      this.tape = var1;
      int var2 = var1.ticks.size();
      this.reach = new int[var2];
      this.reachDia = new int[var2];
      this.rate = new double[var2];
      this.weight = new double[var2];
      Arrays.fill(this.weight, 1.0);
   }
}
