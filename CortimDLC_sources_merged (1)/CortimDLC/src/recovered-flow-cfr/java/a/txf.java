/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 */
package a;

import a.tzg;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public final class txf {
    private static /* synthetic */ int txg;
    private static /* synthetic */ long txh;

    private txf() {
    }

    public static boolean hazard(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10164) || blockState.method_27852(Blocks.field_10036) || blockState.method_27852(Blocks.field_22089) || blockState.method_27852(Blocks.field_10092) || blockState.method_27852(Blocks.field_17350) || blockState.method_27852(Blocks.field_23860) || blockState.method_27852(Blocks.field_10029) || blockState.method_27852(Blocks.field_16999) || blockState.method_27852(Blocks.field_10606) || blockState.method_27852(Blocks.field_27879) || blockState.method_27852(Blocks.field_28048) || blockState.method_26227().method_15767(FluidTags.field_15518);
    }

    public static int code(BlockView blockView, BlockPos blockPos, BlockState blockState, Map<BlockState, Integer> map) {
        Integer n;
        boolean bl;
        if (blockState.method_26215()) {
            return 0;
        }
        boolean bl2 = bl = !blockState.method_31709();
        if (bl && (n = map.get(blockState)) != null) {
            return n;
        }
        int n2 = 0;
        VoxelShape voxelShape = blockState.method_26220(blockView, blockPos);
        if (!voxelShape.method_1110()) {
            double d = voxelShape.method_1105(Direction.Axis.field_11052);
            n2 = d > 1.0001 ? 9 : Math.max(1, Math.min(8, (int)Math.round(d * 8.0)));
            Box box = voxelShape.method_1107();
            if (box.method_17939() < 0.7 || box.method_17941() < 0.7) {
                n2 |= 0x80;
            }
        }
        if (blockState.method_26227().method_15767(FluidTags.field_15517)) {
            n2 |= 0x10;
        }
        if (txf.hazard(blockState)) {
            n2 |= 0x20;
        }
        if (blockState.method_26164(BlockTags.field_22414)) {
            n2 |= 0x40;
        }
        if (bl) {
            map.put(blockState, n2);
        }
        return n2;
    }

    public static tzg snap(BlockView blockView, int n, int n2, int n3) {
        byte[] byArray = new byte[1183];
        int n4 = n - 6;
        int n5 = n2 - 3;
        int n6 = n3 - 6;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        IdentityHashMap<BlockState, Integer> identityHashMap = new IdentityHashMap<BlockState, Integer>();
        for (int i = 0; i < 13; ++i) {
            for (int j = 0; j < 7; ++j) {
                for (int k = 0; k < 13; ++k) {
                    mutable.method_10103(n4 + i, n5 + j, n6 + k);
                    byArray[tzg.index((int)i, (int)j, (int)k)] = (byte)txf.code(blockView, (BlockPos)mutable, blockView.method_8320((BlockPos)mutable), identityHashMap);
                }
            }
        }
        return new tzg(n4, n5, n6, byArray);
    }

    private static /* synthetic */ int csn(int n, int n2) {
        return n ^ n2 ^ 0xDADE5568;
    }

    private static /* synthetic */ int cso(int n, int n2) {
        return txf.csn(n, n2) ^ 0xA6F5CC4;
    }
}

