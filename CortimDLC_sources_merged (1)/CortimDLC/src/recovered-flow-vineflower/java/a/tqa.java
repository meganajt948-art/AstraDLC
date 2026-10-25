package a;

import flow.dev.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class tqa {
   public final int in;
   public final int hidden;
   public final double[] p;
   public final double[] mu;
   public final double[] sd;
   private final int tqb;
   private final int tqc;
   private final int tqd;

   public tqa(int var1, int var2) {
      this.in = var1;
      this.hidden = var2;
      this.tqb = var2 * var1;
      this.tqc = this.tqb + var2;
      this.tqd = this.tqc + var2;
      this.p = new double[this.tqd + 1];
      this.mu = new double[var1];
      this.sd = new double[var1];
      Arrays.fill(this.sd, 1.0);
   }

   public void init(Random var1) {
      double var2 = Math.sqrt(1.0 / this.in);

      for (int var4 = 0; var4 < this.tqb; var4++) {
         this.p[var4] = var1.nextGaussian() * var2;
      }

      double var7 = 0.3 * Math.sqrt(1.0 / this.hidden);

      for (int var6 = 0; var6 < this.hidden; var6++) {
         this.p[this.tqc + var6] = var1.nextGaussian() * var7;
      }
   }

   public tqa copy() {
      tqa var1 = new tqa(this.in, this.hidden);
      System.arraycopy(this.p, 0, var1.p, 0, this.p.length);
      System.arraycopy(this.mu, 0, var1.mu, 0, this.in);
      System.arraycopy(this.sd, 0, var1.sd, 0, this.in);
      return var1;
   }

   public void normalize(double[] var1, int var2, double[] var3, int var4) {
      for (int var5 = 0; var5 < this.in; var5++) {
         var3[var4 + var5] = Math.max(-8.0, Math.min(8.0, (var1[var2 + var5] - this.mu[var5]) / this.sd[var5]));
      }
   }

   void silence(int var1) {
      for (int var2 = 0; var2 < this.hidden; var2++) {
         this.p[var2 * this.in + var1] = 0.0;
      }
   }

   double forward(double[] var1, int var2, double[] var3) {
      double var4 = this.p[this.tqd];

      for (int var6 = 0; var6 < this.hidden; var6++) {
         double var7 = this.p[this.tqb + var6];
         int var9 = var6 * this.in;

         for (int var10 = 0; var10 < this.in; var10++) {
            var7 += this.p[var9 + var10] * var1[var2 + var10];
         }

         var3[var6] = Math.tanh(var7);
         var4 += this.p[this.tqc + var6] * var3[var6];
      }

      return var4;
   }

   void backward(double[] var1, int var2, double[] var3, double var4, double[] var6) {
      var6[this.tqd] = var6[this.tqd] + var4;

      for (int var7 = 0; var7 < this.hidden; var7++) {
         var6[this.tqc + var7] = var6[this.tqc + var7] + var4 * var3[var7];
         double var8 = var4 * this.p[this.tqc + var7] * (1.0 - var3[var7] * var3[var7]);
         if (var8 != 0.0) {
            var6[this.tqb + var7] = var6[this.tqb + var7] + var8;
            int var10 = var7 * this.in;

            for (int var11 = 0; var11 < this.in; var11++) {
               var6[var10 + var11] = var6[var10 + var11] + var8 * var1[var2 + var11];
            }
         }
      }
   }

   public double[] scores(tpn var1) {
      double[] var2 = new double[var1.n];
      double[] var3 = new double[this.in];
      double[] var4 = new double[this.hidden];

      for (int var5 = 0; var5 < var1.n; var5++) {
         this.normalize(var1.f, var5 * 32, var3, 0);
         var2[var5] = this.forward(var3, 0, var4);
      }

      return var2;
   }

   public void write(DataOutputStream var1) throws IOException {
      var1.writeInt(this.in);
      var1.writeInt(this.hidden);

      for (int var2 = 0; var2 < this.in; var2++) {
         var1.writeFloat((float)this.mu[var2]);
         var1.writeFloat((float)this.sd[var2]);
      }

      for (double var5 : this.p) {
         var1.writeFloat((float)var5);
      }
   }

   public static tqa read(DataInputStream var0) throws IOException {
      int var1 = var0.readInt();
      int var2 = var0.readInt();
      if (var1 == 32 && var2 > 0 && var2 <= 256) {
         tqa var3 = new tqa(var1, var2);

         for (int var4 = 0; var4 < var1; var4++) {
            var3.mu[var4] = var0.readFloat();
            var3.sd[var4] = var0.readFloat();
         }

         for (int var5 = 0; var5 < var3.p.length; var5++) {
            var3.p[var5] = var0.readFloat();
         }

         return var3;
      } else {
         throw new IOException(a.c(-409391692, "ⷛ呡\udeb5䃂쬟䶨\uf7be縜\ue058櫠\ued22ᝆ"));
      }
   }
}
