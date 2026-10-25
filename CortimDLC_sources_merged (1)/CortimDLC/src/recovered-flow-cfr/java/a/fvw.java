/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.hlc;
import a.wam;
import a.wap;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;

final class fvw {
    private static /* synthetic */ String fvx;
    private static /* synthetic */ String fvy;

    private fvw() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        Screen screen = minecraftClient.field_1755;
        switch (n) {
            case 1: {
                minecraftClient.method_1562().method_45730(a.c(206856521, "\u6130\u189c\u924b\u0c32\u87a0\u0142\ubb07\u32e7\uacec\u264b\ua19e\u5bef\ud538"));
                break;
            }
            case 60: {
                fvw.fwc(minecraftClient, a.b("\u5a04\u23ba\ua972\u3702\ubcd2\u3a7f\u8031\u09d1\u97c7\u1d2c\u9ae7\u608b\uee42\u77fb", 1038375532));
                break;
            }
            case 62: {
                minecraftClient.method_1507((Screen)new ChatScreen("", false));
                break;
            }
            case 100: {
                fvw.fwc(minecraftClient, a.d("\uabee\ud250\u5898\uc6e8\u4d38\ucb95\u71db\uf83b\u662d\uecd2\u6b0a\u9172\u1fb0", -1380226419, -1992507128));
                break;
            }
            case 102: {
                minecraftClient.method_1507(null);
                wap.set(wam.RU);
                fvw.fvz(minecraftClient);
                break;
            }
            case 150: {
                fvw.fwc(minecraftClient, a.c(1531803911, "\u7972\u00cc\u8a04\u1474\u9fa4\u1909\ua347\u2aa7\ub4b1\u3e4a\ub98b\u43e6\ucd75\u548a\uded5\u5826\ue266\u6db4\uf712"));
                break;
            }
            case 152: {
                fvw.fwa(screen, 400.0f, 23.0f, 0);
                for (char c : a.c(1995684410, "\uba4a\uc3fd\u4935\ud74a").toCharArray()) {
                    screen.method_25400(new CharInput((int)c, 0));
                }
                break;
            }
            case 170: {
                fvw.fwa(screen, 200.0f, 69.0f, 1);
                break;
            }
            case 200: {
                fvw.fwc(minecraftClient, a.d("\u5d5e\u24e0\uae28\u3058\ubb88\u3d25\u876b\u0e8b\u909d\u1a66\u9da7\u67ca\ue959\u70b1\ufae4\u7c0e\uc64f\u499e\ud32f\u5569\udc8e\ua6d2\u287a", 849381698, -988031891));
                break;
            }
            case 202: {
                for (int i = 0; i < 3; ++i) {
                    screen.method_25404(new KeyInput(256, 0, 0));
                }
                break;
            }
        }
        return n >= 215;
    }

    private static void fvz(MinecraftClient minecraftClient) throws Exception {
        Field field = hlc.class.getDeclaredField(a.d("\udd68\ua4cc\u2e1c\ub044\u3bbd\ubd10", -1607629551, -1950787573));
        field.setAccessible(true);
        field.set(null, a.d("\u6907\u109a\u9a4b\u0435\u8fe1\u0945", -473880015, 1275675507));
        for (String string : new String[]{a.d("\uac29\ud586\u5f52\uc129\u4af5\ucc5c\u7620", -1602852161, -219101466), a.d("\u43c1\u3a6e\ub0ba\u2ec1\ua51d\u23b4\u99c9", -1745119362, -1286417201)}) {
            Field field2 = hlc.class.getDeclaredField(string);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void fwa(Screen screen, float f, float f2, int n) throws Exception {
        if (!(screen instanceof hlc)) {
            return;
        }
        float f3 = fvw.fwb(screen, a.c(204217489, "\u1cf9\u6555\uef9d\u71e2\ufa3b\u7c8d\uc6e8"));
        float f4 = fvw.fwb(screen, a.b("\u773d\u0e91\u8459\u1a26\u91ff\u1749\uad2d", 1636071253));
        float f5 = fvw.fwb(screen, a.d("\u4cb5\u3514\ubfc5\u21b9\uaa67", 1629125131, -118999352));
        screen.method_25402(new Click((double)(f3 + f * f5), (double)(f4 + f2 * f5), new MouseInput(n, 0)), false);
    }

    private static float fwb(Object object, String string) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    private static void fwc(MinecraftClient minecraftClient, String string) {
        System.out.println(a.d("\u78c0\u0167\u8bbd\u15c6\u9e57\u18b2\ua2f0\u2b17\ub54f\u3faa", 1758870791, -1813559874) + string + a.c(-462910363, "\u8c46\uf597\u7f24") + minecraftClient.method_47599() + a.c(-1650675153, "\ub20b\ucbfc\u4139\udf4b"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(-1692160232, "\uaf78\ud6c3\u5c13\uc27a\u49e8\ucf46") + string + a.d("\u4086\u3969\ub3a4\u2ddc", 554766139, 1322143639)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int rn(int n, int n2) {
        return n * n2 | 0xA4664C7F;
    }

    private static /* synthetic */ int ro(int n, int n2) {
        return fvw.rn(n, n2) ^ 0xC60596;
    }
}

