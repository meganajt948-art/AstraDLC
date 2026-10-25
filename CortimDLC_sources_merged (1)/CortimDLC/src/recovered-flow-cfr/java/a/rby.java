/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 */
package a;

import a.hlc;
import a.kfa;
import a.kfe;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vcj;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class rby
extends kfe {
    private static rby rbz;
    private final vlv rca = this.add(new vlv("Mode", "Box", "Box", "Corners", "Face"));
    private final vla rcb = this.add(new vla("Color", "Theme"));
    private final vmc rcc = this.add(new vmc("Width", 1.2, 0.5, 3.0, 0.1));
    private final vmc rcd = this.add(new vmc("Corner size", 0.25, 0.1, 0.5, 0.01).percent());
    private final vmc rce = this.add(new vmc("Fill", 0.12, 0.0, 0.5, 0.01).percent());
    private final vmc rcf = this.add(new vmc("Glow", 0.5, 0.0, 1.0, 0.05).percent());
    private final vkl rcg = this.add(new vkl("Smooth", true));
    private final double[] rch = new double[6];
    private boolean rci;
    private Direction rcj = Direction.field_11036;
    private final vcj rck = new vcj(14.0f);
    private long rcl = -1L;
    private final double[][] rcm = new double[8][3];
    private final float[] rcn = new float[4];
    private final float[] rco = new float[3];
    private final float[][] rcp = new float[8][3];
    private final boolean[] rcq = new boolean[8];
    private final boolean[] rcr = new boolean[6];
    private static final int[][] rcs;
    private static final Direction[] rct;
    private static final int[][] rcu;
    private static /* synthetic */ long rcv;
    private static /* synthetic */ long rcw;

    public rby() {
        super(new String(new char[]{'B', 'l', 'o', 'c', 'k', 'O', 'u', 't', 'l', 'i', 'n', 'e'}), "A clean outline on the block you aim at", kfa.RENDER);
        rbz = this;
        this.rcd.visibleWhen(() -> this.rca.is("Corners"));
    }

    public static boolean vanilla() {
        return rbz == null || !rbz.isEnabled();
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        rby rby2 = rbz;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rby2 == null || !rby2.isEnabled() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            if (rby2 != null) {
                rby2.rci = false;
                rby2.rck.set(0.0f);
            }
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rby2.rcl) {
            return;
        }
        rby2.rcl = unf.frame();
        rby2.rcx(drawContext, minecraftClient, renderTickCounter.method_60637(true), unf.delta());
    }

    private void rcx(DrawContext drawContext, MinecraftClient minecraftClient, float f, float f2) {
        boolean bl;
        usn usn2;
        VoxelShape voxelShape;
        BlockState blockState;
        BlockHitResult blockHitResult;
        Box box = null;
        HitResult hitResult = minecraftClient.field_1765;
        if (hitResult instanceof BlockHitResult && (blockHitResult = (BlockHitResult)hitResult).method_17783() == HitResult.Type.field_1332 && !(blockState = minecraftClient.field_1687.method_8320((BlockPos)(hitResult = blockHitResult.method_17777()))).method_26215() && minecraftClient.field_1687.method_8621().method_11952((BlockPos)hitResult) && !(voxelShape = blockState.method_26172((BlockView)minecraftClient.field_1687, (BlockPos)hitResult, ShapeContext.method_16195((Entity)minecraftClient.method_1560()))).method_1110()) {
            box = voxelShape.method_1107().method_996((BlockPos)hitResult);
            this.rcj = blockHitResult.method_17780();
        }
        float f3 = this.rck.step(box != null, f2);
        if (box != null) {
            if (!this.rci || !this.rcg.get() || f3 < 0.05f) {
                this.rdb(box);
            } else {
                double d = 1.0 - Math.exp((double)(-f2) * 26.0);
                this.rch[0] = this.rch[0] + (box.field_1323 - this.rch[0]) * d;
                this.rch[1] = this.rch[1] + (box.field_1322 - this.rch[1]) * d;
                this.rch[2] = this.rch[2] + (box.field_1321 - this.rch[2]) * d;
                this.rch[3] = this.rch[3] + (box.field_1320 - this.rch[3]) * d;
                this.rch[4] = this.rch[4] + (box.field_1325 - this.rch[4]) * d;
                this.rch[5] = this.rch[5] + (box.field_1324 - this.rch[5]) * d;
            }
            this.rci = true;
        }
        if (!this.rci || f3 <= 0.01f) {
            this.rci = this.rci && f3 > 0.01f;
            return;
        }
        try {
            usn2 = usn.capture(f, drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        double d = 0.002;
        for (int i = 0; i < 8; ++i) {
            this.rcm[i][0] = (i & 1) == 0 ? this.rch[0] - d : this.rch[3] + d;
            this.rcm[i][1] = (i & 2) == 0 ? this.rch[1] - d : this.rch[4] + d;
            this.rcm[i][2] = (i & 4) == 0 ? this.rch[2] - d : this.rch[5] + d;
            this.rcq[i] = usn2.depth(this.rcm[i][0], this.rcm[i][1], this.rcm[i][2]) > 0.05f && usn2.project3(this.rcm[i][0], this.rcm[i][1], this.rcm[i][2], this.rcp[i]);
        }
        Vec3d vec3d = usn2.camera();
        for (bl = false; bl < 6 != 0; bl += 1) {
            this.rcr[bl] = this.rdc(bl ? 1 : 0, vec3d);
        }
        bl = this.rca.is("Face");
        int n = this.rcb.color() | 0xFF000000;
        uut.beginFrame();
        uut.pushAlpha(f3);
        this.rcy(drawContext, n, bl);
        this.rcz(drawContext, usn2, n, bl);
        uut.popAlpha();
    }

    private void rcy(DrawContext drawContext, int n, boolean bl) {
        float f = (float)this.rce.get();
        if (f <= 0.005f) {
            return;
        }
        for (int i = 0; i < 6; ++i) {
            int[] nArray;
            if (!this.rcr[i] || bl && rct[i] != this.rcj || !this.rcq[(nArray = rcs[i])[0]] || !this.rcq[nArray[1]] || !this.rcq[nArray[2]] || !this.rcq[nArray[3]]) continue;
            int n2 = ujt.withAlpha(n, Math.round(255.0f * f * (rct[i] == this.rcj ? 1.0f : 0.55f)));
            uut.quad(drawContext, this.rcp[nArray[0]][0], this.rcp[nArray[0]][1], n2, this.rcp[nArray[1]][0], this.rcp[nArray[1]][1], n2, this.rcp[nArray[2]][0], this.rcp[nArray[2]][1], n2, this.rcp[nArray[3]][0], this.rcp[nArray[3]][1], n2);
        }
    }

    private void rcz(DrawContext drawContext, usn usn2, int n, boolean bl) {
        float f = (float)this.rcc.get();
        float f2 = (float)this.rcf.get();
        int n2 = ujt.withAlpha(n, 225);
        int n3 = ujt.withAlpha(n, Math.round(110.0f * f2));
        boolean bl2 = this.rca.is("Corners");
        double d = this.rcd.get();
        for (int[] nArray : rcu) {
            boolean bl3;
            boolean bl4 = bl ? (rct[nArray[2]] == this.rcj || rct[nArray[3]] == this.rcj) && (this.rcr[nArray[2]] || this.rcr[nArray[3]]) : (bl3 = this.rcr[nArray[2]] || this.rcr[nArray[3]]);
            if (!bl3) continue;
            double[] dArray = this.rcm[nArray[0]];
            double[] dArray2 = this.rcm[nArray[1]];
            if (bl2) {
                this.rda(drawContext, usn2, dArray, dArray2, 0.0, d, f, n2, n3, f2);
                this.rda(drawContext, usn2, dArray, dArray2, 1.0 - d, 1.0, f, n2, n3, f2);
                continue;
            }
            this.rda(drawContext, usn2, dArray, dArray2, 0.0, 1.0, f, n2, n3, f2);
        }
    }

    private void rda(DrawContext drawContext, usn usn2, double[] dArray, double[] dArray2, double d, double d2, float f, int n, int n2, float f2) {
        double d3 = dArray[0] + (dArray2[0] - dArray[0]) * d;
        double d4 = dArray[1] + (dArray2[1] - dArray[1]) * d;
        double d5 = dArray[2] + (dArray2[2] - dArray[2]) * d;
        double d6 = dArray[0] + (dArray2[0] - dArray[0]) * d2;
        double d7 = dArray[1] + (dArray2[1] - dArray[1]) * d2;
        double d8 = dArray[2] + (dArray2[2] - dArray[2]) * d2;
        if (!usn2.projectSegment(d3, d4, d5, d6, d7, d8, 0.05f, this.rcn, this.rco)) {
            return;
        }
        if (f2 > 0.02f) {
            uut.additive(true);
            uut.softLine(drawContext, this.rcn[0], this.rcn[1], this.rcn[2], this.rcn[3], f, 2.5f + 3.5f * f2, n2);
            uut.additive(false);
        }
        uut.line(drawContext, this.rcn[0], this.rcn[1], this.rcn[2], this.rcn[3], f, n);
    }

    private void rdb(Box box) {
        this.rch[0] = box.field_1323;
        this.rch[1] = box.field_1322;
        this.rch[2] = box.field_1321;
        this.rch[3] = box.field_1320;
        this.rch[4] = box.field_1325;
        this.rch[5] = box.field_1324;
    }

    private boolean rdc(int n, Vec3d vec3d) {
        return switch (n) {
            case 0 -> {
                if (vec3d.field_1351 < this.rch[1]) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (vec3d.field_1351 > this.rch[4]) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (vec3d.field_1350 < this.rch[2]) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (vec3d.field_1350 > this.rch[5]) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if (vec3d.field_1352 < this.rch[0]) {
                    yield true;
                }
                yield false;
            }
            default -> vec3d.field_1352 > this.rch[3];
        };
    }

    static {
        rcs = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
        rct = new Direction[]{Direction.field_11033, Direction.field_11036, Direction.field_11043, Direction.field_11035, Direction.field_11039, Direction.field_11034};
        rcu = new int[][]{{0, 1, 0, 2}, {2, 3, 1, 2}, {4, 5, 0, 3}, {6, 7, 1, 3}, {0, 2, 2, 4}, {1, 3, 2, 5}, {4, 6, 3, 4}, {5, 7, 3, 5}, {0, 4, 0, 4}, {1, 5, 0, 5}, {2, 6, 1, 4}, {3, 7, 1, 5}};
    }

    private static /* synthetic */ int bxg(int n, int n2) {
        return n + n2 + -1527728900;
    }

    private static /* synthetic */ int bxh(int n, int n2) {
        return (n ^ n2) + -1819545525;
    }

    private static /* synthetic */ int bxi(int n, int n2) {
        return rby.bxg(n, n2) ^ 0xFAF89237;
    }
}

