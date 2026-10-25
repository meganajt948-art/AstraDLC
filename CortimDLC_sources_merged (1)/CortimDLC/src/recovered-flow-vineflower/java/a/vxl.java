package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.Generic3x3ContainerScreen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HopperScreen;
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public final class vxl {
   static Field vxm;
   static boolean vxn;

   vxl() {
   }

   public static boolean isStorage(Screen var0) {
      return var0 instanceof GenericContainerScreen
         || var0 instanceof ShulkerBoxScreen
         || var0 instanceof HopperScreen
         || var0 instanceof Generic3x3ContainerScreen;
   }

   public static Slot hovered(HandledScreen<?> var0) {
      if (!vxn) {
         vxn = true;
         vxm = vxr.find(
            HandledScreen.class,
            a.c(-625653279, "䦘〢뫠Ⓥ꽟⧪鎾ᩄ萝ຽ襽猋\ufdce搥\uee3b棅튇嵄쟷䆊젖뉅㳵"),
            a.c(-774200306, "ꑢ\udddc圃쥻䊤쐮縐\uf7e4榴\ue30a"),
            a.c(1664134501, "괳풠幸쀘䮔쵧眰ﻆ悒\uea25淧鞅ᥕ胶૾豃㘃맟⍾ꔯ\u2cf4囋\ud87e䎫엒伍")
         );
      }

      if (vxm == null) {
         return null;
      }

      try {
         return (Slot)vxm.get(var0);
      } catch (IllegalAccessException | RuntimeException var2) {
         return null;
      }
   }

   public static List<Slot> own(ScreenHandler var0, PlayerInventory var1) {
      ArrayList var2 = new ArrayList();

      for (Slot var4 : var0.slots) {
         if (var4.inventory != var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public static Slot room(ScreenHandler var0, PlayerInventory var1, ItemStack var2, boolean var3) {
      for (Slot var5 : var0.slots) {
         if (var5.inventory == var1 && vxq(var5, var3) && var5.hasStack()) {
            ItemStack var6 = var5.getStack();
            if (ItemStack.areItemsAndComponentsEqual(var2, var6) && var6.getCount() < var6.getMaxCount()) {
               return var5;
            }
         }
      }

      for (Slot var8 : var0.slots) {
         if (var8.inventory == var1 && vxq(var8, var3) && !var8.hasStack()) {
            return var8;
         }
      }

      return null;
   }

   static boolean vxq(Slot var0, boolean var1) {
      int var2 = var0.getIndex();
      return var2 >= 9 && var2 < 36 || var1 && var2 >= 0 && var2 < 9;
   }

   public static boolean hasRoom(ScreenHandler var0, PlayerInventory var1, ItemStack var2) {
      return room(var0, var1, var2, true) != null;
   }

   public static void click(MinecraftClient var0, ScreenHandler var1, int var2, int var3, SlotActionType var4) {
      var0.interactionManager.clickSlot(var1.syncId, var2, var3, var4, var0.player);
   }
}
