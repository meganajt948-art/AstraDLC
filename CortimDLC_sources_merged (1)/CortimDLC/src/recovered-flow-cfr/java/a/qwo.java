/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongArrayList
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.hlc;
import a.pzc;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class qwo {
    private static final int qwp = -11541505;
    private static final int qwq = -1;
    private static final int qwr = 600;
    private static final int[][] qws = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
    private static final int[][] qwt = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
    private static final int[][] qwu = new int[][]{{0, 1, 0, 2}, {2, 3, 1, 2}, {4, 5, 0, 3}, {6, 7, 1, 3}, {0, 2, 2, 4}, {1, 3, 2, 5}, {4, 6, 3, 4}, {5, 7, 3, 5}, {0, 4, 0, 4}, {1, 5, 0, 5}, {2, 6, 1, 4}, {3, 7, 1, 5}};
    private static volatile long[] qwv = new long[0];
    private static volatile LongOpenHashSet qww = new LongOpenHashSet();
    private static volatile long qwx = Long.MIN_VALUE;
    private static long qwy = -1L;
    private static final double[][] qwz = new double[8][3];
    private static final float[][] qxa = new float[8][2];
    private static final boolean[] qxb = new boolean[8];
    private static final boolean[] qxc = new boolean[6];
    private static final float[] qxd = new float[4];
    private static final float[] qxe = new float[2];
    private static /* synthetic */ long qxf;
    private static /* synthetic */ long qxg;

    private qwo() {
    }

    public static boolean isDiamond(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10442) || blockState.method_27852(Blocks.field_29029);
    }

    public static void scan(World world, pzc pzc2, Vec3d vec3d) {
        if (world == null || pzc2 == null || pzc2.maxX < pzc2.minX) {
            qwo.clear();
            return;
        }
        LongArrayList longArrayList = new LongArrayList();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = pzc2.minY; i <= pzc2.maxY; ++i) {
            for (int j = pzc2.minX; j <= pzc2.maxX; ++j) {
                for (int k = pzc2.minZ; k <= pzc2.maxZ; ++k) {
                    if (!qwo.isDiamond(world.method_8320((BlockPos)mutable.method_10103(j, i, k)))) continue;
                    longArrayList.add(mutable.method_10063());
                }
            }
        }
        if (longArrayList.size() > 600) {
            longArrayList.sort((l, l2) -> Double.compare(qwo.qxh(l, vec3d), qwo.qxh(l2, vec3d)));
            longArrayList.size(600);
        }
        qwv = longArrayList.toLongArray();
        qww = new LongOpenHashSet((LongCollection)longArrayList);
    }

    private static double qxh(long l, Vec3d vec3d) {
        double d = (double)BlockPos.method_10061((long)l) + 0.5 - vec3d.field_1352;
        double d2 = (double)BlockPos.method_10071((long)l) + 0.5 - vec3d.field_1351;
        double d3 = (double)BlockPos.method_10083((long)l) + 0.5 - vec3d.field_1350;
        return d * d + d2 * d2 + d3 * d3;
    }

    public static void focus(BlockPos blockPos) {
        qwx = blockPos == null ? Long.MIN_VALUE : blockPos.method_10063();
    }

    public static void clear() {
        if (qwv.length > 0) {
            qwv = new long[0];
            qww = new LongOpenHashSet();
        }
        qwx = Long.MIN_VALUE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        long[] lArray = qwv;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (lArray.length == 0 || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == qwy) {
            return;
        }
        qwy = unf.frame();
        try {
            usn2 = usn.capture(renderTickCounter.method_60637(true), drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        LongOpenHashSet longOpenHashSet = qww;
        long l = qwx;
        Vec3d vec3d = usn2.camera();
        float f = usn2.width();
        float f2 = usn2.height();
        uut.beginBatch();
        try {
            for (long l2 : lArray) {
                float f3;
                double d;
                double d2;
                double d3 = BlockPos.method_10061((long)l2);
                if (usn2.depth(d3 + 0.5, (d2 = (double)BlockPos.method_10071((long)l2)) + 0.5, (d = (double)BlockPos.method_10083((long)l2)) + 0.5) < -1.0f || usn2.depth(d3 + 0.5, d2 + 0.5, d + 0.5) > 2.0f && usn2.project(d3 + 0.5, d2 + 0.5, d + 0.5, qxe) && (qxe[0] < -(f3 = usn2.unitsPerBlock(d3 + 0.5, d2 + 0.5, d + 0.5) * 0.9f) || qxe[1] < -f3 || qxe[0] > f + f3 || qxe[1] > f2 + f3)) continue;
                boolean bl = l2 == l;
                int n = 0;
                if (!bl) {
                    for (int i = 0; i < 6; ++i) {
                        long l3 = BlockPos.method_10096((long)l2, (int)qwt[i][0], (int)qwt[i][1], (int)qwt[i][2]);
                        if (l3 == l || !longOpenHashSet.contains(l3)) continue;
                        n |= 1 << i;
                    }
                }
                qwo.cube(drawContext, usn2, vec3d, d3, d2, d, bl ? -1 : -11541505, n, bl ? 1.6f : 1.0f, bl ? 0.28f : 0.16f);
            }
        }
        finally {
            uut.endBatch();
        }
    }

    public static void cube(DrawContext drawContext, usn usn2, Vec3d vec3d, double d, double d2, double d3, int n, int n2, float f, float f2) {
        int n3;
        int n4;
        double d4 = 0.004;
        double d5 = d - d4;
        double d6 = d2 - d4;
        double d7 = d3 - d4;
        double d8 = d + 1.0 + d4;
        double d9 = d2 + 1.0 + d4;
        double d10 = d3 + 1.0 + d4;
        for (n4 = 0; n4 < 8; ++n4) {
            qwo.qwz[n4][0] = (n4 & 1) == 0 ? d5 : d8;
            qwo.qwz[n4][1] = (n4 & 2) == 0 ? d6 : d9;
            qwo.qwz[n4][2] = (n4 & 4) == 0 ? d7 : d10;
            qwo.qxb[n4] = usn2.depth(qwz[n4][0], qwz[n4][1], qwz[n4][2]) > 0.05f && usn2.project(qwz[n4][0], qwz[n4][1], qwz[n4][2], qxa[n4]);
        }
        qwo.qxc[0] = vec3d.field_1351 < d6;
        qwo.qxc[1] = vec3d.field_1351 > d9;
        qwo.qxc[2] = vec3d.field_1350 < d7;
        qwo.qxc[3] = vec3d.field_1350 > d10;
        qwo.qxc[4] = vec3d.field_1352 < d5;
        qwo.qxc[5] = vec3d.field_1352 > d8;
        n4 = ujt.withAlpha(n, Math.round(255.0f * f2));
        for (n3 = 0; n3 < 6; ++n3) {
            int[] object = qws[n3];
            if (!qxc[n3] || (n2 & 1 << n3) != 0 || !qxb[object[0]] || !qxb[object[1]] || !qxb[object[2]] || !qxb[object[3]]) continue;
            uut.quad(drawContext, qxa[object[0]][0], qxa[object[0]][1], n4, qxa[object[1]][0], qxa[object[1]][1], n4, qxa[object[2]][0], qxa[object[2]][1], n4, qxa[object[3]][0], qxa[object[3]][1], n4);
        }
        n3 = ujt.withAlpha(n, 235);
        for (int[] nArray : qwu) {
            double[] dArray;
            double[] dArray2;
            if ((n2 & (1 << nArray[2] | 1 << nArray[3])) != 0 || !qxc[nArray[2]] && !qxc[nArray[3]] || !usn2.projectSegment((dArray2 = qwz[nArray[0]])[0], dArray2[1], dArray2[2], (dArray = qwz[nArray[1]])[0], dArray[1], dArray[2], 0.05f, qxd, qxe)) continue;
            uut.line(drawContext, qxd[0], qxd[1], qxd[2], qxd[3], f, n3);
        }
    }

    private static /* synthetic */ int bwj(int n, int n2) {
        return n + n2 ^ 0x6A64D446;
    }

    private static /* synthetic */ int bwk(int n, int n2) {
        return qwo.bwj(n, n2) + n;
    }

    private static /* synthetic */ int bwl(int n, int n2) {
        return qwo.bwk(n, n2) * n2;
    }
}

