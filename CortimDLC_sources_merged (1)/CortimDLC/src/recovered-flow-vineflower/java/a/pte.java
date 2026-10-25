package a;

import flow.dev.a;
import java.util.Locale;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

public final class pte {
   private pte() {
   }

   public static BlockPos find(MinecraftClient var0, BlockPos var1, String... var2) {
      return find(var0, var1, 10, 5, var2);
   }

   public static BlockPos find(MinecraftClient var0, BlockPos var1, int var2, int var3, String... var4) {
      if (var0.field_1687 != null && var1 != null) {
         BlockPos var5 = null;
         double var6 = Double.MAX_VALUE;
         int var8 = var1.method_10263() >> 4;
         int var9 = var1.method_10260() >> 4;
         int var10 = (var2 >> 4) + 1;

         for (int var11 = -var10; var11 <= var10; var11++) {
            for (int var12 = -var10; var12 <= var10; var12++) {
               WorldChunk var13 = var0.field_1687.method_2935().method_12126(var8 + var11, var9 + var12, false);
               if (var13 != null) {
                  for (BlockEntity var15 : var13.method_12214().values()) {
                     if (var15 instanceof SignBlockEntity var16) {
                        BlockPos var17 = var16.method_11016();
                        if (Math.abs(var17.method_10263() - var1.method_10263()) <= var2
                           && Math.abs(var17.method_10264() - var1.method_10264()) <= var3
                           && Math.abs(var17.method_10260() - var1.method_10260()) <= var2
                           && matches(var16, var4)) {
                           BlockPos var18 = chestFor(var0.field_1687, var17);
                           if (var18 != null) {
                              double var19 = var18.method_10262(var1);
                              if (var19 < var6) {
                                 var6 = var19;
                                 var5 = var18;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var5;
      } else {
         return null;
      }
   }

   public static boolean matches(SignBlockEntity var0, String... var1) {
      for (boolean var5 : new boolean[]{true, false}) {
         Text[] var6 = var0.method_49843(var5).method_49877(false);

         for (Text var10 : var6) {
            if (var10 != null) {
               String var11 = var10.getString().replace(a.c(-1697674788, "觽"), "").toLowerCase(Locale.ROOT).replace('ё', 'е');

               for (String var15 : var1) {
                  if (var11.contains(var15)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public static BlockPos chestFor(World var0, BlockPos var1) {
      BlockState var2 = var0.method_8320(var1);
      if (var2.method_26204() instanceof WallSignBlock) {
         BlockPos var8 = var1.method_10093(((Direction)var2.method_11654(WallSignBlock.field_11726)).method_10153());
         if (isChest(var0, var8)) {
            return var8;
         } else {
            return isChest(var0, var1.method_10074()) ? var1.method_10074() : null;
         }
      } else if (var2.method_26204() instanceof WallHangingSignBlock) {
         Direction var3 = (Direction)var2.method_11654(WallHangingSignBlock.field_40319);

         for (Direction var7 : new Direction[]{var3.method_10170(), var3.method_10160(), var3.method_10153()}) {
            if (isChest(var0, var1.method_10093(var7))) {
               return var1.method_10093(var7);
            }
         }

         return isChest(var0, var1.method_10074()) ? var1.method_10074() : null;
      } else if (var2.method_26204() instanceof HangingSignBlock) {
         return isChest(var0, var1.method_10084()) ? var1.method_10084() : null;
      } else {
         return isChest(var0, var1.method_10074()) ? var1.method_10074() : null;
      }
   }

   public static boolean isChest(World var0, BlockPos var1) {
      return var0.method_8320(var1).method_26204() instanceof ChestBlock;
   }
}
