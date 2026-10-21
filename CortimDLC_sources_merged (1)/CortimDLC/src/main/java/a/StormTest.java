/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1132
 *  net.minecraft.class_1972
 *  net.minecraft.class_2338
 *  net.minecraft.class_276
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_3218
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gzj;
import a.Module;
import a.SeasonWeather;
import a.StormPass;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.WeatherSounds;
import com.mojang.datafixers.util.Pair;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import net.minecraft.class_1132;
import net.minecraft.class_1972;
import net.minecraft.class_2338;
import net.minecraft.class_276;
import net.minecraft.class_2902;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_3218;
import org.lwjgl.glfw.GLFW;

final class StormTest {
    private static final int gzu = 520;
    private static final String gzv = System.getenv("FLOW2_STORM");
    private static final gzj[] gzw = new gzj[]{new gzj(0, "day-horizon", 6000L, 20.0f, -5.0f, true), new gzj(40, "day-horizon-off", 6000L, 20.0f, -5.0f, false), new gzj(80, "day-sky", 6000L, 20.0f, -45.0f, true), new gzj(120, "day-up", 6000L, 110.0f, -80.0f, true), new gzj(160, "day-ground", 6000L, 0.0f, 35.0f, true), new gzj(200, "day-wall", 6000L, -90.0f, 8.0f, true), new gzj(240, "day-path", 6000L, 180.0f, 30.0f, true), new gzj(280, "sunset", 12600L, 90.0f, -6.0f, true), new gzj(320, "sunset-off", 12600L, 90.0f, -6.0f, false), new gzj(360, "dusk-ground", 13000L, 0.0f, 30.0f, true), new gzj(400, "night", 18000L, 20.0f, -20.0f, true), new gzj(440, "night-ground", 18000L, 0.0f, 30.0f, true), new gzj(480, "night-bolt", 18000L, 30.0f, -8.0f, true, "bolt:900"), new gzj(520, "day-bolt", 6000L, 30.0f, -8.0f, true, "bolt:650"), new gzj(560, "night-flash", 18000L, 20.0f, -25.0f, true, "flash:600"), new gzj(600, "rain-close", 6000L, 60.0f, 0.0f, true), new gzj(700, "lens", 6000L, 20.0f, -50.0f, true, "hud"), new gzj(800, "perf-low", 6000L, 20.0f, -20.0f, true, "Low"), new gzj(880, "perf-medium", 6000L, 20.0f, -20.0f, true, "Medium"), new gzj(960, "perf-high", 6000L, 20.0f, -20.0f, true, "High"), new gzj(1140, "server-rain", 6000L, 20.0f, -5.0f, true, "rain"), new gzj(1190, "wall-far", 6000L, -140.0f, -4.0f, true), new gzj(1230, "wall-graze", 6000L, -45.0f, 4.0f, true), new gzj(1270, "wall-far-off", 6000L, -140.0f, -4.0f, false)};
    private static final String[] gzx = new String[]{"FullBright", "VolumetricFog", "Shaders", "ShaderSky", "MotionBlur"};
    private static boolean[] gzy;
    private static volatile class_2338 gzz;
    private static volatile boolean haa;
    private static int hab;
    private static /* synthetic */ String hac;
    private static /* synthetic */ boolean had;

    private StormTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
        if (n == 1) {
            gzy = new boolean[gzx.length];
            for (int i = 0; i < gzx.length; ++i) {
                Module kfe3 = Flow.getInstance().getModuleManager().getByName(gzx[i]);
                boolean bl = StormTest.gzy[i] = kfe3 != null && kfe3.isEnabled();
                if (!gzy[i]) continue;
                kfe3.setEnabled(false);
            }
            class_3102.field_1690.field_1842 = true;
            class_3102.field_1690.field_1837 = false;
            class_3102.field_1690.method_42503().method_41748((Object)12);
            class_3102.field_1690.method_41808().method_41748((Object)70);
            StormTest.hah(class_3102, "gamemode creative");
            StormTest.hah(class_3102, "gamerule doDaylightCycle false");
            StormTest.hah(class_3102, "gamerule doWeatherCycle false");
            StormTest.hah(class_3102, "weather clear");
            GLFW.glfwSetWindowSize((long)class_3102.method_22683().method_4490(), (int)1920, (int)1080);
            StormTest.hae(class_3102);
            return false;
        }
        if (n < 10) {
            return false;
        }
        if (hab < 0) {
            if (!haa) {
                return false;
            }
            class_2338 class_23382 = gzz;
            if (class_23382 == null) {
                System.out.println("storm: no plains found");
                return true;
            }
            System.out.println("storm at " + class_23382.method_23854());
            StormTest.hah(class_3102, "tp @s " + class_23382.method_10263() + " " + class_23382.method_10264() + " " + class_23382.method_10260() + " 0 0");
            StormTest.hah(class_3102, "time set 6000");
            ((ModeSetting)StormTest.hag(kfe2, "Season")).set("Rain");
            ((NumberSetting)StormTest.hag(kfe2, "Rainfall")).set(0.7);
            ((NumberSetting)StormTest.hag(kfe2, "Lightning")).set(0.0);
            ((NumberSetting)StormTest.hag(kfe2, "Clouds")).set(0.9);
            ((NumberSetting)StormTest.hag(kfe2, "Gloom")).set(0.6);
            ((NumberSetting)StormTest.hag(kfe2, "Sounds")).set(Double.parseDouble(System.getenv().getOrDefault("FLOW2_STORM_SOUND", "0.25")));
            ((BoolSetting)StormTest.hag(kfe2, "Colour grade")).set(true);
            ((BoolSetting)StormTest.hag(kfe2, "Lens drops")).set(true);
            ((ModeSetting)StormTest.hag(kfe2, "Quality")).set("High");
            kfe2.setEnabled(true);
            hab = n;
            return false;
        }
        int n2 = n - hab - 520;
        if (n2 == -500) {
            StormTest.hah(class_3102, "fill ~-12 ~ ~-12 ~12 ~8 ~12 air");
            StormTest.hah(class_3102, "fill ~-12 ~-1 ~-12 ~12 ~-1 ~12 grass_block");
            StormTest.hah(class_3102, "fill ~-2 ~-1 ~3 ~2 ~-1 ~6 water");
            StormTest.hah(class_3102, "fill ~4 ~ ~-4 ~4 ~3 ~4 stone_bricks");
            StormTest.hah(class_3102, "fill ~-1 ~-1 ~-12 ~1 ~-1 ~-3 cobblestone");
            StormTest.hah(class_3102, "fill ~-6 ~ ~-6 ~-6 ~2 ~-6 oak_log");
            StormTest.hah(class_3102, "fill ~20 ~ ~-40 ~45 ~12 ~-38 stone_bricks");
            StormTest.hah(class_3102, "fill ~20 ~-1 ~-37 ~45 ~-1 ~-30 grass_block");
        }
        if (n2 == -480) {
            class_3102.field_1724.method_31549().field_7479 = false;
        }
        if (class_3102.field_1755 != null) {
            class_3102.method_1507(null);
        }
        if (n2 == -40) {
            StormPass.timing(true);
            StormPass.gpuMillis();
        }
        if (n2 == -1) {
            System.out.println("storm RenderPerfTest " + StormPass.gpuReport());
        }
        for (gzj gzj2 : gzw) {
            int n3;
            if (gzv != null && !gzj2.gzl.startsWith(gzv)) continue;
            int n4 = gzj2.gzq.equals("hud") ? 90 : (n3 = gzj2.gzq.equals("rain") ? 130 : 36);
            if (n2 == gzj2.gzk - n3) {
                StormTest.hah(class_3102, "time set " + gzj2.gzm);
                kfe2.setEnabled(gzj2.gzp);
                boolean bl = class_3102.field_1690.field_1842 = !gzj2.gzq.equals("hud");
                if (gzj2.gzq.equals("Low") || gzj2.gzq.equals("Medium") || gzj2.gzq.equals("High")) {
                    ((ModeSetting)StormTest.hag(kfe2, "Quality")).set(gzj2.gzq);
                }
                StormTest.haf(class_3102, gzj2.gzn, gzj2.gzo);
                if (!gzj2.gzq.equals("rain")) continue;
                StormTest.hah(class_3102, "weather rain");
                continue;
            }
            if (n2 == gzj2.gzk - 30 && (gzj2.gzq.equals("Low") || gzj2.gzq.equals("Medium") || gzj2.gzq.equals("High"))) {
                StormPass.gpuMillis();
                continue;
            }
            if (n2 == gzj2.gzk - 3 && (gzj2.gzq.startsWith("bolt:") || gzj2.gzq.startsWith("flash:"))) {
                float f = Float.parseFloat(gzj2.gzq.substring(gzj2.gzq.indexOf(58) + 1));
                float f2 = gzj2.gzn * ((float)Math.PI / 180);
                double d = Math.atan2(Math.cos(f2), -Math.sin(f2));
                ((SeasonWeather)kfe2).testStrike(f, gzj2.gzq.startsWith("bolt:"), d, 0.03);
                continue;
            }
            if (n2 == gzj2.gzk - 2) {
                StormTest.haf(class_3102, gzj2.gzn, gzj2.gzo);
                continue;
            }
            if (n2 == gzj2.gzk) {
                if (gzj2.gzq.equals("Low") || gzj2.gzq.equals("Medium") || gzj2.gzq.equals("High")) {
                    System.out.println("storm " + gzj2.gzl + " RenderPerfTest " + StormPass.gpuReport() + " @ " + class_3102.method_47599() + " fps");
                }
                StormTest.hai(class_3102, "storm-" + gzj2.gzl);
                System.out.println("storm audio " + WeatherSounds.report());
                continue;
            }
            if (n2 == gzj2.gzk + 2 && gzj2.gzq.equals("rain")) {
                System.out.println("storm server rain gradient " + class_3102.field_1687.method_8430(1.0f) + " raining " + class_3102.field_1687.method_8419());
                StormTest.hah(class_3102, "weather clear");
                continue;
            }
            if (n2 != gzj2.gzk + 4 || !gzj2.gzq.startsWith("bolt:") && !gzj2.gzq.startsWith("flash:")) continue;
            ((SeasonWeather)kfe2).testStrike(100000.0f, false, 0.0, 10.0);
        }
        if (n2 > StormTest.gzw[StormTest.gzw.length - 1].gzk + 10) {
            StormPass.timing(false);
            class_3102.field_1690.field_1842 = false;
            for (int i = 0; i < gzx.length; ++i) {
                Module kfe4 = Flow.getInstance().getModuleManager().getByName(gzx[i]);
                if (kfe4 == null) continue;
                kfe4.setEnabled(gzy[i]);
            }
            return true;
        }
        return false;
    }

    private static void hae(class_310 class_3102) {
        gzz = null;
        haa = false;
        class_1132 class_11322 = class_3102.method_1576();
        class_2338 class_23382 = class_3102.field_1724.method_24515();
        class_11322.execute(() -> {
            try {
                class_3218 class_32182 = class_11322.method_30002();
                Pair pair = class_32182.method_42108(class_68802 -> class_68802.method_40225(class_1972.field_9451), class_23382, 6400, 32, 64);
                if (pair != null) {
                    class_2338 class_23383 = (class_2338)pair.getFirst();
                    class_32182.method_8500(class_23383);
                    int n = class_32182.method_8624(class_2902.class_2903.field_13203, class_23383.method_10263(), class_23383.method_10260());
                    gzz = new class_2338(class_23383.method_10263(), n, class_23383.method_10260());
                }
            }
            catch (Throwable throwable) {
                System.out.println("storm locate failed: " + throwable);
            }
            haa = true;
        });
    }

    private static void haf(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static Setting hag(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void hah(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void hai(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        hab = -1;
    }

    private static /* synthetic */ int yb(int n, int n2) {
        return n * n2 | 0x1EBBC3A0;
    }

    private static /* synthetic */ int yc(int n, int n2) {
        return n + n2 + 1068741962;
    }

    private static /* synthetic */ int yd(int n, int n2) {
        return n - n2 | 0x58554139;
    }
}

