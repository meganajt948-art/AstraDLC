package a;

import net.minecraft.screen.slot.Slot;

final class mgg implements Comparable<mgg> {
   final Slot mgh;
   final int mgi;

   mgg(Slot slot, int price) {
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
