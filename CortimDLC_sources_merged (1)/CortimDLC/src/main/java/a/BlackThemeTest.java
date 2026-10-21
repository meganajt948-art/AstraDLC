/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 */
package a;

import a.ClickGuiScreen;
import a.Theme;
import a.WallpaperManager;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;

final class BlackThemeTest {
    private static String fwe;
    private static String fwf;
    private static /* synthetic */ boolean fwg;
    private static /* synthetic */ String fwh;

    private BlackThemeTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        switch (n) {
            case 1: {
                class_3102.method_1562().method_45730("time set 6000");
                fwe = Theme.PRESET.get();
                fwf = WallpaperManager.selected();
                BlackThemeTest.fwi("Flow Black", "video:flow-dark");
                BlackThemeTest.fwj(class_3102, "Combat");
                break;
            }
            case 70: {
                BlackThemeTest.fwk(class_3102, "flowlook-black-combat");
                break;
            }
            case 72: {
                BlackThemeTest.fwj(class_3102, "Render");
                break;
            }
            case 110: {
                BlackThemeTest.fwk(class_3102, "flowlook-black-render");
                break;
            }
            case 112: {
                BlackThemeTest.fwj(class_3102, "Theme");
                break;
            }
            case 150: {
                BlackThemeTest.fwk(class_3102, "flowlook-black-theme");
                break;
            }
            case 152: {
                BlackThemeTest.fwi("Flow White", "video:flow-light");
                BlackThemeTest.fwj(class_3102, "Combat");
                break;
            }
            case 210: {
                BlackThemeTest.fwk(class_3102, "flowlook-white-combat");
                break;
            }
            case 212: {
                BlackThemeTest.fwi("Flow Black", "video:flow-dark");
                class_3102.method_1507(null);
                break;
            }
            case 250: {
                BlackThemeTest.fwk(class_3102, "flowlook-hud-black");
                break;
            }
            case 252: {
                BlackThemeTest.fwi("Flow White", "video:flow-light");
                break;
            }
            case 290: {
                BlackThemeTest.fwk(class_3102, "flowlook-hud-white");
                break;
            }
            case 292: {
                Theme.PRESET.set(fwe);
                WallpaperManager.select(fwf);
                break;
            }
        }
        return n >= 300;
    }

    private static void fwi(String string, String string2) {
        Theme.PRESET.set(string);
        Theme.ACCENT.set("Auto");
        WallpaperManager.select(string2);
    }

    private static void fwj(class_310 class_3102, String string) throws Exception {
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{"windowX", "windowY"}) {
            Field field2 = ClickGuiScreen.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        Field field3 = ClickGuiScreen.class.getDeclaredField("SCROLLS");
        field3.setAccessible(true);
        ((Map)field3.get(null)).clear();
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void fwk(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int rr(int n, int n2) {
        return n * n2 + -1608125436;
    }
}

