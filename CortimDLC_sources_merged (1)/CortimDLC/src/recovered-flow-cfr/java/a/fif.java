/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.hud.ChatHud
 *  net.minecraft.client.gui.hud.ChatHudLine
 *  net.minecraft.client.gui.hud.ChatHudLine$Visible
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.text.Text
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.hhf;
import a.hlc;
import a.hyz;
import a.iov;
import a.kfe;
import a.kfx;
import a.vmo;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

final class fif {
    private static BlockPos fig;
    private static Entity fih;
    private static Entity fii;
    private static String fij;
    private static /* synthetic */ boolean fik;
    private static /* synthetic */ String fil;

    private fif() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        Object object;
        Object object2;
        kfx kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            fif.fja(minecraftClient, a.b("\uabba\ud20d\u58d2\uc6ab\u4d74\ucbc7\u719f\uf86f\u6675\uec87\u6b45\u9123\u1ff0\u8654\u0c1a\u8af4\u30a8", 207137740));
            fif.fja(minecraftClient, a.d("\ue8ec\u9140\u1b97\u85ee\u0e7c\u889e\u32db\ubb3b\u2530\uaf97\u2842\ud233\u5ce4", -225443667, -1782716360));
            fif.fja(minecraftClient, a.b("\u1141\u68ff\ue225\u7c50\uf794\u7177\ucb44\u4286", 1142034730));
            fif.fja(minecraftClient, a.b("\ufa7b\u83c4\u0908\u976a\u1cf8\u9a29\u2049\ua9eb\u37f9\ubd4c\u3a98\uc0e2\u4e33\ud793\u5dd3\udb25\u6178\ueee7\u741e\uf24a\u7bba\u01e9\u8f46\u149e\u92db\u1826\ua18e\u2fc2\ub52c\u337a\ub8c7\u4601\ucc63\u55af\ud3f1\u5957\ue6a3\u6ce4\uea33\u7385\uf9d1\u8726\u0d64\u8ac6\u1016\u9e75\u27e8\uad00\u2b43\ub093\u3efa\uc43e\u4d81\ucbd7\u512f\udf69\u6499\ue22e\u687d\uf1a4\u7f0c\u055e\u82b6\u08a9\u966c\u1fc1\ua5d7\u233b\ua97d\u36c4\ubc40\u3a70\uc3bd\u4901\ud70c\u5ce5\udafd\u6048\ue99c\u77e6\ufd2f\u7b6f\u00cf\u8e19\u147c\u9de3\u1b0e\ua152\u2ea5\ub4f8\u3249\ubb99\u41e4\ucf73\u54ce\ud2d0\u5813\ue678\u6fb0\uf51b\u7302\uf8fa\u86a8\u0c56\u9589\u13a9\u992d\u2694\uacdc\u2a2e\ub066\u3999\uc758\u4d11\ucaa7\u50eb\ude4d\u6794\uedb0\u6b20\uf08d\u7ed1\u047c\u8235\u0bcd\u9118\u1f6c\ua4b6\u22ff\ua85f\u319f\ubfe9\u452c\uc2d3\u48dd\ud624\u5c78\ue5c1\u6313\ue969\u768f\ufc00\u7a42\u03b3\u89e0\u1738\u9ccc\u1a93\ua02b\u2e76\ub7df\u3d15\ubb70\u40ef\uce53\u544a\uddbd\u5bbd\ue159\u6e80\uf4d0\u7222\uf86a\u8195\u0f49\u953a\u12f6\u9802\u2640\uafa0\u35fb\ub31d\u388b\uc6e8\u4c36\ud5d9\u538e\ud910\u6767\uecb1\u6a0d\uf05a\u79b8\u07fa\u8d42\u0a81\u90bc\u1e39\ua785\u2dc5\uab2a\u3176\ubeae\u4404\uc24a\u4baa\ud1c7\u5f5a\ue48d\u62e4\ue826\u7181\uff94\u856b\u0373\u88ce\u1607\u9c6d\u25b8\ua3a7\u291f\ub682\u3cf5\uba75\u4391\uc9c8\u5728\udd7a\u5ad2\ue04d\u6e32\uf7e1\u7d4e\ufb5a\u8088\u0ee8\u9433\u1dd5\u9bc3\u2120\uaf7e\u3491\ub256\u3868\uc1bf\u4f09\ud555\u52a2\ud8e0\u6642\uef8a\u75c9\uf374\u797a\u06c6\u8c1d\u0a6f\u93a9\u193b\ua745\u2ca3\uaaf6\u3052\ub99d\u47a0\ucd7f\u4b7f\ud0c2\u5e0b\ue461\u6dac\ueb53\u710b\ufefd\u84e9\u0258\u8bab\u11da", -333055216));
            fif.fiv(kfx2, a.d("\u690b\u1081\u9a4f\u0427\u8ff7\u0948\ub30c\u3adf\ua4a2\u2e04\ua9c4\u53aa\udd71\u44d2", -2075972373, 2075215293), true);
        }
        if (n == 6) {
            fif.fja(minecraftClient, a.d("\u76ef\u0f58\u8587\u1bfe\u9021\u1692\uacca\u253a\ubb20\u31c2\ub617\u4c61\uc2b2\u5b1c\ud150\u57b6\uedf4", 314341314, 1850278235));
        }
        if (n == 12) {
            minecraftClient.method_1507((Screen)new InventoryScreen((PlayerEntity)minecraftClient.field_1724));
        }
        if (n == 16) {
            fif.fin(minecraftClient, Items.field_8816);
        }
        if (n == 24) {
            fif.fjb(minecraftClient, a.c(173509584, "\u8ba6\uf21c\u78c2\ue6a5\u6d75\ueb9d\u5190\ud87a\u4638\ucc90\u4b44\ub13b\u3ffb\ua615\u2c1b\uaae8\u10b0\u9f72\u05de\u8383\u0a66"));
            minecraftClient.method_1507(null);
            fif.fja(minecraftClient, a.d("\u313c\u4882\uc258\u5c2d\ud7e9\u510a\ueb39\u62fb", 1367866398, -192950967));
            fif.fja(minecraftClient, a.c(-1932172771, "\u626b\u1bdc\u9103\u0f7a\u84a5\u0216\ub84e\u31be\uafa4\u2556\ua294\u58f2\ud621\u4f85\uc5cb\u4325\uf979"));
        }
        if (n == 30) {
            object2 = minecraftClient.field_1724.method_24515().method_10069(2, 0, 0);
            fig = object2;
            fif.fja(minecraftClient, a.d("\u3be2\u4245\uc887\u56e0\udd39\u5b8b\ue1d4\u682d\uf639", 2129240152, 160078784) + object2.method_10263() + a.b("\uf3d8", -2004093959) + object2.method_10264() + a.c(2866349, "\ubc8c") + object2.method_10260() + a.c(-110723571, "\u7eeb\u0717\u8dc0\u13b6\u986a\u1edd\ua49f\u2d7d\ub325\u3986\ube1b\u4433\ucaef\u5353\ud916\u5fe0\ue5a0\u6a43\uf0cd\u768d\uff72\u853d\u0bc7\u9077\u1628\u9cd1\u255d\uab0f\u31e3\ub7fc\u3c45\uc2c6\u48c7\ud173\u572d\uddc2\u620d\ue833\u6ee4\uf752\u7d06\u03f1\u89b3\u0e11\u94c1\u1aa2\ua33f\u29d0\uaf92\u344b\uba34\u40e7\uc951\u4f0a\ud5bf\u5be0\ue010\u66cd\ueca4\u756e\ufbc3\u81dc\u0624\u8c76\u12f6\u9b16\u2112\ua7cb\u2da3\ub211\u38d9\ubee6\u4736\ucdd0\u53cd\ud879\u5e23\ue4cc\u6d07\uf339\u79f2\uffa4\u841c\u0acb\u90ad\u196f\u9fdb\u2598\uaa29\u3026\ub698\u3f52\uc523\u4ba4\ud019\u5607\udcc4\u62af\ueb67\u71cc\uf7d5\u7c2a\u027d\u8881\u110f\u9729\u1dd2\ua25c\u2808\uaee2\u34ff\ubd4d\u43d9\uc9c6\u4e70\ud42c\u5ac5\ue30c\u6930\uefe5\u745d\ufa07\u80f2\u06b2\u8f16\u15c0\u9ba1\u203e\ua622\u2c88\ub546\u3b36\uc1d0\u4657\ucc03\u52fb\ud8ac\u6106\ue783\u6dfc\uf264\u78d9\ufe90\u877a\u0d2f\u93b0\u180b\u9e58\u24e2\uaae2\u3306\ub9ff\u3fbf\uc46d\u4ac5\ud0da\u5925\udf76\u6597\uea08\u7002\uf6fe\u7cf3\u055a\u8bc2\u11b7\u9663\u1cd9\ua280\u2b60\ub120\u3796\ubc53\u426c\uc8e2\u515b\ud717\u5dce\ue3bc\u6866\ueee0\u748f\ufd6d\u833c\u099f\u8e47\u1473\u9aac\u2354\ua909\u2fe0\ub5aa\u3a7f\uc080\u46da\ucf65\u5512\udb83"));
            fif.fiv(kfx2, a.b("\u8d2a\uf4b0\u7e6e\ue009\u6bd9\ued4f\u573b\udedb\u4080\uca3c\u4de6\ub780", 561745253), true);
        }
        if (n == 36) {
            fif.fim(minecraftClient, fig);
        }
        if (n == 60) {
            System.out.println(a.b("\u1daa\u6410\ueece\u70a9\ufb79\u7d9c\uc79c\u4e6a\ud024\u5a91\udd4f\u2737\ua9f7\u300e\uba47\u3ce5\u86ba\u097a\u93de\u158f\u9c73\ue671", 14556639) + (minecraftClient.field_1755 == null ? a.b("\u6c3b\u1585\u9f55\u0138\u8af9\u0c49", -2021299106) : a.b("\u8a7c\uf3d2\u7914\ue76e", 2054261271)) + a.d("\u514c\u28b9\ua267\u3c1e\ub7c5\u3176\u8b24\u02df\u9c97\u1668", -1798172765, -2130026811) + fif.fio(minecraftClient, Items.field_8477) + a.b("\u1d48\u64bd\uee63\u7009\ufbd8\u7d20", -578937490) + fif.fio(minecraftClient, Items.field_8831) + a.d("\ua4ab\udd53\u579b\uc9f7\u4221\uc4c3", -1972879567, -2090034244) + fif.fio(minecraftClient, Items.field_8620) + a.b("\ua1f6\ud806\u52c4\uccb5\u477e\uc1c6\u7b83\uf23c", 1144824286) + fif.fio(minecraftClient, Items.field_8463));
            fif.fiv(kfx2, a.b("\u281d\u5187\udb59\u453e\uceee\u4878\uf20c\u7bec\ue5b7\u6f0b\ue8d1\u12b7", -2128271278), false);
            minecraftClient.method_1507(null);
            fif.fja(minecraftClient, a.b("\ud275\uabcb\u2111\ubf64\u34a0\ub243\u0870\u81b2", -163130850));
        }
        if (n == 66) {
            object2 = fig;
            fif.fja(minecraftClient, a.d("\u93b1\uea16\u60d4\ufeb3\u756a\uf3d8\u4987\uc07e\u5e6a", 2060766837, 473128382) + object2.method_10263() + a.b("\uda3d", 1904728604) + object2.method_10264() + a.c(1633796232, "\uc0a9") + object2.method_10260() + a.c(1510773586, "\u937c\uea80\u6057\ufe21\u75fd\uf34a\u4908\uc0ea\u5eb2\ud411\u538c\ua9a6\u2779\ubed3"));
            fif.fja(minecraftClient, a.d("\u5cff\u2558\uaf9a\u31fd\uba24\u3c96\u86c9\u0f30\u9124", -871067743, 451597092) + object2.method_10263() + a.c(1801728485, "\u31c4") + object2.method_10264() + a.c(1549442587, "\u9e3a") + object2.method_10260() + a.d("\u70a0\u095c\u838b\u1dfd\u9621\u1096\uaad4\u2336\ubd6e\u37cd\ub050\u4a78\uc4a4\u5d18\ud75d\u51ab\uebeb\u6408\ufe86\u78c6\uf139\u8b76\u058c\u9e3c\u1863\u929a\u2b16\ua544\u3fa8\ub9b7\u320e\ucc8d\u468c\udf38\u5966\ud389\u6c46\ue678\u60af\uf919\u734d\u0dba\u87f8Z\u9a8a\u14e9\uad74\u279b\ua1d9\u3a13\ub466\u4ee1\uc758\u4146\udbb9\u55f2\uee56\u689d\ue2a0\u7b79\uf5cc\u8fd0\u0872\u8274\u1c93\u951d\u2f4d\ua9a7\u23be\ubc06\u3684\ub0bb\u4921\uc39d\u5d90\ud679\u5061\uead4\u6300\ufd7a\u77b3\uf1f3\u8a53\u0485\u9ee0\u177f\u9192\u2bce\ua439\u3e64\ub8d5\u3105\ucb78\u4592\ude0d\u5858\ud28f\u6ce3\ue526\u7fd1\uf988\u7236\u0c69\u86c2\u1f06\u996d\u13f0\uac4a\u2651\ua0f1\u3af5\ub36c\u4d9c\uc7ce\u4026\uda39\u5483\ued07\u673a\ue1ae\u7a1c\uf413\u8ef8\u08e6\u8155\u1b83\u95fb\u2e2c\ua872\u22d0\ubb04\u3567\ucffe\u4811\uc24f\u5ca5\ud6fc\u6f1b\ue9c6\u63f8\ufc23\u7688\uf0c0\u892b\u032a\u9df2\u1642\u905e\u2af8\ua4fe\u3d65\ub78b\u31f7\uca3d\u44c0\ude93\u573e\ud121\u6bd7\ue40b\u7e1a\uf8f3\u72ef\u0b5a\u858a\u1ff0\u9825\u1285\uacc9\u253f\ubf7e\u3981\ub20e\u4c6f\uc6ab\u5f1e\ud954\u53c3\uedbe\u6620\ue09b\u7ad0\uf338\u8d73\u0782\u805c\u1a67\u94e7\u2d07\ua77e\u21b2\ubbe0\u3434\ucecb\u4893\uc161\u5b66\ud599\u6e0f\ue873\u62f2\ufb5b\u7547\u0fb2\u89e2\u0258\u9c8d\u16ed\uaf31\u2967\ua3c6\u3c59\ub67d\u30b7\uc919\u4349\udd87\u57e1\ud05f\u6a87\ue4f1\u7d28\uf78a\u718d\u0a4c\u8472\u1ead\u9706\u114a\uaba1\u25bc\ube06\u3895\ub2b5\u4b31\uc5a8\u5fc0\ud832\u527a\uec85\u6541\uff15\u79b0\uf3af\u8c5d\u0681\u80ac\u1965\u9395\u2dc0\ua634\u206e\ubadf\u331f\ucd7f\u47a9\uc1f4\u5a0b\ud491\u6ee7\ue72b\u619b\ufbc3\u7475\u0e24\u88da\u0105\u9b6e\u15a2\uae09\u2814\ua2e9\u3ca4\ub53c\u4fde\uc9d8\u4207\udc69\u56d9\uef13\u6922\ue3f8\u7c43\uf649\u70f0\u0ae4\u835a\u1dd5\u9782\u103c\uaa6b\u24dd\ubd01\u3776\ub1b4\u4a16\uc44e\u5ead\ud8b0\u515f\ueb85\u65fc\ufe23\u7890\uf2de\u8b05\u054d\u9fb3\u181d\u9246\u2cbd\ua6e6\u3f40\ub98c\u33b8\ucc67\u469f\uc0c2\u592b\ud361\u6db4\ue64b\u6013\ufaae\u74a8\u0d4e\u87b5\u01fb\u9a27\u148d\uae90\u2769\ua139\u3bdf\ub442\u4e76\uc8b4\u42bb\udb10\u558e\ueffd\u682b\ue293\u7cc4\uf52a\u8f68\u09dc\u821f\u1c26\u96af\u2f0c\ua94a\u2381\ubdf5\u3660\ub0df\u4ac7\uc33a\u5d73\ud7d9\u501c\uea23\u64fd\ufd06\u7771\uf1a0", 282150851, -488229331));
            fif.fiv(kfx2, a.b("\ubfac\uc636\u4ce8\ud28f\u595f\udfc9\u65a6\uec4a\u7213\uf8b3\u7f77", -1004027932), true);
        }
        if (n == 72) {
            fif.fim(minecraftClient, fig);
        }
        if (n == 80) {
            fif.fjb(minecraftClient, a.c(1964535088, "\u6d40\u14fa\u9e24C\u8b93\u0d7b\ub776\u3e9b\ua0d9\u2a6e\uadac\u57ca\ud942\u40bc\ucae8\u4c1a\uf65c\u7990\ue334"));
            fif.fis(kfx2.getByName(a.c(1204846593, "\u8049\uf9d3\u730d\ued6a\u66ba\ue02c\u5a43\ud3af\u4df6\uc756\u4092")), a.b("\u3b59\u42ef\uc829\u564b\udd9a", 2145663791), minecraftClient);
        }
        if (n == 110) {
            fif.fjb(minecraftClient, a.b("\u66a1\u1f1b\u95c5\u0ba2\u8072\u069a\ubc97\u357a\uab38\u218f\ua64d\u5c2b\ud2a3\u4b5e\uc10a\u47e9\ufdb7\u7271", 896165584));
            System.out.println(a.b("\u720a\u0bb0\u816e\u1f09\u94d9\u123c\ua83c\u21d1\ubf93\u3524\ub2e6\u4880\uc61f\u5fb4", 1040740967) + fif.fip(minecraftClient));
            minecraftClient.method_1507(null);
            fif.fiv(kfx2, a.c(1348343858, "\u187a\u61e0\ueb3e\u7559\ufe89\u781f\uc270\u4b9c\ud5c5\u5f65\ud8a1"), false);
        }
        if (n == 116) {
            object2 = fig;
            fif.fja(minecraftClient, a.c(386438221, "\u9437\ued90\u6752\uf935\u72ec\uf45e\u4e01\uc7f8\u59ec") + object2.method_10263() + a.c(-688413037, "\ua6b2") + object2.method_10264() + a.b("\uf478", -845548455) + object2.method_10260() + a.d("\u875c\ufea0\u7477\uea01\u61dd\ue76a\u5d28\ud4ca\u4a92\uc031\u47ac\ubd86\u3359\uaaf3", 1887709742, -117789348));
            fif.fja(minecraftClient, a.d("\ua067\ud9c0\u5302\ucd65\u46bc\uc00e\u7a51\uf3a8\u6dbc", -1279546496, -1234302051) + object2.method_10263() + a.d("\u01dc", 1366860489, -1351834828) + object2.method_10264() + a.c(1809519062, "\u11f7") + object2.method_10260() + a.c(98135950, "\u6f65\u1699\u9c4e\u0238\u89e4\u0f53\ub511\u3cf3\ua2ab\u2808\uaf95\u55bd\udb61\u42dd\uc898\u4e6e\uf42e\u7bcd\ue143\u6703\ueefc\u94b3\u1a49\u81f9\u07a6\u8d5f\u34d3\uba81\u206d\ua672\u2dcb\ud348\u5949\uc0fd\u46a3\ucc4c\u7383\uf9bd\u7f6a\ue6dc\u6c88\u127f\u983d\u1f9f\u854f\u0b2c\ub2b1\u385e\ube1c\u25c5\uabba\u5169\ud8df\u5e84\uc431\u4a6e\uf19e\u7743\ufd2a\u64e0\uea4d\u9052\u17a2\u9db7\u0329\u8acf\u30b4\ub67a\u3c2e\ua384\u2919\uaf66\u56ef\udc10\u4206\uc9fa\u4ff3\uf55a\u7cc6\ue2b3\u687b\uee21\u9594\u1b54\u8130\u08e6\u8e47\u3458\ubbf9\u21a5\ua70d\u2eda\ud4fb\u5a24\uc1d8\u4785\ucd50\u733a\ufaf3\u600c\ue655\u6da0\u13be\u995e\u00d6\u868f\u0c63\ub3d1\u399d\ubf22\u257a\uacca\u5257\ud848\u5ffe\uc5a2\u4b4b\uf282\u78be\ufe6b\u65d3\ueb89\u917c\u173c\u9e98\u044e\u8a2f\u31b0\ub7b1\u3d1b\ua4d3\u2ab3\ud06c\u57ef\udd8c\u4374\uc912\u7089\uf641\u7c3a\ue3f0\u6951\uef05\u96fd\u1cf7\u8228\u09d4\u8f89\u3564\ubb2e\u2287\ua818\u2e6c\ud5f1\u5b13\uc115\u48ca\ucea4\u7414\ufbde\u61df\ue725\u6d71\u1494\u9a0d9\u87e7\u0d08\ub34f\u3af1\ua0a6\u2610\uadcc\u53bb\ud979\u40db\uc693\u4c50\uf26d\u79e5\uff5e\u6502\uecf1\u92ae\u1818\u9fdf\u05ab\u8b61\u32d7\ub88d\u3e39\ua466\u2be6\ud15b\u5712\udef8\u44b5\uca4a\u7195\uf7e6\u7d70\ue4e1\u6a92"));
            fif.fja(minecraftClient, a.c(369407242, "\ub561\uccdf\u4605\ud870\u53b4\ud557\u6f64\ue6a6"));
            fif.fiv(kfx2, a.c(448261760, "\ueec8\u9752\u1d8c\u83eb\u083b\u8eb2\u34c2\ubd33\u2377\ua9d7\u2e13"), true);
        }
        if (n == 122) {
            fif.fim(minecraftClient, fig);
        }
        if (n == 128) {
            fif.fis(kfx2.getByName(a.b("\u7491\u0d0b\u87d5\u19b2\u9262\u14eb\uae9b\u276a\ub92e\u338e\ub44a", 1281520857)), a.b("\u7992$\u8ae2\u1480\u9f51", 1417771492), minecraftClient);
        }
        if (n == 134) {
            fif.fjb(minecraftClient, a.d("\ub245\ucbff\u4121\udf46\u5496\ud27e\u686c\ue19e\u7fc1\uf56b\u72a9\u88cf\u0647\u9fac\u15e7\u930b\u295d\ua68e\u3c3a\uba62", 1296996773, 1039018903));
        }
        if (n == 150) {
            System.out.println(a.d("\u4b97\u322d\ub8f3\u2694\uad44\u2ba1\u91be\u184c\u8613\u0cb9\u8b7b\u711d\uff82\u6629\uec29\u6ac8\ud096\u5f50\uc5e3\u43b9\uca1d", 1955760665, 2022228472) + (minecraftClient.field_1755 == null ? a.b("\u8f00\uf6be\u7c6e\ue203\u69c2\uef72", -1935241371) : a.d("\udcf0\ua55e\u2f98\ub1e2", 1631335569, 1422387210)) + a.d("\u736a\u0a9f\u8041\u1e38\u95e3\u1350\ua902\u20f9\ubeb1\u344e", 1523404914, -754375886) + fif.fio(minecraftClient, Items.field_8477) + a.c(-464378449, "\u2587\u5c62\ud6aa\u48c0\uc306\u45bf\ufff2\u764d") + fif.fio(minecraftClient, Items.field_8288) + a.d("\u857e\ufc8b\u7655\ue83f\u63ee\ue516", -572141831, -1467069535) + fif.fio(minecraftClient, Items.field_8831) + a.d("\u82d9\ufb2b\u71f4\uef88\u645f\ue2e0\u58ba\ud113", -246286408, -1023576759) + fif.fio(minecraftClient, Items.field_20412));
            minecraftClient.method_1507(null);
            fif.fiy(minecraftClient, Vec3d.method_24953((Vec3i)fig));
        }
        if (n == 158) {
            fif.fjb(minecraftClient, a.b("\u2e5d\u57e7\udd39\u435e\uc88e\u4e66\uf474\u7d86\ue3d9\u6973\ueeb1\u14d7\u9a5f\u03ae\u89f1\u0f13\ub545", -626643409));
            fif.fiv(kfx2, a.d("\u0f3b\u76a1\ufc7f\u6218\ue9c8\u6f41\ud531\u5cc0\uc284\u4824\ucfe0", 263478697, -1575857446), false);
            fif.fja(minecraftClient, a.b("\u5af4\u2353\ua991\u37f6\ubc2f\u3a9d\u80c2\u093b\u972f", -2129700210) + fig.method_10263() + a.b("\u30d8", 79704313) + fig.method_10264() + a.b("\ub69f", 228505278) + fig.method_10260() + a.b("\udb25\ua2d9\u280e\ub678\u3da4\ubb13\u0151\u88b3\u16eb\u9c48\u1bd5\ue1ff\u6f20\uf68a", -1963140341));
            fif.fja(minecraftClient, a.c(195528627, "\u87d8\ufe66\u74bc\ueac9\u610d\ue7ee\u5ddd\ud41f"));
        }
        if (n == 162) {
            fif.fiv(kfx2, a.d("\u34a1\u4d3b\uc7e1\u5985\ud272\u54e0\ueea1\u6754\uf901\u73a8", 402401470, -1771299754), true);
        }
        if (n == 164) {
            int n2;
            object2 = minecraftClient.field_1705.method_1743();
            for (n2 = 0; n2 < 150; ++n2) {
                object2.method_1812((Text)Text.method_43470((String)(a.c(-681165657, "\u3cee\u457a\ucfae\u51d4\uda46") + n2)));
            }
            for (n2 = 0; n2 < 3; ++n2) {
                object2.method_1812((Text)Text.method_43470((String)a.c(-2115286170, "\u4f5d\u36f2\ubc2e\u2253\uad94\u2b29\u9565\u1c95\u82ce\u0806\u8fa9\u75d7\ufb09\u62c3\ue8e7\u6a03\ud451\u5b8d\uc52e\u471e\uce9d\ub4b9\u3a78\ua1ae\u27a4\uad00")));
            }
            object = fif.fiq((ChatHud)object2);
            System.out.println(a.d("\ub04f\uc9f5\u432f\udd4b\u56c8\ud02d\u6a7d\ue39e\u7dc5\uf77e\u70b5\u8a8d\u0440\u9dba\u17e7\u9103\u2b48\ua4cd", 807730501, 1216957819) + object.size() + a.d("\ua780\ude7c\u54a7\ucac0\u4117\uc7b4\u7de1\uf412\u6a5b\ue0b5\u676a\u9d55\u1389\u8a2ak\u868c\u3cc4\ub341\u29f5", -1022682740, -475087297) + ((ChatHudLine)object.get(0)).comp_893().getString() + a.d("\u1fc5\u667f\ueca0\u729d\uf94f\u7ff9\uc5a1\u4c46\ud24a", -1149951363, -944161386) + fif.fir((ChatHud)object2).size() + a.b("\u98eb", 1577162954) + fif.fir((ChatHud)object2).getClass().getSimpleName());
            minecraftClient.method_1507((Screen)new ChatScreen("", false));
        }
        if (n == 166 || n == 169) {
            System.out.println(a.c(-1186849806, "\u1b87\u623d\ue8e7\u7683\ufd00\u7be5\uc1b5\u4856\ud60d\u5cb6\udb7d\u215f\uafdb\u367a\ubc38\u3ade\u8091\u0f4b\u95b6\u13a6\u9a44\ue041") + n + a.d("\ubc37\uc59c", 1969303861, 245140794) + (minecraftClient.field_1755 == null ? a.d("\u0939\u7089\ufa5b\u6421", -973858005, 194908792) : minecraftClient.field_1755.getClass().getSimpleName()) + a.b("\u35b3\u4c0e\uc691\u58e5\ud335\u558f\uefca\u6668", 68892055) + fif.fir(minecraftClient.field_1705.method_1743()).size());
        }
        if (n == 170) {
            fif.fjb(minecraftClient, a.c(-1925541517, "\u911b\ue8a1\u627b\ufc1f\u7791\uf179\u4b29\uc2ca\u5c91\ud62a\u51e1"));
            object2 = kfx2.getByName(a.b("\u6a39\u13a3\u9979\u071d\u8cea\u0a78\ub039\u39cc\ua799\u2d30", 524446320));
            object = object2.getClass().getDeclaredMethod(a.d("\u84db\ufd62\u77a7\ue9d6\u6213\ue4a4\u5ef5\ud720\u494a", 2111643906, 1305454013), Double.TYPE, Double.TYPE);
            ((Method)object).setAccessible(true);
            double d = (Double)minecraftClient.field_1690.method_42554().method_41753();
            int n3 = (int)Math.floor((double)(minecraftClient.method_22683().method_4502() - 40) / d);
            Object object3 = ((Method)object).invoke(null, 20.0, (double)(n3 - 4) * d);
            System.out.println(a.d("\u3ec5\u477f\ucda5\u53c1\ud842\u5ea7\ue4f7\u6d14\uf34f\u79f4\ufe3f\u041d\u8a89\u1334\u9978\u1f80\ua58c\u2a47\ub0f3", -1962282622, -1330786505) + object3 + a.c(1202349313, "\u6527"));
            minecraftClient.method_1507(null);
            ChatHud chatHud = minecraftClient.field_1705.method_1743();
            chatHud.method_1808(true);
            chatHud.method_1817();
            System.out.println(a.b("\ude97\ua72d\u2df7\ub393\u3810\ubef5\u04a5\u8d46\u131d\u99a6\u1e6d\ue44f\u6ad9\uf36f\u792e\uffce\u4596\uca15\u50e5\ud6bb\u5f45\u2510\uabb0\u3029\ub64c", -389292307) + fif.fiq(chatHud).size() + a.c(-1494725803, "\u4b7c\u3280\ub85b\u263c\uadeb\u2b48\u911d\u18ee\u86a7"));
            fif.fiv(kfx2, a.b("\ub606\ucf9c\u4546\udb22\u50d5\ud647\u6c06\ue5f3\u7ba6\uf10f", -341789105), false);
        }
        if (n == 176) {
            fif.fix(minecraftClient, 0.0f, 0.0f);
            fih = fif.fit(minecraftClient, a.c(-1284904675, "\ue953\u90c6\u1a16\u8472\u0fbd"), 1.8);
            fii = fif.fit(minecraftClient, a.b("\u7429\u0db3\u876b\u1912\u92d1", 1425962089), 2.9);
            hhf.add(a.c(-2040056073, "\u36b9\u4f2c\uc5fc\u5b98\ud057"));
        }
        if (n == 180) {
            Entity entity;
            minecraftClient.field_1773.method_3190(1.0f);
            Object object4 = minecraftClient.field_1765;
            if (object4 instanceof EntityHitResult) {
                object = (EntityHitResult)object4;
                entity = object.method_17782();
            } else {
                entity = null;
            }
            object2 = entity;
            object = kfx2.getByName(a.d("\uaba2\ud235\u58fd\uc682\u4d55\ucbe6\u71a2\uf863\u6611\uecbb", 1548838014, 447270786));
            object4 = fif.fis(object, a.b("\ub986\uc038\u4aec\ud497\u5f70\ud9f4\u63b4\uea50\u740d\ufead", 745191914), minecraftClient);
            System.out.println(a.c(980182986, "\u67a0\u1e0d\u94c4\u0aa8\u8165\u07c6\ubd9a\u3423\uaa3a\u209f\ua757\u5d2a\ud3f6\u4a4d\uc009\u46b1\ufce4\u7376\ue9d4\u6f98\ue673\u9c22\u128a\u8952\u0f25\u85ef\u3c0e\ub210\u28e6\uaef9") + fif.fiu((Entity)object2) + a.b("\u5c80\u253d\uafba\u31de\uba1a\u3cbe\u86ef\u0f0f\u9104", -792830811) + fif.fiu((Entity)object4) + a.b("\u2f6d\u56d4\udc4a\u4226\uc9f9\u4f5d\uf508\u7cee\ue2a0\u6810\uef87\u1593\u9b6f\u02d5\u888e\u0e6b\ub474", 650194780));
            hhf.remove(a.b("\uca74\ub3e1\u3931\ua755\u2c9a", 68340282));
            minecraftClient.field_1687.method_2945(fih.method_5628(), Entity.RemovalReason.field_26999);
            minecraftClient.field_1687.method_2945(fii.method_5628(), Entity.RemovalReason.field_26999);
        }
        if (n == 184) {
            fij = iov.PRESET.get();
            iov.PRESET.set(a.c(1369827103, "\ue755\u9ede\u1416\u8a60\u01a0\u8713\u3d45\ub4af\u2af5"));
            fif.fiz(minecraftClient, a.c(1776921711, "\uac3e\ud5b3\u5f6d\uc114\u4acb"));
        }
        if (n == 204) {
            fif.fjb(minecraftClient, a.b("\u6cb5\u1518\u9fc6\u01bf\u8a60\u0c99\ub684\u3f6f\ua12b\u2b9d\uac59\u562a\ud8f8\u4152\ucb04", 901147854));
            iov.PRESET.set(a.b("\uaeb7\ud72e\u5df5\uc393\u4857\uceeb\u74b0", 709996277));
        }
        if (n == 220) {
            fif.fjb(minecraftClient, a.d("\u9866\ue1cb\u6b15\uf56c\u7eb3\uf84a\u4251\ucba8\u55ff\udf59\u5899\ua2e5\u2c3a", -40113443, -1288408382));
            iov.PRESET.set(a.d("\u043c\u7db2\uf760\u690c\ue2ca", -1759562574, 1095905500));
        }
        if (n == 236) {
            fif.fjb(minecraftClient, a.c(-1439165110, "\u1535\u6c98\ue646\u783f\uf3e0\u7519\ucf10\u46fe\ud8a0\u520c\ud5ce"));
            iov.PRESET.set(fij);
            minecraftClient.method_1507(null);
        }
        if (n >= 240) {
            hyz.save();
            return true;
        }
        return false;
    }

    private static void fim(MinecraftClient minecraftClient, BlockPos blockPos) {
        minecraftClient.field_1761.method_2896(minecraftClient.field_1724, Hand.field_5808, new BlockHitResult(Vec3d.method_24953((Vec3i)blockPos), Direction.field_11036, blockPos, false));
    }

    private static void fin(MinecraftClient minecraftClient, Item item) {
        Screen screen = minecraftClient.field_1755;
        if (!(screen instanceof HandledScreen)) {
            return;
        }
        HandledScreen handledScreen = (HandledScreen)screen;
        for (Slot slot : handledScreen.method_17577().field_7761) {
            if (!slot.method_7677().method_31574(item)) continue;
            double d = minecraftClient.method_22683().method_4495();
            double d2 = (double)(handledScreen.field_22789 - 176) / 2.0 + (double)slot.field_7873 + 8.0;
            double d3 = (double)(handledScreen.field_22790 - 166) / 2.0 + (double)slot.field_7872 + 8.0;
            long l = minecraftClient.method_22683().method_4490();
            GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)l, null);
            GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
            GLFW.glfwSetCursorPos((long)l, (double)(d2 * d), (double)(d3 * d));
            if (gLFWCursorPosCallback != null) {
                gLFWCursorPosCallback.invoke(l, d2 * d, d3 * d);
            }
            return;
        }
        System.out.println(a.c(471881002, "\u5546\u2cfc\ua622\u3845\ub395\u3570\u8f77\u0697\u98de\u1268\u95f5\u6f9e\ue107\u78b7\uf2ab") + item + a.b("\u6541\u1ca4\u966c\u0852\u83cd\u057b\ubf31\u36d3\ua89b", -929536664));
    }

    private static int fio(MinecraftClient minecraftClient, Item item) {
        int n = 0;
        for (int i = 0; i < minecraftClient.field_1724.method_31548().method_5439(); ++i) {
            ItemStack itemStack = minecraftClient.field_1724.method_31548().method_5438(i);
            if (!itemStack.method_31574(item)) continue;
            n += itemStack.method_7947();
        }
        return n;
    }

    private static String fip(MinecraftClient minecraftClient) {
        Object object = minecraftClient.field_1755;
        if (!(object instanceof HandledScreen)) {
            return a.b("\ue5d0\u9c60\u16fc\u88ce\u0312\u85ae\u3feb\ub61d", 2048648630);
        }
        HandledScreen handledScreen = (HandledScreen)object;
        object = new StringBuilder();
        for (Slot slot : handledScreen.method_17577().field_7761) {
            if (slot.field_7871 == minecraftClient.field_1724.method_31548()) continue;
            ((StringBuilder)object).append(slot.method_7681() ? Registries.field_41178.method_10221((Object)slot.method_7677().method_7909()).method_12832() + a.c(1234789788, "\u65e5") + slot.method_7677().method_7947() : a.d("\uc8df", 184099837, -1748702450)).append(' ');
        }
        return ((StringBuilder)object).toString().trim();
    }

    private static List<ChatHudLine> fiq(ChatHud chatHud) throws Exception {
        for (Field field : ChatHud.class.getDeclaredFields()) {
            ParameterizedType parameterizedType;
            Type type = field.getGenericType();
            if (!(type instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments()[0] != ChatHudLine.class) continue;
            field.setAccessible(true);
            return (List)field.get(chatHud);
        }
        throw new IllegalStateException(a.c(-1200458734, "\u7469\u0dd9\u8745\u1977\u92ab\u1413\uae55\u27f0\ub9e2\u335b\ub49e\u4eef\uc02a\u599d\ud3cc\u552b\uef37\u60aa\ufa1c\u7c57\uf5a7"));
    }

    private static List<?> fir(ChatHud chatHud) throws Exception {
        for (Field field : ChatHud.class.getDeclaredFields()) {
            ParameterizedType parameterizedType;
            Type type = field.getGenericType();
            if (!(type instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments()[0] != ChatHudLine.Visible.class) continue;
            field.setAccessible(true);
            return (List)field.get(chatHud);
        }
        throw new IllegalStateException(a.b("\ub3b0\uca00\u409c\udeae\u5572\ud3ca\u698c\ue029\u7e3a\uf48e\u735a\u8920\u07e1\u9e03\u141c\u92e8\u28bd\ua76b", 616608716));
    }

    private static Object fis(Object object, String string, MinecraftClient minecraftClient) throws Exception {
        Method method = object.getClass().getDeclaredMethod(string, MinecraftClient.class);
        method.setAccessible(true);
        return method.invoke(object, minecraftClient);
    }

    private static Entity fit(MinecraftClient minecraftClient, String string, double d) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.field_1724.method_73189().method_1031(0.0, 0.0, d);
        otherClientPlayerEntity.method_5808(vec3d.field_1352, minecraftClient.field_1724.method_23318(), vec3d.field_1350, 180.0f, 0.0f);
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6174, new ItemStack((ItemConvertible)Items.field_8523));
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static String fiu(Entity entity) {
        return entity == null ? a.b("\u07c2\u7e72\uf4ba\u6ad7\ue101\u67b7\udded", 1479411627) : entity.method_5477().getString();
    }

    private static void fiv(kfx kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static vmo fiw(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.b("\ua466\udd9f\u5745\uc926\u42a2\uc45d\u7e0f\uf7b1", 1566876750) + string);
    }

    private static void fix(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static void fiy(MinecraftClient minecraftClient, Vec3d vec3d) {
        Vec3d vec3d2 = vec3d.method_1020(minecraftClient.field_1724.method_33571());
        fif.fix(minecraftClient, (float)Math.toDegrees(Math.atan2(-vec3d2.field_1352, vec3d2.field_1350)), (float)(-Math.toDegrees(Math.atan2(vec3d2.field_1351, Math.hypot(vec3d2.field_1352, vec3d2.field_1350)))));
    }

    private static void fiz(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.c(833923379, "\ua941\ud0e5\u5a35\uc46d\u4f94\uc939"));
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{a.c(-762972457, "\uf6a7\u8f08\u05dc\u9ba7\u107b\u96d2\u2cae"), a.b("\ue046\u99e9\u133d\u8d46\u069a\u8033\u3a4e", 1684135990)}) {
            Field field2 = hlc.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void fja(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void fjb(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u47ca\u3e6d\ub4b7\u2acc\ua15d\u27b8\u9dfa\u141d\u8a45\u00a0", -2043131981) + string + a.d("\u3d52\u4483\uce30", -471153242, 327153879) + minecraftClient.method_47599() + a.c(-993185052, "\u32c0\u4b37\uc1f2\u5f80"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\uf554\u8cef\u063f\u9856\u13c4\u956a", -1868410755, -1268669111) + string + a.c(-1187779207, "\ued53\u94bc\u1e71\u8009")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int os(int n, int n2) {
        return n - n2 ^ 0x2873A092;
    }

    private static /* synthetic */ int ot(int n, int n2) {
        return fif.os(n, n2) * n2;
    }

    private static /* synthetic */ int ou(int n, int n2) {
        return fif.os(n, n2) * n2;
    }
}

