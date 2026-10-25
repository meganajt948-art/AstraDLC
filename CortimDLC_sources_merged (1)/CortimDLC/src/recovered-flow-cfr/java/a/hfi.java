/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.hlc;
import a.hyz;
import a.izx;
import a.kfe;
import a.kfx;
import a.ruv;
import a.vkl;
import a.vlq;
import a.vlv;
import a.vmo;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class hfi {
    private static final List<PlayerEntity> hfj = new ArrayList<PlayerEntity>();
    private static PlayerEntity hfk;
    private static final int hfl = 80;
    private static final String[] hfm;
    private static final String[] hfn;
    private static long hfo;
    private static long hfp;
    private static boolean hfq;
    private static /* synthetic */ String hfr;
    private static /* synthetic */ int hfs;

    private hfi() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        ruv ruv2 = (ruv)kfx2.getByName(a.b("\u2964\u50e0\uda20\u4444\ucf91\u4931\uf353\u7ab4\ue4e8", -889640647));
        switch (n) {
            case 1: {
                hfi.hgb(minecraftClient, a.d("\u42af\u3b18\ub1c7\u2fbe\ua461\u22d2\u988a\u117a\u8f60\u0592\u8250\u7836\uf6e5\u6f41\ue50f\u63e1\ud9bd", -29371973, 1391235938));
                hfi.hgb(minecraftClient, a.c(-579271001, "\u06de\u7f72\uf5a5\u6bdc\ue04e\u66ac\udce9\u5509\ucb02\u41a5\uc670\u3c01\ub2d6"));
                hfi.hgb(minecraftClient, a.b("\u4c69\u35ca\ubf1d\u2179\uaab2\u2c0e\u964a\u1fe9\u81f5\u0b4b\u8c91\u76e4\uf820", -1201714157));
                hfi.hfw(minecraftClient, 0.0f, 8.0f);
                hfk = hfi.hfy(minecraftClient, a.c(-1415440344, "\u1869\u61ee\ueb2a\u755f\ufe84"), 3.2, 0.0);
                hfk.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_22022));
                ruv.onAttack((Entity)hfk);
                ruv2.mode.set(a.d("\uc37f\ubae1\u3035\uae58\u2588\ua33e", 1150096127, -177745471));
                ruv2.setEnabled(true);
                izx.TARGET.enabled.set(false);
                break;
            }
            case 22: {
                hfi.hgd(minecraftClient, a.c(-1654873138, "\ua3b6\uda41\u5093\ucefe\u4561\uc3c6\u7996\uf03a\u6e2f\ue491\u6345\u9928\u17f8\u8e4e"));
                break;
            }
            case 23: {
                ruv2.mode.set(a.c(-537484703, "\ua23a\udba8\u516a\ucf08\u44c6\uc270\u782a\uf1cd"));
                break;
            }
            case 42: {
                hfi.hgd(minecraftClient, a.b("\ua2d4\udb23\u51f2\ucf9c\u4403\uc2a4\u78f4\uf158\u6f59\ue5eb\u6229\u984b\u1685\u8f33\u0569\u838e", 1925489330));
                break;
            }
            case 43: {
                ruv2.mode.set(a.d("\u9f61\ue6eb\u6c3f\uf247", -445354524, 47117011));
                break;
            }
            case 56: {
                hfi.hgd(minecraftClient, a.c(1671574997, "\u35af\u4c58\uc688\u58e7\ud378\u55df\uef8f\u6623\uf823\u7289\uf55d\u0f25"));
                break;
            }
            case 63: {
                hfi.hgd(minecraftClient, a.b("\ufd45\u84b2\u0e62\u9042\u1bda\u9d23\u2766\uae94\u3096\uba78\u3db0\uc7c6\u4918", 1837301054));
                break;
            }
            case 64: {
                ruv2.mode.set(a.d("\uad91\ud40c\u5edd\uc0a4\u4b62\ucdd4", -595888241, 1616042587));
                break;
            }
            case 80: {
                hfi.hgd(minecraftClient, a.b("\u0d00\u74f7\ufe20\u6048\uebd7\u6d70\ud720\u5e8c\uc09d\u4a20\ucdf1\u3788\ub94e\u20f8", -770830984));
                break;
            }
            case 81: {
                ruv2.mode.set(a.c(-21445475, "\uc4d8\ubd4c\u3791\ua9ef\u2224\ua48f\u1edb\u972d\u097b"));
                break;
            }
            case 90: {
                hfi.hfk.field_6235 = 10;
                hfi.hfk.field_6254 = 10;
                ruv.onAttack((Entity)hfk);
                break;
            }
            case 91: {
                hfi.hgd(minecraftClient, a.b("\u991c\ue0eb\u6a3d\uf454\u7fcb\uf96c\u433c\uca90\u548e\ude3a\u59e7\ua399\u2d52\ub4f9\u3ead\ub85b\u021d\u8d86\u1770\u9120\u18ca", 787192191));
                break;
            }
            case 100: {
                hfi.hgd(minecraftClient, a.c(69428594, "\u6516\u1ce1\u9637\u0811\u8389\u0570\ubf35\u36c7\ua8c5\u2235\ua5e3\u5f9c\ud144\u48e9\uc2a0\u4456\ufe1e\u71c6"));
                System.out.println(a.c(-1877998296, "\u0551\u7cff\uf636\u6841\ue382\u653e\udf21\u5695\uc8dc\u426e\uc5ed\u3fdf\ub11b\u28af\ua2a9") + hfi.hgc(ruv.cpuMicros()) + a.b("\udcae\ua54a\u2f9f\ub1b2\u3a2c\ubc89\u06c9\u8f34\u1163", 1422187655));
                break;
            }
            case 101: {
                ruv2.setEnabled(false);
                izx.TARGET.enabled.set(true);
                hfi.hfz(minecraftClient, (Entity)hfk);
                hfi.hfu(kfx2, a.c(-8298297, "\u6089\u1905\u93c7\u0dbe\u8641\u00e6\ubab6"), true);
                hfi.hfu(kfx2, a.b("\ubd73\uc4ff\u4e3d\ud044\u5bae\udd27\u6765\uee9e\u70db\ufa60\u7da3", -1468875471), true);
                hfi.hgb(minecraftClient, a.c(722207029, "\u011b\u78ac\uf267\u6c16\ue7c3\u6173\udb6e\u52d2\ucc89\u463f\uc1e7\u3b90\ub556\u2cf4\ua6a0\u2043\u9a42\u15c0\u8f6e\u092e\u80d1\ufacd\u7420\uefbe\u69d0\ue35f\u5aa2\ud4ed\u4e01\uc845\u43a8\ubd35\u3766\uae8c\u28ca\ua220\u1dc5\u9789\u114b\u88f2\u02fa\u7c4a\uf60b\u71b7\ueb3e\u6557\udccb\u567e\ud036\u4bec\uc599\u3f59\ub6fd\u30ab\uaa4a\u2455\u9fb4\u1968\u9313\u0ace\u847b\ufe2b\u79d2\uf3c5\u6d04\ue4fa\u5ea5\ud84e\u5202\ucda9\u4734\uc14e\u3892\ub26c\u2c6e\ua7e3\u218d\u9b36\u12ed\u8c82\u0648\u802d\ufbbf\u7567\uef1d\u66d4\ue024\u5a7c\ud582\u4fd6\uc964\u40b4\uba89"));
                hfi.hgb(minecraftClient, a.d("\ucaa2\ub315\u39de\ua7af\u2c7a\uaaca\u10d7\u996b\u0730\u8d86\u0a5e\uf029\u7eef\ue74d\u6d19\uebfa\u51fb\ude79\u44d7\uc297\u4b68\u3174\ubf99\u241b\ua279\u28b6\u9113\u1f5a\u85f3\u03ec\u8841\u768b\ufcd1\u657e\ue360\u69cc\ud607\u5c64\udaec\u436f\uc90d\ub7ed\u3db6\uba50\u20c6\uaea5\u177b\u9d94\u1bc3\u805d\u0e2a\uf4fc\u7d40\ufb17\u61f5\uefb7\u540f\ud2cc\u58f1\uc17d\u4fc2\u3590\ub26b\u383b\ua6ff\u2f7f\u9512\u13f2\u99a5\u0608\u8cd2\u0ae4\uf335\u79cb\ue794\u6c7f\uea33\u5098\ud905\u477d\ucdfc\u4bfc\u3033\ubedb\u24a6\uad7f\u2bd2\u9186\u1e4d\u843d\u0287\u8b5b\u7134\uffa6\u641c\ue24c\u6886\ud6f6\u5f24\uc5df", 1177951666, -1578117369));
                hfi.hgb(minecraftClient, a.d("\u51bd\u280a\ua2c1\u3cb0\ub765\u31d5\u8bc8\u0274\u9c2f\u1699\u9141\u6b36\ue5f0\u7c52\uf606\u70e5\ucae4\u4566\udfc8\u5988\ud077\uaa6b\u2486\ubf19\u3978\ub3b5\u0a14\u841b\u1ea2\u98ed\u1345\ued81\u6790\ufe2b\u7862\uf2c9\u4d0a\uc720\u41c1\ud84d\u5203\u2cfa\ua6fe\u210e\ubbcb\u35b7\u8c3a\u0693\u8093\u1b46\u9532\u6fe8\ue659\u6019\ufaf9\u74af\ucf02\u499d\uc3ba\u5a60\ud4c6\uae8b\u2975\ua333\u3de7\ub44b\u0e09\u88c2\u02b9\u9d0c\u17c7\u91ab\u6862\ue295\u7cc8\uf776\u712d\ucb86\u424e\udc25\u56a4\ud0fe\uab01\u2581\ubf8a\u3662\ub0db\u0a82\u8563\u1f37\u99b0\u1040\uea3e\u64e2\uff49\u795b\uf39d\u4ded\uc43b\u5e8b\ud8dd\u5366", 1928688260, -1093721300));
                hfi.hgb(minecraftClient, a.d("\ue814\u91a3\u1b68\u8519\u0ecc\u887c\u3261\ubbdd\u2586\uaf30\u28e8\ud29f\u5c59\uc5fb\u4faf\uc94c\u734d\ufccf\u6661\ue021\u69de\u13c2\u9d2f\u06ad\u80cd\u0a0e\ub3e3\u3dfc\ua715\u215f\uaaf9\u5476\ude72\u4796\uc19e\u4b1d\uf4f7\u7e97\uf84c\u61aa\uebb4\u9557\u1f09\u98e6\u0229\u8c17\u35c0\ubf76\u3932\ua2e5\u2c87\ud645\u5ff5\ud9b6\u430b\ucd03\u76b0\uf06c\u7a1f\ue3c0\u6d7e\u1739\u90cd\u1a87\u8449\u0df3\ub7e7\u3118\ubb00\u24bd\uae74\u281e\ud1db\u5b24\uc57b\u4e88\uc896\u7276\ufbd9\u6591\uef54\u690d\u12a0\u9c74\u0637\u8fc7\u097d\ub321\u3cc6\ua6d4\u206e\ua9be\u53cc\udd1c\u46ae\uc0b5", 94637132, -1752112053));
                hfi.hgb(minecraftClient, a.d("\u3840\u41f7\ucb3c\u554d\ude98\u5828\ue235\u6b89\uf5d2\u7f64\uf8bc\u02cb\u8c0d\u15af\u9ffb\u1918\ua319\u2c9b\ub635\u3075\ub98a\uc396\u4d7b\ud6f9\u5099\uda54\u63fa\uedb8\u7711\uf10e\u7aa3\u8469\u0e33\u979c\u1184\u9b2e\u24e5\uae86\u280e\ub18d\u3bef\u450f\ucf54\u48b2\ud224\u5c47\ue599\u6f76\ue921\u72bf\ufcc8\u061e\u8fa2\u09f5\u9317\u1d55\ua6ed\u202e\uaa13\u339b\ubd20\uc77c\u408f\ucad0\u5416\uddb1\u67e5\ue10f\u6b59\uf4e3\u7e77\uf808\u0198\u8b25\u156c\u9e86\u18cb\ua234\u2beb\ub598\u3f1e\ub91e\uc2d1\u4c39\ud644\u5f9d\ud930\u6364\uecaf\u76df\uf065\u79b9\u83d6\u0d44\u96fe\u10ae\u9a64\u2414\uadc6\u373d", -1831622921, -1714643296));
                hfi.hgb(minecraftClient, a.b("\uee4a\u97fd\u1d36\u8347\u0892\u8e22\u343f\ubd83\u23d8\ua96e\u2eb6\ud4c1\u5a07\uc3a5\u49f1\ucf12\u7513\ufa91\u603f\ue67f\u6f80\u159c\u9b71\u00ec\u8681\u0c0e\ub5f3\u3bbc\ua150\u2714\uacf9\u5260\ud839\u4193\uc7f2\u4d7e\uf2b8\u78c1\ufe45\u67b5\uedf8\u9304\u1909\u9ea0\u0438\u8a4d\u3399\ub923\u3f6a\ua4aa\u2aca\ud01c\u59b9\udfa6\u450a\ucb50\u70e5\uf635\u7c51\ue5ad\u6b35\u1171\u9686\u1cc4\u8215\u0bea\ub1b7\u3709\ubd52\u22f9\ua831\u2e5a\ud7cb\u5d71\uc325\u489f\uce99\u7454\ufdbe\u63c5\ue902\u6f4d\u14fb\u9a1eH\u8990\u0f2e\ub567\u3adb\ua083\u2631\uafe5\u5593\udb43\u40ba", 349630054));
                hfi.hfw(minecraftClient, 0.0f, 38.0f);
                break;
            }
            case 140: {
                hfi.hgd(minecraftClient, a.b("\u7ad8\u032f\u89fa\u1790\u9c03\u1aaf\ua0ed\u2914\ub755", -220824921));
                break;
            }
            case 141: {
                hfi.hgb(minecraftClient, a.b("\u33cb\u4a78\uc0ae\u5edf\ud544\u5395\ue9e3\u602c\ufe5c\u74e0\uf33a\u095e\u87d1\u1e34\u947a\u129a\ua8dd\u273c", -1173605454));
                hfi.hfu(kfx2, a.d("\ua3b2\uda3e\u50fc\uce85\u457a\uc3dd\u798d", -803660341, -1876312521), false);
                minecraftClient.field_1724.method_31548().method_61496(0);
                minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8634, 16));
                hfi.hfu(kfx2, a.b("\u6ada\u1349\u998d\u07fd\u8c27\u0a9c\ub0d8\u3934\ua76d\u2ddd\uaa13", 1036610177), true);
                hfi.hfw(minecraftClient, 0.0f, -12.0f);
                break;
            }
            case 150: {
                hfi.hgd(minecraftClient, a.b("\ub7a9\uce5e\u448a\udae1\u516b\ud7cf\u6d98\ue47a\u7a3b\uf0cb\u7753\u8d25\u03e1", 774158290));
                break;
            }
            case 151: {
                hfi.hfw(minecraftClient, 30.0f, 32.0f);
                break;
            }
            case 160: {
                hfi.hgd(minecraftClient, a.c(1507032069, "\u7c7d\u058a\u8f51\u1135\u9abf\u1c1b\ua64c\u2fae\ub1ef\u3b1f\ubc8f\u46f5\uc826\u5184"));
                break;
            }
            case 161: {
                hfi.hfu(kfx2, a.c(-396307395, "\ud466\uadf5\u2731\ub941\u329b\ub420\u0e64\u8788\u19d1\u9361\u14af"), false);
                minecraftClient.field_1724.method_31548().method_5447(0, ItemStack.field_8037);
                hfi.hgb(minecraftClient, a.c(605698820, "\u3b57\u42f0\uc832\u5655\udd8c\u5b3e\ue161\u6898\uf68c\u7c63\ufbff\u019f\u8f16\u16f9\u9cf4\u1a48\ua014\u2f88\ub53f\u3369\uba95\uc0c2\u4e60\ud5a2\u53da\ud919\u60e4\ueefc\u740c\uf246\u79f4\u872e"));
                hfi.hgb(minecraftClient, a.d("\u1429\u6d8e\ue74c\u792b\uf2f2\u7440\uce1f\u47e6\ud9f2\u531d\ud490\u2ebf\ua036\u39d9\ub3c7\u3525\u8f27\u00f2\u9a46\u1c1c\u95ed\uefad\u610d\ufadb\u7cb6\uf629\u4fcf\uc190\u5b6d\udd08\u5688\ua85a\u221d", -1065952444, 1138872127));
                hfi.hfu(kfx2, a.b("\u2f03\u569c\udc4c\u4231\uc9ee\u4f7b\uf512\u7ce2\ue2a5\u6811\uefc5\u15bf", -526241971), true);
                hfi.hfx(minecraftClient, new Vec3d(Math.floor(minecraftClient.field_1724.method_23317()) + 0.5, Math.floor(minecraftClient.field_1724.method_23318()) + 0.6, Math.floor(minecraftClient.field_1724.method_23321()) + 3.5));
                break;
            }
            case 172: {
                hfi.hgd(minecraftClient, a.d("\u7527\u0cd0\u860a\u186f\u93fa\u1551\uaf03\u26ea\ub8b0\u3206\ub5de", 1593671134, 850593924));
                break;
            }
            case 173: {
                hfi.hfu(kfx2, a.b("\u7901\u009e\u8a4e\u1433\u9fec\u1979\ua310\u2ae0\ub4a7\u3e13\ub9c7\u43bd", 9468239), false);
                hfi.hgb(minecraftClient, a.c(-1442831450, "\u23cb\u5a6c\ud0ae\u4ec9\uc510\u43a2\uf9fd\u7004\uee10\u64ff\ue363\u1903\u978a\u0e65\u8468\u02d4\ub888\u3714\uada3\u2bf5\ua209\ud85e\u56fc\ucd3e\u4b46\uc185\u7878\uf672\u6c8d\ueac7"));
                hfi.hgb(minecraftClient, a.b("\uf58d\u8c2a\u06e8\u988f\u1356\u95e4\u2fbb\ua642\u3856\ub2b9\u3534\ucf1b\u4192\ud87d\u5263\ud481\u6e83\ue156\u7be2\ufdb8\u7449\u0e09\u80a9\u1b7f\u9d12\u178d\uae65\u203c\ubad0", -744884765));
                hfi.hfw(minecraftClient, 0.0f, 8.0f);
                hfj.add(hfi.hfy(minecraftClient, a.d("\ucdb9\ub42f\u3ef1\ua081\u2b51\uadea", -700706643, -453911216), -6.0, 1.0));
                hfj.add(hfi.hfy(minecraftClient, a.d("\udff1\ua664\u2cb4\ub2d0\u391f", 541876439, -1169571992), 3.0, -7.0));
                hfj.add(hfi.hfy(minecraftClient, a.c(1787343316, "\ub183\uc809\u42d4\udcaa\u5761"), 1.0, 9.0));
                hfj.add(hfi.hfy(minecraftClient, a.c(-2050079229, "\u4646\u3fd0\ub510"), 40.0, 25.0));
                hhf.add(a.c(-1364339382, "\ud504\uac91\u2641\ub825\u33ea"));
                kfe kfe2 = kfx2.getByName(a.b("\ua06a\ud9e8\u533b\ucd57\u4698\uc02d", -809131987));
                ((vkl)hfi.hfv(kfe2, a.b("\uf229\u8bb5\u017c\u9f0a\u14c8\u9276\u2828\ua1df", 974582373))).set(true);
                kfe2.setEnabled(true);
                break;
            }
            case 185: {
                hfi.hgd(minecraftClient, a.b("\u40e0\u3916\ub3c4\u2da8\ua633\u2091\u9ac2\u132e\u8d69\u07dc", -191741796));
                break;
            }
            case 186: {
                hfi.hfu(kfx2, a.b("\uc8ea\ub168\u3bbb\ua5d7\u2e18\ua8ad", -1417361235), false);
                for (PlayerEntity playerEntity : hfj) {
                    hfi.hfz(minecraftClient, (Entity)playerEntity);
                }
                hfj.clear();
                hhf.remove(a.c(-713189088, "\u996e\ue0fb\u6a2b\uf44f\u7f80"));
                hfi.hgb(minecraftClient, a.c(-1374378505, "\ua581\udc36\u56e9\uc890\u434f\uc5fc\u7fa4\uf654\u684e\ue2ac\u6579\u9f0f\u11dc\u8872\u023e\u84d8\u3e9a"));
                minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8176, 8));
                break;
            }
            case 190: {
                minecraftClient.field_1724.method_7344().method_7580(11);
                minecraftClient.field_1724.method_7344().method_7581(4.5f);
                break;
            }
            case 192: {
                hfi.hgd(minecraftClient, a.b("\u546b\u2d9d\ua74e\u3923\ub2aa\u3409\u8e4f\u07bf\u99e7\u1345\u9483\u6eef\ue03e\u798e", -540126189));
                break;
            }
            case 193: {
                hfi.hgb(minecraftClient, a.b("\u79c4s\u8aac\u14d5\u9f0a\u19b9\ua3e1\u2a11\ub40b\u3ef9\ub93b\u435d\ucd8e\u542a\ude64\u588a\ue2d6", 1496152498));
                minecraftClient.field_1724.method_31548().method_5447(0, ItemStack.field_8037);
                hfi.hfw(minecraftClient, 35.0f, 4.0f);
                break;
            }
            case 200: {
                hfi.hgd(minecraftClient, a.d("\u89a8\uf05e\u7a8e\ue4e0\u6f69\ue9c3\u5399\uda6d\u4433\uce95\u4947\ub368\u3dfd\ua445\u2e16", -405124736, 278708305));
                break;
            }
            case 201: {
                hfi.hfu(kfx2, a.b("\u895b\uf0d1\u7a0b\ue47f\u6fa9\ue90f\u535d", 1409321231), true);
                break;
            }
            case 210: {
                hfi.hgd(minecraftClient, a.b("\u58a9\u215f\uab8e\u35e1\ube68\u38c2\u8298\u0b6c\u9532\u1f94\u9846\u6269\uece0\u754d\uff17\u79f4", 529094863));
                break;
            }
            case 211: {
                ((vlv)hfi.hfv(kfx2.getByName(a.d("\u7658\u0fd2\u8508\u1b7c\u90aa\u160c\uac5e", 531804825, 1669121173)), a.c(-951277814, "\ua742\uded0\u5403\uca76"))).set(a.c(-1864331575, "\u8e9a\uf714\u7dd8\ue3b6\u686c"));
                break;
            }
            case 220: {
                hfi.hgd(minecraftClient, a.c(1571514803, "\u69d4\u1022\u9af4\u049c\u8f15\u09bf\ub3e5\u3a11\ua44f\u2ee9\ua93b\u5314\udd98\u4436\uce7a\u4894\uf2d6"));
                break;
            }
            case 221: {
                ((vlv)hfi.hfv(kfx2.getByName(a.d("\uf052\u89d8\u0302\u9d76\u16a0\u9006\u2a54", 1881793586, 39195700)), a.c(1903188971, "\u5ba3\u2231\ua8e2\u3697"))).set(a.d("\u23a1\u5a2c\ud0f6\u4e95", 1392243656, 938659902));
                hfi.hfu(kfx2, a.b("\ud9a3\ua029\u2af3\ub487\u3f51\ub9f7\u03a5", -1523394057), false);
                break;
            }
            case 222: {
                kfe kfe3 = kfx2.getByName(a.b("\ue0f7\u9973\u13a0\u8dd3", -310779735));
                ((vlv)hfi.hfv(kfe3, a.c(-526648438, "\ufbdf\u824c\u0888\u96ef\u1d38"))).set(a.c(154062266, "\ucde8\ub462\u3eb9\ua0c8\u2b14\uadac"));
                kfe3.setEnabled(true);
                kfe3.onKey(minecraftClient, ((vlq)hfi.hfv(kfe3, a.d("\ua9c9\ud056\u5a99", 909894838, -605139657))).get());
                break;
            }
            case 240: {
                hfi.hgd(minecraftClient, a.d("\ud744\uaeb2\u2465\uba0c\u318c\ub728\u0d7b\u8488", 171311575, 1308415725));
                break;
            }
            case 241: {
                kfe kfe4 = kfx2.getByName(a.d("\u0b1f\u729b\uf848\u663b", 68531645, -16335108));
                kfe4.onKey(minecraftClient, ((vlq)hfi.hfv(kfe4, a.b("\u5f82\u261d\uacd2", -563912758))).get());
                break;
            }
            case 255: {
                kfe kfe5 = kfx2.getByName(a.d("\ud032\ua9b6\u2365\ubd16", 2010665989, -1125350295));
                ((vlv)hfi.hfv(kfe5, a.b("\uc321\ubab2\u3076\uae11\u25c6", 708690804))).set(a.b("\ua47b\udded\u573d\uc944", 542286903));
                kfe5.setEnabled(false);
                System.out.println(a.b("\u76ec\u0f42\u858b\u1bfc\u903f\u1683\uac9c\u2537\ubb7d\u31cc\ub61d\u4c21\uc2b4\u5b06\ud157\u57ae\uedb0\u627b\uf88e\u7ed6\uf738\u8d3f", 985101964) + minecraftClient.field_1690.method_41808().method_41753());
                break;
            }
            case 256: {
                hfk = hfi.hfy(minecraftClient, a.d("\u32fc\u4b7b\uc1bf\u5fca\ud411", -1674618759, 1012099780), 3.2, 0.0);
                hfi.hfu(kfx2, a.c(-1624805604, "\u6f5d\u16d8\u9c1c\u026d\u899c\u0f0f\ub550"), true);
                minecraftClient.field_1690.field_1894.method_23481(true);
                minecraftClient.field_1690.field_1903.method_23481(true);
                break;
            }
            case 266: {
                minecraftClient.field_1690.field_1894.method_23481(false);
                minecraftClient.field_1690.field_1903.method_23481(false);
                minecraftClient.field_1724.method_36456(minecraftClient.field_1724.method_36454() + 180.0f);
                minecraftClient.field_1724.method_36457(25.0f);
                break;
            }
            case 276: {
                hfi.hgd(minecraftClient, a.c(-704559858, "\u4573\u3c85\ub651\u283b\ua3a7\u2502\u9f46\u16b7\u88ee\u025d\u8582"));
                System.out.println(a.b("\u8967\uf0c9\u7a00\ue477\u6fb4\ue908\u5317\udaa0\u44eb\uce4d\u499e\ub3e9\u3d3c\ua481\u2e85\ua86e\u1262\u9db1\u070e\u8157\u08b7\u72f5\ufc07", 1594853638) + minecraftClient.method_1560().getClass().getSimpleName() + a.c(1432191976, "\u83cc\ufa3c\u70fa\ueedf") + hfi.hgc(minecraftClient.method_1560().method_23318()) + a.c(-818678624, "\uf480\u8d3d\u07be\u99d3\u1209\u94a0\u2eef\ua709\u3904\ub3f4\u3432\uce17") + hfi.hgc(minecraftClient.field_1724.method_23318()));
                break;
            }
            case 277: {
                hfi.hfu(kfx2, a.c(119458082, "\uc963\ub0e6\u3a22\ua453\u2fa2\ua931\u136e"), false);
                break;
            }
            case 280: {
                kfe kfe6 = kfx2.getByName(a.d("\u101a\u699f\ue35b\u7d2a\uf6d4\u7046\uca15\u43e0", 1875664269, -2108666407));
                ((vlv)hfi.hfv(kfe6, a.c(9502400, "\ufe95\u8706\u0dc2\u93a5\u1872"))).set(a.c(1428842983, "\u69b5\u103f\u9ae4\u0495\u8f49\u09f1"));
                kfe6.setEnabled(true);
                kfe6.onKey(minecraftClient, ((vlq)hfi.hfv(kfe6, a.c(743270327, "\u67ff\u1e60\u94af"))).get());
                break;
            }
            case 283: {
                minecraftClient.field_1724.method_36456(minecraftClient.field_1724.method_36454() + 140.0f);
                break;
            }
            case 295: {
                hfi.hgd(minecraftClient, a.c(1768789185, "\u94bb\ued4d\u6798\uf9f3\u726f\uf4ca\u4e8e\uc77f\u5929\ud39b\u5448\uae3d"));
                System.out.println(a.d("\u8499\ufd37\u77fe\ue989\u624a\ue4f6\u5ee9\ud75e\u4915\uc3b3\u4460\ube18\u30cc\ua97d\u232a\ua58a\u1fdf\u904c\u0af2\u8ca8\u0542\u7f4a\uf1a0\u6a69\uec00\u6686", 664758633, -410260068) + hfi.hgc(minecraftClient.field_1724.field_6283) + a.c(-196679254, "\ue986\u9074\u1aa5\u84d8\u0f07\u89a1\u33e1\uba51\u2457\uaefe\u293b\ud31d") + hfi.hgc(minecraftClient.field_1773.method_19418().method_19330()));
                break;
            }
            case 296: {
                kfe kfe7 = kfx2.getByName(a.b("\u031f\u7a9a\uf05e\u6e2f\ue5d1\u6343\ud910\u50e5", -1550711983));
                kfe7.onKey(minecraftClient, ((vlq)hfi.hfv(kfe7, a.d("\ua0ab\ud934\u53fb", -441774236, 681422727))).get());
                ((vlv)hfi.hfv(kfe7, a.c(-1858900171, "\u6f60\u16f3\u9c37\u0250\u8987"))).set(a.c(-1753218900, "\u00e0\u7976\uf3a6\u6ddf"));
                kfe7.setEnabled(false);
                hfi.hfz(minecraftClient, (Entity)hfk);
                break;
            }
            case 300: {
                hfi.hgb(minecraftClient, a.b("\u70db\u0978\u83af\u1dcb\u9600\u10bc\uaaf8\u235b\ubd56\u37f4\ub02f\u4a59", -95129440));
                hfi.hfw(minecraftClient, 0.0f, -20.0f);
                break;
            }
            case 330: {
                hfi.hgd(minecraftClient, a.b("\ua628\udfde\u5504\ucb60\u40e8\uc64a\u7c11\uf5e7", 2049812054));
                break;
            }
            case 331: {
                hfi.hfu(kfx2, a.c(-102542321, "\u5449\u2dd9\ua737\u3971\ub2ad\u3416\u8e44\u07a2"), true);
                break;
            }
            case 340: {
                ((vkl)hfi.hfv(kfx2.getByName(a.b("\ue1c9\u9859\u12b7\u8cf1\u072d\u8196\u3bc4\ub222", -1249123953)), a.b("\ua618\udf9a\u5541\ucb37", 1745659470))).set(true);
                break;
            }
            case 360: {
                hfi.hgd(minecraftClient, a.d("\ue689\u9f7f\u15a4\u8bc1U\u86e5\u3cab\ub54d\u2b19\ua1a2\u2670\udc16\u529e\ucb70\u4130\uc7c9\u7d81", 1202997424, 2145889886));
                ((vkl)hfi.hfv(kfx2.getByName(a.d("\u5ad0\u2340\ua9ae\u37e8\ubc34\u3a8f\u80dd\u093b", 1731904335, 969972185)), a.d("\uea15\u9397\u194c\u873a", -978803554, 1710182109))).set(false);
                hfi.hgb(minecraftClient, a.d("\uba5f\uc3fc\u492b\ud74f\u5c84\uda38\u607c\ue9df\u77c3\ufd7d\u7aa7\u80d2\u0e16", 1766228525, -1360250872));
                break;
            }
            case 361: {
                hfi.hga(minecraftClient, a.c(-1308191608, "\u94dc\ued5a\u6782\uf9f9\u722f\uf489"));
                break;
            }
            case 385: {
                hfi.hgd(minecraftClient, a.b("\u91ad\ue858\u6289\ufce5\u7778\uf1db\u4b94\uc221\u5c21\ud687\u515f\uab24\u25f2\ubc54", 1828557269));
                break;
            }
            case 386: {
                hfi.hga(minecraftClient, a.b("\u4278\u3bf5\ub12b\u2f42\ua489\u222f", -1964031442));
                break;
            }
            case 405: {
                hfi.hgd(minecraftClient, a.d("\uea95\u9360\u19b0\u87dd\u0c40\u8ae3\u30ac\ub919\u271b\uadb6\u2a68\ud001\u5eca\uc76c", -1517345332, -209400031));
                break;
            }
            case 406: {
                hfi.hga(minecraftClient, a.d("\udfa1\ua63c\u2ced\ub293\u3947\ubfe3", 1959963310, 291861834));
                break;
            }
            case 425: {
                hfi.hgd(minecraftClient, a.b("\u97c2\uee37\u64e4\ufa8a\u7117\uf7b4\u4dfb\uc44e\u5a5f\ud0e2\u5733\uad4d\u2399\uba3d", -1494509638));
                break;
            }
            case 426: {
                hfi.hga(minecraftClient, a.b("\ua077\ud9e2\u532b\ucd4a", -745627586));
                break;
            }
            case 445: {
                hfi.hgd(minecraftClient, a.c(-631067390, "\uad78\ud48d\u5e5f\uc030\u4bad\ucd0e\u7741\ufef4\u60eb\uea5e\u6d97\u97f6"));
                break;
            }
            case 446: {
                minecraftClient.method_1507(null);
                hfi.hft();
                hfi.hfw(minecraftClient, 0.0f, 12.0f);
                hfk = hfi.hfy(minecraftClient, a.d("\uacee\ud569\u5fad\uc1d8\u4a03", 410241330, -1500224099), 3.2, 0.0);
                ruv.onAttack((Entity)hfk);
                for (int i = 0; i < 4; ++i) {
                    hfj.add(hfi.hfy(minecraftClient, a.c(976145247, "\ucb0e") + i, 6.0 + (double)(i * 5), (double)(i % 2 == 0 ? -1 : 1) * (4.0 + (double)(i * 3))));
                }
                hfi.hgb(minecraftClient, a.c(-1588745918, "\ua96a\ud0dd\u5a16\uc467\u4fb2\uc902\u731f\ufaa3\u64f8\uee4e\u6996\u93e1\u1d27\u8485\u0ed1\u8832\u3233\ubdb1\u271f\ua15f\u28a0\u52bc\udc51\u47cf\uc1a1\u4b2e\uf2d3\u7c9c\ue670\u6034\uebd9\u1543\u9f19\u06b3\u80d2\u0a5e\ub598\u3fe1\ub965\u2095\uaad8\ud424\u5e29\ud980\u4318\ucd6d\u74b9\ufe03\u784a\ue38a\u6dea\u973c\u1e99\u9886\u022b\u8c77\u37c0\ub11d\u3b6c\ua2bc\u2c01\u5616\ud1eb\u5bf5\uc536\u4c9d\uf6d5\u703e\ufa27\u659d\uef4d\u6973\u90fd\u1a30\u845a\u0fa1\u89fe\u3351\uba87\u24c2\uae2c\u2874\u53ca\udd03\u4737\uceef\u485d\uf209\u7df7\ue7a7\u615e"));
                hfi.hgb(minecraftClient, a.d("\u4cc5\u3572\ubfb9\u21c8\uaa1d\u2cad\u96b0\u1f0c\u8157\u0be1\u8c39\u764e\uf888\u612a\ueb7e\u6d9d\ud79c\u581e\uc2b0\u44f0\ucd0f\ub713\u39fe\ua27c\u241f\uaedf\u1732\u992d\u03c4\u858e\u0e28\uf0a7\u7aa0\ue347\u654f\uefcc\u5026\uda46\u5c9d\uc57b\u4f65\u3186\ubbd8\u3c37\ua6f8\u28c6\u9111\u1ba7\u9de3\u0634\u8856\u7294\ufb24\u7d67\ue7da\u69d6\ud261\u54b3\udec8\u4718\uc9a4\ub3c4\u3409\ube49\u2086\ua92b\u1371\u95c7\u1f9e\u8060\u0abf\u8cd4\u7510\uffbb\u61a6\uea5e\u6c47\ud6a7\u5f08\uc140\u4b85\ucddc\ub671\u38a5\ua2e6\u2b16\uadac\u17f0\u9817\u0205\u84bf\u0d6f\uf71d\u79cd\ue27f\u6464", -1436957165, -1026454843));
                hfi.hgb(minecraftClient, a.c(-1082757928, "\u6cf4\u1543\u9f88\u01f9\u8a2c\u0c9c\ub681\u3f3d\ua166\u2bd0\uac08\u567f\ud8b9\u411b\ucb4f\u4dac\uf7ad\u782f\ue281\u64c1\ued3e\u9722\u19cf\u8252\u043f\u8eb0\u374d\ub902\u23ee\ua5aa\u2e47\ud0df\u5a87\uc32d\u454c\ucfc0\u7006\ufa7f\u7cfb\ue50b\u6f46\u11ba\u9bb7\u1c1e\u8686\u08f3\ub127\u3b9d\ubdd4\u2614\ua874\u52a2\udb07\u5d18\uc7b2\u49ef\uf25d\u748c\ufef1\u6729\ue988\u93de\u1436\u9e66\u00a2\u8954\u3309\ub5b7\u3fec\ua047\u2a8f\uace4\u5575\udfc8\u4199\uca21\u4c27\uf6ea\u7f00\ue17b\u6bbc\uedf3\u9645\u18a0\u82f6\u0b2e\u8d90\u37d9\ub865\u223d\ua48f\u2d5b\ud72d\u59fd\uc204"));
                hfi.hgb(minecraftClient, a.d("\u1d1c\u64bb\uee79\u701e\ufbc7\u7d75\uc72a\u4ed3\ud0c7\u5a28\udda5\u278a\ua903\u30ec\ubaf7\u3c10\u8612\u09c7\u9373\u1529\u9cd8\ue698\u6838\uf3ee\u7583\uff1c\u46e6\uc8b0\u525c\ud40c\u5fb4", 266247674, 463437962));
                minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8634, 16));
                ruv2.mode.set(a.c(-1706255069, "\u9d78\ue4ea\u6e28\uf04a\u7b84\ufd32\u4768\uce8f"));
                break;
            }
            default: {
                if (n > 450 && n <= 450 + 80 * hfm.length) {
                    int n2 = (n - 451) / 80;
                    int n3 = (n - 451) % 80;
                    String string = hfm[n2];
                    if (n3 == 0) {
                        for (String string2 : hfn) {
                            boolean bl = string2.equals(a.c(-684734793, "\uc6e3\ubf69\u35b3\uabc7\u2011\ua6b7\u1ce5"));
                            hfi.hfu(kfx2, string2, string.equals(a.d("\u6f96\u162a\u9cf9\u02c4\u895c\u0fec", 77195613, 4884140)) || string.equals(a.c(2091798412, "\u4ff8\u3652\ubc88\u22fc\ua92a\u2f8c\u95de")) && bl || string.equals(a.c(223658741, "\uc29b\ubb27\u31f4\uafc9\u245c\ua2fa\u18a8\u910d\u0f01\u85ab\u0271\uf805\u76d3\uef75\u6527")) && !bl);
                        }
                        ruv.cpuMicros();
                        break;
                    }
                    if (n3 == 20) {
                        hfo = 0L;
                        hfp = System.nanoTime();
                        break;
                    }
                    if (n3 != 79) break;
                    double d = (double)(System.nanoTime() - hfp) / 1.0E9;
                    double d2 = d * 1000.0 / (double)Math.max(1L, hfo);
                    System.out.println(a.c(1761785443, "\ub619\ucfb7\u457e\udb09\u50ca\ud676\u6c69\ue5db\u7b88\uf125\u76f1\u8cd4") + string + a.d("\u28a9\u5102", -86010962, -1766868161) + hfi.hgc(d2) + a.d("\ue127\u98db\u1216\u8c3b\u07a5\u8100\u3b40\ub2bd\u2cea\ua61e\u21c5", -1929776881, -57602045) + Math.round((double)hfo / d) + a.b("\u7edb\u072c\u8de9\u139b\u9816\u1ea2\ua4fd\u2d69\ub320\u3992\ube31\u4403\ucac7\u5373\ud975", 348094196) + hfi.hgc(ruv.cpuMicros()) + a.c(-508716865, "\u9896\ue172\u6ba7\uf58a\u7e14\uf8b1\u42f1\ucb0c\u555b"));
                    break;
                }
                if (n <= 450 + 80 * hfm.length) break;
                for (String string : hfn) {
                    hfi.hfu(kfx2, string, false);
                }
                hfi.hfz(minecraftClient, (Entity)hfk);
                for (PlayerEntity playerEntity : hfj) {
                    hfi.hfz(minecraftClient, (Entity)playerEntity);
                }
                hfj.clear();
                hfi.hgb(minecraftClient, a.d("\ube81\uc732\u4de4\ud395\u580e\udedf\u64a9\ued66\u7316\uf9aa\u7e70\u8414\u0a9b\u937e\u1930\u9fd0\u2597\uaa76", 403356954, -1726479390));
                hfi.hgb(minecraftClient, a.b("\ubfb2\uc615\u4cd7\ud2b0\u5969\udfdb\u6584\uec7d\u7269\uf886\u7f0b\u8524\u0bad\u9242\u1859\u9ebe\u24bc\uab69\u31dd\ub787\u3e76\u4436\uca96\u5140\ud72d\u5db2\ue45a\u6a03\uf0ef", -421150756));
                minecraftClient.field_1724.method_31548().method_5447(0, ItemStack.field_8037);
                hyz.save();
                return true;
            }
        }
        return false;
    }

    private static void hft() {
        if (!hfq) {
            hfq = true;
            HudRenderCallback.EVENT.register((drawContext, renderTickCounter) -> ++hfo);
        }
    }

    private static void hfu(kfx kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static vmo hfv(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.c(1701043776, "\ude68\ua791\u2d4b\ub328\u38ac\ube53\u0401\u8dbf") + string);
    }

    private static void hfw(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static void hfx(MinecraftClient minecraftClient, Vec3d vec3d) {
        Vec3d vec3d2 = vec3d.method_1020(minecraftClient.field_1724.method_33571());
        hfi.hfw(minecraftClient, (float)Math.toDegrees(Math.atan2(-vec3d2.field_1352, vec3d2.field_1350)), (float)(-Math.toDegrees(Math.atan2(vec3d2.field_1351, Math.hypot(vec3d2.field_1352, vec3d2.field_1350)))));
    }

    private static PlayerEntity hfy(MinecraftClient minecraftClient, String string, double d, double d2) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0);
        Vec3d vec3d2 = new Vec3d(-1.0, 0.0, 0.0);
        Vec3d vec3d3 = minecraftClient.field_1724.method_73189().method_1019(vec3d.method_1021(d)).method_1019(vec3d2.method_1021(d2));
        otherClientPlayerEntity.method_5808(vec3d3.field_1352, minecraftClient.field_1724.method_23318(), vec3d3.field_1350, 180.0f, 0.0f);
        otherClientPlayerEntity.method_5636(180.0f);
        otherClientPlayerEntity.method_5847(180.0f);
        otherClientPlayerEntity.field_6220 = 180.0f;
        otherClientPlayerEntity.field_6259 = 180.0f;
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6174, new ItemStack((ItemConvertible)Items.field_8058));
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static void hfz(MinecraftClient minecraftClient, Entity entity) {
        if (entity != null) {
            minecraftClient.field_1687.method_2945(entity.method_5628(), Entity.RemovalReason.field_26999);
        }
    }

    private static void hga(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.d("\ub4e1\ucd45\u4795\ud9cd\u5234\ud499", 1522891369, 1873727226));
        field.setAccessible(true);
        field.set(null, string);
        Field field2 = hlc.class.getDeclaredField(a.c(-830912732, "\u4770\u3ed1\ub413\u2a7f\ua1ab\u271a\u9d56"));
        field2.setAccessible(true);
        ((Map)field2.get(null)).clear();
        for (String string2 : new String[]{a.c(-1988972275, "\ub17d\uc8d2\u4206\udc7d\u57a1\ud108\u6b74"), a.d("\ucca4\ub50b\u3fdf\ua1a4\u2a78\uacd1\u16ac", -1042722861, 1113031431)}) {
            Field field3 = hlc.class.getDeclaredField(string2);
            field3.setAccessible(true);
            field3.setFloat(null, Float.NaN);
        }
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void hgb(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static String hgc(double d) {
        return String.format(Locale.ROOT, a.d("\u21b7\u580d\ud2c2\u4ce7", 2082499842, -1915401068), d);
    }

    private static void hgd(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u0ac0\u7367\uf9bd\u67c6\uec57\u6ab2\ud0f0\u5917\uc74f\u4daa", 334564025) + string + a.c(915238833, "\u6f92\u1643\u9cf0") + minecraftClient.method_47599() + a.b("\ubc5f\uc5a8\u4f6d\ud11f", 828357755));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.b("\uf51e\u8ca5\u0675\u981c\u138e\u9520", 958788990) + string + a.c(112637340, "\ub5b6\ucc59\u4694\ud8ec")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        hfm = new String[]{a.c(496399700, "\u7538\u0c80\u8653"), a.d("\u4b1d\u32a1\ub872\u264f\uadd7\u2b67", -443151681, -1676459579), a.d("\uf2f9\u8b41\u0192", -1959514627, -973480088), a.d("\u812e\uf884\u725e\uec2a\u67fc\ue15a\u5b08", -927582642, -1921140972), a.c(357961634, "\u0fce\u7676\ufca5"), a.c(-1752267343, "\u85df\ufc63\u76b0\ue88d\u6318\ue5be\u5fec\ud649\u4845\uc2ef\u4535\ubf41\u3197\ua831\u2263"), a.c(1056645037, "\u1fc1\u6679\uecaa"), a.b("\ub1c5\uc879\u42aa\udc97\u570f\ud1bf", 1380561314)};
        hfn = new String[]{a.c(-765029261, "\u942e\uedaa\u676a\uf90e\u72db\uf47b\u4e19\uc7fe\u59a2"), a.c(1345099157, "\u95db\uec57\u6695\uf8ec\u7313\uf5b4\u4fe4"), a.b("\u75dc\u0c50\u8692\u18eb\u9301\u1588\uafca\u2631\ub874\u32cf\ub50c", 1917285790), a.d("\u778e\u0e1d\u84d9\u1aa9\u9173\u17c8\uad8c\u2460\uba39\u3089\ub747", 123663664, -644250907), a.c(-311495107, "\uf67a\u8ff8\u052b\u9b47\u1088\u963d"), a.b("\ueedd\u9742\u1d92\u83ef\u0830\u8ea5\u34cc\ubd3c\u237b\ua9cf\u2e1b\ud461", 444853907), a.c(-2080681175, "\u537d\u2af7\ua02d\u3e59\ub58f\u3329\u897b")};
    }

    private static /* synthetic */ int zq(int n, int n2) {
        return n * n2 | 0x1EDF4F6A;
    }
}

