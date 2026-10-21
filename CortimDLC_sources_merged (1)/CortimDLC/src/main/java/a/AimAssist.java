/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_3532
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
import a.TargetFilter;
import a.AncientFarmer;
import a.AutoMines;
import a.FreeCam;
import a.tbm;
import a.AngleUtil;
import a.AimModel;
import a.tcw;
import a.RecorderHooks;
import a.AimBrain;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.Reflect;
import a.vyd;
import a.BelowNameHook;
import flow.config.ConfigManager;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class AimAssist
extends Module {
    private final ButtonSetting kgk = this.add(new ButtonSetting("Preset", new vkq("FT", Icon.CHECK, this::kit)));
    private final NumberSetting kgl = this.add(new NumberSetting("Speed", 1.0, 0.3, 1.6, 0.05).percent());
    private final NumberSetting kgm = this.add(new NumberSetting("Aim smooth", 0.5, 0.0, 1.0, 0.05).percent());
    private final NumberSetting kgn = this.add(new NumberSetting("Aim max speed", 30.0, 5.0, 90.0, 1.0).suffix("°/t"));
    private final NumberSetting kgo = this.add(new NumberSetting("Aim reaction", 100.0, 0.0, 300.0, 10.0).suffix("ms"));
    private final BoolSetting kgp = this.add(new BoolSetting("Aim yield to mouse", false));
    private final BoolSetting kgq = this.add(new BoolSetting("Aim only while moving", false));
    private final NumberSetting kgr = this.add(new NumberSetting("Aim toward target", 3.0, 1.0, 3.0, 0.05).suffix("x"));
    private final NumberSetting kgs = this.add(new NumberSetting("Aim away from target", 1.0, 0.0, 1.0, 0.05).suffix("x"));
    private final NumberSetting kgt = this.add(new NumberSetting("FOV", 70.0, 10.0, 360.0, 5.0).unit("°"));
    private final NumberSetting kgu = this.add(new NumberSetting("Distance", 4.5, 2.0, 8.0, 0.1).suffix("m"));
    private final NumberSetting kgv = this.add(new NumberSetting("Vertical", 1.0, 0.0, 1.0, 0.05).percent());
    private final ModeSetting kgw = this.add(new ModeSetting("Items", "Weapons", "Weapons", "Swords", "Axes", "Any"));
    private final ModeSetting kgx = this.add(new ModeSetting("Priority", "Angle", "Angle", "Distance", "Health"));
    private final BoolSetting kgy = this.add(new BoolSetting("Click only", false));
    private final BoolSetting kgz = this.add(new BoolSetting("Players", true));
    private final BoolSetting kha = this.add(new BoolSetting("Mobs", false));
    private final BoolSetting khb = this.add(new BoolSetting("Through walls", false));
    private final TargetFilter khc = new TargetFilter();
    private static final double khd = 1.2;
    private static final double khe = 1.5;
    private static final int khf = 12;
    private static final long khg = 1200L;
    private static final long khh = 650L;
    private static final double khi = 1.0;
    private static final double khj = 0.8;
    private static final long khk = 180L;
    private static final double khl = 1.5;
    private static final double khm = 8.0;
    private static final double khn = 350.0;
    private static final double kho = 1000.0;
    private static final double khp = 0.25;
    private static Field khq;
    private static Field khr;
    private static Field khs;
    private final AimBrain kht;
    private final tbm khu;
    private final double[] khv;
    private long khw;
    private class_1297 khx;
    private long khy;
    private GLFWCursorPosCallback khz;
    private GLFWCursorPosCallback kia;
    private boolean kib;
    private double kic;
    private double kid;
    private double kie;
    private double kif;
    private double kig;
    private long kih;
    private double kii;
    private double kij;
    private double kik;
    private double kil;
    private double kim;
    private volatile long kin;
    private class_1297 kio;
    private long kip;
    private int kiq;
    private static /* synthetic */ int kir;
    private static /* synthetic */ String kis;

    public AimAssist() {
        super("AimAssist", "Smooth aim help with a weapon", ModuleCategory.COMBAT);
        this.add(this.khc.naked);
        this.add(this.khc.invisible);
        this.add(this.khc.armored);
        this.kht = new AimBrain();
        this.khu = new tbm();
        this.khv = new double[2];
        this.kig = Double.NaN;
        this.kii = 0.016666666666666666;
        for (Setting vmo2 : new Setting[]{this.kgm, this.kgn, this.kgo, this.kgp, this.kgq, this.kgr, this.kgs}) {
            vmo2.visibleWhen(() -> false);
        }
    }

    private void kit() {
        this.kgl.set(0.9);
        this.kgt.set(360.0);
        this.kgu.set(4.5);
        this.kgv.set(0.55);
        ConfigManager.autoSaveLater();
    }

    public class_1297 pilotTarget() {
        return this.isEnabled() ? this.kht.target() : null;
    }

    @Override
    protected void onDisable() {
        this.kht.reset();
        this.kht.forgetFrame();
        this.kjf();
        this.khx = null;
        this.kih = 0L;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            this.khx = null;
            return;
        }
        this.kht.use(AimModel.profileOld());
        this.kjb(class_3102);
        this.kht.tune(this.kgl.get(), 1.0 * (1.0 - 0.8 * this.kgm.get()), this.kgv.get());
        this.kht.newTick();
        this.kht.cap(this.kgn.get());
        class_1297 class_12972 = this.kjc(class_3102, class_7462) ? this.kiu(class_3102, class_7462) : null;
        long l = System.currentTimeMillis();
        if (class_12972 != null && this.kgq.get() && l - this.kin > 180L) {
            class_12972 = null;
        }
        int n = (int)Math.round(this.kgo.get() / 50.0);
        if (class_12972 != null && class_12972 == this.kio && l - this.kip < 1200L) {
            n = 0;
        }
        if (class_12972 != null) {
            this.kio = class_12972;
            this.kip = l;
        }
        this.kht.tick(class_3102, class_7462, class_12972, n, this.kgp.get());
        this.khx = class_12972;
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        if (!(this.kia != null && this.kib || class_3102.method_22683() == null)) {
            this.kje(class_3102.method_22683().method_4490());
        }
        long l = System.nanoTime();
        if (this.kih != 0L) {
            this.kii += (Math.min(0.1, (double)(l - this.kih) / 1.0E9) - this.kii) * 0.2;
        }
        this.kih = l;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1755 != null || !class_3102.field_1729.method_1613()) {
            this.kht.forgetFrame();
            return;
        }
        this.kht.frame(class_3102, class_7462);
    }

    /*
     * Exception decompiling
     */
    private class_1297 kiu(class_310 var1_1, class_746 var2_2) {
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

    private boolean kiv(class_746 class_7462, class_243 class_2432, class_1297 class_12972, double d, double d2) {
        if (class_12972.method_31481() || !this.kix(class_7462, class_12972, false) || !AimAssist.kiz(class_2432, class_12972, d + 1.5) || AimAssist.kja(class_7462, class_2432, class_12972) > d2 * 1.2) {
            return false;
        }
        if (this.khb.get() || class_7462.method_6057(class_12972)) {
            this.kiq = 0;
            return true;
        }
        return ++this.kiq <= 12;
    }

    private boolean kiw(class_746 class_7462, class_1297 class_12972) {
        return this.kix(class_7462, class_12972, true);
    }

    private boolean kix(class_746 class_7462, class_1297 class_12972, boolean bl) {
        class_1309 class_13092;
        if (!(class_12972 != class_7462 && class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_5805() && class_12972.method_5732())) {
            return false;
        }
        if (class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            if (!this.kgz.get() || class_16572.method_7325() || Friends.protects((class_1297)class_16572)) {
                return false;
            }
        } else if (!this.kha.get() || !(class_12972 instanceof class_1569)) {
            return false;
        }
        if (!this.khc.allows(class_12972)) {
            return false;
        }
        return !bl || this.khb.get() || class_7462.method_6057(class_12972);
    }

    private static double kiy(class_1309 class_13092) {
        vyd vyd2 = BelowNameHook.of(class_13092);
        return vyd2.unknown() ? 100.0 : (double)vyd2.total();
    }

    private static boolean kiz(class_243 class_2432, class_1297 class_12972, double d) {
        return class_12972.method_5829().method_49271(class_2432) <= d * d;
    }

    private static double kja(class_746 class_7462, class_243 class_2432, class_1297 class_12972) {
        class_243 class_2433 = class_12972.method_73189();
        double d = Math.toDegrees(Math.atan2(class_2433.field_1350 - class_2432.field_1350, class_2433.field_1352 - class_2432.field_1352)) - 90.0;
        return Math.abs(class_3532.method_15338((double)(d - (double)class_7462.method_36454())));
    }

    private void kjb(class_310 class_3102) {
        boolean bl;
        boolean bl2 = bl = class_3102.field_1690.field_1886.method_1434() || class_3102.field_1755 == null && class_3102.method_22683() != null && GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1;
        if (bl) {
            this.khw = System.currentTimeMillis();
        }
    }

    private boolean kjc(class_310 class_3102, class_746 class_7462) {
        if (class_3102.field_1755 != null || !class_3102.method_1569() || !class_3102.field_1729.method_1613() || !class_7462.method_5805() || class_7462.method_7325()) {
            return false;
        }
        if (class_3102.field_1761 != null && class_3102.field_1761.method_2923()) {
            return false;
        }
        if (class_7462.method_6115()) {
            return false;
        }
        if (AutoMace.busy() || RecorderHooks.mode() == tcw.RECORD || AutoMines.busy() || AncientFarmer.busy()) {
            return false;
        }
        if (this.kgy.get() && System.currentTimeMillis() - this.khw > 650L) {
            return false;
        }
        return this.kjd(class_7462.method_6047());
    }

    /*
     * Exception decompiling
     */
    private boolean kjd(class_1799 var1_1) {
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

    private void kje(long l) {
        if (khq == null || khr == null || khs == null) {
            khq = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1789", "D");
            khr = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1787", "D");
            khs = Reflect.find(class_312.class, "net.minecraft.class_312", "field_47842", "D");
        }
        if (khq == null || khr == null || khs == null) {
            return;
        }
        this.kif = 0.0;
        this.kie = 0.0;
        this.kid = 0.0;
        this.kic = 0.0;
        this.kig = Double.NaN;
        this.kim = 0.0;
        this.kil = 0.0;
        this.kik = 0.0;
        this.kij = 0.0;
        if (this.kia == null) {
            this.khy = l;
            this.kia = GLFWCursorPosCallback.create(this::kjg);
            this.khz = GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)this.kia);
        }
        this.kib = true;
    }

    private void kjf() {
        this.kib = false;
        if (this.kia == null) {
            return;
        }
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)this.khy, (GLFWCursorPosCallbackI)this.khz);
        if (gLFWCursorPosCallback != null && gLFWCursorPosCallback.address() == this.kia.address()) {
            this.kia.free();
            this.kia = null;
            this.khz = null;
        } else {
            GLFW.glfwSetCursorPosCallback((long)this.khy, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        }
    }

    private void kjg(long l, double d, double d2) {
        if (this.khz != null) {
            this.khz.invoke(l, d, d2);
        }
        if (this.kib) {
            class_310.method_1551().execute(this::kjh);
        }
    }

    private void kjh() {
        if (!this.kib || khq == null) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        try {
            double d = khq.getDouble(class_3102.field_1729);
            double d2 = khr.getDouble(class_3102.field_1729);
            double d3 = khs.getDouble(class_3102.field_1729);
            if (d3 != this.kig) {
                boolean bl = !Double.isNaN(this.kig) && d3 - this.kig < 0.25;
                this.kij = bl ? this.kil : 0.0;
                this.kik = bl ? this.kim : 0.0;
                this.kim = 0.0;
                this.kil = 0.0;
                this.kig = d3;
                this.kic = d;
                this.kid = d2;
            } else {
                this.kic += d - this.kie;
                this.kid += d2 - this.kif;
            }
            if (this.kic != 0.0 || this.kid != 0.0) {
                this.kin = System.currentTimeMillis();
            }
            this.kji(class_3102);
            this.kie = this.kic + this.khv[0];
            this.kif = this.kid + this.khv[1];
            khq.setDouble(class_3102.field_1729, this.kie);
            khr.setDouble(class_3102.field_1729, this.kif);
        }
        catch (IllegalAccessException illegalAccessException) {
            khq = null;
            this.kib = false;
        }
    }

    private void kji(class_310 class_3102) {
        this.khv[1] = 0.0;
        this.khv[0] = 0.0;
        class_746 class_7462 = class_3102.field_1724;
        class_1297 class_12972 = this.khx;
        if (this.kic == 0.0 && this.kid == 0.0 || !this.isEnabled() || class_7462 == null || class_12972 == null || !class_12972.method_5805() || class_12972.method_31481() || class_3102.field_1755 != null || !class_3102.field_1729.method_1613() || class_3102.field_1690.field_1914 || !class_3102.field_1690.method_31044().method_31034() || FreeCam.active()) {
            this.kim = 0.0;
            this.kil = 0.0;
            return;
        }
        double d = AimAssist.kjl(class_3102, class_7462);
        float f = class_3102.method_61966().method_60637(true);
        class_243 class_2432 = class_7462.method_5836(f);
        class_243 class_2433 = class_12972.method_30950(f);
        if (d <= 0.0 || !AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, class_2433.field_1352, class_2433.field_1351, class_2433.field_1350, (double)class_12972.method_17681() * 0.5, class_12972.method_17682(), 0.0, 0.5, this.khu)) {
            this.kim = 0.0;
            this.kil = 0.0;
            return;
        }
        double d2 = (Boolean)class_3102.field_1690.method_72706().method_41753() != false ? -1.0 : 1.0;
        double d3 = (Boolean)class_3102.field_1690.method_42438().method_41753() != false ? -1.0 : 1.0;
        double d4 = this.kic * d * d2;
        double d5 = this.kid * d * d3;
        double d6 = AngleUtil.wrap(this.khu.yaw - (double)class_7462.method_36454());
        double d7 = this.khu.pitch - (double)class_7462.method_36455();
        double d8 = AimAssist.kjk(d6 + this.khu.la, d6 + this.khu.ra);
        double d9 = AimAssist.kjk(d7 + this.khu.ta, d7 + this.khu.ba);
        double d10 = 1.0 - AimAssist.kjm(1.5, 8.0, Math.hypot(d8, d9));
        double d11 = AimAssist.kjm(350.0, 1000.0, Math.hypot(d4, d5) / Math.max(0.001, this.kii));
        double d12 = (this.kjj(d4, d8, d6, d10) - d4) * (1.0 - d11);
        double d13 = (this.kjj(d5, d9, d7, d10) - d5) * (1.0 - d11) * this.kgv.get();
        double d14 = d12 / d * d2 + this.kij;
        double d15 = d13 / d * d3 + this.kik;
        this.khv[0] = Math.rint(d14);
        this.khv[1] = Math.rint(d15);
        this.kil = d14 - this.khv[0];
        this.kim = d15 - this.khv[1];
    }

    private double kjj(double d, double d2, double d3, double d4) {
        boolean bl;
        if (d == 0.0) {
            return 0.0;
        }
        boolean bl2 = d2 != 0.0 ? d * d2 > 0.0 : (bl = d * d3 > 0.0);
        if (!bl) {
            return d * class_3532.method_16436((double)d4, (double)1.0, (double)this.kgs.get());
        }
        if (d2 == 0.0) {
            return d;
        }
        double d5 = d * this.kgr.get();
        double d6 = Math.max(Math.abs(d), Math.abs(d3));
        return Math.abs(d5) > d6 ? Math.copySign(d6, d) : d5;
    }

    private static double kjk(double d, double d2) {
        return d > 0.0 ? d : (d2 < 0.0 ? d2 : 0.0);
    }

    private static double kjl(class_310 class_3102, class_746 class_7462) {
        double d = (Double)class_3102.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = class_3102.field_1690.method_31044().method_31034() && class_7462.method_31550();
        return (bl ? d2 : d2 * 8.0) * 0.15;
    }

    private static double kjm(double d, double d2, double d3) {
        double d4 = class_3532.method_15350((double)((d3 - d) / (d2 - d)), (double)0.0, (double)1.0);
        return d4 * d4 * (3.0 - 2.0 * d4);
    }

    private /* synthetic */ boolean lambda$pickTarget$1(class_746 class_7462, class_1297 class_12972) {
        return this.kiw(class_7462, class_12972);
    }

    private static /* synthetic */ int ath(int n, int n2) {
        return (n ^ n2) + -855431446;
    }

    private static /* synthetic */ int ati(int n, int n2) {
        return AimAssist.ath(n, n2) ^ 0x6FA7BA6B;
    }
}

