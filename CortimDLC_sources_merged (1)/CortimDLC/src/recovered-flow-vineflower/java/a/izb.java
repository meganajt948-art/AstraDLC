package a;

import net.minecraft.item.ItemStack;

final class izb {
   private final String izc;
   private final ItemStack izd;
   private final String ize;
   private final long izf;
   private final float izg;

   izb(String key, ItemStack stack, String name, long endsAt, float totalSeconds) {
      this.izc = key;
      this.izd = stack;
      this.ize = name;
      this.izf = endsAt;
      this.izg = totalSeconds;
   }

   float seconds() {
      return Math.max(0.0F, (float)(this.izf - System.nanoTime()) / 1.0E9F);
   }

   float fraction() {
      return Math.min(1.0F, this.seconds() / Math.max(0.05F, this.izg));
   }

   public String key() {
      return this.izc;
   }

   public ItemStack stack() {
      return this.izd;
   }

   public String name() {
      return this.ize;
   }

   public long endsAt() {
      return this.izf;
   }

   public float totalSeconds() {
      return this.izg;
   }
}
