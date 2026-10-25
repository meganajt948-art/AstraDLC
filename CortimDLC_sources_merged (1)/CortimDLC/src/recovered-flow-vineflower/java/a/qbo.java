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
   private final ArrayDeque<qbf> qbp = new ArrayDeque<>();
   private final List<String> qbq = new ArrayList<>();
   private int qbr;
   private int qbs;
   private int qbt = -1;
   private int qbu;
   private boolean qbv;
   private int qbw = -1;
   private int qbx;
   private int qby;

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

      this.qbp.add(new qbf(qbi.KEEP, Items.field_8477, Items.field_8603, 16));
      this.qbp.add(new qbf(qbi.KEEP, Items.field_8695, Items.field_8494, var2));
      this.qbp.add(new qbf(qbi.CLEAR, null, null, 0));
   }

   private void qcb() {
      this.qbp.add(new qbf(qbi.COMPRESS, Items.field_8397, Items.field_8695, 0));
      this.qbp.add(new qbf(qbi.COMPRESS, Items.field_8695, Items.field_8494, 0));
      this.qbp.add(new qbf(qbi.COMPRESS, Items.field_8477, Items.field_8603, 0));
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
      } else {
         for (int var4 = 0; var4 < 3; var4++) {
            qbf var5 = this.qbp.peek();
            if (var5 == null) {
               return true;
            }

            if (!var3.method_34255().method_7960() && var5.kind != qbi.CLEAR) {
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
                     + var3.method_61627().method_7677()
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
   }

   private qbl qcc(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, qbf var4) {
      List var5 = var3.method_61628();

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

   private qbl qcd(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, qbf var5) {
      if (qcl(var4, var5.item, null)) {
         return this.qcj(var1, var2, var3, var4, var5.item);
      } else {
         int var6 = count(var3, var2, var5.item);
         int var7 = Integer.MAX_VALUE;
         int var8 = 0;

         for (Slot var10 : var4) {
            var7 = Math.min(var7, var10.method_7677().method_7947());
            var8 += var10.method_7677().method_7947();
         }

         if (var6 >= 9 && var7 < 64) {
            Slot var11 = qcs(var3, var2, var5.item);
            if (var11.method_7677().method_7947() < 9) {
               Slot var13 = qct(var3, var2, var5.item, var11);
               qcq(var1, var2, var3, var13.field_7874, 0, SlotActionType.field_7790);
               qcq(var1, var2, var3, var11.field_7874, 0, SlotActionType.field_7790);
               putBack(var1, var2, var3, var13.field_7874);
               return qbl.ACT;
            } else {
               int var12 = var11.field_7874;
               qcq(var1, var2, var3, var12, 0, SlotActionType.field_7790);
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
   }

   private qbl qce(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, qbf var5) {
      Slot var6 = (Slot)var4.get(4);
      if (qcl(var4, var5.item, var6)) {
         return this.qcj(var1, var2, var3, var4, null);
      } else {
         if (!var5.started) {
            var5.started = true;
            int var7 = var6.method_7677().method_7947();
            if (var7 < var5.amount && count(var3, var2, var5.item) > 0) {
               Slot var8 = qcs(var3, var2, var5.item);
               int var9 = var5.amount - var7;
               qcq(var1, var2, var3, var8.field_7874, 0, SlotActionType.field_7790);
               if (var3.method_34255().method_7947() <= var9) {
                  qcq(var1, var2, var3, var6.field_7874, 0, SlotActionType.field_7790);
               } else {
                  for (int var10 = 0; var10 < var9; var10++) {
                     qcq(var1, var2, var3, var6.field_7874, 1, SlotActionType.field_7790);
                  }
               }

               putBack(var1, var2, var3, var8.field_7874);
               return qbl.ACT;
            }
         }

         return var6.method_7681() ? this.qci(var1, var2, var3, var5.result) : qbl.DONE;
      }
   }

   private qbl qcf(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, qbf var5) {
      Slot var6 = (Slot)var4.get(4);
      if (qcl(var4, var5.item, var6)) {
         return this.qcj(var1, var2, var3, var4, null);
      } else if (var6.method_7681()) {
         return this.qci(var1, var2, var3, var5.result);
      } else {
         int var7 = count(var3, var2, var5.result);
         if (count(var3, var2, var5.item) != 0 && (var5.amount <= 0 || var7 < var5.amount)) {
            int var8 = var5.amount > 0 ? (var5.amount - var7 + 8) / 9 : 64;
            Slot var9 = qcs(var3, var2, var5.item);
            qcq(var1, var2, var3, var9.field_7874, 0, SlotActionType.field_7790);
            if (var3.method_34255().method_7947() > var8 && var8 <= 12) {
               for (int var10 = 0; var10 < var8; var10++) {
                  qcq(var1, var2, var3, var6.field_7874, 1, SlotActionType.field_7790);
               }
            } else {
               qcq(var1, var2, var3, var6.field_7874, 0, SlotActionType.field_7790);
            }

            putBack(var1, var2, var3, var9.field_7874);
            return qbl.ACT;
         } else {
            return qbl.DONE;
         }
      }
   }

   private qbl qcg(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4) {
      if (this.qbv) {
         return this.qcj(var1, var2, var3, var4, null);
      } else {
         Slot var5 = (Slot)var4.get(4);
         List var6 = List.of((Slot)var4.get(1), (Slot)var4.get(3), (Slot)var4.get(5), (Slot)var4.get(7));

         for (int var10 : new int[]{0, 2, 6, 8}) {
            if (((Slot)var4.get(var10)).method_7681()) {
               qcq(var1, var2, var3, ((Slot)var4.get(var10)).field_7874, 0, SlotActionType.field_7794);
               return qbl.ACT;
            }
         }

         if (var5.method_7681() && !var5.method_7677().method_31574(Items.field_8477)) {
            qcq(var1, var2, var3, var5.field_7874, 0, SlotActionType.field_7794);
            return qbl.ACT;
         } else {
            for (Slot var15 : var6) {
               if (var15.method_7681() && !var15.method_7677().method_31574(Items.field_8397)) {
                  qcq(var1, var2, var3, var15.field_7874, 0, SlotActionType.field_7794);
                  return qbl.ACT;
               }
            }

            int var14 = count(var3, var2, Items.field_8477);
            int var16 = count(var3, var2, Items.field_8397);
            int var17 = 0;

            for (Slot var11 : var6) {
               if (!var11.method_7681()) {
                  var17++;
               }
            }

            if ((var5.method_7681() || var14 != 0) && (var17 <= 0 || var16 >= Math.max(4, var17))) {
               if (var5.method_7677().method_7947() < 64 && var14 > 0) {
                  Slot var20 = qcs(var3, var2, Items.field_8477);
                  qcq(var1, var2, var3, var20.field_7874, 0, SlotActionType.field_7790);
                  qcq(var1, var2, var3, var5.field_7874, 0, SlotActionType.field_7790);
                  putBack(var1, var2, var3, var20.field_7874);
                  return qbl.ACT;
               } else {
                  int var19 = Integer.MAX_VALUE;

                  for (Slot var12 : var6) {
                     var19 = Math.min(var19, var12.method_7677().method_7947());
                  }

                  if (var19 < 64 && var16 >= 4) {
                     Slot var23 = qcs(var3, var2, Items.field_8397);
                     if (var23.method_7677().method_7947() < 4) {
                        Slot var24 = qct(var3, var2, Items.field_8397, var23);
                        qcq(var1, var2, var3, var24.field_7874, 0, SlotActionType.field_7790);
                        qcq(var1, var2, var3, var23.field_7874, 0, SlotActionType.field_7790);
                        putBack(var1, var2, var3, var24.field_7874);
                        return qbl.ACT;
                     } else {
                        qcq(var1, var2, var3, var23.field_7874, 0, SlotActionType.field_7790);
                        qcr(var1, var2, var3, var6);
                        putBack(var1, var2, var3, var23.field_7874);
                        return qbl.ACT;
                     }
                  } else if (var5.method_7681() && var19 >= 1) {
                     qbl var22 = this.qci(var1, var2, var3, null);
                     if (var22 == qbl.FAIL && this.qbs < 0) {
                        this.qbv = true;
                        this.qbq.add(a.b("黙\ue71c涺\uf3b9硩ﺭ䂞쵲匥\udd81幆ꐳ⫯띅㤌뾇ָ訝Ⴈ銛ὲ攢\uebe5瀽\uf630磱셊䬃퇿垩\udc16⋀겘㕢댺㦟虜ࡌ軮ᝓ鴎\ue381榬\uee17瓎蝹䝿", 546020023));
                     }

                     return var22;
                  } else {
                     return this.qcj(var1, var2, var3, var4, null);
                  }
               }
            } else {
               return this.qcj(var1, var2, var3, var4, null);
            }
         }
      }
   }

   private qbl qch(ClientPlayerEntity var1, CraftingScreenHandler var2) {
      int var3 = count(var2, var1, Items.field_8603);
      int var4 = count(var2, var1, Items.field_8477);
      int var5 = count(var2, var1, Items.field_8494);
      int var6 = count(var2, var1, Items.field_8695);
      int var7 = count(var2, var1, Items.field_8397);
      int var8 = Math.min(15, var3 - 2);
      if (var8 <= 0) {
         this.qbq.add(a.b("笐ʭ衵ᘁ駈᭩ꄱ⣇뚔㰢미䆅쭀囬\udcb2幓\ue002濒\uf515獍", 1067745080));
         return qbl.DONE;
      } else {
         int var9 = 4 * (var8 * 9 + var4);
         int var10 = var6 * 9 + var7;
         int var11 = Math.max(0, Math.min(var5 - 2, (var9 - var10 + 80) / 81));
         if (var10 + var11 * 81 < 4) {
            this.qbq.add(a.d("釿\ue842抚ﳮ猧\uf181䯛숯屵횸儙꽸▲밎㉍낢૬蕉ῳ", 2107579766, -204502874));
            return qbl.DONE;
         } else {
            ArrayList var12 = new ArrayList();
            var12.add(new qbf(qbi.UNPACK, Items.field_8603, Items.field_8477, var8));
            if (var11 > 0) {
               var12.add(new qbf(qbi.UNPACK, Items.field_8494, Items.field_8695, var11));
            }

            var12.add(new qbf(qbi.SPLIT, Items.field_8695, Items.field_8397, var9));
            var12.add(new qbf(qbi.XP, null, null, 0));
            var12.add(new qbf(qbi.CLEAR, null, null, 0));
            var12.add(new qbf(qbi.COMPRESS, Items.field_8397, Items.field_8695, 0));
            var12.add(new qbf(qbi.COMPRESS, Items.field_8695, Items.field_8494, 0));
            var12.add(new qbf(qbi.COMPRESS, Items.field_8477, Items.field_8603, 0));
            this.qbp.poll();

            for (int var13 = var12.size() - 1; var13 >= 0; var13--) {
               this.qbp.addFirst((qbf)var12.get(var13));
            }

            return qbl.DONE;
         }
      }
   }

   private qbl qci(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, Item var4) {
      Slot var5 = var3.method_61627();
      ItemStack var6 = var5.method_7677();
      boolean var7 = var4 != null
         ? !var6.method_31574(var4)
         : var6.method_31574(Items.field_8397)
            || var6.method_31574(Items.field_8695)
            || var6.method_31574(Items.field_8494)
            || var6.method_31574(Items.field_8477)
            || var6.method_31574(Items.field_8603);
      if (var5.method_7681() && !var7) {
         this.qbs = 0;
         int var8 = qcm(var3.method_61628());
         if (var8 == this.qbt) {
            if (++this.qbu >= 3) {
               this.qbq.add(a.c(-1890441319, "⎄娽킙䪊앁䏹吏瀬\uee01悠\ue361ᴂ韍\u0e79营˓뢔㜺귻⯚ꉘ\udc1c嚻쵥䭮에硹\uf652法\ueaf0慅鿦"));
               return qbl.FAIL;
            }
         } else {
            this.qbu = 0;
         }

         this.qbt = var8;
         qcq(var1, var2, var3, var5.field_7874, 0, SlotActionType.field_7794);
         this.qbr = qco(var1, var2);
         return qbl.ACT;
      } else if (++this.qbs > qcp(var1, var2)) {
         this.qbs = -1;
         if (var4 != null) {
            this.qbq.add(a.b("↞堨튎䳾윪䇩ﮰ癛\uec19暠\ue566ᬃ闐౪舢", 1126507939) + var4.method_63680().getString());
         }

         return qbl.FAIL;
      } else {
         return qbl.WAIT;
      }
   }

   private qbl qcj(MinecraftClient var1, ClientPlayerEntity var2, CraftingScreenHandler var3, List<Slot> var4, Item var5) {
      if (!var3.method_34255().method_7960()) {
         putBack(var1, var2, var3, -1);
         return qbl.ACT;
      } else {
         for (Slot var7 : var4) {
            if (var7.method_7681() && (var5 == null || !var7.method_7677().method_31574(var5))) {
               int var8 = var7.method_7677().method_7947();
               if (var7.field_7874 == this.qbw && var8 == this.qbx) {
                  if (++this.qby > 4) {
                     this.qbq.add(a.c(1035572653, "醠\ue819抽\uf8ae睥\uf1dd䯺숈尥튄充꼦◩뱝㘁냷ર蔞῟駾ၼ渴\ue08b缽蘆玕쨥䑺\udae1墮퍢ⶰꞍ㹷렯㋯贵̨臩\u1c4a鈇\uecf1曗\ue167箳\uf5b0䱩웗"));
                     return qbl.DONE;
                  }
               } else {
                  this.qby = 0;
               }

               this.qbw = var7.field_7874;
               this.qbx = var8;
               qcq(var1, var2, var3, var7.field_7874, 0, SlotActionType.field_7794);
               return qbl.ACT;
            }
         }

         return qbl.DONE;
      }
   }

   private static String qck(CraftingScreenHandler var0) {
      StringBuilder var1 = new StringBuilder(a.c(344476069, "䧿"));

      for (Slot var3 : var0.method_61628()) {
         var1.append(var3.method_7677().method_7947()).append(' ');
      }

      return var1.append(']').toString();
   }

   private static boolean qcl(List<Slot> var0, Item var1, Slot var2) {
      for (Slot var4 : var0) {
         if (var4.method_7681() && (!var4.method_7677().method_31574(var1) || var2 != null && var4 != var2)) {
            return true;
         }
      }

      return false;
   }

   private static int qcm(List<Slot> var0) {
      int var1 = 17;

      for (Slot var3 : var0) {
         var1 = var1 * 31 + var3.method_7677().method_7947();
      }

      return var1;
   }

   private static int qcn(MinecraftClient var0, ClientPlayerEntity var1) {
      if (var0.method_1562() == null) {
         return 100;
      } else {
         PlayerListEntry var2 = var0.method_1562().method_2871(var1.method_5667());
         return var2 == null ? 100 : Math.max(0, var2.method_2959());
      }
   }

   private static int qco(MinecraftClient var0, ClientPlayerEntity var1) {
      return Math.min(14, 3 + qcn(var0, var1) / 50);
   }

   private static int qcp(MinecraftClient var0, ClientPlayerEntity var1) {
      return Math.min(100, 30 + qcn(var0, var1) / 20);
   }

   private static void qcq(MinecraftClient var0, ClientPlayerEntity var1, ScreenHandler var2, int var3, int var4, SlotActionType var5) {
      var0.field_1761.method_2906(var2.field_7763, var3, var4, var5, var1);
   }

   private static void qcr(MinecraftClient var0, ClientPlayerEntity var1, ScreenHandler var2, List<Slot> var3) {
      qcq(var0, var1, var2, -999, ScreenHandler.method_7591(0, 0), SlotActionType.field_7789);

      for (Slot var5 : var3) {
         qcq(var0, var1, var2, var5.field_7874, ScreenHandler.method_7591(1, 0), SlotActionType.field_7789);
      }

      qcq(var0, var1, var2, -999, ScreenHandler.method_7591(2, 0), SlotActionType.field_7789);
   }

   static void putBack(MinecraftClient var0, ClientPlayerEntity var1, ScreenHandler var2, int var3) {
      for (int var4 = 0; var4 < 4 && !var2.method_34255().method_7960(); var4++) {
         ItemStack var5 = var2.method_34255();
         int var6 = -1;
         if (var3 >= 0 && var3 < var2.field_7761.size()) {
            ItemStack var7 = ((Slot)var2.field_7761.get(var3)).method_7677();
            if (var7.method_7960() || ItemStack.method_31577(var7, var5) && var7.method_7947() < var7.method_7914()) {
               var6 = var3;
            }
         }

         if (var6 < 0) {
            for (Slot var8 : var2.field_7761) {
               if (var8.field_7871 == var1.method_31548()
                  && var8.method_7681()
                  && ItemStack.method_31577(var8.method_7677(), var5)
                  && var8.method_7677().method_7947() < var8.method_7677().method_7914()) {
                  var6 = var8.field_7874;
                  break;
               }
            }
         }

         if (var6 < 0) {
            for (Slot var11 : var2.field_7761) {
               if (var11.field_7871 == var1.method_31548() && !var11.method_7681() && var11.method_34266() < 36) {
                  var6 = var11.field_7874;
                  break;
               }
            }
         }

         qcq(var0, var1, var2, var6 < 0 ? -999 : var6, 0, SlotActionType.field_7790);
         var3 = -1;
      }
   }

   static int count(ScreenHandler var0, ClientPlayerEntity var1, Item var2) {
      int var3 = 0;

      for (Slot var5 : var0.field_7761) {
         if (var5.field_7871 == var1.method_31548() && var5.method_7677().method_31574(var2)) {
            var3 += var5.method_7677().method_7947();
         }
      }

      return var3;
   }

   private static Slot qcs(ScreenHandler var0, ClientPlayerEntity var1, Item var2) {
      Slot var3 = null;

      for (Slot var5 : var0.field_7761) {
         if (var5.field_7871 == var1.method_31548()
            && var5.method_7677().method_31574(var2)
            && (var3 == null || var5.method_7677().method_7947() > var3.method_7677().method_7947())) {
            var3 = var5;
         }
      }

      return var3;
   }

   private static Slot qct(ScreenHandler var0, ClientPlayerEntity var1, Item var2, Slot var3) {
      Slot var4 = null;

      for (Slot var6 : var0.field_7761) {
         if (var6 != var3
            && var6.field_7871 == var1.method_31548()
            && var6.method_7677().method_31574(var2)
            && (var4 == null || var6.method_7677().method_7947() < var4.method_7677().method_7947())) {
            var4 = var6;
         }
      }

      return var4;
   }
}
