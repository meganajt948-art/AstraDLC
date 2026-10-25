package a;

import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.List;

final class epm {
   private final byte[] epn;
   private int epo;
   private final int epp;

   epm(byte[] var1, int var2, int var3) {
      this.epn = var1;
      this.epo = var2;
      this.epp = var3;
   }

   boolean more() {
      return this.epo < this.epp;
   }

   int tag() {
      return (int)this.varint();
   }

   long varint() {
      long var1 = 0L;

      for (byte var3 = 0; var3 < 64; var3 += 7) {
         byte var4 = this.epn[this.epo++];
         var1 |= (long)(var4 & 127) << var3;
         if ((var4 & 128) == 0) {
            return var1;
         }
      }

      throw new IllegalArgumentException(a.c(1476841557, "퀥ꦃ⍃봩㛹끒"));
   }

   epm sub() {
      int var1 = (int)this.varint();
      if (var1 >= 0 && this.epo + var1 <= this.epp) {
         epm var2 = new epm(this.epn, this.epo, this.epo + var1);
         this.epo += var1;
         return var2;
      } else {
         throw new IllegalArgumentException(a.d("鸊\ue7b2浪\uf312磖ﹻ", -710237401, 1339047239));
      }
   }

   String string() {
      epm var1 = this.sub();
      return new String(var1.epn, var1.epo, var1.epp - var1.epo, StandardCharsets.UTF_8);
   }

   int fixed32() {
      int var1 = this.epn[this.epo] & 255 | (this.epn[this.epo + 1] & 255) << 8 | (this.epn[this.epo + 2] & 255) << 16 | (this.epn[this.epo + 3] & 255) << 24;
      this.epo += 4;
      return var1;
   }

   void ints(int var1, List<Long> var2) {
      if (var1 == 2) {
         epm var3 = this.sub();

         while (var3.more()) {
            var2.add(var3.varint());
         }
      } else {
         var2.add(this.varint());
      }
   }

   void skip(int var1) {
      switch (var1) {
         case 0:
            this.varint();
            break;
         case 1:
            this.epo += 8;
            break;
         case 2:
            this.sub();
            break;
         case 3:
         case 4:
         default:
            throw new IllegalArgumentException(a.d("\u0e62矍ﴅ捣\ue8f1", 1361763564, 1296421628) + var1);
         case 5:
            this.epo += 4;
      }

      if (this.epo > this.epp) {
         throw new IllegalArgumentException(a.c(1970606544, "ᆸ栐\ue2d0粶\uf761燗쮟"));
      }
   }
}
