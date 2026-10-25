package flow.dev;

public final class a {
   private static final int MIX;

   private a() {
   }

   public static String b(String var0, int var1) {
      int var2 = var0.length();
      int var3 = MIX;
      char[] var4 = new char[var2];

      for (int var5 = 0; var5 < var2; var5++) {
         int var6 = var1 ^ var5 * var3 ^ var2;
         var4[var5] = (char)(var0.charAt(var5) ^ var6);
      }

      return new String(var4);
   }

   public static String c(int var0, String var1) {
      int var2 = var1.length();
      int var3 = MIX;
      char[] var4 = new char[var2];

      for (int var5 = 0; var5 < var2; var5++) {
         int var6 = var0 ^ var5 * var3 ^ var2;
         var4[var5] = (char)(var1.charAt(var5) ^ var6);
      }

      return new String(var4);
   }

   public static String d(String var0, int var1, int var2) {
      int var3 = var1 ^ var2;
      int var4 = var0.length();
      int var5 = MIX;
      char[] var6 = new char[var4];

      for (int var7 = 0; var7 < var4; var7++) {
         int var8 = var3 ^ var7 * var5 ^ var4;
         var6[var7] = (char)(var0.charAt(var7) ^ var8);
      }

      return new String(var6);
   }

   static {
      char var0 = '鸷';
      short var1 = 31153;
      MIX = var0 << 16 | var1;
   }
}
