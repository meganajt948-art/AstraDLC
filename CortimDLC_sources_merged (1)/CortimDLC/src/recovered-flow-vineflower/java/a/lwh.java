package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public class lwh extends kfe {
   private static final int lwi = 7;
   private static lwh lwj;
   private boolean lwk;
   private boolean lwl;

   public lwh() {
      super(a.d("岃┆꿔ㆾ멕㳇蚖ོ鄤ᮏ", 2043464830, -1213755210), a.b("蠦\uf1b4筥\ue50f滟\ue874删\udb82䖊켤䣶늂㱜ꖨ⾢ꥅጐ鲔ٰ耷্玛ﵣ更\ue082橎폸嶿읛䄜", 1527351403), kfa.MOVEMENT);
      lwj = this;
   }

   public static boolean active() {
      return lwj != null && lwj.isEnabled();
   }

   public static boolean wants(MinecraftClient var0, ClientPlayerEntity var1) {
      GameOptions var2 = var0.field_1690;
      return (var1.method_7344().method_7586() >= 7 || var1.method_31549().field_7478)
         && vzz.isPhysicallyDown(var0, var2.field_1894)
         && !vzz.isPhysicallyDown(var0, var2.field_1881)
         && !var2.field_1832.method_1434();
   }

   @Override
   protected void onDisable() {
      this.lwp(this.mc);
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (var1.field_1755 == null && !vyn.anyHeld() && !oxw.busy() && !kvz.busy()) {
         if (!var2.method_7325() && !var2.method_5765() && wants(var1, var2)) {
            this.lwo(var1.field_1690);
         } else {
            this.lwp(var1);
         }
      }
   }

   private void lwo(GameOptions var1) {
      KeyBinding var2 = var1.field_1867;
      if ((Boolean)var1.method_42450().method_41753()) {
         if (!var2.method_1434()) {
            var2.method_23481(true);
            this.lwl = true;
         }
      } else {
         var2.method_23481(true);
      }

      this.lwk = true;
   }

   private void lwp(MinecraftClient var1) {
      if (this.lwk) {
         this.lwk = false;
         if (var1 != null && var1.field_1690 != null && var1.method_22683() != null) {
            KeyBinding var2 = var1.field_1690.field_1867;
            if ((Boolean)var1.field_1690.method_42450().method_41753()) {
               if (this.lwl && var2.method_1434()) {
                  var2.method_23481(true);
               }
            } else {
               var2.method_23481(vzz.isPhysicallyDown(var1, var2));
            }

            this.lwl = false;
         } else {
            this.lwl = false;
         }
      }
   }
}
