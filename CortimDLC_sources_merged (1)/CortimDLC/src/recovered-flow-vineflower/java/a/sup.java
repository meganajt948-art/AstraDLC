package a;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

final class sup {
   final ItemEntity first;
   final ItemStack stack;
   int count;
   String name;
   int color;
   final float[] screen = new float[2];
   double distance;
   int widthStep = -1;
   float nameW;
   String countText;
   float countW;

   sup(ItemEntity var1) {
      this.first = var1;
      this.stack = var1.method_6983();
      this.count = this.stack.method_7947();
   }
}
