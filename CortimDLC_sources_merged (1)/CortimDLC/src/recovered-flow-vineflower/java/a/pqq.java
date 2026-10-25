package a;

import java.util.Random;

public final class pqq {
   final long pqr;
   final double pqs;
   final double pqt;
   public final double wall;

   public pqq(long var1, double var3, double var5, double var7) {
      this.pqr = var1;
      this.pqs = var3;
      this.pqt = var5;
      this.wall = var7;
   }

   public static pqq random(Random var0) {
      return new pqq(var0.nextLong(), 4.5 + var0.nextDouble() * 5.0, 0.18 + var0.nextDouble() * 0.17, 0.6 + var0.nextDouble() * 0.8);
   }

   public double at(int var1, int var2) {
      double var3 = var1 / this.pqs;
      double var5 = var2 / this.pqs;
      int var7 = (int)Math.floor(var3);
      int var8 = (int)Math.floor(var5);
      double var9 = var3 - var7;
      double var11 = var5 - var8;
      var9 = var9 * var9 * (3.0 - 2.0 * var9);
      var11 = var11 * var11 * (3.0 - 2.0 * var11);
      double var13 = this.pqw(var7, var8);
      double var15 = this.pqw(var7 + 1, var8);
      double var17 = this.pqw(var7, var8 + 1);
      double var19 = this.pqw(var7 + 1, var8 + 1);
      double var21 = var13 + (var15 - var13) * var9 + (var17 - var13) * var11 + (var13 - var15 - var17 + var19) * var9 * var11;
      return 1.0 + this.pqt * (var21 * 2.0 - 1.0);
   }

   double pqw(int var1, int var2) {
      long var3 = this.pqr ^ var1 * -7046029254386353131L ^ var2 * -4417276706812531889L;
      var3 ^= var3 >>> 31;
      var3 *= -4658895280553007687L;
      var3 ^= var3 >>> 29;
      return (var3 >>> 11) * 1.110223E-16F;
   }
}
