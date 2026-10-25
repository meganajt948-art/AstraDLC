package a;

import net.minecraft.util.math.BlockPos;

record nwq(rzv timer, BlockPos chest, int tier, double score) {
   private final rzv nwr;
   private final BlockPos nws;
   private final int nwt;
   private final double nwu;

   private nwq(rzv timer, BlockPos chest, int tier, double score) {
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
