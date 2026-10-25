package a;

import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;

final class fkm {
   private static final String[][] fkn = new String[][]{
      {a.c(1025493841, "쬼늙㡍꘡ⷫꭉᄤ飽ڼ谊ௐ\uf1b5"), a.c(1429218099, "⍙嫹퀷乞얐䌐若炌\ueec6"), a.b("ᑥ淖\ue710祊\uf2b2琖칔", 1725830145)},
      {a.c(-1455105884, "\ud8d9ꅰ⮤뗟㸃뢵˷謡ᕖ鿹ᠭ\ue255沖"), a.d("⓽嵋힅䧨숢䒿ﻛ眣\ue969", 1075746262, 1093710154), a.b("쎻먉ニ꺩╧ꏢᦞ遺ิ", -980237375)},
      {a.c(-2055241250, "膳\uf816狘\uecb5来\ue1ff宄퉫䰳욋䅌"), a.d("夲₈꩕㐠뿇㥌茛ૹ钧", 1592752730, 411968271), a.d("\uf0a2褑ϟ鶩ᙸ郒⪊ꍁ㴱랕し", -632387585, 1846835005)},
      {a.c(994076566, "柹ṉ钒ૡ脷\u07b7뷌㐣ꩻ\u20c3꜄"), a.d("뤪삅䩋퐭忱\ud977挓\ueaeb璡", 949491773, -972512919), a.d("꒞\udd39執즇䉛쓐纬\uf748椆", 901330400, -907177709)},
      {a.d("䦴〟뫗⒡꽡⧽鎆ᩩ萱ຉ襎", -286517117, 1246056799), a.c(-1493936905, "咔\u2d28ꟿ㦋뉋㓬躮ݴ餜Ꭴ鑢"), a.c(885054376, "\udbd6ꉸ⢢뛞㴀뮋Ƿ蠓ᙝ")},
      {a.c(-1577781954, "\uf542質ؿ顃Ꭿ锶⽻ꚍ㣛뉾"), a.d("⇢塚튄䳶윑䆗\ufbcd爩", -129687334, -181599912), a.d("唵ⲋꙟ㠲돢㕸輄۠颮", 1566018214, -523247619)},
      {
            a.b("糡Ղ辛ᇴ騤ᲆꛫ⼲녳㯅밟䙺", -604930914),
            a.d("Ё綺\uf76a椃\ue2c6摠\ude1e埓증䌱쓺㺒", -1261658958, -246834983),
            a.c(2020558241, "䗉㱠뚨⣪ꌒ▶鿴"),
            a.d("\ud943ꃰ⨶둬㾔뤴ͥ誜", 288221364, -161140324)
      },
      {a.d("䙢㿜딆\u2b75ꂫ☩鱒ᖽ该ŝ蚚", -8236403, -766897019), a.c(1683486537, "\uf73a躐ќ騂ᇢ靚ⴜ"), a.b("㙖俸씮孛킄嘏\uec73斗ﯙ", -248891860)},
      {a.b("\uf4a4贚ߘ馭ቫ铘⺃", 1874523337), a.d("跡\uf459纝\ue0cb欮\ued93埒\ude3b", 1915558893, 12293730), a.c(-1081936415, "\uf582谼ۦ颗ፕ闂⾾Ꙛ㠔")},
      {a.d("飯\ue15c殚\uf5c0縸\uf898䋉쬰", -1002608043, 1121579729), a.d("\ud883ꄹ⯤떑㹶룽ʪ譈ᔖ", 1505158262, -191480686), a.b("遇\ue9e0挠ﵗ皈\uf038䩚쎄巎흮", 1701679145)},
      {a.c(2091963029, "틺ꭎ\u218f뿭㐱늚ࣈ脾ὶ闽ሁ\ue861暴－"), a.d("\uf621辁Տ鬦შ陨Ⰼꗴ㮾", 660372061, 1754696726)},
      {a.b("៝湯\ue4a2竔\uf132瞷췮䐊\uda40僾휢ⵁ", -1936451675), a.b("ࠌ熺ﭴ攙\ueed3桎툪寒얘", 71960685)},
      {a.c(-646497243, "㱏䗪켾兒\uda98尺\ue657澚\uf1c7筧ﲡ"), a.d("꼢횂屌숥䧫콫甏ﳷ抽", 197097614, -145107002)},
      {a.c(790220942, "탫ꥑ⎅뷣㘭낑ૼ茱ᵬ韌ည"), a.b("虎￡甯\ueb49悕\ue613屷햏䯅", 544769584)}
   };
   private static final String fko = a.b("境ℬ꯸㖀빃㢻芶\u0b46锑ᾢ顰戰\ueccf畠Ｔ秌쎗䰙훶傲\ud954ꍋⶦ뙡」뫚͡贱៷醉ᨯ\ue4ef滸\uf74d焗﮳䐪츉䣝텱嬲◞꾡⠧당㲝蔖\u0fe9覥ቶ鰍暍\uef6a椴\uf3d6綃옭䃾쪅", -1791534897);
   private static final int fkp = 60;
   private static double fkq;
   private static double fkr;
   private static double fks;
   private static boolean fkt;
   private static boolean fku;
   private static final int fkv = 50;
   private static final String fkw = System.getenv(a.b("\uf0ee襕΅鷬ᙞ邂⫍ꌰ㵳럎〃쩥", 144437412));

   private fkm() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      if (var1 == 1) {
         flh(var0, a.d("祻Ì訓ᑪ龵ᤆꍞ⪮뒴㹆름䏢촱咕\udedb堵\ue269", 417626828, 1840382913));
         flh(var0, a.c(1966096109, "㺔䜸췯厖\ud804廦\ue4a3浃\uf348积︺ы誜"));
         flh(var0, a.b("⩤叇\ud910䝴첿䨃\uf047秤\ue7f8浆\uea9cჩ鸭", -1334695394));
         ucg.ENABLED.set(false);
         var0.field_1690.field_1842 = true;
         fkq = Math.floor(var0.field_1724.method_23317()) + 0.5;
         fkr = Math.floor(var0.field_1724.method_23318());
         fks = Math.floor(var0.field_1724.method_23321()) + 0.5;
         System.out.println(a.c(906401395, "阂\uefbf数ײַ烀\uf660䰮엕定텸囧겕≌미ㆪ띚ോ芀") + Cosmetics.items().size());
      }

      byte var2 = 20;
      boolean var3 = a.b("ꂣ\ud905叁춥䙧샅", 1270587588).equals(System.getenv(a.c(1609610802, "뙺쿁䔑\udb78僊혖汙\ue5a4篧\uf15a皙賩ȼ鮘")));
      int var4 = var3 ? var2 : var2 + fkn.length * 60;
      if (var1 >= var2 && var1 < var4) {
         int var5 = (var1 - var2) / 60;
         int var6 = (var1 - var2) % 60;
         flg(var0, 30.0F, 8.0F);
         if (var6 == 0) {
            flc(fkn[var5]);
            var0.field_1690.method_31043(Perspective.field_26665);
         }

         if (var6 == 24) {
            fli(var0, a.c(658348784, "骗\ue32a槥\uf7ca") + String.format(a.d("螺肵\u0a64鑃", 1057241400, -429408248), var5) + a.b("䃚㤤돴ⶇꙘ", -1953873678));
         }

         if (var6 == 26) {
            var0.field_1690.method_31043(Perspective.field_26666);
         }

         if (var6 == 44) {
            fli(var0, a.b("ଶ犋\uf844晫", 351406929) + String.format(a.d("闬\uec48暙\uf8be", 663228853, -51673992), var5) + a.b("\uf01d觧̠鵌ᚚ週", 429322294));
         }
      }

      if (var1 >= var4 && var1 < var4 + fla()) {
         flb(var0, var1 - var4);
      }

      if (var3 && var1 == var4 + fla()) {
         var0.method_1507(null);
         Cosmetics.clearAll();
         System.out.println(a.c(-1972809577, "僔⥩ꎦ㷉똖ザ諸̃鵌ឮ逩橉\ue488紾\uf739熉쯑䐗\udeb1壵턑ꬒ◱븸㡎늍ନ蔼ᾏ駕ቧ\uecbd"));
         return true;
      } else {
         int var16 = var4 + fla();
         if (var1 == var16) {
            flc(
               new String[]{
                  a.d("ᬩ技\ue854瘯ﷳ筅섇䣑횦尉\udbdd↥꽦", -692522264, -1052382788),
                  a.c(1018516351, "匔⪧ꁡ㸻뗃㍣褲Ë"),
                  a.b("阳\uef80敎טּ烩\uf643䰛에宠턄囆", -1173055917),
                  a.b("྆瘼ﳡ抔\ue973濸햯屍숓", 1234178017)
               }
            );
            var0.field_1690.method_31043(Perspective.field_26665);
            flg(var0, 30.0F, 8.0F);
         }

         if (var1 == var16 + 20) {
            fli(var0, a.c(731266809, "㺒䜯췠叏\ud85c廠\ue4bb浃"));
            var0.field_1690.field_1894.method_23481(true);
         }

         if (var1 > var16 && var1 < var16 + 160) {
            flg(var0, 30.0F, 8.0F);
         }

         if (var1 == var16 + 45) {
            fli(var0, a.c(389268365, "쏦멛ゔ꺻┶ꎑ\u19cf逹"));
            var0.field_1724.method_5728(true);
            var0.field_1690.field_1867.method_23481(true);
         }

         if (var1 == var16 + 70) {
            fli(var0, a.d("諐\uf36d禢\ue78d氄\ueab6僧\ud90d䝕췾", 1104769802, 692124083));
            var0.field_1690.field_1867.method_23481(false);
            var0.field_1724.method_5728(false);
            var0.field_1690.field_1894.method_23481(false);
         }

         if (var1 == var16 + 90) {
            var0.field_1690.field_1903.method_23481(true);
         }

         if (var1 == var16 + 92) {
            var0.field_1690.field_1903.method_23481(false);
         }

         if (var1 == var16 + 95) {
            fli(var0, a.b("綹Є軋ფ魴ᷚꞑ\u2e7d", 461405650));
         }

         if (var1 == var16 + 110) {
            flh(var0, String.format(Locale.ROOT, a.c(-2123220860, "㣤䅑쯒嗃\ude27壅\ue293歩\uf529翏\uf85aȮ賲ᕜ齘᧯ꎥⱿ뛓フ"), fkq, fkr + 9.0, fks));
         }

         if (var1 == var16 + 126) {
            fli(var0, a.c(-173720184, "㷣䑞캑傾\udb22嶔\ue7ca渻"));
         }

         if (var1 == var16 + 140) {
            var0.field_1690.field_1832.method_23481(true);
         }

         if (var1 == var16 + 155) {
            fli(var0, a.d("ᧀ恽\ueab2璝４禸쏠䨕푀", 59588481, -857463253));
            var0.field_1690.field_1832.method_23481(false);
         }

         if (var1 >= var16 + 160 && var1 < var16 + 175) {
            float var7 = 30.0F + (var1 - var16 - 160) * 9.0F;
            flg(var0, var7, 8.0F);
         }

         if (var1 == var16 + 172) {
            fli(var0, a.c(1077176466, "棹ᅄ鮋֤踪࢚닎㬣"));
         }

         if (var1 == var16 + 180) {
            var0.field_1690.method_31043(Perspective.field_26664);
            flg(var0, 75.0F, 4.0F);
         }

         if (var1 == var16 + 200) {
            fli(var0, a.c(1699535322, "\ud9b6ꀋ⫄듫㽷막\u0381話ᐩ麜ᥚ\ue33c淪\uf447縕"));
         }

         int var17 = var16 + 210;
         if (var1 == var17) {
            Cosmetics.clearAll();
            flh(var0, String.format(Locale.ROOT, a.c(315734865, "물슉䠊혛巿\udb1d態\ue8b1盱ﰗ箂臶༪隄ᲀ騷⁽꾧㔋댍㪼䃴칎喏폠"), fkq, fkr, fks));
            double var8 = fkq - 3.5;
            double var10 = fkr;
            double var12 = fks;
            UUID var14 = var0.field_1724.method_5667();
            var0.method_1576().execute(() -> fnq.spawn(var0.method_1576(), var14, var8, var10, var12));
         }

         if (var1 == var17 + 30) {
            fkt = fld();
            System.out
               .println(
                  a.c(-1607415960, "윜뺡㑮ꨁ⇞Ꝿᴰ铋\u0a84聦ߦ\ufd90獒\ueaf6悤\ue653屏폝䥢켸䛎㳚뉮")
                     + Cosmetics.code()
                     + a.b("퇩ꡓ⊌벭㝫뇉ஜ艠ᱦ際ᅋ\ueb3a早ﱆ瘐\uf0b1", 2036519390)
                     + ucg.cosmeticsOf(a.d("ꙇ\udfdc唌쭥䂇옛籓", 488947690, 1878530540))
               );
         }

         if (var1 > var17 && var1 < var17 + 120) {
            flg(var0, 90.0F, 6.0F);
         }

         if (var1 == var17 + 1) {
            var0.field_1690.method_31043(Perspective.field_26664);
         }

         if (var1 == var17 + 70) {
            fli(var0, a.c(2115957788, "\uf475跈܇館አ鐆⹝Ɪ㧪덊"));
            fku = fle(var0);
         }

         if (var1 == var17 + 75) {
            var0.field_1690.method_31043(Perspective.field_26665);
         }

         if (var1 == var17 + 100) {
            fli(var0, a.d("䦄〹뫶ⓙ꽑⧷鎬\u1a5f萛ົ褠猚\ufdca摨", 591938664, 235212161));
         }

         int var18 = var17 + 120;
         if (var1 == var18) {
            var0.field_1690.method_31043(Perspective.field_26665);
            var0.field_1690.field_1842 = false;

            try {
               Field var9 = hlc.class.getDeclaredField(a.b("괼풘幈쀐䯩쵄", 1925426510));
               var9.setAccessible(true);
               var9.set(null, a.b("荠\ufafd瀲\uee5d斂\ue322奬킗付", 2108523306));
            } catch (Exception var15) {
               System.out.println(a.b("㉌䯨세弋풚判\ue87b憃ￔ画\uf2f2", -2116865485) + var15);
            }

            var0.method_1507(new hlc());
         }

         if (var1 == var18 + 30) {
            fli(var0, a.d("瀙ত荫ᵄ雙ၺꨵ", -778026717, 1479225694));
         }

         if (var1 >= var18 + 40) {
            var0.method_1507(null);
            List var19 = Cosmetics.items();
            boolean var20 = !flf(a.b("ꚑ\udf2a嗺쮓䀝웡精\uf553欒\ue1ab晩鰅ዘ謤Ě蟇㶔뉛⣠꺠❊崑펆䡼츀䓉", 700163821), a.d("彚⛬갷㉃릝㼭", 1604315028, 647870638));
            boolean var11 = var19.size() >= 30 && fkt && fku && var20;
            System.out
               .println(
                  a.c(-498524822, "ᴆ撻\uee74瀛\ufbc4絤윪仑킞婼\uddfb➛\ua95aレ뫫")
                     + (var11 ? a.b("⒎崮ퟯ䦞", 1300505818) : a.d("՜糪\uf631桅", 378173547, -1294041739))
                     + a.b("ⵐ哩", 811150706)
                     + var19.size()
                     + a.c(2134002941, "䳓㔫뿥ↅ\uaa5a\u2cf5雹ἄ脋\u0bab豫瘜\uf8c6愮")
                     + fkt
                     + a.c(-72599737, "㝢仟쑞娸퇧坔\ued1c擼\ufae6")
                     + fku
                     + a.b("漡᚜鰈ɲ覦༏딋", 1211985674)
                     + var20
                     + a.b("肸", 510623888)
               );
            Cosmetics.clearAll();
            ucg.ENABLED.set(true);
            return true;
         } else {
            return false;
         }
      }
   }

   private static int fkz() {
      return fkw != null ? 1 : 24;
   }

   private static int fla() {
      return fkz() * 50 + 240;
   }

   private static void flb(MinecraftClient var0, int var1) {
      List var2 = fkw != null && Cosmetics.get(fkw) != null ? List.of(Cosmetics.get(fkw)) : Cosmetics.ofSlot(a.b("་皭ﱩ戍\ue9cf潭", -2056122516));
      int var3 = var1 / 50;
      int var4 = var1 % 50;
      if (var3 < fkz()) {
         if (var3 < var2.size()) {
            flg(var0, 30.0F, 8.0F);
            if (var4 == 0) {
               flc(new String[]{((CosmeticItem)var2.get(var3)).id});
               var0.field_1690.method_31043(Perspective.field_26666);
            }

            if (var4 == 18) {
               fli(var0, a.b("ꠥ톘字앸代졅牍", -1904170943) + ((CosmeticItem)var2.get(var3)).id + a.b("緱Ћ軌Ⴀ魶ᷝ", -649888294));
               var0.field_1690.method_31043(Perspective.field_26665);
            }

            if (var4 == 36) {
               fli(var0, a.c(-282329569, "ﹻ蟆ഉ錦ᢽ鸛␓") + ((CosmeticItem)var2.get(var3)).id + a.b("銐\ueb6e憾ￍ琒", -110390600));
            }
         }
      } else {
         String var5 = fkw != null ? fkw : a.b("먷쎜䥎휸峮\uda6f怄\ue9fb瞿ﴐ", 129677903);
         int var6 = var1 - fkz() * 50;
         if (var6 == 0) {
            flc(new String[]{var5});
            flh(var0, a.b("䊀㬬뇮⾗ꐍ⋮颪ᅎ輍ֱ艠砗\uf685潱\ue529揂\ud990噜쳢䫪썽뤟㟿걹⨔ꃁᥣ霭ෛ诊:ﻧ璠\ued56欃\ue1bb幣퐘劏쭩䄨㿄떋㉲꣡⚝齆ᗻ鎶ࡦ蘟糵\uf56e猻\ue9d0果\udc35", -991214896));
            var0.field_1690.method_31043(Perspective.field_26666);
         }

         if (var6 >= 0 && var6 < 200) {
            flg(var0, 30.0F, 8.0F);
         }

         if (var6 == 14) {
            fli(var0, a.c(-1024157143, "驛\ue3e6椩\uf706粝層䀳즇埕\udd73媽ꂎ⸇랲㷹묕Ō"));
            var0.field_1690.field_1894.method_23481(true);
         }

         if (var6 == 34) {
            fli(var0, a.c(-2868670, "㨱䎌쥃坬\udcf7婑\ue059槭\uf7bf紙𧻓ä蹩៎鶐᭦"));
            var0.field_1690.method_31043(Perspective.field_26665);
         }

         if (var6 == 50) {
            fli(var0, a.c(-1067583919, "\uf627辚Օ魺ს陇ⱏꗻ㮩넏㛁쳲䉿\udbd8円흰浹\ue2e7硗︄矻"));
            var0.field_1690.method_31043(Perspective.field_26666);
            var0.field_1724.method_5728(true);
            var0.field_1690.field_1867.method_23481(true);
         }

         if (var6 == 72) {
            fli(var0, a.c(-1440959815, "니쭵䆺\udf95后튨梠\ue114罆\uf5e0爮蠝ڔ鼦ᕷ鎝⧕ꘞ"));
            var0.field_1690.field_1867.method_23481(false);
            var0.field_1724.method_5728(false);
            var0.field_1690.field_1894.method_23481(false);
         }

         if (var6 == 84) {
            var0.field_1724.method_6104(Hand.field_5808);
         }

         if (var6 == 86) {
            fli(var0, a.b("ꙺ\udfc7唈쬧䂼옚簒\uf5a6毴\ue152暜鲯ሦ讓Ǟ蜨㵮", 452503048));
            var0.field_1690.field_1832.method_23481(true);
         }

         if (var6 == 96) {
            fli(var0, a.d("\uf8ad脐\u0bdf闰ṫ飍⋅ꭱ㔣뾅㡋쉸䳱핝弅\ud9f0掵", 1323254719, 331529056));
            var0.field_1690.field_1832.method_23481(false);
            var0.field_1690.field_1903.method_23481(true);
         }

         if (var6 == 98) {
            var0.field_1690.field_1903.method_23481(false);
         }

         if (var6 == 101) {
            fli(var0, a.c(104289379, "吐ⶭꝢ㥍닖㑰蹸ߌ馞ጸ银滅\ue055移\uf3b0畜"));
            flh(var0, a.b("枘ḯ铰ઉ腖ߥ붽㑍꩗₵Ꝡ崖폅䩫쀧䛁ﲃ", -396924946));
            flh(var0, a.d("㶠䐔컋傶\udb67巔\ue7c2湓\uf03f竝ﴟݿ觥ၐ騄\u1cfeꚷ⥷돗㖁뱤왻䢕퍆唲\udfe8晌\ue806狻", -1267658956, -400739603));
         }

         if (var6 == 103) {
            fli(var0, a.c(913483553, "Ꝓ\udeef吠쨏䆔윲紺\uf48e櫜\ue07a枴鶇ጕ誹í蘚"));
            flh(var0, a.d("書\u1f4f閐௩耶څ볝㔭ꬷ⇅ꘇ屡튲䬖션䞶\ufdea", 480017498, 336861908));
         }

         if (var6 == 104) {
            flc(new String[]{var5, a.b("뫷썉䦓ퟠ尾\udabc惇\ue928睰\ufdc8稏", 928627357)});
            var0.field_1690.method_31043(Perspective.field_26665);
         }

         if (var6 == 124) {
            fli(var0, a.c(1595029269, "㝧仚쐕娺톡圇\ued0f撻\ufae9灏\uf781\u0db2茿᪐郄ᘼ걧"));
            flc(new String[]{var5});
            var0.field_1690.field_1842 = false;
            var0.method_1507(new InventoryScreen(var0.field_1724));
         }

         if (var6 == 150) {
            fli(var0, a.c(-495765348, "㣪䅗쮘喷\ude2c墊\ue282欶\uf564翂\uf80cȿ責ᔚ齑ᦳꏷⰼ뚔ヘ뤤"));
            var0.method_1507(null);
            var0.field_1690.field_1842 = true;
            flc(new String[]{a.c(-942674837, "\uec04閾ὧ脗\u0ad7豋㘠뿟↛ꬴ")});
            var0.field_1690.method_31043(Perspective.field_26666);
            var0.field_1690.field_1894.method_23481(true);
            var0.field_1724.method_5728(true);
            var0.field_1690.field_1867.method_23481(true);
         }

         if (var6 == 176) {
            fli(var0, a.c(909319798, "Ḇ枻\ued74獛\uf8c0繦쑮䷁펝央\udee6⒐꩝㎵릮㽔蔑ુ遥"));
            var0.field_1690.field_1867.method_23481(false);
            var0.field_1724.method_5728(false);
            var0.field_1690.field_1894.method_23481(false);
            flh(var0, a.b("槎ၢ骠ә轃ঠ돤㨀ꑃ\u2eff꤮卙\uddcb䐿칧䢌\uf2de紒\ue7ac憤\ue833鉑Ჱ蜷Ś讏㈭뱣⚕ꂄ\u2b74햩忮옘䁍쫵甭ｖ私\ue027橦ᒊ黅\u193c莪ී됛", -1372821112));
         }
      }
   }

   private static void flc(String[] var0) {
      Cosmetics.clearAll();

      for (String var4 : var0) {
         CosmeticItem var5 = Cosmetics.get(var4);
         if (var5 != null) {
            Cosmetics.toggle(var5);
         } else {
            System.out.println(a.d("ᯕ扨\ue8a7盈ﴗ箷쇹䠂혞峢\udb35⅞꾉㘢뱶㪎肆", 1072162413, 110230986) + var4);
         }
      }
   }

   private static boolean fld() {
      try {
         Field var0 = ucg.class.getDeclaredField(a.d("\ufde5葘\u0e80郰", -1420035194, 67569156));
         Field var1 = ucg.class.getDeclaredField(a.c(556005734, "螺肱ੱ鐆\u1fdc饝⌣"));
         Field var2 = ucg.class.getDeclaredField(a.c(-1198664489, "풝괤⟿릁㉑듷ລ"));
         var0.setAccessible(true);
         var1.setAccessible(true);
         var2.setAccessible(true);
         var0.set(null, a.d("藹ﱀ皛\ue8e2挽\ue584", 597880319, 1779001421));
         var1.set(null, a.b("ί稏\uf0ca溼\ue532揞\ud99c偾츧䒛", 75367377));
         List var3 = (List)var2.get(null);
         var3.clear();
         ubm var4 = new ubm();
         var4.code = a.d("僾⥇ꎜ㷥똺ゃ", 1721586671, -1560083622);
         var4.name = MinecraftClient.method_1551().method_1548().method_1676();
         var4.online = true;
         var3.add(var4);
         ubm var5 = new ubm();
         var5.code = a.d("㿞䙢첪勍\ud917徽", 197516191, -1155472379);
         var5.name = a.c(1040991407, "䓮㵵랥⧌ꈮ⒲黺");
         var5.online = true;
         var5.cosmetics = a.d("훧꽈▜믤〧뛟\u0cd2蔢᭵釆ᘔ\uec54披ﬄ煐\uf7a8䷳쉽墒\uded6地\u2d2fꏂ㠅빩㒾贅͕馓῭鑋檋\ue09c礩ｳ痗쩎䁭욹引핖ꮺ⇅ꙃ㲝당୲膍߁鰒ቩ\ue8e9愎\ue750網\uf3e7䡉캚䓡", 57324718, -982359547);
         var3.add(var5);
         return a.c(-435270875, "䭩㋆렒♪궩⭑酜\u18ac蛻ై讚燚Ｅ暊\uecde樦큽忳씜䍘쪾낡㹌ꖋ⏧ꤰႋ黛Н艣\u09c5\uf705紒\ue4a7拽\ue859埀\udde3嬷슛䣘㘴뱋㯍ꄓ⽷雼ᰃ驏Ɯ迧畧ﲀ竞\ue03c湩헇匔\ud96f")
               .equals(ucg.cosmeticsOf(a.d("ൺ瓡︱恘\uebba洦흮", 504606791, -759120516)))
            && ucg.cosmeticsOf(a.b("ﰻ薫ཱུ鄉\u1ad5鱹", 661519475)) == null;
      } catch (Exception var6) {
         System.out.println(a.d("멡쏁䤁흶岬\uda44恞\ue9a8石﵍窘胾\u0e7d鞊ᷞ鬧Ⅽ꺵㐇눈㯥", -1847751607, -954714547) + var6);
         return false;
      }
   }

   private static boolean fle(MinecraftClient var0) {
      try {
         Entity var1 = var0.field_1687.method_8469(fnq.spawned);
         Field var2 = Cosmetics.class.getDeclaredField(a.c(420921525, "샿륌㎄귨☹ꂉ᫇"));
         var2.setAccessible(true);
         Map var3 = (Map)var2.get(null);
         boolean var4 = var1 != null && var3.containsKey(var1.method_5628());
         System.out
            .println(
               a.d("꯹퉄墋웤䴻쮛燕\uf82e晡\uec83欂酤Ά蘈ీ誠オ뼹▇ꏍ⩮", 420515449, 1299850742)
                  + (var1 == null ? a.c(-793928944, "魺\ue2cf栆\uf677綺\ufb0c䅖") : var1.method_5477().getString())
                  + a.c(-1623507862, "㱂䖾콯儅\udacf屸\ue62a澕")
                  + var4
            );
         return var4;
      } catch (Exception var5) {
         System.out.println(a.d("㣺䅉쮁嗭\ude3c墌\ue291欣\uf577翋\uf81eɧ賻ᔌ齘ᦡꏫⰳ뚁ゎ륣", -1085271836, -363255706) + var5);
         return false;
      }
   }

   private static boolean flf(String var0, String var1) {
      try {
         Field var2 = Class.forName(var0).getDeclaredField(var1);
         var2.setAccessible(true);
         return var2.getBoolean(null);
      } catch (Exception var3) {
         return true;
      }
   }

   private static void flg(MinecraftClient var0, float var1, float var2) {
      var0.field_1724.method_36456(var1);
      var0.field_1724.method_36457(var2);
      var0.field_1724.field_5982 = var1;
      var0.field_1724.field_6004 = var2;
      var0.field_1724.method_5636(var1);
      var0.field_1724.field_6220 = var1;
      var0.field_1724.method_5847(var1);
   }

   private static void flh(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void fli(MinecraftClient var0, String var1) {
      System.out.println(a.b("ꄣ\ud884剞찥䞴셑笓\uf2f4沬\ue649", 1112318298) + var1 + a.c(1259479249, "\u20f2夣펐") + var0.method_47599() + a.b("ꮀ퉷墲움", -1293243484));
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.c(-805849911, "뒩촒䟂\ud9ab刹풗") + var1 + a.c(-1084692205, "\ue939郖ᨛ董"),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
