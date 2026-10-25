package a;

import java.awt.geom.Path2D.Float;

final class vii {
   final String vij;
   int vik;

   vii(String var1) {
      this.vij = var1;
   }

   static Float parse(String var0) {
      return new vii(var0).vin();
   }

   Float vin() {
      Float var1 = new Float();
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 0.0F;
      float var6 = 0.0F;
      float var7 = 0.0F;
      char var8 = ' ';
      char var9 = ' ';

      while (true) {
         this.vio();
         if (this.vik >= this.vij.length()) {
            return var1;
         }

         char var10 = this.vij.charAt(this.vik);
         if (Character.isLetter(var10)) {
            var9 = var10;
            this.vik++;
         } else if (var9 == 'M') {
            var9 = 'L';
         } else if (var9 == 'm') {
            var9 = 'l';
         }

         boolean var11 = Character.isLowerCase(var9);
         float var12 = var11 ? var2 : 0.0F;
         float var13 = var11 ? var3 : 0.0F;
         switch (Character.toUpperCase(var9)) {
            case 'A':
               float var24 = this.vip();
               float var28 = this.vip();
               float var31 = this.vip();
               boolean var33 = this.viq();
               boolean var34 = this.viq();
               float var19 = var12 + this.vip();
               float var20 = var13 + this.vip();
               vir(var1, var2, var3, var24, var28, var31, var33, var34, var19, var20);
               var2 = var19;
               var3 = var20;
               var6 = var2;
               var7 = var3;
               break;
            case 'B':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'I':
            case 'J':
            case 'K':
            case 'N':
            case 'O':
            case 'P':
            case 'R':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
               throw new IllegalArgumentException("bad path command '" + var9 + "' in " + this.vij);
            case 'C':
               float var23 = var12 + this.vip();
               float var27 = var13 + this.vip();
               float var30 = var12 + this.vip();
               float var32 = var13 + this.vip();
               var2 = var12 + this.vip();
               var3 = var13 + this.vip();
               var1.curveTo(var23, var27, var30, var32, var2, var3);
               var6 = var30;
               var7 = var32;
               break;
            case 'H':
               var2 = var12 + this.vip();
               var1.lineTo(var2, var3);
               var6 = var2;
               var7 = var3;
               break;
            case 'L':
               var2 = var12 + this.vip();
               var3 = var13 + this.vip();
               var1.lineTo(var2, var3);
               var6 = var2;
               var7 = var3;
               break;
            case 'M':
               var2 = var12 + this.vip();
               var3 = var13 + this.vip();
               var1.moveTo(var2, var3);
               var4 = var2;
               var5 = var3;
               var6 = var2;
               var7 = var3;
               break;
            case 'Q':
               float var22 = var12 + this.vip();
               float var26 = var13 + this.vip();
               var2 = var12 + this.vip();
               var3 = var13 + this.vip();
               var1.quadTo(var22, var26, var2, var3);
               var6 = var22;
               var7 = var26;
               break;
            case 'S':
               boolean var21 = "CcSs".indexOf(var8) >= 0;
               float var25 = var21 ? 2.0F * var2 - var6 : var2;
               float var29 = var21 ? 2.0F * var3 - var7 : var3;
               float var17 = var12 + this.vip();
               float var18 = var13 + this.vip();
               var2 = var12 + this.vip();
               var3 = var13 + this.vip();
               var1.curveTo(var25, var29, var17, var18, var2, var3);
               var6 = var17;
               var7 = var18;
               break;
            case 'T':
               boolean var14 = "QqTt".indexOf(var8) >= 0;
               float var15 = var14 ? 2.0F * var2 - var6 : var2;
               float var16 = var14 ? 2.0F * var3 - var7 : var3;
               var2 = var12 + this.vip();
               var3 = var13 + this.vip();
               var1.quadTo(var15, var16, var2, var3);
               var6 = var15;
               var7 = var16;
               break;
            case 'V':
               var3 = var13 + this.vip();
               var1.lineTo(var2, var3);
               var6 = var2;
               var7 = var3;
               break;
            case 'Z':
               var1.closePath();
               var2 = var4;
               var3 = var5;
               var6 = var2;
               var7 = var3;
         }

         var8 = var9;
      }
   }

   void vio() {
      while (this.vik < this.vij.length()) {
         char var1 = this.vij.charAt(this.vik);
         if (var1 == ' ' || var1 == ',' || var1 == '\n' || var1 == '\t') {
            this.vik++;
            continue;
         }
         break;
      }
   }

   float vip() {
      this.vio();
      int var1 = this.vik;
      if (this.vik < this.vij.length() && (this.vij.charAt(this.vik) == '-' || this.vij.charAt(this.vik) == '+')) {
         this.vik++;
      }

      boolean var2 = false;

      while (this.vik < this.vij.length()) {
         char var3 = this.vij.charAt(this.vik);
         if (Character.isDigit(var3)) {
            this.vik++;
         } else {
            if (var3 != '.' || var2) {
               break;
            }

            var2 = true;
            this.vik++;
         }
      }

      if (var1 == this.vik) {
         throw new IllegalArgumentException("number expected at " + this.vik + " in " + this.vij);
      } else {
         return java.lang.Float.parseFloat(this.vij.substring(var1, this.vik));
      }
   }

   boolean viq() {
      this.vio();
      char var1 = this.vij.charAt(this.vik++);
      return var1 == '1';
   }

   static void vir(Float var0, float var1, float var2, float var3, float var4, float var5, boolean var6, boolean var7, float var8, float var9) {
      if (var3 != 0.0F && var4 != 0.0F && (var1 != var8 || var2 != var9)) {
         var3 = Math.abs(var3);
         var4 = Math.abs(var4);
         double var10 = Math.toRadians(var5);
         double var12 = Math.cos(var10);
         double var14 = Math.sin(var10);
         double var16 = (var1 - var8) * 0.5;
         double var18 = (var2 - var9) * 0.5;
         double var20 = var12 * var16 + var14 * var18;
         double var22 = -var14 * var16 + var12 * var18;
         double var24 = var20 * var20 / (var3 * var3) + var22 * var22 / (var4 * var4);
         if (var24 > 1.0) {
            double var26 = Math.sqrt(var24);
            var3 = (float)(var3 * var26);
            var4 = (float)(var4 * var26);
         }

         double var75 = var3 * var3 * var4 * var4 - var3 * var3 * var22 * var22 - var4 * var4 * var20 * var20;
         double var28 = var3 * var3 * var22 * var22 + var4 * var4 * var20 * var20;
         double var30 = (var6 != var7 ? 1 : -1) * Math.sqrt(Math.max(0.0, var75 / var28));
         double var32 = var30 * var3 * var22 / var4;
         double var34 = -var30 * var4 * var20 / var3;
         double var36 = var12 * var32 - var14 * var34 + (var1 + var8) * 0.5;
         double var38 = var14 * var32 + var12 * var34 + (var2 + var9) * 0.5;
         double var40 = (var20 - var32) / var3;
         double var42 = (var22 - var34) / var4;
         double var44 = (-var20 - var32) / var3;
         double var46 = (-var22 - var34) / var4;
         double var48 = Math.atan2(var42, var40);
         double var50 = Math.atan2(var40 * var46 - var42 * var44, var40 * var44 + var42 * var46);
         if (!var7 && var50 > 0.0) {
            var50 -= Math.PI * 2;
         } else if (var7 && var50 < 0.0) {
            var50 += Math.PI * 2;
         }

         int var52 = (int)Math.ceil(Math.abs(var50) / (Math.PI / 2) - 1.0E-6);
         double var53 = var50 / Math.max(1, var52);
         double var55 = 1.3333333333333333 * Math.tan(var53 / 4.0);

         for (int var57 = 0; var57 < var52; var57++) {
            double var58 = var48 + var53 * var57;
            double var60 = var58 + var53;
            double var62 = Math.cos(var58);
            double var64 = Math.sin(var58);
            double var66 = Math.cos(var60);
            double var68 = Math.sin(var60);
            double[] var70 = vis(var62 - var55 * var64, var64 + var55 * var62, var3, var4, var12, var14, var36, var38);
            double[] var71 = vis(var66 + var55 * var68, var68 - var55 * var66, var3, var4, var12, var14, var36, var38);
            double[] var72 = vis(var66, var68, var3, var4, var12, var14, var36, var38);
            var0.curveTo((float)var70[0], (float)var70[1], (float)var71[0], (float)var71[1], (float)var72[0], (float)var72[1]);
         }
      } else {
         var0.lineTo(var8, var9);
      }
   }

   static double[] vis(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14) {
      double var16 = var0 * var4;
      double var18 = var2 * var6;
      return new double[]{var8 * var16 - var10 * var18 + var12, var10 * var16 + var8 * var18 + var14};
   }
}
