package a;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.item.ItemStack;

public final class elq {
   final Set<String> elr = new LinkedHashSet<>();
   final Supplier<List<emu>> els;

   elq(Supplier<List<emu>> var1) {
      this.els = var1;
   }

   public List<emu> entries() {
      return this.els.get();
   }

   public boolean isSelected(emu var1) {
      return var1 != null && this.elr.contains(var1.getName());
   }

   public void toggle(emu var1) {
      if (var1 != null) {
         if (!this.elr.remove(var1.getName())) {
            this.elr.add(var1.getName());
         }
      }
   }

   public int selectedCount() {
      return this.elr.size();
   }

   public void selectAll(boolean var1) {
      this.elr.clear();
      if (var1) {
         for (emu var3 : this.entries()) {
            this.elr.add(var3.getName());
         }
      }
   }

   public int selectWhere(Predicate<emu> var1) {
      this.elr.clear();

      for (emu var3 : this.entries()) {
         if (var1.test(var3)) {
            this.elr.add(var3.getName());
         }
      }

      return this.elr.size();
   }

   public emu match(ItemStack var1) {
      if (var1 != null && !var1.isEmpty() && !this.elr.isEmpty()) {
         String var2 = null;

         for (emu var4 : this.entries()) {
            if (this.elr.contains(var4.getName()) && var1.isOf(var4.getItem())) {
               if (var4.matches(var1)) {
                  return var4;
               }

               if (var2 == null) {
                  var2 = elv(var1.getName().getString());
               }

               String var5 = elv(var4.getSearchQuery());
               if (!var5.isEmpty() && var2.contains(var5)) {
                  return var4;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   static String elv(String var0) {
      if (var0 == null) {
         return "";
      }

      StringBuilder var1 = new StringBuilder(var0.length());

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (var3 == 167) {
            var2++;
         } else if (Character.isLetterOrDigit(var3)) {
            var3 = Character.toLowerCase(var3);
            var1.append(var3 == 1105 ? 'е' : var3);
         }
      }

      return var1.toString();
   }
}
