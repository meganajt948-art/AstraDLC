package a;

import flow.dev.a;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

record kqa(String id, boolean glint, String name) {
   private final String kqb;
   private final boolean kqc;
   private final String kqd;

   private kqa(String id, boolean glint, String name) {
      this.kqb = id;
      this.kqc = glint;
      this.kqd = name;
   }

   static kqa of(ItemStack var0) {
      return new kqa(Registries.field_41178.method_10221(var0.method_7909()).toString(), var0.method_7958(), kqg(var0));
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
      return !var1.method_7960()
         && Registries.field_41178.method_10221(var1.method_7909()).toString().equals(this.kqb)
         && var1.method_7958() == this.kqc
         && kqg(var1).equals(this.kqd);
   }

   Item item() {
      Identifier var1 = Identifier.method_12829(this.kqb);
      return var1 == null ? Items.field_8162 : (Item)Registries.field_41178.method_63535(var1);
   }

   private static String kqg(ItemStack var0) {
      Text var1 = (Text)var0.method_58694(DataComponentTypes.field_49631);
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
