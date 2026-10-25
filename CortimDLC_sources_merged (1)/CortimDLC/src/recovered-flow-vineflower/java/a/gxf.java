package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Method;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.glfw.GLFW;

final class gxf {
   private static final String[] gxg = new String[]{
      a.b("\ue1b9頼የ貄ݎ臬", 286974462),
      a.b("膩\uf833狧\uec81杏\ue1f3", -1340177951),
      a.d("\uf3a5訲ì麐ᕞ鏮", 1093878435, 1254666567),
      a.b("\uf1cd衚ʒ鳾\u173f醟", 1486549400),
      a.d("쒧봹㟩ꦂ≄ꓢ", 2093519116, 793531886)
   };
   private static final int gxh = 40;
   private static final int gxi = 40 + gxg.length * 40 + 80;
   private static String gxj;
   private static int gxk = -1;
   private static String gxl;

   private gxf() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfe var2 = gxr(a.d("꘤\udfae啴쬀䃖왰簂\uf5cb殆", -1400977260, -633049366));
      kfe var3 = gxr(a.c(-1467238690, "뚗켒䗀\udbaa偁훔沑\ue571"));
      kfe var4 = gxr(a.d("\uf655迒Ԗ魣Ⴇ阁ⱨꖴ㯢녏㚉쳯", -279031647, 1297524395));
      if (var1 == gxk) {
         gxu(var0, a.b("֧簎\uf6cf棪", -1700592176) + gxj);
      }

      if (var1 == 1) {
         gxt(var0, a.b("ጓ檤\ue07b縂\uf5dd獮줶䃆\udedc吮포⦊ꝙ㻽뒳㉝蠁", -1376840859));
         gxt(var0, a.d("琝න蝦\u191f銍ᑯ긪⟊링㍦뒳仂쀕", -1797451190, -1527290322));
         gxt(var0, a.c(1548471383, "찭떎㽙ꄽ⫶걊ᘎ龭Ʊ謏ೕ\uf6a0硤"));
         gxt(var0, a.b("桩ᇞ鬁ո躸ࠎ뉄㮼ꖦ⽓ꢋ勑\udc23䖊쿌䤸\uf379粧\ue608恮\ue9a3鏨ᵔ蚌¶訡㎕뷉✡ꅦ", -340170736));
         gxt(var0, a.d("\ue105颻ቡ谔ߐ脳㬀닂", -247866706, -1525072960));
      } else if (var1 == 20) {
         gxo(var0, 0.0F, -8.0F, a.c(-130127514, "椗Ⴑ驭Л迉ॸ댦"), var1);
      } else if (var1 >= 40 && var1 < gxi - 80) {
         int var9 = (var1 - 40) / 40;
         int var10 = (var1 - 40) % 40;
         if (var10 == 0) {
            ((vlv)gxs(var2, a.c(159696790, "쟆빏㒎"))).set(gxg[var9]);
            var2.setEnabled(true);
            uxi.timing(true);
            gxo(var0, 0.0F, -12.0F, gxg[var9].toLowerCase(), var1);
         } else if (var10 == 12) {
            uxi.gpuMillis();
         } else if (var10 == 24) {
            System.out
               .println(
                  a.b("垰⸙ꓘ㫰", 1992447943)
                     + gxg[var9]
                     + a.c(-877436460, "懱᠇鋃ಷ蜵")
                     + uxi.gpuMillis()
                     + a.c(-2018424916, "䞊㹶뒻⪙ꄮ⟿")
                     + var0.getCurrentFps()
                     + a.b("錏\ueaf8怽﹏", -1476422869)
               );
            gxo(var0, 140.0F, -50.0F, gxg[var9].toLowerCase() + a.d("웋뼢㗴", -2012466074, -895421821), var1);
         }
      } else if (var1 == gxi - 75) {
         ((vlv)gxs(var2, a.b("僻⥲ꎳ", 799035563))).set(a.b("䠅㆟뭋┭껣⡟", -1308014515));
         ((vmc)gxs(var2, a.d("킊ꤜ⏒붸㙼냘ઊ茵ᴨ鞗၍\uea37擪", 1956890364, 696063539))).set(0.0);
         gxo(var0, 0.0F, -12.0F, a.c(-566170689, "\uebd6鉦ᢲ蛔\u0d11诪ㇺ렊♘곧⬽텇徚"), var1);
      } else if (var1 == gxi - 60) {
         ((vmc)gxs(var2, a.d("ﰀ薖མ鄲\u1af6鱒☀꾿ㆢ묝㳇욽䡠", -1709473202, -913015285))).set(1.0);
         ((vkl)gxs(var2, a.c(1115575454, "哝ⵍꞓ㧣뉱㒃軟ܭ饨Ꮘ鐌"))).set(false);
         gxo(var0, 0.0F, -12.0F, a.d("⪹匉\ud9dd䞻챾䪅\uf098祦\ue73a涑\uea53ဵ", -439619257, 747428758), var1);
      } else if (var1 == gxi - 45) {
         ((vkl)gxs(var2, a.c(2126270775, "兴⣤ꈺ㱊럘ㄪ譶ʄ鳁ᙡ醥"))).set(true);
         gxo(var0, 0.0F, -12.0F, a.c(-2001020906, "\ud879ꇉ⬝땻㺾롅ə讦ᗰ齊ᢓ"), var1);
      } else if (var1 == gxi - 30) {
         gxo(var0, 0.0F, -88.0F, a.c(379244016, "춘됨㻼ꂚ⭟궤ហ鹎\u001a説ൢ\uf70f"), var1);
      } else if (var1 == gxi - 15) {
         ((vlv)gxs(var2, a.b("\uf72e躧Ѧ", -611453058))).set(a.d("므쉗䢟훳崲\udb92", -1674279482, -834519469));
         gxo(var0, 180.0F, -10.0F, a.b("臑\uf866犮\uecc2會\ue1a3宩툆䱟웵", -412253784), var1);
      } else if (var1 == gxi) {
         uxi.timing(false);
         ((vlv)gxs(var2, a.b("⮎切\ud8c6", -738579490))).set(a.d("ㅀ䣅숑屽ힷ儕", -613721265, -373134776));
         gxo(var0, 0.0F, 0.0F, a.b("軋\uf77d綳\ue3d9栝\ueeb9哫", -1439199580), var1);
         gxt(var0, a.c(570476759, "좡넖㯉ꖰ\u2e6f\ua8dcኄ魴ծ辌࡙\uf22f糼\ue552漞\ue9f8厺"));
         gxt(var0, a.c(-399674710, "犁ଭ臯ᾖ鐌ዯꢫ⅏뼌㖰뉡䠖욄彰픨參\ue991晝ﳣ竫\uf37c褞߾鱦᨞郗⥷ꜭ㷀뮊〤컾䓦\udd0a孊톬湥\ue409拆\ufb3f焭࿘薌ȶ飧ᚇ꽇◱ꎬ㠳똎䳄앨䌨\ud9d3垰\uec3f櫧\ue0ad祖\uf7fa趡\u0a4f耎Ệ靾"));
         gxt(
            var0,
            a.b(
               "\uf3ae訂À麹ᔣ鏀⦄ꁠ㸣뒟㍎줹䞫\ude5f吇틬梾\ue772緌\ufbc4牓࠱蛑ᵉ鬱ᇸꡘ☂볯㪥넋俑엉尢\uda65傃\uef4a攦\ue3e9稐\uf002軷ң茙ᧈ鞨\u2e68ꓞ⊃뤜㜡췫䑇숇壼횟洐\uebc8憂\uf879盕ಎ譠ġ鿩ᙑ갾⫹ꂪ㼜뗄㎳쩽䃟\ude8b啨퍱榟\ue047縻\uf4ff犧छ蟐ᶾ鑧ዟꢔ❀봩㮑뉅䠵웾嵦\udb07凑\uefb3晷ﳆ窊\uf176輤\u05cd鱛ᨬ郸⽙ꕇ⏷릠〖컒䒅썧夥힕湖\ue46b拣壘眝෩讣Ȗ飵ᚷ굩⬪ꆓ㠘뙳䢡켂䕚\udba8冎\ue842溝\ue4e1缫\uf1a0瞩๛萟᪾酷ᝑ궨⎍빖㓽",
               -279907489
            )
         );
         gxt(
            var0,
            a.d(
               "⮰刜\ud8de䚧촽䯞\uf19a硾\ue63d沁\ueb50ᄧ龵ف谙\u0af2날㽬ꗒ⏚ꩍ퀯廏앗䌯짦灆\ufe1c擱\ue2bb椕韏ᷗ落ɻ袝㝔봸㯷ꈎ⠜囩\udcbd嬇쇖侶\uf676糀瞧愂\uef3bᗶ鱌ᨅ胪ຬ딾㏘릦\u2073껁풯卪\ud93f䟷칍琘\uf2f8碼\ue70a淋\uebf4ቲ飕ڀ赶\u0b3a놉㡨꘨⳨ꪵ턎徇엪䠽컫瓋סּ慠\ue3c3渗鑵᪪腦݆覞㞕",
               1202682835,
               -802467736
            )
         );
         gxt(
            var0,
            a.d(
               "傺⤖ꏔ㶭똷ピ誐ʹ鴷ឋ遚樭\ue4bf絋\uf713燸쮪䑦\uded8壐텇ꬥ◅빝㠥달ୌ蔖Ώ馱ሟ\uecc5曝［祱\uf397䱞옲䃽\ud904化ⷣꞷ\u200d뫜㒼赼ߊ膗ᨈ鐱滸\ue746愘ﯱ疻츆䣥스孽헂꾜⡿ꈽ㳽땇༪觭ξ鰈ᛐ邧楩\ue3cb綟\uf67c灥쪍䍈\udd3f執톽ꨌ⓯뺩㝷뇈\u0b91萶ṽ鳸ᔆ\uef79懒謁硜\uf683䢁셑宐\ud9d0剛Ⱶꛕ㼉",
               1970188207,
               1065352981
            )
         );
         gxt(
            var0,
            a.c(
               1043354762,
               "咇\u2d2b\ua7e9㦐눊㓩躭݉養Ꮆ鑧渐\ue082祶\uf32e病쾗䁛\udae5峭핺꼘⇸멠㰘뛑ཱ脫ᯆ鶌ᘢ\ue8f8拠\ufb0e絜\uf7fd䡽숒䓜\udd71坦⧚ꎍ\u243b뻧ゐ襒ϰ薸ṻ遆櫃\ue37f政\uffd0熌쨤䳮욀彀퇍ꮰⱓꘓ㣏녯ଗ跐ރ頵ይ钚浔\ue7f6禢\uf241瑘캰䝵\ud902及햀긱⃒몔㍊뗵ྫྷ耋ᩀ飶ᅅ\ueb42斜︪硱\uf6a9䢢섌宪"
            )
         );
         gxt(
            var0,
            a.c(
               1808482395,
               "䁭㧁댃\u2d7aꛠ 驇Ꭳ跠ݜ肍竺\uf468涜\ue7c4愯\udb7d咱츏䠇손믲㔒꺊⣲ꈻᮛ闁༬襦ˈﰒ瘊\uefe4榷\ue317岗훸倶즛䎌㴰띧パꨍ⑺鶸\u171a酒ઑ蒬縣\uf782燈\ueb37敧\udee3堆퉻䮣씈뽲㢷닢Ⱚꖐ\u1fc5餥፡賗ؖ耩禯\uf308浝\ue6ab惧\uda54厵췵䜵셨뫓㑚긷⏞ꕉἓ邝\u0acf蠙Ʋ﮸畻\ueeca"
            )
         );
         gxt(
            var0,
            a.d(
               "\uec15閹ύ脂ઘ豻㘿뿛↘ꬤ\u2cf5횂堐쇤䮼쵗眅\uf8c9扷\ue47f淨ដ饪˲蒊ใ럣㦹ꍔ┞꺰偪\uda72䎜엌佯\uf0ef窀ﱎ旣\ueff4酈ᬟ鲩ٵ蠂㇀뭢㴪ꛩ⣔퉌寽\uddbe䝋줉犟\uf478縏\ue7d9楥ጲ铐Ẓ聚৹돤㕌뼍₺ꩮⰄ헙彚세䫆첝瘤ﾯ懄\uef03楏ዳ鰯ا讙व댐㲟ꚹ②귊埀\ud902",
               2090656541,
               -1951920321
            )
         );
         gxt(
            var0,
            a.c(
               -774508021,
               "\uf207讫ũ鼐ᒊ鉩⠭ꇉ㾊딶㋧좐䘂\udff6單퍅椗\ue6db籥舘珺ঘ蝸᳠骘ၑ꧱➫뵆㬌낢乸쑠嶎\udbdf兽\ueefd撒\ue25c篱\uf1e6轚ԍ芻ᡧ阐⿒ꕰ⌸룻㛆챈䗴쎯奝휛沉\uea62怍燎睉മ諙\u008f鹋\u17fc궾⭜ꄌ㺯됲㈚쯓䅤\udf30哚튏栌\ue1ee羐\uf553猊࣡蘪ᡮ醞ᜯ굷⋶룟㹡랸䶰쌓壖\udef9呁\uee58柱ﴽ筸"
            )
         );
         gxt(var0, a.d("뭶싚䠘홡巻\udb18慜\ue8b8盻ﱇ箖臡ཱི隇᳟騴\u2066꾪㔔댜㪋䃩츉喐폨夢\ue087滕\uf431爼秊ݐ赈ᒧ鋩ᡄ\ua7dbⷧꬰ㊆룒옥䱧쯅儕\udf76曫\uec17橆\uf190翩蔃ಈ諒ဨ鹪◀ꌓ⤥냥㹕", 384920718, 1493686188));
         gxt(var0, a.c(-507755810, "䊋㬧뇥⾜ꐆ⋥颡ᅅ輆ֺ艫砜\uf68e潺\ue522揉\ud99b噗쳩䫡썶뤔㟴걭⨕ꃟ\u197a霨\u0dcc证lﺭ璵\ued5a欔\ue1b9带퐚勍쭻䄯㿘떚㈸꣨⚋鼖ᗹ鎻ࡢ蘝糎\uf578猣\ue9eb枖\udc2d嫤킊䥍"));
      } else if (var1 == gxi + 15) {
         var3.setEnabled(true);
         var0.setScreen(new iwf((ivw)var3, -1));
         gxp(a.b("\udf4bꛥⰻ뉊㦔뽤ռ貙ዑ顠", -1272455370), var1);
      } else if (var1 == gxi + 30) {
         Method var5 = iwf.class.getDeclaredMethod(a.d("⽾囎\udc10䉼", -1716200507, -214502182), int.class);
         var5.setAccessible(true);
         var5.invoke(var0.currentScreen, 1);
         gxp(a.d("숟뮱ㅯ꼞Ⓚꈰᠾ釞ྎ蔴ˮ", 2146113667, 700635872), var1);
      } else if (var1 == gxi + 45) {
         PlayerInventory var7 = var0.player.getInventory();
         ivw var6 = (ivw)var3;
         var6.assign(0, var7.getStack(12));
         var6.assign(1, var7.getStack(13));
         var6.assign(2, var7.getStack(14));
         var0.setScreen(new iwf(var6, -1));
         gxp(a.b("\uf694輺פ鮕။隻ⲣꕝ㬇놶㙬찜", 840627951), var1);
      } else if (var1 == gxi + 49) {
         gxq(var0, 0.5F, 0.32F);
      } else if (var1 == gxi + 60) {
         ((ivw)var3).pick(2);
         var0.setScreen(null);
      } else if (var1 == gxi + 70) {
         System.out
            .println(
               a.b("介㝢붣⎋ꠋ⺥铻ᴊ荜ড踡瑔歹挵\ue92c濇헇娟사䛳켍땓㯪ꁢ", 1980059296)
                  + var0.player.getOffHandStack().getName().getString()
                  + (
                     var0.player.getOffHandStack().getName().getString().contains(a.d("焦ࣲ艐᱔音", 1499429615, -1918955539))
                        ? a.c(-1372385264, "ဵ槴\ue336絕\uf682")
                        : a.b("ꄩ\ud8fe刪챓䞁", 356229388)
                  )
            );
         var4.setEnabled(true);
         vlq var8 = (vlq)gxs(var4, a.b("磣ů训ᗔ鹎ᢨꋤ⬘땇㿿", 151091360));
         var8.set(72);
         var4.onKey(var0, 72);
         gxp(a.c(-1904588063, "䪚㌴맪➛걅⪵那ᥟ蜉ඤ詢瀄"), var1);
      } else if (var1 == gxi + 74) {
         gxq(var0, 0.62F, 0.42F);
      } else if (var1 == gxi + 85) {
         var0.setScreen(null);
         ((vlq)gxs(var4, a.b("敊᳆阄ࡽ菧ԁ뽍㚱꣮≖", 1981768969))).set(-1);
         var4.setEnabled(false);
         var3.setEnabled(false);
         gxl = isv.selected();
         isv.select(a.c(-1020334405, "\ueec2靫ᶪ莘ࠔ躱㓥봉⍋ꧩ"));
         var0.setScreen(new hlc());
         gxp(a.d("䌀㪹끡⸋ꖄ⍹餾\u10c8躊Ц菦", 1396068737, -629271833), var1 + 10);
      } else if (var1 == gxi + 110) {
         isv.select(a.c(-1393836138, "뿯왆䲇튵夶\udf8c旘\uec3e牸\uf8c4"));
         gxp(a.c(1969699761, "㯗䉮좶囜\udd53审\ue1f9栏\uf647糯בּ"), var1);
      } else if (var1 == gxi + 125) {
         isv.select(a.c(-1460742908, "핽곔☕렧㎹딎ཆ蚪ᣣ鉃"));
         gxp(a.b("齱\ue6c8氐\uf27a秵：䕏첥勧\ud840徂", 1870307095), var1);
      } else if (var1 == gxi + 140) {
         isv.select(a.b("懲ᡔ銛೯蜠ƌ믘㉽걫⛈ꄑ孾햮䰌옓䂡\ufae9甶\uef8a槇", 1963745668));
         gxp(a.b("\uea32鎋ᥓ蜹ಶ詚】맧➣괉", 40299093), var1 + 15);
      } else if (var1 == gxi + 170) {
         gxp(a.d("襬\uf0d5稍\ue467濨\ue904协\udab9䓽칗䧆돶㴬ꒈ⻊꠬", 832447595, -2064863878), var1);
      } else if (var1 == gxi + 185) {
         isv.select(gxl);
         var0.setScreen(null);
         var2.setEnabled(false);
         gxt(var0, a.b("騱\ue386楙\uf720糠節䀜짤埾\udd0b嫓ꂉ\u2e7b럒㶔뭠ġ軿ᑐ鈶\u1bfb憰\uef0c瓔\uf2ee硫쇞侈핯", 90413643));
         gxt(var0, a.b("맍쁺䪥퓜弃\ud9b0揨\uea18琂ﻰ礲荔ඇ鐣ṭ颃⋟", -1530349125));
         return true;
      }

      return false;
   }

   private static void gxo(MinecraftClient var0, float var1, float var2, String var3, int var4) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
      gxp(var3, var4);
   }

   private static void gxp(String var0, int var1) {
      gxj = var0;
      gxk = var1 + 10;
   }

   private static void gxq(MinecraftClient var0, float var1, float var2) {
      int[] var3 = new int[1];
      int[] var4 = new int[1];
      GLFW.glfwGetWindowSize(var0.getWindow().getHandle(), var3, var4);
      GLFW.glfwSetCursorPos(var0.getWindow().getHandle(), var3[0] * var1, var4[0] * var2);
   }

   private static kfe gxr(String var0) {
      kfe var1 = Flow.getInstance().getModuleManager().getByName(var0);
      if (var1 == null) {
         throw new IllegalStateException(a.b("Ӣ絒\uf7ce槲\ue227撝\udedf圷쥡䎕", 704185478) + var0);
      } else {
         return var1;
      }
   }

   private static vmo gxs(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.b("車\uf733緩\ue38a栎\ueef1咣\udd1d", -637563166) + var1);
   }

   private static void gxt(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   private static void gxu(MinecraftClient var0, String var1) {
      System.out
         .println(a.b("폝ꩺ₠뻛㕊뎯৭耊Ṓ钷", -1202728028) + var1 + a.d("儥⣴ꉇ", -1595525772, -944544654) + var0.getCurrentFps() + a.d("\ud862ꆕ⭐딢", -1519773701, -73674819));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.d("읈뻳㐣ꩊ⇘ꝶ", 2105204273, -146532071) + var1 + a.b("睨ງ葊ᨲ", -497649854),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
