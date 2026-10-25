package a;

import java.util.ArrayList;
import java.util.List;

final class eoc {
   String name = "";
   Long i;
   Float f;
   String s;
   final List<Long> ints = new ArrayList<>();

   private eoc() {
   }

   static eoc read(epm var0) {
      eoc var1 = new eoc();

      while (var0.more()) {
         int var2 = var0.tag();
         int var3 = var2 >>> 3;
         int var4 = var2 & 7;
         if (var3 == 1 && var4 == 2) {
            var1.name = var0.string();
         } else if (var3 == 2 && var4 == 5) {
            var1.f = Float.intBitsToFloat(var0.fixed32());
         } else if (var3 == 3 && var4 == 0) {
            var1.i = var0.varint();
         } else if (var3 == 4 && var4 == 2) {
            var1.s = var0.string();
         } else if (var3 == 8) {
            var0.ints(var4, var1.ints);
         } else {
            var0.skip(var4);
         }
      }

      return var1;
   }
}
