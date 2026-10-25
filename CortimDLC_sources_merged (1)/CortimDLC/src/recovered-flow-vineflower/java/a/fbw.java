package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

final class fbw {
   private static final String fbx = System.getenv()
      .getOrDefault(a.b("핍곶☦롏㏽딡ཬ蚉ᣑ鉳ᖾ\uefc0愕\uf8b9狣\uf41d乗솏", 1381225753), a.d("⤭储\uda7c䐞쿼䥼\uf339竏", 1538060898, -1509238010));
   private static final boolean fby = a.b("ᯪ戚", 419896216).equals(System.getenv(a.d("飖\ue16d殽\uf5d4繦\uf8ba䋷쬒啊\udfe8堥ꉉⲎ딬㽷릁", -1720076646, 1120742938)));
   private static final int fbz = 2400;
   private static final Field fca = vxr.find(
      ClientPlayerEntity.class,
      a.d("籍\u05f7輵ᄞ骊᰿ꙫ⾑뇈㭨벨䛞젛凰\udbee崐\ue752梑\uf222瑟ﷀ螒ण", -924784086, 1023120926),
      a.b("\uef3f隁ᱞ舦৹轳㕌벷⋥ꡑ", 1219161939),
      a.b("ߘ", -245168225)
   );
   private static final Field fcb = vxr.find(
      ClientPlayerEntity.class,
      a.d("銍\ueb37懵\uffde瑊\uf2ff䢫셑弈햨剨ꠞ⛛뼰㔮돐\u0992虑᳢骟ጀ楒\ue7e3", -1991564925, 1375777655),
      a.b("띻컅䐚\uda62冽휷洈\ue4f3窧\uf011", 159364887),
      a.d("\uf1b3", -1911433442, 1338189546)
   );
   private static final Random fcc = new Random(7L);
   private static final Set<Integer> fcd = new HashSet<>();
   private static final List<double[]> fce = new ArrayList<>();
   private static final List<double[]> fcf = new ArrayList<>();
   private static final List<Double> fcg = new ArrayList<>();
   private static final List<Double> fch = new ArrayList<>();
   private static Field fci;
   private static Field fcj;
   private static float fck = Float.NaN;
   private static float fcl;
   private static int fcm = -1;
   private static int fcn;
   private static int fco;
   private static int fcp;
   private static int fcq;
   private static final tbm fcr = new tbm();
   private static double fcs = Double.NaN;
   private static int fct;
   private static double fcu;
   private static double fcv;
   private static int fcw;
   private static Entity fcx;
   private static int fcy = -1;
   private static final List<Integer> fcz = new ArrayList<>();
   private static int fda;

   private fbw() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      ClientPlayerEntity var2 = var0.player;
      if (var2 == null) {
         return false;
      } else if (var1 == 1) {
         fdd(var0);
         return false;
      } else {
         fdn(var0);
         if (var1 < 60) {
            return false;
         } else if (fcm < 0) {
            fde(var0);
            fcm = var1;
            return false;
         } else {
            int var3 = var1 - fcm;
            fdf(var0, var2);
            fdh(var0, var2);
            if (var3 >= 2400) {
               fdm();
               tcz.stop();
               vzz.simulated = null;
               return true;
            } else {
               return false;
            }
         }
      }
   }

   private static void fdd(MinecraftClient var0) {
      fdo(var0, a.b("恣᧔錋൲蚲\u0004멎㎶궬❙ꂁ嫒퐧䶛쟹䄫ﭵ璲\uee18桎\ue1be鯦ᔒ躅ࣽ舡㮍뗊", 641359896));
      fdo(var0, a.d("푤귖✅륷㊦됀ง螱᧠鍎ᒎ\ueeba怍憐玏\uf52c佴삳娚\udc51喡\u2fe5ꅙ㪅볼㙨辒Ǆ鬻ᵥ雑标\ue255箵ﶣ眀죐䊡쑧嶂ퟛ꤭⍮", 193277433, 1505425875));
      fdo(var0, a.c(-1590780541, "鷍\ue47f溬\uf0de笏ﶩ䞮츘偉\udae7崧꜓⦤뀦㨦버ۙ褝Ꭿ闹ᰝ晙\ue8f7猠\uf55e翁옻䡭튒哌\udf78↮\uabfc㈜됊㺩腹ଈ跎ᐫ鹲\ue084櫇"));
      fdo(var0, a.d("{秅\uf313浢\ue6f9怖\uda16叻춡䜄삉㪫둠ⷀ\ua7cdⅯ鬼ᓨ蹏ࡀ臸ﮬ甋\uee84梨\ue265寇허佰줤䊃밟㙔꾢⧺ꍍ\u1c8b雩ွ覞Ώ紷\uf77a烉\uea1e摴\uddbb圽텞䪈쓠㸰람", -1913349282, 830380918));
      fdo(var0, a.c(1472904838, "뻉읷䶡폐塋\udea4撤\ued49猓禮縻萔ઝ鍿ᤰ鿄▟ꨐレ뚸㽛䕔쮬偨홉峗\ue561欤\uf19e矋ﱿʥ裬ᄌ靌᷺ꈿ⠀꺈㜱뵵"));
      fdo(var0, a.c(1132876923, "吃ⶼꝰ㤒늀㑑踱ޓ馁ጴ铠溚\ue04b秫\uf3ab畝케䂟\uda72尮헑꾌ℽ뫭㲘뙲\u0fed膸᭗鴛ᚾ"));
      fci = vxr.find(
         Mouse.class, a.c(1301380534, "総ѵ躷ႜ鬈ᶽ\ua7e9⸓끊㫪봪䝜즙偲\uda6c岒\ue6d0椓\uf3a0痝ﱆ蘕ࢥ"), a.b("璍ള蟬ᦔ鉋ᓁ껼✋륛㏡", -1974373151), a.d("\uf2ad", -2038234296, -1778847298)
      );
      fcj = vxr.find(
         MinecraftClient.class,
         a.c(68073431, "랮츔䓖\udafd兩ퟜ消\ue472稫\uf08b睋贽ϸ験ဍ雳ⲱꍲ㧁뾼㘧䱴싆"),
         a.d("䒍㴳러⦔ꉋⓁ黼ᜊ襚ϧ", -789126292, -591812723),
         a.d("㞘", -1857656419, 1284333150)
      );
      long var1 = var0.getWindow().getHandle();
      GLFW.glfwSetCursorPosCallback(var1, (var0x, var2, var4) -> {});
      GLFW.glfwSetMouseButtonCallback(var1, (var0x, var2, var3, var4) -> {});
      var0.player.getInventory().setSelectedSlot(0);

      for (String var6 : new String[]{
         a.d("䑡㷶뜾⥁ꊖ␥鹡ហ角\u0378", 2057064799, -1076357792),
         a.b("⏊婓킄仙씼䎍龍瀯\uee77", 180102018),
         a.c(-1782438086, "❳延퐤䩎솻䜦ﵷ璀"),
         a.d("퐗궒❀뤪㋁둔ฑ蟱", 1953805047, 575104681),
         a.d("ṥ柿\ued3c獊\uf880縟쑤䶑", -1428883204, 416802527)
      }) {
         kfe var7 = Flow.getInstance().getModuleManager().getByName(var6);
         if (var7 != null) {
            var7.setEnabled(false);
         }
      }
   }

   private static void fde(MinecraftClient var0) {
      tiq var1 = tiq.open(fbx);
      if (var1 == null) {
         throw new IllegalStateException(a.b("ⱈ嗸\udf64䅅쪐䰼\uf666羘\ue1c2歺\uecec", 645475373) + fbx);
      }

      var1.set(a.b("㻰䝆춀叾\ud823庅\ue48b洷\uf364秏︇Ѭ", 1332166287), 1);
      var1.set(
         a.b("錡\uea97恑︯痲\uf354䥚샨庵퐏叝", 1739559769),
         System.getenv().getOrDefault(a.c(-814160754, "\ue4d9鵢ឲ觛ɩ蒵㻸뜝⥅ꏧ\u242a\ude57傇줣䍿얄翜"), a.d("踥\uf7b3給\ue304棔\uee66", -1322815012, -358547540))
      );
      var1.set(a.d("︽螋്錳ᣮ鹈⑆귷㎣뤖㻖", 1616466373, -773345408), 2.0);
      var1.set(a.c(1555997550, "ꌗ\udaa1偧츙䗄썢祬\uf0d5溍\ue42f"), 3.2);
      var1.set(a.b("輣\uf695籓\ue22d槰\uef56啘\udcf4䊨젌俟떯", 699961180), 1.6);
      var1.save();
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.c(-11815150, "띑컂䐔\uda65冟휚济\ue4ac"));

      for (vmo var4 : var2.getSettings()) {
         switch (var4.getName()) {
            case a.c(901710615, "͍竁\uf009湭\ue5af挃\ud956傦"):
               ((vlv)var4).set(a.d("ࠋ熀ﭖ攮\ueef2桙", 175681583, -77809551));
               break;
            case a.d("皒༒藚᮶遦", 697800270, -681647974):
            case a.d("詵\uf3e6礬\ue74e泜\uea2b偷\ud997", 565697721, 146953865):
            case a.b("栛ᆖ魈ԡ軪ࡌ눞", 318990412):
               ((vkl)var4).set(true);
               break;
            case a.c(1628227637, "졼뇯㬱ꕑ"):
            case a.d("浰ᓽ鸴X讕ശ띪㻓ꃛ⩼궢埓\ud91b", -733271769, -1242676210):
               ((vkl)var4).set(false);
               break;
            case a.d("鉗\uebdb愙｠璩", 85436674, 1991785241):
               ((vlv)var4).set(a.b("츴랪㵮", 548785782));
               break;
            case a.c(-1450119321, "\uef31隣ᱥ舔ূ"):
            case a.d("貎\uf50c翈\ue1bf橵\uecce嚟\udf63", -1678477354, 1035795206):
               ((vmc)var4).set(1.0);
               break;
            case a.c(490584658, "먗쎯䥥"):
               ((vmc)var4).set(360.0);
               break;
            case a.c(172477368, "쯴뉨㢡ꛗⴕꮫᇵ頂"):
               ((vmc)var4).set(4.0);
               break;
            case a.c(1737822369, "ც楳\ue3a4綘\uf607炻쫤䌛\udd4b埦"):
               ((vlv)var4).set(a.b("짟끌㪔ꓤ⼺", -883570281));
         }
      }

      kwf.useStudio(fby ? null : var1);
      System.out
         .println(
            a.d("ぞ䧻쌯嵍훛倹\uea6d掉\ufdd9睢\uf0a6\u0a84萇ᶧ韢ᄔꬕⓞ", -1975724845, -456596226)
               + (fby ? a.b("뤅삖䩘퐠忸\ud94c挖\ueaa2瓬", 497138012) : var1.name + a.d("秙)諮ᒘ齜ᦢꎹ⨜된㻠", 980957280, 2128757139) + (var1.auraModel() != null))
         );
      tcz.startTest(var1);
      var2.setEnabled(true);
   }

   private static void fdf(MinecraftClient var0, ClientPlayerEntity var1) {
      if (--fcq <= 0) {
         fcq = 15 + fcc.nextInt(35);
         fcp = fcc.nextInt(3) - 1;
      }

      fcd.clear();
      fdg(var0.options.leftKey, fcp < 0);
      fdg(var0.options.rightKey, fcp > 0);
      fdg(var0.options.forwardKey, fcc.nextInt(4) == 0);
      var0.options.jumpKey.setPressed(var1.isOnGround() && fcc.nextInt(25) == 0);
      vzz.simulated = fcd::contains;
   }

   private static void fdg(KeyBinding var0, boolean var1) {
      var0.setPressed(var1);
      if (var1) {
         fcd.add(KeyBindingHelper.getBoundKeyOf(var0).getCode());
      }
   }

   private static void fdh(MinecraftClient var0, ClientPlayerEntity var1) {
      float var2 = vxr.getFloat(fca, var1, var1.getYaw());
      float var3 = vxr.getFloat(fcb, var1, var1.getPitch());
      Entity var4 = kwf.target();
      if (var4 != fcx) {
         fcx = var4;
         fcs = Double.NaN;
         fct = 0;
         fcy = var4 != null && fdi(var1, var4, var2, var3) >= 15.0 ? -1000 : -1;
         if (fcy == -1000) {
            fda++;
         }
      }

      if (!Float.isNaN(fck) && var4 != null) {
         double var5 = MathHelper.wrapDegrees(var2 - fck);
         fcg.add(var5);
         fch.add((double)(var3 - fcl));
         fcn++;
         if (fdk(var1, var4, var2, var3)) {
            fco++;
         }

         if (fcy == -1000) {
            fcy = 0;
         } else if (fcy >= 0) {
            if (Math.hypot(var5, var3 - fcl) > 0.001) {
               fcz.add(fcy);
               fcy = -1;
            } else if (++fcy > 40) {
               fcy = -1;
            }
         }

         fdj(var1, var4, var2, var5);
      } else {
         fdl();
      }

      fck = var2;
      fcl = var3;
   }

   private static double fdi(ClientPlayerEntity var0, Entity var1, float var2, float var3) {
      Vec3d var4 = var0.getEyePos();
      Box var5 = var1.getBoundingBox();
      return !tbp.aim(
            var4.x,
            var4.y,
            var4.z,
            (var5.minX + var5.maxX) * 0.5,
            var5.minY,
            (var5.minZ + var5.maxZ) * 0.5,
            (var5.maxX - var5.minX) * 0.5,
            var5.maxY - var5.minY,
            0.0,
            0.5,
            fcr
         )
         ? 0.0
         : Math.hypot(tbp.wrap(fcr.yaw - var2), fcr.pitch - var3);
   }

   private static void fdj(ClientPlayerEntity var0, Entity var1, float var2, double var3) {
      Vec3d var5 = var0.getEyePos();
      Box var6 = var1.getBoundingBox();
      if (tbp.aim(
         var5.x,
         var5.y,
         var5.z,
         (var6.minX + var6.maxX) * 0.5,
         var6.minY,
         (var6.minZ + var6.maxZ) * 0.5,
         (var6.maxX - var6.minX) * 0.5,
         var6.maxY - var6.minY,
         0.0,
         0.5,
         fcr
      )) {
         double var7 = tbp.wrap(var2 - fcr.yaw);
         double var9 = 0.25 * fcr.bw;
         int var11 = var7 > fcr.ra + var9 ? 1 : (var7 < fcr.la - var9 ? -1 : 0);
         fcu += var3;
         if (!Double.isNaN(fcs)) {
            fcv = fcv + tbp.wrap(fcr.yaw - fcs);
         }

         fcs = fcr.yaw;
         if (var11 != 0) {
            if (fct != 0 && var11 != fct && fcu * var11 > 0.0 && fcu * var11 > -fcv * var11) {
               fcw++;
            }

            fct = var11;
            fcu = 0.0;
            fcv = 0.0;
         }
      }
   }

   private static boolean fdk(ClientPlayerEntity var0, Entity var1, float var2, float var3) {
      Vec3d var4 = var0.getEyePos();
      Vec3d var5 = Vec3d.fromPolar(var3, var2);
      Box var6 = var1.getBoundingBox().expand(var1.getTargetingMargin());
      return var6.raycast(var4, var4.add(var5.multiply(8.0))).isPresent();
   }

   private static void fdl() {
      if (fcg.size() >= 8) {
         fce.add(fcg.stream().mapToDouble(Double::doubleValue).toArray());
         fcf.add(fch.stream().mapToDouble(Double::doubleValue).toArray());
      }

      fcg.clear();
      fch.clear();
   }

   private static void fdm() {
      fdl();
      tiq var0 = tiq.open(fbx);
      ArrayList var1 = new ArrayList();
      if (var0 != null) {
         var1.addAll(var0.tapes());
      }

      double[] var2 = syq.onTarget(var1);
      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.b(
                  "ꅍ\ud8e8刼챞䟈섪签\uf29a泊\ue671憵鮗ᔔ貴۱耇㨜뗈⼭ꤵ⃘嫏푳侬짜䌑謹瓩\uee17栁\ue3b7ᴧ霬ຉ裇ɼ붣㟊녆⣻ꋷ\udc10噔퇡䬥앃糂\uf625灵\ueba8旉齏ᚷ郧ਗ਼葟㿼뤠㌖ꪔ␤幠\ud99c叇쵌䓸ﺠ硎\uf24e涼\ue76f愛飌ሬ豩ނ膀㭸늬ⲓ꘎⁈寽픠佊욍䀳贈疓\uefd6椶\ue0e2\u1a9e鑐ྴ覦ͩ봝㒁긹⠨ꏜ\uddce圻캰䣜숅綼\uf7f3煘",
                  1092329794
               ),
               fby ? a.b("\ued13钀Ṏ耶௮赚㜀뺴\u20fa", 958983498) : fbx,
               fcn,
               100.0 * fco / Math.max(1, fcn),
               var2[0] * 100.0,
               (int)var2[1]
            )
         );
      double[] var3 = syq.overshootRates(var1);
      fcz.sort(Integer::compare);
      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.b(
                  "ὗ曲\uec26牄戮缰앤䲀틐填\udfaf▍ꬎ㊮룫㸝萆\u0b98鄲ᝰ麐\ue4c0橨\uf1be矁ﴋ䒿쪽倲혁嶨ꌸ⥣낕㛕밥Ϸ覍ག隧Ჾ戟\ue859濿\uf57a笚싈䡹츦喣\udbcd№ꢩ⻠둌㨑臷ܰ赙ᓝ驯\ue035柚\ueddf獖請䂴옃䱓폱奰\udf44⚐갨㉽릊㿟蕸\u0cf8銌᠂鸛\ue5a4欧\uf147碒︣䑥쮇凐흢廽ꓞ⨒놫㟲봥̇諑ံ阾᷃揙\ue96f炭\uf6db簝쎣䧮콋唝\udca7≶ꡱ⿁떐㬢芯ࢀ踈ᖡ鯪\ue156朝\ueee9琴梅䆝잖䵪풱嫁ꀛ➢귾㍁뤛¡虬ో鏖ᥫ齱\ue687法\uf203禥\ufffb䔖쬓劥\ud87f帞ꖙ⭩넸",
                  -685236310
               ),
               100.0 * fcw / Math.max(1, fcn),
               var3[0],
               fda,
               fcz,
               100.0 * fcz.stream().filter(var0x -> var0x == 0).count() / Math.max(1, fcz.size()),
               syq.medianReaction(var1),
               100.0 * syq.instantShare(var1)
            )
         );

      for (String var5 : syq.report(fce, fcf, var1)) {
         System.out.println(a.d("\uf685輠״鮖က離Ⲷꕒ㬂놹㙽챟䋜\udb7c儹ퟏ淔", -1129038113, 844351530) + var5);
      }
   }

   private static void fdn(MinecraftClient var0) {
      try {
         if (fci != null && var0.currentScreen == null) {
            fci.setBoolean(var0.mouse, true);
         }

         if (fcj != null) {
            fcj.setBoolean(var0, true);
         }
      } catch (IllegalAccessException var2) {
      }
   }

   private static void fdo(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
