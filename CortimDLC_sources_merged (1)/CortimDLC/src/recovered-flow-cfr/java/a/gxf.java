/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.player.PlayerInventory
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.hlc;
import a.isv;
import a.ivw;
import a.iwf;
import a.kfe;
import a.uxi;
import a.vkl;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vmo;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Method;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.glfw.GLFW;

final class gxf {
    private static final String[] gxg = new String[]{a.b("\ue1b9\u983c\u12e8\u8c84\u074e\u81ec", 286974462), a.b("\u81a9\uf833\u72e7\uec81\u674f\ue1f3", -1340177951), a.d("\uf3a5\u8a32\u00ec\u9e90\u155e\u93ee", 1093878435, 1254666567), a.b("\uf1cd\u885a\u0292\u9cfe\u173f\u919f", 1486549400), a.d("\uc4a7\ubd39\u37e9\ua982\u2244\ua4e2", 2093519116, 793531886)};
    private static final int gxh = 40;
    private static final int gxi = 40 + gxg.length * 40 + 80;
    private static String gxj;
    private static int gxk;
    private static String gxl;
    private static /* synthetic */ boolean gxm;
    private static /* synthetic */ int gxn;

    private gxf() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        kfe kfe2 = gxf.gxr(a.d("\ua624\udfae\u5574\ucb00\u40d6\uc670\u7c02\uf5cb\u6b86", -1400977260, -633049366));
        kfe kfe3 = gxf.gxr(a.c(-1467238690, "\ub697\ucf12\u45c0\udbaa\u5041\ud6d4\u6c91\ue571"));
        kfe kfe4 = gxf.gxr(a.d("\uf655\u8fd2\u0516\u9b63\u10a7\u9601\u2c68\ua5b4\u3be2\ub14f\u3689\uccef", -279031647, 1297524395));
        if (n == gxk) {
            gxf.gxu(minecraftClient, a.b("\u05a7\u7c0e\uf6cf\u68ea", -1700592176) + gxj);
        }
        if (n == 1) {
            gxf.gxt(minecraftClient, a.b("\u1313\u6aa4\ue07b\u7e02\uf5dd\u736e\uc936\u40c6\udedc\u542e\ud3ec\u298a\ua759\u3efd\ub4b3\u325d\u8801", -1376840859));
            gxf.gxt(minecraftClient, a.d("\u741d\u0db1\u8766\u191f\u928d\u146f\uae2a\u27ca\ub9c1\u3366\ub4b3\u4ec2\uc015", -1797451190, -1527290322));
            gxf.gxt(minecraftClient, a.c(1548471383, "\ucc2d\ub58e\u3f59\ua13d\u2af6\uac4a\u160e\u9fad\u01b1\u8b0f\u0cd5\uf6a0\u7864"));
            gxf.gxt(minecraftClient, a.b("\u6869\u11de\u9b01\u0578\u8eb8\u080e\ub244\u3bbc\ua5a6\u2f53\ua88b\u52d1\udc23\u458a\ucfcc\u4938\uf379\u7ca7\ue608\u606e\ue9a3\u93e8\u1d54\u868c\u00b6\u8a21\u3395\ubdc9\u2721\ua166", -340170736));
            gxf.gxt(minecraftClient, a.d("\ue105\u98bb\u1261\u8c14\u07d0\u8133\u3b00\ub2c2", -247866706, -1525072960));
        } else if (n == 20) {
            gxf.gxo(minecraftClient, 0.0f, -8.0f, a.c(-130127514, "\u6917\u10b1\u9a6d\u041b\u8fc9\u0978\ub326"), n);
        } else if (n >= 40 && n < gxi - 80) {
            int n2 = (n - 40) / 40;
            int n3 = (n - 40) % 40;
            if (n3 == 0) {
                ((vlv)gxf.gxs(kfe2, a.c(159696790, "\uc7c6\ube4f\u348e"))).set(gxg[n2]);
                kfe2.setEnabled(true);
                uxi.timing(true);
                gxf.gxo(minecraftClient, 0.0f, -12.0f, gxg[n2].toLowerCase(), n);
            } else if (n3 == 12) {
                uxi.gpuMillis();
            } else if (n3 == 24) {
                System.out.println(a.b("\u57b0\u2e19\ua4d8\u3af0", 1992447943) + gxg[n2] + a.c(-877436460, "\u61f1\u1807\u92c3\u0cb7\u8735") + uxi.gpuMillis() + a.c(-2018424916, "\u478a\u3e76\ub4bb\u2a99\ua12e\u27ff") + minecraftClient.method_47599() + a.b("\u930f\ueaf8\u603d\ufe4f", -1476422869));
                gxf.gxo(minecraftClient, 140.0f, -50.0f, gxg[n2].toLowerCase() + a.d("\uc6cb\ubf22\u35f4", -2012466074, -895421821), n);
            }
        } else if (n == gxi - 75) {
            ((vlv)gxf.gxs(kfe2, a.b("\u50fb\u2972\ua3b3", 799035563))).set(a.b("\u4805\u319f\ubb4b\u252d\uaee3\u285f", -1308014515));
            ((vmc)gxf.gxs(kfe2, a.d("\ud08a\ua91c\u23d2\ubdb8\u367c\ub0d8\u0a8a\u8335\u1d28\u9797\u104d\uea37\u64ea", 1956890364, 696063539))).set(0.0);
            gxf.gxo(minecraftClient, 0.0f, -12.0f, a.c(-566170689, "\uebd6\u9266\u18b2\u86d4\u0d11\u8bea\u31fa\ub80a\u2658\uace7\u2b3d\ud147\u5f9a"), n);
        } else if (n == gxi - 60) {
            ((vmc)gxf.gxs(kfe2, a.d("\ufc00\u8596\u0f58\u9132\u1af6\u9c52\u2600\uafbf\u31a2\ubb1d\u3cc7\uc6bd\u4860", -1709473202, -913015285))).set(1.0);
            ((vkl)gxf.gxs(kfe2, a.c(1115575454, "\u54dd\u2d4d\ua793\u39e3\ub271\u3483\u8edf\u072d\u9968\u13c8\u940c"))).set(false);
            gxf.gxo(minecraftClient, 0.0f, -12.0f, a.d("\u2ab9\u5309\ud9dd\u47bb\ucc7e\u4a85\uf098\u7966\ue73a\u6d91\uea53\u1035", -439619257, 747428758), n);
        } else if (n == gxi - 45) {
            ((vkl)gxf.gxs(kfe2, a.c(2126270775, "\u5174\u28e4\ua23a\u3c4a\ub7d8\u312a\u8b76\u0284\u9cc1\u1661\u91a5"))).set(true);
            gxf.gxo(minecraftClient, 0.0f, -12.0f, a.c(-2001020906, "\ud879\ua1c9\u2b1d\ub57b\u3ebe\ub845\u0259\u8ba6\u15f0\u9f4a\u1893"), n);
        } else if (n == gxi - 30) {
            gxf.gxo(minecraftClient, 0.0f, -88.0f, a.c(379244016, "\ucd98\ub428\u3efc\ua09a\u2b5f\uada4\u17a0\u9e4e\u001a\u8aac\u0d62\uf70f"), n);
        } else if (n == gxi - 15) {
            ((vlv)gxf.gxs(kfe2, a.b("\uf72e\u8ea7\u0466", -611453058))).set(a.d("\ubbc0\uc257\u489f\ud6f3\u5d32\udb92", -1674279482, -834519469));
            gxf.gxo(minecraftClient, 180.0f, -10.0f, a.b("\u81d1\uf866\u72ae\uecc2\u6703\ue1a3\u5ba9\ud206\u4c5f\uc6f5", -412253784), n);
        } else if (n == gxi) {
            uxi.timing(false);
            ((vlv)gxf.gxs(kfe2, a.b("\u2b8e\u5207\ud8c6", -738579490))).set(a.d("\u3140\u48c5\uc211\u5c7d\ud7b7\u5115", -613721265, -373134776));
            gxf.gxo(minecraftClient, 0.0f, 0.0f, a.b("\u8ecb\uf77d\u7db3\ue3d9\u681d\ueeb9\u54eb", -1439199580), n);
            gxf.gxt(minecraftClient, a.c(570476759, "\uc8a1\ub116\u3bc9\ua5b0\u2e6f\ua8dc\u1284\u9b74\u056e\u8f8c\u0859\uf22f\u7cfc\ue552\u6f1e\ue9f8\u53ba"));
            gxf.gxt(minecraftClient, a.c(-399674710, "\u7281\u0b2d\u81ef\u1f96\u940c\u12ef\ua8ab\u214f\ubf0c\u35b0\ub261\u4816\uc684\u5f70\ud528\u53c3\ue991\u665d\ufce3\u7aeb\uf37c\u891e\u07fe\u9c66\u1a1e\u90d7\u2977\ua72d\u3dc0\ubb8a\u3024\ucefe\u44e6\udd0a\u5b4a\ud1ac\u6e65\ue409\u62c6\ufb3f\u712d\u0fd8\u858c\u0236\u98e7\u1687\uaf47\u25f1\ua3ac\u3833\ub60e\u4cc4\uc568\u4328\ud9d3\u57b0\uec3f\u6ae7\ue0ad\u7956\uf7fa\u8da1\u0a4f\u800e\u1ec6\u977e"));
            gxf.gxt(minecraftClient, a.b("\uf3ae\u8a02\u00c0\u9eb9\u1523\u93c0\u2984\ua060\u3e23\ub49f\u334e\uc939\u47ab\ude5f\u5407\ud2ec\u68be\ue772\u7dcc\ufbc4\u7253\u0831\u86d1\u1d49\u9b31\u11f8\ua858\u2602\ubcef\u3aa5\ub10b\u4fd1\uc5c9\u5c22\uda65\u5083\uef4a\u6526\ue3e9\u7a10\uf002\u8ef7\u04a3\u8319\u19c8\u97a8\u2e68\ua4de\u2283\ub91c\u3721\ucdeb\u4447\uc207\u58fc\ud69f\u6d10\uebc8\u6182\uf879\u76d5\u0c8e\u8b60\u0121\u9fe9\u1651\uac3e\u2af9\ua0aa\u3f1c\ub5c4\u33b3\uca7d\u40df\ude8b\u5568\ud371\u699f\ue047\u7e3b\uf4ff\u72a7\u091b\u87d0\u1dbe\u9467\u12df\ua894\u2740\ubd29\u3b91\ub245\u4835\uc6fe\u5d66\udb07\u51d1\uefb3\u6677\ufcc6\u7a8a\uf176\u8f24\u05cd\u9c5b\u1a2c\u90f8\u2f59\ua547\u23f7\ub9a0\u3016\uced2\u4485\uc367\u5925\ud795\u6e56\ue46b\u62e3\uf94a\u771d\u0de9\u8ba3\u0216\u98f5\u16b7\uad69\u2b2a\ua193\u3818\ub673\u48a1\ucf02\u455a\udba8\u518e\ue842\u6e9d\ue4e1\u7f2b\uf1a0\u77a9\u0e5b\u841f\u1abe\u9177\u1751\uada8\u238d\ube56\u34fd", -279907489));
            gxf.gxt(minecraftClient, a.d("\u2bb0\u521c\ud8de\u46a7\ucd3d\u4bde\uf19a\u787e\ue63d\u6c81\ueb50\u1127\u9fb5\u0641\u8c19\u0af2\ub0a0\u3f6c\ua5d2\u23da\uaa4d\ud02f\u5ecf\uc557\u432f\uc9e6\u7046\ufe1c\u64f1\ue2bb\u6915\u97cf\u1dd7\u843d\u027b\u889d\u3754\ubd38\u3bf7\ua20e\u281c\u56e9\udcbd\u5b07\uc1d6\u4fb6\uf676\u7cc0\ufa9d\u6102\uef3b\u15f6\u9c4c\u1a05\u80ea\u0eac\ub53e\u33d8\ub9a6\u2073\uaec1\ud4af\u536a\ud93f\u47f7\uce4d\u7418\uf2f8\u78bc\ue70a\u6dcb\uebf4\u1272\u98d5\u0680\u8d76\u0b3a\ub189\u3868\ua628\u2ce8\uaab5\ud10e\u5f87\uc5ea\u483d\uceeb\u74cb\ufb41\u6160\ue3c3\u6e17\u9475\u1aaa\u8166\u0746\u899e\u3795", 1202682835, -802467736));
            gxf.gxt(minecraftClient, a.d("\u50ba\u2916\ua3d4\u3dad\ub637\u30d4\u8a90\u0374\u9d37\u178b\u905a\u6a2d\ue4bf\u7d4b\uf713\u71f8\ucbaa\u4466\uded8\u58d0\ud147\uab25\u25c5\ube5d\u3825\ub2ec\u0b4c\u8516\u1ffb\u99b1\u121f\uecc5\u66dd\uff3b\u7971\uf397\u4c5e\uc632\u40fd\ud904\u5316\u2de3\ua7b7\u200d\ubadc\u34bc\u8d7c\u07ca\u8197\u1a08\u9431\u6ef8\ue746\u6118\ufbf1\u75bb\uce06\u48e5\uc2a4\u5b7d\ud5c2\uaf9c\u287f\ua23d\u3cfd\ub547\u0f2a\u89ed\u03be\u9c08\u16d0\u90a7\u6969\ue3cb\u7d9f\uf67c\u7065\uca8d\u4348\udd3f\u57f7\ud1bd\uaa0c\u24ef\ubea9\u3777\ub1c8\u0b91\u8436\u1e7d\u9cf8\u1506\uef79\u61d2\ufa62\u785c\uf683\u4881\uc151\u5b90\ud9d0\u525b\u2c75\ua6d5\u3f09", 1970188207, 1065352981));
            gxf.gxt(minecraftClient, a.c(1043354762, "\u5487\u2d2b\ua7e9\u3990\ub20a\u34e9\u8ead\u0749\u990a\u13b6\u9467\u6e10\ue082\u7976\uf32e\u75c5\ucf97\u405b\udae5\u5ced\ud57a\uaf18\u21f8\uba60\u3c18\ub6d1\u0f71\u812b\u1bc6\u9d8c\u1622\ue8f8\u62e0\ufb0e\u7d5c\uf7fd\u487d\uc212\u44dc\udd71\u5766\u29da\ua38d\u243b\ubee7\u3090\u8952\u03f0\u85b8\u1e7b\u9046\u6ac3\ue37f\u653f\uffd0\u718c\uca24\u4cee\uc680\u5f40\ud1cd\uabb0\u2c53\ua613\u38cf\ub16f\u0b17\u8dd0\u0783\u9835\u12ed\u949a\u6d54\ue7f6\u79a2\uf241\u7458\uceb0\u4775\ud902\u53ca\ud580\uae31\u20d2\uba94\u334a\ub5f5\u0fac\u800b\u1a40\u98f6\u1145\ueb42\u659c\ufe2a\u7871\uf6a9\u48a2\uc10c\u5baa"));
            gxf.gxt(minecraftClient, a.c(1808482395, "\u406d\u39c1\ub303\u2d7a\ua6e0\u2003\u9a47\u13a3\u8de0\u075c\u808d\u7afa\uf468\u6d9c\ue7c4\u612f\udb7d\u54b1\uce0f\u4807\uc190\ubbf2\u3512\uae8a\u28f2\ua23b\u1b9b\u95c1\u0f2c\u8966\u02c8\ufc12\u760a\uefe4\u69b7\ue317\u5c97\ud6f8\u5036\uc99b\u438c\u3d30\ub767\u30d1\uaa0d\u247a\u9db8\u171a\u9152\u0a91\u84ac\u7e23\uf782\u71c8\ueb37\u6567\udee3\u5806\ud27b\u4ba3\uc508\ubf72\u38b7\ub2e2\u2c2a\ua590\u1fc5\u9925\u1361\u8cd7\u0616\u8029\u79af\uf308\u6d5d\ue6ab\u60e7\uda54\u53b5\ucdf5\u4735\uc168\ubad3\u345a\uae37\u23de\ua549\u1f13\u909d\u0acf\u8819\u01b2\ufbb8\u757b\ueeca"));
            gxf.gxt(minecraftClient, a.d("\uec15\u95b9\u1f7b\u8102\u0a98\u8c7b\u363f\ubfdb\u2198\uab24\u2cf5\ud682\u5810\uc1e4\u4bbc\ucd57\u7705\uf8c9\u6277\ue47f\u6de8\u178a\u996a\u02f2\u848a\u0e43\ub7e3\u39b9\ua354\u251e\uaeb0\u506a\uda72\u439c\uc5cc\u4f6f\uf0ef\u7a80\ufc4e\u65e3\ueff4\u9148\u1b1f\u9ca9\u0675\u8802\u31c0\ubb62\u3d2a\ua6e9\u28d4\ud24c\u5bfd\uddbe\u474b\uc909\u729f\uf478\u7e0f\ue7d9\u6965\u1332\u94d0\u1e92\u805a\u09f9\ub3e4\u354c\ubf0d\u20ba\uaa6e\u2c04\ud5d9\u5f5a\uc138\u4ac6\ucc9d\u7624\uffaf\u61c4\uef03\u694f\u12f3\u9c2f\u0627\u8b99\u0935\ub310\u3c9f\ua6b9\u2461\uadca\u57c0\ud902", 2090656541, -1951920321));
            gxf.gxt(minecraftClient, a.c(-774508021, "\uf207\u8bab\u0169\u9f10\u148a\u9269\u282d\ua1c9\u3f8a\ub536\u32e7\uc890\u4602\udff6\u55ae\ud345\u6917\ue6db\u7c65\ufa6d\u73fa\u0998\u8778\u1ce0\u9a98\u1051\ua9f1\u27ab\ubd46\u3b0c\ub0a2\u4e78\uc460\u5d8e\udbdf\u517d\ueefd\u6492\ue25c\u7bf1\uf1e6\u8f5a\u050d\u82bb\u1867\u9610\u2fd2\ua570\u2338\ub8fb\u36c6\ucc48\u45f4\uc3af\u595d\ud71b\u6c89\uea62\u600d\uf9c0\u7749\u0d2e\u8ad9\u008f\u9e4b\u17fc\uadbe\u2b5c\ua10c\u3eaf\ub432\u321a\ucbd3\u4164\udf30\u54da\ud28f\u680c\ue1ee\u7f90\uf553\u730a\u08e1\u862a\u186e\u919e\u172f\uad77\u22f6\ub8df\u3e61\ub7b8\u4db0\uc313\u58d6\udef9\u5441\uee58\u67f1\ufd3d\u7b78"));
            gxf.gxt(minecraftClient, a.d("\ubb76\uc2da\u4818\ud661\u5dfb\udb18\u615c\ue8b8\u76fb\ufc47\u7b96\u81e1\u0f73\u9687\u1cdf\u9a34\u2066\uafaa\u3514\ub31c\u3a8b\u40e9\uce09\u5590\ud3e8\u5922\ue087\u6ed5\uf431\u723c\uf995\u0750\u8d48\u14a7\u92e9\u1844\ua7db\u2de7\uab30\u3286\ub8d2\uc625\u4c67\ucbc5\u5115\udf76\u66eb\uec17\u6a46\uf190\u7fe9\u8503\u0c88\u8ad2\u1028\u9e6a\u25c0\ua313\u2925\ub0e5\u3e55", 384920718, 1493686188));
            gxf.gxt(minecraftClient, a.c(-507755810, "\u428b\u3b27\ub1e5\u2f9c\ua406\u22e5\u98a1\u1145\u8f06\u05ba\u826b\u781c\uf68e\u6f7a\ue522\u63c9\ud99b\u5657\ucce9\u4ae1\uc376\ub914\u37f4\uac6d\u2a15\ua0df\u197a\u9728\u0dcc\u8bc1l\ufead\u74b5\ued5a\u6b14\ue1b9\u5e26\ud41a\u52cd\ucb7b\u412f\u3fd8\ub59a\u3238\ua8e8\u268b\u9f16\u15f9\u93bb\u0862\u861d\u7cce\uf578\u7323\ue9eb\u6796\udc2d\u5ae4\ud08a\u494d"));
        } else if (n == gxi + 15) {
            kfe3.setEnabled(true);
            minecraftClient.method_1507((Screen)new iwf((ivw)((Object)kfe3), -1));
            gxf.gxp(a.b("\udf4b\ua6e5\u2c3b\ub24a\u3994\ubf64\u057c\u8c99\u12d1\u9860", -1272455370), n);
        } else if (n == gxi + 30) {
            Method method = iwf.class.getDeclaredMethod(a.d("\u2f7e\u56ce\udc10\u427c", -1716200507, -214502182), Integer.TYPE);
            method.setAccessible(true);
            method.invoke((Object)minecraftClient.field_1755, 1);
            gxf.gxp(a.d("\uc21f\ubbb1\u316f\uaf1e\u24c0\ua230\u183e\u91de\u0f8e\u8534\u02ee", 2146113667, 700635872), n);
        } else if (n == gxi + 45) {
            PlayerInventory playerInventory = minecraftClient.field_1724.method_31548();
            ivw ivw2 = (ivw)((Object)kfe3);
            ivw2.assign(0, playerInventory.method_5438(12));
            ivw2.assign(1, playerInventory.method_5438(13));
            ivw2.assign(2, playerInventory.method_5438(14));
            minecraftClient.method_1507((Screen)new iwf(ivw2, -1));
            gxf.gxp(a.b("\uf694\u8f3a\u05e4\u9b95\u104b\u96bb\u2ca3\ua55d\u3b07\ub1b6\u366c\ucc1c", 840627951), n);
        } else if (n == gxi + 49) {
            gxf.gxq(minecraftClient, 0.5f, 0.32f);
        } else if (n == gxi + 60) {
            ((ivw)((Object)kfe3)).pick(2);
            minecraftClient.method_1507(null);
        } else if (n == gxi + 70) {
            System.out.println(a.b("\u4ecb\u3762\ubda3\u238b\ua80b\u2ea5\u94fb\u1d0a\u835c\u09a1\u8e21\u7454\ufa95\u6335\ue92c\u6fc7\ud5c7\u5a1f\uc0ac\u46f3\ucf0d\ub553\u3bea\ua062", 1980059296) + minecraftClient.field_1724.method_6079().method_7964().getString() + (minecraftClient.field_1724.method_6079().method_7964().getString().contains(a.d("\u7126\u08f2\u8250\u1c54\u97f3", 1499429615, -1918955539)) ? a.c(-1372385264, "\u1035\u69f4\ue336\u7d55\uf682") : a.b("\ua129\ud8fe\u522a\ucc53\u4781", 356229388)));
            kfe4.setEnabled(true);
            vlq vlq2 = (vlq)gxf.gxs(kfe4, a.b("\u78e3\u016f\u8bad\u15d4\u9e4e\u18a8\ua2e4\u2b18\ub547\u3fff", 151091360));
            vlq2.set(72);
            kfe4.onKey(minecraftClient, 72);
            gxf.gxp(a.c(-1904588063, "\u4a9a\u3334\ub9ea\u279b\uac45\u2ab5\u90a3\u195f\u8709\u0da4\u8a62\u7004"), n);
        } else if (n == gxi + 74) {
            gxf.gxq(minecraftClient, 0.62f, 0.42f);
        } else if (n == gxi + 85) {
            minecraftClient.method_1507(null);
            ((vlq)gxf.gxs(kfe4, a.b("\u654a\u1cc6\u9604\u087d\u83e7\u0501\ubf4d\u36b1\ua8ee\u2256", 1981768969))).set(-1);
            kfe4.setEnabled(false);
            kfe3.setEnabled(false);
            gxl = isv.selected();
            isv.select(a.c(-1020334405, "\ueec2\u976b\u1daa\u8398\u0814\u8eb1\u34e5\ubd09\u234b\ua9e9"));
            minecraftClient.method_1507((Screen)new hlc());
            gxf.gxp(a.d("\u4300\u3ab9\ub061\u2e0b\ua584\u2379\u993e\u10c8\u8e8a\u0426\u83e6", 1396068737, -629271833), n + 10);
        } else if (n == gxi + 110) {
            isv.select(a.c(-1393836138, "\ubfef\uc646\u4c87\ud2b5\u5936\udf8c\u65d8\uec3e\u7278\uf8c4"));
            gxf.gxp(a.c(1969699761, "\u3bd7\u426e\uc8b6\u56dc\udd53\u5ba1\ue1f9\u680f\uf647\u7cef\ufb31"), n);
        } else if (n == gxi + 125) {
            isv.select(a.c(-1460742908, "\ud57d\uacd4\u2615\ub827\u33b9\ub50e\u0f46\u86aa\u18e3\u9243"));
            gxf.gxp(a.b("\u9f71\ue6c8\u6c10\uf27a\u79f5\uff1a\u454f\ucca5\u52e7\ud840\u5f82", 1870307095), n);
        } else if (n == gxi + 140) {
            isv.select(a.b("\u61f2\u1854\u929b\u0cef\u8720\u018c\ubbd8\u327d\uac6b\u26c8\ua111\u5b7e\ud5ae\u4c0c\uc613\u40a1\ufae9\u7536\uef8a\u69c7", 1963745668));
            gxf.gxp(a.b("\uea32\u938b\u1953\u8739\u0cb6\u8a5a\u3011\ub9e7\u27a3\uad09", 40299093), n + 15);
        } else if (n == gxi + 170) {
            gxf.gxp(a.d("\u896c\uf0d5\u7a0d\ue467\u6fe8\ue904\u534f\udab9\u44fd\uce57\u49c6\ub3f6\u3d2c\ua488\u2eca\ua82c", 832447595, -2064863878), n);
        } else if (n == gxi + 185) {
            isv.select(gxl);
            minecraftClient.method_1507(null);
            kfe2.setEnabled(false);
            gxf.gxt(minecraftClient, a.b("\u9a31\ue386\u6959\uf720\u7ce0\ufa56\u401c\uc9e4\u57fe\udd0b\u5ad3\ua089\u2e7b\ub7d2\u3d94\ubb60\u0121\u8eff\u1450\u9236\u1bfb\u61b0\uef0c\u74d4\uf2ee\u786b\uc1de\u4f88\ud56f", 90413643));
            gxf.gxt(minecraftClient, a.b("\ub9cd\uc07a\u4aa5\ud4dc\u5f03\ud9b0\u63e8\uea18\u7402\ufef0\u7932\u8354\u0d87\u9423\u1e6d\u9883\u22df", -1530349125));
            return true;
        }
        return false;
    }

    private static void gxo(MinecraftClient minecraftClient, float f, float f2, String string, int n) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
        gxf.gxp(string, n);
    }

    private static void gxp(String string, int n) {
        gxj = string;
        gxk = n + 10;
    }

    private static void gxq(MinecraftClient minecraftClient, float f, float f2) {
        int[] nArray = new int[1];
        int[] nArray2 = new int[1];
        GLFW.glfwGetWindowSize((long)minecraftClient.method_22683().method_4490(), (int[])nArray, (int[])nArray2);
        GLFW.glfwSetCursorPos((long)minecraftClient.method_22683().method_4490(), (double)((float)nArray[0] * f), (double)((float)nArray2[0] * f2));
    }

    private static kfe gxr(String string) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 == null) {
            throw new IllegalStateException(a.b("\u04e2\u7d52\uf7ce\u69f2\ue227\u649d\udedf\u5737\uc961\u4395", 704185478) + string);
        }
        return kfe2;
    }

    private static vmo gxs(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.b("\u8eca\uf733\u7de9\ue38a\u680e\ueef1\u54a3\udd1d", -637563166) + string);
    }

    private static void gxt(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void gxu(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\ud3dd\uaa7a\u20a0\ubedb\u354a\ub3af\u09ed\u800a\u1e52\u94b7", -1202728028) + string + a.d("\u5125\u28f4\ua247", -1595525772, -944544654) + minecraftClient.method_47599() + a.d("\ud862\ua195\u2b50\ub522", -1519773701, -73674819));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\uc748\ubef3\u3423\uaa4a\u21d8\ua776", 2105204273, -146532071) + string + a.b("\u7768\u0e87\u844a\u1a32", -497649854)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        gxk = -1;
    }

    private static /* synthetic */ int xj(int n, int n2) {
        return n + n2 + -116137160;
    }

    private static /* synthetic */ int xk(int n, int n2) {
        return gxf.xj(n, n2) + n;
    }
}

