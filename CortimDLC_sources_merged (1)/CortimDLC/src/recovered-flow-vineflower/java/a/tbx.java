package a;

import flow.dev.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class tbx {
   public final int in;
   public final int h1;
   public final int h2;
   public final int out;
   public final double[] p;
   final int tby;
   final int tbz;
   final int tca;
   final int tcb;
   final int tcc;
   final int tcd;

   public tbx(int var1, int var2, int var3, int var4) {
      this.in = var1;
      this.h1 = var2;
      this.h2 = var3;
      this.out = var4;
      this.tby = 0;
      this.tbz = this.tby + var2 * var1;
      this.tca = this.tbz + var2;
      this.tcb = this.tca + var3 * var2;
      this.tcc = this.tcb + var3;
      this.tcd = this.tcc + var4 * var3;
      this.p = new double[this.tcd + var4];
   }

   public void init(Random var1, double[] var2) {
      this.tcg(var1, this.tby, this.h1 * this.in, Math.sqrt(1.0 / this.in));
      this.tcg(var1, this.tca, this.h2 * this.h1, Math.sqrt(1.0 / this.h1));
      this.tcg(var1, this.tcc, this.out * this.h2, 0.1 * Math.sqrt(1.0 / this.h2));

      for (int var3 = 0; var3 < this.out; var3++) {
         this.p[this.tcd + var3] = var2[var3];
      }
   }

   void tcg(Random var1, int var2, int var3, double var4) {
      for (int var6 = 0; var6 < var3; var6++) {
         this.p[var2 + var6] = var1.nextGaussian() * var4;
      }
   }

   public int size() {
      return this.p.length;
   }

   public tbx copy() {
      tbx var1 = new tbx(this.in, this.h1, this.h2, this.out);
      System.arraycopy(this.p, 0, var1.p, 0, this.p.length);
      return var1;
   }

   public void forward(double[] var1, double[] var2, double[] var3, double[] var4) {
      for (int var5 = 0; var5 < this.h1; var5++) {
         double var6 = this.p[this.tbz + var5];
         int var8 = this.tby + var5 * this.in;

         for (int var9 = 0; var9 < this.in; var9++) {
            var6 += this.p[var8 + var9] * var1[var9];
         }

         var2[var5] = Math.tanh(var6);
      }

      for (int var10 = 0; var10 < this.h2; var10++) {
         double var12 = this.p[this.tcb + var10];
         int var14 = this.tca + var10 * this.h1;

         for (int var16 = 0; var16 < this.h1; var16++) {
            var12 += this.p[var14 + var16] * var2[var16];
         }

         var3[var10] = Math.tanh(var12);
      }

      for (int var11 = 0; var11 < this.out; var11++) {
         double var13 = this.p[this.tcd + var11];
         int var15 = this.tcc + var11 * this.h2;

         for (int var17 = 0; var17 < this.h2; var17++) {
            var13 += this.p[var15 + var17] * var3[var17];
         }

         var4[var11] = var13;
      }
   }

   public void backward(double[] var1, double[] var2, double[] var3, double[] var4, double[] var5, double[] var6, double[] var7, double[] var8) {
      for (int var9 = 0; var9 < this.h2; var9++) {
         var8[var9] = 0.0;
      }

      for (int var14 = 0; var14 < this.out; var14++) {
         double var10 = var4[var14];
         if (var10 != 0.0) {
            var5[this.tcd + var14] = var5[this.tcd + var14] + var10;
            int var12 = this.tcc + var14 * this.h2;

            for (int var13 = 0; var13 < this.h2; var13++) {
               var5[var12 + var13] = var5[var12 + var13] + var10 * var3[var13];
               var8[var13] += var10 * this.p[var12 + var13];
            }
         }
      }

      for (int var15 = 0; var15 < this.h1; var15++) {
         var7[var15] = 0.0;
      }

      for (int var16 = 0; var16 < this.h2; var16++) {
         double var19 = var8[var16] * (1.0 - var3[var16] * var3[var16]);
         var5[this.tcb + var16] = var5[this.tcb + var16] + var19;
         int var21 = this.tca + var16 * this.h1;

         for (int var23 = 0; var23 < this.h1; var23++) {
            var5[var21 + var23] = var5[var21 + var23] + var19 * var2[var23];
            var7[var23] += var19 * this.p[var21 + var23];
         }
      }

      if (var6 != null) {
         for (int var17 = 0; var17 < this.in; var17++) {
            var6[var17] = 0.0;
         }
      }

      for (int var18 = 0; var18 < this.h1; var18++) {
         double var20 = var7[var18] * (1.0 - var2[var18] * var2[var18]);
         var5[this.tbz + var18] = var5[this.tbz + var18] + var20;
         int var22 = this.tby + var18 * this.in;

         for (int var24 = 0; var24 < this.in; var24++) {
            var5[var22 + var24] = var5[var22 + var24] + var20 * var1[var24];
            if (var6 != null) {
               var6[var24] += var20 * this.p[var22 + var24];
            }
         }
      }
   }

   public void write(DataOutputStream var1) throws IOException {
      var1.writeInt(this.in);
      var1.writeInt(this.h1);
      var1.writeInt(this.h2);
      var1.writeInt(this.out);

      for (double var5 : this.p) {
         var1.writeFloat((float)var5);
      }
   }

   public static tbx read(DataInputStream var0) throws IOException {
      int var1 = var0.readInt();
      int var2 = var0.readInt();
      int var3 = var0.readInt();
      int var4 = var0.readInt();
      if (var1 > 0 && var2 > 0 && var3 > 0 && var4 > 0 && var1 <= 256 && var2 <= 1024 && var3 <= 1024 && var4 <= 64) {
         tbx var5 = new tbx(var1, var2, var3, var4);

         for (int var6 = 0; var6 < var5.p.length; var6++) {
            var5.p[var6] = var0.readFloat();
         }

         return var5;
      } else {
         throw new IOException(a.b("㕞䳬옺堏펖唬\uef6e暜\uf8db牷\uf5bd྇脃ᢩ鋳ᐓ깉", 1652372781));
      }
   }
}
