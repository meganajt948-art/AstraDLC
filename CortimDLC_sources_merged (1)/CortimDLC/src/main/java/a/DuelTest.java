/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.minecraft.class_1269
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2616
 *  net.minecraft.class_2743
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3966
 *  net.minecraft.class_746
 *  net.minecraft.server.MinecraftServer
 */
package a;

import a.TestBotSpawner;
import a.foo;
import a.fot;
import a.fpc;
import a.fpf;
import a.Module;
import a.Aura;
import a.AimCompare;
import a.StudioProfiles;
import a.RecordingReader;
import a.Reflect;
import a.KeyUtil;
import a.PacketHooks;
import a.ForwardKeyHold;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.class_1269;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2616;
import net.minecraft.class_2743;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3966;
import net.minecraft.class_746;
import net.minecraft.server.MinecraftServer;

final class DuelTest {
    private static final fot[] fpp = new fot[]{new fot("duel", 900, true, 0.6, true, 16.0f), new fot("aggro", 700, true, 1.0, true, 16.0f), new fot("calm", 600, true, 0.1, false, 14.0f), new fot("ground", 500, false, 0.5, true, 16.0f)};
    private static final fot[] fpq = DuelTest.fue();
    private static final int fpr = 100;
    private static final int fps = 8;
    private static final boolean fpt = System.getenv("FLOW2_DUEL_TRACE") != null;
    private static final String fpu = System.getenv("FLOW2_DUEL_AURA");
    private static final Field fpv = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3941", "F");
    private static final Field fpw = Reflect.find(class_746.class, "net.minecraft.class_746", "field_3925", "F");
    private static final Set<Integer> fpx = new HashSet<Integer>();
    private static final List<Double> fpy = new ArrayList<Double>();
    private static final List<double[]> fpz = new ArrayList<double[]>();
    private static final List<double[]> fqa = new ArrayList<double[]>();
    private static final List<Double> fqb = new ArrayList<Double>();
    private static final List<Double> fqc = new ArrayList<Double>();
    private static float fqd = Float.NaN;
    private static float fqe;
    private static double fqf;
    private static int fqg;
    private static int fqh;
    private static double fqi;
    private static final List<Double> fqj;
    private static final boolean fqk;
    private static int fql;
    private static double fqm;
    private static double fqn;
    private static int fqo;
    private static int fqp;
    private static int fqq;
    private static int fqr;
    private static double fqs;
    private static double fqt;
    private static final ConcurrentLinkedQueue<fpf> fqu;
    private static final ConcurrentLinkedQueue<foo> fqv;
    private static final ConcurrentLinkedQueue<Integer> fqw;
    private static final ConcurrentLinkedQueue<Integer> fqx;
    private static final List<fpc> fqy;
    private static final ArrayDeque<fpc> fqz;
    private static volatile int fra;
    private static volatile int frb;
    private static volatile int frc;
    private static volatile UUID frd;
    private static volatile boolean fre;
    private static volatile int frf;
    private static boolean frg;
    private static int frh;
    private static double fri;
    private static double frj;
    private static double frk;
    private static int frl;
    private static int frm;
    private static int frn;
    private static final Random fro;
    private static boolean frp;
    private static int frq;
    private static int frr;
    private static boolean frs;
    private static int frt;
    private static boolean fru;
    private static float frv;
    private static boolean frw;
    private static String frx;
    private static int fry;
    private static int frz;
    private static int fsa;
    private static boolean fsb;
    private static boolean fsc;
    private static final class_243[] fsd;
    private static float fse;
    private static float fsf;
    private static float fsg;
    private static int fsh;
    private static int fsi;
    private static int fsj;
    private static float fsk;
    private static int fsl;
    private static int fsm;
    private static final int[] fsn;
    private static final int[] fso;
    private static final int[] fsp;
    private static final int[] fsq;
    private static final int[] fsr;
    private static final int[] fss;
    private static final int[] fst;
    private static final int[] fsu;
    private static final int[][] fsv;
    private static final int[] fsw;
    private static final int[] fsx;
    private static final int[] fsy;
    private static final int[] fsz;
    private static final int[] fta;
    private static final double[] ftb;
    private static final double[] ftc;
    private static final int[] ftd;
    private static final int[] fte;
    private static final int[] ftf;
    private static final int[] ftg;
    private static final List<Double> fth;
    private static /* synthetic */ String fti;
    private static /* synthetic */ boolean ftj;

    private DuelTest() {
    }

    static boolean tick(class_310 class_3102) {
        int n;
        class_746 class_7462 = class_3102.field_1724;
        DuelTest.fub(class_3102);
        PacketHooks.ensure(class_3102);
        if (++frh == 1) {
            int n2 = class_3532.method_15357((double)class_7462.method_23317());
            int n3 = class_3532.method_15357((double)class_7462.method_23318());
            int n4 = class_3532.method_15357((double)class_7462.method_23321());
            fri = (double)n2 + 0.5;
            frj = n3;
            frk = (double)n4 + 0.5;
            frd = class_7462.method_5667();
            frc = class_7462.method_5628();
            DuelTest.fuf(class_3102, "gamemode survival");
            DuelTest.fuf(class_3102, "time set day");
            DuelTest.fuf(class_3102, "weather clear");
            DuelTest.fuf(class_3102, "effect give @s resistance 99999 4 true");
            DuelTest.fuf(class_3102, "effect give @s saturation 99999 4 true");
            DuelTest.fuf(class_3102, "clear @s");
            DuelTest.fuf(class_3102, "kill @e[type=!player]");
            DuelTest.fuf(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
            DuelTest.fuf(class_3102, String.format(Locale.ROOT, "fill %d %d %d %d %d %d minecraft:glass hollow", n2 - 16, n3 - 1, n4 - 16, n2 + 16, n3 + 9, n4 + 16));
            DuelTest.fuf(class_3102, String.format(Locale.ROOT, "tp @s %.1f %d %.1f -90 0", fri, n3, frk));
            class_7462.method_31548().method_61496(0);
            return false;
        }
        if (frh == 8) {
            double d = fri + 3.0;
            class_3102.method_1576().execute(() -> TestBotSpawner.spawn((MinecraftServer)class_3102.method_1576(), frd, d, frj, frk));
            return false;
        }
        if (frh == 40) {
            DuelTest.fuc();
        }
        if (frh < 100) {
            if (frh > 20) {
                DuelTest.fua(class_3102);
            }
            return false;
        }
        class_1297 class_12972 = DuelTest.fua(class_3102);
        if (class_12972 == null) {
            System.out.println("duel test FAIL no bot");
            return true;
        }
        if (class_3102.field_1729.method_1613()) {
            class_3102.field_1729.method_1610();
        }
        int n5 = frh - 100;
        int n6 = 0;
        for (n = 0; n < fpq.length && n5 >= n6 + DuelTest.fpq[n].fov; ++n) {
            n6 += DuelTest.fpq[n].fov;
        }
        if (n >= fpq.length) {
            fre = false;
            TestBotSpawner.active = false;
            DuelTest.ftz(class_3102);
            KeyUtil.simulated = null;
            DuelTest.ftw();
            DuelTest.fud();
            return true;
        }
        fot fot2 = fpq[n];
        if (n != frf) {
            if (frf >= 0) {
                DuelTest.ftf[DuelTest.frf] = TestBotSpawner.hits - frm;
                DuelTest.ftg[DuelTest.frf] = TestBotSpawner.critHits - frn;
            }
            frf = n;
            frl = frh;
            frm = TestBotSpawner.hits;
            frn = TestBotSpawner.critHits;
            TestBotSpawner.aggression = fot2.fox;
            TestBotSpawner.jumping = fot2.foy;
            TestBotSpawner.strafing = true;
            TestBotSpawner.active = true;
            fre = true;
            System.out.println("duel phase " + fot2.fou);
        }
        DuelTest.ftf[n] = TestBotSpawner.hits - frm;
        DuelTest.ftg[n] = TestBotSpawner.critHits - frn;
        if (fpt && frw && fry != fra) {
            System.out.println("duel skip " + fot2.fou + " " + frx);
        }
        frw = false;
        if (fpu != null) {
            DuelTest.ftk(class_3102, class_7462, class_12972, fot2.fow && frh - frl >= 20);
            return false;
        }
        if (frh - frl < 20) {
            DuelTest.ftx(class_3102, class_7462, class_12972, fot2, n);
            DuelTest.fty(class_3102, class_7462, class_12972, false);
            return false;
        }
        DuelTest.ftx(class_3102, class_7462, class_12972, fot2, n);
        DuelTest.fty(class_3102, class_7462, class_12972, fot2.fow);
        return false;
    }

    private static void ftk(class_310 class_3102, class_746 class_7462, class_1297 class_12972, boolean bl) {
        double d;
        boolean bl2;
        double d2;
        float f = Reflect.getFloat(fpv, class_7462, class_7462.method_36454());
        float f2 = Reflect.getFloat(fpw, class_7462, class_7462.method_36455());
        if (!Float.isNaN(fqd)) {
            double d3 = class_3532.method_15393((float)(f - fqd));
            d2 = f2 - fqe;
            fpy.add(Math.sqrt(d3 * d3 + d2 * d2));
            if (Aura.target() != null) {
                fqb.add(d3);
                fqc.add(d2);
            } else {
                DuelTest.ftl();
            }
            if (System.getenv("FLOW2_DUEL_AURA_TRACE") != null || Math.sqrt(d3 * d3 + d2 * d2) > 30.0) {
                System.out.println(String.format(Locale.ROOT, "duel AURA big turn t=%d sent %.1f/%.1f -> %.1f/%.1f camera %.1f/%.1f target=%s %s", fra, Float.valueOf(fqd), Float.valueOf(fqe), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(class_7462.method_36454()), Float.valueOf(class_7462.method_36455()), Aura.target(), Aura.debug()));
            }
        }
        fqd = f;
        fqe = f2;
        if (fqk) {
            DuelTest.ftm(class_7462, f, f2);
        }
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_12972.method_73189();
        d2 = Math.toDegrees(Math.atan2(class_2433.field_1350 - class_2432.field_1350, class_2433.field_1352 - class_2432.field_1352)) - 90.0;
        if ("silent".equals(fpu)) {
            if (--fsh <= 0) {
                fsh = 30 + fro.nextInt(60);
                fqf = (fro.nextDouble() - 0.5) * 6.0;
            }
            class_7462.method_5872(fqf / 0.15, 0.0);
            if (Math.abs(class_3532.method_15338((double)(d2 - (double)class_7462.method_36454()))) > 90.0) {
                ++fqg;
            }
        }
        ++fqh;
        double d4 = class_2433.field_1352 - class_7462.method_23317();
        double d5 = class_2433.field_1350 - class_7462.method_23321();
        double d6 = Math.max(0.001, Math.sqrt(d4 * d4 + d5 * d5));
        fqi += d6;
        if (--fsl <= 0) {
            fsl = 15 + fro.nextInt(30);
            fsm = fro.nextInt(3) - 1;
        }
        boolean bl3 = bl2 = Math.abs(class_7462.method_23317() - fri) > 12.0 || Math.abs(class_7462.method_23321() - frk) > 12.0;
        double d7 = d6 > 2.6 ? 1.0 : (d6 < 1.4 ? -1.0 : 0.0);
        double d8 = bl2 ? 0.0 : (double)fsm;
        double d9 = d4 / d6 * d7 + d5 / d6 * d8;
        double d10 = d5 / d6 * d7 - d4 / d6 * d8;
        double d11 = Math.hypot(d9, d10);
        double d12 = 0.0;
        double d13 = 0.0;
        if (d11 > 1.0E-6) {
            d = Math.toRadians(class_7462.method_36454());
            d12 = (d10 * Math.cos(d) - d9 * Math.sin(d)) / d11;
            d13 = (d9 * Math.cos(d) + d10 * Math.sin(d)) / d11;
        }
        d = Math.sin(Math.toRadians(22.5));
        fpx.clear();
        DuelTest.ftn(class_3102, class_3102.field_1690.field_1894, d12 > d);
        DuelTest.ftn(class_3102, class_3102.field_1690.field_1881, d12 < -d);
        DuelTest.ftn(class_3102, class_3102.field_1690.field_1913, d13 > d);
        DuelTest.ftn(class_3102, class_3102.field_1690.field_1849, d13 < -d);
        class_3102.field_1690.field_1903.method_23481(bl);
        KeyUtil.simulated = fpx::contains;
    }

    private static void ftl() {
        if (fqb.size() >= 8) {
            fpz.add(fqb.stream().mapToDouble(Double::doubleValue).toArray());
            fqa.add(fqc.stream().mapToDouble(Double::doubleValue).toArray());
        }
        fqb.clear();
        fqc.clear();
    }

    private static void ftm(class_746 class_7462, float f, float f2) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("KillAura");
        int n = fqh % 100;
        if (fql >= 0) {
            int n2 = fra - fql;
            if (n2 > 0 && fpy.size() > 0) {
                fqn = Math.max(fqn, fpy.get(fpy.size() - 1));
            }
            double d = Math.hypot(class_3532.method_15393((float)(f - class_7462.method_36454())), f2 - class_7462.method_36455());
            if (fqo < 0 && n2 > 0 && d < 1.0) {
                fqo = n2;
            }
        }
        if (n == 59 && fql >= 0) {
            System.out.println(String.format(Locale.ROOT, "duel AURA off #%d: view was %.1f deg from camera, back in %d ticks, max turn %.1f deg/tick", fqp, fqm, fqo, fqn));
            ++fqp;
            if (fqn > 35.0) {
                ++fqq;
            }
            if (fqo < 0) {
                ++fqr;
            } else {
                fqt += (double)fqo;
            }
            fqs = Math.max(fqs, fqn);
            fql = -1;
        }
        if (n == 0 && kfe2.isEnabled()) {
            fql = fra;
            fqm = Math.hypot(class_3532.method_15393((float)(f - class_7462.method_36454())), f2 - class_7462.method_36455());
            fqn = 0.0;
            fqo = -1;
            kfe2.setEnabled(false);
        } else if (n == 60 && !kfe2.isEnabled()) {
            kfe2.setEnabled(true);
        }
    }

    private static void ftn(class_310 class_3102, class_304 class_3042, boolean bl) {
        class_3042.method_23481(bl);
        class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3042);
        if (bl) {
            fpx.add(class_3062.method_1444());
        }
    }

    private static void fto(class_310 class_3102) {
        Object object;
        fpf fpf2;
        float f;
        Object object2;
        Integer n;
        ++fra;
        class_746 class_7462 = class_3102.field_1724;
        if (!fre || class_7462 == null || frb < 0) {
            return;
        }
        int n2 = frf;
        class_1297 class_12972 = class_3102.field_1687.method_8469(frb);
        if (class_12972 == null) {
            return;
        }
        if (System.getenv("FLOW2_DUEL_AURA_TRACE") != null) {
            System.out.println(String.format(Locale.ROOT, "duel AURA start t=%d yaw=%.1f sent=%.1f last=%.1f", fra, Float.valueOf(class_7462.method_36454()), Float.valueOf(Reflect.getFloat(fpv, class_7462, Float.NaN)), Float.valueOf(class_7462.field_5982)));
        }
        while ((n = fqx.poll()) != null) {
            frt = n;
            fru = !class_7462.method_24828() && class_7462.field_6017 > 0.0;
            int n3 = n2;
            fsw[n3] = fsw[n3] + 1;
            if (!fru) continue;
            int n4 = n2;
            fsx[n4] = fsx[n4] + 1;
        }
        double d = class_7462.method_23318() - class_7462.field_6036;
        boolean bl = class_7462.method_24828();
        frq = !bl && d < 0.0 ? ++frq : 0;
        for (fpc fpc2 : fqz) {
            if (fpc2.land >= 0 || !bl) continue;
            fpc2.land = fra - fpc2.tick;
        }
        if (frp && !bl && d > 0.0) {
            DuelTest.ftu(n2);
            frr = 0;
            frs = false;
            int n5 = n2;
            fsn[n5] = fsn[n5] + 1;
        }
        frp = bl;
        class_239 class_2392 = class_3102.field_1765;
        boolean bl2 = class_2392 != null && class_2392.method_17783() == class_239.class_240.field_1331 && ((class_3966)class_2392).method_17782() == class_12972;
        boolean bl3 = class_7462.method_7261(0.5f) > 0.9f;
        boolean bl4 = frw = bl2 && bl3;
        if (fpt && frw) {
            frx = String.format(Locale.ROOT, "t=%d ground=%s fallTick=%d dy=%.3f fall=%.2f vy=%.3f sprintSent=%s charge=%.2f knock=%d contact=%d", fra, bl, frq, d, class_7462.field_6017, class_7462.method_18798().field_1351, ForwardKeyHold.serverSprinting(class_7462), Float.valueOf(class_7462.method_7261(0.5f)), fra - frt, fsa < 0 ? -1 : fra - fsa);
        }
        if (bl2) {
            int n6 = n2;
            fte[n6] = fte[n6] + 1;
            if (!bl && bl3) {
                frs = true;
            }
            if (frz >= 5) {
                DuelTest.ftv(n2);
                fsa = fra;
                fsb = bl3;
                fsc = false;
                int n7 = n2;
                fss[n7] = fss[n7] + 1;
                if (bl3) {
                    int n8 = n2;
                    fst[n8] = fst[n8] + 1;
                }
            }
            frz = 0;
        } else if (++frz == 5) {
            DuelTest.ftv(n2);
        }
        if (class_12972 instanceof class_1309) {
            object2 = (class_1309)class_12972;
            v7 = object2.method_6032();
        } else {
            v7 = f = 0.0f;
        }
        if (frv >= 0.0f && f < frv - 0.01f && (object2 = DuelTest.fts(fra)) != null && ((fpc)object2).damage == 0.0f) {
            ((fpc)object2).damage = frv - f;
        }
        frv = f;
        while ((object2 = fqw.poll()) != null) {
            fpc fpc3 = DuelTest.fts((Integer)object2);
            if (fpc3 == null) continue;
            fpc3.seenCrit = true;
        }
        long l = System.nanoTime();
        while ((fpf2 = fqu.peek()) != null) {
            fqu.poll();
            object = DuelTest.ftt(fpf2.fpg);
            if (object == null || ((fpc)object).serverCrit != null) continue;
            ((fpc)object).serverCrit = fpf2.fph;
            if (!((fpc)object).clientCrit || fpf2.fph) continue;
            System.out.println(String.format(Locale.ROOT, "duel client-crit rejected: fallTick=%d land=%d charge=%.2f server fall=%.3f ground=%s sprint=%s charge=%.2f", ((fpc)object).fallTick, ((fpc)object).land, Float.valueOf(((fpc)object).charge), fpf2.fpj, fpf2.fpk, fpf2.fpl, Float.valueOf(fpf2.fpi)));
        }
        while ((object = fqv.peek()) != null) {
            fqv.poll();
            fpc fpc4 = DuelTest.ftt(((foo)object).fop);
            if (fpc4 == null) continue;
            fpc4.serverDamage += ((foo)object).foq;
        }
        while (!fqz.isEmpty() && fra - DuelTest.fqz.peekFirst().tick > 40 && l - DuelTest.fqz.peekFirst().nanos > 1000000000L) {
            fqz.pollFirst();
        }
    }

    private static double ftp(String string, double d) {
        return DuelTest.ftq(string, d, 0);
    }

    private static double ftq(String string, double d, int n) {
        String string2 = System.getenv(string);
        if (string2 == null) {
            return d;
        }
        String[] stringArray = string2.split(",");
        return Double.parseDouble(stringArray[Math.min(n, stringArray.length - 1)].trim());
    }

    private static void ftr(class_310 class_3102, class_1297 class_12972) {
        Object object;
        class_746 class_7462 = class_3102.field_1724;
        if (!fre || class_12972.method_5628() != frb || class_7462 == null) {
            return;
        }
        class_239 class_2392 = class_3102.field_1765;
        if (class_2392 instanceof class_3966 && (object = (class_3966)class_2392).method_17782() == class_12972) {
            class_2392 = class_12972.method_5829();
            fqj.add((object.method_17784().field_1351 - class_2392.field_1322) / (class_2392.field_1325 - class_2392.field_1322));
        }
        object = new fpc();
        object.phase = frf;
        object.tick = fra;
        object.nanos = System.nanoTime();
        object.charge = class_7462.method_7261(0.5f);
        object.sprintSent = ForwardKeyHold.serverSprinting(class_7462);
        object.clientCrit = object.charge > 0.9f && class_7462.field_6017 > 0.0 && !class_7462.method_24828() && !class_7462.method_6101() && !class_7462.method_5799() && !class_7462.method_6059(class_1294.field_5919) && !class_7462.method_5765() && !object.sprintSent;
        object.fallTick = frq;
        fry = fra;
        object.sinceKnock = fra - frt;
        object.midAirKnock = fru;
        fqy.add((fpc)object);
        fqz.add((fpc)object);
        ++frr;
        if (fsa >= 0 && !fsc) {
            fsc = true;
            if (fsb) {
                int n = fra - fsa;
                int[] nArray = fsv[object.phase];
                int n2 = n <= 0 ? 0 : (n == 1 ? 1 : (n == 2 ? 2 : (n <= 5 ? 3 : 4)));
                nArray[n2] = nArray[n2] + 1;
            }
            int n = object.phase;
            fsu[n] = fsu[n] + 1;
        }
    }

    private static fpc fts(int n) {
        fpc fpc2 = null;
        for (fpc fpc3 : fqz) {
            if (fpc3.tick > n || n - fpc3.tick > 8) continue;
            fpc2 = fpc3;
        }
        return fpc2;
    }

    private static fpc ftt(long l) {
        fpc fpc2 = null;
        for (fpc fpc3 : fqz) {
            if (fpc3.nanos > l || l - fpc3.nanos >= 400000000L) continue;
            fpc2 = fpc3;
        }
        return fpc2;
    }

    private static void ftu(int n) {
        if (n < 0 || fsn[n] == 0) {
            return;
        }
        if (frr > 0) {
            int n2 = n;
            fso[n2] = fso[n2] + 1;
        }
        if (frr > 1) {
            int n3 = n;
            fsp[n3] = fsp[n3] + 1;
        }
        if (frs) {
            int n4 = n;
            fsq[n4] = fsq[n4] + 1;
            if (frr > 0) {
                int n5 = n;
                fsr[n5] = fsr[n5] + 1;
            }
        }
    }

    private static void ftv(int n) {
        if (fsa >= 0 && fsb && !fsc && n >= 0) {
            int[] nArray = fsv[n];
            nArray[5] = nArray[5] + 1;
        }
        fsa = -1;
    }

    private static void ftw() {
        for (fpc fpc2 : fqy) {
            boolean bl;
            if (fpc2.sinceKnock < 0 || fpc2.sinceKnock > 15 || !(bl = fpc2.serverCrit != null ? fpc2.serverCrit : fpc2.seenCrit)) continue;
            int n = fpc2.phase;
            fsy[n] = fsy[n] + 1;
            int n2 = fpc2.phase;
            fsz[n2] = fsz[n2] + fpc2.sinceKnock;
            if (!fpc2.midAirKnock || fpc2.sinceKnock > 2) continue;
            int n3 = fpc2.phase;
            fta[n3] = fta[n3] + 1;
        }
    }

    private static void ftx(class_310 class_3102, class_746 class_7462, class_1297 class_12972, fot fot2, int n) {
        int n2;
        System.arraycopy(fsd, 0, fsd, 1, fsd.length - 1);
        DuelTest.fsd[0] = class_12972.method_73189();
        for (n2 = 1; n2 < fsd.length; ++n2) {
            if (fsd[n2] != null) continue;
            DuelTest.fsd[n2] = fsd[0];
        }
        if (--fsh <= 0) {
            fsh = 6 + fro.nextInt(14);
            fsf = (fro.nextFloat() - 0.5f) * 0.5f;
            fsg = 0.8f + fro.nextFloat() * 0.8f;
            fse = 0.7f + fro.nextFloat() * 0.6f;
        }
        n2 = 2 + fro.nextInt(2);
        class_243 class_2432 = fsd[n2];
        class_243 class_2433 = fsd[n2].method_1020(fsd[n2 + 1]);
        class_243 class_2434 = class_2432.method_1019(class_2433.method_1021((double)n2 * 0.6));
        class_243 class_2435 = class_7462.method_33571();
        double d = class_2434.field_1352 - class_2435.field_1352;
        double d2 = class_2434.field_1350 - class_2435.field_1350;
        double d3 = Math.max(0.001, Math.sqrt(d * d + d2 * d2));
        double d4 = -d2 / d3;
        double d5 = d / d3;
        double d6 = class_2434.field_1352 + d4 * (double)fsf - class_2435.field_1352;
        double d7 = class_2434.field_1350 + d5 * (double)fsf - class_2435.field_1350;
        double d8 = class_2434.field_1351 + (double)fsg - class_2435.field_1351;
        float f = (float)(class_3532.method_15349((double)d7, (double)d6) * 57.2957763671875) - 90.0f;
        float f2 = (float)(-(class_3532.method_15349((double)d8, (double)Math.sqrt(d6 * d6 + d7 * d7)) * 57.2957763671875));
        if (fsi > 0) {
            --fsi;
            f += fsk;
        } else if (--fsj <= 0) {
            fsj = 90 + fro.nextInt(120);
            fsi = 5 + fro.nextInt(10);
            fsk = (float)(fro.nextBoolean() ? 1 : -1) * (35.0f + fro.nextFloat() * 40.0f);
        }
        float f3 = fot2.foz * fse;
        float f4 = class_3532.method_15393((float)(f - class_7462.method_36454()));
        float f5 = f2 - class_7462.method_36455();
        float f6 = class_3532.method_15363((float)(f4 * 0.55f), (float)(-f3), (float)f3) + (float)fro.nextGaussian() * 0.35f;
        float f7 = class_3532.method_15363((float)(f5 * 0.35f), (float)(-f3 * 0.6f), (float)(f3 * 0.6f)) + (float)fro.nextGaussian() * 0.2f;
        class_7462.method_5872((double)(f6 / 0.15f), (double)(f7 / 0.15f));
        double d9 = Math.sqrt(f6 * f6 + f7 * f7);
        int n3 = n;
        ftb[n3] = ftb[n3] + d9;
        DuelTest.ftc[n] = Math.max(ftc[n], d9);
        int n4 = n;
        ftd[n4] = ftd[n4] + 1;
        fth.add(d9);
    }

    private static void fty(class_310 class_3102, class_746 class_7462, class_1297 class_12972, boolean bl) {
        double d = class_12972.method_23317() - class_7462.method_23317();
        double d2 = class_12972.method_23321() - class_7462.method_23321();
        double d3 = Math.sqrt(d * d + d2 * d2);
        if (--fsl <= 0) {
            fsl = 15 + fro.nextInt(30);
            fsm = fro.nextInt(3) - 1;
        }
        boolean bl2 = Math.abs(class_7462.method_23317() - fri) > 12.0 || Math.abs(class_7462.method_23321() - frk) > 12.0;
        class_3102.field_1690.field_1894.method_23481(d3 > 2.6);
        class_3102.field_1690.field_1881.method_23481(d3 < 1.4);
        class_3102.field_1690.field_1913.method_23481(!bl2 && fsm < 0);
        class_3102.field_1690.field_1849.method_23481(!bl2 && fsm > 0);
        class_3102.field_1690.field_1903.method_23481(bl);
    }

    private static void ftz(class_310 class_3102) {
        class_3102.field_1690.field_1894.method_23481(false);
        class_3102.field_1690.field_1881.method_23481(false);
        class_3102.field_1690.field_1913.method_23481(false);
        class_3102.field_1690.field_1849.method_23481(false);
        class_3102.field_1690.field_1903.method_23481(false);
    }

    private static class_1297 fua(class_310 class_3102) {
        Object object;
        if (frb >= 0 && (object = class_3102.field_1687.method_8469(frb)) != null) {
            return object;
        }
        for (class_1657 class_16572 : class_3102.field_1687.method_18456()) {
            if (!"FlowBot".equals(class_16572.method_7334().name())) continue;
            frb = class_16572.method_5628();
            return class_16572;
        }
        return null;
    }

    private static void fub(class_310 class_3102) {
        if (frg) {
            return;
        }
        frg = true;
        ClientTickEvents.START_CLIENT_TICK.register(DuelTest::fto);
        AttackEntityCallback.EVENT.register((class_16572, class_19372, class_12682, class_12972, class_39662) -> {
            if (class_19372.method_8608()) {
                DuelTest.ftr(class_310.method_1551(), class_12972);
                return class_1269.field_5811;
            }
            if (!fre || class_12972.method_5628() != TestBotSpawner.spawned || !class_16572.method_5667().equals(frd)) {
                return class_1269.field_5811;
            }
            float f = class_16572.method_7261(0.5f);
            boolean bl = f > 0.9f && class_16572.field_6017 > 0.0 && !class_16572.method_24828() && !class_16572.method_6101() && !class_16572.method_5799() && !class_16572.method_5765() && !class_16572.method_5624();
            fqu.add(new fpf(System.nanoTime(), bl, f, class_16572.field_6017, class_16572.method_24828(), class_16572.method_5624()));
            return class_1269.field_5811;
        });
        ServerLivingEntityEvents.AFTER_DAMAGE.register((class_13092, class_12822, f, f2, bl) -> {
            if (fre && class_13092.method_5628() == TestBotSpawner.spawned) {
                fqv.add(new foo(System.nanoTime(), f2));
            }
        });
        PacketHooks.listen(class_25962 -> {
            class_2743 class_27432;
            class_2616 class_26162;
            if (class_25962 instanceof class_2616 && (class_26162 = (class_2616)class_25962).method_11269() == frb && class_26162.method_11267() == 4) {
                fqw.add(fra);
            } else if (class_25962 instanceof class_2743 && (class_27432 = (class_2743)class_25962).method_11818() == frc && fre) {
                fqx.add(fra);
            }
        });
    }

    /*
     * Exception decompiling
     */
    private static void fuc() {
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

    private static void fud() {
        int n;
        StringBuilder stringBuilder = new StringBuilder("phase,tick,clientCrit,serverCrit,seenCrit,charge,fallTick,land,sinceKnock,midAirKnock,sprintSent,damage,serverDamage\n");
        int[] nArray = new int[8];
        for (int i = 0; i < fpq.length; ++i) {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            n = 0;
            double d2 = 0.0;
            int n9 = 0;
            double d3 = 0.0;
            int n10 = 0;
            double d4 = 0.0;
            double d5 = 0.0;
            float f = 1.0f;
            int[] nArray2 = new int[8];
            for (fpc fpc2 : fqy) {
                if (fpc2.phase != i) continue;
                ++n2;
                d5 += (double)fpc2.charge;
                f = Math.min(f, fpc2.charge);
                if (fpc2.clientCrit) {
                    ++n3;
                    int n11 = Math.min(7, fpc2.fallTick);
                    nArray2[n11] = nArray2[n11] + 1;
                }
                if (fpc2.serverCrit != null) {
                    ++n5;
                    if (fpc2.serverCrit.booleanValue()) {
                        ++n4;
                    } else if (fpc2.clientCrit) {
                        ++n;
                    }
                }
                if (fpc2.seenCrit) {
                    ++n6;
                }
                if (fpc2.clientCrit && fpc2.land >= 1 && fpc2.land <= 2) {
                    ++n7;
                    if (Boolean.FALSE.equals(fpc2.serverCrit)) {
                        ++n8;
                    }
                }
                if (fpc2.damage > 0.0f) {
                    if (fpc2.seenCrit) {
                        d2 += (double)fpc2.damage;
                        ++n9;
                    } else {
                        d3 += (double)fpc2.damage;
                        ++n10;
                    }
                }
                d4 += (double)fpc2.serverDamage;
                stringBuilder.append(String.format(Locale.ROOT, "%s,%d,%s,%s,%s,%.3f,%d,%d,%d,%s,%s,%.2f,%.2f%n", DuelTest.fpq[i].fou, fpc2.tick, fpc2.clientCrit, fpc2.serverCrit, fpc2.seenCrit, Float.valueOf(fpc2.charge), fpc2.fallTick, fpc2.land, fpc2.sinceKnock, fpc2.midAirKnock, fpc2.sprintSent, Float.valueOf(fpc2.damage), Float.valueOf(fpc2.serverDamage)));
            }
            nArray[0] = nArray[0] + n2;
            nArray[1] = nArray[1] + n3;
            nArray[2] = nArray[2] + n4;
            nArray[3] = nArray[3] + n6;
            nArray[4] = nArray[4] + n;
            double d6 = (double)DuelTest.fpq[i].fov / 20.0;
            System.out.println(String.format(Locale.ROOT, "duel %s: hits=%d (%.2f/s) crit client=%d seen=%d server=%d/%d rejected=%d late=%d lateFail=%d charge avg=%.3f min=%.3f", DuelTest.fpq[i].fou, n2, (double)n2 / d6, n3, n6, n4, n5, n, n7, n8, n2 == 0 ? 0.0 : d5 / (double)n2, Float.valueOf(f)));
            System.out.println(String.format(Locale.ROOT, "duel %s: damage crit avg=%.2f (%d) plain avg=%.2f (%d) server total=%.1f  crit fall tick hist=%s", DuelTest.fpq[i].fou, n9 == 0 ? 0.0 : d2 / (double)n9, n9, n10 == 0 ? 0.0 : d3 / (double)n10, n10, d4, Arrays.toString(Arrays.copyOfRange(nArray2, 1, 8))));
            if (DuelTest.fpq[i].fow) {
                System.out.println(String.format(Locale.ROOT, "duel %s: jumps=%d with hit=%d double=%d | jumps with a chance=%d hit=%d (%.0f%%)", DuelTest.fpq[i].fou, fsn[i], fso[i], fsp[i], fsq[i], fsr[i], fsq[i] == 0 ? 0.0 : 100.0 * (double)fsr[i] / (double)fsq[i]));
            }
            int[] nArray3 = fsv[i];
            System.out.println(String.format(Locale.ROOT, "duel %s: contacts=%d charged=%d hit=%d reaction(charged) 0t=%d 1t=%d 2t=%d 3-5t=%d 6+t=%d none=%d", DuelTest.fpq[i].fou, fss[i], fst[i], fsu[i], nArray3[0], nArray3[1], nArray3[2], nArray3[3], nArray3[4], nArray3[5]));
            System.out.println(String.format(Locale.ROOT, "duel %s: knockbacks=%d midair=%d recrits(<=15t)=%d avg delay=%.1f fast midair recrits=%d | bot hits=%d crits=%d", DuelTest.fpq[i].fou, fsw[i], fsx[i], fsy[i], fsy[i] == 0 ? 0.0 : (double)fsz[i] / (double)fsy[i], fta[i], ftf[i], ftg[i]));
            System.out.println(String.format(Locale.ROOT, "duel %s: aim turn avg=%.1f max=%.1f deg/tick, crosshair on bot %.0f%% of ticks", DuelTest.fpq[i].fou, ftd[i] == 0 ? 0.0 : ftb[i] / (double)ftd[i], ftc[i], ftd[i] == 0 ? 0.0 : 100.0 * (double)fte[i] / (double)ftd[i]));
        }
        fth.sort(Double::compare);
        double d7 = fth.isEmpty() ? 0.0 : fth.get((int)((double)fth.size() * 0.95));
        System.out.println(String.format(Locale.ROOT, "duel RESULT hits=%d crits client=%d seen=%d server=%d rejected=%d aim p95=%.1f deg/tick", nArray[0], nArray[1], nArray[3], nArray[2], nArray[4], d7));
        if (fpu != null) {
            fpy.sort(Double::compare);
            double d8 = fpy.isEmpty() ? 0.0 : fpy.get((int)((double)fpy.size() * 0.95));
            double d9 = fpy.isEmpty() ? 0.0 : fpy.get(fpy.size() - 1);
            double d10 = fpy.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println(String.format(Locale.ROOT, "duel AURA %s: sent turn avg=%.1f p95=%.1f max=%.1f deg/tick, camera away from bot %.0f%%, avg distance %.2f", fpu, d10, d8, d9, fqh == 0 ? 0.0 : 100.0 * (double)fqg / (double)fqh, fqh == 0 ? 0.0 : fqi / (double)fqh));
            if (fqk) {
                System.out.println(String.format(Locale.ROOT, "duel AURA OFF RESULT turned off %d times: snaps(>35/tick)=%d not back in 59 ticks=%d avg back in %.1f ticks, max turn after off %.1f deg/tick", fqp, fqq, fqr, fqp - fqr == 0 ? 0.0 : fqt / (double)(fqp - fqr), fqs));
            }
            fqj.sort(Double::compare);
            if (!fqj.isEmpty()) {
                n = fqj.size();
                System.out.println(String.format(Locale.ROOT, "duel AURA hit height (0 feet, 1 top): p10=%.2f median=%.2f p90=%.2f min=%.2f max=%.2f of %d", fqj.get(n / 10), fqj.get(n / 2), fqj.get(n * 9 / 10), fqj.get(0), fqj.get(n - 1), n));
            }
            System.out.println(String.format(Locale.ROOT, "duel AURA turns >20=%d >30=%d >40=%d of %d", fpy.stream().filter(d -> d > 20.0).count(), fpy.stream().filter(d -> d > 30.0).count(), fpy.stream().filter(d -> d > 40.0).count(), fpy.size()));
            DuelTest.ftl();
            StudioProfiles tiq2 = Aura.studioProfile();
            if (tiq2 == null && System.getenv("FLOW2_DUEL_AURA_REF") != null) {
                tiq2 = StudioProfiles.open(System.getenv("FLOW2_DUEL_AURA_REF"));
            }
            ArrayList<RecordingReader> arrayList = new ArrayList<RecordingReader>();
            if (tiq2 != null) {
                arrayList.addAll(tiq2.tapes());
            }
            for (String string : AimCompare.report(fpz, fqa, arrayList)) {
                System.out.println("duel AURA motion " + string);
            }
        }
        try {
            Path path = Path.of("flow2-duel.csv", new String[0]);
            Files.writeString(path, (CharSequence)stringBuilder.toString(), StandardCharsets.UTF_8, new OpenOption[0]);
            System.out.println("duel csv " + path.toAbsolutePath());
        }
        catch (IOException iOException) {
            System.out.println("duel csv failed " + iOException);
        }
    }

    private static fot[] fue() {
        String string = System.getenv("FLOW2_DUEL_ONLY");
        if (string == null) {
            return fpp;
        }
        ArrayList<fot> arrayList = new ArrayList<fot>();
        for (String string2 : string.split(",")) {
            for (fot fot2 : fpp) {
                if (!fot2.fou.equals(string2.trim())) continue;
                arrayList.add(fot2);
            }
        }
        return arrayList.toArray(new fot[0]);
    }

    private static void fuf(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    static {
        fqj = new ArrayList<Double>();
        fqk = System.getenv("FLOW2_DUEL_AURA_TOGGLE") != null;
        fql = -1;
        fqo = -1;
        fqu = new ConcurrentLinkedQueue();
        fqv = new ConcurrentLinkedQueue();
        fqw = new ConcurrentLinkedQueue();
        fqx = new ConcurrentLinkedQueue();
        fqy = new ArrayList<fpc>();
        fqz = new ArrayDeque();
        frb = -1;
        frc = -1;
        frf = -1;
        fro = new Random(17L);
        frp = true;
        frt = -1000;
        frv = -1.0f;
        frx = "";
        fry = -1;
        frz = 99;
        fsa = -1;
        fsd = new class_243[12];
        fse = 1.0f;
        fsg = 1.2f;
        fsj = 80;
        fsn = new int[8];
        fso = new int[8];
        fsp = new int[8];
        fsq = new int[8];
        fsr = new int[8];
        fss = new int[8];
        fst = new int[8];
        fsu = new int[8];
        fsv = new int[8][6];
        fsw = new int[8];
        fsx = new int[8];
        fsy = new int[8];
        fsz = new int[8];
        fta = new int[8];
        ftb = new double[8];
        ftc = new double[8];
        ftd = new int[8];
        fte = new int[8];
        ftf = new int[8];
        ftg = new int[8];
        fth = new ArrayList<Double>();
    }

    private static /* synthetic */ int qu(int n, int n2) {
        return n * n2 | 0xD48AE4F5;
    }

    private static /* synthetic */ int qv(int n, int n2) {
        return DuelTest.qu(n, n2) + n;
    }

    private static /* synthetic */ int qw(int n, int n2) {
        return (n ^ n2) + 1728271675;
    }
}

