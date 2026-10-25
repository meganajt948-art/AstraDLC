package a;

import java.util.List;
import net.minecraft.item.ItemStack;

public interface ivw {
   String title();

   List<ivx> slots();

   void pick(int var1);

   default boolean editable() {
      return false;
   }

   default void assign(int var1, ItemStack var2) {
   }
}
