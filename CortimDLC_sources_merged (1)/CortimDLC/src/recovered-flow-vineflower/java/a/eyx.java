package a;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class eyx {
   static final long eyy = 60L;
   static final int eyz = 6;
   static final String[] eza = new String[]{
      a.c(773155805, "殿ሆ飞ڴ费ெ놁㡱\ua62fⲆꭖ內\udff4䙟찛"),
      a.d("\ue5b7鰎ᛖ袼̱藜㾌뙿⠻ꊍ╗\udf6f凼졗䈓", -1713857707, 676429440),
      a.c(2066134992, "랲츋䓓\udab9儴ퟙ涌\ue465稺\uf083睇赪Ϲ驒ဖ"),
      a.c(-2126358501, "塹⇀\uab18㕲뻿㠖艛\u0bad门Ὀ颌抡\uec32疙\uffdd"),
      a.c(-1873148842, "Щ綐\uf748椢\ue2af摆\ude03埧즩䌏쓈㺾끤⧕ꏄ╱鼤ტ"),
      a.c(1260921856, "⑿巆휞䥴싹䐐﹕瞱\ue9ff捙\ue49eỨ進ঃ莒Խ뽬ゴ"),
      a.c(943375943, "옩뾏㕋\uab2f⃭ꙏᰝ閰ண脐ۖﳽ牴\uebdb憁"),
      a.d("㝜仺쐾婚톘场\ued68擅齃火\uf7b9\u0dcd茔᪹邽ᘒ걃⎛", -1570280711, -1892459050),
      a.b("㾿䘙쳝効\ud97b忙\ue58b氦\uf226碒ｓի询ቍ頗", -1962721327),
      a.b("퍡\uaacf‑빡㖼덍ॗ肬Ự鑙Ꮠ\ue9e8机ﺘ瓒\uf266䡪잦嵑", -778841340),
      a.b("\ue0a5餋Ꮥ趥ٸ肉㪓덨ⴴꞝ—\uda24哶쵉䜕쇸篭\uf47f滑\ue8c4", 2012537031),
      a.c(-1057257160, "襝\uf0f3稭\ue45d澀\ue971卫\uda90䓌칥䧬돔㴆꒤⻮ꡚቑ鶚ܾ"),
      a.d("ሕ殻\ue165缕\uf4c8爹젣䇘\udf84唭튤⢔Ꙇ㿹떥㍈襝ۈ鱡ᨧ", -1569195355, -1802049326),
      a.d("ￎ虠ಾ鋎ᤓ鿢◿갚㉄룴㼿앍䯙툦塷\ude93擛\ueb57熠\uf7eb縋", -174133769, -454487462),
      a.c(1836650660, "Ⴢ楬\ue3b2緂\uf61f烮쫱䌂\udd4f培퀲⩊ꓖ㴣띪ㆌ"),
      a.d("툱ꮟ⅁뼱㓬눝ࠂ臸ᾪ锌ዟ\ue8a5春\uffd0疙\uf37f", 1511790504, 1594344959),
      a.d("\uecf4镚ᾄ致\u0a29賘㛁뼹ⅬꮕⰂ황墩", 628019952, -1798095233),
      a.d("께흶嶨쏘䠅컴瓮ﴘ捔\ue9fa湪鑟᪒茴", 1447675886, 373451086),
      a.b("塄⇪ꬴ㕄뺙㡨色உ闕ὼ颽招\uec0d痡\ufff6礝썅", 1827887139),
      a.b("क़烶﨨摘\uef85楴퍠媊쓔为즷㏞봛⓽껪⠁鉙", -732821185),
      a.c(-473679258, "㨁䎯쥱圁\udcdc娭\ue022槁\uf792紻\ufaef\u008d蹒ឤ鶳᭘ꄀ"),
      a.c(1250566233, "‡妏퍑䴡웼䀍拓珮\uedb0朙\ue093᪦鑫\u0dcd"),
      a.d("ಅ甫\ufff5憅\uea58沩횦彔섚䮸챲㘄룚℠ꬷⷜ鞄", 1224355336, -75488534),
      a.b("̊窧\uf06e渄\ue5d9捿\ud970僙캔䐡쏧㦊띐\u2ef6ꓸ≔須៑赥ଅ苅\uf899瘮\uede8殘\ue11e壬횵䱂", -912522396),
      a.c(990709497, "ڗ缺\uf5f3殙\ue044曢\udced啄쬉䆼왺㰗닍⭫ꅥ⟉鶕ቌ裸ຘ蝜ﴈ玵\ue86b済\ue483嵱패䧟"),
      a.c(721109836, "䌟㪲끻⸑ꗌ⍪饥\u10cc躁д菲禟\uf745滣\ue4ed扇\ud814埘쵰䬫식뢛㘅귭⮕ꅗᣉ零ఞ討Ƶ､"),
      a.c(-985709079, "䖺㰗뛞⢴ꍩ●鿀ᙩ蠤ʑ蕗缺\uf1e0框\ue248擢\udeb1兽쯕䶎쑸븾゠ꭈⴰꟲṬ遐\u0abb貫ܐ療"),
      a.c(1055358175, "粌ԡ迨ᆂ驟᳹꛶⽟넒㮧뱡䘌죖兰\udb7e巔\ue787桋\uf2e3璸﵎蜈খ鉾ᐆ黄❚ꥧ㎍떝㸦샷"),
      a.c(1103242283, "⑸巕휜䥶슫䐍︂瞫\ue9e6捓\ue495Ỹ逢\u0984莊Ԡ뽳タꨗⱌꖺ\udffc兢쪁䳺옦羮\uf191歹\ued69曒頃"),
      a.d("鳲\ue55f澖\uf1fc稡ﲇ䚈켡公\udbd9尟꙲⢨넎㬀붪߹蠵ኝ铆ᴰ杶\ue9e8爋\uf470纬윤䤘폳嗣\ude58₉", -278567405, 179632818),
      a.d("胥賂玁\uedeb昶\ue090媟팶䵻쟎䀈멥㒿괙✗ꆽᯮ鐢ຊ裑ħ筡\uf5ff渟\ue86b抾\udb1e啢쿻䦵쉇㲞뛑", -171015507, 921109018),
      a.b("绁ݬ趥Ꮟ頒Ẵ꒻ⴒ덟㧪븬䑁쪛匽\ud933徙\ue5ca樆\uf0ae盵＃蕅\u0bdb逻ᙏ鲚┺ꭆ㇜랑㱣슺䣵", -83722605),
      a.c(1455659978, "鮘\ue235棼\uf696絋ﯭ䇢졋嘆\udcb3孵ꄘ⿂뙤㱪뫀\u0093轟ᗷ鎬ᩚ怜\uee82畢\uf316秃쁣丟풄勈\ud93a⟣궬"),
      a.b("㊳䬞쇗徽푠勆\ue8c9慠Ｍ疘\uf25e࠳蛩\u1f4f镁Ꮻꦸ♴볜㪇덱줷䞩\udc49娽탨楈\ue734綨ﯣ瀑軈҇", 1255617249),
      a.c(1573259651, "৳灀廒擷\uef37榍폗婨쑼什줝㍢붨␞긐⢠鋮ᴿ螚"),
      a.d("吻\u2d9cꝂ㤳닸㑘踚߾馶ጆ钉溶\ue06c私\uf38b畽켹䂠\uda50将헿꾡ℎ명㲾뙵࿑", -478533927, 487486094),
      a.c(493720107, "鉉\uebee愰ａ璊\uf22a䡨소忄해勻꣄☇뾱㗿댓ॏ蛑ᰦ驭ᎍ"),
      a.c(1604825227, "냨쥏䎑\udde0嘫킋櫉\ue32d絥\uf7d5灚試ҿ鴍\u175e醭⮡ꐴ㺝룛"),
      a.c(1914491472, "툴ꮓ⅍뼼㓷뉗ࠕ臱Ᾱ锉ኆ\ue8bb普ￊ疞\uf332䤹웲屖"),
      a.d("쨦뎁㥟Ꜯ⳥ꩅဇ駣ޫ贛ઔ\uf0ae繨\ue7c2涚\ueb7d兯\udefa䑓숕", 1101015236, 1022157441),
      a.d("⩎叩\ud937䝆첍䨭\uf06f禋\ue7c3浳\ueafc\u10c6鸀\u07b7跼ୈ녃㺈ꐬ", -775457528, 1403412258),
      a.c(-1259484363, "쭚닽㠣Ꙓ\u2d99ꬹᅻ颟ۗ豧௨\uf1d3缀\ue6a2泷\uea1a偏\udf85䔬썫䫗ヂ빫▭"),
      a.d("뀉즮䍰\udd01囊큪樨\ue3cc綄\uf734炻誀ё鷯ឹ酑⬝ꓚ㸢렷㇚䮜", 2104518826, -628434750),
      a.c(-931677795, "맾쁙䪇퓶弽\ud99d揟\uea3b瑳ﻃ祌荷ඨ鐖Ṃ颤⊷괢㞋뇍"),
      a.d("\ue5b0鰗ᛉ袸ͳ藓㾑뙵⠽ꊍ│\udf39処졟䈛쓹纻\uf162殘\ued88摲ḩ邔\u0b0e贵߾빚", -1936319473, -2008286765),
      a.d("픔겳♭렜㏗땷༵蛑ᢙ鈩ᖦ\uef9f慃\uf8ff犮\uf455世쇐嬼\udd2c哖⺍ꀰ㮪붑㝚軾", 904040836, -498514692),
      a.c(1717678244, "냊쥭䎳\uddc2嘉킩櫫\ue30f絇\uf7f7灸詁Ҟ鴬\u1777醇⯃ꑑ㺼룻ㄈ䬖엡帪\ud842"),
      a.c(-1864955464, "\u09da災画擒\uef19榹폻娟쑗仧쥨㍞부\u243e깢⢟鋔ᵂ螵Ǿ蠞"),
      a.d("⎙娾탠云앚䏺隸灜\uee14撤\ue32bᤜ韑\u0e7f营˂룐㝅귬⮪", -1170917016, -720823662),
      a.d("界೫蘵ᡄ鎏ᔯ꽭⚉룁㉱뗾俌섖墨틡吁\uee59憔ךּ紶\uf485軎j", 621400466, -511073090),
      a.b("\ue2cd魪ᆴ迅Ў芮㣬너⽀ꗰ≿\ud84d嚟켶䕡쎌秎\uf655沢\ueae9按", -478551377),
      a.c(-55776814, "\ue9bf逘᫆蒷ོ觜㎞멺\u2432꺂⤍팾巭쑙不죮狵ﵪ柕\ue18a桯ሹ鳐݅脠௦"),
      a.d("\udf90\ua637⳩늘㥓뿳ֱ豕ም颭ἢ\ue511毂\uf269砽ﻁ䓚쭖凼\ud7aa幖␑\uaaffㅪ뜏㷉", 830227825, 220830348),
      a.d("鍎\ueae9怷﹆疍\uf32d䥯삋廃푳叼꧌✐뺦㓢눊ࡈ蟖ᴡ魪ኊ", -811271738, 1948543722),
      a.b("엿뱘㚆ꣷ⌼ꖜ῞阺ࡲ苂Սｽ熭\ue812扎\ue4a3庵턨䮖췇䐹㹴낐⬅굠➦", 583976338),
      a.b("\uf5d1豶ڨ飙ጒ閲⿰ꘔ㡜달㕣콍䆏\ud83a剣풊溘\ue10d箤\ufde2", -194841166),
      a.c(-2079037106, "椭ႊ驔Х迮ॎ댌㫨꒠⸐ꦟ厱\udd64䓎캇䡨\uf264緱\ue758愞"),
      a.b("ㅿ䣘숆屷ힼ儜\ueb5e抺ﳲ療\uf1cd\u0be0蔥Პ雓ဥ꩹◤뼔㥂낻쫥䑊\udfc1姺팱檕", 1924215059),
      a.c(-330742117, "䛺㽝떃⯲ꀹ⚙鳛ᔿ護Ǉ虈籥\uf2a9欙\ue141枧\udde4刭죑仄윩뵯"),
      a.b("\u0a54珳來杜\uec97樷큵妑쟙䵩쫦ニ븛➿귿⬚酒Ẏ落Ȯ讝\uf1d6署", 658246196),
      a.b("熝࠺苤Ვ非ᇾꮼ≘밐㚠넯䬂엒屶혶僙\uea93敟ﾵ禥\uf05f訄ҹ鼣ᤘ鏓⩷", 153514481),
      a.c(-1907942152, "Ვ攲\uefec熝節糶운佐턘宨\udc27☍ꣁㅴ묵㷒蟟ࡗ鋿ᒶ鵓\ue715槺\uf26f琊ﻌ"),
      a.c(931609648, "㱓䗴켪兛\uda90尰\ue672澖\uf1de筮ﳡۈ蠉ᆯ鯯ᴈꜚ⢏눦㑠")
   };
   static volatile boolean ezb;
   static final AtomicInteger ezc = new AtomicInteger();
   static volatile int ezd;

   eyx() {
   }

   public static boolean done() {
      return ezb;
   }

   public static String progress() {
      return ezc.get() + a.c(204724958, "\udaf0") + Math.max(ezd, ezc.get());
   }

   public static int loaded() {
      return ezc.get();
   }

   public static int total() {
      return ezd;
   }

   public static float fraction() {
      int var0 = ezd;
      return ezb ? 1.0F : (var0 <= 0 ? 0.0F : Math.min(1.0F, (float)ezc.get() / var0));
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void run() {
      if (!ezb) {
         long var0 = System.currentTimeMillis();
         ExecutorService var2 = Executors.newFixedThreadPool(6, var0x -> {
            Thread var1 = new Thread(var0x, a.d("롷쇬䬼핕廇\ud864执\ueb94痜ｮ碾苞ఞ閤", 3439610, -1981168699));
            var1.setDaemon(true);
            return var1;
         });
         boolean var14 = false /* VF: Semaphore variable */;

         label94: {
            try {
               var14 = true;
               LinkedHashSet<String> var3 = new LinkedHashSet<>(List.of(eza));
               var3.addAll(ezg(var0));
               ezd = var3.size();
               ArrayList<Future<?>> var4 = new ArrayList<>();

               for (String var6 : var3) {
                  var4.add(var2.submit(() -> {
                     try {
                        eul.bytes(var6);
                     } catch (Throwable var2x) {
                     }

                     ezc.incrementAndGet();
                  }));
               }

               for (Future var19 : var4) {
                  long var7 = 60000L - (System.currentTimeMillis() - var0);
                  if (var7 <= 0L) {
                     var14 = false;
                     break label94;
                  }

                  try {
                     var19.get(var7, TimeUnit.MILLISECONDS);
                  } catch (Throwable var15) {
                  }
               }

               var14 = false;
               break label94;
            } catch (Throwable var16) {
               System.out.println(a.c(75486110, "폟ꩳ₊뻸㔷돃\u09ff聳Ṽ铏ጋ\ue979枭︍瑉\uf2b3䢴윶嶂\udbc8删⡱ꛗ㴇묦\u31ed") + var16);
               var14 = false;
            } finally {
               if (var14) {
                  var2.shutdownNow();
                  ezb = true;
                  System.out
                     .println(
                        a.b("\u0c64痈Ｑ慃\uea8c汸홄忈쇖䭵첦㛁렇↱ꮱⴒ靊ᢟ舩ѥ跋", 1628507178)
                           + progress()
                           + a.d("\ue3b2驊႞躡", -1966466613, -234423715)
                           + (System.currentTimeMillis() - var0)
                           + a.b("㾂䙾첳", 444678049)
                     );
               }
            }

            var2.shutdownNow();
            ezb = true;
            System.out
               .println(
                  a.c(-1624167542, "⯄剨\ud891䛣촬䯘\uf1e4硨\ue676法\ueb06ᅡ龧ؑ谑લ냪㼿ꖉ⏅ꩫ")
                     + progress()
                     + a.c(-1750403267, "\uf719軡е騊")
                     + (System.currentTimeMillis() - var0)
                     + a.d("踪\uf7d6紛", -1681195175, 1905029456)
               );
            return;
         }

         var2.shutdownNow();
         ezb = true;
         System.out
            .println(
               a.b("⢞儲\udbcb䖹칶䢂\uf2be笲\ue52c澏\ue85cሻ鳽Ջ轋২뎰㱥ꛓ\u209fꤱ", 650782928)
                  + progress()
                  + a.d("뢊셲䮦햙", -841421513, -1820109415)
                  + (System.currentTimeMillis() - var0)
                  + a.d("끀즼䍱", -528082445, 1656269200)
            );
      }
   }

   static Set<String> ezg(long var0) {
      LinkedHashSet var2 = new LinkedHashSet();

      try {
         JsonObject var3 = ezh(a.d("ꗂ\udc7f嚰죟䌀얠翮\uf615桚\ue2b7攢齔ᆉ蠹ɷ蓐㻛넓⮼귬", 22812734, 2056961419));
         if (var3 == null || !var3.has(a.b("腩\uf8c5爇\uec7e枷", 1745060101))) {
            return var2;
         }

         var2.add(a.b("ᗊ汷\ue6b8磗\uf308疨쿦䘝\ud852势픪⽜ꆁ㠱뉿㓘軓ě鮴ᷤ", 384112061));

         for (JsonElement var5 : var3.getAsJsonArray(a.d("\ue1e3顏ኍ賴ܽ", 1110167293, 1224552306))) {
            if (System.currentTimeMillis() - var0 > 30000L) {
               break;
            }

            String var6 = var5.getAsString();
            var2.add(a.c(92248170, "頃\ue1be歱\uf51e绁\uf861䈯쯔喛\udf76") + var6 + a.b("錦\uead3怙ﹴ疢", 359568141));
            var2.add(a.d("¤礙\uf3d6涹\ue666惆\uda88即촼䟑쁙㨴듾ⵗ꜋⇫鯸", -725425680, 1036247334) + var6 + a.c(292516492, "犦\u0b49膄ῼ"));
            JsonObject var7 = ezh(a.c(-345977182, "컋띶㶹ꏖ⠉꺩ᓧ鴜͓覾") + var6 + a.c(118349066, "\udd21ꓔ⸞끳㮥"));
            if (var7 != null) {
               ezi(var7, var2);
               if (var7.has(a.b("ᥭ惃\uea1d瑭ﾰ", 1686968606))
                  && var7.get(a.c(756998073, "\udfcaꙤⲺ닊㤗")).isJsonObject()
                  && var7.getAsJsonObject(a.c(-622626688, "磳ŝ讃ᗳ鸮")).has(a.b("\ue9af逑ᫎ蒷", 1447946693))) {
                  String var8 = var7.getAsJsonObject(a.d("뗻챕䚋\ud8fb匦", 181884249, -216473391)).get(a.b("\ue508鲶ᙩ蠐", 1691805026)).getAsString();
                  var2.add(a.c(-1773309975, "澙ᘷ鳩ʙ襄ྵ") + var8 + a.d("\ueadc錩᧠螆", -308391678, -610354188));
                  var2.add(a.d("᱄旪\uef34煄滋籨", -1552289242, 42397202) + var8 + a.b("\uf17f袍Ƀ鱶", -1776029355));
               }
            }
         }
      } catch (Throwable var9) {
         System.out.println(a.c(1525932562, "\ue26d鯁ᄸ轊҅艱㡍뇁\u2fddꕠ⊯\ud8c0嘟쾿䗱쌊祕\uf6d7氨\uea7c掑ᧇ霠ತ諀\u001e릺㟼괃⭗ꃩ帻푺䶂쮎䄥") + var9);
      }

      return var2;
   }

   static JsonObject ezh(String var0) {
      try {
         return JsonParser.parseString(new String(eul.bytes(var0), StandardCharsets.UTF_8)).getAsJsonObject();
      } catch (Throwable var2) {
         return null;
      }
   }

   static void ezi(JsonElement var0, Set<String> var1) {
      if (var0 != null && !var0.isJsonNull()) {
         if (var0.isJsonObject()) {
            for (Entry var3 : var0.getAsJsonObject().entrySet()) {
               ezi((JsonElement)var3.getValue(), var1);
            }
         } else if (var0.isJsonArray()) {
            for (JsonElement var4 : var0.getAsJsonArray()) {
               ezi(var4, var1);
            }
         } else if (var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isString()) {
            String var6 = var0.getAsString().trim();
            String var8 = var6.toLowerCase(Locale.ROOT);
            if (var8.endsWith(a.d("\ue49f鵰ួ觅", -1693094604, -1134261887))
               || var8.endsWith(a.b("캼띉㶀ꏦ", -646132074))
               || var8.endsWith(a.c(-221285030, "異ಂ虌\u1879"))
               || var8.endsWith(a.b("⸣埓\udd08䍹", 985738761))
               || var8.endsWith(a.c(-1269268093, "膨\uf85d犗\uecfa本"))
               || var8.endsWith(a.d("\uef82陪Ძ苝अ", -1978794281, -499117698))) {
               while (var6.startsWith(a.d("꯴", -709828656, -1070304246))) {
                  var6 = var6.substring(1);
               }

               if (var6.startsWith(a.c(-2110123573, "ᆨ栓\ue2c3粪\uf725"))) {
                  var6 = var6.substring(5);
               }

               var1.add(var6.startsWith(a.b("瑏ෲ蜽ᥒ銍ᐭ깣➘맗㌺", 458257446)) ? var6 : a.b("䵎㓳븼⁓ꮌ\u2d2c面ẙ胖\u0a3b", -180335321) + var6);
            }
         }
      }
   }
}
