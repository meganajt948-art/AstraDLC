package a;

import flow.dev.a;

public final class jgd {
   final String jge;
   final String jgf;
   final String jgg;
   final boolean jgh;
   final long jgi;
   final long jgj;
   final long jgk;

   public jgd(String app, String title, String artist, boolean playing, long pos, long duration, long stamp) {
      this.jge = app;
      this.jgf = title;
      this.jgg = artist;
      this.jgh = playing;
      this.jgi = pos;
      this.jgj = duration;
      this.jgk = stamp;
   }

   public long position() {
      long var1 = this.jgh ? this.jgi + (System.currentTimeMillis() - this.jgk) : this.jgi;
      return this.jgj > 0L ? Math.min(this.jgj, var1) : var1;
   }

   public float progress() {
      return this.jgj > 0L ? Math.min(1.0F, (float)this.position() / (float)this.jgj) : -1.0F;
   }

   String key() {
      return this.jge + '|' + this.jgf + '|' + this.jgg;
   }

   public String source() {
      String var1 = this.jge.toLowerCase();
      if (var1.contains(a.d("쑗뷥㜩ꥃ⊉ꐷṻ", -763607868, 1990754535))) {
         return a.d("䗚㱈뚄⣮ꌤ▚鿖", 1944382814, -1016223536);
      }

      if (var1.contains(a.b("䦥「뫐⒫꽽⧑", -781628966))) {
         return a.c(1048148905, "篼ɵ袩ᛒ鴄ᮨꆣ⠿뙘㳯묦䅝");
      }

      if (var1.contains(a.d("틣ꭌ↉뿹㐭늞", -1056537635, 778064213))) {
         return a.c(111891631, "哮\u2d7eꞮ㧝");
      }

      if (var1.contains(a.d("ꡥ퇟嬖앺亯젖", -30383401, 472435415))) {
         return a.d("ͬ競\uf03f湓\ue586挿", 238200921, -649352336);
      }

      if (var1.contains(a.c(1673954769, "薰ﰎ盆\ue8a0捴\ue5cc很"))) {
         return a.b("ꂊ\ud914叜춺䙮샖窒", -1879924533);
      }

      if (var1.contains(a.c(1108898419, "爙ஷ腱\u1f17铓"))) {
         return a.b("國⺅ꑃ㨥뇡", -1291954367);
      }

      if (var1.contains(a.d("⚮弐험䮢쁽䛔ﲁ番\ueb3f", -601390467, -512711520)) || var1.contains(a.b("\ud962ꃛ⨉둵㾪", 2143869194))) {
         return a.c(1751140626, "䥓ナ먘⑤꾻⥋鍨᪥蓷\u0e5e覑珷");
      }

      if (var1.contains(a.b("乾㟕봉", -1407103477))) {
         return a.c(349834886, "໓睸ﶤ");
      }

      if (!var1.contains(a.c(428600653, "\ued29钉Ṛ耷௩")) && !var1.contains(a.d("쟖빺㒨ꫂ℞ꞹ", -1839281604, -614396539))) {
         String var2 = this.jge;
         int var3 = var2.indexOf(33);
         if (var3 >= 0) {
            var2 = var2.substring(0, var3);
         }

         if (var2.endsWith(a.d("\ue44b鶱\u177f褓", -1228502547, -546804340))) {
            var2 = var2.substring(0, var2.length() - 4);
         }

         return var2.isEmpty() ? a.c(-1716368130, "䲨㔥뿻→꩙⳿") : var2;
      } else {
         return a.b("᎒樒\ue0c1纬\uf572玆즸䁱\ude28咃퍚", 1065423832);
      }
   }

   public String app() {
      return this.jge;
   }

   public String title() {
      return this.jgf;
   }

   public String artist() {
      return this.jgg;
   }

   public boolean playing() {
      return this.jgh;
   }

   public long pos() {
      return this.jgi;
   }

   public long duration() {
      return this.jgj;
   }

   public long stamp() {
      return this.jgk;
   }
}
