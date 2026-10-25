/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.option.Perspective
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.mob.ZombieEntity
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
import a.rrx;
import a.vkl;
import a.vlj;
import a.vlv;
import a.vmc;
import a.vmo;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class fwv {
    private static final List<Entity> fww = new ArrayList<Entity>();
    private static final String[] fwx = new String[]{a.c(-1549244495, "\u67f0\u1e6c\u94a8"), a.c(-103404170, "\u2d32\u54af\ude61\u400c\ucbd0\u4d76\uf724"), a.c(1783628664, "\u033a\u7aac\uf07d\u6e0a")};
    private static final String[] fwy = new String[]{a.c(374044592, "\u77e6\u0e6c\u84b8\u1ac0"), a.c(546817548, "\uc649\ubfdd\u3500\uab7e\u20b5\ua61e\u1c4a\u95bc\u0bea"), a.c(1303079224, "\u6969\u10e6\u9a32\u0459\u8f9f\u0939"), a.b("\uabe3\ud27f\u58bb\uc6dd", -1983337557), a.c(208887909, "\u6020\u19bd\u9372\u0d1d\u86c8e"), a.c(-123909574, "\u4a7d\u33f8\ub92c\u2740\uac8a\u2a28"), a.b("\u49ec\u3071\ubaa4\u24d1\uaf09", 1014057382), a.b("\u7c33\u05a9\u8f70\u1100", 1440709753), a.d("\udf8f\ua60c\u2cd5\ub2ba\u396a\ubfc8", -1403450249, 1271387053)};
    private static final String[] fwz = new String[]{a.d("\u6c2e\u15a5\u9f77\u011e\u8acc\u0c7a\ub622", 1138654841, 1090392607), a.c(-83881656, "\u1109\u6895\ue251")};
    private static /* synthetic */ boolean fxa;
    private static /* synthetic */ String fxb;

    private fwv() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        kfx kfx2 = Flow.getInstance().getModuleManager();
        if (n == 1) {
            fwv.fxn(minecraftClient, a.b("\u47fb\u3e4c\ub493\u2aea\ua135\u2786\u9dde\u142e\u8a34\u00c6\u8704\u7d62\uf3b1\u6a15\ue05b\u66b5\udce9", -1195292787));
            fwv.fxn(minecraftClient, a.b("\u670e\u1ea2\u9475\u0a0c\u819e\u077c\ubd39\u34d9\uaad2\u2075\ua7a0\u5dd1\ud306", -1288411273));
            fwv.fxn(minecraftClient, a.d("\ufef6\u8755\u0d82\u93e6\u182d\u9e91\u24d5\uad76\u336a\ub9d4\u3e0e\uc47b\u4abf", -801001966, 999051422));
            fwv.fxn(minecraftClient, a.c(1864066707, "\u66ff\u1f58\u959a\u0bfd\u8024\u0696\ubcc9\u3530\uab24\u21cb\ua646\u5c69\ud2e0\u4b0f\uc111\u47f3\ufdf1\u7224\ue890\u6eca\ue73b\u9d7b\u13db\u880d\u0e60\u84ff\u3d05\ub353\u29bf\uafef\u2457"));
            fwv.fxn(minecraftClient, a.d("\ub19d\uc83a\u42f8\udc9f\u5746\ud1f4\u6bab\ue252\u7c46\uf6a9\u7135\u8b55\u05dc\u9c33\u163e\u9082\u2ade\ua542\u3ff5\ub9a3\u305f\u4a08\uc4aa\u5f68\ud910\u53d3\uea2e\u6436\ufec6\u788c\uf33e\u0de4", 235330743, -368611975));
            izx.TARGET.enabled.set(false);
        }
        if (n == 6) {
            fwv.fxh(minecraftClient, new Vec3d(Math.floor(minecraftClient.field_1724.method_23317()) + 0.5, Math.floor(minecraftClient.field_1724.method_23318()) + 0.7, Math.floor(minecraftClient.field_1724.method_23321()) + 3.5));
            fwv.fxd(kfx2, a.c(117294034, "\uc39c\uba03\u30d3\uaeae\u2571\ua3e4\u198d\u907d\u0e3a\u848e\u035a\uf920"), true);
        }
        for (n10 = 0; n10 < fwx.length; ++n10) {
            n9 = 10 + n10 * 10;
            if (n == n9) {
                fwv.fxe(kfx2, a.c(-1216626906, "\ubf68\uc6f7\u4c27\ud25a\u5985\udf10\u6579\uec89\u72ce\uf87a\u7fae\u85d4"), a.d("\u1300\u6a93\ue04b\u7e3b", 314910037, 1299002908), fwx[n10]);
                continue;
            }
            if (n != n9 + 8) continue;
            fwv.fxo(minecraftClient, a.b("\u3d45\u44ea\uce6c\u505f\udb92\u5d22\ue769\u6e9d\uf0c5\u7a7f\ufde4", 1299070248) + fwx[n10].toLowerCase());
        }
        n10 = 100;
        if (n == n10) {
            fwv.fxd(kfx2, a.c(231819471, "\u4881\u311e\ubbce\u25b3\uae6c\u28f9\u9290\u1b60\u8527\u0f93\u8847\u723d"), false);
            fwv.fxn(minecraftClient, a.c(-1173305380, "\uc7b2\ube15\u34d7\uaab0\u2169\ua7db\u1d84\u947d\u0a69\u8086\u070b\ufd24\u73ad\uea42\u605c\ue6be\u5cbc\ud369\u49dd\ucf87\u4676\u3c36\ub296\u2940\uaf2d\u25b2\u9c5a\u1203\u88ef"));
            fwv.fxn(minecraftClient, a.b("\u7fc7\u0660\u8ca2\u12c5\u991c\u1fae\ua5f1\u2c08\ub21c\u38f3\ubf6f\u450f\ucb86\u5269\ud864\u5ed8\ue484\u6b18\uf1af\u77f9\ufe05\u8452\u0af0\u9132\u174a\u9d89\u2474\uaa7e\u3081\ub6cb", 1906737066));
            minecraftClient.field_1690.method_31043(Perspective.field_26665);
            fwv.fxg(minecraftClient, 0.0f, 35.0f);
            fwv.fxd(kfx2, a.c(1255363447, "\u5336\u2ab8\ua073\u3e1f\ub5fb\u3360\u8928\u00c8\u9e98\u1420\u93e5"), true);
        }
        for (n9 = 0; n9 < fwy.length; ++n9) {
            int n11 = n10 + 4 + n9 * 16;
            if (n == n11) {
                fwv.fxe(kfx2, a.b("\ue9aa\u9024\u1aef\u8483\u0f67\u89fc\u33b4\uba54\u2404\uaebc\u2979", 258206187), a.b("\u9546\ueccb\u6615\uf86c\u73b3", -661940969), fwy[n9]);
                if (!minecraftClient.field_1724.method_24828()) continue;
                minecraftClient.field_1724.method_6043();
                continue;
            }
            if (n != n11 + 7) continue;
            fwv.fxo(minecraftClient, a.b("\u8b31\uf29e\u7818\ue627\u6dfa\ueb50\u5112\ud8ec\u46ba\ucc43", -1378251939) + fwy[n9].toLowerCase());
        }
        n9 = n10 + 4 + fwy.length * 16 + 4;
        if (n == n9) {
            fwv.fxd(kfx2, a.d("\u69af\u1021\u9aea\u0486\u8f62\u09f9\ub3b1\u3a51\ua401\u2eb9\ua97c", -25457215, 1660544047), false);
            minecraftClient.field_1690.method_31043(Perspective.field_26664);
            fwv.fxg(minecraftClient, 0.0f, -10.0f);
            kfe kfe2 = kfx2.getByName(a.c(1595478387, "\u1127\u68aa\ue263\u7c0b\uf7f5\u7152\ucb02"));
            ((vkl)fwv.fxf(kfe2, a.d("\ud53d\uacae\u2670\ub810", -842385269, -1435439617))).set(true);
            kfe2.setEnabled(true);
            fwv.fxn(minecraftClient, a.d("\ubdfe\uc449\u4e82\ud0f3\u5b26\udd96\u678b\uee37\u706c\ufada\u7d02\u8775\u09b3\u9011\u1a45\u9ca6\u26a7\ua936\u3390\ub5c3\u3c3b\u4661\uc8de\u534a\ud56b\u5fe4\ue609\u6806\uf2af\u74b5\uff13\u0199\u8be3\u1233\u944e\u1ef7\ua153\u2b29\uada9\u3456\ube76\uc0bd\u4aeb\ucd53\u578f\ud9e4\u6079\ueac3\u6cdf\uf740\u797a\u83bf\u0a0c\u8c41\u16ab\u98e7\u2350\ua58a\u2fe3\ub67c\u388a\u42cd\uc532\u4f6b\ud1a3\u5814\ue24e\u64b0\ueeed\u7102\ufb90\u7df3\u8421\u0ece\u9085\u1b3b\u9d68\u27de\uae06\u3071\ubaaf\u3ced\u4759\uc99a\u53a3\uda3c\u5c94\ue6de\u6930\uf369\u75e8\ufc09\u0677\u889f\u1306\u954c\u1f89\ua1e5\u2826\ub290\u34ce\ubf7a\uc127\u4bd9\ud20a\u5461\udea9\u6102\ueb1b\u6de1\uf7fe\u7e4f\u8080", -126635076, 863505984));
        }
        if (n == n9 + 10) {
            ZombieEntity zombieEntity = fwv.fxc(minecraftClient);
            System.out.println(a.b("\u4319\u3ab6\ub03d\u2e1f\ua5d4\u237f\u9935\u1092\u8ed7\u043c\u83fa\u7989\uf751\u6eeb\ue4b4\u6200", 463946607) + (zombieEntity != null));
            if (zombieEntity != null) {
                rrx.onAttack((Entity)zombieEntity);
            }
            fwv.fxn(minecraftClient, a.c(871493000, "\uedd5\u9461\u1ebe\u80c3\u0b12\u8da1\u37b7\ube26\u205c\uaad3\u2d2f\ud753\u598d\uc029\u4a22\ucc83\u76c8\uf91e\u63a6\ue5f1\u6c17\u1655\u98e1\u0322\u8513\u0f82\ub624\u3877\ua28f\u24d5\uaf6a\u51f2\udbfd\u4209\uc45e\u4eeb\uf121\u7b19\ufdc6\u646a\uee6a\u9087\u1ac9\u9d7e\u07e0\u89c2\u301a\ubaaf\u3cf3\ua735\u2950\ud386\u5a18\udc34\u46d6\uc886\u7339"));
        }
        if (n == n9 + 24) {
            fwv.fxo(minecraftClient, a.d("\u35de\u4c71\uc6f7\u58d8\ud313\u55b8\ueff2\u6642\uf844\u72ee\uf526\u0f46\u8199", 618332524, -1001179943));
        }
        if (n == n9 + 40) {
            fwv.fxn(minecraftClient, a.b("\uf1ff\u884c\u029a\u9ceb\u1770\u91a1\u2bd7\ua218\u3c68\ub6d4\u310e\ucb6a\u45e5\udc04\u5653\ud0a5\u6ae1\ue536\u7f94\uf9d6\u7026\u0a65\u8498\u1f09\u9963\u13b0\uaa0c\u2456\ubead\u38c4", -1919487606));
        }
        if (n == n9 + 56) {
            fwv.fxo(minecraftClient, a.d("\uf636\u8f99\u051f\u9b30\u10fb\u9650\u2c1a\ua5aa\u3bb3\ub100\u36d6\ucca7", -123526971, -1513498983));
        }
        if (n == (n8 = n9 + 80)) {
            fwv.fxd(kfx2, a.d("\u3259\u4bd4\uc11d\u5f75\ud48b\u522c\ue87c", -1179222205, 67849550), false);
            fwv.fxg(minecraftClient, 0.0f, 6.0f);
            fww.add((Entity)fwv.fxi(minecraftClient, a.b("\uf7de\u8e59\u049d\u9ae8\u1133", 296351647), 4.0, 0.0, false));
            fww.add((Entity)fwv.fxi(minecraftClient, a.d("\u605d\u19c8\u9318\u0d7c\u86b3", -1289965007, 1081528866), 6.0, 3.0, false));
            fww.add((Entity)fwv.fxi(minecraftClient, a.d("\ub144\uc8d2\u4212", 359761655, -966379530), 14.0, -5.0, false));
            hhf.add(a.c(2082645425, "\ua5ff\udc6a\u56ba\uc8de\u4311"));
            fwv.fxd(kfx2, a.b("\ufbec\u8261\u08bf\u96d6\u1d1d\u9bbb\u21df\ua838\u3664", -1558971467), true);
        }
        for (n7 = 0; n7 < fwz.length; ++n7) {
            n6 = n8 + 2 + n7 * 8;
            if (n == n6) {
                fwv.fxe(kfx2, a.d("\u4dae\u3423\ubefd\u2094\uab5f\u2df9\u979d\u1e7a\u8026", -1490264935, 1187713390), a.b("\ueb32\u92a1\u1879\u8609", 1575021435), fwz[n7]);
                continue;
            }
            if (n != n6 + 6) continue;
            fwv.fxo(minecraftClient, a.d("\u5080\u292f\ua3a9\u3d90\ub651\u30e3\u8aed", -1681612380, -572067515) + fwz[n7].toLowerCase());
        }
        n7 = n8 + 2 + fwz.length * 8 + 2;
        if (n == n7) {
            fwv.fxd(kfx2, a.b("\u907f\ue9f2\u632c\ufd45\u768e\uf028\u4a4c\uc3ab\u5df7", 661032998), false);
            fwv.fxd(kfx2, a.d("\udeb0\ua727\u2de7\ub399\u3853\ubee1\u04a3\u8d41\u1309\u99b3\u1e7a\ue439\u6ada\uf370\u792f\uffd5\u4590\uca56", -1688121343, 1353289463), true);
        }
        if (n == n7 + 6) {
            fwv.fxo(minecraftClient, a.c(2075809627, "\u5732\u2e9d\ua41b\u3a21\ub1e2\u3748\u8d17\u04ed\u9ab8\u1040\u97d9\u6da7\ue377\u7ada\uf08e"));
        }
        if (n == n7 + 7) {
            fwv.fxd(kfx2, a.d("\u2d36\u54a1\ude61\u401f\ucbd5\u4d67\uf725\u7ec7\ue08f\u6a35\uedfc\u17bf\u995c\u00f6\u8aa9\u0c53\ub616\u39d0", -1634971933, 1237934995), false);
            hhf.remove(a.b("\u7d3d\u04a8\u8e78\u101c\u9bd3", 1022852467));
            fww.get(0).method_5648(true);
            fwv.fxd(kfx2, a.b("\u90de\ue954\u6380\ufde9\u7600\uf096\u4add\uc333\u5d76\ud7dd\u5005\uaa7a\u24a4", -511078272), true);
        }
        if (n == n7 + 13) {
            fwv.fxo(minecraftClient, a.b("\u0de3\u744c\ufeca\u60e5\ueb29\u6d9f\ud7d4\u5e7f\uc064\u4ad2\ucd19\u3777\ub9ba\u2011\uaa49\u2cb6\u96f0", -164033132));
        }
        if (n == (n6 = n7 + 16)) {
            fwv.fxd(kfx2, a.b("\uef5a\u96d0\u1c04\u826d\u0984\u8f12\u3559\ubcb7\u22f2\ua859\u2f81\ud5fe\u5b20", 1603464964), false);
            for (Object object : fww) {
                fwv.fxj(minecraftClient, object);
            }
            fww.clear();
            fwv.fxn(minecraftClient, a.d("\ua938\ud086\u5a50\uc421\u4fba\uc955\u7355\ufaba\u64f6\uee19\u6994\u93bb\u1d26\u8483\u0e8e\u8832\u326e\ubde1\u271f\ua15d\u28f4\u52ef\udc48\u47d4\uc1af\u4b79\uf2c1\u7c96\ue670\u6032\ueb86\u1545\u9f44\u06fc\u80a8\u0a02\ub5d4\u3fae", 295606913, -1528417287));
            fwv.fxn(minecraftClient, a.d("\u166c\u6fcb\ue509\u7b6e\uf0b7\u7605\ucc5a\u45a3\udbb7\u5158\ud6d5\u2cfa\ua273\u3b9c\ub186\u3760\u8d62\u02b7\u9803\u1e59\u97a8\uede8\u6348\uf89e\u7ef3\uf46c\u4d81\uc3dd\u5922\udf7f\u54ce\uaa1e\u205b\ub991\u3ff2\ub55e\u0a9e", 1261701325, -1926357257));
            fwv.fxn(minecraftClient, a.d("\uf034\u8993\u0351\u9d36\u16ef\u905d\u2a02\ua3fb\u3def\ub700\u309c\ucafc\u4475\udd9a\u5797\ud12f\u6b77\ue4eb\u7e5c\uf80a\u71f6\u0ba1\u8503\u1ec1\u98b9\u127a\uab87\u2588\ubf72\u392b\ub294\u4c47\uc609\u5ff2\ud99a\u531b\uecd1\u66b7", 482511765, 1992326132));
            fwv.fxn(minecraftClient, a.c(38934580, "\u1861\u61c6\ueb04\u7563\ufeba\u7808\uc257\u4bae\ud5ba\u5f55\ud8d8\u22f7\uac6f\u35cf\ubfc2\u397a\u8322\u0cbe\u9609\u105f\u99a3\ue3f4\u6d56\uf694\u70ec\ufa2f\u43d2\ucddd\u5727\ud17e\u5ac1\ua412\u2e5c\ub7a7\u31cf\ubb4e\u0484\u8ee2"));
            fwv.fxn(minecraftClient, a.b("\u3c72\u45d5\ucf17\u5170\udaa9\u5c1b\ue644\u6fbd\uf1a9\u7b46\ufccb\u06e4\u886d\u1182\u9b97\u1d7e\ua77c\u28a9\ub21d\u3447\ubdb6\uc7f6\u4956\ud280\u54ed\ude72\u679f\ue9c3\u733c\uf561\u7ed0\u8000\u0a45\u938f\u15ec\u9f40\u2080", -1538180060));
            fwv.fxn(minecraftClient, a.c(1066760325, "\u78d3\u0174\u8bb6\u15d1\u9e08\u18ba\ua2e5\u2b1c\ub508\u3fe7\ub867\u4209\ucccc\u5523\udf3f\u59df\ue3ce\u6c59\uf6f2\u70ee\uf91d\u834b\u0df3\u9624\u104a\u9a88\u233c\uad7f\u37c6\ub1ca\u3a71\uc4a3\u4ee4\ud72e\u514d\udbe1\u6421"));
            fwv.fxn(minecraftClient, a.b("\u501c\u29bb\ua379\u3d1e\ub6c7\u3075\u8a2a\u03d3\u9dc7\u1728\u90b7\u6ad4\ue45d\u7db2\uf7bf\u7109\ucb5f\u44c3\ude74\u5822\ud1de\uab89\u252b\ubee9\u3891\ub252\u0baf\u85a7\u1f5b\u9907\u12a2\uec74", 547901519));
            fwv.fxn(minecraftClient, a.b("\ue3d4\u9a73\u10b1\u8ed6\u050f\u83bd\u39e2\ub01b\u2e0f\ua4e0\u2360\ud90d\u57cb\uce24\u4429\uc286\u7886\uf756\u6df5\uebe9\u621a\u184c\u96f4\u0d23\u8b4d\u018f\ub83b\u3678\uacc1\u2acb\ua177\u5fab\ud5ee\u4c13\uca4b\u40e0\uff1c\u7556\uf384\u6a32\ue07d\u9e97\u14de", 673506188));
            fwv.fxg(minecraftClient, 0.0f, 5.0f);
        }
        if (n == n6 + 4) {
            fwv.fxd(kfx2, a.d("\udeee\ua771\u2da1\ub3dc\u3803\ube9c\u04d9\u8d2b", -585514113, -1962926629), true);
        }
        if (n == n6 + 14) {
            fwv.fxo(minecraftClient, a.b("\u4161\u38ce\ub248\u2c76\ua7af\u211d\u9b42\u12bb\u8ca2\u065b\u819e\u7bec", -206487285));
        }
        if (n == n6 + 15) {
            fwv.fxe(kfx2, a.b("\ubb48\uc2d7\u4807\ud67a\u5da5\udb3a\u617f\ue88d", 1760213762), a.b("\ub49e\ucd0d\u47d5\ud9a5", -588466985), a.d("\u8b65\uf2f8\u7836\ue65b\u6d87\ueb21\u5173", 1245773470, 246707647));
        }
        if (n == n6 + 22) {
            fwv.fxo(minecraftClient, a.b("\uc601\ubfae\u3528\uab16\u20cf\ua67d\u1c22\u95db\u0bc2\u813b\u06fe\ufc8c\u7206\uebf9\u61a6\ue74a\u5d19\ud2c3\u4867\uce37", -1483618701));
        }
        if (n == (n5 = n6 + 26)) {
            fwv.fxd(kfx2, a.d("\ub9f1\uc06e\u4abe\ud4c3\u5f1c\ud983\u63c6\uea34", -224609552, -1241447605), false);
            fwv.fxk(minecraftClient, a.b("\ud6a6\uaf20\u25f8\ubb83\u3055\ub6f3", -287975694));
        }
        if (n == n5 + 12) {
            Object object;
            object = kfx2.getByName(a.d("\ub12f\uc8b0\u4260\udc1d\u57c2\ud15d\u6b18\ue2ea", -2047458823, -1189482340));
            Method method = hlc.class.getDeclaredMethod(a.b("\ub700\uceae\u4468\uda12\u51fb\ud773\u6d2a\ue4d3\u7a82\uf024", 1523955557), vlj.class);
            method.setAccessible(true);
            method.invoke((Object)minecraftClient.field_1755, (vlj)fwv.fxf((kfe)object, a.c(468176351, "\ucd9b\ub404\u3ed4\ua0a9\u2b76\uaddf")));
        }
        if (n == n5 + 22) {
            fwv.fxo(minecraftClient, a.b("\u4f7c\u36d3\ubc55\u2279\ua9b7\u2f0c\u9557\u1ca8\u82e0", -1158131949));
        }
        if (n == n5 + 23) {
            fwv.fxm(minecraftClient.field_1755, a.b("\ufcba\u8506\u0fdd\u91a0\u1a75\u9cc5\u269c", 1145044185));
        }
        if (n == n5 + 30) {
            fwv.fxo(minecraftClient, a.d("\u83c5\ufa6a\u70ec\ueec0\u650e\ue3b5\u59ee\ud011\u4e59\uc4b7\u433a\ub95d\u378e\uae2c\u246e\ua294", 1877013680, 1059550979));
        }
        if (n == n5 + 31) {
            fwv.fxl(minecraftClient.field_1755, 256);
            fwv.fxl(minecraftClient.field_1755, 256);
        }
        if (n == n5 + 38) {
            fwv.fxo(minecraftClient, a.c(-1583265651, "\u48fb\u3154\ubbd2\u25fe\uae30\u288b\u92d0\u1b2f\u8567\u0f89\u8814\u726a\ufcbe\u6513\uef56\u69a6"));
            minecraftClient.method_1507(null);
        }
        if (n == (n4 = n5 + 42)) {
            fwv.fxn(minecraftClient, a.c(-420455482, "\u5b84\u223a\ua8ec\u369d\ubd06\u3be9\u81e9\u0806\u964a\u1ca5\u9b28\u6107\uef9a\u763f\ufc32\u7a8e\uc0d2\u4f5d\ud5a3\u53e1\uda48\ua053\u2ef4\ub568\u3313\ub9c5}\u8e2a\u14cc\u928e\u193a\ue7f9\u6df8\uf452\u7209\uf8a3"));
            fwv.fxg(minecraftClient, 0.0f, 10.0f);
            minecraftClient.field_1724.method_31548().method_61496(0);
            minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8802));
            minecraftClient.field_1724.method_5673(EquipmentSlot.field_6171, new ItemStack((ItemConvertible)Items.field_8288));
            fwv.fxo(minecraftClient, a.b("\u6895\u113a\u9bbc\u0588\u8e56\u08e8\ub2b1\u3b57\ua556\u2fba\ua875\u5209\udcd6\u4560", -69637891));
        }
        if (n == n4 + 2) {
            fwv.fxd(kfx2, a.b("\u28b5\u513f\udbe5\u4591\uce47\u48e1\uf288\u7b50\ue500\u6fbb\ue87f", -1318377235), true);
        }
        if (n == n4 + 10) {
            fwv.fxo(minecraftClient, a.c(998713923, "\u2a28\u5387\ud901\u4735\ucceb\u4a55\uf00c\u79ea\ue7eb\u6d16\uead1\u10a7\u9e63"));
        }
        if (n == (n3 = n4 + 14)) {
            fwv.fxd(kfx2, a.b("\ua19f\ud815\u52cf\uccbb\u476d\uc1cb\u7ba2\uf27a\u6c2a\ue691\u6155", -2140036665), false);
            kfe kfe3 = kfx2.getByName(a.d("\u7646\u0fc8\u8517\u1b74\u9099\u160a\uac52\u25a2\ubbf4", -651009054, -1202121221));
            ((vmc)fwv.fxf(kfe3, a.c(1708025020, "\u64e5"))).set(-0.15);
            ((vmc)fwv.fxf(kfe3, a.b("\uca28", -1068512653))).set(0.2);
            ((vmc)fwv.fxf(kfe3, a.d("\u1877\u61e7\ueb33\u755e\ufec7\u780f", -1441236106, -1772919981))).set(-25.0);
            ((vmc)fwv.fxf(kfe3, a.b("\u9f9a\ue611\u6cd1\uf2bf", -753492019))).set(0.8);
            kfe3.setEnabled(true);
        }
        if (n == n3 + 6) {
            fwv.fxo(minecraftClient, a.d("\u0754\u7efb\uf47d\u6a57\ue19f\u6722\udd63\u5488\ucad5\u406f\uc7bd\u3dc5", -1978312184, -2115150538));
        }
        if (n == n3 + 7) {
            fwv.fxd(kfx2, a.c(-34100288, "\uab9f\ud211\u58ce\uc6ad\u4d40\ucbd3\u718b\uf87b\u662d"), false);
        }
        if (n == (n2 = n3 + 16)) {
            minecraftClient.field_1724.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_49814));
            minecraftClient.field_1724.method_75203();
        }
        if (n == n2 + 4) {
            fwv.fxo(minecraftClient, a.b("\uc603\ubfac\u352a\uab1b\u20c0\ua673\u1c26\u959f\u0b9f\u8139\u06ec\ufc96\u7248\uebea\u61ac\ue75f", 638633589));
        }
        if (n == n2 + 5) {
            fwv.fxn(minecraftClient, a.c(1450754855, "\uc351\ubae6\u3039\uae40\u259f\ua32c\u1974\u9084\u0e9e\u847c\u03a9\uf9df\u770c\ueea2\u64ee\ue208\u584a"));
            fwv.fxn(minecraftClient, a.b("\u13d1\u6a63\ue0b0\u7ec2\uf513\u73b5\uc9b2\u4004\ude55\u54fb\ud33b\u290f\ua7b8\u3e3a\ub43a\u3286\u88cd\u071b\u9da3\u1bf4\u9212\ue850\u66e4\ufd27\u7b16\uf18f\u482b\uc66c\u5c81\udaca\u517e\uafba\u25fa\ubc06\u3a53\ub0a7\u0f63\u8511\u03d2\u9a72\u102c\u6ecd\ue4ca\u637d\uf9ad\u77cc", 1956058010));
            fwv.fxn(minecraftClient, a.c(-421777965, "\u2dab\u541e\ude9d\u408c\ucb68\u4d8a\uf787\u7e28\ue029\u6adf\ued15\u173a"));
        }
        if (n == n2 + 20) {
            fwv.fxo(minecraftClient, a.d("\u6a60\u13cf\u9949\u0778\u8ca3\u0a10\ub045\u39fc\ua7fd\u2d52\uaa8d\u50ee\ude22", 355623171, -196932856));
        }
        if (n >= n2 + 40) {
            fwv.fxn(minecraftClient, a.c(1145741441, "\ua0f7\ud940\u539f\ucde6\u4639\uc08a\u7ad2\uf322\u6d38\ue7ca\u6008\u9a6e\u14bd\u8d19\u0757\u81b9\u3be5"));
            minecraftClient.field_1724.method_31548().method_5447(0, ItemStack.field_8037);
            minecraftClient.field_1724.method_5673(EquipmentSlot.field_6171, ItemStack.field_8037);
            izx.TARGET.enabled.set(true);
            hyz.save();
            return true;
        }
        return false;
    }

    private static ZombieEntity fxc(MinecraftClient minecraftClient) {
        ZombieEntity zombieEntity = null;
        for (Entity entity : minecraftClient.field_1687.method_18112()) {
            if (!(entity instanceof ZombieEntity)) continue;
            ZombieEntity zombieEntity2 = (ZombieEntity)entity;
            if (zombieEntity != null && !(zombieEntity2.method_5858((Entity)minecraftClient.field_1724) < zombieEntity.method_5858((Entity)minecraftClient.field_1724))) continue;
            zombieEntity = zombieEntity2;
        }
        return zombieEntity;
    }

    private static void fxd(kfx kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static void fxe(kfx kfx2, String string, String string2, String string3) {
        ((vlv)fwv.fxf(kfx2.getByName(string), string2)).set(string3);
    }

    private static vmo fxf(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.c(-720921272, "\u9d60\ue499\u6e43\uf020\u7ba4\ufd5b\u4709\uceb7") + string);
    }

    private static void fxg(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
    }

    private static void fxh(MinecraftClient minecraftClient, Vec3d vec3d) {
        Vec3d vec3d2 = vec3d.method_1020(minecraftClient.field_1724.method_33571());
        fwv.fxg(minecraftClient, (float)Math.toDegrees(Math.atan2(-vec3d2.field_1352, vec3d2.field_1350)), (float)(-Math.toDegrees(Math.atan2(vec3d2.field_1351, Math.hypot(vec3d2.field_1352, vec3d2.field_1350)))));
    }

    private static PlayerEntity fxi(MinecraftClient minecraftClient, String string, double d, double d2, boolean bl) {
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

    private static void fxj(MinecraftClient minecraftClient, Entity entity) {
        if (entity != null) {
            minecraftClient.field_1687.method_2945(entity.method_5628(), Entity.RemovalReason.field_26999);
        }
    }

    private static void fxk(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.d("\u8c97\uf533\u7fe3\ue1bb\u6a42\uecef", -1214216446, 1279986663));
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{a.c(-1177159865, "\uf737\u8e98\u044c\u9a37\u11eb\u9742\u2d3e"), a.d("\u9297\ueb38\u61ec\uff97\u744b\uf2e2\u489f", -2091486387, 1639113130)}) {
            Field field2 = hlc.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void fxl(Screen screen, int n) {
        if (screen != null) {
            screen.method_25404(new KeyInput(n, 0, 0));
        }
    }

    private static void fxm(Screen screen, String string) {
        if (screen != null) {
            for (char c : string.toCharArray()) {
                screen.method_25400(new CharInput((int)c, 0));
            }
        }
    }

    private static void fxn(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void fxo(MinecraftClient minecraftClient, String string) {
        System.out.println(a.c(-1758931688, "\ud561\uacc6\u261c\ub867\u33f6\ub513\u0f51\u86b6\u18ee\u920b") + string + a.d("\uc464\ubdb5\u3706", 1184295006, -1008587751) + minecraftClient.method_47599() + a.c(-1535618344, "\u52fc\u2b0b\ua1ce\u3fbc"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.b("\u704d\u09f6\u8326\u1d4f\u96dd\u1073", -184979411) + string + a.b("\u1713\u6efc\ue431\u7a49", 738334521)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int ry(int n, int n2) {
        return n ^ n2 | 0xCC09A06D;
    }

    private static /* synthetic */ int rz(int n, int n2) {
        return fwv.ry(n, n2) ^ 0x1187FEC7;
    }
}

