package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.effect.StatusEffects;

public final class wdt {
   static final Field wdu = vxr.find(
      ClientPlayerEntity.class,
      a.b("苐ﭪ熨\uef83搗\ue2a2壶턌何엵䈵롃㚆꽭╳ꎍ\u19cf阌ಿ諂͝礏\uf7be", 1596162729),
      a.d("渃ួ鵢̚装๏둰㶋ꏜ⥥", -2122966181, 124613940),
      a.d("侪", -1387316494, 561935619)
   );
   static int wdv;
   static int wdw;
   boolean wdx;
   boolean wdy;

   public static boolean anyHeld() {
      return wdv > 0;
   }

   public static boolean serverSprinting(ClientPlayerEntity var0) {
      return vxr.getBoolean(wdu, var0, var0.isSprinting());
   }

   public boolean isHeld() {
      return this.wdx;
   }

   public void hold(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (!this.wdx) {
         this.wdy = var2.isSprinting() || vxr.getBoolean(wdu, var2, false);
         wdv++;
      }

      var1.options.forwardKey.setPressed(false);
      this.wdx = true;
   }

   public void release(MinecraftClient var1) {
      if (this.wdx) {
         this.wdx = false;
         wdv = Math.max(0, wdv - 1);
         if (var1 != null && var1.options != null && var1.player != null) {
            KeyBinding var2 = var1.options.forwardKey;
            var2.setPressed(vzz.isPhysicallyDown(var1, var2));
            ClientPlayerEntity var3 = var1.player;
            if (this.wdy && !lwh.active() && !var1.options.getSprintToggled().getValue() && !var1.options.sprintKey.isPressed() && canResumeSprint(var1, var3)) {
               var1.options.sprintKey.setPressed(true);
               wdw = 2;
            }

            this.wdy = false;
         } else {
            this.wdy = false;
         }
      }
   }

   public static void settle(MinecraftClient var0) {
      if (wdw > 0 && --wdw <= 0) {
         if (var0.options != null && var0.getWindow() != null && !var0.options.getSprintToggled().getValue()) {
            var0.options.sprintKey.setPressed(vzz.isPhysicallyDown(var0, var0.options.sprintKey));
         }
      }
   }

   public static boolean canResumeSprint(MinecraftClient var0, ClientPlayerEntity var1) {
      return var0.options.forwardKey.isPressed()
         && !var0.options.backKey.isPressed()
         && !var1.isSneaking()
         && !var1.isUsingItem()
         && !var1.horizontalCollision
         && !var1.isTouchingWater()
         && !var1.isGliding()
         && !var1.hasStatusEffect(StatusEffects.BLINDNESS)
         && (var1.getHungerManager().getFoodLevel() > 6 || var1.getAbilities().allowFlying);
   }
}
