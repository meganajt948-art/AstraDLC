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
      return this.mc.player;
   }

   protected ClientWorld getWorld() {
      return this.mc.world;
   }

   protected ClientPlayNetworkHandler getNetworkHandler() {
      return this.mc.getNetworkHandler();
   }

   protected ClientPlayerInteractionManager getInteractionManager() {
      return this.mc.interactionManager;
   }

   protected boolean isNotInWorld() {
      return this.mc.player == null || this.mc.world == null;
   }

   protected boolean heldByHuman(KeyBinding var1) {
      if (this.driver != null) {
         return this.driver.heldByHuman(var1);
      }

      if (var1 != null && this.mc.getWindow() != null) {
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
      GameOptions var1 = this.mc.options;
      ClientPlayerEntity var2 = this.mc.player;
      if (var1 != null && var2 != null) {
         var1.forwardKey.setPressed(false);
         var1.backKey.setPressed(false);
         var1.leftKey.setPressed(false);
         var1.rightKey.setPressed(false);
         var1.jumpKey.setPressed(false);
         var1.sprintKey.setPressed(false);
         if (var2.isSprinting()) {
            var2.setSprinting(false);
         }
      }
   }

   protected boolean isMovementSilent() {
      ClientPlayerEntity var1 = this.mc.player;
      if (var1 != null && var1.input != null) {
         PlayerInput var2 = var1.input.playerInput;
         return !var1.isSprinting() && !var2.forward() && !var2.backward() && !var2.left() && !var2.right() && !var2.jump() && !var2.sprint();
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
