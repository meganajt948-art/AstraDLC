/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 */
package a;

import a.Hud;
import a.Module;
import a.ModuleManager;
import a.MobEsp;
import a.BoolSetting;
import a.ModeSetting;
import a.Setting;
import flow.Flow;
import flow.cosmetic.PetFollowTest;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;
import net.minecraft.class_1297;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;

final class MobEspTest {
    private static final String[] ghg = new String[]{"MobESP", "Nametags", "Arrows"};
    private static double ghh;
    private static double ghi;
    private static double ghj;
    private static /* synthetic */ int ghk;
    private static /* synthetic */ boolean ghl;

    private MobEspTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        switch (n) {
            case 1: {
                for (String string : ghg) {
                    MobEspTest.ghq(kfx2, string, false);
                }
                MobEspTest.ghw(class_3102, "gamemode creative");
                MobEspTest.ghw(class_3102, "time set 6000");
                MobEspTest.ghw(class_3102, "weather clear");
                MobEspTest.ghw(class_3102, "gamerule doMobSpawning false");
                ghh = Math.floor(class_3102.field_1724.method_23317()) + 0.5;
                ghi = Math.floor(class_3102.field_1724.method_23318());
                ghj = Math.floor(class_3102.field_1724.method_23321()) + 0.5;
                MobEspTest.ghw(class_3102, MobEspTest.ghp("tp @s %.1f %.1f %.1f 0 12", ghh, ghi, ghj));
                class_3102.field_1690.field_1842 = false;
                Hud.TARGET.enabled.set(false);
                break;
            }
            case 5: {
                MobEspTest.ghw(class_3102, MobEspTest.ghp("fill %d %d %d %d %d %d minecraft:air", -8, 0, 2, 8, 4, 20));
                MobEspTest.ghw(class_3102, MobEspTest.ghp("fill %d %d %d %d %d %d minecraft:stone", -7, 0, 9, 7, 3, 9));
                for (int i = 0; i < 30; ++i) {
                    int n2 = -6 + i % 10 * 4 / 3;
                    int n3 = 11 + i / 10 * 2;
                    MobEspTest.ghw(class_3102, MobEspTest.ghp("summon minecraft:villager %.1f %.1f %.1f {NoAI:1b,Rotation:[180f,0f]}", ghh + (double)n2, ghi, ghj + (double)n3));
                }
                MobEspTest.gho(class_3102, "magma_cube", -3.0, 5.0, "{NoAI:1b,Size:1}");
                MobEspTest.gho(class_3102, "magma_cube", -1.5, 6.0, "{NoAI:1b,Size:0}");
                MobEspTest.gho(class_3102, "iron_golem", 3.0, 6.0, "{NoAI:1b,Rotation:[180f,0f]}");
                MobEspTest.gho(class_3102, "wolf", 1.5, 4.0, "{NoAI:1b,Rotation:[180f,0f]}");
                MobEspTest.gho(class_3102, "cow", 0.0, 7.0, "{NoAI:1b,Rotation:[180f,0f]}");
                MobEspTest.gho(class_3102, "villager", 5.0, 4.0, "{NoAI:1b,CustomName:'\"Bob\"',Rotation:[180f,0f]}");
                break;
            }
            case 60: {
                MobEspTest.ghv(class_3102, 0.0f, 12.0f);
                MobEspTest.ghx(class_3102, "mob-plain");
                MobEspTest.ghq(kfx2, "MobESP", true);
                break;
            }
            case 80: {
                MobEspTest.ghx(class_3102, "mob-esp-outline");
                System.out.println("mob test entity fx failed: " + MobEspTest.ghu("flow.render.EntityFx", "failed") + ", picked around: " + MobEspTest.ghn(class_3102));
                MobEspTest.ghs(kfx2.getByName("MobESP"), "Mode", "Box");
                break;
            }
            case 100: {
                MobEspTest.ghx(class_3102, "mob-esp-box");
                MobEspTest.ghs(kfx2.getByName("MobESP"), "Mode", "Outline");
                MobEspTest.ghr(kfx2.getByName("Nametags"), "Mobs", true);
                MobEspTest.ghq(kfx2, "Nametags", true);
                break;
            }
            case 120: {
                MobEspTest.ghx(class_3102, "mob-tags");
                MobEspTest.ghr(kfx2.getByName("Arrows"), "Mobs", true);
                MobEspTest.ghq(kfx2, "Arrows", true);
                MobEspTest.ghv(class_3102, 180.0f, 12.0f);
                break;
            }
            case 140: {
                MobEspTest.ghv(class_3102, 180.0f, 12.0f);
                MobEspTest.ghx(class_3102, "mob-arrows");
                break;
            }
            case 141: {
                for (String string : ghg) {
                    MobEspTest.ghq(kfx2, string, false);
                }
                MobEspTest.ghr(kfx2.getByName("Nametags"), "Mobs", false);
                MobEspTest.ghr(kfx2.getByName("Arrows"), "Mobs", false);
                MobEspTest.ghw(class_3102, "kill @e[type=!player]");
                MobEspTest.ghw(class_3102, MobEspTest.ghp("tp @s %.1f %.1f %.1f 0 0", ghh, ghi, ghj - 6.0));
                MobEspTest.ghw(class_3102, MobEspTest.ghp("fill %d %d %d %d %d %d minecraft:stone_slab", -3, 0, -1, 3, 0, 6));
                Hud.TARGET.enabled.set(true);
                break;
            }
            default: {
                if (n <= 141) break;
                return MobEspTest.ghm(class_3102, n - 141);
            }
        }
        return false;
    }

    private static boolean ghm(class_310 class_3102, int n) {
        String string = PetFollowTest.step(class_3102, 0.05f);
        if (n < 120) {
            MobEspTest.ghv(class_3102, 0.0f, 0.0f);
        }
        switch (n) {
            case 20: {
                class_3102.field_1690.field_1894.method_23481(true);
                break;
            }
            case 60: {
                class_3102.field_1690.field_1894.method_23481(false);
                break;
            }
            case 100: {
                System.out.println("mob test pet: turning in place");
                break;
            }
        }
        if (n >= 100 && n < 140) {
            MobEspTest.ghv(class_3102, (float)(n - 100) * 9.0f, 0.0f);
        }
        if (n == 1 || n == 19 || n % 10 == 0 && n <= 160) {
            System.out.println("mob test pet t" + n + ": " + string + ", player y " + String.format(Locale.ROOT, "%.2f", class_3102.field_1724.method_23318()));
        }
        if (n >= 170) {
            System.out.println("mob test done");
            return true;
        }
        return false;
    }

    private static int ghn(class_310 class_3102) {
        MobEsp rhs2 = MobEsp.get();
        int n = 0;
        for (class_1297 class_12972 : class_3102.field_1687.method_18112()) {
            if (!rhs2.picks(class_12972)) continue;
            ++n;
        }
        return n;
    }

    private static void gho(class_310 class_3102, String string, double d, double d2, String string2) {
        MobEspTest.ghw(class_3102, MobEspTest.ghp("summon minecraft:%s %.1f %.1f %.1f %s", string, ghh + d, ghi, ghj + d2, string2));
    }

    private static String ghp(String string, Object ... objectArray) {
        Object[] objectArray2 = (Object[])objectArray.clone();
        if (string.startsWith("fill")) {
            int n = (int)Math.floor(ghh);
            int n2 = (int)ghi;
            int n3 = (int)Math.floor(ghj);
            for (int i = 0; i < objectArray2.length; ++i) {
                int n4 = i % 3 == 0 ? n : (i % 3 == 1 ? n2 : n3);
                objectArray2[i] = n4 + (Integer)objectArray2[i];
            }
        }
        return String.format(Locale.ROOT, string, objectArray2);
    }

    private static void ghq(ModuleManager kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static void ghr(Module kfe2, String string, boolean bl) {
        ((BoolSetting)MobEspTest.ght(kfe2, string)).set(bl);
    }

    private static void ghs(Module kfe2, String string, String string2) {
        ((ModeSetting)MobEspTest.ght(kfe2, string)).set(string2);
    }

    private static Setting ght(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static boolean ghu(String string, String string2) {
        try {
            Field field = Class.forName(string).getDeclaredField(string2);
            field.setAccessible(true);
            return field.getBoolean(null);
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static void ghv(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
        class_3102.field_1724.method_5636(f);
        class_3102.field_1724.field_6220 = f;
        class_3102.field_1724.method_5847(f);
    }

    private static void ghw(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void ghx(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int tt(int n, int n2) {
        return n ^ n2 ^ 0x41C69DF5;
    }

    private static /* synthetic */ int tu(int n, int n2) {
        return MobEspTest.tt(n, n2) * n2;
    }

    private static /* synthetic */ int tv(int n, int n2) {
        return MobEspTest.tu(n, n2) + n;
    }
}

