/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1531
 *  net.minecraft.class_1542
 *  net.minecraft.class_1646
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1893
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2535
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_276
 *  net.minecraft.class_2940
 *  net.minecraft.class_2943
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_318
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3532
 *  net.minecraft.class_3730
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 *  net.minecraft.class_7924
 *  net.minecraft.class_8113$class_8123
 *  net.minecraft.class_8609
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 *  net.minecraft.server.MinecraftServer
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gdz;
import a.gec;
import a.Module;
import a.nfi;
import a.AutoMines;
import a.AutoMineController;
import a.BoolSetting;
import a.NumberSetting;
import a.Setting;
import a.TextSetting;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1646;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2535;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_276;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_318;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3532;
import net.minecraft.class_3730;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import net.minecraft.class_8113;
import net.minecraft.class_8609;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import net.minecraft.server.MinecraftServer;
import org.lwjgl.glfw.GLFW;

final class MineTest {
    private static final String geg = System.getenv().getOrDefault("FLOW2_MINE_ONLY", "hop");
    private static final boolean geh = System.getenv("FLOW2_MINE_TRACE") != null;
    private static final String gei = System.getenv().getOrDefault("FLOW2_MINE_DOZER", "look");
    private static volatile class_2338 gej;
    private static volatile class_2350 gek;
    private static final boolean gel;
    private static final int gem = 8;
    private static final int gen;
    private static double geo;
    private static double gep;
    private static int geq;
    private static int ger;
    private static int ges;
    private static class_1297 get;
    private static volatile int geu;
    private static int gev;
    private static volatile int gew;
    private static final List<String> gex;
    private static final int gey = 3;
    private static final List<gec> gez;
    private static final List<class_2338> gfa;
    private static final List<String> gfb;
    private static boolean gfc;
    private static boolean gfd;
    private static long gfe;
    private static gec gff;
    private static class_2338 gfg;
    private static gec gfh;
    private static long gfi;
    private static long gfj;
    private static int gfk;
    private static int gfl;
    private static int gfm;
    private static String gfn;
    private static class_2940<class_2561> gfo;
    private static int gfp;
    private static int gfq;
    private static float gfr;
    private static float gfs;
    private static boolean gft;
    private static final List<Double> gfu;
    private static final List<Double> gfv;
    private static float gfw;
    private static float gfx;
    private static boolean gfy;
    private static volatile long gfz;
    private static String gga;
    private static int ggb;
    private static boolean ggc;
    private static boolean ggd;
    private static boolean gge;
    private static int ggf;
    private static double ggg;
    private static long ggh;
    private static volatile int ggi;
    private static double ggj;
    private static /* synthetic */ long ggk;
    private static /* synthetic */ String ggl;

    private MineTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        Object object;
        Object object2;
        boolean bl;
        class_746 class_7462 = class_3102.field_1724;
        MineTest.ghc(class_3102);
        boolean bl2 = geg.equals("diamonds");
        boolean bl3 = bl = geg.equals("dig") || bl2 || gel;
        if (n == 1) {
            GLFW.glfwSetCursorPosCallback((long)class_3102.method_22683().method_4490(), (l, d, d2) -> {});
            MineTest.ghb(class_3102, "AimAssist", false);
            MineTest.ghb(class_3102, "FreeLook", false);
            MineTest.ghe(class_3102, "gamemode survival");
            MineTest.ghe(class_3102, "effect give @s saturation 1000 4 true");
            MineTest.ghe(class_3102, "effect give @s resistance 1000 4 true");
            MineTest.ghe(class_3102, "effect give @s night_vision 1000 0 true");
            MineTest.ghe(class_3102, "clear @s");
            MineTest.ghe(class_3102, "time set day");
            MineTest.ghe(class_3102, "gamerule doDaylightCycle false");
            MineTest.ghe(class_3102, "gamerule doMobSpawning false");
            class_3102.field_1690.method_42503().method_41748((Object)12);
        }
        if (n == 5) {
            object2 = class_7462.method_24515();
            gfn = class_7462.method_5477().getString();
            object = class_3102.method_1576();
            object.execute(() -> MineTest.lambda$tick$1((MinecraftServer)object, (class_2338)object2, bl));
        }
        if (n == 40) {
            object2 = class_3102.method_1576();
            object2.execute(() -> MineTest.lambda$tick$2((MinecraftServer)object2, bl));
        }
        if (n == 60) {
            class_7462.method_31548().method_61496(3);
        }
        if (!ggc && n >= 140 && class_7462 != null && MineTest.ggn(class_7462)) {
            ggc = true;
            object2 = Flow.getInstance().getModuleManager().getByName("AutoMine");
            nfi.solo = bl;
            nfi.anarchies = "101, 104, 102, 103";
            nfi.minMineMs = 15000L;
            nfi.maxMineMs = gel ? 110000L : (bl ? 75000L : 45000L);
            gev = class_7462.method_31548().method_18861(class_1802.field_8477);
            MineTest.ghb(class_3102, "AimAssist", false);
            MineTest.ghb(class_3102, "TriggerBot", false);
            MineTest.ghb(class_3102, "AutoTool", false);
            class_3102.method_1576().execute(() -> {
                long l = gfe;
                for (gec gec2 : gez) {
                    gec2.refreshAt += l;
                }
                gfd = true;
            });
            if (geh) {
                AutoMineController.trace = string -> System.out.println("dig " + string);
            }
            ((Module)object2).setEnabled(true);
            gfp = n;
            gfq = n + (gel ? 2000 : (bl ? 1700 : 4000));
            System.out.println("mine test: start " + geg);
        }
        if (ggc && n > gfp && class_7462 != null) {
            float f = class_7462.method_36454();
            float f2 = class_7462.method_36455();
            if (gft) {
                double d3 = class_3532.method_15393((float)(f - gfr));
                double d4 = f2 - gfs;
                double d5 = Math.sqrt(d3 * d3 + d4 * d4);
                gfu.add(d5);
                if (d5 > 35.0) {
                    String string2 = ((AutoMines)Flow.getInstance().getModuleManager().getByName("AutoMine")).debug();
                    System.out.println(String.format(Locale.ROOT, "mine big turn t=%.2f yaw %.1f->%.1f pitch %.1f->%.1f focus=" + class_3102.method_1569() + " %s pos=%s", (double)(n - gfp) / 20.0, Float.valueOf(gfr), Float.valueOf(f), Float.valueOf(gfs), Float.valueOf(f2), string2.substring(0, string2.indexOf(32)), class_7462.method_73189()) + " " + ((AutoMines)Flow.getInstance().getModuleManager().getByName("AutoMine")).action());
                }
            }
            gfr = f;
            gfs = f2;
            gft = true;
            AutoMines nfl2 = (AutoMines)Flow.getInstance().getModuleManager().getByName("AutoMine");
            String string3 = nfl2.debug();
            String string4 = string3.substring(0, string3.indexOf(32));
            if (!string4.equals(gga)) {
                if (gga.equals("MINE") && string4.equals("DECIDE") && ggj < 0.0) {
                    ggj = (double)(n - gfp) / 20.0;
                }
                gga = string4;
                System.out.println("mine test t=" + (double)(n - gfp) / 20.0 + "s " + string3);
            }
            if (string3.startsWith("WAIT") && !ggd || string3.startsWith("MINE") && !gge && n - gfp > 1300) {
                if (string3.startsWith("WAIT")) {
                    ggd = true;
                } else {
                    gge = true;
                }
                MineTest.ghd(class_3102, "automine-hud-" + (string3.startsWith("WAIT") ? "wait" : "mine"));
            }
            if ((n - gfp) % 200 == 0) {
                System.out.println("mine test t=" + (double)(n - gfp) / 20.0 + "s " + string3 + " pos=" + class_7462.method_24515().method_23854());
            }
        }
        if (n == gfq) {
            Module kfe2 = Flow.getInstance().getModuleManager().getByName("AutoMine");
            object = ((AutoMines)kfe2).debug();
            kfe2.setEnabled(false);
            gfd = false;
            MineTest.ggm(class_3102, (String)object, bl, bl2);
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ggm(class_310 class_3102, String string2, boolean bl, boolean bl2) {
        ArrayList<Double> arrayList;
        System.out.println("mine test end (dozer sim " + gei + "): " + string2);
        for (String object : gfb) {
            System.out.println("mine log " + object);
        }
        for (gec gec2 : gez) {
            System.out.println("mine " + gec2.id + ": refreshes=" + gec2.refreshes + " broken=" + gec2.mined + " ores=" + gec2.minedOres + " " + String.join((CharSequence)" | ", gec2.events));
        }
        System.out.println(String.format(Locale.ROOT, "mine first-mine ore rate: %.1f ores/min", (double)ggf * 60.0 / Math.max(1.0, ggg)));
        ArrayList<Double> arrayList2 = new ArrayList<Double>(gfu);
        arrayList2.sort(Double::compare);
        double d2 = arrayList2.isEmpty() ? 0.0 : (Double)arrayList2.get(arrayList2.size() - 1);
        double d3 = arrayList2.isEmpty() ? 0.0 : (Double)arrayList2.get((int)((double)arrayList2.size() * 0.95));
        System.out.println(String.format(Locale.ROOT, "mine turns (client ticks): p95 %.1f max %.1f deg/tick", d3, d2));
        List<Double> list = gfv;
        synchronized (list) {
            arrayList = new ArrayList<Double>(gfv);
        }
        arrayList.sort(Double::compare);
        double d4 = arrayList.isEmpty() ? 0.0 : (Double)arrayList.get(arrayList.size() - 1);
        double d5 = arrayList.isEmpty() ? 0.0 : (Double)arrayList.get((int)((double)arrayList.size() * 0.95));
        long l = arrayList.stream().filter(d -> d > 30.0).count();
        System.out.println(String.format(Locale.ROOT, "mine turns (server packets): n=%d p95 %.1f max %.1f deg/packet, >30: %d", arrayList.size(), d5, d4, l));
        d2 = d4;
        class_3218 class_32182 = class_3102.method_1576().method_30002();
        int n = 0;
        for (Object object : gfa) {
            if (class_32182.method_8320(object).method_26215()) continue;
            ++n;
        }
        MineTest.ggo(gfk == 0, "protected break attempts: " + gfk);
        MineTest.ggo(gfl == 0, "second /warp while teleporting: " + gfl);
        if (!bl) {
            MineTest.ggo(gfm == 4, "an104 tries " + gfm + " (want 1 + 3 retries)");
        }
        MineTest.ggo(n == gfa.size(), "decor ores left " + n + "/" + gfa.size());
        MineTest.ggo(d2 <= 118.0, "turn max " + d2);
        if (gel) {
            var18_18 = gez.get(0);
            int n2 = 289 * gen;
            int n3 = class_3102.field_1724 == null ? 0 : class_3102.field_1724.method_31548().method_18861(class_1802.field_8477) - gev;
            double d6 = ggj;
            System.out.println(String.format(Locale.ROOT, "mine sweep: %d of %d blocks broken, %d left, left the mine at %.1f s, %.1f blocks/s, diamonds %d in the mine, %d left in it, %d picked up, %d clicks (%.2f blocks a click), %d entity hits", ((gec)var18_18).mined, n2, geq, d6, (double)((gec)var18_18).mined / Math.max(1.0, d6 > 0.0 ? d6 : (double)(gfq - gfp) / 20.0), ger, ges, n3, gew, (double)((gec)var18_18).mined / (double)Math.max(1, gew), geu));
            MineTest.ggo(d6 > 0.0 && d6 < 75.0, "didn't leave the mine in time: " + d6);
            MineTest.ggo(ges >= 0 && ges <= 4, "diamonds left in the mine " + ges);
            MineTest.ggo(geu == 0, "hit the mob standing in the way " + geu + " times");
        } else if (bl2) {
            var18_18 = gez.get(0);
            System.out.println("mine diamonds: " + ((gec)var18_18).minedDiamonds + " diamonds, " + (((gec)var18_18).minedOres - ((gec)var18_18).minedDiamonds) + " other ores, deepest targeted y=" + ggi + " (top y=" + (((gec)var18_18).y0 - 1) + ", depth " + 3 + "), left the mine at " + ggj + " s");
            MineTest.ggo(((gec)var18_18).minedDiamonds >= 4, "diamonds mined " + ((gec)var18_18).minedDiamonds);
            MineTest.ggo(ggi >= ((gec)var18_18).y0 - 3, "dug below the depth limit: y=" + ggi);
            MineTest.ggo(ggj > 0.0 && ggj < 70.0, "didn't leave once the diamonds ran out: " + ggj);
        } else if (bl) {
            MineTest.ggo(MineTest.gez.get((int)0).minedOres >= 25, "ores mined " + MineTest.gez.get((int)0).minedOres);
        } else {
            Object object;
            var18_18 = gez.get(0);
            object = gez.get(1);
            MineTest.ggo(((gec)var18_18).minedOres >= 10, "101 ores " + ((gec)var18_18).minedOres);
            MineTest.ggo(object.minedOres >= 10, "102 ores " + object.minedOres);
            MineTest.ggo(((gec)var18_18).events.stream().anyMatch(string -> string.startsWith("refresh1 near")), "not at 101 on its refresh");
            MineTest.ggo(object.events.stream().anyMatch(string -> string.startsWith("refresh1 near")), "not at 102 on its refresh");
        }
        MineTest.ggo(string2.contains("thrown=") && !string2.contains("thrown=0"), "junk not thrown: " + string2);
        System.out.println("mine test " + (ggb == 0 ? "PASS" : "FAIL (" + ggb + ")"));
    }

    private static boolean ggn(class_746 class_7462) {
        for (int i = 0; i < 36; ++i) {
            if (!class_7462.method_31548().method_5438(i).method_31574(class_1802.field_22024)) continue;
            return true;
        }
        return false;
    }

    private static void ggo(boolean bl, String string) {
        if (!bl) {
            ++ggb;
            System.out.println("mine test check failed: " + string);
        }
    }

    private static void ggp(MinecraftServer minecraftServer, class_2338 class_23383, boolean bl) {
        class_1646 class_16462;
        class_3218 class_32182 = minecraftServer.method_30002();
        gez.clear();
        gfa.clear();
        int n = class_23383.method_10264() + 10;
        gfg = new class_2338(class_23383.method_10263() + 100, class_23383.method_10264(), class_23383.method_10260() - 250);
        for (int i = (gfg.method_10263() >> 4) - 2; i <= (gfg.method_10263() >> 4) + 2; ++i) {
            for (int j = (gfg.method_10260() >> 4) - 2; j <= (gfg.method_10260() >> 4) + 2; ++j) {
                class_32182.method_8497(i, j);
            }
        }
        if (gel) {
            gez.add(new gec(0, class_23383.method_10263(), class_23383.method_10260() + 40, n, false, 8000L, 8000L, "Обычная"));
        } else if (bl) {
            gez.add(new gec(0, class_23383.method_10263(), class_23383.method_10260() + 40, n, false, 120L, 1800L, "Обычная", "Мифическая"));
        } else {
            gez.add(new gec(101, class_23383.method_10263(), class_23383.method_10260() + 40, n, false, 1000L, 2000L, "Мифическая", "Обычная"));
            gez.add(new gec(102, class_23383.method_10263() + 220, class_23383.method_10260() + 40, n, true, 2400L, 2400L, "Легендарная", "Обычная"));
            gez.add(new gec(103, class_23383.method_10263() + 440, class_23383.method_10260() + 40, n, false, 4000L, 2000L, "Обычная", "Мифическая"));
        }
        for (gec gec2 : gez) {
            MineTest.ggv(class_32182, gec2, class_23383.method_10264());
        }
        if (gel) {
            class_16462 = (class_1646)class_1299.field_6077.method_5883((class_1937)class_32182, class_3730.field_16462);
            gec gec3 = gez.get(0);
            class_16462.method_5808((double)gec3.cx + 0.5, (double)gec3.y0, (double)gec3.cz + 0.5, 0.0f, 0.0f);
            class_16462.method_5977(true);
            class_16462.method_5684(true);
            class_16462.method_5803(true);
            class_32182.method_8649((class_1297)class_16462);
            get = class_16462;
        }
        if (!gfc) {
            gfc = true;
            ServerTickEvents.END_SERVER_TICK.register(MineTest::ggt);
            PlayerBlockBreakEvents.BEFORE.register((class_19372, class_16572, class_23382, class_26802, class_25862) -> {
                if (!gfd || class_19372.method_8608()) {
                    return true;
                }
                for (gec gec2 : gez) {
                    if (!gec2.inMine(class_23382)) continue;
                    return true;
                }
                ++gfk;
                gfb.add("protected " + class_23382.method_23854() + " " + class_26802.method_26204());
                return false;
            });
            PlayerBlockBreakEvents.AFTER.register((class_19372, class_16572, class_23382, class_26802, class_25862) -> {
                if (!gfd || class_19372.method_8608() || !(class_16572 instanceof class_3222)) {
                    return;
                }
                class_3222 class_32222 = (class_3222)class_16572;
                for (gec gec2 : gez) {
                    if (!gec2.inMine(class_23382)) continue;
                    if (geh) {
                        System.out.println("srv broke " + class_23382.method_23854() + " t=" + gfe);
                    }
                    ggi = Math.min(ggi, class_23382.method_10264());
                    MineTest.ggr(gec2, class_26802);
                    MineTest.ggs((class_3218)class_19372, class_32222, gec2, class_23382);
                }
            });
        }
        class_16462 = minecraftServer.method_3734().method_9235();
        for (gec gec4 : gez) {
            class_16462.register((LiteralArgumentBuilder)class_2170.method_9247((String)("an" + gec4.id)).executes(commandContext -> {
                class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
                if (gff == gec4) {
                    class_32222.method_64398((class_2561)class_2561.method_43470((String)"§cВы уже находитесь на этом сервере!"));
                    return 1;
                }
                gfh = gec4;
                gfi = gfe + 25L;
                return 1;
            }));
        }
        class_16462.register((LiteralArgumentBuilder)class_2170.method_9247((String)"warp").then(class_2170.method_9247((String)"mine").executes(commandContext -> {
            class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
            if (gfj >= 0L) {
                ++gfl;
                gfb.add("t=" + (double)gfe / 20.0 + " SECOND WARP while teleporting");
            }
            gfj = gfe + 140L;
            class_32222.method_64398((class_2561)class_2561.method_43470((String)"§6⚡ §fПеремещение на варп §emine§f."));
            class_32222.method_64398((class_2561)class_2561.method_43470((String)"§c[⚡] Телепортация! §fПеремещение через §a7 сек"));
            class_32222.method_64398((class_2561)class_2561.method_43470((String)"§c[⚡] Внимание! §fНе получайте §cурон §fот игроков!"));
            class_32222.method_64398((class_2561)class_2561.method_43470((String)"§c        [Отменить телепорт]"));
            return 1;
        })));
        class_16462.register((LiteralArgumentBuilder)class_2170.method_9247((String)"an104").executes(commandContext -> {
            ++gfm;
            ((class_2168)commandContext.getSource()).method_9207().method_64398((class_2561)class_2561.method_43470((String)"§cСервер на который Вы пытаетесь подключиться в данный момент недоступен!"));
            return 1;
        }));
        class_3222 class_32222 = minecraftServer.method_3760().method_14566(gfn);
        if (class_32222 != null) {
            minecraftServer.method_3760().method_14576(class_32222);
            MineTest.ggq(minecraftServer, class_32222);
        }
    }

    private static void ggq(MinecraftServer minecraftServer, class_3222 class_32222) {
        try {
            class_2535 class_25352 = null;
            for (Field field : class_8609.class.getDeclaredFields()) {
                if (field.getType() != class_2535.class) continue;
                field.setAccessible(true);
                class_25352 = (class_2535)field.get(class_32222.field_13987);
            }
            Channel channel = null;
            for (Field field : class_2535.class.getDeclaredFields()) {
                if (!Channel.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                channel = (Channel)field.get(class_25352);
            }
            channel.pipeline().addBefore("packet_handler", "flow2_mine_recorder", (ChannelHandler)new gdz(minecraftServer));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    private static void ggr(gec gec2, class_2680 class_26802) {
        ++gec2.mined;
        String string = class_7923.field_41175.method_10221((Object)class_26802.method_26204()).method_12832();
        if (string.endsWith("diamond_ore")) {
            ++gec2.minedDiamonds;
        }
        if (string.endsWith("_ore")) {
            ++gec2.minedOres;
            if (gec2 == gez.get(0) && gec2.refreshes == 1) {
                ++ggf;
                if (ggh < 0L) {
                    ggh = gfe;
                }
                ggg = (double)(gfe - ggh) / 20.0;
            }
        }
    }

    private static void ggs(class_3218 class_32182, class_3222 class_32222, gec gec2, class_2338 class_23382) {
        class_2350.class_2351 class_23512;
        boolean bl;
        if (gei.equals("none")) {
            return;
        }
        float f = class_32222.method_36455();
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        float f2 = class_3532.method_15393((float)class_32222.method_36454());
        boolean bl2 = bl = Math.abs(f2) < 45.0f || Math.abs(f2) > 135.0f;
        class_2350.class_2351 class_23513 = Math.abs(f) > 50.0f ? class_2350.class_2351.field_11052 : (class_23512 = bl ? class_2350.class_2351.field_11051 : class_2350.class_2351.field_11048);
        if (gei.equals("face") && class_23382.equals((Object)gej) && gek != null) {
            class_23512 = gek.method_10166();
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0) continue;
                if (class_23512 == class_2350.class_2351.field_11052) {
                    arrayList.add(class_23382.method_10069(i, 0, j));
                    continue;
                }
                if (class_23512 == class_2350.class_2351.field_11051) {
                    arrayList.add(class_23382.method_10069(i, j, 0));
                    continue;
                }
                arrayList.add(class_23382.method_10069(0, j, i));
            }
        }
        for (class_2338 class_23383 : arrayList) {
            class_2680 class_26802 = class_32182.method_8320(class_23383);
            if (!gec2.inMine(class_23383) || class_26802.method_26215()) continue;
            for (class_1799 class_17992 : class_2248.method_9609((class_2680)class_26802, (class_3218)class_32182, (class_2338)class_23383, null, (class_1297)class_32222, (class_1799)class_32222.method_6047())) {
                class_32222.method_31548().method_7394(class_17992);
            }
            class_32182.method_8652(class_23383, class_2246.field_10124.method_9564(), 3);
            MineTest.ggr(gec2, class_26802);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ggt(MinecraftServer minecraftServer) {
        class_3222 class_32222;
        if (!gfd && gez.isEmpty()) {
            return;
        }
        class_3218 class_32182 = minecraftServer.method_30002();
        class_3222 class_32223 = class_32222 = gfn == null ? null : minecraftServer.method_3760().method_14566(gfn);
        if (gfi >= 0L && ++gfe >= gfi && class_32222 != null) {
            gfi = -1L;
            gff = gfh;
            MineTest.ggz(minecraftServer, MineTest.gff.spawn, 0.0f, 0.0f);
            gfb.add("t=" + (double)gfe / 20.0 + " joined " + MineTest.gff.id);
        }
        if (gfj >= 0L && gfe >= gfj && class_32222 != null) {
            gfj = -1L;
            if (gff != null) {
                MineTest.ggz(minecraftServer, MineTest.gff.warp, 180.0f, 15.0f);
                class_32222.method_6092(new class_1293(class_1294.field_5919, 50, 0));
                gfb.add("t=" + (double)gfe / 20.0 + " warped " + MineTest.gff.id);
            }
        }
        if (!gfd) {
            return;
        }
        if (gel && gfe % 10L == 0L && !gez.isEmpty()) {
            gec gec2 = gez.get(0);
            if (gep < 0.0 && gec2.mined > 0) {
                gep = (double)gfe / 20.0;
            }
            int n = 0;
            int n2 = 0;
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = gec2.cx - 8; i <= gec2.cx + 8; ++i) {
                for (int j = gec2.cz - 8; j <= gec2.cz + 8; ++j) {
                    for (int k = gec2.y0 - gen; k <= gec2.y0 - 1; ++k) {
                        class_2680 class_26802 = class_32182.method_8320(new class_2338(i, k, j));
                        if (class_26802.method_27852(class_2246.field_10442)) {
                            ++n2;
                        }
                        if (class_26802.method_26215()) continue;
                        ++n;
                        if (arrayList.size() >= 80) continue;
                        arrayList.add(i - gec2.cx + "," + (k - gec2.y0) + "," + (j - gec2.cz));
                    }
                }
            }
            class_243 class_2432 = gex;
            synchronized (class_2432) {
                gex.clear();
                gex.addAll(arrayList);
            }
            geq = n;
            ges = n2;
            if (get != null && class_32222 != null && gfe % 40L == 0L) {
                class_2432 = class_32222.method_5720().method_18805(1.0, 0.0, 1.0).method_1029();
                get.method_5808(class_32222.method_23317() + class_2432.field_1352 * 1.6, class_32222.method_23318(), class_32222.method_23321() + class_2432.field_1350 * 1.6, 0.0f, 0.0f);
            }
            int n3 = 289 * gen;
            if (geo < 0.0 && n <= n3 / 50) {
                geo = (double)gfe / 20.0;
                gfb.add(String.format(Locale.ROOT, "cleared at %.1f s (%d left)", geo, n));
            }
            if (gfe % 100L == 0L) {
                System.out.println("mine sweep t=" + (double)gfe / 20.0 + " left=" + n + " broken=" + gec2.mined);
            }
        }
        for (gec gec3 : gez) {
            if (gfe >= gec3.refreshAt) {
                gec3.refreshAt += gec3.period;
                ++gec3.tierAt;
                ++gec3.refreshes;
                MineTest.ggw(class_32182, gec3, new Random((long)gec3.id * 31L + (long)gec3.refreshes), 0.0);
                String string = class_32222 != null && class_32222.method_24515().method_19771((class_2382)gec3.warp, 30.0) ? "near" : "away";
                gec3.events.add("refresh" + gec3.refreshes + " " + string + " t=" + (double)gfe / 20.0);
            }
            if (gfe % 20L == 0L) {
                MineTest.ggx(gec3);
            }
            if (class_32222 == null || gfe % 2L != 0L) continue;
            MineTest.ggu(class_32182, class_32222, gec3);
        }
    }

    private static void ggu(class_3218 class_32182, class_3222 class_32222, gec gec2) {
        class_238 class_2383 = new class_238((double)(gec2.cx - 8 - 2), (double)(gec2.y0 - gen - 2), (double)(gec2.cz - 8 - 2), (double)(gec2.cx + 8 + 3), (double)(gec2.y0 + 4), (double)(gec2.cz + 8 + 3));
        for (class_1542 class_15423 : class_32182.method_8390(class_1542.class, class_2383, class_15422 -> class_15422.method_24921() == null)) {
            class_1799 class_17992 = class_15423.method_6983().method_7972();
            class_32222.method_31548().method_7394(class_17992);
            if (class_17992.method_7960()) {
                class_15423.method_31472();
                continue;
            }
            class_15423.method_6979(class_17992);
        }
    }

    private static void ggv(class_3218 class_32182, gec gec2, int n) {
        class_2338[] class_2338Array;
        class_2680 class_26802;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        for (n6 = gec2.cx - 40 >> 4; n6 <= gec2.cx + 40 >> 4; ++n6) {
            for (n5 = gec2.cz - 140 >> 4; n5 <= gec2.cz + 40 >> 4; ++n5) {
                class_32182.method_8497(n6, n5);
            }
        }
        for (n6 = gec2.cx - 8 - 6 >> 4; n6 <= gec2.cx + 8 + 6 >> 4; ++n6) {
            for (n5 = gec2.cz - 8 - 6 >> 4; n5 <= gec2.cz + 8 + 6 >> 4; ++n5) {
                class_32182.method_17988(n6, n5, true);
            }
        }
        n6 = 12;
        for (n5 = gec2.cx - n6; n5 <= gec2.cx + n6; ++n5) {
            for (n4 = gec2.cz - n6; n4 <= gec2.cz + n6; ++n4) {
                for (n3 = gec2.y0 - gen - 1; n3 <= gec2.y0 + 5; ++n3) {
                    n2 = Math.abs(n5 - gec2.cx) == n6 || Math.abs(n4 - gec2.cz) == n6 ? 1 : 0;
                    class_26802 = class_2246.field_10124.method_9564();
                    if (n3 < gec2.y0) {
                        class_26802 = class_2246.field_10056.method_9564();
                    } else if (n2 != 0 && n3 <= gec2.y0 + 2 && (n4 != gec2.cz + n6 || Math.abs(n5 - gec2.cx) > 1)) {
                        class_26802 = class_2246.field_10056.method_9564();
                    }
                    class_32182.method_8652(new class_2338(n5, n3, n4), class_26802, 3);
                }
            }
        }
        MineTest.ggw(class_32182, gec2, new Random(gec2.id), gel ? 0.0 : 0.55);
        if (gel) {
            ger = 0;
            for (n5 = gec2.cx - 8; n5 <= gec2.cx + 8; ++n5) {
                for (n4 = gec2.cz - 8; n4 <= gec2.cz + 8; ++n4) {
                    for (n3 = gec2.y0 - gen; n3 <= gec2.y0 - 1; ++n3) {
                        if (!class_32182.method_8320(new class_2338(n5, n3, n4)).method_27852(class_2246.field_10442)) continue;
                        ++ger;
                    }
                }
            }
        }
        class_2338[] class_2338Array2 = class_2338Array = new class_2338[]{new class_2338(gec2.cx - 8 - 2, gec2.y0 - 1, gec2.cz), new class_2338(gec2.cx + 8 + 2, gec2.y0 - 1, gec2.cz + 2), new class_2338(gec2.cx, gec2.y0 - 1, gec2.cz - 8 - 2), new class_2338(gec2.cx + 3, gec2.y0 + 1, gec2.cz - n6), new class_2338(gec2.cx - 8 - 1, gec2.y0 - 2, gec2.cz - 3)};
        n3 = class_2338Array2.length;
        for (n2 = 0; n2 < n3; ++n2) {
            class_26802 = class_2338Array2[n2];
            class_32182.method_8652((class_2338)class_26802, class_2246.field_10442.method_9564(), 3);
            gfa.add((class_2338)class_26802);
        }
        gec2.warp = new class_2338(gec2.cx, gec2.y0, gec2.cz + 8 + 2);
        class_2338 class_23382 = gec2.spawn = gec2.id == 101 || gec2.id == 0 ? new class_2338(gec2.cx, n, gec2.cz - 100) : new class_2338(gec2.cx + 3, gec2.y0, gec2.cz + 8 + 4 + 18);
        if (gec2.id != 101 && gec2.id != 0) {
            for (int i = gec2.spawn.method_10263() - 3; i <= gec2.spawn.method_10263() + 3; ++i) {
                for (n3 = gec2.spawn.method_10260() - 3; n3 <= gec2.spawn.method_10260() + 3; ++n3) {
                    class_32182.method_8652(new class_2338(i, gec2.y0 - 1, n3), class_2246.field_10566.method_9564(), 3);
                }
            }
        }
        double d = (double)gec2.cx + 0.5;
        double d2 = (double)gec2.y0 + 1.6;
        double d3 = (double)(gec2.cz + 8) - 0.5;
        if (gec2.armor) {
            for (int i = 0; i < 4; ++i) {
                class_1531 class_15312 = new class_1531((class_1937)class_32182, d, d2 + 0.27 * (double)(3 - i), d3);
                class_15312.method_5648(true);
                class_15312.method_5875(true);
                class_15312.method_5880(true);
                try {
                    Method method = class_1531.class.getDeclaredMethod("setMarker", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke((Object)class_15312, true);
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    throw new RuntimeException(reflectiveOperationException);
                }
                class_32182.method_8649((class_1297)class_15312);
                gec2.labels.add((class_1297)class_15312);
            }
        } else {
            class_8113.class_8123 class_81232 = (class_8113.class_8123)class_1299.field_42457.method_5883((class_1937)class_32182, class_3730.field_16462);
            class_81232.method_5808(d, d2, d3, 0.0f, 0.0f);
            class_32182.method_8649((class_1297)class_81232);
            gec2.labels.add((class_1297)class_81232);
        }
        MineTest.ggx(gec2);
    }

    private static void ggw(class_3218 class_32182, gec gec2, Random random, double d) {
        class_2248[] class_2248Array = new class_2248[]{class_2246.field_10418, class_2246.field_10212, class_2246.field_10571, class_2246.field_10080, class_2246.field_10090, class_2246.field_10442};
        double[] dArray = new double[]{0.04, 0.035, 0.025, 0.02, 0.018, 0.012};
        for (int i = gec2.cx - 8; i <= gec2.cx + 8; ++i) {
            for (int j = gec2.cz - 8; j <= gec2.cz + 8; ++j) {
                for (int k = gec2.y0 - gen; k <= gec2.y0 - 1; ++k) {
                    class_2680 class_26802;
                    double d2 = (double)(gec2.y0 - 1 - k) / (double)gen;
                    if (d > 0.0 && random.nextDouble() < d * (1.0 - d2)) {
                        class_26802 = class_2246.field_10124.method_9564();
                    } else {
                        double d3 = random.nextDouble();
                        class_2248 class_22482 = null;
                        double d4 = 0.0;
                        for (int i2 = 0; i2 < class_2248Array.length; ++i2) {
                            if (!(d3 < (d4 += dArray[i2]))) continue;
                            class_22482 = class_2248Array[i2];
                            break;
                        }
                        if (class_22482 == null) {
                            double d5 = random.nextDouble();
                            class_22482 = d5 < 0.35 ? class_2246.field_10474 : (d5 < 0.68 ? class_2246.field_10445 : class_2246.field_10508);
                        }
                        class_26802 = class_22482.method_9564();
                    }
                    class_32182.method_8652(new class_2338(i, k, j), class_26802, 3);
                }
            }
        }
    }

    private static void ggx(gec gec2) {
        long l = Math.max(0L, gec2.refreshAt - gfe);
        if (!gfd) {
            l = gec2.refreshAt;
        }
        long l2 = (l + 19L) / 20L;
        String string = String.format(Locale.ROOT, "%02d:%02d", l2 / 60L, l2 % 60L);
        CharSequence[] charSequenceArray = new String[]{"§6⚒ Авто-Шахта ⚒", "§fСледующая: §d" + gec2.tier(), "§fОбновление через:", "§6" + string};
        if (gec2.armor) {
            for (int i = 0; i < 4 && i < gec2.labels.size(); ++i) {
                gec2.labels.get(i).method_5665((class_2561)class_2561.method_43470((String)charSequenceArray[i]));
            }
        } else if (!gec2.labels.isEmpty()) {
            MineTest.ggy((class_8113.class_8123)gec2.labels.get(0), (class_2561)class_2561.method_43470((String)String.join((CharSequence)"\n", charSequenceArray)));
        }
    }

    private static void ggy(class_8113.class_8123 class_81232, class_2561 class_25612) {
        if (gfo == null) {
            for (Field field : class_8113.class_8123.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != class_2940.class) continue;
                try {
                    field.setAccessible(true);
                    class_2940 class_29402 = (class_2940)field.get(null);
                    if (class_29402.comp_2328() != class_2943.field_13317) continue;
                    gfo = class_29402;
                    break;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    throw new RuntimeException(reflectiveOperationException);
                }
            }
        }
        class_81232.method_5841().method_12778(gfo, (Object)class_25612);
    }

    private static void ggz(MinecraftServer minecraftServer, class_2338 class_23382, float f, float f2) {
        gfy = false;
        gfz = gfe + 20L;
        minecraftServer.method_3734().method_44252(minecraftServer.method_3739(), String.format(Locale.ROOT, "tp %s %.1f %d %.1f %.0f %.0f", gfn, (double)class_23382.method_10263() + 0.5, class_23382.method_10264(), (double)class_23382.method_10260() + 0.5, Float.valueOf(f), Float.valueOf(f2)));
    }

    private static void gha(Module kfe2, String string, Object object) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            if (vmo2 instanceof BoolSetting) {
                BoolSetting vkl2 = (BoolSetting)vmo2;
                vkl2.set((Boolean)object);
                continue;
            }
            if (vmo2 instanceof NumberSetting) {
                NumberSetting vmc2 = (NumberSetting)vmo2;
                vmc2.set(((Number)object).doubleValue());
                continue;
            }
            if (!(vmo2 instanceof TextSetting)) continue;
            TextSetting vmu2 = (TextSetting)vmo2;
            vmu2.set((String)object);
        }
    }

    private static void ghb(class_310 class_3102, String string, boolean bl) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
    }

    private static void ghc(class_310 class_3102) throws Exception {
        for (Field field : class_312.class.getDeclaredFields()) {
            if (!field.getName().equals("cursorLocked")) continue;
            field.setAccessible(true);
            field.setBoolean(class_3102.field_1729, true);
        }
    }

    private static void ghd(class_310 class_3102, String string) {
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static void ghe(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static /* synthetic */ void lambda$tick$2(MinecraftServer minecraftServer, boolean bl) {
        int n;
        class_3222 class_32222 = minecraftServer.method_3760().method_14566(gfn);
        class_1799 class_17992 = new class_1799((class_1935)class_1802.field_22024);
        class_17992.method_7978((class_6880)minecraftServer.method_30611().method_30530(class_7924.field_41265).method_46747(class_1893.field_9131), 10);
        class_17992.method_57379(class_9334.field_49632, (Object)new class_9290(List.of(class_2561.method_43470((String)"§7Бульдозер II"), class_2561.method_43470((String)"§7Магнит I"))));
        class_32222.method_31548().method_5447(3, new class_1799((class_1935)class_1802.field_8802));
        class_32222.method_31548().method_5447(20, class_17992);
        for (n = 9; n < 36; ++n) {
            if (n == 20 || n == 35) continue;
            class_32222.method_31548().method_5447(n, new class_1799((class_1935)class_1802.field_20412, 64));
        }
        for (n = 5; n < 9; ++n) {
            class_32222.method_31548().method_5447(n, new class_1799((class_1935)class_1802.field_20394, 64));
        }
        gec gec2 = gez.get(0);
        class_2338 class_23382 = bl ? gec2.warp : gfg;
        MineTest.ggz(minecraftServer, class_23382, 180.0f, 10.0f);
        gff = bl ? gec2 : null;
    }

    private static /* synthetic */ void lambda$tick$1(MinecraftServer minecraftServer, class_2338 class_23382, boolean bl) {
        MineTest.ggp(minecraftServer, class_23382, bl);
    }

    static {
        gel = geg.equals("sweep");
        gen = gel ? 10 : 6;
        geo = -1.0;
        gep = -1.0;
        geq = -1;
        ges = -1;
        gev = -1;
        gex = new ArrayList<String>();
        gez = new ArrayList<gec>();
        gfa = new ArrayList<class_2338>();
        gfb = new ArrayList<String>();
        gfi = -1L;
        gfj = -1L;
        gfu = new ArrayList<Double>();
        gfv = Collections.synchronizedList(new ArrayList());
        gga = "";
        ggh = -1L;
        ggi = Integer.MAX_VALUE;
        ggj = -1.0;
    }

    private static /* synthetic */ int tq(int n, int n2) {
        return n - n2 | 0xD2BC6923;
    }
}

