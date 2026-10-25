package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class hfi {
   static final List<PlayerEntity> hfj = new ArrayList<>();
   static PlayerEntity hfk;
   static final int hfl = 80;
   static final String[] hfm = new String[]{
      a.c(496399700, "甸ಀ虓"),
      a.d("䬝㊡롲♏귗⭧", -443151681, -1676459579),
      a.d("\uf2f9譁ƒ", -1959514627, -973480088),
      a.d("脮\uf884牞\uec2a柼\ue15a嬈", -927582642, -1921140972),
      a.c(357961634, "࿎癶ﲥ"),
      a.c(-1752267343, "藟ﱣ皰\ue88d挘\ue5be忬홉䡅싯䔵뽁㆗꠱≣"),
      a.c(1056645037, "῁晹\uecaa"),
      a.b("뇅졹䊪\udc97圏톿", 1380561314)
   };
   static final String[] hfn = new String[]{
      a.c(-765029261, "鐮\uedaa杪癩狛\uf47b丙쟾妢"),
      a.c(1345099157, "闛\uec57暕\uf8ec猓\uf5b4俤"),
      a.b("痜\u0c50蚒ᣫ錁ᖈ꿊☱롴㋏딌", 1917285790),
      a.d("瞎ฝ蓙᪩酳ៈ권①먹ら띇", 123663664, -644250907),
      a.c(-311495107, "\uf67a迸ԫ魇ႈ阽"),
      a.b("\ueedd靂ᶒ華࠰躥㓌봼⍻ꧏ⸛푡", 444853907),
      a.c(-2080681175, "卽⫷ꀭ㹙떏㌩襻")
   };
   static long hfo;
   static long hfp;
   static boolean hfq;

   hfi() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfx var2 = Flow.getInstance().getModuleManager();
      ruv var3 = (ruv)var2.getByName(a.b("⥤僠\uda20䑄쾑䤱\uf353窴\ue4e8", -889640647));
      switch (var1) {
         case 1:
            hgb(var0, a.d("䊯㬘뇇⾾ꑡ⋒颊ᅺ轠֒艐砶\uf6e5潁\ue50f握\ud9bd", -29371973, 1391235938));
            hgb(var0, a.c(-579271001, "۞署\uf5a5毜\ue04e暬\udce9唉쬂䆥왰㰁닖"));
            hgb(var0, a.b("䱩㗊뼝ⅹꪲⰎ陊Ῡ臵ୋ貑盤\uf820", -1201714157));
            hfw(var0, 0.0F, 8.0F);
            hfk = hfy(var0, a.c(-1415440344, "ᡩ懮\ueb2a畟ﺄ"), 3.2, 0.0);
            hfk.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
            ruv.onAttack(hfk);
            var3.mode.set(a.d("썿뫡〵깘█ꌾ", 1150096127, -177745471));
            var3.setEnabled(true);
            izx.TARGET.enabled.set(false);
            break;
         case 22:
            hgd(var0, a.c(-1654873138, "ꎶ\uda41傓컾䕡쏆禖\uf03a港\ue491捅館៸蹎"));
            break;
         case 23:
            var3.mode.set(a.c(-537484703, "ꈺ\udba8兪켈䓆쉰砪\uf1cd"));
            break;
         case 42:
            hgd(var0, a.b("ꋔ\udb23凲쾜䐃스磴\uf158潙\ue5eb戩顋ᚅ輳թ莎", 1925489330));
            break;
         case 43:
            var3.mode.set(a.d("齡\ue6eb氿\uf247", -445354524, 47117011));
            break;
         case 56:
            hgd(var0, a.c(1671574997, "㖯䱘욈壧퍸嗟\uef8f昣\uf823犉\uf55d༥"));
            break;
         case 63:
            hgd(var0, a.b("﵅蒲\u0e62遂ᯚ鴣❦꺔ゖ멸㶰쟆䤘", 1837301054));
            break;
         case 64:
            var3.mode.set(a.d("궑퐌廝삤䭢췔", -595888241, 1616042587));
            break;
         case 80:
            hgd(var0, a.b("ഀ瓷︠恈\uebd7浰휠庌삝䨠췱㞈륎\u20f8", -770830984));
            break;
         case 81:
            var3.mode.set(a.c(-21445475, "쓘뵌㞑ꧯ∤\ua48fớ霭ॻ"));
            break;
         case 90:
            hfk.hurtTime = 10;
            hfk.maxHurtTime = 10;
            ruv.onAttack(hfk);
            break;
         case 91:
            hgd(var0, a.b("餜\ue0eb樽\uf454翋塞䌼쪐咎\ude3a姧ꎙⵒ듹㺭롛ȝ趆ᝰ鄠ᣊ", 787192191));
            break;
         case 100:
            hgd(var0, a.c(69428594, "攖᳡阷ࠑ莉հ뼵㛇ꣅ∵ꗣ徜텄䣩슠䑖\ufe1e燆"));
            System.out.println(a.c(-1877998296, "Ց糿\uf636桁\ue382放\udf21嚕죜䉮역㿟넛⢯ꊩ") + hgc(ruv.cpuMicros()) + a.b("\udcaeꕊ⾟놲㨬벉ۉ輴ᅣ", 1422187655));
            break;
         case 101:
            var3.setEnabled(false);
            izx.TARGET.enabled.set(true);
            hfz(var0, hfk);
            hfu(var2, a.c(-8298297, "悉ᤅ鏇\u0dbe虁æ몶"), true);
            hfu(var2, a.b("뵳쓿丽큄宮\udd27来\uee9e烛褐綣", -1468875471), true);
            hgb(
               var0,
               a.c(
                  722207029,
                  "ě碬\uf267氖\ue7c3慳\udb6e勒첉䘿쇧㮐땖\u2cf4ꚠ⁃驂ᗀ轮म胑鬒琠\uefbe槐\ue35f媢퓭丁졅䎨봵㝦꺌⣊ꈠ᷅鞉ᅋ裲˺籊\uf60b熷\ueb3e敗\udccb噾퀶䯬얙㽙뛽カꩊ\u2455龴ᥨ錓\u0ace葻︫秒\uf3c5洄\ue4fa庥\ud84e刂충䜴셎㢒뉬Ɱ\ua7e3\u218d鬶ይ貂و耭﮿畧\uef1d曔\ue024婼햂俖쥤䂴몉"
               )
            );
            hgb(
               var0,
               a.d(
                  "쪢댕㧞ꞯⱺ\uaacaთ饫ܰ趆ਫ਼\uf029绯\ue74d洙\uebfa击\ude79䓗슗䭨ㅴ뾙␛ꉹ⢶鄓\u1f5a藳Ϭ衁皋ﳑ敾\ue360槌혇層\udaec䍯줍럭㶶멐\u20c6꺥\u177b鶔ᯃ聝ส\uf4fc絀ﬗ懵\uefb7吏틌壱셽係㖐뉫㠻\ua6ff⽿锒Ᏺ馥؈賒\u0ae4\uf335秋\ue794汿\uea33傘\ud905䝽췼䯼〳뻛⒦굿⯒醆ṍ落ʇ譛焴ﾦ搜\ue24c梆훶弤엟",
                  1177951666,
                  -1578117369
               )
            );
            hgb(
               var0,
               a.d(
                  "冽⠊ꋁ㲰띥㇕诈ɴ鰯ᚙ酁欶\ue5f0籒\uf606烥쫤䕦\udfc8妈큷ꩫ⒆뼙㥸뎵ਔ萛Ả飭ፅ\ued81析︫硢\uf2c9䴊유䇁\ud84d刃⳺\ua6feℎ믋㖷谺ړ肓ᭆ锲濨\ue659怙\ufaf9璯켂䦝쎺婠퓆꺋⥵ꌳ㷧둋ฉ裂ʹ鴌ះ醫桢\ue295糈\uf776焭쮆䉎\udc25嚤탾ꬁ▁뾊㙢냛ં蕣ἷ馰၀\uea3e擢ｉ祛\uf39d䷭쐻庋\ud8dd卦",
                  1928688260,
                  -1093721300
               )
            );
            hgb(
               var0,
               a.d(
                  "\ue814醣᭨蔙໌衼㉡믝▆꼰⣨튟屙엻侯쥌獍ﳏ晡\ue021槞Ꮒ鴯ڭ胍\u0a0e돣㷼꜕⅟\uaaf9呶\ude72䞖솞䬝\uf4f7纗\uf84c憪\uebb4镗Ἁ飦ȩ谗㗀뽶㤲ꋥⲇ홅念\ud9b6䌋촃皰\uf06c稟\ue3c0浾\u1739郍᪇葉ෳ럧ㄘ묀Ⓗ깴⠞퇛嬤앻予좖牶ﯙ斑\uef54植አ鱴ط过ॽ댡㳆ꛔ\u206eꦾ双\udd1c䚮삵",
                  94637132,
                  -1752112053
               )
            );
            hgb(
               var0,
               a.d(
                  "㡀䇷쬼啍\ude98堨\ue235殉\uf5d2罤\uf8bcˋ谍ᖯ鿻ᤘꌙⲛ똵ふ릊쎖䵻훹備\uda54揺\uedb8眑\uf10e窣葩ำ鞜ᆄ鬮ⓥ꺆⠎농㯯䔏코䢲툤屇\ue599潶\ue921犿ﳈ؞辢৵錗ᵕꛭ\u202eꨓ㎛봠일䂏쫐吖\uddb1查\ue10f歙\uf4e3繷\uf808Ƙ謥ᕬ麆ᣋꈴ⯫떘㼞뤞싑䰹홄徝\ud930捤\uecaf盟\uf065禹菖ൄ雾Ⴎ驤␔귆㜽",
                  -1831622921,
                  -1714643296
               )
            );
            hgb(
               var0,
               a.b(
                  "\uee4a韽ᴶ荇\u0892踢㐿붃⏘ꥮ⺶퓁娇쎥䧱켒甓晴怿\ue67f澀ᖜ魱ì蚁ఎ뗳㮼ꅐ✔곹剠\ud839䆓쟲䵾\uf2b8磁﹅枵\uedf8錄ᤉ麠и詍㎙뤣㽪꒪⫊퀜妹\udfa6䔊쭐烥\uf635籑\ue5ad欵ᅱ隆᳄舕௪놷㜉뵒⋹꠱⹚ퟋ嵱쌥䢟캙瑔ﶾ揅\ue902潍ᓻ騞H覐༮땧㫛ꂃ☱꿥喓\udb43䂺",
                  349630054
               )
            );
            hfw(var0, 0.0F, 38.0F);
            break;
         case 140:
            hgd(var0, a.b("竘̯觺ថ鰃\u1aafꃭ⤔띕", -220824921));
            break;
         case 141:
            hgb(var0, a.b("㏋䩸삮廟필厕\ue9e3怬﹜瓠\uf33aफ़蟑Ḵ鑺ኚ\ua8dd✼", -1173605454));
            hfu(var2, a.d("ꎲ\uda3e僼캅䕺쏝禍", -803660341, -1876312521), false);
            var0.player.getInventory().setSelectedSlot(0);
            var0.player.getInventory().setStack(0, new ItemStack(Items.ENDER_PEARL, 16));
            hfu(var2, a.b("櫚ፉ馍߽谧જ냘㤴ꝭⷝꨓ", 1036610177), true);
            hfw(var0, 0.0F, -12.0F);
            break;
         case 150:
            hgd(var0, a.b("랩칞䒊\udae1八ퟏ涘\ue47a稻\uf0cb睓败ϡ", 774158290));
            break;
         case 151:
            hfw(var0, 30.0F, 32.0F);
            break;
         case 160:
            hgd(var0, a.c(1507032069, "籽֊轑ᄵ骿ᰛꙌ⾮뇯㬟벏䛵젦冄"));
            break;
         case 161:
            hfu(var2, a.c(-396307395, "푦귵✱륁㊛될\u0e64螈᧑鍡ᒯ"), false);
            var0.player.getInventory().setStack(0, ItemStack.EMPTY);
            hgb(var0, a.c(605698820, "㭗䋰젲噕\udd8c嬾\ue161梘\uf68c籣ﯿƟ輖\u16f9鳴ᩈꀔ⾈딿㍩몕샂习햢叚\ud919惤\ueefc琌\uf246秴蜮"));
            hgb(var0, a.d("ᐩ涎\ue74c礫\uf2f2瑀츟䟦\ud9f2匝풐⺿ꀶ㧙돇㔥輧ò驆ᰜ闭\uefad愍\ufadb粶\uf629俏손孭\udd08嚈ꡚ∝", -1065952444, 1138872127));
            hfu(var2, a.b("⼃嚜\udc4c䈱짮佻\uf512糢\ue2a5树\uefc5ᖿ", -526241971), true);
            hfx(var0, new Vec3d(Math.floor(var0.player.getX()) + 0.5, Math.floor(var0.player.getY()) + 0.6, Math.floor(var0.player.getZ()) + 3.5));
            break;
         case 172:
            hgd(var0, a.d("甧\u0cd0蘊ᡯ鏺ᕑ꼃⛪뢰㈆뗞", 1593671134, 850593924));
            break;
         case 173:
            hfu(var2, a.b("礁\u009e詎ᐳ鿬\u1979ꌐ⫠뒧㸓맇䎽", 9468239), false);
            hgb(var0, a.c(-1442831450, "⏋婬킮仉씐䎢什瀄\uee10擿\ue363ᤃ鞊\u0e65葨˔뢈㜔궣⯵ꈉ\ud85e囼촾䭆솅硸\uf672沍\ueac7"));
            hgb(var0, a.b("\uf58d谪ۨ颏ፖ闤⾻Ꙃ㡖늹㔴켛䆒\ud87d剣풁溃\ue156篢ﶸ瑉ฉ肩\u1b7f鴒ឍ깥‼뫐", -744884765));
            hfw(var0, 0.0F, 8.0F);
            hfj.add(hfy(var0, a.d("춹됯㻱ꂁ⭑귪", -700706643, -453911216), -6.0, 1.0));
            hfj.add(hfy(var0, a.d("\udff1ꙤⲴ닐㤟", 541876439, -1169571992), 3.0, -7.0));
            hfj.add(hfy(var0, a.c(1787343316, "놃젉䋔\udcaa坡"), 1.0, 9.0));
            hfj.add(hfy(var0, a.c(-2050079229, "䙆㿐딐"), 40.0, 25.0));
            hhf.add(a.c(-1364339382, "프겑♁력㏪"));
            kfe var21 = var2.getByName(a.b("ꁪ\ud9e8医쵗䚘쀭", -809131987));
            ((vkl)hfv(var21, a.b("\uf229讵ż鼊ᓈ鉶⠨ꇟ", 974582373))).set(true);
            var21.setEnabled(true);
            break;
         case 185:
            hgd(var0, a.b("䃠㤖도ⶨ\ua633ₑ髂ጮ赩ߜ", -191741796));
            break;
         case 186:
            hfu(var2, a.b("죪녨㮻ꗗ⸘ꢭ", -1417361235), false);

            for (PlayerEntity var24 : hfj) {
               hfz(var0, var24);
            }

            hfj.clear();
            hhf.remove(a.c(-713189088, "饮\ue0fb樫\uf44f羀"));
            hgb(var0, a.c(-1374378505, "ꖁ\udc36囩좐䍏염群\uf654桎\ue2ac敹鼏ᇜ衲Ⱦ蓘㺚"));
            var0.player.getInventory().setStack(0, new ItemStack(Items.COOKED_BEEF, 8));
            break;
         case 190:
            var0.player.getHungerManager().setFoodLevel(11);
            var0.player.getHungerManager().setSaturationLevel(4.5F);
            break;
         case 192:
            hgd(var0, a.b("呫\u2d9dꝎ㤣늪㐉蹏\u07bf駧ፅ钃滯\ue03e禎", -540126189));
            break;
         case 193:
            hgb(var0, a.b("秄s説ᓕ鼊ᦹꏡ⨑됋㻹뤻䍝춎吪\ude64墊\ue2d6", 1496152498));
            var0.player.getInventory().setStack(0, ItemStack.EMPTY);
            hfw(var0, 35.0F, 4.0F);
            break;
         case 200:
            hgd(var0, a.d("覨\uf05e窎\ue4e0潩\ue9c3厙\uda6d䐳캕䥇덨㷽ꑅ⸖", -405124736, 278708305));
            break;
         case 201:
            hfu(var2, a.b("襛\uf0d1程\ue47f澩\ue90f卝", 1409321231), true);
            break;
         case 210:
            hgd(var0, a.b("墩⅟ꮎ㗡빨㣂芘୬锲ᾔ顆扩\uece0畍７秴", 529094863));
            break;
         case 211:
            ((vlv)hfv(var2.getByName(a.d("癘࿒蔈᭼邪ᘌ걞", 531804825, 1669121173)), a.c(-951277814, "Ꝃ\uded0吃쩶"))).set(a.c(-1864331575, "躚\uf714緘\ue3b6桬"));
            break;
         case 220:
            hgd(var0, a.c(1571514803, "槔ဢ髴Ҝ輕ি돥㨑ꑏ⻩ꤻ匔\udd98䐶칺䢔\uf2d6"));
            break;
         case 221:
            ((vlv)hfv(var2.getByName(a.d("\uf052觘̂鵶ᚠ逆⩔", 1881793586, 39195700)), a.c(1903188971, "宣∱꣢㚗"))).set(a.d("⎡娬탶井", 1392243656, 938659902));
            hfu(var2, a.b("\ud9a3ꀩ⫳뒇㽑맷Υ", -1523394057), false);
            break;
         case 222:
            kfe var19 = var2.getByName(a.b("\ue0f7饳Ꭰ跓", -310779735));
            ((vlv)hfv(var19, a.c(-526648438, "ﯟ艌࢈雯ᴸ"))).set(a.c(154062266, "취둢㺹ꃈ⬔궬"));
            var19.setEnabled(true);
            var19.onKey(var0, ((vlq)hfv(var19, a.d("꧉큖媙", 909894838, -605139657))).get());
            break;
         case 240:
            hgd(var0, a.d("흄꺲⑥먌ㆌ뜨ൻ蒈", 171311575, 1308415725));
            break;
         case 241:
            kfe var18 = var2.getByName(a.d("ଟ犛\uf848昻", 68531645, -16335108));
            var18.onKey(var0, ((vlq)hfv(var18, a.b("徂☝곒", -563912758))).get());
            break;
         case 255:
            kfe var17 = var2.getByName(a.d("퀲ꦶ⍥봖", 2010665989, -1125350295));
            ((vlv)hfv(var17, a.b("쌡몲ぶ긑◆", 708690804))).set(a.b("ꑻ\udded圽쥄", 542286903));
            var17.setEnabled(false);
            System.out.println(a.b("盬ག薋᯼逿ᚃ겜┷뭽㇌똝䰡슴嬆텗垮\uedb0扻\uf88e绖\uf738贿", 985101964) + var0.options.getFov().getValue());
            break;
         case 256:
            hfk = hfy(var0, a.d("㋼䭻솿忊퐑", -1674618759, 1012099780), 3.2, 0.0);
            hfu(var2, a.c(-1624805604, "潝ᛘ鰜ɭ覜༏땐"), true);
            var0.options.forwardKey.setPressed(true);
            var0.options.jumpKey.setPressed(true);
            break;
         case 266:
            var0.options.forwardKey.setPressed(false);
            var0.options.jumpKey.setPressed(false);
            var0.player.setYaw(var0.player.getYaw() + 180.0F);
            var0.player.setPitch(25.0F);
            break;
         case 276:
            hgd(var0, a.c(-704559858, "䕳㲅뙑⠻ꎧ│齆ᚷ裮ɝ薂"));
            System.out
               .println(
                  a.b("襧\uf0c9稀\ue477澴\ue908北\udaa0䓫칍䦞돩㴼ꒁ⺅ꡮቢ鶱\u070e腗ࢷ狵ﰇ", 1594853638)
                     + var0.getCameraEntity().getClass().getSimpleName()
                     + a.c(1432191976, "菌屮烺\ueedf")
                     + hgc(var0.getCameraEntity().getY())
                     + a.c(-818678624, "\uf480贽\u07be駓ሉ钠⻯꜉㤄돴㐲츗")
                     + hgc(var0.player.getY())
               );
            break;
         case 277:
            hfu(var2, a.c(119458082, "쥣냦㨢ꑓ⾢ꤱ፮"), false);
            break;
         case 280:
            kfe var16 = var2.getByName(a.d("ယ榟\ue35b紪\uf6d4灆쨕䏠", 1875664269, -2108666407));
            ((vlv)hfv(var16, a.c(9502400, "ﺕ蜆ෂ鎥ᡲ"))).set(a.c(1428842983, "榵ဿ髤ҕ轉ৱ"));
            var16.setEnabled(true);
            var16.onKey(var0, ((vlq)hfv(var16, a.c(743270327, "柿Ṡ钯"))).get());
            break;
         case 283:
            var0.player.setYaw(var0.player.getYaw() + 140.0F);
            break;
         case 295:
            hgd(var0, a.c(1768789185, "钻\ued4d枘麟牯\uf4ca于읿天펛呈긽"));
            System.out
               .println(
                  a.d("蒙ﴷ矾\ue989扊\ue4f6廩흞䤕쎳䑠븘ヌ\ua97d〉ꖊ῟遌\u0af2貨Ղ罊\uf1a0橩\uec00暆", 664758633, -410260068)
                     + hgc(var0.player.bodyYaw)
                     + a.c(-196679254, "\ue986遴᪥蓘༇覡㏡멑\u2457껾⤻팝")
                     + hgc(var0.gameRenderer.getCamera().getYaw())
               );
            break;
         case 296:
            kfe var15 = var2.getByName(a.b("̟窚\uf05e港\ue5d1捃\ud910僥", -1550711983));
            var15.onKey(var0, ((vlq)hfv(var15, a.d("ꂫ\ud934叻", -441774236, 681422727))).get());
            ((vlv)hfv(var15, a.c(-1858900171, "潠ᛳ鰷ɐ覇"))).set(a.c(-1753218900, "à祶\uf3a6淟"));
            var15.setEnabled(false);
            hfz(var0, hfk);
            break;
         case 300:
            hgb(var0, a.b("烛ॸ莯᷋阀Ⴜ\uaaf8⍛뵖㟴뀯䩙", -95129440));
            hfw(var0, 0.0F, -20.0F);
            break;
         case 330:
            hgd(var0, a.b("꘨\udfde唄쭠䃨왊簑\uf5e7", 2049812054));
            break;
         case 331:
            hfu(var2, a.c(-102542321, "呉ⷙꜷ㥱늭㐖蹄ޢ"), true);
            break;
         case 340:
            ((vkl)hfv(var2.getByName(a.b("\ue1c9顙\u12b7賱ܭ膖㯄눢", -1249123953)), a.b("ꘘ\udf9a啁쬷", 1745659470))).set(true);
            break;
         case 360:
            hgd(var0, a.d("\ue689齿ᖤ证U蛥㲫땍⬙ꆢ♰\udc16办쭰䄰쟉綁", 1202997424, 2145889886));
            ((vkl)hfv(var2.getByName(a.d("嫐⍀ꦮ㟨밴㪏胝ऻ", 1731904335, 969972185)), a.d("\uea15鎗᥌蜺", -978803554, 1710182109))).set(false);
            hgb(var0, a.d("멟쏼䤫흏岄\uda38恼\ue9df矃ﵽ窧胒ถ", 1766228525, -1360250872));
            break;
         case 361:
            hga(var0, a.c(-1308191608, "铜\ued5a枂粒爯\uf489"));
            break;
         case 385:
            hgd(var0, a.b("醭\ue858抉ﳥ睸\uf1db䮔숡尡횇兟ꬤ◲뱔", 1828557269));
            break;
         case 386:
            hga(var0, a.b("䉸㯵넫⽂ꒉ∯", -1964031442));
            break;
         case 405:
            hgd(var0, a.d("\uea95鍠ᦰ蟝ీ諣ガ뤙✛궶⩨퀁廊읬", -1517345332, -209400031));
            break;
         case 406:
            hga(var0, a.d("\udfa1\ua63cⳭ늓㥇뿣", 1959963310, 291861834));
            break;
         case 425:
            hgd(var0, a.b("韂\uee37擤慠焗\uf7b4䷻쑎婟탢圳굍⎙먽", -1494509638));
            break;
         case 426:
            hga(var0, a.b("ꁷ\ud9e2匫쵊", -745627586));
            break;
         case 445:
            hgd(var0, a.c(-631067390, "굸풍幟쀰䮭촎睁ﻴ惫\uea5e涗韶"));
            break;
         case 446:
            var0.setScreen(null);
            hft();
            hfw(var0, 0.0F, 12.0F);
            hfk = hfy(var0, a.d("곮합徭쇘䨃", 410241330, -1500224099), 3.2, 0.0);
            ruv.onAttack(hfk);

            for (int var14 = 0; var14 < 4; var14++) {
               hfj.add(hfy(var0, a.c(976145247, "쬎") + var14, 6.0 + var14 * 5, (var14 % 2 == 0 ? -1 : 1) * (4.0 + var14 * 3)));
            }

            hgb(
               var0,
               a.c(
                  -1588745918,
                  "ꥪ택娖쑧侲줂猟画擸\uee4e榖鏡ᴧ蒅໑蠲㈳붱✟ꅟ⢠劼\udc51䟏송䬮\uf2d3粜\ue670怴\uebd9ᕃ鼙ڳ胒ਫ਼떘㿡륥ₕ\uaad8퐤帩\ud980䌘쵭璹︃硊\ue38a淪霼ẙ领ȫ豷㟀넝㭬ꊼⰁ嘖퇫寵씶䲝\uf6d5瀾﨧斝\uef4d楳都ᨰ葚ྡ觾㍑몇Ⓜ긬⡴及\udd03䜷컯䡝\uf209緷\ue7a7慞"
               )
            );
            hgb(
               var0,
               a.d(
                  "䳅㕲뾹⇈ꨝⲭ隰Ἄ腗\u0be1谹癎\uf888愪\ueb7e涝힜堞슰䓰촏뜓㧾ꉼ␟껟ᜲ餭τ薎ศ\uf0a7窠\ue347敏\uefcc倦\uda46岝앻佥ㆆ믘㰷\ua6f8⣆鄑ᮧ鷣ش衖犔ﬤ絧\ue7da槖퉡咳\udec8䜘즤도㐉빉₆꤫፱闇ᾞ聠િ賔甐ﾻ憦\uea5e汇횧弈셀䮅췜뙱㢥ꋦ⬖궬៰頗ȅ蒿൯\uf71d种\ue27f摤",
                  -1436957165,
                  -1026454843
               )
            );
            hgb(
               var0,
               a.c(
                  -1082757928,
                  "泴ᕃ龈ǹ訬ಜ뚁㼽ꅦ⯐갈噿\ud8b9䄛쭏䶬\uf7ad砯\ue281擁\ued3e霢\u19cf艒п躰㝍뤂⏮ꖪ⹇탟媇쌭䕌쿀瀆奔系\ue50b潆ᆺ鮷ᰞ蚆ࣳ넧㮝뷔☔꡴劢\udb07崘잲䧯\uf25d璌ﻱ朩\ue988鏞ᐶ鹦¢襔㌉떷㿬ꁇ⪏곤啵\udfc8䆙쨡䰧\uf6ea缀\ue17b殼\uedf3际ᢠ苶ମ趐㟙롥∽\ua48fⵛ휭姽숄"
               )
            );
            hgb(var0, a.d("ᴜ撻\uee79瀞\ufbc7絵윪仓탇娨\udda5➊꤃レ뫷㰐蘒ে鍳ᔩ鳘\ue698核\uf3ee疃＜䛦좰剜퐌徴", 266247674, 463437962));
            var0.player.getInventory().setStack(0, new ItemStack(Items.ENDER_PEARL, 16));
            var3.mode.set(a.c(-1706255069, "鵸\ue4ea渨\uf04a箄ﴲ䝨캏"));
            break;
         default:
            if (var1 > 450 && var1 <= 450 + 80 * hfm.length) {
               int var13 = (var1 - 451) / 80;
               int var23 = (var1 - 451) % 80;
               String var25 = hfm[var13];
               if (var23 == 0) {
                  for (String var10 : hfn) {
                     boolean var11 = var10.equals(a.c(-684734793, "웣뽩㖳ꯇ‑ꚷ᳥"));
                     hfu(
                        var2,
                        var10,
                        var25.equals(a.d("澖ᘪ鳹˄襜\u0fec", 77195613, 4884140))
                           || var25.equals(a.c(2091798412, "俸㙒번⋼ꤪ⾌闞")) && var11
                           || var25.equals(a.c(223658741, "슛묧ㇴ꿉\u245cꋺᢨ鄍༁薫ɱ\uf805盓\uef75攧")) && !var11
                     );
                  }

                  ruv.cpuMicros();
               } else if (var23 == 20) {
                  hfo = 0L;
                  hfp = System.nanoTime();
               } else if (var23 == 79) {
                  double var27 = (System.nanoTime() - hfp) / 1.0E9;
                  double var28 = var27 * 1000.0 / Math.max(1L, hfo);
                  System.out
                     .println(
                        a.c(1761785443, "똙쾷䕾\udb09僊홶汩\ue5db箈\uf125盱賔")
                           + var25
                           + a.d("⢩儂", -86010962, -1766868161)
                           + hgc(var28)
                           + a.d("\ue127飛ሖ谻ޥ脀㭀늽⳪ꘞ⇅", -1929776881, -57602045)
                           + Math.round(hfo / var27)
                           + a.b("绛ܬ跩\u139b頖Ảꓽ\u2d69댠㦒븱䐃쫇即\ud975", 348094196)
                           + hgc(ruv.cpuMicros())
                           + a.c(-508716865, "颖\ue172殧\uf58a縔\uf8b1䋱쬌啛")
                     );
               }
            } else if (var1 > 450 + 80 * hfm.length) {
               for (String var7 : hfn) {
                  hfu(var2, var7, false);
               }

               hfz(var0, hfk);

               for (PlayerEntity var22 : hfj) {
                  hfz(var0, var22);
               }

               hfj.clear();
               hgb(var0, a.d("뺁윲䷤펕堎\udedf撩\ued66猖寧繰萔છ鍾ᤰ鿐▗ꩶ", 403356954, -1726479390));
               hgb(var0, a.b("뾲옕䳗튰奩\udfdb斄\uec7d物\uf886缋蔤\u0bad鉂ᡙ麾Ⓖꭩ㇝랇㹶䐶쪖兀휭嶲\ue45a樃\uf0ef", -421150756));
               var0.player.getInventory().setStack(0, ItemStack.EMPTY);
               hyz.save();
               return true;
            }
      }

      return false;
   }

   static void hft() {
      if (!hfq) {
         hfq = true;
         HudRenderCallback.EVENT.register((HudRenderCallback)(var0, var1) -> hfo++);
      }
   }

   static void hfu(kfx var0, String var1, boolean var2) {
      var0.getByName(var1).setEnabled(var2);
   }

   static vmo hfv(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.c(1701043776, "\ude68ꞑⵋ댨㢬빓Ё趿") + var1);
   }

   static void hfw(MinecraftClient var0, float var1, float var2) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
   }

   static void hfx(MinecraftClient var0, Vec3d var1) {
      Vec3d var2 = var1.subtract(var0.player.getEyePos());
      hfw(var0, (float)Math.toDegrees(Math.atan2(-var2.x, var2.z)), (float)(-Math.toDegrees(Math.atan2(var2.y, Math.hypot(var2.x, var2.z)))));
   }

   static PlayerEntity hfy(MinecraftClient var0, String var1, double var2, double var4) {
      OtherClientPlayerEntity var6 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var7 = new Vec3d(0.0, 0.0, 1.0);
      Vec3d var8 = new Vec3d(-1.0, 0.0, 0.0);
      Vec3d var9 = var0.player.getEntityPos().add(var7.multiply(var2)).add(var8.multiply(var4));
      var6.refreshPositionAndAngles(var9.x, var0.player.getY(), var9.z, 180.0F, 0.0F);
      var6.setBodyYaw(180.0F);
      var6.setHeadYaw(180.0F);
      var6.lastBodyYaw = 180.0F;
      var6.lastHeadYaw = 180.0F;
      var6.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
      var0.world.addEntity(var6);
      return var6;
   }

   static void hfz(MinecraftClient var0, Entity var1) {
      if (var1 != null) {
         var0.world.removeEntity(var1.getId(), RemovalReason.DISCARDED);
      }
   }

   static void hga(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.d("듡쵅䞕\ud9cd刴풙", 1522891369, 1873727226));
      var2.setAccessible(true);
      var2.set(null, var1);
      Field var3 = hlc.class.getDeclaredField(a.c(-830912732, "䝰㻑됓⩿ꆫ✚鵖"));
      var3.setAccessible(true);
      ((Map)var3.get(null)).clear();

      for (String var7 : new String[]{a.c(-1988972275, "녽죒䈆\udc7d垡턈歴"), a.d("첤딋㿟ꆤ⩸곑ᚬ", -1042722861, 1113031431)}) {
         Field var8 = hlc.class.getDeclaredField(var7);
         var8.setAccessible(true);
         var8.setFloat(null, Float.NaN);
      }

      var0.setScreen(new hlc());
   }

   static void hgb(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   static String hgc(double var0) {
      return String.format(Locale.ROOT, a.d("↷堍틂䳧", 2082499842, -1915401068), var0);
   }

   static void hgd(MinecraftClient var0, String var1) {
      System.out.println(a.b("ી獧尿柆\uec57檲탰夗읏䶪", 334564025) + var1 + a.c(915238833, "澒ᙃ鳰") + var0.getCurrentFps() + a.b("뱟얨佭턟", 828357755));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.b("\uf51e貥ٵ頜ᎎ锠", 958788990) + var1 + a.c(112637340, "떶챙䚔\ud8ec"),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
