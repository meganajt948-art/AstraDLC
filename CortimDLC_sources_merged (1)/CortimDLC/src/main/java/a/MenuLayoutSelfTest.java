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
import a.WallpaperEntry;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_8032;

public final class MenuLayoutSelfTest {
    private static int fwm;
    private static int fwn;
    private static MenuScreen fwo;
    private static /* synthetic */ boolean fwp;
    private static /* synthetic */ int fwq;

    private MenuLayoutSelfTest() {
    }

    public static void install() {
        if (Boolean.getBoolean("flow2.selftest") && "flowmenu".equals(System.getenv("FLOW2_SELFTEST_SCENE"))) {
            ClientTickEvents.END_CLIENT_TICK.register(MenuLayoutSelfTest::fwr);
        }
    }

    private static void fwr(class_310 class_3102) {
        ++fwn;
        try {
            if (fwo == null) {
                class_437 class_4372;
                if (class_3102.method_18506() == null && class_3102.field_1755 instanceof class_8032) {
                    class_3102.field_1690.field_41785 = false;
                    class_3102.method_1507((class_437)new class_442());
                }
                if (class_3102.method_18506() == null && (class_4372 = class_3102.field_1755) instanceof MenuScreen) {
                    MenuScreen jte2 = (MenuScreen)class_4372;
                    if (fwn > 60) {
                        fwo = jte2;
                        fwn = 0;
                    }
                }
                return;
            }
            if (fwn % 50 != 0) {
                return;
            }
            switch (fwm++) {
                case 0: {
                    MenuLayoutSelfTest.fws("video:flow-dark");
                    TitleLayoutSetting.POSITION.set("Left");
                    TitleLayoutSetting.BUTTONS.set("Glass");
                    break;
                }
                case 1: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-black-left");
                    break;
                }
                case 2: {
                    TitleLayoutSetting.POSITION.set("Center");
                    break;
                }
                case 3: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-black-center");
                    break;
                }
                case 4: {
                    TitleLayoutSetting.POSITION.set("Right");
                    break;
                }
                case 5: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-black-right");
                    break;
                }
                case 6: {
                    MenuLayoutSelfTest.fws("video:flow-light");
                    TitleLayoutSetting.POSITION.set("Left");
                    break;
                }
                case 7: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-white-left");
                    break;
                }
                case 8: {
                    TitleLayoutSetting.POSITION.set("Center");
                    MenuLayoutSelfTest.fwt("pickerOpen", true);
                    break;
                }
                case 9: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-white-center");
                    break;
                }
                case 10: {
                    MenuLayoutSelfTest.fws("video:flow-dark");
                    TitleLayoutSetting.POSITION.set("Left");
                    MenuLayoutSelfTest.fwt("pickerOpen", true);
                    break;
                }
                case 11: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-picker");
                    break;
                }
                case 12: {
                    MenuLayoutSelfTest.fwt("pickerOpen", false);
                    class_3102.method_1521();
                    fwn = 30;
                    break;
                }
                case 13: {
                    MenuLayoutSelfTest.fwu(class_3102, "flowmenu-reload");
                    break;
                }
                default: {
                    if (class_3102.method_18506() != null) {
                        --fwm;
                        return;
                    }
                    TitleLayoutSetting.reset();
                    System.out.println("flow menu test PASS");
                    class_3102.method_1592();
                    fwn = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println("flow menu test FAIL: " + throwable);
            throwable.printStackTrace();
            class_3102.method_1592();
            fwn = Integer.MIN_VALUE;
        }
    }

    private static void fws(String string) throws Exception {
        Method method = MenuScreen.class.getDeclaredMethod("pick", WallpaperEntry.class);
        method.setAccessible(true);
        method.invoke((Object)fwo, WallpaperEntry.byKey(string));
    }

    private static void fwt(String string, Object object) throws Exception {
        Field field = MenuScreen.class.getDeclaredField(string);
        field.setAccessible(true);
        field.set((Object)fwo, object);
    }

    private static void fwu(class_310 class_3102, String string) {
        System.out.println("flow menu test " + string);
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> {});
    }

    private static /* synthetic */ int ru(int n, int n2) {
        return n ^ n2 | 0xEDA8F51F;
    }

    private static /* synthetic */ int rv(int n, int n2) {
        return n * n2 + 774725973;
    }
}

