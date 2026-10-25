package a;

import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ufw {
   public static final SecureRandom RANDOM = new SecureRandom();
   static final Encoder ufx = Base64.getUrlEncoder().withoutPadding();
   static final Decoder ufy = Base64.getUrlDecoder();
   static final byte[] ufz = a.b("鲬\ue517濇\uf1ae稼ﲒ䚜콼儰\udb87屙꙼⣤녘㬜붸ެ蠺", 717200600).getBytes(StandardCharsets.UTF_8);

   ufw() {
   }

   public static KeyPair generate() throws GeneralSecurityException {
      return KeyPairGenerator.getInstance(a.b("뺉읒䶆폷堤\ude9d", -997409065)).generateKeyPair();
   }

   public static PrivateKey privateKey(String var0) throws GeneralSecurityException {
      return KeyFactory.getInstance(a.c(-57310070, "蓔ﴏ矛\ue9aa批\ue4c0")).generatePrivate(new PKCS8EncodedKeySpec(ufy.decode(var0)));
   }

   public static PublicKey publicKey(String var0) throws GeneralSecurityException {
      return KeyFactory.getInstance(a.c(-1300335048, "癦\u0fbd蕩ᬘ郋ᙲ")).generatePublic(new X509EncodedKeySpec(ufy.decode(var0)));
   }

   public static String b64(byte[] var0) {
      return ufx.encodeToString(var0);
   }

   public static byte[] unb64(String var0) {
      return ufy.decode(var0);
   }

   public static byte[] randomKey() {
      byte[] var0 = new byte[32];
      RANDOM.nextBytes(var0);
      return var0;
   }

   public static String fingerprint(String var0) {
      try {
         byte[] var1 = MessageDigest.getInstance(a.b("矇\u0e6d蒷᪪酢។궄", 1697544083))
            .digest((a.c(641194536, "\uda47ꏼ⤬띅㳗멹a覆៕") + var0).getBytes(StandardCharsets.UTF_8));
         long var2 = (var1[0] & 255L) << 32 | (var1[1] & 255L) << 24 | (var1[2] & 255L) << 16 | (var1[3] & 255L) << 8 | var1[4] & 255L;
         String var4 = String.format(a.b("\uefff陛ᲀ芭", -1565462562), var2 % 100000000L);
         return var4.substring(0, 4) + a.b("䜒", -1214429389) + var4.substring(4);
      } catch (GeneralSecurityException var5) {
         return a.d("빥쟔䴇퍶", 1566802609, -103924497);
      }
   }

   public static byte[] boxKey(PrivateKey var0, String var1, String var2) throws GeneralSecurityException {
      KeyAgreement var3 = KeyAgreement.getInstance(a.d("\ue466鶽ᝩ褘ˋ葲", -2043992836, -1901608764));
      var3.init(var0);
      var3.doPhase(publicKey(var2), true);
      byte[] var4 = var3.generateSecret();
      boolean var5 = true;

      for (byte var9 : var4) {
         if (var9 != 0) {
            var5 = false;
            break;
         }
      }

      if (var5) {
         throw new GeneralSecurityException(a.b("迮\uf64d粚\ue2e1楽\uef87嗚\udc37", 1116114833));
      }

      String var10 = var1.compareTo(var2) < 0 ? var1 : var2;
      String var11 = var10.equals(var1) ? var2 : var1;
      byte[] var12 = ugc(var4, ufz, (var10 + a.c(1295920587, "ⶶ") + var11).getBytes(StandardCharsets.UTF_8));
      Arrays.fill(var4, (byte)0);
      return var12;
   }

   public static String seal(byte[] var0, String var1, byte[] var2) throws GeneralSecurityException {
      byte[] var3 = new byte[12];
      RANDOM.nextBytes(var3);
      Cipher var4 = Cipher.getInstance(a.d("謇\uf2b2硷\ue67a淅\ueb70儭\ud8be䚀찐䯼놼㽮ꛟⲁ꩷ေ", -264854523, 1239691090));
      var4.init(1, new SecretKeySpec(var0, a.c(532210467, "\ue361體ထ")), new GCMParameterSpec(128, var3));
      var4.updateAAD(var1.getBytes(StandardCharsets.UTF_8));
      byte[] var5 = var4.doFinal(var2);
      byte[] var6 = new byte[12 + var5.length];
      System.arraycopy(var3, 0, var6, 0, 12);
      System.arraycopy(var5, 0, var6, 12, var5.length);
      return b64(var6);
   }

   public static byte[] open(byte[] var0, String var1, String var2) {
      try {
         byte[] var3 = unb64(var2);
         if (var3.length < 28) {
            return null;
         }

         Cipher var4 = Cipher.getInstance(a.d("㒸䴍쟈姅퉺哏\uee92朁錄环\uf443ฃ胑ᥠ錾ᗈ꾎", -1919511839, 934782473));
         var4.init(2, new SecretKeySpec(var0, a.b("\u12c1歴\ue1b1", 1318851203)), new GCMParameterSpec(128, var3, 0, 12));
         var4.updateAAD(var1.getBytes(StandardCharsets.UTF_8));
         return var4.doFinal(var3, 12, var3.length - 12);
      } catch (GeneralSecurityException | IllegalArgumentException var5) {
         return null;
      }
   }

   static byte[] ugc(byte[] var0, byte[] var1, byte[] var2) throws GeneralSecurityException {
      Mac var3 = Mac.getInstance(a.b("\uf432趦ݹ養ይ鑇⸝ꞟ㧇덵", 684323952));
      var3.init(new SecretKeySpec(var1, a.c(1725539985, "ꛓ\udf47喘쯫䀌욦糼\uf57e欦\ue194")));
      byte[] var4 = var3.doFinal(var0);
      var3.init(new SecretKeySpec(var4, a.d("\uf8a2脶௩閚ṽ飗⊍\uab0f㕗뿥", -1649414495, -1070197183)));
      var3.update(var2);
      var3.update((byte)1);
      byte[] var5 = var3.doFinal();
      Arrays.fill(var4, (byte)0);
      return var5;
   }
}
