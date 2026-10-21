/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.TriggerBotCrits;
import a.AutoMace;
import a.KeyPearl;
import a.AutoCrits;
import a.AimContext;
import a.RotationDebug;
import a.AimDriver;
import a.AutoMend;
import a.FreeCam;
import a.ServerHelper;
import a.AimModel;
import a.tcw;
import a.RecorderHooks;
import a.StudioProfiles;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.TextSetting;
import a.vyd;
import a.BelowNameHook;
import a.KeyUtil;
import flow.config.ConfigManager;
import flow.dev.StringDecryptor;
import java.util.Locale;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public class Aura
extends Module {
    private final ModeSetting kwg = this.add(new ModeSetting("Rotation", "Silent", "Silent", "Client"));
    private final ModeSetting kwh = this.add(new ModeSetting("Aim", "Neural", "Neural", "Shard"));
    private final ModeSetting kwi = this.add(new ModeSetting("Neural model", "Profile 1", "Profile 1", "Studio"));
    private final TextSetting kwj = this.add(new TextSetting("Aura profile", "", 32));
    private final NumberSetting kwk = this.add(new NumberSetting("Speed", 1.0, 0.3, 1.6, 0.05).percent());
    private final NumberSetting kwl = this.add(new NumberSetting("Vertical", 1.0, 0.0, 1.0, 0.05).percent());
    private final ModeSetting kwm = this.add(new ModeSetting("Aim height", "Model", "Model", "Custom"));
    private final NumberSetting kwn = this.add(new NumberSetting("Height from", 0.45, 0.0, 1.0, 0.05).percent());
    private final NumberSetting kwo = this.add(new NumberSetting("Height to", 0.85, 0.0, 1.0, 0.05).percent());
    private final NumberSetting kwp = this.add(new NumberSetting("FOV", 360.0, 10.0, 360.0, 5.0).unit("°"));
    private final NumberSetting kwq = this.add(new NumberSetting("Distance", 4.0, 2.0, 6.0, 0.1).suffix("m"));
    private final ModeSetting kwr = this.add(new ModeSetting("Items", "Weapons", "Weapons", "Swords", "Axes", "Any"));
    private final ModeSetting kws = this.add(new ModeSetting("Priority", "Angle", "Angle", "Distance", "Health"));
    private final BoolSetting kwt = this.add(new BoolSetting("Crits", true));
    private final BoolSetting kwu = this.add(new BoolSetting("Move fix", true));
    private final BoolSetting kwv = this.add(new BoolSetting("Return view", false));
    private final BoolSetting kww = this.add(new BoolSetting("Players", true));
    private final BoolSetting kwx = this.add(new BoolSetting("Mobs", false));
    private final BoolSetting kwy = this.add(new BoolSetting("Through walls", false));
    private static final double kwz = 1.2;
    private static final int kxa = 2;
    private static final double kxb = Math.sin(Math.toRadians(22.5));
    private static final int kxc = 8;
    private static final int kxd = 2;
    private final Random kxe = new Random();
    private static Aura kxf;
    private final AimDriver kxg = new AimDriver();
    private final TriggerBotCrits kxh = TriggerBotCrits.embedded(this::kyg);
    private final AimContext kxi = new AimContext();
    private final RotationDebug kxj = new RotationDebug(this.kxi);
    private class_1297 kxk;
    private class_243 kxl;
    private double kxm;
    private boolean kxn;
    private boolean kxo;
    private boolean kxp;
    private class_746 kxq;
    private StudioProfiles kxr;
    private String kxs = "";
    private AimModel kxt;
    private long kxu;
    private int kxv = 2;
    private static /* synthetic */ long kxw;
    private static /* synthetic */ String kxx;

    public Aura() {
        super("KillAura", "Fights the nearest target with the neural rotation", ModuleCategory.COMBAT);
        kxf = this;
        this.kwu.visibleWhen(() -> this.kwg.is("Silent"));
        this.kwv.visibleWhen(() -> this.kwg.is("Client"));
        this.kwi.visibleWhen(() -> this.kwh.is("Neural"));
        this.kwk.visibleWhen(() -> this.kwh.is("Neural") && !this.kwi.is("Studio"));
        this.kwl.visibleWhen(() -> this.kwh.is("Neural") && !this.kwi.is("Studio"));
        this.kwm.visibleWhen(() -> this.kwh.is("Neural") && !this.kwi.is("Studio"));
        this.kwn.visibleWhen(() -> this.kwh.is("Neural") && !this.kwi.is("Studio") && this.kwm.is("Custom"));
        this.kwo.visibleWhen(() -> this.kwh.is("Neural") && !this.kwi.is("Studio") && this.kwm.is("Custom"));
        this.kwj.visibleWhen(() -> false);
    }

    public static StudioProfiles studioProfile() {
        Aura kwf2 = kxf;
        if (kwf2 == null) {
            return null;
        }
        String string = kwf2.kwj.get();
        if (string == null || string.isBlank()) {
            kwf2.kxr = null;
            kwf2.kxs = "";
            return null;
        }
        if (kwf2.kxr == null || !string.equals(kwf2.kxs)) {
            kwf2.kxs = string;
            kwf2.kxr = StudioProfiles.open(string);
        }
        return kwf2.kxr;
    }

    public static boolean usesStudio(StudioProfiles tiq2) {
        Aura kwf2 = kxf;
        return kwf2 != null && tiq2 != null && kwf2.kwi.is("Studio") && Aura.studioProfile() == tiq2;
    }

    public static void useStudio(StudioProfiles tiq2) {
        Aura kwf2 = kxf;
        if (kwf2 == null) {
            return;
        }
        kwf2.kwj.set(tiq2 == null ? "" : tiq2.name);
        kwf2.kxr = tiq2;
        kwf2.kxs = tiq2 == null ? "" : tiq2.name;
        kwf2.kwi.set(tiq2 == null ? "Profile 1" : "Studio");
        kwf2.kxu = 0L;
        ConfigManager.autoSaveLater();
    }

    private AimModel kxy() {
        if (!this.kwi.is("Studio")) {
            return AimModel.profile1();
        }
        long l = System.currentTimeMillis();
        if (l - this.kxu > 1000L) {
            this.kxu = l;
            StudioProfiles tiq2 = Aura.studioProfile();
            this.kxt = tiq2 == null ? null : tiq2.auraModel();
        }
        return this.kxt != null ? this.kxt : AimModel.profile1();
    }

    public static class_1297 target() {
        return kxf != null && kxf.isEnabled() ? Aura.kxf.kxg.target() : null;
    }

    public static String debug() {
        if (kxf == null) {
            return "off";
        }
        class_746 class_7462 = class_310.method_1551().field_1724;
        return String.format(Locale.ROOT, "offset=%s fighting=%s idle=%s view=%.1f/%.1f shard[%s] bot[%s]", Aura.kxf.kxg.debugOffsets(), Aura.kxf.kxo, Aura.kxf.kxg.idle(), class_7462 == null ? 0.0 : (double)Aura.kxf.kxg.serverYaw(class_7462), class_7462 == null ? 0.0 : (double)Aura.kxf.kxg.serverPitch(class_7462), Aura.kxf.kxj.debug(), Aura.kxf.kxh.trace());
    }

    public static boolean returning() {
        return kxf != null && Aura.kxf.kxp;
    }

    @Override
    public boolean ticksWhenOff() {
        return this.kxp;
    }

    @Override
    protected void onEnable() {
        if (!this.kxp) {
            this.kxg.reset();
        }
        this.kxp = false;
        this.kxq = null;
        this.kxo = false;
        this.kxj.enabled();
        this.kxh.onEnable();
    }

    @Override
    protected void onDisable() {
        this.kxh.onDisable();
        this.kxo = false;
        class_746 class_7462 = this.mc.field_1724;
        if (this.kwg.is("Silent") && class_7462 != null && class_7462.method_5805() && !this.kxg.idle()) {
            this.kxg.hit(2 + this.kxe.nextInt(3));
            this.kxp = true;
            this.kxq = class_7462;
            return;
        }
        this.kxg.end(class_7462);
        this.kye(this.mc);
        this.kxg.reset();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (!this.isEnabled()) {
            if (this.kxp && class_7462 == this.kxq) {
                this.kxg.begin(class_7462);
                if (this.kwu.get() && !this.kxg.idle() && class_3102.field_1755 == null) {
                    this.kyd(class_3102, class_7462);
                }
            }
            return;
        }
        boolean bl = this.kwg.is("Silent");
        this.kxg.mode(bl, class_7462);
        this.kxg.begin(class_7462);
        if (bl && this.kwu.get() && !this.kxg.idle() && class_3102.field_1755 == null) {
            this.kyd(class_3102, class_7462);
        }
        if (this.kyl(class_3102, class_7462) && this.kym(class_7462.method_6047()) && !AutoCrits.moduleOn()) {
            this.kxh.crits(this.kwt.get());
            this.kxh.onStartTick(class_3102);
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_1297 class_12972;
        class_746 class_7462 = class_3102.field_1724;
        this.kxg.end(class_7462);
        this.kxg.newTick(class_7462);
        this.kye(class_3102);
        AimModel tck2 = this.kxy();
        boolean bl = tck2 != AimModel.profile1();
        this.kxg.use(tck2, bl ? 1.0 : this.kwk.get());
        this.kxg.vertical(bl ? 1.0 : this.kwl.get());
        if (!bl && this.kwm.is("Custom")) {
            this.kxg.height(this.kwn.get(), this.kwo.get());
        } else {
            this.kxg.height(Double.NaN, Double.NaN);
        }
        this.kxg.verticalAware(false);
        this.kxg.stepCap(bl && tck2.turnCap > 0.0f ? (double)tck2.turnCap : this.kxg.maxTurn());
        int n = this.kxv = bl ? -1 : 2;
        if (!this.isEnabled()) {
            this.kyb(class_3102, class_7462);
            return;
        }
        this.kxh.onEndTick(class_3102);
        class_1297 class_12973 = class_12972 = this.kyl(class_3102, class_7462) && this.kym(class_7462.method_6047()) ? this.kyf(class_3102, class_7462) : null;
        if (class_12972 == null) {
            this.kxj.targetNull();
            this.kxi.target = null;
            this.kxk = null;
            this.kxl = null;
            if (this.kxo && class_7462.method_5805()) {
                this.kxg.hit(8 + this.kxe.nextInt(5));
            }
            this.kxo = false;
            this.kyc(class_3102, class_7462);
            return;
        }
        this.kxo = true;
        if (this.kwh.is("Shard")) {
            this.kxz(class_3102, class_7462, class_12972);
        } else {
            this.kxg.track(class_3102, class_7462, class_12972, this.kxv);
        }
    }

    private void kxz(class_310 class_3102, class_746 class_7462, class_1297 class_12972) {
        float f = this.kxg.serverYaw(class_7462);
        float f2 = this.kxg.serverPitch(class_7462);
        class_238 class_2383 = class_12972.method_5829();
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2383.method_1005();
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1351 - class_2432.field_1351;
        double d3 = class_2433.field_1350 - class_2432.field_1350;
        this.kxi.target = class_12972;
        this.kxi.box = class_2383;
        this.kxi.yawToTarget = (float)(Math.toDegrees(Math.atan2(d3, d)) - 90.0);
        this.kxi.pitchToTarget = (float)(-Math.toDegrees(Math.atan2(d2, Math.hypot(d, d3))));
        this.kxi.strikeIn = this.kxh.strikeIn(class_3102, class_7462, class_12972, this.kwt.get());
        this.kxi.attackReady = this.kxi.strikeIn == 0;
        this.kya(class_12972, class_2432, class_2433);
        if (this.kxj.rotate(f, f2)) {
            this.kxg.turnBy(class_3102, class_7462, class_12972, this.kxj.yaw() - f, this.kxj.pitch() - f2);
        }
    }

    private void kya(class_1297 class_12972, class_243 class_2432, class_243 class_2433) {
        class_243 class_2434;
        class_243 class_2435 = class_12972.method_73189();
        class_243 class_2436 = class_2434 = class_12972 == this.kxk && this.kxl != null ? class_2435.method_1020(this.kxl) : class_243.field_1353;
        if (class_2434.method_1027() > 1.0) {
            class_2434 = class_243.field_1353;
        }
        if (class_12972 != this.kxk || class_12972.method_24828()) {
            this.kxm = class_2435.field_1351;
        }
        this.kxk = class_12972;
        this.kxl = class_2435;
        double d = class_2433.field_1352;
        double d2 = class_2433.field_1351;
        double d3 = class_2433.field_1350;
        double d4 = class_12972.method_24828() ? 0.0 : class_2434.field_1351;
        double d5 = class_2433.field_1351 - (class_2435.field_1351 - this.kxm);
        for (int i = 0; i < 16; ++i) {
            this.kxi.eyeAt[i] = class_2432.method_1019(this.kxh.selfOffset(i));
            this.kxi.targetAt[i] = new class_243(d, d2, d3);
            d += class_2434.field_1352;
            d3 += class_2434.field_1350;
            if (d4 == 0.0 && !(d2 > d5)) continue;
            d2 += d4;
            d4 = (d4 - 0.08) * 0.98;
            if (!(d2 < d5)) continue;
            d2 = d5;
            d4 = 0.0;
        }
    }

    private void kyb(class_310 class_3102, class_746 class_7462) {
        if (class_7462 != this.kxq || class_7462 == null || !class_7462.method_5805() || !this.kwg.is("Silent") || this.kxg.home(class_3102, class_7462)) {
            this.kxg.reset();
            this.kxp = false;
            this.kxq = null;
        }
    }

    private void kyc(class_310 class_3102, class_746 class_7462) {
        if (!class_7462.method_5805()) {
            this.kxg.forget();
        } else if (this.kwv.get() || this.kwg.is("Silent")) {
            this.kxg.home(class_3102, class_7462);
        } else {
            this.kxg.release();
        }
    }

    private void kyd(class_310 class_3102, class_746 class_7462) {
        class_315 class_3152 = class_3102.field_1690;
        double d = (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1894) ? 1 : 0) - (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1881) ? 1 : 0);
        double d2 = (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1913) ? 1 : 0) - (KeyUtil.isPhysicallyDown(class_3102, class_3152.field_1849) ? 1 : 0);
        if (d == 0.0 && d2 == 0.0) {
            return;
        }
        double d3 = Math.toRadians(this.kxg.cameraYaw(class_7462));
        double d4 = d2 * Math.cos(d3) - d * Math.sin(d3);
        double d5 = d * Math.cos(d3) + d2 * Math.sin(d3);
        double d6 = Math.hypot(d4, d5);
        double d7 = Math.toRadians(class_7462.method_36454());
        double d8 = (d5 * Math.cos(d7) - d4 * Math.sin(d7)) / d6;
        double d9 = (d4 * Math.cos(d7) + d5 * Math.sin(d7)) / d6;
        class_3152.field_1894.method_23481(d8 > kxb);
        class_3152.field_1881.method_23481(d8 < -kxb);
        class_3152.field_1913.method_23481(d9 > kxb);
        class_3152.field_1849.method_23481(d9 < -kxb);
        this.kxn = true;
    }

    private void kye(class_310 class_3102) {
        if (!this.kxn || class_3102.field_1690 == null) {
            return;
        }
        this.kxn = false;
        for (class_304 class_3042 : new class_304[]{class_3102.field_1690.field_1894, class_3102.field_1690.field_1881, class_3102.field_1690.field_1913, class_3102.field_1690.field_1849}) {
            class_3042.method_23481(class_3102.field_1755 == null && KeyUtil.isPhysicallyDown(class_3102, class_3042));
        }
    }

    /*
     * Exception decompiling
     */
    private class_1297 kyf(class_310 var1_1, class_746 var2_2) {
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

    private boolean kyg(class_1297 class_12972) {
        if (class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            return this.kww.get() && !class_16572.method_7325() && !Friends.protects((class_1297)class_16572);
        }
        return this.kwx.get() && class_12972 instanceof class_1569;
    }

    private boolean kyh(class_746 class_7462, class_1297 class_12972) {
        class_1309 class_13092;
        if (!(class_12972 != class_7462 && class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_5805() && class_12972.method_5732() && this.kyg(class_12972))) {
            return false;
        }
        return this.kwy.get() || class_7462.method_6057(class_12972);
    }

    private static double kyi(class_1309 class_13092) {
        vyd vyd2 = BelowNameHook.of(class_13092);
        return vyd2.unknown() ? 100.0 : (double)vyd2.total();
    }

    private static boolean kyj(class_243 class_2432, class_1297 class_12972, double d) {
        return class_12972.method_5829().method_49271(class_2432) <= d * d;
    }

    private static double kyk(float f, class_243 class_2432, class_1297 class_12972) {
        class_243 class_2433 = class_12972.method_73189();
        double d = Math.toDegrees(Math.atan2(class_2433.field_1350 - class_2432.field_1350, class_2433.field_1352 - class_2432.field_1352)) - 90.0;
        return Math.abs(class_3532.method_15338((double)(d - (double)f)));
    }

    private boolean kyl(class_310 class_3102, class_746 class_7462) {
        return class_3102.field_1755 == null && class_7462.method_5805() && !class_7462.method_7325() && !class_7462.method_6115() && !class_7462.method_3144() && !FreeCam.active() && !ServerHelper.busy() && !KeyPearl.busy() && !AutoMend.busy() && !AutoMace.busy() && RecorderHooks.mode() != tcw.RECORD && (class_3102.field_1761 == null || !class_3102.field_1761.method_2923());
    }

    /*
     * Exception decompiling
     */
    private boolean kym(class_1799 var1_1) {
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

    private /* synthetic */ boolean lambda$pickTarget$9(class_746 class_7462, class_1297 class_12972) {
        return this.kyh(class_7462, class_12972);
    }

    private static /* synthetic */ int avm(int n, int n2) {
        return (n ^ n2) + 1400613756;
    }
}

