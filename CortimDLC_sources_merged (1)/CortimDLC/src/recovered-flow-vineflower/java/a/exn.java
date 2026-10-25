package a;

import flow.dev.a;
import flow.util.LoaderInfo;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class exn {
   static final String exo = a.c(-2003942744, "䋝㬫놵");
   static final int exp = 12;
   static final int exq = 128;
   static final Encoder exr = Base64.getUrlEncoder().withoutPadding();
   static final Decoder exs = Base64.getUrlDecoder();
   static final SecureRandom ext = new SecureRandom();
   static final byte[] exu = new byte[]{70, 50, 78, 49};
   static final byte[] exv = new byte[]{70, 50, 78, 48};

   exn() {
   }

   static SecretKeySpec exy() {
      byte[] var0 = LoaderInfo.encKey();
      return var0 != null && var0.length == 32 ? new SecretKeySpec(var0, a.b("立聂ઇ", -1604126283)) : null;
   }

   public static boolean armed() {
      return exy() != null;
   }

   public static String sealWith(byte[] var0, String var1, String var2) {
      if (var0 != null && var0.length == 32 && var2 != null) {
         try {
            byte[] var3 = new byte[12];
            ext.nextBytes(var3);
            Cipher var4 = Cipher.getInstance(a.b("莞飼烮\ueee3敜\ue3e9妴퀧丙쒉䍥뤥㟷깆␘ꋮᢨ", 19891150));
            var4.init(1, new SecretKeySpec(var0, a.b("信㙔벑", 1645629347)), new GCMParameterSpec(128, var3));
            var4.updateAAD(var1.getBytes(StandardCharsets.UTF_8));
            byte[] var5 = var4.doFinal(var2.getBytes(StandardCharsets.UTF_8));
            return a.d("竘̮覰", 1466619707, 547204502) + exr.encodeToString(var3) + a.d("냔", 679593158, -583371665) + exr.encodeToString(var5);
         } catch (Exception var6) {
            return null;
         }
      } else {
         return null;
      }
   }

   public static String openWith(byte[] var0, String var1, String var2) {
      if (var0 != null && var0.length == 32 && var2 != null && var2.startsWith(a.d("䐺㷌띒", 528007247, 860259328))) {
         int var3 = var2.indexOf(124, a.c(-792534082, "\ue3cb騽Ⴃ").length());
         if (var3 <= 0) {
            return null;
         }

         try {
            byte[] var4 = exs.decode(var2.substring(a.d("쬇닱㡯", 52354566, 459412852).length(), var3));
            byte[] var5 = exs.decode(var2.substring(var3 + 1));
            Cipher var6 = Cipher.getInstance(a.c(151720179, "Ⴃ椖\ue3d3緞\uf661烔쪉䌚\udd24垴큘⨘\ua4ca㵻뜥㇓讕"));
            var6.init(2, new SecretKeySpec(var0, a.c(-1314873104, "ꂲ\ud907参")), new GCMParameterSpec(128, var4));
            var6.updateAAD(var1.getBytes(StandardCharsets.UTF_8));
            return new String(var6.doFinal(var5), StandardCharsets.UTF_8);
         } catch (Exception var7) {
            return null;
         }
      } else {
         return null;
      }
   }

   public static byte[] sealBytes(String var0, byte[] var1) {
      if (var1 == null) {
         return null;
      }

      SecretKeySpec var2 = exy();
      if (var2 == null) {
         byte[] var8 = new byte[exv.length + var1.length];
         System.arraycopy(exv, 0, var8, 0, exv.length);
         System.arraycopy(var1, 0, var8, exv.length, var1.length);
         return var8;
      }

      try {
         byte[] var3 = new byte[12];
         ext.nextBytes(var3);
         Cipher var4 = Cipher.getInstance(a.c(-1557608148, "쥼냉㨌ꐁ⾾ꤋፖ髅ӻ蹫ই\uf3c7紕\ue4a4滺\ue80c削"));
         var4.init(1, var2, new GCMParameterSpec(128, var3));
         var4.updateAAD(var0.getBytes(StandardCharsets.UTF_8));
         byte[] var5 = var4.doFinal(var1);
         byte[] var6 = new byte[exu.length + 12 + var5.length];
         System.arraycopy(exu, 0, var6, 0, exu.length);
         System.arraycopy(var3, 0, var6, exu.length, 12);
         System.arraycopy(var5, 0, var6, exu.length + 12, var5.length);
         return var6;
      } catch (Exception var7) {
         return null;
      }
   }

   public static byte[] openBytes(String var0, byte[] var1) {
      if (var1 != null && var1.length >= 4) {
         SecretKeySpec var2 = exy();
         if (exz(var1, exv)) {
            return var2 == null ? Arrays.copyOfRange(var1, exv.length, var1.length) : null;
         }

         if (exz(var1, exu) && var2 != null && var1.length >= exu.length + 12 + 16) {
            try {
               Cipher var3 = Cipher.getInstance(a.d("훈꽽▸뮵《뚿ೢ蕱\u1b4f釟ᘳ\uec73抡\ufb10煎\uf7b8䷾", 561945855, -1081980313));
               var3.init(2, var2, new GCMParameterSpec(128, var1, exu.length, 12));
               var3.updateAAD(var0.getBytes(StandardCharsets.UTF_8));
               int var4 = exu.length + 12;
               return var3.doFinal(var1, var4, var1.length - var4);
            } catch (Exception var5) {
               return null;
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   static boolean exz(byte[] var0, byte[] var1) {
      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var0[var2] != var1[var2]) {
            return false;
         }
      }

      return true;
   }

   public static String seal(String var0, String var1) {
      if (var1 == null) {
         return null;
      }

      SecretKeySpec var2 = exy();
      if (var2 == null) {
         return var1;
      }

      try {
         byte[] var3 = new byte[12];
         ext.nextBytes(var3);
         Cipher var4 = Cipher.getInstance(a.c(1555062999, "悇ᤲ鏷\u0dfa虅ð몭㌾관➐ꁼ娼퓮䵟윁䇷ﮱ"));
         var4.init(1, var2, new GCMParameterSpec(128, var3));
         if (var0 != null) {
            var4.updateAAD(var0.getBytes(StandardCharsets.UTF_8));
         }

         byte[] var5 = var4.doFinal(var1.getBytes(StandardCharsets.UTF_8));
         return a.d("嗓Ⱕꚻ", 259326423, 1864651889) + exr.encodeToString(var3) + a.c(-1794809585, "慲") + exr.encodeToString(var5);
      } catch (Exception var6) {
         return null;
      }
   }

   public static String open(String var0, String var1) {
      if (var1 != null && !var1.isEmpty()) {
         SecretKeySpec var2 = exy();
         if (!var1.startsWith(a.c(-1546608407, "ꂜ\ud96a叴"))) {
            return var2 == null ? var1 : null;
         }

         if (var2 == null) {
            return null;
         }

         int var3 = var1.indexOf(124, a.b("砚Ǭ譲", -342198161).length());
         if (var3 <= 0) {
            return null;
         }

         try {
            byte[] var4 = exs.decode(var1.substring(a.b("䢾ㅈ믖", -1545516853).length(), var3));
            byte[] var5 = exs.decode(var1.substring(var3 + 1));
            Cipher var6 = Cipher.getInstance(a.b("\ufaf0荅ঀ鞍ᰲ骇⃚ꥉ㝷뷧㨋쁋亙휨嵶\udb80懆", 1713699488));
            var6.init(2, var2, new GCMParameterSpec(128, var4));
            if (var0 != null) {
               var6.updateAAD(var0.getBytes(StandardCharsets.UTF_8));
            }

            return new String(var6.doFinal(var5), StandardCharsets.UTF_8);
         } catch (Exception var7) {
            return null;
         }
      } else {
         return var1;
      }
   }
}
