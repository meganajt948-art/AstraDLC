package a;

import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import net.minecraft.client.MinecraftClient;

public final class hzv {
   public static final List<hzq> ALL = List.of(
      new hzq(a.b("\ude50ꟼⴾ", 1503977019), a.d("鲥\ue52f濻\uf192稒ﳋ䚅콥", 2138001309, 432853859), () -> hzz(a.b("뢋섧䯥", 2119547072), izx.ENABLED)),
      new hzq(a.c(1349440162, "틜ꭻ↰뿈㐀늷ࣣ脈ὐ"), a.c(-288575655, "꼄횎屚숳䦳콕甐ﳹ抯\ue801濔関᭯苙"), () -> hzz(wap.t(a.b("峷╰꾻㇃먋㲼蛨༃酛", 1916558505)), wlk.ENABLED)),
      new hzq(a.c(-501256206, "澈ᘯ鳤ʜ襔\u0fe3떷㱜ꉙ⢮꽰唖\udbd6"), a.b("ﾸ蘿\u0cf4銌᥄鿳▧걌㉇뢾㽠씆䯆", -457703454), hzv::hzy),
      new hzq(a.c(2058614031, "\uf570賝\u0603顺Ꭵ镟⽎ꚺ㣫뉕㖚"), a.d("쏅멑れ껲┹ꏜᦀ遾\u0e65蓑̑凉知\uee00摏\ue2b3壴휭", -262292331, 1739947790), () -> {
         iov.toggleLight();
         iaa(wap.t(a.c(-792170135, "焸ࢵ艫ᰒ韍")) + a.b("\uf194蠥", -1447431754) + iov.shownName(iov.presetName()));
      }),
      new hzq(a.d("糅ը辶ᇏ騐ᳪ\ua6f9⼃녁㯼", -2116819124, -1515217929), a.d("赩\uf4f3總\ue040毃\ued26坩\ude95䃂쩻", 721512737, -1570184180), () -> {
         iov.cycle(1);
         iaa(wap.t(a.d("㴵䒸칦借\udbc0", -438028705, -1870460101)) + a.b("幗⟦", -1620091275) + iov.shownName(iov.presetName()));
      }),
      new hzq(
         a.b("彇⛠갾㉏름㼤蕦ಂ鋊ᠧ龴旎\ueb04犹", 998268734),
         a.d("作㛆밈≵꧶⼐镕Ჩ苶࡛辙痹כּ抝", -1863417340, 1778896152),
         () -> iaa(wap.t(a.b("㵤䓣츽偌\udb87崧\ue765溁\uf0c9", 551632186)) + a.d("\ue7ee鹟", -473336638, -617049330) + isv.next())
      ),
      new hzq(
         a.d("䛸㽑떄⯯ꀲ⛎鳇ᔭ譺ǋ蘓籫", -1417798605, -575186262),
         a.c(1312762163, "⥱僼\uda22䑋쿅䥻\uf327窆\ue4c8湭\ue9b8Ꮯ鵍ұ軺ࠍ뉘㶃"),
         () -> jgn.command(a.d("ﰄ薮ཱུ鄄\u1ad8鱠", 2004529605, -301445709))
      ),
      new hzq(a.b("ࣀ煩﮼旗\uee0a棶틥嬟앝俠", -253622105), a.d("畖ೌ蘂\u187f鏼ᔙ꽌⚮룳㉊", -1700900214, -1128126568), () -> jgn.command(a.c(402363329, "鎫\uea11惟ﺢ"))),
      new hzq(a.d("\ued40铥ḭ聐\u0b8c贷", 659191548, 370318300), a.c(38960229, "簷֣轰ᅅ骝ᰣ꘢⿄놓㬠볪䚈젚凭\udbaa嵀\ue703棙\uf260"), vzz.mouse(2), hhf::toggleAimed),
      new hzq(a.d("骬\ue30c槌\uf7bb籡慎䂗쥪圦\udd8e", -1785227844, -555348118), a.b("糢բ辢ᇕ騏᳧\ua6f9⼄녈㯠", 1710455992), vzz.mouse(3), ucg::markKey)
   );

   static hzq friendKey() {
      for (hzq var1 : ALL) {
         if (var1.id.equals(a.c(-1875024147, "暍Ἠ闠\u0b9d聁ۺ"))) {
            return var1;
         }
      }

      throw new IllegalStateException(a.b("\ue0f8饈Ꮤ跣ؠ肊㫕댯\u2d7aꞏ—\uda62咮촀䝝솰", 1096278150));
   }

   static hzq partyMarkKey() {
      for (hzq var1 : ALL) {
         if (var1.id.equals(a.b("\u0000禠\uf360洗\ue6cd怫\uda3b叆춊䜢", -22085510))) {
            return var1;
         }
      }

      throw new IllegalStateException(a.d("嗍ⱽꛡ㣀댆㖤迱؍頋ዷ锨潊\ue184硾\uf265璓컇䄉\udbb4巹", -1231193829, -1296814932));
   }

   private hzv() {
   }

   public static void run(int var0) {
      for (hzq var2 : ALL) {
         if (var2.key == var0) {
            try {
               var2.hzr.run();
            } catch (RuntimeException var4) {
               System.out.println(a.c(-1410827792, "禟)諡ᒏ齖᧻ꏱ") + var2.name + a.b("練Ѓ軗Ⴎ魼᷄Ꞗ⸹끼", -2019328547) + var4);
            }
         }
      }
   }

   static List<String> boundTo(int var0, String var1) {
      ArrayList var2 = new ArrayList();
      if (var0 == -1) {
         return var2;
      }

      for (kfe var4 : Flow.getInstance().getModuleManager().getModules()) {
         if (var4.getKey() == var0 && !var4.getName().equals(var1) && !var4.getDisplayName().equals(var1)) {
            var2.add(var4.getDisplayName());
         }

         for (vmo var6 : var4.getSettings()) {
            if (var6 instanceof vlq var7 && var7.get() == var0 && !var7.getName().equals(var1)) {
               var2.add(var4.getDisplayName() + a.d("ᦔ", -1304769950, -1483615273) + wap.t(var7.getName()));
            }
         }
      }

      for (hzq var9 : ALL) {
         if (var9.key == var0 && !var9.name.equals(var1)) {
            var2.add(wap.t(var9.name));
         }
      }

      return var2;
   }

   private static void hzy() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      if (var0.player != null && var0.world != null) {
         int var1 = wlk.inWorld().size();
         String var2 = wap.s(a.d("嶖␑껚ア뭪㷝螉\u0e62適", -1021880999, -672069487), a.c(-1194970411, "㛏佗엳寺퀧劆")) + (var1 + 1);
         wlk.add(var2, var0.player.getBlockX(), var0.player.getBlockY(), var0.player.getBlockZ(), wlk.COLORS[var1 % wlk.COLORS.length]);
         iaa(
            wap.s(a.d("뤇삓䩀퐰忦\ud913", -1115218932, -1284397748), a.b("㙀俛씇孷킢嘚\uec47斾ﯬ畍", -1412222370))
               + var2
               + a.b("\u0feb癚", -1506013239)
               + var0.player.getBlockX()
               + a.d("했", 1863008517, 1501009068)
               + var0.player.getBlockY()
               + a.d("深", 121919909, -471976843)
               + var0.player.getBlockZ()
         );
      }
   }

   private static void hzz(String var0, vkl var1) {
      var1.toggle();
      iaa(var0 + a.c(1606273036, "젮놟") + wap.value(var1.get() ? a.c(-1163236512, "欭ኽ") : a.d("뽓웋䰘", 1393738908, -1984201853)).toLowerCase(Locale.ROOT));
   }

   private static void iaa(String var0) {
      izx.notify(a.c(-2141799571, "묯슴䡤혍"), var0);
   }

   static void load(Properties var0) {
      for (hzq var2 : ALL) {
         try {
            var2.key = Integer.parseInt(var0.getProperty(a.b("氼ᖊ齂Ĭ諵ౘ뙜", -151753645) + var2.id, String.valueOf(var2.hzs)).trim());
         } catch (NumberFormatException var4) {
            var2.key = var2.hzs;
         }
      }
   }

   static void save(Properties var0) {
      for (hzq var2 : ALL) {
         var0.setProperty(a.c(-1842833971, "関\uec14曜\uf8b2獫\uf5c6係") + var2.id, String.valueOf(var2.key));
      }
   }
}
