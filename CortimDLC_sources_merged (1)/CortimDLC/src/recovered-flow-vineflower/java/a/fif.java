package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.hud.ChatHudLine.Visible;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

final class fif {
   private static BlockPos fig;
   private static Entity fih;
   private static Entity fii;
   private static String fij;

   private fif() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfx var2 = Flow.getInstance().getModuleManager();
      if (var1 == 1) {
         fja(var0, a.b("ꮺ툍壒욫䵴쯇熟\uf86f晵\uec87歅鄣\u1ff0虔చ諴エ", 207137740));
         fja(var0, a.d("\ue8ec酀ᮗ藮\u0e7c袞㋛묻┰꾗⡂툳峤", -225443667, -1782716360));
         fja(var0, a.b("ᅁ棿\ue225籐\uf794煷쭄䊆", 1142034730));
         fja(
            var0,
            a.b(
               "嗢菄ई靪᳸騩⁉ꧫ㟹뵌㪘샢丳힓巓\udb25慸\ueee7琞\uf24a箺ǩ轆ᒞ鋛ᠦꆎ⿂딬㍺룇䘁챣喯폱套\ue6a3泤\uea33玅六蜦\u0d64諆ဖ鹵⟨관⭃낓㻺쐾䶁쯗儯\udf69撙\ue22e桽\uf1a4缌՞芶ࢩ陬῁ꗗ⌻\ua97d㛄뱀㩰쎽䤁휌峥\udafd恈\ue99c矦ﴯ筯Ï踙ᑼ鷣ᬎꅒ⺥듸㉉뮙䇤콳哎틐堓\ue678澰\uf51b猂\uf8fa蚨ౖ閉Ꭹ餭⚔곜⨮끦㦙의䴑쪧僫\ude4d枔\uedb0欠\uf08d绑Ѽ舵்鄘Ὤ꒶⋿ꡟ㆟뿩䔬싓䣝혤屸\ue5c1挓\ue969皏ﰀ穂γ觠\u1738鳌᪓ꀫ\u2e76럟㴕뭰䃯칓告\uddbd宽\ue159満\uf4d0爢\uf86a膕ཉ锺ዶ頂♀꾠㗻댝㢋웨䰶헙厎\ud910杧\uecb1樍\uf05a禸ߺ赂ઁ邼ḹꞅⷅꬪㅶ뺮䐄쉊䮪퇇彚\ue48d拤\ue826熁ﾔ蕫ͳ裎ᘇ鱭▸ꎧ⤟뚂㳵멵䎑질在\udd7a嫒\ue04d渲\uf7e1絎ﭚ肈\u0ee8鐳ᷕ鯃℠꽾㒑뉖㡨솿伉핕劢\ud8e0時\uef8a痉\uf374祺ۆ谝੯鎩᤻ꝅⲣ꫶げ릝䞠쵿䭿탂帋\ue461涬\ueb53焋\ufefd蓩ɘ讫ᇚ",
               -333055216
            )
         );
         fiv(var2, a.d("椋ႁ驏Ч迷ै댌㫟꒢⸄꧄厪\udd71䓒", -2075972373, 2075215293), true);
      }

      if (var1 == 6) {
         fja(var0, a.d("盯མ薇᯾逡ᚒ곊┺묠㇂똗䱡슲嬜텐垶\uedf4", 314341314, 1850278235));
      }

      if (var1 == 12) {
         var0.method_1507(new InventoryScreen(var0.field_1724));
      }

      if (var1 == 16) {
         fin(var0, Items.field_8816);
      }

      if (var1 == 24) {
         fjb(var0, a.c(173509584, "讦\uf21c磂\ue6a5浵\ueb9d冐\ud87a䘸첐䭄넻㿻ꘕⰛꫨႰ齲מ莃੦"));
         var0.method_1507(null);
         fja(var0, a.d("ㄼ䢂쉘尭ퟩ儊\ueb39拻", 1367866398, -192950967));
         fja(var0, a.c(-1932172771, "扫ᯜ鄃ེ蒥Ȗ롎ㆾ꾤╖ꊔ売혡侅엋䌥凉"));
      }

      if (var1 == 30) {
         BlockPos var3 = var0.field_1724.method_24515().method_10069(2, 0, 0);
         fig = var3;
         fja(
            var0,
            a.d("㯢䉅좇因\udd39宋\ue1d4栭\uf639", 2129240152, 160078784)
               + var3.method_10263()
               + a.b("\uf3d8", -2004093959)
               + var3.method_10264()
               + a.c(2866349, "벌")
               + var3.method_10260()
               + a.c(
                  -110723571,
                  "绫ܗ跀Ꮆ顪ờ꒟\u2d7d댥㦆븛䐳쫯卓\ud916忠\ue5a0橃\uf0cd皍ｲ蔽ே遷ᘨ鳑╝\uab0f㇣럼㱅싆䣇텳圭\uddc2戍\ue833滤\uf752紆ϱ観ฑ铁᪢ꌿ⧐꾒㑋먴䃧쥑伊햿寠\ue010曍\ueca4畮\ufbc3臜ؤ豶ዶ鬖ℒ\ua7cbⶣ눑㣙뻦䜶췐反\ud879帣\ue4cc洇\uf339秲ﾤ萜ો邭\u196f鿛▘ꨩ〦뚘㽒씣䮤퀙嘇\udcc4抯\ueb67燌\uf7d5簪ɽ袁ᄏ霩᷒ꉜ⠈껢㓿뵍䏙짆买퐬嫅\ue30c椰\uefe5瑝輻胲ڲ輖ᗀ鮡‾꘢Ⲉ땆㬶쇐䙗찃勻\ud8ac愆\ue783淼\uf264磙ﺐ蝺യ鎰᠋鹘ⓢꫢ㌆맿㾿쑭䫅탚夥\udf76斗\uea08瀂\uf6fe糳՚诂ᆷ陣᳙ꊀ⭠넠㞖뱓䉬죢兛휗巎\ue3bc桦\ueee0璏ﵭ茼ট蹇ᑳ骬⍔꤉\u2fe0떪㩿삀䛚콥唒\udb83"
               )
         );
         fiv(var2, a.b("贪\uf4b0繮\ue009毙\ued4f圻\udedb䂀쨼䷦란", 561745253), true);
      }

      if (var1 == 36) {
         fim(var0, fig);
      }

      if (var1 == 60) {
         System.out
            .println(
               a.b("ᶪ搐\ueece炩ﭹ綜잜乪퀤媑\udd4f✷꧷『멇㳥蚺ॺ鏞ᖏ鱳\ue671", 14556639)
                  + (var0.field_1755 == null ? a.b("氻ᖅ齕ĸ諹\u0c49", -2021299106) : a.b("詼\uf3d2礔\ue76e", 2054261271))
                  + a.d("兌⢹ꉧ㰞럅ㅶ謤˟鲗ᙨ", -1798172765, -2130026811)
                  + fio(var0, Items.field_8477)
                  + a.b("ᵈ撽\uee63瀉ﯘ素", -578937490)
                  + fio(var0, Items.field_8831)
                  + a.d("꒫\udd53垛짷䈡쓃", -1972879567, -2090034244)
                  + fio(var0, Items.field_8620)
                  + a.b("ꇶ\ud806勄첵䝾쇆箃\uf23c", 1144824286)
                  + fio(var0, Items.field_8463)
            );
         fiv(var2, a.b("⠝冇\udb59䔾컮䡸\uf20c篬\ue5b7漋\ue8d1\u12b7", -2128271278), false);
         var0.method_1507(null);
         fja(var0, a.b("퉵ꯋℑ뽤㒠뉃ࡰ膲", -163130850));
      }

      if (var1 == 66) {
         BlockPos var10 = fig;
         fja(
            var0,
            a.d("鎱\uea16惔ﺳ番\uf3d8䦇쁾幪", 2060766837, 473128382)
               + var10.method_10263()
               + a.b("\uda3d", 1904728604)
               + var10.method_10264()
               + a.c(1633796232, "삩")
               + var10.method_10260()
               + a.c(1510773586, "鍼\uea80恗︡痽\uf34a䤈샪庲퐑厌ꦦ❹뻓")
         );
         fja(
            var0,
            a.d("峿╘꾚ㇽ먤㲖蛉༰鄤", -871067743, 451597092)
               + var10.method_10263()
               + a.c(1801728485, "㇄")
               + var10.method_10264()
               + a.c(1549442587, "鸺")
               + var10.method_10260()
               + a.d(
                  "炠ड़莋᷽阡႖\uaad4⌶뵮㟍끐䩸쒤崘흝冫\uebeb搈ﺆ磆\uf139譶\u058c鸼ᡣ銚⬖ꕄ㾨릷㈎첍䚌\udf38奦펉汆\ue678悯酪獍ය蟸Z骊ᓩ굴➛ꇙ㨓둦仡의䅆\udbb9嗲\uee56條\ue2a0筹\uf5cc运ࡲ艴Დ锝⽍ꦧ⎾밆㚄낻䤡쎝嶐홹偡\uead4挀ﵺ瞳\uf1f3詓҅黠\u177f醒⯎ꐹ㹤룕ㄅ쭸䖒\ude0d塘튏泣\ue526翑麗父౩蛂ἆ饭Ᏸ걊♑ꃱ㫵덬䶜쟎䀦\uda39咃\ued07机\ue1ae稜\uf413軸ࣦ腕ᮃ闻⸬ꡲ⋐묄㕧쿾䠑쉏岥훼漛\ue9c6揸ﰣ皈\uf0c0褫̪鷲ᙂ遞⫸꓾㵥랋ㇷ쨽䓀\ude93圾턡毗\ue40b縚\uf8f3狯\u0b5a薊\u1ff0頥ኅ곉┿뽾㦁눎䱯욫弞\ud954參\uedbe映\ue09b竐\uf338赳ނ聜ᩧ铧ⴇꝾ↲믠㐴컋䢓셡学햙渏\ue873拲ﭛ畇ྲ觢ɘ鲍᛭꼱⥧ꏆ㱙뙽シ줙䍉\udd87埡큟檇\ue4f1紨\uf78a熍ੌ葲ậ霆ᅊꮡ▼븆㢕늵䬱얨忀\ud832剺\uec85敁５禰\uf3af豝ځ肬ᥥ鎕ⷀ\ua634\u206e뫟㌟쵿䞩쇴娋풑滧\ue72b憛\ufbc3瑵ฤ裚ą魮ᖢ급⠔ꋩ㲤딼俞짘䈇\udc69囙\uef13椢\ue3f8籃\uf649烰\u0ae4荚ᷕ鞂ြꩫⓝ봁㝶놴䨖쑎庭\ud8b0兟\ueb85旼︣碐\uf2de謅Ս龳\u181d鉆ⲽꛦ㽀릌㎸챧䚟샂夫퍡涴\ue64b怓类璨ൎ螵ǻ騧ᒍ꺐❩ꄹ㯟둂乶좴䊻\udb10喎\ueffd栫\ue293糄\uf52a轨ড়舟ᰦ隯⼌ꥊ⎁뷵㙠냟䫇쌺嵳ퟙ倜\uea23擽ﴆ睱\uf1a0",
                  282150851,
                  -488229331
               )
         );
         fiv(var2, a.b("뾬옶䳨튏奟\udfc9斦\uec4a爓\uf8b3罷", -1004027932), true);
      }

      if (var1 == 72) {
         fim(var0, fig);
      }

      if (var1 == 80) {
         fjb(var0, a.c(1964535088, "浀ᓺ鸤C讓ൻ띶㺛ꃙ⩮궬埊\ud942䂼쫨䰚\uf65c禐\ue334"));
         fis(var2.getByName(a.c(1204846593, "聉陸猍\ued6a暺\ue02c婃펯䷶읖䂒")), a.b("㭙䋯젩噋\udd9a", 2145663791), var0);
      }

      if (var1 == 110) {
         fjb(var0, a.b("暡Ἓ闅\u0ba2聲ښ벗㕺ꬸ\u218fꙍ尫튣䭞섊䟩ﶷ牱", 896165584));
         System.out.println(a.b("爊ர腮Ἁ铙ሼ\ua83c⇑뾓㔤닦䢀옟徴", 1040740967) + fip(var0));
         var0.method_1507(null);
         fiv(var2, a.c(1348343858, "\u187a懠\ueb3e留ﺉ砟쉰䮜헅彥\ud8a1"), false);
      }

      if (var1 == 116) {
         BlockPos var11 = fig;
         fja(
            var0,
            a.c(386438221, "鐷\ued90杒蘆独\uf45e丁쟸姬")
               + var11.method_10263()
               + a.c(-688413037, "ꚲ")
               + var11.method_10264()
               + a.b("\uf478", -845548455)
               + var11.method_10260()
               + a.d("蝜ﺠ瑷\uea01懝\ue76a崨퓊䪒쀱䞬붆㍙ꫳ", 1887709742, -117789348)
         );
         fja(
            var0,
            a.d("ꁧ\ud9c0匂쵥䚼쀎穑\uf3a8涼", -1279546496, -1234302051)
               + var11.method_10263()
               + a.d("ǜ", 1366860489, -1351834828)
               + var11.method_10264()
               + a.c(1809519062, "ᇷ")
               + var11.method_10260()
               + a.c(
                  98135950,
                  "潥ᚙ鱎ȸ觤ན딑㳳ꊫ⠈꾕喽\udb61䋝좘乮\uf42e篍\ue143會\ueefc钳ᩉ臹ަ赟㓓몁\u206d꙲ⷋ퍈奉샽䚣챌玃尿罪\ue6dc沈ቿ頽ᾟ蕏ବ늱㡞븜◅ꮺ兩\ud8df庄쐱䩮\uf19e睃ﴪ擠\uea4d遒អ鶷̩諏ゴ뙺㰮ꎄ⤙꽦囯\udc10䈆짺俳\uf55a糆\ue2b3桻\uee21閔᭔脰ࣦ蹇㑘믹↥꜍⻚퓻娤쇘䞅쵐猺\ufaf3怌\ue655涠Ꮎ饞Ö蚏ౣ돑㦝뼢╺곊剗\ud848忾얢䭋\uf282碾﹫旓\ueb89酼\u173c麘ю訯ㆰ랱㴛ꓓ⪳크埯\udd8c䍴줒炉\uf641簺\ue3f0楑\uef05雽᳷舨\u09d4辉㕤묮⊇ꠘ\u2e6c헱嬓섕䣊캤琔ﯞ懟\ue725浱ᒔ騍9蟧ഈ덏㫱ꂦ☐귌去\ud979䃛욓䱐\uf26d秥～攂\uecf1銮᠘鿟֫譡㋗뢍㸹ꑦ⯦텛園\udef8䒵쩊熕\uf7e6絰\ue4e1檒"
               )
         );
         fja(var0, a.c(369407242, "땡쳟䘅\ud870厴핗潤\ue6a6"));
         fiv(var2, a.c(448261760, "\ueec8青ᶌ菫࠻躲㓂봳⍷꧗⸓"), true);
      }

      if (var1 == 122) {
         fim(var0, fig);
      }

      if (var1 == 128) {
         fis(var2.getByName(a.b("璑ഋ蟕ᦲ鉢ᓫ꺛❪뤮㎎둊", 1281520857)), a.b("禒$諢ᒀ齑", 1417771492), var0);
      }

      if (var1 == 134) {
         fjb(var0, a.d("뉅쯿䄡\udf46咖퉾桬\ue19e翁\uf56b犩裏ه龬ᗧ錋⥝Ꚏ㰺멢", 1296996773, 1039018903));
      }

      if (var1 == 150) {
         System.out
            .println(
               a.d("䮗㈭룳⚔굄⮡醾ᡌ蘓ಹ譻焝ﾂ昩\uec29櫈킖彐엣䎹쨝", 1955760665, 2022228472)
                  + (var0.field_1755 == null ? a.b("輀\uf6be籮\ue203槂\uef72", -1935241371) : a.d("\udcf0ꕞ⾘뇢", 1631335569, 1422387210))
                  + a.d("獪ટ聁Ḹ闣ፐ꤂\u20f9뺱㑎", 1523404914, -754375886)
                  + fio(var0, Items.field_8477)
                  + a.c(-464378449, "▇屢횪䣀쌆䖿\ufff2癍")
                  + fio(var0, Items.field_8288)
                  + a.d("蕾ﲋ癕\ue83f揮\ue516", -572141831, -1467069535)
                  + fio(var0, Items.field_8831)
                  + a.d("苙שׂ燴\uef88摟\ue2e0墺턓", -246286408, -1023576759)
                  + fio(var0, Items.field_20412)
            );
         var0.method_1507(null);
         fiy(var0, Vec3d.method_24953(fig));
      }

      if (var1 == 158) {
         fjb(var0, a.b("⹝埧\udd39䍞좎书\uf474綆\ue3d9楳\ueeb1ᓗ驟ή觱༓땅", -626643409));
         fiv(var2, a.d("༻皡ﱿ战\ue9c8潁픱峀슄䠤쿠", 263478697, -1575857446), false);
         fja(
            var0,
            a.b("嫴⍓ꦑ㟶밯㪝胂ऻ霯", -2129700210)
               + fig.method_10263()
               + a.b("ヘ", 79704313)
               + fig.method_10264()
               + a.b("뚟", 228505278)
               + fig.method_10260()
               + a.b("\udb25ꋙ⠎뙸㶤묓ő袳᛫鱈ᯕ\ue1ff漠\uf68a", -1963140341)
         );
         fja(var0, a.c(195528627, "蟘﹦璼\ueac9愍\ue7ee川퐟"));
      }

      if (var1 == 162) {
         fiv(var2, a.d("㒡䴻쟡妅퉲哠\ueea1杔更玨", 402401470, -1771299754), true);
      }

      if (var1 == 164) {
         ChatHud var12 = var0.field_1705.method_1743();

         for (int var4 = 0; var4 < 150; var4++) {
            var12.method_1812(Text.method_43470(a.c(-681165657, "㳮䕺쾮凔\uda46") + var4));
         }

         for (int var15 = 0; var15 < 3; var15++) {
            var12.method_1812(Text.method_43470(a.c(-2115286170, "佝㛲밮≓궔⬩镥Ვ苎ࠆ辩痗\ufb09拃\ue8e7樃푑宍씮䜞캝뒹㩸ꆮ➤관")));
         }

         List var16 = fiq(var12);
         System.out
            .println(
               a.d("끏짵䌯\udd4b囈퀭橽\ue39e緅\uf77e炵認р鶺៧鄃⭈\ua4cd", 807730501, 1216957819)
                  + var16.size()
                  + a.d("Ꞁ\ude7c咧쫀䄗잴緡\uf412橛\ue0b5杪鵕ᎉ訪k蚌㳄덁⧵", -1022682740, -475087297)
                  + ((ChatHudLine)var16.get(0)).comp_893().getString()
                  + a.d("\u1fc5晿\ueca0犝累翹얡䱆퉊", -1149951363, -944161386)
                  + fir(var12).size()
                  + a.b("飫", 1577162954)
                  + fir(var12).getClass().getSimpleName()
            );
         var0.method_1507(new ChatScreen("", false));
      }

      if (var1 == 166 || var1 == 169) {
         System.out
            .println(
               a.c(-1186849806, "ᮇ戽\ue8e7皃ﴀ篥솵䡖혍岶\udb7d⅟꿛㙺밸㫞肑ཋ閶Ꭶ驄\ue041")
                  + var1
                  + a.d("밷얜", 1969303861, 245140794)
                  + (var0.field_1755 == null ? a.d("ह炉者搡", -973858005, 194908792) : var0.field_1755.getClass().getSimpleName())
                  + a.b("㖳䰎욑壥팵喏\uefca晨", 68892055)
                  + fir(var0.field_1705.method_1743()).size()
            );
      }

      if (var1 == 170) {
         fjb(var0, a.c(-1925541517, "鄛\ue8a1扻ﰟ瞑\uf179䬩싊岑혪凡"));
         kfe var13 = var2.getByName(a.b("樹Ꭳ饹ܝ質\u0a78뀹㧌ꞙⴰ", 524446320));
         Method var17 = var13.getClass().getDeclaredMethod(a.d("蓛ﵢ瞧\ue9d6戓\ue4a4廵휠䥊", 2111643906, 1305454013), double.class, double.class);
         var17.setAccessible(true);
         double var5 = (Double)var0.field_1690.method_42554().method_41753();
         int var7 = (int)Math.floor((var0.method_22683().method_4502() - 40) / var5);
         Object var8 = var17.invoke(null, 20.0, (var7 - 4) * var5);
         System.out.println(a.d("㻅䝿춥叁\ud842座\ue4f7洔\uf34f秴︿Н誉ጴ饸ᾀꖌ⩇냳", -1962282622, -1330786505) + var8 + a.c(1202349313, "攧"));
         var0.method_1507(null);
         ChatHud var9 = var0.field_1705.method_1743();
         var9.method_1808(true);
         var9.method_1817();
         System.out.println(a.b("\ude97ꜭⷷ뎓㠐뻵ҥ赆ጝ馦ṭ\ue44f櫙\uf36f礮ￎ䖖쨕僥횻彅┐ꮰ〩뙌", -389292307) + fiq(var9).size() + a.c(-1494725803, "䭼㊀롛☼귫⭈鄝ᣮ蚧"));
         fiv(var2, a.b("똆쾜䕆\udb22僕홇氆\ue5f3箦\uf10f", -341789105), false);
      }

      if (var1 == 176) {
         fix(var0, 0.0F, 0.0F);
         fih = fit(var0, a.c(-1284904675, "\ue953郆ᨖ葲\u0fbd"), 1.8);
         fii = fit(var0, a.b("琩ඳ蝫ᤒ鋑", 1425962089), 2.9);
         hhf.add(a.c(-2040056073, "㚹伬염官큗"));
      }

      if (var1 == 180) {
         var0.field_1773.method_3190(1.0F);
         Entity var14 = var0.field_1765 instanceof EntityHitResult var18 ? var18.method_17782() : null;
         kfe var19 = var2.getByName(a.d("ꮢ툵壽욂䵕쯦熢\uf863昑\uecbb", 1548838014, 447270786));
         Object var21 = fis(var19, a.b("릆쀸䫬풗彰\ud9f4掴\uea50琍ﺭ", 745191914), var0);
         System.out
            .println(
               a.c(980182986, "枠ḍ铄ન腥߆붚㐣\uaa3a\u209fꝗ崪폶䩍쀉䚱ﳤ獶\ue9d4澘\ue673鰢ኊ襒༥藯㰎눐⣦껹")
                  + fiu(var14)
                  + a.b("岀┽꾺㇞먚㲾蛯༏鄄", -792830811)
                  + fiu((Entity)var21)
                  + a.b("⽭囔\udc4a䈦짹佝\uf508糮\ue2a0栐\uef87ᖓ魯˕袎\u0e6b둴", 650194780)
            );
         hhf.remove(a.b("쩴돡㤱ꝕⲚ", 68340282));
         var0.field_1687.method_2945(fih.method_5628(), RemovalReason.field_26999);
         var0.field_1687.method_2945(fii.method_5628(), RemovalReason.field_26999);
      }

      if (var1 == 184) {
         fij = iov.PRESET.get();
         iov.PRESET.set(a.c(1369827103, "\ue755點ᐖ詠Ơ蜓㵅뒯⫵"));
         fiz(var0, a.c(1776921711, "갾햳彭섔䫋"));
      }

      if (var1 == 204) {
         fjb(var0, a.b("沵ᔘ鿆ƿ詠ಙ뚄㽯ꄫ⮝걙嘪\ud8f8䅒쬄", 901147854));
         iov.PRESET.set(a.b("꺷휮巵쎓䡗컫環", 709996277));
      }

      if (var1 == 220) {
         fjb(var0, a.d("顦\ue1cb欕\uf56c纳\uf84a䉑쮨嗿\udf59墙ꋥⰺ", -40113443, -1288408382));
         iov.PRESET.set(a.d("м網\uf760椌\ue2ca", -1759562574, 1095905500));
      }

      if (var1 == 236) {
         fjb(var0, a.c(-1439165110, "ᔵ沘\ue646砿\uf3e0甙켐䛾\ud8a0刌헎"));
         iov.PRESET.set(fij);
         var0.method_1507(null);
      }

      if (var1 >= 240) {
         hyz.save();
         return true;
      } else {
         return false;
      }
   }

   private static void fim(MinecraftClient var0, BlockPos var1) {
      var0.field_1761.method_2896(var0.field_1724, Hand.field_5808, new BlockHitResult(Vec3d.method_24953(var1), Direction.field_11036, var1, false));
   }

   private static void fin(MinecraftClient var0, Item var1) {
      if (var0.field_1755 instanceof HandledScreen var2) {
         for (Slot var4 : var2.method_17577().field_7761) {
            if (var4.method_7677().method_31574(var1)) {
               double var5 = var0.method_22683().method_4495();
               double var7 = (var2.field_22789 - 176) / 2.0 + var4.field_7873 + 8.0;
               double var9 = (var2.field_22790 - 166) / 2.0 + var4.field_7872 + 8.0;
               long var11 = var0.method_22683().method_4490();
               GLFWCursorPosCallback var13 = GLFW.glfwSetCursorPosCallback(var11, null);
               GLFW.glfwSetCursorPosCallback(var11, var13);
               GLFW.glfwSetCursorPos(var11, var7 * var5, var9 * var5);
               if (var13 != null) {
                  var13.invoke(var11, var7 * var5, var9 * var5);
               }

               return;
            }
         }

         System.out.println(a.c(471881002, "商⳼꘢㡅뎕㕰轷ڗ飞ቨ闵澞\ue107碷\uf2ab") + var1 + a.b("敁Ფ陬ࡒ菍ջ뼱㛓ꢛ", -929536664));
      }
   }

   private static int fio(MinecraftClient var0, Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < var0.field_1724.method_31548().method_5439(); var3++) {
         ItemStack var4 = var0.field_1724.method_31548().method_5438(var3);
         if (var4.method_31574(var1)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private static String fip(MinecraftClient var0) {
      if (var0.field_1755 instanceof HandledScreen var1) {
         StringBuilder var5 = new StringBuilder();

         for (Slot var4 : var1.method_17577().field_7761) {
            if (var4.field_7871 != var0.field_1724.method_31548()) {
               var5.append(
                     var4.method_7681()
                        ? Registries.field_41178.method_10221(var4.method_7677().method_7909()).method_12832()
                           + a.c(1234789788, "日")
                           + var4.method_7677().method_7947()
                        : a.d("죟", 184099837, -1748702450)
                  )
                  .append(' ');
            }
         }

         return var5.toString().trim();
      } else {
         return a.b("\ue5d0鱠\u16fc裎̒薮㿫똝", 2048648630);
      }
   }

   private static List<ChatHudLine> fiq(ChatHud var0) throws Exception {
      for (Field var4 : ChatHud.class.getDeclaredFields()) {
         if (var4.getGenericType() instanceof ParameterizedType var5 && var5.getActualTypeArguments()[0] == ChatHudLine.class) {
            var4.setAccessible(true);
            return (List<ChatHudLine>)var4.get(var0);
         }
      }

      throw new IllegalStateException(a.c(-1200458734, "瑩ෙ蝅\u1977銫ᐓ깕⟰맢㍛뒞仯쀪妝폌唫\uef37悪靖籗\uf5a7"));
   }

   private static List<?> fir(ChatHud var0) throws Exception {
      for (Field var4 : ChatHud.class.getDeclaredFields()) {
         if (var4.getGenericType() instanceof ParameterizedType var5 && var5.getActualTypeArguments()[0] == Visible.class) {
            var4.setAccessible(true);
            return (List<?>)var4.get(var0);
         }
      }

      throw new IllegalStateException(a.b("뎰쨀䂜\udeae啲폊榌\ue029縺\uf48e獚褠ߡ鸃ᐜ鋨⢽ꝫ", 616608716));
   }

   private static Object fis(Object var0, String var1, MinecraftClient var2) throws Exception {
      Method var3 = var0.getClass().getDeclaredMethod(var1, MinecraftClient.class);
      var3.setAccessible(true);
      return var3.invoke(var0, var2);
   }

   private static Entity fit(MinecraftClient var0, String var1, double var2) {
      OtherClientPlayerEntity var4 = new OtherClientPlayerEntity(var0.field_1687, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var5 = var0.field_1724.method_73189().method_1031(0.0, 0.0, var2);
      var4.method_5808(var5.field_1352, var0.field_1724.method_23318(), var5.field_1350, 180.0F, 0.0F);
      var4.method_5673(EquipmentSlot.field_6174, new ItemStack(Items.field_8523));
      var0.field_1687.method_53875(var4);
      return var4;
   }

   private static String fiu(Entity var0) {
      return var0 == null ? a.b("߂繲\uf4ba櫗\ue101枷\udded", 1479411627) : var0.method_5477().getString();
   }

   private static void fiv(kfx var0, String var1, boolean var2) {
      var0.getByName(var1).setEnabled(var2);
   }

   private static vmo fiw(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.b("ꑦ\udd9f坅줦䊢쑝縏\uf7b1", 1566876750) + var1);
   }

   private static void fix(MinecraftClient var0, float var1, float var2) {
      var0.field_1724.method_36456(var1);
      var0.field_1724.method_36457(var2);
      var0.field_1724.field_5982 = var1;
      var0.field_1724.field_6004 = var2;
   }

   private static void fiy(MinecraftClient var0, Vec3d var1) {
      Vec3d var2 = var1.method_1020(var0.field_1724.method_33571());
      fix(
         var0,
         (float)Math.toDegrees(Math.atan2(-var2.field_1352, var2.field_1350)),
         (float)(-Math.toDegrees(Math.atan2(var2.field_1351, Math.hypot(var2.field_1352, var2.field_1350))))
      );
   }

   private static void fiz(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.c(833923379, "ꥁ탥娵쑭侔줹"));
      var2.setAccessible(true);
      var2.set(null, var1);

      for (String var6 : new String[]{a.c(-762972457, "\uf6a7輈ל鮧ၻ雒Ⲯ"), a.b("\ue046駩ጽ赆ښ耳㩎", 1684135990)}) {
         Field var7 = hlc.class.getDeclaredField(var6);
         var7.setAccessible(true);
         var7.setFloat(null, Float.NaN);
      }

      var0.method_1507(new hlc());
   }

   private static void fja(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void fjb(MinecraftClient var0, String var1) {
      System.out.println(a.b("䟊㹭뒷⫌ꅝ➸鷺ᐝ詅 ", -2043131981) + var1 + a.d("㵒䒃츰", -471153242, 327153879) + var0.method_47599() + a.c(-993185052, "㋀䬷쇲往"));
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.d("\uf554賯ؿ顖Ꮔ镪", -1868410755, -1268669111) + var1 + a.c(-1187779207, "\ued53钼ṱ耉"),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
