package a;

import flow.dev.a;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

enum kpx {
   TOTEM(a.b("ⶏ吅\udecd䂭쭲", -2114048546)),
   ENCH_TOTEM(a.d("⻗坍\udd93䏩젂予\uf4c0素\ue377", -264319294, 722133081)),
   SPHERE(a.c(1066720112, "\udb25ꊷ⡼똀㷀뭦"));

   final String title;

   kpx(String var3) {
      this.title = var3;
   }

   boolean matches(ItemStack var1) {
      return switch (this) {
         case TOTEM -> var1.isOf(Items.TOTEM_OF_UNDYING) && !var1.hasGlint();
         case ENCH_TOTEM -> var1.isOf(Items.TOTEM_OF_UNDYING) && var1.hasGlint();
         case SPHERE -> var1.isOf(Items.PLAYER_HEAD);
      };
   }

   boolean isTotem() {
      return this != SPHERE;
   }

   static kpx of(vlv var0) {
      for (kpx var4 : values()) {
         if (var0.is(var4.title)) {
            return var4;
         }
      }

      return TOTEM;
   }

   static String[] names() {
      kpx[] var0 = values();
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2].title;
      }

      return var1;
   }
}
