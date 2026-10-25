/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.util.InputUtil$Type
 *  net.minecraft.client.util.Window
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.dtv;
import a.ejp;
import java.util.function.IntPredicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;

public final class vzz {
    private static final int waa = -100;
    private static final int wab = 8;
    private static final int wac = 16;
    private static final int wad = 7;
    public static volatile IntPredicate simulated;
    private static /* synthetic */ boolean wae;
    private static /* synthetic */ boolean waf;

    private vzz() {
    }

    public static int mouse(int n) {
        return -100 - n;
    }

    public static boolean isMouse(int n) {
        return n <= -100 && n > -108;
    }

    public static int mouseButton(int n) {
        return -100 - n;
    }

    public static int combo(int n, int n2) {
        return n <= 0 || n2 == 0 || vzz.isModifier(n) ? n : n | (n2 &= 7) << 16;
    }

    public static int baseKey(int n) {
        return n > 0 ? n & 0xFFFF : n;
    }

    public static int mods(int n) {
        return n > 0 ? n >>> 16 & 7 : 0;
    }

    public static boolean isModifier(int n) {
        return n == 340 || n == 344 || n == 341 || n == 345 || n == 342 || n == 346;
    }

    public static boolean isDown(MinecraftClient minecraftClient, int n) {
        if (n == -1 || minecraftClient.getWindow() == null) {
            return false;
        }
        if (vzz.isMouse(n)) {
            return GLFW.glfwGetMouseButton((long)minecraftClient.getWindow().getHandle(), (int)vzz.mouseButton(n)) == 1;
        }
        int n2 = vzz.mods(n);
        if ((n2 & 1) != 0 && !vzz.wag(minecraftClient, 340, 344) || (n2 & 2) != 0 && !vzz.wag(minecraftClient, 341, 345) || (n2 & 4) != 0 && !vzz.wag(minecraftClient, 342, 346)) {
            return false;
        }
        int n3 = vzz.baseKey(n);
        IntPredicate intPredicate = simulated;
        if (intPredicate != null && n3 > 0 && intPredicate.test(n3)) {
            return true;
        }
        return n3 > 0 && InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)n3);
    }

    public static int heldMods(MinecraftClient minecraftClient) {
        if (minecraftClient.getWindow() == null) {
            return 0;
        }
        return (vzz.wag(minecraftClient, 340, 344) ? 1 : 0) | (vzz.wag(minecraftClient, 341, 345) ? 2 : 0) | (vzz.wag(minecraftClient, 342, 346) ? 4 : 0);
    }

    private static boolean wag(MinecraftClient minecraftClient, int n, int n2) {
        return InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)n) || InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)n2);
    }

    public static boolean isPhysicallyDown(MinecraftClient minecraftClient, KeyBinding keyBinding) {
        dtv dtv2 = ejp.current();
        if (dtv2 != null) {
            return dtv2.heldByHuman(keyBinding);
        }
        InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding);
        if (key.equals((Object)InputUtil.UNKNOWN_KEY)) {
            return false;
        }
        IntPredicate intPredicate = simulated;
        if (intPredicate != null && key.getCategory() == InputUtil.Type.KEYSYM && intPredicate.test(key.getCode())) {
            return true;
        }
        if (key.getCategory() == InputUtil.Type.MOUSE) {
            return GLFW.glfwGetMouseButton((long)minecraftClient.getWindow().getHandle(), (int)key.getCode()) == 1;
        }
        return InputUtil.isKeyPressed((Window)minecraftClient.getWindow(), (int)key.getCode());
    }

    private static /* synthetic */ int dnk(int n, int n2) {
        return n * n2 ^ 0x18DD82AE;
    }

    private static /* synthetic */ int dnl(int n, int n2) {
        return n + n2 ^ 0x681C48B4;
    }

    private static /* synthetic */ int dnm(int n, int n2) {
        return vzz.dnl(n, n2) + n;
    }
}

