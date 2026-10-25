package a;

import net.minecraft.util.math.BlockPos;

public record qmx(BlockPos target, int[] path, float cost) {
   private final BlockPos qmy;
   private final int[] qmz;
   private final float qna;

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
