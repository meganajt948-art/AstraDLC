/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.minecraft.class_1132
 *  net.minecraft.class_1263
 *  net.minecraft.class_1277
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 *  net.minecraft.class_155
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1707
 *  net.minecraft.class_1714
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1893
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2374
 *  net.minecraft.class_2378
 *  net.minecraft.class_238
 *  net.minecraft.class_2551
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2625
 *  net.minecraft.class_2680
 *  net.minecraft.class_276
 *  net.minecraft.class_2769
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_318
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3264
 *  net.minecraft.class_3908
 *  net.minecraft.class_3917
 *  net.minecraft.class_5218
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  net.minecraft.class_747
 *  net.minecraft.class_7923
 *  net.minecraft.class_7924
 *  net.minecraft.class_8242
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 *  net.minecraft.server.MinecraftServer
 */
package a;

import a.fdt;
import a.Module;
import a.nfi;
import a.AutoMines;
import a.Box3;
import a.BuyerSeller;
import a.AutoMineController;
import a.TrackingError;
import a.MineTools;
import a.InventoryCounter;
import a.StorageRun;
import a.AimModel;
import a.AimBrain;
import a.BoolSetting;
import a.NumberSetting;
import a.Setting;
import a.TextSetting;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.class_1132;
import net.minecraft.class_1263;
import net.minecraft.class_1277;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_155;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1707;
import net.minecraft.class_1714;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_2378;
import net.minecraft.class_238;
import net.minecraft.class_2551;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2625;
import net.minecraft.class_2680;
import net.minecraft.class_276;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_318;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3264;
import net.minecraft.class_3908;
import net.minecraft.class_3917;
import net.minecraft.class_5218;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import net.minecraft.class_747;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import net.minecraft.class_8242;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import net.minecraft.server.MinecraftServer;

final class BaseFarmTest {
    private static final String fdy = System.getenv().getOrDefault("FLOW2_BASE_ONLY", "layout,base,buyer,trap");
    private static String fdz;
    private static class_2338 fea;
    private static class_2338 feb;
    private static class_2338 fec;
    private static class_2338 fed;
    private static class_2338 fee;
    private static class_2338 fef;
    private static class_2338 feg;
    private static long feh;
    private static long fei;
    private static long fej;
    private static int fek;
    private static int fel;
    private static int fem;
    private static boolean fen;
    private static int feo;
    private static final List<String> fep;
    private static final MineTools feq;
    private static boolean fer;
    private static BuyerSeller fes;
    private static AutoMineController fet;
    private static final AimBrain feu;
    private static final TrackingError fev;
    private static boolean few;
    private static class_2338 fex;
    private static int fey;
    private static volatile boolean fez;
    private static volatile boolean ffa;
    private static volatile long ffb;
    private static final List<class_1792> ffc;
    private static /* synthetic */ int ffd;
    private static /* synthetic */ boolean ffe;

    private BaseFarmTest() {
    }

    static boolean tick(class_310 class_3103, int n) throws Exception {
        Object object2;
        class_746 class_7462 = class_3103.field_1724;
        BaseFarmTest.ffx(class_3103);
        if (n == 1) {
            if (System.getenv("FLOW2_MINE_TRACE") != null) {
                StorageRun.trace = string -> System.out.println("stash " + string);
            }
            BaseFarmTest.ffw("AimAssist", false);
            BaseFarmTest.ffw("FreeLook", false);
            BaseFarmTest.ffw("AutoTotem", false);
            BaseFarmTest.ffw("AutoTool", false);
            BaseFarmTest.ffz(class_3103, "gamemode survival");
            BaseFarmTest.ffz(class_3103, "effect give @s resistance 1000 4 true");
            BaseFarmTest.ffz(class_3103, "effect give @s night_vision 1000 0 true");
            BaseFarmTest.ffz(class_3103, "time set day");
            BaseFarmTest.ffz(class_3103, "gamerule doDaylightCycle false");
            BaseFarmTest.ffz(class_3103, "gamerule doMobSpawning false");
            BaseFarmTest.ffz(class_3103, "clear @s");
            if (!fen) {
                fen = true;
                ClientTickEvents.START_CLIENT_TICK.register(class_3102 -> {
                    if (class_3102.field_1724 != null && fel == 11 && fem % 20 == 0 && System.getenv("FLOW2_MINE_TRACE") != null) {
                        System.out.println("base test start-tick: use=" + class_3102.field_1690.field_1904.method_1434() + " screen=" + class_3102.field_1755 + " cooldown=" + class_3102.field_1724.method_7357().method_7904(class_3102.field_1724.method_6047()));
                    }
                    if (fer && class_3102.field_1724 != null) {
                        feq.startTick(class_3102);
                    }
                    if (few && class_3102.field_1724 != null) {
                        feu.newTick();
                        fet.startTick(class_3102, class_3102.field_1724);
                    }
                });
            }
        }
        if (n == 5) {
            fdz = class_7462.method_5477().getString();
            object2 = class_7462.method_24515();
            class_1132 object3 = class_3103.method_1576();
            object3.execute(() -> BaseFarmTest.lambda$tick$2((MinecraftServer)object3, (class_2338)object2));
        }
        if (n == 30) {
            BaseFarmTest.ffz(class_3103, "reload");
        }
        if (n >= 40 && !fez && n % 20 == 0) {
            object2 = class_3103.method_1576();
            int n2 = n;
            object2.execute(() -> BaseFarmTest.lambda$tick$3((MinecraftServer)object2, n2));
        }
        if (!fez || n < 90 || !ffa) {
            return false;
        }
        ++fem;
        switch (fel) {
            case 0: {
                BaseFarmTest.fff(fdy.contains("layout") ? 1 : (fdy.contains("base") ? 10 : (fdy.contains("buyer") ? 20 : 30)));
                break;
            }
            case 1: {
                BaseFarmTest.ffs(class_3103, class_32222 -> {
                    class_1661 class_16612 = class_32222.method_31548();
                    class_16612.method_5448();
                    class_16612.method_5447(4, BaseFarmTest.ffp(class_32222, 1800));
                    class_16612.method_5447(0, new class_1799((class_1935)class_1802.field_20412, 64));
                    class_16612.method_5447(7, new class_1799((class_1935)class_1802.field_8477, 40));
                    class_16612.method_5447(12, new class_1799((class_1935)class_1802.field_8695, 30));
                    class_16612.method_5447(20, new class_1799((class_1935)class_1802.field_8725, 12));
                    class_16612.method_5447(21, new class_1799((class_1935)class_1802.field_8725, 7));
                    class_16612.method_5447(22, new class_1799((class_1935)class_1802.field_8759, 9));
                    class_16612.method_5447(25, new class_1799((class_1935)class_1802.field_8620, 3));
                    class_16612.method_5447(26, new class_1799((class_1935)class_1802.field_8713, 5));
                    class_16612.method_5447(30, new class_1799((class_1935)class_1802.field_22019, 1));
                    class_16612.method_5447(31, new class_1799((class_1935)class_1802.field_20394, 33));
                    class_16612.method_5447(33, new class_1799((class_1935)class_1802.field_33400, 4));
                    class_16612.method_5447(34, new class_1799((class_1935)class_1802.field_8071, 20));
                    class_16612.method_5447(35, new class_1799((class_1935)class_1802.field_8288));
                    class_32222.field_7512.method_7623();
                });
                BaseFarmTest.fff(2);
                break;
            }
            case 2: {
                if (feq.busy()) {
                    feq.endTick(class_3103, class_7462, Set.of("minecraft:cobblestone", "minecraft:granite"));
                }
                if (fem == 20) {
                    fer = true;
                    feq.layout();
                    break;
                }
                if (fem > 20 && !feq.busy()) {
                    int n2;
                    fer = false;
                    object2 = class_7462.method_31548();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (n2 = 0; n2 < 36; ++n2) {
                        class_1799 class_17992 = object2.method_5438(n2);
                        stringBuilder.append(n2).append('=').append(class_17992.method_7960() ? "-" : BaseFarmTest.fft(class_17992.method_7909()) + "x" + class_17992.method_7947()).append(' ');
                    }
                    System.out.println("base test layout: " + stringBuilder + " off=" + BaseFarmTest.fft(class_7462.method_6079().method_7909()) + "x" + class_7462.method_6079().method_7947());
                    n2 = InventoryCounter.misplaced((class_1661)object2, InventoryCounter.targets((class_1661)object2, class_7462.method_6079()));
                    BaseFarmTest.ffu(feq.laidOut(), "layout gave up");
                    BaseFarmTest.ffu(n2 == 0, "layout misplaced " + n2);
                    BaseFarmTest.ffu(object2.method_5438(0).method_31574(class_1802.field_22024), "pickaxe not in slot 0");
                    BaseFarmTest.ffu(class_7462.method_6079().method_31574(class_1802.field_8071), "carrots not in the offhand");
                    BaseFarmTest.ffu(InventoryCounter.count((class_1661)object2, class_1802.field_8477) == 40 && InventoryCounter.count((class_1661)object2, class_1802.field_8695) == 30, "diamonds/gold lost: " + InventoryCounter.count((class_1661)object2, class_1802.field_8477) + "/" + InventoryCounter.count((class_1661)object2, class_1802.field_8695));
                    BaseFarmTest.ffu(InventoryCounter.count((class_1661)object2, class_1802.field_20412) == 0 && InventoryCounter.count((class_1661)object2, class_1802.field_20394) == 0, "junk still there");
                    BaseFarmTest.ffu(InventoryCounter.count((class_1661)object2, class_1802.field_8725) >= 1 && InventoryCounter.count((class_1661)object2, class_1802.field_8725) <= 12, "redstone");
                    BaseFarmTest.ffu(InventoryCounter.count((class_1661)object2, class_1802.field_8288) == 1, "totem thrown");
                    BaseFarmTest.ffu(object2.method_5438(32).method_31574(class_1802.field_22019), "debris not in its slot");
                    BaseFarmTest.ffy(class_3103, "minebase-layout");
                    BaseFarmTest.fff(fdy.contains("base") ? 10 : (fdy.contains("buyer") ? 20 : 30));
                    break;
                }
                if (fem <= 600) break;
                BaseFarmTest.ffu(false, "layout never finished");
                fer = false;
                feq.cancel(class_3103);
                BaseFarmTest.fff(30);
                break;
            }
            case 10: {
                BaseFarmTest.ffs(class_3103, class_32222 -> {
                    int n;
                    class_1661 class_16612 = class_32222.method_31548();
                    class_16612.method_5448();
                    class_16612.method_5447(0, BaseFarmTest.ffp(class_32222, 90));
                    for (n = 1; n <= 8; ++n) {
                        class_16612.method_5447(n, new class_1799((class_1935)class_1802.field_8477, 64));
                    }
                    class_16612.method_5447(9, new class_1799((class_1935)class_1802.field_8725, 5));
                    class_16612.method_5447(10, new class_1799((class_1935)class_1802.field_8759, 3));
                    class_16612.method_5447(11, new class_1799((class_1935)class_1802.field_8620, 1));
                    class_16612.method_5447(12, new class_1799((class_1935)class_1802.field_8713, 2));
                    class_16612.method_5447(13, new class_1799((class_1935)class_1802.field_8695, 64));
                    class_16612.method_5447(14, new class_1799((class_1935)class_1802.field_8695, 64));
                    class_16612.method_5447(15, new class_1799((class_1935)class_1802.field_8695, 40));
                    for (n = 16; n <= 26; ++n) {
                        class_16612.method_5447(n, new class_1799((class_1935)class_1802.field_8695, 1));
                    }
                    class_16612.method_5447(27, new class_1799((class_1935)class_1802.field_8477, 64));
                    class_16612.method_5447(28, new class_1799((class_1935)class_1802.field_8477, 30));
                    for (int n2 : new int[]{29, 30, 31, 33, 34}) {
                        class_16612.method_5447(n2, new class_1799((class_1935)class_1802.field_8477, 1));
                    }
                    class_16612.method_5447(35, new class_1799((class_1935)class_1802.field_20412, 64));
                    class_16612.method_5447(32, new class_1799((class_1935)class_1802.field_22019, 3));
                    class_32222.method_31548().method_5447(40, new class_1799((class_1935)class_1802.field_8071, 2));
                    class_32222.field_7512.method_7623();
                    feo = BaseFarmTest.ffo(BaseFarmTest.ffn(class_32222.method_51469(), fed), class_1802.field_8287);
                    BaseFarmTest.ffq(BaseFarmTest.ffr(class_3103), feg);
                });
                BaseFarmTest.fff(11);
                break;
            }
            case 11: {
                boolean bl;
                if (fem == 30) {
                    object2 = Flow.getInstance().getModuleManager().getByName("AutoMine");
                    nfi.solo = false;
                    nfi.anarchies = "101";
                    BaseFarmTest.ffv((Module)object2, "Анка склада", "an513");
                    BaseFarmTest.ffv((Module)object2, "Команда склада", "home");
                    BaseFarmTest.ffv((Module)object2, "Включать авто-скупку", false);
                    BaseFarmTest.ffv((Module)object2, "Сообщения", true);
                    ((Module)object2).setEnabled(true);
                    System.out.println("base test: AutoMine on");
                    break;
                }
                if (fem <= 30) break;
                object2 = (AutoMines)Flow.getInstance().getModuleManager().getByName("AutoMine");
                String string2 = AutoMines.hudStatus();
                if (fem % 40 == 0) {
                    System.out.println("base test t=" + (double)fem / 20.0 + "s " + string2 + " pos=" + class_7462.method_24515().method_23854() + " dur=" + InventoryCounter.pickaxeDurability(class_7462));
                }
                if (fem == 900) {
                    BaseFarmTest.ffy(class_3103, "minebase-base");
                }
                boolean bl2 = bl = fem > 200 && !((AutoMines)object2).debug().startsWith("BASE");
                if (!bl && fem <= 4800) break;
                System.out.println("base test: base over: " + string2 + " " + ((AutoMines)object2).debug());
                ((Module)object2).setEnabled(false);
                BaseFarmTest.ffg(class_3103, class_7462);
                BaseFarmTest.fff(fdy.contains("buyer") ? 20 : (fdy.contains("trap") ? 30 : 99));
                break;
            }
            case 20: {
                if (fem == 10) {
                    fes = new BuyerSeller();
                    fes.begin(class_3103, "/buyer", System.currentTimeMillis());
                    break;
                }
                if (fem <= 10) break;
                if (fem == 14) {
                    BaseFarmTest.ffy(class_3103, "minebase-buyer");
                }
                if (fes.tick(class_3103, class_7462, System.currentTimeMillis())) {
                    System.out.println("base test buyer: ok=" + fes.ok() + " " + fes.result() + " in " + (fem - 10) + " ticks");
                    BaseFarmTest.ffu(fes.ok(), "buyer: " + fes.result());
                    BaseFarmTest.ffs(class_3103, class_32222 -> {
                        for (class_1792 class_17922 : new class_1792[]{class_1802.field_8725, class_1802.field_8759, class_1802.field_8713, class_1802.field_8620}) {
                            BaseFarmTest.ffu(ffc.contains(class_17922), "buyer left " + BaseFarmTest.fft(class_17922) + " off");
                        }
                    });
                    BaseFarmTest.fff(fdy.contains("trap") ? 30 : 99);
                    break;
                }
                if (fem <= 400) break;
                BaseFarmTest.ffu(false, "buyer hung");
                BaseFarmTest.fff(30);
                break;
            }
            case 30: {
                boolean bl;
                if (fem == 5) {
                    object2 = fea.method_10069(-6, 0, -6);
                    BaseFarmTest.ffs(class_3103, arg_0 -> BaseFarmTest.lambda$tick$7(class_3103, (class_2338)object2, arg_0));
                    fex = object2.method_10084();
                    break;
                }
                if (fem == 30) {
                    fet = new AutoMineController();
                    fet.configure(fev, false, false);
                    fet.guard(Box3.empty(class_7462.method_24515()));
                    feu.use(AimModel.profile1());
                    few = true;
                    object2 = class_2338.method_49638((class_2374)class_7462.method_33571());
                    fex = object2;
                    BaseFarmTest.ffs(class_3103, arg_0 -> BaseFarmTest.lambda$tick$8((class_2338)object2, arg_0));
                    System.out.println("base test: stone put in the head at " + object2.method_23854());
                    break;
                }
                if (fem <= 32) break;
                fet.endTick(class_3103, class_7462, feu);
                if (fem % 20 == 0) {
                    object2 = class_7462.method_5829().method_1011(0.001);
                    System.out.println("base test trap: eye=" + class_7462.method_33571() + " pos=" + class_7462.method_73189() + " empty=" + class_3103.field_1687.method_8587((class_1297)class_7462, (class_238)object2) + " trapped=" + AutoMineController.trapped((class_1937)class_3103.field_1687, class_7462) + " eyeBlock=" + class_3103.field_1687.method_8320(class_2338.method_49638((class_2374)class_7462.method_33571())) + " insideWall=" + class_7462.method_5757());
                    System.out.println("base test trap: sel=" + class_7462.method_31548().method_67532() + " main=" + class_7462.method_6047() + " using=" + class_7462.method_6115() + " use=" + class_3103.field_1690.field_1904.method_1434() + " attack=" + class_3103.field_1690.field_1886.method_1434() + " screen=" + class_3103.field_1755 + " hit=" + class_3103.field_1765.method_17783() + " " + fet.action() + " status=" + (Object)((Object)fet.status()));
                }
                boolean bl3 = bl = class_3103.field_1687.method_8320(fex).method_26215() && class_3103.field_1687.method_8320(fex.method_10074()).method_26215();
                if (bl) {
                    System.out.println("base test: dug out in " + (fem - 30) + " ticks");
                    BaseFarmTest.ffu(fem - 30 <= 40, "dig-out slow: " + (fem - 30) + " ticks");
                    few = false;
                    fet.stop(class_3103);
                    BaseFarmTest.fff(99);
                    break;
                }
                if (fem <= 200) break;
                BaseFarmTest.ffu(false, "never dug out of " + fex.method_23854());
                few = false;
                fet.stop(class_3103);
                BaseFarmTest.fff(99);
                break;
            }
            default: {
                for (String string3 : fep) {
                    System.out.println("base log " + string3);
                }
                System.out.println("base test " + (fek == 0 ? "PASS" : "FAIL (" + fek + ")"));
                return true;
            }
        }
        return false;
    }

    private static void fff(int n) {
        fel = n;
        fem = 0;
    }

    private static void ffg(class_310 class_3102, class_746 class_7462) {
        class_1661 class_16612 = class_7462.method_31548();
        int n = InventoryCounter.pickaxeDurability(class_7462);
        System.out.println("base test: dur=" + n + " diamonds=" + InventoryCounter.count(class_16612, class_1802.field_8477) + " gold=" + InventoryCounter.count(class_16612, class_1802.field_8695) + " carrots=" + InventoryCounter.food((class_1657)class_7462) + " bottles=" + InventoryCounter.count(class_16612, class_1802.field_8287));
        BaseFarmTest.ffu(n >= 1500, "pickaxe not repaired: " + n);
        BaseFarmTest.ffu(class_16612.method_5438(0).method_31574(class_1802.field_22024), "pickaxe not back in slot 0");
        BaseFarmTest.ffu(InventoryCounter.food((class_1657)class_7462) == 64, "carrots " + InventoryCounter.food((class_1657)class_7462) + " (want 64)");
        BaseFarmTest.ffu(class_7462.method_6079().method_31574(class_1802.field_8071), "carrots not in the offhand");
        BaseFarmTest.ffu(InventoryCounter.count(class_16612, class_1802.field_8477) >= 16 && InventoryCounter.count(class_16612, class_1802.field_8477) < 34, "diamonds kept " + InventoryCounter.count(class_16612, class_1802.field_8477));
        BaseFarmTest.ffu(InventoryCounter.count(class_16612, class_1802.field_22019) == 0, "debris not dumped " + InventoryCounter.count(class_16612, class_1802.field_22019));
        BaseFarmTest.ffu(class_16612.method_5438(32).method_31574(class_1802.field_8695), "debris slot holds " + class_16612.method_5438(32));
        BaseFarmTest.ffu(InventoryCounter.count(class_16612, class_1802.field_8725) == 5, "redstone " + InventoryCounter.count(class_16612, class_1802.field_8725) + " (want all 5)");
        BaseFarmTest.ffu(InventoryCounter.count(class_16612, class_1802.field_20412) == 0, "junk wasn't thrown before the trip");
        BaseFarmTest.ffu(InventoryCounter.count(class_16612, class_1802.field_8603) == 0 && InventoryCounter.count(class_16612, class_1802.field_8494) == 0, "blocks not dumped");
        BaseFarmTest.ffs(class_3102, class_32222 -> {
            int n;
            class_3218 class_32182 = class_32222.method_51469();
            class_1263 class_12632 = BaseFarmTest.ffn(class_32182, feb);
            int n2 = BaseFarmTest.ffo(class_12632, class_1802.field_8603);
            int n3 = BaseFarmTest.ffo(class_12632, class_1802.field_8494);
            int n4 = BaseFarmTest.ffo(class_12632, class_1802.field_22019);
            int n5 = 0;
            for (n = 0; n < class_12632.method_5439(); ++n) {
                class_1799 class_17992 = class_12632.method_5438(n);
                if (class_17992.method_7960() || class_17992.method_31574(class_1802.field_8603) || class_17992.method_31574(class_1802.field_8494) || class_17992.method_31574(class_1802.field_22019)) continue;
                n5 += class_17992.method_7947();
            }
            n = class_32182.method_8390(class_1542.class, new class_238(feb).method_1014(16.0), class_15422 -> true).size();
            int n6 = BaseFarmTest.ffo(BaseFarmTest.ffn(class_32182, fed), class_1802.field_8287);
            System.out.println("base test chests: dump diamond_block=" + n2 + " gold_block=" + n3 + " debris=" + n4 + " other=" + n5 + " | dropped at the base " + n + " | xp " + feo + " -> " + n6 + " | food left " + BaseFarmTest.ffo(BaseFarmTest.ffn(class_32182, fec), class_1802.field_8071));
            BaseFarmTest.ffu(n2 >= 40, "diamond blocks in the dump " + n2);
            BaseFarmTest.ffu(n3 >= 3, "gold blocks in the dump " + n3);
            BaseFarmTest.ffu(n4 == 3, "debris in the dump " + n4);
            BaseFarmTest.ffu(n5 == 0, "something else than blocks in the dump: " + n5);
            BaseFarmTest.ffu(n == 0, "items thrown out at the stash: " + n);
            BaseFarmTest.ffu(n6 > feo, "no XP crafted into the XP chest");
            BaseFarmTest.ffu(BaseFarmTest.ffo(BaseFarmTest.ffn(class_32182, fec), class_1802.field_8071) == 66, "carrots taken wrong");
        });
    }

    private static void ffh(MinecraftServer minecraftServer2, class_2338 class_23382) {
        int n;
        int n2;
        class_3218 class_32182 = minecraftServer2.method_30002();
        fea = class_23382.method_10069(0, 0, 200);
        feg = class_23382.method_10069(4, 0, 4);
        for (n2 = (fea.method_10263() >> 4) - 2; n2 <= (fea.method_10263() >> 4) + 2; ++n2) {
            for (n = (fea.method_10260() >> 4) - 2; n <= (fea.method_10260() >> 4) + 2; ++n) {
                class_32182.method_8497(n2, n);
                class_32182.method_17988(n2, n, true);
            }
        }
        for (n2 = -12; n2 <= 12; ++n2) {
            for (n = -12; n <= 12; ++n) {
                class_32182.method_8652(fea.method_10069(n2, -1, n), class_2246.field_10340.method_9564(), 3);
                for (int i = 0; i <= 4; ++i) {
                    class_32182.method_8652(fea.method_10069(n2, i, n), class_2246.field_10124.method_9564(), 3);
                }
            }
        }
        feb = fea.method_10069(1, 0, 0);
        fec = fea.method_10069(4, 0, 0);
        fed = fea.method_10069(7, 0, 0);
        fee = fea.method_10069(8, 0, 0);
        fef = fea.method_10069(3, 0, -4);
        class_2338 class_23383 = fea.method_10069(-3, 0, 0);
        for (class_2338 class_23384 : new class_1263[]{feb, fec, fed, class_23383}) {
            class_32182.method_8652(class_23384, class_2246.field_10034.method_9564(), 3);
        }
        class_32182.method_8652(fee, class_2246.field_9980.method_9564(), 3);
        BaseFarmTest.ffm(class_32182, feb.method_10095(), "Сброс");
        BaseFarmTest.ffm(class_32182, fec.method_10095(), "Золотая", "морковь");
        BaseFarmTest.ffm(class_32182, fed.method_10095(), "§lОпыт");
        BaseFarmTest.ffm(class_32182, class_23383.method_10095(), "Разное");
        class_1263 class_12632 = BaseFarmTest.ffn(class_32182, fec);
        class_12632.method_5447(3, new class_1799((class_1935)class_1802.field_8071, 64));
        class_12632.method_5447(5, new class_1799((class_1935)class_1802.field_8071, 64));
        class_1263 class_12633 = BaseFarmTest.ffn(class_32182, fed);
        for (int i = 0; i < 3; ++i) {
            class_12633.method_5447(i * 2, new class_1799((class_1935)class_1802.field_8287, 64));
        }
        BaseFarmTest.ffn(class_32182, class_23383).method_5447(0, new class_1799((class_1935)class_1802.field_8831, 10));
        BaseFarmTest.ffj(minecraftServer2);
        ServerTickEvents.END_SERVER_TICK.register(minecraftServer -> {
            Object object;
            ++feh;
            class_3222 class_32222 = minecraftServer.method_3760().method_14566(fdz);
            if (class_32222 == null) {
                return;
            }
            if (fej >= 0L && feh >= fej) {
                fej = -1L;
                BaseFarmTest.ffq(minecraftServer, fea.method_10069(0, 0, -70));
                fep.add("t=" + (double)feh / 20.0 + " /an513");
            }
            if (fei >= 0L && feh >= fei) {
                fei = -1L;
                BaseFarmTest.ffq(minecraftServer, fef);
                fep.add("t=" + (double)feh / 20.0 + " /home");
            }
            if (System.getenv("FLOW2_MINE_TRACE") != null && (object = class_32222.field_7512) instanceof class_1714) {
                class_1714 class_17142 = (class_1714)object;
                if (feh % 5L == 0L) {
                    object = new StringBuilder("[");
                    for (class_1735 class_17352 : class_17142.method_61628()) {
                        ((StringBuilder)object).append(class_17352.method_7677().method_7947()).append(class_17352.method_7677().method_7960() ? "" : BaseFarmTest.fft(class_17352.method_7677().method_7909()).substring(0, 2)).append(' ');
                    }
                    System.out.println("srv grid " + object + "] out=" + class_17142.method_61627().method_7677() + " rev=" + class_17142.method_37421() + " t=" + feh);
                }
            }
        });
    }

    private static void ffi(MinecraftServer minecraftServer) {
        CommandDispatcher commandDispatcher = minecraftServer.method_3734().method_9235();
        commandDispatcher.register((LiteralArgumentBuilder)class_2170.method_9247((String)"an513").executes(commandContext -> {
            fej = feh + 30L;
            return 1;
        }));
        commandDispatcher.register((LiteralArgumentBuilder)class_2170.method_9247((String)"home").executes(commandContext -> {
            class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
            class_32222.method_64398((class_2561)class_2561.method_43470((String)"§c[⚡] Телепортация! §fПеремещение через §a3 сек"));
            fei = feh + 60L;
            return 1;
        }));
        commandDispatcher.register((LiteralArgumentBuilder)class_2170.method_9247((String)"buyer").executes(commandContext -> {
            class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
            class_32222.method_17355((class_3908)new class_747((n, class_16612, class_16572) -> BaseFarmTest.ffk(n, class_16612), (class_2561)class_2561.method_43470((String)"Скупщик")));
            return 1;
        }));
        class_3222 class_32222 = minecraftServer.method_3760().method_14566(fdz);
        if (class_32222 != null) {
            minecraftServer.method_3760().method_14576(class_32222);
        }
    }

    private static void ffj(MinecraftServer minecraftServer) {
        try {
            Path path = minecraftServer.method_27050(class_5218.field_24186).resolve("flowtest");
            Files.createDirectories(path.resolve("data/flowtest/recipe"), new FileAttribute[0]);
            int n = class_155.method_16673().method_70592(class_3264.field_14190).comp_4416();
            Files.writeString(path.resolve("pack.mcmeta"), (CharSequence)("{\"pack\":{\"description\":\"flow test\",\"min_format\":" + n + ",\"max_format\":" + n + "}}"), StandardCharsets.UTF_8, new OpenOption[0]);
            Files.writeString(path.resolve("data/flowtest/recipe/xp_bottle.json"), (CharSequence)"{\"type\":\"minecraft:crafting_shaped\",\"category\":\"misc\",\"pattern\":[\" N \",\"NDN\",\" N \"],\"key\":{\"N\":\"minecraft:gold_nugget\",\"D\":\"minecraft:diamond\"},\"result\":{\"id\":\"minecraft:experience_bottle\",\"count\":5}}", StandardCharsets.UTF_8, new OpenOption[0]);
            System.out.println("base test: datapack format " + n + " at " + path);
        }
        catch (Exception exception) {
            System.out.println("base test: no datapack: " + exception);
        }
    }

    private static class_1707 ffk(int n, class_1661 class_16612) {
        class_1277 class_12772 = new class_1277(27);
        class_1799 class_17992 = new class_1799((class_1935)class_1802.field_8759);
        class_17992.method_57379(class_9334.field_49631, (Object)class_2561.method_43470((String)"§9Шахтёр"));
        class_12772.method_5447(11, new class_1799((class_1935)class_1802.field_8861));
        class_12772.method_5447(13, class_17992);
        class_12772.method_5447(15, new class_1799((class_1935)class_1802.field_8511));
        ffc.clear();
        ffc.add(class_1802.field_8759);
        return new fdt(class_3917.field_17326, n, class_16612, (class_1263)class_12772, 3, class_12772);
    }

    private static class_1799 ffl(class_1792 class_17922) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        boolean bl = ffc.contains(class_17922);
        class_17992.method_57379(class_9334.field_49632, (Object)new class_9290(List.of(class_2561.method_43470((String)"§7Цена: 1¢"), class_2561.method_43470((String)(bl ? "§6[Q] §fавто-скупка: §aвключена" : "§6[Q] §fавто-скупка: §cвыключена")))));
        return class_17992;
    }

    private static void ffm(class_3218 class_32182, class_2338 class_23382, String ... stringArray) {
        class_32182.method_8652(class_23382, (class_2680)class_2246.field_10187.method_9564().method_11657((class_2769)class_2551.field_11726, (Comparable)class_2350.field_11043), 3);
        class_2586 class_25862 = class_32182.method_8321(class_23382);
        if (class_25862 instanceof class_2625) {
            class_2625 class_26252 = (class_2625)class_25862;
            class_25862 = new class_8242();
            for (int i = 0; i < stringArray.length; ++i) {
                class_25862 = class_25862.method_49857(i, (class_2561)class_2561.method_43470((String)stringArray[i]));
            }
            class_26252.method_49840((class_8242)class_25862, true);
            class_32182.method_8413(class_23382, class_32182.method_8320(class_23382), class_32182.method_8320(class_23382), 3);
        }
    }

    private static class_1263 ffn(class_3218 class_32182, class_2338 class_23382) {
        return (class_2595)class_32182.method_8321(class_23382);
    }

    private static int ffo(class_1263 class_12632, class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < class_12632.method_5439(); ++i) {
            if (!class_12632.method_5438(i).method_31574(class_17922)) continue;
            n += class_12632.method_5438(i).method_7947();
        }
        return n;
    }

    private static class_1799 ffp(class_3222 class_32222, int n) {
        class_1799 class_17992 = new class_1799((class_1935)class_1802.field_22024);
        class_2378 class_23782 = class_32222.method_51469().method_30349().method_30530(class_7924.field_41265);
        class_17992.method_7978((class_6880)class_23782.method_46747(class_1893.field_9131), 5);
        class_17992.method_7978((class_6880)class_23782.method_46747(class_1893.field_9101), 1);
        class_17992.method_7974(class_17992.method_7936() - n);
        return class_17992;
    }

    private static void ffq(MinecraftServer minecraftServer, class_2338 class_23382) {
        minecraftServer.method_3734().method_44252(minecraftServer.method_3739(), String.format(Locale.ROOT, "tp %s %.1f %d %.1f 0 10", fdz, (double)class_23382.method_10263() + 0.5, class_23382.method_10264(), (double)class_23382.method_10260() + 0.5));
    }

    private static MinecraftServer ffr(class_310 class_3102) {
        return class_3102.method_1576();
    }

    private static void ffs(class_310 class_3102, Consumer<class_3222> consumer) {
        class_1132 class_11322 = class_3102.method_1576();
        ffa = false;
        class_11322.execute(() -> BaseFarmTest.lambda$server$16((MinecraftServer)class_11322, consumer));
    }

    private static String fft(class_1792 class_17922) {
        return class_7923.field_41178.method_10221((Object)class_17922).method_12832();
    }

    private static void ffu(boolean bl, String string) {
        if (!bl) {
            ++fek;
            System.out.println("base test check failed: " + string);
        }
    }

    private static void ffv(Module kfe2, String string, Object object) {
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

    private static void ffw(String string, boolean bl) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
    }

    private static void ffx(class_310 class_3102) throws Exception {
        for (Field field : class_312.class.getDeclaredFields()) {
            if (!field.getName().equals("cursorLocked")) continue;
            field.setAccessible(true);
            field.setBoolean(class_3102.field_1729, true);
        }
    }

    private static void ffy(class_310 class_3102, String string) {
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static void ffz(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static /* synthetic */ void lambda$server$16(MinecraftServer minecraftServer, Consumer consumer) {
        class_3222 class_32222 = minecraftServer.method_3760().method_14566(fdz);
        if (class_32222 != null) {
            consumer.accept(class_32222);
        }
        ffb = feh;
        ffa = true;
    }

    private static /* synthetic */ void lambda$tick$8(class_2338 class_23382, class_3222 class_32222) {
        class_3218 class_32182 = class_32222.method_51469();
        for (class_2350 class_23502 : class_2350.class_2353.field_11062) {
            class_32182.method_8501(class_23382.method_10093(class_23502), class_2246.field_10340.method_9564());
            class_32182.method_8501(class_23382.method_10074().method_10093(class_23502), class_2246.field_10340.method_9564());
        }
        class_32182.method_8501(class_23382.method_10084(), class_2246.field_10340.method_9564());
        class_32182.method_8501(class_23382, class_2246.field_10340.method_9564());
        class_32182.method_8501(class_23382.method_10074(), class_2246.field_10340.method_9564());
    }

    private static /* synthetic */ void lambda$tick$7(class_310 class_3102, class_2338 class_23382, class_3222 class_32222) {
        BaseFarmTest.ffq(BaseFarmTest.ffr(class_3102), class_23382);
        class_32222.method_31548().method_5447(0, BaseFarmTest.ffp(class_32222, 1500));
        class_32222.method_31548().method_61496(0);
    }

    private static /* synthetic */ void lambda$tick$3(MinecraftServer minecraftServer, int n) {
        boolean bl = minecraftServer.method_3772().method_8130(class_5321.method_29179((class_5321)class_7924.field_52178, (class_2960)class_2960.method_60655((String)"flowtest", (String)"xp_bottle"))).isPresent();
        if (!fez && (bl || n > 1200)) {
            System.out.println("base test: XP recipe loaded=" + bl);
            BaseFarmTest.ffi(minecraftServer);
            fez = true;
        }
    }

    private static /* synthetic */ void lambda$tick$2(MinecraftServer minecraftServer, class_2338 class_23382) {
        BaseFarmTest.ffh(minecraftServer, class_23382);
    }

    static {
        fei = -1L;
        fej = -1L;
        fep = new ArrayList<String>();
        feq = new MineTools();
        feu = new AimBrain();
        fev = new TrackingError();
        fey = 1;
        ffa = true;
        ffc = new ArrayList<class_1792>();
    }

    private static /* synthetic */ int od(int n, int n2) {
        return (n ^ n2) + -863514473;
    }
}

