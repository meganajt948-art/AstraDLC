package a;

import net.minecraft.item.ItemStack;

public final class vuc {
   private final int vud;
   private final int vue;
   private final ItemStack vuf;

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
