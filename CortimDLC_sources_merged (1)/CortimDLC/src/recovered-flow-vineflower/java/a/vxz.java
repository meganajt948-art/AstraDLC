package a;

public final class vxz {
   private static final wbu<Double> vya = new wbu<>(var0 -> var0.options.getGamma());

   private vxz() {
   }

   public static boolean override(double var0) {
      return vya.override(var0);
   }

   public static void release() {
      vya.release();
   }

   public static double own() {
      Double var0 = vya.own();
      return var0 == null ? 0.5 : Math.max(0.0, Math.min(1.0, var0));
   }
}
