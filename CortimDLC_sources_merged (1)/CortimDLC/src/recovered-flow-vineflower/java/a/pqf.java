package a;

import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.math.Direction.Type;
import net.minecraft.util.shape.VoxelShape;

public final class pqf {
   public static final double MAX_JUMP = 1.25;

   pqf() {
   }

   static MinecraftClient pqi() {
      return MinecraftClient.getInstance();
   }

   public static double getStandY(BlockPos var0) {
      MinecraftClient var1 = pqi();
      return var1.world == null ? var0.getY() : pqx.getStandY(var1.world, var0);
   }

   public static boolean isBlockedHorizontally() {
      MinecraftClient var0 = pqi();
      return var0.player == null ? false : var0.player.horizontalCollision && var0.player.getVelocity().horizontalLengthSquared() < 0.0025;
   }

   public static double getFrontStepUp(float var0) {
      MinecraftClient var1 = pqi();
      if (var1.player != null && var1.world != null) {
         Vec3d var2 = Vec3d.fromPolar(0.0F, var0).normalize();
         BlockPos var3 = BlockPos.ofFloored(var1.player.getX() + var2.x * 0.65, var1.player.getY() + 0.1, var1.player.getZ() + var2.z * 0.65);
         double var4 = Double.NEGATIVE_INFINITY;

         for (int var6 = 0; var6 <= 2; var6++) {
            BlockPos var7 = var3.up(var6);
            VoxelShape var8 = var1.world.getBlockState(var7).getCollisionShape(var1.world, var7);
            if (var8.isEmpty()) {
               break;
            }

            var4 = var7.getY() + var8.getMax(Axis.Y);
         }

         return var4 == Double.NEGATIVE_INFINITY ? 0.0 : Math.max(0.0, var4 - var1.player.getY());
      } else {
         return 0.0;
      }
   }

   public static boolean isJumpUseful(float var0) {
      double var1 = getFrontStepUp(var0);
      return var1 > 0.6 && var1 <= 1.25;
   }

   public static boolean onClimbable(PlayerEntity var0) {
      return var0 != null && var0.isClimbing() && !var0.isTouchingWater() && !var0.getAbilities().flying;
   }

   public static Vec3d awayFromClimbable(PlayerEntity var0) {
      MinecraftClient var1 = pqi();
      if (var1.world != null && var0 != null) {
         BlockPos var2 = var0.getBlockPos();
         double var3 = 0.0;
         double var5 = 0.0;

         for (BlockPos var10 : new BlockPos[]{var2, var2.up()}) {
            BlockState var11 = var1.world.getBlockState(var10);
            if (var11.getBlock() instanceof VineBlock) {
               for (Direction var13 : Type.HORIZONTAL) {
                  BooleanProperty var14 = VineBlock.getFacingProperty(var13);
                  if (var14 != null && var11.get(var14)) {
                     var3 -= var13.getOffsetX();
                     var5 -= var13.getOffsetZ();
                  }
               }
            } else if (var11.getBlock() instanceof LadderBlock) {
               Direction var12 = var11.get(LadderBlock.FACING);
               var3 += var12.getOffsetX();
               var5 += var12.getOffsetZ();
            }
         }

         if (var3 == 0.0 && var5 == 0.0) {
            for (Direction var17 : Type.HORIZONTAL) {
               BlockPos var18 = var2.offset(var17);
               boolean var19 = var1.world.getBlockState(var18).getCollisionShape(var1.world, var18).isEmpty()
                  && var1.world.getBlockState(var18.up()).getCollisionShape(var1.world, var18.up()).isEmpty()
                  && !var1.world.getBlockState(var18).isIn(BlockTags.CLIMBABLE);
               if (var19) {
                  return new Vec3d(var17.getOffsetX(), 0.0, var17.getOffsetZ());
               }
            }

            return null;
         } else {
            double var15 = Math.hypot(var3, var5);
            return new Vec3d(var3 / var15, 0.0, var5 / var15);
         }
      } else {
         return null;
      }
   }

   public static void resetKeys() {
      MinecraftClient var0 = pqi();
      if (var0.options != null) {
         var0.options.forwardKey.setPressed(false);
         var0.options.backKey.setPressed(false);
         var0.options.leftKey.setPressed(false);
         var0.options.rightKey.setPressed(false);
         var0.options.jumpKey.setPressed(false);
         var0.options.sprintKey.setPressed(false);
      }
   }

   public static boolean hasReachedNode(BlockPos var0) {
      MinecraftClient var1 = pqi();
      if (var1.player == null) {
         return false;
      }

      double var2 = var1.player.getX() - (var0.getX() + 0.5);
      double var4 = var1.player.getZ() - (var0.getZ() + 0.5);
      double var6 = var2 * var2 + var4 * var4;
      boolean var8 = var6 < 0.36;
      double var9 = var1.player.getY() - getStandY(var0);
      boolean var11 = var9 > -0.6 && var9 < 1.6;
      return var8 && var11;
   }
}
