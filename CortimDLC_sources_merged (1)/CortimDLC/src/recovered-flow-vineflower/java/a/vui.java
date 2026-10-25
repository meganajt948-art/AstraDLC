package a;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.apache.commons.lang3.math.Fraction;

public final class vui {
   private vui() {
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static int slotId(EquipmentSlot var0) {
      return switch (var0) {
         case field_6169 -> 5;
         case field_6174 -> 6;
         case field_6172 -> 7;
         default -> 8;
      };
   }

   public static EquipmentSlot wornIn(ItemStack var0) {
      if (var0.method_7960()) {
         return null;
      } else {
         EquippableComponent var1 = (EquippableComponent)var0.method_58694(DataComponentTypes.field_54196);
         if (var1 == null) {
            return null;
         } else {
            EquipmentSlot var2 = var1.comp_3174();
            return var2 != EquipmentSlot.field_6169 && var2 != EquipmentSlot.field_6174 && var2 != EquipmentSlot.field_6172 && var2 != EquipmentSlot.field_6166
               ? null
               : var2;
         }
      }
   }

   public static int left(ItemStack var0) {
      return var0.method_7963() ? var0.method_7936() - var0.method_7919() : Integer.MAX_VALUE;
   }

   public static vuc best(PlayerInventory var0, boolean var1, ToIntFunction<ItemStack> var2) {
      vuc var3 = null;
      int var4 = 0;

      for (int var5 = 0; var5 < 36; var5++) {
         ItemStack var6 = var0.method_5438(var5);
         int var7 = var2.applyAsInt(var6);
         if (var7 > var4) {
            var3 = new vuc(var5, -1, var6);
            var4 = var7;
         }

         if (var1) {
            BundleContentsComponent var8 = vvn.contents(var6);
            if (var8 != null) {
               for (int var9 = 0; var9 < var8.method_57426(); var9++) {
                  ItemStack var10 = var8.method_57422(var9);
                  int var11 = var2.applyAsInt(var10);
                  if (var11 > var4) {
                     var3 = new vuc(var5, var9, var10);
                     var4 = var11;
                  }
               }
            }
         }
      }

      return var3;
   }

   public static boolean roomFor(PlayerInventory var0, vuc var1, ItemStack var2) {
      if (!var2.method_7960() && var1.inBundle()) {
         ItemStack var3 = var0.method_5438(var1.index());
         BundleContentsComponent var4 = vvn.contents(var3);
         if (var4 != null) {
            Fraction var5 = Fraction.ONE.subtract(var4.method_57428()).add(Fraction.getFraction(var1.stack().method_7947(), var1.stack().method_7914()));
            if (var5.compareTo(Fraction.getFraction(var2.method_7947(), var2.method_7914())) >= 0) {
               return true;
            }
         }

         return vum(var0) >= 0;
      } else {
         return true;
      }
   }

   public static boolean equip(MinecraftClient var0, EquipmentSlot var1, vuc var2) {
      ClientPlayerEntity var3 = var0.field_1724;
      if (!wdq.canClick(var3)) {
         return false;
      } else {
         PlayerInventory var4 = var3.method_31548();
         int var5 = slotId(var1);
         if (var2.inBundle()) {
            ItemStack var6 = var4.method_5438(var2.index());
            BundleContentsComponent var7 = vvn.contents(var6);
            if (var7 == null || var2.entry() >= var7.method_57426()) {
               return false;
            }

            vun(var0, var2.index(), var2.entry());
            vuo(var0, wdq.slotId(var2.index()), 1);
         } else {
            vuo(var0, wdq.slotId(var2.index()), 0);
         }

         if (vul(var3).method_7960()) {
            return false;
         } else {
            vuo(var0, var5, 0);
            if (!vul(var3).method_7960()) {
               vuo(var0, wdq.slotId(var2.index()), 0);
            }

            if (!vul(var3).method_7960()) {
               int var8 = vum(var4);
               if (var8 >= 0) {
                  vuo(var0, wdq.slotId(var8), 0);
               }
            }

            if (!vul(var3).method_7960()) {
               vuo(var0, var5, 0);
               vuo(var0, wdq.slotId(var2.index()), 0);
            }

            wdq.close(var0);
            return ItemStack.method_7984(var3.method_6118(var1), var2.stack());
         }
      }
   }

   public static boolean takeOff(MinecraftClient var0, EquipmentSlot var1) {
      ClientPlayerEntity var2 = var0.field_1724;
      int var3 = vum(var2.method_31548());
      if (var3 >= 0 && wdq.canClick(var2) && !var2.method_6118(var1).method_7960()) {
         vuo(var0, slotId(var1), 0);
         vuo(var0, wdq.slotId(var3), 0);
         wdq.close(var0);
         return true;
      } else {
         return false;
      }
   }

   public static boolean matches(ItemStack var0, Predicate<ItemStack> var1) {
      return !var0.method_7960() && var1.test(var0);
   }

   private static ItemStack vul(ClientPlayerEntity var0) {
      return var0.field_7498.method_34255();
   }

   private static int vum(PlayerInventory var0) {
      for (int var1 = 9; var1 < 36; var1++) {
         if (var0.method_5438(var1).method_7960()) {
            return var1;
         }
      }

      for (int var2 = 0; var2 < 9; var2++) {
         if (var0.method_5438(var2).method_7960()) {
            return var2;
         }
      }

      return -1;
   }

   private static void vun(MinecraftClient var0, int var1, int var2) {
      ItemStack var3 = var0.field_1724.method_31548().method_5438(var1);
      BundleContentsComponent var4 = vvn.contents(var3);
      int var5 = var4 == null ? -1 : var4.method_61668();
      if (var4 != null && var5 != var2 && (var2 != 0 || var5 >= 0 && var5 < var4.method_57426())) {
         BundleItem.method_61637(var3, var2);
         var0.method_1562().method_52787(new BundleItemSelectedC2SPacket(wdq.slotId(var1), var2));
      }
   }

   private static void vuo(MinecraftClient var0, int var1, int var2) {
      ClientPlayerEntity var3 = var0.field_1724;
      var0.field_1761.method_2906(var3.field_7498.field_7763, var1, var2, SlotActionType.field_7790, var3);
   }
}
