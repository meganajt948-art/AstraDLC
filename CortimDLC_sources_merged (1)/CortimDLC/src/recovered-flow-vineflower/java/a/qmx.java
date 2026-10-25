package a;

import net.minecraft.util.math.BlockPos;

public final class qmx {
   final BlockPos qmy;
   final int[] qmz;
   final float qna;

   public qmx(BlockPos target, int[] path, float cost) {
      this.qmy = target;
      this.qmz = path;
      this.qna = cost;
   }

   public BlockPos target() {
      return this.qmy;
   }

   public int[] path() {
      return this.qmz;
   }

   public float cost() {
      return this.qna;
   }
}
