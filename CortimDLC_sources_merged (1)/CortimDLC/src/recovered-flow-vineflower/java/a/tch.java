package a;

public final class tch {
   final double[] x = new double[32];
   final double[] m = new double[32];
   double[] a1 = new double[0];
   double[] a2 = new double[0];
   final double[] y = new double[4];
   final double[] sum = new double[4];

   void fit(tbx var1) {
      if (this.a1.length != var1.h1) {
         this.a1 = new double[var1.h1];
      }

      if (this.a2.length != var1.h2) {
         this.a2 = new double[var1.h2];
      }
   }
}
