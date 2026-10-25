package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public final class eff {
   private static final MinecraftClient efg = MinecraftClient.getInstance();
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
      if (efg.player != null) {
         GameOptions var2 = efg.options;
         if (this.efi) {
            this.efi = false;
            if (!var1.isActive()) {
               for (KeyBinding var6 : new KeyBinding[]{
                  var2.forwardKey, var2.backKey, var2.leftKey, var2.rightKey, var2.jumpKey, var2.sneakKey, var2.sprintKey, var2.attackKey, var2.useKey
               }) {
                  var6.setPressed(false);
               }
            }
         }

         if (this.efh) {
            boolean var8 = !var1.isActive();
            efy(var2.forwardKey, this.efj, var8);
            efy(var2.backKey, this.efk, var8);
            efy(var2.leftKey, this.efl, var8);
            efy(var2.rightKey, this.efm, var8);
            efy(var2.jumpKey, this.efn, var8);
            efy(var2.sneakKey, this.efo, var8);
            efy(var2.sprintKey, this.efp, var8);
            efy(var2.attackKey, this.efq, var8);
            efy(var2.useKey, this.efr, var8);

            while (this.efs > 0) {
               edj.click(var2.attackKey);
               this.efs--;
            }

            while (this.eft > 0) {
               edj.click(var2.useKey);
               this.eft--;
            }

            if (this.efu != 0.0 || this.efv != 0.0) {
               double var9 = var1.mouseMultiplier();
               double var10 = var2.getInvertMouseY().getValue() ? -1.0 : 1.0;
               efg.player.changeLookDirection(this.efu * var9, this.efv * var9 * var10);
               this.efu = 0.0;
               this.efv = 0.0;
            }
         }
      }
   }

   private static void efy(KeyBinding var0, boolean var1, boolean var2) {
      if (var1) {
         var0.setPressed(true);
      } else if (var2) {
         var0.setPressed(false);
      }
   }

   boolean isHeld(KeyBinding var1) {
      if (this.efh && var1 != null && efg.options != null) {
         GameOptions var2 = efg.options;
         if (var1 == var2.forwardKey) {
            return this.efj;
         } else if (var1 == var2.backKey) {
            return this.efk;
         } else if (var1 == var2.leftKey) {
            return this.efl;
         } else if (var1 == var2.rightKey) {
            return this.efm;
         } else if (var1 == var2.jumpKey) {
            return this.efn;
         } else if (var1 == var2.sneakKey) {
            return this.efo;
         } else if (var1 == var2.sprintKey) {
            return this.efp;
         } else {
            return var1 == var2.attackKey ? this.efq : var1 == var2.useKey && this.efr;
         }
      } else {
         return false;
      }
   }
}
