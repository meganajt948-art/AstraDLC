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
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.ScreenshotRecorder;

public final class gah {
    private static int gai;
    private static int gaj;
    private static jte gak;
    private static /* synthetic */ boolean gal;
    private static /* synthetic */ int gam;

    private gah() {
    }

    public static void install() {
        if (Boolean.getBoolean(a.b("\uc9e7\ub05c\u3a8c\ua4e5\u2f77\ua9da\u13d4\u9a33\u0465\u8ede\u091f\uf37f\u7dbe\ue408", -984495729)) && a.d("\uc92c\ub09e\u3a4d\ua438", -1825222353, 629708907).equals(System.getenv(a.c(-1880875410, "\u1e3c\u6787\ued57\u733e\uf88c\u7e50\uc40f\u4de8\ud3be\u5905\udec4\u24a4\uaa65\u33d3\ub98b\u3f76\u8529\u0afe\u9046\u161c")))) {
            ClientTickEvents.END_CLIENT_TICK.register(gah::gan);
        }
    }

    private static void gan(MinecraftClient minecraftClient) {
        ++gaj;
        try {
            if (gak == null) {
                Screen screen;
                if (minecraftClient.getOverlay() == null && minecraftClient.currentScreen instanceof AccessibilityOnboardingScreen) {
                    minecraftClient.options.onboardAccessibility = false;
                    minecraftClient.setScreen((Screen)new TitleScreen());
                }
                if (minecraftClient.getOverlay() == null && (screen = minecraftClient.currentScreen) instanceof jte) {
                    jte jte2 = (jte)screen;
                    if (gaj > 60) {
                        gak = jte2;
                        gaj = 0;
                    }
                }
                return;
            }
            if (gaj % 40 != 0) {
                return;
            }
            switch (gai++) {
                case 0: {
                    gah.gao(a.d("\ue05c\u99f4\u132d\u8d54\u068d\u802b\u3a45\ub38b\u2dc1\ua77b", 2099296420, -1495705470), true);
                    gah.gao(a.c(961953710, "\u3fd1\u4670\uccb2\u52de\ud90a\u5fbb\ue5d0\u6c14\uf258\u78fc\uff2d\u054d"), Float.valueOf(10000.0f));
                    break;
                }
                case 1: {
                    gah.gap(minecraftClient, a.d("\u724f\u0bfd\u812e\u1f5b\u94ca\u1266\ua828\u2184\ubfc2\u3579\ub2a2\u48dd\uc61d", -515919221, 589349029));
                    break;
                }
                case 2: {
                    gah.gao(a.c(-723980407, "\ueff3\u965b\u1c82\u82fb\u0922\u8f84\u35ea\ubc24\u226e\ua8d4"), false);
                    kbm.POSITION.set(a.c(-577870408, "\u65f0\u1c68\u96b8\u08db"));
                    kbm.BUTTONS.set(a.d("\u7290\u0b1b\u81c9\u1fa0\u9472\u12c4\ua89c", 327430107, 900553987));
                    kbm.TITLE.set(false);
                    kbm.BLUR.set(0.0);
                    break;
                }
                case 3: {
                    gah.gap(minecraftClient, a.c(746787578, "\u128d\u6b3f\ue1ec\u7f99\uf408\u72a5\uc8ea\u415a\udf0c\u55be\ud27f\u2857\ua6c2\u3f69\ub53b\u33d2\u8998\u064e\u9cf6\u1aef\u935b\ue90b\u67a3\ufc6f\u7a0d\uf0c4\u497e"));
                    break;
                }
                case 4: {
                    kbm.POSITION.set(a.d("\u652d\u1ca7\u967a\u0804\u83cf", 1511596505, 1296647331));
                    kbm.BUTTONS.set(a.b("\u2b46\u52d2\ud812\u467a", -1879889146));
                    kbm.TITLE.set(true);
                    kbm.ROUND.set(0.3);
                    kbm.DIM.set(0.3);
                    break;
                }
                case 5: {
                    gah.gap(minecraftClient, a.b("\ud291\uab23\u21f0\ubf85\u3414\ub2ba\u08f6\u8158\u1f1c\u95a3\u127f\ue812\u669c\uff64\u7532\uf3d0\u4986", 774951660));
                    break;
                }
                case 6: {
                    kbm.POSITION.set(a.c(-1438094032, "\u6d75\u14e2\u9e3aQ\u8b97\u0d31"));
                    kbm.BUTTONS.set(a.b("\u143a\u6dae\ue773\u790d\uf2c6", -1657990029));
                    kbm.ROUND.set(1.0);
                    kbm.DIM.set(0.0);
                    kbm.BLUR.set(0.5);
                    gah.gao(a.d("\u348b\u4d23\uc7fa\u5983\ud25a\u54fc\uee92\u675c\uf916\u73ac", 692601086, 1144681487), true);
                    break;
                }
                case 7: {
                    gah.gap(minecraftClient, a.d("\u48a5\u3117\ubbc4\u25b1\uae20\u288f\u92c2\u1b72\u8528\u0f97\u884b\u7226\ufca8\u6544\uef0e\u69f5\ud3b2\u5c6d\uc6c9", 532829353, -810935181));
                    break;
                }
                default: {
                    kbm.reset();
                    gah.gao(a.b("\u5d32\u249a\uae43\u303a\ubbe3\u3d45\u872b\u0ee5\u90af\u1a15", 1847549256), false);
                    System.out.println(a.b("\u2246\u5bf4\ud127\u4f52\uc4ce\u422b\uf869\u718e\uefd6\u6533\ue290\u18f0\u9635\u0f84", 0x54522224));
                    minecraftClient.scheduleStop();
                    gaj = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println(a.d("\u9657\uefe5\u6536\ufb43\u70df\uf63a\u4c78\uc59f\u5bc7\ud122\u5697\uace1\u223e\ubb8a\u31af\ub744", 1581932315, 1981729072) + throwable);
            throwable.printStackTrace();
            minecraftClient.scheduleStop();
            gaj = Integer.MIN_VALUE;
        }
    }

    private static void gao(String string, Object object) throws Exception {
        Field field = jte.class.getDeclaredField(string);
        field.setAccessible(true);
        field.set((Object)gak, object);
    }

    private static void gap(MinecraftClient minecraftClient, String string) {
        System.out.println(a.d("\uadea\ud458\u5e8b\uc0fe\u4b62\ucd87\u77c5\ufe22\u607a\uea9f", -1702102730, -1614588742) + string);
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\ueebd\u9706\u1dd6\u83bf\u082d\u8e83", 1098837725) + string + a.d("\uba49\uc3a6\u496b\ud713", 1308586951, -234239580)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
    }

    private static /* synthetic */ int su(int n, int n2) {
        return n * n2 ^ 0xD99817BD;
    }
}

