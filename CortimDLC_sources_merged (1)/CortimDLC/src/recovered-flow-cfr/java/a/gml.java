/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.hud.ChatHudLine
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$TooltipContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.tooltip.TooltipType
 */
package a;

import a.kfe;
import a.vlq;
import a.vmo;
import a.vzz;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;

final class gml {
    private static final Set<Integer> gmm = ConcurrentHashMap.newKeySet();
    private static int gmn;
    private static int gmo;
    private static /* synthetic */ int gmp;
    private static /* synthetic */ long gmq;

    private gml() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        switch (n) {
            case 1: {
                vzz.simulated = gmm::contains;
                gml.gmv(minecraftClient, a.b("\u5d9c\u242b\uaef4\u308d\ubb52\u3de1\u87b9\u0e49\u9053\u1ab1\u9d64\u6712\ue9c1\u706f\ufa23\u7cc5\uc687", 1353014762));
                gml.gmv(minecraftClient, a.b("\u20df\u596d\ud3be\u4dcc\uc61d\u40bb\ufabc\u730a\ued5b\u67f5\ue035\u1a01\u94b6\u0d34\u8734\u0196\ubbcb\u340f\uaebd\u28eb\ua10f\udb4b\u55e5\uce32\u484c\uc2d3\u7b76\uf521\u6fd6\ue997\u6230\u9cf5\u16ee\u8f19\u094d\u83ec", 185213086));
                gml.gmv(minecraftClient, a.c(362037881, "\u4212\u3bac\ub176\u2f03\ua4c7\u2224\u9817\u11d5"));
                break;
            }
            case 10: {
                gml.gmv(minecraftClient, a.c(81985252, "\ufeb1\u871d\u0ddf\u93a6\u183c\u9edf\u249b\uad7f\u333c\ub980\u3e51\uc426\u4ab4\ud340\u5918\udff3\u65a1\uea6d\u70d3\uf6db\u7f4c\u052e\u8bce\u1057\u962f\u1ce5\ua540\u2b12\ub1f6\u37fb\ubc56\u4297\uc88f\u5160\ud72e\u5d83\ue21c\u6820\ueef7\u7741\ufd15\u83e2\u09a0\u8e02\u14d2\u9ab1\u232c\ua9c3\u2f81\ub458\u3a27\uc0f4\u4942\ucf19\u55d1\udbac\u6017\ue6de\u6cb0\uf577"));
                gml.gmv(minecraftClient, a.b("\u3592\u4c3e\uc6fc\u5885\ud31f\u55fc\uefb8\u665c\uf81f\u72a3\uf572\u0f05\u8197\u1863\u923b\u14d0\uae82\u214e\ubbf0\u3df8\ub46f\uce0d\u40ed\udb75\u5d0d\ud7c4\u6e64\ue03e\u7ad3\ufc99\u7737\u89ed\u03f5\u9a19\u1c59\u96bf\u2976\ua31a\u25d5\ubc2c\u363e\u48cb\uc29f\u4525\udff4\u5194\ue854\u62e2\ue4bf\u7f20\uf10d\u0bd1\u826e\u0433\u9ec2\u1092\uab27\u2dcd\ua782\u3e58\ub0e2\ucaa5\u4d51\uc704\u59d7\ud06b\u6a2d\ueccd", -469879361));
                gml.gmv(minecraftClient, a.c(1464034093, "\u6378\u1ad4\u9016\u0e6f\u85f5\u0316\ub952\u30b6\uaef5\u2449\ua398\u59ef\ud77d\u4e89\uc4d1\u423a\uf868\u77a4\ued1a\u6b12\ue285\u98e7\u1607\u8d9f\u0be7\u812e\u388e\ub6d4\u2c39\uaa73\u21dd\udf07\u551f\uccf4\u4ab3\uc055\u7f9c\uf5f0\u733f\ueac6\u60d4\u1e21\u9475\u13cf\u891e\u077e\ubebe\u3408\ub255\u29ca\ua7ea\u5d20\ud48a\u52da\uc818\u4674\ufdc6\u7b17\uf17f\u68a9"));
                gml.gmv(minecraftClient, a.d("\u558d\u2c21\ua6e3\u389a\ub300\u35e3\u8fa7\u0643\u9800\u12bc\u956d\u6f1a\ue188\u787c\uf224\u74cf\uce9d\u4151\udbef\u5de7\ud470\uae12\u20f2\ubb6a\u3d12\ub7db\u0e7b\u8021\u1acc\u9c86\u1728\ue9f2\u63ea\ufa00\u7c46\uf6a0\u4969\uc305\u45ca\udc33\u5621\u28d4\ua280\u253a\ubfeb\u318b\u884b\u02fd\u84a0\u1f3f\u9114\u6bd2\ue27e\u6425\ufede\u7086\ucb07\u4de0\uc797\u5e41\ud0fd\uaaaa\u2d48\ua70a\u39c2\ub061\u0a7c\u8cd5\u0695\u993f\u13e6\u959f\u6c49\ue6c2\u78ad\uf350\u7506\ucfad\u466f\ud815\u52c0\ud496\uaf6b\u21dc\ubb8b\u3248\ub4f6\u0ef9\u811e\u1b00\u9db7\u1461\uee1d\u60ca\ufb68\u7d2a\uf7e2\u4981\uc01c\u5af9\udca5\u5745\u290a\ua3b6\u3a7e\ubc14\u36da\u897a\u0317\u85d1\u1f8f\u9637\u68f9\ue2a0\u6542\uff45\u71fc\uc862\u421d\uc4d6\u5f72\ud139\uab84\u2dde\ua425\u3ed4\ub0a7", 1179504592, 554474059));
                gml.gmv(minecraftClient, a.b("\u80eb\uf947\u7385\uedfc\u6666\ue085\u5ac1\ud325\u4d66\uc7da\u400b\uba7c\u34ee\uad1a\u2742\ua1a9\u1bfb\u9437\u0e89\u8881\u0116\u7b74\uf594\u6e0c\ue874\u62bd\udb1d\u5547\ucfaa\u49e0\uc24e\u3c94\ub68c\u2f65\ua920\u23c6\u9c0f\u1663\u90ac\u0955\u8347\ufdb2\u77e6\uf05c\u6a8d\ue4ed\u5d2d\ud79b\u51c6\uca59\u4474\ubea8\u3717\ub14a\u2bbb\ua5eb\u1e5e\u98b4\u12f4\u8b2c\u0599\u7fc8\uf835\u7263\ueca5\u6500\udf7b\u59bc\ud3ef\u4c59\uc681\u40f6\ub938\u339a\uadce\u262d\ua034\u1adb\u930d\u0d70\u87b3\u01e4\u7a55\uf4dc\u6ea2\ue77e\u61c0\udbf8", -1011384102));
                gml.gmv(minecraftClient, a.c(157978558, "\u8f95\uf639\u7cfb\ue282\u6918\ueffb\u55bf\udc5b\u4218\uc8a4\u4f75\ub502\u3b90\ua264\u283c\uaed7\u1485\u9b49\u01f7\u87ff\u0e68\u740a\ufaea\u6172\ue70a\u6dc3\ud463\u5a39\uc0d4\u469e\ucd30\u33ea\ub9f2\u201a\ua65e\u2cb8\u9371\u191d\u9fd2\u062b\u8c39\uf2cc\u7898\uff22\u65f3\ueb93\u5253\ud8e5\u5eb8\uc527\u4b0a\ub1d6\u3869\ube34\u24c5\uaa95\u1120\u97ca\u1d8a\u8452\u0ae7\u70b6\uf74b\u7d1d\ue3db\u6a7e"));
                break;
            }
            case 20: {
                gml.gmt(a.b("\ubd6c\uc4e9\u4e3b\ud051\u5ba8\udd2a\u6766\uee95\u70d7", -785531612), true);
                break;
            }
            case 60: {
                gml.gms(a.c(-1690082569, "\u62b9\u1b3c\u91ee\u0f84\u847d\u02ff\ub8b3\u3140\uaf02\u25e1\ua271\u580b\ud6d1\u4f76\uc522"), gml.gmr(minecraftClient, EquipmentSlot.field_6174).method_31574(Items.field_8058), gml.gmr(minecraftClient, EquipmentSlot.field_6174));
                gml.gms(a.b("\ub7d4\uce51\u4483\udae9\u5110\ud792\u6dde\ue42d\u7a6f\uf08c\u7717\u8d6b\u03b8\u9a0c\u101b\u96e2\u2ce7\ua321\u3989\ubfd2\u362d\u4c75\uc28a", -2129938558), gml.gmr(minecraftClient, EquipmentSlot.field_6169).method_31574(Items.field_22027), gml.gmr(minecraftClient, EquipmentSlot.field_6169));
                gml.gms(a.d("\uab32\ud2b7\u5865\uc60f\u4df6\ucb74\u7138\uf8cb\u6689\uec6a\u6bf7\u9187\u1f1f\u86e7\u0caf\u8a43\u300d", 755053315, -400254879), gml.gmr(minecraftClient, EquipmentSlot.field_6166).method_7960(), gml.gmr(minecraftClient, EquipmentSlot.field_6166));
                ItemStack itemStack = gml.gmr(minecraftClient, EquipmentSlot.field_6172);
                gml.gms(a.d("\u6ec2\u1747\u9d95\u03ff\u8806\u0e84\ub4c8\u3d3b\ua379\u299a\uae05\u547d\udaa8\u430d", 598271865, -779908620), itemStack.method_31574(Items.field_8348) && itemStack.method_7919() == 0, itemStack);
                break;
            }
            case 70: {
                gml.gmv(minecraftClient, a.b("\ub7c8\uce64\u44a6\udadf\u5145\ud7a6\u6de2\ue406\u7a45\uf0f9\u7728\u8d5f\u03cd\u9a39\u1061\u968a\u2cd8\ua314\u39aa\ubfa2\u3635\u4c57\uc2b7\u5927\udf4b\u5585\uec34\u6278\uf8d3\u7ec0\uf57a\u0ba9\u81f2\u1850\u9e54\u14fb\uab31\u215c\ua7c7\u3e3b\ub460\uca96\u40ce\uc779\u5dbf\ud3dd\u6a09\ue0aa\u66ab\ufd24\u735a\u89838\u866b\u1c99\u92c2\u2946\uafa4\u25de\ubc0d\u32ba\u48e5\ucf11\u4549\udb92\u520b\ue86e\u6e9b\ue4cb\u7b71\uf1a4\u77c4\u8e08\u04be\u9aff\u1140\u9749\u2dfd\ua422\u3a5f\ub096\u36c5\u4d2e\uc3f6\u598c\ud050\u568a", 1457895414));
                break;
            }
            case 75: {
                gml.gmv(minecraftClient, a.d("\u6079\u19d5\u9317\u0d6e\u86f4\u0017\uba53\u33b7\uadf4\u2748\ua099\u5aee\ud47c\u4d88\uc7d0\u413b\ufb69\u74a5\uee1b\u6813\ue184\u9be6\u1506\u8e9e\u08e6\u822f\u3b8f\ub5d5\u2f38\ua972\u22dc\udc06\u561e\ucff6\u49b2\uc354\u7c9d\uf6f1\u703e\ue9c7\u63d5\u1d20\u9774\u10ce\u8a1f\u047f\ubdbf\u3709\ub154\u2acb\ua4e6\u5e3a\ud785\u51d8\ucb29\u4579\ufecc\u7826\uf266\u6bbe\ue50b\u9f5a\u18a7\u92f1\u0c37\u8592", -83468132, -1331625778));
                break;
            }
            case 110: {
                ItemStack itemStack = gml.gmr(minecraftClient, EquipmentSlot.field_6172);
                gml.gms(a.d("\u8e18\uf79d\u7d4f\ue325\u68dc\uee5e\u5412\udde1\u43a3\uc940\u4ed1\ub4b0\u3a70\ua3c5\u299c\uaf6f\u1527\u9aff\u000b\u8609\u0ffa\u75bd\ufb1f", 1771123776, 2046540302), itemStack.method_7919() == 0, itemStack);
                gml.gmt(a.c(-1053344482, "\u3d56\u44d3\uce01\u506b\udb92\u5d10\ue75c\u6eaf\uf0ed"), false);
                break;
            }
            case 120: {
                gml.gmv(minecraftClient, a.c(-1944162761, "\u6e67\u17cb\u9d09\u0370\u88ea\u0e09\ub44d\u3da9\ua3ea\u2956\uae87\u54f0\uda62\u4396\uc9ce\u4f25\uf577\u7abb\ue005\u660d\uef9a\u95f8\u1b18\u8080\u06f8\u8c31\u3591\ubbcb\u2126\ua76c\u2cc2\ud218\u5800\uc1ee\u47bc\ucd1d\u729d\uf8f2\u7e3c\ue791\u6d86\u133a\u996d\u1edb\u8407\u0a70\ub3b2\u3910\ubf58\u249b\uaaa6\u5028\ud996\u5fd2\uc52c\u4b7b\uf0d7"));
                kfe kfe2 = gml.gmt(a.c(1292010177, "\u828e\ufb16\u71d0\uefac\u647d\ue2df\u58be\ud16b\u4f22\uc582"), true);
                int n2 = 0;
                for (vmo vmo2 : kfe2.getSettings()) {
                    if (!(vmo2 instanceof vlq)) continue;
                    vlq vlq2 = (vlq)vmo2;
                    vlq2.set(n2++ == 0 ? 74 : 75);
                }
                gml.gms(a.c(1718115172, "\u5b36\u22ae\ua868\u3614\ubdc5\u3b67\u8106\u08d3\u969a\u1c3a\u9bb9\u619c\uef48\u76e1\ufcfd\u7a5f\uc006\u4fc6\ud575\u5339\udac9\ua091\u2e36"), kfe2.getSettings().size() == 2 && n2 == 2, kfe2.getSettings().size());
                break;
            }
            case 130: {
                gmm.add(74);
                break;
            }
            case 133: {
                gmm.remove(74);
                break;
            }
            case 160: {
                gml.gms(a.d("\ufa1f\u8387\u0941\u973d\u1cec\u9a4e\u202f\ua9fa\u37b3\ubd13\u3a90\uc0ae\u4e78", 1920992336, 784268807), gml.gmr(minecraftClient, EquipmentSlot.field_6174).method_31574(Items.field_8833), gml.gmr(minecraftClient, EquipmentSlot.field_6174));
                gmm.add(74);
                break;
            }
            case 163: {
                gmm.remove(74);
                break;
            }
            case 190: {
                gml.gms(a.b("\uea3a\u93a2\u1964\u8718\u0cc9\u8a6b\u300a\ub9df\u2796\uad36\u2ab5\ud086\u5e52\uc7e1\u4dba", -1339037072), gml.gmr(minecraftClient, EquipmentSlot.field_6174).method_31574(Items.field_8058), gml.gmr(minecraftClient, EquipmentSlot.field_6174));
                gml.gmv(minecraftClient, a.b("\udc28\ua584\u2f46\ub13f\u3aa5\ubc46\u0602\u8fe6\u11a5\u9b19\u1cc8\ue6bf\u682d\uf1d9\u7b81\ufd6a\u4738\uc8f4\u524a\ud442\u5dd5\u27b7\ua957\u32cf\ub4b7\u3e7e\u87de\u0984\u9369\u1523\u9e8d\u6057\uea4f\u73a2\uf5f3\u7f52\uc0d2\u4abd\ucc73\u55de\udfc9\ua175\u2b22\uac94\u3648\ub83f\u01fd\u8b5f\u0d17\u96d4\u18e9\ue264\u6bdc\ued96\u7772\uf931\u4296\uc45a\u4e30\ud7d5\u594f\u2303\ua4fc\u2ea5\ub064\u39c4\u83c3\u0523\u8f73", -360915964));
                minecraftClient.field_1724.method_36457(90.0f);
                gmo = minecraftClient.field_1724.method_31548().method_67532();
                break;
            }
            case 195: {
                gmm.add(75);
                break;
            }
            case 197: {
                gmm.remove(75);
                break;
            }
            case 230: {
                int n3 = 0;
                for (int i = 0; i < minecraftClient.field_1724.method_31548().method_5439(); ++i) {
                    ItemStack itemStack = minecraftClient.field_1724.method_31548().method_5438(i);
                    if (!itemStack.method_31574(Items.field_8639)) continue;
                    n3 += itemStack.method_7947();
                }
                gml.gms(a.c(1976948043, "\ud516\uac8e\u2648\ub834\u33e5\ub547\u0f26\u86f3\u18ba\u921a\u1599\uefae\u6176\uf8dc\u7298\uf47b\u4e2c\uc1e0\u5b4a\udd50\u54f2\u2ea5\ua000\u3bd0"), n3 == 15, n3);
                gml.gms(a.d("\ue85b\u91c3\u1b05\u8579\u0ea8\u880a\u326b\ubbbe\u25f7\uaf57\u28d4\ud2e3\u5c3b\uc591\u4fd5\uc936\u7361\ufcad\u6607\ue01d\u69a8\u13fa\u9d4b\u0692\u80a6\u0a3e\ub38a\u3d95\ua732\u217f\uaac1\u5412\ude5b", 359606986, 476693237), minecraftClient.field_1724.method_31548().method_5438(29).method_31574(Items.field_8639) && minecraftClient.field_1724.method_31548().method_67532() == gmo, minecraftClient.field_1724.method_31548().method_5438(29));
                gml.gmt(a.c(-1964206851, "\u94b2\ued2a\u67ec\uf990\u7241\uf4e3\u4e82\uc757\u591e\ud3be"), false);
                minecraftClient.field_1724.method_36457(0.0f);
                break;
            }
            case 240: {
                gml.gmt(a.c(1476554783, "\u705a\u09c4\u831b\u1d62\u9680\u1013\uaa5d\u23b7\ubdf9\u374e\ub08a"), true);
                String string = minecraftClient.method_1548().method_1676();
                gml.gmv(minecraftClient, a.d("\u33ec\u4a4d\uc092\u5efe\ud53e\u5388\ue9d6\u6029\ufe65\u74c2\uf355\u096b\u87b1\u1e08\u9454\u12a3\ua8fb\u2737\ubd9b\u3bd9\ub238\uc83a\u46c8\udd1c\u5b63\ud1f6\u680b\ue644\u7ce3\ufaf6\u7154\u8f9d\u05d2\u9c37\u1a3d\u908e\u2b64\ua14a\u27e7\ube2c\u340f\u4afd\uc0d9\u4304", 809384694, 457574725) + string + a.b("\uacb4", 505326743));
                gml.gmv(minecraftClient, a.c(1555381848, "\u3e00\u47a1\ucd7e\u5312\ud8d2\u5e64\ue43a\u6dc5\uf389\u792e\ufeb9\u0487\u8a5d\u13e4\u99b8\u1f4f\ua517\u2adb\ub077\u3635\ubfd4\uc5d6\u4b36\ud0f1\u569f\udc5e\u65e0\uebab\u715f\uf712\u7cac\u8265\u0873\u91d1\u1798\u9d24\u22f2\ua884\u2e54\ub7f6\u3dfb\u4344\uc909"));
                gml.gmv(minecraftClient, a.d("\u9b50\ue2f1\u682e\uf642\u7d82\ufb34\u416a\uc895\u56d9\udc7e\u5be9\ua1c8\u2f03\ub6bf\u3cf4\uba19A\u8f91\u1571\u9373\u1a92\u60d2\uee35", -621032919, -624471779) + string + a.d("\uca47\ub3b8\u3975\ua754\u2c94", -679766179, 59530559));
                gml.gmv(minecraftClient, a.c(651657541, "\u812d\uf88c\u7253\uec3f\u67ff\ue149\u5b17\ud2e8\u4ca4\uc603\u4194\ubbb5\u357e\uacc2\u2689\ua064\u1a3c\u95ec\u0f0c\u890e\u00ef\u7aaf\uf448\u6ba4\uedfe\u672d\uda9e") + string + a.b("\uf774\u8e8b\u0446\u9a67\u11a3", 410056529));
                gml.gmv(minecraftClient, a.d("\u8b93\uf22f\u78e0\ue691\u6d57\uebe5\u51a5\ud806\u4618\uccac\u4b7f\ub14a\u3fdb\ua660\u2c30\uaad9\u10db\u9f5e\u05f3\u83f2\u0a07\u7465\ufaf9\u6157\ue728\u6998\ud43f\u5a61\uc0e2\u42dc", -1204514642, 903093057) + string + a.c(-1452256846, "\u5191"));
                gml.gmv(minecraftClient, a.b("\ud66e\uafd2\u251d\ubb6c\u30aa\ub618\u0c58\u85fb\u1bf7\u9150\u1692\uecb7\u6226\ufb9d\u71cd\uf724\u4d26\uc2a3\u580e\ude0f\u57a8\u2de5\ua35b\u3892\ubef1\u3437\u8d85\u0387\u9910\u1f72", -325528046));
                gml.gmv(minecraftClient, a.b("\ub5ec\ucc40\u4682\ud8fb\u5361\ud582\u6fc6\ue622\u7861\uf2dd\u750c\u8f7b\u01e9\u981d\u1245\u94ae\u2efc\ua130\u3b8e\ubd86\u3411\u4e73\uc093\u5b0a\udd72\u57b8\uee1d\u604f\ufaab\u7ca6\uf70a\u09ca\u83d2\u1a3d\u9c73\u16de\ua941\u237d\ua5aa\u3c1c\ub648\uc8bf\u42fd\uc55f\u5f8f\ud1ec\u6871\ue28a\u64d4\uff14\u7172\u8bb4\u022a\u844d\u1eba\u90ec\u2b58\uad8f\u27ed\ube2f\u309f\u4adc\ucd61\u4766\ud9aa\u5006\uea42\u6ceb\ue6da\u7917\uf3c1\u7180\u8876\u02cc\u9c9b\u176b\u9132\u2b8d\ua22d\u3820\ub2f5", 681883092) + string + a.c(-2002409295, "\ua897\ud123\u5b8a\uc5fb"));
                break;
            }
            case 245: {
                gml.gmv(minecraftClient, a.d("\u6aa1\u1301\u99db\u07aa\u8c63\u0ac1\ub084\u3922\ua71d\u2d9f\uaa1f\u506c\udef1\u474d\ucd17\u4be6\uf1aa\u7e34", 1724644439, 1063098000) + minecraftClient.method_1548().method_1676() + a.d("\u2530\u5cc9\ud617\u4871\uc3b1\u4547", 1448794323, -1867711035));
                break;
            }
            case 248: {
                gml.gmv(minecraftClient, a.b("\u9b07\ue2ab\u6865\uf60c\u7dd2\ufb26\u4115\uc8d7\u56db\udc3e\u5bf0\ua19c\u2f53\ub6eb\u3cfd\uba0e\u047c\u8bf2\u1139\u9762\u1e92\u64b4\uee69\u75b4", 1469225835) + minecraftClient.method_1548().method_1676() + a.d("\ud5f9", -218393377, -1458880251));
                break;
            }
            case 252: {
                String string = gml.gmu(minecraftClient);
                gml.gms(a.b("\ub156\uc8c8\u4217\udc6e\u578c\ud11f\u6b51\ue2bb\u7cf5\uf642\u7186\u8ba3\u0537\u9c8d\u16d7\u9033", -708529912), string.contains(a.c(-777997596, "\ub2a6\ucb3d\u41ed\udf84")) && !string.contains(minecraftClient.method_1548().method_1676()), string);
                ItemStack itemStack = minecraftClient.field_1724.method_31548().method_5438(1);
                String string2 = itemStack.method_7950(Item.TooltipContext.field_51353, (PlayerEntity)minecraftClient.field_1724, (TooltipType)TooltipType.field_41070).toString();
                gml.gms(a.c(-1324821619, "\ud3e1\uaa7f\u20a0\ubed9\u353b\ub3a8\u09e6\u800c\u1e42\u94f5\u1331\ue914\u678f\ufe37\u7460\uf286\u48da\uc71d\u5dfd\udbe0\u5214\u2858\ua6fc\u3d68\ubb43\u3189\u8875\u0669\u9c9c\u1ac6\u9164\u6fac\ue5ea\u7c0d"), string2.contains(minecraftClient.method_1548().method_1676()), string2);
                minecraftClient.field_1690.field_1907.method_23481(true);
                break;
            }
            case 256: {
                gml.gmw(minecraftClient, a.d("\u695b\u10e1\u9a20\u044b\u8f9e\u0924\ub360\u3acf\ua4d3\u2e6d\ua9b2\u53cb\udd09\u44ba\ucef4\u481e\uf240\u7d97\ue733", 85074728, 318065166));
                break;
            }
            case 258: {
                minecraftClient.field_1690.field_1907.method_23481(false);
                gml.gmt(a.d("\udb31\ua2af\u2870\ub609\u3deb\ubb78\u0136\u88dc\u1692\u9c25\u1be1", -2063666699, 267332225), false);
                break;
            }
            case 262: {
                gml.gmw(minecraftClient, a.b("\u3ca9\u4513\ucfd2\u51b9\uda6c\u5cd6\ue692\u6f3d\uf121\u7b9f\ufc40\u0639\u88fb\u1148\u9b06\u1dec\ua7b2\u2865\ub2c1\u34c9\ubd7c\uc724\u4997", 454048976));
                break;
            }
            case 264: {
                String string = minecraftClient.method_1548().method_1676();
                gml.gmv(minecraftClient, a.d("\u4079\u39d8\ub307\u2d6b\ua6ab\u201d\u9a43\u13bc\u8df0\u0757\u80c0\u7afe\uf424\u6d9d\ue7c1\u6136\udb6e\u54a2\uce0e\u484c\uc1ad\ubbaf\u354e\uae88\u28ff\ua22c\u1b86\u95c4\u0f76\u8969\u02c4", 90450245, 453011792));
                gml.gmv(minecraftClient, a.c(-951125806, "\uf8a6\u811a\u0bd5\u95a4\u1e62\u98d0\u2290\uab33\u353e\ubf98\u3843\uc230\u4cfe\ud55c\u5f4a\ud9fd\u63b8\uec6a\u76c1\uf0dd\u797e\u0331"));
                gml.gmv(minecraftClient, a.d("\u43ee\u3a42\ub08c\u2ee5\ua53b\u23cf\u99fc\u103e\u8e32\u04c0\u831c\u7964\uf7b7\u6e15", -355964792, 87960348));
                gml.gms(a.d("\ubd92\uc40c\u4ed3\ud0aa\u5b48\udddb\u6795\uee7f\u7031\ufa86\u7d42\u8767\u09ff\u9047\u1a14\u9ca3\u26be\ua978\u33dd\ub58b\u3c67\u462b\uc88f\u5348", 1656319985, 2110181941), !string.isEmpty(), string);
                break;
            }
            case 270: {
                gml.gmw(minecraftClient, a.c(2094245578, "\ua6a9\udf13\u55d2\ucbb9\u406c\uc6d6\u7c92\uf53d\u6b3f\ue192\u664c\u9c35\u12e5"));
                break;
            }
            case 275: {
                gml.gmt(a.c(-624765798, "\ud4d0\uad53\u2783\ub9e7\u3236\ub490\u0ee5\u8727\u196d\u93c1\u1414"), true);
                break;
            }
            case 285: {
                gml.gmw(minecraftClient, a.b("\u39f7\u404d\uca8c\u54e7\udf32\u5988\ue3cc\u6a63\uf470\u7ed3\uf903\u0367\u8db6\u1410", 1923168663));
                break;
            }
            case 290: {
                gml.gmt(a.c(475161172, "\u621e\u1b9d\u914d\u0f29\u84f8\u025e\ub82b\u31e9\uafa3\u250f\ua2da"), false);
                System.out.println(a.d("\udad7\ua370\u29aa\ub7d1\u3c40\ubaa5\u00e7\u8900\u1758\u9dbd\u1a20\ue05a\u6e9f\uf734\u7d65\ufb9f\u41c7\uce5f\u54f6", 101498018, 818832917) + (gmn == 0 ? a.b("\u339d\u4a21\uc0f2\u5eef\ud548\u53e8\ue9a9\u6058", -1568132140) : gmn + a.d("\u1a4b\u639c\ue948\u7731\ufce3", -40831462, -1285034892)));
                vzz.simulated = null;
                return true;
            }
        }
        return false;
    }

    private static ItemStack gmr(MinecraftClient minecraftClient, EquipmentSlot equipmentSlot) {
        return minecraftClient.field_1724.method_6118(equipmentSlot);
    }

    private static void gms(String string, boolean bl, Object object) {
        if (!bl) {
            ++gmn;
        }
        System.out.println(a.b("\u6005\u19a2\u9378\u0d03\u8692w\uba35\u33d2\uad8a\u276f\ua0f2\u5a88\ud44d\u4de6\uc7b7\u414d\ufb15\u7497", 472866916) + (bl ? a.d("\u908d\ue92d\u63ec\ufd9d\u7639", 766419575, -1407896913) : a.d("\u2f0a\u56bc\udc67\u4213\uc9a8", -541978352, 311115353)) + string + a.d("\ub4b6\ucd0a\u47ca\ud9a5", 373883518, 2034611948) + object);
    }

    private static kfe gmt(String string, boolean bl) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 == null) {
            System.out.println(a.c(1226504343, "\uf8c5\u8162\u0bb8\u95c3\u1e52\u98b7\u22f5\uab12\u354a\ubfaf\u3832\uc248\u4c8d\ud526\u5f77\ud98d\u63d5\uec57\u7682\uf0d4\u792b\u037f\u8da0\u163f\u9041\u1adf\ua321\u2d72\ub78e\u31ce\uba64\u44bc\uceb6") + string);
            ++gmn;
            return null;
        }
        kfe2.setEnabled(bl);
        System.out.println(a.b("\ue7c2\u9e65\u14bf\u8ac4\u0155\u87b0\u3df2\ub415\u2a4d\ua0a8\u2735\udd4f\u538a\uca21\u4070\uc68a\u7cd2\uf350", -561059933) + string + a.b("\u9ca2\ue556\u6f8e\uf1f0\u7a24\ufc9b\u46c1\ucf31\u5137", 1524735115) + kfe2.isEnabled());
        return kfe2;
    }

    private static String gmu(MinecraftClient minecraftClient) {
        try {
            for (Field field : minecraftClient.field_1705.method_1743().getClass().getDeclaredFields()) {
                Object e;
                if (!List.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                List list = (List)field.get(minecraftClient.field_1705.method_1743());
                if (list.isEmpty() || !((e = list.get(0)) instanceof ChatHudLine)) continue;
                ChatHudLine chatHudLine = (ChatHudLine)e;
                return chatHudLine.comp_893().getString();
            }
        }
        catch (Exception exception) {
            return a.d("\ubff7\uc659", -2058535814, 740721584) + exception;
        }
        return "";
    }

    private static void gmv(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void gmw(MinecraftClient minecraftClient, String string) {
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\u83ff\ufa44\u7094\ueefd\u656f\ue3c1", -848198097, 758515120) + string + a.c(944517745, "\u325b\u4bb4\uc179\u5f01")), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int ux(int n, int n2) {
        return (n ^ n2) + 1023961257;
    }

    private static /* synthetic */ int uy(int n, int n2) {
        return gml.ux(n, n2) * n2;
    }
}

