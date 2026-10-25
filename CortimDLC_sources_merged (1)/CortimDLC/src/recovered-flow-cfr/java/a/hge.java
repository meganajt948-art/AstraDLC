/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.util.Hand
 */
package a;

import flow.Flow;
import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

final class hge {
    private static final int hgf = 20;
    private static final int hgg = 5;
    private static int hgh;
    private static boolean hgi;
    private static /* synthetic */ int hgj;
    private static /* synthetic */ int hgk;

    private hge() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        PlayerInventory playerInventory;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (n == 1) {
            hge.hgp(minecraftClient, a.d("\ucea9\ub71e\u3dc1\ua3b8\u2867\uaed4\u148c\u9d7c\u0366\u8984\u0e51\uf427\u7af4\ue35a\u6916\ueff0\u55b2", -481329984, -1142836705));
            hge.hgp(minecraftClient, a.d("\udd3c\ua490\u2e47\ub03e\u3bac\ubd4e\u070b\u8eeb\u10e0\u9a47\u1d92\ue7e3\u6934", -912220701, 732512422));
            hge.hgp(minecraftClient, a.b("\u9523\uec91\u6642\uf830\u73e1\uf547\u4f40\uc6f6\u58a7\ud209\u55c9\uaffd\u214a\ub8c8\u32c8\ub474\u0e3f\u81e9\u1b51\u9d06\u14e0\u6ea2\ue016\u7bd5\ufde4\u777d\uced9\u409e\uda73\u5c38\ud78c\u2948\ua308\u3af4\ubca1\u3655\u8993\u03e1\u8530\u1c91\u96df\ue82f\u626c\ue589\u7f58\uf12e\u48ed", -70085271));
        }
        if (n == 20) {
            hge.hgl(minecraftClient, 20);
            Flow.getInstance().getModuleManager().getByName(a.c(1020377856, "\ubb49\uc2cc\u481e\ud674\u5d81\udb1c\u614d\ue8ba")).setEnabled(true);
        }
        if (n == 30) {
            hge.hgm(minecraftClient);
        }
        if (n > 30 && n < 110) {
            hge.hgn(clientPlayerEntity, a.d("\u7b8b\u023d\u88f6\u1694\u9d48\u1be3\ua1ab\u2847\ub613", 1654984789, -86479938), n);
        }
        if (n == 110) {
            playerInventory = clientPlayerEntity.method_31548();
            hge.hgo(hgi, a.b("\u21b4\u5802\ud2c9\u4cab\uc777\u41dc\ufb94\u7278\uec2c\u66de\ue117\u1b32\u95f9\u0c45\u8653\u00ef\ubaac\u357f\uafca\u29de\ua067\uda3d\u549d\ucf5f\u4937\uc3b4\u7a44\uf417\u6eec\ue8b5\u6343\u9ddb\u1793\u8e78\u0830\u82ce\u3d4d\ub720\u31fe\ua80a\u221d\u5ce5\ud6b9\u5102", -1615584783));
            hge.hgo(playerInventory.method_5438(20).method_31574(Items.field_49814), a.b("\uf6cc\u8f7a\u05b1\u9bd3\u100f\u96a4\u2cec\ua500\u3b54\ub1a6\u366f\ucc4a\u4281\udb3d\u512b\ud797\u6dd4\ue207\u78b2\ufea6\u7715\u0d49\u83f7\u182c\u9e1a\u1498\uad7f\u2369\ub996\u3f88\ub479\u4aab\uc0e6\u591f\udf07\u55e2\uea2e\u6010\ue6d1\u7f62\uf52d\u8bd4\u01db\u8676\u1cac\u92ca\u2b0e\ua1e0\u27b5", -625936748) + playerInventory.method_5438(20) + a.d("\udc75", 504865572, 563642233));
            hge.hgo(playerInventory.method_5438(0).method_31574(Items.field_49098), a.d("\u1a48\u63fe\ue935\u7757\ufc8b\u7a20\uc068\u4984\ud7d0\u5d22\udaeb\u20c9\uae01\u37b3\ubdfb\u3b5e\u8101\u0ec0\u943a\u1271\u9b9b\ue183\u6f63\uf4e6\u72cd\uf800\u41be\ucfaa\u550a\ud345\u58f1\ua62a\u2c21\ub593\u33cb\ub973\u06b7\u8cd3\u0a02\u93ec\u19a9", 2069072120, 228102896) + playerInventory.method_5438(0));
            hgi = false;
            hge.hgl(minecraftClient, 5);
        }
        if (n == 125) {
            hge.hgm(minecraftClient);
        }
        if (n > 125 && n < 205) {
            hge.hgn(clientPlayerEntity, a.d("\ue7c3\u9e75\u14bd\u8ada\u010e\u87ac", 863981644, 1016510433), n);
        }
        if (n == 205) {
            playerInventory = clientPlayerEntity.method_31548();
            hge.hgo(hgi, a.c(1226082837, "\u8a54\uf3e2\u792a\ue74d\u6c99\uea3b\u5020\ud9cb\u47c0\ucd6d\u4ab3\ub087\u3e1d\ua7a0\u2df1\uab06\u110c\u9e93\u042b\u8269\u0b8d\u71cb\uff2a\u64b8\ue2c5\u6818\ud1a3\u5fb7\uc509\u435f\uc8f6\u363c\ubc3c\u2599\ua3d6\u296a\u96f8\u1cc1\u9a1b\u03a5\u89f0"));
            hge.hgo(playerInventory.method_67532() == 0, a.d("\u7f00\u06b6\u8c7e\u1219\u99cd\u1f6f\ua574\u2c9f\ub294\u3839\ubfe7\u45d3\ucb57\u52f9\ud8a9\u5e43\ue458\u6bcd\uf173\u772f\ufed2\u84ca\u0a2a\u91af\u1793\u9d4e\u24ff\uaaa6\u3014\ub607\u3db7\uc364\u4923\ud099\u569e\udc34\u63ac\ue9cd\u6f14\uf6bf", -1707324956, 1523201700) + playerInventory.method_67532());
            hge.hgo(playerInventory.method_5438(5).method_31574(Items.field_49814), a.c(-2145105708, "\u48aa\u311c\ubbd4\u25b3\uae67\u28c5\u92de\u1b35\u853e\u0f93\u884d\u7279\ufce3\u655e\uef0f\u69f8\ud3f2\u5c6e\uc6df\u4097\uc973\ub323"));
            Flow.getInstance().getModuleManager().getByName(a.d("\ua3f4\uda71\u50a3\ucec9\u453c\uc3a1\u79f0\uf007", -593157387, -482311864)).setEnabled(false);
            System.out.println(a.c(-1110937726, "\u6ffa\u1655\u9c81\u02fa\u8969\u0f95\ub5ca\u3c39\ua260\u2894\uaf13\u5573\udbb2\u4204\uc803") + (hgh == 0 ? a.d("\u4a3c\u339c\ub95d\u272c", -348607848, 1845813488) : a.d("\u814d\uf8fb\u7220\uec54\u67ef\ue156", -2047406575, 1185124124) + hgh + a.d("\ueb0c", 1692605108, 1544810896)));
            return true;
        }
        return false;
    }

    private static void hgl(MinecraftClient minecraftClient, int n) {
        minecraftClient.method_1576().execute(() -> {
            ServerPlayerEntity serverPlayerEntity = minecraftClient.method_1576().method_3760().method_14566(minecraftClient.field_1724.method_5477().getString());
            serverPlayerEntity.method_31548().method_5448();
            serverPlayerEntity.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_49098, 16));
            serverPlayerEntity.method_31548().method_5447(1, new ItemStack((ItemConvertible)Items.field_8802));
            serverPlayerEntity.method_31548().method_5447(n, new ItemStack((ItemConvertible)Items.field_49814));
        });
        minecraftClient.field_1724.method_31548().method_61496(0);
    }

    private static void hgm(MinecraftClient minecraftClient) {
        minecraftClient.field_1724.method_36457(89.0f);
        minecraftClient.field_1724.field_6004 = 89.0f;
        minecraftClient.field_1761.method_2919((PlayerEntity)minecraftClient.field_1724, Hand.field_5808);
        minecraftClient.field_1724.method_6104(Hand.field_5808);
        System.out.println(a.b("\ucb26\ub289\u385d\ua626\u2db5\uab49\u1116\u98e5\u06bc\u8c48\u0bcf\uf1af\u7f6e\ue6d8\u6cc5\uea2e\u5035\udff8\u4551\uc31d\u4af2\u30ba\ube4b\u2596\ua3aa\u2977\u90c4\u1e96\u8469\u0233\u8998\u7750\ufd51", 900713328) + minecraftClient.field_1724.method_7357().method_7904(new ItemStack((ItemConvertible)Items.field_49098)));
    }

    private static void hgn(ClientPlayerEntity clientPlayerEntity, String string, int n) {
        boolean bl = clientPlayerEntity.method_6047().method_31574(Items.field_49814);
        hgi |= bl && !clientPlayerEntity.method_24828();
        if (n % 5 == 0) {
            System.out.println(a.c(-575122148, "\u5564\u2ccb\ua61f\u3864\ub3f7\u350b\u8f54\u06a7\u98fe\u120a\u958d\u6fed\ue12c\u789a\uf29d") + string + a.b("\u0a94\u7371\uf9eb", 465308343) + n + a.b("\u66c9\u1f3f\u95f9\u0b95\u8058\u06f2\ubcab\u3503", 1157261025) + clientPlayerEntity.method_24828() + a.b("\u6411\u1df9\u976e", -2058394574) + String.format(Locale.ROOT, a.b("\u9bf1\ue24b\u6884\uf6a1", 328506320), clientPlayerEntity.method_23318()) + a.d("\udd06\ua4ff\u2e21\ub059\u3b86\ubd6e", 329127786, -1195718070) + clientPlayerEntity.method_31548().method_67532() + a.c(-1910086354, "\u6508\u1cf1\u962b\u0855\u8388\u0560") + clientPlayerEntity.method_6047().method_7909());
        }
    }

    private static void hgo(boolean bl, String string) {
        if (!bl) {
            ++hgh;
            System.out.println(a.b("\udd99\ua436\u2ee2\ub099\u3b0a\ubdf6\u07a9\u8e5a\u1003\u9af7\u1d70\ue710\u69d1\uf067\u7a60\ufcd2\u4696\uc94a\u53ff\ud5a6\u5c1a\u260d\ua8b9\u3360\ub51a\u3fc2\u8670\u087f\u9292", 1924652531) + string);
        }
    }

    private static void hgp(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static /* synthetic */ int zt(int n, int n2) {
        return n * n2 | 0xCA5D47A0;
    }
}

