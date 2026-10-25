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
   pte() {
   }

   public static BlockPos find(MinecraftClient var0, BlockPos var1, String... var2) {
      return find(var0, var1, 10, 5, var2);
   }

   public static BlockPos find(MinecraftClient var0, BlockPos var1, int var2, int var3, String... var4) {
      if (var0.world != null && var1 != null) {
         BlockPos var5 = null;
         double var6 = Double.MAX_VALUE;
         int var8 = var1.getX() >> 4;
         int var9 = var1.getZ() >> 4;
         int var10 = (var2 >> 4) + 1;

         for (int var11 = -var10; var11 <= var10; var11++) {
            for (int var12 = -var10; var12 <= var10; var12++) {
               WorldChunk var13 = var0.world.getChunkManager().getWorldChunk(var8 + var11, var9 + var12, false);
               if (var13 != null) {
                  for (BlockEntity var15 : var13.getBlockEntities().values()) {
                     if (var15 instanceof SignBlockEntity var16) {
                        BlockPos var17 = var16.getPos();
                        if (Math.abs(var17.getX() - var1.getX()) <= var2
                           && Math.abs(var17.getY() - var1.getY()) <= var3
                           && Math.abs(var17.getZ() - var1.getZ()) <= var2
                           && matches(var16, var4)) {
                           BlockPos var18 = chestFor(var0.world, var17);
                           if (var18 != null) {
                              double var19 = var18.getSquaredDistance(var1);
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
         Text[] var6 = var0.getText(var5).getMessages(false);

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
      BlockState var2 = var0.getBlockState(var1);
      if (var2.getBlock() instanceof WallSignBlock) {
         BlockPos var8 = var1.offset(var2.get(WallSignBlock.FACING).getOpposite());
         if (isChest(var0, var8)) {
            return var8;
         } else {
            return isChest(var0, var1.down()) ? var1.down() : null;
         }
      } else if (var2.getBlock() instanceof WallHangingSignBlock) {
         Direction var3 = var2.get(WallHangingSignBlock.FACING);

         for (Direction var7 : new Direction[]{var3.rotateYClockwise(), var3.rotateYCounterclockwise(), var3.getOpposite()}) {
            if (isChest(var0, var1.offset(var7))) {
               return var1.offset(var7);
            }
         }

         return isChest(var0, var1.down()) ? var1.down() : null;
      } else if (var2.getBlock() instanceof HangingSignBlock) {
         return isChest(var0, var1.up()) ? var1.up() : null;
      } else {
         return isChest(var0, var1.down()) ? var1.down() : null;
      }
   }

   public static boolean isChest(World var0, BlockPos var1) {
      return var0.getBlockState(var1).getBlock() instanceof ChestBlock;
   }
}
