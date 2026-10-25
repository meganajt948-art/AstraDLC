package a;

import net.minecraft.item.ItemStack;

public final class ivx {
   final ItemStack ivy;
   final String ivz;
   final String iwa;
   final float iwb;
   final boolean iwc;

   public ivx(ItemStack icon, String title, String note, float cooldown, boolean usable) {
      this.ivy = icon;
      this.ivz = title;
      this.iwa = note;
      this.iwb = cooldown;
      this.iwc = usable;
   }

   public ItemStack icon() {
      return this.ivy;
   }

   public String title() {
      return this.ivz;
   }

   public String note() {
      return this.iwa;
   }

   public float cooldown() {
      return this.iwb;
   }

   public boolean usable() {
      return this.iwc;
   }
}
