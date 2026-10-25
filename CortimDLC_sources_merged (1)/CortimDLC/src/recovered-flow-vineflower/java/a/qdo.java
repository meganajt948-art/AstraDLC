package a;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;

final class qdo {
   private final int qdp;
   private final LongOpenHashSet qdq;

   private qdo(int tick, LongOpenHashSet blocks) {
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
