/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11905
 *  net.minecraft.class_11909
 *  net.minecraft.class_11910
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2338
 *  net.minecraft.class_2561
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.ClickGuiScreen;
import a.Module;
import a.ModuleManager;
import a.AutoEnd;
import a.AutoWarden;
import a.AutoLoot;
import a.InstanceQueue;
import a.AnarchyQueue;
import a.TalismanTable;
import a.ChestFinder;
import a.ListSetting;
import a.wam;
import a.Lang;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import net.minecraft.class_11905;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class ChestScenarioTest {
    private static int fvc;
    private static class_2338 fvd;
    private static /* synthetic */ boolean fve;
    private static /* synthetic */ String fvf;

    private ChestScenarioTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        ModuleManager kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            ChestScenarioTest.fvu(class_3102, "gamemode creative");
            ChestScenarioTest.fvu(class_3102, "time set 6000");
            ChestScenarioTest.fvu(class_3102, "weather clear");
            ChestScenarioTest.fvl();
            ChestScenarioTest.fvp();
            ChestScenarioTest.fvq(kfx2);
            fvd = class_3102.field_1724.method_24515();
            ChestScenarioTest.fvu(class_3102, "setblock ~2 ~ ~4 minecraft:chest");
            ChestScenarioTest.fvu(class_3102, "setblock ~2 ~1 ~4 minecraft:chest");
            ChestScenarioTest.fvu(class_3102, "setblock ~2 ~1 ~3 minecraft:oak_wall_sign[facing=north]{front_text:{messages:[\"инвиз\",\"\",\"\",\"\"]}}");
            ChestScenarioTest.fvu(class_3102, "setblock ~-2 ~ ~4 minecraft:chest");
            ChestScenarioTest.fvu(class_3102, "setblock ~-2 ~1 ~4 minecraft:oak_sign{front_text:{messages:[\"Сброс\",\"\",\"\",\"\"]}}");
        }
        if (n == 20) {
            class_2338 class_23382 = ChestFinder.find(class_3102, fvd, "инвиз", "невидим");
            class_2338 class_23383 = ChestFinder.find(class_3102, fvd, "сброс");
            ChestScenarioTest.fvr("wall sign marks the chest it hangs on", fvd.method_10069(2, 1, 4).equals((Object)class_23382), String.valueOf(class_23382));
            ChestScenarioTest.fvr("standing sign marks the chest under it", fvd.method_10069(-2, 0, 4).equals((Object)class_23383), String.valueOf(class_23383));
        }
        if (n == 24) {
            Lang.set(wam.EN);
            ChestScenarioTest.fvs(class_3102, kfx2.get(AutoWarden.class).lootList());
        }
        if (n == 36) {
            ChestScenarioTest.fvv(class_3102, "farm-loot-warden-en");
        }
        if (n == 37) {
            class_3102.method_1507(null);
            Lang.set(wam.RU);
            ChestScenarioTest.fvs(class_3102, kfx2.get(AutoEnd.class).lootList());
        }
        if (n == 49) {
            ChestScenarioTest.fvv(class_3102, "farm-loot-end-ru");
        }
        if (n == 50) {
            ChestScenarioTest.fvt(class_3102.field_1755, "талис");
        }
        if (n == 58) {
            ChestScenarioTest.fvv(class_3102, "farm-loot-end-search");
            class_3102.method_1507(null);
        }
        if (n == 60 || n == 116) {
            Lang.set(n == 60 ? wam.RU : wam.EN);
            ChestScenarioTest.fvk(class_3102, "Player");
        }
        if (n == 70 || n == 126) {
            ChestScenarioTest.fvi(class_3102, AutoWarden.class);
        }
        if (n == 86) {
            ChestScenarioTest.fvv(class_3102, "farm-tooltip-ru");
        }
        if (n == 87) {
            ChestScenarioTest.fvh(class_3102, AutoWarden.class, 1);
        }
        if (n == 100) {
            ChestScenarioTest.fvv(class_3102, "farm-card-ru");
        }
        if (n == 101) {
            ChestScenarioTest.fvh(class_3102, AutoLoot.class, 1);
        }
        if (n == 112) {
            ChestScenarioTest.fvv(class_3102, "farm-card-looter");
        }
        if (n == 142) {
            ChestScenarioTest.fvv(class_3102, "farm-tooltip-en");
            class_3102.method_1507(null);
            Lang.set(wam.RU);
        }
        if (n == 146) {
            System.out.println("farm test: " + (fvc == 0 ? "ALL PASSED" : fvc + " FAILED"));
            return true;
        }
        return false;
    }

    private static double[] fvg(class_310 class_3102, Class<? extends Module> clazz) throws Exception {
        Object object = class_3102.field_1755;
        if (!(object instanceof ClickGuiScreen)) {
            return null;
        }
        ClickGuiScreen hlc2 = (ClickGuiScreen)((Object)object);
        object = ClickGuiScreen.class.getDeclaredField("visible");
        ((Field)object).setAccessible(true);
        for (Object e : (List)((Field)object).get((Object)hlc2)) {
            if (!clazz.isInstance(ChestScenarioTest.fvj(e, "module"))) continue;
            float f = ((Float)ChestScenarioTest.fvj(e, "x")).floatValue() + 24.0f;
            float f2 = ((Float)ChestScenarioTest.fvj(e, "y")).floatValue() + 10.0f;
            float f3 = ((Float)ChestScenarioTest.fvj((Object)hlc2, "originX")).floatValue();
            float f4 = ((Float)ChestScenarioTest.fvj((Object)hlc2, "originY")).floatValue();
            float f5 = ((Float)ChestScenarioTest.fvj((Object)hlc2, "scale")).floatValue();
            return new double[]{f3 + f * f5, f4 + f2 * f5};
        }
        System.out.println("farm test: no card for " + clazz.getSimpleName());
        return null;
    }

    private static void fvh(class_310 class_3102, Class<? extends Module> clazz, int n) throws Exception {
        double[] dArray = ChestScenarioTest.fvg(class_3102, clazz);
        if (dArray != null) {
            class_3102.field_1755.method_25402(new class_11909(dArray[0], dArray[1], new class_11910(n, 0)), false);
        }
    }

    private static void fvi(class_310 class_3102, Class<? extends Module> clazz) throws Exception {
        double[] dArray = ChestScenarioTest.fvg(class_3102, clazz);
        if (dArray != null) {
            double d = class_3102.method_22683().method_4495();
            double d2 = dArray[0] * d;
            double d3 = dArray[1] * d;
            long l = class_3102.method_22683().method_4490();
            GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
            GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
            GLFW.glfwSetCursorPos((long)l, (double)d2, (double)d3);
            if (gLFWCursorPosCallback != null) {
                gLFWCursorPosCallback.invoke(l, d2, d3);
            }
        }
    }

    private static Object fvj(Object object, String string) throws Exception {
        for (Class<?> clazz = object.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(string);
                field.setAccessible(true);
                return field.get(object);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                continue;
            }
        }
        throw new NoSuchFieldException(string);
    }

    private static void fvk(class_310 class_3102, String string) throws Exception {
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

    private static void fvl() {
        List<String> list = List.of(TalismanTable.WARDEN_DEFAULTS);
        List<String> list2 = List.of(TalismanTable.END_DEFAULTS);
        ChestScenarioTest.fvr("warden list has 57 lines", list.size() == 57, String.valueOf(list.size()));
        ChestScenarioTest.fvr("end list has 59 lines", list2.size() == 59, String.valueOf(list2.size()));
        ChestScenarioTest.fvm("elytra", new class_1799((class_1935)class_1802.field_8833), true, true);
        ChestScenarioTest.fvm("netherite boots", new class_1799((class_1935)class_1802.field_22030), true, true);
        ChestScenarioTest.fvm("enchanted apple", new class_1799((class_1935)class_1802.field_8367), true, true);
        ChestScenarioTest.fvm("tyrant talisman", ChestScenarioTest.fvn(class_1802.field_8288, "[★] Талисман Тирана"), true, true);
        ChestScenarioTest.fvm("fury talisman: End only", ChestScenarioTest.fvn(class_1802.field_8288, "[★] Талисман Ярости"), false, true);
        ChestScenarioTest.fvm("mace head: End only", new class_1799((class_1935)class_1802.field_49813), false, true);
        ChestScenarioTest.fvm("hydra sphere", ChestScenarioTest.fvn(class_1802.field_8575, "[★] Сфера Гидры"), true, true);
        ChestScenarioTest.fvm("trap (scrap with the cage cast)", ChestScenarioTest.fvo(class_1802.field_22021, "[★] Трапка", "Каст: Нерушимая клетка"), true, true);
        ChestScenarioTest.fvr("a trap is not netherite scrap", !TalismanTable.picked(ChestScenarioTest.fvo(class_1802.field_22021, "[★] Трапка", "Каст: Нерушимая клетка"), Set.of("netherite_scrap")), "");
        ChestScenarioTest.fvr("plain scrap is netherite scrap", TalismanTable.picked(new class_1799((class_1935)class_1802.field_22021), Set.of("netherite_scrap")), "");
        class_1799 class_17992 = ChestScenarioTest.fvo(class_1802.field_8626, "[★] Блэк", "Способен взорвать обсидиан");
        ChestScenarioTest.fvr("black TNT is black, not white or plain", TalismanTable.picked(class_17992, Set.of("black_tnt")) && !TalismanTable.picked(class_17992, Set.of("white_tnt", "tnt")), "");
        ChestScenarioTest.fvr("plain TNT is plain TNT", TalismanTable.picked(new class_1799((class_1935)class_1802.field_8626), Set.of("tnt")) && !TalismanTable.picked(new class_1799((class_1935)class_1802.field_8626), Set.of("white_tnt", "black_tnt")), "");
        ChestScenarioTest.fvm("lockpick", ChestScenarioTest.fvn(class_1802.field_8366, "[★] Отмычка к Сферам"), true, true);
        ChestScenarioTest.fvm("dragon skin", ChestScenarioTest.fvo(class_1802.field_8407, "[★] Драконий скин", "Нажмите, чтобы получить Драконий скин"), true, true);
        ChestScenarioTest.fvm("fly modifier", ChestScenarioTest.fvo(class_1802.field_8153, "[⚡] Модификатор полёта", "Доступ к /fly"), true, true);
        ChestScenarioTest.fvm("golden carrot", new class_1799((class_1935)class_1802.field_8071), true, true);
        ChestScenarioTest.fvm("fermented eye", new class_1799((class_1935)class_1802.field_8711), true, true);
        ChestScenarioTest.fvr("a plain totem is no line", !TalismanTable.known(new class_1799((class_1935)class_1802.field_8288)), "");
        ChestScenarioTest.fvr("dirt is no line", !TalismanTable.known(new class_1799((class_1935)class_1802.field_8831)), "");
        ChestScenarioTest.fvr("a plain feather is no line", !TalismanTable.known(new class_1799((class_1935)class_1802.field_8153)), "");
        ChestScenarioTest.fvr("the Russian name in Russian", TalismanTable.byId((String)"talisman_tyrant").name.equals("Талисман Тирана"), "");
    }

    private static void fvm(String string, class_1799 class_17992, boolean bl, boolean bl2) {
        boolean bl3 = TalismanTable.picked(class_17992, Set.of(TalismanTable.WARDEN_DEFAULTS));
        boolean bl4 = TalismanTable.picked(class_17992, Set.of(TalismanTable.END_DEFAULTS));
        ChestScenarioTest.fvr(string, bl3 == bl && bl4 == bl2, "warden=" + bl3 + " end=" + bl4);
    }

    private static class_1799 fvn(class_1792 class_17922, String string) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        class_17992.method_57379(class_9334.field_49631, (Object)class_2561.method_43470((String)string));
        return class_17992;
    }

    private static class_1799 fvo(class_1792 class_17922, String string, String string2) {
        class_1799 class_17992 = ChestScenarioTest.fvn(class_17922, string);
        class_17992.method_57379(class_9334.field_49632, (Object)new class_9290(List.of(class_2561.method_43470((String)string2))));
        return class_17992;
    }

    private static void fvp() {
        Object object = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        ChestScenarioTest.fvr("1st in", InstanceQueue.enter(object, "an238"), "");
        ChestScenarioTest.fvr("2nd in", InstanceQueue.enter(object2, "/an238"), "");
        ChestScenarioTest.fvr("3rd in", InstanceQueue.enter(object3, "238"), "");
        ChestScenarioTest.fvr("4th waits", !InstanceQueue.enter(object4, "an238"), "");
        ChestScenarioTest.fvr("4th is first in line", InstanceQueue.position(object4) == 1, String.valueOf(InstanceQueue.position(object4)));
        ChestScenarioTest.fvr("5th waits behind it", !InstanceQueue.enter(object5, "an238") && InstanceQueue.position(object5) == 2, "");
        ChestScenarioTest.fvr("another anarchy is free", InstanceQueue.hasRoom("an239", object5), "");
        ChestScenarioTest.fvr("one leaves for the loot", InstanceQueue.enter(object, "an239"), "");
        ChestScenarioTest.fvr("the 5th still waits (the 4th was first)", !InstanceQueue.enter(object5, "an238"), "");
        ChestScenarioTest.fvr("the 4th goes in", InstanceQueue.enter(object4, "an238"), "");
        ChestScenarioTest.fvr("the 5th is next now", InstanceQueue.position(object5) == 1, String.valueOf(InstanceQueue.position(object5)));
        InstanceQueue.leave(object2);
        ChestScenarioTest.fvr("the 5th goes in after a log-off", InstanceQueue.enter(object5, "an238"), "");
        ChestScenarioTest.fvr("three there", InstanceQueue.count("an238", null) == 3, String.valueOf(InstanceQueue.count("an238", null)));
        for (Object object6 : new Object[]{object, object2, object3, object4, object5}) {
            InstanceQueue.leave(object6);
        }
        ChestScenarioTest.fvr("typed hop parsed", "238".equals(AnarchyQueue.anarchy("an 238")) && "238".equals(AnarchyQueue.anarchy("/AN238")), "");
        ChestScenarioTest.fvr("other command is no hop", AnarchyQueue.anarchy("home") == null && AnarchyQueue.anarchy("ah 238") == null, "");
        ChestScenarioTest.fvr("own account in", AnarchyQueue.allow("an238"), "");
        ChestScenarioTest.fvr("two bots join it", InstanceQueue.enter(object, "an238") && InstanceQueue.enter(object2, "an238"), "");
        ChestScenarioTest.fvr("a 3rd bot waits behind the own account", !InstanceQueue.enter(object3, "an238"), "");
        InstanceQueue.leave(object);
        InstanceQueue.leave(object2);
        InstanceQueue.enter(object, "an240");
        InstanceQueue.enter(object2, "an240");
        InstanceQueue.enter(object3, "an240");
        ChestScenarioTest.fvr("own account's typed hop to a full anarchy is held back", !AnarchyQueue.allow("an240"), "");
        ChestScenarioTest.fvr("typing it again cancels the wait", !AnarchyQueue.allow("an240") && InstanceQueue.position(InstanceQueue.MAIN) == 0, "");
        for (Object object6 : new Object[]{object, object2, object3, InstanceQueue.MAIN}) {
            InstanceQueue.leave(object6);
        }
    }

    private static void fvq(ModuleManager kfx2) {
        Lang.set(wam.RU);
        int n2 = 0;
        for (Module kfe2 : kfx2.getModules()) {
            String string = Lang.t(kfe2.getDescription());
            boolean bl = string.chars().anyMatch(n -> n >= 1024 && n <= 1279);
            if (bl) continue;
            ++n2;
            System.out.println("farm test: no Russian description for " + kfe2.getName() + ": " + string);
        }
        ChestScenarioTest.fvr("every module described in Russian", n2 == 0, n2 + " in English");
    }

    private static void fvr(String string, boolean bl, String string2) {
        if (!bl) {
            ++fvc;
        }
        System.out.println("farm test " + (bl ? "PASS " : "FAIL ") + string + (bl || string2.isEmpty() ? "" : " (" + string2 + ")"));
    }

    private static void fvs(class_310 class_3102, ListSetting vlj2) throws Exception {
        ChestScenarioTest.fvk(class_3102, "Player");
        Method method = ClickGuiScreen.class.getDeclaredMethod("openPicker", ListSetting.class);
        method.setAccessible(true);
        method.invoke((Object)class_3102.field_1755, vlj2);
    }

    private static void fvt(class_437 class_4372, String string) {
        if (class_4372 != null) {
            for (char c : string.toCharArray()) {
                class_4372.method_25400(new class_11905((int)c, 0));
            }
        }
    }

    private static void fvu(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fvv(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int ri(int n, int n2) {
        return n ^ n2 ^ 0x1E9BD093;
    }

    private static /* synthetic */ int rj(int n, int n2) {
        return n - n2 | 0x9336326D;
    }

    private static /* synthetic */ int rk(int n, int n2) {
        return ChestScenarioTest.rj(n, n2) + n;
    }
}

