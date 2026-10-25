package a;

final class tni {
   final double[] grad;
   final double[][] s = new double[24][32];
   final double[][] x = new double[24][32];
   final double[][] a1;
   final double[][] a2;
   final double[][] y = new double[24][4];
   final double[] ex = new double[25];
   final double[] ey = new double[25];
   final double[] dx = new double[25];
   final double[] dy = new double[25];
   final double[] lEx = new double[25];
   final double[] lEy = new double[25];
   final double[] lDx = new double[25];
   final double[] lDy = new double[25];
   final double[] gEx = new double[25];
   final double[] gEy = new double[25];
   final double[] gDx = new double[25];
   final double[] gDy = new double[25];
   final double[] gy = new double[4];
   final double[] gx = new double[32];
   final double[] gs = new double[32];
   final double[] t1;
   final double[] t2;
   double loss;
   int steps;
   double lambda = 10.0;

   tni(tbx var1) {
      this.grad = new double[var1.size()];
      this.a1 = new double[24][var1.h1];
      this.a2 = new double[24][var1.h2];
      this.t1 = new double[var1.h1];
      this.t2 = new double[var1.h2];
   }
}
