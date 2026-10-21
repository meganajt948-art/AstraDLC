/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.AssetStore;
import flow.dev.StringDecryptor;
import java.io.IOException;
import java.io.InputStream;

public final class AssetPaths {
    private static final String[] ezk = new String[]{"/flow/video/", "/flow/cosmetics/", "/flow/wallpapers/", "/flow/menu/", "/flow/avatars/", "/flow/captcha/", "/flow/sounds/weather/"};
    private static /* synthetic */ String ezl;
    private static /* synthetic */ long ezm;

    private AssetPaths() {
    }

    private static boolean ezn(String string) {
        return string != null && string.length() <= 512 && !string.contains("..") && !string.contains("\\") && !string.contains("//");
    }

    public static InputStream open(String string) throws IOException {
        for (String string2 : ezk) {
            if (!string.startsWith(string2)) continue;
            return AssetStore.open(string);
        }
        if (!AssetPaths.ezn(string)) {
            throw new IOException("bad resource path");
        }
        InputStream inputStream = AssetPaths.class.getResourceAsStream(string);
        if (inputStream == null) {
            throw new IOException("missing " + string);
        }
        return inputStream;
    }

    public static byte[] bytes(String string) throws IOException {
        for (String string2 : ezk) {
            if (!string.startsWith(string2)) continue;
            return AssetStore.bytes(string);
        }
        if (!AssetPaths.ezn(string)) {
            throw new IOException("bad resource path");
        }
        try (InputStream inputStream = AssetPaths.class.getResourceAsStream(string);){
            if (inputStream == null) {
                throw new IOException("missing " + string);
            }
            byte[] byArray = inputStream.readAllBytes();
            return byArray;
        }
    }

    private static /* synthetic */ int mq(int n, int n2) {
        return n * n2 ^ 0xECD7612D;
    }

    private static /* synthetic */ int mr(int n, int n2) {
        return AssetPaths.mq(n, n2) + n;
    }

    private static /* synthetic */ int ms(int n, int n2) {
        return AssetPaths.mr(n, n2) ^ 0xA29B4332;
    }
}

