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
      int var1 = var0.method_7344().method_7586();
      return var1 <= 14 || var1 < 20 && var0.method_6032() < var0.method_6063() * 0.6F;
   }

   public static boolean canEat(ClientPlayerEntity var0) {
      if (qpw.isFood(var0.method_6079())) {
         return true;
      } else {
         PlayerInventory var1 = var0.method_31548();

         for (int var2 = 0; var2 < 9; var2++) {
            if (qpw.isFood(var1.method_5438(var2))) {
               return true;
            }
         }

         return false;
      }
   }

   public static int stored(ClientPlayerEntity var0) {
      PlayerInventory var1 = var0.method_31548();
      int var2 = qpw.find(var1, Items.field_8071);
      if (var2 >= 9) {
         return var2;
      } else {
         for (int var3 = 9; var3 < 36; var3++) {
            if (qpw.isFood(var1.method_5438(var3))) {
               return var3;
            }
         }

         return -1;
      }
   }

   public boolean start(ClientPlayerEntity var1) {
      if (!this.active() && !var1.method_6115()) {
         this.qmc = -1;
         if (!qpw.isFood(var1.method_6079())) {
            PlayerInventory var2 = var1.method_31548();
            int var3 = -1;

            for (int var4 = 0; var4 < 9; var4++) {
               if (var2.method_5438(var4).method_31574(Items.field_8071) || var3 < 0 && qpw.isFood(var2.method_5438(var4))) {
                  var3 = var4;
               }
            }

            if (var3 < 0) {
               return false;
            }

            if (var2.method_67532() != var3) {
               this.qmc = var2.method_67532();
               var2.method_61496(var3);
            }
         }

         this.qmb = 0;
         this.qmd = var1.method_7344().method_7586();
         return true;
      } else {
         return false;
      }
   }

   public void startTick(MinecraftClient var1) {
      if (this.active()) {
         var1.field_1690.field_1904.method_23481(true);
         this.qme = true;
      }
   }

   public void endTick(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.active()) {
         this.qmb++;
         if (this.qmb == 1 || this.qmb == 12 && !var2.method_6115()) {
            Key var3 = KeyBindingHelper.getBoundKeyOf(var1.field_1690.field_1904);
            if (!var3.equals(InputUtil.field_16237)) {
               KeyBinding.method_1420(var3);
            }
         }

         boolean var4 = var2.method_7344().method_7586() > this.qmd && !var2.method_6115();
         if (var4 || this.qmb > 70 || this.qmb > 24 && !var2.method_6115() || !var2.method_5805()) {
            this.stop(var1, var2);
         }
      }
   }

   public void stop(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.qme && var1.field_1690 != null && var1.method_22683() != null) {
         var1.field_1690.field_1904.method_23481(vzz.isPhysicallyDown(var1, var1.field_1690.field_1904));
      }

      this.qme = false;
      if (this.qmc >= 0 && var2 != null) {
         var2.method_31548().method_61496(this.qmc);
      }

      this.qmc = -1;
      this.qmb = -1;
   }
}
