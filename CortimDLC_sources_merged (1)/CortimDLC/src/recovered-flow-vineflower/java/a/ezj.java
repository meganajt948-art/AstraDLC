package a;

import flow.dev.a;
import java.io.IOException;
import java.io.InputStream;

public final class ezj {
   static final String[] ezk = new String[]{
      a.b("\ue42b鷓ᜊ襸ʷ葞㹔랺⧨ꍘ⒁\udeb0", 1740563464),
      a.d("\uf010觨̱鵃ᚌ遥⩺ꎇ㷄띫グ쫐䐚\udda1埢텏", 1123916396, 1545693763),
      a.c(438051307, "⇕堭틴䲆읉䆠ﮫ牌\uec1e暯\ue160ᬀ闆ౢ蘦Ö뫅"),
      a.b("鏽\uea05惜ﺮ畡\uf388䦙쁠帴풞北", 1158190041),
      a.c(-1986876740, "ꪝ퍥妼쟎䰁쫨烵邏杛\uedff樹遛ẍ蝠"),
      a.b("킧꥟⎆뷴㘻냒્茾ᵰ韅ခ\uea7b撥ﵚ", -335097722),
      a.b("⯵刍\ud8d4䚦쵩䮀\uf18f硢\ue627沍\ueb54ᄲ龹ِ谑\u0ae4낾㽳ꗍ⎋ꨡ", -1761727537)
   };

   ezj() {
   }

   static boolean ezn(String var0) {
      return var0 != null
         && var0.length() <= 512
         && !var0.contains(a.d("즘뀩", -750130496, 161293172))
         && !var0.contains(a.c(393230726, "㧛"))
         && !var0.contains(a.c(1088129160, "袥\uf114"));
   }

   public static InputStream open(String var0) throws IOException {
      for (String var4 : ezk) {
         if (var0.startsWith(var4)) {
            return eul.open(var0);
         }
      }

      if (!ezn(var0)) {
         throw new IOException(a.b("㋹䭋솝徨퐭劋\ue8ce愣ｦ痐\uf212ࡥ蛷\u1f16镔Ꮀꧣ", -1830604150));
      } else {
         InputStream var5 = ezj.class.getResourceAsStream(var0);
         if (var5 == null) {
            throw new IOException(a.b("\udfcdꙸⲱ닀㤍뾻ס豗", 1461444520) + var0);
         } else {
            return var5;
         }
      }
   }

   public static byte[] bytes(String var0) throws IOException {
      for (String var4 : ezk) {
         if (var0.startsWith(var4)) {
            return eul.bytes(var0);
         }
      }

      if (!ezn(var0)) {
         throw new IOException(a.c(-1081457980, "䊷㬅뇓\u2fe6ꑣ⋅颀ᅭ輨֞艜砫\uf6b9潘\ue51a揾\ud9ad"));
      }

      try (InputStream var7 = ezj.class.getResourceAsStream(var0)) {
         if (var7 == null) {
            throw new IOException(a.d("셋룾㈷걆➋ꄽ᭧鋑", -177354787, -869857549) + var0);
         } else {
            return var7.readAllBytes();
         }
      }
   }
}
