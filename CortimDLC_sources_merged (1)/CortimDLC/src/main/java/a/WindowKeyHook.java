/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWKeyCallback
 *  org.lwjgl.glfw.GLFWKeyCallbackI
 */
package a;

import flow.dev.StringDecryptor;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

public final class WindowKeyHook {
    private static GLFWKeyCallback wel;
    private static GLFWKeyCallbackI wem;
    private static long wen;
    private static Boolean weo;
    private static /* synthetic */ String wep;
    private static /* synthetic */ long weq;

    private WindowKeyHook() {
    }

    public static void tick(class_310 class_3102) {
        WindowKeyHook.wer(class_3102);
        if (class_3102.field_1690 != null) {
            if (weo == null) {
                weo = class_3102.field_1690.field_1837;
            }
            class_3102.field_1690.field_1837 = false;
        }
    }

    public static void shutdown(class_310 class_3102) {
        if (weo == null || class_3102.field_1690 == null || weo == class_3102.field_1690.field_1837) {
            return;
        }
        class_3102.field_1690.field_1837 = weo;
        try {
            class_3102.field_1690.method_1640();
        }
        catch (Throwable throwable) {
            System.out.println("can't give options.txt its pause-on-focus back: " + throwable);
        }
    }

    private static void wer(class_310 class_3102) {
        if (class_3102.method_22683() == null) {
            return;
        }
        long l = class_3102.method_22683().method_4490();
        if (l == 0L || wen == l) {
            return;
        }
        wen = l;
        try {
            if (wel == null) {
                wel = GLFWKeyCallback.create(WindowKeyHook::wes);
            }
            wem = GLFW.glfwSetKeyCallback((long)l, (GLFWKeyCallbackI)wel);
        }
        catch (Throwable throwable) {
            System.out.println("can't take Ctrl+B from the narrator: " + throwable);
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
        return WindowKeyHook.dpz(n, n2) + n;
    }

    private static /* synthetic */ int dqb(int n, int n2) {
        return WindowKeyHook.dpz(n, n2) ^ 0x10BCF763;
    }
}

