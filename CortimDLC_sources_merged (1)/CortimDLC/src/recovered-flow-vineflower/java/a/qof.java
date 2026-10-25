package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public final class qof {
   static final int qog = 420;
   final vyn qoh = new vyn();
   final Random qoi = new Random();
   final ArrayDeque<int[]> qoj = new ArrayDeque<>();
   final IntArrayList qok = new IntArrayList();
   qoc qol = qoc.NONE;
   int qom;
   int qon;
   boolean qoo;
   int qop;
   int qoq;
   int qor;
   Item[] qos;
   boolean[] qot;
   int qou;
   boolean qov;
   boolean qow;
   int qox = -1;
   int qoy = -1;
   int qoz = -1;
   int qpa = -1;
   Item qpb;
   public boolean noThrow;

   public boolean busy() {
      return this.qol != qoc.NONE;
   }

   public qoc job() {
      return this.qol;
   }

   public int thrown() {
      return this.qop;
   }

   public boolean laidOut() {
      return this.qow;
   }

   public static int bestPickaxe(PlayerInventory var0) {
      BlockState var1 = Blocks.STONE.getDefaultState();
      int var2 = -1;
      double var3 = 0.0;

      for (int var5 = 0; var5 < 36; var5++) {
         ItemStack var6 = var0.getStack(var5);
         if (!var6.isEmpty() && var6.isIn(ItemTags.PICKAXES) && (!var6.isDamageable() || var6.getMaxDamage() - var6.getDamage() > 5)) {
            double var7 = var6.getMiningSpeedMultiplier(var1);
            int var9 = qpo(var6);
            if (var9 > 0) {
               var7 += var9 * var9 + 1;
            }

            String var10 = qpp(var6);
            if (var10.contains(a.b("軆\uf705綮\ue3a8标\ueebc哦", 1289784048))) {
               var7 += 1000.0;
            }

            if (var10.contains(a.d("퐆궻❫뤔㋆됍", 172131137, 390157181))) {
               var7 += 500.0;
            }

            if (var5 == var0.getSelectedSlot()) {
               var7 += 0.5;
            } else if (var5 < 9) {
               var7 += 0.25;
            }

            if (var7 > var3) {
               var3 = var7;
               var2 = var5;
            }
         }
      }

      return var2;
   }

   public static boolean holdsPickaxe(ClientPlayerEntity var0) {
      return var0.getMainHandStack().isIn(ItemTags.PICKAXES);
   }

   public static boolean hasJunk(PlayerInventory var0, Set<String> var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         if (qpe(var0.getStack(var2), var1)) {
            return true;
         }
      }

      return false;
   }

   public static int empty(PlayerInventory var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (var0.getStack(var2).isEmpty()) {
            var1++;
         }
      }

      return var1;
   }

   public static boolean isJunkStack(ItemStack var0, Set<String> var1) {
      return qpe(var0, var1);
   }

   static boolean qpe(ItemStack var0, Set<String> var1) {
      return !var0.isEmpty() && var1.contains(Registries.ITEM.getId(var0.getItem()).toString());
   }

   public boolean equip(MinecraftClient var1, ClientPlayerEntity var2) {
      PlayerInventory var3 = var2.getInventory();
      int var4 = bestPickaxe(var3);
      if (var4 < 0) {
         return false;
      }

      if (var4 < 9) {
         if (var3.getSelectedSlot() != var4) {
            var3.setSelectedSlot(var4);
         }

         return true;
      } else {
         if (this.qol == qoc.NONE) {
            this.qol = qoc.EQUIP;
            this.qom = 0;
         }

         return true;
      }
   }

   public void dropJunk(int var1) {
      if (this.qol == qoc.NONE) {
         this.qpf(qoc.JUNK);
         this.qoq = var1;
         this.qon = 1;
      }
   }

   public void swaps(int... var1) {
      if (this.qol == qoc.NONE && var1.length >= 2) {
         this.qoj.clear();

         for (byte var2 = 0; var2 + 1 < var1.length; var2 += 2) {
            this.qoj.add(new int[]{var1[var2], var1[var2 + 1]});
         }

         this.qpf(qoc.SWAPS);
      }
   }

   public void throwOne(int var1) {
      if (this.qol == qoc.NONE) {
         this.qpf(qoc.THROW);
         this.qor = var1;
      }
   }

   public void layout() {
      if (this.qol == qoc.NONE) {
         this.qpf(qoc.LAYOUT);
         this.qos = null;
         this.qov = false;
         this.qow = false;
      }
   }

   public void compact() {
      if (this.qol == qoc.NONE) {
         this.qpf(qoc.COMPACT);
      }
   }

   public void freeHand() {
      if (this.qol == qoc.NONE) {
         this.qpf(qoc.HAND);
         this.qox = -1;
      }
   }

   public void unstow(ClientPlayerEntity var1) {
      if (this.qpa >= 0 && this.qol == qoc.NONE) {
         PlayerInventory var2 = var1.getInventory();
         int var3 = this.qoz;
         int var4 = this.qpa;
         this.qpa = -1;
         if (var2.getStack(var3).isEmpty() && var2.getStack(var4).isOf(this.qpb)) {
            this.swaps(var4, var3);
         }
      }
   }

   void qpf(qoc var1) {
      this.qol = var1;
      this.qom = 0;
      this.qon = 0;
      this.qoo = false;
      this.qou = 0;
   }

   public void startTick(MinecraftClient var1) {
      if (this.qol != qoc.NONE) {
         this.qoh.hold(var1);
      }
   }

   public void endTick(MinecraftClient var1, ClientPlayerEntity var2, Set<String> var3) {
      if (this.qol != qoc.NONE) {
         boolean var4 = var2.isAlive() && !var2.isSpectator() && var2.currentScreenHandler == var2.playerScreenHandler;
         if (var4 && (this.qol == qoc.LAYOUT || this.qol == qoc.COMPACT || this.qol == qoc.HAND || wdq.canClick(var2))) {
            boolean var5 = vyn.serverIdle(var2)
               && vyn.still(var2)
               && !var2.isUsingItem()
               && (var1.interactionManager == null || !var1.interactionManager.isBreakingBlock());
            if (!var5) {
               if (++this.qom > 24) {
                  this.qpn(var1);
               }
            } else {
               PlayerInventory var6 = var2.getInventory();
               switch (this.qol) {
                  case EQUIP:
                     int var8 = bestPickaxe(var6);
                     if (var8 >= 9) {
                        wdq.swap(var1, var8, var6.getSelectedSlot());
                     }

                     this.qpn(var1);
                     break;
                  case JUNK:
                     this.qpg(var1, var2, var6, var3);
                     break;
                  case SWAPS:
                     int[] var7 = this.qoj.poll();
                     if (var7 == null) {
                        this.qpm(var1);
                        return;
                     }

                     wdq.click(var1, var7[0], var7[1]);
                     this.qoo = true;
                     if (this.qoj.isEmpty()) {
                        this.qpm(var1);
                     }
                     break;
                  case THROW:
                     if (!this.noThrow && !var6.getStack(this.qor).isEmpty()) {
                        var1.interactionManager.clickSlot(var2.playerScreenHandler.syncId, wdq.slotId(this.qor), 0, SlotActionType.THROW, var2);
                        this.qoo = true;
                        this.qop++;
                     }

                     this.qpm(var1);
                     break;
                  case LAYOUT:
                     this.qpl(var1, var2, var6, var3);
                     break;
                  case COMPACT:
                     this.qpk(var1, var2, var6);
                     break;
                  case HAND:
                     this.qph(var1, var2, var6, var3);
                     break;
                  default:
                     this.qpn(var1);
               }
            }
         } else {
            qsw.log(
               a.d("ﱥ藓༘鄿", -1859296817, -1221812793)
                  + this.qol
                  + a.c(1060193063, "䌕㫧뀶⹈ꗖ⌴餳ႁ軑ѥ莼秅\uf743滨\ue4f4戝\ud84b埉")
                  + var4
                  + a.b("럈츱䓫\uda95先ퟱ涫\ue44d穝", -452937759)
                  + var2.currentScreenHandler
                  + a.c(915444762, "鐲\uedc0朅拾犥\uf408乆쟸")
                  + var2.playerScreenHandler.getCursorStack()
                  + a.c(-962717369, "\u196f悍\uea4e琮￮祟쌇䪥")
                  + var1.currentScreen
            );
            this.qpn(var1);
         }
      }
   }

   void qpg(MinecraftClient var1, ClientPlayerEntity var2, PlayerInventory var3, Set<String> var4) {
      if (this.noThrow) {
         this.qpm(var1);
      } else if (this.qon > 0) {
         this.qon--;
      } else {
         int var5 = var3.getSelectedSlot();

         for (int var6 = 35; var6 >= 0 && this.qoq > 0; var6--) {
            if (var6 != var5 && qpe(var3.getStack(var6), var4)) {
               this.qoq--;
               var1.interactionManager.clickSlot(var2.playerScreenHandler.syncId, wdq.slotId(var6), 1, SlotActionType.THROW, var2);
               this.qoo = true;
               this.qop++;
               this.qon = this.qoi.nextInt(5) == 0 ? 1 : 0;
               return;
            }
         }

         this.qpm(var1);
      }
   }

   void qph(MinecraftClient var1, ClientPlayerEntity var2, PlayerInventory var3, Set<String> var4) {
      PlayerScreenHandler var5 = var2.playerScreenHandler;
      if (this.qon > 0) {
         this.qon--;
      } else if (this.qox >= 0) {
         var1.interactionManager.clickSlot(var5.syncId, wdq.slotId(this.qox), 0, SlotActionType.PICKUP, var2);
         if (!var5.getCursorStack().isEmpty()) {
            var1.interactionManager.clickSlot(var5.syncId, wdq.slotId(this.qoy), 0, SlotActionType.PICKUP, var2);
         }

         this.qox = -1;
         this.qon = 1;
      } else if (!var5.getCursorStack().isEmpty()) {
         this.qpm(var1);
      } else {
         for (int var6 = 0; var6 < 9; var6++) {
            if (var3.getStack(var6).isEmpty()) {
               this.qpm(var1);
               return;
            }
         }

         if (++this.qou > 6) {
            this.qpm(var1);
         } else {
            int var8 = qpi(var3);

            for (int var7 = 9; var7 < 36; var7++) {
               if (var3.getStack(var7).isEmpty()) {
                  this.qoz = var8;
                  this.qpa = var7;
                  this.qpb = var3.getStack(var8).getItem();
                  wdq.click(var1, var7, var8);
                  this.qoo = true;
                  this.qpm(var1);
                  return;
               }
            }

            for (int var9 = 35; var9 >= 0 && !this.noThrow; var9--) {
               if (qpe(var3.getStack(var9), var4)) {
                  var1.interactionManager.clickSlot(var5.syncId, wdq.slotId(var9), 1, SlotActionType.THROW, var2);
                  this.qoo = true;
                  this.qop++;
                  this.qon = 1;
                  return;
               }
            }

            int[] var10 = qpj(var3, var8);
            if (var10 == null) {
               this.qpm(var1);
            } else {
               this.qoy = var10[0];
               var1.interactionManager.clickSlot(var5.syncId, wdq.slotId(var10[0]), 0, SlotActionType.PICKUP, var2);
               this.qoo = true;
               this.qox = var10[1];
               this.qon = 1;
            }
         }
      }
   }

   static int qpi(PlayerInventory var0) {
      int var1 = var0.getSelectedSlot();
      if (!var0.getStack(var1).isIn(ItemTags.PICKAXES)) {
         return var1;
      }

      int var2 = -1;

      for (int var3 = 0; var3 < 9; var3++) {
         ItemStack var4 = var0.getStack(var3);
         if (!var4.isIn(ItemTags.PICKAXES) && (var2 < 0 || var4.getCount() < var0.getStack(var2).getCount())) {
            var2 = var3;
         }
      }

      return var2 >= 0 ? var2 : var1;
   }

   static int[] qpj(PlayerInventory var0, int var1) {
      int[] var2 = null;
      int var3 = Integer.MAX_VALUE;

      for (int var4 = 0; var4 < 36; var4++) {
         ItemStack var5 = var0.getStack(var4);
         if (!var5.isEmpty() && var5.getMaxCount() > 1 && !var5.isIn(ItemTags.PICKAXES)) {
            for (int var6 = 0; var6 < 36; var6++) {
               ItemStack var7 = var0.getStack(var6);
               if (var6 != var4
                  && !var7.isEmpty()
                  && var5.getCount() + var7.getCount() <= var7.getMaxCount()
                  && ItemStack.areItemsAndComponentsEqual(var5, var7)) {
                  int var8 = (var4 == var1 ? 0 : (var4 < 9 ? 200 : 100)) + var5.getCount();
                  if (var8 < var3) {
                     var3 = var8;
                     var2 = new int[]{var4, var6};
                  }
               }
            }
         }
      }

      return var2;
   }

   void qpk(MinecraftClient var1, ClientPlayerEntity var2, PlayerInventory var3) {
      PlayerScreenHandler var4 = var2.playerScreenHandler;
      byte var5 = -1;
      int var6 = -1;
      if (var4.getCursorStack().isEmpty() && ++this.qou < 120) {
         for (int var7 = 0; var7 < 36 && var5 < 0; var7++) {
            ItemStack var8 = var3.getStack(var7);
            if (!var8.isEmpty() && var8.getCount() < var8.getMaxCount()) {
               for (int var9 = 0; var9 < 36; var9++) {
                  ItemStack var10 = var3.getStack(var9);
                  if (var9 != var7
                     && !var10.isEmpty()
                     && var10.getCount() < var10.getMaxCount()
                     && ItemStack.areItemsAndComponentsEqual(var8, var10)
                     && (var6 < 0 || var10.getCount() > var3.getStack(var6).getCount())) {
                     var6 = var9;
                  }
               }

               if (var6 >= 0) {
                  var5 = (byte)(var8.getCount() <= var3.getStack(var6).getCount() ? var7 : var6);
                  var6 = var5 == var7 ? var6 : var7;
               }
            }
         }
      }

      if (var5 < 0) {
         if (!var4.getCursorStack().isEmpty()) {
            int var11 = qpw.emptySlot(var3);
            var1.interactionManager.clickSlot(var4.syncId, var11 >= 0 ? wdq.slotId(var11) : -999, 0, SlotActionType.PICKUP, var2);
         }

         this.qpm(var1);
      } else {
         var1.interactionManager.clickSlot(var4.syncId, wdq.slotId(var5), 0, SlotActionType.PICKUP, var2);
         var1.interactionManager.clickSlot(var4.syncId, wdq.slotId(var6), 0, SlotActionType.PICKUP, var2);
         if (!var4.getCursorStack().isEmpty()) {
            var1.interactionManager.clickSlot(var4.syncId, wdq.slotId(var5), 0, SlotActionType.PICKUP, var2);
         }

         this.qoo = true;
      }
   }

   void qpl(MinecraftClient var1, ClientPlayerEntity var2, PlayerInventory var3, Set<String> var4) {
      PlayerScreenHandler var5 = var2.playerScreenHandler;
      if (!this.qov) {
         this.qov = true;
         this.qok.clear();

         for (int var6 = 0; var6 < 36 && !this.noThrow; var6++) {
            ItemStack var7 = var3.getStack(var6);
            if (qpw.throwable(var7) || qpe(var7, var4)) {
               this.qok.add(var6);
            }
         }

         for (Item var9 : this.noThrow ? new Item[0] : qpw.MARKERS) {
            int var10 = qpw.find(var3, var9);

            for (int var11 = 0; var11 < 36; var11++) {
               if (var11 != var10 && var3.getStack(var11).isOf(var9)) {
                  this.qok.add(var11);
               }
            }
         }
      }

      if (!this.qok.isEmpty() && var5.getCursorStack().isEmpty()) {
         int var14 = this.qok.removeInt(this.qok.size() - 1);
         if (!var3.getStack(var14).isEmpty()) {
            var1.interactionManager.clickSlot(var5.syncId, wdq.slotId(var14), 1, SlotActionType.THROW, var2);
            this.qoo = true;
            this.qop++;
         }
      } else {
         if (this.qos == null) {
            this.qos = qpw.targets(var3, var2.getOffHandStack());
            this.qot = new boolean[36];
         }

         for (int var13 = 0; var13 < 2; var13++) {
            qpq var16 = qpw.next(var3, var5.getCursorStack(), var2.getOffHandStack(), this.qos, this.qot, this.noThrow);
            boolean var17 = false;
            if (var16 != null && this.noThrow && var16.slot() == -999) {
               var16 = null;
               var17 = true;
            }

            if (var16 == null || ++this.qou > 420) {
               this.qow = var16 == null && !var17;
               if (!var5.getCursorStack().isEmpty()) {
                  int var19 = qpw.emptySlot(var3);
                  if (var19 >= 0 || !this.noThrow) {
                     var1.interactionManager.clickSlot(var5.syncId, var19 >= 0 ? wdq.slotId(var19) : -999, 0, SlotActionType.PICKUP, var2);
                  }
               }

               this.qpm(var1);
               return;
            }

            int var18 = var16.slot() == -999 ? -999 : (var16.slot() == 40 ? 45 : wdq.slotId(var16.slot()));
            var1.interactionManager.clickSlot(var5.syncId, var18, var16.button(), var16.type(), var2);
            this.qoo = true;
            if (var16.type() != SlotActionType.PICKUP) {
               return;
            }
         }
      }
   }

   void qpm(MinecraftClient var1) {
      if (this.qoo) {
         wdq.close(var1);
      }

      this.qpn(var1);
   }

   public void cancel(MinecraftClient var1) {
      if (this.qoo && var1.player != null) {
         wdq.close(var1);
      }

      this.qpn(var1);
   }

   void qpn(MinecraftClient var1) {
      if (this.qol != qoc.NONE) {
         qsw.log(
            a.d("駛\ue06d檦\uf481", -1205381147, -1964061101)
               + this.qol
               + a.d("᫅挻\ue9f1瞓ﱓ窼샣䥅휌嶵\uda7b‛껍㜸", 2095411800, 244345011)
               + this.qom
               + (this.qoo ? a.c(-1773078270, "蠟肚ਊ鑴ᾦ餝⍆ꪹ㓧") : a.d("\ue22b鮖ᄋ轻ӣ舑㡍놹\u2fecꕕ", 783832303, -1532905758))
         );
      }

      this.qol = qoc.NONE;
      this.qoo = false;
      this.qom = 0;
      this.qoj.clear();
      this.qok.clear();
      if (this.qoh.isHeld()) {
         this.qoh.release(var1);
      }
   }

   static int qpo(ItemStack var0) {
      for (Entry var2 : var0.getEnchantments().getEnchantmentEntries()) {
         if (((RegistryEntry)var2.getKey()).matchesKey(Enchantments.EFFICIENCY)) {
            return var2.getIntValue();
         }
      }

      return 0;
   }

   static String qpp(ItemStack var0) {
      StringBuilder var1 = new StringBuilder();
      LoreComponent var2 = var0.get(DataComponentTypes.LORE);
      if (var2 != null) {
         for (Text var4 : var2.lines()) {
            var1.append(var4.getString()).append('\n');
         }
      }

      var1.append(var0.getName().getString());
      return var1.toString().toLowerCase(Locale.ROOT);
   }
}
