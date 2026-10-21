/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1835
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3489
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 *  net.minecraft.class_9362
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.Friends;
import a.ProfilePopup;
import a.ModuleCategory;
import a.Module;
import a.AutoMine;
import a.AimModel;
import a.tcw;
import a.RecorderHooks;
import a.AimBrain;
import a.StudioProfiles;
import a.DummyPlayer;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.TextSetting;
import flow.dev.StringDecryptor;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1835;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3489;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import net.minecraft.class_9362;
import org.lwjgl.glfw.GLFW;

public class AimStudio
extends Module {
    private static AimStudio lds;
    private static StudioProfiles ldt;
    private static String ldu;
    private final ButtonSetting ldv = this.add(new ButtonSetting("Studio", new vkq("Open studio", Icon.LAYERS, ProfilePopup::open)));
    private final TextSetting ldw = this.add(new TextSetting("Profile", "", 32));
    private final NumberSetting ldx = this.add(new NumberSetting("Speed", 1.0, 0.3, 1.6, 0.05).percent());
    private final NumberSetting ldy = this.add(new NumberSetting("Texture", 1.0, 0.0, 1.5, 0.05).percent());
    private final NumberSetting ldz = this.add(new NumberSetting("Vertical", 1.0, 0.0, 1.0, 0.05).percent());
    private final NumberSetting lea = this.add(new NumberSetting("FOV", 120.0, 20.0, 360.0, 5.0).unit("°"));
    private final NumberSetting leb = this.add(new NumberSetting("Distance", 5.0, 3.0, 8.0, 0.1).suffix("m"));
    private final NumberSetting lec = this.add(new NumberSetting("Reaction", 120.0, 0.0, 300.0, 10.0).suffix("ms"));
    private final ModeSetting led = this.add(new ModeSetting("Activation", "Always", "Always", "On attack", "On key"));
    private final KeySetting lee = this.add(new KeySetting("Aim key"));
    private final ModeSetting lef = this.add(new ModeSetting("Items", "Weapons", "Weapons", "Any"));
    private final BoolSetting leg = this.add(new BoolSetting("Players", true));
    private final BoolSetting leh = this.add(new BoolSetting("Mobs", false));
    private final BoolSetting lei = this.add(new BoolSetting("Through walls", false));
    private final BoolSetting lej = this.add(new BoolSetting("Yield to mouse", true));
    private final KeySetting lek = this.add(new KeySetting("Stop stands", 269));
    private final AimBrain lel = new AimBrain();
    private long lem;
    private long len;
    private static /* synthetic */ int leo;
    private static /* synthetic */ String lep;

    public AimStudio() {
        super("NeuroAim", "Aim trained on your own rotation", ModuleCategory.COMBAT);
        lds = this;
        this.ldw.visibleWhen(() -> false);
        this.lee.visibleWhen(() -> this.led.is("On key"));
    }

    public static AimStudio get() {
        return lds;
    }

    public static StudioProfiles activeProfile() {
        return AutoMine.activeProfile();
    }

    public static void activate(StudioProfiles tiq2) {
        AutoMine.activate(tiq2);
        if (lds != null) {
            AimStudio.lds.len = 0L;
        }
    }

    public int stopKey() {
        return this.lek.get();
    }

    public boolean aiming() {
        return this.isEnabled() && this.lel.aiming();
    }

    public class_1297 target() {
        return this.lel.target();
    }

    @Override
    protected void onDisable() {
        this.lel.reset();
        this.lel.forgetFrame();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        StudioProfiles tiq2;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.len > 1000L) {
            this.len = l;
            tiq2 = AimStudio.activeProfile();
            AimModel tck2 = tiq2 == null ? null : tiq2.model();
            this.lel.use(tck2);
        }
        this.leq(class_3102);
        this.lel.tune(this.ldx.get(), this.ldy.get(), this.ldz.get());
        tiq2 = this.ler(class_3102, class_7462) ? this.let(class_3102, class_7462) : null;
        int n = (int)Math.round(this.lec.get() / 50.0);
        this.lel.tick(class_3102, class_7462, (class_1297)tiq2, n, this.lej.get());
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || class_3102.field_1755 != null || !class_3102.field_1729.method_1613()) {
            this.lel.forgetFrame();
            return;
        }
        this.lel.frame(class_3102, class_7462);
    }

    private void leq(class_310 class_3102) {
        if (class_3102.field_1690.field_1886.method_1434() || class_3102.field_1755 == null && class_3102.method_22683() != null && GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1) {
            this.lem = System.currentTimeMillis();
        }
    }

    /*
     * Exception decompiling
     */
    private boolean ler(class_310 var1_1, class_746 var2_2) {
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

    private boolean les(class_1799 class_17992) {
        if (this.lef.is("Any")) {
            return true;
        }
        return class_17992.method_31573(class_3489.field_42611) || class_17992.method_31573(class_3489.field_42612) || class_17992.method_7909() instanceof class_9362 || class_17992.method_7909() instanceof class_1835;
    }

    private class_1297 let(class_310 class_3102, class_746 class_7462) {
        class_243 class_2432 = class_7462.method_33571();
        double d = this.leb.get();
        double d2 = this.lea.get() * 0.5;
        class_1297 class_12973 = this.lel.target();
        if (class_12973 != null && this.leu(class_7462, class_12973) && AimStudio.lev(class_2432, class_12973, d) && AimStudio.lew(class_7462, class_2432, class_12973) <= Math.min(180.0, d2 * 1.25)) {
            return class_12973;
        }
        class_1297 class_12974 = null;
        double d3 = Double.MAX_VALUE;
        for (class_1297 class_12975 : class_3102.field_1687.method_8333((class_1297)class_7462, class_7462.method_5829().method_1014(d + 1.0), class_12972 -> this.leu(class_7462, (class_1297)class_12972))) {
            double d4;
            if (!AimStudio.lev(class_2432, class_12975, d) || (d4 = AimStudio.lew(class_7462, class_2432, class_12975)) > d2 || !(d4 < d3)) continue;
            d3 = d4;
            class_12974 = class_12975;
        }
        return class_12974;
    }

    private boolean leu(class_746 class_7462, class_1297 class_12972) {
        class_1309 class_13092;
        if (!(class_12972 != class_7462 && class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_5805() && class_12972.method_5732())) {
            return false;
        }
        if (class_12972 instanceof DummyPlayer) {
            return RecorderHooks.mode() == tcw.TEST;
        }
        if (class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            if (!this.leg.get() || class_16572.method_7325() || Friends.protects((class_1297)class_16572)) {
                return false;
            }
        } else if (!this.leh.get() || !(class_12972 instanceof class_1569)) {
            return false;
        }
        return this.lei.get() || class_7462.method_6057(class_12972);
    }

    private static boolean lev(class_243 class_2432, class_1297 class_12972, double d) {
        return class_12972.method_5829().method_49271(class_2432) <= d * d;
    }

    private static double lew(class_746 class_7462, class_243 class_2432, class_1297 class_12972) {
        class_243 class_2433 = class_12972.method_5829().method_1005();
        double d = Math.toDegrees(Math.atan2(class_2433.field_1350 - class_2432.field_1350, class_2433.field_1352 - class_2432.field_1352)) - 90.0;
        double d2 = -Math.toDegrees(Math.atan2(class_2433.field_1351 - class_2432.field_1351, Math.hypot(class_2433.field_1352 - class_2432.field_1352, class_2433.field_1350 - class_2432.field_1350)));
        double d3 = class_3532.method_15338((double)(d - (double)class_7462.method_36454()));
        double d4 = d2 - (double)class_7462.method_36455();
        return Math.sqrt(d3 * d3 + d4 * d4 * 0.25);
    }

    static {
        ldu = "";
    }

    private static /* synthetic */ int avw(int n, int n2) {
        return n + n2 | 0xCD9369D1;
    }

    private static /* synthetic */ int avx(int n, int n2) {
        return AimStudio.avw(n, n2) + n;
    }
}

