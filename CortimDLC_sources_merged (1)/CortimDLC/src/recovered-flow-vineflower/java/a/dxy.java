package a;

import net.minecraft.util.math.MathHelper;

final class dxy {
   final int dxz;
   final int dya;
   final int[] dyb;

   dxy(int w, int h, int[] px) {
      this.dxz = w;
      this.dya = h;
      this.dyb = px;
   }

   int sample(double var1, double var3) {
      int var5 = MathHelper.clamp((int)(var1 * this.dxz), 0, this.dxz - 1);
      int var6 = MathHelper.clamp((int)(var3 * this.dya), 0, this.dya - 1);
      return this.dyb[var6 * this.dxz + var5];
   }

   public int w() {
      return this.dxz;
   }

   public int h() {
      return this.dya;
   }

   public int[] px() {
      return this.dyb;
   }
}
