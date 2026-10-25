package a;

import flow.dev.a;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public final class pnr {
   private static final Pattern pns = Pattern.compile(a.c(-782830220, "\uf554賵ٸ順Ꮳ镽⽷Ꚅ㢯눦㖺쿉䅫\ud8f5勿"), 2);
   private static final int pnt = 20;
   private static String pnu;
   private static String pnv;
   private static int pnw;

   private pnr() {
   }

   public static String anarchy(String var0) {
      if (var0 == null) {
         return null;
      }

      Matcher var1 = pns.matcher(var0.trim());
      return var1.matches() ? var1.group(1) : null;
   }

   public static boolean allow(String var0) {
      String var1 = anarchy(var0);
      if (var1 == null || ejp.isActive() || dry.armed()) {
         return true;
      } else if (pjd.enter(pjd.MAIN, var1)) {
         pnu = null;
         return true;
      } else {
         String var2 = var0.trim().toLowerCase(Locale.ROOT);
         if (var2.equals(pnu)) {
            pjd.cancel(pjd.MAIN);
            pnu = null;
            izx.notify(
               a.c(1152969418, "\ueed3霻ᶚ莞࠼躌㒧"),
               a.d("瞀\u0e68蓉ᫍ酯\u17df귴\u2069먫\u3097더䥤잼", 1636529083, -891682776) + var1 + a.d("ꖾ\ud811劾첱䝯쇖箍\uf274氦", 1585140585, 1423701758)
            );
            return false;
         } else {
            pnu = var2;
            pnv = var1;
            pnw = 0;
            izx.notify(
               a.b("㝑亹쐘娜톾圎\ued25", -1360121016),
               a.c(1415886245, "놽젡䛢\ud8d2匊")
                  + var1
                  + a.c(-870811422, "磇ԕ辳ᇁ鸃")
                  + 3
                  + a.d("⦤合\uded6䃟쭸䶴\uf382婇\ue42c檋\ued5a\u175c鷨E訟ಚ뛖㥵Ꟗ\u218f", -724402854, -826256182)
                  + pjd.position(pjd.MAIN)
                  + a.c(-361788714, "諟\uf77a禹\ue7cf氖\uee98哪\udd17䌸짵乘둑㺞ꌵ⥢꾑ᗒ騎´蚒ଊ煗ﮃ恗\ue654沊핃役손䞽챰㊨룯ℛꜲⶍ")
            );
            return false;
         }
      }
   }

   public static void tick(MinecraftClient var0) {
      ClientPlayNetworkHandler var1 = var0.getNetworkHandler();
      if (var1 != null && var0.player != null && !var0.isInSingleplayer()) {
         pjd.keep(pjd.MAIN);
         if (pnu != null && !dry.armed() && ++pnw % 20 == 0) {
            if (pjd.enter(pjd.MAIN, pnv)) {
               String var2 = pnu;
               pnu = null;
               izx.notify(
                  a.c(-918229594, "\ue9bf遗\u1af6蓲ཐ觠㏋"),
                  a.c(-1993731768, "ᕟ泇\ue660砒\uf3b9焖콘䚤\udceb嘛퇇")
                     + pnv
                     + a.d("诎\uf661糍\ue2cf椔\uefaa嗶\udc0d䉞죬伺딴㯮\ua633\u0c54ꪑᓁ鬚ǜ蟸\u0e7f瑕\ufaee慊", -1130124162, 704849800)
               );
               var1.sendChatCommand(var2.startsWith(a.d("쌳", -1469336528, -1251444947)) ? var2.substring(1) : var2);
            }
         }
      } else {
         if (var1 == null) {
            pjd.leave(pjd.MAIN);
         }

         pnu = null;
      }
   }
}
