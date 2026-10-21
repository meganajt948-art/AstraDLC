/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package a;

import a.evy;
import a.ewf;
import a.AesGcmBox;
import a.CloudEndpoint;
import a.Hud;
import a.Icon;
import a.Lang;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.StringDecryptor;
import flow.offline.LocalState;
import flow.util.LoaderInfo;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class CloudSync {
    private static final String ewl = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'f', 'l', 'o', 'w', '2', '-', 'a', 'u', 't', 'h', '.', 'f', 'l', 'o', 'w', '-', 'c', '0', 'd', '8', '7', '.', 'w', 'o', 'r', 'k', 'e', 'r', 's', '.', 'd', 'e', 'v'});
    private static final long ewm = 5000L;
    private static final long ewn = 1500L;
    private static final Map<String, String> ewo = new ConcurrentHashMap<String, String>();
    private static final Map<String, evy> ewp = new ConcurrentHashMap<String, evy>();
    private static final Set<String> ewq = new HashSet<String>();
    private static final Set<String> ewr = new HashSet<String>();
    private static final Set<String> ews = new HashSet<String>();
    private static final Object ewt = new Object();
    private static volatile boolean ewu;
    private static volatile boolean ewv;
    private static final CountDownLatch eww;
    private static HttpClient ewx;
    private static ScheduledExecutorService ewy;
    private static ScheduledFuture<?> ewz;
    private static volatile int exa;
    private static volatile long exb;
    private static /* synthetic */ boolean exc;
    private static /* synthetic */ int exd;

    private CloudSync() {
    }

    private static String exe() {
        String string = LoaderInfo.api();
        if (string == null || string.isBlank()) {
            return ewl;
        }
        return (string = string.trim()).endsWith("/") ? string.substring(0, string.length() - 1) : string;
    }

    static String endpoint() {
        return CloudSync.exe();
    }

    public static synchronized void init() {
        if (ewu) {
            LocalState.init();
            return;
        }
        ewu = true;
        String string = LoaderInfo.token();
        boolean bl = ewv = string != null && !string.isBlank();
        if (!ewv) {
            eww.countDown();
            LocalState.init();
            return;
        }
        ewx = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(6L)).build();
        ewy = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "Flow2 cloud");
            thread.setDaemon(true);
            return thread;
        });
        ewy.execute(CloudSync::exf);
        LocalState.init();
    }

    public static boolean online() {
        return ewv;
    }

    public static void ensureLoaded() {
        if (!ewu) {
            CloudSync.init();
        }
        try {
            eww.await(5000L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void exf() {
        try {
            Object object;
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(CloudSync.exe() + "/api/data/pull")).timeout(Duration.ofSeconds(8L)).header("authorization", "Bearer " + LoaderInfo.token()).header("content-type", "application/json").header("x-hwid", CloudEndpoint.get()).POST(HttpRequest.BodyPublishers.ofString("{}")).build();
            HttpResponse<byte[]> httpResponse = ewx.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (httpResponse.statusCode() != 200) {
                CloudSync.exm(httpResponse.statusCode());
                return;
            }
            if (httpResponse.body().length > 0x800000) {
                return;
            }
            JsonObject jsonObject = JsonParser.parseString((String)new String(httpResponse.body(), StandardCharsets.UTF_8)).getAsJsonObject();
            if (jsonObject.has("slots") && jsonObject.get("slots").isJsonObject()) {
                for (Map.Entry entry : jsonObject.getAsJsonObject("slots").entrySet()) {
                    if (!((JsonElement)entry.getValue()).isJsonPrimitive() || CloudSync.exg((String)entry.getKey()) || (object = AesGcmBox.open("slot:" + (String)entry.getKey(), ((JsonElement)entry.getValue()).getAsString())) == null) continue;
                    ewo.put((String)entry.getKey(), (String)object);
                }
            }
            if (jsonObject.has("configs") && jsonObject.get("configs").isJsonObject()) {
                for (Map.Entry entry : jsonObject.getAsJsonObject("configs").entrySet()) {
                    if (CloudSync.exh((String)entry.getKey()) || !((JsonElement)entry.getValue()).isJsonObject()) continue;
                    object = ((JsonElement)entry.getValue()).getAsJsonObject();
                    String string = AesGcmBox.open("config:" + (String)entry.getKey(), object.has("data") ? object.get("data").getAsString() : "");
                    if (string == null) continue;
                    ewp.put((String)entry.getKey(), new evy(string, object.has("enabled") ? object.get("enabled").getAsInt() : 0, object.has("modules") ? object.get("modules").getAsInt() : 0, object.has("updated") ? object.get("updated").getAsLong() : 0L));
                }
            }
        }
        catch (Exception exception) {
        }
        finally {
            eww.countDown();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean exg(String string) {
        Object object = ewt;
        synchronized (object) {
            return ewq.contains(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean exh(String string) {
        Object object = ewt;
        synchronized (object) {
            return ewr.contains(string) || ews.contains(string);
        }
    }

    public static String get(String string) {
        CloudSync.ensureLoaded();
        return ewo.get(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void put(String string, String string2) {
        ewo.put(string, string2);
        if (!ewv) {
            LocalState.save();
            return;
        }
        Object object = ewt;
        synchronized (object) {
            ewq.add(string);
            CloudSync.exi();
        }
        LocalState.save();
    }

    public static void putAlone(String string, String string2) {
        ewo.put(string, string2);
        if (!ewv || ewy == null) {
            LocalState.save();
            return;
        }
        ewy.execute(() -> {
            String string3 = AesGcmBox.seal("slot:" + string, string2);
            if (string3 == null) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(string, string3);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("slots", (JsonElement)jsonObject);
            try {
                HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(CloudSync.exe() + "/api/data/push")).timeout(Duration.ofSeconds(20L)).header("authorization", "Bearer " + LoaderInfo.token()).header("content-type", "application/json").header("x-hwid", CloudEndpoint.get()).POST(HttpRequest.BodyPublishers.ofString(jsonObject2.toString(), StandardCharsets.UTF_8)).build();
                CloudSync.exm(ewx.send(httpRequest, HttpResponse.BodyHandlers.discarding()).statusCode());
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
        LocalState.save();
    }

    public static long sizeOf(String string) {
        CloudSync.ensureLoaded();
        long l = 0L;
        for (Map.Entry<String, String> entry : ewo.entrySet()) {
            if (!entry.getKey().startsWith(string)) continue;
            l += (long)entry.getValue().length();
        }
        return l;
    }

    public static byte[] getBytes(String string) {
        String string2 = CloudSync.get(string);
        if (string2 == null) {
            return null;
        }
        try {
            return Base64.getDecoder().decode(string2.trim());
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public static void putBytes(String string, byte[] byArray) {
        CloudSync.put(string, Base64.getEncoder().encodeToString(byArray));
    }

    public static Set<String> configNames() {
        CloudSync.ensureLoaded();
        return new TreeSet<String>(ewp.keySet());
    }

    public static Map<String, evy> configs() {
        CloudSync.ensureLoaded();
        return Map.copyOf(ewp);
    }

    public static boolean hasConfig(String string) {
        CloudSync.ensureLoaded();
        return string != null && ewp.containsKey(string);
    }

    public static String getConfig(String string) {
        CloudSync.ensureLoaded();
        evy evy2 = ewp.get(string);
        return evy2 == null ? null : evy2.data();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void putConfig(String string, String string2, int n, int n2) {
        ewp.put(string, new evy(string2, n, n2, System.currentTimeMillis() / 1000L));
        if (!ewv) {
            LocalState.save();
            return;
        }
        Object object = ewt;
        synchronized (object) {
            ewr.add(string);
            ews.remove(string);
            CloudSync.exi();
        }
        LocalState.save();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void deleteConfig(String string) {
        ewp.remove(string);
        if (!ewv) {
            LocalState.save();
            return;
        }
        Object object = ewt;
        synchronized (object) {
            ewr.remove(string);
            ews.add(string);
            CloudSync.exi();
        }
        LocalState.save();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void renameConfig(String string, String string2) {
        evy evy2 = ewp.remove(string);
        if (evy2 == null) {
            LocalState.save();
            return;
        }
        ewp.put(string2, new evy(evy2.data(), evy2.enabled(), evy2.modules(), System.currentTimeMillis() / 1000L));
        if (!ewv) {
            LocalState.save();
            return;
        }
        Object object = ewt;
        synchronized (object) {
            ewr.add(string2);
            ewr.remove(string);
            ews.add(string);
            ews.remove(string2);
            CloudSync.exi();
        }
        LocalState.save();
    }

    private static void exi() {
        if (ewy == null) {
            return;
        }
        if (ewz != null) {
            ewz.cancel(false);
        }
        ewz = ewy.schedule(CloudSync::exj, 1500L, TimeUnit.MILLISECONDS);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void exj() {
        JsonObject jsonObject;
        Object object = ewt;
        synchronized (object) {
            if (ewq.isEmpty() && ewr.isEmpty() && ews.isEmpty()) {
                return;
            }
            jsonObject = CloudSync.exl();
            ewq.clear();
            ewr.clear();
            ews.clear();
        }
        try {
            object = HttpRequest.newBuilder(URI.create(CloudSync.exe() + "/api/data/push")).timeout(Duration.ofSeconds(10L)).header("authorization", "Bearer " + LoaderInfo.token()).header("content-type", "application/json").header("x-hwid", CloudEndpoint.get()).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            HttpResponse<String> httpResponse = ewx.send((HttpRequest)object, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200) {
                CloudSync.exm(httpResponse.statusCode());
                CloudSync.exk(jsonObject);
            }
        }
        catch (Exception exception) {
            CloudSync.exk(jsonObject);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void exk(JsonObject jsonObject) {
        Object object = ewt;
        synchronized (object) {
            if (jsonObject.has("slots")) {
                ewq.addAll(jsonObject.getAsJsonObject("slots").keySet());
            }
            if (jsonObject.has("configs")) {
                ewr.addAll(jsonObject.getAsJsonObject("configs").keySet());
            }
            if (jsonObject.has("delConfigs")) {
                jsonObject.getAsJsonArray("delConfigs").forEach(jsonElement -> ews.add(jsonElement.getAsString()));
            }
        }
    }

    private static JsonObject exl() {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        for (String object2 : ewq) {
            String string;
            String string2 = ewo.get(object2);
            if (string2 == null || (string = AesGcmBox.seal("slot:" + object2, string2)) == null) continue;
            jsonObject2.addProperty(object2, string);
        }
        if (jsonObject2.size() > 0) {
            jsonObject.add("slots", (JsonElement)jsonObject2);
        }
        JsonObject jsonObject3 = new JsonObject();
        for (String string : ewr) {
            String string3;
            evy evy2 = ewp.get(string);
            if (evy2 == null || (string3 = AesGcmBox.seal("config:" + string, evy2.data())) == null) continue;
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("data", string3);
            jsonObject4.addProperty("enabled", (Number)evy2.enabled());
            jsonObject4.addProperty("modules", (Number)evy2.modules());
            jsonObject3.add(string, (JsonElement)jsonObject4);
        }
        if (jsonObject3.size() > 0) {
            jsonObject.add("configs", (JsonElement)jsonObject3);
        }
        if (!ews.isEmpty()) {
            JsonArray jsonArray = new JsonArray();
            for (String string : ews) {
                jsonArray.add(string);
            }
            jsonObject.add("delConfigs", (JsonElement)jsonArray);
        }
        return jsonObject;
    }

    private static void exm(int n) {
        if (n != 401 && n != 403) {
            return;
        }
        long l = System.currentTimeMillis();
        if (n == exa && l - exb < 15000L) {
            return;
        }
        exa = n;
        exb = l;
        try {
            String string = n == 403 ? Lang.s("HWID mismatch — reset HWID in bot", "HWID не совпал — сбрось в боте") : Lang.s("re-login needed", "перезайди в лоадер");
            Hud.alert(Lang.s("Cloud", "Облако"), string, Icon.MISC, false);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static CompletableFuture<ewf> call(String string, JsonObject jsonObject) {
        if (!ewu) {
            CloudSync.init();
        }
        if (!ewv || ewy == null) {
            return CompletableFuture.failedFuture(new IOException("offline"));
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                JsonObject jsonObject2;
                HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(CloudSync.exe() + string)).timeout(Duration.ofSeconds(10L)).header("authorization", "Bearer " + LoaderInfo.token()).header("content-type", "application/json").header("x-hwid", CloudEndpoint.get()).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
                HttpResponse<byte[]> httpResponse = ewx.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
                CloudSync.exm(httpResponse.statusCode());
                if (httpResponse.body().length > 0x200000) {
                    throw new IOException("too large");
                }
                try {
                    jsonObject2 = JsonParser.parseString((String)new String(httpResponse.body(), StandardCharsets.UTF_8)).getAsJsonObject();
                }
                catch (RuntimeException runtimeException) {
                    jsonObject2 = new JsonObject();
                }
                return new ewf(httpResponse.statusCode(), jsonObject2);
            }
            catch (IOException iOException) {
                throw new CompletionException(iOException);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                throw new CompletionException(interruptedException);
            }
        }, ewy);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void flushNow() {
        if (!ewv) {
            LocalState.save();
            return;
        }
        Object object = ewt;
        synchronized (object) {
            if (ewz != null) {
                ewz.cancel(false);
            }
        }
        CloudSync.exj();
        LocalState.save();
    }

    static {
        eww = new CountDownLatch(1);
    }

    private static /* synthetic */ int ls(int n, int n2) {
        return n - n2 | 0x7AFA7243;
    }
}

