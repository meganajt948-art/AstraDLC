package a;

import flow.dev.a;

public final class pfl {
   private static final String[] pfm = new String[]{
      a.c(-74709434, "؎"),
      a.c(-1925491375, "唚ⲫ"),
      a.b("릙쀨䫻", 2111355347),
      a.c(-554631820, "﴿蒑"),
      a.b("\u0e70", -1469837785),
      a.b("䔯㲁", 851330427),
      a.c(632004626, "ꁇ\ud9e9区"),
      a.c(-1118815858, "㧜䁲쪡哐"),
      a.c(-1741263234, "渵ផ"),
      a.c(-2047216373, "\uf552")
   };
   private static final String[] pfn = new String[]{
      a.b("\ude12", 318234234),
      a.b("ᛑ潠", 1023022778),
      a.b("泼ᕍ龞", -707367786),
      a.b("쐮부", 1629930565),
      a.b("鼇", 1423679344),
      a.d("\uf092褼", -86503537, -481689751),
      a.d("\ue06e駀ጓ", -664668912, 936645899),
      a.c(-643852177, "頝\ue1b3歠\uf511"),
      a.b("\uf75e軾", 2015164213),
      a.b("ڥ", 1873741532)
   };
   private static final String pfo = a.c(780907790, "땪쳄䘙\ud820叶필漖\ue6e0碾\uf20c痞辠Ŷ");
   private static final String pfp = a.b("\ud8b3ꄖ⯆閉ṙ롋Ȕ譠ᕽ龍", 1179506819);
   private static final String pfq = a.b("\ude31ꞇ\u2d7b댥㣛븯Ѽ跼Ꮢ餏ỵ\ue4c3樖\uf3a7秳ｩ䔏쪙倨홻忸▲ꭷ", -1477583235);
   private static final String pfr = a.c(-1319903035, "\ue0ac餟Ꮚ趵٦胈㪓덣");
   private static final String pfs = a.c(1137342698, "糒Ԓ辵ᇋ騘᳗ꚁ⽶");

   private pfl() {
   }

   public static String roman(int var0) {
      return var0 >= 1 && var0 <= pfm.length ? pfm[var0 - 1] : String.valueOf(var0);
   }

   public static String normalize(String var0) {
      return var0 == null
         ? ""
         : var0.replaceAll(a.b("㶋䒳", 947666222), "").toLowerCase().replaceAll(a.c(858554202, "编ڠ豜ሂ駼Ἀꕛⳛ답㠨뿒䗤쬱劀\ud8d4幎\ue428殾\uf10f睜ﻟ蒕\u0a50"), "");
   }

   public static String title(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = var0.replaceAll(a.d("姷\u20cf", 1304323519, -2736915), "")
            .toLowerCase()
            .replaceAll(a.b("椼ႊ驶Ш迖ढ덱㫱ꓟ⸂꧸収\udd1b䒪컾䡤\uf202綔\ue725慶\ue8f5銿ᱺ", -506500752), a.d("\ued7b", -457283411, 1292862967))
            .trim();
         StringBuilder var2 = new StringBuilder(var1.length());

         for (int var3 = 0; var3 < var1.length(); var3++) {
            char var4 = var1.charAt(var3);
            int var5 = a.d("誶\uf305秐\ue7af汼\uead2傉\ud979", -1709089634, 514119233).indexOf(var4);
            var2.append(var5 < 0 ? var4 : a.b("阷\ueff7敐אַ烽\uf632䱤얓", 2110165519).charAt(var5));
         }

         return var2.toString();
      }
   }

   public static int levelOf(String var0, String var1) {
      if (!var0.isEmpty() && !var1.isEmpty()) {
         int var2 = 0;

         for (int var3 = var0.indexOf(var1); var3 >= 0; var3 = var0.indexOf(var1, var3 + var1.length())) {
            var2 = Math.max(var2, Math.max(1, pfv(var0, var3 + var1.length())));
         }

         return var2;
      } else {
         return 0;
      }
   }

   private static int pfv(String var0, int var1) {
      int var2 = var1;

      while (var2 < var0.length() && a.d("녛죾䈮ﱡ瞱톣毼\ue288粕\uf665", -708714892, -1032163553).indexOf(var0.charAt(var2)) >= 0) {
         var2++;
      }

      int var3 = var2;

      while (var2 < var0.length() && a.d("퇘꡶⊫벒㝄뇶த艒ᰌ难ᅬ\ueb12旄", -793375252, -1095771056).indexOf(var0.charAt(var2)) >= 0) {
         var2++;
      }

      return var2 == var3 ? 0 : parseLevel(var0.substring(var3, var2));
   }

   static int parseLevel(String var0) {
      String var1 = normalize(var0);
      if (var1.isEmpty()) {
         return 0;
      } else {
         for (int var2 = 0; var2 < pfn.length; var2++) {
            if (var1.equals(pfn[var2])) {
               return var2 + 1;
            }
         }

         String var4 = var1.replaceAll(a.d("踫\uf79f索\ue34e梍\uee58", -1779658696, -1460003250), "");
         if (!var4.isEmpty() && var4.length() < 3) {
            int var3 = Integer.parseInt(var4);
            if (var3 >= 1 && var3 <= 10) {
               return var3;
            }
         }

         for (int var5 = pfn.length - 1; var5 >= 0; var5--) {
            if (var1.contains(pfn[var5])) {
               return var5 + 1;
            }
         }

         return 0;
      }
   }
}
