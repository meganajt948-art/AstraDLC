package a;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;

public final class qma {
   private int qmb = -1;
   private int qmc = -1;
   private int qmd;
   private boolean qme;

   public boolean active() {
      return this.qmb >= 0;
   }

   public static boolean hungry(ClientPlayerEntity var0) {
      int var1 = var0.getHungerManager().getFoodLevel();
      return var1 <= 14 || var1 < 20 && var0.getHealth() < var0.getMaxHealth() * 0.6F;
   }

   public static boolean canEat(ClientPlayerEntity var0) {
      if (qpw.isFood(var0.getOffHandStack())) {
         return true;
      }

      PlayerInventory var1 = var0.getInventory();

      for (int var2 = 0; var2 < 9; var2++) {
         if (qpw.isFood(var1.getStack(var2))) {
            return true;
         }
      }

      return false;
   }

   public static int stored(ClientPlayerEntity var0) {
      PlayerInventory var1 = var0.getInventory();
      int var2 = qpw.find(var1, Items.GOLDEN_CARROT);
      if (var2 >= 9) {
         return var2;
      }

      for (int var3 = 9; var3 < 36; var3++) {
         if (qpw.isFood(var1.getStack(var3))) {
            return var3;
         }
      }

      return -1;
   }

   public boolean start(ClientPlayerEntity var1) {
      if (!this.active() && !var1.isUsingItem()) {
         this.qmc = -1;
         if (!qpw.isFood(var1.getOffHandStack())) {
            PlayerInventory var2 = var1.getInventory();
            int var3 = -1;

            for (int var4 = 0; var4 < 9; var4++) {
               if (var2.getStack(var4).isOf(Items.GOLDEN_CARROT) || var3 < 0 && qpw.isFood(var2.getStack(var4))) {
                  var3 = var4;
               }
            }

            if (var3 < 0) {
               return false;
            }

            if (var2.getSelectedSlot() != var3) {
               this.qmc = var2.getSelectedSlot();
               var2.setSelectedSlot(var3);
            }
         }

         this.qmb = 0;
         this.qmd = var1.getHungerManager().getFoodLevel();
         return true;
      } else {
         return false;
      }
   }

   public void startTick(MinecraftClient var1) {
      if (this.active()) {
         var1.options.useKey.setPressed(true);
         this.qme = true;
      }
   }

   public void endTick(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.active()) {
         this.qmb++;
         if (this.qmb == 1 || this.qmb == 12 && !var2.isUsingItem()) {
            Key var3 = KeyBindingHelper.getBoundKeyOf(var1.options.useKey);
            if (!var3.equals(InputUtil.UNKNOWN_KEY)) {
               KeyBinding.onKeyPressed(var3);
            }
         }

         boolean var4 = var2.getHungerManager().getFoodLevel() > this.qmd && !var2.isUsingItem();
         if (var4 || this.qmb > 70 || this.qmb > 24 && !var2.isUsingItem() || !var2.isAlive()) {
            this.stop(var1, var2);
         }
      }
   }

   public void stop(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.qme && var1.options != null && var1.getWindow() != null) {
         var1.options.useKey.setPressed(vzz.isPhysicallyDown(var1, var1.options.useKey));
      }

      this.qme = false;
      if (this.qmc >= 0 && var2 != null) {
         var2.getInventory().setSelectedSlot(this.qmc);
      }

      this.qmc = -1;
      this.qmb = -1;
   }
}
