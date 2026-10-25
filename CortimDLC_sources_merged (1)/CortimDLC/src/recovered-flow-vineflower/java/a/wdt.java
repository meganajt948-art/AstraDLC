package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.effect.StatusEffects;

public final class wdt {
   private static final Field wdu = vxr.find(
      ClientPlayerEntity.class,
      a.b("苐ﭪ熨\uef83搗\ue2a2壶턌何엵䈵롃㚆꽭╳ꎍ\u19cf阌ಿ諂͝礏\uf7be", 1596162729),
      a.d("渃ួ鵢̚装๏둰㶋ꏜ⥥", -2122966181, 124613940),
      a.d("侪", -1387316494, 561935619)
   );
   private static int wdv;
   private static int wdw;
   private boolean wdx;
   private boolean wdy;

   public static boolean anyHeld() {
      return wdv > 0;
   }

   public static boolean serverSprinting(ClientPlayerEntity var0) {
      return vxr.getBoolean(wdu, var0, var0.method_5624());
   }

   public boolean isHeld() {
      return this.wdx;
   }

   public void hold(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (!this.wdx) {
         this.wdy = var2.method_5624() || vxr.getBoolean(wdu, var2, false);
         wdv++;
      }

      var1.field_1690.field_1894.method_23481(false);
      this.wdx = true;
   }

   public void release(MinecraftClient var1) {
      if (this.wdx) {
         this.wdx = false;
         wdv = Math.max(0, wdv - 1);
         if (var1 != null && var1.field_1690 != null && var1.field_1724 != null) {
            KeyBinding var2 = var1.field_1690.field_1894;
            var2.method_23481(vzz.isPhysicallyDown(var1, var2));
            ClientPlayerEntity var3 = var1.field_1724;
            if (this.wdy
               && !lwh.active()
               && !(Boolean)var1.field_1690.method_42450().method_41753()
               && !var1.field_1690.field_1867.method_1434()
               && canResumeSprint(var1, var3)) {
               var1.field_1690.field_1867.method_23481(true);
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
         if (var0.field_1690 != null && var0.method_22683() != null && !(Boolean)var0.field_1690.method_42450().method_41753()) {
            var0.field_1690.field_1867.method_23481(vzz.isPhysicallyDown(var0, var0.field_1690.field_1867));
         }
      }
   }

   public static boolean canResumeSprint(MinecraftClient var0, ClientPlayerEntity var1) {
      return var0.field_1690.field_1894.method_1434()
         && !var0.field_1690.field_1881.method_1434()
         && !var1.method_5715()
         && !var1.method_6115()
         && !var1.field_5976
         && !var1.method_5799()
         && !var1.method_6128()
         && !var1.method_6059(StatusEffects.field_5919)
         && (var1.method_7344().method_7586() > 6 || var1.method_31549().field_7478);
   }
}
