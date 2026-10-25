/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket$Mode
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.network.ServerCommonNetworkHandler
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.util.PlayerInput
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.fyi;
import a.kfe;
import a.vkl;
import a.vmo;
import a.vyn;
import a.vzz;
import a.wdt;
import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.Vec3d;

final class fyl {
    private static final int fym = 170;
    private static final Set<Integer> fyn = ConcurrentHashMap.newKeySet();
    private static final AtomicInteger fyo = new AtomicInteger();
    private static final AtomicInteger fyp = new AtomicInteger();
    private static final AtomicInteger fyq = new AtomicInteger();
    private static final StringBuffer fyr = new StringBuffer();
    private static volatile boolean fys;
    private static volatile boolean fyt;
    private static volatile boolean fyu;
    private static int fyv;
    private static int fyw;
    private static int fyx;
    private static int fyy;
    private static double fyz;
    private static Vec3d fza;
    private static int fzb;
    private static boolean fzc;
    private static /* synthetic */ long fzd;
    private static /* synthetic */ String fze;

    private fyl() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        if (n == 1) {
            vzz.simulated = fyn::contains;
            kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\ufe7f\u87fc\u0d33\u9366\u1893\u9e3b\u247b", -483525057));
            kfe2.setEnabled(true);
            kfe kfe3 = Flow.getInstance().getModuleManager().getByName(a.b("\uf724\u8ea1\u0473\u9a19\u11f2\u9760\u2d31\ua4db\u3a83\ub028", -115083409));
            if (kfe3 != null) {
                kfe3.setEnabled(false);
            }
            minecraftClient.getNetworkHandler().sendChatCommand(a.c(1970304928, "\u77d6\u0e61\u84be\u1ac7\u9118\u17ab\uadf3\u2403\uba19\u30fb\ub72e\u4d58\uc38b\u5a25\ud069\u568f\ueccd"));
            minecraftClient.getNetworkHandler().sendChatCommand(a.b("\u1308\u6aba\ue069\u7e1b\uf5ca\u736c\uc96b\u40dd\ude8c\u5422\ud3e2\u29d6\ua761\u3ee3\ub4e3\u3240\u8818\u07df\u9d76\u1b3d\u92cd\ue889\u6635\ufde9\u7b90\uf104\u48a1\uc6f6\u5c01\uda40\u51e7\uaf22\u2539\ubcce\u3a9a\ub03b", 1362367305));
            minecraftClient.getNetworkHandler().sendChatCommand(a.d("\u0195\u7827\uf2f4\u6c86\ue757\u61f1\udbf6\u5240\ucc11\u46bf\uc17f\u3b4b\ub5fc\u2c7e\ua67e\u20dc\u9a81\u1545\u8ff7\u09a1\u8045\ufa01\u74af\uef78\u6906\ue399\u5a3c\ud46b\u4e9c\uc8dd\u437a\ubdbf\u37a4\uae53\u2807\ua2a6", -1219211482, -1724428558));
        }
        if (n == 5) {
            fyl.fzj(minecraftClient);
        }
        if (n < 10) {
            return false;
        }
        int n2 = n - 10;
        int n3 = n2 / 170;
        int n4 = n2 % 170;
        if (n3 >= 2) {
            vzz.simulated = null;
            System.out.println(a.d("\ued5b\u94f8\u1e37\u8042\u0b97\u8d3f\u377f\ubecb\u20c0\uaa60\u2da5\ud7d3\u5950", 1133453017, 1659499496) + (fzb == 0 ? a.b("\ud43a\uad9a\u275b\ub92a", -1509763986) : a.c(1999730949, "\u7945\u00f3\u8a28\u145c\u9fe7\u195e") + fzb + a.c(1527971416, "\ufe70")));
            return true;
        }
        fyl.fzf(minecraftClient, n3 == 0, n4);
        return false;
    }

    private static void fzf(MinecraftClient minecraftClient, boolean bl, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        String string = bl ? a.c(-844494835, "\u0846\u719e\ufb02\u6575\ueeb7\u6817\ud201\u5bbf\uc5e1\u4f17") : a.b("\u5fd6\u260d\uac91\u32e6\ub924\u3f84\u8592\u0c2c\u927a\u18cb\u9f57", 1356554143);
        switch (n) {
            case 0: {
                fyl.fzi(bl);
                minecraftClient.getNetworkHandler().sendChatCommand(a.b("\u2403\u5dbd\ud767\u4912\uc2d6\u4435\ufe06\u77c4", 288564328));
                minecraftClient.getNetworkHandler().sendChatCommand(a.b("\uef2a\u9686\u1c44\u823d\u09a7\u8f44\u3500\ubce4\u22a7\ua81b\u2fca\ud5bd\u5b2f\uc2db\u4883\uce68\u743a\ufbf6\u6148\ue740\u6ed7\u14b5\u9a55\u01cc\u87b4\u0d7e\ub4db\u3a89\ua06d\u2660\uadcd\u530c\ud914\u40fb\uc6b5\u4c18\uf387\u79bb\uff6c\u66da\uec8e\u9279\u183b\u9f99\u0549\u8b2a\u32b7\ub84f\u3e07\ua5cd\u2bbf\ud165\u5897\uded0\u4421", 89255796));
                minecraftClient.getNetworkHandler().sendChatCommand(a.b("\ua544\udce8\u562a\uc853\u43c9\uc52a\u7f6e\uf68a\u68c9\ue275\u65a4\u9fd3\u1141\u88b5\u02ed\u8406\u3e54\ub198\u2b26\uad2e\u24b9\u5edb\ud03b\u4ba2\ucdda\u4710\ufeb5\u70e7\uea03\u6c0e\ue7a2\u1962\u937a\u0a95\u8cdb\u0676\ub9e9\u33d5\ub502\u2cb4\ua6e0\ud817\u5255\ud5f7\u4f27\uc144\u78d9\uf236\u7474\uefbe\u61cb\u9b4e\u12ef\u94bc", -643652325));
                minecraftClient.getNetworkHandler().sendChatCommand(a.c(-846622283, "\u91e5\ue849\u628b\ufcf2\u7768\uf18b\u4bcf\uc22b\u5c68\ud6d4\u5105\uab72\u25e0\ubc14\u364c\ub0a7\u0af5\u8539\u1f87\u998f\u1018\u6a7a\ue49a\u7f03\uf97b\u73b1\uca14\u4446\udea2\u58af\ud300\u2dc3\ua7db\u3e34\ub87a\u32d7\u8d48\u0774\u81a3\u1815\u9241\uecb6\u66f4\ue156\u7b86\uf5e5\u4c78\uc69c\u40dd\udb06\u5541\uafa3\u2617\ua04e\u3afa\ub4bd\u0f00"));
                minecraftClient.getNetworkHandler().sendChatCommand(a.c(1143088105, "\u23bd\u5a11\ud0d3\u4eaa\uc530\u43d3\uf997\u7073\uee30\u648c\ue35d\u192a\u97b8\u0e4c\u8414\u02ff\ub8ad\u3761\uaddf\u2bd7\ua240\ud822\u56c2\ucd5b\u4b23\uc1e9\u784c\uf61e\u6cfa\ueaf7\u6159\u9f9b\u1583\u8c6c\u0a22\u808f\u3f10\ub52c\u33fb\uaa4d\u2019\u5eee\ud4ac\u530e\uc9de\u47bd\ufe20\u74c8\uf28b\u6957\ue724\u1dfb\u9445\u1202\u88f6\u06bc\ubd02\u3bd8\ub1ee\u2829\ua69c"));
                clientPlayerEntity.setYaw((float)clientPlayerEntity.age * 37.0f % 360.0f);
                break;
            }
            case 5: {
                fyn.add(87);
                fyn.add(341);
                minecraftClient.options.forwardKey.setPressed(true);
                minecraftClient.options.sprintKey.setPressed(true);
                break;
            }
            case 20: {
                fyo.set(0);
                fyp.set(0);
                fyq.set(0);
                fyr.setLength(0);
                fyv = 0;
                fyw = 0;
                fyx = 0;
                fyy = 0;
                fyz = 0.0;
                fza = clientPlayerEntity.getEntityPos();
                System.out.println(a.d("\u6e30\u1793\u9d5c\u0329\u88fc\u0e54\ub414\u3da0", -1896455195, -2055926342) + string + a.b("\uc516\ubce5\u3631\ua843\u239d\ua531\u1f75\u96c1\u08d1\u827f\u05b9\uffc3\u7140\ue8eb\u62eb\ue419\u5e54\ud19e\u4b2a\ucd61\u448b\u3edd\ub067\u2bec", 1946207534) + clientPlayerEntity.isSprinting() + a.b("\u705b\u09b9\u837c\u1d1a\u96c9\u106b\uaa2f\u23ff\ubd83\u3730\ub0f8\u4a8e\uc443\u5dbb", -662736779) + wdt.serverSprinting(clientPlayerEntity));
                minecraftClient.setScreen((Screen)new InventoryScreen((PlayerEntity)clientPlayerEntity));
                break;
            }
            case 30: {
                fyl.fzg(minecraftClient, 36, 0, SlotActionType.PICKUP);
                break;
            }
            case 38: {
                fyl.fzg(minecraftClient, 10, 0, SlotActionType.PICKUP);
                break;
            }
            case 46: {
                fyl.fzg(minecraftClient, 37, 0, SlotActionType.PICKUP);
                break;
            }
            case 54: {
                fyl.fzg(minecraftClient, 11, 0, SlotActionType.PICKUP);
                break;
            }
            case 62: {
                fyl.fzg(minecraftClient, 38, 0, SlotActionType.PICKUP);
                fyl.fzg(minecraftClient, 12, 0, SlotActionType.PICKUP);
                fyl.fzg(minecraftClient, 12, 0, SlotActionType.PICKUP);
                fyl.fzg(minecraftClient, 13, 0, SlotActionType.PICKUP);
                break;
            }
            case 70: {
                fyn.add(340);
                break;
            }
            case 74: {
                fyl.fzg(minecraftClient, 39, 0, SlotActionType.QUICK_MOVE);
                break;
            }
            case 75: {
                fyl.fzg(minecraftClient, 10, 0, SlotActionType.QUICK_MOVE);
                break;
            }
            case 80: {
                fyn.remove(340);
                break;
            }
            case 86: 
            case 87: 
            case 88: 
            case 89: {
                fyl.fzg(minecraftClient, 11 + (n - 86) % 2, 0, SlotActionType.PICKUP);
                break;
            }
            case 100: {
                fyn.add(32);
                break;
            }
            case 104: {
                fyl.fzg(minecraftClient, 13, 1, SlotActionType.PICKUP);
                break;
            }
            case 106: {
                fyl.fzg(minecraftClient, 14, 0, SlotActionType.PICKUP);
                break;
            }
            case 110: {
                fyn.remove(32);
                break;
            }
            case 120: {
                if (clientPlayerEntity.currentScreenHandler.getCursorStack().isEmpty()) break;
                fyl.fzg(minecraftClient, 15, 0, SlotActionType.PICKUP);
                break;
            }
            case 125: {
                clientPlayerEntity.closeHandledScreen();
                break;
            }
            case 145: {
                fyn.clear();
                minecraftClient.options.forwardKey.setPressed(false);
                minecraftClient.options.sprintKey.setPressed(false);
                break;
            }
            case 160: {
                fyl.fzh(string, bl, clientPlayerEntity);
                break;
            }
        }
        if (n > 20 && n <= 125 && minecraftClient.currentScreen instanceof InventoryScreen) {
            ++fyw;
            Vec3d vec3d = clientPlayerEntity.getEntityPos();
            fyz += Math.hypot(vec3d.x - fyl.fza.x, vec3d.z - fyl.fza.z);
            fza = vec3d;
            if (wdt.serverSprinting(clientPlayerEntity)) {
                ++fyx;
            }
            if (PlayerInput.DEFAULT.equals((Object)vyn.lastSent(clientPlayerEntity))) {
                ++fyy;
            }
        }
        if (n == 131 && minecraftClient.currentScreen == null) {
            System.out.println(a.d("\u44f2\u3d51\ub79e\u29eb\ua23e\u2496\u9ed6\u1762", -149613077, -1440067210) + string + a.c(-390081916, "\ud2b2\uab42\u2196\ubff5\u3433\ub295\u0894\u8126\u1f76\u95c4\u120b\ue86c\u66e4\uff4f\u755a\uf3a2\u49f0\uc624\u5c81\udac3\u5322\u292a") + minecraftClient.options.forwardKey.isPressed() + a.c(1798920197, "\u582e\u21cc\uab1c\u356f\ubea3\u3815\u825c\u0bb0\u95e8\u1f50\u98d9") + clientPlayerEntity.isSprinting() + a.b("\u52bf\u2b47\ua193\u3ffc\ub42e\u329e\u8884", -1664265576) + vyn.lastSent(clientPlayerEntity));
        }
    }

    private static void fzg(MinecraftClient minecraftClient, int n, int n2, SlotActionType slotActionType) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        minecraftClient.interactionManager.clickSlot(clientPlayerEntity.currentScreenHandler.syncId, n, n2, slotActionType, (PlayerEntity)clientPlayerEntity);
        ++fyv;
    }

    private static void fzh(String string, boolean bl, ClientPlayerEntity clientPlayerEntity) {
        double d = fyw == 0 ? 0.0 : fyz / (double)fyw * 20.0;
        System.out.println(a.d("\u5b15\u22b6\ua879\u360c\ubdd9\u3b71\u8131\u0885", 935414950, 1024464860) + string + a.b("\ub594\ucc3f\u46af\ud8d1\u5303\ud5b8\u6fe3\ue60a\u7806\uf2fa\u7525\u8f51\u0187\u986e", 1423816096) + fyv + a.d("\u3e7b\u4799\ucd5c\u532d\ud8f1\u5e13", 601385455, 1102534578) + fyo.get() + a.b("\u671f\u1eed\u9431\u0a43\u8188\u072f\ubd6a\u34d5", 585066295) + fyp.get() + a.c(-1301177844, "\u9a20\ue3c7\u690b\uf77c\u7ca8\ufa14\u4052\uc9be\u57e7\udd57\u5a99\ua0a6") + fyq.get() + a.c(1451297089, "\u096b\u709d\ufa5c\u6431\uefdb\u6957\ud30e\u5af7\uc4b0\u4e4f") + fyw + a.d("\u9e2d\ue7cf\u6d1f\uf36c\u78a0\ufe16\u445f\ucd8e\u53ec\ud957\u5e8c\ua4e5\u2a7c", 327794909, -1483043) + fyx + a.c(-697959434, "\ufbdd\u8225\u08fb\u9682\u1d5c\u9bdc\u21b2\ua849\u361e\ubcb7\u3b2a") + fyy + String.format(a.d("\u00df\u793d\uf3ed\u6d89\ue65e\u60ee\udae4\u530d\ucd59\u47f4\uc073\u3a44\ub4d1\u2d2d\ua722", 375287929, 1427206281), d) + a.b("\ud04a\ua9b8\u237d\ubd0b\u36dd\ub070\u0a3e\u8380", -495660958) + clientPlayerEntity.currentScreenHandler.getCursorStack());
        if (!fyr.isEmpty()) {
            System.out.println(a.d("\u497a\u30d9\uba16\u2463\uafb6\u291e\u935e\u1aea", 311087375, 58562586) + string + a.b("\u797d\u009a\u8a56\u1421\u9ff5\u1949\ua30f\u2ae3\ub4ba\u3e0a\ub9c4\u43fc", 2126608721) + fyr);
        }
        if (fyo.get() != fyv || fyp.get() != 1) {
            ++fzb;
            System.out.println(a.b("\u4cb5\u3516\ubfd9\u21ac\uaa79\u2cd1\u9691\u1f25", 1040207066) + string + a.d("\u89d3\uf004\u7ad0\ue4a9\u6f7b\ue9a6\u53a5\uda45\u4418\ucea1\u497c\ub31c\u3dcc\ua42e\u2e31\ua8c3\u1290\u9d46\u07a1\u81bf\u0855\u7256\ufca1\u6761\ue11b\u6bd6\ud260\u5c3b\uc6ce\u408a\ucb28\u35f8", -1214472341, -1374546248));
        }
        if (bl) {
            if (fyq.get() != 0) {
                ++fzb;
                System.out.println(a.c(-1702930156, "\u597b\u20d8\uaa17\u3462\ubfb7\u391f\u835f\u0aeb") + string + a.b("\u1ad1\u6306\ue9d2\u77ab\ufc79\u7aa4\uc09a\u4953\ud715\u5dbc\uda72\u202b\uaede\u3778\ubd36\u3bc1\u818f\u0e43\u94a3\u12a5\u9b4a\ue101\u6fab\uf472\u7249\uf8de\u4167\ucf3b\u55ca", 955914988));
            }
            if (d < 4.0 || (double)fyx < (double)fyw * 0.7) {
                ++fzb;
                System.out.println(a.c(-288621834, "\ufa99\u833a\u09f5\u9780\u1c55\u9afd\u20bd\ua909") + string + a.c(-419089244, "\u349b\u4d4c\uc798\u59e1\ud233\u54ee\ueee9\u6703\uf95c\u73a2\uf422\u0e4c\u8098\u1931\u9335\u158d\uafc5\u205a\ubabd\u3cf0\ub50a\ucf1e\u41e4\uda32\u5c55\ud697\u6f2f\ue164\u7b88\ufdc4\u767c"));
            }
        } else if (fyq.get() == 0) {
            ++fzb;
            System.out.println(a.d("\u5e43\u27e0\uad2f\u335a\ub88f\u3e27\u8467\u0dd3", -2022943659, -1978791303) + string + a.d("\u77c8\u0e1f\u84cb\u1ab2\u9160\u17bd\uadad\u2450\uba0e\u30a5\ub770\u4d1c\uc3c8\u5a35\ud034\u56c2\uec96\u6309\uf9e9\u7faa\uf64b\u8c4d\u02b0\u9960\u1f50\u95d7\u2c7b\ua22c\u38d8\ube84\u3522\ucbee\u41a7\ud857\u5e19\ud4fb\u6b24\ue10f\u67cb\ufe7c\u742f\u0ac3\u8086\u0736\u9df6\u13d5\uaa44\u20e5\ua6b7\u3d62\ub31f\u49c5\uc023\u4664", 148357246, 1315092384));
        }
    }

    private static void fzi(boolean bl) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\u45cf\u3c4c\ub683\u28d6\ua323\u258b\u9fcb", 726156687));
        for (vmo vmo2 : kfe2.getSettings()) {
            vkl vkl2;
            if (!(vmo2 instanceof vkl) || !(vkl2 = (vkl)vmo2).getName().equals(a.b("\ufdac\u8432\u0efb\u9097\u1b09\u9dd5\u27be\uae56\u3011\ubabd\u3d46\uc715\u49d5\ud079\u5a2c\udcdc\u668e", -1766457860))) continue;
            vkl2.set(bl);
        }
    }

    private static void fzj(MinecraftClient minecraftClient) throws Exception {
        if (fzc) {
            return;
        }
        IntegratedServer integratedServer = minecraftClient.getServer();
        ServerPlayerEntity serverPlayerEntity = integratedServer.getPlayerManager().getPlayer(minecraftClient.player.getUuid());
        ClientConnection clientConnection = null;
        for (Field field : ServerCommonNetworkHandler.class.getDeclaredFields()) {
            if (field.getType() != ClientConnection.class) continue;
            field.setAccessible(true);
            clientConnection = (ClientConnection)field.get(serverPlayerEntity.networkHandler);
        }
        Channel channel = null;
        for (Field field : ClientConnection.class.getDeclaredFields()) {
            if (!Channel.class.isAssignableFrom(field.getType())) continue;
            field.setAccessible(true);
            channel = (Channel)field.get(clientConnection);
        }
        channel.pipeline().addBefore(a.b("\u1789\u6e29\ue4f8\u7a81\uf158\u77f8\ucd80\u4446\uda10\u50ae\ud777\u2d0e\ua3d0\u3a76", -947316745), a.d("\u2cff\u5544\udf94\u41fd\uca6f\u4cb3\uf6cb\u7f2b\ue162\u6bd4\uec2c\u1670\u98b0\u0107\u8b58\u0db4\ub7ed\u383d\ua299", -1162050249, 166242749), (ChannelHandler)new fyi());
        fzc = true;
        System.out.println(a.b("\u4f18\u36bb\ubc74\u2201\ua9d4\u2f7c\u953c\u1c88\u8285\u0823\u8ff6\u758b\ufb41\u62e6\ue8b4\u6e52\ud44f\u5bd1\uc163\u477c", 477777771) + channel.getClass().getSimpleName());
    }

    private static void fzk(Object object) {
        if (object instanceof PlayerInputC2SPacket) {
            PlayerInputC2SPacket playerInputC2SPacket = (PlayerInputC2SPacket)object;
            PlayerInput playerInput = playerInputC2SPacket.input();
            fys = playerInput.forward() || playerInput.backward() || playerInput.left() || playerInput.right() || playerInput.jump();
            fyt = playerInput.sneak();
        } else if (object instanceof ClientCommandC2SPacket) {
            ClientCommandC2SPacket clientCommandC2SPacket = (ClientCommandC2SPacket)object;
            if (clientCommandC2SPacket.getMode() == ClientCommandC2SPacket.Mode.START_SPRINTING) {
                fyu = true;
            } else if (clientCommandC2SPacket.getMode() == ClientCommandC2SPacket.Mode.STOP_SPRINTING) {
                fyu = false;
            }
        } else if (object instanceof ClickSlotC2SPacket || object instanceof CloseHandledScreenC2SPacket) {
            if (object instanceof ClickSlotC2SPacket) {
                fyo.incrementAndGet();
            } else {
                fyp.incrementAndGet();
            }
            if (fys || fyt || fyu) {
                fyq.incrementAndGet();
                if (fyr.length() < 400) {
                    fyr.append(a.c(-427077049, "\u5265\u2baf")).append(object.getClass().getSimpleName()).append(a.c(-330412030, "\u502a\u29d6\ua307\u3d6f\ub6a7\u3011\u8a4b\u03e0")).append(fys).append(a.d("\uad9a\ud478\u5eb6\uc0cc\u4b1f\ucda4\u77a1", -1539528017, -32045294)).append(fyt).append(a.c(-2105552321, "\ud217\uabf5\u2125\ubf56\u349a\ub22c\u0865\u81dd")).append(fyu).append(']');
                }
            }
        }
    }

    private static /* synthetic */ int sj(int n, int n2) {
        return n + n2 | 0x67C5FAC1;
    }

    private static /* synthetic */ int sk(int n, int n2) {
        return fyl.sj(n, n2) + n;
    }
}

