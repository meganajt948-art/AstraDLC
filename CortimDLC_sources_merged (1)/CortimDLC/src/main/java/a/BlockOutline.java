/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.Spring;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_9779;

public class BlockOutline
extends Module {
    private static BlockOutline rbz;
    private final ModeSetting rca = this.add(new ModeSetting("Mode", "Box", "Box", "Corners", "Face"));
    private final ColorSetting rcb = this.add(new ColorSetting("Color", "Theme"));
    private final NumberSetting rcc = this.add(new NumberSetting("Width", 1.2, 0.5, 3.0, 0.1));
    private final NumberSetting rcd = this.add(new NumberSetting("Corner size", 0.25, 0.1, 0.5, 0.01).percent());
    private final NumberSetting rce = this.add(new NumberSetting("Fill", 0.12, 0.0, 0.5, 0.01).percent());
    private final NumberSetting rcf = this.add(new NumberSetting("Glow", 0.5, 0.0, 1.0, 0.05).percent());
    private final BoolSetting rcg = this.add(new BoolSetting("Smooth", true));
    private final double[] rch = new double[6];
    private boolean rci;
    private class_2350 rcj = class_2350.field_11036;
    private final Spring rck = new Spring(14.0f);
    private long rcl = -1L;
    private final double[][] rcm = new double[8][3];
    private final float[] rcn = new float[4];
    private final float[] rco = new float[3];
    private final float[][] rcp = new float[8][3];
    private final boolean[] rcq = new boolean[8];
    private final boolean[] rcr = new boolean[6];
    private static final int[][] rcs;
    private static final class_2350[] rct;
    private static final int[][] rcu;
    private static /* synthetic */ long rcv;
    private static /* synthetic */ long rcw;

    public BlockOutline() {
        super(new String(new char[]{'B', 'l', 'o', 'c', 'k', 'O', 'u', 't', 'l', 'i', 'n', 'e'}), "A clean outline on the block you aim at", ModuleCategory.RENDER);
        rbz = this;
        this.rcd.visibleWhen(() -> this.rca.is("Corners"));
    }

    public static boolean vanilla() {
        return rbz == null || !rbz.isEnabled();
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        BlockOutline rby2 = rbz;
        class_310 class_3102 = class_310.method_1551();
        if (rby2 == null || !rby2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            if (rby2 != null) {
                rby2.rci = false;
                rby2.rck.set(0.0f);
            }
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rby2.rcl) {
            return;
        }
        rby2.rcl = FrameDelta.frame();
        rby2.rcx(class_3322, class_3102, class_97792.method_60637(true), FrameDelta.delta());
    }

    private void rcx(class_332 class_3322, class_310 class_3102, float f, float f2) {
        boolean bl;
        ScreenProjection usn2;
        class_265 class_2652;
        class_2680 class_26802;
        class_3965 class_39652;
        class_238 class_2383 = null;
        class_239 class_2392 = class_3102.field_1765;
        if (class_2392 instanceof class_3965 && (class_39652 = (class_3965)class_2392).method_17783() == class_239.class_240.field_1332 && !(class_26802 = class_3102.field_1687.method_8320((class_2338)(class_2392 = class_39652.method_17777()))).method_26215() && class_3102.field_1687.method_8621().method_11952((class_2338)class_2392) && !(class_2652 = class_26802.method_26172((class_1922)class_3102.field_1687, (class_2338)class_2392, class_3726.method_16195((class_1297)class_3102.method_1560()))).method_1110()) {
            class_2383 = class_2652.method_1107().method_996((class_2338)class_2392);
            this.rcj = class_39652.method_17780();
        }
        float f3 = this.rck.step(class_2383 != null, f2);
        if (class_2383 != null) {
            if (!this.rci || !this.rcg.get() || f3 < 0.05f) {
                this.rdb(class_2383);
            } else {
                double d = 1.0 - Math.exp((double)(-f2) * 26.0);
                this.rch[0] = this.rch[0] + (class_2383.field_1323 - this.rch[0]) * d;
                this.rch[1] = this.rch[1] + (class_2383.field_1322 - this.rch[1]) * d;
                this.rch[2] = this.rch[2] + (class_2383.field_1321 - this.rch[2]) * d;
                this.rch[3] = this.rch[3] + (class_2383.field_1320 - this.rch[3]) * d;
                this.rch[4] = this.rch[4] + (class_2383.field_1325 - this.rch[4]) * d;
                this.rch[5] = this.rch[5] + (class_2383.field_1324 - this.rch[5]) * d;
            }
            this.rci = true;
        }
        if (!this.rci || f3 <= 0.01f) {
            this.rci = this.rci && f3 > 0.01f;
            return;
        }
        try {
            usn2 = ScreenProjection.capture(f, class_3322.method_51421(), class_3322.method_51443());
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
        class_243 class_2432 = usn2.camera();
        for (bl = false; bl < 6 != 0; bl += 1) {
            this.rcr[bl] = this.rdc(bl ? 1 : 0, class_2432);
        }
        bl = this.rca.is("Face");
        int n = this.rcb.color() | 0xFF000000;
        DrawUtil.beginFrame();
        DrawUtil.pushAlpha(f3);
        this.rcy(class_3322, n, bl);
        this.rcz(class_3322, usn2, n, bl);
        DrawUtil.popAlpha();
    }

    private void rcy(class_332 class_3322, int n, boolean bl) {
        float f = (float)this.rce.get();
        if (f <= 0.005f) {
            return;
        }
        for (int i = 0; i < 6; ++i) {
            int[] nArray;
            if (!this.rcr[i] || bl && rct[i] != this.rcj || !this.rcq[(nArray = rcs[i])[0]] || !this.rcq[nArray[1]] || !this.rcq[nArray[2]] || !this.rcq[nArray[3]]) continue;
            int n2 = ColorUtil.withAlpha(n, Math.round(255.0f * f * (rct[i] == this.rcj ? 1.0f : 0.55f)));
            DrawUtil.quad(class_3322, this.rcp[nArray[0]][0], this.rcp[nArray[0]][1], n2, this.rcp[nArray[1]][0], this.rcp[nArray[1]][1], n2, this.rcp[nArray[2]][0], this.rcp[nArray[2]][1], n2, this.rcp[nArray[3]][0], this.rcp[nArray[3]][1], n2);
        }
    }

    private void rcz(class_332 class_3322, ScreenProjection usn2, int n, boolean bl) {
        float f = (float)this.rcc.get();
        float f2 = (float)this.rcf.get();
        int n2 = ColorUtil.withAlpha(n, 225);
        int n3 = ColorUtil.withAlpha(n, Math.round(110.0f * f2));
        boolean bl2 = this.rca.is("Corners");
        double d = this.rcd.get();
        for (int[] nArray : rcu) {
            boolean bl3;
            boolean bl4 = bl ? (rct[nArray[2]] == this.rcj || rct[nArray[3]] == this.rcj) && (this.rcr[nArray[2]] || this.rcr[nArray[3]]) : (bl3 = this.rcr[nArray[2]] || this.rcr[nArray[3]]);
            if (!bl3) continue;
            double[] dArray = this.rcm[nArray[0]];
            double[] dArray2 = this.rcm[nArray[1]];
            if (bl2) {
                this.rda(class_3322, usn2, dArray, dArray2, 0.0, d, f, n2, n3, f2);
                this.rda(class_3322, usn2, dArray, dArray2, 1.0 - d, 1.0, f, n2, n3, f2);
                continue;
            }
            this.rda(class_3322, usn2, dArray, dArray2, 0.0, 1.0, f, n2, n3, f2);
        }
    }

    private void rda(class_332 class_3322, ScreenProjection usn2, double[] dArray, double[] dArray2, double d, double d2, float f, int n, int n2, float f2) {
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
            DrawUtil.additive(true);
            DrawUtil.softLine(class_3322, this.rcn[0], this.rcn[1], this.rcn[2], this.rcn[3], f, 2.5f + 3.5f * f2, n2);
            DrawUtil.additive(false);
        }
        DrawUtil.line(class_3322, this.rcn[0], this.rcn[1], this.rcn[2], this.rcn[3], f, n);
    }

    private void rdb(class_238 class_2383) {
        this.rch[0] = class_2383.field_1323;
        this.rch[1] = class_2383.field_1322;
        this.rch[2] = class_2383.field_1321;
        this.rch[3] = class_2383.field_1320;
        this.rch[4] = class_2383.field_1325;
        this.rch[5] = class_2383.field_1324;
    }

    private boolean rdc(int n, class_243 class_2432) {
        return switch (n) {
            case 0 -> {
                if (class_2432.field_1351 < this.rch[1]) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (class_2432.field_1351 > this.rch[4]) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (class_2432.field_1350 < this.rch[2]) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (class_2432.field_1350 > this.rch[5]) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if (class_2432.field_1352 < this.rch[0]) {
                    yield true;
                }
                yield false;
            }
            default -> class_2432.field_1352 > this.rch[3];
        };
    }

    static {
        rcs = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
        rct = new class_2350[]{class_2350.field_11033, class_2350.field_11036, class_2350.field_11043, class_2350.field_11035, class_2350.field_11039, class_2350.field_11034};
        rcu = new int[][]{{0, 1, 0, 2}, {2, 3, 1, 2}, {4, 5, 0, 3}, {6, 7, 1, 3}, {0, 2, 2, 4}, {1, 3, 2, 5}, {4, 6, 3, 4}, {5, 7, 3, 5}, {0, 4, 0, 4}, {1, 5, 0, 5}, {2, 6, 1, 4}, {3, 7, 1, 5}};
    }

    private static /* synthetic */ int bxg(int n, int n2) {
        return n + n2 + -1527728900;
    }

    private static /* synthetic */ int bxh(int n, int n2) {
        return (n ^ n2) + -1819545525;
    }

    private static /* synthetic */ int bxi(int n, int n2) {
        return BlockOutline.bxg(n, n2) ^ 0xFAF89237;
    }
}

