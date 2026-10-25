/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.GameMenuScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.NamedScreenHandlerFactory
 *  net.minecraft.screen.SimpleNamedScreenHandlerFactory
 *  net.minecraft.server.command.CommandManager
 *  net.minecraft.server.command.ServerCommandSource
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.text.Text
 */
package a;

import a.fjf;
import a.fjo;
import a.hlc;
import a.hrt;
import a.kfe;
import a.mkl;
import a.pdr;
import a.pej;
import a.vkw;
import a.vmo;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

final class fjv {
    private static final List<List<fjo>> fjw = new ArrayList<List<fjo>>();
    private static final List<List<fjo>> fjx = new ArrayList<List<fjo>>();
    private static final List<String> fjy = new ArrayList<String>();
    private static int fjz;
    private static int fka;
    private static int fkb;
    private static /* synthetic */ String fkc;
    private static /* synthetic */ String fkd;

    private fjv() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        boolean bl;
        if (n == 1) {
            fjv.fkg(minecraftClient);
        }
        if (n == 10) {
            for (pdr pdr2 : pej.items()) {
                pdr2.setActive(pdr2.name().equals(a.c(1127711615, "\u8766\ufefe\u7428\uea5c\u61f7\ue73a\u5d62\ud086\u4ab6\uc079\u47a0\ubdd4\u3307\uaab2")) || pdr2.name().equals(a.d("\u972f\uee82\u642d\ufa2b\u71f5\uf358\u4d1a\uc4ef\u5ac4\ud075\u57db\uada3\u2301\ubab2\u309b\ub61d", -1547564320, 2030541309)));
            }
            for (String object : new String[]{a.d("\ue86a\u91c5\u1b11\u856a\u0eb6\u881f\u3263", 310237167, -1419755531), a.b("\u0a85\u732a\uf9fe\u6785\uec59\u6af0\ud08d", 1038486261)}) {
                Field field = hlc.class.getDeclaredField(object);
                field.setAccessible(true);
                field.setFloat(null, Float.NaN);
            }
            minecraftClient.method_1507((Screen)new hlc());
        }
        if (n == 20) {
            hrt.open();
        }
        if (n == 40) {
            fjv.fkl(minecraftClient, a.c(1696401020, "\u060f\u7fb2\uf562\u6b13\ue0cd\u667a\udc3e\u55d4\ucb96\u4178\uc6e3\u3c93\ub249\u2be5\ua1ad\u2741"));
            minecraftClient.method_1507(null);
        }
        if (n == 60) {
            String[] stringArray = fjv.fke();
            stringArray.setEnabled(true);
            for (vmo vmo2 : stringArray.getSettings()) {
                vkw vkw2;
                if (!(vmo2 instanceof vkw) || !(vkw2 = (vkw)vmo2).getName().equals(a.b("\u7634\u0fbd\u8573\u1b1b", 86472295))) continue;
                vkw2.buttons().get(0).action().run();
            }
            fkb = n;
        }
        if (n == 220) {
            fjv.fkk(minecraftClient);
        }
        if (fkb > 0 && minecraftClient.field_1755 instanceof GameMenuScreen) {
            minecraftClient.method_1507(null);
        }
        if (n > 60 && n % 100 == 0) {
            System.out.println(a.c(-2021947974, "\u85c8\ufc75\u76a5\ue8d4\u630a\ue5bd\u5ff9\ud613\u4851\uc2b2\u4535\ubf55\u3194\ua822\u2225\ua480\u1e86") + n + a.d("\u3caa\u455a\ucf98\u51e9\uda22\u5c9a\ue6df\u6f60", -1049685970, -754111316) + fjv.fkf(minecraftClient, Items.field_8463) + a.b("\u3501\u4ce4\uc62c\u5846\ud380\u5539\uef74\u66cb", 1608332585) + fjv.fkf(minecraftClient, Items.field_8288) + a.c(1285554454, "\u013e\u78cc\uf210\u6c64\ue7b9\u6100\udb4b\u52f4") + fjz + a.b("\uf72b\u8ec9\u040c\u9a79\u11bd\u971d\u2d45\ua4b9\u3af0\ub00f", 1173812993) + fka);
        }
        boolean bl2 = bl = fjv.fkf(minecraftClient, Items.field_8463) >= 16 && fjv.fkf(minecraftClient, Items.field_8288) >= 1 && minecraftClient.field_1755 == null && mkl.collecting() == null;
        if (fkb > 0 && (bl || n > 2460)) {
            for (String string : fjy) {
                System.out.println(a.c(-1205244786, "\u6cfc\u1541\u9f91\u01e0\u8a3e\u0c89\ub6cd\u3f27\ua165\u2b86\uac17\u566b\ud8a6\u4105\ucb59\u4db4\uf7af") + string);
            }
            boolean bl3 = fjy.size() == 2 && fjy.contains(a.d("\udb1a\ua2a3\u2873\ub60a\u3ddc\ubb66\u0104\u88cb\u1685\u9c34\u1bfb\ue183\u6f11\uf6f8\u7ce2\ufa14\u404d\ucffc\u553a\ud36e", -106870202, -771649233)) && fjy.contains(a.c(-1779214859, "\u5599\u2c33\ua6fb\u389b\ub344\u35c7\u8fa4\u065c\u983a\u12a1\u9569\u6f12\ue1d8\u7879\uf22d\u74d5\ucedd\u4154\udbae\u5dee\ud479\uae5a\u20eb\ubb3a"));
            System.out.println(a.d("\u3c29\u4594\ucf44\u5135\udaeb\u5c5c\ue618\u6ff2\uf1b0\u7b53\ufcd4\u06b4\u8875\u11c3\u9bc4", -1763079091, -1473007608) + (bl3 ? a.b("\u4dde\u347e\ubebf\u20ce", 1075006858) : a.d("\u60f3\u1945\u939e\u0dea", -1889157236, -664346819)) + a.d("\u34cf\u4d37\uc7e3\u59dc", -967650387, 1239410502) + (double)(n - fkb) / 20.0 + a.d("\u07d3\u7e31\uf4bd\u6ac0\ue154\u67ea\uddbc\u5447\uca10\u40b9\uc724", 1152220038, -1171489666) + fjz + a.c(1429745722, "\u3010\u49f2\uc337\u5d42\ud686\u5026\uea7e\u6382\ufdcb\u7734") + fka);
            fjv.fke().setEnabled(false);
            return true;
        }
        return false;
    }

    private static kfe fke() {
        for (kfe kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            if (!kfe2.getName().equals(a.d("\u41c0\u3845\ub297\u2cfd\ua706\u219b\u9bcb\u123a\u8c6c\u06db\u811f\u7b75\uf5bf", -477235129, -1691174453))) continue;
            return kfe2;
        }
        throw new IllegalStateException(a.d("\u3d1f\u44af\uce33\u5023\udbc0\u5d70\ue738\u6ee5\uf096\u7a24\ufdf7\u078f\u895e\u10f8\u9ab0\u1c5c", 411646939, -270465350));
    }

    private static int fkf(MinecraftClient minecraftClient, Item item) {
        int n = 0;
        for (int i = 0; i < 41; ++i) {
            ItemStack itemStack = minecraftClient.field_1724.method_31548().method_5438(i);
            if (!itemStack.method_31574(item)) continue;
            n += itemStack.method_7947();
        }
        return n;
    }

    private static void fkg(MinecraftClient minecraftClient) {
        minecraftClient.field_1690.field_1837 = false;
        fjw.clear();
        fjw.add(List.of(new fjo(Items.field_8463, 16, 100, false), new fjo(Items.field_8463, 8, 90, false), new fjo(Items.field_8477, 1, 5, false)));
        fjw.add(List.of(new fjo(Items.field_8463, 16, 80, false), new fjo(Items.field_8463, 64, 10, false)));
        fjw.add(List.of(new fjo(Items.field_8463, 16, 50, false), new fjo(Items.field_8463, 16, 120, false)));
        fjx.clear();
        fjx.add(List.of(new fjo(Items.field_8288, 1, 5, true), new fjo(Items.field_8288, 1, 300, false)));
        fjx.add(List.of(new fjo(Items.field_8288, 1, 200, false)));
        fjy.clear();
        minecraftClient.method_1576().execute(() -> minecraftClient.method_1576().method_3734().method_9235().register((LiteralArgumentBuilder)CommandManager.method_9247((String)a.c(-394057898, "\u2735\u5e8d")).then(CommandManager.method_9247((String)a.c(1943436757, "\u7da0\u0407\u8ed0\u10b2\u9b74\u1dce")).then(CommandManager.method_9244((String)a.b("\udf93", -140714013), (ArgumentType)StringArgumentType.greedyString()).executes(commandContext -> {
            ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).method_9207();
            ++fka;
            String string = StringArgumentType.getString((CommandContext)commandContext, (String)a.b("\u73cf", -860523585));
            ArrayList arrayList = string.toLowerCase().contains(a.b("\ud87d\ua1b2\u2b6b\ub51f\u3ecc\ub879", -231809996)) ? fjw : (string.toLowerCase().contains(a.c(-307971912, "\ubcff\uc532\u4f9d\ud19b\u5a45")) ? fjx : new ArrayList());
            fjv.fkh(serverPlayerEntity, string, arrayList);
            return 1;
        })))));
        minecraftClient.method_1562().method_45730(a.b("\udf80\ua637\u2ce8\ub291\u394e\ubffd\u05a5\u8c55\u124f\u98ad\u1f78\ue50e\u6bdd\uf273\u783f\ufed9\u449b", 1991761910));
        minecraftClient.method_1562().method_45730(a.c(-1101271582, "\ued89\u9437\u1eed\u8098\u0b5c\u8dbf\u378c\ube4e"));
    }

    private static void fkh(ServerPlayerEntity serverPlayerEntity, String string, List<List<fjo>> list) {
        serverPlayerEntity.method_51469().method_8503().execute(() -> serverPlayerEntity.method_17355((NamedScreenHandlerFactory)new SimpleNamedScreenHandlerFactory((n, playerInventory, playerEntity) -> new fjf(n, playerInventory, string, list), (Text)Text.method_43470((String)(a.d("\ued0d\u94ef\u1e45\u8048\u0be1\u8d56\u3706\ube81\u24b5\uae9f\u29d7", 948621306, 1188898540) + string)))));
    }

    private static ItemStack fki(fjo fjo2) {
        ItemStack itemStack = new ItemStack((ItemConvertible)fjo2.item(), fjo2.count());
        itemStack.method_57379(DataComponentTypes.field_49632, (Object)new LoreComponent(List.of(Text.method_43470((String)a.d("\u93c7", -793090041, -862782495)), Text.method_43470((String)(a.d("\u858c\ufcac\u766d\ue818\u67c9\ue53b\u5b30\ud69d\u4899\uc232\u4566\ubfd5", 1343909004, -1735202389) + String.format(a.c(149046876, "\u467a\u3fc2\ub559"), fjo2.price() * fjo2.count()).replace(',', ' '))), Text.method_43470((String)a.d("\u129f\u6bbe\ue545\u7b6b\uf0c2\u7679\ucc2e\u45dd\udb85\u5147\ud2e8\u2883\ua627\u3fa0\ub5fa\u330b\u894d\u068b", 372596788, -494767586)))));
        if (fjo2.glint()) {
            itemStack.method_57379(DataComponentTypes.field_49641, (Object)true);
        }
        return itemStack;
    }

    private static ItemStack fkj(Item item, String string) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        itemStack.method_57379(DataComponentTypes.field_49631, (Object)Text.method_43470((String)string));
        return itemStack;
    }

    private static void fkk(MinecraftClient minecraftClient) {
        fjv.fkl(minecraftClient, a.b("\ue5b4\u9c09\u16d9\u88a8\u0376\u85c1\u3f85\ub66f\u282d\ua2c3\u255c\udf39\u51f8\uc85e\u4210\uc4e7\u7ea9", -1050810938));
    }

    private static void fkl(MinecraftClient minecraftClient, String string) {
        System.out.println(a.d("\ub8cb\uc16c\u4bb6\ud5cd\u5e5c\ud8b9\u62fb\ueb1c\u7544\uffa1", -1257100161, -1836018483) + string);
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(1705350918, "\u9766\ueedd\u640d\ufa64\u71f6\uf758") + string + a.b("\ue0fe\u9911\u13dc\u8da4", -612441900)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int pk(int n, int n2) {
        return n * n2 + -1635781412;
    }
}

