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

import a.LyricsParser;
import a.slp;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public final class TrackTitleCleaner {
    private static final int slt = 0x400000;
    private static final int slu = 48;
    private static final long slv = 20000L;
    private static final double slw = 15.0;
    private static final Pattern slx = Pattern.compile("\\s*[(\\[][^)\\]]*(official|video|audio|lyric|visuali[sz]er|music|clip|\u043a\u043b\u0438\u043f|\u043f\u0440\u0435\u043c\u044c\u0435\u0440|\\bhd\\b|\\b4k\\b|\\bmv\\b|m/v|remaster|prod\\.)[^)\\]]*[)\\]]", 258);
    private static final Pattern sly = Pattern.compile("\\s*[(\\[]?\\b(feat\\.?|ft\\.|featuring)\\s+[^)\\]]*[)\\]]?", 258);
    private static final Pattern slz = Pattern.compile("\\s*(,|&|;|/|\\bfeat\\.?|\\bft\\.)\\s*", 258);
    private static final ExecutorService sma = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "media-text");
        thread.setDaemon(true);
        return thread;
    });
    private static final Map<String, LyricsParser> smb = Collections.synchronizedMap(new slp(16, 0.75f, true));
    private static final Set<String> smc = ConcurrentHashMap.newKeySet();
    private static final Map<String, Long> smd = new ConcurrentHashMap<String, Long>();
    private static volatile HttpClient sme;
    private static /* synthetic */ long smf;
    private static /* synthetic */ String smg;

    private TrackTitleCleaner() {
    }

    public static LyricsParser get(String string, String string2, long l) {
        String string3 = string + '\u0001' + string2;
        LyricsParser sle2 = smb.get(string3);
        if (sle2 != null) {
            return sle2;
        }
        Long l2 = smd.get(string3);
        if (l2 != null && System.currentTimeMillis() < l2) {
            return null;
        }
        if (smc.add(string3)) {
            sma.execute(() -> {
                try {
                    smb.put(string3, TrackTitleCleaner.smh(string, string2, l));
                    smd.remove(string3);
                }
                catch (Throwable throwable) {
                    smd.put(string3, System.currentTimeMillis() + 20000L);
                }
                finally {
                    smc.remove(string3);
                }
            });
        }
        return null;
    }

    private static LyricsParser smh(String string, String string2, long l) throws IOException, InterruptedException {
        Object object;
        int n;
        String string3 = TrackTitleCleaner.cleanTitle(string);
        String string4 = TrackTitleCleaner.plainArtist(string2);
        String string5 = TrackTitleCleaner.cleanArtist(string2);
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        if (!string4.isEmpty()) {
            arrayList.add(new String[]{string3, string4});
        }
        if (!string5.isEmpty() && !string5.equals(string4)) {
            arrayList.add(new String[]{string3, string5});
        }
        if ((n = TrackTitleCleaner.sml(string3)) > 0) {
            object = TrackTitleCleaner.cleanArtist(string3.substring(0, n));
            String string6 = TrackTitleCleaner.cleanTitle(string3.substring(n + 3));
            if (!((String)object).isEmpty() && !string6.isEmpty()) {
                arrayList.add(new String[]{string6, object});
            }
        }
        arrayList.add(new String[]{string5.isEmpty() ? string3 : string3 + " " + string5, null});
        object = null;
        boolean bl = false;
        for (String[] stringArray : arrayList) {
            JsonArray jsonArray;
            try {
                jsonArray = TrackTitleCleaner.smi(stringArray[0], stringArray[1]);
                bl = true;
            }
            catch (IOException iOException) {
                object = iOException;
                continue;
            }
            LyricsParser sle2 = TrackTitleCleaner.smj(jsonArray, stringArray[1] != null ? stringArray[0] : string3, stringArray[1] != null ? stringArray[1] : string5, l);
            if (sle2 == null) continue;
            return sle2;
        }
        if (!bl && object != null) {
            throw object;
        }
        return LyricsParser.NONE;
    }

    private static JsonArray smi(String string, String string2) throws IOException, InterruptedException {
        String string3 = string2 != null ? "track_name=" + TrackTitleCleaner.smq(string) + "&artist_name=" + TrackTitleCleaner.smq(string2) : "q=" + TrackTitleCleaner.smq(string);
        URI uRI = URI.create(TrackTitleCleaner.smr() + "?" + string3);
        int n = 0;
        while (true) {
            byte[] byArray;
            HttpRequest httpRequest = HttpRequest.newBuilder(uRI).timeout(Duration.ofSeconds(12L)).header("accept", "application/json").GET().build();
            HttpResponse<InputStream> httpResponse = TrackTitleCleaner.sms().send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            try (InputStream inputStream = httpResponse.body();){
                byArray = inputStream.readNBytes(0x400000);
            }
            int n2 = httpResponse.statusCode();
            if (n2 == 200) {
                JsonElement jsonElement = JsonParser.parseString((String)new String(byArray, StandardCharsets.UTF_8));
                return jsonElement.isJsonArray() ? jsonElement.getAsJsonArray() : new JsonArray();
            }
            if (n2 == 404) {
                return new JsonArray();
            }
            if (n2 != 429 && n2 < 500 || n >= 3) {
                throw new IOException("status " + n2);
            }
            Thread.sleep(1500L * (long)(n + 1));
            ++n;
        }
    }

    private static LyricsParser smj(JsonArray jsonArray, String string, String string2, long l) {
        String string3 = TrackTitleCleaner.smm(string);
        String string4 = TrackTitleCleaner.smm(string2);
        double d = Double.MAX_VALUE;
        JsonObject jsonObject = null;
        for (JsonElement jsonElement : jsonArray) {
            if (!jsonElement.isJsonObject()) continue;
            JsonObject jsonObject2 = jsonElement.getAsJsonObject();
            boolean bl = TrackTitleCleaner.smo(jsonObject2, "instrumental");
            String string5 = TrackTitleCleaner.smn(jsonObject2, "syncedLyrics");
            if (!bl && string5.isBlank()) continue;
            double d2 = 0.0;
            double d3 = TrackTitleCleaner.smp(jsonObject2, "duration");
            if (l > 0L && d3 > 0.0) {
                double d4 = Math.abs(d3 - (double)l / 1000.0);
                if (d4 > 15.0) continue;
                d2 += d4;
            }
            d2 += TrackTitleCleaner.smk(string3, TrackTitleCleaner.smm(TrackTitleCleaner.smn(jsonObject2, "trackName")), 3.0, 9.0);
            if (!string4.isEmpty()) {
                d2 += TrackTitleCleaner.smk(string4, TrackTitleCleaner.smm(TrackTitleCleaner.smn(jsonObject2, "artistName")), 2.0, 7.0);
            }
            if (bl) {
                d2 += 4.0;
            }
            if (!(d2 < d)) continue;
            d = d2;
            jsonObject = jsonObject2;
        }
        if (jsonObject == null) {
            return null;
        }
        return TrackTitleCleaner.smo(jsonObject, "instrumental") ? LyricsParser.NONE : LyricsParser.parse(TrackTitleCleaner.smn(jsonObject, "syncedLyrics"));
    }

    private static double smk(String string, String string2, double d, double d2) {
        if (string.isEmpty() || string2.isEmpty()) {
            return d;
        }
        if (string.equals(string2)) {
            return 0.0;
        }
        return string.contains(string2) || string2.contains(string) ? d : d2;
    }

    static String cleanTitle(String string) {
        int n;
        String string2 = slx.matcher(string).replaceAll("");
        int n2 = (string2 = sly.matcher(string2).replaceAll("")).indexOf(" | ");
        if (n2 > 0) {
            string2 = string2.substring(0, n2);
        }
        if ((n = string2.indexOf(" #")) > 0) {
            string2 = string2.substring(0, n);
        }
        string2 = string2.replace('\u00ab', ' ').replace('\u00bb', ' ').replace('\"', ' ').replace('\u201c', ' ').replace('\u201d', ' ');
        return string2.replaceAll("\\s+", " ").trim();
    }

    static String plainArtist(String string) {
        return string.replaceAll("(?i)\\s*-\\s*topic$", "").replaceAll("(?i)vevo$", "").replaceAll("(?i)\\s*official$", "").trim();
    }

    static String cleanArtist(String string) {
        String[] stringArray;
        String string2 = TrackTitleCleaner.plainArtist(string);
        for (String string3 : stringArray = slz.split(string2)) {
            if (string3.isBlank()) continue;
            return string3.trim();
        }
        return string2;
    }

    private static int sml(String string) {
        for (String string2 : new String[]{" - ", " \u2013 ", " \u2014 "}) {
            int n = string.indexOf(string2);
            if (n <= 0) continue;
            return n;
        }
        return -1;
    }

    private static String smm(String string) {
        int n;
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        String string2 = string.toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
        for (int i = 0; i < string2.length(); i += Character.charCount(n)) {
            n = string2.codePointAt(i);
            if (!Character.isLetterOrDigit(n)) continue;
            stringBuilder.appendCodePoint(n);
        }
        return stringBuilder.toString();
    }

    private static String smn(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement == null || jsonElement.isJsonNull() ? "" : jsonElement.getAsString();
    }

    private static boolean smo(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement != null && !jsonElement.isJsonNull() && jsonElement.getAsBoolean();
    }

    private static double smp(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        try {
            return jsonElement == null || jsonElement.isJsonNull() ? 0.0 : jsonElement.getAsDouble();
        }
        catch (RuntimeException runtimeException) {
            return 0.0;
        }
    }

    private static String smq(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

    private static String smr() {
        return new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'l', 'r', 'c', 'l', 'i', 'b', '.', 'n', 'e', 't', '/', 'a', 'p', 'i', '/', 's', 'e', 'a', 'r', 'c', 'h'});
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static HttpClient sms() {
        HttpClient httpClient = sme;
        if (httpClient != null) return httpClient;
        Class<TrackTitleCleaner> clazz = TrackTitleCleaner.class;
        synchronized (TrackTitleCleaner.class) {
            httpClient = sme;
            if (httpClient != null) return httpClient;
            sme = httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).followRedirects(HttpClient.Redirect.NORMAL).build();
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return httpClient;
        }
    }

    private static /* synthetic */ int cet(int n, int n2) {
        return n * n2 ^ 0x129B3E51;
    }
}

