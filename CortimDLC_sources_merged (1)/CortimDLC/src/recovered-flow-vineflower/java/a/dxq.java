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
      FluidState var2 = var1.getFluidState();
      this.water = var2.isIn(FluidTags.WATER);
      this.lava = var2.isIn(FluidTags.LAVA);
      VoxelShape var3 = var1.getOutlineShape(EmptyBlockView.INSTANCE, BlockPos.ORIGIN);
      this.air = var1.isAir() || var3.isEmpty() && var2.isEmpty();
      this.fluidOnly = var3.isEmpty() && !var2.isEmpty();
      this.fullCube = !var3.isEmpty() && Block.isShapeFullCube(var3);
      this.luminance = var1.getLuminance();
      MapColor var4 = var1.getMapColor(EmptyBlockView.INSTANCE, BlockPos.ORIGIN);
      this.mapColor = var4 != null && var4 != MapColor.CLEAR ? 0xFF000000 | var4.color : -8355712;
      if (!this.air) {
         BlockStateModel var5 = null;

         try {
            var5 = dyh.dyq.getBlockRenderManager().getModel(var1);
         } catch (Throwable var18) {
         }

         List var6 = List.of();
         if (var5 != null) {
            try {
               var6 = var5.getParts(Random.create(42L));
            } catch (Throwable var17) {
            }
         }

         dxl var7 = null;

         for (Direction var11 : dyh.dyp) {
            ArrayList var12 = new ArrayList(2);

            for (BlockModelPart var14 : var6) {
               for (BakedQuad var16 : var14.getQuads(var11)) {
                  dxt(var12, var16);
               }

               for (BakedQuad var20 : var14.getQuads(null)) {
                  if (var20.face() == var11) {
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
         dxy var2 = dyh.ean(var1.sprite());
         if (var2 != null) {
            var0.add(new dxl(var2, var1.hasTint() ? var1.tintIndex() : -1));
         }
      }
   }

   private static dxl dxu(BlockState var0, BlockStateModel var1, List<BlockModelPart> var2) {
      for (BlockModelPart var4 : var2) {
         for (BakedQuad var6 : var4.getQuads(null)) {
            dxy var7 = dyh.ean(var6.sprite());
            if (var7 != null) {
               return new dxl(var7, var6.hasTint() ? var6.tintIndex() : -1);
            }
         }
      }

      Sprite var9 = null;

      try {
         if (var0.getFluidState().isIn(FluidTags.WATER) && var0.getBlock() != Blocks.WATER) {
            var9 = dyh.dyq.getBlockRenderManager().getModels().getModelParticleSprite(Blocks.WATER.getDefaultState());
         } else {
            var9 = var1 != null ? var1.particleSprite() : dyh.dyq.getBlockRenderManager().getModels().getModelParticleSprite(var0);
         }
      } catch (Throwable var8) {
      }

      dxy var10 = var9 == null ? null : dyh.ean(var9);
      boolean var11 = var0.getFluidState().isIn(FluidTags.WATER);
      return var10 == null ? null : new dxl(var10, var11 ? 0 : -1);
   }
}
