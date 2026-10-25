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

   private pqf() {
   }

   private static MinecraftClient pqi() {
      return MinecraftClient.method_1551();
   }

   public static double getStandY(BlockPos var0) {
      MinecraftClient var1 = pqi();
      return var1.field_1687 == null ? var0.method_10264() : pqx.getStandY(var1.field_1687, var0);
   }

   public static boolean isBlockedHorizontally() {
      MinecraftClient var0 = pqi();
      return var0.field_1724 == null ? false : var0.field_1724.field_5976 && var0.field_1724.method_18798().method_37268() < 0.0025;
   }

   public static double getFrontStepUp(float var0) {
      MinecraftClient var1 = pqi();
      if (var1.field_1724 != null && var1.field_1687 != null) {
         Vec3d var2 = Vec3d.method_1030(0.0F, var0).method_1029();
         BlockPos var3 = BlockPos.method_49637(
            var1.field_1724.method_23317() + var2.field_1352 * 0.65,
            var1.field_1724.method_23318() + 0.1,
            var1.field_1724.method_23321() + var2.field_1350 * 0.65
         );
         double var4 = Double.NEGATIVE_INFINITY;

         for (int var6 = 0; var6 <= 2; var6++) {
            BlockPos var7 = var3.method_10086(var6);
            VoxelShape var8 = var1.field_1687.method_8320(var7).method_26220(var1.field_1687, var7);
            if (var8.method_1110()) {
               break;
            }

            var4 = var7.method_10264() + var8.method_1105(Axis.field_11052);
         }

         return var4 == Double.NEGATIVE_INFINITY ? 0.0 : Math.max(0.0, var4 - var1.field_1724.method_23318());
      } else {
         return 0.0;
      }
   }

   public static boolean isJumpUseful(float var0) {
      double var1 = getFrontStepUp(var0);
      return var1 > 0.6 && var1 <= 1.25;
   }

   public static boolean onClimbable(PlayerEntity var0) {
      return var0 != null && var0.method_6101() && !var0.method_5799() && !var0.method_31549().field_7479;
   }

   public static Vec3d awayFromClimbable(PlayerEntity var0) {
      MinecraftClient var1 = pqi();
      if (var1.field_1687 != null && var0 != null) {
         BlockPos var2 = var0.method_24515();
         double var3 = 0.0;
         double var5 = 0.0;

         for (BlockPos var10 : new BlockPos[]{var2, var2.method_10084()}) {
            BlockState var11 = var1.field_1687.method_8320(var10);
            if (var11.method_26204() instanceof VineBlock) {
               for (Direction var13 : Type.field_11062) {
                  BooleanProperty var14 = VineBlock.method_10828(var13);
                  if (var14 != null && (Boolean)var11.method_11654(var14)) {
                     var3 -= var13.method_10148();
                     var5 -= var13.method_10165();
                  }
               }
            } else if (var11.method_26204() instanceof LadderBlock) {
               Direction var12 = (Direction)var11.method_11654(LadderBlock.field_11253);
               var3 += var12.method_10148();
               var5 += var12.method_10165();
            }
         }

         if (var3 == 0.0 && var5 == 0.0) {
            for (Direction var17 : Type.field_11062) {
               BlockPos var18 = var2.method_10093(var17);
               boolean var19 = var1.field_1687.method_8320(var18).method_26220(var1.field_1687, var18).method_1110()
                  && var1.field_1687.method_8320(var18.method_10084()).method_26220(var1.field_1687, var18.method_10084()).method_1110()
                  && !var1.field_1687.method_8320(var18).method_26164(BlockTags.field_22414);
               if (var19) {
                  return new Vec3d(var17.method_10148(), 0.0, var17.method_10165());
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
      if (var0.field_1690 != null) {
         var0.field_1690.field_1894.method_23481(false);
         var0.field_1690.field_1881.method_23481(false);
         var0.field_1690.field_1913.method_23481(false);
         var0.field_1690.field_1849.method_23481(false);
         var0.field_1690.field_1903.method_23481(false);
         var0.field_1690.field_1867.method_23481(false);
      }
   }

   public static boolean hasReachedNode(BlockPos var0) {
      MinecraftClient var1 = pqi();
      if (var1.field_1724 == null) {
         return false;
      } else {
         double var2 = var1.field_1724.method_23317() - (var0.method_10263() + 0.5);
         double var4 = var1.field_1724.method_23321() - (var0.method_10260() + 0.5);
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = var6 < 0.36;
         double var9 = var1.field_1724.method_23318() - getStandY(var0);
         boolean var11 = var9 > -0.6 && var9 < 1.6;
         return var8 && var11;
      }
   }
}
