package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class our extends kfe {
   private static final long ous = 1500L;
   private final vlv out = this.add(
      new vlv(
         a.d("⟬幠풢䫛섒", 371836292, 1154343460),
         a.c(-989054788, "㣮䅗쯴嗇\ude1d墷\ue2e4欍\uf55b翼"),
         a.b("\u009c礥\uf386涵\ue66f情\uda96卿촩䞎", 821952718),
         a.b("뤦삹䩩퐔忋\ud962", 1051965794),
         a.d("刴⮨ꅻ", 1844157367, 562940353)
      )
   );
   private final vmc ouu = this.add(new vmc(a.c(-1911835816, "댘쪚䁚\ude3c嗠"), 1.0, 1.0, 4.0, 1.0).suffix(a.d("㩷䏛줂坻\udcb4", -1336664190, 1026762116)));
   private static Field ouv;
   private static boolean ouw;
   private static our oux;
   private static boolean ouy;
   private static long ouz;

   public our() {
      super(a.c(1827912193, "멀쏖䤗흡岗\uda00恅"), a.d("ᇝ桋\ue28a糼\uf73a熜쮝䈾\udc7a囅턙\u2b74ꗷ㰅뙙キ諨Ա鿉\u19cf逧\uea77擁９礣\uf3ba䨄쑜庣", 278196198, 273481312), kfa.PLAYER);
      if (oux == null) {
         oux = this;
      }
   }

   public static void repairing(MinecraftClient var0) {
      our var1 = oux;
      if (var1 != null && !dry.armed()) {
         int var2 = var1.ouu.getInt();
         dtv var3 = ejp.current();
         if (var3 != null) {
            var3.boostItemUse(var2);
         } else {
            if (!var1.isEnabled()) {
               var1.setEnabled(true);
               ouy = var1.isEnabled();
            }

            if (var1.isEnabled()) {
               ouz = System.currentTimeMillis();
               if (var0.field_1724 != null
                  && (var0.field_1724.method_6047().method_31574(Items.field_8287) || var0.field_1724.method_6079().method_31574(Items.field_8287))) {
                  ovc(var0, var2);
               }
            }
         }
      }
   }

   @Override
   protected void onDisable() {
      ouy = false;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (ouy && System.currentTimeMillis() - ouz > 1500L) {
         ouy = false;
         this.setEnabled(false);
      } else if (var1.field_1724 != null
         && var1.field_1690.field_1904.method_1434()
         && (this.ovd(var1.field_1724.method_6047()) || this.ovd(var1.field_1724.method_6079()))) {
         ovc(var1, this.ouu.getInt());
      }
   }

   private static void ovc(MinecraftClient var0, int var1) {
      if (!ouw) {
         ouw = true;
         ouv = vxr.find(
            MinecraftClient.class,
            a.d("幵⟏괍㌦뢲㸇葓ඩ鏰ᥐ麐擦\uea23珈淪缨앪䪩퀚噧\udffcꖯ⬝", -921164903, 2081586581),
            a.d("슙묧ㇸ꾀\u245fꋕᣨ鄟ག藴", 1791094245, 1530867472),
            a.d("퉽", -775583553, 301947530)
         );
      }

      if (vxr.getInt(ouv, var0, 0) > var1) {
         vxr.setInt(ouv, var0, var1);
      }
   }

   private boolean ovd(ItemStack var1) {
      if (var1.method_7960()) {
         return false;
      } else {
         String var2 = this.out.get();

         return switch (var2) {
            case a.b("寑≍ꢞ", -319071341) -> true;
            case a.b("渕ដ鵚̧裸๑", -770740655) -> var1.method_7909() instanceof BlockItem || var1.method_31574(Items.field_8287);
            default -> var1.method_31574(Items.field_8287);
         };
      }
   }
}
