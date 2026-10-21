/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  net.minecraft.class_1132
 *  net.minecraft.class_1263
 *  net.minecraft.class_1268
 *  net.minecraft.class_1277
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_3222
 *  net.minecraft.class_3908
 *  net.minecraft.class_3917
 *  net.minecraft.class_747
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package a;

import a.fbh;
import a.Module;
import a.BoolSetting;
import a.Setting;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.class_1132;
import net.minecraft.class_1263;
import net.minecraft.class_1268;
import net.minecraft.class_1277;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_3222;
import net.minecraft.class_3908;
import net.minecraft.class_3917;
import net.minecraft.class_747;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

final class AutoSellTest {
    private static final String fbl = "§6[★] §eТалисман Крушителя";
    private static final String fbm = "§fЗолотое яблоко";
    private static final List<String> fbn = Collections.synchronizedList(new ArrayList());
    private static final List<String> fbo = Collections.synchronizedList(new ArrayList());
    private static int fbp;
    private static /* synthetic */ boolean fbq;
    private static /* synthetic */ boolean fbr;

    private AutoSellTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        if (n == 1) {
            class_3102.field_1690.field_1837 = false;
            class_3102.method_1562().method_45730("gamemode survival");
            AutoSellTest.fbs(class_3102);
        }
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("AutoSell");
        if (n == 40) {
            for (Setting vmo2 : kfe2.getSettings()) {
                if (!(vmo2 instanceof BoolSetting)) continue;
                BoolSetting vkl2 = (BoolSetting)vmo2;
                if (!vmo2.getName().equals("Из сундуков")) continue;
                vkl2.set(false);
            }
            kfe2.setEnabled(true);
            fbp = n;
        }
        if (!(fbp <= 0 || n <= fbp + 5 || kfe2.isEnabled() && n <= fbp + 1800)) {
            System.out.println("auc test searches: " + fbn);
            System.out.println("auc test sold: " + fbo);
            boolean bl = fbn.contains("талисман крушителя") && fbn.contains("золотое яблоко") && fbo.contains("talisman 949") && fbo.contains("apple16 909") && !kfe2.isEnabled();
            System.out.println("auc test " + (bl ? "PASS" : "FAIL") + " in " + (double)(n - fbp) / 20.0 + " s");
            kfe2.setEnabled(false);
            return true;
        }
        return false;
    }

    private static void fbs(class_310 class_3102) {
        class_3102.method_1576().execute(() -> {
            class_1132 class_11322 = class_3102.method_1576();
            CommandDispatcher commandDispatcher = class_11322.method_3734().method_9235();
            commandDispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247((String)"ah").then(class_2170.method_9247((String)"search").then(class_2170.method_9244((String)"q", (ArgumentType)StringArgumentType.greedyString()).executes(commandContext -> {
                class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
                String string = StringArgumentType.getString((CommandContext)commandContext, (String)"q");
                fbn.add(string);
                System.out.println("auc test: ah search " + string);
                AutoSellTest.fbt(class_32222, string);
                return 1;
            })))).then(class_2170.method_9247((String)"sell").then(class_2170.method_9244((String)"price", (ArgumentType)StringArgumentType.word()).executes(commandContext -> {
                class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
                String string = StringArgumentType.getString((CommandContext)commandContext, (String)"price");
                class_1799 class_17992 = class_32222.method_6047();
                String string2 = class_17992.method_31574(class_1802.field_8288) ? "talisman" : (class_17992.method_31574(class_1802.field_8463) ? "apple" + class_17992.method_7947() : class_17992.method_7909().toString());
                fbo.add(string2 + " " + string);
                System.out.println("auc test: ah sell " + string + " (" + string2 + ")");
                class_32222.method_6122(class_1268.field_5808, class_1799.field_8037);
                class_32222.method_64398((class_2561)class_2561.method_43470((String)"§aВы успешно выставили предмет на продажу"));
                return 1;
            }))));
            class_3222 class_32222 = class_11322.method_3760().method_14566(class_3102.field_1724.method_5477().getString());
            class_32222.method_31548().method_5448();
            class_32222.method_31548().method_5447(9, AutoSellTest.fbv(class_1802.field_8288, "§6[★] §eТалисман Крушителя", 1));
            class_32222.method_31548().method_5447(14, AutoSellTest.fbv(class_1802.field_8463, "§fЗолотое яблоко", 16));
            class_11322.method_3760().method_14576(class_32222);
        });
    }

    private static void fbt(class_3222 class_32222, String string) {
        ArrayList<class_1799> arrayList = new ArrayList<class_1799>();
        if (string.contains("талисман")) {
            for (int n : new int[]{5000, 1200, 1000, 1300}) {
                arrayList.add(AutoSellTest.fbu(class_1802.field_8288, "§6[★] §eТалисман Крушителя", 1, n));
            }
        } else if (string.contains("яблоко")) {
            arrayList.add(AutoSellTest.fbu(class_1802.field_8463, "§fЗолотое яблоко", 16, 800));
            arrayList.add(AutoSellTest.fbu(class_1802.field_8463, "§fЗолотое яблоко", 8, 480));
            arrayList.add(AutoSellTest.fbu(class_1802.field_8463, "§fЗолотое яблоко", 16, 1120));
        }
        class_32222.method_51469().method_8503().execute(() -> class_32222.method_17355((class_3908)new class_747((n, class_16612, class_16572) -> {
            class_1277 class_12772 = new class_1277(54);
            for (int i = 0; i < arrayList.size(); ++i) {
                class_12772.method_5447(i, (class_1799)arrayList.get(i));
            }
            return new fbh(class_3917.field_17327, n, class_16612, (class_1263)class_12772, 6);
        }, (class_2561)class_2561.method_43470((String)("Аукционы » " + string)))));
    }

    private static class_1799 fbu(class_1792 class_17922, String string, int n, int n2) {
        class_1799 class_17992 = AutoSellTest.fbv(class_17922, string, n);
        class_17992.method_57379(class_9334.field_49632, (Object)new class_9290(List.of(class_2561.method_43470((String)" "), class_2561.method_43470((String)("§6$ Цeнa: §e" + String.format("%,d", n2).replace(',', ' '))), class_2561.method_43470((String)"§7Продавец: Seller"))));
        return class_17992;
    }

    private static class_1799 fbv(class_1792 class_17922, String string, int n) {
        class_1799 class_17992 = new class_1799((class_1935)class_17922, n);
        class_17992.method_57379(class_9334.field_49631, (Object)class_2561.method_43470((String)string));
        return class_17992;
    }

    private static /* synthetic */ int nk(int n, int n2) {
        return n + n2 ^ 0xBC84C992;
    }

    private static /* synthetic */ int nl(int n, int n2) {
        return n + n2 | 0xF196B325;
    }

    private static /* synthetic */ int nm(int n, int n2) {
        return AutoSellTest.nk(n, n2) ^ 0xAE306EA6;
    }
}

