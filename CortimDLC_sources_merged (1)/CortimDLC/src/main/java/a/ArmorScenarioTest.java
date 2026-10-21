/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792$class_9635
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1836
 *  net.minecraft.class_276
 *  net.minecraft.class_303
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 */
package a;

import a.Module;
import a.KeySetting;
import a.Setting;
import a.KeyUtil;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1836;
import net.minecraft.class_276;
import net.minecraft.class_303;
import net.minecraft.class_310;
import net.minecraft.class_318;

final class ArmorScenarioTest {
    private static final Set<Integer> gmm = ConcurrentHashMap.newKeySet();
    private static int gmn;
    private static int gmo;
    private static /* synthetic */ int gmp;
    private static /* synthetic */ long gmq;

    private ArmorScenarioTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        switch (n) {
            case 1: {
                KeyUtil.simulated = gmm::contains;
                ArmorScenarioTest.gmv(class_3102, "gamemode survival");
                ArmorScenarioTest.gmv(class_3102, "effect give @s saturation 600 4 true");
                ArmorScenarioTest.gmv(class_3102, "clear @s");
                break;
            }
            case 10: {
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.3 with minecraft:diamond_chestplate");
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.4 with minecraft:iron_boots");
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.5 with minecraft:bundle[minecraft:bundle_contents=[{id:\"minecraft:netherite_helmet\",count:1}]]");
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.6 with minecraft:diamond_leggings[minecraft:damage=494]");
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.7 with minecraft:diamond_leggings");
                break;
            }
            case 20: {
                ArmorScenarioTest.gmt("AutoArmor", true);
                break;
            }
            case 60: {
                ArmorScenarioTest.gms("AutoArmor chest", ArmorScenarioTest.gmr(class_3102, class_1304.field_6174).method_31574(class_1802.field_8058), ArmorScenarioTest.gmr(class_3102, class_1304.field_6174));
                ArmorScenarioTest.gms("AutoArmor head (bundle)", ArmorScenarioTest.gmr(class_3102, class_1304.field_6169).method_31574(class_1802.field_22027), ArmorScenarioTest.gmr(class_3102, class_1304.field_6169));
                ArmorScenarioTest.gms("AutoArmor no iron", ArmorScenarioTest.gmr(class_3102, class_1304.field_6166).method_7960(), ArmorScenarioTest.gmr(class_3102, class_1304.field_6166));
                class_1799 class_17992 = ArmorScenarioTest.gmr(class_3102, class_1304.field_6172);
                ArmorScenarioTest.gms("AutoArmor legs", class_17992.method_31574(class_1802.field_8348) && class_17992.method_7919() == 0, class_17992);
                break;
            }
            case 70: {
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s armor.legs with minecraft:diamond_leggings[minecraft:damage=494]");
                break;
            }
            case 75: {
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.7 with minecraft:diamond_leggings");
                break;
            }
            case 110: {
                class_1799 class_17993 = ArmorScenarioTest.gmr(class_3102, class_1304.field_6172);
                ArmorScenarioTest.gms("AutoArmor breaking swap", class_17993.method_7919() == 0, class_17993);
                ArmorScenarioTest.gmt("AutoArmor", false);
                break;
            }
            case 120: {
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.10 with minecraft:elytra");
                Module kfe2 = ArmorScenarioTest.gmt("ElytraSwap", true);
                int n2 = 0;
                for (Setting vmo2 : kfe2.getSettings()) {
                    if (!(vmo2 instanceof KeySetting)) continue;
                    KeySetting vlq2 = (KeySetting)vmo2;
                    vlq2.set(n2++ == 0 ? 74 : 75);
                }
                ArmorScenarioTest.gms("ElytraSwap two settings", kfe2.getSettings().size() == 2 && n2 == 2, kfe2.getSettings().size());
                break;
            }
            case 130: {
                gmm.add(74);
                break;
            }
            case 133: {
                gmm.remove(74);
                break;
            }
            case 160: {
                ArmorScenarioTest.gms("ElytraSwap on", ArmorScenarioTest.gmr(class_3102, class_1304.field_6174).method_31574(class_1802.field_8833), ArmorScenarioTest.gmr(class_3102, class_1304.field_6174));
                gmm.add(74);
                break;
            }
            case 163: {
                gmm.remove(74);
                break;
            }
            case 190: {
                ArmorScenarioTest.gms("ElytraSwap back", ArmorScenarioTest.gmr(class_3102, class_1304.field_6174).method_31574(class_1802.field_8058), ArmorScenarioTest.gmr(class_3102, class_1304.field_6174));
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s inventory.20 with minecraft:firework_rocket 16");
                class_3102.field_1724.method_36457(90.0f);
                gmo = class_3102.field_1724.method_31548().method_67532();
                break;
            }
            case 195: {
                gmm.add(75);
                break;
            }
            case 197: {
                gmm.remove(75);
                break;
            }
            case 230: {
                int n3 = 0;
                for (int i = 0; i < class_3102.field_1724.method_31548().method_5439(); ++i) {
                    class_1799 class_17994 = class_3102.field_1724.method_31548().method_5438(i);
                    if (!class_17994.method_31574(class_1802.field_8639)) continue;
                    n3 += class_17994.method_7947();
                }
                ArmorScenarioTest.gms("ElytraSwap firework used", n3 == 15, n3);
                ArmorScenarioTest.gms("ElytraSwap firework back in place", class_3102.field_1724.method_31548().method_5438(29).method_31574(class_1802.field_8639) && class_3102.field_1724.method_31548().method_67532() == gmo, class_3102.field_1724.method_31548().method_5438(29));
                ArmorScenarioTest.gmt("ElytraSwap", false);
                class_3102.field_1724.method_36457(0.0f);
                break;
            }
            case 240: {
                ArmorScenarioTest.gmt("NameProtect", true);
                String string = class_3102.method_1548().method_1676();
                ArmorScenarioTest.gmv(class_3102, "scoreboard objectives add np dummy \"Профиль " + string + "\"");
                ArmorScenarioTest.gmv(class_3102, "scoreboard objectives setdisplay sidebar np");
                ArmorScenarioTest.gmv(class_3102, "scoreboard players set " + string + " np 7");
                ArmorScenarioTest.gmv(class_3102, "scoreboard players set Ник:" + string + " np 3");
                ArmorScenarioTest.gmv(class_3102, "bossbar add flow:np \"Босс для " + string + "\"");
                ArmorScenarioTest.gmv(class_3102, "bossbar set flow:np players @s");
                ArmorScenarioTest.gmv(class_3102, "item replace entity @s hotbar.1 with minecraft:paper[minecraft:lore=['\"Владелец: " + string + "\"']]");
                break;
            }
            case 245: {
                ArmorScenarioTest.gmv(class_3102, "tellraw @s \"hello " + class_3102.method_1548().method_1676() + " here\"");
                break;
            }
            case 248: {
                ArmorScenarioTest.gmv(class_3102, "title @s title \"Привет, " + class_3102.method_1548().method_1676() + "\"");
                break;
            }
            case 252: {
                String string = ArmorScenarioTest.gmu(class_3102);
                ArmorScenarioTest.gms("NameProtect chat", string.contains("Flow") && !string.contains(class_3102.method_1548().method_1676()), string);
                class_1799 class_17995 = class_3102.field_1724.method_31548().method_5438(1);
                String string2 = class_17995.method_7950(class_1792.class_9635.field_51353, (class_1657)class_3102.field_1724, (class_1836)class_1836.field_41070).toString();
                ArmorScenarioTest.gms("NameProtect leaves lore to modules", string2.contains(class_3102.method_1548().method_1676()), string2);
                class_3102.field_1690.field_1907.method_23481(true);
                break;
            }
            case 256: {
                ArmorScenarioTest.gmw(class_3102, "newmods-nameprotect");
                break;
            }
            case 258: {
                class_3102.field_1690.field_1907.method_23481(false);
                ArmorScenarioTest.gmt("NameProtect", false);
                break;
            }
            case 262: {
                ArmorScenarioTest.gmw(class_3102, "newmods-nameprotect-off");
                break;
            }
            case 264: {
                String string = class_3102.method_1548().method_1676();
                ArmorScenarioTest.gmv(class_3102, "scoreboard objectives remove np");
                ArmorScenarioTest.gmv(class_3102, "bossbar remove flow:np");
                ArmorScenarioTest.gmv(class_3102, "title @s clear");
                ArmorScenarioTest.gms("NameProtect off restores", !string.isEmpty(), string);
                break;
            }
            case 270: {
                ArmorScenarioTest.gmw(class_3102, "newmods-plain");
                break;
            }
            case 275: {
                ArmorScenarioTest.gmt("AspectRatio", true);
                break;
            }
            case 285: {
                ArmorScenarioTest.gmw(class_3102, "newmods-aspect");
                break;
            }
            case 290: {
                ArmorScenarioTest.gmt("AspectRatio", false);
                System.out.println("self test newmods: " + (gmn == 0 ? "ALL PASS" : gmn + " FAIL"));
                KeyUtil.simulated = null;
                return true;
            }
        }
        return false;
    }

    private static class_1799 gmr(class_310 class_3102, class_1304 class_13042) {
        return class_3102.field_1724.method_6118(class_13042);
    }

    private static void gms(String string, boolean bl, Object object) {
        if (!bl) {
            ++gmn;
        }
        System.out.println("self test newmods " + (bl ? "PASS " : "FAIL ") + string + " -> " + object);
    }

    private static Module gmt(String string, boolean bl) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 == null) {
            System.out.println("self test newmods FAIL no module " + string);
            ++gmn;
            return null;
        }
        kfe2.setEnabled(bl);
        System.out.println("self test newmods " + string + " enabled=" + kfe2.isEnabled());
        return kfe2;
    }

    private static String gmu(class_310 class_3102) {
        try {
            for (Field field : class_3102.field_1705.method_1743().getClass().getDeclaredFields()) {
                Object e;
                if (!List.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                List list = (List)field.get(class_3102.field_1705.method_1743());
                if (list.isEmpty() || !((e = list.get(0)) instanceof class_303)) continue;
                class_303 class_3032 = (class_303)e;
                return class_3032.comp_893().getString();
            }
        }
        catch (Exception exception) {
            return "? " + exception;
        }
        return "";
    }

    private static void gmv(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void gmw(class_310 class_3102, String string) {
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int ux(int n, int n2) {
        return (n ^ n2) + 1023961257;
    }

    private static /* synthetic */ int uy(int n, int n2) {
        return ArmorScenarioTest.ux(n, n2) * n2;
    }
}

