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
        if (minecraftClient.world == null || blockPos == null) {
            return null;
        }
        BlockPos blockPos2 = null;
        double d = Double.MAX_VALUE;
        int n3 = blockPos.getX() >> 4;
        int n4 = blockPos.getZ() >> 4;
        int n5 = (n >> 4) + 1;
        for (int i = -n5; i <= n5; ++i) {
            for (int j = -n5; j <= n5; ++j) {
                WorldChunk worldChunk = minecraftClient.world.getChunkManager().getWorldChunk(n3 + i, n4 + j, false);
                if (worldChunk == null) continue;
                for (BlockEntity blockEntity : worldChunk.getBlockEntities().values()) {
                    double d2;
                    BlockPos blockPos3;
                    SignBlockEntity signBlockEntity;
                    BlockPos blockPos4;
                    if (!(blockEntity instanceof SignBlockEntity) || Math.abs((blockPos4 = (signBlockEntity = (SignBlockEntity)blockEntity).getPos()).getX() - blockPos.getX()) > n || Math.abs(blockPos4.getY() - blockPos.getY()) > n2 || Math.abs(blockPos4.getZ() - blockPos.getZ()) > n || !pte.matches(signBlockEntity, stringArray) || (blockPos3 = pte.chestFor((World)minecraftClient.world, blockPos4)) == null || !((d2 = blockPos3.getSquaredDistance((Vec3i)blockPos)) < d)) continue;
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
            for (Text text : textArray = signBlockEntity.getText(bl).getMessages(false)) {
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
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() instanceof WallSignBlock) {
            BlockPos blockPos2 = blockPos.offset(((Direction)blockState.get((Property)WallSignBlock.FACING)).getOpposite());
            if (pte.isChest(world, blockPos2)) {
                return blockPos2;
            }
            return pte.isChest(world, blockPos.down()) ? blockPos.down() : null;
        }
        if (blockState.getBlock() instanceof WallHangingSignBlock) {
            Direction direction = (Direction)blockState.get((Property)WallHangingSignBlock.FACING);
            for (Direction direction2 : new Direction[]{direction.rotateYClockwise(), direction.rotateYCounterclockwise(), direction.getOpposite()}) {
                if (!pte.isChest(world, blockPos.offset(direction2))) continue;
                return blockPos.offset(direction2);
            }
            return pte.isChest(world, blockPos.down()) ? blockPos.down() : null;
        }
        if (blockState.getBlock() instanceof HangingSignBlock) {
            return pte.isChest(world, blockPos.up()) ? blockPos.up() : null;
        }
        return pte.isChest(world, blockPos.down()) ? blockPos.down() : null;
    }

    public static boolean isChest(World world, BlockPos blockPos) {
        return world.getBlockState(blockPos).getBlock() instanceof ChestBlock;
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

