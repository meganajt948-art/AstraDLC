/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1132
 *  net.minecraft.class_1263
 *  net.minecraft.class_1277
 *  net.minecraft.class_1661
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1806
 *  net.minecraft.class_1934
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2561
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3908
 *  net.minecraft.class_437
 *  net.minecraft.class_746
 *  net.minecraft.class_747
 */
package a;

import a.dts;
import a.Bot;
import a.ech;
import a.BotManager;
import a.BotRuntime;
import a.Module;
import a.AutoEnd;
import a.AutoWarden;
import a.BotModule;
import a.CameraOwner;
import flow.Flow;
import flow.bot.BotScreen;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;
import net.minecraft.class_1132;
import net.minecraft.class_1263;
import net.minecraft.class_1277;
import net.minecraft.class_1661;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1806;
import net.minecraft.class_1934;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3908;
import net.minecraft.class_437;
import net.minecraft.class_746;
import net.minecraft.class_747;

final class LanBotTest {
    private static final String fgb = "FlowBot1";
    private static int fgc;
    private static Bot fgd;
    private static int fge;
    private static double fgf;
    private static int fgg;
    private static float fgh;
    private static float fgi;
    private static /* synthetic */ String fgj;
    private static /* synthetic */ boolean fgk;

    private LanBotTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Object object;
        int n2;
        class_1132 class_11322 = class_3102.method_1576();
        if (class_11322 == null) {
            return n > 40;
        }
        if (n == 1) {
            class_11322.method_3864(false);
            fgc = 25570 + (int)(System.nanoTime() % 20L);
            n2 = class_11322.method_3763(class_1934.field_9215, true, fgc);
            LanBotTest.fgq("lan open " + (n2 != 0) + " port " + fgc);
            if (n2 == 0) {
                LanBotTest.fgp("LAN did not open");
                return true;
            }
        }
        if (n == 10) {
            fgd = BotManager.get().add("FlowBot1", "localhost:" + fgc);
            LanBotTest.fgq("bot added " + (fgd != null));
            if (fgd != null) {
                fgd.setAddress("localhost:" + fgc);
                if (fgd.getStatus() == dts.OFFLINE || fgd.getStatus() == dts.FAILED) {
                    fgd.connect();
                }
            }
        }
        if (fgd == null) {
            return n > 20;
        }
        if (n > 10 && n % 20 == 0 && fge < 0) {
            LanBotTest.fgq("status " + (Object)((Object)fgd.getStatus()) + " " + fgd.getStatusText() + " pending " + fgd.getPendingPackets());
        }
        if (fge < 0 && fgd.getStatus() == dts.ONLINE && fgd.getPlayer() != null) {
            fge = n;
            LanBotTest.fgq("ONLINE at t=" + n);
        }
        if (fge < 0) {
            if (n > 900) {
                LanBotTest.fgp("bot never came online: " + fgd.getStatusText());
                LanBotTest.fgn();
                return true;
            }
            return false;
        }
        n2 = n - fge;
        class_746 class_7462 = fgd.getPlayer();
        if (n2 == 40) {
            LanBotTest.fgo(class_3102.field_1724 != null && class_3102.field_1724 != class_7462, "main player is not the bot");
            LanBotTest.fgo(class_3102.field_1687 != null && class_3102.field_1687 != fgd.getWorld(), "main world is not the bot's");
            LanBotTest.fgo(!BotRuntime.isActive(), "no bot context outside the frame hook");
            object = class_11322.method_3760().method_14566("FlowBot1");
            LanBotTest.fgo(object != null, "server sees the bot");
            if (class_7462 != null) {
                LanBotTest.fgq("bot at " + class_7462.method_24515() + " hp " + class_7462.method_6032() + " loaded " + (class_7462.field_3944 != null && class_7462.field_3944.method_76760()));
                LanBotTest.fgo(class_7462.field_3944.method_76760(), "bot marked loaded");
            }
            fgd.sendChat("hello from bot");
            class_11322.execute(() -> {
                class_3222 class_32222 = class_11322.method_3760().method_14566("FlowBot1");
                if (class_32222 != null) {
                    class_32222.method_64398((class_2561)class_2561.method_43470((String)"server says hi"));
                    class_32222.method_31548().method_7394(new class_1799((class_1935)class_1802.field_8477, 5));
                }
            });
        }
        if (n2 == 80) {
            boolean bl = false;
            for (ech ech2 : fgd.getChat().lines()) {
                if (!ech2.text.getString().contains("server says hi")) continue;
                bl = true;
            }
            LanBotTest.fgo(bl, "bot chat got the server message");
            boolean bl2 = class_7462 != null && class_7462.method_31548().method_18861(class_1802.field_8477) == 5;
            LanBotTest.fgo(bl2, "bot inventory synced (5 diamonds)");
            class_3102.method_1507((class_437)new BotScreen());
        }
        if (n2 == 110) {
            LanBotTest.fgr(class_3102, "bots-window");
        }
        if (n2 == 120) {
            fgf = class_7462 == null ? 0.0 : class_7462.method_23321();
            fgd.getControl().setActive(true);
            fgd.getControl().setMovement(true, false, false, false, false, false, false);
        }
        if (n2 == 160) {
            fgd.getControl().setMovement(false, false, false, false, false, false, false);
            fgd.getControl().setActive(false);
            double d = class_7462 == null ? 0.0 : Math.abs(class_7462.method_23321() - fgf);
            LanBotTest.fgq("control moved " + String.format("%.2f", d));
            LanBotTest.fgo(d > 1.0, "bot walks under control");
            class_11322.execute(() -> {
                class_3222 class_32222 = class_11322.method_3760().method_14566("FlowBot1");
                if (class_32222 != null) {
                    class_1277 class_12772 = new class_1277(27);
                    class_12772.method_5447(0, new class_1799((class_1935)class_1802.field_8687, 3));
                    class_32222.method_17355((class_3908)new class_747((n, class_16612, class_16572) -> class_1707.method_19245((int)n, (class_1661)class_16612, (class_1263)class_12772), (class_2561)class_2561.method_43470((String)"Тестовый сундук")));
                }
            });
        }
        if (n2 == 200) {
            boolean bl = class_7462 != null && class_7462.field_7512 != class_7462.field_7498;
            LanBotTest.fgo(bl, "bot sees the opened chest");
            LanBotTest.fgo("Тестовый сундук".equals(fgd.getOpenedScreenTitle()), "chest title reached the bot");
            LanBotTest.fgr(class_3102, "bots-chest");
            if (bl) {
                fgd.clickSlot(class_7462.field_7512.field_7763, 0, 0, class_1713.field_7794);
            }
        }
        if (n2 == 240) {
            LanBotTest.fgo(class_7462 != null && class_7462.method_31548().method_18861(class_1802.field_8687) == 3, "bot took the emeralds");
            fgd.closeScreen();
        }
        if (n2 == 260) {
            LanBotTest.fgo(class_7462 != null && class_7462.field_7512 == class_7462.field_7498, "bot closed the chest");
            fgd.setF1(true);
        }
        if (n2 == 320) {
            LanBotTest.fgl("TAB_W");
        }
        if (n2 == 325) {
            LanBotTest.fgr(class_3102, "bots-tab-warden");
        }
        if (n2 == 340) {
            LanBotTest.fgo(fgd.f1Run(), "AutoWarden runs on the bot");
            LanBotTest.fgq("warden state " + fgd.f1ref().getStateIndex());
            fgd.setF0(true);
        }
        if (n2 == 400) {
            LanBotTest.fgl("TAB_E");
        }
        if (n2 == 405) {
            LanBotTest.fgr(class_3102, "bots-tab-autoend");
            LanBotTest.fgm("lootPicker", true);
        }
        if (n2 == 410) {
            LanBotTest.fgr(class_3102, "bots-loot-picker");
            LanBotTest.fgm("lootPicker", false);
        }
        if (n2 == 420) {
            LanBotTest.fgo(fgd.f0Run() && !fgd.f1Run(), "AutoEnd replaced AutoWarden");
            LanBotTest.fgq("autoend " + fgd.f0ref().getStateDescription());
            fgd.stopAutomation();
        }
        if (n2 == 460) {
            LanBotTest.fgo(!fgd.isActive(), "automation stopped");
            class_11322.execute(() -> {
                class_3222 class_32222 = class_11322.method_3760().method_14566("FlowBot1");
                if (class_32222 != null) {
                    class_32222.method_5768(class_32222.method_51469());
                }
            });
        }
        if (n2 == 480) {
            LanBotTest.fgl("BOT");
        }
        if (n2 == 485) {
            LanBotTest.fgr(class_3102, "bots-tab-bot");
            LanBotTest.fgl("ALL");
        }
        if (n2 == 490) {
            LanBotTest.fgr(class_3102, "bots-tab-all");
            LanBotTest.fgl("CHAT");
        }
        if (n2 == 640) {
            object = fgd.getPlayer();
            LanBotTest.fgo(object != null && object.method_5805(), "bot respawned by itself");
            class_11322.execute(() -> {
                class_3222 class_32222 = class_11322.method_3760().method_14566("FlowBot1");
                if (class_32222 != null) {
                    class_1799 class_17992 = class_1806.method_8005((class_3218)class_32222.method_51469(), (int)class_32222.method_31477(), (int)class_32222.method_31479(), (byte)0, (boolean)true, (boolean)false);
                    class_32222.method_31548().method_5447(class_32222.method_31548().method_67532(), class_17992);
                }
            });
        }
        if (n2 == 700) {
            LanBotTest.fgo(fgd.getCaptcha().isPresent(), "captcha picked up the map in hand");
            LanBotTest.fgr(class_3102, "bots-captcha");
        }
        if (n2 == 760) {
            LanBotTest.fgq("captcha auto: '" + fgd.getCaptcha().getAutoCode() + "' state '" + fgd.getCaptcha().getAutoState() + "'");
            fgd.getCaptcha().dismiss();
            class_11322.execute(() -> {
                int n;
                int n2;
                class_3222 class_32222 = class_11322.method_3760().method_14566("FlowBot1");
                if (class_32222 == null) {
                    return;
                }
                class_3218 class_32182 = class_32222.method_51469();
                class_32222.method_31548().method_5447(class_32222.method_31548().method_67532(), new class_1799((class_1935)class_1802.field_8377));
                class_2338 class_23382 = class_32222.method_24515();
                for (n2 = -4; n2 <= 4; ++n2) {
                    for (n = 0; n <= 3; ++n) {
                        class_32182.method_8501(class_23382.method_10069(n2, n, 7), n2 == 0 && n >= 1 && n <= 2 ? class_2246.field_10033.method_9564() : (n == 3 ? class_2246.field_10503.method_9564() : class_2246.field_10056.method_9564()));
                    }
                }
                for (n2 = -2; n2 <= 2; ++n2) {
                    for (n = 3; n <= 5; ++n) {
                        class_32182.method_8501(class_23382.method_10069(n2, -1, n), class_2246.field_10382.method_9564());
                    }
                }
                class_32182.method_8501(class_23382.method_10069(3, 0, 4), class_2246.field_10336.method_9564());
                class_32182.method_8501(class_23382.method_10069(-3, 0, 4), class_2246.field_10442.method_9564());
                class_32182.method_8501(class_23382.method_10069(-3, 1, 4), class_2246.field_10449.method_9564());
                class_11322.method_3734().method_44252(class_11322.method_3739(), String.format(Locale.ROOT, "tp %s %.2f %.2f %.2f 0 12", "FlowBot1", (double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264(), (double)class_23382.method_10260() + 0.5));
            });
        }
        if (n2 == 790) {
            LanBotTest.fgm("cameraMode", true);
            LanBotTest.fgl("TAB_M");
        }
        if (n2 == 830) {
            LanBotTest.fgo(fgd.getCamera().isReady(), "bot camera renders");
            LanBotTest.fgq("camera frame " + fgd.getCamera().getRenderMillis() + " ms");
            LanBotTest.fgr(class_3102, "bots-camera");
            fgd.setF2(true);
        }
        if (n2 == 930) {
            LanBotTest.fgo(fgd.f2Run(), "AutoMine runs on the bot");
            LanBotTest.fgq("bot automine: " + fgd.f2ref().status() + " / " + fgd.f2ref().lastNote());
            LanBotTest.fgq("camera main thread " + fgd.getCamera().getRenderMillis() + " ms, background trace " + fgd.getCamera().getTraceMillis() + " ms");
            LanBotTest.fgr(class_3102, "bots-tab-mine");
            fgd.setF2(false);
        }
        if (n2 == 960) {
            LanBotTest.fgo(!fgd.f2Run(), "AutoMine stopped on the bot");
            LanBotTest.fgm("cameraMode", false);
            class_3102.method_1507(null);
        }
        if (n2 == 1080) {
            LanBotTest.fgr(class_3102, "bots-main-view");
            LanBotTest.fgo(class_3102.field_1724 != null && class_3102.field_1687 != null && class_3102.field_1724.method_5805(), "main player fine");
            LanBotTest.fgn();
            BotManager.get().remove(fgd);
        }
        if (n2 == 1140) {
            LanBotTest.fgo(class_11322.method_3760().method_14566("FlowBot1") == null, "bot left the server");
            fgh = class_3102.field_1724.method_36454();
            fgi = class_3102.field_1724.method_36455();
            object = Flow.getInstance().getModuleManager().get(AutoWarden.class);
            ((BotModule)object).setEnabled(true);
        }
        if (n2 == 1220) {
            object = Flow.getInstance().getModuleManager().get(AutoWarden.class);
            LanBotTest.fgq("own warden state " + ((AutoWarden)object).getStateIndex() + " spoof " + CameraOwner.INSTANCE.engaged());
            LanBotTest.fgo(((Module)object).isEnabled(), "own AutoWarden kept running");
            ((BotModule)object).setEnabled(false);
            Flow.getInstance().getModuleManager().get(AutoEnd.class).setEnabled(true);
        }
        if (n2 == 1300) {
            object = Flow.getInstance().getModuleManager().get(AutoEnd.class);
            LanBotTest.fgq("own autoend " + ((AutoEnd)object).getStateDescription() + " spoof " + CameraOwner.INSTANCE.engaged());
            LanBotTest.fgo(((Module)object).isEnabled(), "own AutoEnd kept running");
            ((BotModule)object).setEnabled(false);
        }
        if (n2 == 1360) {
            LanBotTest.fgq("camera yaw " + fgh + " -> " + class_3102.field_1724.method_36454() + ", pitch " + fgi + " -> " + class_3102.field_1724.method_36455());
            LanBotTest.fgo(!CameraOwner.INSTANCE.engaged(), "silent view released");
            LanBotTest.fgo(class_3102.field_1724.method_5805(), "main player alive after own farm modules");
            LanBotTest.fgr(class_3102, "bots-own-after");
            LanBotTest.fgq("done, fails " + fgg);
            return true;
        }
        return false;
    }

    private static void fgl(String string) {
        try {
            Class<?> clazz = Class.forName("flow.bot.BotScreen$Tab");
            Field field = BotScreen.class.getDeclaredField("tab");
            field.setAccessible(true);
            field.set(null, Enum.valueOf(clazz, string));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            LanBotTest.fgp("tab " + string + ": " + reflectiveOperationException);
        }
    }

    private static void fgm(String string, boolean bl) {
        try {
            Field field = BotScreen.class.getDeclaredField(string);
            field.setAccessible(true);
            field.setBoolean(null, bl);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            LanBotTest.fgp("flag " + string + ": " + reflectiveOperationException);
        }
    }

    private static void fgn() {
        if (fgd == null) {
            return;
        }
        for (ech ech2 : fgd.getChat().lines()) {
            LanBotTest.fgq("chat [" + (Object)((Object)ech2.kind) + "] " + ech2.text.getString());
        }
    }

    private static void fgo(boolean bl, String string) {
        if (bl) {
            LanBotTest.fgq("OK " + string);
        } else {
            LanBotTest.fgp(string);
        }
    }

    private static void fgp(String string) {
        ++fgg;
        LanBotTest.fgq("FAIL " + string);
    }

    private static void fgq(String string) {
        System.out.println("bots: " + string);
    }

    private static void fgr(class_310 class_3102, String string) {
        LanBotTest.fgq("shot " + string);
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        fge = -1;
    }

    private static /* synthetic */ int og(int n, int n2) {
        return n ^ n2 ^ 0x1D17353B;
    }
}

