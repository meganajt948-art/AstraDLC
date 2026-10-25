package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public final class egl {
   private static List<emu> egm;

   private egl() {
   }

   public static List<emu> entries() {
      if (egm == null) {
         ArrayList var0 = new ArrayList<>(egp());
         var0.add(emu.of(a.c(-159145799, "꒗\udd4b埡짷䉊쓾约\uf342楲\ue3b8搟鸐"), Items.HEAVY_CORE));
         var0.add(emu.of(a.c(-918860193, "䩮㏉륥❬ꢥ⨋逧\u19ae蟾ള誙烪鶴枆\uedaf欫턐廂쑿䈭쮨뇼㽊꒖⛴\ua83fᆅ鿖Ԭ荴"), Items.ZOMBIE_VILLAGER_SPAWN_EGG));
         var0.add(emu.of(a.d("櫨፺馧ߘ谍શ낓㤐ꍖⶆꨤ偙\ude8c䝃쵮䮕\uf1d0縅", 1527644692, -117674760), Items.IRON_NUGGET));
         var0.add(emu.of(a.b("䊝㬄뇕⾦ꐄ⋍飤ᅩ輺ײ艓簻\uf684潆\ue51b揣", -255637872), Items.NETHERITE_HELMET));
         var0.add(emu.of(a.b("╯島혧䡔쏶䔿６皛\ue8c8戀\ue5a1ᯉ鄃ࢿ苯ѭ븡ㆇꬽ\u2d69꒜", -1888476825), Items.NETHERITE_CHESTPLATE));
         var0.add(emu.of(a.d("ꈗ\udb8e兟켬䒎쉇确\uf1e3澰\ue578拕鲱ᙹ迉֙荫㤬뛳", 1742189057, -874114023), Items.NETHERITE_LEGGINGS));
         var0.add(emu.of(a.b("틂꭛↊뿹㑛늒ࢻ脶ὥ閭ሀ\uec64暢＜申\uf3b8䧲오岕", -937896244), Items.NETHERITE_BOOTS));
         egm = var0;
      }

      return egm;
   }

   private static List<emu> egp() {
      return List.of(
         emu.of(a.b("뺯\ue140䷋폇尕\udaba惬\ue91c眿ﶅ稤聟", -1704673544), Items.SPLASH_POTION)
            .effect(StatusEffects.SLOWNESS, 10, 200)
            .effect(StatusEffects.SPEED, 5, 300)
            .effect(StatusEffects.BLINDNESS, 10, 100)
            .effect(StatusEffects.GLOWING, 1, 3600)
            .color(16711680),
         emu.of(a.b("뫃\ue52c䦧\ud7ab塽\udedf擱\ued0d猠燐穒萱૪鍑ᤆ", 1922022039), Items.SPLASH_POTION)
            .effect(StatusEffects.REGENERATION, 2, 900)
            .effect(StatusEffects.INVISIBILITY, 2, 12000)
            .effect(StatusEffects.INSTANT_HEALTH, 2, 0)
            .color(16777215),
         emu.of(a.d("蘆ꛚੑ鑝ᮽ鴮❳껵ビ빷㶗쟈䤗킡嫰", 1353138208, 1680390465), Items.SPLASH_POTION)
            .effect(StatusEffects.STRENGTH, 5, 600)
            .effect(StatusEffects.SLOWNESS, 4, 600)
            .color(10040115),
         emu.of(a.d("笥Ⓤ衁ᙍ馭Ἶꕣ⳥닃㱧뾋䗕쬉劸\ud8e0帕\ue456殂\uf13c", -2066477811, -2056227232), Items.SPLASH_POTION)
            .effect(StatusEffects.RESISTANCE, 1, 12000)
            .effect(StatusEffects.FIRE_RESISTANCE, 1, 12000)
            .effect(StatusEffects.HEALTH_BOOST, 3, 1200)
            .effect(StatusEffects.INVISIBILITY, 1, 18000)
            .color(65535),
         emu.of(a.b("轓킼簷\ue23b淛\ueb48儕\ud893䚵접䯲뇒㼅ꛅ⳧ꩯဥ鿹", 279285530), Items.SPLASH_POTION)
            .effect(StatusEffects.STRENGTH, 4, 1200)
            .effect(StatusEffects.SPEED, 3, 6000)
            .effect(StatusEffects.HASTE, 1, 1200)
            .effect(StatusEffects.INSTANT_DAMAGE, 2, 0)
            .color(3355443),
         emu.of(a.c(711740067, "䫪ᔅ릎➂ꡢ⻱钬ᴪ茌ඨ蹻琚韛捴\ue92f澨햙婈"), Items.SPLASH_POTION)
            .effect(StatusEffects.POISON, 2, 300)
            .effect(StatusEffects.WITHER, 2, 300)
            .effect(StatusEffects.SLOWNESS, 3, 300)
            .effect(StatusEffects.HUNGER, 5, 300)
            .effect(StatusEffects.GLOWING, 1, 300)
            .color(3329330),
         emu.of(a.b("ꪕ\uf57a姱쟽䠫캆瓖ﵛ捴\ue9c9湤鑨᪼茆", 355904192), Items.SPLASH_POTION)
            .effect(StatusEffects.WEAKNESS, 2, 1800)
            .effect(StatusEffects.MINING_FATIGUE, 2, 200)
            .effect(StatusEffects.WITHER, 3, 1800)
            .effect(StatusEffects.BLINDNESS, 1, 200)
            .color(4737096),
         emu.of(a.b("䱅Ꭺ뼡ℭ껸⡛鈃ᯱ藗༛裄犸\uf872旹\ueff0椂퍆峧옮䀈짱돔", -1827058680), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.MAX_HEALTH, 4.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ATTACK_DAMAGE, 3.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR_TOUGHNESS, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR, 2.0, Operation.ADD_VALUE),
         emu.of(a.b("㘮槁않孆풓到\ue868憚ﾼ異\uf2af࣓舙ᾨ闫ጝꥑ⚊뱇㩦", 907949665), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.ATTACK_DAMAGE, 4.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MOVEMENT_SPEED, 0.10000001817743467, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.ATTACK_SPEED, 0.10000001817743467, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.ARMOR, -3.0, Operation.ADD_VALUE),
         emu.of(a.c(-96264837, "ᴳ䋜\uee57灛ﾎ礭썵䪇풡幭\ud9b2⏎꤄㒷뻾㡷艈ඔ霪"), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.ATTACK_DAMAGE, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, -4.0, Operation.ADD_VALUE),
         emu.of(a.d("繗↸贳ጿ鳪ᩉꀑ⧣럅㴉뫖䂪쩠埞\udde2孭\ue15d溏\uf446", -248395138, 1469297761), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.ATTACK_DAMAGE, 5.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, -4.0, Operation.ADD_VALUE),
         emu.of(a.d("쑳鮜㜗ꤛ⛎ꁭᨵ鏇\u0de1蜭ò搜灄\uedc7枾\ue132學풦", -2018129407, -1781461445), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.MAX_HEALTH, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MOVEMENT_SPEED, 0.1500000347540806, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.ATTACK_SPEED, 0.1500000347540806, Operation.ADD_MULTIPLIED_BASE),
         emu.of(a.b("䪌ᕣ맨⟤꠱⺒铊ᴸ茞\u09d2踍瑱ﺻ挶\ue939澸헽娦", -978564411), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.ARMOR, 1.5, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, 1.5, Operation.ADD_VALUE),
         emu.of(a.d("セ潔쏟巓툆咥\ueefd朏朗珥\uf43aๆ蒌ᤉ鍻ᖃ꿎“몢", 401664792, 2097667051), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.ATTACK_DAMAGE, 2.5, Operation.ADD_VALUE)
            .attr(EntityAttributes.ATTACK_SPEED, 0.10000001817743467, Operation.ADD_MULTIPLIED_BASE),
         emu.of(a.b("竼┓覘ប顁Ợ꒺ⵈ덮㦢빽䐁컋區\ud939徸\ue587樤\uf0e0皿＼脂\u0fe9鐸ቇ", 178092734), Items.TOTEM_OF_UNDYING)
            .attr(EntityAttributes.ATTACK_DAMAGE, 7.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, -4.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MOVEMENT_SPEED, 0.10000001817743467, Operation.ADD_MULTIPLIED_BASE),
         emu.of(a.d("쐊鯥㝮ꥢ⚴ꁠᩂ鏆෩荈\u009e\ufafa琣\ueded柏", 596747918, -189504816), Items.PLAYER_HEAD)
            .attr(EntityAttributes.MAX_HEALTH, -4.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR, 1.5, Operation.ADD_VALUE)
            .attr(EntityAttributes.ATTACK_DAMAGE, 2.5, Operation.ADD_VALUE)
            .attr(EntityAttributes.MOVEMENT_SPEED, 0.07000004566537438, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.ATTACK_SPEED, 0.13000000024761527, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.GRAVITY, 0.09000001839414021, Operation.ADD_MULTIPLIED_BASE)
            .profile(
               a.c(
                  753102265,
                  "永ᖛ齐ĩ諐౫똱㾺ꆴ⬳겆嚪\ud872䆓쮡䵪\uf72f磄\ue26e搗\uedc0鞜ᤄ苝҈蹀㟄맇⍌ꔔ⺪퀁娲쏈䖆콞烴煮籰\ue5dd澸ᅇ鬠Ჭ虸ࠃ뇒㭋봎⛴ꢅ剨\udbf3嶕읧䤩\uf2bf瑡︫柽\ue968錙ᓂ黤T觯㎶땶㼗ꂒ⩩갠嗏\udf49䄥쫯䲟\uf627翶\ue1b8歔\ued6e隦\u180e舄ப赢㝋룜⊹ꐽⷜ힛套싶䓂칰瀦留捄\ue534溺႑騃ϸ薩ཚ낔㪫뱓☚꾑兮\udb15峎욹䠠\uf1d6箉ﵣ曇\ue8c6鉝ᐦ鶃ݷ褕㋝뒄㸻ꞎ⦢퍐品\udeba䀼쨜玧\uf57d缲\ue0c8橸\uec39闪ᾗ腋\u0ad8貆㙆렛↢ꭉⴆ훽塦숑䯈춾眭\uf8c2抧\ue43e湪ឆ饝̀蓍๓뀯㧒ꎝ┊껒傘\uda45䏒얎佑\uf119竵ﱠ昑\uefca釬ᬬ鳼ڕ衯㇅뮧㵖꜡⣞퉅吾\udde9䞐줆狩\uf4a6繰\ue7ec榥ጷ锲ẍ聥ਸ도㖵뼮₈ꪀⱐ험徱셌䬗첦癑\uf808懓\ueb69洦ᛮ飼ɳ诡ධ띡㤚ꋜ⑼긌埤\ud96d䌸쓃互\uf005秤\ue3bf敎\uef39邠ᩖ鰝ף轇ㄷ뫎㲱\ua62e\u2fd9톂孻\udd3c䚤졭牾ﯺ絬\ue714棼ኙ鑗ᷥ螪ॴ단㒡븳\u202e꧱卹프廅삵䩚\uf3ca疧ｹ惱\uea9c汢ᘽ龥ş謙\u0ccf뛪㠛ꇣ⮐굊囜\ud891䉃쐁䷒\uf755礈\ue2c5摛\uee37韯᧶荲ӧ車ぎ멩⎼ꕣ⼒킥婸\udc42䗑쾸煇陼粦\ue676栗ᆅ魮ᵾ蛌ࡎ눓㯮붟✤꣺劻푀帋잪䤌\uf304瓲\ufe6d怓\ue9c8鎾ᔶ黌\u008f詄㏀뗃㽰ꅾ⫒개嘴\udfcf䆍쬁䳻\uf6a9硒\ue1df殿\ued54霻ᢎ艴Ш跎㟬뤤⋿꒙\u2e72\ud7ff妠썊䔡캬灴降揿\ue587漁ც髻᱃藼ྲ넾㬜벍♀ꠍ凘\udb63崲웥䢄\uf25f篮ﶙ杀\ue935鋚ᑖ鸡ߓ襡㌝듘㺈ꀱ⧚펴啥\udf1e䃘쩰䰀\uf5e8罡\ue13c櫇\uec96阁Ὸ膃\u0b52賅㚤롿∎꯷ⵋ휯墲슱䐿췣瞰勵拨\ue4b4湬ဵ駔͂蔱\u0efd낸㨿ꎋ▣꽖働\udab6屡옘侣\uf172笥ﳄ暔\ue85f釵ᮀ鵛۪袝㉌된㷗Ᵹ⤈틓呡\ude4b䟾즢猯\uf493"
               )
            ),
         emu.of(a.d("槞㘱骺Ҷ譠ප랖㸒ꀽ⺜굎圮\ud98b䁀쩫䳪", 791425563, 1399020430), Items.PLAYER_HEAD)
            .attr(EntityAttributes.ATTACK_DAMAGE, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.JUMP_STRENGTH, -0.10000000768432185, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.ATTACK_SPEED, 0.1500000347540806, Operation.ADD_MULTIPLIED_BASE)
            .profile(
               a.b(
                  "坩⻊ꐁ㩸놁㜺赠ӫ髥ၢ韗添\ue323竂\uf0f0瘻챾䎕\ud93f彆횑곍≕릌㿙딑ಕ芖\u181d鹅ᗻ\ueb50慣\uf899绗\uf448䮧쇝䜟\ude82哫⨖ꁱ⟼봩㍒誃\u001a號ᶥ鏔椹\ue0a2曄ﰶ牸짮估앺岬툹ꡈ⾓ꖵ㬅늾ࣤ踴х鯭ᄻ霯溊\ue41f穠\uf1be矍촃䒷\udae4倆홠귳⍟륖ィ똑ఞ莛᧑齰ᚋ\uecdd戕撚翚\uf522䭉슢堓\ude65喣⯮ꅒ㢾뻿㐜讟Ǻ蜒ᵋ铀樿\ue044枟\ufde8獱쪇䃘옲嶖펗ꤌ⽷ꛒ㰦뉄ঌ迕ժ鳟ዳ\ue801澐\ue5eb筭\uf14d䣶츬䑮\udb99儩흊꺣⓸먊㇇럅ഺ荊\u1af3逘ᙗ\uedac挷鹿炙\uf6ef䱼쎓姶\udf6f唻ⳗꈌ㡑뾜㔂譾ʃ飌ṛ閃毉\ue114碃ﻟ琀쩈䆤윱嵀풛ꪽ⁽Ɬ㷄댾ઔ胶؇鱰ᎏ\ue914潯\ue6b8糁\uf257䦸쿷䔡\udcbd勴⡦깣◜무ㅩ袕\u0ee4葿ᯙ金ᜁ\uee89擠精灆\uf7f7䴀썙媂퀸噷\u2dbfꎭ㤢낰㛡谰ɋ馍Ἥ镝沵\ue23c硩ﾒ痃쭔䊵\ud8ee帟푨꯱ℇꝌ㺲됖੦膟ߠ鵿ᒈ\uead3怪\ue66d緵\uf33c䤯삫䘽\udc45厭⧈꼆⚴볻㈥覹\u0ff0蕢\u1b7f銠栨\uee55斔ﯤ焋좛件쐨宠퇍圳\u2d6cꓴ㨎끈㞞趻͊骲Ⴡ阛涍\ue3c0礒ｐ皃찄䉙\ud994弊핦겾⊦롼㾶뗓ଜ腣\u18fb鸲ᑓ\uebf7愿\ue775纺\uf4ea䨂솺䟴\udd37卆⫮ꀼ♱붊㌱襍\u00ad蛎ᱛ鎨槾\uef13敚ﳴ爅졗侍씒孇튎ꣂ\u2e73ꗗ㯊넫ࢧ軚е驷ᆏ靏浲\ue49e竟\uf00b瞫췂䌗\udac4僮혆걄⏛뤱㼟뚐೧艵ᦓ鿗ᔲ\uecad拱\uf810繪\uf5ea䬶셗墻\uded5呪⮫ꇨ✒뺭㓿詨M蟜ᴑ鍜檉\ue032晣ﶴ珕줎䂿웈少퉤ꦋ⼇ꕰ㲂눰ࡌ辉י魠ኋ\ue8e5渴\ue44f箉\uf121睑캹䐰\uda6d冖\ud7c7교⒩뫒〃랔\u0df5茮ᥟ邦ᘚ\uec7e揣易置\uf6b2䳡숮妹\udfe5唽⭤ꊅ㠓빠㖬诩Ů飚Ỳ鐇殜\ue1e7朰﵉瓲쨣䁴잕巅팎ꪤ⃑ꘊ㶻돌झ轍چ鰬\u1259\ue982漰\ue51a粯\uf2f3䡾쿂",
                  -1551083800
               )
            ),
         emu.of(a.d("奁ڮꨥ㐩믿㴫蜉ຍ邢ḃ鷡枴\ue917炥戴籽", -1619369134, 398211672), Items.PLAYER_HEAD)
            .attr(EntityAttributes.ARMOR, 1.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, 4.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MOVEMENT_SPEED, 0.10000001817743467, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.ATTACK_SPEED, 0.10000001817743467, Operation.ADD_MULTIPLIED_BASE)
            .profile(
               a.d(
                  "氟ᖼ齷Ď諷ౌ똖㾝ꆓ⬔겡嚍\ud855䆴쮆䵍\uf708磣\ue249搰\uede7鞻ᤣ苺ү蹧㟣맠⍫ꔳ⺉퀥娗쏑䖟켳烐磌籗\ue5f7澟ᅠ鬇\u1c8a號ࠤ뇵㭬봩⛓ꢢ剏\udbd4嶲은䤎\uf298瑆︌柚\ue94f錾ᓥ黃s览㎑딘㼳ꂵ⩉갗嗼\udf54䄙쫙䲸\uf675翙\ue1d5歰\ued3f隑ᠩ舠௨赝㝭룻⊤ꐕⷦힿ夅싑䓧칀瀁淋挽\ue504滅႗驽Ϝ薷ྲྀ냫㪏뱴☽꾶光\udb32峩욞䠇\uf1f1箮﵄曠\ue8e1鉺ᐁ鶤ݐ褲㋺뒣㸜ꞩ⦅퍷哦\ude9d䀛쨻玀\uf55a缷\ue0ef橪\uec38閗ᾋ腣ૅ貰㙢렾↣ꭺ\u2d2b훰塊숫䯇춠眠\uf8e0抃\ue473渪៸饽̂蓪\u0e5e뀈㧻ꎶ╰껷傿\uda7e䏩얐佘\uf121竞ﱁ昶\uefee重ᬡ鳽ڶ衝㇊뮖㵋꜒⣳퉈吒\udd99䞤줗狴\uf4dd繖\ue7db榚ፍ锕Ế聝ਂ돥㖒뼊₮ꪭⱖ헍徺셫䬰첁癸\uf833憇\ueb70洟ᛎ颂ɱ诮එ띆㤾ꋺ\u2451긊埱\ud966䌟쓤亵\uf022秃\ue398敢\uef48邭ᩲ鰛ה轋ㄗ뫏㲖꘏⿺톌嬅\udd1e䚃졙牟ﯲ絶\ue765條ከ鐛᷸蟑॒닟㒞빉 ꧂匽픭廏삨䩹\uf3f1疻\uff00惊\ueab9汼ᘙ龕Š謸ೆ뚮㡹ꇒ⯜굮囡\ud8b7䉫쐢䷰\uf775礊\ue2e1摳\uee04韏ᦹ荁Ӄ躈な먗⎏ꕇ⼃탋婉\udc13䗢쾜煵\ufadc粂\ue643栤ᆛ魰ᴄ蛫ࡔ눙㯛붯✽ꣷ劜푳帬잒䥲\uf337瓕﹨怰\ue9ef鎧ᔫ麥¨詣㏧떢㽀ꄬ⫾걤嘐\udfeb䆟쬷䳟\uf68e硺\ue1ea殙\ued63霱ᢽ艐П跥㞁뤗⋥꒥⹄ퟌ姡썱䕅캋灐慨揝\ue5b7漱ჴ骀ᱳ藜ྕ녞㬱벪♑꠆凿\udb44崕웂䢣\uf278篂ﶭ杴\ue927銞ᑵ鸸ߴ襆㍡듿㺤ꀍ⧲펕啂\udf3a䃾쩝䰆\uf5fd罪\ue11b櫠\uecb1阦῟膤୵賢㚃롶≙ꯏⵔ휘壺슎䐋췺瞡龜拏\ue494湮ဏ駘͌蔴ໝ낷㨨ꏳ▊꽻僀\uda91屆옿侄\uf156筜ﳩ暒\ue809釾ᮧ鵼ێ裤㉡됚㶁ꝶ⤀틦呴\ude6c",
                  51198289,
                  647189707
               )
            ),
         emu.of(a.d("煿⺐舛ᰗ鏁ᔕ꼷⚳뢜㘽뗞俿셝墘튺", 186696851, -124930632), Items.PLAYER_HEAD)
            .attr(EntityAttributes.ATTACK_DAMAGE, 6.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR, -2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, -2.0, Operation.ADD_VALUE)
            .profile(
               a.c(
                  1412529367,
                  "絒ӱ踺၃鮺ᴁꝛ⻐냞㩙뷬䟀줘價\udacb尀\ue645榮\uf304畽ﲪ蛶\u086e鎷ᗢ鼪⚮ꢭ㈦둾㿄셨䭚튜哖\ude37憝\uebe6洸\uf4f1绑=詊\u0dc7霒ᥩꂸ⨡걤㞞맯䌂쪙䳿혍塃\ue3d5攋\uef41皗\uf802艳֨辎ᄾ颅⋟ꐌ\u2e6a뇕㬜뵘䒦츤停\udbde巴\ue75d溗\uf0c3稪ﱜ蟀।鍭᪥鰄☢ꦠ㏺땃㲰웥䠀페嗠\udf19慜\ue8b0牰\uf45e羦ǒ譸ኒ铩Ḩꇸ⯖괃㝰뻻䀄쩿䶤ퟓ奊\ue0bc櫣\uec09瞭怜茷Ռ賩ᘝ顿⎷ꗮ⽑뛤㣈숺䖫쿐兖\udb76拍\ue417湝\uf19f笒ﵗ蒀\u0ec5逮ᮐ鷽✯ꥳヮ먷㱦잽䤇퍦媊\udced晭\ue9ad珎\uf53e罧ڵ蠰\u124f閧ἓꅅ⢶닻㐽뾺䇲쬳劤퓝帕\ue06c殓\ued0c睻ﺣ肀੬趰\u17fb餐₇ꫛⰆ뙟㦾쌅䕟쳔囩\ud85a掹\ue590漛\uf696磗Ȁ葘\u0ff3鄐\u1b4fꊨⓟ깇㇣믠㴛쒀价퀦婽\uddcc朵\ue97e烊悔籒ރ觏ጼ骣᳜ꘋ⡳뎷㔜뽇䚼젫剒햩忸\ue16f梎\uf2d5琯︅臠ି赖ᒙ鸆⁚ꮂⷛ띂㺷상䩈챓城\ud914挒\ueabf氻\uf628秐ϥ蕖ವ障\u181fꎒ◓꼄ㅄ뢏䉰쑠侂퇥嬴\ue2bc擶\uee4d熇ﯴ紱ݔ軘ိ驵ᶋ\ua7e3⤴낟㪑밣䞬짺匦핯岽\ue638桇\uf3ac甾～蚬࣠鉆ᖚ鿅ℳꭚ㋁됳㹧솔䬑쵷咧\uded1怹\ueb92深\uf709祩Æ訲\u0c57鞱\u197cꍏ⪀곡㙞립䏃씽佲훟堼\ue26d斈\uef0c焢\uf8b5苓ј辤ᇦ鬐⊐꒫⸚끲㮳봯䝝캶僿\uda68嶒\ue7f9椧\uf0a7竕ﰇ虷\u09e4錉ᕬ鲂⚁ꡙ㎕뗤㽀욂䣉툤呆\udfd2愷\ueb7c犀\uf4fa縴ƌ话പ钑Ộꀓ⩼귧㜜륋䂲쨉䱘힏姮\ue335檏\uece0瘹\uf86a菓Ը轵ᚹ頋∬ꖲ\u2fe9녀㢿싘䐏칷决\udb10嵋\ue4b0渧\uf056箭﷼蝫ຒ郩ᨸ鶯⟎ꤻ㌔몂㰙왕䦷폃商\udcb7曬\ue84a玂\uf5d9缣ł袕ሁ鑹ᾐꇺ⭥늾㓇븶䆍쯜䴋흲廉\ue01b樑\ueda4矟籠肳૪谱ឃ馩⌬ꕗⳌ똻㡍쎫䔹켡"
               )
            ),
         emu.of(a.d("ꍺﲕ倞츒䇄윐紲\uf4b6檙\ue438柘鶂ፙ誜Ä", -2039246579, -1846005213), Items.PLAYER_HEAD)
            .attr(EntityAttributes.MAX_HEALTH, 4.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.SUBMERGED_MINING_SPEED, 0.5, Operation.ADD_MULTIPLIED_BASE)
            .attr(EntityAttributes.OXYGEN_BONUS, 0.5, Operation.ADD_MULTIPLIED_BASE)
            .profile(
               a.b(
                  "⳥商\udf8d䇴쨍䲶\uf6ec罧\ue169毮\uec5bᙷ颯Ŏ譼භ럲㠙ꊳⓊ괝흁姙숀䑕캝眙駱掑\ue5c9湷郜\u1aef茕\u0557迉〩멿㲃ꕃ⽥冠\udbfd屰욥䣞\uf10f箖\ufdd3昩\ue858ኵ鬮ᵈ螺৴뉢㒼뻶✠ꦵ폄吟\ude39䂉줲獫\uf5e2翋\ue072檼\uecfaᔒ龮ǣ詮ూ뛩㼣ꅧ⮞귆홣壓싛䬁축矐\uf801扝\ue4eb洜靅ᦧ舨х躹・뤓⎊ꗾ⸑偔\udadb䌱앍侟\uf04e穣ﲞ曇\uef4cᆳ鯈ᰓ虤ࣽ넋㭔붾☚ꠛ튀哻\udd5e䞪질爀\uf459绦\ue753楿鎍ᐜ鹧á諁㍺떠㿏ꀭ⫏곂픪彂솄䨸챖皎\uf8dd慧\ueb8e淔阈ᢕ苌କ赎㟴렕≁ꒆ⻦坆\ud9bd䏍쐔仆\uf0cb礴\ue35c旨\uee36၅骈͎蕑ྐྵ뇘㨯벮⛦꼟텠寷\udc00䙘죻焟ףּ綈\ue7e3栌銰ᓍ鴴ݍ觶㈬됧㺒꜡⥂叫헨幥삤䫳\uf333畸\ufffb怄\uea5b沬锴ἐ膛\u0be0豻㚌룕ℎꮿⷆ嘵\ud821䊶쬹䵰\uf7bc秏\ue250撧\ueef0ᜈ駌ϯ萴๏냘㤹ꍢ▓꿤큽媦\udcdc䕶쾛燄鶴籢\ue6f5漩酱ᮨ鷉ٜ袊㊣묠㶽\ua7e7⡡剄퓀嵓윫䦖\uf225瑆ﻯ惴\ue919Ꮈ闏ḷ聼ઃ댓㕹뾞⁏ꩇⲅ嚾\udf74䆇쯺䰿\uf653磆\ue106歸\ued90ᙇ顤˪蓘ൗ랉㧕ꈜⓎ껓휌奇쎵䐹츗炃\ufafd捡\ue593濟逳᪳鳪ԏ輽\u318f먥㱸ꚸ⣋兡\udba3巠옒䢭\uf2ff筫ﵖ柺\ue83bቨ钝Ử蝼ঋ돚㐂뺧ₓꤕ퍍嗙\ude5a䁒쪉猰\uf542羯\ue1c6樋\uec8b᛫鼒ŋ诀థ뙝㢢ꄑ⭣궉ퟩ塅슿䓦촃睺燐戈\ue44f滵霷\u197d莗ָ蹲\u3097뫇⌶ꕍ\u2fdc倸\uda7a岉씢佷\uf1ad篅ﱐ暣\ue8e8ᄏ鮔ᷯ蘸࡙늂㬳뵄➝꧆퉼咓\udec2䜑즨珃\uf406繊\ue0f8楟鍹ᖂ鿋T誫\u0cfc딄㿀ꇫ⨰걋훜弥셞䮏찘癹\uf8a2拓\ueb24涽韈ᡧ艱Ӣ贮㝌릸∵ꑄ⺟傹\ud909䎲엨丩\uf066竲\ue30a散\uef81သ驅\u1cbc蛅ཾ놯㯸밙♂꣰텚字\uddac䘷졀犑\uf4ca絸\ue7d2槟鈤ᒿ黈܆襀㎲둊",
                  284896612
               )
            ),
         emu.of(a.b("ὃ䂬\uec27爫﷽笩섋䢏횠堁\udbea↹꽤㚥벆", 527441687), Items.PLAYER_HEAD)
            .attr(EntityAttributes.ATTACK_DAMAGE, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, 2.0, Operation.ADD_VALUE)
            .profile(
               a.c(
                  -665893161,
                  "䝚㻹됲⩋ꆲ✉鵓ᓘ論Q蟤緈\uf310櫱\ue0c3昈\udc4d厦줌併욢볾㉦ꦿ\u2feaꔢᲦ銥\u082e蹶\u05c8ﭣ煐\ue8aa滨\ue438宖퇀在컽䓚㨵끂㟏괚⍡骰ဩ陬ඖ菧礊\uf091盷\uec05手\ud9dd弃핉䲟숊롻㾠떆⬶ꊍᣗ鸄ᑡ话ė蝃纸\uf402橜\ue19c柩\udd56咀쫙䀶완뷈㍬ꥱ₾ꘃᱴ鎨ৢ轭ڹﳭ爦\ue980澡\ue510孺튚䡽칖䖽㯰넽⢘껱\u2438鮾ᇝ霛൸蓳稌\uf077瞬\ueddb捂\udab4僫혁䶥쎤뤿㽄뛡Ⱅꉷᦿ鿦ᕙ賬ˀ\uf832羣\uf5d8歞\ue17e壅\ude1f呷쮑䅰읃뺙㓎ꨨ↪\ua7e5ᴦ鍾૪聩ٮﶟ猲\ue95f悪\ue6f1局펹䧼콜䕑㳢눹⡇꾿╸魳ኾ裿\u0e68薆篏\uf127梸\ueeeb搉\uda41内휑䵍쒸뫑ぎ랒ⷊꌓᪧ郚ᘫ谁Υ欄罪\uf6a7泲\ue249妘\udfc1唓첁䋃㡐빗㗊\uab07⅙颵Ủ鑀வ臢ܾﺦ瓿\uea02恁\ue7ea崳퍪䪱쀀䙷㶖돂⤳ꂀ⛈鰿ል觡༞蕢粚\uf223桶\uef95旞\udb67劆죝丬쑛믂ㄙ띨⺑ꐣᩎ醯ះ赊һ\ufae0灆\uf676淍\ue317奃킟嘂챋䎟㧸뽯㛭곒∗馅ῇ镔ୋ芶砛﹥疱\uebe2慄\ud8ad廅퐡䮩쇡䜹㵥듏⨩ꁆ➹鷧ጼ誗Ç虌綤\uf3f3椥\uef0c暴\udc09剺즙佰앫벆㋧ꠐ⾇ꖨᬤ鄊ࣈ踒Ѥﮎ焙\uf746溻\ue4db娱톚埄쵞䍵㪸뀜㙑궭⌂饌ႜ雾ె莈秙＠畹\uecc7戶\ud866忈픀䭢슪룛㹜뗠⯭ꄘᢏ黺ᐅ詩Ƹ蝼絔\uf4be櫯\ue062枙\udde2匬쫵䃝예뱴㎲ꤕ⽙ꚸ\u1c8e鉅\u098e迿Ԓﲞ狼\ue828湍\ue5cc嬆텊䢊컲䐼㮔놞㜶꺝ⓟ騅ၹ韼ശ荍窿\uf003百\ued87揦\ud93d傌훻䰢쉹마㼱땅ⲡꈓᠤ龺ᗥ譓ʸ\uf8fb縩\uf478毥\ue112杮\ude96启쩲䆑쟚뵣㒚ꫡ‰ꞧ᷆錝६肛\u0602ﱙ玣\ue9cc潥\ue6e4峷툘䦡쿑䔨㭗늰⠧깜▅鯘ᄸ袡໘萕箕\uf1dc眯\ued7a擁\uda10假\ud7a6䷽썌못ネ똫ⶦꏿ\u192e齵ᛄ谳Ʌ念缮\uf577沖\ue2e6塍\udf87嗽쬻䄄㢵"
               )
            ),
         emu.of(a.b("婷֘ꤓ㜟룉㸝萿ර鎔ᴵ黫擷\uea58珥零", 595155491), Items.PLAYER_HEAD)
            .attr(EntityAttributes.LUCK, 1.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.MAX_HEALTH, 2.0, Operation.ADD_VALUE)
            .attr(EntityAttributes.BLOCK_INTERACTION_RANGE, 1.0, Operation.ADD_VALUE)
            .profile(
               a.b(
                  "\uf28b謨ǣ龚ᑣ鋘⢂ꄉ㼇떀㈵젙䛁\udf20唒폙榜\ue677糝瘝獳य螷ᱮ騻ჳꥷ❴뷿㮧뀝亱쒃嵅\udb0b凯\uee47搯\ue2ed笭\uf108迎֓舞ᣋ隰⽡ꗸ⎽롇㘶쳛䕀쌦委힚氌\uead2悘漏矛ඪ話W黧\u175c괆⯑ꆰ㸜득㊀쭿䇭\udfa0呝툯梔\ue146缛\uf5f0玅ࠑ蚽Ჷ长Ꮦꦠ♯밍㪕댰䤨쟧属\uda2c僃\ueeb8杦ﷱ箐\uf06f踄ҵ鵟ᬍ里\u2e79ꐛ⋊뢩ㄢ쿝䖦쉽堊횓潥\ue53a提\uf874癵೮誕̰駄ឦ걮⨷ꂈ㤽뜑䷣쩲䀉\ude8f咯\ued14毎\ue1c5繃\uf4d4犖୴脤ῷ鑆ሆ꣣⚼뼊㗥뎿䡎웣岎핻匠\ue991晨ﰭ窍\uf080褳ߨ鶖ᩮ邩⺢ꝯ㴮뮹し츞䓶\udd69嬺퇘澐\ue454拀\uf89c煩ༀ薟Ƀ頛ᛂ꽶┋ꏺ㧐뙴䳌쪻䍶\ud923垘\uec49樐\ue0c2祐\uf712趁ஆ耛Ỗ针ⵤꬷ↑빤㐳닯䭷섮忓햐刻\ue8e2暻｠痑\uf3a6衇ؓ鳢ᕑ錙⧮\ua7dc㰰뫏コ쥋䟲\udda7婄퀏溶\ue757紌ﯽ熊ณ蓈ʹ魀ᇲ꾟⑾ꈖ㢛녪伱얗䎧\ud81c囆\uec92敎\ue3d3禚\uf64e谩ા茼ᤃ韆ⱔꨖ₅뺚㝧췊䮴쁠帳풕浼\ueb14懰ﹸ琰\uf2e8袴Ğ鿸ᖗ鉨⠶ꛭ㽆딖㎝졵䘢\udcf4嫝퍥様\ue7ab籈瑱為ॗ蜶᷁驖ေ껢⒅봘㯀놡乜쓈䊩\udb75儖\uefe0摛\ue228磐\uf6a7轩מ莓ᡨ雺ⲑꔀ⌸릇㙑챀䫱삻夙ힹ涴\uea6f惻ﺳ睹ര讁\u007f鸿ᒑ굙⭲ꇗ㾅둪㋰좓䅁\udf31喣퉟栠\ue6f5缡\uf50f珙ড蘨᳇骢፮꤅➃뱡㨔냄䥛윃巽\udbd5倜\ueed7撱ﴕ笷\uf188蹞Ж苧᭱鄆⿕ꖨ∀룍㚜콮䗒쎯塖혷泬\ue55d挪麟瞨ఙ諠\u0094饰ែ귵⩫ꀴ㺂띩䴪쯸䆩\ude34哃튿歇\ue1fe羣\uf440爋ࢲ腋ἰ闡ቶꠗ⛌벽㕊돓䦈왲尝\udab4匵\ue926柉ﱰ稀\uf0f9躆ݡ鷶ᮍ達⸉ꓩ㵰묉㇄칄䐍싾墫턐濁\ue596扷\uf82c皝ཪ蔜Ϻ顷ᘮ곿⪤ꌕ㧢랔䱲쫿䂦\ud947圷\ued9c橖\ue02c绪\uf4d5赤",
                  31781638
               )
            ),
         emu.of(a.c(653021401, "傒ཽꏶ㷺눬㓸軚ݞ饱័鐁湪\ue0c7礄\uf35a疦"), Items.PLAYER_HEAD)
            .attr(EntityAttributes.ARMOR, 2.5, Operation.ADD_VALUE)
            .attr(EntityAttributes.ARMOR_TOUGHNESS, 2.5, Operation.ADD_VALUE)
            .attr(EntityAttributes.MOVEMENT_SPEED, -0.15000007945819008, Operation.ADD_MULTIPLIED_BASE)
            .profile(
               a.c(
                  803549495,
                  "ゾ䤝쏖嶯홖僭\ueab7挼ﴲ瞵\uf000ਬ蓴ᴕ霧ᇬꮩ⑂뻨㢑녆쬚䖂\ude5b堎틆歂\ue541翊漣爨貅ڵ齎ᤈ鏙ⱱꘚ⃘뤙㌾䷫잦䀫\udafe咅\ued54柍\ue188穲\uf403\u0eee蝵ē鯡ᖯ긹⣧ꊭ㭻뗮쾟䡄쉢峒합漳\ue9e3掐ﰺ盞\uf0bbॊ菘ᶴ険ဍꪲ⍸뵰㟒농쨠䒈\ude81坤퇁殔\ue44c縆\uf8b8焁謈ב鹨ᡅ鋡Ⲏꕈ㾙릲㉤䰇욇彾\ud916叜\uec10昮\ue0ef窜\uf317෨螓H騿ᒦ교✏ꇥ㩁둀컛䢠섅寱햓湛\ue802抽\ufb08甤迖ࡇ舼Ჺ隚⼡ꧻ⎄뱴㛋낙쥰䌨\uddd2噅퀵櫖\ue489紣\uf7d0熌詖Ӵ麈ᝊ鄼⮆ꑝ㸷룋㊶䬏엶徍\ud857勖\uec92敕Ｕ禕\uf26eఞ蛇ἕ餈Ꮧ궟♋ꃵ㪦덋쵭䞂쁪娋퓼浽\ue735懌﮳瑔軃ࢻ脸ᬼ門\u2e6bꠠ⋟뭣㔞俧즞䈥\udcff围\uef51椂\ue381簈\uf62b烆襧̐鷠ឫ逨⫗ꒈ㵿럧㇃䩸쐣廘흏儶\uebcd斜︅磦\uf2f2\u0b65藪ᾣ顯ሜ것╤뼓㧋돯찬䛗삌奻폪涱\ue640怷类獵贏ޥ膸ᨇ铎⺡Ꝗ⇪뮒㑫业좏䅙\udb70嗳\uee6e栴\ue2b2粇\uf563ྐ览ɕ鰆ᚅ꼌⤧ꏊ㱫똜ヤ䪯썐巀힚偝\uea6c撄ﵦ睽\uf1d7\u0a44萩Ử颀ᄕꯕ▫빃㢔늧쬉䔛\udff4塊툶泟\ue6ed缀履玔豦ۨ育\u1943錸ⷔ꙾†몽㒐䴪쟬䇽\uda5c哥\ueeb8朳\ue118箢\uf464\u0e3c裒ʠ鬂ᖊ꾖⡉ꋸ㳌땙켸䦨숀尝훁潨\ue940揵ﶍ癟\uf0c4લ荊ᴘ韟ၾꨨⓀ뵘㜺뇂쮔䑖\udee5墾텏欲\ue5a1繪\uf814犬譹Ԧ鿋ᦸ鈩ⲄꚌ㽬뤔㎮䱯옥䃑\ud96a匼\uedbe枉\ue036站\uf4ac്蟢Ƽ驾ᐂ껳❞ꄳ㯆떝츬䣛슊孑헠澗\ue84e戻ﳔ畘輟্莟ᰃ雦႖ꥏ⏄붺㙫뀐쫖䍾\udd0e埦큯樢\ue4f9纈\uf77f燦讽ь鸻ᢪ酱⬀ꗹ㹅렡㊼䲿앁忽\ud98e剡\uec16暪ｒ礫\uf3daౌ蘿ó骶ጱ궅➭ꁈ㨳뒨쵟䜆쇝婬퐛滊\ue89a慑ﯻ疎蹕ࣤ芓᭲锂⾩ꡣ∶볍㚟何짰䎬\udc21嚝"
               )
            ),
         emu.of(a.b("Ɂ嶮\uf125漩\ue0fc是\udc0c嗲쮨䄓", -1091698160), Items.NETHERITE_SCRAP)
            .lore(a.d("活ᒠ鸂p迟ॴ뜚㻃ꃩ⩛궃垂\ud951䃬쫀䡞\uf60b秛\ue366敀\ueccf隔", -181245197, 97125316)),
         emu.of(a.b("䁵ᾚ댑ⴝꋅ⑩鸵៉觩ܷ蓻绾\uf059榟", 212484128), Items.SUGAR).lore(a.b("귺푡廃삱伞즵矧︅恝\uea9b洴靉ᦜ聒\u0e6e貍㚱뤞⏙ꖋⰎ噕", -1135957514)),
         emu.of(a.b("⊺絕퇞俒쀄䚩ﳲ甀\ueb57懢\ue22bᱍ銝ଠ腱߾뷏㈗ꢩ⻲", -2075647243), Items.SNOWBALL)
            .lore(a.d("촽뒦㸄ꁶ\u2fd9ꥲ\u171a黅\u009b詑\u0df0\uf78c礤\ue4fa櫈\uec3c嘂\ud9a6䍥", -1493778811, 376797105)),
         emu.of(a.c(-1526920087, "఼叓ｘ慔\ueeb2栬퉷导얠䭾좽㊿뱫▪"), Items.PHANTOM_MEMBRANE).lore(a.b("ﲱ蔪ྈ釺ṕ飾⚜꽂ㄕ뮧㰀왲䣕텣嬸\uddc9枋\ue825盹\uf4b8紼ݮ覭", -1746077508)),
         emu.of(a.d("ꄢﻍ剆챊䎩씹罨\uf690梱\ue278斦鿟ᅷ袴ʑ萞㸦", -1563861077, -1581908285), Items.ENDER_EYE).lore(a.b("㞧丼쒞嫬핃叨\ued8c摘勇炾\uf769ഔ菁ᨏ鐳ᛐ겓⍇맲㾮", 551826345)),
         emu.of(a.b("綡≎軅\u10c9鼡ᦴꏬ⩬됰", -1564770829), Items.DRIED_KELP).lore(a.d("縝ކ贤ፖ鳹ᩒꐼⷥ돏㥽뺥䒤쩷及\ud9e6學\ue556檄\uf040瘙￣", 1308268891, 1268966217)),
         emu.of(a.c(-805391587, "데쫁䀒\ude3b凐흈浩\ue0ff窚\uf071瞡跛ͼ骷႓陬ⱗ\ua7e9㴂뭓㊤"), Items.NETHERITE_SWORD)
            .denyEnch(Enchantments.KNOCKBACK)
            .lore(a.c(-926383170, "菽\udc12炙\uee95慼\ue793嶸푂䨖삢䝼봆㎦ꩦ⁃ꛀᢖ鍘ঔ辰ن簟\uf2a5椃"))
            .lore(a.d("\uddf8ꑨ⻏낷㬟뷘߹", 1175992380, -1402215971), 3)
            .lore(a.c(1061619801, "ూ痑．慼\ueaac汥홎徰쇤"), 2)
            .lore(a.d("ﳉ蕜ྍ醅ᨨ鲗⛌꼸ㅪ", 2078968229, -402755205), 2)
            .lore(a.d("釢\ue848", 1436963100, -646331181), 3)
            .lore(a.c(791917678, "끲짢䍆\udd40嚘큕橸\ue3fe"), 3),
         emu.of(a.c(-38025358, "윒뺣㑰꩙▿ꍜ\u1977邍໐董ޠ匿睦\ueed4撌\ue20d堸힞䴣쬆䚞㲗눤⧵"), Items.MACE)
            .lore(a.c(1665179835, "ꃸ７厜춐䉹쒖纽\uf747椓\ue3a7摹鸃Ⴃ襣͆藅㮓끝⪑겵╃弚토䨆"))
            .lore(a.d("⻇块\uddf0䎈젠仧\uf4c6", 1270666534, -63832072), 3)
            .lore(a.d("\uf63e辭ղ鬀ა阙ⰲꗌ㮘", 133505967, -299839094), 2)
            .lore(a.c(396588478, "熩࠼苭᳥靈ᇷꮬ≘밊"), 2)
            .lore(a.c(1020696733, "鲰\ue51a"), 3)
            .lore(a.c(-105186002, "爐肢ਆ鐀Ῐ餕⌸ꪾ"), 3),
         emu.of(a.c(72286606, "Ǭ硝\uf28e沧\ue372斡\udf87噴졟䊜앋㽉뗸⡳ꉺ⒈黌ᅭ认ං葻﹞璂\uef0b楴\ue3a5"), Items.TRIDENT)
            .lore(a.d("\ue45d뮲\u1739褵ۜ耳㨘돢ⶶ꜂⃜\udaa6吆췆䟣셠缶\uf4f8渴\ue810懦ᮿ锅ຣ", -1396576622, -1670313332))
            .lore(a.b("\ue73a麐ᑉ詋Ɲ", -1845894370), 3)
            .lore(a.c(-1868732350, "汥ᖷ齥Ũ誾\u0c71"), 3)
            .lore(a.b("墵⅛꯰㗻븡㣩芹ୀ锚ᾦ", -1206035296), 2)
            .lore(a.b("\ufde1葼\u0ea6郒᭷鶶➜긑う뫲㴬", -470353416))
            .lore(a.c(1910084780, "邺\ue92a揳ﷶ瘪\uf0e2䪾썊崗")),
         emu.of(a.d("僞⥯ꎼ㶕뉸㓫軀\u074b餞ឿ鑖湽\ue0a9礓\uf330疻쾃䁜\uda9b墥턊꭛◨", -1937985822, 161218131), Items.NETHERITE_PICKAXE)
            .lore(a.b("䳫ጄ뾏Ↄ깪⢅銮᭔蔀ྴ衪爐ﲰ数\uef55槖힀屎욂䂦쥐댉㶳ꘕ", -611365720))
            .lore(a.b("Խ糞\uf675桳\ue3dc敧\udf3d囎죤", 1777664293), 2)
            .lore(a.d("榈ဘ骿Ӈ软ন뎉", -909662688, 1136446385), 3)
            .lore(a.d("Ꮏ樢\ue0f2纍\uf55f玔", -1462778778, 1651364803))
            .lore(a.b("ᣉ慚\uebf9痴侮碳싄䬾핣忚\ud803", 1862343890))
            .lore(a.b("ꧠ큾嫞쒮伃즷珩", -1714442760))
            .lore(a.d("눇쮑䅇\udf38哩툭", -950025044, 1451127474)),
         emu.of(a.d("㣍䅼쮯喆\uda61岀\ue6a2潒\uf106箹ﰝȎ裣ᄈ魘ᶢꞝ⠶닲㒭봮쌐䷻혪偕", -852345594, 1684735402), Items.CROSSBOW)
            .lore(a.c(672672690, "⯱琞\ud895䚙쥰侟\uf5b4籎\ue21a梮\uef70ᔊ鮪ɪ衏໌낚㭔ꆘ➼깊퐓媩섏")),
         emu.of(a.b("誱\uf300秓\ue7fa栥\uee87哚\udd22䝡짪乣됑㫍ꌌ⤥꾣ᗢ驇қ芒\u0b65焴", 1799326431), Items.NETHERITE_HELMET)
            .ench(Enchantments.PROTECTION, 5)
            .ench(Enchantments.FIRE_PROTECTION, 5)
            .ench(Enchantments.BLAST_PROTECTION, 5)
            .ench(Enchantments.PROJECTILE_PROTECTION, 5)
            .ench(Enchantments.UNBREAKING, 5)
            .ench(Enchantments.MENDING, 1)
            .ench(Enchantments.AQUA_AFFINITY, 1)
            .ench(Enchantments.RESPIRATION, 3)
            .denyEnch(Enchantments.THORNS),
         emu.of(a.c(-995374821, "쥸냉㨚ꐳ⯙굅᜕麗Ë訍\u0dd7\uf7a3祶\ue4dd檴\uec1f噓\ud989䍊액䳡㚾롹⟇ꇠ⬱銂"), Items.NETHERITE_CHESTPLATE)
            .ench(Enchantments.PROTECTION, 5)
            .ench(Enchantments.FIRE_PROTECTION, 5)
            .ench(Enchantments.BLAST_PROTECTION, 5)
            .ench(Enchantments.PROJECTILE_PROTECTION, 5)
            .ench(Enchantments.UNBREAKING, 5)
            .ench(Enchantments.MENDING, 1)
            .denyEnch(Enchantments.THORNS),
         emu.of(a.d("漣耣૰铙ᬱ鶡⟱긃ご뫫㤠읫䧦큔娌\udc8d暸\ue91e玣\uf586砞ȗ貤\u1775", 865605316, 1892740918), Items.NETHERITE_LEGGINGS)
            .ench(Enchantments.PROTECTION, 5)
            .ench(Enchantments.FIRE_PROTECTION, 5)
            .ench(Enchantments.BLAST_PROTECTION, 5)
            .ench(Enchantments.PROJECTILE_PROTECTION, 5)
            .ench(Enchantments.UNBREAKING, 5)
            .ench(Enchantments.MENDING, 1)
            .denyEnch(Enchantments.THORNS),
         emu.of(a.b("靉\ueef8搫拓痤\uf37a䥕샞庄퐲口궊❧뺌㓜눦࠙螲ᵶ鬩ኪ沔\ue27f禮\uffd1", -750217432), Items.NETHERITE_BOOTS)
            .ench(Enchantments.PROTECTION, 5)
            .ench(Enchantments.FIRE_PROTECTION, 5)
            .ench(Enchantments.BLAST_PROTECTION, 5)
            .ench(Enchantments.PROJECTILE_PROTECTION, 5)
            .ench(Enchantments.UNBREAKING, 5)
            .ench(Enchantments.MENDING, 1)
            .ench(Enchantments.FEATHER_FALLING, 4)
            .ench(Enchantments.SOUL_SPEED, 3)
            .ench(Enchantments.DEPTH_STRIDER, 3)
            .denyEnch(Enchantments.THORNS),
         emu.of(a.b("ꀹￖ卝쵑䊸쑕繸\uf7fe榭\ue361撸髙န趿ϭ蕹㽇냣⨠걽", -1699700618), Items.TRIPWIRE_HOOK).lore(a.c(-1528077250, "怖ᶦ鍴ൠ蛆\u0002먡㏜궇")),
         emu.of(a.c(-1570432815, "ᢛ䝴\uebff痳凞粋원佛텽忙\udc10♫\ua8cdㄍ뭓㶧蟥"), Items.GOLDEN_PICKAXE).lore(a.c(92923501, "\ue265鯶ᄭ轟ӿ蘬㡫놐⿀ꔋ⋑\ud8ae刕쿅䗨쌖祛\uf685氾\uea1a")),
         emu.of(a.d("\uddd6船⺲낾㽕맆Ϣ詧ᑎ麍ᵇ\ue355淵\uf440繣", 680643464, 2096829962), Items.GOLDEN_PICKAXE)
            .lore(a.d("\ue47d鷮᜵襇˧耴㸇랆⧞ꌘⓈ\udeb2倕짞䎃섞罀\uf095樧\uec02斋῞", -416100670, 674049717)),
         emu.of(a.c(551241163, "䇙㡇닮ⲓꜾ⇹鯘ᘰ豳ۆ腬笞"), Items.CAMPFIRE).lore(a.c(1891012023, "要\uf053竾\ue483潓\ue9ea又\ude55䐑컘䤊댉㧔ꁿ⸒\ua8ccዹ鴤߭臊ࡏ")),
         emu.of(a.c(-1443046027, "\ud968ꃶ⨨둚㿿륇ͦ躎ᓍ鹸᧒\ue3a0"), Items.CAMPFIRE).lore(a.d("줪냸㩕ꐨ⿸ꥁ፣黾Һ蹳ড\uf3a2祿\ue0d4溶\ue868刪\uddf8䜹셡䣤", 1930577818, -1806398842)),
         emu.of(a.c(-1981382991, "窺̥觰ជ鱘\u1ae0ꂷ⤶뜔㷓멲䐚컑坤\udd4e宼"), Items.SOUL_CAMPFIRE)
            .lore(a.d("꧋퀙媴쓉伙즠玂\ufe1f摛\uee92楀鍃ᦞ耵\u0e5d袂㋋봜➧ꇿ⠌刭\udce3䝄셉", -675429317, 538798538)),
         emu.of(a.d("ᎋ䱤\ue0ef绣\uf109瞐췎䐰\uda69僜휌\u2d76ꏗ㨔둞㛎賺̩馟", 1034245509, 424429126), Items.PAPER)
            .lore(a.b("そ䧭쌻崲훡倧\uea71揷\ufddf獻\uf095ૌ萖ᶨ韽ᄈꭄ⒞빛㡸떖쮦䕮\udebd壇", 1548825723)),
         emu.of(a.c(-2108342663, "㸳懜쵗卛\udcb8婝\ue07e榅\uf7de絬諸Ê訄។鷼ᬏꅅ"), Items.PAPER).lore(a.b("桱ᇁ鬗Ԟ軍ࠋ뉝㯛ꗳ⭗ꢰ劕\udc32䖉쿞䤬\uf366粶\ue21c怬\ue9a0鏳ᵅ", -1756271527)),
         emu.of(a.d("䑉ᮦ뜭⤡ꛉ‧騊\u13f6跚ݨ胏竎\uf466淕\ue39c愊\udb32哮칚䠏쇴뾷ㅿ\uaac4ⳲꙪ\u1fb5", 488039062, 1908516511), Items.STRUCTURE_BLOCK)
            .lore(a.d("Ӌ紅\uf7a8槔\ue270擂\udee4圓쥉䏱쐠㹖뒘⤷ꍫ▐鿔ၴ諄೯脀ﭙ痳\uee6b桝\ue294", 1901119070, -1019361616)),
         emu.of(a.d("䄖ỹ뉲Ȿꎖ╸齕ᚩ袅ȷ薐羑\uf139梊\ue6c3摕\ude6d冱쬅䵐쒫뫨㐠꾙⦭ꌷ\u1aea", 1628743315, -544741435), Items.STRUCTURE_BLOCK)
            .lore(a.d("䰤㗪뽇℻ꪟⰭ阋ῼ膦ଞ賏皹ﱷ懘\ueb84浿휻墛숫䐀짯뎶㴞Ꚅ₰ꩻ", -75045199, 675589808)),
         emu.of(a.c(-879474549, "䣋ᜤ뮯▣ꩋⲥ隈ὴ腘௪豍癌\uf8e4慗\uef1e消ힰ塬싘䒍쵶댵㷽Ꙃ⁰ꫬጷ"), Items.STRUCTURE_BLOCK)
            .lore(a.c(-1914073955, "袸\uf176篛\ue5a7渃\ue8b1劗\udb60䔺쾂䡓눥㣫ꕄ⼘ꧣᎧ鰇ڷ肜൳眪濾战\ue42a滧")),
         emu.of(a.c(1450171537, "\udcda茵⾾놲㹥룁ʔ譮ᔷ龅\u1c4b\ue628棸\uf104笝\ufdeb"), Items.CHAIN_COMMAND_BLOCK)
            .lore(a.d("捄\u1ae5週๋薕͑뵸㒓꫞\u2068ꟶ巍팝䪹쓻䈀\uf84a瞟\ued28歵", 347357242, 1674389322)),
         emu.of(a.b("繌↣质ጤ鳃ᩚꁱ⧴럟㴐뫂", -1833927140), Items.REDSTONE_TORCH).lore(a.c(-2111632485, "ྴ発ﳑ抯\ue904濌햝塼숓䢊켡㔤뮇≈ꠚ⻤")),
         emu.of(a.d("摦㮉霂ऎ蛨s먥㏐ꦕ✰ꃧ媚푁䷳잦䄢", 770153876, -1066206791), Items.JIGSAW).lore(a.d("杣Ỹ鑚ਨ薇̬뵂㒞\uaacc⁵\ua7d2巗팈䪼샢䈆ﰪ珸\ue935潧\ue69d", 1713446614, 1242529210)),
         emu.of(a.b("꼾\uf075屚쉖䶽쬮煷\uf88a暩\uec64段野Ὣ蚦ಋ踚お뾚┬ꌗ⫳僐", -1004621965), Items.FEATHER).lore(a.c(-1487276241, "\uf336読\u0001鹳ᖥ鍨ⴤꃏ㪊뀴㞮췕䌗")),
         emu.of(a.d("ǝ庖\uf2b9沵\ue35e旍\udf94噩졊䊇앖㼭놈⡅ꉨ\u20f9麩ᅹ讳ඝ葯︹炈", -1095655217, 390898014), Items.AMETHYST_SHARD)
            .lore(a.c(2019959093, "┬岷혛䡩쎿䕲מּ盕\uec90昮\ue1b4ᯊ锌")),
         emu.of(a.d("ꀏ￠卫쵧䊊쐚縼\uf7c4淼\ue353擼髯ဢ覜σ蕊㽴뒵⩧ꡗ▟徑텚䪁쳴䘦ﾛ燌\ueb30洖\ue6d6᠃", -318642788, 465323496), Items.TRIAL_KEY)
            .lore(a.b("\udaecꌁ⦪랡㱽몵ä褐\u1738駱Ḹ\ue073溋\uf736紝ﾍ䆣쨓咟튑嬞ⅅ꿼㐮뉟㢈脰༖閒Ꮗ", -232661268)),
         emu.of(a.c(1296740952, "눟\uedf0䅻\udf77傚혊氬\ue5d4翬\uf143盬裿Ȳ鮌ᇓ靚ⵤꚥ㡷멇㞲䷿썈墖\udee1吽\ued82揗"), Items.TRIAL_KEY)
            .lore(a.c(1145712754, "㑶䶛윰夻틧启\uee7e枊廉睫\uf0a2\u0ee9耑\u19ac鎇ᄗ꼹⒉머㱵떆쿘䅣\udabf峌혙")),
         emu.of(a.b("呯\u0b80꜋㤇뛢ぱ訫Ρ", 2043958332), Items.TNT)
            .lore(a.d("嵟\u20fc\uaa3e㑎뾉㵘蝻ຍ铅ᨕ鶿柍\ue96d炭\ufaf6簇쉝䦒팮唅\udcfeꛕ⡥뎹㗋", 1853940498, 1623702118))
            .denyLore(a.d("ᄷ棸\ue22a簤\uf78c焲쭥䊜\ud8de噽톫⯓ꕺ㲹뛨に訪Ɨ鼺ᥤ郣\ueacb摴ﾩ秞\uf302", 1613521781, -1213237735)),
         emu.of(a.d("\uefd9뀶Ჽ花ൗ诌\u31e9롯", -1974943122, 377761252), Items.TNT).lore(a.b("\ue547鲈ᙚ衔ϼ蕂㼕뛬Ⲯꈍ◛\udfa3儊죉䊘쐛繚\uf5e7歊\ued14撓ẻ逄\u0bd9趮ݲ", -1926766308)),
         emu.of(a.b("遜\ue9b7挚ﵧ皲\uf001䩐쏞姮휾僮ꪝ\u243f부㟘", 1889702985), Items.TIPPED_ARROW)
            .effect(StatusEffects.WEAKNESS, 3, 60)
            .effect(StatusEffects.BLINDNESS, 1, 40)
            .effect(StatusEffects.MINING_FATIGUE, 1, 40)
            .effect(StatusEffects.NAUSEA, 1, 100),
         emu.of(a.d("\uda04ꏖ⤇뜃㳚멠У觌វ鴧\u1afa\ue08a湜\uf7e5綾קּ䄍캫", 1607172941, -700424838), Items.TIPPED_ARROW)
            .effect(StatusEffects.SLOWNESS, 10, 100)
            .effect(StatusEffects.MINING_FATIGUE, 3, 40),
         emu.of(a.c(53498643, "圝⻳ꐤ㨪놇㝁贜Қ骴ဈ鞤榺\ue30c窾\uf0ef癫찪䏰"), Items.TIPPED_ARROW)
            .effect(StatusEffects.SLOWNESS, 3, 100)
            .effect(StatusEffects.WITHER, 3, 100)
            .effect(StatusEffects.POISON, 3, 100),
         emu.of(a.c(1996839619, "廚❂궔㏠롋㺆蓞ऺ錊ᧅ鸜摨\ueabb猎"), Items.GOLDEN_APPLE),
         emu.of(a.b("뎇쨡䂂\ude89啔", 1962784677), Items.ENCHANTED_GOLDEN_APPLE),
         emu.of(a.d("ዲ歝\ue181翲\uf42a犓좵", -2123843825, -1107975717), Items.SPAWNER),
         emu.of(a.b("剚⯄ꅣ㽭듆㉴衐ƨ鿺ᔴ隈梙\ue64d羋\uf5dc", -945269171), Items.EMERALD_ORE),
         emu.of(a.d("톫꠷⋡법㝎뇽྾艛ᱰ隱ᅨ\ueb1d旉ﱵ", -1922192586, 479821440), Items.DRAGON_HEAD),
         emu.of(a.d("ᚯ漈\ue5a4箭\uf464盁쳦䕧\udb32冇홗Ⱛ", 1655006980, 1295873416), Items.DRAGON_EGG),
         emu.of(a.b("䝯㻈되⨓ꇆ❼", -1566293180), Items.ELYTRA),
         emu.of(a.b("\ue3fc驡Ⴭ軉", -729356316), Items.BEACON),
         emu.of(a.b("ퟫ까ⓠ뫩㔠랎ජ萫᩻邶\u171c\ued6f枨糖瀪\uf6ae䲕썇姺\udfa8嘭ⱹꋏ㤓", -1300507684), Items.VILLAGER_SPAWN_EGG),
         emu.of(a.c(1902689492, "룭셊䯦헯娦\ud888护\ueb2d畽ﾰ砚艩ࢮ镲ὑ馩⏧걃㚌냔㤫䍷"), Items.ENDERMAN_SPAWN_EGG),
         emu.of(a.b("┝峰확䠥쏼䕌５狴\ue8b6戏\ue5deᾭ鄏ࣆ苯Ѣ븡ㇲꬾ", 210641168), Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
         emu.of(a.d("慩ᣳ鈧ౚ螊", -1935306170, -924190918), Items.DIAMOND),
         emu.of(a.c(698441641, "害∧ꣳ㚀뵔㯡薢\u086e阙Ც魻慿\uefd8"), Items.NETHER_STAR),
         emu.of(a.c(-530096869, "夀⃥ꩃ㐵뿭㥙茇\u0ee3钢Ḝ駅掱\ued64瓓ﺂ"), Items.ANCIENT_DEBRIS),
         emu.of(a.c(1994590243, "బ疵､愗\ueab5汼확忘솋䭃쳢㊊렼⇷ꮧ\u2d2c霟ᣊ"), Items.NETHERITE_INGOT)
      );
   }
}
