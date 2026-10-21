/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.Module;
import a.Reflect;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class StrafeTestA {
    private static final String[] gix = new String[]{"off-left-1", "toward-1", "away-1", "toward-2", "away-2", "toward-3", "away-3", "off-right-2", "toward-fast-40"};
    private static final int giy = 10;
    private static Field giz;
    private static Field gja;
    private static boolean gjb;
    private static volatile int gjc;
    private static double gjd;
    private static long gje;
    private static float gjf;
    private static /* synthetic */ boolean gjg;
    private static /* synthetic */ boolean gjh;

    private StrafeTestA() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("MouseAssist");
        if (n == 1) {
            class_3102.field_1690.field_1837 = false;
            giz = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1783", "Z");
            gja = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1695", "Z");
            if (!gjb) {
                gjb = true;
                WorldRenderEvents.END_MAIN.register(worldRenderContext -> StrafeTestA.gji());
            }
            StrafeTestA.gjk(class_3102, "gamemode survival");
            StrafeTestA.gjk(class_3102, "time set noon");
            StrafeTestA.gjk(class_3102, "effect give @s resistance infinite 255 true");
            StrafeTestA.gjk(class_3102, "fill ~-6 ~-1 ~-6 ~6 ~-1 ~6 minecraft:smooth_stone");
            StrafeTestA.gjk(class_3102, "fill ~-6 ~ ~-6 ~6 ~4 ~6 minecraft:air");
            StrafeTestA.gjk(class_3102, "summon minecraft:zombie ~1.5 ~ ~3 {NoAI:1b,Silent:1b,PersistenceRequired:1b}");
            return false;
        }
        StrafeTestA.gjj(class_3102);
        if (n < 40) {
            return false;
        }
        int n2 = 26;
        int n3 = (n - 40) / n2;
        int n4 = (n - 40) % n2;
        if (n3 >= gix.length) {
            gjc = 0;
            kfe2.setEnabled(false);
            return true;
        }
        String string = gix[n3];
        if (n4 == 0) {
            kfe2.setEnabled(!string.startsWith("off"));
            class_3102.field_1724.method_36456(0.0f);
            class_3102.field_1724.method_36457(0.0f);
        } else if (n4 == 4) {
            gjf = class_3102.field_1724.method_36454();
            gje = 0L;
            int n5 = Integer.parseInt(string.substring(string.lastIndexOf(45) + 1));
            boolean bl = string.contains("right") || string.startsWith("away");
            gjc = bl ? n5 : -n5;
        } else if (n4 == 14) {
            gjc = 0;
        } else if (n4 == 22) {
            double d = (Double)class_3102.field_1690.method_42495().method_41753() * 0.6 + 0.2;
            double d2 = (double)gje * d * d * d * 8.0 * 0.15;
            float f = class_3102.field_1724.method_36454() - gjf;
            System.out.printf("mouseframe %s: turned %.3f deg, vanilla %.3f deg, ratio %.3f%n", string, Float.valueOf(f), d2, (double)Math.abs(f) / Math.abs(d2));
        }
        return false;
    }

    private static void gji() {
        int n = gjc;
        if (n == 0) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        long l = class_3102.method_22683().method_4490();
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
        GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        gje += (long)Math.abs(n);
        gLFWCursorPosCallback.invoke(l, gjd += (double)n, 500.0);
    }

    private static void gjj(class_310 class_3102) throws Exception {
        if (giz != null && class_3102.field_1755 == null) {
            giz.setBoolean(class_3102.field_1729, true);
        }
        if (gja != null) {
            gja.setBoolean(class_3102, true);
        }
    }

    private static void gjk(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    static {
        gjd = 1000.0;
    }

    private static /* synthetic */ int ub(int n, int n2) {
        return n - n2 | 0xD97E4D31;
    }

    private static /* synthetic */ int uc(int n, int n2) {
        return StrafeTestA.ub(n, n2) ^ 0x850039C1;
    }

    private static /* synthetic */ int ud(int n, int n2) {
        return StrafeTestA.ub(n, n2) ^ 0xD1B800AB;
    }
}

