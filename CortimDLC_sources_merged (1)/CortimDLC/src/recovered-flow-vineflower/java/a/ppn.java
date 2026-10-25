package a;

import java.util.function.Predicate;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public final class ppn {
   public final String id;
   public final String name;
   public final String nameEn;
   private final Item ppo;
   private final String ppp;
   private final Predicate<ppi> ppq;
   private ItemStack ppr;

   private ppn(String var1, String var2, String var3, Item var4, String var5, Predicate<ppi> var6) {
      this.id = var1;
      this.name = var2;
      this.nameEn = var3;
      this.ppo = var4;
      this.ppp = var5;
      this.ppq = var6;
   }

   public boolean matches(ItemStack var1) {
      return var1 != null && !var1.isEmpty() && this.ppq.test(new ppi(var1));
   }

   boolean test(ppi var1) {
      return this.ppq.test(var1);
   }

   public String shownName() {
      return wap.s(this.nameEn, this.name);
   }

   public ItemStack icon() {
      if (this.ppr == null) {
         ItemStack var1 = null;
         if (this.ppp != null) {
            for (emu var3 : egl.entries()) {
               if (var3.getName().equals(this.ppp)) {
                  try {
                     var1 = var3.buildStack();
                  } catch (RuntimeException var5) {
                     var1 = null;
                  }
                  break;
               }
            }
         }

         if (var1 == null) {
            var1 = new ItemStack(this.ppo);
         }

         var1.set(DataComponentTypes.CUSTOM_NAME, Text.literal(this.name).styled(var0 -> var0.withItalic(false)));
         this.ppr = var1;
      }

      return this.ppr;
   }
}
