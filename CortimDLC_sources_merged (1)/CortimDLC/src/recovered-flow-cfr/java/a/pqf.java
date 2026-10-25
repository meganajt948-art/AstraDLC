/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.LadderBlock
 *  net.minecraft.block.VineBlock
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.Property
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 */
package a;

import a.pqx;
import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public final class pqf {
    public static final double MAX_JUMP = 1.25;
    private static /* synthetic */ boolean pqg;
    private static /* synthetic */ int pqh;

    private pqf() {
    }

    private static MinecraftClient pqi() {
        return MinecraftClient.method_1551();
    }

    public static double getStandY(BlockPos blockPos) {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.field_1687 == null) {
            return blockPos.method_10264();
        }
        return pqx.getStandY((BlockView)minecraftClient.field_1687, blockPos);
    }

    public static boolean isBlockedHorizontally() {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.field_1724 == null) {
            return false;
        }
        return minecraftClient.field_1724.field_5976 && minecraftClient.field_1724.method_18798().method_37268() < 0.0025;
    }

    public static double getFrontStepUp(float f) {
        BlockPos blockPos;
        VoxelShape voxelShape;
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.field_1724 == null || minecraftClient.field_1687 == null) {
            return 0.0;
        }
        Vec3d vec3d = Vec3d.method_1030((float)0.0f, (float)f).method_1029();
        BlockPos blockPos2 = BlockPos.method_49637((double)(minecraftClient.field_1724.method_23317() + vec3d.field_1352 * 0.65), (double)(minecraftClient.field_1724.method_23318() + 0.1), (double)(minecraftClient.field_1724.method_23321() + vec3d.field_1350 * 0.65));
        double d = Double.NEGATIVE_INFINITY;
        for (int i = 0; i <= 2 && !(voxelShape = minecraftClient.field_1687.method_8320(blockPos = blockPos2.method_10086(i)).method_26220((BlockView)minecraftClient.field_1687, blockPos)).method_1110(); ++i) {
            d = (double)blockPos.method_10264() + voxelShape.method_1105(Direction.Axis.field_11052);
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return Math.max(0.0, d - minecraftClient.field_1724.method_23318());
    }

    public static boolean isJumpUseful(float f) {
        double d = pqf.getFrontStepUp(f);
        return d > 0.6 && d <= 1.25;
    }

    public static boolean onClimbable(PlayerEntity playerEntity) {
        return playerEntity != null && playerEntity.method_6101() && !playerEntity.method_5799() && !playerEntity.method_31549().field_7479;
    }

    public static Vec3d awayFromClimbable(PlayerEntity playerEntity) {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.field_1687 == null || playerEntity == null) {
            return null;
        }
        BlockPos blockPos = playerEntity.method_24515();
        double d = 0.0;
        double d2 = 0.0;
        for (BlockPos blockPos2 : new BlockPos[]{blockPos, blockPos.method_10084()}) {
            BlockState blockState = minecraftClient.field_1687.method_8320(blockPos2);
            if (blockState.method_26204() instanceof VineBlock) {
                for (Direction direction : Direction.Type.field_11062) {
                    BooleanProperty booleanProperty = VineBlock.method_10828((Direction)direction);
                    if (booleanProperty == null || !((Boolean)blockState.method_11654((Property)booleanProperty)).booleanValue()) continue;
                    d -= (double)direction.method_10148();
                    d2 -= (double)direction.method_10165();
                }
                continue;
            }
            if (!(blockState.method_26204() instanceof LadderBlock)) continue;
            Iterator iterator = (Direction)blockState.method_11654((Property)LadderBlock.field_11253);
            d += (double)iterator.method_10148();
            d2 += (double)iterator.method_10165();
        }
        if (d != 0.0 || d2 != 0.0) {
            double d3 = Math.hypot(d, d2);
            return new Vec3d(d / d3, 0.0, d2 / d3);
        }
        for (Direction direction : Direction.Type.field_11062) {
            BlockPos blockPos3 = blockPos.method_10093(direction);
            boolean bl = minecraftClient.field_1687.method_8320(blockPos3).method_26220((BlockView)minecraftClient.field_1687, blockPos3).method_1110() && minecraftClient.field_1687.method_8320(blockPos3.method_10084()).method_26220((BlockView)minecraftClient.field_1687, blockPos3.method_10084()).method_1110() && !minecraftClient.field_1687.method_8320(blockPos3).method_26164(BlockTags.field_22414);
            if (!bl) continue;
            return new Vec3d((double)direction.method_10148(), 0.0, (double)direction.method_10165());
        }
        return null;
    }

    public static void resetKeys() {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.field_1690 != null) {
            minecraftClient.field_1690.field_1894.method_23481(false);
            minecraftClient.field_1690.field_1881.method_23481(false);
            minecraftClient.field_1690.field_1913.method_23481(false);
            minecraftClient.field_1690.field_1849.method_23481(false);
            minecraftClient.field_1690.field_1903.method_23481(false);
            minecraftClient.field_1690.field_1867.method_23481(false);
        }
    }

    public static boolean hasReachedNode(BlockPos blockPos) {
        double d;
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.field_1724 == null) {
            return false;
        }
        double d2 = minecraftClient.field_1724.method_23317() - ((double)blockPos.method_10263() + 0.5);
        double d3 = d2 * d2 + (d = minecraftClient.field_1724.method_23321() - ((double)blockPos.method_10260() + 0.5)) * d;
        boolean bl = d3 < 0.36;
        double d4 = minecraftClient.field_1724.method_23318() - pqf.getStandY(blockPos);
        boolean bl2 = d4 > -0.6 && d4 < 1.6;
        return bl && bl2;
    }

    private static /* synthetic */ int bmo(int n, int n2) {
        return n * n2 ^ 0xEAB3C550;
    }
}

