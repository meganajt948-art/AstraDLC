package a;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;

final class qdo {
   final int qdp;
   final LongOpenHashSet qdq;

   qdo(int tick, LongOpenHashSet blocks) {
      this.qdp = tick;
      this.qdq = blocks;
   }

   public int tick() {
      return this.qdp;
   }

   public LongOpenHashSet blocks() {
      return this.qdq;
   }
}
