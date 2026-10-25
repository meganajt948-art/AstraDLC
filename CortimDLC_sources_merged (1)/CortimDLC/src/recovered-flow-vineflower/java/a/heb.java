package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;

final class heb {
   private static final String[] hec = new String[]{
      a.b("ﭤ苯ࠧ陑ᶑ鬢ⅴꢞ㛄", -939066578),
      a.b("\uede2鑦Ầ胆ଉ趹㟷븗", 1918037421),
      a.b("텲ꣲ∺뱏㞆넫\u0b79", -2077634250),
      a.b("൞瓇\ufe1c恺\uebbe洂흙", 745147676),
      a.c(-1839367964, "碮ĳ详ᖓ鹋"),
      a.d("懃ᡆ銈\u0ce5蜵", -1608849160, -655455880),
      a.c(-480886768, "䁂㧌댞\u2d72ꚴ")
   };
   private static final String[] hed = new String[]{
      a.b("褢\uf09b穌", 2198801),
      a.d("뇚졧䊰", 880101766, -907871205),
      a.c(210480402, "ꤥ탦婍쐷俢쥑"),
      a.b("ᒷ洏\ue7d0秙", 794955919),
      a.d("혍꾾┝묐", -207522360, 1905108977),
      a.c(-2088760150, "࢜煙ﯴ"),
      a.c(-2070144800, "ᢆ愡\uebf1"),
      a.c(1583004346, "뺉윽䶟펗"),
      a.c(-411916651, "ꊧ\udb13冱쾹䑬"),
      a.b("剙⯢ꄤ", -1483517380),
      a.c(2088467662, "粮"),
      a.b("ꆊ\ud839", 1642177970),
      a.d("誗\uf352禆\ue780", -701569400, 604006493),
      a.b("䒇㵁랛⧦", 268714177),
      a.d("澣ᘝ鳍ʰ襭࿒떋", -1132606835, 1292476695),
      a.c(-628079578, "䑗㷽뜵⥕ꊊ"),
      a.b("ꈘ\udbd5兺콼䒢", -1028282785),
      a.c(292867745, "쪘댪㦀ꟺ"),
      a.b("\ud816ꆤ\u2b75딟㻏롤", 1203099747),
      a.b("ᶖ摙\ueef5烼אַ締", 1599019473),
      a.d("诽\uf251碓", -520010442, 539283104),
      a.d("\uea25鎒ᤶ", -100435229, -101346176),
      a.c(-938264574, "㰰䗵켥儠\uda8c尾"),
      a.b("춿둱㺩ꂥ⭺귏", -569063034),
      a.d("븴잗䵀팤壯\ude53搗", 904556202, -1059794706),
      a.d("\uef9d限\u1c8b苼", -1417314016, -146707720),
      a.b("\ufdc9葺໗邯ᬏ鷇", -913966706),
      a.c(-1767390145, "쑙뷣㜽\ua95a⊊"),
      a.b("⧝偢\udaa8䓞", 203958715),
      a.d("並菇झ靥Ფ騒⁜ꦥ㟷", -765110387, -1591038569),
      a.c(-1119767893, "뛬콞䗺\udb84偒훦"),
      a.b("哗\u2d6dꞳ㧐눇", 1248744629),
      a.d("ﷳ葀\u0ee3郮ἧ鶇➦긯ほ뫈㴙", 2091562247, 2117881039),
      a.d("\u0a52玑鷺杀\uec95樦푥妄쟙䴘쪷", -1386540558, -174448742),
      a.b("錾\ueaf6怯︡疊\uf349", 1775277834),
      a.b("B秷\uf35c洯\ue6f2恏", -499448832),
      a.d("砩ƌ譈ᔹ麫ᡙꈈ⯵", -2101182347, 1492121650),
      a.b("鄽\ue899扊ﰹ", -1891135165),
      a.b("㟯个쒆", 1262564315),
      a.d("혐꾠╰묃", 185538655, 908511857),
      a.c(-1244882043, "龰\ue608泞\uf2a6"),
      a.d("䀌㦵덡\u2d6eꛂ\u2072", -66853711, 462266608)
   };
   private static String hee;

   private heb() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      if (var1 == 1) {
         hek(var0, a.d("쩮돂㤕Ꝭ⳾ꨜၙ馹\u07b2贕ી\uf0b1繦", -921631153, 279563352));
         hee = iov.PRESET.get();
         hej(var0, a.d("禖\u001b諅ᒼ齣", -501449164, 1740769267));
      }

      byte var2 = 24;
      byte var3 = 30;

      for (int var4 = 0; var4 < hec.length; var4++) {
         if (var1 == var3 + var4 * var2) {
            iov.PRESET.set(hec[var4]);
         }

         if (var1 == var3 + var4 * var2 + var2 - 2) {
            hel(var0, a.c(-892032214, "ꭙ틴堪왓䶌쬫焦") + hec[var4].toLowerCase(Locale.ROOT).replace(' ', '-'));
         }
      }

      int var5 = var3 + hec.length * var2;
      if (var1 == var5) {
         iov.PRESET.set(a.b("͊竊\uf002湷\ue5be挓\ud941", 101450510));
         hej(var0, a.b("焄࢙艈ᰶ韢ᅆ", -1452969663));
      }

      if (var1 == var5 + 24) {
         hel(var0, a.d("쨰뎝㥃Ꜻ⳥ꩂ၏駰\u07be贔ૃ\uf0ac繧\ue7d7淇\ueb78儻\udee8䑔숆䯤", -2034779261, 1176990162));
         var0.setScreen(null);
      }

      if (var1 == var5 + 50) {
         hel(var0, a.c(-1045055429, "록쇰䬮핗庈\ud82f戢\ueb9d痓ｹ碮苁ఊ閺ᾪ餞⍌게"));
         iov.PRESET.set(a.b("㮪䈳죨嚎\udd4a寶\ue1ad", -1303233560));
      }

      if (var1 == var5 + 76) {
         hel(var0, a.c(2000554611, "ਕ玸復期\uecc0橧큪姓임䴽쫹゛빁⟸귢⭖鄄Ễ"));
         iov.PRESET.set(a.c(1483371279, "獌ૉ耇Ṫ閺"));
      }

      if (var1 == var5 + 102) {
         hel(var0, a.d("⋽子톎俷쐨䊏\uf882焸\uef73旟\ue210ᡦ雨༜蕒β", -2016978591, 282688504));
         hej(var0, a.b("ᄝ梀\ue251簯\uf7fb煟", 1537872216));
      }

      if (var1 == var5 + 110) {
         iov.PRESET.set(a.c(1013557707, "ꦏ퀏嫇쒲佻짖玄"));
         heh(var0);
      }

      if (var1 == var5 + 134) {
         hel(var0, a.d("琈ඥ蝻ᤂ鋝ᑺ깷⟘릑㌤들亄쁘妬펺商\uef05惚辶簫", -2012478648, -257198304));
         hei(var0);
      }

      if (var1 == var5 + 150) {
         hel(var0, a.c(-1063172167, "䟘㹵뒫⫒ꄍ➪鶧ᐈ詁ô蜴絔\uf388橼\ue061暟\udcd9匌즬俪옜"));
         iov.PRESET.set(hee);
         var0.setScreen(null);
      }

      return var1 >= var5 + 154;
   }

   private static void heh(MinecraftClient var0) throws Exception {
      if (!(var0.currentScreen instanceof hlc var1)) {
         System.out.println(a.b("둋췬䜻\ud959功퐥渾\ue79b秕\uf372璦躙T馫ᏹ镇⽅ꂜ㨤뱮", -1087523796));
      } else {
         Method var15 = hlc.class.getDeclaredMethod(a.b("ꋅ\udb62冠쿶䐗슢磢\uf102潖", 264282815), String.class);
         var15.setAccessible(true);
         Field var3 = hlc.class.getDeclaredField(a.c(-1496376009, "ᵆ擨\uee21灊ﮖ紩읳"));
         var3.setAccessible(true);

         for (String var7 : hed) {
            var15.invoke(var1, var7);
            ArrayList var8 = new ArrayList();

            for (Object var10 : (List)var3.get(var1)) {
               Field var11 = var10.getClass().getDeclaredField(a.d("逫\ue987捉ﴠ盾", 1923380511, 1096607045));
               var11.setAccessible(true);
               Method var12 = var10.getClass().getDeclaredMethod(a.c(-1779915702, "ꐨ\udd83坠줽䋩쑘縆\uf7e6榺\ue31d擏"));
               var12.setAccessible(true);
               Field var13 = var10.getClass().getDeclaredField(a.d("\ueb1f銳ᡸ蘍", -157676220, -1388714451));
               var13.setAccessible(true);
               boolean var14 = !(Boolean)var12.invoke(var10) && !((List)var13.get(var10)).isEmpty();
               var8.add(var11.get(var10) + (var14 ? a.c(-1908481402, "\ue2a1鬘ᆌ迢Р芚㢎") : ""));
            }

            System.out
               .println(
                  a.d("愾ᢙ鉎బ蟪Ő뭋㊽", 2056485920, 1008737637)
                     + var7
                     + a.b("殐ሦ飸ښ赓", -516199502)
                     + var8.size()
                     + a.c(2002630231, "뙯쿄")
                     + String.join(a.c(-396098735, "Ϳ竂"), var8)
               );
         }

         var15.invoke(var1, a.b("휪껢\u243b먵㆞띝", -1775578338));
      }
   }

   private static void hei(MinecraftClient var0) throws Exception {
      if (var0.currentScreen instanceof hlc var1) {
         Method var3 = hlc.class.getDeclaredMethod(a.d("곇할徢쇴䨕철盠\uff00慔", -2031593148, -955124231), String.class);
         var3.setAccessible(true);
         var3.invoke(var1, "");
      }
   }

   private static void hej(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.b("퓮굊➚맂㈻뒖", 903861404));
      var2.setAccessible(true);
      var2.set(null, var1);

      for (String var6 : new String[]{a.b("㬤䊋졟嘤\uddf8孑\ue12d", 1386756948), a.b("\udf21Ꚏⱚ눡㧽뽔ԩ", -1384849583)}) {
         Field var7 = hlc.class.getDeclaredField(var6);
         var7.setAccessible(true);
         var7.setFloat(null, Float.NaN);
      }

      Field var8 = hlc.class.getDeclaredField(a.b("䕕㳴똶⡚ꎎ┿齳", 1361921281));
      var8.setAccessible(true);
      ((Map)var8.get(null)).clear();
      var0.setScreen(new hlc());
   }

   private static void hek(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   private static void hel(MinecraftClient var0, String var1) {
      System.out.println(a.b("뫒썵䦯ퟔ居\udaa0惢\ue905睝ﶸ", -414729557) + var1 + a.c(787828274, "丑㟀뵳") + var0.getCurrentFps() + a.c(-1513143353, "䏣㨔냑⺣"));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.b("꾰혋峛슲䤠쾎", -1970556976) + var1 + a.c(-1948281975, "鎣\uea4c悁ﻹ"),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
