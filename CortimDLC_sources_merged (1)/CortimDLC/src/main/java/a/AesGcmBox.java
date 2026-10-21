/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
import flow.util.LoaderInfo;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcmBox {
    private static final String exo = "v1|";
    private static final int exp = 12;
    private static final int exq = 128;
    private static final Base64.Encoder exr = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder exs = Base64.getUrlDecoder();
    private static final SecureRandom ext = new SecureRandom();
    private static final byte[] exu = new byte[]{70, 50, 78, 49};
    private static final byte[] exv = new byte[]{70, 50, 78, 48};
    private static /* synthetic */ long exw;
    private static /* synthetic */ boolean exx;

    private AesGcmBox() {
    }

    private static SecretKeySpec exy() {
        byte[] byArray = LoaderInfo.encKey();
        return byArray == null || byArray.length != 32 ? null : new SecretKeySpec(byArray, "AES");
    }

    public static boolean armed() {
        return AesGcmBox.exy() != null;
    }

    public static String sealWith(byte[] byArray, String string, String string2) {
        if (byArray == null || byArray.length != 32 || string2 == null) {
            return null;
        }
        try {
            byte[] byArray2 = new byte[12];
            ext.nextBytes(byArray2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(128, byArray2));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            byte[] byArray3 = cipher.doFinal(string2.getBytes(StandardCharsets.UTF_8));
            return "v1|" + exr.encodeToString(byArray2) + "|" + exr.encodeToString(byArray3);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String openWith(byte[] byArray, String string, String string2) {
        if (byArray == null || byArray.length != 32 || string2 == null || !string2.startsWith("v1|")) {
            return null;
        }
        int n = string2.indexOf(124, "v1|".length());
        if (n <= 0) {
            return null;
        }
        try {
            byte[] byArray2 = exs.decode(string2.substring("v1|".length(), n));
            byte[] byArray3 = exs.decode(string2.substring(n + 1));
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(128, byArray2));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            return new String(cipher.doFinal(byArray3), StandardCharsets.UTF_8);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static byte[] sealBytes(String string, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = AesGcmBox.exy();
        if (secretKeySpec == null) {
            byte[] byArray2 = new byte[exv.length + byArray.length];
            System.arraycopy(exv, 0, byArray2, 0, exv.length);
            System.arraycopy(byArray, 0, byArray2, exv.length, byArray.length);
            return byArray2;
        }
        try {
            byte[] byArray3 = new byte[12];
            ext.nextBytes(byArray3);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, (Key)secretKeySpec, new GCMParameterSpec(128, byArray3));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            byte[] byArray4 = cipher.doFinal(byArray);
            byte[] byArray5 = new byte[exu.length + 12 + byArray4.length];
            System.arraycopy(exu, 0, byArray5, 0, exu.length);
            System.arraycopy(byArray3, 0, byArray5, exu.length, 12);
            System.arraycopy(byArray4, 0, byArray5, exu.length + 12, byArray4.length);
            return byArray5;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static byte[] openBytes(String string, byte[] byArray) {
        if (byArray == null || byArray.length < 4) {
            return null;
        }
        SecretKeySpec secretKeySpec = AesGcmBox.exy();
        if (AesGcmBox.exz(byArray, exv)) {
            return secretKeySpec == null ? Arrays.copyOfRange(byArray, exv.length, byArray.length) : null;
        }
        if (!AesGcmBox.exz(byArray, exu) || secretKeySpec == null || byArray.length < exu.length + 12 + 16) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, (Key)secretKeySpec, new GCMParameterSpec(128, byArray, exu.length, 12));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            int n = exu.length + 12;
            return cipher.doFinal(byArray, n, byArray.length - n);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static boolean exz(byte[] byArray, byte[] byArray2) {
        for (int i = 0; i < byArray2.length; ++i) {
            if (byArray[i] == byArray2[i]) continue;
            return false;
        }
        return true;
    }

    public static String seal(String string, String string2) {
        if (string2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = AesGcmBox.exy();
        if (secretKeySpec == null) {
            return string2;
        }
        try {
            byte[] byArray = new byte[12];
            ext.nextBytes(byArray);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, (Key)secretKeySpec, new GCMParameterSpec(128, byArray));
            if (string != null) {
                cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            }
            byte[] byArray2 = cipher.doFinal(string2.getBytes(StandardCharsets.UTF_8));
            return "v1|" + exr.encodeToString(byArray) + "|" + exr.encodeToString(byArray2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String open(String string, String string2) {
        if (string2 == null || string2.isEmpty()) {
            return string2;
        }
        SecretKeySpec secretKeySpec = AesGcmBox.exy();
        if (!string2.startsWith("v1|")) {
            return secretKeySpec == null ? string2 : null;
        }
        if (secretKeySpec == null) {
            return null;
        }
        int n = string2.indexOf(124, "v1|".length());
        if (n <= 0) {
            return null;
        }
        try {
            byte[] byArray = exs.decode(string2.substring("v1|".length(), n));
            byte[] byArray2 = exs.decode(string2.substring(n + 1));
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, (Key)secretKeySpec, new GCMParameterSpec(128, byArray));
            if (string != null) {
                cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            }
            return new String(cipher.doFinal(byArray2), StandardCharsets.UTF_8);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static /* synthetic */ int lv(int n, int n2) {
        return n + n2 ^ 0x5514BB8;
    }

    private static /* synthetic */ int lw(int n, int n2) {
        return AesGcmBox.lv(n, n2) + n;
    }
}

