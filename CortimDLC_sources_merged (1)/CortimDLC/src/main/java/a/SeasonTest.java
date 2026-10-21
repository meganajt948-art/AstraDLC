/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1132
 *  net.minecraft.class_1959
 *  net.minecraft.class_1972
 *  net.minecraft.class_2338
 *  net.minecraft.class_276
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_3218
 *  net.minecraft.class_5321
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gsp;
import a.Module;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import com.mojang.datafixers.util.Pair;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import net.minecraft.class_1132;
import net.minecraft.class_1959;
import net.minecraft.class_1972;
import net.minecraft.class_2338;
import net.minecraft.class_276;
import net.minecraft.class_2902;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_3218;
import net.minecraft.class_5321;
import org.lwjgl.glfw.GLFW;

final class SeasonTest {
    private static final gsp[] gta = new gsp[]{new gsp("winter", (class_5321<class_1959>)class_1972.field_34471, "Winter", "Sunset", 23200L, 22, 12.0f), new gsp("spring", (class_5321<class_1959>)class_1972.field_42720, "Spring", "Clouds", 2500L, 24, 18.0f), new gsp("summer", (class_5321<class_1959>)class_1972.field_9455, "Summer", "Sunset", 11900L, 14, 12.0f), new gsp("autumn", (class_5321<class_1959>)class_1972.field_9412, "Autumn", "Sunset", 11400L, 12, 14.0f)};
    private static final float[] gtb = new float[]{0.0f, 45.0f, 90.0f, 135.0f, 180.0f, 225.0f, 270.0f, 315.0f};
    private static final int gtc = 760;
    private static final int gtd = 30;
    private static int gte = -1;
    private static int gtf;
    private static volatile class_2338 gtg;
    private static volatile boolean gth;
    private static /* synthetic */ long gti;
    private static /* synthetic */ String gtj;

    private SeasonTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Object object;
        if (n == 1) {
            class_3102.field_1690.field_1842 = true;
            class_3102.field_1690.method_42503().method_41748((Object)14);
            class_3102.field_1690.method_41808().method_41748((Object)80);
            SeasonTest.gto(class_3102, "gamemode spectator");
            SeasonTest.gto(class_3102, "gamerule doDaylightCycle false");
            SeasonTest.gto(class_3102, "gamerule doWeatherCycle false");
            SeasonTest.gto(class_3102, "weather clear");
            GLFW.glfwSetWindowSize((long)class_3102.method_22683().method_4490(), (int)2560, (int)1440);
            return false;
        }
        if (n < 30) {
            return false;
        }
        if (gte < 0 || n - gtf > 760 + 30 * (gtb.length + 1)) {
            if ((gte = SeasonTest.gtk(gte)) >= gta.length) {
                class_3102.field_1690.field_1842 = false;
                return true;
            }
            gtf = n;
            SeasonTest.gtl(class_3102, gta[gte]);
            return false;
        }
        gsp gsp2 = gta[gte];
        int n2 = n - gtf;
        if (n2 == 1 && !gth) {
            ++gtf;
            return false;
        }
        if (n2 == 2) {
            object = gtg;
            if (object == null) {
                System.out.println("scenery: no " + gsp2.gsq + " biome found");
                gtf -= 760 + 30 * (gtb.length + 2);
                return false;
            }
            System.out.println("scenery " + gsp2.gsq + " at " + object.method_23854());
            SeasonTest.gto(class_3102, "tp @s " + object.method_10263() + " " + (object.method_10264() + gsp2.gsv) + " " + object.method_10260());
            SeasonTest.gto(class_3102, "time set " + gsp2.gsu);
            Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
            ((ModeSetting)SeasonTest.gtn(kfe2, "Season")).set(gsp2.gss);
            ((NumberSetting)SeasonTest.gtn(kfe2, "Particles")).set(0.0);
            kfe2.setEnabled(true);
            Module kfe3 = Flow.getInstance().getModuleManager().getByName("ShaderSky");
            ((ModeSetting)SeasonTest.gtn(kfe3, "Sky")).set(gsp2.gst);
            kfe3.setEnabled(true);
            SeasonTest.gtm(class_3102, gtb[0], gsp2.gsw);
        }
        object = System.getenv("FLOW2_SCENERY_YAW");
        for (int i = 0; i < gtb.length; ++i) {
            if (object != null && !((String)object).equals(String.valueOf((int)gtb[i]))) continue;
            if (n2 == 760 + 30 * i - 12) {
                SeasonTest.gtm(class_3102, gtb[i], gsp2.gsw);
                continue;
            }
            if (n2 != 760 + 30 * i) continue;
            SeasonTest.gtp(class_3102, "scenery-" + gsp2.gsq + "-" + (int)gtb[i]);
        }
        return false;
    }

    private static int gtk(int n) {
        String string = System.getenv("FLOW2_SCENERY");
        for (int i = n + 1; i < gta.length; ++i) {
            if (string != null && !string.contains(SeasonTest.gta[i].gsq)) continue;
            return i;
        }
        return gta.length;
    }

    private static void gtl(class_310 class_3102, gsp gsp2) {
        gtg = null;
        gth = false;
        class_1132 class_11322 = class_3102.method_1576();
        class_2338 class_23382 = class_3102.field_1724.method_24515();
        class_11322.execute(() -> {
            try {
                class_3218 class_32182 = class_11322.method_30002();
                Pair pair = class_32182.method_42108(class_68802 -> class_68802.method_40225(gsp2.gsr), class_23382, 6400, 32, 64);
                if (pair != null) {
                    class_2338 class_23383 = (class_2338)pair.getFirst();
                    class_32182.method_8500(class_23383);
                    int n = class_32182.method_8624(class_2902.class_2903.field_13197, class_23383.method_10263(), class_23383.method_10260());
                    gtg = new class_2338(class_23383.method_10263(), n, class_23383.method_10260());
                }
            }
            catch (Throwable throwable) {
                System.out.println("scenery locate failed: " + throwable);
            }
            gth = true;
        });
    }

    private static void gtm(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static Setting gtn(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void gto(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void gtp(class_310 class_3102, String string) {
        System.out.println("scenery " + string + " " + class_3102.method_22683().method_4489() + "x" + class_3102.method_22683().method_4506());
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static /* synthetic */ int wy(int n, int n2) {
        return n - n2 ^ 0xCA59988;
    }

    private static /* synthetic */ int wz(int n, int n2) {
        return SeasonTest.wy(n, n2) * n2;
    }
}

