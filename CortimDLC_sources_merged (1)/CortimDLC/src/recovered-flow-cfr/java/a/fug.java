/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
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
import a.izx;
import a.kfe;
import a.kfx;
import a.vlv;
import a.vmc;
import a.vmo;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class fug {
    private static final List<Entity> fuh = new ArrayList<Entity>();
    private static final String[] fui = new String[]{a.c(1067002255, "\u29d6\u505b\uda85\u44ec\ucf27\u4981\uf3e5\u7a02\ue45e"), a.c(-1583623650, "\ud258\uabcf\u210f\ubf71\u34bb\ub209\u084b\u81a9\u1fe1\u955b\u1292\ue8d1\u6632\uff98\u75c7\uf33d\u4978\uc6be"), a.b("\u56f4\u2f7e\ua5aa\u3bc3\ub02a\u36bc\u8cf7\u0519\u9b5c\u11f7\u962f\u6c50\ue28e", 1994938026), a.b("\u5862\u21e8\uab32\u3546\ube90\u3836\u825f\u0b87\u95d7\u1f6c\u98a8", -1766893510)};
    private static int fuj;
    private static int fuk;
    private static int ful;
    private static boolean fum;
    private static /* synthetic */ int fun;
    private static /* synthetic */ String fuo;

    private fug() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        if (!fum) {
            fum = true;
            WorldRenderEvents.END_MAIN.register(worldRenderContext -> ++fuj);
        }
        if (n < 40 || fuj - fuk < 6) {
            if (n == 1) {
                fug.fup(minecraftClient, kfx2);
            }
            return false;
        }
        fuk = fuj;
        switch (ful++) {
            case 0: {
                fug.fut(minecraftClient, 0.0f, 8.0f);
                minecraftClient.field_1724.method_31548().method_61496(0);
                minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8802));
                fuh.add((Entity)fug.fuu(minecraftClient, a.d("\u30ed\u4977\uc3af\u5dd6\ud615", 960297345, 1409009964), 5.0, 1.8, false));
                fuh.add((Entity)fug.fuu(minecraftClient, a.b("\u4772\u3ee7\ub437\u2a53\ua19c", 433932092), 4.0, -0.6, false));
                fuh.add((Entity)fug.fuu(minecraftClient, a.d("\ucf15\ub683\u3c5d\ua22d\u29fd\uaf46", -777661067, -532407772), 7.0, -0.9, false));
                fuh.add((Entity)fug.fuu(minecraftClient, a.d("\uc74d\ubed3\u3407\uaa6a\u21ba", 1342501231, 279328352), 6.0, 3.6, true));
                fuh.add((Entity)fug.fuu(minecraftClient, a.c(970955697, "\u9be0\ue267\u68b9\uf6c8\u7d16\ufba6"), 10.0, -4.5, false));
                hhf.add(a.d("\u2eb7\u5722\uddf2\u4396\uc859", 636813956, 56831101));
                break;
            }
            case 1: {
                fug.fuw(minecraftClient, a.d("\u8d9c\uf43b\u7ef6\ue0d2\u6b58\uedf5\u57ab\ude52\u400a", -693882087, -758530308));
                fug.fuq(kfx2, a.d("\u3cbd\u4530\ucfee\u5187\uda4c\u5cea\ue68e\u6f69\uf135", -1227632877, 1779495927), true);
                break;
            }
            case 2: {
                fug.fuw(minecraftClient, a.c(-1322512275, "\u1012\u69b5\ue378\u7d5c\uf6c3\u7064\uca34\u4398\udd85\u572e\ud0fc\u2a95\ua447\u3df1\ub7a9"));
                kfe kfe2 = kfx2.getByName(a.c(417098145, "\u69f8\u1075\u9aab\u04c2\u8f09\u09af\ub3cb\u3a2c\ua470"));
                fug.fur(kfe2, a.d("\ue119\u9883\u1253\u8c3a", 1747105783, -2122950995), 1.0);
                fug.fur(kfe2, a.d("\uf6fe\u8f64\u05b4\u9bdd\u105d\u96bf\u2cf6\ua514\u3b54", 678944814, 930682526), 1.0);
                fug.fur(kfe2, a.c(670007112, "\u7f0a\u0694\u8c42\u1233"), 0.3);
                fug.fur(kfe2, a.d("\u63ed\u1a62\u90bc\u0edd\u8516", 1572968588, 1207302963), 3.0);
                break;
            }
            case 3: {
                fug.fuw(minecraftClient, a.d("\u5056\u29f1\ua33c\u3d18\ub687\u3020\u8a70\u03dc\u9ddd\u176b\u90be\u6ad2\ue404\u7dbc", 1152760797, -843518987));
                ((vlv)fug.fus(kfx2.getByName(a.b("\u32ad\u4b20\uc1fe\u5f97\ud45c\u52fa\ue89e\u6179\uff25", 182072052)), a.b("\uc945\ub0d6\u3a0e\ua47e", 257673484))).set(a.b("\u7600\u0f9c\u8558", 888698433));
                break;
            }
            case 4: {
                fug.fuw(minecraftClient, a.c(-541321656, "\u1633\u6f94\ue559\u7b7d\uf0e2\u7645\ucc15\u45b9\udba9\u5115\ud6d1"));
                fug.fuq(kfx2, a.d("\u760d\u0f80\u855e\u1b37\u90fc\u165a\uac3e\u25d9\ubb85", -978191945, -875720733), false);
                fug.fuq(kfx2, a.d("\ube28\uc7bf\u4d7f\ud301\u58cb\ude79\u643b\uedd9\u7391\uf92b\u7ee2\u84a1\u0a42\u93e8\u19b7\u9f4d\u2508\uaace", 1284447576, -576871626), true);
                break;
            }
            case 5: {
                fug.fuw(minecraftClient, a.b("\u7d2b\u048c\u8e41\u1065\u9bf9\u1d5c\ua714\u2ee9\ub0bd\u3a06\ubd9c\u47f6\uc927", -1535214250));
                fug.fur(kfx2.getByName(a.c(-146315481, "\u6761\u1ef6\u9436\u0a48\u8182\u0730\ubd72\u3490\uaad8\u2062\ua7ab\u5de8\ud30b\u4aa1\uc0fe\u4604\ufc41\u7387")), a.b("\uba33\uc3a4\u4964\ud71a\u5cd0\uda62\u6020\ue9c2\u778a\ufd30\u7aee\u8085", -2015249813), 1.0);
                break;
            }
            case 6: {
                fug.fuw(minecraftClient, a.b("\u6e7a\u17dd\u9d10\u0334\u88a8\u0e0d\ub445\u3db8\ua3ec\u2957\uaecd\u54a0\uda76\u43c7", -1967821308));
                fug.fur(kfx2.getByName(a.b("\ubab8\uc32f\u49ef\ud791\u5c5b\udae9\u60ab\ue949\u7701\ufdbb\u7a72\u8031\u0ed2\u9778\u1d27\u9bdd\u2198\uae5e", -1368933634)), a.d("\u3d9c\u440b\ucecb\u50b5\udb7f\u5dcd\ue78f\u6e6d\uf025\u7a9f\ufd41\u072a", 1813872263, -2068167869), 0.0);
                break;
            }
            case 7: {
                fug.fuw(minecraftClient, a.b("\u472d\u3e8a\ub447\u2a63\ua1ff\u275a\u9d12\u14ef\u8abb\u0000\u879a\u7df6", 724649809));
                fug.fur(kfx2.getByName(a.b("\u45e8\u3c7f\ub6bf\u28c1\ua30b\u25b9\u9ffb\u1619\u8851\u02eb\u8522\u7f61\uf182\u6828\ue277\u648d\udec8\u510e", -365541970)), a.b("\u5f44\u26d3\uac13\u326d\ub9a7\u3f15\u8557\u0cb5\u92fd\u1847\u9f99\u65f2", 1150246684), 0.6);
                fug.fuq(kfx2, a.d("\u9c96\ue51c\u6fc8\uf1a1\u7a48\ufcde\u4695\ucf7b\u513e\udb95\u5c4d\ua632\u28ec", 455276542, 2108320566), true);
                break;
            }
            case 8: {
                fug.fuw(minecraftClient, a.b("\ufd16\u84b1\u0e7c\u9058\u1bcb\u9d7d\u2736\uaed8\u309d\uba36\u3dee\uc791\u494f", -1417413269));
                kfe kfe3 = kfx2.getByName(a.d("\u8568\ufce5\u763b\ue852\u6399\ue53f\u5f5b\ud6bc\u48e0", -286340712, 163597481));
                ((vlv)fug.fus(kfe3, a.c(1570457914, "\u4973\u30e0\uba38\u2448"))).set(a.b("\u3a41\u43ca\uc918\u5771\udca3\u5a15\ue04d", 534592009));
                fug.fur(kfe3, a.b("\uac31\ud5ab\u5f7b\uc112", 1817554034), 0.5);
                fug.fur(kfe3, a.b("\u4260\u3bfa\ub12a\u2f43\ua4c3\u2221\u9868\u118a\u8fca", 1108951598), 0.5);
                fug.fur(kfe3, a.d("\u7cc2\u055c\u8f8a\u11fb", 478831465, -586342423), 0.1);
                fug.fur(kfe3, a.c(1162242021, "\u67b7\u1e38\u94e6\u0a87\u814c"), 1.5);
                fug.fuq(kfx2, a.b("\u5ecf\u2742\uad9c\u33f5\ub83e\u3e98\u84fc\u0d1b\u9347", -1621074282), true);
                break;
            }
            case 9: {
                fug.fuw(minecraftClient, a.d("\u077d\u7eda\uf417\u6a33\ue1a8\u6714\udd47", -1756306687, 1900798987));
                fug.fuq(kfx2, a.b("\u06e0\u7f6a\uf5b0\u6bc4\ue012\u66b4\udcdd\u5505\ucb55\u41ee\uc62a", -277477704), true);
                break;
            }
            case 10: {
                fug.fuw(minecraftClient, a.b("\u9954\ue0f3\u6a3e\uf41a\u7f88\uf930\u436c\uca97\u54df", 1960024365));
                break;
            }
            default: {
                for (String string : fui) {
                    fug.fuq(kfx2, string, false);
                }
                for (Entity entity : fuh) {
                    minecraftClient.field_1687.method_2945(entity.method_5628(), Entity.RemovalReason.field_26999);
                }
                fuh.clear();
                hhf.remove(a.d("\u3df7\u4462\uceb2\u50d6\udb19", -1579901925, -658398814));
                minecraftClient.field_1724.method_31548().method_5447(0, ItemStack.field_8037);
                izx.TARGET.enabled.set(true);
                return true;
            }
        }
        return false;
    }

    private static void fup(MinecraftClient minecraftClient, kfx kfx2) {
        for (String string : fui) {
            fug.fuq(kfx2, string, false);
            for (vmo vmo2 : kfx2.getByName(string).getSettings()) {
                if (vmo2 instanceof vmc) {
                    vmc vmc2 = (vmc)vmo2;
                    vmc2.reset();
                    continue;
                }
                if (!(vmo2 instanceof vlv)) continue;
                vlv vlv2 = (vlv)vmo2;
                vlv2.reset();
            }
        }
        fug.fuv(minecraftClient, a.c(-619295671, "\u4c3f\u3588\ubf57\u212e\uaaf1\u2c42\u961a\u1fea\u81f0\u0b02\u8cc0\u76a6\uf875\u61d1\ueb9f\u6d71\ud72d"));
        fug.fuv(minecraftClient, a.d("\ua667\udfcb\u551c\ucb65\u40f7\uc615\u7c50\uf5b0\u6bbb\ue11c\u66c9\u9cb8\u126f", -1507915741, 373665341));
        fug.fuv(minecraftClient, a.d("\u3e3b\u4798\ucd4f\u532b\ud8e0\u5e5c\ue418\u6dbb\uf3a7\u7919\ufec3\u04b6\u8a72", -1082592760, 813288521));
        fug.fuv(minecraftClient, a.b("\u2db6\u5408\udede\u40af\ucb34\u4ddb\uf7db\u7e31\ue078\u6a97\ued1a\u1735\u99ae\r\u8a00\u0cb9\ub6e0\u396f\ua391\u25d3\uac7a\ud664\u58d2\uc317\u4525\ucff0\u7644\uf81e\u62ef\ue4af\u6f0f\u91d9\u1b84\u823b\u0433\u8e8a\u3146", -785240587));
        fug.fuv(minecraftClient, a.c(1211504919, "\u1954\u60ea\uea3c\u744d\uffd6\u7939\uc327\u4ac5\ud4c4\u5e2b\ud9a6\u2391\uad5e\u34b1\ubeaa\u384d\u825c\u0dc1\u9760\u116f\u98de\ue297\u6c69\uf7bc\u71c4\ufb1e\u42ab\ucceb\u560f\ud059\u5bf8\ua567\u2f61\ub697\u30df\uba6f\u05b3"));
        izx.TARGET.enabled.set(false);
    }

    private static void fuq(kfx kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static void fur(kfe kfe2, String string, double d) {
        ((vmc)fug.fus(kfe2, string)).set(d);
    }

    private static vmo fus(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.c(404436688, "\u36f8\u4f01\uc5db\u5bb8\ud03c\u56c3\uec91\u652f") + string);
    }

    private static void fut(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static PlayerEntity fuu(MinecraftClient minecraftClient, String string, double d, double d2, boolean bl) {
        OtherClientPlayerEntity otherClientPlayerEntity = new OtherClientPlayerEntity(minecraftClient.field_1687, new GameProfile(UUID.randomUUID(), string));
        Vec3d vec3d = minecraftClient.field_1724.method_73189().method_1019(new Vec3d(0.0, 0.0, 1.0).method_1021(d)).method_1019(new Vec3d(-1.0, 0.0, 0.0).method_1021(d2));
        otherClientPlayerEntity.method_5808(vec3d.field_1352, minecraftClient.field_1724.method_23318(), vec3d.field_1350, 180.0f, 0.0f);
        otherClientPlayerEntity.method_5636(180.0f);
        otherClientPlayerEntity.method_5847(180.0f);
        otherClientPlayerEntity.field_6220 = 180.0f;
        otherClientPlayerEntity.field_6259 = 180.0f;
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6174, new ItemStack((ItemConvertible)Items.field_8058));
        otherClientPlayerEntity.method_5673(EquipmentSlot.field_6173, new ItemStack((ItemConvertible)Items.field_22022));
        otherClientPlayerEntity.method_5648(bl);
        minecraftClient.field_1687.method_53875((Entity)otherClientPlayerEntity);
        return otherClientPlayerEntity;
    }

    private static void fuv(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void fuw(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\ub2d3\ucb74\u41ae\udfd5\u5444\ud2a1\u68e3\ue104\u7f5c\uf5b9", -2106674518) + string + a.b("\u086d\u71bc\ufb0f", -1435236274) + minecraftClient.method_47599() + a.c(-1494075902, "\u3626\u4fd1\uc514\u5b66"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\u6a6b\u13d0\u9900\u0769\u8cfb\u0a55", -458814974, -1054515191) + string + a.d("\u5b19\u22f6\ua83b\u3643", -1358663236, 183184015)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int qz(int n, int n2) {
        return n - n2 + -1664652938;
    }

    private static /* synthetic */ int ra(int n, int n2) {
        return n + n2 ^ 0x7BD10F62;
    }
}

