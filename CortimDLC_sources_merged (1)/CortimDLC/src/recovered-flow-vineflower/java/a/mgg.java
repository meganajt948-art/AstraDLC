package a;

import net.minecraft.screen.slot.Slot;

record mgg(Slot slot, int price) implements Comparable<mgg> {
   private final Slot mgh;
   private final int mgi;

   private mgg(Slot slot, int price) {
      this.mgh = slot;
      this.mgi = price;
   }

   public int compareTo(mgg var1) {
      return Integer.compare(this.mgi, var1.mgi);
   }

   public Slot slot() {
      return this.mgh;
   }

   public int price() {
      return this.mgi;
   }
}
