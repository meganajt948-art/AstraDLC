/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_276
 *  net.minecraft.class_303
 *  net.minecraft.class_303$class_7590
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_338
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_490
 *  net.minecraft.class_745
 *  net.minecraft.class_7923
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.Friends;
import a.ClickGuiScreen;
import a.GuiConfig;
import a.Theme;
import a.Module;
import a.ModuleManager;
import a.Setting;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_276;
import net.minecraft.class_303;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_338;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_490;
import net.minecraft.class_745;
import net.minecraft.class_7923;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class ShulkerPreviewTest {
    private static class_2338 fig;
    private static class_1297 fih;
    private static class_1297 fii;
    private static String fij;
    private static /* synthetic */ boolean fik;
    private static /* synthetic */ String fil;

    private ShulkerPreviewTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        Object object;
        Object object2;
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            ShulkerPreviewTest.fja(class_3102, "gamemode creative");
            ShulkerPreviewTest.fja(class_3102, "time set 6000");
            ShulkerPreviewTest.fja(class_3102, "clear @s");
            ShulkerPreviewTest.fja(class_3102, "give @s minecraft:purple_shulker_box[minecraft:container=[{slot:0,item:{id:\"minecraft:diamond\",count:32}},{slot:4,item:{id:\"minecraft:golden_apple\",count:5}},{slot:13,item:{id:\"minecraft:netherite_sword\",count:1}},{slot:20,item:{id:\"minecraft:ender_pearl\",count:16}}]]");
            ShulkerPreviewTest.fiv(kfx2, "ShulkerPreview", true);
        }
        if (n == 6) {
            ShulkerPreviewTest.fja(class_3102, "gamemode survival");
        }
        if (n == 12) {
            class_3102.method_1507((class_437)new class_490((class_1657)class_3102.field_1724));
        }
        if (n == 16) {
            ShulkerPreviewTest.fin(class_3102, class_1802.field_8816);
        }
        if (n == 24) {
            ShulkerPreviewTest.fjb(class_3102, "chest-shulker-preview");
            class_3102.method_1507(null);
            ShulkerPreviewTest.fja(class_3102, "clear @s");
            ShulkerPreviewTest.fja(class_3102, "gamemode creative");
        }
        if (n == 30) {
            object2 = class_3102.field_1724.method_24515().method_10069(2, 0, 0);
            fig = object2;
            ShulkerPreviewTest.fja(class_3102, "setblock " + object2.method_10263() + " " + object2.method_10264() + " " + object2.method_10260() + " minecraft:chest{Items:[{Slot:0b,id:\"minecraft:diamond\",count:12},{Slot:5b,id:\"minecraft:dirt\",count:40},{Slot:9b,id:\"minecraft:iron_ingot\",count:20},{Slot:20b,id:\"minecraft:golden_apple\",count:3}]}");
            ShulkerPreviewTest.fiv(kfx2, "ChestStealer", true);
        }
        if (n == 36) {
            ShulkerPreviewTest.fim(class_3102, fig);
        }
        if (n == 60) {
            System.out.println("chest stealer: screen=" + (class_3102.field_1755 == null ? "closed" : "open") + " diamonds=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8477) + " dirt=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8831) + " iron=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8620) + " apples=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8463));
            ShulkerPreviewTest.fiv(kfx2, "ChestStealer", false);
            class_3102.method_1507(null);
            ShulkerPreviewTest.fja(class_3102, "clear @s");
        }
        if (n == 66) {
            object2 = fig;
            ShulkerPreviewTest.fja(class_3102, "setblock " + object2.method_10263() + " " + object2.method_10264() + " " + object2.method_10260() + " minecraft:air");
            ShulkerPreviewTest.fja(class_3102, "setblock " + object2.method_10263() + " " + object2.method_10264() + " " + object2.method_10260() + " minecraft:chest{Items:[{Slot:0b,id:\"minecraft:dirt\",count:20},{Slot:3b,id:\"minecraft:diamond_sword\",count:1},{Slot:7b,id:\"minecraft:dirt\",count:30},{Slot:8b,id:\"minecraft:bread\",count:5},{Slot:12b,id:\"minecraft:iron_helmet\",count:1},{Slot:14b,id:\"minecraft:stone\",count:64},{Slot:19b,id:\"minecraft:diamond_pickaxe\",count:1},{Slot:25b,id:\"minecraft:bread\",count:7}]}");
            ShulkerPreviewTest.fiv(kfx2, "ChestSorter", true);
        }
        if (n == 72) {
            ShulkerPreviewTest.fim(class_3102, fig);
        }
        if (n == 80) {
            ShulkerPreviewTest.fjb(class_3102, "chest-sorter-before");
            ShulkerPreviewTest.fis(kfx2.getByName("ChestSorter"), "start", class_3102);
        }
        if (n == 110) {
            ShulkerPreviewTest.fjb(class_3102, "chest-sorter-after");
            System.out.println("chest sorter: " + ShulkerPreviewTest.fip(class_3102));
            class_3102.method_1507(null);
            ShulkerPreviewTest.fiv(kfx2, "ChestSorter", false);
        }
        if (n == 116) {
            object2 = fig;
            ShulkerPreviewTest.fja(class_3102, "setblock " + object2.method_10263() + " " + object2.method_10264() + " " + object2.method_10260() + " minecraft:air");
            ShulkerPreviewTest.fja(class_3102, "setblock " + object2.method_10263() + " " + object2.method_10264() + " " + object2.method_10260() + " minecraft:chest{Items:[{Slot:0b,id:\"minecraft:diamond\",count:9},{Slot:4b,id:\"minecraft:dirt\",count:40},{Slot:10b,id:\"minecraft:totem_of_undying\",count:1},{Slot:16b,id:\"minecraft:cobblestone\",count:64}]}");
            ShulkerPreviewTest.fja(class_3102, "clear @s");
            ShulkerPreviewTest.fiv(kfx2, "ChestLooter", true);
        }
        if (n == 122) {
            ShulkerPreviewTest.fim(class_3102, fig);
        }
        if (n == 128) {
            ShulkerPreviewTest.fis(kfx2.getByName("ChestLooter"), "start", class_3102);
        }
        if (n == 134) {
            ShulkerPreviewTest.fjb(class_3102, "chest-looter-working");
        }
        if (n == 150) {
            System.out.println("chest looter: screen=" + (class_3102.field_1755 == null ? "closed" : "open") + " diamonds=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8477) + " totems=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8288) + " dirt=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_8831) + " cobble=" + ShulkerPreviewTest.fio(class_3102, class_1802.field_20412));
            class_3102.method_1507(null);
            ShulkerPreviewTest.fiy(class_3102, class_243.method_24953((class_2382)fig));
        }
        if (n == 158) {
            ShulkerPreviewTest.fjb(class_3102, "chest-looter-mark");
            ShulkerPreviewTest.fiv(kfx2, "ChestLooter", false);
            ShulkerPreviewTest.fja(class_3102, "setblock " + fig.method_10263() + " " + fig.method_10264() + " " + fig.method_10260() + " minecraft:air");
            ShulkerPreviewTest.fja(class_3102, "clear @s");
        }
        if (n == 162) {
            ShulkerPreviewTest.fiv(kfx2, "ChatTweaks", true);
        }
        if (n == 164) {
            int n2;
            object2 = class_3102.field_1705.method_1743();
            for (n2 = 0; n2 < 150; ++n2) {
                object2.method_1812((class_2561)class_2561.method_43470((String)("Line " + n2)));
            }
            for (n2 = 0; n2 < 3; ++n2) {
                object2.method_1812((class_2561)class_2561.method_43470((String)"Спам, покупайте на сервере"));
            }
            object = ShulkerPreviewTest.fiq((class_338)object2);
            System.out.println("chat tweaks: kept " + object.size() + " messages, newest '" + ((class_303)object.get(0)).comp_893().getString() + "', lines " + ShulkerPreviewTest.fir((class_338)object2).size() + " " + ShulkerPreviewTest.fir((class_338)object2).getClass().getSimpleName());
            class_3102.method_1507((class_437)new class_408("", false));
        }
        if (n == 166 || n == 169) {
            System.out.println("chat tweaks screen at " + n + ": " + (class_3102.field_1755 == null ? "none" : class_3102.field_1755.getClass().getSimpleName()) + ", lines " + ShulkerPreviewTest.fir(class_3102.field_1705.method_1743()).size());
        }
        if (n == 170) {
            ShulkerPreviewTest.fjb(class_3102, "chat-tweaks");
            object2 = kfx2.getByName("ChatTweaks");
            object = object2.getClass().getDeclaredMethod("messageAt", Double.TYPE, Double.TYPE);
            ((Method)object).setAccessible(true);
            double d = (Double)class_3102.field_1690.method_42554().method_41753();
            int n3 = (int)Math.floor((double)(class_3102.method_22683().method_4502() - 40) / d);
            Object object3 = ((Method)object).invoke(null, 20.0, (double)(n3 - 4) * d);
            System.out.println("chat tweaks copy: '" + object3 + "'");
            class_3102.method_1507(null);
            class_338 class_3382 = class_3102.field_1705.method_1743();
            class_3382.method_1808(true);
            class_3382.method_1817();
            System.out.println("chat tweaks after clear: " + ShulkerPreviewTest.fiq(class_3382).size() + " messages");
            ShulkerPreviewTest.fiv(kfx2, "ChatTweaks", false);
        }
        if (n == 176) {
            ShulkerPreviewTest.fix(class_3102, 0.0f, 0.0f);
            fih = ShulkerPreviewTest.fit(class_3102, "Kolya", 1.8);
            fii = ShulkerPreviewTest.fit(class_3102, "Enemy", 2.9);
            Friends.add("Kolya");
        }
        if (n == 180) {
            class_1297 class_12972;
            class_3102.field_1773.method_3190(1.0f);
            Object object4 = class_3102.field_1765;
            if (object4 instanceof class_3966) {
                object = (class_3966)object4;
                class_12972 = object.method_17782();
            } else {
                class_12972 = null;
            }
            object2 = class_12972;
            object = kfx2.getByName("TriggerBot");
            object4 = ShulkerPreviewTest.fis(object, "findTarget", class_3102);
            System.out.println("through friends: crosshair on " + ShulkerPreviewTest.fiu((class_1297)object2) + ", target " + ShulkerPreviewTest.fiu((class_1297)object4) + " (expected Enemy)");
            Friends.remove("Kolya");
            class_3102.field_1687.method_2945(fih.method_5628(), class_1297.class_5529.field_26999);
            class_3102.field_1687.method_2945(fii.method_5628(), class_1297.class_5529.field_26999);
        }
        if (n == 184) {
            fij = Theme.PRESET.get();
            Theme.PRESET.set("Cyberpunk");
            ShulkerPreviewTest.fiz(class_3102, "Theme");
        }
        if (n == 204) {
            ShulkerPreviewTest.fjb(class_3102, "theme-cyberpunk");
            Theme.PRESET.set("Emerald");
        }
        if (n == 220) {
            ShulkerPreviewTest.fjb(class_3102, "theme-emerald");
            Theme.PRESET.set("White");
        }
        if (n == 236) {
            ShulkerPreviewTest.fjb(class_3102, "theme-white");
            Theme.PRESET.set(fij);
            class_3102.method_1507(null);
        }
        if (n >= 240) {
            GuiConfig.save();
            return true;
        }
        return false;
    }

    private static void fim(class_310 class_3102, class_2338 class_23382) {
        class_3102.field_1761.method_2896(class_3102.field_1724, class_1268.field_5808, new class_3965(class_243.method_24953((class_2382)class_23382), class_2350.field_11036, class_23382, false));
    }

    private static void fin(class_310 class_3102, class_1792 class_17922) {
        class_437 class_4372 = class_3102.field_1755;
        if (!(class_4372 instanceof class_465)) {
            return;
        }
        class_465 class_4652 = (class_465)class_4372;
        for (class_1735 class_17352 : class_4652.method_17577().field_7761) {
            if (!class_17352.method_7677().method_31574(class_17922)) continue;
            double d = class_3102.method_22683().method_4495();
            double d2 = (double)(class_4652.field_22789 - 176) / 2.0 + (double)class_17352.field_7873 + 8.0;
            double d3 = (double)(class_4652.field_22790 - 166) / 2.0 + (double)class_17352.field_7872 + 8.0;
            long l = class_3102.method_22683().method_4490();
            GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
            GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
            GLFW.glfwSetCursorPos((long)l, (double)(d2 * d), (double)(d3 * d));
            if (gLFWCursorPosCallback != null) {
                gLFWCursorPosCallback.invoke(l, d2 * d, d3 * d);
            }
            return;
        }
        System.out.println("chest test: no " + class_17922 + " to hover");
    }

    private static int fio(class_310 class_3102, class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < class_3102.field_1724.method_31548().method_5439(); ++i) {
            class_1799 class_17992 = class_3102.field_1724.method_31548().method_5438(i);
            if (!class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private static String fip(class_310 class_3102) {
        Object object = class_3102.field_1755;
        if (!(object instanceof class_465)) {
            return "no chest";
        }
        class_465 class_4652 = (class_465)object;
        object = new StringBuilder();
        for (class_1735 class_17352 : class_4652.method_17577().field_7761) {
            if (class_17352.field_7871 == class_3102.field_1724.method_31548()) continue;
            ((StringBuilder)object).append(class_17352.method_7681() ? class_7923.field_41178.method_10221((Object)class_17352.method_7677().method_7909()).method_12832() + "x" + class_17352.method_7677().method_7947() : "-").append(' ');
        }
        return ((StringBuilder)object).toString().trim();
    }

    private static List<class_303> fiq(class_338 class_3382) throws Exception {
        for (Field field : class_338.class.getDeclaredFields()) {
            ParameterizedType parameterizedType;
            Type type = field.getGenericType();
            if (!(type instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments()[0] != class_303.class) continue;
            field.setAccessible(true);
            return (List)field.get(class_3382);
        }
        throw new IllegalStateException("no chat messages list");
    }

    private static List<?> fir(class_338 class_3382) throws Exception {
        for (Field field : class_338.class.getDeclaredFields()) {
            ParameterizedType parameterizedType;
            Type type = field.getGenericType();
            if (!(type instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments()[0] != class_303.class_7590.class) continue;
            field.setAccessible(true);
            return (List)field.get(class_3382);
        }
        throw new IllegalStateException("no chat lines list");
    }

    private static Object fis(Object object, String string, class_310 class_3102) throws Exception {
        Method method = object.getClass().getDeclaredMethod(string, class_310.class);
        method.setAccessible(true);
        return method.invoke(object, class_3102);
    }

    private static class_1297 fit(class_310 class_3102, String string, double d) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1031(0.0, 0.0, d);
        class_7452.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 180.0f, 0.0f);
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8523));
        class_3102.field_1687.method_53875((class_1297)class_7452);
        return class_7452;
    }

    private static String fiu(class_1297 class_12972) {
        return class_12972 == null ? "nothing" : class_12972.method_5477().getString();
    }

    private static void fiv(ModuleManager kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static Setting fiw(Module kfe2, String string) {
        for (Setting vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + " has no " + string);
    }

    private static void fix(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
    }

    private static void fiy(class_310 class_3102, class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(class_3102.field_1724.method_33571());
        ShulkerPreviewTest.fix(class_3102, (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350)), (float)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))));
    }

    private static void fiz(class_310 class_3102, String string) throws Exception {
        Field field = ClickGuiScreen.class.getDeclaredField("tabKey");
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{"windowX", "windowY"}) {
            Field field2 = ClickGuiScreen.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        class_3102.method_1507((class_437)new ClickGuiScreen());
    }

    private static void fja(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fjb(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int os(int n, int n2) {
        return n - n2 ^ 0x2873A092;
    }

    private static /* synthetic */ int ot(int n, int n2) {
        return ShulkerPreviewTest.os(n, n2) * n2;
    }

    private static /* synthetic */ int ou(int n, int n2) {
        return ShulkerPreviewTest.os(n, n2) * n2;
    }
}

