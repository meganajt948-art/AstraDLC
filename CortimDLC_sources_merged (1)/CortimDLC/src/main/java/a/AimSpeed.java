/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_746
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.AutoMace;
import a.TargetStrafe;
import a.AimSmoother;
import a.AncientFarmer;
import a.AutoMines;
import a.FreeCam;
import a.tbm;
import a.AngleUtil;
import a.tcw;
import a.RecorderHooks;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Reflect;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_746;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class AimSpeed
extends Module {
    private final NumberSetting kyo = this.add(new NumberSetting("Speed", 5.0, 1.0, 10.0, 1.0));
    private final NumberSetting kyp = this.add(new NumberSetting("Speed spread", 0.3, 0.0, 0.6, 0.05).percent());
    private final NumberSetting kyq = this.add(new NumberSetting("Slowdown", 0.35, 0.0, 0.8, 0.05).percent());
    private final NumberSetting kyr = this.add(new NumberSetting("Vertical", 0.5, 0.0, 1.0, 0.05).percent());
    private final NumberSetting kys = this.add(new NumberSetting("FOV", 90.0, 20.0, 180.0, 5.0).unit("°"));
    private final NumberSetting kyt = this.add(new NumberSetting("Distance", 4.0, 2.0, 6.0, 0.1).suffix("m"));
    private final ModeSetting kyu = this.add(new ModeSetting("Items", "Weapons", "Weapons", "Swords", "Axes", "Any"));
    private final BoolSetting kyv = this.add(new BoolSetting("Click only", false));
    private final BoolSetting kyw = this.add(new BoolSetting("Players", true));
    private final BoolSetting kyx = this.add(new BoolSetting("Mobs", false));
    private final BoolSetting kyy = this.add(new BoolSetting("Through walls", false));
    private static final double kyz = 1.2;
    private static final double kza = 0.12;
    private static final double kzb = 0.08;
    private static final double kzc = 0.25;
    private static Field kzd;
    private static Field kze;
    private static Field kzf;
    private final Random kzg = new Random();
    private final AimSmoother kzh = new AimSmoother();
    private final tbm kzi = new tbm();
    private final tbm kzj = new tbm();
    private final double[] kzk = new double[2];
    private long kzl;
    private GLFWCursorPosCallback kzm;
    private GLFWCursorPosCallback kzn;
    private boolean kzo;
    private double kzp;
    private double kzq;
    private double kzr;
    private double kzs;
    private double kzt = Double.NaN;
    private double kzu = Double.NaN;
    private double kzv;
    private double kzw;
    private double kzx;
    private double kzy;
    private class_1309 kzz;
    private boolean laa;
    private long lab;
    private class_1309 lac;
    private long lad;
    private double lae;
    private double laf;
    private double lag;
    private double lah;
    private double lai;
    private double laj;
    private double lak;
    private double lal;
    private double lam;
    private double lan;
    private double lao;
    private double lap;
    private double laq;
    private double lar;
    private double las;
    private double lat;
    private double lau;
    private long lav;
    private double law = 0.016666666666666666;
    private boolean lax;
    private long lay;
    private double laz;
    private double lba;
    private double lbb;
    private double lbc;
    private double lbd;
    private double lbe;
    private double lbf;
    private double lbg;
    private boolean lbh;
    private double lbi;
    private double lbj;
    private double lbk;
    private double lbl;
    private static /* synthetic */ long lbm;
    private static /* synthetic */ String lbn;

    public AimSpeed() {
        super("LegitAim", "Helps your own mouse: faster to the target, softer on it", ModuleCategory.COMBAT);
    }

    @Override
    protected void onEnable() {
        TargetStrafe lck2 = AimSpeed.lca();
        if (lck2 != null && lck2.isEnabled()) {
            lck2.setEnabled(false);
        }
    }

    @Override
    protected void onDisable() {
        this.lcc();
        this.kzz = null;
        this.laa = false;
        this.lbp();
        this.kzh.reset();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1687 == null) {
            this.kzz = null;
            this.laa = false;
            return;
        }
        this.lbx(class_3102);
        this.laa = this.lby(class_3102, class_7462);
        this.kzz = this.laa ? this.lbt(class_3102, class_7462) : null;
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        class_1309 class_13092;
        TargetStrafe lck2 = AimSpeed.lca();
        if (lck2 != null && lck2.isEnabled()) {
            this.setEnabled(false);
            return;
        }
        if (!(this.kzn != null && this.kzo || class_3102.method_22683() == null)) {
            this.lcb(class_3102.method_22683().method_4490());
        }
        long l = System.nanoTime();
        double d = this.lav == 0L ? 0.016666666666666666 : Math.min(0.1, (double)(l - this.lav) / 1.0E9);
        this.lav = l;
        this.law += (Math.min(0.05, d) - this.law) * 0.2;
        class_746 class_7462 = class_3102.field_1724;
        boolean bl = class_7462 != null && class_3102.field_1755 == null && class_3102.field_1729.method_1613();
        class_1309 class_13093 = class_13092 = bl && this.laa ? this.kzz : null;
        if (class_13092 != null && class_13092 != this.lac) {
            this.lbo(class_13092, l);
        }
        boolean bl2 = class_13092 != null && class_13092 == this.lac;
        double d2 = this.lae = bl2 ? Math.min(1.0, this.lae + d / this.laf) : Math.max(0.0, this.lae - d / 0.12);
        if (this.lac != null && (!bl2 && this.lae <= 0.0 || this.lac.method_31481() || !this.lac.method_5805())) {
            this.lbp();
        }
        if (this.lac == null || class_7462 == null) {
            this.lax = false;
            this.lbg = 0.0;
            return;
        }
        this.lbq(class_3102, class_7462, l, d);
    }

    private void lbo(class_1309 class_13092, long l) {
        this.lac = class_13092;
        this.lad = l;
        this.lae = 0.0;
        this.laf = 0.18 + this.kzg.nextDouble() * 0.22;
        this.lag = 0.35 + this.kzg.nextDouble() * 0.2;
        this.lah = this.kzg.nextDouble() * 2.0 - 1.0;
        this.lai = 0.45 + this.kzg.nextDouble() * 0.45;
        this.laj = 1.1 + this.kzg.nextDouble() * 0.6;
        this.lak = this.kzg.nextDouble() * Math.PI * 2.0;
        this.lal = this.kzg.nextDouble() * Math.PI * 2.0;
        double[] dArray = this.lbs();
        this.lao = this.laq = dArray[0];
        this.lam = this.laq;
        this.lap = this.lar = dArray[1];
        this.lan = this.lar;
        this.lat = 0.0;
        this.las = 0.0;
        this.lau = 0.4 + this.kzg.nextDouble() * 0.9;
        this.lbh = false;
        this.lbl = 0.0;
        this.lbk = 0.0;
    }

    private void lbp() {
        this.lac = null;
        this.lae = 0.0;
        this.lax = false;
        this.lbh = false;
        this.lbg = 0.0;
        this.lbl = 0.0;
        this.lbk = 0.0;
    }

    private void lbq(class_310 class_3102, class_746 class_7462, long l, double d) {
        double d2;
        double d3;
        double d4;
        double d5 = (double)(l - this.lad) / 1.0E9;
        this.lbr(d5);
        float f = class_3102.method_61966().method_60637(true);
        class_243 class_2432 = class_7462.method_5836(f);
        class_243 class_2433 = this.lac.method_30950(f);
        double d6 = (double)this.lac.method_17681() * 0.5;
        double d7 = this.lac.method_17682();
        if (!AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, class_2433.field_1352, class_2433.field_1351, class_2433.field_1350, d6, d7, this.lam, this.lan, this.kzi) || !AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, class_2433.field_1352, class_2433.field_1351, class_2433.field_1350, d6, d7, 0.0, 0.5, this.kzj)) {
            this.lax = false;
            this.lbh = false;
            this.lbg = 0.0;
            return;
        }
        if (this.lbh && d > 1.0E-4) {
            d4 = AngleUtil.wrap(this.kzj.yaw - this.lbi) / d;
            d3 = (this.kzj.pitch - this.lbj) / d;
            d2 = 1.0 - Math.exp(-d / 0.08);
            this.lbk += (d4 - this.lbk) * d2;
            this.lbl += (d3 - this.lbl) * d2;
        }
        this.lbi = this.kzj.yaw;
        this.lbj = this.kzj.pitch;
        this.lbh = true;
        this.laz = this.kzi.yaw;
        this.lba = this.kzi.pitch;
        this.lbb = this.kzi.la;
        this.lbc = this.kzi.ra;
        this.lbd = this.kzi.ta;
        this.lbe = this.kzi.ba;
        this.lay = l;
        this.lbf = Math.max(1.0, 0.6 * this.kzi.bw);
        this.lax = true;
        d4 = this.kys.get() * 0.5;
        d3 = Math.hypot(AngleUtil.wrap(this.kzi.yaw - (double)class_7462.method_36454()), this.kzi.pitch - (double)class_7462.method_36455());
        d2 = 1.0 - AimSpeed.lci(d4 * 0.75, d4 * 1.2, d3);
        double d8 = 0.5 * (Math.sin(Math.PI * 2 * this.lai * d5 + this.lak) + Math.sin(Math.PI * 2 * this.laj * d5 + this.lal));
        double d9 = AimSpeed.lcj(1.0 + this.kyp.get() * (this.lah + 0.6 * d8), 0.2, 2.0);
        double d10 = this.kyv.get() ? 1.0 - AimSpeed.lci(0.45, 0.8, (double)(System.currentTimeMillis() - this.lab) / 1000.0) : 1.0;
        this.lbg = AimSpeed.lci(0.0, 1.0, this.lae) * d9 * d2 * d10;
        this.kzh.pull = 0.1 * this.kyo.get();
        this.kzh.slow = this.kyq.get();
        this.kzh.vertical = this.kyr.get();
    }

    private void lbr(double d) {
        if (d < this.lat) {
            double d2 = AimSpeed.lci(this.las, this.lat, d);
            this.lam = this.lao + (this.laq - this.lao) * d2;
            this.lan = this.lap + (this.lar - this.lap) * d2;
            return;
        }
        this.lam = this.laq;
        this.lan = this.lar;
        if (d >= this.lau) {
            double[] dArray = this.lbs();
            this.lao = this.lam;
            this.lap = this.lan;
            this.laq = dArray[0];
            this.lar = dArray[1];
            this.las = d;
            this.lat = d + 0.25 + this.kzg.nextDouble() * 0.3;
            this.lau = this.lat + 0.5 + this.kzg.nextDouble() * 0.9;
        }
    }

    private double[] lbs() {
        double d = AimSpeed.lcj(this.kzg.nextGaussian() * 0.18, -0.35, 0.35);
        double d2 = 0.55 + this.kzg.nextDouble() * 0.3;
        return new double[]{d, d2};
    }

    private class_1309 lbt(class_310 class_3102, class_746 class_7462) {
        class_243 class_2432 = class_7462.method_33571();
        double d = this.kyt.get();
        double d2 = this.kys.get() * 0.5;
        if (this.kzz != null && this.lbu(class_7462, this.kzz) && AimSpeed.lbv(class_2432, (class_1297)this.kzz, d) && AimSpeed.lbw(class_7462, class_2432, (class_1297)this.kzz) <= d2 * 1.2) {
            return this.kzz;
        }
        class_1309 class_13092 = null;
        double d3 = Double.MAX_VALUE;
        for (class_1297 class_12972 : class_3102.field_1687.method_8335((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0))) {
            double d4;
            class_1309 class_13093;
            if (!(class_12972 instanceof class_1309) || !this.lbu(class_7462, class_13093 = (class_1309)class_12972) || !AimSpeed.lbv(class_2432, (class_1297)class_13093, d) || !((d4 = AimSpeed.lbw(class_7462, class_2432, (class_1297)class_13093)) <= d2) || !(d4 < d3)) continue;
            d3 = d4;
            class_13092 = class_13093;
        }
        return class_13092;
    }

    private boolean lbu(class_746 class_7462, class_1309 class_13092) {
        if (class_13092 == class_7462 || class_13092.method_31481() || !class_13092.method_5805() || !class_13092.method_5732() || class_13092 instanceof class_1531) {
            return false;
        }
        if (class_13092 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_13092;
            if (!this.kyw.get() || class_16572.method_7325() || Friends.protects((class_1297)class_16572)) {
                return false;
            }
        } else if (!this.kyx.get() || !(class_13092 instanceof class_1569)) {
            return false;
        }
        return this.kyy.get() || class_7462.method_6057((class_1297)class_13092);
    }

    private static boolean lbv(class_243 class_2432, class_1297 class_12972, double d) {
        return class_12972.method_5829().method_49271(class_2432) <= d * d;
    }

    private static double lbw(class_746 class_7462, class_243 class_2432, class_1297 class_12972) {
        class_243 class_2433 = class_12972.method_5829().method_1005();
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        double d3 = AngleUtil.yawTo(d, d2);
        double d4 = AngleUtil.pitchTo(class_2433.field_1351 - class_2432.field_1351, Math.sqrt(d * d + d2 * d2));
        return Math.hypot(AngleUtil.wrap(d3 - (double)class_7462.method_36454()), d4 - (double)class_7462.method_36455());
    }

    private void lbx(class_310 class_3102) {
        boolean bl;
        boolean bl2 = bl = class_3102.field_1690.field_1886.method_1434() || class_3102.field_1755 == null && class_3102.method_22683() != null && GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1;
        if (bl) {
            this.lab = System.currentTimeMillis();
        }
    }

    private boolean lby(class_310 class_3102, class_746 class_7462) {
        if (class_3102.field_1755 != null || !class_3102.method_1569() || !class_3102.field_1729.method_1613() || !class_7462.method_5805() || class_7462.method_7325() || class_7462.method_6115()) {
            return false;
        }
        if (!class_3102.field_1690.method_31044().method_31034() || class_3102.field_1690.field_1914) {
            return false;
        }
        if (class_3102.field_1761 != null && class_3102.field_1761.method_2923()) {
            return false;
        }
        if (FreeCam.active() || AutoMace.busy() || AutoMines.busy() || RecorderHooks.mode() == tcw.RECORD || AncientFarmer.busy()) {
            return false;
        }
        return this.lbz(class_7462.method_6047());
    }

    /*
     * Exception decompiling
     */
    private boolean lbz(class_1799 var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static TargetStrafe lca() {
        Flow flow = Flow.getInstance();
        return flow == null || flow.getModuleManager() == null ? null : flow.getModuleManager().get(TargetStrafe.class);
    }

    private void lcb(long l) {
        if (kzd == null || kze == null || kzf == null) {
            kzd = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1789", "D");
            kze = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1787", "D");
            kzf = Reflect.find(class_312.class, "net.minecraft.class_312", "field_47842", "D");
        }
        if (kzd == null || kze == null || kzf == null) {
            return;
        }
        this.kzs = 0.0;
        this.kzr = 0.0;
        this.kzq = 0.0;
        this.kzp = 0.0;
        this.kzt = Double.NaN;
        this.kzu = Double.NaN;
        this.kzy = 0.0;
        this.kzx = 0.0;
        this.kzw = 0.0;
        this.kzv = 0.0;
        this.kzh.reset();
        if (this.kzn == null) {
            this.kzl = l;
            this.kzn = GLFWCursorPosCallback.create(this::lcd);
            this.kzm = GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)this.kzn);
        }
        this.kzo = true;
    }

    private void lcc() {
        this.kzo = false;
        if (this.kzn == null) {
            return;
        }
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)this.kzl, (GLFWCursorPosCallbackI)this.kzm);
        if (gLFWCursorPosCallback != null && gLFWCursorPosCallback.address() == this.kzn.address()) {
            this.kzn.free();
            this.kzn = null;
            this.kzm = null;
        } else {
            GLFW.glfwSetCursorPosCallback((long)this.kzl, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        }
    }

    private void lcd(long l, double d, double d2) {
        if (this.kzm != null) {
            this.kzm.invoke(l, d, d2);
        }
        if (this.kzo) {
            class_310.method_1551().execute(this::lce);
        }
    }

    private void lce() {
        if (!this.kzo || kzd == null) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        try {
            double d = kzd.getDouble(class_3102.field_1729);
            double d2 = kze.getDouble(class_3102.field_1729);
            double d3 = kzf.getDouble(class_3102.field_1729);
            if (d3 != this.kzt) {
                double d4 = Double.isNaN(this.kzu) ? 1.0 : d3 - this.kzu;
                this.kzh.frame(d4);
                boolean bl = d4 < 0.25;
                this.kzv = bl ? this.kzx : 0.0;
                this.kzw = bl ? this.kzy : 0.0;
                this.kzy = 0.0;
                this.kzx = 0.0;
                this.kzt = d3;
                this.kzu = d3;
                this.kzp = d;
                this.kzq = d2;
            } else {
                this.kzp += d - this.kzr;
                this.kzq += d2 - this.kzs;
            }
            this.lcf(class_3102);
            this.kzr = this.kzp + this.kzk[0];
            this.kzs = this.kzq + this.kzk[1];
            kzd.setDouble(class_3102.field_1729, this.kzr);
            kze.setDouble(class_3102.field_1729, this.kzs);
        }
        catch (IllegalAccessException illegalAccessException) {
            kzd = null;
            this.kzo = false;
        }
    }

    private void lcf(class_310 class_3102) {
        boolean bl;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || this.kzp == 0.0 && this.kzq == 0.0) {
            this.kzk[1] = 0.0;
            this.kzk[0] = 0.0;
            return;
        }
        double d = AimSpeed.lch(class_3102, class_7462);
        double d2 = (Boolean)class_3102.field_1690.method_72706().method_41753() != false ? -1.0 : 1.0;
        double d3 = (Boolean)class_3102.field_1690.method_42438().method_41753() != false ? -1.0 : 1.0;
        double d4 = this.kzp * d * d2;
        double d5 = this.kzq * d * d3;
        boolean bl2 = bl = this.isEnabled() && this.lax && this.lbg > 0.0 && class_3102.field_1755 == null && class_3102.field_1729.method_1613() && !class_3102.field_1690.field_1914;
        if (!bl) {
            this.kzh.extra(d4, d5, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, this.kzk);
            this.kzy = 0.0;
            this.kzx = 0.0;
            this.kzk[1] = 0.0;
            this.kzk[0] = 0.0;
            return;
        }
        double d6 = AimSpeed.lcj((double)(System.nanoTime() - this.lay) / 1.0E9, 0.0, 0.05);
        double d7 = this.laz + this.lbk * d6;
        double d8 = this.lba + this.lbl * d6;
        double d9 = AngleUtil.wrap(d7 - (double)class_7462.method_36454());
        double d10 = d8 - (double)class_7462.method_36455();
        double d11 = AimSpeed.lcg(d9 + this.lbb * this.lag, d9 + this.lbc * this.lag);
        double d12 = AimSpeed.lcg(d10 + this.lbd * this.lag, d10 + this.lbe * this.lag);
        this.kzh.extra(d4, d5, d11, d12, this.lbk * this.law, this.lbl * this.law, this.lbf, this.lbg, this.kzk);
        double d13 = this.kzk[0] / d * d2 + this.kzv;
        double d14 = this.kzk[1] / d * d3 + this.kzw;
        double d15 = Math.rint(d13);
        double d16 = Math.rint(d14);
        this.kzx = d13 - d15;
        this.kzy = d14 - d16;
        this.kzk[0] = d15;
        this.kzk[1] = d16;
    }

    private static double lcg(double d, double d2) {
        return d > 0.0 ? d : (d2 < 0.0 ? d2 : 0.0);
    }

    private static double lch(class_310 class_3102, class_746 class_7462) {
        double d = (Double)class_3102.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = class_3102.field_1690.method_31044().method_31034() && class_7462.method_31550();
        return (bl ? d2 : d2 * 8.0) * 0.15;
    }

    private static double lci(double d, double d2, double d3) {
        double d4 = AimSpeed.lcj((d3 - d) / (d2 - d), 0.0, 1.0);
        return d4 * d4 * (3.0 - 2.0 * d4);
    }

    private static double lcj(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private static /* synthetic */ int avp(int n, int n2) {
        return n * n2 | 0x731EFBBC;
    }

    private static /* synthetic */ int avq(int n, int n2) {
        return AimSpeed.avp(n, n2) * n2;
    }
}

