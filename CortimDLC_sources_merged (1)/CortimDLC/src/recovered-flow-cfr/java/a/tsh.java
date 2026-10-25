/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 */
package a;

import a.pzc;
import a.qnd;
import a.tpx;
import a.tvn;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongPredicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class tsh {
    private static final Map<BlockState, Byte> tsi = new ConcurrentHashMap<BlockState, Byte>();
    private static /* synthetic */ int tsj;
    private static /* synthetic */ String tsk;

    private tsh() {
    }

    public static boolean diamond(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10442) || blockState.method_27852(Blocks.field_29029);
    }

    public static BlockPos standing(World world, ClientPlayerEntity clientPlayerEntity) {
        BlockPos blockPos = clientPlayerEntity.method_24515();
        if (clientPlayerEntity.method_23318() - (double)blockPos.method_10264() >= 0.49 && !world.method_8320(blockPos).method_26220((BlockView)world, blockPos).method_1110()) {
            return blockPos.method_10084();
        }
        return blockPos;
    }

    public static byte kind(World world, BlockPos blockPos, BlockState blockState) {
        boolean bl;
        if (blockState.method_26215()) {
            return 0;
        }
        Byte by = tsi.get(blockState);
        if (by != null) {
            return by;
        }
        boolean bl2 = bl = !blockState.method_26227().method_15769();
        int n = blockState.method_26218((BlockView)world, blockPos).method_1110() ? (bl ? 5 : 0) : (bl || blockState.method_26214((BlockView)world, blockPos) < 0.0f || blockState.method_26220((BlockView)world, blockPos).method_1110() ? 4 : (tsh.diamond(blockState) ? 2 : (qnd.value(blockState) > 0.0f ? 3 : (blockState.method_26234((BlockView)world, blockPos) ? 1 : 6))));
        tsi.put(blockState, (byte)n);
        return (byte)n;
    }

    public static byte code(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos, BlockState blockState, pzc pzc2, Map<BlockState, Boolean> map) {
        byte by = tsh.kind(world, blockPos, blockState);
        if (!tpx.minable(by)) {
            return by;
        }
        if (pzc2 != null && !pzc2.contains(blockPos)) {
            return 4;
        }
        Boolean bl = map.get(blockState);
        if (bl == null) {
            bl = blockState.method_26165((PlayerEntity)clientPlayerEntity, (BlockView)world, blockPos) < 1.0f;
            map.put(blockState, bl);
        }
        return bl != false ? (byte)(by | 8) : by;
    }

    public static tvn snap(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos, pzc pzc2, LongPredicate longPredicate, LongPredicate longPredicate2) {
        byte[] byArray = new byte[2475];
        int n = blockPos.method_10263() - 7;
        int n2 = blockPos.method_10264() - 3;
        int n3 = blockPos.method_10260() - 7;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        IdentityHashMap<BlockState, Boolean> identityHashMap = new IdentityHashMap<BlockState, Boolean>();
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 11; ++j) {
                for (int k = 0; k < 15; ++k) {
                    int n4;
                    mutable.method_10103(n + i, n2 + j, n3 + k);
                    long l = mutable.method_10063();
                    if (longPredicate2 != null && longPredicate2.test(l)) {
                        n4 = 0;
                    } else {
                        n4 = tsh.code(world, clientPlayerEntity, (BlockPos)mutable, world.method_8320((BlockPos)mutable), pzc2, identityHashMap);
                        if (longPredicate != null && tpx.minable((byte)n4) && longPredicate.test(l)) {
                            n4 = 4;
                        }
                    }
                    byArray[tvn.index((int)i, (int)j, (int)k)] = n4;
                }
            }
        }
        return new tvn(n, n2, n3, byArray);
    }

    private static /* synthetic */ int cqa(int n, int n2) {
        return n + n2 + 1251813785;
    }

    private static /* synthetic */ int cqb(int n, int n2) {
        return tsh.cqa(n, n2) + n;
    }

    private static /* synthetic */ int cqc(int n, int n2) {
        return n * n2 | 0xB6119E66;
    }
}

