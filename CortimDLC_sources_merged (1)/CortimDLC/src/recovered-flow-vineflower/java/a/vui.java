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
         case HEAD -> 5;
         case CHEST -> 6;
         case LEGS -> 7;
         default -> 8;
      };
   }

   public static EquipmentSlot wornIn(ItemStack var0) {
      if (var0.isEmpty()) {
         return null;
      }

      EquippableComponent var1 = var0.get(DataComponentTypes.EQUIPPABLE);
      if (var1 == null) {
         return null;
      }

      EquipmentSlot var2 = var1.slot();
      return var2 != EquipmentSlot.HEAD && var2 != EquipmentSlot.CHEST && var2 != EquipmentSlot.LEGS && var2 != EquipmentSlot.FEET ? null : var2;
   }

   public static int left(ItemStack var0) {
      return var0.isDamageable() ? var0.getMaxDamage() - var0.getDamage() : Integer.MAX_VALUE;
   }

   public static vuc best(PlayerInventory var0, boolean var1, ToIntFunction<ItemStack> var2) {
      vuc var3 = null;
      int var4 = 0;

      for (int var5 = 0; var5 < 36; var5++) {
         ItemStack var6 = var0.getStack(var5);
         int var7 = var2.applyAsInt(var6);
         if (var7 > var4) {
            var3 = new vuc(var5, -1, var6);
            var4 = var7;
         }

         if (var1) {
            BundleContentsComponent var8 = vvn.contents(var6);
            if (var8 != null) {
               for (int var9 = 0; var9 < var8.size(); var9++) {
                  ItemStack var10 = var8.get(var9);
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
      if (!var2.isEmpty() && var1.inBundle()) {
         ItemStack var3 = var0.getStack(var1.index());
         BundleContentsComponent var4 = vvn.contents(var3);
         if (var4 != null) {
            Fraction var5 = Fraction.ONE.subtract(var4.getOccupancy()).add(Fraction.getFraction(var1.stack().getCount(), var1.stack().getMaxCount()));
            if (var5.compareTo(Fraction.getFraction(var2.getCount(), var2.getMaxCount())) >= 0) {
               return true;
            }
         }

         return vum(var0) >= 0;
      } else {
         return true;
      }
   }

   public static boolean equip(MinecraftClient var0, EquipmentSlot var1, vuc var2) {
      ClientPlayerEntity var3 = var0.player;
      if (!wdq.canClick(var3)) {
         return false;
      }

      PlayerInventory var4 = var3.getInventory();
      int var5 = slotId(var1);
      if (var2.inBundle()) {
         ItemStack var6 = var4.getStack(var2.index());
         BundleContentsComponent var7 = vvn.contents(var6);
         if (var7 == null || var2.entry() >= var7.size()) {
            return false;
         }

         vun(var0, var2.index(), var2.entry());
         vuo(var0, wdq.slotId(var2.index()), 1);
      } else {
         vuo(var0, wdq.slotId(var2.index()), 0);
      }

      if (vul(var3).isEmpty()) {
         return false;
      }

      vuo(var0, var5, 0);
      if (!vul(var3).isEmpty()) {
         vuo(var0, wdq.slotId(var2.index()), 0);
      }

      if (!vul(var3).isEmpty()) {
         int var8 = vum(var4);
         if (var8 >= 0) {
            vuo(var0, wdq.slotId(var8), 0);
         }
      }

      if (!vul(var3).isEmpty()) {
         vuo(var0, var5, 0);
         vuo(var0, wdq.slotId(var2.index()), 0);
      }

      wdq.close(var0);
      return ItemStack.areItemsEqual(var3.getEquippedStack(var1), var2.stack());
   }

   public static boolean takeOff(MinecraftClient var0, EquipmentSlot var1) {
      ClientPlayerEntity var2 = var0.player;
      int var3 = vum(var2.getInventory());
      if (var3 >= 0 && wdq.canClick(var2) && !var2.getEquippedStack(var1).isEmpty()) {
         vuo(var0, slotId(var1), 0);
         vuo(var0, wdq.slotId(var3), 0);
         wdq.close(var0);
         return true;
      } else {
         return false;
      }
   }

   public static boolean matches(ItemStack var0, Predicate<ItemStack> var1) {
      return !var0.isEmpty() && var1.test(var0);
   }

   private static ItemStack vul(ClientPlayerEntity var0) {
      return var0.playerScreenHandler.getCursorStack();
   }

   private static int vum(PlayerInventory var0) {
      for (int var1 = 9; var1 < 36; var1++) {
         if (var0.getStack(var1).isEmpty()) {
            return var1;
         }
      }

      for (int var2 = 0; var2 < 9; var2++) {
         if (var0.getStack(var2).isEmpty()) {
            return var2;
         }
      }

      return -1;
   }

   private static void vun(MinecraftClient var0, int var1, int var2) {
      ItemStack var3 = var0.player.getInventory().getStack(var1);
      BundleContentsComponent var4 = vvn.contents(var3);
      int var5 = var4 == null ? -1 : var4.getSelectedStackIndex();
      if (var4 != null && var5 != var2 && (var2 != 0 || var5 >= 0 && var5 < var4.size())) {
         BundleItem.setSelectedStackIndex(var3, var2);
         var0.getNetworkHandler().sendPacket(new BundleItemSelectedC2SPacket(wdq.slotId(var1), var2));
      }
   }

   private static void vuo(MinecraftClient var0, int var1, int var2) {
      ClientPlayerEntity var3 = var0.player;
      var0.interactionManager.clickSlot(var3.playerScreenHandler.syncId, var1, var2, SlotActionType.PICKUP, var3);
   }
}
