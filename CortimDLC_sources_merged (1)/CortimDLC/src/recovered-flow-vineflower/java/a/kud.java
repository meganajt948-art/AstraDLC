package a;

import net.minecraft.entity.Entity;

final class kud {
   final int tick;
   final Entity target;
   final double[] x;
   final double[] p;
   int labels;
   int mask;
   int censorFrom = Integer.MAX_VALUE;

   kud(int var1, Entity var2, double[] var3, double[] var4) {
      this.tick = var1;
      this.target = var2;
      this.x = var3;
      this.p = var4;
   }
}
