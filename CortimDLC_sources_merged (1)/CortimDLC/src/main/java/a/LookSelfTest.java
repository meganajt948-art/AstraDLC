/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_8032
 */
package a;

import a.MenuScreen;
import a.TitleLayoutSetting;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_8032;

public final class LookSelfTest {
    private static int gai;
    private static int gaj;
    private static MenuScreen gak;
    private static /* synthetic */ boolean gal;
    private static /* synthetic */ int gam;

    private LookSelfTest() {
    }

    public static void install() {
        if (Boolean.getBoolean("flow2.selftest") && "look".equals(System.getenv("FLOW2_SELFTEST_SCENE"))) {
            ClientTickEvents.END_CLIENT_TICK.register(LookSelfTest::gan);
        }
    }

    private static void gan(class_310 class_3102) {
        ++gaj;
        try {
            if (gak == null) {
                class_437 class_4372;
                if (class_3102.method_18506() == null && class_3102.field_1755 instanceof class_8032) {
                    class_3102.field_1690.field_41785 = false;
                    class_3102.method_1507((class_437)new class_442());
                }
                if (class_3102.method_18506() == null && (class_4372 = class_3102.field_1755) instanceof MenuScreen) {
                    MenuScreen jte2 = (MenuScreen)class_4372;
                    if (gaj > 60) {
                        gak = jte2;
                        gaj = 0;
                    }
                }
                return;
            }
            if (gaj % 40 != 0) {
                return;
            }
            switch (gai++) {
                case 0: {
                    LookSelfTest.gao("pickerOpen", true);
                    LookSelfTest.gao("scrollTarget", Float.valueOf(10000.0f));
                    break;
                }
                case 1: {
                    LookSelfTest.gap(class_3102, "look-0-picker");
                    break;
                }
                case 2: {
                    LookSelfTest.gao("pickerOpen", false);
                    TitleLayoutSetting.POSITION.set("Left");
                    TitleLayoutSetting.BUTTONS.set("Outline");
                    TitleLayoutSetting.TITLE.set(false);
                    TitleLayoutSetting.BLUR.set(0.0);
                    break;
                }
                case 3: {
                    LookSelfTest.gap(class_3102, "look-1-left-outline-notitle");
                    break;
                }
                case 4: {
                    TitleLayoutSetting.POSITION.set("Right");
                    TitleLayoutSetting.BUTTONS.set("Dark");
                    TitleLayoutSetting.TITLE.set(true);
                    TitleLayoutSetting.ROUND.set(0.3);
                    TitleLayoutSetting.DIM.set(0.3);
                    break;
                }
                case 5: {
                    LookSelfTest.gap(class_3102, "look-2-right-dark");
                    break;
                }
                case 6: {
                    TitleLayoutSetting.POSITION.set("Center");
                    TitleLayoutSetting.BUTTONS.set("Light");
                    TitleLayoutSetting.ROUND.set(1.0);
                    TitleLayoutSetting.DIM.set(0.0);
                    TitleLayoutSetting.BLUR.set(0.5);
                    LookSelfTest.gao("pickerOpen", true);
                    break;
                }
                case 7: {
                    LookSelfTest.gap(class_3102, "look-3-light-picker");
                    break;
                }
                default: {
                    TitleLayoutSetting.reset();
                    LookSelfTest.gao("pickerOpen", false);
                    System.out.println("look test PASS");
                    class_3102.method_1592();
                    gaj = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println("look test FAIL: " + throwable);
            throwable.printStackTrace();
            class_3102.method_1592();
            gaj = Integer.MIN_VALUE;
        }
    }

    private static void gao(String string, Object object) throws Exception {
        Field field = MenuScreen.class.getDeclaredField(string);
        field.setAccessible(true);
        field.set((Object)gak, object);
    }

    private static void gap(class_310 class_3102, String string) {
        System.out.println("look test " + string);
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static /* synthetic */ int su(int n, int n2) {
        return n * n2 ^ 0xD99817BD;
    }
}

