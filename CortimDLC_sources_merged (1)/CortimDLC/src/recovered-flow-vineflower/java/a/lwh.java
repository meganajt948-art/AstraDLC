package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public class lwh extends kfe {
   static final int lwi = 7;
   static lwh lwj;
   boolean lwk;
   boolean lwl;

   public lwh() {
      super(a.d("岃┆꿔ㆾ멕㳇蚖ོ鄤ᮏ", 2043464830, -1213755210), a.b("蠦\uf1b4筥\ue50f滟\ue874删\udb82䖊켤䣶늂㱜ꖨ⾢ꥅጐ鲔ٰ耷্玛ﵣ更\ue082橎폸嶿읛䄜", 1527351403), kfa.MOVEMENT);
      lwj = this;
   }

   public static boolean active() {
      return lwj != null && lwj.isEnabled();
   }

   public static boolean wants(MinecraftClient var0, ClientPlayerEntity var1) {
      GameOptions var2 = var0.options;
      return (var1.getHungerManager().getFoodLevel() >= 7 || var1.getAbilities().allowFlying)
         && vzz.isPhysicallyDown(var0, var2.forwardKey)
         && !vzz.isPhysicallyDown(var0, var2.backKey)
         && !var2.sneakKey.isPressed();
   }

   @Override
   protected void onDisable() {
      this.lwp(this.mc);
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var1.currentScreen == null && !vyn.anyHeld() && !oxw.busy() && !kvz.busy()) {
         if (!var2.isSpectator() && !var2.hasVehicle() && wants(var1, var2)) {
            this.lwo(var1.options);
         } else {
            this.lwp(var1);
         }
      }
   }

   void lwo(GameOptions var1) {
      KeyBinding var2 = var1.sprintKey;
      if (var1.getSprintToggled().getValue()) {
         if (!var2.isPressed()) {
            var2.setPressed(true);
            this.lwl = true;
         }
      } else {
         var2.setPressed(true);
      }

      this.lwk = true;
   }

   void lwp(MinecraftClient var1) {
      if (this.lwk) {
         this.lwk = false;
         if (var1 != null && var1.options != null && var1.getWindow() != null) {
            KeyBinding var2 = var1.options.sprintKey;
            if (var1.options.getSprintToggled().getValue()) {
               if (this.lwl && var2.isPressed()) {
                  var2.setPressed(true);
               }
            } else {
               var2.setPressed(vzz.isPhysicallyDown(var1, var2));
            }

            this.lwl = false;
         } else {
            this.lwl = false;
         }
      }
   }
}
