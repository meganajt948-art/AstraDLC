package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

final class gkm {
   static final int gkn = Integer.getInteger(a.d("ﭺ苁ࠑ陸ᷪ魇⅔ꢮ㛡뱗㮙솩伢횄峑", 250015868, -1923871889), 2400);
   static final int gko = 1600;
   static final boolean gkp = a.d("\udba7", 1013606485, 1609216962).equals(System.getenv(a.b("恵菐ऀ革᳛騇⁅ꦿ㟰뵆㪈삇", 1281882657)));
   static final boolean gkq = a.b("‾", -2129518578).equals(System.getenv(a.d("駁\ue07a檪\uf4c3罱玲䏯쨕呚\udeec夢ꍃ\u2d9c됵㹫뢚˛贃", 1993108701, -1415973560)));
   static final boolean gkr = a.b("倁", 1338527793).equals(System.getenv(a.c(246098352, "⧦偝\uda8d䓤콖䦊\uf3c8稲\ue47d滋\ue905፤鶮М蹝ࢺ")));
   static final Random gks = new Random(11L);
   static Field gkt;
   static Field gku;
   static int gkv;
   static int gkw;
   static tiq gkx;
   static final gkj gky = new gkj(a.c(1704126509, "\ue840釬ᬧ蕚ຂ"));
   static final gkj gkz = new gkj(a.c(-1796949976, "례쇳䬫핛庅"));
   static final List<String> gla = new ArrayList<>();
   static final Map<String, Integer> glb = new TreeMap<>();
   static tkx glc;
   static int gld;
   static double gle;
   static double glf;
   static final LinkedList<double[]> glg = new LinkedList<>();
   static double glh;
   static double gli;
   static int glj;
   static int glk;
   static double gll;
   static double glm;
   static double gln;
   static double glo;
   static int glp;
   static float glq;
   static float glr;
   static boolean gls;
   static int glt;
   static int glu;
   static int glv;
   static boolean glw;

   gkm() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      if (var1 == 1) {
         gmb(var0);
         return false;
      }

      gmc(var0);
      if (var1 < 60) {
         return false;
      }

      ClientPlayerEntity var2 = var0.player;
      switch (gkv) {
         case 0:
            tiq var11 = tiq.open(a.b("㳁䕆쾜凧\uda02岂\ue6c7漱", 1780628634));
            if (var11 != null) {
               tiq.delete(var11);
            }

            gkx = tiq.create(a.d("쐻붼㝦ꤝ⋸ꑸḽ韋", 1925992372, -1430680620));
            if (gkp) {
               gkx.set(a.d("\ue009馿፹贇ۚ聼㩲돎\u2d9dꜶ\u20fe\uda95", -416062819, 1846248171), 1);
               gkx.set(a.d("译\uf267碡\ue6df洂\ueba4冪\ud818䙅쳿䬭", -1396128702, -2046930965), a.b("兇⣑ꈄ㱦랶\u3104", 285102354));
               gkx.set(a.b("컸띎㶈ꏶ⠫꺍ᒃ鴲ͦ觓ณ", 825216640), 2.0);
               gkx.set(a.c(625822132, "䧍ほ몽Ⓝ꼞⦸鎶ᨏ著\u0ef5"), 3.2);
               gkx.set(a.b("놐젦䋠\udc9e坃퇥毫\ue247簛\uf6bf煬謜", 799519215), 1.6);
               gkx.save();

               for (vmo var5 : glz().getSettings()) {
                                    if (java.util.Objects.equals(var5.getName(), a.d("㚲伊엀") || java.util.Objects.equals(var5.getName(), -2095181633) || java.util.Objects.equals(var5.getName(), 1183524424))) {
                     ((vmc)var5).set(360.0);
                  }
                  else if (java.util.Objects.equals(var5.getName(), a.d("髃\ue34f榍\uf7f4簽") || java.util.Objects.equals(var5.getName(), 191620579) || java.util.Objects.equals(var5.getName(), 1211334508))) {
                     ((vlv)var5).set(a.d("湕់鴏", 792875829, 1071463714));
                  }
                  else if (java.util.Objects.equals(var5.getName(), a.b("턬ꢰ≹및㟍녳ଭ苚") || java.util.Objects.equals(var5.getName(), 565956960))) {
                     ((vmc)var5).set(8.0);
                  }
               }

               tcz.startTest(gkx);
               if (gkr) {
                  ldr.activate(tiq.open(a.b("殑ቿ飒ۙ赲ீ뇤㱹ꈷ", 2086236039)));
                  gmd();

                  for (vmo var16 : ldr.get().getSettings()) {
                     if (var16.getName().equals(a.d("\uefb2阳ᳬ芔ो达㖹뱓≃ꢿ⽮픅寔쉳", -16820338, -1952597909))) {
                        ((vkl)var16).set(true);
                     }
                  }

                  ldr.get().setEnabled(true);
               } else {
                  glz().setEnabled(true);
               }

               gls = false;
               glp = 20;
               gkv = 4;
               gkw = var1;
               return false;
            }

            gkx.set(a.c(-636719267, "漢ᚔ鱒Ȭ觱བྷ땙㳥ꊶ⠝꿕喾"), 2);
            gkx.set(a.b("卑⫧ꀡ㹟떂㌤褪\u0098黅ᑿ鎭", -1478864087), a.c(-793764349, "ṍ柘\ued1a"));
            gkx.set(a.b("饂\ue0f5樵\uf44c羜臘䍢쫏哏\ude7a妽ꏁⴓ뒿㻡", -1082746567), a.b("\uda94ꌂ⧃략", -1484072234));
            gkx.save();
            ldr.activate(gkx);
            tcz.startRecording(gkx);
            gma(var1);
            break;
         case 1:
            int var10 = var1 - gkw;
            if (tcz.recorder() != null && tcz.recorder().paused) {
               glb.merge(tcz.recorder().pauseReason, 1, Integer::sum);
            }

            gme(var0, var2);
            if (var10 == 200) {
               gmk(var0, a.d("䏛㩡낢⻔ꔞ⏭馣ၓ踐Ӿ茺祍\uf796渺\ue47f抃\ud8cb圓", -300546295, 1770276014));
            }

            if (var10 >= gkn) {
               System.out
                  .println(
                     a.c(395866913, "獕૯耬Ṛ閐፮ꥩ₉뻀㑶돱䧒윒庥퓺刖\ue84f枟ﴻ笢\uf2cf裖٤鶨ᯐ酒")
                        + tcz.recorder().hits
                        + a.d("嗕Ⱒ\ua6fe㢊덅㗥辡ه頙ዬ", -444321357, -942840756)
                        + tcz.recorder().failures
                        + a.c(-70499842, "䇙㠼닲ⲉꝖ⇿鯿")
                        + tcz.recorder().recorded
                        + a.d("琛\u0dfa蜸ᥝ銌ᐫ깮⟌", 13753241, -1423986774)
                        + glb
                  );
               tcz.stop();
               System.out.println(a.b("ꢲ턈寋얽乷좉犎ﭮ攧\uef91栖", -1017272105) + gky.report());
               tcz.train(gkx);
               gma(var1);
            }
            break;
         case 2:
            tct var9 = tcz.job();
            if ((var1 - gkw) % 100 == 0) {
               System.out
                  .println(
                     a.c(-2025442772, "㉖䯬섯彙풓剭\ue86a憊ￃ畵\uf2f2ࣗ蘆ᾤ闿ጉꥁ⚗밭㨻")
                        + var9.progress.phase
                        + a.c(642589983, "┾")
                        + (var9.progress.epoch + 1)
                        + a.d("ᒇ", -1945029987, -472373708)
                        + var9.progress.epochs
                        + a.c(-477601634, "悻ᥜ鎘\u0de4虿")
                        + var9.progress.valLoss
                  );
            }

            if (var9.done) {
               if (var9.result == null) {
                  System.out.println(a.d("鮱\ue20b棈\uf6be絴ﮊ䆍졭嘤\udc92嬕ꄂ⿒뙫㰽몠»转ᗌ鎕ᩥ怳\uee87畟\uf37d禶", -1846368712, 817053181) + var9.error);
                  return true;
               }

               tck var13 = var9.result;
               System.out
                  .println(
                     String.format(
                        Locale.ROOT,
                        a.c(
                           -655294796,
                           "ﹼ蟆അ鍳ᢹ鹇⑀궠㏩륟㻘쓽䨬펎姕\udf23敧\ueab7灀\uf658羨ַ謁მ隻᰽ꗈ⯊녴㜿볉䈍졝冠ퟸ嵒\ue2d6梢\uee30矅\ufdd2茢६軚ᑞ騪⎸ꥍ⽑뒇㫥쀡䦕쾗啡\udb71悊\ue608污\uf5b4笇œ蚭೯鈻ᮗꇉ❡괳㊉롅㹣쟺䴘퍈墬\udefb摋\ueddc玨塞缡ӆ詑ၲ馾Ἁꕐ⫪낾㘆뿋䗨쭿傟훕尓\ue273段\uf141眓ﳩ芦ࡃ釚៤鴮⊌\ua8cc⸼둴㷂쌍䥇컠哤\uda55排\ue9f6潵\uf4cf窕z虿ྎ锒᭣ꂹ⛷걏㗐뮤䅸웕䳒퉥塪\ue1ce朙\ued62狾\uf84a縒߿跤፼飅ẟꑴ⩱뎄㤐뽤䒯쨚偀\ud9ee徺\ue502櫏\uf0d4癬ﰵ薏ୄ酡"
                        ),
                        (var9.finished - var9.started) / 1000.0,
                        var13.epochs,
                        var13.hits,
                        var13.steps,
                        var13.similarity,
                        var13.speedMatch,
                        var13.timeMatch,
                        var13.shapeMatch,
                        var13.overshootUser,
                        var13.overshootModel,
                        var13.userPeak,
                        var13.modelPeak,
                        var13.userEntry,
                        var13.modelEntry
                     )
                  );
               gma(var1);
            }
            break;
         case 3:
            int var8 = var1 - gkw;
            if (var8 == 1) {
               var0.setScreen(new hlc());
            }

            if (var8 == 10) {
               ign.open();
            }

            if (var8 == 40) {
               gmk(var0, a.b("鍳\ueac9怊ﹼ疶\uf345䤋샸庸푗厃꧳✵뺉㓜", -1664380142));
            }

            if (var8 == 50) {
               var0.setScreen(null);
            }

            if (var8 == 70) {
               gmd();
               tcz.startTest(gkx);
               ldr var12 = ldr.get();
               var12.setEnabled(true);
               gls = false;
               glp = 20;
               gma(var1);
            }
            break;
         case 4:
            int var3 = var1 - gkw;
            gmf(var0, var2);
            if (var3 == 300) {
               gmk(var0, a.b("伐㚪뱩∟꧕⼦镨Ლ苛࠳迱疖צּ", -593145997));
            }

            if (var3 >= 1600) {
               System.out.println(a.c(-779495075, "\ud938ꂂ⩁됷㿽뤃̄諤ᒭ鸛ᦜ") + gky.report());
               System.out.println(a.c(-1801777671, "ග琦ﻥ悓\ueb59涧힠幀쀉䪿촸") + gkz.report());
               System.out
                  .println(
                     String.format(
                        Locale.ROOT,
                        a.c(2007196590, "掄ᨾ都\u0e8b蕁ο릸じ긑⒧ꌠ夒ퟔ乸쐷䋆\uf892睊\uedf1殻\ue21e頀ᚲ购ଓ膃㡣똵ⳗꪉℰ\udfa5嗯찕䩙삿缫\uf55a玌\uea72怤ẓ钁ጽ觪ߗ빐㓼늹⥠꜋嶅퐾刣죙䚙ﵲ篤\uf19f栁\ue6b3鲣ᬔ鄑࿃虶㰭뫊"),
                        100.0 * glu / Math.max(1, glt),
                        glv
                     )
                  );
               Files.write(var0.runDirectory.toPath().resolve(a.c(-625204932, "ⅎ壵툥䱌쟞䅰ﭠ犚\uecd5晣\ue1adᮞ锐ರ蛵\u0003먖㖊꼩⥽")), gla);
               tcz.stop();
               ldr.get().setEnabled(false);
               glz().setEnabled(false);
               boolean var4 = gkz.overshoots <= Math.max(2, gky.overshoots / 4) && gkz.acquired >= gkz.episodes * 0.8 && gkz.offGrid == 0;
               System.out
                  .println(
                     a.d("ݺ绀\uf403橵\ue1bf杁\udd46咦쫯䁙쟞", -2012051141, -2141221340)
                        + (var4 ? a.d("胛糧玺\uedcb", -1873085776, 1331264063) : a.c(-1435804078, "帔➮군㌇룘"))
                  );
               return true;
            }
            break;
         default:
            return true;
      }

      return false;
   }

   static kgj glz() {
      return (kgj)Flow.getInstance().getModuleManager().getByName(a.d("ᖌ氕\ue6c2碟\uf37a痋쾂䙩\ud831", 2136601038, -1797331958));
   }

   static void gma(int var0) {
      gkv++;
      gkw = var0;
   }

   static void gmb(MinecraftClient var0) {
      var0.options.pauseOnLostFocus = false;
      gmj(var0, a.c(1377092853, "쒃봴㟫ꦒ≍꓾Ầ靖ौ莮ѻ︍烞\ue970挼\ue5da徘"));
      gmj(var0, a.c(624971756, "侕㘹볮⊗꤅\u2fe7関᱂艉ࢶ轤甕\ufbc3"));
      gmj(var0, a.d("鿨\ue65f沀\uf2f9礹ﾏ䗅창刧\ud8d2弊ꕐ⮢눋㡍뺹Ӹ謦ᆉ韯Ḣ摩\uead5焍\uf737綠쐔䩈킠囧", 2059195844, -1422243243));
      gmj(var0, a.b("䉥㯒넍⽴꒴∂顈ᆰ辪՟芇磔\uf621澝\ue5ff挭\ud973嚴찞䩈쎸맠㜔것⫻ꀧᦋ韌", 886587934));
      gmj(var0, a.b("ﭚ苨࠻陉ᶘ鬾ℹꢏ㛞뱰㮰솄伳횱岱\uda12恊\uef8d甤\uf36f窟Û蹧ᖻ鏂ᥖꂬ\u2efa됅㉛맯䜹쵫咋튝堾\ue7ee涟\ueb59犼\uf8e5蘓\u0c50", -712312044));
      gmj(var0, a.c(-2136931082, "Ҹ紊\uf7d9榫\ue27a擜\udedb坭줼䎒쑒㹦냑⥓ꍓ◱龬ၨ諚ಌ蕨Ｌ熂\uea55氫\ue6b4彎턘䯧춹䘍룛㊉ꭩ⵿\ua7dc᠌鉽ᒻ赞܇秱\uf3b2"));
      gmj(var0, a.d("쒔봪㟼ꦍ∖ꓹỹ霔ॎ菫Ѧ﹄炏\ue92f挢\ue580忓퀇䪠첯䔗㽃뇤⩫걇⚊鼨ᄧ讟\u0dcb虬磰\uf2bb歍\ued15枢\ud864分퓒䵱읠맘㎕됦⻱ꂛᥔ鏒ᖱ蹧\u000f\ufadf獣", 1895791654, -1546536735));
      gmj(var0, a.c(2034184372, "・䥅쎓巢홹傖\uea96捻ﴡ瞄\uf009ਦ蒯ᵍ霂ᇶꮭ␢뻞㢊녩쭦䖞\ude5a塻틥歓\ue516羬粒牍貗۞鼾\u197e鏈Ⰽ\ua632₺뤃㍇"));
      gmj(var0, a.c(1038854227, "꠫톔存씺亨졹爙﮻斩\uef1c棈銲ᱣ藃ྃ襵㌨벷♚ꀆ⧹厤\udd15䛅산䩚\uf3c5綐\ue77f愳\uea96"));
      gkt = vxr.find(
         Mouse.class,
         a.d("讞\uf224磦\ue6cd浙\uebec冸\ud842䘛첻䭻넍㿈꘣ⰽ\uaac3ႁ齂ױ莌ਗ灄ﻴ", -1166656787, 1589227786),
         a.d("螖︨瓷\uea8f慐\ue7da巧퐐䩀샺", -448739739, 1283867039),
         a.c(-1679076026, "唝")
      );
      gku = vxr.find(
         MinecraftClient.class,
         a.c(-347873512, "\udf61ꛛⰙ눲㦦뼓Շ貽ዤ顄ᾄ\ue5f2欷\uf2dc磂︼䑾쮽儎흳廨Ⓕꨉ"),
         a.d("尕▫꽴ㄌ뫓㱙虤ྒ釂\u1b7f", 1304887905, 1801215512),
         a.b("ग़", -2046031615)
      );
      long var1 = var0.getWindow().getHandle();
      GLFW.glfwSetCursorPosCallback(var1, (var0x, var2, var4) -> {});
      GLFW.glfwSetMouseButtonCallback(var1, (var0x, var2, var3, var4) -> {});
      GLFW.glfwSetScrollCallback(var1, (var0x, var2, var4) -> {});
      var0.player.getInventory().setSelectedSlot(0);

      for (String var6 : new String[]{
         a.d("ꠅ톒孚씥仲졁爅\ufbc4斶\uef1c", 2048177307, -1097982784),
         a.c(-2135397586, "武ዿ頨ٵ趐ଡ녨㢃ꛛ"),
         a.d("鏈\uea4d悟ﻵ甀\uf39d䧌쀻", -1878356177, 712907950),
         a.b("ﳈ蕍ྟ釵᨞鲋⛎꼮", 1359150209)
      }) {
         kfe var7 = Flow.getInstance().getModuleManager().getByName(var6);
         if (var7 != null) {
            var7.setEnabled(false);
         }
      }
   }

   static void gmc(MinecraftClient var0) throws Exception {
      if (gkt != null && var0.currentScreen == null) {
         gkt.setBoolean(var0.mouse, true);
      }

      if (gku != null) {
         gku.setBoolean(var0, true);
      }
   }

   static void gmd() {
      for (vmo var1 : ldr.get().getSettings()) {
                  if (java.util.Objects.equals(var1.getName(), a.d("\u18ff慇\ueb8d") || java.util.Objects.equals(var1.getName(), -649256303) || java.util.Objects.equals(var1.getName(), 2113550891))) {
            ((vmc)var1).set(360.0);
         }
         else if (java.util.Objects.equals(var1.getName(), a.c(595747638) || java.util.Objects.equals(var1.getName(), "捽\u1aee逪ๆ薎̨륮も껛⑫"))) {
            ((vlv)var1).set(a.d("䡟㇃묋╬꺣⠘", 447541621, -436160147));
         }
         else if (java.util.Objects.equals(var1.getName(), a.c(-822058171) || java.util.Objects.equals(var1.getName(), "按᪅遇\u0e3e藷"))) {
            ((vlv)var1).set(a.b("皑༏藋", 360871635));
         }
         else if (java.util.Objects.equals(var1.getName(), a.d("睵\u0ef4萫ᩓ醌\u1779굾⒔몄へ랩䷂쌓媴") || java.util.Objects.equals(var1.getName(), 234270201) || java.util.Objects.equals(var1.getName(), 1959779035))) {
            ((vkl)var1).set(false);
         }
         else if (java.util.Objects.equals(var1.getName(), a.d("欜ኀ顉ؿ跽ୃ넝㣪") || java.util.Objects.equals(var1.getName(), 520945119) || java.util.Objects.equals(var1.getName(), 2064225935))) {
            ((vmc)var1).set(8.0);
         }
      }
   }

   static void gme(MinecraftClient var0, ClientPlayerEntity var1) {
      List var2 = tcz.stands();
      if (!var2.isEmpty()) {
         if (glc == null || glc.isRemoved() || --gld <= 0) {
            tkx var3 = (tkx)var2.get(gks.nextInt(var2.size()));
            if (var3 != glc || glc == null) {
               glc = var3;
               glg.clear();
               glk = glj;
               gle = gks.nextGaussian() * 0.3;
               glf = 0.6 + gks.nextDouble() * 0.28;
               gky.episode();
            }

            gld = 40 + gks.nextInt(70);
         }

         Vec3d var38 = var1.getEyePos();
         Box var4 = glc.getBoundingBox();
         tbm var5 = new tbm();
         if (tbp.aim(
            var38.x,
            var38.y,
            var38.z,
            (var4.minX + var4.maxX) * 0.5,
            var4.minY,
            (var4.minZ + var4.maxZ) * 0.5,
            (var4.maxX - var4.minX) * 0.5,
            var4.maxY - var4.minY,
            gle,
            glf,
            var5
         )) {
            glg.addLast(new double[]{var5.yaw, var5.pitch});
            if (glg.size() > 6) {
               glg.removeFirst();
            }

            double[] var6 = glg.size() >= 4 ? glg.get(glg.size() - 4) : glg.getFirst();
            double[] var7 = glg.size() >= 5 ? glg.get(glg.size() - 5) : var6;
            double var8 = tbp.wrap(var6[0] - var7[0]);
            double var10 = var6[1] - var7[1];
            double var12 = tbp.wrap(var6[0] + var8 * 3.0 - var1.getYaw());
            double var14 = var6[1] + var10 * 3.0 - var1.getPitch();
            double var16 = 0.0;
            double var18 = 0.0;
            if (glk < glj) {
               double var20 = gmi((double)glk / glj);
               double var22 = gmi((double)(glk + 1) / glj);
               var16 += glh * (var22 - var20);
               var18 += gli * (var22 - var20);
               glk++;
            } else {
               double var43 = Math.hypot(var12, var14);
               if (var43 > Math.max(0.5, var5.bw * 0.55)) {
                  double var45 = 1.02 + gks.nextGaussian() * 0.08;
                  glh = var12 * var45;
                  gli = var14 * var45 * 0.9;
                  glj = Math.max(2, (int)Math.round(2.0 + 1.5 * Math.log(1.0 + var43 / 2.0) / Math.log(2.0)));
                  glk = 0;
                  double var24 = gmi(1.0 / glj);
                  var16 += glh * var24;
                  var18 += gli * var24;
                  glk = 1;
               }
            }

            var16 += var8 * 0.8;
            var18 += var10 * 0.6;
            gll = 0.6 * gll + gks.nextGaussian() * 0.07;
            glm = 0.6 * glm + gks.nextGaussian() * 0.04;
            var16 += gll;
            var18 += glm;
            double var44 = tcz.unit(var0);
            gln += var16 / var44;
            glo += var18 / var44;
            long var46 = (long)gln;
            long var47 = (long)glo;
            gln -= var46;
            glo -= var47;
            float var26 = var1.getYaw();
            float var27 = var1.getPitch();
            var1.changeLookDirection(var46 * var44 / 0.15, var47 * var44 / 0.15);
            double var28 = var1.getYaw() - var26;
            double var30 = var1.getPitch() - var27;
            boolean var32 = gmg(var1, var4);
            double var33 = tbp.wrap(var1.getYaw() - var5.yaw);
            gky.sample(var28, var30, var32, var33, var5.la, var5.ra, var5.bw, tbp.wrap(var6[0] - var7[0]));
            boolean var35 = false;

            for (tkx var37 : var2) {
               var35 |= gmg(var1, var37.getBoundingBox());
            }

            if (var1.getAttackCooldownProgress(0.5F) >= 0.9F && (var32 && gks.nextDouble() < 0.75 || var35 && gks.nextDouble() < 0.3)
               || gks.nextDouble() < 0.02) {
               gmh(var0);
            }
         }
      }
   }

   static void gmf(MinecraftClient var0, ClientPlayerEntity var1) {
      float var2 = var1.getYaw();
      float var3 = var1.getPitch();
      if (gls) {
         double var4 = var2 - glq;
         double var6 = var3 - glr;
         Entity var8 = gkp && !gkr ? glz().pilotTarget() : ldr.get().target();
         double var9 = tcz.unit(var0);
         double var11 = var4 / var9;
         gkz.gridTicks++;
         if (Math.abs(var11 - Math.rint(var11)) > 0.01 && Math.abs(var4) > 1.0E-4) {
            gkz.offGrid++;
         }

         if (var8 != null) {
            Box var13 = var8.getBoundingBox();
            Vec3d var14 = var1.getEyePos();
            tbm var15 = new tbm();
            if (tbp.aim(
               var14.x,
               var14.y,
               var14.z,
               (var13.minX + var13.maxX) * 0.5,
               var13.minY,
               (var13.minZ + var13.maxZ) * 0.5,
               (var13.maxX - var13.minX) * 0.5,
               var13.maxY - var13.minY,
               0.0,
               0.7,
               var15
            )) {
               boolean var16 = gmg(var1, var13);
               gkz.sample(var4, var6, var16, tbp.wrap(var2 - var15.yaw), var15.la, var15.ra, var15.bw, 0.0);
               gla.add(
                  String.format(
                     Locale.ROOT,
                     a.d("퓢괒➉맱㈭뒆ງ蜼ᥪ鏐ᐙ\uee3a悧蘭獇\uf5ab侱쀪媐\udcca唠⼤ꇝ㨅밻", -683513179, 510967419),
                     gla.size(),
                     var4,
                     var6,
                     tbp.wrap(var15.yaw - var2),
                     var15.pitch - var3,
                     var16 ? 1 : 0
                  )
               );
            }
         }
      }

      if (--glp <= 0) {
         glp = 50 + gks.nextInt(60);
         double var17 = (gks.nextBoolean() ? 1 : -1) * (35.0 + gks.nextDouble() * 70.0);
         double var21 = tcz.unit(var0);
         long var23 = Math.round(var17 / var21);
         var1.changeLookDirection(var23 * var21 / 0.15, 0.0);
         gkz.episode();
      } else if (gkq) {
         gll = 0.85 * gll + gks.nextGaussian() * 0.9;
         glm = 0.85 * glm + gks.nextGaussian() * 0.35;
         if (gks.nextDouble() < 0.04) {
            gll = gll + (gks.nextBoolean() ? 1 : -1) * (4.0 + gks.nextDouble() * 4.0);
         }

         double var18 = tcz.unit(var0);
         gln = gln + gll / var18;
         glo = glo + glm / var18;
         long var22 = (long)gln;
         long var24 = (long)glo;
         gln -= var22;
         glo -= var24;
         var1.changeLookDirection(var22 * var18 / 0.15, var24 * var18 / 0.15);
      }

      glq = var1.getYaw();
      glr = var1.getPitch();
      gls = true;
      glt++;

      for (tkx var5 : tcz.stands()) {
         if (gmg(var1, var5.getBoundingBox())) {
            glu++;
            break;
         }
      }

      Entity var20 = gkp && !gkr ? glz().pilotTarget() : ldr.get().target();
      if (var20 == null && glw) {
         glv++;
      }

      glw = var20 != null;
      if (var1.getAttackCooldownProgress(0.5F) >= 0.9F && var0.targetedEntity instanceof tkx) {
         gmh(var0);
      }
   }

   static boolean gmg(ClientPlayerEntity var0, Box var1) {
      Vec3d var2 = var0.getEyePos();
      Vec3d var3 = var2.add(var0.getRotationVec(1.0F).multiply(6.0));
      return var1.raycast(var2, var3).isPresent() || var1.contains(var2);
   }

   static void gmh(MinecraftClient var0) {
      KeyBinding.onKeyPressed(KeyBindingHelper.getBoundKeyOf(var0.options.attackKey));
   }

   static double gmi(double var0) {
      var0 = Math.max(0.0, Math.min(1.0, var0));
      return var0 * var0 * var0 * (10.0 - 15.0 * var0 + 6.0 * var0 * var0);
   }

   static void gmj(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   static void gmk(MinecraftClient var0, String var1) {
      System.out.println(a.b("撫ᴌ韖ভ舼ә뺛㝼ꤤ⏁", -367958830) + var1);
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(1175503320, "솸렃㋓겺✨ꆆ") + var1 + a.d("ࣕ焺ﯷ斏", -475594086, -2036463003),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
