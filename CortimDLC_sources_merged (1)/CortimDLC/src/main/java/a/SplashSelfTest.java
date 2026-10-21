/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 */
package a;

import a.MainSelfTest;
import a.Lang;
import flow.dev.StringDecryptor;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.io.File;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;

public final class SplashSelfTest {
    private static final boolean gyw;
    private static final float[] gyx;
    private static int gyy;
    private static long gyz;
    private static int gza;
    private static int gzb;
    private static /* synthetic */ boolean gzc;
    private static /* synthetic */ String gzd;

    private SplashSelfTest() {
    }

    public static void install() {
        if (!Boolean.getBoolean("flow2.selftest") || !"splash".equals(System.getenv("FLOW2_SELFTEST_SCENE"))) {
            return;
        }
        ClientTickEvents.END_CLIENT_TICK.register(SplashSelfTest::gzf);
    }

    private static float gze() {
        return (float)(System.nanoTime() - gyz) / 1.0E9f;
    }

    private static void gzf(class_310 class_3102) {
        switch (gyy) {
            case 0: {
                if (!(class_3102.method_18506() instanceof FlowSplash)) break;
                gyz = System.nanoTime();
                gyy = 1;
                break;
            }
            case 1: {
                if (class_3102.method_18506() != null) break;
                System.out.println("splash test boot overlay gone after " + SplashSelfTest.gze() + " s");
                gyy = 2;
                gzb = 0;
                break;
            }
            case 2: {
                if (class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1755 != null || class_3102.method_18506() != null) break;
                if (++gzb == 1) {
                    SplashSelfTest.gzh();
                }
                if (gzb <= 60) break;
                if (gyw) {
                    SplashSelfTest.gzg(false);
                }
                Splash.preview(class_3102, 5.0f, true);
                gyz = System.nanoTime();
                gza = 0;
                gyy = 3;
                break;
            }
            case 3: {
                float f = SplashSelfTest.gze();
                if (gza < gyx.length && f >= gyx[gza]) {
                    SplashSelfTest.gzi(class_3102, "splash-" + gza, f);
                    ++gza;
                }
                if (gza >= gyx.length && class_3102.method_18506() == null) {
                    System.out.println("splash test preview gone after " + f + " s");
                    if (gyw) {
                        SplashSelfTest.gzi(class_3102, "splash-welcome-screen", f);
                        SplashSelfTest.gzg(true);
                        class_3102.method_1507(null);
                    }
                    gyy = 4;
                    gzb = 0;
                    break;
                }
                if (!(f > 20.0f)) break;
                System.out.println("splash test FAIL, preview still up after 20 s");
                gyy = 9;
                class_3102.method_1592();
                break;
            }
            case 4: {
                if (++gzb <= 30) break;
                Splash.requestAfterInject();
                gyz = System.nanoTime();
                gyy = 5;
                break;
            }
            case 5: {
                float f = SplashSelfTest.gze();
                if (class_3102.method_18506() instanceof FlowSplash && gzb > 0) {
                    gzb = -1;
                    System.out.println("splash test real reload adopted");
                }
                if (gzb < 0 && class_3102.method_18506() == null) {
                    System.out.println("splash test PASS, real reload overlay gone after " + f + " s");
                    gyy = 9;
                    class_3102.method_1592();
                    break;
                }
                if (!(f > 40.0f)) break;
                System.out.println("splash test FAIL, real reload: " + class_3102.method_18506());
                gyy = 9;
                class_3102.method_1592();
                break;
            }
        }
    }

    private static void gzg(boolean bl) {
        try {
            Field field = Lang.class.getDeclaredField("chosen");
            field.setAccessible(true);
            field.setBoolean(null, bl);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            System.out.println("splash test can't set the language state: " + reflectiveOperationException);
        }
    }

    private static void gzh() {
        try {
            Field field = MainSelfTest.class.getDeclaredField("state");
            field.setAccessible(true);
            field.setInt(null, 99);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            System.out.println("splash test can't park the self test: " + reflectiveOperationException);
        }
    }

    private static void gzi(class_310 class_3102, String string, float f) {
        System.out.println("splash test " + string + " t=" + f + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    static {
        float[] fArray;
        boolean bl = gyw = System.getenv("FLOW2_SPLASH_WELCOME") != null;
        if (gyw) {
            float[] fArray2 = new float[10];
            fArray2[0] = 0.6f;
            fArray2[1] = 2.5f;
            fArray2[2] = 5.3f;
            fArray2[3] = 5.9f;
            fArray2[4] = 6.5f;
            fArray2[5] = 7.2f;
            fArray2[6] = 8.2f;
            fArray2[7] = 9.2f;
            fArray2[8] = 10.0f;
            fArray = fArray2;
            fArray2[9] = 10.6f;
        } else {
            float[] fArray3 = new float[15];
            fArray3[0] = 0.15f;
            fArray3[1] = 0.35f;
            fArray3[2] = 0.6f;
            fArray3[3] = 0.9f;
            fArray3[4] = 1.2f;
            fArray3[5] = 1.55f;
            fArray3[6] = 1.95f;
            fArray3[7] = 2.35f;
            fArray3[8] = 2.8f;
            fArray3[9] = 3.6f;
            fArray3[10] = 4.6f;
            fArray3[11] = 5.35f;
            fArray3[12] = 5.75f;
            fArray3[13] = 6.05f;
            fArray = fArray3;
            fArray3[14] = 6.35f;
        }
        gyx = fArray;
    }

    private static /* synthetic */ int xu(int n, int n2) {
        return n * n2 ^ 0xFB6B427;
    }

    private static /* synthetic */ int xv(int n, int n2) {
        return SplashSelfTest.xu(n, n2) ^ 0x457A79EA;
    }
}

