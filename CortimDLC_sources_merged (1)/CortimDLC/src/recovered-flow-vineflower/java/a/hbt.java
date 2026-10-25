package a;

import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
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
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.BlockPos;

final class hbt {
   static final Set<Integer> hbu = ConcurrentHashMap.newKeySet();
   static final AtomicInteger hbv = new AtomicInteger();
   static final AtomicInteger hbw = new AtomicInteger();
   static final StringBuffer hbx = new StringBuffer();
   static volatile boolean hby;
   static volatile boolean hbz;
   static volatile boolean hca;
   static volatile boolean hcb;
   static volatile int hcc;
   static boolean hcd;
   static int hce;
   static boolean hcf;
   static BlockPos hcg;
   static int hch;
   static int hci;

   hbt() {
   }

   static boolean totem(MinecraftClient var0, int var1) throws Exception {
      ClientPlayerEntity var2 = var0.player;
      hcc = var1;
      switch (var1) {
         case 1:
            vzz.simulated = hbu::contains;
            hcr(var0, a.c(-1040710225, "פ籡\uf6b3棙\ue332斠\udff1嘛졃䋨"), false);
            kfe var3 = hcr(var0, a.b("㑎䷋윙女튟吕\uee5d枽離", -1857342458), true);

            for (vmo var5 : var3.getSettings()) {
               if (var5 instanceof vmc var6 && var6.getName().equals(a.d("醾\ue82e抃ﲌ睖\uf5f4䮰쉂尗훘兵\uab08□밓", -193670150, 516834901))) {
                  var6.set(12.0);
               }
            }

            hdf(var0, a.c(-2127470673, "忙♮겱㋈뤗㾤藼ఌ鈖ᣴ鼡敗\ueb84爪\uf866纀쓂"));
            hdf(var0, a.b("냒쥠䎳\uddc1嘐킶檱\ue307絖\uf7f8瀸訌һ鴹\u1739醛⯆ꐂ㺰룦\u3102䭆엨帿\ud841勞\ueb7b攬ￛ禚\uf23d\u0cf8蛣ἔ饀Ꮱ", -1249922925));
         case 2:
         case 3:
         case 4:
         case 6:
         case 7:
         case 8:
         case 9:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 42:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         case 49:
         case 51:
         case 52:
         case 53:
         case 54:
         case 60:
         case 61:
         case 62:
         case 63:
         case 64:
         case 65:
         case 66:
         case 67:
         case 68:
         case 69:
         case 71:
         case 72:
         case 73:
         case 74:
         case 76:
         case 77:
         case 78:
         case 79:
         case 80:
         case 81:
         case 82:
         case 83:
         case 84:
         case 85:
         case 86:
         case 87:
         case 88:
         case 89:
         case 96:
         case 97:
         case 98:
         case 99:
         case 100:
         case 101:
         case 102:
         case 103:
         case 104:
         case 106:
         case 107:
         case 108:
         case 109:
         case 111:
         case 112:
         case 113:
         case 114:
         case 115:
         case 116:
         case 117:
         case 118:
         case 119:
         case 120:
         case 121:
         case 122:
         case 123:
         case 124:
         case 126:
         case 127:
         case 128:
         case 129:
         case 131:
         case 132:
         case 133:
         case 134:
         case 135:
         case 136:
         case 137:
         case 138:
         case 139:
         case 145:
         case 146:
         case 147:
         case 148:
         case 149:
         case 150:
         case 151:
         case 152:
         case 153:
         case 154:
         case 156:
         case 157:
         case 158:
         case 159:
         default:
            break;
         case 5:
            hdg(var0);
            break;
         case 10:
            hdf(var0, a.c(676132405, "\uf65e迠Ժ魏ႋ陨ⱛꖙ"));
            hdf(var0, a.d("ʺ笖\uf1d4澭\ue437拔\ud890兴켷䖋쉚㠭뚿⽋ꔓ⏸馪ᙦ賘ૐ荇拉矅\uec43樮\ue0fb奙휗䷡쯰䀂뻚㒕굪⬰ꆎṓ鑦ዢ譍ď翢\uf5f9爅\ue8d6暠\udf78嗏펑䡓옧㳤딝㌅ꧭ➽鰎\u1ad6邭", -254478424, -1942096576));
            hdf(var0, a.b("\ue56d鳁ᘃ衺Ϡ蔃㽇뚣⣠ꉜ▍\udffa全좜䋄쐯繽\uf1b1欏\ued07撐Ỳ递\u0b8b跳ܹ뺜ノꨪⰧ꞊奋퍓䪼쳲䙟燎珼\uf52b沝\ue6c9頾ቼ闞༎腭㣰눟㑝꾄⇻\udb28办퓅不쁰篋ﴂ睬\ueeab", -110041800));
            hdf(
               var0,
               a.d(
                  "ು畭ﾯ懖\uea4c沯훫式셌䯰찡㙖룄ℰꭨⶃ韑\u181d芣ҫ贼\uf75e禾\ue226摞\uee97圷\ud96d䎀엊乤낾㪦ꍌ┊꿬ဥ驉ᲆ蕿\u0f6d熘\ufbcc籶\ue6a7棇턇宱\uddec䙳졎㊄묨㵨ꞓ⧰鉿ᒧ黭ܖ覺\uf3e1琏﹎悆\ue93e卑햖必쁳䪫쳜㔒뾰⇤ꨇⰞ雰Ἠ腔ஐ跈\uf674碿\ue2d1欈\uedb0埻\ud82f䉆쓾䴪띚㦑ꈉ⑨꺾ნ餘Ω藥น灋甆挴\ue543澗퀶婙",
                  -189808974,
                  -789073289
               )
            );
            hdf(
               var0,
               a.d(
                  "냛쥷䎵\uddcc噖킵櫱\ue315絖\uf7ea瀻詌Ӟ鴪ᝲ醙⯋ꐇ㺹뢱ㄦ䭄얤帼\ud844劍\ueb2d敷ﾚ秐\uf27eತ蚼ὕ餐\u13f6갿♓ꂜ㥥덷춂䟖쁬媽퓝洝\ue7ab懶響瑔躞ܲ腲ᮉ闪\u2e65ꢽ⋷묌㖠俻정䉔\udc9c唤",
                  -2051599371,
                  1583850245
               )
            );
            hdf(var0, a.c(-397640895, "筪ˆ蠄ᙽ鷧ᬄꅀ⢤뛧㱛뮊䇽콯嚛\udcc3娨\ue07a澶\uf508猀流胵ต閍Ᏽ餼ₜ껆㐫뉡㧏윕䴍퓥务\ud847枎\uede2欭\uf2d4磆س豧\u0bdd鄌ὬꚬⰚꩇ㇘뿥䔯첃䫃퀸幛\ue5d4挌\ue946炽︑葊Τ觥ᜭ麕"));
            var2.getInventory().setSelectedSlot(0);
            hcs(var0, 20.0F);
            break;
         case 20:
            hco(var0, true, true);
            break;
         case 35:
            hde();
            hcs(var0, 5.0F);
            break;
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
            hcz(var0, a.d("灜", 1942573851, 182657799), var1);
            break;
         case 50:
            hdb(a.b("躮", -1571189010), hcu(var0).isOf(Items.TOTEM_OF_UNDYING) && !hcu(var0).hasGlint(), a.b("廬❔궇㏸렦㺘蓁൩", -361472373) + hcy(hcu(var0)));
            hdb(a.b("撶", 46818550), hcv(var0, 15).isOf(Items.SHIELD), a.b("\uf4ce赠ް駚ቈ铽⺦", -421595974) + hcy(hcv(var0, 15)));
            hdc(a.d("硺", 1264791601, 1761101835));
            break;
         case 55:
            hde();
            hcs(var0, 20.0F);
            break;
         case 56:
         case 57:
         case 58:
         case 59:
            hcz(var0, a.c(-721231674, "\ue085"), var1);
            break;
         case 70:
            hdb(a.b("宻", 1831164920), hcu(var0).isOf(Items.SHIELD), a.d("\uab18튠塳옌䷒쭬焵\uf89d", 1039122175, 197924224) + hcy(hcu(var0)));
            hdb(a.b("ᝁ", -771549438), hcv(var0, 15).isOf(Items.TOTEM_OF_UNDYING), a.d("┷岙홉䠣쎱䔄｟", -786174657, -1615017860) + hcy(hcv(var0, 15)));
            hdc(a.d("⏣", -1657563059, 1034140653));
            break;
         case 75:
            hde();
            hcs(var0, 5.0F);
            break;
         case 90:
            hdf(var0, a.d("겕픡忾솃䩒쳡盷ｦ愊\uebe8氯陚ᢝ腡ଶ跀㞄롓⋱꒳ⵃ圀\ud9fd䉱쐌他\uf76e礨\ue3c4斟", 718072311, -374717160));
            break;
         case 91:
         case 92:
         case 93:
         case 94:
         case 95:
            hcz(var0, a.d("䔴", 1751377408, 55223158), var1);
            break;
         case 105:
            hdb(a.d("\uf318", -1466843589, 732056929), var0.player.isAlive() && hct(var0).isAlive(), a.b("\uf83a膊ଢ଼锩", 1630402650));
            hdb(a.d("빭", 1275066045, 853100690), hcu(var0).isOf(Items.TOTEM_OF_UNDYING), a.d("㒪䴒쟁妾퉠哞\uee87术", 218480637, 1598524208) + hcy(hcu(var0)));
            hdb(a.b("䮎", 1068649420), hcv(var0, 16).isEmpty(), a.d("⫼卒\ud982䟨챺䫌\uf094", -964062088, -64307472) + hcy(hcv(var0, 16)));
            hdb(a.d("霈", -319383903, -746061333), hcv(var0, 15).isOf(Items.SHIELD), a.c(-282030906, "貲\uf51c翌\ue1a6樴\uec81囚") + hcy(hcv(var0, 15)));
            hdc(a.b("녛", 478523673));
            break;
         case 110:
            hde();
            hdf(var0, a.b("蒔ﴦ矵\ue987扖\ue4f0廷흅䤕쎭䑺븘ゝꥌ⌬ꖎᾌ遙૭買Ն缆\uf1a6橰\uec1d暂\udf6a儸쯞䶓옽㣮능⭉괜➬", -102923051));
            hdf(var0, a.d("睊\u0ef8萫ᩙ醈ᜮ괩⒛뫋び랤䷆썃媒탲噐\uec52掇盧罩\uf698賘ɸ馮ῃ镜ⲧꋡ㠔빇㗿쬥䅽\ud89f廙푵殤\ue1d4", -1226071521, 349361430));
            hcs(var0, 20.0F);
            break;
         case 125:
            hdb(a.c(607994011, "䃞"), hcu(var0).isOf(Items.SHIELD), a.b("듾쵆䞕\ud9ea刴풊滓\ue77b", -651840359) + hcy(hcu(var0)));
            hdb(a.d("㺔", 2038519779, 1064790322), hcv(var0, 15).isOf(Items.TOTEM_OF_UNDYING), a.c(1306167922, "訆\uf3a8祸\ue712沀\uea35偮") + hcy(hcv(var0, 15)));
            hdc(a.d("쩼", 1814975009, 325228568));
            break;
         case 130:
            hco(var0, false, false);
            hcp(var0, true);
            break;
         case 140:
            hde();
            hcs(var0, 5.0F);
            break;
         case 141:
         case 142:
         case 143:
         case 144:
            hcz(var0, a.c(70459413, "⁑"), var1);
            break;
         case 155:
            hdb(a.c(-396979589, "鈿"), hcu(var0).isOf(Items.TOTEM_OF_UNDYING), a.b("ᓃ浻\ue7a8秗\uf209璷컮䝆", 431559844) + hcy(hcu(var0)));
            hdb(a.b("幚", 1169645086), var0.options.sneakKey.isPressed(), a.b("辷\uf61b糃\ue2b6楫\uef91喌\udc7c䈸죝作딺㯻ꉍ⠅껩ᒱ魡", 1128107990));
            hdc(a.c(1984102125, "ﺩ"));
            hcp(var0, false);
            break;
         case 160:
            vzz.simulated = null;
            hbu.clear();
            System.out
               .println(
                  a.c(1772691842, "⇽塗튟䳿유䇜ﯛ爻\uec72曄\ue143")
                     + (hce == 0 ? a.b("吷\u2d97Ꝗ㤧", 1358320739) : a.b("\udbb2ꈄ⣟뚫㴐뮩", 915790834) + hce + a.b("㿮", -1729282106))
               );
            return true;
      }

      if (var1 > 20 && var1 < 130) {
         var0.options.forwardKey.setPressed(true);
      }

      return false;
   }

   static boolean tool(MinecraftClient var0, int var1) throws Exception {
      ClientPlayerEntity var2 = var0.player;
      hcc = var1;
      hcq(var0);
      switch (var1) {
         case 1:
            vzz.simulated = hbu::contains;
            hcr(var0, a.c(-1117831209, "㾜䘙쳋务\ud94a忘\ue589汣\uf23b碐"), false);
            hcr(var0, a.b("\uf36e諹1鹎ᖙ錪⥮ꂯ㻝둷", -6163664), false);
            hcr(var0, a.b("猵ર聢Ḉ闤፮ꤽ\u20cf", -1750043780), true);
            hdf(var0, a.b("鶝\ue42a滵\uf08c筓\ufde0䞸칈偒\udab0嵥꜓⧀끮㨢별چ", -1393975829));
            hdf(var0, a.b("㥿䃍쨞呬\udfbd夛\ue31c檪\uf4fb繕秊Ρ贖ᒔ麔ᠶꉫ\u2daf뜝ㅋ뢯싫䱅힒凬\udb73拖\uec81癶\uf037箐蕕ཎ隹ჭ驌", 979515710));
            hdf(var0, a.d("\u0a43珱濫材\uec81樧퀠妖쟇䵩쪩ゝ븪➨궨⬋酓Ẕ落ɶ讆\uf1c2罾\ue4a2招\ue84f凪\udfbd䕊쌋䢬뙩㱲ꖅ⏑ꥰ", 1050499387, -1954393287));
         case 2:
         case 3:
         case 4:
         case 6:
         case 7:
         case 8:
         case 9:
         case 11:
         case 12:
         case 13:
         case 14:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 35:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
         case 42:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         case 49:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
         case 58:
         case 59:
         case 60:
         case 61:
         case 62:
         case 63:
         case 64:
         case 65:
         case 66:
         case 67:
         case 68:
         case 69:
         case 71:
         case 72:
         case 73:
         case 74:
         case 76:
         case 77:
         case 78:
         case 79:
         case 81:
         case 82:
         case 83:
         case 84:
         case 85:
         case 86:
         case 87:
         case 88:
         case 89:
         case 101:
         case 102:
         case 103:
         case 104:
         case 105:
         case 106:
         case 107:
         case 108:
         case 109:
         case 111:
         case 112:
         case 113:
         case 114:
         case 115:
         case 116:
         case 117:
         case 118:
         case 119:
         case 120:
         case 121:
         case 122:
         case 123:
         case 124:
         case 125:
         case 126:
         case 127:
         case 128:
         case 129:
         case 132:
         case 133:
         case 134:
         case 136:
         case 137:
         case 138:
         case 139:
         case 140:
         case 141:
         case 142:
         case 143:
         case 144:
         case 148:
         case 149:
         case 150:
         case 151:
         case 152:
         case 153:
         case 154:
         case 155:
         case 156:
         case 157:
         case 158:
         case 159:
         case 160:
         case 161:
         case 162:
         case 163:
         case 164:
         case 165:
         case 166:
         case 167:
         case 168:
         case 169:
         case 171:
         case 172:
         case 173:
         case 174:
         case 175:
         case 176:
         case 177:
         case 178:
         case 179:
         case 180:
         case 181:
         case 182:
         case 183:
         case 184:
         case 186:
         case 187:
         case 189:
         case 191:
         case 192:
         case 193:
         case 194:
         case 200:
         case 201:
         case 202:
         case 203:
         case 204:
         case 205:
         case 206:
         case 207:
         case 208:
         case 209:
         case 210:
         case 211:
         case 212:
         case 213:
         case 214:
         case 217:
         case 219:
         case 225:
         case 226:
         case 227:
         case 228:
         case 229:
         case 230:
         case 231:
         case 233:
         case 234:
         case 235:
         case 236:
         case 237:
         case 238:
         case 239:
         default:
            break;
         case 5:
            hdg(var0);
            break;
         case 10:
            hdf(var0, a.c(576967680, "푫귕✏륺㊾둝\u0e6e螬"));
            hdf(var0, a.c(426628741, "훐꽼▾믇そ뚾\u0cfa蔞᭝釡ᘰ\uec47拕ﬡ煹\uf792䷀숌墲\udeba圭ⵏꎯ㠶빎㒄贡ͳ馗ᾚ鐷櫶\ue0ee礁ｏ痢쩽䁁욖张해ꮃ⇁ꙣ㲳닐୍膢ߠ鰹ቆ\ue895愣\ue778綰\uf3cd䡶캿䓑\udd16"));
            hdf(var0, a.c(285580329, "鱺\ue5d6演\uf16d竷ﰔ䙐쾴凷\udb4b岚ꛭ⡿놋㯓봸ݪ袦መ鐐ᶇ查\ue905犜\uf4e4縮잋䧙팽唰\ude99⁜ꩄ㎫뗥㽈胗૫谼ᖊ鿞\ue129歫\uecc9瘙\uf87a䇧쬈䵊횓壬ꈿ⮉귒㜚륵˓萟"));
            hdf(
               var0,
               a.b(
                  "讀\uf22c磮\ue697洍\uebee冪\ud84e䘍첱䭠넗㾅꙱Ⱙꫂ႐齜ע菪\u0a7d瀟\ufeff敧\ue31f槖큶帬쓁䊋줥㟿뷧␉ꉋ⢭靤ᴈ鯇Ⱦ蠬\uf6d9粍\ufb37懦\uef86噆\udcf0媭섲伟뗃㱼먡⃐꺀ᔵ鏟ᦃ聋\u0ef6璯\uf356礞\ue7cc",
                  -1066300504
               )
            );
            hdf(
               var0,
               a.c(419860496, "逹\ue995捗ﴮ皴\uf057䨓쏷嶴휈僙ꪮ\u243c뷈㞐녻\u0b29蓥ṛ顓ᇄ殦\ue546绞\uf8a6牯쯏䖕\udf78夲튜ⱆꙞ㾳맲㌔賝ڱ聾ᦇ鎕\ued60朴\ue08e穟\uf43f䷿읉䄔\uda8b咦깺⟅ꆘ㭩딹ຌ衦ȹ鯳ᕃ漋\ue8eb抳")
            );
            var2.getInventory().setSelectedSlot(0);
            BlockPos var4 = var2.getBlockPos();
            hdf(
               var0,
               a.d("紿Ҋ踉ဘ鯼ᴞ", -944704064, -702642035)
                  + (var4.getX() + 0.5)
                  + a.c(-320636272, "窱")
                  + var4.getY()
                  + a.d("寗", 62482547, 68694917)
                  + (var4.getZ() + 0.5)
                  + a.c(889561278, "ꂚ\ud93b司춙")
            );
            hcg = var4.add(0, 1, 2);
            hdf(
               var0,
               a.b("废✡귷㎆렝", -191078660)
                  + (hcg.getX() - 1)
                  + a.b("㩇", 1784422)
                  + (hcg.getY() - 1)
                  + a.c(-1821074457, "鯆")
                  + hcg.getZ()
                  + a.b("龰", 1857134481)
                  + (hcg.getX() + 1)
                  + a.c(-1665400354, "ǿ")
                  + (hcg.getY() + 2)
                  + a.b("겫", 1502653578)
                  + (hcg.getZ() + 1)
                  + a.b("姣‟\uaac8㒾뽢㧕莗ੵ鐭Ẏ餓挹\uede6瑌", -1544005171)
            );
            break;
         case 15:
            hcl(var0, a.b("袥\uf110範\ue5be湯\ue8cf劏\udb79䔴쿋䡑눧㳫ꕛ⼃", -1199667001));
            break;
         case 25:
            hde();
            hcn(var2);
            hcm(var0, true, var1);
            break;
         case 26:
         case 27:
         case 28:
         case 29:
            hcz(var0, a.d("ﰉ", 761578864, 48707897), var1);
            break;
         case 50:
            hdb(a.d("⨮", -1502327000, 706897222), hch > 0 && hch - hci <= 12, a.d("恃᧵錽്蚑e면㎕귗❢ꂿ媋퐝䶫쟪䄊ﭒ瓑", 727021702, -1986062172) + (hch - hci));
            hcm(var0, false, var1);
            break;
         case 70:
            hdb(
               a.c(608030638, "쿮"),
               hcw(var0).isOf(Items.DIAMOND_SWORD) && hcx(var0) == 0,
               a.c(587762196, "詹\uf3c1礝\ue766注") + hcy(hcw(var0)) + a.c(-220529706, "ﯰ舒ࣞ隬ᵠ鮘") + hcx(var0)
            );
            hdb(a.b("뫲", 1549122226), hcv(var0, 10).isOf(Items.DIAMOND_PICKAXE), a.b("憅ᠫ鋻\u0c91蜃Ƴ믭", 521495025) + hcy(hcv(var0, 10)));
            hdb(a.d("ꕎ", 1496227005, -682280525), !nuo.busy(), a.d("뭑싧䠩홝嶊\udb77慦\ue880盙ﱢ", 1342529673, 1120787361));
            hdc(a.d("꒷", -182078014, -1851715275));
            break;
         case 75:
            hcl(var0, a.c(364536828, "掟ᨪ郾ຄ蕕ϵ릵ぃ긎⓱ꍼ夀ퟌ乻"));
            break;
         case 80:
            hco(var0, true, true);
            break;
         case 90:
            hde();
            hcn(var2);
            hcm(var0, true, var1);
            break;
         case 91:
         case 92:
         case 93:
         case 94:
         case 95:
         case 96:
         case 97:
         case 98:
         case 99:
         case 100:
            hcz(var0, a.b("囮", -549693779), var1);
            break;
         case 110:
            hdb(a.d("ᬐ", -1917094131, -496604066), hch > 0 && hch - hci <= 12, a.d("₿夃폋䶼옿䃌摒獣\ued38枇\ue011ᨡ铱\u0d52蜐Ƕ믫", 971893736, -783103198) + (hch - hci));
            hcm(var0, false, var1);
            hco(var0, false, false);
            break;
         case 130:
            hdb(
               a.b("ॏ", -1710749428),
               hcw(var0).isOf(Items.DIAMOND_SWORD) && hcx(var0) == 0,
               a.b("ᚕ漭\ue5f1箊\uf004", -1877534984) + hcy(hcw(var0)) + a.d("〷䧕쌙嵫횧偟", 1333834835, 697795650) + hcx(var0)
            );
            hdb(a.b("ꌔ", -1018846377), hcv(var0, 11).isOf(Items.DIAMOND_SHOVEL), a.d("姖⁸ꪨ㓂뽐㧡莾", 1089220075, 1928754249) + hcy(hcv(var0, 11)));
            hdc(a.c(-1380291182, "淑"));
            break;
         case 131:
            BlockPos var3 = hcg.add(0, -1, -2);
            hdf(
               var0,
               a.c(262612842, "✘庭퐮䨿쇛䜹")
                  + (var3.getX() + 0.5)
                  + a.c(285118072, "蹙")
                  + var3.getY()
                  + a.b("弄", -434413787)
                  + (var3.getZ() + 0.5)
                  + a.b("쳛땺㾹ꇘ", -540881665)
            );
            break;
         case 135:
            hcl(var0, a.b("ዩ歜\ue188翲\uf423犃죃䄵\udf78喇툁⡾ꚣ㼦땆㎴觳", 112595605));
            break;
         case 145:
            hde();
            hcn(var2);
            hcm(var0, true, var1);
            break;
         case 146:
         case 147:
            hcz(var0, a.b("돂", 1440789376), var1);
            break;
         case 170:
            hdb(a.d("ᆓ", -949092281, -867429994), hch > 0 && hch - hci <= 20, a.b("섙뢫㉰걆⟓ꅲᬼ鋉ಘ虬Ǿﮈ畍\ueced暩\ue00a", -1650146971) + (hch - hci));
            hcm(var0, false, var1);
            break;
         case 185:
            hdb(
               a.b("\udab7", -1386358027),
               hcx(var0) == 0 && hcw(var0).isOf(Items.DIAMOND_SWORD),
               a.d("⃗奯펳䷈왆", 429074013, -1683749145) + hcy(hcw(var0)) + a.b("婇⎥ꥩ㜛볗㨯", 1676565089) + hcx(var0)
            );
            hdd(a.b("‡", -782032797), false);
            break;
         case 188:
            hcp(var0, true);
            break;
         case 190:
            hcl(var0, a.d("鉂\uebf7愣ｙ璈\uf228䡨솞忓픬劶ꣀ☌뾼㗤", -608749091, 491170813));
            break;
         case 195:
            hde();
            hcn(var2);
            hcm(var0, true, var1);
            break;
         case 196:
         case 197:
         case 198:
         case 199:
            hcz(var0, a.b("㯅", -705152128), var1);
            break;
         case 215:
            hdb(a.b("ꤊ", 1511893327), hch > 0 && hch - hci <= 14, a.d("\udd91ꐧ⻯낟㭃붷ަ蹇စ骰ᵭ\ue759槏\uf079稸ﳘ䚀줃", -2115298988, 1902757028) + (hch - hci));
            hcm(var0, false, var1);
            break;
         case 216:
         case 218:
         case 220:
         case 221:
         case 222:
         case 223:
         case 224:
            hcz(var0, a.b("ᅼ", 86118713), var1);
            break;
         case 232:
            hdb(
               a.b("꺷", -656429326),
               hcw(var0).isOf(Items.DIAMOND_SWORD) && hcv(var0, 10).isOf(Items.DIAMOND_PICKAXE),
               a.b("⧲偊\uda96䓭콣", 1978673567) + hcy(hcw(var0)) + a.d("嚮⽌ꖀ㯲뀾㛊貘դ", 516086856, 382372558) + hcy(hcv(var0, 10))
            );
            hdb(a.c(1876634645, "ⱐ"), var0.options.sneakKey.isPressed(), a.d("렉솥䭽픈廕\ud82f戲\uebc2疆｣磢芄\u0c45闳Ά饗⌏곟", -2111747915, -134947));
            hdc(a.d("숁", -1523871485, -423799993));
            hcp(var0, false);
            break;
         case 240:
            vzz.simulated = null;
            hbu.clear();
            hcf = false;
            System.out
               .println(
                  a.c(-1172985409, "꧁큫媸쓊佑즴珶﨑摉\ueeac")
                     + (hce == 0 ? a.d("\uf8ce腮ய闞", -428148651, 333709519) : a.c(-1918644677, "칻럍㴖ꍢ⣙깠") + hce + a.b("ꁭ", -139550651))
               );
            return true;
      }

      if (var1 > 12) {
         hcn(var2);
      }

      if (hcf) {
         var0.options.attackKey.setPressed(true);
         if (hch == 0 && hcg != null && var0.getServer().getOverworld().getBlockState(hcg).isAir()) {
            hch = var1;
         }
      }

      if (hbu.contains(87)) {
         var0.options.forwardKey.setPressed(true);
      }

      return false;
   }

   static void hcl(MinecraftClient var0, String var1) {
      hdf(
         var0,
         a.c(734464194, "ࢸ焟ﯝ斺\uee63棑튎孷앣")
            + hcg.getX()
            + a.b("蜊", 1298237227)
            + hcg.getY()
            + a.d("雷", -1682575794, 622204710)
            + hcg.getZ()
            + a.d("\u1a8e", 1212318067, 1963498460)
            + var1
      );
   }

   static void hcm(MinecraftClient var0, boolean var1, int var2) {
      hcf = var1;
      KeyBinding var3 = var0.options.attackKey;
      if (var1) {
         hci = var2;
         hch = 0;
         KeyBinding.onKeyPressed(KeyBindingHelper.getBoundKeyOf(var3));
         var3.setPressed(true);
      } else {
         var3.setPressed(false);
      }
   }

   static void hcn(ClientPlayerEntity var0) {
      var0.setYaw(0.0F);
      var0.setPitch(0.0F);
   }

   static void hco(MinecraftClient var0, boolean var1, boolean var2) {
      if (var1) {
         hbu.add(87);
         var0.options.forwardKey.setPressed(true);
         if (var2) {
            hbu.add(341);
            var0.options.sprintKey.setPressed(true);
         }
      } else {
         hbu.remove(87);
         hbu.remove(341);
         var0.options.forwardKey.setPressed(false);
         var0.options.sprintKey.setPressed(false);
      }
   }

   static void hcp(MinecraftClient var0, boolean var1) {
      if (var1) {
         hbu.add(340);
      } else {
         hbu.remove(340);
      }

      var0.options.sneakKey.setPressed(var1);
   }

   static void hcq(MinecraftClient var0) throws Exception {
      for (Field var4 : Mouse.class.getDeclaredFields()) {
         if (var4.getName().equals(a.d("ᅍ棪\ue23e籎\uf785焩쭄䊖\udcc5噼톡⯑", 1805990665, 1680681515))) {
            var4.setAccessible(true);
            var4.setBoolean(var0.mouse, true);
         }
      }
   }

   static kfe hcr(MinecraftClient var0, String var1, boolean var2) {
      kfe var3 = Flow.getInstance().getModuleManager().getByName(var1);
      if (var3 != null) {
         var3.setEnabled(var2);
      }

      return var3;
   }

   static void hcs(MinecraftClient var0, float var1) {
      IntegratedServer var2 = var0.getServer();
      ServerPlayerEntity var3 = hct(var0);
      var2.execute(() -> var3.setHealth(var1));
   }

   static ServerPlayerEntity hct(MinecraftClient var0) {
      return var0.getServer().getPlayerManager().getPlayer(var0.player.getUuid());
   }

   static ItemStack hcu(MinecraftClient var0) {
      return hct(var0).getOffHandStack();
   }

   static ItemStack hcv(MinecraftClient var0, int var1) {
      return hct(var0).getInventory().getStack(var1);
   }

   static ItemStack hcw(MinecraftClient var0) {
      return hct(var0).getMainHandStack();
   }

   static int hcx(MinecraftClient var0) {
      return hct(var0).getInventory().getSelectedSlot();
   }

   static String hcy(ItemStack var0) {
      Item var1 = var0.getItem();
      return var0.isEmpty() ? a.d("猡ઘ聖ḣ闹", 1703722534, 773377383) : var1 + (var0.hasGlint() ? a.d("겙", 899128468, 1416376358) : "");
   }

   static void hcz(MinecraftClient var0, String var1, int var2) {
      ClientPlayerEntity var3 = var0.player;
      System.out
         .println(
            a.c(1542174098, "뗤챑䚔\ud8f4即")
               + var1
               + a.d("긖ퟳ", -1161273423, -204148347)
               + var2
               + a.b("ﺐ蜻ච鏉ᡓ", -352125265)
               + var3.getHealth()
               + a.d("橉Ꮇ饭ܜ貐", -1613372681, 943229083)
               + hcy(var3.getOffHandStack())
               + a.c(707826779, "鑽\ued84杞鸞狽\uf415")
               + hcy(var3.getMainHandStack())
               + a.d("⼷囒\udc1a䉰즶伏\uf573粵\ue2ec桗\uefc0", 541188480, 123719324)
               + krd.busy()
               + a.b("\ue29d魸ᆰ迁Е芊㣮넙⽌ꖹ", 295101111)
               + nuo.busy()
               + a.b("䦱ぉ몗⓮꼰⧙", -1300870761)
               + vyn.serverIdle(var3)
               + a.b("퇎꠹⋻벙㜗", 418238955)
               + var0.options.forwardKey.isPressed()
               + a.b("젔뇤㬢ꕌ⻍", 1764542513)
               + var0.options.attackKey.isPressed()
               + a.d("픍곾☽롛㎈딳ར蚔ᣂ鈩", 1223729231, -366381720)
               + var0.interactionManager.isBreakingBlock()
               + a.b("쌕뫥〾깋◌", -521616592)
               + (var0.crosshairTarget == null ? a.d("\u177c滖\ue41c穭", 1926913607, 930367825) : var0.crosshairTarget.getType())
               + a.c(-1756083821, "䦰せ뫏")
               + String.format(a.c(-2110751949, "笒ʨ衧ᙂ"), var3.getZ())
               + a.b(" 姶팢䴊", -1143463904)
               + hda(var0, a.b("깒ퟶ崥썁䢔츭瑖ﶋ揔\ue966溽铇ᨈ莠", -912544195))
               + a.d("\ue05d馠፰贍ے聭㨿뎗", -214994533, 372937198)
               + var0.mouse.isCursorLocked()
         );
   }

   static String hda(Object var0, String var1) {
      try {
         Field var2 = var0.getClass().getDeclaredField(var1);
         var2.setAccessible(true);
         return String.valueOf(var2.get(var0));
      } catch (ReflectiveOperationException var3) {
         return a.c(-1284934122, "瘨");
      }
   }

   static void hdb(String var0, boolean var1, String var2) {
      if (!var1) {
         hce++;
         System.out.println(a.b("傄⤱ꏴ㶔똓", 1668829426) + var0 + a.c(-1185889547, "싓묄㇐꾩⑻ꊦ") + var2);
      }
   }

   static void hdc(String var0) {
      hdd(var0, true);
   }

   static void hdd(String var0, boolean var1) {
      hcb = false;
      System.out
         .println(
            a.c(-1935485745, "풹괌⟉릩㈮")
               + var0
               + a.d("∖宽턭体쒁䈺\uf861熈\uef99", -496649406, -1710450329)
               + hbv.get()
               + a.d("뤡샆䨊푽復\ud915捓\ueabf瓦﹖禘莧", 1369449910, -107963205)
               + hbw.get()
               + a.b("桥ᆀ魕Է軨\u085c뉞", -860657598)
               + hbx
         );
      if (var1 == (hbv.get() == 0)) {
         hce++;
         System.out
            .println(
               a.b("拔᭡醤࿄葃", -1477614942)
                  + var0
                  + a.d("⣣儴\udbe0䖙칋䢖\uf286筸\ue522澙\ue842ራ鲲", -1618384527, -1442823745)
                  + hbv.get()
                  + a.b("咔ⵠꞮ㧗눕㒢軦܆饘Ꭽ", 649221310)
                  + (var1 ? a.d("˸筇", 1645121513, -203518675) : a.b("싚", 1210630891))
            );
      }

      if (hbw.get() != 0) {
         hce++;
         System.out.println(a.c(564617127, "忑♤겡㋁륆") + var0 + a.d("㟣临쓠媙텋垖\ueda8摡﨧炎\uf740ങ菬ᩊ逄ᛳ경⍱릑㾗뙸찳䊙\ud940彻헬汕\ue209磸", -263467608, -123274634));
      }
   }

   static void hde() {
      hbv.set(0);
      hbw.set(0);
      hbx.setLength(0);
      hcb = true;
   }

   static void hdf(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   static void hdg(MinecraftClient var0) throws Exception {
      if (!hcd) {
         ServerPlayerEntity var1 = hct(var0);
         ClientConnection var2 = null;

         for (Field var6 : ServerCommonNetworkHandler.class.getDeclaredFields()) {
            if (var6.getType() == ClientConnection.class) {
               var6.setAccessible(true);
               var2 = (ClientConnection)var6.get(var1.networkHandler);
            }
         }

         Channel var8 = null;

         for (Field var7 : ClientConnection.class.getDeclaredFields()) {
            if (Channel.class.isAssignableFrom(var7.getType())) {
               var7.setAccessible(true);
               var8 = (Channel)var7.get(var2);
            }
         }

         var8.pipeline()
            .addBefore(
               a.d("⼺嚚\udc4b䈲짫佋\uf533糵\ue2a3栝\uefc4ᖽ魣˅", 775179838, -1496358534),
               a.c(787934943, "\ueeaa霑᷁莨࠺軦㒙뵬⌥ꦅ\u2e79퐥嫥썒䤍쿡疸難惌"),
               new ChannelInboundHandlerAdapter() {
                  public void channelRead(ChannelHandlerContext var1, Object var2x) throws Exception {
                     hbt.hdh(var2x);
                     super.channelRead(var1, var2x);
                  }
               }
            );
         hcd = true;
      }
   }

   static void hdh(Object var0) {
      if (var0 instanceof PlayerInputC2SPacket var1) {
         PlayerInput var5 = var1.input();
         boolean var6 = var5.forward() || var5.backward() || var5.left() || var5.right() || var5.jump();
         if (hcb && (var6 != hby || var5.sneak() != hbz)) {
            hdi(!var6 && !var5.sneak() ? a.b("➚带퓽䪅", -1410062345) : a.c(-974392198, "\uf416趠ݭ餙ዏ"));
         }

         hby = var6;
         hbz = var5.sneak();
      } else if (var0 instanceof ClientCommandC2SPacket var2) {
         if (var2.getMode() == Mode.START_SPRINTING) {
            hca = true;
            hdi(a.c(976424471, "\u0e62矐ﴁ捫\ue8bb渐"));
         } else if (var2.getMode() == Mode.STOP_SPRINTING) {
            hca = false;
            hdi(a.b("렙솯䭧픉廽\ud86f戾\uebd4疌Ｇ", -1861961632));
         }
      } else if (var0 instanceof PlayerActionC2SPacket var3) {
         Action var7 = var3.getAction();
         if (var7 == Action.START_DESTROY_BLOCK || var7 == Action.ABORT_DESTROY_BLOCK || var7 == Action.STOP_DESTROY_BLOCK) {
            hdi(var7.name());
         }
      } else if (var0 instanceof UpdateSelectedSlotC2SPacket var4) {
         hdi(a.c(1398952013, "倸⦟ꍅ㴽뛬お") + var4.getSelectedSlot());
      } else if (var0 instanceof ClickSlotC2SPacket || var0 instanceof CloseHandledScreenC2SPacket) {
         boolean var8 = var0 instanceof ClickSlotC2SPacket;
         if (var8) {
            hbv.incrementAndGet();
         }

         hdi(var8 ? a.c(-214246594, "\udb78ꋆ⠐뙫㶴") : a.b("沈背ਜ鑱ᾰ", -904988364));
         if (hby || hbz || hca) {
            hbw.incrementAndGet();
            hdi(
               a.b("莗祝炝\ueeea放\ue382姄퀨乱쓁䍴륀㞕긽⑱ꊇᣁ靊", -944667740)
                  + hby
                  + a.b("\ue6cf鼡ᗯ讕F蛽㳸", -221714716)
                  + hbz
                  + a.c(-679008255, "⠥凋\udb1b䕨캤䠒\uf25b篣")
                  + hca
                  + a.c(2003472898, "鈪")
            );
         }
      }
   }

   static void hdi(String var0) {
      if (hcb && hbx.length() < 600) {
         hbx.append(' ').append(hcc).append(':').append(var0);
      }
   }
}
