package a;

import flow.dev.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class txv {
   public static final int NONE = 0;
   public static final int F = 1;
   public static final int FL = 2;
   public static final int FR = 3;
   public static final int L = 4;
   public static final int R = 5;
   public static final int B = 6;
   public static final int BL = 7;
   public static final int BR = 8;
   public static final int MOVES = 9;
   public static final int[] MIRROR = new int[]{0, 1, 3, 2, 5, 4, 6, 8, 7};
   public static final int[] FWD = new int[]{0, 1, 1, 1, 0, 0, -1, -1, -1};
   public static final int[] LEFT = new int[]{0, 0, 1, -1, 1, -1, 0, 1, -1};
   public static final float[] YAW = tyc(new float[]{0.3F, 0.7F, 1.2F, 1.9F, 2.8F, 4.0F, 5.5F, 7.5F, 10.0F, 13.0F, 17.0F, 22.0F, 29.0F, 38.0F, 52.0F});
   public static final float[] PITCH = tyc(new float[]{0.3F, 0.7F, 1.3F, 2.2F, 3.5F, 5.5F, 9.0F});
   public static final int JUMP = 9;
   public static final int SPRINT = 10;
   public static final int YAW0 = 11;
   public static final int PITCH0 = 11 + YAW.length;
   public static final int OUT = PITCH0 + PITCH.length;
   public final tbx net;
   public final double[] mu = new double[txl.N];
   public final double[] sd = new double[txl.N];
   final double[] txw = new double[txl.N];
   double[] txx;
   double[] txy;
   final double[] txz = new double[OUT];

   public txv(tbx var1) {
      this.net = var1;
      Arrays.fill(this.sd, 1.0);
      this.txx = new double[var1.h1];
      this.txy = new double[var1.h2];
   }

   static float[] tyc(float[] var0) {
      float[] var1 = new float[var0.length * 2 + 1];
      int var2 = var0.length;

      for (int var3 = 0; var3 < var0.length; var3++) {
         var1[var2 + 1 + var3] = var0[var3];
         var1[var2 - 1 - var3] = -var0[var3];
      }

      return var1;
   }

   public static int bin(float[] var0, double var1) {
      int var3 = 0;
      double var4 = Double.MAX_VALUE;

      for (int var6 = 0; var6 < var0.length; var6++) {
         double var7 = Math.abs(var0[var6] - var1);
         if (var7 < var4) {
            var4 = var7;
            var3 = var6;
         }
      }

      return var3;
   }

   public static double lo(float[] var0, int var1) {
      return var1 == 0 ? var0[0] - (var0[1] - var0[0]) * 0.5 : (var0[var1 - 1] + var0[var1]) * 0.5;
   }

   public static double hi(float[] var0, int var1) {
      int var2 = var0.length;
      return var1 == var2 - 1 ? var0[var2 - 1] + (var0[var2 - 1] - var0[var2 - 2]) * 0.5 : (var0[var1] + var0[var1 + 1]) * 0.5;
   }

   public static double draw(float[] var0, int var1, Random var2) {
      double var3 = lo(var0, var1);
      double var5 = hi(var0, var1);
      return var0[var1] == 0.0F ? (var2.nextDouble() - 0.5) * (var5 - var3) * 0.6 : var3 + (var5 - var3) * var2.nextDouble();
   }

   public void normalize(double[] var1, int var2, double[] var3) {
      for (int var4 = 0; var4 < txl.N; var4++) {
         double var5 = (var1[var2 + var4] - this.mu[var4]) / this.sd[var4];
         var3[var4] = var5 > 8.0 ? 8.0 : (var5 < -8.0 ? -8.0 : var5);
      }
   }

   public double[] forward(double[] var1) {
      this.normalize(var1, 0, this.txw);
      this.net.forward(this.txw, this.txx, this.txy, this.txz);
      return this.txz;
   }

   public static void softmax(double[] var0, int var1, int var2, double var3, double[] var5) {
      double var6 = Double.NEGATIVE_INFINITY;

      for (int var8 = 0; var8 < var2; var8++) {
         var6 = Math.max(var6, var0[var1 + var8]);
      }

      double var11 = 0.0;

      for (int var10 = 0; var10 < var2; var10++) {
         var5[var10] = Math.exp((var0[var1 + var10] - var6) / var3);
         var11 += var5[var10];
      }

      for (int var12 = 0; var12 < var2; var12++) {
         var5[var12] /= var11;
      }
   }

   public static int sample(double[] var0, int var1, Random var2) {
      double var3 = var2.nextDouble();

      for (int var5 = 0; var5 < var1; var5++) {
         var3 -= var0[var5];
         if (var3 <= 0.0) {
            return var5;
         }
      }

      return var1 - 1;
   }

   public static double pick(float[] var0, double[] var1, int var2, double var3, double var5, double[] var7, Random var8) {
      softmax(var1, var2, var0.length, var3, var7);
      int var9 = sample(var7, var0.length, var8);
      int var10 = Math.max(0, var9 - 1);
      int var11 = Math.min(var0.length - 1, var9 + 1);
      double var12 = 0.0;
      double var14 = 0.0;

      for (int var16 = var10; var16 <= var11; var16++) {
         var12 += var7[var16];
         var14 += var7[var16] * var0[var16];
      }

      double var18 = var12 > 0.0 ? var14 / var12 : var0[var9];
      return var18 + var5 * (draw(var0, var9, var8) - var18);
   }

   public static double sigmoid(double var0) {
      return 1.0 / (1.0 + Math.exp(-var0));
   }

   public void write(DataOutputStream var1) throws IOException {
      var1.writeInt(txl.N);
      var1.writeInt(OUT);

      for (int var2 = 0; var2 < txl.N; var2++) {
         var1.writeFloat((float)this.mu[var2]);
         var1.writeFloat((float)this.sd[var2]);
      }

      this.net.write(var1);
   }

   public static txv read(DataInputStream var0) throws IOException {
      int var1 = var0.readInt();
      int var2 = var0.readInt();
      if (var1 == txl.N && var2 == OUT) {
         double[] var3 = new double[var1];
         double[] var4 = new double[var1];

         for (int var5 = 0; var5 < var1; var5++) {
            var3[var5] = var0.readFloat();
            var4[var5] = var0.readFloat();
         }

         tbx var7 = tbx.read(var0);
         if (var7.in == var1 && var7.out == OUT) {
            txv var6 = new txv(var7);
            System.arraycopy(var3, 0, var6.mu, 0, var1);
            System.arraycopy(var4, 0, var6.sd, 0, var1);
            return var6;
         } else {
            throw new IOException(a.b("툨ꮏ⅑뼧㒻뉙ࠑ臩ᾧ锃", -1834888619));
         }
      } else {
         throw new IOException(a.d("뒹촋䟐\ud9e5剿퓌溔\ue764礲\uf3cf瑊踨è饘\u1311闦⾨ꀷ㫓범㕮伸쇀婂\udc26图\uef5c愘", -1040571682, -1129867756));
      }
   }

   public txv copy() {
      txv var1 = new txv(this.net.copy());
      System.arraycopy(this.mu, 0, var1.mu, 0, this.mu.length);
      System.arraycopy(this.sd, 0, var1.sd, 0, this.sd.length);
      return var1;
   }
}
