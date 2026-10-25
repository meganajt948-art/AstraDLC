package a;

import net.minecraft.item.ItemStack;

public final class vuc {
   final int vud;
   final int vue;
   final ItemStack vuf;

   public vuc(int index, int entry, ItemStack stack) {
      this.vud = index;
      this.vue = entry;
      this.vuf = stack;
   }

   public boolean inBundle() {
      return this.vue >= 0;
   }

   public int index() {
      return this.vud;
   }

   public int entry() {
      return this.vue;
   }

   public ItemStack stack() {
      return this.vuf;
   }
}
