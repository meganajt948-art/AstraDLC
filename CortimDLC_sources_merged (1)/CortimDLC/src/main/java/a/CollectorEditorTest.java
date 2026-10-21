/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2561
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_3222
 *  net.minecraft.class_3908
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_747
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package a;

import a.fjf;
import a.fjo;
import a.ClickGuiScreen;
import a.CollectorListPopup;
import a.Module;
import a.AutoCollector;
import a.CustomItemInfo;
import a.CollectorState;
import a.ButtonSetting;
import a.Setting;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2561;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_3222;
import net.minecraft.class_3908;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_747;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

final class CollectorEditorTest {
    private static final List<List<fjo>> fjw = new ArrayList<List<fjo>>();
    private static final List<List<fjo>> fjx = new ArrayList<List<fjo>>();
    private static final List<String> fjy = new ArrayList<String>();
    private static int fjz;
    private static int fka;
    private static int fkb;
    private static /* synthetic */ String fkc;
    private static /* synthetic */ String fkd;

    private CollectorEditorTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        boolean bl;
        if (n == 1) {
            CollectorEditorTest.fkg(class_3102);
        }
        if (n == 10) {
            for (CustomItemInfo pdr2 : CollectorState.items()) {
                pdr2.setActive(pdr2.name().equals("Золотое яблоко") || pdr2.name().equals("Тотем бессмертия"));
            }
            for (String object : new String[]{"windowX", "windowY"}) {
                Field field = ClickGuiScreen.class.getDeclaredField(object);
                field.setAccessible(true);
                field.setFloat(null, Float.NaN);
            }
            class_3102.method_1507((class_437)new ClickGuiScreen());
        }
        if (n == 20) {
            CollectorListPopup.open();
        }
        if (n == 40) {
            CollectorEditorTest.fkl(class_3102, "collector-editor");
            class_3102.method_1507(null);
        }
        if (n == 60) {
            String[] stringArray = CollectorEditorTest.fke();
            stringArray.setEnabled(true);
            for (Setting vmo2 : stringArray.getSettings()) {
                ButtonSetting vkw2;
                if (!(vmo2 instanceof ButtonSetting) || !(vkw2 = (ButtonSetting)vmo2).getName().equals("Work")) continue;
                vkw2.buttons().get(0).action().run();
            }
            fkb = n;
        }
        if (n == 220) {
            CollectorEditorTest.fkk(class_3102);
        }
        if (fkb > 0 && class_3102.field_1755 instanceof class_433) {
            class_3102.method_1507(null);
        }
        if (n > 60 && n % 100 == 0) {
            System.out.println("collector test t=" + n + " apples=" + CollectorEditorTest.fkf(class_3102, class_1802.field_8463) + " totems=" + CollectorEditorTest.fkf(class_3102, class_1802.field_8288) + " clicks=" + fjz + " searches=" + fka);
        }
        boolean bl2 = bl = CollectorEditorTest.fkf(class_3102, class_1802.field_8463) >= 16 && CollectorEditorTest.fkf(class_3102, class_1802.field_8288) >= 1 && class_3102.field_1755 == null && AutoCollector.collecting() == null;
        if (fkb > 0 && (bl || n > 2460)) {
            for (String string : fjy) {
                System.out.println("collector bought " + string);
            }
            boolean bl3 = fjy.size() == 2 && fjy.contains("golden_apple x16 @50") && fjy.contains("totem_of_undying x1 @200");
            System.out.println("collector test " + (bl3 ? "PASS" : "FAIL") + " in " + (double)(n - fkb) / 20.0 + " s, clicks=" + fjz + " searches=" + fka);
            CollectorEditorTest.fke().setEnabled(false);
            return true;
        }
        return false;
    }

    private static Module fke() {
        for (Module kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            if (!kfe2.getName().equals("AutoCollector")) continue;
            return kfe2;
        }
        throw new IllegalStateException("no AutoCollector");
    }

    private static int fkf(class_310 class_3102, class_1792 class_17922) {
        int n = 0;
        for (int i = 0; i < 41; ++i) {
            class_1799 class_17992 = class_3102.field_1724.method_31548().method_5438(i);
            if (!class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private static void fkg(class_310 class_3102) {
        class_3102.field_1690.field_1837 = false;
        fjw.clear();
        fjw.add(List.of(new fjo(class_1802.field_8463, 16, 100, false), new fjo(class_1802.field_8463, 8, 90, false), new fjo(class_1802.field_8477, 1, 5, false)));
        fjw.add(List.of(new fjo(class_1802.field_8463, 16, 80, false), new fjo(class_1802.field_8463, 64, 10, false)));
        fjw.add(List.of(new fjo(class_1802.field_8463, 16, 50, false), new fjo(class_1802.field_8463, 16, 120, false)));
        fjx.clear();
        fjx.add(List.of(new fjo(class_1802.field_8288, 1, 5, true), new fjo(class_1802.field_8288, 1, 300, false)));
        fjx.add(List.of(new fjo(class_1802.field_8288, 1, 200, false)));
        fjy.clear();
        class_3102.method_1576().execute(() -> class_3102.method_1576().method_3734().method_9235().register((LiteralArgumentBuilder)class_2170.method_9247((String)"ah").then(class_2170.method_9247((String)"search").then(class_2170.method_9244((String)"q", (ArgumentType)StringArgumentType.greedyString()).executes(commandContext -> {
            class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
            ++fka;
            String string = StringArgumentType.getString((CommandContext)commandContext, (String)"q");
            ArrayList arrayList = string.toLowerCase().contains("яблоко") ? fjw : (string.toLowerCase().contains("тотем") ? fjx : new ArrayList());
            CollectorEditorTest.fkh(class_32222, string, arrayList);
            return 1;
        })))));
        class_3102.method_1562().method_45730("gamemode survival");
        class_3102.method_1562().method_45730("clear @s");
    }

    private static void fkh(class_3222 class_32222, String string, List<List<fjo>> list) {
        class_32222.method_51469().method_8503().execute(() -> class_32222.method_17355((class_3908)new class_747((n, class_16612, class_16572) -> new fjf(n, class_16612, string, list), (class_2561)class_2561.method_43470((String)("Аукционы » " + string)))));
    }

    private static class_1799 fki(fjo fjo2) {
        class_1799 class_17992 = new class_1799((class_1935)fjo2.item(), fjo2.count());
        class_17992.method_57379(class_9334.field_49632, (Object)new class_9290(List.of(class_2561.method_43470((String)" "), class_2561.method_43470((String)("§6$ Цeнa: §e" + String.format("%,d", fjo2.price() * fjo2.count()).replace(',', ' '))), class_2561.method_43470((String)"§7Продавец: Seller"))));
        if (fjo2.glint()) {
            class_17992.method_57379(class_9334.field_49641, (Object)true);
        }
        return class_17992;
    }

    private static class_1799 fkj(class_1792 class_17922, String string) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922);
        class_17992.method_57379(class_9334.field_49631, (Object)class_2561.method_43470((String)string));
        return class_17992;
    }

    private static void fkk(class_310 class_3102) {
        CollectorEditorTest.fkl(class_3102, "collector-auction");
    }

    private static void fkl(class_310 class_3102, String string) {
        System.out.println("self test " + string);
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int pk(int n, int n2) {
        return n * n2 + -1635781412;
    }
}

