package a;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.longs.LongArrayList;

final class qdt {
   final qda hit;
   final long key;
   final double own;
   final double ticks;
   double value;
   double time;
   final LongArrayList caught = new LongArrayList();
   final DoubleArrayList chance = new DoubleArrayList();

   qdt(qda var1, double var2, double var4) {
      this.hit = var1;
      this.key = var1.pos().asLong();
      this.own = var2;
      this.ticks = var4;
   }

   double rate() {
      return this.value / this.time;
   }

   double chanceOf(long var1) {
      for (int var3 = 0; var3 < this.caught.size(); var3++) {
         if (this.caught.getLong(var3) == var1) {
            return this.chance.getDouble(var3);
         }
      }

      return 0.0;
   }
}
