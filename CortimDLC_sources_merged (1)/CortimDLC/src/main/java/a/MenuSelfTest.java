/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.class_11905
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_11910
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_429
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_446
 *  net.minecraft.class_500
 *  net.minecraft.class_8032
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.AccountsScreen;
import a.MenuScreen;
import a.MenuScale;
import a.WallpaperEntry;
import a.WelcomeScreen;
import flow.dev.StringDecryptor;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_429;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_446;
import net.minecraft.class_500;
import net.minecraft.class_8032;
import org.lwjgl.glfw.GLFW;

public final class MenuSelfTest {
    private static final float[] gdi = new float[]{0.5f, 1.5f, 2.9f, 3.5f, 3.8f, 4.2f, 4.8f, 5.5f, 6.5f, 7.5f, 8.5f, 9.5f};
    private static int gdj;
    private static long gdk;
    private static int gdl;
    private static int gdm;
    private static MenuScreen gdn;
    private static /* synthetic */ boolean gdo;
    private static /* synthetic */ long gdp;

    private MenuSelfTest() {
    }

    public static void install() {
        if (!Boolean.getBoolean("flow2.selftest") || !"menu".equals(System.getenv("FLOW2_SELFTEST_SCENE"))) {
            return;
        }
        ClientTickEvents.END_CLIENT_TICK.register(MenuSelfTest::gds);
    }

    private static float gdq() {
        return (float)(System.nanoTime() - gdk) / 1.0E9f;
    }

    private static void gdr() {
        gdk = System.nanoTime();
        gdl = 0;
    }

    private static void gds(class_310 class_3102) {
        ++gdm;
        try {
            MenuSelfTest.gdt(class_3102);
        }
        catch (Throwable throwable) {
            System.out.println("menu test FAIL: " + throwable);
            throwable.printStackTrace();
            gdj = 99;
            class_3102.method_1592();
        }
    }

    private static void gdt(class_310 class_3102) throws Exception {
        switch (gdj) {
            case 0: {
                if (gdm % 100 == 0) {
                    System.out.println("menu test waiting: overlay " + class_3102.method_18506() + ", screen " + class_3102.field_1755);
                }
                if (class_3102.method_18506() == null && class_3102.field_1755 instanceof class_8032) {
                    class_3102.field_1690.field_41785 = false;
                    class_3102.method_1507((class_437)new class_442());
                }
                if (class_3102.method_18506() != null || !(class_3102.field_1755 instanceof MenuScreen) || gdm <= 60) break;
                Splash.preview(class_3102, 3.0f, true);
                MenuSelfTest.gdr();
                gdj = 1;
                break;
            }
            case 1: {
                if (gdl < gdi.length && MenuSelfTest.gdq() >= gdi[gdl]) {
                    MenuSelfTest.gdy(class_3102, "menu-01-intro-" + gdl);
                    ++gdl;
                }
                if (class_3102.method_18506() == null && class_3102.field_1755 instanceof WelcomeScreen) {
                    System.out.println("menu test intro over after " + MenuSelfTest.gdq() + " s");
                    MenuSelfTest.gdr();
                    gdj = 2;
                    break;
                }
                if (!(MenuSelfTest.gdq() > 15.0f)) break;
                throw new IllegalStateException("intro still up: " + class_3102.method_18506() + " " + class_3102.field_1755);
            }
            case 2: {
                class_437 class_4372;
                float f = MenuSelfTest.gdq();
                if (gdl == 0 && f > 0.25f) {
                    MenuSelfTest.gdy(class_3102, "menu-02-welcome-in");
                    ++gdl;
                    break;
                }
                if (gdl == 1 && f > 1.2f) {
                    MenuSelfTest.gdv(class_3102, 0.37f, 0.5f);
                    ++gdl;
                    break;
                }
                if (gdl == 2 && f > 1.7f) {
                    MenuSelfTest.gdy(class_3102, "menu-03-welcome-hover");
                    ++gdl;
                    break;
                }
                if (gdl == 3 && f > 1.8f) {
                    MenuSelfTest.gdw(class_3102.field_1755, "pick", new Class[]{Integer.TYPE}, 0);
                    ++gdl;
                    break;
                }
                if (gdl == 4 && f > 2.0f) {
                    MenuSelfTest.gdy(class_3102, "menu-04-welcome-picked");
                    ++gdl;
                    break;
                }
                if (gdl == 5 && (class_4372 = class_3102.field_1755) instanceof MenuScreen) {
                    MenuScreen fArray;
                    gdn = fArray = (MenuScreen)class_4372;
                    MenuSelfTest.gdv(class_3102, 0.1f, 0.9f);
                    MenuSelfTest.gdr();
                    gdj = 3;
                    break;
                }
                if (!(f > 8.0f)) break;
                throw new IllegalStateException("no menu after the pick: " + class_3102.field_1755);
            }
            case 3: {
                float f = MenuSelfTest.gdq();
                float[] n = new float[]{0.3f, 0.7f, 1.2f, 2.0f, 3.5f};
                if (gdl < n.length && f >= n[gdl]) {
                    MenuSelfTest.gdy(class_3102, "menu-05-open-" + gdl);
                    ++gdl;
                    break;
                }
                if (gdl == n.length && f > 3.7f) {
                    float f2 = MenuScale.scale(MenuSelfTest.gdn.field_22789, MenuSelfTest.gdn.field_22790);
                    MenuSelfTest.gdv(class_3102, 0.5f, ((float)MenuSelfTest.gdn.field_22790 * 0.5f + -13.1f * f2) / (float)MenuSelfTest.gdn.field_22790);
                    ++gdl;
                    break;
                }
                if (gdl == n.length + 1 && f > 4.3f) {
                    MenuSelfTest.gdy(class_3102, "menu-06-hover-single");
                    float f3 = MenuScale.scale(MenuSelfTest.gdn.field_22789, MenuSelfTest.gdn.field_22790);
                    MenuSelfTest.gdv(class_3102, 1.0f - 49.5f * f3 / (float)MenuSelfTest.gdn.field_22789, 22.5f * f3 / (float)MenuSelfTest.gdn.field_22790);
                    ++gdl;
                    break;
                }
                if (gdl == n.length + 2 && f > 4.9f) {
                    MenuSelfTest.gdy(class_3102, "menu-07-hover-bg");
                    MenuSelfTest.gdx((Object)gdn, "pickerOpen", true);
                    ++gdl;
                    break;
                }
                if (gdl == n.length + 3 && f > 5.6f) {
                    MenuSelfTest.gdy(class_3102, "menu-08-picker");
                    MenuSelfTest.gdx((Object)gdn, "scrollTarget", Float.valueOf(240.0f));
                    ++gdl;
                    break;
                }
                if (gdl != n.length + 4 || !(f > 6.6f)) break;
                MenuSelfTest.gdy(class_3102, "menu-08b-picker-walls");
                MenuSelfTest.gdx((Object)gdn, "scrollTarget", Float.valueOf(0.0f));
                MenuSelfTest.gdr();
                gdj = 4;
                break;
            }
            case 4: {
                WallpaperEntry[] kbsArray = new WallpaperEntry[]{WallpaperEntry.byKey("video:sparkle"), WallpaperEntry.byKey("video:castle"), WallpaperEntry.byKey("video:cherry"), WallpaperEntry.byKey("video:farm")};
                int f4 = gdl / 2;
                if (f4 >= kbsArray.length) {
                    MenuSelfTest.gdx((Object)gdn, "pickerOpen", false);
                    class_3102.method_1507((class_437)new class_429((class_437)gdn, class_3102.field_1690));
                    MenuSelfTest.gdr();
                    gdj = 5;
                    return;
                }
                if (gdl % 2 == 0 && MenuSelfTest.gdq() > 0.2f) {
                    MenuSelfTest.gdw((Object)gdn, "pick", new Class[]{WallpaperEntry.class}, kbsArray[(f4 + 1) % kbsArray.length]);
                    ++gdl;
                    break;
                }
                if (gdl % 2 != 1 || !(MenuSelfTest.gdq() > 1.6f)) break;
                MenuSelfTest.gdx((Object)gdn, "pickerOpen", false);
                MenuSelfTest.gdy(class_3102, "menu-09-season-" + kbsArray[(f4 + 1) % kbsArray.length].key.replace(':', '-'));
                ++gdl;
                MenuSelfTest.gdr();
                gdl = f4 * 2 + 2;
                break;
            }
            case 5: {
                float f = MenuSelfTest.gdq();
                if (gdl == 0 && f > 0.15f) {
                    MenuSelfTest.gdy(class_3102, "menu-10a-options-in");
                    ++gdl;
                    break;
                }
                if (gdl == 1 && f > 0.9f) {
                    MenuSelfTest.gdv(class_3102, 0.32999998f, 0.4f);
                    ++gdl;
                    break;
                }
                if (gdl == 2 && f > 1.5f) {
                    MenuSelfTest.gdy(class_3102, "menu-10b-options");
                    class_3102.method_1507((class_437)new class_500((class_437)gdn));
                    ++gdl;
                    break;
                }
                if (gdl == 3 && f > 2.6f) {
                    MenuSelfTest.gdy(class_3102, "menu-10c-multiplayer");
                    class_3102.method_1507((class_437)new class_446((class_437)gdn, class_3102, class_3102.field_1690));
                    ++gdl;
                    break;
                }
                if (gdl == 4 && f > 3.6f) {
                    MenuSelfTest.gdy(class_3102, "menu-10d-video");
                    class_3102.method_1507((class_437)gdn);
                    ++gdl;
                    break;
                }
                if (gdl == 5 && f > 4.0f) {
                    MenuSelfTest.gdy(class_3102, "menu-10-back");
                    ++gdl;
                    break;
                }
                if (gdl != 6 || !(f > 5.2f)) break;
                float jos2 = MenuScale.scale(MenuSelfTest.gdn.field_22789, MenuSelfTest.gdn.field_22790);
                float f5 = ((float)MenuSelfTest.gdn.field_22789 / jos2 - 138.0f) * 0.5f + 40.0f;
                float f2 = (float)MenuSelfTest.gdn.field_22790 / jos2 * 0.5f - 25.6f + 64.0f + 12.5f;
                gdn.method_25402(new class_11909((double)(f5 * jos2), (double)(f2 * jos2), new class_11910(0, 0)), false);
                MenuSelfTest.gdr();
                gdj = 7;
                break;
            }
            case 7: {
                float f = MenuSelfTest.gdq();
                if (gdl == 0 && f > 0.08f) {
                    MenuSelfTest.gdy(class_3102, "menu-12-alt-press");
                    ++gdl;
                    break;
                }
                if (gdl == 1 && f > 0.9f) {
                    MenuSelfTest.gdy(class_3102, "menu-13-alt");
                    ++gdl;
                    break;
                }
                if (gdl == 2 && f > 1.1f) {
                    class_437 object = class_3102.field_1755;
                    if (object instanceof AccountsScreen) {
                        AccountsScreen jos2 = (AccountsScreen)object;
                        for (char c : "FlowTester".toCharArray()) {
                            jos2.method_25400(new class_11905((int)c, 0));
                        }
                        jos2.method_25404(new class_11908(257, 0, 0));
                    }
                    ++gdl;
                    break;
                }
                if (gdl == 3 && f > 1.8f) {
                    MenuSelfTest.gdy(class_3102, "menu-14-alt-added");
                    MenuSelfTest.gdu(class_3102, 60.0f);
                    ++gdl;
                    break;
                }
                if (gdl == 4 && f > 3.0f) {
                    MenuSelfTest.gdy(class_3102, "menu-15-alt-login");
                    MenuSelfTest.gdu(class_3102, 242.0f);
                    ++gdl;
                    break;
                }
                if (gdl == 5 && f > 3.3f) {
                    MenuSelfTest.gdy(class_3102, "menu-16-alt-confirm");
                    MenuSelfTest.gdu(class_3102, 242.0f);
                    ++gdl;
                    break;
                }
                if (gdl == 6 && f > 3.8f) {
                    MenuSelfTest.gdy(class_3102, "menu-17-alt-removed");
                    class_3102.method_1507((class_437)gdn);
                    MenuSelfTest.gdx((Object)gdn, "noticeOpen", false);
                    ++gdl;
                    break;
                }
                if (gdl != 7 || !(f > 5.0f)) break;
                Splash.preview(class_3102, 2.0f, false);
                MenuSelfTest.gdr();
                gdj = 6;
                break;
            }
            case 6: {
                float[] fArray = new float[]{0.15f, 0.6f, 1.4f, 2.2f};
                if (gdl < fArray.length && MenuSelfTest.gdq() >= fArray[gdl]) {
                    MenuSelfTest.gdy(class_3102, "menu-11-reload-" + gdl);
                    ++gdl;
                }
                if (gdl >= fArray.length && !(class_3102.method_18506() instanceof FlowSplash)) {
                    System.out.println("menu test PASS, reload gone after " + MenuSelfTest.gdq() + " s");
                    gdj = 99;
                    class_3102.method_1592();
                    break;
                }
                if (!(MenuSelfTest.gdq() > 12.0f)) break;
                throw new IllegalStateException("reload still up");
            }
        }
    }

    private static void gdu(class_310 class_3102, float f) {
        class_437 class_4372 = class_3102.field_1755;
        if (!(class_4372 instanceof AccountsScreen)) {
            return;
        }
        AccountsScreen jos2 = (AccountsScreen)class_4372;
        float f2 = MenuScale.scale(jos2.field_22789, jos2.field_22790);
        float f3 = ((float)jos2.field_22789 / f2 - 268.0f) * 0.5f;
        float f4 = ((float)jos2.field_22790 / f2 - 218.0f) * 0.5f + 4.0f;
        jos2.method_25402(new class_11909((double)((f3 + f) * f2), (double)((f4 + 52.0f + 14.0f) * f2), new class_11910(0, 0)), false);
    }

    private static void gdv(class_310 class_3102, float f, float f2) {
        int[] nArray = new int[1];
        int[] nArray2 = new int[1];
        GLFW.glfwGetWindowSize((long)class_3102.method_22683().method_4490(), (int[])nArray, (int[])nArray2);
        GLFW.glfwSetCursorPos((long)class_3102.method_22683().method_4490(), (double)(f * (float)nArray[0]), (double)(f2 * (float)nArray2[0]));
    }

    private static void gdw(Object object, String string, Class<?>[] classArray, Object ... objectArray) throws Exception {
        Method method = object.getClass().getDeclaredMethod(string, classArray);
        method.setAccessible(true);
        method.invoke(object, objectArray);
    }

    private static void gdx(Object object, String string, Object object2) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        field.set(object, object2);
    }

    private static void gdy(class_310 class_3102, String string) {
        System.out.println("menu test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static /* synthetic */ int tg(int n, int n2) {
        return (n ^ n2) + -151045592;
    }
}

