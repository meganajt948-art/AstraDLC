package a;

public final class vxu {
   static final long[] vxv = new long[]{1L, 10L, 100L, 1000L, 10000L};

   vxu() {
   }

   public static String fixed(double var0, int var2) {
      int var3 = Math.max(0, Math.min(4, var2));
      long var4 = Math.round(Math.abs(var0) * vxv[var3]);
      StringBuilder var6 = new StringBuilder(12);
      if (var0 < 0.0 && var4 != 0L) {
         var6.append('-');
      }

      var6.append(var4 / vxv[var3]);
      if (var3 > 0) {
         var6.append('.');
         String var7 = Long.toString(var4 % vxv[var3]);

         for (int var8 = var7.length(); var8 < var3; var8++) {
            var6.append('0');
         }

         var6.append(var7);
      }

      return var6.toString();
   }

   public static String clock(long var0) {
      long var2 = Math.max(0L, var0);
      StringBuilder var4 = new StringBuilder(8);
      if (var2 >= 3600L) {
         var4.append(var2 / 3600L).append(':');
         vxy(var4, var2 / 60L % 60L);
      } else {
         var4.append(var2 / 60L);
      }

      var4.append(':');
      vxy(var4, var2 % 60L);
      return var4.toString();
   }

   public static String hoursMinutes(int var0, int var1) {
      StringBuilder var2 = new StringBuilder(5);
      vxy(var2, var0);
      var2.append(':');
      vxy(var2, var1);
      return var2.toString();
   }

   static void vxy(StringBuilder var0, long var1) {
      if (var1 < 10L) {
         var0.append('0');
      }

      var0.append(var1);
   }
}
