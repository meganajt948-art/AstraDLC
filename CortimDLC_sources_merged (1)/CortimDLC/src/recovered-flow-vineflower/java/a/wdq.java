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
      ClientPlayerEntity var3 = var0.field_1724;
      var0.field_1761.method_2906(var3.field_7498.field_7763, slotId(var1), var2, SlotActionType.field_7791, var3);
   }

   public static void close(MinecraftClient var0) {
      if (!(var0.field_1755 instanceof HandledScreen)) {
         ClientPlayerEntity var1 = var0.field_1724;
         var1.field_3944.method_52787(new CloseHandledScreenC2SPacket(var1.field_7498.field_7763));
      }
   }

   public static int slotId(int var0) {
      return var0 < 9 ? 36 + var0 : var0;
   }

   public static int slotId(ScreenHandler var0, Inventory var1, int var2) {
      for (Slot var4 : var0.field_7761) {
         if (var4.field_7871 == var1 && var4.method_34266() == var2) {
            return var4.field_7874;
         }
      }

      return -1;
   }

   public static boolean canClick(ClientPlayerEntity var0) {
      return var0 != null && var0.method_5805() && !var0.method_7325() && var0.field_7512 == var0.field_7498 && var0.field_7498.method_34255().method_7960();
   }
}
