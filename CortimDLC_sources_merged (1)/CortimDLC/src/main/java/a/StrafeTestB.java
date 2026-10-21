/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Pointer
 *  com.sun.jna.platform.win32.BaseTSD$ULONG_PTR
 *  com.sun.jna.platform.win32.User32
 *  com.sun.jna.platform.win32.WinDef$DWORD
 *  com.sun.jna.platform.win32.WinDef$HWND
 *  com.sun.jna.platform.win32.WinDef$LONG
 *  com.sun.jna.platform.win32.WinDef$WORD
 *  com.sun.jna.platform.win32.WinUser$INPUT
 *  net.minecraft.class_310
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWNativeWin32
 */
package a;

import a.Module;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import flow.Flow;
import flow.dev.StringDecryptor;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWNativeWin32;

final class StrafeTestB {
    private static final String[] gjm = new String[]{"off-left", "on-left(toward)", "on-right(away)", "off-right", "on-left-fast"};
    private static final int gjn = 6;
    private static float gjo;
    private static /* synthetic */ boolean gjp;
    private static /* synthetic */ long gjq;

    private StrafeTestB() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("MouseAssist");
        if (n == 1) {
            class_3102.field_1690.field_1837 = false;
            StrafeTestB.gju(class_3102, "gamemode survival");
            StrafeTestB.gju(class_3102, "time set noon");
            StrafeTestB.gju(class_3102, "effect give @s resistance infinite 255 true");
            StrafeTestB.gju(class_3102, "fill ~-6 ~-1 ~-6 ~6 ~-1 ~6 minecraft:smooth_stone");
            StrafeTestB.gju(class_3102, "fill ~-6 ~ ~-6 ~6 ~4 ~6 minecraft:air");
            StrafeTestB.gju(class_3102, "summon minecraft:zombie ~1.5 ~ ~3 {NoAI:1b,Silent:1b,PersistenceRequired:1b}");
            return false;
        }
        if (!class_3102.method_1569()) {
            StrafeTestB.gjr(class_3102);
        }
        if (class_3102.field_1755 == null && !class_3102.field_1729.method_1613()) {
            class_3102.field_1729.method_1612();
        }
        if (n < 40) {
            return false;
        }
        int n2 = 30;
        int n3 = (n - 40) / n2;
        int n4 = (n - 40) % n2;
        if (n3 >= gjm.length) {
            kfe2.setEnabled(false);
            return true;
        }
        if (n4 == 0) {
            kfe2.setEnabled(gjm[n3].startsWith("on"));
            class_3102.field_1724.method_36456(0.0f);
            class_3102.field_1724.method_36457(0.0f);
        } else if (n4 == 10) {
            gjo = class_3102.field_1724.method_36454();
        } else if (n4 > 10 && n4 <= 16) {
            int n5 = gjm[n3].contains("right") ? 1 : -1;
            int n6 = gjm[n3].contains("fast") ? 60 : 8;
            for (int i = 0; i < 4; ++i) {
                StrafeTestB.gjt(n5 * n6 / 4);
            }
        } else if (n4 == 28) {
            float f = class_3102.field_1724.method_36454() - gjo;
            System.out.printf("mousereal %s: turned %.3f deg, focused=%s locked=%s%n", gjm[n3], Float.valueOf(f), class_3102.method_1569(), class_3102.field_1729.method_1613());
        }
        return false;
    }

    private static void gjr(class_310 class_3102) {
        WinDef.HWND hWND = new WinDef.HWND(new Pointer(GLFWNativeWin32.glfwGetWin32Window((long)class_3102.method_22683().method_4490())));
        StrafeTestB.gjs(18, 0);
        StrafeTestB.gjs(18, 2);
        User32.INSTANCE.ShowWindow(hWND, 9);
        User32.INSTANCE.SetForegroundWindow(hWND);
        GLFW.glfwFocusWindow((long)class_3102.method_22683().method_4490());
    }

    private static void gjs(int n, int n2) {
        WinUser.INPUT iNPUT = new WinUser.INPUT();
        iNPUT.type = new WinDef.DWORD(1L);
        iNPUT.input.setType("ki");
        iNPUT.input.ki.wVk = new WinDef.WORD((long)n);
        iNPUT.input.ki.dwFlags = new WinDef.DWORD((long)n2);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1L), (WinUser.INPUT[])iNPUT.toArray(1), iNPUT.size());
    }

    private static void gjt(int n) {
        WinUser.INPUT iNPUT = new WinUser.INPUT();
        iNPUT.type = new WinDef.DWORD(0L);
        iNPUT.input.setType("mi");
        iNPUT.input.mi.dx = new WinDef.LONG((long)n);
        iNPUT.input.mi.dy = new WinDef.LONG(0L);
        iNPUT.input.mi.dwFlags = new WinDef.DWORD(1L);
        iNPUT.input.mi.time = new WinDef.DWORD(0L);
        iNPUT.input.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(0L);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1L), (WinUser.INPUT[])iNPUT.toArray(1), iNPUT.size());
    }

    private static void gju(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static /* synthetic */ int ug(int n, int n2) {
        return n + n2 | 0xC33E6995;
    }

    private static /* synthetic */ int uh(int n, int n2) {
        return StrafeTestB.ug(n, n2) + n;
    }

    private static /* synthetic */ int ui(int n, int n2) {
        return StrafeTestB.uh(n, n2) ^ 0x9A500DAD;
    }
}

