/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 */
package a;

import a.Module;
import a.WeatherSeasonPass;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;

final class WeatherTest {
    private static String hgr;
    private static int hgs;
    private static /* synthetic */ long hgt;
    private static /* synthetic */ int hgu;

    private WeatherTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
        if (n == hgs) {
            WeatherTest.hgy(class_3102, "winterplants-" + hgr);
        }
        switch (n) {
            case 1: {
                WeatherTest.hgx(class_3102, "gamemode creative");
                WeatherTest.hgx(class_3102, "time set 2500");
                WeatherTest.hgx(class_3102, "weather clear");
                WeatherTest.hgx(class_3102, "gamerule doDaylightCycle false");
                WeatherTest.hgx(class_3102, "tp @s 0 ~ 0");
                break;
            }
            case 3: {
                WeatherTest.hgx(class_3102, "fill -12 ~ -4 12 ~8 16 minecraft:air");
                break;
            }
            case 4: {
                WeatherTest.hgx(class_3102, "fill -12 ~-1 -4 12 ~-1 16 minecraft:grass_block");
                break;
            }
            case 5: {
                WeatherTest.hgx(class_3102, "fill -5 ~ 3 -1 ~ 7 minecraft:short_grass");
                break;
            }
            case 6: {
                WeatherTest.hgx(class_3102, "setblock 1 ~ 4 minecraft:poppy");
                WeatherTest.hgx(class_3102, "setblock 2 ~ 5 minecraft:dandelion");
                WeatherTest.hgx(class_3102, "setblock 1 ~ 6 minecraft:cornflower");
                WeatherTest.hgx(class_3102, "setblock 3 ~ 3 minecraft:fern");
                WeatherTest.hgx(class_3102, "setblock 0 ~ 9 minecraft:birch_sapling");
                break;
            }
            case 7: {
                WeatherTest.hgx(class_3102, "setblock 2 ~ 7 minecraft:tall_grass[half=lower]");
                WeatherTest.hgx(class_3102, "setblock 2 ~1 7 minecraft:tall_grass[half=upper]");
                break;
            }
            case 8: {
                WeatherTest.hgx(class_3102, "fill 6 ~-1 8 6 ~-1 10 minecraft:water");
                WeatherTest.hgx(class_3102, "fill 5 ~ 8 5 ~2 10 minecraft:sugar_cane");
                break;
            }
            case 9: {
                WeatherTest.hgx(class_3102, "fill -8 ~ 8 -6 ~1 10 minecraft:oak_leaves[persistent=true]");
                break;
            }
            case 10: {
                WeatherTest.hgx(class_3102, "fill 8 ~ 4 10 ~2 6 minecraft:spruce_leaves[persistent=true]");
                break;
            }
            case 11: {
                WeatherTest.hgx(class_3102, "fill -8 ~ 2 -6 ~1 4 minecraft:birch_leaves[persistent=true]");
                break;
            }
            case 12: {
                WeatherTest.hgx(class_3102, "fill -3 ~ 12 -3 ~3 12 minecraft:oak_log");
                break;
            }
            case 13: {
                WeatherTest.hgx(class_3102, "fill -5 ~3 10 -1 ~4 14 minecraft:oak_leaves[persistent=true] keep");
                break;
            }
            case 30: {
                WeatherTest.hgv(class_3102, 0.0f, 28.0f, "vanilla-day", n);
                break;
            }
            case 40: {
                ((ModeSetting)WeatherTest.hgw(kfe2, "Season")).set("Winter");
                ((NumberSetting)WeatherTest.hgw(kfe2, "Particles")).set(0.25);
                kfe2.setEnabled(true);
                WeatherSeasonPass.timing(true);
                break;
            }
            case 60: {
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 70: {
                System.out.println("winterplants RenderPerfTest day " + WeatherSeasonPass.gpuMillis() + " ms");
                WeatherTest.hgv(class_3102, 0.0f, 28.0f, "day", n);
                break;
            }
            case 85: {
                WeatherTest.hgx(class_3102, "tp @s 0 ~ 2");
                WeatherTest.hgv(class_3102, 0.0f, 42.0f, "day-close", n);
                break;
            }
            case 105: {
                WeatherTest.hgv(class_3102, 45.0f, 18.0f, "day-leaves", n);
                break;
            }
            case 120: {
                WeatherTest.hgv(class_3102, -35.0f, 4.0f, "day-cane", n);
                break;
            }
            case 135: {
                WeatherTest.hgv(class_3102, 20.0f, -5.0f, "day-tree", n);
                break;
            }
            case 150: {
                WeatherTest.hgv(class_3102, -78.0f, 8.0f, "day-spruce", n);
                break;
            }
            case 165: {
                WeatherTest.hgv(class_3102, 92.0f, 14.0f, "day-birch", n);
                break;
            }
            case 180: {
                WeatherTest.hgx(class_3102, "time set 18000");
                WeatherTest.hgx(class_3102, "summon minecraft:zombie 0 ~ 6 {NoAI:1b,PersistenceRequired:1b,Rotation:[180f,0f]}");
                WeatherTest.hgx(class_3102, "summon minecraft:creeper 2 ~ 8 {NoAI:1b,PersistenceRequired:1b,Rotation:[200f,0f]}");
                WeatherTest.hgx(class_3102, "summon minecraft:pig -2 ~ 7 {NoAI:1b,PersistenceRequired:1b,Rotation:[150f,0f]}");
                break;
            }
            case 190: {
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 200: {
                System.out.println("winterplants RenderPerfTest night " + WeatherSeasonPass.gpuMillis() + " ms");
                WeatherTest.hgv(class_3102, 0.0f, 20.0f, "night-mobs", n);
                break;
            }
            case 215: {
                WeatherTest.hgx(class_3102, "tp @s 0 ~ 3.5");
                WeatherTest.hgv(class_3102, 0.0f, 12.0f, "night-zombie", n);
                break;
            }
            case 230: {
                WeatherTest.hgv(class_3102, 60.0f, 14.0f, "night-leaves", n);
                break;
            }
            case 245: {
                WeatherTest.hgv(class_3102, 22.0f, -5.0f, "night-tree", n);
                break;
            }
            case 260: {
                WeatherTest.hgx(class_3102, "time set 2500");
                WeatherTest.hgv(class_3102, 0.0f, 12.0f, "day-zombie", n);
                break;
            }
            case 262: {
                WeatherSeasonPass.gpuMillis();
                break;
            }
            case 274: {
                System.out.println("winterplants RenderPerfTest day2 " + WeatherSeasonPass.gpuMillis() + " ms");
                break;
            }
            case 275: {
                kfe2.setEnabled(false);
                WeatherTest.hgv(class_3102, 0.0f, 12.0f, "day-zombie-off", n);
                break;
            }
            case 290: {
                WeatherSeasonPass.timing(false);
                WeatherTest.hgx(class_3102, "gamerule doDaylightCycle true");
                return true;
            }
        }
        return false;
    }

    private static void hgv(class_310 class_3102, float f, float f2, String string, int n) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
        hgr = string;
        hgs = n + 10;
    }

    private static Setting hgw(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void hgx(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void hgy(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        hgs = -1;
    }

    private static /* synthetic */ int zw(int n, int n2) {
        return n + n2 | 0x93706DC;
    }
}

