/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import flow.util.LoaderInfo;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class exn {
    private static final String exo = a.c(-2003942744, "\u42dd\u3b2b\ub1b5");
    private static final int exp = 12;
    private static final int exq = 128;
    private static final Base64.Encoder exr = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder exs = Base64.getUrlDecoder();
    private static final SecureRandom ext = new SecureRandom();
    private static final byte[] exu = new byte[]{70, 50, 78, 49};
    private static final byte[] exv = new byte[]{70, 50, 78, 48};
    private static /* synthetic */ long exw;
    private static /* synthetic */ boolean exx;

    private exn() {
    }

    private static SecretKeySpec exy() {
        byte[] byArray = LoaderInfo.encKey();
        return byArray == null || byArray.length != 32 ? null : new SecretKeySpec(byArray, a.b("\uf9f7\u8042\u0a87", -1604126283));
    }

    public static boolean armed() {
        return exn.exy() != null;
    }

    public static String sealWith(byte[] byArray, String string, String string2) {
        if (byArray == null || byArray.length != 32 || string2 == null) {
            return null;
        }
        try {
            byte[] byArray2 = new byte[12];
            ext.nextBytes(byArray2);
            Cipher cipher = Cipher.getInstance(a.b("\u839e\ufa2b\u70ee\ueee3\u655c\ue3e9\u59b4\ud027\u4e19\uc489\u4365\ub925\u37f7\uae46\u2418\ua2ee\u18a8", 19891150));
            cipher.init(1, (Key)new SecretKeySpec(byArray, a.b("\u4fe1\u3654\ubc91", 1645629347)), new GCMParameterSpec(128, byArray2));
            cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            byte[] byArray3 = cipher.doFinal(string2.getBytes(StandardCharsets.UTF_8));
            return a.d("\u7ad8\u032e\u89b0", 1466619707, 547204502) + exr.encodeToString(byArray2) + a.d("\ub0d4", 679593158, -583371665) + exr.encodeToString(byArray3);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String openWith(byte[] byArray, String string, String string2) {
        if (byArray == null || byArray.length != 32 || string2 == null || !string2.startsWith(a.d("\u443a\u3dcc\ub752", 528007247, 860259328))) {
            return null;
        }
        int n = string2.indexOf(124, a.c(-792534082, "\ue3cb\u9a3d\u10a3").length());
        if (n <= 0) {
            return null;
        }
        try {
            byte[] byArray2 = exs.decode(string2.substring(a.d("\ucb07\ub2f1\u386f", 52354566, 459412852).length(), n));
            byte[] byArray3 = exs.decode(string2.substring(n + 1));
            Cipher cipher = Cipher.getInstance(a.c(151720179, "\u10a3\u6916\ue3d3\u7dde\uf661\u70d4\uca89\u431a\udd24\u57b4\ud058\u2a18\ua4ca\u3d7b\ub725\u31d3\u8b95"));
            cipher.init(2, (Key)new SecretKeySpec(byArray, a.c(-1314873104, "\ua0b2\ud907\u53c2")), new GCMParameterSpec(128, byArray2));
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
        SecretKeySpec secretKeySpec = exn.exy();
        if (secretKeySpec == null) {
            byte[] byArray2 = new byte[exv.length + byArray.length];
            System.arraycopy(exv, 0, byArray2, 0, exv.length);
            System.arraycopy(byArray, 0, byArray2, exv.length, byArray.length);
            return byArray2;
        }
        try {
            byte[] byArray3 = new byte[12];
            ext.nextBytes(byArray3);
            Cipher cipher = Cipher.getInstance(a.c(-1557608148, "\uc97c\ub0c9\u3a0c\ua401\u2fbe\ua90b\u1356\u9ac5\u04fb\u8e6b\u0987\uf3c7\u7d15\ue4a4\u6efa\ue80c\u524a"));
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
        SecretKeySpec secretKeySpec = exn.exy();
        if (exn.exz(byArray, exv)) {
            return secretKeySpec == null ? Arrays.copyOfRange(byArray, exv.length, byArray.length) : null;
        }
        if (!exn.exz(byArray, exu) || secretKeySpec == null || byArray.length < exu.length + 12 + 16) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(a.d("\ud6c8\uaf7d\u25b8\ubbb5\u300a\ub6bf\u0ce2\u8571\u1b4f\u91df\u1633\uec73\u62a1\ufb10\u714e\uf7b8\u4dfe", 561945855, -1081980313));
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
        SecretKeySpec secretKeySpec = exn.exy();
        if (secretKeySpec == null) {
            return string2;
        }
        try {
            byte[] byArray = new byte[12];
            ext.nextBytes(byArray);
            Cipher cipher = Cipher.getInstance(a.c(1555062999, "\u6087\u1932\u93f7\u0dfa\u8645\u00f0\ubaad\u333e\uad00\u2790\ua07c\u5a3c\ud4ee\u4d5f\uc701\u41f7\ufbb1"));
            cipher.init(1, (Key)secretKeySpec, new GCMParameterSpec(128, byArray));
            if (string != null) {
                cipher.updateAAD(string.getBytes(StandardCharsets.UTF_8));
            }
            byte[] byArray2 = cipher.doFinal(string2.getBytes(StandardCharsets.UTF_8));
            return a.d("\u55d3\u2c25\ua6bb", 259326423, 1864651889) + exr.encodeToString(byArray) + a.c(-1794809585, "\u6172") + exr.encodeToString(byArray2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String open(String string, String string2) {
        if (string2 == null || string2.isEmpty()) {
            return string2;
        }
        SecretKeySpec secretKeySpec = exn.exy();
        if (!string2.startsWith(a.c(-1546608407, "\ua09c\ud96a\u53f4"))) {
            return secretKeySpec == null ? string2 : null;
        }
        if (secretKeySpec == null) {
            return null;
        }
        int n = string2.indexOf(124, a.b("\u781a\u01ec\u8b72", -342198161).length());
        if (n <= 0) {
            return null;
        }
        try {
            byte[] byArray = exs.decode(string2.substring(a.b("\u48be\u3148\ubbd6", -1545516853).length(), n));
            byte[] byArray2 = exs.decode(string2.substring(n + 1));
            Cipher cipher = Cipher.getInstance(a.b("\ufaf0\u8345\u0980\u978d\u1c32\u9a87\u20da\ua949\u3777\ubde7\u3a0b\uc04b\u4e99\ud728\u5d76\udb80\u61c6", 1713699488));
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
        return exn.lv(n, n2) + n;
    }
}

