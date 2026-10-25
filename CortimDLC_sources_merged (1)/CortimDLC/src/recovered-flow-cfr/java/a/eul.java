/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.izx;
import a.vhz;
import a.wap;
import flow.dev.a;
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

public final class eul {
    private static final String eum = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'f', 'l', 'o', 'w', '2', '-', 'a', 'u', 't', 'h', '.', 'f', 'l', 'o', 'w', '-', 'c', '0', 'd', '8', '7', '.', 'w', 'o', 'r', 'k', 'e', 'r', 's', '.', 'd', 'e', 'v'});
    private static final long eun = 314572800L;
    private static final long euo = 0x3000000L;
    private static final int eup = 4;
    private static final Pattern euq = Pattern.compile(a.d("\u4c3e\u358a\ubf43\u215e\uaafe\u2c74\u966b\u1fcd\u81d8\u0b74\u8cb3\u76a6\uf877\u61dc\uebe3\u6d65\ud711\u588c\uc268\u4473\ucd99\ub7dc\u3978\ua2d8\u24d7\uae04\u17c7\u99b0\u030c\u8541\u0eec\uf03a\u7a75\ue3cc\u65c6", 512414536, 799710987));
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

    private eul() {
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
        Class<eul> clazz = eul.class;
        synchronized (eul.class) {
            if (euu == null) {
                euu = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();
                euv = (ThreadPoolExecutor)Executors.newFixedThreadPool(4, runnable -> {
                    Thread thread = new Thread(runnable, a.c(1557565890, "\u9188\ue813\u62c3\ufcaa\u7738\uf19b\u4b89\uc26a\u5c35\ud692\u5150\uab26"));
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
        while (string2.startsWith(a.b("\ue74b", 1190979429))) {
            string2 = string2.substring(1);
        }
        if (string2.startsWith(a.c(739659443, "\u4ed0\u376b\ubdbb\u23d2\ua85d"))) {
            string2 = string2.substring(a.c(-1313949918, "\ub741\ucefa\u442a\uda43\u51cc").length());
        }
        if (!euq.matcher(string2).matches()) {
            return "";
        }
        for (String string3 : string2.split(a.c(-2933635, "\u3c53"))) {
            if (!string3.isEmpty() && !string3.equals(a.d("\u6323", 274787962, -1357607562)) && !string3.equals(a.d("\u5321\u2a90", -952182484, -1744270815))) continue;
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
        String string2 = eul.evc(string);
        byte[] byArray = eul.evd(string2);
        if (byArray != null) {
            if (consumer != null) {
                consumer.accept(byArray);
            }
            return;
        }
        eul.evb();
        euv.execute(() -> {
            try {
                byte[] byArray = eul.bytes(string2);
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
        return new ByteArrayInputStream(eul.bytes(string));
    }

    private static byte[] evf(String string) throws Exception {
        return LocalAssets.bytes(string);
    }

    private static String evg(int n) {
        return switch (n) {
            case 401 -> wap.s(a.d("\ud543\uace5\u267e\ub84e\u339a\ub523\u0f7e\u8688\u1899\u9266\u15be\uefcf\u6119\uf8a9\u72fb", -1232236474, -1336392328), a.d("\uc116\ub8ad\u320b\uac0f\u27da\ua16c\u1b36\u92ca\u0c99\u8230\u01f1\uff92\u755e\uecea\u66b7\ue042\u5a0c\ud5a8", 1964156038, 459956669));
            case 403 -> wap.s(a.b("\u6e17\u17b9\u9d74\u0308\u88bb\u0e47\ub410\u3dfb\ua3ba\u2907\uaec1\u54a7\uda7b\u4382\ue9e5\u4f20\uf53d\u7afb\ue05e\u6619\uefff\u95fa\u1b21\u80ef\u068e\u8c52\u3585\ubb9d\u216d\ua772\u2c83\ud25f\u580b", 1722510974), a.b("\u631b\u1ab5\u9078\u0e04\u85b7\u071b\ubd40\u30a4\uaa9a\u2054\ua78b\u5df7\ud32f\u4a95\uc4dd\u6218\uf863\u73d3\ue910\u6f30\ue6b9\u9c97\u1229\u8d94\u0ff9\u813a\u3c98\ub2c6\u284d\uae6b", 135095117));
            case 404 -> wap.s(a.c(-291342373, "\u77b7\u0e14\u84c7\u1aa0\u9166\u1783\uad9d\u2468\uba2d\u309c\ub755\u4d23\uc3fd"), a.d("\u8885\uf13c\u7ffa\ue596\u6e4c\ue8f4\u52aa\udb5a\u450d\ucfbf", -1199009961, 1900938213));
            default -> a.c(-852605427, "\u4640\u3fed\ub53e\u2b4b\ua0ec") + n;
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
            izx.alert(wap.s(a.c(-1698901386, "\ud230\uabae\u217e\ubf15\u34d3"), a.d("\u44b9\u3d27\ub7fe\u2984\ua259\u24ec", -1937593698, 983034431)), string, vhz.MISC, false);
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
        return euv.submit(() -> eul.evf(string));
    }

    static {
        eut = new ConcurrentHashMap();
    }

    private static /* synthetic */ int lb(int n, int n2) {
        return n - n2 + 841310287;
    }

    private static /* synthetic */ int lc(int n, int n2) {
        return eul.lb(n, n2) * n2;
    }

    private static /* synthetic */ int ld(int n, int n2) {
        return eul.lb(n, n2) ^ 0xB678B262;
    }
}

