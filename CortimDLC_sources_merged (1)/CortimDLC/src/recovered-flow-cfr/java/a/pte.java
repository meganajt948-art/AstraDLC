/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.HangingSignBlock
 *  net.minecraft.block.WallHangingSignBlock
 *  net.minecraft.block.WallSignBlock
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.SignBlockEntity
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.state.property.Property
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.WorldChunk
 */
package a;

import flow.dev.a;
import java.util.Locale;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

public final class pte {
    private static /* synthetic */ int ptf;
    private static /* synthetic */ int ptg;

    private pte() {
    }

    public static BlockPos find(MinecraftClient minecraftClient, BlockPos blockPos, String ... stringArray) {
        return pte.find(minecraftClient, blockPos, 10, 5, stringArray);
    }

    public static BlockPos find(MinecraftClient minecraftClient, BlockPos blockPos, int n, int n2, String ... stringArray) {
        if (minecraftClient.field_1687 == null || blockPos == null) {
            return null;
        }
        BlockPos blockPos2 = null;
        double d = Double.MAX_VALUE;
        int n3 = blockPos.method_10263() >> 4;
        int n4 = blockPos.method_10260() >> 4;
        int n5 = (n >> 4) + 1;
        for (int i = -n5; i <= n5; ++i) {
            for (int j = -n5; j <= n5; ++j) {
                WorldChunk worldChunk = minecraftClient.field_1687.method_2935().method_12126(n3 + i, n4 + j, false);
                if (worldChunk == null) continue;
                for (BlockEntity blockEntity : worldChunk.method_12214().values()) {
                    double d2;
                    BlockPos blockPos3;
                    SignBlockEntity signBlockEntity;
                    BlockPos blockPos4;
                    if (!(blockEntity instanceof SignBlockEntity) || Math.abs((blockPos4 = (signBlockEntity = (SignBlockEntity)blockEntity).method_11016()).method_10263() - blockPos.method_10263()) > n || Math.abs(blockPos4.method_10264() - blockPos.method_10264()) > n2 || Math.abs(blockPos4.method_10260() - blockPos.method_10260()) > n || !pte.matches(signBlockEntity, stringArray) || (blockPos3 = pte.chestFor((World)minecraftClient.field_1687, blockPos4)) == null || !((d2 = blockPos3.method_10262((Vec3i)blockPos)) < d)) continue;
                    d = d2;
                    blockPos2 = blockPos3;
                }
            }
        }
        return blockPos2;
    }

    public static boolean matches(SignBlockEntity signBlockEntity, String ... stringArray) {
        for (boolean bl : new boolean[]{true, false}) {
            Text[] textArray;
            for (Text text : textArray = signBlockEntity.method_49843(bl).method_49877(false)) {
                if (text == null) continue;
                String string = text.getString().replace(a.c(-1697674788, "\u89fd"), "").toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
                for (String string2 : stringArray) {
                    if (!string.contains(string2)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static BlockPos chestFor(World world, BlockPos blockPos) {
        BlockState blockState = world.method_8320(blockPos);
        if (blockState.method_26204() instanceof WallSignBlock) {
            BlockPos blockPos2 = blockPos.method_10093(((Direction)blockState.method_11654((Property)WallSignBlock.field_11726)).method_10153());
            if (pte.isChest(world, blockPos2)) {
                return blockPos2;
            }
            return pte.isChest(world, blockPos.method_10074()) ? blockPos.method_10074() : null;
        }
        if (blockState.method_26204() instanceof WallHangingSignBlock) {
            Direction direction = (Direction)blockState.method_11654((Property)WallHangingSignBlock.field_40319);
            for (Direction direction2 : new Direction[]{direction.method_10170(), direction.method_10160(), direction.method_10153()}) {
                if (!pte.isChest(world, blockPos.method_10093(direction2))) continue;
                return blockPos.method_10093(direction2);
            }
            return pte.isChest(world, blockPos.method_10074()) ? blockPos.method_10074() : null;
        }
        if (blockState.method_26204() instanceof HangingSignBlock) {
            return pte.isChest(world, blockPos.method_10084()) ? blockPos.method_10084() : null;
        }
        return pte.isChest(world, blockPos.method_10074()) ? blockPos.method_10074() : null;
    }

    public static boolean isChest(World world, BlockPos blockPos) {
        return world.method_8320(blockPos).method_26204() instanceof ChestBlock;
    }

    private static /* synthetic */ int bog(int n, int n2) {
        return n - n2 + 458206696;
    }

    private static /* synthetic */ int boh(int n, int n2) {
        return n * n2 + 1005050481;
    }

    private static /* synthetic */ int boi(int n, int n2) {
        return pte.boh(n, n2) + n;
    }
}

