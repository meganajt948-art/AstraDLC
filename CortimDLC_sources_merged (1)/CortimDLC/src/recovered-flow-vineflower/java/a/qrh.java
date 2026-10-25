package a;

import net.minecraft.block.BlockState;

final class qrh {
   private final BlockState qri;
   private final int qrj;

   private qrh(BlockState was, int until) {
      this.qri = was;
      this.qrj = until;
   }

   public BlockState was() {
      return this.qri;
   }

   public int until() {
      return this.qrj;
   }
}
