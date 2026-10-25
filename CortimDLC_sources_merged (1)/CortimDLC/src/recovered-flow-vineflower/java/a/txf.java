package a;

import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public final class txf {
   private txf() {
   }

   public static boolean hazard(BlockState var0) {
      return var0.method_27852(Blocks.field_10164)
         || var0.method_27852(Blocks.field_10036)
         || var0.method_27852(Blocks.field_22089)
         || var0.method_27852(Blocks.field_10092)
         || var0.method_27852(Blocks.field_17350)
         || var0.method_27852(Blocks.field_23860)
         || var0.method_27852(Blocks.field_10029)
         || var0.method_27852(Blocks.field_16999)
         || var0.method_27852(Blocks.field_10606)
         || var0.method_27852(Blocks.field_27879)
         || var0.method_27852(Blocks.field_28048)
         || var0.method_26227().method_15767(FluidTags.field_15518);
   }

   public static int code(BlockView var0, BlockPos var1, BlockState var2, Map<BlockState, Integer> var3) {
      if (var2.method_26215()) {
         return 0;
      } else {
         boolean var4 = !var2.method_31709();
         if (var4) {
            Integer var5 = (Integer)var3.get(var2);
            if (var5 != null) {
               return var5;
            }
         }

         int var10 = 0;
         VoxelShape var6 = var2.method_26220(var0, var1);
         if (!var6.method_1110()) {
            double var7 = var6.method_1105(Axis.field_11052);
            var10 = var7 > 1.0001 ? 9 : Math.max(1, Math.min(8, (int)Math.round(var7 * 8.0)));
            Box var9 = var6.method_1107();
            if (var9.method_17939() < 0.7 || var9.method_17941() < 0.7) {
               var10 |= 128;
            }
         }

         if (var2.method_26227().method_15767(FluidTags.field_15517)) {
            var10 |= 16;
         }

         if (hazard(var2)) {
            var10 |= 32;
         }

         if (var2.method_26164(BlockTags.field_22414)) {
            var10 |= 64;
         }

         if (var4) {
            var3.put(var2, var10);
         }

         return var10;
      }
   }

   public static tzg snap(BlockView var0, int var1, int var2, int var3) {
      byte[] var4 = new byte[1183];
      int var5 = var1 - 6;
      int var6 = var2 - 3;
      int var7 = var3 - 6;
      Mutable var8 = new Mutable();
      IdentityHashMap var9 = new IdentityHashMap();

      for (int var10 = 0; var10 < 13; var10++) {
         for (int var11 = 0; var11 < 7; var11++) {
            for (int var12 = 0; var12 < 13; var12++) {
               var8.method_10103(var5 + var10, var6 + var11, var7 + var12);
               var4[tzg.index(var10, var11, var12)] = (byte)code(var0, var8, var0.method_8320(var8), var9);
            }
         }
      }

      return new tzg(var5, var6, var7, var4);
   }
}
