package a;

import net.minecraft.client.MinecraftClient;

public final class lka {
   static final MinecraftClient lkb = MinecraftClient.getInstance();
   double lkc;
   double lkd;

   double lkg() {
      double var1 = lkb.options.getMouseSensitivity().getValue();
      double var3 = var1 * 0.6 + 0.2;
      double var5 = var3 * var3 * var3 * 1.2;
      return var5 * 0.15;
   }

   public float fix(float var1, boolean var2) {
      double var3 = this.lkg();
      double var5 = var1 + (var2 ? this.lkc : this.lkd);
      long var7 = Math.round(var5 / var3);
      double var9 = var7 * var3;
      double var11 = var5 - var9;
      if (var2) {
         this.lkc = var11;
      } else {
         this.lkd = var11;
      }

      return (float)var9;
   }

   public void reset() {
      this.lkc = 0.0;
      this.lkd = 0.0;
   }
}
