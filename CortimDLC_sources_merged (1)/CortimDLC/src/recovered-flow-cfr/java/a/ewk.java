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
import a.exn;
import a.eya;
import a.izx;
import a.vhz;
import a.wap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
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

public final class ewk {
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

    private ewk() {
    }

    private static String exe() {
        String string = LoaderInfo.api();
        if (string == null || string.isBlank()) {
            return ewl;
        }
        return (string = string.trim()).endsWith(a.c(-1959158928, "\u9b5e")) ? string.substring(0, string.length() - 1) : string;
    }

    static String endpoint() {
        return ewk.exe();
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
            Thread thread = new Thread(runnable, a.d("\u3469\u4df2\uc722\u594b\ud2d9\u547a\uee6a\u6794\uf9c8\u7363\uf4a1", -288422410, 846541266));
            thread.setDaemon(true);
            return thread;
        });
        ewy.execute(ewk::exf);
        LocalState.init();
    }

    public static boolean online() {
        return ewv;
    }

    public static void ensureLoaded() {
        if (!ewu) {
            ewk.init();
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
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(ewk.exe() + a.b("\ue7d6\u9e29\u14eb\u8a83\u0112\u87e8\u3dbe\ub45a\u2a10\ua0ef\u2763\udd17\u53d9\uca68", 1851647991))).timeout(Duration.ofSeconds(8L)).header(a.d("\uebad\u9208\u18da\u86b7\u0d67\u8bcb\u3183\ub861\u2625\uac81\u2b4f\ud138\u5fee", 1754081090, -1202926461), a.d("\u63b6\u1a20\u90f7\u0e95\u8555\u03f3\ub9f2", -921926319, -889002334) + LoaderInfo.token()).header(a.b("\uff69\u86d4\u0c06\u926d\u19ab\u9f11\u2558\uacf0\u32f6\ub84a\u3f90\uc5f4", 881327878), a.d("\u52ab\u2b0b\ua1d8\u3fb5\ub467\u32dc\u888d\u0169\u9f2b\u159c\u924e\u687e\ue6ec\u7f44\uf50b\u73fb", -1721122490, -426077284)).header(a.b("\ub977\uc093\u4a05\ud46b\u5fa2\ud91e", 66697481), eya.get()).POST(HttpRequest.BodyPublishers.ofString(a.b("\ufc73\u85c4", 1139145738))).build();
            HttpResponse<byte[]> httpResponse = ewx.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            if (httpResponse.statusCode() != 200) {
                ewk.exm(httpResponse.statusCode());
                return;
            }
            if (httpResponse.body().length > 0x800000) {
                return;
            }
            JsonObject jsonObject = JsonParser.parseString((String)new String(httpResponse.body(), StandardCharsets.UTF_8)).getAsJsonObject();
            if (jsonObject.has(a.b("\ub6ac\ucf02\u45d2\udbb8\u5068", -1280657702)) && jsonObject.get(a.c(431515312, "\u66c6\u1f68\u95b8\u0bd2\u8002")).isJsonObject()) {
                for (Map.Entry entry : jsonObject.getAsJsonObject(a.d("\ucbb0\ub21e\u38ce\ua6a4\u2d74", 1197382561, 719933543)).entrySet()) {
                    if (!((JsonElement)entry.getValue()).isJsonPrimitive() || ewk.exg((String)entry.getKey()) || (object = exn.open(a.c(439022201, "\uf20f\u8ba1\u0171\u9f1b\u1482") + (String)entry.getKey(), ((JsonElement)entry.getValue()).getAsString())) == null) continue;
                    ewo.put((String)entry.getKey(), (String)object);
                }
            }
            if (jsonObject.has(a.c(-1185447159, "\u836d\ufad0\u7002\uee7b\u65a3\ue31c\u595b")) && jsonObject.get(a.b("\u2075\u59c8\ud31a\u4d63\uc6bb\u4004\ufa43", 1419386897)).isJsonObject()) {
                for (Map.Entry entry : jsonObject.getAsJsonObject(a.c(-184772066, "\u9a7a\ue3c7\u6915\uf76c\u7cb4\ufa0b\u404c")).entrySet()) {
                    if (ewk.exh((String)entry.getKey()) || !((JsonElement)entry.getValue()).isJsonObject()) continue;
                    object = ((JsonElement)entry.getValue()).getAsJsonObject();
                    String string = exn.open(a.d("\uf423\u8d9e\u074c\u9935\u12ed\u9452\u2e5c", 1316211507, 373047156) + (String)entry.getKey(), object.has(a.d("\ue3a5\u9a11\u10d7\u8eb3", 1694103458, 127603815)) ? object.get(a.c(-1629606079, "\u2f21\u5695\udc53\u4237")).getAsString() : "");
                    if (string == null) continue;
                    ewp.put((String)entry.getKey(), new evy(string, object.has(a.d("\u1e3e\u6784\ued58\u732a\uf8f3\u7e4b\uc419", 1226093598, 1498327618)) ? object.get(a.c(-910560547, "\uf2bf\u8b05\u01d9\u9fab\u1472\u92ca\u2898")).getAsInt() : 0, object.has(a.d("\ueb93\u9220\u18f8\u8698\u0d56\u8bee\u31ab", -1812808388, 1433294533)) ? object.get(a.b("\u197f\u60cc\uea14\u7474\uffba\u7902\uc347", 1739528469)).getAsInt() : 0, object.has(a.b("\u047e\u7dca\uf70d\u6979\ue2bb\u641b\ude49", -22281204)) ? object.get(a.c(-1275027440, "\ua062\ud9d6\u5311\ucd65\u46a7\uc007\u7a55")).getAsLong() : 0L));
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
        ewk.ensureLoaded();
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
            ewk.exi();
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
            String string3 = exn.seal(a.d("\u82c7\ufb69\u71b9\uefd3\u644a", -1074421833, -1157620474) + string, string2);
            if (string3 == null) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(string, string3);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(a.c(-875142907, "\u6173\u18dd\u920d\u0c67\u87b7"), (JsonElement)jsonObject);
            try {
                HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(ewk.exe() + a.c(-92669599, "\uf940\u80bf\u0a7d\u9415\u1f84\u997e\u2328\uaacc\u3486\ube79\u39f5\uc381\u4d50\ud4fa"))).timeout(Duration.ofSeconds(20L)).header(a.d("\uaf29\ud68c\u5c5e\uc233\u49e3\ucf4f\u7507\ufce5\u62a1\ue805\u6fcb\u95bc\u1b6a", 1962397008, 374694421), a.b("\u2a3b\u53ad\ud97a\u4718\uccd8\u4a7e\uf07f", 960375422) + LoaderInfo.token()).header(a.c(-329410554, "\u9869\ue1d4\u6b06\uf56d\u7eab\uf811\u4258\ucbf0\u55f6\udf4a\u5890\ua2f4"), a.c(623456749, "\u319c\u483c\uc2ef\u5c82\ud750\u51eb\uebba\u625e\ufc1c\u76ab\uf179\u0b49\u85db\u1c73\u963c\u10cc")).header(a.d("\ua24f\udbab\u513d\ucf53\u449a\uc226", 515674112, -1723321807), eya.get()).POST(HttpRequest.BodyPublishers.ofString(jsonObject2.toString(), StandardCharsets.UTF_8)).build();
                ewk.exm(ewx.send(httpRequest, HttpResponse.BodyHandlers.discarding()).statusCode());
            }
            catch (Exception exception) {
                // empty catch block
            }
        });
        LocalState.save();
    }

    public static long sizeOf(String string) {
        ewk.ensureLoaded();
        long l = 0L;
        for (Map.Entry<String, String> entry : ewo.entrySet()) {
            if (!entry.getKey().startsWith(string)) continue;
            l += (long)entry.getValue().length();
        }
        return l;
    }

    public static byte[] getBytes(String string) {
        String string2 = ewk.get(string);
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
        ewk.put(string, Base64.getEncoder().encodeToString(byArray));
    }

    public static Set<String> configNames() {
        ewk.ensureLoaded();
        return new TreeSet<String>(ewp.keySet());
    }

    public static Map<String, evy> configs() {
        ewk.ensureLoaded();
        return Map.copyOf(ewp);
    }

    public static boolean hasConfig(String string) {
        ewk.ensureLoaded();
        return string != null && ewp.containsKey(string);
    }

    public static String getConfig(String string) {
        ewk.ensureLoaded();
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
            ewk.exi();
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
            ewk.exi();
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
            ewk.exi();
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
        ewz = ewy.schedule(ewk::exj, 1500L, TimeUnit.MILLISECONDS);
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
            jsonObject = ewk.exl();
            ewq.clear();
            ewr.clear();
            ews.clear();
        }
        try {
            object = HttpRequest.newBuilder(URI.create(ewk.exe() + a.c(895331111, "\uab06\ud2f9\u583b\uc653\u4dc2\ucb38\u716e\uf88a\u66c0\uec3f\u6bb3\u91c7\u1f16\u86bc"))).timeout(Duration.ofSeconds(10L)).header(a.d("\u4dfb\u345e\ube8c\u20e1\uab31\u2d9d\u97d5\u1e37\u8073\u0ad7\u8d19\u776e\uf9b8", 348207528, -1436715969), a.c(-1442955409, "\u3f2a\u46bc\ucc6b\u5209\ud9c9\u5f6f\ue56e") + LoaderInfo.token()).header(a.d("\u553d\u2c80\ua652\u3839\ub3ff\u3545\u8f0c\u06a4\u98a2\u121e\u95c4\u6fa0", 1456105416, 1540960922), a.c(-1772307896, "\uba39\uc399\u494a\ud727\u5cf5\uda4e\u601f\ue9fb\u77b9\ufd0e\u7adc\u80ec\u0e7e\u97d6\u1d99\u9b69")).header(a.b("\ub402\ucde6\u4770\ud91e\u52d7\ud46b", -1012747140), eya.get()).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
            HttpResponse<String> httpResponse = ewx.send((HttpRequest)object, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200) {
                ewk.exm(httpResponse.statusCode());
                ewk.exk(jsonObject);
            }
        }
        catch (Exception exception) {
            ewk.exk(jsonObject);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void exk(JsonObject jsonObject) {
        Object object = ewt;
        synchronized (object) {
            if (jsonObject.has(a.c(1113055403, "\ue0dd\u9973\u13a3\u8dc9\u0619"))) {
                ewq.addAll(jsonObject.getAsJsonObject(a.c(-83611927, "\u2e9f\u5731\udde1\u438b\uc85b")).keySet());
            }
            if (jsonObject.has(a.d("\ud730\uae8d\u245f\uba26\u31fe\ub741\u0d06", -773624455, -591939027))) {
                ewr.addAll(jsonObject.getAsJsonObject(a.c(582933155, "\udac7\ua37a\u29a8\ub7d1\u3c09\ubab6\u00f1")).keySet());
            }
            if (jsonObject.has(a.c(-645409145, "\ud6e9\uaf59\u2583\ubbdd\u3026\ub696\u0ccd\u8533\u1b62\u91c7"))) {
                jsonObject.getAsJsonArray(a.c(1879308360, "\uf826\u8196\u0b4c\u9512\u1ee9\u9859\u2202\uabfc\u35ad\ubf08")).forEach(jsonElement -> ews.add(jsonElement.getAsString()));
            }
        }
    }

    private static JsonObject exl() {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        for (String object2 : ewq) {
            String string;
            String string2 = ewo.get(object2);
            if (string2 == null || (string = exn.seal(a.c(-546090694, "\u514c\u28e2\ua232\u3c58\ub7c1") + object2, string2)) == null) continue;
            jsonObject2.addProperty(object2, string);
        }
        if (jsonObject2.size() > 0) {
            jsonObject.add(a.b("\uf007\u89a9\u0379\u9d13\u16c3", 931917937), (JsonElement)jsonObject2);
        }
        JsonObject jsonObject3 = new JsonObject();
        for (String string : ewr) {
            String string3;
            evy evy2 = ewp.get(string);
            if (evy2 == null || (string3 = exn.seal(a.c(-236845419, "\u06f1\u7f4c\uf59e\u6be7\ue03f\u6680\udc8e") + string, evy2.data())) == null) continue;
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty(a.c(1716571219, "\ucc33\ub587\u3f41\ua125"), string3);
            jsonObject4.addProperty(a.d("\u5d49\u24f3\uae2f\u305d\ubb84\u3d3c\u876e", 1958396343, 1536662684), (Number)evy2.enabled());
            jsonObject4.addProperty(a.d("\u0f76\u76c5\ufc1d\u627d\ue9b3\u6f0b\ud54e", 31516459, 740026423), (Number)evy2.modules());
            jsonObject3.add(string, (JsonElement)jsonObject4);
        }
        if (jsonObject3.size() > 0) {
            jsonObject.add(a.b("\ue2ad\u9b10\u11c2\u8fbb\u0463\u82dc\u389b", -305929527), (JsonElement)jsonObject3);
        }
        if (!ews.isEmpty()) {
            JsonArray jsonArray = new JsonArray();
            for (String string : ews) {
                jsonArray.add(string);
            }
            jsonObject.add(a.b("\ub2f7\ucb47\u419d\udfc3\u5438\ud288\u68d3\ue12d\u7f7c\uf5d9", 549368473), (JsonElement)jsonArray);
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
            String string = n == 403 ? wap.s(a.b("\u7746\u0ee8\u8425\u1a59\u91ea\u1716\uad41\u24aa\ubaeb\u3056\ub790\u4df6\uc32a\u5ad3\uf0b4\u5671\uec6c\u63aa\uf90f\u7f48\uf6ae\u8cab\u0270\u99be\u1fdf\u9503\u2cd4\ua2cc\u383c\ube23\u35d2\ucb0e\u415a", 1795585839), a.b("\uc655\ubffb\u3536\uab4a\u20f9\ua255\u180e\u95ea\u0fd4\u851a\u02c5\uf8b9\u7661\uefdb\u6193\uc756\u5d2d\ud69d\u4c5e\uca7e\u43f7\u39d9\ub767\u28da\uaab7\u2474\u99d6\u1788\u8d03\u0b25", -1684617725)) : wap.s(a.c(1076843101, "\u5220\u2b86\ua11d\u3f2d\ub4f9\u3240\u881d\u01eb\u9ffa\u1505\u92dd\u68ac\ue67a\u7fca\uf598"), a.d("\ua15d\ud8e6\u5240\ucc44\u4791\uc127\u7b7d\uf281\u6cd2\ue27b\u61ba\u9fd9\u1515\u8ca1\u06fc\u8009\u3a47\ub5e3", 772717351, 1579097687));
            izx.alert(wap.s(a.c(925850643, "\u5c55\u25cb\uaf1b\u3170\ubab6"), a.c(-1033315770, "\ude5e\ua7c0\u2d19\ub363\u38be\ube0b")), string, vhz.MISC, false);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static CompletableFuture<ewf> call(String string, JsonObject jsonObject) {
        if (!ewu) {
            ewk.init();
        }
        if (!ewv || ewy == null) {
            return CompletableFuture.failedFuture(new IOException(a.d("\u0e31\u7789\ufd5a\u6321\ue8f3\u6e45\ud41d", 1008244733, -300639836)));
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                JsonObject jsonObject2;
                HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(ewk.exe() + string)).timeout(Duration.ofSeconds(10L)).header(a.d("\ud86c\ua1c9\u2b1b\ub576\u3ea6\ub80a\u0242\u8ba0\u15e4\u9f40\u188e\ue2f9\u6c2f", 1301689201, 240184177), a.b("\u4eed\u377b\ubdac\u23ce\ua80e\u2ea8\u94a9", -1080013144) + LoaderInfo.token()).header(a.d("\u0282\u7b3f\uf1ed\u6f86\ue440\u62fa\ud8b3\u511b\ucf1d\u45a1\uc27b\u381f", 218058370, -1695658897), a.b("\u26c1\u5f61\ud5b2\u4bdf\uc00d\u46b6\ufce7\u7503\ueb41\u61f6\ue624\u1c14\u9286\u0b2e\u8161\u0791", 1849304752)).header(a.d("\uf1bd\u8859\u02cf\u9ca1\u1768\u91d4", -998770625, 1189743100), eya.get()).POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString(), StandardCharsets.UTF_8)).build();
                HttpResponse<byte[]> httpResponse = ewx.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
                ewk.exm(httpResponse.statusCode());
                if (httpResponse.body().length > 0x200000) {
                    throw new IOException(a.b("\u5c07\u25ad\uaf7e\u3140\ubadb\u3c67\u8627\u0fc3\u919e", -1018012550));
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
        ewk.exj();
        LocalState.save();
    }

    static {
        eww = new CountDownLatch(1);
    }

    private static /* synthetic */ int ls(int n, int n2) {
        return n - n2 | 0x7AFA7243;
    }
}

