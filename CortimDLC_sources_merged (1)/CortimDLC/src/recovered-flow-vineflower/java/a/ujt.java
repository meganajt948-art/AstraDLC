package a;

import java.awt.Color;

public final class ujt {
   private ujt() {
   }

   public static int alpha(int var0) {
      return var0 >>> 24 & 0xFF;
   }

   public static int mulAlpha(int var0, float var1) {
      int var2 = Math.round(alpha(var0) * Math.max(0.0F, Math.min(1.0F, var1)));
      return var2 << 24 | var0 & 16777215;
   }

   public static int withAlpha(int var0, int var1) {
      return Math.max(0, Math.min(255, var1)) << 24 | var0 & 16777215;
   }

   public static int lerp(int var0, int var1, float var2) {
      var2 = Math.max(0.0F, Math.min(1.0F, var2));
      int var3 = var0 >>> 24 & 0xFF;
      int var4 = var0 >> 16 & 0xFF;
      int var5 = var0 >> 8 & 0xFF;
      int var6 = var0 & 0xFF;
      int var7 = var1 >>> 24 & 0xFF;
      int var8 = var1 >> 16 & 0xFF;
      int var9 = var1 >> 8 & 0xFF;
      int var10 = var1 & 0xFF;
      return Math.round(var3 + (var7 - var3) * var2) << 24
         | Math.round(var4 + (var8 - var4) * var2) << 16
         | Math.round(var5 + (var9 - var5) * var2) << 8
         | Math.round(var6 + (var10 - var6) * var2);
   }

   public static int hsv(float var0, float var1, float var2) {
      return 0xFF000000 | Color.HSBtoRGB(var0, Math.max(0.0F, Math.min(1.0F, var1)), Math.max(0.0F, Math.min(1.0F, var2))) & 16777215;
   }

   public static float luminance(int var0) {
      return (0.2126F * (var0 >> 16 & 0xFF) + 0.7152F * (var0 >> 8 & 0xFF) + 0.0722F * (var0 & 0xFF)) / 255.0F;
   }

   public static int shade(int var0, float var1) {
      int var2 = Math.min(255, Math.round((var0 >> 16 & 0xFF) * var1));
      int var3 = Math.min(255, Math.round((var0 >> 8 & 0xFF) * var1));
      int var4 = Math.min(255, Math.round((var0 & 0xFF) * var1));
      return var0 & 0xFF000000 | var2 << 16 | var3 << 8 | var4;
   }
}
