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

import a.CloudSync;
import a.AesGcmBox;
import a.CloudEndpoint;
import a.eyg;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.StringDecryptor;
import flow.util.LoaderInfo;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class CloudConfigs {
    private static final int eyo = 0x2000000;
    private static HttpClient eyp;
    private static ExecutorService eyq;
    private static /* synthetic */ long eyr;
    private static /* synthetic */ boolean eys;

    private CloudConfigs() {
    }

    public static boolean online() {
        CloudSync.ensureLoaded();
        return CloudSync.online();
    }

    private static synchronized void eyt() {
        if (eyq != null) {
            return;
        }
        eyp = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
        eyq = Executors.newFixedThreadPool(2, runnable -> {
            Thread thread = new Thread(runnable, "cloud-n");
            thread.setDaemon(true);
            thread.setPriority(1);
            return thread;
        });
    }

    private static HttpRequest.Builder eyu(String string, int n) {
        return HttpRequest.newBuilder(URI.create(CloudSync.endpoint() + string)).timeout(Duration.ofSeconds(n)).header("authorization", "Bearer " + LoaderInfo.token()).header("x-hwid", CloudEndpoint.get());
    }

    private static <T> CompletableFuture<T> eyv(Callable<T> callable) {
        if (!CloudConfigs.online()) {
            return CompletableFuture.failedFuture(new IOException("offline"));
        }
        CloudConfigs.eyt();
        return CompletableFuture.supplyAsync(() -> {
            try {
                return callable.call();
            }
            catch (Exception exception) {
                throw new CompletionException(exception);
            }
        }, eyq);
    }

    public static CompletableFuture<List<eyg>> list(String string) {
        return CloudConfigs.eyv(() -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("prefix", string == null ? "" : string);
            HttpRequest httpRequest = CloudConfigs.eyu("/api/neuro/list", 20).header("content-type", "application/json").POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            HttpResponse<byte[]> httpResponse = eyp.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (httpResponse.statusCode() != 200 || httpResponse.body().length > 0x400000) {
                throw new IOException("list " + httpResponse.statusCode());
            }
            JsonObject jsonObject2 = JsonParser.parseString((String)new String(httpResponse.body(), StandardCharsets.UTF_8)).getAsJsonObject();
            ArrayList<eyg> arrayList = new ArrayList<eyg>();
            if (jsonObject2.has("items") && jsonObject2.get("items").isJsonArray()) {
                for (JsonElement jsonElement : jsonObject2.getAsJsonArray("items")) {
                    JsonObject jsonObject3 = jsonElement.getAsJsonObject();
                    arrayList.add(new eyg(jsonObject3.get("key").getAsString(), jsonObject3.get("size").getAsLong(), jsonObject3.get("uploaded").getAsLong(), CloudConfigs.parseMeta(jsonObject3.has("meta") ? jsonObject3.get("meta").getAsString() : "")));
                }
            }
            return arrayList;
        });
    }

    public static CompletableFuture<byte[]> get(String string) {
        return CloudConfigs.eyv(() -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", string);
            HttpRequest httpRequest = CloudConfigs.eyu("/api/neuro/get", 120).header("content-type", "application/json").POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            HttpResponse<byte[]> httpResponse = eyp.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (httpResponse.statusCode() != 200) {
                throw new IOException("get " + httpResponse.statusCode());
            }
            if (httpResponse.body().length > 0x2000000) {
                throw new IOException("too large");
            }
            byte[] byArray = AesGcmBox.openBytes("neuro:" + string, httpResponse.body());
            if (byArray == null) {
                throw new IOException("sealed");
            }
            return byArray;
        });
    }

    public static CompletableFuture<Boolean> put(String string, byte[] byArray, Map<String, String> map) {
        return CloudConfigs.eyv(() -> {
            byte[] byArray2 = AesGcmBox.sealBytes("neuro:" + string, byArray);
            if (byArray2 == null) {
                throw new IOException("seal");
            }
            HttpRequest httpRequest = CloudConfigs.eyu("/api/neuro/put?key=" + URLEncoder.encode(string, StandardCharsets.UTF_8), 180).header("content-type", "application/octet-stream").header("x-meta", URLEncoder.encode(CloudConfigs.meta(map), StandardCharsets.UTF_8).replace("+", "%20")).PUT(HttpRequest.BodyPublishers.ofByteArray(byArray2)).build();
            HttpResponse<String> httpResponse = eyp.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200) {
                throw new IOException("put " + httpResponse.statusCode() + " " + httpResponse.body());
            }
            return true;
        });
    }

    public static CompletableFuture<Boolean> delete(Collection<String> collection, String string) {
        return CloudConfigs.eyv(() -> {
            Object object;
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            if (collection != null) {
                object = collection.iterator();
                while (object.hasNext()) {
                    String string2 = (String)object.next();
                    jsonArray.add(string2);
                }
            }
            jsonObject.add("keys", (JsonElement)jsonArray);
            if (string != null) {
                jsonObject.addProperty("prefix", string);
            }
            return eyp.send((HttpRequest)(object = CloudConfigs.eyu("/api/neuro/del", 30).header("content-type", "application/json").POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build()), HttpResponse.BodyHandlers.discarding()).statusCode() == 200;
        });
    }

    public static String meta(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(';');
                }
                stringBuilder.append(CloudConfigs.eyw(entry.getKey())).append('=').append(CloudConfigs.eyw(entry.getValue()));
            }
        }
        return stringBuilder.length() > 900 ? stringBuilder.substring(0, 900) : stringBuilder.toString();
    }

    private static String eyw(String string) {
        return string == null ? "" : string.replace(';', ',').replace('=', ':').replace('\n', ' ').replace('\r', ' ');
    }

    public static Map<String, String> parseMeta(String string) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        if (string == null) {
            return linkedHashMap;
        }
        for (String string2 : string.split(";")) {
            int n = string2.indexOf(61);
            if (n <= 0) continue;
            linkedHashMap.put(string2.substring(0, n), string2.substring(n + 1));
        }
        return linkedHashMap;
    }

    private static /* synthetic */ int mh(int n, int n2) {
        return n ^ n2 | 0xC1EFE896;
    }

    private static /* synthetic */ int mi(int n, int n2) {
        return CloudConfigs.mh(n, n2) ^ 0xB48E3FE5;
    }

    private static /* synthetic */ int mj(int n, int n2) {
        return n - n2 + 1374229131;
    }
}

