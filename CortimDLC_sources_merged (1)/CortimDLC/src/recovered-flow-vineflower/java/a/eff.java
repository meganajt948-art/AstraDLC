package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public final class eff {
   private static final MinecraftClient efg = MinecraftClient.method_1551();
   private boolean efh;
   private boolean efi;
   private boolean efj;
   private boolean efk;
   private boolean efl;
   private boolean efm;
   private boolean efn;
   private boolean efo;
   private boolean efp;
   private boolean efq;
   private boolean efr;
   private int efs;
   private int eft;
   private double efu;
   private double efv;

   public boolean isActive() {
      return this.efh;
   }

   public void setActive(boolean var1) {
      if (!var1 && this.efh) {
         this.release();
         this.efi = true;
      }

      this.efh = var1;
   }

   public void setMovement(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      this.efj = var1;
      this.efk = var2;
      this.efl = var3;
      this.efm = var4;
      this.efn = var5;
      this.efo = var6;
      this.efp = var7;
   }

   public void setMouse(boolean var1, boolean var2) {
      if (var1 && !this.efq) {
         this.efs++;
      }

      if (var2 && !this.efr) {
         this.eft++;
      }

      this.efq = var1;
      this.efr = var2;
   }

   public void addLook(double var1, double var3) {
      this.efu += var1;
      this.efv += var3;
   }

   void release() {
      this.efj = false;
      this.efk = false;
      this.efl = false;
      this.efm = false;
      this.efn = false;
      this.efo = false;
      this.efp = false;
      this.efq = false;
      this.efr = false;
      this.efs = 0;
      this.eft = 0;
      this.efu = 0.0;
      this.efv = 0.0;
   }

   void apply(dtv var1) {
      if (efg.field_1724 != null) {
         GameOptions var2 = efg.field_1690;
         if (this.efi) {
            this.efi = false;
            if (!var1.isActive()) {
               for (KeyBinding var6 : new KeyBinding[]{
                  var2.field_1894,
                  var2.field_1881,
                  var2.field_1913,
                  var2.field_1849,
                  var2.field_1903,
                  var2.field_1832,
                  var2.field_1867,
                  var2.field_1886,
                  var2.field_1904
               }) {
                  var6.method_23481(false);
               }
            }
         }

         if (this.efh) {
            boolean var8 = !var1.isActive();
            efy(var2.field_1894, this.efj, var8);
            efy(var2.field_1881, this.efk, var8);
            efy(var2.field_1913, this.efl, var8);
            efy(var2.field_1849, this.efm, var8);
            efy(var2.field_1903, this.efn, var8);
            efy(var2.field_1832, this.efo, var8);
            efy(var2.field_1867, this.efp, var8);
            efy(var2.field_1886, this.efq, var8);
            efy(var2.field_1904, this.efr, var8);

            while (this.efs > 0) {
               edj.click(var2.field_1886);
               this.efs--;
            }

            while (this.eft > 0) {
               edj.click(var2.field_1904);
               this.eft--;
            }

            if (this.efu != 0.0 || this.efv != 0.0) {
               double var9 = var1.mouseMultiplier();
               double var10 = var2.method_42438().method_41753() ? -1.0 : 1.0;
               efg.field_1724.method_5872(this.efu * var9, this.efv * var9 * var10);
               this.efu = 0.0;
               this.efv = 0.0;
            }
         }
      }
   }

   private static void efy(KeyBinding var0, boolean var1, boolean var2) {
      if (var1) {
         var0.method_23481(true);
      } else if (var2) {
         var0.method_23481(false);
      }
   }

   boolean isHeld(KeyBinding var1) {
      if (this.efh && var1 != null && efg.field_1690 != null) {
         GameOptions var2 = efg.field_1690;
         if (var1 == var2.field_1894) {
            return this.efj;
         } else if (var1 == var2.field_1881) {
            return this.efk;
         } else if (var1 == var2.field_1913) {
            return this.efl;
         } else if (var1 == var2.field_1849) {
            return this.efm;
         } else if (var1 == var2.field_1903) {
            return this.efn;
         } else if (var1 == var2.field_1832) {
            return this.efo;
         } else if (var1 == var2.field_1867) {
            return this.efp;
         } else {
            return var1 == var2.field_1886 ? this.efq : var1 == var2.field_1904 && this.efr;
         }
      } else {
         return false;
      }
   }
}
