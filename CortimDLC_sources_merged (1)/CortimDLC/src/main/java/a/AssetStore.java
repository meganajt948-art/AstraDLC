/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Hud;
import a.Icon;
import a.Lang;
import flow.dev.StringDecryptor;
import flow.offline.LocalAssets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public final class AssetStore {
    private static final String eum = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'f', 'l', 'o', 'w', '2', '-', 'a', 'u', 't', 'h', '.', 'f', 'l', 'o', 'w', '-', 'c', '0', 'd', '8', '7', '.', 'w', 'o', 'r', 'k', 'e', 'r', 's', '.', 'd', 'e', 'v'});
    private static final long eun = 314572800L;
    private static final long euo = 0x3000000L;
    private static final int eup = 4;
    private static final Pattern euq = Pattern.compile("^[A-Za-z0-9][A-Za-z0-9._/-]{0,255}$");
    private static final Map<String, byte[]> eur = new LinkedHashMap<String, byte[]>(32, 0.75f, true);
    private static long eus;
    private static final ConcurrentHashMap<String, Future<byte[]>> eut;
    private static volatile HttpClient euu;
    private static volatile ThreadPoolExecutor euv;
    private static volatile String euw;
    private static volatile int eux;
    private static volatile long euy;
    private static /* synthetic */ int euz;
    private static /* synthetic */ boolean eva;

    private AssetStore() {
    }

    public static String base() {
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static HttpClient evb() {
        HttpClient httpClient = euu;
        if (httpClient != null) {
            return httpClient;
        }
        Class<AssetStore> clazz = AssetStore.class;
        synchronized (AssetStore.class) {
            if (euu == null) {
                euu = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();
                euv = (ThreadPoolExecutor)Executors.newFixedThreadPool(4, runnable -> {
                    Thread thread = new Thread(runnable, "Flow2 assets");
                    thread.setDaemon(true);
                    return thread;
                });
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return euu;
        }
    }

    private static String evc(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.replace('\\', '/').trim();
        while (string2.startsWith("/")) {
            string2 = string2.substring(1);
        }
        if (string2.startsWith("flow/")) {
            string2 = string2.substring("flow/".length());
        }
        if (!euq.matcher(string2).matches()) {
            return "";
        }
        for (String string3 : string2.split("/")) {
            if (!string3.isEmpty() && !string3.equals(".") && !string3.equals("..")) continue;
            return "";
        }
        return string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] evd(String string) {
        Map<String, byte[]> map = eur;
        synchronized (map) {
            return eur.get(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void eve(String string, byte[] byArray) {
        Map<String, byte[]> map = eur;
        synchronized (map) {
            byte[] byArray2 = eur.put(string, byArray);
            if (byArray2 != null) {
                eus -= (long)byArray2.length;
            }
            eus += (long)byArray.length;
            while (eus > 314572800L && eur.size() > 1) {
                Map.Entry<String, byte[]> entry = eur.entrySet().iterator().next();
                eur.remove(entry.getKey());
                eus -= (long)entry.getValue().length;
            }
        }
    }

    public static byte[] bytes(String string) throws IOException {
        return LocalAssets.bytes(string);
    }

    public static void preload(String string, Consumer<byte[]> consumer) {
        String string2 = AssetStore.evc(string);
        byte[] byArray = AssetStore.evd(string2);
        if (byArray != null) {
            if (consumer != null) {
                consumer.accept(byArray);
            }
            return;
        }
        AssetStore.evb();
        euv.execute(() -> {
            try {
                byte[] byArray = AssetStore.bytes(string2);
                if (consumer != null) {
                    consumer.accept(byArray);
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
        });
    }

    public static InputStream open(String string) throws IOException {
        return new ByteArrayInputStream(AssetStore.bytes(string));
    }

    private static byte[] evf(String string) throws Exception {
        return LocalAssets.bytes(string);
    }

    private static String evg(int n) {
        return switch (n) {
            case 401 -> Lang.s("re-login needed", "перезайди в лоадер");
            case 403 -> Lang.s("HWID mismatch — reset HWID in bot", "HWID не совпал — сбрось в боте");
            case 404 -> Lang.s("asset missing", "не найдено");
            default -> "HTTP " + n;
        };
    }

    private static void evh(int n, String string) {
        long l = System.currentTimeMillis();
        if (n == eux && l - euy < 15000L) {
            return;
        }
        eux = n;
        euy = l;
        try {
            Hud.alert(Lang.s("Cloud", "Облако"), string, Icon.MISC, false);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static void shutdown() {
        ThreadPoolExecutor threadPoolExecutor = euv;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
            try {
                threadPoolExecutor.awaitTermination(2L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static /* synthetic */ Future lambda$bytes$2(String string) {
        return euv.submit(() -> AssetStore.evf(string));
    }

    static {
        eut = new ConcurrentHashMap();
    }

    private static /* synthetic */ int lb(int n, int n2) {
        return n - n2 + 841310287;
    }

    private static /* synthetic */ int lc(int n, int n2) {
        return AssetStore.lb(n, n2) * n2;
    }

    private static /* synthetic */ int ld(int n, int n2) {
        return AssetStore.lb(n, n2) ^ 0xB678B262;
    }
}

