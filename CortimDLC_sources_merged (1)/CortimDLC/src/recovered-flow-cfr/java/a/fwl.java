/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.AccessibilityOnboardingScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.jte;
import a.kbm;
import a.kbs;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.ScreenshotRecorder;

public final class fwl {
    private static int fwm;
    private static int fwn;
    private static jte fwo;
    private static /* synthetic */ boolean fwp;
    private static /* synthetic */ int fwq;

    private fwl() {
    }

    public static void install() {
        if (Boolean.getBoolean(a.c(997354048, "\u6a28\u1393\u9943\u072a\u8cb8\u0a15\ub01b\u39fc\ua7aa\u2d11\uaad0\u50b0\ude71\u47c7")) && a.c(1768596395, "\ua3c5\uda7e\u50ae\ucec7\u450a\uc3b3\u79eb\uf001").equals(System.getenv(a.c(-1010832933, "\ue989\u9032\u1ae2\u848b\u0f39\u89e5\u33ba\uba5d\u240b\uaeb0\u2971\ud311\u5dd0\uc466\u4e3e\uc8c3\u729c\ufd4b\u67f3\ue1a9")))) {
            ClientTickEvents.END_CLIENT_TICK.register(fwl::fwr);
        }
    }

    private static void fwr(MinecraftClient minecraftClient) {
        ++fwn;
        try {
            if (fwo == null) {
                Screen screen;
                if (minecraftClient.method_18506() == null && minecraftClient.field_1755 instanceof AccessibilityOnboardingScreen) {
                    minecraftClient.field_1690.field_41785 = false;
                    minecraftClient.method_1507((Screen)new TitleScreen());
                }
                if (minecraftClient.method_18506() == null && (screen = minecraftClient.field_1755) instanceof jte) {
                    jte jte2 = (jte)screen;
                    if (fwn > 60) {
                        fwo = jte2;
                        fwn = 0;
                    }
                }
                return;
            }
            if (fwn % 50 != 0) {
                return;
            }
            switch (fwm++) {
                case 0: {
                    fwl.fws(a.d("\ud0ed\ua943\u239d\ubded\u3630\ub0d4\u0adb\u8320\u1d7c\u97d5\u105c\uea64\u64b6\ufd14\u775e", 1683244346, -1894017618));
                    kbm.POSITION.set(a.d("\ue22a\u9bb2\u1162\u8f01", -1602350262, 1137307944));
                    kbm.BUTTONS.set(a.c(1231351652, "\uef26\u96bc\u1c62\u8201\u09d6"));
                    break;
                }
                case 1: {
                    fwl.fwu(minecraftClient, a.b("\u652d\u1c96\u9646\u082f\u83e2\u055b\ubf03\u36e9\ua8ee\u2210\ua5cd\u5fb1\ud164\u48dd\uc2c8\u4478\ufe3e\u71ec\ueb4d", -1847827112));
                    break;
                }
                case 2: {
                    kbm.POSITION.set(a.b("\u3d6e\u44f9\uce21\u504a\udb8c\u5d2a", 746929451));
                    break;
                }
                case 3: {
                    fwl.fwu(minecraftClient, a.d("\u431d\u3aa6\ub076\u2e1f\ua5d2\u236b\u9933\u10d9\u8ede\u0420\u83fd\u7981\uf754\u6eed\ue4f8\u6247\ud80e\u57d4\ucd7d\u4b3d\uc2dd", -111760188, 1694887850));
                    break;
                }
                case 4: {
                    kbm.POSITION.set(a.c(1998370238, "\ub5e9\ucc63\u46be\ud8c0\u530b"));
                    break;
                }
                case 5: {
                    fwl.fwu(minecraftClient, a.b("\u8a6d\uf3d6\u7906\ue76f\u6ca2\uea1b\u5043\ud9a9\u47ae\ucd50\u4a8d\ub0f1\u3e24\ua79d\u2d88\uab26\u1172\u9ead\u0411\u825c", -2134210017));
                    break;
                }
                case 6: {
                    fwl.fws(a.b("\uef0b\u96a5\u1c7b\u820b\u09d6\u8f32\u353d\ubcc6\u229a\ua833\u2fba\ud58a\u5b58\uc2e7\u48bb\uce56", 2029317997));
                    kbm.POSITION.set(a.d("\uf54b\u8cd3\u0603\u9860", 2099475610, 956400025));
                    break;
                }
                case 7: {
                    fwl.fwu(minecraftClient, a.d("\u89be\uf005\u7ad5\ue4bc\u6f71\ue9c8\u5390\uda7a\u447d\uce96\u495a\ub32a\u3de0\ua440\u2e5b\ua8eb\u12ad\u9d7f\u07de", 1993077602, -1007584599));
                    break;
                }
                case 8: {
                    kbm.POSITION.set(a.b("\u42aa\u3b3d\ub1e5\u2f8e\ua448\u22ee", 1546994415));
                    fwl.fwt(a.c(-96410484, "\ue4f6\u9d5e\u1787\u89fe\u0227\u8481\u3eef\ub721\u296b\ua3d1"), true);
                    break;
                }
                case 9: {
                    fwl.fwu(minecraftClient, a.b("\ua0e1\ud95a\u538a\ucde3\u462e\uc097\u7acf\uf325\u6d22\ue7c9\u6005\u9a75\u14bf\u8d1f\u0704\u81bb\u3bf2\ub428\u2e81\ua8c1\u2121", 659267730));
                    break;
                }
                case 10: {
                    fwl.fws(a.c(447829818, "\u5743\u2eed\ua433\u3a43\ub19e\u377a\u8d75\u048e\u9ad2\u107b\u97f2\u6dca\ue318\u7aba\uf0f0"));
                    kbm.POSITION.set(a.c(-760200350, "\u432a\u3ab2\ub062\u2e01"));
                    fwl.fwt(a.d("\u860d\uffa5\u757c\ueb05\u60dc\ue67a\u5c14\ud5da\u4b90\uc12a", -538040193, -2090357240), true);
                    break;
                }
                case 11: {
                    fwl.fwu(minecraftClient, a.d("\u3aac\u4317\uc9c7\u57ae\udc63\u5ada\ue082\u6968\uf76f\u7d83\ufa492\u8eed\u1752\u9d16", 2097088531, -997444906));
                    break;
                }
                case 12: {
                    fwl.fwt(a.c(1210179599, "\ue075\u99dd\u1304\u8d7d\u06a4\u8002\u3a6c\ub3a2\u2de8\ua752"), false);
                    minecraftClient.method_1521();
                    fwn = 30;
                    break;
                }
                case 13: {
                    fwl.fwu(minecraftClient, a.d("\uefbd\u9606\u1cd6\u82bf\u0972\u8fcb\u3593\ubc79\u227e\ua890\u2f54\ud52c\u5bf8\uc247\u4811", -115584705, 2013970155));
                    break;
                }
                default: {
                    if (minecraftClient.method_18506() != null) {
                        --fwm;
                        return;
                    }
                    kbm.reset();
                    System.out.println(a.c(1859703475, "\ud2c6\uab7d\u21ad\ubfc4\u3444\ub2b8\u08e3\u8119\u1f5d\u95b9\u123e\ue85e\u669f\uff29\u752e\uf3af\u49f1\uc632\u5c81"));
                    minecraftClient.method_1592();
                    fwn = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println(a.c(1722832086, "\u54a5\u2d1e\ua7ce\u39a7\ub227\u34db\u8e80\u077a\u993e\u13da\u945d\u6e3d\ue0fc\u794a\uf34d\u75da\ucf92\u404b\udafd\u5cda\ud537") + throwable);
            throwable.printStackTrace();
            minecraftClient.method_1592();
            fwn = Integer.MIN_VALUE;
        }
    }

    private static void fws(String string) throws Exception {
        Method method = jte.class.getDeclaredMethod(a.d("\uc5f4\ubc5c\u3685\ua8fc", -13756320, -1431118368), kbs.class);
        method.setAccessible(true);
        method.invoke((Object)fwo, kbs.byKey(string));
    }

    private static void fwt(String string, Object object) throws Exception {
        Field field = jte.class.getDeclaredField(string);
        field.setAccessible(true);
        field.set((Object)fwo, object);
    }

    private static void fwu(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\uf25a\u8be1\u0131\u9f58\u14d8\u9224\u287f\ua185\u3fc1\ub525\u32a2\uc8c2\u4603\udfb5\u55b2", 195752499) + string);
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\u409a\u3921\ub3f1\u2d98\ua60a\u20a4", 1867066142, 771714020) + string + a.c(757021108, "\u399e\u4071\ucabc\u54c4")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> {});
    }

    private static /* synthetic */ int ru(int n, int n2) {
        return n ^ n2 | 0xEDA8F51F;
    }

    private static /* synthetic */ int rv(int n, int n2) {
        return n * n2 + 774725973;
    }
}

