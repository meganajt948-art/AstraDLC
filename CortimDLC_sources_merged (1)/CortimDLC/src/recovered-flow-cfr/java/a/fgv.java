/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket$Mode
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket
 *  net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket
 *  net.minecraft.server.network.ServerCommonNetworkHandler
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.util.PlayerInput
 */
package a;

import a.fgs;
import a.kfe;
import a.oxw;
import a.vkl;
import a.vlq;
import a.vmo;
import a.vvn;
import a.vzz;
import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.PlayerInput;

final class fgv {
    private static final String fgw = a.d("\u1ce6\u6545\uef9b\u71b4\ufa7b\u7c85\uc6d2\u4f24\ud170\u5bc7\udc05\u2667\ua8b7\u3114\ubb09\u3db1\u87e3\u0833\u9298\u14dc\u9d28\ue774\u69c7\uf258\u7429\ufeb7\u4708\uc943\u53af\ud5e4\u5e19\ua0ca\u2a91\ub32f\u3570\ubfc3\t\u8a67\u0cb5\u950f\u1f5b\u61b0\uebe4\u6c1c\uf68a\u78a2\uc13e\u4b8b\ucdc3\u5619\ud86c\u22ac\uab08\u2d5e\ub7bf\u39a0\u8246\u0481\u8ef4\u1722\u998e\ue3dd\u641c\uee7c\u70bc\uf901\u435a\uc5ec\u4fa3\ud00a\u5eda\ud8b7\u2160\uabd2\u3589\ube7c\u3c31\u8297\u0b43\u953e\u1ff3\u99dc\ue211\u6cc9\uf6b3\u7f68\ufdc9\u47c7\uc838", 644535152, 656789428);
    private static final Set<Integer> fgx = ConcurrentHashMap.newKeySet();
    private static final StringBuffer fgy = new StringBuffer();
    private static volatile boolean fgz;
    private static volatile boolean fha;
    private static volatile boolean fhb;
    private static volatile int fhc;
    private static volatile int fhd;
    private static volatile int fhe;
    private static int fhf;
    private static boolean fhg;
    private static kfe fhh;
    private static int fhi;
    private static int fhj;
    private static int fhk;
    private static /* synthetic */ int fhl;
    private static /* synthetic */ boolean fhm;

    private fgv() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        fhe = n;
        if (minecraftClient.player != null && n > 10) {
            minecraftClient.player.setYaw(0.0f);
            if (!oxw.busy()) {
                minecraftClient.player.setPitch(0.0f);
            }
        }
        switch (n) {
            case 1: {
                vzz.simulated = fgx::contains;
                fgv.fhz(a.c(192891683, "\u4b68\u32ed\ub83f\u2655\uadbe\u2b2c\u917d\u1897\u86cf\u0c64"), false);
                fhh = fgv.fhz(a.b("\u44c5\u3d42\ub786\u29f3\ua237\u2491\u9ef8\u1724\u8972\u03df\u8419\u7e7f", 255870106), true);
                for (vmo vmo2 : fhh.getSettings()) {
                    vkl vkl2;
                    vkl vkl3;
                    vlq vlq2;
                    vlq vlq3;
                    if (vmo2 instanceof vlq && (vlq3 = (vlq)vmo2).getName().equals(a.b("\ua793\ude3e\u54e5\uca97\u4148\uc7fd\u79b4\uf452\u6a0a\ue0b7\u6766\u9d69\u13c0\u8a78&\u86dd", 763143074))) {
                        vlq3.set(fhi);
                        continue;
                    }
                    if (vmo2 instanceof vlq && (vlq2 = (vlq)vmo2).getName().equals(a.c(-1616320011, "\uede9\u947f\u1edc\u80a2\u0b0e\u89ab\u37ea\ube1c\u2034\uaa87\u2d24"))) {
                        vlq2.set(fhj);
                        continue;
                    }
                    if (vmo2 instanceof vkl && (vkl3 = (vkl)vmo2).getName().equals(a.b("\ucbd8\ub23b\u3890\ua6ea\u2d3f\uab8c\u15cf\u9821\u067f\u8cb1\u0b18\uf167\u7ba5\ue603\u6c57\uead6\u5096\udf3c\u458b", -2063347750))) {
                        vkl3.set(false);
                        continue;
                    }
                    if (!(vmo2 instanceof vkl) || !(vkl2 = (vkl)vmo2).getName().equals(a.d("\u538d\u2a63\ua0bb\u3eb7\ub568\u33dd\u8d94w\u9a3a\u14e9\u9348\u6930\ue7e2\u7e57\uf401\u72fe", 184781602, -1770857312))) continue;
                    vkl2.set(false);
                }
                fgv.fia(minecraftClient, a.d("\uebf4\u9243\u189c\u86e5\u0d3a\u8b89\u31d1\ub821\u263b\uacd9\u2b0c\ud17a\u5fa9\uc607\u4c4b\ucaad\u70ef", -1425560337, -956283027));
                fgv.fia(minecraftClient, a.c(312132122, "\uc25b\ubbe9\u313a\uaf48\u2499\ua23f\u1838\u918e\u0fdf\u8571\u02b1\uf885\u7632\uefb0\u65b0\ue313\u594b\ud68c\u4c25\uca6e\u439e\u39da\ub766\u2cba\uaac3\u2057\u99f2\u17a5\u8d52\u0b13\u80b4\u7e71\uf46a\u6d9d\uebc9\u6168"));
                fgv.fia(minecraftClient, a.d("\u99b0\ue002\u6ad1\uf4a3\u7f72\uf9d4\u43d3\uca65\u5434\ude9a\u595a\ua36e\u2dd9\ub45b\u3e5b\ub8f9\u02a4\u8d60\u17d2\u9184\u1860\u6224\uec8a\u775d\uf123\u7bbc\uc219\u4c4e\ud6b9\u50f8\udb5f\u259a\uaf81\u3676\ub022\u3a83", 627316700, -1842508243));
                fgv.fia(minecraftClient, a.c(-578724654, "\u5ca9\u251e\uafc1\u31b8\uba78\u3cce\u8684\u0f7c\u9166\u1b93\u9c4b\u6618\ue8ed\u7151\ufb33\u7de1\uc7bf\u4878\ud2d2\u5484\udd74\ua72c\u29d8\ub24f\u3437\ubeeb\u0747\u8900"));
                break;
            }
            case 5: {
                fgv.fib(minecraftClient);
                break;
            }
            case 10: {
                fgv.fia(minecraftClient, a.c(-1674384711, "\uead2\u936c\u19b6\u87c3\u0c07\u8ae4\u30d7\ub915"));
                fgv.fia(minecraftClient, a.d("\u1956\u60fa\uea38\u7441\uffdb\u7938\uc37c\u4a98\ud4db\u5e67\ud9b6\u23c1\uad53\u34a7\ubeff\u3814\u8246\u0d8a\u9734\u113c\u98ab\ue2c9\u6c29\uf7b0\u71c8\ufb02\u42a7\uccf5\u5611\ud01c\u5bb1\ua570\u2f68\ub687\u30c9\uba64\u05fb\u8fc7\u0910\u90a6\u1af2\u6405\uee47\u69e5\uf335\u7d56\uc4cb\u4e24\uc866\u53bf\uddc0\u2713\uaea5\u28fe\ub236\u3c4b\u87f0\u0139\u8b57\u1290", 65477195, 50463560));
                fgv.fia(minecraftClient, a.d("\u6a7e\u13d2\u9910\u0769\u8cf3\u0a10\ub054\u39b0\ua7f3\u2d4f\uaa9e\u50e9\ude7b\u478f\ucdd7\u4b3c\uf16e\u7ea2\ue41c\u6214\ueb83\u91e1\u1f01\u8499\u02e1\u8828\u3188\ubfd2\u253f\ua375\u28db\ud601\u5c19\uc5f5\u43b5\uc953\u769a\ufcf6\u7a39\ue3c0\u69d2\u1727\u9d73\u1ac9\u8018\u0e78\ub7b8\u3d0e\ubb53\u20cc\uaee7\u5421\udd8d\u5bd6\uc12d\u4f75\uf4f4\u721c\uf878\u61b2\uef0f\u9556\u12ac\u98c7\u0634\u8f89\u35db\ub330\u3976\ua6cc\u2c05\uaa73\u53e2\ud935\u4746\ucca5\u4aff\uf010\u79db\ue7e5\u6d2e\ueb78\u90c0\u1e17\u8471\u0db3\u8b07\u3144\ubef5\u24e9\ua244\u2b92\ud1ef\u5f05\uc48a\u42d0\uc816\u7674\uffb2\u6501\ue311\u68ee\u16f2\u9c4f\u058a\u83e0\u0929\ub6d6\u3c8e\uba37\u2035\ua9d3\u570e\udd52\u5aff\uc0b6\u4e4e\uf79b\u7def\ufb35\u608c\ueecc\u942c\u127a\u9bdf\u0140\u8f68\u34aa\ub2e5\u3849\ua182\u2fa6\ud57f\u5281\ud8de\u4635\ucc71\u75da\uf347\u793d\ue6eb\u6c17\uea64\u9395", -809739439, -655085098));
                minecraftClient.player.getInventory().setSelectedSlot(0);
                break;
            }
            case 20: {
                fgv.fho(minecraftClient, true);
                break;
            }
            case 40: {
                fgv.fhn(minecraftClient, fhj);
                break;
            }
            case 70: {
                fgv.fho(minecraftClient, false);
                fgv.fhr(minecraftClient, a.d("\u6c52", 551280286, 22786700), Items.DIAMOND_SWORD);
                fgv.fht(minecraftClient, a.c(-785915601, "\ue16f"), 12, Items.WIND_CHARGE, 4);
                fgv.fht(minecraftClient, a.b("\u484c", -1565177844), 12, Items.ARROW, 10);
                fgv.fhv(minecraftClient, a.c(-759465548, "\u79f4"));
                fgv.fhx(a.c(855086810, "\u969a"));
                break;
            }
            case 80: {
                fgv.fhp(minecraftClient, a.b("\ub0e9\uc95c\u4388\uddf2\u5623\ud083\u6ac3\ue335\u7d78\uf787\u700a\u8a76\u04ba\u9d0d\u170a\u91ed\u2ba0", -288182123));
                fgv.fia(minecraftClient, a.c(-270603253, "\uec5e\u95f2\u1f30\u8149\u0ad3\u8c30\u3674\ubf90\u21d3\uab6f\u2cbe\ud6c9\u585b\uc1af\u4bf7\ucd1c\u774e\uf882\u623c\ue434\u6da3\u17c1\u9921\u02b8\u84c0\u0e0a\ub7af\u39fd\ua319\u2514\uaeb9\u5078\uda60\u438f\uc5c1\u4f6c\uf0f3\u7acf\ufc18\u65ae\ueffa\u910d\u1b4f\u9ced\u063d\u885e\u31c3\ubb2c\u3d6e\ua6b7\u28c8\ud21b\u5bad\uddf6\u473e\uc943\u72f8\uf431\u7e5f\ue798"));
                fgv.fia(minecraftClient, a.c(626761421, "\u9e98\ue734\u6df6\uf38f\u7815\ufef6\u44b2\ucd56\u5315\ud9a9\u5e78\ua40f\u2a9d\ub369\u3931\ubfda\u0588\u8a44\u10fa\u96f2\u1f65\u6507\uebe7\u707e\uf606\u7ccc\uc569\u4b3b\ud1df\u57d2\udc7a\u22be\ua8a6\u3149\ub707\u3daa\u8235\u0809\u8ede\u1768\u9d3c\ue3cb\u6989\uee2b\u74fb\ufa98\u4305\uc9eb\u4faf\ud474\u5a06\ua0c0\u295a\uaf24\u35c2\ubb97;\u86f4\u0ccb\u950e"));
                fgv.fia(minecraftClient, a.b("\ud264\uabc8\u210a\ubf73\u34e9\ub20a\u084e\u81aa\u1fe9\u9555\u1284\ue8f3\u6661\uff95\u75cd\uf326\u4974\uc6b8\u5c06\uda0e\u5399\u29fb\ua71b\u3c83\ubafb\u3032\u8992\u07c8\u9d25\u1b6f\u90c1\u6e1b\ue403\u7def\ufbaf\u7149\uce80\u44ec\uc223\u5bda\ud1c8\uaf3d\u2569\ua2d3\u3802\ub662\u0fa2\u8514\u0349\u98d6\u16fd\uec3b\u6597\ue3cc\u7937\uf76f\u4cee\uca06\u4062\ud9a8\u5715\u2d4c\uaab6\u20dd\ube2e\u3793\u8dc1\u0b2a\u816c\u1ed6\u941f\u1269\uebf8\u612f\uff5c\u74bf\uf2e5\u480a\uc1c1\u5fff\ud534\u5362\u28da\ua60d\u3c6b\ub5a9\u331d\u895e\u06ef\u9cf7\u1a59\u9389\u69e6\ue722\u7c92\uface\u7001\uce3e\u47e3\udd1d\u5b46\ud0ad\uaee5\u244e\ubddf\u3bac\ub16b\u0e95\u84ce\u023d\u9873\u11dd\uef13\u6549\ue2b1\u78fa\uf64a\u4fd2\uc5e0\u4368\ud898\u56cd\u2c39\uaa63\u23d2\ub912\u3772\u8ca4\u0af9\u8006\u198c\u97eb\u6d3a\uea8c\u60c4\ufe37\u745a\ucdda\u4b06\uc17b\u5ea4\ud452\u5219\u2bf0\ua5bc\u3b71\ub0ca\u3698\u8c67\u0232\u9f9b\u115d\u9725\u6cf8\ue249\u7866\uf1ef\u77b7\ucd09\u42d2\udc8f\u5a21\ud072\ua992\u2712\ubd71\u3aaf\ub040\u0e07\u87b9\u1dee\u9b58\u1084\ueef3\u6431\ufd93\u7bdb\uf118\u4f25\uc4af\u420b\ud85a\u51b4\u2ffd\ua517\u22c8\ub8f4\u3629\u8f84\u05ce\u8327\u1938\u96fe\u6c4e\uea52\u6383\uf9d4", 1512886984));
                minecraftClient.player.getInventory().setSelectedSlot(0);
                break;
            }
            case 100: {
                fgv.fho(minecraftClient, true);
                break;
            }
            case 110: {
                fgv.fhn(minecraftClient, fhi);
                break;
            }
            case 140: {
                fgv.fho(minecraftClient, false);
                fgv.fhr(minecraftClient, a.b("\u71f2", 1343451569), Items.DIAMOND_SWORD);
                fgv.fhs(minecraftClient, a.b("\uab16", -1042961579), 5, Items.ENDER_PEARL, 4);
                fgv.fht(minecraftClient, a.c(1411108673, "\ucf02"), 12, Items.SNOWBALL, 7);
                fgv.fht(minecraftClient, a.b("\u19c4", 565320071), 12, Items.ARROW, 32);
                fgv.fht(minecraftClient, a.c(663858111, "\uabfc"), 12, Items.ENDER_PEARL, 0);
                fgv.fhu(minecraftClient, a.d("\u6630", -1421646715, -579403018), Items.DIRT, 2112);
                fgv.fhw(minecraftClient, a.b("\uce8a", 654560969));
                fgv.fhx(a.c(-154456710, "\u2d39"));
                break;
            }
            case 150: {
                fgv.fhp(minecraftClient, a.d("\ue7bc\u9e09\u14dd\u8aa7\u0176\u87d6\u3d96\ub460\u2a2d\ua0d2\u275f\udd23\u53ef\uca58\u405f\uc6b8\u7cf5", 1200770892, 659531916));
                fgv.fia(minecraftClient, a.c(-1958718617, "\u5332\u2a9e\ua05c\u3e25\ub5bf\u335c\u8918\u00fc\u9ebf\u1403\u93d2\u69a5\ue737\u7ec3\uf49b\u7270\uc822\u47ee\udd50\u5b58\ud2cf\ua8ad\u264d\ubdd4\u3bac\ub166\u08c3\u8691\u1c75\u9a78\u11d5\uef14\u650c\ufce3\u7aad\uf000\u4f9f\uc5a3\u4374\udac2\u5096\u2e61\ua423\u2381\ub951\u3732\u8eaf\u0440\u8202\u19db\u97a4\u6d77\ue4c1\u629a\uf852\u762f\ucd94\u4b5d\uc133\u58f4"));
                fgv.fia(minecraftClient, a.d("\u3e82\u472e\ucdec\u5395\ud80f\u5eec\ue4a8\u6d4c\uf30f\u79b3\ufe62\u0415\u8a87\u1373\u992b\u1fc0\ua592\u2a5e\ub0e0\u36e8\ubf7f\uc51d\u4bfd\ud065\u561d\udcd4\u6574\ueb2e\u71c3\uf789\u7c27\u82fd\u08e5\u9109\u1749\u9daf\u2266\ua80a\u2ec5\ub73c\u3d2e\u43db\uc98f\u4e35\ud4e4\u5a84\ue344\u69f2\uefaf\u7430\ufa1b\u00dd\u8971\u0f2a\u95d1\u1b89\ua008\u26e0\uac84\u354e\ubbf3\uc1aa\u4650\ucc3b\u52c8\udb75\u6127\ue7cc\u6d8a\uf230\u78f9\ufe8f\u071e\u8dc9\u13ba\u9859\u1e03\ua4ec\u2d27\ub319\u39d2\ubf84\uc43c\u4aeb\ud08d\u594f\udffb\u65b8\uea09\u7011\uf6bf\u7f6f\u8500\u0bc4\u9074\u1628\u9ce7\u22d8\uab05\u31fb\ub7a0\u3c4b\u4203\uc8a8\u5139\ud74a\u5d8d\ue273\u6828\ueedb\u7495\ufd3b\u03f5\u89af\u0e57\u941c\u1aac\ua334\u2906\uaf8e\u347e\uba2b\uc0df\u4685\ucf34\u55f4\udb94\u6042\ue61f\u6ce0\uf56a\u7b0d\u81dc\u066a\u8c22\u12d1\u98bc\u213c\ua7e0\u2d9d\ub242\u38b4\ubeff\uc716\u495a\ud797\u5c2c\uda7e\u6081\ueed4\u737d\ufdbb\u7bc3\u801e\u0eaf\u9480\u1d09\u9b51\u21ef\uae34\u3069\ub6c7\u3c94\u4574\ucbf4\u5197\ud649\u5ca6\ue2e1\u6b5f\uf108\u77be\ufc62\u0215\u88d7\u1175\u973d\u1dfe\ua3c3\u2849\uaeed\u34bc\ubd52\uc31b\u49f1\uce2e\u5412\udacf\u6362\ue928\u6fc1\uf5de\u7a18\u80a8\u06b4\u8f65\u1532", 1030380689, -1427676481));
                minecraftClient.player.getInventory().setSelectedSlot(0);
                break;
            }
            case 170: {
                fgv.fhn(minecraftClient, fhi);
                break;
            }
            case 200: {
                fgv.fhr(minecraftClient, a.b("\ua888", -557143862), Items.DIAMOND_SWORD);
                fgv.fht(minecraftClient, a.b("\ub193", -651972143), 12, Items.SNOWBALL, 7);
                fgv.fht(minecraftClient, a.d("\ub16d", 2072286785, -878565522), 12, Items.ARROW, 32);
                fgv.fhu(minecraftClient, a.d("\u7271", 966105098, -1756304839), Items.DIRT, 2176);
                fgv.fhw(minecraftClient, a.b("\u30ae", 408367340));
                fgv.fhx(a.d("\u886b", 332097813, 1909317948));
                break;
            }
            case 210: {
                fgv.fhp(minecraftClient, a.c(1636273031, "\u8bfb\uf24e\u789a\ue6e0\u6d31\ueb91\u51d1\ud827\u466a\ucc95\u4b18\ub164\u3fa8\ua61f\u2c18\uaaff\u10b2"));
                fgv.fia(minecraftClient, a.b("\u191e\u60b2\uea70\u7409\uff93\u7970\uc334\u4ad0\ud493\u5e2f\ud9fe\u2389\uad1b\u34ef\ubeb7\u385c\u820e\u0dc2\u977c\u1174\u98e3\ue281\u6c61\uf7f8\u7180\ufb4a\u42ef\uccbd\u5659\ud054\u5bf9\ua538\u2f20\ub6cf\u3081\uba2c\u05b3\u8f8f\u0958\u90ee\u1aba\u644d\uee0f\u69ad\uf37d\u7d1e\uc483\u4e69\uc82e\u53e4", 1333467461));
                fgv.fia(minecraftClient, a.c(1838312476, "\u6cb0\u151c\u9fde\u01a7\u8a3d\u0cde\ub69a\u3f7e\ua13d\u2b81\uac50\u5627\ud8b5\u4141\ucb19\u4df2\uf7a0\u786c\ue2d2\u64da\ued4d\u972f\u19cf\u8257\u042f\u8ee6\u3746\ub91c\u23f1\ua5bb\u2e15\ud0cf\u5ad7\uc33b\u457b\ucf9d\u7054\ufa38\u7cf7\ue50e\u6f1c\u11e9\u9bbd\u1c07\u86d6\u08b6\ub176\u3bc0\ubd9d\u2602\ua829\u52ef\udb43\u5d18\uc7e3\u49bb\uf23a\u74d2\ufeb6\u677c\ue9c1\u9398\u1462\u9e09\u00fa\u8947\u3315\ub5fe\u3fb8\ua002\u2acb\uacbd\u552c\udffb\u4188\uca6b\u4c31\uf6de\u7f15\ue12b\u6be0\uedb6\u960e\u18d9\u82bf\u0b7d\u8dc9\u378a\ub83b\u2231\ua491\u2d40\ud72a\u59e3\uc205\u445a\uceda\u70a7\uf96e\u63c4\ue589\u6e36\u106e\u9ad8\u034c\u856c\u0fe8\ub04b\u3a11\ubcbe\u26f5\uaf0b\u51c0\udb96\u5c6e\uc639\u489f\uf15d\u7b29\ufdea\u661b\ue803\u92ed\u14bd\u9d12\u07d6\u89a6\u327a\ub435\u3eca\ua717\u2929\ud3f2\u5459\ude11\u40fa\ucaeb\u7358\uf59f\u7fa1\ue07a\u6ac9\uec87\u9569\u1f27\u81fd\u0a45\u8c0e\u36fe\ub8e6\u2114\uab9c\u2dac\ud679\u58cd\uc297\u4b66\ucd26\u7786\uf850\u620d\ue4b2\u6eb8\u171f\u99ce\u03b8\u8470\u0ec3\ub0ae\u396e\ua332\u258f\uae50\u5066\udaad\u4304\uc148\u4b85\uf5fe\u7e2c\uf893\u62c6\uef2f\u9569\u1fd1\u980c\u027d\u8cd2\u351b\ubf43\u39bd\ua3e6\u283b\ud2d5\u5486\udd57\u4700"));
                minecraftClient.player.getInventory().setSelectedSlot(0);
                break;
            }
            case 230: {
                fgv.fhn(minecraftClient, fhi);
                break;
            }
            case 260: {
                fgv.fhr(minecraftClient, a.c(1014080994, "\ua5a7"), Items.AIR);
                fgv.fht(minecraftClient, a.b("\ua76b", 1308010286), 12, Items.SNOWBALL, 7);
                fgv.fht(minecraftClient, a.d("\uafba", -1905158281, 1744844936), 12, Items.ARROW, 16);
                fgv.fhw(minecraftClient, a.c(1294228714, "\u5caf"));
                fgv.fhx(a.d("\u0b10", -520123174, -1692956785));
                break;
            }
            case 270: {
                vzz.simulated = null;
                fgx.clear();
                System.out.println(a.d("\u6716\u1eb0\u9478\u0a03\u81dc\u0764\ubd72\u34d7\uaa99\u203e\ua7ea\u5dcf", -735804971, -1097800019) + (fhf == 0 ? a.d("\u04af\u7d0f\uf7ce\u69bf", -603285068, -2053006001) : a.b("\u4f21\u3697\ubc4c\u2238\ua983\u2f3a", -1533784223) + fhf + a.b("\ub80b", 21542947)));
                return true;
            }
        }
        if (n > fhk && n < fhk + 8 && minecraftClient.player != null) {
            System.out.println(a.b("\u0c10\u75b6\uff7e\u6105\ueada\u6c62\ud674\u5fd1", 1746537594) + n + a.d("\u29e9\u5042\udad3\u44b5\ucf64\u49df\uf3c8", -826878956, -658571840) + oxw.busy() + a.b("\uc911\ub0e8\u3a32\ua44c\u2f91\ua979", 602130743) + minecraftClient.player.getMainHandStack() + a.c(1647239394, "\ue0ca\u9938\u13fd\u8d8b\u065d\u80f0\u3abe\ub300") + minecraftClient.player.playerScreenHandler.getCursorStack() + a.d("\u1e94\u6775\uedbf\u73d3\uf813\u7ea9\uc4af", 1263301123, 1747872944) + minecraftClient.player.getPitch());
        }
        return false;
    }

    private static void fhn(MinecraftClient minecraftClient, int n) {
        fhc = 0;
        fhd = 0;
        fgy.setLength(0);
        fgz = true;
        fhk = fhe;
        fhh.onKey(minecraftClient, n);
    }

    private static void fho(MinecraftClient minecraftClient, boolean bl) {
        int n = 87;
        int n2 = 341;
        if (bl) {
            fgx.add(n);
            fgx.add(n2);
        } else {
            fgx.remove(n);
            fgx.remove(n2);
        }
        minecraftClient.options.forwardKey.setPressed(bl);
        minecraftClient.options.sprintKey.setPressed(bl);
    }

    private static void fhp(MinecraftClient minecraftClient, String string) {
        int n;
        fgv.fia(minecraftClient, a.c(862828649, "\ub810\uc1a3\u4b75\ud504\u5e9f\ud84e\u6238\uebf7\u7587\uff3b\u78e1\u8285\u0c0a\u95ef\u1fa1\u9941\u2306\uace7"));
        fgv.fia(minecraftClient, a.b("\ua7b2\ude0c\u54d6\ucaa3\u4167\uc784\u7db7\uf475", -150362151));
        for (n = 0; n < 9; ++n) {
            fgv.fia(minecraftClient, a.d("\uba3c\uc390\u4952\ud72b\u5cb1\uda52\u6016\ue9f2\u77b1\ufd0d\u7adc\u80ab\u0e39\u97cd\u1d95\u9b7e\u212c\uaee0\u345e\ub256\u3bc1\u41a3\ucf43\u54da\ud2a2\u5868\ue1cd\u6f9f\uf57b\u7376", 2002127990, -1371556291) + n + a.c(1296766142, "\u1498\u6d7e\ue7b3\u79df\uf214\u74ed") + string);
        }
        for (n = 0; n < 27; ++n) {
            fgv.fia(minecraftClient, a.c(274502064, "\u91f8\ue854\u6296\ufcef\u7775\uf196\u4bd2\uc236\u5c75\ud6c9\u5118\uab6f\u25fd\ubc09\u3651\ub0ba\u0ae8\u8524\u1f9a\u9992\u1005\u6a67\ue487\u7f1f\uf967\u73ae\uca0e\u4454\udeb9\u58f3\ud35d\u2d87\ua79f") + n + a.d("\u0530\u7cd6\uf61b\u6877\ue3bc\u6545", -1045814033, -1119673863) + string);
        }
    }

    private static ServerPlayerEntity fhq(MinecraftClient minecraftClient) {
        return minecraftClient.getServer().getPlayerManager().getPlayer(minecraftClient.player.getUuid());
    }

    private static void fhr(MinecraftClient minecraftClient, String string, Item item) {
        ItemStack itemStack = fgv.fhq(minecraftClient).getMainHandStack();
        fgv.fhy(string, item == Items.AIR ? itemStack.isEmpty() : itemStack.isOf(item), a.c(1389889576, "\u0845\u71fd\ufb21\u655a\ueed4") + itemStack);
        fgv.fhy(string, minecraftClient.player.playerScreenHandler.getCursorStack().isEmpty() && fgv.fhq((MinecraftClient)minecraftClient).playerScreenHandler.getCursorStack().isEmpty(), a.c(1491390755, "\ud150\ua8f7\u2223\ubc53\u3798\ub134\u0b35\u828a\u1cd4\u967e\u11f9\uebcd\u6512\ufcbe\u76e9\uf015"));
        fgv.fhy(string, !oxw.busy(), a.b("\u19be\u6008\ueac6\u74b2\uff65\u7998\uc389\u4a6f\ud436\u5e8d", 1209276871));
    }

    private static void fhs(MinecraftClient minecraftClient, String string, int n, Item item, int n2) {
        ItemStack itemStack = fgv.fhq(minecraftClient).getInventory().getStack(n);
        fgv.fhy(string, itemStack.isOf(item) && itemStack.getCount() == n2, a.b("\u80e0\uf94e\u739e\uedf4", 1199669399) + n + a.b("\u4867", -1880995749) + itemStack);
    }

    private static void fht(MinecraftClient minecraftClient, String string, int n, Item item, int n2) {
        BundleContentsComponent bundleContentsComponent = vvn.contents(fgv.fhq(minecraftClient).getInventory().getStack(n));
        int n3 = 0;
        if (bundleContentsComponent != null) {
            for (ItemStack itemStack : bundleContentsComponent.iterate()) {
                if (!itemStack.isOf(item)) continue;
                n3 += itemStack.getCount();
            }
        }
        fgv.fhy(string, n3 == n2, a.b("\u622a\u1b8c\u9144\u0f3f\u84e0\u0258\ub84e", 399401551) + item + a.b("\u3406", -771279814) + n3 + a.b("\u083b\u71cf\ufb01\u6578\ueeba\u680d\ud249\u5ba9\uc5f7\u4f02", 1980237841) + n2 + a.b("\ue1ed\u9854", 1414259151) + bundleContentsComponent + a.c(-338101845, "\uf983"));
    }

    private static void fhu(MinecraftClient minecraftClient, String string, Item item, int n) {
        PlayerInventory playerInventory = fgv.fhq(minecraftClient).getInventory();
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.getStack(i).isOf(item)) continue;
            n2 += playerInventory.getStack(i).getCount();
        }
        fgv.fhy(string, n2 == n, a.d("\u9ba0\ue20a\u68c2\uf6a6\u7d7c\ufb81", -606239669, -444981351) + item + a.d("\u1673", 1139039676, 1579240435) + n2 + a.c(-842749171, "\uab27\ud2d3\u581d\uc664\u4da6\ucb11\u7155\uf8b5\u66eb\uec1e") + n);
    }

    private static void fhv(MinecraftClient minecraftClient, String string) {
        PlayerInventory playerInventory = fgv.fhq(minecraftClient).getInventory();
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            fgv.fhy(string, i == 0 || i == 12 || itemStack.isEmpty(), a.d("\ucb0f\ub2b7\u3867\ua604\u2dc8\uab60\u1120\u98c6\u06cb\u8c29\u0be5\uf197\u7f5b", -617149226, 1630062520) + i + a.b("\u166f", -1154214317) + itemStack);
        }
    }

    private static void fhw(MinecraftClient minecraftClient, String string) {
        ServerPlayerEntity serverPlayerEntity = fgv.fhq(minecraftClient);
        int n = serverPlayerEntity.getEntityWorld().getEntitiesByClass(ItemEntity.class, serverPlayerEntity.getBoundingBox().expand(16.0), itemEntity -> true).size();
        fgv.fhy(string, n == 0, a.d("\u8224\ufb83\u714d\uef23\u64f4\ue250\u5802\ud1b7\u4fa1\uc50d\u42cf\ub8b6\u367f\uaf80", -339271658, -1234001320) + n);
    }

    private static void fhx(String string) {
        fgz = false;
        System.out.println(a.c(1606876959, "\uff7a\u86dc\u0c14\u926f\u19b0\u9f08\u251e") + string + a.d("\uffa7\u860c\u0c9c\u92e2\u1930\u9f8b\u25d0\uac39\u3228", -74211324, 1227054992) + fhc + a.d("\u6ac9\u132e\u99e2\u0795\u8c41\u0afd\ub0bb\u3957\ua70e\u2dbe\uaa70\u504f", 443072308, -1615735343) + fhd + a.b("\ua689\udf6c\u55b9\ucbdb\u4004\uc6b0\u7cb2", 607954606) + fgy);
        fgv.fhy(string, fhd == 0, a.c(-2062944450, "\uf764\u8eed\u0427\u9a4e\u1184\u971d\u2d6c\ua48a\u3ac8\ub07f\u37ad\ucdc1\u4345\udaa3\u50e8\ud603\u6c55\ue38c\u797b\uff6c\u7691\u0ccd\u8278"));
    }

    private static void fhy(String string, boolean bl, String string2) {
        if (!bl) {
            ++fhf;
            System.out.println(a.b("\ua0f7\ud951\u5399\ucde2\u463d\uc085\u7a93", -1226923886) + string + a.c(552997084, "\u10fa\u692d\ue3f9\u7d80\uf652\u708f") + string2);
        }
    }

    private static kfe fhz(String string, boolean bl) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
        return kfe2;
    }

    private static void fia(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void fib(MinecraftClient minecraftClient) throws Exception {
        if (fhg) {
            return;
        }
        ServerPlayerEntity serverPlayerEntity = fgv.fhq(minecraftClient);
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
        channel.pipeline().addBefore(a.c(462399507, "\ua86d\ud1cd\u5b1c\uc565\u4ebc\uc81c\u7264\ufba2\u65f4\uef4a\u6893\u92ea\u1c34\u8592"), a.b("\u11ac\u6817\ue2c7\u7cae\uf73c\u71e0\ucb8e\u4268\udc2c\u5697\ud14c\u2b34\ua5d9\u3c45\ub601\u30f6\u8ab5\u0579\u9fdc\u198c\u906c", -1747578401), (ChannelHandler)new fgs());
        fhg = true;
    }

    private static void fic(Object object) {
        if (object instanceof PlayerInputC2SPacket) {
            boolean bl;
            PlayerInputC2SPacket playerInputC2SPacket = (PlayerInputC2SPacket)object;
            PlayerInput playerInput = playerInputC2SPacket.input();
            boolean bl2 = bl = playerInput.forward() || playerInput.backward() || playerInput.left() || playerInput.right() || playerInput.jump() || playerInput.sneak();
            if (bl != fha) {
                fgv.fie(bl ? a.b("\u7f9d\u062b\u8ce6\u1292\u9944", -479035407) : a.c(-1505566785, "\udfd2\ua66e\u2cb5\ub2cd"));
            }
            fha = bl;
        } else if (object instanceof ClientCommandC2SPacket) {
            ClientCommandC2SPacket clientCommandC2SPacket = (ClientCommandC2SPacket)object;
            if (clientCommandC2SPacket.getMode() == ClientCommandC2SPacket.Mode.START_SPRINTING) {
                fhb = true;
                fgv.fie(a.c(52130303, "\u718a\u0838\u82e9\u1c83\u9753\u11f8"));
            } else if (clientCommandC2SPacket.getMode() == ClientCommandC2SPacket.Mode.STOP_SPRINTING) {
                fhb = false;
                fgv.fie(a.b("\u872e\ufe98\u7450\uea3e\u61ca\ue758\u5d09\ud4e3\u4abb\uc010", 1910802263));
            }
        } else if (object instanceof UpdateSelectedSlotC2SPacket) {
            UpdateSelectedSlotC2SPacket updateSelectedSlotC2SPacket = (UpdateSelectedSlotC2SPacket)object;
            fgv.fie(a.b("\ue56d\u9cca\u1610\u8868\u03b9\u851f", 349693208) + updateSelectedSlotC2SPacket.getSelectedSlot());
        } else if (object instanceof PlayerInteractItemC2SPacket) {
            fgv.fie(a.b("\u45a9\u3c1e\ub6db", 1344947711));
        } else if (object instanceof BundleItemSelectedC2SPacket) {
            BundleItemSelectedC2SPacket bundleItemSelectedC2SPacket = (BundleItemSelectedC2SPacket)object;
            fgv.fie(a.c(-2113610157, "\ude35\ua795\u2d50\ub328") + bundleItemSelectedC2SPacket.slotId() + a.d("\u8ff4", -1129324171, -1543606609) + bundleItemSelectedC2SPacket.selectedItemIndex());
        } else if (object instanceof ClickSlotC2SPacket) {
            ClickSlotC2SPacket clickSlotC2SPacket = (ClickSlotC2SPacket)object;
            ++fhc;
            fgv.fie(a.b("\uc2a7\ubb19\u31cf\uafb4\u246b", 506905313) + clickSlotC2SPacket.slot() + a.d("\ub609", -1575539551, -1214276986) + clickSlotC2SPacket.button() + a.b("\u9a40", -427910546) + clickSlotC2SPacket.actionType());
            fgv.fid();
        } else if (object instanceof CloseHandledScreenC2SPacket) {
            fgv.fie(a.c(-2036118680, "\u4b2e\u3290\ub840\u262d\uadec"));
            fgv.fid();
        }
    }

    private static void fid() {
        if (fgz && (fha || fhb)) {
            ++fhd;
            fgv.fie(a.b("\ub7ce\uce08\u44c4\udab3\u5167\ud7db\u6d9d\ue471\u7a28\uf098", -736905243));
        }
    }

    private static void fie(String string) {
        if (fgz && fgy.length() < 800) {
            fgy.append(' ').append(fhe).append(':').append(string);
        }
    }

    static {
        fhi = 75;
        fhj = 74;
    }

    private static /* synthetic */ int oo(int n, int n2) {
        return n ^ n2 ^ 0x67D18ED4;
    }

    private static /* synthetic */ int op(int n, int n2) {
        return fgv.oo(n, n2) + n;
    }
}

