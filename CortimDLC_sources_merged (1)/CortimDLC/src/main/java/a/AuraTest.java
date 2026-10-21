/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.Module;
import a.Aura;
import a.AimCompare;
import a.tbm;
import a.AngleUtil;
import a.RecorderHooks;
import a.StudioProfiles;
import a.RecordingReader;
import a.Reflect;
import a.KeyUtil;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import org.lwjgl.glfw.GLFW;

final class AuraTest {
    private static final String fbx = System.getenv().getOrDefault("FLOW2_AURA_PROFILE", "AuraTest");
    private static final boolean fby = "p1".equals(System.getenv("FLOW2_AURA_BRAIN"));
    private static final int fbz = 2400;
    private static final Field fca = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field fcb = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static final Random fcc = new Random(7L);
    private static final Set<Integer> fcd = new HashSet<Integer>();
    private static final List<double[]> fce = new ArrayList<double[]>();
    private static final List<double[]> fcf = new ArrayList<double[]>();
    private static final List<Double> fcg = new ArrayList<Double>();
    private static final List<Double> fch = new ArrayList<Double>();
    private static Field fci;
    private static Field fcj;
    private static float fck;
    private static float fcl;
    private static int fcm;
    private static int fcn;
    private static int fco;
    private static int fcp;
    private static int fcq;
    private static final tbm fcr;
    private static double fcs;
    private static int fct;
    private static double fcu;
    private static double fcv;
    private static int fcw;
    private static class_1297 fcx;
    private static int fcy;
    private static final List<Integer> fcz;
    private static int fda;
    private static /* synthetic */ long fdb;
    private static /* synthetic */ boolean fdc;

    private AuraTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return false;
        }
        if (n == 1) {
            AuraTest.fdd(class_3102);
            return false;
        }
        AuraTest.fdn(class_3102);
        if (n < 60) {
            return false;
        }
        if (fcm < 0) {
            AuraTest.fde(class_3102);
            fcm = n;
            return false;
        }
        int n2 = n - fcm;
        AuraTest.fdf(class_3102, class_7462);
        AuraTest.fdh(class_3102, class_7462);
        if (n2 >= 2400) {
            AuraTest.fdm();
            RecorderHooks.stop();
            KeyUtil.simulated = null;
            return true;
        }
        return false;
    }

    private static void fdd(class_310 class_3102) {
        AuraTest.fdo(class_3102, "gamerule doMobSpawning false");
        AuraTest.fdo(class_3102, "effect give @s resistance infinite 255 true");
        AuraTest.fdo(class_3102, "effect give @s saturation infinite 255 true");
        AuraTest.fdo(class_3102, "fill ~-14 ~-1 ~-14 ~14 ~-1 ~14 minecraft:smooth_stone");
        AuraTest.fdo(class_3102, "fill ~-14 ~ ~-14 ~14 ~5 ~14 minecraft:air");
        AuraTest.fdo(class_3102, "give @s minecraft:diamond_sword");
        fci = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1783", "Z");
        fcj = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1695", "Z");
        long l2 = class_3102.method_22683().method_4490();
        GLFW.glfwSetCursorPosCallback((long)l2, (l, d, d2) -> {});
        GLFW.glfwSetMouseButtonCallback((long)l2, (l, n, n2, n3) -> {});
        class_3102.field_1724.method_31548().method_61496(0);
        for (String string : new String[]{"TriggerBot", "AimAssist", "AutoMace", "AutoSwap", "NeuroAim"}) {
            Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
            if (kfe2 == null) continue;
            kfe2.setEnabled(false);
        }
    }

    /*
     * Exception decompiling
     */
    private static void fde(class_310 var0) {
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

    private static void fdf(class_310 class_3102, class_746 class_7462) {
        if (--fcq <= 0) {
            fcq = 15 + fcc.nextInt(35);
            fcp = fcc.nextInt(3) - 1;
        }
        fcd.clear();
        AuraTest.fdg(class_3102.field_1690.field_1913, fcp < 0);
        AuraTest.fdg(class_3102.field_1690.field_1849, fcp > 0);
        AuraTest.fdg(class_3102.field_1690.field_1894, fcc.nextInt(4) == 0);
        class_3102.field_1690.field_1903.method_23481(class_7462.method_24828() && fcc.nextInt(25) == 0);
        KeyUtil.simulated = fcd::contains;
    }

    private static void fdg(class_304 class_3042, boolean bl) {
        class_3042.method_23481(bl);
        if (bl) {
            fcd.add(KeyBindingHelper.getBoundKeyOf((class_304)class_3042).method_1444());
        }
    }

    private static void fdh(class_310 class_3102, class_746 class_7462) {
        float f = Reflect.getFloat(fca, class_7462, class_7462.method_36454());
        float f2 = Reflect.getFloat(fcb, class_7462, class_7462.method_36455());
        class_1297 class_12972 = Aura.target();
        if (class_12972 != fcx) {
            fcx = class_12972;
            fcs = Double.NaN;
            fct = 0;
            int n = fcy = class_12972 != null && AuraTest.fdi(class_7462, class_12972, f, f2) >= 15.0 ? -1000 : -1;
            if (fcy == -1000) {
                ++fda;
            }
        }
        if (!Float.isNaN(fck) && class_12972 != null) {
            double d = class_3532.method_15393((float)(f - fck));
            fcg.add(d);
            fch.add(Double.valueOf(f2 - fcl));
            ++fcn;
            if (AuraTest.fdk(class_7462, class_12972, f, f2)) {
                ++fco;
            }
            if (fcy == -1000) {
                fcy = 0;
            } else if (fcy >= 0) {
                if (Math.hypot(d, f2 - fcl) > 0.001) {
                    fcz.add(fcy);
                    fcy = -1;
                } else if (++fcy > 40) {
                    fcy = -1;
                }
            }
            AuraTest.fdj(class_7462, class_12972, f, d);
        } else {
            AuraTest.fdl();
        }
        fck = f;
        fcl = f2;
    }

    private static double fdi(class_746 class_7462, class_1297 class_12972, float f, float f2) {
        class_243 class_2432 = class_7462.method_33571();
        class_238 class_2382 = class_12972.method_5829();
        if (!AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, (class_2382.field_1323 + class_2382.field_1320) * 0.5, class_2382.field_1322, (class_2382.field_1321 + class_2382.field_1324) * 0.5, (class_2382.field_1320 - class_2382.field_1323) * 0.5, class_2382.field_1325 - class_2382.field_1322, 0.0, 0.5, fcr)) {
            return 0.0;
        }
        return Math.hypot(AngleUtil.wrap(AuraTest.fcr.yaw - (double)f), AuraTest.fcr.pitch - (double)f2);
    }

    private static void fdj(class_746 class_7462, class_1297 class_12972, float f, double d) {
        double d2;
        class_243 class_2432 = class_7462.method_33571();
        class_238 class_2382 = class_12972.method_5829();
        if (!AngleUtil.aim(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, (class_2382.field_1323 + class_2382.field_1320) * 0.5, class_2382.field_1322, (class_2382.field_1321 + class_2382.field_1324) * 0.5, (class_2382.field_1320 - class_2382.field_1323) * 0.5, class_2382.field_1325 - class_2382.field_1322, 0.0, 0.5, fcr)) {
            return;
        }
        double d3 = AngleUtil.wrap((double)f - AuraTest.fcr.yaw);
        int n = d3 > AuraTest.fcr.ra + (d2 = 0.25 * AuraTest.fcr.bw) ? 1 : (d3 < AuraTest.fcr.la - d2 ? -1 : 0);
        fcu += d;
        if (!Double.isNaN(fcs)) {
            fcv += AngleUtil.wrap(AuraTest.fcr.yaw - fcs);
        }
        fcs = AuraTest.fcr.yaw;
        if (n != 0) {
            if (fct != 0 && n != fct && fcu * (double)n > 0.0 && fcu * (double)n > -fcv * (double)n) {
                ++fcw;
            }
            fct = n;
            fcu = 0.0;
            fcv = 0.0;
        }
    }

    private static boolean fdk(class_746 class_7462, class_1297 class_12972, float f, float f2) {
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_243.method_1030((float)f2, (float)f);
        class_238 class_2382 = class_12972.method_5829().method_1014((double)class_12972.method_5871());
        return class_2382.method_992(class_2432, class_2432.method_1019(class_2433.method_1021(8.0))).isPresent();
    }

    private static void fdl() {
        if (fcg.size() >= 8) {
            fce.add(fcg.stream().mapToDouble(Double::doubleValue).toArray());
            fcf.add(fch.stream().mapToDouble(Double::doubleValue).toArray());
        }
        fcg.clear();
        fch.clear();
    }

    private static void fdm() {
        AuraTest.fdl();
        StudioProfiles tiq2 = StudioProfiles.open(fbx);
        ArrayList<RecordingReader> arrayList = new ArrayList<RecordingReader>();
        if (tiq2 != null) {
            arrayList.addAll(tiq2.tapes());
        }
        double[] dArray = AimCompare.onTarget(arrayList);
        System.out.println(String.format(Locale.ROOT, "aura stands test %s: fighting %d ticks, server view on the stand %.1f%% (you in recordings %.1f%% of %d ticks)", fby ? "Profile 1" : fbx, fcn, 100.0 * (double)fco / (double)Math.max(1, fcn), dArray[0] * 100.0, (int)dArray[1]));
        double[] dArray2 = AimCompare.overshootRates(arrayList);
        fcz.sort(Integer::compare);
        System.out.println(String.format(Locale.ROOT, "aura stands test overshoots X: aura %.2f per 100 ticks, you %.2f | far engages %d, reaction ticks %s, instant %.0f%% | you: cold median %.0f, instant %.0f%%", 100.0 * (double)fcw / (double)Math.max(1, fcn), dArray2[0], fda, fcz, 100.0 * (double)fcz.stream().filter(n -> n == 0).count() / (double)Math.max(1, fcz.size()), AimCompare.medianReaction(arrayList), 100.0 * AimCompare.instantShare(arrayList)));
        for (String string : AimCompare.report(fce, fcf, arrayList)) {
            System.out.println("aura stands test " + string);
        }
    }

    private static void fdn(class_310 class_3102) {
        try {
            if (fci != null && class_3102.field_1755 == null) {
                fci.setBoolean(class_3102.field_1729, true);
            }
            if (fcj != null) {
                fcj.setBoolean(class_3102, true);
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
    }

    private static void fdo(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    static {
        fck = Float.NaN;
        fcm = -1;
        fcr = new tbm();
        fcs = Double.NaN;
        fcy = -1;
        fcz = new ArrayList<Integer>();
    }

    private static /* synthetic */ int np(int n, int n2) {
        return n - n2 + 263390829;
    }

    private static /* synthetic */ int nq(int n, int n2) {
        return AuraTest.np(n, n2) * n2;
    }
}

