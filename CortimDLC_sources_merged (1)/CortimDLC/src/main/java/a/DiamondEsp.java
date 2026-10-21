/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongArrayList
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.Box3;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class DiamondEsp {
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

    private DiamondEsp() {
    }

    public static boolean isDiamond(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10442) || class_26802.method_27852(class_2246.field_29029);
    }

    public static void scan(class_1937 class_19372, Box3 pzc2, class_243 class_2432) {
        if (class_19372 == null || pzc2 == null || pzc2.maxX < pzc2.minX) {
            DiamondEsp.clear();
            return;
        }
        LongArrayList longArrayList = new LongArrayList();
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = pzc2.minY; i <= pzc2.maxY; ++i) {
            for (int j = pzc2.minX; j <= pzc2.maxX; ++j) {
                for (int k = pzc2.minZ; k <= pzc2.maxZ; ++k) {
                    if (!DiamondEsp.isDiamond(class_19372.method_8320((class_2338)class_23392.method_10103(j, i, k)))) continue;
                    longArrayList.add(class_23392.method_10063());
                }
            }
        }
        if (longArrayList.size() > 600) {
            longArrayList.sort((l, l2) -> Double.compare(DiamondEsp.qxh(l, class_2432), DiamondEsp.qxh(l2, class_2432)));
            longArrayList.size(600);
        }
        qwv = longArrayList.toLongArray();
        qww = new LongOpenHashSet((LongCollection)longArrayList);
    }

    private static double qxh(long l, class_243 class_2432) {
        double d = (double)class_2338.method_10061((long)l) + 0.5 - class_2432.field_1352;
        double d2 = (double)class_2338.method_10071((long)l) + 0.5 - class_2432.field_1351;
        double d3 = (double)class_2338.method_10083((long)l) + 0.5 - class_2432.field_1350;
        return d * d + d2 * d2 + d3 * d3;
    }

    public static void focus(class_2338 class_23382) {
        qwx = class_23382 == null ? Long.MIN_VALUE : class_23382.method_10063();
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
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        long[] lArray = qwv;
        class_310 class_3102 = class_310.method_1551();
        if (lArray.length == 0 || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == qwy) {
            return;
        }
        qwy = FrameDelta.frame();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        LongOpenHashSet longOpenHashSet = qww;
        long l = qwx;
        class_243 class_2432 = usn2.camera();
        float f = usn2.width();
        float f2 = usn2.height();
        DrawUtil.beginBatch();
        try {
            for (long l2 : lArray) {
                float f3;
                double d;
                double d2;
                double d3 = class_2338.method_10061((long)l2);
                if (usn2.depth(d3 + 0.5, (d2 = (double)class_2338.method_10071((long)l2)) + 0.5, (d = (double)class_2338.method_10083((long)l2)) + 0.5) < -1.0f || usn2.depth(d3 + 0.5, d2 + 0.5, d + 0.5) > 2.0f && usn2.project(d3 + 0.5, d2 + 0.5, d + 0.5, qxe) && (qxe[0] < -(f3 = usn2.unitsPerBlock(d3 + 0.5, d2 + 0.5, d + 0.5) * 0.9f) || qxe[1] < -f3 || qxe[0] > f + f3 || qxe[1] > f2 + f3)) continue;
                boolean bl = l2 == l;
                int n = 0;
                if (!bl) {
                    for (int i = 0; i < 6; ++i) {
                        long l3 = class_2338.method_10096((long)l2, (int)qwt[i][0], (int)qwt[i][1], (int)qwt[i][2]);
                        if (l3 == l || !longOpenHashSet.contains(l3)) continue;
                        n |= 1 << i;
                    }
                }
                DiamondEsp.cube(class_3322, usn2, class_2432, d3, d2, d, bl ? -1 : -11541505, n, bl ? 1.6f : 1.0f, bl ? 0.28f : 0.16f);
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    public static void cube(class_332 class_3322, ScreenProjection usn2, class_243 class_2432, double d, double d2, double d3, int n, int n2, float f, float f2) {
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
            DiamondEsp.qwz[n4][0] = (n4 & 1) == 0 ? d5 : d8;
            DiamondEsp.qwz[n4][1] = (n4 & 2) == 0 ? d6 : d9;
            DiamondEsp.qwz[n4][2] = (n4 & 4) == 0 ? d7 : d10;
            DiamondEsp.qxb[n4] = usn2.depth(qwz[n4][0], qwz[n4][1], qwz[n4][2]) > 0.05f && usn2.project(qwz[n4][0], qwz[n4][1], qwz[n4][2], qxa[n4]);
        }
        DiamondEsp.qxc[0] = class_2432.field_1351 < d6;
        DiamondEsp.qxc[1] = class_2432.field_1351 > d9;
        DiamondEsp.qxc[2] = class_2432.field_1350 < d7;
        DiamondEsp.qxc[3] = class_2432.field_1350 > d10;
        DiamondEsp.qxc[4] = class_2432.field_1352 < d5;
        DiamondEsp.qxc[5] = class_2432.field_1352 > d8;
        n4 = ColorUtil.withAlpha(n, Math.round(255.0f * f2));
        for (n3 = 0; n3 < 6; ++n3) {
            int[] object = qws[n3];
            if (!qxc[n3] || (n2 & 1 << n3) != 0 || !qxb[object[0]] || !qxb[object[1]] || !qxb[object[2]] || !qxb[object[3]]) continue;
            DrawUtil.quad(class_3322, qxa[object[0]][0], qxa[object[0]][1], n4, qxa[object[1]][0], qxa[object[1]][1], n4, qxa[object[2]][0], qxa[object[2]][1], n4, qxa[object[3]][0], qxa[object[3]][1], n4);
        }
        n3 = ColorUtil.withAlpha(n, 235);
        for (int[] nArray : qwu) {
            double[] dArray;
            double[] dArray2;
            if ((n2 & (1 << nArray[2] | 1 << nArray[3])) != 0 || !qxc[nArray[2]] && !qxc[nArray[3]] || !usn2.projectSegment((dArray2 = qwz[nArray[0]])[0], dArray2[1], dArray2[2], (dArray = qwz[nArray[1]])[0], dArray[1], dArray[2], 0.05f, qxd, qxe)) continue;
            DrawUtil.line(class_3322, qxd[0], qxd[1], qxd[2], qxd[3], f, n3);
        }
    }

    private static /* synthetic */ int bwj(int n, int n2) {
        return n + n2 ^ 0x6A64D446;
    }

    private static /* synthetic */ int bwk(int n, int n2) {
        return DiamondEsp.bwj(n, n2) + n;
    }

    private static /* synthetic */ int bwl(int n, int n2) {
        return DiamondEsp.bwk(n, n2) * n2;
    }
}

