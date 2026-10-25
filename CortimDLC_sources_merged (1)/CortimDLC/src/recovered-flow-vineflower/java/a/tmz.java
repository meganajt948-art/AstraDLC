package a;

final class tmz {
   final double[] ex;
   final double[] ey;
   final double[] dx;
   final double[] dy;

   tmz(int var1) {
      this.ex = new double[var1 + 1];
      this.ey = new double[var1 + 1];
      this.dx = new double[var1 + 1];
      this.dy = new double[var1 + 1];
   }

   void state(sze var1, int var2, int var3, double[] var4) {
      int var5 = var2 + var3;
      System.arraycopy(var1.st, var5 * 32, var4, 0, 32);
      var4[0] = this.ex[var3];
      var4[1] = this.ey[var3];

      for (int var6 = 0; var6 < tnl.tnw.length; var6++) {
         int var7 = var3 - tnl.tnw[var6];
         if (var7 >= 1) {
            var4[tnl.tnx[var6]] = this.ex[var7];
            var4[tnl.tnx[var6] + 1] = this.ey[var7];
         }
      }
   }
}
