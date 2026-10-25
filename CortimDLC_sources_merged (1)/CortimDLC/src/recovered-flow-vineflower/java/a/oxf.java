package a;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class oxf {
   public final String id;
   public final String name;
   public final Item item;
   final String match;
   final String server;
   final boolean self;
   boolean thenMace;
   boolean anyItem;
   boolean groundOnly;
   public final vlq key;
   long usedAt;

   oxf(String var1, String var2, Item var3, String var4, String var5, boolean var6) {
      this.id = var1;
      this.name = var2;
      this.item = var3;
      this.match = var4 == null ? null : oxw.pbd(var4);
      this.server = var5;
      this.self = var6;
      this.key = new vlq(var2);
   }

   boolean matches(ItemStack var1) {
      return !var1.isEmpty()
         && (var1.isOf(this.item) || this.anyItem && this.match != null)
         && (this.match == null || oxw.pbd(var1.getName().getString()).contains(this.match));
   }

   boolean potion() {
      return this.match != null && (this.item == Items.SPLASH_POTION || this.item == Items.LINGERING_POTION || this.item == Items.POTION);
   }
}
