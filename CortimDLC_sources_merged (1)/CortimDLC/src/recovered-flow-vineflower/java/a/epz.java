package a;

import flow.dev.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

final class epz {
   String name = "";
   long[] dims = new long[0];
   float[] data;

   private epz() {
   }

   static epz read(epm var0) {
      epz var1 = new epz();
      ArrayList var2 = new ArrayList();
      int var3 = 0;
      byte[] var4 = null;
      ArrayList var5 = new ArrayList();
      boolean var6 = false;

      while (var0.more()) {
         int var7 = var0.tag();
         int var8 = var7 >>> 3;
         int var9 = var7 & 7;
         if (var8 == 1) {
            var0.ints(var9, var2);
         } else if (var8 == 2 && var9 == 0) {
            var3 = (int)var0.varint();
         } else if (var8 == 4 && var9 == 2) {
            epm var18 = var0.sub();

            while (var18.more()) {
               var5.add(Float.intBitsToFloat(var18.fixed32()));
            }
         } else if (var8 == 4 && var9 == 5) {
            var5.add(Float.intBitsToFloat(var0.fixed32()));
         } else if (var8 == 8 && var9 == 2) {
            var1.name = var0.string();
         } else if (var8 == 9 && var9 == 2) {
            epm var10 = var0.sub();
            var4 = Arrays.copyOfRange(var10.epn, var10.epo, var10.epp);
         } else if (var8 == 14 && var9 == 0) {
            var6 = var0.varint() == 1L;
         } else {
            var0.skip(var9);
         }
      }

      var1.dims = var2.stream().mapToLong(Long::longValue).toArray();
      if (var3 == 1 && !var6) {
         long var14 = 1L;

         for (long var12 : var1.dims) {
            var14 *= var12;
         }

         if (var4 != null) {
            float[] var17 = new float[var4.length / 4];
            ByteBuffer.wrap(var4).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(var17);
            var1.data = var17;
         } else {
            var1.data = new float[var5.size()];

            for (int var16 = 0; var16 < var1.data.length; var16++) {
               var1.data[var16] = (Float)var5.get(var16);
            }
         }

         if (var1.data.length != var14) {
            throw new IllegalArgumentException(a.b("\ude51\ua7f1\u2d29덅㢎븢У趁Ꮔ饦Ẫ\ue49e", -175251927) + var1.name);
         }
      }

      return var1;
   }
}
