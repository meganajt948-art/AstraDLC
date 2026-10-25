package a;

import net.minecraft.item.ItemStack;

final class iay {
   final String iaz;
   final ItemStack iba;
   final String ibb;
   final String ibc;

   iay(String id, ItemStack icon, String name, String search) {
      this.iaz = id;
      this.iba = icon;
      this.ibb = name;
      this.ibc = search;
   }

   public String id() {
      return this.iaz;
   }

   public ItemStack icon() {
      return this.iba;
   }

   public String name() {
      return this.ibb;
   }

   public String search() {
      return this.ibc;
   }
}
