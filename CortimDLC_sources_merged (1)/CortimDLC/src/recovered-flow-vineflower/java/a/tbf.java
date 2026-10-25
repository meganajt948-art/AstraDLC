package a;

public final class tbf {
   public static final int EX = 0;
   public static final int EY = 1;
   public static final int E2X = 2;
   public static final int E2Y = 3;
   public static final int E4X = 4;
   public static final int E4Y = 5;
   public static final int W0X = 6;
   public static final int W0Y = 7;
   public static final int W1X = 8;
   public static final int W1Y = 9;
   public static final int W2X = 10;
   public static final int W2Y = 11;
   public static final int W3X = 12;
   public static final int W3Y = 13;
   public static final int H0X = 14;
   public static final int H0Y = 15;
   public static final int H1X = 16;
   public static final int H1Y = 17;
   public static final int H2X = 18;
   public static final int H2Y = 19;
   public static final int H3X = 20;
   public static final int H3Y = 21;
   public static final int BW = 22;
   public static final int BH = 23;
   public static final int U = 24;
   public static final int V = 25;
   public static final int DIST = 26;
   public static final int CD = 27;
   public static final int LA = 28;
   public static final int RA = 29;
   public static final int TA = 30;
   public static final int BA = 31;
   public static final int S = 32;
   public static final int WX = 6;
   public static final int WY = 7;
   public static final int HIST = 4;
   public static final int N = 32;
   public static final int OUT = 4;
   public static final double C_SCALE = 2.0;
   static final double tbg = 1.5;
   static final int[] tbh = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 24};
   static final int[][] tbi = new int[][]{
      {0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15}, {16, 17}, {18, 19}, {20, 21}, {22, 23}, {28, 30}, {29, 31}
   };

   tbf() {
   }

   public static void raw(double[] var0, double[] var1) {
      double var2 = var0[0];
      double var4 = var0[1];
      var1[0] = var2 / 10.0;
      var1[1] = slog(var2);
      var1[2] = var4 / 10.0;
      var1[3] = slog(var4);
      var1[4] = var0[2] / 10.0;
      var1[5] = var0[3] / 10.0;
      var1[6] = var0[4] / 10.0;
      var1[7] = var0[5] / 10.0;

      for (int var6 = 0; var6 < 8; var6++) {
         var1[8 + var6] = var0[6 + var6] / 3.0;
      }

      for (int var7 = 0; var7 < 8; var7++) {
         var1[16 + var7] = var0[14 + var7] / 5.0;
      }

      var1[24] = var0[22] / 4.0;
      var1[25] = var0[23] / 8.0;
      var1[26] = var0[24];
      var1[27] = var0[25] - 0.5;
      var1[28] = var0[26] / 4.0 - 1.0;
      var1[29] = var0[27] * 2.0 - 1.0;
      var1[30] = Math.tanh(outX(var0) / 1.5);
      var1[31] = Math.tanh(outY(var0) / 1.5);
   }

   public static void features(double[] var0, double[] var1, double[] var2, double[] var3) {
      raw(var0, var3);

      for (int var4 = 0; var4 < 32; var4++) {
         var3[var4] = (var3[var4] - var1[var4]) / var2[var4];
      }
   }

   public static double outX(double[] var0) {
      return Math.max(var0[28] + var0[0], -var0[0] - var0[29]);
   }

   public static double outY(double[] var0) {
      return Math.max(var0[30] + var0[1], -var0[1] - var0[31]);
   }

   public static void backward(double[] var0, double[] var1, double[] var2, double[] var3) {
      double var4 = var0[0];
      double var6 = var0[1];
      double var8 = Math.tanh(outX(var0) / 1.5);
      double var10 = Math.tanh(outY(var0) / 1.5);
      double var12 = var0[28] + var4 >= -var4 - var0[29] ? 1.0 : -1.0;
      double var14 = var0[30] + var6 >= -var6 - var0[31] ? 1.0 : -1.0;
      var3[0] = var2[0] / var1[0] / 10.0 + var2[1] / var1[1] * tbl(var4) + var2[30] / var1[30] * (1.0 - var8 * var8) / 1.5 * var12;
      var3[1] = var2[2] / var1[2] / 10.0 + var2[3] / var1[3] * tbl(var6) + var2[31] / var1[31] * (1.0 - var10 * var10) / 1.5 * var14;
      var3[2] = var2[4] / var1[4] / 10.0;
      var3[3] = var2[5] / var1[5] / 10.0;
      var3[4] = var2[6] / var1[6] / 10.0;
      var3[5] = var2[7] / var1[7] / 10.0;

      for (int var16 = 0; var16 < 8; var16++) {
         var3[14 + var16] = var2[16 + var16] / var1[16 + var16] / 5.0;
      }
   }

   public static void swapAxes(double[] var0) {
      for (int[] var4 : tbi) {
         double var5 = var0[var4[0]];
         var0[var4[0]] = var0[var4[1]];
         var0[var4[1]] = var5;
      }
   }

   public static void mirror(double[] var0, double[] var1) {
      System.arraycopy(var0, 0, var1, 0, 32);

      for (int var5 : tbh) {
         var1[var5] = -var0[var5];
      }

      var1[28] = -var0[29];
      var1[29] = -var0[28];
   }

   public static double slog(double var0) {
      return Math.signum(var0) * Math.log1p(Math.abs(var0) / 0.5) / 3.0;
   }

   static double tbl(double var0) {
      return 1.0 / (3.0 * (0.5 + Math.abs(var0)));
   }
}
