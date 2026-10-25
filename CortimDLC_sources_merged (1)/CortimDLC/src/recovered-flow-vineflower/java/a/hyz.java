package a;

import flow.Flow;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

public final class hyz {
   private static final String hza = a.d("⢻儘\udbd7䗡칫䣊\uf288筤\ue538澉\ue818", -958074736, 2118965319);
   private static final String hzb = a.b("멌쎴䥭휟峐\uda39怡\ue9d1瞍ﴻ竼肔๛鞳ᶪ魉ℚ꺌㑡눲㯘䆖켰哶튏塃\ue1fc澻", -1462453633);
   private static final int hzc = 4;
   private static final int hzd = 1;
   private static final int hze = 1;
   private static final int hzf = 1;

   private hyz() {
   }

   static Path gameDir() {
      return ConfigManager.gameDir();
   }

   private static List<Object[]> hzi() {
      ArrayList var0 = new ArrayList();

      for (vmo var2 : iov.ALL) {
         var0.add(new Object[]{a.b("䔥㲈뙖⠯ꏰ┊", -971946665) + var2.getName(), var2});
      }

      for (vmo var10 : hyv.ALL) {
         var0.add(new Object[]{a.d("굅퓿帡쁂䮕쵹", -1960490982, -2094078658) + var10.getName(), var10});
      }

      for (vmo var11 : wlk.ALL) {
         var0.add(new Object[]{a.c(1059159555, "繾ߙ贒፪颢ḕꑁⶪ돲㤞") + var11.getName(), var11});
      }

      for (vmo var12 : hhf.ALL) {
         var0.add(new Object[]{a.d("䍨㫍뀅\u2e78ꖤ⌟饛ჷ", -2115709623, 1374721615) + var12.getName(), var12});
      }

      for (vmo var13 : ucg.ALL) {
         var0.add(new Object[]{a.b("㡷䇗쬗啠\udeba塜", -480495615) + var13.getName(), var13});
      }

      for (vmo var14 : Cosmetics.ALL) {
         var0.add(new Object[]{a.b("琮ඓ蝜ᤳ鋬ᑌ긂⟹릶㍚", -150178745) + var14.getName(), var14});
      }

      for (vmo var15 : kbm.ALL) {
         var0.add(new Object[]{a.b("\ue66f鿖ᔎ譤è蘛㱋떺⯡ꄕ", 797369864) + var15.getName(), var15});
      }

      var0.add(new Object[]{a.c(974428212, "顎\ue1e9欷\uf546纍\uf82d䉯쮋嗃\udf2e墵ꋋⰁ"), isv.FIT});
      var0.add(new Object[]{a.c(1321085846, "⯱剖\ud888䛹촲䮒\uf1d0破\ue67c沑\ueb08ᅼ龸ؐ豍ષ"), isv.DARKEN});
      var0.add(new Object[]{a.d("ꦛ퀼嫢쒓佘째玺艹搖\ueefb楫錘ᷔ葸อ裝", -191903814, 581267014), isv.MOTION});
      var0.add(new Object[]{a.d("鑋\uedec朲弄犈\uf428乪잎姆팫咦껆 릵㏻딀ཀ肘ᨽ", 450299864, 1928106999), isv.PARTICLES});
      var0.add(new Object[]{a.b("쳮땓㾁ꇸ⨠겟ᚅ鼻Ű诀ఈ\uf665碠\ue106歆", -878588798), ConfigManager.AUTO_SAVE});
      var0.add(new Object[]{a.c(836122142, "㙯俒씀孹킡嘞\uec04斷ﯫ煔\uf682\u0cf8舮ᮂ釖ᜲ굮⊹"), ConfigManager.LOAD_ON_START});

      for (Entry var16 : izx.persisted().entrySet()) {
         var0.add(new Object[]{var16.getKey(), var16.getValue()});
      }

      return var0;
   }

   public static void load() {
      String var0 = ewk.get(a.c(-2030287407, "䖵㰖뛙"));
      boolean var1 = var0 == null || var0.isBlank();
      Properties var2 = new Properties();

      try {
         label153: {
            try (Object var3 = var1
                  ? hyz.class.getResourceAsStream(a.d("烆ा菧ᶕ陚Ⴓꪫ⍛봇㞱끶䨞쓑崹휠凃\ueb90搆ﻫ碸\uf152謜ֺ鹼᠅鋉⭶ꔱ", -1790576267, 1112377728))
                  : new ByteArrayInputStream(var0.getBytes(StandardCharsets.ISO_8859_1))) {
               if (var3 != null) {
                  var2.load((InputStream)var3);
                  break label153;
               }
            }

            return;
         }
      } catch (Exception var17) {
         System.out.println(a.c(-927025624, "뙑쿢䔾\udb06傂홧汦\ue580篛\uf16f相賄ț鮡ᇩ靍ⵑꊖ㠴빥㞏䷙썣墦\ude90呛") + var17);
         return;
      }

      for (Object[] var4 : hzi()) {
         String var5 = var2.getProperty((String)var4[0]);
         if (var5 != null) {
            try {
               vmo var6 = (vmo)var4[1];
               if (var6 instanceof vkl var7) {
                  var7.set(Boolean.parseBoolean(var5));
               } else if (var6 instanceof vmc var8) {
                  var8.set(Double.parseDouble(var5));
               } else if (var6 instanceof vlv var9) {
                  var9.set(var5);
               }
            } catch (RuntimeException var15) {
            }
         }
      }

      int var19;
      try {
         var19 = Integer.parseInt(var2.getProperty(a.c(1810183108, "㎦䨖샓庸핡叙"), a.b("ꕴ", 1397925189)).trim());
      } catch (NumberFormatException var14) {
         var19 = 0;
      }

      String var20 = var2.getProperty(a.c(1138738276, "쐚붽㝣ꤒ⋙ꑹḻ韟গ"));
      if (var20 != null) {
         isv.select(var20);
      }

      if (var19 < 4) {
         iov.resetLook();
         hyv.ENABLED.reset();
         izx.BACKGROUND.reset();
         isv.select(a.d("\ue34b髢ာ蹃֜", -680255380, 2134098773));
      }

      if (!String.valueOf(1).equals(var2.getProperty(a.d("ꗋ\udc6c嚲죃䌈얨翪\uf60e框\ue2d7攳齑", 818388974, -1271186850)))) {
         isv.select(a.d("᤺悔\uea4a琺\uffe7礃쌌䫷풫市\ud98b⎳굡㓃뺉", 77651275, 1295238152));
      }

      if (!String.valueOf(1).equals(var2.getProperty(a.c(-150025691, "쩟돳㤺Ꝑⲍꨊၮ馌")))) {
         iov.ROUNDNESS.reset();
      }

      iov.loadColors(var2);
      izx.load(var2);
      hzv.load(var2);
      wap.load(var2.getProperty(a.b("辮\uf612糎\ue2b6楳\uefd6喃\udc70", 139890634)));
      kbs.load(var2.getProperty(a.d("᎔樭\ue0f5纟\uf513珮즾䁍\ude1a咧퍡⤍Ꟁ㹪됳", 1949172507, 571805933)));
      if (!String.valueOf(1).equals(var2.getProperty(a.c(638471757, "丬㞗뵇⌮\ua8dc⹚鐚")))) {
         iov.choose(a.d("誒\uf309秙\ue7b0氰\ueae3傞\ud962䜿춆", 33375682, 2096156444));
         kbs.select(kbs.DEFAULT);
      }

      whl.warm(kbs.selected().key, isv.selected());
      hia.select(var2.getProperty(a.c(-838486858, "듑쵷䞳\ud9d7刕풷")));
      hia.seenOwn(var2.getProperty(a.d("衅\uf1e3笧\ue543溁\ue823刬\udb9c䗛콳", -1473135370, -1760676648)));
      Cosmetics.load(var2);
      String var21 = var2.getProperty(a.b("ᖿ氂\ue6d0碩\uf371痎쿔䙪\ud837劑핟⼱ꇵ", -1194125871));
      if (var21 != null && ConfigManager.exists(var21)) {
         ConfigManager.setActive(var21);
      }

      try {
         int var22 = Integer.parseInt(var2.getProperty(a.d("♉忰픨䭂삫䘴ﱻ", -1140560141, -685094704), ""));
         if (var22 > 0) {
            Flow.getInstance().setOpenGuiKey(var22);
         }
      } catch (NumberFormatException var13) {
      }

      String var23 = var2.getProperty(a.d("씍벮㙡ꡗ⏚ꕾἮ", -1709446922, 57683355));
      if (var23 != null) {
         hlc.setTabKey(var23);
      }

      for (String var26 : var2.stringPropertyNames()) {
         if (var26.startsWith(a.d("ᄀ梣\ue26c籚\uf7d0煱쬳䋟\udc83嘲톣", 1607151036, -354665264))) {
            try {
               hlc.scrolls().put(var26.substring(a.c(956124704, "乌㟯봠⌖ꢜ⸽鑿ᶓ菏ॾ軯").length()), Float.parseFloat(var2.getProperty(var26)));
            } catch (NumberFormatException var12) {
            }
         }
      }

      try {
         float var25 = Float.parseFloat(var2.getProperty(a.c(-772639102, "盠གྷ薌ᮺ逻"), a.b("켯뚱㱍", -2071867550)));
         float var27 = Float.parseFloat(var2.getProperty(a.b("፸櫛\ue014縢\uf5a2", 224006938), a.b("浝ᓃ鸿", -267031280)));
         hlc.setWindowPos(var25, var27);
      } catch (NumberFormatException var11) {
      }
   }

   public static void save() {
      if (!dry.armed()) {
         hzk(hzj());
      }
   }

   public static void saveLater() {
      if (!dry.armed()) {
         Properties var0 = hzj();
         vza.later(a.b("䛉㽰떨⯂ꁀ⚢鳧ᔇ識Ǵ蘠籘\uf29b", 796739241), () -> hzk(var0));
      }
   }

   private static Properties hzj() {
      Properties var0 = new Properties();

      for (Object[] var2 : hzi()) {
         vmo var3 = (vmo)var2[1];
         String var4;
         if (var3 instanceof vkl var6) {
            var4 = String.valueOf(var6.get());
         } else if (var3 instanceof vmc var7) {
            var4 = String.valueOf(var7.get());
         } else {
            if (!(var3 instanceof vlv var5)) {
               continue;
            }

            var4 = var5.get();
         }

         var0.setProperty((String)var2[0], var4);
      }

      var0.setProperty(a.c(-1891167040, "ᒢ洒\ue7d7禼\uf265瓝"), String.valueOf(4));
      var0.setProperty(a.c(1649862408, "\ue776黑ᐏ詾Ƶ蜕㵗뒳⫻"), isv.selected());
      var0.setProperty(a.d("樺\u139d饃ܲ賹ਖ਼뀛㧿ꞷ\u2d26ꫂ傠", 898543414, -304298633), String.valueOf(1));
      var0.setProperty(a.b("⺻圀\uddd0䎹졋仍\uf48d", 289156826), String.valueOf(1));
      var0.setProperty(a.d("腋\uf8e7爮\uec44枙\ue11e孺튘", 495926758, -1786463017), String.valueOf(1));
      iov.saveColors(var0);
      izx.save(var0);
      hzv.save(var0);
      if (wap.chosen()) {
         var0.setProperty(a.d("┝岡홽䠅쏀䕥Ｐ盃", 478029325, 1712915316), wap.code());
      }

      var0.setProperty(a.c(377766346, "䆭㠋닏ⲫꝩ⇋"), hia.selected());
      var0.setProperty(a.c(-383488861, "泈ᕮ龪ǎ訌ಮ뚡㼑ꅖ⯾"), hia.seenOwn());
      Cosmetics.save(var0);
      var0.setProperty(a.b("臞\uf867犿\uecd5杙\ue1a4寴툇䱐웭䄫뭇㖊갠♹", -1065451076), kbs.selected().key);
      var0.setProperty(a.b("\uabef퉖墎웤䴍쮒燝", -1710904443), String.valueOf(Flow.getInstance().getOpenGuiKey()));
      if (ConfigManager.active() != null) {
         var0.setProperty(a.d("诺\uf247碕\ue6ec洴\ueb8b冑\ud82f䙲쳔䬚녴㾰", 337429835, -194097441), ConfigManager.active());
      }

      if (hlc.tabKey() != null) {
         var0.setProperty(a.d("ࡲ燑ﬞ攨\ueea5栁퉑", -187041966, -1365573824), hlc.tabKey());
      }

      for (Entry var9 : hlc.scrolls().entrySet()) {
         var0.setProperty(a.b("䏛㩸낷⺁ꔋ⎪駨င蹘ө荸", -698989641) + (String)var9.getKey(), String.valueOf(var9.getValue()));
      }

      if (!Float.isNaN(hlc.windowX())) {
         var0.setProperty(a.d("력솆䭉핿廾", -345268276, 441984907), String.valueOf(hlc.windowX()));
         var0.setProperty(a.c(918637187, "䫡㍂릍➻갻"), String.valueOf(hlc.windowY()));
      }

      return var0;
   }

   private static void hzk(Properties var0) {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         var0.store(
            var1,
            a.d("\udf44ꛟⰏ뉦㧴뽗Չ貰ዤ顎Ὲ\ue5b1欢\uf290磃︶䐾쯣儓흎庸ⓡ꩝ㆂ랺㴤蒈\u0add逷ᙠ鷒挞\ue90e烳\uf6f7籐쎟䧧켫嚜\udcc4ꈯ⠨꿝㔇뭬ʼ蠑๓閚ᮼ\ue161梚\ueec6琧况䆚윛䵷풺娗⁛ꞵⷢ댬㫚", -915220363, -635500747)
         );
         ewk.put(a.c(-735331213, "밗어佻"), var1.toString(StandardCharsets.ISO_8859_1));
      } catch (Exception var2) {
         System.out.println(a.b("\uf694輧\u05fb鯃၇隢Ⲣꕁ㬉놫㘽찁䋞\udb64儬히涔\ue253磱ﺠ睊ജ莦ᡣ鹕ᒞ", 1133115117) + var2);
      }
   }
}
