/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2561
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_408
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 */
package a;

import a.Module;
import a.NumberSetting;
import a.Setting;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_408;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_490;

final class AnimationsTest {
    private static /* synthetic */ boolean fbd;
    private static /* synthetic */ long fbe;

    private AnimationsTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        switch (n) {
            case 1: {
                AnimationsTest.fbf(class_3102, "time set 6000");
                AnimationsTest.fbf(class_3102, "scoreboard objectives add flowhp health");
                AnimationsTest.fbf(class_3102, "scoreboard objectives setdisplay list flowhp");
                Module kfe2 = Flow.getInstance().getModuleManager().getByName("Animations");
                for (Setting vmo2 : kfe2.getSettings()) {
                    if (!(vmo2 instanceof NumberSetting)) continue;
                    NumberSetting vmc2 = (NumberSetting)vmo2;
                    if (!"Speed".equals(vmc2.getName())) continue;
                    vmc2.set(0.5);
                }
                System.out.println("anim test: Animations on = " + kfe2.isEnabled());
                break;
            }
            case 20: {
                class_3102.field_1690.field_1907.method_23481(true);
                break;
            }
            case 22: {
                AnimationsTest.fbg(class_3102, "anim-01-tab-opening");
                break;
            }
            case 34: {
                AnimationsTest.fbg(class_3102, "anim-02-tab-open");
                break;
            }
            case 35: {
                class_3102.field_1690.field_1907.method_23481(false);
                break;
            }
            case 37: {
                AnimationsTest.fbg(class_3102, "anim-03-tab-closing");
                break;
            }
            case 50: {
                class_3102.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)"Hello from Flow, line one"));
                break;
            }
            case 56: {
                class_3102.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)"A second line slides the chat up"));
                break;
            }
            case 57: {
                AnimationsTest.fbg(class_3102, "anim-04-chat-sliding");
                break;
            }
            case 70: {
                AnimationsTest.fbg(class_3102, "anim-05-chat-settled");
                break;
            }
            case 80: {
                class_3102.method_1507((class_437)new class_408("", false));
                break;
            }
            case 82: {
                AnimationsTest.fbg(class_3102, "anim-06-chat-open-rising");
                break;
            }
            case 95: {
                AnimationsTest.fbg(class_3102, "anim-07-chat-open");
                class_3102.method_1507(null);
                break;
            }
            case 110: {
                class_3102.method_1507((class_437)new class_490((class_1657)class_3102.field_1724));
                break;
            }
            case 112: {
                AnimationsTest.fbg(class_3102, "anim-08-inventory-opening");
                break;
            }
            case 130: {
                AnimationsTest.fbg(class_3102, "anim-09-inventory-open");
                class_3102.method_1507(null);
                break;
            }
            case 140: {
                class_3102.method_1507((class_437)new class_433(true));
                break;
            }
            case 142: {
                AnimationsTest.fbg(class_3102, "anim-10-pause-rising");
                break;
            }
            case 160: {
                AnimationsTest.fbg(class_3102, "anim-11-pause");
                break;
            }
            case 170: {
                class_3102.method_1507(null);
                System.out.println("anim test PASS");
                return true;
            }
        }
        return false;
    }

    private static void fbf(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fbg(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static /* synthetic */ int na(int n, int n2) {
        return (n ^ n2) + 804670014;
    }

    private static /* synthetic */ int nb(int n, int n2) {
        return n - n2 | 0x75ED6D49;
    }

    private static /* synthetic */ int nc(int n, int n2) {
        return AnimationsTest.nb(n, n2) * n2;
    }
}

