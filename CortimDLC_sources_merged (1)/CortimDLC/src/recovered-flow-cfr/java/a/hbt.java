/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket$Mode
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket$Action
 *  net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket
 *  net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.server.network.ServerCommonNetworkHandler
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.util.PlayerInput
 *  net.minecraft.util.math.BlockPos
 */
package a;

import a.hbq;
import a.kfe;
import a.krd;
import a.nuo;
import a.vmc;
import a.vmo;
import a.vyn;
import a.vzz;
import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.BlockPos;

final class hbt {
    private static final Set<Integer> hbu = ConcurrentHashMap.newKeySet();
    private static final AtomicInteger hbv = new AtomicInteger();
    private static final AtomicInteger hbw = new AtomicInteger();
    private static final StringBuffer hbx = new StringBuffer();
    private static volatile boolean hby;
    private static volatile boolean hbz;
    private static volatile boolean hca;
    private static volatile boolean hcb;
    private static volatile int hcc;
    private static boolean hcd;
    private static int hce;
    private static boolean hcf;
    private static BlockPos hcg;
    private static int hch;
    private static int hci;
    private static /* synthetic */ long hcj;
    private static /* synthetic */ String hck;

    private hbt() {
    }

    static boolean totem(MinecraftClient minecraftClient, int n) throws Exception {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        hcc = n;
        switch (n) {
            case 1: {
                vzz.simulated = hbu::contains;
                hbt.hcr(minecraftClient, a.c(-1040710225, "\u05e4\u7c61\uf6b3\u68d9\ue332\u65a0\udff1\u561b\uc843\u42e8"), false);
                kfe kfe2 = hbt.hcr(minecraftClient, a.b("\u344e\u4dcb\uc719\u5973\ud29f\u5415\uee5d\u67bd\uf9ea", -1857342458), true);
                for (vmo vmo2 : kfe2.getSettings()) {
                    vmc vmc2;
                    if (!(vmo2 instanceof vmc) || !(vmc2 = (vmc)vmo2).getName().equals(a.d("\u91be\ue82e\u6283\ufc8c\u7756\uf5f4\u4bb0\uc242\u5c17\ud6d8\u5175\uab08\u25a1\ubc13", -193670150, 516834901))) continue;
                    vmc2.set(12.0);
                }
                hbt.hdf(minecraftClient, a.c(-2127470673, "\u5fd9\u266e\uacb1\u32c8\ub917\u3fa4\u85fc\u0c0c\u9216\u18f4\u9f21\u6557\ueb84\u722a\uf866\u7e80\uc4c2"));
                hbt.hdf(minecraftClient, a.b("\ub0d2\uc960\u43b3\uddc1\u5610\ud0b6\u6ab1\ue307\u7d56\uf7f8\u7038\u8a0c\u04bb\u9d39\u1739\u919b\u2bc6\ua402\u3eb0\ub8e6\u3102\u4b46\uc5e8\u5e3f\ud841\u52de\ueb7b\u652c\uffdb\u799a\uf23d\u0cf8\u86e3\u1f14\u9940\u13e1", -1249922925));
                break;
            }
            case 5: {
                hbt.hdg(minecraftClient);
                break;
            }
            case 10: {
                hbt.hdf(minecraftClient, a.c(676132405, "\uf65e\u8fe0\u053a\u9b4f\u108b\u9668\u2c5b\ua599"));
                hbt.hdf(minecraftClient, a.d("\u02ba\u7b16\uf1d4\u6fad\ue437\u62d4\ud890\u5174\ucf37\u458b\uc25a\u382d\ub6bf\u2f4b\ua513\u23f8\u99aa\u1666\u8cd8\u0ad0\u8347\uf925\u77c5\uec43\u6a2e\ue0fb\u5959\ud717\u4de1\ucbf0\u4002\ubeda\u3495\uad6a\u2b30\ua18e\u1e53\u9466\u12e2\u8b4d\u010f\u7fe2\uf5f9\u7205\ue8d6\u66a0\udf78\u55cf\ud391\u4853\uc627\u3ce4\ub51d\u3305\ua9ed\u27bd\u9c0e\u1ad6\u90ad", -254478424, -1942096576));
                hbt.hdf(minecraftClient, a.b("\ue56d\u9cc1\u1603\u887a\u03e0\u8503\u3f47\ub6a3\u28e0\ua25c\u258d\udffa\u5168\uc89c\u42c4\uc42f\u7e7d\uf1b1\u6b0f\ued07\u6490\u1ef2\u9012\u0b8b\u8df3\u0739\ube9c\u30ce\uaa2a\u2c27\ua78a\u594b\ud353\u4abc\uccf2\u465f\uf9c0\u73fc\uf52b\u6c9d\ue6c9\u983e\u127c\u95de\u0f0e\u816d\u38f0\ub21f\u345d\uaf84\u21fb\udb28\u529e\ud4c5\u4e0d\uc070\u7bcb\ufd02\u776c\ueeab", -110041800));
                hbt.hdf(minecraftClient, a.d("\u0cc1\u756d\uffaf\u61d6\uea4c\u6caf\ud6eb\u5f0f\uc14c\u4bf0\ucc21\u3656\ub8c4\u2130\uab68\u2d83\u97d1\u181d\u82a3\u04ab\u8d3c\uf75e\u79be\ue226\u645e\uee97\u5737\ud96d\u4380\uc5ca\u4e64\ub0be\u3aa6\ua34c\u250a\uafec\u1025\u9a49\u1c86\u857f\u0f6d\u7198\ufbcc\u7c76\ue6a7\u68c7\ud107\u5bb1\uddec\u4673\uc84e\u3284\ubb28\u3d68\ua793\u29f0\u927f\u14a7\u9eed\u0716\u89ba\uf3e1\u740f\ufe4e\u6086\ue93e\u5351\ud596\u5fc5\uc073\u4aab\uccdc\u3512\ubfb0\u21e4\uaa07\u2c1e\u96f0\u1f28\u8154\u0b90\u8dc8\uf674\u78bf\ue2d1\u6b08\uedb0\u57fb\ud82f\u4246\uc4fe\u4d2a\ub75a\u3991\ua209\u2468\uaebe\u10dc\u9918\u03a9\u85e5\u0e19\u704b\ufaa2\u6334\ue543\u6f97\ud036\u5a59", -189808974, -789073289));
                hbt.hdf(minecraftClient, a.d("\ub0db\uc977\u43b5\uddcc\u5656\ud0b5\u6af1\ue315\u7d56\uf7ea\u703b\u8a4c\u04de\u9d2a\u1772\u9199\u2bcb\ua407\u3eb9\ub8b1\u3126\u4b44\uc5a4\u5e3c\ud844\u528d\ueb2d\u6577\uff9a\u79d0\uf27e\u0ca4\u86bc\u1f55\u9910\u13f6\uac3f\u2653\ua09c\u3965\ub377\ucd82\u47d6\uc06c\u5abd\ud4dd\u6d1d\ue7ab\u61f6\ufa69\u7454\u8e9e\u0732\u8172\u1b89\u95ea\u2e65\ua8bd\u22f7\ubb0c\u35a0\u4ffb\uc815\u4254\udc9c\u5524", -2051599371, 1583850245));
                hbt.hdf(minecraftClient, a.c(-397640895, "\u7b6a\u02c6\u8804\u167d\u9de7\u1b04\ua140\u28a4\ub6e7\u3c5b\ubb8a\u41fd\ucf6f\u569b\udcc3\u5a28\ue07a\u6fb6\uf508\u7300\ufa97\u80f5\u0e15\u958d\u13f5\u993c\u209c\uaec6\u342b\ub261\u39cf\uc715\u4d0d\ud4e5\u52a1\ud847\u678e\uede2\u6b2d\uf2d4\u78c6\u0633\u8c67\u0bdd\u910c\u1f6c\ua6ac\u2c1a\uaa47\u31d8\ubfe5\u452f\ucc83\u4ac3\ud038\u5e5b\ue5d4\u630c\ue946\u70bd\ufe11\u844a\u03a4\u89e5\u172d\u9e95"));
                clientPlayerEntity.method_31548().method_61496(0);
                hbt.hcs(minecraftClient, 20.0f);
                break;
            }
            case 20: {
                hbt.hco(minecraftClient, true, true);
                break;
            }
            case 35: {
                hbt.hde();
                hbt.hcs(minecraftClient, 5.0f);
                break;
            }
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: {
                hbt.hcz(minecraftClient, a.d("\u705c", 1942573851, 182657799), n);
                break;
            }
            case 50: {
                hbt.hdb(a.b("\u8eae", -1571189010), hbt.hcu(minecraftClient).method_31574(Items.field_8288) && !hbt.hcu(minecraftClient).method_7958(), a.b("\u5eec\u2754\uad87\u33f8\ub826\u3e98\u84c1\u0d69", -361472373) + hbt.hcy(hbt.hcu(minecraftClient)));
                hbt.hdb(a.b("\u64b6", 46818550), hbt.hcv(minecraftClient, 15).method_31574(Items.field_8255), a.b("\uf4ce\u8d60\u07b0\u99da\u1248\u94fd\u2ea6", -421595974) + hbt.hcy(hbt.hcv(minecraftClient, 15)));
                hbt.hdc(a.d("\u787a", 1264791601, 1761101835));
                break;
            }
            case 55: {
                hbt.hde();
                hbt.hcs(minecraftClient, 20.0f);
                break;
            }
            case 56: 
            case 57: 
            case 58: 
            case 59: {
                hbt.hcz(minecraftClient, a.c(-721231674, "\ue085"), n);
                break;
            }
            case 70: {
                hbt.hdb(a.b("\u5bbb", 1831164920), hbt.hcu(minecraftClient).method_31574(Items.field_8255), a.d("\uab18\ud2a0\u5873\uc60c\u4dd2\ucb6c\u7135\uf89d", 1039122175, 197924224) + hbt.hcy(hbt.hcu(minecraftClient)));
                hbt.hdb(a.b("\u1741", -771549438), hbt.hcv(minecraftClient, 15).method_31574(Items.field_8288), a.d("\u2537\u5c99\ud649\u4823\uc3b1\u4504\uff5f", -786174657, -1615017860) + hbt.hcy(hbt.hcv(minecraftClient, 15)));
                hbt.hdc(a.d("\u23e3", -1657563059, 1034140653));
                break;
            }
            case 75: {
                hbt.hde();
                hbt.hcs(minecraftClient, 5.0f);
                break;
            }
            case 90: {
                hbt.hdf(minecraftClient, a.d("\uac95\ud521\u5ffe\uc183\u4a52\ucce1\u76f7\uff66\u610a\uebe8\u6c2f\u965a\u189d\u8161\u0b36\u8dc0\u3784\ub853\u22f1\ua4b3\u2d43\u5700\ud9fd\u4271\uc40c\u4ed6\uf76e\u7928\ue3c4\u659f", 718072311, -374717160));
                break;
            }
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: {
                hbt.hcz(minecraftClient, a.d("\u4534", 1751377408, 55223158), n);
                break;
            }
            case 105: {
                hbt.hdb(a.d("\uf318", -1466843589, 732056929), minecraftClient.field_1724.method_5805() && hbt.hct(minecraftClient).method_5805(), a.b("\uf83a\u818a\u0b5d\u9529", 1630402650));
                hbt.hdb(a.d("\ube6d", 1275066045, 853100690), hbt.hcu(minecraftClient).method_31574(Items.field_8288), a.d("\u34aa\u4d12\uc7c1\u59be\ud260\u54de\uee87\u672f", 218480637, 1598524208) + hbt.hcy(hbt.hcu(minecraftClient)));
                hbt.hdb(a.b("\u4b8e", 1068649420), hbt.hcv(minecraftClient, 16).method_7960(), a.d("\u2afc\u5352\ud982\u47e8\ucc7a\u4acc\uf094", -964062088, -64307472) + hbt.hcy(hbt.hcv(minecraftClient, 16)));
                hbt.hdb(a.d("\u9708", -319383903, -746061333), hbt.hcv(minecraftClient, 15).method_31574(Items.field_8255), a.c(-282030906, "\u8cb2\uf51c\u7fcc\ue1a6\u6a34\uec81\u56da") + hbt.hcy(hbt.hcv(minecraftClient, 15)));
                hbt.hdc(a.b("\ub15b", 478523673));
                break;
            }
            case 110: {
                hbt.hde();
                hbt.hdf(minecraftClient, a.b("\u8494\ufd26\u77f5\ue987\u6256\ue4f0\u5ef7\ud745\u4915\uc3ad\u447a\ube18\u309d\ua94c\u232c\ua58e\u1f8c\u9059\u0aed\u8cb7\u0546\u7f06\uf1a6\u6a70\uec1d\u6682\udf6a\u5138\ucbde\u4d93\uc63d\u38ee\ub2a5\u2b49\uad1c\u27ac", -102923051));
                hbt.hdf(minecraftClient, a.d("\u774a\u0ef8\u842b\u1a59\u9188\u172e\uad29\u249b\ubacb\u3073\ub7a4\u4dc6\uc343\u5a92\ud0f2\u5650\uec52\u6387\uf933\u7f69\uf698\u8cd8\u0278\u99ae\u1fc3\u955c\u2ca7\ua2e1\u3814\ube47\u35ff\ucb25\u417d\ud89f\u5ed9\ud475\u6ba4\ue1d4", -1226071521, 349361430));
                hbt.hcs(minecraftClient, 20.0f);
                break;
            }
            case 125: {
                hbt.hdb(a.c(607994011, "\u40de"), hbt.hcu(minecraftClient).method_31574(Items.field_8255), a.b("\ub4fe\ucd46\u4795\ud9ea\u5234\ud48a\u6ed3\ue77b", -651840359) + hbt.hcy(hbt.hcu(minecraftClient)));
                hbt.hdb(a.d("\u3e94", 2038519779, 1064790322), hbt.hcv(minecraftClient, 15).method_31574(Items.field_8288), a.c(1306167922, "\u8a06\uf3a8\u7978\ue712\u6c80\uea35\u506e") + hbt.hcy(hbt.hcv(minecraftClient, 15)));
                hbt.hdc(a.d("\uca7c", 1814975009, 325228568));
                break;
            }
            case 130: {
                hbt.hco(minecraftClient, false, false);
                hbt.hcp(minecraftClient, true);
                break;
            }
            case 140: {
                hbt.hde();
                hbt.hcs(minecraftClient, 5.0f);
                break;
            }
            case 141: 
            case 142: 
            case 143: 
            case 144: {
                hbt.hcz(minecraftClient, a.c(70459413, "\u2051"), n);
                break;
            }
            case 155: {
                hbt.hdb(a.c(-396979589, "\u923f"), hbt.hcu(minecraftClient).method_31574(Items.field_8288), a.b("\u14c3\u6d7b\ue7a8\u79d7\uf209\u74b7\uceee\u4746", 431559844) + hbt.hcy(hbt.hcu(minecraftClient)));
                hbt.hdb(a.b("\u5e5a", 1169645086), minecraftClient.field_1690.field_1832.method_1434(), a.b("\u8fb7\uf61b\u7cc3\ue2b6\u696b\uef91\u558c\udc7c\u4238\uc8dd\u4f5c\ub53a\u3bfb\ua24d\u2805\uaee9\u14b1\u9b61", 1128107990));
                hbt.hdc(a.c(1984102125, "\ufea9"));
                hbt.hcp(minecraftClient, false);
                break;
            }
            case 160: {
                vzz.simulated = null;
                hbu.clear();
                System.out.println(a.c(1772691842, "\u21fd\u5857\ud29f\u4cff\uc720\u41dc\ufbdb\u723b\uec72\u66c4\ue143") + (hce == 0 ? a.b("\u5437\u2d97\ua756\u3927", 1358320739) : a.b("\udbb2\ua204\u28df\ub6ab\u3d10\ubba9", 915790834) + hce + a.b("\u3fee", -1729282106)));
                return true;
            }
        }
        if (n > 20 && n < 130) {
            minecraftClient.field_1690.field_1894.method_23481(true);
        }
        return false;
    }

    static boolean tool(MinecraftClient minecraftClient, int n) throws Exception {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        hcc = n;
        hbt.hcq(minecraftClient);
        switch (n) {
            case 1: {
                vzz.simulated = hbu::contains;
                hbt.hcr(minecraftClient, a.c(-1117831209, "\u3f9c\u4619\ucccb\u52a1\ud94a\u5fd8\ue589\u6c63\uf23b\u7890"), false);
                hbt.hcr(minecraftClient, a.b("\uf36e\u8af91\u9e4e\u1599\u932a\u296e\ua0af\u3edd\ub477", -6163664), false);
                hbt.hcr(minecraftClient, a.b("\u7335\u0ab0\u8062\u1e08\u95e4\u136e\ua93d\u20cf", -1750043780), true);
                hbt.hdf(minecraftClient, a.b("\u9d9d\ue42a\u6ef5\uf08c\u7b53\ufde0\u47b8\uce48\u5052\udab0\u5d65\ua713\u29c0\ub06e\u3a22\ubcc4\u0686", -1393975829));
                hbt.hdf(minecraftClient, a.b("\u397f\u40cd\uca1e\u546c\udfbd\u591b\ue31c\u6aaa\uf4fb\u7e55\uf995\u03a1\u8d16\u1494\u9e94\u1836\ua26b\u2daf\ub71d\u314b\ub8af\uc2eb\u4c45\ud792\u51ec\udb73\u62d6\uec81\u7676\uf037\u7b90\u8555\u0f4e\u96b9\u10ed\u9a4c", 979515710));
                hbt.hdf(minecraftClient, a.d("\u0a43\u73f1\uf922\u6750\uec81\u6a27\ud020\u5996\uc7c7\u4d69\ucaa9\u309d\ube2a\u27a8\uada8\u2b0b\u9153\u1e94\u843d\u0276\u8b86\uf1c2\u7f7e\ue4a2\u62db\ue84f\u51ea\udfbd\u454a\uc30b\u48ac\ub669\u3c72\ua585\u23d1\ua970", 1050499387, -1954393287));
                break;
            }
            case 5: {
                hbt.hdg(minecraftClient);
                break;
            }
            case 10: {
                hbt.hdf(minecraftClient, a.c(576967680, "\ud46b\uadd5\u270f\ub97a\u32be\ub45d\u0e6e\u87ac"));
                hbt.hdf(minecraftClient, a.c(426628741, "\ud6d0\uaf7c\u25be\ubbc7\u305d\ub6be\u0cfa\u851e\u1b5d\u91e1\u1630\uec47\u62d5\ufb21\u7179\uf792\u4dc0\uc20c\u58b2\udeba\u572d\u2d4f\ua3af\u3836\ube4e\u3484\u8d21\u0373\u9997\u1f9a\u9437\u6af6\ue0ee\u7901\uff4f\u75e2\uca7d\u4041\uc696\u5f20\ud574\uab83\u21c1\ua663\u3cb3\ub2d0\u0b4d\u81a2\u07e0\u9c39\u1246\ue895\u6123\ue778\u7db0\uf3cd\u4876\ucebf\u44d1\udd16"));
                hbt.hdf(minecraftClient, a.c(285580329, "\u9c7a\ue5d6\u6f14\uf16d\u7af7\ufc14\u4650\ucfb4\u51f7\udb4b\u5c9a\ua6ed\u287f\ub18b\u3bd3\ubd38\u076a\u88a6\u1218\u9410\u1d87\u67e5\ue905\u729c\uf4e4\u7e2e\uc78b\u49d9\ud33d\u5530\ude99\u205c\uaa44\u33ab\ub5e5\u3f48\u80d7\u0aeb\u8c3c\u158a\u9fde\ue129\u6b6b\uecc9\u7619\uf87a\u41e7\ucb08\u4d4a\ud693\u58ec\ua23f\u2b89\uadd2\u371a\ub975\u02d3\u841f"));
                hbt.hdf(minecraftClient, a.b("\u8b80\uf22c\u78ee\ue697\u6d0d\uebee\u51aa\ud84e\u460d\uccb1\u4b60\ub117\u3f85\ua671\u2c29\uaac2\u1090\u9f5c\u05e2\u83ea\u0a7d\u701f\ufeff\u6567\ue31f\u69d6\ud076\u5e2c\uc4c1\u428b\uc925\u37ff\ubde7\u2409\ua24b\u28ad\u9764\u1d08\u9bc7\u023e\u882c\uf6d9\u7c8d\ufb37\u61e6\uef86\u5646\udcf0\u5aad\uc132\u4f1f\ub5c3\u3c7c\uba21\u20d0\uae80\u1535\u93df\u1983\u804b\u0ef6\u74af\uf356\u791e\ue7cc", -1066300504));
                hbt.hdf(minecraftClient, a.c(419860496, "\u9039\ue995\u6357\ufd2e\u76b4\uf057\u4a13\uc3f7\u5db4\ud708\u50d9\uaaae\u243c\ubdc8\u3790\ub17b\u0b29\u84e5\u1e5b\u9853\u11c4\u6ba6\ue546\u7ede\uf8a6\u726f\ucbcf\u4595\udf78\u5932\ud29c\u2c46\ua65e\u3fb3\ub9f2\u3314\u8cdd\u06b1\u807e\u1987\u9395\ued60\u6734\ue08e\u7a5f\uf43f\u4dff\uc749\u4114\uda8b\u54a6\uae7a\u27c5\ua198\u3b69\ub539\u0e8c\u8866\u0239\u9bf3\u1543\u6f0b\ue8eb\u62b3"));
                clientPlayerEntity.method_31548().method_61496(0);
                BlockPos blockPos = clientPlayerEntity.method_24515();
                hbt.hdf(minecraftClient, a.d("\u7d3f\u048a\u8e09\u1018\u9bfc\u1d1e", -944704064, -702642035) + ((double)blockPos.method_10263() + 0.5) + a.c(-320636272, "\u7ab1") + blockPos.method_10264() + a.d("\u5bd7", 62482547, 68694917) + ((double)blockPos.method_10260() + 0.5) + a.c(889561278, "\ua09a\ud93b\u53f8\ucd99"));
                hcg = blockPos.method_10069(0, 1, 2);
                hbt.hdf(minecraftClient, a.b("\u5e9f\u2721\uadf7\u3386\ub81d", -191078660) + (hcg.method_10263() - 1) + a.b("\u3a47", 1784422) + (hcg.method_10264() - 1) + a.c(-1821074457, "\u9bc6") + hcg.method_10260() + a.b("\u9fb0", 1857134481) + (hcg.method_10263() + 1) + a.c(-1665400354, "\u01ff") + (hcg.method_10264() + 2) + a.b("\uacab", 1502653578) + (hcg.method_10260() + 1) + a.b("\u59e3\u201f\uaac8\u34be\ubf62\u39d5\u8397\u0a75\u942d\u1e8e\u9913\u6339\uede6\u744c", -1544005171));
                break;
            }
            case 15: {
                hbt.hcl(minecraftClient, a.b("\u88a5\uf110\u7bc4\ue5be\u6e6f\ue8cf\u528f\udb79\u4534\ucfcb\u4851\ub227\u3ceb\ua55b\u2f03", -1199667001));
                break;
            }
            case 25: {
                hbt.hde();
                hbt.hcn(clientPlayerEntity);
                hbt.hcm(minecraftClient, true, n);
                break;
            }
            case 26: 
            case 27: 
            case 28: 
            case 29: {
                hbt.hcz(minecraftClient, a.d("\ufc09", 761578864, 48707897), n);
                break;
            }
            case 50: {
                hbt.hdb(a.d("\u2a2e", -1502327000, 706897222), hch > 0 && hch - hci <= 12, a.d("\u6043\u19f5\u933d\u0d4d\u8691e\uba74\u3395\uadd7\u2762\ua0bf\u5a8b\ud41d\u4dab\uc7ea\u410a\ufb52\u74d1", 727021702, -1986062172) + (hch - hci));
                hbt.hcm(minecraftClient, false, n);
                break;
            }
            case 70: {
                hbt.hdb(a.c(608030638, "\ucfee"), hbt.hcw(minecraftClient).method_31574(Items.field_8802) && hbt.hcx(minecraftClient) == 0, a.c(587762196, "\u8a79\uf3c1\u791d\ue766\u6ce8") + hbt.hcy(hbt.hcw(minecraftClient)) + a.c(-220529706, "\ufbf0\u8212\u08de\u96ac\u1d60\u9b98") + hbt.hcx(minecraftClient));
                hbt.hdb(a.b("\ubaf2", 1549122226), hbt.hcv(minecraftClient, 10).method_31574(Items.field_8377), a.b("\u6185\u182b\u92fb\u0c91\u8703\u01b3\ubbed", 521495025) + hbt.hcy(hbt.hcv(minecraftClient, 10)));
                hbt.hdb(a.d("\ua54e", 1496227005, -682280525), !nuo.busy(), a.d("\ubb51\uc2e7\u4829\ud65d\u5d8a\udb77\u6166\ue880\u76d9\ufc62", 1342529673, 1120787361));
                hbt.hdc(a.d("\ua4b7", -182078014, -1851715275));
                break;
            }
            case 75: {
                hbt.hcl(minecraftClient, a.c(364536828, "\u639f\u1a2a\u90fe\u0e84\u8555\u03f5\ub9b5\u3043\uae0e\u24f1\ua37c\u5900\ud7cc\u4e7b"));
                break;
            }
            case 80: {
                hbt.hco(minecraftClient, true, true);
                break;
            }
            case 90: {
                hbt.hde();
                hbt.hcn(clientPlayerEntity);
                hbt.hcm(minecraftClient, true, n);
                break;
            }
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: {
                hbt.hcz(minecraftClient, a.b("\u56ee", -549693779), n);
                break;
            }
            case 110: {
                hbt.hdb(a.d("\u1b10", -1917094131, -496604066), hch > 0 && hch - hci <= 12, a.d("\u20bf\u5903\ud3cb\u4dbc\uc63f\u40cc\ufa8f\u7363\ued38\u6787\ue011\u1a21\u94f1\u0d52\u8710\u01f6\ubbeb", 971893736, -783103198) + (hch - hci));
                hbt.hcm(minecraftClient, false, n);
                hbt.hco(minecraftClient, false, false);
                break;
            }
            case 130: {
                hbt.hdb(a.b("\u094f", -1710749428), hbt.hcw(minecraftClient).method_31574(Items.field_8802) && hbt.hcx(minecraftClient) == 0, a.b("\u1695\u6f2d\ue5f1\u7b8a\uf004", -1877534984) + hbt.hcy(hbt.hcw(minecraftClient)) + a.d("\u3037\u49d5\uc319\u5d6b\ud6a7\u505f", 1333834835, 697795650) + hbt.hcx(minecraftClient));
                hbt.hdb(a.b("\ua314", -1018846377), hbt.hcv(minecraftClient, 11).method_31574(Items.field_8250), a.d("\u59d6\u2078\uaaa8\u34c2\ubf50\u39e1\u83be", 1089220075, 1928754249) + hbt.hcy(hbt.hcv(minecraftClient, 11)));
                hbt.hdc(a.c(-1380291182, "\u6dd1"));
                break;
            }
            case 131: {
                BlockPos blockPos = hcg.method_10069(0, -1, -2);
                hbt.hdf(minecraftClient, a.c(262612842, "\u2718\u5ead\ud42e\u4a3f\uc1db\u4739") + ((double)blockPos.method_10263() + 0.5) + a.c(285118072, "\u8e59") + blockPos.method_10264() + a.b("\u5f04", -434413787) + ((double)blockPos.method_10260() + 0.5) + a.b("\uccdb\ub57a\u3fb9\ua1d8", -540881665));
                break;
            }
            case 135: {
                hbt.hcl(minecraftClient, a.b("\u12e9\u6b5c\ue188\u7ff2\uf423\u7283\uc8c3\u4135\udf78\u5587\ud201\u287e\ua6a3\u3f26\ub546\u33b4\u89f3", 112595605));
                break;
            }
            case 145: {
                hbt.hde();
                hbt.hcn(clientPlayerEntity);
                hbt.hcm(minecraftClient, true, n);
                break;
            }
            case 146: 
            case 147: {
                hbt.hcz(minecraftClient, a.b("\ub3c2", 1440789376), n);
                break;
            }
            case 170: {
                hbt.hdb(a.d("\u1193", -949092281, -867429994), hch > 0 && hch - hci <= 20, a.b("\uc119\ub8ab\u3270\uac46\u27d3\ua172\u1b3c\u92c9\u0c98\u866c\u01fe\ufb88\u754d\ueced\u66a9\ue00a", -1650146971) + (hch - hci));
                hbt.hcm(minecraftClient, false, n);
                break;
            }
            case 185: {
                hbt.hdb(a.b("\udab7", -1386358027), hbt.hcx(minecraftClient) == 0 && hbt.hcw(minecraftClient).method_31574(Items.field_8802), a.d("\u20d7\u596f\ud3b3\u4dc8\uc646", 429074013, -1683749145) + hbt.hcy(hbt.hcw(minecraftClient)) + a.b("\u5a47\u23a5\ua969\u371b\ubcd7\u3a2f", 1676565089) + hbt.hcx(minecraftClient));
                hbt.hdd(a.b("\u2021", -782032797), false);
                break;
            }
            case 188: {
                hbt.hcp(minecraftClient, true);
                break;
            }
            case 190: {
                hbt.hcl(minecraftClient, a.d("\u9242\uebf7\u6123\uff59\u7488\uf228\u4868\uc19e\u5fd3\ud52c\u52b6\ua8c0\u260c\ubfbc\u35e4", -608749091, 491170813));
                break;
            }
            case 195: {
                hbt.hde();
                hbt.hcn(clientPlayerEntity);
                hbt.hcm(minecraftClient, true, n);
                break;
            }
            case 196: 
            case 197: 
            case 198: 
            case 199: {
                hbt.hcz(minecraftClient, a.b("\u3bc5", -705152128), n);
                break;
            }
            case 215: {
                hbt.hdb(a.b("\ua90a", 1511893327), hch > 0 && hch - hci <= 14, a.d("\udd91\ua427\u2eef\ub09f\u3b43\ubdb7\u07a6\u8e47\u1005\u9ab0\u1d6d\ue759\u69cf\uf079\u7a38\ufcd8\u4680\uc903", -2115298988, 1902757028) + (hch - hci));
                hbt.hcm(minecraftClient, false, n);
                break;
            }
            case 216: 
            case 218: 
            case 220: 
            case 221: 
            case 222: 
            case 223: 
            case 224: {
                hbt.hcz(minecraftClient, a.b("\u117c", 86118713), n);
                break;
            }
            case 232: {
                hbt.hdb(a.b("\uaeb7", -656429326), hbt.hcw(minecraftClient).method_31574(Items.field_8802) && hbt.hcv(minecraftClient, 10).method_31574(Items.field_8377), a.b("\u29f2\u504a\uda96\u44ed\ucf63", 1978673567) + hbt.hcy(hbt.hcw(minecraftClient)) + a.d("\u56ae\u2f4c\ua580\u3bf2\ub03e\u36ca\u8c98\u0564", 516086856, 382372558) + hbt.hcy(hbt.hcv(minecraftClient, 10)));
                hbt.hdb(a.c(1876634645, "\u2c50"), minecraftClient.field_1690.field_1832.method_1434(), a.d("\ub809\uc1a5\u4b7d\ud508\u5ed5\ud82f\u6232\uebc2\u7586\uff63\u78e2\u8284\u0c45\u95f3\u1fbb\u9957\u230f\uacdf", -2111747915, -134947));
                hbt.hdc(a.d("\uc201", -1523871485, -423799993));
                hbt.hcp(minecraftClient, false);
                break;
            }
            case 240: {
                vzz.simulated = null;
                hbu.clear();
                hcf = false;
                System.out.println(a.c(-1172985409, "\ua9c1\ud06b\u5ab8\uc4ca\u4f51\uc9b4\u73f6\ufa11\u6449\ueeac") + (hce == 0 ? a.d("\uf8ce\u816e\u0baf\u95de", -428148651, 333709519) : a.c(-1918644677, "\uce7b\ub7cd\u3d16\ua362\u28d9\uae60") + hce + a.b("\ua06d", -139550651)));
                return true;
            }
        }
        if (n > 12) {
            hbt.hcn(clientPlayerEntity);
        }
        if (hcf) {
            minecraftClient.field_1690.field_1886.method_23481(true);
            if (hch == 0 && hcg != null && minecraftClient.method_1576().method_30002().method_8320(hcg).method_26215()) {
                hch = n;
            }
        }
        if (hbu.contains(87)) {
            minecraftClient.field_1690.field_1894.method_23481(true);
        }
        return false;
    }

    private static void hcl(MinecraftClient minecraftClient, String string) {
        hbt.hdf(minecraftClient, a.c(734464194, "\u08b8\u711f\ufbdd\u65ba\uee63\u68d1\ud28e\u5b77\uc563") + hcg.method_10263() + a.b("\u870a", 1298237227) + hcg.method_10264() + a.d("\uf949", -1682575794, 622204710) + hcg.method_10260() + a.d("\u1a8e", 1212318067, 1963498460) + string);
    }

    private static void hcm(MinecraftClient minecraftClient, boolean bl, int n) {
        hcf = bl;
        KeyBinding keyBinding = minecraftClient.field_1690.field_1886;
        if (bl) {
            hci = n;
            hch = 0;
            KeyBinding.method_1420((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding));
            keyBinding.method_23481(true);
        } else {
            keyBinding.method_23481(false);
        }
    }

    private static void hcn(ClientPlayerEntity clientPlayerEntity) {
        clientPlayerEntity.method_36456(0.0f);
        clientPlayerEntity.method_36457(0.0f);
    }

    private static void hco(MinecraftClient minecraftClient, boolean bl, boolean bl2) {
        if (bl) {
            hbu.add(87);
            minecraftClient.field_1690.field_1894.method_23481(true);
            if (bl2) {
                hbu.add(341);
                minecraftClient.field_1690.field_1867.method_23481(true);
            }
        } else {
            hbu.remove(87);
            hbu.remove(341);
            minecraftClient.field_1690.field_1894.method_23481(false);
            minecraftClient.field_1690.field_1867.method_23481(false);
        }
    }

    private static void hcp(MinecraftClient minecraftClient, boolean bl) {
        if (bl) {
            hbu.add(340);
        } else {
            hbu.remove(340);
        }
        minecraftClient.field_1690.field_1832.method_23481(bl);
    }

    private static void hcq(MinecraftClient minecraftClient) throws Exception {
        for (Field field : Mouse.class.getDeclaredFields()) {
            if (!field.getName().equals(a.d("\u114d\u68ea\ue23e\u7c4e\uf785\u7129\ucb44\u4296\udcc5\u567c\ud1a1\u2bd1", 1805990665, 1680681515))) continue;
            field.setAccessible(true);
            field.setBoolean(minecraftClient.field_1729, true);
        }
    }

    private static kfe hcr(MinecraftClient minecraftClient, String string, boolean bl) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(string);
        if (kfe2 != null) {
            kfe2.setEnabled(bl);
        }
        return kfe2;
    }

    private static void hcs(MinecraftClient minecraftClient, float f) {
        IntegratedServer integratedServer = minecraftClient.method_1576();
        ServerPlayerEntity serverPlayerEntity = hbt.hct(minecraftClient);
        integratedServer.execute(() -> serverPlayerEntity.method_6033(f));
    }

    private static ServerPlayerEntity hct(MinecraftClient minecraftClient) {
        return minecraftClient.method_1576().method_3760().method_14602(minecraftClient.field_1724.method_5667());
    }

    private static ItemStack hcu(MinecraftClient minecraftClient) {
        return hbt.hct(minecraftClient).method_6079();
    }

    private static ItemStack hcv(MinecraftClient minecraftClient, int n) {
        return hbt.hct(minecraftClient).method_31548().method_5438(n);
    }

    private static ItemStack hcw(MinecraftClient minecraftClient) {
        return hbt.hct(minecraftClient).method_6047();
    }

    private static int hcx(MinecraftClient minecraftClient) {
        return hbt.hct(minecraftClient).method_31548().method_67532();
    }

    private static String hcy(ItemStack itemStack) {
        Item item = itemStack.method_7909();
        return itemStack.method_7960() ? a.d("\u7321\u0a98\u8056\u1e23\u95f9", 1703722534, 773377383) : item + (itemStack.method_7958() ? a.d("\uac99", 899128468, 1416376358) : "");
    }

    private static void hcz(MinecraftClient minecraftClient, String string, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        System.out.println(a.c(1542174098, "\ub5e4\ucc51\u4694\ud8f4\u5373") + string + a.d("\uae16\ud7f3", -1161273423, -204148347) + n + a.b("\ufe90\u873b\u0da0\u93c9\u1853", -352125265) + clientPlayerEntity.method_6032() + a.d("\u6a49\u13b7\u996d\u071c\u8c90", -1613372681, 943229083) + hbt.hcy(clientPlayerEntity.method_6079()) + a.c(707826779, "\u947d\ued84\u675e\uf920\u72fd\uf415") + hbt.hcy(clientPlayerEntity.method_6047()) + a.d("\u2f37\u56d2\udc1a\u4270\uc9b6\u4f0f\uf573\u7cb5\ue2ec\u6857\uefc0", 541188480, 123719324) + krd.busy() + a.b("\ue29d\u9b78\u11b0\u8fc1\u0415\u828a\u38ee\ub119\u2f4c\ua5b9", 295101111) + nuo.busy() + a.b("\u49b1\u3049\uba97\u24ee\uaf30\u29d9", -1300870761) + vyn.serverIdle(clientPlayerEntity) + a.b("\ud1ce\ua839\u22fb\ubc99\u3717", 418238955) + minecraftClient.field_1690.field_1894.method_1434() + a.b("\uc814\ub1e4\u3b22\ua54c\u2ecd", 1764542513) + minecraftClient.field_1690.field_1886.method_1434() + a.d("\ud50d\uacfe\u263d\ub85b\u3388\ub533\u0f62\u8694\u18c2\u9229", 1223729231, -366381720) + minecraftClient.field_1761.method_2923() + a.b("\uc315\ubae5\u303e\uae4b\u25cc", -521616592) + (minecraftClient.field_1765 == null ? a.d("\u177c\u6ed6\ue41c\u7a6d", 1926913607, 930367825) : minecraftClient.field_1765.method_17783()) + a.c(-1756083821, "\u49b0\u305b\ubacf") + String.format(a.c(-2110751949, "\u7b12\u02a8\u8867\u1642"), clientPlayerEntity.method_23321()) + a.b("\u2004\u59f6\ud322\u4d0a", -1143463904) + hbt.hda(minecraftClient, a.b("\uae52\ud7f6\u5d25\uc341\u4894\uce2d\u7456\ufd8b\u63d4\ue966\u6ebd\u94c7\u1a08\u83a0", -912544195)) + a.d("\ue05d\u99a0\u1370\u8d0d\u06d2\u806d\u3a3f\ub397", -214994533, 372937198) + minecraftClient.field_1729.method_1613());
    }

    private static String hda(Object object, String string) {
        try {
            Field field = object.getClass().getDeclaredField(string);
            field.setAccessible(true);
            return String.valueOf(field.get(object));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            return a.c(-1284934122, "\u7628");
        }
    }

    private static void hdb(String string, boolean bl, String string2) {
        if (!bl) {
            ++hce;
            System.out.println(a.b("\u5084\u2931\ua3f4\u3d94\ub613", 1668829426) + string + a.c(-1185889547, "\uc2d3\ubb04\u31d0\uafa9\u247b\ua2a6") + string2);
        }
    }

    private static void hdc(String string) {
        hbt.hdd(string, true);
    }

    private static void hdd(String string, boolean bl) {
        hcb = false;
        System.out.println(a.c(-1935485745, "\ud4b9\uad0c\u27c9\ub9a9\u322e") + string + a.d("\u2216\u5bbd\ud12d\u4f53\uc481\u423a\uf861\u7188\uef99", -496649406, -1710450329) + hbv.get() + a.d("\ub921\uc0c6\u4a0a\ud47d\u5fa9\ud915\u6353\ueabf\u74e6\ufe56\u7998\u83a7", 1369449910, -107963205) + hbw.get() + a.b("\u6865\u1180\u9b55\u0537\u8ee8\u085c\ub25e", -860657598) + hbx);
        if (bl == (hbv.get() == 0)) {
            ++hce;
            System.out.println(a.b("\u62d4\u1b61\u91a4\u0fc4\u8443", -1477614942) + string + a.d("\u28e3\u5134\udbe0\u4599\uce4b\u4896\uf286\u7b78\ue522\u6f99\ue842\u122b\u9cb2", -1618384527, -1442823745) + hbv.get() + a.b("\u5494\u2d60\ua7ae\u39d7\ub215\u34a2\u8ee6\u0706\u9958\u13ad", 649221310) + (bl ? a.d("\u02f8\u7b47", 1645121513, -203518675) : a.b("\uc2da", 1210630891)));
        }
        if (hbw.get() != 0) {
            ++hce;
            System.out.println(a.c(564617127, "\u5fd1\u2664\uaca1\u32c1\ub946") + string + a.d("\u37e3\u4e34\uc4e0\u5a99\ud14b\u5796\ueda8\u6461\ufa27\u708e\uf740\u0d19\u83ec\u1a4a\u9004\u16f3\uacbd\u2371\ub991\u3f97\ub678\ucc33\u4299\ud940\u5f7b\ud5ec\u6c55\ue209\u78f8", -263467608, -123274634));
        }
    }

    private static void hde() {
        hbv.set(0);
        hbw.set(0);
        hbx.setLength(0);
        hcb = true;
    }

    private static void hdf(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void hdg(MinecraftClient minecraftClient) throws Exception {
        if (hcd) {
            return;
        }
        ServerPlayerEntity serverPlayerEntity = hbt.hct(minecraftClient);
        ClientConnection clientConnection = null;
        for (Field field : ServerCommonNetworkHandler.class.getDeclaredFields()) {
            if (field.getType() != ClientConnection.class) continue;
            field.setAccessible(true);
            clientConnection = (ClientConnection)field.get(serverPlayerEntity.field_13987);
        }
        Channel channel = null;
        for (Field field : ClientConnection.class.getDeclaredFields()) {
            if (!Channel.class.isAssignableFrom(field.getType())) continue;
            field.setAccessible(true);
            channel = (Channel)field.get(clientConnection);
        }
        channel.pipeline().addBefore(a.d("\u2f3a\u569a\udc4b\u4232\uc9eb\u4f4b\uf533\u7cf5\ue2a3\u681d\uefc4\u15bd\u9b63\u02c5", 775179838, -1496358534), a.c(787934943, "\ueeaa\u9711\u1dc1\u83a8\u083a\u8ee6\u3499\ubd6c\u2325\ua985\u2e79\ud425\u5ae5\uc352\u490d\ucfe1\u75b8\ufa68\u60cc"), (ChannelHandler)new hbq());
        hcd = true;
    }

    private static void hdh(Object object) {
        if (object instanceof PlayerInputC2SPacket) {
            boolean bl;
            PlayerInputC2SPacket playerInputC2SPacket = (PlayerInputC2SPacket)object;
            PlayerInput playerInput = playerInputC2SPacket.comp_3139();
            boolean bl2 = bl = playerInput.comp_3159() || playerInput.comp_3160() || playerInput.comp_3161() || playerInput.comp_3162() || playerInput.comp_3163();
            if (hcb && (bl != hby || playerInput.comp_3164() != hbz)) {
                hbt.hdi(bl || playerInput.comp_3164() ? a.c(-974392198, "\uf416\u8da0\u076d\u9919\u12cf") : a.b("\u279a\u5e26\ud4fd\u4a85", -1410062345));
            }
            hby = bl;
            hbz = playerInput.comp_3164();
        } else if (object instanceof ClientCommandC2SPacket) {
            ClientCommandC2SPacket clientCommandC2SPacket = (ClientCommandC2SPacket)object;
            if (clientCommandC2SPacket.method_12365() == ClientCommandC2SPacket.Mode.field_12981) {
                hca = true;
                hbt.hdi(a.c(976424471, "\u0e62\u77d0\ufd01\u636b\ue8bb\u6e10"));
            } else if (clientCommandC2SPacket.method_12365() == ClientCommandC2SPacket.Mode.field_12985) {
                hca = false;
                hbt.hdi(a.b("\ub819\uc1af\u4b67\ud509\u5efd\ud86f\u623e\uebd4\u758c\uff27", -1861961632));
            }
        } else if (object instanceof PlayerActionC2SPacket) {
            PlayerActionC2SPacket playerActionC2SPacket = (PlayerActionC2SPacket)object;
            PlayerActionC2SPacket.Action action = playerActionC2SPacket.method_12363();
            if (action == PlayerActionC2SPacket.Action.field_12968 || action == PlayerActionC2SPacket.Action.field_12971 || action == PlayerActionC2SPacket.Action.field_12973) {
                hbt.hdi(action.name());
            }
        } else if (object instanceof UpdateSelectedSlotC2SPacket) {
            UpdateSelectedSlotC2SPacket updateSelectedSlotC2SPacket = (UpdateSelectedSlotC2SPacket)object;
            hbt.hdi(a.c(1398952013, "\u5038\u299f\ua345\u3d3d\ub6ec\u304a") + updateSelectedSlotC2SPacket.method_12442());
        } else if (object instanceof ClickSlotC2SPacket || object instanceof CloseHandledScreenC2SPacket) {
            boolean bl = object instanceof ClickSlotC2SPacket;
            if (bl) {
                hbv.incrementAndGet();
            }
            hbt.hdi(bl ? a.c(-214246594, "\udb78\ua2c6\u2810\ub66b\u3db4") : a.b("\uf972\u80cc\u0a1c\u9471\u1fb0", -904988364));
            if (hby || hbz || hca) {
                hbw.incrementAndGet();
                hbt.hdi(a.b("\u8397\ufa51\u709d\ueeea\u653e\ue382\u59c4\ud028\u4e71\uc4c1\u4374\ub940\u3795\uae3d\u2471\ua287\u18c1\u974a", -944667740) + hby + a.b("\ue6cf\u9f21\u15ef\u8b95F\u86fd\u3cf8", -221714716) + hbz + a.c(-679008255, "\u2825\u51cb\udb1b\u4568\ucea4\u4812\uf25b\u7be3") + hca + a.c(2003472898, "\u922a"));
            }
        }
    }

    private static void hdi(String string) {
        if (hcb && hbx.length() < 600) {
            hbx.append(' ').append(hcc).append(':').append(string);
        }
    }

    private static /* synthetic */ int yt(int n, int n2) {
        return n * n2 + -917876198;
    }

    private static /* synthetic */ int yu(int n, int n2) {
        return hbt.yt(n, n2) + n;
    }
}

