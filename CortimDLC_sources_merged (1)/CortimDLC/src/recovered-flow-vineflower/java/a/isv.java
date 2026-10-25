package a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public final class isv {
   public static final vlv FIT = new vlv(
      a.c(1594806204, "쿹뙧㲩"),
      a.d("哭\u2d68Ꞻ㧐", -1832121426, -1124835578),
      a.d("姄⁁ꪓ㓹", 1406095829, 1098713172),
      a.d("㜸亦쑰威", 1718428303, -896592395),
      a.b("ꎿ\uda21僯", 1056744442)
   );
   public static final vmc DARKEN = new vmc(a.d("쫂덖㦖ꟾⰧꪝ", 597683531, -1740888117), 0.3, 0.0, 0.9, 0.05).percent();
   public static final vmc MOTION = new vmc(a.d("㊀䬓쇛德푦勖", -412184341, 136159776), 0.6, 0.0, 1.0, 0.05).percent();
   public static final vkl PARTICLES = new vkl(a.d("줰낰㩰ꐇ⿍ꥶጪ髒қ", -1395487446, 773473347), true);
   public static final String WORLD = a.c(-1535440022, "ଘ犱\uf87f昐\uedcf");
   static final float isw = 0.7F;
   static final float isx = 0.95F;
   public static final String DEFAULT = a.c(298037884, "눅쮫䅵\udf05哘툼栳\ue1c8羔\uf53d犴袌ٞ鿼ᖶ");
   static final String[][] isy = new String[][]{
      {a.d("嶧\u243c껬ゅ묅㷖螫๗逊᪳", 1549861911, 1368218108), a.b("锞\ueca5晵\uf81c玑\uf569伿웝墛", 1694733681), a.b("뱀엵伢텖媄\udc33", -1868841866)},
      {a.b("갃햘彈섡䪡챧瘋\ufffb憹\ueb19", 902212687), a.b("쮜눧㣷ꚞⴓꯣᆵ顊ؚ買", -2082419728), a.c(292262441, "鉪\uebdb愈ｺ璮\uf21e")}
   };
   static final String[][] isz = new String[][]{
      {a.b("ሴ殧\ue161缗", -1821765005), a.b("ꅶ\ud8c5刃챵", -1709006575), a.c(-1642025373, "ꩿ폪奅읎䲛쨨")},
      {a.b("눆쮑䅙\udf35哴퉔桓\ue1cb羮\uf500狚袽", 731165273), a.c(-473269146, "簊֡轭ᄕ體"), a.d("䵦㒈빘\u202bꮂⴿ靮\u1a8f胍ੱ覲矔滑悿\ueae6汥홝", -1279266724, -1373325003)},
      {a.b("\uec06閆ὓ脺", -930026426), a.c(1593637829, "ﮥ舅࣐隹"), a.c(1557960506, "錜\ueacf恣\ufe1b疹\uf372䤣")},
      {a.d("节\ufb07燓\uefbf摵\ue2d7", -2072326435, 1501973528), a.c(171995385, "炞ऻ華ᶃ陉ძ"), a.c(805714384, "㷆䑕컴僻\udb52嶓")},
      {a.d("ᮔ戎\ue8da皼ﵲ篎", -1051202588, 1636954168), a.b("ꊼ\udb06凒쾴䑺싆", -1270308140), a.c(-601101234, "\ue866醶ᬚ蕧ຽ蠌㉜믒▎꼱")},
      {a.c(543200213, "鎟\uea0b惀ﺵ畾\uf3c2"), a.b("ᎄ樰\ue0fb纎\uf545珹", -1700588562), a.d("䭴㋫렴♋궘⭖鄆\u18f9", -715955066, -718525460)},
      {
            a.d("햴갨⛧뢏㍟뗥\u0ff3虬᠔銫ᕷ\uef1a", -857589004, -302780659),
            a.d("\udddbꑧ⺨냀㬐붪ޱ踃ၛ髤ᴸ\ue755", -301590589, -641611147),
            a.d("쮵눯㢋ꚉⵙꯩᇂ顈؝賓\u0f6f\uf103翗\ue61f汇", -1281197122, 1304802324)
      },
      {a.c(-604987192, "ꂝ\ud919収춵䙺"), a.b("䡹㇝묊╱꺾", -98220020), a.b("락컫䑍\uda34冓휧洂", 1702409064)},
      {a.c(-1073667916, "⃯她펿䷝옞䂨\ufaf6猇"), a.d("좒네㯢ꖀ⹃ꣵካ魚", 714851130, 1590954963), a.d("﷾葪\u0ebe郍ᬙ鶢⟰긎さ", 1273053523, -2068793165)},
      {a.b("嘑⾄ꕒ㬤냡㘉谹פ鮵ᄖ雂", -1798810025), a.d("펲ꨇ⃑뺧㕢뎇চ聧Ḷ钕ፁ", -84044472, 720979612), a.d("桰ᇦ鬻Ը躕ࡒ뉳㾛ꗕ⽠\ua8c6勂\udc13", -220200377, 1583181350)},
      {a.d("⮌刚\ud8dc䚾쵷䯃\uf18d砨\ue61b沇\ueb5eᄡ", -850181059, 1198813166), a.c(-1182093686, "껵흃嶅쏧䠮캚瓔ﵼ换\ue9de渇鑸"), a.b("漥ᚱ鰁Ȗ观ེ딪㳐Ꚛ⠵꿯喜\udb3e䋱", -1366463684)},
      {a.b("붧쐲任킍字\uddbf果\uee54瀌襁絳", 1638972897), a.d("\uf44e跻ܲ饄ኞ鑻\u2e75ꞝ㧅덿㒺", 1218673103, -1304654361), a.b("䨥㎋뤧✪겋⹑逐ᷳ蟎ൾ諒炯\ufe75柌", 432295434)},
      {
            a.d("㼋䚑챏刼\ud9e1彜\ue518治\uf288研ￍֲ", -108792356, 1636289180),
            a.d("栰ᆊ魔ԧ軺ࡇ눃㮭ꖳ⼏꣖助", -1720544287, -1944978502),
            a.d("刣⮼ꅮ㼖듄㉷蠠ǝ龎ᔴ雲條\ue643翰\uf5d6獙", 1581988101, -1320063187)
      },
      {a.b("\ud878ꇡ⬺땜㺘려ɿ诊ᗹ齥ᢼ\ue2c3", 1755240497), a.d("\ueb5f鋦ᠽ虛ඟ謣ㅸ룀⛞걢⮻퇄", -1228137259, 506329059), a.d("㓴䵪쟍姃퉨哚\ueefe朆讀珠\uf026้肗ᤤ錂ᖍ", 1941314427, -1830212729)},
      {a.c(851606702, "糣պ辪ᇓ騅Ჿꚢ⼠녉㯼"), a.d("ᵂ擻\uee2b灒ﮄ紾윮亁탈婽", -1725266030, -1031890243), a.d("惾ᥦ鎰හ虯¢뫺㜞굝⟮ꁃ婇", -990004506, 1858395651)},
      {a.c(-1193110433, "鐟\ued86杚郎独"), a.c(-1539998991, "窑̨觴គ鱂"), a.b("ꑴ\uddd5圎쥼", -846290861)},
      {a.c(1308522483, "瞲า蓺᪀酁"), a.c(1433816987, "俺㙚벒⋨ꤩ"), a.d("⯋删\ud880䚇", -1930829015, 369216754)},
      {a.d("䦓〙뫋⒱꽱⧌鎇", -1967193060, 511593947), a.c(-476039222, "㞾且쓆媼텼埁\ued8a"), a.b("뱛엳伩턪嫱", 1175500927)},
      {
            a.b("∲室텹伇쓌䈩\uf81b燇\uef98攠\ue2ef", -854777225),
            a.b("⤧傑\uda4c䐲쿹䤑\uf30e竲\ue4ad渕\ue9da", -219469502),
            a.d("맸쁪䫀퓋弟\ud9a9柣\uea0d瑘ﺜ示茽ඒ鐦ṱ", -1127000797, 805562569)
      },
      {a.c(-1483311598, "癖࿊蔖᭽邻ᘝ걒▾"), a.d("ꡳ퇏嬓앸亾젘牗﮻", -1450055781, -448245876), a.b("ᴡ撊\uee5a瀦ﮁ絈윙仪", 1505499405)},
      {a.b("䰜㖖뽁™ꫣⰝ阺\u1ff0膷ଔ賐", -1503835069), a.d("ꛓ\udf79單쯍䀌웿糵\uf51f歘\ue1fb昿", -1522865981, 1806388847), a.c(-1465944331, "狘୵膢ῑ鐇ዎ꣦ℝ뼽㇣눡䡑웾强픛")},
      {a.c(-253953181, "שּׂ芵ࡩ阗᷌魹"), a.d("ᜃ溻\ue467稙\uf1c2睷", -1494382754, 2026737715), a.b("钨\ued0c柒瑩牵\uf4c0", -763129717)},
      {a.b("灙\u09da范ᵬ隼သꨌ⎓뷫㝔낈䫥", -1392414714), a.c(-662453789, "솜렿㋦겉❙ꇻᯤ鉖ఎ蚱ŭﬀ"), a.c(1062331809, "\ue1b1頣\u1289貂ݘ膖㾪눺Ⱄꚯ℅\udb77嗐")},
      {a.c(772618092, "㜮亹쑥娑퇟坭\ued28"), a.c(-955127068, "\uea86錱᧭螙\u0c57諥゠"), a.d("ꛂ\udf54嗵쯺䀤욝糋\uf537", -1760093288, 79673669)},
      {a.b("\ue329骼ၼ踋׀荫㤣냈⺁", 843899749), a.c(-98242446, "\uf01e覫ͫ鴜ᛗ遼⨴ꏟ㶖"), a.b("⏕婈탤云씽䎆ﷁ瀇\uee7a擂\ue316ᥤ", 329197515)},
      {a.d("￠虳\u0cbb鋐ᤙ", 1259971352, -245998419), a.d("봅쒶乾퀕寜", -325963832, -1057647944), a.d("﵈蒦ญ遳ᮯ鴒", -878545718, -1431335525)},
      {a.c(-1788440756, "輞\uf699籝\ue23f槾"), a.c(849212209, "\uf343諤 鹂ᖃ"), a.d("ꃙ\ud944厒췥䙄", -823471733, 1929803077)},
      {a.b("⃫奴펤䷕였", 1615405228), a.d("땣쳜䘌\ud87d厨", -1616177246, 560308902), a.d("뢭섈䯜헚幺\ud8c3投\ueb69", 1658056068, 370823431)}
   };
   static final String[][] ita = new String[][]{
      {a.b("䐚㶈띊⤨ꋦ\u2450鸊", -1362541490), a.b("♢忐픒䭰삾䘈ﱒ", 1980507670)},
      {a.c(284617204, "\ue9ba造\u1afe蒘ཏ觵㏿멢␔꺡⥥팇巆"), a.b("Ἆ暴\uec6a爌率罡", 383786859)},
      {a.d("䂏㤊돘ⶨꙧ⃕髈ፚ货ރ聗", 754663102, 1786674811), a.c(856732834, "듈쵭䞿\ud9cf刀풲溢\ue71d祀\uf3e4琰")},
      {a.b("䌇㪔끕⸣ꗬ⍔饂ჺ躢ѝ菚禷\uf76d溙\ue4a9扷\ud83b埰쵒䬔", 280511312), a.b("酃\ue8f0戱ﱇ瞈\uf130", 1228902694)},
      {a.d("⪽匫\ud9f5䞄챖䫠\uf0ba礌\ue720涬\uea7eဗ", 361453095, 1062108368), a.b("ￏ虣ಱ鋘", 619577272)},
      {a.b("㖃䰊웋壣퍙嗀\uef97晣\uf837犞", 61289946), a.b("밮얄佖텸嫱\udc58昙", 480099393)},
      {a.d("ꂦ\ud939叱춞䘅샣窮\uf342洁\ue7f8恍騖ᓂ赫ܪ臌㮂", 971849989, -596778507), a.b("翎ٵ貥ዌ餉ᾯꗽ", 1414692783)},
      {a.c(-1151348670, "퀎ꦚ⍚봲㚮끺\u0a00菻"), a.b("ꈮ\udb96兏", 1556062792)},
      {a.b("≚寝턁佺쒬䈊\uf842熴\uefe2攔\ue2b4\u18f7阬྅藑̳르", -1157619172), a.d("ꌷ\uda94偋츢䗲썐礋", 264168695, -1291302988)},
      {a.b("臸\uf86f犧\ueccb朊\ue1aa宭툺䱂웠䄬", -659586656), a.c(535672963, "룡셗䮗헹")}
   };
   static final int itb = 2560;
   static final int itc = 192;
   static final int itd = 108;
   static final ExecutorService ite = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, a.b("ⷨ味\udea3䃊쭘䷻\uf7ff縘\ue04a櫻\ued34\u1754馒6該ಂ", 103099838));
      var1.setDaemon(true);
      return var1;
   });
   static final ExecutorService itf = Executors.newFixedThreadPool(3, var0 -> {
      Thread var1 = new Thread(var0, a.c(2078655510, "쑆뷝㜍ꥤ⋶ꑕṑ鞶\u09e4荕Қﻺ瀼\ue998揜\ue57f彤킩䨇챎䖶㿶"));
      var1.setDaemon(true);
      var1.setPriority(1);
      return var1;
   });
   static final List<isn> itg = new ArrayList<>();
   static final List<isq> ith = new ArrayList<>();
   static boolean iti;
   static String itj = a.b("秲\\誂ᓲ鼯\u19cbꏄ⨿둣㻊륃䍻충吋\ude41", -1821214325);
   static uok itk;
   static String itl;
   static float itm = -1.0F;
   static float itn = -1.0F;
   static CompletableFuture<BufferedImage> ito;
   static String itp;
   static volatile String itq;
   static final BufferedImage itr = new BufferedImage(1, 1, 1);

   isv() {
   }

   static List<isn> entries() {
      if (!iti) {
         rescan();
      }

      return itg;
   }

   static void rescan() {
      iti = true;
      ArrayList<isn> var0 = new ArrayList<>(itg);
      itg.clear();
      itg.add(itu(var0, new isn(a.b("䑺㷓뜝⥲ꊭ", -721533944), a.c(1419028856, "ꤪ킣婭쐂保"), null, null)));

      for (String[] var4 : isy) {
         isn var5 = itu(var0, new isn(a.b("뛔콺䖤\udbd4倉훭", 541243044) + var4[1], var4[0], whl.poster(var4[1]), null, null, var4[1]));
         var5.fill = Integer.parseInt(var4[2], 16);
         itg.add(var5);
      }

      for (uxt var24 : uxt.values()) {
         itg.add(
            itu(
               var0,
               new isn(
                  a.c(574584315, "疌థ蛤ᣖ") + var24.title.toLowerCase(Locale.ROOT), a.d("\ue153飇ላ豩\u07fb", 1451393691, 683828097) + var24.title, null, null, var24
               )
            )
         );
      }

      for (String[] var25 : ita) {
         itg.add(itu(var0, new isn(a.c(1947858897, "\uf7a1踏ӑ骡ᅼ鞘") + var25[1], var25[0], whl.poster(var25[1]), null, null, var25[1])));
      }

      for (String[] var26 : isz) {
         itg.add(
            itu(
               var0,
               new isn(
                  a.d("뀷즑䍞\udd2a囥큉樝\ue3b8", -286070969, -900376806) + var26[1],
                  var26[0],
                  a.c(-549743858, "錰\ueac8怑﹣疬\uf345䥎삩廻푊厅ꧥ✣뺇㓃눳ࠠ") + var26[1] + a.c(688199602, "ម湭\ue4a4竂"),
                  null
               )
            )
         );
      }

      ArrayList<String> var13 = new ArrayList<>();

      for (Path var22 : itw()) {
         if (Files.isDirectory(var22)) {
            try (Stream<Path> var27 = Files.list(var22)) {
               var27.filter(isv::itv).sorted().forEach(var2 -> {
                  String var3 = var2.getFileName().toString();
                  if (!var13.contains(var3.toLowerCase(Locale.ROOT))) {
                     var13.add(var3.toLowerCase(Locale.ROOT));
                     String var4x = var3.substring(0, var3.lastIndexOf(46));
                     itg.add(itu(var0, new isn(a.c(738646596, "\uda27ꎙ⥏뜷㲿") + var3, var4x, null, var2)));
                  }
               });
            } catch (IOException var9) {
               System.out.println(a.b("汹ᗊ鼖Į說\u0c4f뙐㾤ꇡ⭗곐", -1475384303) + var22 + a.b("䈱㮚", 1900495369) + var9);
            }
         }
      }

      for (isn var23 : var0) {
         if (!itg.contains(var23) && var23.thumb != null) {
            iug(var23.thumb);
         }
      }

      if (find(itj) == null) {
         itj = a.d("묍스䡪혅巚", -1602450682, 144060537);
      }
   }

   static isn itu(List<isn> var0, isn var1) {
      for (isn var3 : var0) {
         if (var3.key.equals(var1.key) && Objects.equals(var3.file, var1.file)) {
            var3.failed = false;
            if (var3.thumb == null) {
               var3.thumbLoad = null;
            }

            return var3;
         }
      }

      return var1;
   }

   static boolean itv(Path var0) {
      String var1 = var0.getFileName().toString().toLowerCase(Locale.ROOT);
      return Files.isRegularFile(var0)
         && (
            var1.endsWith(a.b("椠\u10cf騂Ѻ", -448829174))
               || var1.endsWith(a.d("ᡒ憧\ueb6e甈", -980247980, -410287572))
               || var1.endsWith(a.d("蝆ﺳ瑺\uea1e懋", 839537380, 1307432329))
               || var1.endsWith(a.b("鷘\ue425滹\uf095", 492477938))
               || var1.endsWith(a.c(1863453429, "\u0adf猧狀构"))
         );
   }

   static List<Path> itw() {
      return List.of();
   }

   static void openFolder() {
   }

   public static String selected() {
      return itj;
   }

   static boolean photoSelected() {
      isn var0 = find(itj);
      return var0 != null && !var0.isWorld() && !var0.isLive() && !var0.isVideo();
   }

   public static void select(String var0) {
      entries();
      itj = find(var0) != null ? var0 : a.c(-664324189, "㟑乸쒶嫙턆");
   }

   static String next() {
      List var0 = entries();
      int var1 = var0.indexOf(find(itj));
      isn var2 = (isn)var0.get((var1 + 1) % var0.size());
      itj = var2.key;
      return label(var2);
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static String label(isn var0) {
      if (var0.isWorld()) {
         return wap.value(a.c(-204771466, "漤ᚭ鱣Ȍ觓"));
      }

      if (!var0.isUser() && wap.ru()) {
         if (var0.isLive()) {
            return switch (var0.sky) {
               case AURORA -> a.d("隮\uef31旨ﮛ瀳\uf2ed䲮앝孰톿嘒갓", 2137722992, -335969596);
               case NEBULA -> a.b("䱤㗻뼢⅑\uaaf9⠧阖ῦ臆\u0b7b貥盔\uf800懎\ueb9e浡", -798472094);
               case GALAXY -> a.b("綮б軨ႛ鬳᧭Ɬ\u2e5f뀋㪱뵨䝡짌偿\uda26", -774211145);
               case SUNSET -> a.c(271997063, "岚┅꿜ㆡ멱㣙蚝ཫ鄾ᮅ鰤");
               case CLOUDS -> a.d("䅻㣤눽ⰵꞜ┸魵ኋ賞٤膽篆", -808562496, -1949035103);
               default -> var0.name;
            };
         } else {
            kbs var1 = kbs.byKey(var0.key);
            if (var1 != null) {
               return var1.title();
            }

            for (String[] var5 : isz) {
               if (var0.key.equals(a.b("ꬑ튷塸옌䷃쭯焻\uf89e", -1358845061) + var5[1])) {
                  return var5[2];
               }
            }

            return var0.name;
         }
      } else {
         return var0.name;
      }
   }

   static isn find(String var0) {
      for (isn var2 : itg) {
         if (var2.key.equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   static GpuTextureView frame(int var0, int var1) {
      iuh();
      isn var2 = find(itj);
      itn = -1.0F;
      if (var2 != null && !var2.isWorld() && !var2.isLive() && !var2.failed && var0 >= 16 && var1 >= 16) {
         uok var8 = itx(var2, var0, var1);
         if (var2.isVideo()) {
            float var9 = Math.min(1.0F, 2560.0F / var0);
            int var10 = Math.round(var0 * var9);
            int var6 = Math.round(var1 * var9);
            GpuTextureView var7 = var2.fill >= 0
               ? whl.get(var2.video).placed(var10, var6, hlc.contentCenterX(), hlc.contentCenterY(), 0.95F, var2.fill)
               : whl.get(var2.video).fitted(var10, var6);
            return var7 != null ? var7 : (var8 != null ? var8.view : null);
         }

         if (var8 == null) {
            return null;
         }

         float var4 = (float)MOTION.get();
         if (var4 > 0.001F) {
            GpuTextureView var5 = upi.photo(var8, uxt.time(), var4, PARTICLES.get(), iov.tone());
            if (var5 != null) {
               return var5;
            }
         }

         return var8.view;
      } else {
         if (itk != null) {
            iug(itk);
            itk = null;
            itl = null;
            itm = -1.0F;
         }

         if (var2 != null && var2.isLive() && var0 >= 16 && var1 >= 16) {
            GpuTextureView var3 = upi.sky(var2.sky, Math.round(var0 * 0.7F), Math.round(var1 * 0.7F), uxt.time());
            itn = var3 != null ? var2.sky.luminance : -1.0F;
            return var3;
         } else {
            return null;
         }
      }
   }

   static uok itx(isn var0, int var1, int var2) {
      int var3 = Math.min(2560, Math.max(256, (var1 + 63) / 64 * 64));
      int var4 = Math.round(var3 * ((float)var2 / var1));
      String var5 = var0.key + a.c(-459523315, "㭰") + var3 + a.b("ʍ", 1067516660) + var4 + a.d("圍", 239565320, -614650504) + FIT.get();
      itq = var5;
      if (itk != null && var5.equals(itl)) {
         return itk;
      }

      if (ito == null || !var5.equals(itp)) {
         itp = var5;
         String var6 = FIT.get();
         ito = CompletableFuture.supplyAsync(() -> var5.equals(itq) ? iub(itz(var0), var3, var4, var6) : itr, ite);
      }

      if (ito.isDone()) {
         BufferedImage var7 = ito.getNow(null);
         ito = null;
         if (var7 == itr) {
            itp = null;
         } else if (var7 == null) {
            var0.failed = true;
            System.out.println(a.c(-664270660, "࣊煹ﮥ斝\uee19棼틣嬑앀俴졣㉅버┸꽫⦆鏘ᰘ蚾ø襝") + var0.name);
         } else {
            if (itk != null) {
               iug(itk);
            }

            itk = uok.upload(a.d("瘪ྍ蕓ᬢ郩ᙉ갋◯뮧", -1125567290, 1535132306), var7, false);
            itl = var5;
            itm = ity(var7);
         }
      }

      return itk;
   }

   static float luminance() {
      return itk != null ? itm : itn;
   }

   static float ity(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      double var3 = 0.0;
      int var5 = 0;

      for (int var6 = var2 / 5; var6 < var2 * 4 / 5; var6 += 4) {
         for (int var7 = var1 / 5; var7 < var1 * 4 / 5; var7 += 4) {
            int var8 = var0.getRGB(var7, var6);
            var3 += 0.2126 * (var8 >> 16 & 0xFF) + 0.7152 * (var8 >> 8 & 0xFF) + 0.0722 * (var8 & 0xFF);
            var5++;
         }
      }

      return var5 == 0 ? 0.4F : (float)(var3 / var5 / 255.0);
   }

   static uok thumbnail(isn var0) {
      if (var0.thumb != null || var0.isWorld() || var0.failed) {
         return var0.thumb;
      }

      if (var0.isLive()) {
         if (RenderSystem.isOnRenderThread()) {
            var0.thumb = upi.still(var0.sky, 384, 216, 63.0F);
            var0.failed = var0.thumb == null;
         }

         return var0.thumb;
      } else {
         if (var0.thumbLoad == null) {
            var0.thumbLoad = CompletableFuture.supplyAsync(() -> iub(iua(var0, 384, 216), 192, 108, a.b("⧎偐\uda86䓷", 1774004620)), itf);
         } else if (var0.thumbLoad.isDone() && RenderSystem.isOnRenderThread()) {
            BufferedImage var1 = var0.thumbLoad.getNow(null);
            if (var1 == null) {
               var0.failed = true;
            } else {
               var0.thumb = uok.upload(a.d("芩\ufb0e燐\uefa1摪\ue2ca墈텬伤엇䉀렭㛧꽎┒", -872687546, -1526179177), var1, false);
            }
         }

         return var0.thumb;
      }
   }

   static BufferedImage itz(isn var0) {
      try {
         if (var0.resource != null) {
            try (InputStream var1 = ezj.open(var0.resource)) {
               return ImageIO.read(var1);
            }
         } else {
            return ImageIO.read(var0.file.toFile());
         }
      } catch (Exception var6) {
         System.out.println(a.c(1565477579, "䪣㌐만⟴거⪕邔ᥲ蜩ඝ訊") + var0.name + a.b("\udaceꍥ", 163306230) + var6);
         return null;
      }
   }

   static BufferedImage iua(isn var0, int var1, int var2) {
      try (
         InputStream var3 = var0.resource != null ? ezj.open(var0.resource) : Files.newInputStream(var0.file);
         ImageInputStream var4 = var3 == null ? null : ImageIO.createImageInputStream(var3);
      ) {
         if (var4 == null) {
            return null;
         }

         Iterator var5 = ImageIO.getImageReaders(var4);
         if (var5.hasNext()) {
            ImageReader var24 = (ImageReader)var5.next();

            try {
               var24.setInput(var4, true, true);
               int var7 = Math.max(1, Math.min(var24.getWidth(0) / var1, var24.getHeight(0) / var2));
               ImageReadParam var8 = var24.getDefaultReadParam();
               var8.setSourceSubsampling(var7, var7, 0, 0);
               return var24.read(0, var8);
            } finally {
               var24.dispose();
            }
         } else {
            return null;
         }
      } catch (Exception var22) {
         return itz(var0);
      }
   }

   static BufferedImage iub(BufferedImage var0, int var1, int var2, String var3) {
      if (var0 == null) {
         return null;
      }

      float var4 = (float)var0.getWidth() / var0.getHeight();
      float var5 = (float)var1 / var2;
      boolean var6 = var3.equals(a.c(-251317271, "㎬䨲샼")) || var3.equals(a.c(1063451959, "ﵲ蓷ล遏")) && var4 < var5 * 0.72F;
      BufferedImage var7 = new BufferedImage(var1, var2, 1);
      Graphics2D var8 = var7.createGraphics();
      iuf(var8);
      iuc(var8, var0, var1, var2);
      if (var6) {
         BufferedImage var9 = iud(var7, Math.max(1, var1 / 28), Math.max(1, var2 / 28));
         var8.drawImage(var9, 0, 0, var1, var2, null);
         var8.setColor(new Color(0, 0, 0, 90));
         var8.fillRect(0, 0, var1, var2);
         float var10 = Math.min((float)var1 / var0.getWidth(), (float)var2 / var0.getHeight());
         int var11 = Math.round(var0.getWidth() * var10);
         int var12 = Math.round(var0.getHeight() * var10);
         var8.drawImage(iud(var0, var11, var12), (var1 - var11) / 2, (var2 - var12) / 2, null);
      }

      var8.dispose();
      return var7;
   }

   static void iuc(Graphics2D var0, BufferedImage var1, int var2, int var3) {
      float var4 = Math.max((float)var2 / var1.getWidth(), (float)var3 / var1.getHeight());
      int var5 = Math.max(var2, Math.round(var1.getWidth() * var4));
      int var6 = Math.max(var3, Math.round(var1.getHeight() * var4));
      var0.drawImage(iud(var1, var5, var6), (var2 - var5) / 2, (var3 - var6) / 2, null);
   }

   static BufferedImage iud(BufferedImage var0, int var1, int var2) {
      BufferedImage var3 = var0;
      int var4 = var3.getWidth();

      int var5;
      for (var5 = var3.getHeight(); var4 / 2 >= var1 && var5 / 2 >= var2; var3 = iue(var3, var4, var5)) {
         var4 /= 2;
         var5 /= 2;
      }

      return var4 == var1 && var5 == var2 ? var3 : iue(var3, var1, var2);
   }

   static BufferedImage iue(BufferedImage var0, int var1, int var2) {
      BufferedImage var3 = new BufferedImage(Math.max(1, var1), Math.max(1, var2), 1);
      Graphics2D var4 = var3.createGraphics();
      iuf(var4);
      var4.drawImage(var0, 0, 0, var3.getWidth(), var3.getHeight(), null);
      var4.dispose();
      return var3;
   }

   static void iuf(Graphics2D var0) {
      var0.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      var0.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   }

   static void iug(uok var0) {
      ith.add(new isq(var0, unf.frame()));
   }

   static void iuh() {
      long var0 = unf.frame();
      ith.removeIf(var2 -> {
         if (var0 - var2.iss > 2L) {
            var2.isr.close();
            return true;
         } else {
            return false;
         }
      });
   }
}
