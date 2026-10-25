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
 *  net.minecraft.client.MinecraftClient
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWNativeWin32
 */
package a;

import a.kfe;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import flow.Flow;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWNativeWin32;

final class gjl {
    private static final String[] gjm = new String[]{a.d("\u4138\u3880\ub253\u2c69\ua7ff\u2147\u9b17\u12f4", 1926793555, 71616524), a.b("\u8a9a\uf32a\u79ba\ue78a\u6c54\ueae6\u50a7\ud90a\u4709\ucda3\u4a68\ub00f\u3ecb\ua76c\u2d72", -743601414), a.d("\u60a1\u1911\u9381\u0daf\u8663\u00dc\uba80\u336d\uad6e\u2796\ua053\u5a34\ud4fb\u4d1a", 312056445, -515441987), a.b("\u18f4\u614c\ueb9f\u75a5\ufe2d\u7887\uc2da\u4b24\ud567", -1859774318), a.c(1103682452, "\udbf7\ua247\u28d7\ub6e7\u3d39\ubb8b\u01ca\u8862\u1676\u9cc0\u1b01\ue177")};
    private static final int gjn = 6;
    private static float gjo;
    private static /* synthetic */ boolean gjp;
    private static /* synthetic */ long gjq;

    private gjl() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\u7616\u0f85\u854c\u1b3b\u90fa\u166f\uac0e\u25ff\ubbba\u3111\ub6c5", -1841007024));
        if (n == 1) {
            minecraftClient.options.pauseOnLostFocus = false;
            gjl.gju(minecraftClient, a.b("\ub820\uc197\u4b48\ud531\u5eee\ud85d\u6205\uebf5\u75ef\uff0d\u78d8\u82ae\u0c7d\u95d3\u1f9f\u9979\u233b", 503560278));
            gjl.gju(minecraftClient, a.b("\ub211\ucbbd\u416a\udf13\u5481\ud263\u6826\ue1c6\u7fcd\uf532\u72e0\u8891\u0647", -441011608));
            gjl.gju(minecraftClient, a.c(2118270715, "\u3eb5\u4707\ucdd4\u53a6\ud877\u5ed1\ue4d6\u6d60\uf331\u799f\ufe5f\u046b\u8adc\u135e\u995e\u1ffd\ua5a5\u2a62\ub0cb\u3680\ubf70\uc534\u4b88\ud054\u562d\udcb9\u6543\ueb15\u71ea\uf7b4\u7c00\u82d6\u0884\u9164\u1772\u9dd1\u2201\ua870\u2eb6\ub753\u3d0a\u43fc\uc9bf"));
            gjl.gju(minecraftClient, a.c(-2102130111, "\u0a16\u73a8\uf97e\u670f\uec94\u6a7b\ud07b\u5991\uc7d8\u4d37\ucab7\u30da\ube1c\u27f3\uadf3\u2b19\u9140\u1ecf\u8434\u0273\u8bda\uf1d8\u7f77\ue4b7\u6296\ue80f\u51aa\udfb6\u4545\uc313\u48ab\ub67c\u3c22\ua5c0\u2394\ua937\u16ae\u9c96\u1a5b\u83e8\u09b7\u775d\ufd12\u7a94\ue06f\u6e19\ud7d1\u5d61\udb25"));
            gjl.gju(minecraftClient, a.b("\u92b8\ueb06\u61d0\uffa1\u743a\uf2d5\u48d5\uc13f\u5f76\ud599\u5214\ua83b\u26bf\ubf15\u3550\ub3ff\u09f8\u863f\u1cd2\u9ac9\u132a\u6925\ue7de\u7c19\ufa2b\u70fe\uc94a\u4710\udde1\u5ba1\ud001\u2ed7\ua48a\u3d35\ubb3d\u3184\u8e48", 997102331));
            gjl.gju(minecraftClient, a.b("\ucfcf\ub678\u3cb3\ua2c2\u2917\uafa7\u15ba\u9c06\u025d\u88eb\u0f33\uf544\u7b82\ue220\u6874\uee97\u5496\udb07\u41a1\uc7f2\u4e0a\u3450\ubaef\u217b\ua75a\u2dc4\u9468\u1a22\u80c0\u06cf\u8d22\u73ad\uf9af\u604d\ue645\u6cc1\ud337\u5968\udfb3\u4671\ucc25\ub287\u389a\ubf54\u25b9\uabcd\u1217\u98ad\u1ef8\u8567\u0b1f\uf19d\u7864\ufe49\u648f\ueac9\u5177\ud7bc\u5dd5\uc403\u4aa5\u30ff\ub701\u3d56\ua3ae\u2a28\u906f\u169a\u9cd1\u037b\u89bf\u0fcf\uf64e\u7cf4\ue2f4\u691a", -1216753680));
            return false;
        }
        if (!minecraftClient.isWindowFocused()) {
            gjl.gjr(minecraftClient);
        }
        if (minecraftClient.currentScreen == null && !minecraftClient.mouse.isCursorLocked()) {
            minecraftClient.mouse.lockCursor();
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
            kfe2.setEnabled(gjm[n3].startsWith(a.d("\ua504\udcb4", 502728803, 140422410)));
            minecraftClient.player.setYaw(0.0f);
            minecraftClient.player.setPitch(0.0f);
        } else if (n4 == 10) {
            gjo = minecraftClient.player.getYaw();
        } else if (n4 > 10 && n4 <= 16) {
            int n5 = gjm[n3].contains(a.b("\u1e5e\u67f4\ued29\u7357\uf89c", -118022615)) ? 1 : -1;
            int n6 = gjm[n3].contains(a.c(857404759, "\uf535\u8c83\u0642\u9834")) ? 60 : 8;
            for (int i = 0; i < 4; ++i) {
                gjl.gjt(n5 * n6 / 4);
            }
        } else if (n4 == 28) {
            float f = minecraftClient.player.getYaw() - gjo;
            System.out.printf(a.c(29663991, "\ua2af\udb1c\u51d5\ucfa2\u4463\uc2c5\u7881\uf174\u6f26\ue5db\u620d\u982a\u16b4\u8f1f\u0518\u83e8\u39a0\ub66d\u2cd5\uaa85\u2336\u5962\ud7da\u4c16\uca3c\u40ab\uf95c\u770c\uedf9\u6be3\ue05c\u1ecb\u948d\u0d70\u8b35\u0182\ube43\u3433\ub2b9\u2b10\ua119\udfbb\u55a4\ud216\u48cd\uc6b4\u7f69\uf5d9\u73cf\ue806\u6623\u9ca4\u1558"), gjm[n3], Float.valueOf(f), minecraftClient.isWindowFocused(), minecraftClient.mouse.isCursorLocked());
        }
        return false;
    }

    private static void gjr(MinecraftClient minecraftClient) {
        WinDef.HWND hWND = new WinDef.HWND(new Pointer(GLFWNativeWin32.glfwGetWin32Window((long)minecraftClient.getWindow().getHandle())));
        gjl.gjs(18, 0);
        gjl.gjs(18, 2);
        User32.INSTANCE.ShowWindow(hWND, 9);
        User32.INSTANCE.SetForegroundWindow(hWND);
        GLFW.glfwFocusWindow((long)minecraftClient.getWindow().getHandle());
    }

    private static void gjs(int n, int n2) {
        WinUser.INPUT iNPUT = new WinUser.INPUT();
        iNPUT.type = new WinDef.DWORD(1L);
        iNPUT.input.setType(a.d("\udb25\ua296", -723584777, 1964778427));
        iNPUT.input.ki.wVk = new WinDef.WORD((long)n);
        iNPUT.input.ki.dwFlags = new WinDef.DWORD((long)n2);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1L), (WinUser.INPUT[])iNPUT.toArray(1), iNPUT.size());
    }

    private static void gjt(int n) {
        WinUser.INPUT iNPUT = new WinUser.INPUT();
        iNPUT.type = new WinDef.DWORD(0L);
        iNPUT.input.setType(a.b("\uf013\u89a6", -1770983300));
        iNPUT.input.mi.dx = new WinDef.LONG((long)n);
        iNPUT.input.mi.dy = new WinDef.LONG(0L);
        iNPUT.input.mi.dwFlags = new WinDef.DWORD(1L);
        iNPUT.input.mi.time = new WinDef.DWORD(0L);
        iNPUT.input.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(0L);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1L), (WinUser.INPUT[])iNPUT.toArray(1), iNPUT.size());
    }

    private static void gju(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static /* synthetic */ int ug(int n, int n2) {
        return n + n2 | 0xC33E6995;
    }

    private static /* synthetic */ int uh(int n, int n2) {
        return gjl.ug(n, n2) + n;
    }

    private static /* synthetic */ int ui(int n, int n2) {
        return gjl.uh(n, n2) ^ 0x9A500DAD;
    }
}

