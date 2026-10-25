package a;

import flow.dev.a;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.PlayerInput;

public abstract class pnc extends kfe {
   protected efz driver;

   protected pnc(String var1, String var2, kfa var3) {
      super(var1, var2, var3);
   }

   public void attachBot(efz var1) {
      this.driver = var1;
   }

   public boolean isBotInstance() {
      return this.driver != null;
   }

   public void setBotRunning(boolean var1) {
      this.setEnabledSilently(var1);
   }

   @Override
   public void setEnabled(boolean var1) {
      if (this.driver != null) {
         this.setEnabledSilently(var1);
      } else {
         super.setEnabled(var1);
      }
   }

   protected ClientPlayerEntity getPlayer() {
      return this.mc.field_1724;
   }

   protected ClientWorld getWorld() {
      return this.mc.field_1687;
   }

   protected ClientPlayNetworkHandler getNetworkHandler() {
      return this.mc.method_1562();
   }

   protected ClientPlayerInteractionManager getInteractionManager() {
      return this.mc.field_1761;
   }

   protected boolean isNotInWorld() {
      return this.mc.field_1724 == null || this.mc.field_1687 == null;
   }

   protected boolean heldByHuman(KeyBinding var1) {
      if (this.driver != null) {
         return this.driver.heldByHuman(var1);
      } else if (var1 != null && this.mc.method_22683() != null) {
         try {
            return vzz.isPhysicallyDown(this.mc, var1);
         } catch (RuntimeException var3) {
            return false;
         }
      } else {
         return false;
      }
   }

   protected void silenceMovement() {
      GameOptions var1 = this.mc.field_1690;
      ClientPlayerEntity var2 = this.mc.field_1724;
      if (var1 != null && var2 != null) {
         var1.field_1894.method_23481(false);
         var1.field_1881.method_23481(false);
         var1.field_1913.method_23481(false);
         var1.field_1849.method_23481(false);
         var1.field_1903.method_23481(false);
         var1.field_1867.method_23481(false);
         if (var2.method_5624()) {
            var2.method_5728(false);
         }
      }
   }

   protected boolean isMovementSilent() {
      ClientPlayerEntity var1 = this.mc.field_1724;
      if (var1 != null && var1.field_3913 != null) {
         PlayerInput var2 = var1.field_3913.field_54155;
         return !var1.method_5624()
            && !var2.comp_3159()
            && !var2.comp_3160()
            && !var2.comp_3161()
            && !var2.comp_3162()
            && !var2.comp_3163()
            && !var2.comp_3165();
      } else {
         return false;
      }
   }

   protected void notifyUser(String var1, boolean var2) {
      var1 = wap.t(var1);
      if (this.driver != null) {
         this.driver.report(this.getName() + a.d("쎃먨", 986616081, 231690922) + var1, var2);
      } else {
         try {
            izx.alert(this.getName(), var1, vhz.INFO, var2);
         } catch (Throwable var4) {
         }
      }
   }
}
