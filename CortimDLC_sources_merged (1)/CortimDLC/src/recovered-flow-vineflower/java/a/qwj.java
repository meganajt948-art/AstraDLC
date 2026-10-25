package a;

import flow.dev.a;
import java.util.Locale;

public enum qwj {
   COMMON(a.b("⚭弳햚䯧쁊䛶ﳚ", 309863092), 1),
   MYTHIC(a.b("粕Ԁ辯ᆢ騊\u1cc9ꛮ⽤넱㯿", -848398205), 2),
   LEGENDARY(a.b("獶૩耼ṋ閔ጬꥻ\u20fa뻘㑤돈", -291997850), 3);

   private final String qwk;
   private final int qwl;

   qwj(String var3, int var4) {
      this.qwk = var3;
      this.qwl = var4;
   }

   public String title() {
      return this.qwk;
   }

   public int rank() {
      return this.qwl;
   }

   public boolean atLeast(qwj var1) {
      return this.qwl >= var1.qwl;
   }

   public static qwj parse(String var0) {
      String var1 = var0.toLowerCase(Locale.ROOT);
      if (var1.contains(a.d("尩▖꽃ㄴ뫫", 704360598, -335878015))) {
         return LEGENDARY;
      } else if (var1.contains(a.d("鳭\ue558濷", -87782288, 1160320162))) {
         return MYTHIC;
      } else {
         return var1.contains(a.d("ꚹ\udf07單쯓", -1358368631, 144658954)) ? COMMON : null;
      }
   }

   public static qwj byTitle(String var0) {
      for (qwj var4 : values()) {
         if (var4.qwk.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return COMMON;
   }
}
