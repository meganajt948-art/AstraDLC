/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2743
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 *  net.minecraft.server.MinecraftServer
 */
package a;

import a.TestBotSpawner;
import a.gmx;
import a.gng;
import a.gnl;
import a.gno;
import a.Aura;
import a.Reflect;
import a.KeyUtil;
import a.PacketHooks;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2743;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import net.minecraft.server.MinecraftServer;

final class MovementTest {
    private static final gmx[] gns = new gmx[]{new gmx("strafe-stand", 500, 1, false, 0.0, false), new gmx("strafe-jump", 700, 1, true, 0.0, false), new gmx("sprint-jump", 700, 2, true, 0.0, false), new gmx("sprint-stand", 500, 2, false, 0.0, false), new gmx("fight-jump", 700, 1, true, 0.7, false), new gmx("fight-move", 700, 1, true, 0.7, true), new gmx("fight-sprint-move", 700, 2, true, 0.7, true), new gmx("fight-sprint-jump", 700, 2, true, 1.0, false)};
    private static final gmx[] gnt = MovementTest.gph();
    private static final int gnu = 100;
    private static final int gnv = 20;
    private static final boolean gnw = System.getenv("FLOW2_ORBIT_TRACE") != null;
    private static final Field gnx = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field gny = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static final gnl[] gnz = new gnl[gnt.length];
    private static final ConcurrentLinkedQueue<gng> goa = new ConcurrentLinkedQueue();
    private static final Random gob = new Random(23L);
    private static volatile boolean goc;
    private static volatile int god;
    private static volatile int goe;
    private static volatile UUID gof;
    private static volatile int gog;
    private static boolean goh;
    private static int goi;
    private static int goj;
    private static double gok;
    private static double gol;
    private static double gom;
    private static int gon;
    private static gno goo;
    private static int gop;
    private static boolean goq;
    private static boolean gor;
    private static boolean gos;
    private static boolean got;
    private static float gou;
    private static float gov;
    private static double gow;
    private static int gox;
    private static long goy;
    private static boolean goz;
    private static final Set<Integer> gpa;
    private static volatile int gpb;
    private static final ConcurrentLinkedQueue<Integer> gpc;
    private static int gpd;
    private static int gpe;
    private static /* synthetic */ boolean gpf;
    private static /* synthetic */ String gpg;

    private MovementTest() {
    }

    private static gmx[] gph() {
        String string = System.getenv("FLOW2_ORBIT_ONLY");
        if (string == null || string.isBlank()) {
            return gns;
        }
        List<String> list = Arrays.asList(string.split(","));
        return (gmx[])Arrays.stream(gns).filter(gmx2 -> list.contains(gmx2.gmy)).toArray(gmx[]::new);
    }

    static boolean tick(class_310 class_3102) {
        int n;
        class_746 class_7462 = class_3102.field_1724;
        MovementTest.gps();
        if (++goi == 1) {
            int n2 = class_3532.method_15357((double)class_7462.method_23317());
            int n3 = class_3532.method_15357((double)class_7462.method_23318());
            int n4 = class_3532.method_15357((double)class_7462.method_23321());
            gok = (double)n2 + 0.5;
            gol = n3;
            gom = (double)n4 + 0.5;
            gof = class_7462.method_5667();
            gpb = class_7462.method_5628();
            MovementTest.gpt(class_3102, "gamemode survival");
            MovementTest.gpt(class_3102, "time set day");
            MovementTest.gpt(class_3102, "weather clear");
            MovementTest.gpt(class_3102, "effect give @s resistance 99999 4 true");
            MovementTest.gpt(class_3102, "effect give @s saturation 99999 4 true");
            MovementTest.gpt(class_3102, "clear @s");
            MovementTest.gpt(class_3102, "kill @e[type=!player]");
            MovementTest.gpt(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
            MovementTest.gpt(class_3102, String.format(Locale.ROOT, "fill %d %d %d %d %d %d minecraft:glass hollow", n2 - 16, n3 - 1, n4 - 16, n2 + 16, n3 + 9, n4 + 16));
            MovementTest.gpt(class_3102, String.format(Locale.ROOT, "tp @s %.1f %d %.1f -90 0", gok, n3, gom));
            class_7462.method_31548().method_61496(0);
            return false;
        }
        if (goi == 8) {
            double d = gok + 2.7;
            class_3102.method_1576().execute(() -> TestBotSpawner.spawn((MinecraftServer)class_3102.method_1576(), gof, d, gol, gom));
            return false;
        }
        if (goi == 40) {
            MovementTest.gpq();
        }
        if (goi < 100) {
            if (goi > 20) {
                MovementTest.gpr(class_3102);
            }
            return false;
        }
        PacketHooks.ensure(class_3102);
        class_1297 class_12972 = MovementTest.gpr(class_3102);
        if (class_12972 == null) {
            System.out.println("orbit test FAIL no bot");
            return true;
        }
        if (class_3102.field_1729.method_1613()) {
            class_3102.field_1729.method_1610();
        }
        int n5 = goi - 100;
        int n6 = 0;
        for (n = 0; n < gnt.length && n5 >= n6 + MovementTest.gnt[n].gmz; ++n) {
            n6 += MovementTest.gnt[n].gmz;
        }
        if (n >= gnt.length) {
            goc = false;
            TestBotSpawner.active = false;
            TestBotSpawner.orbit = 0;
            class_3102.field_1690.field_1903.method_23481(false);
            MovementTest.gpk(class_3102);
            MovementTest.gpp();
            return true;
        }
        gmx gmx2 = gnt[n];
        if (n != gog) {
            MovementTest.gpl();
            if (gor && gog >= 0) {
                MovementTest.gpo(gnz[gog]);
            }
            gor = false;
            gog = n;
            goj = goi;
            MovementTest.gnz[n] = new gnl();
            TestBotSpawner.orbit = gmx2.gna;
            TestBotSpawner.jumping = true;
            TestBotSpawner.aggression = gmx2.gnc;
            TestBotSpawner.active = true;
            TestBotSpawner.orbitRadiusSum = 0.0;
            TestBotSpawner.orbitTurnSum = 0.0;
            TestBotSpawner.orbitTicks = 0;
            goo = null;
            gop = -1;
            goc = true;
            System.out.println("orbit phase " + gmx2.gmy);
        }
        if (--gox <= 0) {
            gox = 30 + gob.nextInt(60);
            gow = (gob.nextDouble() - 0.5) * 6.0;
        }
        class_7462.method_5872(gow / 0.15, 0.0);
        class_3102.field_1690.field_1903.method_23481(gmx2.gnb && goi - goj >= 20);
        MovementTest.gpi(class_3102, class_7462, class_12972, gmx2.gnd && goi - goj >= 20);
        float f = Reflect.getFloat(gnx, class_7462, class_7462.method_36454());
        float f2 = Reflect.getFloat(gny, class_7462, class_7462.method_36455());
        if (!Float.isNaN(gou) && goi - goj >= 20) {
            double d = class_3532.method_15393((float)(f - gou));
            double d2 = f2 - gov;
            MovementTest.gnz[n].turns.add(Math.sqrt(d * d + d2 * d2));
        }
        gou = f;
        gov = f2;
        return false;
    }

    private static void gpi(class_310 class_3102, class_746 class_7462, class_1297 class_12972, boolean bl) {
        double d;
        boolean bl2;
        gpa.clear();
        if (!bl) {
            MovementTest.gpj(class_3102.field_1690.field_1894, false);
            MovementTest.gpj(class_3102.field_1690.field_1881, false);
            MovementTest.gpj(class_3102.field_1690.field_1913, false);
            MovementTest.gpj(class_3102.field_1690.field_1849, false);
            KeyUtil.simulated = gpa::contains;
            return;
        }
        double d2 = class_12972.method_23317() - class_7462.method_23317();
        double d3 = class_12972.method_23321() - class_7462.method_23321();
        double d4 = Math.max(0.001, Math.sqrt(d2 * d2 + d3 * d3));
        if (--gpd <= 0) {
            gpd = 15 + gob.nextInt(30);
            gpe = gob.nextInt(3) - 1;
        }
        boolean bl3 = bl2 = Math.abs(class_7462.method_23317() - gok) > 11.0 || Math.abs(class_7462.method_23321() - gom) > 11.0;
        double d5 = d4 > 3.0 ? 1.0 : (d4 < 2.0 ? -1.0 : 0.0);
        double d6 = bl2 ? 0.0 : (double)gpe;
        double d7 = d2 / d4 * d5 + d3 / d4 * d6;
        double d8 = d3 / d4 * d5 - d2 / d4 * d6;
        if (bl2) {
            d7 = gok - class_7462.method_23317();
            d8 = gom - class_7462.method_23321();
        }
        double d9 = Math.hypot(d7, d8);
        double d10 = 0.0;
        double d11 = 0.0;
        if (d9 > 1.0E-6) {
            d = Math.toRadians(class_7462.method_36454());
            d10 = (d8 * Math.cos(d) - d7 * Math.sin(d)) / d9;
            d11 = (d7 * Math.cos(d) + d8 * Math.sin(d)) / d9;
        }
        d = Math.sin(Math.toRadians(22.5));
        MovementTest.gpj(class_3102.field_1690.field_1894, d10 > d);
        MovementTest.gpj(class_3102.field_1690.field_1881, d10 < -d);
        MovementTest.gpj(class_3102.field_1690.field_1913, d11 > d);
        MovementTest.gpj(class_3102.field_1690.field_1849, d11 < -d);
        KeyUtil.simulated = gpa::contains;
    }

    private static void gpj(class_304 class_3042, boolean bl) {
        class_3042.method_23481(bl);
        if (bl) {
            gpa.add(KeyBindingHelper.getBoundKeyOf((class_304)class_3042).method_1444());
        }
    }

    private static void gpk(class_310 class_3102) {
        class_3102.field_1690.field_1894.method_23481(false);
        class_3102.field_1690.field_1881.method_23481(false);
        class_3102.field_1690.field_1913.method_23481(false);
        class_3102.field_1690.field_1849.method_23481(false);
        KeyUtil.simulated = null;
    }

    private static void gpl() {
        if (gog >= 0 && gnz[gog] != null) {
            gnl gnl2 = gnz[gog];
            gnl2.radius = TestBotSpawner.orbitRadiusSum;
            gnl2.spin = TestBotSpawner.orbitTurnSum;
            gnl2.orbitTicks = TestBotSpawner.orbitTicks;
        }
    }

    private static void gpm(class_310 class_3102) {
        gng gng2;
        ++god;
        class_746 class_7462 = class_3102.field_1724;
        if (!goc || class_7462 == null || goe < 0 || gog < 0) {
            return;
        }
        class_1297 class_12972 = class_3102.field_1687.method_8469(goe);
        if (class_12972 == null) {
            return;
        }
        gnl gnl2 = gnz[gog];
        long l = System.nanoTime();
        if (goy != 0L && l - goy < 10000000L) {
            ++gnl2.bursts;
        }
        goy = l;
        while ((gng2 = goa.poll()) != null) {
            ++gnl2.serverHits;
            if (!gng2.gni) continue;
            ++gnl2.serverCrits;
            if (!gor) continue;
            goz = true;
        }
        while (gpc.poll() != null) {
            ++gnl2.knocks;
        }
        if (goo != null && MovementTest.goo.phase == gog) {
            MovementTest.gpn(goo, gon == MovementTest.goo.tick);
        }
        if (goi - goj < 20) {
            goo = null;
            return;
        }
        class_243 class_2432 = class_7462.method_33571();
        class_238 class_2383 = class_12972.method_5829();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(3.0));
        gno gno2 = new gno();
        gno2.tick = god;
        gno2.phase = gog;
        gno2.charged = class_7462.method_7261(0.5f) > 0.9f;
        gno2.reach = class_2383.method_49271(class_2432) <= 9.0;
        gno2.aimed = class_2383.method_1006(class_2432) || class_2383.method_992(class_2432, class_2433).isPresent();
        gno2.ground = class_7462.method_24828();
        gno2.crit = !gno2.ground && class_7462.field_6017 > 0.0;
        gno2.why = Aura.debug();
        double d = class_2383.method_49271(class_2432);
        if (d <= 16.0) {
            ++gnl2.nearTicks;
            if (Aura.target() == null) {
                ++gnl2.lostTicks;
            }
        }
        if (d > 9.0) {
            ++gnl2.farTicks;
        }
        class_243 class_2434 = class_2383.method_1005();
        double d2 = class_2434.field_1352 - class_2432.field_1352;
        double d3 = class_2434.field_1350 - class_2432.field_1350;
        gno2.yawErr = class_3532.method_15338((double)(Math.toDegrees(Math.atan2(d3, d2)) - 90.0 - (double)class_7462.method_36454()));
        gno2.pitchErr = -Math.toDegrees(Math.atan2(class_2434.field_1351 - class_2432.field_1351, Math.hypot(d2, d3))) - (double)class_7462.method_36455();
        if (goq && !gno2.ground && class_7462.method_18798().field_1351 > 0.0) {
            if (gor) {
                MovementTest.gpo(gnl2);
            }
            gor = true;
            gos = false;
            got = false;
            goz = false;
            ++gnl2.jumps;
        }
        goq = gno2.ground;
        goo = gno2;
    }

    private static void gpn(gno gno2, boolean bl) {
        gnl gnl2 = gnz[gno2.phase];
        ++gnl2.ticks;
        if (gno2.aimed) {
            ++gnl2.aimedTicks;
        }
        if (bl) {
            ++gnl2.hits;
            if (gor) {
                gos = true;
            }
        }
        if (gno2.crit && gno2.charged && gno2.reach && gor) {
            got = true;
        }
        if (gno2.charged && gno2.reach) {
            ++gnl2.ready;
            if (gop < 0) {
                gop = gno2.tick;
            }
            if (bl) {
                ++gnl2.readyHit;
            } else if (gno2.aimed) {
                ++gnl2.heldAimed;
                if (gno2.why.contains("crit=") && !gno2.why.contains("crit=-1") && !gno2.why.contains("crit=0 ")) {
                    ++gnl2.heldCrit;
                } else {
                    ++gnl2.heldOther;
                }
            } else {
                ++gnl2.notAimed;
            }
        }
        if (bl && gop >= 0) {
            int n = gno2.tick - gop;
            int[] nArray = gnl2.wait;
            int n2 = n <= 0 ? 0 : (n == 1 ? 1 : (n == 2 ? 2 : (n <= 5 ? 3 : (n <= 10 ? 4 : (n <= 20 ? 5 : 6)))));
            nArray[n2] = nArray[n2] + 1;
            gop = -1;
        }
        if (gnw) {
            System.out.println(String.format(Locale.ROOT, "orbit t=%d %s charged=%s reach=%s aimed=%s ground=%s crit=%s attack=%s err=%.1f/%.1f %s", gno2.tick, MovementTest.gnt[gno2.phase].gmy, gno2.charged, gno2.reach, gno2.aimed, gno2.ground, gno2.crit, bl, gno2.yawErr, gno2.pitchErr, gno2.why));
        }
    }

    private static void gpo(gnl gnl2) {
        if (gos) {
            ++gnl2.jumpsHit;
        }
        if (goz) {
            ++gnl2.jumpsCrit;
        }
        if (got) {
            ++gnl2.jumpsChance;
            if (gos) {
                ++gnl2.jumpsChanceHit;
            }
        }
    }

    private static void gpp() {
        MovementTest.gpl();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (int i = 0; i < gnt.length; ++i) {
            gnl gnl2 = gnz[i];
            if (gnl2 == null) continue;
            gnl2.turns.sort(Double::compare);
            double d = gnl2.turns.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double d2 = gnl2.turns.isEmpty() ? 0.0 : gnl2.turns.get((int)((double)gnl2.turns.size() * 0.95));
            double d3 = gnl2.turns.isEmpty() ? 0.0 : gnl2.turns.get(gnl2.turns.size() - 1);
            System.out.println(String.format(Locale.ROOT, "orbit %s: hits=%d (%.2f/s) server=%d crits=%d | ready=%d hitOnReady=%d heldAimed=%d (crit wait %d, other %d) notAimed=%d | aimed %.0f%% of ticks", MovementTest.gnt[i].gmy, gnl2.hits, gnl2.ticks == 0 ? 0.0 : (double)gnl2.hits * 20.0 / (double)gnl2.ticks, gnl2.serverHits, gnl2.serverCrits, gnl2.ready, gnl2.readyHit, gnl2.heldAimed, gnl2.heldCrit, gnl2.heldOther, gnl2.notAimed, gnl2.ticks == 0 ? 0.0 : 100.0 * (double)gnl2.aimedTicks / (double)gnl2.ticks));
            System.out.println(String.format(Locale.ROOT, "orbit %s: wait charged->hit 0t=%d 1t=%d 2t=%d 3-5t=%d 6-10t=%d 11-20t=%d 21+t=%d | jumps=%d hit=%d crit=%d chance=%d chanceHit=%d", MovementTest.gnt[i].gmy, gnl2.wait[0], gnl2.wait[1], gnl2.wait[2], gnl2.wait[3], gnl2.wait[4], gnl2.wait[5], gnl2.wait[6], gnl2.jumps, gnl2.jumpsHit, gnl2.jumpsCrit, gnl2.jumpsChance, gnl2.jumpsChanceHit));
            System.out.println(String.format(Locale.ROOT, "orbit %s: knockbacks=%d | out of reach %.0f%% of ticks | target lost %d of %d ticks within 4 m", MovementTest.gnt[i].gmy, gnl2.knocks, gnl2.ticks == 0 ? 0.0 : 100.0 * (double)gnl2.farTicks / (double)gnl2.ticks, gnl2.lostTicks, gnl2.nearTicks));
            System.out.println(String.format(Locale.ROOT, "orbit %s: sent turn avg=%.1f p95=%.1f max=%.1f deg/tick | bot radius %.2f spin %.1f deg/tick | ticks <10ms apart %d", MovementTest.gnt[i].gmy, d, d2, d3, gnl2.orbitTicks == 0 ? 0.0 : gnl2.radius / (double)gnl2.orbitTicks, gnl2.orbitTicks == 0 ? 0.0 : gnl2.spin / (double)gnl2.orbitTicks, gnl2.bursts));
            n += gnl2.hits;
            n2 += gnl2.serverHits;
            n3 += gnl2.serverCrits;
            n4 += gnl2.ready;
            n5 += gnl2.notAimed;
            n6 += gnl2.heldAimed;
            n7 += gnl2.ticks;
        }
        System.out.println(String.format(Locale.ROOT, "orbit RESULT hits=%d (%.2f/s) server=%d crits=%d ready=%d notAimed=%d heldAimed=%d", n, n7 == 0 ? 0.0 : (double)n * 20.0 / (double)n7, n2, n3, n4, n5, n6));
    }

    /*
     * Exception decompiling
     */
    private static void gpq() {
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

    private static class_1297 gpr(class_310 class_3102) {
        Object object;
        if (goe >= 0 && (object = class_3102.field_1687.method_8469(goe)) != null) {
            return object;
        }
        for (class_1657 class_16572 : class_3102.field_1687.method_18456()) {
            if (!"FlowBot".equals(class_16572.method_7334().name())) continue;
            goe = class_16572.method_5628();
            return class_16572;
        }
        return null;
    }

    private static void gps() {
        if (goh) {
            return;
        }
        goh = true;
        ClientTickEvents.START_CLIENT_TICK.register(MovementTest::gpm);
        PacketHooks.listen(class_25962 -> {
            class_2743 class_27432;
            if (goc && class_25962 instanceof class_2743 && (class_27432 = (class_2743)class_25962).method_11818() == gpb) {
                gpc.add(god);
            }
        });
        AttackEntityCallback.EVENT.register((class_16572, class_19372, class_12682, class_12972, class_39662) -> {
            if (class_19372.method_8608()) {
                if (goc && class_12972.method_5628() == goe) {
                    gon = god;
                }
                return class_1269.field_5811;
            }
            if (!goc || class_12972.method_5628() != TestBotSpawner.spawned || !class_16572.method_5667().equals(gof)) {
                return class_1269.field_5811;
            }
            boolean bl = class_16572.method_7261(0.5f) > 0.9f && class_16572.field_6017 > 0.0 && !class_16572.method_24828() && !class_16572.method_6101() && !class_16572.method_5799() && !class_16572.method_5765() && !class_16572.method_5624();
            goa.add(new gng(god, bl));
            return class_1269.field_5811;
        });
    }

    private static void gpt(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    static {
        goe = -1;
        gog = -1;
        gon = -1;
        gop = -1;
        goq = true;
        gou = Float.NaN;
        gpa = new HashSet<Integer>();
        gpb = -1;
        gpc = new ConcurrentLinkedQueue();
    }

    private static /* synthetic */ int vs(int n, int n2) {
        return n ^ n2 | 0xDA73E825;
    }

    private static /* synthetic */ int vt(int n, int n2) {
        return MovementTest.vs(n, n2) ^ 0xDD792CCF;
    }
}

