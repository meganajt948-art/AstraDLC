package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;

final class gax {
   private static final int gay = 40;
   private static final int gaz = 24;
   private static final int gba = 140;
   private static final List<gaq> gbb = new ArrayList<>();
   private static final Field gbc = vxr.find(
      ClientPlayerEntity.class, a.c(-1274661362, "㙷俍씏嬤킰嘅\uec51斫ﯲ煒\uf692\u0ce4舡ᯊ釔ᜪ굨⊫렘㹥럺춨䌙"), a.d("氮ᖐ齏ķ諨ౢ뙝㾦ꇴ⭀", 665238109, -1623730657), a.b("밝", 1812118618)
   );
   private static final Field gbd = vxr.find(
      ClientPlayerEntity.class,
      a.d("ḃ枹\ued7b獐\uf8c4繱쐥䷟펆夦\udee6⒐꩕㎾릠㽞蔜\u0adf遬ᘑ龎\ue5dc歭", -1022138324, -978356650),
      a.c(-489357927, "ﷵ葋ດ郬ᬳ鶹➆깽〩몟"),
      a.d("蠏", 866256624, -1860202824)
   );
   private static final double gbe = 25.0;
   private static final double gbf = 45.0;
   private static final double gbg = 10.0;
   private static final double gbh = 10.0;
   private static final double[] gbi = new double[256];
   private static final double[] gbj = new double[256];
   private static final double[] gbk = new double[256];
   private static float gbl = Float.NaN;
   private static float gbm;
   private static int gbn;
   private static int gbo = 99;
   private static final int[] gbp = new int[256];
   private static final int[] gbq = new int[256];
   private static final int[] gbr = new int[256];
   private static final double[] gbs = new double[256];
   private static final boolean[] gbt = new boolean[256];
   private static final boolean[] gbu = new boolean[256];
   private static final double[] gbv = new double[256];
   private static final double[] gbw = new double[256];
   private static final int[] gbx = new int[256];
   private static final int[] gby = new int[256];
   private static volatile int gbz = -1;
   private static volatile int gca = -1;
   private static boolean gcb;
   private static int gcc;
   private static double gcd;
   private static double gce;
   private static double gcf;
   private static int gcg = -1;
   private static int gch;
   private static int gci;
   private static int gcj;
   private static float gck;
   private static float gcl;
   private static float gcm;
   private static float gcn;
   private static double gco;
   private static boolean gcp;
   private static boolean gcq;
   private static boolean gcr;
   private static final List<Double> gcs = new ArrayList<>();
   private static final lnb gct = new lnb();
   private static final lmn gcu = new lmn();
   private static final Random gcv = new Random(11L);

   private gax() {
   }

   static boolean tick(MinecraftClient var0) {
      gcc++;
      ClientPlayerEntity var1 = var0.field_1724;
      gde();
      if (gcc == 1) {
         gcy();
         int var5 = MathHelper.method_15357(var1.method_23317());
         int var6 = MathHelper.method_15357(var1.method_23318());
         int var4 = MathHelper.method_15357(var1.method_23321());
         gcd = var5 + 4.5;
         gce = var6;
         gcf = var4 + 0.5;
         gdg(var0, a.d("뱌엻伤텝媂\udc31晩\uef99熃ﭡ粴蛂ࠑ醿᯳鴕❗", -1552956524, 2093973422));
         gdg(var0, a.b("ⓨ嵄힓䧪쉸䒚ﻟ眿\ue934揁\ue417Ṿ", -1149492080));
         gdg(var0, a.c(1660717034, "螫︙瓊\ueab8慩\ue7cf巈푾䨯삁䝁뵵㏂ꩀ⁀ꛣ\u1cbb鍼\u09d5辞ٮ簪\uf296楊\uef33斧\udc0d剕좢代아㮁놚⡭긹⒘"));
         gdg(var0, a.b("\uee81霳ᷠ莒ࡃ軥㓢뵔⌅ꦫ\u2e6b푟嫨썪䥪쿈疕祝惣\ue6b5潑ᔕ鮻l蘒\u0c8d딧㭿ꆈ⟉걮劫\ud8b0䅇윓䶲", 1691086528));
         gdg(var0, a.b("銂\ueb3c懦ﾓ瑗\uf2b4䢇셅", -294743319));
         gdg(var0, a.d("찜떯㽹ꄈ⪓걂ᘴ鿻Ƌ謷೭\uf689砆\ue1ab殩\ued44圆\ud8cf䉠쐦䷾", 1151680984, -1641509446));
         gdg(
            var0,
            System.getenv(a.c(1307863766, "檞ጥ駵ޜ谮\u0af2낳㥎꜓ⶤꩭ倊\udeda䝳")) != null
               ? a.b("쩀돬㤮ꝗⳍꨮၪ馎ߍ赱ઠ\uf0d7繅\ue7b1淩\ueb02児\ude9c䐢숪䮽㇟뼿⒧ꋟ⠖醶Ῥ蔁͋裥瘿ﰧ旈\ue38b業횤峈\uda07䏾짬뜙㵍뫷…깆ឆ鴰᭭胲໖\uf40b綾ﯩ", -584267233)
               : a.b("滍ᝡ鶣Ϛ血ຣ듧㴃ꍀ⧼긭呚\udac8䌼쥤侏\uf5dd稑\ue0af暧\uef30镒᮲耫ٓ貙㔼뭮↊ꞇⰪ틫壳서䝒췿牠\uf85c纋\ue73d浩\u139e駜Ṿ蒮્덐㦶뿵␦꩓", 1203793559)
         );
         gdg(var0, a.d("騎\ue3a2楠\uf719粃褐䀤지垃\udd3f嫮ꂙ⸋럿㶧뭌Ğ軒ᑬ鉤᯳憑\uef71瓨\uf290硚쇿侭핉卄\ud8e8☨갰㗟뎑㤼蚣ಟ詈\u13fe馪\ue75d洟\ueabd灭︎䞓쵼䬾탧庘ꑋⷽꮦㅮ뼓Ҩ艡ࠏ釈", -253393274, 876027101));
         gdg(var0, String.format(Locale.ROOT, a.c(-1336177453, "貿\uf50a羉\ue198橼\uec9e囈\udf32䅲쮔䰁뙵㣣ꄖ⭀궺\u17ea顬ʙ蓅ദ睾利戜"), var5 + 0.5, var6, var4 + 0.5));
         gdg(
            var0,
            String.format(
               Locale.ROOT,
               a.d(
                  "䄢㢕뉞Ⱟꟺ⅊魗ያ貰؆臞箩\uf56f泍\ue699恺\uda7b嗸콖䤁샮뫴㑂꾘⧻ꍾ\u1a8b铟\u0e69衼ϊﴐ睃\ueee6棳\ue219巻\ud7ab兖죯䋃㰹똹㇆\uab6e┥鳳ᙋ透\u0bc4藹缣\uf6c7烘\uea57搳\udf9b奋팢䫩쑙븙㧡뎽\u2d74ꓲẖ顳ሠ趍݅脣磽\uf212汊\ue7e8懱\udb0d勋첺䙳쀹뮁㕇꼱⛱ꁔᩌ闒ྣ褂Þ\ufaf7琾\uefc2榗\ue35f崥퓰乐젔䏢㶣띜⻔ꢩ≣鷵ផ酩ା节籕\uf618熡\uebfe攇\udcd5嚴큳䮓엉뼻㥨냙⨒ꑿΰ馌ፌ諻ҧﹴ秈\uf383浮\ue763廙\ud80b剸충䝊섂",
                  -1308396412,
                  109720922
               ),
               gcd,
               var6,
               gcf
            )
         );
         gdg(var0, a.d("䋶㭄놗\u2fe5ꐴ⊒颕ᄣ轲ל舜砨\uf69f漋\ue566掸\ud9fa嘢첄䪍쌪륿㟋갑⩨ꂨᤈ非ර认Eﺉ瓀\ued29歌\ue180帅푣劦쬍䅈㾾뗸㉆ꢜ⛫齽ᖅ鏍ࠔ虨精\uf50e獂\ue9a0枴\udc18嫚탽䤪잚뷛", -956233788, -1948367511));
         var1.method_31548().method_61496(1);
         return false;
      } else if (gcc == 30) {
         for (Entity var3 : var0.field_1687.method_18112()) {
            if (var3 instanceof HuskEntity) {
               gca = var3.method_5628();
               gcd = var3.method_23317();
               gce = var3.method_23318();
               gcf = var3.method_23321();
            }
         }

         if (gca < 0) {
            System.out.println(a.c(1195040937, "\ue0d2饷Ꭵ跏ؚ肧㫶댁ⴛꟾ‼\uda5b咋쵮䝛솭篪\uf43e满\ue8fe愈ᬖ闭ม衘ʑ"));
            return true;
         } else {
            gdf(a.b("朤ẳ鑻\u0a04臓ݠ봤㓥ꪗ‽", -1939380358));
            gdf(a.d("\uec6d间ἣ腾છ谪㙣뾈⇐", 631584224, 1476843973));
            gdf(a.d("\ue366髣ေ蹛ְ茢㥳낙⻁ꑪ", -338757580, -708699367));
            return false;
         }
      } else if (gcc < 40) {
         return false;
      } else {
         gct.update(var1);
         if (var0.field_1729.method_1613()) {
            var0.field_1729.method_1610();
         }

         if (gcg >= 0 && gch != 3) {
            gda(var0, var1, gbb.get(gcg));
            return false;
         } else {
            gcg++;
            if (gcg >= gbb.size()) {
               return gdb();
            } else {
               gcz(var0, var1, gbb.get(gcg));
               return false;
            }
         }
      }
   }

   private static void gcy() {
      String var0 = System.getenv(a.c(1402896268, "翅پ貮\u12c7饵ᾩꗨⰕ뉈㣿뼶䕗쮁刲\ud874"));
      if (var0 == null || var0.contains(a.d("姾⁋ꪊ㓻뼹", -1649138588, 1874099692))) {
         for (int var1 = 1; var1 <= 4; var1++) {
            for (int var2 = 0; var2 < 3; var2++) {
               gbb.add(new gaq(a.c(583375262, "駨\ue05d檜\uf4ed缯"), 8.0, 0.15, var1));
            }
         }
      }

      double[] var13 = new double[]{6.0, 9.0, 13.0, 20.0};
      double[] var14 = new double[]{0.3, 1.5, 2.3};
      if (var0 == null || var0.contains(a.b("瞍ำ蓥᪘酄\u17ef", 1613723624))) {
         for (double var6 : var13) {
            for (double var11 : var14) {
               gbb.add(new gaq(a.d("ᬇ抹\ue86f瘒\ufdce筥", 1778768718, -1663975380), var6, var11, 0));
            }
         }
      }

      if (var0 == null || var0.contains(a.c(2019133105, "蛄ｯ疹\uebc1思\ue6b6"))) {
         for (double var25 : var13) {
            for (double var37 : var14) {
               gbb.add(new gaq(a.c(-1980040361, "ﬢ芉\u085f阧᷻魐"), var25, var37, 0));
            }
         }
      }

      if (var0 == null || var0.contains(a.b("竄ͷ覽៓鰃᪻", 1920301743))) {
         for (int var16 = 0; var16 < 8; var16++) {
            gbb.add(new gaq(a.b("࢟焬ﯦ斈\uee58棠", 887752948), 12.0, 0.0, 0));
         }
      }

      if (var0 == null || var0.contains(a.c(1019759958, "䴱㒗빃″ꯣ"))) {
         gbb.add(new gaq(a.b("\ued44铢Ḷ聆\u0b96", 651554083), 12.0, 0.4, 0));
      }

      if (var0 == null || var0.contains(a.b("胷陵玉\uede0", -464617344))) {
         for (double var26 : new double[]{9.0, 13.0, 20.0}) {
            for (double var38 : var14) {
               gbb.add(new gaq(a.d("Ι稷\uf0e7溎", -182661321, 1978059993), var26, var38, 0));
            }
         }
      }

      if (var0 == null || var0.contains(a.c(678014557, "긳힏嵐쌯䣷칚"))) {
         for (double var27 : new double[]{6.0, 9.0, 13.0, 20.0}) {
            for (double var39 : new double[]{0.3, 1.5}) {
               gbb.add(new gaq(a.c(901603260, "忒♮겱㋎뤖㾻"), var27, var39, 0));
            }
         }
      }
   }

   private static void gcz(MinecraftClient var0, ClientPlayerEntity var1, gaq var2) {
      boolean var3 = var2.phase().equals(a.d("吓ⶦꝧ㤖닔", -553690804, 1237519657));
      kfe var4 = Flow.getInstance().getModuleManager().getByName(a.d("쁂맇㌕굿⚊ꀗᩆ鎱", -691619115, -1359119650));
      gdd(
         var4,
         var2.phase().equals(a.c(56380044, "䫹㍒름⟼갠⪋")) || var2.phase().equals(a.d("漄ᚪ鱺ȓ", -197957066, 266601797)),
         var2.phase().equals(a.d("皩༇藗ᮾ", 1226154320, -1036200050)),
         var2.phase().equals(a.d("ﵺ蓆น遦ᮾ鴓", 1993216269, -1765610471)) ? 10.0 : 1.5
      );
      var4.setEnabled(!var3);
      if (var2.phase().equals(a.d("攰Ზ陂࠲菢", 311657617, 1640292806))) {
         gdg(
            var0,
            a.c(
               -577265585,
               "ꁺ\ud9d6匔쵭䛷쀔穐\uf3b4混\ue74b悚髭ᑿ趋ߓ脸㭪뒦⸘ꠐↇ寥픅亜죤䈮ﮋ痙\uef3d椰\ue29dᱜ附ྫ觥͈볗㛫뀼⦊ꏞ\udd29坫탉䨙쑺緧\uf701煂\uea91擤鸋គ釘ଦ蕼㻊렔㉽ꮵ┊彐\ud8b9勯챮䖙ﾓ礭\uf37e泈\ue610恧馩ጋ赟ڼ肥㩙뎔ⷢꜧ⅍嫃퐅乵장䄑ﬖ瓱\ueea9桔\ue1a5"
            )
         );
      }

      var1.method_31548().method_61496(var3 ? 0 : 1);
      double var5 = gcv.nextDouble() * Math.PI * 2.0;
      double var7 = gcd + Math.cos(var5) * var2.offset();
      double var9 = gcf + Math.sin(var5) * var2.offset();
      gck = var3 ? 0.0F : (float)Math.round(gcv.nextDouble() * 3600.0 - 1800.0) / 10.0F;
      gcl = var3 ? 90.0F : -90.0F;
      gdg(
         var0,
         String.format(Locale.ROOT, a.d("官∭ꢮ㚿뵛㮹臯ࠕ陗Ჳ鬦慒\uef8e瘢ﰤ窓샙伃햭厩\uda18ꁌ\u2ef4딺㌒릅3蹩ᒁ銇", -1121577348, -1570222706), var7, gce + var2.height(), var9, gck, gcl)
      );
      gbz = gcg;
      gch = 0;
      gci = 0;
      gcj = 0;
      gcq = false;
      gcr = false;
      gcp = true;
      gbv[gcg] = 0.0;
      gbw[gcg] = 0.0;
      gbl = Float.NaN;
   }

   private static void gda(MinecraftClient var0, ClientPlayerEntity var1, gaq var2) {
      gci++;
      if (var2.phase().equals(a.d("≸寋턁佯쒿䈇", 713464405, -679167930))) {
         gco += 0.1388888888888889;
         gdg(
            var0,
            String.format(
               Locale.ROOT,
               a.c(1034511288, "揥ᩐ郓ໂ蔰ο맃〿깩Ⓧꍆ奧ힴ丂쑚䊭\uf8f3眱\ued85毆\ue27f顼ᛒ贅ୢ膅㡋똟ⳣꪯⅉ\udfde喔챮䨠샄罕\uf521珹\uea55恟"),
               gcd + Math.cos(gco) * 1.8,
               gce,
               gcf + Math.sin(gco) * 1.8
            )
         );
      }

      if (gch == 0) {
         if (var1.method_23318() > gce + var2.height() - 0.5 || gci > 20) {
            gch = 1;
            gci = 0;
            gcm = var1.method_36454();
            gcn = var1.method_36455();
         }
      } else {
         boolean var3 = var1.method_24828();
         if (!var3) {
            gcq = true;
         }

         float var4 = gdc(gbc, var1);
         float var5 = gdc(gbd, var1);
         int var6 = kmy.strikes();
         gbo = var6 != gbn ? 0 : gbo + 1;
         gbn = var6;
         if (!Float.isNaN(gbl) && gci > 2 && var2.sweep() == 0) {
            double var7 = Math.sqrt(MathHelper.method_27285(MathHelper.method_15393(var4 - gbl)) + MathHelper.method_27285(var5 - gbm));
            gbi[gcg] = Math.max(gbi[gcg], var7);
            if (gbo == 0) {
               gbj[gcg] = Math.max(gbj[gcg], var7);
            } else if (gbo == 1) {
               gbk[gcg] = Math.max(gbk[gcg], var7);
            }
         }

         gbl = var4;
         gbm = var5;
         if (var3 && !gcp && gcq) {
            gby[gcg]++;
         }

         gcp = var3;
         float var17 = var1.method_36454();
         float var8 = var1.method_36455();
         double var9 = MathHelper.method_15393(var17 - gck);
         double var11 = var8 - gcl;
         double var13 = Math.sqrt(var9 * var9 + var11 * var11);
         if (var2.phase().equals(a.c(1458140965, "睐\u0efb萭ᩕ醉ᜢ"))) {
            gbw[gcg] = Math.max(gbw[gcg], var13);
            if (!var3 && System.getenv(a.b("ᅛ棠\ue230籙\uf7eb焷쭶䊋\udcd6噡톨⯒ꔃ㲡뛰〇", 797118733)) != null) {
               System.out
                  .println(
                     String.format(
                        Locale.ROOT,
                        a.d("㓑䵴잦姌툙咤\ueef5朂落珽\uf428๊肟ᤨ錾ᖋ꿒„몲㲮땁콑䆦\uda23尕훜漮\ue13b箟\ufdd8癠被ʭ魄ᴜ鞲⠲ꈊⓓ뵩㜩䦏쎚䑷\udefc傈\ue90d", -204931405, -1388983764),
                        gcg,
                        gci,
                        var4,
                        var5,
                        kmy.debug()
                     )
                  );
            }
         } else if (!var2.phase().equals(a.b("䆽㠈닉Ⲹꝺ", -1508032053))) {
            gbv[gcg] = Math.max(gbv[gcg], var13);
            if (var13 > 0.5) {
               gbx[gcg]++;
            }

            double var15 = Math.sqrt(MathHelper.method_27285(MathHelper.method_15393(var17 - gcm)) + MathHelper.method_27285(var8 - gcn));
            if (var15 > 2.0) {
               gcs.add(var15);
            }

            if (var15 > 0.5 && System.getenv(a.d("極\u10ce騞ѷ迅ङ던㪥ꓸ⹏ꦆ叼\udd2d䒏컞䠩", -1813186387, -2118086258)) != null) {
               System.out
                  .println(
                     String.format(
                        Locale.ROOT,
                        a.d(
                           "頰\ue195歇\uf52d绸\uf845䈔쯣嗹\udf1c壉ꊫⱾ뗉㿟륪̳賿ᙓ遏ᦠ掰\ued47盂\uf0f4稽쏏䷚흴儽\uda98␃깔㞮뇢㬄蒕ິ衾ᇒ鮚\ue560潦\ue8cf爓ﱽ䗹켎䤒틄岦Ꙣ⾘꧑㌩뵧ڏ耘ਬ鏨ᵂ有\ue0e1檺\uf42c綅잀䄢쬩哄\ude12堵",
                           -1926042877,
                           -1517849830
                        ),
                        gcg,
                        gci,
                        var17,
                        var8,
                        var15,
                        var3,
                        kmy.debug()
                     )
                  );
            }
         }

         gcm = var17;
         gcn = var8;
         if (var2.sweep() > 0) {
            gcu.predict(var1, var0.field_1687, gct.get());
            if (!var3 && !gcr && gcu.landing() == var2.sweep()) {
               gcr = true;
               KeyBinding.method_1420(KeyBindingHelper.getBoundKeyOf(var0.field_1690.field_1886));
            }
         }

         boolean var18 = var2.phase().equals(a.c(-1360991899, "\ue902邤ᩰ萀࿐")) ? gci > 420 : gcq && var3;
         if (var18) {
            gcj++;
         } else {
            gcj = 0;
         }

         if (gcj > 24 || gci > (var2.phase().equals(a.c(-72865706, "⠱冗\udb43䔳컣")) ? 440 : 140)) {
            gbt[gcg] = var13 < 1.5;
            gbu[gcg] = var1.method_31548().method_67532() == (var2.sweep() > 0 ? 0 : 1);
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.c(
                        -2125728045,
                        "\uf601辤ն鬜\u10c9陴Ⱕꗒ㯈넽㛸첔䉜\udbbd凫흛浐\ue284硡﹣矜ෘ荳ᢩ黈ᑏ궺⎤륚㼋듣䨪쁮妀\udf84啳\ueaf7悂\ue643翲\uf5b8謄ŏ蚿ᰶ鉝⯏ꅫ✤볠㊑졈䇧쟸崓팃棸\uee7a搗\ufdca獯थ躃ӊ驄Ꮁꦡ⽁ꔍ㪡뀻㙒쿌䔹\udb2c僚횀氱\ue5b3篚\uf11e睓\u0cb4舣᠆釀ᝢ괲⋊뢇㸿럯䷁쌈壭\udeef味\uea1d揍不罹\uf490誕w駥ᾘ镒⫔ꂪ♛뱓㗺쬾䅰월峃툵毲\ue197杞ﲥ独࡞蹋\u07bf鵬ጓꢒ⻅ꑿ㶰뎕䤄컹䒧\uda59倌\ue9b0潤\ue51c竟\uf020癫\u0fdb藐᭒郷ᚭ걀≘믳ㄩ띉䳏숺堪퇈垆\ued63抪\uf8ee縀\uf404跳ͥ餓Ồ鑲⨺ꎄ㧏뽵㒽쪛䀎\ud9e3忰픤欁"
                     ),
                     gcg,
                     var2.phase(),
                     var2.height(),
                     var2.offset(),
                     var2.sweep(),
                     gbp[gcg],
                     gbq[gcg],
                     gbr[gcg],
                     gbs[gcg],
                     gbt[gcg],
                     gbu[gcg],
                     gbv[gcg],
                     gbx[gcg],
                     gbw[gcg],
                     gby[gcg],
                     gbi[gcg],
                     gbj[gcg],
                     gbk[gcg],
                     kmy.debug()
                  )
               );
            gbz = -1;
            gch = 3;
         }
      }
   }

   private static boolean gdb() {
      gdf(a.d("藋ﱎ皜\ue8f6挃\ue59e忏호", 1168533370, 460514040));
      int var0 = 0;

      for (String var4 : new String[]{
         a.b("聪履猞\ued6f暭", 1268613148),
         a.c(-1159913653, "Ἦ暐\uec46爻裏罌"),
         a.d("嶦␍껛ィ뭿㷔", 52244868, 1131703383),
         a.c(-1954266809, "䄬㢟뉕ⰻ\ua7eb⅓"),
         a.b("\ua7f1\ude57咃쫳䄣", 232040342),
         a.c(-874545457, "纸ܖ跆Ꭿ"),
         a.b("ꐩ\udd95坊줵䋭쑀", -353262521)
      }) {
         if (var4.equals(a.b("檓ጯ駰ޏ豗ૺ", -1438291203))) {
            int var28 = 0;
            boolean var30 = true;
            StringBuilder var31 = new StringBuilder();

            for (int var33 = 0; var33 < gbb.size(); var33++) {
               gaq var35 = gbb.get(var33);
               if (var35.phase().equals(a.b("禚&諹ᒆ齞᧳", 364280308))) {
                  var28++;
                  boolean var36 = var35.height() > 11.0;
                  boolean var37 = var36 ? gbq[var33] > 0 && gbs[var33] > 10.0 : gbp[var33] == 0;
                  var30 &= var37;
                  var31.append(
                     String.format(
                        Locale.ROOT,
                        a.b("ꎚ\uda63僥캌䕐쏿秺\uf057渗\ue4f0捸饀គ踬Щ苀㣎띛ⶮ꯸∂塓횱䵸쬌䇁\uf826瘸", 899916710),
                        var35.height(),
                        var37 ? a.c(-1907967722, "륻샎") : a.b("눁쮳䅥", -1859866048),
                        gbp[var33],
                        gbs[var33]
                     )
                  );
               }
            }

            if (var28 != 0) {
               if (!var30) {
                  var0++;
               }

               System.out
                  .println(
                     a.b("캊뜯㷽ꎗ⡂껿ᒮ鵙̓覺\u0e64\uf419竀\ue37e椱\uef94", 1471074043)
                        + (var30 ? a.d("\udefcꝉ", 152730001, 278374144) : a.d("㚛伭엶宂", 466542069, -589370580))
                        + a.d("⒴崍힅䧳숢䒈ﻙ眦\ue93c揅\ue41bṦ邿ँ荎\u05eb", -2013770223, -1675203947)
                        + 10.0
                        + a.b("\udcf5ꕗ", -1340941090)
                        + var31
                  );
            }
         } else {
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;
            int var9 = 0;
            int var10 = 0;
            int var11 = 0;
            double var12 = 0.0;
            int var14 = 0;
            double var15 = 0.0;
            double var17 = 0.0;
            double var19 = 0.0;

            for (int var21 = 0; var21 < gbb.size(); var21++) {
               gaq var22 = gbb.get(var21);
               if (var22.phase().equals(var4)) {
                  var5++;
                  var8 += gbp[var21];
                  var7 += gbq[var21];
                  var9 += gbr[var21];
                  if (gbq[var21] > 0) {
                     var6++;
                  }

                  if (gbt[var21]) {
                     var10++;
                  }

                  if (gbu[var21]) {
                     var11++;
                  }

                  var12 = Math.max(var12, gbw[var21]);
                  var14 += gby[var21];
                  var15 = Math.max(var15, gbi[var21]);
                  var17 = Math.max(var17, gbj[var21]);
                  var19 = Math.max(var19, gbk[var21]);
               }
            }

            if (var5 != 0) {
               if (var4.equals(a.b("\u0a7d珈契杸\uecba", -1494021621))) {
                  for (int var39 = 1; var39 <= 4; var39++) {
                     int var40 = 0;
                     int var41 = 0;
                     StringBuilder var24 = new StringBuilder();

                     for (int var42 = 0; var42 < gbb.size(); var42++) {
                        if (gbb.get(var42).phase().equals(a.d("䟎㹻뒺⫋ꄉ", 1864266670, -1165741034)) && gbb.get(var42).sweep() == var39) {
                           var40 += gbp[var42];
                           var41 += gbq[var42];
                           var24.append(String.format(Locale.ROOT, a.c(531964509, "≸富턔佹쓺"), gbs[var42]));
                        }
                     }

                     System.out
                        .println(
                           a.d("뿛왾䲬틆夓\udfae旿\uec08爒\uf8f0缧蕄ஓ鈷ᠴ麉Ⓥꬕㆬ런㸀䑘쪡", 625966097, -1032600644)
                              + var39
                              + a.b("㣕䅾쯬喈\ude5f壻\ue2aa歓\uf514翫", 1247033573)
                              + var40
                              + a.c(-2041620204, "夳⃑ꨜ㑡뾤㤎茈")
                              + var41
                              + a.c(586991857, "죝넿㯺ꖜ⹏꣭ኩ魬Ԕ辨ࡻ\uf25b")
                              + var24
                        );
                  }
               } else {
                  double var38;
                  boolean var10000;
                  label203: {
                     label202: {
                        var38 = (var4.equals(a.c(-574422621, "ǔ硺\uf2aa泃")) ? 10.0 : 45.0) + 0.5;
                        if (var15 <= var38) {
                           switch (var4) {
                              case a.c(1130731238, "隃\uef3d旫ﮖ灊\uf6e1"):
                                 if (var6 >= var5 - 1 && var7 == var8 && var10 >= var5 - 1 && var11 == var5) {
                                    break label202;
                                 }
                                 break;
                              case a.c(1567587195, "笎ʥ衳ᘋ鷗᭼"):
                                 if (var6 >= var5 - 1 && var7 == var8 && var12 < 0.01 && var11 == var5) {
                                    break label202;
                                 }
                                 break;
                              case a.c(-1712243932, "㭏䋼젶噘\udd88嬰"):
                                 if (var6 >= var5 - 1 && var7 == var8) {
                                    break label202;
                                 }
                                 break;
                              case a.c(-240740589, "靤\ueeca搚侀"):
                                 if (var7 == var8 && var12 < 0.01) {
                                    break label202;
                                 }
                                 break;
                              default:
                                 if (var7 >= 4 && var14 <= 2) {
                                    break label202;
                                 }
                           }
                        }

                        var10000 = false;
                        break label203;
                     }

                     var10000 = true;
                  }

                  boolean var23 = var10000;
                  if (!var23) {
                     var0++;
                  }

                  System.out
                     .println(
                        a.d("䁭㧈댚⵰ꚥ‘驉Ꮎ趤", -204865187, 1115046232)
                           + var4
                           + (var23 ? a.c(1529662521, "찚뗤㼳") : a.c(-42478989, "퉖ꮁ⅕뼬㓾"))
                           + a.c(-615054464, "β稙\uf08e滩\ue523掍\ud9dd偢")
                           + var5
                           + a.b("Ｓ蛑జ鉡ᦤ鼎═겠㋟롘㾖엸䬬틓", -1787166947)
                           + var6
                           + a.b("\udf41ꚱⱷ눆㧄뽷Ԭ賅ዔ", -1990074520)
                           + var8
                           + a.b("㧪䀈쫅咸\udf7d姗\ue3d1", 1160657357)
                           + var7
                           + a.d("꺗흥嶧쏍䠇컿", -1287800332, 5904197)
                           + var9
                           + a.c(22470665, "\ue023駄ገ赵ڰ耴㩄뎷ⷠ꜇")
                           + var10
                           + a.b("⇝堿틳䲁읍䇊﮺牉\uec1e曹", -780656137)
                           + var11
                           + a.b("७炟祈搳\uefcd楊팂嫼쒱义", 1005586759)
                           + String.format(Locale.ROOT, a.d("哎\u2d74Ꞻ㦞", -338961959, 1973390646), var12)
                           + a.b("류삥䩻퐅忘\ud964挰\ueac8璃ﹼ", -1469400718)
                           + var14
                           + String.format(
                              Locale.ROOT,
                              a.c(594019499, "ұ絍\uf792槺\ue201撑\udec5在줶䏜쐒㹩낶⥑ꌚ◠龰ံ諃\u0cd3蔱ｿ燳\uea1f汪\ue6b3彖턟䯣춭䙉룞㋐ꬦⵧꟇ᠇鉅ᒣ贍܄秭\uf3b5琛\uee9b悬\ud977厂허丝쁪㪦덅㔑꿩↦驏᳑"),
                              var15,
                              var17,
                              var19,
                              var38 - 0.5
                           )
                     );
               }
            }
         }
      }

      if (!gcs.isEmpty()) {
         double var26 = Double.MAX_VALUE;
         double var27 = 0.0;
         double var29 = 0.0;

         for (double var34 : gcs) {
            var26 = Math.min(var26, var34);
            var27 = Math.max(var27, var34);
            var29 += var34;
         }

         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.b("섈뢭㉿강⟀ꅽᬬ鋛ು蘢Ǭﮆ畄\uece0暮\ue059娗했佨줾䃘㪜됬⾴꧑⍎骮ᓧ蹑ࡄ莺絯\uf727溅\ue8ce扴\uddbc垚턏䣿슷뱗㙞뇷⬫ꕅ᳁阶ဴ诩փ７皸\uf0e2樎\ue408", 1848099153),
                  gcs.size(),
                  var26,
                  var29 / gcs.size(),
                  var27
               )
            );
      }

      System.out
         .println(
            a.d("絡ӄ踖ၼ鮩ᴔꝅ⺲남㩍붏䟨줸僝", 1693725021, 950094931)
               + (var0 == 0 ? a.b("뽸웘䰙퉨", -2135507156) : a.d("砦Ɛ譋ᔿ麄ᠽ", 2016966189, 1639976523) + var0 + a.c(-2070921256, "㿰"))
         );
      return true;
   }

   private static float gdc(Field var0, ClientPlayerEntity var1) {
      try {
         return var0.getFloat(var1);
      } catch (RuntimeException | ReflectiveOperationException var3) {
         return 0.0F;
      }
   }

   private static void gdd(kfe var0, boolean var1, boolean var2, double var3) {
      for (vmo var6 : var0.getSettings()) {
         String var7 = var6.getName();
         switch (var7) {
            case a.b("\udd17ꒂ⹔됶㿯뵌ݦ躝Ⴝ驰᷑\ue3b0椄\uf0c2窕ﰔ䘫", -2113283814):
               ((vmc)var6).set(var3);
               break;
            case a.b("ਁ玜聾杏\ue8f7湈퀉妁쟔䴚쪵ザ멱➣궇⭲配Ử", 1828195855):
               ((vmc)var6).set(60.0);
               break;
            case a.d("㒥䴊장妦툇哈\ueeec", -635672334, -1308862352):
               ((vlv)var6).set(var1 ? a.d("심뭇\u31e9꿭⑅", 107002353, 7700282) : a.c(-1559172839, "\ued09钙ṉ耵௪贤㝴뻾₫ꩥ"));
               break;
            case a.b("椂Ⴈ驿Ѱ这ग덇㪸", 1252355371):
               ((vmc)var6).set(var2 ? 0.3 : 1.0);
               break;
            case a.b("숀뮓ㅏ꽄", -512178664):
            case a.c(1515057882, "\uf6c5輮օ鮎ၐ"):
            case a.d("ภ瞽ﵧ挓\ue8b6湷푖姅쎈䤼컫㒒먱⏻ꦬ", -1885777674, 1563450059):
            case a.d("益ཨ薹ᯇ鐏ᚣ곽ℜ뭒㆑똺䱀슕孕", 938611334, -262512541):
            case a.d("篈ɞ裸ᛴ鵝ᯭꆰⰭ똓㳘묎䄃", 1528016615, -1328426703):
               ((vkl)var6).set(true);
               break;
            case a.b("凢⡿ꋕ㲧뜂ㆾ讖ș鰱", -367634945):
               ((vmc)var6).set(3.0);
               break;
            case a.d("㎤䩇샬庖핃台\uedb3恐精璳\uf36fच蟌ṵ鐣ዒ", 1520702691, -2002181306):
               ((vkl)var6).set(System.getenv(a.b("\ue6ce齵ᖥ诌~蚢㳣딞⭃ꇴ☽\udc5d劋쬳䅧잛緔", 61466265)) == null);
         }
      }
   }

   private static void gde() {
      if (!gcb) {
         gcb = true;
         AttackEntityCallback.EVENT
            .register(
               (AttackEntityCallback)(var0, var1, var2, var3, var4) -> {
                  int var5 = gbz;
                  if (!var1.method_8608() && var5 >= 0 && var3.method_5628() == gca) {
                     float var6 = var0.method_7261(0.5F);
                     boolean var7 = var6 > 0.9F && var0.field_6017 > 0.0 && !var0.method_24828() && !var0.method_5624();
                     boolean var8 = var0.method_6047().method_31574(Items.field_49814) && var0.field_6017 > 1.5 && !var0.method_6128();
                     boolean var9 = var3 instanceof LivingEntity var10 && var10.field_6008 > 10;
                     gbp[var5]++;
                     if (var8) {
                        gbq[var5]++;
                     }

                     if (var7) {
                        gbr[var5]++;
                     }

                     gbs[var5] = var0.field_6017;
                     System.out
                        .println(
                           String.format(
                              Locale.ROOT,
                              a.d(
                                 "\u0bdc特\uf8ab曁\ued14殩퇸堏옕䳷쬲ㅔ뾇☥걡⫂郌Ἀ薻Ͽ訊\uf053纫\ue53e捗\ue99b倷\ude2b䓄싔䤣랫㶠ꑉ∑ꢼ\u173f鴈ᮝ舫ࡹ皈ﲊ笣\ue1ff澒형峢\udaea䄮콀㖋밧㩼ꃖ⺟镶Ᏼ駄\u001e躠\uf4e2猄綾柀\uee69吱틜壟율䶨쯇㈔뢷⛿굛⬔釳ᡳ虁ಟ諕\uf17b翣\ue58c氋\ueaeb僳\udf03䕆쏦䨻끄㺃ꕾ⌷ꦮ",
                                 1329275695,
                                 -645060365
                              ),
                              var5,
                              var0.method_23318() - gce,
                              var0.field_6017,
                              var0.method_24828(),
                              var6,
                              var8,
                              var7,
                              var9
                           )
                        );
                     return ActionResult.field_5811;
                  } else {
                     return ActionResult.field_5811;
                  }
               }
            );
      }
   }

   private static void gdf(String var0) {
      kfe var1 = Flow.getInstance().getModuleManager().getByName(var0);
      if (var1 != null) {
         var1.setEnabled(false);
      }
   }

   private static void gdg(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }
}
