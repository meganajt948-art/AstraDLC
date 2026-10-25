package a;

import net.minecraft.client.network.ClientPlayerEntity;

public final class lnb {
   private double lnc;
   private double lnd = Double.NaN;

   public void reset() {
      this.lnc = 0.0;
      this.lnd = Double.NaN;
   }

   public void update(ClientPlayerEntity var1) {
      double var2 = var1.getY();
      double var4 = Double.isNaN(this.lnd) ? 0.0 : var2 - this.lnd;
      this.lnd = var2;
      if (var4 > 0.0 || var4 < -4.0) {
         this.lnc = 0.0;
      } else if (var4 < 0.0 && !var1.isTouchingWater()) {
         this.lnc -= var4;
      }

      this.lnc = Math.min(this.lnc, var1.fallDistance);
   }

   public void landed() {
      this.lnc = 0.0;
   }

   public double get() {
      return this.lnc;
   }
}
