package a;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongPredicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

public final class tsh {
   private static final Map<BlockState, Byte> tsi = new ConcurrentHashMap<>();

   private tsh() {
   }

   public static boolean diamond(BlockState var0) {
      return var0.isOf(Blocks.DIAMOND_ORE) || var0.isOf(Blocks.DEEPSLATE_DIAMOND_ORE);
   }

   public static BlockPos standing(World var0, ClientPlayerEntity var1) {
      BlockPos var2 = var1.getBlockPos();
      return var1.getY() - var2.getY() >= 0.49 && !var0.getBlockState(var2).getCollisionShape(var0, var2).isEmpty() ? var2.up() : var2;
   }

   public static byte kind(World var0, BlockPos var1, BlockState var2) {
      if (var2.isAir()) {
         return 0;
      }

      Byte var3 = tsi.get(var2);
      if (var3 != null) {
         return var3;
      }

      boolean var5 = !var2.getFluidState().isEmpty();
      int var4;
      if (var2.getOutlineShape(var0, var1).isEmpty()) {
         var4 = var5 ? 5 : 0;
      } else if (var5 || var2.getHardness(var0, var1) < 0.0F || var2.getCollisionShape(var0, var1).isEmpty()) {
         var4 = 4;
      } else if (diamond(var2)) {
         var4 = 2;
      } else if (qnd.value(var2) > 0.0F) {
         var4 = 3;
      } else {
         var4 = var2.isFullCube(var0, var1) ? 1 : 6;
      }

      tsi.put(var2, Byte.valueOf((byte)var4));
      return (byte)var4;
   }

   public static byte code(World var0, ClientPlayerEntity var1, BlockPos var2, BlockState var3, pzc var4, Map<BlockState, Boolean> var5) {
      byte var6 = kind(var0, var2, var3);
      if (!tpx.minable(var6)) {
         return var6;
      }

      if (var4 != null && !var4.contains(var2)) {
         return 4;
      }

      Boolean var7 = (Boolean)var5.get(var3);
      if (var7 == null) {
         var7 = var3.calcBlockBreakingDelta(var1, var0, var2) < 1.0F;
         var5.put(var3, var7);
      }

      return var7 ? (byte)(var6 | 8) : var6;
   }

   public static tvn snap(World var0, ClientPlayerEntity var1, BlockPos var2, pzc var3, LongPredicate var4, LongPredicate var5) {
      byte[] var6 = new byte[2475];
      int var7 = var2.getX() - 7;
      int var8 = var2.getY() - 3;
      int var9 = var2.getZ() - 7;
      Mutable var10 = new Mutable();
      IdentityHashMap var11 = new IdentityHashMap();

      for (int var12 = 0; var12 < 15; var12++) {
         for (int var13 = 0; var13 < 11; var13++) {
            for (int var14 = 0; var14 < 15; var14++) {
               var10.set(var7 + var12, var8 + var13, var9 + var14);
               long var15 = var10.asLong();
               byte var17;
               if (var5 != null && var5.test(var15)) {
                  var17 = 0;
               } else {
                  var17 = code(var0, var1, var10, var0.getBlockState(var10), var3, var11);
                  if (var4 != null && tpx.minable(var17) && var4.test(var15)) {
                     var17 = 4;
                  }
               }

               var6[tvn.index(var12, var13, var14)] = var17;
            }
         }
      }

      return new tvn(var7, var8, var9, var6);
   }
}
