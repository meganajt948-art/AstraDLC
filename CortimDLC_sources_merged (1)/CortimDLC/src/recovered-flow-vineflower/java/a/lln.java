package a;

public final class lln {
   public double pull = 0.5;
   public double slow = 0.35;
   public double vertical = 0.5;
   public double flickFrom = 300.0;
   public double flickTo = 800.0;
   static final double llo = 0.045;
   static final double llp = 0.06;
   static final double llq = 0.1;
   double llr;
   double lls;
   double llt;
   double llu;
   double llv;
   double llw;
   double llx;
   double lly;
   double llz = 0.016666666666666666;
   double lma;

   public void reset() {
      this.llr = 0.0;
      this.lma = 0.0;
      this.lls = this.llt = 0.0;
      this.llu = this.llv = 0.0;
      this.llx = this.lly = 0.0;
      this.llw = 0.0;
   }

   public double speed() {
      return this.lma;
   }

   public void frame(double var1) {
      if (this.llw > 0.0) {
         this.llr = lmd(this.llr, Math.hypot(this.llu, this.llv) / this.llw, this.llw, 0.045);
         this.lls = lmd(this.lls, this.llx, this.llw, 0.06);
         this.llt = lmd(this.llt, this.lly, this.llw, 0.06);
      }

      this.llu = this.llv = 0.0;
      this.llx = this.lly = 0.0;
      this.llw = 0.0;
      if (var1 >= 0.1) {
         this.llr = 0.0;
         this.lls = this.llt = 0.0;
      }

      this.llz = clamp(var1, 0.001, 0.1);
   }

   public void extra(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double[] var17) {
      var17[0] = 0.0;
      var17[1] = 0.0;
      this.llu = var1;
      this.llv = var3;
      this.llw = this.llz;
      double var18 = Math.hypot(var1, var3);
      this.lma = Math.max(lmd(this.llr, var18 / this.llz, this.llz, 0.045), 0.7 * var18 / this.llz);
      double var20 = Math.max(0.0, var15) * (1.0 - smooth(this.flickFrom, this.flickTo, this.lma));
      double var22 = clamp(this.vertical, 0.0, 1.0);
      double var24 = var5 + var9;
      double var26 = (var7 + var11) * var22;
      double var28 = 1.0 - smooth(0.0, Math.max(0.2, var13), Math.hypot(var5, var7 * var22));
      double var30 = Math.hypot(var24, var26);
      double var32 = 0.0;
      double var34 = 0.0;
      if (var30 >= 1.0E-9 && var18 >= 1.0E-9) {
         var32 = (var1 * var24 + var3 * var26) / var30;
         var34 = clamp((var32 / var18 + 0.35) / 1.35, 0.0, 1.0);
      }

      this.llx = this.pull * var20 * var34;
      this.lly = Math.min(0.9, this.slow * var28 * var20);
      if (!(var18 < 1.0E-9)) {
         double var36 = lmd(this.lls, this.llx, this.llz, 0.06);
         double var38 = lmd(this.llt, this.lly, this.llz, 0.06);
         if (var30 < 1.0E-9) {
            var17[0] = -var38 * var1;
            var17[1] = -var38 * var3 * var22;
         } else {
            double var40 = var24 / var30;
            double var42 = var26 / var30;
            double var44 = clamp(var32, 0.0, var30);
            double var46 = Math.min(var30 - var44, var18 * var36);
            var17[0] = -var38 * (var1 - var44 * var40) + var46 * var40;
            var17[1] = (-var38 * (var3 - var44 * var42) + var46 * var42) * var22;
         }
      }
   }

   static double lmd(double var0, double var2, double var4, double var6) {
      return var0 + (var2 - var0) * (1.0 - Math.exp(-var4 / var6));
   }

   static double smooth(double var0, double var2, double var4) {
      double var6 = clamp((var4 - var0) / (var2 - var0), 0.0, 1.0);
      return var6 * var6 * (3.0 - 2.0 * var6);
   }

   static double clamp(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }
}
