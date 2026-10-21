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

import a.gxv;
import a.Module;
import a.WeatherSeasonPass;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
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

final class SnowSkyTest {
    private static final int gyg = 520;
    private static final String gyh = System.getenv("FLOW2_SNOWSKY");
    private static final gxv[] gyi = new gxv[]{new gxv(0, "noon-horizon", 6000L, 20.0f, -6.0f, true), new gxv(50, "noon-horizon-off", 6000L, 20.0f, -6.0f, false), new gxv(100, "noon-sky", 6000L, 20.0f, -40.0f, true), new gxv(150, "noon-sky-off", 6000L, 20.0f, -40.0f, false), new gxv(200, "noon-ground", 6000L, 200.0f, 24.0f, true), new gxv(250, "noon-up", 6000L, 110.0f, -80.0f, true), new gxv(300, "sunset", 12600L, 90.0f, -8.0f, true), new gxv(350, "sunset-off", 12600L, 90.0f, -8.0f, false), new gxv(400, "sunset-back", 12600L, -90.0f, -8.0f, true), new gxv(450, "night", 18000L, 20.0f, -10.0f, true), new gxv(500, "night-off", 18000L, 20.0f, -10.0f, false), new gxv(550, "dawn", 23300L, -90.0f, -8.0f, true), new gxv(600, "shaders-noon", 6000L, 20.0f, -6.0f, true, "Shaders"), new gxv(650, "fog-sunset", 12600L, 90.0f, -8.0f, true, "VolumetricFog"), new gxv(700, "fog-noon", 6000L, 20.0f, -6.0f, true, "VolumetricFog")};
    private static final String[] gyj = new String[]{"FullBright", "VolumetricFog", "Shaders", "ShaderSky", "MotionBlur"};
    private static boolean[] gyk;
    private static volatile class_2338 gyl;
    private static volatile boolean gym;
    private static int gyn;
    private static /* synthetic */ String gyo;
    private static /* synthetic */ String gyp;

    private SnowSkyTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        int n2;
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
        if (n == 1) {
            gyk = new boolean[gyj.length];
            for (int i = 0; i < gyj.length; ++i) {
                Module kfe3 = Flow.getInstance().getModuleManager().getByName(gyj[i]);
                boolean bl = SnowSkyTest.gyk[i] = kfe3 != null && kfe3.isEnabled();
                if (!gyk[i]) continue;
                kfe3.setEnabled(false);
            }
            class_3102.field_1690.field_1842 = true;
            class_3102.field_1690.field_1837 = false;
            class_3102.field_1690.method_42503().method_41748((Object)12);
            class_3102.field_1690.method_41808().method_41748((Object)70);
            SnowSkyTest.gyt(class_3102, "gamemode creative");
            SnowSkyTest.gyt(class_3102, "gamerule doDaylightCycle false");
            SnowSkyTest.gyt(class_3102, "gamerule doWeatherCycle false");
            SnowSkyTest.gyt(class_3102, "weather clear");
            GLFW.glfwSetWindowSize((long)class_3102.method_22683().method_4490(), (int)1920, (int)1080);
            SnowSkyTest.gyq(class_3102);
            return false;
        }
        if (n < 10) {
            return false;
        }
        if (gyn < 0) {
            if (!gym) {
                return false;
            }
            class_2338 class_23382 = gyl;
            if (class_23382 == null) {
                System.out.println("snowsky: no snowy biome found");
                return true;
            }
            System.out.println("snowsky at " + class_23382.method_23854());
            SnowSkyTest.gyt(class_3102, "tp @s " + class_23382.method_10263() + " " + (class_23382.method_10264() + 7) + " " + class_23382.method_10260());
            SnowSkyTest.gyt(class_3102, "time set 6000");
            ((ModeSetting)SnowSkyTest.gys(kfe2, "Season")).set("Winter");
            ((NumberSetting)SnowSkyTest.gys(kfe2, "Particles")).set(0.6);
            ((NumberSetting)SnowSkyTest.gys(kfe2, "Clouds")).set(0.9);
            ((NumberSetting)SnowSkyTest.gys(kfe2, "Cold")).set(0.7);
            ((BoolSetting)SnowSkyTest.gys(kfe2, "Colour grade")).set(true);
            kfe2.setEnabled(true);
            WeatherSeasonPass.timing(true);
            gyn = n;
            return false;
        }
        class_3102.field_1724.method_31549().field_7479 = true;
        if (class_3102.field_1755 != null) {
            class_3102.method_1507(null);
        }
        if ((n2 = n - gyn - 520) == -40) {
            WeatherSeasonPass.gpuMillis();
        }
        if (n2 == -1) {
            System.out.println("snowsky RenderPerfTest " + WeatherSeasonPass.gpuMillis() + " ms");
        }
        for (gxv gxv2 : gyi) {
            if (gyh != null && !gxv2.gxx.startsWith(gyh)) continue;
            if (n2 == gxv2.gxw - 40) {
                SnowSkyTest.gyt(class_3102, "time set " + gxv2.gxy);
                kfe2.setEnabled(gxv2.gyb);
                for (String string : gyj) {
                    Module kfe4 = Flow.getInstance().getModuleManager().getByName(string);
                    if (kfe4 == null) continue;
                    kfe4.setEnabled(string.equals(gxv2.gyc));
                }
                SnowSkyTest.gyr(class_3102, gxv2.gxz, gxv2.gya);
                continue;
            }
            if (n2 == gxv2.gxw - 2) {
                SnowSkyTest.gyr(class_3102, gxv2.gxz, gxv2.gya);
                continue;
            }
            if (n2 != gxv2.gxw) continue;
            SnowSkyTest.gyu(class_3102, "snowsky-" + gxv2.gxx);
        }
        if (n2 > SnowSkyTest.gyi[SnowSkyTest.gyi.length - 1].gxw + 10) {
            WeatherSeasonPass.timing(false);
            class_3102.field_1690.field_1842 = false;
            for (int i = 0; i < gyj.length; ++i) {
                Module kfe5 = Flow.getInstance().getModuleManager().getByName(gyj[i]);
                if (kfe5 == null) continue;
                kfe5.setEnabled(gyk[i]);
            }
            return true;
        }
        return false;
    }

    private static void gyq(class_310 class_3102) {
        gyl = null;
        gym = false;
        class_1132 class_11322 = class_3102.method_1576();
        class_2338 class_23382 = class_3102.field_1724.method_24515();
        class_11322.execute(() -> {
            try {
                class_3218 class_32182 = class_11322.method_30002();
                Pair pair = class_32182.method_42108(class_68802 -> class_68802.method_40225(class_1972.field_35117), class_23382, 6400, 32, 64);
                if (pair != null) {
                    class_2338 class_23383 = (class_2338)pair.getFirst();
                    class_32182.method_8500(class_23383);
                    int n = class_32182.method_8624(class_2902.class_2903.field_13197, class_23383.method_10263(), class_23383.method_10260());
                    gyl = new class_2338(class_23383.method_10263(), n, class_23383.method_10260());
                }
            }
            catch (Throwable throwable) {
                System.out.println("snowsky locate failed: " + throwable);
            }
            gym = true;
        });
    }

    private static void gyr(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static Setting gys(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void gyt(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void gyu(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        gyn = -1;
    }

    private static /* synthetic */ int xq(int n, int n2) {
        return n - n2 + 969675938;
    }

    private static /* synthetic */ int xr(int n, int n2) {
        return SnowSkyTest.xq(n, n2) + n;
    }
}

