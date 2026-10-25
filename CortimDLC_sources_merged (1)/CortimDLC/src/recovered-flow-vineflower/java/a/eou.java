package a;

import java.util.ArrayList;

final class eou {
   final String eov;
   final long[] eow;

   eou(String name, long[] dims) {
      this.eov = name;
      this.eow = dims;
   }

   static eou read(epm var0) {
      String var1 = "";
      ArrayList var2 = new ArrayList();

      while (var0.more()) {
         int var3 = var0.tag();
         if (var3 >>> 3 == 1 && (var3 & 7) == 2) {
            var1 = var0.string();
         } else if (var3 >>> 3 == 2 && (var3 & 7) == 2) {
            epm var4 = var0.sub();

            while (var4.more()) {
               int var5 = var4.tag();
               if (var5 >>> 3 == 1 && (var5 & 7) == 2) {
                  epm var6 = var4.sub();

                  while (var6.more()) {
                     int var7 = var6.tag();
                     if (var7 >>> 3 == 2 && (var7 & 7) == 2) {
                        epm var8 = var6.sub();

                        while (var8.more()) {
                           int var9 = var8.tag();
                           if (var9 >>> 3 == 1 && (var9 & 7) == 2) {
                              epm var10 = var8.sub();
                              long var11 = -1L;

                              while (var10.more()) {
                                 int var13 = var10.tag();
                                 if (var13 >>> 3 == 1 && (var13 & 7) == 0) {
                                    var11 = var10.varint();
                                 } else {
                                    var10.skip(var13 & 7);
                                 }
                              }

                              var2.add(var11);
                           } else {
                              var8.skip(var9 & 7);
                           }
                        }
                     } else {
                        var6.skip(var7 & 7);
                     }
                  }
               } else {
                  var4.skip(var5 & 7);
               }
            }
         } else {
            var0.skip(var3 & 7);
         }
      }

      return new eou(var1, var2.stream().mapToLong(Long::longValue).toArray());
   }

   public String name() {
      return this.eov;
   }

   public long[] dims() {
      return this.eow;
   }
}
