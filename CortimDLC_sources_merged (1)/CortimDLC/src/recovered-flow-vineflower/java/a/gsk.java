package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;

public final class gsk {
   public static final boolean ON = Boolean.getBoolean(a.b("﴾蒅๕逼ᮮ鴃✎껽タ먇", -4784814));
   public static boolean variant;
   static final Map<String, long[]> gsl = new LinkedHashMap<>();
   static long gsm;

   gsk() {
   }

   public static void add(String var0, long var1) {
      gsl.computeIfAbsent(var0, var0x -> new long[1])[0] += var1;
   }

   public static void frame() {
      gsm++;
   }

   public static HudElement wrap(String var0, HudElement var1) {
      return !ON ? var1 : (var2, var3) -> {
         long var4 = System.nanoTime();
         var1.render(var2, var3);
         add(a.c(-1578954354, "ᇢ桎\ue28c粹") + var0, System.nanoTime() - var4);
      };
   }

   public static void reset() {
      gsl.clear();
      gsm = 0L;
   }

   public static void report(String var0) {
      if (ON) {
         ArrayList<Map.Entry<String, long[]>> var1 = new ArrayList<>(gsl.entrySet());
         var1.sort((var0x, var1x) -> Long.compare(((long[])var1x.getValue())[0], ((long[])var0x.getValue())[0]));
         long var2 = Math.max(1L, gsm);
         double var4 = 0.0;
         StringBuilder var6 = new StringBuilder(
            a.b("鈘\uebab慥＝璌", -1508208019) + var0 + a.b("턖ꢯ", 1367396660) + gsm + a.d("徜♫견㋎뤕㾬藩ే鈔ᣰ鼥攈\ueb96爳\uf873纎쓉䭔퇴", 1109548860, 809959571)
         );

         for (Map.Entry<String, long[]> var8 : var1) {
            double var9 = ((long[])var8.getValue())[0] / 1000.0 / var2;
            var4 += var9;
            if (var9 >= 1.0) {
               var6.append(String.format(Locale.ROOT, a.d("र烊練搦\ueff1楀팖嫺쒳丝즙㎮뵹Ⓧ껈", 644798038, 55500620), var9, var8.getKey()));
            }
         }

         var6.append(String.format(Locale.ROOT, a.c(1241336930, "䱕㖯뼲⅃ꪔⰥ陳ᾟ臖\u0b78購盋\uf81c懹\uebb1浛휁壝"), var4));
         System.out.println(var6);
      }
   }
}
