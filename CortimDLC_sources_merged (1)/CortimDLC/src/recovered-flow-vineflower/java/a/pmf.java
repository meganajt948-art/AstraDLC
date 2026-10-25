package a;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.MathHelper;

public final class pmf {
   private static final int pmg = 6;
   private final Predicate<ItemStack> pmh;
   private final PlayerInventory pmi;
   private final Random pmj;
   private final int pmk;
   private plz pml = plz.PICK;
   private int pmm;
   private int pmn;
   private int pmo;
   private int pmp;
   private int pmq;
   private long pmr;
   private boolean pms;

   private pmf(Predicate<ItemStack> var1, PlayerInventory var2, Random var3, int var4, int var5, int var6) {
      this.pmh = var1;
      this.pmi = var2;
      this.pmj = var3;
      this.pmk = Math.max(1, var4);
      this.pmm = var5;
      this.pmn = var6;
   }

   public static pmf plan(ScreenHandler var0, PlayerInventory var1, Predicate<ItemStack> var2, int var3, Random var4, long var5) {
      int var7 = pmz(var0, var1, var2, var4);
      if (var7 == -1) {
         return null;
      }

      int var8 = pna(var0, var1, var0.slots.get(var7).getStack(), var4);
      if (var8 == -1) {
         return null;
      }

      pmf var9 = new pmf(var2, var1, var4, var3, var7, var8);
      var9.pmr = var5 + travelDelay(var4);
      return var9;
   }

   public pmc drive(ScreenHandler var1, long var2, ply var4) {
      if (this.pml == plz.DONE) {
         return this.pms ? pmc.GAVE_UP : pmc.DONE;
      }

      if (var2 < this.pmr) {
         return pmc.WAIT;
      }

      if (this.pmq > this.pmk + 2 + 6) {
         if (var1.getCursorStack().isEmpty() || this.pmp >= 8) {
            return this.pmv(true);
         }

         this.pmp++;
         this.pml = plz.RETURN;
      }

      ItemStack var5 = var1.getCursorStack();
      switch (this.pml) {
         case PICK:
            if (!var5.isEmpty()) {
               this.pml = plz.RETURN;
               return pmc.WAIT;
            } else {
               if (!this.pmx(var1, this.pmm)) {
                  this.pmm = pmz(var1, this.pmi, this.pmh, this.pmj);
                  if (this.pmm == -1) {
                     return this.pmv(true);
                  }
               }

               int var7 = var1.slots.get(this.pmm).getStack().getCount();
               this.pmw(var4, this.pmm, 0, var2);
               this.pml = var7 <= this.pmk ? plz.PLACE_ALL : plz.PLACE_ONE;
               return pmc.CLICKED;
            }
         case PLACE_ALL:
         case PLACE_ONE:
            if (var5.isEmpty()) {
               if (++this.pmp > 2) {
                  return this.pmv(true);
               }

               this.pml = plz.PICK;
               this.pmr = var2 + clickDelay(this.pmj);
               return pmc.WAIT;
            } else if (!this.pmh.test(var5)) {
               this.pml = plz.RETURN;
               return pmc.WAIT;
            } else {
               if (!pmy(var1, this.pmi, this.pmn, var5)) {
                  this.pmn = pna(var1, this.pmi, var5, this.pmj);
                  if (this.pmn == -1) {
                     this.pml = plz.RETURN;
                     return pmc.WAIT;
                  }
               }

               if (this.pml == plz.PLACE_ALL) {
                  this.pmw(var4, this.pmn, 0, var2);
                  this.pml = plz.VERIFY;
                  this.pmr = var2 + settleDelay(this.pmj);
               } else {
                  this.pmw(var4, this.pmn, 1, var2);
                  if (++this.pmo >= this.pmk) {
                     this.pml = plz.RETURN;
                  }
               }

               return pmc.CLICKED;
            }
         case RETURN:
            if (var5.isEmpty()) {
               this.pml = plz.VERIFY;
               this.pmr = var2 + settleDelay(this.pmj);
               return pmc.WAIT;
            } else {
               int var6 = stashSlot(var1, this.pmi, var5, this.pmm);
               if (var6 == -1) {
                  return this.pmv(true);
               }

               this.pmw(var4, var6, 0, var2);
               this.pml = plz.VERIFY;
               this.pmr = var2 + settleDelay(this.pmj);
               return pmc.CLICKED;
            }
         case VERIFY:
            if (!var5.isEmpty()) {
               if (++this.pmp > 3) {
                  return this.pmv(true);
               }

               this.pml = plz.RETURN;
               this.pmr = var2 + clickDelay(this.pmj);
               return pmc.WAIT;
            }

            return this.pmv(false);
         default:
            return this.pmv(true);
      }
   }

   public void abort() {
      if (this.pml != plz.DONE) {
         this.pml = plz.RETURN;
         this.pmr = 0L;
      }
   }

   public boolean isDone() {
      return this.pml == plz.DONE;
   }

   private pmc pmv(boolean var1) {
      this.pml = plz.DONE;
      this.pms = var1;
      return var1 ? pmc.GAVE_UP : pmc.DONE;
   }

   private void pmw(ply var1, int var2, int var3, long var4) {
      var1.click(var2, var3, SlotActionType.PICKUP);
      this.pmq++;
      this.pmr = var4 + clickDelay(this.pmj);
   }

   private boolean pmx(ScreenHandler var1, int var2) {
      if (var2 >= 0 && var2 < var1.slots.size()) {
         Slot var3 = var1.slots.get(var2);
         return var3.inventory != this.pmi && var3.hasStack() && this.pmh.test(var3.getStack());
      } else {
         return false;
      }
   }

   private static boolean pmy(ScreenHandler var0, PlayerInventory var1, int var2, ItemStack var3) {
      if (var2 >= 0 && var2 < var0.slots.size()) {
         Slot var4 = var0.slots.get(var2);
         if (var4.inventory != var1 || var4.getIndex() >= 36) {
            return false;
         }

         if (!var4.hasStack()) {
            return true;
         }

         ItemStack var5 = var4.getStack();
         return ItemStack.areItemsAndComponentsEqual(var5, var3) && var5.getCount() < var5.getMaxCount();
      } else {
         return false;
      }
   }

   private static int pmz(ScreenHandler var0, PlayerInventory var1, Predicate<ItemStack> var2, Random var3) {
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < var0.slots.size(); var5++) {
         Slot var6 = var0.slots.get(var5);
         if (var6.inventory != var1 && var6.hasStack() && var2.test(var6.getStack())) {
            var4.add(var5);
         }
      }

      return var4.isEmpty() ? -1 : (Integer)var4.get(var3.nextInt(var4.size()));
   }

   private static int pna(ScreenHandler var0, PlayerInventory var1, ItemStack var2, Random var3) {
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();

      for (int var7 = 0; var7 < var0.slots.size(); var7++) {
         Slot var8 = var0.slots.get(var7);
         if (var8.inventory == var1 && var8.getIndex() < 36) {
            if (!var8.hasStack()) {
               (var8.getIndex() < 9 ? var4 : var5).add(var7);
            } else if (ItemStack.areItemsAndComponentsEqual(var8.getStack(), var2) && var8.getStack().getCount() < var8.getStack().getMaxCount()) {
               var6.add(var7);
            }
         }
      }

      ArrayList var9 = !var4.isEmpty() ? var4 : (!var5.isEmpty() ? var5 : var6);
      return var9.isEmpty() ? -1 : (Integer)var9.get(var3.nextInt(var9.size()));
   }

   public static int stashSlot(ScreenHandler var0, PlayerInventory var1, ItemStack var2, int var3) {
      if (var2.isEmpty()) {
         return -1;
      }

      if (pnb(var0, var1, var3, var2, false)) {
         return var3;
      }

      int var4 = -1;

      for (int var5 = 0; var5 < var0.slots.size(); var5++) {
         Slot var6 = var0.slots.get(var5);
         if (var6.inventory != var1) {
            if (!var6.hasStack()) {
               return var5;
            }

            if (var4 == -1 && pnb(var0, var1, var5, var2, false)) {
               var4 = var5;
            }
         }
      }

      if (var4 != -1) {
         return var4;
      }

      for (int var7 = 0; var7 < var0.slots.size(); var7++) {
         if (pnb(var0, var1, var7, var2, true)) {
            return var7;
         }
      }

      return -1;
   }

   private static boolean pnb(ScreenHandler var0, PlayerInventory var1, int var2, ItemStack var3, boolean var4) {
      if (var2 >= 0 && var2 < var0.slots.size()) {
         Slot var5 = var0.slots.get(var2);
         if (var5.inventory == var1 == var4 && (!var4 || var5.getIndex() < 36)) {
            if (!var5.hasStack()) {
               return var5.canInsert(var3);
            }

            ItemStack var6 = var5.getStack();
            return ItemStack.areItemsAndComponentsEqual(var6, var3) && var6.getCount() < Math.min(var6.getMaxCount(), var5.getMaxItemCount(var6));
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static long clickDelay(Random var0) {
      double var1 = 72.0 * Math.exp(var0.nextGaussian() * 0.28);
      if (var0.nextDouble() < 0.05) {
         var1 += 100.0 + var0.nextDouble() * 160.0;
      }

      return Math.round(MathHelper.clamp(var1, 45.0, 320.0));
   }

   public static long travelDelay(Random var0) {
      return Math.round(MathHelper.clamp(160.0 * Math.exp(var0.nextGaussian() * 0.25), 110.0, 300.0));
   }

   public static long settleDelay(Random var0) {
      return Math.round(MathHelper.clamp(150.0 * Math.exp(var0.nextGaussian() * 0.2), 110.0, 260.0));
   }
}
