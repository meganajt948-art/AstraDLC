package a;

import java.util.Random;

public final class psc {
   public double wide = 0.55;
   public double radius = 1.3;
   public double wobble = 0.15;

   public static psc of(long var0) {
      Random var2 = new Random(var0 ^ 7640891576956012809L);
      psc var3 = new psc();
      var3.wide = 0.42 + var2.nextDouble() * 0.3;
      var3.radius = 0.9 + var2.nextDouble() * 1.0;
      var3.wobble = 0.05 + var2.nextDouble() * 0.2;
      return var3;
   }
}
