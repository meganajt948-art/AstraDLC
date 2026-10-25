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
    private static final Direction[] prd = new Direction[]{Direction.field_11043, Direction.field_11035, Direction.field_11034, Direction.field_11039};
    private static /* synthetic */ long pre;
    private static /* synthetic */ int prf;

    private pqx() {
    }

    public static List<BlockPos> findPath(BlockPos blockPos, BlockPos blockPos2, List<BlockPos> list, double d, boolean bl) {
        return pqx.findPath(blockPos, blockPos2, list, d, bl, Collections.emptySet());
    }

    public static List<BlockPos> findPath(BlockPos blockPos, BlockPos blockPos2, List<BlockPos> list, double d, boolean bl, Set<BlockPos> set) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (minecraftClient.field_1687 == null) {
            return null;
        }
        return pqx.findPath((BlockView)minecraftClient.field_1687, (Entity)minecraftClient.field_1724, blockPos, blockPos2, list, d, bl, set);
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
                    d4 *= pqq2.at(blockPos3.method_10263(), blockPos3.method_10260());
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
                if (pqx.isClimbable(blockView, blockPos3) || pqx.isClimbable(blockView, blockPos3.method_10084())) {
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
        BlockPos blockPos2 = blockPos.method_10074();
        VoxelShape voxelShape = blockView.method_8320(blockPos2).method_26220(blockView, blockPos2);
        if (voxelShape.method_1110()) {
            return blockPos.method_10264();
        }
        return (double)blockPos2.method_10264() + voxelShape.method_1105(Direction.Axis.field_11052);
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
            if (bl && (!pqx.prl(blockView, blockPos.method_10069(n, 0, 0)) || !pqx.prl(blockView, blockPos.method_10069(0, 0, n2)) || !pqx.prl(blockView, blockPos.method_10069(n, 1, 0)) || !pqx.prl(blockView, blockPos.method_10069(0, 1, n2)))) continue;
            BlockPos blockPos3 = blockPos.method_10069(n, 0, n2);
            if (pqx.prj(blockView, blockPos3, list, d)) {
                if (set.contains(blockPos3)) continue;
                arrayList.add(blockPos3);
                list2.add(false);
                continue;
            }
            BlockPos blockPos4 = blockPos3.method_10084();
            if (pqx.prj(blockView, blockPos4, list, d)) {
                boolean bl3;
                boolean bl4;
                if (set.contains(blockPos4)) continue;
                double d3 = pqx.getStandY(blockView, blockPos4);
                double d4 = d3 - d2;
                boolean bl5 = d4 <= 0.6 || !bl && pqx.prg(blockView, blockPos3, n, n2, d2);
                boolean bl6 = bl4 = !bl5 && d4 <= 1.2 && !pqx.pri(blockView, blockPos3);
                if (!bl5 && !bl4) continue;
                boolean bl7 = bl3 = bl4 || d3 + 1.8 > (double)blockPos.method_10264() + 2.0 + 1.0E-4;
                if (bl3 && (!pqx.prl(blockView, blockPos.method_10086(2)) || bl && (!pqx.prl(blockView, blockPos.method_10069(n, 2, 0)) || !pqx.prl(blockView, blockPos.method_10069(0, 2, n2))))) continue;
                arrayList.add(blockPos4);
                list2.add(bl4);
                continue;
            }
            if (!pqx.prl(blockView, blockPos3.method_10084())) continue;
            for (int i = 1; i <= 100 && pqx.prl(blockView, (blockPos2 = blockPos3.method_10087(i)).method_10084()) && !pqx.isClimbable(blockView, blockPos2.method_10084()); ++i) {
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
        VoxelShape voxelShape = blockView.method_8320(blockPos).method_26220(blockView, blockPos);
        if (voxelShape.method_1110()) {
            return false;
        }
        double d2 = voxelShape.method_1105(Direction.Axis.field_11052);
        double d3 = n < 0 ? 0.5 : 0.0;
        double d4 = n > 0 ? 0.5 : 1.0;
        double d5 = n2 < 0 ? 0.5 : 0.0;
        double d6 = n2 > 0 ? 0.5 : 1.0;
        double d7 = 0.0;
        for (Box box : voxelShape.method_1090()) {
            if (!(box.field_1320 > d3 + 1.0E-4) || !(box.field_1323 < d4 - 1.0E-4) || !(box.field_1324 > d5 + 1.0E-4) || !(box.field_1321 < d6 - 1.0E-4)) continue;
            d7 = Math.max(d7, box.field_1325);
        }
        if (d7 >= d2 - 1.0E-4) {
            return false;
        }
        return (double)blockPos.method_10264() + d7 - d <= 0.6001 && d2 - d7 <= 0.6001;
    }

    private static double prh(BlockView blockView, BlockPos blockPos, Map<BlockPos, Double> map) {
        Double d = map.get(blockPos);
        if (d != null) {
            return d;
        }
        double d2 = 0.0;
        for (Object object : prd) {
            BlockPos blockPos2 = blockPos.method_10093(object);
            if (pqx.prl(blockView, blockPos2) && pqx.prl(blockView, blockPos2.method_10084())) continue;
            d2 += 0.32;
        }
        int[][] nArray = prc;
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            Object object;
            object = nArray[i];
            if (pqx.prl(blockView, blockPos.method_10069((int)object[0], 0, (int)object[1])) && pqx.prl(blockView, blockPos.method_10069((int)object[0], 1, (int)object[1]))) continue;
            d2 += 0.14;
        }
        map.put(blockPos.method_10062(), d2);
        return d2;
    }

    private static boolean pri(BlockView blockView, BlockPos blockPos) {
        BlockState blockState = blockView.method_8320(blockPos);
        VoxelShape voxelShape = blockState.method_26220(blockView, blockPos);
        if (voxelShape.method_1110()) {
            return false;
        }
        return voxelShape.method_1105(Direction.Axis.field_11052) > 1.0;
    }

    private static boolean prj(BlockView blockView, BlockPos blockPos, List<BlockPos> list, double d) {
        if (!list.isEmpty() && d > 0.0) {
            double d2 = d * d;
            for (BlockPos directionArray : list) {
                if (!(blockPos.method_10262((Vec3i)directionArray) <= d2)) continue;
                return false;
            }
        }
        if (!pqx.prl(blockView, blockPos) || !pqx.prl(blockView, blockPos.method_10084())) {
            return false;
        }
        BlockPos blockPos2 = blockPos.method_10074();
        BlockState blockState = blockView.method_8320(blockPos2);
        if (pqx.prl(blockView, blockPos2) && !blockState.method_27852(Blocks.field_10382)) {
            return false;
        }
        if (pqx.pri(blockView, blockPos2)) {
            return false;
        }
        if (pqx.prk(blockState)) {
            return false;
        }
        BlockState blockState2 = blockView.method_8320(blockPos);
        if (blockState2.method_27852(Blocks.field_10164) || blockState2.method_27852(Blocks.field_10036)) {
            return false;
        }
        for (Direction direction : prd) {
            BlockPos blockPos3 = blockPos.method_10093(direction);
            if (!pqx.prk(blockView.method_8320(blockPos3)) && !pqx.prk(blockView.method_8320(blockPos3.method_10074()))) continue;
            return false;
        }
        return true;
    }

    private static boolean prk(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10164) || blockState.method_27852(Blocks.field_10036) || blockState.method_27852(Blocks.field_17350) || blockState.method_27852(Blocks.field_10092);
    }

    private static boolean prl(BlockView blockView, BlockPos blockPos) {
        BlockState blockState = blockView.method_8320(blockPos);
        return blockState.method_26220(blockView, blockPos).method_1110() && !blockState.method_27852(Blocks.field_10164);
    }

    public static boolean isClimbable(BlockView blockView, BlockPos blockPos) {
        return blockView.method_8320(blockPos).method_26164(BlockTags.field_22414);
    }

    private static boolean prm(BlockView blockView, Entity entity, BlockPos blockPos, BlockPos blockPos2) {
        if (pqx.prn(blockPos, blockPos2) > 4.0) {
            return false;
        }
        Vec3d vec3d = new Vec3d((double)blockPos.method_10263() + 0.5, pqx.getStandY(blockView, blockPos) + 1.62, (double)blockPos.method_10260() + 0.5);
        Vec3d vec3d2 = Vec3d.method_24953((Vec3i)blockPos2);
        BlockHitResult blockHitResult = blockView.method_17742(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.field_17558, RaycastContext.FluidHandling.field_1348, entity == null ? ShapeContext.method_16194() : ShapeContext.method_16195((Entity)entity)));
        return blockHitResult.method_17783() == HitResult.Type.field_1333 || blockHitResult.method_17777().equals((Object)blockPos2);
    }

    private static double prn(BlockPos blockPos, BlockPos blockPos2) {
        double d = blockPos.method_10263() - blockPos2.method_10263();
        double d2 = blockPos.method_10264() - blockPos2.method_10264();
        double d3 = blockPos.method_10260() - blockPos2.method_10260();
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

