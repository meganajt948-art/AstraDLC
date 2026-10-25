package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.PlayerInput;

public final class vyn {
   private static final Field vyo = vxr.find(
      ClientPlayerEntity.class,
      a.c(-19559334, "谣\uf599罛\ue170櫤\uec51嘅\udfff䆦쬆䳆뚰㡵ꆞ⮀굾\u173c飿Ɍ萱ථ矼淚"),
      a.b("⸇垹\udd66䌞죁之\uf472綂\ue3d8業\ueebd", -619368854),
      a.b("䛎㽝떅⯥ꁩ⚚鳍ᔻ譯ǘ蘚籸\uf2a8欋\ue103枾\uddfe刢좃仒윉봶㎄ꡔ⸢꓾ᵃ", 1580680857)
   );
   private static int vyp;
   private final wdt vyq = new wdt();
   private final boolean vyr;
   private boolean vys;
   private boolean vyt;
   private boolean vyu;

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

   private static boolean vyx(ClientPlayerEntity var0, boolean var1) {
      if (wdt.serverSprinting(var0)) {
         return false;
      } else {
         Object var2 = var0.field_3913.field_54155;
         if (vyo != null) {
            try {
               var2 = vyo.get(var0);
            } catch (RuntimeException | IllegalAccessException var4) {
            }
         }

         return var1 && var2 instanceof PlayerInput var3
            ? !var3.comp_3159() && !var3.comp_3160() && !var3.comp_3161() && !var3.comp_3162() && !var3.comp_3163() && !var3.comp_3165()
            : PlayerInput.field_54098.equals(var2);
      }
   }

   public static boolean still(ClientPlayerEntity var0) {
      double var1 = var0.method_23317() - var0.field_6014;
      double var3 = var0.method_23321() - var0.field_5969;
      return var0.method_24828() && var1 * var1 + var3 * var3 < 9.0E-4;
   }

   public static PlayerInput lastSent(ClientPlayerEntity var0) {
      if (vyo != null) {
         try {
            if (vyo.get(var0) instanceof PlayerInput var1) {
               return var1;
            }
         } catch (RuntimeException | IllegalAccessException var3) {
         }
      }

      return var0.field_3913.field_54155;
   }

   public boolean isHeld() {
      return this.vys;
   }

   public static boolean anyHeld() {
      return vyp > 0;
   }

   public void hold(MinecraftClient var1) {
      GameOptions var2 = var1.field_1690;

      for (KeyBinding var6 : vyy(var2)) {
         var6.method_23481(false);
      }

      KeyBinding var7 = var2.field_1832;
      if (this.vyr) {
         vwy.sneakOk(true);
      } else if ((Boolean)var2.method_42449().method_41753()) {
         if (var7.method_1434()) {
            var7.method_23481(true);
            this.vyt = true;
         }
      } else {
         var7.method_23481(false);
      }

      KeyBinding var8 = var2.field_1867;
      if ((Boolean)var2.method_42450().method_41753()) {
         if (var8.method_1434()) {
            var8.method_23481(true);
            this.vyu = true;
         }
      } else {
         var8.method_23481(false);
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

         if (var1 != null && var1.field_1690 != null && var1.method_22683() != null) {
            GameOptions var2 = var1.field_1690;

            for (KeyBinding var6 : vyy(var2)) {
               var6.method_23481(vzz.isPhysicallyDown(var1, var6));
            }

            KeyBinding var7 = var2.field_1832;
            if (!this.vyr) {
               if ((Boolean)var2.method_42449().method_41753()) {
                  if (this.vyt && !var7.method_1434()) {
                     var7.method_23481(true);
                  }
               } else {
                  var7.method_23481(vzz.isPhysicallyDown(var1, var7));
               }
            }

            this.vyt = false;
            KeyBinding var8 = var2.field_1867;
            if ((Boolean)var2.method_42450().method_41753()) {
               if (this.vyu && !var8.method_1434()) {
                  var8.method_23481(true);
               }
            } else {
               var8.method_23481(vzz.isPhysicallyDown(var1, var8));
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

   private static KeyBinding[] vyy(GameOptions var0) {
      return new KeyBinding[]{var0.field_1894, var0.field_1881, var0.field_1913, var0.field_1849, var0.field_1903, var0.field_1904};
   }
}
