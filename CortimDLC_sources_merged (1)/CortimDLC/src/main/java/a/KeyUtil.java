/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_1041
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3675$class_307
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.Bot;
import a.BotRuntime;
import java.util.function.IntPredicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1041;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import org.lwjgl.glfw.GLFW;

public final class KeyUtil {
    private static final int waa = -100;
    private static final int wab = 8;
    private static final int wac = 16;
    private static final int wad = 7;
    public static volatile IntPredicate simulated;
    private static /* synthetic */ boolean wae;
    private static /* synthetic */ boolean waf;

    private KeyUtil() {
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
        return n <= 0 || n2 == 0 || KeyUtil.isModifier(n) ? n : n | (n2 &= 7) << 16;
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

    public static boolean isDown(class_310 class_3102, int n) {
        if (n == -1 || class_3102.method_22683() == null) {
            return false;
        }
        if (KeyUtil.isMouse(n)) {
            return GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)KeyUtil.mouseButton(n)) == 1;
        }
        int n2 = KeyUtil.mods(n);
        if ((n2 & 1) != 0 && !KeyUtil.wag(class_3102, 340, 344) || (n2 & 2) != 0 && !KeyUtil.wag(class_3102, 341, 345) || (n2 & 4) != 0 && !KeyUtil.wag(class_3102, 342, 346)) {
            return false;
        }
        int n3 = KeyUtil.baseKey(n);
        IntPredicate intPredicate = simulated;
        if (intPredicate != null && n3 > 0 && intPredicate.test(n3)) {
            return true;
        }
        return n3 > 0 && class_3675.method_15987((class_1041)class_3102.method_22683(), (int)n3);
    }

    public static int heldMods(class_310 class_3102) {
        if (class_3102.method_22683() == null) {
            return 0;
        }
        return (KeyUtil.wag(class_3102, 340, 344) ? 1 : 0) | (KeyUtil.wag(class_3102, 341, 345) ? 2 : 0) | (KeyUtil.wag(class_3102, 342, 346) ? 4 : 0);
    }

    private static boolean wag(class_310 class_3102, int n, int n2) {
        return class_3675.method_15987((class_1041)class_3102.method_22683(), (int)n) || class_3675.method_15987((class_1041)class_3102.method_22683(), (int)n2);
    }

    public static boolean isPhysicallyDown(class_310 class_3102, class_304 class_3042) {
        Bot dtv2 = BotRuntime.current();
        if (dtv2 != null) {
            return dtv2.heldByHuman(class_3042);
        }
        class_3675.class_306 class_3062 = KeyBindingHelper.getBoundKeyOf((class_304)class_3042);
        if (class_3062.equals((Object)class_3675.field_16237)) {
            return false;
        }
        IntPredicate intPredicate = simulated;
        if (intPredicate != null && class_3062.method_1442() == class_3675.class_307.field_1668 && intPredicate.test(class_3062.method_1444())) {
            return true;
        }
        if (class_3062.method_1442() == class_3675.class_307.field_1672) {
            return GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)class_3062.method_1444()) == 1;
        }
        return class_3675.method_15987((class_1041)class_3102.method_22683(), (int)class_3062.method_1444());
    }

    private static /* synthetic */ int dnk(int n, int n2) {
        return n * n2 ^ 0x18DD82AE;
    }

    private static /* synthetic */ int dnl(int n, int n2) {
        return n + n2 ^ 0x681C48B4;
    }

    private static /* synthetic */ int dnm(int n, int n2) {
        return KeyUtil.dnl(n, n2) + n;
    }
}

