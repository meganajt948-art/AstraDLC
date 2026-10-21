/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_11910
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_8032
 */
package a;

import a.MenuScreen;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_8032;

public final class LockScreenSelfTest {
    private static int fzr;
    private static int fzs;
    private static long fzt;
    private static int fzu;
    private static MenuScreen fzv;
    private static /* synthetic */ int fzw;
    private static /* synthetic */ boolean fzx;

    private LockScreenSelfTest() {
    }

    public static void install() {
        if (Boolean.getBoolean("flow2.selftest") && "lock".equals(System.getenv("FLOW2_SELFTEST_SCENE"))) {
            ClientTickEvents.END_CLIENT_TICK.register(LockScreenSelfTest::gaa);
        }
    }

    public static void skip() {
        try {
            Field field = MenuScreen.class.getDeclaredField("unlockedOnce");
            field.setAccessible(true);
            field.set(null, true);
        }
        catch (Exception exception) {
            System.out.println("can't skip the lock screen: " + exception);
        }
    }

    private static float fzy() {
        return (float)(System.nanoTime() - fzt) / 1.0E9f;
    }

    private static void fzz() {
        fzt = System.nanoTime();
        fzu = 0;
    }

    private static void gaa(class_310 class_3102) {
        ++fzs;
        try {
            LockScreenSelfTest.gab(class_3102);
        }
        catch (Throwable throwable) {
            System.out.println("lock test FAIL: " + throwable);
            throwable.printStackTrace();
            fzr = 99;
            class_3102.method_1592();
        }
    }

    private static void gab(class_310 class_3102) throws Exception {
        switch (fzr) {
            case 0: {
                class_437 class_4372;
                if (class_3102.method_18506() == null && class_3102.field_1755 instanceof class_8032) {
                    class_3102.field_1690.field_41785 = false;
                    class_3102.method_1507((class_437)new class_442());
                }
                if (class_3102.method_18506() != null || !((class_4372 = class_3102.field_1755) instanceof MenuScreen)) break;
                MenuScreen jte2 = (MenuScreen)class_4372;
                if (fzs <= 20) break;
                fzv = jte2;
                if (!LockScreenSelfTest.gac()) {
                    throw new IllegalStateException("the menu opened unlocked");
                }
                LockScreenSelfTest.fzz();
                fzr = 1;
                break;
            }
            case 1: {
                float[] fArray = new float[]{0.15f, 0.5f, 1.2f, 2.6f};
                if (fzu < fArray.length && LockScreenSelfTest.fzy() >= fArray[fzu]) {
                    LockScreenSelfTest.gag(class_3102, "lock-0" + fzu + "-in");
                    ++fzu;
                    break;
                }
                if (fzu != fArray.length) break;
                LockScreenSelfTest.gad((float)LockScreenSelfTest.fzv.field_22789 * 0.5f, (float)LockScreenSelfTest.fzv.field_22790 - 10.0f);
                LockScreenSelfTest.fzz();
                fzr = 2;
                break;
            }
            case 2: {
                float f = (float)LockScreenSelfTest.fzv.field_22790 - 10.0f - Math.min(1.0f, LockScreenSelfTest.fzy() / 0.4f) * (float)LockScreenSelfTest.fzv.field_22790 * 0.12f;
                LockScreenSelfTest.gae((float)LockScreenSelfTest.fzv.field_22789 * 0.5f, f);
                if (LockScreenSelfTest.fzy() > 0.45f && fzu == 0) {
                    LockScreenSelfTest.gag(class_3102, "lock-10-swipe-small");
                    LockScreenSelfTest.gaf((float)LockScreenSelfTest.fzv.field_22789 * 0.5f, f);
                    ++fzu;
                    break;
                }
                if (fzu != 1 || !(LockScreenSelfTest.fzy() > 1.1f)) break;
                LockScreenSelfTest.gag(class_3102, "lock-11-sprang-back");
                if (!LockScreenSelfTest.gac()) {
                    throw new IllegalStateException("a short swipe unlocked");
                }
                fzv.method_25404(new class_11908(32, 0, 0));
                LockScreenSelfTest.fzz();
                fzr = 3;
                break;
            }
            case 3: {
                float[] fArray = new float[]{0.08f, 0.2f, 0.35f, 0.55f, 0.9f, 1.6f};
                if (fzu < fArray.length && LockScreenSelfTest.fzy() >= fArray[fzu]) {
                    LockScreenSelfTest.gag(class_3102, "lock-2" + fzu + "-unlock");
                    ++fzu;
                    break;
                }
                if (fzu != fArray.length || !(LockScreenSelfTest.fzy() > 2.2f)) break;
                if (LockScreenSelfTest.gac()) {
                    throw new IllegalStateException("space didn't unlock");
                }
                Method method = MenuScreen.class.getDeclaredMethod("lockNow", new Class[0]);
                method.setAccessible(true);
                method.invoke((Object)fzv, new Object[0]);
                LockScreenSelfTest.fzz();
                fzr = 4;
                break;
            }
            case 4: {
                float[] fArray = new float[]{0.2f, 0.6f, 1.6f};
                if (fzu < fArray.length && LockScreenSelfTest.fzy() >= fArray[fzu]) {
                    LockScreenSelfTest.gag(class_3102, "lock-3" + fzu + "-relock");
                    ++fzu;
                    break;
                }
                if (fzu != fArray.length) break;
                if (!LockScreenSelfTest.gac()) {
                    throw new IllegalStateException("lockNow didn't lock");
                }
                LockScreenSelfTest.gad((float)LockScreenSelfTest.fzv.field_22789 * 0.5f, (float)LockScreenSelfTest.fzv.field_22790 * 0.7f);
                LockScreenSelfTest.fzz();
                fzr = 5;
                break;
            }
            case 5: {
                float f = (float)LockScreenSelfTest.fzv.field_22790 * 0.7f - Math.min(1.0f, LockScreenSelfTest.fzy() / 0.3f) * (float)LockScreenSelfTest.fzv.field_22790 * 0.4f;
                LockScreenSelfTest.gae((float)LockScreenSelfTest.fzv.field_22789 * 0.5f, f);
                if (fzu == 0 && LockScreenSelfTest.fzy() > 0.18f) {
                    LockScreenSelfTest.gag(class_3102, "lock-40-swipe-mid");
                    ++fzu;
                    break;
                }
                if (fzu != 1 || !(LockScreenSelfTest.fzy() > 0.32f)) break;
                LockScreenSelfTest.gaf((float)LockScreenSelfTest.fzv.field_22789 * 0.5f, f);
                ++fzu;
                LockScreenSelfTest.fzz();
                fzu = 2;
                fzr = 6;
                break;
            }
            case 6: {
                if (fzu == 2 && LockScreenSelfTest.fzy() > 0.25f) {
                    LockScreenSelfTest.gag(class_3102, "lock-41-swipe-unlocking");
                    ++fzu;
                    break;
                }
                if (fzu != 3 || !(LockScreenSelfTest.fzy() > 1.8f)) break;
                LockScreenSelfTest.gag(class_3102, "lock-42-menu");
                if (LockScreenSelfTest.gac()) {
                    throw new IllegalStateException("a long swipe didn't unlock");
                }
                System.out.println("lock test PASS");
                fzr = 99;
                class_3102.method_1592();
                break;
            }
        }
    }

    private static boolean gac() throws Exception {
        Field field = MenuScreen.class.getDeclaredField("locked");
        field.setAccessible(true);
        return field.getBoolean((Object)fzv);
    }

    private static void gad(float f, float f2) {
        fzv.method_25402(new class_11909((double)f, (double)f2, new class_11910(0, 0)), false);
    }

    private static void gae(float f, float f2) {
        fzv.method_25403(new class_11909((double)f, (double)f2, new class_11910(0, 0)), 0.0, 0.0);
    }

    private static void gaf(float f, float f2) {
        fzv.method_25406(new class_11909((double)f, (double)f2, new class_11910(0, 0)));
    }

    private static void gag(class_310 class_3102, String string) {
        System.out.println("lock test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static /* synthetic */ int sq(int n, int n2) {
        return n + n2 + -968476179;
    }

    private static /* synthetic */ int sr(int n, int n2) {
        return LockScreenSelfTest.sq(n, n2) * n2;
    }
}

