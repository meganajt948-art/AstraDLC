/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1576
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.Module;
import a.RecorderHooks;
import a.Reflect;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1576;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import org.lwjgl.glfw.GLFW;

final class WorldSetupTest {
    private static final int ezp = 1200;
    private static final int ezq = 300;
    private static final Field ezr = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1783", "Z");
    private static final Field ezs = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1695", "Z");
    private static final Random ezt = new Random(5L);
    private static final List<Double> ezu = new ArrayList<Double>();
    private static double ezv;
    private static double ezw;
    private static double ezx;
    private static int ezy;
    private static int ezz;
    private static int faa;
    private static int fab;
    private static int fac;
    private static int fad;
    private static int fae;
    private static boolean faf;
    private static int fag;
    private static int fah;
    private static double fai;
    private static double faj;
    private static boolean fak;
    private static float fal;
    private static float fam;
    private static boolean fan;
    private static /* synthetic */ boolean fao;
    private static /* synthetic */ boolean fap;

    private WorldSetupTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        class_746 class_7462 = class_3102.field_1724;
        WorldSetupTest.fba(class_3102);
        if (n == 1) {
            WorldSetupTest.faq(class_3102, class_7462);
            return false;
        }
        if (n < 60) {
            return false;
        }
        WorldSetupTest.far(class_3102, n);
        int n2 = n - ezz;
        switch (ezy) {
            case 0: {
                WorldSetupTest.fax(true, false);
                WorldSetupTest.fay().setEnabled(true);
                WorldSetupTest.faz(n);
                break;
            }
            case 1: {
                WorldSetupTest.fas(class_3102, class_7462);
                if (n2 < 1200) break;
                WorldSetupTest.faz(n);
                WorldSetupTest.fax(false, false);
                fak = false;
                break;
            }
            case 2: {
                WorldSetupTest.fat(class_3102, class_7462, n2);
                if (n2 < 300) break;
                WorldSetupTest.faz(n);
                WorldSetupTest.fax(true, false);
                WorldSetupTest.fbb(class_3102, "effect give @e[type=minecraft:husk] invisibility infinite 0 true");
                fak = false;
                break;
            }
            case 3: {
                WorldSetupTest.fat(class_3102, class_7462, n2);
                if (n2 < 300) break;
                return WorldSetupTest.faw();
            }
            default: {
                return true;
            }
        }
        return false;
    }

    private static void faq(class_310 class_3102, class_746 class_7462) {
        class_3102.field_1690.field_1837 = false;
        long l2 = class_3102.method_22683().method_4490();
        GLFW.glfwSetCursorPosCallback((long)l2, (l, d, d2) -> {});
        GLFW.glfwSetMouseButtonCallback((long)l2, (l, n, n2, n3) -> {});
        ezv = Math.floor(class_7462.method_23317()) + 0.5;
        ezw = Math.floor(class_7462.method_23318());
        ezx = Math.floor(class_7462.method_23321()) + 0.5;
        WorldSetupTest.fbb(class_3102, "gamemode survival");
        WorldSetupTest.fbb(class_3102, "time set noon");
        WorldSetupTest.fbb(class_3102, "gamerule doMobSpawning false");
        WorldSetupTest.fbb(class_3102, "kill @e[type=!player]");
        WorldSetupTest.fbb(class_3102, "effect give @s resistance infinite 255 true");
        WorldSetupTest.fbb(class_3102, "effect give @s saturation infinite 255 true");
        WorldSetupTest.fbb(class_3102, "fill ~-12 ~-1 ~-12 ~12 ~-1 ~12 minecraft:smooth_stone");
        WorldSetupTest.fbb(class_3102, "fill ~-12 ~ ~-12 ~12 ~5 ~12 minecraft:air");
        WorldSetupTest.fbb(class_3102, "clear @s");
        WorldSetupTest.fbb(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
        WorldSetupTest.fbb(class_3102, String.format(Locale.ROOT, "tp @s %.1f %.1f %.1f 0 0", ezv, ezw, ezx));
        for (int i = 0; i < 2; ++i) {
            WorldSetupTest.fbb(class_3102, String.format(Locale.ROOT, "summon minecraft:husk %.2f %.1f %.2f {NoAI:1b,Silent:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:1024.0}],Health:1024f}", ezv + (double)i, ezw, ezx + 3.0));
        }
        WorldSetupTest.fbb(class_3102, "effect give @e[type=minecraft:husk] resistance infinite 4 true");
        class_7462.method_31548().method_61496(0);
        for (String string : new String[]{"TriggerBot", "AutoMace", "AutoSwap"}) {
            Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
            if (kfe2 == null) continue;
            kfe2.setEnabled(false);
        }
    }

    private static void far(class_310 class_3102, int n) {
        for (int i = 0; i < 2; ++i) {
            double d = Math.toRadians(-35.0 + 70.0 * (double)i + 25.0 * Math.sin((double)n * (0.045 + 0.02 * (double)i) + (double)i));
            double d2 = 2.8 + 0.45 * Math.sin((double)n * 0.03 + (double)i * 2.0);
            WorldSetupTest.fbb(class_3102, String.format(Locale.ROOT, "tp @e[type=minecraft:husk,limit=1,sort=%s] %.3f %.1f %.3f", i == 0 ? "nearest" : "furthest", ezv - Math.sin(d) * d2, ezw, ezx + Math.cos(d) * d2));
        }
    }

    private static void fas(class_310 class_3102, class_746 class_7462) {
        WorldSetupTest.fau(class_3102, class_7462);
        boolean bl = WorldSetupTest.fav(class_3102, class_7462);
        if (fan) {
            ++fae;
            if (!faf && bl) {
                faf = true;
                ++fac;
                fad += fae;
            }
        }
        if (--faa <= 0) {
            faa = 30 + ezt.nextInt(40);
            double d = (double)(ezt.nextBoolean() ? 1 : -1) * (20.0 + ezt.nextDouble() * 35.0);
            double d2 = RecorderHooks.unit(class_3102);
            long l = Math.round(d / d2);
            class_7462.method_5872((double)l * d2 / 0.15, 0.0);
            fal = class_7462.method_36454();
            fam = class_7462.method_36455();
            fan = true;
            faf = false;
            fae = 0;
            ++fab;
        }
    }

    private static void fat(class_310 class_3102, class_746 class_7462, int n) {
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        if (fak && n > 20) {
            faj += (double)(Math.abs(class_3532.method_15393((float)(f - fal))) + Math.abs(f2 - fam));
        }
        fal = f;
        fam = f2;
        fak = true;
        if (n == 1) {
            class_7462.method_5872(200.0, 0.0);
        }
    }

    private static void fau(class_310 class_3102, class_746 class_7462) {
        float f = class_7462.method_36454();
        float f2 = class_7462.method_36455();
        if (fak) {
            double d = f - fal;
            double d2 = f2 - fam;
            double d3 = RecorderHooks.unit(class_3102);
            double d4 = d / d3;
            ++fah;
            if (Math.abs(d4 - Math.rint(d4)) > 0.01 && Math.abs(d) > 1.0E-4) {
                ++fag;
            }
            double d5 = Math.hypot(class_3532.method_15338((double)d), d2);
            fai = Math.max(fai, d5);
            if (d5 > 0.5) {
                ezu.add(d5);
            }
        }
        fal = f;
        fam = f2;
        fak = true;
    }

    private static boolean fav(class_310 class_3102, class_746 class_7462) {
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(6.0));
        for (class_1297 class_12972 : class_3102.field_1687.method_18112()) {
            class_238 class_2382;
            if (!(class_12972 instanceof class_1576) || !(class_2382 = class_12972.method_5829()).method_992(class_2432, class_2433).isPresent()) continue;
            return true;
        }
        return false;
    }

    private static boolean faw() {
        WorldSetupTest.fay().setEnabled(false);
        double[] dArray = ezu.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        String string = dArray.length == 0 ? "none" : String.format(Locale.ROOT, "p50 %.2f p90 %.2f max %.2f", dArray[dArray.length / 2], dArray[(int)((double)dArray.length * 0.9)], dArray[dArray.length - 1]);
        System.out.println(String.format(Locale.ROOT, "aim test: acquired %d/%d, entry %.1f ticks, off-grid %d/%d, steps %s, turned while off %.2f°", fac, fab, (double)fad / (double)Math.max(1, fac), fag, fah, string, faj));
        boolean bl = (double)fac >= (double)fab * 0.8 && fag == 0 && fai < 60.0 && faj < 0.5;
        System.out.println("aim test " + (bl ? "PASS" : "FAIL"));
        return true;
    }

    /*
     * Exception decompiling
     */
    private static void fax(boolean var0, boolean var1_1) {
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

    private static Module fay() {
        return Flow.getInstance().getModuleManager().getByName("AimAssist");
    }

    private static void faz(int n) {
        ++ezy;
        ezz = n;
    }

    private static void fba(class_310 class_3102) {
        try {
            if (ezr != null && class_3102.field_1755 == null) {
                ezr.setBoolean(class_3102.field_1729, true);
            }
            if (ezs != null) {
                ezs.setBoolean(class_3102, true);
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
    }

    private static void fbb(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static /* synthetic */ int mv(int n, int n2) {
        return n ^ n2 | 0xCC2BFEC1;
    }

    private static /* synthetic */ int mw(int n, int n2) {
        return n ^ n2 | 0x50A4B7AD;
    }

    private static /* synthetic */ int mx(int n, int n2) {
        return WorldSetupTest.mv(n, n2) ^ 0xF16CE316;
    }
}

