/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_10185
 *  net.minecraft.class_1132
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2338
 *  net.minecraft.class_2535
 *  net.minecraft.class_2813
 *  net.minecraft.class_2815
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2851
 *  net.minecraft.class_2868
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_3222
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_746
 *  net.minecraft.class_8609
 */
package a;

import a.hbq;
import a.Module;
import a.AutoTotem;
import a.AutoMend;
import a.NumberSetting;
import a.Setting;
import a.IdleTracker;
import a.KeyUtil;
import flow.Flow;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_10185;
import net.minecraft.class_1132;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2338;
import net.minecraft.class_2535;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_2846;
import net.minecraft.class_2848;
import net.minecraft.class_2851;
import net.minecraft.class_2868;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3222;
import net.minecraft.class_3675;
import net.minecraft.class_746;
import net.minecraft.class_8609;

final class AutoTotemTest {
    private static final Set<Integer> hbu = ConcurrentHashMap.newKeySet();
    private static final AtomicInteger hbv = new AtomicInteger();
    private static final AtomicInteger hbw = new AtomicInteger();
    private static final StringBuffer hbx = new StringBuffer();
    private static volatile boolean hby;
    private static volatile boolean hbz;
    private static volatile boolean hca;
    private static volatile boolean hcb;
    private static volatile int hcc;
    private static boolean hcd;
    private static int hce;
    private static boolean hcf;
    private static class_2338 hcg;
    private static int hch;
    private static int hci;
    private static /* synthetic */ long hcj;
    private static /* synthetic */ String hck;

    private AutoTotemTest() {
    }

    static boolean totem(class_310 class_3102, int n) throws Exception {
        class_746 class_7462 = class_3102.field_1724;
        hcc = n;
        switch (n) {
            case 1: {
                KeyUtil.simulated = hbu::contains;
                AutoTotemTest.hcr(class_3102, "AutoSprint", false);
                Module kfe2 = AutoTotemTest.hcr(class_3102, "AutoTotem", true);
                for (Setting vmo2 : kfe2.getSettings()) {
                    NumberSetting vmc2;
                    if (!(vmo2 instanceof NumberSetting) || !(vmc2 = (NumberSetting)vmo2).getName().equals("Порог здоровья")) continue;
                    vmc2.set(12.0);
                }
                AutoTotemTest.hdf(class_3102, "gamemode survival");
                AutoTotemTest.hdf(class_3102, "effect give @s saturation 600 4 true");
                break;
            }
            case 5: {
                AutoTotemTest.hdg(class_3102);
                break;
            }
            case 10: {
                AutoTotemTest.hdf(class_3102, "clear @s");
                AutoTotemTest.hdf(class_3102, "item replace entity @s weapon.offhand with minecraft:shield");
                AutoTotemTest.hdf(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                AutoTotemTest.hdf(class_3102, "item replace entity @s inventory.5 with minecraft:totem_of_undying[minecraft:enchantment_glint_override=true]");
                AutoTotemTest.hdf(class_3102, "item replace entity @s inventory.6 with minecraft:totem_of_undying");
                AutoTotemTest.hdf(class_3102, "item replace entity @s inventory.7 with minecraft:totem_of_undying");
                class_7462.method_31548().method_61496(0);
                AutoTotemTest.hcs(class_3102, 20.0f);
                break;
            }
            case 20: {
                AutoTotemTest.hco(class_3102, true, true);
                break;
            }
            case 35: {
                AutoTotemTest.hde();
                AutoTotemTest.hcs(class_3102, 5.0f);
                break;
            }
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: {
                AutoTotemTest.hcz(class_3102, "A", n);
                break;
            }
            case 50: {
                AutoTotemTest.hdb("A", AutoTotemTest.hcu(class_3102).method_31574(class_1802.field_8288) && !AutoTotemTest.hcu(class_3102).method_7958(), "offhand=" + AutoTotemTest.hcy(AutoTotemTest.hcu(class_3102)));
                AutoTotemTest.hdb("A", AutoTotemTest.hcv(class_3102, 15).method_31574(class_1802.field_8255), "slot15=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 15)));
                AutoTotemTest.hdc("A");
                break;
            }
            case 55: {
                AutoTotemTest.hde();
                AutoTotemTest.hcs(class_3102, 20.0f);
                break;
            }
            case 56: 
            case 57: 
            case 58: 
            case 59: {
                AutoTotemTest.hcz(class_3102, "B", n);
                break;
            }
            case 70: {
                AutoTotemTest.hdb("B", AutoTotemTest.hcu(class_3102).method_31574(class_1802.field_8255), "offhand=" + AutoTotemTest.hcy(AutoTotemTest.hcu(class_3102)));
                AutoTotemTest.hdb("B", AutoTotemTest.hcv(class_3102, 15).method_31574(class_1802.field_8288), "slot15=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 15)));
                AutoTotemTest.hdc("B");
                break;
            }
            case 75: {
                AutoTotemTest.hde();
                AutoTotemTest.hcs(class_3102, 5.0f);
                break;
            }
            case 90: {
                AutoTotemTest.hdf(class_3102, "damage @s 40 minecraft:generic");
                break;
            }
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: {
                AutoTotemTest.hcz(class_3102, "C", n);
                break;
            }
            case 105: {
                AutoTotemTest.hdb("C", class_3102.field_1724.method_5805() && AutoTotemTest.hct(class_3102).method_5805(), "dead");
                AutoTotemTest.hdb("C", AutoTotemTest.hcu(class_3102).method_31574(class_1802.field_8288), "offhand=" + AutoTotemTest.hcy(AutoTotemTest.hcu(class_3102)));
                AutoTotemTest.hdb("C", AutoTotemTest.hcv(class_3102, 16).method_7960(), "slot16=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 16)));
                AutoTotemTest.hdb("C", AutoTotemTest.hcv(class_3102, 15).method_31574(class_1802.field_8255), "slot15=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 15)));
                AutoTotemTest.hdc("C");
                break;
            }
            case 110: {
                AutoTotemTest.hde();
                AutoTotemTest.hdf(class_3102, "effect clear @s minecraft:absorption");
                AutoTotemTest.hdf(class_3102, "effect clear @s minecraft:regeneration");
                AutoTotemTest.hcs(class_3102, 20.0f);
                break;
            }
            case 125: {
                AutoTotemTest.hdb("D", AutoTotemTest.hcu(class_3102).method_31574(class_1802.field_8255), "offhand=" + AutoTotemTest.hcy(AutoTotemTest.hcu(class_3102)));
                AutoTotemTest.hdb("D", AutoTotemTest.hcv(class_3102, 15).method_31574(class_1802.field_8288), "slot15=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 15)));
                AutoTotemTest.hdc("D");
                break;
            }
            case 130: {
                AutoTotemTest.hco(class_3102, false, false);
                AutoTotemTest.hcp(class_3102, true);
                break;
            }
            case 140: {
                AutoTotemTest.hde();
                AutoTotemTest.hcs(class_3102, 5.0f);
                break;
            }
            case 141: 
            case 142: 
            case 143: 
            case 144: {
                AutoTotemTest.hcz(class_3102, "E", n);
                break;
            }
            case 155: {
                AutoTotemTest.hdb("E", AutoTotemTest.hcu(class_3102).method_31574(class_1802.field_8288), "offhand=" + AutoTotemTest.hcy(AutoTotemTest.hcu(class_3102)));
                AutoTotemTest.hdb("E", class_3102.field_1690.field_1832.method_1434(), "sneak not restored");
                AutoTotemTest.hdc("E");
                AutoTotemTest.hcp(class_3102, false);
                break;
            }
            case 160: {
                KeyUtil.simulated = null;
                hbu.clear();
                System.out.println("totem test " + (hce == 0 ? "PASS" : "FAIL (" + hce + ")"));
                return true;
            }
        }
        if (n > 20 && n < 130) {
            class_3102.field_1690.field_1894.method_23481(true);
        }
        return false;
    }

    static boolean tool(class_310 class_3102, int n) throws Exception {
        class_746 class_7462 = class_3102.field_1724;
        hcc = n;
        AutoTotemTest.hcq(class_3102);
        switch (n) {
            case 1: {
                KeyUtil.simulated = hbu::contains;
                AutoTotemTest.hcr(class_3102, "AutoSprint", false);
                AutoTotemTest.hcr(class_3102, "TriggerBot", false);
                AutoTotemTest.hcr(class_3102, "AutoTool", true);
                AutoTotemTest.hdf(class_3102, "gamemode survival");
                AutoTotemTest.hdf(class_3102, "effect give @s saturation 600 4 true");
                AutoTotemTest.hdf(class_3102, "effect give @s resistance 600 4 true");
                break;
            }
            case 5: {
                AutoTotemTest.hdg(class_3102);
                break;
            }
            case 10: {
                AutoTotemTest.hdf(class_3102, "clear @s");
                AutoTotemTest.hdf(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                AutoTotemTest.hdf(class_3102, "item replace entity @s hotbar.4 with minecraft:diamond_axe");
                AutoTotemTest.hdf(class_3102, "item replace entity @s inventory.1 with minecraft:diamond_pickaxe");
                AutoTotemTest.hdf(class_3102, "item replace entity @s inventory.2 with minecraft:diamond_shovel");
                class_7462.method_31548().method_61496(0);
                class_2338 class_23382 = class_7462.method_24515();
                AutoTotemTest.hdf(class_3102, "tp @s " + ((double)class_23382.method_10263() + 0.5) + " " + class_23382.method_10264() + " " + ((double)class_23382.method_10260() + 0.5) + " 0 0");
                hcg = class_23382.method_10069(0, 1, 2);
                AutoTotemTest.hdf(class_3102, "fill " + (hcg.method_10263() - 1) + " " + (hcg.method_10264() - 1) + " " + hcg.method_10260() + " " + (hcg.method_10263() + 1) + " " + (hcg.method_10264() + 2) + " " + (hcg.method_10260() + 1) + " minecraft:air");
                break;
            }
            case 15: {
                AutoTotemTest.hcl(class_3102, "minecraft:stone");
                break;
            }
            case 25: {
                AutoTotemTest.hde();
                AutoTotemTest.hcn(class_7462);
                AutoTotemTest.hcm(class_3102, true, n);
                break;
            }
            case 26: 
            case 27: 
            case 28: 
            case 29: {
                AutoTotemTest.hcz(class_3102, "A", n);
                break;
            }
            case 50: {
                AutoTotemTest.hdb("A", hch > 0 && hch - hci <= 12, "stone broke after " + (hch - hci));
                AutoTotemTest.hcm(class_3102, false, n);
                break;
            }
            case 70: {
                AutoTotemTest.hdb("A", AutoTotemTest.hcw(class_3102).method_31574(class_1802.field_8802) && AutoTotemTest.hcx(class_3102) == 0, "hand=" + AutoTotemTest.hcy(AutoTotemTest.hcw(class_3102)) + " slot=" + AutoTotemTest.hcx(class_3102));
                AutoTotemTest.hdb("A", AutoTotemTest.hcv(class_3102, 10).method_31574(class_1802.field_8377), "slot10=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 10)));
                AutoTotemTest.hdb("A", !AutoMend.busy(), "still busy");
                AutoTotemTest.hdc("A");
                break;
            }
            case 75: {
                AutoTotemTest.hcl(class_3102, "minecraft:dirt");
                break;
            }
            case 80: {
                AutoTotemTest.hco(class_3102, true, true);
                break;
            }
            case 90: {
                AutoTotemTest.hde();
                AutoTotemTest.hcn(class_7462);
                AutoTotemTest.hcm(class_3102, true, n);
                break;
            }
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: {
                AutoTotemTest.hcz(class_3102, "B", n);
                break;
            }
            case 110: {
                AutoTotemTest.hdb("B", hch > 0 && hch - hci <= 12, "dirt broke after " + (hch - hci));
                AutoTotemTest.hcm(class_3102, false, n);
                AutoTotemTest.hco(class_3102, false, false);
                break;
            }
            case 130: {
                AutoTotemTest.hdb("B", AutoTotemTest.hcw(class_3102).method_31574(class_1802.field_8802) && AutoTotemTest.hcx(class_3102) == 0, "hand=" + AutoTotemTest.hcy(AutoTotemTest.hcw(class_3102)) + " slot=" + AutoTotemTest.hcx(class_3102));
                AutoTotemTest.hdb("B", AutoTotemTest.hcv(class_3102, 11).method_31574(class_1802.field_8250), "slot11=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 11)));
                AutoTotemTest.hdc("B");
                break;
            }
            case 131: {
                class_2338 class_23383 = hcg.method_10069(0, -1, -2);
                AutoTotemTest.hdf(class_3102, "tp @s " + ((double)class_23383.method_10263() + 0.5) + " " + class_23383.method_10264() + " " + ((double)class_23383.method_10260() + 0.5) + " 0 0");
                break;
            }
            case 135: {
                AutoTotemTest.hcl(class_3102, "minecraft:oak_log");
                break;
            }
            case 145: {
                AutoTotemTest.hde();
                AutoTotemTest.hcn(class_7462);
                AutoTotemTest.hcm(class_3102, true, n);
                break;
            }
            case 146: 
            case 147: {
                AutoTotemTest.hcz(class_3102, "C", n);
                break;
            }
            case 170: {
                AutoTotemTest.hdb("C", hch > 0 && hch - hci <= 20, "log broke after " + (hch - hci));
                AutoTotemTest.hcm(class_3102, false, n);
                break;
            }
            case 185: {
                AutoTotemTest.hdb("C", AutoTotemTest.hcx(class_3102) == 0 && AutoTotemTest.hcw(class_3102).method_31574(class_1802.field_8802), "hand=" + AutoTotemTest.hcy(AutoTotemTest.hcw(class_3102)) + " slot=" + AutoTotemTest.hcx(class_3102));
                AutoTotemTest.hdd("C", false);
                break;
            }
            case 188: {
                AutoTotemTest.hcp(class_3102, true);
                break;
            }
            case 190: {
                AutoTotemTest.hcl(class_3102, "minecraft:stone");
                break;
            }
            case 195: {
                AutoTotemTest.hde();
                AutoTotemTest.hcn(class_7462);
                AutoTotemTest.hcm(class_3102, true, n);
                break;
            }
            case 196: 
            case 197: 
            case 198: 
            case 199: {
                AutoTotemTest.hcz(class_3102, "D", n);
                break;
            }
            case 215: {
                AutoTotemTest.hdb("D", hch > 0 && hch - hci <= 14, "stone broke after " + (hch - hci));
                AutoTotemTest.hcm(class_3102, false, n);
                break;
            }
            case 216: 
            case 218: 
            case 220: 
            case 221: 
            case 222: 
            case 223: 
            case 224: {
                AutoTotemTest.hcz(class_3102, "D", n);
                break;
            }
            case 232: {
                AutoTotemTest.hdb("D", AutoTotemTest.hcw(class_3102).method_31574(class_1802.field_8802) && AutoTotemTest.hcv(class_3102, 10).method_31574(class_1802.field_8377), "hand=" + AutoTotemTest.hcy(AutoTotemTest.hcw(class_3102)) + " slot10=" + AutoTotemTest.hcy(AutoTotemTest.hcv(class_3102, 10)));
                AutoTotemTest.hdb("D", class_3102.field_1690.field_1832.method_1434(), "sneak not restored");
                AutoTotemTest.hdc("D");
                AutoTotemTest.hcp(class_3102, false);
                break;
            }
            case 240: {
                KeyUtil.simulated = null;
                hbu.clear();
                hcf = false;
                System.out.println("tool test " + (hce == 0 ? "PASS" : "FAIL (" + hce + ")"));
                return true;
            }
        }
        if (n > 12) {
            AutoTotemTest.hcn(class_7462);
        }
        if (hcf) {
            class_3102.field_1690.field_1886.method_23481(true);
            if (hch == 0 && hcg != null && class_3102.method_1576().method_30002().method_8320(hcg).method_26215()) {
                hch = n;
            }
        }
        if (hbu.contains(87)) {
            class_3102.field_1690.field_1894.method_23481(true);
        }
        return false;
    }

    private static void hcl(class_310 class_3102, String string) {
        AutoTotemTest.hdf(class_3102, "setblock " + hcg.method_10263() + " " + hcg.method_10264() + " " + hcg.method_10260() + " " + string);
    }

    private static void hcm(class_310 class_3102, boolean bl, int n) {
        hcf = bl;
        class_304 class_3042 = class_3102.field_1690.field_1886;
        if (bl) {
            hci = n;
            hch = 0;
            class_304.method_1420((class_3675.class_306)KeyBindingHelper.getBoundKeyOf((class_304)class_3042));
            class_3042.method_23481(true);
        } else {
            class_3042.method_23481(false);
        }
    }

    private static void hcn(class_746 class_7462) {
        class_7462.method_36456(0.0f);
        class_7462.method_36457(0.0f);
    }

    private static void hco(class_310 class_3102, boolean bl, boolean bl2) {
        if (bl) {
            hbu.add(87);
            class_3102.field_1690.field_1894.method_23481(true);
            if (bl2) {
                hbu.add(341);
                class_3102.field_1690.field_1867.method_23481(true);
            }
        } else {
            hbu.remove(87);
            hbu.remove(341);
            class_3102.field_1690.field_1894.method_23481(false);
            class_3102.field_1690.field_1867.method_23481(false);
        }
    }

    private static void hcp(class_310 class_3102, boolean bl) {
        if (bl) {
            hbu.add(340);
        } else {
            hbu.remove(340);
        }
        class_3102.field_1690.field_1832.method_23481(bl);
    }

    private static void hcq(class_310 class_3102) throws Exception {
        for (Field field : class_312.class.getDeclaredFields()) {
            if (!field.getName().equals("cursorLocked")) continue;
            field.setAccessible(true);
            field.setBoolean(class_3102.field_1729, true);
        }
    }

    private static Module hcr(class_310 class_3102, String string, boolean bl) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
        return kfe2;
    }

    private static void hcs(class_310 class_3102, float f) {
        class_1132 class_11322 = class_3102.method_1576();
        class_3222 class_32222 = AutoTotemTest.hct(class_3102);
        class_11322.execute(() -> class_32222.method_6033(f));
    }

    private static class_3222 hct(class_310 class_3102) {
        return class_3102.method_1576().method_3760().method_14602(class_3102.field_1724.method_5667());
    }

    private static class_1799 hcu(class_310 class_3102) {
        return AutoTotemTest.hct(class_3102).method_6079();
    }

    private static class_1799 hcv(class_310 class_3102, int n) {
        return AutoTotemTest.hct(class_3102).method_31548().method_5438(n);
    }

    private static class_1799 hcw(class_310 class_3102) {
        return AutoTotemTest.hct(class_3102).method_6047();
    }

    private static int hcx(class_310 class_3102) {
        return AutoTotemTest.hct(class_3102).method_31548().method_67532();
    }

    private static String hcy(class_1799 class_17992) {
        class_1792 class_17922 = class_17992.method_7909();
        return class_17992.method_7960() ? "empty" : class_17922 + (class_17992.method_7958() ? "*" : "");
    }

    private static void hcz(class_310 class_3102, String string, int n) {
        class_746 class_7462 = class_3102.field_1724;
        System.out.println("swap " + string + " t" + n + ": hp=" + class_7462.method_6032() + " off=" + AutoTotemTest.hcy(class_7462.method_6079()) + " hand=" + AutoTotemTest.hcy(class_7462.method_6047()) + " totemBusy=" + AutoTotem.busy() + " toolBusy=" + AutoMend.busy() + " idle=" + IdleTracker.serverIdle(class_7462) + " BlackThemeTest=" + class_3102.field_1690.field_1894.method_1434() + " atk=" + class_3102.field_1690.field_1886.method_1434() + " breaking=" + class_3102.field_1761.method_2923() + " aim=" + (class_3102.field_1765 == null ? "null" : class_3102.field_1765.method_17783()) + " z=" + String.format("%.2f", class_7462.method_23321()) + " cd=" + AutoTotemTest.hda(class_3102, "attackCooldown") + " locked=" + class_3102.field_1729.method_1613());
    }

    private static String hda(Object object, String string) {
        try {
            Field field = object.getClass().getDeclaredField(string);
            field.setAccessible(true);
            return String.valueOf(field.get(object));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            return "?";
        }
    }

    private static void hdb(String string, boolean bl, String string2) {
        if (!bl) {
            ++hce;
            System.out.println("swap " + string + " FAIL " + string2);
        }
    }

    private static void hdc(String string) {
        AutoTotemTest.hdd(string, true);
    }

    private static void hdd(String string, boolean bl) {
        hcb = false;
        System.out.println("swap " + string + ": clicks=" + hbv.get() + " violations=" + hbw.get() + " trail=" + hbx);
        if (bl == (hbv.get() == 0)) {
            ++hce;
            System.out.println("swap " + string + " FAIL clicks=" + hbv.get() + " expected " + (bl ? ">0" : "0"));
        }
        if (hbw.get() != 0) {
            ++hce;
            System.out.println("swap " + string + " FAIL MultiActions would flag");
        }
    }

    private static void hde() {
        hbv.set(0);
        hbw.set(0);
        hbx.setLength(0);
        hcb = true;
    }

    private static void hdf(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void hdg(class_310 class_3102) throws Exception {
        if (hcd) {
            return;
        }
        class_3222 class_32222 = AutoTotemTest.hct(class_3102);
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
        channel.pipeline().addBefore("packet_handler", "flow2_swap_recorder", (ChannelHandler)new hbq());
        hcd = true;
    }

    private static void hdh(Object object) {
        if (object instanceof class_2851) {
            boolean bl;
            class_2851 class_28512 = (class_2851)object;
            class_10185 class_101852 = class_28512.comp_3139();
            boolean bl2 = bl = class_101852.comp_3159() || class_101852.comp_3160() || class_101852.comp_3161() || class_101852.comp_3162() || class_101852.comp_3163();
            if (hcb && (bl != hby || class_101852.comp_3164() != hbz)) {
                AutoTotemTest.hdi(bl || class_101852.comp_3164() ? "input" : "idle");
            }
            hby = bl;
            hbz = class_101852.comp_3164();
        } else if (object instanceof class_2848) {
            class_2848 class_28482 = (class_2848)object;
            if (class_28482.method_12365() == class_2848.class_2849.field_12981) {
                hca = true;
                AutoTotemTest.hdi("sprint");
            } else if (class_28482.method_12365() == class_2848.class_2849.field_12985) {
                hca = false;
                AutoTotemTest.hdi("stopSprint");
            }
        } else if (object instanceof class_2846) {
            class_2846 class_28462 = (class_2846)object;
            class_2846.class_2847 class_28472 = class_28462.method_12363();
            if (class_28472 == class_2846.class_2847.field_12968 || class_28472 == class_2846.class_2847.field_12971 || class_28472 == class_2846.class_2847.field_12973) {
                AutoTotemTest.hdi(class_28472.name());
            }
        } else if (object instanceof class_2868) {
            class_2868 class_28682 = (class_2868)object;
            AutoTotemTest.hdi("select" + class_28682.method_12442());
        } else if (object instanceof class_2813 || object instanceof class_2815) {
            boolean bl = object instanceof class_2813;
            if (bl) {
                hbv.incrementAndGet();
            }
            AutoTotemTest.hdi(bl ? "CLICK" : "CLOSE");
            if (hby || hbz || hca) {
                hbw.incrementAndGet();
                AutoTotemTest.hdi("!VIOLATION(moving=" + hby + ",sneak=" + hbz + ",sprint=" + hca + ")");
            }
        }
    }

    private static void hdi(String string) {
        if (hcb && hbx.length() < 600) {
            hbx.append(' ').append(hcc).append(':').append(string);
        }
    }

    private static /* synthetic */ int yt(int n, int n2) {
        return n * n2 + -917876198;
    }

    private static /* synthetic */ int yu(int n, int n2) {
        return AutoTotemTest.yt(n, n2) + n;
    }
}

