package a;

import flow.Flow;
import flow.dev.a;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class flm {
   static final int fln = 400;
   static final int flo = 60;
   static final String[] flp = new String[]{
      a.d("讃\uf235磷\ue682浐\uebfc", -1704124698, 1663538448),
      a.d("氳ᖅ齇Ĳ諠ౌ뙍㿥ꆽ⬗", 2078710467, 582678153),
      a.d("ꏲ\uda49傟커䔻쏗禂", 2129849168, 1493190851),
      a.b("篍ɶ袠ᛛ鴄ᯯꆽ⡌", 1494383523),
      a.d("Ш綄\uf758椸", 348307711, -1727216480),
      a.b("ߘ繴\uf4a8櫈\ue144枬\uddf8吒", 854132643),
      a.c(644102035, "㟲么쒖嫨턲垅")
   };
   static final int[] flq = fng();
   static final int flr = flq.length;
   static final int fls = 23;
   static final int flt = 4;
   static final boolean flu = System.getenv(a.c(51904108, "︺螁\u0d51錸ᢊ鹖␙극㎽뤑㻉쒴䩧폄妗\udf73")) != null;
   static final int[] flv = new int[]{4, 6, 10, 16, 6};
   static final int flw = 300;
   static final int flx = 80;
   static final ConcurrentLinkedQueue<flj> fly = new ConcurrentLinkedQueue<>();
   static volatile flj flz;
   static volatile int fma = -1;
   static volatile boolean fmb;
   static volatile int fmc;
   static volatile int fmd = -1;
   static boolean fme;
   static boolean fmf;
   static final int[] fmg = new int[16];
   static final int[] fmh = new int[16];
   static final int[] fmi = new int[16];
   static final int[] fmj = new int[16];
   static final boolean[] fmk = new boolean[16];
   static final int[] fml = new int[16];
   static final int[] fmm = new int[16];
   static final int[] fmn = new int[16];
   static final int[] fmo = new int[16];
   static int fmp;
   static int fmq;
   static int fmr;
   static int fms;
   static int fmt = -1;
   static int fmu;
   static double fmv;
   static double fmw;
   static double fmx;
   static float fmy;
   static boolean fmz;
   static int fna = -1;
   static int fnb;
   static int fnc = -1;
   static final Random fnd = new Random(7L);

   flm() {
   }

   static boolean crit(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      if (fni(var0, false)) {
         return fmu == -1;
      }

      int var2 = (fmu - 60) / 400;
      int var3 = (fmu - 60) % 400;
      int var4 = var2 < flr ? flq[var2] : -1;
      fmc = var4 >= 0 ? var4 : 15;
      fnl();
      if (var4 < 0) {
         fnn(var0);
         int var11 = 0;
         int var12 = 0;

         for (int var10 : flq) {
            System.out
               .println(
                  a.b("畖\u0cf6蘾ᡒ鏑ᔴ꽶⚑룉㈬떯俆섘墻틾告", 15562021)
                     + flp[var10]
                     + a.b("♮必핗䬳샤䙀ﰑ痨\uebaf慐", 1251878494)
                     + fmg[var10]
                     + a.c(-1018977563, "ꋂ\udb30凲쾘䑒실磹")
                     + fmh[var10]
                     + a.d("\uecf7镎\u1fc5膥ੰ賉㚔뽴ℬꯔⰝ혤売셞䬊춵", -982959636, 1396626731)
                     + fml[var10]
                     + a.d("䝡㺓둑⨻ꇱ❇鵚", -185017319, 2097257311)
                     + fmm[var10]
                     + a.d("豒", 1824051989, -869179537)
               );
            var11 += fmg[var10];
            var12 += fmh[var10];
         }

         if (flu) {
            for (int var14 = 5; var14 <= 10; var14++) {
               System.out
                  .println(
                     a.b("㶥䐅컍傡\udb22巀\ue797湴\uf02b窏ﴌܷ觿ၖ騘Ჹꚢ⥮돗㖎밲왨", 465059280)
                        + var14
                        + a.d("㪻䌐즗埠\udc2c媑\ue0d4楫", 1119165905, 1230579544)
                        + fmn[var14]
                        + a.b("఼痎，慦\ueaac氚혇", -1091892197)
                        + fmo[var14]
                  );
            }
         }

         System.out
            .println(
               a.d("ₒ夲폺䶖옕䃰者獕\ued0d柨\ue049ᨯ铮൙蜓Ǻ믁㑑껷⢦ꅄ\udb17喬칥䡔", 1637075819, 1324804995)
                  + var11
                  + a.c(-212783997, "Ⲥ啖\udf94䇾쨴䲂\uf69f")
                  + var12
                  + a.b("\uddf9ꐆ⻔낤㬰뷏ލ蹧ဥ骓ᴎ", 1667423698)
                  + (var11 - var12)
            );
         if (fmq > 0) {
            System.out.println(a.b("뗖챶䚾\ud8d2卑햴濶\ue611硉\uf2ac甸轂Ƙ頦ቸ钏⺟ꅔ㮠뷺㐀乞샠嬷\udd5e埁", -372918865) + fmq + a.d("좸녁㮓ꗿ\u2e61", -784412092, -910419239) + fmr);
         }

         return true;
      } else {
         boolean var5 = var4 == 1 || var4 == 3 || var4 == 5;
         var0.options.jumpKey.setPressed(true);
         var0.options.forwardKey.setPressed(var5);

         float var6 = switch (var4) {
            case 2 -> 60.0F * MathHelper.sin(var3 * (float) (Math.PI * 2) / 12.0F);
            case 3 -> 100.0F * MathHelper.sin(var3 * (float) (Math.PI * 2) / 8.0F);
            case 4, 5 -> {
               if (var3 % 3 == 0) {
                  fmy = fnd.nextFloat() < 0.5F ? 0.0F : (fnd.nextBoolean() ? 1 : -1) * (40.0F + fnd.nextFloat() * 120.0F);
               }

               yield fmy;
            }
            case 6 -> {
               int var7 = var3 % 23;
               if (var7 == 0) {
                  if (fmt >= 0 && fmg[6] > fms) {
                     fmr++;
                  }

                  fmq++;
                  fmt = fmu;
                  fms = fmg[6];
               }

               yield var7 < 4 ? 0.0F : 90.0F;
            }
            default -> 0.0F;
         };
         fnk(var1, var6);
         if (flu) {
            fnm(var0, var1);
         }

         return false;
      }
   }

   static boolean mace(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      if (fni(var0, true)) {
         return fmu == -1;
      }

      fnl();
      fnk(var1, 0.0F);
      if (fmu < 140) {
         fmc = 0;
         var0.options.jumpKey.setPressed(false);
      } else if (fmu < 290) {
         fmc = 1;
         var0.options.jumpKey.setPressed(true);
      } else if (fmu < 300) {
         fmc = 15;
         var0.options.jumpKey.setPressed(false);
      } else {
         int var2 = (fmu - 300) / 80;
         int var3 = (fmu - 300) % 80;
         if (var2 >= flv.length) {
            fnn(var0);
            fnh(a.d("ꬳ튗塙옲䷾쭅", 1985298171, 837588393), 0, false, false);
            fnh(a.b("ჸ楖\ue39d緱\uf63f炉쫓", 873599125), 1, false, false);

            for (int var5 = 0; var5 < flv.length; var5++) {
               fnh(
                  a.b("ꆻ\ud81c勒첼䜻", 518496730) + flv[var5] + (var5 == flv.length - 1 ? a.c(-220268974, "\uf678辜Ք鬨ჴ陌Ⰼꗨ㮵넅") : ""),
                  2 + var5,
                  true,
                  var5 != flv.length - 1
               );
            }

            System.out
               .println(
                  a.d("헭걐⚁룶㍤떁࿃蘤\u187c銙", -1491480770, 723589812)
                     + (fmp == 0 ? a.d("買\uf517翖\ue1a7", -1491103736, 1156914411) : a.c(-471321820, "㍤䫒쀉幽헆卿") + fmp + a.b("嶈", 1012161952))
               );
            return true;
         }

         fmc = 2 + var2;
         boolean var4 = var2 == flv.length - 1;
         if (var3 == 0) {
            if (var4) {
               var1.getInventory().setSelectedSlot(1);
            }

            fnp(var0, String.format(Locale.ROOT, a.c(-865372405, "睤໑葒ᩃ醧ᝅ괓ⓩ몪く럚䶮썲嫟탘噯\uec25揿縷罕\uf6e4貸ȟ駇ᾨ镯Ⳛ"), fmv - 1.3, fmw + flv[var2], fmx));
         } else if (var3 == 2 && var4) {
            var1.getInventory().setSelectedSlot(0);
         }
      }

      return false;
   }

   static int[] fng() {
      String var0 = System.getenv(a.d("Ｉ蚒ూ鈫ᦙ齅┊곪㊮렂㿚얻䭭틞墘", 1336180136, -1449098552));
      if (var0 == null) {
         int[] var4 = new int[flp.length];
         int var5 = 0;

         while (var5 < var4.length) {
            var4[var5] = var5++;
         }

         return var4;
      } else {
         String[] var1 = var0.split(a.c(374375650, "蓏"));
         int[] var2 = new int[var1.length];

         for (int var3 = 0; var3 < var1.length; var3++) {
            var2[var3] = Arrays.asList(flp).indexOf(var1[var3].trim());
         }

         return var2;
      }
   }

   static void fnh(String var0, int var1, boolean var2, boolean var3) {
      boolean var4 = var2 ? fmg[var1] >= 1 && fmi[var1] == fmg[var1] && fmj[var1] == 0 && (!var3 || fmk[var1]) : fmg[var1] == 0;
      if (!var4) {
         fmp++;
      }

      System.out
         .println(
            a.b("焊ࢷ艦ᰑ鞃", -1717669534)
               + var0
               + (var4 ? a.b("曎ἰ闧", -847812883) : a.d("ϖ稁\uf0d5溬\ue57e", -273147928, -1474685925))
               + a.d("╶峝홏䠫쏼䕘）盰\ue8b7扈", 1063345825, -754156569)
               + fmg[var1]
               + a.d("\ueda5鑇Ẋ胷ଲ趘㞞", 1400336396, 1445371278)
               + fmi[var1]
               + a.d("슜뭮ㆬ꿆␌ꋴ", -2076476884, 1207220374)
               + fmh[var1]
               + a.b("㳎䔹쿥冏\uda59峯\ue68b潋\uf10f箣ﰹ", 510868709)
               + fmk[var1]
               + a.d("㇢䠚싎岥흩凾\ueba2执ﰫ皖\uf14dପ薳", 1171666054, 571999561)
               + fmj[var1]
               + a.b("꧁큸嫴쒓佋짠珧", 1881778662)
               + (var2 ? a.d("\udf0dꚢⱽ눞㧒", 864346494, 1168850437) + (var3 ? a.b("\uf40c趶ݮ饜ኚ鐰\u2e7e\ua7db㧂덼㒴컄䀔", -35982303) : "") : a.b("㻆䝶춤叞", 670711468))
               + a.c(-2101192973, "四")
         );
   }

   static boolean fni(MinecraftClient var0, boolean var1) {
      fmu++;
      ClientPlayerEntity var2 = var0.player;
      fmf = var1;
      fnj();
      wcn.ensure(var0);
      if (fmu == 1) {
         int var6 = MathHelper.floor(var2.getX());
         int var7 = MathHelper.floor(var2.getY());
         int var8 = MathHelper.floor(var2.getZ());
         fmv = var6 + 2.8;
         fmw = var7;
         fmx = var8 + 0.5;
         fnp(var0, a.c(-1452320767, "塷⇀\uab1f㕦뺹㠊艒\u0ba2閸\u1f5a颏拹\uec2a疄\uffc8礮썬"));
         fnp(var0, a.b("\u242b嶙흊䤸싩䑏﹈矾\ue9af持\ue4c1ỵ遂ী菀գ뼻ー꩕Ⱎꗮ\udfaa儖쫊䲳옧羍\uf1d5欢\ued63曄頁ሚ语ඹ蜘", -1998969750));
         fnp(var0, a.c(1471835660, "湍\u17ff鴬͞袏ษ됮㶘ꏉ⥧꺧咓\uda24䎦즦伄\uf559窝\ue02f晹\uef9d闙᭷肠۞豁㗫뮳⅄꜅Ⲣ퉧塼솋䟟쵾"));
         fnp(var0, a.c(-2059059030, "䃁㥿뎥ⷐꘔ\u20f7髄ጆ"));
         fnp(var0, a.c(-1724250924, "Ҫ紙\uf7cf榾\ue225擴\ude82坍줽䎁쑛㸿낰⤝ꌟ◲龰ၹ論ಐ蕈"));
         if (var1) {
            fnp(var0, a.b("늛쬷䇵\udf8c吖틵梱\ue155编\uf5aa牻蠌ڞ齪ᔲ鏙⦋ꙇ㳹뫱㍦䤄쟤屽\uda05像\ue96a朸\ufddc篑\uf07cຽ蒥ᵊ鬄ᆩ긶␊ꋝ㭫넿쿈䖊숨壸횛漆\ue5e0掣\uf870瘅", -632180031));
            fnp(var0, a.c(-1758258951, "\u18ac愀\uebc2疻︡磂슆䭢픡徝\ud84c∻격㕝뼅㧮莼\u0c70雎\u10c6饑\ue333淓\uf64a瀲\ufaf8䍝촏埫퇦婊ꒊ⺒락ㄳ뮞Ё踽࣪酜ᬈ旿\uefbd栟\uf2cf粬씱俞즜剅\udc3a⛩꽟⤄돌㶱蘊Ã読፪"));
         } else {
            fnp(
               var0,
               a.d("셛룷㈵걌⟖ꄵ᭱銕ೖ虪ƻ\ufbcc畞\uecaa曲\ue019婋햇伹줱䂦㫄됤⾽꧅⌏骪ᓸ踜ࠑ莼絽\uf765溊\ue8c4扩\uddf6埊턝䢫싿밈㙊뇨⬸ꕛ᳆阩ၫ讲\u05cd＞皨\uf0f3樻\ue446忽\ud934博쪝", 1446161584, 101739966)
            );
            fnp(
               var0,
               String.format(
                  Locale.ROOT,
                  a.d("ꗦ\udc58嚎죿䍤에翂\uf677栭\ue2dd敊鼾ᆨ衝ȋ蒻㺰녤\u2b96궃⑱幡킖䬊쵱䞧\ufe1f灈\ueaae泬\ue758ᦛ鎚ਢ豶ۜ뤊㍰뗦Ⱏꙇ\ud8b5勦핔供", 582359879, -1867333910),
                  var6 - 3,
                  var7 - 1,
                  var8 - 3,
                  var6 + 4,
                  var7 + 3,
                  var8 + 3
               )
            );
         }

         fnp(var0, String.format(Locale.ROOT, a.b("ꅠ\ud8d5剖챇䞣셁笗\uf2ed沭\ue64b懞鮪ᔼ賉ڟ聥㨵떳⽆ꤚ\u20f9媡퐂促", -1601396468), var6 + 0.5, var7, var8 + 0.5));
         fnp(
            var0,
            String.format(
               Locale.ROOT,
               a.b(
                  "욻뼌㗇ꮶ\u2063ꛓ\u1cce镲\u0b29膟هﰰ狶\ueb54愀\ue7e3巢퉠䣈캄䝲㴒뎙⡀긼ⓤ鵟ፃ覱\u0feb葄竁\uf0c8椼\uef2e旛\uda09偳횼余앀믪ㆌ똜⳥ꊜᬼ醆រ谅ȉ\uf8e2煐\uf708淰\ue3bb塊\ude90咰촯䏤㦀빤㐴ꫡ⍊餞῾関ਞ胋ڍ･痀\ueb97恺\ue636岐핂䭭솩䞫㱖닊⢨ꅹ⟌鶆ቲ蠴ຆ蝆紧\uf3bf桭\uee1c擁\udabd匰즙侁쑴먠゚ꥃ⼣ꗣᩕ逐ᚯ貫Ԗ﯀熶\uf672氮\ue29d孁턪埧찒䉍㣰뺢㜇귀⏬頶Ṹ铋ഞ荵禼﹀琳\ueab3悈\ud914心햿䩰생䛜㼦땨⮻ꀎ☍鳡",
                  -1394162083
               ),
               fmv,
               var7,
               fmx
            )
         );
         fnp(var0, a.c(-1625792642, "彟⛭갾㉌릝㼻蔼ಊ鋛ᡵ龵斁\ueb36犢\uf8cf縑쑓䮋턭圤\ude83ꓖ⩢놸㟁봁ҡ諷ဒ阍ᷭ\ue327極\uf085盧ﱮ䎱짃伙횠峏≃ꡂ\u2fe4딥㭎芇࠱蹫ᖵ鯋愜\ue8ee滶\uf402穛쇫䜽쵉咅\uda23ꀷ⟗궕㌎몹í蘌"));
         var2.getInventory().setSelectedSlot(0);
         return true;
      } else if (fmu == 30) {
         Entity var3 = null;

         for (Entity var5 : var0.world.getEntities()) {
            if (var5 instanceof IronGolemEntity) {
               var3 = var5;
            }
         }

         if (var3 == null) {
            System.out.println(a.c(1341095332, "緐Ѱ躸ე魗ᶲ\ua7f0⸗끏㪪봟䝩즶倂\uda3d岂\ue6cc楒\uf3a6痿ﰋ虓ࣨ"));
            fmu = -1;
            return true;
         } else {
            fma = var3.getId();
            fmv = var3.getX();
            fmw = var3.getY();
            fmx = var3.getZ();
            fno();
            return true;
         }
      } else {
         if (fmu < 60) {
            return true;
         }

         fmb = true;
         return false;
      }
   }

   static void fnj() {
      if (!fme) {
         fme = true;
         AttackEntityCallback.EVENT
            .register(
               (AttackEntityCallback)(var0, var1, var2, var3, var4) -> {
                  if (!var1.isClient() && fmb && var3.getId() == fma) {
                     float var5 = var0.getAttackCooldownProgress(0.5F);
                     boolean var6 = var5 > 0.9F
                        && var0.fallDistance > 0.0
                        && !var0.isOnGround()
                        && !var0.isClimbing()
                        && !var0.isTouchingWater()
                        && !var0.hasVehicle()
                        && !var0.isSprinting();
                     boolean var7 = var0.getMainHandStack().isOf(Items.MACE) && var0.fallDistance > 1.5 && !var0.isGliding();
                     int var8 = fmc;
                     if (fmg[var8] == 0) {
                        fmk[var8] = var6;
                     }

                     if (var3 instanceof LivingEntity var9 && var9.timeUntilRegen > 10) {
                        fmj[var8]++;
                     }

                     fmg[var8]++;
                     if (var6) {
                        fmh[var8]++;
                     }

                     if (var7) {
                        fmi[var8]++;
                     }

                     int var10 = fmd;
                     if (var10 >= 0) {
                        fmn[var10]++;
                        if (var6) {
                           fmo[var10]++;
                        }

                        fmd = -1;
                     }

                     if (!var6 || fmf) {
                        System.out
                           .println(
                              String.format(
                                 Locale.ROOT,
                                 a.d(
                                    "\ue830醐᭘蔴ື衕㈐믶▭꼏⣋틨屾엚侉쥭猠ﳹ昁\ue003槫Ꮉ鴑ډ胮\u0a7e뎉㶁Ꜳⅻ\uaac3吏\ude15䞢솷䬁\uf4db纪\uf828憁\uebd5锹Ἷ飈ɘ谼㗲뽙㤍ꋖ⳼혵忔\ud9d6䍶촤皙\uf053稧\ue3ec洒\u175b郾\u1afc葰්랐ㅲ묰⒃금⡡통嬙씟亨좬爃ﯜ斿\uef6b楯ዄ鱃٧辻छ더㲮ꚩ",
                                    1981648075,
                                    1198810306
                                 ),
                                 var8,
                                 var0.getY() - fmw,
                                 var0.fallDistance,
                                 var0.isOnGround(),
                                 var0.isSprinting(),
                                 var5,
                                 var7,
                                 var6 ? a.d("䍭㫍뀅\u2e69", 1603297142, 395975772) : a.c(70411306, "摃ᷳ靯ढ़芛б빿")
                              )
                           );
                     }

                     return ActionResult.PASS;
                  } else {
                     return ActionResult.PASS;
                  }
               }
            );
         wcn.listen(var0 -> {
            if (var0 instanceof EntityDamageS2CPacket var1 && var1.entityId() == fma) {
               flj var3 = new flj();
               flz = var3;
               fly.add(var3);
            } else if (var0 instanceof EntityAnimationS2CPacket var2 && var2.getEntityId() == fma && var2.getAnimationId() == 4 && flz != null) {
               flz.crit = true;
            }
         });
      }
   }

   static void fnk(ClientPlayerEntity var0, float var1) {
      Vec3d var2 = var0.getEyePos();
      double var3 = fmv - var2.x;
      double var5 = fmw + 1.35 - var2.y;
      double var7 = fmx - var2.z;
      float var9 = (float)(MathHelper.atan2(var7, var3) * 180.0F / (float)Math.PI) - 90.0F;
      float var10 = (float)(-(MathHelper.atan2(var5, Math.sqrt(var3 * var3 + var7 * var7)) * 180.0F / (float)Math.PI));
      var0.setYaw(var9 + var1);
      var0.setPitch(var10);
   }

   static void fnl() {
      long var0 = System.nanoTime();

      flj var2;
      while ((var2 = fly.peek()) != null && var0 - var2.at > 60000000L) {
         fly.poll();
         fml[fmc]++;
         if (var2.crit) {
            fmm[fmc]++;
         }
      }
   }

   static void fnm(MinecraftClient var0, ClientPlayerEntity var1) {
      boolean var2 = var1.isOnGround();
      if (fmz && !var2 && var1.getVelocity().y > 0.0) {
         fna = fmu;
         fnb++;
         fnc = fnb % 2 == 0 ? 5 + fnb / 2 % 6 : -1;
      }

      fmz = var2;
      if (fnc > 0 && fmu - fna == fnc - 1) {
         fmd = fnc;
         KeyBinding.onKeyPressed(KeyBindingHelper.getBoundKeyOf(var0.options.attackKey));
      }
   }

   static void fnn(MinecraftClient var0) {
      var0.options.jumpKey.setPressed(false);
      var0.options.forwardKey.setPressed(false);
   }

   static void fno() {
      kfe var0 = Flow.getInstance().getModuleManager().getByName(a.b("េ湖\ue49e竡\uf136瞅췁䐀\uda72僘", 2135955359));

      for (vmo var2 : var0.getSettings()) {
         switch (var2.getName()) {
            case a.c(1176698422, "ﹰ蟰സ鍔ᢄ"):
               ((vlv)var2).set(a.d("됫춤䝻\ud919勈", 2093587698, 1890527375));
               break;
            case a.b("镻\uece8昬\uf85c玆\uf53d佹", -855665364):
            case a.c(310300561, "쿉뙛㲊ꋠ⤰꾛ᗮ鰨ɡ裆༄"):
            case a.b("\uf20f讝Ō鼦ᓶ鉝⡚ꇹ㾱딖㋓좳", -319032752):
            case a.c(528080413, "\ude59Ꞔⴕ덢㢃브ѓ趰Ᏼ"):
            case a.d("ꩾ폳夭을䲏쨩灻", 1650408268, -864906907):
            case a.b("膱\uf822狼\uec9c", -2005171720):
               ((vkl)var2).set(true);
               break;
            case a.d("∕宓텆伻쓱䉖", 1102996644, -509131035):
               ((vkl)var2).set(false);
               break;
            case a.d("殱ሷ飠ړ赓\u0bff놪㡚", 218863902, -2143489291):
            case a.c(-560125924, "⡝凍\udb17䕫캤"):
               ((vmc)var2).set(0.0);
         }
      }

      var0.setEnabled(!flu);
      Flow.getInstance().getModuleManager().getByName(a.b("딦첣䙱\ud81b台핢漳\ue6d9碁\uf22a", -474696339)).setEnabled(true);
      kfe var5 = Flow.getInstance().getModuleManager().getByName(a.b("琰ඩ蝾ᤣ鋆ᑷ긾⟕릍", 675705976));
      if (var5 != null) {
         var5.setEnabled(false);
      }

      Flow.getInstance()
         .getModuleManager()
         .getByName(a.d("\ue191頁ዷ貹ݶ臚㮽뉭ⰻꚇ⅌", -1877332432, -14299164))
         .setEnabled(a.d("ሴ", -490438028, 1576177776).equals(System.getenv(a.b("찦떝㽍ꄤ⪖걊ᘈ鿽Ƭ", -477639575))));
   }

   static void fnp(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
