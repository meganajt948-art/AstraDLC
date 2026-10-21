/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class StrafeTestC {
    private static final int gjw = 2;
    private static final int gjx = 3;
    private static final int gjy = 6;
    private static final String[] gjz = new String[]{"off-right", "off-left", "on-right(away)", "on-left(toward)", "on-left-fast"};
    private static Field gka;
    private static Field gkb;
    private static double gkc;
    private static float gkd;
    private static /* synthetic */ int gke;
    private static /* synthetic */ int gkf;

    private StrafeTestC() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("MouseAssist");
        if (n == 1) {
            class_3102.field_1690.field_1837 = false;
            gka = Reflect.find(class_312.class, "net.minecraft.class_312", "field_1783", "Z");
            gkb = Reflect.find(class_310.class, "net.minecraft.class_310", "field_1695", "Z");
            StrafeTestC.gki(class_3102, "gamemode survival");
            StrafeTestC.gki(class_3102, "time set noon");
            StrafeTestC.gki(class_3102, "effect give @s resistance infinite 255 true");
            StrafeTestC.gki(class_3102, "fill ~-6 ~-1 ~-6 ~6 ~-1 ~6 minecraft:smooth_stone");
            StrafeTestC.gki(class_3102, "fill ~-6 ~ ~-6 ~6 ~4 ~6 minecraft:air");
            StrafeTestC.gki(class_3102, "summon minecraft:zombie ~1.5 ~ ~3 {NoAI:1b,Silent:1b,PersistenceRequired:1b}");
            System.out.println("mouse sens " + class_3102.field_1690.method_42495().method_41753());
            return false;
        }
        StrafeTestC.gkh(class_3102);
        if (n < 40) {
            return false;
        }
        int n2 = 26;
        int n3 = (n - 40) / n2;
        int n4 = (n - 40) % n2;
        if (n3 >= gjz.length) {
            kfe2.setEnabled(false);
            return true;
        }
        if (n4 == 0) {
            kfe2.setEnabled(n3 >= 2);
            class_3102.field_1724.method_36456(0.0f);
            class_3102.field_1724.method_36457(0.0f);
            class_3102.field_1724.field_5982 = 0.0f;
        } else if (n4 == 10) {
            gkd = class_3102.field_1724.method_36454();
        } else if (n4 > 10 && n4 <= 16) {
            int n5 = gjz[n3].contains("right") ? 1 : -1;
            int n6 = gjz[n3].contains("fast") ? 8 : 1;
            GLFWCursorPosCallback gLFWCursorPosCallback = StrafeTestC.gkg(class_3102);
            long l = class_3102.method_22683().method_4490();
            for (int i = 0; i < 3 * n6; ++i) {
                gLFWCursorPosCallback.invoke(l, gkc += (double)(n5 * 2), 500.0);
            }
        } else if (n4 == 24) {
            int n7 = gjz[n3].contains("fast") ? 8 : 1;
            double d = 36 * n7;
            double d2 = (Double)class_3102.field_1690.method_42495().method_41753() * 0.6 + 0.2;
            double d3 = d * d2 * d2 * d2 * 8.0 * 0.15;
            float f = class_3102.field_1724.method_36454() - gkd;
            System.out.printf("mouse %s: turned %.3f deg, vanilla %.3f deg, ratio %.3f%n", gjz[n3], Float.valueOf(f), d3, (double)Math.abs(f) / d3);
        }
        return false;
    }

    private static GLFWCursorPosCallback gkg(class_310 class_3102) {
        long l = class_3102.method_22683().method_4490();
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
        GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        return gLFWCursorPosCallback;
    }

    private static void gkh(class_310 class_3102) throws Exception {
        if (gka != null && class_3102.field_1755 == null) {
            gka.setBoolean(class_3102.field_1729, true);
        }
        if (gkb != null) {
            gkb.setBoolean(class_3102, true);
        }
    }

    private static void gki(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    static {
        gkc = 1000.0;
    }

    private static /* synthetic */ int ul(int n, int n2) {
        return n + n2 | 0xC470591C;
    }
}

