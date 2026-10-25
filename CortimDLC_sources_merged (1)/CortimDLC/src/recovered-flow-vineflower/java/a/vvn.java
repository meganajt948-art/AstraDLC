package a;

import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BeesComponent;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.apache.commons.lang3.math.Fraction;

public final class vvn {
   private static final Fraction vvo = Fraction.getFraction(1, 16);
   private int vvp = -1;
   private int vvq;
   private int vvr;
   private int vvs = -1;
   private ItemStack vvt = ItemStack.field_8037;
   private boolean vvu;

   public boolean active() {
      return this.vvu;
   }

   public boolean cursorHeld(ClientPlayerEntity var1) {
      return this.vvu && !var1.field_7498.method_34255().method_7960();
   }

   public static BundleContentsComponent contents(ItemStack var0) {
      return var0.method_7909() instanceof BundleItem ? (BundleContentsComponent)var0.method_58694(DataComponentTypes.field_49650) : null;
   }

   public static int[] locate(PlayerInventory var0, Predicate<ItemStack> var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         BundleContentsComponent var3 = contents(var0.method_5438(var2));
         if (var3 != null) {
            for (int var4 = 0; var4 < var3.method_57426(); var4++) {
               if (var1.test(var3.method_57422(var4))) {
                  return new int[]{var2, var4};
               }
            }
         }
      }

      return null;
   }

   public static ItemStack peek(PlayerInventory var0, Predicate<ItemStack> var1) {
      int[] var2 = locate(var0, var1);
      return var2 == null ? ItemStack.field_8037 : contents(var0.method_5438(var2[0])).method_57422(var2[1]);
   }

   public static int count(PlayerInventory var0, Predicate<ItemStack> var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         BundleContentsComponent var4 = contents(var0.method_5438(var3));
         if (var4 != null) {
            for (ItemStack var6 : var4.method_57421()) {
               if (var1.test(var6)) {
                  var2 += var6.method_7947();
               }
            }
         }
      }

      return var2;
   }

   public boolean take(MinecraftClient var1, Predicate<ItemStack> var2, int var3) {
      ClientPlayerEntity var4 = var1.field_1724;
      PlayerInventory var5 = var4.method_31548();
      if (var4.field_7512 == var4.field_7498 && var4.field_7498.method_34255().method_7960()) {
         int[] var6 = locate(var5, var2);
         if (var6 == null) {
            return false;
         } else {
            int var7 = var6[0];
            ItemStack var8 = contents(var5.method_5438(var7)).method_57422(var6[1]);
            Fraction var9 = vwb(var5.method_5438(var7)).add(vwc(var8));
            ItemStack var10 = var5.method_5438(var3);
            int var11 = -1;
            int var12 = -1;
            if (var10.method_7960()) {
               var11 = var3;
            } else {
               var11 = vwe(var5, -1);
               if (var11 < 0 && vvy(var10)) {
                  var12 = vvz(var5, var10, var3, var7, var9);
                  if (var12 >= 0) {
                     var11 = var3;
                  }
               }

               for (int var13 = 0; var13 < 2 && var11 < 0; var13++) {
                  for (int var14 = var13 == 0 ? 0 : 9; var14 < (var13 == 0 ? 9 : 36) && var11 < 0; var14++) {
                     ItemStack var15 = var5.method_5438(var14);
                     if (var14 != var3 && var14 != var7 && vvy(var15)) {
                        var12 = vvz(var5, var15, var14, var7, var9);
                        if (var12 >= 0) {
                           var11 = var14;
                        }
                     }
                  }
               }

               if (var11 < 0 && contents(var10) == null) {
                  var11 = var3;
               }
            }

            if (var11 < 0) {
               return false;
            } else {
               this.vvp = var7;
               this.vvq = var11;
               this.vvr = var3;
               this.vvs = var12;
               this.vvt = ItemStack.field_8037;
               this.vvu = true;
               vwf(var1, var7, var6[1]);
               vwg(var1, var7, 1);
               vwg(var1, var11, 0);
               if (var12 >= 0) {
                  this.vvt = var4.field_7498.method_34255().method_7972();
                  vwg(var1, var12, 0);
               }

               if (var11 != var3 && var4.field_7498.method_34255().method_7960()) {
                  wdq.click(var1, var11, var3);
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   public void giveBack(MinecraftClient var1) {
      if (this.vvu) {
         this.vvu = false;
         ClientPlayerEntity var2 = var1.field_1724;
         if (var2 != null && var2.field_7512 == var2.field_7498) {
            PlayerInventory var3 = var2.method_31548();
            if (this.vvq != this.vvr && vvx(var2).method_7960()) {
               wdq.click(var1, this.vvq, this.vvr);
            }

            if (this.vvs >= 0 && vvx(var2).method_7960()) {
               BundleContentsComponent var4 = contents(var3.method_5438(this.vvs));
               int var5 = var4 == null ? -1 : vwa(var4, this.vvt);
               if (var5 >= 0) {
                  vwf(var1, this.vvs, var5);
                  vwg(var1, this.vvs, 1);
               }
            }

            if (!vvx(var2).method_7960() || !var3.method_5438(this.vvq).method_7960()) {
               vwg(var1, this.vvq, 0);
            }

            if (!vvx(var2).method_7960() && contents(var3.method_5438(this.vvp)) != null) {
               vwg(var1, this.vvp, 0);
            }

            if (!vvx(var2).method_7960()) {
               int var6 = vwe(var3, -1);
               if (var6 >= 0) {
                  vwg(var1, var6, 0);
               }
            }

            this.vvs = -1;
            this.vvt = ItemStack.field_8037;
         }
      }
   }

   private static ItemStack vvx(ClientPlayerEntity var0) {
      return var0.field_7498.method_34255();
   }

   private static boolean vvy(ItemStack var0) {
      return BundleContentsComponent.method_61667(var0) && contents(var0) == null;
   }

   private static int vvz(PlayerInventory var0, ItemStack var1, int var2, int var3, Fraction var4) {
      Fraction var5 = vwc(var1);
      int var6 = -1;

      for (int var7 = 0; var7 < 36; var7++) {
         if (var7 != var2) {
            ItemStack var8 = var0.method_5438(var7);
            BundleContentsComponent var9 = contents(var8);
            if (var9 != null && (var7 == var3 ? var4 : vwb(var8)).compareTo(var5) >= 0) {
               if (vwa(var9, var1) < 0) {
                  return var7;
               }

               if (var6 < 0) {
                  var6 = var7;
               }
            }
         }
      }

      return var6;
   }

   private static int vwa(BundleContentsComponent var0, ItemStack var1) {
      for (int var2 = 0; var2 < var0.method_57426(); var2++) {
         if (ItemStack.method_31577(var0.method_57422(var2), var1)) {
            return var2;
         }
      }

      return -1;
   }

   private static Fraction vwb(ItemStack var0) {
      return Fraction.ONE.subtract(contents(var0).method_57428());
   }

   private static Fraction vwc(ItemStack var0) {
      return vwd(var0).multiplyBy(Fraction.getFraction(var0.method_7947(), 1));
   }

   private static Fraction vwd(ItemStack var0) {
      BundleContentsComponent var1 = (BundleContentsComponent)var0.method_58694(DataComponentTypes.field_49650);
      if (var1 != null) {
         return vvo.add(var1.method_57428());
      } else {
         return !((BeesComponent)var0.method_58695(DataComponentTypes.field_49624, BeesComponent.field_56300)).comp_3585().isEmpty()
            ? Fraction.ONE
            : Fraction.getFraction(1, var0.method_7914());
      }
   }

   private static int vwe(PlayerInventory var0, int var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         if (var2 != var1 && var0.method_5438(var2).method_7960()) {
            return var2;
         }
      }

      return -1;
   }

   private static void vwf(MinecraftClient var0, int var1, int var2) {
      ItemStack var3 = var0.field_1724.method_31548().method_5438(var1);
      BundleContentsComponent var4 = contents(var3);
      int var5 = var4.method_61668();
      if (var5 != var2 && (var2 != 0 || var5 >= 0 && var5 < var4.method_57426())) {
         BundleItem.method_61637(var3, var2);
         var0.method_1562().method_52787(new BundleItemSelectedC2SPacket(wdq.slotId(var1), var2));
      }
   }

   private static void vwg(MinecraftClient var0, int var1, int var2) {
      ClientPlayerEntity var3 = var0.field_1724;
      var0.field_1761.method_2906(var3.field_7498.field_7763, wdq.slotId(var1), var2, SlotActionType.field_7790, var3);
   }
}
