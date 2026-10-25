package a;

import net.minecraft.item.Item;

final class fjo {
   final Item fjp;
   final int fjq;
   final int fjr;
   final boolean fjs;

   fjo(Item item, int count, int price, boolean glint) {
      this.fjp = item;
      this.fjq = count;
      this.fjr = price;
      this.fjs = glint;
   }

   public Item item() {
      return this.fjp;
   }

   public int count() {
      return this.fjq;
   }

   public int price() {
      return this.fjr;
   }

   public boolean glint() {
      return this.fjs;
   }
}
