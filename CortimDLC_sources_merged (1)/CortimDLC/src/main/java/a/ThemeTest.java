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
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;

final class ThemeTest {
    private static final String[] hec = new String[]{"Cyberpunk", "Graphite", "Crimson", "Emerald", "Ocean", "Frost", "White"};
    private static final String[] hed = new String[]{"аим", "фшь", "булава", "мейс", "авто", "есп", "esp", "звук", "звуки", "fly", "a", "ки", "цвет", "тема", "обводка", "totem", "тотем", "ночь", "sprint", "спринт", "hud", "худ", "друзья", "прыжок", "weather", "снег", "сундук", "chest", "blur", "celestial", "стекло", "glass", "авто булава", "булава авто", "высота", "фрикам", "free cam", "zoom", "зум", "клик", "бинд", "ыуфкср"};
    private static String hee;
    private static /* synthetic */ String hef;
    private static /* synthetic */ int heg;

    private ThemeTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        int n2;
        if (n == 1) {
            ThemeTest.hek(class_3102, "time set 6000");
            hee = Theme.PRESET.get();
            ThemeTest.hej(class_3102, "Theme");
        }
        int n3 = 24;
        int n4 = 30;
        for (n2 = 0; n2 < hec.length; ++n2) {
            if (n == n4 + n2 * n3) {
                Theme.PRESET.set(hec[n2]);
            }
            if (n != n4 + n2 * n3 + n3 - 2) continue;
            ThemeTest.hel(class_3102, "themes-" + hec[n2].toLowerCase(Locale.ROOT).replace(' ', '-'));
        }
        n2 = n4 + hec.length * n3;
        if (n == n2) {
            Theme.PRESET.set("Crimson");
            ThemeTest.hej(class_3102, "Combat");
        }
        if (n == n2 + 24) {
            ThemeTest.hel(class_3102, "themes-crimson-combat");
            class_3102.method_1507(null);
        }
        if (n == n2 + 50) {
            ThemeTest.hel(class_3102, "themes-crimson-hud");
            Theme.PRESET.set("Emerald");
        }
        if (n == n2 + 76) {
            ThemeTest.hel(class_3102, "themes-emerald-hud");
            Theme.PRESET.set("Frost");
        }
        if (n == n2 + 102) {
            ThemeTest.hel(class_3102, "themes-frost-hud");
            ThemeTest.hej(class_3102, "Combat");
        }
        if (n == n2 + 110) {
            Theme.PRESET.set("Crimson");
            ThemeTest.heh(class_3102);
        }
        if (n == n2 + 134) {
            ThemeTest.hel(class_3102, "themes-search-height");
            ThemeTest.hei(class_3102);
        }
        if (n == n2 + 150) {
            ThemeTest.hel(class_3102, "themes-search-cleared");
            Theme.PRESET.set(hee);
            class_3102.method_1507(null);
        }
        return n >= n2 + 154;
    }

    private static void heh(class_310 class_3102) throws Exception {
        Object object = class_3102.field_1755;
        if (!(object instanceof ClickGuiScreen)) {
            System.out.println("search test: no menu");
            return;
        }
        ClickGuiScreen hlc2 = (ClickGuiScreen)((Object)object);
        object = ClickGuiScreen.class.getDeclaredMethod("setSearch", String.class);
        ((Method)object).setAccessible(true);
        Field field = ClickGuiScreen.class.getDeclaredField("visible");
        field.setAccessible(true);
        for (String string : hed) {
            ((Method)object).invoke((Object)hlc2, string);
            ArrayList<String> arrayList = new ArrayList<String>();
            for (Object e : (List)field.get((Object)hlc2)) {
                Field field2 = e.getClass().getDeclaredField("title");
                field2.setAccessible(true);
                Method method = e.getClass().getDeclaredMethod("isCollapsed", new Class[0]);
                method.setAccessible(true);
                Field field3 = e.getClass().getDeclaredField("rows");
                field3.setAccessible(true);
                boolean bl = (Boolean)method.invoke(e, new Object[0]) == false && !((List)field3.get(e)).isEmpty();
                arrayList.add(field2.get(e) + (bl ? " (open)" : ""));
            }
            System.out.println("search '" + string + "' -> " + arrayList.size() + ": " + String.join((CharSequence)", ", arrayList));
        }
        ((Method)object).invoke((Object)hlc2, "высота");
    }

    private static void hei(class_310 class_3102) throws Exception {
        Object object = class_3102.field_1755;
        if (object instanceof ClickGuiScreen) {
            ClickGuiScreen hlc2 = (ClickGuiScreen)((Object)object);
            object = ClickGuiScreen.class.getDeclaredMethod("setSearch", String.class);
            ((Method)object).setAccessible(true);
            ((Method)object).invoke((Object)hlc2, "");
        }
    }

    private static void hej(class_310 class_3102, String string) throws Exception {
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

    private static void hek(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void hel(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int zh(int n, int n2) {
        return n - n2 + 239775150;
    }

    private static /* synthetic */ int zi(int n, int n2) {
        return ThemeTest.zh(n, n2) ^ 0x1B7EC35E;
    }
}

