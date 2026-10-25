package a;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class vvi {
   static final int vvj = (int)(System.nanoTime() ^ -1640531527L);
   static final byte[] vvk;

   vvi() {
   }

   public static String get() {
      byte[] var0 = new byte[vvk.length];

      for (int var1 = 0; var1 < vvk.length; var1++) {
         var0[var1] = (byte)(vvk[var1] ^ (byte)(vvj >>> (var1 & 3) * 8));
      }

      StringBuilder var3 = new StringBuilder(var0.length * 2 - 1);

      for (int var2 = 0; var2 < var0.length; var2++) {
         if (var2 > 0) {
            var3.append('\u200c');
         }

         var3.append((char)(var0[var2] & 0xFF));
      }

      Arrays.fill(var0, (byte)0);
      return var3.toString();
   }

   public static String getRaw() {
      byte[] var0 = new byte[vvk.length];

      for (int var1 = 0; var1 < vvk.length; var1++) {
         var0[var1] = (byte)(vvk[var1] ^ (byte)(vvj >>> (var1 & 3) * 8));
      }

      return new String(var0, StandardCharsets.UTF_8);
   }

   static {
      byte[] var0 = new byte[]{70, 108, 111, 119, 67, 108, 105, 101, 110, 116};

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] ^= (byte)(vvj >>> (var1 & 3) * 8);
      }

      vvk = var0;
   }
}
