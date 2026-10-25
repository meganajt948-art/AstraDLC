/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.inventory.SimpleInventory
 *  net.minecraft.item.FilledMapItem
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.NamedScreenHandlerFactory
 *  net.minecraft.screen.SimpleNamedScreenHandlerFactory
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.GameMode
 */
package a;

import a.dts;
import a.dtv;
import a.ech;
import a.egq;
import a.ejp;
import a.kfe;
import a.mpq;
import a.nxa;
import a.pnc;
import a.pud;
import flow.Flow;
import flow.bot.BotScreen;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;

final class fga {
    private static final String fgb = a.d("\ua28b\udb10\u51c0\ucfa9\u444b\uc2d7\u789f\uf12b", 89280975, 1072362250);
    private static int fgc;
    private static dtv fgd;
    private static int fge;
    private static double fgf;
    private static int fgg;
    private static float fgh;
    private static float fgi;
    private static /* synthetic */ String fgj;
    private static /* synthetic */ boolean fgk;

    private fga() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        Object object;
        int n2;
        IntegratedServer integratedServer = minecraftClient.method_1576();
        if (integratedServer == null) {
            return n > 40;
        }
        if (n == 1) {
            integratedServer.method_3864(false);
            fgc = 25570 + (int)(System.nanoTime() % 20L);
            n2 = integratedServer.method_3763(GameMode.field_9215, true, fgc);
            fga.fgq(a.b("\ub3f0\uca4c\u4090\udeaf\u5537\ud399\u69df\ue025\u7e34", 954577813) + (n2 != 0) + a.c(-669091689, "\u78b1\u0150\u8b9c\u15f0\u9e21\u18c4") + fgc);
            if (n2 == 0) {
                fga.fgp(a.d("\uf4aa\u8d16\u07ca\u99d5\u1246\u94fa\u2ea4\ua711\u3900\ub3b0\u3478\uce5d\u40c5\ud96b\u532d\ud5d7", -1636469545, 1283620897));
                return true;
            }
        }
        if (n == 10) {
            fgd = egq.get().add(a.c(1666217046, "\u7418\u0d83\u8753\u193a\u92d8\u1444\uae0c\u27b8"), a.c(-509571510, "\u8e2c\uf79e\u7d41\ue332\u68e8\uee5d\u5409\udde4\u43bc\uc943") + fgc);
            fga.fgq(a.b("\u0b03\u72bf\uf877\u6652\uedc4\u6b70\ud123\u58d3\uc68d\u4c78", 2105019243) + (fgd != null));
            if (fgd != null) {
                fgd.setAddress(a.c(35446680, "\udffe\ua64c\u2c93\ub2e0\u393a\ubf8f\u05db\u8c36\u126e\u9891") + fgc);
                if (fgd.getStatus() == dts.OFFLINE || fgd.getStatus() == dts.FAILED) {
                    fgd.connect();
                }
            }
        }
        if (fgd == null) {
            return n > 20;
        }
        if (n > 10 && n % 20 == 0 && fge < 0) {
            fga.fgq(a.d("\u3277\u4bc1\uc107\u5f63\ud4b5\u5202\ue802", -1605762203, 526528870) + (Object)((Object)fgd.getStatus()) + a.d("\u2d29", 1224311547, -224808973) + fgd.getStatusText() + a.d("\u4b31\u32d0\ub816\u266c\uadb1\u2b0d\u9159\u18a1\u86b9", 192220901, 1219708413) + fgd.getPendingPackets());
        }
        if (fge < 0 && fgd.getStatus() == dts.ONLINE && fgd.getPlayer() != null) {
            fge = n;
            fga.fgq(a.d("\uc2f7\ubb47\u3196\uafe2\u2432\ua288\u18be\u910e\u0f44\u85a1\u0226\uf81e", 1732825670, -719253262) + n);
        }
        if (fge < 0) {
            if (n > 900) {
                fga.fgp(a.c(1397391619, "\u8176\uf8ca\u7202\uec27\u67be\ue104\u5b44\ud2a6\u4cee\uc60d\u419d\ubbee\u3535\uac8c\u269a\ua024\u1a6a\u95b9\u0f0f\u8959\u00a5\u7aab\uf402") + fgd.getStatusText());
                fga.fgn();
                return true;
            }
            return false;
        }
        n2 = n - fge;
        ClientPlayerEntity clientPlayerEntity = fgd.getPlayer();
        if (n2 == 40) {
            fga.fgo(minecraftClient.field_1724 != null && minecraftClient.field_1724 != clientPlayerEntity, a.b("\u8ee2\uf75f\u7d84\ue3f2\u686b\uee8a\u54c5\udd39\u437e\uc9d3\u4e17\ub434\u3aaa\ua301\u2901\uafbe\u15f0\u9a3a\u00dd\u86d8\u0f33\u756f\ufb99\u600a\ue678\u6cb2", 808750741));
            fga.fgo(minecraftClient.field_1687 != null && minecraftClient.field_1687 != fgd.getWorld(), a.b("\uce2e\ub793\u3d48\ua33e\u28a7\uae41\u140a\u9de6\u03a7\u891e\u0e89\uf4b1\u7a7c\ue39e\u6983\uef73\u5527\udaa2\u4045\uc608\u4ff2\u35e6\ubb17\u20cb\ua6af\u2c2d\u95ca", -1080242600));
            fga.fgo(!ejp.isActive(), a.b("\u5082\u2932\ua3ae\u3d9d\ub647\u30ed\u8aea\u0358\u9d0b\u17bb\u9072\u6a12\ue4d8\u7d65\uf762\u71dc\ucb89\u4459\udeed\u58a6\ud15c\uab0c\u25fa\ube7f\u381c\ub2c0\u0b36\u8521\u1fc2\u9980\u123f\uece6\u66ec\uff55\u7901\uf3b0\u4c63", -1342615351));
            object = integratedServer.method_3760().method_14566(a.d("\u3b5e\u42c5\uc815\u567c\udd9e\u5b02\ue14a\u68fe", 445396861, -1192489875));
            fga.fgo(object != null, a.b("\u70d7\u0970\u83b4\u1dc1\u9605\u10a3\uaaa2\u2300\ubd49\u37f8\ub03d\u4a1f\uc49c\u5d31\ud76f\u51db\uebd6\u640a\ufea2", 621965495));
            if (clientPlayerEntity != null) {
                fga.fgq(a.b("\ue6a5\u9f19\u15d1\u8bf4b\u86c6\u3cc1", -333257024) + clientPlayerEntity.method_24515() + a.b("\uc7ac\ube55\u349e\uaabf", 468305800) + clientPlayerEntity.method_6032() + a.c(1051366678, "\u953e\uecc3\u6613\uf86c\u73be\uf50e\u4f5c\uc6e9") + (clientPlayerEntity.field_3944 != null && clientPlayerEntity.field_3944.method_76760()));
                fga.fgo(clientPlayerEntity.field_3944.method_76760(), a.d("\u3585\u4c39\uc6f1\u58d4\ud34e\u55f3\uefb3\u665b\uf80a\u72ba\uf52d\u0f10\u81c4\u187b\u922d\u14dd\uae93", -2115151787, 1252945315));
            }
            fgd.sendChat(a.c(1252426910, "\u84f8\ufd44\u779e\ue9ef\u623b\ue4c5\u5ed0\ud735\u4977\uc3c4\u445a\ube69\u30b3\ua919"));
            integratedServer.execute(() -> {
                ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(a.b("\u801d\uf986\u7356\ued3f\u66dd\ue041\u5a09\ud3bd", -2097774509));
                if (serverPlayerEntity != null) {
                    serverPlayerEntity.method_64398((Text)Text.method_43470((String)a.c(-277837053, "\u8b7e\uf2d9\u781d\ue668\u6dac\ueb0a\u510b\ud8a9\u46e4\ucc4d\u4b94\ub1b6\u3f29\ua699")));
                    serverPlayerEntity.method_31548().method_7394(new ItemStack((ItemConvertible)Items.field_8477, 5));
                }
            });
        }
        if (n2 == 80) {
            boolean bl = false;
            for (ech ech2 : fgd.getChat().lines()) {
                if (!ech2.text.getString().contains(a.b("\ua13e\ud899\u525d\ucc28\u47ec\uc14a\u7b4b\uf2e9\u6ca4\ue60d\u61d4\u9bf6\u1569\u8cd9", 623092035))) continue;
                bl = true;
            }
            fga.fgo(bl, a.d("\ue225\u9b99\u1151\u8f74\u04e0\u825a\u3800\ub1e4\u2fef\ua519\u22c2\ud8a8\u562b\ucfce\u4581\uc37d\u7977\uf6f5\u6c50\uea16\u63e5\u19a7\u9703\u0c80\u8ab2k\ub9ce\u379f\uad7a\u2b2d\ua09c", -765163163, -1426035907));
            boolean bl2 = clientPlayerEntity != null && clientPlayerEntity.method_31548().method_18861(Items.field_8477) == 5;
            fga.fgo(bl2, a.c(-1171144340, "\uc12f\ub893\u325b\uac7e\u27e0\ua156\u1b1d\u92ff\u0cab\u8600\u01c8\ufba4\u7578\uec90\u6690\ue06b\u5a33\ud5ef\u4f5a\uc90a\u40b9\u3ae0\ub44e\u2f8a\ua9b1\u236d\u9ad6\u148b\u8e7e\u082e\u8397\u7d51\uf744"));
            minecraftClient.method_1507((Screen)new BotScreen());
        }
        if (n2 == 110) {
            fga.fgr(minecraftClient, a.c(2086426012, "\u55f5\u2c49\ua681\u38f7\ub37e\u3595\u8fd8\u062e\u987b\u12c1\u950a"));
        }
        if (n2 == 120) {
            fgf = clientPlayerEntity == null ? 0.0 : clientPlayerEntity.method_23321();
            fgd.getControl().setActive(true);
            fgd.getControl().setMovement(true, false, false, false, false, false, false);
        }
        if (n2 == 160) {
            fgd.getControl().setMovement(false, false, false, false, false, false, false);
            fgd.getControl().setActive(false);
            double d = clientPlayerEntity == null ? 0.0 : Math.abs(clientPlayerEntity.method_23321() - fgf);
            fga.fgq(a.b("\u889f\uf122\u7bf0\ue59b\u6e4a\ue8e6\u52b6\udb0b\u4519\ucfaa\u4860\ub202\u3cd4\ua521", 492996850) + String.format(a.c(1109517561, "\ue4d8\u9d62\u17ad\u8988"), d));
            fga.fgo(d > 1.0, a.d("\uf45d\u8de1\u0729\u990c\u128c\u942b\u2e75\ua783\u39c4\ub326\u34a0\uceca\u4017\ud9a7\u53e3\ud540\u6f4c\ue091\u7a23\ufc68\u7599\u0fd5\u8165", -1726780876, 579116572));
            integratedServer.execute(() -> {
                ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(a.d("\u3739\u4ea2\uc472\u5a1b\ud1f9\u5765\ued2d\u6499", -1514888023, -1153002530));
                if (serverPlayerEntity != null) {
                    SimpleInventory simpleInventory = new SimpleInventory(27);
                    simpleInventory.method_5447(0, new ItemStack((ItemConvertible)Items.field_8687, 3));
                    serverPlayerEntity.method_17355((NamedScreenHandlerFactory)new SimpleNamedScreenHandlerFactory((n, playerInventory, playerEntity) -> GenericContainerScreenHandler.method_19245((int)n, (PlayerInventory)playerInventory, (Inventory)simpleInventory), (Text)Text.method_43470((String)a.c(-1018002040, "\u81a5\uf803\u72a4\uecd6\u677d\ue1c0\u5bea\ud269\u482f\uc6ff\u412e\ubb21\u35ff\uac39\u2613"))));
                }
            });
        }
        if (n2 == 200) {
            boolean bl = clientPlayerEntity != null && clientPlayerEntity.field_7512 != clientPlayerEntity.field_7498;
            fga.fgo(bl, a.b("\ub0ee\uc952\u439a\uddbf\u563b\ud09c\u6acf\ue328\u7d24\uf7c1\u700e\u8a72\u04e0\u9d1e\u1752\u91b6\u2bf2\ua428\u3e9a\ub88f\u313b\u4b61\uc5df\u5e18\ud860", 1025618069));
            fga.fgo(a.d("\ua64d\udfeb\u554c\ucb3e\u4095\uc628\u7c02\uf581\u6fc7\ue117\u66c6\u9cc9\u1217\u8bd1\u01fb", -1023977768, -367856456).equals(fgd.getOpenedScreenTitle()), a.d("\u47fa\u3e40\ub49e\u2af9\ua129\u27cc\u9dcb\u1427\u8a65\u00cc\u8716\u7d22\uf3a7\u6a01\ue056\u66a5\udce1\u533d\uc98f\u4f9a\uc639\ubc74\u32ca\ua95e\u2f63\ua5bf\u1c17", -885922151, -134373093));
            fga.fgr(minecraftClient, a.d("\ud728\uae94\u245c\uba2a\u31a3\ub75c\u0d04\u84f8\u1ab1\u9007", -1352342703, -1670171631));
            if (bl) {
                fgd.clickSlot(clientPlayerEntity.field_7512.field_7763, 0, 0, SlotActionType.field_7794);
            }
        }
        if (n2 == 240) {
            fga.fgo(clientPlayerEntity != null && clientPlayerEntity.method_31548().method_18861(Items.field_8687) == 3, a.c(-1138314966, "\ub15d\uc8e1\u4229\udc0c\u578f\ud125\u6b76\ue283\u7c97\uf672\u71bd\u8bc1\u0553\u9ca7\u16fc\u9005\u2a5d\ua59f\u3f21\ub978\u3098"));
            fgd.closeScreen();
        }
        if (n2 == 260) {
            fga.fgo(clientPlayerEntity != null && clientPlayerEntity.field_7512 == clientPlayerEntity.field_7498, a.b("\uddb0\ua40c\u2ec4\ub0e1\u3b75\ubdcb\u079b\u8e76\u103f\u9a8f\u1d18\ue73d\u69f6\uf04a\u7a5c\ufcee\u46aa\uc976\u53d3\ud585", 842259910));
            fgd.setF1(true);
        }
        if (n2 == 320) {
            fga.fgl(a.d("\ud041\ua9e5\u2335\ubd59\u3686", -1408031883, -529075355));
        }
        if (n2 == 325) {
            fga.fgr(minecraftClient, a.b("\ueefd\u9741\u1d89\u83ff\u0876\u8e9e\u34d8\ubd2a\u233a\ua9d1\u2e14\ud476\u5ab7\uc307\u495f", -310710640));
        }
        if (n2 == 340) {
            fga.fgo(fgd.f1Run(), a.c(1992991707, "\ua380\uda05\u50d7\ucebd\u4552\uc3d5\u7995\uf072\u6e2c\ue496\u630b\u9928\u17f8\u8e52\u041c\u82be\u38be\ub76e\u2d93\uab96\u227d\u5821\ud6d7\u4d44\ucb36\u41fc"));
            fga.fgq(a.b("\uf6ca\u8f6d\u05ad\u9bca\u101c\u96a6\u2cbb\ua519\u3b41\ub1e5\u3623\ucc43\u42d1", 993392304) + fgd.f1ref().getStateIndex());
            fgd.setF0(true);
        }
        if (n2 == 400) {
            fga.fgl(a.d("\uc8a4\ub100\u3bd0\ua5bc\u2e71", -675965019, -532914352));
        }
        if (n2 == 405) {
            fga.fgr(minecraftClient, a.c(198825007, "\ud45d\uade1\u2729\ub95f\u32d6\ub43e\u0e78\u878a\u199a\u9367\u14a0\ueed0\u601c\uf9a7\u73ff\uf504"));
            fga.fgm(a.d("\u2bbc\u520e\ud8dd\u46b7\ucd44\u4bcc\uf195\u786c\ue63d\u6c9b", 1365152139, 1654635089), true);
        }
        if (n2 == 410) {
            fga.fgr(minecraftClient, a.b("\uc968\ub0d4\u3a1c\ua46a\u2fe3\ua913\u1343\u9ab2\u04f6\u8e1e\u0990\uf3f8\u7d25\ue49c\u6ec1\ue827", 315017498));
            fga.fgm(a.d("\uee79\u97cb\u1d18\u8372\u0881\u8e09\u3450\ubda9\u23f8\ua95e", 956481740, -244175149), false);
        }
        if (n2 == 420) {
            fga.fgo(fgd.f0Run() && !fgd.f1Run(), a.b("\ufb3d\u82b8\u086a\u9600\u1dfd\u9b67\u213e\ua88b\u3686\ubc20\u3be6\uc18b\u4f51\ud6e2\u5cb7\uda47\u604c\ueffc\u757b\uf32b\u7ac7\u00ae\u8e2b\u15e9\u9380\u1950\ua0e8", 1765800807));
            fga.fgq(a.c(-724339235, "\u75b4\u0c11\u86c3\u18a9\u9374\u15ce\uaf97\u2622") + fgd.f0ref().getStateDescription());
            fgd.stopAutomation();
        }
        if (n2 == 460) {
            fga.fgo(!fgd.isActive(), a.b("\ue1d3\u9876\u12a4\u8cce\u071b\u81a6\u3be0\ub20c\u2c55\ua6e5\u2178\udb5a\u558a\ucc20\u466c\uc09d\u7ac7\uf517", 1614995872));
            integratedServer.execute(() -> {
                ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(a.c(1623804685, "\u4b43\u32d8\ub808\u2661\uad83\u2b1f\u9157\u18e3"));
                if (serverPlayerEntity != null) {
                    serverPlayerEntity.method_5768(serverPlayerEntity.method_51469());
                }
            });
        }
        if (n2 == 480) {
            fga.fgl(a.c(-1257686291, "\u3aac\u4310\uc9d8"));
        }
        if (n2 == 485) {
            fga.fgr(minecraftClient, a.d("\ufa3d\u8381\u0949\u973f\u1cb6\u9a5e\u2018\ua9ea\u37fa\ubd04\u3ada\uc0b0", -34642725, 1228512904));
            fga.fgl(a.d("\u816d\uf8d1\u7202", -868218746, -1739159127));
        }
        if (n2 == 490) {
            fga.fgr(minecraftClient, a.c(-516886420, "\uf002\u89be\u0376\u9d00\u1689\u9061\u2a27\ua3d5\u3dc5\ub738\u30e6\uca97"));
            fga.fgl(a.d("\u5549\u2cf3\ua629\u384d", -1281559410, 886743424));
        }
        if (n2 == 640) {
            object = fgd.getPlayer();
            fga.fgo(object != null && object.method_5805(), a.b("\ubf66\uc6da\u4c12\ud237\u59b2\udf14\u6551\ueca3\u72ed\uf84a\u7f80\u85fa\u0b2c\u92d9\u18c8\u9e22\u2434\uabac\u3102\ub754\u3eb5\u44ed\uca54", -821969133));
            integratedServer.execute(() -> {
                ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(a.d("\u45a5\u3c3e\ub6ee\u2887\ua365\u25f9\u9fb1\u1605", 2105076975, -909596412));
                if (serverPlayerEntity != null) {
                    ItemStack itemStack = FilledMapItem.method_8005((ServerWorld)serverPlayerEntity.method_51469(), (int)serverPlayerEntity.method_31477(), (int)serverPlayerEntity.method_31479(), (byte)0, (boolean)true, (boolean)false);
                    serverPlayerEntity.method_31548().method_5447(serverPlayerEntity.method_31548().method_67532(), itemStack);
                }
            });
        }
        if (n2 == 700) {
            fga.fgo(fgd.getCaptcha().isPresent(), a.c(-638171101, "\u4861\u31d2\ubb10\u2565\uaea5\u281f\u9245\u1bf5\u85fa\u0f52\u888b\u72f2\ufc2b\u659b\uef8c\u6928\ud362\u5ce3\uc604\u4049\uc9b3\ub3a7\u3d59\ua684\u20ea\uaa6b\u1391\u9dc7\u077e\u8167\u0add\uf403\u7e46"));
            fga.fgr(minecraftClient, a.d("\ub69b\ucf27\u45ef\udb99\u5010\ud6ef\u6cbe\ue55e\u7b05\uf1a3\u767b\u8c03", 254067128, 841774925));
        }
        if (n2 == 760) {
            fga.fgq(a.b("\uf718\u8eab\u0469\u9a1c\u11dc\u9766\u2d3c\ua48c\u3a92\ub037\u37e5\ucd8f\u430d\udaa6\u50f2", 2011690868) + fgd.getCaptcha().getAutoCode() + a.b("\u8aae\uf318\u7998\ue7ee\u6c2c\uea88\u50ca\ud97e\u4726", -1442542976) + fgd.getCaptcha().getAutoState() + a.c(452633577, "\ua3cf"));
            fgd.getCaptcha().dismiss();
            integratedServer.execute(() -> {
                int n;
                int n2;
                ServerPlayerEntity serverPlayerEntity = integratedServer.method_3760().method_14566(a.b("\ude93\ua708\u2dd8\ub3b1\u3853\ubecf\u0487\u8d33", 2071781085));
                if (serverPlayerEntity == null) {
                    return;
                }
                ServerWorld serverWorld = serverPlayerEntity.method_51469();
                serverPlayerEntity.method_31548().method_5447(serverPlayerEntity.method_31548().method_67532(), new ItemStack((ItemConvertible)Items.field_8377));
                BlockPos blockPos = serverPlayerEntity.method_24515();
                for (n2 = -4; n2 <= 4; ++n2) {
                    for (n = 0; n <= 3; ++n) {
                        serverWorld.method_8501(blockPos.method_10069(n2, n, 7), n2 == 0 && n >= 1 && n <= 2 ? Blocks.field_10033.method_9564() : (n == 3 ? Blocks.field_10503.method_9564() : Blocks.field_10056.method_9564()));
                    }
                }
                for (n2 = -2; n2 <= 2; ++n2) {
                    for (n = 3; n <= 5; ++n) {
                        serverWorld.method_8501(blockPos.method_10069(n2, -1, n), Blocks.field_10382.method_9564());
                    }
                }
                serverWorld.method_8501(blockPos.method_10069(3, 0, 4), Blocks.field_10336.method_9564());
                serverWorld.method_8501(blockPos.method_10069(-3, 0, 4), Blocks.field_10442.method_9564());
                serverWorld.method_8501(blockPos.method_10069(-3, 1, 4), Blocks.field_10449.method_9564());
                integratedServer.method_3734().method_44252(integratedServer.method_3739(), String.format(Locale.ROOT, a.c(1298756983, "\u751a\u0caf\u862c\u1858\u93d9\u153b\uaf6d\u2697\ub8d4\u3231\ub5a4\u4fd0\uc10c\u58a1\ud2a6\u5411\uee5b\u6181\ufb2e\u7d2b\uf49a\u8edbx\u9bb8\u1dc4"), a.c(1120117411, "\ua2ed\udb76\u51a6\ucfcf\u442d\uc2b1\u78f9\uf14d"), (double)blockPos.method_10263() + 0.5, (double)blockPos.method_10264(), (double)blockPos.method_10260() + 0.5));
            });
        }
        if (n2 == 790) {
            fga.fgm(a.b("\u51bc\u280f\ua2d0\u3ca9\ub769\u31cb\u8bb4\u0267\u9c33\u1683", 252334549), true);
            fga.fgl(a.b("\u16ad\u6f09\ue5d9\u7bb5\uf070", 963974908));
        }
        if (n2 == 830) {
            fga.fgo(fgd.getCamera().isReady(), a.d("\u6730\u1e8c\u9444\u0a61\u81f5\u0746\ubd19\u34e0\uaaa8\u200a\ua798\u5dbb\ud37b\u4ac1\uc098\u4668\ufc30\u73e0", 2010703720, 161382440));
            fga.fgq(a.b("\u2967\u50d4\uda0b\u4472\ucfb2\u4910\uf302\u7ab5\ue4fe\u6e5c\ue983\u13fa\u9d68", -1561515767) + fgd.getCamera().getRenderMillis() + a.d("\ubd6f\uc493\u4e5e", 256783636, -451114920));
            fga.fgr(minecraftClient, a.c(512459316, "\u825d\ufbe1\u7129\uef5f\u64d6\ue229\u5878\ud185\u4fd2\uc574\u42b4"));
            fgd.setF2(true);
        }
        if (n2 == 930) {
            fga.fgo(fgd.f2Run(), a.b("\u90cd\ue948\u639a\ufdf0\u7605\uf090\u4ac4\uc33e\u5d24\ud7c7\u5013\uaa79\u24b3\ubd51\u374d\ub1bd\u0bbc\u8439\u1e96\u98ca\u1178\u6b6b\ue5d5\u7e1f", -1006006124));
            fga.fgq(a.c(-720762679, "\u08a5\u7119\ufbd1\u65f4\uee62\u68c7\ud295\u5b7f\uc522\u4f97\uc843\u3239\ubcb1\u251a") + fgd.f2ref().status() + a.b("\ud359\uaae7\u203b", 1138348922) + fgd.f2ref().lastNote());
            fga.fgq(a.c(-369590155, "\u8005\uf9b6\u7369\ued10\u66d0\ue072\u5a60\ud3dc\u4d8f\uc736\u40e2\ubadd\u345e\uadf3\u27ba\ua15c\u1b17\u94c3\u0e34") + fgd.getCamera().getRenderMillis() + a.d("\u5719\u2ee5\ua428\u3a06\ub1dd\u372e\u8d7e\u048d\u9ada\u1067\u97a1\u6dcd\ue300\u7aaa\uf0f3\u7646\ucc5d\u438a\ud92a\u5f79\ud688\uac9c", -238035433, -1813214920) + fgd.getCamera().getTraceMillis() + a.b("\u3c92\u456e\ucfa3", -1911735119));
            fga.fgr(minecraftClient, a.c(-1660701371, "\ub52a\ucc96\u465e\ud828\u53a1\ud549\u6f0f\ue6fd\u78ed\uf21c\u75cb\u8fbd\u0161"));
            fgd.setF2(false);
        }
        if (n2 == 960) {
            fga.fgo(!fgd.f2Run(), a.b("\u9716\uee93\u6441\ufa2b\u71de\uf74b\u4d1f\uc4e5\u5aff\ud01d\u57c9\uada3\u236b\ubada\u309c\ub66c\u0c67\u83f9\u194b\u9f54\u16f7\u6cba\ue204\u7990\uffad\u7571\uccd9", -792225972));
            fga.fgm(a.b("\uc229\ubb9a\u3145\uaf3c\u24fc\ua25e\u1821\u91f2\u0fa6\u8516", 1766048320), false);
            minecraftClient.method_1507(null);
        }
        if (n2 == 1080) {
            fga.fgr(minecraftClient, a.b("\ua083\ud93f\u53f7\ucd81\u4608\uc0f9\u7aa6\uf35f\u6d07\ue7f5\u607d\u9a13\u14c8\u8d6b", 516530415));
            fga.fgo(minecraftClient.field_1724 != null && minecraftClient.field_1687 != null && minecraftClient.field_1724.method_5805(), a.b("\u7c5a\u05e7\u8f3c\u114a\u9ad3\u1c32\ua67d\u2f81\ub1c6\u3b6b\ubcaf\u468c\uc81d\u51a3\udbf7\u5d0d", -789808089));
            fga.fgn();
            egq.get().remove(fgd);
        }
        if (n2 == 1140) {
            fga.fgo(integratedServer.method_3760().method_14566(a.c(-447927251, "\u2c63\u55f8\udf28\u4141\ucaa3\u4c3f\uf677\u7fc3")) == null, a.b("\u84d2\ufd6e\u77a6\ue983\u6218\ue4a0\u5ef0\ud713\u4918\uc3fd\u4432\ube4e\u30dc\ua93e\u237b\ua59d\u1fd6\u9014\u0ab0", 319849635));
            fgh = minecraftClient.field_1724.method_36454();
            fgi = minecraftClient.field_1724.method_36455();
            object = Flow.getInstance().getModuleManager().get(nxa.class);
            ((pnc)object).setEnabled(true);
        }
        if (n2 == 1220) {
            object = Flow.getInstance().getModuleManager().get(nxa.class);
            fga.fgq(a.d("\ua2b3\udb1a\u51d0\ucfef\u446f\uc2c8\u7888\uf16f\u6f31\ue58b\u6216\u9834\u16e4\u8f40\u0506\u83e6\u39ec", -1095201715, 1958489728) + ((nxa)object).getStateIndex() + a.c(496858290, "\u7495\u0d77\u87a7\u19c9\u921e\u14a6\uaeb3") + pud.INSTANCE.engaged());
            fga.fgo(((kfe)object).isEnabled(), a.d("\u09b1\u7018\ufad2\u64ed\uef5b\u69de\ud38c\u5a66\uc401\u4e86\uc946\u3321\ubdf7\u244d\uae50\u28ea\u92ab\u1d6f\u87d8\u01dd\u8878\uf22e\u7c86\ue757\u612f\uebf9\u5243", 1750999978, 184822383));
            ((pnc)object).setEnabled(false);
            Flow.getInstance().getModuleManager().get(mpq.class).setEnabled(true);
        }
        if (n2 == 1300) {
            object = Flow.getInstance().getModuleManager().get(mpq.class);
            fga.fgq(a.d("\ue3d0\u9a79\u10b3\u8e8c\u051a\u83bf\u39ed\ub007\u2e52\ua4e8\u2331\ud904", -1858723772, -1925790729) + ((mpq)object).getStateDescription() + a.c(259861559, "\u2c10\u55f2\udf22\u414c\uca9b\u4c23\uf636") + pud.INSTANCE.engaged());
            fga.fgo(((kfe)object).isEnabled(), a.c(1938160456, "\ufb3f\u8296\u085c\u9663\u1dd5\u9b50\u2102\ua8e8\u369d\ubc07\u3bde\uc1eb\u4f77\ud6c8\u5c8e\uda7b\u6060\uefe3\u7557\uf31d\u7aea\u00bc\u8e08\u15d0"));
            ((pnc)object).setEnabled(false);
        }
        if (n2 == 1360) {
            fga.fgq(a.b("\u291a\u50a9\uda76\u440f\ucfcf\u496d\uf37f\u7ad7\ue490\u6e37\ue9b3", 974662002) + fgh + a.b("\u95b3\uec0f\u66cf\uf8a0", -1932814953) + minecraftClient.field_1724.method_36454() + a.d("\u3e11\u47ac\ucd2f\u5347\ud88d\u5e2b\ue473\u6dca", 2114299029, 1981717152) + fgi + a.d("\u5df4\u2448\uae88\u30e7", 1811799430, -874872746) + minecraftClient.field_1724.method_36455());
            fga.fgo(!pud.INSTANCE.engaged(), a.c(-1866540694, "\ud90d\ua0a6\u2a70\ub408\u3fd4\ub97f\u0378\u8adf\u149f\u9e22\u19e3\ue3c5\u6d40\uf4e6\u7ebc\uf844\u420f\ucdcc\u5769\ud139"));
            fga.fgo(minecraftClient.field_1724.method_5805(), a.b("\ueafa\u9347\u199c\u87ea\u0c73\u8a92\u30dd\ub921\u2766\uadcb\u2a0f\ud02c\u5eba\uc706\u4d50\ucbbe\u71e2\ufe76\u6484\ue2d2\u6b37\u1177\u9fd3\u0450\u8260\u08a9\ub103\u3f1c\ua5ad\u23fb\ua85b\u5695\udc97\u452b\uc37a\u49c0\uf606\u7c6e\ufab4\u6313", 1558440639));
            fga.fgr(minecraftClient, a.c(836500773, "\ufd49\u84f5\u0e3d\u904b\u1bc2\u9d31\u277a\uae92\u308e\uba73\u3da7\uc7c4\u4902\ud0a4"));
            fga.fgq(a.b("\ucadc\ub366\u39b4\ua7ce\u2c50\uaaed\u10f8\u990e\u0759\u8ded\u0a21\uf003", -1359492428) + fgg);
            return true;
        }
        return false;
    }

    private static void fgl(String string) {
        try {
            Class<?> clazz = Class.forName(a.d("\ubc49\uc5f2\u4f22\ud14b\u5ac5\udc38\u6666\uef8c\u7189\ufb54\u7caa\u86c0\u0830\u91b1\u1bf3\u9d15\u275a\ua880\u3279\ub458\u3d9a\u47c8", -2122152327, 1288583744));
            Field field = BotScreen.class.getDeclaredField(a.d("\udcc3\ua567\u2fb7", 309031401, -2122928803));
            field.setAccessible(true);
            field.set(null, Enum.valueOf(clazz, string));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            fga.fgp(a.b("\u4769\u3ecd\ub41d\u2a2e", -350402791) + string + a.b("\u3e44\u47ef", -1595064708) + reflectiveOperationException);
        }
    }

    private static void fgm(String string, boolean bl) {
        try {
            Field field = BotScreen.class.getDeclaredField(string);
            field.setAccessible(true);
            field.setBoolean(null, bl);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            fga.fgp(a.c(-487589604, "\uf97f\u80c4\u0a1a\u946d\u1ffd") + string + a.b("\u97c6\uee6d", 1784518654) + reflectiveOperationException);
        }
    }

    private static void fgn() {
        if (fgd == null) {
            return;
        }
        for (ech ech2 : fgd.getChat().lines()) {
            fga.fgq(a.b("\u82b0\ufb0a\u71d0\uefb4\u6437\ue2fd", -104955179) + (Object)((Object)ech2.kind) + a.c(-1103987934, "\u7b7d\u02b1") + ech2.text.getString());
        }
    }

    private static void fgo(boolean bl, String string) {
        if (bl) {
            fga.fgq(a.c(-312308744, "\u8bb4\uf201\u78b9") + string);
        } else {
            fga.fgp(string);
        }
    }

    private static void fgp(String string) {
        ++fgg;
        fga.fgq(a.d("\u3e83\u4735\ucdee\u539a\ud821", -1100895633, -379087697) + string);
    }

    private static void fgq(String string) {
        System.out.println(a.d("\ua8dc\ud160\u5ba8\uc5de\u4e40\uc8eb", -504240883, -2012262987) + string);
    }

    private static void fgr(MinecraftClient minecraftClient, String string) {
        fga.fgq(a.c(435751021, "\u081b\u71b1\ufb65\u650f\uee8c") + string);
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(-1261595976, "\u92d8\ueb63\u61b3\uffda\u7448\uf2e6") + string + a.d("\ud7e8\uae07\u24ca\ubab2", 1570177671, -748432059)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        fge = -1;
    }

    private static /* synthetic */ int og(int n, int n2) {
        return n ^ n2 ^ 0x1D17353B;
    }
}

