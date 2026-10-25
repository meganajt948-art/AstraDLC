package a;

import net.minecraft.client.gui.DrawContext;

public final class unf {
   static Object ung;
   static long unh;
   static long uni;
   static float unj = 0.016666668F;

   unf() {
   }

   public static void observe(DrawContext var0) {
      if (var0 != ung) {
         ung = var0;
         unh++;
         long var1 = System.nanoTime();
         if (uni != 0L) {
            unj = Math.max(0.0F, Math.min(0.2F, (float)(var1 - uni) / 1.0E9F));
         }

         uni = var1;
      }
   }

   public static long frame() {
      return unh;
   }

   public static float delta() {
      return unj;
   }
}
