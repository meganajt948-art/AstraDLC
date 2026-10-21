/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
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

public final class PartyCrypto {
    public static final SecureRandom RANDOM = new SecureRandom();
    private static final Base64.Encoder ufx = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder ufy = Base64.getUrlDecoder();
    private static final byte[] ufz = "flow2-party-box-v1".getBytes(StandardCharsets.UTF_8);
    private static /* synthetic */ int uga;
    private static /* synthetic */ String ugb;

    private PartyCrypto() {
    }

    public static KeyPair generate() throws GeneralSecurityException {
        return KeyPairGenerator.getInstance("X25519").generateKeyPair();
    }

    public static PrivateKey privateKey(String string) throws GeneralSecurityException {
        return KeyFactory.getInstance("X25519").generatePrivate(new PKCS8EncodedKeySpec(ufy.decode(string)));
    }

    public static PublicKey publicKey(String string) throws GeneralSecurityException {
        return KeyFactory.getInstance("X25519").generatePublic(new X509EncodedKeySpec(ufy.decode(string)));
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
            byte[] byArray = MessageDigest.getInstance("SHA-256").digest(("flow2-fp|" + string).getBytes(StandardCharsets.UTF_8));
            long l = ((long)byArray[0] & 0xFFL) << 32 | ((long)byArray[1] & 0xFFL) << 24 | ((long)byArray[2] & 0xFFL) << 16 | ((long)byArray[3] & 0xFFL) << 8 | (long)byArray[4] & 0xFFL;
            String string2 = String.format("%08d", l % 100000000L);
            return string2.substring(0, 4) + " " + string2.substring(4);
        }
        catch (GeneralSecurityException generalSecurityException) {
            return "????";
        }
    }

    public static byte[] boxKey(PrivateKey privateKey, String string, String string2) throws GeneralSecurityException {
        KeyAgreement keyAgreement = KeyAgreement.getInstance("X25519");
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(PartyCrypto.publicKey(string2), true);
        byte[] byArray = keyAgreement.generateSecret();
        boolean bl = true;
        for (byte by : byArray) {
            if (by == 0) continue;
            bl = false;
            break;
        }
        if (bl) {
            throw new GeneralSecurityException("weak key");
        }
        Object object = string.compareTo(string2) < 0 ? string : string2;
        String string3 = ((String)object).equals(string) ? string2 : string;
        byte[] byArray2 = PartyCrypto.ugc(byArray, ufz, ((String)object + "|" + string3).getBytes(StandardCharsets.UTF_8));
        Arrays.fill(byArray, (byte)0);
        return byArray2;
    }

    public static String seal(byte[] byArray, String string, byte[] byArray2) throws GeneralSecurityException {
        byte[] byArray3 = new byte[12];
        RANDOM.nextBytes(byArray3);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(128, byArray3));
        cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
        byte[] byArray4 = cipher.doFinal(byArray2);
        byte[] byArray5 = new byte[12 + byArray4.length];
        System.arraycopy(byArray3, 0, byArray5, 0, 12);
        System.arraycopy(byArray4, 0, byArray5, 12, byArray4.length);
        return PartyCrypto.b64(byArray5);
    }

    public static byte[] open(byte[] byArray, String string, String string2) {
        try {
            byte[] byArray2 = PartyCrypto.unb64(string2);
            if (byArray2.length < 28) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(128, byArray2, 0, 12));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            return cipher.doFinal(byArray2, 12, byArray2.length - 12);
        }
        catch (IllegalArgumentException | GeneralSecurityException exception) {
            return null;
        }
    }

    private static byte[] ugc(byte[] byArray, byte[] byArray2, byte[] byArray3) throws GeneralSecurityException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(byArray2, "HmacSHA256"));
        byte[] byArray4 = mac.doFinal(byArray);
        mac.init(new SecretKeySpec(byArray4, "HmacSHA256"));
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
        return PartyCrypto.cwd(n, n2) + n;
    }
}

