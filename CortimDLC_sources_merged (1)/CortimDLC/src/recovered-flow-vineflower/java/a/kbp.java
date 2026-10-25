package a;

public final class kbp {
   public static final float MIN_W = 330.0F;
   public static final float MIN_H = 270.0F;

   private kbp() {
   }

   public static float scale(int var0, int var1) {
      return Math.max(0.05F, Math.min(1.0F, Math.min(var0 / 330.0F, var1 / 270.0F)));
   }
}
