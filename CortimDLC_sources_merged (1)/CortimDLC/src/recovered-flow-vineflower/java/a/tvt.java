package a;

public final class tvt {
   public static final byte JUMP = 1;
   public static final byte DROP = 2;
   public static final byte WATER = 4;
   public static final byte CLIMB = 8;
   public final int n;
   public final float[] x;
   public final float[] y;
   public final float[] z;
   public final byte[] flag;
   public final float[] s;

   public tvt(float[] var1, float[] var2, float[] var3, byte[] var4) {
      this.n = var1.length;
      this.x = var1;
      this.y = var2;
      this.z = var3;
      this.flag = var4;
      this.s = new float[this.n];

      for (int var5 = 1; var5 < this.n; var5++) {
         this.s[var5] = this.s[var5 - 1] + (float)Math.hypot(var1[var5] - var1[var5 - 1], var3[var5] - var3[var5 - 1]);
      }
   }

   public double length() {
      return this.n == 0 ? 0.0 : this.s[this.n - 1];
   }

   public int closest(double var1, double var3, double var5, int var7, int var8, int var9) {
      if (this.n == 0) {
         return 0;
      }

      int var10 = Math.max(0, var7 - var8);
      int var11 = Math.min(this.n - 1, var7 + var9);
      int var12 = Math.max(var10, Math.min(var11, var7));
      double var13 = Double.MAX_VALUE;

      for (int var15 = var10; var15 <= var11; var15++) {
         double var16 = this.x[var15] - var1;
         double var18 = this.z[var15] - var5;
         double var20 = this.y[var15] - var3;
         double var22 = var16 * var16 + var18 * var18 + var20 * var20 * 0.35;
         if (var22 < var13 - 1.0E-9) {
            var13 = var22;
            var12 = var15;
         }
      }

      return var12;
   }

   public double project(double var1, double var3, int var5) {
      if (this.n < 2) {
         return 0.0;
      }

      double var6 = this.s[var5];
      double var8 = Double.MAX_VALUE;

      for (int var10 = Math.max(0, var5 - 1); var10 <= Math.min(this.n - 2, var5); var10++) {
         double var11 = this.x[var10];
         double var13 = this.z[var10];
         double var15 = this.x[var10 + 1] - var11;
         double var17 = this.z[var10 + 1] - var13;
         double var19 = var15 * var15 + var17 * var17;
         double var21 = var19 < 1.0E-9 ? 0.0 : Math.max(0.0, Math.min(1.0, ((var1 - var11) * var15 + (var3 - var13) * var17) / var19));
         double var23 = var11 + var15 * var21 - var1;
         double var25 = var13 + var17 * var21 - var3;
         double var27 = var23 * var23 + var25 * var25;
         if (var27 < var8) {
            var8 = var27;
            var6 = this.s[var10] + (this.s[var10 + 1] - this.s[var10]) * var21;
         }
      }

      return var6;
   }

   public int index(double var1) {
      if (this.n == 0) {
         return 0;
      }

      if (var1 <= 0.0) {
         return 0;
      }

      if (var1 >= this.s[this.n - 1]) {
         return this.n - 1;
      }

      int var3 = 0;
      int var4 = this.n - 1;

      while (var4 - var3 > 1) {
         int var5 = var3 + var4 >>> 1;
         if (this.s[var5] <= var1) {
            var3 = var5;
         } else {
            var4 = var5;
         }
      }

      return var3;
   }

   public void at(double var1, double[] var3) {
      if (this.n == 0) {
         var3[0] = 0.0;
         var3[1] = 0.0;
         var3[2] = 0.0;
      } else if (this.n == 1 || var1 <= 0.0) {
         var3[0] = this.x[0];
         var3[1] = this.y[0];
         var3[2] = this.z[0];
      } else if (var1 >= this.s[this.n - 1]) {
         var3[0] = this.x[this.n - 1];
         var3[1] = this.y[this.n - 1];
         var3[2] = this.z[this.n - 1];
      } else {
         int var4 = this.index(var1);
         double var5 = this.s[var4 + 1] - this.s[var4];
         double var7 = var5 < 1.0E-9 ? 0.0 : (var1 - this.s[var4]) / var5;
         var3[0] = this.x[var4] + (this.x[var4 + 1] - this.x[var4]) * var7;
         var3[1] = this.y[var4] + (this.y[var4 + 1] - this.y[var4]) * var7;
         var3[2] = this.z[var4] + (this.z[var4 + 1] - this.z[var4]) * var7;
      }
   }

   public double heading(double var1) {
      if (this.n < 2) {
         return 0.0;
      }

      int var3 = Math.min(this.n - 2, this.index(var1));
      int var4 = var3 + 1;

      while (var4 < this.n - 1 && this.s[var4] - this.s[var3] < 0.4) {
         var4++;
      }

      while (var3 > 0 && this.s[var4] - this.s[var3] < 0.4) {
         var3--;
      }

      return yawOf(this.x[var4] - this.x[var3], this.z[var4] - this.z[var3]);
   }

   public double lateral(double var1, double var3, double var5) {
      if (this.n < 2) {
         return 0.0;
      }

      double[] var7 = new double[3];
      this.at(var5, var7);
      double var8 = Math.toRadians(this.heading(var5));
      double var10 = var1 - var7[0];
      double var12 = var3 - var7[2];
      return var10 * Math.cos(var8) + var12 * Math.sin(var8);
   }

   public double offset(double var1, double var3, double var5) {
      double[] var7 = new double[3];
      this.at(var5, var7);
      return Math.hypot(var1 - var7[0], var3 - var7[2]);
   }

   public double next(double var1, double var3, byte var5, double var6, double[] var8) {
      int var9 = this.index(var1);
      double var10 = var1 + var3;

      for (int var12 = var9; var12 < this.n && this.s[var12] <= var10; var12++) {
         if ((this.flag[var12] & var5) != 0) {
            if (var5 == 1) {
               double var13 = this.y[var12] - var6;

               for (int var15 = var12; var15 < this.n && this.s[var15] <= this.s[var12] + 1.6; var15++) {
                  var13 = Math.max(var13, this.y[var15] - var6);
               }

               if (!(var13 < 0.55)) {
                  var8[0] = var13;
                  return Math.max(0.0, this.s[var12] - var1);
               }
            } else {
               if (var5 != 2) {
                  var8[0] = 0.0;
                  return Math.max(0.0, this.s[var12] - var1);
               }

               double var16 = this.y[var12];

               for (int var17 = var12; var17 < this.n && this.s[var17] <= this.s[var12] + 2.0; var17++) {
                  var16 = Math.min(var16, this.y[var17]);
               }

               var8[0] = var6 - var16;
               if (!(var8[0] < 0.55)) {
                  return Math.max(0.0, this.s[var12] - var1);
               }
            }
         }
      }

      var8[0] = 0.0;
      return -1.0;
   }

   public double flatAhead(double var1, double var3, double var5) {
      int var7 = this.index(var1);
      double var8 = var1 + var3;

      for (int var10 = var7; var10 < this.n && this.s[var10] <= var8; var10++) {
         if (Math.abs(this.y[var10] - var5) > 0.55 || (this.flag[var10] & 15) != 0) {
            return this.s[var10] - var1;
         }
      }

      return Math.min(var3, this.length() - var1);
   }

   public double bend(double var1, double var3) {
      if (this.n < 3) {
         return 0.0;
      }

      double var5 = this.heading(var1);
      double var7 = 0.0;

      for (double var9 = 0.5; var9 <= var3 && !(var1 + var9 > this.length()); var9 += 0.5) {
         var7 = Math.max(var7, Math.abs(wrap(this.heading(var1 + var9) - var5)));
      }

      return var7;
   }

   public static double yawOf(double var0, double var2) {
      return Math.toDegrees(Math.atan2(-var0, var2));
   }

   public static double wrap(double var0) {
      double var2 = var0 % 360.0;
      if (var2 >= 180.0) {
         var2 -= 360.0;
      }

      if (var2 < -180.0) {
         var2 += 360.0;
      }

      return var2;
   }
}
