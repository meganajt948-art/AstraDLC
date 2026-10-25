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
 *  net.minecraft.client.gui.screen.world.CreateWorldScreen
 *  net.minecraft.client.util.ScreenshotRecorder
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.hlc;
import a.isv;
import a.jte;
import a.kbp;
import a.kbs;
import com.sun.management.OperatingSystemMXBean;
import flow.dev.a;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.util.ScreenshotRecorder;
import org.lwjgl.glfw.GLFW;

public final class hem {
    private static final float[] hen = new float[]{0.4f, 1.2f, 1.45f, 2.5f, 4.0f, 5.9f, 6.6f, 8.0f};
    private static final float[] heo = new float[]{1.0f, 1.6f, 3.0f};
    private static int hep;
    private static long heq;
    private static int her;
    private static int hes;
    private static jte het;
    private static kbs heu;
    private static String hev;
    private static int hew;
    private static long hex;
    private static long hey;
    private static /* synthetic */ long hez;
    private static /* synthetic */ int hfa;

    private hem() {
    }

    public static void install() {
        if (Boolean.getBoolean(a.b("\u3068\u49d3\uc303\u5d6a\ud6f8\u5055\uea5b\u63bc\ufdea\u7751\uf090\u0af0\u8431\u1d87", 767963136)) && a.c(1596259544, "\ufcab\u8505\u0fdb\u91ab\u1a76").equals(System.getenv(a.d("\ud70d\uaeb6\u2466\uba0f\u31bd\ub761\u0d3e\u84d9\u1a8f\u9034\u17f5\ued95\u6354\ufae2\u70ba\uf647\u4c18\uc3cf\u5977\udf2d", -1768064936, -1743671545)))) {
            ClientTickEvents.END_CLIENT_TICK.register(hem::hfd);
        }
    }

    private static float hfb() {
        return (float)(System.nanoTime() - heq) / 1.0E9f;
    }

    private static void hfc() {
        heq = System.nanoTime();
        her = 0;
    }

    private static void hfd(MinecraftClient minecraftClient) {
        ++hes;
        try {
            hem.hfe(minecraftClient);
        }
        catch (Throwable throwable) {
            System.out.println(a.b("\u4ef9\u3757\ubd89\u23f9\ua824\u2eda\u94dd\u1d3d\u8374\u09c2\u8e45\u7452\ufa82\u633b\ue96d\u6fea\ud5bf", -1621799266) + throwable);
            throwable.printStackTrace();
            hep = 99;
            minecraftClient.scheduleStop();
        }
    }

    private static void hfe(MinecraftClient minecraftClient) throws Exception {
        switch (hep) {
            case 0: {
                Screen screen;
                if (minecraftClient.getOverlay() == null && minecraftClient.currentScreen instanceof AccessibilityOnboardingScreen) {
                    minecraftClient.options.onboardAccessibility = false;
                    minecraftClient.setScreen((Screen)new TitleScreen());
                }
                if (minecraftClient.getOverlay() != null || !((screen = minecraftClient.currentScreen) instanceof jte)) break;
                jte jte2 = (jte)screen;
                if (hes <= 60) break;
                het = jte2;
                heu = kbs.selected();
                hem.hfg(kbs.byKey(a.c(-1424319468, "\u9c6f\ue5c1\u6f1f\uf16f\u7ab2\ufc56\u464c\ucfbe\u51f0\udb52\u5c98\ua6ee\u2830")));
                hem.hfc();
                hep = 1;
                break;
            }
            case 1: {
                if (her < hen.length && hem.hfb() >= hen[her]) {
                    hem.hfh(minecraftClient, a.c(-2130813552, "\u5ded\u2443\uae9d\u30ed\ubb30\u3dc3\u87d0\u0e29\u907d\u1ad7\u9d5c") + her);
                    ++her;
                    break;
                }
                if (her != hen.length || !hem.hff(minecraftClient, a.d("\u47de\u3e67\ub4bf\u2ad5", 2038568660, 1654280547), 9.0f, 4)) break;
                hem.hfc();
                hep = 10;
                break;
            }
            case 10: {
                String[] stringArray = new String[]{a.b("\u2a8b\u5325\ud9fb\u478b\ucc56\u4ab2\uf0b8\u7942\ue710\u6db6\uea65\u101f", -236573967), a.c(-1071065842, "\ud569\uacc7\u2619\ub869\u33b4\ub550\u0f58\u86bd\u18e3\u9253\u1598\uefea\u617e\uf881\u72d0\uf434\u4e7c"), a.d("\ua0ab\ud905\u53db\ucdab\u4676\uc092\u7a98\uf36b\u6d26\ue790\u605b\u9a23", 318335887, 2082786142), a.c(-708112594, "\u0f52\u76fc\ufc22\u6252\ue98f\u6f6b\ud571\u5c9d\uc2c3\u486a")};
                int n = her / 2;
                if (n >= stringArray.length) {
                    float f = kbp.scale(hem.het.width, hem.het.height);
                    int[] nArray = new int[1];
                    int[] nArray2 = new int[1];
                    GLFW.glfwGetWindowSize((long)minecraftClient.getWindow().getHandle(), (int[])nArray, (int[])nArray2);
                    float f2 = ((float)hem.het.height * 0.5f + -13.1f * f) / (float)hem.het.height;
                    GLFW.glfwSetCursorPos((long)minecraftClient.getWindow().getHandle(), (double)(0.5f * (float)nArray[0]), (double)(f2 * (float)nArray2[0]));
                    hem.hfc();
                    hep = 11;
                    break;
                }
                if (her % 2 == 0) {
                    hem.hfg(kbs.byKey(stringArray[n]));
                    ++her;
                    break;
                }
                if (!(hem.hfb() > 3.0f * (float)(n + 1))) break;
                hem.hfh(minecraftClient, a.c(-1639392780, "\ud989\ua027\u2af9\ub489\u3f54\ub9a7\u03b4\u8a4d\u1419\u9eb3\u1938") + stringArray[n].substring(6));
                ++her;
                break;
            }
            case 11: {
                if (!(hem.hfb() > 1.0f)) break;
                hem.hfh(minecraftClient, a.d("\u48b6\u3118\ubbc6\u25b6\uae6b\u2898\u928b\u1b72\u8526\u0f8c\u8807\u7233\ufce3\u654b\uef0b\u69ed", -1005863368, -2004683032));
                hem.hfg(heu);
                CreateWorldScreen.showTestWorld((MinecraftClient)minecraftClient, () -> minecraftClient.setScreen((Screen)new TitleScreen()));
                hep = 2;
                break;
            }
            case 2: {
                Object object = minecraftClient.currentScreen;
                if (!(object instanceof CreateWorldScreen)) break;
                CreateWorldScreen createWorldScreen = (CreateWorldScreen)object;
                object = CreateWorldScreen.class.getDeclaredMethod(a.c(-1629906922, "\u987e\ue1de\u6b1a\uf56f\u7ead\uf80d\u4277\ucbaf\u55e3\udf41\u589b"), new Class[0]);
                ((Method)object).setAccessible(true);
                ((Method)object).invoke((Object)createWorldScreen, new Object[0]);
                hes = 0;
                hep = 3;
                break;
            }
            case 3: {
                if (minecraftClient.world == null || minecraftClient.player == null || minecraftClient.currentScreen != null || hes <= 500) break;
                hev = isv.selected();
                isv.select(a.d("\u220f\u5ba9\ud166\u4f12\uc4dd\u4271\uf825\u7180\uef86\u6535\ue2f3\u1885", 2106112520, 501848169));
                minecraftClient.setScreen((Screen)new hlc());
                hem.hfc();
                hep = 30;
                break;
            }
            case 30: {
                if (!hem.hff(minecraftClient, a.d("\u1f33\u6690\uec5f\u7267\uf9e0\u7f49\uc51d\u4cf7\ud2b3\u584d\udfdc\u25aa\uab7e\u32c6\ub888\u3e6e", 658034700, 845598536), 2.0f, 5)) break;
                isv.select(a.b("\ufe93\u873d\u0de3\u9393\u184e\u9eaa\u24b0\uad42\u330c\ub9ae\u3e64\uc412\u4acc", -986841368));
                hem.hfc();
                hep = 4;
                break;
            }
            case 4: {
                if (her < heo.length && hem.hfb() >= heo[her]) {
                    hem.hfh(minecraftClient, a.b("\u9c96\ue538\u6fe6\uf196\u7a4b\ufcb8\u46a1\ucf42\u5101\udbf4", 1382325482) + her);
                    ++her;
                    break;
                }
                if (her != heo.length || !hem.hff(minecraftClient, a.b("\u668c\u1f2f\u95e0\u0bd8\u8059\u06f7\ubca9\u3559\uab0c", 731997922), 4.0f, 6)) break;
                isv.select(a.d("\uf8d4\u8172\u0bbd\u95c9\u1e06\u98aa\u22fe\uab5b\u355d\ubfee\u3828\uc25e", 660552764, -567229306));
                hem.hfc();
                hep = 5;
                break;
            }
            case 5: {
                if (her == 0 && hem.hfb() > 1.5f) {
                    hem.hfh(minecraftClient, a.b("\u677f\u1ed1\u940f\u0a7f\u81a2\u0751\ubd48\u34ab\uaae8\u201d\ua793\u5dfa\ud32a\u4a80\uc0c8", 482240262));
                    ++her;
                    break;
                }
                if (her != 1 || !hem.hff(minecraftClient, a.d("\ucd30\ub493\u3e5c\ua064\u2be3\uad4a\u171e\u9ef4\u00b0", -1919973888, -258061474), 2.0f, 4)) break;
                isv.select(hev);
                minecraftClient.setScreen(null);
                System.out.println(a.c(467844086, "\ubb8f\uc221\u48ff\ud68f\u5d52\udbac\u61ab\ue84b\u7602\ufcb4\u7b33\u8132\u0ff4\u9657\u1c04"));
                hep = 99;
                minecraftClient.scheduleStop();
                break;
            }
        }
    }

    private static boolean hff(MinecraftClient minecraftClient, String string, float f, int n) {
        int n2 = (int)Math.floor(hem.hfb() - f);
        if (n2 < 0 || n2 == hew) {
            return false;
        }
        hew = n2;
        if (n2 > 0) {
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
            long l = operatingSystemMXBean.getProcessCpuTime();
            long l2 = System.nanoTime();
            if (hex > 0L) {
                System.out.println(a.b("\u506a\u29c4\ua31a\u3d6a\ub6b7\u3049\u8a4e\u03ae\u9de7\u1751\u90d6\u6af6\ue425\u7d88\uf7d7\u7137\ucb2c", 1573343245) + string + a.b("\ua941\ud0a3\u5a66\uc411\u4fca\uc97a\u7323\ufa96", -90592919) + n2 + a.c(1230948482, "\uc8ba\ub111") + minecraftClient.getCurrentFps() + a.d("\uf342\u8ab5p\u9e02\u158a\u9337\u2934\ua0c7\u3e85\ub438\u33ed\uc98a\u475d\udebf\u54af\ud24d\u6807\ue783", -366423398, -1554308630) + (double)Math.round((double)(l - hex) * 1000.0 / (double)(l2 - hey)) / 10.0 + a.c(16680704, "\u8728\ufe9c\u7400\uea78\u61e9\ue717\u5d45\ud4bf\u4aa5\uc057\u4788\ubde4\u3324"));
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

    private static void hfg(kbs kbs2) throws Exception {
        Method method = jte.class.getDeclaredMethod(a.b("\u0662\u7fca\uf513\u6b6a", 1714947606), kbs.class);
        method.setAccessible(true);
        method.invoke((Object)het, kbs2);
    }

    private static void hfh(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u8b69\uf2c7\u7819\ue669\u6db4\ueb4a\u514d\ud8ad\u46e4\ucc52\u4bd5", -1710781676) + string + a.c(-1406982674, "\u25cd\u5c1c\ud6af") + minecraftClient.getCurrentFps() + a.d("\u1b95\u6262\ue8a7\u76d5", 808316819, 1487860770));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.c(1879829018, "\uea7a\u93c1\u1911\u8778\u0cea\u8a44") + string + a.b("\ue2fc\u9b13\u11de\u8fa6", 140960470)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
    }

    static {
        hew = -1;
    }

    private static /* synthetic */ int zl(int n, int n2) {
        return n * n2 + 238710565;
    }

    private static /* synthetic */ int zm(int n, int n2) {
        return hem.zl(n, n2) ^ 0x7868C0D2;
    }

    private static /* synthetic */ int zn(int n, int n2) {
        return hem.zm(n, n2) ^ 0x93A95522;
    }
}

