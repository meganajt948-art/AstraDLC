/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWKeyCallback
 *  org.lwjgl.glfw.GLFWKeyCallbackI
 */
package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

public final class wek {
    private static GLFWKeyCallback wel;
    private static GLFWKeyCallbackI wem;
    private static long wen;
    private static Boolean weo;
    private static /* synthetic */ String wep;
    private static /* synthetic */ long weq;

    private wek() {
    }

    public static void tick(MinecraftClient minecraftClient) {
        wek.wer(minecraftClient);
        if (minecraftClient.field_1690 != null) {
            if (weo == null) {
                weo = minecraftClient.field_1690.field_1837;
            }
            minecraftClient.field_1690.field_1837 = false;
        }
    }

    public static void shutdown(MinecraftClient minecraftClient) {
        if (weo == null || minecraftClient.field_1690 == null || weo == minecraftClient.field_1690.field_1837) {
            return;
        }
        minecraftClient.field_1690.field_1837 = weo;
        try {
            minecraftClient.field_1690.method_1640();
        }
        catch (Throwable throwable) {
            System.out.println(a.b("\ub96e\uc0dd\u4a01\ud439\u5fbd\ud958\u634c\ueab3\u74f3\ufe51\u79c7\u83f9\u0d31\u9484\u1eca\u983d\u2273\uadbf\u3751\ub15a\u38a1\u42fc\ucc1b\u5783\ud1e1\u5b37\ue2d7\u6cd6\uf630\u7075\ufbc0\u0507\u8f00\u16b3\u90e1\u1a13\ua58f\u2ff7\ua928\u308f\ubad6\uc474\u4e65\uc9d7\u5302\udd7b\u64f9\uee52", -401295043) + throwable);
        }
    }

    private static void wer(MinecraftClient minecraftClient) {
        if (minecraftClient.method_22683() == null) {
            return;
        }
        long l = minecraftClient.method_22683().method_4490();
        if (l == 0L || wen == l) {
            return;
        }
        wen = l;
        try {
            if (wel == null) {
                wel = GLFWKeyCallback.create(wek::wes);
            }
            wem = GLFW.glfwSetKeyCallback((long)l, (GLFWKeyCallbackI)wel);
        }
        catch (Throwable throwable) {
            System.out.println(a.d("\u40bf\u390c\ub3d0\u2de8\ua66c\u2089\u9a8e\u136a\u8d3f\u0780\u8016\u7a04\uf4e4\u6d53\ue71e\u61a8\udb8e\u543d\ucec8\u488d\uc167\ubb34\u35ca\uae4f\u282c\ua2f0\u1b06\u9519\u0fe1\u89a3\u0210\ufcd2\u7688\uef62\u692c\ue3d5\u5c18", -1126015439, 379657928) + throwable);
        }
    }

    private static void wes(long l, int n, int n2, int n3, int n4) {
        if (n == 66) {
            n4 &= 0xFFFFFFF5;
        }
        if (wem != null) {
            wem.invoke(l, n, n2, n3, n4);
        }
    }

    private static /* synthetic */ int dpz(int n, int n2) {
        return n * n2 ^ 0x6C8BB69F;
    }

    private static /* synthetic */ int dqa(int n, int n2) {
        return wek.dpz(n, n2) + n;
    }

    private static /* synthetic */ int dqb(int n, int n2) {
        return wek.dpz(n, n2) ^ 0x10BCF763;
    }
}

