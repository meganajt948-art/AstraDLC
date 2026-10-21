/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.ClickGuiScreen;
import a.WallpaperManager;
import a.ivw;
import a.WheelScreen;
import a.Module;
import a.SkyPass;
import a.BoolSetting;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Method;
import net.minecraft.class_1661;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;

final class SkyStyleTest {
    private static final String[] gxg = new String[]{"Aurora", "Nebula", "Galaxy", "Sunset", "Clouds"};
    private static final int gxh = 40;
    private static final int gxi = 40 + gxg.length * 40 + 80;
    private static String gxj;
    private static int gxk;
    private static String gxl;
    private static /* synthetic */ boolean gxm;
    private static /* synthetic */ int gxn;

    private SkyStyleTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        Module kfe2 = SkyStyleTest.gxr("ShaderSky");
        Module kfe3 = SkyStyleTest.gxr("AutoSwap");
        Module kfe4 = SkyStyleTest.gxr("ServerHelper");
        if (n == gxk) {
            SkyStyleTest.gxu(class_3102, "sky-" + gxj);
        }
        if (n == 1) {
            SkyStyleTest.gxt(class_3102, "gamemode creative");
            SkyStyleTest.gxt(class_3102, "time set 6000");
            SkyStyleTest.gxt(class_3102, "weather clear");
            SkyStyleTest.gxt(class_3102, "gamerule doDaylightCycle false");
            SkyStyleTest.gxt(class_3102, "clear @s");
        } else if (n == 20) {
            SkyStyleTest.gxo(class_3102, 0.0f, -8.0f, "vanilla", n);
        } else if (n >= 40 && n < gxi - 80) {
            int n2 = (n - 40) / 40;
            int n3 = (n - 40) % 40;
            if (n3 == 0) {
                ((ModeSetting)SkyStyleTest.gxs(kfe2, "Sky")).set(gxg[n2]);
                kfe2.setEnabled(true);
                SkyPass.timing(true);
                SkyStyleTest.gxo(class_3102, 0.0f, -12.0f, gxg[n2].toLowerCase(), n);
            } else if (n3 == 12) {
                SkyPass.gpuMillis();
            } else if (n3 == 24) {
                System.out.println("sky " + gxg[n2] + " RenderPerfTest " + SkyPass.gpuMillis() + " ms @ " + class_3102.method_47599() + " fps");
                SkyStyleTest.gxo(class_3102, 140.0f, -50.0f, gxg[n2].toLowerCase() + "-up", n);
            }
        } else if (n == gxi - 75) {
            ((ModeSetting)SkyStyleTest.gxs(kfe2, "Sky")).set("Nebula");
            ((NumberSetting)SkyStyleTest.gxs(kfe2, "Horizon blend")).set(0.0);
            SkyStyleTest.gxo(class_3102, 0.0f, -12.0f, "debug-noblend", n);
        } else if (n == gxi - 60) {
            ((NumberSetting)SkyStyleTest.gxs(kfe2, "Horizon blend")).set(1.0);
            ((BoolSetting)SkyStyleTest.gxs(kfe2, "Hide clouds")).set(false);
            SkyStyleTest.gxo(class_3102, 0.0f, -12.0f, "debug-clouds", n);
        } else if (n == gxi - 45) {
            ((BoolSetting)SkyStyleTest.gxs(kfe2, "Hide clouds")).set(true);
            SkyStyleTest.gxo(class_3102, 0.0f, -12.0f, "debug-blend", n);
        } else if (n == gxi - 30) {
            SkyStyleTest.gxo(class_3102, 0.0f, -88.0f, "debug-zenith", n);
        } else if (n == gxi - 15) {
            ((ModeSetting)SkyStyleTest.gxs(kfe2, "Sky")).set("Sunset");
            SkyStyleTest.gxo(class_3102, 180.0f, -10.0f, "sunset-sun", n);
        } else if (n == gxi) {
            SkyPass.timing(false);
            ((ModeSetting)SkyStyleTest.gxs(kfe2, "Sky")).set("Aurora");
            SkyStyleTest.gxo(class_3102, 0.0f, 0.0f, "horizon", n);
            SkyStyleTest.gxt(class_3102, "gamemode survival");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.3 with minecraft:totem_of_undying");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.4 with minecraft:totem_of_undying[minecraft:enchantment_glint_override=true,minecraft:custom_name='Талисман Крушителя']");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.5 with minecraft:player_head[minecraft:custom_name='Сфера Хаоса']");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.9 with minecraft:phantom_membrane[minecraft:custom_name='Божья аура'] 12");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.10 with minecraft:netherite_scrap[minecraft:custom_name='Трапка'] 7");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.11 with minecraft:dried_kelp[minecraft:custom_name='Пласт'] 20");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.12 with minecraft:sugar[minecraft:custom_name='Явная пыль'] 3");
            SkyStyleTest.gxt(class_3102, "item replace entity @s inventory.13 with minecraft:ender_eye[minecraft:custom_name='Дезориентация'] 2");
            SkyStyleTest.gxt(class_3102, "item replace entity @s hotbar.4 with minecraft:wind_charge 16");
            SkyStyleTest.gxt(class_3102, "item replace entity @s hotbar.0 with minecraft:diamond_sword");
        } else if (n == gxi + 15) {
            kfe3.setEnabled(true);
            class_3102.method_1507((class_437)new WheelScreen((ivw)((Object)kfe3), -1));
            SkyStyleTest.gxp("wheel-free", n);
        } else if (n == gxi + 30) {
            Method method = WheelScreen.class.getDeclaredMethod("edit", Integer.TYPE);
            method.setAccessible(true);
            method.invoke((Object)class_3102.field_1755, 1);
            SkyStyleTest.gxp("wheel-panel", n);
        } else if (n == gxi + 45) {
            class_1661 class_16612 = class_3102.field_1724.method_31548();
            ivw ivw2 = (ivw)((Object)kfe3);
            ivw2.assign(0, class_16612.method_5438(12));
            ivw2.assign(1, class_16612.method_5438(13));
            ivw2.assign(2, class_16612.method_5438(14));
            class_3102.method_1507((class_437)new WheelScreen(ivw2, -1));
            SkyStyleTest.gxp("wheel-filled", n);
        } else if (n == gxi + 49) {
            SkyStyleTest.gxq(class_3102, 0.5f, 0.32f);
        } else if (n == gxi + 60) {
            ((ivw)((Object)kfe3)).pick(2);
            class_3102.method_1507(null);
        } else if (n == gxi + 70) {
            System.out.println("sky wheel swap: offhand=" + class_3102.field_1724.method_6079().method_7964().getString() + (class_3102.field_1724.method_6079().method_7964().getString().contains("Сфера") ? " PASS" : " FAIL"));
            kfe4.setEnabled(true);
            KeySetting vlq2 = (KeySetting)SkyStyleTest.gxs(kfe4, "Item wheel");
            vlq2.set(72);
            kfe4.onKey(class_3102, 72);
            SkyStyleTest.gxp("wheel-helper", n);
        } else if (n == gxi + 74) {
            SkyStyleTest.gxq(class_3102, 0.62f, 0.42f);
        } else if (n == gxi + 85) {
            class_3102.method_1507(null);
            ((KeySetting)SkyStyleTest.gxs(kfe4, "Item wheel")).set(-1);
            kfe4.setEnabled(false);
            kfe3.setEnabled(false);
            gxl = WallpaperManager.selected();
            WallpaperManager.select("sky:aurora");
            class_3102.method_1507((class_437)new ClickGuiScreen());
            SkyStyleTest.gxp("menu-aurora", n + 10);
        } else if (n == gxi + 110) {
            WallpaperManager.select("sky:nebula");
            SkyStyleTest.gxp("menu-nebula", n);
        } else if (n == gxi + 125) {
            WallpaperManager.select("sky:sunset");
            SkyStyleTest.gxp("menu-sunset", n);
        } else if (n == gxi + 140) {
            WallpaperManager.select("builtin:sakura-night");
            SkyStyleTest.gxp("menu-photo", n + 15);
        } else if (n == gxi + 170) {
            SkyStyleTest.gxp("menu-photo-later", n);
        } else if (n == gxi + 185) {
            WallpaperManager.select(gxl);
            class_3102.method_1507(null);
            kfe2.setEnabled(false);
            SkyStyleTest.gxt(class_3102, "gamerule doDaylightCycle true");
            SkyStyleTest.gxt(class_3102, "gamemode creative");
            return true;
        }
        return false;
    }

    private static void gxo(class_310 class_3102, float f, float f2, String string, int n) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
        SkyStyleTest.gxp(string, n);
    }

    private static void gxp(String string, int n) {
        gxj = string;
        gxk = n + 10;
    }

    private static void gxq(class_310 class_3102, float f, float f2) {
        int[] nArray = new int[1];
        int[] nArray2 = new int[1];
        GLFW.glfwGetWindowSize((long)class_3102.method_22683().method_4490(), (int[])nArray, (int[])nArray2);
        GLFW.glfwSetCursorPos((long)class_3102.method_22683().method_4490(), (double)((float)nArray[0] * f), (double)((float)nArray2[0] * f2));
    }

    private static Module gxr(String string) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 == null) {
            throw new IllegalStateException("no module " + string);
        }
        return kfe2;
    }

    private static Setting gxs(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void gxt(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void gxu(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        gxk = -1;
    }

    private static /* synthetic */ int xj(int n, int n2) {
        return n + n2 + -116137160;
    }

    private static /* synthetic */ int xk(int n, int n2) {
        return SkyStyleTest.xj(n, n2) + n;
    }
}

