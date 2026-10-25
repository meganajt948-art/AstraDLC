package a;

import flow.dev.a;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

final class vnb {
   static final List<String> NAMES = List.of(a.c(-1980250628, "얶밡㛻ꢃ⍂ꗴᾺ陃ࠑ"), a.d("ፈ櫎\ue00a繻\uf5a2猚", -1710906119, 1216198645), a.b("\uddb6ꐤ⻩낟㭍뷻ޡ", 2099633637));

   private vnb() {
   }

   static boolean has(String var0) {
      return NAMES.contains(var0);
   }

   static vpi load(String var0, boolean var1) {
      String var2 = a.c(764142521, "\ue39b驣Ⴚ軈ԇ菮㧡뀌⹉ꓣ⌺\ud95c埗")
         + var0.toLowerCase(Locale.ROOT)
         + (var1 ? a.c(-2066750377, "\ue40b鶊\u1758") : a.d("\ufe1e螟\u0d45錴", -1242686201, -486939838))
         + a.c(-505650787, "憷ᡇ銜೭");

      try (InputStream var3 = vnb.class.getResourceAsStream(var2)) {
         return var3 == null ? null : vpo.decode(var3.readAllBytes());
      } catch (Exception var8) {
         System.out.println(a.c(-10428349, "\ue03d馎ፒ赪ۮ耋㨈돥\u2db7ꜞₔ\udab1呺췆䟐셣笻\uf4f1湈\ue811懯ᮿ镈໊袩ɢ믊㖑꼢") + var2 + a.b("\uf1be蠕", -1790578298) + var8);
         return null;
      }
   }
}
