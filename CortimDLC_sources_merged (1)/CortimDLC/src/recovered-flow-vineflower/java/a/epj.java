package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class epj {
   String op = "";
   final List<String> inputs = new ArrayList<>();
   final Map<String, eoc> attrs = new HashMap<>();

   private epj() {
   }

   static epj read(epm var0) {
      epj var1 = new epj();

      while (var0.more()) {
         int var2 = var0.tag();
         int var3 = var2 >>> 3;
         int var4 = var2 & 7;
         if (var3 == 1 && var4 == 2) {
            var1.inputs.add(var0.string());
         } else if (var3 == 4 && var4 == 2) {
            var1.op = var0.string();
         } else if (var3 == 5 && var4 == 2) {
            eoc var5 = eoc.read(var0.sub());
            var1.attrs.put(var5.name, var5);
         } else {
            var0.skip(var4);
         }
      }

      return var1;
   }

   boolean has(String var1) {
      return this.attrs.containsKey(var1);
   }

   long integer(String var1, long var2) {
      eoc var4 = this.attrs.get(var1);
      return var4 != null && var4.i != null ? var4.i : var2;
   }

   float floating(String var1, float var2) {
      eoc var3 = this.attrs.get(var1);
      return var3 != null && var3.f != null ? var3.f : var2;
   }

   String string(String var1, String var2) {
      eoc var3 = this.attrs.get(var1);
      return var3 != null && var3.s != null ? var3.s : var2;
   }

   long[] ints(String var1, long[] var2) {
      eoc var3 = this.attrs.get(var1);
      return var3 != null && !var3.ints.isEmpty() ? var3.ints.stream().mapToLong(Long::longValue).toArray() : var2;
   }
}
