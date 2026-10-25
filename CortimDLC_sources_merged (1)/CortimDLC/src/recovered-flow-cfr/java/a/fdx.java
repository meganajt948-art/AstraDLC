/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.minecraft.SharedConstants
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.WallSignBlock
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.entity.SignBlockEntity
 *  net.minecraft.block.entity.SignText
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.inventory.SimpleInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 *  net.minecraft.registry.Registry
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.resource.ResourceType
 *  net.minecraft.screen.CraftingScreenHandler
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.NamedScreenHandlerFactory
 *  net.minecraft.screen.ScreenHandlerType
 *  net.minecraft.screen.SimpleNamedScreenHandlerFactory
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.command.CommandManager
 *  net.minecraft.server.command.ServerCommandSource
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.state.property.Property
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.WorldSavePath
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.math.Position
 *  net.minecraft.world.World
 */
package a;

import a.fdt;
import a.kfe;
import a.nfi;
import a.nfl;
import a.pzc;
import a.qaj;
import a.qdz;
import a.qmh;
import a.qof;
import a.qpw;
import a.qsw;
import a.tck;
import a.tel;
import a.vkl;
import a.vmc;
import a.vmo;
import a.vmu;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.SharedConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.block.entity.SignText;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

final class fdx {
    private static final String fdy = System.getenv().getOrDefault(a.d("\uee69\u97d2\u1d02\u836b\u08d9\u8e05\u344b\ubdb9\u23f4\ua953\u2e9a\ud4fb\u5a2d\uc39e\u49d8", -2125142414, 835455058), a.b("\u8822\uf19e\u7b55\ue532\u6eff\ue84f\u5244\udbfb\u45a7\ucf04\u48c1\ub2f9\u3c60\ua5c6\u2f99\ua974\u132c\u9ca3\u0648\u801f\u09fb\u73bb", 1705609304));
    private static String fdz;
    private static BlockPos fea;
    private static BlockPos feb;
    private static BlockPos fec;
    private static BlockPos fed;
    private static BlockPos fee;
    private static BlockPos fef;
    private static BlockPos feg;
    private static long feh;
    private static long fei;
    private static long fej;
    private static int fek;
    private static int fel;
    private static int fem;
    private static boolean fen;
    private static int feo;
    private static final List<String> fep;
    private static final qof feq;
    private static boolean fer;
    private static qaj fes;
    private static qdz fet;
    private static final tel feu;
    private static final qmh fev;
    private static boolean few;
    private static BlockPos fex;
    private static int fey;
    private static volatile boolean fez;
    private static volatile boolean ffa;
    private static volatile long ffb;
    private static final List<Item> ffc;
    private static /* synthetic */ int ffd;
    private static /* synthetic */ boolean ffe;

    private fdx() {
    }

    static boolean tick(MinecraftClient minecraftClient2, int n) throws Exception {
        Object object2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient2.player;
        fdx.ffx(minecraftClient2);
        if (n == 1) {
            if (System.getenv(a.d("\u01e2\u7859\uf289\u6ce0\ue752\u618e\udbcf\u523a\ucc62\u46d8\uc111\u3b6b\ub5ba\u2c18\ua649\u20be", 138791207, 1291438227)) != null) {
                qsw.trace = string -> System.out.println(a.d("\uedf7\u9441\u1e87\u80e4\u0b28\u8dd1", -354314714, -290554972) + string);
            }
            fdx.ffw(a.d("\u3324\u4abd\uc06a\u5e37\ud5d2\u5363\ue92a\u60c1\ufe99", -1268483825, -1493415325), false);
            fdx.ffw(a.c(1976889784, "\uf1f6\u8873\u02b7\u9cc6\u1738\u91aa\u2bf9\ua20c"), false);
            fdx.ffw(a.b("\ue9a6\u9023\u1af1\u849b\u0f77\u89fd\u33b5\uba55\u2402", 322824686), false);
            fdx.ffw(a.d("\u6e49\u17cc\u9d1e\u0374\u8898\u0e12\ub441\u3db3", -1680684380, 1187226788), false);
            fdx.ffz(minecraftClient2, a.c(-1308812717, "\u1a25\u6392\ue94d\u7734\ufceb\u7a58\uc000\u49f0\ud7ea\u5d08\udadd\u20ab\uae78\u37d6\ubd9a\u3b7c\u813e"));
            fdx.ffz(minecraftClient2, a.d("\u88d4\uf166\u7bb5\ue5c7\u6e16\ue8b0\u52b7\udb01\u4550\ucffe\u483e\ub20a\u3cbd\ua53f\u2f3f\ua99c\u13c4\u9c03\u06aa\u80e1\u0911\u7355\ufde9\u6635\ue04c\u6ad8\ud37a\u5d2a\uc7dd\u418c\uca2f\u34ea\ubeb1\u2714\ua141\u2bf7\u9430", -2136770993, -1864433957));
            fdx.ffz(minecraftClient2, a.c(274223750, "\u52c4\u2b76\ua1a5\u3fd7\ub406\u32a0\u88a7\u0111\u9f40\u15ee\u922e\u681a\ue6ad\u7f2f\uf52f\u7390\uc9d8\u4607\udcbb\u5af6\ud32a\ua952\u27fe\ubc35\u3a50\ub087\u0935\u872a\u1dcc\u9b9c\u102f\ueefe\u64a1\ufd40\u7b03\uf1e6\u4e37\uc441\u4282"));
            fdx.ffz(minecraftClient2, a.c(2106547120, "\u5bc8\u2264\ua8b3\u36ca\ubd58\u3bba\u81ff\u081f\u9614\u1ce1\u9b37\u615e"));
            fdx.ffz(minecraftClient2, a.d("\u3a44\u43f3\uc92c\u5755\udc95\u5a23\ue069\u6991\uf78b\u7d7e\ufaa6\u00fc\u8e0e\u17a7\u9de1\u1b15\ua154\u2e8a\ub425\u3243\ubb8e\uc1c5\u4f79\ud4a1\u529b\ud80c\u61b8\uefe4\u750c\uf34b", -1982658438, -1882574265));
            fdx.ffz(minecraftClient2, a.c(-40414019, "\u54c6\u2d71\ua7ae\u39d7\ub217\u34a1\u8eeb\u0713\u9909\u13fc\u9424\u6e77\ue082\u793e\uf35c\u758e\ucfd0\u4017\udabd\u5ceb\ud51b\uaf43\u21b7\uba20\u3c58\ub684\u0f28\u816f"));
            fdx.ffz(minecraftClient2, a.d("\u8ea3\uf71d\u7dc7\ue3b2\u6876\uee95\u54a6\udd64", -1077189503, -1941181879));
            if (!fen) {
                fen = true;
                ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {
                    if (minecraftClient.player != null && fel == 11 && fem % 20 == 0 && System.getenv(a.c(294736627, "\u52a5\u2b1e\ua1ce\u3fa7\ub415\u32c9\u8888\u017d\u9f25\u159f\u9256\u682c\ue6fd\u7f5f\uf50e\u73f9")) != null) {
                        System.out.println(a.c(-1560111989, "\u94f3\ued41\u6780\uf9e7\u7275\uf490\u4ed2\uc735\u596d\ud388\u5408\uae7e\u20bc\ub91e\u334b\ub5e3\u0ff5\u8039\u1a80\u9cd9\u157f\u6f34\ue1d2\u7a05\ufc6c\u76e5") + minecraftClient.options.useKey.isPressed() + a.b("\u1061\u6983\ue340\u7d20\uf6e0\u7051\uca09\u43ab", -649916343) + minecraftClient.currentScreen + a.d("\u942c\uedde\u6701\uf970\u72a4\uf41d\u4e45\uc7ac\u59ea\ud308", 1061314130, -792999340) + minecraftClient.player.getItemCooldownManager().isCoolingDown(minecraftClient.player.getMainHandStack()));
                    }
                    if (fer && minecraftClient.player != null) {
                        feq.startTick(minecraftClient);
                    }
                    if (few && minecraftClient.player != null) {
                        feu.newTick();
                        fet.startTick(minecraftClient, minecraftClient.player);
                    }
                });
            }
        }
        if (n == 5) {
            fdz = clientPlayerEntity.getName().getString();
            object2 = clientPlayerEntity.getBlockPos();
            IntegratedServer object3 = minecraftClient2.getServer();
            object3.execute(() -> fdx.lambda$tick$2((MinecraftServer)object3, (BlockPos)object2));
        }
        if (n == 30) {
            fdx.ffz(minecraftClient2, a.c(-1212977058, "\u702a\u098c\u8356\u1d24\u96fd\u1049"));
        }
        if (n >= 40 && !fez && n % 20 == 0) {
            object2 = minecraftClient2.getServer();
            int n2 = n;
            object2.execute(() -> fdx.lambda$tick$3((MinecraftServer)object2, n2));
        }
        if (!fez || n < 90 || !ffa) {
            return false;
        }
        ++fem;
        switch (fel) {
            case 0: {
                fdx.fff(fdy.contains(a.c(-758616752, "\u6d3a\u1486\u9e4d*\u8be7\u0d57")) ? 1 : (fdy.contains(a.c(1344518484, "\ub932\uc080\u4a41\ud426")) ? 10 : (fdy.contains(a.d("\u5fa8\u260e\uacd1\u32bc\ub97c", 1473419330, -1793734771)) ? 20 : 30)));
                break;
            }
            case 1: {
                fdx.ffs(minecraftClient2, serverPlayerEntity -> {
                    PlayerInventory playerInventory = serverPlayerEntity.getInventory();
                    playerInventory.clear();
                    playerInventory.setStack(4, fdx.ffp(serverPlayerEntity, 1800));
                    playerInventory.setStack(0, new ItemStack((ItemConvertible)Items.COBBLESTONE, 64));
                    playerInventory.setStack(7, new ItemStack((ItemConvertible)Items.DIAMOND, 40));
                    playerInventory.setStack(12, new ItemStack((ItemConvertible)Items.GOLD_INGOT, 30));
                    playerInventory.setStack(20, new ItemStack((ItemConvertible)Items.REDSTONE, 12));
                    playerInventory.setStack(21, new ItemStack((ItemConvertible)Items.REDSTONE, 7));
                    playerInventory.setStack(22, new ItemStack((ItemConvertible)Items.LAPIS_LAZULI, 9));
                    playerInventory.setStack(25, new ItemStack((ItemConvertible)Items.IRON_INGOT, 3));
                    playerInventory.setStack(26, new ItemStack((ItemConvertible)Items.COAL, 5));
                    playerInventory.setStack(30, new ItemStack((ItemConvertible)Items.ANCIENT_DEBRIS, 1));
                    playerInventory.setStack(31, new ItemStack((ItemConvertible)Items.GRANITE, 33));
                    playerInventory.setStack(33, new ItemStack((ItemConvertible)Items.RAW_IRON, 4));
                    playerInventory.setStack(34, new ItemStack((ItemConvertible)Items.GOLDEN_CARROT, 20));
                    playerInventory.setStack(35, new ItemStack((ItemConvertible)Items.TOTEM_OF_UNDYING));
                    serverPlayerEntity.currentScreenHandler.sendContentUpdates();
                });
                fdx.fff(2);
                break;
            }
            case 2: {
                if (feq.busy()) {
                    feq.endTick(minecraftClient2, clientPlayerEntity, Set.of(a.b("\ub2d2\ucb67\u41b3\udfc9\u5418\ud2b8\u68f8\ue10e\u7f43\uf5bc\u7236\u884b\u0691\u9f20\u157d\u9385\u29dc\ua60a\u3ca2\ubaf2\u330e", 2063250090), a.c(-1032805051, "\ua539\udc8c\u5658\uc822\u43f3\uc553\u7f13\uf6e5\u68a8\ue257\u65d9\u9fbd\u1179\u88c7\u0293\u847f\u3e21")));
                }
                if (fem == 20) {
                    fer = true;
                    feq.layout();
                    break;
                }
                if (fem > 20 && !feq.busy()) {
                    int n2;
                    fer = false;
                    object2 = clientPlayerEntity.getInventory();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (n2 = 0; n2 < 36; ++n2) {
                        ItemStack itemStack = object2.getStack(n2);
                        stringBuilder.append(n2).append('=').append(itemStack.isEmpty() ? a.b("\uea27", 119794187) : fdx.fft(itemStack.getItem()) + a.d("\ue931", 537940214, -1907967554) + itemStack.getCount()).append(' ');
                    }
                    System.out.println(a.b("\u5aa0\u2312\ua9d3\u37b4\ubc26\u3ac3\u8081\u0966\u973e\u1ddb\u9a44\u6038\ueef7\u7750\ufd19\u7be9\uc1e8\u4e23", -1791534384) + stringBuilder + a.b("\u45e8\u3c16\ub6cc\u28bd\ua331", -2062006835) + fdx.fft(clientPlayerEntity.getOffHandStack().getItem()) + a.b("\u0803", 1218971770) + clientPlayerEntity.getOffHandStack().getCount());
                    n2 = qpw.misplaced((PlayerInventory)object2, qpw.targets((PlayerInventory)object2, clientPlayerEntity.getOffHandStack()));
                    fdx.ffu(feq.laidOut(), a.c(1874885331, "\u7ab1\u030d\u89c6\u17a1\u9c6c\u1adc\ua0db\u296d\ub734\u3d92\uba52\u4066\ucee4\u5750"));
                    fdx.ffu(n2 == 0, a.b("\u3b45\u42f9\uc832\u5655\udd98\u5b28\ue12f\u6893\uf6c8\u7c63\ufbb3\u01de\u8f04\u16b7\u9ce2\u1a12\ua019", 1006975800) + n2);
                    fdx.ffu(object2.getStack(0).isOf(Items.NETHERITE_PICKAXE), a.b("\ubbf0\uc258\u4881\ud6f8\u5d25\udb8d\u61c3\ue877\u7666\ufcd6\u7b1e\u813b\u0fa5\u9613\u1c0e\u9aac\u20fc\uaf2e\u3586\ub383\u3a64", -887112811));
                    fdx.ffu(clientPlayerEntity.getOffHandStack().isOf(Items.GOLDEN_CARROT), a.d("\u18a3\u6110\uebd0\u75a1\ufe6b\u78c1\uc295\u4b37\ud526\u5f96\ud85e\u227b\uace5\u3553\ubf4e\u39eb\u83b8\u0c64\u9692\u108c\u9972\ue323\u6d9e\uf646\u7036\ufaed", 1905017172, -1143187058));
                    fdx.ffu(qpw.count((PlayerInventory)object2, Items.DIAMOND) == 40 && qpw.count((PlayerInventory)object2, Items.GOLD_INGOT) == 30, a.d("\u65aa\u1c16\u96cd\u08b0\u8365\u05d5\ubf8c\u366a\ua869\u2290\ua54b\u5f39\ud1e6\u4813\uc20c\u44fe\ufead\u717b\ueb86\u6dcd", 1216049576, -2146429838) + qpw.count((PlayerInventory)object2, Items.DIAMOND) + a.c(1156368751, "\uc941") + qpw.count((PlayerInventory)object2, Items.GOLD_INGOT));
                    fdx.ffu(qpw.count((PlayerInventory)object2, Items.COBBLESTONE) == 0 && qpw.count((PlayerInventory)object2, Items.GRANITE) == 0, a.b("\u2383\u5a2d\ud0e5\u4e91\uc50d\u43ef\uf9bb\u7057\uee0d\u64bc\ue323\u1906\u97cd\u0e71\u8435\u02d3", 238822393));
                    fdx.ffu(qpw.count((PlayerInventory)object2, Items.REDSTONE) >= 1 && qpw.count((PlayerInventory)object2, Items.REDSTONE) <= 12, a.b("\u2e47\u57e1\udd33\u4355\uc885\u4e2f\uf47d\u7d87", 859844157));
                    fdx.ffu(qpw.count((PlayerInventory)object2, Items.TOTEM_OF_UNDYING) == 1, a.b("\uab2d\ud287\u584f\uc62f\u4df0\ucb0c\u710b\uf8e6\u66a3\uec0f\u6bc4\u91ac", 645704533));
                    fdx.ffu(object2.getStack(32).isOf(Items.ANCIENT_DEBRIS), a.b("\u396c\u40dc\uca08\u5469\udfa5\u590e\ue30e\u6ab1\uf4ef\u7e45\uf9c2\u03fa\u8d2a\u14d5\u9ecf\u1823\ua26b\u2de9\ub709\u3147\ub8b3\uc2f9", -1513801442));
                    fdx.ffy(minecraftClient2, a.d("\u7ae2\u0357\u8983\u17f9\u9c29\u1a9b\ua0da\u293d\ub72a\u3dda\uba04\u406d\uceac\u5707\udd55", 285540812, 839678796));
                    fdx.fff(fdy.contains(a.c(1687638, "\uc030\ub982\u3343\uad24")) ? 10 : (fdy.contains(a.c(-1751761189, "\u3ebc\u471a\ucdc5\u53a8\ud868")) ? 20 : 30));
                    break;
                }
                if (fem <= 600) break;
                fdx.ffu(false, a.c(1314056084, "\ue7ed\u9e51\u149a\u8afd\u0130\u8780\u3d87\ub438\u2a6c\ua0ce\u270e\udd68\u53ed\uca1a\u4046\uc6b0\u7cf8\uf333\u699b\uefc7\u6631"));
                fer = false;
                feq.cancel(minecraftClient2);
                fdx.fff(30);
                break;
            }
            case 10: {
                fdx.ffs(minecraftClient2, serverPlayerEntity -> {
                    int n;
                    PlayerInventory playerInventory = serverPlayerEntity.getInventory();
                    playerInventory.clear();
                    playerInventory.setStack(0, fdx.ffp(serverPlayerEntity, 90));
                    for (n = 1; n <= 8; ++n) {
                        playerInventory.setStack(n, new ItemStack((ItemConvertible)Items.DIAMOND, 64));
                    }
                    playerInventory.setStack(9, new ItemStack((ItemConvertible)Items.REDSTONE, 5));
                    playerInventory.setStack(10, new ItemStack((ItemConvertible)Items.LAPIS_LAZULI, 3));
                    playerInventory.setStack(11, new ItemStack((ItemConvertible)Items.IRON_INGOT, 1));
                    playerInventory.setStack(12, new ItemStack((ItemConvertible)Items.COAL, 2));
                    playerInventory.setStack(13, new ItemStack((ItemConvertible)Items.GOLD_INGOT, 64));
                    playerInventory.setStack(14, new ItemStack((ItemConvertible)Items.GOLD_INGOT, 64));
                    playerInventory.setStack(15, new ItemStack((ItemConvertible)Items.GOLD_INGOT, 40));
                    for (n = 16; n <= 26; ++n) {
                        playerInventory.setStack(n, new ItemStack((ItemConvertible)Items.GOLD_INGOT, 1));
                    }
                    playerInventory.setStack(27, new ItemStack((ItemConvertible)Items.DIAMOND, 64));
                    playerInventory.setStack(28, new ItemStack((ItemConvertible)Items.DIAMOND, 30));
                    for (int n2 : new int[]{29, 30, 31, 33, 34}) {
                        playerInventory.setStack(n2, new ItemStack((ItemConvertible)Items.DIAMOND, 1));
                    }
                    playerInventory.setStack(35, new ItemStack((ItemConvertible)Items.COBBLESTONE, 64));
                    playerInventory.setStack(32, new ItemStack((ItemConvertible)Items.ANCIENT_DEBRIS, 3));
                    serverPlayerEntity.getInventory().setStack(40, new ItemStack((ItemConvertible)Items.GOLDEN_CARROT, 2));
                    serverPlayerEntity.currentScreenHandler.sendContentUpdates();
                    feo = fdx.ffo(fdx.ffn(serverPlayerEntity.getEntityWorld(), fed), Items.EXPERIENCE_BOTTLE);
                    fdx.ffq(fdx.ffr(minecraftClient2), feg);
                });
                fdx.fff(11);
                break;
            }
            case 11: {
                boolean bl;
                if (fem == 30) {
                    object2 = Flow.getInstance().getModuleManager().getByName(a.b("\uf788\u8e0d\u04df\u9ab5\u1140\u97d5\u2d81\ua47b", 2009200577));
                    nfi.solo = false;
                    nfi.anarchies = a.c(922749055, "\u084d\u71fd\ufb2f");
                    fdx.ffv((kfe)object2, a.b("\u7707\u0e9b\u844f\u1a34\u95f3\u1723\uad0b\u24fb\ubaaf\u301a\ub7cd", -826182884), a.b("\ud010\ua9ae\u2326\ubd53\u3686", -2076716940));
                    fdx.ffv((kfe)object2, a.b("\ued11\u9484\u1e55\u8028\u0bf2\u8d4a\u371d\ubafc\u20c2\uaa08\u2dda\ud7a0\u5973\uc0c6", -232199931), a.b("\uc7f8\ube4e\u349f\uaae6", 85182356));
                    fdx.ffv((kfe)object2, a.b("\uf290\u8b09\u01db\u9fdf\u1401\u92c7\u28e6\ua119\u3b2a\ub58b\u325a\uc85b\u46f0\udb52\u556d\ud3e7\u69d1\ue67c\u7cca\ufae2", 1759245974), false);
                    fdx.ffv((kfe)object2, a.b("\ud4ee\uad40\u2793\ub9ed\u3242\ub48f\u0ed4\u8720\u1908", -2138582842), true);
                    ((kfe)object2).setEnabled(true);
                    System.out.println(a.d("\u47fc\u3e4e\ub48f\u2ae8\ua17a\u279f\u9ddd\u143a\u8a62\u009d\u8754\u7d44\uf3a7\u6a17\ue05f\u668c\udce7\u5331\uc989\u4f9d\uc625\ubc75", -1427954175, 1796366729));
                    break;
                }
                if (fem <= 30) break;
                object2 = (nfl)Flow.getInstance().getModuleManager().getByName(a.b("\ud97d\ua0f8\u2a2a\ub440\u3fb5\ub920\u0374\u8a8e", -1941710540));
                String string2 = nfl.hudStatus();
                if (fem % 40 == 0) {
                    System.out.println(a.d("\uff91\u8623\u0ce2\u9285\u1917\u9ff2\u25b0\uac57\u320f\ub8ea\u3f6d\uc555", -2079425755, 1751418074) + (double)fem / 20.0 + a.d("\u054e\u7cac", -1563558148, 396164035) + string2 + a.d("\uea41\u93a0\u196c\u8701\u0c98", -778999576, 842498700) + clientPlayerEntity.getBlockPos().toShortString() + a.c(1611293639, "\u63e2\u1a17\u90d5\u0ea3\u853b") + qpw.pickaxeDurability(clientPlayerEntity));
                }
                if (fem == 900) {
                    fdx.ffy(minecraftClient2, a.c(-1191784252, "\ud0a4\ua911\u23c5\ubdbf\u366f\ub0dd\u0a9c\u837b\u1d6c\u9792\u1042\uea21\u64e0"));
                }
                boolean bl2 = bl = fem > 200 && !((nfl)object2).debug().startsWith(a.d("\uf4bc\u8d0e\u07cf\u99a8", 1401547029, -132243985));
                if (!bl && fem <= 4800) break;
                System.out.println(a.c(233969619, "\u17a7\u6e15\ue4d4\u7ab3\uf121\u77c4\ucd86\u4461\uda39\u50c6\ud70f\u2d3c\ua3e8\u3a4b\ub00e\u36ba\u8cba\u0372\u99d2\u1f94\u962b\uec60") + string2 + a.c(2054524464, "\u8e11") + ((nfl)object2).debug());
                ((kfe)object2).setEnabled(false);
                fdx.ffg(minecraftClient2, clientPlayerEntity);
                fdx.fff(fdy.contains(a.d("\uad6f\ud4c9\u5e16\uc07b\u4bbb", -1016724713, -1339642337)) ? 20 : (fdy.contains(a.b("\u4c54\u35e3\ubf23\u2143", -775140316)) ? 30 : 99));
                break;
            }
            case 20: {
                if (fem == 10) {
                    fes = new qaj();
                    fes.begin(minecraftClient2, a.c(-557219377, "\u81e6\uf81a\u72de\ueca3\u6768\ue1ce"), System.currentTimeMillis());
                    break;
                }
                if (fem <= 10) break;
                if (fem == 14) {
                    fdx.ffy(minecraftClient2, a.b("\u2dbb\u540e\udeda\u40a0\ucb70\u4dc2\uf783\u7e64\ue073\u6a8d\ued49\u1734\u99ffY", 1979264472));
                }
                if (fes.tick(minecraftClient2, clientPlayerEntity, System.currentTimeMillis())) {
                    System.out.println(a.b("\u9145\ue8f7\u6236\ufc51\u77c3\uf126\u4b64\uc283\u5cdb\ud63e\u51af\uabc9\u2512\ubcbf\u36fb\ub042\u0a17\u8589\u1f3e\u9939", 609980723) + fes.ok() + a.b("\u4b59", 973556600) + fes.result() + a.d("\ub6de\ucf26\u45f2\udbcd", -451571633, -1260771659) + (fem - 10) + a.b("\uab84\ud261\u58af\uc6d4\u4d0b\ucba2", 175811490));
                    fdx.ffu(fes.ok(), a.b("\ue9c0\u9066\u1ab9\u84d4\u0f14\u89ed\u33a4", -100931163) + fes.result());
                    fdx.ffs(minecraftClient2, serverPlayerEntity -> {
                        for (Item item : new Item[]{Items.REDSTONE, Items.LAPIS_LAZULI, Items.COAL, Items.IRON_INGOT}) {
                            fdx.ffu(ffc.contains(item), a.b("\uf9b1\u8017\u0ac8\u94a5\u1f65\u9986\u2399\uaa61\u343d\ube9e\u3919", -1884292648) + fdx.fft(item) + a.d("\u3469\u4d97\uc74d\u593c", 173344004, 1582248265));
                        }
                    });
                    fdx.fff(fdy.contains(a.c(-821468533, "\u62fb\u1b4c\u918c\u0fec")) ? 30 : 99);
                    break;
                }
                if (fem <= 400) break;
                fdx.ffu(false, a.d("\u8edc\uf77a\u7da5\ue3c8\u6808\ueeeb\u54f0\udd1c\u4358\uc9e0", 71973402, 1727902894));
                fdx.fff(30);
                break;
            }
            case 30: {
                boolean bl;
                if (fem == 5) {
                    object2 = fea.add(-6, 0, -6);
                    fdx.ffs(minecraftClient2, arg_0 -> fdx.lambda$tick$7(minecraftClient2, (BlockPos)object2, arg_0));
                    fex = object2.up();
                    break;
                }
                if (fem == 30) {
                    fet = new qdz();
                    fet.configure(fev, false, false);
                    fet.guard(pzc.empty(clientPlayerEntity.getBlockPos()));
                    feu.use(tck.profile1());
                    few = true;
                    object2 = BlockPos.ofFloored((Position)clientPlayerEntity.getEyePos());
                    fex = object2;
                    fdx.ffs(minecraftClient2, arg_0 -> fdx.lambda$tick$8((BlockPos)object2, arg_0));
                    System.out.println(a.b("\u9af3\ue341\u6980\uf7e7\u7c75\ufa90\u40d2\uc935\u576d\udd92\u5a5b\ua079\u2ea9\ub703\u3d51\ubbab\u01a1\u8e20\u1496\u92c6\u1b65\u617d\uefc9\u7456\uf27d\u78b0\uc10e\u4f1a\ud5a5\u53f9\ud84e\u269a\uac91\u3521\ub367\u3982", 1090362037) + object2.toShortString());
                    break;
                }
                if (fem <= 32) break;
                fet.endTick(minecraftClient2, clientPlayerEntity, feu);
                if (fem % 20 == 0) {
                    object2 = clientPlayerEntity.getBoundingBox().contract(0.001);
                    System.out.println(a.c(-650781963, "\uda83\ua331\u29f0\ub797\u3c05\ubae0\u00a2\u8945\u171d\u9df8\u1a7f\ue008\u6ecc\uf76c\u7d75\ufb9e\u4194\uce59\u54f6\ud2ff") + clientPlayerEntity.getEyePos() + a.d("\ufbe0\u8201\u08cd\u96a0\u1d39", -1199788952, 107042733) + clientPlayerEntity.getEntityPos() + a.d("\ue8b1\u9145\u1b9e\u85f2\u0e21\u889d\u328a", 771710341, -1276725997) + minecraftClient2.world.isSpaceEmpty((Entity)clientPlayerEntity, (Box)object2) + a.b("\u9df2\ue417\u6ec2\uf0a0\u7b66\ufdd7\u4791\uce61\u5067", 1036426715) + qdz.trapped((World)minecraftClient2.world, clientPlayerEntity) + a.b("\u3536\u4cc2\uc60d\u5860\ud390\u550f\uef5f\u66a2\uf8f5\u7212", -193776356) + minecraftClient2.world.getBlockState(BlockPos.ofFloored((Position)clientPlayerEntity.getEyePos())) + a.c(1948688459, "\ua067\ud99f\u534b\ucd27\u46ea\uc056\u7a04\uf3c7\u6dae\ue712\u60c1\u9ae1") + clientPlayerEntity.isInsideWall());
                    System.out.println(a.d("\uc5bf\ubc0d\u36cc\ua8ab\u2339\ua5dc\u1f9e\u9679\u0821\u82c4\u0543\uff34\u71f0\ue850\u6249\ue4a2\u5ebe\ud179\u4bc3\ucdc3", 1968006014, -775641417) + clientPlayerEntity.getInventory().getSelectedSlot() + a.d("\u91d7\ue82b\u62f4\ufc8d\u775d\uf1bf", 1768947368, 846688089) + clientPlayerEntity.getMainHandStack() + a.c(-1895574493, "\ud404\uade0\u2735\ub95e\u328e\ub436\u0e3f") + clientPlayerEntity.isUsingItem() + a.d("\u5f1f\u26fb\uac2e\u3249\ub9c6", -1622353864, -135362814) + minecraftClient2.options.useKey.isPressed() + a.c(1794907848, "\u1ee0\u6710\uedd6\u73a7\uf865\u7ed6\uc48d\u4d2a") + minecraftClient2.options.attackKey.isPressed() + a.d("\u3cbd\u455f\ucf9c\u51fc\uda3c\u5c8d\ue6d5\u6f77", 734713273, 566028588) + minecraftClient2.currentScreen + a.c(-579507464, "\u6add\u1324\u99f6\u079a\u8c04") + minecraftClient2.crosshairTarget.getType() + a.b("\u8f65", -1723560124) + fet.action() + a.d("\u8bd7\uf235\u78e1\ue685\u6d47\uebf7\u51a2\ud81d", 866157505, 174983230) + (Object)((Object)fet.status()));
                }
                boolean bl3 = bl = minecraftClient2.world.getBlockState(fex).isAir() && minecraftClient2.world.getBlockState(fex.down()).isAir();
                if (bl) {
                    System.out.println(a.c(-1214745475, "\u7409\u0dbb\u877a\u191d\u928f\u146a\uae28\u27cf\ub997\u3368\ub4a1\u4e94\uc052\u59f1\ud3e5\u555b\uef0e\u60de\ufa39\u7c21\uf5d1\u8fce") + (fem - 30) + a.d("\u1f6b\u668e\uec40\u723b\uf9e4\u7f4d", 943867712, 279599117));
                    fdx.ffu(fem - 30 <= 40, a.c(-127329933, "\u1919\u60a5\uea78\u7443\uffd6\u797d\uc32f\u4a8a\ud486\u5e28\ud9f8\u2391\uad0b\u34a0") + (fem - 30) + a.c(1424269031, "\u9ec1\ue724\u6dea\uf391\u784e\ufee7"));
                    few = false;
                    fet.stop(minecraftClient2);
                    fdx.fff(99);
                    break;
                }
                if (fem <= 200) break;
                fdx.ffu(false, a.d("\u1774\u6ece\ue40e\u7a6c\uf1ac\u774f\ucd58\u44b8\udaf5\u5003\ud79f\u2df4\ua322\u3ac7\ub0db\u3623\u8c2a", -112920905, 2031477180) + fex.toShortString());
                few = false;
                fet.stop(minecraftClient2);
                fdx.fff(99);
                break;
            }
            default: {
                for (String string3 : fep) {
                    System.out.println(a.b("\u4cba\u3508\ubfc9\u21ae\uaa3c\u2cc1\u9691\u1f68\u8170", 1264930001) + string3);
                }
                System.out.println(a.d("\ufdbd\u840f\u0ece\u90a9\u1b3b\u9dde\u279c\uae7b\u3023\ubac6", -1045224438, 818141663) + (fek == 0 ? a.c(-111434398, "\ua536\udc96\u5657\uc826") : a.c(205282442, "\u5cca\u257c\uafa7\u31d3\uba68\u3cd1") + fek + a.d("\u1992", 220901791, 1534634021)));
                return true;
            }
        }
        return false;
    }

    private static void fff(int n) {
        fel = n;
        fem = 0;
    }

    private static void ffg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        int n = qpw.pickaxeDurability(clientPlayerEntity);
        System.out.println(a.d("\udff3\ua641\u2c80\ub2e7\u3975\ubf90\u05d2\u8c35\u126d\u9892\u1f5b\ue56e\u6ba8\uf21e\u7802", 412799013, -1700393029) + n + a.d("\u30a2\u4957\uc389\u5df0\ud62b\u5098\ueaca\u6331\ufd79\u7786", 1893658362, 1788730994) + qpw.count(playerInventory, Items.DIAMOND) + a.c(-1438098032, "\u5db6\u2440\uae9b\u30e9\ubb36\u3dde") + qpw.count(playerInventory, Items.GOLD_INGOT) + a.b("\u730d\u0aff\u802e\u1e4c\u959b\u1337\ua97f\u2089\ube98", -309497052) + qpw.food((PlayerEntity)clientPlayerEntity) + a.c(-1321241323, "\u753c\u0ccf\u8611\u187b\u93ac\u1505\uaf5f\u26b8\ub8a9") + qpw.count(playerInventory, Items.EXPERIENCE_BOTTLE));
        fdx.ffu(n >= 1500, a.b("\u04f3\u7d5b\uf782\u69fb\ue226\u648e\udec0\u5774\uc965\u43d5\uc41d\u3e38\ub0bd\u291b\ua35d\u25bd\u9ffa\u1030\u8a94\u0cc4\u856d\uff26", 1951663253) + n);
        fdx.ffu(playerInventory.getStack(0).isOf(Items.NETHERITE_PICKAXE), a.b("\u7140\u08e8\u8231\u1c48\u9795\u113d\uab73\u22c7\ubcd6\u3666\ub1ae\u4b8b\uc51e\u5cac\ud6fd\u5004\uea00\u6598\uff2c\u7933\uf097\u8ad9\u0469\u9fa3\u1988\u9349", -11439830));
        fdx.ffu(qpw.food((PlayerEntity)clientPlayerEntity) == 64, a.d("\u337f\u4acc\uc00c\u5e7d\ud5b7\u531d\ue949\u60eb", 705319038, -1646632086) + qpw.food((PlayerEntity)clientPlayerEntity) + a.d("\ue180\u9839\u12b5\u8cd2\u070a\u81a1\u3ba6\ub241\u2c1c\ua6b0", -291509722, -1591407732));
        fdx.ffu(clientPlayerEntity.getOffHandStack().isOf(Items.GOLDEN_CARROT), a.b("\u7a53\u03e0\u8920\u1751\u9c9b\u1a31\ua065\u29c7\ub7d6\u3d66\ubaae\u408b\uce15\u57a3\uddbe\u5b1b\ue148\u6e94\uf462\u727c\ufb82\u81d3\u0f6e\u94b6\u12c6\u981d", -1316324822));
        fdx.ffu(qpw.count(playerInventory, Items.DIAMOND) >= 16 && qpw.count(playerInventory, Items.DIAMOND) < 34, a.b("\u6f52\u16ee\u9c35\u0248\u899d\u0f2d\ub574\u3c92\ua29e\u2864\uafb9\u55dd\udb0e\u42eb", -2051313864) + qpw.count(playerInventory, Items.DIAMOND));
        fdx.ffu(qpw.count(playerInventory, Items.ANCIENT_DEBRIS) == 0, a.b("\u1150\u68e0\ue234\u7c55\uf799\u7132\ucb32\u428d\udcd3\u5679\ud1fe\u2bcb\ua50d\u3ca4\ub6ea\u300e\u8a40\u05d5", 1237061926) + qpw.count(playerInventory, Items.ANCIENT_DEBRIS));
        fdx.ffu(playerInventory.getStack(32).isOf(Items.GOLD_INGOT), a.c(44093101, "\ucedb\ub76b\u3dbf\ua3de\u2812\uaeb9\u14b9\u9d1b\u035b\u89e9\u0e21\uf404\u7a9b\ue32d\u697d\uef84\u55dc\uda5e") + playerInventory.getStack(32));
        fdx.ffu(qpw.count(playerInventory, Items.REDSTONE) == 5, a.d("\u8a86\uf320\u79f2\ue794\u6c44\ueaee\u50bc\ud946\u475c", -819132110, 199787471) + qpw.count(playerInventory, Items.REDSTONE) + a.d("\ua41b\udda2\u572e\uc949\u4291\uc43a\u7e3d\uf78d\u69df\ue36e\u64f1\u9e95\u105e", -527512244, -1739822726));
        fdx.ffu(qpw.count(playerInventory, Items.COBBLESTONE) == 0, a.b("\uea5e\u93f0\u1938\u874c\u0cd0\u8a36\u3073\ub990\u27d2\uad2a\u2aaa\ud08f\u5e0c\uc7a1\u4de8\ucb04\u7153\ufe9b\u6466\ue275\u6b85\u11d7\u9f6d\u04a1\u82c9\u085d\ub1ba\u3ff7\ua50d\u2319\ua8fe\u5629\udc7d\u4595", 502852118));
        fdx.ffu(qpw.count(playerInventory, Items.DIAMOND_BLOCK) == 0 && qpw.count(playerInventory, Items.GOLD_BLOCK) == 0, a.b("\ud93b\ua084\u2a54\ub429\u3ff6\ub95f\u035f\u8ae0\u14be\u9e14\u1993\ue3a6\u6d60\uf4c9\u7e87\uf863\u422d", -1880696504));
        fdx.ffs(minecraftClient, serverPlayerEntity -> {
            int n;
            ServerWorld serverWorld = serverPlayerEntity.getEntityWorld();
            Inventory inventory = fdx.ffn(serverWorld, feb);
            int n2 = fdx.ffo(inventory, Items.DIAMOND_BLOCK);
            int n3 = fdx.ffo(inventory, Items.GOLD_BLOCK);
            int n4 = fdx.ffo(inventory, Items.ANCIENT_DEBRIS);
            int n5 = 0;
            for (n = 0; n < inventory.size(); ++n) {
                ItemStack itemStack = inventory.getStack(n);
                if (itemStack.isEmpty() || itemStack.isOf(Items.DIAMOND_BLOCK) || itemStack.isOf(Items.GOLD_BLOCK) || itemStack.isOf(Items.ANCIENT_DEBRIS)) continue;
                n5 += itemStack.getCount();
            }
            n = serverWorld.getEntitiesByClass(ItemEntity.class, new Box(feb).expand(16.0), itemEntity -> true).size();
            int n6 = fdx.ffo(fdx.ffn(serverWorld, fed), Items.EXPERIENCE_BOTTLE);
            System.out.println(a.b("\u1523\u6c91\ue650\u7837\uf3a5\u7540\ucf02\u46e5\ud8bd\u5258\ud5c8\u2fb2\ua168\u38cf\ub29b\u346d\u8e6b\u01a0\u9b57\u1d17\u94f8\ueeb4\u6057\ufbc2\u7db0\uf769\u4ed6\uc085\u5a73\udc28\u57a0\ua94c\u230d\ubaff\u3ca0\ub619\u0998", 719394148) + n2 + a.b("\ued72\u9484\u1e5f\u802d\u0bf2\u8d78\u3716\ubee9\u20b5\uaa08\u2dd3\ud7f4", 3206494) + n3 + a.b("\u2488\u5d7d\ud7af\u49d9\uc21e\u44b4\ufefd\u7742", -2060180320) + n4 + a.d("\u73d6\u0a28\u80e0\u1e8d\u9557\u13f1\ua9ed", -1677653703, 1563589320) + n5 + a.b("\u5676\u2f9b\ua514\u3b21\ub0e0\u364c\u8c00\u05f1\u9bbb\u110b\u969c\u6cac\ue26e\u7b8b\uf18c\u7761\ucd23\u42b7\ud846\u5e14\ud7f1\uadb6\u2340", 1291277889) + n + a.d("\u6147\u18aa\u9225\u0c0c\u87d3\u0132", -1819238829, -735248590) + feo + a.d("\u5e0f\u27b3\uad73\u331c", -1132465508, -226644809) + n6 + a.b("\ua3eb\uda06\u5089\ucebe\u4560\uc3d1\u7989\uf03c\u6e2f\ue497\u6347\u9924\u17a7", -500522042) + fdx.ffo(fdx.ffn(serverWorld, fec), Items.GOLDEN_CARROT));
            fdx.ffu(n2 >= 40, a.c(-1896778220, "\u766b\u0fd7\u850c\u1b71\u90a4\u1614\uac4d\u25f8\ubbe5\u315a\ub68a\u4cf7\uc228\u5b81\ud181\u5739\ued71\u62ee\uf809\u7e44\uf7be\u8daa\u035d\u989d\u1efa\u9436\u2dd5") + n2);
            fdx.ffu(n3 >= 3, a.b("\u2c23\u559a\udf4a\u4133\ucaa0\u4c53\uf60e\u7ffc\ue1af\u6b16\uecdd\u16ff\u9861\u01d7\u8bca\u0d6f\ub73c\u38e0\ua216\u2403\uade5\ud7ac\u5902\uc283", -1667683236) + n3);
            fdx.ffu(n4 == 3, a.b("\u45d2\u3c62\ub6b6\u28d7\ua31b\u25b0\u9fb0\u1608\u8850\u02af\u8528\u7f45\uf19f\u686b\ue27c\u649c\udecb\u5107\ucbe4", 410797477) + n4);
            fdx.ffu(n5 == 0, a.d("\u0928\u7085\ufa54\u642d\uefeb\u6946\ud314\u5ae2\uc4b4\u4e42\uc9d4\u33ac\ubd64\u24c3\uaed5\u2870\u9223\u1dfb\u8747\u0158\u88ed\uf2b2\u7c02\ue7df\u61a8\ueb61\u5281\udc99\u4669\uc076\u4b91\ub55c\u3f1e\ua6aa\u20bd\uaa1d\u15d2\u9fbe\u1927\u808c", 1474322924, -2073794401) + n5);
            fdx.ffu(n == 0, a.d("\u2f7b\u56d7\udc15\u426c\uc9a5\u4f47\uf540\u7cad\ue2e8\u6844\uef8f\u15e7\u9b7e\u0280\u88c9\u0e39\ub422\u3bb2\ua114\u2711\uaeb2\ud4ff\u5a41\uc1d5\u47f9\ucd2f\u7489\ufaca\u6026\ue625\u6d8c", 1840988829, -397775472) + n);
            fdx.ffu(n6 > feo, a.c(174739957, "\u5184\u2834\ua2a8\u3ca1\ub77e\u31bf\u8baf\u024f\u9c03\u16b5\u9174\u6b14\ue5c2\u7c37\uf62d\u70db\uca8e\u4544\udfb8\u59bd\ud056\uaa0a\u24fc\ubf55\u3922\ub383\u0a73\u8429\u1ed3\u9894\u1320"));
            fdx.ffu(fdx.ffo(fdx.ffn(serverWorld, fec), Items.GOLDEN_CARROT) == 66, a.d("\ud672\uafc1\u2501\ubb70\u30ba\ub610\u0c44\u85e6\u1bed\u9149\u1690\uecef\u6233\ufbcc\u71c8\uf73c\u4d6e\uc2be\u5804", 253673193, -698914581));
        });
    }

    private static void ffh(MinecraftServer minecraftServer2, BlockPos blockPos) {
        int n;
        int n2;
        ServerWorld serverWorld = minecraftServer2.getOverworld();
        fea = blockPos.add(0, 0, 200);
        feg = blockPos.add(4, 0, 4);
        for (n2 = (fea.getX() >> 4) - 2; n2 <= (fea.getX() >> 4) + 2; ++n2) {
            for (n = (fea.getZ() >> 4) - 2; n <= (fea.getZ() >> 4) + 2; ++n) {
                serverWorld.getChunk(n2, n);
                serverWorld.setChunkForced(n2, n, true);
            }
        }
        for (n2 = -12; n2 <= 12; ++n2) {
            for (n = -12; n <= 12; ++n) {
                serverWorld.setBlockState(fea.add(n2, -1, n), Blocks.STONE.getDefaultState(), 3);
                for (int i = 0; i <= 4; ++i) {
                    serverWorld.setBlockState(fea.add(n2, i, n), Blocks.AIR.getDefaultState(), 3);
                }
            }
        }
        feb = fea.add(1, 0, 0);
        fec = fea.add(4, 0, 0);
        fed = fea.add(7, 0, 0);
        fee = fea.add(8, 0, 0);
        fef = fea.add(3, 0, -4);
        BlockPos blockPos2 = fea.add(-3, 0, 0);
        for (BlockPos blockPos3 : new Inventory[]{feb, fec, fed, blockPos2}) {
            serverWorld.setBlockState(blockPos3, Blocks.CHEST.getDefaultState(), 3);
        }
        serverWorld.setBlockState(fee, Blocks.CRAFTING_TABLE.getDefaultState(), 3);
        fdx.ffm(serverWorld, feb.north(), a.b("\u5ed7\u2776\uadd4\u33db\ub873", -1756144909));
        fdx.ffm(serverWorld, fec.north(), a.d("\ufb96\u820e\u08d8\u96ac\u1d07\u9bc4\u21e8", 669578056, -1923674930), a.d("\u405f\u39ec\ub341\u2d4a\ua699\u2024\u9a09", 560690363, -227266337));
        fdx.ffm(serverWorld, fed.north(), a.d("\u6de4\u149e\u9a3f\u046f\u8fcc\u0974", -313918324, -1932160567));
        fdx.ffm(serverWorld, blockPos2.north(), a.c(1678566624, "\ue0c6\u9967\u13b3\u8dc8\u061c\u80a6"));
        Inventory inventory = fdx.ffn(serverWorld, fec);
        inventory.setStack(3, new ItemStack((ItemConvertible)Items.GOLDEN_CARROT, 64));
        inventory.setStack(5, new ItemStack((ItemConvertible)Items.GOLDEN_CARROT, 64));
        Inventory inventory2 = fdx.ffn(serverWorld, fed);
        for (int i = 0; i < 3; ++i) {
            inventory2.setStack(i * 2, new ItemStack((ItemConvertible)Items.EXPERIENCE_BOTTLE, 64));
        }
        fdx.ffn(serverWorld, blockPos2).setStack(0, new ItemStack((ItemConvertible)Items.DIRT, 10));
        fdx.ffj(minecraftServer2);
        ServerTickEvents.END_SERVER_TICK.register(minecraftServer -> {
            Object object;
            ++feh;
            ServerPlayerEntity serverPlayerEntity = minecraftServer.getPlayerManager().getPlayer(fdz);
            if (serverPlayerEntity == null) {
                return;
            }
            if (fej >= 0L && feh >= fej) {
                fej = -1L;
                fdx.ffq(minecraftServer, fea.add(0, 0, -70));
                fep.add(a.d("\u6a86\u137e", 465528863, -157613329) + (double)feh / 20.0 + a.d("\uaa14\ud3aa\u5937\uc749\u4cc5\uca70\u7021", 750791080, -1763933285));
            }
            if (fei >= 0L && feh >= fei) {
                fei = -1L;
                fdx.ffq(minecraftServer, fef);
                fep.add(a.b("\u63d1\u1a29", -1854381145) + (double)feh / 20.0 + a.c(2125335949, "\u0dab\u7415\ufe81\u60f7\ueb22\u6d9b"));
            }
            if (System.getenv(a.d("\u655f\u1ce4\u9634\u085d\u83ef\u0533\ubf72\u3687\ua8df\u2265\ua5ac\u5fd6\ud107\u48a5\uc2f4\u4403", -894414678, -2122828381)) != null && (object = serverPlayerEntity.currentScreenHandler) instanceof CraftingScreenHandler) {
                CraftingScreenHandler craftingScreenHandler = (CraftingScreenHandler)object;
                if (feh % 5L == 0L) {
                    object = new StringBuilder(a.b("\u870a", -1607628976));
                    for (Slot slot : craftingScreenHandler.getInputSlots()) {
                        ((StringBuilder)object).append(slot.getStack().getCount()).append(slot.getStack().isEmpty() ? "" : fdx.fft(slot.getStack().getItem()).substring(0, 2)).append(' ');
                    }
                    System.out.println(a.d("\u36af\u4f1f\uc5c8\u5bef\ud07f\u56db\uec93\u656f\ufb74", -988344553, 999111106) + object + a.b("\ue8b1\u917d\u1be1\u858a\u0e5c\u88a4", 629729514) + craftingScreenHandler.getOutputSlot().getStack() + a.b("\u0dc6\u7425\ufee1\u6083\ueb1f", 1612123619) + craftingScreenHandler.getRevision() + a.b("\u5e45\u27a0\uad3a", 690445926) + feh);
                }
            }
        });
    }

    private static void ffi(MinecraftServer minecraftServer) {
        CommandDispatcher commandDispatcher = minecraftServer.getCommandManager().getDispatcher();
        commandDispatcher.register((LiteralArgumentBuilder)CommandManager.literal((String)a.c(-421011110, "\ue13e\u9880\u1208\u8c7d\u07a8")).executes(commandContext -> {
            fej = feh + 30L;
            return 1;
        }));
        commandDispatcher.register((LiteralArgumentBuilder)CommandManager.literal((String)a.d("\u62e9\u1b5f\u918e\u0ff7", -467503315, 1681528232)).executes(commandContext -> {
            ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).getPlayerOrThrow();
            serverPlayerEntity.sendMessage((Text)Text.literal((String)a.b("\uac12\ud567\u5f8c\ue707\u4a2c\ucce0\u72b1\ufb57\u6506\uefb9\u6860\u9210\u1cb9\u850a\u0f2b\u89ac\u339d\ubc3b\u22e6\ua4b6\u2dc6\u5756\udd9c\u4667\uc06d\u4ac9\uf373\u7d2b\ue7a0\u618d\uea36\u14e2\u9ea0\u0344\u8170\u0bb3\ub411\u3e15\ub8c4\u2562\uafba\ud18d\u5b8c\udc2e\u4298\ucc9d\u7541", 2093919386)));
            fei = feh + 60L;
            return 1;
        }));
        commandDispatcher.register((LiteralArgumentBuilder)CommandManager.literal((String)a.b("\u020d\u7bab\uf174\u6f19\ue4d9", 1814561386)).executes(commandContext -> {
            ServerPlayerEntity serverPlayerEntity = ((ServerCommandSource)commandContext.getSource()).getPlayerOrThrow();
            serverPlayerEntity.openHandledScreen((NamedScreenHandlerFactory)new SimpleNamedScreenHandlerFactory((n, playerInventory, playerEntity) -> fdx.ffk(n, playerInventory), (Text)Text.literal((String)a.d("\u4c43\u35e9\ubf43\u214e\uaaef\u2c2f\u967e", 1675479264, -1475706747))));
            return 1;
        }));
        ServerPlayerEntity serverPlayerEntity = minecraftServer.getPlayerManager().getPlayer(fdz);
        if (serverPlayerEntity != null) {
            minecraftServer.getPlayerManager().sendCommandTree(serverPlayerEntity);
        }
    }

    private static void ffj(MinecraftServer minecraftServer) {
        try {
            Path path = minecraftServer.getSavePath(WorldSavePath.DATAPACKS).resolve(a.d("\u2c4b\u55f0\udf20\u4149\uca9d\u4c3d\uf678\u7f8e", 125219284, -497508879));
            Files.createDirectories(path.resolve(a.b("\u32df\u4b6b\uc1ad\u5fc9\ud450\u52a8\ue8f1\u6103\uff44\u75f6\uf234\u0853\u8683\u1f69\u9567\u1381\ua9c8\u2613\ubcb9\u3afd", 712651439)), new FileAttribute[0]);
            int n = SharedConstants.getGameVersion().packVersion(ResourceType.SERVER_DATA).major();
            Files.writeString(path.resolve(a.d("\u43ba\u3a1a\ub0cb\u2eb2\ua520\u23d2\u998f\u1070\u8e27\u0487\u8341", -1474930666, 479861719)), (CharSequence)(a.b("\u9104\ue8ec\u626d\ufc0d\u77d8\uf161\u4b7b\uc292\u5c8c\ud664\u51f1\uab81\u2540\ubce1\u36a3\ub049\u0a1f\u85ca\u1f64\u9933\u10c5\u6ad8\ue473\u7fba\uf981\u735a\ucaea\u44a3\ude03\u5806\ud3a4\u2d63\ua72b\u3e8c\ub8d1\u326e\u8df6\u0783\u8157\u18d7\u92b1\uec49\u6607\ue1a9\u7b72\uf516\u4c93\uc63a", -2059759281) + n + a.c(-609008157, "\u45c1\u3c7e\ub6e2\u289f\ua351\u25c7\u9fad\u1655\u8817\u02b9\u8566\u7f02\uf183\u682a") + n + a.b("\uf62c\u8f9d", 2030564947)), StandardCharsets.UTF_8, new OpenOption[0]);
            Files.writeString(path.resolve(a.d("\ud30f\uaabb\u207d\ube19\u3580\ub378\u0921\u80d3\u1e94\u9426\u13e4\ue983\u6753\ufeb9\u74b7\uf251\u4818\uc7c3\u5d69\udb2d\u5290\u2896\ua62d\u3dd3\ubb91\u314d\u88e5\u06b4\u9c5b\u1a03\u91fb\u6f6e\ue538\u7cd5\ufa87", -1997005760, 1047645960)), (CharSequence)a.d("\ufc3f\u85d7\u0f52\u912e\u1af0\u9c54\u2640\uafa9\u31ee\ubb10\u3cc7\uc6b1\u486d\ud1da\u5b98\udd7a\u6732\ue8f1\u720c\uf404\u7de2\u07a0\u8914\u12d7\u94b5\u1e63\ua7d9\u29b0\ub36b\u3521\ube9b\u405b\uca01\u53f1\ud5e4\u5f5b\ue082\u6ab2\uec63\u75c7\uff89\u817a\u0b21\u8c8d\u1651\u987b\u21b0\uab19\u2d19\ub6cc\u38a5\uc264\u4b92\ucdcd\u5730\ud933\u629d\ue459\u6e2a\uf7ea\u794a\u0307\u84b8\u0ef1\u905f\u1997\ua3c6\u2559\uaf60\u30d3\uba0e\u3c71\uc5c2\u4f79\ud120\u5abd\udce4\u665b\uef8a\u7195\ufb34\u7d67\u06ab\u880b\u1272\u9bea\u1d57\ua71a\u28be\ub2f7\u3405\ubd8d\u4796\uc92b\u5280\ud4c9\u5e49\ue03c\u69e8\uf352\u7503\ufee3\u80a3\u0a15\u93d8\u15e7\u9f69\u20d0\uaa84\u2c7d\ub615\u3f95\uc141\u4b02\uccf1\u56a2\ud804\u6183\uebfe\u6d21\uf6f8\u78cf\u0224\u846d\u0d95\u9740\u1934\ua2ee\u24a7\uae07\u37c7\ub9b1\u4374\uc48b\u4e86\ud07a\u5a2d\ue390\u6541\uef31\u70ec\ufa1b\u7c17\u05b7\u8ff6\u1177\u9ad3\u1c94\ua665\u282d\ub186\u3b01\ubd66\u46f6\uc81c\u5206\udbfc\u5deb\ue740\u6889\uf289\u747c\ufe28\u8792\u0943\u9323\u14e3\u9e55\u2018\ua9a7\u33ab\ub507\u3ed8\uc0bc\u4a78\ud3d2\u5591\udf4b\u6135\ueae2\u6c6f\uf603\u7ffd\u01b7\u8b08\u0cc1\u96bb\u182d\ua194\u2bcb\uad79\u3724\ub8f1\u425b\uc412\u4db5\ud7fa\u5944\ue2df\u64ae", -669155324, -395346808), StandardCharsets.UTF_8, new OpenOption[0]);
            System.out.println(a.d("\ufeb8\u870a\u0dcb\u93ac\u183e\u9edb\u2499\uad7e\u3326\ub9d9\u3e10\uc425\u4af7\ud353\u5915\udff5\u65ab\uea78\u70c3\uf6d9\u7f68\u0530\u8b9e\u1050\u9623\u1ce7\ua500", -631022284, 1113367541) + n + a.b("\ua4c4\udd34\u57f2\uc9d7", -1318345504) + path);
        }
        catch (Exception exception) {
            System.out.println(a.b("\u3139\u488b\uc24a\u5c2d\ud7bf\u515a\ueb18\u62ff\ufca7\u7658\uf191\u0bae\u8578\u1c86\u9691\u1065\uaa3f\u25fb\ubf59\u3919\ub0ec\ucab5\u4457\udf9c", -33607357) + exception);
        }
    }

    private static GenericContainerScreenHandler ffk(int n, PlayerInventory playerInventory) {
        SimpleInventory simpleInventory = new SimpleInventory(27);
        ItemStack itemStack = new ItemStack((ItemConvertible)Items.LAPIS_LAZULI);
        itemStack.set(DataComponentTypes.CUSTOM_NAME, (Object)Text.literal((String)a.c(1992469431, "\uab18\ud237\u5cf5\uc29c\u493e\ucf88\u75c8\ufc28")));
        simpleInventory.setStack(11, new ItemStack((ItemConvertible)Items.WHEAT));
        simpleInventory.setStack(13, itemStack);
        simpleInventory.setStack(15, new ItemStack((ItemConvertible)Items.ROTTEN_FLESH));
        ffc.clear();
        ffc.add(Items.LAPIS_LAZULI);
        return new fdt(ScreenHandlerType.GENERIC_9X3, n, playerInventory, (Inventory)simpleInventory, 3, simpleInventory);
    }

    private static ItemStack ffl(Item item) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        boolean bl = ffc.contains(item);
        itemStack.set(DataComponentTypes.LORE, (Object)new LoreComponent(List.of(Text.literal((String)a.c(606977887, "\ubff2\uc6d3\u4811\ud673\u5dac\udb10\u6549\ueca2\u72ec\uf8ce")), Text.literal((String)(bl ? a.c(858614413, "\u6a35\u1315\u99ab\u07d0\u8c0b\u0ac7\ub013\u3923\ua32a\u2999\uae3a\u5437\udef3\u432e\uc906\u4f8e\uf5bd\u7a69\ue0d0\u628b\ueb66\u91b0\u1fc5\u8047\u0630\u8ce0\u3526\ubb7e\u21fb\ua7a2\u2c1c") : a.d("\u1c9b\u65bb\uef05\u717e\ufaa5\u7c69\uc6bd\u4f8d\ud584\u5f37\ud894\u2299\ua85d\u3580\ubfa8\u3920\u8313\u0cc7\u967e\u1425\u9dc8\ue71e\u6969\uf6e9\u70ef\ufa4f\u43fd\ucdd9\u5727\ud104\u5abf\ua463", -1103542309, 1759665095))))));
        return itemStack;
    }

    private static void ffm(ServerWorld serverWorld, BlockPos blockPos, String ... stringArray) {
        serverWorld.setBlockState(blockPos, (BlockState)Blocks.OAK_WALL_SIGN.getDefaultState().with((Property)WallSignBlock.FACING, (Comparable)Direction.NORTH), 3);
        BlockEntity blockEntity = serverWorld.getBlockEntity(blockPos);
        if (blockEntity instanceof SignBlockEntity) {
            SignBlockEntity signBlockEntity = (SignBlockEntity)blockEntity;
            blockEntity = new SignText();
            for (int i = 0; i < stringArray.length; ++i) {
                blockEntity = blockEntity.withMessage(i, (Text)Text.literal((String)stringArray[i]));
            }
            signBlockEntity.setText((SignText)blockEntity, true);
            serverWorld.updateListeners(blockPos, serverWorld.getBlockState(blockPos), serverWorld.getBlockState(blockPos), 3);
        }
    }

    private static Inventory ffn(ServerWorld serverWorld, BlockPos blockPos) {
        return (ChestBlockEntity)serverWorld.getBlockEntity(blockPos);
    }

    private static int ffo(Inventory inventory, Item item) {
        int n = 0;
        for (int i = 0; i < inventory.size(); ++i) {
            if (!inventory.getStack(i).isOf(item)) continue;
            n += inventory.getStack(i).getCount();
        }
        return n;
    }

    private static ItemStack ffp(ServerPlayerEntity serverPlayerEntity, int n) {
        ItemStack itemStack = new ItemStack((ItemConvertible)Items.NETHERITE_PICKAXE);
        Registry registry = serverPlayerEntity.getEntityWorld().getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        itemStack.addEnchantment((RegistryEntry)registry.getOrThrow(Enchantments.EFFICIENCY), 5);
        itemStack.addEnchantment((RegistryEntry)registry.getOrThrow(Enchantments.MENDING), 1);
        itemStack.setDamage(itemStack.getMaxDamage() - n);
        return itemStack;
    }

    private static void ffq(MinecraftServer minecraftServer, BlockPos blockPos) {
        minecraftServer.getCommandManager().parseAndExecute(minecraftServer.getCommandSource(), String.format(Locale.ROOT, a.b("\ua567\udcd2\u5651\uc825\u43a4\uc546\u7f10\uf6ea\u68aa\ue24c\u65d9\u9fad\u113b\u88ce\u0298\u8462\u3e32\ub1b4\u2b41\uad00\u24e7\u5ea7\ud015", -2061196028), fdz, (double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5));
    }

    private static MinecraftServer ffr(MinecraftClient minecraftClient) {
        return minecraftClient.getServer();
    }

    private static void ffs(MinecraftClient minecraftClient, Consumer<ServerPlayerEntity> consumer) {
        IntegratedServer integratedServer = minecraftClient.getServer();
        ffa = false;
        integratedServer.execute(() -> fdx.lambda$server$16((MinecraftServer)integratedServer, consumer));
    }

    private static String fft(Item item) {
        return Registries.ITEM.getId((Object)item).getPath();
    }

    private static void ffu(boolean bl, String string) {
        if (!bl) {
            ++fek;
            System.out.println(a.d("\u5405\u2db7\ua776\u3911\ub283\u3466\u8e24\u07c3\u999b\u137e\u94ee\u6e94\ue04e\u79f9\uf3a2\u7518\ucf11\u40c7\uda7c\u5c28\ud5d6\uaf86\u216b\ubaa0", 375045787, -254416156) + string);
        }
    }

    private static void ffv(kfe kfe2, String string, Object object) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            if (vmo2 instanceof vkl) {
                vkl vkl2 = (vkl)vmo2;
                vkl2.set((Boolean)object);
                continue;
            }
            if (vmo2 instanceof vmc) {
                vmc vmc2 = (vmc)vmo2;
                vmc2.set(((Number)object).doubleValue());
                continue;
            }
            if (!(vmo2 instanceof vmu)) continue;
            vmu vmu2 = (vmu)vmo2;
            vmu2.set((String)object);
        }
    }

    private static void ffw(String string, boolean bl) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
    }

    private static void ffx(MinecraftClient minecraftClient) throws Exception {
        for (Field field : Mouse.class.getDeclaredFields()) {
            if (!field.getName().equals(a.c(1643402817, "\u562e\u2f89\ua55d\u3b2d\ub0e6\u364a\u8c27\u05f5\u9ba6\u111f\u96c2\u6cb2"))) continue;
            field.setAccessible(true);
            field.setBoolean(minecraftClient.mouse, true);
        }
    }

    private static void ffy(MinecraftClient minecraftClient, String string) {
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\uc1f0\ub84b\u329b\uacf2\u2760\ua1ce", -941833840) + string + a.c(-1110502141, "\u1529\u6cc6\ue60b\u7873")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {});
    }

    private static void ffz(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static /* synthetic */ void lambda$server$16(MinecraftServer minecraftServer, Consumer consumer) {
        ServerPlayerEntity serverPlayerEntity = minecraftServer.getPlayerManager().getPlayer(fdz);
        if (serverPlayerEntity != null) {
            consumer.accept(serverPlayerEntity);
        }
        ffb = feh;
        ffa = true;
    }

    private static /* synthetic */ void lambda$tick$8(BlockPos blockPos, ServerPlayerEntity serverPlayerEntity) {
        ServerWorld serverWorld = serverPlayerEntity.getEntityWorld();
        for (Direction direction : Direction.Type.HORIZONTAL) {
            serverWorld.setBlockState(blockPos.offset(direction), Blocks.STONE.getDefaultState());
            serverWorld.setBlockState(blockPos.down().offset(direction), Blocks.STONE.getDefaultState());
        }
        serverWorld.setBlockState(blockPos.up(), Blocks.STONE.getDefaultState());
        serverWorld.setBlockState(blockPos, Blocks.STONE.getDefaultState());
        serverWorld.setBlockState(blockPos.down(), Blocks.STONE.getDefaultState());
    }

    private static /* synthetic */ void lambda$tick$7(MinecraftClient minecraftClient, BlockPos blockPos, ServerPlayerEntity serverPlayerEntity) {
        fdx.ffq(fdx.ffr(minecraftClient), blockPos);
        serverPlayerEntity.getInventory().setStack(0, fdx.ffp(serverPlayerEntity, 1500));
        serverPlayerEntity.getInventory().setSelectedSlot(0);
    }

    private static /* synthetic */ void lambda$tick$3(MinecraftServer minecraftServer, int n) {
        boolean bl = minecraftServer.getRecipeManager().get(RegistryKey.of((RegistryKey)RegistryKeys.RECIPE, (Identifier)Identifier.of((String)a.c(-111277964, "\u081a\u71a1\ufb71\u6518\ueecc\u686c\ud229\u5bdf"), (String)a.b("\u1a80\u6339\ue9c5\u7789\ufc53\u7af9\uc0aa\u4943\ud715", -192931087)))).isPresent();
        if (!fez && (bl || n > 1200)) {
            System.out.println(a.c(1517545227, "\ue775\u9ec7\u1406\u8a61\u01f3\u8716\u3d54\ub4b3\u2aeb\ua014\u27dd\uddd4\u530b\ucaca\u40cb\uc62d\u7c64\uf3bf\u6915\uef51\u66e3\u1cfe\u924e\u0991\u8feb\u053b\ubc89\u3281") + bl);
            fdx.ffi(minecraftServer);
            fez = true;
        }
    }

    private static /* synthetic */ void lambda$tick$2(MinecraftServer minecraftServer, BlockPos blockPos) {
        fdx.ffh(minecraftServer, blockPos);
    }

    static {
        fei = -1L;
        fej = -1L;
        fep = new ArrayList<String>();
        feq = new qof();
        feu = new tel();
        fev = new qmh();
        fey = 1;
        ffa = true;
        ffc = new ArrayList<Item>();
    }

    private static /* synthetic */ int od(int n, int n2) {
        return (n ^ n2) + -863514473;
    }
}

