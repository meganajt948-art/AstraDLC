package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public final class wdq {
   private wdq() {
   }

   public static void swap(MinecraftClient var0, int var1, int var2) {
      click(var0, var1, var2);
      close(var0);
   }

   public static void click(MinecraftClient var0, int var1, int var2) {
      ClientPlayerEntity var3 = var0.player;
      var0.interactionManager.clickSlot(var3.playerScreenHandler.syncId, slotId(var1), var2, SlotActionType.SWAP, var3);
   }

   public static void close(MinecraftClient var0) {
      if (!(var0.currentScreen instanceof HandledScreen)) {
         ClientPlayerEntity var1 = var0.player;
         var1.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(var1.playerScreenHandler.syncId));
      }
   }

   public static int slotId(int var0) {
      return var0 < 9 ? 36 + var0 : var0;
   }

   public static int slotId(ScreenHandler var0, Inventory var1, int var2) {
      for (Slot var4 : var0.slots) {
         if (var4.inventory == var1 && var4.getIndex() == var2) {
            return var4.id;
         }
      }

      return -1;
   }

   public static boolean canClick(ClientPlayerEntity var0) {
      return var0 != null
         && var0.isAlive()
         && !var0.isSpectator()
         && var0.currentScreenHandler == var0.playerScreenHandler
         && var0.playerScreenHandler.getCursorStack().isEmpty();
   }
}
