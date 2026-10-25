/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.inventory.SimpleInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.NamedScreenHandlerFactory
 *  net.minecraft.screen.ScreenHandlerType
 *  net.minecraft.screen.SimpleNamedScreenHandlerFactory
 *  net.minecraft.server.command.CommandManager
 *  net.minecraft.server.command.ServerCommandSource
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.text.Text
 *  net.minecraft.util.Hand
 */
package a;

import a.fbh;
import a.kfe;
import a.vkl;
import a.vmo;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

final class fbk {
    private static final String fbl = a.c(1293647272, "\u7d15\u0435\u8e8b\u36a4\u9b2b\u1de7\ua733\u2e00\ub418\u3ebb\ub963\u4311\ucdbf\u5473\ude2c\u58d0\ue682\u6d69\uf780\u71d2\uf82e\u820f\u0cc6\u9760\u1111\u9bb4");
    private static final String fbm = a.b("\ubb09\uc279\u4cdb\ud283\u5951\udfe5\u65ca\uec47\u7213\ufcb7\u7f0b\u8504\u0bd9\u926d\u183a\u9ecf", -108610626);
    private static final List<String> fbn = Collections.synchronizedList(new ArrayList());
    private static final List<String> fbo = Collections.synchronizedList(new ArrayList());
    private static int fbp;
    private static /* synthetic */ boolean fbq;
    private static /* synthetic */ boolean fbr;

    private fbk() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        if (n == 1) {
            minecraftClient.field_1690.field_1837 = false;
            minecraftClient.method_1562().method_45730(a.b("\ufc8a\u853d\u0fe2\u919b\u1a44\u9cf7\u26af\uaf5f\u3145\ubba7\u3c72\uc604\u48d7\ud179\u5b35\uddd3\u6791", -554631940));
            fbk.fbs(minecraftClient);
        }
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\ud83f\ua1ba\u2b68\ub502\u3ee9\ub86e\u0234\u8bc5", -2064459658));
        if (n == 40) {
            for (vmo vmo2 : kfe2.getSettings()) {
                if (!(vmo2 instanceof vkl)) continue;
                vkl vkl2 = (vkl)vmo2;
                if (!vmo2.getName().equals(a.b("\u24ec\u5d72\ud3b6\u49a6\uc273\u44bc\ufee6\u7760\ue946\u63f3\ue42c", 775954687))) continue;
                vkl2.set(false);
            }
            kfe2.setEnabled(true);
            fbp = n;
        }
        if (!(fbp <= 0 || n <= fbp + 5 || kfe2.isEnabled() && n <= fbp + 1800)) {
            System.out.println(a.d("\uf58d\u8c28\u06ed\u98df\u135c\u95fc\u2fb9\ua64f\u3844\ub2a6\u3563\ucf16\u41d2\ud872\u522a\ud4d6\u6e8f\ue117\u7bbe", -595449031, -1344282938) + fbn);
            System.out.println(a.d("\u5527\u2c82\ua647\u3875\ub3f6\u3556\u8f13\u06e5\u98ee\u120c\u95c3\u6fb1\ue16e\u7881\uf2c8", 39237823, -1779372554) + fbo);
            boolean bl = fbn.contains(a.b("\u546a\u2da9\ua771\u3903\ub2ad\u3461\u8e3e\u07c2\u9d80\u132b\u9482\u6ef0\ue02c\u79ed\uf3c4\u7542\ucf03\u40a6", 2112639034)) && fbn.contains(a.c(-1258825930, "\ud30f\uaab7\u2061\ube15\u35be\ub373\u092b\u84cf\u1eff\u9430\u13e9\ue99d\u674e\ufefb")) && fbo.contains(a.c(-1245452352, "\ue7b8\u9e1c\u14c2\u8ab6\u017b\u87d4\u3d8b\ub475\u2a64\ua0cc\u2712\udd6e")) && fbo.contains(a.b("\u3b6f\u42cf\uc81c\u5671\uddaf\u5b4a\ue11e\u68f9\uf6bf\u7c07\ufbdd", -1794098427)) && !kfe2.isEnabled();
            System.out.println(a.c(1585088383, "\u8717\ufeb2\u7477\uea45\u61c6\ue766\u5d23\ud4d5\u4ade") + (bl ? a.d("\ud5c1\uac61\u26a0\ub8d1", 1462404644, 313086897) : a.d("\u9e42\ue7f4\u6d2f\uf35b", -390288334, -1233636814)) + a.b("\u2ab3\u534b\ud99f\u47a0", -1104532841) + (double)(n - fbp) / 20.0 + a.c(-1005345528, "\ua52a\udcc8"));
            kfe2.setEnabled(false);
            return true;
        }
        return false;
    }

    private static void fbs(MinecraftClient minecraftClient) {
        minecraftClient.method_1576().execute(() -> {
            IntegratedServer integratedServer = minecraftClient.method_1576();
            CommandDispatcher commandDispatcher = integratedServer.method_3734().method_9235();
            commandDispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)CommandManager.method_9247((String)a.b("\u5853\u21eb", -599762896)).then(CommandManager.method_9247((String)a.b("\uc17c\ub8db\u320c\uac6e\u27a8\ua112", 1640022281)).then(CommandManager.method_9244((String)a.b("\u7b48", 775387960), (ArgumentType)StringArgumentType.greedyString()).executes(commandContext -> {
                ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).method_9207();
                String string = StringArgumentType.getString((CommandContext)commandContext, (String)a.c(-1230087837, "\u5913"));
                fbn.add(string);
                System.out.println(a.d("\u2bc3\u5266\ud8a3\u4691\ucd12\u4bb2\uf1f7\u7801\ue610\u6cbb\ueb29\u1151\u9fce\u062c\u8c69\u0a9c\ub0c0\u3f00\ua5b8\u23a1", -263186052, 1980969674) + string);
                fbk.fbt(serverPlayerEntity, string);
                return 1;
            })))).then(CommandManager.method_9247((String)a.d("\u4de9\u344e\ube94\u20e5", -1277554645, -437756491)).then(CommandManager.method_9244((String)a.b("\ua765\uded6\u541e\uca65\u41b4", 1418241808), (ArgumentType)StringArgumentType.word()).executes(commandContext -> {
                ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).method_9207();
                String string = StringArgumentType.getString((CommandContext)commandContext, (String)a.c(908919499, "\u02be\u7b0d\uf1c5\u6fbe\ue46f"));
                ItemStack itemStack = serverPlayerEntity.method_6047();
                String string2 = itemStack.method_31574(Items.field_8288) ? a.d("\ue863\u91c7\u1b19\u856d\u0ea0\u880f\u3250\ubbae", -1488463553, 361509152) : (itemStack.method_31574(Items.field_8463) ? a.c(266803768, "\u1a5c\u63fc\ue92f\u7742\ufc9c") + itemStack.method_7947() : itemStack.method_7909().toString());
                fbo.add(string2 + a.d("\u884d", -1273448989, -1686684273) + string);
                System.out.println(a.d("\uab6c\ud2c9\u580c\uc63e\u4dbd\ucb1d\u7158\uf8ae\u66bf\uec14\u6b86\u91fe\u1f61\u8683\u0cc6\u8a3e\u3071\ubfec", 1111554602, 1712607541) + string + a.b("\ua2fa\udb43", -352214312) + string2 + a.d("\u6db4", 703127057, 639021965));
                serverPlayerEntity.method_6122(Hand.field_5808, ItemStack.field_8037);
                serverPlayerEntity.method_64398((Text)Text.method_43470((String)a.c(-473268833, "\u7d11\u0466\u8ac6\u14ee\u9b52\u1980\ua3d1\u2a5e\ub40b\u3ec7\ub961\u4313\uc9da\u5479\ude53\u58a8\ue2e4\u6d47\uf7f6\u71ad\uf859\u820b\u08a0\u976e\u116e\u9bca\u2278\uac21\u36df\ub0f9\u3f28\uc5e4\u4fa6\ud247\u500b\udac5\u656c\uef17\u69c0\uf077\u7a5d")));
                return 1;
            }))));
            ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(minecraftClient.field_1724.method_5477().getString());
            serverPlayerEntity.method_31548().method_5448();
            serverPlayerEntity.method_31548().method_5447(9, fbk.fbv(Items.field_8288, a.b("\u4ac4\u33e4\ub95a\u0175\uacfa\u2a36\u90e2\u19d1\u83c9\u096a\u8eb2\u74c0\ufa6e\u63a2\ue9fd\u6f01\ud153\u5ab8\uc051\u4603\ucfff\ub5de\u3b17\ua0b1\u26c0\uac65", 958810745), 1));
            serverPlayerEntity.method_31548().method_5447(14, fbk.fbv(Items.field_8463, a.c(-2114917427, "\ueb7a\u920a\u1ca8\u82f0\u0922\u8f96\u35b9\ubc34\u2260\uacc4\u2f78\ud577\u5baa\uc21e\u4849\ucebc"), 16));
            integratedServer.method_3760().method_14576(serverPlayerEntity);
        });
    }

    private static void fbt(ServerPlayerEntity serverPlayerEntity, String string) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        if (string.contains(a.d("\u0fca\u7609\ufcd1\u62a3\ue90d\u6fc1\ud59e\u5c62", -834313699, -515282531))) {
            for (int n : new int[]{5000, 1200, 1000, 1300}) {
                arrayList.add(fbk.fbu(Items.field_8288, a.c(729864317, "\ud8c0\ua1e0\u2b5e\u9371\u3efe\ub832\u02e6\u8bd5\u11cd\u9b6e\u1cb6\ue6c4\u686a\uf1a6\u7bf9\ufd05\u4357\uc8bc\u5255\ud407\u5dfb\u27da\ua913\u32b5\ub4c4\u3e61"), 1, n));
            }
        } else if (string.contains(a.d("\u71c5\u080a\u82d3\u1ca7\u9774\u11c1", 1834586556, 166192176))) {
            arrayList.add(fbk.fbu(Items.field_8463, a.b("\u5a46\u2336\uad94\u33cc\ub81e\u3eaa\u8485\u0d08\u935c\u1df8\u9e44\u644b\uea96\u7322\uf975\u7f80", 992697073), 16, 800));
            arrayList.add(fbk.fbu(Items.field_8463, a.c(-1902286666, "\u6801\u1171\u9fd3\u018b\u8a59\u0ced\ub6c2\u3f4f\ua11b\u2fbf\uac03\u560c\ud8d1\u4165\ucb32\u4dc7"), 8, 480));
            arrayList.add(fbk.fbu(Items.field_8463, a.d("\u9418\ued68\u63ca\ufd92\u7640\uf0f4\u4adb\uc356\u5d02\ud3a6\u501a\uaa15\u24c8\ubd7c\u372b\ub1de", -532862386, 1129430753), 16, 1120));
        }
        serverPlayerEntity.method_51469().method_8503().execute(() -> serverPlayerEntity.method_17355((NamedScreenHandlerFactory)new SimpleNamedScreenHandlerFactory((n, playerInventory, playerEntity) -> {
            SimpleInventory simpleInventory = new SimpleInventory(54);
            for (int i = 0; i < arrayList.size(); ++i) {
                simpleInventory.method_5447(i, (ItemStack)arrayList.get(i));
            }
            return new fbh(ScreenHandlerType.field_17327, n, playerInventory, (Inventory)simpleInventory, 6);
        }, (Text)Text.method_43470((String)(a.b("\ub182\uc860\u42ca\udcc7\u576e\ud1d9\u6b89\ue20e\u783a\uf210\u7558", -77351527) + string)))));
    }

    private static ItemStack fbu(Item item, String string, int n, int n2) {
        ItemStack itemStack = fbk.fbv(item, string, n);
        itemStack.method_57379(DataComponentTypes.field_49632, (Object)new LoreComponent(List.of(Text.method_43470((String)a.b("\ude9f", -1155014978)), Text.method_43470((String)(a.c(-1051773491, "\u3566\u4c46\uc687\u58f2\ud723\u55d1\uebda\u6677\uf873\u72d8\uf58c\u0f3f") + String.format(a.d("\ufd0f\u84b7\u0e2c", 894465, -235840728), n2).replace(',', ' '))), Text.method_43470((String)a.c(405001453, "\ud458\uad79\u2382\ubdac\u3605\ub0be\u0ae9\u831a\u1d42\u9780\u142f\uee44\u60e0\uf967\u733d\uf5cc\u4f8a\uc04c")))));
        return itemStack;
    }

    private static ItemStack fbv(Item item, String string, int n) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item, n);
        itemStack.method_57379(DataComponentTypes.field_49631, (Object)Text.method_43470((String)string));
        return itemStack;
    }

    private static /* synthetic */ int nk(int n, int n2) {
        return n + n2 ^ 0xBC84C992;
    }

    private static /* synthetic */ int nl(int n, int n2) {
        return n + n2 | 0xF196B325;
    }

    private static /* synthetic */ int nm(int n, int n2) {
        return fbk.nk(n, n2) ^ 0xAE306EA6;
    }
}

