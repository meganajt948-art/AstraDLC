package a;

import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.PlayerInput;

final class fgv {
   private static final String fgw = a.d(
      "᳦故\uef9b熴嗢粅웒伤텰寇\udc05♧ꢷㄔ묉㶱蟣࠳銘ᓜ鴨\ue774槇\uf258琩ﺷ䜈쥃厯헤帙ꃊ⪑댯㕰뿃\t詧ವ锏Ὓ憰\uebe4氜\uf68a碢섾䮋췃嘙\ud86c⊬\uab08ⵞ랿㦠艆ҁ軴ᜢ馎\ue3dd搜\uee7c炼更䍚여侣퀊廚\ud8b7Ⅰꯒ㖉빼㰱芗ୃ锾ῳ駜\ue211泉\uf6b3罨\ufdc9䟇져",
      644535152,
      656789428
   );
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
   private static int fhi = 75;
   private static int fhj = 74;
   private static int fhk;

   private fgv() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      fhe = var1;
      if (var0.field_1724 != null && var1 > 10) {
         var0.field_1724.method_36456(0.0F);
         if (!oxw.busy()) {
            var0.field_1724.method_36457(0.0F);
         }
      }

      switch (var1) {
         case 1:
            vzz.simulated = fgx::contains;
            fhz(a.c(192891683, "䭨㋭렿♕궾⬬酽ᢗ蛏\u0c64"), false);
            fhh = fhz(a.b("䓅㵂랆⧳ꈷ⒑黸ᜤ襲ϟ萙繿", 255870106), true);

            for (vmo var3 : fhh.getSettings()) {
               if (var3 instanceof vlq var4 && var4.getName().equals(a.b("ꞓ\ude3e哥쪗䅈쟽禴\uf452樊\ue0b7杦鵩Ꮐ詸&蛝", 763143074))) {
                  var4.set(fhi);
               } else if (var3 instanceof vlq var5 && var5.getName().equals(a.c(-1616320011, "\uede9鑿Ờ肢\u0b0e覫㟪븜‴ꪇⴤ"))) {
                  var5.set(fhj);
               } else if (var3 instanceof vkl var6 && var6.getName().equals(a.b("쯘눻㢐ꛪⴿꮌᗏ頡ٿ貱ଘ\uf167箥\ue603汗\uead6傖\udf3c䖋", -2063347750))) {
                  var6.set(false);
               } else if (var3 instanceof vkl var7 && var7.getName().equals(a.d("厍⩣ꂻ㺷땨㏝趔w騺ᓩ鍈椰\ue7e2繗\uf401狾", 184781602, -1770857312))) {
                  var7.set(false);
               }
            }

            fia(var0, a.d("\uebf4鉃ᢜ蛥ഺ讉㇑렡☻곙⬌텺復옇䱋쪭烯", -1425560337, -956283027));
            fia(var0, a.c(312132122, "쉛믩ㄺ꽈⒙ꈿᠸ醎\u0fdf蕱ʱ\uf885瘲\uefb0新\ue313奋회䰥쩮䎞㧚띦Ⲻ\uaac3⁗駲ឥ赒ଓ肴繱\uf46a涝\uebc9慨"));
            fia(var0, a.d("馰\ue002櫑\uf4a3署倫䏓쩥吴\ude9a奚ꍮⷙ둛㹛룹ʤ赠្醄ᡠ戤\uec8a睝\uf123箼숙䱎횹僸\udb5f▚꾁㙶뀢㪃", 627316700, -1842508243));
            fia(var0, a.c(-578724654, "岩┞꿁ㆸ멸㳎蚄ོ酦ᮓ鱋昘\ue8ed煑דּ緡잿䡸틒咄\udd74Ꜭ⧘뉏㐷뻫݇褀"));
            break;
         case 5:
            fib(var0);
            break;
         case 10:
            fia(var0, a.c(-1674384711, "\uead2鍬ᦶ蟃ఇ諤プ뤕"));
            fia(var0, a.d("ᥖ惺\uea38瑁ￛ礸썼䪘퓛幧\ud9b6⏁굓㒧뻿㠔艆ඊ霴ᄼ颫\ue2c9氩\uf7b0燈ﬂ䊧쳵嘑퀜宱ꕰ⽨뚇ド멤\u05fb过ऐ邦\u1af2搅\uee47槥\uf335絖쓋两졦县\uddc0✓꺥⣾눶㱋蟰Ĺ譗ነ", 65477195, 50463560));
            fia(
               var0,
               a.d(
                  "橾Ꮢ餐ݩ賳ਐ끔㦰ꟳⵏꪞ僩\ude7b䞏췗䬼\uf16e红\ue41c戔\ueb83釡ἁ蒙ˡ蠨ㆈ뿒┿ꍵ⣛혁尙엵䎵쥓皚ﳶ稹\ue3c0槒ᜧ鵳᫉耘\u0e78랸㴎뭓\u20cc껧吡\udd8d寖섭併\uf4f4爜\uf878憲\uef0f镖ኬ飇ش辉㗛댰㥶ꛌⰅꩳ叢\ud935䝆첥䫿\uf010秛\ue7e5洮\ueb78郀ḗ葱ඳ謇ㅄ뻵ⓩꉄ⮒퇯弅쒊䋐젖癴ﾲ攁\ue311森ᛲ鱏֊菠ऩ뛖㲎먷‵꧓圎\udd52嫿삶乎\uf79b緯וּ悌\ueecc鐬ቺ鯟ŀ轨㒪닥㡉ꆂ⾦핿劁\ud8de䘵챱痚\uf347礽\ue6eb気\uea64鎕",
                  -809739439,
                  -655085098
               )
            );
            var0.field_1724.method_31548().method_61496(0);
            break;
         case 20:
            fho(var0, true);
            break;
         case 40:
            fhn(var0, fhj);
            break;
         case 70:
            fho(var0, false);
            fhr(var0, a.d("汒", 551280286, 22786700), Items.field_8802);
            fht(var0, a.c(-785915601, "\ue16f"), 12, Items.field_49098, 4);
            fht(var0, a.b("䡌", -1565177844), 12, Items.field_8107, 10);
            fhv(var0, a.c(-759465548, "秴"));
            fhx(a.c(855086810, "隚"));
            break;
         case 80:
            fhp(var0, a.b("냩쥜䎈\uddf2嘣킃櫃\ue335絸\uf787瀊詶Һ鴍ᜊ釭⮠", -288182123));
            fia(
               var0,
               a.c(-270603253, "\uec5e闲ἰ腉\u0ad3谰㙴뾐⇓\uab6fⲾ훉塛솯䯷촜睎\uf882戼\ue434涣េ餡ʸ蓀ช랯㧽ꌙ└꺹偸\uda60䎏엁佬\uf0f3竏ﰘ斮\ueffa鄍\u1b4f鳭ؽ衞㇃묬㵮ꚷ⣈툛宭\uddf6䜾쥃狸\uf431繟\ue798")
            );
            fia(var0, a.c(626761421, "麘\ue734淶\uf38f砕ﻶ䒲쵖匕\ud9a9幸ꐏ⪝덩㤱뿚ֈ詄ჺ雲ὥ攇\uebe7灾\uf606糌앩䬻퇟埒\udc7a⊾ꢦㅉ뜇㶪舵ࠉ軞ᝨ鴼\ue3cb榉\uee2b瓻滛䌅짫侯푴娆ꃀ⥚꼤㗂뮗;蛴ೋ锎"));
            fia(
               var0,
               a.b(
                  "퉤ꯈℊ뽳㓩눊ࡎ膪Ῡ镕ኄ\ue8f3晡ﾕ痍\uf326䥴울将\uda0e厙⧻ꜛ㲃뫻〲覒߈鴥᭯郁減\ue403緯ﮯ煉캀䓬숣寚퇈꼽╩ꋓ㠂뙢ྡྷ蔔͉飖\u16fd\uec3b斗\ue3cc礷\uf76f䳮쨆䁢\ud9a8圕ⵌꪶ⃝븮㞓跁ପ腬Ỗ鐟ቩ\uebf8愯｜璿\uf2e5䠊쇁忿픴卢⣚꘍㱫떩㌝襞ۯ鳷ᩙ鎉槦\ue722粒龜瀁츾䟣\udd1d孆킭껥\u244e뷟㮬녫ຕ蓎Ƚ顳ᇝ\uef13敉\ue2b1磺\uf64a俒엠䍨\ud898囍ⰹꩣ⏒뤒㝲貤ૹ耆ᦌ韫洺\uea8c惄︷瑚췚䬆셻庤푒则⯰ꖼ㭱냊㚘豧Ȳ龛ᅝ霥泸\ue249硦\uf1ef瞷촉䋒\udc8f娡큲ꦒ✒뵱㪯끀ง螹ᷮ魘ႄ\ueef3搱ﶓ篛\uf118伥쒯䈋\ud85a冴\u2ffdꔗ⋈룴㘩辄\u05ce茧ᤸ雾汎\uea52掃倫",
                  1512886984
               )
            );
            var0.field_1724.method_31548().method_61496(0);
            break;
         case 100:
            fho(var0, true);
            break;
         case 110:
            fhn(var0, fhi);
            break;
         case 140:
            fho(var0, false);
            fhr(var0, a.b("燲", 1343451569), Items.field_8802);
            fhs(var0, a.b("ꬖ", -1042961579), 5, Items.field_8634, 4);
            fht(var0, a.c(1411108673, "켂"), 12, Items.field_8543, 7);
            fht(var0, a.b("ᧄ", 565320071), 12, Items.field_8107, 32);
            fht(var0, a.c(663858111, "\uabfc"), 12, Items.field_8634, 0);
            fhu(var0, a.d("昰", -1421646715, -579403018), Items.field_8831, 2112);
            fhw(var0, a.b("캊", 654560969));
            fhx(a.c(-154456710, "ⴹ"));
            break;
         case 150:
            fhp(var0, a.d("\ue7bc鸉ᓝ誧Ŷ蟖㶖둠⨭ꃒ❟\udd23可쩘䁟울糵", 1200770892, 659531916));
            fia(var0, a.c(-1958718617, "匲⪞ꁜ㸥떿㍜褘ü麿ᐃ鏒榥\ue737练\uf49b牰젢䟮\udd50存틏ꢭ♍뷔㮬녦ࣃ蚑ᱵ驸ᇕ\uef14攌ﳣ窭\uf000侟얣䍴\udac2傖\u2e61ꐣ⎁륑㜲躯р舂\u19db鞤海\ue4c1抚\uf852瘯추䭝섳壴"));
            fia(
               var0,
               a.d(
                  "㺂䜮췬厕\ud80f廬\ue4a8浌\uf30f禳﹢Е誇፳餫῀ꖒ⩞냠㛨뽿씝䯽큥嘝\udcd4整\ueb2e燃\uf789簧苽ࣥ鄉ᝉ鶯≦ꠊ⻅뜼㴮䏛즏丵퓤媄\ue344槲\uefaf琰福Ý襱༪闑ᮉꀈ⛠겄㕎믳솪䙐찻勈\udb75愧\ue7cc涊\uf230磹ﺏܞ跉Ꮊ顙ḃꓬⴧ댙㧒뾄쐼䫫킍奏\udffb斸\uea09瀑\uf6bf罯蔀\u0bc4遴ᘨ鳧⋘ꬅㇻ랠㱋䈃좨儹흊嶍\ue273栨\ueedb璕ﴻϵ覯๗鐜᪬ꌴ⤆꾎㑾먫샟䚅켴嗴\udb94恂\ue61f泠\uf56a笍臜٪谢ዑ颼ℼ\ua7e0\u2d9d뉂㢴뻿윖䥚힗尬\uda7e悁\ueed4獽ﶻ篃耞ຯ钀ᴉ魑⇯긴ど뛇㲔䕴쯴冗홉岦\ue2e1歟\uf108瞾ﱢȕ裗ᅵ霽᷾ꏃ⡉껭㒼뵒쌛䧱츮吒\udacf换\ue928濁\uf5de稘肨ڴ轥ᔲ",
                  1030380689,
                  -1427676481
               )
            );
            var0.field_1724.method_31548().method_61496(0);
            break;
         case 170:
            fhn(var0, fhi);
            break;
         case 200:
            fhr(var0, a.b("ꢈ", -557143862), Items.field_8802);
            fht(var0, a.b("놓", -651972143), 12, Items.field_8543, 7);
            fht(var0, a.d("녭", 2072286785, -878565522), 12, Items.field_8107, 32);
            fhu(var0, a.d("牱", 966105098, -1756304839), Items.field_8831, 2176);
            fhw(var0, a.b("ギ", 408367340));
            fhx(a.d("衫", 332097813, 1909317948));
            break;
         case 210:
            fhp(var0, a.c(1636273031, "读\uf24e碚\ue6e0洱\ueb91凑\ud827䙪첕䬘녤㾨ꘟⰘ\uaaffႲ"));
            fia(var0, a.b("ᤞ悲\uea70琉ﾓ祰쌴䫐풓帯\ud9fe⎉괛㓯뺷㡜舎ෂ靼ᅴ飣\ue281污\uf7f8熀תּ䋯첽噙큔对ꔸ⼠뛏め먬ֳ辏क़郮᪺摍\uee0f榭\uf37d紞쒃乩젮古", 1333467461));
            fia(
               var0,
               a.c(
                  1838312476,
                  "沰ᔜ鿞Ƨ訽ೞ뚚㽾ꄽ⮁걐嘧\ud8b5䅁쬙䷲\uf7a0硬\ue2d2據\ued4d霯\u19cf艗Я軦㝆뤜⏱ꖻ⸕탏嫗쌻䕻쾝灔器糷\ue50e漜ᇩ鮽ᰇ蛖ࢶ녶㯀붝☂꠩勯\udb43崘쟣䦻\uf23a瓒ﺶ杼\ue9c1鎘ᑢ鸉ú襇㌕뗾㾸ꀂ⫋경唬\udffb䆈쩫䰱\uf6de缕\ue12b毠\uedb6阎ᣙ芿\u0b7d跉㞊렻∱꒑ⵀ휪姣숅䑚컚炧葉揄\ue589渶ၮ高͌蕬\u0fe8끋㨑벾⛵꼋净\udb96屮옹䢟\uf15d笩\ufdea昛\ue803鋭ᒽ鴒ߖ覦㉺됵㻊ꜗ⤩폲呙\ude11䃺쫫獘\uf59f羡\ue07a櫉\uec87镩ἧ臽\u0a45谎㛾룦℔ꮜⶬ홹壍슗䭦촦瞆\uf850戍\ue4b2溸ᜟ駎θ葰ໃ낮㥮ꌲ▏깐偦\udaad䌄셈䮅\uf5fe縬\uf893拆\uef2f镩ῑ頌ɽ賒㔛뽃㦽ꏦ⠻틕咆\udd57䜀"
               )
            );
            var0.field_1724.method_31548().method_61496(0);
            break;
         case 230:
            fhn(var0, fhi);
            break;
         case 260:
            fhr(var0, a.c(1014080994, "ꖧ"), Items.field_8162);
            fht(var0, a.b("ꝫ", 1308010286), 12, Items.field_8543, 7);
            fht(var0, a.d("꾺", -1905158281, 1744844936), 12, Items.field_8107, 16);
            fhw(var0, a.c(1294228714, "岯"));
            fhx(a.d("ଐ", -520123174, -1692956785));
            break;
         case 270:
            vzz.simulated = null;
            fgx.clear();
            System.out
               .println(
                  a.d("朖Ằ鑸ਃ臜ݤ뵲㓗ꪙ‾\ua7ea巏", -735804971, -1097800019)
                     + (fhf == 0 ? a.d("ү紏\uf7ce榿", -603285068, -2053006001) : a.b("伡㚗뱌∸ꦃ⼺", -1533784223) + fhf + a.b("렋", 21542947))
               );
            return true;
      }

      if (var1 > fhk && var1 < fhk + 8 && var0.field_1724 != null) {
         System.out
            .println(
               a.b("ఐ疶ｾ愅\ueada汢홴忑", 1746537594)
                  + var1
                  + a.d("⧩偂\udad3䒵콤䧟\uf3c8", -826878956, -658571840)
                  + oxw.busy()
                  + a.b("중냨㨲ꑌ⾑ꥹ", 602130743)
                  + var0.field_1724.method_6047()
                  + a.c(1647239394, "\ue0ca餸ᏽ趋ٝ胰㪾대")
                  + var0.field_1724.field_7498.method_34255()
                  + a.d("Ẕ杵\uedbf珓\uf813纩쒯", 1263301123, 1747872944)
                  + var0.field_1724.method_36455()
            );
      }

      return false;
   }

   private static void fhn(MinecraftClient var0, int var1) {
      fhc = 0;
      fhd = 0;
      fgy.setLength(0);
      fgz = true;
      fhk = fhe;
      fhh.onKey(var0, var1);
   }

   private static void fho(MinecraftClient var0, boolean var1) {
      byte var2 = 87;
      short var3 = 341;
      if (var1) {
         fgx.add(Integer.valueOf(var2));
         fgx.add(Integer.valueOf(var3));
      } else {
         fgx.remove(Integer.valueOf(var2));
         fgx.remove(Integer.valueOf(var3));
      }

      var0.field_1690.field_1894.method_23481(var1);
      var0.field_1690.field_1867.method_23481(var1);
   }

   private static void fhp(MinecraftClient var0, String var1) {
      fia(var0, a.c(862828649, "렐솣䭵프废\ud84e戸\uebf7疇［磡芅ఊ闯ᾡ饁⌆곧"));
      fia(var0, a.b("Ʝ\ude0c哖쪣䅧임綷\uf475", -150362151));

      for (int var2 = 0; var2 < 9; var2++) {
         fia(var0, a.d("먼쎐䥒휫岱\uda52怖\ue9f2瞱ﴍ竜肫ู韍ᶕ魾ℬ껠㑞뉖㯁䆣콃哚튢塨\ue1cd澟\uf57b獶", 2002127990, -1371556291) + var2 + a.c(1296766142, "ᒘ浾\ue7b3租\uf214瓭") + var1);
      }

      for (int var3 = 0; var3 < 27; var3++) {
         fia(
            var0,
            a.c(274502064, "釸\ue854抖ﳯ睵\uf196䯒숶屵훉儘\uab6f◽밉㙑낺૨蔤ᾚ馒စ橧\ue487缟不玮쨎䑔\udeb9壳퍝ⶇꞟ") + var3 + a.d("\u0530糖\uf61b桷\ue3bc故", -1045814033, -1119673863) + var1
         );
      }
   }

   private static ServerPlayerEntity fhq(MinecraftClient var0) {
      return var0.method_1576().method_3760().method_14602(var0.field_1724.method_5667());
   }

   private static void fhr(MinecraftClient var0, String var1, Item var2) {
      ItemStack var3 = fhq(var0).method_6047();
      fhy(var1, var2 == Items.field_8162 ? var3.method_7960() : var3.method_31574(var2), a.c(1389889576, "ࡅ燽ﬡ敚\ueed4") + var3);
      fhy(
         var1,
         var0.field_1724.field_7498.method_34255().method_7960() && fhq(var0).field_7498.method_34255().method_7960(),
         a.c(1491390755, "텐ꣷ∣뱓㞘넴ଵ芊᳔陾ᇹ\uebcd攒ﲾ盩\uf015")
      );
      fhy(var1, !oxw.busy(), a.b("ᦾ怈\ueac6璲･禘쎉䩯퐶庍", 1209276871));
   }

   private static void fhs(MinecraftClient var0, String var1, int var2, Item var3, int var4) {
      ItemStack var5 = fhq(var0).method_31548().method_5438(var2);
      fhy(var1, var5.method_31574(var3) && var5.method_7947() == var4, a.b("胠漏玞\uedf4", 1199669399) + var2 + a.b("䡧", -1880995749) + var5);
   }

   private static void fht(MinecraftClient var0, String var1, int var2, Item var3, int var4) {
      BundleContentsComponent var5 = vvn.contents(fhq(var0).method_31548().method_5438(var2));
      int var6 = 0;
      if (var5 != null) {
         for (ItemStack var8 : var5.method_57421()) {
            if (var8.method_31574(var3)) {
               var6 += var8.method_7947();
            }
         }
      }

      fhy(
         var1,
         var6 == var4,
         a.b("截ᮌ酄༿蓠ɘ롎", 399401551)
            + var3
            + a.b("㐆", -771279814)
            + var6
            + a.b("࠻燏ﬁ數\ueeba栍퉉宩엷伂", 1980237841)
            + var4
            + a.b("\ue1ed顔", 1414259151)
            + var5
            + a.c(-338101845, "旅")
      );
   }

   private static void fhu(MinecraftClient var0, String var1, Item var2, int var3) {
      PlayerInventory var4 = fhq(var0).method_31548();
      int var5 = 0;

      for (int var6 = 0; var6 < 36; var6++) {
         if (var4.method_5438(var6).method_31574(var2)) {
            var5 += var4.method_5438(var6).method_7947();
         }
      }

      fhy(
         var1,
         var5 == var3,
         a.d("鮠\ue20a棂\uf6a6絼ﮁ", -606239669, -444981351) + var2 + a.d("ᙳ", 1139039676, 1579240435) + var5 + a.c(-842749171, "\uab27틓堝왤䶦쬑煕\uf8b5曫\uec1e") + var3
      );
   }

   private static void fhv(MinecraftClient var0, String var1) {
      PlayerInventory var2 = fhq(var0).method_31548();

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = var2.method_5438(var3);
         fhy(var1, var3 == 0 || var3 == 12 || var4.method_7960(), a.d("쬏늷㡧ꘄⷈꭠᄠ飆ۋ谩\u0be5\uf197罛", -617149226, 1630062520) + var3 + a.b("ᙯ", -1154214317) + var4);
      }
   }

   private static void fhw(MinecraftClient var0, String var1) {
      ServerPlayerEntity var2 = fhq(var0);
      int var3 = var2.method_51469().method_8390(ItemEntity.class, var2.method_5829().method_1014(16.0), var0x -> true).size();
      fhy(var1, var3 == 0, a.d("舤ﮃ煍\uef23擴\ue250堂톷価씍䋏뢶㙿꾀", -339271658, -1234001320) + var3);
   }

   private static void fhx(String var0) {
      fgz = false;
      System.out
         .println(
            a.c(1606876959, "ｺ蛜ఔ鉯ᦰ鼈┞")
               + var0
               + a.d("ﾧ蘌ಜ鋢ᤰ龋◐갹㈨", -74211324, 1227054992)
               + fhc
               + a.d("櫉ጮ駢ޕ豁૽낻㥗꜎ⶾꩰ偏", 443072308, -1615735343)
               + fhd
               + a.b("ꚉ\udf6c喹쯛䀄우粲", 607954606)
               + fgy
         );
      fhy(var0, fhd == 0, a.c(-2062944450, "\uf764軭Ч驎ᆄ霝\u2d6cꒊ㫈끿㞭췁䍅\udaa3僨혃汕\ue38c祻ｬ皑್艸"));
   }

   private static void fhy(String var0, boolean var1, String var2) {
      if (!var1) {
         fhf++;
         System.out.println(a.b("ꃷ\ud951厙췢䘽삅窓", -1226923886) + var0 + a.c(552997084, "ჺ椭\ue3f9綀\uf652炏") + var2);
      }
   }

   private static kfe fhz(String var0, boolean var1) {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(var0);
      if (var2 != null) {
         var2.setEnabled(var1);
      }

      return var2;
   }

   private static void fia(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void fib(MinecraftClient var0) throws Exception {
      if (!fhg) {
         ServerPlayerEntity var1 = fhq(var0);
         ClientConnection var2 = null;

         for (Field var6 : ServerCommonNetworkHandler.class.getDeclaredFields()) {
            if (var6.getType() == ClientConnection.class) {
               var6.setAccessible(true);
               var2 = (ClientConnection)var6.get(var1.field_13987);
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
            .addBefore(a.c(462399507, "ꡭ퇍嬜앥亼제牤ﮢ旴\uef4a梓鋪ᰴ薒"), a.b("ᆬ栗\ue2c7粮\uf73c燠쮎䉨\udc2c嚗테⬴ꗙ㱅똁ヶ誵չ鿜ᦌ遬", -1747578401), new ChannelInboundHandlerAdapter() {
               public void channelRead(ChannelHandlerContext var1, Object var2x) throws Exception {
                  fgv.fic(var2x);
                  super.channelRead(var1, var2x);
               }
            });
         fhg = true;
      }
   }

   private static void fic(Object var0) {
      if (var0 instanceof PlayerInputC2SPacket var1) {
         PlayerInput var6 = var1.comp_3139();
         boolean var7 = var6.comp_3159() || var6.comp_3160() || var6.comp_3161() || var6.comp_3162() || var6.comp_3163() || var6.comp_3164();
         if (var7 != fha) {
            fie(var7 ? a.b("羝ث賦ኒ饄", -479035407) : a.c(-1505566785, "\udfd2ꙮⲵ닍"));
         }

         fha = var7;
      } else if (var0 instanceof ClientCommandC2SPacket var2) {
         if (var2.method_12365() == Mode.field_12981) {
            fhb = true;
            fie(a.c(52130303, "熊࠸苩ᲃ靓ᇸ"));
         } else if (var2.method_12365() == Mode.field_12985) {
            fhb = false;
            fie(a.b("蜮ﺘ瑐\uea3e懊\ue758崉퓣䪻쀐", 1910802263));
         }
      } else if (var0 instanceof UpdateSelectedSlotC2SPacket var3) {
         fie(a.b("\ue56d鳊ᘐ表ι蔟", 349693208) + var3.method_12442());
      } else if (var0 instanceof PlayerInteractItemC2SPacket) {
         fie(a.b("䖩㰞뛛", 1344947711));
      } else if (var0 instanceof BundleItemSelectedC2SPacket var4) {
         fie(a.c(-2113610157, "\ude35ꞕⵐ댨") + var4.comp_2894() + a.d("迴", -1129324171, -1543606609) + var4.comp_2895());
      } else if (var0 instanceof ClickSlotC2SPacket var5) {
         fhc++;
         fie(a.b("슧묙㇏꾴⑫", 506905313) + var5.comp_3844() + a.d("똉", -1575539551, -1214276986) + var5.comp_3845() + a.b("驀", -427910546) + var5.comp_3846());
         fid();
      } else if (var0 instanceof CloseHandledScreenC2SPacket) {
         fie(a.c(-2036118680, "䬮㊐례☭귬"));
         fid();
      }
   }

   private static void fid() {
      if (fgz && (fha || fhb)) {
         fhd++;
         fie(a.b("럎츈䓄\udab3內ퟛ涝\ue471稨\uf098", -736905243));
      }
   }

   private static void fie(String var0) {
      if (fgz && fgy.length() < 800) {
         fgy.append(' ').append(fhe).append(':').append(var0);
      }
   }
}
