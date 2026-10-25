/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package a;

import a.pqj;
import a.pqq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;

public final class pqx {
    private static final int pqy = 6000;
    private static final int pqz = 100;
    public static final double STEP_HEIGHT = 0.6;
    public static final double JUMP_HEIGHT = 1.2;
    private static final double pra = 8.0;
    private static final int[][] prb = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final int[][] prc = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final Direction[] prd = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
    private static /* synthetic */ long pre;
    private static /* synthetic */ int prf;

    private pqx() {
    }

    public static List<BlockPos> findPath(BlockPos blockPos, BlockPos blockPos2, List<BlockPos> list, double d, boolean bl) {
        return pqx.findPath(blockPos, blockPos2, list, d, bl, Collections.emptySet());
    }

    public static List<BlockPos> findPath(BlockPos blockPos, BlockPos blockPos2, List<BlockPos> list, double d, boolean bl, Set<BlockPos> set) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
            return null;
        }
        return pqx.findPath((BlockView)minecraftClient.world, (Entity)minecraftClient.player, blockPos, blockPos2, list, d, bl, set);
    }

    public static List<BlockPos> findPath(BlockView blockView, Entity entity, BlockPos blockPos, BlockPos blockPos2, List<BlockPos> list, double d, boolean bl, Set<BlockPos> set) {
        return pqx.findPath(blockView, entity, blockPos, blockPos2, list, d, bl, set, null);
    }

    public static List<BlockPos> findPath(BlockView blockView, Entity entity, BlockPos blockPos, BlockPos blockPos2, List<BlockPos> list, double d, boolean bl, Set<BlockPos> set, pqq pqq2) {
        HashMap<BlockPos, Double> hashMap = bl ? new HashMap<BlockPos, Double>() : null;
        PriorityQueue<pqj> priorityQueue = new PriorityQueue<pqj>(Comparator.comparingDouble(pqj::fCost));
        HashMap<BlockPos, Double> hashMap2 = new HashMap<BlockPos, Double>();
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        pqj pqj2 = new pqj(blockPos);
        pqj2.pqm = 0.0;
        pqj2.pqn = pqx.prn(blockPos, blockPos2);
        priorityQueue.add(pqj2);
        hashMap2.put(blockPos, 0.0);
        pqj pqj3 = pqj2;
        double d2 = pqj2.pqn;
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>(8);
        int n = 0;
        while (!priorityQueue.isEmpty() && n++ < 6000) {
            pqj pqj4 = priorityQueue.poll();
            if (!hashSet.add(pqj4.pqk)) continue;
            if (pqj4.pqn < d2) {
                d2 = pqj4.pqn;
                pqj3 = pqj4;
            }
            if (pqx.prn(pqj4.pqk, blockPos2) <= 2.0 && pqx.prm(blockView, entity, pqj4.pqk, blockPos2)) {
                return pqx.pro(pqj4);
            }
            double d3 = pqx.getStandY(blockView, pqj4.pqk);
            List<BlockPos> list2 = pqx.neighbors(blockView, pqj4.pqk, list, d, set, arrayList);
            for (int i = 0; i < list2.size(); ++i) {
                BlockPos blockPos3 = list2.get(i);
                if (hashSet.contains(blockPos3)) continue;
                double d4 = pqx.prn(pqj4.pqk, blockPos3);
                if (pqq2 != null) {
                    d4 *= pqq2.at(blockPos3.getX(), blockPos3.getZ());
                }
                double d5 = pqx.getStandY(blockView, blockPos3) - d3;
                if (((Boolean)arrayList.get(i)).booleanValue()) {
                    d4 += 0.5;
                }
                if (d5 < -1.5) {
                    d4 += 0.2;
                }
                if (hashMap != null && d5 < -3.2) {
                    d4 += (-d5 - 3.2) * 1.5;
                }
                if (hashMap != null) {
                    d4 += pqx.prh(blockView, blockPos3, hashMap) * (pqq2 == null ? 1.0 : pqq2.wall);
                }
                if (pqx.isClimbable(blockView, blockPos3) || pqx.isClimbable(blockView, blockPos3.up())) {
                    d4 += 8.0;
                }
                double d6 = pqj4.pqm + d4;
                Double d7 = (Double)hashMap2.get(blockPos3);
                if (d7 != null && d6 >= d7 - 1.0E-6) continue;
                hashMap2.put(blockPos3, d6);
                pqj pqj5 = new pqj(blockPos3);
                pqj5.pqm = d6;
                pqj5.pqn = pqx.prn(blockPos3, blockPos2);
                pqj5.pql = pqj4;
                priorityQueue.add(pqj5);
            }
        }
        if (pqj3.pql != null) {
            return pqx.pro(pqj3);
        }
        return null;
    }

    public static double getStandY(BlockView blockView, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.down();
        VoxelShape voxelShape = blockView.getBlockState(blockPos2).getCollisionShape(blockView, blockPos2);
        if (voxelShape.isEmpty()) {
            return blockPos.getY();
        }
        return (double)blockPos2.getY() + voxelShape.getMax(Direction.Axis.Y);
    }

    static List<BlockPos> neighbors(BlockView blockView, BlockPos blockPos, List<BlockPos> list, double d, Set<BlockPos> set, List<Boolean> list2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>(8);
        list2.clear();
        double d2 = pqx.getStandY(blockView, blockPos);
        block0: for (int[] nArray : prb) {
            BlockPos blockPos2;
            boolean bl;
            int n = nArray[0];
            int n2 = nArray[1];
            boolean bl2 = bl = n != 0 && n2 != 0;
            if (bl && (!pqx.prl(blockView, blockPos.add(n, 0, 0)) || !pqx.prl(blockView, blockPos.add(0, 0, n2)) || !pqx.prl(blockView, blockPos.add(n, 1, 0)) || !pqx.prl(blockView, blockPos.add(0, 1, n2)))) continue;
            BlockPos blockPos3 = blockPos.add(n, 0, n2);
            if (pqx.prj(blockView, blockPos3, list, d)) {
                if (set.contains(blockPos3)) continue;
                arrayList.add(blockPos3);
                list2.add(false);
                continue;
            }
            BlockPos blockPos4 = blockPos3.up();
            if (pqx.prj(blockView, blockPos4, list, d)) {
                boolean bl3;
                boolean bl4;
                if (set.contains(blockPos4)) continue;
                double d3 = pqx.getStandY(blockView, blockPos4);
                double d4 = d3 - d2;
                boolean bl5 = d4 <= 0.6 || !bl && pqx.prg(blockView, blockPos3, n, n2, d2);
                boolean bl6 = bl4 = !bl5 && d4 <= 1.2 && !pqx.pri(blockView, blockPos3);
                if (!bl5 && !bl4) continue;
                boolean bl7 = bl3 = bl4 || d3 + 1.8 > (double)blockPos.getY() + 2.0 + 1.0E-4;
                if (bl3 && (!pqx.prl(blockView, blockPos.up(2)) || bl && (!pqx.prl(blockView, blockPos.add(n, 2, 0)) || !pqx.prl(blockView, blockPos.add(0, 2, n2))))) continue;
                arrayList.add(blockPos4);
                list2.add(bl4);
                continue;
            }
            if (!pqx.prl(blockView, blockPos3.up())) continue;
            for (int i = 1; i <= 100 && pqx.prl(blockView, (blockPos2 = blockPos3.down(i)).up()) && !pqx.isClimbable(blockView, blockPos2.up()); ++i) {
                if (!pqx.prj(blockView, blockPos2, list, d)) continue;
                if (set.contains(blockPos2)) continue block0;
                arrayList.add(blockPos2);
                list2.add(false);
                continue block0;
            }
        }
        return arrayList;
    }

    private static boolean prg(BlockView blockView, BlockPos blockPos, int n, int n2, double d) {
        VoxelShape voxelShape = blockView.getBlockState(blockPos).getCollisionShape(blockView, blockPos);
        if (voxelShape.isEmpty()) {
            return false;
        }
        double d2 = voxelShape.getMax(Direction.Axis.Y);
        double d3 = n < 0 ? 0.5 : 0.0;
        double d4 = n > 0 ? 0.5 : 1.0;
        double d5 = n2 < 0 ? 0.5 : 0.0;
        double d6 = n2 > 0 ? 0.5 : 1.0;
        double d7 = 0.0;
        for (Box box : voxelShape.getBoundingBoxes()) {
            if (!(box.maxX > d3 + 1.0E-4) || !(box.minX < d4 - 1.0E-4) || !(box.maxZ > d5 + 1.0E-4) || !(box.minZ < d6 - 1.0E-4)) continue;
            d7 = Math.max(d7, box.maxY);
        }
        if (d7 >= d2 - 1.0E-4) {
            return false;
        }
        return (double)blockPos.getY() + d7 - d <= 0.6001 && d2 - d7 <= 0.6001;
    }

    private static double prh(BlockView blockView, BlockPos blockPos, Map<BlockPos, Double> map) {
        Double d = map.get(blockPos);
        if (d != null) {
            return d;
        }
        double d2 = 0.0;
        for (Object object : prd) {
            BlockPos blockPos2 = blockPos.offset(object);
            if (pqx.prl(blockView, blockPos2) && pqx.prl(blockView, blockPos2.up())) continue;
            d2 += 0.32;
        }
        int[][] nArray = prc;
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            Object object;
            object = nArray[i];
            if (pqx.prl(blockView, blockPos.add((int)object[0], 0, (int)object[1])) && pqx.prl(blockView, blockPos.add((int)object[0], 1, (int)object[1]))) continue;
            d2 += 0.14;
        }
        map.put(blockPos.toImmutable(), d2);
        return d2;
    }

    private static boolean pri(BlockView blockView, BlockPos blockPos) {
        BlockState blockState = blockView.getBlockState(blockPos);
        VoxelShape voxelShape = blockState.getCollisionShape(blockView, blockPos);
        if (voxelShape.isEmpty()) {
            return false;
        }
        return voxelShape.getMax(Direction.Axis.Y) > 1.0;
    }

    private static boolean prj(BlockView blockView, BlockPos blockPos, List<BlockPos> list, double d) {
        if (!list.isEmpty() && d > 0.0) {
            double d2 = d * d;
            for (BlockPos directionArray : list) {
                if (!(blockPos.getSquaredDistance((Vec3i)directionArray) <= d2)) continue;
                return false;
            }
        }
        if (!pqx.prl(blockView, blockPos) || !pqx.prl(blockView, blockPos.up())) {
            return false;
        }
        BlockPos blockPos2 = blockPos.down();
        BlockState blockState = blockView.getBlockState(blockPos2);
        if (pqx.prl(blockView, blockPos2) && !blockState.isOf(Blocks.WATER)) {
            return false;
        }
        if (pqx.pri(blockView, blockPos2)) {
            return false;
        }
        if (pqx.prk(blockState)) {
            return false;
        }
        BlockState blockState2 = blockView.getBlockState(blockPos);
        if (blockState2.isOf(Blocks.LAVA) || blockState2.isOf(Blocks.FIRE)) {
            return false;
        }
        for (Direction direction : prd) {
            BlockPos blockPos3 = blockPos.offset(direction);
            if (!pqx.prk(blockView.getBlockState(blockPos3)) && !pqx.prk(blockView.getBlockState(blockPos3.down()))) continue;
            return false;
        }
        return true;
    }

    private static boolean prk(BlockState blockState) {
        return blockState.isOf(Blocks.LAVA) || blockState.isOf(Blocks.FIRE) || blockState.isOf(Blocks.CAMPFIRE) || blockState.isOf(Blocks.MAGMA_BLOCK);
    }

    private static boolean prl(BlockView blockView, BlockPos blockPos) {
        BlockState blockState = blockView.getBlockState(blockPos);
        return blockState.getCollisionShape(blockView, blockPos).isEmpty() && !blockState.isOf(Blocks.LAVA);
    }

    public static boolean isClimbable(BlockView blockView, BlockPos blockPos) {
        return blockView.getBlockState(blockPos).isIn(BlockTags.CLIMBABLE);
    }

    private static boolean prm(BlockView blockView, Entity entity, BlockPos blockPos, BlockPos blockPos2) {
        if (pqx.prn(blockPos, blockPos2) > 4.0) {
            return false;
        }
        Vec3d vec3d = new Vec3d((double)blockPos.getX() + 0.5, pqx.getStandY(blockView, blockPos) + 1.62, (double)blockPos.getZ() + 0.5);
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos2);
        BlockHitResult blockHitResult = blockView.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, entity == null ? ShapeContext.absent() : ShapeContext.of((Entity)entity)));
        return blockHitResult.getType() == HitResult.Type.MISS || blockHitResult.getBlockPos().equals((Object)blockPos2);
    }

    private static double prn(BlockPos blockPos, BlockPos blockPos2) {
        double d = blockPos.getX() - blockPos2.getX();
        double d2 = blockPos.getY() - blockPos2.getY();
        double d3 = blockPos.getZ() - blockPos2.getZ();
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    private static List<BlockPos> pro(pqj pqj2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        pqj pqj3 = pqj2;
        while (pqj3 != null && pqj3.pql != null) {
            arrayList.add(pqj3.pqk);
            pqj3 = pqj3.pql;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private static /* synthetic */ int bmz(int n, int n2) {
        return n ^ n2 ^ 0xC97FF2F3;
    }

    private static /* synthetic */ int bna(int n, int n2) {
        return n * n2 ^ 0x2A97661F;
    }

    private static /* synthetic */ int bnb(int n, int n2) {
        return pqx.bna(n, n2) * n2;
    }
}

