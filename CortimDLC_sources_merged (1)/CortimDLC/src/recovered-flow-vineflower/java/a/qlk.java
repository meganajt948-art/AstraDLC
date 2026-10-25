package a;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;

final class qlk {
   final long pos;
   final int tick;
   final int faceAxis;
   final double[] look;
   final Long2IntOpenHashMap blocks = new Long2IntOpenHashMap();

   qlk(long var1, int var3, int var4, double[] var5) {
      this.pos = var1;
      this.tick = var3;
      this.faceAxis = var4;
      this.look = var5;
   }
}
