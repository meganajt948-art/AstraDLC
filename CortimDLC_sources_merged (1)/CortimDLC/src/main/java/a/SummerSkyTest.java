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

import a.haj;
import a.Module;
import a.CloudPass;
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

final class SummerSkyTest {
    private static final int haw = 560;
    private static final String hax = System.getenv("FLOW2_SUMMERSKY");
    private static final String hay = System.getenv().getOrDefault("FLOW2_SUMMER_QUALITY", "Medium");
    private static final haj[] haz = new haj[]{new haj(0, "noon-sky", 6000L, 20.0f, -35.0f, 2, true), new haj(60, "noon-sky-off", 6000L, 20.0f, -35.0f, 2, false), new haj(120, "noon-horizon", 6000L, 20.0f, -4.0f, 2, true), new haj(150, "noon-pan", 6000L, 0.0f, -25.0f, 2, true), new haj(180, "noon-up", 6000L, 110.0f, -80.0f, 2, true), new haj(240, "morning-sun", 1000L, -90.0f, -14.0f, 2, true), new haj(300, "morning-sun-off", 1000L, -90.0f, -14.0f, 2, false), new haj(360, "morning-side", 1000L, -20.0f, -4.0f, 2, true), new haj(420, "morning-trees", 600L, -90.0f, -6.0f, 2, true), new haj(480, "sunset", 12300L, 90.0f, -8.0f, 2, true), new haj(540, "sunset-off", 12300L, 90.0f, -8.0f, 2, false), new haj(600, "sunset-back", 12300L, -90.0f, -12.0f, 2, true), new haj(660, "golden-high", 11500L, 90.0f, -2.0f, 30, true), new haj(720, "shadows-high", 6000L, 30.0f, 50.0f, 60, true), new haj(780, "night", 18000L, 20.0f, -25.0f, 2, true), new haj(840, "above-clouds", 7000L, 20.0f, 25.0f, 260, true), new haj(900, "in-clouds", 6000L, 20.0f, 0.0f, 170, true), new haj(960, "rain", 6000L, 20.0f, -20.0f, 2, true, "rain"), new haj(1080, "perf-low", 6000L, 20.0f, -30.0f, 2, true, "clear", "Low"), new haj(1180, "perf-medium", 6000L, 20.0f, -30.0f, 2, true, "clear", "Medium"), new haj(1280, "perf-high", 6000L, 20.0f, -30.0f, 2, true, "clear", "High"), new haj(1380, "perf-off", 6000L, 20.0f, -30.0f, 2, false, "clear", "Medium")};
    private static final String[] hba = new String[]{"FullBright", "VolumetricFog", "Shaders", "ShaderSky", "MotionBlur"};
    private static boolean[] hbb;
    private static volatile class_2338 hbc;
    private static volatile boolean hbd;
    private static int hbe;
    private static int hbf;
    private static /* synthetic */ long hbg;
    private static /* synthetic */ String hbh;

    private SummerSkyTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        int n2;
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("Weather");
        if (n == 1) {
            hbb = new boolean[hba.length];
            for (int i = 0; i < hba.length; ++i) {
                Module kfe3 = Flow.getInstance().getModuleManager().getByName(hba[i]);
                boolean bl = SummerSkyTest.hbb[i] = kfe3 != null && kfe3.isEnabled();
                if (!hbb[i]) continue;
                kfe3.setEnabled(false);
            }
            class_3102.field_1690.field_1842 = true;
            class_3102.field_1690.field_1837 = false;
            class_3102.field_1690.method_42503().method_41748((Object)12);
            class_3102.field_1690.method_41808().method_41748((Object)70);
            SummerSkyTest.hbo(class_3102, "gamemode creative");
            SummerSkyTest.hbo(class_3102, "gamerule doDaylightCycle false");
            SummerSkyTest.hbo(class_3102, "gamerule doWeatherCycle false");
            SummerSkyTest.hbo(class_3102, "weather clear");
            GLFW.glfwSetWindowSize((long)class_3102.method_22683().method_4490(), (int)1920, (int)1080);
            SummerSkyTest.hbj(class_3102);
            return false;
        }
        if (n < 10) {
            return false;
        }
        if (hbe < 0) {
            if (!hbd) {
                return false;
            }
            if (hbc == null) {
                System.out.println("summersky: no forest found");
                return true;
            }
            System.out.println("summersky at " + hbc.method_23854());
            SummerSkyTest.hbi(class_3102, 2);
            SummerSkyTest.hbo(class_3102, "time set 6000");
            ((ModeSetting)SummerSkyTest.hbn(kfe2, "Season")).set("Summer");
            ((ModeSetting)SummerSkyTest.hbn(kfe2, "Quality")).set(hay);
            ((NumberSetting)SummerSkyTest.hbn(kfe2, "Particles")).set(0.6);
            ((NumberSetting)SummerSkyTest.hbn(kfe2, "Cumulus")).set(0.5);
            ((NumberSetting)SummerSkyTest.hbn(kfe2, "Sun rays")).set(0.7);
            ((NumberSetting)SummerSkyTest.hbn(kfe2, "Light shafts")).set(0.6);
            ((BoolSetting)SummerSkyTest.hbn(kfe2, "Cloud shadows")).set(true);
            ((BoolSetting)SummerSkyTest.hbn(kfe2, "Colour grade")).set(true);
            kfe2.setEnabled(true);
            CloudPass.timing(true);
            hbe = n;
            return false;
        }
        class_3102.field_1724.method_31549().field_7479 = true;
        if (class_3102.field_1755 != null) {
            class_3102.method_1507(null);
        }
        if ((n2 = n - hbe - 560) == -40) {
            CloudPass.gpuMillis();
        }
        if (n2 == -1) {
            System.out.println("summersky RenderPerfTest " + CloudPass.gpuMillis() + " ms");
        }
        for (haj haj2 : haz) {
            if (hax != null && !haj2.hal.startsWith(hax)) continue;
            if (n2 == haj2.hak - 50) {
                SummerSkyTest.hbo(class_3102, "time set " + haj2.ham);
                SummerSkyTest.hbo(class_3102, "weather " + haj2.har);
                if (haj2.hap != hbf) {
                    SummerSkyTest.hbi(class_3102, haj2.hap);
                }
                kfe2.setEnabled(haj2.haq);
                ((ModeSetting)SummerSkyTest.hbn(kfe2, "Quality")).set(haj2.has);
                SummerSkyTest.hbm(class_3102, haj2.han, haj2.hao);
                continue;
            }
            if (n2 == haj2.hak - 20) {
                CloudPass.gpuMillis();
                SummerSkyTest.hbm(class_3102, haj2.han, haj2.hao);
                continue;
            }
            if (haj2.hal.endsWith("pan") && n2 > haj2.hak - 25 && n2 < haj2.hak) {
                SummerSkyTest.hbm(class_3102, haj2.han + (float)(n2 - (haj2.hak - 25)) * 1.6f, haj2.hao);
                continue;
            }
            if (n2 == haj2.hak - 2) {
                SummerSkyTest.hbm(class_3102, haj2.han, haj2.hao);
                continue;
            }
            if (n2 != haj2.hak) continue;
            System.out.println("summersky " + haj2.hal + " RenderPerfTest " + CloudPass.gpuMillis() + " ms");
            SummerSkyTest.hbp(class_3102, "summersky-" + haj2.hal);
        }
        if (n2 > SummerSkyTest.haz[SummerSkyTest.haz.length - 1].hak + 10) {
            CloudPass.timing(false);
            SummerSkyTest.hbo(class_3102, "weather clear");
            class_3102.field_1690.field_1842 = false;
            for (int i = 0; i < hba.length; ++i) {
                Module kfe4 = Flow.getInstance().getModuleManager().getByName(hba[i]);
                if (kfe4 == null) continue;
                kfe4.setEnabled(hbb[i]);
            }
            return true;
        }
        return false;
    }

    private static void hbi(class_310 class_3102, int n) {
        hbf = n;
        class_2338 class_23382 = hbc;
        SummerSkyTest.hbo(class_3102, "tp @s " + class_23382.method_10263() + " " + (class_23382.method_10264() + n) + " " + class_23382.method_10260());
    }

    private static void hbj(class_310 class_3102) {
        hbc = null;
        hbd = false;
        class_1132 class_11322 = class_3102.method_1576();
        class_2338 class_23382 = class_3102.field_1724.method_24515();
        class_11322.execute(() -> {
            try {
                class_3218 class_32182 = class_11322.method_30002();
                Pair pair = class_32182.method_42108(class_68802 -> class_68802.method_40225(class_1972.field_9409), class_23382, 6400, 32, 64);
                if (pair != null) {
                    class_2338 class_23383 = (class_2338)pair.getFirst();
                    class_2338 class_23384 = null;
                    int n = -1;
                    for (int i = -64; i <= 64; i += 4) {
                        for (int j = -64; j <= 64; j += 4) {
                            int n2;
                            int n3 = class_23383.method_10263() + j;
                            int n4 = SummerSkyTest.hbl(class_32182, n3, n2 = class_23383.method_10260() + i);
                            if (n4 <= n) continue;
                            n = n4;
                            class_23384 = new class_2338(n3, SummerSkyTest.hbk(class_32182, class_2902.class_2903.field_13197, n3, n2), n2);
                        }
                    }
                    hbc = class_23384;
                }
            }
            catch (Throwable throwable) {
                System.out.println("summersky locate failed: " + throwable);
            }
            hbd = true;
        });
    }

    private static int hbk(class_3218 class_32182, class_2902.class_2903 class_29032, int n, int n2) {
        class_32182.method_8497(n >> 4, n2 >> 4);
        return class_32182.method_8624(class_29032, n, n2);
    }

    private static int hbl(class_3218 class_32182, int n, int n2) {
        int n3 = 0;
        int n4 = 0;
        for (int i = -12; i <= 12; i += 2) {
            for (int j = -12; j <= 12; j += 2) {
                boolean bl;
                int n5 = SummerSkyTest.hbk(class_32182, class_2902.class_2903.field_13197, n + j, n2 + i);
                int n6 = SummerSkyTest.hbk(class_32182, class_2902.class_2903.field_13203, n + j, n2 + i);
                boolean bl2 = bl = Math.abs(j) <= 4 && Math.abs(i) <= 4;
                if (n5 == n6) {
                    if (!bl) continue;
                    ++n3;
                    continue;
                }
                if (bl) continue;
                ++n4;
            }
        }
        return n3 == 25 ? 100 + Math.min(n4, 60) : n3;
    }

    private static void hbm(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static Setting hbn(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void hbo(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void hbp(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        hbe = -1;
        hbf = 2;
    }

    private static /* synthetic */ int yl(int n, int n2) {
        return n - n2 | 0x723689AD;
    }

    private static /* synthetic */ int ym(int n, int n2) {
        return SummerSkyTest.yl(n, n2) * n2;
    }
}

