package a;

import net.minecraft.item.ItemStack;

public record ivx(ItemStack icon, String title, String note, float cooldown, boolean usable) {
   private final ItemStack ivy;
   private final String ivz;
   private final String iwa;
   private final float iwb;
   private final boolean iwc;

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
