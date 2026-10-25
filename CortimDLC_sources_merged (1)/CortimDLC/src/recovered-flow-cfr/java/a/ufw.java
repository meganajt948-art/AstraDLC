/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
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
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ufw {
    public static final SecureRandom RANDOM = new SecureRandom();
    private static final Base64.Encoder ufx = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder ufy = Base64.getUrlDecoder();
    private static final byte[] ufz = a.b("\u9cac\ue517\u6fc7\uf1ae\u7a3c\ufc92\u469c\ucf7c\u5130\udb87\u5c59\ua67c\u28e4\ub158\u3b1c\ubdb8\u07ac\u883a", 717200600).getBytes(StandardCharsets.UTF_8);
    private static /* synthetic */ int uga;
    private static /* synthetic */ String ugb;

    private ufw() {
    }

    public static KeyPair generate() throws GeneralSecurityException {
        return KeyPairGenerator.getInstance(a.b("\ube89\uc752\u4d86\ud3f7\u5824\ude9d", -997409065)).generateKeyPair();
    }

    public static PrivateKey privateKey(String string) throws GeneralSecurityException {
        return KeyFactory.getInstance(a.c(-57310070, "\u84d4\ufd0f\u77db\ue9aa\u6279\ue4c0")).generatePrivate(new PKCS8EncodedKeySpec(ufy.decode(string)));
    }

    public static PublicKey publicKey(String string) throws GeneralSecurityException {
        return KeyFactory.getInstance(a.c(-1300335048, "\u7666\u0fbd\u8569\u1b18\u90cb\u1672")).generatePublic(new X509EncodedKeySpec(ufy.decode(string)));
    }

    public static String b64(byte[] byArray) {
        return ufx.encodeToString(byArray);
    }

    public static byte[] unb64(String string) {
        return ufy.decode(string);
    }

    public static byte[] randomKey() {
        byte[] byArray = new byte[32];
        RANDOM.nextBytes(byArray);
        return byArray;
    }

    public static String fingerprint(String string) {
        try {
            byte[] byArray = MessageDigest.getInstance(a.b("\u77c7\u0e6d\u84b7\u1aaa\u9162\u17d4\uad84", 1697544083)).digest((a.c(641194536, "\uda47\ua3fc\u292c\ub745\u3cd7\uba79a\u8986\u17d5") + string).getBytes(StandardCharsets.UTF_8));
            long l = ((long)byArray[0] & 0xFFL) << 32 | ((long)byArray[1] & 0xFFL) << 24 | ((long)byArray[2] & 0xFFL) << 16 | ((long)byArray[3] & 0xFFL) << 8 | (long)byArray[4] & 0xFFL;
            String string2 = String.format(a.b("\uefff\u965b\u1c80\u82ad", -1565462562), l % 100000000L);
            return string2.substring(0, 4) + a.b("\u4712", -1214429389) + string2.substring(4);
        }
        catch (GeneralSecurityException generalSecurityException) {
            return a.d("\ube65\uc7d4\u4d07\ud376", 1566802609, -103924497);
        }
    }

    public static byte[] boxKey(PrivateKey privateKey, String string, String string2) throws GeneralSecurityException {
        KeyAgreement keyAgreement = KeyAgreement.getInstance(a.d("\ue466\u9dbd\u1769\u8918\u02cb\u8472", -2043992836, -1901608764));
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(ufw.publicKey(string2), true);
        byte[] byArray = keyAgreement.generateSecret();
        boolean bl = true;
        for (byte by : byArray) {
            if (by == 0) continue;
            bl = false;
            break;
        }
        if (bl) {
            throw new GeneralSecurityException(a.b("\u8fee\uf64d\u7c9a\ue2e1\u697d\uef87\u55da\udc37", 1116114833));
        }
        Object object = string.compareTo(string2) < 0 ? string : string2;
        String string3 = ((String)object).equals(string) ? string2 : string;
        byte[] byArray2 = ufw.ugc(byArray, ufz, ((String)object + a.c(1295920587, "\u2db6") + string3).getBytes(StandardCharsets.UTF_8));
        Arrays.fill(byArray, (byte)0);
        return byArray2;
    }

    public static String seal(byte[] byArray, String string, byte[] byArray2) throws GeneralSecurityException {
        byte[] byArray3 = new byte[12];
        RANDOM.nextBytes(byArray3);
        Cipher cipher = Cipher.getInstance(a.d("\u8b07\uf2b2\u7877\ue67a\u6dc5\ueb70\u512d\ud8be\u4680\ucc10\u4bfc\ub1bc\u3f6e\ua6df\u2c81\uaa77\u1031", -264854523, 1239691090));
        cipher.init(1, (Key)new SecretKeySpec(byArray, a.c(532210467, "\ue361\u9ad4\u1011")), new GCMParameterSpec(128, byArray3));
        cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
        byte[] byArray4 = cipher.doFinal(byArray2);
        byte[] byArray5 = new byte[12 + byArray4.length];
        System.arraycopy(byArray3, 0, byArray5, 0, 12);
        System.arraycopy(byArray4, 0, byArray5, 12, byArray4.length);
        return ufw.b64(byArray5);
    }

    public static byte[] open(byte[] byArray, String string, String string2) {
        try {
            byte[] byArray2 = ufw.unb64(string2);
            if (byArray2.length < 28) {
                return null;
            }
            Cipher cipher = Cipher.getInstance(a.d("\u34b8\u4d0d\uc7c8\u59c5\ud27a\u54cf\uee92\u6701\uf93f\u73af\uf443\u0e03\u80d1\u1960\u933e\u15c8\uaf8e", -1919511839, 934782473));
            cipher.init(2, (Key)new SecretKeySpec(byArray, a.b("\u12c1\u6b74\ue1b1", 1318851203)), new GCMParameterSpec(128, byArray2, 0, 12));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            return cipher.doFinal(byArray2, 12, byArray2.length - 12);
        }
        catch (IllegalArgumentException | GeneralSecurityException exception) {
            return null;
        }
    }

    private static byte[] ugc(byte[] byArray, byte[] byArray2, byte[] byArray3) throws GeneralSecurityException {
        Mac mac = Mac.getInstance(a.b("\uf432\u8da6\u0779\u990a\u12ed\u9447\u2e1d\ua79f\u39c7\ub375", 684323952));
        mac.init(new SecretKeySpec(byArray2, a.c(1725539985, "\ua6d3\udf47\u5598\ucbeb\u400c\uc6a6\u7cfc\uf57e\u6b26\ue194")));
        byte[] byArray4 = mac.doFinal(byArray);
        mac.init(new SecretKeySpec(byArray4, a.d("\uf8a2\u8136\u0be9\u959a\u1e7d\u98d7\u228d\uab0f\u3557\ubfe5", -1649414495, -1070197183)));
        mac.update(byArray3);
        mac.update((byte)1);
        byte[] byArray5 = mac.doFinal();
        Arrays.fill(byArray4, (byte)0);
        return byArray5;
    }

    private static /* synthetic */ int cwd(int n, int n2) {
        return n ^ n2 | 0x4B9B527C;
    }

    private static /* synthetic */ int cwe(int n, int n2) {
        return ufw.cwd(n, n2) + n;
    }
}

