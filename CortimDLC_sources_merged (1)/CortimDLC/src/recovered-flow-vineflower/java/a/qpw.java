package a;

import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.SlotActionType;

public final class qpw {
   public static final int SLOTS = 36;
   public static final int OFFHAND = 40;
   public static final int OUTSIDE = -999;
   public static final int DEBRIS_SLOT = 32;
   public static final int KEEP_DIAMONDS = 16;
   public static final int KEEP_GOLD = 14;
   public static final Item[] MARKERS = new Item[]{Items.REDSTONE, Items.LAPIS_LAZULI, Items.IRON_INGOT, Items.COAL};
   private static final Item[] qpx = new Item[36];
   private static final int[] qpy;

   private qpw() {
   }

   public static int count(PlayerInventory var0, Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = var0.getStack(var3);
         if (var4.isOf(var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   public static int countAll(PlayerEntity var0, Item var1) {
      ItemStack var2 = var0.getOffHandStack();
      return count(var0.getInventory(), var1) + (var2.isOf(var1) ? var2.getCount() : 0);
   }

   public static int food(PlayerEntity var0) {
      return countAll(var0, Items.GOLDEN_CARROT);
   }

   public static int find(PlayerInventory var0, Item var1) {
      int var2 = -1;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = var0.getStack(var3);
         if (var4.isOf(var1) && (var2 < 0 || var4.getCount() > var0.getStack(var2).getCount())) {
            var2 = var3;
         }
      }

      return var2;
   }

   public static int emptySlot(PlayerInventory var0) {
      for (int var1 = 35; var1 >= 0; var1--) {
         if (var0.getStack(var1).isEmpty()) {
            return var1;
         }
      }

      return -1;
   }

   public static int durability(ItemStack var0) {
      return !var0.isEmpty() && var0.isDamageable() ? var0.getMaxDamage() - var0.getDamage() : -1;
   }

   public static int pickaxe(PlayerInventory var0) {
      if (var0.getStack(0).isIn(ItemTags.PICKAXES)) {
         return 0;
      }

      int var1 = qof.bestPickaxe(var0);
      if (var1 >= 0) {
         return var1;
      }

      for (int var2 = 0; var2 < 36; var2++) {
         if (var0.getStack(var2).isIn(ItemTags.PICKAXES)) {
            return var2;
         }
      }

      return -1;
   }

   public static int pickaxeDurability(ClientPlayerEntity var0) {
      ItemStack var1 = var0.getMainHandStack();
      if (var1.isIn(ItemTags.PICKAXES) && var1.isDamageable()) {
         return durability(var1);
      }

      int var2 = pickaxe(var0.getInventory());
      if (var2 >= 0) {
         return durability(var0.getInventory().getStack(var2));
      }

      ItemStack var3 = var0.getOffHandStack();
      return var3.isIn(ItemTags.PICKAXES) ? durability(var3) : -1;
   }

   public static boolean isFood(ItemStack var0) {
      return !var0.isEmpty() && var0.get(DataComponentTypes.FOOD) != null
         ? !var0.isOf(Items.ROTTEN_FLESH)
            && !var0.isOf(Items.SPIDER_EYE)
            && !var0.isOf(Items.POISONOUS_POTATO)
            && !var0.isOf(Items.PUFFERFISH)
            && !var0.isOf(Items.CHORUS_FRUIT)
            && !var0.isOf(Items.SUSPICIOUS_STEW)
            && !var0.isOf(Items.ENCHANTED_GOLDEN_APPLE)
         : false;
   }

   public static boolean isLayoutItem(Item var0) {
      if (var0 != Items.DIAMOND && var0 != Items.GOLD_INGOT && var0 != Items.ANCIENT_DEBRIS) {
         for (Item var4 : MARKERS) {
            if (var4 == var0) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public static boolean isMarker(Item var0) {
      for (Item var4 : MARKERS) {
         if (var4 == var0) {
            return true;
         }
      }

      return false;
   }

   public static boolean keeps(ItemStack var0) {
      if (var0.isEmpty()) {
         return false;
      } else if (var0.isIn(ItemTags.PICKAXES) || var0.isDamageable() || isFood(var0) || var0.isOf(Items.ENCHANTED_GOLDEN_APPLE)) {
         return true;
      } else {
         return !var0.isOf(Items.TOTEM_OF_UNDYING)
               && !var0.isOf(Items.EXPERIENCE_BOTTLE)
               && !var0.isOf(Items.NETHERITE_INGOT)
               && !var0.isOf(Items.NETHERITE_SCRAP)
               && !var0.isOf(Items.DIAMOND_BLOCK)
               && !var0.isOf(Items.GOLD_BLOCK)
               && !var0.isOf(Items.ENDER_PEARL)
               && !var0.isOf(Items.ELYTRA)
               && !var0.isOf(Items.EMERALD)
               && !var0.isOf(Items.EMERALD_BLOCK)
               && !var0.isOf(Items.NETHERITE_BLOCK)
            ? var0.getItem() instanceof BlockItem var1 && var1.getBlock() instanceof ShulkerBoxBlock
            : true;
      }
   }

   public static boolean throwable(ItemStack var0) {
      return !var0.isEmpty() && !keeps(var0) && !isLayoutItem(var0.getItem());
   }

   public static boolean ready(PlayerInventory var0) {
      int var1 = 14 + (count(var0, Items.ANCIENT_DEBRIS) == 0 ? 1 : 0);
      return count(var0, Items.DIAMOND) >= 16 && count(var0, Items.GOLD_INGOT) >= var1;
   }

   public static int keepGold(PlayerInventory var0) {
      return 14 + (count(var0, Items.ANCIENT_DEBRIS) == 0 ? 1 : 0);
   }

   public static Item[] targets(PlayerInventory var0, ItemStack var1) {
      Item[] var2 = (Item[])qpx.clone();
      if (count(var0, Items.ANCIENT_DEBRIS) == 0) {
         var2[32] = Items.GOLD_INGOT;
      }

      for (int var3 = 0; var3 < MARKERS.length; var3++) {
         if (count(var0, MARKERS[var3]) == 0) {
            var2[9 + var3] = null;
         }
      }

      int var8 = pickaxe(var0);
      boolean var4 = var1.isEmpty() || var1.isOf(Items.GOLDEN_CARROT);
      int var5 = 0;

      for (int var6 = 0; var6 < 36; var6++) {
         ItemStack var7 = var0.getStack(var6);
         if (!var7.isEmpty() && var6 != var8 && !isLayoutItem(var7.getItem()) && keeps(var7)) {
            if (var4 && var7.isOf(Items.GOLDEN_CARROT)) {
               var4 = false;
            } else {
               var5++;
            }
         }
      }

      for (int var9 = 1; var9 < 36; var9++) {
         if (var2[var9] == null) {
            var5--;
         }
      }

      for (int var10 = qpy.length - 1; var10 >= 0 && var5 > 0; var10--) {
         if (var2[qpy[var10]] != null) {
            var2[qpy[var10]] = null;
            var5--;
         }
      }

      return var2;
   }

   public static int misplaced(PlayerInventory var0, Item[] var1) {
      int var2 = 0;

      for (int var3 = 1; var3 < 36; var3++) {
         if (var1[var3] != null && !var0.getStack(var3).isOf(var1[var3])) {
            var2++;
         }
      }

      return var2;
   }

   public static qpq next(PlayerInventory var0, ItemStack var1, ItemStack var2, Item[] var3, boolean[] var4) {
      return next(var0, var1, var2, var3, var4, false);
   }

   public static qpq next(PlayerInventory var0, ItemStack var1, ItemStack var2, Item[] var3, boolean[] var4, boolean var5) {
      if (var1.isEmpty()) {
         int var6 = pickaxe(var0);
         if (var6 > 0 && !var0.getStack(0).isIn(ItemTags.PICKAXES)) {
            return new qpq(var6, 0, SlotActionType.SWAP);
         }

         for (int var10 : qpy) {
            Item var11 = var3[var10];
            if (var11 != null && !var4[var10]) {
               ItemStack var12 = var0.getStack(var10);
               if (!var12.isOf(var11)) {
                  if (!var12.isEmpty()) {
                     return new qpq(var10, 0, SlotActionType.PICKUP);
                  }

                  int var13 = qqc(var0, var3, var11);
                  if (var13 >= 0) {
                     return new qpq(var13, 0, SlotActionType.PICKUP);
                  }

                  var4[var10] = true;
               }
            }
         }

         if (!var2.isOf(Items.GOLDEN_CARROT) && var2.isEmpty()) {
            int var14 = find(var0, Items.GOLDEN_CARROT);
            if (var14 >= 0) {
               return new qpq(var14, 40, SlotActionType.SWAP);
            }
         }

         return null;
      } else {
         return !var1.isOf(Items.GOLDEN_CARROT)
               || !var2.isEmpty() && (!ItemStack.areItemsAndComponentsEqual(var2, var1) || var2.getCount() >= var2.getMaxCount())
            ? qqb(var0, var1, var3, var4, var5)
            : new qpq(40, 0, SlotActionType.PICKUP);
      }
   }

   private static qpq qqb(PlayerInventory var0, ItemStack var1, Item[] var2, boolean[] var3, boolean var4) {
      Item var5 = var1.getItem();

      for (int var9 : qpy) {
         if (var2[var9] == var5 && !var3[var9] && var0.getStack(var9).isEmpty()) {
            return new qpq(var9, var1.getCount() > 1 ? 1 : 0, SlotActionType.PICKUP);
         }
      }

      int var10 = -1;

      for (int var11 = 0; var11 < 36; var11++) {
         ItemStack var14 = var0.getStack(var11);
         if (!var14.isEmpty()
            && ItemStack.areItemsAndComponentsEqual(var14, var1)
            && var14.getCount() < var14.getMaxCount()
            && (var10 < 0 || var2[var11] == var5 && var2[var10] != var5)) {
            var10 = var11;
         }
      }

      if (var10 >= 0) {
         return new qpq(var10, 0, SlotActionType.PICKUP);
      }

      for (int var12 = 35; var12 >= 1; var12--) {
         if (var2[var12] == null && var0.getStack(var12).isEmpty()) {
            return new qpq(var12, 0, SlotActionType.PICKUP);
         }
      }

      if (!var4 && !keeps(var1) && !isLayoutItem(var5)) {
         return new qpq(-999, 0, SlotActionType.PICKUP);
      }

      for (int var13 = qpy.length - 1; var13 >= 0; var13--) {
         int var15 = qpy[var13];
         if (var0.getStack(var15).isEmpty()) {
            var3[var15] = true;
            return new qpq(var15, 0, SlotActionType.PICKUP);
         }
      }

      return var4 ? null : new qpq(-999, 0, SlotActionType.PICKUP);
   }

   private static int qqc(PlayerInventory var0, Item[] var1, Item var2) {
      int var3 = -1;
      int var4 = -1;

      for (int var5 = 0; var5 < 36; var5++) {
         ItemStack var6 = var0.getStack(var5);
         if (var6.isOf(var2)) {
            boolean var7 = var1[var5] == var2;
            if (!var7 || var6.getCount() >= 2) {
               int var8 = (var7 ? 0 : 1000) + var6.getCount();
               if (var8 > var4) {
                  var4 = var8;
                  var3 = var5;
               }
            }
         }
      }

      return var3;
   }

   static {
      for (int var0 = 1; var0 <= 8; var0++) {
         qpx[var0] = Items.DIAMOND;
      }

      for (int var3 = 0; var3 < MARKERS.length; var3++) {
         qpx[9 + var3] = MARKERS[var3];
      }

      for (int var4 = 13; var4 <= 26; var4++) {
         qpx[var4] = Items.GOLD_INGOT;
      }

      for (int var5 = 27; var5 <= 35; var5++) {
         qpx[var5] = Items.DIAMOND;
      }

      qpx[32] = Items.ANCIENT_DEBRIS;
      int[] var6 = new int[35];
      int var1 = 0;
      int var2 = 9;

      while (var2 <= 12) {
         var6[var1++] = var2++;
      }

      var6[var1++] = 32;
      var2 = 13;

      while (var2 <= 26) {
         var6[var1++] = var2++;
      }

      for (int var9 = 27; var9 <= 35; var9++) {
         if (var9 != 32) {
            var6[var1++] = var9;
         }
      }

      var2 = 1;

      while (var2 <= 8) {
         var6[var1++] = var2++;
      }

      qpy = var6;
   }
}
