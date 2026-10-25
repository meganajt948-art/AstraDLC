package a;

import flow.dev.a;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

final class kqa {
   final String kqb;
   final boolean kqc;
   final String kqd;

   kqa(String id, boolean glint, String name) {
      this.kqb = id;
      this.kqc = glint;
      this.kqd = name;
   }

   static kqa of(ItemStack var0) {
      return new kqa(Registries.ITEM.getId(var0.getItem()).toString(), var0.hasGlint(), kqg(var0));
   }

   static kqa parse(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String[] var1 = var0.split(a.d("᨟掎", -1734657441, -1743577058), 3);
         return new kqa(var1[0], var1.length > 1 && var1[1].equals(a.d("鵚", 457070805, 1630520767)), var1.length > 2 ? var1[2] : "");
      } else {
         return null;
      }
   }

   String text() {
      return this.kqb
         + a.d("폣", -1347921791, 383093535)
         + (this.kqc ? a.d("抨", -1497313896, -984043776) : a.d("⼜", -966173331, -383225280))
         + a.c(-1895962922, "\ue6ab")
         + this.kqd;
   }

   boolean matches(ItemStack var1) {
      return !var1.isEmpty() && Registries.ITEM.getId(var1.getItem()).toString().equals(this.kqb) && var1.hasGlint() == this.kqc && kqg(var1).equals(this.kqd);
   }

   Item item() {
      Identifier var1 = Identifier.tryParse(this.kqb);
      return var1 == null ? Items.AIR : Registries.ITEM.get(var1);
   }

   static String kqg(ItemStack var0) {
      Text var1 = var0.get(DataComponentTypes.CUSTOM_NAME);
      return var1 == null ? "" : var1.getString();
   }

   public String id() {
      return this.kqb;
   }

   public boolean glint() {
      return this.kqc;
   }

   public String name() {
      return this.kqd;
   }
}
