/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.minecraft.class_10185
 *  net.minecraft.class_1542
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2535
 *  net.minecraft.class_2813
 *  net.minecraft.class_2815
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2851
 *  net.minecraft.class_2868
 *  net.minecraft.class_2886
 *  net.minecraft.class_310
 *  net.minecraft.class_3222
 *  net.minecraft.class_8609
 *  net.minecraft.class_9276
 *  net.minecraft.class_9837
 */
package a;

import a.fgs;
import a.Module;
import a.ServerHelper;
import a.BoolSetting;
import a.KeySetting;
import a.Setting;
import a.CursorStack;
import a.KeyUtil;
import flow.Flow;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_10185;
import net.minecraft.class_1542;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2535;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_2848;
import net.minecraft.class_2851;
import net.minecraft.class_2868;
import net.minecraft.class_2886;
import net.minecraft.class_310;
import net.minecraft.class_3222;
import net.minecraft.class_8609;
import net.minecraft.class_9276;
import net.minecraft.class_9837;

final class ServerHelperTest {
    private static final String fgw = "{id:\"minecraft:snowball\",count:8,components:{\"minecraft:custom_name\":\"Снежок заморозка\"}}";
    private static final Set<Integer> fgx = ConcurrentHashMap.newKeySet();
    private static final StringBuffer fgy = new StringBuffer();
    private static volatile boolean fgz;
    private static volatile boolean fha;
    private static volatile boolean fhb;
    private static volatile int fhc;
    private static volatile int fhd;
    private static volatile int fhe;
    private static int fhf;
    private static boolean fhg;
    private static Module fhh;
    private static int fhi;
    private static int fhj;
    private static int fhk;
    private static /* synthetic */ int fhl;
    private static /* synthetic */ boolean fhm;

    private ServerHelperTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        fhe = n;
        if (class_3102.field_1724 != null && n > 10) {
            class_3102.field_1724.method_36456(0.0f);
            if (!ServerHelper.busy()) {
                class_3102.field_1724.method_36457(0.0f);
            }
        }
        switch (n) {
            case 1: {
                KeyUtil.simulated = fgx::contains;
                ServerHelperTest.fhz("AutoSprint", false);
                fhh = ServerHelperTest.fhz("ServerHelper", true);
                for (Setting vmo2 : fhh.getSettings()) {
                    BoolSetting vkl2;
                    BoolSetting vkl3;
                    KeySetting vlq2;
                    KeySetting vlq3;
                    if (vmo2 instanceof KeySetting && (vlq3 = (KeySetting)vmo2).getName().equals("Снежок заморозка")) {
                        vlq3.set(fhi);
                        continue;
                    }
                    if (vmo2 instanceof KeySetting && (vlq2 = (KeySetting)vmo2).getName().equals("Заряд ветра")) {
                        vlq2.set(fhj);
                        continue;
                    }
                    if (vmo2 instanceof BoolSetting && (vkl3 = (BoolSetting)vmo2).getName().equals("Булава после заряда")) {
                        vkl3.set(false);
                        continue;
                    }
                    if (!(vmo2 instanceof BoolSetting) || !(vkl2 = (BoolSetting)vmo2).getName().equals("Прыжок в тайминг")) continue;
                    vkl2.set(false);
                }
                ServerHelperTest.fia(class_3102, "gamemode survival");
                ServerHelperTest.fia(class_3102, "effect give @s resistance 600 4 true");
                ServerHelperTest.fia(class_3102, "effect give @s saturation 600 4 true");
                ServerHelperTest.fia(class_3102, "gamerule doMobSpawning false");
                break;
            }
            case 5: {
                ServerHelperTest.fib(class_3102);
                break;
            }
            case 10: {
                ServerHelperTest.fia(class_3102, "clear @s");
                ServerHelperTest.fia(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                ServerHelperTest.fia(class_3102, "item replace entity @s inventory.3 with minecraft:bundle[bundle_contents=[{id:\"minecraft:wind_charge\",count:5},{id:\"minecraft:arrow\",count:10}]]");
                class_3102.field_1724.method_31548().method_61496(0);
                break;
            }
            case 20: {
                ServerHelperTest.fho(class_3102, true);
                break;
            }
            case 40: {
                ServerHelperTest.fhn(class_3102, fhj);
                break;
            }
            case 70: {
                ServerHelperTest.fho(class_3102, false);
                ServerHelperTest.fhr(class_3102, "A", class_1802.field_8802);
                ServerHelperTest.fht(class_3102, "A", 12, class_1802.field_49098, 4);
                ServerHelperTest.fht(class_3102, "A", 12, class_1802.field_8107, 10);
                ServerHelperTest.fhv(class_3102, "A");
                ServerHelperTest.fhx("A");
                break;
            }
            case 80: {
                ServerHelperTest.fhp(class_3102, "minecraft:dirt 64");
                ServerHelperTest.fia(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                ServerHelperTest.fia(class_3102, "item replace entity @s hotbar.5 with minecraft:ender_pearl 4");
                ServerHelperTest.fia(class_3102, "item replace entity @s inventory.3 with minecraft:bundle[bundle_contents=[{id:\"minecraft:snowball\",count:8,components:{\"minecraft:custom_name\":\"Снежок заморозка\"}},{id:\"minecraft:arrow\",count:32}]]");
                class_3102.field_1724.method_31548().method_61496(0);
                break;
            }
            case 100: {
                ServerHelperTest.fho(class_3102, true);
                break;
            }
            case 110: {
                ServerHelperTest.fhn(class_3102, fhi);
                break;
            }
            case 140: {
                ServerHelperTest.fho(class_3102, false);
                ServerHelperTest.fhr(class_3102, "B", class_1802.field_8802);
                ServerHelperTest.fhs(class_3102, "B", 5, class_1802.field_8634, 4);
                ServerHelperTest.fht(class_3102, "B", 12, class_1802.field_8543, 7);
                ServerHelperTest.fht(class_3102, "B", 12, class_1802.field_8107, 32);
                ServerHelperTest.fht(class_3102, "B", 12, class_1802.field_8634, 0);
                ServerHelperTest.fhu(class_3102, "B", class_1802.field_8831, 2112);
                ServerHelperTest.fhw(class_3102, "B");
                ServerHelperTest.fhx("B");
                break;
            }
            case 150: {
                ServerHelperTest.fhp(class_3102, "minecraft:dirt 64");
                ServerHelperTest.fia(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                ServerHelperTest.fia(class_3102, "item replace entity @s inventory.3 with minecraft:bundle[bundle_contents=[{id:\"minecraft:snowball\",count:8,components:{\"minecraft:custom_name\":\"Снежок заморозка\"}},{id:\"minecraft:arrow\",count:32}]]");
                class_3102.field_1724.method_31548().method_61496(0);
                break;
            }
            case 170: {
                ServerHelperTest.fhn(class_3102, fhi);
                break;
            }
            case 200: {
                ServerHelperTest.fhr(class_3102, "C", class_1802.field_8802);
                ServerHelperTest.fht(class_3102, "C", 12, class_1802.field_8543, 7);
                ServerHelperTest.fht(class_3102, "C", 12, class_1802.field_8107, 32);
                ServerHelperTest.fhu(class_3102, "C", class_1802.field_8831, 2176);
                ServerHelperTest.fhw(class_3102, "C");
                ServerHelperTest.fhx("C");
                break;
            }
            case 210: {
                ServerHelperTest.fhp(class_3102, "minecraft:dirt 64");
                ServerHelperTest.fia(class_3102, "item replace entity @s hotbar.0 with minecraft:air");
                ServerHelperTest.fia(class_3102, "item replace entity @s inventory.3 with minecraft:bundle[bundle_contents=[{id:\"minecraft:arrow\",count:16},{id:\"minecraft:snowball\",count:8,components:{\"minecraft:custom_name\":\"Снежок заморозка\"}}]]");
                class_3102.field_1724.method_31548().method_61496(0);
                break;
            }
            case 230: {
                ServerHelperTest.fhn(class_3102, fhi);
                break;
            }
            case 260: {
                ServerHelperTest.fhr(class_3102, "D", class_1802.field_8162);
                ServerHelperTest.fht(class_3102, "D", 12, class_1802.field_8543, 7);
                ServerHelperTest.fht(class_3102, "D", 12, class_1802.field_8107, 16);
                ServerHelperTest.fhw(class_3102, "D");
                ServerHelperTest.fhx("D");
                break;
            }
            case 270: {
                KeyUtil.simulated = null;
                fgx.clear();
                System.out.println("bundle test " + (fhf == 0 ? "PASS" : "FAIL (" + fhf + ")"));
                return true;
            }
        }
        if (n > fhk && n < fhk + 8 && class_3102.field_1724 != null) {
            System.out.println("bundle t" + n + ": busy=" + ServerHelper.busy() + " hand=" + class_3102.field_1724.method_6047() + " cursor=" + class_3102.field_1724.field_7498.method_34255() + " pitch=" + class_3102.field_1724.method_36455());
        }
        return false;
    }

    private static void fhn(class_310 class_3102, int n) {
        fhc = 0;
        fhd = 0;
        fgy.setLength(0);
        fgz = true;
        fhk = fhe;
        fhh.onKey(class_3102, n);
    }

    private static void fho(class_310 class_3102, boolean bl) {
        int n = 87;
        int n2 = 341;
        if (bl) {
            fgx.add(n);
            fgx.add(n2);
        } else {
            fgx.remove(n);
            fgx.remove(n2);
        }
        class_3102.field_1690.field_1894.method_23481(bl);
        class_3102.field_1690.field_1867.method_23481(bl);
    }

    private static void fhp(class_310 class_3102, String string) {
        int n;
        ServerHelperTest.fia(class_3102, "kill @e[type=item]");
        ServerHelperTest.fia(class_3102, "clear @s");
        for (n = 0; n < 9; ++n) {
            ServerHelperTest.fia(class_3102, "item replace entity @s hotbar." + n + " with " + string);
        }
        for (n = 0; n < 27; ++n) {
            ServerHelperTest.fia(class_3102, "item replace entity @s inventory." + n + " with " + string);
        }
    }

    private static class_3222 fhq(class_310 class_3102) {
        return class_3102.method_1576().method_3760().method_14602(class_3102.field_1724.method_5667());
    }

    private static void fhr(class_310 class_3102, String string, class_1792 class_17922) {
        class_1799 class_17992 = ServerHelperTest.fhq(class_3102).method_6047();
        ServerHelperTest.fhy(string, class_17922 == class_1802.field_8162 ? class_17992.method_7960() : class_17992.method_31574(class_17922), "hand=" + class_17992);
        ServerHelperTest.fhy(string, class_3102.field_1724.field_7498.method_34255().method_7960() && ServerHelperTest.fhq((class_310)class_3102).field_7498.method_34255().method_7960(), "cursor not empty");
        ServerHelperTest.fhy(string, !ServerHelper.busy(), "still busy");
    }

    private static void fhs(class_310 class_3102, String string, int n, class_1792 class_17922, int n2) {
        class_1799 class_17992 = ServerHelperTest.fhq(class_3102).method_31548().method_5438(n);
        ServerHelperTest.fhy(string, class_17992.method_31574(class_17922) && class_17992.method_7947() == n2, "slot" + n + "=" + class_17992);
    }

    private static void fht(class_310 class_3102, String string, int n, class_1792 class_17922, int n2) {
        class_9276 class_92762 = CursorStack.contents(ServerHelperTest.fhq(class_3102).method_31548().method_5438(n));
        int n3 = 0;
        if (class_92762 != null) {
            for (class_1799 class_17992 : class_92762.method_57421()) {
                if (!class_17992.method_31574(class_17922)) continue;
                n3 += class_17992.method_7947();
            }
        }
        ServerHelperTest.fhy(string, n3 == n2, "bundle " + class_17922 + "=" + n3 + " expected " + n2 + " (" + class_92762 + ")");
    }

    private static void fhu(class_310 class_3102, String string, class_1792 class_17922, int n) {
        class_1661 class_16612 = ServerHelperTest.fhq(class_3102).method_31548();
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            if (!class_16612.method_5438(i).method_31574(class_17922)) continue;
            n2 += class_16612.method_5438(i).method_7947();
        }
        ServerHelperTest.fhy(string, n2 == n, "total " + class_17922 + "=" + n2 + " expected " + n);
    }

    private static void fhv(class_310 class_3102, String string) {
        class_1661 class_16612 = ServerHelperTest.fhq(class_3102).method_31548();
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            ServerHelperTest.fhy(string, i == 0 || i == 12 || class_17992.method_7960(), "leftover slot" + i + "=" + class_17992);
        }
    }

    private static void fhw(class_310 class_3102, String string) {
        class_3222 class_32222 = ServerHelperTest.fhq(class_3102);
        int n = class_32222.method_51469().method_8390(class_1542.class, class_32222.method_5829().method_1014(16.0), class_15422 -> true).size();
        ServerHelperTest.fhy(string, n == 0, "dropped items=" + n);
    }

    private static void fhx(String string) {
        fgz = false;
        System.out.println("bundle " + string + ": clicks=" + fhc + " violations=" + fhd + " trail=" + fgy);
        ServerHelperTest.fhy(string, fhd == 0, "MultiActions would flag");
    }

    private static void fhy(String string, boolean bl, String string2) {
        if (!bl) {
            ++fhf;
            System.out.println("bundle " + string + " FAIL " + string2);
        }
    }

    private static Module fhz(String string, boolean bl) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
        return kfe2;
    }

    private static void fia(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fib(class_310 class_3102) throws Exception {
        if (fhg) {
            return;
        }
        class_3222 class_32222 = ServerHelperTest.fhq(class_3102);
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
        channel.pipeline().addBefore("packet_handler", "flow2_bundle_recorder", (ChannelHandler)new fgs());
        fhg = true;
    }

    private static void fic(Object object) {
        if (object instanceof class_2851) {
            boolean bl;
            class_2851 class_28512 = (class_2851)object;
            class_10185 class_101852 = class_28512.comp_3139();
            boolean bl2 = bl = class_101852.comp_3159() || class_101852.comp_3160() || class_101852.comp_3161() || class_101852.comp_3162() || class_101852.comp_3163() || class_101852.comp_3164();
            if (bl != fha) {
                ServerHelperTest.fie(bl ? "input" : "idle");
            }
            fha = bl;
        } else if (object instanceof class_2848) {
            class_2848 class_28482 = (class_2848)object;
            if (class_28482.method_12365() == class_2848.class_2849.field_12981) {
                fhb = true;
                ServerHelperTest.fie("sprint");
            } else if (class_28482.method_12365() == class_2848.class_2849.field_12985) {
                fhb = false;
                ServerHelperTest.fie("stopSprint");
            }
        } else if (object instanceof class_2868) {
            class_2868 class_28682 = (class_2868)object;
            ServerHelperTest.fie("select" + class_28682.method_12442());
        } else if (object instanceof class_2886) {
            ServerHelperTest.fie("USE");
        } else if (object instanceof class_9837) {
            class_9837 class_98372 = (class_9837)object;
            ServerHelperTest.fie("bsel" + class_98372.comp_2894() + "/" + class_98372.comp_2895());
        } else if (object instanceof class_2813) {
            class_2813 class_28132 = (class_2813)object;
            ++fhc;
            ServerHelperTest.fie("CLICK" + class_28132.comp_3844() + "/" + class_28132.comp_3845() + "/" + class_28132.comp_3846());
            ServerHelperTest.fid();
        } else if (object instanceof class_2815) {
            ServerHelperTest.fie("CLOSE");
            ServerHelperTest.fid();
        }
    }

    private static void fid() {
        if (fgz && (fha || fhb)) {
            ++fhd;
            ServerHelperTest.fie("!VIOLATION");
        }
    }

    private static void fie(String string) {
        if (fgz && fgy.length() < 800) {
            fgy.append(' ').append(fhe).append(':').append(string);
        }
    }

    static {
        fhi = 75;
        fhj = 74;
    }

    private static /* synthetic */ int oo(int n, int n2) {
        return n ^ n2 ^ 0x67D18ED4;
    }

    private static /* synthetic */ int op(int n, int n2) {
        return ServerHelperTest.oo(n, n2) + n;
    }
}

