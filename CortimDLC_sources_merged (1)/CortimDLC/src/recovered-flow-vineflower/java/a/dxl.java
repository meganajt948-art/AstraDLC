package a;

final class dxl {
   private final dxy dxm;
   private final int dxn;

   private dxl(dxy tex, int tintIndex) {
      this.dxm = tex;
      this.dxn = tintIndex;
   }

   public dxy tex() {
      return this.dxm;
   }

   public int tintIndex() {
      return this.dxn;
   }
}
