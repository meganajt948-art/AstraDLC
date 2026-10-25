package a;

import net.minecraft.block.Block;

final class qcu {
   final long qcv;
   final Block qcw;
   final int qcx;

   qcu(long pos, Block block, int tick) {
      this.qcv = pos;
      this.qcw = block;
      this.qcx = tick;
   }

   public long pos() {
      return this.qcv;
   }

   public Block block() {
      return this.qcw;
   }

   public int tick() {
      return this.qcx;
   }
}
