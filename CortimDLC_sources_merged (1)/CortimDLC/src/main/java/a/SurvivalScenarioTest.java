/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1576
 *  net.minecraft.class_1657
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3966
 *  net.minecraft.class_746
 */
package a;

import a.gaq;
import a.Module;
import a.AutoMace;
import a.SmashPredictor;
import a.LandingTracker;
import a.Reflect;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1576;
import net.minecraft.class_1657;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3966;
import net.minecraft.class_746;

final class SurvivalScenarioTest {
    private static final int gay = 40;
    private static final int gaz = 24;
    private static final int gba = 140;
    private static final List<gaq> gbb = new ArrayList<gaq>();
    private static final Field gbc = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field gbd = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static final double gbe = 25.0;
    private static final double gbf = 45.0;
    private static final double gbg = 10.0;
    private static final double gbh = 10.0;
    private static final double[] gbi = new double[256];
    private static final double[] gbj = new double[256];
    private static final double[] gbk = new double[256];
    private static float gbl = Float.NaN;
    private static float gbm;
    private static int gbn;
    private static int gbo;
    private static final int[] gbp;
    private static final int[] gbq;
    private static final int[] gbr;
    private static final double[] gbs;
    private static final boolean[] gbt;
    private static final boolean[] gbu;
    private static final double[] gbv;
    private static final double[] gbw;
    private static final int[] gbx;
    private static final int[] gby;
    private static volatile int gbz;
    private static volatile int gca;
    private static boolean gcb;
    private static int gcc;
    private static double gcd;
    private static double gce;
    private static double gcf;
    private static int gcg;
    private static int gch;
    private static int gci;
    private static int gcj;
    private static float gck;
    private static float gcl;
    private static float gcm;
    private static float gcn;
    private static double gco;
    private static boolean gcp;
    private static boolean gcq;
    private static boolean gcr;
    private static final List<Double> gcs;
    private static final LandingTracker gct;
    private static final SmashPredictor gcu;
    private static final Random gcv;
    private static /* synthetic */ boolean gcw;
    private static /* synthetic */ String gcx;

    private SurvivalScenarioTest() {
    }

    static boolean tick(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        SurvivalScenarioTest.gde();
        if (++gcc == 1) {
            SurvivalScenarioTest.gcy();
            int n = class_3532.method_15357((double)class_7462.method_23317());
            int n2 = class_3532.method_15357((double)class_7462.method_23318());
            int n3 = class_3532.method_15357((double)class_7462.method_23321());
            gcd = (double)n + 4.5;
            gce = n2;
            gcf = (double)n3 + 0.5;
            SurvivalScenarioTest.gdg(class_3102, "gamemode survival");
            SurvivalScenarioTest.gdg(class_3102, "time set day");
            SurvivalScenarioTest.gdg(class_3102, "effect give @s resistance 900 4 true");
            SurvivalScenarioTest.gdg(class_3102, "effect give @s saturation 900 4 true");
            SurvivalScenarioTest.gdg(class_3102, "clear @s");
            SurvivalScenarioTest.gdg(class_3102, "kill @e[type=!player]");
            SurvivalScenarioTest.gdg(class_3102, System.getenv("FLOW2_MACE_INV") != null ? "item replace entity @s inventory.0 with minecraft:mace" : "item replace entity @s hotbar.0 with minecraft:mace");
            SurvivalScenarioTest.gdg(class_3102, "item replace entity @s hotbar.1 with minecraft:diamond_sword");
            SurvivalScenarioTest.gdg(class_3102, String.format(Locale.ROOT, "tp @s %.1f %d %.1f -90 0", (double)n + 0.5, n2, (double)n3 + 0.5));
            SurvivalScenarioTest.gdg(class_3102, String.format(Locale.ROOT, "summon minecraft:husk %.2f %d %.2f {NoAI:1b,Silent:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:1024.0}],Health:1024f}", gcd, n2, gcf));
            SurvivalScenarioTest.gdg(class_3102, "effect give @e[type=minecraft:husk] resistance infinite 3 true");
            class_7462.method_31548().method_61496(1);
            return false;
        }
        if (gcc == 30) {
            for (class_1297 class_12972 : class_3102.field_1687.method_18112()) {
                if (!(class_12972 instanceof class_1576)) continue;
                gca = class_12972.method_5628();
                gcd = class_12972.method_23317();
                gce = class_12972.method_23318();
                gcf = class_12972.method_23321();
            }
            if (gca < 0) {
                System.out.println("automace test FAIL no husk");
                return true;
            }
            SurvivalScenarioTest.gdf("TriggerBot");
            SurvivalScenarioTest.gdf("AimAssist");
            SurvivalScenarioTest.gdf("AutoSprint");
            return false;
        }
        if (gcc < 40) {
            return false;
        }
        gct.update(class_7462);
        if (class_3102.field_1729.method_1613()) {
            class_3102.field_1729.method_1610();
        }
        if (gcg < 0 || gch == 3) {
            if (++gcg >= gbb.size()) {
                return SurvivalScenarioTest.gdb();
            }
            SurvivalScenarioTest.gcz(class_3102, class_7462, gbb.get(gcg));
            return false;
        }
        SurvivalScenarioTest.gda(class_3102, class_7462, gbb.get(gcg));
        return false;
    }

    private static void gcy() {
        String string = System.getenv("FLOW2_MACE_ONLY");
        if (string == null || string.contains("sweep")) {
            for (int i = 1; i <= 4; ++i) {
                for (int j = 0; j < 3; ++j) {
                    gbb.add(new gaq("sweep", 8.0, 0.15, i));
                }
            }
        }
        double[] dArray = new double[]{6.0, 9.0, 13.0, 20.0};
        double[] dArray2 = new double[]{0.3, 1.5, 2.3};
        if (string == null || string.contains("client")) {
            for (double d : dArray) {
                for (double d2 : dArray2) {
                    gbb.add(new gaq("client", d, d2, 0));
                }
            }
        }
        if (string == null || string.contains("silent")) {
            for (double d : dArray) {
                for (double d2 : dArray2) {
                    gbb.add(new gaq("silent", d, d2, 0));
                }
            }
        }
        if (string == null || string.contains("moving")) {
            for (int i = 0; i < 8; ++i) {
                gbb.add(new gaq("moving", 12.0, 0.0, 0));
            }
        }
        if (string == null || string.contains("burst")) {
            gbb.add(new gaq("burst", 12.0, 0.4, 0));
        }
        if (string == null || string.contains("slow")) {
            for (double d : new double[]{9.0, 13.0, 20.0}) {
                for (double d2 : dArray2) {
                    gbb.add(new gaq("slow", d, d2, 0));
                }
            }
        }
        if (string == null || string.contains("height")) {
            for (double d : new double[]{6.0, 9.0, 13.0, 20.0}) {
                for (double d2 : new double[]{0.3, 1.5}) {
                    gbb.add(new gaq("height", d, d2, 0));
                }
            }
        }
    }

    private static void gcz(class_310 class_3102, class_746 class_7462, gaq gaq2) {
        boolean bl = gaq2.phase().equals("sweep");
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("AutoMace");
        SurvivalScenarioTest.gdd(kfe2, gaq2.phase().equals("silent") || gaq2.phase().equals("slow"), gaq2.phase().equals("slow"), gaq2.phase().equals("height") ? 10.0 : 1.5);
        kfe2.setEnabled(!bl);
        if (gaq2.phase().equals("burst")) {
            SurvivalScenarioTest.gdg(class_3102, "item replace entity @s hotbar.0 with minecraft:mace[enchantments={\"minecraft:wind_burst\":3}]");
        }
        class_7462.method_31548().method_61496(bl ? 0 : 1);
        double d = gcv.nextDouble() * Math.PI * 2.0;
        double d2 = gcd + Math.cos(d) * gaq2.offset();
        double d3 = gcf + Math.sin(d) * gaq2.offset();
        gck = bl ? 0.0f : (float)Math.round(gcv.nextDouble() * 3600.0 - 1800.0) / 10.0f;
        gcl = bl ? 90.0f : -90.0f;
        SurvivalScenarioTest.gdg(class_3102, String.format(Locale.ROOT, "tp @s %.3f %.3f %.3f %.1f %.1f", d2, gce + gaq2.height(), d3, Float.valueOf(gck), Float.valueOf(gcl)));
        gbz = gcg;
        gch = 0;
        gci = 0;
        gcj = 0;
        gcq = false;
        gcr = false;
        gcp = true;
        SurvivalScenarioTest.gbv[SurvivalScenarioTest.gcg] = 0.0;
        SurvivalScenarioTest.gbw[SurvivalScenarioTest.gcg] = 0.0;
        gbl = Float.NaN;
    }

    private static void gda(class_310 class_3102, class_746 class_7462, gaq gaq2) {
        boolean bl;
        ++gci;
        if (gaq2.phase().equals("moving")) {
            SurvivalScenarioTest.gdg(class_3102, String.format(Locale.ROOT, "tp @e[type=minecraft:husk] %.3f %.3f %.3f", gcd + Math.cos(gco += 0.1388888888888889) * 1.8, gce, gcf + Math.sin(gco) * 1.8));
        }
        if (gch == 0) {
            if (class_7462.method_23318() > gce + gaq2.height() - 0.5 || gci > 20) {
                gch = 1;
                gci = 0;
                gcm = class_7462.method_36454();
                gcn = class_7462.method_36455();
            }
            return;
        }
        boolean bl2 = class_7462.method_24828();
        if (!bl2) {
            gcq = true;
        }
        float f = SurvivalScenarioTest.gdc(gbc, class_7462);
        float f2 = SurvivalScenarioTest.gdc(gbd, class_7462);
        int n = AutoMace.strikes();
        gbo = n != gbn ? 0 : gbo + 1;
        gbn = n;
        if (!Float.isNaN(gbl) && gci > 2 && gaq2.sweep() == 0) {
            double d = Math.sqrt(class_3532.method_27285((float)class_3532.method_15393((float)(f - gbl))) + class_3532.method_27285((float)(f2 - gbm)));
            SurvivalScenarioTest.gbi[SurvivalScenarioTest.gcg] = Math.max(gbi[gcg], d);
            if (gbo == 0) {
                SurvivalScenarioTest.gbj[SurvivalScenarioTest.gcg] = Math.max(gbj[gcg], d);
            } else if (gbo == 1) {
                SurvivalScenarioTest.gbk[SurvivalScenarioTest.gcg] = Math.max(gbk[gcg], d);
            }
        }
        gbl = f;
        gbm = f2;
        if (bl2 && !gcp && gcq) {
            int n2 = gcg;
            gby[n2] = gby[n2] + 1;
        }
        gcp = bl2;
        float f3 = class_7462.method_36454();
        float f4 = class_7462.method_36455();
        double d = class_3532.method_15393((float)(f3 - gck));
        double d2 = f4 - gcl;
        double d3 = Math.sqrt(d * d + d2 * d2);
        if (gaq2.phase().equals("silent")) {
            SurvivalScenarioTest.gbw[SurvivalScenarioTest.gcg] = Math.max(gbw[gcg], d3);
            if (!bl2 && System.getenv("FLOW2_MACE_TRACE") != null) {
                System.out.println(String.format(Locale.ROOT, "automace trace drop=%d t=%d sent=%.1f/%.1f | %s", gcg, gci, Float.valueOf(f), Float.valueOf(f2), AutoMace.debug()));
            }
        } else if (!gaq2.phase().equals("sweep")) {
            double d4;
            SurvivalScenarioTest.gbv[SurvivalScenarioTest.gcg] = Math.max(gbv[gcg], d3);
            if (d3 > 0.5) {
                int n3 = gcg;
                gbx[n3] = gbx[n3] + 1;
            }
            if ((d4 = Math.sqrt(class_3532.method_27285((float)class_3532.method_15393((float)(f3 - gcm))) + class_3532.method_27285((float)(f4 - gcn)))) > 2.0) {
                gcs.add(d4);
            }
            if (d4 > 0.5 && System.getenv("FLOW2_MACE_TRACE") != null) {
                System.out.println(String.format(Locale.ROOT, "automace trace drop=%d t=%d yaw=%.1f pitch=%.1f step=%.1f ground=%s | %s", gcg, gci, Float.valueOf(f3), Float.valueOf(f4), d4, bl2, AutoMace.debug()));
            }
        }
        gcm = f3;
        gcn = f4;
        if (gaq2.sweep() > 0) {
            gcu.predict(class_7462, (class_1937)class_3102.field_1687, gct.get());
            if (!bl2 && !gcr && gcu.landing() == gaq2.sweep()) {
                gcr = true;
                class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3102.field_1690.field_1886));
            }
        }
        boolean bl3 = gaq2.phase().equals("burst") ? gci > 420 : (bl = gcq && bl2);
        gcj = bl ? ++gcj : 0;
        if (gcj > 24 || gci > (gaq2.phase().equals("burst") ? 440 : 140)) {
            SurvivalScenarioTest.gbt[SurvivalScenarioTest.gcg] = d3 < 1.5;
            SurvivalScenarioTest.gbu[SurvivalScenarioTest.gcg] = class_7462.method_31548().method_67532() == (gaq2.sweep() > 0 ? 0 : 1);
            System.out.println(String.format(Locale.ROOT, "automace drop %d %s h=%.0f off=%.1f sweep=%d: attacks=%d smash=%d crit=%d fall=%.2f returned=%s slot=%s maxOff=%.1f away=%d cam=%.2f landings=%d sent=%.1f atk=%.1f after=%.1f | %s", gcg, gaq2.phase(), gaq2.height(), gaq2.offset(), gaq2.sweep(), gbp[gcg], gbq[gcg], gbr[gcg], gbs[gcg], gbt[gcg], gbu[gcg], gbv[gcg], gbx[gcg], gbw[gcg], gby[gcg], gbi[gcg], gbj[gcg], gbk[gcg], AutoMace.debug()));
            gbz = -1;
            gch = 3;
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean gdb() {
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

    private static float gdc(Field field, class_746 class_7462) {
        try {
            return field.getFloat(class_7462);
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            return 0.0f;
        }
    }

    /*
     * Exception decompiling
     */
    private static void gdd(Module var0, boolean var1_1, boolean var2_2, double var3_3) {
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

    private static void gde() {
        if (gcb) {
            return;
        }
        gcb = true;
        AttackEntityCallback.EVENT.register(SurvivalScenarioTest::lambda$hook$0);
    }

    private static void gdf(String string) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(false);
        }
    }

    private static void gdg(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    /*
     * Unable to fully structure code
     */
    private static /* synthetic */ class_1269 lambda$hook$0(class_1657 var0, class_1937 var1_1, class_1268 var2_2, class_1297 var3_3, class_3966 var4_4) {
        var5_5 = SurvivalScenarioTest.gbz;
        if (var1_1.method_8608() || var5_5 < 0 || var3_3.method_5628() != SurvivalScenarioTest.gca) {
            return class_1269.field_5811;
        }
        var6_6 = var0.method_7261(0.5f);
        var7_7 = var6_6 > 0.9f && var0.field_6017 > 0.0 && var0.method_24828() == false && var0.method_5624() == false;
        v0 = var8_8 = var0.method_6047().method_31574(class_1802.field_49814) != false && var0.field_6017 > 1.5 && var0.method_6128() == false;
        if (!(var3_3 instanceof class_1309)) ** GOTO lbl-1000
        var10_9 = (class_1309)var3_3;
        if (var10_9.field_6008 > 10) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
        var9_10 = v1;
        v2 = var5_5;
        SurvivalScenarioTest.gbp[v2] = SurvivalScenarioTest.gbp[v2] + 1;
        if (var8_8) {
            v3 = var5_5;
            SurvivalScenarioTest.gbq[v3] = SurvivalScenarioTest.gbq[v3] + 1;
        }
        if (var7_7) {
            v4 = var5_5;
            SurvivalScenarioTest.gbr[v4] = SurvivalScenarioTest.gbr[v4] + 1;
        }
        SurvivalScenarioTest.gbs[var5_5] = var0.field_6017;
        System.out.println(String.format(Locale.ROOT, "automace server attack drop=%d y=%.2f fall=%.2f ground=%s charge=%.2f smash=%s crit=%s iframes=%s", new Object[]{var5_5, var0.method_23318() - SurvivalScenarioTest.gce, var0.field_6017, var0.method_24828(), Float.valueOf(var6_6), var8_8, var7_7, var9_10}));
        return class_1269.field_5811;
    }

    static {
        gbo = 99;
        gbp = new int[256];
        gbq = new int[256];
        gbr = new int[256];
        gbs = new double[256];
        gbt = new boolean[256];
        gbu = new boolean[256];
        gbv = new double[256];
        gbw = new double[256];
        gbx = new int[256];
        gby = new int[256];
        gbz = -1;
        gca = -1;
        gcg = -1;
        gcs = new ArrayList<Double>();
        gct = new LandingTracker();
        gcu = new SmashPredictor();
        gcv = new Random(11L);
    }

    private static /* synthetic */ int tc(int n, int n2) {
        return n * n2 + 2060365132;
    }

    private static /* synthetic */ int td(int n, int n2) {
        return SurvivalScenarioTest.tc(n, n2) * n2;
    }
}

