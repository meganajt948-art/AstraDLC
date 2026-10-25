package a;

import java.util.List;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public final class pua {
   public static final double STEP = 0.6;

   private pua() {
   }

   public static boolean bodyFits(World var0, Entity var1, double var2, double var4, double var6, double var8) {
      Box var10 = new Box(var2 - var8, var6 + 0.6, var4 - var8, var2 + var8, var6 + 1.8, var4 + var8);

      for (VoxelShape var12 : var0.getBlockCollisions(var1, var10)) {
         if (!var12.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public static boolean water(World var0, double var1, double var3, double var5) {
      Mutable var7 = new Mutable((int)Math.floor(var1), (int)Math.floor(var3 + 0.1), (int)Math.floor(var5));
      if (var0.getFluidState(var7).isIn(FluidTags.WATER)) {
         return true;
      }

      var7.move(Direction.DOWN);
      return var0.getFluidState(var7).isIn(FluidTags.WATER) && var3 - var7.getY() < 1.05;
   }

   public static double standAt(World var0, double var1, double var3, double var5, double var7) {
      int var9 = (int)Math.floor(var1);
      int var10 = (int)Math.floor(var5);
      if (water(var0, var1, var3, var5)) {
         return var3;
      }

      Mutable var11 = new Mutable();
      int var12 = (int)Math.floor(var3 + 0.6);
      int var13 = (int)Math.floor(var3 - var7) - 1;

      for (int var14 = var12; var14 >= var13; var14--) {
         var11.set(var9, var14, var10);
         BlockState var15 = var0.getBlockState(var11);
         VoxelShape var16 = var15.getCollisionShape(var0, var11);
         if (!var16.isEmpty()) {
            double var17 = var14 + var16.getMax(Axis.Y);
            if (var17 > var3 + 0.6 + 1.0E-4) {
               return Double.NaN;
            }

            if (var17 < var3 - var7 - 1.0E-4) {
               return Double.NaN;
            }

            return var17;
         }

         if (var15.getFluidState().isIn(FluidTags.WATER)) {
            return Math.max(var14 + 1.0, var3 - var7);
         }
      }

      return Double.NaN;
   }

   public static boolean hazard(World var0, double var1, double var3, double var5) {
      int var7 = (int)Math.floor(var1);
      int var8 = (int)Math.floor(var5);
      int var9 = (int)Math.floor(var3 + 0.01);
      Mutable var10 = new Mutable();

      for (int var11 = -1; var11 <= 1; var11++) {
         var10.set(var7, var9 + var11, var8);
         if (txf.hazard(var0.getBlockState(var10))) {
            return true;
         }
      }

      return false;
   }

   public static boolean blocked(BlockPos var0, List<BlockPos> var1, double var2, Set<BlockPos> var4) {
      if (var4.isEmpty() || !var4.contains(var0) && !var4.contains(var0.down())) {
         if (!var1.isEmpty() && var2 > 0.0) {
            double var5 = var2 * var2;

            for (BlockPos var8 : var1) {
               double var9 = var8.getX() - var0.getX();
               double var11 = var8.getZ() - var0.getZ();
               double var13 = var8.getY() - var0.getY();
               if (var9 * var9 + var11 * var11 + var13 * var13 <= var5) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
