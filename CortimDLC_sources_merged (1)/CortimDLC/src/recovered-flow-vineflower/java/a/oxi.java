package a;

import net.minecraft.item.ItemStack;

public final class oxi {
   final String oxj;
   final String oxk;
   final ItemStack oxl;
   final int oxm;
   final int oxn;
   final float oxo;
   final long oxp;
   final boolean oxq;

   public oxi(String id, String name, ItemStack icon, int count, int key, float cooldown, long usedAt, boolean active) {
      this.oxj = id;
      this.oxk = name;
      this.oxl = icon;
      this.oxm = count;
      this.oxn = key;
      this.oxo = cooldown;
      this.oxp = usedAt;
      this.oxq = active;
   }

   public String id() {
      return this.oxj;
   }

   public String name() {
      return this.oxk;
   }

   public ItemStack icon() {
      return this.oxl;
   }

   public int count() {
      return this.oxm;
   }

   public int key() {
      return this.oxn;
   }

   public float cooldown() {
      return this.oxo;
   }

   public long usedAt() {
      return this.oxp;
   }

   public boolean active() {
      return this.oxq;
   }
}
