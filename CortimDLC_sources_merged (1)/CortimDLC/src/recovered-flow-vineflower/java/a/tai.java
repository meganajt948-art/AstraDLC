package a;

import java.util.Random;

public final class tai {
   private final tck taj;
   private final Random tak;
   private final tch tal = new tch();
   private final double[] tam = new double[32];
   private final double[] tan = new double[2];
   private double tao;
   private double tap;
   private double taq;
   private double tar;
   private double tas;
   private double tat;
   private double tau;
   private double tav;
   private double taw;
   private double tax;
   private int tay = -1;
   private double taz = 1.0;
   private double tba;
   private double tbb;

   public tai(tck var1, Random var2) {
      this.taj = var1;
      this.tak = var2;
   }

   public tck model() {
      return this.taj;
   }

   public void reset() {
      this.tao = this.tap = this.taq = this.tar = this.tas = this.tat = this.tau = this.tav = 0.0;
      this.taw = this.tax = 0.0;
      this.tay = -1;
      this.tba = this.tbb = 0.0;
   }

   public void settle() {
      this.taw = this.tax = 0.0;
   }

   public void prime(double var1, double var3) {
      this.taw = var1;
      this.tax = var3;
   }

   public void history(double var1, double var3) {
      this.tau = this.tas;
      this.tav = this.tat;
      this.tas = this.taq;
      this.tat = this.tar;
      this.taq = this.tao;
      this.tar = this.tap;
      this.tao = var1;
      this.tap = var3;
   }

   public double lastX() {
      return this.tao;
   }

   public double lastY() {
      return this.tap;
   }

   public void step(double[] var1, taf var2, double[] var3) {
      this.step(var1, var2, var3, false);
   }

   public void step(double[] var1, taf var2, double[] var3, boolean var4) {
      System.arraycopy(var1, 0, this.tam, 0, 32);
      this.tam[14] = this.tao;
      this.tam[15] = this.tap;
      this.tam[16] = this.taq;
      this.tam[17] = this.tar;
      this.tam[18] = this.tas;
      this.tam[19] = this.tat;
      this.tam[20] = this.tau;
      this.tam[21] = this.tav;
      double var5 = this.taw;
      double var7 = this.tax;
      if (var4) {
         tbf.swapAxes(this.tam);
         var5 = this.tax;
         var7 = this.taw;
      }

      this.taj.predict(this.tam, this.tan, this.tal);
      double var9 = this.tam[0];
      double var11 = this.tam[1];
      double var13 = Math.hypot(var9, var11);
      int var15 = tck.bin(var13);
      double var16 = this.tan[0] * var2.speed;
      double var18 = this.tan[1] * var2.speed;
      if (var2.texture > 0.0 && this.taj.resX.length > 0) {
         this.tbe(var15);
         double var20 = this.taj.texCap * Math.hypot(var16, var18) + this.taj.texFloor;
         double var22 = this.tba * var2.texture * (var4 ? this.taj.texY : this.taj.texX);
         double var24 = this.tbb * var2.texture * (var4 ? this.taj.texX : this.taj.texY);
         double var26 = Math.hypot(var22, var24);
         if (var26 > var20) {
            var22 *= var20 / var26;
            var24 *= var20 / var26;
         }

         var16 += var22;
         var18 += var24;
      }

      if (var4) {
         var16 *= var2.vertical;
      } else {
         var18 *= var2.vertical;
      }

      double var52 = Math.max(1.0, var2.speed);
      double var53 = Math.hypot(this.tam[6], this.tam[7]);
      double var54 = this.taj.speedCap[var15] * var52 * 1.05 + var53 * 1.2;
      double var55 = Math.hypot(var16, var18);
      if (var2.envelope && var55 > var54 && var55 > 1.0E-9) {
         var16 *= var54 / var55;
         var18 *= var54 / var55;
      }

      double var28 = var16 - var5;
      double var30 = var18 - var7;
      double var32 = Math.hypot(var28, var30);
      double var34 = this.taj.accelCap[var15] * var52 * 1.1 + var53 * 0.5;
      if (var2.envelope && var32 > var34 && var32 > 1.0E-9) {
         var16 = var5 + var28 * var34 / var32;
         var18 = var7 + var30 * var34 / var32;
      }

      double var36 = var9 + this.tam[6] * var2.lead;
      double var38 = var11 + this.tam[7] * var2.lead;
      double var40 = Math.hypot(var36, var38);
      if (var2.guard && var40 > 1.0E-6) {
         double var42 = var36 / var40;
         double var44 = var38 / var40;
         double var46 = 0.18 * (this.tam[22] * Math.abs(var42) + 0.5 * this.tam[23] * Math.abs(var44)) + 0.02;
         double var48 = var16 * var42 + var18 * var44;
         double var50 = var40 + var46;
         if (var48 > var50) {
            var16 -= var42 * (var48 - var50);
            var18 -= var44 * (var48 - var50);
         }
      }

      var3[0] = var4 ? var18 : var16;
      var3[1] = var4 ? var16 : var18;
      this.taw = var3[0];
      this.tax = var3[1];
   }

   private void tbe(int var1) {
      boolean var2 = this.tay < 0 || this.tay + 1 >= this.taj.resX.length || !this.taj.resLink[this.tay] || Math.abs(this.taj.resBin[this.tay + 1] - var1) > 1;
      if (var2) {
         int[] var3 = this.taj.residualsIn(var1);
         if (var3.length == 0) {
            this.tba = this.tbb = 0.0;
            return;
         }

         this.tay = var3[this.tak.nextInt(var3.length)];
         this.taz = this.taj.mirror && this.tak.nextBoolean() ? -1.0 : 1.0;
      } else {
         this.tay++;
      }

      this.tba = this.taj.resX[this.tay] * this.taz;
      this.tbb = this.taj.resY[this.tay];
   }
}
