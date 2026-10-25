package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

final class ezo {
   static final int ezp = 1200;
   static final int ezq = 300;
   static final Field ezr = vxr.find(
      Mouse.class,
      a.d("珂\u0a78肺ẑ锅Ꮀꧤ„빇㓧댧䥑잔广푡功\ue8dd朞ﶭ篐\uf24b蠘ڨ", -1485326510, -1020214039),
      a.d("឴渊\ue4d5窭\uf172矸췅䐲\uda62僘", -2083282817, 1968093095),
      a.b("壘", -1922565871)
   );
   static final Field ezs = vxr.find(
      MinecraftClient.class,
      a.c(295900337, "ᓈ浲\ue7b0禛\uf20f璺컮䜔\ud94d叭퐭⹛ꂞ㥵덫㖕迗\u0014骧᳚镁\uef12憠"),
      a.d("쟳빍㒒ꫪℵꞿᶂ鑴ਤ肙", 137919040, -1116160545),
      a.d("ம", -336775945, -1328136446)
   );
   static final Random ezt = new Random(5L);
   static final List<Double> ezu = new ArrayList<>();
   static double ezv;
   static double ezw;
   static double ezx;
   static int ezy;
   static int ezz;
   static int faa;
   static int fab;
   static int fac;
   static int fad;
   static int fae;
   static boolean faf;
   static int fag;
   static int fah;
   static double fai;
   static double faj;
   static boolean fak;
   static float fal;
   static float fam;
   static boolean fan;

   ezo() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      ClientPlayerEntity var2 = var0.player;
      fba(var0);
      if (var1 == 1) {
         faq(var0, var2);
         return false;
      }

      if (var1 < 60) {
         return false;
      }

      far(var0, var1);
      int var3 = var1 - ezz;
      switch (ezy) {
         case 0:
            fax(true, false);
            fay().setEnabled(true);
            faz(var1);
            break;
         case 1:
            fas(var0, var2);
            if (var3 >= 1200) {
               faz(var1);
               fax(false, false);
               fak = false;
            }
            break;
         case 2:
            fat(var0, var2, var3);
            if (var3 >= 300) {
               faz(var1);
               fax(true, false);
               fbb(var0, a.c(470625424, "ⲵ唇\udfd4䆦쩷䳑\uf6d6罠\ue131殟\uec5fᙫ飜ň謥\u0dfb랹㡡ꋇⓎ굩휼妈쉒䐫컫睋欄揸\ue5e7渆郊᪃荪ԏ迃そ먫㳠ꕎ⼋几\udbb8専원䢤\uf16a篖ﷀ晘\ue82cድ魍ᴛ蟯ণ눍㒙뻺✻꧘펏呻\ude3a"));
               fak = false;
            }
            break;
         case 3:
            fat(var0, var2, var3);
            if (var3 >= 300) {
               return faw();
            }
            break;
         default:
            return true;
      }

      return false;
   }

   static void faq(MinecraftClient var0, ClientPlayerEntity var1) {
      var0.options.pauseOnLostFocus = false;
      long var2 = var0.getWindow().getHandle();
      GLFW.glfwSetCursorPosCallback(var2, (var0x, var2x, var4x) -> {});
      GLFW.glfwSetMouseButtonCallback(var2, (var0x, var2x, var3, var4x) -> {});
      ezv = Math.floor(var1.getX()) + 0.5;
      ezw = Math.floor(var1.getY());
      ezx = Math.floor(var1.getZ()) + 0.5;
      fbb(var0, a.d("ꢃ턴寫얒乍죾犦ﭖ敌\uefae桻鈍᳞蕰༼觚㎘", 242148558, -2144842693));
      fbb(var0, a.c(1509462003, "辊\uf626糱\ue288椚\ueff8喽\udc5d䉖좩佻딊㯜"));
      fbb(var0, a.d("閭耱૮钗ὗ駡⎫꩓㑉뺼㥤쌷䷂푾帜\ud8ce抐\ued57矽\uf1ab硛ȃ賷ᝠ鄘ᯄꉨⰯ", -1388819991, 1667018772));
      fbb(var0, a.b("ȯ箜\uf14a漻\ue4a0扱\ud807凈쾸䔄싞㢺똵⾘ꖚ⍷餵\u16fc豓ਕ菍", -1894120879));
      fbb(var0, a.c(-2048553495, "趧\uf415细\ue0b4步\uedc3埄\ude72䀣쪍䵍띹㧎ꁌ⩌곯ᚷ饰ϙ薒ౢ瘦\uf89a捆\ue53f澫홑堇싸䒦켒㇄뮖≶ꑠ⻃鄓᭢鶤с踘\uf0ee窭"));
      fbb(var0, a.b("\ue55b鳩ᘺ衈Ι蔿㼸뚎⣟ꉱ▱\udf85儲좰䊰쐒繏\uf18b欹\ued6f撋ỏ遡ஶ跈ݗ뺭・ꨄⱚ\ua7ee夸퍪䪊천䘿璘玞\uf558沽\ue6e4頒ቑ", -333781739));
      fbb(var0, a.c(-1505508903, "솊렴㋢겓✈ꇧᯧ鈊ౖ蛵Ÿﭚ疑\uec31昼\ue09e嫍픟侾즱䀉㩛듺⽵\ua959⎔騶ᐹ躁࣓荲緮\uf7a5湓\ue80b押\udd7a團퇌䡯쉾볆㚋넸⯯ꖅ\u1c4a雌Ⴏ譹ԑ\uffc1白"));
      fbb(var0, a.d("졾뇀㬖ꕧ\u2efcꠓሓ鯾֢輁ࢌ\uf2a3簪\ue5c8澇\ue975匨\udca7䙛쀉䧬㏣봛⛟ꃾ⩠鏐ᶓ蜩ż諈琒﹛枻\ue1fb歍품康\ud83f䆆쯂", -713177206, 753078203));
      fbb(var0, a.b("걄헺张셕䪑챲癁ﾃ", 1322626095));
      fbb(var0, a.b("㕐䳼옾塇폝唾\uef7a暞\uf8dd牡\uf5b0࿇腕ᢡ鋹ᐒ김\u218c묲㴺뒭컏䀯\udbb6巎휄溡\ue0f3稗ﰚ瞷襶ͮ骁\u1ccf院⧽ꏁ┖베㛴䠃쉁䗣\udf33児\ue8cd戢\ue460羹\uf1c6କ芣Ӹ鸰၍꯶ⴿꝑ㺖", 89339141));
      fbb(var0, String.format(Locale.ROOT, a.d("അ環︳怢\uebc6洤흲庈새䨮춻㟏뤓₽ꪹⰎ附ᦞ茲Դ貅\uf6c4硧\ue3a6", -615730361, -1151615442), ezv, ezw, ezx));

      for (int var4 = 0; var4 < 2; var4++) {
         fbb(
            var0,
            String.format(
               Locale.ROOT,
               a.b(
                  "듛쵬䞧\ud9d6刃풳溮\ue712祉\uf3ff琧蹐\u0096餴፠閃⾂ꀁ㪯본㔗伍솻婡\udc02嚇\uef72愦ﯚ綔\uf670ࣧ芭᭗鴘\u17fdꡬ≆꒠㴰띁즸䎘쐢度킙椵\ue3be旴︬灔誟ͦ蔼ᾜ醃⩀겤⛀뼐ㆽ䯶찂䙂\ud886儺\ueb6f涩\ue7c9硬\uf2bb瓖贒\u07b4駦\u1249鐕\u2ef7Ꝫ㥖뎌㗝乨삢嫞팘喪\uefea怃福糉\uf538ཝ膁ᩬ鰥ᚥ꣐℄뮾㷯똏졏䋹\udb34崋힏栲\ue27c撪ﻎ睲覹ϥ萎ṃ邾⥡ꍜ▎븣つ䫈첒䔤\udff7冂\uea49氘\ue6e4缗\uf117த谸ٯ颓ዔꭹⷸꞂ㡔닧㒲䴑읅",
                  -1638616007
               ),
               ezv + var4,
               ezw,
               ezx + 3.0
            )
         );
      }

      fbb(
         var0,
         a.d(
            "濏ᙽ鲮˜褍ྫ떬㰚ꉋ⣥꼥唑\udba6䈲졟亁\uf4c3笛\ue1bd枴\uee13鑆\u1af2脨ݑ趑㐱멧₂ꚝ\u2d7c펰姹쀐䙵첹猼讀羟\ue634汱ኇ飁\u1f7f薥\u0bd2뉄㢼뻴┭ꭑ冇\ud837幻쒙䪍\uf126矣ﷄ搓\ueaa3郢",
            -2086475564,
            806455104
         )
      );
      var1.getInventory().setSelectedSlot(0);

      for (String var7 : new String[]{a.b("뛺콭䖥\udbda倍횾泺\ue53b等\uf1e3", -560679260), a.c(1104694707, "䷺㑿뺭\u20c7ꬲ\u2daf韾ḉ"), a.c(1094963974, "퍏\uaaca‘빲㖙댌ॉ肩")}) {
         kfe var8 = Flow.getInstance().getModuleManager().getByName(var7);
         if (var8 != null) {
            var8.setEnabled(false);
         }
      }
   }

   static void far(MinecraftClient var0, int var1) {
      for (int var2 = 0; var2 < 2; var2++) {
         double var3 = Math.toRadians(-35.0 + 70.0 * var2 + 25.0 * Math.sin(var1 * (0.045 + 0.02 * var2) + var2));
         double var5 = 2.8 + 0.45 * Math.sin(var1 * 0.03 + var2 * 2.0);
         fbb(
            var0,
            String.format(
               Locale.ROOT,
               a.b("末ẞ鐝\u0a0c臾ݱ봍㓱ꪧ ꞈ嶩퍺䫌삔䙣ﰽ珿\ue94b漈\ue6b1鲲ሜ觋ྫྷ蔺㳉늝⡮긻▕\udb0d兎좢亮쐃築\uf1be眤\uee8d撄ᩛ遵េ贝ͱ뫷　뙊ⶐꏼ奺킋囟찧䉫女", 1856661350),
               var2 == 0 ? a.c(2093632074, "䨣㎙륎✬곬⩋速") : a.c(193833399, "꧙큻媯쓘伓즯珪靖"),
               ezv - Math.sin(var3) * var5,
               ezw,
               ezx + Math.cos(var3) * var5
            )
         );
      }
   }

   static void fas(MinecraftClient var0, ClientPlayerEntity var1) {
      fau(var0, var1);
      boolean var2 = fav(var0, var1);
      if (fan) {
         fae++;
         if (!faf && var2) {
            faf = true;
            fac++;
            fad = fad + fae;
         }
      }

      if (--faa <= 0) {
         faa = 30 + ezt.nextInt(40);
         double var3 = (ezt.nextBoolean() ? 1 : -1) * (20.0 + ezt.nextDouble() * 35.0);
         double var5 = tcz.unit(var0);
         long var7 = Math.round(var3 / var5);
         var1.changeLookDirection(var7 * var5 / 0.15, 0.0);
         fal = var1.getYaw();
         fam = var1.getPitch();
         fan = true;
         faf = false;
         fae = 0;
         fab++;
      }
   }

   static void fat(MinecraftClient var0, ClientPlayerEntity var1, int var2) {
      float var3 = var1.getYaw();
      float var4 = var1.getPitch();
      if (fak && var2 > 20) {
         faj = faj + (Math.abs(MathHelper.wrapDegrees(var3 - fal)) + Math.abs(var4 - fam));
      }

      fal = var3;
      fam = var4;
      fak = true;
      if (var2 == 1) {
         var1.changeLookDirection(200.0, 0.0);
      }
   }

   static void fau(MinecraftClient var0, ClientPlayerEntity var1) {
      float var2 = var1.getYaw();
      float var3 = var1.getPitch();
      if (fak) {
         double var4 = var2 - fal;
         double var6 = var3 - fam;
         double var8 = tcz.unit(var0);
         double var10 = var4 / var8;
         fah++;
         if (Math.abs(var10 - Math.rint(var10)) > 0.01 && Math.abs(var4) > 1.0E-4) {
            fag++;
         }

         double var12 = Math.hypot(MathHelper.wrapDegrees(var4), var6);
         fai = Math.max(fai, var12);
         if (var12 > 0.5) {
            ezu.add(var12);
         }
      }

      fal = var2;
      fam = var3;
      fak = true;
   }

   static boolean fav(MinecraftClient var0, ClientPlayerEntity var1) {
      Vec3d var2 = var1.getEyePos();
      Vec3d var3 = var2.add(var1.getRotationVec(1.0F).multiply(6.0));

      for (Entity var5 : var0.world.getEntities()) {
         if (var5 instanceof HuskEntity) {
            Box var6 = var5.getBoundingBox();
            if (var6.raycast(var2, var3).isPresent()) {
               return true;
            }
         }
      }

      return false;
   }

   static boolean faw() {
      fay().setEnabled(false);
      double[] var0 = ezu.stream().mapToDouble(Double::doubleValue).sorted().toArray();
      String var1 = var0.length == 0
         ? a.c(1436186511, "知๕蒇\u1afd")
         : String.format(
            Locale.ROOT,
            a.d("㟡丕쓃媢텰埊\ued85搠塀烘\uf742ഺ菽ᩉ逑\u16fc곧⍰릎㿓똽찴䊂\ud958弻햾", 1548030262, 581379773),
            var0[var0.length / 2],
            var0[(int)(var0.length * 0.9)],
            var0[var0.length - 1]
         );
      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.d(
                  "㲍䔴쿣凟\uda5c峼\ue6b9潏\uf15e篵ﱧؔ裑ᅤ鬫᷁ꞙ⡉늾㓪뵜읆䧿퉯员\ude85杳\ue929珄\uf593縫肣૩錓ᕟ龹\u2028ꨍⳃ땸㼯䇆쯊䱷훯増\ue144殾\uedbb癿\uf817ˋ謸൬韞ᧄꉱⓡ껚㜇맣쎵䑗츓僟\ud93d捫\ue5cc濄\uf079竾ﲎՖ迻ᆣ驓᱀ꚦ⽪넚㯐불왾䣠튞孏\uddba柮\ue81a牗\uf4b0綷",
                  294159572,
                  2133833828
               ),
               fac,
               fab,
               (double)fad / Math.max(1, fac),
               fag,
               fah,
               var1,
               faj
            )
         );
      boolean var2 = fac >= fab * 0.8 && fag == 0 && fai < 60.0 && faj < 0.5;
      System.out.println(a.c(1074181284, "듌쵵䞢\ud99e初풽滸\ue70e礅") + (var2 ? a.b("殦ሆ飇ڶ", -1594921998) : a.c(-222565819, "\uea07鎱ᥪ蜞")));
      return true;
   }

   static void fax(boolean var0, boolean var1) {
      for (vmo var3 : fay().getSettings()) {
                  if (java.util.Objects.equals(var3.getName(), a.d("윩뺺㑤ꨄ") || java.util.Objects.equals(var3.getName(), 641918419) || java.util.Objects.equals(var3.getName(), 738140851))) {
            ((vkl)var3).set(var0);
         }
         else if (java.util.Objects.equals(var3.getName(), a.c(-679125292) || java.util.Objects.equals(var3.getName(), "应✂귉㎧롪㻁蒙൦錰"))) {
            ((vkl)var3).set(var1);
         }
         else if (java.util.Objects.equals(var3.getName(), a.b("웝뽥㖯") || java.util.Objects.equals(var3.getName(), -1661221224))) {
            ((vmc)var3).set(180.0);
         }
         else if (java.util.Objects.equals(var3.getName(), a.d("夲₮ꩧ㐑뿓㥭茳ૄ") || java.util.Objects.equals(var3.getName(), 2016844539) || java.util.Objects.equals(var3.getName(), -2100051067))) {
            ((vmc)var3).set(3.5);
         }
      }
   }

   static kfe fay() {
      return Flow.getInstance().getModuleManager().getByName(a.c(-993895056, "崸⒡깶〫믎㵿蜶ໝ邅"));
   }

   static void faz(int var0) {
      ezy++;
      ezz = var0;
   }

   static void fba(MinecraftClient var0) {
      try {
         if (ezr != null && var0.currentScreen == null) {
            ezr.setBoolean(var0.mouse, true);
         }

         if (ezs != null) {
            ezs.setBoolean(var0, true);
         }
      } catch (ReflectiveOperationException var2) {
      }
   }

   static void fbb(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
