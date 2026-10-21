/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class EncodedString {
    private static final int vvj = (int)(System.nanoTime() ^ 0xFFFFFFFF9E3779B9L);
    private static final byte[] vvk;
    private static /* synthetic */ int vvl;
    private static /* synthetic */ int vvm;

    private EncodedString() {
    }

    public static String get() {
        byte[] byArray = new byte[vvk.length];
        for (int i = 0; i < vvk.length; ++i) {
            byArray[i] = (byte)(vvk[i] ^ (byte)(vvj >>> (i & 3) * 8));
        }
        StringBuilder stringBuilder = new StringBuilder(byArray.length * 2 - 1);
        for (int i = 0; i < byArray.length; ++i) {
            if (i > 0) {
                stringBuilder.append('\u200c');
            }
            stringBuilder.append((char)(byArray[i] & 0xFF));
        }
        Arrays.fill(byArray, (byte)0);
        return stringBuilder.toString();
    }

    public static String getRaw() {
        byte[] byArray = new byte[vvk.length];
        for (int i = 0; i < vvk.length; ++i) {
            byArray[i] = (byte)(vvk[i] ^ (byte)(vvj >>> (i & 3) * 8));
        }
        return new String(byArray, StandardCharsets.UTF_8);
    }

    static {
        byte[] byArray = new byte[]{70, 108, 111, 119, 67, 108, 105, 101, 110, 116};
        for (int i = 0; i < byArray.length; ++i) {
            int n = i;
            byArray[n] = (byte)(byArray[n] ^ (byte)(vvj >>> (i & 3) * 8));
        }
        vvk = byArray;
    }

    private static /* synthetic */ int dla(int n, int n2) {
        return (n ^ n2) + 783453400;
    }

    private static /* synthetic */ int dlb(int n, int n2) {
        return n * n2 | 0x1DD881BA;
    }

    private static /* synthetic */ int dlc(int n, int n2) {
        return EncodedString.dla(n, n2) + n;
    }
}

