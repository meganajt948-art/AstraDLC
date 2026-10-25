/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 */
package a;

import a.txf;
import java.util.List;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class pua {
    public static final double STEP = 0.6;
    private static /* synthetic */ String pub;
    private static /* synthetic */ boolean puc;

    private pua() {
    }

    public static boolean bodyFits(World world, Entity entity, double d, double d2, double d3, double d4) {
        Box box = new Box(d - d4, d3 + 0.6, d2 - d4, d + d4, d3 + 1.8, d2 + d4);
        for (VoxelShape voxelShape : world.getBlockCollisions(entity, box)) {
            if (voxelShape.isEmpty()) continue;
            return false;
        }
        return true;
    }

    public static boolean water(World world, double d, double d2, double d3) {
        BlockPos.Mutable mutable = new BlockPos.Mutable((int)Math.floor(d), (int)Math.floor(d2 + 0.1), (int)Math.floor(d3));
        if (world.getFluidState((BlockPos)mutable).isIn(FluidTags.WATER)) {
            return true;
        }
        mutable.move(Direction.DOWN);
        return world.getFluidState((BlockPos)mutable).isIn(FluidTags.WATER) && d2 - (double)mutable.getY() < 1.05;
    }

    public static double standAt(World world, double d, double d2, double d3, double d4) {
        int n = (int)Math.floor(d);
        int n2 = (int)Math.floor(d3);
        if (pua.water(world, d, d2, d3)) {
            return d2;
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int n3 = (int)Math.floor(d2 + 0.6);
        int n4 = (int)Math.floor(d2 - d4) - 1;
        for (int i = n3; i >= n4; --i) {
            mutable.set(n, i, n2);
            BlockState blockState = world.getBlockState((BlockPos)mutable);
            VoxelShape voxelShape = blockState.getCollisionShape((BlockView)world, (BlockPos)mutable);
            if (voxelShape.isEmpty()) {
                if (!blockState.getFluidState().isIn(FluidTags.WATER)) continue;
                return Math.max((double)i + 1.0, d2 - d4);
            }
            double d5 = (double)i + voxelShape.getMax(Direction.Axis.Y);
            if (d5 > d2 + 0.6 + 1.0E-4) {
                return Double.NaN;
            }
            if (d5 < d2 - d4 - 1.0E-4) {
                return Double.NaN;
            }
            return d5;
        }
        return Double.NaN;
    }

    public static boolean hazard(World world, double d, double d2, double d3) {
        int n = (int)Math.floor(d);
        int n2 = (int)Math.floor(d3);
        int n3 = (int)Math.floor(d2 + 0.01);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = -1; i <= 1; ++i) {
            mutable.set(n, n3 + i, n2);
            if (!txf.hazard(world.getBlockState((BlockPos)mutable))) continue;
            return true;
        }
        return false;
    }

    public static boolean blocked(BlockPos blockPos, List<BlockPos> list, double d, Set<BlockPos> set) {
        if (!set.isEmpty() && (set.contains(blockPos) || set.contains(blockPos.down()))) {
            return true;
        }
        if (!list.isEmpty() && d > 0.0) {
            double d2 = d * d;
            for (BlockPos blockPos2 : list) {
                double d3;
                double d4;
                double d5 = blockPos2.getX() - blockPos.getX();
                if (!(d5 * d5 + (d4 = (double)(blockPos2.getZ() - blockPos.getZ())) * d4 + (d3 = (double)(blockPos2.getY() - blockPos.getY())) * d3 <= d2)) continue;
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ int bos(int n, int n2) {
        return n * n2 ^ 0xFF087E17;
    }
}

