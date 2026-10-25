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

import a.ewk;
import a.exn;
import a.eya;
import a.eyg;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
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

public final class eyn {
    private static final int eyo = 0x2000000;
    private static HttpClient eyp;
    private static ExecutorService eyq;
    private static /* synthetic */ long eyr;
    private static /* synthetic */ boolean eys;

    private eyn() {
    }

    public static boolean online() {
        ewk.ensureLoaded();
        return ewk.online();
    }

    private static synchronized void eyt() {
        if (eyq != null) {
            return;
        }
        eyp = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).build();
        eyq = Executors.newFixedThreadPool(2, runnable -> {
            Thread thread = new Thread(runnable, a.c(527543031, "\uaa93\ud32d\u59fd\uc796\u4c50\ucaa8\u70b8"));
            thread.setDaemon(true);
            thread.setPriority(1);
            return thread;
        });
    }

    private static HttpRequest.Builder eyu(String string, int n) {
        return HttpRequest.newBuilder(URI.create(ewk.endpoint() + string)).timeout(Duration.ofSeconds(n)).header(a.d("\ue484\u9d21\u17f3\u899e\u024e\u84e2\u3eaa\ub748\u290c\ua3a8\u2466\ude11\u50c7", 1669155788, 1428664100), a.b("\u2696\u5f00\ud5d7\u4bb5\uc075\u46d3\ufcd2", -1834735917) + LoaderInfo.token()).header(a.c(-846022945, "\ub6a1\ucf45\u45d3\udbbd\u5074\ud6c8"), eya.get());
    }

    private static <T> CompletableFuture<T> eyv(Callable<T> callable) {
        if (!eyn.online()) {
            return CompletableFuture.failedFuture(new IOException(a.c(278616441, "\u5911\u20a9\uaa7a\u3401\ubfd3\u3965\u833d")));
        }
        eyn.eyt();
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
        return eyn.eyv(() -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.b("\ud3aa\uaa19\u20dd\ubeaf\u3577\ub3d7", -1980378148), string == null ? "" : string);
            HttpRequest httpRequest = eyn.eyu(a.d("\ude05\ua7fa\u2d38\ub350\u38c1\ube31\u0469\u8d88\u13d0\u997c\u1eef\ue4dd\u6a0f\uf3a4\u79f0", 1237169686, 645163059), 20).header(a.d("\u35d8\u4c65\uc6b7\u58dc\ud31a\u55a0\uefe9\u6641\uf847\u72fb\uf521\u0f45", -601345637, -311491540), a.b("\ue5e0\u9c40\u1693\u88fe\u032c\u8597\u3fc6\ub622\u2860\ua2d7\u2505\udf35\u51a7\uc80f\u4240\uc4b0", 666232209)).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            HttpResponse<byte[]> httpResponse = eyp.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (httpResponse.statusCode() != 200 || httpResponse.body().length > 0x400000) {
                throw new IOException(a.d("\ua663\udfd7\u551e\ucb68\u40eb", -32256427, 825845855) + httpResponse.statusCode());
            }
            JsonObject jsonObject2 = JsonParser.parseString((String)new String(httpResponse.body(), StandardCharsets.UTF_8)).getAsJsonObject();
            ArrayList<eyg> arrayList = new ArrayList<eyg>();
            if (jsonObject2.has(a.d("\ucaa8\ub304\u39c6\ua7bf\u2c76", -853197632, 1864693252)) && jsonObject2.get(a.c(-2086874550, "\ud226\uab8a\u2148\ubf31\u34f8")).isJsonArray()) {
                for (JsonElement jsonElement : jsonObject2.getAsJsonArray(a.c(210030296, "\uceb4\ub718\u3dda\ua3a3\u286a"))) {
                    JsonObject jsonObject3 = jsonElement.getAsJsonObject();
                    arrayList.add(new eyg(jsonObject3.get(a.c(-757718825, "\u20bf\u5900\ud3cf")).getAsString(), jsonObject3.get(a.d("\u78f2\u0159\u8b99\u15f7", 1902634188, -76309431)).getAsLong(), jsonObject3.get(a.d("\u2379\u5acd\ud002\u4e70\uc5a9\u431d\uf94f\u70bf", -1635005759, 975169989)).getAsLong(), eyn.parseMeta(jsonObject3.has(a.d("\uece8\u9551\u1f93\u81f7", 1193019393, 1039590528)) ? jsonObject3.get(a.d("\u8473\ufdca\u7708\ue96c", 616314835, -2131446839)).getAsString() : "")));
                }
            }
            return arrayList;
        });
    }

    public static CompletableFuture<byte[]> get(String string) {
        return eyn.eyv(() -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.b("\u9f47\ue6f8\u6c37", -1934909649), string);
            HttpRequest httpRequest = eyn.eyu(a.d("\ufd42\u84bd\u0e7f\u9017\u1b86\u9d76\u272e\uaecf\u3097\uba3b\u3da8\uc791\u4944\ud0e4", -771726234, -616392443), 120).header(a.c(-645149043, "\ucee2\ub75f\u3d8d\ua3e6\u2820\uae9a\u14d3\u9d7b\u037d\u89c1\u0e1b\uf47f"), a.d("\ud04b\ua9eb\u2338\ubd55\u3687\ub03c\u0a6d\u8389\u1dcb\u977c\u10ae\uea9e\u640c\ufda4\u77eb\uf11b", -563118819, 1153740071)).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            HttpResponse<byte[]> httpResponse = eyp.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (httpResponse.statusCode() != 200) {
                throw new IOException(a.c(1108902475, "\u8228\ufb9b\u7159\uef7c") + httpResponse.statusCode());
            }
            if (httpResponse.body().length > 0x2000000) {
                throw new IOException(a.c(-690311172, "\uaf81\ud62b\u5cf8\uc2c6\u495d\ucfe1\u75a1\ufc45\u6218"));
            }
            byte[] byArray = exn.openBytes(a.c(1441751894, "\u633e\u1a84\u9047\u0e31\u85fb\u031f") + string, httpResponse.body());
            if (byArray == null) {
                throw new IOException(a.b("\uc2a7\ubb00\u31d7\uafab\u2475\ua2c5", 1684521682));
            }
            return byArray;
        });
    }

    public static CompletableFuture<Boolean> put(String string, byte[] byArray, Map<String, String> map) {
        return eyn.eyv(() -> {
            byte[] byArray2 = exn.sealBytes(a.c(-1327433137, "\ufa27\u839d\u095e\u9728\u1ce2\u9a06") + string, byArray);
            if (byArray2 == null) {
                throw new IOException(a.b("\u4b32\u3295\ub842\u263e", 230771525));
            }
            HttpRequest httpRequest = eyn.eyu(a.d("\ua2e1\udb1e\u51dc\ucfb4\u4425\uc2d5\u788d\uf16c\u6f34\ue598\u620b\u9825\u16f7\u8f47\u055f\u83fa\u39bb\ub676\u2c81", -2110089013, -411026922) + URLEncoder.encode(string, StandardCharsets.UTF_8), 180).header(a.c(738725346, "\u0d8d\u7430\ufee2\u6089\ueb4f\u6df5\ud7bc\u5e14\uc012\u4aae\ucd74\u3710"), a.d("\u0df7\u7457\ufe84\u60e9\ueb3b\u6d80\ud7d1\u5e35\uc077\u4ac0\ucd12\u3722\ub9b5\u2008\uaa4c\u2cac\u96f2\u197a\u8397\u05c1\u8c30\uf676\u78c1\ue31c", -983470750, 1241276652)).header(a.b("\uab82\ud266\u58f5\uc68c\u4d4a\ucbee", 938191868), URLEncoder.encode(eyn.meta(map), StandardCharsets.UTF_8).replace(a.d("\u7ef3", 1518118432, -884352775), a.b("\u00ac\u790a\uf3db", 1299841162))).PUT(HttpRequest.BodyPublishers.ofByteArray(byArray2)).build();
            HttpResponse<String> httpResponse = eyp.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200) {
                throw new IOException(a.c(15853502, "\ue7ca\u9e7e\u14ac\u8a89") + httpResponse.statusCode() + a.b("\u5b21", 997219072) + httpResponse.body());
            }
            return true;
        });
    }

    public static CompletableFuture<Boolean> delete(Collection<String> collection, String string) {
        return eyn.eyv(() -> {
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
            jsonObject.add(a.d("\u60e5\u195a\u9395\u0dee", -374834285, -799466727), (JsonElement)jsonArray);
            if (string != null) {
                jsonObject.addProperty(a.d("\u6057\u19e4\u9320\u0d52\u868a*", -727031432, 538509657), string);
            }
            return eyp.send((HttpRequest)(object = eyn.eyu(a.b("\ua96d\ud092\u5a50\uc438\u4fa9\uc959\u7301\ufae0\u64b8\uee14\u6987\u93bd\u1d6b\u84d3", -920802996), 30).header(a.d("\uf570\u8ccd\u061f\u9874\u13b2\u9508\u2f41\ua6e9\u38ef\ub253\u3589\ucfed", 1347995745, 668614014), a.b("\ucef9\ub759\u3d8a\ua3e7\u2835\uae8e\u14df\u9d3b\u0379\u89ce\u0e1c\uf42c\u7abe\ue316\u6959\uefa9", 673894024)).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build()), HttpResponse.BodyHandlers.discarding()).statusCode() == 200;
        });
    }

    public static String meta(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(';');
                }
                stringBuilder.append(eyn.eyw(entry.getKey())).append('=').append(eyn.eyw(entry.getValue()));
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
        for (String string2 : string.split(a.d("\ub6ae", -126428214, 878603614))) {
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
        return eyn.mh(n, n2) ^ 0xB48E3FE5;
    }

    private static /* synthetic */ int mj(int n, int n2) {
        return n - n2 + 1374229131;
    }
}

