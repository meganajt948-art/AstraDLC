/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.biome.BiomeKeys
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.gzj;
import a.kfe;
import a.sbp;
import a.uxx;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vss;
import com.mojang.datafixers.util.Pair;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import org.lwjgl.glfw.GLFW;

final class gzt {
    private static final int gzu = 520;
    private static final String gzv = System.getenv(a.b("\u97c3\uee78\u64a8\ufac1\u7173\uf7af\u4df0\uc406\u5a42\ud0ee\u5722", -156526706));
    private static final gzj[] gzw = new gzj[]{new gzj(0, a.d("\u4710\u3ea4\ub46f\u2a4a\ua1d8\u276e\u9d20\u14ca\u8a86\"\u87f0", -51852174, 424184589), 6000L, 20.0f, -5.0f, true), new gzj(40, a.b("\u2a57\u53e3\ud928\u470d\ucc9f\u4a29\uf067\u798d\ue7c1\u6d65\ueab7\u1085\u9e10\u07a8\u8dfb", 435169852), 6000L, 20.0f, -5.0f, false), new gzj(80, a.d("\u7e74\u07c0\u8d0b\u132e\u98a7\u1e0e\ua44f", 1647265527, -576243488), 6000L, 20.0f, -45.0f, true), new gzj(120, a.c(-6405728, "\u41c2\u3876\ub2bd\u2c98\ua717\u21a3"), 6000L, 110.0f, -80.0f, true), new gzj(160, a.b("\u0450\u7de4\uf72f\u690a\ue297\u6433\ude7d\u5796\uc9d2\u4369", -1166408642), 6000L, 0.0f, 35.0f, true), new gzj(200, a.d("\u7138\u088c\u8247\u1c62\u97ef\u1148\uab16\u22e7", 900366508, -400428552), 6000L, -90.0f, 8.0f, true), new gzj(240, a.b("\u18ac\u6118\uebd3\u75f6\ufe7c\u78dc\uc29a\u4b77", 1598429376), 6000L, 180.0f, 30.0f, true), new gzj(280, a.c(-1478492971, "\ufca0\u8517\u0fdf\u91b3\u1a72\u9cd2"), 12600L, 90.0f, -6.0f, true), new gzj(320, a.c(-500062101, "\ua812\ud1a5\u5b6d\uc501\u4ec0\uc860\u726a\ufbd9\u658f\uef3e"), 12600L, 90.0f, -6.0f, false), new gzj(360, a.c(1540584367, "\u73c0\u0a60\u80b5\u1edc\u954d\u13b6\ua9f0\u201c\ube59\u34f3\ub32a"), 13000L, 0.0f, 30.0f, true), new gzj(400, a.c(-584332884, "\uc9c7\ub071\u3aac\ua4d2\u2f19"), 18000L, 20.0f, -20.0f, true), new gzj(440, a.b("\udb1d\ua2ab\u2876\ub608\u3dc3\ubb2b\u0132\u88d6\u1694\u9c3f\u1bf7\ue18c", -416228481), 18000L, 0.0f, 30.0f, true), new gzj(480, a.b("\u6dcc\u147a\u9ea7\u00d9\u8b12\u0dfa\ub7e6\u3e1a\ua046\u2aef", 123170216), 18000L, 30.0f, -8.0f, true, a.b("!\u799d\uf34d\u6d24\ue6bd\u600f\uda55\u53a4", -1050279861)), new gzj(520, a.b("\u01f4\u7840\uf28b\u6cae\ue736\u618a\udbda\u5233", 283050392), 6000L, 30.0f, -8.0f, true, a.d("\u71d2\u086e\u82be\u1cd7\u974e\u11f3\uaba3\u2257", 1712026096, -1742208952)), new gzj(560, a.c(-1883623624, "\u2f5d\u56eb\udc36\u4248\uc983\u4f6b\uf573\u7c88\ue2da\u6879\uefb1"), 18000L, 20.0f, -25.0f, true, a.c(-89595739, "\ue0ca\u9971\u13af\u8dcc\u0600\u80e3\u3abc\ub34b\u2d14")), new gzj(600, a.c(-1310810088, "\ua060\ud9c2\u5319\ucd6f\u46fb\uc004\u7a58\uf3aa\u6de9\ue74e"), 6000L, 60.0f, 0.0f, true), new gzj(700, a.b("\u921d\ueba5\u617d\uff11", 1869714037), 6000L, 20.0f, -50.0f, true, a.b("\u624f\u1be3\u9121", -1817812444)), new gzj(800, a.b("\u3a2b\u438f\uc94b\u572e\udcb2\u5a42\ue012\u69fb", 1365588563), 6000L, 20.0f, -20.0f, true, a.b("\u55c9\u2c5b\ua690", -896445050)), new gzj(880, a.c(-890242893, "\uf8c8\u816c\u0ba8\u95cd\u1e51\u98a0\u22fb\uab0b\u3559\ubff4\u383f"), 6000L, 20.0f, -20.0f, true, a.b("\uc9cd\ub054\u3a86\ua4fa\u2f31\ua998", -1577006714)), new gzj(960, a.c(-1438407290, "\ua5ff\udc5b\u569f\uc8fa\u4366\uc592\u7fc0\uf63f\u686f"), 6000L, 20.0f, -20.0f, true, a.c(-1823389408, "\u496c\u30fc\uba21\u245f")), new gzj(1140, a.d("\u808b\uf92c\u73e8\ued9d\u6659\ue0ff\u5af3\ud35d\u4d11\uc7a8\u407c", -940827439, -1434018782), 6000L, 20.0f, -5.0f, true, a.d("\u84b3\ufd11\u77ca\ue9bc", 1410256285, -195081896)), new gzj(1190, a.c(403609009, "\u95ce\uec69\u66b7\uf8c6\u7350\uf5aa\u4ffe\uc61c"), 6000L, -140.0f, -4.0f, true), new gzj(1230, a.c(1837369384, "\u0855\u71f2\ufb2c\u655d\ueecb\u6830\ud276\u5b94\uc5d0\u4f7e"), 6000L, -45.0f, 4.0f, true), new gzj(1270, a.b("\u75bd\u0c1a\u86c4\u18b5\u9323\u15d9\uaf8d\u266f\ub86f\u329c\ub546\u4f37", 508720582), 6000L, -140.0f, -4.0f, false)};
    private static final String[] gzx = new String[]{a.c(60010768, "\ub15c\uc8de\u4214\udc65\u579c\ud11d\u6b55\ue2aa\u7cfa\uf657"), a.b("\u09cd\u7045\ufa95\u64fd\uef32\u698b\ud3c9\u5a3e\uc47a\u4ec1\uc937\u336f\ubdb0", 484706710), a.d("\udaad\ua327\u29fd\ub789\u3c5f\ubaf9\u00ab", 2064107261, 115416068), a.b("\uaa17\ud39d\u5947\uc733\u4ce5\uca43\u7031\uf9f8\u67b5", 710126157), a.d("\u962a\uefb9\u6571\ufb1d\u70cc\uf67c\u4c03\uc5dc\u5b9a\ud12c", 1943758016, -996281683)};
    private static boolean[] gzy;
    private static volatile BlockPos gzz;
    private static volatile boolean haa;
    private static int hab;
    private static /* synthetic */ String hac;
    private static /* synthetic */ boolean had;

    private gzt() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.b("\u4968\u30eb\uba3c\u2458\uaf93\u292f\u936b", 1993754936));
        if (n == 1) {
            gzy = new boolean[gzx.length];
            for (int i = 0; i < gzx.length; ++i) {
                kfe kfe3 = Flow.getInstance().getModuleManager().getByName(gzx[i]);
                boolean bl = gzt.gzy[i] = kfe3 != null && kfe3.isEnabled();
                if (!gzy[i]) continue;
                kfe3.setEnabled(false);
            }
            minecraftClient.field_1690.field_1842 = true;
            minecraftClient.field_1690.field_1837 = false;
            minecraftClient.field_1690.method_42503().method_41748((Object)12);
            minecraftClient.field_1690.method_41808().method_41748((Object)70);
            gzt.hah(minecraftClient, a.c(2088924329, "\u74df\u0d68\u87b7\u19ce\u9211\u14a2\uaefa\u270a\ub910\u33e2\ub420\u4e46\uc095\u5931\ud37f\u5591\uefcd"));
            gzt.hah(minecraftClient, a.c(929463682, "\u7dfb\u044c\u8e93\u10ea\u9b2a\u1d9c\ua7d6\u2e2e\ub034\u3ac1\ubd19\u4743\uc9b1\u5018\uda5e\u5caa\ue6eb\u6935\uf39a\u75fc\ufc31\u867a\u08c6\u931e\u1524\u9fb3\u2607\ua85b\u32b3\ub4f4"));
            gzt.hah(minecraftClient, a.c(-2031809362, "\u0cd4\u7563\uffbc\u61c5\uea05\u6cb3\ud6f9\u5f01\uc11b\u4bee\ucc36\u367f\ub89a\u212f\uab69\u2d84\u97c6\u1800\u8282\u04e9\u8d04\uf75a\u79e0\ue274\u644d\uee9b\u5725\ud96b\u438a"));
            gzt.hah(minecraftClient, a.b("\u5ce3\u2540\uaf97\u31f3\uba38\u3c84\u86c0\u0f63\u917f\u1bc1\u9c1b\u666e\ue8aa", -466527079));
            GLFW.glfwSetWindowSize((long)minecraftClient.method_22683().method_4490(), (int)1920, (int)1080);
            gzt.hae(minecraftClient);
            return false;
        }
        if (n < 10) {
            return false;
        }
        if (hab < 0) {
            if (!haa) {
                return false;
            }
            BlockPos blockPos = gzz;
            if (blockPos == null) {
                System.out.println(a.d("\ub6a4\ucf12\u45da\udbb6\u507e\ud698\u6cd1\ue56e\u7b30\uf1ce\u764d\u8c20\u02fa\u9b43\u1117\u97fb\u2de7\ua270\u38ca\ube81\u376d\u4d36", -1066735519, -975544672));
                return true;
            }
            System.out.println(a.b("\u5721\u2e97\ua45f\u3a33\ub1fb\u3707\u8d15\u04f1\u9afa", 845436763) + blockPos.method_23854());
            gzt.hah(minecraftClient, a.b("\u718f\u083a\u82b9\u1ca8\u974c\u11ae", -1708297731) + blockPos.method_10263() + a.d("\uf382", -612820508, 1748757063) + blockPos.method_10264() + a.b("\uf2ff", -368184610) + blockPos.method_10260() + a.c(393713989, "\u9961\ue0c0\u6a03\uf462"));
            gzt.hah(minecraftClient, a.d("\u6ad2\u137e\u99a9\u07d0\u8c42\u0aa0\ub0e5\u3905\ua70e\u2da9\uaa7c\u500d\udeda", 143055043, -1572425112));
            ((vlv)gzt.hag(kfe2, a.c(-1035039376, "\u8d25\uf4a2\u7e75\ue016\u6bdd\ued6d"))).set(a.d("\ufbe7\u8265\u08be\u96c8", 893300861, 618089420));
            ((vmc)gzt.hag(kfe2, a.d("\u5725\u2ea7\ua47c\u3a0a\ub1d5\u3763\u8d3d\u04cc", 966683043, -1209909540))).set(0.7);
            ((vmc)gzt.hag(kfe2, a.d("\uf8b1\u8125\u0bf8\u9586\u1e4d\u98e6\u22b2\uab44\u3512", -415442843, 1256136849))).set(0.0);
            ((vmc)gzt.hag(kfe2, a.d("\uf9a1\u803f\u0aef\u9484\u1f42\u99e4", -2060895661, 1597555639))).set(0.9);
            ((vmc)gzt.hag(kfe2, a.d("\u7a65\u03ff\u892f\u175e\u9c8b", 1092827518, 1117733721))).set(0.6);
            ((vmc)gzt.hag(kfe2, a.d("\udc56\ua5db\u2f12\ub178\u3aa5\ubc03", 2032628115, 1257549200))).set(Double.parseDouble(System.getenv().getOrDefault(a.c(-41168118, "\ud35d\uaae6\u2036\ube5f\u35ed\ub331\u096e\u8098\u1edc\u9470\u13bc\ue9df\u6704\ufea9\u74e0\uf20a\u484f"), a.d("\u9609\uefa6\u6569\ufb1f", 924644733, -1993907392))));
            ((vkl)gzt.hag(kfe2, a.c(-364400684, "\uaf9b\ud606\u5cd6\uc2a4\u4969\ucfdf\u75de\ufc68\u6222\ue880\u6f56\u9526"))).set(true);
            ((vkl)gzt.hag(kfe2, a.d("\ucf09\ub691\u3c49\ua225\u29a1\uaf54\u1511\u9cfd\u02bd\u880f", 1964666462, 1378590993))).set(true);
            ((vlv)gzt.hag(kfe2, a.b("\u7c5e\u05cb\u8f0c\u1170\u9aa2\u1c0e\ua650", 671841288))).set(a.c(-1234508476, "\ue508\u9c98\u1645\u883b"));
            kfe2.setEnabled(true);
            hab = n;
            return false;
        }
        int n2 = n - hab - 520;
        if (n2 == -500) {
            gzt.hah(minecraftClient, a.d("\udaa2\ua31c\u29ca\ub7bb\u3c20\ubacf\u00cf\u8922\u177e\u9ddd\u1a50\ue07f\u6ef6\uf714\u7d5b\ufba9\u41f4\uce7b\u5487\ud2d5\u5b30\u213f\uafca\u3403\ub222\u38bc\u810c\u0f4f\u95f9\u13a0\u9808", -1389541723, -1483498370));
            gzt.hah(minecraftClient, a.d("\uc415\ubdab\u377d\ua90c\u2297\ua478\u1e78\u9795\u09c9\u836a\u04e7\ufec5\u700e\ue9ae\u63a3\ue501\u5f52\ud080\u4a21\ucc2e\u4596\u3fc4\ub165\u2aea\uacc6\u260b\u9fa9\u11a6\u8b1e\u0d4c\u86ed\u787b\uf221\u6bc3\ued82\u6733\ud8c8\u5284\ud459\u4deb\uc7b8\ub941", 558560400, 2007380169));
            gzt.hah(minecraftClient, a.c(375565197, "\uabf4\ud24a\u589c\uc6ed\u4d76\ucb99\u7199\uf877\u663a\uecd5\u6b55\u9138\u1ffe\u8611\u0c0f\u8aed\u30fc\ubf61\u25c0\ua3cf\u2a6b\u5026\ude84\u450b\uc33c\u49fb\uf01f\u7e58\ue4ba\u62fa\ue95e"));
            gzt.hah(minecraftClient, a.d("\u188a\u6134\uebe2\u7593\ufe08\u78e7\uc2fe\u4b1b\ud51a\u5ff5\ud878\u225a\uac94\u3531\ubf3c\u3987\u83dc\u0c53\u96ad\u10ef\u9946\ue35d\u6dfa\uf678\u7000\ufaca\u4378\ucd22\u57ef\ud183\u5a20\ua4ea\u2eaf\ub756\u311d", -10025834, 1188895833));
            gzt.hah(minecraftClient, a.c(-367724837, "\uf695\u8f2b\u05fd\u9b8c\u1017\u96f8\u2cf8\ua515\u3b5b\ub1b4\u3634\ucc59\u429f\udb70\u5170\ud79d\u6dd1\ue212\u78ff\ufee1\u7707\u0d08\u83e8\u1825\u9e4b\u14c4\uad24\u236b\ub98f\u3f9d\ub422\u4afe\uc0b1\u594e\udf14\u55b3\uea63\u6009\ue6db\u7f61"));
            gzt.hah(minecraftClient, a.b("\u41da\u3864\ub2b2\u2cc3\ua758\u21b7\u9bb7\u125d\u8c14\u06fb\u8176\u7b59\uf5dd\u6c77\ue632\u609d\uda81\u554b\ucfee\u49e1\uc05a\uba19\u34f4\uaf76\u2912\ua3d5\u1a29\u9476\u0e8b\u88ee\u036e\ufdbc\u77fb", -785301091));
            gzt.hah(minecraftClient, a.d("\ueb46\u92f8\u182e\u865f\u0dc4\u8b2b\u3134\ub8c7\u2688\uac67\u2bea\ud1c5\u5f41\uc6e9\u4cbe\uca5f\u704e\uffd5\u6567\ue323\u6a8a\u1094\u9e24\u05e7\u83c6\u0944\ub0e9\u3eb3\ua45c\u225e\ua9ea\u5720\udd6e\u4494\uc2fd\u4871\uf7b6\u7ddc\ufb05\u62bc\ue8fb", -256150883, 1014602132));
            gzt.hah(minecraftClient, a.b("\ubadc\uc362\u49b4\ud7c5\u5c5e\udab1\u60ae\ue95d\u7712\ufdfd\u7a7d\u8010\u0ed6\u9739\u1d39\u9bd6\u219d\uae5b\u34b6\ub2ad\u3b5b\u411f\ucff2\u5470\ud213\u58d3\ue13e\u6f3c\uf5d5\u7387\uf824\u06b2\u8ce8\u150a\u934b\u19fa\ua601\u2c4d\uaa90\u3322\ub971\uc788", 2040838800));
        }
        if (n2 == -480) {
            minecraftClient.field_1724.method_31549().field_7479 = false;
        }
        if (minecraftClient.field_1755 != null) {
            minecraftClient.method_1507(null);
        }
        if (n2 == -40) {
            uxx.timing(true);
            uxx.gpuMillis();
        }
        if (n2 == -1) {
            System.out.println(a.b("\u0bf9\u724f\uf887\u66eb\ued23\u6bdf\ud1cb\u582d\uc677\u4c93", -1257501824) + uxx.gpuReport());
        }
        for (gzj gzj2 : gzw) {
            int n3;
            if (gzv != null && !gzj2.gzl.startsWith(gzv)) continue;
            int n4 = gzj2.gzq.equals(a.b("\udd1d\ua4b1\u2e73", 1334238582)) ? 90 : (n3 = gzj2.gzq.equals(a.b("\uf5ea\u8c48\u0693\u98e5", 439874972)) ? 130 : 36);
            if (n2 == gzj2.gzk - n3) {
                gzt.hah(minecraftClient, a.c(-209631884, "\u4509\u3ca5\ub672\u280b\ua399\u257b\u9f3e\u16de\u88d5") + gzj2.gzm);
                kfe2.setEnabled(gzj2.gzp);
                boolean bl = minecraftClient.field_1690.field_1842 = !gzj2.gzq.equals(a.b("\uf221\u8b8d\u014f", -160501174));
                if (gzj2.gzq.equals(a.c(1159962363, "\u9eb4\ue726\u6ded")) || gzj2.gzq.equals(a.d("\ub9d9\uc040\u4a92\ud4ee\u5f25\ud98c", -978177975, 1316129243)) || gzj2.gzq.equals(a.d("\u807c\uf9ec\u7331\ued4f", -1488011237, -597278677))) {
                    ((vlv)gzt.hag(kfe2, a.d("\u839c\ufa09\u70ce\ueeb2\u6560\ue3cc\u5992", 420493145, -233524077))).set(gzj2.gzq);
                }
                gzt.haf(minecraftClient, gzj2.gzn, gzj2.gzo);
                if (!gzj2.gzq.equals(a.d("\u2cba\u5518\udfc3\u41b5", 174860185, 1521486677))) continue;
                gzt.hah(minecraftClient, a.b("\u9a00\ue3a3\u6974\uf710\u7cdb\ufa67\u4023\uc980\u578d\udd2f\u5af4\ua082", 2105580155));
                continue;
            }
            if (n2 == gzj2.gzk - 30 && (gzj2.gzq.equals(a.c(-46849522, "\u2241\u5bd3\ud118")) || gzj2.gzq.equals(a.c(-1378828215, "\uc002\ub99b\u3349\uad35\u26fe\ua057")) || gzj2.gzq.equals(a.d("\u0bd8\u7248\uf895\u66eb", -131874378, -894514654)))) {
                uxx.gpuMillis();
                continue;
            }
            if (n2 == gzj2.gzk - 3 && (gzj2.gzq.startsWith(a.b("\uf94f\u80f3\u0a23\u944a\u1fd3", 725350696)) || gzj2.gzq.startsWith(a.c(-1329097185, "\u967f\uefc4\u651a\ufb79\u70b5\uf656")))) {
                float f = Float.parseFloat(gzj2.gzq.substring(gzj2.gzq.indexOf(58) + 1));
                float f2 = gzj2.gzn * ((float)Math.PI / 180);
                double d = Math.atan2(Math.cos(f2), -Math.sin(f2));
                ((sbp)kfe2).testStrike(f, gzj2.gzq.startsWith(a.b("\u6e7c\u17c0\u9d10\u0379\u88e0", 380923419)), d, 0.03);
                continue;
            }
            if (n2 == gzj2.gzk - 2) {
                gzt.haf(minecraftClient, gzj2.gzn, gzj2.gzo);
                continue;
            }
            if (n2 == gzj2.gzk) {
                if (gzj2.gzq.equals(a.b("\u827a\ufbe8\u7123", 1441169973)) || gzj2.gzq.equals(a.b("\u7884\u011d\u8bcf\u15b3\u9e78\u18d1", -1753515825)) || gzj2.gzq.equals(a.c(1280185584, "\u14bc\u6d2c\ue7f1\u798f"))) {
                    System.out.println(a.c(838323896, "\ucecd\ub77b\u3db3\ua3df\u2817\uaeeb") + gzj2.gzl + a.d("\ucf4e\ub6b8\u3c7c\ua208\u298a", 899869419, -333830784) + uxx.gpuReport() + a.b("\u7f10\u06c1\u8c72", 256278323) + minecraftClient.method_47599() + a.c(-395673399, "\u80ed\uf91a\u73df\uedad"));
                }
                gzt.hai(minecraftClient, a.b("\u4431\u3d87\ub74f\u2923\ua2eb\u241a", -1219148732) + gzj2.gzl);
                System.out.println(a.b("\u8611\uffa7\u756f\ueb03\u60cb\ue637\u5c25\ud5c0\u4b8e\uc132\u46e7\ubcd9", -1073117586) + vss.report());
                continue;
            }
            if (n2 == gzj2.gzk + 2 && gzj2.gzq.equals(a.d("\u0c2e\u758c\uff57\u6121", 1620330410, 767118322))) {
                System.out.println(a.b("\ua78c\ude3a\u54f2\uca9e\u4156\uc7aa\u7daa\uf44d\u6a05\ue0b0\u6770\u9d16\u1393\u8a700\u86c9\u3c81\ub31e\u29ea\uafae\u264a\u5c1e\ud2a0\u497d\ucf09\u45c2\ufc25", 792438756) + minecraftClient.field_1687.method_8430(1.0f) + a.d("\u608e\u196d\u93ad\u0dd4\u8604\u00b2\ubae6\u331e\uad06", -965558439, 789766142) + minecraftClient.field_1687.method_8419());
                gzt.hah(minecraftClient, a.b("\u64d1\u1d72\u97a5\u09c1\u820a\u04b6\ubef2\u3751\ua94d\u23f3\ua429\u5e5c\ud098", -32676693));
                continue;
            }
            if (n2 != gzj2.gzk + 4 || !gzj2.gzq.startsWith(a.d("\u94c9\ued75\u67a5\uf9cc\u7255", 1833965833, -619868761)) && !gzj2.gzq.startsWith(a.b("\ue547\u9cfc\u1622\u8841\u038d\u856e", -1916541657))) continue;
            ((sbp)kfe2).testStrike(100000.0f, false, 0.0, 10.0);
        }
        if (n2 > gzt.gzw[gzt.gzw.length - 1].gzk + 10) {
            uxx.timing(false);
            minecraftClient.field_1690.field_1842 = false;
            for (int i = 0; i < gzx.length; ++i) {
                kfe kfe4 = Flow.getInstance().getModuleManager().getByName(gzx[i]);
                if (kfe4 == null) continue;
                kfe4.setEnabled(gzy[i]);
            }
            return true;
        }
        return false;
    }

    private static void hae(MinecraftClient minecraftClient) {
        gzz = null;
        haa = false;
        IntegratedServer integratedServer = minecraftClient.method_1576();
        BlockPos blockPos = minecraftClient.field_1724.method_24515();
        integratedServer.execute(() -> {
            try {
                ServerWorld serverWorld = integratedServer.method_30002();
                Pair pair = serverWorld.method_42108(registryEntry -> registryEntry.method_40225(BiomeKeys.field_9451), blockPos, 6400, 32, 64);
                if (pair != null) {
                    BlockPos blockPos2 = (BlockPos)pair.getFirst();
                    serverWorld.method_8500(blockPos2);
                    int n = serverWorld.method_8624(Heightmap.Type.field_13203, blockPos2.method_10263(), blockPos2.method_10260());
                    gzz = new BlockPos(blockPos2.method_10263(), n, blockPos2.method_10260());
                }
            }
            catch (Throwable throwable) {
                System.out.println(a.b("\u5f3e\u2688\uac40\u322c\ub9e4\u3f18\u8507\u0cf5\u92a6\u1815\u9fd3\u65b3\ueb21\u72d6\uf882\u7e7b\uc431\u4be9\ud15b\u5754\udeb9", 787439448) + throwable);
            }
            haa = true;
        });
    }

    private static void haf(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static vmo hag(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.c(825255096, "\u6490\u1d69\u97b3\u09d0\u8254\u04ab\ubef9\u3747") + string);
    }

    private static void hah(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void hai(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u313c\u489b\uc241\u5c3a\ud7ab\u514e\ueb0c\u62eb\ufcb3\u7656", 1767715141) + string + a.c(-678339050, "\u5e35\u27e4\uad57") + minecraftClient.method_47599() + a.d("\u4a57\u33a0\ub965\u2717", -1698887769, 701779412));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\uff31\u868a\u0c5a\u9233\u19a1\u9f0f", -406698519, 135838392) + string + a.b("\u8696\uff79\u75b4\uebcc", 1204324028)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        hab = -1;
    }

    private static /* synthetic */ int yb(int n, int n2) {
        return n * n2 | 0x1EBBC3A0;
    }

    private static /* synthetic */ int yc(int n, int n2) {
        return n + n2 + 1068741962;
    }

    private static /* synthetic */ int yd(int n, int n2) {
        return n - n2 | 0x58554139;
    }
}

