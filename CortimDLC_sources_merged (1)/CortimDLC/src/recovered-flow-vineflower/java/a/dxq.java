package a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BlockModelPart;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.EmptyBlockView;

final class dxq {
   final boolean air;
   final boolean fullCube;
   final boolean water;
   final boolean lava;
   final boolean fluidOnly;
   final int luminance;
   final dxl[][] faces = new dxl[6][];
   final int mapColor;

   dxq(BlockState var1) {
      FluidState var2 = var1.method_26227();
      this.water = var2.method_15767(FluidTags.field_15517);
      this.lava = var2.method_15767(FluidTags.field_15518);
      VoxelShape var3 = var1.method_26218(EmptyBlockView.field_12294, BlockPos.field_10980);
      this.air = var1.method_26215() || var3.method_1110() && var2.method_15769();
      this.fluidOnly = var3.method_1110() && !var2.method_15769();
      this.fullCube = !var3.method_1110() && Block.method_9614(var3);
      this.luminance = var1.method_26213();
      MapColor var4 = var1.method_26205(EmptyBlockView.field_12294, BlockPos.field_10980);
      this.mapColor = var4 != null && var4 != MapColor.field_16008 ? 0xFF000000 | var4.field_16011 : -8355712;
      if (!this.air) {
         BlockStateModel var5 = null;

         try {
            var5 = dyh.dyq.method_1541().method_3349(var1);
         } catch (Throwable var18) {
         }

         List var6 = List.of();
         if (var5 != null) {
            try {
               var6 = var5.method_68512(Random.method_43049(42L));
            } catch (Throwable var17) {
            }
         }

         dxl var7 = null;

         for (Direction var11 : dyh.dyp) {
            ArrayList var12 = new ArrayList(2);

            for (BlockModelPart var14 : var6) {
               for (BakedQuad var16 : var14.method_68509(var11)) {
                  dxt(var12, var16);
               }

               for (BakedQuad var20 : var14.method_68509(null)) {
                  if (var20.comp_3723() == var11) {
                     dxt(var12, var20);
                  }
               }
            }

            if (var12.isEmpty()) {
               if (var7 == null) {
                  var7 = dxu(var1, var5, var6);
               }

               if (var7 != null) {
                  var12.add(var7);
               }
            }

            this.faces[var11.ordinal()] = var12.toArray(new dxl[0]);
         }
      }
   }

   private static void dxt(List<dxl> var0, BakedQuad var1) {
      if (var0.size() < 2) {
         dxy var2 = dyh.ean(var1.comp_3724());
         if (var2 != null) {
            var0.add(new dxl(var2, var1.method_3360() ? var1.comp_3722() : -1));
         }
      }
   }

   private static dxl dxu(BlockState var0, BlockStateModel var1, List<BlockModelPart> var2) {
      for (BlockModelPart var4 : var2) {
         for (BakedQuad var6 : var4.method_68509(null)) {
            dxy var7 = dyh.ean(var6.comp_3724());
            if (var7 != null) {
               return new dxl(var7, var6.method_3360() ? var6.comp_3722() : -1);
            }
         }
      }

      Sprite var9 = null;

      try {
         if (var0.method_26227().method_15767(FluidTags.field_15517) && var0.method_26204() != Blocks.field_10382) {
            var9 = dyh.dyq.method_1541().method_3351().method_3339(Blocks.field_10382.method_9564());
         } else {
            var9 = var1 != null ? var1.method_68511() : dyh.dyq.method_1541().method_3351().method_3339(var0);
         }
      } catch (Throwable var8) {
      }

      dxy var10 = var9 == null ? null : dyh.ean(var9);
      boolean var11 = var0.method_26227().method_15767(FluidTags.field_15517);
      return var10 == null ? null : new dxl(var10, var11 ? 0 : -1);
   }
}
