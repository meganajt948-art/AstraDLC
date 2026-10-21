/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_525
 *  net.minecraft.class_8032
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.ClickGuiScreen;
import a.WallpaperManager;
import a.MenuScreen;
import a.MenuScale;
import a.WallpaperEntry;
import com.sun.management.OperatingSystemMXBean;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_525;
import net.minecraft.class_8032;
import org.lwjgl.glfw.GLFW;

public final class VideoSelfTest {
    private static final float[] hen = new float[]{0.4f, 1.2f, 1.45f, 2.5f, 4.0f, 5.9f, 6.6f, 8.0f};
    private static final float[] heo = new float[]{1.0f, 1.6f, 3.0f};
    private static int hep;
    private static long heq;
    private static int her;
    private static int hes;
    private static MenuScreen het;
    private static WallpaperEntry heu;
    private static String hev;
    private static int hew;
    private static long hex;
    private static long hey;
    private static /* synthetic */ long hez;
    private static /* synthetic */ int hfa;

    private VideoSelfTest() {
    }

    public static void install() {
        if (Boolean.getBoolean("flow2.selftest") && "video".equals(System.getenv("FLOW2_SELFTEST_SCENE"))) {
            ClientTickEvents.END_CLIENT_TICK.register(VideoSelfTest::hfd);
        }
    }

    private static float hfb() {
        return (float)(System.nanoTime() - heq) / 1.0E9f;
    }

    private static void hfc() {
        heq = System.nanoTime();
        her = 0;
    }

    private static void hfd(class_310 class_3102) {
        ++hes;
        try {
            VideoSelfTest.hfe(class_3102);
        }
        catch (Throwable throwable) {
            System.out.println("video test FAIL: " + throwable);
            throwable.printStackTrace();
            hep = 99;
            class_3102.method_1592();
        }
    }

    private static void hfe(class_310 class_3102) throws Exception {
        switch (hep) {
            case 0: {
                class_437 class_4372;
                if (class_3102.method_18506() == null && class_3102.field_1755 instanceof class_8032) {
                    class_3102.field_1690.field_41785 = false;
                    class_3102.method_1507((class_437)new class_442());
                }
                if (class_3102.method_18506() != null || !((class_4372 = class_3102.field_1755) instanceof MenuScreen)) break;
                MenuScreen jte2 = (MenuScreen)class_4372;
                if (hes <= 60) break;
                het = jte2;
                heu = WallpaperEntry.selected();
                VideoSelfTest.hfg(WallpaperEntry.byKey("video:sparkle"));
                VideoSelfTest.hfc();
                hep = 1;
                break;
            }
            case 1: {
                if (her < hen.length && VideoSelfTest.hfb() >= hen[her]) {
                    VideoSelfTest.hfh(class_3102, "video-menu-" + her);
                    ++her;
                    break;
                }
                if (her != hen.length || !VideoSelfTest.hff(class_3102, "menu", 9.0f, 4)) break;
                VideoSelfTest.hfc();
                hep = 10;
                break;
            }
            case 10: {
                String[] stringArray = new String[]{"video:cherry", "video:autumn-cats", "video:castle", "video:snow"};
                int n = her / 2;
                if (n >= stringArray.length) {
                    float f = MenuScale.scale(VideoSelfTest.het.field_22789, VideoSelfTest.het.field_22790);
                    int[] nArray = new int[1];
                    int[] nArray2 = new int[1];
                    GLFW.glfwGetWindowSize((long)class_3102.method_22683().method_4490(), (int[])nArray, (int[])nArray2);
                    float f2 = ((float)VideoSelfTest.het.field_22790 * 0.5f + -13.1f * f) / (float)VideoSelfTest.het.field_22790;
                    GLFW.glfwSetCursorPos((long)class_3102.method_22683().method_4490(), (double)(0.5f * (float)nArray[0]), (double)(f2 * (float)nArray2[0]));
                    VideoSelfTest.hfc();
                    hep = 11;
                    break;
                }
                if (her % 2 == 0) {
                    VideoSelfTest.hfg(WallpaperEntry.byKey(stringArray[n]));
                    ++her;
                    break;
                }
                if (!(VideoSelfTest.hfb() > 3.0f * (float)(n + 1))) break;
                VideoSelfTest.hfh(class_3102, "video-menu-" + stringArray[n].substring(6));
                ++her;
                break;
            }
            case 11: {
                if (!(VideoSelfTest.hfb() > 1.0f)) break;
                VideoSelfTest.hfh(class_3102, "video-menu-hover");
                VideoSelfTest.hfg(heu);
                class_525.method_64248((class_310)class_3102, () -> class_3102.method_1507((class_437)new class_442()));
                hep = 2;
                break;
            }
            case 2: {
                Object object = class_3102.field_1755;
                if (!(object instanceof class_525)) break;
                class_525 class_5252 = (class_525)object;
                object = class_525.class.getDeclaredMethod("createLevel", new Class[0]);
                ((Method)object).setAccessible(true);
                ((Method)object).invoke((Object)class_5252, new Object[0]);
                hes = 0;
                hep = 3;
                break;
            }
            case 3: {
                if (class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1755 != null || hes <= 500) break;
                hev = WallpaperManager.selected();
                WallpaperManager.select("builtin:cats");
                class_3102.method_1507((class_437)new ClickGuiScreen());
                VideoSelfTest.hfc();
                hep = 30;
                break;
            }
            case 30: {
                if (!VideoSelfTest.hff(class_3102, "gui photo before", 2.0f, 5)) break;
                WallpaperManager.select("video:sparkle");
                VideoSelfTest.hfc();
                hep = 4;
                break;
            }
            case 4: {
                if (her < heo.length && VideoSelfTest.hfb() >= heo[her]) {
                    VideoSelfTest.hfh(class_3102, "video-gui-" + her);
                    ++her;
                    break;
                }
                if (her != heo.length || !VideoSelfTest.hff(class_3102, "gui video", 4.0f, 6)) break;
                WallpaperManager.select("builtin:cats");
                VideoSelfTest.hfc();
                hep = 5;
                break;
            }
            case 5: {
                if (her == 0 && VideoSelfTest.hfb() > 1.5f) {
                    VideoSelfTest.hfh(class_3102, "video-gui-photo");
                    ++her;
                    break;
                }
                if (her != 1 || !VideoSelfTest.hff(class_3102, "gui photo", 2.0f, 4)) break;
                WallpaperManager.select(hev);
                class_3102.method_1507(null);
                System.out.println("video test PASS");
                hep = 99;
                class_3102.method_1592();
                break;
            }
        }
    }

    private static boolean hff(class_310 class_3102, String string, float f, int n) {
        int n2 = (int)Math.floor(VideoSelfTest.hfb() - f);
        if (n2 < 0 || n2 == hew) {
            return false;
        }
        hew = n2;
        if (n2 > 0) {
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
            long l = operatingSystemMXBean.getProcessCpuTime();
            long l2 = System.nanoTime();
            if (hex > 0L) {
                System.out.println("video test quiet " + string + " second " + n2 + ": " + class_3102.method_47599() + " fps, process cpu " + (double)Math.round((double)(l - hex) * 1000.0 / (double)(l2 - hey)) / 10.0 + "% of one core");
            }
            hex = l;
            hey = l2;
        }
        if (n2 >= n) {
            hew = -1;
            hex = 0L;
            ++her;
            return true;
        }
        return false;
    }

    private static void hfg(WallpaperEntry kbs2) throws Exception {
        Method method = MenuScreen.class.getDeclaredMethod("pick", WallpaperEntry.class);
        method.setAccessible(true);
        method.invoke((Object)het, kbs2);
    }

    private static void hfh(class_310 class_3102, String string) {
        System.out.println("video test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    static {
        hew = -1;
    }

    private static /* synthetic */ int zl(int n, int n2) {
        return n * n2 + 238710565;
    }

    private static /* synthetic */ int zm(int n, int n2) {
        return VideoSelfTest.zl(n, n2) ^ 0x7868C0D2;
    }

    private static /* synthetic */ int zn(int n, int n2) {
        return VideoSelfTest.zm(n, n2) ^ 0x93A95522;
    }
}

