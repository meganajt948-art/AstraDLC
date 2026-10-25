package a;

import net.minecraft.block.BlockState;

final class qrh {
   final BlockState qri;
   final int qrj;

   qrh(BlockState was, int until) {
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
