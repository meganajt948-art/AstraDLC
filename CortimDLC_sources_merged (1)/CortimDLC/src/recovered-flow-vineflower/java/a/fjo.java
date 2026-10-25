package a;

import net.minecraft.item.Item;

record fjo(Item item, int count, int price, boolean glint) {
   private final Item fjp;
   private final int fjq;
   private final int fjr;
   private final boolean fjs;

   private fjo(Item item, int count, int price, boolean glint) {
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
