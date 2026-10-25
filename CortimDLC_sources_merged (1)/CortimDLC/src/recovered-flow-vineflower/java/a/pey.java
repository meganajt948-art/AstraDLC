package a;

import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public final class pey {
   final ItemStack pez;
   String pfa;

   public pey(ItemStack var1) {
      this.pez = var1;
   }

   public ItemStack stack() {
      return this.pez;
   }

   public String lore() {
      if (this.pfa == null) {
         List var1 = pfd.tooltip(this.pez);
         StringBuilder var2 = new StringBuilder();

         for (int var3 = 1; var3 < var1.size(); var3++) {
            if (var2.length() > 0) {
               var2.append('\n');
            }

            var2.append(pfl.normalize(((Text)var1.get(var3)).getString()));
         }

         this.pfa = var2.toString();
      }

      return this.pfa;
   }
}
