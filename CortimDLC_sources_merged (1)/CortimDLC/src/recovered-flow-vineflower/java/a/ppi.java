package a;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

final class ppi {
   final ItemStack stack;
   private String ppj;
   private String ppk;

   ppi(ItemStack var1) {
      this.stack = var1;
   }

   boolean is(Item... var1) {
      for (Item var5 : var1) {
         if (this.stack.method_31574(var5)) {
            return true;
         }
      }

      return false;
   }

   String name() {
      if (this.ppj == null) {
         this.ppj = ppu.norm(this.stack.method_7964().getString());
      }

      return this.ppj;
   }

   String lore() {
      if (this.ppk == null) {
         StringBuilder var1 = new StringBuilder();
         LoreComponent var2 = (LoreComponent)this.stack.method_58694(DataComponentTypes.field_49632);
         if (var2 != null) {
            for (Text var4 : var2.comp_2400()) {
               var1.append(var4.getString()).append('\n');
            }
         }

         this.ppk = ppu.norm(var1.toString());
      }

      return this.ppk;
   }

   boolean named(String... var1) {
      String var2 = this.name();

      for (String var6 : var1) {
         if (!var2.contains(var6)) {
            return false;
         }
      }

      return true;
   }

   boolean says(String var1) {
      return this.name().contains(var1) || this.lore().contains(var1);
   }

   boolean potion() {
      return this.is(Items.field_8574, Items.field_8436, Items.field_8150);
   }
}
