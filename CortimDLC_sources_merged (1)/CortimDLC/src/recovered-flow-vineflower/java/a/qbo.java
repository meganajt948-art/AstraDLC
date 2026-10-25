package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

final class qbo {
   static final int XP_DIAMOND_BLOCKS = 15;
   final ArrayDeque<qbf> qbp = new ArrayDeque<>();
   final List<String> qbq = new ArrayList<>();
   int qbr;
   int qbs;
   int qbt = -1;
   int qbu;
   boolean qbv;
   int qbw = -1;
   int qbx;
   int qby;

   void plan(boolean var1, int var2) {
      this.qbp.clear();
      this.qbq.clear();
      this.qbr = 0;
      this.qbs = 0;
      this.qbt = -1;
      this.qbu = 0;
      this.qbv = false;
      this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
      this.qcb();
      if (var1) {
         this.qbp.add(new qbf(qbi.PLAN_XP, null, null, 0));
      }

      this.qbp.add(new qbf(qbi.KEEP, Items.DIAMOND, Items.DIAMOND_BLOCK, 16));
      this.qbp.add(new qbf(qbi.KEEP, Items.GOLD_INGOT, Items.GOLD_BLOCK, var2));
      this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
   }

   void qcb() {
      this.qbp.add(new qbf(qbi.COMPRESS, Items.GOLD_NUGGET, Items.GOLD_INGOT, 0));
      this.qbp.add(new qbf(qbi.COMPRESS, Items.GOLD_INGOT, Items.GOLD_BLOCK, 0));
      this.qbp.add(new qbf(qbi.COMPRESS, Items.DIAMOND, Items.DIAMOND_BLOCK, 0));
   }

   List<String> notes() {
      return this.qbq;
   }

   boolean xpFailed() {
      return this.qbv;
   }

   boolean tick(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3) {
      if (this.qbr > 0) {
         this.qbr--;
         return false;
      }

      for (int var4 = 0; var4 < 3; var4++) {
         qbf var5 = this.qbp.peek();
         if (var5 == null) {
            return true;
         }

         if (!var3.getCursorStack().isEmpty() && var5.kind != qbi.CLEAR) {
            putBack(var1, var2, var3, -1);
            return false;
         }

         qbl var6 = this.qcc(var1, var2, var3, var5);
         if (var6 != qbl.WAIT && qsw.trace != null) {
            qsw.log(
               a.c(1515772726, "\udb53ꋳ⠳뙅㶀뭥")
                  + var5.kind
                  + (var5.item == null ? "" : a.b("鴜", 2110823741) + var5.item)
                  + a.c(635152340, "Ꟶ")
                  + var6
                  + a.d("㔕䳣옥塏펕啽", -1113159271, -2125218646)
                  + qck(var3)
                  + a.c(1518769935, "霪\ueed4搝舘燳")
                  + var3.getOutputSlot().getStack()
            );
         }

         if (var6 != qbl.DONE && var6 != qbl.FAIL) {
            if (var6 == qbl.WAIT) {
               return false;
            }
         } else {
            if (this.qbp.peek() == var5) {
               this.qbp.poll();
            }

            if (var6 == qbl.FAIL) {
               this.qbp.addFirst(new qbf(qbi.CLEAR, null, null, 0));
            }

            this.qbs = 0;
            this.qbt = -1;
            this.qbu = 0;
         }
      }

      return false;
   }

   qbl qcc(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, qbf var4) {
      List var5 = var3.getInputSlots();

      return switch (var4.kind) {
         case COMPRESS -> this.qcd(var1, var2, var3, var5, var4);
         case UNPACK -> this.qce(var1, var2, var3, var5, var4);
         case SPLIT -> this.qcf(var1, var2, var3, var5, var4);
         case XP -> this.qcg(var1, var2, var3, var5);
         case PLAN_XP -> this.qch(var2, var3);
         case KEEP -> {
            int var6 = count(var3, var2, var4.item);
            if (var6 < var4.amount && count(var3, var2, var4.result) != 0) {
               this.qbp.poll();
               this.qbp.addFirst(new qbf(qbi.UNPACK, var4.result, var4.item, Math.min(count(var3, var2, var4.result), (var4.amount - var6 + 8) / 9)));
               yield qbl.ACT;
            } else {
               yield qbl.DONE;
            }
         }
         case CLEAR -> this.qcj(var1, var2, var3, var5, null);
      };
   }

   qbl qcd(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, qbf var5) {
      if (qcl(var4, var5.item, null)) {
         return this.qcj(var1, var2, var3, var4, var5.item);
      }

      int var6 = count(var3, var2, var5.item);
      int var7 = Integer.MAX_VALUE;
      int var8 = 0;

      for (Slot var10 : var4) {
         var7 = Math.min(var7, var10.getStack().getCount());
         var8 += var10.getStack().getCount();
      }

      if (var6 >= 9 && var7 < 64) {
         Slot var11 = qcs(var3, var2, var5.item);
         if (var11.getStack().getCount() < 9) {
            Slot var13 = qct(var3, var2, var5.item, var11);
            qcq(var1, var2, var3, var13.id, 0, SlotActionType.PICKUP);
            qcq(var1, var2, var3, var11.id, 0, SlotActionType.PICKUP);
            putBack(var1, var2, var3, var13.id);
            return qbl.ACT;
         } else {
            int var12 = var11.id;
            qcq(var1, var2, var3, var12, 0, SlotActionType.PICKUP);
            qcr(var1, var2, var3, var4);
            putBack(var1, var2, var3, var12);
            return qbl.ACT;
         }
      } else if (var7 >= 1) {
         return this.qci(var1, var2, var3, var5.result);
      } else {
         return var8 > 0 ? this.qcj(var1, var2, var3, var4, null) : qbl.DONE;
      }
   }

   qbl qce(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, qbf var5) {
      Slot var6 = (Slot)var4.get(4);
      if (qcl(var4, var5.item, var6)) {
         return this.qcj(var1, var2, var3, var4, null);
      }

      if (!var5.started) {
         var5.started = true;
         int var7 = var6.getStack().getCount();
         if (var7 < var5.amount && count(var3, var2, var5.item) > 0) {
            Slot var8 = qcs(var3, var2, var5.item);
            int var9 = var5.amount - var7;
            qcq(var1, var2, var3, var8.id, 0, SlotActionType.PICKUP);
            if (var3.getCursorStack().getCount() <= var9) {
               qcq(var1, var2, var3, var6.id, 0, SlotActionType.PICKUP);
            } else {
               for (int var10 = 0; var10 < var9; var10++) {
                  qcq(var1, var2, var3, var6.id, 1, SlotActionType.PICKUP);
               }
            }

            putBack(var1, var2, var3, var8.id);
            return qbl.ACT;
         }
      }

      return var6.hasStack() ? this.qci(var1, var2, var3, var5.result) : qbl.DONE;
   }

   qbl qcf(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, qbf var5) {
      Slot var6 = (Slot)var4.get(4);
      if (qcl(var4, var5.item, var6)) {
         return this.qcj(var1, var2, var3, var4, null);
      }

      if (var6.hasStack()) {
         return this.qci(var1, var2, var3, var5.result);
      }

      int var7 = count(var3, var2, var5.result);
      if (count(var3, var2, var5.item) != 0 && (var5.amount <= 0 || var7 < var5.amount)) {
         int var8 = var5.amount > 0 ? (var5.amount - var7 + 8) / 9 : 64;
         Slot var9 = qcs(var3, var2, var5.item);
         qcq(var1, var2, var3, var9.id, 0, SlotActionType.PICKUP);
         if (var3.getCursorStack().getCount() > var8 && var8 <= 12) {
            for (int var10 = 0; var10 < var8; var10++) {
               qcq(var1, var2, var3, var6.id, 1, SlotActionType.PICKUP);
            }
         } else {
            qcq(var1, var2, var3, var6.id, 0, SlotActionType.PICKUP);
         }

         putBack(var1, var2, var3, var9.id);
         return qbl.ACT;
      } else {
         return qbl.DONE;
      }
   }

   qbl qcg(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4) {
      if (this.qbv) {
         return this.qcj(var1, var2, var3, var4, null);
      }

      Slot var5 = (Slot)var4.get(4);
      List var6 = List.of((Slot)var4.get(1), (Slot)var4.get(3), (Slot)var4.get(5), (Slot)var4.get(7));

      for (int var10 : new int[]{0, 2, 6, 8}) {
         if (((Slot)var4.get(var10)).hasStack()) {
            qcq(var1, var2, var3, ((Slot)var4.get(var10)).id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
         }
      }

      if (var5.hasStack() && !var5.getStack().isOf(Items.DIAMOND)) {
         qcq(var1, var2, var3, var5.id, 0, SlotActionType.QUICK_MOVE);
         return qbl.ACT;
      }

      for (Slot var15 : var6) {
         if (var15.hasStack() && !var15.getStack().isOf(Items.GOLD_NUGGET)) {
            qcq(var1, var2, var3, var15.id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
         }
      }

      int var14 = count(var3, var2, Items.DIAMOND);
      int var16 = count(var3, var2, Items.GOLD_NUGGET);
      int var17 = 0;

      for (Slot var11 : var6) {
         if (!var11.hasStack()) {
            var17++;
         }
      }

      if ((var5.hasStack() || var14 != 0) && (var17 <= 0 || var16 >= Math.max(4, var17))) {
         if (var5.getStack().getCount() < 64 && var14 > 0) {
            Slot var20 = qcs(var3, var2, Items.DIAMOND);
            qcq(var1, var2, var3, var20.id, 0, SlotActionType.PICKUP);
            qcq(var1, var2, var3, var5.id, 0, SlotActionType.PICKUP);
            putBack(var1, var2, var3, var20.id);
            return qbl.ACT;
         }

         int var19 = Integer.MAX_VALUE;

         for (Slot var12 : var6) {
            var19 = Math.min(var19, var12.getStack().getCount());
         }

         if (var19 < 64 && var16 >= 4) {
            Slot var23 = qcs(var3, var2, Items.GOLD_NUGGET);
            if (var23.getStack().getCount() < 4) {
               Slot var24 = qct(var3, var2, Items.GOLD_NUGGET, var23);
               qcq(var1, var2, var3, var24.id, 0, SlotActionType.PICKUP);
               qcq(var1, var2, var3, var23.id, 0, SlotActionType.PICKUP);
               putBack(var1, var2, var3, var24.id);
               return qbl.ACT;
            } else {
               qcq(var1, var2, var3, var23.id, 0, SlotActionType.PICKUP);
               qcr(var1, var2, var3, var6);
               putBack(var1, var2, var3, var23.id);
               return qbl.ACT;
            }
         } else if (var5.hasStack() && var19 >= 1) {
            qbl var22 = this.qci(var1, var2, var3, null);
            if (var22 == qbl.FAIL && this.qbs < 0) {
               this.qbv = true;
               this.qbq.add(a.b("黙\ue71c涺\uf3b9硩ﺭ䂞쵲匥\udd81幆ꐳ⫯띅㤌뾇ָ訝Ⴈ銛ὲ攢\uebe5瀽\uf630磱셊䬃퇿垩\udc16⋀겘㕢댺㦟虜ࡌ軮ᝓ鴎\ue381榬\uee17瓎蝹䝿", 546020023));
            }

            return var22;
         } else {
            return this.qcj(var1, var2, var3, var4, null);
         }
      } else {
         return this.qcj(var1, var2, var3, var4, null);
      }
   }

   qbl qch(ClientPlayerEntity var1, CraftingScreenHandler var2) {
      int var3 = count(var2, var1, Items.DIAMOND_BLOCK);
      int var4 = count(var2, var1, Items.DIAMOND);
      int var5 = count(var2, var1, Items.GOLD_BLOCK);
      int var6 = count(var2, var1, Items.GOLD_INGOT);
      int var7 = count(var2, var1, Items.GOLD_NUGGET);
      int var8 = Math.min(15, var3 - 2);
      if (var8 <= 0) {
         this.qbq.add(a.b("笐ʭ衵ᘁ駈᭩ꄱ⣇뚔㰢미䆅쭀囬\udcb2幓\ue002濒\uf515獍", 1067745080));
         return qbl.DONE;
      }

      int var9 = 4 * (var8 * 9 + var4);
      int var10 = var6 * 9 + var7;
      int var11 = Math.max(0, Math.min(var5 - 2, (var9 - var10 + 80) / 81));
      if (var10 + var11 * 81 < 4) {
         this.qbq.add(a.d("釿\ue842抚ﳮ猧\uf181䯛숯屵횸儙꽸▲밎㉍낢૬蕉ῳ", 2107579766, -204502874));
         return qbl.DONE;
      }

      ArrayList var12 = new ArrayList();
      var12.add(new qbf(qbi.UNPACK, Items.DIAMOND_BLOCK, Items.DIAMOND, var8));
      if (var11 > 0) {
         var12.add(new qbf(qbi.UNPACK, Items.GOLD_BLOCK, Items.GOLD_INGOT, var11));
      }

      var12.add(new qbf(qbi.SPLIT, Items.GOLD_INGOT, Items.GOLD_NUGGET, var9));
      var12.add(new qbf(qbi.XP, null, null, 0));
      var12.add(new qbf(qbi.CLEAR, null, null, 0));
      var12.add(new qbf(qbi.COMPRESS, Items.GOLD_NUGGET, Items.GOLD_INGOT, 0));
      var12.add(new qbf(qbi.COMPRESS, Items.GOLD_INGOT, Items.GOLD_BLOCK, 0));
      var12.add(new qbf(qbi.COMPRESS, Items.DIAMOND, Items.DIAMOND_BLOCK, 0));
      this.qbp.poll();

      for (int var13 = var12.size() - 1; var13 >= 0; var13--) {
         this.qbp.addFirst((qbf)var12.get(var13));
      }

      return qbl.DONE;
   }

   qbl qci(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, Item var4) {
      Slot var5 = var3.getOutputSlot();
      ItemStack var6 = var5.getStack();
      boolean var7 = var4 != null
         ? !var6.isOf(var4)
         : var6.isOf(Items.GOLD_NUGGET)
            || var6.isOf(Items.GOLD_INGOT)
            || var6.isOf(Items.GOLD_BLOCK)
            || var6.isOf(Items.DIAMOND)
            || var6.isOf(Items.DIAMOND_BLOCK);
      if (var5.hasStack() && !var7) {
         this.qbs = 0;
         int var8 = qcm(var3.getInputSlots());
         if (var8 == this.qbt) {
            if (++this.qbu >= 3) {
               this.qbq.add(a.c(-1890441319, "⎄娽킙䪊앁䏹吏瀬\uee01悠\ue361ᴂ韍\u0e79营˓뢔㜺귻⯚ꉘ\udc1c嚻쵥䭮에硹\uf652法\ueaf0慅鿦"));
               return qbl.FAIL;
            }
         } else {
            this.qbu = 0;
         }

         this.qbt = var8;
         qcq(var1, var2, var3, var5.id, 0, SlotActionType.QUICK_MOVE);
         this.qbr = qco(var1, var2);
         return qbl.ACT;
      } else if (++this.qbs > qcp(var1, var2)) {
         this.qbs = -1;
         if (var4 != null) {
            this.qbq.add(a.b("↞堨튎䳾윪䇩ﮰ癛\uec19暠\ue566ᬃ闐౪舢", 1126507939) + var4.getName().getString());
         }

         return qbl.FAIL;
      } else {
         return qbl.WAIT;
      }
   }

   qbl qcj(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, Item var5) {
      if (!var3.getCursorStack().isEmpty()) {
         putBack(var1, var2, var3, -1);
         return qbl.ACT;
      }

      for (Slot var7 : var4) {
         if (var7.hasStack() && (var5 == null || !var7.getStack().isOf(var5))) {
            int var8 = var7.getStack().getCount();
            if (var7.id == this.qbw && var8 == this.qbx) {
               if (++this.qby > 4) {
                  this.qbq.add(a.c(1035572653, "醠\ue819抽\uf8ae睥\uf1dd䯺숈尥튄充꼦◩뱝㘁냷ર蔞῟駾ၼ渴\ue08b缽蘆玕쨥䑺\udae1墮퍢ⶰꞍ㹷렯㋯贵̨臩\u1c4a鈇\uecf1曗\ue167箳\uf5b0䱩웗"));
                  return qbl.DONE;
               }
            } else {
               this.qby = 0;
            }

            this.qbw = var7.id;
            this.qbx = var8;
            qcq(var1, var2, var3, var7.id, 0, SlotActionType.QUICK_MOVE);
            return qbl.ACT;
         }
      }

      return qbl.DONE;
   }

   static String qck(CraftingScreenHandler var0) {
      StringBuilder var1 = new StringBuilder(a.c(344476069, "䧿"));

      for (Slot var3 : var0.getInputSlots()) {
         var1.append(var3.getStack().getCount()).append(' ');
      }

      return var1.append(']').toString();
   }

   static boolean qcl(List<Slot> var0, Item var1, Slot var2) {
      for (Slot var4 : var0) {
         if (var4.hasStack() && (!var4.getStack().isOf(var1) || var2 != null && var4 != var2)) {
            return true;
         }
      }

      return false;
   }

   static int qcm(List<Slot> var0) {
      int var1 = 17;

      for (Slot var3 : var0) {
         var1 = var1 * 31 + var3.getStack().getCount();
      }

      return var1;
   }

   static int qcn(MinecraftClient var0, ClientPlayerEntity var1) {
      if (var0.getNetworkHandler() == null) {
         return 100;
      }

      PlayerListEntry var2 = var0.getNetworkHandler().getPlayerListEntry(var1.getUuid());
      return var2 == null ? 100 : Math.max(0, var2.getLatency());
   }

   static int qco(MinecraftClient var0, ClientPlayerEntity var1) {
      return Math.min(14, 3 + qcn(var0, var1) / 50);
   }

   static int qcp(MinecraftClient var0, ClientPlayerEntity var1) {
      return Math.min(100, 30 + qcn(var0, var1) / 20);
   }

   static void qcq(MinecraftClient var0, ClientPlayerEntity var1, ScreenHandler var2, int var3, int var4, SlotActionType var5) {
      var0.interactionManager.clickSlot(var2.syncId, var3, var4, var5, var1);
   }

   static void qcr(MinecraftClient var0, ClientPlayerEntity var1, ScreenHandler var2, List<Slot> var3) {
      qcq(var0, var1, var2, -999, ScreenHandler.packQuickCraftData(0, 0), SlotActionType.QUICK_CRAFT);

      for (Slot var5 : var3) {
         qcq(var0, var1, var2, var5.id, ScreenHandler.packQuickCraftData(1, 0), SlotActionType.QUICK_CRAFT);
      }

      qcq(var0, var1, var2, -999, ScreenHandler.packQuickCraftData(2, 0), SlotActionType.QUICK_CRAFT);
   }

   static void putBack(MinecraftClient var0, ClientPlayerEntity var1, ScreenHandler var2, int var3) {
      for (int var4 = 0; var4 < 4 && !var2.getCursorStack().isEmpty(); var4++) {
         ItemStack var5 = var2.getCursorStack();
         int var6 = -1;
         if (var3 >= 0 && var3 < var2.slots.size()) {
            ItemStack var7 = var2.slots.get(var3).getStack();
            if (var7.isEmpty() || ItemStack.areItemsAndComponentsEqual(var7, var5) && var7.getCount() < var7.getMaxCount()) {
               var6 = var3;
            }
         }

         if (var6 < 0) {
            for (Slot var8 : var2.slots) {
               if (var8.inventory == var1.getInventory()
                  && var8.hasStack()
                  && ItemStack.areItemsAndComponentsEqual(var8.getStack(), var5)
                  && var8.getStack().getCount() < var8.getStack().getMaxCount()) {
                  var6 = var8.id;
                  break;
               }
            }
         }

         if (var6 < 0) {
            for (Slot var11 : var2.slots) {
               if (var11.inventory == var1.getInventory() && !var11.hasStack() && var11.getIndex() < 36) {
                  var6 = var11.id;
                  break;
               }
            }
         }

         qcq(var0, var1, var2, var6 < 0 ? -999 : var6, 0, SlotActionType.PICKUP);
         var3 = -1;
      }
   }

   static int count(ScreenHandler var0, ClientPlayerEntity var1, Item var2) {
      int var3 = 0;

      for (Slot var5 : var0.slots) {
         if (var5.inventory == var1.getInventory() && var5.getStack().isOf(var2)) {
            var3 += var5.getStack().getCount();
         }
      }

      return var3;
   }

   static Slot qcs(ScreenHandler var0, ClientPlayerEntity var1, Item var2) {
      Slot var3 = null;

      for (Slot var5 : var0.slots) {
         if (var5.inventory == var1.getInventory() && var5.getStack().isOf(var2) && (var3 == null || var5.getStack().getCount() > var3.getStack().getCount())) {
            var3 = var5;
         }
      }

      return var3;
   }

   static Slot qct(ScreenHandler var0, ClientPlayerEntity var1, Item var2, Slot var3) {
      Slot var4 = null;

      for (Slot var6 : var0.slots) {
         if (var6 != var3
            && var6.inventory == var1.getInventory()
            && var6.getStack().isOf(var2)
            && (var4 == null || var6.getStack().getCount() < var4.getStack().getCount())) {
            var4 = var6;
         }
      }

      return var4;
   }
}
