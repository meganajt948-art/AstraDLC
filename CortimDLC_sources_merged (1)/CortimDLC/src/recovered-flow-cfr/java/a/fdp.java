/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.util.ScreenshotRecorder
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.hlc;
import a.ign;
import a.ldr;
import a.tiq;
import flow.dev.a;
import java.io.File;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ScreenshotRecorder;
import org.lwjgl.glfw.GLFW;

final class fdp {
    private static final String fdq = System.getenv().getOrDefault(a.c(231149979, "\u11cf\u6874\ue2a4\u7ccd\uf77f\u71a3\ucbee\u420b\udc53\u56f1\ud13c\u2b42\ua597\u3c3b\ub661\u309f\u8ad5\u050d"), a.d("\ue2f7\u9b72\u11a6\u8fc4\u0426\u82a6\u38e3\ub115", 146637828, -1505270086));
    private static /* synthetic */ long fdr;
    private static /* synthetic */ boolean fds;

    private fdp() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        if (n == 1) {
            GLFW.glfwSetWindowSize((long)minecraftClient.getWindow().getHandle(), (int)1600, (int)900);
        }
        if (n == 20) {
            tiq tiq2 = tiq.open(fdq);
            System.out.println(a.d("\u8879\uf1dc\u7b08\ue56a\u6efc\ue81e\u524a\udbba\u45f4\ucf48\u489d\ub2a3\u3c20\ua580\u2fc5\ua933\u1328\u9ca9\u0618\u8054\u09aa\u73f4\ufd42\u669a\ue0a0", -1612905752, 2048756457) + fdq + a.d("\ub157\uc8fc", -52326856, 1386692439) + (tiq2 == null ? a.b("\uf90c\u80b9\u0a70\u9401\u1fcc\u997a\u2320", -1512048282) : tiq2.purpose() + a.b("\ub63b\ucf86\u4514\udb71\u50a1\ud603\u6c11\ue5ad\u7bf0\uf14a\u7698\u8ce0\u027b", -1603684838) + (tiq2.auraModel() != null)));
            ldr.activate(tiq2);
            minecraftClient.setScreen((Screen)new hlc());
        }
        if (n == 32) {
            ign.open();
        }
        if (n == 65) {
            System.out.println(a.c(2095983040, "\u29a6\u5001\udadb\u44a0\ucf31\u49d4\uf396\u7a71\ue429\u6ecc\ue95e\u133b\u9deb\u0449\u8e56\u08f9\ub2b1\u3d61\ua7c3\u219f\ua86e"));
            ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)a.c(111842120, "\u933b\uea80\u6050\ufe39\u75ab\uf305\u491a\uc0ff\u5ea7\ud405\u539a\ua9b5\u2765\ubed5\u3497\ub26b\u0822\u87b2\u1d5f\u9b10\u12ee"), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
        }
        if (n == 75) {
            minecraftClient.setScreen(null);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int nt(int n, int n2) {
        return n ^ n2 | 0x1CB2367B;
    }

    private static /* synthetic */ int nu(int n, int n2) {
        return fdp.nt(n, n2) ^ 0x12FA01D1;
    }

    private static /* synthetic */ int nv(int n, int n2) {
        return fdp.nu(n, n2) + n;
    }
}

