package a;

import net.minecraft.util.math.BlockPos;

final class nwq {
   final rzv nwr;
   final BlockPos nws;
   final int nwt;
   final double nwu;

   nwq(rzv timer, BlockPos chest, int tier, double score) {
      this.nwr = timer;
      this.nws = chest;
      this.nwt = tier;
      this.nwu = score;
   }

   public rzv timer() {
      return this.nwr;
   }

   public BlockPos chest() {
      return this.nws;
   }

   public int tier() {
      return this.nwt;
   }

   public double score() {
      return this.nwu;
   }
}
