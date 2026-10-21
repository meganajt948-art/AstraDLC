/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_10055
 *  net.minecraft.class_11658
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_9779
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.FxPipeline;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.BelowNameHook;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_11658;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_9779;

public class PlayerEsp
extends Module {
    private static PlayerEsp rkz;
    private final ModeSetting rla = this.add(new ModeSetting("Mode", "Outline", "Outline", "Box"));
    private final ColorSetting rlb = this.add(new ColorSetting("Color", "Theme"));
    private final BoolSetting rlc = this.add(new BoolSetting("Friends", true));
    private final BoolSetting rld = this.add(new BoolSetting("Health color", false));
    private final BoolSetting rle = this.add(new BoolSetting("Health bar", true));
    private final NumberSetting rlf = this.add(new NumberSetting("Outline", 1.0, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rlg = this.add(new NumberSetting("Width", 1.5, 0.5, 4.0, 0.1));
    private final NumberSetting rlh = this.add(new NumberSetting("Fill", 0.1, 0.0, 0.6, 0.01).percent());
    private final NumberSetting rli = this.add(new NumberSetting("Glow", 0.5, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rlj = this.add(new NumberSetting("Glow size", 0.5, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rlk = this.add(new NumberSetting("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));
    private final NumberSetting rll = this.add(new NumberSetting("Range", 128.0, 16.0, 256.0, 8.0).suffix("blocks"));
    private final BoolSetting rlm = this.add(new BoolSetting("Self", false));
    static final int FRIEND = -10686326;
    private long rln = -1L;
    private final float[] rlo = new float[2];
    private final float[] rlp = new float[4];
    private final float[] rlq = new float[2];
    private final double[][] rlr = new double[8][3];
    private final float[][] rls = new float[8][2];
    private final boolean[] rlt = new boolean[8];
    private static final int[][] rlu;
    private static final int[][] rlv;
    private float rlw;
    private float rlx;
    private float rly;
    private float rlz;
    private boolean rma;
    private static /* synthetic */ boolean rmb;
    private static /* synthetic */ boolean rmc;

    public PlayerEsp() {
        super(new String(new char[]{'P', 'l', 'a', 'y', 'e', 'r', 'E', 'S', 'P'}), "Players through walls: outline or box", ModuleCategory.RENDER);
        rkz = this;
        this.rle.visibleWhen(() -> this.rla.is("Box"));
        this.rlf.visibleWhen(() -> this.rla.is("Outline"));
        this.rli.visibleWhen(() -> this.rla.is("Outline"));
        this.rlj.visibleWhen(() -> this.rla.is("Outline") && this.rli.get() > 0.0);
        this.rlk.visibleWhen(() -> this.rla.is("Outline"));
    }

    private boolean rmd(class_310 class_3102, class_1657 class_16572) {
        if (class_16572 == class_3102.field_1724) {
            return this.rlm.get() && !class_3102.field_1690.method_31044().method_31034();
        }
        if (!class_16572.method_5805() || class_16572.method_7325() || class_16572 == class_3102.method_1560()) {
            return false;
        }
        if (!this.rlc.get() && Friends.isFriend((class_1297)class_16572)) {
            return false;
        }
        double d = this.rll.get();
        return class_3102.field_1724.method_5858((class_1297)class_16572) <= d * d;
    }

    private int rme(class_1657 class_16572) {
        if (Friends.isFriend((class_1297)class_16572)) {
            return -10686326;
        }
        int n = this.rlb.color() | 0xFF000000;
        if (this.rld.get()) {
            float f = BelowNameHook.of((class_1309)class_16572).fraction();
            return ColorUtil.lerp(-45730, -10686326, f);
        }
        return n;
    }

    public static void afterExtraction(class_11658 class_116582) {
        PlayerEsp rky2 = rkz;
        class_310 class_3102 = class_310.method_1551();
        if (rky2 == null || !rky2.isEnabled() || !rky2.rla.is("Outline") || class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return;
        }
        FxPipeline.style(0).set((float)rky2.rlh.get(), (float)rky2.rlf.get(), (float)rky2.rlg.get(), (float)rky2.rli.get(), (float)rky2.rlj.get(), (float)rky2.rlk.get());
        int n = rky2.rlb.color() | 0xFF000000;
        int n2 = rky2.rlb.color2() | 0xFF000000;
        boolean bl = rky2.rld.get();
        for (class_10017 class_100172 : class_116582.field_61735) {
            class_1657 class_16572;
            if (!(class_100172 instanceof class_10055)) continue;
            class_10055 class_100552 = (class_10055)class_100172;
            class_1297 class_12972 = class_3102.field_1687.method_8469(class_100552.field_53528);
            if (!(class_12972 instanceof class_1657) || !rky2.rmd(class_3102, class_16572 = (class_1657)class_12972)) continue;
            boolean bl2 = Friends.isFriend((class_1297)class_16572);
            int n3 = bl2 ? -10686326 : (bl ? ColorUtil.lerp(-45730, -10686326, BelowNameHook.of((class_1309)class_16572).fraction()) : n);
            int n4 = bl2 || bl ? ColorUtil.lerp(n3, -1, 0.35f) : n2;
            FxPipeline.paint(class_100172, 0, n3, n4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        PlayerEsp rky2 = rkz;
        class_310 class_3102 = class_310.method_1551();
        if (rky2 == null || !rky2.isEnabled() || rky2.rla.is("Outline") || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rky2.rln) {
            return;
        }
        rky2.rln = FrameDelta.frame();
        float f = class_97792.method_60637(true);
        try {
            usn2 = ScreenProjection.capture(f, class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        DrawUtil.beginBatch();
        try {
            for (class_1657 class_16572 : class_3102.field_1687.method_18456()) {
                if (!rky2.rmd(class_3102, class_16572)) continue;
                class_243 class_2432 = class_16572.method_30950(f);
                int n = rky2.rme(class_16572);
                rky2.rmg(class_3322, usn2, class_16572, class_2432, n);
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    private void rmf(double d, double d2, double d3, double d4, double d5) {
        for (int i = 0; i < 8; ++i) {
            this.rlr[i][0] = (i & 1) == 0 ? d - d4 : d + d4;
            this.rlr[i][1] = (i & 2) == 0 ? d2 : d2 + d5;
            this.rlr[i][2] = (i & 4) == 0 ? d3 - d4 : d3 + d4;
        }
    }

    private void rmg(class_332 class_3322, ScreenProjection usn2, class_1657 class_16572, class_243 class_2432, int n) {
        int n2;
        double d = (double)class_16572.method_17681() * 0.5 + 0.02;
        this.rmf(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, d, (double)class_16572.method_17682() + 0.02);
        for (int i = 0; i < 8; ++i) {
            this.rlt[i] = usn2.depth(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2]) > 0.05f && usn2.project(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2], this.rls[i]);
        }
        float f = (float)this.rlh.get();
        if (f > 0.005f) {
            class_243 class_2433 = usn2.camera();
            n2 = ColorUtil.withAlpha(n, Math.round(255.0f * f));
            int n3 = ColorUtil.withAlpha(n, Math.round(255.0f * f * 0.25f));
            for (int i = 0; i < 6; ++i) {
                int[] nArray = rlv[i];
                if (!this.rlt[nArray[0]] || !this.rlt[nArray[1]] || !this.rlt[nArray[2]] || !this.rlt[nArray[3]] || !this.rmh(i, class_2433, class_2432, d, class_16572.method_17682())) continue;
                DrawUtil.quad(class_3322, this.rls[nArray[0]][0], this.rls[nArray[0]][1], (nArray[0] & 2) != 0 ? n2 : n3, this.rls[nArray[1]][0], this.rls[nArray[1]][1], (nArray[1] & 2) != 0 ? n2 : n3, this.rls[nArray[2]][0], this.rls[nArray[2]][1], (nArray[2] & 2) != 0 ? n2 : n3, this.rls[nArray[3]][0], this.rls[nArray[3]][1], (nArray[3] & 2) != 0 ? n2 : n3);
            }
        }
        float f2 = (float)this.rlg.get();
        n2 = ColorUtil.withAlpha(n, 220);
        for (int[] nArray : rlu) {
            double[] dArray = this.rlr[nArray[0]];
            double[] dArray2 = this.rlr[nArray[1]];
            if (!usn2.projectSegment(dArray[0], dArray[1], dArray[2], dArray2[0], dArray2[1], dArray2[2], 0.05f, this.rlp, this.rlq)) continue;
            DrawUtil.line(class_3322, this.rlp[0], this.rlp[1], this.rlp[2], this.rlp[3], f2, n2);
        }
        if (this.rle.get()) {
            this.rmi(usn2);
            if (this.rma) {
                this.rmj(class_3322, class_16572);
            }
        }
    }

    private boolean rmh(int n, class_243 class_2432, class_243 class_2433, double d, double d2) {
        return switch (n) {
            case 0 -> {
                if (class_2432.field_1351 < class_2433.field_1351) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (class_2432.field_1351 > class_2433.field_1351 + d2) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (class_2432.field_1350 < class_2433.field_1350 - d) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (class_2432.field_1350 > class_2433.field_1350 + d) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if (class_2432.field_1352 < class_2433.field_1352 - d) {
                    yield true;
                }
                yield false;
            }
            default -> class_2432.field_1352 > class_2433.field_1352 + d;
        };
    }

    private void rmi(ScreenProjection usn2) {
        this.rma = false;
        this.rlw = Float.MAX_VALUE;
        this.rlx = Float.MAX_VALUE;
        this.rly = -3.4028235E38f;
        this.rlz = -3.4028235E38f;
        for (int i = 0; i < 8; ++i) {
            if (usn2.depth(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2]) <= 0.05f || !usn2.project(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2], this.rlo)) {
                return;
            }
            this.rlw = Math.min(this.rlw, this.rlo[0]);
            this.rlx = Math.min(this.rlx, this.rlo[1]);
            this.rly = Math.max(this.rly, this.rlo[0]);
            this.rlz = Math.max(this.rlz, this.rlo[1]);
        }
        this.rma = this.rly - this.rlw > 1.0f && this.rlz - this.rlx > 1.0f;
    }

    private void rmj(class_332 class_3322, class_1657 class_16572) {
        float f = class_3532.method_15363((float)BelowNameHook.of((class_1309)class_16572).fraction(), (float)0.0f, (float)1.0f);
        float f2 = this.rlz - this.rlx;
        float f3 = Math.max(1.5f, Math.min(3.0f, f2 * 0.025f));
        float f4 = this.rlw - f3 - 3.0f;
        DrawUtil.round(class_3322, f4 - 0.6f, this.rlx - 0.6f, f3 + 1.2f, f2 + 1.2f, f3 * 0.5f + 0.6f, Integer.MIN_VALUE);
        int n = ColorUtil.lerp(-45730, -10686326, f);
        float f5 = f2 * f;
        DrawUtil.round(class_3322, f4, this.rlx + f2 - f5, f3, f5, f3 * 0.5f, n);
    }

    static {
        rlu = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
        rlv = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
    }

    private static /* synthetic */ int bzo(int n, int n2) {
        return n * n2 + -660459049;
    }

    private static /* synthetic */ int bzp(int n, int n2) {
        return PlayerEsp.bzo(n, n2) + n;
    }
}

