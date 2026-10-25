/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.option.Perspective
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.Hand
 */
package a;

import a.fnq;
import a.hlc;
import a.ubm;
import a.ucg;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Hand;

final class fkm {
    private static final String[][] fkn;
    private static final String fko;
    private static final int fkp = 60;
    private static double fkq;
    private static double fkr;
    private static double fks;
    private static boolean fkt;
    private static boolean fku;
    private static final int fkv = 50;
    private static final String fkw;
    private static /* synthetic */ String fkx;
    private static /* synthetic */ long fky;

    private fkm() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        Object object;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        if (n == 1) {
            fkm.flh(minecraftClient, a.d("\u797b\u00cc\u8a13\u146a\u9fb5\u1906\ua35e\u2aae\ub4b4\u3e46\ub984\u43e2\ucd31\u5495\udedb\u5835\ue269", 417626828, 1840382913));
            fkm.flh(minecraftClient, a.c(1966096109, "\u3e94\u4738\ucdef\u5396\ud804\u5ee6\ue4a3\u6d43\uf348\u79ef\ufe3a\u044b\u8a9c"));
            fkm.flh(minecraftClient, a.b("\u2a64\u53c7\ud910\u4774\uccbf\u4a03\uf047\u79e4\ue7f8\u6d46\uea9c\u10e9\u9e2d", -1334695394));
            ucg.ENABLED.set(false);
            minecraftClient.field_1690.field_1842 = true;
            fkq = Math.floor(minecraftClient.field_1724.method_23317()) + 0.5;
            fkr = Math.floor(minecraftClient.field_1724.method_23318());
            fks = Math.floor(minecraftClient.field_1724.method_23321()) + 0.5;
            System.out.println(a.c(906401395, "\u9602\uefbf\u6570\ufb1f\u70c0\uf660\u4c2e\uc5d5\u5b9a\ud178\u56e7\uac95\u224c\ubbf8\u31aa\ub75a\u0d4b\u8280") + Cosmetics.items().size());
        }
        int n7 = 20;
        boolean bl = a.b("\ua0a3\ud905\u53c1\ucda5\u4667\uc0c5", 1270587588).equals(System.getenv(a.c(1609610802, "\ub67a\ucfc1\u4511\udb78\u50ca\ud616\u6c59\ue5a4\u7be7\uf15a\u7699\u8ce9\u023c\u9b98")));
        int n8 = n6 = bl ? n7 : n7 + fkn.length * 60;
        if (n >= n7 && n < n6) {
            n5 = (n - n7) / 60;
            n4 = (n - n7) % 60;
            fkm.flg(minecraftClient, 30.0f, 8.0f);
            if (n4 == 0) {
                fkm.flc(fkn[n5]);
                minecraftClient.field_1690.method_31043(Perspective.field_26665);
            }
            if (n4 == 24) {
                fkm.fli(minecraftClient, a.c(658348784, "\u9a97\ue32a\u69e5\uf7ca") + String.format(a.d("\uf911\u80b5\u0a64\u9443", 1057241400, -429408248), n5) + a.b("\u40da\u3924\ub3f4\u2d87\ua658", -1953873678));
            }
            if (n4 == 26) {
                minecraftClient.field_1690.method_31043(Perspective.field_26666);
            }
            if (n4 == 44) {
                fkm.fli(minecraftClient, a.b("\u0b36\u728b\uf844\u666b", 351406929) + String.format(a.d("\u95ec\uec48\u6699\uf8be", 663228853, -51673992), n5) + a.b("\uf01d\u89e7\u0320\u9d4c\u169a\u9031", 429322294));
            }
        }
        if (n >= (n5 = n6) && n < n5 + fkm.fla()) {
            fkm.flb(minecraftClient, n - n5);
        }
        if (bl && n == n5 + fkm.fla()) {
            minecraftClient.method_1507(null);
            Cosmetics.clearAll();
            System.out.println(a.c(-1972809577, "\u50d4\u2969\ua3a6\u3dc9\ub616\u30b6\u8af8\u0303\u9d4c\u17ae\u9029\u6a49\ue488\u7d3e\uf739\u7189\ucbd1\u4417\udeb1\u58f5\ud111\uab12\u25f1\ube38\u384e\ub28d\u0b28\u853c\u1f8f\u99d5\u1267\uecbd"));
            return true;
        }
        n4 = n5 + fkm.fla();
        if (n == n4) {
            fkm.flc(new String[]{a.d("\u1b29\u6280\ue854\u762f\ufdf3\u7b45\uc107\u48d1\ud6a6\u5c09\udbdd\u21a5\uaf66", -692522264, -1052382788), a.c(1018516351, "\u5314\u2aa7\ua061\u3e3b\ub5c3\u3363\u8932\u00cb"), a.b("\u9633\uef80\u654e\ufb38\u70e9\uf643\u4c1b\uc5d0\u5ba0\ud104\u56c6", -1173055917), a.b("\u0f86\u763c\ufce1\u6294\ue973\u6ff8\ud5af\u5c4d\uc213", 1234178017)});
            minecraftClient.field_1690.method_31043(Perspective.field_26665);
            fkm.flg(minecraftClient, 30.0f, 8.0f);
        }
        if (n == n4 + 20) {
            fkm.fli(minecraftClient, a.c(731266809, "\u3e92\u472f\ucde0\u53cf\ud85c\u5ee0\ue4bb\u6d43"));
            minecraftClient.field_1690.field_1894.method_23481(true);
        }
        if (n > n4 && n < n4 + 160) {
            fkm.flg(minecraftClient, 30.0f, 8.0f);
        }
        if (n == n4 + 45) {
            fkm.fli(minecraftClient, a.c(389268365, "\uc3e6\uba5b\u3094\uaebb\u2536\ua391\u19cf\u9039"));
            minecraftClient.field_1724.method_5728(true);
            minecraftClient.field_1690.field_1867.method_23481(true);
        }
        if (n == n4 + 70) {
            fkm.fli(minecraftClient, a.d("\u8ad0\uf36d\u79a2\ue78d\u6c04\ueab6\u50e7\ud90d\u4755\ucdfe", 1104769802, 692124083));
            minecraftClient.field_1690.field_1867.method_23481(false);
            minecraftClient.field_1724.method_5728(false);
            minecraftClient.field_1690.field_1894.method_23481(false);
        }
        if (n == n4 + 90) {
            minecraftClient.field_1690.field_1903.method_23481(true);
        }
        if (n == n4 + 92) {
            minecraftClient.field_1690.field_1903.method_23481(false);
        }
        if (n == n4 + 95) {
            fkm.fli(minecraftClient, a.b("\u7db9\u0404\u8ecb\u10e4\u9b74\u1dda\ua791\u2e7d", 461405650));
        }
        if (n == n4 + 110) {
            fkm.flh(minecraftClient, String.format(Locale.ROOT, a.c(-2123220860, "\u38e4\u4151\ucbd2\u55c3\ude27\u58c5\ue293\u6b69\uf529\u7fcf\uf85a\u022e\u8cf2\u155c\u9f58\u19ef\ua3a5\u2c7f\ub6d3\u30d5"), fkq, fkr + 9.0, fks));
        }
        if (n == n4 + 126) {
            fkm.fli(minecraftClient, a.c(-173720184, "\u3de3\u445e\uce91\u50be\udb22\u5d94\ue7ca\u6e3b"));
        }
        if (n == n4 + 140) {
            minecraftClient.field_1690.field_1832.method_23481(true);
        }
        if (n == n4 + 155) {
            fkm.fli(minecraftClient, a.d("\u19c0\u607d\ueab2\u749d\uff14\u79b8\uc3e0\u4a15\ud440", 59588481, -857463253));
            minecraftClient.field_1690.field_1832.method_23481(false);
        }
        if (n >= n4 + 160 && n < n4 + 175) {
            float f = 30.0f + (float)(n - n4 - 160) * 9.0f;
            fkm.flg(minecraftClient, f, 8.0f);
        }
        if (n == n4 + 172) {
            fkm.fli(minecraftClient, a.c(1077176466, "\u68f9\u1144\u9b8b\u05a4\u8e2a\u089a\ub2ce\u3b23"));
        }
        if (n == n4 + 180) {
            minecraftClient.field_1690.method_31043(Perspective.field_26664);
            fkm.flg(minecraftClient, 75.0f, 4.0f);
        }
        if (n == n4 + 200) {
            fkm.fli(minecraftClient, a.c(1699535322, "\ud9b6\ua00b\u2ac4\ub4eb\u3f77\ub9c9\u0381\u8a71\u1429\u9e9c\u195a\ue33c\u6dea\uf447\u7e15"));
        }
        if (n == (n3 = n4 + 210)) {
            Cosmetics.clearAll();
            fkm.flh(minecraftClient, String.format(Locale.ROOT, a.c(315734865, "\ubb3c\uc289\u480a\ud61b\u5dff\udb1d\u614b\ue8b1\u76f1\ufc17\u7b82\u81f6\u0f2a\u9684\u1c80\u9a37\u207d\uafa7\u350b\ub30d\u3abc\u40f4\uce4e\u558f\ud3e0"), fkq, fkr, fks));
            double d = fkq - 3.5;
            double d2 = fkr;
            double d3 = fks;
            UUID uUID = minecraftClient.field_1724.method_5667();
            minecraftClient.method_1576().execute(() -> fnq.spawn((MinecraftServer)minecraftClient.method_1576(), uUID, d, d2, d3));
        }
        if (n == n3 + 30) {
            fkt = fkm.fld();
            System.out.println(a.c(-1607415960, "\uc71c\ubea1\u346e\uaa01\u21de\ua77e\u1d30\u94cb\u0a84\u8066\u07e6\ufd90\u7352\ueaf6\u60a4\ue653\u5c4f\ud3dd\u4962\ucf38\u46ce\u3cda\ub26e") + Cosmetics.code() + a.b("\ud1e9\ua853\u228c\ubcad\u376b\ub1c9\u0b9c\u8260\u1c66\u969b\u114b\ueb3a\u65e9\ufc46\u7610\uf0b1", 2036519390) + ucg.cosmeticsOf(a.d("\ua647\udfdc\u550c\ucb65\u4087\uc61b\u7c53", 488947690, 1878530540)));
        }
        if (n > n3 && n < n3 + 120) {
            fkm.flg(minecraftClient, 90.0f, 6.0f);
        }
        if (n == n3 + 1) {
            minecraftClient.field_1690.method_31043(Perspective.field_26664);
        }
        if (n == n3 + 70) {
            fkm.fli(minecraftClient, a.c(2115957788, "\uf475\u8dc8\u0707\u9928\u12a0\u9406\u2e5d\ua7ae\u39ea\ub34a"));
            fku = fkm.fle(minecraftClient);
        }
        if (n == n3 + 75) {
            minecraftClient.field_1690.method_31043(Perspective.field_26665);
        }
        if (n == n3 + 100) {
            fkm.fli(minecraftClient, a.d("\u4984\u3039\ubaf6\u24d9\uaf51\u29f7\u93ac\u1a5f\u841b\u0ebb\u8920\u731a\ufdca\u6468", 591938664, 235212161));
        }
        if (n == (n2 = n3 + 120)) {
            minecraftClient.field_1690.method_31043(Perspective.field_26665);
            minecraftClient.field_1690.field_1842 = false;
            try {
                object = hlc.class.getDeclaredField(a.b("\uad3c\ud498\u5e48\uc010\u4be9\ucd44", 1925426510));
                ((Field)object).setAccessible(true);
                ((Field)object).set(null, a.b("\u8360\ufafd\u7032\uee5d\u6582\ue322\u596c\ud097\u4ed8", 2108523306));
            }
            catch (Exception exception) {
                System.out.println(a.b("\u324c\u4be8\uc138\u5f0b\ud49a\u5224\ue87b\u6183\uffd4\u753b\uf2f2", -2116865485) + exception);
            }
            minecraftClient.method_1507((Screen)new hlc());
        }
        if (n == n2 + 30) {
            fkm.fli(minecraftClient, a.d("\u7019\u09a4\u836b\u1d44\u96d9\u107a\uaa35", -778026717, 1479225694));
        }
        if (n >= n2 + 40) {
            minecraftClient.method_1507(null);
            object = Cosmetics.items();
            boolean bl2 = !fkm.flf(a.b("\ua691\udf2a\u55fa\ucb93\u401d\uc6e1\u7cbe\uf553\u6b12\ue1ab\u6669\u9c05\u12d8\u8b24\u011a\u87c7\u3d94\ub25b\u28e0\uaea0\u274a\u5d11\ud386\u487c\uce00\u44c9", 700163821), a.d("\u5f5a\u26ec\uac37\u3243\ub99d\u3f2d", 1604315028, 647870638));
            boolean bl3 = object.size() >= 30 && fkt && fku && bl2;
            System.out.println(a.c(-498524822, "\u1d06\u64bb\uee74\u701b\ufbc4\u7d64\uc72a\u4ed1\ud09e\u5a7c\uddfb\u279b\ua95a\u30ec\ubaeb") + (bl3 ? a.b("\u248e\u5d2e\ud7ef\u499e", 1300505818) : a.d("\u055c\u7cea\uf631\u6845", 378173547, -1294041739)) + a.b("\u2d50\u54e9", 811150706) + object.size() + a.c(2134002941, "\u4cd3\u352b\ubfe5\u2185\uaa5a\u2cf5\u96f9\u1f04\u810b\u0bab\u8c6b\u761c\uf8c6\u612e") + fkt + a.c(-72599737, "\u3762\u4edf\uc45e\u5a38\ud1e7\u5754\ued1c\u64fc\ufae6") + fku + a.b("\u6f21\u169c\u9c08\u0272\u89a6\u0f0f\ub50b", 1211985674) + bl2 + a.b("\u80b8", 510623888));
            Cosmetics.clearAll();
            ucg.ENABLED.set(true);
            return true;
        }
        return false;
    }

    private static int fkz() {
        return fkw != null ? 1 : 24;
    }

    private static int fla() {
        return fkm.fkz() * 50 + 240;
    }

    private static void flb(MinecraftClient minecraftClient, int n) {
        List<CosmeticItem> list = fkw != null && Cosmetics.get(fkw) != null ? List.of(Cosmetics.get(fkw)) : Cosmetics.ofSlot(a.b("\u0f0b\u76ad\ufc69\u620d\ue9cf\u6f6d", -2056122516));
        int n2 = n / 50;
        int n3 = n % 50;
        if (n2 < fkm.fkz()) {
            if (n2 >= list.size()) {
                return;
            }
            fkm.flg(minecraftClient, 30.0f, 8.0f);
            if (n3 == 0) {
                fkm.flc(new String[]{list.get((int)n2).id});
                minecraftClient.field_1690.method_31043(Perspective.field_26666);
            }
            if (n3 == 18) {
                fkm.fli(minecraftClient, a.b("\ua825\ud198\u5b57\uc578\u4ee3\uc845\u724d", -1904170943) + list.get((int)n2).id + a.b("\u7df1\u040b\u8ecc\u10a0\u9b76\u1ddd", -649888294));
                minecraftClient.field_1690.method_31043(Perspective.field_26665);
            }
            if (n3 == 36) {
                fkm.fli(minecraftClient, a.c(-282329569, "\ufe7b\u87c6\u0d09\u9326\u18bd\u9e1b\u2413") + list.get((int)n2).id + a.b("\u9290\ueb6e\u61be\uffcd\u7412", -110390600));
            }
            return;
        }
        String string = fkw != null ? fkw : a.b("\uba37\uc39c\u494e\ud738\u5cee\uda6f\u6004\ue9fb\u77bf\ufd10", 129677903);
        int n4 = n - fkm.fkz() * 50;
        if (n4 == 0) {
            fkm.flc(new String[]{string});
            fkm.flh(minecraftClient, a.b("\u4280\u3b2c\ub1ee\u2f97\ua40d\u22ee\u98aa\u114e\u8f0d\u05b1\u8260\u7817\uf685\u6f71\ue529\u63c2\ud990\u565c\ucce2\u4aea\uc37d\ub91f\u37ff\uac79\u2a14\ua0c1\u1963\u972d\u0ddb\u8bca:\ufee7\u74a0\ued56\u6b03\ue1bb\u5e63\ud418\u528f\ucb69\u4128\u3fc4\ub58b\u3272\ua8e1\u269d\u9f46\u15fb\u93b6\u0866\u861f\u7cf5\uf56e\u733b\ue9d0\u679c\udc35", -991214896));
            minecraftClient.field_1690.method_31043(Perspective.field_26666);
        }
        if (n4 >= 0 && n4 < 200) {
            fkm.flg(minecraftClient, 30.0f, 8.0f);
        }
        if (n4 == 14) {
            fkm.fli(minecraftClient, a.c(-1024157143, "\u9a5b\ue3e6\u6929\uf706\u7c9d\ufa3b\u4033\uc987\u57d5\udd73\u5abd\ua08e\u2e07\ub7b2\u3df9\ubb15\u014c"));
            minecraftClient.field_1690.field_1894.method_23481(true);
        }
        if (n4 == 34) {
            fkm.fli(minecraftClient, a.c(-2868670, "\u3a31\u438c\uc943\u576c\udcf7\u5a51\ue059\u69ed\uf7bf\u7d19\ufad7\u00e4\u8e69\u17ce\u9d90\u1b66"));
            minecraftClient.field_1690.method_31043(Perspective.field_26665);
        }
        if (n4 == 50) {
            fkm.fli(minecraftClient, a.c(-1067583919, "\uf627\u8f9a\u0555\u9b7a\u10e1\u9647\u2c4f\ua5fb\u3ba9\ub10f\u36c1\uccf2\u427f\udbd8\u5186\ud770\u6d79\ue2e7\u7857\ufe04\u77fb"));
            minecraftClient.field_1690.method_31043(Perspective.field_26666);
            minecraftClient.field_1724.method_5728(true);
            minecraftClient.field_1690.field_1867.method_23481(true);
        }
        if (n4 == 72) {
            fkm.fli(minecraftClient, a.c(-1440959815, "\ub2c8\ucb75\u41ba\udf95\u540e\ud2a8\u68a0\ue114\u7f46\uf5e0\u722e\u881d\u0694\u9f26\u1577\u939d\u29d5\ua61e"));
            minecraftClient.field_1690.field_1867.method_23481(false);
            minecraftClient.field_1724.method_5728(false);
            minecraftClient.field_1690.field_1894.method_23481(false);
        }
        if (n4 == 84) {
            minecraftClient.field_1724.method_6104(Hand.field_5808);
        }
        if (n4 == 86) {
            fkm.fli(minecraftClient, a.b("\ua67a\udfc7\u5508\ucb27\u40bc\uc61a\u7c12\uf5a6\u6bf4\ue152\u669c\u9caf\u1226\u8b93\u01de\u8728\u3d6e", 452503048));
            minecraftClient.field_1690.field_1832.method_23481(true);
        }
        if (n4 == 96) {
            fkm.fli(minecraftClient, a.d("\uf8ad\u8110\u0bdf\u95f0\u1e6b\u98cd\u22c5\uab71\u3523\ubf85\u384b\uc278\u4cf1\ud55d\u5f05\ud9f0\u63b5", 1323254719, 331529056));
            minecraftClient.field_1690.field_1832.method_23481(false);
            minecraftClient.field_1690.field_1903.method_23481(true);
        }
        if (n4 == 98) {
            minecraftClient.field_1690.field_1903.method_23481(false);
        }
        if (n4 == 101) {
            fkm.fli(minecraftClient, a.c(104289379, "\u5410\u2dad\ua762\u394d\ub2d6\u3470\u8e78\u07cc\u999e\u1338\u94f6\u6ec5\ue055\u79fb\uf3b0\u755c"));
            fkm.flh(minecraftClient, a.b("\u6798\u1e2f\u94f0\u0a89\u8156\u07e5\ubdbd\u344d\uaa57\u20b5\ua760\u5d16\ud3c5\u4a6b\uc027\u46c1\ufc83", -396924946));
            fkm.flh(minecraftClient, a.d("\u3da0\u4414\ucecb\u50b6\udb67\u5dd4\ue7c2\u6e53\uf03f\u7add\ufd1f\u077f\u89e5\u1050\u9a04\u1cfe\ua6b7\u2977\ub3d7\u3581\ubc64\uc67b\u4895\ud346\u5532\udfe8\u664c\ue806\u72fb", -1267658956, -400739603));
        }
        if (n4 == 103) {
            fkm.fli(minecraftClient, a.c(913483553, "\ua752\udeef\u5420\uca0f\u4194\uc732\u7d3a\uf48e\u6adc\ue07a\u67b4\u9d87\u1315\u8ab9\u00ed\u861a"));
            fkm.flh(minecraftClient, a.d("\u66f8\u1f4f\u9590\u0be9\u8036\u0685\ubcdd\u352d\uab37\u21c5\ua607\u5c61\ud2b2\u4b16\uc158\u47b6\ufdea", 480017498, 336861908));
        }
        if (n4 == 104) {
            fkm.flc(new String[]{string, a.b("\ubaf7\uc349\u4993\ud7e0\u5c3e\udabc\u60c7\ue928\u7770\ufdc8\u7a0f", 928627357)});
            minecraftClient.field_1690.method_31043(Perspective.field_26665);
        }
        if (n4 == 124) {
            fkm.fli(minecraftClient, a.c(1595029269, "\u3767\u4eda\uc415\u5a3a\ud1a1\u5707\ued0f\u64bb\ufae9\u704f\uf781\u0db2\u833f\u1a90\u90c4\u163c\uac67"));
            fkm.flc(new String[]{string});
            minecraftClient.field_1690.field_1842 = false;
            minecraftClient.method_1507((Screen)new InventoryScreen((PlayerEntity)minecraftClient.field_1724));
        }
        if (n4 == 150) {
            fkm.fli(minecraftClient, a.c(-495765348, "\u38ea\u4157\ucb98\u55b7\ude2c\u588a\ue282\u6b36\uf564\u7fc2\uf80c\u023f\u8cac\u151a\u9f51\u19b3\ua3f7\u2c3c\ub694\u30d8\ub924"));
            minecraftClient.method_1507(null);
            minecraftClient.field_1690.field_1842 = true;
            fkm.flc(new String[]{a.c(-942674837, "\uec04\u95be\u1f67\u8117\u0ad7\u8c4b\u3620\ubfdf\u219b\uab34")});
            minecraftClient.field_1690.method_31043(Perspective.field_26666);
            minecraftClient.field_1690.field_1894.method_23481(true);
            minecraftClient.field_1724.method_5728(true);
            minecraftClient.field_1690.field_1867.method_23481(true);
        }
        if (n4 == 176) {
            fkm.fli(minecraftClient, a.c(909319798, "\u1e06\u67bb\ued74\u735b\uf8c0\u7e66\uc46e\u4dc1\ud39d\u592e\udee6\u2490\uaa5d\u33b5\ub9ae\u3f54\u8511\u0ac1\u9065"));
            minecraftClient.field_1690.field_1867.method_23481(false);
            minecraftClient.field_1724.method_5728(false);
            minecraftClient.field_1690.field_1894.method_23481(false);
            fkm.flh(minecraftClient, a.b("\u69ce\u1062\u9aa0\u04d9\u8f43\u09a0\ub3e4\u3a00\ua443\u2eff\ua92e\u5359\uddcb\u443f\uce67\u488c\uf2de\u7d12\ue7ac\u61a4\ue833\u9251\u1cb1\u8737\u015a\u8b8f\u322d\ubc63\u2695\ua084\u2b74\ud5a9\u5fee\uc618\u404d\ucaf5\u752d\uff56\u79c1\ue027\u6a66\u148a\u9ec5\u193c\u83aa\u0dd3\ub41b", -1372821112));
        }
    }

    private static void flc(String[] stringArray) {
        Cosmetics.clearAll();
        for (String string : stringArray) {
            CosmeticItem cosmeticItem = Cosmetics.get(string);
            if (cosmeticItem != null) {
                Cosmetics.toggle(cosmeticItem);
                continue;
            }
            System.out.println(a.d("\u1bd5\u6268\ue8a7\u76c8\ufd17\u7bb7\uc1f9\u4802\ud61e\u5ce2\udb35\u215e\uaf89\u3622\ubc76\u3a8e\u8086", 1072162413, 110230986) + string);
        }
    }

    private static boolean fld() {
        try {
            Field field = ucg.class.getDeclaredField(a.d("\ufde5\u8458\u0e80\u90f0", -1420035194, 67569156));
            Field field2 = ucg.class.getDeclaredField(a.c(556005734, "\uf911\u80b1\u0a71\u9406\u1fdc\u995d\u2323"));
            Field field3 = ucg.class.getDeclaredField(a.c(-1198664489, "\ud49d\uad24\u27ff\ub981\u3251\ub4f7\u0ea5"));
            field.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);
            field.set(null, a.d("\u85f9\ufc40\u769b\ue8e2\u633d\ue584", 597880319, 1779001421));
            field2.set(null, a.b("\u03af\u7a0f\uf0ca\u6ebc\ue532\u63de\ud99c\u507e\uce27\u449b", 75367377));
            List list = (List)field3.get(null);
            list.clear();
            ubm ubm2 = new ubm();
            ubm2.code = a.d("\u50fe\u2947\ua39c\u3de5\ub63a\u3083", 1721586671, -1560083622);
            ubm2.name = MinecraftClient.method_1551().method_1548().method_1676();
            ubm2.online = true;
            list.add(ubm2);
            ubm ubm3 = new ubm();
            ubm3.code = a.d("\u3fde\u4662\uccaa\u52cd\ud917\u5fbd", 197516191, -1155472379);
            ubm3.name = a.c(1040991407, "\u44ee\u3d75\ub7a5\u29cc\ua22e\u24b2\u9efa");
            ubm3.online = true;
            ubm3.cosmetics = a.d("\ud6e7\uaf48\u259c\ubbe4\u3027\ub6df\u0cd2\u8522\u1b75\u91c6\u1614\uec54\u62ab\ufb04\u7150\uf7a8\u4df3\uc27d\u5892\uded6\u5730\u2d2f\ua3c2\u3805\ube69\u34be\u8d05\u0355\u9993\u1fed\u944b\u6a8b\ue09c\u7929\uff73\u75d7\uca4e\u406d\uc6b9\u5f15\ud556\uabba\u21c5\ua643\u3c9d\ub2f9\u0b72\u818d\u07c1\u9c12\u1269\ue8e9\u610e\ue750\u7db2\uf3e7\u4849\uce9a\u44e1", 57324718, -982359547);
            list.add(ubm3);
            return a.c(-435270875, "\u4b69\u32c6\ub812\u266a\uada9\u2b51\u915c\u18ac\u86fb\u0c48\u8b9a\u71da\uff25\u668a\uecde\u6a26\ud07d\u5ff3\uc51c\u4358\ucabe\ub0a1\u3e4c\ua58b\u23e7\ua930\u108b\u9edb\u041d\u8263\u09c5\uf705\u7d12\ue4a7\u62fd\ue859\u57c0\udde3\u5b37\uc29b\u48d8\u3634\ubc4b\u3bcd\ua113\u2f77\u96fc\u1c03\u9a4f\u019c\u8fe7\u7567\ufc80\u7ade\ue03c\u6e69\ud5c7\u5314\ud96f").equals(ucg.cosmeticsOf(a.d("\u0d7a\u74e1\ufe31\u6058\uebba\u6d26\ud76e", 504606791, -759120516))) && ucg.cosmeticsOf(a.b("\ufc3b\u85ab\u0f75\u9109\u1ad5\u9c79", 661519475)) == null;
        }
        catch (Exception exception) {
            System.out.println(a.d("\uba61\uc3c1\u4901\ud776\u5cac\uda44\u605e\ue9a8\u77f3\ufd4d\u7a98\u80fe\u0e7d\u978a\u1dde\u9b27\u216d\uaeb5\u3407\ub208\u3be5", -1847751607, -954714547) + exception);
            return false;
        }
    }

    private static boolean fle(MinecraftClient minecraftClient) {
        try {
            Entity entity = minecraftClient.field_1687.method_8469(fnq.spawned);
            Field field = Cosmetics.class.getDeclaredField(a.c(420921525, "\uc0ff\ub94c\u3384\uade8\u2639\ua089\u1ac7"));
            field.setAccessible(true);
            Map map = (Map)field.get(null);
            boolean bl = entity != null && map.containsKey(entity.method_5628());
            System.out.println(a.d("\uabf9\ud244\u588b\uc6e4\u4d3b\ucb9b\u71d5\uf82e\u6661\uec83\u6b02\u9164\u1fbb\u8608\u0c40\u8aa0\u30aa\ubf39\u2587\ua3cd\u2a6e", 420515449, 1299850742) + (entity == null ? a.c(-793928944, "\u9b7a\ue2cf\u6806\uf677\u7dba\ufb0c\u4156") : entity.method_5477().getString()) + a.c(-1623507862, "\u3c42\u45be\ucf6f\u5105\udacf\u5c78\ue62a\u6f95") + bl);
            return bl;
        }
        catch (Exception exception) {
            System.out.println(a.d("\u38fa\u4149\ucb81\u55ed\ude3c\u588c\ue291\u6b23\uf577\u7fcb\uf81e\u0267\u8cfb\u150c\u9f58\u19a1\ua3eb\u2c33\ub681\u308e\ub963", -1085271836, -363255706) + exception);
            return false;
        }
    }

    private static boolean flf(String string, String string2) {
        try {
            Field field = Class.forName(string).getDeclaredField(string2);
            field.setAccessible(true);
            return field.getBoolean(null);
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static void flg(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
        minecraftClient.field_1724.method_5636(f);
        minecraftClient.field_1724.field_6220 = f;
        minecraftClient.field_1724.method_5847(f);
    }

    private static void flh(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void fli(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\ua123\ud884\u525e\ucc25\u47b4\uc151\u7b13\uf2f4\u6cac\ue649", 1112318298) + string + a.c(1259479249, "\u20f2\u5923\ud390") + minecraftClient.method_47599() + a.b("\uab80\ud277\u58b2\uc6c0", -1293243484));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(-805849911, "\ub4a9\ucd12\u47c2\ud9ab\u5239\ud497") + string + a.c(-1084692205, "\ue939\u90d6\u1a1b\u8463")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        fko = a.b("\u5883\u212c\uabf8\u3580\ube43\u38bb\u82b6\u0b46\u9511\u1fa2\u9870\u6230\ueccf\u7560\uff34\u79cc\uc397\u4c19\ud6f6\u50b2\ud954\ua34b\u2da6\ub661\u300d\ubada\u0361\u8d31\u17f7\u9189\u1a2f\ue4ef\u6ef8\uf74d\u7117\ufbb3\u442a\uce09\u48dd\ud171\u5b32\u25de\uafa1\u2827\ub2f9\u3c9d\u8516\u0fe9\u89a5\u1276\u9c0d\u668d\uef6a\u6934\uf3d6\u7d83\uc62d\u40fe\uca85", -1791534897);
        fkn = new String[][]{{a.c(1025493841, "\ucb3c\ub299\u384d\ua621\u2deb\uab49\u1124\u98fd\u06bc\u8c0a\u0bd0\uf1b5"), a.c(1429218099, "\u2359\u5af9\ud037\u4e5e\uc590\u4310\uf974\u708c\ueec6"), a.b("\u1465\u6dd6\ue710\u794a\uf2b2\u7416\uce54", 1725830145)}, {a.c(-1455105884, "\ud8d9\ua170\u2ba4\ub5df\u3e03\ub8b5\u02f7\u8b21\u1556\u9ff9\u182d\ue255\u6c96"), a.d("\u24fd\u5d4b\ud785\u49e8\uc222\u44bf\ufedb\u7723\ue969", 1075746262, 1093710154), a.b("\uc3bb\uba09\u30cb\uaea9\u2567\ua3e2\u199e\u907a\u0e34", -980237375)}, {a.c(-2055241250, "\u81b3\uf816\u72d8\uecb5\u6765\ue1ff\u5b84\ud26b\u4c33\uc68b\u414c"), a.d("\u5932\u2088\uaa55\u3420\ubfc7\u394c\u831b\u0af9\u94a7", 1592752730, 411968271), a.d("\uf0a2\u8911\u03df\u9da9\u1678\u90d2\u2a8a\ua341\u3d31\ub795\u3057", -632387585, 1846835005)}, {a.c(994076566, "\u67f9\u1e49\u9492\u0ae1\u8137\u07b7\ubdcc\u3423\uaa7b\u20c3\ua704"), a.d("\ub92a\uc085\u4a4b\ud42d\u5ff1\ud977\u6313\ueaeb\u74a1", 949491773, -972512919), a.d("\ua49e\udd39\u57f7\uc987\u425b\uc4d0\u7eac\uf748\u6906", 901330400, -907177709)}, {a.d("\u49b4\u301f\ubad7\u24a1\uaf61\u29fd\u9386\u1a69\u8431\u0e89\u894e", -286517117, 1246056799), a.c(-1493936905, "\u5494\u2d28\ua7ff\u398b\ub24b\u34ec\u8eae\u0774\u991c\u13a4\u9462"), a.c(885054376, "\udbd6\ua278\u28a2\ub6de\u3d00\ubb8b\u01f7\u8813\u165d")}, {a.c(-1577781954, "\uf542\u8cea\u063f\u9843\u13af\u9536\u2f7b\ua68d\u38db\ub27e"), a.d("\u21e2\u585a\ud284\u4cf6\uc711\u4197\ufbcd\u7229", -129687334, -181599912), a.d("\u5535\u2c8b\ua65f\u3832\ub3e2\u3578\u8f04\u06e0\u98ae", 1566018214, -523247619)}, {a.b("\u7ce1\u0542\u8f9b\u11f4\u9a24\u1c86\ua6eb\u2f32\ub173\u3bc5\ubc1f\u467a", -604930914), a.d("\u0401\u7dba\uf76a\u6903\ue2c6\u6460\ude1e\u57d3\uc99d\u4331\uc4fa\u3e92", -1261658958, -246834983), a.c(2020558241, "\u45c9\u3c60\ub6a8\u28ea\ua312\u25b6\u9ff4"), a.d("\ud943\ua0f0\u2a36\ub46c\u3f94\ub934\u0365\u8a9c", 288221364, -161140324)}, {a.d("\u4662\u3fdc\ub506\u2b75\ua0ab\u2629\u9c52\u15bd\u8be5\u015d\u869a", -8236403, -766897019), a.c(1683486537, "\uf73a\u8e90\u045c\u9a02\u11e2\u975a\u2d1c"), a.b("\u3656\u4ff8\uc52e\u5b5b\ud084\u560f\uec73\u6597\ufbd9", -248891860)}, {a.b("\uf4a4\u8d1a\u07d8\u99ad\u126b\u94d8\u2e83", 1874523337), a.d("\u8de1\uf459\u7e9d\ue0cb\u6b2e\ued93\u57d2\ude3b", 1915558893, 12293730), a.c(-1081936415, "\uf582\u8c3c\u06e6\u9897\u1355\u95c2\u2fbe\ua65a\u3814")}, {a.d("\u98ef\ue15c\u6b9a\uf5c0\u7e38\uf898\u42c9\ucb30", -1002608043, 1121579729), a.d("\ud883\ua139\u2be4\ub591\u3e76\ub8fd\u02aa\u8b48\u1516", 1505158262, -191480686), a.b("\u9047\ue9e0\u6320\ufd57\u7688\uf038\u4a5a\uc384\u5dce\ud76e", 1701679145)}, {a.c(2091963029, "\ud2fa\uab4e\u218f\ubfed\u3431\ub29a\u08c8\u813e\u1f76\u95fd\u1201\ue861\u66b4\uff0d"), a.d("\uf621\u8f81\u054f\u9b26\u10e8\u9668\u2c0c\ua5f4\u3bbe", 660372061, 1754696726)}, {a.b("\u17dd\u6e6f\ue4a2\u7ad4\uf132\u77b7\ucdee\u440a\uda40\u50fe\ud722\u2d41", -1936451675), a.b("\u080c\u71ba\ufb74\u6519\ueed3\u684e\ud22a\u5bd2\uc598", 71960685)}, {a.c(-646497243, "\u3c4f\u45ea\ucf3e\u5152\uda98\u5c3a\ue657\u6f9a\uf1c7\u7b67\ufca1"), a.d("\uaf22\ud682\u5c4c\uc225\u49eb\ucf6b\u750f\ufcf7\u62bd", 197097614, -145107002)}, {a.c(790220942, "\ud0eb\ua951\u2385\ubde3\u362d\ub091\u0afc\u8331\u1d6c\u97cc\u100a"), a.b("\u864e\uffe1\u752f\ueb49\u6095\ue613\u5c77\ud58f\u4bc5", 544769584)}};
        fkw = System.getenv(a.b("\uf0ee\u8955\u0385\u9dec\u165e\u9082\u2acd\ua330\u3d73\ub7ce\u3003\uca65", 144437412));
    }

    private static /* synthetic */ int pn(int n, int n2) {
        return n + n2 ^ 0x4640E757;
    }

    private static /* synthetic */ int po(int n, int n2) {
        return fkm.pn(n, n2) * n2;
    }

    private static /* synthetic */ int pp(int n, int n2) {
        return fkm.po(n, n2) + n;
    }
}

