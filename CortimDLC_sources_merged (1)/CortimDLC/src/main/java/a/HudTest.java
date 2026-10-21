/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11905
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_11910
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 */
package a;

import a.ClickGuiScreen;
import a.wam;
import a.Lang;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_408;
import net.minecraft.class_437;

final class HudTest {
    private static /* synthetic */ String fvx;
    private static /* synthetic */ String fvy;

    private HudTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        class_437 class_4372 = class_3102.field_1755;
        switch (n) {
            case 1: {
                class_3102.method_1562().method_45730("time set 6000");
                break;
            }
            case 60: {
                HudTest.fwc(class_3102, "firsthud-world");
                break;
            }
            case 62: {
                class_3102.method_1507((class_437)new class_408("", false));
                break;
            }
            case 100: {
                HudTest.fwc(class_3102, "firsthud-chat");
                break;
            }
            case 102: {
                class_3102.method_1507(null);
                Lang.set(wam.RU);
                HudTest.fvz(class_3102);
                break;
            }
            case 150: {
                HudTest.fwc(class_3102, "firsthud-gui-combat");
                break;
            }
            case 152: {
                HudTest.fwa(class_4372, 400.0f, 23.0f, 0);
                for (char c : "trig".toCharArray()) {
                    class_4372.method_25400(new class_11905((int)c, 0));
                }
                break;
            }
            case 170: {
                HudTest.fwa(class_4372, 200.0f, 69.0f, 1);
                break;
            }
            case 200: {
                HudTest.fwc(class_3102, "firsthud-gui-triggerbot");
                break;
            }
            case 202: {
                for (int i = 0; i < 3; ++i) {
                    class_4372.method_25404(new class_11908(256, 0, 0));
                }
                break;
            }
        }
        return n >= 215;
    }

    private static void fvz(class_310 class_3102) throws Exception {
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, "Combat");
        for (String string : new String[]{"windowX", "windowY"}) {
            Field field2 = ClickGuiScreen.class.getDeclaredField(string);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void fwa(class_437 class_4372, float f, float f2, int n) throws Exception {
        if (!(class_4372 instanceof ClickGuiScreen)) {
            return;
        }
        float f3 = HudTest.fwb(class_4372, "originX");
        float f4 = HudTest.fwb(class_4372, "originY");
        float f5 = HudTest.fwb(class_4372, "scale");
        class_4372.method_25402(new class_11909((double)(f3 + f * f5), (double)(f4 + f2 * f5), new class_11910(n, 0)), false);
    }

    private static float fwb(Object object, String string) throws Exception {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return field.getFloat(object);
    }

    private static void fwc(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int rn(int n, int n2) {
        return n * n2 | 0xA4664C7F;
    }

    private static /* synthetic */ int ro(int n, int n2) {
        return HudTest.rn(n, n2) ^ 0xC60596;
    }
}

