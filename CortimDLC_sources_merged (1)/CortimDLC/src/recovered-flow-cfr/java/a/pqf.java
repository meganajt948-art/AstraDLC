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
        return MinecraftClient.getInstance();
    }

    public static double getStandY(BlockPos blockPos) {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.world == null) {
            return blockPos.getY();
        }
        return pqx.getStandY((BlockView)minecraftClient.world, blockPos);
    }

    public static boolean isBlockedHorizontally() {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.player == null) {
            return false;
        }
        return minecraftClient.player.horizontalCollision && minecraftClient.player.getVelocity().horizontalLengthSquared() < 0.0025;
    }

    public static double getFrontStepUp(float f) {
        BlockPos blockPos;
        VoxelShape voxelShape;
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.player == null || minecraftClient.world == null) {
            return 0.0;
        }
        Vec3d vec3d = Vec3d.fromPolar((float)0.0f, (float)f).normalize();
        BlockPos blockPos2 = BlockPos.ofFloored((double)(minecraftClient.player.getX() + vec3d.x * 0.65), (double)(minecraftClient.player.getY() + 0.1), (double)(minecraftClient.player.getZ() + vec3d.z * 0.65));
        double d = Double.NEGATIVE_INFINITY;
        for (int i = 0; i <= 2 && !(voxelShape = minecraftClient.world.getBlockState(blockPos = blockPos2.up(i)).getCollisionShape((BlockView)minecraftClient.world, blockPos)).isEmpty(); ++i) {
            d = (double)blockPos.getY() + voxelShape.getMax(Direction.Axis.Y);
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return Math.max(0.0, d - minecraftClient.player.getY());
    }

    public static boolean isJumpUseful(float f) {
        double d = pqf.getFrontStepUp(f);
        return d > 0.6 && d <= 1.25;
    }

    public static boolean onClimbable(PlayerEntity playerEntity) {
        return playerEntity != null && playerEntity.isClimbing() && !playerEntity.isTouchingWater() && !playerEntity.getAbilities().flying;
    }

    public static Vec3d awayFromClimbable(PlayerEntity playerEntity) {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.world == null || playerEntity == null) {
            return null;
        }
        BlockPos blockPos = playerEntity.getBlockPos();
        double d = 0.0;
        double d2 = 0.0;
        for (BlockPos blockPos2 : new BlockPos[]{blockPos, blockPos.up()}) {
            BlockState blockState = minecraftClient.world.getBlockState(blockPos2);
            if (blockState.getBlock() instanceof VineBlock) {
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    BooleanProperty booleanProperty = VineBlock.getFacingProperty((Direction)direction);
                    if (booleanProperty == null || !((Boolean)blockState.get((Property)booleanProperty)).booleanValue()) continue;
                    d -= (double)direction.getOffsetX();
                    d2 -= (double)direction.getOffsetZ();
                }
                continue;
            }
            if (!(blockState.getBlock() instanceof LadderBlock)) continue;
            Iterator iterator = (Direction)blockState.get((Property)LadderBlock.FACING);
            d += (double)iterator.getOffsetX();
            d2 += (double)iterator.getOffsetZ();
        }
        if (d != 0.0 || d2 != 0.0) {
            double d3 = Math.hypot(d, d2);
            return new Vec3d(d / d3, 0.0, d2 / d3);
        }
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos blockPos3 = blockPos.offset(direction);
            boolean bl = minecraftClient.world.getBlockState(blockPos3).getCollisionShape((BlockView)minecraftClient.world, blockPos3).isEmpty() && minecraftClient.world.getBlockState(blockPos3.up()).getCollisionShape((BlockView)minecraftClient.world, blockPos3.up()).isEmpty() && !minecraftClient.world.getBlockState(blockPos3).isIn(BlockTags.CLIMBABLE);
            if (!bl) continue;
            return new Vec3d((double)direction.getOffsetX(), 0.0, (double)direction.getOffsetZ());
        }
        return null;
    }

    public static void resetKeys() {
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.options != null) {
            minecraftClient.options.forwardKey.setPressed(false);
            minecraftClient.options.backKey.setPressed(false);
            minecraftClient.options.leftKey.setPressed(false);
            minecraftClient.options.rightKey.setPressed(false);
            minecraftClient.options.jumpKey.setPressed(false);
            minecraftClient.options.sprintKey.setPressed(false);
        }
    }

    public static boolean hasReachedNode(BlockPos blockPos) {
        double d;
        MinecraftClient minecraftClient = pqf.pqi();
        if (minecraftClient.player == null) {
            return false;
        }
        double d2 = minecraftClient.player.getX() - ((double)blockPos.getX() + 0.5);
        double d3 = d2 * d2 + (d = minecraftClient.player.getZ() - ((double)blockPos.getZ() + 0.5)) * d;
        boolean bl = d3 < 0.36;
        double d4 = minecraftClient.player.getY() - pqf.getStandY(blockPos);
        boolean bl2 = d4 > -0.6 && d4 < 1.6;
        return bl && bl2;
    }

    private static /* synthetic */ int bmo(int n, int n2) {
        return n * n2 ^ 0xEAB3C550;
    }
}

