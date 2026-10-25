package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.PlayerInput;

public final class vyn {
   static final Field vyo = vxr.find(
      ClientPlayerEntity.class,
      a.c(-19559334, "谣\uf599罛\ue170櫤\uec51嘅\udfff䆦쬆䳆뚰㡵ꆞ⮀굾\u173c飿Ɍ萱ථ矼淚"),
      a.b("⸇垹\udd66䌞죁之\uf472綂\ue3d8業\ueebd", -619368854),
      a.b("䛎㽝떅⯥ꁩ⚚鳍ᔻ譯ǘ蘚籸\uf2a8欋\ue103枾\uddfe刢좃仒윉봶㎄ꡔ⸢꓾ᵃ", 1580680857)
   );
   static int vyp;
   final wdt vyq = new wdt();
   final boolean vyr;
   boolean vys;
   boolean vyt;
   boolean vyu;

   public vyn() {
      this(false);
   }

   public vyn(boolean var1) {
      this.vyr = var1;
   }

   public boolean idle(ClientPlayerEntity var1) {
      return this.vyr ? vyx(var1, true) : serverIdle(var1);
   }

   public static boolean serverIdle(ClientPlayerEntity var0) {
      return vyx(var0, false);
   }

   static boolean vyx(ClientPlayerEntity var0, boolean var1) {
      if (wdt.serverSprinting(var0)) {
         return false;
      }

      Object var2 = var0.input.playerInput;
      if (vyo != null) {
         try {
            var2 = vyo.get(var0);
         } catch (IllegalAccessException | RuntimeException var4) {
         }
      }

      return var1 && var2 instanceof PlayerInput var3
         ? !var3.forward() && !var3.backward() && !var3.left() && !var3.right() && !var3.jump() && !var3.sprint()
         : PlayerInput.DEFAULT.equals(var2);
   }

   public static boolean still(ClientPlayerEntity var0) {
      double var1 = var0.getX() - var0.lastX;
      double var3 = var0.getZ() - var0.lastZ;
      return var0.isOnGround() && var1 * var1 + var3 * var3 < 9.0E-4;
   }

   public static PlayerInput lastSent(ClientPlayerEntity var0) {
      if (vyo != null) {
         try {
            if (vyo.get(var0) instanceof PlayerInput var1) {
               return var1;
            }
         } catch (IllegalAccessException | RuntimeException var3) {
         }
      }

      return var0.input.playerInput;
   }

   public boolean isHeld() {
      return this.vys;
   }

   public static boolean anyHeld() {
      return vyp > 0;
   }

   public void hold(MinecraftClient var1) {
      GameOptions var2 = var1.options;

      for (KeyBinding var6 : vyy(var2)) {
         var6.setPressed(false);
      }

      KeyBinding var7 = var2.sneakKey;
      if (this.vyr) {
         vwy.sneakOk(true);
      } else if (var2.getSneakToggled().getValue()) {
         if (var7.isPressed()) {
            var7.setPressed(true);
            this.vyt = true;
         }
      } else {
         var7.setPressed(false);
      }

      KeyBinding var8 = var2.sprintKey;
      if (var2.getSprintToggled().getValue()) {
         if (var8.isPressed()) {
            var8.setPressed(true);
            this.vyu = true;
         }
      } else {
         var8.setPressed(false);
      }

      this.vyq.hold(var1);
      if (!this.vys) {
         vyp++;
      }

      this.vys = true;
   }

   public void release(MinecraftClient var1) {
      if (this.vys) {
         this.vys = false;
         vyp = Math.max(0, vyp - 1);
         if (this.vyr) {
            vwy.sneakOk(false);
         }

         if (var1 != null && var1.options != null && var1.getWindow() != null) {
            GameOptions var2 = var1.options;

            for (KeyBinding var6 : vyy(var2)) {
               var6.setPressed(vzz.isPhysicallyDown(var1, var6));
            }

            KeyBinding var7 = var2.sneakKey;
            if (!this.vyr) {
               if (var2.getSneakToggled().getValue()) {
                  if (this.vyt && !var7.isPressed()) {
                     var7.setPressed(true);
                  }
               } else {
                  var7.setPressed(vzz.isPhysicallyDown(var1, var7));
               }
            }

            this.vyt = false;
            KeyBinding var8 = var2.sprintKey;
            if (var2.getSprintToggled().getValue()) {
               if (this.vyu && !var8.isPressed()) {
                  var8.setPressed(true);
               }
            } else {
               var8.setPressed(vzz.isPhysicallyDown(var1, var8));
            }

            this.vyu = false;
            this.vyq.release(var1);
         } else {
            this.vyt = false;
            this.vyu = false;
            this.vyq.release(var1);
         }
      }
   }

   static KeyBinding[] vyy(GameOptions var0) {
      return new KeyBinding[]{var0.forwardKey, var0.backKey, var0.leftKey, var0.rightKey, var0.jumpKey, var0.useKey};
   }
}
