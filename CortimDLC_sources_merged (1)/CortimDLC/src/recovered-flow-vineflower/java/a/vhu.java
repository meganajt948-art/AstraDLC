package a;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;

public final class vhu {
   static vht vhv;
   static vhs vhw;

   vhu() {
   }

   public static void register(vht var0) {
      vhv = var0;
   }

   public static void register(vhs var0) {
      vhw = var0;
   }

   static boolean changesHands() {
      return vhv != null && vhv.active() || vhw != null && vhw.active();
   }

   static void viewModel(MatrixStack var0, Arm var1) {
      if (vhv != null && vhv.active()) {
         vhv.apply(var0, var1);
      }
   }

   static boolean swings(AbstractClientPlayerEntity var0, Hand var1, ItemStack var2) {
      return vhw != null && vhw.active() && vhw.handles(var0, var1, var2);
   }

   static void swing(MatrixStack var0, AbstractClientPlayerEntity var1, Arm var2, Hand var3, float var4, ItemStack var5, float var6) {
      vhw.apply(var0, var1, var2, var3, var4, var5, var6);
   }
}
