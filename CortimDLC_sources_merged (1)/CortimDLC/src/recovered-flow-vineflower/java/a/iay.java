package a;

import net.minecraft.item.ItemStack;

record iay(String id, ItemStack icon, String name, String search) {
   private final String iaz;
   private final ItemStack iba;
   private final String ibb;
   private final String ibc;

   private iay(String id, ItemStack icon, String name, String search) {
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
