/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.gtq;
import a.wap;
import flow.dev.a;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.io.File;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.util.ScreenshotRecorder;

public final class gyv {
    private static final boolean gyw;
    private static final float[] gyx;
    private static int gyy;
    private static long gyz;
    private static int gza;
    private static int gzb;
    private static /* synthetic */ boolean gzc;
    private static /* synthetic */ String gzd;

    private gyv() {
    }

    public static void install() {
        if (!Boolean.getBoolean(a.b("\u0b99\u7222\uf8f2\u669b\ued09\u6ba4\ud1aa\u584d\uc61b\u4ca0\ucb61\u3101\ubfc0\u2676", -1289942031)) || !a.c(-158508991, "\u5834\u2186\uab49\u3535\ubef0\u385a").equals(System.getenv(a.b("\ua7f7\ude4c\u549c\ucaf5\u4147\uc79b\u7dc4\uf423\u6a75\ue0ce\u670f\u9d6f\u13ae\u8a18@\u86bd\u3ce2\ub335\u298d\uafd7", 1698539429)))) {
            return;
        }
        ClientTickEvents.END_CLIENT_TICK.register(gyv::gzf);
    }

    private static float gze() {
        return (float)(System.nanoTime() - gyz) / 1.0E9f;
    }

    private static void gzf(MinecraftClient minecraftClient) {
        switch (gyy) {
            case 0: {
                if (!(minecraftClient.getOverlay() instanceof FlowSplash)) break;
                gyz = System.nanoTime();
                gyy = 1;
                break;
            }
            case 1: {
                if (minecraftClient.getOverlay() != null) break;
                System.out.println(a.c(1738700540, "\u76ab\u0f19\u85d6\u1baa\u906f\u16c5\uacde\u257b\ubb35\u3192\ub646\u4c63\uc2f6\u5b4a\ud119\u57f3\uede8\u6276\uf8dc\u7e9e\uf77e\u8d31\u038f\u9846\u1e60\u94f6\u2d4d\ua31d\u39e1\ubff5\u3407\ucad1\u408c\ud96c\u5f28\ud5cb") + gyv.gze() + a.b("\u53d8\u2a3a", 16536570));
                gyy = 2;
                gzb = 0;
                break;
            }
            case 2: {
                if (minecraftClient.world == null || minecraftClient.player == null || minecraftClient.currentScreen != null || minecraftClient.getOverlay() != null) break;
                if (++gzb == 1) {
                    gyv.gzh();
                }
                if (gzb <= 60) break;
                if (gyw) {
                    gyv.gzg(false);
                }
                Splash.preview(minecraftClient, 5.0f, true);
                gyz = System.nanoTime();
                gza = 0;
                gyy = 3;
                break;
            }
            case 3: {
                float f = gyv.gze();
                if (gza < gyx.length && f >= gyx[gza]) {
                    gyv.gzi(minecraftClient, a.d("\ua0f3\ud941\u538e\ucdf2\u4637\uc09d\u7a8b", 1799572683, 1687022668) + gza, f);
                    ++gza;
                }
                if (gza >= gyx.length && minecraftClient.getOverlay() == null) {
                    System.out.println(a.b("\u2d37\u5485\ude4a\u4036\ucbf3\u4d59\uf742\u7ee7\ue0a9\u6a0e\uedda\u17ff\u9978\u00cb\u8a8f\u0c6d\ub63d\u39e0\ua341\u2547\uacf7\ud6ae\u581c\uc3c6\u45fc\ucf6c\u76d8\uf89b\u627d\ue43b\u6fda", -7721637) + f + a.c(1490806940, "\ue8be\u915c"));
                    if (gyw) {
                        gyv.gzi(minecraftClient, a.c(-305119411, "\u3f2b\u4699\ucc56\u522a\ud9ef\u5f45\ue553\u6cf8\uf2b5\u780d\uffd1\u05ac\u8b79\u12c0\u98db\u1e74\ua42b\u2beb\ub14f\u371e\ubee2"), f);
                        gyv.gzg(true);
                        minecraftClient.setScreen(null);
                    }
                    gyy = 4;
                    gzb = 0;
                    break;
                }
                if (!(f > 20.0f)) break;
                System.out.println(a.b("\ua510\udca2\u566d\uc811\u43d4\uc57e\u7f65\uf6c0\u688e\ue229\u65fd\u9fd8\u1169\u88df\u0284\u8470\u3e5f\ub182\u2b61\uad32\u24d2\u5e90\ud03c\u4be1\ucd8c\u470a\ufeea\u70bc\uea56\u6c02\ue7b1\u192c\u9336\u0ac2\u8cc1\u0631\ub9e1\u3382\ub540\u2ce6\ua6eb\ud808\u5259\ud5f8\u4f7c", -1703434930));
                gyy = 9;
                minecraftClient.scheduleStop();
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
                float f = gyv.gze();
                if (minecraftClient.getOverlay() instanceof FlowSplash && gzb > 0) {
                    gzb = -1;
                    System.out.println(a.d("\u6089\u193b\u93f4\u0d88\u864d\u00e7\ubafc\u3359\uad17\u27b0\ua064\u5a41\ud4c4\u4d62\uc735\u41c9\ufbca\u7449\ueeed\u68b5\ue141\u9b1e\u15a8\u8e3d\u0803\u82d7\u3b6f\ub521\u2fd2\ua992\u2220", 1124949631, 1472544410));
                }
                if (gzb < 0 && minecraftClient.getOverlay() == null) {
                    System.out.println(a.b("\ufd5c\u84ee\u0e21\u905d\u1b98\u9d32\u2729\uae8c\u30c2\uba65\u3db1\uc794\u4933\ud093\u5ad2\udc23\u6613\ue9ce\u732f\uf569\u7c9a\u06c6\u8839\u13ba\u95d2\u1f0a\ua6ba\u28e5\ub217\u3402\ubffe\u4136\ucb6a\u528c\ud4c1\u5e7d\ue1b2\u6b9a\ued0e\u74b7\ufee9\u8013\u0a05\u8df5\u1725\u9946\u2084\uaa22\u2c3f", -825754338) + f + a.d("\udedf\ua73d", -1053383851, -1439793752));
                    gyy = 9;
                    minecraftClient.scheduleStop();
                    break;
                }
                if (!(f > 40.0f)) break;
                System.out.println(a.b("\ud2a2\uab10\u21df\ubfa3\u3466\ub2cc\u08d7\u8172\u1f3c\u959b\u124f\ue86a\u66db\uff6d\u7536\uf3c2\u49ed\uc630\u5cd1\uda97\u5364\u2938\ua7c7\u3c44\uba2c\u30f4\u8944\u071b\u9de9\u1be6\u904f", -281423154) + minecraftClient.getOverlay());
                gyy = 9;
                minecraftClient.scheduleStop();
                break;
            }
        }
    }

    private static void gzg(boolean bl) {
        try {
            Field field = wap.class.getDeclaredField(a.d("\u785e\u01e4\u8b30\u155d\u9e9c\u1826", -1349352270, 1268251785));
            field.setAccessible(true);
            field.setBoolean(null, bl);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            System.out.println(a.b("\ub813\uc1a1\u4b6e\ud512\u5ed7\ud87d\u6266\uebc3\u758d\uff2a\u78fe\u82db\u0c4f\u95fc\u1fa0\u9918\u2304\uac81\u3661\ub026\u39c0\u43c5\ucd22\u56ef\ud09d\u5a09\ue3f6\u6daa\uf752\u710a\ufaab\u046e\u8e27\u17d4\u91c2\u1b20\ua4f0\u2e94\ua852\u31f2\ubbf2\uc519", 1209382986) + reflectiveOperationException);
        }
    }

    private static void gzh() {
        try {
            Field field = gtq.class.getDeclaredField(a.c(-503078855, "\ua04f\ud9f9\u533f\ucd5b\u469d"));
            field.setAccessible(true);
            field.setInt(null, 99);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            System.out.println(a.c(805425130, "\ucfbf\ub60d\u3cc2\ua2be\u297b\uafd1\u15ca\u9c6f\u0221\u8886\u0f52\uf577\u7be3\ue250\u680c\ueeb4\u54a8\udb2d\u41ce\uc78e\u4e6a\u3422\ubada\u215f\ua73c\u2de0\u9416\u1a14\u80f5\u06ad\u8d14\u7383\uf998\u6078\ue63d\u6c8b\ud312\u5979") + reflectiveOperationException);
        }
    }

    private static void gzi(MinecraftClient minecraftClient, String string, float f) {
        System.out.println(a.b("\u1b1b\u62a9\ue866\u761a\ufddf\u7b75\uc16e\u48cb\ud685\u5c22\udbf6\u21d3", -1286661276) + string + a.c(441512652, "\uf2ef\u8b0a\u0190") + f + a.c(135231358, "\u775d\u0e8c\u843f") + minecraftClient.getCurrentFps() + a.c(1389960858, "\u1ebe\u6749\ued8c\u73fe"));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.d("\ueaf1\u934a\u199a\u87f3\u0c61\u8acf", 2062906485, -2022662428) + string + a.b("\u86dc\uff33\u75fe\ueb86", 391350006)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
    }

    static {
        float[] fArray;
        boolean bl = gyw = System.getenv(a.d("\u041f\u7da4\uf774\u691d\ue2af\u6473\ude2c\u57de\uc99d\u4321\uc4e0\u3e8a\ub04a\u29f3\ua3b2\u254a\u9f0a\u10d7\u8a66\u0c3f", 976739528, -1374365563)) != null;
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
        return gyv.xu(n, n2) ^ 0x457A79EA;
    }
}

