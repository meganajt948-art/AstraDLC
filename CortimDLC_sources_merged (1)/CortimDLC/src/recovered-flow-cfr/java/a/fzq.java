/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.screen.AccessibilityOnboardingScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.jte;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;

public final class fzq {
    private static int fzr;
    private static int fzs;
    private static long fzt;
    private static int fzu;
    private static jte fzv;
    private static /* synthetic */ int fzw;
    private static /* synthetic */ boolean fzx;

    private fzq() {
    }

    public static void install() {
        if (Boolean.getBoolean(a.d("\u1e9f\u6724\uedf4\u739d\uf80f\u7ea2\uc4ac\u4d4b\ud31d\u59a6\ude67\u2407\uaac6\u3370", -1135408864, 1924077527)) && a.c(-426590231, "\ubf81\uc633\u4cec\ud295").equals(System.getenv(a.d("\ue78b\u9e30\u14e0\u8a89\u013b\u87e7\u3db8\ub45f\u2a09\ua0b2\u2773\udd13\u53d2\uca64\u403c\uc6c1\u7c9e\uf349\u69f1\uefab", -76430052, 658580165)))) {
            ClientTickEvents.END_CLIENT_TICK.register(fzq::gaa);
        }
    }

    public static void skip() {
        try {
            Field field = jte.class.getDeclaredField(a.b("\uf169\u88c3\u0212\u9c60\u17bb\u9102\u2b5f\ua2af\u3cdb\ub64b\u3195\ucbe2", -1378160368));
            field.setAccessible(true);
            field.set(null, true);
        }
        catch (Exception exception) {
            System.out.println(a.c(1508476242, "\u852d\ufc9e\u7642\ue87a\u63fe\ue51b\u5f1b\ud6f2\u48af\uc207\u4584\ubfa1\u316a\ua8d6\u22c0\ua47d\u1e31\u91ec\u0b57\u8d4d\u04e9\u7ea8\uf00a\u6bcc\uedb3\u6769\ude8e\u50c5") + exception);
        }
    }

    private static float fzy() {
        return (float)(System.nanoTime() - fzt) / 1.0E9f;
    }

    private static void fzz() {
        fzt = System.nanoTime();
        fzu = 0;
    }

    private static void gaa(MinecraftClient minecraftClient) {
        ++fzs;
        try {
            fzq.gab(minecraftClient);
        }
        catch (Throwable throwable) {
            System.out.println(a.c(1116441229, "\u8af1\uf343\u799c\ue7e5\u6c79\uea9c\u50de\ud939\u4761\ucd84\u4a31\ub047\u3e98\ua72c\u2d09\uabe2") + throwable);
            throwable.printStackTrace();
            fzr = 99;
            minecraftClient.scheduleStop();
        }
    }

    private static void gab(MinecraftClient minecraftClient) throws Exception {
        switch (fzr) {
            case 0: {
                Screen screen;
                if (minecraftClient.getOverlay() == null && minecraftClient.currentScreen instanceof AccessibilityOnboardingScreen) {
                    minecraftClient.options.onboardAccessibility = false;
                    minecraftClient.setScreen((Screen)new TitleScreen());
                }
                if (minecraftClient.getOverlay() != null || !((screen = minecraftClient.currentScreen) instanceof jte)) break;
                jte jte2 = (jte)screen;
                if (fzs <= 20) break;
                fzv = jte2;
                if (!fzq.gac()) {
                    throw new IllegalStateException(a.c(-1504920801, "\ubb73\uc2de\u4800\ud634\u5dae\udb17\u614f\ue8a5\u76af\ufc51\u7b9d\u81f9\u0f25\u969f\u1ccd\u9a78\u2062\uafa8\u3519\ub34b\u3ab0\u40e9\uce54\u5584"));
                }
                fzq.fzz();
                fzr = 1;
                break;
            }
            case 1: {
                float[] fArray = new float[]{0.15f, 0.5f, 1.2f, 2.6f};
                if (fzu < fArray.length && fzq.fzy() >= fArray[fzu]) {
                    fzq.gag(minecraftClient, a.c(1387646873, "\ucff3\ub641\u3c9e\ua2e7\u2976\uafda") + fzu + a.d("\u599d\u2068\uaabc", 520292062, -284008595));
                    ++fzu;
                    break;
                }
                if (fzu != fArray.length) break;
                fzq.gad((float)fzq.fzv.width * 0.5f, (float)fzq.fzv.height - 10.0f);
                fzq.fzz();
                fzr = 2;
                break;
            }
            case 2: {
                float f = (float)fzq.fzv.height - 10.0f - Math.min(1.0f, fzq.fzy() / 0.4f) * (float)fzq.fzv.height * 0.12f;
                fzq.gae((float)fzq.fzv.width * 0.5f, f);
                if (fzq.fzy() > 0.45f && fzu == 0) {
                    fzq.gag(minecraftClient, a.b("\u6136\u1884\u925b\u0c22\u87b3\u011e\ubb4c\u32a0\uaca1\u2614\ua1d9\u5bb1\ud573\u4c8a\uc687\u4068\ufa2b\u75f7\uef44", -882155191));
                    fzq.gaf((float)fzq.fzv.width * 0.5f, f);
                    ++fzu;
                    break;
                }
                if (fzu != 1 || !(fzq.fzy() > 1.1f)) break;
                fzq.gag(minecraftClient, a.c(-1807498508, "\uc28b\ubb39\u31e6\uaf9f\u240e\ua2a3\u18f0\u911d\u0f1c\u85ae\u027f\uf81d\u76c5\uef7d\u6564\ue3da\u5996\ud645\u4cfe"));
                if (!fzq.gac()) {
                    throw new IllegalStateException(a.c(-245255457, "\ub2a8\ucb58\u41d8\udfb2\u5462\ud2ce\u689b\ue13e\u7f32\uf587\u724a\u8822\u06e0\u9f14\u1512\u93f8\u29b5\ua667\u3cd8\uba81\u3378\u4928"));
                }
                fzv.keyPressed(new KeyInput(32, 0, 0));
                fzq.fzz();
                fzr = 3;
                break;
            }
            case 3: {
                float[] fArray = new float[]{0.08f, 0.2f, 0.35f, 0.55f, 0.9f, 1.6f};
                if (fzu < fArray.length && fzq.fzy() >= fArray[fzu]) {
                    fzq.gag(minecraftClient, a.d("\u8c4e\uf5fc\u7f23\ue15a\u6acb\uec65", 983082928, -1054790764) + fzu + a.d("\ud23d\uabd4\u211c\ubf6f\u34bb\ub206\u085d", 1265093157, -2086660046));
                    ++fzu;
                    break;
                }
                if (fzu != fArray.length || !(fzq.fzy() > 2.2f)) break;
                if (fzq.gac()) {
                    throw new IllegalStateException(a.d("\u7cee\u055c\u8f9e\u11ed\u9a3c\u1cc8\ua6df\u2f23\ub171\u3bca\ubc50\u4672\uc8f1\u5115\udb5d\u5dae\ue7e2\u683f\uf284", -1652866152, 1907506966));
                }
                Method method = jte.class.getDeclaredMethod(a.d("\u2e51\u57e3\udd3c\u4345\uc8b7\u4e27\uf46c", -1368248741, -1016004511), new Class[0]);
                method.setAccessible(true);
                method.invoke((Object)fzv, new Object[0]);
                fzq.fzz();
                fzr = 4;
                break;
            }
            case 4: {
                float[] fArray = new float[]{0.2f, 0.6f, 1.6f};
                if (fzu < fArray.length && fzq.fzy() >= fArray[fzu]) {
                    fzq.gag(minecraftClient, a.c(387972665, "\ufe53\u87e1\u0d3e\u9347\u18d6\u9e79") + fzu + a.c(-815334284, "\ufc5e\u85b0\u0f74\u910c\u1ad8\u9c65\u263e"));
                    ++fzu;
                    break;
                }
                if (fzu != fArray.length) break;
                if (!fzq.gac()) {
                    throw new IllegalStateException(a.b("\u3e34\u4786\ucd59\u5320\ud8d2\u5e42\ue409\u6daf\uf3b4\u7908\ufed6\u04ad\u8a33\u13d1\u99d6\u1f6b\ua527\u2afa\ub041", 1509768779));
                }
                fzq.gad((float)fzq.fzv.width * 0.5f, (float)fzq.fzv.height * 0.7f);
                fzq.fzz();
                fzr = 5;
                break;
            }
            case 5: {
                float f = (float)fzq.fzv.height * 0.7f - Math.min(1.0f, fzq.fzy() / 0.3f) * (float)fzq.fzv.height * 0.4f;
                fzq.gae((float)fzq.fzv.width * 0.5f, f);
                if (fzu == 0 && fzq.fzy() > 0.18f) {
                    fzq.gag(minecraftClient, a.b("\ue25b\u9be9\u1136\u8f4f\u04de\u8276\u3821\ub1cd\u2fcc\ua579\u22b4\ud8dc\u561e\ucfe7\u45f4\uc301\u7943", 1487987238));
                    ++fzu;
                    break;
                }
                if (fzu != 1 || !(fzq.fzy() > 0.32f)) break;
                fzq.gaf((float)fzq.fzv.width * 0.5f, f);
                ++fzu;
                fzq.fzz();
                fzu = 2;
                fzr = 6;
                break;
            }
            case 6: {
                if (fzu == 2 && fzq.fzy() > 0.25f) {
                    fzq.gag(minecraftClient, a.d("\ud4ef\uad5d\u2782\ub9fb\u326a\ub4c2\u0e94\u8779\u1978\u93cd\u1400\uee68\u60aa\uf953\u7358\uf5b2\u4fff\uc02d\u5a92\udccb\u553e\u2f68\ua1d2", 765567490, 373257878));
                    ++fzu;
                    break;
                }
                if (fzu != 3 || !(fzq.fzy() > 1.8f)) break;
                fzq.gag(minecraftClient, a.d("\u902e\ue99c\u6343\ufd3a\u76ab\uf003\u4a56\uc3b8\u5da7\ud71e\u50c6\uaaac", 1532196534, -33167624));
                if (fzq.gac()) {
                    throw new IllegalStateException(a.b("\u104c\u69bc\ue323\u7d51\uf687\u703f\uca2b\u4389\uddd2\u577d\ud0b7\u2ad3\ua441\u3db4\ub7ea\u3116\u8b53\u04cb\u9e2b\u182e\u918c\uebc6\u6577\ufea5\u78d6\uf20f", -132378569));
                }
                System.out.println(a.d("\ufc1f\u85ad\u0f72\u910b\u1a97\u9c72\u2630\uafd7\u318f\ubb6a\u3cc9\uc6a9\u486c\ud1dd", -985682515, -482651696));
                fzr = 99;
                minecraftClient.scheduleStop();
                break;
            }
        }
    }

    private static boolean gac() throws Exception {
        Field field = jte.class.getDeclaredField(a.b("\uaf27\ud695\u5c4a\uc233\u49ea\ucf5a", 1289203533));
        field.setAccessible(true);
        return field.getBoolean((Object)fzv);
    }

    private static void gad(float f, float f2) {
        fzv.mouseClicked(new Click((double)f, (double)f2, new MouseInput(0, 0)), false);
    }

    private static void gae(float f, float f2) {
        fzv.mouseDragged(new Click((double)f, (double)f2, new MouseInput(0, 0)), 0.0, 0.0);
    }

    private static void gaf(float f, float f2) {
        fzv.mouseReleased(new Click((double)f, (double)f2, new MouseInput(0, 0)));
    }

    private static void gag(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u110f\u68bd\ue262\u7c1b\uf787\u7162\ucb20\u42c7\udc9f\u567a", 1941639529) + string + a.b("\uae05\ud7d4\u5d67", 1010937382) + minecraftClient.getCurrentFps() + a.c(1821759149, "\ud689\uaf7e\u25bb\ubbc9"));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.d("\ub100\uc8bb\u426b\udc02\u5790\ud13e", -800622465, -670775009) + string + a.c(-2005816376, "\uabe2\ud20d\u58c0\uc6b8")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
    }

    private static /* synthetic */ int sq(int n, int n2) {
        return n + n2 + -968476179;
    }

    private static /* synthetic */ int sr(int n, int n2) {
        return fzq.sq(n, n2) * n2;
    }
}

