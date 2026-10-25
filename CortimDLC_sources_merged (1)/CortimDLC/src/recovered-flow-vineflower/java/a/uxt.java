package a;

public enum uxt {
   AURORA("Aurora", -7709441, -2513153, 1.0F, 0.34F),
   NEBULA("Nebula", -10914817, -42561, 1.0F, 0.16F),
   GALAXY("Galaxy", -9200897, -1654785, 1.0F, 0.08F),
   SUNSET("Sunset", -29632, -45696, 0.6F, 0.36F),
   CLOUDS("Clouds", -10904833, -1, 0.0F, 0.62F);

   public final String title;
   public final int color1;
   public final int color2;
   public final float stars;
   public final float luminance;
   private static final long uxu = System.nanoTime();

   private uxt(String var3, int var4, int var5, float var6, float var7) {
      this.title = var3;
      this.color1 = var4;
      this.color2 = var5;
      this.stars = var6;
      this.luminance = var7;
   }

   public int id() {
      return this.ordinal() + 1;
   }

   public static uxt of(String var0) {
      for (uxt var4 : values()) {
         if (var4.title.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return AURORA;
   }

   public static String[] titles() {
      uxt[] var0 = values();
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2].title;
      }

      return var1;
   }

   public static float time() {
      return (float)(System.nanoTime() - uxu) / 1.0E9F;
   }
}
