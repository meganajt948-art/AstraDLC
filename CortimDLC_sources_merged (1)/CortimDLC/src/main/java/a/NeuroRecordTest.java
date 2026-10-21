/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_318
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_746
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gkj;
import a.Module;
import a.AimAssist;
import a.AimStudio;
import a.tbm;
import a.AngleUtil;
import a.RecorderHooks;
import a.StudioProfiles;
import a.DummyPlayer;
import a.Reflect;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_318;
import net.minecraft.class_3675;
import net.minecraft.class_746;
import org.lwjgl.glfw.GLFW;

final class NeuroRecordTest {
    private static final int gkn = Integer.getInteger("flow2.neuro.rec", 2400);
    private static final int gko = 1600;
    private static final boolean gkp = "1".equals(System.getenv("FLOW2_NEURO1"));
    private static final boolean gkq = "1".equals(System.getenv("FLOW2_NEURO_WOBBLE"));
    private static final boolean gkr = "1".equals(System.getenv("FLOW2_NEURO_BASE"));
    private static final Random gks = new Random(11L);
    private static Field gkt;
    private static Field gku;
    private static int gkv;
    private static int gkw;
    private static StudioProfiles gkx;
    private static final gkj gky;
    private static final gkj gkz;
    private static final List<String> gla;
    private static final Map<String, Integer> glb;
    private static DummyPlayer glc;
    private static int gld;
    private static double gle;
    private static double glf;
    private static final LinkedList<double[]> glg;
    private static double glh;
    private static double gli;
    private static int glj;
    private static int glk;
    private static double gll;
    private static double glm;
    private static double gln;
    private static double glo;
    private static int glp;
    private static float glq;
    private static float glr;
    private static boolean gls;
    private static int glt;
    private static int glu;
    private static int glv;
    private static boolean glw;
    private static /* synthetic */ int glx;
    private static /* synthetic */ boolean gly;

    private NeuroRecordTest() {
    }

    /*
     * Exception decompiling
     */
    static boolean tick(class_310 var0, int var1_1) throws Exception {
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

    private static AimAssist glz() {
        return (AimAssist)Flow.getInstance().getModuleManager().getByName("AimAssist");
    }

    private static void gma(int n) {
        ++gkv;
        gkw = n;
    }

    private static void gmb(class_310 class_3102) {
        class_3102.field_1690.field_1837 = false;
        NeuroRecordTest.gmj(class_3102, "gamemode survival");
        NeuroRecordTest.gmj(class_3102, "time set noon");
        NeuroRecordTest.gmj(class_3102, "gamerule doDaylightCycle false");
        NeuroRecordTest.gmj(class_3102, "gamerule doMobSpawning false");
        NeuroRecordTest.gmj(class_3102, "effect give @s resistance infinite 255 true");
        NeuroRecordTest.gmj(class_3102, "effect give @s saturation infinite 255 true");
        NeuroRecordTest.gmj(class_3102, "fill ~-14 ~-1 ~-14 ~14 ~-1 ~14 minecraft:smooth_stone");
        NeuroRecordTest.gmj(class_3102, "fill ~-14 ~ ~-14 ~14 ~5 ~14 minecraft:air");
        NeuroRecordTest.gmj(class_3102, "give @s minecraft:diamond_sword");
        gkt = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1783", "Z");
        gku = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1695", "Z");
        long l2 = class_3102.method_22683().method_4490();
        GLFW.glfwSetCursorPosCallback((long)l2, (l, d, d2) -> {});
        GLFW.glfwSetMouseButtonCallback((long)l2, (l, n, n2, n3) -> {});
        GLFW.glfwSetScrollCallback((long)l2, (l, d, d2) -> {});
        class_3102.field_1724.method_31548().method_61496(0);
        for (String string : new String[]{"TriggerBot", "AimAssist", "AutoMace", "AutoSwap"}) {
            Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
            if (kfe2 == null) continue;
            kfe2.setEnabled(false);
        }
    }

    private static void gmc(class_310 class_3102) throws Exception {
        if (gkt != null && class_3102.field_1755 == null) {
            gkt.setBoolean(class_3102.field_1729, true);
        }
        if (gku != null) {
            gku.setBoolean(class_3102, true);
        }
    }

    /*
     * Exception decompiling
     */
    private static void gmd() {
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

    private static void gme(class_310 class_3102, class_746 class_7462) {
        double d;
        DummyPlayer tkx2;
        List<DummyPlayer> list = RecorderHooks.stands();
        if (list.isEmpty()) {
            return;
        }
        if (glc == null || glc.method_31481() || --gld <= 0) {
            tkx2 = list.get(gks.nextInt(list.size()));
            if (tkx2 != glc || glc == null) {
                glc = tkx2;
                glg.clear();
                glk = glj;
                gle = gks.nextGaussian() * 0.3;
                glf = 0.6 + gks.nextDouble() * 0.28;
                gky.episode();
            }
            gld = 40 + gks.nextInt(70);
        }
        tkx2 = class_7462.method_33571();
        class_238 class_2383 = glc.method_5829();
        tbm tbm2 = new tbm();
        if (!AngleUtil.aim(((class_243)tkx2).field_1352, ((class_243)tkx2).field_1351, ((class_243)tkx2).field_1350, (class_2383.field_1323 + class_2383.field_1320) * 0.5, class_2383.field_1322, (class_2383.field_1321 + class_2383.field_1324) * 0.5, (class_2383.field_1320 - class_2383.field_1323) * 0.5, class_2383.field_1325 - class_2383.field_1322, gle, glf, tbm2)) {
            return;
        }
        glg.addLast(new double[]{tbm2.yaw, tbm2.pitch});
        if (glg.size() > 6) {
            glg.removeFirst();
        }
        double[] dArray = glg.size() >= 4 ? glg.get(glg.size() - 4) : glg.getFirst();
        double[] dArray2 = glg.size() >= 5 ? glg.get(glg.size() - 5) : dArray;
        double d2 = AngleUtil.wrap(dArray[0] - dArray2[0]);
        double d3 = dArray[1] - dArray2[1];
        double d4 = AngleUtil.wrap(dArray[0] + d2 * 3.0 - (double)class_7462.method_36454());
        double d5 = dArray[1] + d3 * 3.0 - (double)class_7462.method_36455();
        double d6 = 0.0;
        double d7 = 0.0;
        if (glk < glj) {
            d = NeuroRecordTest.gmi((double)glk / (double)glj);
            var22_15 = NeuroRecordTest.gmi((double)(glk + 1) / (double)glj);
            d6 += glh * (var22_15 - d);
            d7 += gli * (var22_15 - d);
            ++glk;
        } else {
            d = Math.hypot(d4, d5);
            if (d > Math.max(0.5, tbm2.bw * 0.55)) {
                var22_15 = 1.02 + gks.nextGaussian() * 0.08;
                glh = d4 * var22_15;
                gli = d5 * var22_15 * 0.9;
                glj = Math.max(2, (int)Math.round(2.0 + 1.5 * Math.log(1.0 + d / 2.0) / Math.log(2.0)));
                glk = 0;
                double d8 = NeuroRecordTest.gmi(1.0 / (double)glj);
                d6 += glh * d8;
                d7 += gli * d8;
                glk = 1;
            }
        }
        d6 += d2 * 0.8;
        d7 += d3 * 0.6;
        gll = 0.6 * gll + gks.nextGaussian() * 0.07;
        glm = 0.6 * glm + gks.nextGaussian() * 0.04;
        d = RecorderHooks.unit(class_3102);
        long l = (long)(gln += (d6 += gll) / d);
        long l2 = (long)(glo += (d7 += glm) / d);
        gln -= (double)l;
        glo -= (double)l2;
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        class_7462.method_5872((double)l * d / 0.15, (double)l2 * d / 0.15);
        double d9 = class_7462.method_36454() - f;
        double d10 = class_7462.method_36455() - f2;
        boolean bl = NeuroRecordTest.gmg(class_7462, class_2383);
        double d11 = AngleUtil.wrap((double)class_7462.method_36454() - tbm2.yaw);
        gky.sample(d9, d10, bl, d11, tbm2.la, tbm2.ra, tbm2.bw, AngleUtil.wrap(dArray[0] - dArray2[0]));
        boolean bl2 = false;
        for (DummyPlayer tkx3 : list) {
            bl2 |= NeuroRecordTest.gmg(class_7462, tkx3.method_5829());
        }
        if (class_7462.method_7261(0.5f) >= 0.9f && (bl && gks.nextDouble() < 0.75 || bl2 && gks.nextDouble() < 0.3) || gks.nextDouble() < 0.02) {
            NeuroRecordTest.gmh(class_3102);
        }
    }

    private static void gmf(class_310 class_3102, class_746 class_7462) {
        double d;
        double d2;
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        if (gls) {
            d2 = f - glq;
            d = f2 - glr;
            class_1297 class_12972 = gkp && !gkr ? NeuroRecordTest.glz().pilotTarget() : AimStudio.get().target();
            double d3 = RecorderHooks.unit(class_3102);
            double d4 = d2 / d3;
            ++NeuroRecordTest.gkz.gridTicks;
            if (Math.abs(d4 - Math.rint(d4)) > 0.01 && Math.abs(d2) > 1.0E-4) {
                ++NeuroRecordTest.gkz.offGrid;
            }
            if (class_12972 != null) {
                class_238 class_2383 = class_12972.method_5829();
                class_243 class_2432 = class_7462.method_33571();
                tbm tbm2 = new tbm();
                if (AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, (class_2383.field_1323 + class_2383.field_1320) * 0.5, class_2383.field_1322, (class_2383.field_1321 + class_2383.field_1324) * 0.5, (class_2383.field_1320 - class_2383.field_1323) * 0.5, class_2383.field_1325 - class_2383.field_1322, 0.0, 0.7, tbm2)) {
                    boolean bl = NeuroRecordTest.gmg(class_7462, class_2383);
                    gkz.sample(d2, d, bl, AngleUtil.wrap((double)f - tbm2.yaw), tbm2.la, tbm2.ra, tbm2.bw, 0.0);
                    gla.add(String.format(Locale.ROOT, "%d,%.4f,%.4f,%.3f,%.3f,%d", gla.size(), d2, d, AngleUtil.wrap(tbm2.yaw - (double)f), tbm2.pitch - (double)f2, bl ? 1 : 0));
                }
            }
        }
        if (--glp <= 0) {
            glp = 50 + gks.nextInt(60);
            d2 = (double)(gks.nextBoolean() ? 1 : -1) * (35.0 + gks.nextDouble() * 70.0);
            d = RecorderHooks.unit(class_3102);
            long l = Math.round(d2 / d);
            class_7462.method_5872((double)l * d / 0.15, 0.0);
            gkz.episode();
        } else if (gkq) {
            gll = 0.85 * gll + gks.nextGaussian() * 0.9;
            glm = 0.85 * glm + gks.nextGaussian() * 0.35;
            if (gks.nextDouble() < 0.04) {
                gll += (double)(gks.nextBoolean() ? 1 : -1) * (4.0 + gks.nextDouble() * 4.0);
            }
            d2 = RecorderHooks.unit(class_3102);
            long l = (long)(gln += gll / d2);
            long l2 = (long)(glo += glm / d2);
            gln -= (double)l;
            glo -= (double)l2;
            class_7462.method_5872((double)l * d2 / 0.15, (double)l2 * d2 / 0.15);
        }
        glq = class_7462.method_36454();
        glr = class_7462.method_36455();
        gls = true;
        ++glt;
        class_1297 class_12973 = RecorderHooks.stands().iterator();
        while (class_12973.hasNext()) {
            DummyPlayer tkx2 = class_12973.next();
            if (!NeuroRecordTest.gmg(class_7462, tkx2.method_5829())) continue;
            ++glu;
            break;
        }
        class_1297 class_12974 = class_12973 = gkp && !gkr ? NeuroRecordTest.glz().pilotTarget() : AimStudio.get().target();
        if (class_12973 == null && glw) {
            ++glv;
        }
        boolean bl = glw = class_12973 != null;
        if (class_7462.method_7261(0.5f) >= 0.9f && class_3102.field_1692 instanceof DummyPlayer) {
            NeuroRecordTest.gmh(class_3102);
        }
    }

    private static boolean gmg(class_746 class_7462, class_238 class_2383) {
        class_243 class_2432;
        class_243 class_2433 = class_7462.method_33571();
        return class_2383.method_992(class_2433, class_2432 = class_2433.method_1019(class_7462.method_5828(1.0f).method_1021(6.0))).isPresent() || class_2383.method_1006(class_2433);
    }

    private static void gmh(class_310 class_3102) {
        class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1886));
    }

    private static double gmi(double d) {
        d = Math.max(0.0, Math.min(1.0, d));
        return d * d * d * (10.0 - 15.0 * d + 6.0 * d * d);
    }

    private static void gmj(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void gmk(class_310 class_3102, String string) {
        System.out.println("self test " + string);
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        gky = new gkj("human");
        gkz = new gkj("model");
        gla = new ArrayList<String>();
        glb = new TreeMap<String, Integer>();
        glg = new LinkedList();
    }

    private static /* synthetic */ int us(int n, int n2) {
        return n - n2 + -679524899;
    }

    private static /* synthetic */ int ut(int n, int n2) {
        return NeuroRecordTest.us(n, n2) ^ 0x73ABB55C;
    }

    private static /* synthetic */ int uu(int n, int n2) {
        return NeuroRecordTest.ut(n, n2) ^ 0x21925D57;
    }
}

