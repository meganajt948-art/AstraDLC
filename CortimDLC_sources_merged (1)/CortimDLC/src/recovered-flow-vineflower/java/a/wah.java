package a;

import flow.dev.a;

final class wah {
   final String[] nameCompacts;
   final String[] nameWholeSounds;
   final String[] nameWords;
   final String[] nameSounds;
   final String[] aliasWords;
   final String[] detailWords;
   final String[] descriptionWords;

   wah(String var1, String var2, String var3, String var4) {
      String var5 = var1 == null ? "" : var1;
      String[] var6 = var5.split(a.b("묌", -126436601));
      this.nameCompacts = new String[var6.length];
      this.nameWholeSounds = new String[var6.length];

      for (int var7 = 0; var7 < var6.length; var7++) {
         this.nameCompacts[var7] = wap.wbf(wap.wbb(var6[var7]));
         this.nameWholeSounds[var7] = wap.wbh(wap.wbg(this.nameCompacts[var7]));
      }

      this.nameWords = wap.wbc(var5);
      this.nameSounds = new String[this.nameWords.length];

      for (int var8 = 0; var8 < this.nameWords.length; var8++) {
         this.nameSounds[var8] = wap.wbh(wap.wbg(this.nameWords[var8]));
      }

      this.aliasWords = wap.wbc(var2);
      this.detailWords = wap.wbc(var3);
      this.descriptionWords = wap.wbc(var4);
   }

   int score(String var1) {
      String[] var2 = wap.wbc(var1);
      if (var2.length == 0) {
         return 0;
      }

      String var3 = String.join("", var2);
      String var4 = wap.wbh(wap.wbg(var3));
      byte var5 = 0;

      for (int var6 = 0; var6 < this.nameCompacts.length; var6++) {
         String var7 = this.nameCompacts[var6];
         if (!var7.isEmpty()) {
            if (var7.equals(var3)) {
               return 100;
            }

            if (var7.startsWith(var3)) {
               var5 = 90;
            } else if (var5 == 0 && var3.length() >= 3 && var4.length() >= 3 && this.nameWholeSounds[var6].startsWith(var4)) {
               var5 = 88;
            }
         }
      }

      if (var5 > 0) {
         return var5;
      }

      if (var3.length() >= 2 && wal(this.aliasWords, var3, true)) {
         return 85;
      }

      int var12 = 80;

      for (String var10 : var2) {
         byte var11;
         if (this.wak(var10)) {
            var11 = 80;
         } else if (var10.length() >= 2 && wal(this.aliasWords, var10, false)) {
            var11 = 80;
         } else if (var10.length() >= 2 && wal(this.detailWords, var10, false)) {
            var11 = 60;
         } else {
            if (var10.length() < 3 || !wal(this.descriptionWords, var10, false)) {
               return 0;
            }

            var11 = 40;
         }

         var12 = Math.min(var12, var11);
      }

      return var12;
   }

   boolean wak(String var1) {
      if (wal(this.nameWords, var1, false)) {
         return true;
      }

      if (var1.length() < 3) {
         return false;
      }

      for (String var5 : this.nameCompacts) {
         if (var5.contains(var1)) {
            return true;
         }
      }

      String var7 = wap.wbh(wap.wbg(var1));
      if (var7.length() < 3) {
         return false;
      }

      for (String var6 : this.nameSounds) {
         if (var6.startsWith(var7)) {
            return true;
         }
      }

      for (String var14 : this.nameWholeSounds) {
         if (var14.contains(var7)) {
            return true;
         }
      }

      return false;
   }

   static boolean wal(String[] var0, String var1, boolean var2) {
      for (String var6 : var0) {
         if (var2 ? var6.equals(var1) : var6.startsWith(var1)) {
            return true;
         }
      }

      return false;
   }
}
